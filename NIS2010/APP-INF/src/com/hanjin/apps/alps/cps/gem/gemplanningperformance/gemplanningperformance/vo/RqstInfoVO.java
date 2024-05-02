/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RqstInfoVO.java
*@FileTitle : RqstInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RqstInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RqstInfoVO> models = new ArrayList<RqstInfoVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String rsltYrmon = null;
	/* Column Info */
	private String schExpenseTo = null;
	/* Column Info */
	private String comDiff = null;
	/* Column Info */
	private String comRatio = null;
	/* Column Info */
	private String schTicCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String monthlyView = null;
	/* Column Info */
	private String schExpenseFrom = null;
	/* Column Info */
	private String genExpnTrnsDivCd = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String schLang = null;
	/* Column Info */
	private String loginOffice = null;
	/* Column Info */
	private String expnDep = null;
	/* Column Info */
	private String plnMon = null;
	/* Column Info */
	private String ofcCur = null;
	/* Column Info */
	private String comRatioNum = null;
	/* Column Info */
	private String curUnit = null;
	/* Column Info */
	private String schExpenseGroup = null;
	/* Column Info */
	private String ofcLvl1 = null;
	/* Column Info */
	private String ofcLvl2 = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String subOfficeView = null;
	/* Column Info */
	private String ofcLvl3 = null;
	/* Column Info */
	private String schAppDivGbn = null;
	/* Column Info */
	private String ofcExpnCd = null;
	/* Column Info */
	private String fromRsltYrmon = null;
	/* Column Info */
	private String rtYr = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String ofcSal = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String toRsltYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String schDeltFlg = null;
	/* Column Info */
	private String subTotal = null;
	/* Column Info */
	private String closingDate = null;
	/* Column Info */
	private String schSumupGbn = null;
	/* Column Info */
	private String slpTjNo = null;
	/* Column Info */
	private String comDiffNum = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String ofcCo = null;
	/* Column Info */
	private String rtToMon = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String rtFmMon = null;
	/* Column Info */
	private String langDiv = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String perfDiv = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;
	/* Column Info */
	private String slsOfcDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RqstInfoVO() {}

	public RqstInfoVO(String ibflag, String pagerows, String total, String rsltYrmon, String schExpenseTo, String comDiff, String comRatio, String schTicCd, String monthlyView, String schExpenseFrom, String genExpnTrnsDivCd, String genExpnRqstNo, String plnYr, String schLang, String loginOffice, String expnDep, String plnMon, String ofcCur, String comRatioNum, String curUnit, String schExpenseGroup, String ofcLvl1, String pageNo, String ofcLvl2, String subOfficeView, String ofcLvl3, String schAppDivGbn, String fromRsltYrmon, String rtYr, String rowNum, String authFlg, String ofcSal, String backendjobKey, String toRsltYrmon, String schDeltFlg, String subTotal, String closingDate, String schSumupGbn, String comDiffNum, String plnYrmon, String ofcCo, String rtToMon, String genExpnCd, String rtFmMon, String langDiv, String ofcCd, String perfDiv, String genExpnRqstSeq, String genExpnRqstTpCd, String slsOfcDivCd, String ofcExpnCd, String slpTjNo, String ofcCoDivCd) {
		this.total = total;
		this.rsltYrmon = rsltYrmon;
		this.schExpenseTo = schExpenseTo;
		this.comDiff = comDiff;
		this.comRatio = comRatio;
		this.schTicCd = schTicCd;
		this.pagerows = pagerows;
		this.monthlyView = monthlyView;
		this.schExpenseFrom = schExpenseFrom;
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
		this.genExpnRqstNo = genExpnRqstNo;
		this.plnYr = plnYr;
		this.ofcCoDivCd = ofcCoDivCd;
		this.schLang = schLang;
		this.loginOffice = loginOffice;
		this.expnDep = expnDep;
		this.plnMon = plnMon;
		this.ofcCur = ofcCur;
		this.comRatioNum = comRatioNum;
		this.curUnit = curUnit;
		this.schExpenseGroup = schExpenseGroup;
		this.ofcLvl1 = ofcLvl1;
		this.ofcLvl2 = ofcLvl2;
		this.pageNo = pageNo;
		this.subOfficeView = subOfficeView;
		this.ofcLvl3 = ofcLvl3;
		this.schAppDivGbn = schAppDivGbn;
		this.ofcExpnCd = ofcExpnCd;
		this.fromRsltYrmon = fromRsltYrmon;
		this.rtYr = rtYr;
		this.rowNum = rowNum;
		this.authFlg = authFlg;
		this.ofcSal = ofcSal;
		this.backendjobKey = backendjobKey;
		this.toRsltYrmon = toRsltYrmon;
		this.ibflag = ibflag;
		this.schDeltFlg = schDeltFlg;
		this.subTotal = subTotal;
		this.closingDate = closingDate;
		this.schSumupGbn = schSumupGbn;
		this.slpTjNo = slpTjNo;
		this.comDiffNum = comDiffNum;
		this.plnYrmon = plnYrmon;
		this.ofcCo = ofcCo;
		this.rtToMon = rtToMon;
		this.genExpnCd = genExpnCd;
		this.rtFmMon = rtFmMon;
		this.langDiv = langDiv;
		this.ofcCd = ofcCd;
		this.perfDiv = perfDiv;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		this.hashColumns.put("sch_expense_to", getSchExpenseTo());
		this.hashColumns.put("com_diff", getComDiff());
		this.hashColumns.put("com_ratio", getComRatio());
		this.hashColumns.put("sch_tic_cd", getSchTicCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("monthly_view", getMonthlyView());
		this.hashColumns.put("sch_expense_from", getSchExpenseFrom());
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("sch_lang", getSchLang());
		this.hashColumns.put("login_office", getLoginOffice());
		this.hashColumns.put("expn_dep", getExpnDep());
		this.hashColumns.put("pln_mon", getPlnMon());
		this.hashColumns.put("ofc_cur", getOfcCur());
		this.hashColumns.put("com_ratio_num", getComRatioNum());
		this.hashColumns.put("cur_unit", getCurUnit());
		this.hashColumns.put("sch_expense_group", getSchExpenseGroup());
		this.hashColumns.put("ofc_lvl1", getOfcLvl1());
		this.hashColumns.put("ofc_lvl2", getOfcLvl2());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("sub_office_view", getSubOfficeView());
		this.hashColumns.put("ofc_lvl3", getOfcLvl3());
		this.hashColumns.put("sch_app_div_gbn", getSchAppDivGbn());
		this.hashColumns.put("ofc_expn_cd", getOfcExpnCd());
		this.hashColumns.put("from_rslt_yrmon", getFromRsltYrmon());
		this.hashColumns.put("rt_yr", getRtYr());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("ofc_sal", getOfcSal());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("to_rslt_yrmon", getToRsltYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_delt_flg", getSchDeltFlg());
		this.hashColumns.put("sub_total", getSubTotal());
		this.hashColumns.put("closing_date", getClosingDate());
		this.hashColumns.put("sch_sumup_gbn", getSchSumupGbn());
		this.hashColumns.put("slp_tj_no", getSlpTjNo());
		this.hashColumns.put("com_diff_num", getComDiffNum());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("ofc_co", getOfcCo());
		this.hashColumns.put("rt_to_mon", getRtToMon());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("rt_fm_mon", getRtFmMon());
		this.hashColumns.put("lang_div", getLangDiv());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("perf_div", getPerfDiv());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("rslt_yrmon", "rsltYrmon");
		this.hashFields.put("sch_expense_to", "schExpenseTo");
		this.hashFields.put("com_diff", "comDiff");
		this.hashFields.put("com_ratio", "comRatio");
		this.hashFields.put("sch_tic_cd", "schTicCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("monthly_view", "monthlyView");
		this.hashFields.put("sch_expense_from", "schExpenseFrom");
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("sch_lang", "schLang");
		this.hashFields.put("login_office", "loginOffice");
		this.hashFields.put("expn_dep", "expnDep");
		this.hashFields.put("pln_mon", "plnMon");
		this.hashFields.put("ofc_cur", "ofcCur");
		this.hashFields.put("com_ratio_num", "comRatioNum");
		this.hashFields.put("cur_unit", "curUnit");
		this.hashFields.put("sch_expense_group", "schExpenseGroup");
		this.hashFields.put("ofc_lvl1", "ofcLvl1");
		this.hashFields.put("ofc_lvl2", "ofcLvl2");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("sub_office_view", "subOfficeView");
		this.hashFields.put("ofc_lvl3", "ofcLvl3");
		this.hashFields.put("sch_app_div_gbn", "schAppDivGbn");
		this.hashFields.put("ofc_expn_cd", "ofcExpnCd");
		this.hashFields.put("from_rslt_yrmon", "fromRsltYrmon");
		this.hashFields.put("rt_yr", "rtYr");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("ofc_sal", "ofcSal");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("to_rslt_yrmon", "toRsltYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_delt_flg", "schDeltFlg");
		this.hashFields.put("sub_total", "subTotal");
		this.hashFields.put("closing_date", "closingDate");
		this.hashFields.put("sch_sumup_gbn", "schSumupGbn");
		this.hashFields.put("slp_tj_no", "slpTjNo");
		this.hashFields.put("com_diff_num", "comDiffNum");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("ofc_co", "ofcCo");
		this.hashFields.put("rt_to_mon", "rtToMon");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("rt_fm_mon", "rtFmMon");
		this.hashFields.put("lang_div", "langDiv");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("perf_div", "perfDiv");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
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
	 * @return rsltYrmon
	 */
	public String getRsltYrmon() {
		return this.rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @return schExpenseTo
	 */
	public String getSchExpenseTo() {
		return this.schExpenseTo;
	}
	
	/**
	 * Column Info
	 * @return comDiff
	 */
	public String getComDiff() {
		return this.comDiff;
	}
	
	/**
	 * Column Info
	 * @return comRatio
	 */
	public String getComRatio() {
		return this.comRatio;
	}
	
	/**
	 * Column Info
	 * @return schTicCd
	 */
	public String getSchTicCd() {
		return this.schTicCd;
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
	 * @return monthlyView
	 */
	public String getMonthlyView() {
		return this.monthlyView;
	}
	
	/**
	 * Column Info
	 * @return schExpenseFrom
	 */
	public String getSchExpenseFrom() {
		return this.schExpenseFrom;
	}
	
	/**
	 * Column Info
	 * @return genExpnTrnsDivCd
	 */
	public String getGenExpnTrnsDivCd() {
		return this.genExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @return schLang
	 */
	public String getSchLang() {
		return this.schLang;
	}
	
	/**
	 * Column Info
	 * @return loginOffice
	 */
	public String getLoginOffice() {
		return this.loginOffice;
	}
	
	/**
	 * Column Info
	 * @return expnDep
	 */
	public String getExpnDep() {
		return this.expnDep;
	}
	
	/**
	 * Column Info
	 * @return plnMon
	 */
	public String getPlnMon() {
		return this.plnMon;
	}
	
	/**
	 * Column Info
	 * @return ofcCur
	 */
	public String getOfcCur() {
		return this.ofcCur;
	}
	
	/**
	 * Column Info
	 * @return comRatioNum
	 */
	public String getComRatioNum() {
		return this.comRatioNum;
	}
	
	/**
	 * Column Info
	 * @return curUnit
	 */
	public String getCurUnit() {
		return this.curUnit;
	}
	
	/**
	 * Column Info
	 * @return schExpenseGroup
	 */
	public String getSchExpenseGroup() {
		return this.schExpenseGroup;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl1
	 */
	public String getOfcLvl1() {
		return this.ofcLvl1;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl2
	 */
	public String getOfcLvl2() {
		return this.ofcLvl2;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return subOfficeView
	 */
	public String getSubOfficeView() {
		return this.subOfficeView;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl3
	 */
	public String getOfcLvl3() {
		return this.ofcLvl3;
	}
	
	/**
	 * Column Info
	 * @return schAppDivGbn
	 */
	public String getSchAppDivGbn() {
		return this.schAppDivGbn;
	}
	
	/**
	 * Column Info
	 * @return ofcExpnCd
	 */
	public String getOfcExpnCd() {
		return this.ofcExpnCd;
	}
	
	/**
	 * Column Info
	 * @return fromRsltYrmon
	 */
	public String getFromRsltYrmon() {
		return this.fromRsltYrmon;
	}
	
	/**
	 * Column Info
	 * @return rtYr
	 */
	public String getRtYr() {
		return this.rtYr;
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
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcSal
	 */
	public String getOfcSal() {
		return this.ofcSal;
	}
	
	/**
	 * Column Info
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
	}
	
	/**
	 * Column Info
	 * @return toRsltYrmon
	 */
	public String getToRsltYrmon() {
		return this.toRsltYrmon;
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
	 * @return schDeltFlg
	 */
	public String getSchDeltFlg() {
		return this.schDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return subTotal
	 */
	public String getSubTotal() {
		return this.subTotal;
	}
	
	/**
	 * Column Info
	 * @return closingDate
	 */
	public String getClosingDate() {
		return this.closingDate;
	}
	
	/**
	 * Column Info
	 * @return schSumupGbn
	 */
	public String getSchSumupGbn() {
		return this.schSumupGbn;
	}
	
	/**
	 * Column Info
	 * @return slpTjNo
	 */
	public String getSlpTjNo() {
		return this.slpTjNo;
	}
	
	/**
	 * Column Info
	 * @return comDiffNum
	 */
	public String getComDiffNum() {
		return this.comDiffNum;
	}
	
	/**
	 * Column Info
	 * @return plnYrmon
	 */
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	
	/**
	 * Column Info
	 * @return ofcCo
	 */
	public String getOfcCo() {
		return this.ofcCo;
	}
	
	/**
	 * Column Info
	 * @return rtToMon
	 */
	public String getRtToMon() {
		return this.rtToMon;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return rtFmMon
	 */
	public String getRtFmMon() {
		return this.rtFmMon;
	}
	
	/**
	 * Column Info
	 * @return langDiv
	 */
	public String getLangDiv() {
		return this.langDiv;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return perfDiv
	 */
	public String getPerfDiv() {
		return this.perfDiv;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return this.genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcDivCd
	 */
	public String getSlsOfcDivCd() {
		return this.slsOfcDivCd;
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
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @param schExpenseTo
	 */
	public void setSchExpenseTo(String schExpenseTo) {
		this.schExpenseTo = schExpenseTo;
	}
	
	/**
	 * Column Info
	 * @param comDiff
	 */
	public void setComDiff(String comDiff) {
		this.comDiff = comDiff;
	}
	
	/**
	 * Column Info
	 * @param comRatio
	 */
	public void setComRatio(String comRatio) {
		this.comRatio = comRatio;
	}
	
	/**
	 * Column Info
	 * @param schTicCd
	 */
	public void setSchTicCd(String schTicCd) {
		this.schTicCd = schTicCd;
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
	 * @param monthlyView
	 */
	public void setMonthlyView(String monthlyView) {
		this.monthlyView = monthlyView;
	}
	
	/**
	 * Column Info
	 * @param schExpenseFrom
	 */
	public void setSchExpenseFrom(String schExpenseFrom) {
		this.schExpenseFrom = schExpenseFrom;
	}
	
	/**
	 * Column Info
	 * @param genExpnTrnsDivCd
	 */
	public void setGenExpnTrnsDivCd(String genExpnTrnsDivCd) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @param schLang
	 */
	public void setSchLang(String schLang) {
		this.schLang = schLang;
	}
	
	/**
	 * Column Info
	 * @param loginOffice
	 */
	public void setLoginOffice(String loginOffice) {
		this.loginOffice = loginOffice;
	}
	
	/**
	 * Column Info
	 * @param expnDep
	 */
	public void setExpnDep(String expnDep) {
		this.expnDep = expnDep;
	}
	
	/**
	 * Column Info
	 * @param plnMon
	 */
	public void setPlnMon(String plnMon) {
		this.plnMon = plnMon;
	}
	
	/**
	 * Column Info
	 * @param ofcCur
	 */
	public void setOfcCur(String ofcCur) {
		this.ofcCur = ofcCur;
	}
	
	/**
	 * Column Info
	 * @param comRatioNum
	 */
	public void setComRatioNum(String comRatioNum) {
		this.comRatioNum = comRatioNum;
	}
	
	/**
	 * Column Info
	 * @param curUnit
	 */
	public void setCurUnit(String curUnit) {
		this.curUnit = curUnit;
	}
	
	/**
	 * Column Info
	 * @param schExpenseGroup
	 */
	public void setSchExpenseGroup(String schExpenseGroup) {
		this.schExpenseGroup = schExpenseGroup;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl1
	 */
	public void setOfcLvl1(String ofcLvl1) {
		this.ofcLvl1 = ofcLvl1;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl2
	 */
	public void setOfcLvl2(String ofcLvl2) {
		this.ofcLvl2 = ofcLvl2;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param subOfficeView
	 */
	public void setSubOfficeView(String subOfficeView) {
		this.subOfficeView = subOfficeView;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl3
	 */
	public void setOfcLvl3(String ofcLvl3) {
		this.ofcLvl3 = ofcLvl3;
	}
	
	/**
	 * Column Info
	 * @param schAppDivGbn
	 */
	public void setSchAppDivGbn(String schAppDivGbn) {
		this.schAppDivGbn = schAppDivGbn;
	}
	
	/**
	 * Column Info
	 * @param ofcExpnCd
	 */
	public void setOfcExpnCd(String ofcExpnCd) {
		this.ofcExpnCd = ofcExpnCd;
	}
	
	/**
	 * Column Info
	 * @param fromRsltYrmon
	 */
	public void setFromRsltYrmon(String fromRsltYrmon) {
		this.fromRsltYrmon = fromRsltYrmon;
	}
	
	/**
	 * Column Info
	 * @param rtYr
	 */
	public void setRtYr(String rtYr) {
		this.rtYr = rtYr;
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
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcSal
	 */
	public void setOfcSal(String ofcSal) {
		this.ofcSal = ofcSal;
	}
	
	/**
	 * Column Info
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	/**
	 * Column Info
	 * @param toRsltYrmon
	 */
	public void setToRsltYrmon(String toRsltYrmon) {
		this.toRsltYrmon = toRsltYrmon;
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
	 * @param schDeltFlg
	 */
	public void setSchDeltFlg(String schDeltFlg) {
		this.schDeltFlg = schDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param subTotal
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	
	/**
	 * Column Info
	 * @param closingDate
	 */
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	
	/**
	 * Column Info
	 * @param schSumupGbn
	 */
	public void setSchSumupGbn(String schSumupGbn) {
		this.schSumupGbn = schSumupGbn;
	}
	
	/**
	 * Column Info
	 * @param slpTjNo
	 */
	public void setSlpTjNo(String slpTjNo) {
		this.slpTjNo = slpTjNo;
	}
	
	/**
	 * Column Info
	 * @param comDiffNum
	 */
	public void setComDiffNum(String comDiffNum) {
		this.comDiffNum = comDiffNum;
	}
	
	/**
	 * Column Info
	 * @param plnYrmon
	 */
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	
	/**
	 * Column Info
	 * @param ofcCo
	 */
	public void setOfcCo(String ofcCo) {
		this.ofcCo = ofcCo;
	}
	
	/**
	 * Column Info
	 * @param rtToMon
	 */
	public void setRtToMon(String rtToMon) {
		this.rtToMon = rtToMon;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param rtFmMon
	 */
	public void setRtFmMon(String rtFmMon) {
		this.rtFmMon = rtFmMon;
	}
	
	/**
	 * Column Info
	 * @param langDiv
	 */
	public void setLangDiv(String langDiv) {
		this.langDiv = langDiv;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param perfDiv
	 */
	public void setPerfDiv(String perfDiv) {
		this.perfDiv = perfDiv;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstTpCd
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcDivCd
	 */
	public void setSlsOfcDivCd(String slsOfcDivCd) {
		this.slsOfcDivCd = slsOfcDivCd;
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
		setRsltYrmon(JSPUtil.getParameter(request, prefix + "rslt_yrmon", ""));
		setSchExpenseTo(JSPUtil.getParameter(request, prefix + "sch_expense_to", ""));
		setComDiff(JSPUtil.getParameter(request, prefix + "com_diff", ""));
		setComRatio(JSPUtil.getParameter(request, prefix + "com_ratio", ""));
		setSchTicCd(JSPUtil.getParameter(request, prefix + "sch_tic_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMonthlyView(JSPUtil.getParameter(request, prefix + "monthly_view", ""));
		setSchExpenseFrom(JSPUtil.getParameter(request, prefix + "sch_expense_from", ""));
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, prefix + "gen_expn_trns_div_cd", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, prefix + "gen_expn_rqst_no", ""));
		setPlnYr(JSPUtil.getParameter(request, prefix + "pln_yr", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, prefix + "ofc_co_div_cd", ""));
		setSchLang(JSPUtil.getParameter(request, prefix + "sch_lang", ""));
		setLoginOffice(JSPUtil.getParameter(request, prefix + "login_office", ""));
		setExpnDep(JSPUtil.getParameter(request, prefix + "expn_dep", ""));
		setPlnMon(JSPUtil.getParameter(request, prefix + "pln_mon", ""));
		setOfcCur(JSPUtil.getParameter(request, prefix + "ofc_cur", ""));
		setComRatioNum(JSPUtil.getParameter(request, prefix + "com_ratio_num", ""));
		setCurUnit(JSPUtil.getParameter(request, prefix + "cur_unit", ""));
		setSchExpenseGroup(JSPUtil.getParameter(request, prefix + "sch_expense_group", ""));
		setOfcLvl1(JSPUtil.getParameter(request, prefix + "ofc_lvl1", ""));
		setOfcLvl2(JSPUtil.getParameter(request, prefix + "ofc_lvl2", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setSubOfficeView(JSPUtil.getParameter(request, prefix + "sub_office_view", ""));
		setOfcLvl3(JSPUtil.getParameter(request, prefix + "ofc_lvl3", ""));
		setSchAppDivGbn(JSPUtil.getParameter(request, prefix + "sch_app_div_gbn", ""));
		setOfcExpnCd(JSPUtil.getParameter(request, prefix + "ofc_expn_cd", ""));
		setFromRsltYrmon(JSPUtil.getParameter(request, prefix + "from_rslt_yrmon", ""));
		setRtYr(JSPUtil.getParameter(request, prefix + "rt_yr", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setOfcSal(JSPUtil.getParameter(request, prefix + "ofc_sal", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setToRsltYrmon(JSPUtil.getParameter(request, prefix + "to_rslt_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSchDeltFlg(JSPUtil.getParameter(request, prefix + "sch_delt_flg", ""));
		setSubTotal(JSPUtil.getParameter(request, prefix + "sub_total", ""));
		setClosingDate(JSPUtil.getParameter(request, prefix + "closing_date", ""));
		setSchSumupGbn(JSPUtil.getParameter(request, prefix + "sch_sumup_gbn", ""));
		setSlpTjNo(JSPUtil.getParameter(request, prefix + "slp_tj_no", ""));
		setComDiffNum(JSPUtil.getParameter(request, prefix + "com_diff_num", ""));
		setPlnYrmon(JSPUtil.getParameter(request, prefix + "pln_yrmon", ""));
		setOfcCo(JSPUtil.getParameter(request, prefix + "ofc_co", ""));
		setRtToMon(JSPUtil.getParameter(request, prefix + "rt_to_mon", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setRtFmMon(JSPUtil.getParameter(request, prefix + "rt_fm_mon", ""));
		setLangDiv(JSPUtil.getParameter(request, prefix + "lang_div", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setPerfDiv(JSPUtil.getParameter(request, prefix + "perf_div", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, prefix + "gen_expn_rqst_seq", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, prefix + "gen_expn_rqst_tp_cd", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RqstInfoVO[]
	 */
	public RqstInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RqstInfoVO[]
	 */
	public RqstInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RqstInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon", length));
			String[] schExpenseTo = (JSPUtil.getParameter(request, prefix	+ "sch_expense_to", length));
			String[] comDiff = (JSPUtil.getParameter(request, prefix	+ "com_diff", length));
			String[] comRatio = (JSPUtil.getParameter(request, prefix	+ "com_ratio", length));
			String[] schTicCd = (JSPUtil.getParameter(request, prefix	+ "sch_tic_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] monthlyView = (JSPUtil.getParameter(request, prefix	+ "monthly_view", length));
			String[] schExpenseFrom = (JSPUtil.getParameter(request, prefix	+ "sch_expense_from", length));
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			String[] schLang = (JSPUtil.getParameter(request, prefix	+ "sch_lang", length));
			String[] loginOffice = (JSPUtil.getParameter(request, prefix	+ "login_office", length));
			String[] expnDep = (JSPUtil.getParameter(request, prefix	+ "expn_dep", length));
			String[] plnMon = (JSPUtil.getParameter(request, prefix	+ "pln_mon", length));
			String[] ofcCur = (JSPUtil.getParameter(request, prefix	+ "ofc_cur", length));
			String[] comRatioNum = (JSPUtil.getParameter(request, prefix	+ "com_ratio_num", length));
			String[] curUnit = (JSPUtil.getParameter(request, prefix	+ "cur_unit", length));
			String[] schExpenseGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expense_group", length));
			String[] ofcLvl1 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl1", length));
			String[] ofcLvl2 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl2", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] subOfficeView = (JSPUtil.getParameter(request, prefix	+ "sub_office_view", length));
			String[] ofcLvl3 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl3", length));
			String[] schAppDivGbn = (JSPUtil.getParameter(request, prefix	+ "sch_app_div_gbn", length));
			String[] ofcExpnCd = (JSPUtil.getParameter(request, prefix	+ "ofc_expn_cd", length));
			String[] fromRsltYrmon = (JSPUtil.getParameter(request, prefix	+ "from_rslt_yrmon", length));
			String[] rtYr = (JSPUtil.getParameter(request, prefix	+ "rt_yr", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] ofcSal = (JSPUtil.getParameter(request, prefix	+ "ofc_sal", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] toRsltYrmon = (JSPUtil.getParameter(request, prefix	+ "to_rslt_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] schDeltFlg = (JSPUtil.getParameter(request, prefix	+ "sch_delt_flg", length));
			String[] subTotal = (JSPUtil.getParameter(request, prefix	+ "sub_total", length));
			String[] closingDate = (JSPUtil.getParameter(request, prefix	+ "closing_date", length));
			String[] schSumupGbn = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_gbn", length));
			String[] slpTjNo = (JSPUtil.getParameter(request, prefix	+ "slp_tj_no", length));
			String[] comDiffNum = (JSPUtil.getParameter(request, prefix	+ "com_diff_num", length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon", length));
			String[] ofcCo = (JSPUtil.getParameter(request, prefix	+ "ofc_co", length));
			String[] rtToMon = (JSPUtil.getParameter(request, prefix	+ "rt_to_mon", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] rtFmMon = (JSPUtil.getParameter(request, prefix	+ "rt_fm_mon", length));
			String[] langDiv = (JSPUtil.getParameter(request, prefix	+ "lang_div", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] perfDiv = (JSPUtil.getParameter(request, prefix	+ "perf_div", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RqstInfoVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				if (schExpenseTo[i] != null)
					model.setSchExpenseTo(schExpenseTo[i]);
				if (comDiff[i] != null)
					model.setComDiff(comDiff[i]);
				if (comRatio[i] != null)
					model.setComRatio(comRatio[i]);
				if (schTicCd[i] != null)
					model.setSchTicCd(schTicCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (monthlyView[i] != null)
					model.setMonthlyView(monthlyView[i]);
				if (schExpenseFrom[i] != null)
					model.setSchExpenseFrom(schExpenseFrom[i]);
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (schLang[i] != null)
					model.setSchLang(schLang[i]);
				if (loginOffice[i] != null)
					model.setLoginOffice(loginOffice[i]);
				if (expnDep[i] != null)
					model.setExpnDep(expnDep[i]);
				if (plnMon[i] != null)
					model.setPlnMon(plnMon[i]);
				if (ofcCur[i] != null)
					model.setOfcCur(ofcCur[i]);
				if (comRatioNum[i] != null)
					model.setComRatioNum(comRatioNum[i]);
				if (curUnit[i] != null)
					model.setCurUnit(curUnit[i]);
				if (schExpenseGroup[i] != null)
					model.setSchExpenseGroup(schExpenseGroup[i]);
				if (ofcLvl1[i] != null)
					model.setOfcLvl1(ofcLvl1[i]);
				if (ofcLvl2[i] != null)
					model.setOfcLvl2(ofcLvl2[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (subOfficeView[i] != null)
					model.setSubOfficeView(subOfficeView[i]);
				if (ofcLvl3[i] != null)
					model.setOfcLvl3(ofcLvl3[i]);
				if (schAppDivGbn[i] != null)
					model.setSchAppDivGbn(schAppDivGbn[i]);
				if (ofcExpnCd[i] != null)
					model.setOfcExpnCd(ofcExpnCd[i]);
				if (fromRsltYrmon[i] != null)
					model.setFromRsltYrmon(fromRsltYrmon[i]);
				if (rtYr[i] != null)
					model.setRtYr(rtYr[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (ofcSal[i] != null)
					model.setOfcSal(ofcSal[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (toRsltYrmon[i] != null)
					model.setToRsltYrmon(toRsltYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (schDeltFlg[i] != null)
					model.setSchDeltFlg(schDeltFlg[i]);
				if (subTotal[i] != null)
					model.setSubTotal(subTotal[i]);
				if (closingDate[i] != null)
					model.setClosingDate(closingDate[i]);
				if (schSumupGbn[i] != null)
					model.setSchSumupGbn(schSumupGbn[i]);
				if (slpTjNo[i] != null)
					model.setSlpTjNo(slpTjNo[i]);
				if (comDiffNum[i] != null)
					model.setComDiffNum(comDiffNum[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (ofcCo[i] != null)
					model.setOfcCo(ofcCo[i]);
				if (rtToMon[i] != null)
					model.setRtToMon(rtToMon[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (rtFmMon[i] != null)
					model.setRtFmMon(rtFmMon[i]);
				if (langDiv[i] != null)
					model.setLangDiv(langDiv[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (perfDiv[i] != null)
					model.setPerfDiv(perfDiv[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRqstInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RqstInfoVO[]
	 */
	public RqstInfoVO[] getRqstInfoVOs(){
		RqstInfoVO[] vos = (RqstInfoVO[])models.toArray(new RqstInfoVO[models.size()]);
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
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseTo = this.schExpenseTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDiff = this.comDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comRatio = this.comRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTicCd = this.schTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monthlyView = this.monthlyView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseFrom = this.schExpenseFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLang = this.schLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOffice = this.loginOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnDep = this.expnDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMon = this.plnMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCur = this.ofcCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comRatioNum = this.comRatioNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curUnit = this.curUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseGroup = this.schExpenseGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl1 = this.ofcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl2 = this.ofcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfficeView = this.subOfficeView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl3 = this.ofcLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schAppDivGbn = this.schAppDivGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcExpnCd = this.ofcExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromRsltYrmon = this.fromRsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtYr = this.rtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcSal = this.ofcSal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRsltYrmon = this.toRsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDeltFlg = this.schDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotal = this.subTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closingDate = this.closingDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupGbn = this.schSumupGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTjNo = this.slpTjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDiffNum = this.comDiffNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCo = this.ofcCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtToMon = this.rtToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFmMon = this.rtFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.langDiv = this.langDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfDiv = this.perfDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
