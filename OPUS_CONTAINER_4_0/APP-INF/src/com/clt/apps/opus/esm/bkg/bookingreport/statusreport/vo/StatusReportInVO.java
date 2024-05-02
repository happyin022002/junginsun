/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportInVO.java
*@FileTitle : StatusReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.02.24 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StatusReportInVO> models = new ArrayList<StatusReportInVO>();
	
	/* Column Info */
	private String agentCdAll = null;
	/* Column Info */
	private String nonRev = null;
	/* Column Info */
	private String holding = null;
	/* Column Info */
	private String spCargoHd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spCargoHg = null;
	/* Column Info */
	private String spCargoPc = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String fvVvdCd = null;
	/* Column Info */
	private String fvPolCd = null;
	/* Column Info */
	private String fvPodYardCd = null;
	/* Column Info */
	private String bOfcCdSub = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String spCargoPm = null;
	/* Column Info */
	private String bOfcCd = null;
	/* Column Info */
	private String bkgKind = null;
	/* Column Info */
	private String orderbyTitleSql = null;
	/* Column Info */
	private String boardFromDt = null;
	/* Column Info */
	private String zoneCd = null;
	/* Column Info */
	private String boardToDt = null;
	/* Column Info */
	private String pGridType = null;
	/* Column Info */
	private String sModeOri = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String spCargoFg = null;
	/* Column Info */
	private String podTs = null;
	/* Column Info */
	private String stopCargo = null;
	/* Column Info */
	private String bStaffId = null;
	/* Column Info */
	private String caedY = null;
	/* Column Info */
	private String caedN = null;
	/* Column Info */
	private String deptCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String roN = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String crnNoFlag = null;
	/* Column Info */
	private String sRouteDest = null;
	/* Column Info */
	private String wgtFrom = null;
	/* Column Info */
	private String spCargoRb = null;
	/* Column Info */
	private String roY = null;
	/* Column Info */
	private String spCargoRf = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String polLocal = null;
	/* Column Info */
	private String spCargoRd = null;
	/* Column Info */
	private String cRepId = null;
	/* Column Info */
	private String ctrRfaNo = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String cOfcCdSub = null;
	/* Column Info */
	private String deliMode = null;
	/* Column Info */
	private String lOfcCdSub = null;
	/* Column Info */
	private String certiChecks = null;
	/* Column Info */
	private String rdYn = null;
	/* Column Info */
	private String orderbySelect = null;
	/* Column Info */
	private String spCargoSoc = null;
	/* Column Info */
	private String pBkgRptKndCd = null;
	/* Column Info */
	private String fvPolLocal = null;
	/* Column Info */
	private String fvPodCd = null;
	/* Column Info */
	private String podLocal = null;
	/* Column Info */
	private String lRepId = null;
	/* Column Info */
	private String lastOrderby = null;
	/* Column Info */
	private String rTerm = null;
	/* Column Info */
	private String certiG = null;
	/* Column Info */
	private String sModeDest = null;
	/* Column Info */
	private String certiN = null;
	/* Column Info */
	private String fvPolYardCd = null;
	/* Column Info */
	private String certiY = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String polYardCd = null;
	/* Column Info */
	private String bkgStsCdW = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String bkgStsCdX = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String spCargoBb = null;
	/* Column Info */
	private String podYardCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ctrRfaCd = null;
	/* Column Info */
	private String lOfcCd = null;
	/* Column Info */
	private String cargoTpF = null;
	/* Column Info */
	private String bkgStsCdF = null;
	/* Column Info */
	private String fvPrePstCd = null;
	/* Column Info */
	private String trunkFlag = null;
	/* Column Info */
	private String sRouteOri = null;
	/* Column Info */
	private String bkgStsCdA = null;
	/* Column Info */
	private String spCargoAk = null;
	/* Column Info */
	private String certiC = null;
	/* Column Info */
	private String cOfcCd = null;
	/* Column Info */
	private String certiD = null;
	/* Column Info */
	private String agentCd = null;
	/* Column Info */
	private String cargoTpR = null;
	/* Column Info */
	private String certiA = null;
	/* Column Info */
	private String orderby = null;
	/* Column Info */
	private String certiB = null;
	/* Column Info */
	private String cargoTpP = null;
	/* Column Info */
	private String nonSpCargo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fvPodLocal = null;
	/* Column Info */
	private String blTypeS = null;
	/* Column Info */
	private String wgtTo = null;
	/* Column Info */
	private String pReportType = null;
	/* Column Info */
	private String aesY = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spCargoEq = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String orderbyTitle = null;
	/* Column Info */
	private String polTs = null;
	/* Column Info */
	private String custTpCdS = null;
	/* Column Info */
	private String caFlag = null;
	/* Column Info */
	private String custTpCdN = null;
	/* Column Info */
	private String custTpCdF = null;
	/* Column Info */
	private String custTpCdG = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custTpCdC = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String custTpCdA = null;
	/* Column Info */
	private String blTypeA = null;
	/* Column Info */
	private String aesN = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String spCargoDg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StatusReportInVO() {}

	public StatusReportInVO(String ibflag, String pagerows, String pBkgRptKndCd, String pGridType, String pReportType, String currPage, String rowsPerPage, String lastOrderby, String orderby, String orderbySelect, String orderbyTitleSql, String orderbyTitle, String vvdCd, String trunkFlag, String laneCd, String dirCd, String polCd, String polYardCd, String polLocal, String polTs, String podCd, String podYardCd, String podLocal, String podTs, String porCd, String delCd, String rTerm, String dTerm, String zoneCd, String deliMode, String boardFromDt, String boardToDt, String bkgFromDt, String bkgToDt, String bkgKind, String bOfcCd, String bOfcCdSub, String bStaffId, String caFlag, String agentCd, String agentCdAll, String eqType, String cmdtCd, String cmdtNm, String wgtFrom, String wgtTo, String soNo, String lOfcCd, String lOfcCdSub, String deptCd, String lRepId, String cOfcCd, String cOfcCdSub, String cRepId, String ctrRfaCd, String ctrRfaNo, String sModeOri, String sModeDest, String sRouteOri, String sRouteDest, String fvPrePstCd, String fvVvdCd, String fvPolCd, String fvPolYardCd, String fvPolLocal, String fvPodCd, String fvPodYardCd, String fvPodLocal, String custTpCdS, String custTpCdC, String custTpCdN, String custTpCdF, String custTpCdA, String custTpCdG, String custCntCd, String custSeq, String custNm, String custTpCd, String spCargoDg, String spCargoRf, String spCargoAk, String spCargoBb, String spCargoHg, String spCargoSoc, String spCargoEq, String spCargoRd, String spCargoPm, String spCargoPc, String spCargoFg, String spCargoHd, String spCargoRb, String cargoTpF, String cargoTpP, String cargoTpR, String bkgStsCdF, String bkgStsCdX, String bkgStsCdA, String bkgStsCdW, String nonSpCargo, String holding, String blTypeA, String blTypeS, String rev, String nonRev, String aesY, String aesN, String stopCargo, String roY, String roN, String caedY, String caedN, String crnNoFlag, String certiD, String certiA, String certiB, String certiG, String certiC, String certiChecks, String certiY, String certiN, String rdYn) {
		this.agentCdAll = agentCdAll;
		this.nonRev = nonRev;
		this.holding = holding;
		this.spCargoHd = spCargoHd;
		this.pagerows = pagerows;
		this.spCargoHg = spCargoHg;
		this.spCargoPc = spCargoPc;
		this.rowsPerPage = rowsPerPage;
		this.vvdCd = vvdCd;
		this.fvVvdCd = fvVvdCd;
		this.fvPolCd = fvPolCd;
		this.fvPodYardCd = fvPodYardCd;
		this.bOfcCdSub = bOfcCdSub;
		this.custCntCd = custCntCd;
		this.spCargoPm = spCargoPm;
		this.bOfcCd = bOfcCd;
		this.bkgKind = bkgKind;
		this.orderbyTitleSql = orderbyTitleSql;
		this.boardFromDt = boardFromDt;
		this.zoneCd = zoneCd;
		this.boardToDt = boardToDt;
		this.pGridType = pGridType;
		this.sModeOri = sModeOri;
		this.podCd = podCd;
		this.spCargoFg = spCargoFg;
		this.podTs = podTs;
		this.stopCargo = stopCargo;
		this.bStaffId = bStaffId;
		this.caedY = caedY;
		this.caedN = caedN;
		this.deptCd = deptCd;
		this.laneCd = laneCd;
		this.rev = rev;
		this.roN = roN;
		this.custNm = custNm;
		this.crnNoFlag = crnNoFlag;
		this.sRouteDest = sRouteDest;
		this.wgtFrom = wgtFrom;
		this.spCargoRb = spCargoRb;
		this.roY = roY;
		this.spCargoRf = spCargoRf;
		this.cmdtCd = cmdtCd;
		this.bkgToDt = bkgToDt;
		this.polLocal = polLocal;
		this.spCargoRd = spCargoRd;
		this.cRepId = cRepId;
		this.ctrRfaNo = ctrRfaNo;
		this.dirCd = dirCd;
		this.cOfcCdSub = cOfcCdSub;
		this.deliMode = deliMode;
		this.lOfcCdSub = lOfcCdSub;
		this.certiChecks = certiChecks;
		this.rdYn = rdYn;
		this.orderbySelect = orderbySelect;
		this.spCargoSoc = spCargoSoc;
		this.pBkgRptKndCd = pBkgRptKndCd;
		this.fvPolLocal = fvPolLocal;
		this.fvPodCd = fvPodCd;
		this.podLocal = podLocal;
		this.lRepId = lRepId;
		this.lastOrderby = lastOrderby;
		this.rTerm = rTerm;
		this.certiG = certiG;
		this.sModeDest = sModeDest;
		this.certiN = certiN;
		this.fvPolYardCd = fvPolYardCd;
		this.certiY = certiY;
		this.polCd = polCd;
		this.currPage = currPage;
		this.polYardCd = polYardCd;
		this.bkgStsCdW = bkgStsCdW;
		this.dTerm = dTerm;
		this.bkgStsCdX = bkgStsCdX;
		this.soNo = soNo;
		this.spCargoBb = spCargoBb;
		this.podYardCd = podYardCd;
		this.delCd = delCd;
		this.ctrRfaCd = ctrRfaCd;
		this.lOfcCd = lOfcCd;
		this.cargoTpF = cargoTpF;
		this.bkgStsCdF = bkgStsCdF;
		this.fvPrePstCd = fvPrePstCd;
		this.trunkFlag = trunkFlag;
		this.sRouteOri = sRouteOri;
		this.bkgStsCdA = bkgStsCdA;
		this.spCargoAk = spCargoAk;
		this.certiC = certiC;
		this.cOfcCd = cOfcCd;
		this.certiD = certiD;
		this.agentCd = agentCd;
		this.cargoTpR = cargoTpR;
		this.certiA = certiA;
		this.orderby = orderby;
		this.certiB = certiB;
		this.cargoTpP = cargoTpP;
		this.nonSpCargo = nonSpCargo;
		this.porCd = porCd;
		this.fvPodLocal = fvPodLocal;
		this.blTypeS = blTypeS;
		this.wgtTo = wgtTo;
		this.pReportType = pReportType;
		this.aesY = aesY;
		this.ibflag = ibflag;
		this.spCargoEq = spCargoEq;
		this.custTpCd = custTpCd;
		this.orderbyTitle = orderbyTitle;
		this.polTs = polTs;
		this.custTpCdS = custTpCdS;
		this.caFlag = caFlag;
		this.custTpCdN = custTpCdN;
		this.custTpCdF = custTpCdF;
		this.custTpCdG = custTpCdG;
		this.custSeq = custSeq;
		this.custTpCdC = custTpCdC;
		this.cmdtNm = cmdtNm;
		this.eqType = eqType;
		this.custTpCdA = custTpCdA;
		this.blTypeA = blTypeA;
		this.aesN = aesN;
		this.bkgFromDt = bkgFromDt;
		this.spCargoDg = spCargoDg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agent_cd_all", getAgentCdAll());
		this.hashColumns.put("non_rev", getNonRev());
		this.hashColumns.put("holding", getHolding());
		this.hashColumns.put("sp_cargo_hd", getSpCargoHd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sp_cargo_hg", getSpCargoHg());
		this.hashColumns.put("sp_cargo_pc", getSpCargoPc());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("fv_vvd_cd", getFvVvdCd());
		this.hashColumns.put("fv_pol_cd", getFvPolCd());
		this.hashColumns.put("fv_pod_yard_cd", getFvPodYardCd());
		this.hashColumns.put("b_ofc_cd_sub", getBOfcCdSub());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("sp_cargo_pm", getSpCargoPm());
		this.hashColumns.put("b_ofc_cd", getBOfcCd());
		this.hashColumns.put("bkg_kind", getBkgKind());
		this.hashColumns.put("orderby_title_sql", getOrderbyTitleSql());
		this.hashColumns.put("board_from_dt", getBoardFromDt());
		this.hashColumns.put("zone_cd", getZoneCd());
		this.hashColumns.put("board_to_dt", getBoardToDt());
		this.hashColumns.put("p_grid_type", getPGridType());
		this.hashColumns.put("s_mode_ori", getSModeOri());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sp_cargo_fg", getSpCargoFg());
		this.hashColumns.put("pod_ts", getPodTs());
		this.hashColumns.put("stop_cargo", getStopCargo());
		this.hashColumns.put("b_staff_id", getBStaffId());
		this.hashColumns.put("caed_y", getCaedY());
		this.hashColumns.put("caed_n", getCaedN());
		this.hashColumns.put("dept_cd", getDeptCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("ro_n", getRoN());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("crn_no_flag", getCrnNoFlag());
		this.hashColumns.put("s_route_dest", getSRouteDest());
		this.hashColumns.put("wgt_from", getWgtFrom());
		this.hashColumns.put("sp_cargo_rb", getSpCargoRb());
		this.hashColumns.put("ro_y", getRoY());
		this.hashColumns.put("sp_cargo_rf", getSpCargoRf());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("pol_local", getPolLocal());
		this.hashColumns.put("sp_cargo_rd", getSpCargoRd());
		this.hashColumns.put("c_rep_id", getCRepId());
		this.hashColumns.put("ctr_rfa_no", getCtrRfaNo());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("c_ofc_cd_sub", getCOfcCdSub());
		this.hashColumns.put("deli_mode", getDeliMode());
		this.hashColumns.put("l_ofc_cd_sub", getLOfcCdSub());
		this.hashColumns.put("certi_checks", getCertiChecks());
		this.hashColumns.put("rd_yn", getRdYn());
		this.hashColumns.put("orderby_select", getOrderbySelect());
		this.hashColumns.put("sp_cargo_soc", getSpCargoSoc());
		this.hashColumns.put("p_bkg_rpt_knd_cd", getPBkgRptKndCd());
		this.hashColumns.put("fv_pol_local", getFvPolLocal());
		this.hashColumns.put("fv_pod_cd", getFvPodCd());
		this.hashColumns.put("pod_local", getPodLocal());
		this.hashColumns.put("l_rep_id", getLRepId());
		this.hashColumns.put("last_orderby", getLastOrderby());
		this.hashColumns.put("r_term", getRTerm());
		this.hashColumns.put("certi_g", getCertiG());
		this.hashColumns.put("s_mode_dest", getSModeDest());
		this.hashColumns.put("certi_n", getCertiN());
		this.hashColumns.put("fv_pol_yard_cd", getFvPolYardCd());
		this.hashColumns.put("certi_y", getCertiY());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("pol_yard_cd", getPolYardCd());
		this.hashColumns.put("bkg_sts_cd_w", getBkgStsCdW());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("bkg_sts_cd_x", getBkgStsCdX());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("sp_cargo_bb", getSpCargoBb());
		this.hashColumns.put("pod_yard_cd", getPodYardCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ctr_rfa_cd", getCtrRfaCd());
		this.hashColumns.put("l_ofc_cd", getLOfcCd());
		this.hashColumns.put("cargo_tp_f", getCargoTpF());
		this.hashColumns.put("bkg_sts_cd_f", getBkgStsCdF());
		this.hashColumns.put("fv_pre_pst_cd", getFvPrePstCd());
		this.hashColumns.put("trunk_flag", getTrunkFlag());
		this.hashColumns.put("s_route_ori", getSRouteOri());
		this.hashColumns.put("bkg_sts_cd_a", getBkgStsCdA());
		this.hashColumns.put("sp_cargo_ak", getSpCargoAk());
		this.hashColumns.put("certi_c", getCertiC());
		this.hashColumns.put("c_ofc_cd", getCOfcCd());
		this.hashColumns.put("certi_d", getCertiD());
		this.hashColumns.put("agent_cd", getAgentCd());
		this.hashColumns.put("cargo_tp_r", getCargoTpR());
		this.hashColumns.put("certi_a", getCertiA());
		this.hashColumns.put("orderby", getOrderby());
		this.hashColumns.put("certi_b", getCertiB());
		this.hashColumns.put("cargo_tp_p", getCargoTpP());
		this.hashColumns.put("non_sp_cargo", getNonSpCargo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("fv_pod_local", getFvPodLocal());
		this.hashColumns.put("bl_type_s", getBlTypeS());
		this.hashColumns.put("wgt_to", getWgtTo());
		this.hashColumns.put("p_report_type", getPReportType());
		this.hashColumns.put("aes_y", getAesY());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sp_cargo_eq", getSpCargoEq());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("orderby_title", getOrderbyTitle());
		this.hashColumns.put("pol_ts", getPolTs());
		this.hashColumns.put("cust_tp_cd_s", getCustTpCdS());
		this.hashColumns.put("ca_flag", getCaFlag());
		this.hashColumns.put("cust_tp_cd_n", getCustTpCdN());
		this.hashColumns.put("cust_tp_cd_f", getCustTpCdF());
		this.hashColumns.put("cust_tp_cd_g", getCustTpCdG());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_tp_cd_c", getCustTpCdC());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("cust_tp_cd_a", getCustTpCdA());
		this.hashColumns.put("bl_type_a", getBlTypeA());
		this.hashColumns.put("aes_n", getAesN());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("sp_cargo_dg", getSpCargoDg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agent_cd_all", "agentCdAll");
		this.hashFields.put("non_rev", "nonRev");
		this.hashFields.put("holding", "holding");
		this.hashFields.put("sp_cargo_hd", "spCargoHd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sp_cargo_hg", "spCargoHg");
		this.hashFields.put("sp_cargo_pc", "spCargoPc");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("fv_vvd_cd", "fvVvdCd");
		this.hashFields.put("fv_pol_cd", "fvPolCd");
		this.hashFields.put("fv_pod_yard_cd", "fvPodYardCd");
		this.hashFields.put("b_ofc_cd_sub", "bOfcCdSub");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("sp_cargo_pm", "spCargoPm");
		this.hashFields.put("b_ofc_cd", "bOfcCd");
		this.hashFields.put("bkg_kind", "bkgKind");
		this.hashFields.put("orderby_title_sql", "orderbyTitleSql");
		this.hashFields.put("board_from_dt", "boardFromDt");
		this.hashFields.put("zone_cd", "zoneCd");
		this.hashFields.put("board_to_dt", "boardToDt");
		this.hashFields.put("p_grid_type", "pGridType");
		this.hashFields.put("s_mode_ori", "sModeOri");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sp_cargo_fg", "spCargoFg");
		this.hashFields.put("pod_ts", "podTs");
		this.hashFields.put("stop_cargo", "stopCargo");
		this.hashFields.put("b_staff_id", "bStaffId");
		this.hashFields.put("caed_y", "caedY");
		this.hashFields.put("caed_n", "caedN");
		this.hashFields.put("dept_cd", "deptCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("rev", "rev");
		this.hashFields.put("ro_n", "roN");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("crn_no_flag", "crnNoFlag");
		this.hashFields.put("s_route_dest", "sRouteDest");
		this.hashFields.put("wgt_from", "wgtFrom");
		this.hashFields.put("sp_cargo_rb", "spCargoRb");
		this.hashFields.put("ro_y", "roY");
		this.hashFields.put("sp_cargo_rf", "spCargoRf");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("pol_local", "polLocal");
		this.hashFields.put("sp_cargo_rd", "spCargoRd");
		this.hashFields.put("c_rep_id", "cRepId");
		this.hashFields.put("ctr_rfa_no", "ctrRfaNo");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("c_ofc_cd_sub", "cOfcCdSub");
		this.hashFields.put("deli_mode", "deliMode");
		this.hashFields.put("l_ofc_cd_sub", "lOfcCdSub");
		this.hashFields.put("certi_checks", "certiChecks");
		this.hashFields.put("rd_yn", "rdYn");
		this.hashFields.put("orderby_select", "orderbySelect");
		this.hashFields.put("sp_cargo_soc", "spCargoSoc");
		this.hashFields.put("p_bkg_rpt_knd_cd", "pBkgRptKndCd");
		this.hashFields.put("fv_pol_local", "fvPolLocal");
		this.hashFields.put("fv_pod_cd", "fvPodCd");
		this.hashFields.put("pod_local", "podLocal");
		this.hashFields.put("l_rep_id", "lRepId");
		this.hashFields.put("last_orderby", "lastOrderby");
		this.hashFields.put("r_term", "rTerm");
		this.hashFields.put("certi_g", "certiG");
		this.hashFields.put("s_mode_dest", "sModeDest");
		this.hashFields.put("certi_n", "certiN");
		this.hashFields.put("fv_pol_yard_cd", "fvPolYardCd");
		this.hashFields.put("certi_y", "certiY");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("pol_yard_cd", "polYardCd");
		this.hashFields.put("bkg_sts_cd_w", "bkgStsCdW");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("bkg_sts_cd_x", "bkgStsCdX");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("sp_cargo_bb", "spCargoBb");
		this.hashFields.put("pod_yard_cd", "podYardCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ctr_rfa_cd", "ctrRfaCd");
		this.hashFields.put("l_ofc_cd", "lOfcCd");
		this.hashFields.put("cargo_tp_f", "cargoTpF");
		this.hashFields.put("bkg_sts_cd_f", "bkgStsCdF");
		this.hashFields.put("fv_pre_pst_cd", "fvPrePstCd");
		this.hashFields.put("trunk_flag", "trunkFlag");
		this.hashFields.put("s_route_ori", "sRouteOri");
		this.hashFields.put("bkg_sts_cd_a", "bkgStsCdA");
		this.hashFields.put("sp_cargo_ak", "spCargoAk");
		this.hashFields.put("certi_c", "certiC");
		this.hashFields.put("c_ofc_cd", "cOfcCd");
		this.hashFields.put("certi_d", "certiD");
		this.hashFields.put("agent_cd", "agentCd");
		this.hashFields.put("cargo_tp_r", "cargoTpR");
		this.hashFields.put("certi_a", "certiA");
		this.hashFields.put("orderby", "orderby");
		this.hashFields.put("certi_b", "certiB");
		this.hashFields.put("cargo_tp_p", "cargoTpP");
		this.hashFields.put("non_sp_cargo", "nonSpCargo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fv_pod_local", "fvPodLocal");
		this.hashFields.put("bl_type_s", "blTypeS");
		this.hashFields.put("wgt_to", "wgtTo");
		this.hashFields.put("p_report_type", "pReportType");
		this.hashFields.put("aes_y", "aesY");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_cargo_eq", "spCargoEq");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("orderby_title", "orderbyTitle");
		this.hashFields.put("pol_ts", "polTs");
		this.hashFields.put("cust_tp_cd_s", "custTpCdS");
		this.hashFields.put("ca_flag", "caFlag");
		this.hashFields.put("cust_tp_cd_n", "custTpCdN");
		this.hashFields.put("cust_tp_cd_f", "custTpCdF");
		this.hashFields.put("cust_tp_cd_g", "custTpCdG");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_tp_cd_c", "custTpCdC");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("cust_tp_cd_a", "custTpCdA");
		this.hashFields.put("bl_type_a", "blTypeA");
		this.hashFields.put("aes_n", "aesN");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("sp_cargo_dg", "spCargoDg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agentCdAll
	 */
	public String getAgentCdAll() {
		return this.agentCdAll;
	}
	
	/**
	 * Column Info
	 * @return nonRev
	 */
	public String getNonRev() {
		return this.nonRev;
	}
	
	/**
	 * Column Info
	 * @return holding
	 */
	public String getHolding() {
		return this.holding;
	}
	
	/**
	 * Column Info
	 * @return spCargoHd
	 */
	public String getSpCargoHd() {
		return this.spCargoHd;
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
	 * @return spCargoHg
	 */
	public String getSpCargoHg() {
		return this.spCargoHg;
	}
	
	/**
	 * Column Info
	 * @return spCargoPc
	 */
	public String getSpCargoPc() {
		return this.spCargoPc;
	}
	
	/**
	 * Column Info
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return fvVvdCd
	 */
	public String getFvVvdCd() {
		return this.fvVvdCd;
	}
	
	/**
	 * Column Info
	 * @return fvPolCd
	 */
	public String getFvPolCd() {
		return this.fvPolCd;
	}
	
	/**
	 * Column Info
	 * @return fvPodYardCd
	 */
	public String getFvPodYardCd() {
		return this.fvPodYardCd;
	}
	
	/**
	 * Column Info
	 * @return bOfcCdSub
	 */
	public String getBOfcCdSub() {
		return this.bOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return spCargoPm
	 */
	public String getSpCargoPm() {
		return this.spCargoPm;
	}
	
	/**
	 * Column Info
	 * @return bOfcCd
	 */
	public String getBOfcCd() {
		return this.bOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgKind
	 */
	public String getBkgKind() {
		return this.bkgKind;
	}
	
	/**
	 * Column Info
	 * @return orderbyTitleSql
	 */
	public String getOrderbyTitleSql() {
		return this.orderbyTitleSql;
	}
	
	/**
	 * Column Info
	 * @return boardFromDt
	 */
	public String getBoardFromDt() {
		return this.boardFromDt;
	}
	
	/**
	 * Column Info
	 * @return zoneCd
	 */
	public String getZoneCd() {
		return this.zoneCd;
	}
	
	/**
	 * Column Info
	 * @return boardToDt
	 */
	public String getBoardToDt() {
		return this.boardToDt;
	}
	
	/**
	 * Column Info
	 * @return pGridType
	 */
	public String getPGridType() {
		return this.pGridType;
	}
	
	/**
	 * Column Info
	 * @return sModeOri
	 */
	public String getSModeOri() {
		return this.sModeOri;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return spCargoFg
	 */
	public String getSpCargoFg() {
		return this.spCargoFg;
	}
	
	/**
	 * Column Info
	 * @return podTs
	 */
	public String getPodTs() {
		return this.podTs;
	}
	
	/**
	 * Column Info
	 * @return stopCargo
	 */
	public String getStopCargo() {
		return this.stopCargo;
	}
	
	/**
	 * Column Info
	 * @return bStaffId
	 */
	public String getBStaffId() {
		return this.bStaffId;
	}
	
	/**
	 * Column Info
	 * @return caedY
	 */
	public String getCaedY() {
		return this.caedY;
	}
	
	/**
	 * Column Info
	 * @return caedN
	 */
	public String getCaedN() {
		return this.caedN;
	}
	
	/**
	 * Column Info
	 * @return deptCd
	 */
	public String getDeptCd() {
		return this.deptCd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return rev
	 */
	public String getRev() {
		return this.rev;
	}
	
	/**
	 * Column Info
	 * @return roN
	 */
	public String getRoN() {
		return this.roN;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return crnNoFlag
	 */
	public String getCrnNoFlag() {
		return this.crnNoFlag;
	}
	
	/**
	 * Column Info
	 * @return sRouteDest
	 */
	public String getSRouteDest() {
		return this.sRouteDest;
	}
	
	/**
	 * Column Info
	 * @return wgtFrom
	 */
	public String getWgtFrom() {
		return this.wgtFrom;
	}
	
	/**
	 * Column Info
	 * @return spCargoRb
	 */
	public String getSpCargoRb() {
		return this.spCargoRb;
	}
	
	/**
	 * Column Info
	 * @return roY
	 */
	public String getRoY() {
		return this.roY;
	}
	
	/**
	 * Column Info
	 * @return spCargoRf
	 */
	public String getSpCargoRf() {
		return this.spCargoRf;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return polLocal
	 */
	public String getPolLocal() {
		return this.polLocal;
	}
	
	/**
	 * Column Info
	 * @return spCargoRd
	 */
	public String getSpCargoRd() {
		return this.spCargoRd;
	}
	
	/**
	 * Column Info
	 * @return cRepId
	 */
	public String getCRepId() {
		return this.cRepId;
	}
	
	/**
	 * Column Info
	 * @return ctrRfaNo
	 */
	public String getCtrRfaNo() {
		return this.ctrRfaNo;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return cOfcCdSub
	 */
	public String getCOfcCdSub() {
		return this.cOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @return deliMode
	 */
	public String getDeliMode() {
		return this.deliMode;
	}
	
	/**
	 * Column Info
	 * @return lOfcCdSub
	 */
	public String getLOfcCdSub() {
		return this.lOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @return certiChecks
	 */
	public String getCertiChecks() {
		return this.certiChecks;
	}
	
	/**
	 * Column Info
	 * @return rdYn
	 */
	public String getRdYn() {
		return this.rdYn;
	}
	
	/**
	 * Column Info
	 * @return orderbySelect
	 */
	public String getOrderbySelect() {
		return this.orderbySelect;
	}
	
	/**
	 * Column Info
	 * @return spCargoSoc
	 */
	public String getSpCargoSoc() {
		return this.spCargoSoc;
	}
	
	/**
	 * Column Info
	 * @return pBkgRptKndCd
	 */
	public String getPBkgRptKndCd() {
		return this.pBkgRptKndCd;
	}
	
	/**
	 * Column Info
	 * @return fvPolLocal
	 */
	public String getFvPolLocal() {
		return this.fvPolLocal;
	}
	
	/**
	 * Column Info
	 * @return fvPodCd
	 */
	public String getFvPodCd() {
		return this.fvPodCd;
	}
	
	/**
	 * Column Info
	 * @return podLocal
	 */
	public String getPodLocal() {
		return this.podLocal;
	}
	
	/**
	 * Column Info
	 * @return lRepId
	 */
	public String getLRepId() {
		return this.lRepId;
	}
	
	/**
	 * Column Info
	 * @return lastOrderby
	 */
	public String getLastOrderby() {
		return this.lastOrderby;
	}
	
	/**
	 * Column Info
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
	}
	
	/**
	 * Column Info
	 * @return certiG
	 */
	public String getCertiG() {
		return this.certiG;
	}
	
	/**
	 * Column Info
	 * @return sModeDest
	 */
	public String getSModeDest() {
		return this.sModeDest;
	}
	
	/**
	 * Column Info
	 * @return certiN
	 */
	public String getCertiN() {
		return this.certiN;
	}
	
	/**
	 * Column Info
	 * @return fvPolYardCd
	 */
	public String getFvPolYardCd() {
		return this.fvPolYardCd;
	}
	
	/**
	 * Column Info
	 * @return certiY
	 */
	public String getCertiY() {
		return this.certiY;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return polYardCd
	 */
	public String getPolYardCd() {
		return this.polYardCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdW
	 */
	public String getBkgStsCdW() {
		return this.bkgStsCdW;
	}
	
	/**
	 * Column Info
	 * @return dTerm
	 */
	public String getDTerm() {
		return this.dTerm;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdX
	 */
	public String getBkgStsCdX() {
		return this.bkgStsCdX;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return spCargoBb
	 */
	public String getSpCargoBb() {
		return this.spCargoBb;
	}
	
	/**
	 * Column Info
	 * @return podYardCd
	 */
	public String getPodYardCd() {
		return this.podYardCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return ctrRfaCd
	 */
	public String getCtrRfaCd() {
		return this.ctrRfaCd;
	}
	
	/**
	 * Column Info
	 * @return lOfcCd
	 */
	public String getLOfcCd() {
		return this.lOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cargoTpF
	 */
	public String getCargoTpF() {
		return this.cargoTpF;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdF
	 */
	public String getBkgStsCdF() {
		return this.bkgStsCdF;
	}
	
	/**
	 * Column Info
	 * @return fvPrePstCd
	 */
	public String getFvPrePstCd() {
		return this.fvPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return trunkFlag
	 */
	public String getTrunkFlag() {
		return this.trunkFlag;
	}
	
	/**
	 * Column Info
	 * @return sRouteOri
	 */
	public String getSRouteOri() {
		return this.sRouteOri;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdA
	 */
	public String getBkgStsCdA() {
		return this.bkgStsCdA;
	}
	
	/**
	 * Column Info
	 * @return spCargoAk
	 */
	public String getSpCargoAk() {
		return this.spCargoAk;
	}
	
	/**
	 * Column Info
	 * @return certiC
	 */
	public String getCertiC() {
		return this.certiC;
	}
	
	/**
	 * Column Info
	 * @return cOfcCd
	 */
	public String getCOfcCd() {
		return this.cOfcCd;
	}
	
	/**
	 * Column Info
	 * @return certiD
	 */
	public String getCertiD() {
		return this.certiD;
	}
	
	/**
	 * Column Info
	 * @return agentCd
	 */
	public String getAgentCd() {
		return this.agentCd;
	}
	
	/**
	 * Column Info
	 * @return cargoTpR
	 */
	public String getCargoTpR() {
		return this.cargoTpR;
	}
	
	/**
	 * Column Info
	 * @return certiA
	 */
	public String getCertiA() {
		return this.certiA;
	}
	
	/**
	 * Column Info
	 * @return orderby
	 */
	public String getOrderby() {
		return this.orderby;
	}
	
	/**
	 * Column Info
	 * @return certiB
	 */
	public String getCertiB() {
		return this.certiB;
	}
	
	/**
	 * Column Info
	 * @return cargoTpP
	 */
	public String getCargoTpP() {
		return this.cargoTpP;
	}
	
	/**
	 * Column Info
	 * @return nonSpCargo
	 */
	public String getNonSpCargo() {
		return this.nonSpCargo;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return fvPodLocal
	 */
	public String getFvPodLocal() {
		return this.fvPodLocal;
	}
	
	/**
	 * Column Info
	 * @return blTypeS
	 */
	public String getBlTypeS() {
		return this.blTypeS;
	}
	
	/**
	 * Column Info
	 * @return wgtTo
	 */
	public String getWgtTo() {
		return this.wgtTo;
	}
	
	/**
	 * Column Info
	 * @return pReportType
	 */
	public String getPReportType() {
		return this.pReportType;
	}
	
	/**
	 * Column Info
	 * @return aesY
	 */
	public String getAesY() {
		return this.aesY;
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
	 * @return spCargoEq
	 */
	public String getSpCargoEq() {
		return this.spCargoEq;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return orderbyTitle
	 */
	public String getOrderbyTitle() {
		return this.orderbyTitle;
	}
	
	/**
	 * Column Info
	 * @return polTs
	 */
	public String getPolTs() {
		return this.polTs;
	}
	
	/**
	 * Column Info
	 * @return custTpCdS
	 */
	public String getCustTpCdS() {
		return this.custTpCdS;
	}
	
	/**
	 * Column Info
	 * @return caFlag
	 */
	public String getCaFlag() {
		return this.caFlag;
	}
	
	/**
	 * Column Info
	 * @return custTpCdN
	 */
	public String getCustTpCdN() {
		return this.custTpCdN;
	}
	
	/**
	 * Column Info
	 * @return custTpCdF
	 */
	public String getCustTpCdF() {
		return this.custTpCdF;
	}
	
	/**
	 * Column Info
	 * @return custTpCdG
	 */
	public String getCustTpCdG() {
		return this.custTpCdG;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custTpCdC
	 */
	public String getCustTpCdC() {
		return this.custTpCdC;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Column Info
	 * @return custTpCdA
	 */
	public String getCustTpCdA() {
		return this.custTpCdA;
	}
	
	/**
	 * Column Info
	 * @return blTypeA
	 */
	public String getBlTypeA() {
		return this.blTypeA;
	}
	
	/**
	 * Column Info
	 * @return aesN
	 */
	public String getAesN() {
		return this.aesN;
	}
	
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @return spCargoDg
	 */
	public String getSpCargoDg() {
		return this.spCargoDg;
	}
	

	/**
	 * Column Info
	 * @param agentCdAll
	 */
	public void setAgentCdAll(String agentCdAll) {
		this.agentCdAll = agentCdAll;
	}
	
	/**
	 * Column Info
	 * @param nonRev
	 */
	public void setNonRev(String nonRev) {
		this.nonRev = nonRev;
	}
	
	/**
	 * Column Info
	 * @param holding
	 */
	public void setHolding(String holding) {
		this.holding = holding;
	}
	
	/**
	 * Column Info
	 * @param spCargoHd
	 */
	public void setSpCargoHd(String spCargoHd) {
		this.spCargoHd = spCargoHd;
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
	 * @param spCargoHg
	 */
	public void setSpCargoHg(String spCargoHg) {
		this.spCargoHg = spCargoHg;
	}
	
	/**
	 * Column Info
	 * @param spCargoPc
	 */
	public void setSpCargoPc(String spCargoPc) {
		this.spCargoPc = spCargoPc;
	}
	
	/**
	 * Column Info
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param fvVvdCd
	 */
	public void setFvVvdCd(String fvVvdCd) {
		this.fvVvdCd = fvVvdCd;
	}
	
	/**
	 * Column Info
	 * @param fvPolCd
	 */
	public void setFvPolCd(String fvPolCd) {
		this.fvPolCd = fvPolCd;
	}
	
	/**
	 * Column Info
	 * @param fvPodYardCd
	 */
	public void setFvPodYardCd(String fvPodYardCd) {
		this.fvPodYardCd = fvPodYardCd;
	}
	
	/**
	 * Column Info
	 * @param bOfcCdSub
	 */
	public void setBOfcCdSub(String bOfcCdSub) {
		this.bOfcCdSub = bOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param spCargoPm
	 */
	public void setSpCargoPm(String spCargoPm) {
		this.spCargoPm = spCargoPm;
	}
	
	/**
	 * Column Info
	 * @param bOfcCd
	 */
	public void setBOfcCd(String bOfcCd) {
		this.bOfcCd = bOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgKind
	 */
	public void setBkgKind(String bkgKind) {
		this.bkgKind = bkgKind;
	}
	
	/**
	 * Column Info
	 * @param orderbyTitleSql
	 */
	public void setOrderbyTitleSql(String orderbyTitleSql) {
		this.orderbyTitleSql = orderbyTitleSql;
	}
	
	/**
	 * Column Info
	 * @param boardFromDt
	 */
	public void setBoardFromDt(String boardFromDt) {
		this.boardFromDt = boardFromDt;
	}
	
	/**
	 * Column Info
	 * @param zoneCd
	 */
	public void setZoneCd(String zoneCd) {
		this.zoneCd = zoneCd;
	}
	
	/**
	 * Column Info
	 * @param boardToDt
	 */
	public void setBoardToDt(String boardToDt) {
		this.boardToDt = boardToDt;
	}
	
	/**
	 * Column Info
	 * @param pGridType
	 */
	public void setPGridType(String pGridType) {
		this.pGridType = pGridType;
	}
	
	/**
	 * Column Info
	 * @param sModeOri
	 */
	public void setSModeOri(String sModeOri) {
		this.sModeOri = sModeOri;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param spCargoFg
	 */
	public void setSpCargoFg(String spCargoFg) {
		this.spCargoFg = spCargoFg;
	}
	
	/**
	 * Column Info
	 * @param podTs
	 */
	public void setPodTs(String podTs) {
		this.podTs = podTs;
	}
	
	/**
	 * Column Info
	 * @param stopCargo
	 */
	public void setStopCargo(String stopCargo) {
		this.stopCargo = stopCargo;
	}
	
	/**
	 * Column Info
	 * @param bStaffId
	 */
	public void setBStaffId(String bStaffId) {
		this.bStaffId = bStaffId;
	}
	
	/**
	 * Column Info
	 * @param caedY
	 */
	public void setCaedY(String caedY) {
		this.caedY = caedY;
	}
	
	/**
	 * Column Info
	 * @param caedN
	 */
	public void setCaedN(String caedN) {
		this.caedN = caedN;
	}
	
	/**
	 * Column Info
	 * @param deptCd
	 */
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
	
	/**
	 * Column Info
	 * @param roN
	 */
	public void setRoN(String roN) {
		this.roN = roN;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param crnNoFlag
	 */
	public void setCrnNoFlag(String crnNoFlag) {
		this.crnNoFlag = crnNoFlag;
	}
	
	/**
	 * Column Info
	 * @param sRouteDest
	 */
	public void setSRouteDest(String sRouteDest) {
		this.sRouteDest = sRouteDest;
	}
	
	/**
	 * Column Info
	 * @param wgtFrom
	 */
	public void setWgtFrom(String wgtFrom) {
		this.wgtFrom = wgtFrom;
	}
	
	/**
	 * Column Info
	 * @param spCargoRb
	 */
	public void setSpCargoRb(String spCargoRb) {
		this.spCargoRb = spCargoRb;
	}
	
	/**
	 * Column Info
	 * @param roY
	 */
	public void setRoY(String roY) {
		this.roY = roY;
	}
	
	/**
	 * Column Info
	 * @param spCargoRf
	 */
	public void setSpCargoRf(String spCargoRf) {
		this.spCargoRf = spCargoRf;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param polLocal
	 */
	public void setPolLocal(String polLocal) {
		this.polLocal = polLocal;
	}
	
	/**
	 * Column Info
	 * @param spCargoRd
	 */
	public void setSpCargoRd(String spCargoRd) {
		this.spCargoRd = spCargoRd;
	}
	
	/**
	 * Column Info
	 * @param cRepId
	 */
	public void setCRepId(String cRepId) {
		this.cRepId = cRepId;
	}
	
	/**
	 * Column Info
	 * @param ctrRfaNo
	 */
	public void setCtrRfaNo(String ctrRfaNo) {
		this.ctrRfaNo = ctrRfaNo;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param cOfcCdSub
	 */
	public void setCOfcCdSub(String cOfcCdSub) {
		this.cOfcCdSub = cOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @param deliMode
	 */
	public void setDeliMode(String deliMode) {
		this.deliMode = deliMode;
	}
	
	/**
	 * Column Info
	 * @param lOfcCdSub
	 */
	public void setLOfcCdSub(String lOfcCdSub) {
		this.lOfcCdSub = lOfcCdSub;
	}
	
	/**
	 * Column Info
	 * @param certiChecks
	 */
	public void setCertiChecks(String certiChecks) {
		this.certiChecks = certiChecks;
	}
	
	/**
	 * Column Info
	 * @param rdYn
	 */
	public void setRdYn(String rdYn) {
		this.rdYn = rdYn;
	}
	
	/**
	 * Column Info
	 * @param orderbySelect
	 */
	public void setOrderbySelect(String orderbySelect) {
		this.orderbySelect = orderbySelect;
	}
	
	/**
	 * Column Info
	 * @param spCargoSoc
	 */
	public void setSpCargoSoc(String spCargoSoc) {
		this.spCargoSoc = spCargoSoc;
	}
	
	/**
	 * Column Info
	 * @param pBkgRptKndCd
	 */
	public void setPBkgRptKndCd(String pBkgRptKndCd) {
		this.pBkgRptKndCd = pBkgRptKndCd;
	}
	
	/**
	 * Column Info
	 * @param fvPolLocal
	 */
	public void setFvPolLocal(String fvPolLocal) {
		this.fvPolLocal = fvPolLocal;
	}
	
	/**
	 * Column Info
	 * @param fvPodCd
	 */
	public void setFvPodCd(String fvPodCd) {
		this.fvPodCd = fvPodCd;
	}
	
	/**
	 * Column Info
	 * @param podLocal
	 */
	public void setPodLocal(String podLocal) {
		this.podLocal = podLocal;
	}
	
	/**
	 * Column Info
	 * @param lRepId
	 */
	public void setLRepId(String lRepId) {
		this.lRepId = lRepId;
	}
	
	/**
	 * Column Info
	 * @param lastOrderby
	 */
	public void setLastOrderby(String lastOrderby) {
		this.lastOrderby = lastOrderby;
	}
	
	/**
	 * Column Info
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
	}
	
	/**
	 * Column Info
	 * @param certiG
	 */
	public void setCertiG(String certiG) {
		this.certiG = certiG;
	}
	
	/**
	 * Column Info
	 * @param sModeDest
	 */
	public void setSModeDest(String sModeDest) {
		this.sModeDest = sModeDest;
	}
	
	/**
	 * Column Info
	 * @param certiN
	 */
	public void setCertiN(String certiN) {
		this.certiN = certiN;
	}
	
	/**
	 * Column Info
	 * @param fvPolYardCd
	 */
	public void setFvPolYardCd(String fvPolYardCd) {
		this.fvPolYardCd = fvPolYardCd;
	}
	
	/**
	 * Column Info
	 * @param certiY
	 */
	public void setCertiY(String certiY) {
		this.certiY = certiY;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param polYardCd
	 */
	public void setPolYardCd(String polYardCd) {
		this.polYardCd = polYardCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdW
	 */
	public void setBkgStsCdW(String bkgStsCdW) {
		this.bkgStsCdW = bkgStsCdW;
	}
	
	/**
	 * Column Info
	 * @param dTerm
	 */
	public void setDTerm(String dTerm) {
		this.dTerm = dTerm;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdX
	 */
	public void setBkgStsCdX(String bkgStsCdX) {
		this.bkgStsCdX = bkgStsCdX;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param spCargoBb
	 */
	public void setSpCargoBb(String spCargoBb) {
		this.spCargoBb = spCargoBb;
	}
	
	/**
	 * Column Info
	 * @param podYardCd
	 */
	public void setPodYardCd(String podYardCd) {
		this.podYardCd = podYardCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param ctrRfaCd
	 */
	public void setCtrRfaCd(String ctrRfaCd) {
		this.ctrRfaCd = ctrRfaCd;
	}
	
	/**
	 * Column Info
	 * @param lOfcCd
	 */
	public void setLOfcCd(String lOfcCd) {
		this.lOfcCd = lOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cargoTpF
	 */
	public void setCargoTpF(String cargoTpF) {
		this.cargoTpF = cargoTpF;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdF
	 */
	public void setBkgStsCdF(String bkgStsCdF) {
		this.bkgStsCdF = bkgStsCdF;
	}
	
	/**
	 * Column Info
	 * @param fvPrePstCd
	 */
	public void setFvPrePstCd(String fvPrePstCd) {
		this.fvPrePstCd = fvPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param trunkFlag
	 */
	public void setTrunkFlag(String trunkFlag) {
		this.trunkFlag = trunkFlag;
	}
	
	/**
	 * Column Info
	 * @param sRouteOri
	 */
	public void setSRouteOri(String sRouteOri) {
		this.sRouteOri = sRouteOri;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdA
	 */
	public void setBkgStsCdA(String bkgStsCdA) {
		this.bkgStsCdA = bkgStsCdA;
	}
	
	/**
	 * Column Info
	 * @param spCargoAk
	 */
	public void setSpCargoAk(String spCargoAk) {
		this.spCargoAk = spCargoAk;
	}
	
	/**
	 * Column Info
	 * @param certiC
	 */
	public void setCertiC(String certiC) {
		this.certiC = certiC;
	}
	
	/**
	 * Column Info
	 * @param cOfcCd
	 */
	public void setCOfcCd(String cOfcCd) {
		this.cOfcCd = cOfcCd;
	}
	
	/**
	 * Column Info
	 * @param certiD
	 */
	public void setCertiD(String certiD) {
		this.certiD = certiD;
	}
	
	/**
	 * Column Info
	 * @param agentCd
	 */
	public void setAgentCd(String agentCd) {
		this.agentCd = agentCd;
	}
	
	/**
	 * Column Info
	 * @param cargoTpR
	 */
	public void setCargoTpR(String cargoTpR) {
		this.cargoTpR = cargoTpR;
	}
	
	/**
	 * Column Info
	 * @param certiA
	 */
	public void setCertiA(String certiA) {
		this.certiA = certiA;
	}
	
	/**
	 * Column Info
	 * @param orderby
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	
	/**
	 * Column Info
	 * @param certiB
	 */
	public void setCertiB(String certiB) {
		this.certiB = certiB;
	}
	
	/**
	 * Column Info
	 * @param cargoTpP
	 */
	public void setCargoTpP(String cargoTpP) {
		this.cargoTpP = cargoTpP;
	}
	
	/**
	 * Column Info
	 * @param nonSpCargo
	 */
	public void setNonSpCargo(String nonSpCargo) {
		this.nonSpCargo = nonSpCargo;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param fvPodLocal
	 */
	public void setFvPodLocal(String fvPodLocal) {
		this.fvPodLocal = fvPodLocal;
	}
	
	/**
	 * Column Info
	 * @param blTypeS
	 */
	public void setBlTypeS(String blTypeS) {
		this.blTypeS = blTypeS;
	}
	
	/**
	 * Column Info
	 * @param wgtTo
	 */
	public void setWgtTo(String wgtTo) {
		this.wgtTo = wgtTo;
	}
	
	/**
	 * Column Info
	 * @param pReportType
	 */
	public void setPReportType(String pReportType) {
		this.pReportType = pReportType;
	}
	
	/**
	 * Column Info
	 * @param aesY
	 */
	public void setAesY(String aesY) {
		this.aesY = aesY;
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
	 * @param spCargoEq
	 */
	public void setSpCargoEq(String spCargoEq) {
		this.spCargoEq = spCargoEq;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param orderbyTitle
	 */
	public void setOrderbyTitle(String orderbyTitle) {
		this.orderbyTitle = orderbyTitle;
	}
	
	/**
	 * Column Info
	 * @param polTs
	 */
	public void setPolTs(String polTs) {
		this.polTs = polTs;
	}
	
	/**
	 * Column Info
	 * @param custTpCdS
	 */
	public void setCustTpCdS(String custTpCdS) {
		this.custTpCdS = custTpCdS;
	}
	
	/**
	 * Column Info
	 * @param caFlag
	 */
	public void setCaFlag(String caFlag) {
		this.caFlag = caFlag;
	}
	
	/**
	 * Column Info
	 * @param custTpCdN
	 */
	public void setCustTpCdN(String custTpCdN) {
		this.custTpCdN = custTpCdN;
	}
	
	/**
	 * Column Info
	 * @param custTpCdF
	 */
	public void setCustTpCdF(String custTpCdF) {
		this.custTpCdF = custTpCdF;
	}
	
	/**
	 * Column Info
	 * @param custTpCdG
	 */
	public void setCustTpCdG(String custTpCdG) {
		this.custTpCdG = custTpCdG;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custTpCdC
	 */
	public void setCustTpCdC(String custTpCdC) {
		this.custTpCdC = custTpCdC;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Column Info
	 * @param custTpCdA
	 */
	public void setCustTpCdA(String custTpCdA) {
		this.custTpCdA = custTpCdA;
	}
	
	/**
	 * Column Info
	 * @param blTypeA
	 */
	public void setBlTypeA(String blTypeA) {
		this.blTypeA = blTypeA;
	}
	
	/**
	 * Column Info
	 * @param aesN
	 */
	public void setAesN(String aesN) {
		this.aesN = aesN;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	
	/**
	 * Column Info
	 * @param spCargoDg
	 */
	public void setSpCargoDg(String spCargoDg) {
		this.spCargoDg = spCargoDg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgentCdAll(JSPUtil.getParameter(request, "agent_cd_all", ""));
		setNonRev(JSPUtil.getParameter(request, "non_rev", ""));
		setHolding(JSPUtil.getParameter(request, "holding", ""));
		setSpCargoHd(JSPUtil.getParameter(request, "sp_cargo_hd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSpCargoHg(JSPUtil.getParameter(request, "sp_cargo_hg", ""));
		setSpCargoPc(JSPUtil.getParameter(request, "sp_cargo_pc", ""));
		setRowsPerPage(JSPUtil.getParameter(request, "rows_per_page", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setFvVvdCd(JSPUtil.getParameter(request, "fv_vvd_cd", ""));
		setFvPolCd(JSPUtil.getParameter(request, "fv_pol_cd", ""));
		setFvPodYardCd(JSPUtil.getParameter(request, "fv_pod_yard_cd", ""));
		setBOfcCdSub(JSPUtil.getParameter(request, "b_ofc_cd_sub", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setSpCargoPm(JSPUtil.getParameter(request, "sp_cargo_pm", ""));
		setBOfcCd(JSPUtil.getParameter(request, "b_ofc_cd", ""));
		setBkgKind(JSPUtil.getParameter(request, "bkg_kind", ""));
		setOrderbyTitleSql(JSPUtil.getParameter(request, "orderby_title_sql", ""));
		setBoardFromDt(JSPUtil.getParameter(request, "board_from_dt", ""));
		setZoneCd(JSPUtil.getParameter(request, "zone_cd", ""));
		setBoardToDt(JSPUtil.getParameter(request, "board_to_dt", ""));
		setPGridType(JSPUtil.getParameter(request, "p_grid_type", ""));
		setSModeOri(JSPUtil.getParameter(request, "s_mode_ori", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSpCargoFg(JSPUtil.getParameter(request, "sp_cargo_fg", ""));
		setPodTs(JSPUtil.getParameter(request, "pod_ts", ""));
		setStopCargo(JSPUtil.getParameter(request, "stop_cargo", ""));
		setBStaffId(JSPUtil.getParameter(request, "b_staff_id", ""));
		setCaedY(JSPUtil.getParameter(request, "caed_y", ""));
		setCaedN(JSPUtil.getParameter(request, "caed_n", ""));
		setDeptCd(JSPUtil.getParameter(request, "dept_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setRoN(JSPUtil.getParameter(request, "ro_n", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCrnNoFlag(JSPUtil.getParameter(request, "crn_no_flag", ""));
		setSRouteDest(JSPUtil.getParameter(request, "s_route_dest", ""));
		setWgtFrom(JSPUtil.getParameter(request, "wgt_from", ""));
		setSpCargoRb(JSPUtil.getParameter(request, "sp_cargo_rb", ""));
		setRoY(JSPUtil.getParameter(request, "ro_y", ""));
		setSpCargoRf(JSPUtil.getParameter(request, "sp_cargo_rf", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setBkgToDt(JSPUtil.getParameter(request, "bkg_to_dt", ""));
		setPolLocal(JSPUtil.getParameter(request, "pol_local", ""));
		setSpCargoRd(JSPUtil.getParameter(request, "sp_cargo_rd", ""));
		setCRepId(JSPUtil.getParameter(request, "c_rep_id", ""));
		setCtrRfaNo(JSPUtil.getParameter(request, "ctr_rfa_no", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setCOfcCdSub(JSPUtil.getParameter(request, "c_ofc_cd_sub", ""));
		setDeliMode(JSPUtil.getParameter(request, "deli_mode", ""));
		setLOfcCdSub(JSPUtil.getParameter(request, "l_ofc_cd_sub", ""));
		setCertiChecks(JSPUtil.getParameter(request, "certi_checks", ""));
		setRdYn(JSPUtil.getParameter(request, "rd_yn", ""));
		setOrderbySelect(JSPUtil.getParameter(request, "orderby_select", ""));
		setSpCargoSoc(JSPUtil.getParameter(request, "sp_cargo_soc", ""));
		setPBkgRptKndCd(JSPUtil.getParameter(request, "p_bkg_rpt_knd_cd", ""));
		setFvPolLocal(JSPUtil.getParameter(request, "fv_pol_local", ""));
		setFvPodCd(JSPUtil.getParameter(request, "fv_pod_cd", ""));
		setPodLocal(JSPUtil.getParameter(request, "pod_local", ""));
		setLRepId(JSPUtil.getParameter(request, "l_rep_id", ""));
		setLastOrderby(JSPUtil.getParameter(request, "last_orderby", ""));
		setRTerm(JSPUtil.getParameter(request, "r_term", ""));
		setCertiG(JSPUtil.getParameter(request, "certi_g", ""));
		setSModeDest(JSPUtil.getParameter(request, "s_mode_dest", ""));
		setCertiN(JSPUtil.getParameter(request, "certi_n", ""));
		setFvPolYardCd(JSPUtil.getParameter(request, "fv_pol_yard_cd", ""));
		setCertiY(JSPUtil.getParameter(request, "certi_y", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCurrPage(JSPUtil.getParameter(request, "curr_page", ""));
		setPolYardCd(JSPUtil.getParameter(request, "pol_yard_cd", ""));
		setBkgStsCdW(JSPUtil.getParameter(request, "bkg_sts_cd_w", ""));
		setDTerm(JSPUtil.getParameter(request, "d_term", ""));
		setBkgStsCdX(JSPUtil.getParameter(request, "bkg_sts_cd_x", ""));
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setSpCargoBb(JSPUtil.getParameter(request, "sp_cargo_bb", ""));
		setPodYardCd(JSPUtil.getParameter(request, "pod_yard_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCtrRfaCd(JSPUtil.getParameter(request, "ctr_rfa_cd", ""));
		setLOfcCd(JSPUtil.getParameter(request, "l_ofc_cd", ""));
		setCargoTpF(JSPUtil.getParameter(request, "cargo_tp_f", ""));
		setBkgStsCdF(JSPUtil.getParameter(request, "bkg_sts_cd_f", ""));
		setFvPrePstCd(JSPUtil.getParameter(request, "fv_pre_pst_cd", ""));
		setTrunkFlag(JSPUtil.getParameter(request, "trunk_flag", ""));
		setSRouteOri(JSPUtil.getParameter(request, "s_route_ori", ""));
		setBkgStsCdA(JSPUtil.getParameter(request, "bkg_sts_cd_a", ""));
		setSpCargoAk(JSPUtil.getParameter(request, "sp_cargo_ak", ""));
		setCertiC(JSPUtil.getParameter(request, "certi_c", ""));
		setCOfcCd(JSPUtil.getParameter(request, "c_ofc_cd", ""));
		setCertiD(JSPUtil.getParameter(request, "certi_d", ""));
		setAgentCd(JSPUtil.getParameter(request, "agent_cd", ""));
		setCargoTpR(JSPUtil.getParameter(request, "cargo_tp_r", ""));
		setCertiA(JSPUtil.getParameter(request, "certi_a", ""));
		setOrderby(JSPUtil.getParameter(request, "orderby", ""));
		setCertiB(JSPUtil.getParameter(request, "certi_b", ""));
		setCargoTpP(JSPUtil.getParameter(request, "cargo_tp_p", ""));
		setNonSpCargo(JSPUtil.getParameter(request, "non_sp_cargo", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setFvPodLocal(JSPUtil.getParameter(request, "fv_pod_local", ""));
		setBlTypeS(JSPUtil.getParameter(request, "bl_type_s", ""));
		setWgtTo(JSPUtil.getParameter(request, "wgt_to", ""));
		setPReportType(JSPUtil.getParameter(request, "p_report_type", ""));
		setAesY(JSPUtil.getParameter(request, "aes_y", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpCargoEq(JSPUtil.getParameter(request, "sp_cargo_eq", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setOrderbyTitle(JSPUtil.getParameter(request, "orderby_title", ""));
		setPolTs(JSPUtil.getParameter(request, "pol_ts", ""));
		setCustTpCdS(JSPUtil.getParameter(request, "cust_tp_cd_s", ""));
		setCaFlag(JSPUtil.getParameter(request, "ca_flag", ""));
		setCustTpCdN(JSPUtil.getParameter(request, "cust_tp_cd_n", ""));
		setCustTpCdF(JSPUtil.getParameter(request, "cust_tp_cd_f", ""));
		setCustTpCdG(JSPUtil.getParameter(request, "cust_tp_cd_g", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustTpCdC(JSPUtil.getParameter(request, "cust_tp_cd_c", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setCustTpCdA(JSPUtil.getParameter(request, "cust_tp_cd_a", ""));
		setBlTypeA(JSPUtil.getParameter(request, "bl_type_a", ""));
		setAesN(JSPUtil.getParameter(request, "aes_n", ""));
		setBkgFromDt(JSPUtil.getParameter(request, "bkg_from_dt", ""));
		setSpCargoDg(JSPUtil.getParameter(request, "sp_cargo_dg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusReportInVO[]
	 */
	public StatusReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusReportInVO[]
	 */
	public StatusReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StatusReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agentCdAll = (JSPUtil.getParameter(request, prefix	+ "agent_cd_all", length));
			String[] nonRev = (JSPUtil.getParameter(request, prefix	+ "non_rev", length));
			String[] holding = (JSPUtil.getParameter(request, prefix	+ "holding", length));
			String[] spCargoHd = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_hd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spCargoHg = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_hg", length));
			String[] spCargoPc = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_pc", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] fvVvdCd = (JSPUtil.getParameter(request, prefix	+ "fv_vvd_cd", length));
			String[] fvPolCd = (JSPUtil.getParameter(request, prefix	+ "fv_pol_cd", length));
			String[] fvPodYardCd = (JSPUtil.getParameter(request, prefix	+ "fv_pod_yard_cd", length));
			String[] bOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd_sub", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] spCargoPm = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_pm", length));
			String[] bOfcCd = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd", length));
			String[] bkgKind = (JSPUtil.getParameter(request, prefix	+ "bkg_kind", length));
			String[] orderbyTitleSql = (JSPUtil.getParameter(request, prefix	+ "orderby_title_sql", length));
			String[] boardFromDt = (JSPUtil.getParameter(request, prefix	+ "board_from_dt", length));
			String[] zoneCd = (JSPUtil.getParameter(request, prefix	+ "zone_cd", length));
			String[] boardToDt = (JSPUtil.getParameter(request, prefix	+ "board_to_dt", length));
			String[] pGridType = (JSPUtil.getParameter(request, prefix	+ "p_grid_type", length));
			String[] sModeOri = (JSPUtil.getParameter(request, prefix	+ "s_mode_ori", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] spCargoFg = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_fg", length));
			String[] podTs = (JSPUtil.getParameter(request, prefix	+ "pod_ts", length));
			String[] stopCargo = (JSPUtil.getParameter(request, prefix	+ "stop_cargo", length));
			String[] bStaffId = (JSPUtil.getParameter(request, prefix	+ "b_staff_id", length));
			String[] caedY = (JSPUtil.getParameter(request, prefix	+ "caed_y", length));
			String[] caedN = (JSPUtil.getParameter(request, prefix	+ "caed_n", length));
			String[] deptCd = (JSPUtil.getParameter(request, prefix	+ "dept_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] roN = (JSPUtil.getParameter(request, prefix	+ "ro_n", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] crnNoFlag = (JSPUtil.getParameter(request, prefix	+ "crn_no_flag", length));
			String[] sRouteDest = (JSPUtil.getParameter(request, prefix	+ "s_route_dest", length));
			String[] wgtFrom = (JSPUtil.getParameter(request, prefix	+ "wgt_from", length));
			String[] spCargoRb = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rb", length));
			String[] roY = (JSPUtil.getParameter(request, prefix	+ "ro_y", length));
			String[] spCargoRf = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rf", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] polLocal = (JSPUtil.getParameter(request, prefix	+ "pol_local", length));
			String[] spCargoRd = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rd", length));
			String[] cRepId = (JSPUtil.getParameter(request, prefix	+ "c_rep_id", length));
			String[] ctrRfaNo = (JSPUtil.getParameter(request, prefix	+ "ctr_rfa_no", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] cOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "c_ofc_cd_sub", length));
			String[] deliMode = (JSPUtil.getParameter(request, prefix	+ "deli_mode", length));
			String[] lOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "l_ofc_cd_sub", length));
			String[] certiChecks = (JSPUtil.getParameter(request, prefix	+ "certi_checks", length));
			String[] rdYn = (JSPUtil.getParameter(request, prefix	+ "rd_yn", length));
			String[] orderbySelect = (JSPUtil.getParameter(request, prefix	+ "orderby_select", length));
			String[] spCargoSoc = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_soc", length));
			String[] pBkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "p_bkg_rpt_knd_cd", length));
			String[] fvPolLocal = (JSPUtil.getParameter(request, prefix	+ "fv_pol_local", length));
			String[] fvPodCd = (JSPUtil.getParameter(request, prefix	+ "fv_pod_cd", length));
			String[] podLocal = (JSPUtil.getParameter(request, prefix	+ "pod_local", length));
			String[] lRepId = (JSPUtil.getParameter(request, prefix	+ "l_rep_id", length));
			String[] lastOrderby = (JSPUtil.getParameter(request, prefix	+ "last_orderby", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			String[] certiG = (JSPUtil.getParameter(request, prefix	+ "certi_g", length));
			String[] sModeDest = (JSPUtil.getParameter(request, prefix	+ "s_mode_dest", length));
			String[] certiN = (JSPUtil.getParameter(request, prefix	+ "certi_n", length));
			String[] fvPolYardCd = (JSPUtil.getParameter(request, prefix	+ "fv_pol_yard_cd", length));
			String[] certiY = (JSPUtil.getParameter(request, prefix	+ "certi_y", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] polYardCd = (JSPUtil.getParameter(request, prefix	+ "pol_yard_cd", length));
			String[] bkgStsCdW = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_w", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] bkgStsCdX = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_x", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] spCargoBb = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_bb", length));
			String[] podYardCd = (JSPUtil.getParameter(request, prefix	+ "pod_yard_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ctrRfaCd = (JSPUtil.getParameter(request, prefix	+ "ctr_rfa_cd", length));
			String[] lOfcCd = (JSPUtil.getParameter(request, prefix	+ "l_ofc_cd", length));
			String[] cargoTpF = (JSPUtil.getParameter(request, prefix	+ "cargo_tp_f", length));
			String[] bkgStsCdF = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_f", length));
			String[] fvPrePstCd = (JSPUtil.getParameter(request, prefix	+ "fv_pre_pst_cd", length));
			String[] trunkFlag = (JSPUtil.getParameter(request, prefix	+ "trunk_flag", length));
			String[] sRouteOri = (JSPUtil.getParameter(request, prefix	+ "s_route_ori", length));
			String[] bkgStsCdA = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_a", length));
			String[] spCargoAk = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_ak", length));
			String[] certiC = (JSPUtil.getParameter(request, prefix	+ "certi_c", length));
			String[] cOfcCd = (JSPUtil.getParameter(request, prefix	+ "c_ofc_cd", length));
			String[] certiD = (JSPUtil.getParameter(request, prefix	+ "certi_d", length));
			String[] agentCd = (JSPUtil.getParameter(request, prefix	+ "agent_cd", length));
			String[] cargoTpR = (JSPUtil.getParameter(request, prefix	+ "cargo_tp_r", length));
			String[] certiA = (JSPUtil.getParameter(request, prefix	+ "certi_a", length));
			String[] orderby = (JSPUtil.getParameter(request, prefix	+ "orderby", length));
			String[] certiB = (JSPUtil.getParameter(request, prefix	+ "certi_b", length));
			String[] cargoTpP = (JSPUtil.getParameter(request, prefix	+ "cargo_tp_p", length));
			String[] nonSpCargo = (JSPUtil.getParameter(request, prefix	+ "non_sp_cargo", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fvPodLocal = (JSPUtil.getParameter(request, prefix	+ "fv_pod_local", length));
			String[] blTypeS = (JSPUtil.getParameter(request, prefix	+ "bl_type_s", length));
			String[] wgtTo = (JSPUtil.getParameter(request, prefix	+ "wgt_to", length));
			String[] pReportType = (JSPUtil.getParameter(request, prefix	+ "p_report_type", length));
			String[] aesY = (JSPUtil.getParameter(request, prefix	+ "aes_y", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spCargoEq = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_eq", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] orderbyTitle = (JSPUtil.getParameter(request, prefix	+ "orderby_title", length));
			String[] polTs = (JSPUtil.getParameter(request, prefix	+ "pol_ts", length));
			String[] custTpCdS = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_s", length));
			String[] caFlag = (JSPUtil.getParameter(request, prefix	+ "ca_flag", length));
			String[] custTpCdN = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_n", length));
			String[] custTpCdF = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_f", length));
			String[] custTpCdG = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_g", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custTpCdC = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_c", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] custTpCdA = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_a", length));
			String[] blTypeA = (JSPUtil.getParameter(request, prefix	+ "bl_type_a", length));
			String[] aesN = (JSPUtil.getParameter(request, prefix	+ "aes_n", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] spCargoDg = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_dg", length));
			
			for (int i = 0; i < length; i++) {
				model = new StatusReportInVO();
				if (agentCdAll[i] != null)
					model.setAgentCdAll(agentCdAll[i]);
				if (nonRev[i] != null)
					model.setNonRev(nonRev[i]);
				if (holding[i] != null)
					model.setHolding(holding[i]);
				if (spCargoHd[i] != null)
					model.setSpCargoHd(spCargoHd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spCargoHg[i] != null)
					model.setSpCargoHg(spCargoHg[i]);
				if (spCargoPc[i] != null)
					model.setSpCargoPc(spCargoPc[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (fvVvdCd[i] != null)
					model.setFvVvdCd(fvVvdCd[i]);
				if (fvPolCd[i] != null)
					model.setFvPolCd(fvPolCd[i]);
				if (fvPodYardCd[i] != null)
					model.setFvPodYardCd(fvPodYardCd[i]);
				if (bOfcCdSub[i] != null)
					model.setBOfcCdSub(bOfcCdSub[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (spCargoPm[i] != null)
					model.setSpCargoPm(spCargoPm[i]);
				if (bOfcCd[i] != null)
					model.setBOfcCd(bOfcCd[i]);
				if (bkgKind[i] != null)
					model.setBkgKind(bkgKind[i]);
				if (orderbyTitleSql[i] != null)
					model.setOrderbyTitleSql(orderbyTitleSql[i]);
				if (boardFromDt[i] != null)
					model.setBoardFromDt(boardFromDt[i]);
				if (zoneCd[i] != null)
					model.setZoneCd(zoneCd[i]);
				if (boardToDt[i] != null)
					model.setBoardToDt(boardToDt[i]);
				if (pGridType[i] != null)
					model.setPGridType(pGridType[i]);
				if (sModeOri[i] != null)
					model.setSModeOri(sModeOri[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (spCargoFg[i] != null)
					model.setSpCargoFg(spCargoFg[i]);
				if (podTs[i] != null)
					model.setPodTs(podTs[i]);
				if (stopCargo[i] != null)
					model.setStopCargo(stopCargo[i]);
				if (bStaffId[i] != null)
					model.setBStaffId(bStaffId[i]);
				if (caedY[i] != null)
					model.setCaedY(caedY[i]);
				if (caedN[i] != null)
					model.setCaedN(caedN[i]);
				if (deptCd[i] != null)
					model.setDeptCd(deptCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (roN[i] != null)
					model.setRoN(roN[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (crnNoFlag[i] != null)
					model.setCrnNoFlag(crnNoFlag[i]);
				if (sRouteDest[i] != null)
					model.setSRouteDest(sRouteDest[i]);
				if (wgtFrom[i] != null)
					model.setWgtFrom(wgtFrom[i]);
				if (spCargoRb[i] != null)
					model.setSpCargoRb(spCargoRb[i]);
				if (roY[i] != null)
					model.setRoY(roY[i]);
				if (spCargoRf[i] != null)
					model.setSpCargoRf(spCargoRf[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (polLocal[i] != null)
					model.setPolLocal(polLocal[i]);
				if (spCargoRd[i] != null)
					model.setSpCargoRd(spCargoRd[i]);
				if (cRepId[i] != null)
					model.setCRepId(cRepId[i]);
				if (ctrRfaNo[i] != null)
					model.setCtrRfaNo(ctrRfaNo[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (cOfcCdSub[i] != null)
					model.setCOfcCdSub(cOfcCdSub[i]);
				if (deliMode[i] != null)
					model.setDeliMode(deliMode[i]);
				if (lOfcCdSub[i] != null)
					model.setLOfcCdSub(lOfcCdSub[i]);
				if (certiChecks[i] != null)
					model.setCertiChecks(certiChecks[i]);
				if (rdYn[i] != null)
					model.setRdYn(rdYn[i]);
				if (orderbySelect[i] != null)
					model.setOrderbySelect(orderbySelect[i]);
				if (spCargoSoc[i] != null)
					model.setSpCargoSoc(spCargoSoc[i]);
				if (pBkgRptKndCd[i] != null)
					model.setPBkgRptKndCd(pBkgRptKndCd[i]);
				if (fvPolLocal[i] != null)
					model.setFvPolLocal(fvPolLocal[i]);
				if (fvPodCd[i] != null)
					model.setFvPodCd(fvPodCd[i]);
				if (podLocal[i] != null)
					model.setPodLocal(podLocal[i]);
				if (lRepId[i] != null)
					model.setLRepId(lRepId[i]);
				if (lastOrderby[i] != null)
					model.setLastOrderby(lastOrderby[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				if (certiG[i] != null)
					model.setCertiG(certiG[i]);
				if (sModeDest[i] != null)
					model.setSModeDest(sModeDest[i]);
				if (certiN[i] != null)
					model.setCertiN(certiN[i]);
				if (fvPolYardCd[i] != null)
					model.setFvPolYardCd(fvPolYardCd[i]);
				if (certiY[i] != null)
					model.setCertiY(certiY[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (polYardCd[i] != null)
					model.setPolYardCd(polYardCd[i]);
				if (bkgStsCdW[i] != null)
					model.setBkgStsCdW(bkgStsCdW[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (bkgStsCdX[i] != null)
					model.setBkgStsCdX(bkgStsCdX[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (spCargoBb[i] != null)
					model.setSpCargoBb(spCargoBb[i]);
				if (podYardCd[i] != null)
					model.setPodYardCd(podYardCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ctrRfaCd[i] != null)
					model.setCtrRfaCd(ctrRfaCd[i]);
				if (lOfcCd[i] != null)
					model.setLOfcCd(lOfcCd[i]);
				if (cargoTpF[i] != null)
					model.setCargoTpF(cargoTpF[i]);
				if (bkgStsCdF[i] != null)
					model.setBkgStsCdF(bkgStsCdF[i]);
				if (fvPrePstCd[i] != null)
					model.setFvPrePstCd(fvPrePstCd[i]);
				if (trunkFlag[i] != null)
					model.setTrunkFlag(trunkFlag[i]);
				if (sRouteOri[i] != null)
					model.setSRouteOri(sRouteOri[i]);
				if (bkgStsCdA[i] != null)
					model.setBkgStsCdA(bkgStsCdA[i]);
				if (spCargoAk[i] != null)
					model.setSpCargoAk(spCargoAk[i]);
				if (certiC[i] != null)
					model.setCertiC(certiC[i]);
				if (cOfcCd[i] != null)
					model.setCOfcCd(cOfcCd[i]);
				if (certiD[i] != null)
					model.setCertiD(certiD[i]);
				if (agentCd[i] != null)
					model.setAgentCd(agentCd[i]);
				if (cargoTpR[i] != null)
					model.setCargoTpR(cargoTpR[i]);
				if (certiA[i] != null)
					model.setCertiA(certiA[i]);
				if (orderby[i] != null)
					model.setOrderby(orderby[i]);
				if (certiB[i] != null)
					model.setCertiB(certiB[i]);
				if (cargoTpP[i] != null)
					model.setCargoTpP(cargoTpP[i]);
				if (nonSpCargo[i] != null)
					model.setNonSpCargo(nonSpCargo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fvPodLocal[i] != null)
					model.setFvPodLocal(fvPodLocal[i]);
				if (blTypeS[i] != null)
					model.setBlTypeS(blTypeS[i]);
				if (wgtTo[i] != null)
					model.setWgtTo(wgtTo[i]);
				if (pReportType[i] != null)
					model.setPReportType(pReportType[i]);
				if (aesY[i] != null)
					model.setAesY(aesY[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spCargoEq[i] != null)
					model.setSpCargoEq(spCargoEq[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (orderbyTitle[i] != null)
					model.setOrderbyTitle(orderbyTitle[i]);
				if (polTs[i] != null)
					model.setPolTs(polTs[i]);
				if (custTpCdS[i] != null)
					model.setCustTpCdS(custTpCdS[i]);
				if (caFlag[i] != null)
					model.setCaFlag(caFlag[i]);
				if (custTpCdN[i] != null)
					model.setCustTpCdN(custTpCdN[i]);
				if (custTpCdF[i] != null)
					model.setCustTpCdF(custTpCdF[i]);
				if (custTpCdG[i] != null)
					model.setCustTpCdG(custTpCdG[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custTpCdC[i] != null)
					model.setCustTpCdC(custTpCdC[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (custTpCdA[i] != null)
					model.setCustTpCdA(custTpCdA[i]);
				if (blTypeA[i] != null)
					model.setBlTypeA(blTypeA[i]);
				if (aesN[i] != null)
					model.setAesN(aesN[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (spCargoDg[i] != null)
					model.setSpCargoDg(spCargoDg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStatusReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StatusReportInVO[]
	 */
	public StatusReportInVO[] getStatusReportInVOs(){
		StatusReportInVO[] vos = (StatusReportInVO[])models.toArray(new StatusReportInVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.agentCdAll = this.agentCdAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonRev = this.nonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holding = this.holding .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoHd = this.spCargoHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoHg = this.spCargoHg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoPc = this.spCargoPc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvVvdCd = this.fvVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPolCd = this.fvPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPodYardCd = this.fvPodYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCdSub = this.bOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoPm = this.spCargoPm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCd = this.bOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKind = this.bkgKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbyTitleSql = this.orderbyTitleSql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardFromDt = this.boardFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneCd = this.zoneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardToDt = this.boardToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pGridType = this.pGridType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sModeOri = this.sModeOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoFg = this.spCargoFg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTs = this.podTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopCargo = this.stopCargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bStaffId = this.bStaffId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedY = this.caedY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedN = this.caedN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptCd = this.deptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roN = this.roN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnNoFlag = this.crnNoFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRouteDest = this.sRouteDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtFrom = this.wgtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRb = this.spCargoRb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roY = this.roY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRf = this.spCargoRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocal = this.polLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRd = this.spCargoRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cRepId = this.cRepId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrRfaNo = this.ctrRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOfcCdSub = this.cOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliMode = this.deliMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOfcCdSub = this.lOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiChecks = this.certiChecks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdYn = this.rdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbySelect = this.orderbySelect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoSoc = this.spCargoSoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgRptKndCd = this.pBkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPolLocal = this.fvPolLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPodCd = this.fvPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocal = this.podLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lRepId = this.lRepId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastOrderby = this.lastOrderby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiG = this.certiG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sModeDest = this.sModeDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiN = this.certiN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPolYardCd = this.fvPolYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiY = this.certiY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYardCd = this.polYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdW = this.bkgStsCdW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdX = this.bkgStsCdX .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoBb = this.spCargoBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYardCd = this.podYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrRfaCd = this.ctrRfaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lOfcCd = this.lOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoTpF = this.cargoTpF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdF = this.bkgStsCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPrePstCd = this.fvPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkFlag = this.trunkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRouteOri = this.sRouteOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdA = this.bkgStsCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoAk = this.spCargoAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiC = this.certiC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cOfcCd = this.cOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiD = this.certiD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agentCd = this.agentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoTpR = this.cargoTpR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiA = this.certiA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderby = this.orderby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiB = this.certiB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoTpP = this.cargoTpP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonSpCargo = this.nonSpCargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvPodLocal = this.fvPodLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeS = this.blTypeS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtTo = this.wgtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pReportType = this.pReportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesY = this.aesY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoEq = this.spCargoEq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbyTitle = this.orderbyTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTs = this.polTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdS = this.custTpCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlag = this.caFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdN = this.custTpCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdF = this.custTpCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdG = this.custTpCdG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdC = this.custTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdA = this.custTpCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeA = this.blTypeA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesN = this.aesN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoDg = this.spCargoDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
