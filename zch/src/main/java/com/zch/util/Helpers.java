package com.zch.util;

import org.apache.tomcat.util.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by chensuo on 2018-8-1.
 */
public class Helpers {
    /**
     * 对给定字符串进行MD5加密
     * @param str
     * @return
     */
    public static String MD5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return Base64.encodeBase64String(md5.digest(Base64.decodeBase64(str)));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("异常-未找到MD5加密算法");
            return "";
        } catch (Exception e) {
            System.out.println("异常-MD5");
            return "";
        }
    }


    public static String getProperty(String str){
        try {
            ResourceBundle resource = ResourceBundle.getBundle("main/java/com/zch/aop/authority_mapping");
            String key = resource.getString(str);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
            return "==========";
        }

    }

    public static void main(String[] asfs) throws NoSuchAlgorithmException {
        System.out.println(getProperty("asdf"));
    }
}
