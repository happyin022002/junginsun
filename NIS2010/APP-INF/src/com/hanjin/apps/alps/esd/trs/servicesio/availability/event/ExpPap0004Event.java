/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_004Event.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability.event;


import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.event.EmptyAvailabilityInquiryRequest;


/**
 * EXP_PAP_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_PAP_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private	String periodFlg = "";							
	private	String fromDt = "";							
	private	String toDt = "";								
	private	String freightCollectFlg = "";               
	private	String originalBlFlg = "";          	
	private	String customsFlg = "";      
	private	String cntrPkupNoFlg = "";                         

	private String trspWoNo			= ""; 
    private String eqNo					= ""; 
	private String bkgNo				= ""; 
	private String blNo					= ""; 
	private String availableStsFlg		= ""; 

	private String userID = "";
	private String vendorCode = "";
	private EmptyAvailabilityInquiryRequest emptyAvailabilityInquiryRequest = new EmptyAvailabilityInquiryRequest();
	
	

	
	/**
	 * 
	 * @return
	 */
	public ExpPap0004Event(){}

	

    /**
     * ExpPap0004Event이벤트 생성
     * 
     * @param vendorCode
     * @param period_flg
     * @param from_dt
     * @param to_dt
     * @param freight_collect_flg
     * @param original_bl_flg
     * @param customs_flg
     * @param cntr_pkup_no_flg
     * @param available_sts_flg
     */
    public ExpPap0004Event(
    		String vendorCode,
    		String period_flg,
    		String from_dt,
    		String to_dt,
    		String freight_collect_flg,
    		String original_bl_flg,
    		String customs_flg,
    		String cntr_pkup_no_flg,
    		String available_sts_flg

	) {
    	this.vendorCode	= vendorCode;		
    	this.periodFlg                   	= period_flg;                       
    	this.fromDt                      	= from_dt;                      
    	this.toDt                          	= to_dt;                          
    	this.freightCollectFlg         = freight_collect_flg;           
    	this.originalBlFlg     			= original_bl_flg;     
    	this.customsFlg				= customs_flg;
    	this.cntrPkupNoFlg = cntr_pkup_no_flg;
    	this.availableStsFlg = available_sts_flg;
    	
    }
	
 
    /**
     * ExpPap0004Event를 생성한다.
     * 
     * @param vendorCode
     * @param trsp_wo_no
     * @param eq_no
     * @param bkg_no
     * @param bl_no
     */
    public ExpPap0004Event(
    		String vendorCode,
       		String trsp_wo_no,
       	 	String eq_no,
    		String bkg_no,
    		String bl_no
	) {
    	this.vendorCode	= vendorCode;		
    	this.trspWoNo					= trsp_wo_no;
        this.eqNo							= eq_no;
        this.bkgNo						= bkg_no;
        this.blNo							= bl_no;

    }
    
    /**
     * ExpPap0004Event를 생성한다.
     * 
     * @param emptyAvailabilityInquiryRequest
     */
    public ExpPap0004Event(
    		EmptyAvailabilityInquiryRequest emptyAvailabilityInquiryRequest
	) {
    	this.emptyAvailabilityInquiryRequest	= emptyAvailabilityInquiryRequest;		
    }
    
    

    
	/**
	 * @return
	 */
    public String getPeriod_flg()	{		
    	return periodFlg;					}
	/**
	 * @return
	 */
	public String getFrom_dt()						 {		
		return fromDt;					}
	/**
	 * @return
	 */
	public String getTo_dt()							 {		
		return toDt;						}	
	/**
	 * @return
	 */
	public String getFreight_collect_flg()            {		
		return freightCollectFlg;            	}
	/**
	 * @return
	 */
	public String getOriginal_bl_flg()      {		
		return originalBlFlg;      	}
	/**
	 * @return
	 */
	public String getCustoms_flg() 		{		
		return customsFlg; 	}
	/**
	 * @return
	 */
	public String getCntr_pkup_no_flg()  {		
		return cntrPkupNoFlg;                     	}

	/**
	 * @return
	 */
	public String getTrsp_wo_no()	{		
		return trspWoNo;					}
	/**
	 * @return
	 */
	public String getEq_no()					 {		
		return eqNo;							}
	/**
	 * @return
	 */
	public String getBkg_no()					 {		
		return bkgNo;						}
	/**
	 * @return
	 */
	public String getBl_no()					 {		
		return blNo;							}

	
	public String getAvailable_sts_flg()  {		
		return availableStsFlg;                     	}

	/**
	 * @return
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @return
	 */
	public void setUserID(String userID) {
		this.userID = userID;
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
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	
	/**
	 * @return
	 */
    public String getEventName() {
        return "ExpPap0004Event";
    }

	/**
	 * @return
	 */
    public String toString() {
        return "ExpPap0004Event";
    }


	/**
	 * @return Returns the emptyAvailabilityInquiryRequest.
	 */
	public EmptyAvailabilityInquiryRequest getEmptyAvailabilityInquiryRequest() {
		return emptyAvailabilityInquiryRequest;
	}	

    
}
