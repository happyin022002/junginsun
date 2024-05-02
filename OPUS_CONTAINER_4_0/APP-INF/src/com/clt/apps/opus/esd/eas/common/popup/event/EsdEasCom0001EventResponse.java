/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_COM_001EventResponse.java
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-27
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-27 yujin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.eas.common.popup.event;

import com.clt.apps.opus.esd.sce.common.CommonPopUpManageSC;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - ESD_EAS_COM_001 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - ESD_EAS_COM_001 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author yujin
 * @see CommonPopUpManageSC 참조
 * @since J2EE 1.4
 */
public class EsdEasCom0001EventResponse extends EventResponseSupport {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;

	/**
	 * ESD_EAS_COM_001EventResponse 객체를 생성
	 */
	public EsdEasCom0001EventResponse() {
	}

	/**
	 * ESD_EAS_COM_001 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ESD_EAS_COM_001EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public EsdEasCom0001EventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * ESD_EAS_COM_001 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ESD_EAS_COM_001EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public EsdEasCom0001EventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}

	/**
	 * DB ResultSet 반환작업
	 * 
	 * @return DBRowSet 서버 실행 결과
	 */
	public DBRowSet getRs() {
		return this.rowSet;
	}

	/**
	 * return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(ESD_EAS_COM_001EventResponse)을 반환
	 * 
	 * @return String ESD_EAS_COM_001EventResponse
	 */
	public String toString() {
		return "ESD_EAS_COM_001EventResponse";
	}

	/**
	 * 이벤트 명(ESD_EAS_COM_001EventResponse)을 반환
	 * 
	 * @return String ESD_EAS_COM_001EventResponse
	 */
	public String getEventName() {
		return "ESD_EAS_COM_001EventResponse";
	}

}