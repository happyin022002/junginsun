/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: MASEvent.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-11-16 Park Eun Ju
* 1.0 최초 생성
* =============================================================
* History
* 2008.02.22 박은주 N200802200010 MAS 조회 권한 관련 요청
*                  SELB로 시작하는 조직과 SELSC를 제외한 SEL로 시작하는 조직에에 MAS REPORT에 대한 조회 권한부여
* 2008.05.13 박은주 N200805070003 MAS_조회권한 관련 & Customized Condition 오류 수정 요청
*                  PHXSC = LGBBB, SLCSC = SEABB, SELSC = SELBB 즉 5레벨의 OFFICE가 4레벨의 OFFICE와 같은 권한을 주기 위해 OFC_LVL, OFC_CD에 예외처리
* 2008.07.21 박은주 N200807090016 SQ 산하의 조직이면서 SQ레벨의 office code를 리턴한다.
* 2008.08.07 박은주 N200808018416 PUSB로 시작하는 조직은 제외한 PUS로 시작하는 조직에게 SELHO 권한을 부여한다.
* 2008.08.07 박상희 N200808010005 PUSB로 시작하는 조직은 제외한 PUS로 시작하는 조직에게 SELHO 권한을 부여한다.
* 2008.12.10 전성진 CSR No.N200812090012 
* 					- HJSM 조직에 SELHO 권한을 부여한다.
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.07.13 최성민 [CHM-201111826] R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 *
 * @author Park Eun Ju
 * @see    HTMLAction 참조
 * @since  J2EE 1.4
 */
public class MASEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Utils.class);
	
	private String errCd;
	private String errMsg;
	
	/**
	 * MASEvent 생성자 함수
	 *
	 */
	public MASEvent(){
		//
	}
	
	/**
	 * key에 해당하는 값을 String[]타입으로 리턴한다.
	 * 
	 * @param key
	 * @return
	 */
	public String[] getObject(String key) {
		try{
			HashMap hMap = (HashMap)super.getAttribute("fRequest");
			return (String[])hMap.get(key);
		}catch(NullPointerException ne){
			log.error(ne.toString(), ne);
			return null;
		}
	}
	
	/**
	 * key에 해당하는 값을 String타입으로 리턴한다.
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		try{
			HashMap hMap= (HashMap) super.getAttribute("fRequest");
			String[] arrString = (String[]) hMap.get(key);
			return (String) arrString[0];
		}catch(NullPointerException ne){
			log.error(ne.toString(), ne);
			return null;
		}
	}
	
	/**
	 * key에 해당하는 값을 Integer타입으로 리턴한다.
	 * 
	 * @param key
	 * @return
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
	 * @return
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
	 * @return
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
	 * 사용자 password를 리턴한다.
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
		return "MASEvent";
	}

	/**
	 * Event 명을 반환한다.
	 */
	public String toString() {
		return "MASEvent";
	}
	
}