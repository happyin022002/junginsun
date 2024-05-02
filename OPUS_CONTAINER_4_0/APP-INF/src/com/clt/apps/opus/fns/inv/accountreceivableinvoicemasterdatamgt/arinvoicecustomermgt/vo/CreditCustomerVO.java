/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreditCustomerVO.java
*@FileTitle : CreditCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.12.10 한동훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreditCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreditCustomerVO> models = new ArrayList<CreditCustomerVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cngIndivCd = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String crStDt = null;
	/* Column Info */
	private String custScrLoclAmt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String ibEml = null;
	/* Column Info */
	private String scrEndDt = null;
	/* Column Info */
	private String custLglEngNm2 = null;
	/* Column Info */
	private String obFaxNo = null;
	/* Column Info */
	private String custRgstNo2 = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String custRmk = null;
	/* Column Info */
	private String crCustRmk = null;
	/* Column Info */
	private String obPhnNo = null;
	/* Column Info */
	private String loclZipCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String xchRtDivCd = null;
	/* Column Info */
	private String issDivCd = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String crCustTpCd = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String obEml = null;
	/* Column Info */
	private String custCrDueDtDivCd = null;
	/* Column Info */
	private String custScrDivCd = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String payDtDy4 = null;
	/* Column Info */
	private String payDtDy3 = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String payDtDy2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payDtDy1 = null;
	/* Column Info */
	private String loclAddr4 = null;
	/* Column Info */
	private String loclAddr3 = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String loclAddr2 = null;
	/* Column Info */
	private String loclAddr1 = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String payDivCd = null;
	/* Column Info */
	private String invDueDtDpFlg = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String custRlseCtrlFlg = null;
	/* Column Info */
	private String scrStDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String krIbOfcCd = null;
	/* Column Info */
	private String tvaNo = null;
	/* Column Info */
	private String crEndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreditCustomerVO() {}

	public CreditCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String custLglEngNm, String custLglEngNm2, String custRgstNo, String custRgstNo2, String bzetAddr, String zipCd, String phnNo, String faxNo, String ofcCd, String cntCd, String steNm, String ctyNm, String custRmk, String crCurrCd, String crAmt, String crStDt, String crEndDt, String crCltOfcCd, String ibCrTermDys, String obCrTermDys, String custRlseCtrlFlg, String cntcPsonNm, String xchRtDivCd, String cngIndivCd, String actCustCntCd, String actCustSeq, String obEml, String ibEml, String crCustRmk, String payDivCd, String bankAcctNo, String ownrNm, String tvaNo, String bzctNm, String bztpNm, String loclNm, String indivCorpDivCd, String loclAddr1, String loclAddr2, String loclAddr3, String loclAddr4, String crCustTpCd, String krIbOfcCd, String loclZipCd, String obPhnNo, String obFaxNo, String custScrDivCd, String custScrLoclAmt, String scrStDt, String scrEndDt, String issDivCd, String custCrDueDtDivCd, String payDtDy1, String payDtDy2, String payDtDy3, String payDtDy4, String deltFlg, String invDueDtDpFlg) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.bzctNm = bzctNm;
		this.bztpNm = bztpNm;
		this.bzetAddr = bzetAddr;
		this.obCrTermDys = obCrTermDys;
		this.pagerows = pagerows;
		this.cngIndivCd = cngIndivCd;
		this.crAmt = crAmt;
		this.cntCd = cntCd;
		this.crStDt = crStDt;
		this.custScrLoclAmt = custScrLoclAmt;
		this.custCntCd = custCntCd;
		this.phnNo = phnNo;
		this.ibEml = ibEml;
		this.scrEndDt = scrEndDt;
		this.custLglEngNm2 = custLglEngNm2;
		this.obFaxNo = obFaxNo;
		this.custRgstNo2 = custRgstNo2;
		this.custLglEngNm = custLglEngNm;
		this.custRmk = custRmk;
		this.crCustRmk = crCustRmk;
		this.obPhnNo = obPhnNo;
		this.loclZipCd = loclZipCd;
		this.zipCd = zipCd;
		this.faxNo = faxNo;
		this.ctyNm = ctyNm;
		this.ownrNm = ownrNm;
		this.xchRtDivCd = xchRtDivCd;
		this.issDivCd = issDivCd;
		this.bankAcctNo = bankAcctNo;
		this.loclNm = loclNm;
		this.deltFlg = deltFlg;
		this.crCustTpCd = crCustTpCd;
		this.custRgstNo = custRgstNo;
		this.obEml = obEml;
		this.custCrDueDtDivCd = custCrDueDtDivCd;
		this.custScrDivCd = custScrDivCd;
		this.crCltOfcCd = crCltOfcCd;
		this.payDtDy4 = payDtDy4;
		this.payDtDy3 = payDtDy3;
		this.ibCrTermDys = ibCrTermDys;
		this.payDtDy2 = payDtDy2;
		this.ibflag = ibflag;
		this.payDtDy1 = payDtDy1;
		this.loclAddr4 = loclAddr4;
		this.loclAddr3 = loclAddr3;
		this.cntcPsonNm = cntcPsonNm;
		this.loclAddr2 = loclAddr2;
		this.loclAddr1 = loclAddr1;
		this.actCustCntCd = actCustCntCd;
		this.payDivCd = payDivCd;
		this.invDueDtDpFlg = invDueDtDpFlg;
		this.actCustSeq = actCustSeq;
		this.custSeq = custSeq;
		this.crCurrCd = crCurrCd;
		this.custRlseCtrlFlg = custRlseCtrlFlg;
		this.scrStDt = scrStDt;
		this.ofcCd = ofcCd;
		this.steNm = steNm;
		this.krIbOfcCd = krIbOfcCd;
		this.tvaNo = tvaNo;
		this.crEndDt = crEndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cng_indiv_cd", getCngIndivCd());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cr_st_dt", getCrStDt());
		this.hashColumns.put("cust_scr_locl_amt", getCustScrLoclAmt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("ib_eml", getIbEml());
		this.hashColumns.put("scr_end_dt", getScrEndDt());
		this.hashColumns.put("cust_lgl_eng_nm2", getCustLglEngNm2());
		this.hashColumns.put("ob_fax_no", getObFaxNo());
		this.hashColumns.put("cust_rgst_no2", getCustRgstNo2());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cust_rmk", getCustRmk());
		this.hashColumns.put("cr_cust_rmk", getCrCustRmk());
		this.hashColumns.put("ob_phn_no", getObPhnNo());
		this.hashColumns.put("locl_zip_cd", getLoclZipCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("xch_rt_div_cd", getXchRtDivCd());
		this.hashColumns.put("iss_div_cd", getIssDivCd());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cr_cust_tp_cd", getCrCustTpCd());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("ob_eml", getObEml());
		this.hashColumns.put("cust_cr_due_dt_div_cd", getCustCrDueDtDivCd());
		this.hashColumns.put("cust_scr_div_cd", getCustScrDivCd());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("pay_dt_dy4", getPayDtDy4());
		this.hashColumns.put("pay_dt_dy3", getPayDtDy3());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("pay_dt_dy2", getPayDtDy2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pay_dt_dy1", getPayDtDy1());
		this.hashColumns.put("locl_addr4", getLoclAddr4());
		this.hashColumns.put("locl_addr3", getLoclAddr3());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("locl_addr2", getLoclAddr2());
		this.hashColumns.put("locl_addr1", getLoclAddr1());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("pay_div_cd", getPayDivCd());
		this.hashColumns.put("inv_due_dt_dp_flg", getInvDueDtDpFlg());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("cust_rlse_ctrl_flg", getCustRlseCtrlFlg());
		this.hashColumns.put("scr_st_dt", getScrStDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("kr_ib_ofc_cd", getKrIbOfcCd());
		this.hashColumns.put("tva_no", getTvaNo());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cng_indiv_cd", "cngIndivCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cr_st_dt", "crStDt");
		this.hashFields.put("cust_scr_locl_amt", "custScrLoclAmt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("ib_eml", "ibEml");
		this.hashFields.put("scr_end_dt", "scrEndDt");
		this.hashFields.put("cust_lgl_eng_nm2", "custLglEngNm2");
		this.hashFields.put("ob_fax_no", "obFaxNo");
		this.hashFields.put("cust_rgst_no2", "custRgstNo2");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_rmk", "custRmk");
		this.hashFields.put("cr_cust_rmk", "crCustRmk");
		this.hashFields.put("ob_phn_no", "obPhnNo");
		this.hashFields.put("locl_zip_cd", "loclZipCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("xch_rt_div_cd", "xchRtDivCd");
		this.hashFields.put("iss_div_cd", "issDivCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cr_cust_tp_cd", "crCustTpCd");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("ob_eml", "obEml");
		this.hashFields.put("cust_cr_due_dt_div_cd", "custCrDueDtDivCd");
		this.hashFields.put("cust_scr_div_cd", "custScrDivCd");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("pay_dt_dy4", "payDtDy4");
		this.hashFields.put("pay_dt_dy3", "payDtDy3");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("pay_dt_dy2", "payDtDy2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_dt_dy1", "payDtDy1");
		this.hashFields.put("locl_addr4", "loclAddr4");
		this.hashFields.put("locl_addr3", "loclAddr3");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("locl_addr2", "loclAddr2");
		this.hashFields.put("locl_addr1", "loclAddr1");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("pay_div_cd", "payDivCd");
		this.hashFields.put("inv_due_dt_dp_flg", "invDueDtDpFlg");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("cust_rlse_ctrl_flg", "custRlseCtrlFlg");
		this.hashFields.put("scr_st_dt", "scrStDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("kr_ib_ofc_cd", "krIbOfcCd");
		this.hashFields.put("tva_no", "tvaNo");
		this.hashFields.put("cr_end_dt", "crEndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return indivCorpDivCd
	 */
	public String getIndivCorpDivCd() {
		return this.indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return bztpNm
	 */
	public String getBztpNm() {
		return this.bztpNm;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
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
	 * @return cngIndivCd
	 */
	public String getCngIndivCd() {
		return this.cngIndivCd;
	}
	
	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return crStDt
	 */
	public String getCrStDt() {
		return this.crStDt;
	}
	
	/**
	 * Column Info
	 * @return custScrLoclAmt
	 */
	public String getCustScrLoclAmt() {
		return this.custScrLoclAmt;
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return ibEml
	 */
	public String getIbEml() {
		return this.ibEml;
	}
	
	/**
	 * Column Info
	 * @return scrEndDt
	 */
	public String getScrEndDt() {
		return this.scrEndDt;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm2
	 */
	public String getCustLglEngNm2() {
		return this.custLglEngNm2;
	}
	
	/**
	 * Column Info
	 * @return obFaxNo
	 */
	public String getObFaxNo() {
		return this.obFaxNo;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo2
	 */
	public String getCustRgstNo2() {
		return this.custRgstNo2;
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
	 * @return custRmk
	 */
	public String getCustRmk() {
		return this.custRmk;
	}
	
	/**
	 * Column Info
	 * @return crCustRmk
	 */
	public String getCrCustRmk() {
		return this.crCustRmk;
	}
	
	/**
	 * Column Info
	 * @return obPhnNo
	 */
	public String getObPhnNo() {
		return this.obPhnNo;
	}
	
	/**
	 * Column Info
	 * @return loclZipCd
	 */
	public String getLoclZipCd() {
		return this.loclZipCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return xchRtDivCd
	 */
	public String getXchRtDivCd() {
		return this.xchRtDivCd;
	}
	
	/**
	 * Column Info
	 * @return issDivCd
	 */
	public String getIssDivCd() {
		return this.issDivCd;
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
	 * @return loclNm
	 */
	public String getLoclNm() {
		return this.loclNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return crCustTpCd
	 */
	public String getCrCustTpCd() {
		return this.crCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	
	/**
	 * Column Info
	 * @return obEml
	 */
	public String getObEml() {
		return this.obEml;
	}
	
	/**
	 * Column Info
	 * @return custCrDueDtDivCd
	 */
	public String getCustCrDueDtDivCd() {
		return this.custCrDueDtDivCd;
	}
	
	/**
	 * Column Info
	 * @return custScrDivCd
	 */
	public String getCustScrDivCd() {
		return this.custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return payDtDy4
	 */
	public String getPayDtDy4() {
		return this.payDtDy4;
	}
	
	/**
	 * Column Info
	 * @return payDtDy3
	 */
	public String getPayDtDy3() {
		return this.payDtDy3;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return payDtDy2
	 */
	public String getPayDtDy2() {
		return this.payDtDy2;
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
	 * @return payDtDy1
	 */
	public String getPayDtDy1() {
		return this.payDtDy1;
	}
	
	/**
	 * Column Info
	 * @return loclAddr4
	 */
	public String getLoclAddr4() {
		return this.loclAddr4;
	}
	
	/**
	 * Column Info
	 * @return loclAddr3
	 */
	public String getLoclAddr3() {
		return this.loclAddr3;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return loclAddr2
	 */
	public String getLoclAddr2() {
		return this.loclAddr2;
	}
	
	/**
	 * Column Info
	 * @return loclAddr1
	 */
	public String getLoclAddr1() {
		return this.loclAddr1;
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
	 * @return payDivCd
	 */
	public String getPayDivCd() {
		return this.payDivCd;
	}
	
	/**
	 * Column Info
	 * @return invDueDtDpFlg
	 */
	public String getInvDueDtDpFlg() {
		return this.invDueDtDpFlg;
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
	 * @return crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 * Column Info
	 * @return custRlseCtrlFlg
	 */
	public String getCustRlseCtrlFlg() {
		return this.custRlseCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @return scrStDt
	 */
	public String getScrStDt() {
		return this.scrStDt;
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
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
	}
	
	/**
	 * Column Info
	 * @return krIbOfcCd
	 */
	public String getKrIbOfcCd() {
		return this.krIbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tvaNo
	 */
	public String getTvaNo() {
		return this.tvaNo;
	}
	
	/**
	 * Column Info
	 * @return crEndDt
	 */
	public String getCrEndDt() {
		return this.crEndDt;
	}
	

	/**
	 * Column Info
	 * @param indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param bztpNm
	 */
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
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
	 * @param cngIndivCd
	 */
	public void setCngIndivCd(String cngIndivCd) {
		this.cngIndivCd = cngIndivCd;
	}
	
	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param crStDt
	 */
	public void setCrStDt(String crStDt) {
		this.crStDt = crStDt;
	}
	
	/**
	 * Column Info
	 * @param custScrLoclAmt
	 */
	public void setCustScrLoclAmt(String custScrLoclAmt) {
		this.custScrLoclAmt = custScrLoclAmt;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param ibEml
	 */
	public void setIbEml(String ibEml) {
		this.ibEml = ibEml;
	}
	
	/**
	 * Column Info
	 * @param scrEndDt
	 */
	public void setScrEndDt(String scrEndDt) {
		this.scrEndDt = scrEndDt;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm2
	 */
	public void setCustLglEngNm2(String custLglEngNm2) {
		this.custLglEngNm2 = custLglEngNm2;
	}
	
	/**
	 * Column Info
	 * @param obFaxNo
	 */
	public void setObFaxNo(String obFaxNo) {
		this.obFaxNo = obFaxNo;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo2
	 */
	public void setCustRgstNo2(String custRgstNo2) {
		this.custRgstNo2 = custRgstNo2;
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
	 * @param custRmk
	 */
	public void setCustRmk(String custRmk) {
		this.custRmk = custRmk;
	}
	
	/**
	 * Column Info
	 * @param crCustRmk
	 */
	public void setCrCustRmk(String crCustRmk) {
		this.crCustRmk = crCustRmk;
	}
	
	/**
	 * Column Info
	 * @param obPhnNo
	 */
	public void setObPhnNo(String obPhnNo) {
		this.obPhnNo = obPhnNo;
	}
	
	/**
	 * Column Info
	 * @param loclZipCd
	 */
	public void setLoclZipCd(String loclZipCd) {
		this.loclZipCd = loclZipCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param xchRtDivCd
	 */
	public void setXchRtDivCd(String xchRtDivCd) {
		this.xchRtDivCd = xchRtDivCd;
	}
	
	/**
	 * Column Info
	 * @param issDivCd
	 */
	public void setIssDivCd(String issDivCd) {
		this.issDivCd = issDivCd;
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
	 * @param loclNm
	 */
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param crCustTpCd
	 */
	public void setCrCustTpCd(String crCustTpCd) {
		this.crCustTpCd = crCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	
	/**
	 * Column Info
	 * @param obEml
	 */
	public void setObEml(String obEml) {
		this.obEml = obEml;
	}
	
	/**
	 * Column Info
	 * @param custCrDueDtDivCd
	 */
	public void setCustCrDueDtDivCd(String custCrDueDtDivCd) {
		this.custCrDueDtDivCd = custCrDueDtDivCd;
	}
	
	/**
	 * Column Info
	 * @param custScrDivCd
	 */
	public void setCustScrDivCd(String custScrDivCd) {
		this.custScrDivCd = custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param payDtDy4
	 */
	public void setPayDtDy4(String payDtDy4) {
		this.payDtDy4 = payDtDy4;
	}
	
	/**
	 * Column Info
	 * @param payDtDy3
	 */
	public void setPayDtDy3(String payDtDy3) {
		this.payDtDy3 = payDtDy3;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param payDtDy2
	 */
	public void setPayDtDy2(String payDtDy2) {
		this.payDtDy2 = payDtDy2;
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
	 * @param payDtDy1
	 */
	public void setPayDtDy1(String payDtDy1) {
		this.payDtDy1 = payDtDy1;
	}
	
	/**
	 * Column Info
	 * @param loclAddr4
	 */
	public void setLoclAddr4(String loclAddr4) {
		this.loclAddr4 = loclAddr4;
	}
	
	/**
	 * Column Info
	 * @param loclAddr3
	 */
	public void setLoclAddr3(String loclAddr3) {
		this.loclAddr3 = loclAddr3;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param loclAddr2
	 */
	public void setLoclAddr2(String loclAddr2) {
		this.loclAddr2 = loclAddr2;
	}
	
	/**
	 * Column Info
	 * @param loclAddr1
	 */
	public void setLoclAddr1(String loclAddr1) {
		this.loclAddr1 = loclAddr1;
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
	 * @param payDivCd
	 */
	public void setPayDivCd(String payDivCd) {
		this.payDivCd = payDivCd;
	}
	
	/**
	 * Column Info
	 * @param invDueDtDpFlg
	 */
	public void setInvDueDtDpFlg(String invDueDtDpFlg) {
		this.invDueDtDpFlg = invDueDtDpFlg;
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
	 * @param crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * Column Info
	 * @param custRlseCtrlFlg
	 */
	public void setCustRlseCtrlFlg(String custRlseCtrlFlg) {
		this.custRlseCtrlFlg = custRlseCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @param scrStDt
	 */
	public void setScrStDt(String scrStDt) {
		this.scrStDt = scrStDt;
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
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @param krIbOfcCd
	 */
	public void setKrIbOfcCd(String krIbOfcCd) {
		this.krIbOfcCd = krIbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tvaNo
	 */
	public void setTvaNo(String tvaNo) {
		this.tvaNo = tvaNo;
	}
	
	/**
	 * Column Info
	 * @param crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIndivCorpDivCd(JSPUtil.getParameter(request, "indiv_corp_div_cd", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setBzetAddr(JSPUtil.getParameter(request, "bzet_addr", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCngIndivCd(JSPUtil.getParameter(request, "cng_indiv_cd", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCrStDt(JSPUtil.getParameter(request, "cr_st_dt", ""));
		setCustScrLoclAmt(JSPUtil.getParameter(request, "cust_scr_locl_amt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setIbEml(JSPUtil.getParameter(request, "ib_eml", ""));
		setScrEndDt(JSPUtil.getParameter(request, "scr_end_dt", ""));
		setCustLglEngNm2(JSPUtil.getParameter(request, "cust_lgl_eng_nm2", ""));
		setObFaxNo(JSPUtil.getParameter(request, "ob_fax_no", ""));
		setCustRgstNo2(JSPUtil.getParameter(request, "cust_rgst_no2", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setCustRmk(JSPUtil.getParameter(request, "cust_rmk", ""));
		setCrCustRmk(JSPUtil.getParameter(request, "cr_cust_rmk", ""));
		setObPhnNo(JSPUtil.getParameter(request, "ob_phn_no", ""));
		setLoclZipCd(JSPUtil.getParameter(request, "locl_zip_cd", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request, "cty_nm", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setXchRtDivCd(JSPUtil.getParameter(request, "xch_rt_div_cd", ""));
		setIssDivCd(JSPUtil.getParameter(request, "iss_div_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request, "bank_acct_no", ""));
		setLoclNm(JSPUtil.getParameter(request, "locl_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCrCustTpCd(JSPUtil.getParameter(request, "cr_cust_tp_cd", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setObEml(JSPUtil.getParameter(request, "ob_eml", ""));
		setCustCrDueDtDivCd(JSPUtil.getParameter(request, "cust_cr_due_dt_div_cd", ""));
		setCustScrDivCd(JSPUtil.getParameter(request, "cust_scr_div_cd", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setPayDtDy4(JSPUtil.getParameter(request, "pay_dt_dy4", ""));
		setPayDtDy3(JSPUtil.getParameter(request, "pay_dt_dy3", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setPayDtDy2(JSPUtil.getParameter(request, "pay_dt_dy2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPayDtDy1(JSPUtil.getParameter(request, "pay_dt_dy1", ""));
		setLoclAddr4(JSPUtil.getParameter(request, "locl_addr4", ""));
		setLoclAddr3(JSPUtil.getParameter(request, "locl_addr3", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setLoclAddr2(JSPUtil.getParameter(request, "locl_addr2", ""));
		setLoclAddr1(JSPUtil.getParameter(request, "locl_addr1", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setPayDivCd(JSPUtil.getParameter(request, "pay_div_cd", ""));
		setInvDueDtDpFlg(JSPUtil.getParameter(request, "inv_due_dt_dp_flg", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setCustRlseCtrlFlg(JSPUtil.getParameter(request, "cust_rlse_ctrl_flg", ""));
		setScrStDt(JSPUtil.getParameter(request, "scr_st_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSteNm(JSPUtil.getParameter(request, "ste_nm", ""));
		setKrIbOfcCd(JSPUtil.getParameter(request, "kr_ib_ofc_cd", ""));
		setTvaNo(JSPUtil.getParameter(request, "tva_no", ""));
		setCrEndDt(JSPUtil.getParameter(request, "cr_end_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreditCustomerVO[]
	 */
	public CreditCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreditCustomerVO[]
	 */
	public CreditCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreditCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cngIndivCd = (JSPUtil.getParameter(request, prefix	+ "cng_indiv_cd", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] crStDt = (JSPUtil.getParameter(request, prefix	+ "cr_st_dt", length));
			String[] custScrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_locl_amt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] ibEml = (JSPUtil.getParameter(request, prefix	+ "ib_eml", length));
			String[] scrEndDt = (JSPUtil.getParameter(request, prefix	+ "scr_end_dt", length));
			String[] custLglEngNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm2", length));
			String[] obFaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_fax_no", length));
			String[] custRgstNo2 = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no2", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] custRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rmk", length));
			String[] crCustRmk = (JSPUtil.getParameter(request, prefix	+ "cr_cust_rmk", length));
			String[] obPhnNo = (JSPUtil.getParameter(request, prefix	+ "ob_phn_no", length));
			String[] loclZipCd = (JSPUtil.getParameter(request, prefix	+ "locl_zip_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] xchRtDivCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_div_cd", length));
			String[] issDivCd = (JSPUtil.getParameter(request, prefix	+ "iss_div_cd", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] crCustTpCd = (JSPUtil.getParameter(request, prefix	+ "cr_cust_tp_cd", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] obEml = (JSPUtil.getParameter(request, prefix	+ "ob_eml", length));
			String[] custCrDueDtDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_cr_due_dt_div_cd", length));
			String[] custScrDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_scr_div_cd", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] payDtDy4 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy4", length));
			String[] payDtDy3 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy3", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] payDtDy2 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payDtDy1 = (JSPUtil.getParameter(request, prefix	+ "pay_dt_dy1", length));
			String[] loclAddr4 = (JSPUtil.getParameter(request, prefix	+ "locl_addr4", length));
			String[] loclAddr3 = (JSPUtil.getParameter(request, prefix	+ "locl_addr3", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] loclAddr2 = (JSPUtil.getParameter(request, prefix	+ "locl_addr2", length));
			String[] loclAddr1 = (JSPUtil.getParameter(request, prefix	+ "locl_addr1", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] payDivCd = (JSPUtil.getParameter(request, prefix	+ "pay_div_cd", length));
			String[] invDueDtDpFlg = (JSPUtil.getParameter(request, prefix	+ "inv_due_dt_dp_flg", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] custRlseCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_flg", length));
			String[] scrStDt = (JSPUtil.getParameter(request, prefix	+ "scr_st_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] krIbOfcCd = (JSPUtil.getParameter(request, prefix	+ "kr_ib_ofc_cd", length));
			String[] tvaNo = (JSPUtil.getParameter(request, prefix	+ "tva_no", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreditCustomerVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cngIndivCd[i] != null)
					model.setCngIndivCd(cngIndivCd[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (crStDt[i] != null)
					model.setCrStDt(crStDt[i]);
				if (custScrLoclAmt[i] != null)
					model.setCustScrLoclAmt(custScrLoclAmt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (ibEml[i] != null)
					model.setIbEml(ibEml[i]);
				if (scrEndDt[i] != null)
					model.setScrEndDt(scrEndDt[i]);
				if (custLglEngNm2[i] != null)
					model.setCustLglEngNm2(custLglEngNm2[i]);
				if (obFaxNo[i] != null)
					model.setObFaxNo(obFaxNo[i]);
				if (custRgstNo2[i] != null)
					model.setCustRgstNo2(custRgstNo2[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (custRmk[i] != null)
					model.setCustRmk(custRmk[i]);
				if (crCustRmk[i] != null)
					model.setCrCustRmk(crCustRmk[i]);
				if (obPhnNo[i] != null)
					model.setObPhnNo(obPhnNo[i]);
				if (loclZipCd[i] != null)
					model.setLoclZipCd(loclZipCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (xchRtDivCd[i] != null)
					model.setXchRtDivCd(xchRtDivCd[i]);
				if (issDivCd[i] != null)
					model.setIssDivCd(issDivCd[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (crCustTpCd[i] != null)
					model.setCrCustTpCd(crCustTpCd[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (obEml[i] != null)
					model.setObEml(obEml[i]);
				if (custCrDueDtDivCd[i] != null)
					model.setCustCrDueDtDivCd(custCrDueDtDivCd[i]);
				if (custScrDivCd[i] != null)
					model.setCustScrDivCd(custScrDivCd[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (payDtDy4[i] != null)
					model.setPayDtDy4(payDtDy4[i]);
				if (payDtDy3[i] != null)
					model.setPayDtDy3(payDtDy3[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (payDtDy2[i] != null)
					model.setPayDtDy2(payDtDy2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payDtDy1[i] != null)
					model.setPayDtDy1(payDtDy1[i]);
				if (loclAddr4[i] != null)
					model.setLoclAddr4(loclAddr4[i]);
				if (loclAddr3[i] != null)
					model.setLoclAddr3(loclAddr3[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (loclAddr2[i] != null)
					model.setLoclAddr2(loclAddr2[i]);
				if (loclAddr1[i] != null)
					model.setLoclAddr1(loclAddr1[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (payDivCd[i] != null)
					model.setPayDivCd(payDivCd[i]);
				if (invDueDtDpFlg[i] != null)
					model.setInvDueDtDpFlg(invDueDtDpFlg[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (custRlseCtrlFlg[i] != null)
					model.setCustRlseCtrlFlg(custRlseCtrlFlg[i]);
				if (scrStDt[i] != null)
					model.setScrStDt(scrStDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (krIbOfcCd[i] != null)
					model.setKrIbOfcCd(krIbOfcCd[i]);
				if (tvaNo[i] != null)
					model.setTvaNo(tvaNo[i]);
				if (crEndDt[i] != null)
					model.setCrEndDt(crEndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreditCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreditCustomerVO[]
	 */
	public CreditCustomerVO[] getCreditCustomerVOs(){
		CreditCustomerVO[] vos = (CreditCustomerVO[])models.toArray(new CreditCustomerVO[models.size()]);
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
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngIndivCd = this.cngIndivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crStDt = this.crStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrLoclAmt = this.custScrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEml = this.ibEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrEndDt = this.scrEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm2 = this.custLglEngNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obFaxNo = this.obFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo2 = this.custRgstNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRmk = this.custRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCustRmk = this.crCustRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPhnNo = this.obPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclZipCd = this.loclZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDivCd = this.xchRtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivCd = this.issDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCustTpCd = this.crCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obEml = this.obEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrDueDtDivCd = this.custCrDueDtDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrDivCd = this.custScrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy4 = this.payDtDy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy3 = this.payDtDy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy2 = this.payDtDy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtDy1 = this.payDtDy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr4 = this.loclAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr3 = this.loclAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr2 = this.loclAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr1 = this.loclAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDivCd = this.payDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDtDpFlg = this.invDueDtDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlFlg = this.custRlseCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrStDt = this.scrStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krIbOfcCd = this.krIbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaNo = this.tvaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
