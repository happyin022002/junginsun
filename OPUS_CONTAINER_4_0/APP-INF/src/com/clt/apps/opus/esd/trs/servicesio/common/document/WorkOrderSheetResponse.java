/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetResponse.java
*@FileTitle : WorkOrderSheet 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;

import java.util.Arrays;


/**
 * EXP_PAP_006Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_006EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetResponse {
	/** (Header) */
	private String	id				= "WorkOrderSheetResponse";
	private String	status		= "";
	private int		count			= 0;
	
	/** (Param 객체) */
	private WorkOrderSheetFormatType			workOrderSheetFormatType;
	private WorkOrderSheet							workOrderSheet;
	private WorkOrderSheetTotalQuantity		workOrderSheetTotalQuantity;
	private WorkOrderSheetList[]					workOrderSheetList	= null;
	private WorkOrderSheetList[]					workOrderSheetList2	= null;
	private WorkOrderSheetCargoAwkward[]	workOrderSheetCargoAwkward = null;
	private WorkOrderSheetCargoReefer[]		workOrderSheetCargoReefer = null;
	private WorkOrderSheetCargoDg[]			workOrderSheetCargoDg = null;
	private WorkOrderSheetSecondList[]		workOrderSheetSecondList = null;
	

	
	public void setWorkOrderSheet(WorkOrderSheet WorkOrderSheet) {
		this.workOrderSheet = WorkOrderSheet;
	}
	
	public WorkOrderSheet getWorkOrderSheet() {
		return workOrderSheet;
	}
	
	public void setWorkOrderSheetTotalQuantity(WorkOrderSheetTotalQuantity WorkOrderSheetTotalQuantity) {
		this.workOrderSheetTotalQuantity = WorkOrderSheetTotalQuantity;
	}
	
	public WorkOrderSheetTotalQuantity getWorkOrderSheetTotalQuantity() {
		return workOrderSheetTotalQuantity;
	}
	
	public void setWorkOrderSheetList(WorkOrderSheetList[] WorkOrderSheetList) {
		if (WorkOrderSheetList != null) {
			WorkOrderSheetList[] tmpVOs = Arrays.copyOf(WorkOrderSheetList, WorkOrderSheetList.length);
			this.workOrderSheetList = tmpVOs;
		} // end if
	}

	public WorkOrderSheetList[] getWorkOrderSheetList() {
		WorkOrderSheetList[] rtnVOs = null;
		if (this.workOrderSheetList != null) {
			rtnVOs = Arrays.copyOf(this.workOrderSheetList, this.workOrderSheetList.length);
		} // end if
		return rtnVOs;
	}

	
	public void setWorkOrderSheetList2(WorkOrderSheetList[] WorkOrderSheetList2) {
		if (WorkOrderSheetList2 != null) {
			WorkOrderSheetList[] tmpVOs = Arrays.copyOf(WorkOrderSheetList2, WorkOrderSheetList2.length);
			this.workOrderSheetList2 = tmpVOs;
		} // end if
	}

	public WorkOrderSheetList[] getWorkOrderSheetList2() {
		WorkOrderSheetList[] rtnVOs = null;
		if (this.workOrderSheetList2 != null) {
			rtnVOs = Arrays.copyOf(this.workOrderSheetList2, this.workOrderSheetList2.length);
		} // end if
		return rtnVOs;
	}
	
	public void setWorkOrderSheetCargoAwkward(WorkOrderSheetCargoAwkward[] WorkOrderSheetCargoAwkward) {
		if (WorkOrderSheetCargoAwkward != null) {
			WorkOrderSheetCargoAwkward[] tmpVOs = Arrays.copyOf(WorkOrderSheetCargoAwkward, WorkOrderSheetCargoAwkward.length);
			this.workOrderSheetCargoAwkward = tmpVOs;
		} // end if
	}


    public WorkOrderSheetCargoAwkward[] getWorkOrderSheetCargoAwkward() {
        WorkOrderSheetCargoAwkward[] rtnVOs = null;
		if (this.workOrderSheetCargoAwkward != null) {
			rtnVOs = Arrays.copyOf(this.workOrderSheetCargoAwkward, this.workOrderSheetCargoAwkward.length);
		} // end if
		return rtnVOs;
    }

	public void setWorkOrderSheetCargoReefer(WorkOrderSheetCargoReefer[] WorkOrderSheetCargoReefer) {
		if (WorkOrderSheetCargoReefer != null) {
			WorkOrderSheetCargoReefer[] tmpVOs = Arrays.copyOf(WorkOrderSheetCargoReefer, WorkOrderSheetCargoReefer.length);
			this.workOrderSheetCargoReefer = tmpVOs;
		} // end if
	}

    public WorkOrderSheetCargoReefer[] getWorkOrderSheetCargoReefer() {
        WorkOrderSheetCargoReefer[] rtnVOs = null;
		if (this.workOrderSheetCargoReefer != null) {
			rtnVOs = Arrays.copyOf(this.workOrderSheetCargoReefer, this.workOrderSheetCargoReefer.length);
		} // end if
		return rtnVOs;
    }

	public void setWorkOrderSheetCargoDg(WorkOrderSheetCargoDg[] WorkOrderSheetCargoDg) {
		if (WorkOrderSheetCargoDg != null) {
			WorkOrderSheetCargoDg[] tmpVOs = Arrays.copyOf(WorkOrderSheetCargoDg, WorkOrderSheetCargoDg.length);
			this.workOrderSheetCargoDg = tmpVOs;
		} // end if
	}

    public WorkOrderSheetCargoDg[] getWorkOrderSheetCargoDg() {
        WorkOrderSheetCargoDg[] rtnVOs = null;
		if (this.workOrderSheetCargoDg != null) {
			rtnVOs = Arrays.copyOf(this.workOrderSheetCargoDg, this.workOrderSheetCargoDg.length);
		} // end if
		return rtnVOs;
    }

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
		WorkOrderSheetSecondList[] rtnVOs = null;
		if (this.workOrderSheetSecondList != null) {
			rtnVOs = Arrays.copyOf(this.workOrderSheetSecondList, this.workOrderSheetSecondList.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param workOrderSheetSecondList 설정하려는 workOrderSheetSecondList입니다.
	 */
	public void setWorkOrderSheetSecondList(
			WorkOrderSheetSecondList[] workOrderSheetSecondList) {
		if (workOrderSheetSecondList != null) {
			WorkOrderSheetSecondList[] tmpVOs = Arrays.copyOf(workOrderSheetSecondList, workOrderSheetSecondList.length);
			this.workOrderSheetSecondList = tmpVOs;
		} // end if
	}
}
