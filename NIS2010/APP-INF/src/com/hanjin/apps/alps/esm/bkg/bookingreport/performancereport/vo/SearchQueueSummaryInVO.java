/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchQueueSummaryInVO.java
*@FileTitle : SearchQueueSummaryInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.07 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQueueSummaryInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQueueSummaryInVO> models = new ArrayList<SearchQueueSummaryInVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String svrCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String srKndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String splitOnlyFlg = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String returnTo = null;
	/* Column Info */
	private String duraToDt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String curQueue = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String duraFromDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String pendingOnly = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String qa = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String input = null;
	/* Column Info */
	private String queueStatus = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String setSlctFlg = null;
	/* Column Info */
	private String prtCd = null;
	/* Column Info */
	private String dpcsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchQueueSummaryInVO() {}

	public SearchQueueSummaryInVO(String ibflag, String pagerows, String bkgCustTpCd, String bkgNo, String bkgOfcCd, String currPage, String curQueue, String custCntCd, String custNm, String custSeq, String duraFromDt, String duraToDt, String fax, String input, String ofcCd, String pendingOnly, String podCd, String polCd, String prtCd, String dpcsOfcCd, String qa, String queueStatus, String rate, String returnTo, String rgnCd, String setSlctFlg, String slanCd, String splitOnlyFlg, String srcCd, String srepCd, String srAmdTpCd, String srKndCd, String sts, String svrCd, String usrId, String vvdCd) {
		this.rgnCd = rgnCd;
		this.custNm = custNm;
		this.svrCd = svrCd;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.srKndCd = srKndCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.splitOnlyFlg = splitOnlyFlg;
		this.currPage = currPage;
		this.rate = rate;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.returnTo = returnTo;
		this.duraToDt = duraToDt;
		this.srAmdTpCd = srAmdTpCd;
		this.curQueue = curQueue;
		this.bkgCustTpCd = bkgCustTpCd;
		this.duraFromDt = duraFromDt;
		this.custCntCd = custCntCd;
		this.bkgOfcCd = bkgOfcCd;
		this.srcCd = srcCd;
		this.fax = fax;
		this.pendingOnly = pendingOnly;
		this.custSeq = custSeq;
		this.qa = qa;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.input = input;
		this.queueStatus = queueStatus;
		this.slanCd = slanCd;
		this.sts = sts;
		this.setSlctFlg = setSlctFlg;
		this.prtCd = prtCd;
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("svr_cd", getSvrCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("split_only_flg", getSplitOnlyFlg());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("return_to", getReturnTo());
		this.hashColumns.put("dura_to_dt", getDuraToDt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("cur_queue", getCurQueue());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("dura_from_dt", getDuraFromDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("pending_only", getPendingOnly());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("qa", getQa());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("input", getInput());
		this.hashColumns.put("queue_status", getQueueStatus());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("set_slct_flg", getSetSlctFlg());
		this.hashColumns.put("prt_cd", getPrtCd());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("svr_cd", "svrCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("split_only_flg", "splitOnlyFlg");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("return_to", "returnTo");
		this.hashFields.put("dura_to_dt", "duraToDt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("cur_queue", "curQueue");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("dura_from_dt", "duraFromDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("pending_only", "pendingOnly");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("qa", "qa");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("input", "input");
		this.hashFields.put("queue_status", "queueStatus");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("set_slct_flg", "setSlctFlg");
		this.hashFields.put("prt_cd", "prtCd");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
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
	 * @return svrCd
	 */
	public String getSvrCd() {
		return this.svrCd;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return splitOnlyFlg
	 */
	public String getSplitOnlyFlg() {
		return this.splitOnlyFlg;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return returnTo
	 */
	public String getReturnTo() {
		return this.returnTo;
	}
	
	/**
	 * Column Info
	 * @return duraToDt
	 */
	public String getDuraToDt() {
		return this.duraToDt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return curQueue
	 */
	public String getCurQueue() {
		return this.curQueue;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return duraFromDt
	 */
	public String getDuraFromDt() {
		return this.duraFromDt;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return pendingOnly
	 */
	public String getPendingOnly() {
		return this.pendingOnly;
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
	 * @return qa
	 */
	public String getQa() {
		return this.qa;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return input
	 */
	public String getInput() {
		return this.input;
	}
	
	/**
	 * Column Info
	 * @return queueStatus
	 */
	public String getQueueStatus() {
		return this.queueStatus;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return setSlctFlg
	 */
	public String getSetSlctFlg() {
		return this.setSlctFlg;
	}
	
	/**
	 * Column Info
	 * @return prtCd
	 */
	public String getPrtCd() {
		return this.prtCd;
	}
	
	/**
	 * Column Info
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
	}
	

	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
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
	 * @param svrCd
	 */
	public void setSvrCd(String svrCd) {
		this.svrCd = svrCd;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param splitOnlyFlg
	 */
	public void setSplitOnlyFlg(String splitOnlyFlg) {
		this.splitOnlyFlg = splitOnlyFlg;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param returnTo
	 */
	public void setReturnTo(String returnTo) {
		this.returnTo = returnTo;
	}
	
	/**
	 * Column Info
	 * @param duraToDt
	 */
	public void setDuraToDt(String duraToDt) {
		this.duraToDt = duraToDt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param curQueue
	 */
	public void setCurQueue(String curQueue) {
		this.curQueue = curQueue;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param duraFromDt
	 */
	public void setDuraFromDt(String duraFromDt) {
		this.duraFromDt = duraFromDt;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param pendingOnly
	 */
	public void setPendingOnly(String pendingOnly) {
		this.pendingOnly = pendingOnly;
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
	 * @param qa
	 */
	public void setQa(String qa) {
		this.qa = qa;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param input
	 */
	public void setInput(String input) {
		this.input = input;
	}
	
	/**
	 * Column Info
	 * @param queueStatus
	 */
	public void setQueueStatus(String queueStatus) {
		this.queueStatus = queueStatus;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param setSlctFlg
	 */
	public void setSetSlctFlg(String setSlctFlg) {
		this.setSlctFlg = setSlctFlg;
	}
	
	/**
	 * Column Info
	 * @param prtCd
	 */
	public void setPrtCd(String prtCd) {
		this.prtCd = prtCd;
	}
	
	/**
	 * Column Info
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
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
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSvrCd(JSPUtil.getParameter(request, prefix + "svr_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSplitOnlyFlg(JSPUtil.getParameter(request, prefix + "split_only_flg", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setReturnTo(JSPUtil.getParameter(request, prefix + "return_to", ""));
		setDuraToDt(JSPUtil.getParameter(request, prefix + "dura_to_dt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setCurQueue(JSPUtil.getParameter(request, prefix + "cur_queue", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setDuraFromDt(JSPUtil.getParameter(request, prefix + "dura_from_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setPendingOnly(JSPUtil.getParameter(request, prefix + "pending_only", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setQa(JSPUtil.getParameter(request, prefix + "qa", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInput(JSPUtil.getParameter(request, prefix + "input", ""));
		setQueueStatus(JSPUtil.getParameter(request, prefix + "queue_status", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setSetSlctFlg(JSPUtil.getParameter(request, prefix + "set_slct_flg", ""));
		setPrtCd(JSPUtil.getParameter(request, prefix + "prt_cd", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, prefix + "dpcs_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQueueSummaryInVO[]
	 */
	public SearchQueueSummaryInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQueueSummaryInVO[]
	 */
	public SearchQueueSummaryInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQueueSummaryInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] svrCd = (JSPUtil.getParameter(request, prefix	+ "svr_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] splitOnlyFlg = (JSPUtil.getParameter(request, prefix	+ "split_only_flg", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] returnTo = (JSPUtil.getParameter(request, prefix	+ "return_to", length));
			String[] duraToDt = (JSPUtil.getParameter(request, prefix	+ "dura_to_dt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] curQueue = (JSPUtil.getParameter(request, prefix	+ "cur_queue", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] duraFromDt = (JSPUtil.getParameter(request, prefix	+ "dura_from_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] pendingOnly = (JSPUtil.getParameter(request, prefix	+ "pending_only", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] qa = (JSPUtil.getParameter(request, prefix	+ "qa", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] input = (JSPUtil.getParameter(request, prefix	+ "input", length));
			String[] queueStatus = (JSPUtil.getParameter(request, prefix	+ "queue_status", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] setSlctFlg = (JSPUtil.getParameter(request, prefix	+ "set_slct_flg", length));
			String[] prtCd = (JSPUtil.getParameter(request, prefix	+ "prt_cd", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQueueSummaryInVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (svrCd[i] != null)
					model.setSvrCd(svrCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (splitOnlyFlg[i] != null)
					model.setSplitOnlyFlg(splitOnlyFlg[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (returnTo[i] != null)
					model.setReturnTo(returnTo[i]);
				if (duraToDt[i] != null)
					model.setDuraToDt(duraToDt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (curQueue[i] != null)
					model.setCurQueue(curQueue[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (duraFromDt[i] != null)
					model.setDuraFromDt(duraFromDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (pendingOnly[i] != null)
					model.setPendingOnly(pendingOnly[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (qa[i] != null)
					model.setQa(qa[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (input[i] != null)
					model.setInput(input[i]);
				if (queueStatus[i] != null)
					model.setQueueStatus(queueStatus[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (setSlctFlg[i] != null)
					model.setSetSlctFlg(setSlctFlg[i]);
				if (prtCd[i] != null)
					model.setPrtCd(prtCd[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQueueSummaryInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQueueSummaryInVO[]
	 */
	public SearchQueueSummaryInVO[] getSearchQueueSummaryInVOs(){
		SearchQueueSummaryInVO[] vos = (SearchQueueSummaryInVO[])models.toArray(new SearchQueueSummaryInVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrCd = this.svrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitOnlyFlg = this.splitOnlyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnTo = this.returnTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraToDt = this.duraToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curQueue = this.curQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraFromDt = this.duraFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingOnly = this.pendingOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qa = this.qa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.input = this.input .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueStatus = this.queueStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setSlctFlg = this.setSlctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtCd = this.prtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
