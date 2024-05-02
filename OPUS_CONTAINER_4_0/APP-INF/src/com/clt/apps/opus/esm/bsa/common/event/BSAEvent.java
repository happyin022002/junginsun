/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: COAEvent.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-11-16 Park Eun Ju
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bsa.common.event;

import java.util.HashMap;

import com.clt.apps.opus.esm.bsa.common.Utils;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *
 * @author Park Eun Ju
 * @see    HTMLAction 참조
 * @since  J2EE 1.4
 */
@SuppressWarnings("serial")
public class BSAEvent extends EventSupport {
	private String errCd;
	private String errMsg;
//	Logger log =Logger.getLogger(this.getClass());			//SJH.20150508.소스품질
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Utils.class); 		//20150522.소스품질.2차
	
	/**
	 * COAEvent 생성자 함수
	 *
	 */
	public BSAEvent(){
		//
	}
	
	/**
	 * key에 해당하는 값을 String[]타입으로 리턴한다.
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String[] getObject(String key) {
		try{
			HashMap hMap = (HashMap)super.getAttribute("fRequest");
			return (String[])hMap.get(key);
		}catch(NullPointerException ne){
			log.error("err " + ne.toString(), ne);
			return null;
		}
	}
	
	/**
	 * key에 해당하는 값을 String타입으로 리턴한다.
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getString(String key) {
		try{
			HashMap hMap= (HashMap) super.getAttribute("fRequest");
			String[] arrString = (String[]) hMap.get(key);
			return (String) arrString[0];
		}catch(NullPointerException ne){
			log.error("err " + ne.toString(), ne);
			return null;
		}
	}
	
	/**
	 * key에 해당하는 값을 Integer타입으로 리턴한다.
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
	 * @return
	 * @throws EventException
	 */
	public String getUserId() throws EventException{
		return super.getSignOnUserAccount().getUsr_id();
	}
	
	/**
	 * 사용자 Name을 리턴한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String getUserNm() throws EventException {
		return super.getSignOnUserAccount().getUsr_nm();
	}
	
	/**
	 * 사용자 비.밀.번.호를 리턴한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String getUserPwd() throws EventException {
		return super.getSignOnUserAccount().getUsr_pwd();
	}
	
	/**
	 * 사용자 office code 을 리턴한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String getUserOffice() throws EventException {
		return super.getSignOnUserAccount().getOfc_cd();
	}
	
	/**
	 * 사용자 E-mail을 리턴한다.
	 * 
	 * @return
	 * @throws EventException
	 */
	public String getUserEml() throws EventException {
		return super.getSignOnUserAccount().getUsr_eml();
	}
	
	/**
	 * 에러코드를 세팅한다
	 * @param code
	 */
	public void setErrorCode(String code){
		this.errCd = code;
	}
	
	/**
	 * 에러메시지를 세팅한다.
	 * @param msg
	 */
	public void setErrorMsg(String msg){
		this.errMsg = msg;
	}
	
	/**
	 * 에러코드를 반환한다.
	 * @return
	 */
	public String getErrorCode(){
		return this.errCd;
	}
	
	/**
	 * 에러메시지를 반환한다.
	 * @return
	 */
	public String getErrorMsg(){
		return this.errMsg;
	}
	
	/**
	 *  Event 명을 반환한다.
	 */
	public String getEventName() {
		return "BSAEvent";
	}

	/**
	 * Event 명을 반환한다.
	 */
	public String toString() {
		return "BSAEvent";
	}
	
}