/*=========================================================
 *@FileName : ESD_TRS_0224Event.java
 *@FileTitle : Agreement Correction Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
 * 2014.10.29 최종혁 [CHM-201432544] Link 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import java.util.ArrayList;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchCorrSumAgmtVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0224 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0224HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0224Event extends EventSupport {
	String fmAgmtno          = null;
	String fmVndrPrmrySeq  = null;
	String fmCtrtOfcCd     = null;
	String fmTrspAgmtRtTpCd = null;
	String fmEffectiveAgmt  = null;
	String fmHjscnt  = null;
	String fmCustCd = null;
	String fmTrspCostModCd  = null;
	String fmAgmtTrspTpCd   = null;
	String fmCgoTpCd  = null;
	String fmRailSvcTpCd  = null;
	String fmCmdtGrpCd  = null;
	String fmTrspScgCd  = null;
	String fmAccountOfcCd  = null;
	String fmAccountUsrId  = null;
	String fmCfmFlg  = null;
	String fmLinkFlg  = null;

	private SearchCorrSumAgmtVO searchCorrSumAgmtVO = null;
	private SearchCorrSumAgmtVO[] searchCorrSumAgmtVOs = null;

	public String getFm_agmtno() {
		return fmAgmtno;
	}

	public void setFm_agmtno(String fm_agmtno) {
		this.fmAgmtno = fm_agmtno;
	}

	public String getFm_vndr_prmry_seq() {
		return fmVndrPrmrySeq;
	}

	public void setFm_vndr_prmry_seq(String fmVndrPrmrySeq) {
		this.fmVndrPrmrySeq = fmVndrPrmrySeq;
	}

	public String getFm_ctrt_ofc_cd() {
		return fmCtrtOfcCd;
	}

	public void setFm_ctrt_ofc_cd(String fmCtrtOfcCd) {
		this.fmCtrtOfcCd = fmCtrtOfcCd;
	}

	public String getFm_trsp_agmt_rt_tp_cd() {
		return fmTrspAgmtRtTpCd;
	}

	public void setFm_trsp_agmt_rt_tp_cd(String fmTrspAgmtRtTpCd) {
		this.fmTrspAgmtRtTpCd = fmTrspAgmtRtTpCd;
	}

	public String getFm_effective_agmt() {
		return fmEffectiveAgmt;
	}

	public void setFm_effective_agmt(String fmEffectiveAgmt) {
		this.fmEffectiveAgmt = fmEffectiveAgmt;
	}

	public String getFm_hjscnt() {
		return fmHjscnt;
	}

	public void setFm_hjscnt(String fmHjscnt) {
		this.fmHjscnt = fmHjscnt;
	}

	public String getFm_cust_cd() {
		return fmCustCd;
	}

	public void setFm_cust_cd(String fmCustCd) {
		this.fmCustCd = fmCustCd;
	}

	public String getFm_trsp_cost_mod_cd() {
		return fmTrspCostModCd;
	}

	public void setFm_trsp_cost_mod_cd(String fmTrspCostModCd) {
		this.fmTrspCostModCd = fmTrspCostModCd;
	}

	public String getFm_agmt_trsp_tp_cd() {
		return fmAgmtTrspTpCd;
	}

	public void setFm_agmt_trsp_tp_cd(String fmAgmtTrspTpCd) {
		this.fmAgmtTrspTpCd = fmAgmtTrspTpCd;
	}

	public String getFm_cgo_tp_cd() {
		return fmCgoTpCd;
	}

	public void setFm_cgo_tp_cd(String fmCgoTpCd) {
		this.fmCgoTpCd = fmCgoTpCd;
	}

	public String getFm_rail_svc_tp_cd() {
		return fmRailSvcTpCd;
	}

	public void setFm_rail_svc_tp_cd(String fmRailSvcTpCd) {
		this.fmRailSvcTpCd = fmRailSvcTpCd;
	}

	public String getFm_cmdt_grp_cd() {
		return fmCmdtGrpCd;
	}

	public void setFm_cmdt_grp_cd(String fmCmdtGrpCd) {
		this.fmCmdtGrpCd = fmCmdtGrpCd;
	}

	public String getFm_trsp_scg_cd() {
		return fmTrspScgCd;
	}

	public void setFm_trsp_scg_cd(String fmTrspScgCd) {
		this.fmTrspScgCd = fmTrspScgCd;
	}

	public SearchCorrSumAgmtVO getSearchCorrSumAgmtVO() {
		return searchCorrSumAgmtVO;
	}

	public void setSearchCorrSumAgmtVO(SearchCorrSumAgmtVO searchCorrSumAgmtVO) {
		this.searchCorrSumAgmtVO = searchCorrSumAgmtVO;
	}

	public SearchCorrSumAgmtVO[] getSearchCorrSumAgmtVOs() {
		return searchCorrSumAgmtVOs;
	}

	public void setSearchCorrSumAgmtVOs(SearchCorrSumAgmtVO[] searchCorrSumAgmtVOs) {
		this.searchCorrSumAgmtVOs = searchCorrSumAgmtVOs;
	}

	public String getFm_account_ofc_cd() {
		return fmAccountOfcCd;
	}

	public void setFm_account_ofc_cd(String fmAccountOfcCd) {
		this.fmAccountOfcCd = fmAccountOfcCd;
	}

	public String getFm_account_usr_id() {
		return fmAccountUsrId;
	}

	public void setFm_account_usr_id(String fmAccountUsrId) {
		this.fmAccountUsrId = fmAccountUsrId;
	}

	public String getFmCfmFlg() {
		return fmCfmFlg;
	}

	public void setFmCfmFlg(String fmCfmFlg) {
		this.fmCfmFlg = fmCfmFlg;
	}

	public String getFmLinkFlg() {
		return fmLinkFlg;
	}

	public void setFmLinkFlg(String fmLinkFlg) {
		this.fmLinkFlg = fmLinkFlg;
	}

	public ArrayList setArrayList(String[] src, ArrayList tgt){
		tgt = new ArrayList();

		for(int i=0;src != null && i<src.length; i++  ){
			tgt.add(src[i]);
		}
		return tgt;
	}


}
