package com.huya.facing.convert;

import com.huya.search.facing.convert.IgnorableConvertException;
import com.huya.search.facing.convert.NewLiveServerConvert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by zhangyiqun1@yy.com on 2018/3/5.
 */
public class NewLiveServerConvertTest {

    @Test
    public void runTest() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/geekcat/Documents/data.txt"));
        NewLiveServerConvert convert = new NewLiveServerConvert();
        while (true) {
            String key = bufferedReader.readLine();
            String value = bufferedReader.readLine();

            if (key == null) break;
            try {
                System.out.println(convert.convert(0, 0, value, key));
            } catch (IgnorableConvertException ignore) {
                ignore.printStackTrace();
            }
        }
    }
}
