/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0115EventResponse.java
*@FileTitle : Manual Container Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-09 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0115 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0115 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Hun-Il Jung
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class EsdSce0115EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	/** Database ResultSet */
    private DBRowSet   rowSet;
    private DBRowSet   rowSetCate;
    /** Success Flag */
    private String successFlag;

    /**
     * EsdSce0115EventResponse 객체를 생성
     */
	public EsdSce0115EventResponse() { }

    /**
     * EsdSce0115 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0115EventResponse 객체를 생성
     *
     * @param DBRowSet rowSet
     */
    public EsdSce0115EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * EsdSce0115 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0115EventResponse 객체를 생성
     *
     * @param DBRowSet rowSet
     * @param String successFlag
     */
    public EsdSce0115EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }
    /**
     * EsdSce0115 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0115EventResponse 객체를 생성
     *
     * @param DBRowSet rowSet
     * @param DBRowSet rowSetCate
     */
    public EsdSce0115EventResponse(DBRowSet rowSet, DBRowSet rowSetCate) {
    	this.rowSet=rowSet;
    	this.rowSetCate=rowSetCate;
    }

    /**
     * DB ResultSet 반환작업
     *
     * @return DBRowSet 서버 실행 결과
     */
    public DBRowSet getRs() {
        return this.rowSet;
    }
    public DBRowSet getRsCate() {
    	return this.rowSetCate;
    }

    /**
     * return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    /**
     * 객체 표현 문자열(EsdSce0115EventResponse)을 반환
     *
     * @return String EsdSce0115EventResponse
     */
    public String toString() {
        return "EsdSce0115EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0115EventResponse)을 반환
     *
     * @return String EsdSce0115EventResponse
     */
    public String getEventName() {
        return "EsdSce0115EventResponse";
    }

}