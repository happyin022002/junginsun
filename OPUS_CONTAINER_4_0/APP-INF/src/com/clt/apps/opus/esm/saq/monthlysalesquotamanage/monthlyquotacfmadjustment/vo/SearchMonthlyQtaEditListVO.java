/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQtaEditListVO.java
*@FileTitle : SearchMonthlyQtaEditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2009.11.06 Choi.M.C 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.vo;

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
 * @author Choi.M.C
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQtaEditListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQtaEditListVO> models = new ArrayList<SearchMonthlyQtaEditListVO>();
	
	/* Column Info */
	private String saqMiscRevAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String addTpCd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyTrspUcAmt = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String custGrpNm = null;
	/* Column Info */
	private String cntrFxUcAmt = null;
	/* Column Info */
	private String bizActUcAmt = null;
	/* Column Info */
	private String eqHldUcAmt = null;
	/* Column Info */
	private String fullTrspUcAmt = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String raOpfitUcAmt = null;
	/* Column Info */
	private String custGrpId = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String opfitUcAmt = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String agnCommUtAmt = null;
	/* Column Info */
	private String chssFxUcAmt = null;
	/* Column Info */
	private String raCmAmt = null;
	/* Column Info */
	private String eqSimUcAmt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String cmUcAmt = null;
	/* Column Info */
	private String qtaTgtCd = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String stpUcAmt = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String mqtaRlseVerNo = null;
	/* Column Info */
	private String eqRepoUcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mtyStvgUcAmt = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String sltMgmtUcAmt = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String raOpfitAmt = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String cmAmt = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String ownVolActUcAmt = null;
	/* Column Info */
	private String fullStvgUcAmt = null;
	/* Column Info */
	private String bsa = null;
	private String bsaCapa = null;
	private String deltFlg = null;
	private String grp = null;
	private String iocCd = null;
	private String lstLodgPortEtdDt = null;
	private String mon = null;
	private String newRlaneCd = null;
	private String skdDirCd = null;
	private String skdVoyNo = null;
	private String vslCd = null;
	private String vvd = null;
	private String vvdSeq = null;
	private String week = null;
	private String bsaGrpCd = null;
	private String etdDt = null;
	private String grpMax = null;
	private String sprtGrpCd = null;
	private String strFnlBsaCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQtaEditListVO() {}

	public SearchMonthlyQtaEditListVO(String ibflag, String pagerows, String rn, String custGrpNm, String mqtaRlseVerNo, String bseYr, String bseQtrCd, String qtaTgtCd, String trdCd, String dirCd, String subTrdCd, String rlaneCd, String vvdCd, String laneGrp, String bseMon, String bseWk, String fnlBsaCapa, String rgnOfcCd, String rhqCd, String aqCd, String unit, String lodQty, String grsRev, String grsRpbRev, String cmAmt, String cmUcAmt, String raCmAmt, String raCmUcAmt, String raOpfitAmt, String raOpfitUcAmt, String opfitUcAmt, String fullStvgUcAmt, String fullTrspUcAmt, String mtyStvgUcAmt, String mtyTrspUcAmt, String cntrFxUcAmt, String chssFxUcAmt, String agnCommUtAmt, String bizActUcAmt, String sltMgmtUcAmt, String ownVolActUcAmt, String stpUcAmt, String eqHldUcAmt, String eqRepoUcAmt, String eqSimUcAmt, String convDirCd, String saqMiscRevAmt, String custGrpId, String addTpCd, String bsa, String bsaCapa, String deltFlg, String grp, String iocCd, String lstLodgPortEtdDt, String mon, String newRlaneCd, String skdDirCd, String skdVoyNo, String vslCd, String vvd, String vvdSeq, String week, String bsaGrpCd, String etdDt, String grpMax, String sprtGrpCd, String strFnlBsaCapa) {
		this.saqMiscRevAmt = saqMiscRevAmt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.addTpCd = addTpCd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.mtyTrspUcAmt = mtyTrspUcAmt;
		this.bseQtrCd = bseQtrCd;
		this.vvdCd = vvdCd;
		this.convDirCd = convDirCd;
		this.custGrpNm = custGrpNm;
		this.cntrFxUcAmt = cntrFxUcAmt;
		this.bizActUcAmt = bizActUcAmt;
		this.eqHldUcAmt = eqHldUcAmt;
		this.fullTrspUcAmt = fullTrspUcAmt;
		this.lodQty = lodQty;
		this.raOpfitUcAmt = raOpfitUcAmt;
		this.custGrpId = custGrpId;
		this.rhqCd = rhqCd;
		this.opfitUcAmt = opfitUcAmt;
		this.bseWk = bseWk;
		this.agnCommUtAmt = agnCommUtAmt;
		this.chssFxUcAmt = chssFxUcAmt;
		this.raCmAmt = raCmAmt;
		this.eqSimUcAmt = eqSimUcAmt;
		this.subTrdCd = subTrdCd;
		this.cmUcAmt = cmUcAmt;
		this.qtaTgtCd = qtaTgtCd;
		this.rn = rn;
		this.stpUcAmt = stpUcAmt;
		this.bseMon = bseMon;
		this.mqtaRlseVerNo = mqtaRlseVerNo;
		this.eqRepoUcAmt = eqRepoUcAmt;
		this.ibflag = ibflag;
		this.mtyStvgUcAmt = mtyStvgUcAmt;
		this.grsRpbRev = grsRpbRev;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.aqCd = aqCd;
		this.sltMgmtUcAmt = sltMgmtUcAmt;
		this.laneGrp = laneGrp;
		this.raOpfitAmt = raOpfitAmt;
		this.bseYr = bseYr;
		this.cmAmt = cmAmt;
		this.unit = unit;
		this.raCmUcAmt = raCmUcAmt;
		this.grsRev = grsRev;
		this.ownVolActUcAmt = ownVolActUcAmt;
		this.fullStvgUcAmt = fullStvgUcAmt;
		this.bsa = bsa;
		this.bsaCapa = bsaCapa;
		this.deltFlg = deltFlg;
		this.grp = grp;
		this.iocCd = iocCd;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.mon = mon;
		this.newRlaneCd = newRlaneCd;
		this.skdDirCd = skdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.vslCd = vslCd;
		this.vvd = vvd;
		this.vvdSeq = vvdSeq;
		this.week = week;
		this.bsaGrpCd = bsaGrpCd;
		this.etdDt = etdDt;
		this.grpMax = grpMax;
		this.sprtGrpCd = sprtGrpCd;
		this.strFnlBsaCapa = strFnlBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("saq_misc_rev_amt", getSaqMiscRevAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("add_tp_cd", getAddTpCd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_trsp_uc_amt", getMtyTrspUcAmt());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("cust_grp_nm", getCustGrpNm());
		this.hashColumns.put("cntr_fx_uc_amt", getCntrFxUcAmt());
		this.hashColumns.put("biz_act_uc_amt", getBizActUcAmt());
		this.hashColumns.put("eq_hld_uc_amt", getEqHldUcAmt());
		this.hashColumns.put("full_trsp_uc_amt", getFullTrspUcAmt());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ra_opfit_uc_amt", getRaOpfitUcAmt());
		this.hashColumns.put("cust_grp_id", getCustGrpId());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("opfit_uc_amt", getOpfitUcAmt());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("agn_comm_ut_amt", getAgnCommUtAmt());
		this.hashColumns.put("chss_fx_uc_amt", getChssFxUcAmt());
		this.hashColumns.put("ra_cm_amt", getRaCmAmt());
		this.hashColumns.put("eq_sim_uc_amt", getEqSimUcAmt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cm_uc_amt", getCmUcAmt());
		this.hashColumns.put("qta_tgt_cd", getQtaTgtCd());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("stp_uc_amt", getStpUcAmt());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("mqta_rlse_ver_no", getMqtaRlseVerNo());
		this.hashColumns.put("eq_repo_uc_amt", getEqRepoUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mty_stvg_uc_amt", getMtyStvgUcAmt());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("slt_mgmt_uc_amt", getSltMgmtUcAmt());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("ra_opfit_amt", getRaOpfitAmt());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("cm_amt", getCmAmt());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("own_vol_act_uc_amt", getOwnVolActUcAmt());
		this.hashColumns.put("full_stvg_uc_amt", getFullStvgUcAmt());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("mon", getMon());
		this.hashColumns.put("new_rlane_cd", getNewRlaneCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("grp_max", getGrpMax());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("str_fnl_bsa_capa", getStrFnlBsaCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("saq_misc_rev_amt", "saqMiscRevAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("add_tp_cd", "addTpCd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_trsp_uc_amt", "mtyTrspUcAmt");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("cust_grp_nm", "custGrpNm");
		this.hashFields.put("cntr_fx_uc_amt", "cntrFxUcAmt");
		this.hashFields.put("biz_act_uc_amt", "bizActUcAmt");
		this.hashFields.put("eq_hld_uc_amt", "eqHldUcAmt");
		this.hashFields.put("full_trsp_uc_amt", "fullTrspUcAmt");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ra_opfit_uc_amt", "raOpfitUcAmt");
		this.hashFields.put("cust_grp_id", "custGrpId");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("opfit_uc_amt", "opfitUcAmt");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("agn_comm_ut_amt", "agnCommUtAmt");
		this.hashFields.put("chss_fx_uc_amt", "chssFxUcAmt");
		this.hashFields.put("ra_cm_amt", "raCmAmt");
		this.hashFields.put("eq_sim_uc_amt", "eqSimUcAmt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cm_uc_amt", "cmUcAmt");
		this.hashFields.put("qta_tgt_cd", "qtaTgtCd");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("stp_uc_amt", "stpUcAmt");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("mqta_rlse_ver_no", "mqtaRlseVerNo");
		this.hashFields.put("eq_repo_uc_amt", "eqRepoUcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mty_stvg_uc_amt", "mtyStvgUcAmt");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("slt_mgmt_uc_amt", "sltMgmtUcAmt");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("ra_opfit_amt", "raOpfitAmt");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("cm_amt", "cmAmt");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("own_vol_act_uc_amt", "ownVolActUcAmt");
		this.hashFields.put("full_stvg_uc_amt", "fullStvgUcAmt");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("mon", "mon");
		this.hashFields.put("new_rlane_cd", "newRlaneCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("week", "week");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("grp_max", "grpMax");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("str_fnl_bsa_capa", "strFnlBsaCapa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return saqMiscRevAmt
	 */
	public String getSaqMiscRevAmt() {
		return this.saqMiscRevAmt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return addTpCd
	 */
	public String getAddTpCd() {
		return this.addTpCd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return mtyTrspUcAmt
	 */
	public String getMtyTrspUcAmt() {
		return this.mtyTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return custGrpNm
	 */
	public String getCustGrpNm() {
		return this.custGrpNm;
	}
	
	/**
	 * Column Info
	 * @return cntrFxUcAmt
	 */
	public String getCntrFxUcAmt() {
		return this.cntrFxUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bizActUcAmt
	 */
	public String getBizActUcAmt() {
		return this.bizActUcAmt;
	}
	
	/**
	 * Column Info
	 * @return eqHldUcAmt
	 */
	public String getEqHldUcAmt() {
		return this.eqHldUcAmt;
	}
	
	/**
	 * Column Info
	 * @return fullTrspUcAmt
	 */
	public String getFullTrspUcAmt() {
		return this.fullTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return raOpfitUcAmt
	 */
	public String getRaOpfitUcAmt() {
		return this.raOpfitUcAmt;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return opfitUcAmt
	 */
	public String getOpfitUcAmt() {
		return this.opfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return agnCommUtAmt
	 */
	public String getAgnCommUtAmt() {
		return this.agnCommUtAmt;
	}
	
	/**
	 * Column Info
	 * @return chssFxUcAmt
	 */
	public String getChssFxUcAmt() {
		return this.chssFxUcAmt;
	}
	
	/**
	 * Column Info
	 * @return raCmAmt
	 */
	public String getRaCmAmt() {
		return this.raCmAmt;
	}
	
	/**
	 * Column Info
	 * @return eqSimUcAmt
	 */
	public String getEqSimUcAmt() {
		return this.eqSimUcAmt;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return cmUcAmt
	 */
	public String getCmUcAmt() {
		return this.cmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return qtaTgtCd
	 */
	public String getQtaTgtCd() {
		return this.qtaTgtCd;
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
	 * @return stpUcAmt
	 */
	public String getStpUcAmt() {
		return this.stpUcAmt;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return mqtaRlseVerNo
	 */
	public String getMqtaRlseVerNo() {
		return this.mqtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @return eqRepoUcAmt
	 */
	public String getEqRepoUcAmt() {
		return this.eqRepoUcAmt;
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
	 * @return mtyStvgUcAmt
	 */
	public String getMtyStvgUcAmt() {
		return this.mtyStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
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
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	
	/**
	 * Column Info
	 * @return sltMgmtUcAmt
	 */
	public String getSltMgmtUcAmt() {
		return this.sltMgmtUcAmt;
	}
	
	/**
	 * Column Info
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return raOpfitAmt
	 */
	public String getRaOpfitAmt() {
		return this.raOpfitAmt;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return cmAmt
	 */
	public String getCmAmt() {
		return this.cmAmt;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return ownVolActUcAmt
	 */
	public String getOwnVolActUcAmt() {
		return this.ownVolActUcAmt;
	}
	
	/**
	 * Column Info
	 * @return fullStvgUcAmt
	 */
	public String getFullStvgUcAmt() {
		return this.fullStvgUcAmt;
	}
	

	/**
	 * Column Info
	 * @param saqMiscRevAmt
	 */
	public void setSaqMiscRevAmt(String saqMiscRevAmt) {
		this.saqMiscRevAmt = saqMiscRevAmt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param addTpCd
	 */
	public void setAddTpCd(String addTpCd) {
		this.addTpCd = addTpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param mtyTrspUcAmt
	 */
	public void setMtyTrspUcAmt(String mtyTrspUcAmt) {
		this.mtyTrspUcAmt = mtyTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param custGrpNm
	 */
	public void setCustGrpNm(String custGrpNm) {
		this.custGrpNm = custGrpNm;
	}
	
	/**
	 * Column Info
	 * @param cntrFxUcAmt
	 */
	public void setCntrFxUcAmt(String cntrFxUcAmt) {
		this.cntrFxUcAmt = cntrFxUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bizActUcAmt
	 */
	public void setBizActUcAmt(String bizActUcAmt) {
		this.bizActUcAmt = bizActUcAmt;
	}
	
	/**
	 * Column Info
	 * @param eqHldUcAmt
	 */
	public void setEqHldUcAmt(String eqHldUcAmt) {
		this.eqHldUcAmt = eqHldUcAmt;
	}
	
	/**
	 * Column Info
	 * @param fullTrspUcAmt
	 */
	public void setFullTrspUcAmt(String fullTrspUcAmt) {
		this.fullTrspUcAmt = fullTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param raOpfitUcAmt
	 */
	public void setRaOpfitUcAmt(String raOpfitUcAmt) {
		this.raOpfitUcAmt = raOpfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @param custGrpId
	 */
	public void setCustGrpId(String custGrpId) {
		this.custGrpId = custGrpId;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param opfitUcAmt
	 */
	public void setOpfitUcAmt(String opfitUcAmt) {
		this.opfitUcAmt = opfitUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param agnCommUtAmt
	 */
	public void setAgnCommUtAmt(String agnCommUtAmt) {
		this.agnCommUtAmt = agnCommUtAmt;
	}
	
	/**
	 * Column Info
	 * @param chssFxUcAmt
	 */
	public void setChssFxUcAmt(String chssFxUcAmt) {
		this.chssFxUcAmt = chssFxUcAmt;
	}
	
	/**
	 * Column Info
	 * @param raCmAmt
	 */
	public void setRaCmAmt(String raCmAmt) {
		this.raCmAmt = raCmAmt;
	}
	
	/**
	 * Column Info
	 * @param eqSimUcAmt
	 */
	public void setEqSimUcAmt(String eqSimUcAmt) {
		this.eqSimUcAmt = eqSimUcAmt;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param cmUcAmt
	 */
	public void setCmUcAmt(String cmUcAmt) {
		this.cmUcAmt = cmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param qtaTgtCd
	 */
	public void setQtaTgtCd(String qtaTgtCd) {
		this.qtaTgtCd = qtaTgtCd;
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
	 * @param stpUcAmt
	 */
	public void setStpUcAmt(String stpUcAmt) {
		this.stpUcAmt = stpUcAmt;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param mqtaRlseVerNo
	 */
	public void setMqtaRlseVerNo(String mqtaRlseVerNo) {
		this.mqtaRlseVerNo = mqtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @param eqRepoUcAmt
	 */
	public void setEqRepoUcAmt(String eqRepoUcAmt) {
		this.eqRepoUcAmt = eqRepoUcAmt;
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
	 * @param mtyStvgUcAmt
	 */
	public void setMtyStvgUcAmt(String mtyStvgUcAmt) {
		this.mtyStvgUcAmt = mtyStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
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
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Column Info
	 * @param sltMgmtUcAmt
	 */
	public void setSltMgmtUcAmt(String sltMgmtUcAmt) {
		this.sltMgmtUcAmt = sltMgmtUcAmt;
	}
	
	/**
	 * Column Info
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param raOpfitAmt
	 */
	public void setRaOpfitAmt(String raOpfitAmt) {
		this.raOpfitAmt = raOpfitAmt;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param cmAmt
	 */
	public void setCmAmt(String cmAmt) {
		this.cmAmt = cmAmt;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param ownVolActUcAmt
	 */
	public void setOwnVolActUcAmt(String ownVolActUcAmt) {
		this.ownVolActUcAmt = ownVolActUcAmt;
	}
	
	/**
	 * Column Info
	 * @param fullStvgUcAmt
	 */
	public void setFullStvgUcAmt(String fullStvgUcAmt) {
		this.fullStvgUcAmt = fullStvgUcAmt;
	}
	
	public String getBsa() {
		return bsa;
	}

	public void setBsa(String bsa) {
		this.bsa = bsa;
	}

	public String getBsaCapa() {
		return bsaCapa;
	}

	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}

	public String getDeltFlg() {
		return deltFlg;
	}

	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getIocCd() {
		return iocCd;
	}

	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}

	public String getLstLodgPortEtdDt() {
		return lstLodgPortEtdDt;
	}

	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getNewRlaneCd() {
		return newRlaneCd;
	}

	public void setNewRlaneCd(String newRlaneCd) {
		this.newRlaneCd = newRlaneCd;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getVvdSeq() {
		return vvdSeq;
	}

	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getBsaGrpCd() {
		return bsaGrpCd;
	}

	public void setBsaGrpCd(String bsaGrpCd) {
		this.bsaGrpCd = bsaGrpCd;
	}

	public String getEtdDt() {
		return etdDt;
	}

	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	public String getGrpMax() {
		return grpMax;
	}

	public void setGrpMax(String grpMax) {
		this.grpMax = grpMax;
	}

	public String getSprtGrpCd() {
		return sprtGrpCd;
	}

	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}

	public String getStrFnlBsaCapa() {
		return strFnlBsaCapa;
	}

	public void setStrFnlBsaCapa(String strFnlBsaCapa) {
		this.strFnlBsaCapa = strFnlBsaCapa;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSaqMiscRevAmt(JSPUtil.getParameter(request, "saq_misc_rev_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setAddTpCd(JSPUtil.getParameter(request, "add_tp_cd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMtyTrspUcAmt(JSPUtil.getParameter(request, "mty_trsp_uc_amt", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setConvDirCd(JSPUtil.getParameter(request, "conv_dir_cd", ""));
		setCustGrpNm(JSPUtil.getParameter(request, "cust_grp_nm", ""));
		setCntrFxUcAmt(JSPUtil.getParameter(request, "cntr_fx_uc_amt", ""));
		setBizActUcAmt(JSPUtil.getParameter(request, "biz_act_uc_amt", ""));
		setEqHldUcAmt(JSPUtil.getParameter(request, "eq_hld_uc_amt", ""));
		setFullTrspUcAmt(JSPUtil.getParameter(request, "full_trsp_uc_amt", ""));
		setLodQty(JSPUtil.getParameter(request, "lod_qty", ""));
		setRaOpfitUcAmt(JSPUtil.getParameter(request, "ra_opfit_uc_amt", ""));
		setCustGrpId(JSPUtil.getParameter(request, "cust_grp_id", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setOpfitUcAmt(JSPUtil.getParameter(request, "opfit_uc_amt", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
		setAgnCommUtAmt(JSPUtil.getParameter(request, "agn_comm_ut_amt", ""));
		setChssFxUcAmt(JSPUtil.getParameter(request, "chss_fx_uc_amt", ""));
		setRaCmAmt(JSPUtil.getParameter(request, "ra_cm_amt", ""));
		setEqSimUcAmt(JSPUtil.getParameter(request, "eq_sim_uc_amt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setCmUcAmt(JSPUtil.getParameter(request, "cm_uc_amt", ""));
		setQtaTgtCd(JSPUtil.getParameter(request, "qta_tgt_cd", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setStpUcAmt(JSPUtil.getParameter(request, "stp_uc_amt", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setMqtaRlseVerNo(JSPUtil.getParameter(request, "mqta_rlse_ver_no", ""));
		setEqRepoUcAmt(JSPUtil.getParameter(request, "eq_repo_uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMtyStvgUcAmt(JSPUtil.getParameter(request, "mty_stvg_uc_amt", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, "grs_rpb_rev", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, "rgn_ofc_cd", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setSltMgmtUcAmt(JSPUtil.getParameter(request, "slt_mgmt_uc_amt", ""));
		setLaneGrp(JSPUtil.getParameter(request, "lane_grp", ""));
		setRaOpfitAmt(JSPUtil.getParameter(request, "ra_opfit_amt", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setCmAmt(JSPUtil.getParameter(request, "cm_amt", ""));
		setUnit(JSPUtil.getParameter(request, "unit", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, "ra_cm_uc_amt", ""));
		setGrsRev(JSPUtil.getParameter(request, "grs_rev", ""));
		setOwnVolActUcAmt(JSPUtil.getParameter(request, "own_vol_act_uc_amt", ""));
		setFullStvgUcAmt(JSPUtil.getParameter(request, "full_stvg_uc_amt", ""));
		setBsa(JSPUtil.getParameter(request, "bsa", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, "lst_lodg_port_etd_dt", ""));
		setMon(JSPUtil.getParameter(request, "mon", ""));
		setNewRlaneCd(JSPUtil.getParameter(request, "new_rlane_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setGrpMax(JSPUtil.getParameter(request, "grp_max", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setStrFnlBsaCapa(JSPUtil.getParameter(request, "str_fnl_bsa_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQtaEditListVO[]
	 */
	public SearchMonthlyQtaEditListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQtaEditListVO[]
	 */
	public SearchMonthlyQtaEditListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQtaEditListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] saqMiscRevAmt = (JSPUtil.getParameter(request, prefix	+ "saq_misc_rev_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] addTpCd = (JSPUtil.getParameter(request, prefix	+ "add_tp_cd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_uc_amt", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] custGrpNm = (JSPUtil.getParameter(request, prefix	+ "cust_grp_nm", length));
			String[] cntrFxUcAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_fx_uc_amt", length));
			String[] bizActUcAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_uc_amt", length));
			String[] eqHldUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_hld_uc_amt", length));
			String[] fullTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "full_trsp_uc_amt", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] raOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_opfit_uc_amt", length));
			String[] custGrpId = (JSPUtil.getParameter(request, prefix	+ "cust_grp_id", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] opfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "opfit_uc_amt", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] agnCommUtAmt = (JSPUtil.getParameter(request, prefix	+ "agn_comm_ut_amt", length));
			String[] chssFxUcAmt = (JSPUtil.getParameter(request, prefix	+ "chss_fx_uc_amt", length));
			String[] raCmAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_amt", length));
			String[] eqSimUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_sim_uc_amt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] cmUcAmt = (JSPUtil.getParameter(request, prefix	+ "cm_uc_amt", length));
			String[] qtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "qta_tgt_cd", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] stpUcAmt = (JSPUtil.getParameter(request, prefix	+ "stp_uc_amt", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] mqtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_rlse_ver_no", length));
			String[] eqRepoUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_repo_uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mtyStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "mty_stvg_uc_amt", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] sltMgmtUcAmt = (JSPUtil.getParameter(request, prefix	+ "slt_mgmt_uc_amt", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] raOpfitAmt = (JSPUtil.getParameter(request, prefix	+ "ra_opfit_amt", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] cmAmt = (JSPUtil.getParameter(request, prefix	+ "cm_amt", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] ownVolActUcAmt = (JSPUtil.getParameter(request, prefix	+ "own_vol_act_uc_amt", length));
			String[] fullStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "full_stvg_uc_amt", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] mon = (JSPUtil.getParameter(request, prefix	+ "mon", length));
			String[] newRlaneCd = (JSPUtil.getParameter(request, prefix	+ "new_rlane_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] grpMax = (JSPUtil.getParameter(request, prefix	+ "grp_max", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] strFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "str_fnl_bsa_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQtaEditListVO();
				if (saqMiscRevAmt[i] != null)
					model.setSaqMiscRevAmt(saqMiscRevAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (addTpCd[i] != null)
					model.setAddTpCd(addTpCd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyTrspUcAmt[i] != null)
					model.setMtyTrspUcAmt(mtyTrspUcAmt[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (custGrpNm[i] != null)
					model.setCustGrpNm(custGrpNm[i]);
				if (cntrFxUcAmt[i] != null)
					model.setCntrFxUcAmt(cntrFxUcAmt[i]);
				if (bizActUcAmt[i] != null)
					model.setBizActUcAmt(bizActUcAmt[i]);
				if (eqHldUcAmt[i] != null)
					model.setEqHldUcAmt(eqHldUcAmt[i]);
				if (fullTrspUcAmt[i] != null)
					model.setFullTrspUcAmt(fullTrspUcAmt[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (raOpfitUcAmt[i] != null)
					model.setRaOpfitUcAmt(raOpfitUcAmt[i]);
				if (custGrpId[i] != null)
					model.setCustGrpId(custGrpId[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (opfitUcAmt[i] != null)
					model.setOpfitUcAmt(opfitUcAmt[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (agnCommUtAmt[i] != null)
					model.setAgnCommUtAmt(agnCommUtAmt[i]);
				if (chssFxUcAmt[i] != null)
					model.setChssFxUcAmt(chssFxUcAmt[i]);
				if (raCmAmt[i] != null)
					model.setRaCmAmt(raCmAmt[i]);
				if (eqSimUcAmt[i] != null)
					model.setEqSimUcAmt(eqSimUcAmt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (cmUcAmt[i] != null)
					model.setCmUcAmt(cmUcAmt[i]);
				if (qtaTgtCd[i] != null)
					model.setQtaTgtCd(qtaTgtCd[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (stpUcAmt[i] != null)
					model.setStpUcAmt(stpUcAmt[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (mqtaRlseVerNo[i] != null)
					model.setMqtaRlseVerNo(mqtaRlseVerNo[i]);
				if (eqRepoUcAmt[i] != null)
					model.setEqRepoUcAmt(eqRepoUcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mtyStvgUcAmt[i] != null)
					model.setMtyStvgUcAmt(mtyStvgUcAmt[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (sltMgmtUcAmt[i] != null)
					model.setSltMgmtUcAmt(sltMgmtUcAmt[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (raOpfitAmt[i] != null)
					model.setRaOpfitAmt(raOpfitAmt[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (cmAmt[i] != null)
					model.setCmAmt(cmAmt[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (ownVolActUcAmt[i] != null)
					model.setOwnVolActUcAmt(ownVolActUcAmt[i]);
				if (fullStvgUcAmt[i] != null)
					model.setFullStvgUcAmt(fullStvgUcAmt[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (mon[i] != null)
					model.setMon(mon[i]);
				if (newRlaneCd[i] != null)
					model.setNewRlaneCd(newRlaneCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (grpMax[i] != null)
					model.setGrpMax(grpMax[i]);
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (strFnlBsaCapa[i] != null)
					model.setStrFnlBsaCapa(strFnlBsaCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQtaEditListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQtaEditListVO[]
	 */
	public SearchMonthlyQtaEditListVO[] getSearchMonthlyQtaEditListVOs(){
		SearchMonthlyQtaEditListVO[] vos = (SearchMonthlyQtaEditListVO[])models.toArray(new SearchMonthlyQtaEditListVO[models.size()]);
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
		this.saqMiscRevAmt = this.saqMiscRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addTpCd = this.addTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspUcAmt = this.mtyTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpNm = this.custGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFxUcAmt = this.cntrFxUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActUcAmt = this.bizActUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqHldUcAmt = this.eqHldUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTrspUcAmt = this.fullTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raOpfitUcAmt = this.raOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGrpId = this.custGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opfitUcAmt = this.opfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCommUtAmt = this.agnCommUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssFxUcAmt = this.chssFxUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmAmt = this.raCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSimUcAmt = this.eqSimUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmUcAmt = this.cmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaTgtCd = this.qtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stpUcAmt = this.stpUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaRlseVerNo = this.mqtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoUcAmt = this.eqRepoUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyStvgUcAmt = this.mtyStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltMgmtUcAmt = this.sltMgmtUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raOpfitAmt = this.raOpfitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmAmt = this.cmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownVolActUcAmt = this.ownVolActUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullStvgUcAmt = this.fullStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon = this.mon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRlaneCd = this.newRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpMax = this.grpMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strFnlBsaCapa = this.strFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
