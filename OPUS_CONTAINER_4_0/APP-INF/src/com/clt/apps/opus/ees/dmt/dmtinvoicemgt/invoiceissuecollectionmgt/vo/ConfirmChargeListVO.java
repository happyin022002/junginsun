/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ConfirmChargeListVO.java
*@FileTitle : ConfirmChargeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ConfirmChargeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConfirmChargeListVO> models = new ArrayList<ConfirmChargeListVO>();
	
	/* Column Info */
	private String chgCustSeq = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String invTaxAmt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String invTaxRto = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String gb = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String dmdtInvStsCd = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String errCode = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String checkBox = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */ 
	private String errMsg = null;
	/* Column Info */
	private String invPayableAmt = null;
	/* Column Info */
	private String chgCustCntCd = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String checkSeq = null;
	/* Column Info */
	private String dmdtDeltRqstStsCd = null;
	/* Column Info */
	private String idaHighEduTaxRt = null;
	/* Column Info */
	private String idaExpnTaxRt = null;
	/* Column Info */
	private String idaExpnTax = null;
	/* Column Info */
	private String idaEduTax = null;
	/* Column Info */
	private String idaHighEduTax = null;
	/* Column Info */
	private String idaEduTaxRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ConfirmChargeListVO() {}

	public ConfirmChargeListVO(String ibflag, String pagerows, String checkBox, String checkSeq, String bkgNo, String blNo, String cntrCnt, String gb, String cntrNo, String ofcCd, String dmdtTrfCd, String actCntCd, String actCustSeq, String custCd, String custNm, String scNo, String rfaNo, String arCurrCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String porCd, String delCd, String invAmt, String bzcTrfCurrCd, String orgChgAmt, String scRfaExptAmt, String aftExptDcAmt, String bilAmt, String invXchRt, String dmdtInvNo, String dmdtInvStsCd, String dmdtArIfCd, String invTaxRto, String invTaxAmt, String invPayableAmt, String errCode, String errMsg, String chgCustCntCd, String chgCustSeq, String dmdtChgLocDivCd, String dmdtDeltRqstStsCd, String idaExpnTaxRt, String idaExpnTax, String idaEduTaxRt, String idaEduTax, String idaHighEduTaxRt, String idaHighEduTax) {		
		this.chgCustSeq = chgCustSeq;
		this.porCd = porCd;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.vslCd = vslCd;
		this.invTaxAmt = invTaxAmt;
		this.custNm = custNm;
		this.scRfaExptAmt = scRfaExptAmt;
		this.aftExptDcAmt = aftExptDcAmt;
		this.invTaxRto = invTaxRto;
		this.bilAmt = bilAmt;
		this.blNo = blNo;
		this.gb = gb;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.actCntCd = actCntCd;
		this.scNo = scNo;
		this.invAmt = invAmt;
		this.invXchRt = invXchRt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.dmdtInvStsCd = dmdtInvStsCd;
		this.arCurrCd = arCurrCd;
		this.dmdtInvNo = dmdtInvNo;
		this.actCustSeq = actCustSeq;
		this.errCode = errCode;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.cntrCnt = cntrCnt;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.checkBox = checkBox;
		this.cntrNo = cntrNo;
		this.custCd = custCd;
		this.errMsg = errMsg;
		this.invPayableAmt = invPayableAmt;
		this.chgCustCntCd = chgCustCntCd;
		this.dmdtArIfCd = dmdtArIfCd;
		this.orgChgAmt = orgChgAmt;
		this.checkSeq = checkSeq;
		this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
		this.idaHighEduTaxRt = idaHighEduTaxRt;
		this.idaExpnTaxRt = idaExpnTaxRt;
		this.idaExpnTax = idaExpnTax;
		this.idaEduTax = idaEduTax;
		this.idaHighEduTax = idaHighEduTax;
		this.idaEduTaxRt = idaEduTaxRt;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_cust_seq", getChgCustSeq());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("inv_tax_amt", getInvTaxAmt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("inv_tax_rto", getInvTaxRto());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("gb", getGb());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("dmdt_inv_sts_cd", getDmdtInvStsCd());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("check_box", getCheckBox());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("inv_payable_amt", getInvPayableAmt());
		this.hashColumns.put("chg_cust_cnt_cd", getChgCustCntCd());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("check_seq", getCheckSeq());
		this.hashColumns.put("dmdt_delt_rqst_sts_cd", getDmdtDeltRqstStsCd());
		this.hashColumns.put("ida_high_edu_tax_rt", getIdaHighEduTaxRt());
		this.hashColumns.put("ida_expn_tax_rt", getIdaExpnTaxRt());
		this.hashColumns.put("ida_expn_tax", getIdaExpnTax());
		this.hashColumns.put("ida_edu_tax", getIdaEduTax());
		this.hashColumns.put("ida_high_edu_tax", getIdaHighEduTax());
		this.hashColumns.put("ida_edu_tax_rt", getIdaEduTaxRt());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_cust_seq", "chgCustSeq");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("inv_tax_amt", "invTaxAmt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("inv_tax_rto", "invTaxRto");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("gb", "gb");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("dmdt_inv_sts_cd", "dmdtInvStsCd");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("check_box", "checkBox");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("inv_payable_amt", "invPayableAmt");
		this.hashFields.put("chg_cust_cnt_cd", "chgCustCntCd");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("check_seq", "checkSeq");
		this.hashFields.put("dmdt_delt_rqst_sts_cd", "dmdtDeltRqstStsCd");
		this.hashFields.put("ida_high_edu_tax_rt", "idaHighEduTaxRt");
		this.hashFields.put("ida_expn_tax_rt", "idaExpnTaxRt");
		this.hashFields.put("ida_expn_tax", "idaExpnTax");
		this.hashFields.put("ida_edu_tax", "idaEduTax");
		this.hashFields.put("ida_high_edu_tax", "idaHighEduTax");
		this.hashFields.put("ida_edu_tax_rt", "idaEduTaxRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgCustSeq
	 */
	public String getChgCustSeq() {
		return this.chgCustSeq;
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
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
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
	 * @return invTaxAmt
	 */
	public String getInvTaxAmt() {
		return this.invTaxAmt;
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
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @return aftExptDcAmt
	 */
	public String getAftExptDcAmt() {
		return this.aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @return invTaxRto
	 */
	public String getInvTaxRto() {
		return this.invTaxRto;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return gb
	 */
	public String getGb() {
		return this.gb;
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
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvStsCd
	 */
	public String getDmdtInvStsCd() {
		return this.dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
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
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return checkBox
	 */
	public String getCheckBox() {
		return this.checkBox;
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
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return invPayableAmt
	 */
	public String getInvPayableAmt() {
		return this.invPayableAmt;
	}
	
	/**
	 * Column Info
	 * @return chgCustCntCd
	 */
	public String getChgCustCntCd() {
		return this.chgCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @return checkSeq
	 */
	public String getCheckSeq() {
		return this.checkSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeltRqstStsCd
	 */	
	public String getDmdtDeltRqstStsCd() {
		return dmdtDeltRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param chgCustSeq
	 */
	public void setChgCustSeq(String chgCustSeq) {
		this.chgCustSeq = chgCustSeq;
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
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
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
	 * @param invTaxAmt
	 */
	public void setInvTaxAmt(String invTaxAmt) {
		this.invTaxAmt = invTaxAmt;
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
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @param aftExptDcAmt
	 */
	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @param invTaxRto
	 */
	public void setInvTaxRto(String invTaxRto) {
		this.invTaxRto = invTaxRto;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param gb
	 */
	public void setGb(String gb) {
		this.gb = gb;
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
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvStsCd
	 */
	public void setDmdtInvStsCd(String dmdtInvStsCd) {
		this.dmdtInvStsCd = dmdtInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
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
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param checkBox
	 */
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
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
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param invPayableAmt
	 */
	public void setInvPayableAmt(String invPayableAmt) {
		this.invPayableAmt = invPayableAmt;
	}
	
	/**
	 * Column Info
	 * @param chgCustCntCd
	 */
	public void setChgCustCntCd(String chgCustCntCd) {
		this.chgCustCntCd = chgCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @param checkSeq
	 */
	public void setCheckSeq(String checkSeq) {
		this.checkSeq = checkSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeltRqstStsCd
	 */	
	public void setDmdtDeltRqstStsCd(String dmdtDeltRqstStsCd) {
		this.dmdtDeltRqstStsCd = dmdtDeltRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return idaHighEduTaxRt
	 */
	public String getIdaHighEduTaxRt() {
		return this.idaHighEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @return idaExpnTaxRt
	 */
	public String getIdaExpnTaxRt() {
		return this.idaExpnTaxRt;
	}
	
	/**
	 * Column Info
	 * @return idaExpnTax
	 */
	public String getIdaExpnTax() {
		return this.idaExpnTax;
	}
	
	/**
	 * Column Info
	 * @return idaEduTax
	 */
	public String getIdaEduTax() {
		return this.idaEduTax;
	}
	
	/**
	 * Column Info
	 * @return idaHighEduTax
	 */
	public String getIdaHighEduTax() {
		return this.idaHighEduTax;
	}
	
	/**
	 * Column Info
	 * @return idaEduTaxRt
	 */
	public String getIdaEduTaxRt() {
		return this.idaEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaHighEduTaxRt
	 */
	public void setIdaHighEduTaxRt(String idaHighEduTaxRt) {
		this.idaHighEduTaxRt = idaHighEduTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaExpnTaxRt
	 */
	public void setIdaExpnTaxRt(String idaExpnTaxRt) {
		this.idaExpnTaxRt = idaExpnTaxRt;
	}
	
	/**
	 * Column Info
	 * @param idaExpnTax
	 */
	public void setIdaExpnTax(String idaExpnTax) {
		this.idaExpnTax = idaExpnTax;
	}
	
	/**
	 * Column Info
	 * @param idaEduTax
	 */
	public void setIdaEduTax(String idaEduTax) {
		this.idaEduTax = idaEduTax;
	}
	
	/**
	 * Column Info
	 * @param idaHighEduTax
	 */
	public void setIdaHighEduTax(String idaHighEduTax) {
		this.idaHighEduTax = idaHighEduTax;
	}
	
	/**
	 * Column Info
	 * @param idaEduTaxRt
	 */
	public void setIdaEduTaxRt(String idaEduTaxRt) {
		this.idaEduTaxRt = idaEduTaxRt;
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
		setChgCustSeq(JSPUtil.getParameter(request, prefix + "chg_cust_seq", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setInvTaxAmt(JSPUtil.getParameter(request, prefix + "inv_tax_amt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
		setInvTaxRto(JSPUtil.getParameter(request, prefix + "inv_tax_rto", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setGb(JSPUtil.getParameter(request, prefix + "gb", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setDmdtInvStsCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_cd", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCheckBox(JSPUtil.getParameter(request, prefix + "check_box", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setInvPayableAmt(JSPUtil.getParameter(request, prefix + "inv_payable_amt", ""));
		setChgCustCntCd(JSPUtil.getParameter(request, prefix + "chg_cust_cnt_cd", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
		setCheckSeq(JSPUtil.getParameter(request, prefix + "check_seq", ""));
		setDmdtDeltRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_delt_rqst_sts_cd", ""));
		setIdaHighEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax_rt", ""));
		setIdaExpnTaxRt(JSPUtil.getParameter(request, prefix + "ida_expn_tax_rt", ""));
		setIdaExpnTax(JSPUtil.getParameter(request, prefix + "ida_expn_tax", ""));
		setIdaEduTax(JSPUtil.getParameter(request, prefix + "ida_edu_tax", ""));
		setIdaHighEduTax(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax", ""));
		setIdaEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_edu_tax_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConfirmChargeListVO[]
	 */
	public ConfirmChargeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConfirmChargeListVO[]
	 */
	public ConfirmChargeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConfirmChargeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgCustSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cust_seq", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] invTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_amt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] invTaxRto = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rto", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] gb = (JSPUtil.getParameter(request, prefix	+ "gb", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] dmdtInvStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_sts_cd", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] checkBox = (JSPUtil.getParameter(request, prefix	+ "check_box", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] invPayableAmt = (JSPUtil.getParameter(request, prefix	+ "inv_payable_amt", length));
			String[] chgCustCntCd = (JSPUtil.getParameter(request, prefix	+ "chg_cust_cnt_cd", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] checkSeq = (JSPUtil.getParameter(request, prefix	+ "check_seq", length));
			String[] dmdtDeltRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_delt_rqst_sts_cd", length));
			String[] idaHighEduTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_high_edu_tax_rt", length));
			String[] idaExpnTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_expn_tax_rt", length));
			String[] idaExpnTax = (JSPUtil.getParameter(request, prefix	+ "ida_expn_tax", length));
			String[] idaEduTax = (JSPUtil.getParameter(request, prefix	+ "ida_edu_tax", length));
			String[] idaHighEduTax = (JSPUtil.getParameter(request, prefix	+ "ida_high_edu_tax", length));
			String[] idaEduTaxRt = (JSPUtil.getParameter(request, prefix	+ "ida_edu_tax_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ConfirmChargeListVO();
				if (chgCustSeq[i] != null)
					model.setChgCustSeq(chgCustSeq[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (invTaxAmt[i] != null)
					model.setInvTaxAmt(invTaxAmt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (invTaxRto[i] != null)
					model.setInvTaxRto(invTaxRto[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (gb[i] != null)
					model.setGb(gb[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (dmdtInvStsCd[i] != null)
					model.setDmdtInvStsCd(dmdtInvStsCd[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (checkBox[i] != null)
					model.setCheckBox(checkBox[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (invPayableAmt[i] != null)
					model.setInvPayableAmt(invPayableAmt[i]);
				if (chgCustCntCd[i] != null)
					model.setChgCustCntCd(chgCustCntCd[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (checkSeq[i] != null)
					model.setCheckSeq(checkSeq[i]);
				if (dmdtDeltRqstStsCd[i] != null)
					model.setDmdtDeltRqstStsCd(dmdtDeltRqstStsCd[i]);
				if (idaHighEduTaxRt[i] != null)
					model.setIdaHighEduTaxRt(idaHighEduTaxRt[i]);
				if (idaExpnTaxRt[i] != null)
					model.setIdaExpnTaxRt(idaExpnTaxRt[i]);
				if (idaExpnTax[i] != null)
					model.setIdaExpnTax(idaExpnTax[i]);
				if (idaEduTax[i] != null)
					model.setIdaEduTax(idaEduTax[i]);
				if (idaHighEduTax[i] != null)
					model.setIdaHighEduTax(idaHighEduTax[i]);
				if (idaEduTaxRt[i] != null)
					model.setIdaEduTaxRt(idaEduTaxRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConfirmChargeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConfirmChargeListVO[]
	 */
	public ConfirmChargeListVO[] getConfirmChargeListVOs(){
		ConfirmChargeListVO[] vos = (ConfirmChargeListVO[])models.toArray(new ConfirmChargeListVO[models.size()]);
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
		this.chgCustSeq = this.chgCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxAmt = this.invTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRto = this.invTaxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gb = this.gb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvStsCd = this.dmdtInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkBox = this.checkBox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayableAmt = this.invPayableAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCustCntCd = this.chgCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkSeq = this.checkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeltRqstStsCd = this.dmdtDeltRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHighEduTaxRt = this.idaHighEduTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaExpnTaxRt = this.idaExpnTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaExpnTax = this.idaExpnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaEduTax = this.idaEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHighEduTax = this.idaHighEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaEduTaxRt = this.idaEduTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
