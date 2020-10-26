package cn.net.rainier.thread;/**
 * Description: remote-lab
 * <p>
 * Created by Admin on 2020/10/23 9:06
 */

import java.sql.Time;
import java.sql.Timestamp;
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
public class ThreadTest extends Thread{

    private List list = new ArrayList();;

    @Override
    public void run() {
        Random random = new Random();
        list.add(random);

    }

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        System.out.println(time);
        for (int i = 0; i < 50000; i++) {
            Thread thread = new Thread(new ThreadTest());
            thread.start();
        }
        System.out.println(System.currentTimeMillis()-time);
    }
}
