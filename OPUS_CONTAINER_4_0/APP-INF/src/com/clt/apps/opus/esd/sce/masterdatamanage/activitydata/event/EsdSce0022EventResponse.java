/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0022EventResponse.java
*@FileTitle : Activity Attribute Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.event;

import com.clt.apps.opus.esd.sce.masterdatamanage.MasterDataManageSC;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0022 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0022 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Se-Hoon PARK
 * @see MasterDataManageSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0022EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	/** Database ResultSet */
    private DBRowSet   rowSet;
    /** Success Flag */
    private String successFlag;

    /**
     * EsdSce0022EventResponse 객체를 생성
     */
	public EsdSce0022EventResponse() { }

    /**
     * EsdSce0022 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0022EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0022EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * EsdSce0022 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0022EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0022EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet=rowSet;
        this.successFlag=successFlag;
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
     * return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    /**
     * 객체 표현 문자열(EsdSce0022EventResponse)을 반환
     * 
     * @return String EsdSce0022EventResponse
     */
    public String toString() {
        return "EsdSce0022EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0022EventResponse)을 반환
     * 
     * @return String EsdSce0022EventResponse
     */
    public String getEventName() {
        return "EsdSce0022EventResponse";
    }

}