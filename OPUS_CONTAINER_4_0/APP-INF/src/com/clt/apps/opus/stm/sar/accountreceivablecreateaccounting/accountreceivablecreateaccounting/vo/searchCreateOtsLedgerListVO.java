/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : searchCreateOtsLedgerListVO.java
*@FileTitle : searchCreateOtsLedgerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.vo;

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

public class searchCreateOtsLedgerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchCreateOtsLedgerListVO> models = new ArrayList<searchCreateOtsLedgerListVO>();
	
	/* Column Info */
	private String funcCurr = null;
	/* Column Info */
	private String thsAmt = null;
	/* Column Info */
	private String arAcctCd = null;
	/* Column Info */
	private String otsTpCd = null;
	/* Column Info */
	private String arRhqCd = null;
	/* Column Info */
	private String endUsd = null;
	/* Column Info */
	private String glMonth = null;
	/* Column Info */
	private String copUsd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String copKrw = null;
	/* Column Info */
	private String arDmstDrAcctCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String prvBal = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String dmstDrAcctCd = null;
	/* Column Info */
	private String thsBalCk = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String endKrw = null;
	/* Column Info */
	private String glSldth = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String thsBal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public searchCreateOtsLedgerListVO() {}

	public searchCreateOtsLedgerListVO(String ibflag, String pagerows, String effYrmon, String rhqCd, String otsOfcCd, String dmstDrAcctCd, String otsTpCd, String blCurrCd, String prvBal, String thsAmt, String thsBal, String thsBalCk, String copKrw, String copUsd, String endKrw, String endUsd, String glMonth, String arOfcCd, String arRhqCd, String arDmstDrAcctCd, String glSldth, String source, String curr, String arAcctCd, String funcCurr) {
		this.funcCurr = funcCurr;
		this.thsAmt = thsAmt;
		this.arAcctCd = arAcctCd;
		this.otsTpCd = otsTpCd;
		this.arRhqCd = arRhqCd;
		this.endUsd = endUsd;
		this.glMonth = glMonth;
		this.copUsd = copUsd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.curr = curr;
		this.copKrw = copKrw;
		this.arDmstDrAcctCd = arDmstDrAcctCd;
		this.rhqCd = rhqCd;
		this.blCurrCd = blCurrCd;
		this.prvBal = prvBal;
		this.arOfcCd = arOfcCd;
		this.dmstDrAcctCd = dmstDrAcctCd;
		this.thsBalCk = thsBalCk;
		this.otsOfcCd = otsOfcCd;
		this.source = source;
		this.endKrw = endKrw;
		this.glSldth = glSldth;
		this.effYrmon = effYrmon;
		this.thsBal = thsBal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("func_curr", getFuncCurr());
		this.hashColumns.put("ths_amt", getThsAmt());
		this.hashColumns.put("ar_acct_cd", getArAcctCd());
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());
		this.hashColumns.put("ar_rhq_cd", getArRhqCd());
		this.hashColumns.put("end_usd", getEndUsd());
		this.hashColumns.put("gl_month", getGlMonth());
		this.hashColumns.put("cop_usd", getCopUsd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("cop_krw", getCopKrw());
		this.hashColumns.put("ar_dmst_dr_acct_cd", getArDmstDrAcctCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("prv_bal", getPrvBal());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("dmst_dr_acct_cd", getDmstDrAcctCd());
		this.hashColumns.put("ths_bal_ck", getThsBalCk());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("end_krw", getEndKrw());
		this.hashColumns.put("gl_sldth", getGlSldth());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("ths_bal", getThsBal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("func_curr", "funcCurr");
		this.hashFields.put("ths_amt", "thsAmt");
		this.hashFields.put("ar_acct_cd", "arAcctCd");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("ar_rhq_cd", "arRhqCd");
		this.hashFields.put("end_usd", "endUsd");
		this.hashFields.put("gl_month", "glMonth");
		this.hashFields.put("cop_usd", "copUsd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("cop_krw", "copKrw");
		this.hashFields.put("ar_dmst_dr_acct_cd", "arDmstDrAcctCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("prv_bal", "prvBal");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("dmst_dr_acct_cd", "dmstDrAcctCd");
		this.hashFields.put("ths_bal_ck", "thsBalCk");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("source", "source");
		this.hashFields.put("end_krw", "endKrw");
		this.hashFields.put("gl_sldth", "glSldth");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("ths_bal", "thsBal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return funcCurr
	 */
	public String getFuncCurr() {
		return this.funcCurr;
	}
	
	/**
	 * Column Info
	 * @return thsAmt
	 */
	public String getThsAmt() {
		return this.thsAmt;
	}
	
	/**
	 * Column Info
	 * @return arAcctCd
	 */
	public String getArAcctCd() {
		return this.arAcctCd;
	}
	
	/**
	 * Column Info
	 * @return otsTpCd
	 */
	public String getOtsTpCd() {
		return this.otsTpCd;
	}
	
	/**
	 * Column Info
	 * @return arRhqCd
	 */
	public String getArRhqCd() {
		return this.arRhqCd;
	}
	
	/**
	 * Column Info
	 * @return endUsd
	 */
	public String getEndUsd() {
		return this.endUsd;
	}
	
	/**
	 * Column Info
	 * @return glMonth
	 */
	public String getGlMonth() {
		return this.glMonth;
	}
	
	/**
	 * Column Info
	 * @return copUsd
	 */
	public String getCopUsd() {
		return this.copUsd;
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
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return copKrw
	 */
	public String getCopKrw() {
		return this.copKrw;
	}
	
	/**
	 * Column Info
	 * @return arDmstDrAcctCd
	 */
	public String getArDmstDrAcctCd() {
		return this.arDmstDrAcctCd;
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
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}
	
	/**
	 * Column Info
	 * @return prvBal
	 */
	public String getPrvBal() {
		return this.prvBal;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmstDrAcctCd
	 */
	public String getDmstDrAcctCd() {
		return this.dmstDrAcctCd;
	}
	
	/**
	 * Column Info
	 * @return thsBalCk
	 */
	public String getThsBalCk() {
		return this.thsBalCk;
	}
	
	/**
	 * Column Info
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return endKrw
	 */
	public String getEndKrw() {
		return this.endKrw;
	}
	
	/**
	 * Column Info
	 * @return glSldth
	 */
	public String getGlSldth() {
		return this.glSldth;
	}
	
	/**
	 * Column Info
	 * @return effYrmon
	 */
	public String getEffYrmon() {
		return this.effYrmon;
	}
	
	/**
	 * Column Info
	 * @return thsBal
	 */
	public String getThsBal() {
		return this.thsBal;
	}
	

	/**
	 * Column Info
	 * @param funcCurr
	 */
	public void setFuncCurr(String funcCurr) {
		this.funcCurr = funcCurr;
	}
	
	/**
	 * Column Info
	 * @param thsAmt
	 */
	public void setThsAmt(String thsAmt) {
		this.thsAmt = thsAmt;
	}
	
	/**
	 * Column Info
	 * @param arAcctCd
	 */
	public void setArAcctCd(String arAcctCd) {
		this.arAcctCd = arAcctCd;
	}
	
	/**
	 * Column Info
	 * @param otsTpCd
	 */
	public void setOtsTpCd(String otsTpCd) {
		this.otsTpCd = otsTpCd;
	}
	
	/**
	 * Column Info
	 * @param arRhqCd
	 */
	public void setArRhqCd(String arRhqCd) {
		this.arRhqCd = arRhqCd;
	}
	
	/**
	 * Column Info
	 * @param endUsd
	 */
	public void setEndUsd(String endUsd) {
		this.endUsd = endUsd;
	}
	
	/**
	 * Column Info
	 * @param glMonth
	 */
	public void setGlMonth(String glMonth) {
		this.glMonth = glMonth;
	}
	
	/**
	 * Column Info
	 * @param copUsd
	 */
	public void setCopUsd(String copUsd) {
		this.copUsd = copUsd;
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
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param copKrw
	 */
	public void setCopKrw(String copKrw) {
		this.copKrw = copKrw;
	}
	
	/**
	 * Column Info
	 * @param arDmstDrAcctCd
	 */
	public void setArDmstDrAcctCd(String arDmstDrAcctCd) {
		this.arDmstDrAcctCd = arDmstDrAcctCd;
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
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}
	
	/**
	 * Column Info
	 * @param prvBal
	 */
	public void setPrvBal(String prvBal) {
		this.prvBal = prvBal;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmstDrAcctCd
	 */
	public void setDmstDrAcctCd(String dmstDrAcctCd) {
		this.dmstDrAcctCd = dmstDrAcctCd;
	}
	
	/**
	 * Column Info
	 * @param thsBalCk
	 */
	public void setThsBalCk(String thsBalCk) {
		this.thsBalCk = thsBalCk;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param endKrw
	 */
	public void setEndKrw(String endKrw) {
		this.endKrw = endKrw;
	}
	
	/**
	 * Column Info
	 * @param glSldth
	 */
	public void setGlSldth(String glSldth) {
		this.glSldth = glSldth;
	}
	
	/**
	 * Column Info
	 * @param effYrmon
	 */
	public void setEffYrmon(String effYrmon) {
		this.effYrmon = effYrmon;
	}
	
	/**
	 * Column Info
	 * @param thsBal
	 */
	public void setThsBal(String thsBal) {
		this.thsBal = thsBal;
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
		setFuncCurr(JSPUtil.getParameter(request, prefix + "func_curr", ""));
		setThsAmt(JSPUtil.getParameter(request, prefix + "ths_amt", ""));
		setArAcctCd(JSPUtil.getParameter(request, prefix + "ar_acct_cd", ""));
		setOtsTpCd(JSPUtil.getParameter(request, prefix + "ots_tp_cd", ""));
		setArRhqCd(JSPUtil.getParameter(request, prefix + "ar_rhq_cd", ""));
		setEndUsd(JSPUtil.getParameter(request, prefix + "end_usd", ""));
		setGlMonth(JSPUtil.getParameter(request, prefix + "gl_month", ""));
		setCopUsd(JSPUtil.getParameter(request, prefix + "cop_usd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurr(JSPUtil.getParameter(request, prefix + "curr", ""));
		setCopKrw(JSPUtil.getParameter(request, prefix + "cop_krw", ""));
		setArDmstDrAcctCd(JSPUtil.getParameter(request, prefix + "ar_dmst_dr_acct_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setPrvBal(JSPUtil.getParameter(request, prefix + "prv_bal", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setDmstDrAcctCd(JSPUtil.getParameter(request, prefix + "dmst_dr_acct_cd", ""));
		setThsBalCk(JSPUtil.getParameter(request, prefix + "ths_bal_ck", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setEndKrw(JSPUtil.getParameter(request, prefix + "end_krw", ""));
		setGlSldth(JSPUtil.getParameter(request, prefix + "gl_sldth", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setThsBal(JSPUtil.getParameter(request, prefix + "ths_bal", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchCreateOtsLedgerListVO[]
	 */
	public searchCreateOtsLedgerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchCreateOtsLedgerListVO[]
	 */
	public searchCreateOtsLedgerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchCreateOtsLedgerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] funcCurr = (JSPUtil.getParameter(request, prefix	+ "func_curr", length));
			String[] thsAmt = (JSPUtil.getParameter(request, prefix	+ "ths_amt", length));
			String[] arAcctCd = (JSPUtil.getParameter(request, prefix	+ "ar_acct_cd", length));
			String[] otsTpCd = (JSPUtil.getParameter(request, prefix	+ "ots_tp_cd", length));
			String[] arRhqCd = (JSPUtil.getParameter(request, prefix	+ "ar_rhq_cd", length));
			String[] endUsd = (JSPUtil.getParameter(request, prefix	+ "end_usd", length));
			String[] glMonth = (JSPUtil.getParameter(request, prefix	+ "gl_month", length));
			String[] copUsd = (JSPUtil.getParameter(request, prefix	+ "cop_usd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] copKrw = (JSPUtil.getParameter(request, prefix	+ "cop_krw", length));
			String[] arDmstDrAcctCd = (JSPUtil.getParameter(request, prefix	+ "ar_dmst_dr_acct_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] prvBal = (JSPUtil.getParameter(request, prefix	+ "prv_bal", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] dmstDrAcctCd = (JSPUtil.getParameter(request, prefix	+ "dmst_dr_acct_cd", length));
			String[] thsBalCk = (JSPUtil.getParameter(request, prefix	+ "ths_bal_ck", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] endKrw = (JSPUtil.getParameter(request, prefix	+ "end_krw", length));
			String[] glSldth = (JSPUtil.getParameter(request, prefix	+ "gl_sldth", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] thsBal = (JSPUtil.getParameter(request, prefix	+ "ths_bal", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchCreateOtsLedgerListVO();
				if (funcCurr[i] != null)
					model.setFuncCurr(funcCurr[i]);
				if (thsAmt[i] != null)
					model.setThsAmt(thsAmt[i]);
				if (arAcctCd[i] != null)
					model.setArAcctCd(arAcctCd[i]);
				if (otsTpCd[i] != null)
					model.setOtsTpCd(otsTpCd[i]);
				if (arRhqCd[i] != null)
					model.setArRhqCd(arRhqCd[i]);
				if (endUsd[i] != null)
					model.setEndUsd(endUsd[i]);
				if (glMonth[i] != null)
					model.setGlMonth(glMonth[i]);
				if (copUsd[i] != null)
					model.setCopUsd(copUsd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (copKrw[i] != null)
					model.setCopKrw(copKrw[i]);
				if (arDmstDrAcctCd[i] != null)
					model.setArDmstDrAcctCd(arDmstDrAcctCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (prvBal[i] != null)
					model.setPrvBal(prvBal[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (dmstDrAcctCd[i] != null)
					model.setDmstDrAcctCd(dmstDrAcctCd[i]);
				if (thsBalCk[i] != null)
					model.setThsBalCk(thsBalCk[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (endKrw[i] != null)
					model.setEndKrw(endKrw[i]);
				if (glSldth[i] != null)
					model.setGlSldth(glSldth[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (thsBal[i] != null)
					model.setThsBal(thsBal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchCreateOtsLedgerListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchCreateOtsLedgerListVO[]
	 */
	public searchCreateOtsLedgerListVO[] getsearchCreateOtsLedgerListVOs(){
		searchCreateOtsLedgerListVO[] vos = (searchCreateOtsLedgerListVO[])models.toArray(new searchCreateOtsLedgerListVO[models.size()]);
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
		this.funcCurr = this.funcCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thsAmt = this.thsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAcctCd = this.arAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd = this.otsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arRhqCd = this.arRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endUsd = this.endUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonth = this.glMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copUsd = this.copUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copKrw = this.copKrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arDmstDrAcctCd = this.arDmstDrAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prvBal = this.prvBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstDrAcctCd = this.dmstDrAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thsBalCk = this.thsBalCk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endKrw = this.endKrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glSldth = this.glSldth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thsBal = this.thsBal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
