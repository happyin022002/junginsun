/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_008EventResponse.java
*@FileTitle : Drop Off Charge Collection Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2008-01-30
*@LastModifier : ho-sam lee
*@LastVersion : 1.0
* 2008-01-30 ho-sam lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventResponseSupport;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_008EventResponse ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author ho-sam lee
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0010EventResponse extends EventResponseSupport {

    // Database ResultSet
    private DBRowSet rowSet;
    
    // Search Count
    private int totalCount ;

    // Success Flag
    private String successFlag;

    /**
     * ESD_EAS_008EventResponse 객체를 생성
     */
    public EsdEas0010EventResponse() {
    }

    /**
     * ESD_EAS_008 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ESD_EAS_008EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param totalCount 총 검색수
     * @param successFlag 성공여부
     */
    public EsdEas0010EventResponse(DBRowSet rowSet , int totalCount, String successFlag) {
        this.rowSet = rowSet;
        this.totalCount = totalCount ;
        this.successFlag = successFlag ;
    }

    /**
     * ESD_EAS_008 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ESD_EAS_008EventResponse 객체를 생성
     * 
     * @param rowSet 서버 실행 결과
     * @param successFlag 성공여부
     */
    public EsdEas0010EventResponse(DBRowSet rowSet, String successFlag) {
        this.rowSet = rowSet;
        this.successFlag = successFlag ;
    }
    
    /**
     * DBRowSet 반환작업
     * 
     * @return rowSet 서버 실행 결과
     */
    public DBRowSet getRowSet() {
        return this.rowSet;
    }
    
    /**
     * total count 반환작업
     * 
     * @return int 서버 실행 결과 개수
     */
    public int getTotalCount() {
        return this.totalCount;
    }

    /**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }

    /**
     * 객체 표현 문자열(ESD_EAS_008EventResponse)을 반환
     * 
     * @return String ESD_EAS_008EventResponse
     */
    public String toString() {
        return "ESD_EAS_008EventResponse";
    }

    /**
     * 이벤트 명(ESD_EAS_008EventResponse)을 반환
     * 
     * @return String ESD_EAS_008EventResponse
     */
    public String getEventName() {
        return "ESD_EAS_008EventResponse";
    }

	/**
	 * @param successFlag The successFlag to set.
	 */
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

}
