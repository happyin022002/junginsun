/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0006EventResponse.java
*@FileTitle : WO Sheet Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-10
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;


import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventResponseSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetFormatType;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheet;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetTotalQuantity;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoAwkward;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoReefer;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoDg;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetSecondList;
/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EXP_PAP_006 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - EXP_PAP_006 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author doomi
 * @see EXP_PAP_006SC 참조
 * @since J2EE 1.4
 */
public class ExpPap0006EventResponse extends EventResponseSupport {

	private static final long serialVersionUID = 1L;
	
	// WorkOrderSheet Master
	private WorkOrderSheetFormatType workOrderSheetFormatType;
	private WorkOrderSheet	workOrderSheet;
	private WorkOrderSheetTotalQuantity workOrderSheetTotalQuantity;
	private WorkOrderSheetList[]	workOrderSheetList;
	private WorkOrderSheetList[]	workOrderSheetList2;
	private WorkOrderSheetCargoAwkward[]	workOrderSheetCargoAwkward;
	private WorkOrderSheetCargoReefer[]	workOrderSheetCargoReefer;
	private WorkOrderSheetCargoDg[]	workOrderSheetCargoDg;
	private WorkOrderSheetSecondList[]	workOrderSheetSecondList;
	
	
    // Success Flag
    private String successFlag;
    
    // 전체 카운트
    private int totalCount = 0;

	//modify count
    private int count = 0;

	/**
	 * ExpPap0006EventResponse 객체를 생성
	 */
	public ExpPap0006EventResponse() {
	}


   /**
	 * ExpPap0006EventResponse 객체를 생성
	 * @param WorkOrderSheetFormatType
	 */
	public ExpPap0006EventResponse(
			WorkOrderSheetFormatType WorkOrderSheetFormatType) {
		this.workOrderSheetFormatType = WorkOrderSheetFormatType;
	}

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheet
     */
    public ExpPap0006EventResponse(WorkOrderSheet WorkOrderSheet) {
        this.workOrderSheet = WorkOrderSheet;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetTotalQuantity
     */
    public ExpPap0006EventResponse(WorkOrderSheetTotalQuantity WorkOrderSheetTotalQuantity) {
        this.workOrderSheetTotalQuantity = WorkOrderSheetTotalQuantity;
    }

	/**
	 * ExpPap0006EventResponse 객체를 생성
	 * @param WorkOrderSheetList
	 */
	public ExpPap0006EventResponse(WorkOrderSheetList[] WorkOrderSheetList) {
        this.workOrderSheetList = WorkOrderSheetList;
    }

    
    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetCargoAwkward
     */
    public ExpPap0006EventResponse(WorkOrderSheetCargoAwkward[] WorkOrderSheetCargoAwkward) {
        this.workOrderSheetCargoAwkward = WorkOrderSheetCargoAwkward;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetCargoReefer
     */
    public ExpPap0006EventResponse(WorkOrderSheetCargoReefer[] WorkOrderSheetCargoReefer) {
        this.workOrderSheetCargoReefer = WorkOrderSheetCargoReefer;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetCargoDg
     */
    public ExpPap0006EventResponse(WorkOrderSheetCargoDg[] WorkOrderSheetCargoDg) {
        this.workOrderSheetCargoDg = WorkOrderSheetCargoDg;
    }

    
	/**
	 * ExpPap0006EventResponse 객체를 생성
	 * @param WorkOrderSheetSecondList
	 */
	public ExpPap0006EventResponse(WorkOrderSheetSecondList[] WorkOrderSheetSecondList) {
        this.workOrderSheetSecondList = WorkOrderSheetSecondList;
    }

	
    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetFormatType
     * @param successFlag
     */
    public ExpPap0006EventResponse(WorkOrderSheetFormatType WorkOrderSheetFormatType, String successFlag) {
        this.workOrderSheetFormatType = WorkOrderSheetFormatType;
        this.successFlag=successFlag;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheet
     * @param successFlag
     */
    public ExpPap0006EventResponse(WorkOrderSheet WorkOrderSheet, String successFlag) {
        this.workOrderSheet = WorkOrderSheet;
        this.successFlag=successFlag;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetTotalQuantity
     * @param successFlag
     */
    public ExpPap0006EventResponse(WorkOrderSheetTotalQuantity WorkOrderSheetTotalQuantity, String successFlag) {
        this.workOrderSheetTotalQuantity = WorkOrderSheetTotalQuantity;
        this.successFlag=successFlag;
    }

	/**
	 * ExpPap0006EventResponse 객체를 생성
	 * @param WorkOrderSheetList
	 * @param successFlag
	 */
	public ExpPap0006EventResponse(WorkOrderSheetList[] WorkOrderSheetList, String successFlag) {
        this.workOrderSheetList = WorkOrderSheetList;
        this.successFlag=successFlag;
    }
 
    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetCargoAwkward
     * @param successFlag
     */
    public ExpPap0006EventResponse(WorkOrderSheetCargoAwkward[] WorkOrderSheetCargoAwkward, String successFlag) {
        this.workOrderSheetCargoAwkward = WorkOrderSheetCargoAwkward;
        this.successFlag=successFlag;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetCargoReefer
     * @param successFlag
     */
    public ExpPap0006EventResponse(WorkOrderSheetCargoReefer[] WorkOrderSheetCargoReefer, String successFlag) {
        this.workOrderSheetCargoReefer = WorkOrderSheetCargoReefer;
        this.successFlag=successFlag;
    }

    /**
     * ExpPap0006EventResponse 객체를 생성
     * @param WorkOrderSheetCargoDg
     * @param successFlag
     */
    public ExpPap0006EventResponse(WorkOrderSheetCargoDg[] WorkOrderSheetCargoDg, String successFlag) {
        this.workOrderSheetCargoDg = WorkOrderSheetCargoDg;
        this.successFlag=successFlag;
    }

    
	/**
	 * ExpPap0006EventResponse 객체를 생성
	 * @param WorkOrderSheetSecondList
	 * @param successFlag
	 */
	public ExpPap0006EventResponse(WorkOrderSheetSecondList[] WorkOrderSheetSecondList, String successFlag) {
        this.workOrderSheetSecondList = WorkOrderSheetSecondList;
        this.successFlag=successFlag;
    }

    
    /**
     * WorkOrderSheet 반환작업
     * 
     * @return WorkOrderSheet 서버 실행 결과
     */	
    public WorkOrderSheet getWorkOrderSheet() {
        return this.workOrderSheet;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderSheet(WorkOrderSheet WorkOrderSheet) {
		this.workOrderSheet = WorkOrderSheet;
	}

    /**
     * WorkOrderSheetTotalQuantity 반환작업
     * 
     * @return 서버 실행 결과
     */	
    public WorkOrderSheetTotalQuantity getWorkOrderSheetTotalQuantity() {
        return this.workOrderSheetTotalQuantity;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderSheetTotalQuantity(WorkOrderSheetTotalQuantity WorkOrderSheetTotalQuantity) {
		this.workOrderSheetTotalQuantity = WorkOrderSheetTotalQuantity;
	}

	
	/**
	 * @return 
	 */
	public WorkOrderSheetList[] getWorkOrderSheetList() {
        WorkOrderSheetList[] rtnList = null;
		if(this.workOrderSheetList != null){
			rtnList = Arrays.copyOf(workOrderSheetList, workOrderSheetList.length);
		}
		return rtnList;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderSheetList(WorkOrderSheetList[] WorkOrderSheetList) {
		if(WorkOrderSheetList != null){
			WorkOrderSheetList[] tmpList = Arrays.copyOf(WorkOrderSheetList, WorkOrderSheetList.length);
			this.workOrderSheetList = tmpList;
		}
	}

	
	/**
	 * @return 
	 */
	public WorkOrderSheetList[] getWorkOrderSheetList2() {
        WorkOrderSheetList[] rtnList = null;
		if(this.workOrderSheetList2 != null){
			rtnList = Arrays.copyOf(workOrderSheetList2, workOrderSheetList2.length);
		}
		return rtnList;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderSheetList2(WorkOrderSheetList[] WorkOrderSheetList2) {
		if(WorkOrderSheetList2 != null){
			WorkOrderSheetList[] tmpList = Arrays.copyOf(WorkOrderSheetList2, WorkOrderSheetList2.length);
			this.workOrderSheetList2 = tmpList;
		}
	}


	/**
	 * @param 
	 */
	public void setWorkOrderSheetCargoAwkward(WorkOrderSheetCargoAwkward[] WorkOrderSheetCargoAwkward) {
		if(WorkOrderSheetCargoAwkward != null){
			WorkOrderSheetCargoAwkward[] tmpList = Arrays.copyOf(WorkOrderSheetCargoAwkward, WorkOrderSheetCargoAwkward.length);
			this.workOrderSheetCargoAwkward = tmpList;
		}
	}


	/**
	 * @return 
	 */
    public WorkOrderSheetCargoAwkward[] getWorkOrderSheetCargoAwkward() {
        WorkOrderSheetCargoAwkward[] rtnList = null;
		if(this.workOrderSheetCargoAwkward != null){
			rtnList = Arrays.copyOf(workOrderSheetCargoAwkward, workOrderSheetCargoAwkward.length);
		}
		return rtnList;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderSheetCargoReefer(WorkOrderSheetCargoReefer[] WorkOrderSheetCargoReefer) {
		if(WorkOrderSheetCargoReefer != null){
			WorkOrderSheetCargoReefer[] tmpList = Arrays.copyOf(WorkOrderSheetCargoReefer, WorkOrderSheetCargoReefer.length);
			this.workOrderSheetCargoReefer = tmpList;
		}
	}

	/**
	 * @return 
	 */
    public WorkOrderSheetCargoReefer[] getWorkOrderSheetCargoReefer() {
        WorkOrderSheetCargoReefer[] rtnList = null;
		if(this.workOrderSheetCargoReefer != null){
			rtnList = Arrays.copyOf(workOrderSheetCargoReefer, workOrderSheetCargoReefer.length);
		}
		return rtnList;
    }

	/**
	 * @param 
	 */
	public void setWorkOrderSheetCargoDg(WorkOrderSheetCargoDg[] WorkOrderSheetCargoDg) {
		if(WorkOrderSheetCargoDg != null){
			WorkOrderSheetCargoDg[] tmpList = Arrays.copyOf(WorkOrderSheetCargoDg, WorkOrderSheetCargoDg.length);
			this.workOrderSheetCargoDg = tmpList;
		}
	}

	/**
	 * @return 
	 */
    public WorkOrderSheetCargoDg[] getWorkOrderSheetCargoDg() {
        WorkOrderSheetCargoDg[] rtnList = null;
		if(this.workOrderSheetCargoDg != null){
			rtnList = Arrays.copyOf(workOrderSheetCargoDg, workOrderSheetCargoDg.length);
		}
		return rtnList;
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

    public void setCount(int count) {
        this.count = count;
    }
    

	/**
	 * 객체 표현 문자열(ExpPap0006EventResponse)을 반환
	 * 
	 * @return String ExpPap0006EventResponse
	 */
	public String toString() {
		return "ExpPap0006EventResponse";
	}

	/**
	 * 이벤트 명(ExpPap0006EventResponse)을 반환
	 * 
	 * @return String ExpPap0006EventResponse
	 */
	public String getEventName() {
		return "ExpPap0006EventResponse";
	}


	/**
	 * @return workOrderSheetFormatType을 리턴합니다.
	 */
	public WorkOrderSheetFormatType getWorkOrderSheetFormatType() {
		return workOrderSheetFormatType;
	}


	/**
	 * @param workOrderSheetFormatType 설정하려는 workOrderSheetFormatType입니다.
	 */
	public void setWorkOrderSheetFormatType(
			WorkOrderSheetFormatType workOrderSheetFormatType) {
		this.workOrderSheetFormatType = workOrderSheetFormatType;
	}


	/**
	 * @return workOrderSheetSecondList을 리턴합니다.
	 */
	public WorkOrderSheetSecondList[] getWorkOrderSheetSecondList() {
		WorkOrderSheetSecondList[] rtnList = null;
		if(this.workOrderSheetSecondList != null){
			rtnList = Arrays.copyOf(workOrderSheetSecondList, workOrderSheetSecondList.length);
		}
		return rtnList;
	}


	/**
	 * @param workOrderSheetSecondList 설정하려는 workOrderSheetSecondList입니다.
	 */
	public void setWorkOrderSheetSecondList(WorkOrderSheetSecondList[] workOrderSheetSecondList) {
		if(workOrderSheetSecondList != null){
			WorkOrderSheetSecondList[] tmpList = Arrays.copyOf(workOrderSheetSecondList, workOrderSheetSecondList.length);
			this.workOrderSheetSecondList = tmpList;
		}
	}

	
}