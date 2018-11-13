package com.example.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringTokenizer;

/**
 * 类描述：
 *
 * @author Weway-RG001
 * @date 2018-11-08 18:14
 */
public class TempTest {
    private static String sample = "https://wx.vibeac.com/bizcardServer/openapi/card/share/getShareImgCallBack?cardId=5b15ee7a344f1f1b2bf8ae0b&userId=5b15ee4a344f1f18ddfde99e&cardType=online&offlineShareForReceive=";
    private static Logger log = LoggerFactory.getLogger(TempTest.class);

    @Test
    public void test() {
        System.out.println(byRegEx()[0]);
        System.out.println(byTokenizer().nextToken());
        System.out.println(bySplit()[0]);
        System.out.println(bySubString());
        repeatTest(1000000);
    }

    private String[] byRegEx() {
        String[] urlString = sample.split("[?]");
        return urlString;
    }

    private StringTokenizer byTokenizer() {
        return new StringTokenizer(sample, "?");
    }

    private String[] bySplit() {
        return sample.split("[?]");
    }

    private String bySubString() {
        return sample.substring(0, sample.indexOf('?'));
    }

    private void repeatTest(int repeat) {
        long begin, end;
        begin = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            byRegEx();
        }
        end = System.nanoTime();
        log.info("耗时：{}毫秒 - {}", (end - begin) / 1000000, "byRegEx");

        begin = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            bySplit();
        }
        end = System.nanoTime();
        log.info("耗时：{}毫秒 - {}", (end - begin) / 1000000, "bySplit");

        begin = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            bySubString();
        }
        end = System.nanoTime();
        log.info("耗时：{}毫秒 - {}", (end - begin) / 1000000, "bySubString");

        begin = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            byTokenizer();
        }
        end = System.nanoTime();
        log.info("耗时：{}毫秒 - {}", (end - begin) / 1000000, "byTokenizer");

    }
}
