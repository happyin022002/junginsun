/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteMsUSVO.java
*@FileTitle : InlandRouteMsUSVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.11 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InlandRouteMsUSVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InlandRouteMsUSVO> models = new ArrayList<InlandRouteMsUSVO>();
	
	/* Column Info */
	private String wrsFChk = null;
	/* Column Info */
	private String detailOrgIWrsFlCd = null;
	/* Column Info */
	private String iRoutDestNodCd = null;
	/* Column Info */
	private String iWrsFlCd = null;
	/* Column Info */
	private String detailOrgIBkgFlg = null;
	/* Column Info */
	private String rBtnIrgCd = null;
	/* Column Info */
	private String iWrsMtCd = null;
	/* Column Info */
	private String detailOrgIInv = null;
	/* Column Info */
	private String iOrgCd = null;
	/* Column Info */
	private String iMcntrRoutFlg = null;
	/* Column Info */
	private String iRoutOrgNodCd = null;
	/* Column Info */
	private String iHubSearchGb = null;
	/* Column Info */
	private String iFrontGb = null;
	/* Column Info */
	private String iSelrow = null;
	/* Column Info */
	private String iUndefineNod = null;
	/* Column Info */
	private String iCombinedMod = null;
	/* Column Info */
	private String rowCount = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String iRoutSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nextRoutSeq = null;
	/* Column Info */
	private String disableBkgFlg = null;
	/* Column Info */
	private String nextPrioSeq = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String iWebRailSysFlg = null;
	/* Column Info */
	private String iRoutPlnCd = null;
	/* Column Info */
	private String iNewRouteCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String detailOrgIRoutPlnCd = null;
	/* Column Info */
	private String prioSeqCombo = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String rBtnNodTyCd = null;
	/* Column Info */
	private String detailOrgIWrsMtCd = null;
	/* Column Info */
	private String iDestCd = null;
	/* Column Info */
	private String iBkgFlg = null;
	/* Column Info */
	private String iInv = null;
	/* Column Info */
	private String iDelFlg = null;
	/* Column Info */
	private String iSelRow = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String iHubLoc = null;
	/* Column Info */
	private String nodTpCd1 = null;
	/* Column Info */
	private String nodTpCd2 = null;
	/* Column Info */
	private String iRouteRmk = null;
	/* Column Info */
	private String rInbound = null;
	/* Column Info */
	private String iNewroutecd = null;
	
	private String iOptmFlg = null;
	
	public void setIOptmFlg (String iOptmFlg) {
		this.iOptmFlg = iOptmFlg;
	}
	
	public String getIOptmFlg () {
		return this.iOptmFlg;
	}
	
	//2009-10-12 kim kwijin추가
	private String fullRtnYdCd = null;
	
	private String fullPkupYdCd = null;
	
	public String getFullRtnYdCd() {
		return fullRtnYdCd;
	}

	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}

	public String getFullPkupYdCd() {
		return fullPkupYdCd;
	}

	public void setFullPkupYdCd(String fullPkupYdCd) {
		this.fullPkupYdCd = fullPkupYdCd;
	}

	public String getTrspModCd() {
		return trspModCd;
	}

	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}

	private String trspModCd	= null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InlandRouteMsUSVO() {}

	public InlandRouteMsUSVO(String ibflag, String pagerows, String rowCount, String rInbound, String iInv, String iRoutPlnCd, String iWrsFlCd, String iWrsMtCd, String iRoutOrgNodCd, String iRoutDestNodCd, String cnt, String iRoutSeq, String iRouteRmk, String iHubSearchGb, String iFrontGb, String iUndefineNod, String iNewroutecd, String iNewRouteCd, String iSelrow, String iSelRow, String disableBkgFlg, String prioSeqCombo, String detailOrgIInv, String detailOrgIRoutPlnCd, String detailOrgIBkgFlg, String iMcntrRoutFlg, String detailOrgIWrsFlCd, String detailOrgIWrsMtCd, String rBtnNodTyCd, String iDelFlg, String rBtnIrgCd, String iOrgCd, String iDestCd, String iHubLoc, String nodTpCd1, String nodTpCd2, String iCombinedMod, String iWebRailSysFlg, String iBkgFlg, String wrsFChk, String nextRoutSeq, String nextPrioSeq, String updUsrId, String creUsrId, String creOfcCd,String fullRtnYdCd,String fullPkupYdCd,String trspModCd, String iOptmFlg) {
		this.wrsFChk = wrsFChk;
		this.detailOrgIWrsFlCd = detailOrgIWrsFlCd;
		this.iRoutDestNodCd = iRoutDestNodCd;
		this.iWrsFlCd = iWrsFlCd;
		this.detailOrgIBkgFlg = detailOrgIBkgFlg;
		this.rBtnIrgCd = rBtnIrgCd;
		this.iWrsMtCd = iWrsMtCd;
		this.detailOrgIInv = detailOrgIInv;
		this.iOrgCd = iOrgCd;
		this.iMcntrRoutFlg = iMcntrRoutFlg;
		this.iRoutOrgNodCd = iRoutOrgNodCd;
		this.iHubSearchGb = iHubSearchGb;
		this.iFrontGb = iFrontGb;
		this.iSelrow = iSelrow;
		this.iUndefineNod = iUndefineNod;
		this.iCombinedMod = iCombinedMod;
		this.rowCount = rowCount;
		this.pagerows = pagerows;
		this.iRoutSeq = iRoutSeq;
		this.ibflag = ibflag;
		this.nextRoutSeq = nextRoutSeq;
		this.disableBkgFlg = disableBkgFlg;
		this.nextPrioSeq = nextPrioSeq;
		this.creOfcCd = creOfcCd;
		this.iWebRailSysFlg = iWebRailSysFlg;
		this.iRoutPlnCd = iRoutPlnCd;
		this.iNewRouteCd = iNewRouteCd;
		this.updUsrId = updUsrId;
		this.detailOrgIRoutPlnCd = detailOrgIRoutPlnCd;
		this.prioSeqCombo = prioSeqCombo;
		this.cnt = cnt;
		this.rBtnNodTyCd = rBtnNodTyCd;
		this.detailOrgIWrsMtCd = detailOrgIWrsMtCd;
		this.iDestCd = iDestCd;
		this.iBkgFlg = iBkgFlg;
		this.iInv = iInv;
		this.iDelFlg = iDelFlg;
		this.iSelRow = iSelRow;
		this.creUsrId = creUsrId;
		this.iHubLoc = iHubLoc;
		this.nodTpCd1 = nodTpCd1;
		this.nodTpCd2 = nodTpCd2;
		this.iRouteRmk = iRouteRmk;
		this.rInbound = rInbound;
		this.iNewroutecd = iNewroutecd;
		
		this.fullRtnYdCd = fullRtnYdCd;
		this.fullPkupYdCd = fullPkupYdCd;
		this.trspModCd = trspModCd;
		this.iOptmFlg = iOptmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wrs_f_chk", getWrsFChk());
		this.hashColumns.put("detail_org_i_wrs_fl_cd", getDetailOrgIWrsFlCd());
		this.hashColumns.put("i_rout_dest_nod_cd", getIRoutDestNodCd());
		this.hashColumns.put("i_wrs_fl_cd", getIWrsFlCd());
		this.hashColumns.put("detail_org_i_bkg_flg", getDetailOrgIBkgFlg());
		this.hashColumns.put("r_btn_irg_cd", getRBtnIrgCd());
		this.hashColumns.put("i_wrs_mt_cd", getIWrsMtCd());
		this.hashColumns.put("detail_org_i_inv", getDetailOrgIInv());
		this.hashColumns.put("i_org_cd", getIOrgCd());
		this.hashColumns.put("i_mcntr_rout_flg", getIMcntrRoutFlg());
		this.hashColumns.put("i_rout_org_nod_cd", getIRoutOrgNodCd());
		this.hashColumns.put("i_hub_search_gb", getIHubSearchGb());
		this.hashColumns.put("i_front_gb", getIFrontGb());
		this.hashColumns.put("i_selrow", getISelrow());
		this.hashColumns.put("i_undefine_nod", getIUndefineNod());
		this.hashColumns.put("i_combined_mod", getICombinedMod());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("i_rout_seq", getIRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("next_rout_seq", getNextRoutSeq());
		this.hashColumns.put("disable_bkg_flg", getDisableBkgFlg());
		this.hashColumns.put("next_prio_seq", getNextPrioSeq());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("i_web_rail_sys_flg", getIWebRailSysFlg());
		this.hashColumns.put("i_rout_pln_cd", getIRoutPlnCd());
		this.hashColumns.put("i_new_route_cd", getINewRouteCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("detail_org_i_rout_pln_cd", getDetailOrgIRoutPlnCd());
		this.hashColumns.put("prio_seq_combo", getPrioSeqCombo());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("r_btn_nod_ty_cd", getRBtnNodTyCd());
		this.hashColumns.put("detail_org_i_wrs_mt_cd", getDetailOrgIWrsMtCd());
		this.hashColumns.put("i_dest_cd", getIDestCd());
		this.hashColumns.put("i_bkg_flg", getIBkgFlg());
		this.hashColumns.put("i_inv", getIInv());
		this.hashColumns.put("i_del_flg", getIDelFlg());
		this.hashColumns.put("i_sel_row", getISelRow());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("i_hub_loc", getIHubLoc());
		this.hashColumns.put("nod_tp_cd1", getNodTpCd1());
		this.hashColumns.put("nod_tp_cd2", getNodTpCd2());
		this.hashColumns.put("i_route_rmk", getIRouteRmk());
		this.hashColumns.put("r_inbound", getRInbound());
		this.hashColumns.put("i_newroutecd", getINewroutecd());
		this.hashColumns.put("full_rtn_yd_cd", this.getFullRtnYdCd());
		this.hashColumns.put("full_pkup_yd_cd", this.getFullPkupYdCd());
		this.hashColumns.put("trsp_mod_cd", this.getTrspModCd());
		this.hashColumns.put("i_optm_flg", this.getIOptmFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wrs_f_chk", "wrsFChk");
		this.hashFields.put("detail_org_i_wrs_fl_cd", "detailOrgIWrsFlCd");
		this.hashFields.put("i_rout_dest_nod_cd", "iRoutDestNodCd");
		this.hashFields.put("i_wrs_fl_cd", "iWrsFlCd");
		this.hashFields.put("detail_org_i_bkg_flg", "detailOrgIBkgFlg");
		this.hashFields.put("r_btn_irg_cd", "rBtnIrgCd");
		this.hashFields.put("i_wrs_mt_cd", "iWrsMtCd");
		this.hashFields.put("detail_org_i_inv", "detailOrgIInv");
		this.hashFields.put("i_org_cd", "iOrgCd");
		this.hashFields.put("i_mcntr_rout_flg", "iMcntrRoutFlg");
		this.hashFields.put("i_rout_org_nod_cd", "iRoutOrgNodCd");
		this.hashFields.put("i_hub_search_gb", "iHubSearchGb");
		this.hashFields.put("i_front_gb", "iFrontGb");
		this.hashFields.put("i_selrow", "iSelrow");
		this.hashFields.put("i_undefine_nod", "iUndefineNod");
		this.hashFields.put("i_combined_mod", "iCombinedMod");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("i_rout_seq", "iRoutSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("next_rout_seq", "nextRoutSeq");
		this.hashFields.put("disable_bkg_flg", "disableBkgFlg");
		this.hashFields.put("next_prio_seq", "nextPrioSeq");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("i_web_rail_sys_flg", "iWebRailSysFlg");
		this.hashFields.put("i_rout_pln_cd", "iRoutPlnCd");
		this.hashFields.put("i_new_route_cd", "iNewRouteCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("detail_org_i_rout_pln_cd", "detailOrgIRoutPlnCd");
		this.hashFields.put("prio_seq_combo", "prioSeqCombo");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("r_btn_nod_ty_cd", "rBtnNodTyCd");
		this.hashFields.put("detail_org_i_wrs_mt_cd", "detailOrgIWrsMtCd");
		this.hashFields.put("i_dest_cd", "iDestCd");
		this.hashFields.put("i_bkg_flg", "iBkgFlg");
		this.hashFields.put("i_inv", "iInv");
		this.hashFields.put("i_del_flg", "iDelFlg");
		this.hashFields.put("i_sel_row", "iSelRow");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("i_hub_loc", "iHubLoc");
		this.hashFields.put("nod_tp_cd1", "nodTpCd1");
		this.hashFields.put("nod_tp_cd2", "nodTpCd2");
		this.hashFields.put("i_route_rmk", "iRouteRmk");
		this.hashFields.put("r_inbound", "rInbound");
		this.hashFields.put("i_newroutecd", "iNewroutecd");
		
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("i_optm_flg", "iOptmFlg");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return wrsFChk
	 */
	public String getWrsFChk() {
		return this.wrsFChk;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIWrsFlCd
	 */
	public String getDetailOrgIWrsFlCd() {
		return this.detailOrgIWrsFlCd;
	}
	
	/**
	 * Column Info
	 * @return iRoutDestNodCd
	 */
	public String getIRoutDestNodCd() {
		return this.iRoutDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return iWrsFlCd
	 */
	public String getIWrsFlCd() {
		return this.iWrsFlCd;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIBkgFlg
	 */
	public String getDetailOrgIBkgFlg() {
		return this.detailOrgIBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return rBtnIrgCd
	 */
	public String getRBtnIrgCd() {
		return this.rBtnIrgCd;
	}
	
	/**
	 * Column Info
	 * @return iWrsMtCd
	 */
	public String getIWrsMtCd() {
		return this.iWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIInv
	 */
	public String getDetailOrgIInv() {
		return this.detailOrgIInv;
	}
	
	/**
	 * Column Info
	 * @return iOrgCd
	 */
	public String getIOrgCd() {
		return this.iOrgCd;
	}
	
	/**
	 * Column Info
	 * @return iMcntrRoutFlg
	 */
	public String getIMcntrRoutFlg() {
		return this.iMcntrRoutFlg;
	}
	
	/**
	 * Column Info
	 * @return iRoutOrgNodCd
	 */
	public String getIRoutOrgNodCd() {
		return this.iRoutOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return iHubSearchGb
	 */
	public String getIHubSearchGb() {
		return this.iHubSearchGb;
	}
	
	/**
	 * Column Info
	 * @return iFrontGb
	 */
	public String getIFrontGb() {
		return this.iFrontGb;
	}
	
	/**
	 * Column Info
	 * @return iSelrow
	 */
	public String getISelrow() {
		return this.iSelrow;
	}
	
	/**
	 * Column Info
	 * @return iUndefineNod
	 */
	public String getIUndefineNod() {
		return this.iUndefineNod;
	}
	
	/**
	 * Column Info
	 * @return iCombinedMod
	 */
	public String getICombinedMod() {
		return this.iCombinedMod;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return iRoutSeq
	 */
	public String getIRoutSeq() {
		return this.iRoutSeq;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return nextRoutSeq
	 */
	public String getNextRoutSeq() {
		return this.nextRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return disableBkgFlg
	 */
	public String getDisableBkgFlg() {
		return this.disableBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return nextPrioSeq
	 */
	public String getNextPrioSeq() {
		return this.nextPrioSeq;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return iWebRailSysFlg
	 */
	public String getIWebRailSysFlg() {
		return this.iWebRailSysFlg;
	}
	
	/**
	 * Column Info
	 * @return iRoutPlnCd
	 */
	public String getIRoutPlnCd() {
		return this.iRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @return iNewRouteCd
	 */
	public String getINewRouteCd() {
		return this.iNewRouteCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIRoutPlnCd
	 */
	public String getDetailOrgIRoutPlnCd() {
		return this.detailOrgIRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @return prioSeqCombo
	 */
	public String getPrioSeqCombo() {
		return this.prioSeqCombo;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return rBtnNodTyCd
	 */
	public String getRBtnNodTyCd() {
		return this.rBtnNodTyCd;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIWrsMtCd
	 */
	public String getDetailOrgIWrsMtCd() {
		return this.detailOrgIWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @return iDestCd
	 */
	public String getIDestCd() {
		return this.iDestCd;
	}
	
	/**
	 * Column Info
	 * @return iBkgFlg
	 */
	public String getIBkgFlg() {
		return this.iBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return iInv
	 */
	public String getIInv() {
		return this.iInv;
	}
	
	/**
	 * Column Info
	 * @return iDelFlg
	 */
	public String getIDelFlg() {
		return this.iDelFlg;
	}
	
	/**
	 * Column Info
	 * @return iSelRow
	 */
	public String getISelRow() {
		return this.iSelRow;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return iHubLoc
	 */
	public String getIHubLoc() {
		return this.iHubLoc;
	}
	
	/**
	 * Column Info
	 * @return nodTpCd1
	 */
	public String getNodTpCd1() {
		return this.nodTpCd1;
	}
	
	/**
	 * Column Info
	 * @return nodTpCd2
	 */
	public String getNodTpCd2() {
		return this.nodTpCd2;
	}
	
	/**
	 * Column Info
	 * @return iRouteRmk
	 */
	public String getIRouteRmk() {
		return this.iRouteRmk;
	}
	
	/**
	 * Column Info
	 * @return rInbound
	 */
	public String getRInbound() {
		return this.rInbound;
	}
	
	/**
	 * Column Info
	 * @return iNewroutecd
	 */
	public String getINewroutecd() {
		return this.iNewroutecd;
	}
	

	/**
	 * Column Info
	 * @param wrsFChk
	 */
	public void setWrsFChk(String wrsFChk) {
		this.wrsFChk = wrsFChk;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIWrsFlCd
	 */
	public void setDetailOrgIWrsFlCd(String detailOrgIWrsFlCd) {
		this.detailOrgIWrsFlCd = detailOrgIWrsFlCd;
	}
	
	/**
	 * Column Info
	 * @param iRoutDestNodCd
	 */
	public void setIRoutDestNodCd(String iRoutDestNodCd) {
		this.iRoutDestNodCd = iRoutDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param iWrsFlCd
	 */
	public void setIWrsFlCd(String iWrsFlCd) {
		this.iWrsFlCd = iWrsFlCd;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIBkgFlg
	 */
	public void setDetailOrgIBkgFlg(String detailOrgIBkgFlg) {
		this.detailOrgIBkgFlg = detailOrgIBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param rBtnIrgCd
	 */
	public void setRBtnIrgCd(String rBtnIrgCd) {
		this.rBtnIrgCd = rBtnIrgCd;
	}
	
	/**
	 * Column Info
	 * @param iWrsMtCd
	 */
	public void setIWrsMtCd(String iWrsMtCd) {
		this.iWrsMtCd = iWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIInv
	 */
	public void setDetailOrgIInv(String detailOrgIInv) {
		this.detailOrgIInv = detailOrgIInv;
	}
	
	/**
	 * Column Info
	 * @param iOrgCd
	 */
	public void setIOrgCd(String iOrgCd) {
		this.iOrgCd = iOrgCd;
	}
	
	/**
	 * Column Info
	 * @param iMcntrRoutFlg
	 */
	public void setIMcntrRoutFlg(String iMcntrRoutFlg) {
		this.iMcntrRoutFlg = iMcntrRoutFlg;
	}
	
	/**
	 * Column Info
	 * @param iRoutOrgNodCd
	 */
	public void setIRoutOrgNodCd(String iRoutOrgNodCd) {
		this.iRoutOrgNodCd = iRoutOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param iHubSearchGb
	 */
	public void setIHubSearchGb(String iHubSearchGb) {
		this.iHubSearchGb = iHubSearchGb;
	}
	
	/**
	 * Column Info
	 * @param iFrontGb
	 */
	public void setIFrontGb(String iFrontGb) {
		this.iFrontGb = iFrontGb;
	}
	
	/**
	 * Column Info
	 * @param iSelrow
	 */
	public void setISelrow(String iSelrow) {
		this.iSelrow = iSelrow;
	}
	
	/**
	 * Column Info
	 * @param iUndefineNod
	 */
	public void setIUndefineNod(String iUndefineNod) {
		this.iUndefineNod = iUndefineNod;
	}
	
	/**
	 * Column Info
	 * @param iCombinedMod
	 */
	public void setICombinedMod(String iCombinedMod) {
		this.iCombinedMod = iCombinedMod;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param iRoutSeq
	 */
	public void setIRoutSeq(String iRoutSeq) {
		this.iRoutSeq = iRoutSeq;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param nextRoutSeq
	 */
	public void setNextRoutSeq(String nextRoutSeq) {
		this.nextRoutSeq = nextRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param disableBkgFlg
	 */
	public void setDisableBkgFlg(String disableBkgFlg) {
		this.disableBkgFlg = disableBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param nextPrioSeq
	 */
	public void setNextPrioSeq(String nextPrioSeq) {
		this.nextPrioSeq = nextPrioSeq;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param iWebRailSysFlg
	 */
	public void setIWebRailSysFlg(String iWebRailSysFlg) {
		this.iWebRailSysFlg = iWebRailSysFlg;
	}
	
	/**
	 * Column Info
	 * @param iRoutPlnCd
	 */
	public void setIRoutPlnCd(String iRoutPlnCd) {
		this.iRoutPlnCd = iRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @param iNewRouteCd
	 */
	public void setINewRouteCd(String iNewRouteCd) {
		this.iNewRouteCd = iNewRouteCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIRoutPlnCd
	 */
	public void setDetailOrgIRoutPlnCd(String detailOrgIRoutPlnCd) {
		this.detailOrgIRoutPlnCd = detailOrgIRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @param prioSeqCombo
	 */
	public void setPrioSeqCombo(String prioSeqCombo) {
		this.prioSeqCombo = prioSeqCombo;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param rBtnNodTyCd
	 */
	public void setRBtnNodTyCd(String rBtnNodTyCd) {
		this.rBtnNodTyCd = rBtnNodTyCd;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIWrsMtCd
	 */
	public void setDetailOrgIWrsMtCd(String detailOrgIWrsMtCd) {
		this.detailOrgIWrsMtCd = detailOrgIWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @param iDestCd
	 */
	public void setIDestCd(String iDestCd) {
		this.iDestCd = iDestCd;
	}
	
	/**
	 * Column Info
	 * @param iBkgFlg
	 */
	public void setIBkgFlg(String iBkgFlg) {
		this.iBkgFlg = iBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param iInv
	 */
	public void setIInv(String iInv) {
		this.iInv = iInv;
	}
	
	/**
	 * Column Info
	 * @param iDelFlg
	 */
	public void setIDelFlg(String iDelFlg) {
		this.iDelFlg = iDelFlg;
	}
	
	/**
	 * Column Info
	 * @param iSelRow
	 */
	public void setISelRow(String iSelRow) {
		this.iSelRow = iSelRow;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param iHubLoc
	 */
	public void setIHubLoc(String iHubLoc) {
		this.iHubLoc = iHubLoc;
	}
	
	/**
	 * Column Info
	 * @param nodTpCd1
	 */
	public void setNodTpCd1(String nodTpCd1) {
		this.nodTpCd1 = nodTpCd1;
	}
	
	/**
	 * Column Info
	 * @param nodTpCd2
	 */
	public void setNodTpCd2(String nodTpCd2) {
		this.nodTpCd2 = nodTpCd2;
	}
	
	/**
	 * Column Info
	 * @param iRouteRmk
	 */
	public void setIRouteRmk(String iRouteRmk) {
		this.iRouteRmk = iRouteRmk;
	}
	
	/**
	 * Column Info
	 * @param rInbound
	 */
	public void setRInbound(String rInbound) {
		this.rInbound = rInbound;
	}
	
	/**
	 * Column Info
	 * @param iNewroutecd
	 */
	public void setINewroutecd(String iNewroutecd) {
		this.iNewroutecd = iNewroutecd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWrsFChk(JSPUtil.getParameter(request, "wrs_f_chk", ""));
		setDetailOrgIWrsFlCd(JSPUtil.getParameter(request, "detail_org_i_wrs_fl_cd", ""));
		setIRoutDestNodCd(JSPUtil.getParameter(request, "i_rout_dest_nod_cd", ""));
		setIWrsFlCd(JSPUtil.getParameter(request, "i_wrs_fl_cd", ""));
		setDetailOrgIBkgFlg(JSPUtil.getParameter(request, "detail_org_i_bkg_flg", ""));
		setRBtnIrgCd(JSPUtil.getParameter(request, "r_btn_irg_cd", ""));
		setIWrsMtCd(JSPUtil.getParameter(request, "i_wrs_mt_cd", ""));
		setDetailOrgIInv(JSPUtil.getParameter(request, "detail_org_i_inv", ""));
		setIOrgCd(JSPUtil.getParameter(request, "i_org_cd", ""));
		setIMcntrRoutFlg(JSPUtil.getParameter(request, "i_mcntr_rout_flg", ""));
		setIRoutOrgNodCd(JSPUtil.getParameter(request, "i_rout_org_nod_cd", ""));
		setIHubSearchGb(JSPUtil.getParameter(request, "i_hub_search_gb", ""));
		setIFrontGb(JSPUtil.getParameter(request, "i_front_gb", ""));
		setISelrow(JSPUtil.getParameter(request, "i_selrow", ""));
		setIUndefineNod(JSPUtil.getParameter(request, "i_undefine_nod", ""));
		setICombinedMod(JSPUtil.getParameter(request, "i_combined_mod", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIRoutSeq(JSPUtil.getParameter(request, "i_rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNextRoutSeq(JSPUtil.getParameter(request, "next_rout_seq", ""));
		setDisableBkgFlg(JSPUtil.getParameter(request, "disable_bkg_flg", ""));
		setNextPrioSeq(JSPUtil.getParameter(request, "next_prio_seq", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setIWebRailSysFlg(JSPUtil.getParameter(request, "i_web_rail_sys_flg", ""));
		setIRoutPlnCd(JSPUtil.getParameter(request, "i_rout_pln_cd", ""));
		setINewRouteCd(JSPUtil.getParameter(request, "i_new_route_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDetailOrgIRoutPlnCd(JSPUtil.getParameter(request, "detail_org_i_rout_pln_cd", ""));
		setPrioSeqCombo(JSPUtil.getParameter(request, "prio_seq_combo", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));
		setRBtnNodTyCd(JSPUtil.getParameter(request, "r_btn_nod_ty_cd", ""));
		setDetailOrgIWrsMtCd(JSPUtil.getParameter(request, "detail_org_i_wrs_mt_cd", ""));
		setIDestCd(JSPUtil.getParameter(request, "i_dest_cd", ""));
		setIBkgFlg(JSPUtil.getParameter(request, "i_bkg_flg", ""));
		setIInv(JSPUtil.getParameter(request, "i_inv", ""));
		setIDelFlg(JSPUtil.getParameter(request, "i_del_flg", ""));
		setISelRow(JSPUtil.getParameter(request, "i_sel_row", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIHubLoc(JSPUtil.getParameter(request, "i_hub_loc", ""));
		setNodTpCd1(JSPUtil.getParameter(request, "nod_tp_cd1", ""));
		setNodTpCd2(JSPUtil.getParameter(request, "nod_tp_cd2", ""));
		setIRouteRmk(JSPUtil.getParameter(request, "i_route_rmk", ""));
		setRInbound(JSPUtil.getParameter(request, "r_inbound", ""));
		setINewroutecd(JSPUtil.getParameter(request, "i_newroutecd", ""));
		this.setFullRtnYdCd(JSPUtil.getParameter(request, "full_rtn_yd_cd", ""));
		this.setFullPkupYdCd(JSPUtil.getParameter(request, "full_pkup_yd_cd", ""));
		this.setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		this.setIOptmFlg(JSPUtil.getParameter(request, "i_optm_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandRouteMsUSVO[]
	 */
	public InlandRouteMsUSVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InlandRouteMsUSVO[]
	 */
	public InlandRouteMsUSVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandRouteMsUSVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wrsFChk = (JSPUtil.getParameter(request, prefix	+ "wrs_f_chk", length));
			String[] detailOrgIWrsFlCd = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_wrs_fl_cd", length));
			String[] iRoutDestNodCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_dest_nod_cd", length));
			String[] iWrsFlCd = (JSPUtil.getParameter(request, prefix	+ "i_wrs_fl_cd", length));
			String[] detailOrgIBkgFlg = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_bkg_flg", length));
			String[] rBtnIrgCd = (JSPUtil.getParameter(request, prefix	+ "r_btn_irg_cd", length));
			String[] iWrsMtCd = (JSPUtil.getParameter(request, prefix	+ "i_wrs_mt_cd", length));
			String[] detailOrgIInv = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_inv", length));
			String[] iOrgCd = (JSPUtil.getParameter(request, prefix	+ "i_org_cd", length));
			String[] iMcntrRoutFlg = (JSPUtil.getParameter(request, prefix	+ "i_mcntr_rout_flg", length));
			String[] iRoutOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_org_nod_cd", length));
			String[] iHubSearchGb = (JSPUtil.getParameter(request, prefix	+ "i_hub_search_gb", length));
			String[] iFrontGb = (JSPUtil.getParameter(request, prefix	+ "i_front_gb", length));
			String[] iSelrow = (JSPUtil.getParameter(request, prefix	+ "i_selrow", length));
			String[] iUndefineNod = (JSPUtil.getParameter(request, prefix	+ "i_undefine_nod", length));
			String[] iCombinedMod = (JSPUtil.getParameter(request, prefix	+ "i_combined_mod", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] iRoutSeq = (JSPUtil.getParameter(request, prefix	+ "i_rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nextRoutSeq = (JSPUtil.getParameter(request, prefix	+ "next_rout_seq", length));
			String[] disableBkgFlg = (JSPUtil.getParameter(request, prefix	+ "disable_bkg_flg", length));
			String[] nextPrioSeq = (JSPUtil.getParameter(request, prefix	+ "next_prio_seq", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] iWebRailSysFlg = (JSPUtil.getParameter(request, prefix	+ "i_web_rail_sys_flg", length));
			String[] iRoutPlnCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_pln_cd", length));
			String[] iNewRouteCd = (JSPUtil.getParameter(request, prefix	+ "i_new_route_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] detailOrgIRoutPlnCd = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_rout_pln_cd", length));
			String[] prioSeqCombo = (JSPUtil.getParameter(request, prefix	+ "prio_seq_combo", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] rBtnNodTyCd = (JSPUtil.getParameter(request, prefix	+ "r_btn_nod_ty_cd", length));
			String[] detailOrgIWrsMtCd = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_wrs_mt_cd", length));
			String[] iDestCd = (JSPUtil.getParameter(request, prefix	+ "i_dest_cd", length));
			String[] iBkgFlg = (JSPUtil.getParameter(request, prefix	+ "i_bkg_flg", length));
			String[] iInv = (JSPUtil.getParameter(request, prefix	+ "i_inv", length));
			String[] iDelFlg = (JSPUtil.getParameter(request, prefix	+ "i_del_flg", length));
			String[] iSelRow = (JSPUtil.getParameter(request, prefix	+ "i_sel_row", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] iHubLoc = (JSPUtil.getParameter(request, prefix	+ "i_hub_loc", length));
			String[] nodTpCd1 = (JSPUtil.getParameter(request, prefix	+ "nod_tp_cd1", length));
			String[] nodTpCd2 = (JSPUtil.getParameter(request, prefix	+ "nod_tp_cd2", length));
			String[] iRouteRmk = (JSPUtil.getParameter(request, prefix	+ "i_route_rmk", length));
			String[] rInbound = (JSPUtil.getParameter(request, prefix	+ "r_inbound", length));
			String[] iNewroutecd = (JSPUtil.getParameter(request, prefix	+ "i_newroutecd", length));
			
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "full_pkup_yd_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			
			String[] iOptmFlg = (JSPUtil.getParameter(request, prefix	+ "i_optm_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InlandRouteMsUSVO();
				if (wrsFChk[i] != null)
					model.setWrsFChk(wrsFChk[i]);
				if (detailOrgIWrsFlCd[i] != null)
					model.setDetailOrgIWrsFlCd(detailOrgIWrsFlCd[i]);
				if (iRoutDestNodCd[i] != null)
					model.setIRoutDestNodCd(iRoutDestNodCd[i]);
				if (iWrsFlCd[i] != null)
					model.setIWrsFlCd(iWrsFlCd[i]);
				if (detailOrgIBkgFlg[i] != null)
					model.setDetailOrgIBkgFlg(detailOrgIBkgFlg[i]);
				if (rBtnIrgCd[i] != null)
					model.setRBtnIrgCd(rBtnIrgCd[i]);
				if (iWrsMtCd[i] != null)
					model.setIWrsMtCd(iWrsMtCd[i]);
				if (detailOrgIInv[i] != null)
					model.setDetailOrgIInv(detailOrgIInv[i]);
				if (iOrgCd[i] != null)
					model.setIOrgCd(iOrgCd[i]);
				if (iMcntrRoutFlg[i] != null)
					model.setIMcntrRoutFlg(iMcntrRoutFlg[i]);
				if (iRoutOrgNodCd[i] != null)
					model.setIRoutOrgNodCd(iRoutOrgNodCd[i]);
				if (iHubSearchGb[i] != null)
					model.setIHubSearchGb(iHubSearchGb[i]);
				if (iFrontGb[i] != null)
					model.setIFrontGb(iFrontGb[i]);
				if (iSelrow[i] != null)
					model.setISelrow(iSelrow[i]);
				if (iUndefineNod[i] != null)
					model.setIUndefineNod(iUndefineNod[i]);
				if (iCombinedMod[i] != null)
					model.setICombinedMod(iCombinedMod[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (iRoutSeq[i] != null)
					model.setIRoutSeq(iRoutSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nextRoutSeq[i] != null)
					model.setNextRoutSeq(nextRoutSeq[i]);
				if (disableBkgFlg[i] != null)
					model.setDisableBkgFlg(disableBkgFlg[i]);
				if (nextPrioSeq[i] != null)
					model.setNextPrioSeq(nextPrioSeq[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (iWebRailSysFlg[i] != null)
					model.setIWebRailSysFlg(iWebRailSysFlg[i]);
				if (iRoutPlnCd[i] != null)
					model.setIRoutPlnCd(iRoutPlnCd[i]);
				if (iNewRouteCd[i] != null)
					model.setINewRouteCd(iNewRouteCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (detailOrgIRoutPlnCd[i] != null)
					model.setDetailOrgIRoutPlnCd(detailOrgIRoutPlnCd[i]);
				if (prioSeqCombo[i] != null)
					model.setPrioSeqCombo(prioSeqCombo[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (rBtnNodTyCd[i] != null)
					model.setRBtnNodTyCd(rBtnNodTyCd[i]);
				if (detailOrgIWrsMtCd[i] != null)
					model.setDetailOrgIWrsMtCd(detailOrgIWrsMtCd[i]);
				if (iDestCd[i] != null)
					model.setIDestCd(iDestCd[i]);
				if (iBkgFlg[i] != null)
					model.setIBkgFlg(iBkgFlg[i]);
				if (iInv[i] != null)
					model.setIInv(iInv[i]);
				if (iDelFlg[i] != null)
					model.setIDelFlg(iDelFlg[i]);
				if (iSelRow[i] != null)
					model.setISelRow(iSelRow[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (iHubLoc[i] != null)
					model.setIHubLoc(iHubLoc[i]);
				if (nodTpCd1[i] != null)
					model.setNodTpCd1(nodTpCd1[i]);
				if (nodTpCd2[i] != null)
					model.setNodTpCd2(nodTpCd2[i]);
				if (iRouteRmk[i] != null)
					model.setIRouteRmk(iRouteRmk[i]);
				if (rInbound[i] != null)
					model.setRInbound(rInbound[i]);
				if (iNewroutecd[i] != null)
					model.setINewroutecd(iNewroutecd[i]);
				
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (iOptmFlg[i] != null)
					model.setIOptmFlg(iOptmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandRouteMsUSVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandRouteMsUSVO[]
	 */
	public InlandRouteMsUSVO[] getInlandRouteMsUSVOs(){
		InlandRouteMsUSVO[] vos = (InlandRouteMsUSVO[])models.toArray(new InlandRouteMsUSVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.wrsFChk = this.wrsFChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIWrsFlCd = this.detailOrgIWrsFlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutDestNodCd = this.iRoutDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iWrsFlCd = this.iWrsFlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIBkgFlg = this.detailOrgIBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBtnIrgCd = this.rBtnIrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iWrsMtCd = this.iWrsMtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIInv = this.detailOrgIInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOrgCd = this.iOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iMcntrRoutFlg = this.iMcntrRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutOrgNodCd = this.iRoutOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iHubSearchGb = this.iHubSearchGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iFrontGb = this.iFrontGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSelrow = this.iSelrow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iUndefineNod = this.iUndefineNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iCombinedMod = this.iCombinedMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutSeq = this.iRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextRoutSeq = this.nextRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disableBkgFlg = this.disableBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPrioSeq = this.nextPrioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iWebRailSysFlg = this.iWebRailSysFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutPlnCd = this.iRoutPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iNewRouteCd = this.iNewRouteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIRoutPlnCd = this.detailOrgIRoutPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeqCombo = this.prioSeqCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBtnNodTyCd = this.rBtnNodTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIWrsMtCd = this.detailOrgIWrsMtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDestCd = this.iDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iBkgFlg = this.iBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iInv = this.iInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDelFlg = this.iDelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSelRow = this.iSelRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iHubLoc = this.iHubLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTpCd1 = this.nodTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTpCd2 = this.nodTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRouteRmk = this.iRouteRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rInbound = this.rInbound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iNewroutecd = this.iNewroutecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPkupYdCd = this.fullPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOptmFlg = this.iOptmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
