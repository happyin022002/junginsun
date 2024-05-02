/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0063EventResponse.java
*@FileTitle : Vessel SKD조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-11
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-11 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;
 
import com.hanjin.bizcommon.BizCommonSC;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0063 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EsdSce0063 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Hyunsu, Ryu
 * @see BizCommonSC 참조
 * @since J2EE 1.4
 */
public class EsdSce0067EventResponse extends EventResponseSupport {

    // Database ResultSet
    private DBRowSet   rowSet;

    // Success Flag
    private String successFlag;

    /**
     * EsdSce0067EventResponse 객체를 생성
     */
    public EsdSce0067EventResponse() {
    }

    /**
     * EsdSce0067 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EsdSce0067EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     */
    public EsdSce0067EventResponse(DBRowSet rowSet) {
        this.rowSet = rowSet;
    }

    /**
     * EsdSce0067 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EsdSce0067EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdSce0067EventResponse(DBRowSet rowSet, String successFlag) {
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
     * SuccessFlg 반환<br>
     * @return 
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    /**
     * 객체 표현 문자열(EsdSce0067EventResponse)을 반환
     * 
     * @return String EsdSce0067EventResponse
     */
    public String toString() {
        return "EsdSce0067EventResponse";
    }

    /**
     * 이벤트 명(EsdSce0067EventResponse)을 반환
     * 
     * @return String EsdSce0067EventResponse
     */
    public String getEventName() {
        return "EsdSce0067EventResponse";
    }

}