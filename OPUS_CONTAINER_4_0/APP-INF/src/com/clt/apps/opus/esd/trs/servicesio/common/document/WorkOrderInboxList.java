/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxList.java
*@FileTitle : WorkOrderInboxList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderInboxList {
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
	private String woIssKnt = ""; 
	private String vendorCode = "";
	private String vendorName = "";
	private String vendorAddress = "";
	private String vendorTelNo = "";
	private String vendorFaxNo = "";
	private String fromYard	= "";
	private String toYard		= "";
	private String cntrNo		= "";
	private String cntrTpsz	= "";
	private String cntrWgt		= "";
	private int    woBasicAmt = 0;
	private int    invEtcAddAmt = 0;
	private int    invAmt		= 0;
	private String invNo		= "";
	private String invCnfmYn  = "";
	private String sppInvActStsNm = "";
	private String preDisUseFlg = "";
	private String bkgNo		= "";
	private String bkgNoSplit = "";
	private String blNo		= "";
	private String vvdNo		= "";
	private String pkupNo		= "";
	private String freeDt		= "";
	private String avalDt		= "";
	private String freightCollectFlg	= "";
	private String originalBlFlg = "";
	private String customsFlg	= "";
	private String trspBndCd	= "";
	private String woOfficeCd = "";
	private String issOfficeCd = "";
	private String issUsr		 = "";
	private String invOfficeCd = "";
	private String invUsr		 = "";
	private String woReceiver   = "";
	private String emailDt		 = "";
	private String pkupYard	 = "";
	private String returnYard   = "";
	private String remark		 = "";
	private String scNo		 = "";
	private String shprCustNm	 = "";
	private String cneeCustNm	 = "";
	private String lstLocCd	 = "";
	private String apntDt		 = "";
	private String deliveryDt   = "";
		
	//2007-10-11 by KJJ: 요청에 따른 추가.
	private String trspSoTpCd = "";
	
	private String obVvdCd   = "";
	private String n1stNodPlnDt   = "";
	private String lstNodPlnDt   = "";
	private String spclCgoCntrTpCd   = "";
	private String bkgQty   = "";
	private String podCd   = "";
	
	private String woTotAmtUsd   = "";
	private String invCurrCd   = "";
	private String invXchRt   = "";
	
	public int getSeq()                 {		return seq ;                }
	public String getTrsp_so_no()		{		return trspSoNo;			}
	public String getIssue_type_cd()	{		return issueTypeCd;		}
	public String getIssue_type_nm()	{		return issueTypeNm;		}
	public String getTrsp_wo_no()		{		return trspWoNo;			}
	public String getTrsp_kind_cd()		{		return trspKindCd;		}
	public String getTrsp_mode_cd()		{		return trspModeCd	;		}
	public String getTrsp_type_cd()		{		return trspTypeCd;		}
	public String getTrsp_kind_nm()		{		return trspKindNm;		}
	public String getTrsp_mode_nm()		{		return trspModeNm	;		}
	public String getTrsp_type_nm()		{		return trspTypeNm;		}
	public String getDisp_dt()			{		return dispDt;				}
	public String getWo_status()		{		return woStatus;			}
	public String getWo_reject()		{		return woReject;			}
	public String getInvoiced_flg()		{		return invoicedFlg;		}
	public String getWo_iss_knt()		{		return woIssKnt;			}
	public String getVendorName()		{	    return vendorName;		}
	public String getVendorCode()		{		return vendorCode;			}
	public String getVendorAddress()	{		return vendorAddress;		}
	public String getVendorTelNo()		{		return vendorTelNo;			}
	public String getVendorFaxNo()		{		return vendorFaxNo;			}
	 public String getFrom_yard			    ()		{		return fromYard			;		}	
	 public String getTo_yard		        ()		{		return toYard		        ;		}
	 public String getCntr_no		        ()		{		return cntrNo		        ;		}
	 public String getCntr_tpsz	            ()		{		return cntrTpsz	        ;		}
	 public String getCntr_wgt		        ()		{		return cntrWgt		        ;		}
	 public int    getWo_basic_amt          ()		{		return woBasicAmt         ;		}
	 public int    getInv_etc_add_amt       ()		{		return invEtcAddAmt      ;		}
	 public int    getInv_amt		        ()		{		return invAmt		        ;		}
	 public String getInv_no		        ()		{		return invNo		        ;		}
	 public String getInv_cnfm_yn           ()		{		return invCnfmYn          ;		}
	 public String getSpp_inv_act_sts_nm    ()		{		return sppInvActStsNm   ;		}
	 public String getPre_dis_use_flg       ()		{		return preDisUseFlg      ;		}
	 public String getBkg_no		        ()		{		return bkgNo		        ;		}
	 public String getBkg_no_split          ()		{		return bkgNoSplit         ;		}
	 public String getBl_no		            ()		{		return blNo		        ;		}
	 public String getVvd_no		        ()		{		return vvdNo		        ;		}
	 public String getPkup_no		        ()		{		return pkupNo		        ;		}
	 public String getFree_dt		        ()		{		return freeDt		        ;		}
	 public String getAval_dt		        ()		{		return avalDt		        ;		}
	 public String getFreight_collect_flg	()		{		return freightCollectFlg	;		}
	 public String getOriginal_bl_flg       ()		{		return originalBlFlg      ;		}
	 public String getCustoms_flg	        ()		{		return customsFlg	        ;		}
	 public String getTrsp_bnd_cd	        ()		{		return trspBndCd	        ;		}
	 public String getWo_office_cd          ()		{		return woOfficeCd         ;		}
	 public String getIss_office_cd         ()		{		return issOfficeCd        ;		}
	 public String getInv_office_cd         ()		{		return invOfficeCd        ;		}
	 public String getInv_usr		        ()		{		return invUsr		        ;		}
	 public String getWo_receiver           ()		{		return woReceiver          ;		}
	 public String getEmail_dt		        ()		{		return emailDt		        ;		}
	 public String getPkup_yard	            ()		{		return pkupYard	        ;		}
	 public String getReturn_yard           ()		{		return returnYard          ;		}
	 public String getRemark		        ()		{		return remark		        ;		}
	 public String getSc_no		            ()		{		return scNo		        ;		}
	 public String getShpr_cust_nm	        ()		{	    return shprCustNm	        ;		}
	 public String getCnee_cust_nm	        ()		{	    return cneeCustNm	        ;		}
	 public String getLst_loc_cd	        ()		{		return lstLocCd	        ;		}
	 public String getApnt_dt		        ()		{		return apntDt		        ;		}
	 public String getDelivery_dt           ()		{		return deliveryDt          ;		}
	 public String getIss_usr		        ()		{		return issUsr		        ;		}
		//2007-10-11 by KJJ: trsp_so_tp_cd = 'M' or 'O'인 경우, invoice Creation 프로세서 Blocking 요청에 의해서 추가.
	 public String getTrsp_so_tp_cd         ()      {		return trspSoTpCd		;		}

	public void	setSeq             			(int	seq 					) {		this.seq			= seq ;                 	}                 
	public void	setTrsp_so_no				(String	trsp_so_no				) {		this.trspSoNo					= trsp_so_no;					}
	public void	setIssue_type_cd			(String	Issue_type_cd			) {		this.issueTypeCd				= Issue_type_cd;			}                 
	public void	setIssue_type_nm			(String	Issue_type_nm			) {		this.issueTypeNm				= Issue_type_nm;			}                 
	public void	setTrsp_wo_no				(String	trsp_wo_no				) {		this.trspWoNo					= trsp_wo_no;					}
	public void	setTrsp_kind_cd				(String	trsp_kind_cd			) {		this.trspKindCd		= trsp_kind_cd; }                 
	public void	setTrsp_mode_cd				(String	trsp_mode_cd			) {		this.trspModeCd			= trsp_mode_cd;			}                 
	public void	setTrsp_type_cd				(String	trsp_type_cd			) {		this.trspTypeCd		= trsp_type_cd;	}                 
	public void	setTrsp_kind_nm				(String	trsp_kind_nm			) {		this.trspKindNm		= trsp_kind_nm; }                 
	public void	setTrsp_mode_nm				(String	trsp_mode_nm			) {		this.trspModeNm			= trsp_mode_nm;			}                 
	public void	setTrsp_type_nm				(String	trsp_type_nm			) {		this.trspTypeNm		= trsp_type_nm;	}                 
	public void	setDisp_dt					(String	disp_dt					) {		this.dispDt							= disp_dt;						}                 
	public void	setWo_status				(String	wo_status				) {		this.woStatus							= wo_status;						}                 
	public void	setWo_reject				(String	wo_reject				) {		this.woReject	= wo_reject;	}                 
	public void	setInvoiced_flg				(String	invoiced_flg			) {		this.invoicedFlg		= invoiced_flg;		}                 
	public void	setWo_iss_knt				(String	wo_iss_knt				) {		this.woIssKnt		= wo_iss_knt;		}                 
	public void	setVendorName				(String	vendorName				) {		this.vendorName		= StringEscapeUtils.escapeXml(vendorName);		}                 
	public void	setVendorCode				(String	vendorCode				) {		this.vendorCode		= vendorCode;		}                 
	public void	setVendorAddress			(String	vendorAddress			) {		this.vendorAddress		= StringEscapeUtils.escapeXml(vendorAddress);		}                 
	public void	setVendorTelNo				(String	vendorTelNo				) {		this.vendorTelNo		= vendorTelNo;		}                 
	public void	setVendorFaxNo				(String	vendorFaxNo				) {		this.vendorFaxNo		= vendorFaxNo;		}                 
	public void	setFrom_yard	            (String	from_yard	            ) {		this.fromYard	                		= from_yard	                ;		}                 
	public void	setTo_yard		            (String	to_yard		            ) {		this.toYard		            		= to_yard		            ;		}                 
	public void	setCntr_no		            (String	cntr_no		            ) {		this.cntrNo		            		= cntr_no		            ;		}                 
	public void	setCntr_tpsz	            (String	cntr_tpsz	            ) {		this.cntrTpsz	                		= cntr_tpsz	                ;		}                 
	public void	setCntr_wgt		            (String	cntr_wgt		        ) {		this.cntrWgt		            		= cntr_wgt		            ;		}                 
	public void	setWo_basic_amt             (int 	wo_basic_amt            ) {		this.woBasicAmt               		= wo_basic_amt              ;		}                 
	public void	setInv_etc_add_amt          (int 	inv_etc_add_amt         ) {		this.invEtcAddAmt            		= inv_etc_add_amt           ;		}                 
	public void	setInv_amt		            (int 	inv_amt		            ) {		this.invAmt		            		= inv_amt		            ;		}                 
	public void	setInv_no		            (String	inv_no		            ) {		this.invNo		                		= inv_no		            ;		}                 
	public void	setInv_cnfm_yn              (String	inv_cnfm_yn             ) {		this.invCnfmYn                		= inv_cnfm_yn               ;		}                 
	public void	setSpp_inv_act_sts_nm       (String	spp_inv_act_sts_nm      ) {		this.sppInvActStsNm         		= spp_inv_act_sts_nm        ;		}                 
	public void	setPre_dis_use_flg          (String	pre_dis_use_flg         ) {		this.preDisUseFlg            		= pre_dis_use_flg           ;		}                 
	public void	setBkg_no		            (String	bkg_no		            ) {		this.bkgNo		                		= bkg_no		            ;		}                 
	public void	setBkg_no_split             (String	bkg_no_split            ) {		this.bkgNoSplit               		= bkg_no_split              ;		}                 
	public void	setBl_no		            (String	bl_no		            ) {		this.blNo		                		= bl_no		                ;		}                 
	public void	setVvd_no		            (String	vvd_no		            ) {		this.vvdNo		                		= vvd_no		            ;		}                 
	public void	setPkup_no		            (String	pkup_no		            ) {		this.pkupNo		            		= pkup_no		            ;		}                 
	public void	setFree_dt		            (String	free_dt		            ) {		this.freeDt		            		= free_dt		            ;		}                 
	public void	setAval_dt		            (String	aval_dt		            ) {		this.avalDt		            		= aval_dt		            ;		}                 
	public void	setFreight_collect_flg	    (String	freight_collect_flg	    ) {		this.freightCollectFlg	    		= freight_collect_flg	    ;		}                 
	public void	setOriginal_bl_flg          (String	original_bl_flg         ) {		this.originalBlFlg            		= original_bl_flg           ;		}                 
	public void	setCustoms_flg	            (String	customs_flg	            ) {		this.customsFlg	            		= customs_flg	            ;		}                 
	public void	setTrsp_bnd_cd	            (String	trsp_bnd_cd	            ) {		this.trspBndCd	            		= trsp_bnd_cd	            ;		}                 
	public void	setWo_office_cd             (String	wo_office_cd            ) {		this.woOfficeCd               		= wo_office_cd              ;		}                 
	public void	setIss_office_cd            (String	iss_office_cd           ) {		this.issOfficeCd              		= iss_office_cd             ;		}                 
	public void	setIss_usr		            (String	iss_usr		            ) {		this.issUsr		            		= iss_usr		            ;		}                 
	public void	setInv_office_cd            (String	inv_office_cd           ) {		this.invOfficeCd              		= inv_office_cd             ;		}                 
	public void	setInv_usr		            (String	inv_usr		            ) {		this.invUsr		            		= inv_usr		            ;		}                 
	public void	setWo_receiver              (String	wo_receiver             ) {		this.woReceiver                		= wo_receiver               ;		}                 
	public void	setEmail_dt		            (String	email_dt		        ) {		this.emailDt		            		= email_dt		            ;		}                 
	public void	setPkup_yard	            (String	pkup_yard	            ) {		this.pkupYard	                		= pkup_yard	                ;		}                 
	public void	setReturn_yard              (String	return_yard             ) {		this.returnYard                		= return_yard               ;		}                 
	public void	setRemark		            (String	remark		            ) {		this.remark		                		= remark		            ;		}                 
	public void	setSc_no		            (String	sc_no		            ) {		this.scNo		                		= sc_no		                ;		}                 
	public void	setShpr_cust_nm	            (String	shpr_cust_nm	        ) {		this.shprCustNm	            		= StringEscapeUtils.escapeXml(shpr_cust_nm)	            ;		}                 
	public void	setCnee_cust_nm	            (String	cnee_cust_nm	        ) {		this.cneeCustNm	            		= StringEscapeUtils.escapeXml(cnee_cust_nm)	            ;		}                 
	public void	setLst_loc_cd	            (String	lst_loc_cd	            ) {		this.lstLocCd	                		= lst_loc_cd	            ;		}                 
	public void	setApnt_dt		            (String	apnt_dt		            ) {		this.apntDt		            		= apnt_dt		            ;		}                 
	public void	setDelivery_dt              (String	delivery_dt             ) {		this.deliveryDt                		= delivery_dt               ;		}                 
	//2007-10-11 by KJJ: trsp_so_tp_cd = 'M' or 'O'인 경우, invoice Creation 프로세서 Blocking 요청에 의해서 추가.
	public void setTrsp_so_tp_cd			(String trsp_so_tp_cd			) {		this.trspSoTpCd						= trsp_so_tp_cd				;		}
	/**
	 * @return Returns the bkg_qty.
	 */
	public String getBkg_qty() {
		return bkgQty;
	}
	/**
	 * @param bkg_qty The bkg_qty to set.
	 */
	public void setBkg_qty(String bkg_qty) {
		this.bkgQty = bkg_qty;
	}
	/**
	 * @return Returns the lst_nod_pln_dt.
	 */
	public String getLst_nod_pln_dt() {
		return lstNodPlnDt;
	}
	/**
	 * @param lst_nod_pln_dt The lst_nod_pln_dt to set.
	 */
	public void setLst_nod_pln_dt(String lst_nod_pln_dt) {
		this.lstNodPlnDt = lst_nod_pln_dt;
	}
	/**
	 * @return Returns the n1st_nod_pln_dt.
	 */
	public String getN1st_nod_pln_dt() {
		return n1stNodPlnDt;
	}
	/**
	 * @param n1st_nod_pln_dt The n1st_nod_pln_dt to set.
	 */
	public void setN1st_nod_pln_dt(String n1st_nod_pln_dt) {
		this.n1stNodPlnDt = n1st_nod_pln_dt;
	}
	/**
	 * @return Returns the ob_vvd_cd.
	 */
	public String getOb_vvd_cd() {
		return obVvdCd;
	}
	/**
	 * @param ob_vvd_cd The ob_vvd_cd to set.
	 */
	public void setOb_vvd_cd(String ob_vvd_cd) {
		this.obVvdCd = ob_vvd_cd;
	}
	/**
	 * @return Returns the pod_cd.
	 */
	public String getPod_cd() {
		return podCd;
	}
	/**
	 * @param pod_cd The pod_cd to set.
	 */
	public void setPod_cd(String pod_cd) {
		this.podCd = pod_cd;
	}
	/**
	 * @return Returns the spcl_cgo_cntr_tp_cd.
	 */
	public String getSpcl_cgo_cntr_tp_cd() {
		return spclCgoCntrTpCd;
	}
	/**
	 * @param spcl_cgo_cntr_tp_cd The spcl_cgo_cntr_tp_cd to set.
	 */
	public void setSpcl_cgo_cntr_tp_cd(String spcl_cgo_cntr_tp_cd) {
		this.spclCgoCntrTpCd = spcl_cgo_cntr_tp_cd;
	}
	/**
	 * @return Returns the inv_curr_cd.
	 */
	public String getInv_curr_cd() {
		return invCurrCd;
	}
	/**
	 * @param inv_curr_cd The inv_curr_cd to set.
	 */
	public void setInv_curr_cd(String inv_curr_cd) {
		this.invCurrCd = inv_curr_cd;
	}
	/**
	 * @return Returns the inv_xch_rt.
	 */
	public String getInv_xch_rt() {
		return invXchRt;
	}
	/**
	 * @param inv_xch_rt The inv_xch_rt to set.
	 */
	public void setInv_xch_rt(String inv_xch_rt) {
		this.invXchRt = inv_xch_rt;
	}
	/**
	 * @return Returns the wo_tot_amt_usd.
	 */
	public String getWo_tot_amt_usd() {
		return woTotAmtUsd;
	}
	/**
	 * @param wo_tot_amt_usd The wo_tot_amt_usd to set.
	 */
	public void setWo_tot_amt_usd(String wo_tot_amt_usd) {
		this.woTotAmtUsd = wo_tot_amt_usd;
	}               
}
