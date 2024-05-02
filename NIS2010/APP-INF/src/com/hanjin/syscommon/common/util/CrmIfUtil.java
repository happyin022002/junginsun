package com.hanjin.syscommon.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrmIfUtil {

	private String instanceId = null;
	private String msgId = null;
	private List<Map<String, String>> dataList = null;
	private StringBuilder sb = new StringBuilder();
	private String msgTypeName = "CRM CUSTOMER MASTER";
	private String msgTypeCode = "MDM013-001";
	
	public CrmIfUtil(String msgId){
		this.msgId = msgId;
		dataList = new ArrayList<Map<String, String>>();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>").append("\n");
		sb.append(getAddTeb(0)).append("<PropertySet").append(" xmlns=\"http://irep.hanjin.com/alps/").append(msgId.toLowerCase()).append("\" ");
	}
	
	/**
	 * 
	 */
	private void setHeader(){
		sb.append(getAddTeb(0)).append("instanceId=\"").append(getInstanceId()).append("\" ");
		/*sb.append(getAddTeb(0)).append("MsgTypeName=\"").append(msgTypeName).append("\" ");
		sb.append(getAddTeb(0)).append("MsgTypeCode=\"").append(msgTypeCode).append("\">").append("\n");*/
		sb.append(getAddTeb(0)).append("MsgTypeName=\"").append(getMsgTypeName()).append("\" ");
		sb.append(getAddTeb(0)).append("MsgTypeCode=\"").append(getMsgTypeCode()).append("\">").append("\n");
	}
	
	/**
	 * 
	 */
	private void setDataArea(){
		for (int i = 0; i < dataList.size(); i++) {
			Map<String, String> dataMap = dataList.get(i);
			String[] keys = dataMap.keySet().toArray(new String[0]);
			sb.append(getAddTeb(1)).append("<PropertySet ").append(" ");
			for (int j = 0; j < keys.length; j++) {
				String attrName = getChangeName(keys[j]);
				if(!attrName.equals(""))
					sb.append(getAddTeb(2)).append(attrName).append("=").append("\"").append(dataMap.get(keys[j])==null?"":replaceXmlStr(dataMap.get(keys[j]))).append("\"").append(" ");
			}
			sb.append(getAddTeb(1)).append("/>").append("\n");
		}
	}
	
	/**
	 * 
	 */
	public void createdMsg(){
		setHeader();
		setDataArea();
		sb.append(getAddTeb(0)).append("</PropertySet>");
	}
	
	/**
	 * 
	 */
	public String toString(){
		return sb.toString();
	}
	
	private String getChangeName(String name){
		if(name.toUpperCase().equals("IBFLAG") || name.toUpperCase().equals("PAGEROWS")) return "";
		
		String[] temp = name.split("_");
		StringBuffer names = new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			names.append(temp[i].substring(0, 1).toUpperCase() +  temp[i].substring(1, temp[i].length()));
		}
		return names.toString();
	}
	
	private String getAddTeb(int count){
		String tabs = "";
		for (int i = 0; i < count; i++) {
			tabs += "\t";
		}
		return tabs;
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

			
	public void addNewData(Map<String, String> dataMap){
		dataList.add(dataMap);
	}
	
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getMsgTypeName() {
		return msgTypeName;
	}

	public void setMsgTypeName(String msgTypeName) {
		this.msgTypeName = msgTypeName;
	}
	
	public String getMsgTypeCode() {
		return msgTypeCode;
	}

	public void setMsgTypeCode(String msgTypeCode) {
		this.msgTypeCode = msgTypeCode;
	}

	public List<Map<String, String>> getDataList() {
		return dataList;
	}

	public void setDataList(List<Map<String, String>> dataList) {
		this.dataList = dataList;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

//	public static void main(String[] args) {
//		CrmIfUtil eaiUtil = new CrmIfUtil("MDM064-0001");
//		eaiUtil.setInstanceId("MDM064-0001J" + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
//		MDM064 mDM064 = new MDM064();
//		eaiUtil.addNewData(mDM064.getColumnValues());
//		System.out.println(eaiUtil.toString());
//	}

}
