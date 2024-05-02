/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0003EventResponse.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.FillInEquipmentNoList;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_003 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_003 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author juhyun
 * @see EXP_PAP_003SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0003EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	

	// WorkOrder Detail List
	private FillInEquipmentNoList[]	fillInEquipmentNoList;
	
    // Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	
	/**
	 * ExpPap0003EventResponse 객체를 생성
	 */
	public ExpPap0003EventResponse() {
	}


   /**
     * EXP_PAP_003 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ExpPap0003EventResponse 객체를 생성
     * 
     * @param FillInEquipmentNoList 서버 실행 결과
     */
    public ExpPap0003EventResponse(FillInEquipmentNoList[] FillInEquipmentNoList) {
        this.fillInEquipmentNoList = FillInEquipmentNoList;
    }

    /**
     * EXP_PAP_003 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0003EventResponse 객체를 생성
     * 
     * @param FillInEquipmentNoList 서버 실행 결과
     * @param successFlag 성공여부
     */
    public ExpPap0003EventResponse(FillInEquipmentNoList[] FillInEquipmentNoList, String successFlag) {
        this.fillInEquipmentNoList = FillInEquipmentNoList;
        this.successFlag=successFlag;
    }
 
    /**
     * FillInEquipmentNoList 반환작업
     * 
     * @return FillInEquipmentNoList 서버 실행 결과
     */
    public FillInEquipmentNoList[] getFillInEquipmentNoList() {
        FillInEquipmentNoList[] rtnList = null;
		if(this.fillInEquipmentNoList != null){
			rtnList = Arrays.copyOf(fillInEquipmentNoList, fillInEquipmentNoList.length);
		}
		return rtnList;
    }

	public void setFillInEquipmentNoList(FillInEquipmentNoList[] FillInEquipmentNoList) {
		if(FillInEquipmentNoList != null){
			FillInEquipmentNoList[] tmpList = Arrays.copyOf(FillInEquipmentNoList, FillInEquipmentNoList.length);
			this.fillInEquipmentNoList = tmpList;
		}
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
	 * 객체 표현 문자열(ExpPap0003EventResponse)을 반환
	 * 
	 * @return String ExpPap0003EventResponse
	 */
	public String toString() {
		return "ExpPap0003EventResponse";
	}

	/**
	 * 이벤트 명(ExpPap0003EventResponse)을 반환
	 * 
	 * @return String ExpPap0003EventResponse
	 */
	public String getEventName() {
		return "ExpPap0003EventResponse";
	}

	
}