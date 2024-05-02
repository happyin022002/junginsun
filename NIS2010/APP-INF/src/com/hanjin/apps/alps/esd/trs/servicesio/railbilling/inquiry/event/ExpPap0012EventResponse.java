/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0012EventResponse.java
*@FileTitle : Rail Billing Inquiry 조회 (Full)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.RailBillingInquiryRSC;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_012 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingInquiryRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0012EventResponse extends GeneralEventResponse {
	
	private RailBillingInquiry[] railBillingInquiryList;
	
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0012EventResponse 객체를 생성
     */
    public ExpPap0012EventResponse() {
    }

    /**
     * EXP_PAP_012 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0012EventResponse 객체를 생성
     * @param railBillingInquiryList
     * @param successFlag
     */
    public ExpPap0012EventResponse(RailBillingInquiry[] railBillingInquiryList,
    		                        String successFlag) {
    	this.railBillingInquiryList = railBillingInquiryList;
        this.successFlag=successFlag;
    }
    /**
     * 
     * @return
     */
	public RailBillingInquiry[] getRailBillingInquiryList() {
		return railBillingInquiryList;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0012EventResponse)을 반환
     * 
     * @return String ExpPap0012EventResponse
     */
    public String toString() {
        return "ExpPap0012EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0012EventResponse)을 반환
     * 
     * @return String ExpPap0012EventResponse
     */
    public String getEventName() {
        return "ExpPap0012EventResponse";
    }
}