/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolEstmExpenseMGTVO.java
*@FileTitle : PoolEstmExpenseMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.19 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolEstmExpenseMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolEstmExpenseMGTVO> models = new ArrayList<PoolEstmExpenseMGTVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String estmYrmon = null;
	/* Column Info */
	private String monthNm = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chssPoolTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmAmtFxFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dec = null;
	/* Column Info */
	private String chssPoolNm = null;
	/* Column Info */
	private String mar = null;
	/* Column Info */
	private String jan = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String may = null;
	/* Column Info */
	private String apr = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String jul = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String jun = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String oct = null;
	/* Column Info */
	private String feb = null;
	/* Column Info */
	private String nov = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String sep = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String aug = null;
	/* Column Info */
	private String chgAmt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolEstmExpenseMGTVO() {}

	public PoolEstmExpenseMGTVO(String ibflag, String pagerows, String total, String estmYrmon, String monthNm, String currCd, String chssPoolCd, String chssPoolTpCd, String estmAmtFxFlg, String dec, String chssPoolNm, String jan, String mar, String updUsrId, String may, String apr, String agmtSeq, String jul, String estmAmt, String jun, String creUsrId, String oct, String feb, String nov, String agmtOfcCtyCd, String month, String invSmryAmt, String sep, String aug, String chgAmt) {
		this.total = total;
		this.estmYrmon = estmYrmon;
		this.monthNm = monthNm;
		this.chssPoolCd = chssPoolCd;
		this.currCd = currCd;
		this.chssPoolTpCd = chssPoolTpCd;
		this.pagerows = pagerows;
		this.estmAmtFxFlg = estmAmtFxFlg;
		this.ibflag = ibflag;
		this.dec = dec;
		this.chssPoolNm = chssPoolNm;
		this.mar = mar;
		this.jan = jan;
		this.updUsrId = updUsrId;
		this.may = may;
		this.apr = apr;
		this.agmtSeq = agmtSeq;
		this.jul = jul;
		this.estmAmt = estmAmt;
		this.jun = jun;
		this.creUsrId = creUsrId;
		this.oct = oct;
		this.feb = feb;
		this.nov = nov;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.month = month;
		this.sep = sep;
		this.invSmryAmt = invSmryAmt;
		this.aug = aug;
		this.chgAmt = chgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("estm_yrmon", getEstmYrmon());
		this.hashColumns.put("month_nm", getMonthNm());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chss_pool_tp_cd", getChssPoolTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_amt_fx_flg", getEstmAmtFxFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dec", getDec());
		this.hashColumns.put("chss_pool_nm", getChssPoolNm());
		this.hashColumns.put("mar", getMar());
		this.hashColumns.put("jan", getJan());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("may", getMay());
		this.hashColumns.put("apr", getApr());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("jul", getJul());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("jun", getJun());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("oct", getOct());
		this.hashColumns.put("feb", getFeb());
		this.hashColumns.put("nov", getNov());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("sep", getSep());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("aug", getAug());
		this.hashColumns.put("chg_amt", getChgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("estm_yrmon", "estmYrmon");
		this.hashFields.put("month_nm", "monthNm");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chss_pool_tp_cd", "chssPoolTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_amt_fx_flg", "estmAmtFxFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dec", "dec");
		this.hashFields.put("chss_pool_nm", "chssPoolNm");
		this.hashFields.put("mar", "mar");
		this.hashFields.put("jan", "jan");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("may", "may");
		this.hashFields.put("apr", "apr");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("jul", "jul");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("jun", "jun");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("oct", "oct");
		this.hashFields.put("feb", "feb");
		this.hashFields.put("nov", "nov");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("month", "month");
		this.hashFields.put("sep", "sep");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("aug", "aug");
		this.hashFields.put("chg_amt", "chgAmt");
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
	 * @return estmYrmon
	 */
	public String getEstmYrmon() {
		return this.estmYrmon;
	}
	
	/**
	 * Column Info
	 * @return monthNm
	 */
	public String getMonthNm() {
		return this.monthNm;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
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
	 * @return chssPoolTpCd
	 */
	public String getChssPoolTpCd() {
		return this.chssPoolTpCd;
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
	 * @return estmAmtFxFlg
	 */
	public String getEstmAmtFxFlg() {
		return this.estmAmtFxFlg;
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
	 * @return dec
	 */
	public String getDec() {
		return this.dec;
	}
	
	/**
	 * Column Info
	 * @return chssPoolNm
	 */
	public String getChssPoolNm() {
		return this.chssPoolNm;
	}
	
	/**
	 * Column Info
	 * @return mar
	 */
	public String getMar() {
		return this.mar;
	}
	
	/**
	 * Column Info
	 * @return jan
	 */
	public String getJan() {
		return this.jan;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return may
	 */
	public String getMay() {
		return this.may;
	}
	
	/**
	 * Column Info
	 * @return apr
	 */
	public String getApr() {
		return this.apr;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return jul
	 */
	public String getJul() {
		return this.jul;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
	}
	
	/**
	 * Column Info
	 * @return jun
	 */
	public String getJun() {
		return this.jun;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return oct
	 */
	public String getOct() {
		return this.oct;
	}
	
	/**
	 * Column Info
	 * @return feb
	 */
	public String getFeb() {
		return this.feb;
	}
	
	/**
	 * Column Info
	 * @return nov
	 */
	public String getNov() {
		return this.nov;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return sep
	 */
	public String getSep() {
		return this.sep;
	}
	
	/**
	 * Column Info
	 * @return invSmryAmt
	 */
	public String getInvSmryAmt() {
		return this.invSmryAmt;
	}
	
	/**
	 * Column Info
	 * @return aug
	 */
	public String getAug() {
		return this.aug;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @param estmYrmon
	 */
	public void setEstmYrmon(String estmYrmon) {
		this.estmYrmon = estmYrmon;
	}
	
	/**
	 * Column Info
	 * @param monthNm
	 */
	public void setMonthNm(String monthNm) {
		this.monthNm = monthNm;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
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
	 * @param chssPoolTpCd
	 */
	public void setChssPoolTpCd(String chssPoolTpCd) {
		this.chssPoolTpCd = chssPoolTpCd;
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
	 * @param estmAmtFxFlg
	 */
	public void setEstmAmtFxFlg(String estmAmtFxFlg) {
		this.estmAmtFxFlg = estmAmtFxFlg;
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
	 * @param dec
	 */
	public void setDec(String dec) {
		this.dec = dec;
	}
	
	/**
	 * Column Info
	 * @param chssPoolNm
	 */
	public void setChssPoolNm(String chssPoolNm) {
		this.chssPoolNm = chssPoolNm;
	}
	
	/**
	 * Column Info
	 * @param mar
	 */
	public void setMar(String mar) {
		this.mar = mar;
	}
	
	/**
	 * Column Info
	 * @param jan
	 */
	public void setJan(String jan) {
		this.jan = jan;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param may
	 */
	public void setMay(String may) {
		this.may = may;
	}
	
	/**
	 * Column Info
	 * @param apr
	 */
	public void setApr(String apr) {
		this.apr = apr;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param jul
	 */
	public void setJul(String jul) {
		this.jul = jul;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
	}
	
	/**
	 * Column Info
	 * @param jun
	 */
	public void setJun(String jun) {
		this.jun = jun;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param oct
	 */
	public void setOct(String oct) {
		this.oct = oct;
	}
	
	/**
	 * Column Info
	 * @param feb
	 */
	public void setFeb(String feb) {
		this.feb = feb;
	}
	
	/**
	 * Column Info
	 * @param nov
	 */
	public void setNov(String nov) {
		this.nov = nov;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param sep
	 */
	public void setSep(String sep) {
		this.sep = sep;
	}
	
	/**
	 * Column Info
	 * @param invSmryAmt
	 */
	public void setInvSmryAmt(String invSmryAmt) {
		this.invSmryAmt = invSmryAmt;
	}
	
	/**
	 * Column Info
	 * @param aug
	 */
	public void setAug(String aug) {
		this.aug = aug;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setEstmYrmon(JSPUtil.getParameter(request, "estm_yrmon", ""));
		setMonthNm(JSPUtil.getParameter(request, "month_nm", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChssPoolTpCd(JSPUtil.getParameter(request, "chss_pool_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmAmtFxFlg(JSPUtil.getParameter(request, "estm_amt_fx_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDec(JSPUtil.getParameter(request, "dec", ""));
		setChssPoolNm(JSPUtil.getParameter(request, "chss_pool_nm", ""));
		setMar(JSPUtil.getParameter(request, "mar", ""));
		setJan(JSPUtil.getParameter(request, "jan", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMay(JSPUtil.getParameter(request, "may", ""));
		setApr(JSPUtil.getParameter(request, "apr", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setJul(JSPUtil.getParameter(request, "jul", ""));
		setEstmAmt(JSPUtil.getParameter(request, "estm_amt", ""));
		setJun(JSPUtil.getParameter(request, "jun", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOct(JSPUtil.getParameter(request, "oct", ""));
		setFeb(JSPUtil.getParameter(request, "feb", ""));
		setNov(JSPUtil.getParameter(request, "nov", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setSep(JSPUtil.getParameter(request, "sep", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, "inv_smry_amt", ""));
		setAug(JSPUtil.getParameter(request, "aug", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolEstmExpenseMGTVO[]
	 */
	public PoolEstmExpenseMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolEstmExpenseMGTVO[]
	 */
	public PoolEstmExpenseMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolEstmExpenseMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] estmYrmon = (JSPUtil.getParameter(request, prefix	+ "estm_yrmon", length));
			String[] monthNm = (JSPUtil.getParameter(request, prefix	+ "month_nm", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chssPoolTpCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmAmtFxFlg = (JSPUtil.getParameter(request, prefix	+ "estm_amt_fx_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dec = (JSPUtil.getParameter(request, prefix	+ "dec", length));
			String[] chssPoolNm = (JSPUtil.getParameter(request, prefix	+ "chss_pool_nm", length));
			String[] mar = (JSPUtil.getParameter(request, prefix	+ "mar", length));
			String[] jan = (JSPUtil.getParameter(request, prefix	+ "jan", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] may = (JSPUtil.getParameter(request, prefix	+ "may", length));
			String[] apr = (JSPUtil.getParameter(request, prefix	+ "apr", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] jul = (JSPUtil.getParameter(request, prefix	+ "jul", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] jun = (JSPUtil.getParameter(request, prefix	+ "jun", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] oct = (JSPUtil.getParameter(request, prefix	+ "oct", length));
			String[] feb = (JSPUtil.getParameter(request, prefix	+ "feb", length));
			String[] nov = (JSPUtil.getParameter(request, prefix	+ "nov", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] sep = (JSPUtil.getParameter(request, prefix	+ "sep", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] aug = (JSPUtil.getParameter(request, prefix	+ "aug", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix + "chg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolEstmExpenseMGTVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (estmYrmon[i] != null)
					model.setEstmYrmon(estmYrmon[i]);
				if (monthNm[i] != null)
					model.setMonthNm(monthNm[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chssPoolTpCd[i] != null)
					model.setChssPoolTpCd(chssPoolTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmAmtFxFlg[i] != null)
					model.setEstmAmtFxFlg(estmAmtFxFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dec[i] != null)
					model.setDec(dec[i]);
				if (chssPoolNm[i] != null)
					model.setChssPoolNm(chssPoolNm[i]);
				if (mar[i] != null)
					model.setMar(mar[i]);
				if (jan[i] != null)
					model.setJan(jan[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (may[i] != null)
					model.setMay(may[i]);
				if (apr[i] != null)
					model.setApr(apr[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (jul[i] != null)
					model.setJul(jul[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (jun[i] != null)
					model.setJun(jun[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (oct[i] != null)
					model.setOct(oct[i]);
				if (feb[i] != null)
					model.setFeb(feb[i]);
				if (nov[i] != null)
					model.setNov(nov[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (sep[i] != null)
					model.setSep(sep[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (aug[i] != null)
					model.setAug(aug[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolEstmExpenseMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolEstmExpenseMGTVO[]
	 */
	public PoolEstmExpenseMGTVO[] getPoolEstmExpenseMGTVOs(){
		PoolEstmExpenseMGTVO[] vos = (PoolEstmExpenseMGTVO[])models.toArray(new PoolEstmExpenseMGTVO[models.size()]);
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
		this.estmYrmon = this.estmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monthNm = this.monthNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolTpCd = this.chssPoolTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmtFxFlg = this.estmAmtFxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dec = this.dec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolNm = this.chssPoolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mar = this.mar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jan = this.jan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.may = this.may .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apr = this.apr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jul = this.jul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jun = this.jun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oct = this.oct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feb = this.feb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nov = this.nov .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sep = this.sep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aug = this.aug .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
