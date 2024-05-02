/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0112EventResponse.java
*@FileTitle : Exception Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-08-06 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

//import com.hanjin.syscommon.common.table.SCE_COP_EXPT_TP;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0112 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0112 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 * 
 * @author 2007811
 * @see HTMLAction 참조
 * @since J2EE 1.4
 *
 */
public class EsdSce0112EventResponse extends EventResponseSupport {

    /** Database ResultSet */
    private DBRowSet   rowSet;
    private DBRowSet   rowSetCate;
    /** Success Flag */
    private String successFlag;

    /**
     * EsdSce0112EventResponse 객체를 생성
     */
	public EsdSce0112EventResponse() { }

    /**
     * EsdSce0112 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0112EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0112EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * EsdSce0112 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0112EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0112EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }
    
    /**
     * Constructor
     * @param rowSet
     * @param rowSetCate
     */
    public EsdSce0112EventResponse(DBRowSet rowSet, DBRowSet rowSetCate) {
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
     * 객체 표현 문자열(EsdSce0112EventResponse)을 반환
     * 
     * @return String EsdSce0112EventResponse
     */
    public String toString() {
        return "EsdSce0112EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0112EventResponse)을 반환
     * 
     * @return String EsdSce0112EventResponse
     */
    public String getEventName() {
        return "EsdSce0112EventResponse";
    }

}