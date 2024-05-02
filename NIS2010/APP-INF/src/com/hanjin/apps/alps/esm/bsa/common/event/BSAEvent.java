/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: BSAEvent.java
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
* 2008.02.22 박은주 N200802200010 COA 조회 권한 관련 요청
*                  SELB로 시작하는 조직과 SELSC를 제외한 SEL로 시작하는 조직에에 COA REPORT에 대한 조회 권한부여
* 2008.05.13 박은주 N200805070003 COA_조회권한 관련 & Customized Condition 오류 수정 요청
*                  PHXSC = LGBBB, SLCSC = SEABB, SELSC = SELBB 즉 5레벨의 OFFICE가 4레벨의 OFFICE와 같은 권한을 주기 위해 OFC_LVL, OFC_CD에 예외처리
* 2008.07.21 박은주 N200807090016 SQ 산하의 조직이면서 SQ레벨의 office code를 리턴한다.
* 2008.08.07 박은주 N200808018416 PUSB로 시작하는 조직은 제외한 PUS로 시작하는 조직에게 SELHO 권한을 부여한다.
* 2008.08.07 박상희 N200808010005 PUSB로 시작하는 조직은 제외한 PUS로 시작하는 조직에게 SELHO 권한을 부여한다.
* 2008.12.10 전성진 CSR No.N200812090012 
* 					- HJSM 조직에 SELHO 권한을 부여한다.
* 2009.11.02 남궁진호 ALPS 전환 후 BSA모듈 분리에 따른 재생성
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.07.07 최윤성 [CHM-201111824] Split 07-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2015.03.27 김용습 [CHM-201534456] 2015년 1월 소스 보안 결함 건 조치 요청
* 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.common.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esm.bsa.common.Utils;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.event.EventSupport;

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
	
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Utils.class);
	
	/**
	 * BSAEvent 생성자 함수
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
	 * 사용자 비밀번호를 리턴한다.
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