/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableInvoiceVO.java
*@FileTitle : ReceivableInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.04 장준우
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReceivableInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ReceivableInvoiceVO> models = new ArrayList<ReceivableInvoiceVO>();

	/* Column Info */
	private String fmChgAmt = null;
	/* Column Info */
	private String toCurrCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String lseRcvChgTpCd = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String fmCurrCd = null;
	/* Column Info */
	private String toCurrRt = null;
	/* Column Info */
	private String fmCurrRt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String bilDys = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String chgRtAmt = null;
	/* Column Info */
	private String rcvRntlSeq = null;
	/* Column Info */
	private String toChgAmt = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String srcIfSeq = null;
	/* Column Info */
	private String srcIfDt = null;
	/* Column Info */
	private String invIsuDt = null;
	/* Column Info */
	private String invDueDt = null;
	/* Column Info */
	private String toTaxAmt = null;
	/* Column Info */
	private String toTtlAmt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String loclTaxFlg = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String cfmIfFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReceivableInvoiceVO() {}

	public ReceivableInvoiceVO(String ibflag, String cfmFlg, String cfmOfcCd, String cfmIfFlg, String custCntCd, String custSeq, String loclTaxFlg, String toTaxAmt, String toTtlAmt, String pagerows, String invDueDt, String invIsuDt, String srcIfSeq, String srcIfDt, String agmtNo, String agmtCtyCd, String agmtSeq, String rcvRntlSeq, String lstmCd, String cntrTpszCd, String lseRcvChgTpCd, String cntrCnt, String costAmt, String bilDys, String chgRtAmt, String fmCurrCd, String fmCurrRt, String toCurrCd, String toCurrRt, String fmChgAmt, String toChgAmt, String costYrmon, String ofcCd, String creUsrId, String updUsrId, String invNo, String invAmt) {
		this.fmChgAmt = fmChgAmt;
		this.toCurrCd = toCurrCd;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.lseRcvChgTpCd = lseRcvChgTpCd;
		this.cntrCnt = cntrCnt;
		this.fmCurrCd = fmCurrCd;
		this.toCurrRt = toCurrRt;
		this.fmCurrRt = fmCurrRt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costAmt = costAmt;
		this.bilDys = bilDys;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.chgRtAmt = chgRtAmt;
		this.rcvRntlSeq = rcvRntlSeq;
		this.toChgAmt = toChgAmt;
		this.costYrmon = costYrmon;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.invNo = invNo;
		this.invAmt = invAmt;
		this.srcIfSeq = srcIfSeq;
		this.srcIfDt = srcIfDt;
		this.invIsuDt = invIsuDt;
		this.invDueDt = invDueDt;
		this.toTaxAmt = toTaxAmt;
		this.toTtlAmt = toTtlAmt;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.loclTaxFlg = loclTaxFlg;
		this.cfmFlg = cfmFlg;
		this.cfmOfcCd = cfmOfcCd;
		this.cfmIfFlg = cfmIfFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_chg_amt", getFmChgAmt());
		this.hashColumns.put("to_curr_cd", getToCurrCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("lse_rcv_chg_tp_cd", getLseRcvChgTpCd());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("fm_curr_cd", getFmCurrCd());
		this.hashColumns.put("to_curr_rt", getToCurrRt());
		this.hashColumns.put("fm_curr_rt", getFmCurrRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("bil_dys", getBilDys());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("chg_rt_amt", getChgRtAmt());
		this.hashColumns.put("rcv_rntl_seq", getRcvRntlSeq());
		this.hashColumns.put("to_chg_amt", getToChgAmt());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("src_if_seq", getSrcIfSeq());
		this.hashColumns.put("src_if_dt", getSrcIfDt());
		this.hashColumns.put("inv_isu_dt", getInvIsuDt());
		this.hashColumns.put("inv_due_dt", getInvDueDt());
		this.hashColumns.put("to_tax_amt", getToTaxAmt());
		this.hashColumns.put("to_ttl_amt", getToTtlAmt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("locl_tax_flg", getLoclTaxFlg());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cfm_if_flg", getCfmIfFlg());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_chg_amt", "fmChgAmt");
		this.hashFields.put("to_curr_cd", "toCurrCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("lse_rcv_chg_tp_cd", "lseRcvChgTpCd");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("fm_curr_cd", "fmCurrCd");
		this.hashFields.put("to_curr_rt", "toCurrRt");
		this.hashFields.put("fm_curr_rt", "fmCurrRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("bil_dys", "bilDys");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("chg_rt_amt", "chgRtAmt");
		this.hashFields.put("rcv_rntl_seq", "rcvRntlSeq");
		this.hashFields.put("to_chg_amt", "toChgAmt");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("inv_isu_dt", "invIsuDt");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("to_tax_amt", "toTaxAmt");
		this.hashFields.put("to_ttl_amt", "toTtlAmt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("locl_tax_flg", "loclTaxFlg");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cfm_if_flg", "cfmIfFlg");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return fmChgAmt
	 */
	public String getFmChgAmt() {
		return this.fmChgAmt;
	}

	/**
	 * Column Info
	 * @return toCurrCd
	 */
	public String getToCurrCd() {
		return this.toCurrCd;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}

	/**
	 * Column Info
	 * @return lseRcvChgTpCd
	 */
	public String getLseRcvChgTpCd() {
		return this.lseRcvChgTpCd;
	}

	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}

	/**
	 * Column Info
	 * @return fmCurrCd
	 */
	public String getFmCurrCd() {
		return this.fmCurrCd;
	}

	/**
	 * Column Info
	 * @return toCurrRt
	 */
	public String getToCurrRt() {
		return this.toCurrRt;
	}

	/**
	 * Column Info
	 * @return fmCurrRt
	 */
	public String getFmCurrRt() {
		return this.fmCurrRt;
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
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}

	/**
	 * Column Info
	 * @return bilDys
	 */
	public String getBilDys() {
		return this.bilDys;
	}

	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * @return chgRtAmt
	 */
	public String getChgRtAmt() {
		return this.chgRtAmt;
	}

	/**
	 * Column Info
	 * @return rcvRntlSeq
	 */
	public String getRcvRntlSeq() {
		return this.rcvRntlSeq;
	}

	/**
	 * Column Info
	 * @return toChgAmt
	 */
	public String getToChgAmt() {
		return this.toChgAmt;
	}


	/**
	 * Column Info
	 * @param fmChgAmt
	 */
	public void setFmChgAmt(String fmChgAmt) {
		this.fmChgAmt = fmChgAmt;
	}

	/**
	 * Column Info
	 * @param toCurrCd
	 */
	public void setToCurrCd(String toCurrCd) {
		this.toCurrCd = toCurrCd;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**
	 * Column Info
	 * @param lseRcvChgTpCd
	 */
	public void setLseRcvChgTpCd(String lseRcvChgTpCd) {
		this.lseRcvChgTpCd = lseRcvChgTpCd;
	}

	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}

	/**
	 * Column Info
	 * @param fmCurrCd
	 */
	public void setFmCurrCd(String fmCurrCd) {
		this.fmCurrCd = fmCurrCd;
	}

	/**
	 * Column Info
	 * @param toCurrRt
	 */
	public void setToCurrRt(String toCurrRt) {
		this.toCurrRt = toCurrRt;
	}

	/**
	 * Column Info
	 * @param fmCurrRt
	 */
	public void setFmCurrRt(String fmCurrRt) {
		this.fmCurrRt = fmCurrRt;
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
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}

	/**
	 * Column Info
	 * @param bilDys
	 */
	public void setBilDys(String bilDys) {
		this.bilDys = bilDys;
	}

	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * @param chgRtAmt
	 */
	public void setChgRtAmt(String chgRtAmt) {
		this.chgRtAmt = chgRtAmt;
	}

	/**
	 * Column Info
	 * @param rcvRntlSeq
	 */
	public void setRcvRntlSeq(String rcvRntlSeq) {
		this.rcvRntlSeq = rcvRntlSeq;
	}

	/**
	 * Column Info
	 * @param toChgAmt
	 */
	public void setToChgAmt(String toChgAmt) {
		this.toChgAmt = toChgAmt;
	}

	/**
	 * @return the costYrmon
	 */
	public String getCostYrmon() {
		return costYrmon;
	}

	/**
	 * @param costYrmon the costYrmon to set
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNO to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the invAmt
	 */
	public String getInvAmt() {
		return invAmt;
	}

	/**
	 * @param invAmt the invAmt to set
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}

	/**
	 * @return the srcIfSeq
	 */
	public String getSrcIfSeq() {
		return srcIfSeq;
	}

	/**
	 * @param srcIfSeq the srcIfSeq to set
	 */
	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}

	/**
	 * @return the srcIfDt
	 */
	public String getSrcIfDt() {
		return srcIfDt;
	}

	/**
	 * @param srcIfDt the srcIfDt to set
	 */
	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}

	/**
	 * @return the invIsuDt
	 */
	public String getInvIsuDt() {
		return invIsuDt;
	}

	/**
	 * @param invIsuDt the invIsuDt to set
	 */
	public void setInvIsuDt(String invIsuDt) {
		this.invIsuDt = invIsuDt;
	}

	/**
	 * @return the invDueDt
	 */
	public String getInvDueDt() {
		return invDueDt;
	}

	/**
	 * @param invDueDt the invDueDt to set
	 */
	public void setInvDueDt(String invDueDt) {
		this.invDueDt = invDueDt;
	}

	/**
	 * @return the toTaxAmt
	 */
	public String getToTaxAmt() {
		return toTaxAmt;
	}

	/**
	 * @param toTaxAmt the toTaxAmt to set
	 */
	public void setToTaxAmt(String toTaxAmt) {
		this.toTaxAmt = toTaxAmt;
	}

	/**
	 * @return the toTtlAmt
	 */
	public String getToTtlAmt() {
		return toTtlAmt;
	}

	/**
	 * @param toTtlAmt the toTtlAmt to set
	 */
	public void setToTtlAmt(String toTtlAmt) {
		this.toTtlAmt = toTtlAmt;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the loclTaxFlg
	 */
	public String getLoclTaxFlg() {
		return loclTaxFlg;
	}

	/**
	 * @param loclTaxFlg the loclTaxFlg to set
	 */
	public void setLoclTaxFlg(String loclTaxFlg) {
		this.loclTaxFlg = loclTaxFlg;
	}

	/**
	 * @return the cfmFlg
	 */
	public String getCfmFlg() {
		return cfmFlg;
	}

	/**
	 * @param cfmFlg the cfmFlg to set
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}

	/**
	 * @return the cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return cfmOfcCd;
	}

	/**
	 * @param cfmOfcCd the cfmOfcCd to set
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}

	/**
	 * @return the cfmIfFlg
	 */
	public String getCfmIfFlg() {
		return cfmIfFlg;
	}

	/**
	 * @param cfmIfFlg the cfmIfFlg to set
	 */
	public void setCfmIfFlg(String cfmIfFlg) {
		this.cfmIfFlg = cfmIfFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmChgAmt(JSPUtil.getParameter(request, "fm_chg_amt", ""));
		setToCurrCd(JSPUtil.getParameter(request, "to_curr_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setLseRcvChgTpCd(JSPUtil.getParameter(request, "lse_rcv_chg_tp_cd", ""));
		setCntrCnt(JSPUtil.getParameter(request, "cntr_cnt", ""));
		setFmCurrCd(JSPUtil.getParameter(request, "fm_curr_cd", ""));
		setToCurrRt(JSPUtil.getParameter(request, "to_curr_rt", "").replaceAll(",", ""));
		setFmCurrRt(JSPUtil.getParameter(request, "fm_curr_rt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostAmt(JSPUtil.getParameter(request, "cost_amt", ""));
		setBilDys(JSPUtil.getParameter(request, "bil_dys", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setChgRtAmt(JSPUtil.getParameter(request, "chg_rt_amt", ""));
		setRcvRntlSeq(JSPUtil.getParameter(request, "rcv_rntl_seq", ""));
		setToChgAmt(JSPUtil.getParameter(request, "to_chg_amt", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", "").replaceAll("-", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setSrcIfSeq(JSPUtil.getParameter(request, "src_if_seq", ""));
		setSrcIfDt(JSPUtil.getParameter(request, "src_if_dt", "").replaceAll("-", ""));
		setInvIsuDt(JSPUtil.getParameter(request, "inv_isu_dt", "").replaceAll("-", ""));
		setInvDueDt(JSPUtil.getParameter(request, "inv_due_dt", "").replaceAll("-", ""));
		setToTaxAmt(JSPUtil.getParameter(request, "to_tax_amt", ""));
		setToTtlAmt(JSPUtil.getParameter(request, "to_ttl_amt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setLoclTaxFlg(JSPUtil.getParameter(request, "locl_tax_flg", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, "cfm_ofc_cd", ""));
		setCfmIfFlg(JSPUtil.getParameter(request, "cfm_if_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceivableInvoiceVO[]
	 */
	public ReceivableInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceivableInvoiceVO[]
	 */
	public ReceivableInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceivableInvoiceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] fmChgAmt = (JSPUtil.getParameter(request, prefix	+ "fm_chg_amt", length));
			String[] toCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_curr_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] lseRcvChgTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_rcv_chg_tp_cd", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] fmCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_curr_cd", length));
			String[] toCurrRt = (JSPUtil.getParameter(request, prefix	+ "to_curr_rt", length));
			String[] fmCurrRt = (JSPUtil.getParameter(request, prefix	+ "fm_curr_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] bilDys = (JSPUtil.getParameter(request, prefix	+ "bil_dys", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] chgRtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_rt_amt", length));
			String[] rcvRntlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_rntl_seq", length));
			String[] toChgAmt = (JSPUtil.getParameter(request, prefix	+ "to_chg_amt", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] srcIfSeq = (JSPUtil.getParameter(request, prefix	+ "src_if_seq", length));
			String[] srcIfDt = (JSPUtil.getParameter(request, prefix	+ "src_if_dt", length));
			String[] invIsuDt = (JSPUtil.getParameter(request, prefix	+ "inv_isu_dt", length));
			String[] invDueDt = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt", length));
			String[] toTaxAmt = (JSPUtil.getParameter(request, prefix	+ "to_tax_amt", length));
			String[] toTtlAmt = (JSPUtil.getParameter(request, prefix	+ "to_ttl_amt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] loclTaxFlg = (JSPUtil.getParameter(request, prefix	+ "locl_tax_flg", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] cfmIfFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_if_flg", length));

			for (int i = 0; i < length; i++) {
				model = new ReceivableInvoiceVO();
				if (fmChgAmt[i] != null)
					model.setFmChgAmt(fmChgAmt[i]);
				if (toCurrCd[i] != null)
					model.setToCurrCd(toCurrCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (lseRcvChgTpCd[i] != null)
					model.setLseRcvChgTpCd(lseRcvChgTpCd[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (fmCurrCd[i] != null)
					model.setFmCurrCd(fmCurrCd[i]);
				if (toCurrRt[i] != null)
					model.setToCurrRt(toCurrRt[i]);
				if (fmCurrRt[i] != null)
					model.setFmCurrRt(fmCurrRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (bilDys[i] != null)
					model.setBilDys(bilDys[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (chgRtAmt[i] != null)
					model.setChgRtAmt(chgRtAmt[i]);
				if (rcvRntlSeq[i] != null)
					model.setRcvRntlSeq(rcvRntlSeq[i]);
				if (toChgAmt[i] != null)
					model.setToChgAmt(toChgAmt[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (srcIfSeq[i] != null)
					model.setSrcIfSeq(srcIfSeq[i]);
				if (srcIfDt[i] != null)
					model.setSrcIfDt(srcIfDt[i]);
				if (invIsuDt[i] != null)
					model.setInvIsuDt(invIsuDt[i]);
				if (invDueDt[i] != null)
					model.setInvDueDt(invDueDt[i]);
				if (toTaxAmt[i] != null)
					model.setToTaxAmt(toTaxAmt[i]);
				if (toTtlAmt[i] != null)
					model.setToTtlAmt(toTtlAmt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (loclTaxFlg[i] != null)
					model.setLoclTaxFlg(loclTaxFlg[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (cfmIfFlg[i] != null)
					model.setCfmIfFlg(cfmIfFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceivableInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceivableInvoiceVO[]
	 */
	public ReceivableInvoiceVO[] getReceivableInvoiceVOs(){
		ReceivableInvoiceVO[] vos = (ReceivableInvoiceVO[])models.toArray(new ReceivableInvoiceVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.fmChgAmt = this.fmChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrCd = this.toCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRcvChgTpCd = this.lseRcvChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCurrCd = this.fmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurrRt = this.toCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCurrRt = this.fmCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilDys = this.bilDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtAmt = this.chgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlSeq = this.rcvRntlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toChgAmt = this.toChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfSeq = this.srcIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt = this.srcIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIsuDt = this.invIsuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt = this.invIsuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTaxAmt = this.toTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTtlAmt = this.toTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTaxFlg = this.loclTaxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmIfFlg = this.cfmIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
