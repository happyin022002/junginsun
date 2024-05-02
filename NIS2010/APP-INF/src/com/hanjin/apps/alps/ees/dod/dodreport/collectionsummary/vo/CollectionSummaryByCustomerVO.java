/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryByCustomerVO.java
*@FileTitle : CollectionSummaryByCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.05.20 홍성필 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo;

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
 * @author 홍성필
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class CollectionSummaryByCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CollectionSummaryByCustomerVO> models = new ArrayList<CollectionSummaryByCustomerVO>();
	
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String genTrfAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String spclTrfCntr = null;
	/* Column Info */
	private String adjustAmt = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String custFlg = null;
	/* Column Info */
	private String genTrfCntr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String chkSubOfc = null;
	/* Column Info */
	private String dodOfcCd = null;
	/* Column Info */
	private String invoiceCntr = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String reqOfcCd = null;
	/* Column Info */
	private String ctrtOfc = null;
	/* Column Info */
	private String pendingAmt = null;
	/* Column Info */
	private String invoiceAmt = null;
	/* Column Info */
	private String schFlg = null;
	/* Column Info */
	private String spclTrfAmt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String rtnLocCd = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String adjustCntr = null;
	/* Column Info */
	private String pendingCntr = null;
	/* Column Info */
	private String arIf = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CollectionSummaryByCustomerVO() {}

	public CollectionSummaryByCustomerVO(String ibflag, String pagerows, String scNo, String rfaNo, String custCd, String custNm, String reqOfcCd, String dodOfcCd, String locCd, String cntrTpszCd, String currCd, String genTrfCntr, String genTrfAmt, String spclTrfCntr, String spclTrfAmt, String adjustCntr, String adjustAmt, String invoiceCntr, String invoiceAmt, String pendingCntr, String pendingAmt, String period, String tpsz, String schFlg, String scRfaNo, String ctrtOfc, String custFlg, String custType, String ofcFlg, String office, String chkSubOfc, String rtnLocCd, String from, String to, String arIf) {
		this.to = to;
		this.genTrfAmt = genTrfAmt;
		this.currCd = currCd;
		this.custNm = custNm;
		this.spclTrfCntr = spclTrfCntr;
		this.adjustAmt = adjustAmt;
		this.from = from;
		this.custFlg = custFlg;
		this.genTrfCntr = genTrfCntr;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.chkSubOfc = chkSubOfc;
		this.dodOfcCd = dodOfcCd;
		this.invoiceCntr = invoiceCntr;
		this.custType = custType;
		this.office = office;
		this.reqOfcCd = reqOfcCd;
		this.ctrtOfc = ctrtOfc;
		this.pendingAmt = pendingAmt;
		this.invoiceAmt = invoiceAmt;
		this.schFlg = schFlg;
		this.spclTrfAmt = spclTrfAmt;
		this.period = period;
		this.ofcFlg = ofcFlg;
		this.rtnLocCd = rtnLocCd;
		this.tpsz = tpsz;
		this.scRfaNo = scRfaNo;
		this.custCd = custCd;
		this.adjustCntr = adjustCntr;
		this.pendingCntr = pendingCntr;
		this.arIf = arIf;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("spcl_trf_cntr", getSpclTrfCntr());
		this.hashColumns.put("adjust_amt", getAdjustAmt());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("cust_flg", getCustFlg());
		this.hashColumns.put("gen_trf_cntr", getGenTrfCntr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("chk_sub_ofc", getChkSubOfc());
		this.hashColumns.put("dod_ofc_cd", getDodOfcCd());
		this.hashColumns.put("invoice_cntr", getInvoiceCntr());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("req_ofc_cd", getReqOfcCd());
		this.hashColumns.put("ctrt_ofc", getCtrtOfc());
		this.hashColumns.put("pending_amt", getPendingAmt());
		this.hashColumns.put("invoice_amt", getInvoiceAmt());
		this.hashColumns.put("sch_flg", getSchFlg());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("rtn_loc_cd", getRtnLocCd());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("adjust_cntr", getAdjustCntr());
		this.hashColumns.put("pending_cntr", getPendingCntr());
		this.hashColumns.put("ar_if", getArIf());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to", "to");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("spcl_trf_cntr", "spclTrfCntr");
		this.hashFields.put("adjust_amt", "adjustAmt");
		this.hashFields.put("from", "from");
		this.hashFields.put("cust_flg", "custFlg");
		this.hashFields.put("gen_trf_cntr", "genTrfCntr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chk_sub_ofc", "chkSubOfc");
		this.hashFields.put("dod_ofc_cd", "dodOfcCd");
		this.hashFields.put("invoice_cntr", "invoiceCntr");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("office", "office");
		this.hashFields.put("req_ofc_cd", "reqOfcCd");
		this.hashFields.put("ctrt_ofc", "ctrtOfc");
		this.hashFields.put("pending_amt", "pendingAmt");
		this.hashFields.put("invoice_amt", "invoiceAmt");
		this.hashFields.put("sch_flg", "schFlg");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("period", "period");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("rtn_loc_cd", "rtnLocCd");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("adjust_cntr", "adjustCntr");
		this.hashFields.put("pending_cntr", "pendingCntr");
		this.hashFields.put("ar_if", "arIf");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return to
	 */
	public String getTo() {
		return this.to;
	}
	
	/**
	 * Column Info
	 * @return genTrfAmt
	 */
	public String getGenTrfAmt() {
		return this.genTrfAmt;
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
	 * @return spclTrfCntr
	 */
	public String getSpclTrfCntr() {
		return this.spclTrfCntr;
	}
	
	/**
	 * Column Info
	 * @return adjustAmt
	 */
	public String getAdjustAmt() {
		return this.adjustAmt;
	}
	
	/**
	 * Column Info
	 * @return from
	 */
	public String getFrom() {
		return this.from;
	}
	
	/**
	 * Column Info
	 * @return custFlg
	 */
	public String getCustFlg() {
		return this.custFlg;
	}
	
	/**
	 * Column Info
	 * @return genTrfCntr
	 */
	public String getGenTrfCntr() {
		return this.genTrfCntr;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return chkSubOfc
	 */
	public String getChkSubOfc() {
		return this.chkSubOfc;
	}
	
	/**
	 * Column Info
	 * @return dodOfcCd
	 */
	public String getDodOfcCd() {
		return this.dodOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invoiceCntr
	 */
	public String getInvoiceCntr() {
		return this.invoiceCntr;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return reqOfcCd
	 */
	public String getReqOfcCd() {
		return this.reqOfcCd;
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
	 * @return pendingAmt
	 */
	public String getPendingAmt() {
		return this.pendingAmt;
	}
	
	/**
	 * Column Info
	 * @return invoiceAmt
	 */
	public String getInvoiceAmt() {
		return this.invoiceAmt;
	}
	
	/**
	 * Column Info
	 * @return schFlg
	 */
	public String getSchFlg() {
		return this.schFlg;
	}
	
	/**
	 * Column Info
	 * @return spclTrfAmt
	 */
	public String getSpclTrfAmt() {
		return this.spclTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
	}
	
	/**
	 * Column Info
	 * @return rtnLocCd
	 */
	public String getRtnLocCd() {
		return this.rtnLocCd;
	}
	
	/**
	 * Column Info
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
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
	 * @return adjustCntr
	 */
	public String getAdjustCntr() {
		return this.adjustCntr;
	}
	
	/**
	 * Column Info
	 * @return pendingCntr
	 */
	public String getPendingCntr() {
		return this.pendingCntr;
	}
	
	/**
	 * Column Info
	 * @return arIf
	 */
	public String getArIf() {
		return this.arIf;
	}

	/**
	 * Column Info
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * Column Info
	 * @param genTrfAmt
	 */
	public void setGenTrfAmt(String genTrfAmt) {
		this.genTrfAmt = genTrfAmt;
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
	 * @param spclTrfCntr
	 */
	public void setSpclTrfCntr(String spclTrfCntr) {
		this.spclTrfCntr = spclTrfCntr;
	}
	
	/**
	 * Column Info
	 * @param adjustAmt
	 */
	public void setAdjustAmt(String adjustAmt) {
		this.adjustAmt = adjustAmt;
	}
	
	/**
	 * Column Info
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Column Info
	 * @param custFlg
	 */
	public void setCustFlg(String custFlg) {
		this.custFlg = custFlg;
	}
	
	/**
	 * Column Info
	 * @param genTrfCntr
	 */
	public void setGenTrfCntr(String genTrfCntr) {
		this.genTrfCntr = genTrfCntr;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param chkSubOfc
	 */
	public void setChkSubOfc(String chkSubOfc) {
		this.chkSubOfc = chkSubOfc;
	}
	
	/**
	 * Column Info
	 * @param dodOfcCd
	 */
	public void setDodOfcCd(String dodOfcCd) {
		this.dodOfcCd = dodOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invoiceCntr
	 */
	public void setInvoiceCntr(String invoiceCntr) {
		this.invoiceCntr = invoiceCntr;
	}
	
	/**
	 * Column Info
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param reqOfcCd
	 */
	public void setReqOfcCd(String reqOfcCd) {
		this.reqOfcCd = reqOfcCd;
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
	 * @param pendingAmt
	 */
	public void setPendingAmt(String pendingAmt) {
		this.pendingAmt = pendingAmt;
	}
	
	/**
	 * Column Info
	 * @param invoiceAmt
	 */
	public void setInvoiceAmt(String invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}
	
	/**
	 * Column Info
	 * @param schFlg
	 */
	public void setSchFlg(String schFlg) {
		this.schFlg = schFlg;
	}
	
	/**
	 * Column Info
	 * @param spclTrfAmt
	 */
	public void setSpclTrfAmt(String spclTrfAmt) {
		this.spclTrfAmt = spclTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
	}
	
	/**
	 * Column Info
	 * @param rtnLocCd
	 */
	public void setRtnLocCd(String rtnLocCd) {
		this.rtnLocCd = rtnLocCd;
	}
	
	/**
	 * Column Info
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
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
	 * @param adjustCntr
	 */
	public void setAdjustCntr(String adjustCntr) {
		this.adjustCntr = adjustCntr;
	}
	
	/**
	 * Column Info
	 * @param pendingCntr
	 */
	public void setPendingCntr(String pendingCntr) {
		this.pendingCntr = pendingCntr;
	}
	
	/**
	 * Column Info
	 * @param arIf
	 */
	public void setArIf(String arIf) {
		this.arIf = arIf;
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
		setTo(JSPUtil.getParameter(request, prefix + "to", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSpclTrfCntr(JSPUtil.getParameter(request, prefix + "spcl_trf_cntr", ""));
		setAdjustAmt(JSPUtil.getParameter(request, prefix + "adjust_amt", ""));
		setFrom(JSPUtil.getParameter(request, prefix + "from", ""));
		setCustFlg(JSPUtil.getParameter(request, prefix + "cust_flg", ""));
		setGenTrfCntr(JSPUtil.getParameter(request, prefix + "gen_trf_cntr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setChkSubOfc(JSPUtil.getParameter(request, prefix + "chk_sub_ofc", ""));
		setDodOfcCd(JSPUtil.getParameter(request, prefix + "dod_ofc_cd", ""));
		setInvoiceCntr(JSPUtil.getParameter(request, prefix + "invoice_cntr", ""));
		setCustType(JSPUtil.getParameter(request, prefix + "cust_type", ""));
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setReqOfcCd(JSPUtil.getParameter(request, prefix + "req_ofc_cd", ""));
		setCtrtOfc(JSPUtil.getParameter(request, prefix + "ctrt_ofc", ""));
		setPendingAmt(JSPUtil.getParameter(request, prefix + "pending_amt", ""));
		setInvoiceAmt(JSPUtil.getParameter(request, prefix + "invoice_amt", ""));
		setSchFlg(JSPUtil.getParameter(request, prefix + "sch_flg", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setOfcFlg(JSPUtil.getParameter(request, prefix + "ofc_flg", ""));
		setRtnLocCd(JSPUtil.getParameter(request, prefix + "rtn_loc_cd", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setAdjustCntr(JSPUtil.getParameter(request, prefix + "adjust_cntr", ""));
		setPendingCntr(JSPUtil.getParameter(request, prefix + "pending_cntr", ""));
		setArIf(JSPUtil.getParameter(request, prefix + "ar_if", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CollectionSummaryByCustomerVO[]
	 */
	public CollectionSummaryByCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CollectionSummaryByCustomerVO[]
	 */
	public CollectionSummaryByCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CollectionSummaryByCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] spclTrfCntr = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_cntr", length));
			String[] adjustAmt = (JSPUtil.getParameter(request, prefix	+ "adjust_amt", length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from", length));
			String[] custFlg = (JSPUtil.getParameter(request, prefix	+ "cust_flg", length));
			String[] genTrfCntr = (JSPUtil.getParameter(request, prefix	+ "gen_trf_cntr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] chkSubOfc = (JSPUtil.getParameter(request, prefix	+ "chk_sub_ofc", length));
			String[] dodOfcCd = (JSPUtil.getParameter(request, prefix	+ "dod_ofc_cd", length));
			String[] invoiceCntr = (JSPUtil.getParameter(request, prefix	+ "invoice_cntr", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] reqOfcCd = (JSPUtil.getParameter(request, prefix	+ "req_ofc_cd", length));
			String[] ctrtOfc = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc", length));
			String[] pendingAmt = (JSPUtil.getParameter(request, prefix	+ "pending_amt", length));
			String[] invoiceAmt = (JSPUtil.getParameter(request, prefix	+ "invoice_amt", length));
			String[] schFlg = (JSPUtil.getParameter(request, prefix	+ "sch_flg", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] rtnLocCd = (JSPUtil.getParameter(request, prefix	+ "rtn_loc_cd", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] adjustCntr = (JSPUtil.getParameter(request, prefix	+ "adjust_cntr", length));
			String[] pendingCntr = (JSPUtil.getParameter(request, prefix	+ "pending_cntr", length));
			String[] arIf = (JSPUtil.getParameter(request, prefix	+ "ar_if", length));
			
			for (int i = 0; i < length; i++) {
				model = new CollectionSummaryByCustomerVO();
				if (to[i] != null)
					model.setTo(to[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (spclTrfCntr[i] != null)
					model.setSpclTrfCntr(spclTrfCntr[i]);
				if (adjustAmt[i] != null)
					model.setAdjustAmt(adjustAmt[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (custFlg[i] != null)
					model.setCustFlg(custFlg[i]);
				if (genTrfCntr[i] != null)
					model.setGenTrfCntr(genTrfCntr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (chkSubOfc[i] != null)
					model.setChkSubOfc(chkSubOfc[i]);
				if (dodOfcCd[i] != null)
					model.setDodOfcCd(dodOfcCd[i]);
				if (invoiceCntr[i] != null)
					model.setInvoiceCntr(invoiceCntr[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (reqOfcCd[i] != null)
					model.setReqOfcCd(reqOfcCd[i]);
				if (ctrtOfc[i] != null)
					model.setCtrtOfc(ctrtOfc[i]);
				if (pendingAmt[i] != null)
					model.setPendingAmt(pendingAmt[i]);
				if (invoiceAmt[i] != null)
					model.setInvoiceAmt(invoiceAmt[i]);
				if (schFlg[i] != null)
					model.setSchFlg(schFlg[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (rtnLocCd[i] != null)
					model.setRtnLocCd(rtnLocCd[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (adjustCntr[i] != null)
					model.setAdjustCntr(adjustCntr[i]);
				if (pendingCntr[i] != null)
					model.setPendingCntr(pendingCntr[i]);
				if (arIf[i] != null)
					model.setArIf(arIf[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCollectionSummaryByCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CollectionSummaryByCustomerVO[]
	 */
	public CollectionSummaryByCustomerVO[] getCollectionSummaryByCustomerVOs(){
		CollectionSummaryByCustomerVO[] vos = (CollectionSummaryByCustomerVO[])models.toArray(new CollectionSummaryByCustomerVO[models.size()]);
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
		this.to = this.to .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfCntr = this.spclTrfCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustAmt = this.adjustAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFlg = this.custFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfCntr = this.genTrfCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSubOfc = this.chkSubOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodOfcCd = this.dodOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceCntr = this.invoiceCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfcCd = this.reqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfc = this.ctrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingAmt = this.pendingAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceAmt = this.invoiceAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schFlg = this.schFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnLocCd = this.rtnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustCntr = this.adjustCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingCntr = this.pendingCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIf = this.arIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
