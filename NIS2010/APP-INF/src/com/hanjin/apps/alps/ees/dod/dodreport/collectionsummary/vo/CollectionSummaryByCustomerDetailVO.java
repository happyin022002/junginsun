/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryByCustomerDetailVO.java
*@FileTitle : CollectionSummaryByCustomerDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.05.25 홍성필 
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

public class CollectionSummaryByCustomerDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CollectionSummaryByCustomerDetailVO> models = new ArrayList<CollectionSummaryByCustomerDetailVO>();
	
	/* Column Info */
	private String to = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String genTrfAmt = null;
	/* Column Info */
	private String invCustCd = null;
	/* Column Info */
	private String exemption = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String custFlg = null;
	/* Column Info */
	private String tpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtnYd = null;
	/* Column Info */
	private String penAmt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invCustNm = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String contractOfc = null;
	/* Column Info */
	private String troDt = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String genAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String spclTrfAmt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rtnDt = null;
	/* Column Info */
	private String spcAmt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String itemList = null;
	/* Column Info */
	private String aRtnYd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String arIf = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CollectionSummaryByCustomerDetailVO() {}

	public CollectionSummaryByCustomerDetailVO(String ibflag, String pagerows, String ofcCd, String cntrNo, String tpszCd, String rtnYd, String aRtnYd, String rtnDt, String troDt, String bkgNo, String porCd, String polCd, String podCd, String delCd, String scNo, String rfaNo, String custCntCd, String custSeq, String custCd, String custNm, String contractOfc, String invCustCd, String invCustNm, String currCd, String genTrfAmt, String spclTrfAmt, String adjAmt, String invAmt, String invUsdAmt, String spcAmt, String genAmt, String exemption, String arIfDt, String creUsrId, String invOfcCd, String penAmt, String period, String from, String to, String itemList, String custFlg, String custType, String arIf) {
		this.to = to;
		this.porCd = porCd;
		this.genTrfAmt = genTrfAmt;
		this.invCustCd = invCustCd;
		this.exemption = exemption;
		this.currCd = currCd;
		this.from = from;
		this.custFlg = custFlg;
		this.tpszCd = tpszCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.rtnYd = rtnYd;
		this.penAmt = penAmt;
		this.scNo = scNo;
		this.arIfDt = arIfDt;
		this.invAmt = invAmt;
		this.invCustNm = invCustNm;
		this.invOfcCd = invOfcCd;
		this.custCntCd = custCntCd;
		this.custType = custType;
		this.contractOfc = contractOfc;
		this.troDt = troDt;
		this.invUsdAmt = invUsdAmt;
		this.genAmt = genAmt;
		this.delCd = delCd;
		this.adjAmt = adjAmt;
		this.spclTrfAmt = spclTrfAmt;
		this.period = period;
		this.custSeq = custSeq;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.rtnDt = rtnDt;
		this.spcAmt = spcAmt;
		this.cntrNo = cntrNo;
		this.custCd = custCd;
		this.itemList = itemList;
		this.aRtnYd = aRtnYd;
		this.custNm = custNm;
		this.arIf = arIf;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to", getTo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("gen_trf_amt", getGenTrfAmt());
		this.hashColumns.put("inv_cust_cd", getInvCustCd());
		this.hashColumns.put("exemption", getExemption());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("cust_flg", getCustFlg());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rtn_yd", getRtnYd());
		this.hashColumns.put("pen_amt", getPenAmt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_cust_nm", getInvCustNm());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("contract_ofc", getContractOfc());
		this.hashColumns.put("tro_dt", getTroDt());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("gen_amt", getGenAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("spcl_trf_amt", getSpclTrfAmt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rtn_dt", getRtnDt());
		this.hashColumns.put("spc_amt", getSpcAmt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("item_list", getItemList());
		this.hashColumns.put("a_rtn_yd", getARtnYd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ar_if", getArIf());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to", "to");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("gen_trf_amt", "genTrfAmt");
		this.hashFields.put("inv_cust_cd", "invCustCd");
		this.hashFields.put("exemption", "exemption");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("from", "from");
		this.hashFields.put("cust_flg", "custFlg");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rtn_yd", "rtnYd");
		this.hashFields.put("pen_amt", "penAmt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_cust_nm", "invCustNm");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("contract_ofc", "contractOfc");
		this.hashFields.put("tro_dt", "troDt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("gen_amt", "genAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("spcl_trf_amt", "spclTrfAmt");
		this.hashFields.put("period", "period");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rtn_dt", "rtnDt");
		this.hashFields.put("spc_amt", "spcAmt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("item_list", "itemList");
		this.hashFields.put("a_rtn_yd", "aRtnYd");
		this.hashFields.put("cust_nm", "custNm");
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
	 * @return invCustCd
	 */
	public String getInvCustCd() {
		return this.invCustCd;
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
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @return rtnYd
	 */
	public String getRtnYd() {
		return this.rtnYd;
	}
	
	/**
	 * Column Info
	 * @return penAmt
	 */
	public String getPenAmt() {
		return this.penAmt;
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
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
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
	 * @return invCustNm
	 */
	public String getInvCustNm() {
		return this.invCustNm;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * Column Info
	 * @return contractOfc
	 */
	public String getContractOfc() {
		return this.contractOfc;
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
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return rtnDt
	 */
	public String getRtnDt() {
		return this.rtnDt;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return aRtnYd
	 */
	public String getARtnYd() {
		return this.aRtnYd;
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
	 * @param invCustCd
	 */
	public void setInvCustCd(String invCustCd) {
		this.invCustCd = invCustCd;
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
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
	 * @param rtnYd
	 */
	public void setRtnYd(String rtnYd) {
		this.rtnYd = rtnYd;
	}
	
	/**
	 * Column Info
	 * @param penAmt
	 */
	public void setPenAmt(String penAmt) {
		this.penAmt = penAmt;
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
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
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
	 * @param invCustNm
	 */
	public void setInvCustNm(String invCustNm) {
		this.invCustNm = invCustNm;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	/**
	 * Column Info
	 * @param contractOfc
	 */
	public void setContractOfc(String contractOfc) {
		this.contractOfc = contractOfc;
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
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param rtnDt
	 */
	public void setRtnDt(String rtnDt) {
		this.rtnDt = rtnDt;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param itemList
	 */
	public void setItemList(String itemList) {
		this.itemList = itemList;
	}
	
	/**
	 * Column Info
	 * @param aRtnYd
	 */
	public void setARtnYd(String aRtnYd) {
		this.aRtnYd = aRtnYd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setGenTrfAmt(JSPUtil.getParameter(request, prefix + "gen_trf_amt", ""));
		setInvCustCd(JSPUtil.getParameter(request, prefix + "inv_cust_cd", ""));
		setExemption(JSPUtil.getParameter(request, prefix + "exemption", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFrom(JSPUtil.getParameter(request, prefix + "from", ""));
		setCustFlg(JSPUtil.getParameter(request, prefix + "cust_flg", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtnYd(JSPUtil.getParameter(request, prefix + "rtn_yd", ""));
		setPenAmt(JSPUtil.getParameter(request, prefix + "pen_amt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvCustNm(JSPUtil.getParameter(request, prefix + "inv_cust_nm", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustType(JSPUtil.getParameter(request, prefix + "cust_type", ""));
		setContractOfc(JSPUtil.getParameter(request, prefix + "contract_ofc", ""));
		setTroDt(JSPUtil.getParameter(request, prefix + "tro_dt", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setGenAmt(JSPUtil.getParameter(request, prefix + "gen_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setSpclTrfAmt(JSPUtil.getParameter(request, prefix + "spcl_trf_amt", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRtnDt(JSPUtil.getParameter(request, prefix + "rtn_dt", ""));
		setSpcAmt(JSPUtil.getParameter(request, prefix + "spc_amt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setItemList(JSPUtil.getParameter(request, prefix + "item_list", ""));
		setARtnYd(JSPUtil.getParameter(request, prefix + "a_rtn_yd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setArIf(JSPUtil.getParameter(request, prefix + "ar_if", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CollectionSummaryByCustomerDetailVO[]
	 */
	public CollectionSummaryByCustomerDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CollectionSummaryByCustomerDetailVO[]
	 */
	public CollectionSummaryByCustomerDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CollectionSummaryByCustomerDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] to = (JSPUtil.getParameter(request, prefix	+ "to", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] genTrfAmt = (JSPUtil.getParameter(request, prefix	+ "gen_trf_amt", length));
			String[] invCustCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cd", length));
			String[] exemption = (JSPUtil.getParameter(request, prefix	+ "exemption", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from", length));
			String[] custFlg = (JSPUtil.getParameter(request, prefix	+ "cust_flg", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtnYd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd", length));
			String[] penAmt = (JSPUtil.getParameter(request, prefix	+ "pen_amt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invCustNm = (JSPUtil.getParameter(request, prefix	+ "inv_cust_nm", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			String[] contractOfc = (JSPUtil.getParameter(request, prefix	+ "contract_ofc", length));
			String[] troDt = (JSPUtil.getParameter(request, prefix	+ "tro_dt", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] genAmt = (JSPUtil.getParameter(request, prefix	+ "gen_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] spclTrfAmt = (JSPUtil.getParameter(request, prefix	+ "spcl_trf_amt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rtnDt = (JSPUtil.getParameter(request, prefix	+ "rtn_dt", length));
			String[] spcAmt = (JSPUtil.getParameter(request, prefix	+ "spc_amt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] itemList = (JSPUtil.getParameter(request, prefix	+ "item_list", length));
			String[] aRtnYd = (JSPUtil.getParameter(request, prefix	+ "a_rtn_yd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] arIf = (JSPUtil.getParameter(request, prefix	+ "ar_if", length));
			
			for (int i = 0; i < length; i++) {
				model = new CollectionSummaryByCustomerDetailVO();
				if (to[i] != null)
					model.setTo(to[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (genTrfAmt[i] != null)
					model.setGenTrfAmt(genTrfAmt[i]);
				if (invCustCd[i] != null)
					model.setInvCustCd(invCustCd[i]);
				if (exemption[i] != null)
					model.setExemption(exemption[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (custFlg[i] != null)
					model.setCustFlg(custFlg[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtnYd[i] != null)
					model.setRtnYd(rtnYd[i]);
				if (penAmt[i] != null)
					model.setPenAmt(penAmt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invCustNm[i] != null)
					model.setInvCustNm(invCustNm[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (contractOfc[i] != null)
					model.setContractOfc(contractOfc[i]);
				if (troDt[i] != null)
					model.setTroDt(troDt[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (genAmt[i] != null)
					model.setGenAmt(genAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (spclTrfAmt[i] != null)
					model.setSpclTrfAmt(spclTrfAmt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rtnDt[i] != null)
					model.setRtnDt(rtnDt[i]);
				if (spcAmt[i] != null)
					model.setSpcAmt(spcAmt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (itemList[i] != null)
					model.setItemList(itemList[i]);
				if (aRtnYd[i] != null)
					model.setARtnYd(aRtnYd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (arIf[i] != null)
					model.setArIf(arIf[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCollectionSummaryByCustomerDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CollectionSummaryByCustomerDetailVO[]
	 */
	public CollectionSummaryByCustomerDetailVO[] getCollectionSummaryByCustomerDetailVOs(){
		CollectionSummaryByCustomerDetailVO[] vos = (CollectionSummaryByCustomerDetailVO[])models.toArray(new CollectionSummaryByCustomerDetailVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genTrfAmt = this.genTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCd = this.invCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exemption = this.exemption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFlg = this.custFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYd = this.rtnYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.penAmt = this.penAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustNm = this.invCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractOfc = this.contractOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDt = this.troDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genAmt = this.genAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclTrfAmt = this.spclTrfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDt = this.rtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcAmt = this.spcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemList = this.itemList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aRtnYd = this.aRtnYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIf = this.arIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
