/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0013EventResponse.java
*@FileTitle : Rail Billing Request Cancel 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event;

import com.clt.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_013 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0013EventResponse extends GeneralEventResponse {
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0013EventResponse 객체를 생성
     */
    public ExpPap0013EventResponse() {
    }

    /**
     * EXP_PAP_013 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0013EventResponse 객체를 생성
     * @param successFlag
     */
    public ExpPap0013EventResponse(String successFlag) {
        this.successFlag=successFlag;
    }

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0013EventResponse)을 반환
     * 
     * @return String ExpPap0013EventResponse
     */
    public String toString() {
        return "ExpPap0013EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0013EventResponse)을 반환
     * 
     * @return String ExpPap0013EventResponse
     */
    public String getEventName() {
        return "ExpPap0013EventResponse";
    }
}