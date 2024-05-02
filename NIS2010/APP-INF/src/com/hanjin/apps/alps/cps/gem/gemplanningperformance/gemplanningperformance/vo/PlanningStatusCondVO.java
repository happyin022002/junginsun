/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PlanningStatusCondVO.java
*@FileTitle : PlanningStatusCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.11
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.10.11 김창헌 
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
 * @author 김창헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PlanningStatusCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PlanningStatusCondVO> models = new ArrayList<PlanningStatusCondVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String crntGenExpnAproStepCd = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* Column Info */
	private String ofcExpnDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String roleOfcCd = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String genExpnAproAuthOfcCd = null;
	/* Column Info */
	private String crntGenExpnApstsCd = null;
	/* Column Info */
	private String fmTicCd = null;
	/* Column Info */
	private String sumUp = null;
	/* Column Info */
	private String langDiv = null;
	/* Column Info */
	private String ofcLvl1 = null;
	/* Column Info */
	private String fmGenExpnCdGrp = null;
	/* Column Info */
	private String ticAuthOfcCd = null;
	/* Column Info */
	private String ofcLvl2 = null;
	/* Column Info */
	private String ofcLvl3 = null;
	/* Column Info */
	private String ofcExpnCd = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;
	/* Column Info */
	private String slsOfcDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PlanningStatusCondVO() {}

	public PlanningStatusCondVO(String ibflag, String pagerows, String genExpnRqstNo, String crntGenExpnAproStepCd, String crntGenExpnApstsCd, String plnYrmon, String genExpnRqstTpCd, String fmOfcCd, String fmGenExpnCd, String fmGenExpnCdGrp, String fmTicCd, String currCd, String langDiv, String ofcLvl1, String ofcLvl2, String ofcLvl3, String slsOfcDivCd, String ofcExpnDiv, String sumUp, String genExpnAproAuthOfcCd, String roleOfcCd, String ofcExpnCd, String userOfcCd, String authFlg, String ticAuthOfcCd) {
		this.userOfcCd = userOfcCd;
		this.authFlg = authFlg;
		this.currCd = currCd;
		this.crntGenExpnAproStepCd = crntGenExpnAproStepCd;
		this.fmOfcCd = fmOfcCd;
		this.fmGenExpnCd = fmGenExpnCd;
		this.ofcExpnDiv = ofcExpnDiv;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.genExpnRqstNo = genExpnRqstNo;
		this.roleOfcCd = roleOfcCd;
		this.plnYrmon = plnYrmon;
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
		this.crntGenExpnApstsCd = crntGenExpnApstsCd;
		this.fmTicCd = fmTicCd;
		this.sumUp = sumUp;
		this.langDiv = langDiv;
		this.ofcLvl1 = ofcLvl1;
		this.fmGenExpnCdGrp = fmGenExpnCdGrp;
		this.ticAuthOfcCd = ticAuthOfcCd;
		this.ofcLvl2 = ofcLvl2;
		this.ofcLvl3 = ofcLvl3;
		this.ofcExpnCd = ofcExpnCd;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("crnt_gen_expn_apro_step_cd", getCrntGenExpnAproStepCd());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("ofc_expn_div", getOfcExpnDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("role_ofc_cd", getRoleOfcCd());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("gen_expn_apro_auth_ofc_cd", getGenExpnAproAuthOfcCd());
		this.hashColumns.put("crnt_gen_expn_apsts_cd", getCrntGenExpnApstsCd());
		this.hashColumns.put("fm_tic_cd", getFmTicCd());
		this.hashColumns.put("sum_up", getSumUp());
		this.hashColumns.put("lang_div", getLangDiv());
		this.hashColumns.put("ofc_lvl1", getOfcLvl1());
		this.hashColumns.put("fm_gen_expn_cd_grp", getFmGenExpnCdGrp());
		this.hashColumns.put("tic_auth_ofc_cd", getTicAuthOfcCd());
		this.hashColumns.put("ofc_lvl2", getOfcLvl2());
		this.hashColumns.put("ofc_lvl3", getOfcLvl3());
		this.hashColumns.put("ofc_expn_cd", getOfcExpnCd());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("crnt_gen_expn_apro_step_cd", "crntGenExpnAproStepCd");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("ofc_expn_div", "ofcExpnDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("role_ofc_cd", "roleOfcCd");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("gen_expn_apro_auth_ofc_cd", "genExpnAproAuthOfcCd");
		this.hashFields.put("crnt_gen_expn_apsts_cd", "crntGenExpnApstsCd");
		this.hashFields.put("fm_tic_cd", "fmTicCd");
		this.hashFields.put("sum_up", "sumUp");
		this.hashFields.put("lang_div", "langDiv");
		this.hashFields.put("ofc_lvl1", "ofcLvl1");
		this.hashFields.put("fm_gen_expn_cd_grp", "fmGenExpnCdGrp");
		this.hashFields.put("tic_auth_ofc_cd", "ticAuthOfcCd");
		this.hashFields.put("ofc_lvl2", "ofcLvl2");
		this.hashFields.put("ofc_lvl3", "ofcLvl3");
		this.hashFields.put("ofc_expn_cd", "ofcExpnCd");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return crntGenExpnAproStepCd
	 */
	public String getCrntGenExpnAproStepCd() {
		return this.crntGenExpnAproStepCd;
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
	 * @return fmGenExpnCd
	 */
	public String getFmGenExpnCd() {
		return this.fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return ofcExpnDiv
	 */
	public String getOfcExpnDiv() {
		return this.ofcExpnDiv;
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
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return roleOfcCd
	 */
	public String getRoleOfcCd() {
		return this.roleOfcCd;
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
	 * @return genExpnAproAuthOfcCd
	 */
	public String getGenExpnAproAuthOfcCd() {
		return this.genExpnAproAuthOfcCd;
	}
	
	/**
	 * Column Info
	 * @return crntGenExpnApstsCd
	 */
	public String getCrntGenExpnApstsCd() {
		return this.crntGenExpnApstsCd;
	}
	
	/**
	 * Column Info
	 * @return fmTicCd
	 */
	public String getFmTicCd() {
		return this.fmTicCd;
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
	 * @return langDiv
	 */
	public String getLangDiv() {
		return this.langDiv;
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
	 * @return fmGenExpnCdGrp
	 */
	public String getFmGenExpnCdGrp() {
		return this.fmGenExpnCdGrp;
	}
	
	/**
	 * Column Info
	 * @return ticAuthOfcCd
	 */
	public String getTicAuthOfcCd() {
		return this.ticAuthOfcCd;
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
	 * @return ofcLvl3
	 */
	public String getOfcLvl3() {
		return this.ofcLvl3;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param crntGenExpnAproStepCd
	 */
	public void setCrntGenExpnAproStepCd(String crntGenExpnAproStepCd) {
		this.crntGenExpnAproStepCd = crntGenExpnAproStepCd;
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
	 * @param fmGenExpnCd
	 */
	public void setFmGenExpnCd(String fmGenExpnCd) {
		this.fmGenExpnCd = fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param ofcExpnDiv
	 */
	public void setOfcExpnDiv(String ofcExpnDiv) {
		this.ofcExpnDiv = ofcExpnDiv;
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
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param roleOfcCd
	 */
	public void setRoleOfcCd(String roleOfcCd) {
		this.roleOfcCd = roleOfcCd;
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
	 * @param genExpnAproAuthOfcCd
	 */
	public void setGenExpnAproAuthOfcCd(String genExpnAproAuthOfcCd) {
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
	}
	
	/**
	 * Column Info
	 * @param crntGenExpnApstsCd
	 */
	public void setCrntGenExpnApstsCd(String crntGenExpnApstsCd) {
		this.crntGenExpnApstsCd = crntGenExpnApstsCd;
	}
	
	/**
	 * Column Info
	 * @param fmTicCd
	 */
	public void setFmTicCd(String fmTicCd) {
		this.fmTicCd = fmTicCd;
	}
	
	/**
	 * Column Info
	 * @param sumUp
	 */
	public void setSumUp(String sumUp) {
		this.sumUp = sumUp;
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
	 * @param ofcLvl1
	 */
	public void setOfcLvl1(String ofcLvl1) {
		this.ofcLvl1 = ofcLvl1;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnCdGrp
	 */
	public void setFmGenExpnCdGrp(String fmGenExpnCdGrp) {
		this.fmGenExpnCdGrp = fmGenExpnCdGrp;
	}
	
	/**
	 * Column Info
	 * @param ticAuthOfcCd
	 */
	public void setTicAuthOfcCd(String ticAuthOfcCd) {
		this.ticAuthOfcCd = ticAuthOfcCd;
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
	 * @param ofcLvl3
	 */
	public void setOfcLvl3(String ofcLvl3) {
		this.ofcLvl3 = ofcLvl3;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCrntGenExpnAproStepCd(JSPUtil.getParameter(request, prefix + "crnt_gen_expn_apro_step_cd", ""));
		setFmOfcCd(JSPUtil.getParameter(request, prefix + "fm_ofc_cd", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, prefix + "fm_gen_expn_cd", ""));
		setOfcExpnDiv(JSPUtil.getParameter(request, prefix + "ofc_expn_div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, prefix + "gen_expn_rqst_no", ""));
		setRoleOfcCd(JSPUtil.getParameter(request, prefix + "role_ofc_cd", ""));
		setPlnYrmon(JSPUtil.getParameter(request, prefix + "pln_yrmon", ""));
		setGenExpnAproAuthOfcCd(JSPUtil.getParameter(request, prefix + "gen_expn_apro_auth_ofc_cd", ""));
		setCrntGenExpnApstsCd(JSPUtil.getParameter(request, prefix + "crnt_gen_expn_apsts_cd", ""));
		setFmTicCd(JSPUtil.getParameter(request, prefix + "fm_tic_cd", ""));
		setSumUp(JSPUtil.getParameter(request, prefix + "sum_up", ""));
		setLangDiv(JSPUtil.getParameter(request, prefix + "lang_div", ""));
		setOfcLvl1(JSPUtil.getParameter(request, prefix + "ofc_lvl1", ""));
		setFmGenExpnCdGrp(JSPUtil.getParameter(request, prefix + "fm_gen_expn_cd_grp", ""));
		setTicAuthOfcCd(JSPUtil.getParameter(request, prefix + "tic_auth_ofc_cd", ""));
		setOfcLvl2(JSPUtil.getParameter(request, prefix + "ofc_lvl2", ""));
		setOfcLvl3(JSPUtil.getParameter(request, prefix + "ofc_lvl3", ""));
		setOfcExpnCd(JSPUtil.getParameter(request, prefix + "ofc_expn_cd", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, prefix + "gen_expn_rqst_tp_cd", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PlanningStatusCondVO[]
	 */
	public PlanningStatusCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PlanningStatusCondVO[]
	 */
	public PlanningStatusCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PlanningStatusCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] crntGenExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "crnt_gen_expn_apro_step_cd", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd", length));
			String[] ofcExpnDiv = (JSPUtil.getParameter(request, prefix	+ "ofc_expn_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] roleOfcCd = (JSPUtil.getParameter(request, prefix	+ "role_ofc_cd", length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon", length));
			String[] genExpnAproAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_auth_ofc_cd", length));
			String[] crntGenExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "crnt_gen_expn_apsts_cd", length));
			String[] fmTicCd = (JSPUtil.getParameter(request, prefix	+ "fm_tic_cd", length));
			String[] sumUp = (JSPUtil.getParameter(request, prefix	+ "sum_up", length));
			String[] langDiv = (JSPUtil.getParameter(request, prefix	+ "lang_div", length));
			String[] ofcLvl1 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl1", length));
			String[] fmGenExpnCdGrp = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd_grp", length));
			String[] ticAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "tic_auth_ofc_cd", length));
			String[] ofcLvl2 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl2", length));
			String[] ofcLvl3 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl3", length));
			String[] ofcExpnCd = (JSPUtil.getParameter(request, prefix	+ "ofc_expn_cd", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PlanningStatusCondVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (crntGenExpnAproStepCd[i] != null)
					model.setCrntGenExpnAproStepCd(crntGenExpnAproStepCd[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (ofcExpnDiv[i] != null)
					model.setOfcExpnDiv(ofcExpnDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (roleOfcCd[i] != null)
					model.setRoleOfcCd(roleOfcCd[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (genExpnAproAuthOfcCd[i] != null)
					model.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd[i]);
				if (crntGenExpnApstsCd[i] != null)
					model.setCrntGenExpnApstsCd(crntGenExpnApstsCd[i]);
				if (fmTicCd[i] != null)
					model.setFmTicCd(fmTicCd[i]);
				if (sumUp[i] != null)
					model.setSumUp(sumUp[i]);
				if (langDiv[i] != null)
					model.setLangDiv(langDiv[i]);
				if (ofcLvl1[i] != null)
					model.setOfcLvl1(ofcLvl1[i]);
				if (fmGenExpnCdGrp[i] != null)
					model.setFmGenExpnCdGrp(fmGenExpnCdGrp[i]);
				if (ticAuthOfcCd[i] != null)
					model.setTicAuthOfcCd(ticAuthOfcCd[i]);
				if (ofcLvl2[i] != null)
					model.setOfcLvl2(ofcLvl2[i]);
				if (ofcLvl3[i] != null)
					model.setOfcLvl3(ofcLvl3[i]);
				if (ofcExpnCd[i] != null)
					model.setOfcExpnCd(ofcExpnCd[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPlanningStatusCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PlanningStatusCondVO[]
	 */
	public PlanningStatusCondVO[] getPlanningStatusCondVOs(){
		PlanningStatusCondVO[] vos = (PlanningStatusCondVO[])models.toArray(new PlanningStatusCondVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntGenExpnAproStepCd = this.crntGenExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcExpnDiv = this.ofcExpnDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roleOfcCd = this.roleOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproAuthOfcCd = this.genExpnAproAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntGenExpnApstsCd = this.crntGenExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTicCd = this.fmTicCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumUp = this.sumUp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.langDiv = this.langDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl1 = this.ofcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCdGrp = this.fmGenExpnCdGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticAuthOfcCd = this.ticAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl2 = this.ofcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl3 = this.ofcLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcExpnCd = this.ofcExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}