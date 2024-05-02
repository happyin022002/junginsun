/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderMainResponse.java
*@FileTitle : WorkOrderMain 
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
 * EXP_PAP_005Response 에 대한 WebService Document Object including Parameters<br>
 * - TrsSppIWSProxy의 Output Parameter<br>
 * - EXP_PAP_005EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderMainResponse {
	/** (Header) */
	private String	id				= "WorkOrderMainResponse";
	private String	status			= "";
	private int		count			= 0;
	private int newworkordercount = 0;
	
	/** (Param 객체) */
	private WorkOrderMainList[]	workordermainlist	= null;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setWorkOrderMainList(WorkOrderMainList[] workordermainlist) {
		if (workordermainlist != null) {
			WorkOrderMainList[] tmpVOs = Arrays.copyOf(workordermainlist, workordermainlist.length);
			this.workordermainlist = tmpVOs;
		} // end if
	}


	public WorkOrderMainList[] getWorkOrderMainList() {
		WorkOrderMainList[] rtnVOs = null;
		if (this.workordermainlist != null) {
			rtnVOs = Arrays.copyOf(this.workordermainlist, this.workordermainlist.length);
		} // end if
		return rtnVOs;
	}

	
	public int getNewWorkOrderCount() {
		return newworkordercount;
	}
	
	public void setNewWorkOrderCount(int newworkordercount) {
		this.newworkordercount = newworkordercount;
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
