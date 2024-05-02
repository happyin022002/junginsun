/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceDiscrepancyCntr.java
*@FileTitle	: MarineTerminalStorageInvoiceDiscrepancyCntr
*Open Issues :
*Change	history	:
*@LastModifyDate : 2008-04-11
*@LastModifier : KJJ
*@LastVersion :	1.0
* 2008-04-11 KJJ
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

/**
 * @author 
 * @see TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */
public class MarineTerminalStorageInvoiceDiscrepancyCntrList {
	
	private String bbCgoFlg = null;
	private String wrkDt = null;
	private String clmDt = null;
	private String railBilDt = null;
	private String dscrRsn = null;
	private String hndlRsltRmk = null;
	private String cntrRmk = null;
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;
	private String tmlSoOfcCtyCd = null;
	private String tmlSoSeq = null;
	private String tmlSoCntrListSeq = null;
	private String vrfyRsltIndCd = null;
	private String modiFlg = null;
	private String dscrIndCd = null;
	private String tmlRvisIndFlg = null;
	private String ioBndCd = null;
	private String iocCd = null;
	private String laneCd = null;
	private String atbDt = null;
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String cntrStyCd = null;
	private String loclTsIndCd = null;
	private String samLoclTsIndCd = null;
	private String rcvdeTermIndCd = null;
	private String preYdCd = null;
	private String mvmtGateInDt = null;
	private String invGateInDt = null;
	private String gateInTdDys = null;
	private String mvmtGateOutDt = null;
	private String invGateOutDt = null;
	private String gateOutTdDys = null;
	private String mvmtStayDys = null;
	private String invStayDys = null;
	private String stayDiffDys = null;
	private String awkCgoFlg = null;
	private String rcFlg = null;
	private String dcgoClssCd = null;
	
	private String rvisIndFlg = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;
	private String fincVslCd = null;
	private String fincSkdVoyNo = null;
	private String fincSkdDirCd = null;
	private String bkgNo = null;
	private String bkgNoSplit = null;
	private String blNo = null;
	private String blNoTp = null;
	private String blNoChk = null;
	
	/**
	 * 
	 * @return
	 */
	public String getBkg_no() {
		return bkgNo;
	}

	/**
	 * 
	 * @param bkg_no
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}

	/**
	 * 
	 * @return
	 */
	public String getBkg_no_split() {
		return bkgNoSplit;
	}

	/**
	 * 
	 * @param bkg_no_split
	 */
	public void setBkg_no_split(String bkg_no_split) {
		this.bkgNoSplit = bkg_no_split;
	}

	/**
	 * 
	 * @return
	 */
	public String getBl_no() {
		return blNo;
	}

	/**
	 * 
	 * @param bl_no
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}

	/**
	 * 
	 * @return
	 */
	public String getBl_no_chk() {
		return blNoChk;
	}

	/**
	 * 
	 * @param bl_no_chk
	 */
	public void setBl_no_chk(String bl_no_chk) {
		this.blNoChk = bl_no_chk;
	}

	/**
	 * 
	 * @return
	 */
	public String getBl_no_tp() {
		return blNoTp;
	}

	/**
	 * 
	 * @param bl_no_tp
	 */
	public void setBl_no_tp(String bl_no_tp) {
		this.blNoTp = bl_no_tp;
	}

	/**
	 * 
	 * @return
	 */
	public String getFinc_skd_dir_cd() {
		return fincSkdDirCd;
	}

	/**
	 * 
	 * @param finc_skd_dir_cd
	 */
	public void setFinc_skd_dir_cd(String finc_skd_dir_cd) {
		this.fincSkdDirCd = finc_skd_dir_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getFinc_skd_voy_no() {
		return fincSkdVoyNo;
	}

	/**
	 * 
	 * @param finc_skd_voy_no
	 */
	public void setFinc_skd_voy_no(String finc_skd_voy_no) {
		this.fincSkdVoyNo = finc_skd_voy_no;
	}

	/**
	 * 
	 * @return
	 */
	public String getFinc_vsl_cd() {
		return fincVslCd;
	}

	/**
	 * 
	 * @param finc_vsl_cd
	 */
	public void setFinc_vsl_cd(String finc_vsl_cd) {
		this.fincVslCd = finc_vsl_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getRvis_ind_flg() {
		return rvisIndFlg;
	}

	/**
	 * 
	 * @param rvis_ind_flg
	 */
	public void setRvis_ind_flg(String rvis_ind_flg) {
		this.rvisIndFlg = rvis_ind_flg;
	}

	/**
	 * 
	 * @return
	 */
	public String getSkd_dir_cd() {
		return skdDirCd;
	}

	/**
	 * 
	 * @param skd_dir_cd
	 */
	public void setSkd_dir_cd(String skd_dir_cd) {
		this.skdDirCd = skd_dir_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getSkd_voy_no() {
		return skdVoyNo;
	}

	/**
	 * 
	 * @param skd_voy_no
	 */
	public void setSkd_voy_no(String skd_voy_no) {
		this.skdVoyNo = skd_voy_no;
	}

	/**
	 * 
	 * @return
	 */
	public String getVsl_cd() {
		return vslCd;
	}

	/**
	 * 
	 * @param vsl_cd
	 */
	public void setVsl_cd(String vsl_cd) {
		this.vslCd = vsl_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getAtb_dt() {
		return atbDt;
	}
	
	/**
	 * 
	 * @param atb_dt
	 */
	public void setAtb_dt(String atb_dt) {
		this.atbDt = atb_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAwk_cgo_flg() {
		return awkCgoFlg;
	}
	
	/**
	 * 
	 * @param awk_cgo_flg
	 */
	public void setAwk_cgo_flg(String awk_cgo_flg) {
		this.awkCgoFlg = awk_cgo_flg;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBb_cgo_flg() {
		return bbCgoFlg;
	}
	
	/**
	 * 
	 * @param bb_cgo_flg
	 */
	public void setBb_cgo_flg(String bb_cgo_flg) {
		this.bbCgoFlg = bb_cgo_flg;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getClm_dt() {
		return clmDt;
	}
	
	/**
	 * 
	 * @param clm_dt
	 */
	public void setClm_dt(String clm_dt) {
		this.clmDt = clm_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCntr_no() {
		return cntrNo;
	}
	
	/**
	 * 
	 * @param cntr_no
	 */
	public void setCntr_no(String cntr_no) {
		this.cntrNo = cntr_no;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCntr_rmk() {
		return cntrRmk;
	}
	
	/**
	 * 
	 * @param cntr_rmk
	 */
	public void setCntr_rmk(String cntr_rmk) {
		this.cntrRmk = cntr_rmk;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCntr_sty_cd() {
		return cntrStyCd;
	}
	
	/**
	 * 
	 * @param cntr_sty_cd
	 */
	public void setCntr_sty_cd(String cntr_sty_cd) {
		this.cntrStyCd = cntr_sty_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCntr_tpsz_cd() {
		return cntrTpszCd;
	}
	
	/**
	 * 
	 * @param cntr_tpsz_cd
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntrTpszCd = cntr_tpsz_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCre_dt() {
		return creDt;
	}
	
	/**
	 * 
	 * @param cre_dt
	 */
	public void setCre_dt(String cre_dt) {
		this.creDt = cre_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCre_usr_id() {
		return creUsrId;
	}
	
	/**
	 * 
	 * @param cre_usr_id
	 */
	public void setCre_usr_id(String cre_usr_id) {
		this.creUsrId = cre_usr_id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDcgo_clss_cd() {
		return dcgoClssCd;
	}
	
	/**
	 * 
	 * @param dcgo_clss_cd
	 */
	public void setDcgo_clss_cd(String dcgo_clss_cd) {
		this.dcgoClssCd = dcgo_clss_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDscr_ind_cd() {
		return dscrIndCd;
	}
	
	/**
	 * 
	 * @param dscr_ind_cd
	 */
	public void setDscr_ind_cd(String dscr_ind_cd) {
		this.dscrIndCd = dscr_ind_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDscr_rsn() {
		return dscrRsn;
	}
	
	/**
	 * 
	 * @param dscr_rsn
	 */
	public void setDscr_rsn(String dscr_rsn) {
		this.dscrRsn = dscr_rsn;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGate_in_td_dys() {
		return gateInTdDys;
	}
	
	/**
	 * 
	 * @param gate_in_td_dys
	 */
	public void setGate_in_td_dys(String gate_in_td_dys) {
		this.gateInTdDys = gate_in_td_dys;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGate_out_td_dys() {
		return gateOutTdDys;
	}
	
	/**
	 * 
	 * @param gate_out_td_dys
	 */
	public void setGate_out_td_dys(String gate_out_td_dys) {
		this.gateOutTdDys = gate_out_td_dys;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHndl_rslt_rmk() {
		return hndlRsltRmk;
	}
	
	/**
	 * 
	 * @param hndl_rslt_rmk
	 */
	public void setHndl_rslt_rmk(String hndl_rslt_rmk) {
		this.hndlRsltRmk = hndl_rslt_rmk;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInv_gate_in_dt() {
		return invGateInDt;
	}
	
	/**
	 * 
	 * @param inv_gate_in_dt
	 */
	public void setInv_gate_in_dt(String inv_gate_in_dt) {
		this.invGateInDt = inv_gate_in_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInv_gate_out_dt() {
		return invGateOutDt;
	}
	
	/**
	 * 
	 * @param inv_gate_out_dt
	 */
	public void setInv_gate_out_dt(String inv_gate_out_dt) {
		this.invGateOutDt = inv_gate_out_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInv_stay_dys() {
		return invStayDys;
	}
	
	/**
	 * 
	 * @param inv_stay_dys
	 */
	public void setInv_stay_dys(String inv_stay_dys) {
		this.invStayDys = inv_stay_dys;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIo_bnd_cd() {
		return ioBndCd;
	}
	
	/**
	 * 
	 * @param io_bnd_cd
	 */
	public void setIo_bnd_cd(String io_bnd_cd) {
		this.ioBndCd = io_bnd_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIoc_cd() {
		return iocCd;
	}
	
	/**
	 * 
	 * @param ioc_cd
	 */
	public void setIoc_cd(String ioc_cd) {
		this.iocCd = ioc_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLane_cd() {
		return laneCd;
	}
	
	/**
	 * 
	 * @param lane_cd
	 */
	public void setLane_cd(String lane_cd) {
		this.laneCd = lane_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLocl_ts_ind_cd() {
		return loclTsIndCd;
	}
	
	/**
	 * 
	 * @param locl_ts_ind_cd
	 */
	public void setLocl_ts_ind_cd(String locl_ts_ind_cd) {
		this.loclTsIndCd = locl_ts_ind_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getModi_flg() {
		return modiFlg;
	}
	
	/**
	 * 
	 * @param modi_flg
	 */
	public void setModi_flg(String modi_flg) {
		this.modiFlg = modi_flg;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMvmt_gate_in_dt() {
		return mvmtGateInDt;
	}
	
	/**
	 * 
	 * @param mvmt_gate_in_dt
	 */
	public void setMvmt_gate_in_dt(String mvmt_gate_in_dt) {
		this.mvmtGateInDt = mvmt_gate_in_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMvmt_gate_out_dt() {
		return mvmtGateOutDt;
	}
	
	/**
	 * 
	 * @param mvmt_gate_out_dt
	 */
	public void setMvmt_gate_out_dt(String mvmt_gate_out_dt) {
		this.mvmtGateOutDt = mvmt_gate_out_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMvmt_stay_dys() {
		return mvmtStayDys;
	}
	
	/**
	 * 
	 * @param mvmt_stay_dys
	 */
	public void setMvmt_stay_dys(String mvmt_stay_dys) {
		this.mvmtStayDys = mvmt_stay_dys;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPre_yd_cd() {
		return preYdCd;
	}
	
	/**
	 * 
	 * @param pre_yd_cd
	 */
	public void setPre_yd_cd(String pre_yd_cd) {
		this.preYdCd = pre_yd_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRail_bil_dt() {
		return railBilDt;
	}
	
	/**
	 * 
	 * @param rail_bil_dt
	 */
	public void setRail_bil_dt(String rail_bil_dt) {
		this.railBilDt = rail_bil_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRc_flg() {
		return rcFlg;
	}
	
	/**
	 * 
	 * @param rc_flg
	 */
	public void setRc_flg(String rc_flg) {
		this.rcFlg = rc_flg;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRcvde_term_ind_cd() {
		return rcvdeTermIndCd;
	}
	
	/**
	 * 
	 * @param rcvde_term_ind_cd
	 */
	public void setRcvde_term_ind_cd(String rcvde_term_ind_cd) {
		this.rcvdeTermIndCd = rcvde_term_ind_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSam_locl_ts_ind_cd() {
		return samLoclTsIndCd;
	}
	
	/**
	 * 
	 * @param sam_locl_ts_ind_cd
	 */
	public void setSam_locl_ts_ind_cd(String sam_locl_ts_ind_cd) {
		this.samLoclTsIndCd = sam_locl_ts_ind_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStay_diff_dys() {
		return stayDiffDys;
	}
	
	/**
	 * 
	 * @param stay_diff_dys
	 */
	public void setStay_diff_dys(String stay_diff_dys) {
		this.stayDiffDys = stay_diff_dys;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTml_rvis_ind_flg() {
		return tmlRvisIndFlg;
	}
	
	/**
	 * 
	 * @param tml_rvis_ind_flg
	 */
	public void setTml_rvis_ind_flg(String tml_rvis_ind_flg) {
		this.tmlRvisIndFlg = tml_rvis_ind_flg;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTml_so_cntr_list_seq() {
		return tmlSoCntrListSeq;
	}
	
	/**
	 * 
	 * @param tml_so_cntr_list_seq
	 */
	public void setTml_so_cntr_list_seq(String tml_so_cntr_list_seq) {
		this.tmlSoCntrListSeq = tml_so_cntr_list_seq;
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
	
	/**
	 * 
	 * @return
	 */
	public String getUpd_dt() {
		return updDt;
	}
	
	/**
	 * 
	 * @param upd_dt
	 */
	public void setUpd_dt(String upd_dt) {
		this.updDt = upd_dt;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUpd_usr_id() {
		return updUsrId;
	}
	
	/**
	 * 
	 * @param upd_usr_id
	 */
	public void setUpd_usr_id(String upd_usr_id) {
		this.updUsrId = upd_usr_id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getVrfy_rslt_ind_cd() {
		return vrfyRsltIndCd;
	}
	
	/**
	 * 
	 * @param vrfy_rslt_ind_cd
	 */
	public void setVrfy_rslt_ind_cd(String vrfy_rslt_ind_cd) {
		this.vrfyRsltIndCd = vrfy_rslt_ind_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getWrk_dt() {
		return wrkDt;
	}
	
	/**
	 * 
	 * @param wrk_dt
	 */
	public void setWrk_dt(String wrk_dt) {
		this.wrkDt = wrk_dt;
	}
}
