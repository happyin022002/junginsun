/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TPBCommonCodeEventResponse.java
*@FileTitle : 3자구상 유형등록
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-09
*@LastModifier : Youngchang_Kim
*@LastVersion : 1.0
* 2006-10-09 Youngchang_Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - TPBCommonCode 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - TPBCommonCode 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Youngchang_Kim
 * @see TPBCodeManageSC 참조
 * @since J2EE 1.4
 */
public class CommonCodeEventResponse extends EventResponseSupport {
	
	private static final long serialVersionUID = 1L;
	
	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;

	/**
	 * TPBCommonCodeEventResponse 객체를 생성
	 */
	public CommonCodeEventResponse() {
	}

	/**
	 * TPBCommonCode 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 TPBCommonCodeEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public CommonCodeEventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * TPBCommonCode 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 TPBCommonCodeEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public CommonCodeEventResponse(DBRowSet rowSet, String successFlag) {
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
	 * @return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(TPBCommonCodeEventResponse)을 반환
	 * 
	 * @return String TPBCommonCodeEventResponse
	 */
	public String toString() {
		return "TPBCommonCodeEventResponse";
	}

	/**
	 * 이벤트 명(TPBCommonCodeEventResponse)을 반환
	 * 
	 * @return String TPBCommonCodeEventResponse
	 */
	public String getEventName() {
		return "TPBCommonCodeEventResponse";
	}

}