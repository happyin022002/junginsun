/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0018EventResponse.java
*@FileTitle : Rail Billing Request Creation 처리 (Empty)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import com.clt.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_018 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0018EventResponse extends GeneralEventResponse {
	
	private Usa404EDISendVO ediSendInfo;
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0018EventResponse 객체를 생성
     */
    public ExpPap0018EventResponse() {
    }

    /**
     * EXP_PAP_018 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0018EventResponse 객체를 생성
     * @param ediSendInfo
     * @param successFlag
     */
    public ExpPap0018EventResponse(
    		Usa404EDISendVO ediSendInfo,
    		String successFlag) {
    	
        this.ediSendInfo=ediSendInfo;
        this.successFlag=successFlag;
    }
    
	/**
	 * @return Returns the ediSendInfo.
	 */
	public Usa404EDISendVO getEdiSendInfo() {
		return ediSendInfo;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0018EventResponse)을 반환
     * 
     * @return String ExpPap0018EventResponse
     */
    public String toString() {
        return "ExpPap0018EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0018EventResponse)을 반환
     * 
     * @return String ExpPap0018EventResponse
     */
    public String getEventName() {
        return "ExpPap0018EventResponse";
    }
}