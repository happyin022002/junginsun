/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_TES_005EventResponse.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2007-01-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

import com.hanjin.framework.support.layer.event.EventResponseSupport;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceInquiryList;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - SPP_TES_005 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - SPP_TES_005 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author doomi
 * @see SPP_TES_005SC 참조
 * @since J2EE 1.4
 */
public class SppTes0005EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	

	// WorkOrder List
	private TerminalInvoiceInquiryList[]	terminalInvoiceInquirylist;
	
    // Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	
	/**
	 * SPP_TES_005EventResponse 객체를 생성
	 */
	public SppTes0005EventResponse() {
	}


   /**
     * SPP_TES_005 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 SPP_TES_005EventResponse 객체를 생성
     * 
     * @param TerminalInvoiceInquirylist 서버 실행 결과
     */
    public SppTes0005EventResponse(TerminalInvoiceInquiryList[] TerminalInvoiceInquirylist) {
        this.terminalInvoiceInquirylist = TerminalInvoiceInquirylist;
    }

    /**
     * SPP_TES_005 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 SPP_TES_005EventResponse 객체를 생성
     * 
     * @param TerminalInvoiceInquirylist 서버 실행 결과
     * @param successFlag 성공여부
     */
    public SppTes0005EventResponse(TerminalInvoiceInquiryList[] TerminalInvoiceInquirylist, String successFlag) {
        this.terminalInvoiceInquirylist = TerminalInvoiceInquirylist;
        this.successFlag=successFlag;
    }

    /**
     * TerminalInvoiceInquiryList 반환작업
     * 
     * @return TerminalInvoiceInquiryList 서버 실행 결과
     */
    public TerminalInvoiceInquiryList[] getTerminalInvoiceInquiryList() {
        return this.terminalInvoiceInquirylist;
    }


	/**
	 * @return String
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}



    /**
     * 전체 카운트를 저장
     * 
     * @param totalCount 전체 카운트
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    /**
     * @return totalCount
     */
    public int getTotalCount() {
        return this.totalCount ;
    }



	/**
	 * 객체 표현 문자열(SPP_TES_005EventResponse)을 반환
	 * 
	 * @return String SPP_TES_005EventResponse
	 */
	public String toString() {
		return "SPP_TES_005EventResponse";
	}

	/**
	 * 이벤트 명(SPP_TES_005EventResponse)을 반환
	 * 
	 * @return String SPP_TES_005EventResponse
	 */
	public String getEventName() {
		return "SPP_TES_005EventResponse";
	}

	
}