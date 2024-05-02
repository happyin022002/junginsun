/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPP_TES_005Event.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : doomi
*@LastVersion : 1.0
* 2007-01-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;


import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * SPP_TES_005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - SPP_TES_005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class SppTes0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String invoiceNo = null;
	private String vendorCode = null;
	
	private String userID = "";
	private String dateGubun			= null;
    private String fromDt					= null;
	private String toDt						= null;
    private String invoiceStatus			= null;
    private String serviceOrderNo		= null;
    
    /*	2008-04-17	by KJJ 추가	*/
    private String issDt = null; 
    private String rcvDt = null;
    private String tmlInvStsCd = null;
	private String tmlSoOfcCtyCd = null;
	private String tmlSoSeq = null;    
	
	/**
	 * 
	 * @return
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * 
	 * @return
	 */
	public String getIss_dt() {
		return issDt;
	}

	/**
	 * 
	 * @param iss_dt
	 */
	public void setIss_dt(String iss_dt) {
		this.issDt = iss_dt;
	}

	/**
	 * 
	 * @return
	 */
	public String getRcv_dt() {
		return rcvDt;
	}

	/**
	 * 
	 * @param rcv_dt
	 */
	public void setRcv_dt(String rcv_dt) {
		this.rcvDt = rcv_dt;
	}

	/**
	 * 
	 * @return
	 */
	public String getTml_inv_sts_cd() {
		return tmlInvStsCd;
	}

	/**
	 * 
	 * @param tml_inv_sts_cd
	 */
	public void setTml_inv_sts_cd(String tml_inv_sts_cd) {
		this.tmlInvStsCd = tml_inv_sts_cd;
	}

	/**
	 * 
	 * @param dateGubun
	 */
	public void setDateGubun(String dateGubun) {
		this.dateGubun = dateGubun;
	}

	/**
	 * 
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	/**
	 * 
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * 
	 * @param invoiceStatus
	 */
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	/**
	 * 
	 * @param serviceOrderNo
	 */
	public void setServiceOrderNo(String serviceOrderNo) {
		this.serviceOrderNo = serviceOrderNo;
	}

	/**
	 * 
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	/**
	 * 
	 *
	 */
	public SppTes0005Event(){}

	
	/**
	 * 
	 * @param serviceOrderNo
	 */
    public SppTes0005Event(String serviceOrderNo) {
		this.serviceOrderNo	= serviceOrderNo; 		
    }
    
    /**
     * 
     * @param vendorCode
     * @param dateGubun
     * @param fromDt
     * @param toDt
     * @param invoiceStatus
     * @param invoiceNo
     * @param iss_dt
     * @param rcv_dt
     * @param tml_inv_sts_cd
     * @param tml_so_ofc_cty_cd
     * @param tml_so_seq
     */
    public SppTes0005Event(
			String vendorCode,
    		String dateGubun,			
    		String fromDt,				
    		String toDt,					
    		String invoiceStatus,						
    		String invoiceNo,
    		String iss_dt,
    		String rcv_dt,
    		String tml_inv_sts_cd,
			String tml_so_ofc_cty_cd,
			String tml_so_seq) {
		this.vendorCode	= vendorCode;		
    	this.dateGubun = dateGubun;			
    	this.fromDt = fromDt;				
    	this.toDt = toDt;					
    	this.invoiceStatus = invoiceStatus;						
    	this.invoiceNo = invoiceNo;
    	this.issDt = iss_dt;
    	this.rcvDt = rcv_dt;
    	this.tmlInvStsCd = tml_inv_sts_cd;
		this.tmlSoOfcCtyCd = tml_so_ofc_cty_cd;
		this.tmlSoSeq = tml_so_seq;    	
    }
    
	/**
	 * @return
	 */
    public String getDateGubun(){		
    	return dateGubun;		
    }
    
	/**
	 * @return
	 */
	public String getFromDt(){		
		return fromDt;		
	}
	
	/**
	 * @return
	 */
	public String getToDt(){		
		return toDt;						
	}

	/**
	 * 
	 * @return
	 */
	public String getInvoiceStatus(){		
		return invoiceStatus;							
	}
	
	/**
	 * @return
	 */
	public String getInvoiceNo(){		
		return invoiceNo;		
	}


	/**
	 * 
	 * @return
	 */
	public String getServiceOrderNo(){		
		return serviceOrderNo;		
	}

	/**
	 * 
	 * @return
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getVendorCode() {
		return vendorCode;
	}

	/**
	 * 
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	/**
	 * 
	 * @return
	 */
    public String getEventName() {
        return "SPP_TES_005Event";
    }
	/**
	 * 
	 * @return
	 */
    public String toString() {
        return "SPP_TES_005Event";
    }	

	/**
	 * 
	 * @return
	 */
	public String getTml_so_ofc_cty_cd() {
		return tmlSoOfcCtyCd;
	}

	/**
	 * 
	 * @param tml_so_ofc_cty_cd
	 */
	public void setTml_so_ofc_cty_cd(String tml_so_ofc_cty_cd) {
		this.tmlSoOfcCtyCd = tml_so_ofc_cty_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getTml_so_seq() {
		return tmlSoSeq;
	}

	/**
	 * 
	 * @param tml_so_seq
	 */
	public void setTml_so_seq(String tml_so_seq) {
		this.tmlSoSeq = tml_so_seq;
	}
}
