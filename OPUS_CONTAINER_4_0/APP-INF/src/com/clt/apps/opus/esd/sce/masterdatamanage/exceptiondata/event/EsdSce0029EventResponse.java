/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_EsdSce0029EventResponse.java
*@FileTitle : Exception 식별 기준 등록 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-04
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-04 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - UI_EsdSce0029 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - UI_EsdSce0029 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author yongcheon_shin
 * @see MasterDataManageSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0029EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;

    // Database ResultSet
    private DBRowSet   rowSet;

    // Success Flag
    private String successFlag;

    // MultiTolerance Flag
    private int multiTolFlag;
    
    private int totCnt;
    
    /**
     * UI_EsdSce0029EventResponse 객체를 생성
     */
    public EsdSce0029EventResponse() {
    }

    /**
     * UI_EsdSce0029 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 UI_EsdSce0029EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0029EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * UI_EsdSce0029 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 UI_EsdSce0029EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0029EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
    }

    /**
     * Constructor
     * @param rowSet
     * @param totCnt
     * @param successFlag
     */
    public EsdSce0029EventResponse(DBRowSet rowSet, int totCnt, String successFlag) {
        this.rowSet      = rowSet;
        this.totCnt      = totCnt ;
        this.successFlag = successFlag ;
    }	
    
    /**
     * Constructor
     * @param multiTolFlag
     * @param successFlag
     */
    public EsdSce0029EventResponse(int multiTolFlag, String successFlag) {
        this.multiTolFlag=multiTolFlag;
        this.successFlag=successFlag;
    }

    /**
	 * @return Returns the rowSet.
	 */
	public DBRowSet getRowSet() {
		return rowSet;
	}
    
    /**
     * return MultiTolerance Flag
     */
    public int getMultiTolFlag() {
        return this.multiTolFlag ;
    }

    /**
     * return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
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
     * 객체 표현 문자열(UI_EsdSce0029EventResponse)을 반환
     * 
     * @return String UI_EsdSce0029EventResponse
     */
    public String toString() {
        return "EsdSce0029EventResponse";
    }

    /**
     * 이벤트 명(UI_EsdSce0029EventResponse)을 반환
     * 
     * @return String UI_EsdSce0029EventResponse
     */
    public String getEventName() {
        return "EsdSce0029EventResponse";
    }

}