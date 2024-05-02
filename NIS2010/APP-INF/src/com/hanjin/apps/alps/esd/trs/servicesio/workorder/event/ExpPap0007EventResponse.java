/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0007EventResponse.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-10
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;


import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventResponseSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadList;


/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_007 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_007 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author doomi
 * @see EXP_PAP_007SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0007EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
		
	//WorkOrderDetailExcelUploadList
	private WorkOrderDetailExcelUploadList[]	workorderdetailexceluploadlist;
	
    // Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	//modify count
    private int count = 0;

	/**
	 * ExpPap0007EventResponse 객체를 생성
	 */
	public ExpPap0007EventResponse() {
	}


   /**
     * EXP_PAP_007 요청을 처리한 서버 실행 결과(DB ResultSet)를 담아 EXP_PAP_002EventResponse 객체를 생성
     * 
     * @param WorkOrderDetailExcelUploadList 서버 실행 결과
     */
 
    public ExpPap0007EventResponse(WorkOrderDetailExcelUploadList[] workorderdetailexceluploadlist) {
        this.workorderdetailexceluploadlist = workorderdetailexceluploadlist;
    }

    
    /**
     * EXP_PAP_007 요청을 처리한 서버 실행 결과(DB ResultSet)와 성공여부(successFlag)를 담아 ExpPap0007EventResponse 객체를 생성
     * 
     * @param WorkOrderDetailExcelUploadList 서버 실행 결과
     * @param successFlag 성공여부
     */
 
    public ExpPap0007EventResponse(WorkOrderDetailExcelUploadList[] workorderdetailexceluploadlist, String successFlag) {
        this.workorderdetailexceluploadlist = workorderdetailexceluploadlist;
        this.successFlag=successFlag;
    }
  
    
    /**
     * WorkOrderDetailExcelUploadList 반환작업
     * 
     * @return WorkOrderDetailExcelUploadList 서버 실행 결과
     */
 	
   public WorkOrderDetailExcelUploadList[] getWorkOrderDetailExcelUploadList() {
        WorkOrderDetailExcelUploadList[] rtnList = null;
		if(this.workorderdetailexceluploadlist != null){
			rtnList = Arrays.copyOf(workorderdetailexceluploadlist, workorderdetailexceluploadlist.length);
		}
		return rtnList;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderDetailExcelUploadList(WorkOrderDetailExcelUploadList[] workorderdetailexceluploadlist) {
		if(workorderdetailexceluploadlist != null){
			WorkOrderDetailExcelUploadList[] tmpList = Arrays.copyOf(workorderdetailexceluploadlist, workorderdetailexceluploadlist.length);
			this.workorderdetailexceluploadlist = tmpList;
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
     * @return Modify Count
     */
    public int getCount() {
        return this.count ;
    }

	/**
	 * @param 
	 */
   public void setCount(int count) {
        this.count = count;
    }
    

	/**
	 * 객체 표현 문자열(ExpPap0007EventResponse)을 반환
	 * 
	 * @return String ExpPap0007EventResponse
	 */
	public String toString() {
		return "ExpPap0007EventResponse";
	}

	/**
	 * 이벤트 명(ExpPap0007EventResponse)을 반환
	 * 
	 * @return String ExpPap0007EventResponse
	 */
	public String getEventName() {
		return "ExpPap0007EventResponse";
	}

	
}