package com.util;

import org.json.JSONObject;
import org.json.XML;

public class xmlToJson {
	public static String  xmlTojson(String xml_str){
        JSONObject xmlJSONObj = XML.toJSONObject(xml_str);
        return xmlJSONObj.toString();
	}

	public static void main(String[] args){
		String string = xmlTojson("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
				"    <ApplyInfo>\r\n" + 
				"        <TRD_CHNNL_CODE>32</TRD_CHNNL_CODE>\r\n" + 
				"        <TRANTIME>234</TRANTIME>\r\n" + 
				"        <SCREDIT_CODE>342</SCREDIT_CODE>\r\n" + 
				"        <RST_STS>234</RST_STS>\r\n" + 
				"        <ENF_STS>234</ENF_STS>\r\n" + 
				"        <RST_DESC>234</RST_DESC>\r\n" + 
				"        <EXPAND_INFO>234</EXPAND_INFO>\r\n" + 
				"    </ApplyInfo>\r\n" + 
				"");
        System.out.println(string);

	}

}
