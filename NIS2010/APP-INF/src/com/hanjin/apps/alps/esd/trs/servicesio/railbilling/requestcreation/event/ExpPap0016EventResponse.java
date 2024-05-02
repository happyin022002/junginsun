/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0016EventResponse.java
*@FileTitle : Rail Billing Request Creation 조회 (Empty)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import com.hanjin.framework.core.layer.event.GeneralEventResponse;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_016 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0016EventResponse extends GeneralEventResponse {
	
	private LocationDetail[]  locationDetailList;
	private ContainerTypeSize[]  cntrTpSzList;
	private String  userFavFmNodCd;
	
    // Success Flag
    private String successFlag;
    
     /** 
     * ExpPap0016EventResponse 객체를 생성
     */
    public ExpPap0016EventResponse() {
    }

    /**
     * EXP_PAP_016 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0016EventResponse 객체를 생성
     * @param locationDetailList
     * @param cntrTpSzList
     * @param userFavFmNodCd
     * @param successFlag
     */
    public ExpPap0016EventResponse(LocationDetail[]  locationDetailList,
    								ContainerTypeSize[]  cntrTpSzList,
    								String  userFavFmNodCd,
    		                        String successFlag) {
    	this.locationDetailList = locationDetailList;
    	this.cntrTpSzList = cntrTpSzList;
    	this.userFavFmNodCd = userFavFmNodCd;
        this.successFlag=successFlag;
    }

	/**
	 * @return Returns the locationDetailList.
	 */
	public LocationDetail[] getLocationDetailList() {
		return locationDetailList;
	}
	
	/**
	 * @return Returns the cntrTpSzList.
	 */
	public ContainerTypeSize[] getCntrTpSzList() {
		return cntrTpSzList;
	}

	/**
     * @return SuccessFlg
     */
    public String getSuccessFlag() {
        return this.successFlag ;
    }
    
    /**
	 * @return Returns the userFavFmNodCd.
	 */
	public String getUserFavFmNodCd() {
		return userFavFmNodCd;
	}

	/**
     * 객체 표현 문자열(ExpPap0016EventResponse)을 반환
     * 
     * @return String ExpPap0016EventResponse
     */
    public String toString() {
        return "ExpPap0016EventResponse";
    }

    /**
     * 이벤트 명(ExpPap0016EventResponse)을 반환
     * 
     * @return String ExpPap0016EventResponse
     */
    public String getEventName() {
        return "ExpPap0016EventResponse";
    }
}