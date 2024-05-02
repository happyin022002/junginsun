/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvBkgIfChgVO.java
*@FileTitle : InvBkgIfChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.01.13 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvBkgIfChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvBkgIfChgVO> models = new ArrayList<InvBkgIfChgVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3rdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String autoRatCd = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String whfFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvBkgIfChgVO() {}

	public InvBkgIfChgVO(String ibflag, String pagerows, String bkgNo, String bkgSeq, String chgSeq, String chgCd, String currCd, String perTpCd, String trfRtAmt, String ratAsCntrQty, String chgAmt, String invXchRt, String trfNo, String ofcCd, String custCntCd, String custSeq, String ioBndCd, String n3rdFlg, String creUsrId, String creDt, String updUsrId, String updDt, String rcvTermCd, String deTermCd, String autoRatCd, String actCntCd, String actCustSeq, String whfFlg) {
		this.currCd = currCd;
		this.creDt = creDt;
		this.trfRtAmt = trfRtAmt;
		this.chgSeq = chgSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.n3rdFlg = n3rdFlg;
		this.ibflag = ibflag;
		this.actCntCd = actCntCd;
		this.chgAmt = chgAmt;
		this.rcvTermCd = rcvTermCd;
		this.invXchRt = invXchRt;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.autoRatCd = autoRatCd;
		this.perTpCd = perTpCd;
		this.actCustSeq = actCustSeq;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.bkgSeq = bkgSeq;
		this.ofcCd = ofcCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.trfNo = trfNo;
		this.ratAsCntrQty = ratAsCntrQty;
		this.whfFlg = whfFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3rd_flg", getN3rdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("auto_rat_cd", getAutoRatCd());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("whf_flg", getWhfFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3rd_flg", "n3rdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("auto_rat_cd", "autoRatCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("whf_flg", "whfFlg");
		return this.hashFields;
	}
	
	
	/**
	 * @return the whfFlg
	 */
	public String getWhfFlg() {
		return whfFlg;
	}

	/**
	 * @param whfFlg the whfFlg to set
	 */
	public void setWhfFlg(String whfFlg) {
		this.whfFlg = whfFlg;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return n3rdFlg
	 */
	public String getN3rdFlg() {
		return this.n3rdFlg;
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
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return autoRatCd
	 */
	public String getAutoRatCd() {
		return this.autoRatCd;
	}
	
	/**
	 * Column Info
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param n3rdFlg
	 */
	public void setN3rdFlg(String n3rdFlg) {
		this.n3rdFlg = n3rdFlg;
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
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param autoRatCd
	 */
	public void setAutoRatCd(String autoRatCd) {
		this.autoRatCd = autoRatCd;
	}
	
	/**
	 * Column Info
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, prefix + "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3rdFlg(JSPUtil.getParameter(request, prefix + "n3rd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAutoRatCd(JSPUtil.getParameter(request, prefix + "auto_rat_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request, prefix + "per_tp_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, prefix + "rat_as_cntr_qty", ""));
		setWhfFlg(JSPUtil.getParameter(request, prefix + "whf_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvBkgIfChgVO[]
	 */
	public InvBkgIfChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvBkgIfChgVO[]
	 */
	public InvBkgIfChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvBkgIfChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3rdFlg = (JSPUtil.getParameter(request, prefix	+ "n3rd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] autoRatCd = (JSPUtil.getParameter(request, prefix	+ "auto_rat_cd", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] whfFlg = (JSPUtil.getParameter(request, prefix	+ "whf_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvBkgIfChgVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3rdFlg[i] != null)
					model.setN3rdFlg(n3rdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (autoRatCd[i] != null)
					model.setAutoRatCd(autoRatCd[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (whfFlg[i] != null)
					model.setWhfFlg(whfFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvBkgIfChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvBkgIfChgVO[]
	 */
	public InvBkgIfChgVO[] getInvBkgIfChgVOs(){
		InvBkgIfChgVO[] vos = (InvBkgIfChgVO[])models.toArray(new InvBkgIfChgVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdFlg = this.n3rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatCd = this.autoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfFlg = this.whfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
