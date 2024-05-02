/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EsdSce0049EventResponse.java
*@FileTitle : Exception Type & Subscriber Group Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2007-03-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0049 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0049 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author JeongSeon An
 * @see SC 참조
 * @since J2EE 1.4
 */
public class EsdSce0049EventResponse extends EventResponseSupport {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;
	
	// ResultSet Total Count
	private int totCnt;

	/**
	 * EsdSce0049EventResponse 객체를 생성
	 */
	public EsdSce0049EventResponse() {
	}

	/**
	 * EsdSce0049 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0049EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 */
	public EsdSce0049EventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * EsdSce0049 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0049EventResponse 객체를 생성
	 * 
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public EsdSce0049EventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}

    /**
     * EsdSce0049 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0049EventResponse 객체를 생성
     * 
     * @param DBRowSet rowSet
     * @param int totCnt
     * @param String successFlag
     * 
     */
    public EsdSce0049EventResponse(DBRowSet rowSet, int totCnt, String successFlag) {
        this.rowSet      = rowSet;
        this.totCnt      = totCnt ;
        this.successFlag = successFlag ;
    }	
	
	/**
	 * DB ResultSet 반환작업
	 * 
	 * @return DBRowSet 서버 실행 결과
	 */
	public DBRowSet getRowSet() {
		return this.rowSet;
	}
    /**
     * 총개수 반환작업
     * 
     * @return totCnt 총개수
     */
    public int getTotalCount() {
        return this.totCnt;
    }

	/**
	 * return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(EsdSce0049EventResponse)을 반환
	 * 
	 * @return String EsdSce0049EventResponse
	 */
	public String toString() {
		return "EsdSce0049EventResponse";
	}

	/**
	 * 이벤트 명(EsdSce0049EventResponse)을 반환
	 * 
	 * @return String EsdSce0049EventResponse
	 */
	public String getEventName() {
		return "EsdSce0049EventResponse";
	}

}