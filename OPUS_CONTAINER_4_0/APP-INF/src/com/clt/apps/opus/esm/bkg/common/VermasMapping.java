/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VermasMapping.java
 *@FileTitle : VermasMapping
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.22
 *@LastModifier : 정인선
 *@LastVersion : 1.0
 * 2016.06.22 정인선
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * PegasusMapping<br>
 * 
 * @author 정인선
 * @see VermasMapping
 * @since J2EE 1.4
 */
public class VermasMapping {

	protected Logger log = Logger.getLogger(super.getClass().getName());
	private String lineSep = "\n";
	private String colon = ":";
	
	/**
	 * 
	 * @param rootNode
	 * @param msg
	 * @return
	 */
	public LinkedHashMap<String, String> createNodePath(String rootNode, String msg){
		return createNodePath(rootNode, msg, new String[]{"null"});
	}
	
	/**
	 * 
	 * @param rootNode
	 * @param msg
	 * @param passNodePaths
	 * @return
	 */
	public LinkedHashMap<String, String> createNodePath(String rootNode, String msg, String[] passNodePaths){
		String[] lineMsgs = msg.split(lineSep);
		LinkedHashMap<String, String> nodeMap = new LinkedHashMap<String, String>();
		String changeNodePath = "";
		int checkStr = 0;
		for (int i = 0; i < lineMsgs.length; i++) {
			String[] nodeData = null;
			String lineData = lineMsgs[i].replaceAll("\r", "");
			
			/* 불필요한 DATA */
			if(lineData.equals("")) continue;
			else if(lineData.charAt(0) == '{'){
				/* 신규노드Start */
				checkStr = 1;
				changeNodePath = genChangeNodePath(changeNodePath, lineData);
			}else if(lineData.charAt(0) == '}'){
				/* 신규노드End */
				checkStr = 2;
				changeNodePath = genChangeNodePath(changeNodePath, lineData);
			}else{
				/* 노드가 아닌 DATA */
				checkStr = 0;
				nodeData = lineData.split(colon);
			}
			
			/* 노드가 DATA일 경우 */
			if(checkStr == 0){
				/* 노드 이름 */
				String nodeName = nodeData[0].trim();
				/* 노드 값 */
				String nodeValue = "";
				if(nodeData.length > 1)
					nodeValue = nodeData[1].trim();
				/* 노드 이름이 CUST_NM1.2.3 or CUST_ADDR1.2.3 일경우 노드이름 변경 */
				if(nodeName.indexOf("CUST_NM") > -1){
					nodeName = "CUST_NM";
				}else if(nodeName.indexOf("CUST_ADDR") > -1){
					nodeName = "CUST_ADDR";
				}
				/* 노드이름 생성 */
				String genNodePath = genNodePath(rootNode, changeNodePath, nodeName);
				/* 노드이름이 존재할 경우 DATA append */
				if(nodeMap.containsKey(genNodePath)){
					if(!nodeValue.equals(""))
						nodeValue = nodeMap.get(genNodePath) + lineSep + nodeValue;
					else
						nodeValue = nodeMap.get(genNodePath);
				}
				
				/* 불필요한 노드일경우 패스 */
				int passNode = 0;
				
				for (int j = 0; j < passNodePaths.length; j++) {
					if(genNodePath.indexOf(passNodePaths[j]) > -1) passNode = 1;
				}
				
				if(passNode == 0)
					nodeMap.put(genNodePath, nodeValue);
			}
		}
		
		return nodeMap;
	}
	
	/**
	 * 
	 * @param changeNodePath
	 * @param nodePath
	 * @return
	 */
	public String genChangeNodePath(String changeNodePath, String nodePath) {
		/* 신규 노드 및 완료 노드 { , } 문자열 제거 */
		String tempNodePath = nodePath.substring(1, nodePath.length());
		StringBuffer newNodePath = new StringBuffer();
		
		/* 기존노드에 신규노드 이름이 존재하면 true */
		if(changeNodePath.indexOf(tempNodePath) > -1){
			/* 기존 노드에 신규노드명이 존재하면 END 생각하고 해당 노드명 제거 */
			String[] temps = changeNodePath.split("/");
			for (int i = 0; i < temps.length; i++) {
				if(!temps[i].trim().equals("") && !temps[i].trim().equals(tempNodePath)) newNodePath.append(temps[i].trim()).append("/");
			}
		}else{
			/* 기존노드명에 신규노드명이 없으면 하위 노드로 생각하고 노드 append */
			newNodePath.append("/").append(changeNodePath).append("/").append(tempNodePath).append("/");
		}
		return newNodePath.toString().replaceAll("//", "/");
	}
	
	/**
	 * 
	 * @param rootNode
	 * @param changeNodePath
	 * @param nodeData
	 * @return
	 */
	public String genNodePath(String rootNode, String changeNodePath, String nodeData) {
		StringBuffer nodePath = new StringBuffer(rootNode);
		/* 신규노드가 값이 */
		if(changeNodePath != null && !changeNodePath.equals("") && !changeNodePath.equals("/"))
			nodePath.append(changeNodePath.trim());
		if(nodeData != null && !nodeData.equals("")) 
			nodePath.append("/").append(nodeData.trim());
		
		return nodePath.toString().replaceAll("//", "/");
	}
	
	/**
	 * 
	 * @param prefix
	 * @param msg
	 * @return
	 */
	public String getNodeData(String prefix, String msg) {
		String[] lineMsgs = msg.split(lineSep);
		StringBuffer nodeData = new StringBuffer();
		int addStr = 0;
		for (int i = 0; i < lineMsgs.length; i++) {
			if(addStr == 0 && lineMsgs[i].trim().equals("{" + prefix))
				addStr = 1;
			else if(addStr == 1 && lineMsgs[i].charAt(0) == '{')
				addStr = 2;
			else if(lineMsgs[i].trim().equals("}" + prefix))
				addStr = 2;
			
			if(addStr == 1 && !lineMsgs[i].trim().equals("{" + prefix)) nodeData.append(lineMsgs[i]).append(lineSep);
			else if(addStr == 2){
				break;
			}
		}
		return nodeData.toString();
	}
	
	/**
	 * 여러건에 노드DATA를 STR 생성
	 * @param prefix
	 * @param msg
	 * @return
	 */
	public List<String> getNodeDatas(String prefix, String msg) {
		List<String> nodeDataList = new ArrayList<String>();
		String[] lineMsgs = msg.split(lineSep);
		StringBuffer nodeData = new StringBuffer();
		int addStr = 0;
		for (int i = 0; i < lineMsgs.length; i++) {
			if(lineMsgs[i].trim().equals("{" + prefix))
				addStr = 1;
			else if(lineMsgs[i].trim().equals("}" + prefix))
				addStr = 2;
			
			if(addStr == 1 && !lineMsgs[i].trim().equals("{" + prefix)) nodeData.append(lineMsgs[i]).append(lineSep);
			else if(addStr == 2){
				nodeDataList.add(nodeData.toString());
				nodeData.delete(0, nodeData.toString().length());
				addStr = 0;
			}
		}
		return nodeDataList;
	}
	
	/**
	 * 
	 * @param mapData
	 * @param rqstList
	 * @return
	 */
	public LinkedHashMap<String, String> createdBkgXterVgmRqst(Map<String, LinkedHashMap<String, String>> mapData, List<BkgHrdCdgCtntVO> rqstList){
		LinkedHashMap<String, String> dataSet = new LinkedHashMap<String, String>();
		for (int i = 0; i < rqstList.size(); i++) {
			BkgHrdCdgCtntVO vo = rqstList.get(i);
			LinkedHashMap<String, String> dataMap = mapData.get(vo.getAttrCtnt5().trim());
			if(dataMap == null) continue;
			
			String data = dataMap.get(vo.getAttrCtnt10().trim());
			if(vo.getAttrCtnt9() != null && vo.getAttrCtnt9().indexOf(":") > -1){
				String[] type = vo.getAttrCtnt9().split(":");
				if(type[0].equals("B")) data = binding(data, type[1]);
				else if(type[0].equals("R")) data = replaceAll(data, type[1]);
			}
			if((data != null && !data.equals("")) && (vo.getAttrCtnt4() != null && !vo.getAttrCtnt4().equals(""))){
				dataSet.put(vo.getAttrCtnt4(), data.replaceAll("\\'", "\\$\\^"));
			}
		}
		return dataSet;
	}
	
	/**
	 * 
	 * @param dataSet
	 * @param conditions
	 * @return
	 */
	private String binding(String data, String conditions) {
		String[] condition = null;
		if(conditions.indexOf(",") > -1){
			condition =  conditions.split(",");
		}else{
			condition = new String[]{conditions};
		}
		
		for (int i = 0; i < condition.length; i++) {
			if(condition[i].indexOf("[EQUALS]") > -1){
				String[] dataCheck =  condition[i].split("\\[EQUALS\\]");
				if(dataCheck[0].trim().equals("null")){
					if(data == null || data.equals("")){
						data = dataCheck[1];
						break;
					}
				}else if(String.valueOf(data).trim().equals(dataCheck[0])){
					data = dataCheck[1];
					break;
				}
			}else if(condition[i].indexOf("[NOTEMPT-NOTEQUALS]") > -1){
				String[] dataCheck =  condition[i].split("\\[NOTEMPT-NOTEQUALS\\]");
				if(data != null && !data.isEmpty() && !data.trim().equals(dataCheck[0])){
					data = dataCheck[1];
					break;
				}
			}
		}
		return data;
	}
	
	/**
	 * 
	 * @param data
	 * @param conditions
	 * @return
	 */
	private String replaceAll(String data, String conditions) {
		String[] condition = null;
		if(conditions.indexOf("\\,") > -1){
			condition =  conditions.split("\\,");
		}else{
			condition = new String[]{conditions};
		}
		for (int i = 0; i < condition.length; i++) {
			String[] dataCheck =  condition[i].split("=");
			try{
				String changeData = "";
				if(dataCheck[0].length() == 2) changeData = dataCheck[1];
				if(data.indexOf(dataCheck[0]) > -1){
					data = data.replaceAll(dataCheck[0], changeData);
				}
			}catch(Exception e){
				log.error(e);
			}
		}
		return data;
	}
}
