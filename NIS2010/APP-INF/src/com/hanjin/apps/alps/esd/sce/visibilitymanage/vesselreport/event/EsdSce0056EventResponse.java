/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0056EventResponse.java
*@FileTitle : Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-jung Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0056 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0056 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Jeong-Seon An , Yoon-Jung Lee
 * @see ExceptionManageSC 참조
 * @since J2EE 1.4
 */
public class EsdSce0056EventResponse extends EventResponseSupport {

    private DBRowSet rowSet;
    private int      totCnt ;

    /**
     * EsdSce0056EventResponse 객체를 생성
     */
    public EsdSce0056EventResponse() {
    }

    /**
     * EsdSce0056 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0056EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0056EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * EsdSce0056 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0056EventResponse 객체를 생성
     * 
     * @param int totCnt
     */
    public EsdSce0056EventResponse(int totCnt) {
    	this.totCnt = totCnt;
    }

    /**
     * EsdSce0056 요청을 처리한 서버 실행 결과(DB ResultSet)와 정보(DataSet)를 담아<br>
     * EsdSce0056EventResponse 객체를 생성
     * 
     * @param DBRowSet rowSet
     * @param int totCnt
     */
    public EsdSce0056EventResponse(DBRowSet rowSet, int totCnt) {
        this.rowSet = rowSet;
        this.totCnt = totCnt;
    }
    
    /**
     * DB ResultSet 반환작업
     * 
     * @return DBRowSet 서버 실행 결과
     */
    public void setRowSet(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }
    
    /**
     * DB ResultSet 반환작업
     * 
     * @return DBRowSet 서버 실행 결과
     */
    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
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
     * @return dataSet 서버 실행 정보
     */
    public int getTotalCount() {
        return this.totCnt;
    }

    /**
     * 객체 표현 문자열(EsdSce0056EventResponse)을 반환
     * 
     * @return String EsdSce0056EventResponse
     */
    public String toString() {
        return "EsdSce0056EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0056EventResponse)을 반환
     * 
     * @return String EsdSce0056EventResponse
     */
    public String getEventName() {
        return "EsdSce0056EventResponse";
    }

}