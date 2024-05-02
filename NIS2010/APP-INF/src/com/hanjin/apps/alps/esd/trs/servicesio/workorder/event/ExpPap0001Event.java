/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EXP_PAP_001Event.java
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
 * EXP_PAP_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_PAP_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ExpPap0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String dispDtFrom		= "";
	private String dispDtTo			= "";
    private String woStatus			= "";
    private String issueTypeCd		= "";
    private String invoicedCd		= "";
	private String trspKindCd		= "";
	private String trspModeCd		= "";
    private String trspTypeCd		= "";
    private String fmLocationCd		= "";
    private String toLocationCd		= "";
	private String viaLocationCd	= "";
	private String dorLocationCd	= "";
	private String winCd			= "";
	
    private String trspWoNo			= ""; //M2
    private String eqTpCd			= ""; //M2
    private String eqNo				= ""; //M2
    private String bidNo			= "";
	private String bkgNo			= ""; //M2
	private String blNo				= ""; //M2

	private String userID 			= "";
	private String vendorCode 		= "";
	private String parentVendorCode = "";
	
	private String workOrderNo		 = "";
	
	
	/**
	 * 
	 * @return
	 */
	public ExpPap0001Event(){}

	
    /**
     * ExpPap0001Event 생성자
     * 
     * @param parentVendorCode
     * @param vendorCode
     * @param disp_dt_from
     * @param disp_dt_to
     * @param wo_status
     * @param Issue_type_cd
     * @param invoiced_cd
     * @param trsp_kind_cd
     * @param trsp_mode_cd
     * @param trsp_type_cd
     * @param fm_location_cd
     * @param to_location_cd
     * @param via_location_cd
     * @param dor_location_cd
     */
    public ExpPap0001Event(
    		String parentVendorCode,
    		String vendorCode,
    		String disp_dt_from,				
    		String disp_dt_to,					
    		String wo_status,						
    		String Issue_type_cd,			
    		String invoiced_cd,	
    		String trsp_kind_cd,			
    		String trsp_mode_cd,		
    		String trsp_type_cd,	
    		String fm_location_cd,				
    		String to_location_cd,				
    		String via_location_cd,				
    		String dor_location_cd,
    		String win_cd
	) {
    	this.parentVendorCode	= parentVendorCode;		
    	this.vendorCode			= vendorCode;		
    	this.dispDtFrom			= disp_dt_from;				
    	this.dispDtTo			= disp_dt_to;					
    	this.woStatus			= wo_status;						
    	this.issueTypeCd		= Issue_type_cd;			
    	this.invoicedCd			= invoiced_cd;
    	this.trspKindCd			= trsp_kind_cd;			
    	this.trspModeCd			= trsp_mode_cd;		
    	this.trspTypeCd			= trsp_type_cd;	
    	this.fmLocationCd		= fm_location_cd;				
    	this.toLocationCd		= to_location_cd;				
    	this.viaLocationCd		= via_location_cd;				
    	this.dorLocationCd		= dor_location_cd;
    	this.winCd				= win_cd;

    }

    /**
     *  ExpPap0001Event 생성자
     *  
     * @param parentVendorCode
     * @param vendorCode
     * @param trsp_wo_no
     * @param eq_tp_cd
     * @param eq_no
     * @param bkg_no
     * @param bl_no
     */
    public ExpPap0001Event(
    		String parentVendorCode,
       		String vendorCode,
       		String trsp_wo_no,				
       	 	String eq_tp_cd,		
       	 	String eq_no,		
    		String bkg_no,					
    		String bl_no,
    		String bid_no
	) {
    	this.parentVendorCode	= parentVendorCode;		
    	this.vendorCode			= vendorCode;		
    	this.trspWoNo			= trsp_wo_no;				
    	this.eqTpCd				= eq_tp_cd;						
        this.eqNo				= eq_no;						
        this.bkgNo				= bkg_no;					
        this.blNo				= bl_no;
        this.bidNo				= bid_no;

    }


    
    /**
     *  ExpPap0001Event 생성자
     *  
     * @param WorkOrderNo
     * @param vendorCode
     */
    public ExpPap0001Event(
    		String WorkOrderNo,
    		String vendorCode
	) {
    	this.workOrderNo	= WorkOrderNo;	
    	this.vendorCode		= vendorCode;	
    }
    
    /**
     * ExpPap0001Event 생성
     * 
     * @param WorkOrderNo
     */
    public ExpPap0001Event(
    		String WorkOrderNo
	) {
    	this.workOrderNo	= WorkOrderNo;							
    }
    
    
	public String getDisp_dt_from()				 	{		return dispDtFrom;		}
	public String getDisp_dt_to()					{		return dispDtTo;		}
	public String getWo_status()					{		return woStatus;		}
	public String getIssue_type_cd()			 	{ 		return issueTypeCd;		}
	public String getInvoiced_cd()					{		return invoicedCd;		}
	public String getTrsp_kind_cd()					{		return trspKindCd;		}
	public String getTrsp_mode_cd()		 			{		return trspModeCd;		}
	public String getTrsp_type_cd() 				{		return trspTypeCd;		}
	public String getFm_location_cd()				{		return fmLocationCd;	}
	public String getTo_location_cd()				{		return toLocationCd;	}
	public String getVia_location_cd()				{		return viaLocationCd;	}
	public String getDor_location_cd()				{		return dorLocationCd;	}
	public String getWin_cd()						{		return winCd;			}
	
	public String getTrsp_wo_no()			 		{		return trspWoNo;		}
	public String getEq_tp_cd()					 	{		return eqTpCd;			}
	public String getEq_no()						{		return eqNo;			}
	public String getBid_no()						{		return bidNo;			}
	public String getBkg_no()					 	{		return bkgNo;			}
	public String getBl_no()						{		return blNo;							}

	public String getWorkOrderNo()		 			{		return workOrderNo; 	}

	
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
        return "ExpPap0001Event";
    }

    public String toString() {
        return "ExpPap0001Event";
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

    
}
