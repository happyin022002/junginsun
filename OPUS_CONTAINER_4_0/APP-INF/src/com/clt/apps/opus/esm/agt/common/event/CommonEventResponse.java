/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_013EventResponse.java
*@FileTitle : Brokerage Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-11 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.common.event;

import java.util.HashMap;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - ESM_AGT_013 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - ESM_AGT_013 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Hwang GyeongNam
 * @see AGTCommonSC 참조
 * @since J2EE 1.4
 */
public class CommonEventResponse extends EventResponseSupport {

	// Database ResultSet
	private DBRowSet   rowSet;
	
	private HashMap map;

	// Success Flag
	private String successFlag;

	/**
	 * CommonEventResponse 객체를 생성
	 */
	public CommonEventResponse() {
	}

	/**
	 * ESM_AGT_013 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 CommonEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public CommonEventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * ESM_AGT_013 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 CommonEventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public CommonEventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}

	/**
	 * ESM_AGT_013 요청을 처리한 서버 실행 결과( HashMap )를 담아 CommonEventResponse 객체를 생성
	 * 
	 * @param map 서버 실행 결과
	 */
	public CommonEventResponse(HashMap map) {
		this.map = map;
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
	 * DB HashMap 반환작업
	 * 
	 * @return HashMap 서버 실행 결과
	 */
	public HashMap getHashMap() {
		return this.map;
	}
	
	/**
	 * 성공여부를 반환
	 * 
	 * @return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(CommonEventResponse)을 반환
	 * 
	 * @return String CommonEventResponse
	 */
	public String toString() {
		return "CommonEventResponse";
	}

	/**
	 * 이벤트 명(CommonEventResponse)을 반환
	 * 
	 * @return String CommonEventResponse
	 */
	public String getEventName() {
		return "CommonEventResponse";
	}

}