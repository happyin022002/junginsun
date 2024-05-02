/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SumbyOfcDetailVO.java
*@FileTitle : SumbyOfcDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class SumbyOfcDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SumbyOfcDetailVO> models = new ArrayList<SumbyOfcDetailVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String genTrfAmt = null;
	/* Column Info */
	private String troCntrRtnYdCd = null;
	/* Column Info */
	private String exemption = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sTo = null;
	/* Column Info */
	private String invoiceUsdAmt = null;
	/* Column Info */
	private String adjustAmt = null;
	/* Column Info */
	private String customer = null;
	/* Column Info */
	private String invoiceCustCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arIf = null;
	/* Column Info */
	private String rtnDate = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String sFrom = null;
	/* Column Info */
	private String actualRtnYard = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invoiceCustName = null;
	/* Column Info */
	private String troDt = null;
	/* Column Info */
	private String genAmt = null;
	/* Column Info */
	private String pendingAmt = null;
	/* Column Info */
	private String invoiceAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgDel = null;
	/* Column Info */
	private String spclTrfAmt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String invOfc = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String spcAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String itemList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SumbyOfcDetailVO() {}

	public SumbyOfcDetailVO(String ibflag, String pagerows, String cfmOfcCd, String cntrNo, String cntrTpszCd, String troCntrRtnYdCd, String actualRtnYard, String rtnDate, String troDt, String bkgNo, String porCd, String polCd, String podCd, String delCd, String scNo, String rfaNo, String custCntCd, String custSeq, String customer, String custLglEngNm, String invoiceCustCd, String invoiceCustName, String currCd, String genTrfAmt, String spclTrfAmt, String adjustAmt, String invoiceAmt, String invoiceUsdAmt, String spcAmt, String genAmt, String exemption, String arIfDt, String creUsrId, String pendingAmt, String invOfc, String bkgDel, String cntrRtnYdCd, String itemList, String arIf, String custCd, String period, String sTo, String sFrom) {
		this.porCd = porCd;
		this.genTrfAmt = genTrfAmt;
		this.troCntrRtnYdCd = troCntrRtnYdCd;
		this.exemption = exemption;
		this.currCd = currCd;
		this.sTo = sTo;
		this.invoiceUsdAmt = invoiceUsdAmt;
		this.adjustAmt = adjustAmt;
		this.customer = customer;
		this.invoiceCustCd = invoiceCustCd;
		this.pagerows = pagerows;
		this.arIf = arIf;
		this.rtnDate = rtnDate;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.arIfDt = arIfDt;
		this.sFrom = sFrom;
		this.actualRtnYard = actualRtnYard;
		this.custCntCd = custCntCd;
		this.invoiceCustName = invoiceCustName;
		this.troDt = troDt;
		this.genAmt = genAmt;
		this.pendingAmt = pendingAmt;
		this.invoiceAmt = invoiceAmt;
		this.delCd = delCd;
		this.bkgDel = bkgDel;
		this.spclTrfAmt = spclTrfAmt;
		this.period = period;
		this.custSeq = custSeq;
		this.invOfc = invOfc;
		this.custLglEngNm = custLglEngNm;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cfmOfcCd = cfmOfcCd;
		this.custCd = custCd;
		this.spcAmt = spcAmt;
		this.cntrNo = cntrNo;
		this.itemList = itemList;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("tro_cntr_rtn_yd_cd", getTroCntrRtnYdCd());
		this.hashColumns.put("exemption", getExemption());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_to", getSTo());
		this.hashColumns.put("invoice_usd_amt", getInvoiceUsdAmt());
		this.hashColumns.put("adjust_amt", getAdjustAmt());
		this.hashColumns.put("customer", getCustomer());
		this.hashColumns.put("invoice_cust_cd", getInvoiceCustCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ar_if", getArIf());
		this.hashColumns.put("rtn_date", getRtnDate());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("s_from", getSFrom());
		this.hashColumns.put("actual_rtn_yard", getActualRtnYard());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("invoice_cust_name", getInvoiceCustName());
		this.hashColumns.put("tro_dt", getTroDt());
		this.hashColumns.put("gen_amt", getGenAmt());
		this.hashColumns.put("pending_amt", getPendingAmt());
		this.hashColumns.put("invoice_amt", getInvoiceAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_del", getBkgDel());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("inv_ofc", getInvOfc());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("spc_amt", getSpcAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("item_list", getItemList());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("tro_cntr_rtn_yd_cd", "troCntrRtnYdCd");
		this.hashFields.put("exemption", "exemption");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_to", "sTo");
		this.hashFields.put("invoice_usd_amt", "invoiceUsdAmt");
		this.hashFields.put("adjust_amt", "adjustAmt");
		this.hashFields.put("customer", "customer");
		this.hashFields.put("invoice_cust_cd", "invoiceCustCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ar_if", "arIf");
		this.hashFields.put("rtn_date", "rtnDate");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("s_from", "sFrom");
		this.hashFields.put("actual_rtn_yard", "actualRtnYard");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("invoice_cust_name", "invoiceCustName");
		this.hashFields.put("tro_dt", "troDt");
		this.hashFields.put("gen_amt", "genAmt");
		this.hashFields.put("pending_amt", "pendingAmt");
		this.hashFields.put("invoice_amt", "invoiceAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_del", "bkgDel");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("period", "period");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("inv_ofc", "invOfc");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("spc_amt", "spcAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("item_list", "itemList");
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
	 * @return genTrfAmt
	 */
	public String getGenTrfAmt() {
		return this.genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @return troCntrRtnYdCd
	 */
	public String getTroCntrRtnYdCd() {
		return this.troCntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return exemption
	 */
	public String getExemption() {
		return this.exemption;
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
	 * @return sTo
	 */
	public String getSTo() {
		return this.sTo;
	}
	
	/**
	 * Column Info
	 * @return invoiceUsdAmt
	 */
	public String getInvoiceUsdAmt() {
		return this.invoiceUsdAmt;
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
	 * @return customer
	 */
	public String getCustomer() {
		return this.customer;
	}
	
	/**
	 * Column Info
	 * @return invoiceCustCd
	 */
	public String getInvoiceCustCd() {
		return this.invoiceCustCd;
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
	 * @return arIf
	 */
	public String getArIf() {
		return this.arIf;
	}
	
	/**
	 * Column Info
	 * @return rtnDate
	 */
	public String getRtnDate() {
		return this.rtnDate;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
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
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
	}
	
	/**
	 * Column Info
	 * @return sFrom
	 */
	public String getSFrom() {
		return this.sFrom;
	}
	
	/**
	 * Column Info
	 * @return actualRtnYard
	 */
	public String getActualRtnYard() {
		return this.actualRtnYard;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return invoiceCustName
	 */
	public String getInvoiceCustName() {
		return this.invoiceCustName;
	}
	
	/**
	 * Column Info
	 * @return troDt
	 */
	public String getTroDt() {
		return this.troDt;
	}
	
	/**
	 * Column Info
	 * @return genAmt
	 */
	public String getGenAmt() {
		return this.genAmt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDel
	 */
	public String getBkgDel() {
		return this.bkgDel;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return invOfc
	 */
	public String getInvOfc() {
		return this.invOfc;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
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
	 * @return spcAmt
	 */
	public String getSpcAmt() {
		return this.spcAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return itemList
	 */
	public String getItemList() {
		return this.itemList;
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
	 * @param genTrfAmt
	 */
	public void setGenTrfAmt(String genTrfAmt) {
		this.genTrfAmt = genTrfAmt;
	}
	
	/**
	 * Column Info
	 * @param troCntrRtnYdCd
	 */
	public void setTroCntrRtnYdCd(String troCntrRtnYdCd) {
		this.troCntrRtnYdCd = troCntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param exemption
	 */
	public void setExemption(String exemption) {
		this.exemption = exemption;
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
	 * @param sTo
	 */
	public void setSTo(String sTo) {
		this.sTo = sTo;
	}
	
	/**
	 * Column Info
	 * @param invoiceUsdAmt
	 */
	public void setInvoiceUsdAmt(String invoiceUsdAmt) {
		this.invoiceUsdAmt = invoiceUsdAmt;
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
	 * @param customer
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	/**
	 * Column Info
	 * @param invoiceCustCd
	 */
	public void setInvoiceCustCd(String invoiceCustCd) {
		this.invoiceCustCd = invoiceCustCd;
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
	 * @param arIf
	 */
	public void setArIf(String arIf) {
		this.arIf = arIf;
	}
	
	/**
	 * Column Info
	 * @param rtnDate
	 */
	public void setRtnDate(String rtnDate) {
		this.rtnDate = rtnDate;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
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
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
	}
	
	/**
	 * Column Info
	 * @param sFrom
	 */
	public void setSFrom(String sFrom) {
		this.sFrom = sFrom;
	}
	
	/**
	 * Column Info
	 * @param actualRtnYard
	 */
	public void setActualRtnYard(String actualRtnYard) {
		this.actualRtnYard = actualRtnYard;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param invoiceCustName
	 */
	public void setInvoiceCustName(String invoiceCustName) {
		this.invoiceCustName = invoiceCustName;
	}
	
	/**
	 * Column Info
	 * @param troDt
	 */
	public void setTroDt(String troDt) {
		this.troDt = troDt;
	}
	
	/**
	 * Column Info
	 * @param genAmt
	 */
	public void setGenAmt(String genAmt) {
		this.genAmt = genAmt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDel
	 */
	public void setBkgDel(String bkgDel) {
		this.bkgDel = bkgDel;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param invOfc
	 */
	public void setInvOfc(String invOfc) {
		this.invOfc = invOfc;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
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
	 * @param spcAmt
	 */
	public void setSpcAmt(String spcAmt) {
		this.spcAmt = spcAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param itemList
	 */
	public void setItemList(String itemList) {
		this.itemList = itemList;
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
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setTroCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "tro_cntr_rtn_yd_cd", ""));
		setExemption(JSPUtil.getParameter(request, prefix + "exemption", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSTo(JSPUtil.getParameter(request, prefix + "s_to", ""));
		setInvoiceUsdAmt(JSPUtil.getParameter(request, prefix + "invoice_usd_amt", ""));
		setAdjustAmt(JSPUtil.getParameter(request, prefix + "adjust_amt", ""));
		setCustomer(JSPUtil.getParameter(request, prefix + "customer", ""));
		setInvoiceCustCd(JSPUtil.getParameter(request, prefix + "invoice_cust_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setArIf(JSPUtil.getParameter(request, prefix + "ar_if", ""));
		setRtnDate(JSPUtil.getParameter(request, prefix + "rtn_date", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
		setSFrom(JSPUtil.getParameter(request, prefix + "s_from", ""));
		setActualRtnYard(JSPUtil.getParameter(request, prefix + "actual_rtn_yard", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setInvoiceCustName(JSPUtil.getParameter(request, prefix + "invoice_cust_name", ""));
		setTroDt(JSPUtil.getParameter(request, prefix + "tro_dt", ""));
		setGenAmt(JSPUtil.getParameter(request, prefix + "gen_amt", ""));
		setPendingAmt(JSPUtil.getParameter(request, prefix + "pending_amt", ""));
		setInvoiceAmt(JSPUtil.getParameter(request, prefix + "invoice_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgDel(JSPUtil.getParameter(request, prefix + "bkg_del", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setInvOfc(JSPUtil.getParameter(request, prefix + "inv_ofc", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSpcAmt(JSPUtil.getParameter(request, prefix + "spc_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setItemList(JSPUtil.getParameter(request, prefix + "item_list", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SumbyOfcDetailVO[]
	 */
	public SumbyOfcDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SumbyOfcDetailVO[]
	 */
	public SumbyOfcDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SumbyOfcDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] troCntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "tro_cntr_rtn_yd_cd", length));
			String[] exemption = (JSPUtil.getParameter(request, prefix	+ "exemption", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sTo = (JSPUtil.getParameter(request, prefix	+ "s_to", length));
			String[] invoiceUsdAmt = (JSPUtil.getParameter(request, prefix	+ "invoice_usd_amt", length));
			String[] adjustAmt = (JSPUtil.getParameter(request, prefix	+ "adjust_amt", length));
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			String[] invoiceCustCd = (JSPUtil.getParameter(request, prefix	+ "invoice_cust_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] arIf = (JSPUtil.getParameter(request, prefix	+ "ar_if", length));
			String[] rtnDate = (JSPUtil.getParameter(request, prefix	+ "rtn_date", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] sFrom = (JSPUtil.getParameter(request, prefix	+ "s_from", length));
			String[] actualRtnYard = (JSPUtil.getParameter(request, prefix	+ "actual_rtn_yard", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] invoiceCustName = (JSPUtil.getParameter(request, prefix	+ "invoice_cust_name", length));
			String[] troDt = (JSPUtil.getParameter(request, prefix	+ "tro_dt", length));
			String[] genAmt = (JSPUtil.getParameter(request, prefix	+ "gen_amt", length));
			String[] pendingAmt = (JSPUtil.getParameter(request, prefix	+ "pending_amt", length));
			String[] invoiceAmt = (JSPUtil.getParameter(request, prefix	+ "invoice_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgDel = (JSPUtil.getParameter(request, prefix	+ "bkg_del", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] invOfc = (JSPUtil.getParameter(request, prefix	+ "inv_ofc", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] spcAmt = (JSPUtil.getParameter(request, prefix	+ "spc_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] itemList = (JSPUtil.getParameter(request, prefix	+ "item_list", length));
			
			for (int i = 0; i < length; i++) {
				model = new SumbyOfcDetailVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (troCntrRtnYdCd[i] != null)
					model.setTroCntrRtnYdCd(troCntrRtnYdCd[i]);
				if (exemption[i] != null)
					model.setExemption(exemption[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sTo[i] != null)
					model.setSTo(sTo[i]);
				if (invoiceUsdAmt[i] != null)
					model.setInvoiceUsdAmt(invoiceUsdAmt[i]);
				if (adjustAmt[i] != null)
					model.setAdjustAmt(adjustAmt[i]);
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				if (invoiceCustCd[i] != null)
					model.setInvoiceCustCd(invoiceCustCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arIf[i] != null)
					model.setArIf(arIf[i]);
				if (rtnDate[i] != null)
					model.setRtnDate(rtnDate[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (sFrom[i] != null)
					model.setSFrom(sFrom[i]);
				if (actualRtnYard[i] != null)
					model.setActualRtnYard(actualRtnYard[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invoiceCustName[i] != null)
					model.setInvoiceCustName(invoiceCustName[i]);
				if (troDt[i] != null)
					model.setTroDt(troDt[i]);
				if (genAmt[i] != null)
					model.setGenAmt(genAmt[i]);
				if (pendingAmt[i] != null)
					model.setPendingAmt(pendingAmt[i]);
				if (invoiceAmt[i] != null)
					model.setInvoiceAmt(invoiceAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgDel[i] != null)
					model.setBkgDel(bkgDel[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (invOfc[i] != null)
					model.setInvOfc(invOfc[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (spcAmt[i] != null)
					model.setSpcAmt(spcAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (itemList[i] != null)
					model.setItemList(itemList[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSumbyOfcDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SumbyOfcDetailVO[]
	 */
	public SumbyOfcDetailVO[] getSumbyOfcDetailVOs(){
		SumbyOfcDetailVO[] vos = (SumbyOfcDetailVO[])models.toArray(new SumbyOfcDetailVO[models.size()]);
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
		this.genTrfAmt = this.genTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCntrRtnYdCd = this.troCntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exemption = this.exemption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTo = this.sTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceUsdAmt = this.invoiceUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjustAmt = this.adjustAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customer = this.customer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceCustCd = this.invoiceCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIf = this.arIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDate = this.rtnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFrom = this.sFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualRtnYard = this.actualRtnYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceCustName = this.invoiceCustName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDt = this.troDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genAmt = this.genAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingAmt = this.pendingAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceAmt = this.invoiceAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDel = this.bkgDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfc = this.invOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcAmt = this.spcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemList = this.itemList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
