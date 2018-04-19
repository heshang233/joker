package com.joker.restful.api.impl;

import com.joker.restful.api.UserService;
import com.joker.restful.dto.FasterXmlDTO;
import com.joker.restful.dto.TestDTO;
import com.joker.restful.holder.TestHolder;
import com.joker.restful.util.*;
import com.joker.restful.word.RandomSentenceGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author huangsy
 * @date 2018/1/27 13:05
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String get() {
        return "hello world";
    }

    @Override
    public TestDTO postStr(TestDTO testDTO) {
        return testDTO;
    }

    private static Set<String> uuids = new HashSet<>();


    @Override
    public Set<String> xml(String uuid) {
        Random random = new Random();
        if (StringUtils.isEmpty(uuid)){
            uuids.add("urn:uuid:b"+random.nextInt(10)+"8e"+random.nextInt(10)+"61"+random.nextInt(10)+
                    "-2"+random.nextInt(10)+"9b-"+random.nextInt(10)+"a"+random.nextInt(10)+"0-"+random.nextInt(10)+
                    "d5"+random.nextInt(10)+"-aa9"+random.nextInt(10)+"c1b33ea"+random.nextInt(10));
        }else {
            uuids.add("urn:uuid:"+uuid);
        }
        return uuids;
    }

    @Override
    public FasterXmlDTO getxml() {
        FasterXmlDTO fasterXmlDTO = new FasterXmlDTO();
        fasterXmlDTO.setI1(2121);
        fasterXmlDTO.setA1("123");
        fasterXmlDTO.setA2("223");
        fasterXmlDTO.setA3("323");
        FasterXmlDTO fasterXmlDTO1 = new FasterXmlDTO();
        fasterXmlDTO1.setA1("123");
        fasterXmlDTO1.setA2("223");
        fasterXmlDTO1.setA3("323");
        FasterXmlDTO fasterXmlDTO2 = new FasterXmlDTO();
        fasterXmlDTO2.setA1("123");
        fasterXmlDTO2.setA2("223");
        fasterXmlDTO2.setA3("323");
        FasterXmlDTO fasterXmlDTO3 = new FasterXmlDTO();
        fasterXmlDTO3.setA1("123");
        fasterXmlDTO3.setA2("223");
        fasterXmlDTO3.setA3("323");

//        fasterXmlDTO.setF1(fasterXmlDTO1);
        List<FasterXmlDTO> fasterXmlDTOS = new ArrayList<>();
        fasterXmlDTOS.add(fasterXmlDTO2);
        fasterXmlDTOS.add(fasterXmlDTO3);

        fasterXmlDTO.setL1(fasterXmlDTOS);
        return fasterXmlDTO;
    }

    @Override
    public String testHolder(String message) {
        String enabled = TestHolder.isEnabled();
        System.out.println("=============holder boolean:"+enabled);
        TestHolder.disable(message);
        System.out.println("=============holder disable");
        TestHolder.remove();
        return enabled;
    }

    @Override
    public FilmListResultDTO GetFilmList(GetFilmListRequestDTO dto) {
        System.out.println(dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getReportDate());

        FilmListResultDTO filmListResultDTO = new FilmListResultDTO();
        FilmListDTO filmListDTO = new FilmListDTO();

        List<FilmInfoSimpleDTO> filmInfoDTOS = new ArrayList<>();

        uuids.forEach(uuid->{
            FilmInfoSimpleDTO filmInfoDTO = new FilmInfoSimpleDTO();
            filmInfoDTO.setName("鸿海行动1");
            filmInfoDTO.setUuid(uuid);
            filmInfoDTOS.add(filmInfoDTO);
        });


        filmListDTO.setFilmCount(uuids.size());
        filmListDTO.setFilmInfos(filmInfoDTOS);
        filmListResultDTO.setStatus(0);
        filmListResultDTO.setFilmListDTO(filmListDTO);
        return filmListResultDTO;
    }

    @Override
    public FilmInfoResultDTO GetFilmInfo(GetFilmInfoRequestDTO dto) {
        System.out.println(dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getReportDate());
        System.out.println(dto.getUuid());
        FilmInfoResultDTO filmInfoResultDTO = new FilmInfoResultDTO();
        filmInfoResultDTO.setStatus(0);

        FilmInfoDTO filmInfoDTO1 = new FilmInfoDTO();
        filmInfoDTO1.setAdminId("1234567890123");
        filmInfoDTO1.setDuration(9000L);
        String[] countryCodes={"CN", "GB", "FR", "US" ,"UG", "JP"};
        filmInfoDTO1.setPlace(countryCodes[(int) (Math.random() * 6)]);
        filmInfoDTO1.setUuid(dto.getUuid());

        MultilingualListDTO multilingualListDTO = new MultilingualListDTO();

        Integer[] languageCounts = {1,2,3};

        Integer languageCount = languageCounts[(int) (Math.random() * 3)];

        multilingualListDTO.setLanguageCount(languageCount);

        Set<String> languageCodes = new HashSet<>();
        languageCodes.add("eng");
        languageCodes.add("swa");
        languageCodes.add("pro");

        List<MultilingualDTO> multilingualDTOS = new ArrayList<>();
        RandomSentenceGenerator rsgen = new RandomSentenceGenerator();

        for (String languageCode : languageCodes) {
            if (!languageCount.equals(multilingualDTOS.size())){
                MultilingualDTO multilingualDTO1 = new MultilingualDTO();
                multilingualDTO1.setActor(rsgen.getRandomSentence("<NN> <NNS>"));
                multilingualDTO1.setDescription(rsgen.getRandomSentence("<JJ> <NNS> <BED> <NNS> <JJ> <BED> ."));
                multilingualDTO1.setDirector(rsgen.getRandomSentence("<NN> <NNS>"));
                multilingualDTO1.setLanguageCode(languageCode);
                multilingualDTO1.setName(rsgen.getRandomSentence("<JJ> <NN>"));
                multilingualDTO1.setType(rsgen.getRandomSentence("<NN>"));
                multilingualDTOS.add(multilingualDTO1);
            }
        }
        multilingualListDTO.setMultilingualDTO(multilingualDTOS);
        filmInfoDTO1.setMultilingualListDTO(multilingualListDTO);
        filmInfoResultDTO.setFilmInfoDTO(filmInfoDTO1);

        return filmInfoResultDTO;
    }

    @Override
    public FilmFtpResultDTO GetFilmDCP(GetFilmFtpRequestDTO dto) throws Exception {
        System.out.println(dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getReportDate());
        System.out.println(dto.getUuid());

        FilmFtpResultDTO filmFtpResultDTO = new FilmFtpResultDTO();

        filmFtpResultDTO.setStatus(0);

        FilmFtpDTO filmFtpDTO = new FilmFtpDTO();
        filmFtpDTO.setAdminId("1312332");
        /*filmFtpDTO.setFtpPath("ftp://47.104.15.183/home/ftptest/honghaixindong");
        filmFtpDTO.setFtpPsw("ftptest123");
        filmFtpDTO.setFtpUser("ftptest");*/
        filmFtpDTO.setFtpPath("ftp://10.0.251.141/root/song/duoyuyan-lang-lamda2");
        filmFtpDTO.setFtpPsw("123456");
        filmFtpDTO.setFtpUser("root");

        filmFtpDTO.setName("asdasd2");
        filmFtpDTO.setUuid("dasdasd2");

//        FtpUtils ftpUtils = new FtpUtils("ftptest", "ftptest123", "47.104.15.183", 21);
//        ftpUtils.getFileList("/home/ftptest/honghaixindong");
        filmFtpResultDTO.setFilmFtpDTO(filmFtpDTO);
        return filmFtpResultDTO;
    }

}
