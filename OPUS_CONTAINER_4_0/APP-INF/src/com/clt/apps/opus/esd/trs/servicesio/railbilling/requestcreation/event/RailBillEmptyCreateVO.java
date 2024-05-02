/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillEmptyCreateVO.java
*@FileTitle : RailBillEmptyCreateVO Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.RailBillingIWSProxy;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillEmptyCreateVO implements java.io.Serializable {
	/** (Param 객체) */
	private String key_value = null;
	private String trsp_so_ofc_cty_cd = null;
	private String trsp_so_seq = null;
	private String rail_cmb_thru_tp_cd = null;
	private String trsp_so_sts_cd = null;
	private String trsp_rail_bil_tp_cd = null;
	private String fm_nod_cd = null;
	private String to_nod_cd = null;
	private String vsl_cd = null;
	private String skd_voy_no = null;
	private String skd_dir_cd = null;
	private String slan_cd = null;
	private String eq_no = null;
	private String eq_tpsz_cd = null;
	private String cgo_tp_cd = null;
	private String rout_org_nod_cd = null;
	private String rout_dest_nod_cd = null;
	private String rout_seq = null;
	private String rout_pln_cd = null;
	private String inlnd_rout_rmk = null;
	private String cre_ofc_cd = null;
	private String cre_usr_id = null;
	private String upd_usr_id = null;
	private String inter_rmk = null;
	private String spcl_instr_rmk = null;
	private String trsp_mty_cost_mod_cd = null;
	private String repo_pln_id = null;
	private String pln_yrwk = null;
	private String ref_seq = null;
	private String ref_id = null;
	private String trsp_mty_rqst_dt = null;
	private String eq_ctrl_ofc_cd = null;
	private String shpr_cust_nm = null;
	private String shpr_fax_no = null;
	private String mtc_edi_ind_cd = null;
	
	/**
	 * @return Returns the key_value.
	 */
	public String getKey_value() {
		return key_value;
	}
	/**
	 * @param key_value The key_value to set.
	 */
	public void setKey_value(String key_value) {
		this.key_value = key_value;
	}
	/**
	 * @return Returns the cgo_tp_cd.
	 */
	public String getCgo_tp_cd() {
		return cgo_tp_cd;
	}
	/**
	 * @param cgo_tp_cd The cgo_tp_cd to set.
	 */
	public void setCgo_tp_cd(String cgo_tp_cd) {
		this.cgo_tp_cd = cgo_tp_cd;
	}
	/**
	 * @return Returns the cre_ofc_cd.
	 */
	public String getCre_ofc_cd() {
		return cre_ofc_cd;
	}
	/**
	 * @param cre_ofc_cd The cre_ofc_cd to set.
	 */
	public void setCre_ofc_cd(String cre_ofc_cd) {
		this.cre_ofc_cd = cre_ofc_cd;
	}
	/**
	 * @return Returns the cre_usr_id.
	 */
	public String getCre_usr_id() {
		return cre_usr_id;
	}
	/**
	 * @param cre_usr_id The cre_usr_id to set.
	 */
	public void setCre_usr_id(String cre_usr_id) {
		this.cre_usr_id = cre_usr_id;
	}
	/**
	 * @return Returns the eq_no.
	 */
	public String getEq_no() {
		return eq_no;
	}
	/**
	 * @param eq_no The eq_no to set.
	 */
	public void setEq_no(String eq_no) {
		this.eq_no = eq_no;
	}
	/**
	 * @return Returns the eq_tpsz_cd.
	 */
	public String getEq_tpsz_cd() {
		return eq_tpsz_cd;
	}
	/**
	 * @param eq_tpsz_cd The eq_tpsz_cd to set.
	 */
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eq_tpsz_cd = eq_tpsz_cd;
	}
	/**
	 * @return Returns the fm_nod_cd.
	 */
	public String getFm_nod_cd() {
		return fm_nod_cd;
	}
	/**
	 * @param fm_nod_cd The fm_nod_cd to set.
	 */
	public void setFm_nod_cd(String fm_nod_cd) {
		this.fm_nod_cd = fm_nod_cd;
	}
	/**
	 * @return Returns the inlnd_rout_rmk.
	 */
	public String getInlnd_rout_rmk() {
		return inlnd_rout_rmk;
	}
	/**
	 * @param inlnd_rout_rmk The inlnd_rout_rmk to set.
	 */
	public void setInlnd_rout_rmk(String inlnd_rout_rmk) {
		this.inlnd_rout_rmk = inlnd_rout_rmk;
	}
	/**
	 * @return Returns the inter_rmk.
	 */
	public String getInter_rmk() {
		return inter_rmk;
	}
	/**
	 * @param inter_rmk The inter_rmk to set.
	 */
	public void setInter_rmk(String inter_rmk) {
		this.inter_rmk = inter_rmk;
	}
	/**
	 * @return Returns the pln_yrwk.
	 */
	public String getPln_yrwk() {
		return pln_yrwk;
	}
	/**
	 * @param pln_yrwk The pln_yrwk to set.
	 */
	public void setPln_yrwk(String pln_yrwk) {
		this.pln_yrwk = pln_yrwk;
	}
	/**
	 * @return Returns the rail_cmb_thru_tp_cd.
	 */
	public String getRail_cmb_thru_tp_cd() {
		return rail_cmb_thru_tp_cd;
	}
	/**
	 * @param rail_cmb_thru_tp_cd The rail_cmb_thru_tp_cd to set.
	 */
	public void setRail_cmb_thru_tp_cd(String rail_cmb_thru_tp_cd) {
		this.rail_cmb_thru_tp_cd = rail_cmb_thru_tp_cd;
	}
	/**
	 * @return Returns the ref_id.
	 */
	public String getRef_id() {
		return ref_id;
	}
	/**
	 * @param ref_id The ref_id to set.
	 */
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}
	/**
	 * @return Returns the ref_seq.
	 */
	public String getRef_seq() {
		return ref_seq;
	}
	/**
	 * @param ref_seq The ref_seq to set.
	 */
	public void setRef_seq(String ref_seq) {
		this.ref_seq = ref_seq;
	}
	/**
	 * @return Returns the repo_pln_id.
	 */
	public String getRepo_pln_id() {
		return repo_pln_id;
	}
	/**
	 * @param repo_pln_id The repo_pln_id to set.
	 */
	public void setRepo_pln_id(String repo_pln_id) {
		this.repo_pln_id = repo_pln_id;
	}
	/**
	 * @return Returns the rout_dest_nod_cd.
	 */
	public String getRout_dest_nod_cd() {
		return rout_dest_nod_cd;
	}
	/**
	 * @param rout_dest_nod_cd The rout_dest_nod_cd to set.
	 */
	public void setRout_dest_nod_cd(String rout_dest_nod_cd) {
		this.rout_dest_nod_cd = rout_dest_nod_cd;
	}
	/**
	 * @return Returns the rout_org_nod_cd.
	 */
	public String getRout_org_nod_cd() {
		return rout_org_nod_cd;
	}
	/**
	 * @param rout_org_nod_cd The rout_org_nod_cd to set.
	 */
	public void setRout_org_nod_cd(String rout_org_nod_cd) {
		this.rout_org_nod_cd = rout_org_nod_cd;
	}
	/**
	 * @return Returns the rout_pln_cd.
	 */
	public String getRout_pln_cd() {
		return rout_pln_cd;
	}
	/**
	 * @param rout_pln_cd The rout_pln_cd to set.
	 */
	public void setRout_pln_cd(String rout_pln_cd) {
		this.rout_pln_cd = rout_pln_cd;
	}
	/**
	 * @return Returns the rout_seq.
	 */
	public String getRout_seq() {
		return rout_seq;
	}
	/**
	 * @param rout_seq The rout_seq to set.
	 */
	public void setRout_seq(String rout_seq) {
		this.rout_seq = rout_seq;
	}
	/**
	 * @return Returns the skd_dir_cd.
	 */
	public String getSkd_dir_cd() {
		return skd_dir_cd;
	}
	/**
	 * @param skd_dir_cd The skd_dir_cd to set.
	 */
	public void setSkd_dir_cd(String skd_dir_cd) {
		this.skd_dir_cd = skd_dir_cd;
	}
	/**
	 * @return Returns the skd_voy_no.
	 */
	public String getSkd_voy_no() {
		return skd_voy_no;
	}
	/**
	 * @param skd_voy_no The skd_voy_no to set.
	 */
	public void setSkd_voy_no(String skd_voy_no) {
		this.skd_voy_no = skd_voy_no;
	}
	/**
	 * @return Returns the slan_cd.
	 */
	public String getSlan_cd() {
		return slan_cd;
	}
	/**
	 * @param slan_cd The slan_cd to set.
	 */
	public void setSlan_cd(String slan_cd) {
		this.slan_cd = slan_cd;
	}
	/**
	 * @return Returns the spcl_instr_rmk.
	 */
	public String getSpcl_instr_rmk() {
		return spcl_instr_rmk;
	}
	/**
	 * @param spcl_instr_rmk The spcl_instr_rmk to set.
	 */
	public void setSpcl_instr_rmk(String spcl_instr_rmk) {
		this.spcl_instr_rmk = spcl_instr_rmk;
	}
	/**
	 * @return Returns the to_nod_cd.
	 */
	public String getTo_nod_cd() {
		return to_nod_cd;
	}
	/**
	 * @param to_nod_cd The to_nod_cd to set.
	 */
	public void setTo_nod_cd(String to_nod_cd) {
		this.to_nod_cd = to_nod_cd;
	}
	/**
	 * @return Returns the trsp_mty_cost_mod_cd.
	 */
	public String getTrsp_mty_cost_mod_cd() {
		return trsp_mty_cost_mod_cd;
	}
	/**
	 * @param trsp_mty_cost_mod_cd The trsp_mty_cost_mod_cd to set.
	 */
	public void setTrsp_mty_cost_mod_cd(String trsp_mty_cost_mod_cd) {
		this.trsp_mty_cost_mod_cd = trsp_mty_cost_mod_cd;
	}
	/**
	 * @return Returns the trsp_mty_rqst_dt.
	 */
	public String getTrsp_mty_rqst_dt() {
		return trsp_mty_rqst_dt;
	}
	/**
	 * @param trsp_mty_rqst_dt The trsp_mty_rqst_dt to set.
	 */
	public void setTrsp_mty_rqst_dt(String trsp_mty_rqst_dt) {
		this.trsp_mty_rqst_dt = trsp_mty_rqst_dt;
	}
	/**
	 * @return Returns the trsp_rail_bil_tp_cd.
	 */
	public String getTrsp_rail_bil_tp_cd() {
		return trsp_rail_bil_tp_cd;
	}
	/**
	 * @param trsp_rail_bil_tp_cd The trsp_rail_bil_tp_cd to set.
	 */
	public void setTrsp_rail_bil_tp_cd(String trsp_rail_bil_tp_cd) {
		this.trsp_rail_bil_tp_cd = trsp_rail_bil_tp_cd;
	}
	/**
	 * @return Returns the trsp_so_ofc_cty_cd.
	 */
	public String getTrsp_so_ofc_cty_cd() {
		return trsp_so_ofc_cty_cd;
	}
	/**
	 * @param trsp_so_ofc_cty_cd The trsp_so_ofc_cty_cd to set.
	 */
	public void setTrsp_so_ofc_cty_cd(String trsp_so_ofc_cty_cd) {
		this.trsp_so_ofc_cty_cd = trsp_so_ofc_cty_cd;
	}
	/**
	 * @return Returns the trsp_so_seq.
	 */
	public String getTrsp_so_seq() {
		return trsp_so_seq;
	}
	/**
	 * @param trsp_so_seq The trsp_so_seq to set.
	 */
	public void setTrsp_so_seq(String trsp_so_seq) {
		this.trsp_so_seq = trsp_so_seq;
	}
	/**
	 * @return Returns the trsp_so_sts_cd.
	 */
	public String getTrsp_so_sts_cd() {
		return trsp_so_sts_cd;
	}
	/**
	 * @param trsp_so_sts_cd The trsp_so_sts_cd to set.
	 */
	public void setTrsp_so_sts_cd(String trsp_so_sts_cd) {
		this.trsp_so_sts_cd = trsp_so_sts_cd;
	}
	/**
	 * @return Returns the upd_usr_id.
	 */
	public String getUpd_usr_id() {
		return upd_usr_id;
	}
	/**
	 * @param upd_usr_id The upd_usr_id to set.
	 */
	public void setUpd_usr_id(String upd_usr_id) {
		this.upd_usr_id = upd_usr_id;
	}
	/**
	 * @return Returns the vsl_cd.
	 */
	public String getVsl_cd() {
		return vsl_cd;
	}
	/**
	 * @param vsl_cd The vsl_cd to set.
	 */
	public void setVsl_cd(String vsl_cd) {
		this.vsl_cd = vsl_cd;
	}
	/**
	 * @return Returns the shpr_cust_nm.
	 */
	public String getShpr_cust_nm() {
		return shpr_cust_nm;
	}
	/**
	 * @param shpr_cust_nm The shpr_cust_nm to set.
	 */
	public void setShpr_cust_nm(String shpr_cust_nm) {
		this.shpr_cust_nm = shpr_cust_nm;
	}
	/**
	 * @return Returns the shpr_fax_no.
	 */
	public String getShpr_fax_no() {
		return shpr_fax_no;
	}
	/**
	 * @param shpr_fax_no The shpr_fax_no to set.
	 */
	public void setShpr_fax_no(String shpr_fax_no) {
		this.shpr_fax_no = shpr_fax_no;
	}
	/**
	 * @return Returns the mtc_edi_ind_cd.
	 */
	public String getMtc_edi_ind_cd() {
		return mtc_edi_ind_cd;
	}
	/**
	 * @param mtc_edi_ind_cd The mtc_edi_ind_cd to set.
	 */
	public void setMtc_edi_ind_cd(String mtc_edi_ind_cd) {
		this.mtc_edi_ind_cd = mtc_edi_ind_cd;
	}
	/**
	 * @return Returns the eq_ctrl_ofc_cd.
	 */
	public String getEq_ctrl_ofc_cd() {
		return eq_ctrl_ofc_cd;
	}
	/**
	 * @param eq_ctrl_ofc_cd The eq_ctrl_ofc_cd to set.
	 */
	public void setEq_ctrl_ofc_cd(String eq_ctrl_ofc_cd) {
		this.eq_ctrl_ofc_cd = eq_ctrl_ofc_cd;
	}
	
	
	
}
