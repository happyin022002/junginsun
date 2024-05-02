/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_980Event.java
*@FileTitle : More CNT Candidates
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-19
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-11-19 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_921 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_921HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0980Event extends EventSupport {
    String sc_no  = "";
    String rfa_no = "";
    String vndr_seq = "";
    String trsp_bnd_cd = "";
    String fm_nod_cd   = "";
    String fm_nod_yard = "";
    String via_nod_cd   = "";
    String via_nod_yard = "";
    String to_nod_cd   = "";
    String to_nod_yard = "";
    String dor_nod_cd  = "";
    String dor_nod_yard = "";
    String ctrl_ofc_cd  = "";
    String chk_row = "";
    String cgo_tp_cd = "";
    String eq_knd_cd = "";
    String eq_tpsz_cd = "";
    String trsp_crr_mod_cd = "";
    String trsp_cost_dtl_mod_cd = "";
    String cust_nomi_trkr_flg = "";
    String cust_cnt_cd = "";
    String cust_seq = "";
    String cust_cnt_cd_seq = "";
    String cmdt_cd = "";
    String wgt_meas_ut_cd = "";
    String cntr_wgt = "";
    String scrn_id = "";
    String scrn_mode = "";
    String wtr_rcv_term_cd = "";
    String wtr_de_term_cd = "";
    String spcl_cgo_cntr_tp_cd = "";
    String bundling_no = "";
    String trsp_agmt_wy_tp_cd = "";
    
    
        
	public String getTrsp_agmt_wy_tp_cd() {
		return trsp_agmt_wy_tp_cd;
	}

	public void setTrsp_agmt_wy_tp_cd(String trsp_agmt_wy_tp_cd) {
		this.trsp_agmt_wy_tp_cd = trsp_agmt_wy_tp_cd;
	}

	public String getBundling_no() {
		return bundling_no;
	}

	public void setBundling_no(String bundling_no) {
		this.bundling_no = bundling_no;
	}

	public String getCust_cnt_cd_seq() {
		return cust_cnt_cd_seq;
	}

	public void setCust_cnt_cd_seq(String cust_cnt_cd_seq) {
		this.cust_cnt_cd_seq = cust_cnt_cd_seq;
	}

	public String getSpcl_cgo_cntr_tp_cd() {
		return spcl_cgo_cntr_tp_cd;
	}

	public void setSpcl_cgo_cntr_tp_cd(String spcl_cgo_cntr_tp_cd) {
		this.spcl_cgo_cntr_tp_cd = spcl_cgo_cntr_tp_cd;
	}

	public String getWtr_rcv_term_cd() {
		return wtr_rcv_term_cd;
	}

	public void setWtr_rcv_term_cd(String wtr_rcv_term_cd) {
		this.wtr_rcv_term_cd = wtr_rcv_term_cd;
	}

	public String getWtr_de_term_cd() {
		return wtr_de_term_cd;
	}

	public void setWtr_de_term_cd(String wtr_de_term_cd) {
		this.wtr_de_term_cd = wtr_de_term_cd;
	}

	public String getVia_nod_cd() {
		return via_nod_cd;
	}

	public void setVia_nod_cd(String via_nod_cd) {
		this.via_nod_cd = via_nod_cd;
	}

	public String getVia_nod_yard() {
		return via_nod_yard;
	}

	public void setVia_nod_yard(String via_nod_yard) {
		this.via_nod_yard = via_nod_yard;
	}

	public String getCgo_tp_cd() {
		return cgo_tp_cd;
	}

	public void setCgo_tp_cd(String cgo_tp_cd) {
		this.cgo_tp_cd = cgo_tp_cd;
	}

	public String getEq_knd_cd() {
		return eq_knd_cd;
	}

	public void setEq_knd_cd(String eq_knd_cd) {
		this.eq_knd_cd = eq_knd_cd;
	}

	public String getEq_tpsz_cd() {
		return eq_tpsz_cd;
	}

	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eq_tpsz_cd = eq_tpsz_cd;
	}

	public String getScrn_id() {
		return scrn_id;
	}

	public void setScrn_id(String scrn_id) {
		this.scrn_id = scrn_id;
	}

	public String getScrn_mode() {
		return scrn_mode;
	}

	public void setScrn_mode(String scrn_mode) {
		this.scrn_mode = scrn_mode;
	}

	public String getTrsp_crr_mod_cd() {
		return trsp_crr_mod_cd;
	}

	public void setTrsp_crr_mod_cd(String trsp_crr_mod_cd) {
		this.trsp_crr_mod_cd = trsp_crr_mod_cd;
	}

	public String getTrsp_cost_dtl_mod_cd() {
		return trsp_cost_dtl_mod_cd;
	}

	public void setTrsp_cost_dtl_mod_cd(String trsp_cost_dtl_mod_cd) {
		this.trsp_cost_dtl_mod_cd = trsp_cost_dtl_mod_cd;
	}

	public String getCust_nomi_trkr_flg() {
		return cust_nomi_trkr_flg;
	}

	public void setCust_nomi_trkr_flg(String cust_nomi_trkr_flg) {
		this.cust_nomi_trkr_flg = cust_nomi_trkr_flg;
	}

	public String getCust_cnt_cd() {
		return cust_cnt_cd;
	}

	public void setCust_cnt_cd(String cust_cnt_cd) {
		this.cust_cnt_cd = cust_cnt_cd;
	}

	public String getCust_seq() {
		return cust_seq;
	}

	public void setCust_seq(String cust_seq) {
		this.cust_seq = cust_seq;
	}

	public String getCmdt_cd() {
		return cmdt_cd;
	}

	public void setCmdt_cd(String cmdt_cd) {
		this.cmdt_cd = cmdt_cd;
	}

	public String getWgt_meas_ut_cd() {
		return wgt_meas_ut_cd;
	}

	public void setWgt_meas_ut_cd(String wgt_meas_ut_cd) {
		this.wgt_meas_ut_cd = wgt_meas_ut_cd;
	}

	public String getCntr_wgt() {
		return cntr_wgt;
	}

	public void setCntr_wgt(String cntr_wgt) {
		this.cntr_wgt = cntr_wgt;
	}

	public String getSc_no() {
		return sc_no;
	}

	public void setSc_no(String sc_no) {
		this.sc_no = sc_no;
	}

	public String getRfa_no() {
		return rfa_no;
	}

	public void setRfa_no(String rfa_no) {
		this.rfa_no = rfa_no;
	}

	public String getVndr_seq() {
		return vndr_seq;
	}

	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}

	public String getTrsp_bnd_cd() {
		return trsp_bnd_cd;
	}

	public void setTrsp_bnd_cd(String trsp_bnd_cd) {
		this.trsp_bnd_cd = trsp_bnd_cd;
	}

	public String getFm_nod_cd() {
		return fm_nod_cd;
	}

	public void setFm_nod_cd(String fm_nod_cd) {
		this.fm_nod_cd = fm_nod_cd;
	}

	public String getFm_nod_yard() {
		return fm_nod_yard;
	}

	public void setFm_nod_yard(String fm_nod_yard) {
		this.fm_nod_yard = fm_nod_yard;
	}

	public String getTo_nod_cd() {
		return to_nod_cd;
	}

	public void setTo_nod_cd(String to_nod_cd) {
		this.to_nod_cd = to_nod_cd;
	}

	public String getTo_nod_yard() {
		return to_nod_yard;
	}

	public void setTo_nod_yard(String to_nod_yard) {
		this.to_nod_yard = to_nod_yard;
	}

	public String getDor_nod_cd() {
		return dor_nod_cd;
	}

	public void setDor_nod_cd(String dor_nod_cd) {
		this.dor_nod_cd = dor_nod_cd;
	}

	public String getDor_nod_yard() {
		return dor_nod_yard;
	}

	public void setDor_nod_yard(String dor_nod_yard) {
		this.dor_nod_yard = dor_nod_yard;
	}

	public String getCtrl_ofc_cd() {
		return ctrl_ofc_cd;
	}

	public void setCtrl_ofc_cd(String ctrl_ofc_cd) {
		this.ctrl_ofc_cd = ctrl_ofc_cd;
	}

	public String getChk_row() {
		return chk_row;
	}

	public void setChk_row(String chk_row) {
		this.chk_row = chk_row;
	}
	
	public EsdTrs0980Event(){}
	
	public String getEventName() {
		return "EsdTrs0980Event";
	}

	public String toString() {
		return "EsdTrs0980Event";
	}

}
