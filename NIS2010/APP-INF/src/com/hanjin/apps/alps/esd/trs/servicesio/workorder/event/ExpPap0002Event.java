/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_002Event.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;


import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailSubmitRejectList;


/**
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String userID = "";
	private String parentVendorCode = "";
	private String vendorCode = "";
	private WorkOrderDetailSubmitRejectList[] workOrderDetailSubmitRejectList = null;
	private String trspWoNo		= "";
	private String trspSoNo		= "";
	private String eqNo				= "";
	private String workorderno		= "";
	private String submitmode 		= "";
	
	
	
	/**
	 * 
	 * @return
	 */
	public ExpPap0002Event(){}


    /**
     * ExpPap0002Event생성자
     * @param vendorCode
     * @param parentVendorCode
     * @param trsp_wo_no
     * @param trsp_so_no
     */
    public ExpPap0002Event(
    		String vendorCode,
    		String parentVendorCode,
    		String trsp_wo_no,			
			String trsp_so_no			
    ) {
    	this.vendorCode	= vendorCode;	
    	this.parentVendorCode	= parentVendorCode;	
    	this.trspWoNo	= trsp_wo_no;				
    	this.trspSoNo	= trsp_so_no;				
				
    }


	
	/**
	 * ExpPap0002Event 생성자
	 * @param userID
	 * @param vendorCode
	 * @param workorderno
	 * @param submitmode
	 * @param WorkOrderDetailSubmitRejectList
	 */
	public ExpPap0002Event(
			String userID,
			String vendorCode,
			String workorderno,
			String submitmode,
			WorkOrderDetailSubmitRejectList[] WorkOrderDetailSubmitRejectList 

    ) {
		this.userID			= userID;		
		this.vendorCode	= vendorCode;		
		this.workorderno	= workorderno;				
		this.submitmode	= submitmode;				
		this.workOrderDetailSubmitRejectList = WorkOrderDetailSubmitRejectList;		
    
	}
	
	
    /**
     * ExpPap0002Event생성자
     * 
     * @param trsp_so_no
     */
    public ExpPap0002Event(
    		String trsp_so_no			
    ) {
    	this.trspSoNo	= trsp_so_no;				
				
    }
    
	
 	public String getSubmitMode()	{		return submitmode;		}
	public String getWorkOrderNo()	{		return workorderno;		}
	public String getTrsp_wo_no()	{		return trspWoNo;		}
	public String getTrsp_so_no()		{		return trspSoNo;		}
	public String getEq_no()				{		return eqNo;		}
	public WorkOrderDetailSubmitRejectList[] getWorkOrderDetailSubmitRejectList() {	
		WorkOrderDetailSubmitRejectList[] rtnList = null;
		if(this.workOrderDetailSubmitRejectList != null){
			rtnList = Arrays.copyOf(workOrderDetailSubmitRejectList, workOrderDetailSubmitRejectList.length);
		}
		return rtnList;
	}
	
	
	public void setSubmitMode     	(String submitmode) 	{		this.submitmode = submitmode; 	}                 
	public void setWorkOrderNo		(String workorderno) 	{		this.workorderno = workorderno;	}
	public void setTrsp_wo_no		(String trsp_wo_no) 	{		this.trspWoNo = trsp_wo_no;		}
	public void setTrsp_so_no			(String trsp_so_no) 		{		this.trspSoNo = trsp_so_no;		}
	public void setEq_no					(String eq_no) 			{		this.eqNo = eq_no;		}
	public void setWorkOrderDetailSubmitRejectList(WorkOrderDetailSubmitRejectList[] WorkOrderDetailSubmitRejectList) {
		if(workOrderDetailSubmitRejectList != null){
			WorkOrderDetailSubmitRejectList[] tmpList = Arrays.copyOf(workOrderDetailSubmitRejectList, workOrderDetailSubmitRejectList.length);
			this.workOrderDetailSubmitRejectList = tmpList;
		}
	}
	
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return parentVendorCode을 리턴합니다.
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}


	/**
	 * @param parentVendorCode 설정하려는 parentVendorCode입니다.
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}


	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

		
    public String getEventName() {
        return "ExpPap0002Event";  //WORejectEvent
    }

    public String toString() {
        return "ExpPap0002Event";
    }	

    
}
