/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActRsltSubsPerfVO.java
*@FileTitle : ActRsltSubsPerfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.01 박창준 
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

public class ActRsltSubsPerfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActRsltSubsPerfVO> models = new ArrayList<ActRsltSubsPerfVO>();
	
	/* Column Info */
	private String ofcLvl1 = null;
	/* Column Info */
	private String schSumupOffice = null;
	/* Column Info */
	private String schComDiv = null;
	/* Column Info */
	private String schOfficeGbn = null;
	/* Column Info */
	private String slsOfcDivCd = null;
	/* Column Info */
	private String schOfficeCode = null;
	/* Column Info */
	private String strAppDivSql = null;
	/* Column Info */
	private String hdnOfcCd = null;
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
	private String schOfficeLvl = null;
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
	private String authFlg = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* Column Info */
	private String sumUp = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActRsltSubsPerfVO() {}

	public ActRsltSubsPerfVO(String ibflag, String pagerows, String slsOfcDivCd, String ofcLvl1, String ofcLvl2, String ofcLvl3, String schOfficeGbn, String schOfficeCode, String schOfficeLvl, String schComDiv, String schAppDivGbn, String schSumupGbn, String schSumupOffice, String schDeltFlg, String strAppDivSql, String schExpenseGroup, String schLang, String hdnOfcCd, String plnYr, String plnMon, String langDiv, String authFlg, String loginOfcCd, String sumUp) {
		this.ofcLvl1 = ofcLvl1;
		this.schSumupOffice = schSumupOffice;
		this.schComDiv = schComDiv;
		this.schOfficeGbn = schOfficeGbn;
		this.slsOfcDivCd = slsOfcDivCd;
		this.schOfficeCode = schOfficeCode;
		this.strAppDivSql = strAppDivSql;
		this.hdnOfcCd = hdnOfcCd;
		this.schExpenseGroup = schExpenseGroup;
		this.ofcLvl3 = ofcLvl3;
		this.pagerows = pagerows;
		this.ofcLvl2 = ofcLvl2;
		this.ibflag = ibflag;
		this.schOfficeLvl = schOfficeLvl;
		this.schDeltFlg = schDeltFlg;
		this.schLang = schLang;
		this.schAppDivGbn = schAppDivGbn;
		this.schSumupGbn = schSumupGbn;
		this.plnYr = plnYr;
		this.plnMon = plnMon;
		this.langDiv = langDiv;
		this.authFlg = authFlg;
		this.loginOfcCd = loginOfcCd;
		this.sumUp = sumUp;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_lvl1", getOfcLvl1());
		this.hashColumns.put("sch_sumup_office", getSchSumupOffice());
		this.hashColumns.put("sch_com_div", getSchComDiv());
		this.hashColumns.put("sch_office_gbn", getSchOfficeGbn());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		this.hashColumns.put("sch_office_code", getSchOfficeCode());
		this.hashColumns.put("str_app_div_sql", getStrAppDivSql());
		this.hashColumns.put("hdn_ofc_cd", getHdnOfcCd());
		this.hashColumns.put("sch_expense_group", getSchExpenseGroup());
		this.hashColumns.put("ofc_lvl3", getOfcLvl3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_lvl2", getOfcLvl2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_office_lvl", getSchOfficeLvl());
		this.hashColumns.put("sch_delt_flg", getSchDeltFlg());
		this.hashColumns.put("sch_lang", getSchLang());
		this.hashColumns.put("sch_app_div_gbn", getSchAppDivGbn());
		this.hashColumns.put("sch_sumup_gbn", getSchSumupGbn());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_mon", getPlnMon());
		this.hashColumns.put("lang_div", getLangDiv());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("sum_up", getSumUp());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_lvl1", "ofcLvl1");
		this.hashFields.put("sch_sumup_office", "schSumupOffice");
		this.hashFields.put("sch_com_div", "schComDiv");
		this.hashFields.put("sch_office_gbn", "schOfficeGbn");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
		this.hashFields.put("sch_office_code", "schOfficeCode");
		this.hashFields.put("str_app_div_sql", "strAppDivSql");
		this.hashFields.put("hdn_ofc_cd", "hdnOfcCd");
		this.hashFields.put("sch_expense_group", "schExpenseGroup");
		this.hashFields.put("ofc_lvl3", "ofcLvl3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_lvl2", "ofcLvl2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_office_lvl", "schOfficeLvl");
		this.hashFields.put("sch_delt_flg", "schDeltFlg");
		this.hashFields.put("sch_lang", "schLang");
		this.hashFields.put("sch_app_div_gbn", "schAppDivGbn");
		this.hashFields.put("sch_sumup_gbn", "schSumupGbn");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("pln_mon", "plnMon");
		this.hashFields.put("lang_div", "langDiv");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("sum_up", "sumUp");
		return this.hashFields;
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
	 * @return schSumupOffice
	 */
	public String getSchSumupOffice() {
		return this.schSumupOffice;
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
	 * @return schOfficeGbn
	 */
	public String getSchOfficeGbn() {
		return this.schOfficeGbn;
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
	 * @return hdnOfcCd
	 */
	public String getHdnOfcCd() {
		return this.hdnOfcCd;
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
	 * @return schOfficeLvl
	 */
	public String getSchOfficeLvl() {
		return this.schOfficeLvl;
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
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Column Info
	 * @return loginOfcCd
	 */
	public String getLoginOfcCd() {
		return this.loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sumUp
	 */
	public String getSumUp() {
		return this.sumUp;
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
	 * @param schSumupOffice
	 */
	public void setSchSumupOffice(String schSumupOffice) {
		this.schSumupOffice = schSumupOffice;
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
	 * @param schOfficeGbn
	 */
	public void setSchOfficeGbn(String schOfficeGbn) {
		this.schOfficeGbn = schOfficeGbn;
	}
	
	/**
	 * Column Info
	 * @param slsOfcDivCd
	 */
	public void setSlsOfcDivCd(String slsOfcDivCd) {
		this.slsOfcDivCd = slsOfcDivCd;
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
	 * @param hdnOfcCd
	 */
	public void setHdnOfcCd(String hdnOfcCd) {
		this.hdnOfcCd = hdnOfcCd;
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
	 * @param schOfficeLvl
	 */
	public void setSchOfficeLvl(String schOfficeLvl) {
		this.schOfficeLvl = schOfficeLvl;
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
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param loginOfcCd
	 */
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sumUp
	 */
	public void setSumUp(String sumUp) {
		this.sumUp = sumUp;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcLvl1(JSPUtil.getParameter(request, "ofc_lvl1", ""));
		setSchSumupOffice(JSPUtil.getParameter(request, "sch_sumup_office", ""));
		setSchComDiv(JSPUtil.getParameter(request, "sch_com_div", ""));
		setSchOfficeGbn(JSPUtil.getParameter(request, "sch_office_gbn", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, "sls_ofc_div_cd", ""));
		setSchOfficeCode(JSPUtil.getParameter(request, "sch_office_code", ""));
		setStrAppDivSql(JSPUtil.getParameter(request, "str_app_div_sql", ""));
		setHdnOfcCd(JSPUtil.getParameter(request, "hdn_ofc_cd", ""));
		setSchExpenseGroup(JSPUtil.getParameter(request, "sch_expense_group", ""));
		setOfcLvl3(JSPUtil.getParameter(request, "ofc_lvl3", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcLvl2(JSPUtil.getParameter(request, "ofc_lvl2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSchOfficeLvl(JSPUtil.getParameter(request, "sch_office_lvl", ""));
		setSchDeltFlg(JSPUtil.getParameter(request, "sch_delt_flg", ""));
		setSchLang(JSPUtil.getParameter(request, "sch_lang", ""));
		setSchAppDivGbn(JSPUtil.getParameter(request, "sch_app_div_gbn", ""));
		setSchSumupGbn(JSPUtil.getParameter(request, "sch_sumup_gbn", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnMon(JSPUtil.getParameter(request, "pln_mon", ""));
		setLangDiv(JSPUtil.getParameter(request, "lang_div", ""));
		setAuthFlg(JSPUtil.getParameter(request, "auth_flg", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
		setSumUp(JSPUtil.getParameter(request, "sum_up", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return SearchOfficeMgtVO[]
	 */
	public ActRsltSubsPerfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActRsltSubsPerfVO[]
	 */
	public ActRsltSubsPerfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActRsltSubsPerfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcLvl1 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl1".trim(), length));
			String[] schSumupOffice = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_office".trim(), length));
			String[] schComDiv = (JSPUtil.getParameter(request, prefix	+ "sch_com_div".trim(), length));
			String[] schOfficeGbn = (JSPUtil.getParameter(request, prefix	+ "sch_office_gbn".trim(), length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd".trim(), length));
			String[] schOfficeCode = (JSPUtil.getParameter(request, prefix	+ "sch_office_code".trim(), length));
			String[] strAppDivSql = (JSPUtil.getParameter(request, prefix	+ "str_app_div_sql".trim(), length));
			String[] hdnOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdn_ofc_cd".trim(), length));
			String[] schExpenseGroup = (JSPUtil.getParameter(request, prefix	+ "sch_expense_group".trim(), length));
			String[] ofcLvl3 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl3".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcLvl2 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl2".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] schOfficeLvl = (JSPUtil.getParameter(request, prefix	+ "sch_office_lvl".trim(), length));
			String[] schDeltFlg = (JSPUtil.getParameter(request, prefix	+ "sch_delt_flg".trim(), length));
			String[] schLang = (JSPUtil.getParameter(request, prefix	+ "sch_lang".trim(), length));
			String[] schAppDivGbn = (JSPUtil.getParameter(request, prefix	+ "sch_app_div_gbn".trim(), length));
			String[] schSumupGbn = (JSPUtil.getParameter(request, prefix	+ "sch_sumup_gbn".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnMon = (JSPUtil.getParameter(request, prefix	+ "pln_mon".trim(), length));
			String[] langDiv = (JSPUtil.getParameter(request, prefix	+ "lang_div".trim(), length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg".trim(), length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd".trim(), length));
			String[] sumUp = (JSPUtil.getParameter(request, prefix	+ "sum_up".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ActRsltSubsPerfVO();
				if (ofcLvl1[i] != null)
					model.setOfcLvl1(ofcLvl1[i]);
				if (schSumupOffice[i] != null)
					model.setSchSumupOffice(schSumupOffice[i]);
				if (schComDiv[i] != null)
					model.setSchComDiv(schComDiv[i]);
				if (schOfficeGbn[i] != null)
					model.setSchOfficeGbn(schOfficeGbn[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				if (schOfficeCode[i] != null)
					model.setSchOfficeCode(schOfficeCode[i]);
				if (strAppDivSql[i] != null)
					model.setStrAppDivSql(strAppDivSql[i]);
				if (hdnOfcCd[i] != null)
					model.setHdnOfcCd(hdnOfcCd[i]);
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
				if (schOfficeLvl[i] != null)
					model.setSchOfficeLvl(schOfficeLvl[i]);
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
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (sumUp[i] != null)
					model.setSumUp(sumUp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActRsltSubsPerfVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return SearchOfficeMgtVO[]
	 */
	public ActRsltSubsPerfVO[] getActRsltSubsPerfVOs(){
		ActRsltSubsPerfVO[] vos = (ActRsltSubsPerfVO[])models.toArray(new ActRsltSubsPerfVO[models.size()]);
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
		this.ofcLvl1 = this.ofcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupOffice = this.schSumupOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schComDiv = this.schComDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeGbn = this.schOfficeGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeCode = this.schOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strAppDivSql = this.strAppDivSql .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdnOfcCd = this.hdnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schExpenseGroup = this.schExpenseGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl3 = this.ofcLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl2 = this.ofcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfficeLvl = this.schOfficeLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDeltFlg = this.schDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schLang = this.schLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schAppDivGbn = this.schAppDivGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schSumupGbn = this.schSumupGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMon = this.plnMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.langDiv = this.langDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumUp = this.sumUp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
