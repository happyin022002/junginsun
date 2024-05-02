/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchYearlyExpenseVO.java
*@FileTitle : SearchYearlyExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.11 최정미 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchYearlyExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchYearlyExpenseVO> models = new ArrayList<SearchYearlyExpenseVO>();
	
	/* Column Info */
	private String schLvl1 = null;
	/* Column Info */
	private String schSumupOffice = null;
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String schExpenseTo = null;
	/* Column Info */
	private String schComDiv = null;
	/* Column Info */
	private String schStatus = null;
	/* Column Info */
	private String schOfficeGbn = null;
	/* Column Info */
	private String schSlayFlg = null;
	/* Column Info */
	private String schOfficeCode = null;
	/* Column Info */
	private String strAppDivSql = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String schTicCd = null;
	/* Column Info */
	private String schLvl3 = null;
	/* Column Info */
	private String schExpenseFrom = null;
	/* Column Info */
	private String schLvl2 = null;
	/* Column Info */
	private String schCur = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String schDeltFlg = null;
	/* Column Info */
	private String schLang = null;
	/* Column Info */
	private String schCondition = null;
	/* Column Info */
	private String schExpnGroup = null;
	/* Column Info */
	private String schSumupGbn = null;
	/* Column Info */
	private String authOfcCd = null;
	/* Column Info */
	private String schHohqGbn = null;
	/* Column Info */
	private String schTarget = null;
	/* Column Info */
	private String schExpenseGroup = null;
	/* Column Info */
	private String schOfficeLvl = null;
	/* Column Info */
	private String schAppDivGbn = null;
	/* Column Info */
	private String schGenExpnCd = null;
	/* Column Info */
	private String schYrmon = null;
	/* Column Info */
	private String ofcExpnCd = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchYearlyExpenseVO() {}

	public SearchYearlyExpenseVO(String ibflag, String pagerows, String schCondition, String schTarget, String schYrmon, String schCur, String schLang, String schHohqGbn, String schLvl1, String schLvl2, String schLvl3, String schExpenseFrom, String schExpenseTo, String schExpenseGroup, String schTicCd, String schSlayFlg, String schComDiv, String schAppDivGbn, String strAppDivSql, String schStatus, String schOfficeGbn, String schOfficeCode, String schOfficeLvl, String schSumupGbn, String schSumupOffice, String schDeltFlg, String schExpnGroup, String schGenExpnCd, String backendjobKey, String authFlg, String authOfcCd, String ofcExpnCd) {
		this.schLvl1 = schLvl1;
		this.schSumupOffice = schSumupOffice;
		this.authFlg = authFlg;
		this.schExpenseTo = schExpenseTo;
		this.schComDiv = schComDiv;
		this.schStatus = schStatus;
		this.schOfficeGbn = schOfficeGbn;
		this.schSlayFlg = schSlayFlg;
		this.schOfficeCode = schOfficeCode;
		this.strAppDivSql = strAppDivSql;
		this.backendjobKey = backendjobKey;
		this.schTicCd = schTicCd;
		this.schLvl3 = schLvl3;
		this.schExpenseFrom = schExpenseFrom;
		this.schLvl2 = schLvl2;
		this.schCur = schCur;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.schDeltFlg = schDeltFlg;
		this.schLang = schLang;
		this.schCondition = schCondition;
		this.schExpnGroup = schExpnGroup;
		this.schSumupGbn = schSumupGbn;
		this.authOfcCd = authOfcCd;
		this.schHohqGbn = schHohqGbn;
		this.schTarget = schTarget;
		this.schExpenseGroup = schExpenseGroup;
		this.schOfficeLvl = schOfficeLvl;
		this.schAppDivGbn = schAppDivGbn;
		this.schGenExpnCd = schGenExpnCd;
		this.schYrmon = schYrmon;
		this.ofcExpnCd = ofcExpnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sch_lvl1", getSchLvl1());
		this.hashColumns.put("sch_sumup_office", getSchSumupOffice());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("sch_expense_to", getSchExpenseTo());
		this.hashColumns.put("sch_com_div", getSchComDiv());
		this.hashColumns.put("sch_status", getSchStatus());
		this.hashColumns.put("sch_office_gbn", getSchOfficeGbn());
		this.hashColumns.put("sch_slay_flg", getSchSlayFlg());
		this.hashColumns.put("sch_office_code", getSchOfficeCode());
		this.hashColumns.put("str_app_div_sql", getStrAppDivSql());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("sch_tic_cd", getSchTicCd());
		this.hashColumns.put("sch_lvl3", getSchLvl3());
		this.hashColumns.put("sch_expense_from", getSchExpenseFrom());
		this.hashColumns.put("sch_lvl2", getSchLvl2());
		this.hashColumns.put("sch_cur", getSchCur());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_delt_flg", getSchDeltFlg());
		this.hashColumns.put("sch_lang", getSchLang());
		this.hashColumns.put("sch_condition", getSchCondition());
		this.hashColumns.put("sch_expn_group", getSchExpnGroup());
		this.hashColumns.put("sch_sumup_gbn", getSchSumupGbn());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("sch_hohq_gbn", getSchHohqGbn());
		this.hashColumns.put("sch_target", getSchTarget());
		this.hashColumns.put("sch_expense_group", getSchExpenseGroup());
		this.hashColumns.put("sch_office_lvl", getSchOfficeLvl());
		this.hashColumns.put("sch_app_div_gbn", getSchAppDivGbn());
		this.hashColumns.put("sch_gen_expn_cd", getSchGenExpnCd());
		this.hashColumns.put("sch_yrmon", getSchYrmon());
		this.hashColumns.put("ofc_expn_cd", getOfcExpnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sch_lvl1", "schLvl1");
		this.hashFields.put("sch_sumup_office", "schSumupOffice");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("sch_expense_to", "schExpenseTo");
		this.hashFields.put("sch_com_div", "schComDiv");
		this.hashFields.put("sch_status", "schStatus");
		this.hashFields.put("sch_office_gbn", "schOfficeGbn");
		this.hashFields.put("sch_slay_flg", "schSlayFlg");
		this.hashFields.put("sch_office_code", "schOfficeCode");
		this.hashFields.put("str_app_div_sql", "strAppDivSql");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("sch_tic_cd", "schTicCd");
		this.hashFields.put("sch_lvl3", "schLvl3");
		this.hashFields.put("sch_expense_from", "schExpenseFrom");
		this.hashFields.put("sch_lvl2", "schLvl2");
		this.hashFields.put("sch_cur", "schCur");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_delt_flg", "schDeltFlg");
		this.hashFields.put("sch_lang", "schLang");
		this.hashFields.put("sch_condition", "schCondition");
		this.hashFields.put("sch_expn_group", "schExpnGroup");
		this.hashFields.put("sch_sumup_gbn", "schSumupGbn");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("sch_hohq_gbn", "schHohqGbn");
		this.hashFields.put("sch_target", "schTarget");
		this.hashFields.put("sch_expense_group", "schExpenseGroup");
		this.hashFields.put("sch_office_lvl", "schOfficeLvl");
		this.hashFields.put("sch_app_div_gbn", "schAppDivGbn");
		this.hashFields.put("sch_gen_expn_cd", "schGenExpnCd");
		this.hashFields.put("sch_yrmon", "schYrmon");
		this.hashFields.put("ofc_expn_cd", "ofcExpnCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return schLvl1
	 */
	public String getSchLvl1() {
		return this.schLvl1;
	}
	
	/**
	 * Column Info
	 * @return schSumupOffice
	 */
	public String getSchSumupOffice() {
		return this.schSumupOffice;
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
	 * @return schExpenseTo
	 */
	public String getSchExpenseTo() {
		return this.schExpenseTo;
	}
	
	/**
	 * Column Info
	 * @return schComDiv
	 */
	public String getSchComDiv() {
		return this.schComDiv;
	}
	
	/**
	 * Column Info
	 * @return schStatus
	 */
	public String getSchStatus() {
		return this.schStatus;
	}
	
	/**
	 * Column Info
	 * @return schOfficeGbn
	 */
	public String getSchOfficeGbn() {
		return this.schOfficeGbn;
	}
	
	/**
	 * Column Info
	 * @return schSlayFlg
	 */
	public String getSchSlayFlg() {
		return this.schSlayFlg;
	}
	
	/**
	 * Column Info
	 * @return schOfficeCode
	 */
	public String getSchOfficeCode() {
		return this.schOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return strAppDivSql
	 */
	public String getStrAppDivSql() {
		return this.strAppDivSql;
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
	 * @return schTicCd
	 */
	public String getSchTicCd() {
		return this.schTicCd;
	}
	
	/**
	 * Column Info
	 * @return schLvl3
	 */
	public String getSchLvl3() {
		return this.schLvl3;
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
	 * @return schLvl2
	 */
	public String getSchLvl2() {
		return this.schLvl2;
	}
	
	/**
	 * Column Info
	 * @return schCur
	 */
	public String getSchCur() {
		return this.schCur;
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
	 * @return schCondition
	 */
	public String getSchCondition() {
		return this.schCondition;
	}
	
	/**
	 * Column Info
	 * @return schExpnGroup
	 */
	public String getSchExpnGroup() {
		return this.schExpnGroup;
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
	 * @return authOfcCd
	 */
	public String getAuthOfcCd() {
		return this.authOfcCd;
	}
	
	/**
	 * Column Info
	 * @return schHohqGbn
	 */
	public String getSchHohqGbn() {
		return this.schHohqGbn;
	}
	
	/**
	 * Column Info
	 * @return schTarget
	 */
	public String getSchTarget() {
		return this.schTarget;
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
	 * @return schOfficeLvl
	 */
	public String getSchOfficeLvl() {
		return this.schOfficeLvl;
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
	 * @return schGenExpnCd
	 */
	public String getSchGenExpnCd() {
		return this.schGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return schYrmon
	 */
	public String getSchYrmon() {
		return this.schYrmon;
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
	 * @param schLvl1
	 */
	public void setSchLvl1(String schLvl1) {
		this.schLvl1 = schLvl1;
	}
	
	/**
	 * Column Info
	 * @param schSumupOffice
	 */
	public void setSchSumupOffice(String schSumupOffice) {
		this.schSumupOffice = schSumupOffice;
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
	 * @param schExpenseTo
	 */
	public void setSchExpenseTo(String schExpenseTo) {
		this.schExpenseTo = schExpenseTo;
	}
	
	/**
	 * Column Info
	 * @param schComDiv
	 */
	public void setSchComDiv(String schComDiv) {
		this.schComDiv = schComDiv;
	}
	
	/**
	 * Column Info
	 * @param schStatus
	 */
	public void setSchStatus(String schStatus) {
		this.schStatus = schStatus;
	}
	
	/**
	 * Column Info
	 * @param schOfficeGbn
	 */
	public void setSchOfficeGbn(String schOfficeGbn) {
		this.schOfficeGbn = schOfficeGbn;
	}
	
	/**
	 * Column Info
	 * @param schSlayFlg
	 */
	public void setSchSlayFlg(String schSlayFlg) {
		this.schSlayFlg = schSlayFlg;
	}
	
	/**
	 * Column Info
	 * @param schOfficeCode
	 */
	public void setSchOfficeCode(String schOfficeCode) {
		this.schOfficeCode = schOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param strAppDivSql
	 */
	public void setStrAppDivSql(String strAppDivSql) {
		this.strAppDivSql = strAppDivSql;
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
	 * @param schTicCd
	 */
	public void setSchTicCd(String schTicCd) {
		this.schTicCd = schTicCd;
	}
	
	/**
	 * Column Info
	 * @param schLvl3
	 */
	public void setSchLvl3(String schLvl3) {
		this.schLvl3 = schLvl3;
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
	 * @param schLvl2
	 */
	public void setSchLvl2(String schLvl2) {
		this.schLvl2 = schLvl2;
	}
	
	/**
	 * Column Info
	 * @param schCur
	 */
	public void setSchCur(String schCur) {
		this.schCur = schCur;
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
	 * @param schCondition
	 */
	public void setSchCondition(String schCondition) {
		this.schCondition = schCondition;
	}
	
	/**
	 * Column Info
	 * @param schExpnGroup
	 */
	public void setSchExpnGroup(String schExpnGroup) {
		this.schExpnGroup = schExpnGroup;
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
	 * @param authOfcCd
	 */
	public void setAuthOfcCd(String authOfcCd) {
		this.authOfcCd = authOfcCd;
	}
	
	/**
	 * Column Info
	 * @param schHohqGbn
	 */
	public void setSchHohqGbn(String schHohqGbn) {
		this.schHohqGbn = schHohqGbn;
	}
	
	/**
	 * Column Info
	 * @param schTarget
	 */
	public void setSchTarget(String schTarget) {
		this.schTarget = schTarget;
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
	 * @param schOfficeLvl
	 */
	public void setSchOfficeLvl(String schOfficeLvl) {
		this.schOfficeLvl = schOfficeLvl;
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
	 * @param schGenExpnCd
	 */
	public void setSchGenExpnCd(String schGenExpnCd) {
		this.schGenExpnCd = schGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param schYrmon
	 */
	public void setSchYrmon(String schYrmon) {
		this.schYrmon = schYrmon;
	}
	
	/**
	 * Column Info
	 * @param ofcExpnCd
	 */
	public void setOfcExpnCd(String ofcExpnCd) {
		this.ofcExpnCd = ofcExpnCd;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSchLvl1(JSPUtil.getParameter(request, "sch_lvl1", ""));
		setSchSumupOffice(JSPUtil.getParameter(request, "sch_sumup_office", ""));
		setAuthFlg(JSPUtil.getParameter(request, "auth_flg", ""));
		setSchExpenseTo(JSPUtil.getParameter(request, "sch_expense_to", ""));
		setSchComDiv(JSPUtil.getParameter(request, "sch_com_div", ""));
		setSchStatus(JSPUtil.getParameter(request, "sch_status", ""));
		setSchOfficeGbn(JSPUtil.getParameter(request, "sch_office_gbn", ""));
		setSchSlayFlg(JSPUtil.getParameter(request, "sch_slay_flg", ""));
		setSchOfficeCode(JSPUtil.getParameter(request, "sch_office_code", ""));
		setStrAppDivSql(JSPUtil.getParameter(request, "str_app_div_sql", ""));
		setBackendjobKey(JSPUtil.getParameter(request, "backendjob_key", ""));
		setSchTicCd(JSPUtil.getParameter(request, "sch_tic_cd", ""));
		setSchLvl3(JSPUtil.getParameter(request, "sch_lvl3", ""));
		setSchExpenseFrom(JSPUtil.getParameter(request, "sch_expense_from", ""));
		setSchLvl2(JSPUtil.getParameter(request, "sch_lvl2", ""));
		setSchCur(JSPUtil.getParameter(request, "sch_cur", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSchDeltFlg(JSPUtil.getParameter(request, "sch_delt_flg", ""));
		setSchLang(JSPUtil.getParameter(request, "sch_lang", ""));
		setSchCondition(JSPUtil.getParameter(request, "sch_condition", ""));
		setSchExpnGroup(JSPUtil.getParameter(request, "sch_expn_group", ""));
		setSchSumupGbn(JSPUtil.getParameter(request, "sch_sumup_gbn", ""));
		setAuthOfcCd(JSPUtil.getParameter(request, "auth_ofc_cd", ""));
		setSchHohqGbn(JSPUtil.getParameter(request, "sch_hohq_gbn", ""));
		setSchTarget(JSPUtil.getParameter(request, "sch_target", ""));
		setSchExpenseGroup(JSPUtil.getParameter(request, "sch_expense_group", ""));
		setSchOfficeLvl(JSPUtil.getParameter(request, "sch_office_lvl", ""));
		setSchAppDivGbn(JSPUtil.getParameter(request, "sch_app_div_gbn", ""));
		setSchGenExpnCd(JSPUtil.getParameter(request, "sch_gen_expn_cd", ""));
		setSchYrmon(JSPUtil.getParameter(request, "sch_yrmon", ""));
		setOfcExpnCd(JSPUtil.getParameter(request, "ofc_expn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYearlyExpenseVO[]
	 */
	public SearchYearlyExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYearlyExpenseVO[]
	 */
	public SearchYearlyExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchYearlyExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] schLvl1 = (JSPUtil.getParameter(request, prefix	+ "sch_lvl1", length));
			String[] schSumupOffice = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_office", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] schExpenseTo = (JSPUtil.getParameter(request, prefix	+ "sch_expense_to", length));
			String[] schComDiv = (JSPUtil.getParameter(request, prefix	+ "sch_com_div", length));
			String[] schStatus = (JSPUtil.getParameter(request, prefix	+ "sch_status", length));
			String[] schOfficeGbn = (JSPUtil.getParameter(request, prefix	+ "sch_office_gbn", length));
			String[] schSlayFlg = (JSPUtil.getParameter(request, prefix	+ "sch_slay_flg", length));
			String[] schOfficeCode = (JSPUtil.getParameter(request, prefix	+ "sch_office_code", length));
			String[] strAppDivSql = (JSPUtil.getParameter(request, prefix	+ "str_app_div_sql", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] schTicCd = (JSPUtil.getParameter(request, prefix	+ "sch_tic_cd", length));
			String[] schLvl3 = (JSPUtil.getParameter(request, prefix	+ "sch_lvl3", length));
			String[] schExpenseFrom = (JSPUtil.getParameter(request, prefix	+ "sch_expense_from", length));
			String[] schLvl2 = (JSPUtil.getParameter(request, prefix	+ "sch_lvl2", length));
			String[] schCur = (JSPUtil.getParameter(request, prefix	+ "sch_cur", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] schDeltFlg = (JSPUtil.getParameter(request, prefix	+ "sch_delt_flg", length));
			String[] schLang = (JSPUtil.getParameter(request, prefix	+ "sch_lang", length));
			String[] schCondition = (JSPUtil.getParameter(request, prefix	+ "sch_condition", length));
			String[] schExpnGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expn_group", length));
			String[] schSumupGbn = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_gbn", length));
			String[] authOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_ofc_cd", length));
			String[] schHohqGbn = (JSPUtil.getParameter(request, prefix	+ "sch_hohq_gbn", length));
			String[] schTarget = (JSPUtil.getParameter(request, prefix	+ "sch_target", length));
			String[] schExpenseGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expense_group", length));
			String[] schOfficeLvl = (JSPUtil.getParameter(request, prefix	+ "sch_office_lvl", length));
			String[] schAppDivGbn = (JSPUtil.getParameter(request, prefix	+ "sch_app_div_gbn", length));
			String[] schGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "sch_gen_expn_cd", length));
			String[] schYrmon = (JSPUtil.getParameter(request, prefix	+ "sch_yrmon", length));
			String[] ofcExpnCd = (JSPUtil.getParameter(request, prefix	+ "ofc_expn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchYearlyExpenseVO();
				if (schLvl1[i] != null)
					model.setSchLvl1(schLvl1[i]);
				if (schSumupOffice[i] != null)
					model.setSchSumupOffice(schSumupOffice[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (schExpenseTo[i] != null)
					model.setSchExpenseTo(schExpenseTo[i]);
				if (schComDiv[i] != null)
					model.setSchComDiv(schComDiv[i]);
				if (schStatus[i] != null)
					model.setSchStatus(schStatus[i]);
				if (schOfficeGbn[i] != null)
					model.setSchOfficeGbn(schOfficeGbn[i]);
				if (schSlayFlg[i] != null)
					model.setSchSlayFlg(schSlayFlg[i]);
				if (schOfficeCode[i] != null)
					model.setSchOfficeCode(schOfficeCode[i]);
				if (strAppDivSql[i] != null)
					model.setStrAppDivSql(strAppDivSql[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (schTicCd[i] != null)
					model.setSchTicCd(schTicCd[i]);
				if (schLvl3[i] != null)
					model.setSchLvl3(schLvl3[i]);
				if (schExpenseFrom[i] != null)
					model.setSchExpenseFrom(schExpenseFrom[i]);
				if (schLvl2[i] != null)
					model.setSchLvl2(schLvl2[i]);
				if (schCur[i] != null)
					model.setSchCur(schCur[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (schDeltFlg[i] != null)
					model.setSchDeltFlg(schDeltFlg[i]);
				if (schLang[i] != null)
					model.setSchLang(schLang[i]);
				if (schCondition[i] != null)
					model.setSchCondition(schCondition[i]);
				if (schExpnGroup[i] != null)
					model.setSchExpnGroup(schExpnGroup[i]);
				if (schSumupGbn[i] != null)
					model.setSchSumupGbn(schSumupGbn[i]);
				if (authOfcCd[i] != null)
					model.setAuthOfcCd(authOfcCd[i]);
				if (schHohqGbn[i] != null)
					model.setSchHohqGbn(schHohqGbn[i]);
				if (schTarget[i] != null)
					model.setSchTarget(schTarget[i]);
				if (schExpenseGroup[i] != null)
					model.setSchExpenseGroup(schExpenseGroup[i]);
				if (schOfficeLvl[i] != null)
					model.setSchOfficeLvl(schOfficeLvl[i]);
				if (schAppDivGbn[i] != null)
					model.setSchAppDivGbn(schAppDivGbn[i]);
				if (schGenExpnCd[i] != null)
					model.setSchGenExpnCd(schGenExpnCd[i]);
				if (schYrmon[i] != null)
					model.setSchYrmon(schYrmon[i]);
				if (ofcExpnCd[i] != null)
					model.setOfcExpnCd(ofcExpnCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchYearlyExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYearlyExpenseVO[]
	 */
	public SearchYearlyExpenseVO[] getSearchYearlyExpenseVOs(){
		SearchYearlyExpenseVO[] vos = (SearchYearlyExpenseVO[])models.toArray(new SearchYearlyExpenseVO[models.size()]);
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
		this.schLvl1 = this.schLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupOffice = this.schSumupOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseTo = this.schExpenseTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schComDiv = this.schComDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schStatus = this.schStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeGbn = this.schOfficeGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSlayFlg = this.schSlayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeCode = this.schOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strAppDivSql = this.strAppDivSql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTicCd = this.schTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLvl3 = this.schLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseFrom = this.schExpenseFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLvl2 = this.schLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schCur = this.schCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDeltFlg = this.schDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLang = this.schLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schCondition = this.schCondition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpnGroup = this.schExpnGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupGbn = this.schSumupGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd = this.authOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schHohqGbn = this.schHohqGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTarget = this.schTarget .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseGroup = this.schExpenseGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeLvl = this.schOfficeLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schAppDivGbn = this.schAppDivGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schGenExpnCd = this.schGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schYrmon = this.schYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcExpnCd = this.ofcExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
