/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SummaryReportByCustomerVO.java
*@FileTitle : SummaryReportByCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.02.03 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SummaryReportByCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SummaryReportByCustomerVO> models = new ArrayList<SummaryReportByCustomerVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String overCntr = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ttlSty = null;
	/* Column Info */
	private String incurCntr = null;
	/* Column Info */
	private String billAmt = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String trfCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlOver = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String dcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dmdtOfc = null;
	/* Column Info */
	private String ttlCntr = null;
	/* Column Info */
	private String avgOver = null;
	/* Column Info */
	private String dcCntr = null;
	/* Column Info */
	private String exptCntr = null;
	/* Column Info */
	private String ctrtOfc = null;
	/* Column Info */
	private String collAmt = null;
	/* Column Info */
	private String exptAmt = null;
	/* Column Info */
	private String cmdtAmt = null;
	/* Column Info */
	private String invCntr = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cvrCd = null;
	/* Column Info */
	private String collCntr = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cmdtCntr = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String incurAmt = null;
	/* Column Info */
	private String avgSty = null;
	/* Column Info */
	private String billCntr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SummaryReportByCustomerVO() {}

	public SummaryReportByCustomerVO(String ibflag, String pagerows, String ord, String scNo, String rfaNo, String scRfaNo, String custCd, String custNm, String ctrtOfc, String dmdtOfc, String trfCd, String cvrCd, String porCd, String polCd, String podCd, String delCd, String ttlSty, String ttlCntr, String avgSty, String ttlOver, String overCntr, String avgOver, String currCd, String incurCntr, String incurAmt, String cmdtCntr, String cmdtAmt, String exptCntr, String exptAmt, String dcCntr, String dcAmt, String billCntr, String billAmt, String invCntr, String invAmt, String collCntr, String collAmt) {
		this.porCd = porCd;
		this.overCntr = overCntr;
		this.currCd = currCd;
		this.custNm = custNm;
		this.ttlSty = ttlSty;
		this.incurCntr = incurCntr;
		this.billAmt = billAmt;
		this.ord = ord;
		this.trfCd = trfCd;
		this.pagerows = pagerows;
		this.ttlOver = ttlOver;
		this.rfaNo = rfaNo;
		this.dcAmt = dcAmt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.scNo = scNo;
		this.invAmt = invAmt;
		this.dmdtOfc = dmdtOfc;
		this.ttlCntr = ttlCntr;
		this.avgOver = avgOver;
		this.dcCntr = dcCntr;
		this.exptCntr = exptCntr;
		this.ctrtOfc = ctrtOfc;
		this.collAmt = collAmt;
		this.exptAmt = exptAmt;
		this.cmdtAmt = cmdtAmt;
		this.invCntr = invCntr;
		this.delCd = delCd;
		this.cvrCd = cvrCd;
		this.collCntr = collCntr;
		this.podCd = podCd;
		this.cmdtCntr = cmdtCntr;
		this.scRfaNo = scRfaNo;
		this.custCd = custCd;
		this.incurAmt = incurAmt;
		this.avgSty = avgSty;
		this.billCntr = billCntr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("over_cntr", getOverCntr());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ttl_sty", getTtlSty());
		this.hashColumns.put("incur_cntr", getIncurCntr());
		this.hashColumns.put("bill_amt", getBillAmt());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_over", getTtlOver());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("dmdt_ofc", getDmdtOfc());
		this.hashColumns.put("ttl_cntr", getTtlCntr());
		this.hashColumns.put("avg_over", getAvgOver());
		this.hashColumns.put("dc_cntr", getDcCntr());
		this.hashColumns.put("expt_cntr", getExptCntr());
		this.hashColumns.put("ctrt_ofc", getCtrtOfc());
		this.hashColumns.put("coll_amt", getCollAmt());
		this.hashColumns.put("expt_amt", getExptAmt());
		this.hashColumns.put("cmdt_amt", getCmdtAmt());
		this.hashColumns.put("inv_cntr", getInvCntr());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cvr_cd", getCvrCd());
		this.hashColumns.put("coll_cntr", getCollCntr());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cmdt_cntr", getCmdtCntr());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("incur_amt", getIncurAmt());
		this.hashColumns.put("avg_sty", getAvgSty());
		this.hashColumns.put("bill_cntr", getBillCntr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("over_cntr", "overCntr");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ttl_sty", "ttlSty");
		this.hashFields.put("incur_cntr", "incurCntr");
		this.hashFields.put("bill_amt", "billAmt");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_over", "ttlOver");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("dmdt_ofc", "dmdtOfc");
		this.hashFields.put("ttl_cntr", "ttlCntr");
		this.hashFields.put("avg_over", "avgOver");
		this.hashFields.put("dc_cntr", "dcCntr");
		this.hashFields.put("expt_cntr", "exptCntr");
		this.hashFields.put("ctrt_ofc", "ctrtOfc");
		this.hashFields.put("coll_amt", "collAmt");
		this.hashFields.put("expt_amt", "exptAmt");
		this.hashFields.put("cmdt_amt", "cmdtAmt");
		this.hashFields.put("inv_cntr", "invCntr");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cvr_cd", "cvrCd");
		this.hashFields.put("coll_cntr", "collCntr");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cmdt_cntr", "cmdtCntr");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("incur_amt", "incurAmt");
		this.hashFields.put("avg_sty", "avgSty");
		this.hashFields.put("bill_cntr", "billCntr");
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
	 * @return overCntr
	 */
	public String getOverCntr() {
		return this.overCntr;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return ttlSty
	 */
	public String getTtlSty() {
		return this.ttlSty;
	}
	
	/**
	 * Column Info
	 * @return incurCntr
	 */
	public String getIncurCntr() {
		return this.incurCntr;
	}
	
	/**
	 * Column Info
	 * @return billAmt
	 */
	public String getBillAmt() {
		return this.billAmt;
	}
	
	/**
	 * Column Info
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}
	
	/**
	 * Column Info
	 * @return trfCd
	 */
	public String getTrfCd() {
		return this.trfCd;
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
	 * @return ttlOver
	 */
	public String getTtlOver() {
		return this.ttlOver;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtOfc
	 */
	public String getDmdtOfc() {
		return this.dmdtOfc;
	}
	
	/**
	 * Column Info
	 * @return ttlCntr
	 */
	public String getTtlCntr() {
		return this.ttlCntr;
	}
	
	/**
	 * Column Info
	 * @return avgOver
	 */
	public String getAvgOver() {
		return this.avgOver;
	}
	
	/**
	 * Column Info
	 * @return dcCntr
	 */
	public String getDcCntr() {
		return this.dcCntr;
	}
	
	/**
	 * Column Info
	 * @return exptCntr
	 */
	public String getExptCntr() {
		return this.exptCntr;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfc
	 */
	public String getCtrtOfc() {
		return this.ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @return collAmt
	 */
	public String getCollAmt() {
		return this.collAmt;
	}
	
	/**
	 * Column Info
	 * @return exptAmt
	 */
	public String getExptAmt() {
		return this.exptAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdtAmt
	 */
	public String getCmdtAmt() {
		return this.cmdtAmt;
	}
	
	/**
	 * Column Info
	 * @return invCntr
	 */
	public String getInvCntr() {
		return this.invCntr;
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
	 * @return cvrCd
	 */
	public String getCvrCd() {
		return this.cvrCd;
	}
	
	/**
	 * Column Info
	 * @return collCntr
	 */
	public String getCollCntr() {
		return this.collCntr;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCntr
	 */
	public String getCmdtCntr() {
		return this.cmdtCntr;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return incurAmt
	 */
	public String getIncurAmt() {
		return this.incurAmt;
	}
	
	/**
	 * Column Info
	 * @return avgSty
	 */
	public String getAvgSty() {
		return this.avgSty;
	}
	
	/**
	 * Column Info
	 * @return billCntr
	 */
	public String getBillCntr() {
		return this.billCntr;
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
	 * @param overCntr
	 */
	public void setOverCntr(String overCntr) {
		this.overCntr = overCntr;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param ttlSty
	 */
	public void setTtlSty(String ttlSty) {
		this.ttlSty = ttlSty;
	}
	
	/**
	 * Column Info
	 * @param incurCntr
	 */
	public void setIncurCntr(String incurCntr) {
		this.incurCntr = incurCntr;
	}
	
	/**
	 * Column Info
	 * @param billAmt
	 */
	public void setBillAmt(String billAmt) {
		this.billAmt = billAmt;
	}
	
	/**
	 * Column Info
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	/**
	 * Column Info
	 * @param trfCd
	 */
	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
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
	 * @param ttlOver
	 */
	public void setTtlOver(String ttlOver) {
		this.ttlOver = ttlOver;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtOfc
	 */
	public void setDmdtOfc(String dmdtOfc) {
		this.dmdtOfc = dmdtOfc;
	}
	
	/**
	 * Column Info
	 * @param ttlCntr
	 */
	public void setTtlCntr(String ttlCntr) {
		this.ttlCntr = ttlCntr;
	}
	
	/**
	 * Column Info
	 * @param avgOver
	 */
	public void setAvgOver(String avgOver) {
		this.avgOver = avgOver;
	}
	
	/**
	 * Column Info
	 * @param dcCntr
	 */
	public void setDcCntr(String dcCntr) {
		this.dcCntr = dcCntr;
	}
	
	/**
	 * Column Info
	 * @param exptCntr
	 */
	public void setExptCntr(String exptCntr) {
		this.exptCntr = exptCntr;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfc
	 */
	public void setCtrtOfc(String ctrtOfc) {
		this.ctrtOfc = ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @param collAmt
	 */
	public void setCollAmt(String collAmt) {
		this.collAmt = collAmt;
	}
	
	/**
	 * Column Info
	 * @param exptAmt
	 */
	public void setExptAmt(String exptAmt) {
		this.exptAmt = exptAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdtAmt
	 */
	public void setCmdtAmt(String cmdtAmt) {
		this.cmdtAmt = cmdtAmt;
	}
	
	/**
	 * Column Info
	 * @param invCntr
	 */
	public void setInvCntr(String invCntr) {
		this.invCntr = invCntr;
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
	 * @param cvrCd
	 */
	public void setCvrCd(String cvrCd) {
		this.cvrCd = cvrCd;
	}
	
	/**
	 * Column Info
	 * @param collCntr
	 */
	public void setCollCntr(String collCntr) {
		this.collCntr = collCntr;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCntr
	 */
	public void setCmdtCntr(String cmdtCntr) {
		this.cmdtCntr = cmdtCntr;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param incurAmt
	 */
	public void setIncurAmt(String incurAmt) {
		this.incurAmt = incurAmt;
	}
	
	/**
	 * Column Info
	 * @param avgSty
	 */
	public void setAvgSty(String avgSty) {
		this.avgSty = avgSty;
	}
	
	/**
	 * Column Info
	 * @param billCntr
	 */
	public void setBillCntr(String billCntr) {
		this.billCntr = billCntr;
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
		setOverCntr(JSPUtil.getParameter(request, prefix + "over_cntr", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setTtlSty(JSPUtil.getParameter(request, prefix + "ttl_sty", ""));
		setIncurCntr(JSPUtil.getParameter(request, prefix + "incur_cntr", ""));
		setBillAmt(JSPUtil.getParameter(request, prefix + "bill_amt", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlOver(JSPUtil.getParameter(request, prefix + "ttl_over", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setDmdtOfc(JSPUtil.getParameter(request, prefix + "dmdt_ofc", ""));
		setTtlCntr(JSPUtil.getParameter(request, prefix + "ttl_cntr", ""));
		setAvgOver(JSPUtil.getParameter(request, prefix + "avg_over", ""));
		setDcCntr(JSPUtil.getParameter(request, prefix + "dc_cntr", ""));
		setExptCntr(JSPUtil.getParameter(request, prefix + "expt_cntr", ""));
		setCtrtOfc(JSPUtil.getParameter(request, prefix + "ctrt_ofc", ""));
		setCollAmt(JSPUtil.getParameter(request, prefix + "coll_amt", ""));
		setExptAmt(JSPUtil.getParameter(request, prefix + "expt_amt", ""));
		setCmdtAmt(JSPUtil.getParameter(request, prefix + "cmdt_amt", ""));
		setInvCntr(JSPUtil.getParameter(request, prefix + "inv_cntr", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCvrCd(JSPUtil.getParameter(request, prefix + "cvr_cd", ""));
		setCollCntr(JSPUtil.getParameter(request, prefix + "coll_cntr", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCmdtCntr(JSPUtil.getParameter(request, prefix + "cmdt_cntr", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setIncurAmt(JSPUtil.getParameter(request, prefix + "incur_amt", ""));
		setAvgSty(JSPUtil.getParameter(request, prefix + "avg_sty", ""));
		setBillCntr(JSPUtil.getParameter(request, prefix + "bill_cntr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SummaryReportByCustomerVO[]
	 */
	public SummaryReportByCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SummaryReportByCustomerVO[]
	 */
	public SummaryReportByCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SummaryReportByCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] overCntr = (JSPUtil.getParameter(request, prefix	+ "over_cntr", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ttlSty = (JSPUtil.getParameter(request, prefix	+ "ttl_sty", length));
			String[] incurCntr = (JSPUtil.getParameter(request, prefix	+ "incur_cntr", length));
			String[] billAmt = (JSPUtil.getParameter(request, prefix	+ "bill_amt", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlOver = (JSPUtil.getParameter(request, prefix	+ "ttl_over", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dmdtOfc = (JSPUtil.getParameter(request, prefix	+ "dmdt_ofc", length));
			String[] ttlCntr = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr", length));
			String[] avgOver = (JSPUtil.getParameter(request, prefix	+ "avg_over", length));
			String[] dcCntr = (JSPUtil.getParameter(request, prefix	+ "dc_cntr", length));
			String[] exptCntr = (JSPUtil.getParameter(request, prefix	+ "expt_cntr", length));
			String[] ctrtOfc = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc", length));
			String[] collAmt = (JSPUtil.getParameter(request, prefix	+ "coll_amt", length));
			String[] exptAmt = (JSPUtil.getParameter(request, prefix	+ "expt_amt", length));
			String[] cmdtAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_amt", length));
			String[] invCntr = (JSPUtil.getParameter(request, prefix	+ "inv_cntr", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cvrCd = (JSPUtil.getParameter(request, prefix	+ "cvr_cd", length));
			String[] collCntr = (JSPUtil.getParameter(request, prefix	+ "coll_cntr", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cmdtCntr = (JSPUtil.getParameter(request, prefix	+ "cmdt_cntr", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] incurAmt = (JSPUtil.getParameter(request, prefix	+ "incur_amt", length));
			String[] avgSty = (JSPUtil.getParameter(request, prefix	+ "avg_sty", length));
			String[] billCntr = (JSPUtil.getParameter(request, prefix	+ "bill_cntr", length));
			
			for (int i = 0; i < length; i++) {
				model = new SummaryReportByCustomerVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (overCntr[i] != null)
					model.setOverCntr(overCntr[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ttlSty[i] != null)
					model.setTtlSty(ttlSty[i]);
				if (incurCntr[i] != null)
					model.setIncurCntr(incurCntr[i]);
				if (billAmt[i] != null)
					model.setBillAmt(billAmt[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlOver[i] != null)
					model.setTtlOver(ttlOver[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dmdtOfc[i] != null)
					model.setDmdtOfc(dmdtOfc[i]);
				if (ttlCntr[i] != null)
					model.setTtlCntr(ttlCntr[i]);
				if (avgOver[i] != null)
					model.setAvgOver(avgOver[i]);
				if (dcCntr[i] != null)
					model.setDcCntr(dcCntr[i]);
				if (exptCntr[i] != null)
					model.setExptCntr(exptCntr[i]);
				if (ctrtOfc[i] != null)
					model.setCtrtOfc(ctrtOfc[i]);
				if (collAmt[i] != null)
					model.setCollAmt(collAmt[i]);
				if (exptAmt[i] != null)
					model.setExptAmt(exptAmt[i]);
				if (cmdtAmt[i] != null)
					model.setCmdtAmt(cmdtAmt[i]);
				if (invCntr[i] != null)
					model.setInvCntr(invCntr[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cvrCd[i] != null)
					model.setCvrCd(cvrCd[i]);
				if (collCntr[i] != null)
					model.setCollCntr(collCntr[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cmdtCntr[i] != null)
					model.setCmdtCntr(cmdtCntr[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (incurAmt[i] != null)
					model.setIncurAmt(incurAmt[i]);
				if (avgSty[i] != null)
					model.setAvgSty(avgSty[i]);
				if (billCntr[i] != null)
					model.setBillCntr(billCntr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSummaryReportByCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SummaryReportByCustomerVO[]
	 */
	public SummaryReportByCustomerVO[] getSummaryReportByCustomerVOs(){
		SummaryReportByCustomerVO[] vos = (SummaryReportByCustomerVO[])models.toArray(new SummaryReportByCustomerVO[models.size()]);
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
		this.overCntr = this.overCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSty = this.ttlSty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurCntr = this.incurCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billAmt = this.billAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlOver = this.ttlOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtOfc = this.dmdtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntr = this.ttlCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgOver = this.avgOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcCntr = this.dcCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCntr = this.exptCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfc = this.ctrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collAmt = this.collAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptAmt = this.exptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtAmt = this.cmdtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCntr = this.invCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrCd = this.cvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collCntr = this.collCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCntr = this.cmdtCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurAmt = this.incurAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSty = this.avgSty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billCntr = this.billCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
