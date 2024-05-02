/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInvoiceDefaultDataVO.java
*@FileTitle : SearchInvoiceDefaultDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.21 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInvoiceDefaultDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoiceDefaultDataVO> models = new ArrayList<SearchInvoiceDefaultDataVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String n3ptyInvRvisCd = null;
	/* Column Info */
	private String n3ptyNm = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String lengthN3ptyBilTpCd = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String reviseAble = null;
	/* Column Info */
	private String n3ptyInvRvisSeq = null;
	/* Column Info */
	private String invoiceAble = null;
	/* Column Info */
	private String rcvrActYn = null;
	/* Column Info */
	private String n3ptyCd = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String erpifAble = null;
	/* Column Info */
	private String idaTaxSeq = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String n3ptySrcNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInvoiceDefaultDataVO() {}

	public SearchInvoiceDefaultDataVO(String ibflag, String pagerows, String sN3ptyNo, String sN3ptyInvNo, String n3ptyNo, String n3ptyInvNo, String n3ptyInvRvisCd, String n3ptyInvRvisSeq, String vndrCustDivCd, String n3ptyCd, String reviseAble, String lengthN3ptyBilTpCd, String idaTaxSeq, String userOfcCd, String n3ptyExpnTpCd, String n3ptyBilTpCd, String n3ptyBilTpNm, String n3ptySrcNo, String eqNo, String n3ptyNm, String revVvd, String currCd, String otsAmt, String invAmt, String cfmDt, String rcvrActYn, String invoiceAble, String erpifAble) {
		this.userOfcCd = userOfcCd;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.currCd = currCd;
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
		this.n3ptyNm = n3ptyNm;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ibflag = ibflag;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.eqNo = eqNo;
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
		this.n3ptyNo = n3ptyNo;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.invAmt = invAmt;
		this.reviseAble = reviseAble;
		this.n3ptyInvRvisSeq = n3ptyInvRvisSeq;
		this.invoiceAble = invoiceAble;
		this.rcvrActYn = rcvrActYn;
		this.n3ptyCd = n3ptyCd;
		this.sN3ptyNo = sN3ptyNo;
		this.cfmDt = cfmDt;
		this.erpifAble = erpifAble;
		this.idaTaxSeq = idaTaxSeq;
		this.otsAmt = otsAmt;
		this.revVvd = revVvd;
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("n3pty_inv_rvis_cd", getN3ptyInvRvisCd());
		this.hashColumns.put("n3pty_nm", getN3ptyNm());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("length_n3pty_bil_tp_cd", getLengthN3ptyBilTpCd());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("revise_able", getReviseAble());
		this.hashColumns.put("n3pty_inv_rvis_seq", getN3ptyInvRvisSeq());
		this.hashColumns.put("invoice_able", getInvoiceAble());
		this.hashColumns.put("rcvr_act_yn", getRcvrActYn());
		this.hashColumns.put("n3pty_cd", getN3ptyCd());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("erpif_able", getErpifAble());
		this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("n3pty_inv_rvis_cd", "n3ptyInvRvisCd");
		this.hashFields.put("n3pty_nm", "n3ptyNm");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("length_n3pty_bil_tp_cd", "lengthN3ptyBilTpCd");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("revise_able", "reviseAble");
		this.hashFields.put("n3pty_inv_rvis_seq", "n3ptyInvRvisSeq");
		this.hashFields.put("invoice_able", "invoiceAble");
		this.hashFields.put("rcvr_act_yn", "rcvrActYn");
		this.hashFields.put("n3pty_cd", "n3ptyCd");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("erpif_able", "erpifAble");
		this.hashFields.put("ida_tax_seq", "idaTaxSeq");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
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
	 * @return n3ptyInvRvisCd
	 */
	public String getN3ptyInvRvisCd() {
		return this.n3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNm
	 */
	public String getN3ptyNm() {
		return this.n3ptyNm;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
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
	 * @return vndrCustDivCd
	 */
	public String getVndrCustDivCd() {
		return this.vndrCustDivCd;
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
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return lengthN3ptyBilTpCd
	 */
	public String getLengthN3ptyBilTpCd() {
		return this.lengthN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvNo
	 */
	public String getSN3ptyInvNo() {
		return this.sN3ptyInvNo;
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
	 * @return reviseAble
	 */
	public String getReviseAble() {
		return this.reviseAble;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvRvisSeq
	 */
	public String getN3ptyInvRvisSeq() {
		return this.n3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @return invoiceAble
	 */
	public String getInvoiceAble() {
		return this.invoiceAble;
	}
	
	/**
	 * Column Info
	 * @return rcvrActYn
	 */
	public String getRcvrActYn() {
		return this.rcvrActYn;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCd
	 */
	public String getN3ptyCd() {
		return this.n3ptyCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return erpifAble
	 */
	public String getErpifAble() {
		return this.erpifAble;
	}
	
	/**
	 * Column Info
	 * @return idaTaxSeq
	 */
	public String getIdaTaxSeq() {
		return this.idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @return otsAmt
	 */
	public String getOtsAmt() {
		return this.otsAmt;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	

	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
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
	 * @param n3ptyInvRvisCd
	 */
	public void setN3ptyInvRvisCd(String n3ptyInvRvisCd) {
		this.n3ptyInvRvisCd = n3ptyInvRvisCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNm
	 */
	public void setN3ptyNm(String n3ptyNm) {
		this.n3ptyNm = n3ptyNm;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
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
	 * @param vndrCustDivCd
	 */
	public void setVndrCustDivCd(String vndrCustDivCd) {
		this.vndrCustDivCd = vndrCustDivCd;
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
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param lengthN3ptyBilTpCd
	 */
	public void setLengthN3ptyBilTpCd(String lengthN3ptyBilTpCd) {
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvNo
	 */
	public void setSN3ptyInvNo(String sN3ptyInvNo) {
		this.sN3ptyInvNo = sN3ptyInvNo;
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
	 * @param reviseAble
	 */
	public void setReviseAble(String reviseAble) {
		this.reviseAble = reviseAble;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvRvisSeq
	 */
	public void setN3ptyInvRvisSeq(String n3ptyInvRvisSeq) {
		this.n3ptyInvRvisSeq = n3ptyInvRvisSeq;
	}
	
	/**
	 * Column Info
	 * @param invoiceAble
	 */
	public void setInvoiceAble(String invoiceAble) {
		this.invoiceAble = invoiceAble;
	}
	
	/**
	 * Column Info
	 * @param rcvrActYn
	 */
	public void setRcvrActYn(String rcvrActYn) {
		this.rcvrActYn = rcvrActYn;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCd
	 */
	public void setN3ptyCd(String n3ptyCd) {
		this.n3ptyCd = n3ptyCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param erpifAble
	 */
	public void setErpifAble(String erpifAble) {
		this.erpifAble = erpifAble;
	}
	
	/**
	 * Column Info
	 * @param idaTaxSeq
	 */
	public void setIdaTaxSeq(String idaTaxSeq) {
		this.idaTaxSeq = idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @param otsAmt
	 */
	public void setOtsAmt(String otsAmt) {
		this.otsAmt = otsAmt;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setN3ptyInvRvisCd(JSPUtil.getParameter(request, "n3pty_inv_rvis_cd", ""));
		setN3ptyNm(JSPUtil.getParameter(request, "n3pty_nm", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setLengthN3ptyBilTpCd(JSPUtil.getParameter(request, "length_n3pty_bil_tp_cd", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, "s_n3pty_inv_no", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setReviseAble(JSPUtil.getParameter(request, "revise_able", ""));
		setN3ptyInvRvisSeq(JSPUtil.getParameter(request, "n3pty_inv_rvis_seq", ""));
		setInvoiceAble(JSPUtil.getParameter(request, "invoice_able", ""));
		setRcvrActYn(JSPUtil.getParameter(request, "rcvr_act_yn", ""));
		setN3ptyCd(JSPUtil.getParameter(request, "n3pty_cd", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setCfmDt(JSPUtil.getParameter(request, "cfm_dt", ""));
		setErpifAble(JSPUtil.getParameter(request, "erpif_able", ""));
		setIdaTaxSeq(JSPUtil.getParameter(request, "ida_tax_seq", ""));
		setOtsAmt(JSPUtil.getParameter(request, "ots_amt", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, "n3pty_src_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceDefaultDataVO[]
	 */
	public SearchInvoiceDefaultDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceDefaultDataVO[]
	 */
	public SearchInvoiceDefaultDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoiceDefaultDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] n3ptyInvRvisCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_cd", length));
			String[] n3ptyNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_nm", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] lengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_bil_tp_cd", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] reviseAble = (JSPUtil.getParameter(request, prefix	+ "revise_able", length));
			String[] n3ptyInvRvisSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_rvis_seq", length));
			String[] invoiceAble = (JSPUtil.getParameter(request, prefix	+ "invoice_able", length));
			String[] rcvrActYn = (JSPUtil.getParameter(request, prefix	+ "rcvr_act_yn", length));
			String[] n3ptyCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cd", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] erpifAble = (JSPUtil.getParameter(request, prefix	+ "erpif_able", length));
			String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "ida_tax_seq", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoiceDefaultDataVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (n3ptyInvRvisCd[i] != null)
					model.setN3ptyInvRvisCd(n3ptyInvRvisCd[i]);
				if (n3ptyNm[i] != null)
					model.setN3ptyNm(n3ptyNm[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (lengthN3ptyBilTpCd[i] != null)
					model.setLengthN3ptyBilTpCd(lengthN3ptyBilTpCd[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (reviseAble[i] != null)
					model.setReviseAble(reviseAble[i]);
				if (n3ptyInvRvisSeq[i] != null)
					model.setN3ptyInvRvisSeq(n3ptyInvRvisSeq[i]);
				if (invoiceAble[i] != null)
					model.setInvoiceAble(invoiceAble[i]);
				if (rcvrActYn[i] != null)
					model.setRcvrActYn(rcvrActYn[i]);
				if (n3ptyCd[i] != null)
					model.setN3ptyCd(n3ptyCd[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (erpifAble[i] != null)
					model.setErpifAble(erpifAble[i]);
				if (idaTaxSeq[i] != null)
					model.setIdaTaxSeq(idaTaxSeq[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoiceDefaultDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoiceDefaultDataVO[]
	 */
	public SearchInvoiceDefaultDataVO[] getSearchInvoiceDefaultDataVOs(){
		SearchInvoiceDefaultDataVO[] vos = (SearchInvoiceDefaultDataVO[])models.toArray(new SearchInvoiceDefaultDataVO[models.size()]);
		return vos;
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisCd = this.n3ptyInvRvisCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNm = this.n3ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyBilTpCd = this.lengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reviseAble = this.reviseAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvRvisSeq = this.n3ptyInvRvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceAble = this.invoiceAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrActYn = this.rcvrActYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCd = this.n3ptyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpifAble = this.erpifAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxSeq = this.idaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
