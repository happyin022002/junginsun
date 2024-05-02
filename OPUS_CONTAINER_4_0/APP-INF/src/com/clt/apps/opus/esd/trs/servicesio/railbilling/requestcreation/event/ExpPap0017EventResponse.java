/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0017EventResponse.java
*@FileTitle : Rail Billing Request Creation Verify 조회 (Empty)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Arrays;

import com.clt.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_017 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0017EventResponse extends GeneralEventResponse {
	
	private EmptyContainer[] emptyContainerList;
	
    // Success Flag
    private String successFlag;
    
     /**
     * ExpPap0017EventResponse 객체를 생성
     */
    public ExpPap0017EventResponse() {
    }

    /**
     * EXP_PAP_017 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0017EventResponse 객체를 생성
     * @param emptyContainerList
     * @param successFlag
     */
    public ExpPap0017EventResponse(EmptyContainer[] emptyContainerList,
    		                        String successFlag) {
    	this.emptyContainerList = emptyContainerList;
        this.successFlag=successFlag;
    }
    /**
     * 
     * @return
     */
	public EmptyContainer[] getEmptyContainerList() {
		EmptyContainer[] rtnList = null;
		if(this.emptyContainerList != null){
			rtnList = Arrays.copyOf(emptyContainerList, emptyContainerList.length);
		}
		return rtnList;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
     * 객체 표현 문자열(ExpPap0017EventResponse)을 반환
     * 
     * @return String ExpPap0017EventResponse
     */
    public String toString() {
        return "ExpPap0017EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0017EventResponse)을 반환
     * 
     * @return String ExpPap0017EventResponse
     */
    public String getEventName() {
        return "ExpPap0017EventResponse";
    }
}