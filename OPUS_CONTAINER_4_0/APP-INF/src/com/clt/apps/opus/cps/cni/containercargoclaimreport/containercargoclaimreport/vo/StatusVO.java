/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusVO.java
*@FileTitle : StatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.02.05 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StatusVO> models = new ArrayList<StatusVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String slaverClmPtyAbbrNm = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slvUsdAmt = null;
	/* Column Info */
	private String insurPtyAbbrNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String pltNm = null;
	/* Column Info */
	private String lablClmPtyNo = null;
	/* Column Info */
	private String clmCgoTpNm = null;
	/* Column Info */
	private String lablPtyDmndAmt = null;
	/* Column Info */
	private String prlmClmNtcDt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String cgoClmRefBlNo = null;
	/* Column Info */
	private String apofc = null;
	/* Column Info */
	private String slvDt = null;
	/* Column Info */
	private String cgoClmDivCd = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String nhp = null;
	/* Column Info */
	private String legalCosts = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String sveyInpDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String hpd = null;
	/* Column Info */
	private String cgoClmAcknakDt = null;
	/* Column Info */
	private String crtCsNo = null;
	/* Column Info */
	private String agnClmPtyAbbrNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String fmalClmRcvOfcCd = null;
	/* Column Info */
	private String clmTmBarDt = null;
	/* Column Info */
	private String applicant = null;
	/* Column Info */
	private String minrClmDmgLssCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String lablPtyFmalClmDt = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String doav = null;
	/* Column Info */
	private String insurDmndAmt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String sveyClmPtyAbbrNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String period6 = null;
	/* Column Info */
	private String period5 = null;
	/* Column Info */
	private String period4 = null;
	/* Column Info */
	private String period3 = null;
	/* Column Info */
	private String period2 = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String period1 = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String insurFmalClmDt = null;
	/* Column Info */
	private String n1stPreTsLocCd = null;
	/* Column Info */
	private String fvd = null;
	/* Column Info */
	private String deftNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String avsts = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lit = null;
	/* Column Info */
	private String lablTmBarDt = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String clmPtyAbbrNm3 = null;
	/* Column Info */
	private String n1stPstTsLocCd = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String clmPtyAbbrNm2 = null;
	/* Column Info */
	private String approver = null;
	/* Column Info */
	private String clmPtyAbbrNm1 = null;
	/* Column Info */
	private String approvalNo = null;
	/* Column Info */
	private String crtNm = null;
	/* Column Info */
	private String insurRcvrAmt = null;
	/* Column Info */
	private String clmtClmTpCd = null;
	/* Column Info */
	private String deftAttyApntDt = null;
	/* Column Info */
	private String factFndDt = null;
	/* Column Info */
	private String cgoClmRefCntrNo = null;
	/* Column Info */
	private String insDor = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String avofc = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String svyrFeeUsdAmt = null;
	/* Column Info */
	private String hdlrUsrId1 = null;
	/* Column Info */
	private String hdlrUsrId2 = null;
	/* Column Info */
	private String doap = null;
	/* Column Info */
	private String clmAreaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StatusVO() {}

	public StatusVO(String ibflag, String pagerows, String cgoClmDivCd, String cgoClmNo, String clmAreaCd, String hdlrOfcCd, String fmalClmRcvOfcCd, String hdlrUsrId1, String hdlrUsrId2, String cgoClmStsCd, String lit, String csClzDt, String hpd, String nhp, String prlmClmNtcDt, String fmalClmRcvDt, String updDt, String clmtClmTpCd, String clmPtyAbbrNm1, String clmPtyAbbrNm2, String slanCd, String trnkRefVvdNo, String cgoClmRefBlNo, String cgoClmRefCntrNo, String tpSz, String cnt, String crrTermCd, String porCd, String rctDt, String polCd, String podCd, String delCd, String deDt, String clmTmBarDt, String lablTmBarDt, String fvd, String n1stPreTsLocCd, String n1stPstTsLocCd, String clmCgoTpNm, String cgoClmTpCd, String mjrClmDmgLssCd, String minrClmDmgLssCd, String clmtUsdAmt, String cgoClmAcknakDt, String factFndDt, String cgoClmStlTpCd, String cgoClmStlDt, String cgoClmStlUsdAmt, String inciPlcTpCd, String lablClmPtyNo, String hndlOfcCd, String lablPtyFmalClmDt, String lablPtyDmndAmt, String lablPtyRcvrDt, String lablPtyRcvrUsdAmt, String insurPtyAbbrNm, String insurFmalClmDt, String insurDmndAmt, String insDor, String insurRcvrAmt, String sveyClmPtyAbbrNm, String sveyInpDt, String svyrFeeUsdAmt, String slaverClmPtyAbbrNm, String slvDt, String slvUsdAmt, String applicant, String apofc, String doap, String approver, String avsts, String avofc, String doav, String approvalNo, String pltNm, String agnClmPtyAbbrNm, String crtNm, String crtCsNo, String smnsSveDt, String deftNm, String clmPtyAbbrNm3, String deftAttyApntDt, String legalCosts, String cgoClmInciNo, String crmVocNo, String period1, String period2, String period3, String period4, String period5, String period6, String rowNum, String total) {
		this.total = total;
		this.slaverClmPtyAbbrNm = slaverClmPtyAbbrNm;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.smnsSveDt = smnsSveDt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.slvUsdAmt = slvUsdAmt;
		this.insurPtyAbbrNm = insurPtyAbbrNm;
		this.polCd = polCd;
		this.pltNm = pltNm;
		this.lablClmPtyNo = lablClmPtyNo;
		this.clmCgoTpNm = clmCgoTpNm;
		this.lablPtyDmndAmt = lablPtyDmndAmt;
		this.prlmClmNtcDt = prlmClmNtcDt;
		this.cgoClmNo = cgoClmNo;
		this.cgoClmRefBlNo = cgoClmRefBlNo;
		this.apofc = apofc;
		this.slvDt = slvDt;
		this.cgoClmDivCd = cgoClmDivCd;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.nhp = nhp;
		this.legalCosts = legalCosts;
		this.tpSz = tpSz;
		this.sveyInpDt = sveyInpDt;
		this.delCd = delCd;
		this.hpd = hpd;
		this.cgoClmAcknakDt = cgoClmAcknakDt;
		this.crtCsNo = crtCsNo;
		this.agnClmPtyAbbrNm = agnClmPtyAbbrNm;
		this.podCd = podCd;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
		this.clmTmBarDt = clmTmBarDt;
		this.applicant = applicant;
		this.minrClmDmgLssCd = minrClmDmgLssCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.crmVocNo = crmVocNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
		this.cgoClmTpCd = cgoClmTpCd;
		this.rowNum = rowNum;
		this.doav = doav;
		this.insurDmndAmt = insurDmndAmt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.sveyClmPtyAbbrNm = sveyClmPtyAbbrNm;
		this.porCd = porCd;
		this.period6 = period6;
		this.period5 = period5;
		this.period4 = period4;
		this.period3 = period3;
		this.period2 = period2;
		this.csClzDt = csClzDt;
		this.period1 = period1;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.deDt = deDt;
		this.insurFmalClmDt = insurFmalClmDt;
		this.n1stPreTsLocCd = n1stPreTsLocCd;
		this.fvd = fvd;
		this.deftNm = deftNm;
		this.ibflag = ibflag;
		this.crrTermCd = crrTermCd;
		this.avsts = avsts;
		this.cgoClmStsCd = cgoClmStsCd;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.updDt = updDt;
		this.lit = lit;
		this.lablTmBarDt = lablTmBarDt;
		this.cnt = cnt;
		this.clmPtyAbbrNm3 = clmPtyAbbrNm3;
		this.n1stPstTsLocCd = n1stPstTsLocCd;
		this.cgoClmStlDt = cgoClmStlDt;
		this.clmPtyAbbrNm2 = clmPtyAbbrNm2;
		this.approver = approver;
		this.clmPtyAbbrNm1 = clmPtyAbbrNm1;
		this.approvalNo = approvalNo;
		this.crtNm = crtNm;
		this.insurRcvrAmt = insurRcvrAmt;
		this.clmtClmTpCd = clmtClmTpCd;
		this.deftAttyApntDt = deftAttyApntDt;
		this.factFndDt = factFndDt;
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
		this.insDor = insDor;
		this.slanCd = slanCd;
		this.avofc = avofc;
		this.rctDt = rctDt;
		this.cgoClmInciNo = cgoClmInciNo;
		this.svyrFeeUsdAmt = svyrFeeUsdAmt;
		this.hdlrUsrId1 = hdlrUsrId1;
		this.hdlrUsrId2 = hdlrUsrId2;
		this.doap = doap;
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("slaver_clm_pty_abbr_nm", getSlaverClmPtyAbbrNm());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("slv_usd_amt", getSlvUsdAmt());
		this.hashColumns.put("insur_pty_abbr_nm", getInsurPtyAbbrNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("plt_nm", getPltNm());
		this.hashColumns.put("labl_clm_pty_no", getLablClmPtyNo());
		this.hashColumns.put("clm_cgo_tp_nm", getClmCgoTpNm());
		this.hashColumns.put("labl_pty_dmnd_amt", getLablPtyDmndAmt());
		this.hashColumns.put("prlm_clm_ntc_dt", getPrlmClmNtcDt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("cgo_clm_ref_bl_no", getCgoClmRefBlNo());
		this.hashColumns.put("apofc", getApofc());
		this.hashColumns.put("slv_dt", getSlvDt());
		this.hashColumns.put("cgo_clm_div_cd", getCgoClmDivCd());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("nhp", getNhp());
		this.hashColumns.put("legal_costs", getLegalCosts());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("svey_inp_dt", getSveyInpDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("hpd", getHpd());
		this.hashColumns.put("cgo_clm_acknak_dt", getCgoClmAcknakDt());
		this.hashColumns.put("crt_cs_no", getCrtCsNo());
		this.hashColumns.put("agn_clm_pty_abbr_nm", getAgnClmPtyAbbrNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("fmal_clm_rcv_ofc_cd", getFmalClmRcvOfcCd());
		this.hashColumns.put("clm_tm_bar_dt", getClmTmBarDt());
		this.hashColumns.put("applicant", getApplicant());
		this.hashColumns.put("minr_clm_dmg_lss_cd", getMinrClmDmgLssCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("labl_pty_fmal_clm_dt", getLablPtyFmalClmDt());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("doav", getDoav());
		this.hashColumns.put("insur_dmnd_amt", getInsurDmndAmt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("svey_clm_pty_abbr_nm", getSveyClmPtyAbbrNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("period6", getPeriod6());
		this.hashColumns.put("period5", getPeriod5());
		this.hashColumns.put("period4", getPeriod4());
		this.hashColumns.put("period3", getPeriod3());
		this.hashColumns.put("period2", getPeriod2());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("period1", getPeriod1());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("insur_fmal_clm_dt", getInsurFmalClmDt());
		this.hashColumns.put("n1st_pre_ts_loc_cd", getN1stPreTsLocCd());
		this.hashColumns.put("fvd", getFvd());
		this.hashColumns.put("deft_nm", getDeftNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("avsts", getAvsts());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lit", getLit());
		this.hashColumns.put("labl_tm_bar_dt", getLablTmBarDt());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("clm_pty_abbr_nm3", getClmPtyAbbrNm3());
		this.hashColumns.put("n1st_pst_ts_loc_cd", getN1stPstTsLocCd());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("clm_pty_abbr_nm2", getClmPtyAbbrNm2());
		this.hashColumns.put("approver", getApprover());
		this.hashColumns.put("clm_pty_abbr_nm1", getClmPtyAbbrNm1());
		this.hashColumns.put("approval_no", getApprovalNo());
		this.hashColumns.put("crt_nm", getCrtNm());
		this.hashColumns.put("insur_rcvr_amt", getInsurRcvrAmt());
		this.hashColumns.put("clmt_clm_tp_cd", getClmtClmTpCd());
		this.hashColumns.put("deft_atty_apnt_dt", getDeftAttyApntDt());
		this.hashColumns.put("fact_fnd_dt", getFactFndDt());
		this.hashColumns.put("cgo_clm_ref_cntr_no", getCgoClmRefCntrNo());
		this.hashColumns.put("ins_dor", getInsDor());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("avofc", getAvofc());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("svyr_fee_usd_amt", getSvyrFeeUsdAmt());
		this.hashColumns.put("hdlr_usr_id1", getHdlrUsrId1());
		this.hashColumns.put("hdlr_usr_id2", getHdlrUsrId2());
		this.hashColumns.put("doap", getDoap());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("slaver_clm_pty_abbr_nm", "slaverClmPtyAbbrNm");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slv_usd_amt", "slvUsdAmt");
		this.hashFields.put("insur_pty_abbr_nm", "insurPtyAbbrNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("plt_nm", "pltNm");
		this.hashFields.put("labl_clm_pty_no", "lablClmPtyNo");
		this.hashFields.put("clm_cgo_tp_nm", "clmCgoTpNm");
		this.hashFields.put("labl_pty_dmnd_amt", "lablPtyDmndAmt");
		this.hashFields.put("prlm_clm_ntc_dt", "prlmClmNtcDt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("cgo_clm_ref_bl_no", "cgoClmRefBlNo");
		this.hashFields.put("apofc", "apofc");
		this.hashFields.put("slv_dt", "slvDt");
		this.hashFields.put("cgo_clm_div_cd", "cgoClmDivCd");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("nhp", "nhp");
		this.hashFields.put("legal_costs", "legalCosts");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("svey_inp_dt", "sveyInpDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("hpd", "hpd");
		this.hashFields.put("cgo_clm_acknak_dt", "cgoClmAcknakDt");
		this.hashFields.put("crt_cs_no", "crtCsNo");
		this.hashFields.put("agn_clm_pty_abbr_nm", "agnClmPtyAbbrNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("fmal_clm_rcv_ofc_cd", "fmalClmRcvOfcCd");
		this.hashFields.put("clm_tm_bar_dt", "clmTmBarDt");
		this.hashFields.put("applicant", "applicant");
		this.hashFields.put("minr_clm_dmg_lss_cd", "minrClmDmgLssCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("labl_pty_fmal_clm_dt", "lablPtyFmalClmDt");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("doav", "doav");
		this.hashFields.put("insur_dmnd_amt", "insurDmndAmt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("svey_clm_pty_abbr_nm", "sveyClmPtyAbbrNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("period6", "period6");
		this.hashFields.put("period5", "period5");
		this.hashFields.put("period4", "period4");
		this.hashFields.put("period3", "period3");
		this.hashFields.put("period2", "period2");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("period1", "period1");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("insur_fmal_clm_dt", "insurFmalClmDt");
		this.hashFields.put("n1st_pre_ts_loc_cd", "n1stPreTsLocCd");
		this.hashFields.put("fvd", "fvd");
		this.hashFields.put("deft_nm", "deftNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("avsts", "avsts");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lit", "lit");
		this.hashFields.put("labl_tm_bar_dt", "lablTmBarDt");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("clm_pty_abbr_nm3", "clmPtyAbbrNm3");
		this.hashFields.put("n1st_pst_ts_loc_cd", "n1stPstTsLocCd");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("clm_pty_abbr_nm2", "clmPtyAbbrNm2");
		this.hashFields.put("approver", "approver");
		this.hashFields.put("clm_pty_abbr_nm1", "clmPtyAbbrNm1");
		this.hashFields.put("approval_no", "approvalNo");
		this.hashFields.put("crt_nm", "crtNm");
		this.hashFields.put("insur_rcvr_amt", "insurRcvrAmt");
		this.hashFields.put("clmt_clm_tp_cd", "clmtClmTpCd");
		this.hashFields.put("deft_atty_apnt_dt", "deftAttyApntDt");
		this.hashFields.put("fact_fnd_dt", "factFndDt");
		this.hashFields.put("cgo_clm_ref_cntr_no", "cgoClmRefCntrNo");
		this.hashFields.put("ins_dor", "insDor");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("avofc", "avofc");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("svyr_fee_usd_amt", "svyrFeeUsdAmt");
		this.hashFields.put("hdlr_usr_id1", "hdlrUsrId1");
		this.hashFields.put("hdlr_usr_id2", "hdlrUsrId2");
		this.hashFields.put("doap", "doap");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return slaverClmPtyAbbrNm
	 */
	public String getSlaverClmPtyAbbrNm() {
		return this.slaverClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return smnsSveDt
	 */
	public String getSmnsSveDt() {
		return this.smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @return slvUsdAmt
	 */
	public String getSlvUsdAmt() {
		return this.slvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insurPtyAbbrNm
	 */
	public String getInsurPtyAbbrNm() {
		return this.insurPtyAbbrNm;
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
	 * @return pltNm
	 */
	public String getPltNm() {
		return this.pltNm;
	}
	
	/**
	 * Column Info
	 * @return lablClmPtyNo
	 */
	public String getLablClmPtyNo() {
		return this.lablClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return clmCgoTpNm
	 */
	public String getClmCgoTpNm() {
		return this.clmCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @return lablPtyDmndAmt
	 */
	public String getLablPtyDmndAmt() {
		return this.lablPtyDmndAmt;
	}
	
	/**
	 * Column Info
	 * @return prlmClmNtcDt
	 */
	public String getPrlmClmNtcDt() {
		return this.prlmClmNtcDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmRefBlNo
	 */
	public String getCgoClmRefBlNo() {
		return this.cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @return apofc
	 */
	public String getApofc() {
		return this.apofc;
	}
	
	/**
	 * Column Info
	 * @return slvDt
	 */
	public String getSlvDt() {
		return this.slvDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmDivCd
	 */
	public String getCgoClmDivCd() {
		return this.cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @return mjrClmDmgLssCd
	 */
	public String getMjrClmDmgLssCd() {
		return this.mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @return nhp
	 */
	public String getNhp() {
		return this.nhp;
	}
	
	/**
	 * Column Info
	 * @return legalCosts
	 */
	public String getLegalCosts() {
		return this.legalCosts;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return sveyInpDt
	 */
	public String getSveyInpDt() {
		return this.sveyInpDt;
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
	 * @return hpd
	 */
	public String getHpd() {
		return this.hpd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmAcknakDt
	 */
	public String getCgoClmAcknakDt() {
		return this.cgoClmAcknakDt;
	}
	
	/**
	 * Column Info
	 * @return crtCsNo
	 */
	public String getCrtCsNo() {
		return this.crtCsNo;
	}
	
	/**
	 * Column Info
	 * @return agnClmPtyAbbrNm
	 */
	public String getAgnClmPtyAbbrNm() {
		return this.agnClmPtyAbbrNm;
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
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvOfcCd
	 */
	public String getFmalClmRcvOfcCd() {
		return this.fmalClmRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmTmBarDt
	 */
	public String getClmTmBarDt() {
		return this.clmTmBarDt;
	}
	
	/**
	 * Column Info
	 * @return applicant
	 */
	public String getApplicant() {
		return this.applicant;
	}
	
	/**
	 * Column Info
	 * @return minrClmDmgLssCd
	 */
	public String getMinrClmDmgLssCd() {
		return this.minrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @return clmtUsdAmt
	 */
	public String getClmtUsdAmt() {
		return this.clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return crmVocNo
	 */
	public String getCrmVocNo() {
		return this.crmVocNo;
	}
	
	/**
	 * Column Info
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFmalClmDt
	 */
	public String getLablPtyFmalClmDt() {
		return this.lablPtyFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmTpCd
	 */
	public String getCgoClmTpCd() {
		return this.cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return doav
	 */
	public String getDoav() {
		return this.doav;
	}
	
	/**
	 * Column Info
	 * @return insurDmndAmt
	 */
	public String getInsurDmndAmt() {
		return this.insurDmndAmt;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sveyClmPtyAbbrNm
	 */
	public String getSveyClmPtyAbbrNm() {
		return this.sveyClmPtyAbbrNm;
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
	 * @return period6
	 */
	public String getPeriod6() {
		return this.period6;
	}
	
	/**
	 * Column Info
	 * @return period5
	 */
	public String getPeriod5() {
		return this.period5;
	}
	
	/**
	 * Column Info
	 * @return period4
	 */
	public String getPeriod4() {
		return this.period4;
	}
	
	/**
	 * Column Info
	 * @return period3
	 */
	public String getPeriod3() {
		return this.period3;
	}
	
	/**
	 * Column Info
	 * @return period2
	 */
	public String getPeriod2() {
		return this.period2;
	}
	
	/**
	 * Column Info
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
	}
	
	/**
	 * Column Info
	 * @return period1
	 */
	public String getPeriod1() {
		return this.period1;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrUsdAmt
	 */
	public String getLablPtyRcvrUsdAmt() {
		return this.lablPtyRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return deDt
	 */
	public String getDeDt() {
		return this.deDt;
	}
	
	/**
	 * Column Info
	 * @return insurFmalClmDt
	 */
	public String getInsurFmalClmDt() {
		return this.insurFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsLocCd
	 */
	public String getN1stPreTsLocCd() {
		return this.n1stPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return fvd
	 */
	public String getFvd() {
		return this.fvd;
	}
	
	/**
	 * Column Info
	 * @return deftNm
	 */
	public String getDeftNm() {
		return this.deftNm;
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
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
	}
	
	/**
	 * Column Info
	 * @return avsts
	 */
	public String getAvsts() {
		return this.avsts;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlUsdAmt
	 */
	public String getCgoClmStlUsdAmt() {
		return this.cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrDt
	 */
	public String getLablPtyRcvrDt() {
		return this.lablPtyRcvrDt;
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
	 * @return lit
	 */
	public String getLit() {
		return this.lit;
	}
	
	/**
	 * Column Info
	 * @return lablTmBarDt
	 */
	public String getLablTmBarDt() {
		return this.lablTmBarDt;
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
	 * @return clmPtyAbbrNm3
	 */
	public String getClmPtyAbbrNm3() {
		return this.clmPtyAbbrNm3;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsLocCd
	 */
	public String getN1stPstTsLocCd() {
		return this.n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm2
	 */
	public String getClmPtyAbbrNm2() {
		return this.clmPtyAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @return approver
	 */
	public String getApprover() {
		return this.approver;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm1
	 */
	public String getClmPtyAbbrNm1() {
		return this.clmPtyAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @return approvalNo
	 */
	public String getApprovalNo() {
		return this.approvalNo;
	}
	
	/**
	 * Column Info
	 * @return crtNm
	 */
	public String getCrtNm() {
		return this.crtNm;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrAmt
	 */
	public String getInsurRcvrAmt() {
		return this.insurRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @return clmtClmTpCd
	 */
	public String getClmtClmTpCd() {
		return this.clmtClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return deftAttyApntDt
	 */
	public String getDeftAttyApntDt() {
		return this.deftAttyApntDt;
	}
	
	/**
	 * Column Info
	 * @return factFndDt
	 */
	public String getFactFndDt() {
		return this.factFndDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmRefCntrNo
	 */
	public String getCgoClmRefCntrNo() {
		return this.cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @return insDor
	 */
	public String getInsDor() {
		return this.insDor;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return avofc
	 */
	public String getAvofc() {
		return this.avofc;
	}
	
	/**
	 * Column Info
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @return svyrFeeUsdAmt
	 */
	public String getSvyrFeeUsdAmt() {
		return this.svyrFeeUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId1
	 */
	public String getHdlrUsrId1() {
		return this.hdlrUsrId1;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId2
	 */
	public String getHdlrUsrId2() {
		return this.hdlrUsrId2;
	}
	
	/**
	 * Column Info
	 * @return doap
	 */
	public String getDoap() {
		return this.doap;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param slaverClmPtyAbbrNm
	 */
	public void setSlaverClmPtyAbbrNm(String slaverClmPtyAbbrNm) {
		this.slaverClmPtyAbbrNm = slaverClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param smnsSveDt
	 */
	public void setSmnsSveDt(String smnsSveDt) {
		this.smnsSveDt = smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
	 * @param slvUsdAmt
	 */
	public void setSlvUsdAmt(String slvUsdAmt) {
		this.slvUsdAmt = slvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insurPtyAbbrNm
	 */
	public void setInsurPtyAbbrNm(String insurPtyAbbrNm) {
		this.insurPtyAbbrNm = insurPtyAbbrNm;
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
	 * @param pltNm
	 */
	public void setPltNm(String pltNm) {
		this.pltNm = pltNm;
	}
	
	/**
	 * Column Info
	 * @param lablClmPtyNo
	 */
	public void setLablClmPtyNo(String lablClmPtyNo) {
		this.lablClmPtyNo = lablClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param clmCgoTpNm
	 */
	public void setClmCgoTpNm(String clmCgoTpNm) {
		this.clmCgoTpNm = clmCgoTpNm;
	}
	
	/**
	 * Column Info
	 * @param lablPtyDmndAmt
	 */
	public void setLablPtyDmndAmt(String lablPtyDmndAmt) {
		this.lablPtyDmndAmt = lablPtyDmndAmt;
	}
	
	/**
	 * Column Info
	 * @param prlmClmNtcDt
	 */
	public void setPrlmClmNtcDt(String prlmClmNtcDt) {
		this.prlmClmNtcDt = prlmClmNtcDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmRefBlNo
	 */
	public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
		this.cgoClmRefBlNo = cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @param apofc
	 */
	public void setApofc(String apofc) {
		this.apofc = apofc;
	}
	
	/**
	 * Column Info
	 * @param slvDt
	 */
	public void setSlvDt(String slvDt) {
		this.slvDt = slvDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmDivCd
	 */
	public void setCgoClmDivCd(String cgoClmDivCd) {
		this.cgoClmDivCd = cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @param mjrClmDmgLssCd
	 */
	public void setMjrClmDmgLssCd(String mjrClmDmgLssCd) {
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @param nhp
	 */
	public void setNhp(String nhp) {
		this.nhp = nhp;
	}
	
	/**
	 * Column Info
	 * @param legalCosts
	 */
	public void setLegalCosts(String legalCosts) {
		this.legalCosts = legalCosts;
	}
	
	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param sveyInpDt
	 */
	public void setSveyInpDt(String sveyInpDt) {
		this.sveyInpDt = sveyInpDt;
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
	 * @param hpd
	 */
	public void setHpd(String hpd) {
		this.hpd = hpd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmAcknakDt
	 */
	public void setCgoClmAcknakDt(String cgoClmAcknakDt) {
		this.cgoClmAcknakDt = cgoClmAcknakDt;
	}
	
	/**
	 * Column Info
	 * @param crtCsNo
	 */
	public void setCrtCsNo(String crtCsNo) {
		this.crtCsNo = crtCsNo;
	}
	
	/**
	 * Column Info
	 * @param agnClmPtyAbbrNm
	 */
	public void setAgnClmPtyAbbrNm(String agnClmPtyAbbrNm) {
		this.agnClmPtyAbbrNm = agnClmPtyAbbrNm;
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
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvOfcCd
	 */
	public void setFmalClmRcvOfcCd(String fmalClmRcvOfcCd) {
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmTmBarDt
	 */
	public void setClmTmBarDt(String clmTmBarDt) {
		this.clmTmBarDt = clmTmBarDt;
	}
	
	/**
	 * Column Info
	 * @param applicant
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	
	/**
	 * Column Info
	 * @param minrClmDmgLssCd
	 */
	public void setMinrClmDmgLssCd(String minrClmDmgLssCd) {
		this.minrClmDmgLssCd = minrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @param clmtUsdAmt
	 */
	public void setClmtUsdAmt(String clmtUsdAmt) {
		this.clmtUsdAmt = clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param crmVocNo
	 */
	public void setCrmVocNo(String crmVocNo) {
		this.crmVocNo = crmVocNo;
	}
	
	/**
	 * Column Info
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFmalClmDt
	 */
	public void setLablPtyFmalClmDt(String lablPtyFmalClmDt) {
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmTpCd
	 */
	public void setCgoClmTpCd(String cgoClmTpCd) {
		this.cgoClmTpCd = cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param doav
	 */
	public void setDoav(String doav) {
		this.doav = doav;
	}
	
	/**
	 * Column Info
	 * @param insurDmndAmt
	 */
	public void setInsurDmndAmt(String insurDmndAmt) {
		this.insurDmndAmt = insurDmndAmt;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sveyClmPtyAbbrNm
	 */
	public void setSveyClmPtyAbbrNm(String sveyClmPtyAbbrNm) {
		this.sveyClmPtyAbbrNm = sveyClmPtyAbbrNm;
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
	 * @param period6
	 */
	public void setPeriod6(String period6) {
		this.period6 = period6;
	}
	
	/**
	 * Column Info
	 * @param period5
	 */
	public void setPeriod5(String period5) {
		this.period5 = period5;
	}
	
	/**
	 * Column Info
	 * @param period4
	 */
	public void setPeriod4(String period4) {
		this.period4 = period4;
	}
	
	/**
	 * Column Info
	 * @param period3
	 */
	public void setPeriod3(String period3) {
		this.period3 = period3;
	}
	
	/**
	 * Column Info
	 * @param period2
	 */
	public void setPeriod2(String period2) {
		this.period2 = period2;
	}
	
	/**
	 * Column Info
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
	}
	
	/**
	 * Column Info
	 * @param period1
	 */
	public void setPeriod1(String period1) {
		this.period1 = period1;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrUsdAmt
	 */
	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param deDt
	 */
	public void setDeDt(String deDt) {
		this.deDt = deDt;
	}
	
	/**
	 * Column Info
	 * @param insurFmalClmDt
	 */
	public void setInsurFmalClmDt(String insurFmalClmDt) {
		this.insurFmalClmDt = insurFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsLocCd
	 */
	public void setN1stPreTsLocCd(String n1stPreTsLocCd) {
		this.n1stPreTsLocCd = n1stPreTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param fvd
	 */
	public void setFvd(String fvd) {
		this.fvd = fvd;
	}
	
	/**
	 * Column Info
	 * @param deftNm
	 */
	public void setDeftNm(String deftNm) {
		this.deftNm = deftNm;
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
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
	}
	
	/**
	 * Column Info
	 * @param avsts
	 */
	public void setAvsts(String avsts) {
		this.avsts = avsts;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlUsdAmt
	 */
	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrDt
	 */
	public void setLablPtyRcvrDt(String lablPtyRcvrDt) {
		this.lablPtyRcvrDt = lablPtyRcvrDt;
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
	 * @param lit
	 */
	public void setLit(String lit) {
		this.lit = lit;
	}
	
	/**
	 * Column Info
	 * @param lablTmBarDt
	 */
	public void setLablTmBarDt(String lablTmBarDt) {
		this.lablTmBarDt = lablTmBarDt;
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
	 * @param clmPtyAbbrNm3
	 */
	public void setClmPtyAbbrNm3(String clmPtyAbbrNm3) {
		this.clmPtyAbbrNm3 = clmPtyAbbrNm3;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsLocCd
	 */
	public void setN1stPstTsLocCd(String n1stPstTsLocCd) {
		this.n1stPstTsLocCd = n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm2
	 */
	public void setClmPtyAbbrNm2(String clmPtyAbbrNm2) {
		this.clmPtyAbbrNm2 = clmPtyAbbrNm2;
	}
	
	/**
	 * Column Info
	 * @param approver
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm1
	 */
	public void setClmPtyAbbrNm1(String clmPtyAbbrNm1) {
		this.clmPtyAbbrNm1 = clmPtyAbbrNm1;
	}
	
	/**
	 * Column Info
	 * @param approvalNo
	 */
	public void setApprovalNo(String approvalNo) {
		this.approvalNo = approvalNo;
	}
	
	/**
	 * Column Info
	 * @param crtNm
	 */
	public void setCrtNm(String crtNm) {
		this.crtNm = crtNm;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrAmt
	 */
	public void setInsurRcvrAmt(String insurRcvrAmt) {
		this.insurRcvrAmt = insurRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @param clmtClmTpCd
	 */
	public void setClmtClmTpCd(String clmtClmTpCd) {
		this.clmtClmTpCd = clmtClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param deftAttyApntDt
	 */
	public void setDeftAttyApntDt(String deftAttyApntDt) {
		this.deftAttyApntDt = deftAttyApntDt;
	}
	
	/**
	 * Column Info
	 * @param factFndDt
	 */
	public void setFactFndDt(String factFndDt) {
		this.factFndDt = factFndDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmRefCntrNo
	 */
	public void setCgoClmRefCntrNo(String cgoClmRefCntrNo) {
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @param insDor
	 */
	public void setInsDor(String insDor) {
		this.insDor = insDor;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param avofc
	 */
	public void setAvofc(String avofc) {
		this.avofc = avofc;
	}
	
	/**
	 * Column Info
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @param svyrFeeUsdAmt
	 */
	public void setSvyrFeeUsdAmt(String svyrFeeUsdAmt) {
		this.svyrFeeUsdAmt = svyrFeeUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId1
	 */
	public void setHdlrUsrId1(String hdlrUsrId1) {
		this.hdlrUsrId1 = hdlrUsrId1;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId2
	 */
	public void setHdlrUsrId2(String hdlrUsrId2) {
		this.hdlrUsrId2 = hdlrUsrId2;
	}
	
	/**
	 * Column Info
	 * @param doap
	 */
	public void setDoap(String doap) {
		this.doap = doap;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setSlaverClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "slaver_clm_pty_abbr_nm", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, prefix + "smns_sve_dt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSlvUsdAmt(JSPUtil.getParameter(request, prefix + "slv_usd_amt", ""));
		setInsurPtyAbbrNm(JSPUtil.getParameter(request, prefix + "insur_pty_abbr_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPltNm(JSPUtil.getParameter(request, prefix + "plt_nm", ""));
		setLablClmPtyNo(JSPUtil.getParameter(request, prefix + "labl_clm_pty_no", ""));
		setClmCgoTpNm(JSPUtil.getParameter(request, prefix + "clm_cgo_tp_nm", ""));
		setLablPtyDmndAmt(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_amt", ""));
		setPrlmClmNtcDt(JSPUtil.getParameter(request, prefix + "prlm_clm_ntc_dt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setCgoClmRefBlNo(JSPUtil.getParameter(request, prefix + "cgo_clm_ref_bl_no", ""));
		setApofc(JSPUtil.getParameter(request, prefix + "apofc", ""));
		setSlvDt(JSPUtil.getParameter(request, prefix + "slv_dt", ""));
		setCgoClmDivCd(JSPUtil.getParameter(request, prefix + "cgo_clm_div_cd", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "mjr_clm_dmg_lss_cd", ""));
		setNhp(JSPUtil.getParameter(request, prefix + "nhp", ""));
		setLegalCosts(JSPUtil.getParameter(request, prefix + "legal_costs", ""));
		setTpSz(JSPUtil.getParameter(request, prefix + "tp_sz", ""));
		setSveyInpDt(JSPUtil.getParameter(request, prefix + "svey_inp_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setHpd(JSPUtil.getParameter(request, prefix + "hpd", ""));
		setCgoClmAcknakDt(JSPUtil.getParameter(request, prefix + "cgo_clm_acknak_dt", ""));
		setCrtCsNo(JSPUtil.getParameter(request, prefix + "crt_cs_no", ""));
		setAgnClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "agn_clm_pty_abbr_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_tp_cd", ""));
		setFmalClmRcvOfcCd(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_ofc_cd", ""));
		setClmTmBarDt(JSPUtil.getParameter(request, prefix + "clm_tm_bar_dt", ""));
		setApplicant(JSPUtil.getParameter(request, prefix + "applicant", ""));
		setMinrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "minr_clm_dmg_lss_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setCrmVocNo(JSPUtil.getParameter(request, prefix + "crm_voc_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setLablPtyFmalClmDt(JSPUtil.getParameter(request, prefix + "labl_pty_fmal_clm_dt", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_tp_cd", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setDoav(JSPUtil.getParameter(request, prefix + "doav", ""));
		setInsurDmndAmt(JSPUtil.getParameter(request, prefix + "insur_dmnd_amt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setSveyClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "svey_clm_pty_abbr_nm", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPeriod6(JSPUtil.getParameter(request, prefix + "period6", ""));
		setPeriod5(JSPUtil.getParameter(request, prefix + "period5", ""));
		setPeriod4(JSPUtil.getParameter(request, prefix + "period4", ""));
		setPeriod3(JSPUtil.getParameter(request, prefix + "period3", ""));
		setPeriod2(JSPUtil.getParameter(request, prefix + "period2", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setPeriod1(JSPUtil.getParameter(request, prefix + "period1", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setDeDt(JSPUtil.getParameter(request, prefix + "de_dt", ""));
		setInsurFmalClmDt(JSPUtil.getParameter(request, prefix + "insur_fmal_clm_dt", ""));
		setN1stPreTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pre_ts_loc_cd", ""));
		setFvd(JSPUtil.getParameter(request, prefix + "fvd", ""));
		setDeftNm(JSPUtil.getParameter(request, prefix + "deft_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrrTermCd(JSPUtil.getParameter(request, prefix + "crr_term_cd", ""));
		setAvsts(JSPUtil.getParameter(request, prefix + "avsts", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_usd_amt", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLit(JSPUtil.getParameter(request, prefix + "lit", ""));
		setLablTmBarDt(JSPUtil.getParameter(request, prefix + "labl_tm_bar_dt", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setClmPtyAbbrNm3(JSPUtil.getParameter(request, prefix + "clm_pty_abbr_nm3", ""));
		setN1stPstTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pst_ts_loc_cd", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_dt", ""));
		setClmPtyAbbrNm2(JSPUtil.getParameter(request, prefix + "clm_pty_abbr_nm2", ""));
		setApprover(JSPUtil.getParameter(request, prefix + "approver", ""));
		setClmPtyAbbrNm1(JSPUtil.getParameter(request, prefix + "clm_pty_abbr_nm1", ""));
		setApprovalNo(JSPUtil.getParameter(request, prefix + "approval_no", ""));
		setCrtNm(JSPUtil.getParameter(request, prefix + "crt_nm", ""));
		setInsurRcvrAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_amt", ""));
		setClmtClmTpCd(JSPUtil.getParameter(request, prefix + "clmt_clm_tp_cd", ""));
		setDeftAttyApntDt(JSPUtil.getParameter(request, prefix + "deft_atty_apnt_dt", ""));
		setFactFndDt(JSPUtil.getParameter(request, prefix + "fact_fnd_dt", ""));
		setCgoClmRefCntrNo(JSPUtil.getParameter(request, prefix + "cgo_clm_ref_cntr_no", ""));
		setInsDor(JSPUtil.getParameter(request, prefix + "ins_dor", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setAvofc(JSPUtil.getParameter(request, prefix + "avofc", ""));
		setRctDt(JSPUtil.getParameter(request, prefix + "rct_dt", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, prefix + "cgo_clm_inci_no", ""));
		setSvyrFeeUsdAmt(JSPUtil.getParameter(request, prefix + "svyr_fee_usd_amt", ""));
		setHdlrUsrId1(JSPUtil.getParameter(request, prefix + "hdlr_usr_id1", ""));
		setHdlrUsrId2(JSPUtil.getParameter(request, prefix + "hdlr_usr_id2", ""));
		setDoap(JSPUtil.getParameter(request, prefix + "doap", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusVO[]
	 */
	public StatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusVO[]
	 */
	public StatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] slaverClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "slaver_clm_pty_abbr_nm", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "slv_usd_amt", length));
			String[] insurPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "insur_pty_abbr_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pltNm = (JSPUtil.getParameter(request, prefix	+ "plt_nm", length));
			String[] lablClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "labl_clm_pty_no", length));
			String[] clmCgoTpNm = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_nm", length));
			String[] lablPtyDmndAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_amt", length));
			String[] prlmClmNtcDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntc_dt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] cgoClmRefBlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_bl_no", length));
			String[] apofc = (JSPUtil.getParameter(request, prefix	+ "apofc", length));
			String[] slvDt = (JSPUtil.getParameter(request, prefix	+ "slv_dt", length));
			String[] cgoClmDivCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_cd", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] nhp = (JSPUtil.getParameter(request, prefix	+ "nhp", length));
			String[] legalCosts = (JSPUtil.getParameter(request, prefix	+ "legal_costs", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] sveyInpDt = (JSPUtil.getParameter(request, prefix	+ "svey_inp_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] hpd = (JSPUtil.getParameter(request, prefix	+ "hpd", length));
			String[] cgoClmAcknakDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_acknak_dt", length));
			String[] crtCsNo = (JSPUtil.getParameter(request, prefix	+ "crt_cs_no", length));
			String[] agnClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "agn_clm_pty_abbr_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] fmalClmRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_ofc_cd", length));
			String[] clmTmBarDt = (JSPUtil.getParameter(request, prefix	+ "clm_tm_bar_dt", length));
			String[] applicant = (JSPUtil.getParameter(request, prefix	+ "applicant", length));
			String[] minrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "minr_clm_dmg_lss_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] lablPtyFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_fmal_clm_dt", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] doav = (JSPUtil.getParameter(request, prefix	+ "doav", length));
			String[] insurDmndAmt = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_amt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] sveyClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "svey_clm_pty_abbr_nm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] period6 = (JSPUtil.getParameter(request, prefix	+ "period6", length));
			String[] period5 = (JSPUtil.getParameter(request, prefix	+ "period5", length));
			String[] period4 = (JSPUtil.getParameter(request, prefix	+ "period4", length));
			String[] period3 = (JSPUtil.getParameter(request, prefix	+ "period3", length));
			String[] period2 = (JSPUtil.getParameter(request, prefix	+ "period2", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] period1 = (JSPUtil.getParameter(request, prefix	+ "period1", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] insurFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "insur_fmal_clm_dt", length));
			String[] n1stPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_loc_cd", length));
			String[] fvd = (JSPUtil.getParameter(request, prefix	+ "fvd", length));
			String[] deftNm = (JSPUtil.getParameter(request, prefix	+ "deft_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] avsts = (JSPUtil.getParameter(request, prefix	+ "avsts", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lit = (JSPUtil.getParameter(request, prefix	+ "lit", length));
			String[] lablTmBarDt = (JSPUtil.getParameter(request, prefix	+ "labl_tm_bar_dt", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] clmPtyAbbrNm3 = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm3", length));
			String[] n1stPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_loc_cd", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] clmPtyAbbrNm2 = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm2", length));
			String[] approver = (JSPUtil.getParameter(request, prefix	+ "approver", length));
			String[] clmPtyAbbrNm1 = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm1", length));
			String[] approvalNo = (JSPUtil.getParameter(request, prefix	+ "approval_no", length));
			String[] crtNm = (JSPUtil.getParameter(request, prefix	+ "crt_nm", length));
			String[] insurRcvrAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_amt", length));
			String[] clmtClmTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_tp_cd", length));
			String[] deftAttyApntDt = (JSPUtil.getParameter(request, prefix	+ "deft_atty_apnt_dt", length));
			String[] factFndDt = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_dt", length));
			String[] cgoClmRefCntrNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_cntr_no", length));
			String[] insDor = (JSPUtil.getParameter(request, prefix	+ "ins_dor", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] avofc = (JSPUtil.getParameter(request, prefix	+ "avofc", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] svyrFeeUsdAmt = (JSPUtil.getParameter(request, prefix	+ "svyr_fee_usd_amt", length));
			String[] hdlrUsrId1 = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id1", length));
			String[] hdlrUsrId2 = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id2", length));
			String[] doap = (JSPUtil.getParameter(request, prefix	+ "doap", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new StatusVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (slaverClmPtyAbbrNm[i] != null)
					model.setSlaverClmPtyAbbrNm(slaverClmPtyAbbrNm[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slvUsdAmt[i] != null)
					model.setSlvUsdAmt(slvUsdAmt[i]);
				if (insurPtyAbbrNm[i] != null)
					model.setInsurPtyAbbrNm(insurPtyAbbrNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pltNm[i] != null)
					model.setPltNm(pltNm[i]);
				if (lablClmPtyNo[i] != null)
					model.setLablClmPtyNo(lablClmPtyNo[i]);
				if (clmCgoTpNm[i] != null)
					model.setClmCgoTpNm(clmCgoTpNm[i]);
				if (lablPtyDmndAmt[i] != null)
					model.setLablPtyDmndAmt(lablPtyDmndAmt[i]);
				if (prlmClmNtcDt[i] != null)
					model.setPrlmClmNtcDt(prlmClmNtcDt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (cgoClmRefBlNo[i] != null)
					model.setCgoClmRefBlNo(cgoClmRefBlNo[i]);
				if (apofc[i] != null)
					model.setApofc(apofc[i]);
				if (slvDt[i] != null)
					model.setSlvDt(slvDt[i]);
				if (cgoClmDivCd[i] != null)
					model.setCgoClmDivCd(cgoClmDivCd[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (nhp[i] != null)
					model.setNhp(nhp[i]);
				if (legalCosts[i] != null)
					model.setLegalCosts(legalCosts[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (sveyInpDt[i] != null)
					model.setSveyInpDt(sveyInpDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (hpd[i] != null)
					model.setHpd(hpd[i]);
				if (cgoClmAcknakDt[i] != null)
					model.setCgoClmAcknakDt(cgoClmAcknakDt[i]);
				if (crtCsNo[i] != null)
					model.setCrtCsNo(crtCsNo[i]);
				if (agnClmPtyAbbrNm[i] != null)
					model.setAgnClmPtyAbbrNm(agnClmPtyAbbrNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (fmalClmRcvOfcCd[i] != null)
					model.setFmalClmRcvOfcCd(fmalClmRcvOfcCd[i]);
				if (clmTmBarDt[i] != null)
					model.setClmTmBarDt(clmTmBarDt[i]);
				if (applicant[i] != null)
					model.setApplicant(applicant[i]);
				if (minrClmDmgLssCd[i] != null)
					model.setMinrClmDmgLssCd(minrClmDmgLssCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (lablPtyFmalClmDt[i] != null)
					model.setLablPtyFmalClmDt(lablPtyFmalClmDt[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (doav[i] != null)
					model.setDoav(doav[i]);
				if (insurDmndAmt[i] != null)
					model.setInsurDmndAmt(insurDmndAmt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (sveyClmPtyAbbrNm[i] != null)
					model.setSveyClmPtyAbbrNm(sveyClmPtyAbbrNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (period6[i] != null)
					model.setPeriod6(period6[i]);
				if (period5[i] != null)
					model.setPeriod5(period5[i]);
				if (period4[i] != null)
					model.setPeriod4(period4[i]);
				if (period3[i] != null)
					model.setPeriod3(period3[i]);
				if (period2[i] != null)
					model.setPeriod2(period2[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (period1[i] != null)
					model.setPeriod1(period1[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (insurFmalClmDt[i] != null)
					model.setInsurFmalClmDt(insurFmalClmDt[i]);
				if (n1stPreTsLocCd[i] != null)
					model.setN1stPreTsLocCd(n1stPreTsLocCd[i]);
				if (fvd[i] != null)
					model.setFvd(fvd[i]);
				if (deftNm[i] != null)
					model.setDeftNm(deftNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (avsts[i] != null)
					model.setAvsts(avsts[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lit[i] != null)
					model.setLit(lit[i]);
				if (lablTmBarDt[i] != null)
					model.setLablTmBarDt(lablTmBarDt[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (clmPtyAbbrNm3[i] != null)
					model.setClmPtyAbbrNm3(clmPtyAbbrNm3[i]);
				if (n1stPstTsLocCd[i] != null)
					model.setN1stPstTsLocCd(n1stPstTsLocCd[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (clmPtyAbbrNm2[i] != null)
					model.setClmPtyAbbrNm2(clmPtyAbbrNm2[i]);
				if (approver[i] != null)
					model.setApprover(approver[i]);
				if (clmPtyAbbrNm1[i] != null)
					model.setClmPtyAbbrNm1(clmPtyAbbrNm1[i]);
				if (approvalNo[i] != null)
					model.setApprovalNo(approvalNo[i]);
				if (crtNm[i] != null)
					model.setCrtNm(crtNm[i]);
				if (insurRcvrAmt[i] != null)
					model.setInsurRcvrAmt(insurRcvrAmt[i]);
				if (clmtClmTpCd[i] != null)
					model.setClmtClmTpCd(clmtClmTpCd[i]);
				if (deftAttyApntDt[i] != null)
					model.setDeftAttyApntDt(deftAttyApntDt[i]);
				if (factFndDt[i] != null)
					model.setFactFndDt(factFndDt[i]);
				if (cgoClmRefCntrNo[i] != null)
					model.setCgoClmRefCntrNo(cgoClmRefCntrNo[i]);
				if (insDor[i] != null)
					model.setInsDor(insDor[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (avofc[i] != null)
					model.setAvofc(avofc[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (svyrFeeUsdAmt[i] != null)
					model.setSvyrFeeUsdAmt(svyrFeeUsdAmt[i]);
				if (hdlrUsrId1[i] != null)
					model.setHdlrUsrId1(hdlrUsrId1[i]);
				if (hdlrUsrId2[i] != null)
					model.setHdlrUsrId2(hdlrUsrId2[i]);
				if (doap[i] != null)
					model.setDoap(doap[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StatusVO[]
	 */
	public StatusVO[] getStatusVOs(){
		StatusVO[] vos = (StatusVO[])models.toArray(new StatusVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slaverClmPtyAbbrNm = this.slaverClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvUsdAmt = this.slvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPtyAbbrNm = this.insurPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltNm = this.pltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablClmPtyNo = this.lablClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpNm = this.clmCgoTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndAmt = this.lablPtyDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtcDt = this.prlmClmNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefBlNo = this.cgoClmRefBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apofc = this.apofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slvDt = this.slvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivCd = this.cgoClmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nhp = this.nhp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legalCosts = this.legalCosts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyInpDt = this.sveyInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpd = this.hpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmAcknakDt = this.cgoClmAcknakDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCsNo = this.crtCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnClmPtyAbbrNm = this.agnClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvOfcCd = this.fmalClmRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTmBarDt = this.clmTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applicant = this.applicant .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minrClmDmgLssCd = this.minrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFmalClmDt = this.lablPtyFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doav = this.doav .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndAmt = this.insurDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyClmPtyAbbrNm = this.sveyClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period6 = this.period6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period5 = this.period5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period4 = this.period4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period3 = this.period3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period2 = this.period2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period1 = this.period1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFmalClmDt = this.insurFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsLocCd = this.n1stPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fvd = this.fvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftNm = this.deftNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avsts = this.avsts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lit = this.lit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablTmBarDt = this.lablTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm3 = this.clmPtyAbbrNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsLocCd = this.n1stPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm2 = this.clmPtyAbbrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approver = this.approver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm1 = this.clmPtyAbbrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalNo = this.approvalNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtNm = this.crtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrAmt = this.insurRcvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmTpCd = this.clmtClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyApntDt = this.deftAttyApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factFndDt = this.factFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefCntrNo = this.cgoClmRefCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insDor = this.insDor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avofc = this.avofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrFeeUsdAmt = this.svyrFeeUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId1 = this.hdlrUsrId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId2 = this.hdlrUsrId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doap = this.doap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
