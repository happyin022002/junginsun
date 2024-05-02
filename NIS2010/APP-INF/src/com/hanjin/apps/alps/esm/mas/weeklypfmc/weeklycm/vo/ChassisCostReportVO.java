/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisCostReportVO.java
*@FileTitle : ChassisCostReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.04.24 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChassisCostReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChassisCostReportVO> models = new ArrayList<ChassisCostReportVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fSc = null;
	/* Column Info */
	private String div = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fFmyearmonth = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fDel = null;
	/* Column Info */
	private String bkgBndCd = null;
	/* Column Info */
	private String fTpsz = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String rfaCustNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String cpb = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String chssCost = null;
	/* Column Info */
	private String costTtl = null;
	/* Column Info */
	private String commCost = null;
	/* Column Info */
	private String fRevyrmon = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String scCustNm = null;
	/* Column Info */
	private String fRfa = null;
	/* Column Info */
	private String fPor = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String fToyearmonth = null;
	/* Column Info */
	private String fCOfc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChassisCostReportVO() {}

	public ChassisCostReportVO(String ibflag, String pagerows, String scNo, String scCustNm, String rfaNo, String rfaCustNm, String porCd, String delCd, String ctrtOfcCd, String cntrTpszCd, String bkgBndCd, String div, String term, String costYrmon, String bkgQty, String chssCost, String commCost, String costTtl, String cpb, String lvl, String fRevyrmon, String fFmyearmonth, String fToyearmonth, String fCOfc, String fPor, String fDel, String fTpsz, String fSc, String fRfa) {
		this.porCd = porCd;
		this.fSc = fSc;
		this.div = div;
		this.pagerows = pagerows;
		this.fFmyearmonth = fFmyearmonth;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.fDel = fDel;
		this.bkgBndCd = bkgBndCd;
		this.fTpsz = fTpsz;
		this.ctrtOfcCd = ctrtOfcCd;
		this.rfaCustNm = rfaCustNm;
		this.scNo = scNo;
		this.bkgQty = bkgQty;
		this.cpb = cpb;
		this.cntrTpszCd = cntrTpszCd;
		this.chssCost = chssCost;
		this.costTtl = costTtl;
		this.commCost = commCost;
		this.fRevyrmon = fRevyrmon;
		this.delCd = delCd;
		this.scCustNm = scCustNm;
		this.fRfa = fRfa;
		this.fPor = fPor;
		this.lvl = lvl;
		this.term = term;
		this.fToyearmonth = fToyearmonth;
		this.fCOfc = fCOfc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("f_sc", getFSc());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_fmyearmonth", getFFmyearmonth());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("f_del", getFDel());
		this.hashColumns.put("bkg_bnd_cd", getBkgBndCd());
		this.hashColumns.put("f_tpsz", getFTpsz());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("rfa_cust_nm", getRfaCustNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("cpb", getCpb());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("chss_cost", getChssCost());
		this.hashColumns.put("cost_ttl", getCostTtl());
		this.hashColumns.put("comm_cost", getCommCost());
		this.hashColumns.put("f_revyrmon", getFRevyrmon());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("sc_cust_nm", getScCustNm());
		this.hashColumns.put("f_rfa", getFRfa());
		this.hashColumns.put("f_por", getFPor());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("f_toyearmonth", getFToyearmonth());
		this.hashColumns.put("f_c_ofc", getFCOfc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("f_sc", "fSc");
		this.hashFields.put("div", "div");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_fmyearmonth", "fFmyearmonth");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("bkg_bnd_cd", "bkgBndCd");
		this.hashFields.put("f_tpsz", "fTpsz");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("rfa_cust_nm", "rfaCustNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("cpb", "cpb");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chss_cost", "chssCost");
		this.hashFields.put("cost_ttl", "costTtl");
		this.hashFields.put("comm_cost", "commCost");
		this.hashFields.put("f_revyrmon", "fRevyrmon");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("sc_cust_nm", "scCustNm");
		this.hashFields.put("f_rfa", "fRfa");
		this.hashFields.put("f_por", "fPor");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("term", "term");
		this.hashFields.put("f_toyearmonth", "fToyearmonth");
		this.hashFields.put("f_c_ofc", "fCOfc");
		return this.hashFields;
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
	 * @return fSc
	 */
	public String getFSc() {
		return this.fSc;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
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
	 * @return fFmyearmonth
	 */
	public String getFFmyearmonth() {
		return this.fFmyearmonth;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return fDel
	 */
	public String getFDel() {
		return this.fDel;
	}
	
	/**
	 * Column Info
	 * @return bkgBndCd
	 */
	public String getBkgBndCd() {
		return this.bkgBndCd;
	}
	
	/**
	 * Column Info
	 * @return fTpsz
	 */
	public String getFTpsz() {
		return this.fTpsz;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfaCustNm
	 */
	public String getRfaCustNm() {
		return this.rfaCustNm;
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
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return cpb
	 */
	public String getCpb() {
		return this.cpb;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return chssCost
	 */
	public String getChssCost() {
		return this.chssCost;
	}
	
	/**
	 * Column Info
	 * @return costTtl
	 */
	public String getCostTtl() {
		return this.costTtl;
	}
	
	/**
	 * Column Info
	 * @return commCost
	 */
	public String getCommCost() {
		return this.commCost;
	}
	
	/**
	 * Column Info
	 * @return fRevyrmon
	 */
	public String getFRevyrmon() {
		return this.fRevyrmon;
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
	 * @return scCustNm
	 */
	public String getScCustNm() {
		return this.scCustNm;
	}
	
	/**
	 * Column Info
	 * @return fRfa
	 */
	public String getFRfa() {
		return this.fRfa;
	}
	
	/**
	 * Column Info
	 * @return fPor
	 */
	public String getFPor() {
		return this.fPor;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return fToyearmonth
	 */
	public String getFToyearmonth() {
		return this.fToyearmonth;
	}
	
	/**
	 * Column Info
	 * @return fCOfc
	 */
	public String getFCOfc() {
		return this.fCOfc;
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
	 * @param fSc
	 */
	public void setFSc(String fSc) {
		this.fSc = fSc;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
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
	 * @param fFmyearmonth
	 */
	public void setFFmyearmonth(String fFmyearmonth) {
		this.fFmyearmonth = fFmyearmonth;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param fDel
	 */
	public void setFDel(String fDel) {
		this.fDel = fDel;
	}
	
	/**
	 * Column Info
	 * @param bkgBndCd
	 */
	public void setBkgBndCd(String bkgBndCd) {
		this.bkgBndCd = bkgBndCd;
	}
	
	/**
	 * Column Info
	 * @param fTpsz
	 */
	public void setFTpsz(String fTpsz) {
		this.fTpsz = fTpsz;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfaCustNm
	 */
	public void setRfaCustNm(String rfaCustNm) {
		this.rfaCustNm = rfaCustNm;
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
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param cpb
	 */
	public void setCpb(String cpb) {
		this.cpb = cpb;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param chssCost
	 */
	public void setChssCost(String chssCost) {
		this.chssCost = chssCost;
	}
	
	/**
	 * Column Info
	 * @param costTtl
	 */
	public void setCostTtl(String costTtl) {
		this.costTtl = costTtl;
	}
	
	/**
	 * Column Info
	 * @param commCost
	 */
	public void setCommCost(String commCost) {
		this.commCost = commCost;
	}
	
	/**
	 * Column Info
	 * @param fRevyrmon
	 */
	public void setFRevyrmon(String fRevyrmon) {
		this.fRevyrmon = fRevyrmon;
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
	 * @param scCustNm
	 */
	public void setScCustNm(String scCustNm) {
		this.scCustNm = scCustNm;
	}
	
	/**
	 * Column Info
	 * @param fRfa
	 */
	public void setFRfa(String fRfa) {
		this.fRfa = fRfa;
	}
	
	/**
	 * Column Info
	 * @param fPor
	 */
	public void setFPor(String fPor) {
		this.fPor = fPor;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param fToyearmonth
	 */
	public void setFToyearmonth(String fToyearmonth) {
		this.fToyearmonth = fToyearmonth;
	}
	
	/**
	 * Column Info
	 * @param fCOfc
	 */
	public void setFCOfc(String fCOfc) {
		this.fCOfc = fCOfc;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFSc(JSPUtil.getParameter(request, prefix + "f_sc", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFFmyearmonth(JSPUtil.getParameter(request, prefix + "f_fmyearmonth", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFDel(JSPUtil.getParameter(request, prefix + "f_del", ""));
		setBkgBndCd(JSPUtil.getParameter(request, prefix + "bkg_bnd_cd", ""));
		setFTpsz(JSPUtil.getParameter(request, prefix + "f_tpsz", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setRfaCustNm(JSPUtil.getParameter(request, prefix + "rfa_cust_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setCpb(JSPUtil.getParameter(request, prefix + "cpb", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setChssCost(JSPUtil.getParameter(request, prefix + "chss_cost", ""));
		setCostTtl(JSPUtil.getParameter(request, prefix + "cost_ttl", ""));
		setCommCost(JSPUtil.getParameter(request, prefix + "comm_cost", ""));
		setFRevyrmon(JSPUtil.getParameter(request, prefix + "f_revyrmon", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setScCustNm(JSPUtil.getParameter(request, prefix + "sc_cust_nm", ""));
		setFRfa(JSPUtil.getParameter(request, prefix + "f_rfa", ""));
		setFPor(JSPUtil.getParameter(request, prefix + "f_por", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setFToyearmonth(JSPUtil.getParameter(request, prefix + "f_toyearmonth", ""));
		setFCOfc(JSPUtil.getParameter(request, prefix + "f_c_ofc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChassisCostReportVO[]
	 */
	public ChassisCostReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChassisCostReportVO[]
	 */
	public ChassisCostReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChassisCostReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fSc = (JSPUtil.getParameter(request, prefix	+ "f_sc", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fFmyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_fmyearmonth", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fDel = (JSPUtil.getParameter(request, prefix	+ "f_del", length));
			String[] bkgBndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_bnd_cd", length));
			String[] fTpsz = (JSPUtil.getParameter(request, prefix	+ "f_tpsz", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] rfaCustNm = (JSPUtil.getParameter(request, prefix	+ "rfa_cust_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] cpb = (JSPUtil.getParameter(request, prefix	+ "cpb", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] chssCost = (JSPUtil.getParameter(request, prefix	+ "chss_cost", length));
			String[] costTtl = (JSPUtil.getParameter(request, prefix	+ "cost_ttl", length));
			String[] commCost = (JSPUtil.getParameter(request, prefix	+ "comm_cost", length));
			String[] fRevyrmon = (JSPUtil.getParameter(request, prefix	+ "f_revyrmon", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] scCustNm = (JSPUtil.getParameter(request, prefix	+ "sc_cust_nm", length));
			String[] fRfa = (JSPUtil.getParameter(request, prefix	+ "f_rfa", length));
			String[] fPor = (JSPUtil.getParameter(request, prefix	+ "f_por", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] fToyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_toyearmonth", length));
			String[] fCOfc = (JSPUtil.getParameter(request, prefix	+ "f_c_ofc", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChassisCostReportVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fSc[i] != null)
					model.setFSc(fSc[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fFmyearmonth[i] != null)
					model.setFFmyearmonth(fFmyearmonth[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fDel[i] != null)
					model.setFDel(fDel[i]);
				if (bkgBndCd[i] != null)
					model.setBkgBndCd(bkgBndCd[i]);
				if (fTpsz[i] != null)
					model.setFTpsz(fTpsz[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (rfaCustNm[i] != null)
					model.setRfaCustNm(rfaCustNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (cpb[i] != null)
					model.setCpb(cpb[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (chssCost[i] != null)
					model.setChssCost(chssCost[i]);
				if (costTtl[i] != null)
					model.setCostTtl(costTtl[i]);
				if (commCost[i] != null)
					model.setCommCost(commCost[i]);
				if (fRevyrmon[i] != null)
					model.setFRevyrmon(fRevyrmon[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (scCustNm[i] != null)
					model.setScCustNm(scCustNm[i]);
				if (fRfa[i] != null)
					model.setFRfa(fRfa[i]);
				if (fPor[i] != null)
					model.setFPor(fPor[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (fToyearmonth[i] != null)
					model.setFToyearmonth(fToyearmonth[i]);
				if (fCOfc[i] != null)
					model.setFCOfc(fCOfc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChassisCostReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChassisCostReportVO[]
	 */
	public ChassisCostReportVO[] getChassisCostReportVOs(){
		ChassisCostReportVO[] vos = (ChassisCostReportVO[])models.toArray(new ChassisCostReportVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSc = this.fSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmyearmonth = this.fFmyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel = this.fDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBndCd = this.bkgBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTpsz = this.fTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCustNm = this.rfaCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpb = this.cpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCost = this.chssCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtl = this.costTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commCost = this.commCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevyrmon = this.fRevyrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustNm = this.scCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfa = this.fRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPor = this.fPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToyearmonth = this.fToyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCOfc = this.fCOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
