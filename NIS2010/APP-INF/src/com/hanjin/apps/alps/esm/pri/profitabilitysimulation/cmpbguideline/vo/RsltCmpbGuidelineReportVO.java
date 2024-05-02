/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltCmpbGuidelineReportVO.java
*@FileTitle : RsltCmpbGuidelineReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.28 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltCmpbGuidelineReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCmpbGuidelineReportVO> models = new ArrayList<RsltCmpbGuidelineReportVO>();
	
	/* Column Info */
	private String bseSeq = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String mqcRngToQty = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String prsCustTpCdIn = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String cmpbSeq = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prsCustTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creOfcCdIn = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String searchCount = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String destCd = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String ratUtCdIn = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String originCd = null;
	/* Column Info */
	private String dRcvDeTermCd = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String prsCustTpNm = null;
	/* Column Info */
	private String rRcvDeTermCd = null;
	/* Column Info */
	private String mqcRngFmQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCmpbGuidelineReportVO() {}

	public RsltCmpbGuidelineReportVO(String ibflag, String pagerows, String prsCustTpNm, String vslSlanCd, String prcCmdtDefCd, String orgRoutPntLocDefCd, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String rRcvDeTermCd, String dRcvDeTermCd, String ratUtCd, String prcCgoTpCd, String currCd, String cmpbAmt, String creOfcCd, String mqcRngFmQty, String mqcRngToQty, String effDt, String expDt, String bseSeq, String cmpbSeq, String originCd, String destCd, String svcScpCd, String prsCustTpCd, String glineSeq, String searchCount, String creOfcCdIn, String prsCustTpCdIn, String ratUtCdIn) {
		this.bseSeq = bseSeq;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.mqcRngToQty = mqcRngToQty;
		this.svcScpCd = svcScpCd;
		this.prsCustTpCdIn = prsCustTpCdIn;
		this.glineSeq = glineSeq;
		this.cmpbSeq = cmpbSeq;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.prsCustTpCd = prsCustTpCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.creOfcCdIn = creOfcCdIn;
		this.cmpbAmt = cmpbAmt;
		this.creOfcCd = creOfcCd;
		this.searchCount = searchCount;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.expDt = expDt;
		this.destCd = destCd;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.ratUtCdIn = ratUtCdIn;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.ratUtCd = ratUtCd;
		this.originCd = originCd;
		this.dRcvDeTermCd = dRcvDeTermCd;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.prsCustTpNm = prsCustTpNm;
		this.rRcvDeTermCd = rRcvDeTermCd;
		this.mqcRngFmQty = mqcRngFmQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bse_seq", getBseSeq());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("mqc_rng_to_qty", getMqcRngToQty());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prs_cust_tp_cd_in", getPrsCustTpCdIn());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("cmpb_seq", getCmpbSeq());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prs_cust_tp_cd", getPrsCustTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_ofc_cd_in", getCreOfcCdIn());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("search_count", getSearchCount());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dest_cd", getDestCd());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("rat_ut_cd_in", getRatUtCdIn());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("origin_cd", getOriginCd());
		this.hashColumns.put("d_rcv_de_term_cd", getDRcvDeTermCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("prs_cust_tp_nm", getPrsCustTpNm());
		this.hashColumns.put("r_rcv_de_term_cd", getRRcvDeTermCd());
		this.hashColumns.put("mqc_rng_fm_qty", getMqcRngFmQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bse_seq", "bseSeq");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("mqc_rng_to_qty", "mqcRngToQty");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prs_cust_tp_cd_in", "prsCustTpCdIn");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("cmpb_seq", "cmpbSeq");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prs_cust_tp_cd", "prsCustTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_ofc_cd_in", "creOfcCdIn");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("search_count", "searchCount");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dest_cd", "destCd");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("rat_ut_cd_in", "ratUtCdIn");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("origin_cd", "originCd");
		this.hashFields.put("d_rcv_de_term_cd", "dRcvDeTermCd");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("prs_cust_tp_nm", "prsCustTpNm");
		this.hashFields.put("r_rcv_de_term_cd", "rRcvDeTermCd");
		this.hashFields.put("mqc_rng_fm_qty", "mqcRngFmQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bseSeq
	 */
	public String getBseSeq() {
		return this.bseSeq;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mqcRngToQty
	 */
	public String getMqcRngToQty() {
		return this.mqcRngToQty;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return prsCustTpCdIn
	 */
	public String getPrsCustTpCdIn() {
		return this.prsCustTpCdIn;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return cmpbSeq
	 */
	public String getCmpbSeq() {
		return this.cmpbSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return prsCustTpCd
	 */
	public String getPrsCustTpCd() {
		return this.prsCustTpCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCdIn
	 */
	public String getCreOfcCdIn() {
		return this.creOfcCdIn;
	}
	
	/**
	 * Column Info
	 * @return cmpbAmt
	 */
	public String getCmpbAmt() {
		return this.cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return searchCount
	 */
	public String getSearchCount() {
		return this.searchCount;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return destCd
	 */
	public String getDestCd() {
		return this.destCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCdIn
	 */
	public String getRatUtCdIn() {
		return this.ratUtCdIn;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return originCd
	 */
	public String getOriginCd() {
		return this.originCd;
	}
	
	/**
	 * Column Info
	 * @return dRcvDeTermCd
	 */
	public String getDRcvDeTermCd() {
		return this.dRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return prsCustTpNm
	 */
	public String getPrsCustTpNm() {
		return this.prsCustTpNm;
	}
	
	/**
	 * Column Info
	 * @return rRcvDeTermCd
	 */
	public String getRRcvDeTermCd() {
		return this.rRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return mqcRngFmQty
	 */
	public String getMqcRngFmQty() {
		return this.mqcRngFmQty;
	}
	

	/**
	 * Column Info
	 * @param bseSeq
	 */
	public void setBseSeq(String bseSeq) {
		this.bseSeq = bseSeq;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mqcRngToQty
	 */
	public void setMqcRngToQty(String mqcRngToQty) {
		this.mqcRngToQty = mqcRngToQty;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param prsCustTpCdIn
	 */
	public void setPrsCustTpCdIn(String prsCustTpCdIn) {
		this.prsCustTpCdIn = prsCustTpCdIn;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param cmpbSeq
	 */
	public void setCmpbSeq(String cmpbSeq) {
		this.cmpbSeq = cmpbSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param prsCustTpCd
	 */
	public void setPrsCustTpCd(String prsCustTpCd) {
		this.prsCustTpCd = prsCustTpCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCdIn
	 */
	public void setCreOfcCdIn(String creOfcCdIn) {
		this.creOfcCdIn = creOfcCdIn;
	}
	
	/**
	 * Column Info
	 * @param cmpbAmt
	 */
	public void setCmpbAmt(String cmpbAmt) {
		this.cmpbAmt = cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param searchCount
	 */
	public void setSearchCount(String searchCount) {
		this.searchCount = searchCount;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param destCd
	 */
	public void setDestCd(String destCd) {
		this.destCd = destCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCdIn
	 */
	public void setRatUtCdIn(String ratUtCdIn) {
		this.ratUtCdIn = ratUtCdIn;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param originCd
	 */
	public void setOriginCd(String originCd) {
		this.originCd = originCd;
	}
	
	/**
	 * Column Info
	 * @param dRcvDeTermCd
	 */
	public void setDRcvDeTermCd(String dRcvDeTermCd) {
		this.dRcvDeTermCd = dRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param prsCustTpNm
	 */
	public void setPrsCustTpNm(String prsCustTpNm) {
		this.prsCustTpNm = prsCustTpNm;
	}
	
	/**
	 * Column Info
	 * @param rRcvDeTermCd
	 */
	public void setRRcvDeTermCd(String rRcvDeTermCd) {
		this.rRcvDeTermCd = rRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param mqcRngFmQty
	 */
	public void setMqcRngFmQty(String mqcRngFmQty) {
		this.mqcRngFmQty = mqcRngFmQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBseSeq(JSPUtil.getParameter(request, "bse_seq", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, "dest_rout_via_port_def_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setMqcRngToQty(JSPUtil.getParameter(request, "mqc_rng_to_qty", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setPrsCustTpCdIn(JSPUtil.getParameter(request, "prs_cust_tp_cd_in", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setCmpbSeq(JSPUtil.getParameter(request, "cmpb_seq", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrsCustTpCd(JSPUtil.getParameter(request, "prs_cust_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCreOfcCdIn(JSPUtil.getParameter(request, "cre_ofc_cd_in", ""));
		setCmpbAmt(JSPUtil.getParameter(request, "cmpb_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setSearchCount(JSPUtil.getParameter(request, "search_count", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, "org_rout_via_port_def_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setDestCd(JSPUtil.getParameter(request, "dest_cd", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setRatUtCdIn(JSPUtil.getParameter(request, "rat_ut_cd_in", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, "org_rout_pnt_loc_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setOriginCd(JSPUtil.getParameter(request, "origin_cd", ""));
		setDRcvDeTermCd(JSPUtil.getParameter(request, "d_rcv_de_term_cd", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, "dest_rout_pnt_loc_def_cd", ""));
		setPrsCustTpNm(JSPUtil.getParameter(request, "prs_cust_tp_nm", ""));
		setRRcvDeTermCd(JSPUtil.getParameter(request, "r_rcv_de_term_cd", ""));
		setMqcRngFmQty(JSPUtil.getParameter(request, "mqc_rng_fm_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCmpbGuidelineReportVO[]
	 */
	public RsltCmpbGuidelineReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCmpbGuidelineReportVO[]
	 */
	public RsltCmpbGuidelineReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCmpbGuidelineReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bseSeq = (JSPUtil.getParameter(request, prefix	+ "bse_seq", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] mqcRngToQty = (JSPUtil.getParameter(request, prefix	+ "mqc_rng_to_qty", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] prsCustTpCdIn = (JSPUtil.getParameter(request, prefix	+ "prs_cust_tp_cd_in", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] cmpbSeq = (JSPUtil.getParameter(request, prefix	+ "cmpb_seq", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prs_cust_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creOfcCdIn = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd_in", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] searchCount = (JSPUtil.getParameter(request, prefix	+ "search_count", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] destCd = (JSPUtil.getParameter(request, prefix	+ "dest_cd", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] ratUtCdIn = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd_in", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] originCd = (JSPUtil.getParameter(request, prefix	+ "origin_cd", length));
			String[] dRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "d_rcv_de_term_cd", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] prsCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prs_cust_tp_nm", length));
			String[] rRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "r_rcv_de_term_cd", length));
			String[] mqcRngFmQty = (JSPUtil.getParameter(request, prefix	+ "mqc_rng_fm_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCmpbGuidelineReportVO();
				if (bseSeq[i] != null)
					model.setBseSeq(bseSeq[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (mqcRngToQty[i] != null)
					model.setMqcRngToQty(mqcRngToQty[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (prsCustTpCdIn[i] != null)
					model.setPrsCustTpCdIn(prsCustTpCdIn[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (cmpbSeq[i] != null)
					model.setCmpbSeq(cmpbSeq[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prsCustTpCd[i] != null)
					model.setPrsCustTpCd(prsCustTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creOfcCdIn[i] != null)
					model.setCreOfcCdIn(creOfcCdIn[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (searchCount[i] != null)
					model.setSearchCount(searchCount[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (destCd[i] != null)
					model.setDestCd(destCd[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (ratUtCdIn[i] != null)
					model.setRatUtCdIn(ratUtCdIn[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (originCd[i] != null)
					model.setOriginCd(originCd[i]);
				if (dRcvDeTermCd[i] != null)
					model.setDRcvDeTermCd(dRcvDeTermCd[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (prsCustTpNm[i] != null)
					model.setPrsCustTpNm(prsCustTpNm[i]);
				if (rRcvDeTermCd[i] != null)
					model.setRRcvDeTermCd(rRcvDeTermCd[i]);
				if (mqcRngFmQty[i] != null)
					model.setMqcRngFmQty(mqcRngFmQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCmpbGuidelineReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCmpbGuidelineReportVO[]
	 */
	public RsltCmpbGuidelineReportVO[] getRsltCmpbGuidelineReportVOs(){
		RsltCmpbGuidelineReportVO[] vos = (RsltCmpbGuidelineReportVO[])models.toArray(new RsltCmpbGuidelineReportVO[models.size()]);
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
		this.bseSeq = this.bseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngToQty = this.mqcRngToQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCustTpCdIn = this.prsCustTpCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbSeq = this.cmpbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCustTpCd = this.prsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCdIn = this.creOfcCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCount = this.searchCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCd = this.destCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCdIn = this.ratUtCdIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originCd = this.originCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dRcvDeTermCd = this.dRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCustTpNm = this.prsCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rRcvDeTermCd = this.rRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngFmQty = this.mqcRngFmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
