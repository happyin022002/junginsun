/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArTaxMnVO.java
*@FileTitle : InvArTaxMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.09.21 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArTaxMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArTaxMnVO> models = new ArrayList<InvArTaxMnVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custLoclLangNm = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String taxInvNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String taxInvCxlFlg = null;
	/* Column Info */
	private String taxRgstNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String issueGb = null;
	/* Column Info */
	private String issUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deptNm = null;
	/* Column Info */
	private String prnKnt = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String ttlLoclCurrAmt = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String vvdPrnFlg = null;
	/* Column Info */
	private String loclNmPrnFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String portPrnFlg = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String sailArrPrnFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String taxInvCxlRmk = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String taxInvRmk = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String issCurrCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String taxInvCxlDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bizRgstNo = null;
	/* Column Info */
	private String taxInvSeq = null;
	/* Column Info */
	private String taxInvCxlUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArTaxMnVO() {}

	public InvArTaxMnVO(String ibflag, String pagerows, String actCustCntCd, String actCustSeq, String custLglEngNm, String custLoclLangNm, String vvd, String sailArrDt, String porCd, String polCd, String podCd, String delCd, String taxInvNo, String taxInvSeq, String blSrcNo, String bkgNo, String arOfcCd, String loclNmPrnFlg, String vvdPrnFlg, String sailArrPrnFlg, String portPrnFlg, String ioBndCd, String bankNm, String bankAcctNo, String deptNm, String coNm, String bizRgstNo, String taxRgstNo, String issCurrCd, String issDt, String issUsrId, String invXchRt, String ttlLoclCurrAmt, String prnKnt, String taxInvRmk, String taxInvCxlFlg, String taxInvCxlDt, String taxInvCxlUsrId, String taxInvCxlRmk, String creUsrId, String creDt, String updUsrId, String updDt, String issueGb) {
		this.porCd = porCd;
		this.custLoclLangNm = custLoclLangNm;
		this.bankAcctNo = bankAcctNo;
		this.taxInvNo = taxInvNo;
		this.creDt = creDt;
		this.taxInvCxlFlg = taxInvCxlFlg;
		this.taxRgstNo = taxRgstNo;
		this.sailArrDt = sailArrDt;
		this.issueGb = issueGb;
		this.issUsrId = issUsrId;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.deptNm = deptNm;
		this.prnKnt = prnKnt;
		this.bankNm = bankNm;
		this.ttlLoclCurrAmt = ttlLoclCurrAmt;
		this.actCustCntCd = actCustCntCd;
		this.vvdPrnFlg = vvdPrnFlg;
		this.loclNmPrnFlg = loclNmPrnFlg;
		this.updUsrId = updUsrId;
		this.invXchRt = invXchRt;
		this.updDt = updDt;
		this.blSrcNo = blSrcNo;
		this.portPrnFlg = portPrnFlg;
		this.actCustSeq = actCustSeq;
		this.sailArrPrnFlg = sailArrPrnFlg;
		this.delCd = delCd;
		this.taxInvCxlRmk = taxInvCxlRmk;
		this.coNm = coNm;
		this.taxInvRmk = taxInvRmk;
		this.ioBndCd = ioBndCd;
		this.arOfcCd = arOfcCd;
		this.issCurrCd = issCurrCd;
		this.custLglEngNm = custLglEngNm;
		this.podCd = podCd;
		this.vvd = vvd;
		this.taxInvCxlDt = taxInvCxlDt;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.bizRgstNo = bizRgstNo;
		this.taxInvSeq = taxInvSeq;
		this.taxInvCxlUsrId = taxInvCxlUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("tax_inv_no", getTaxInvNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tax_inv_cxl_flg", getTaxInvCxlFlg());
		this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("issue_gb", getIssueGb());
		this.hashColumns.put("iss_usr_id", getIssUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dept_nm", getDeptNm());
		this.hashColumns.put("prn_knt", getPrnKnt());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("ttl_locl_curr_amt", getTtlLoclCurrAmt());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("vvd_prn_flg", getVvdPrnFlg());
		this.hashColumns.put("locl_nm_prn_flg", getLoclNmPrnFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("port_prn_flg", getPortPrnFlg());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("sail_arr_prn_flg", getSailArrPrnFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tax_inv_cxl_rmk", getTaxInvCxlRmk());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("tax_inv_rmk", getTaxInvRmk());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("iss_curr_cd", getIssCurrCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("tax_inv_cxl_dt", getTaxInvCxlDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("biz_rgst_no", getBizRgstNo());
		this.hashColumns.put("tax_inv_seq", getTaxInvSeq());
		this.hashColumns.put("tax_inv_cxl_usr_id", getTaxInvCxlUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("tax_inv_no", "taxInvNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tax_inv_cxl_flg", "taxInvCxlFlg");
		this.hashFields.put("tax_rgst_no", "taxRgstNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("issue_gb", "issueGb");
		this.hashFields.put("iss_usr_id", "issUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dept_nm", "deptNm");
		this.hashFields.put("prn_knt", "prnKnt");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("ttl_locl_curr_amt", "ttlLoclCurrAmt");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("vvd_prn_flg", "vvdPrnFlg");
		this.hashFields.put("locl_nm_prn_flg", "loclNmPrnFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("port_prn_flg", "portPrnFlg");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("sail_arr_prn_flg", "sailArrPrnFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tax_inv_cxl_rmk", "taxInvCxlRmk");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("tax_inv_rmk", "taxInvRmk");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("iss_curr_cd", "issCurrCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("tax_inv_cxl_dt", "taxInvCxlDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("biz_rgst_no", "bizRgstNo");
		this.hashFields.put("tax_inv_seq", "taxInvSeq");
		this.hashFields.put("tax_inv_cxl_usr_id", "taxInvCxlUsrId");
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
	 * @return custLoclLangNm
	 */
	public String getCustLoclLangNm() {
		return this.custLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @return taxInvNo
	 */
	public String getTaxInvNo() {
		return this.taxInvNo;
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
	 * @return taxInvCxlFlg
	 */
	public String getTaxInvCxlFlg() {
		return this.taxInvCxlFlg;
	}
	
	/**
	 * Column Info
	 * @return taxRgstNo
	 */
	public String getTaxRgstNo() {
		return this.taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return issueGb
	 */
	public String getIssueGb() {
		return this.issueGb;
	}
	
	/**
	 * Column Info
	 * @return issUsrId
	 */
	public String getIssUsrId() {
		return this.issUsrId;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return deptNm
	 */
	public String getDeptNm() {
		return this.deptNm;
	}
	
	/**
	 * Column Info
	 * @return prnKnt
	 */
	public String getPrnKnt() {
		return this.prnKnt;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return ttlLoclCurrAmt
	 */
	public String getTtlLoclCurrAmt() {
		return this.ttlLoclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return vvdPrnFlg
	 */
	public String getVvdPrnFlg() {
		return this.vvdPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return loclNmPrnFlg
	 */
	public String getLoclNmPrnFlg() {
		return this.loclNmPrnFlg;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return portPrnFlg
	 */
	public String getPortPrnFlg() {
		return this.portPrnFlg;
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
	 * @return sailArrPrnFlg
	 */
	public String getSailArrPrnFlg() {
		return this.sailArrPrnFlg;
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
	 * @return taxInvCxlRmk
	 */
	public String getTaxInvCxlRmk() {
		return this.taxInvCxlRmk;
	}
	
	/**
	 * Column Info
	 * @return coNm
	 */
	public String getCoNm() {
		return this.coNm;
	}
	
	/**
	 * Column Info
	 * @return taxInvRmk
	 */
	public String getTaxInvRmk() {
		return this.taxInvRmk;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return issCurrCd
	 */
	public String getIssCurrCd() {
		return this.issCurrCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return taxInvCxlDt
	 */
	public String getTaxInvCxlDt() {
		return this.taxInvCxlDt;
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
	 * @return bizRgstNo
	 */
	public String getBizRgstNo() {
		return this.bizRgstNo;
	}
	
	/**
	 * Column Info
	 * @return taxInvSeq
	 */
	public String getTaxInvSeq() {
		return this.taxInvSeq;
	}
	
	/**
	 * Column Info
	 * @return taxInvCxlUsrId
	 */
	public String getTaxInvCxlUsrId() {
		return this.taxInvCxlUsrId;
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
	 * @param custLoclLangNm
	 */
	public void setCustLoclLangNm(String custLoclLangNm) {
		this.custLoclLangNm = custLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @param taxInvNo
	 */
	public void setTaxInvNo(String taxInvNo) {
		this.taxInvNo = taxInvNo;
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
	 * @param taxInvCxlFlg
	 */
	public void setTaxInvCxlFlg(String taxInvCxlFlg) {
		this.taxInvCxlFlg = taxInvCxlFlg;
	}
	
	/**
	 * Column Info
	 * @param taxRgstNo
	 */
	public void setTaxRgstNo(String taxRgstNo) {
		this.taxRgstNo = taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param issueGb
	 */
	public void setIssueGb(String issueGb) {
		this.issueGb = issueGb;
	}
	
	/**
	 * Column Info
	 * @param issUsrId
	 */
	public void setIssUsrId(String issUsrId) {
		this.issUsrId = issUsrId;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param deptNm
	 */
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	
	/**
	 * Column Info
	 * @param prnKnt
	 */
	public void setPrnKnt(String prnKnt) {
		this.prnKnt = prnKnt;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param ttlLoclCurrAmt
	 */
	public void setTtlLoclCurrAmt(String ttlLoclCurrAmt) {
		this.ttlLoclCurrAmt = ttlLoclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param vvdPrnFlg
	 */
	public void setVvdPrnFlg(String vvdPrnFlg) {
		this.vvdPrnFlg = vvdPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param loclNmPrnFlg
	 */
	public void setLoclNmPrnFlg(String loclNmPrnFlg) {
		this.loclNmPrnFlg = loclNmPrnFlg;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param portPrnFlg
	 */
	public void setPortPrnFlg(String portPrnFlg) {
		this.portPrnFlg = portPrnFlg;
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
	 * @param sailArrPrnFlg
	 */
	public void setSailArrPrnFlg(String sailArrPrnFlg) {
		this.sailArrPrnFlg = sailArrPrnFlg;
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
	 * @param taxInvCxlRmk
	 */
	public void setTaxInvCxlRmk(String taxInvCxlRmk) {
		this.taxInvCxlRmk = taxInvCxlRmk;
	}
	
	/**
	 * Column Info
	 * @param coNm
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	/**
	 * Column Info
	 * @param taxInvRmk
	 */
	public void setTaxInvRmk(String taxInvRmk) {
		this.taxInvRmk = taxInvRmk;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param issCurrCd
	 */
	public void setIssCurrCd(String issCurrCd) {
		this.issCurrCd = issCurrCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param taxInvCxlDt
	 */
	public void setTaxInvCxlDt(String taxInvCxlDt) {
		this.taxInvCxlDt = taxInvCxlDt;
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
	 * @param bizRgstNo
	 */
	public void setBizRgstNo(String bizRgstNo) {
		this.bizRgstNo = bizRgstNo;
	}
	
	/**
	 * Column Info
	 * @param taxInvSeq
	 */
	public void setTaxInvSeq(String taxInvSeq) {
		this.taxInvSeq = taxInvSeq;
	}
	
	/**
	 * Column Info
	 * @param taxInvCxlUsrId
	 */
	public void setTaxInvCxlUsrId(String taxInvCxlUsrId) {
		this.taxInvCxlUsrId = taxInvCxlUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCustLoclLangNm(JSPUtil.getParameter(request, "cust_locl_lang_nm", ""));
		setBankAcctNo(JSPUtil.getParameter(request, "bank_acct_no", ""));
		setTaxInvNo(JSPUtil.getParameter(request, "tax_inv_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTaxInvCxlFlg(JSPUtil.getParameter(request, "tax_inv_cxl_flg", ""));
		setTaxRgstNo(JSPUtil.getParameter(request, "tax_rgst_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setIssueGb(JSPUtil.getParameter(request, "issue_gb", ""));
		setIssUsrId(JSPUtil.getParameter(request, "iss_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeptNm(JSPUtil.getParameter(request, "dept_nm", ""));
		setPrnKnt(JSPUtil.getParameter(request, "prn_knt", ""));
		setBankNm(JSPUtil.getParameter(request, "bank_nm", ""));
		setTtlLoclCurrAmt(JSPUtil.getParameter(request, "ttl_locl_curr_amt", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setVvdPrnFlg(JSPUtil.getParameter(request, "vvd_prn_flg", ""));
		setLoclNmPrnFlg(JSPUtil.getParameter(request, "locl_nm_prn_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setPortPrnFlg(JSPUtil.getParameter(request, "port_prn_flg", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setSailArrPrnFlg(JSPUtil.getParameter(request, "sail_arr_prn_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setTaxInvCxlRmk(JSPUtil.getParameter(request, "tax_inv_cxl_rmk", ""));
		setCoNm(JSPUtil.getParameter(request, "co_nm", ""));
		setTaxInvRmk(JSPUtil.getParameter(request, "tax_inv_rmk", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setIssCurrCd(JSPUtil.getParameter(request, "iss_curr_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setTaxInvCxlDt(JSPUtil.getParameter(request, "tax_inv_cxl_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBizRgstNo(JSPUtil.getParameter(request, "biz_rgst_no", ""));
		setTaxInvSeq(JSPUtil.getParameter(request, "tax_inv_seq", ""));
		setTaxInvCxlUsrId(JSPUtil.getParameter(request, "tax_inv_cxl_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArTaxMnVO[]
	 */
	public InvArTaxMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArTaxMnVO[]
	 */
	public InvArTaxMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArTaxMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] taxInvNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] taxInvCxlFlg = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_flg", length));
			String[] taxRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_rgst_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] issueGb = (JSPUtil.getParameter(request, prefix	+ "issue_gb", length));
			String[] issUsrId = (JSPUtil.getParameter(request, prefix	+ "iss_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deptNm = (JSPUtil.getParameter(request, prefix	+ "dept_nm", length));
			String[] prnKnt = (JSPUtil.getParameter(request, prefix	+ "prn_knt", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] ttlLoclCurrAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_locl_curr_amt", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] vvdPrnFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_prn_flg", length));
			String[] loclNmPrnFlg = (JSPUtil.getParameter(request, prefix	+ "locl_nm_prn_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] portPrnFlg = (JSPUtil.getParameter(request, prefix	+ "port_prn_flg", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] sailArrPrnFlg = (JSPUtil.getParameter(request, prefix	+ "sail_arr_prn_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] taxInvCxlRmk = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_rmk", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] taxInvRmk = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rmk", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] issCurrCd = (JSPUtil.getParameter(request, prefix	+ "iss_curr_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] taxInvCxlDt = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bizRgstNo = (JSPUtil.getParameter(request, prefix	+ "biz_rgst_no", length));
			String[] taxInvSeq = (JSPUtil.getParameter(request, prefix	+ "tax_inv_seq", length));
			String[] taxInvCxlUsrId = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArTaxMnVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custLoclLangNm[i] != null)
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (taxInvNo[i] != null)
					model.setTaxInvNo(taxInvNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (taxInvCxlFlg[i] != null)
					model.setTaxInvCxlFlg(taxInvCxlFlg[i]);
				if (taxRgstNo[i] != null)
					model.setTaxRgstNo(taxRgstNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (issueGb[i] != null)
					model.setIssueGb(issueGb[i]);
				if (issUsrId[i] != null)
					model.setIssUsrId(issUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deptNm[i] != null)
					model.setDeptNm(deptNm[i]);
				if (prnKnt[i] != null)
					model.setPrnKnt(prnKnt[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (ttlLoclCurrAmt[i] != null)
					model.setTtlLoclCurrAmt(ttlLoclCurrAmt[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (vvdPrnFlg[i] != null)
					model.setVvdPrnFlg(vvdPrnFlg[i]);
				if (loclNmPrnFlg[i] != null)
					model.setLoclNmPrnFlg(loclNmPrnFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (portPrnFlg[i] != null)
					model.setPortPrnFlg(portPrnFlg[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (sailArrPrnFlg[i] != null)
					model.setSailArrPrnFlg(sailArrPrnFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (taxInvCxlRmk[i] != null)
					model.setTaxInvCxlRmk(taxInvCxlRmk[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (taxInvRmk[i] != null)
					model.setTaxInvRmk(taxInvRmk[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (issCurrCd[i] != null)
					model.setIssCurrCd(issCurrCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (taxInvCxlDt[i] != null)
					model.setTaxInvCxlDt(taxInvCxlDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bizRgstNo[i] != null)
					model.setBizRgstNo(bizRgstNo[i]);
				if (taxInvSeq[i] != null)
					model.setTaxInvSeq(taxInvSeq[i]);
				if (taxInvCxlUsrId[i] != null)
					model.setTaxInvCxlUsrId(taxInvCxlUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArTaxMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArTaxMnVO[]
	 */
	public InvArTaxMnVO[] getInvArTaxMnVOs(){
		InvArTaxMnVO[] vos = (InvArTaxMnVO[])models.toArray(new InvArTaxMnVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvNo = this.taxInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlFlg = this.taxInvCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRgstNo = this.taxRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueGb = this.issueGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issUsrId = this.issUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptNm = this.deptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnKnt = this.prnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoclCurrAmt = this.ttlLoclCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPrnFlg = this.vvdPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNmPrnFlg = this.loclNmPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPrnFlg = this.portPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrPrnFlg = this.sailArrPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlRmk = this.taxInvCxlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRmk = this.taxInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCurrCd = this.issCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlDt = this.taxInvCxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizRgstNo = this.bizRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvSeq = this.taxInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlUsrId = this.taxInvCxlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
