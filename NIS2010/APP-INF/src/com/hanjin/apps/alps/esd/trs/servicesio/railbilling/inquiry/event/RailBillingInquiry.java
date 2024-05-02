/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquiry.java
*@FileTitle : Rail Billing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingInquiry implements java.io.Serializable {
	/** (Param 객체) */
	
	private String rowIdx = null;
	private String soOfcCity = null;
	private String soSeq = null;
	private String cargo = null;
	private String bkgNo = null;
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String cntrTpszNm = null;
	private String statusCd = null;
	private String statusNm = null;
	private String railOrg = null;
	private String railDest = null;
	private String reqDt = null;
	private String railBillDt = null;
	private String cnclDt = null;
	private String cnclReqRsn = null;
	private String cnclReqRjtRsn = null;
	
	private String bilIssKnt		 = null;
	private String spclInstrRmk	 = null;
	private String railOrdRjctFlg = null;
	private String woRjctRsn       = null;
	private String interRmk          = null;
	private String fmNodCd         = null;
	private String toNodCd         = null;
	private String blNo             = null;
	private String blNoTp          = null;
	private String blNoChk         = null;
	private String bkgCgoTpCd     = null;
	private String copNo            = null;
	private String costActGrpSeq  = null;
	private String repoPlnId       = null;
	private String plnYrwk          = null;
	private String refId            = null;
	private String refSeq           = null;
	private String trspRqstBkgFlg = null;
	private String cgoTpCd = null;
    private String vndrSeq = null;
    
    private String ofcCd = null;
    
	/**
	 * @return Returns the bil_iss_knt.
	 */
	public String getBil_iss_knt() {
		return bilIssKnt;
	}
	/**
	 * @param bil_iss_knt The bil_iss_knt to set.
	 */
	public void setBil_iss_knt(String bil_iss_knt) {
		this.bilIssKnt = bil_iss_knt;
	}
	/**
	 * @return Returns the bkg_cgo_tp_cd.
	 */
	public String getBkg_cgo_tp_cd() {
		return bkgCgoTpCd;
	}
	/**
	 * @param bkg_cgo_tp_cd The bkg_cgo_tp_cd to set.
	 */
	public void setBkg_cgo_tp_cd(String bkg_cgo_tp_cd) {
		this.bkgCgoTpCd = bkg_cgo_tp_cd;
	}
	/**
	 * @return Returns the bl_no.
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * @param bl_no The bl_no to set.
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}
	/**
	 * @return Returns the bl_no_chk.
	 */
	public String getBl_no_chk() {
		return blNoChk;
	}
	/**
	 * @param bl_no_chk The bl_no_chk to set.
	 */
	public void setBl_no_chk(String bl_no_chk) {
		this.blNoChk = bl_no_chk;
	}
	/**
	 * @return Returns the bl_no_tp.
	 */
	public String getBl_no_tp() {
		return blNoTp;
	}
	/**
	 * @param bl_no_tp The bl_no_tp to set.
	 */
	public void setBl_no_tp(String bl_no_tp) {
		this.blNoTp = bl_no_tp;
	}
	/**
	 * @return Returns the cop_no.
	 */
	public String getCop_no() {
		return copNo;
	}
	/**
	 * @param cop_no The cop_no to set.
	 */
	public void setCop_no(String cop_no) {
		this.copNo = cop_no;
	}
	/**
	 * @return Returns the cost_act_grp_seq.
	 */
	public String getCost_act_grp_seq() {
		return costActGrpSeq;
	}
	/**
	 * @param cost_act_grp_seq The cost_act_grp_seq to set.
	 */
	public void setCost_act_grp_seq(String cost_act_grp_seq) {
		this.costActGrpSeq = cost_act_grp_seq;
	}
	/**
	 * @return Returns the fm_nod_cd.
	 */
	public String getFm_nod_cd() {
		return fmNodCd;
	}
	/**
	 * @param fm_nod_cd The fm_nod_cd to set.
	 */
	public void setFm_nod_cd(String fm_nod_cd) {
		this.fmNodCd = fm_nod_cd;
	}
	/**
	 * @return Returns the pln_yrwk.
	 */
	public String getPln_yrwk() {
		return plnYrwk;
	}
	/**
	 * @param pln_yrwk The pln_yrwk to set.
	 */
	public void setPln_yrwk(String pln_yrwk) {
		this.plnYrwk = pln_yrwk;
	}
	/**
	 * @return Returns the rail_ord_rjct_flg.
	 */
	public String getRail_ord_rjct_flg() {
		return railOrdRjctFlg;
	}
	/**
	 * @param rail_ord_rjct_flg The rail_ord_rjct_flg to set.
	 */
	public void setRail_ord_rjct_flg(String rail_ord_rjct_flg) {
		this.railOrdRjctFlg = rail_ord_rjct_flg;
	}
	/**
	 * @return Returns the ref_id.
	 */
	public String getRef_id() {
		return refId;
	}
	/**
	 * @param ref_id The ref_id to set.
	 */
	public void setRef_id(String ref_id) {
		this.refId = ref_id;
	}
	/**
	 * @return Returns the ref_seq.
	 */
	public String getRef_seq() {
		return refSeq;
	}
	/**
	 * @param ref_seq The ref_seq to set.
	 */
	public void setRef_seq(String ref_seq) {
		this.refSeq = ref_seq;
	}
	/**
	 * @return Returns the repo_pln_id.
	 */
	public String getRepo_pln_id() {
		return repoPlnId;
	}
	/**
	 * @param repo_pln_id The repo_pln_id to set.
	 */
	public void setRepo_pln_id(String repo_pln_id) {
		this.repoPlnId = repo_pln_id;
	}
	/**
	 * @return Returns the spcl_instr_rmk.
	 */
	public String getSpcl_instr_rmk() {
		return spclInstrRmk;
	}
	/**
	 * @param spcl_instr_rmk The spcl_instr_rmk to set.
	 */
	public void setSpcl_instr_rmk(String spcl_instr_rmk) {
		this.spclInstrRmk = spcl_instr_rmk;
	}
	/**
	 * @return Returns the to_nod_cd.
	 */
	public String getTo_nod_cd() {
		return toNodCd;
	}
	/**
	 * @param to_nod_cd The to_nod_cd to set.
	 */
	public void setTo_nod_cd(String to_nod_cd) {
		this.toNodCd = to_nod_cd;
	}
	/**
	 * @return Returns the wo_rjct_rsn.
	 */
	public String getWo_rjct_rsn() {
		return woRjctRsn;
	}
	/**
	 * @param wo_rjct_rsn The wo_rjct_rsn to set.
	 */
	public void setWo_rjct_rsn(String wo_rjct_rsn) {
		this.woRjctRsn = wo_rjct_rsn;
	}
	/**
	 * @return Returns the bkg_no.
	 */
	public String getBkg_no() {
		return bkgNo;
	}
	/**
	 * @param bkg_no The bkg_no to set.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	/**
	 * @return Returns the cargo.
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo The cargo to set.
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return Returns the cncl_dt.
	 */
	public String getCncl_dt() {
		return cnclDt;
	}
	/**
	 * @param cncl_dt The cncl_dt to set.
	 */
	public void setCncl_dt(String cncl_dt) {
		this.cnclDt = cncl_dt;
	}
	/**
	 * @return Returns the cncl_req_rjt_rsn.
	 */
	public String getCncl_req_rjt_rsn() {
		return cnclReqRjtRsn;
	}
	/**
	 * @param cncl_req_rjt_rsn The cncl_req_rjt_rsn to set.
	 */
	public void setCncl_req_rjt_rsn(String cncl_req_rjt_rsn) {
		this.cnclReqRjtRsn = cncl_req_rjt_rsn;
	}
	/**
	 * @return Returns the cncl_req_rsn.
	 */
	public String getCncl_req_rsn() {
		return cnclReqRsn;
	}
	/**
	 * @param cncl_req_rsn The cncl_req_rsn to set.
	 */
	public void setCncl_req_rsn(String cncl_req_rsn) {
		this.cnclReqRsn = cncl_req_rsn;
	}
	/**
	 * @return Returns the cntr_no.
	 */
	public String getCntr_no() {
		return cntrNo;
	}
	/**
	 * @param cntr_no The cntr_no to set.
	 */
	public void setCntr_no(String cntr_no) {
		this.cntrNo = cntr_no;
	}
	/**
	 * @return Returns the cntr_tpsz_cd.
	 */
	public String getCntr_tpsz_cd() {
		return cntrTpszCd;
	}
	/**
	 * @param cntr_tpsz_cd The cntr_tpsz_cd to set.
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntrTpszCd = cntr_tpsz_cd;
	}
	/**
	 * @return Returns the cntr_tpsz_nm.
	 */
	public String getCntr_tpsz_nm() {
		return cntrTpszNm;
	}
	/**
	 * @param cntr_tpsz_nm The cntr_tpsz_nm to set.
	 */
	public void setCntr_tpsz_nm(String cntr_tpsz_nm) {
		this.cntrTpszNm = cntr_tpsz_nm;
	}
	/**
	 * @return Returns the rail_bill_dt.
	 */
	public String getRail_bill_dt() {
		return railBillDt;
	}
	/**
	 * @param rail_bill_dt The rail_bill_dt to set.
	 */
	public void setRail_bill_dt(String rail_bill_dt) {
		this.railBillDt = rail_bill_dt;
	}
	/**
	 * @return Returns the rail_dest.
	 */
	public String getRail_dest() {
		return railDest;
	}
	/**
	 * @param rail_dest The rail_dest to set.
	 */
	public void setRail_dest(String rail_dest) {
		this.railDest = rail_dest;
	}
	/**
	 * @return Returns the rail_org.
	 */
	public String getRail_org() {
		return railOrg;
	}
	/**
	 * @param rail_org The rail_org to set.
	 */
	public void setRail_org(String rail_org) {
		this.railOrg = rail_org;
	}
	/**
	 * @return Returns the req_dt.
	 */
	public String getReq_dt() {
		return reqDt;
	}
	/**
	 * @param req_dt The req_dt to set.
	 */
	public void setReq_dt(String req_dt) {
		this.reqDt = req_dt;
	}
	/**
	 * @return Returns the row_idx.
	 */
	public String getRow_idx() {
		return rowIdx;
	}
	/**
	 * @param row_idx The row_idx to set.
	 */
	public void setRow_idx(String row_idx) {
		this.rowIdx = row_idx;
	}
	/**
	 * @return Returns the so_ofc_city.
	 */
	public String getSo_ofc_city() {
		return soOfcCity;
	}
	/**
	 * @param so_ofc_city The so_ofc_city to set.
	 */
	public void setSo_ofc_city(String so_ofc_city) {
		this.soOfcCity = so_ofc_city;
	}
	/**
	 * @return Returns the so_seq.
	 */
	public String getSo_seq() {
		return soSeq;
	}
	/**
	 * @param so_seq The so_seq to set.
	 */
	public void setSo_seq(String so_seq) {
		this.soSeq = so_seq;
	}
	/**
	 * @return Returns the status_cd.
	 */
	public String getStatus_cd() {
		return statusCd;
	}
	/**
	 * @param status_cd The status_cd to set.
	 */
	public void setStatus_cd(String status_cd) {
		this.statusCd = status_cd;
	}
	/**
	 * @return Returns the status_nm.
	 */
	public String getStatus_nm() {
		return statusNm;
	}
	/**
	 * @param status_nm The status_nm to set.
	 */
	public void setStatus_nm(String status_nm) {
		this.statusNm = status_nm;
	}
	/**
	 * @return Returns the inter_rmk.
	 */
	public String getInter_rmk() {
		return interRmk;
	}
	/**
	 * @param inter_rmk The inter_rmk to set.
	 */
	public void setInter_rmk(String inter_rmk) {
		this.interRmk = inter_rmk;
	}
	/**
	 * @return Returns the trsp_rqst_bkg_flg.
	 */
	public String getTrsp_rqst_bkg_flg() {
		return trspRqstBkgFlg;
	}
	/**
	 * @param trsp_rqst_bkg_flg The trsp_rqst_bkg_flg to set.
	 */
	public void setTrsp_rqst_bkg_flg(String trsp_rqst_bkg_flg) {
		this.trspRqstBkgFlg = trsp_rqst_bkg_flg;
	}
	/**
	 * @return Returns the cgo_tp_cd.
	 */
	public String getCgo_tp_cd() {
		return cgoTpCd;
	}
	/**
	 * @param cgo_tp_cd The cgo_tp_cd to set.
	 */
	public void setCgo_tp_cd(String cgo_tp_cd) {
		this.cgoTpCd = cgo_tp_cd;
	}
	/**
	 * @return Returns the vndr_seq.
	 */
	public String getVndr_seq() {
		return vndrSeq;
	}
	/**
	 * @param vndr_seq The vndr_seq to set.
	 */
	public void setVndr_seq(String vndr_seq) {
		this.vndrSeq = vndr_seq;
	}
	/**
	 * @return Returns the ofc_cd.
	 */
	public String getOfc_cd() {
		return ofcCd;
	}
	/**
	 * @param ofc_cd The ofc_cd to set.
	 */
	public void setOfc_cd(String ofc_cd) {
		this.ofcCd = ofc_cd;
	}
	
	
	
	
}
