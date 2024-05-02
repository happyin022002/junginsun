/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_004EventResponse.java
*@FileTitle : Availability Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.availability.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.servicesio.common.document.AvailabilityList;
import com.clt.framework.support.layer.event.EventResponseSupport;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_004 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_004 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author juhyun
 * @see EXP_PAP_004SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0004EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	

	// Availability List
	private AvailabilityList[]	availabilitylist;
	
	// Availability List
	private EmptyAvailabilityInquiry[]	emptyAvailabilityInquiry;
	
    public EmptyAvailabilityInquiry[] getEmptyAvailabilityInquiry() {
		EmptyAvailabilityInquiry[] rtnVOs = null;
		if (this.emptyAvailabilityInquiry != null) {
			rtnVOs = Arrays.copyOf(this.emptyAvailabilityInquiry, this.emptyAvailabilityInquiry.length);
		} // end if
		return rtnVOs;
	}


	public void setEmptyAvailabilityInquiry(
			EmptyAvailabilityInquiry[] emptyAvailabilityInquiry) {
		if (emptyAvailabilityInquiry != null) {
			EmptyAvailabilityInquiry[] tmpVOs = Arrays.copyOf(emptyAvailabilityInquiry, emptyAvailabilityInquiry.length);
			this.emptyAvailabilityInquiry = tmpVOs;
		} // end if
	}
	
	public void setEmptyAvailabilityInquiry(
			EmptyAvailabilityInquiry[] emptyAvailabilityInquiry ,String successFlag) {
		if (emptyAvailabilityInquiry != null) {
			EmptyAvailabilityInquiry[] tmpVOs = Arrays.copyOf(emptyAvailabilityInquiry, emptyAvailabilityInquiry.length);
			this.emptyAvailabilityInquiry = tmpVOs;
		} // end if
		this.successFlag=successFlag;
	}

	// Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	
	/**
	 * EXP_PAP_004EventResponse 객체를 생성
	 */
	public ExpPap0004EventResponse() {
	}


   /**
     * EXP_PAP_004 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EXP_PAP_004EventResponse 객체를 생성
     * 
     * @param AvailabilityList 서버 실행 결과
     */
    public ExpPap0004EventResponse(AvailabilityList[] availabilitylist) {
        this.availabilitylist = availabilitylist;
    }

    /**
     * EXP_PAP_004 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EXP_PAP_004EventResponse 객체를 생성
     * 
     * @param AvailabilityList 서버 실행 결과
     * @param successFlag 성공여부
     */
    public ExpPap0004EventResponse(AvailabilityList[] availabilitylist, String successFlag) {
        this.availabilitylist = availabilitylist;
        this.successFlag=successFlag;
    }
    
    /**
     * EXP_PAP_004 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EXP_PAP_004EventResponse 객체를 생성
     * 
     * @param emptyAvailabilityInquiry 서버 실행 결과
     * @param successFlag 성공여부
     */
    public ExpPap0004EventResponse(EmptyAvailabilityInquiry[] emptyAvailabilityInquiry, String successFlag) {
        this.emptyAvailabilityInquiry = emptyAvailabilityInquiry;
        this.successFlag=successFlag;
    }

    /**
     * AvailabilityList 반환작업
     * 
     * @return AvailabilityList 서버 실행 결과
     */
    public AvailabilityList[] getAvailabilityList() {
        AvailabilityList[] rtnVOs = null;
		if (this.availabilitylist != null) {
			rtnVOs = Arrays.copyOf(this.availabilitylist, this.availabilitylist.length);
		} // end if
		return rtnVOs;
    }


	/**
	 * return SuccessFlg
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
	 * 객체 표현 문자열(EXP_PAP_004EventResponse)을 반환
	 * 
	 * @return String EXP_PAP_004EventResponse
	 */
	public String toString() {
		return "ExpPpa0004EventResponse";
	}

	/**
	 * 이벤트 명(EXP_PAP_004EventResponse)을 반환
	 * 
	 * @return String EXP_PAP_004EventResponse
	 */
	public String getEventName() {
		return "ExpPpa0004EventResponse";
	}

	
}