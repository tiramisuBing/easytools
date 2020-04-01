package com.util;

import com.alibaba.fastjson.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class isNull {
    private static Random rand = new Random();

    //置空
    public static String changeStringIsNull(String firstNode,String secondNode,String threeNode,String reqMsg){
        String sNode = getNode(firstNode,secondNode,threeNode,reqMsg);
        reqMsg = reqMsg.replace(sNode,"");
        return reqMsg;
    }

    public static String changeStringIsNull(String firstNode,String secondNode,String threeNode,String fourNode,String reqMsg){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,reqMsg);
        reqMsg = reqMsg.replace(sNode,"");
        return reqMsg;
    }

    public static String changeStringIsNull(String firstNode,String secondNode,String threeNode,String fourNode,String fiveNode,String reqMsg){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,fiveNode,reqMsg);
        reqMsg = reqMsg.replace(sNode,"");
        return reqMsg;
    }

    //根据长度生成字符串
    public static String changeStringLength(String firstNode,String secondNode,String threeNode,String reqMsg,String length){
        String sNode = getNode(firstNode,secondNode,threeNode,reqMsg);
        String randomMsg = getRandomStringNum(length);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    public static String changeStringLength(String firstNode,String secondNode,String threeNode,String fourNode,String reqMsg,String length){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,reqMsg);
        String randomMsg = getRandomStringNum(length);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    public static String changeStringLength(String firstNode,String secondNode,String threeNode,String fourNode,String fiveNode,String reqMsg,String length){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,fiveNode,reqMsg);
        String randomMsg = getRandomStringNum(length);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    //根据长度生成数串
    public static String changeDecimalLength(String firstNode,String secondNode,String threeNode,String reqMsg,String length){
        String sNode = getNode(firstNode,secondNode,threeNode,reqMsg);
        String randomMsg = getRandomNum(length);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    public static String changeDecimalLength(String firstNode,String secondNode,String threeNode,String fourNode,String reqMsg,String length){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,reqMsg);
        String randomMsg = getRandomNum(length);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    public static String changeDecimalLength(String firstNode,String secondNode,String threeNode,String fourNode,String fiveNode,String reqMsg,String length){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,fiveNode,reqMsg);
        String randomMsg = getRandomNum(length);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    //根据长度生成小数
    public static String changeDecimalValue(String firstNode,String secondNode,String threeNode,String reqMsg,String length,String pattern){
        String sNode = getNode(firstNode,secondNode,threeNode,reqMsg);
        String randomMsg = getDouble(length,pattern);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    public static String changeDecimalValue(String firstNode,String secondNode,String threeNode,String fourNode,String reqMsg,String length,String pattern){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,reqMsg);
        String randomMsg = getDouble(length,pattern);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    public static String changeDecimalValue(String firstNode,String secondNode,String threeNode,String fourNode,String fiveNode,String reqMsg,String length,String pattern){
        String sNode = getNode(firstNode,secondNode,threeNode,fourNode,fiveNode,reqMsg);
        String randomMsg = getDouble(length,pattern);
        reqMsg = reqMsg.replace(sNode,randomMsg);
        return reqMsg;
    }

    //获取节点值
    public static String getNode(String firstNode,String secondNode,String threeNode,String reqMsg){
        List<String> list = new ArrayList<>();
        list.add(firstNode);
        list.add(secondNode);
        list.add(threeNode);
        JSONObject obj = JSONObject.parseObject(reqMsg);
        String str = "";
        for (String l:list) {
            str = obj.getString(l);
            if (!l.equals(threeNode)) {
                obj = JSONObject.parseObject(str);
            }
        }
        return str;
    }

    public static String getNode(String firstNode,String secondNode,String threeNode,String fourNode,String reqMsg){
        List<String> list = new ArrayList<>();
        list.add(firstNode);
        list.add(secondNode);
        list.add(threeNode);
        list.add(fourNode);
        JSONObject obj = JSONObject.parseObject(reqMsg);
        String str = "";
        for (String l:list) {
            str = obj.getString(l);
            if (!l.equals(fourNode)) {
                obj = JSONObject.parseObject(str);
            }
        }
        return str;
    }

    public static String getNode(String firstNode,String secondNode,String threeNode,String fourNode,String fiveNode,String reqMsg){
        List<String> list = new ArrayList<>();
        list.add(firstNode);
        list.add(secondNode);
        list.add(threeNode);
        list.add(fourNode);
        list.add(fiveNode);
        JSONObject obj = JSONObject.parseObject(reqMsg);
        String str = "";
        for (String l:list) {
            str = obj.getString(l);
            if (!l.equals(fiveNode)) {
                obj = JSONObject.parseObject(str);
            }
        }
        return str;
    }

    //随机生成字符串
    public static String getRandomStringNum(String length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(length); i++) {
            int number = rand.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //随机生成数串
    public static String getRandomNum(String length) {
        String base = "123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(length); i++) {
            int number = rand.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //随机生成固定长度的小数
    public static String getDouble(String n,String pattern){
        DecimalFormat df=new DecimalFormat(pattern);
        return df.format(rand.nextDouble()*Integer.parseInt(n));
    }

    public static void main(String[] args) {
        String requestmsg = "{\n" +
                "  \"PrejudicInfo\": {\n" +
                "    \"GeneralInfo\": {\n" +
                "      \"PlateformCode\": \"CPI000786\",\n" +
                "      \"Uuid\": \"2ddssdfgrttytyuyueg2\",\n" +
                "      \"Md5Value\": \"4f645134ba2c5a335b05e69bcd39719a\"\n" +
                "    }, \n" +
                "  \"Prejudication\": {\n" +
                "\t  \"Pre_main\": {\n" +
                "        \"insuredSocialCode\": \"91420100555019872H\",\n" +
                "        \"projectCode\": \"1101ZU190271\",\n" +
                "        \"distriSocialCode\": \"91310000310521581B\",\n" +
                "        \"qudLay\": \"000002000001\",\n" +
                "        \"Filename\": \"RB_110101198801010019_buyer-ida,RB_110101198801010019_buyer-idb,RB_110101198801010019_buyer-rbzxsqsdzq,RB_110101198801010019_buyer-face,RB_110101198801010019_buyer-rbzxsqsfdzq,RB_110101198801010019_buyer-sqsqzz\"\n" +
                "      },\n" +
                "      \"Pre_carBuyer\": {\n" +
                "        \"insuredName\": \"测试\",\n" +
                "        \"identifyType\": \"01\",\n" +
                "        \"identifyNumber\": \"110101198801010019\",\n" +
                "        \"validStartDate\": \"20161220\",\n" +
                "        \"validEndDate\": \"20361220\",\n" +
                "        \"identifyAddress\": \"河北省廊坊市三河市东贸国际10号楼\",\n" +
                "        \"sex\": \"男\",\n" +
                "        \"mobile\": \"18100000000\",\n" +
                "        \"accountNo\": \"110101198801010019\",\n" +
                "        \"marriage\": \"2\",\n" +
                "\t\t\"issCtry\": \"CN\",\n" +
                "\t\t\"educationCode\": \"10\",\n" +
                "\t\t\"nature\":{\n" +
                "\t\t\t\"appliWorkName\":\"11\"\n" +
                "\t\t}\n" +
                "      },\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String ret = changeStringIsNull("PrejudicInfo","Prejudication","Pre_carBuyer","nature","appliWorkName",requestmsg);
        String ret1 = changeStringLength("PrejudicInfo","Prejudication","Pre_carBuyer","nature","appliWorkName",requestmsg,"18");
        String ret2 = changeDecimalLength("PrejudicInfo","Prejudication","Pre_carBuyer","nature","appliWorkName",requestmsg,"100");
        String ret3 = changeDecimalValue("PrejudicInfo","Prejudication","Pre_carBuyer","nature","appliWorkName",requestmsg,"100","#.000");
        String ret4 = changeStringIsNull("PrejudicInfo","Prejudication","Pre_carBuyer","mobile",requestmsg);
        String ret5 = changeStringIsNull("PrejudicInfo","Prejudication","Pre_carBuyer","nature","appliWorkName",requestmsg);

        System.out.println(ret);

//        String d = getDouble("100","#.000");
//        System.out.println(d);
    }
}
