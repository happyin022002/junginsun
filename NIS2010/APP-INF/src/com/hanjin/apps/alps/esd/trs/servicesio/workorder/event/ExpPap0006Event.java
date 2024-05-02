/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0006Event.java
*@FileTitle : WO Sheet Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-26
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.event;


import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author doomi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String userID = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	//private String ServiceOrderNo				= "";
	private String workOrderNo					= "";
	/**
	 * 
	 * @return
	 */
	public ExpPap0006Event(){}

	
    /**
     * @param VendorCode
     * @param ParentVendorCode
     * @param WorkOrderNo
     */
    public ExpPap0006Event(
    		String VendorCode,
    		String ParentVendorCode,
     	   	String WorkOrderNo 
    ) {
    	
    	this.vendorCode	= VendorCode;		
    	this.parentVendorCode	= ParentVendorCode;		
		this.workOrderNo	= WorkOrderNo;				
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


	/** 
	 * @return
	 */
	public String getWorkOrderNo()		{		
		return workOrderNo;		}
	
	

	/** 
	 * @param
	 */
	public void setWorkOrderNo(String WorkOrderNo) {		
		this.workOrderNo = WorkOrderNo;	}
	
	

	
   /** 
	 * @return
	 */
	public String getUserID() {
		return userID;
	}

   /** 
	 * @param
	 */
	public void setUserID(String UserID) {
		this.userID = UserID;
	}

   /** 
	 * @return
	 */
	public String getVendorCode() {
		return vendorCode;
	}

   /** 
	 * @return
	 */
	public void setVendorCode(String VendorCode) {
		this.vendorCode = VendorCode;
	}


   /** 
	 * @return
	 */
    public String getEventName() {
        return "ExpPap0006Event";
    }

    /** 
	 * @return
	 */
    public String toString() {
        return "ExpPap0006Event";
    }	

    
}
