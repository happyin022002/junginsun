/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SerachConsultaionVO.java
*@FileTitle : SerachConsultaionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SerachConsultaionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SerachConsultaionVO> models = new ArrayList<SerachConsultaionVO>();
	
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String expnDivCd = null;
	/* Column Info */
	private String subsCsrNo = null;
	/* Column Info */
	private String usrAuthTpCd = null;
	/* Column Info */
	private String subsExpnNm = null;
	/* Column Info */
	private String periodStdt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String expenseText = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String plnMon = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String subsOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ofcLvl1 = null;
	/* Column Info */
	private String subsExpnCd = null;
	/* Column Info */
	private String ofcLvl2 = null;
	/* Column Info */
	private String ofcLvl3 = null;
	/* Column Info */
	private String genExpnRqstTpCd = null;
	/* Column Info */
	private String periodEddt = null;
	/* Column Info */
	private String slsOfcDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SerachConsultaionVO() {}

	public SerachConsultaionVO(String ibflag, String pagerows, String ofcCd, String authFlg, String loclCurrCd, String usdLoclXchRt, String subsExpnNm, String subsExpnCd, String expnDivCd, String invDt, String genExpnRqstTpCd, String periodStdt, String periodEddt, String csrNo, String ofcLvl1, String ofcLvl2, String ofcLvl3, String status, String loginOfcCd, String usrAuthTpCd, String plnYr, String plnMon, String slsOfcDivCd, String expenseText, String subsOfcCd, String subsCsrNo) {
		this.authFlg = authFlg;
		this.expnDivCd = expnDivCd;
		this.subsCsrNo = subsCsrNo;
		this.usrAuthTpCd = usrAuthTpCd;
		this.subsExpnNm = subsExpnNm;
		this.periodStdt = periodStdt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.loginOfcCd = loginOfcCd;
		this.plnYr = plnYr;
		this.usdLoclXchRt = usdLoclXchRt;
		this.expenseText = expenseText;
		this.invDt = invDt;
		this.csrNo = csrNo;
		this.plnMon = plnMon;
		this.status = status;
		this.loclCurrCd = loclCurrCd;
		this.subsOfcCd = subsOfcCd;
		this.ofcCd = ofcCd;
		this.ofcLvl1 = ofcLvl1;
		this.subsExpnCd = subsExpnCd;
		this.ofcLvl2 = ofcLvl2;
		this.ofcLvl3 = ofcLvl3;
		this.genExpnRqstTpCd = genExpnRqstTpCd;
		this.periodEddt = periodEddt;
		this.slsOfcDivCd = slsOfcDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("expn_div_cd", getExpnDivCd());
		this.hashColumns.put("subs_csr_no", getSubsCsrNo());
		this.hashColumns.put("usr_auth_tp_cd", getUsrAuthTpCd());
		this.hashColumns.put("subs_expn_nm", getSubsExpnNm());
		this.hashColumns.put("period_stdt", getPeriodStdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("expense_text", getExpenseText());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("pln_mon", getPlnMon());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("subs_ofc_cd", getSubsOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ofc_lvl1", getOfcLvl1());
		this.hashColumns.put("subs_expn_cd", getSubsExpnCd());
		this.hashColumns.put("ofc_lvl2", getOfcLvl2());
		this.hashColumns.put("ofc_lvl3", getOfcLvl3());
		this.hashColumns.put("gen_expn_rqst_tp_cd", getGenExpnRqstTpCd());
		this.hashColumns.put("period_eddt", getPeriodEddt());
		this.hashColumns.put("sls_ofc_div_cd", getSlsOfcDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("expn_div_cd", "expnDivCd");
		this.hashFields.put("subs_csr_no", "subsCsrNo");
		this.hashFields.put("usr_auth_tp_cd", "usrAuthTpCd");
		this.hashFields.put("subs_expn_nm", "subsExpnNm");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("expense_text", "expenseText");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("pln_mon", "plnMon");
		this.hashFields.put("status", "status");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("subs_ofc_cd", "subsOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ofc_lvl1", "ofcLvl1");
		this.hashFields.put("subs_expn_cd", "subsExpnCd");
		this.hashFields.put("ofc_lvl2", "ofcLvl2");
		this.hashFields.put("ofc_lvl3", "ofcLvl3");
		this.hashFields.put("gen_expn_rqst_tp_cd", "genExpnRqstTpCd");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("sls_ofc_div_cd", "slsOfcDivCd");
		return this.hashFields;
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
	 * @return expnDivCd
	 */
	public String getExpnDivCd() {
		return this.expnDivCd;
	}
	
	/**
	 * Column Info
	 * @return subsCsrNo
	 */
	public String getSubsCsrNo() {
		return this.subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @return usrAuthTpCd
	 */
	public String getUsrAuthTpCd() {
		return this.usrAuthTpCd;
	}
	
	/**
	 * Column Info
	 * @return subsExpnNm
	 */
	public String getSubsExpnNm() {
		return this.subsExpnNm;
	}
	
	/**
	 * Column Info
	 * @return periodStdt
	 */
	public String getPeriodStdt() {
		return this.periodStdt;
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
	 * @return loginOfcCd
	 */
	public String getLoginOfcCd() {
		return this.loginOfcCd;
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
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return expenseText
	 */
	public String getExpenseText() {
		return this.expenseText;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return subsOfcCd
	 */
	public String getSubsOfcCd() {
		return this.subsOfcCd;
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
	 * @return ofcLvl1
	 */
	public String getOfcLvl1() {
		return this.ofcLvl1;
	}
	
	/**
	 * Column Info
	 * @return subsExpnCd
	 */
	public String getSubsExpnCd() {
		return this.subsExpnCd;
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
	 * @return genExpnRqstTpCd
	 */
	public String getGenExpnRqstTpCd() {
		return this.genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return periodEddt
	 */
	public String getPeriodEddt() {
		return this.periodEddt;
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
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param expnDivCd
	 */
	public void setExpnDivCd(String expnDivCd) {
		this.expnDivCd = expnDivCd;
	}
	
	/**
	 * Column Info
	 * @param subsCsrNo
	 */
	public void setSubsCsrNo(String subsCsrNo) {
		this.subsCsrNo = subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @param usrAuthTpCd
	 */
	public void setUsrAuthTpCd(String usrAuthTpCd) {
		this.usrAuthTpCd = usrAuthTpCd;
	}
	
	/**
	 * Column Info
	 * @param subsExpnNm
	 */
	public void setSubsExpnNm(String subsExpnNm) {
		this.subsExpnNm = subsExpnNm;
	}
	
	/**
	 * Column Info
	 * @param periodStdt
	 */
	public void setPeriodStdt(String periodStdt) {
		this.periodStdt = periodStdt;
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
	 * @param loginOfcCd
	 */
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
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
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param expenseText
	 */
	public void setExpenseText(String expenseText) {
		this.expenseText = expenseText;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param subsOfcCd
	 */
	public void setSubsOfcCd(String subsOfcCd) {
		this.subsOfcCd = subsOfcCd;
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
	 * @param ofcLvl1
	 */
	public void setOfcLvl1(String ofcLvl1) {
		this.ofcLvl1 = ofcLvl1;
	}
	
	/**
	 * Column Info
	 * @param subsExpnCd
	 */
	public void setSubsExpnCd(String subsExpnCd) {
		this.subsExpnCd = subsExpnCd;
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
	 * @param genExpnRqstTpCd
	 */
	public void setGenExpnRqstTpCd(String genExpnRqstTpCd) {
		this.genExpnRqstTpCd = genExpnRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param periodEddt
	 */
	public void setPeriodEddt(String periodEddt) {
		this.periodEddt = periodEddt;
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
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setExpnDivCd(JSPUtil.getParameter(request, prefix + "expn_div_cd", ""));
		setSubsCsrNo(JSPUtil.getParameter(request, prefix + "subs_csr_no", ""));
		setUsrAuthTpCd(JSPUtil.getParameter(request, prefix + "usr_auth_tp_cd", ""));
		setSubsExpnNm(JSPUtil.getParameter(request, prefix + "subs_expn_nm", ""));
		setPeriodStdt(JSPUtil.getParameter(request, prefix + "period_stdt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, prefix + "login_ofc_cd", ""));
		setPlnYr(JSPUtil.getParameter(request, prefix + "pln_yr", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", ""));
		setExpenseText(JSPUtil.getParameter(request, prefix + "expense_text", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setPlnMon(JSPUtil.getParameter(request, prefix + "pln_mon", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setSubsOfcCd(JSPUtil.getParameter(request, prefix + "subs_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setOfcLvl1(JSPUtil.getParameter(request, prefix + "ofc_lvl1", ""));
		setSubsExpnCd(JSPUtil.getParameter(request, prefix + "subs_expn_cd", ""));
		setOfcLvl2(JSPUtil.getParameter(request, prefix + "ofc_lvl2", ""));
		setOfcLvl3(JSPUtil.getParameter(request, prefix + "ofc_lvl3", ""));
		setGenExpnRqstTpCd(JSPUtil.getParameter(request, prefix + "gen_expn_rqst_tp_cd", ""));
		setPeriodEddt(JSPUtil.getParameter(request, prefix + "period_eddt", ""));
		setSlsOfcDivCd(JSPUtil.getParameter(request, prefix + "sls_ofc_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SerachConsultaionVO[]
	 */
	public SerachConsultaionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SerachConsultaionVO[]
	 */
	public SerachConsultaionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SerachConsultaionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] expnDivCd = (JSPUtil.getParameter(request, prefix	+ "expn_div_cd", length));
			String[] subsCsrNo = (JSPUtil.getParameter(request, prefix	+ "subs_csr_no", length));
			String[] usrAuthTpCd = (JSPUtil.getParameter(request, prefix	+ "usr_auth_tp_cd", length));
			String[] subsExpnNm = (JSPUtil.getParameter(request, prefix	+ "subs_expn_nm", length));
			String[] periodStdt = (JSPUtil.getParameter(request, prefix	+ "period_stdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] expenseText = (JSPUtil.getParameter(request, prefix	+ "expense_text", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] plnMon = (JSPUtil.getParameter(request, prefix	+ "pln_mon", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] subsOfcCd = (JSPUtil.getParameter(request, prefix	+ "subs_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ofcLvl1 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl1", length));
			String[] subsExpnCd = (JSPUtil.getParameter(request, prefix	+ "subs_expn_cd", length));
			String[] ofcLvl2 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl2", length));
			String[] ofcLvl3 = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl3", length));
			String[] genExpnRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_tp_cd", length));
			String[] periodEddt = (JSPUtil.getParameter(request, prefix	+ "period_eddt", length));
			String[] slsOfcDivCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SerachConsultaionVO();
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (expnDivCd[i] != null)
					model.setExpnDivCd(expnDivCd[i]);
				if (subsCsrNo[i] != null)
					model.setSubsCsrNo(subsCsrNo[i]);
				if (usrAuthTpCd[i] != null)
					model.setUsrAuthTpCd(usrAuthTpCd[i]);
				if (subsExpnNm[i] != null)
					model.setSubsExpnNm(subsExpnNm[i]);
				if (periodStdt[i] != null)
					model.setPeriodStdt(periodStdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (expenseText[i] != null)
					model.setExpenseText(expenseText[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (plnMon[i] != null)
					model.setPlnMon(plnMon[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (subsOfcCd[i] != null)
					model.setSubsOfcCd(subsOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ofcLvl1[i] != null)
					model.setOfcLvl1(ofcLvl1[i]);
				if (subsExpnCd[i] != null)
					model.setSubsExpnCd(subsExpnCd[i]);
				if (ofcLvl2[i] != null)
					model.setOfcLvl2(ofcLvl2[i]);
				if (ofcLvl3[i] != null)
					model.setOfcLvl3(ofcLvl3[i]);
				if (genExpnRqstTpCd[i] != null)
					model.setGenExpnRqstTpCd(genExpnRqstTpCd[i]);
				if (periodEddt[i] != null)
					model.setPeriodEddt(periodEddt[i]);
				if (slsOfcDivCd[i] != null)
					model.setSlsOfcDivCd(slsOfcDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSerachConsultaionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SerachConsultaionVO[]
	 */
	public SerachConsultaionVO[] getSerachConsultaionVOs(){
		SerachConsultaionVO[] vos = (SerachConsultaionVO[])models.toArray(new SerachConsultaionVO[models.size()]);
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
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnDivCd = this.expnDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrNo = this.subsCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrAuthTpCd = this.usrAuthTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsExpnNm = this.subsExpnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt = this.periodStdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expenseText = this.expenseText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMon = this.plnMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsOfcCd = this.subsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl1 = this.ofcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsExpnCd = this.subsExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl2 = this.ofcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl3 = this.ofcLvl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstTpCd = this.genExpnRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt = this.periodEddt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcDivCd = this.slsOfcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
