/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingVerifyEventResponse.java
*@FileTitle : Rail Billing Verify
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event;

import java.util.ArrayList;
import java.util.Collection;
import com.clt.framework.core.layer.event.GeneralEventResponse;

import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.SPPComplementSC;
import com.clt.framework.component.rowset.DBRowSet;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Lee Sang-Woo
 * @see SPPComplementSC 참조
 * @since J2EE 1.4
 */
public class RailBillingVerifyEventResponse extends GeneralEventResponse {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String issuccessFlag;
	private int resultCount;
	private ArrayList arrSeq;

    // Success Flag
//    private String successFlag;
//    private RailBillingVerifyList[] railBillingVerifyList = null;
	private Collection models;	
	
    /**
     * RailBillingVerifyEventResponse 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0010EventResponse 객체를 생성
     * @param models
     * @param issuccessFlag
     */
    public RailBillingVerifyEventResponse(
    								Collection models,
    		                        String issuccessFlag) {
    	this.models = models;
        this.issuccessFlag=issuccessFlag;
    }
    
	/**
	 * TRSP models 반환작업
	 * 
	 * @return models 서버 실행 결과
	 */
	public Collection getModels() {
		return this.models;
	}   
    
	/**
	 * 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 RailBillingVerifyEventResponse 객체를 생성
	 * 
	 * @param arrSeq 서버 실행 결과
	 */
	public RailBillingVerifyEventResponse(ArrayList arrSeq) {
		this.arrSeq = arrSeq;
	}

	/**
	 * TRSP SO SEQ 반환작업
	 * 
	 * @return DBRowSet 서버 실행 결과
	 */
	public ArrayList getArrSeq() {
		return this.arrSeq;
	}	
		
	/**
	 * 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 InvoiceCancelEventResponse 객체를 생성
	 * 
	 * @param rowSet
	 * @param issuccessFlag
	 */
	public RailBillingVerifyEventResponse(DBRowSet rowSet, String issuccessFlag) {
		this.rowSet=rowSet;
		this.issuccessFlag=issuccessFlag;
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
	 * 이벤트 명(RailBillingCancelEventResponse)을 반환
	 * 
	 * @param issuccessFlag
	 */
	public RailBillingVerifyEventResponse(String issuccessFlag) {
		this.issuccessFlag=issuccessFlag;
	}

	/**
	 * @param resultCount
	 */
	public RailBillingVerifyEventResponse(int resultCount) {
		this.resultCount=resultCount;
	}

    /**
     * @return Modify Count
     */
    public int getResultCount() {
        return this.resultCount ;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }
      
	/**
	 * @return SuccessFlg
	 */
	public String getIsSuccessFlag() {
		return this.issuccessFlag ;
	}

	/**
	 * 객체 표현 문자열(RailBillingVerifyEventResponse)을 반환
	 * 
	 * @return String RailBillingVerifyEventResponse
	 */
	public String toString() {
		return "RailBillingVerifyEventResponse";
	}

	/**
	 * 이벤트 명(RailBillingVerifyEventResponse)을 반환
	 * 
	 * @return String RailBillingVerifyEventResponse
	 */
	public String getEventName() {
		return "RailBillingVerifyEventResponse";
	}
}