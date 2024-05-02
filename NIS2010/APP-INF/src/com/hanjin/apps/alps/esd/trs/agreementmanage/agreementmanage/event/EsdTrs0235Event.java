/*=========================================================
 *@FileName : ESD_TRS_0233Event.java
 *@FileTitle : Agreement Header
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-05-11
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2010-05-17 pjy
 * 1.0 최초 생성
 * 
 * 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0235 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0235HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.5
 */
public class EsdTrs0235Event extends EventSupport {
	private String fmRailSvcTpCd         = null;
	private String fmAgmtTrspTpCd        = null;
	private String fmTrspAgmtOfcCtyCd   = null;
	private String fmTrspAgmtSeq          = null;
	private String fmTrspAgmtRtTpSerNo = null;
	private String fmVndrSeq               = null;
	private String fmCtrtOfcCd            = null;
	private String fmEqKndCd              = null;
	private String fmTrspAgmtEqTpSzCd  = null;
	private String fmCgoTpCd              = null;
	private String fmFmNodCd              = null;
	private String fmViaNodCd             = null;
	private String fmDorNodCd             = null;
	private String fmToNodCd              = null;
	private String fmTrspAgmtBdlQty      = null;
	private String fmWgtMeasUtCd         = null;
	private String fmBasicRt               = null;
	private String fmCurrCd                = null;
	private String fmWay                    = null;
	private String effectiveDate = null;
	
	public EsdTrs0235Event(){}

	public String getFm_rail_svc_tp_cd() {
		return fmRailSvcTpCd;
	}

	public void setFm_rail_svc_tp_cd(String fm_rail_svc_tp_cd) {
		this.fmRailSvcTpCd = fm_rail_svc_tp_cd;
	}

	public String getFm_agmt_trsp_tp_cd() {
		return fmAgmtTrspTpCd;
	}

	public void setFm_agmt_trsp_tp_cd(String fm_agmt_trsp_tp_cd) {
		this.fmAgmtTrspTpCd = fm_agmt_trsp_tp_cd;
	}

	public String getFm_trsp_agmt_ofc_cty_cd() {
		return fmTrspAgmtOfcCtyCd;
	}

	public void setFm_trsp_agmt_ofc_cty_cd(String fm_trsp_agmt_ofc_cty_cd) {
		this.fmTrspAgmtOfcCtyCd = fm_trsp_agmt_ofc_cty_cd;
	}

	public String getFm_trsp_agmt_seq() {
		return fmTrspAgmtSeq;
	}

	public void setFm_trsp_agmt_seq(String fm_trsp_agmt_seq) {
		this.fmTrspAgmtSeq = fm_trsp_agmt_seq;
	}

	public String getFm_trsp_agmt_rt_tp_ser_no() {
		return fmTrspAgmtRtTpSerNo;
	}

	public void setFm_trsp_agmt_rt_tp_ser_no(String fm_trsp_agmt_rt_tp_ser_no) {
		this.fmTrspAgmtRtTpSerNo = fm_trsp_agmt_rt_tp_ser_no;
	}

	public String getFm_vndr_seq() {
		return fmVndrSeq;
	}

	public void setFm_vndr_seq(String fm_vndr_seq) {
		this.fmVndrSeq = fm_vndr_seq;
	}

	public String getFm_ctrt_ofc_cd() {
		return fmCtrtOfcCd;
	}

	public void setFm_ctrt_ofc_cd(String fm_ctrt_ofc_cd) {
		this.fmCtrtOfcCd = fm_ctrt_ofc_cd;
	}

	public String getFm_eq_knd_cd() {
		return fmEqKndCd;
	}

	public void setFm_eq_knd_cd(String fm_eq_knd_cd) {
		this.fmEqKndCd = fm_eq_knd_cd;
	}

	public String getFm_trsp_agmt_eq_tp_sz_cd() {
		return fmTrspAgmtEqTpSzCd;
	}

	public void setFm_trsp_agmt_eq_tp_sz_cd(String fm_trsp_agmt_eq_tp_sz_cd) {
		this.fmTrspAgmtEqTpSzCd = fm_trsp_agmt_eq_tp_sz_cd;
	}

	public String getFm_cgo_tp_cd() {
		return fmCgoTpCd;
	}

	public void setFm_cgo_tp_cd(String fm_cgo_tp_cd) {
		this.fmCgoTpCd = fm_cgo_tp_cd;
	}

	public String getFm_fm_nod_cd() {
		return fmFmNodCd;
	}

	public void setFm_fm_nod_cd(String fm_fm_nod_cd) {
		this.fmFmNodCd = fm_fm_nod_cd;
	}

	public String getFm_via_nod_cd() {
		return fmViaNodCd;
	}

	public void setFm_via_nod_cd(String fm_via_nod_cd) {
		this.fmViaNodCd = fm_via_nod_cd;
	}

	public String getFm_dor_nod_cd() {
		return fmDorNodCd;
	}

	public void setFm_dor_nod_cd(String fm_dor_nod_cd) {
		this.fmDorNodCd = fm_dor_nod_cd;
	}

	public String getFm_to_nod_cd() {
		return fmToNodCd;
	}

	public void setFm_to_nod_cd(String fm_to_nod_cd) {
		this.fmToNodCd = fm_to_nod_cd;
	}

	public String getFm_trsp_agmt_bdl_qty() {
		return fmTrspAgmtBdlQty;
	}

	public void setFm_trsp_agmt_bdl_qty(String fm_trsp_agmt_bdl_qty) {
		this.fmTrspAgmtBdlQty = fm_trsp_agmt_bdl_qty;
	}

	public String getFm_wgt_meas_ut_cd() {
		return fmWgtMeasUtCd;
	}

	public void setFm_wgt_meas_ut_cd(String fm_wgt_meas_ut_cd) {
		this.fmWgtMeasUtCd = fm_wgt_meas_ut_cd;
	}

	public String getFm_basic_rt() {
		return fmBasicRt;
	}

	public void setFm_basic_rt(String fm_basic_rt) {
		this.fmBasicRt = fm_basic_rt;
	}

	public String getFm_curr_cd() {
		return fmCurrCd;
	}

	public void setFm_curr_cd(String fm_curr_cd) {
		this.fmCurrCd = fm_curr_cd;
	}

	public String getFm_way() {
		return fmWay;
	}

	public void setFm_way(String fm_way) {
		this.fmWay = fm_way;
	}
	
	public String getEffective_date() {
		return effectiveDate;
	}

	public void setEffective_date(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}	
}