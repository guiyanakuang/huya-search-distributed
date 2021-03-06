package com.huya.search;

import com.huya.search.util.OsUtil;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyiqun1@yy.com on 2018/2/26.
 */
public class HuyaSearchSalverDev {

    public static void main(String[] args) {
        if (OsUtil.isWindows()) {
            System.setProperty("java.security.auth.login.config", "E:/other/huya-search/huya-search-distributed/temp/conf/kafka_client_jaas.conf"); // 环境变量添加，需要输入配置文件的路径
            System.setProperty("pull.content.method", "end"); // 环境变量添加，需要输入配置文件的路径
            System.setProperty("hadoop.home.dir", "D:/program/hadoop");
        }
        HuyaSearchSalver.main(args);
    }

    @Test
    public void closeTest() {
        HuyaSearchSalver.main(new String[]{});
        HuyaSearchSalver searchSalver = HuyaSearchSalver.getInstance();
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchSalver.close();
    }
}
