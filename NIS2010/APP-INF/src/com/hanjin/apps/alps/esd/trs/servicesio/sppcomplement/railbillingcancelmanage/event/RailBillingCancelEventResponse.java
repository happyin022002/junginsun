/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingCancelEventResponse.java
*@FileTitle : Rail Billing Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event;

import java.util.ArrayList;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Lee Sang-Woo
 * @see SPPComplementSC 참조
 * @since J2EE 1.4
 */
public class RailBillingCancelEventResponse extends GeneralEventResponse {

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private boolean successFlag = false;
	private int resultCount;
	private ArrayList arrSeq;

	/**
	 * 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 InvoiceCancelEventResponse 객체를 생성
	 * 
	 * @param arrSeq 서버 실행 결과
	 */
	public RailBillingCancelEventResponse(ArrayList arrSeq) {
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
	 * @param rowSet 서버 실행 결과
	 * @param successFlag 성공여부
	 */
	public RailBillingCancelEventResponse(DBRowSet rowSet, boolean successFlag) {
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
	 * 이벤트 명(RailBillingCancelEventResponse)을 반환
	 * 
	 * @param successFlag boolean
	 * @return ArrayList RailBillingCancelEventResponse
	 */	
	public RailBillingCancelEventResponse(boolean successFlag) {
		this.successFlag=successFlag;
	}

	/**
	 * @param resultCount
	 */
	public RailBillingCancelEventResponse(int resultCount) {
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
	public boolean getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * 객체 표현 문자열(RailBillingCancelEventResponse)을 반환
	 * 
	 * @return String RailBillingCancelEventResponse
	 */
	public String toString() {
		return "RailBillingCancelEventResponse";
	}

	/**
	 * 이벤트 명(RailBillingCancelEventResponse)을 반환
	 * 
	 * @return String RailBillingCancelEventResponse
	 */
	public String getEventName() {
		return "RailBillingCancelEventResponse";
	}
}