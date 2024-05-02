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
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetFormatType;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheet;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetTotalQuantity;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoAwkward;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoReefer;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoDg;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetSecondList;
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
		if(WorkOrderSheetList != null){
			WorkOrderSheetList[] tmpList = Arrays.copyOf(WorkOrderSheetList, WorkOrderSheetList.length);
			this.workOrderSheetList = tmpList;
		}
	}

	public WorkOrderSheetList[] getWorkOrderSheetList() {
		WorkOrderSheetList[] rtnList = null;
		if(this.workOrderSheetList != null){
			rtnList = Arrays.copyOf(workOrderSheetList, workOrderSheetList.length);
		}
		return rtnList;	
	}

	
	public void setWorkOrderSheetList2(WorkOrderSheetList[] WorkOrderSheetList2) {
		if(WorkOrderSheetList2 != null){
			WorkOrderSheetList[] tmpList = Arrays.copyOf(WorkOrderSheetList2, WorkOrderSheetList2.length);
			this.workOrderSheetList2 = tmpList;
		}
	}

	public WorkOrderSheetList[] getWorkOrderSheetList2() {
		WorkOrderSheetList[] rtnList = null;
		if(this.workOrderSheetList2 != null){
			rtnList = Arrays.copyOf(workOrderSheetList2, workOrderSheetList2.length);
		}
		return rtnList;	
	}
	
	public void setWorkOrderSheetCargoAwkward(WorkOrderSheetCargoAwkward[] WorkOrderSheetCargoAwkward) {
		if(WorkOrderSheetCargoAwkward != null){
			WorkOrderSheetCargoAwkward[] tmpList = Arrays.copyOf(WorkOrderSheetCargoAwkward, WorkOrderSheetCargoAwkward.length);
			this.workOrderSheetCargoAwkward = tmpList;
		}
	}


    public WorkOrderSheetCargoAwkward[] getWorkOrderSheetCargoAwkward() {
        WorkOrderSheetCargoAwkward[] rtnList = null;
		if(this.workOrderSheetCargoAwkward != null){
			rtnList = Arrays.copyOf(workOrderSheetCargoAwkward, workOrderSheetCargoAwkward.length);
		}
		return rtnList;
    }

	public void setWorkOrderSheetCargoReefer(WorkOrderSheetCargoReefer[] WorkOrderSheetCargoReefer) {
		if(WorkOrderSheetCargoReefer != null){
			WorkOrderSheetCargoReefer[] tmpList = Arrays.copyOf(WorkOrderSheetCargoReefer, WorkOrderSheetCargoReefer.length);
			this.workOrderSheetCargoReefer = tmpList;
		}
	}

    public WorkOrderSheetCargoReefer[] getWorkOrderSheetCargoReefer() {
        WorkOrderSheetCargoReefer[] rtnList = null;
		if(this.workOrderSheetCargoReefer != null){
			rtnList = Arrays.copyOf(workOrderSheetCargoReefer, workOrderSheetCargoReefer.length);
		}
		return rtnList;
    }

	public void setWorkOrderSheetCargoDg(WorkOrderSheetCargoDg[] WorkOrderSheetCargoDg) {
		if(WorkOrderSheetCargoDg != null){
			WorkOrderSheetCargoDg[] tmpList = Arrays.copyOf(WorkOrderSheetCargoDg, WorkOrderSheetCargoDg.length);
			this.workOrderSheetCargoDg = tmpList;
		}
	}

    public WorkOrderSheetCargoDg[] getWorkOrderSheetCargoDg() {
        WorkOrderSheetCargoDg[] rtnList = null;
		if(this.workOrderSheetCargoDg != null){
			rtnList = Arrays.copyOf(workOrderSheetCargoDg, workOrderSheetCargoDg.length);
		}
		return rtnList;
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
