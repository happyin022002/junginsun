/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTEvent.java
*@FileTitle : 공통업무 이벤트 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-20
*@LastModifier : junghyung kim
*@LastVersion : 1.0
* 2006-11-20 junghyung kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common.event;

import java.util.HashMap;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * AGTEvent 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author junghyung kim
 * @see CommonHTMLAction 참조
 * @since J2EE 1.4
 */
public class AGTEvent extends EventSupport {

	/**
	 * AGTEvent 생성자
	 */
	public AGTEvent(){}
	
	/**
	 * key에 해당하는 값을 String[]타입으로 리턴한다.
	 * 
	 * @param key
	 * @return String[]
	 */
	public String[] getObject(String key) {
		try{
			HashMap hMap = (HashMap)super.getAttribute("fRequest");
			return (String[])hMap.get(key);
		}catch(NullPointerException ne){
			return null;
		}
	}
	
	/**
	 * key에 해당하는 값을 String타입으로 리턴한다.
	 * 
	 * @param key
	 * @return String[]
	 */
	public String getString(String key) {
		try{
			HashMap hMap= (HashMap) super.getAttribute("fRequest");
			String[] arrString = (String[]) hMap.get(key);
			return (String) arrString[0];
		}catch(NullPointerException ne){
			return null;
		}
	}
	
	/**
	 * key에 해당하는 값을 Integer타입으로 리턴한다.
	 * 
	 * @param key
	 * @return Integer
	 */
	public Integer getInteger(String key) {
		if(key.equals("")) return null;
		
		HashMap hMap= (HashMap) super.getAttribute("fRequest");
		String[] arrString = (String[]) hMap.get(key);
		return Integer.getInteger(arrString[0]);
		
	}

	/**
	 * key에 해당하는 값을 Integer타입으로 리턴한다.
	 * 
	 * @param key
	 * @return int[]
	 */
	public int[] getInt(String key) {
		if(key.equals("")) return null;
		
		HashMap hMap= (HashMap) super.getAttribute("fRequest");
		String[] arrString = (String[]) hMap.get(key);
		int[] rtnResult = new int[arrString.length];
		
		for(int i=0; i<arrString.length; i++) {
			if("".equals(arrString[i].trim())) {
				rtnResult[i] = 0;
			} else {
				rtnResult[i] = Integer.parseInt(arrString[i]);
			}
		}
		
		return rtnResult;
	}

	/**
	 * key에 해당하는 값을 Integer타입으로 리턴한다.
	 * 
	 * @param key
	 * @return float[]
	 */
	public float[] getFloat(String key) {
		if(key.equals("")) return null;
		
		HashMap hMap= (HashMap) super.getAttribute("fRequest");
		String[] arrString = (String[]) hMap.get(key);
		float[] rtnResult = new float[arrString.length];
		
		for(int i=0; i<arrString.length; i++) {
			if("".equals(arrString[i].trim())) {
				rtnResult[i] = 0;
			} else {
				rtnResult[i] = Float.parseFloat(arrString[i]);
			}
		}
		
		return rtnResult;
	}

	/**
	 * 사용자 ID를 리턴한다
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String getUserId() throws EventException{
		return super.getSignOnUserAccount().getUsr_id();
	}
	
	/**
	 * 사용자 Name을 리턴한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String getUserNm() throws EventException {
		return super.getSignOnUserAccount().getUsr_nm();
	}
	
	/**
	 * 사용자 password를 리턴한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String getUserPwd() throws EventException {
		return super.getSignOnUserAccount().getUsr_pwd();
	}
	
	/**
	 * 사용자 ofc_cd를 리턴한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String getUserOfcCd() throws EventException {
		return super.getSignOnUserAccount().getOfc_cd();
	}
	
	/**
	 * 사용자 E-mail을 리턴한다.
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String getUserEml() throws EventException {
		return super.getSignOnUserAccount().getUsr_eml();
	}
	
	/**
	 *  Event 명을 반환한다.
	 *  
	 *  @return String
	 */
	public String getEventName() {
		return "AGTEvent";
	}

	/**
	 * Event 명을 반환한다.
	 * 
	 * @return String
	 */
	public String toString() {
		return "AGTEvent";
	}
	
}