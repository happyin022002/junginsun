/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxRetrive.java
*@FileTitle	: WorkOrderInbox
*Open Issues :
*Change	history	:
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion :	1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package	com.hanjin.apps.alps.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_001 에 대한 WebService Document Object including	Parameters<br>
 * - TrsSppIWSProxy의 Input	Parameter<br>
 * - EXP_PAP_001Event로	변환하여 사용<br>
 *
 * @author doomi
 * @see	TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */

public class WorkOrderInboxRetrive { 
	
	/**	(Param 객체) */
	private String userID 			= "";
	private String vendorCode 		= "";
	private String parentVendorCode = "";

	private	String dispDtFrom 		= "";						//Dispatched Date
	private	String dispDtTo 		= "";						//Dispatched Date
	private	String woStatus 		= "";							//Status : W/O 처리상태
	private	String issueTypeCd 		= "";					//Issue	Type : 발행type
	private	String invoicedCd 		= "";				//Invoiced 처리	여부
	private	String trspKindCd 		= "";				//Transportation Kind
	private	String trspModeCd 		= "";					//Transportation Mode
	private	String trspTypeCd		= "";				//Transportation Type
	private	String fmLocationCd 	= "";						//From Location
	private	String toLocationCd 	= "";						//To Location
	private	String viaLocationCd 	= "";						//Via Location
	private	String dorLocationCd 	= "";						//Door Location
	private	String winCd 			= "";						//Door Location
	

	public String getUserID() 					{		return userID;			}
	public String getVendorCode() 				{		return vendorCode;		}
	public String getDisp_dt_from()				{		return dispDtFrom;		}
	public String getDisp_dt_to()				{		return dispDtTo;		}
	public String getWo_status()				{		return woStatus;		}
	public String getIssue_type_cd()			{		return issueTypeCd;		}
	public String getInvoiced_cd()   			{		return invoicedCd;		}
	public String getTrsp_kind_cd() 			{		return trspKindCd;		}
	public String getTrsp_mode_cd()		 		{		return trspModeCd;		}
	public String getTrsp_type_cd()	 			{		return trspTypeCd;		}
	public String getFm_location_cd()			{		return fmLocationCd;	}
	public String getTo_location_cd()			{		return toLocationCd;	}
	public String getVia_location_cd()			{		return viaLocationCd;	}
	public String getDor_location_cd()			{		return dorLocationCd;	}
	public String getWin_cd()				 	{		return winCd;			}
	
	
	public void setUserID(String userID) 					{		this.userID 		= userID;			}
	public void setVendorCode(String vendorCode)			{		this.vendorCode 	= vendorCode;		}
	public void	setDisp_dt_from(String disp_dt_from) 		{		this.dispDtFrom		= disp_dt_from;		}
	public void	setDisp_dt_to(String disp_dt_to) 			{		this.dispDtTo		= disp_dt_to;		}
	public void	setWo_status(String	wo_status) 				{		this.woStatus		= wo_status;		}
	public void	setIssue_type_cd(String	Issue_type_cd) 		{		this.issueTypeCd	= Issue_type_cd;	}
	public void	setInvoiced_cd(String invoiced_cd) 			{		this.invoicedCd		= invoiced_cd;		}
	public void	setTrsp_kind_cd(String trsp_kind_cd) 		{		this.trspKindCd		= trsp_kind_cd;		}
	public void	setTrsp_mode_cd(String trsp_mode_cd) 		{		this.trspModeCd		= trsp_mode_cd;		}
	public void	setTrsp_type_cd(String trsp_type_cd) 		{		this.trspTypeCd		= trsp_type_cd;		}
	public void	setFm_location_cd(String fm_location_cd) 	{		this.fmLocationCd	= fm_location_cd;	}
	public void	setTo_location_cd(String to_location_cd) 	{		this.toLocationCd	= to_location_cd;	}
	public void	setVia_location_cd(String via_location_cd) 	{		this.viaLocationCd	= via_location_cd;	}
	public void	setDor_location_cd(String dor_location_cd) 	{		this.dorLocationCd	= dor_location_cd;	}
	public void	setWin_cd(String win_cd) 				{		this.winCd			= win_cd;			}
	
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
