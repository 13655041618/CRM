package com.wdq.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by haier on 2017/7/9.
 */
public class MyStringUtil {
    /**
     * 将字符串加密
     * @param value
     * @return
     */
    public static String getMD5Value(String value) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //MD5加密后是十进制字符串，而数据库中加密数据是16进制，所以要通过BigInteger进行转换
            byte[] bytes = messageDigest.digest(value.getBytes());
            //参数1表示只考虑正数
            BigInteger bigInteger = new BigInteger(1,bytes);
            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得一个32位随机字符串
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
