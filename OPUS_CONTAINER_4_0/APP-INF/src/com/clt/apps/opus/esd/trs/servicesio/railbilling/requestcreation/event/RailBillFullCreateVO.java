/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillFullCreateVO.java
*@FileTitle : RailBillFullCreateVO Info
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
public class RailBillFullCreateVO implements java.io.Serializable {
	/** (Param 객체) */
	private String trsp_so_ofc_cty_cd = null;
	private String trsp_so_seq = null;
	private String rail_cmb_thru_tp_cd = null;
	private String trsp_so_sts_cd = null;
	private String trsp_rail_bil_tp_cd = null;
	private String ibd_ipi_locl_ind_cd = null;
	private String fm_full_nod_cd = null;
	private String to_full_nod_cd = null;
	private String fm_nod_cd = null;
	private String to_nod_cd = null;
	private String vsl_cd = null;
	private String skd_voy_no = null;
	private String skd_dir_cd = null;
	private String slan_cd = null;
	private String trsp_bnd_cd = null;
	private String bkg_no = null;
	private String bkg_no_split = null;
	private String bl_no = null;
	private String bl_no_tp = null;
	private String bl_no_chk = null;
	private String wgt_meas_ut_cd = null;
	private String cgo_tp_cd = null;
	private String pck_tp_cd = null;
	private String cmdt_cd = null;
	private String stnd_cmdt_no = null;
	private String cop_no = null;
	private String cost_act_grp_seq = null;
	private String spcl_cgo_cntr_tp_cd = null;
	private String ibd_cstms_clr_loc_cd = null;
	private String pod_cd = null;
	private String por_cd = null;
	private String pol_cd = null;
	private String del_cd = null;
	private String por_nod_cd = null;
	private String del_nod_cd = null;
	private String del_scc_cd = null;
	private String nvocc_file_no = null;
	private String cntr_seal_no = null;
	private String act_grp_cd = null;
	private String n1st_nod_pln_dt = null;
	private String lst_nod_pln_dt = null;
	private String bkg_cgo_tp_cd = null;
	private String rout_org_nod_cd = null;
	private String rout_dest_nod_cd = null;
	private String rout_seq = null;
	private String ctrl_ofc_cd = null;
	private String rout_pln_cd = null;
	private String inlnd_rout_rmk = null;
	private String cre_ofc_cd = null;
	private String cre_usr_id = null;
	private String upd_usr_id = null;
	private String shpr_cust_nm = null;
	private String cust_cnt_cd = null;
	private String cust_seq = null;
	private String mtc_edi_ind_cd = null;
	private String bkg_rcvde_term_cd = null;
	private String pol_nod_cd = null;
	private String pod_nod_cd = null;
	private String sc_no = null;
	
	
	/**
	 * @return Returns the act_grp_cd.
	 */
	public String getAct_grp_cd() {
		return act_grp_cd;
	}
	/**
	 * @param act_grp_cd The act_grp_cd to set.
	 */
	public void setAct_grp_cd(String act_grp_cd) {
		this.act_grp_cd = act_grp_cd;
	}
	/**
	 * @return Returns the bkg_cgo_tp_cd.
	 */
	public String getBkg_cgo_tp_cd() {
		return bkg_cgo_tp_cd;
	}
	/**
	 * @param bkg_cgo_tp_cd The bkg_cgo_tp_cd to set.
	 */
	public void setBkg_cgo_tp_cd(String bkg_cgo_tp_cd) {
		this.bkg_cgo_tp_cd = bkg_cgo_tp_cd;
	}
	/**
	 * @return Returns the bkg_no.
	 */
	public String getBkg_no() {
		return bkg_no;
	}
	/**
	 * @param bkg_no The bkg_no to set.
	 */
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	/**
	 * @return Returns the bkg_no_split.
	 */
	public String getBkg_no_split() {
		return bkg_no_split;
	}
	/**
	 * @param bkg_no_split The bkg_no_split to set.
	 */
	public void setBkg_no_split(String bkg_no_split) {
		this.bkg_no_split = bkg_no_split;
	}
	/**
	 * @return Returns the bl_no.
	 */
	public String getBl_no() {
		return bl_no;
	}
	/**
	 * @param bl_no The bl_no to set.
	 */
	public void setBl_no(String bl_no) {
		this.bl_no = bl_no;
	}
	/**
	 * @return Returns the bl_no_chk.
	 */
	public String getBl_no_chk() {
		return bl_no_chk;
	}
	/**
	 * @param bl_no_chk The bl_no_chk to set.
	 */
	public void setBl_no_chk(String bl_no_chk) {
		this.bl_no_chk = bl_no_chk;
	}
	/**
	 * @return Returns the bl_no_tp.
	 */
	public String getBl_no_tp() {
		return bl_no_tp;
	}
	/**
	 * @param bl_no_tp The bl_no_tp to set.
	 */
	public void setBl_no_tp(String bl_no_tp) {
		this.bl_no_tp = bl_no_tp;
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
	 * @return Returns the cmdt_cd.
	 */
	public String getCmdt_cd() {
		return cmdt_cd;
	}
	/**
	 * @param cmdt_cd The cmdt_cd to set.
	 */
	public void setCmdt_cd(String cmdt_cd) {
		this.cmdt_cd = cmdt_cd;
	}
	/**
	 * @return Returns the cntr_seal_no.
	 */
	public String getCntr_seal_no() {
		return cntr_seal_no;
	}
	/**
	 * @param cntr_seal_no The cntr_seal_no to set.
	 */
	public void setCntr_seal_no(String cntr_seal_no) {
		this.cntr_seal_no = cntr_seal_no;
	}
	/**
	 * @return Returns the cop_no.
	 */
	public String getCop_no() {
		return cop_no;
	}
	/**
	 * @param cop_no The cop_no to set.
	 */
	public void setCop_no(String cop_no) {
		this.cop_no = cop_no;
	}
	/**
	 * @return Returns the cost_act_grp_seq.
	 */
	public String getCost_act_grp_seq() {
		return cost_act_grp_seq;
	}
	/**
	 * @param cost_act_grp_seq The cost_act_grp_seq to set.
	 */
	public void setCost_act_grp_seq(String cost_act_grp_seq) {
		this.cost_act_grp_seq = cost_act_grp_seq;
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
	 * @return Returns the del_cd.
	 */
	public String getDel_cd() {
		return del_cd;
	}
	/**
	 * @param del_cd The del_cd to set.
	 */
	public void setDel_cd(String del_cd) {
		this.del_cd = del_cd;
	}
	/**
	 * @return Returns the del_scc_cd.
	 */
	public String getDel_scc_cd() {
		return del_scc_cd;
	}
	/**
	 * @param del_scc_cd The del_scc_cd to set.
	 */
	public void setDel_scc_cd(String del_scc_cd) {
		this.del_scc_cd = del_scc_cd;
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
	 * @return Returns the ibd_cstms_clr_loc_cd.
	 */
	public String getIbd_cstms_clr_loc_cd() {
		return ibd_cstms_clr_loc_cd;
	}
	/**
	 * @param ibd_cstms_clr_loc_cd The ibd_cstms_clr_loc_cd to set.
	 */
	public void setIbd_cstms_clr_loc_cd(String ibd_cstms_clr_loc_cd) {
		this.ibd_cstms_clr_loc_cd = ibd_cstms_clr_loc_cd;
	}
	/**
	 * @return Returns the ibd_ipi_locl_ind_cd.
	 */
	public String getIbd_ipi_locl_ind_cd() {
		return ibd_ipi_locl_ind_cd;
	}
	/**
	 * @param ibd_ipi_locl_ind_cd The ibd_ipi_locl_ind_cd to set.
	 */
	public void setIbd_ipi_locl_ind_cd(String ibd_ipi_locl_ind_cd) {
		this.ibd_ipi_locl_ind_cd = ibd_ipi_locl_ind_cd;
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
	 * @return Returns the lst_nod_pln_dt.
	 */
	public String getLst_nod_pln_dt() {
		return lst_nod_pln_dt;
	}
	/**
	 * @param lst_nod_pln_dt The lst_nod_pln_dt to set.
	 */
	public void setLst_nod_pln_dt(String lst_nod_pln_dt) {
		this.lst_nod_pln_dt = lst_nod_pln_dt;
	}
	/**
	 * @return Returns the n1st_nod_pln_dt.
	 */
	public String getN1st_nod_pln_dt() {
		return n1st_nod_pln_dt;
	}
	/**
	 * @param n1st_nod_pln_dt The n1st_nod_pln_dt to set.
	 */
	public void setN1st_nod_pln_dt(String n1st_nod_pln_dt) {
		this.n1st_nod_pln_dt = n1st_nod_pln_dt;
	}
	/**
	 * @return Returns the nvocc_file_no.
	 */
	public String getNvocc_file_no() {
		return nvocc_file_no;
	}
	/**
	 * @param nvocc_file_no The nvocc_file_no to set.
	 */
	public void setNvocc_file_no(String nvocc_file_no) {
		this.nvocc_file_no = nvocc_file_no;
	}
	/**
	 * @return Returns the pck_tp_cd.
	 */
	public String getPck_tp_cd() {
		return pck_tp_cd;
	}
	/**
	 * @param pck_tp_cd The pck_tp_cd to set.
	 */
	public void setPck_tp_cd(String pck_tp_cd) {
		this.pck_tp_cd = pck_tp_cd;
	}
	/**
	 * @return Returns the pod_cd.
	 */
	public String getPod_cd() {
		return pod_cd;
	}
	/**
	 * @param pod_cd The pod_cd to set.
	 */
	public void setPod_cd(String pod_cd) {
		this.pod_cd = pod_cd;
	}
	/**
	 * @return Returns the pol_cd.
	 */
	public String getPol_cd() {
		return pol_cd;
	}
	/**
	 * @param pol_cd The pol_cd to set.
	 */
	public void setPol_cd(String pol_cd) {
		this.pol_cd = pol_cd;
	}
	/**
	 * @return Returns the por_cd.
	 */
	public String getPor_cd() {
		return por_cd;
	}
	/**
	 * @param por_cd The por_cd to set.
	 */
	public void setPor_cd(String por_cd) {
		this.por_cd = por_cd;
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
	 * @return Returns the spcl_cgo_cntr_tp_cd.
	 */
	public String getSpcl_cgo_cntr_tp_cd() {
		return spcl_cgo_cntr_tp_cd;
	}
	/**
	 * @param spcl_cgo_cntr_tp_cd The spcl_cgo_cntr_tp_cd to set.
	 */
	public void setSpcl_cgo_cntr_tp_cd(String spcl_cgo_cntr_tp_cd) {
		this.spcl_cgo_cntr_tp_cd = spcl_cgo_cntr_tp_cd;
	}
	/**
	 * @return Returns the stnd_cmdt_no.
	 */
	public String getStnd_cmdt_no() {
		return stnd_cmdt_no;
	}
	/**
	 * @param stnd_cmdt_no The stnd_cmdt_no to set.
	 */
	public void setStnd_cmdt_no(String stnd_cmdt_no) {
		this.stnd_cmdt_no = stnd_cmdt_no;
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
	 * @return Returns the trsp_bnd_cd.
	 */
	public String getTrsp_bnd_cd() {
		return trsp_bnd_cd;
	}
	/**
	 * @param trsp_bnd_cd The trsp_bnd_cd to set.
	 */
	public void setTrsp_bnd_cd(String trsp_bnd_cd) {
		this.trsp_bnd_cd = trsp_bnd_cd;
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
	 * @return Returns the wgt_meas_ut_cd.
	 */
	public String getWgt_meas_ut_cd() {
		return wgt_meas_ut_cd;
	}
	/**
	 * @param wgt_meas_ut_cd The wgt_meas_ut_cd to set.
	 */
	public void setWgt_meas_ut_cd(String wgt_meas_ut_cd) {
		this.wgt_meas_ut_cd = wgt_meas_ut_cd;
	}
	/**
	 * @return Returns the del_nod_cd.
	 */
	public String getDel_nod_cd() {
		return del_nod_cd;
	}
	/**
	 * @param del_nod_cd The del_nod_cd to set.
	 */
	public void setDel_nod_cd(String del_nod_cd) {
		this.del_nod_cd = del_nod_cd;
	}
	/**
	 * @return Returns the por_nod_cd.
	 */
	public String getPor_nod_cd() {
		return por_nod_cd;
	}
	/**
	 * @param por_nod_cd The por_nod_cd to set.
	 */
	public void setPor_nod_cd(String por_nod_cd) {
		this.por_nod_cd = por_nod_cd;
	}
	/**
	 * @return Returns the cust_cnt_cd.
	 */
	public String getCust_cnt_cd() {
		return cust_cnt_cd;
	}
	/**
	 * @param cust_cnt_cd The cust_cnt_cd to set.
	 */
	public void setCust_cnt_cd(String cust_cnt_cd) {
		this.cust_cnt_cd = cust_cnt_cd;
	}
	/**
	 * @return Returns the cust_seq.
	 */
	public String getCust_seq() {
		return cust_seq;
	}
	/**
	 * @param cust_seq The cust_seq to set.
	 */
	public void setCust_seq(String cust_seq) {
		this.cust_seq = cust_seq;
	}
	/**
	 * @return Returns the fm_full_nod_cd.
	 */
	public String getFm_full_nod_cd() {
		return fm_full_nod_cd;
	}
	/**
	 * @param fm_full_nod_cd The fm_full_nod_cd to set.
	 */
	public void setFm_full_nod_cd(String fm_full_nod_cd) {
		this.fm_full_nod_cd = fm_full_nod_cd;
	}
	/**
	 * @return Returns the to_full_nod_cd.
	 */
	public String getTo_full_nod_cd() {
		return to_full_nod_cd;
	}
	/**
	 * @param to_full_nod_cd The to_full_nod_cd to set.
	 */
	public void setTo_full_nod_cd(String to_full_nod_cd) {
		this.to_full_nod_cd = to_full_nod_cd;
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
	 * @return Returns the ctrl_ofc_cd.
	 */
	public String getCtrl_ofc_cd() {
		return ctrl_ofc_cd;
	}
	/**
	 * @param ctrl_ofc_cd The ctrl_ofc_cd to set.
	 */
	public void setCtrl_ofc_cd(String ctrl_ofc_cd) {
		this.ctrl_ofc_cd = ctrl_ofc_cd;
	}
	/**
	 * @return Returns the bkg_rcvde_term_cd.
	 */
	public String getBkg_rcvde_term_cd() {
		return bkg_rcvde_term_cd;
	}
	/**
	 * @param bkg_rcvde_term_cd The bkg_rcvde_term_cd to set.
	 */
	public void setBkg_rcvde_term_cd(String bkg_rcvde_term_cd) {
		this.bkg_rcvde_term_cd = bkg_rcvde_term_cd;
	}
	
	/**
	 * @return Returns the pol_nod_cd.
	 */
	public String getPol_nod_cd() {
		return pol_nod_cd;
	}
	
	/**
	 * @param pol_nod_cd The pol_nod_cd to set.
	 */
	public void setPol_nod_cd(String pol_nod_cd) {
		this.pol_nod_cd = pol_nod_cd;
	}
	/**
	 * @return Returns the pod_nod_cd.
	 */
	public String getPod_nod_cd() {
		return pod_nod_cd;
	}
	
	/**
	 * @param pod_nod_cd The pod_nod_cd to set.
	 */
	public void setPod_nod_cd(String pod_nod_cd) {
		this.pod_nod_cd = pod_nod_cd;
	}
	/**
	 * @return Returns the sc_no.
	 */
	public String getSc_no() {
		return sc_no;
	}
	
	/**
	 * @param sc_no The sc_no to set.
	 */
	public void setSc_no(String sc_no) {
		this.sc_no = sc_no;
	}
	
}
