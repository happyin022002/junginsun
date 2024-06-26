/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0024EventResponse.java
*@FileTitle : COP Scheduling Logic Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0024 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0024 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Se-Hoon PARK
 * @see MasterDataManageSC 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0024EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;

	/** Database ResultSet */
    private DBRowSet   rowSet;

    /** Success Flag */
    private String successFlag;

    /**
     * EsdSce0024EventResponse 객체를 생성
     */
	public EsdSce0024EventResponse() { }

    /**
     * EsdSce0024 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0024EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0024EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * EsdSce0024 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0024EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0024EventResponse(DBRowSet rowSet, String successFlag) {
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
     * 객체 표현 문자열(EsdSce0024EventResponse)을 반환
     * 
     * @return String EsdSce0024EventResponse
     */
    public String toString() {
        return "EsdSce0024EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0024EventResponse)을 반환
     * 
     * @return String EsdSce0024EventResponse
     */
    public String getEventName() {
        return "EsdSce0024EventResponse";
    }

}