package com.joker.restful.FTP;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author huangsy
 * @date 2018/4/8 15:42
 */
public class FtpUtils {
    private String username;
    private String password;
    private String ftpHostName;
    private int port = 21;
    private FTPClient ftpClient = new FTPClient();
    private FileOutputStream fos = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtils.class);


    public FtpUtils(String username, String password, String ftpHostName, int port) {
        this.username = username;
        this.password = password;
        this.ftpHostName = ftpHostName;
        this.port = port;
    }

    /**
     * 建立连接
     */
    private void connect() throws IOException {
        try {
            LOGGER.debug("start connect!");
            ftpClient.enterLocalPassiveMode();
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(ftpHostName, port);
            ftpClient.setSoTimeout(600000);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                LOGGER.error("FTP server refused connection.");
            }

            boolean isLoginSuccessful = ftpClient.login(username, password);

            if (!isLoginSuccessful){
                throw new IOException("login failed" + " ftp server info ftpHostName:" + ftpHostName + ", user:" + username + ", password:" + password);
            }

            ftpClient.setBufferSize(256);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            LOGGER.debug("login success!");
        } catch (IOException e) {
            LOGGER.error("connect failure!", e);
            throw e;
        }


    }


    /**
     * 关闭输入输出流
     *
     * @param fos
     */
    private void close(FileOutputStream fos) throws IOException {
        try {
            if (fos != null) {
                fos.close();
            }

            disconnect(ftpClient);
        } catch (IOException e) {
            LOGGER.error("close connect failure!", e);
            disconnect(ftpClient);
            throw e;
        }
    }


    /**
     * 下载文件夹
     *
     * @param ftpFileName
     * @param localDir
     */
    public void downloadDir(String ftpFileName, String localDir) throws Exception {
        connect();
        downFileOrDir(ftpFileName, localDir);
        close(fos);
    }

    public void getFileList(String ftpFileName) throws Exception {
        connect();
        fileList(ftpFileName);
        close(fos);
    }

    private void fileList(String ftpFileName) throws IOException {
        try {
            // 判断是否是目录
            if (isDir(ftpFileName)) {
                String[] names = ftpClient.listNames();
                for (int i = 0; i < names.length; i++) {
                    LOGGER.info("file name is {}", names[i]);
                    if (isDir(names[i])) {
                        fileList(ftpFileName + '/' + names[i]);
                        ftpClient.changeToParentDirectory();
                    }
                }
            }
            LOGGER.info("get filr name success!");
        } catch (IOException e) {
            LOGGER.error("get filr name failure!", e);
            close(fos);
            throw e;
        }
    }

    private void downFileOrDir(String ftpFileName, String localDir) throws IOException {
        try {
            File file = new File(ftpFileName);
            File temp = new File(localDir);
            if (!temp.exists()) {
                temp.mkdirs();
            }
            // 判断是否是目录
            if (isDir(ftpFileName)) {
                String[] names = ftpClient.listNames();
                for (int i = 0; i < names.length; i++) {
                    LOGGER.info("download file ,file name is {}", names[i]);
                    if (isDir(names[i])) {
                        downFileOrDir(ftpFileName + '/' + names[i], localDir
                                + File.separator + names[i]);
                        ftpClient.changeToParentDirectory();
                    } else {
                        File localfile = new File(localDir + File.separator + names[i]);
                        if (!localfile.exists()) {
                            fos = new FileOutputStream(localfile);
                            ftpClient.retrieveFile(names[i], fos);
                        } else {
                            LOGGER.debug("start delete file!");
                            file.delete();
                            fos = new FileOutputStream(localfile);
                            ftpClient.retrieveFile(ftpFileName, fos);
                        }
                    }
                }
            } else {
                File localfile = new File(localDir + File.separator
                        + file.getName());
                if (!localfile.exists()) {
                    fos = new FileOutputStream(localfile);
                    ftpClient.retrieveFile(ftpFileName, fos);
                } else {
                    LOGGER.debug("start delete file");
                    file.delete();
                    fos = new FileOutputStream(localfile);
                    ftpClient.retrieveFile(ftpFileName, fos);
                }
                ftpClient.changeToParentDirectory();
            }
            LOGGER.info("download success!");
        } catch (IOException e) {
            LOGGER.error("download failure!", e);
            close(fos);
            throw e;
        }
    }


    // 判断是否是目录
    public boolean isDir(String fileName) {
        boolean falg = false;
        try {
            // 切换目录，若当前是目录则返回true,否则返回true。
            falg = ftpClient.changeWorkingDirectory(fileName);
        } catch (Exception e) {
            LOGGER.error("change working directory failure!", e);
        }
        return falg;
    }

    private boolean disconnect(FTPClient ftpClient) {
        boolean b = false;
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                this.logout(ftpClient);
                ftpClient.disconnect();
                b = true;
            }
        } catch (IOException e) {
            b = false;
            LOGGER.error("ftp disconnect error",e);
        }
        return b;
    }

    private boolean logout(FTPClient ftpClient) throws IOException {
        boolean b = false;
        try {
            b = ftpClient.logout();
        } catch (IOException e) {
            throw e;
        }
        return b;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFtpHostName() {
        return ftpHostName;
    }
    public void setFtpHostName(String ftpHostName) {
        this.ftpHostName = ftpHostName;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
