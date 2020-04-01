package com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class jsonGetValue {
	public static List<String> JsonValue(String str,String Parentnode,String Secondarynode,String[] Nodearray,JSONArray Dataarray,String Mainnode) {
		
		JSONObject jsonObject = JSONObject.parseObject(str);
		String parentnode = jsonObject.getString(Parentnode);
		
		JSONObject fundcon = JSONObject.parseObject(parentnode);
		String secondarynode = fundcon.getString(Secondarynode);
		
		JSONArray arrP=JSONArray.parseArray(secondarynode);
		
		List<String> node=new ArrayList<>();

		for (int i=0;i<arrP.size();i++) {
			JSONObject obj=JSONObject.parseObject(arrP.get(i).toString());
			for (int j=0;j<Dataarray.size();j++) {
				JSONObject res=JSONObject.parseObject(Dataarray.get(j).toString());
				if (res.getString(Mainnode).equals(obj.getString(Mainnode))) {
					for (String object : Nodearray) {
						if (!res.getString(object).equals(obj.getString(object))) {
							String errornode = obj.getString(Mainnode) + "->" + object;
							node.add(errornode);
						}
					}
				}else {
					node.add(obj.getString(Mainnode)+"->无匹配项");
				}
			}
			
		}
		return node;
	}
	public static JSONObject noListData(String str,String Parentnode,String Secondarynode) {
		JSONObject jsonObject = JSONObject.parseObject(str);
		String parentnode = jsonObject.getString(Parentnode);
		
		JSONObject fundcon = JSONObject.parseObject(parentnode);
		String secondarynode = fundcon.getString(Secondarynode);
		
		return JSONObject.parseObject(secondarynode);
	}

	public static JSONObject noListData(String str,String Parentnode) {
		JSONObject jsonObject = JSONObject.parseObject(str);
		String parentnode = jsonObject.getString(Parentnode);

		return JSONObject.parseObject(parentnode);
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
//		String str = "{\r\n" + 
//				"  \"cpiApprovalReq\": {\r\n" + 
//				"    \"receiveMsg\": {\r\n" + 
//				"      \"requestNo\": \"76328c7c-fd2e-483c-8afe-81f9c964dde3\",\r\n" + 
//				"      \"txTm\": \"2019-12-17 02:20:17.92 UTC\"\r\n" + 
//				"    },\r\n" + 
//				"    \"fundconfigMsgs\": [{\r\n" + 
//				"      \"fundconfig_code\": \"1\",\r\n" + 
//				"      \"fundconfig_serialno\": \"2\",\r\n" + 
//				"      \"fundconfig_name\": \"3\",\r\n" + 
//				"      \"fundconfig_type\": \"4\",\r\n" + 
//				"      \"fundname\": \"5\",\r\n" + 
//				"      \"uscCode\": \"6\",\r\n" + 
//				"      \"element_code\": \"7\",\r\n" + 
//				"      \"element_name\": \"8\",\r\n" + 
//				"      \"upelement_code\": \"9\",\r\n" + 
//				"      \"upelement_name\": \"10\",\r\n" + 
//				"      \"element_control\": \"11\",\r\n" + 
//				"      \"element_length\": \"12\",\r\n" + 
//				"	  \"element_stage\": \"13\",\r\n" + 
//				"	  \"element_type\": \"14\"\r\n" + 
//				"    },\r\n" + 
//				"	{\r\n" + 
//				"      \"fundconfig_code\": \"15\",\r\n" + 
//				"      \"fundconfig_serialno\": \"16\",\r\n" + 
//				"      \"fundconfig_name\": \"17\",\r\n" + 
//				"      \"fundconfig_type\": \"18\",\r\n" + 
//				"      \"fundname\": \"19\",\r\n" + 
//				"      \"uscCode\": \"20\",\r\n" + 
//				"      \"element_code\": \"21\",\r\n" + 
//				"      \"element_name\": \"22\",\r\n" + 
//				"      \"upelement_code\": \"23\",\r\n" + 
//				"      \"upelement_name\": \"24\",\r\n" + 
//				"      \"element_control\": \"25\",\r\n" + 
//				"      \"element_length\": \"26\",\r\n" + 
//				"	  \"element_stage\": \"27\",\r\n" + 
//				"	  \"element_type\": \"28\"\r\n" + 
//				"    }]\r\n" + 
//				"  }\r\n" + 
//				"}";
////		System.out.println(str);
//		String[] str1 = {"fundconfig_code","fundconfig_serialno","fundconfig_name","fundconfig_type","fundname","uscCode","element_code","element_name","upelement_code","upelement_name","element_control","element_length","element_stage","element_type"};
//		JSONArray str2 = JSONArray.parseArray("[{\"fundconfig_name\":\"rrr\",\"element_stage\":\"13\",\"fundname\":\"5\",\"upelement_name\":\"10\",\"element_type\":\"14\",\"element_length\":\"12\",\"element_control\":\"11\",\"fundconfig_serialno\":\"2\",\"fundconfig_type\":\"4\",\"upelement_code\":\"9\",\"fundconfig_code\":\"1\",\"uscCode\":\"6\",\"element_name\":\"8\",\"element_code\":\"7\"}]");
//		List<String> lst = JsonValue(str, "cpiApprovalReq", "fundconfigMsgs", str1, str2, "fundconfig_code");
//		for (String string : lst) {
//			System.out.println(string);
//		}
//		System.out.println(lst.size()!=0);
		
		String str3 = "{\r\n" + 
				"  \"cpiApprovalReq\": {\r\n" + 
				"    \"receiveMsg\": {\r\n" + 
				"      \"requestNo\": \"\",\r\n" + 
				"      \"txTm\": \"2019-12-17 02:20:17.92 UTC\"\r\n" + 
				"    },\r\n" + 
				"    \"projectMsg\": {\r\n" + 
				"      \"ProjectCode\": \"1\",\r\n" + 
				"      \"YhsocialCreditCode\": \"\",\r\n" + 
				"      \"MORTGAGEPERSON\": \"\",\r\n" + 
				"      \"ValidStatus\": \"\",\r\n" + 
				"      \"QdsocialCreditCode\": \"\",\r\n" + 
				"      \"QdsocialCreditName\": \"\",\r\n" + 
				"      \"ComCode\": \"\",\r\n" + 
				"      \"AgentCode\": \"\",\r\n" + 
				"      \"Handler1Code\": \"\",\r\n" + 
				"      \"HandlerCode\": \"\",\r\n" + 
				"      \"makcode\": \"\",\r\n" + 
				"      \"opratecode\": \"\",\r\n" + 
				"      \"term\": \"36,24,12\",\r\n" + 
				"	  \"proSignFlag\": \"36,24,12\",\r\n" + 
				"	  \"creditSignFlag\": \"03\",\r\n" + 
				"      \"businessType\": \"03\",\r\n" + 
				"      \"applicationFlag\": \"02\",\r\n" + 
				"      \"applicationType\": \"14\",\r\n" + 
				"      \"spouseFlag\": \"0\",\r\n" + 
				"      \"vehicleUseNature\": \"1\",\r\n" + 
				"	  \"fundconfigCcode\": \"0\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		JSONArray str4 = JSONArray.parseArray("[{\r\n" + 
				"      \"projectcode\": \"1\",\r\n" + 
				"      \"yhsocialcreditcode\": \"\",\r\n" + 
				"      \"mortgageperson\": \"\",\r\n" + 
				"      \"validstatus\": \"\",\r\n" + 
				"      \"qdsocialcreditcode\": \"\",\r\n" + 
				"      \"comcode\": \"\",\r\n" + 
				"      \"agentcode\": \"\",\r\n" + 
				"      \"AgentCode\": \"\",\r\n" + 
				"      \"handler1code\": \"\",\r\n" + 
				"      \"HandlerCode\": \"\",\r\n" + 
				"      \"makcode\": \"\",\r\n" + 
				"      \"opratecode\": \"\",\r\n" + 
				"      \"term\": \"36,24,12\",\r\n" + 
				"	  \"proSignFlag\": \"36,24,12\",\r\n" + 
				"	  \"creditSignFlag\": \"03\",\r\n" + 
				"      \"businessType\": \"03\",\r\n" + 
				"      \"applicationFlag\": \"02\",\r\n" + 
				"      \"applicationType\": \"14\",\r\n" + 
				"      \"spouseFlag\": \"0\",\r\n" + 
				"      \"vehicleUseNature\": \"1\",\r\n" + 
				"	  \"fundconfigCcode\": \"0\"\r\n" + 
				"    }]");
		JSONObject str5 = noListData(str3,"cpiApprovalReq");
//		String[] str6 = {"ProjectCode","YhsocialCreditCode","MORTGAGEPERSON","ValidStatus","QdsocialCreditCode","QdsocialCreditName","ComCode","AgentCode","Handler1Code","HandlerCode","makcode","opratecode","term","proSignFlag","creditSignFlag","businessType","applicationFlag","applicationType","spouseFlag","vehicleUseNature","fundconfigCcode"};
//		String[] str7 = {"projectcode","yhsocialcreditcode","mortgageperson","validstatus","qdsocialcreditcode","comcode","agentcode","handler1code","handlercode","makcode","opratecode","term","prosignflag","creditsignflag","businesstype","hxbsubbranchcode","hxbsubbranchname","qdsocialcreditname","applicationflag","spouseflag","applicationtype","esigntype","vehicleusenature"};
//		List<String> node1=new ArrayList<>();
//		JSONObject js = JSONObject.parseObject(str4.get(0).toString());
//
//		for (int i=0;i<str6.length;i++) {
////			System.out.println("str6"+str5.getString(str6[i]));
////			System.out.println("str7"+js.getString(str7[i]));
//			if (!str5.getString(str6[i]).equals(js.getString(str7[i]))) {
//				node1.add(str6[i]);
//			}
//		}
//		for (String string : node1) {
//			System.out.println(string);
////			System.out.println(node1.size());
//		}
		System.out.println(str5.getString("projectMsg"));
		
	
	}
}