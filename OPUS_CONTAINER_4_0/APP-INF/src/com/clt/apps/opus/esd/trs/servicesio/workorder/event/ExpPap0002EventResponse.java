/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_002EventResponse.java
*@FileTitle : WO Detail Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-10
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.event;


import java.util.Arrays;

import com.clt.framework.support.layer.event.EventResponseSupport;
import com.clt.apps.opus.esd.trs.servicesio.common.document.WorkOrderDetailTitle;
import com.clt.apps.opus.esd.trs.servicesio.common.document.WorkOrderDetail;
import com.clt.apps.opus.esd.trs.servicesio.common.document.WorkOrderDetailList;
import com.clt.apps.opus.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadList;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_002 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_002 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author doomi
 * @see EXP_PAP_002SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0002EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	
	
	private WorkOrderDetail	workOrderDetail;
	private WorkOrderDetailTitle	workOrderDetailTitle;
	private WorkOrderDetailList[]	workOrderDetailList;
	private WorkOrderDetailExcelUploadList[]	workOrderDetailExcelUploadList;
	
	
    // Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	//modify count
    private int count = 0;

    
	/**
	 * EXP_PAP_002EventResponse 객체를 생성
	 */
	public ExpPap0002EventResponse() {
	}


   /**
     * EXP_PAP_002 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EXP_PAP_002EventResponse 객체를 생성
     * 
     * @param workOrderDetailList
     */
    public ExpPap0002EventResponse(WorkOrderDetailList[] workOrderDetailList) {
        this.workOrderDetailList = workOrderDetailList;
    }

    /**
     * EXP_PAP_002EventResponse 객체를 생성
     * @param workOrderDetail
     */
    public ExpPap0002EventResponse(WorkOrderDetail workOrderDetail) {
        this.workOrderDetail = workOrderDetail;
    }
    
    /**
     * EXP_PAP_002EventResponse 객체를 생성
     * @param workOrderDetailTitle
     */
    public ExpPap0002EventResponse(WorkOrderDetailTitle workOrderDetailTitle) {
        this.workOrderDetailTitle = workOrderDetailTitle;
    }

    /**
     * EXP_PAP_002EventResponse 객체를 생성
     * @param workOrderDetailExcelUploadList
     */
    public ExpPap0002EventResponse(WorkOrderDetailExcelUploadList[] workOrderDetailExcelUploadList) {
        this.workOrderDetailExcelUploadList = workOrderDetailExcelUploadList;
    }

    
    /**
     * EXP_PAP_002 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 EXP_PAP_002EventResponse 객체를 생성
     * 
     * @param workOrderDetailList
     * @param successFlag
     */
    public ExpPap0002EventResponse(WorkOrderDetailList[] workOrderDetailList, String successFlag) {
        this.workOrderDetailList = workOrderDetailList;
        this.successFlag=successFlag;
    }

    /**
     * EXP_PAP_002EventResponse 객체를 생성
     * @param workOrderDetail
     * @param successFlag
     */
    public ExpPap0002EventResponse(WorkOrderDetail workOrderDetail, String successFlag) {
        this.workOrderDetail = workOrderDetail;
        this.successFlag=successFlag;
    }
 
    /**
     * EXP_PAP_002EventResponse 객체를 생성
     * @param workOrderDetailTitle
     * @param successFlag
     */
    public ExpPap0002EventResponse(WorkOrderDetailTitle workOrderDetailTitle, String successFlag) {
        this.workOrderDetailTitle = workOrderDetailTitle;
        this.successFlag=successFlag;
    }

    /**
     * EXP_PAP_002EventResponse 객체를 생성
     * @param workOrderDetailExcelUploadList
     * @param successFlag
     */
    public ExpPap0002EventResponse(WorkOrderDetailExcelUploadList[] workOrderDetailExcelUploadList, String successFlag) {
        this.workOrderDetailExcelUploadList = workOrderDetailExcelUploadList;
        this.successFlag=successFlag;
    }
  

	
	
	/**
	 * return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}


	/**
	 * @param successFlag 설정하려는 successFlag입니다.
	 */
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
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
     * @return Modify Count
     */
    public int getCount() {
        return this.count ;
    }

    public void setCount(int count) {
        this.count = count;
    }
    

	/**
	 * 객체 표현 문자열(EXP_PAP_002EventResponse)을 반환
	 * 
	 * @return String EXP_PAP_002EventResponse
	 */
	public String toString() {
		return "ExpPap0002EventResponse";
	}

	/**
	 * 이벤트 명(ExpPap0002EventResponse)을 반환
	 * 
	 * @return String ExpPap0002EventResponse
	 */
	public String getEventName() {
		return "ExpPap0002EventResponse";
	}


	/**
	 * @return serialVersionUID을 리턴합니다.
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	/**
	 * @return workOrderDetail을 리턴합니다.
	 */
	public WorkOrderDetail getWorkOrderDetail() {
		return workOrderDetail;
	}


	/**
	 * @param workOrderDetail 설정하려는 workOrderDetail입니다.
	 */
	public void setWorkOrderDetail(WorkOrderDetail workOrderDetail) {
		this.workOrderDetail = workOrderDetail;
	}


	/**
	 * @return workOrderDetailExcelUploadList을 리턴합니다.
	 */
	public WorkOrderDetailExcelUploadList[] getWorkOrderDetailExcelUploadList() {
		WorkOrderDetailExcelUploadList[] rtnList = null;
		if(this.workOrderDetailExcelUploadList != null){
			rtnList = Arrays.copyOf(workOrderDetailExcelUploadList, workOrderDetailExcelUploadList.length);
		}
		return rtnList;
	}


	/**
	 * @param workOrderDetailExcelUploadList 설정하려는 workOrderDetailExcelUploadList입니다.
	 */
	public void setWorkOrderDetailExcelUploadList(WorkOrderDetailExcelUploadList[] workOrderDetailExcelUploadList) {
		if(workOrderDetailExcelUploadList != null){
			WorkOrderDetailExcelUploadList[] tmpList = Arrays.copyOf(workOrderDetailExcelUploadList, workOrderDetailExcelUploadList.length);
			this.workOrderDetailExcelUploadList = tmpList;
		}
	}


	/**
	 * @return workOrderDetailList을 리턴합니다.
	 */
	public WorkOrderDetailList[] getWorkOrderDetailList() {
		WorkOrderDetailList[] rtnList = null;
		if(this.workOrderDetailList != null){
			rtnList = Arrays.copyOf(workOrderDetailList, workOrderDetailList.length);
		}
		return rtnList;
	}


	/**
	 * @param workOrderDetailList 설정하려는 workOrderDetailList입니다.
	 */
	public void setWorkOrderDetailList(WorkOrderDetailList[] workOrderDetailList) {
		if(workOrderDetailList != null){
			WorkOrderDetailList[] tmpList = Arrays.copyOf(workOrderDetailList, workOrderDetailList.length);
			this.workOrderDetailList = tmpList;
		}
	}


	/**
	 * @return workOrderDetailTitle을 리턴합니다.
	 */
	public WorkOrderDetailTitle getWorkOrderDetailTitle() {
		return workOrderDetailTitle;
	}


	/**
	 * @param workOrderDetailTitle 설정하려는 workOrderDetailTitle입니다.
	 */
	public void setWorkOrderDetailTitle(WorkOrderDetailTitle workOrderDetailTitle) {
		this.workOrderDetailTitle = workOrderDetailTitle;
	}



	
	
}