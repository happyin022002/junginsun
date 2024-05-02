/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdPrd0083EventResponse.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-09
*@LastModifier : J.Lee
*@LastVersion : 1.0
* 2006-11-09 J.Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - ESD_PRD_0083 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - ESD_PRD_0083 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author J.Lee
 * @see NetworkNodeManageSC 참조
 * @since J2EE 1.4
 */
public class EsdPrd0083EventResponse extends EventResponseSupport {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;

	/**
	 * EsdPrd0083EventResponse 객체를 생성
	 */
	public EsdPrd0083EventResponse() {
	}

	/**
	 * ESD_PRD_0083 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdPrd0083EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public EsdPrd0083EventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * ESD_PRD_0083 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdPrd0083EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public EsdPrd0083EventResponse(DBRowSet rowSet, String successFlag) {
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
	 * 객체 표현 문자열(EsdPrd0083EventResponse)을 반환
	 * 
	 * @return String EsdPrd0083EventResponse
	 */
	public String toString() {
		return "EsdPrd0083EventResponse";
	}

	/**
	 * 이벤트 명(EsdPrd0083EventResponse)을 반환
	 * 
	 * @return String EsdPrd0083EventResponse
	 */
	public String getEventName() {
		return "EsdPrd0083EventResponse";
	}

}