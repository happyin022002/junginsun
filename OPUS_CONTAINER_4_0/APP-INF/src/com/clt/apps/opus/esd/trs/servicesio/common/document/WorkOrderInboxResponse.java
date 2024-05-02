/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxResponse.java
*@FileTitle : WorkOrderInbox 
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
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderInboxResponse {
	/** (Header) */
	private String	id				= "WorkOrderInboxResponse";
	private String	status			= "";
	private int		count			= 0;
	
	/** (Param 객체) */
	private WorkOrderInboxList[]	workorderInboxlist	= null;
	private WorkOrderInboxList	    workorderInboxExcelHeader	= null;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setWorkOrderInboxList(WorkOrderInboxList[] workorderInboxlist) {
		if (workorderInboxlist != null) {
			WorkOrderInboxList[] tmpVOs = Arrays.copyOf(workorderInboxlist, workorderInboxlist.length);
			this.workorderInboxlist = tmpVOs;
		} // end if
	}


	public WorkOrderInboxList[] getWorkOrderInboxList() {
		WorkOrderInboxList[] rtnVOs = null;
		if (this.workorderInboxlist != null) {
			rtnVOs = Arrays.copyOf(this.workorderInboxlist, this.workorderInboxlist.length);
		} // end if
		return rtnVOs;
	}


	public void setWorkorderInboxExcelHeader(WorkOrderInboxList workorderInboxExcelHeader) {
		this.workorderInboxExcelHeader = workorderInboxExcelHeader;
	}


	public WorkOrderInboxList getWorkorderInboxExcelHeader() {
		return workorderInboxExcelHeader;
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
}
