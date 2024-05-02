/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0005EventResponse.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.1
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderMainList;
//import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderNewList;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_005 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_005 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author juhyun
 * @see EXP_PAP_005SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0005EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;

	private WorkOrderMainList[]	workordermainlist;
	private int newworkordercount = 0;
    private String successFlag;
    private int totalCount = 0;
    private int pendingInvoiceCount = 0;
    private int ackCount;
    
	/**
	 * @return Returns the ackCount.
	 */
	public int getAckCount() {
		return ackCount;
	}


	/**
	 * @param ackCount The ackCount to set.
	 */
	public void setAckCount(int ackCount) {
		this.ackCount = ackCount;
	}


	/**
	 * @return Returns the pendingInvoiceCount.
	 */
	public int getPendingInvoiceCount() {
		return pendingInvoiceCount;
	}


	/**
	 * @param pendingInvoiceCount The pendingInvoiceCount to set.
	 */
	public void setPendingInvoiceCount(int pendingInvoiceCount) {
		this.pendingInvoiceCount = pendingInvoiceCount;
	}


	/**
	 * ExpPap0005EventResponse 객체를 생성
	 */
	public ExpPap0005EventResponse() {
	}


   /**
     * EXP_PAP_005 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 ExpPap0005EventResponse 객체를 생성
     * 
     * @param WorkOrderMainList 서버 실행 결과
     */
    public ExpPap0005EventResponse(WorkOrderMainList[] workordermainlist) {
        this.workordermainlist = workordermainlist;
    }

    
    /**
     * EXP_PAP_005 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0005EventResponse 객체를 생성
     * 
     * @param WorkOrderMainList 서버 실행 결과
     * @param successFlag 성공여부
     */
    public ExpPap0005EventResponse(WorkOrderMainList[] workordermainlist, String successFlag) {
        this.workordermainlist = workordermainlist;
        this.successFlag=successFlag;
    }
    
 
    /**
     * WorkOrderMainList 반환작업
     * 
     * @return WorkOrderMainList 서버 실행 결과
     */
    public WorkOrderMainList[] getWorkOrderMainList() {
        WorkOrderMainList[] rtnList = null;
		if(this.workordermainlist != null){
			rtnList = Arrays.copyOf(workordermainlist, workordermainlist.length);
		}
		return rtnList;
    }

    
	/**
	 * @return 
	 */
	public int getNewWorkOrderCount() {
		return newworkordercount;
	}
	
	
	/**
	 * @param 
	 */
	public void setNewWorkOrderCount(int newworkordercount) {
		this.newworkordercount = newworkordercount;
	}


	/**
	 * @return SuccessFlg
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
	 * 객체 표현 문자열(ExpPap0005EventResponse)을 반환
	 * 
	 * @return String ExpPap0005EventResponse
	 */
	public String toString() {
		return "ExpPap0005EventResponse";
	}

	/**
	 * 이벤트 명(ExpPap0005EventResponse)을 반환
	 * 
	 * @return String ExpPap0005EventResponse
	 */
	public String getEventName() {
		return "ExpPap0005EventResponse";
	}

	
}