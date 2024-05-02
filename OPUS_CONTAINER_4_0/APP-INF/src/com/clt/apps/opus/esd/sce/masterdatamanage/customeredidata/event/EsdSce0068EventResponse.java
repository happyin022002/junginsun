/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : EsdSce0068EventResponse.java
 *@FileTitle : EsdSce0068
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2008-03-26
 *@LastModifier : Sanghyun, kim
 *@LastVersion : 1.0
 * 2008-03-26 Sanghyun, kim
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import com.clt.bizcommon.BizCommonSC;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0068 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0068 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 * 
 * @author Hyunsu, Ryu
 * @see BizCommonSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0068EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;
	private DBRowSet rowSet;
	private String successFlag;

	public EsdSce0068EventResponse() {
	}

	/**
	 * EsdSce0068 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0068EventResponse 객체를
	 * 생성
	 * 
	 * @param rowSet
	 *            서버 실행 결과
	 */
	public EsdSce0068EventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * EsdSce0068 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아
	 * EsdSce0068EventResponse 객체를 생성
	 * 
	 * @param rowSet
	 *            서버 실행 결과
	 * @param successFlag
	 *            성공여부
	 */
	public EsdSce0068EventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet = rowSet;
		this.successFlag = successFlag;
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
	 * SuccessFlg 반환<br>
	 * 
	 * @return
	 */
	public String getSuccessFlag() {
		return this.successFlag;
	}

	/**
	 * 객체 표현 문자열(EsdSce0068EventResponse)을 반환
	 * 
	 * @return String EsdSce0068EventResponse
	 */
	public String toString() {
		return "EsdSce0068EventResponse";
	}

	/**
	 * 이벤트 명(EsdSce0068EventResponse)을 반환
	 * 
	 * @return String EsdSce0068EventResponse
	 */
	public String getEventName() {
		return "EsdSce0068EventResponse";
	}
}
