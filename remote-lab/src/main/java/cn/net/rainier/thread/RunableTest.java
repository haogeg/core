package cn.net.rainier.thread;/**
 * Description: remote-lab
 * <p>
 * Created by Admin on 2020/10/23 9:06
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: remote-lab
 *
 * @description:
 *
 * @author: jinhao
 *
 * @create: 2020-10-23 09:06
 **/
public class RunableTest implements Runnable{

    private List list = new ArrayList();;

    private int count = 0;

    @Override
    public void run() {
//        Random random = new Random();
//        list.add(random);
        count++;

    }



    public static void main(String[] args) {
        int count = 0;
        Long time = System.currentTimeMillis();
        System.out.println(time);
        for (int i = 0; i < 50000; i++) {
            Thread thread = new Thread(new RunableTest());
            thread.start();
        }
        System.out.println(System.currentTimeMillis()-time);
        System.out.println("count:"+count);
    }
}
