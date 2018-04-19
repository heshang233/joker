package com.joker.restful.forkjoin;

import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author huangsy
 * @date 2018/4/11 18:18
 */
public class ForkJoinTaskExample extends RecursiveAction{

    private String uuid;

    private List<String> uuids;

    public ForkJoinTaskExample(String uuid, List<String> uuids){
        this.uuids = uuids;
        this.uuid = uuid;
    }

    @Override
    protected void compute() {
        /*boolean canCompute = (end -start)<=1;
        System.out.println("canCompute:"+canCompute+" start:"+start+" end:"+end);
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                try {
                    Thread.sleep(1000L);
                    if (end == 21 ){
                        throw new Exception("ssasasassss");
                    }
                } catch (Exception e) {
                    System.out.println("========task run error=========,"+uuids.get(i)+"=====,"+ Instant.now());
                }
                System.out.println("========task run=========,"+uuids.get(i)+"=====,"+ Instant.now());
            }
        } else {
            int middle = (start + end)/2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start,middle,this.uuids);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle+1,end,this.uuids);

            invokeAll(leftTask,rightTask);

        }*/

        if (StringUtils.isEmpty(uuid)){
            List<ForkJoinTaskExample> forkJoinTaskExamples = new ArrayList<>();
            for (String s : uuids) {
                ForkJoinTaskExample taskExample = new ForkJoinTaskExample(s,uuids);
                forkJoinTaskExamples.add(taskExample);
            }
            invokeAll(forkJoinTaskExamples);
        }else {
            try {
                Thread.sleep(1000L);
                System.out.println("========task run error=========,"+uuid+"=====,"+ Instant.now());
            } catch (Exception e) {
                System.out.println("========task run error=========,"+uuid+"=====,"+ Instant.now());
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Instant now = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            uuids.add("test"+i);
        }
        ForkJoinTaskExample taskExample = new ForkJoinTaskExample(null, uuids);

        forkJoinPool.invoke(taskExample);
        System.out.println("======="+(Instant.now().getEpochSecond()-now.getEpochSecond()));

    }
}
