/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0003Event.java
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

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String userID = "";
	private String vendorCode = "";
	private String parentVendorCode = "";
	private String trspSoNo		= "";
	private String trspWoNo		= "";
	
	

	
	/**
	 * 
	 * @return
	 */
	public ExpPap0003Event(){}
	
	
    /**
     * @param vendorCode
     * @param parentVendorCode
     * @param trsp_wo_no
     */
    public ExpPap0003Event(
    		String vendorCode,
    		String parentVendorCode,
    		String trsp_wo_no
    ) {
    	this.vendorCode	= vendorCode;	
    	this.parentVendorCode	= parentVendorCode;	
    	this.trspWoNo	= trsp_wo_no;	
    }
    
    
	/**
	 * @param String trsp_so_no      
	 */
    public ExpPap0003Event(
    	String trsp_so_no
    ) {
    	this.trspSoNo	= trsp_so_no;	
    }

    
    public String getParentVendorCode() {		return parentVendorCode;	}
	public String getVendorCode() {		return vendorCode;	}
	public String getUserID() {	return userID;	}
	public String getTrsp_wo_no()	{		return trspWoNo;		}
	public String getTrsp_so_no()		{		return trspSoNo;		}
	
	
	public void setParentVendorCode(String parentVendorCode) 	{		this.parentVendorCode = parentVendorCode;	}
	public void setVendorCode(String vendorCode) 	{		this.vendorCode = vendorCode;	}
	public void setUserID(String userID) 					{		this.userID = userID;	}
	public void setTrsp_wo_no(String trsp_wo_no) 	{		this.trspWoNo = trsp_wo_no;	}
	public void setTrsp_so_no(String trsp_so_no) 		{		this.trspSoNo = trsp_so_no;	}


	
    public String getEventName() {
        return "ExpPap0003Event";
    }

    public String toString() {
        return "ExpPap0003Event";
    }	

    
}
