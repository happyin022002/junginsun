/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchBookingTrendReportVO.java
*@FileTitle : SearchBookingTrendReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.06.18 김태경 
* 1.0 Creation
* -----------------------------------------------------------------
* History
* 2010.10.08 김영철 [CHM-201006186-01] 
*   1. 조회조건으로 Contract Office및  Sales Rep.조건 추가
*   2. Direct Down Load(B/L Detail) List상에 Contract Office및 Contract Sales Rep. 추가반영 및 일부항목 Label수정
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBookingTrendReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBookingTrendReportVO> models = new ArrayList<SearchBookingTrendReportVO>();
	
	/* Column Info */
	private String vvdSig = null;
	/* Column Info */
	private String etdWk = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String disOp = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String d6 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cFeu = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String cTeu = null;
	/* Column Info */
	private String d1 = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String d3 = null;
	/* Column Info */
	private String selObSrepCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String selVvd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String grpOp = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String fromWk = null;
	/* Column Info */
	private String selEtdDt = null;
	/* Column Info */
	private String trnkVvdCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgCreWk = null;
	/* Column Info */
	private String cmpb = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String d12 = null;
	/* Column Info */
	private String d11 = null;
	/* Column Info */
	private String unitOp = null;
	/* Column Info */
	private String polEtdFrDt = null;
	/* Column Info */
	private String cntrTpSz = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String d14 = null;
	/* Column Info */
	private String d13 = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String d10 = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String selSlanCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String bkgOfcSub = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String sBkgOfcCd = null;
	/* Column Info */
	private String chkCxlBkgOnly = null;
	/* Column Info */
	private String obSlsOfcSub = null;
	/* Column Info */
	private String sTrade = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bkgCxlDt = null;
	/* Column Info */
	private String toWk = null;
	/* Column Info */
	private String disVal = null;
	/* Column Info */
	private String selCustCd = null;
	/* Column Info */
	private String coaYear = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String bkgCxlWk = null;
	/* Column Info */
	private String vvdSlanCd = null;
	/* Column Info */
	private String bkgCxlFrDt = null;
	/* Column Info */
	private String cmCur = null;
	/* Column Info */
	private String bkgCxlToDt = null;
	/* Column Info */
	private String selOp = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String selCostWk = null;
	/* Column Info */
	private String selPolCd = null;
	/* Column Info */
	private String pkTp = null;
	/* Column Info */
	private String disDays = null;
	/* Column Info */
	private String polEtdToDt = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String ctrtOfcSub = null;
	/* Column Info */
	private String ctrtSrepCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBookingTrendReportVO() {}

	public SearchBookingTrendReportVO(String ibflag, String pagerows, String vvd, String blNo, String slanCd, String porCd, String polCd, String podCd, String delCd, String etdDt, String etdWk, String costWk, String custCntCd, String custSeq, String custNm, String load, String cm, String cmpb, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9, String d10, String d11, String d12, String d13, String d14, String pkTp, String vvdSig, String coaYear, String fromWk, String toWk, String trade, String sTrade, String obSlsOfcCd, String obSlsOfcSub, String obSrepCd, String bkgOfcCd, String bkgOfcSub, String custCd, String disOp, String disVal, String unitOp, String cmCur, String disDays, String selOp, String grpOp, String bkgCxlFrDt, String bkgCxlToDt, String chkCxlBkgOnly, String bkgStsCd, String vvdSlanCd, String bkgCreDt, String bkgCreWk, String bkgCxlDt, String bkgCxlWk, String cmdtCd, String cmdtNm, String interRmk, String xterRmk, String cTeu, String cFeu, String bkgNo, String trnkVvdCd, String cntrTpSz, String polEtdFrDt, String polEtdToDt, String selSlanCd, String selVvd, String selPolCd, String selEtdDt, String selCostWk, String selObSrepCd, String selCustCd, String sBkgOfcCd, String scNo, String rfaNo, String taaNo, String ctrtOfcCd, String ctrtOfcSub, String ctrtSrepCd) {
		this.vvdSig = vvdSig;
		this.etdWk = etdWk;
		this.d9 = d9;
		this.d8 = d8;
		this.disOp = disOp;
		this.d5 = d5;
		this.d4 = d4;
		this.blNo = blNo;
		this.d7 = d7;
		this.d6 = d6;
		this.pagerows = pagerows;
		this.cFeu = cFeu;
		this.obSrepCd = obSrepCd;
		this.cTeu = cTeu;
		this.d1 = d1;
		this.d2 = d2;
		this.polCd = polCd;
		this.d3 = d3;
		this.selObSrepCd = selObSrepCd;
		this.scNo = scNo;
		this.selVvd = selVvd;
		this.bkgCreDt = bkgCreDt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.custCntCd = custCntCd;
		this.grpOp = grpOp;
		this.bkgOfcCd = bkgOfcCd;
		this.fromWk = fromWk;
		this.selEtdDt = selEtdDt;
		this.trnkVvdCd = trnkVvdCd;
		this.delCd = delCd;
		this.bkgCreWk = bkgCreWk;
		this.cmpb = cmpb;
		this.vvd = vvd;
		this.podCd = podCd;
		this.d12 = d12;
		this.d11 = d11;
		this.unitOp = unitOp;
		this.polEtdFrDt = polEtdFrDt;
		this.cntrTpSz = cntrTpSz;
		this.bkgNo = bkgNo;
		this.d14 = d14;
		this.d13 = d13;
		this.cm = cm;
		this.costWk = costWk;
		this.d10 = d10;
		this.custCd = custCd;
		this.xterRmk = xterRmk;
		this.load = load;
		this.selSlanCd = selSlanCd;
		this.porCd = porCd;
		this.custNm = custNm;
		this.trade = trade;
		this.bkgOfcSub = bkgOfcSub;
		this.bkgStsCd = bkgStsCd;
		this.sBkgOfcCd = sBkgOfcCd;
		this.chkCxlBkgOnly = chkCxlBkgOnly;
		this.obSlsOfcSub = obSlsOfcSub;
		this.sTrade = sTrade;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.interRmk = interRmk;
		this.cmdtCd = cmdtCd;
		this.bkgCxlDt = bkgCxlDt;
		this.toWk = toWk;
		this.disVal = disVal;
		this.selCustCd = selCustCd;
		this.coaYear = coaYear;
		this.etdDt = etdDt;
		this.custSeq = custSeq;
		this.cmdtNm = cmdtNm;
		this.bkgCxlWk = bkgCxlWk;
		this.vvdSlanCd = vvdSlanCd;
		this.bkgCxlFrDt = bkgCxlFrDt;
		this.cmCur = cmCur;
		this.bkgCxlToDt = bkgCxlToDt;
		this.selOp = selOp;
		this.slanCd = slanCd;
		this.taaNo = taaNo;
		this.selCostWk = selCostWk;
		this.selPolCd = selPolCd;
		this.pkTp = pkTp;
		this.disDays = disDays;
		this.polEtdToDt = polEtdToDt;
		this.ctrtOfcCd = ctrtOfcCd;
		this.ctrtOfcSub = ctrtOfcSub;
		this.ctrtSrepCd = ctrtSrepCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_sig", getVvdSig());
		this.hashColumns.put("etd_wk", getEtdWk());
		this.hashColumns.put("d_9", getD9());
		this.hashColumns.put("d_8", getD8());
		this.hashColumns.put("dis_op", getDisOp());
		this.hashColumns.put("d_5", getD5());
		this.hashColumns.put("d_4", getD4());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("d_7", getD7());
		this.hashColumns.put("d_6", getD6());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("c_feu", getCFeu());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("c_teu", getCTeu());
		this.hashColumns.put("d_1", getD1());
		this.hashColumns.put("d_2", getD2());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("d_3", getD3());
		this.hashColumns.put("sel_ob_srep_cd", getSelObSrepCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("sel_vvd", getSelVvd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("grp_op", getGrpOp());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("from_wk", getFromWk());
		this.hashColumns.put("sel_etd_dt", getSelEtdDt());
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_cre_wk", getBkgCreWk());
		this.hashColumns.put("cmpb", getCmpb());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("d_12", getD12());
		this.hashColumns.put("d_11", getD11());
		this.hashColumns.put("unit_op", getUnitOp());
		this.hashColumns.put("pol_etd_fr_dt", getPolEtdFrDt());
		this.hashColumns.put("cntr_tp_sz", getCntrTpSz());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("d_14", getD14());
		this.hashColumns.put("d_13", getD13());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("d_10", getD10());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("sel_slan_cd", getSelSlanCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("bkg_ofc_sub", getBkgOfcSub());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("s_bkg_ofc_cd", getSBkgOfcCd());
		this.hashColumns.put("chk_cxl_bkg_only", getChkCxlBkgOnly());
		this.hashColumns.put("ob_sls_ofc_sub", getObSlsOfcSub());
		this.hashColumns.put("s_trade", getSTrade());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bkg_cxl_dt", getBkgCxlDt());
		this.hashColumns.put("to_wk", getToWk());
		this.hashColumns.put("dis_val", getDisVal());
		this.hashColumns.put("sel_cust_cd", getSelCustCd());
		this.hashColumns.put("coa_year", getCoaYear());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("bkg_cxl_wk", getBkgCxlWk());
		this.hashColumns.put("vvd_slan_cd", getVvdSlanCd());
		this.hashColumns.put("bkg_cxl_fr_dt", getBkgCxlFrDt());
		this.hashColumns.put("cm_cur", getCmCur());
		this.hashColumns.put("bkg_cxl_to_dt", getBkgCxlToDt());
		this.hashColumns.put("sel_op", getSelOp());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("sel_cost_wk", getSelCostWk());
		this.hashColumns.put("sel_pol_cd", getSelPolCd());
		this.hashColumns.put("pk_tp", getPkTp());
		this.hashColumns.put("dis_days", getDisDays());
		this.hashColumns.put("pol_etd_to_dt", getPolEtdToDt());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ctrt_ofc_sub", getCtrtOfcSub());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_sig", "vvdSig");
		this.hashFields.put("etd_wk", "etdWk");
		this.hashFields.put("d_9", "d9");
		this.hashFields.put("d_8", "d8");
		this.hashFields.put("dis_op", "disOp");
		this.hashFields.put("d_5", "d5");
		this.hashFields.put("d_4", "d4");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("d_7", "d7");
		this.hashFields.put("d_6", "d6");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("c_feu", "cFeu");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("c_teu", "cTeu");
		this.hashFields.put("d_1", "d1");
		this.hashFields.put("d_2", "d2");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("d_3", "d3");
		this.hashFields.put("sel_ob_srep_cd", "selObSrepCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sel_vvd", "selVvd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("grp_op", "grpOp");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("from_wk", "fromWk");
		this.hashFields.put("sel_etd_dt", "selEtdDt");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_cre_wk", "bkgCreWk");
		this.hashFields.put("cmpb", "cmpb");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("d_12", "d12");
		this.hashFields.put("d_11", "d11");
		this.hashFields.put("unit_op", "unitOp");
		this.hashFields.put("pol_etd_fr_dt", "polEtdFrDt");
		this.hashFields.put("cntr_tp_sz", "cntrTpSz");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("d_14", "d14");
		this.hashFields.put("d_13", "d13");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("d_10", "d10");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("load", "load");
		this.hashFields.put("sel_slan_cd", "selSlanCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("bkg_ofc_sub", "bkgOfcSub");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("s_bkg_ofc_cd", "sBkgOfcCd");
		this.hashFields.put("chk_cxl_bkg_only", "chkCxlBkgOnly");
		this.hashFields.put("ob_sls_ofc_sub", "obSlsOfcSub");
		this.hashFields.put("s_trade", "sTrade");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_cxl_dt", "bkgCxlDt");
		this.hashFields.put("to_wk", "toWk");
		this.hashFields.put("dis_val", "disVal");
		this.hashFields.put("sel_cust_cd", "selCustCd");
		this.hashFields.put("coa_year", "coaYear");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("bkg_cxl_wk", "bkgCxlWk");
		this.hashFields.put("vvd_slan_cd", "vvdSlanCd");
		this.hashFields.put("bkg_cxl_fr_dt", "bkgCxlFrDt");
		this.hashFields.put("cm_cur", "cmCur");
		this.hashFields.put("bkg_cxl_to_dt", "bkgCxlToDt");
		this.hashFields.put("sel_op", "selOp");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("sel_cost_wk", "selCostWk");
		this.hashFields.put("sel_pol_cd", "selPolCd");
		this.hashFields.put("pk_tp", "pkTp");
		this.hashFields.put("dis_days", "disDays");
		this.hashFields.put("pol_etd_to_dt", "polEtdToDt");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ctrt_ofc_sub", "ctrtOfcSub");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvdSig
	 */
	public String getVvdSig() {
		return this.vvdSig;
	}
	
	/**
	 * Column Info
	 * @return etdWk
	 */
	public String getEtdWk() {
		return this.etdWk;
	}
	
	/**
	 * Column Info
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}
	
	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
	}
	
	/**
	 * Column Info
	 * @return disOp
	 */
	public String getDisOp() {
		return this.disOp;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
	}
	
	/**
	 * Column Info
	 * @return d6
	 */
	public String getD6() {
		return this.d6;
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
	 * @return cFeu
	 */
	public String getCFeu() {
		return this.cFeu;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return cTeu
	 */
	public String getCTeu() {
		return this.cTeu;
	}
	
	/**
	 * Column Info
	 * @return d1
	 */
	public String getD1() {
		return this.d1;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return d3
	 */
	public String getD3() {
		return this.d3;
	}
	
	/**
	 * Column Info
	 * @return selObSrepCd
	 */
	public String getSelObSrepCd() {
		return this.selObSrepCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return selVvd
	 */
	public String getSelVvd() {
		return this.selVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
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
	 * @return grpOp
	 */
	public String getGrpOp() {
		return this.grpOp;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fromWk
	 */
	public String getFromWk() {
		return this.fromWk;
	}
	
	/**
	 * Column Info
	 * @return selEtdDt
	 */
	public String getSelEtdDt() {
		return this.selEtdDt;
	}
	
	/**
	 * Column Info
	 * @return trnkVvdCd
	 */
	public String getTrnkVvdCd() {
		return this.trnkVvdCd;
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
	 * @return bkgCreWk
	 */
	public String getBkgCreWk() {
		return this.bkgCreWk;
	}
	
	/**
	 * Column Info
	 * @return cmpb
	 */
	public String getCmpb() {
		return this.cmpb;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return d12
	 */
	public String getD12() {
		return this.d12;
	}
	
	/**
	 * Column Info
	 * @return d11
	 */
	public String getD11() {
		return this.d11;
	}
	
	/**
	 * Column Info
	 * @return unitOp
	 */
	public String getUnitOp() {
		return this.unitOp;
	}
	
	/**
	 * Column Info
	 * @return polEtdFrDt
	 */
	public String getPolEtdFrDt() {
		return this.polEtdFrDt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpSz
	 */
	public String getCntrTpSz() {
		return this.cntrTpSz;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return d14
	 */
	public String getD14() {
		return this.d14;
	}
	
	/**
	 * Column Info
	 * @return d13
	 */
	public String getD13() {
		return this.d13;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return d10
	 */
	public String getD10() {
		return this.d10;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return selSlanCd
	 */
	public String getSelSlanCd() {
		return this.selSlanCd;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcSub
	 */
	public String getBkgOfcSub() {
		return this.bkgOfcSub;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgOfcCd
	 */
	public String getSBkgOfcCd() {
		return this.sBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chkCxlBkgOnly
	 */
	public String getChkCxlBkgOnly() {
		return this.chkCxlBkgOnly;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcSub
	 */
	public String getObSlsOfcSub() {
		return this.obSlsOfcSub;
	}
	
	/**
	 * Column Info
	 * @return sTrade
	 */
	public String getSTrade() {
		return this.sTrade;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
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
	 * @return bkgCxlDt
	 */
	public String getBkgCxlDt() {
		return this.bkgCxlDt;
	}
	
	/**
	 * Column Info
	 * @return toWk
	 */
	public String getToWk() {
		return this.toWk;
	}
	
	/**
	 * Column Info
	 * @return disVal
	 */
	public String getDisVal() {
		return this.disVal;
	}
	
	/**
	 * Column Info
	 * @return selCustCd
	 */
	public String getSelCustCd() {
		return this.selCustCd;
	}
	
	/**
	 * Column Info
	 * @return coaYear
	 */
	public String getCoaYear() {
		return this.coaYear;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return bkgCxlWk
	 */
	public String getBkgCxlWk() {
		return this.bkgCxlWk;
	}
	
	/**
	 * Column Info
	 * @return vvdSlanCd
	 */
	public String getVvdSlanCd() {
		return this.vvdSlanCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCxlFrDt
	 */
	public String getBkgCxlFrDt() {
		return this.bkgCxlFrDt;
	}
	
	/**
	 * Column Info
	 * @return cmCur
	 */
	public String getCmCur() {
		return this.cmCur;
	}
	
	/**
	 * Column Info
	 * @return bkgCxlToDt
	 */
	public String getBkgCxlToDt() {
		return this.bkgCxlToDt;
	}
	
	/**
	 * Column Info
	 * @return selOp
	 */
	public String getSelOp() {
		return this.selOp;
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
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return selCostWk
	 */
	public String getSelCostWk() {
		return this.selCostWk;
	}
	
	/**
	 * Column Info
	 * @return selPolCd
	 */
	public String getSelPolCd() {
		return this.selPolCd;
	}
	
	/**
	 * Column Info
	 * @return pkTp
	 */
	public String getPkTp() {
		return this.pkTp;
	}
	
	/**
	 * Column Info
	 * @return disDays
	 */
	public String getDisDays() {
		return this.disDays;
	}
	
	/**
	 * Column Info
	 * @return polEtdToDt
	 */
	public String getPolEtdToDt() {
		return this.polEtdToDt;
	}
	

	/**
	 * Column Info
	 * @param vvdSig
	 */
	public void setVvdSig(String vvdSig) {
		this.vvdSig = vvdSig;
	}
	
	/**
	 * Column Info
	 * @param etdWk
	 */
	public void setEtdWk(String etdWk) {
		this.etdWk = etdWk;
	}
	
	/**
	 * Column Info
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}
	
	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
	}
	
	/**
	 * Column Info
	 * @param disOp
	 */
	public void setDisOp(String disOp) {
		this.disOp = disOp;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
	}
	
	/**
	 * Column Info
	 * @param d6
	 */
	public void setD6(String d6) {
		this.d6 = d6;
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
	 * @param cFeu
	 */
	public void setCFeu(String cFeu) {
		this.cFeu = cFeu;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param cTeu
	 */
	public void setCTeu(String cTeu) {
		this.cTeu = cTeu;
	}
	
	/**
	 * Column Info
	 * @param d1
	 */
	public void setD1(String d1) {
		this.d1 = d1;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param d3
	 */
	public void setD3(String d3) {
		this.d3 = d3;
	}
	
	/**
	 * Column Info
	 * @param selObSrepCd
	 */
	public void setSelObSrepCd(String selObSrepCd) {
		this.selObSrepCd = selObSrepCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param selVvd
	 */
	public void setSelVvd(String selVvd) {
		this.selVvd = selVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
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
	 * @param grpOp
	 */
	public void setGrpOp(String grpOp) {
		this.grpOp = grpOp;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fromWk
	 */
	public void setFromWk(String fromWk) {
		this.fromWk = fromWk;
	}
	
	/**
	 * Column Info
	 * @param selEtdDt
	 */
	public void setSelEtdDt(String selEtdDt) {
		this.selEtdDt = selEtdDt;
	}
	
	/**
	 * Column Info
	 * @param trnkVvdCd
	 */
	public void setTrnkVvdCd(String trnkVvdCd) {
		this.trnkVvdCd = trnkVvdCd;
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
	 * @param bkgCreWk
	 */
	public void setBkgCreWk(String bkgCreWk) {
		this.bkgCreWk = bkgCreWk;
	}
	
	/**
	 * Column Info
	 * @param cmpb
	 */
	public void setCmpb(String cmpb) {
		this.cmpb = cmpb;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param d12
	 */
	public void setD12(String d12) {
		this.d12 = d12;
	}
	
	/**
	 * Column Info
	 * @param d11
	 */
	public void setD11(String d11) {
		this.d11 = d11;
	}
	
	/**
	 * Column Info
	 * @param unitOp
	 */
	public void setUnitOp(String unitOp) {
		this.unitOp = unitOp;
	}
	
	/**
	 * Column Info
	 * @param polEtdFrDt
	 */
	public void setPolEtdFrDt(String polEtdFrDt) {
		this.polEtdFrDt = polEtdFrDt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpSz
	 */
	public void setCntrTpSz(String cntrTpSz) {
		this.cntrTpSz = cntrTpSz;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param d14
	 */
	public void setD14(String d14) {
		this.d14 = d14;
	}
	
	/**
	 * Column Info
	 * @param d13
	 */
	public void setD13(String d13) {
		this.d13 = d13;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param d10
	 */
	public void setD10(String d10) {
		this.d10 = d10;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param selSlanCd
	 */
	public void setSelSlanCd(String selSlanCd) {
		this.selSlanCd = selSlanCd;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcSub
	 */
	public void setBkgOfcSub(String bkgOfcSub) {
		this.bkgOfcSub = bkgOfcSub;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgOfcCd
	 */
	public void setSBkgOfcCd(String sBkgOfcCd) {
		this.sBkgOfcCd = sBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chkCxlBkgOnly
	 */
	public void setChkCxlBkgOnly(String chkCxlBkgOnly) {
		this.chkCxlBkgOnly = chkCxlBkgOnly;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcSub
	 */
	public void setObSlsOfcSub(String obSlsOfcSub) {
		this.obSlsOfcSub = obSlsOfcSub;
	}
	
	/**
	 * Column Info
	 * @param sTrade
	 */
	public void setSTrade(String sTrade) {
		this.sTrade = sTrade;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
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
	 * @param bkgCxlDt
	 */
	public void setBkgCxlDt(String bkgCxlDt) {
		this.bkgCxlDt = bkgCxlDt;
	}
	
	/**
	 * Column Info
	 * @param toWk
	 */
	public void setToWk(String toWk) {
		this.toWk = toWk;
	}
	
	/**
	 * Column Info
	 * @param disVal
	 */
	public void setDisVal(String disVal) {
		this.disVal = disVal;
	}
	
	/**
	 * Column Info
	 * @param selCustCd
	 */
	public void setSelCustCd(String selCustCd) {
		this.selCustCd = selCustCd;
	}
	
	/**
	 * Column Info
	 * @param coaYear
	 */
	public void setCoaYear(String coaYear) {
		this.coaYear = coaYear;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCxlWk
	 */
	public void setBkgCxlWk(String bkgCxlWk) {
		this.bkgCxlWk = bkgCxlWk;
	}
	
	/**
	 * Column Info
	 * @param vvdSlanCd
	 */
	public void setVvdSlanCd(String vvdSlanCd) {
		this.vvdSlanCd = vvdSlanCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCxlFrDt
	 */
	public void setBkgCxlFrDt(String bkgCxlFrDt) {
		this.bkgCxlFrDt = bkgCxlFrDt;
	}
	
	/**
	 * Column Info
	 * @param cmCur
	 */
	public void setCmCur(String cmCur) {
		this.cmCur = cmCur;
	}
	
	/**
	 * Column Info
	 * @param bkgCxlToDt
	 */
	public void setBkgCxlToDt(String bkgCxlToDt) {
		this.bkgCxlToDt = bkgCxlToDt;
	}
	
	/**
	 * Column Info
	 * @param selOp
	 */
	public void setSelOp(String selOp) {
		this.selOp = selOp;
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
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}
	
	/**
	 * Column Info
	 * @param selCostWk
	 */
	public void setSelCostWk(String selCostWk) {
		this.selCostWk = selCostWk;
	}
	
	/**
	 * Column Info
	 * @param selPolCd
	 */
	public void setSelPolCd(String selPolCd) {
		this.selPolCd = selPolCd;
	}
	
	/**
	 * Column Info
	 * @param pkTp
	 */
	public void setPkTp(String pkTp) {
		this.pkTp = pkTp;
	}
	
	/**
	 * Column Info
	 * @param disDays
	 */
	public void setDisDays(String disDays) {
		this.disDays = disDays;
	}
	
	/**
	 * Column Info
	 * @param polEtdToDt
	 */
	public void setPolEtdToDt(String polEtdToDt) {
		this.polEtdToDt = polEtdToDt;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public String getCtrtOfcCd() {
	return ctrtOfcCd;
	}
	
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	public String getCtrtOfcSub() {
		return ctrtOfcSub;
	}
	
	public void setCtrtOfcSub(String ctrtOfcSub) {
		this.ctrtOfcSub = ctrtOfcSub;
	}
	
	public String getCtrtSrepCd() {
		return ctrtSrepCd;
	}
	
	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVvdSig(JSPUtil.getParameter(request, prefix + "vvd_sig", ""));
		setEtdWk(JSPUtil.getParameter(request, prefix + "etd_wk", ""));
		setD9(JSPUtil.getParameter(request, prefix + "d_9", ""));
		setD8(JSPUtil.getParameter(request, prefix + "d_8", ""));
		setDisOp(JSPUtil.getParameter(request, prefix + "dis_op", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d_5", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d_4", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d_7", ""));
		setD6(JSPUtil.getParameter(request, prefix + "d_6", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCFeu(JSPUtil.getParameter(request, prefix + "c_feu", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setCTeu(JSPUtil.getParameter(request, prefix + "c_teu", ""));
		setD1(JSPUtil.getParameter(request, prefix + "d_1", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d_2", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setD3(JSPUtil.getParameter(request, prefix + "d_3", ""));
		setSelObSrepCd(JSPUtil.getParameter(request, prefix + "sel_ob_srep_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setSelVvd(JSPUtil.getParameter(request, prefix + "sel_vvd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setGrpOp(JSPUtil.getParameter(request, prefix + "grp_op", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setFromWk(JSPUtil.getParameter(request, prefix + "from_wk", ""));
		setSelEtdDt(JSPUtil.getParameter(request, prefix + "sel_etd_dt", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request, prefix + "trnk_vvd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgCreWk(JSPUtil.getParameter(request, prefix + "bkg_cre_wk", ""));
		setCmpb(JSPUtil.getParameter(request, prefix + "cmpb", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setD12(JSPUtil.getParameter(request, prefix + "d_12", ""));
		setD11(JSPUtil.getParameter(request, prefix + "d_11", ""));
		setUnitOp(JSPUtil.getParameter(request, prefix + "unit_op", ""));
		setPolEtdFrDt(JSPUtil.getParameter(request, prefix + "pol_etd_fr_dt", ""));
		setCntrTpSz(JSPUtil.getParameter(request, prefix + "cntr_tp_sz", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setD14(JSPUtil.getParameter(request, prefix + "d_14", ""));
		setD13(JSPUtil.getParameter(request, prefix + "d_13", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setD10(JSPUtil.getParameter(request, prefix + "d_10", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setLoad(JSPUtil.getParameter(request, prefix + "load", ""));
		setSelSlanCd(JSPUtil.getParameter(request, prefix + "sel_slan_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setBkgOfcSub(JSPUtil.getParameter(request, prefix + "bkg_ofc_sub", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setSBkgOfcCd(JSPUtil.getParameter(request, prefix + "s_bkg_ofc_cd", ""));
		setChkCxlBkgOnly(JSPUtil.getParameter(request, prefix + "chk_cxl_bkg_only", ""));
		setObSlsOfcSub(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_sub", ""));
		setSTrade(JSPUtil.getParameter(request, prefix + "s_trade", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBkgCxlDt(JSPUtil.getParameter(request, prefix + "bkg_cxl_dt", ""));
		setToWk(JSPUtil.getParameter(request, prefix + "to_wk", ""));
		setDisVal(JSPUtil.getParameter(request, prefix + "dis_val", ""));
		setSelCustCd(JSPUtil.getParameter(request, prefix + "sel_cust_cd", ""));
		setCoaYear(JSPUtil.getParameter(request, prefix + "coa_year", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setBkgCxlWk(JSPUtil.getParameter(request, prefix + "bkg_cxl_wk", ""));
		setVvdSlanCd(JSPUtil.getParameter(request, prefix + "vvd_slan_cd", ""));
		setBkgCxlFrDt(JSPUtil.getParameter(request, prefix + "bkg_cxl_fr_dt", ""));
		setCmCur(JSPUtil.getParameter(request, prefix + "cm_cur", ""));
		setBkgCxlToDt(JSPUtil.getParameter(request, prefix + "bkg_cxl_to_dt", ""));
		setSelOp(JSPUtil.getParameter(request, prefix + "sel_op", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setSelCostWk(JSPUtil.getParameter(request, prefix + "sel_cost_wk", ""));
		setSelPolCd(JSPUtil.getParameter(request, prefix + "sel_pol_cd", ""));
		setPkTp(JSPUtil.getParameter(request, prefix + "pk_tp", ""));
		setDisDays(JSPUtil.getParameter(request, prefix + "dis_days", ""));
		setPolEtdToDt(JSPUtil.getParameter(request, prefix + "pol_etd_to_dt", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCtrtOfcSub(JSPUtil.getParameter(request, prefix + "ctrt_ofc_sub", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBookingTrendReportVO[]
	 */
	public SearchBookingTrendReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBookingTrendReportVO[]
	 */
	public SearchBookingTrendReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBookingTrendReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdSig = (JSPUtil.getParameter(request, prefix	+ "vvd_sig", length));
			String[] etdWk = (JSPUtil.getParameter(request, prefix	+ "etd_wk", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d_9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d_8", length));
			String[] disOp = (JSPUtil.getParameter(request, prefix	+ "dis_op", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d_5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d_4", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d_7", length));
			String[] d6 = (JSPUtil.getParameter(request, prefix	+ "d_6", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cFeu = (JSPUtil.getParameter(request, prefix	+ "c_feu", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] cTeu = (JSPUtil.getParameter(request, prefix	+ "c_teu", length));
			String[] d1 = (JSPUtil.getParameter(request, prefix	+ "d_1", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d_2", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] d3 = (JSPUtil.getParameter(request, prefix	+ "d_3", length));
			String[] selObSrepCd = (JSPUtil.getParameter(request, prefix	+ "sel_ob_srep_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] selVvd = (JSPUtil.getParameter(request, prefix	+ "sel_vvd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] grpOp = (JSPUtil.getParameter(request, prefix	+ "grp_op", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] fromWk = (JSPUtil.getParameter(request, prefix	+ "from_wk", length));
			String[] selEtdDt = (JSPUtil.getParameter(request, prefix	+ "sel_etd_dt", length));
			String[] trnkVvdCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgCreWk = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_wk", length));
			String[] cmpb = (JSPUtil.getParameter(request, prefix	+ "cmpb", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] d12 = (JSPUtil.getParameter(request, prefix	+ "d_12", length));
			String[] d11 = (JSPUtil.getParameter(request, prefix	+ "d_11", length));
			String[] unitOp = (JSPUtil.getParameter(request, prefix	+ "unit_op", length));
			String[] polEtdFrDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_fr_dt", length));
			String[] cntrTpSz = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_sz", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] d14 = (JSPUtil.getParameter(request, prefix	+ "d_14", length));
			String[] d13 = (JSPUtil.getParameter(request, prefix	+ "d_13", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] d10 = (JSPUtil.getParameter(request, prefix	+ "d_10", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] selSlanCd = (JSPUtil.getParameter(request, prefix	+ "sel_slan_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] bkgOfcSub = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_sub", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] sBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_bkg_ofc_cd", length));
			String[] chkCxlBkgOnly = (JSPUtil.getParameter(request, prefix	+ "chk_cxl_bkg_only", length));
			String[] obSlsOfcSub = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_sub", length));
			String[] sTrade = (JSPUtil.getParameter(request, prefix	+ "s_trade", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bkgCxlDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cxl_dt", length));
			String[] toWk = (JSPUtil.getParameter(request, prefix	+ "to_wk", length));
			String[] disVal = (JSPUtil.getParameter(request, prefix	+ "dis_val", length));
			String[] selCustCd = (JSPUtil.getParameter(request, prefix	+ "sel_cust_cd", length));
			String[] coaYear = (JSPUtil.getParameter(request, prefix	+ "coa_year", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] bkgCxlWk = (JSPUtil.getParameter(request, prefix	+ "bkg_cxl_wk", length));
			String[] vvdSlanCd = (JSPUtil.getParameter(request, prefix	+ "vvd_slan_cd", length));
			String[] bkgCxlFrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cxl_fr_dt", length));
			String[] cmCur = (JSPUtil.getParameter(request, prefix	+ "cm_cur", length));
			String[] bkgCxlToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cxl_to_dt", length));
			String[] selOp = (JSPUtil.getParameter(request, prefix	+ "sel_op", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] selCostWk = (JSPUtil.getParameter(request, prefix	+ "sel_cost_wk", length));
			String[] selPolCd = (JSPUtil.getParameter(request, prefix	+ "sel_pol_cd", length));
			String[] pkTp = (JSPUtil.getParameter(request, prefix	+ "pk_tp", length));
			String[] disDays = (JSPUtil.getParameter(request, prefix	+ "dis_days", length));
			String[] polEtdToDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_to_dt", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] ctrtOfcSub = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_sub", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBookingTrendReportVO();
				if (vvdSig[i] != null)
					model.setVvdSig(vvdSig[i]);
				if (etdWk[i] != null)
					model.setEtdWk(etdWk[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (disOp[i] != null)
					model.setDisOp(disOp[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (d6[i] != null)
					model.setD6(d6[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cFeu[i] != null)
					model.setCFeu(cFeu[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (cTeu[i] != null)
					model.setCTeu(cTeu[i]);
				if (d1[i] != null)
					model.setD1(d1[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (d3[i] != null)
					model.setD3(d3[i]);
				if (selObSrepCd[i] != null)
					model.setSelObSrepCd(selObSrepCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (selVvd[i] != null)
					model.setSelVvd(selVvd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (grpOp[i] != null)
					model.setGrpOp(grpOp[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (fromWk[i] != null)
					model.setFromWk(fromWk[i]);
				if (selEtdDt[i] != null)
					model.setSelEtdDt(selEtdDt[i]);
				if (trnkVvdCd[i] != null)
					model.setTrnkVvdCd(trnkVvdCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgCreWk[i] != null)
					model.setBkgCreWk(bkgCreWk[i]);
				if (cmpb[i] != null)
					model.setCmpb(cmpb[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (d12[i] != null)
					model.setD12(d12[i]);
				if (d11[i] != null)
					model.setD11(d11[i]);
				if (unitOp[i] != null)
					model.setUnitOp(unitOp[i]);
				if (polEtdFrDt[i] != null)
					model.setPolEtdFrDt(polEtdFrDt[i]);
				if (cntrTpSz[i] != null)
					model.setCntrTpSz(cntrTpSz[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (d14[i] != null)
					model.setD14(d14[i]);
				if (d13[i] != null)
					model.setD13(d13[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (d10[i] != null)
					model.setD10(d10[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (selSlanCd[i] != null)
					model.setSelSlanCd(selSlanCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (bkgOfcSub[i] != null)
					model.setBkgOfcSub(bkgOfcSub[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (sBkgOfcCd[i] != null)
					model.setSBkgOfcCd(sBkgOfcCd[i]);
				if (chkCxlBkgOnly[i] != null)
					model.setChkCxlBkgOnly(chkCxlBkgOnly[i]);
				if (obSlsOfcSub[i] != null)
					model.setObSlsOfcSub(obSlsOfcSub[i]);
				if (sTrade[i] != null)
					model.setSTrade(sTrade[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bkgCxlDt[i] != null)
					model.setBkgCxlDt(bkgCxlDt[i]);
				if (toWk[i] != null)
					model.setToWk(toWk[i]);
				if (disVal[i] != null)
					model.setDisVal(disVal[i]);
				if (selCustCd[i] != null)
					model.setSelCustCd(selCustCd[i]);
				if (coaYear[i] != null)
					model.setCoaYear(coaYear[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (bkgCxlWk[i] != null)
					model.setBkgCxlWk(bkgCxlWk[i]);
				if (vvdSlanCd[i] != null)
					model.setVvdSlanCd(vvdSlanCd[i]);
				if (bkgCxlFrDt[i] != null)
					model.setBkgCxlFrDt(bkgCxlFrDt[i]);
				if (cmCur[i] != null)
					model.setCmCur(cmCur[i]);
				if (bkgCxlToDt[i] != null)
					model.setBkgCxlToDt(bkgCxlToDt[i]);
				if (selOp[i] != null)
					model.setSelOp(selOp[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (selCostWk[i] != null)
					model.setSelCostWk(selCostWk[i]);
				if (selPolCd[i] != null)
					model.setSelPolCd(selPolCd[i]);
				if (pkTp[i] != null)
					model.setPkTp(pkTp[i]);
				if (disDays[i] != null)
					model.setDisDays(disDays[i]);
				if (polEtdToDt[i] != null)
					model.setPolEtdToDt(polEtdToDt[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (ctrtOfcSub[i] != null)
					model.setCtrtOfcSub(ctrtOfcSub[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBookingTrendReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBookingTrendReportVO[]
	 */
	public SearchBookingTrendReportVO[] getSearchBookingTrendReportVOs(){
		SearchBookingTrendReportVO[] vos = (SearchBookingTrendReportVO[])models.toArray(new SearchBookingTrendReportVO[models.size()]);
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
		this.vvdSig = this.vvdSig .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdWk = this.etdWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disOp = this.disOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d6 = this.d6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cFeu = this.cFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTeu = this.cTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d1 = this.d1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d3 = this.d3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selObSrepCd = this.selObSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selVvd = this.selVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpOp = this.grpOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromWk = this.fromWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selEtdDt = this.selEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd = this.trnkVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreWk = this.bkgCreWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb = this.cmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d12 = this.d12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d11 = this.d11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitOp = this.unitOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdFrDt = this.polEtdFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpSz = this.cntrTpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d14 = this.d14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d13 = this.d13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d10 = this.d10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selSlanCd = this.selSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcSub = this.bkgOfcSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgOfcCd = this.sBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCxlBkgOnly = this.chkCxlBkgOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcSub = this.obSlsOfcSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrade = this.sTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCxlDt = this.bkgCxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWk = this.toWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disVal = this.disVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCustCd = this.selCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaYear = this.coaYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCxlWk = this.bkgCxlWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSlanCd = this.vvdSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCxlFrDt = this.bkgCxlFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCur = this.cmCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCxlToDt = this.bkgCxlToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOp = this.selOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selCostWk = this.selCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selPolCd = this.selPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkTp = this.pkTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disDays = this.disDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdToDt = this.polEtdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.polEtdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcSub = this.polEtdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.polEtdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
