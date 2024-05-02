package com.hanjin.framework.support.schema.groupware;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GroupwareMailRequest {

	private String instanceId = null;
	private String msgId = null;
	private List<GetMailEpInfo> dataList = null;
	private StringBuilder sb = new StringBuilder();
	
	public GroupwareMailRequest(String msgId){
		this.msgId = msgId;
		dataList = new ArrayList<GetMailEpInfo>();
	}
	
	private void setDataArea(){
		sb.append(getAddTeb(2)).append("<").append(getMsgId()).append("ProcessRequest xmlns=\"http://xmlns.oracle.com/").append(getMsgId()).append("\">").append("\n");
		for (int i = 0; i < dataList.size(); i++) {
			GetMailEpInfo info = dataList.get(i);
			Field[] fidles = info.getClass().getDeclaredFields();
			for (int j = 0; j < fidles.length; j++) {
				sb.append(getAddTeb(3)).append("<").append(fidles[j].getName()).append(">");
				try {
					Object obj = info.getClass().getMethod("get" + fidles[j].getName(), null).invoke(info); 
					sb.append(replaceXmlStr(String.valueOf(obj)));
				} catch (Exception e) {}
				sb.append("</").append(fidles[j].getName()).append(">").append("\n");
			}
		}
		sb.append(getAddTeb(2)).append("</").append(getMsgId()).append("ProcessRequest>").append("\n");
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private String replaceXmlStr(String str) {
		try{
			str = str.replaceAll("\"", "&quot;");
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("\'", "&apos;");
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			str = str.trim();
		}catch(Exception e){}
		return str;
	}
	
	/**
	 * 
	 */
	public void createdMsg(){
		setDataArea();
	}
	
	/**
	 * 
	 */
	public String toString(){
		return sb.toString();
	}
	
	private String getAddTeb(int count){
		String tabs = "";
		for (int i = 0; i < count; i++) {
			tabs += "\t";
		}
		return tabs;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public List<GetMailEpInfo> getDataList() {
		return dataList;
	}

	public void addDataList(GetMailEpInfo data) {
		this.dataList.add(data);
	}

//	public static void main(String[] args) {
//		GroupwareMailUtil eaiUtil = new GroupwareMailUtil("COM012_0001");
//		GetMailEpInfo info = new GetMailEpInfo();
//		info.setInstanceId(eaiUtil.getMsgId() + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
//		info.setUserID("2008601");
//		info.setGlobalUserId("2008601");
//		info.setFormDistinct("MAIL_EP_1");
//		info.setSystemDocumentID("ALPS_20170822130638413");
//		info.setSystemName("ALPS");
//		info.setXmldom(
//		"<?xml version='1.0' encoding = 'UTF-8' ?><ROOT><SUBJECT>" +
//		"Code Creation Request. (BKG#:NYC125684501)" +
//		"</SUBJECT><TO>" +
//		"isjung@hipluscard.co.kr" +
//		"</TO><CC>" +
//		"isjung@hipluscard.co.kr" +
//		"</CC><BODY><CONTENTS><![CDATA[" +
//		"124134325" +
//		"]]></CONTENTS></BODY></ROOT>"
//		);
//		
//		eaiUtil.addDataList(info);
//		eaiUtil.createdMsg();
//		System.out.println(eaiUtil.toString());
//	}
}
