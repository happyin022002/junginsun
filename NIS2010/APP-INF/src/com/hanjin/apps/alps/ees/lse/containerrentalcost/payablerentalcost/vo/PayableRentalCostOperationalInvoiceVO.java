/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostOperationalInvoiceVO.java
*@FileTitle : PayableRentalCostOperationalInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.09 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableRentalCostOperationalInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableRentalCostOperationalInvoiceVO> models = new ArrayList<PayableRentalCostOperationalInvoiceVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String prinAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String opLseStsCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String balAmt = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lseCtrtNo = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bilToDt = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String intAmt = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String bilFmDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String liborAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String opSeq = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String coOfcCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String opLseQty = null;
	/* Column Info */
	private String costNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayableRentalCostOperationalInvoiceVO() {}

	public PayableRentalCostOperationalInvoiceVO(String ibflag, String pagerows, String opLseStsCd, String vndrNm, String bilFmDt, String bilToDt, 
			                                     String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String payDt, String cntrTpszCd, 
			                                     String agmtNo, String agmtRefNo, String vndrLglEngNm, String currCd, String prinAmt, String balAmt, 
			                                     String intAmt, String liborAmt, String payAmt, String invNo, String diffRmk, String lseCtrtNo, 
			                                     String agmtCtyCd, String agmtSeq, String vndrSeq, String opSeq, String acctCd, String costCd,
			                                     String usrId, String coOfcCd, String creOfcCd, String opLseQty, String costNm) {
		this.payDt = payDt;
		this.vslCd = vslCd;
		this.prinAmt = prinAmt;
		this.currCd = currCd;
		this.opLseStsCd = opLseStsCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.balAmt = balAmt;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.lseCtrtNo = lseCtrtNo;
		this.payAmt = payAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.bilToDt = bilToDt;
		this.agmtCtyCd = agmtCtyCd;
		this.intAmt = intAmt;
		this.agmtRefNo = agmtRefNo;
		this.bilFmDt = bilFmDt;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.skdVoyNo = skdVoyNo;
		this.liborAmt = liborAmt;
		this.skdDirCd = skdDirCd;
		this.invNo = invNo;
		this.diffRmk = diffRmk;
		this.vndrSeq = vndrSeq;
		this.opSeq = opSeq;
		this.acctCd = acctCd;
		this.costCd = costCd;
		this.usrId = usrId;
		this.coOfcCd = coOfcCd;
		this.creOfcCd = creOfcCd;
		this.opLseQty = opLseQty;
		this.costNm = costNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("prin_amt", getPrinAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("op_lse_sts_cd", getOpLseStsCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bil_to_dt", getBilToDt());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("int_amt", getIntAmt());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("bil_fm_dt", getBilFmDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("libor_amt", getLiborAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("op_seq", getOpSeq());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("co_ofc_cd", getCoOfcCd());
		this.hashColumns.put("op_lse_qty", getOpLseQty());
		this.hashColumns.put("cost_nm", getCostNm());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("prin_amt", "prinAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("op_lse_sts_cd", "opLseStsCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bil_to_dt", "bilToDt");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("int_amt", "intAmt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("bil_fm_dt", "bilFmDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("libor_amt", "liborAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("op_seq", "opSeq");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("co_ofc_cd", "coOfcCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("op_lse_qty", "opLseQty");
		this.hashFields.put("cost_nm", "costNm");

		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return prinAmt
	 */
	public String getPrinAmt() {
		return this.prinAmt;
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
	 * @return opLseStsCd
	 */
	public String getOpLseStsCd() {
		return this.opLseStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return lseCtrtNo
	 */
	public String getLseCtrtNo() {
		return this.lseCtrtNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return bilToDt
	 */
	public String getBilToDt() {
		return this.bilToDt;
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
	 * @return intAmt
	 */
	public String getIntAmt() {
		return this.intAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return bilFmDt
	 */
	public String getBilFmDt() {
		return this.bilFmDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return liborAmt
	 */
	public String getLiborAmt() {
		return this.liborAmt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param prinAmt
	 */
	public void setPrinAmt(String prinAmt) {
		this.prinAmt = prinAmt;
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
	 * @param opLseStsCd
	 */
	public void setOpLseStsCd(String opLseStsCd) {
		this.opLseStsCd = opLseStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param lseCtrtNo
	 */
	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param bilToDt
	 */
	public void setBilToDt(String bilToDt) {
		this.bilToDt = bilToDt;
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
	 * @param intAmt
	 */
	public void setIntAmt(String intAmt) {
		this.intAmt = intAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param bilFmDt
	 */
	public void setBilFmDt(String bilFmDt) {
		this.bilFmDt = bilFmDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param liborAmt
	 */
	public void setLiborAmt(String liborAmt) {
		this.liborAmt = liborAmt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setOpSeq(String opSeq) {
		this.opSeq = opSeq;
	}

	public String getOpSeq() {
		return opSeq;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}

	public String getAcctCd() {
		return acctCd;
	}

	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}

	public String getCostCd() {
		return costCd;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setCoOfcCd(String coOfcCd) {
		this.coOfcCd = coOfcCd;
	}

	public String getCoOfcCd() {
		return coOfcCd;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	public String getCreOfcCd() {
		return creOfcCd;
	}

	public void setOpLseQty(String opLseQty) {
		this.opLseQty = opLseQty;
	}

	public String getOpLseQty() {
		return opLseQty;
	}

	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}

	public String getCostNm() {
		return costNm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPrinAmt(JSPUtil.getParameter(request, "prin_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOpLseStsCd(JSPUtil.getParameter(request, "op_lse_sts_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setBalAmt(JSPUtil.getParameter(request, "bal_amt", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLseCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
		setPayAmt(JSPUtil.getParameter(request, "pay_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setBilToDt(JSPUtil.getParameter(request, "bil_to_dt", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setIntAmt(JSPUtil.getParameter(request, "int_amt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setBilFmDt(JSPUtil.getParameter(request, "bil_fm_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setLiborAmt(JSPUtil.getParameter(request, "libor_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOpSeq(JSPUtil.getParameter(request, "op_seq", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCoOfcCd(JSPUtil.getParameter(request, "co_ofc_cd", ""));
		setOpLseQty(JSPUtil.getParameter(request, "op_lse_qty", ""));
		setCostNm(JSPUtil.getParameter(request, "cost_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableRentalCostOperationalInvoiceVO[]
	 */
	public PayableRentalCostOperationalInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableRentalCostOperationalInvoiceVO[]
	 */
	public PayableRentalCostOperationalInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableRentalCostOperationalInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix + "pay_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
			String[] prinAmt = (JSPUtil.getParameter(request, prefix + "prin_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] opLseStsCd = (JSPUtil.getParameter(request, prefix	+ "op_lse_sts_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	    + "ibflag", length));
			String[] lseCtrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	    + "pay_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bilToDt = (JSPUtil.getParameter(request, prefix	+ "bil_to_dt", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] intAmt = (JSPUtil.getParameter(request, prefix	    + "int_amt", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] bilFmDt = (JSPUtil.getParameter(request, prefix	+ "bil_fm_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] liborAmt = (JSPUtil.getParameter(request, prefix	+ "libor_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] opSeq = (JSPUtil.getParameter(request, prefix	+ "op_seq", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] coOfcCd = (JSPUtil.getParameter(request, prefix	+ "co_ofc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] opLseQty = (JSPUtil.getParameter(request, prefix	+ "op_lse_qty", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));

			for (int i = 0; i < length; i++) {
				model = new PayableRentalCostOperationalInvoiceVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (prinAmt[i] != null)
					model.setPrinAmt(prinAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (opLseStsCd[i] != null)
					model.setOpLseStsCd(opLseStsCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lseCtrtNo[i] != null)
					model.setLseCtrtNo(lseCtrtNo[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bilToDt[i] != null)
					model.setBilToDt(bilToDt[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (intAmt[i] != null)
					model.setIntAmt(intAmt[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (bilFmDt[i] != null)
					model.setBilFmDt(bilFmDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (liborAmt[i] != null)
					model.setLiborAmt(liborAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (opSeq[i] != null)
					model.setOpSeq(opSeq[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (coOfcCd[i] != null)
					model.setCoOfcCd(coOfcCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (opLseQty[i] != null)
					model.setOpLseQty(opLseQty[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableRentalCostOperationalInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableRentalCostOperationalInvoiceVO[]
	 */
	public PayableRentalCostOperationalInvoiceVO[] getPayableRentalCostOperationalInvoiceVOs(){
		PayableRentalCostOperationalInvoiceVO[] vos = (PayableRentalCostOperationalInvoiceVO[])models.toArray(new PayableRentalCostOperationalInvoiceVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prinAmt = this.prinAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opLseStsCd = this.opLseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo = this.lseCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToDt = this.bilToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intAmt = this.intAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilFmDt = this.bilFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liborAmt = this.liborAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opSeq = this.opSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coOfcCd = this.coOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opLseQty = this.opLseQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}