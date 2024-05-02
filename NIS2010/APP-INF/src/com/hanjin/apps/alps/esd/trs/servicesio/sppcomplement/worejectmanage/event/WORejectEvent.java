/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WORejectEvent.java
*@FileTitle : work order rejection
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0 
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.worejectmanage.event.WorkOrderRejectList;

/**
 *  PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sang-Woo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class WORejectEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String userID = "";
	private String vendorCode = "";
	private WorkOrderRejectList[] workOrderRejectList = null;
	private String trspWoNo		= "";
	private String trspSoNo		= "";
	private String eqNo			= "";
	private String workorderno		= "";
	private String submitmode 		= "";
		
	/**
	 * 
	 * @return
	 */
	public WORejectEvent(){}


	/**
	 * 
     * @param vendorCode
     * @param trspWoNo
     * @param trspSoNo
     */
    public WORejectEvent(
    		String vendorCode,
    		String trspWoNo,			
			String trspSoNo			
    ) {
    	this.vendorCode	= vendorCode;	
    	this.trspWoNo	= trspWoNo;				
    	this.trspSoNo	= trspSoNo;				
				
    }
	
	/**
	 * 
	 * @param userID
	 * @param vendorCode
	 * @param workorderno
	 * @param submitmode
	 * @param workOrderRejectList
	 */
	public WORejectEvent(
			String userID,
			String vendorCode,
			String workorderno,
			String submitmode,
			WorkOrderRejectList[] workOrderRejectList 

    ) {
		this.userID			= userID;		
		this.vendorCode	= vendorCode;		
		this.workorderno	= workorderno;				
		this.submitmode	= submitmode;				
		this.workOrderRejectList = workOrderRejectList;		
    
	}
		
	/**
	 * 
     * @param trsp_so_no
     */
    public WORejectEvent(
    		String trsp_so_no			
    ) {
    	this.trspSoNo	= trsp_so_no;				
				
    }
    	
 	public String getSubmitMode()	{		return submitmode;		}
	public String getWorkOrderNo()	{		return workorderno;		}
	public String getTrsp_wo_no()	{		return trspWoNo;		}
	public String getTrsp_so_no()		{		return trspSoNo;		}
	public String getEq_no()				{		return eqNo;		}
	public WorkOrderRejectList[] getWorkOrderRejectList() {	return workOrderRejectList;	}
	
	
	public void setSubmitMode     	(String submitmode) 	{		this.submitmode = submitmode; 	}                 
	public void setWorkOrderNo		(String workorderno) 	{		this.workorderno = workorderno;	}
	public void setTrsp_wo_no		(String trspWoNo) 	{		this.trspWoNo = trspWoNo;		}
	public void setTrsp_so_no			(String trspSoNo) 		{		this.trspSoNo = trspSoNo;		}
	public void setEq_no					(String eqNo) 			{		this.eqNo = eqNo;		}
	public void setWorkOrderRejectList(WorkOrderRejectList[] workOrderRejectList) {
												this.workOrderRejectList = workOrderRejectList;    
	}
	
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

		
    public String getEventName() {
        return "WORejectEvent";  //WORejectEvent
    }

    public String toString() {
        return "WORejectEvent";
    }	


}
