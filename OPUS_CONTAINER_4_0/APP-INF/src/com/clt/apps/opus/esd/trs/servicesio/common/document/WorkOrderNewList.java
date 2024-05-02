/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderNewList.java
*@FileTitle : WorkOrderNewList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_005Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_005EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderNewList {
	/** (Param 객체) */
	private int seq = 0;
	private	String trspSoNo				= "";	//S/O No
	private	String issueTypeCd			= "";	//Issue Type                                 
	private	String issueTypeNm			= "";	//Issue Type                                 
	private	String trspWoNo				= "";	//W/O No
	private	String trspKindCd		= "";	//Transportation Kind                     
	private	String trspKindNm		= "";	//Transportation Kind                     
	private	String trspModeCd			= "";	//Transportation Mode                   
	private	String trspModeNm			= "";	//Transportation Mode                   
	private	String trspTypeCd		= "";	//Transportation Type
	private	String trspTypeNm		= "";	//Transportation Type
	private	String dispDt					= "";	//Dispatched Time                         
	private	String woStatus					= "";	//WorkOrder Status                        
	private	String woReject	= "";	//Reject 여부     
	private	String invoicedFlg		= "";	//Invoice 처리 여부  FLG(Y,N,Partially)                            
                            

	public int getSeq()                 		{		return seq ;                 	}
	public String getTrsp_so_no()			{		return trspSoNo;					}
	public String getIssue_type_cd()		{		return issueTypeCd;				}
	public String getIssue_type_nm()	{		return issueTypeNm;				}
	public String getTrsp_wo_no()		{		return trspWoNo;					}
	public String getTrsp_kind_cd()		{		return trspKindCd;		}
	public String getTrsp_mode_cd()		{		return trspModeCd	;			}
	public String getTrsp_type_cd()		{		return trspTypeCd;		}
	public String getTrsp_kind_nm()	{		return trspKindNm;		}
	public String getTrsp_mode_nm()			{		return trspModeNm	;			}
	public String getTrsp_type_nm()		{		return trspTypeNm;		}
	public String getDisp_dt()							{		return dispDt;							}
	public String getWo_status()							{		return woStatus;							}
	public String getWo_reject()	{		return woReject;	}
	public String getInvoiced_flg()		{		return invoicedFlg;		}


	public void	setSeq             	(int	seq 				) {		this.seq			= seq ;                 	}                 
	public void	setTrsp_so_no					(String	trsp_so_no					) {		this.trspSoNo					= trsp_so_no;					}
	public void	setIssue_type_cd				(String	Issue_type_cd				) {		this.issueTypeCd				= Issue_type_cd;			}                 
	public void	setIssue_type_nm				(String	Issue_type_nm				) {		this.issueTypeNm				= Issue_type_nm;			}                 
	public void	setTrsp_wo_no					(String	trsp_wo_no					) {		this.trspWoNo					= trsp_wo_no;					}
	public void	setTrsp_kind_cd		(String	trsp_kind_cd		) {		this.trspKindCd		= trsp_kind_cd; }                 
	public void	setTrsp_mode_cd			(String	trsp_mode_cd				) {		this.trspModeCd			= trsp_mode_cd;			}                 
	public void	setTrsp_type_cd			(String	trsp_type_cd			) {		this.trspTypeCd		= trsp_type_cd;	}                 
	public void	setTrsp_kind_nm		(String	trsp_kind_nm		) {		this.trspKindNm		= trsp_kind_nm; }                 
	public void	setTrsp_mode_nm			(String	trsp_mode_nm				) {		this.trspModeNm			= trsp_mode_nm;			}                 
	public void	setTrsp_type_nm			(String	trsp_type_nm			) {		this.trspTypeNm		= trsp_type_nm;	}                 
	public void	setDisp_dt							(String	disp_dt							) {		this.dispDt							= disp_dt;						}                 
	public void	setWo_status							(String	wo_status							) {		this.woStatus							= wo_status;						}                 
	public void	setWo_reject		(String	wo_reject		) {		this.woReject	= wo_reject;	}                 
	public void	setInvoiced_flg		(String	invoiced_flg		) {		this.invoicedFlg		= invoiced_flg;		}                 
                
																																							                                                            

}
