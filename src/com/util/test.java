package com.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author cunyu
 * @date 2020/3/26 19:41
 */
public class test {
    public static void main(String[] args) {
        String str = "1234567890";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int r = new Random().nextInt(str.length());
            sb.append(r);
        }
//        System.out.println(String.valueOf(new Date().getTime()));
//        long newTime = new Date().getTime();
//        String time = Long.toString(newTime).substring(0, 10);
//        System.out.println(time);
//        String pic = "{\"projectMsg\":{\"agentCode\":\"000002000001\",\"applicationFlag\":\"02\",\"applicationType\":\"14\",\"businessType\":\"03\",\"comCode\":\"11010800\",\"creditSignFlag\":\"1\",\"fundconfigCcode\":\"test01\",\"handler1Code\":\"11695836\",\"handlerCode\":\"11695836\",\"makcode\":\"11010800\",\"mortgageperson\":\"4\",\"opratecode\":\"A000008429\",\"proSignFlag\":\"\",\"projectCode\":\"1101ZU190050\",\"qdsocialCreditCode\":\"91310000MA1FL0RA0Y\",\"qdsocialCreditName\":\"联众融资租赁（上海）有限公司\",\"spouseFlag\":\"0\",\"term\":\"12,24,36\",\"validStatus\":\"1\",\"vehicleUseNature\":\"1\",\"yhSocialCreditCode\":\"911200007676419544\"},\"receiveMsg\":{\"txTm\":1585539343000}}";
//        int i = pic.indexOf("RB_");
//        System.out.println(pic.substring(pic.indexOf("RB_")));
//        List<String> node = new ArrayList<>();
//        String res = "{\"projectMsg\":{\"agentCode\":\"000002000001\",\"applicationFlag\":\"02\",\"applicationType\":\"14\",\"businessType\":\"03\",\"comCode\":\"11010800\",\"creditSignFlag\":\"1\",\"fundconfigCcode\":\"test01\",\"handler1Code\":\"11695836\",\"handlerCode\":\"11695836\",\"makcode\":\"11010800\",\"mortgageperson\":\"4\",\"opratecode\":\"A000008429\",\"proSignFlag\":\"\",\"projectCode\":\"1101ZU190050\",\"qdsocialCreditCode\":\"91310000MA1FL0RA0Y\",\"qdsocialCreditName\":\"联众融资租赁（上海）有限公司\",\"spouseFlag\":\"0\",\"term\":\"12,24,36\",\"validStatus\":\"1\",\"vehicleUseNature\":\"1\",\"yhSocialCreditCode\":\"911200007676419544\"},\"receiveMsg\":{\"txTm\":1585539343000}}";
//        JSONObject o = JSONObject.parseObject(res);
//        String s = o.getString("projectMsg");
//        System.out.println(s);
//        String[] n = new String[21];
//        System.out.println(n.length);
        String time = "2020-03-31 16:16:38.0";
        System.out.println(time.replace(".0",""));
        //com.util.isNull.changeStringIsNull();

    }
}
