/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0019EventResponse.java
*@FileTitle : Rail Billing Common 조회 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.railbillingcommon.event;

import com.hanjin.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - ExpPap0019 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0019EventResponse extends GeneralEventResponse {
	
	private int ackCount;
	
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0019EventResponse 객체를 생성
     */
    public ExpPap0019EventResponse() {
    }

    /**
     * EXP_PAP_019 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0019EventResponse 객체를 생성
     * @param ackCount
     * @param successFlag
     */
    public ExpPap0019EventResponse(int ackCount,
    		                        String successFlag) {
    	this.ackCount = ackCount;
        this.successFlag=successFlag;
    }

    /**
     * 
     * @return
     */
	public int getAckCount() {
		return ackCount;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0019EventResponse)을 반환
     * 
     * @return String ExpPap0019EventResponse
     */
    public String toString() {
        return "ExpPap0019EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0019EventResponse)을 반환
     * 
     * @return String ExpPap0019EventResponse
     */
    public String getEventName() {
        return "ExpPap0019EventResponse";
    }
}