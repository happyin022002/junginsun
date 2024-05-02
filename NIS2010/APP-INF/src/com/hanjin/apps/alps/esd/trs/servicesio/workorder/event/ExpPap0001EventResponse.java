/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_001EventResponse.java
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
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxList;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_001 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_001 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author juhyun
 * @see EXP_PAP_001SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0001EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	

	// WorkOrder List
	private WorkOrderInboxList[]	workorderInboxlist;
	private WorkOrderInboxList	    workorderInbox;
	
    // Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	
	/**
	 * EXP_PAP_001EventResponse 객체를 생성
	 */
	public ExpPap0001EventResponse() {
	}


   /**
     * EXP_PAP_001 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EXP_PAP_001EventResponse 객체를 생성
     * 
     * @param WorkOrderInboxList 서버 실행 결과
     */
    public ExpPap0001EventResponse(WorkOrderInboxList[] workorderInboxlist) {
        this.workorderInboxlist = workorderInboxlist;
    }

    /**
     * EXP_PAP_001 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EXP_PAP_001EventResponse 객체를 생성
     * 
     * @param WorkOrderInboxList 서버 실행 결과
     * @param successFlag 성공여부
     */
    public ExpPap0001EventResponse(WorkOrderInboxList[] workorderInboxlist, String successFlag) {
        this.workorderInboxlist = workorderInboxlist;
        this.successFlag=successFlag;
    }

    /**
     * EXP_PAP_001 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EXP_PAP_001EventResponse 객체를 생성
     * 
     * @param workorderInboxlist  서버 실행 결과
     * @param workorderInbox
     * @param successFlag 성공여부
     */
    public ExpPap0001EventResponse(WorkOrderInboxList[] workorderInboxlist,WorkOrderInboxList workorderInbox, String successFlag) {
        this.workorderInboxlist = workorderInboxlist;
        this.workorderInbox = workorderInbox;
        this.successFlag=successFlag;
    }

    /**
     * WorkOrderInboxList 반환작업
     * 
     * @return WorkOrderInboxList 서버 실행 결과
     */
    public WorkOrderInboxList[] getWorkOrderInboxList() {
        WorkOrderInboxList[] rtnList = null;
		if(this.workorderInboxlist != null){
			rtnList = Arrays.copyOf(workorderInboxlist, workorderInboxlist.length);
		}
		return rtnList;
    }

    /**
     * WorkOrderInboxList 반환작업
     * 
     * @return WorkOrderInboxList 서버 실행 결과
     */
    public WorkOrderInboxList getWorkOrderInbox() {
        return this.workorderInbox;
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
	 * 객체 표현 문자열(EXP_PAP_001EventResponse)을 반환
	 * 
	 * @return String EXP_PAP_001EventResponse
	 */
	public String toString() {
		return "ExpPap0001EventResponse";
	}

	/**
	 * 이벤트 명(ExpPap0001EventResponse)을 반환
	 * 
	 * @return String ExpPap0001EventResponse
	 */
	public String getEventName() {
		return "ExpPap0001EventResponse";
	}

	
}