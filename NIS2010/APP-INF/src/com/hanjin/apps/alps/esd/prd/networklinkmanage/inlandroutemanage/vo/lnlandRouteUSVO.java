/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : lnlandRouteUSVO.java
*@FileTitle : lnlandRouteUSVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.07 김귀진 
* 1.0 Creation
* 2012.09.24 정선용  CHM-201220334-01: [PRD] Optimum flag 범위확대 요청
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

public class lnlandRouteUSVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<lnlandRouteUSVO> models = new ArrayList<lnlandRouteUSVO>();
	
	/* Column Info */
	private String rBtnIrgCd = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String iOrgCd = null;
	/* Column Info */
	private String hubSearchGb = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sumDwTt = null;
	/* Column Info */
	private String hub = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inlndRoutInclSttlFlg = null;
	/* Column Info */
	private String inlndRoutTmpFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String totTt = null;
	/* Column Info */
	private String oldPrioSeq = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String orgLoc = null;
	/* Column Info */
	private String iSelectRow = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String forcePrioFlg = null;
	/* Column Info */
	private String frontGb = null;
	/* Column Info */
	private String iSelectCol = null;
	/* Column Info */
	private String rBtnNodTyCd = null;
	/* Column Info */
	private String iDestCd = null;
	/* Column Info */
	private String destLocType = null;
	/* Column Info */
	private String groupGubun = null;
	/* Column Info */
	private String wrsFullCmdt = null;
	/* Column Info */
	private String iDelFlg = null;
	/* Column Info */
	private String sumTtTime = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String maxPrioSeq = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String wrsFullCmdtCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String iHubLoc = null;
	/* Column Info */
	private String route = null;
	/* Column Info */
	private String rInbound = null;
	/* Column Info */
	private String prioSeq = null;
	/* Column Info */
	private String oriPrioSeq = null;
	/* Column Info */
	private String orgLocType = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String inlndRoutBkgFlg = null;
	/* Column Info */
	private String undefineNod = null;
	
	private String inlndRoutOptmFlg = null;
	
	private String lnkKnt = null;
	
	private String inlndTmnlShtlFlg = null;
	
	private String optmDelAbleFlg = null;

	private String schOptmFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public lnlandRouteUSVO() {}

	public lnlandRouteUSVO(String ibflag, String pagerows, String maxPrioSeq, String routOrgNodCd, String routDestNodCd, String rn, String inlndRoutBkgFlg, String inlndRoutTmpFlg, String inlndRoutInclSttlFlg, String orgLoc, String orgLocType, String destLoc, String destLocType, String routSeq, String prioSeq, String oriPrioSeq, String route, String sumTtTime, String sumDwTt, String totTt, String hubSearchGb, String frontGb, String undefineNod, String groupGubun, String wrsFullCmdt, String wrsFullCmdtCd, String creUsrId, String creOfcCd, String creDt, String hubLocCd, String inlndRoutRmk, String hub, String deltFlg, String routPlnCd, String updUsrId, String updDt, String iOrgCd, String iDestCd, String iSelectRow, String iSelectCol, String rInbound, String rBtnIrgCd, String rBtnNodTyCd, String iHubLoc, String iDelFlg, String oldPrioSeq, String forcePrioFlg, String inlndRoutOptmFlg, String lnkKnt, String inlndTmnlShtlFlg, String optmDelAbleFlg, String schOptmFlg) {
		this.rBtnIrgCd = rBtnIrgCd;
		this.rn = rn;
		this.iOrgCd = iOrgCd;
		this.hubSearchGb = hubSearchGb;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.sumDwTt = sumDwTt;
		this.hub = hub;
		this.routOrgNodCd = routOrgNodCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inlndRoutInclSttlFlg = inlndRoutInclSttlFlg;
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
		this.creOfcCd = creOfcCd;
		this.totTt = totTt;
		this.oldPrioSeq = oldPrioSeq;
		this.routDestNodCd = routDestNodCd;
		this.orgLoc = orgLoc;
		this.iSelectRow = iSelectRow;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.forcePrioFlg = forcePrioFlg;
		this.frontGb = frontGb;
		this.iSelectCol = iSelectCol;
		this.rBtnNodTyCd = rBtnNodTyCd;
		this.iDestCd = iDestCd;
		this.destLocType = destLocType;
		this.groupGubun = groupGubun;
		this.wrsFullCmdt = wrsFullCmdt;
		this.iDelFlg = iDelFlg;
		this.sumTtTime = sumTtTime;
		this.destLoc = destLoc;
		this.routPlnCd = routPlnCd;
		this.routSeq = routSeq;
		this.maxPrioSeq = maxPrioSeq;
		this.inlndRoutRmk = inlndRoutRmk;
		this.wrsFullCmdtCd = wrsFullCmdtCd;
		this.creUsrId = creUsrId;
		this.iHubLoc = iHubLoc;
		this.route = route;
		this.rInbound = rInbound;
		this.prioSeq = prioSeq;
		this.oriPrioSeq = oriPrioSeq;
		this.orgLocType = orgLocType;
		this.hubLocCd = hubLocCd;
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
		this.undefineNod = undefineNod;
		this.inlndRoutOptmFlg = inlndRoutOptmFlg;
		this.lnkKnt = lnkKnt;
		this.inlndTmnlShtlFlg = inlndTmnlShtlFlg;
		this.optmDelAbleFlg = optmDelAbleFlg;
		this.schOptmFlg = schOptmFlg;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_btn_irg_cd", getRBtnIrgCd());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("i_org_cd", getIOrgCd());
		this.hashColumns.put("hub_search_gb", getHubSearchGb());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sum_dw_tt", getSumDwTt());
		this.hashColumns.put("hub", getHub());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inlnd_rout_incl_sttl_flg", getInlndRoutInclSttlFlg());
		this.hashColumns.put("inlnd_rout_tmp_flg", getInlndRoutTmpFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("tot_tt", getTotTt());
		this.hashColumns.put("old_prio_seq", getOldPrioSeq());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("org_loc", getOrgLoc());
		this.hashColumns.put("i_select_row", getISelectRow());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("force_prio_flg", getForcePrioFlg());
		this.hashColumns.put("front_gb", getFrontGb());
		this.hashColumns.put("i_select_col", getISelectCol());
		this.hashColumns.put("r_btn_nod_ty_cd", getRBtnNodTyCd());
		this.hashColumns.put("i_dest_cd", getIDestCd());
		this.hashColumns.put("dest_loc_type", getDestLocType());
		this.hashColumns.put("group_gubun", getGroupGubun());
		this.hashColumns.put("wrs_full_cmdt", getWrsFullCmdt());
		this.hashColumns.put("i_del_flg", getIDelFlg());
		this.hashColumns.put("sum_tt_time", getSumTtTime());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("max_prio_seq", getMaxPrioSeq());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("wrs_full_cmdt_cd", getWrsFullCmdtCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("i_hub_loc", getIHubLoc());
		this.hashColumns.put("route", getRoute());
		this.hashColumns.put("r_inbound", getRInbound());
		this.hashColumns.put("prio_seq", getPrioSeq());
		this.hashColumns.put("ori_prio_seq", getOriPrioSeq());
		this.hashColumns.put("org_loc_type", getOrgLocType());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("inlnd_rout_bkg_flg", getInlndRoutBkgFlg());
		this.hashColumns.put("undefine_nod", getUndefineNod());
		this.hashColumns.put("inlnd_rout_optm_flg", getInlndRoutOptmFlg());
		this.hashColumns.put("lnk_knt", getLnkKnt());
		this.hashColumns.put("inlnd_tmnl_shtl_flg", getInlndTmnlShtlFlg());
		this.hashColumns.put("optm_del_able_flg", getOptmDelAbleFlg());
		this.hashColumns.put("sch_optm_flg", getSchOptmFlg());
		

		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_btn_irg_cd", "rBtnIrgCd");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("i_org_cd", "iOrgCd");
		this.hashFields.put("hub_search_gb", "hubSearchGb");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sum_dw_tt", "sumDwTt");
		this.hashFields.put("hub", "hub");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inlnd_rout_incl_sttl_flg", "inlndRoutInclSttlFlg");
		this.hashFields.put("inlnd_rout_tmp_flg", "inlndRoutTmpFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("tot_tt", "totTt");
		this.hashFields.put("old_prio_seq", "oldPrioSeq");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("org_loc", "orgLoc");
		this.hashFields.put("i_select_row", "iSelectRow");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("force_prio_flg", "forcePrioFlg");
		this.hashFields.put("front_gb", "frontGb");
		this.hashFields.put("i_select_col", "iSelectCol");
		this.hashFields.put("r_btn_nod_ty_cd", "rBtnNodTyCd");
		this.hashFields.put("i_dest_cd", "iDestCd");
		this.hashFields.put("dest_loc_type", "destLocType");
		this.hashFields.put("group_gubun", "groupGubun");
		this.hashFields.put("wrs_full_cmdt", "wrsFullCmdt");
		this.hashFields.put("i_del_flg", "iDelFlg");
		this.hashFields.put("sum_tt_time", "sumTtTime");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("max_prio_seq", "maxPrioSeq");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("wrs_full_cmdt_cd", "wrsFullCmdtCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("i_hub_loc", "iHubLoc");
		this.hashFields.put("route", "route");
		this.hashFields.put("r_inbound", "rInbound");
		this.hashFields.put("prio_seq", "prioSeq");
		this.hashFields.put("ori_prio_seq", "oriPrioSeq");
		this.hashFields.put("org_loc_type", "orgLocType");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("inlnd_rout_bkg_flg", "inlndRoutBkgFlg");
		this.hashFields.put("undefine_nod", "undefineNod");

		this.hashFields.put("inlnd_rout_optm_flg", "inlndRoutOptmFlg");
		this.hashFields.put("lnk_knt", "lnkKnt");
		this.hashFields.put("inlnd_tmnl_shtl_flg", "inlndTmnlShtlFlg");
		this.hashFields.put("optm_del_able_flg", "optmDelAbleFlg");

		
		this.hashFields.put("sch_optm_flg", "schOptmFlg");

		return this.hashFields;
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
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
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
	 * @return hubSearchGb
	 */
	public String getHubSearchGb() {
		return this.hubSearchGb;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return sumDwTt
	 */
	public String getSumDwTt() {
		return this.sumDwTt;
	}
	
	/**
	 * Column Info
	 * @return hub
	 */
	public String getHub() {
		return this.hub;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return inlndRoutInclSttlFlg
	 */
	public String getInlndRoutInclSttlFlg() {
		return this.inlndRoutInclSttlFlg;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutTmpFlg
	 */
	public String getInlndRoutTmpFlg() {
		return this.inlndRoutTmpFlg;
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
	 * @return totTt
	 */
	public String getTotTt() {
		return this.totTt;
	}
	
	/**
	 * Column Info
	 * @return oldPrioSeq
	 */
	public String getOldPrioSeq() {
		return this.oldPrioSeq;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return orgLoc
	 */
	public String getOrgLoc() {
		return this.orgLoc;
	}
	
	/**
	 * Column Info
	 * @return iSelectRow
	 */
	public String getISelectRow() {
		return this.iSelectRow;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return forcePrioFlg
	 */
	public String getForcePrioFlg() {
		return this.forcePrioFlg;
	}
	
	/**
	 * Column Info
	 * @return frontGb
	 */
	public String getFrontGb() {
		return this.frontGb;
	}
	
	/**
	 * Column Info
	 * @return iSelectCol
	 */
	public String getISelectCol() {
		return this.iSelectCol;
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
	 * @return iDestCd
	 */
	public String getIDestCd() {
		return this.iDestCd;
	}
	
	/**
	 * Column Info
	 * @return destLocType
	 */
	public String getDestLocType() {
		return this.destLocType;
	}
	
	/**
	 * Column Info
	 * @return groupGubun
	 */
	public String getGroupGubun() {
		return this.groupGubun;
	}
	
	/**
	 * Column Info
	 * @return wrsFullCmdt
	 */
	public String getWrsFullCmdt() {
		return this.wrsFullCmdt;
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
	 * @return sumTtTime
	 */
	public String getSumTtTime() {
		return this.sumTtTime;
	}
	
	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}
	
	/**
	 * Column Info
	 * @return routPlnCd
	 */
	public String getRoutPlnCd() {
		return this.routPlnCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return maxPrioSeq
	 */
	public String getMaxPrioSeq() {
		return this.maxPrioSeq;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return wrsFullCmdtCd
	 */
	public String getWrsFullCmdtCd() {
		return this.wrsFullCmdtCd;
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
	 * @return route
	 */
	public String getRoute() {
		return this.route;
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
	 * @return prioSeq
	 */
	public String getPrioSeq() {
		return this.prioSeq;
	}
	
	/**
	 * Column Info
	 * @return oriPrioSeq
	 */
	public String getOriPrioSeq() {
		return this.oriPrioSeq;
	}
	
	/**
	 * Column Info
	 * @return orgLocType
	 */
	public String getOrgLocType() {
		return this.orgLocType;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutBkgFlg
	 */
	public String getInlndRoutBkgFlg() {
		return this.inlndRoutBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return undefineNod
	 */
	public String getUndefineNod() {
		return this.undefineNod;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutOptmFlg
	 */
	public String getInlndRoutOptmFlg() {
		return this.inlndRoutOptmFlg;
	}
	
	/**
	 * Column Info
	 * @return lnkKnt
	 */
	public String getLnkKnt() {
		return this.lnkKnt;
	}
	
	/**
	 * Column Info
	 * @return inlndTmnlShtlFlg
	 */
	public String getInlndTmnlShtlFlg() {
		return this.inlndTmnlShtlFlg;
	}

	/**
	 * Column Info
	 * @return optmDelAbleFlg
	 */
	public String getOptmDelAbleFlg() {
		return this.optmDelAbleFlg;
	}
	
	/**
	 * Column Info
	 * @return schOptmFlg
	 */
	public String getSchOptmFlg() {
		return this.schOptmFlg;
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
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
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
	 * @param hubSearchGb
	 */
	public void setHubSearchGb(String hubSearchGb) {
		this.hubSearchGb = hubSearchGb;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param sumDwTt
	 */
	public void setSumDwTt(String sumDwTt) {
		this.sumDwTt = sumDwTt;
	}
	
	/**
	 * Column Info
	 * @param hub
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param inlndRoutInclSttlFlg
	 */
	public void setInlndRoutInclSttlFlg(String inlndRoutInclSttlFlg) {
		this.inlndRoutInclSttlFlg = inlndRoutInclSttlFlg;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutTmpFlg
	 */
	public void setInlndRoutTmpFlg(String inlndRoutTmpFlg) {
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
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
	 * @param totTt
	 */
	public void setTotTt(String totTt) {
		this.totTt = totTt;
	}
	
	/**
	 * Column Info
	 * @param oldPrioSeq
	 */
	public void setOldPrioSeq(String oldPrioSeq) {
		this.oldPrioSeq = oldPrioSeq;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param orgLoc
	 */
	public void setOrgLoc(String orgLoc) {
		this.orgLoc = orgLoc;
	}
	
	/**
	 * Column Info
	 * @param iSelectRow
	 */
	public void setISelectRow(String iSelectRow) {
		this.iSelectRow = iSelectRow;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param forcePrioFlg
	 */
	public void setForcePrioFlg(String forcePrioFlg) {
		this.forcePrioFlg = forcePrioFlg;
	}
	
	/**
	 * Column Info
	 * @param frontGb
	 */
	public void setFrontGb(String frontGb) {
		this.frontGb = frontGb;
	}
	
	/**
	 * Column Info
	 * @param iSelectCol
	 */
	public void setISelectCol(String iSelectCol) {
		this.iSelectCol = iSelectCol;
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
	 * @param iDestCd
	 */
	public void setIDestCd(String iDestCd) {
		this.iDestCd = iDestCd;
	}
	
	/**
	 * Column Info
	 * @param destLocType
	 */
	public void setDestLocType(String destLocType) {
		this.destLocType = destLocType;
	}
	
	/**
	 * Column Info
	 * @param groupGubun
	 */
	public void setGroupGubun(String groupGubun) {
		this.groupGubun = groupGubun;
	}
	
	/**
	 * Column Info
	 * @param wrsFullCmdt
	 */
	public void setWrsFullCmdt(String wrsFullCmdt) {
		this.wrsFullCmdt = wrsFullCmdt;
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
	 * @param sumTtTime
	 */
	public void setSumTtTime(String sumTtTime) {
		this.sumTtTime = sumTtTime;
	}
	
	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	
	/**
	 * Column Info
	 * @param routPlnCd
	 */
	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param maxPrioSeq
	 */
	public void setMaxPrioSeq(String maxPrioSeq) {
		this.maxPrioSeq = maxPrioSeq;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param wrsFullCmdtCd
	 */
	public void setWrsFullCmdtCd(String wrsFullCmdtCd) {
		this.wrsFullCmdtCd = wrsFullCmdtCd;
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
	 * @param route
	 */
	public void setRoute(String route) {
		this.route = route;
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
	 * @param prioSeq
	 */
	public void setPrioSeq(String prioSeq) {
		this.prioSeq = prioSeq;
	}
	
	/**
	 * Column Info
	 * @param oriPrioSeq
	 */
	public void setOriPrioSeq(String oriPrioSeq) {
		this.oriPrioSeq = oriPrioSeq;
	}
	
	/**
	 * Column Info
	 * @param orgLocType
	 */
	public void setOrgLocType(String orgLocType) {
		this.orgLocType = orgLocType;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutBkgFlg
	 */
	public void setInlndRoutBkgFlg(String inlndRoutBkgFlg) {
		this.inlndRoutBkgFlg = inlndRoutBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param undefineNod
	 */
	public void setUndefineNod(String undefineNod) {
		this.undefineNod = undefineNod;
	}

	/**
	 * Column Info
	 * @param inlndRoutOptmFlg
	 */
	public void setInlndRoutOptmFlg(String inlndRoutOptmFlg) {
		this.inlndRoutOptmFlg = inlndRoutOptmFlg;
	}

	/**
	 * Column Info
	 * @param lnkKnt
	 */
	public void setLnkKnt(String lnkKnt) {
		this.lnkKnt = lnkKnt;
	}

	/**
	 * Column Info
	 * @param optmDelAbleFlg
	 */
	public void setOptmDelAbleFlg(String optmDelAbleFlg) {
		this.optmDelAbleFlg = optmDelAbleFlg;
	}

	/**
	 * Column Info
	 * @param inlndTmnlShtlFlg
	 */
	public void setInlndTmnlShtlFlg(String inlndTmnlShtlFlg) {
		this.inlndTmnlShtlFlg = inlndTmnlShtlFlg;
	}

	/**
	 * Column Info
	 * @param schOptmFlg
	 */
	public void setSchOptmFlg(String schOptmFlg) {
		this.schOptmFlg = schOptmFlg;
	}
	
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRBtnIrgCd(JSPUtil.getParameter(request, "r_btn_irg_cd", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setIOrgCd(JSPUtil.getParameter(request, "i_org_cd", ""));
		setHubSearchGb(JSPUtil.getParameter(request, "hub_search_gb", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSumDwTt(JSPUtil.getParameter(request, "sum_dw_tt", ""));
		setHub(JSPUtil.getParameter(request, "hub", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInlndRoutInclSttlFlg(JSPUtil.getParameter(request, "inlnd_rout_incl_sttl_flg", ""));
		setInlndRoutTmpFlg(JSPUtil.getParameter(request, "inlnd_rout_tmp_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setTotTt(JSPUtil.getParameter(request, "tot_tt", ""));
		setOldPrioSeq(JSPUtil.getParameter(request, "old_prio_seq", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setOrgLoc(JSPUtil.getParameter(request, "org_loc", ""));
		setISelectRow(JSPUtil.getParameter(request, "i_select_row", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setForcePrioFlg(JSPUtil.getParameter(request, "force_prio_flg", ""));
		setFrontGb(JSPUtil.getParameter(request, "front_gb", ""));
		setISelectCol(JSPUtil.getParameter(request, "i_select_col", ""));
		setRBtnNodTyCd(JSPUtil.getParameter(request, "r_btn_nod_ty_cd", ""));
		setIDestCd(JSPUtil.getParameter(request, "i_dest_cd", ""));
		setDestLocType(JSPUtil.getParameter(request, "dest_loc_type", ""));
		setGroupGubun(JSPUtil.getParameter(request, "group_gubun", ""));
		setWrsFullCmdt(JSPUtil.getParameter(request, "wrs_full_cmdt", ""));
		setIDelFlg(JSPUtil.getParameter(request, "i_del_flg", ""));
		setSumTtTime(JSPUtil.getParameter(request, "sum_tt_time", ""));
		setDestLoc(JSPUtil.getParameter(request, "dest_loc", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setMaxPrioSeq(JSPUtil.getParameter(request, "max_prio_seq", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setWrsFullCmdtCd(JSPUtil.getParameter(request, "wrs_full_cmdt_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIHubLoc(JSPUtil.getParameter(request, "i_hub_loc", ""));
		setRoute(JSPUtil.getParameter(request, "route", ""));
		setRInbound(JSPUtil.getParameter(request, "r_inbound", ""));
		setPrioSeq(JSPUtil.getParameter(request, "prio_seq", ""));
		setOriPrioSeq(JSPUtil.getParameter(request, "ori_prio_seq", ""));
		setOrgLocType(JSPUtil.getParameter(request, "org_loc_type", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
		setInlndRoutBkgFlg(JSPUtil.getParameter(request, "inlnd_rout_bkg_flg", ""));
		setUndefineNod(JSPUtil.getParameter(request, "undefine_nod", ""));
		
		setInlndRoutOptmFlg(JSPUtil.getParameter(request, "inlnd_rout_optm_flg", ""));
		setLnkKnt(JSPUtil.getParameter(request, "lnk_knt", ""));
		setInlndTmnlShtlFlg(JSPUtil.getParameter(request, "inlnd_tmnl_shtl_flg", ""));
		setOptmDelAbleFlg(JSPUtil.getParameter(request, "optm_del_able_flg", ""));
		setSchOptmFlg(JSPUtil.getParameter(request,"sch_optm_flg", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return lnlandRouteUSVO[]
	 */
	public lnlandRouteUSVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return lnlandRouteUSVO[]
	 */
	public lnlandRouteUSVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		lnlandRouteUSVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rBtnIrgCd = (JSPUtil.getParameter(request, prefix	+ "r_btn_irg_cd", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] iOrgCd = (JSPUtil.getParameter(request, prefix	+ "i_org_cd", length));
			String[] hubSearchGb = (JSPUtil.getParameter(request, prefix	+ "hub_search_gb", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sumDwTt = (JSPUtil.getParameter(request, prefix	+ "sum_dw_tt", length));
			String[] hub = (JSPUtil.getParameter(request, prefix	+ "hub", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inlndRoutInclSttlFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_incl_sttl_flg", length));
			String[] inlndRoutTmpFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_tmp_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] totTt = (JSPUtil.getParameter(request, prefix	+ "tot_tt", length));
			String[] oldPrioSeq = (JSPUtil.getParameter(request, prefix	+ "old_prio_seq", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] orgLoc = (JSPUtil.getParameter(request, prefix	+ "org_loc", length));
			String[] iSelectRow = (JSPUtil.getParameter(request, prefix	+ "i_select_row", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] forcePrioFlg = (JSPUtil.getParameter(request, prefix	+ "force_prio_flg", length));
			String[] frontGb = (JSPUtil.getParameter(request, prefix	+ "front_gb", length));
			String[] iSelectCol = (JSPUtil.getParameter(request, prefix	+ "i_select_col", length));
			String[] rBtnNodTyCd = (JSPUtil.getParameter(request, prefix	+ "r_btn_nod_ty_cd", length));
			String[] iDestCd = (JSPUtil.getParameter(request, prefix	+ "i_dest_cd", length));
			String[] destLocType = (JSPUtil.getParameter(request, prefix	+ "dest_loc_type", length));
			String[] groupGubun = (JSPUtil.getParameter(request, prefix	+ "group_gubun", length));
			String[] wrsFullCmdt = (JSPUtil.getParameter(request, prefix	+ "wrs_full_cmdt", length));
			String[] iDelFlg = (JSPUtil.getParameter(request, prefix	+ "i_del_flg", length));
			String[] sumTtTime = (JSPUtil.getParameter(request, prefix	+ "sum_tt_time", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix	+ "rout_pln_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] maxPrioSeq = (JSPUtil.getParameter(request, prefix	+ "max_prio_seq", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_rmk", length));
			String[] wrsFullCmdtCd = (JSPUtil.getParameter(request, prefix	+ "wrs_full_cmdt_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] iHubLoc = (JSPUtil.getParameter(request, prefix	+ "i_hub_loc", length));
			String[] route = (JSPUtil.getParameter(request, prefix	+ "route", length));
			String[] rInbound = (JSPUtil.getParameter(request, prefix	+ "r_inbound", length));
			String[] prioSeq = (JSPUtil.getParameter(request, prefix	+ "prio_seq", length));
			String[] oriPrioSeq = (JSPUtil.getParameter(request, prefix	+ "ori_prio_seq", length));
			String[] orgLocType = (JSPUtil.getParameter(request, prefix	+ "org_loc_type", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] inlndRoutBkgFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_bkg_flg", length));
			String[] undefineNod = (JSPUtil.getParameter(request, prefix	+ "undefine_nod", length));

			String[] inlndRoutOptmFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_optm_flg", length));
			String[] lnkKnt = (JSPUtil.getParameter(request, prefix	+ "lnk_knt", length));
			String[] inlndTmnlShtlFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_tmnl_shtl_flg", length));
			String[] optmDelAbleFlg = (JSPUtil.getParameter(request, prefix	+ "optm_del_able_flg", length));
			String[] schOptmFlg = (JSPUtil.getParameter(request, prefix	+ "sch_optm_flg", length));

			for (int i = 0; i < length; i++) {
				model = new lnlandRouteUSVO();
				if (rBtnIrgCd[i] != null)
					model.setRBtnIrgCd(rBtnIrgCd[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (iOrgCd[i] != null)
					model.setIOrgCd(iOrgCd[i]);
				if (hubSearchGb[i] != null)
					model.setHubSearchGb(hubSearchGb[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sumDwTt[i] != null)
					model.setSumDwTt(sumDwTt[i]);
				if (hub[i] != null)
					model.setHub(hub[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inlndRoutInclSttlFlg[i] != null)
					model.setInlndRoutInclSttlFlg(inlndRoutInclSttlFlg[i]);
				if (inlndRoutTmpFlg[i] != null)
					model.setInlndRoutTmpFlg(inlndRoutTmpFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (totTt[i] != null)
					model.setTotTt(totTt[i]);
				if (oldPrioSeq[i] != null)
					model.setOldPrioSeq(oldPrioSeq[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (orgLoc[i] != null)
					model.setOrgLoc(orgLoc[i]);
				if (iSelectRow[i] != null)
					model.setISelectRow(iSelectRow[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (forcePrioFlg[i] != null)
					model.setForcePrioFlg(forcePrioFlg[i]);
				if (frontGb[i] != null)
					model.setFrontGb(frontGb[i]);
				if (iSelectCol[i] != null)
					model.setISelectCol(iSelectCol[i]);
				if (rBtnNodTyCd[i] != null)
					model.setRBtnNodTyCd(rBtnNodTyCd[i]);
				if (iDestCd[i] != null)
					model.setIDestCd(iDestCd[i]);
				if (destLocType[i] != null)
					model.setDestLocType(destLocType[i]);
				if (groupGubun[i] != null)
					model.setGroupGubun(groupGubun[i]);
				if (wrsFullCmdt[i] != null)
					model.setWrsFullCmdt(wrsFullCmdt[i]);
				if (iDelFlg[i] != null)
					model.setIDelFlg(iDelFlg[i]);
				if (sumTtTime[i] != null)
					model.setSumTtTime(sumTtTime[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (maxPrioSeq[i] != null)
					model.setMaxPrioSeq(maxPrioSeq[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (wrsFullCmdtCd[i] != null)
					model.setWrsFullCmdtCd(wrsFullCmdtCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (iHubLoc[i] != null)
					model.setIHubLoc(iHubLoc[i]);
				if (route[i] != null)
					model.setRoute(route[i]);
				if (rInbound[i] != null)
					model.setRInbound(rInbound[i]);
				if (prioSeq[i] != null)
					model.setPrioSeq(prioSeq[i]);
				if (oriPrioSeq[i] != null)
					model.setOriPrioSeq(oriPrioSeq[i]);
				if (orgLocType[i] != null)
					model.setOrgLocType(orgLocType[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (inlndRoutBkgFlg[i] != null)
					model.setInlndRoutBkgFlg(inlndRoutBkgFlg[i]);
				if (undefineNod[i] != null)
					model.setUndefineNod(undefineNod[i]);

				if (inlndRoutOptmFlg[i] != null)
					model.setInlndRoutOptmFlg(inlndRoutOptmFlg[i]);
				if (lnkKnt[i] != null)
					model.setLnkKnt(lnkKnt[i]);
				if (inlndTmnlShtlFlg[i] != null)
					model.setInlndTmnlShtlFlg(inlndTmnlShtlFlg[i]);
				if (optmDelAbleFlg[i] != null)
					model.setOptmDelAbleFlg(optmDelAbleFlg[i]);
				if (schOptmFlg[i] != null)
					model.setSchOptmFlg(schOptmFlg[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getlnlandRouteUSVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return lnlandRouteUSVO[]
	 */
	public lnlandRouteUSVO[] getlnlandRouteUSVOs(){
		lnlandRouteUSVO[] vos = (lnlandRouteUSVO[])models.toArray(new lnlandRouteUSVO[models.size()]);
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
		this.rBtnIrgCd = this.rBtnIrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOrgCd = this.iOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubSearchGb = this.hubSearchGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumDwTt = this.sumDwTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hub = this.hub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutInclSttlFlg = this.inlndRoutInclSttlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutTmpFlg = this.inlndRoutTmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTt = this.totTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPrioSeq = this.oldPrioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLoc = this.orgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSelectRow = this.iSelectRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forcePrioFlg = this.forcePrioFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frontGb = this.frontGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSelectCol = this.iSelectCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBtnNodTyCd = this.rBtnNodTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDestCd = this.iDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocType = this.destLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupGubun = this.groupGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsFullCmdt = this.wrsFullCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDelFlg = this.iDelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumTtTime = this.sumTtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPrioSeq = this.maxPrioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsFullCmdtCd = this.wrsFullCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iHubLoc = this.iHubLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.route = this.route .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rInbound = this.rInbound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeq = this.prioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriPrioSeq = this.oriPrioSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocType = this.orgLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutBkgFlg = this.inlndRoutBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undefineNod = this.undefineNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.inlndRoutOptmFlg = this.inlndRoutOptmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkKnt = this.lnkKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTmnlShtlFlg = this.inlndTmnlShtlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmDelAbleFlg = this.optmDelAbleFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOptmFlg = this.schOptmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
