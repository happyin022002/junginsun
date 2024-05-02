/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : APActualInterfaceMasterVO.java
*@FileTitle : APActualInterfaceMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.11.12 추경원 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 추경원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class APActualInterfaceMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APActualInterfaceMasterVO> models = new ArrayList<APActualInterfaceMasterVO>();
	
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String expType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String netAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String commAproNo = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String acIfDt = null;
	/* Column Info */
	private String ftuUseCtnt1 = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String rcvErrFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String ifOption = null;
	/* Column Info */
	private String rcvErrFlgMsg = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String ifFlgMsg = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String invRgstNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public APActualInterfaceMasterVO() {}

	public APActualInterfaceMasterVO(String ibflag, String pagerows, String aproStep, String expType, String invDt, String invTaxRt, String asaNo, String totAmt, String currCd, String vat, String searchDtTo, String agnCd, String netAmt, String commAproNo, String payAmt, String acIfDt, String ftuUseCtnt1, String searchDtFr, String csrNo, String rcvErrFlg, String arOfcCd, String invNo, String payMzdLuCd, String ifOption, String rcvErrFlgMsg, String ifFlgMsg, String vvdCnt, String payDt, String statusCd, String invRgstNo) {
		this.aproStep = aproStep;
		this.payDt = payDt;
		this.totAmt = totAmt;
		this.currCd = currCd;
		this.searchDtTo = searchDtTo;
		this.vat = vat;
		this.expType = expType;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.netAmt = netAmt;
		this.ibflag = ibflag;
		this.commAproNo = commAproNo;
		this.payAmt = payAmt;
		this.acIfDt = acIfDt;
		this.ftuUseCtnt1 = ftuUseCtnt1;
		this.searchDtFr = searchDtFr;
		this.invTaxRt = invTaxRt;
		this.invDt = invDt;
		this.csrNo = csrNo;
		this.rcvErrFlg = rcvErrFlg;
		this.arOfcCd = arOfcCd;
		this.invNo = invNo;
		this.payMzdLuCd = payMzdLuCd;
		this.ifOption = ifOption;
		this.rcvErrFlgMsg = rcvErrFlgMsg;
		this.asaNo = asaNo;
		this.vvdCnt = vvdCnt;
		this.ifFlgMsg = ifFlgMsg;
		this.statusCd = statusCd;
		this.invRgstNo = invRgstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("exp_type", getExpType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("net_amt", getNetAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("comm_apro_no", getCommAproNo());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("ac_if_dt", getAcIfDt());
		this.hashColumns.put("ftu_use_ctnt1", getFtuUseCtnt1());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("rcv_err_flg", getRcvErrFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("if_option", getIfOption());
		this.hashColumns.put("rcv_err_flg_msg", getRcvErrFlgMsg());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("if_flg_msg", getIfFlgMsg());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("exp_type", "expType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("net_amt", "netAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("comm_apro_no", "commAproNo");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("ac_if_dt", "acIfDt");
		this.hashFields.put("ftu_use_ctnt1", "ftuUseCtnt1");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("rcv_err_flg", "rcvErrFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("if_option", "ifOption");
		this.hashFields.put("rcv_err_flg_msg", "rcvErrFlgMsg");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("if_flg_msg", "ifFlgMsg");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproStep
	 */
	public String getAproStep() {
		return this.aproStep;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
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
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return vat
	 */
	public String getVat() {
		return this.vat;
	}
	
	/**
	 * Column Info
	 * @return expType
	 */
	public String getExpType() {
		return this.expType;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return netAmt
	 */
	public String getNetAmt() {
		return this.netAmt;
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
	 * @return commAproNo
	 */
	public String getCommAproNo() {
		return this.commAproNo;
	}
	
	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return acIfDt
	 */
	public String getAcIfDt() {
		return this.acIfDt;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt1
	 */
	public String getFtuUseCtnt1() {
		return this.ftuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return invTaxRt
	 */
	public String getInvTaxRt() {
		return this.invTaxRt;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return rcvErrFlg
	 */
	public String getRcvErrFlg() {
		return this.rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return ifOption
	 */
	public String getIfOption() {
		return this.ifOption;
	}
	
	/**
	 * Column Info
	 * @return rcvErrFlgMsg
	 */
	public String getRcvErrFlgMsg() {
		return this.rcvErrFlgMsg;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	
	/**
	 * Column Info
	 * @return ifFlgMsg
	 */
	public String getIfFlgMsg() {
		return this.ifFlgMsg;
	}
	
	/**
	 * Column Info
	 * @return statusCode
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * Column Info
	 * @return invRgstNo
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
	}
	

	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
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
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param vat
	 */
	public void setVat(String vat) {
		this.vat = vat;
	}
	
	/**
	 * Column Info
	 * @param expType
	 */
	public void setExpType(String expType) {
		this.expType = expType;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param netAmt
	 */
	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
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
	 * @param commAproNo
	 */
	public void setCommAproNo(String commAproNo) {
		this.commAproNo = commAproNo;
	}
	
	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param acIfDt
	 */
	public void setAcIfDt(String acIfDt) {
		this.acIfDt = acIfDt;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt1
	 */
	public void setFtuUseCtnt1(String ftuUseCtnt1) {
		this.ftuUseCtnt1 = ftuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param invTaxRt
	 */
	public void setInvTaxRt(String invTaxRt) {
		this.invTaxRt = invTaxRt;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param rcvErrFlg
	 */
	public void setRcvErrFlg(String rcvErrFlg) {
		this.rcvErrFlg = rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param ifOption
	 */
	public void setIfOption(String ifOption) {
		this.ifOption = ifOption;
	}
	
	/**
	 * Column Info
	 * @param rcvErrFlgMsg
	 */
	public void setRcvErrFlgMsg(String rcvErrFlgMsg) {
		this.rcvErrFlgMsg = rcvErrFlgMsg;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}
	
	/**
	 * Column Info
	 * @param ifFlgMsg
	 */
	public void setIfFlgMsg(String ifFlgMsg) {
		this.ifFlgMsg = ifFlgMsg;
	}
	
	/**
	 * Column Info
	 * @param statusCode
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	/**
	 * Column Info
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAproStep(JSPUtil.getParameter(request, "apro_step", ""));
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setTotAmt(JSPUtil.getParameter(request, "tot_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSearchDtTo(JSPUtil.getParameter(request, "search_dt_to", ""));
		setVat(JSPUtil.getParameter(request, "vat", ""));
		setExpType(JSPUtil.getParameter(request, "exp_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, "agn_cd", ""));
		setNetAmt(JSPUtil.getParameter(request, "net_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCommAproNo(JSPUtil.getParameter(request, "comm_apro_no", ""));
		setPayAmt(JSPUtil.getParameter(request, "pay_amt", ""));
		setAcIfDt(JSPUtil.getParameter(request, "ac_if_dt", ""));
		setFtuUseCtnt1(JSPUtil.getParameter(request, "ftu_use_ctnt1", ""));
		setSearchDtFr(JSPUtil.getParameter(request, "search_dt_fr", ""));
		setInvTaxRt(JSPUtil.getParameter(request, "inv_tax_rt", ""));
		setInvDt(JSPUtil.getParameter(request, "inv_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setRcvErrFlg(JSPUtil.getParameter(request, "rcv_err_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, "pay_mzd_lu_cd", ""));
		setIfOption(JSPUtil.getParameter(request, "if_option", ""));
		setRcvErrFlgMsg(JSPUtil.getParameter(request, "rcv_err_flg_msg", ""));
		setAsaNo(JSPUtil.getParameter(request, "asa_no", ""));
		setVvdCnt(JSPUtil.getParameter(request, "vvd_cnt", ""));
		setIfFlgMsg(JSPUtil.getParameter(request, "if_flg_msg", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setInvRgstNo(JSPUtil.getParameter(request, "inv_rgst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APActualInterfaceMasterVO[]
	 */
	public APActualInterfaceMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APActualInterfaceMasterVO[]
	 */
	public APActualInterfaceMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APActualInterfaceMasterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] expType = (JSPUtil.getParameter(request, prefix	+ "exp_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] commAproNo = (JSPUtil.getParameter(request, prefix	+ "comm_apro_no", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] acIfDt = (JSPUtil.getParameter(request, prefix	+ "ac_if_dt", length));
			String[] ftuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt1", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] rcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] ifOption = (JSPUtil.getParameter(request, prefix	+ "if_option", length));
			String[] rcvErrFlgMsg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg_msg", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] ifFlgMsg = (JSPUtil.getParameter(request, prefix	+ "if_flg_msg", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new APActualInterfaceMasterVO();
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (expType[i] != null)
					model.setExpType(expType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (commAproNo[i] != null)
					model.setCommAproNo(commAproNo[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (acIfDt[i] != null)
					model.setAcIfDt(acIfDt[i]);
				if (ftuUseCtnt1[i] != null)
					model.setFtuUseCtnt1(ftuUseCtnt1[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (rcvErrFlg[i] != null)
					model.setRcvErrFlg(rcvErrFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (ifOption[i] != null)
					model.setIfOption(ifOption[i]);
				if (rcvErrFlgMsg[i] != null)
					model.setRcvErrFlgMsg(rcvErrFlgMsg[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (ifFlgMsg[i] != null)
					model.setIfFlgMsg(ifFlgMsg[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPActualInterfaceMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APActualInterfaceMasterVO[]
	 */
	public APActualInterfaceMasterVO[] getAPActualInterfaceMasterVOs(){
		APActualInterfaceMasterVO[] vos = (APActualInterfaceMasterVO[])models.toArray(new APActualInterfaceMasterVO[models.size()]);
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
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expType = this.expType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commAproNo = this.commAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acIfDt = this.acIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt1 = this.ftuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlg = this.rcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOption = this.ifOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlgMsg = this.rcvErrFlgMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlgMsg = this.ifFlgMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
