/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BokCntrListInVO.java
*@FileTitle : BokCntrListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BokCntrListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BokCntrListInVO> models = new ArrayList<BokCntrListInVO>();
	
	/* Column Info */
	private String cgoWgtFrom = null;
	/* Column Info */
	private String holding = null;
	/* Column Info */
	private String cgoWgtTo = null;
	/* Column Info */
	private String wgtBndH = null;
	/* Column Info */
	private String wgtBndM = null;
	/* Column Info */
	private String wgtBndL = null;
	/* Column Info */
	private String cgoWgtLb = null;
	/* Column Info */
	private String spCargoHg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrStsCdTs = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String polYardCd = null;
	/* Column Info */
	private String grsWgtKg = null;
	/* Column Info */
	private String cntrStsCdTn = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgStsCdW = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String bOfcCdSub = null;
	/* Column Info */
	private String bkgStsCdX = null;
	/* Column Info */
	private String bOfcCd = null;
	/* Column Info */
	private String bkgKind = null;
	/* Column Info */
	private String orderbyTitleSql = null;
	/* Column Info */
	private String spCargoBb = null;
	/* Column Info */
	private String grsWgtTo = null;
	/* Column Info */
	private String boardFromDt = null;
	/* Column Info */
	private String podYardCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String boardToDt = null;
	/* Column Info */
	private String ctrRfaCd = null;
	/* Column Info */
	private String bkgStsCdF = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgStsCdA = null;
	/* Column Info */
	private String trunkFlag = null;
	/* Column Info */
	private String grsWgtLb = null;
	/* Column Info */
	private String spCargoAk = null;
	/* Column Info */
	private String podTs = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String bStaffId = null;
	/* Column Info */
	private String cgoWgtKg = null;
	/* Column Info */
	private String cntrStsCdOp = null;
	/* Column Info */
	private String orderby = null;
	/* Column Info */
	private String nonSpCargo = null;
	/* Column Info */
	private String wgtBndXh = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String cntrStsCdEn = null;
	/* Column Info */
	private String pReportType = null;
	/* Column Info */
	private String cntrStsCdOc = null;
	/* Column Info */
	private String blRlseOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spCargoRf = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String spCargoRd = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String polLocal = null;
	/* Column Info */
	private String ctrRfaNo = null;
	/* Column Info */
	private String cntrStsCdVs = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String cntrStsCdVl = null;
	/* Column Info */
	private String custTpCdS = null;
	/* Column Info */
	private String polTs = null;
	/* Column Info */
	private String caFlag = null;
	/* Column Info */
	private String custTpCdN = null;
	/* Column Info */
	private String cntrStsCdIc = null;
	/* Column Info */
	private String cntrStsCdId = null;
	/* Column Info */
	private String orderbySelect = null;
	/* Column Info */
	private String grsWgtFrom = null;
	/* Column Info */
	private String custTpCdF = null;
	/* Column Info */
	private String custTpCdG = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String pBkgRptKndCd = null;
	/* Column Info */
	private String custTpCdC = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String custTpCdA = null;
	/* Column Info */
	private String rateStsU = null;
	/* Column Info */
	private String rateStsR = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String podLocal = null;
	/* Column Info */
	private String lastOrderby = null;
	/* Column Info */
	private String spCargoDg = null;
	/* Column Info */
	private String cntrStsCdMt = null;
	/* Column Info */
	private String rTerm = null;
	/* Column Info */
	private String custGrpId = null;		//SJH.20150129.ADD	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BokCntrListInVO() {}

	public BokCntrListInVO(String ibflag, String pagerows, String pBkgRptKndCd, String pReportType, String vvdCd, String trunkFlag, String laneCd, String dirCd, String polCd, String polYardCd, String polLocal, String polTs, String podCd, String podYardCd, String podLocal, String podTs, String porCd, String delCd, String rTerm, String dTerm, String boardFromDt, String boardToDt, String bkgFromDt, String bkgToDt, String bkgKind, String bOfcCd, String bOfcCdSub, String bStaffId, String caFlag, String blRlseOfcCd, String eqType, String cmdtCd, String cgoWgtFrom, String cgoWgtTo, String cgoWgtKg, String cgoWgtLb, String grsWgtFrom, String grsWgtTo, String grsWgtKg, String grsWgtLb, String wgtBndXh, String wgtBndH, String wgtBndM, String wgtBndL, String ctrRfaCd, String ctrRfaNo, String bkgStsCdF, String bkgStsCdX, String bkgStsCdA, String bkgStsCdW, String nonSpCargo, String holding, String cntrStsCdEn, String cntrStsCdOp, String cntrStsCdIc, String cntrStsCdTn, String cntrStsCdId, String cntrStsCdTs, String cntrStsCdMt, String cntrStsCdVs, String cntrStsCdOc, String cntrStsCdVl, String rateStsR, String rateStsU, String custTpCdS, String custTpCdC, String custTpCdN, String custTpCdF, String custTpCdA, String custTpCdG, String custCntCd, String custSeq, String custNm, String custTpCd, String spCargoDg, String spCargoRf, String spCargoAk, String spCargoBb, String spCargoRd, String spCargoHg, String orderby, String lastOrderby, String orderbySelect, String orderbyTitleSql, String custGrpId, String rptId) {
		this.cgoWgtFrom = cgoWgtFrom;
		this.holding = holding;
		this.cgoWgtTo = cgoWgtTo;
		this.wgtBndH = wgtBndH;
		this.wgtBndM = wgtBndM;
		this.wgtBndL = wgtBndL;
		this.cgoWgtLb = cgoWgtLb;
		this.spCargoHg = spCargoHg;
		this.pagerows = pagerows;
		this.cntrStsCdTs = cntrStsCdTs;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.polYardCd = polYardCd;
		this.grsWgtKg = grsWgtKg;
		this.cntrStsCdTn = cntrStsCdTn;
		this.custCntCd = custCntCd;
		this.bkgStsCdW = bkgStsCdW;
		this.dTerm = dTerm;
		this.bOfcCdSub = bOfcCdSub;
		this.bkgStsCdX = bkgStsCdX;
		this.bOfcCd = bOfcCd;
		this.bkgKind = bkgKind;
		this.orderbyTitleSql = orderbyTitleSql;
		this.spCargoBb = spCargoBb;
		this.grsWgtTo = grsWgtTo;
		this.boardFromDt = boardFromDt;
		this.podYardCd = podYardCd;
		this.delCd = delCd;
		this.boardToDt = boardToDt;
		this.ctrRfaCd = ctrRfaCd;
		this.bkgStsCdF = bkgStsCdF;
		this.podCd = podCd;
		this.bkgStsCdA = bkgStsCdA;
		this.trunkFlag = trunkFlag;
		this.grsWgtLb = grsWgtLb;
		this.spCargoAk = spCargoAk;
		this.podTs = podTs;
		this.rptId = rptId;
		this.bStaffId = bStaffId;
		this.cgoWgtKg = cgoWgtKg;
		this.cntrStsCdOp = cntrStsCdOp;
		this.orderby = orderby;
		this.nonSpCargo = nonSpCargo;
		this.wgtBndXh = wgtBndXh;
		this.porCd = porCd;
		this.laneCd = laneCd;
		this.custNm = custNm;
		this.cntrStsCdEn = cntrStsCdEn;
		this.pReportType = pReportType;
		this.cntrStsCdOc = cntrStsCdOc;
		this.blRlseOfcCd = blRlseOfcCd;
		this.ibflag = ibflag;
		this.spCargoRf = spCargoRf;
		this.cmdtCd = cmdtCd;
		this.spCargoRd = spCargoRd;
		this.bkgToDt = bkgToDt;
		this.polLocal = polLocal;
		this.ctrRfaNo = ctrRfaNo;
		this.cntrStsCdVs = cntrStsCdVs;
		this.dirCd = dirCd;
		this.custTpCd = custTpCd;
		this.cntrStsCdVl = cntrStsCdVl;
		this.custTpCdS = custTpCdS;
		this.polTs = polTs;
		this.caFlag = caFlag;
		this.custTpCdN = custTpCdN;
		this.cntrStsCdIc = cntrStsCdIc;
		this.cntrStsCdId = cntrStsCdId;
		this.orderbySelect = orderbySelect;
		this.grsWgtFrom = grsWgtFrom;
		this.custTpCdF = custTpCdF;
		this.custTpCdG = custTpCdG;
		this.custSeq = custSeq;
		this.pBkgRptKndCd = pBkgRptKndCd;
		this.custTpCdC = custTpCdC;
		this.eqType = eqType;
		this.custTpCdA = custTpCdA;
		this.rateStsU = rateStsU;
		this.rateStsR = rateStsR;
		this.bkgFromDt = bkgFromDt;
		this.podLocal = podLocal;
		this.lastOrderby = lastOrderby;
		this.spCargoDg = spCargoDg;
		this.cntrStsCdMt = cntrStsCdMt;
		this.rTerm = rTerm;
		this.custGrpId = custGrpId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_wgt_from", getCgoWgtFrom());
		this.hashColumns.put("holding", getHolding());
		this.hashColumns.put("cgo_wgt_to", getCgoWgtTo());
		this.hashColumns.put("wgt_bnd_h", getWgtBndH());
		this.hashColumns.put("wgt_bnd_m", getWgtBndM());
		this.hashColumns.put("wgt_bnd_l", getWgtBndL());
		this.hashColumns.put("cgo_wgt_lb", getCgoWgtLb());
		this.hashColumns.put("sp_cargo_hg", getSpCargoHg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_sts_cd_ts", getCntrStsCdTs());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol_yard_cd", getPolYardCd());
		this.hashColumns.put("grs_wgt_kg", getGrsWgtKg());
		this.hashColumns.put("cntr_sts_cd_tn", getCntrStsCdTn());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_sts_cd_w", getBkgStsCdW());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("b_ofc_cd_sub", getBOfcCdSub());
		this.hashColumns.put("bkg_sts_cd_x", getBkgStsCdX());
		this.hashColumns.put("b_ofc_cd", getBOfcCd());
		this.hashColumns.put("bkg_kind", getBkgKind());
		this.hashColumns.put("orderby_title_sql", getOrderbyTitleSql());
		this.hashColumns.put("sp_cargo_bb", getSpCargoBb());
		this.hashColumns.put("grs_wgt_to", getGrsWgtTo());
		this.hashColumns.put("board_from_dt", getBoardFromDt());
		this.hashColumns.put("pod_yard_cd", getPodYardCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("board_to_dt", getBoardToDt());
		this.hashColumns.put("ctr_rfa_cd", getCtrRfaCd());
		this.hashColumns.put("bkg_sts_cd_f", getBkgStsCdF());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_sts_cd_a", getBkgStsCdA());
		this.hashColumns.put("trunk_flag", getTrunkFlag());
		this.hashColumns.put("grs_wgt_lb", getGrsWgtLb());
		this.hashColumns.put("sp_cargo_ak", getSpCargoAk());
		this.hashColumns.put("pod_ts", getPodTs());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("b_staff_id", getBStaffId());
		this.hashColumns.put("cgo_wgt_kg", getCgoWgtKg());
		this.hashColumns.put("cntr_sts_cd_op", getCntrStsCdOp());
		this.hashColumns.put("orderby", getOrderby());
		this.hashColumns.put("non_sp_cargo", getNonSpCargo());
		this.hashColumns.put("wgt_bnd_xh", getWgtBndXh());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cntr_sts_cd_en", getCntrStsCdEn());
		this.hashColumns.put("p_report_type", getPReportType());
		this.hashColumns.put("cntr_sts_cd_oc", getCntrStsCdOc());
		this.hashColumns.put("bl_rlse_ofc_cd", getBlRlseOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sp_cargo_rf", getSpCargoRf());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sp_cargo_rd", getSpCargoRd());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("pol_local", getPolLocal());
		this.hashColumns.put("ctr_rfa_no", getCtrRfaNo());
		this.hashColumns.put("cntr_sts_cd_vs", getCntrStsCdVs());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cntr_sts_cd_vl", getCntrStsCdVl());
		this.hashColumns.put("cust_tp_cd_s", getCustTpCdS());
		this.hashColumns.put("pol_ts", getPolTs());
		this.hashColumns.put("ca_flag", getCaFlag());
		this.hashColumns.put("cust_tp_cd_n", getCustTpCdN());
		this.hashColumns.put("cntr_sts_cd_ic", getCntrStsCdIc());
		this.hashColumns.put("cntr_sts_cd_id", getCntrStsCdId());
		this.hashColumns.put("orderby_select", getOrderbySelect());
		this.hashColumns.put("grs_wgt_from", getGrsWgtFrom());
		this.hashColumns.put("cust_tp_cd_f", getCustTpCdF());
		this.hashColumns.put("cust_tp_cd_g", getCustTpCdG());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("p_bkg_rpt_knd_cd", getPBkgRptKndCd());
		this.hashColumns.put("cust_tp_cd_c", getCustTpCdC());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("cust_tp_cd_a", getCustTpCdA());
		this.hashColumns.put("rate_sts_u", getRateStsU());
		this.hashColumns.put("rate_sts_r", getRateStsR());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("pod_local", getPodLocal());
		this.hashColumns.put("last_orderby", getLastOrderby());
		this.hashColumns.put("sp_cargo_dg", getSpCargoDg());
		this.hashColumns.put("cntr_sts_cd_mt", getCntrStsCdMt());
		this.hashColumns.put("r_term", getRTerm());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_wgt_from", "cgoWgtFrom");
		this.hashFields.put("holding", "holding");
		this.hashFields.put("cgo_wgt_to", "cgoWgtTo");
		this.hashFields.put("wgt_bnd_h", "wgtBndH");
		this.hashFields.put("wgt_bnd_m", "wgtBndM");
		this.hashFields.put("wgt_bnd_l", "wgtBndL");
		this.hashFields.put("cgo_wgt_lb", "cgoWgtLb");
		this.hashFields.put("sp_cargo_hg", "spCargoHg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_sts_cd_ts", "cntrStsCdTs");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_yard_cd", "polYardCd");
		this.hashFields.put("grs_wgt_kg", "grsWgtKg");
		this.hashFields.put("cntr_sts_cd_tn", "cntrStsCdTn");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_sts_cd_w", "bkgStsCdW");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("b_ofc_cd_sub", "bOfcCdSub");
		this.hashFields.put("bkg_sts_cd_x", "bkgStsCdX");
		this.hashFields.put("b_ofc_cd", "bOfcCd");
		this.hashFields.put("bkg_kind", "bkgKind");
		this.hashFields.put("orderby_title_sql", "orderbyTitleSql");
		this.hashFields.put("sp_cargo_bb", "spCargoBb");
		this.hashFields.put("grs_wgt_to", "grsWgtTo");
		this.hashFields.put("board_from_dt", "boardFromDt");
		this.hashFields.put("pod_yard_cd", "podYardCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("board_to_dt", "boardToDt");
		this.hashFields.put("ctr_rfa_cd", "ctrRfaCd");
		this.hashFields.put("bkg_sts_cd_f", "bkgStsCdF");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_sts_cd_a", "bkgStsCdA");
		this.hashFields.put("trunk_flag", "trunkFlag");
		this.hashFields.put("grs_wgt_lb", "grsWgtLb");
		this.hashFields.put("sp_cargo_ak", "spCargoAk");
		this.hashFields.put("pod_ts", "podTs");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("b_staff_id", "bStaffId");
		this.hashFields.put("cgo_wgt_kg", "cgoWgtKg");
		this.hashFields.put("cntr_sts_cd_op", "cntrStsCdOp");
		this.hashFields.put("orderby", "orderby");
		this.hashFields.put("non_sp_cargo", "nonSpCargo");
		this.hashFields.put("wgt_bnd_xh", "wgtBndXh");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cntr_sts_cd_en", "cntrStsCdEn");
		this.hashFields.put("p_report_type", "pReportType");
		this.hashFields.put("cntr_sts_cd_oc", "cntrStsCdOc");
		this.hashFields.put("bl_rlse_ofc_cd", "blRlseOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_cargo_rf", "spCargoRf");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sp_cargo_rd", "spCargoRd");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("pol_local", "polLocal");
		this.hashFields.put("ctr_rfa_no", "ctrRfaNo");
		this.hashFields.put("cntr_sts_cd_vs", "cntrStsCdVs");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("cntr_sts_cd_vl", "cntrStsCdVl");
		this.hashFields.put("cust_tp_cd_s", "custTpCdS");
		this.hashFields.put("pol_ts", "polTs");
		this.hashFields.put("ca_flag", "caFlag");
		this.hashFields.put("cust_tp_cd_n", "custTpCdN");
		this.hashFields.put("cntr_sts_cd_ic", "cntrStsCdIc");
		this.hashFields.put("cntr_sts_cd_id", "cntrStsCdId");
		this.hashFields.put("orderby_select", "orderbySelect");
		this.hashFields.put("grs_wgt_from", "grsWgtFrom");
		this.hashFields.put("cust_tp_cd_f", "custTpCdF");
		this.hashFields.put("cust_tp_cd_g", "custTpCdG");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("p_bkg_rpt_knd_cd", "pBkgRptKndCd");
		this.hashFields.put("cust_tp_cd_c", "custTpCdC");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("cust_tp_cd_a", "custTpCdA");
		this.hashFields.put("rate_sts_u", "rateStsU");
		this.hashFields.put("rate_sts_r", "rateStsR");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("pod_local", "podLocal");
		this.hashFields.put("last_orderby", "lastOrderby");
		this.hashFields.put("sp_cargo_dg", "spCargoDg");
		this.hashFields.put("cntr_sts_cd_mt", "cntrStsCdMt");
		this.hashFields.put("r_term", "rTerm");
		this.hashFields.put("cust_grp_id", "custGrpId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoWgtFrom
	 */
	public String getCgoWgtFrom() {
		return this.cgoWgtFrom;
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
	 * @return cgoWgtTo
	 */
	public String getCgoWgtTo() {
		return this.cgoWgtTo;
	}
	
	/**
	 * Column Info
	 * @return wgtBndH
	 */
	public String getWgtBndH() {
		return this.wgtBndH;
	}
	
	/**
	 * Column Info
	 * @return wgtBndM
	 */
	public String getWgtBndM() {
		return this.wgtBndM;
	}
	
	/**
	 * Column Info
	 * @return wgtBndL
	 */
	public String getWgtBndL() {
		return this.wgtBndL;
	}
	
	/**
	 * Column Info
	 * @return cgoWgtLb
	 */
	public String getCgoWgtLb() {
		return this.cgoWgtLb;
	}
	
	/**
	 * Column Info
	 * @return spCargoHg
	 */
	public String getSpCargoHg() {
		return this.spCargoHg;
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
	 * @return cntrStsCdTs
	 */
	public String getCntrStsCdTs() {
		return this.cntrStsCdTs;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return grsWgtKg
	 */
	public String getGrsWgtKg() {
		return this.grsWgtKg;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCdTn
	 */
	public String getCntrStsCdTn() {
		return this.cntrStsCdTn;
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
	 * @return bOfcCdSub
	 */
	public String getBOfcCdSub() {
		return this.bOfcCdSub;
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
	 * @return spCargoBb
	 */
	public String getSpCargoBb() {
		return this.spCargoBb;
	}
	
	/**
	 * Column Info
	 * @return grsWgtTo
	 */
	public String getGrsWgtTo() {
		return this.grsWgtTo;
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
	 * @return boardToDt
	 */
	public String getBoardToDt() {
		return this.boardToDt;
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
	 * @return bkgStsCdF
	 */
	public String getBkgStsCdF() {
		return this.bkgStsCdF;
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
	 * @return bkgStsCdA
	 */
	public String getBkgStsCdA() {
		return this.bkgStsCdA;
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
	 * @return grsWgtLb
	 */
	public String getGrsWgtLb() {
		return this.grsWgtLb;
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
	 * @return podTs
	 */
	public String getPodTs() {
		return this.podTs;
	}
	
	/**
	 * Column Info
	 * @return rptId
	 */
	public String getRptId() {
		return this.rptId;
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
	 * @return cgoWgtKg
	 */
	public String getCgoWgtKg() {
		return this.cgoWgtKg;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCdOp
	 */
	public String getCntrStsCdOp() {
		return this.cntrStsCdOp;
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
	 * @return nonSpCargo
	 */
	public String getNonSpCargo() {
		return this.nonSpCargo;
	}
	
	/**
	 * Column Info
	 * @return wgtBndXh
	 */
	public String getWgtBndXh() {
		return this.wgtBndXh;
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
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return cntrStsCdEn
	 */
	public String getCntrStsCdEn() {
		return this.cntrStsCdEn;
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
	 * @return cntrStsCdOc
	 */
	public String getCntrStsCdOc() {
		return this.cntrStsCdOc;
	}
	
	/**
	 * Column Info
	 * @return blRlseOfcCd
	 */
	public String getBlRlseOfcCd() {
		return this.blRlseOfcCd;
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
	 * @return spCargoRd
	 */
	public String getSpCargoRd() {
		return this.spCargoRd;
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
	 * @return ctrRfaNo
	 */
	public String getCtrRfaNo() {
		return this.ctrRfaNo;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCdVs
	 */
	public String getCntrStsCdVs() {
		return this.cntrStsCdVs;
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
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCdVl
	 */
	public String getCntrStsCdVl() {
		return this.cntrStsCdVl;
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
	 * @return polTs
	 */
	public String getPolTs() {
		return this.polTs;
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
	 * @return cntrStsCdIc
	 */
	public String getCntrStsCdIc() {
		return this.cntrStsCdIc;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCdId
	 */
	public String getCntrStsCdId() {
		return this.cntrStsCdId;
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
	 * @return grsWgtFrom
	 */
	public String getGrsWgtFrom() {
		return this.grsWgtFrom;
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
	 * @return pBkgRptKndCd
	 */
	public String getPBkgRptKndCd() {
		return this.pBkgRptKndCd;
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
	 * @return rateStsU
	 */
	public String getRateStsU() {
		return this.rateStsU;
	}
	
	/**
	 * Column Info
	 * @return rateStsR
	 */
	public String getRateStsR() {
		return this.rateStsR;
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
	 * @return podLocal
	 */
	public String getPodLocal() {
		return this.podLocal;
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
	 * @return spCargoDg
	 */
	public String getSpCargoDg() {
		return this.spCargoDg;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCdMt
	 */
	public String getCntrStsCdMt() {
		return this.cntrStsCdMt;
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
	 * @return custGrpId
	 */
	public String getCustGrpId() {
		return this.custGrpId;
	}		
	

	/**
	 * Column Info
	 * @param cgoWgtFrom
	 */
	public void setCgoWgtFrom(String cgoWgtFrom) {
		this.cgoWgtFrom = cgoWgtFrom;
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
	 * @param cgoWgtTo
	 */
	public void setCgoWgtTo(String cgoWgtTo) {
		this.cgoWgtTo = cgoWgtTo;
	}
	
	/**
	 * Column Info
	 * @param wgtBndH
	 */
	public void setWgtBndH(String wgtBndH) {
		this.wgtBndH = wgtBndH;
	}
	
	/**
	 * Column Info
	 * @param wgtBndM
	 */
	public void setWgtBndM(String wgtBndM) {
		this.wgtBndM = wgtBndM;
	}
	
	/**
	 * Column Info
	 * @param wgtBndL
	 */
	public void setWgtBndL(String wgtBndL) {
		this.wgtBndL = wgtBndL;
	}
	
	/**
	 * Column Info
	 * @param cgoWgtLb
	 */
	public void setCgoWgtLb(String cgoWgtLb) {
		this.cgoWgtLb = cgoWgtLb;
	}
	
	/**
	 * Column Info
	 * @param spCargoHg
	 */
	public void setSpCargoHg(String spCargoHg) {
		this.spCargoHg = spCargoHg;
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
	 * @param cntrStsCdTs
	 */
	public void setCntrStsCdTs(String cntrStsCdTs) {
		this.cntrStsCdTs = cntrStsCdTs;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param grsWgtKg
	 */
	public void setGrsWgtKg(String grsWgtKg) {
		this.grsWgtKg = grsWgtKg;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCdTn
	 */
	public void setCntrStsCdTn(String cntrStsCdTn) {
		this.cntrStsCdTn = cntrStsCdTn;
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
	 * @param bOfcCdSub
	 */
	public void setBOfcCdSub(String bOfcCdSub) {
		this.bOfcCdSub = bOfcCdSub;
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
	 * @param spCargoBb
	 */
	public void setSpCargoBb(String spCargoBb) {
		this.spCargoBb = spCargoBb;
	}
	
	/**
	 * Column Info
	 * @param grsWgtTo
	 */
	public void setGrsWgtTo(String grsWgtTo) {
		this.grsWgtTo = grsWgtTo;
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
	 * @param boardToDt
	 */
	public void setBoardToDt(String boardToDt) {
		this.boardToDt = boardToDt;
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
	 * @param bkgStsCdF
	 */
	public void setBkgStsCdF(String bkgStsCdF) {
		this.bkgStsCdF = bkgStsCdF;
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
	 * @param bkgStsCdA
	 */
	public void setBkgStsCdA(String bkgStsCdA) {
		this.bkgStsCdA = bkgStsCdA;
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
	 * @param grsWgtLb
	 */
	public void setGrsWgtLb(String grsWgtLb) {
		this.grsWgtLb = grsWgtLb;
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
	 * @param podTs
	 */
	public void setPodTs(String podTs) {
		this.podTs = podTs;
	}
	
	/**
	 * Column Info
	 * @param rptId
	 */
	public void setRptId(String rptId) {
		this.rptId = rptId;
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
	 * @param cgoWgtKg
	 */
	public void setCgoWgtKg(String cgoWgtKg) {
		this.cgoWgtKg = cgoWgtKg;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCdOp
	 */
	public void setCntrStsCdOp(String cntrStsCdOp) {
		this.cntrStsCdOp = cntrStsCdOp;
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
	 * @param nonSpCargo
	 */
	public void setNonSpCargo(String nonSpCargo) {
		this.nonSpCargo = nonSpCargo;
	}
	
	/**
	 * Column Info
	 * @param wgtBndXh
	 */
	public void setWgtBndXh(String wgtBndXh) {
		this.wgtBndXh = wgtBndXh;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param cntrStsCdEn
	 */
	public void setCntrStsCdEn(String cntrStsCdEn) {
		this.cntrStsCdEn = cntrStsCdEn;
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
	 * @param cntrStsCdOc
	 */
	public void setCntrStsCdOc(String cntrStsCdOc) {
		this.cntrStsCdOc = cntrStsCdOc;
	}
	
	/**
	 * Column Info
	 * @param blRlseOfcCd
	 */
	public void setBlRlseOfcCd(String blRlseOfcCd) {
		this.blRlseOfcCd = blRlseOfcCd;
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
	 * @param spCargoRd
	 */
	public void setSpCargoRd(String spCargoRd) {
		this.spCargoRd = spCargoRd;
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
	 * @param ctrRfaNo
	 */
	public void setCtrRfaNo(String ctrRfaNo) {
		this.ctrRfaNo = ctrRfaNo;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCdVs
	 */
	public void setCntrStsCdVs(String cntrStsCdVs) {
		this.cntrStsCdVs = cntrStsCdVs;
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
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCdVl
	 */
	public void setCntrStsCdVl(String cntrStsCdVl) {
		this.cntrStsCdVl = cntrStsCdVl;
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
	 * @param polTs
	 */
	public void setPolTs(String polTs) {
		this.polTs = polTs;
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
	 * @param cntrStsCdIc
	 */
	public void setCntrStsCdIc(String cntrStsCdIc) {
		this.cntrStsCdIc = cntrStsCdIc;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCdId
	 */
	public void setCntrStsCdId(String cntrStsCdId) {
		this.cntrStsCdId = cntrStsCdId;
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
	 * @param grsWgtFrom
	 */
	public void setGrsWgtFrom(String grsWgtFrom) {
		this.grsWgtFrom = grsWgtFrom;
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
	 * @param pBkgRptKndCd
	 */
	public void setPBkgRptKndCd(String pBkgRptKndCd) {
		this.pBkgRptKndCd = pBkgRptKndCd;
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
	 * @param rateStsU
	 */
	public void setRateStsU(String rateStsU) {
		this.rateStsU = rateStsU;
	}
	
	/**
	 * Column Info
	 * @param rateStsR
	 */
	public void setRateStsR(String rateStsR) {
		this.rateStsR = rateStsR;
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
	 * @param podLocal
	 */
	public void setPodLocal(String podLocal) {
		this.podLocal = podLocal;
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
	 * @param spCargoDg
	 */
	public void setSpCargoDg(String spCargoDg) {
		this.spCargoDg = spCargoDg;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCdMt
	 */
	public void setCntrStsCdMt(String cntrStsCdMt) {
		this.cntrStsCdMt = cntrStsCdMt;
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
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}	
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCgoWgtFrom(JSPUtil.getParameter(request, prefix + "cgo_wgt_from", ""));
		setHolding(JSPUtil.getParameter(request, prefix + "holding", ""));
		setCgoWgtTo(JSPUtil.getParameter(request, prefix + "cgo_wgt_to", ""));
		setWgtBndH(JSPUtil.getParameter(request, prefix + "wgt_bnd_h", ""));
		setWgtBndM(JSPUtil.getParameter(request, prefix + "wgt_bnd_m", ""));
		setWgtBndL(JSPUtil.getParameter(request, prefix + "wgt_bnd_l", ""));
		setCgoWgtLb(JSPUtil.getParameter(request, prefix + "cgo_wgt_lb", ""));
		setSpCargoHg(JSPUtil.getParameter(request, prefix + "sp_cargo_hg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrStsCdTs(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_ts", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPolYardCd(JSPUtil.getParameter(request, prefix + "pol_yard_cd", ""));
		setGrsWgtKg(JSPUtil.getParameter(request, prefix + "grs_wgt_kg", ""));
		setCntrStsCdTn(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_tn", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgStsCdW(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_w", ""));
		setDTerm(JSPUtil.getParameter(request, prefix + "d_term", ""));
		setBOfcCdSub(JSPUtil.getParameter(request, prefix + "b_ofc_cd_sub", ""));
		setBkgStsCdX(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_x", ""));
		setBOfcCd(JSPUtil.getParameter(request, prefix + "b_ofc_cd", ""));
		setBkgKind(JSPUtil.getParameter(request, prefix + "bkg_kind", ""));
		setOrderbyTitleSql(JSPUtil.getParameter(request, prefix + "orderby_title_sql", ""));
		setSpCargoBb(JSPUtil.getParameter(request, prefix + "sp_cargo_bb", ""));
		setGrsWgtTo(JSPUtil.getParameter(request, prefix + "grs_wgt_to", ""));
		setBoardFromDt(JSPUtil.getParameter(request, prefix + "board_from_dt", ""));
		setPodYardCd(JSPUtil.getParameter(request, prefix + "pod_yard_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBoardToDt(JSPUtil.getParameter(request, prefix + "board_to_dt", ""));
		setCtrRfaCd(JSPUtil.getParameter(request, prefix + "ctr_rfa_cd", ""));
		setBkgStsCdF(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_f", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgStsCdA(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_a", ""));
		setTrunkFlag(JSPUtil.getParameter(request, prefix + "trunk_flag", ""));
		setGrsWgtLb(JSPUtil.getParameter(request, prefix + "grs_wgt_lb", ""));
		setSpCargoAk(JSPUtil.getParameter(request, prefix + "sp_cargo_ak", ""));
		setPodTs(JSPUtil.getParameter(request, prefix + "pod_ts", ""));
		setRptId(JSPUtil.getParameter(request, prefix + "rpt_id", ""));
		setBStaffId(JSPUtil.getParameter(request, prefix + "b_staff_id", ""));
		setCgoWgtKg(JSPUtil.getParameter(request, prefix + "cgo_wgt_kg", ""));
		setCntrStsCdOp(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_op", ""));
		setOrderby(JSPUtil.getParameter(request, prefix + "orderby", ""));
		setNonSpCargo(JSPUtil.getParameter(request, prefix + "non_sp_cargo", ""));
		setWgtBndXh(JSPUtil.getParameter(request, prefix + "wgt_bnd_xh", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCntrStsCdEn(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_en", ""));
		setPReportType(JSPUtil.getParameter(request, prefix + "p_report_type", ""));
		setCntrStsCdOc(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_oc", ""));
		setBlRlseOfcCd(JSPUtil.getParameter(request, prefix + "bl_rlse_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpCargoRf(JSPUtil.getParameter(request, prefix + "sp_cargo_rf", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSpCargoRd(JSPUtil.getParameter(request, prefix + "sp_cargo_rd", ""));
		setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
		setPolLocal(JSPUtil.getParameter(request, prefix + "pol_local", ""));
		setCtrRfaNo(JSPUtil.getParameter(request, prefix + "ctr_rfa_no", ""));
		setCntrStsCdVs(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_vs", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setCntrStsCdVl(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_vl", ""));
		setCustTpCdS(JSPUtil.getParameter(request, prefix + "cust_tp_cd_s", ""));
		setPolTs(JSPUtil.getParameter(request, prefix + "pol_ts", ""));
		setCaFlag(JSPUtil.getParameter(request, prefix + "ca_flag", ""));
		setCustTpCdN(JSPUtil.getParameter(request, prefix + "cust_tp_cd_n", ""));
		setCntrStsCdIc(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_ic", ""));
		setCntrStsCdId(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_id", ""));
		setOrderbySelect(JSPUtil.getParameter(request, prefix + "orderby_select", ""));
		setGrsWgtFrom(JSPUtil.getParameter(request, prefix + "grs_wgt_from", ""));
		setCustTpCdF(JSPUtil.getParameter(request, prefix + "cust_tp_cd_f", ""));
		setCustTpCdG(JSPUtil.getParameter(request, prefix + "cust_tp_cd_g", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPBkgRptKndCd(JSPUtil.getParameter(request, prefix + "p_bkg_rpt_knd_cd", ""));
		setCustTpCdC(JSPUtil.getParameter(request, prefix + "cust_tp_cd_c", ""));
		setEqType(JSPUtil.getParameter(request, prefix + "eq_type", ""));
		setCustTpCdA(JSPUtil.getParameter(request, prefix + "cust_tp_cd_a", ""));
		setRateStsU(JSPUtil.getParameter(request, prefix + "rate_sts_u", ""));
		setRateStsR(JSPUtil.getParameter(request, prefix + "rate_sts_r", ""));
		setBkgFromDt(JSPUtil.getParameter(request, prefix + "bkg_from_dt", ""));
		setPodLocal(JSPUtil.getParameter(request, prefix + "pod_local", ""));
		setLastOrderby(JSPUtil.getParameter(request, prefix + "last_orderby", ""));
		setSpCargoDg(JSPUtil.getParameter(request, prefix + "sp_cargo_dg", ""));
		setCntrStsCdMt(JSPUtil.getParameter(request, prefix + "cntr_sts_cd_mt", ""));
		setRTerm(JSPUtil.getParameter(request, prefix + "r_term", ""));
		setCustGrpId(JSPUtil.getParameter(request, "cust_grp_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BokCntrListInVO[]
	 */
	public BokCntrListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BokCntrListInVO[]
	 */
	public BokCntrListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BokCntrListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoWgtFrom = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_from", length));
			String[] holding = (JSPUtil.getParameter(request, prefix	+ "holding", length));
			String[] cgoWgtTo = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_to", length));
			String[] wgtBndH = (JSPUtil.getParameter(request, prefix	+ "wgt_bnd_h", length));
			String[] wgtBndM = (JSPUtil.getParameter(request, prefix	+ "wgt_bnd_m", length));
			String[] wgtBndL = (JSPUtil.getParameter(request, prefix	+ "wgt_bnd_l", length));
			String[] cgoWgtLb = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_lb", length));
			String[] spCargoHg = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_hg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrStsCdTs = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_ts", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] polYardCd = (JSPUtil.getParameter(request, prefix	+ "pol_yard_cd", length));
			String[] grsWgtKg = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_kg", length));
			String[] cntrStsCdTn = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_tn", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgStsCdW = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_w", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] bOfcCdSub = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd_sub", length));
			String[] bkgStsCdX = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_x", length));
			String[] bOfcCd = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd", length));
			String[] bkgKind = (JSPUtil.getParameter(request, prefix	+ "bkg_kind", length));
			String[] orderbyTitleSql = (JSPUtil.getParameter(request, prefix	+ "orderby_title_sql", length));
			String[] spCargoBb = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_bb", length));
			String[] grsWgtTo = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_to", length));
			String[] boardFromDt = (JSPUtil.getParameter(request, prefix	+ "board_from_dt", length));
			String[] podYardCd = (JSPUtil.getParameter(request, prefix	+ "pod_yard_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] boardToDt = (JSPUtil.getParameter(request, prefix	+ "board_to_dt", length));
			String[] ctrRfaCd = (JSPUtil.getParameter(request, prefix	+ "ctr_rfa_cd", length));
			String[] bkgStsCdF = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_f", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgStsCdA = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_a", length));
			String[] trunkFlag = (JSPUtil.getParameter(request, prefix	+ "trunk_flag", length));
			String[] grsWgtLb = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_lb", length));
			String[] spCargoAk = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_ak", length));
			String[] podTs = (JSPUtil.getParameter(request, prefix	+ "pod_ts", length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id", length));
			String[] bStaffId = (JSPUtil.getParameter(request, prefix	+ "b_staff_id", length));
			String[] cgoWgtKg = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_kg", length));
			String[] cntrStsCdOp = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_op", length));
			String[] orderby = (JSPUtil.getParameter(request, prefix	+ "orderby", length));
			String[] nonSpCargo = (JSPUtil.getParameter(request, prefix	+ "non_sp_cargo", length));
			String[] wgtBndXh = (JSPUtil.getParameter(request, prefix	+ "wgt_bnd_xh", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] cntrStsCdEn = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_en", length));
			String[] pReportType = (JSPUtil.getParameter(request, prefix	+ "p_report_type", length));
			String[] cntrStsCdOc = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_oc", length));
			String[] blRlseOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_rlse_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spCargoRf = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rf", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] spCargoRd = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_rd", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] polLocal = (JSPUtil.getParameter(request, prefix	+ "pol_local", length));
			String[] ctrRfaNo = (JSPUtil.getParameter(request, prefix	+ "ctr_rfa_no", length));
			String[] cntrStsCdVs = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_vs", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] cntrStsCdVl = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_vl", length));
			String[] custTpCdS = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_s", length));
			String[] polTs = (JSPUtil.getParameter(request, prefix	+ "pol_ts", length));
			String[] caFlag = (JSPUtil.getParameter(request, prefix	+ "ca_flag", length));
			String[] custTpCdN = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_n", length));
			String[] cntrStsCdIc = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_ic", length));
			String[] cntrStsCdId = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_id", length));
			String[] orderbySelect = (JSPUtil.getParameter(request, prefix	+ "orderby_select", length));
			String[] grsWgtFrom = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_from", length));
			String[] custTpCdF = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_f", length));
			String[] custTpCdG = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_g", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pBkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "p_bkg_rpt_knd_cd", length));
			String[] custTpCdC = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_c", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] custTpCdA = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_a", length));
			String[] rateStsU = (JSPUtil.getParameter(request, prefix	+ "rate_sts_u", length));
			String[] rateStsR = (JSPUtil.getParameter(request, prefix	+ "rate_sts_r", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] podLocal = (JSPUtil.getParameter(request, prefix	+ "pod_local", length));
			String[] lastOrderby = (JSPUtil.getParameter(request, prefix	+ "last_orderby", length));
			String[] spCargoDg = (JSPUtil.getParameter(request, prefix	+ "sp_cargo_dg", length));
			String[] cntrStsCdMt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd_mt", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BokCntrListInVO();
				if (cgoWgtFrom[i] != null)
					model.setCgoWgtFrom(cgoWgtFrom[i]);
				if (holding[i] != null)
					model.setHolding(holding[i]);
				if (cgoWgtTo[i] != null)
					model.setCgoWgtTo(cgoWgtTo[i]);
				if (wgtBndH[i] != null)
					model.setWgtBndH(wgtBndH[i]);
				if (wgtBndM[i] != null)
					model.setWgtBndM(wgtBndM[i]);
				if (wgtBndL[i] != null)
					model.setWgtBndL(wgtBndL[i]);
				if (cgoWgtLb[i] != null)
					model.setCgoWgtLb(cgoWgtLb[i]);
				if (spCargoHg[i] != null)
					model.setSpCargoHg(spCargoHg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrStsCdTs[i] != null)
					model.setCntrStsCdTs(cntrStsCdTs[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (polYardCd[i] != null)
					model.setPolYardCd(polYardCd[i]);
				if (grsWgtKg[i] != null)
					model.setGrsWgtKg(grsWgtKg[i]);
				if (cntrStsCdTn[i] != null)
					model.setCntrStsCdTn(cntrStsCdTn[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgStsCdW[i] != null)
					model.setBkgStsCdW(bkgStsCdW[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (bOfcCdSub[i] != null)
					model.setBOfcCdSub(bOfcCdSub[i]);
				if (bkgStsCdX[i] != null)
					model.setBkgStsCdX(bkgStsCdX[i]);
				if (bOfcCd[i] != null)
					model.setBOfcCd(bOfcCd[i]);
				if (bkgKind[i] != null)
					model.setBkgKind(bkgKind[i]);
				if (orderbyTitleSql[i] != null)
					model.setOrderbyTitleSql(orderbyTitleSql[i]);
				if (spCargoBb[i] != null)
					model.setSpCargoBb(spCargoBb[i]);
				if (grsWgtTo[i] != null)
					model.setGrsWgtTo(grsWgtTo[i]);
				if (boardFromDt[i] != null)
					model.setBoardFromDt(boardFromDt[i]);
				if (podYardCd[i] != null)
					model.setPodYardCd(podYardCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (boardToDt[i] != null)
					model.setBoardToDt(boardToDt[i]);
				if (ctrRfaCd[i] != null)
					model.setCtrRfaCd(ctrRfaCd[i]);
				if (bkgStsCdF[i] != null)
					model.setBkgStsCdF(bkgStsCdF[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgStsCdA[i] != null)
					model.setBkgStsCdA(bkgStsCdA[i]);
				if (trunkFlag[i] != null)
					model.setTrunkFlag(trunkFlag[i]);
				if (grsWgtLb[i] != null)
					model.setGrsWgtLb(grsWgtLb[i]);
				if (spCargoAk[i] != null)
					model.setSpCargoAk(spCargoAk[i]);
				if (podTs[i] != null)
					model.setPodTs(podTs[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (bStaffId[i] != null)
					model.setBStaffId(bStaffId[i]);
				if (cgoWgtKg[i] != null)
					model.setCgoWgtKg(cgoWgtKg[i]);
				if (cntrStsCdOp[i] != null)
					model.setCntrStsCdOp(cntrStsCdOp[i]);
				if (orderby[i] != null)
					model.setOrderby(orderby[i]);
				if (nonSpCargo[i] != null)
					model.setNonSpCargo(nonSpCargo[i]);
				if (wgtBndXh[i] != null)
					model.setWgtBndXh(wgtBndXh[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (cntrStsCdEn[i] != null)
					model.setCntrStsCdEn(cntrStsCdEn[i]);
				if (pReportType[i] != null)
					model.setPReportType(pReportType[i]);
				if (cntrStsCdOc[i] != null)
					model.setCntrStsCdOc(cntrStsCdOc[i]);
				if (blRlseOfcCd[i] != null)
					model.setBlRlseOfcCd(blRlseOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spCargoRf[i] != null)
					model.setSpCargoRf(spCargoRf[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (spCargoRd[i] != null)
					model.setSpCargoRd(spCargoRd[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (polLocal[i] != null)
					model.setPolLocal(polLocal[i]);
				if (ctrRfaNo[i] != null)
					model.setCtrRfaNo(ctrRfaNo[i]);
				if (cntrStsCdVs[i] != null)
					model.setCntrStsCdVs(cntrStsCdVs[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (cntrStsCdVl[i] != null)
					model.setCntrStsCdVl(cntrStsCdVl[i]);
				if (custTpCdS[i] != null)
					model.setCustTpCdS(custTpCdS[i]);
				if (polTs[i] != null)
					model.setPolTs(polTs[i]);
				if (caFlag[i] != null)
					model.setCaFlag(caFlag[i]);
				if (custTpCdN[i] != null)
					model.setCustTpCdN(custTpCdN[i]);
				if (cntrStsCdIc[i] != null)
					model.setCntrStsCdIc(cntrStsCdIc[i]);
				if (cntrStsCdId[i] != null)
					model.setCntrStsCdId(cntrStsCdId[i]);
				if (orderbySelect[i] != null)
					model.setOrderbySelect(orderbySelect[i]);
				if (grsWgtFrom[i] != null)
					model.setGrsWgtFrom(grsWgtFrom[i]);
				if (custTpCdF[i] != null)
					model.setCustTpCdF(custTpCdF[i]);
				if (custTpCdG[i] != null)
					model.setCustTpCdG(custTpCdG[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pBkgRptKndCd[i] != null)
					model.setPBkgRptKndCd(pBkgRptKndCd[i]);
				if (custTpCdC[i] != null)
					model.setCustTpCdC(custTpCdC[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (custTpCdA[i] != null)
					model.setCustTpCdA(custTpCdA[i]);
				if (rateStsU[i] != null)
					model.setRateStsU(rateStsU[i]);
				if (rateStsR[i] != null)
					model.setRateStsR(rateStsR[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (podLocal[i] != null)
					model.setPodLocal(podLocal[i]);
				if (lastOrderby[i] != null)
					model.setLastOrderby(lastOrderby[i]);
				if (spCargoDg[i] != null)
					model.setSpCargoDg(spCargoDg[i]);
				if (cntrStsCdMt[i] != null)
					model.setCntrStsCdMt(cntrStsCdMt[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBokCntrListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BokCntrListInVO[]
	 */
	public BokCntrListInVO[] getBokCntrListInVOs(){
		BokCntrListInVO[] vos = (BokCntrListInVO[])models.toArray(new BokCntrListInVO[models.size()]);
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
		this.cgoWgtFrom = this.cgoWgtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holding = this.holding .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtTo = this.cgoWgtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtBndH = this.wgtBndH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtBndM = this.wgtBndM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtBndL = this.wgtBndL .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtLb = this.cgoWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoHg = this.spCargoHg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdTs = this.cntrStsCdTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYardCd = this.polYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtKg = this.grsWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdTn = this.cntrStsCdTn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdW = this.bkgStsCdW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCdSub = this.bOfcCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdX = this.bkgStsCdX .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCd = this.bOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKind = this.bkgKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbyTitleSql = this.orderbyTitleSql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoBb = this.spCargoBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtTo = this.grsWgtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardFromDt = this.boardFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYardCd = this.podYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boardToDt = this.boardToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrRfaCd = this.ctrRfaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdF = this.bkgStsCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdA = this.bkgStsCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkFlag = this.trunkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtLb = this.grsWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoAk = this.spCargoAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTs = this.podTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bStaffId = this.bStaffId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtKg = this.cgoWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdOp = this.cntrStsCdOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderby = this.orderby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonSpCargo = this.nonSpCargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtBndXh = this.wgtBndXh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdEn = this.cntrStsCdEn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pReportType = this.pReportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdOc = this.cntrStsCdOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlseOfcCd = this.blRlseOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRf = this.spCargoRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRd = this.spCargoRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocal = this.polLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrRfaNo = this.ctrRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdVs = this.cntrStsCdVs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdVl = this.cntrStsCdVl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdS = this.custTpCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTs = this.polTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlag = this.caFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdN = this.custTpCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdIc = this.cntrStsCdIc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdId = this.cntrStsCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbySelect = this.orderbySelect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtFrom = this.grsWgtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdF = this.custTpCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdG = this.custTpCdG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgRptKndCd = this.pBkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdC = this.custTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdA = this.custTpCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateStsU = this.rateStsU .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateStsR = this.rateStsR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocal = this.podLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastOrderby = this.lastOrderby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoDg = this.spCargoDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCdMt = this.cntrStsCdMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
