/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0021EventResponse.java
*@FileTitle : Rail Billing Request Inquiry Excel 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.RailBillingReqCreateRSC;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_021 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0021EventResponse extends GeneralEventResponse {
	
	private RailBillingInquiry[] railBillingInquiryList;
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0021EventResponse 객체를 생성
     */
    public ExpPap0021EventResponse() {
    }

    /**
     * EXP_PAP_021 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0021EventResponse 객체를 생성
     * @param railBillingInquiryList
     * @param successFlag
     */
    public ExpPap0021EventResponse(
    			RailBillingInquiry[] railBillingInquiryList,
    			String successFlag
    			) {
        this.railBillingInquiryList = railBillingInquiryList;
        this.successFlag = successFlag;
    }
    
	/**
	 * @return Returns the railBillingInquiryList.
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
     * 객체 표현 문자열(ExpPap0021EventResponse)을 반환
     * 
     * @return String ExpPap0021EventResponse
     */
    public String toString() {
        return "ExpPap0021EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0021EventResponse)을 반환
     * 
     * @return String ExpPap0021EventResponse
     */
    public String getEventName() {
        return "ExpPap0021EventResponse";
    }
}