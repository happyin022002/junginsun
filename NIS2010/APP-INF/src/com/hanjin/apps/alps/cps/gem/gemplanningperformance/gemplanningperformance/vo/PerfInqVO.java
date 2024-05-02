/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerfInqVO.java
*@FileTitle : PerfInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.24 박창준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박창준
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class PerfInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PerfInqVO> models = new ArrayList<PerfInqVO>();
	
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String schExpenseTo = null;
	/* Column Info */
	private String schTicCd = null;
	/* Column Info */
	private String ofcCur = null;
	/* Column Info */
	private String schExpenseGroup = null;
	/* Column Info */
	private String ofcLvl3 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcLvl2 = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String curUnit = null;
	/* Column Info */
	private String schDeltFlg = null;
	/* Column Info */
	private String schLang = null;
	/* Column Info */
	private String schAppDivGbn = null;
	/* Column Info */
	private String schSumupGbn = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnMon = null;
	/* Column Info */
	private String langDiv = null;
	/* Column Info */
	private String subTotal = null;
	/* Column Info */
	private String ofcCo = null;
	/* Column Info */
	private String expnDep = null;
	/* Column Info */
	private String perfDiv = null;
	/* Column Info */
	private String closingDate = null;
	/* Column Info */
	private String comRatio = null;
	/* Column Info */
	private String comRatioNum = null;
	/* Column Info */
	private String comDiff = null;
	/* Column Info */
	private String comDiffNum = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;
	/* Column Info */
	private String rsltYrmon = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PerfInqVO() {}

	public PerfInqVO(String ibflag, String pagerows, String plnYrmon, String fmOfcCd, String ofcLvl2, String ofcLvl3, String toGenExpnCd, String schExpenseTo, String curUnit, String fmGenExpnCd, String schAppDivGbn, String schSumupGbn, String toOfcCd, String schDeltFlg, String schTicCd, String schExpenseGroup, String schLang, String ofcCur, String plnYr, String plnMon, String langDiv, String subTotal, String ofcCo, String expnDep, String perfDiv, String closingDate, String comRatio, String comRatioNum, String comDiff, String comDiffNum, String genExpnRqstTpCd, String rsltYrmon) {
		this.fmOfcCd = fmOfcCd;
		this.toOfcCd = toOfcCd;
		this.fmGenExpnCd = fmGenExpnCd;
		this.toGenExpnCd = toGenExpnCd;
		this.plnYrmon = plnYrmon;
		this.schExpenseTo = schExpenseTo;
		this.schTicCd = schTicCd;
		this.ofcCur = ofcCur;
		this.schExpenseGroup = schExpenseGroup;
		this.ofcLvl3 = ofcLvl3;
		this.pagerows = pagerows;
		this.ofcLvl2 = ofcLvl2;
		this.ibflag = ibflag;
		this.curUnit = curUnit;
		this.schDeltFlg = schDeltFlg;
		this.schLang = schLang;
		this.schAppDivGbn = schAppDivGbn;
		this.schSumupGbn = schSumupGbn;
		this.plnYr = plnYr;
		this.plnMon = plnMon;
		this.langDiv = langDiv;
		this.subTotal = subTotal;
		this.ofcCo = ofcCo;
		this.expnDep = expnDep;
		this.perfDiv = perfDiv;
		this.closingDate = closingDate;
		this.comRatio = comRatio;
		this.comRatioNum = comRatioNum;
		this.comDiff = comDiff;
		this.comDiffNum = comDiffNum;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("sch_expense_to", getSchExpenseTo());
		this.hashColumns.put("sch_tic_cd", getSchTicCd());
		this.hashColumns.put("ofc_cur", getOfcCur());
		this.hashColumns.put("sch_expense_group", getSchExpenseGroup());
		this.hashColumns.put("ofc_lvl3", getOfcLvl3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_lvl2", getOfcLvl2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cur_unit", getCurUnit());
		this.hashColumns.put("sch_delt_flg", getSchDeltFlg());
		this.hashColumns.put("sch_lang", getSchLang());
		this.hashColumns.put("sch_app_div_gbn", getSchAppDivGbn());
		this.hashColumns.put("sch_sumup_gbn", getSchSumupGbn());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_mon", getPlnMon());
		this.hashColumns.put("lang_div", getLangDiv());
		this.hashColumns.put("sub_total", getSubTotal());
		this.hashColumns.put("ofc_co", getOfcCo());
		this.hashColumns.put("expn_dep", getExpnDep());
		this.hashColumns.put("perf_div", getPerfDiv());
		this.hashColumns.put("closing_date", getClosingDate());
		this.hashColumns.put("com_ratio", getComRatio());
		this.hashColumns.put("com_ratio_num", getComRatioNum());
		this.hashColumns.put("com_diff", getComDiff());
		this.hashColumns.put("com_diff_num", getComDiffNum());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("sch_expense_to", "schExpenseTo");
		this.hashFields.put("sch_tic_cd", "schTicCd");
		this.hashFields.put("ofc_cur", "ofcCur");
		this.hashFields.put("sch_expense_group", "schExpenseGroup");
		this.hashFields.put("ofc_lvl3", "ofcLvl3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_lvl2", "ofcLvl2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cur_unit", "curUnit");
		this.hashFields.put("sch_delt_flg", "schDeltFlg");
		this.hashFields.put("sch_lang", "schLang");
		this.hashFields.put("sch_app_div_gbn", "schAppDivGbn");
		this.hashFields.put("sch_sumup_gbn", "schSumupGbn");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("pln_mon", "plnMon");
		this.hashFields.put("lang_div", "langDiv");
		this.hashFields.put("sub_total", "subTotal");
		this.hashFields.put("ofc_co", "ofcCo");
		this.hashFields.put("expn_dep", "expnDep");
		this.hashFields.put("perf_div", "perfDiv");
		this.hashFields.put("closing_date", "closingDate");
		this.hashFields.put("com_ratio", "comRatio");
		this.hashFields.put("com_ratio_num", "comRatioNum");
		this.hashFields.put("com_diff", "comDiff");
		this.hashFields.put("com_diff_num", "comDiffNum");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		this.hashFields.put("rslt_yrmon", "genRsltYrmon");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmOfcCd
	 */
	public String getFmOfcCd() {
		return this.fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toOfcCd
	 */
	public String getToOfcCd() {
		return this.toOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnCd
	 */
	public String getFmGenExpnCd() {
		return this.fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnCd
	 */
	public String getToGenExpnCd() {
		return this.toGenExpnCd;
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
	 * @return schExpenseTo
	 */
	public String getSchExpenseTo() {
		return this.schExpenseTo;
	}
	
	/**
	 * Column Info
	 * @return schTicCd
	 */
	public String getSchTicCd() {
		return this.schTicCd;
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
	 * @return schExpenseGroup
	 */
	public String getSchExpenseGroup() {
		return this.schExpenseGroup;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl3
	 */
	public String getOfcLvl3() {
		return this.ofcLvl3;
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
	 * @return ofcLvl2
	 */
	public String getOfcLvl2() {
		return this.ofcLvl2;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return schDeltFlg
	 */
	public String getSchDeltFlg() {
		return this.schDeltFlg;
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
	 * @return schAppDivGbn
	 */
	public String getSchAppDivGbn() {
		return this.schAppDivGbn;
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
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
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
	 * @return langDiv
	 */
	public String getLangDiv() {
		return this.langDiv;
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
	 * @return ofcCo
	 */
	public String getOfcCo() {
		return this.ofcCo;
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
	 * @return perfDiv
	 */
	public String getPerfDiv() {
		return this.perfDiv;
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
	 * @return comRatio
	 */
	public String getComRatio() {
		return this.comRatio;
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
	 * @return comDiff
	 */
	public String getComDiff() {
		return this.comDiff;
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
	 * @return genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return this.genExpnRqstTpCd;
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
	 * @param fmOfcCd
	 */
	public void setFmOfcCd(String fmOfcCd) {
		this.fmOfcCd = fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toOfcCd
	 */
	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnCd
	 */
	public void setFmGenExpnCd(String fmGenExpnCd) {
		this.fmGenExpnCd = fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCd
	 */
	public void setToGenExpnCd(String toGenExpnCd) {
		this.toGenExpnCd = toGenExpnCd;
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
	 * @param schExpenseTo
	 */
	public void setSchExpenseTo(String schExpenseTo) {
		this.schExpenseTo = schExpenseTo;
	}
	
	/**
	 * Column Info
	 * @param schTicCd
	 */
	public void setSchTicCd(String schTicCd) {
		this.schTicCd = schTicCd;
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
	 * @param schExpenseGroup
	 */
	public void setSchExpenseGroup(String schExpenseGroup) {
		this.schExpenseGroup = schExpenseGroup;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl3
	 */
	public void setOfcLvl3(String ofcLvl3) {
		this.ofcLvl3 = ofcLvl3;
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
	 * @param ofcLvl2
	 */
	public void setOfcLvl2(String ofcLvl2) {
		this.ofcLvl2 = ofcLvl2;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param schDeltFlg
	 */
	public void setSchDeltFlg(String schDeltFlg) {
		this.schDeltFlg = schDeltFlg;
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
	 * @param schAppDivGbn
	 */
	public void setSchAppDivGbn(String schAppDivGbn) {
		this.schAppDivGbn = schAppDivGbn;
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
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
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
	 * @param langDiv
	 */
	public void setLangDiv(String langDiv) {
		this.langDiv = langDiv;
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
	 * @param ofcCo
	 */
	public void setOfcCo(String ofcCo) {
		this.ofcCo = ofcCo;
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
	 * @param perfDiv
	 */
	public void setPerfDiv(String perfDiv) {
		this.perfDiv = perfDiv;
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
	 * @param comRatio
	 */
	public void setComRatio(String comRatio) {
		this.comRatio = comRatio;
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
	 * @param comDiff
	 */
	public void setComDiff(String comDiff) {
		this.comDiff = comDiff;
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
	 * @param genExpnRqstTpCd
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, "fm_gen_expn_cd", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", ""));
		setSchExpenseTo(JSPUtil.getParameter(request, "sch_expense_to", ""));
		setSchTicCd(JSPUtil.getParameter(request, "sch_tic_cd", ""));
		setOfcCur(JSPUtil.getParameter(request, "ofc_cur", ""));
		setSchExpenseGroup(JSPUtil.getParameter(request, "sch_expense_group", ""));
		setOfcLvl3(JSPUtil.getParameter(request, "ofc_lvl3", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcLvl2(JSPUtil.getParameter(request, "ofc_lvl2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurUnit(JSPUtil.getParameter(request, "cur_unit", ""));
		setSchDeltFlg(JSPUtil.getParameter(request, "sch_delt_flg", ""));
		setSchLang(JSPUtil.getParameter(request, "sch_lang", ""));
		setSchAppDivGbn(JSPUtil.getParameter(request, "sch_app_div_gbn", ""));
		setSchSumupGbn(JSPUtil.getParameter(request, "sch_sumup_gbn", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnMon(JSPUtil.getParameter(request, "pln_mon", ""));
		setLangDiv(JSPUtil.getParameter(request, "lang_div", ""));
		setSubTotal(JSPUtil.getParameter(request, "sub_total", ""));
		setOfcCo(JSPUtil.getParameter(request, "ofc_co", ""));
		setExpnDep(JSPUtil.getParameter(request, "expn_dep", ""));
		setPerfDiv(JSPUtil.getParameter(request, "perf_div", ""));
		setClosingDate(JSPUtil.getParameter(request, "closing_date", ""));
		setComRatio(JSPUtil.getParameter(request, "com_ratio", ""));
		setComRatioNum(JSPUtil.getParameter(request, "com_ratio_num", ""));
		setComDiff(JSPUtil.getParameter(request, "com_diff", ""));
		setComDiffNum(JSPUtil.getParameter(request, "com_diff_num", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, "gen_expn_rqst_tp_cd", ""));
		setRsltYrmon(JSPUtil.getParameter(request, "rslt_yrmon", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return PerfInqVO[]
	 */
	public PerfInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PerfInqVO[]
	 */
	public PerfInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PerfInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd".trim(), length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd".trim(), length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd".trim(), length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd".trim(), length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon".trim(), length));
			String[] schExpenseTo = (JSPUtil.getParameter(request, prefix	+ "sch_expense_to".trim(), length));
			String[] schTicCd = (JSPUtil.getParameter(request, prefix	+ "sch_tic_cd".trim(), length));
			String[] ofcCur = (JSPUtil.getParameter(request, prefix	+ "ofc_cur".trim(), length));
			String[] schExpenseGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expense_group".trim(), length));
			String[] ofcLvl3 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl3".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcLvl2 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl2".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] curUnit = (JSPUtil.getParameter(request, prefix	+ "cur_unit".trim(), length));
			String[] schDeltFlg = (JSPUtil.getParameter(request, prefix	+ "sch_delt_flg".trim(), length));
			String[] schLang = (JSPUtil.getParameter(request, prefix	+ "sch_lang".trim(), length));
			String[] schAppDivGbn = (JSPUtil.getParameter(request, prefix	+ "sch_app_div_gbn".trim(), length));
			String[] schSumupGbn = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_gbn".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnMon = (JSPUtil.getParameter(request, prefix	+ "pln_mon".trim(), length));
			String[] langDiv = (JSPUtil.getParameter(request, prefix	+ "lang_div".trim(), length));
			String[] subTotal = (JSPUtil.getParameter(request, prefix	+ "sub_total".trim(), length));
			String[] ofcCo = (JSPUtil.getParameter(request, prefix	+ "ofc_co".trim(), length));
			String[] expnDep = (JSPUtil.getParameter(request, prefix	+ "expn_dep".trim(), length));
			String[] perfDiv = (JSPUtil.getParameter(request, prefix	+ "perf_div".trim(), length));
			String[] closingDate = (JSPUtil.getParameter(request, prefix	+ "closing_date".trim(), length));
			String[] comRatio = (JSPUtil.getParameter(request, prefix	+ "com_ratio".trim(), length));
			String[] comRatioNum = (JSPUtil.getParameter(request, prefix	+ "com_ratio_num".trim(), length));
			String[] comDiff = (JSPUtil.getParameter(request, prefix	+ "com_diff".trim(), length));
			String[] comDiffNum = (JSPUtil.getParameter(request, prefix	+ "com_diff_num".trim(), length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd".trim(), length));
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PerfInqVO();
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (schExpenseTo[i] != null)
					model.setSchExpenseTo(schExpenseTo[i]);
				if (schTicCd[i] != null)
					model.setSchTicCd(schTicCd[i]);
				if (ofcCur[i] != null)
					model.setOfcCur(ofcCur[i]);
				if (schExpenseGroup[i] != null)
					model.setSchExpenseGroup(schExpenseGroup[i]);
				if (ofcLvl3[i] != null)
					model.setOfcLvl3(ofcLvl3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcLvl2[i] != null)
					model.setOfcLvl2(ofcLvl2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (curUnit[i] != null)
					model.setCurUnit(curUnit[i]);
				if (schDeltFlg[i] != null)
					model.setSchDeltFlg(schDeltFlg[i]);
				if (schLang[i] != null)
					model.setSchLang(schLang[i]);
				if (schAppDivGbn[i] != null)
					model.setSchAppDivGbn(schAppDivGbn[i]);
				if (schSumupGbn[i] != null)
					model.setSchSumupGbn(schSumupGbn[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnMon[i] != null)
					model.setPlnMon(plnMon[i]);
				if (langDiv[i] != null)
					model.setLangDiv(langDiv[i]);
				if (subTotal[i] != null)
					model.setSubTotal(subTotal[i]);
				if (ofcCo[i] != null)
					model.setOfcCo(ofcCo[i]);
				if (expnDep[i] != null)
					model.setExpnDep(expnDep[i]);
				if (perfDiv[i] != null)
					model.setPerfDiv(perfDiv[i]);
				if (closingDate[i] != null)
					model.setClosingDate(closingDate[i]);
				if (comRatio[i] != null)
					model.setComRatio(comRatio[i]);
				if (comRatioNum[i] != null)
					model.setComRatioNum(comRatioNum[i]);
				if (comDiff[i] != null)
					model.setComDiff(comDiff[i]);
				if (comDiffNum[i] != null)
					model.setComDiffNum(comDiffNum[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPerfInqVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return PerfInqVO[]
	 */
	public PerfInqVO[] getPerfInqVOs(){
		PerfInqVO[] vos = (PerfInqVO[])models.toArray(new PerfInqVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseTo = this.schExpenseTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTicCd = this.schTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCur = this.ofcCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseGroup = this.schExpenseGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl3 = this.ofcLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl2 = this.ofcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curUnit = this.curUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDeltFlg = this.schDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLang = this.schLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schAppDivGbn = this.schAppDivGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupGbn = this.schSumupGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMon = this.plnMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.langDiv = this.langDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTotal = this.subTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCo = this.ofcCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnDep = this.expnDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfDiv = this.perfDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closingDate = this.closingDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comRatio = this.comRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comRatioNum = this.comRatioNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDiff = this.comDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comDiffNum = this.comDiffNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
