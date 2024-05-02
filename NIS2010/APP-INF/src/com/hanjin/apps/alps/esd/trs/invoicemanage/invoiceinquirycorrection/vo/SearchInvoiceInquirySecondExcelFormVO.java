/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchInvoiceInquirySecondExcelFormVO.java
*@FileTitle : SearchInvoiceInquirySecondExcelFormVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.25 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInvoiceInquirySecondExcelFormVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoiceInquirySecondExcelFormVO> models = new ArrayList<SearchInvoiceInquirySecondExcelFormVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String invPayMzdCd = null;
	/* Column Info */
	private String trspInvCalcLgcTpCd = null;
	/* Column Info */
	private String trspInvCalcLgcTpNm = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String invGttlAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String invHldFlg = null;
	/* Column Info */
	private String spInvRmk = null;
	/* Column Info */
	private String tollFeeAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String trspInvAudStsCd = null;
	/* Column Info */
	private String ifSysKndNm = null;
	/* Column Info */
	private String invWhldTaxAmt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String woTotAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invChkTrnsNo = null;
	/* Column Info */
	private String invBzcAmt = null;
	/* Column Info */
	private String trspSoOfcCtyCdSeq = null;
	/* Column Info */
	private String uplnSoFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String invSbcAmt = null;
	/* Column Info */
	private String scgVatAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String trspInvAudStsNm = null;
	/* Column Info */
	private String invVndrNm = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invVatAmt = null;
	/* Column Info */
	private String invTotAmt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String invEtcAddAmt = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String etsStsFlg = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String ifSysKndCd = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String trspWoOfcCtyCdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchInvoiceInquirySecondExcelFormVO() {}

	public SearchInvoiceInquirySecondExcelFormVO(String ibflag, String pagerows, String uplnSoFlg, String payDt, String glDt, String invVndrSeq, String invPayMzdCd, String trspInvCalcLgcTpCd, String trspInvCalcLgcTpNm, String invIssDt, String invGttlAmt, String blNo, String invRcvDt, String vndrNm, String invHldFlg, String spInvRmk, String tollFeeAmt, String invXchRt, String updUsrId, String csrNo, String trspInvAudStsCd, String ifSysKndNm, String invWhldTaxAmt, String eqTpszCd, String negoAmt, String woTotAmt, String creUsrId, String vndrSeq, String invChkTrnsNo, String invBzcAmt, String trspSoOfcCtyCdSeq, String currCd, String scgVatAmt, String eqNo, String creOfcCd, String trspInvAudStsNm, String invVndrNm, String etcAddAmt, String updDt, String invVatAmt, String invTotAmt, String invCurrCd, String bzcAmt, String invEtcAddAmt, String fuelScgAmt, String invNo, String etsStsFlg, String invRmk, String ifSysKndCd, String updUsrNm, String trspWoOfcCtyCdSeq, String invSbcAmt) {
		this.payDt = payDt;
		this.glDt = glDt;
		this.invVndrSeq = invVndrSeq;
		this.invPayMzdCd = invPayMzdCd;
		this.trspInvCalcLgcTpCd = trspInvCalcLgcTpCd;
		this.trspInvCalcLgcTpNm = trspInvCalcLgcTpNm;
		this.invIssDt = invIssDt;
		this.invGttlAmt = invGttlAmt;
		this.blNo = blNo;
		this.invRcvDt = invRcvDt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.invHldFlg = invHldFlg;
		this.spInvRmk = spInvRmk;
		this.tollFeeAmt = tollFeeAmt;
		this.updUsrId = updUsrId;
		this.invXchRt = invXchRt;
		this.csrNo = csrNo;
		this.trspInvAudStsCd = trspInvAudStsCd;
		this.ifSysKndNm = ifSysKndNm;
		this.invWhldTaxAmt = invWhldTaxAmt;
		this.eqTpszCd = eqTpszCd;
		this.negoAmt = negoAmt;
		this.woTotAmt = woTotAmt;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.invChkTrnsNo = invChkTrnsNo;
		this.invBzcAmt = invBzcAmt;
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
		this.uplnSoFlg = uplnSoFlg;
		this.currCd = currCd;
		this.invSbcAmt = invSbcAmt;
		this.scgVatAmt = scgVatAmt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.creOfcCd = creOfcCd;
		this.trspInvAudStsNm = trspInvAudStsNm;
		this.invVndrNm = invVndrNm;
		this.etcAddAmt = etcAddAmt;
		this.updDt = updDt;
		this.invVatAmt = invVatAmt;
		this.invTotAmt = invTotAmt;
		this.invCurrCd = invCurrCd;
		this.bzcAmt = bzcAmt;
		this.invEtcAddAmt = invEtcAddAmt;
		this.fuelScgAmt = fuelScgAmt;
		this.invNo = invNo;
		this.etsStsFlg = etsStsFlg;
		this.invRmk = invRmk;
		this.ifSysKndCd = ifSysKndCd;
		this.updUsrNm = updUsrNm;
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("inv_pay_mzd_cd", getInvPayMzdCd());
		this.hashColumns.put("trsp_inv_calc_lgc_tp_cd", getTrspInvCalcLgcTpCd());
		this.hashColumns.put("trsp_inv_calc_lgc_tp_nm", getTrspInvCalcLgcTpNm());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("inv_gttl_amt", getInvGttlAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("inv_hld_flg", getInvHldFlg());
		this.hashColumns.put("sp_inv_rmk", getSpInvRmk());
		this.hashColumns.put("toll_fee_amt", getTollFeeAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("trsp_inv_aud_sts_cd", getTrspInvAudStsCd());
		this.hashColumns.put("if_sys_knd_nm", getIfSysKndNm());
		this.hashColumns.put("inv_whld_tax_amt", getInvWhldTaxAmt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("wo_tot_amt", getWoTotAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_chk_trns_no", getInvChkTrnsNo());
		this.hashColumns.put("inv_bzc_amt", getInvBzcAmt());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("upln_so_flg", getUplnSoFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("inv_sbc_amt", getInvSbcAmt());
		this.hashColumns.put("scg_vat_amt", getScgVatAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("trsp_inv_aud_sts_nm", getTrspInvAudStsNm());
		this.hashColumns.put("inv_vndr_nm", getInvVndrNm());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());
		this.hashColumns.put("inv_tot_amt", getInvTotAmt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("inv_etc_add_amt", getInvEtcAddAmt());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ets_sts_flg", getEtsStsFlg());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("if_sys_knd_cd", getIfSysKndCd());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("trsp_wo_ofc_cty_cd_seq", getTrspWoOfcCtyCdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("inv_pay_mzd_cd", "invPayMzdCd");
		this.hashFields.put("trsp_inv_calc_lgc_tp_cd", "trspInvCalcLgcTpCd");
		this.hashFields.put("trsp_inv_calc_lgc_tp_nm", "trspInvCalcLgcTpNm");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("inv_gttl_amt", "invGttlAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("inv_hld_flg", "invHldFlg");
		this.hashFields.put("sp_inv_rmk", "spInvRmk");
		this.hashFields.put("toll_fee_amt", "tollFeeAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("trsp_inv_aud_sts_cd", "trspInvAudStsCd");
		this.hashFields.put("if_sys_knd_nm", "ifSysKndNm");
		this.hashFields.put("inv_whld_tax_amt", "invWhldTaxAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("wo_tot_amt", "woTotAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_chk_trns_no", "invChkTrnsNo");
		this.hashFields.put("inv_bzc_amt", "invBzcAmt");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("upln_so_flg", "uplnSoFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("inv_sbc_amt", "invSbcAmt");
		this.hashFields.put("scg_vat_amt", "scgVatAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("trsp_inv_aud_sts_nm", "trspInvAudStsNm");
		this.hashFields.put("inv_vndr_nm", "invVndrNm");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("inv_tot_amt", "invTotAmt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("inv_etc_add_amt", "invEtcAddAmt");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ets_sts_flg", "etsStsFlg");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("if_sys_knd_cd", "ifSysKndCd");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("trsp_wo_ofc_cty_cd_seq", "trspWoOfcCtyCdSeq");
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
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invPayMzdCd
	 */
	public String getInvPayMzdCd() {
		return this.invPayMzdCd;
	}
	
	/**
	 * Column Info
	 * @return trspInvCalcLgcTpCd
	 */
	public String getTrspInvCalcLgcTpCd() {
		return this.trspInvCalcLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspInvCalcLgcTpNm
	 */
	public String getTrspInvCalcLgcTpNm() {
		return this.trspInvCalcLgcTpNm;
	}
	
	/**
	 * Column Info
	 * @return invIssDt
	 */
	public String getInvIssDt() {
		return this.invIssDt;
	}
	
	/**
	 * Column Info
	 * @return invGttlAmt
	 */
	public String getInvGttlAmt() {
		return this.invGttlAmt;
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
	 * @return invRcvDt
	 */
	public String getInvRcvDt() {
		return this.invRcvDt;
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
	 * @return invHldFlg
	 */
	public String getInvHldFlg() {
		return this.invHldFlg;
	}
	
	/**
	 * Column Info
	 * @return spInvRmk
	 */
	public String getSpInvRmk() {
		return this.spInvRmk;
	}
	
	/**
	 * Column Info
	 * @return tollFeeAmt
	 */
	public String getTollFeeAmt() {
		return this.tollFeeAmt;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return trspInvAudStsCd
	 */
	public String getTrspInvAudStsCd() {
		return this.trspInvAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return ifSysKndNm
	 */
	public String getIfSysKndNm() {
		return this.ifSysKndNm;
	}
	
	/**
	 * Column Info
	 * @return invWhldTaxAmt
	 */
	public String getInvWhldTaxAmt() {
		return this.invWhldTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
	}
	
	/**
	 * Column Info
	 * @return woTotAmt
	 */
	public String getWoTotAmt() {
		return this.woTotAmt;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invChkTrnsNo
	 */
	public String getInvChkTrnsNo() {
		return this.invChkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @return invBzcAmt
	 */
	public String getInvBzcAmt() {
		return this.invBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCdSeq
	 */
	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @return uplnSoFlg
	 */
	public String getUplnSoFlg() {
		return this.uplnSoFlg;
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
	 * @return invSbcAmt
	 */
	public String getInvSbcAmt() {
		return this.invSbcAmt;
	}
	
	/**
	 * Column Info
	 * @return scgVatAmt
	 */
	public String getScgVatAmt() {
		return this.scgVatAmt;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspInvAudStsNm
	 */
	public String getTrspInvAudStsNm() {
		return this.trspInvAudStsNm;
	}
	
	/**
	 * Column Info
	 * @return invVndrNm
	 */
	public String getInvVndrNm() {
		return this.invVndrNm;
	}
	
	/**
	 * Column Info
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
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
	 * @return invVatAmt
	 */
	public String getInvVatAmt() {
		return this.invVatAmt;
	}
	
	/**
	 * Column Info
	 * @return invTotAmt
	 */
	public String getInvTotAmt() {
		return this.invTotAmt;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}
	
	/**
	 * Column Info
	 * @return invEtcAddAmt
	 */
	public String getInvEtcAddAmt() {
		return this.invEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
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
	 * @return etsStsFlg
	 */
	public String getEtsStsFlg() {
		return this.etsStsFlg;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return ifSysKndCd
	 */
	public String getIfSysKndCd() {
		return this.ifSysKndCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCdSeq
	 */
	public String getTrspWoOfcCtyCdSeq() {
		return this.trspWoOfcCtyCdSeq;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invPayMzdCd
	 */
	public void setInvPayMzdCd(String invPayMzdCd) {
		this.invPayMzdCd = invPayMzdCd;
	}
	
	/**
	 * Column Info
	 * @param trspInvCalcLgcTpCd
	 */
	public void setTrspInvCalcLgcTpCd(String trspInvCalcLgcTpCd) {
		this.trspInvCalcLgcTpCd = trspInvCalcLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspInvCalcLgcTpNm
	 */
	public void setTrspInvCalcLgcTpNm(String trspInvCalcLgcTpNm) {
		this.trspInvCalcLgcTpNm = trspInvCalcLgcTpNm;
	}
	
	/**
	 * Column Info
	 * @param invIssDt
	 */
	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
	}
	
	/**
	 * Column Info
	 * @param invGttlAmt
	 */
	public void setInvGttlAmt(String invGttlAmt) {
		this.invGttlAmt = invGttlAmt;
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
	 * @param invRcvDt
	 */
	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
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
	 * @param invHldFlg
	 */
	public void setInvHldFlg(String invHldFlg) {
		this.invHldFlg = invHldFlg;
	}
	
	/**
	 * Column Info
	 * @param spInvRmk
	 */
	public void setSpInvRmk(String spInvRmk) {
		this.spInvRmk = spInvRmk;
	}
	
	/**
	 * Column Info
	 * @param tollFeeAmt
	 */
	public void setTollFeeAmt(String tollFeeAmt) {
		this.tollFeeAmt = tollFeeAmt;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param trspInvAudStsCd
	 */
	public void setTrspInvAudStsCd(String trspInvAudStsCd) {
		this.trspInvAudStsCd = trspInvAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param ifSysKndNm
	 */
	public void setIfSysKndNm(String ifSysKndNm) {
		this.ifSysKndNm = ifSysKndNm;
	}
	
	/**
	 * Column Info
	 * @param invWhldTaxAmt
	 */
	public void setInvWhldTaxAmt(String invWhldTaxAmt) {
		this.invWhldTaxAmt = invWhldTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}
	
	/**
	 * Column Info
	 * @param woTotAmt
	 */
	public void setWoTotAmt(String woTotAmt) {
		this.woTotAmt = woTotAmt;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invChkTrnsNo
	 */
	public void setInvChkTrnsNo(String invChkTrnsNo) {
		this.invChkTrnsNo = invChkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @param invBzcAmt
	 */
	public void setInvBzcAmt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCdSeq
	 */
	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @param uplnSoFlg
	 */
	public void setUplnSoFlg(String uplnSoFlg) {
		this.uplnSoFlg = uplnSoFlg;
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
	 * @param invSbcAmt
	 */
	public void setInvSbcAmt(String invSbcAmt) {
		this.invSbcAmt = invSbcAmt;
	}
	
	/**
	 * Column Info
	 * @param scgVatAmt
	 */
	public void setScgVatAmt(String scgVatAmt) {
		this.scgVatAmt = scgVatAmt;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspInvAudStsNm
	 */
	public void setTrspInvAudStsNm(String trspInvAudStsNm) {
		this.trspInvAudStsNm = trspInvAudStsNm;
	}
	
	/**
	 * Column Info
	 * @param invVndrNm
	 */
	public void setInvVndrNm(String invVndrNm) {
		this.invVndrNm = invVndrNm;
	}
	
	/**
	 * Column Info
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
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
	 * @param invVatAmt
	 */
	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	
	/**
	 * Column Info
	 * @param invTotAmt
	 */
	public void setInvTotAmt(String invTotAmt) {
		this.invTotAmt = invTotAmt;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}
	
	/**
	 * Column Info
	 * @param invEtcAddAmt
	 */
	public void setInvEtcAddAmt(String invEtcAddAmt) {
		this.invEtcAddAmt = invEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
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
	 * @param etsStsFlg
	 */
	public void setEtsStsFlg(String etsStsFlg) {
		this.etsStsFlg = etsStsFlg;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param ifSysKndCd
	 */
	public void setIfSysKndCd(String ifSysKndCd) {
		this.ifSysKndCd = ifSysKndCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCdSeq
	 */
	public void setTrspWoOfcCtyCdSeq(String trspWoOfcCtyCdSeq) {
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setInvPayMzdCd(JSPUtil.getParameter(request, prefix + "inv_pay_mzd_cd", ""));
		setTrspInvCalcLgcTpCd(JSPUtil.getParameter(request, prefix + "trsp_inv_calc_lgc_tp_cd", ""));
		setTrspInvCalcLgcTpNm(JSPUtil.getParameter(request, prefix + "trsp_inv_calc_lgc_tp_nm", ""));
		setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
		setInvGttlAmt(JSPUtil.getParameter(request, prefix + "inv_gttl_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setInvRcvDt(JSPUtil.getParameter(request, prefix + "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setInvHldFlg(JSPUtil.getParameter(request, prefix + "inv_hld_flg", ""));
		setSpInvRmk(JSPUtil.getParameter(request, prefix + "sp_inv_rmk", ""));
		setTollFeeAmt(JSPUtil.getParameter(request, prefix + "toll_fee_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setTrspInvAudStsCd(JSPUtil.getParameter(request, prefix + "trsp_inv_aud_sts_cd", ""));
		setIfSysKndNm(JSPUtil.getParameter(request, prefix + "if_sys_knd_nm", ""));
		setInvWhldTaxAmt(JSPUtil.getParameter(request, prefix + "inv_whld_tax_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setWoTotAmt(JSPUtil.getParameter(request, prefix + "wo_tot_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setInvChkTrnsNo(JSPUtil.getParameter(request, prefix + "inv_chk_trns_no", ""));
		setInvBzcAmt(JSPUtil.getParameter(request, prefix + "inv_bzc_amt", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", ""));
		setUplnSoFlg(JSPUtil.getParameter(request, prefix + "upln_so_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setInvSbcAmt(JSPUtil.getParameter(request, prefix + "inv_sbc_amt", ""));
		setScgVatAmt(JSPUtil.getParameter(request, prefix + "scg_vat_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setTrspInvAudStsNm(JSPUtil.getParameter(request, prefix + "trsp_inv_aud_sts_nm", ""));
		setInvVndrNm(JSPUtil.getParameter(request, prefix + "inv_vndr_nm", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvVatAmt(JSPUtil.getParameter(request, prefix + "inv_vat_amt", ""));
		setInvTotAmt(JSPUtil.getParameter(request, prefix + "inv_tot_amt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setInvEtcAddAmt(JSPUtil.getParameter(request, prefix + "inv_etc_add_amt", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setEtsStsFlg(JSPUtil.getParameter(request, prefix + "ets_sts_flg", ""));
		setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
		setIfSysKndCd(JSPUtil.getParameter(request, prefix + "if_sys_knd_cd", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setTrspWoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceInquirySecondExcelFormVO[]
	 */
	public SearchInvoiceInquirySecondExcelFormVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceInquirySecondExcelFormVO[]
	 */
	public SearchInvoiceInquirySecondExcelFormVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoiceInquirySecondExcelFormVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] invPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_mzd_cd", length));
			String[] trspInvCalcLgcTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_calc_lgc_tp_cd", length));
			String[] trspInvCalcLgcTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_calc_lgc_tp_nm", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] invGttlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_gttl_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] invHldFlg = (JSPUtil.getParameter(request, prefix	+ "inv_hld_flg", length));
			String[] spInvRmk = (JSPUtil.getParameter(request, prefix	+ "sp_inv_rmk", length));
			String[] tollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] trspInvAudStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_aud_sts_cd", length));
			String[] ifSysKndNm = (JSPUtil.getParameter(request, prefix	+ "if_sys_knd_nm", length));
			String[] invWhldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_whld_tax_amt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] woTotAmt = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invChkTrnsNo = (JSPUtil.getParameter(request, prefix	+ "inv_chk_trns_no", length));
			String[] invBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bzc_amt", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd_seq", length));
			String[] uplnSoFlg = (JSPUtil.getParameter(request, prefix	+ "upln_so_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] invSbcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_sbc_amt", length));
			String[] scgVatAmt = (JSPUtil.getParameter(request, prefix	+ "scg_vat_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] trspInvAudStsNm = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_aud_sts_nm", length));
			String[] invVndrNm = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_nm", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invVatAmt = (JSPUtil.getParameter(request, prefix	+ "inv_vat_amt", length));
			String[] invTotAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tot_amt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] invEtcAddAmt = (JSPUtil.getParameter(request, prefix	+ "inv_etc_add_amt", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] etsStsFlg = (JSPUtil.getParameter(request, prefix	+ "ets_sts_flg", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] ifSysKndCd = (JSPUtil.getParameter(request, prefix	+ "if_sys_knd_cd", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] trspWoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoiceInquirySecondExcelFormVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (invPayMzdCd[i] != null)
					model.setInvPayMzdCd(invPayMzdCd[i]);
				if (trspInvCalcLgcTpCd[i] != null)
					model.setTrspInvCalcLgcTpCd(trspInvCalcLgcTpCd[i]);
				if (trspInvCalcLgcTpNm[i] != null)
					model.setTrspInvCalcLgcTpNm(trspInvCalcLgcTpNm[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (invGttlAmt[i] != null)
					model.setInvGttlAmt(invGttlAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (invHldFlg[i] != null)
					model.setInvHldFlg(invHldFlg[i]);
				if (spInvRmk[i] != null)
					model.setSpInvRmk(spInvRmk[i]);
				if (tollFeeAmt[i] != null)
					model.setTollFeeAmt(tollFeeAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (trspInvAudStsCd[i] != null)
					model.setTrspInvAudStsCd(trspInvAudStsCd[i]);
				if (ifSysKndNm[i] != null)
					model.setIfSysKndNm(ifSysKndNm[i]);
				if (invWhldTaxAmt[i] != null)
					model.setInvWhldTaxAmt(invWhldTaxAmt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (woTotAmt[i] != null)
					model.setWoTotAmt(woTotAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invChkTrnsNo[i] != null)
					model.setInvChkTrnsNo(invChkTrnsNo[i]);
				if (invBzcAmt[i] != null)
					model.setInvBzcAmt(invBzcAmt[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (uplnSoFlg[i] != null)
					model.setUplnSoFlg(uplnSoFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (invSbcAmt[i] != null)
					model.setInvSbcAmt(invSbcAmt[i]);
				if (scgVatAmt[i] != null)
					model.setScgVatAmt(scgVatAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (trspInvAudStsNm[i] != null)
					model.setTrspInvAudStsNm(trspInvAudStsNm[i]);
				if (invVndrNm[i] != null)
					model.setInvVndrNm(invVndrNm[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invVatAmt[i] != null)
					model.setInvVatAmt(invVatAmt[i]);
				if (invTotAmt[i] != null)
					model.setInvTotAmt(invTotAmt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (invEtcAddAmt[i] != null)
					model.setInvEtcAddAmt(invEtcAddAmt[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (etsStsFlg[i] != null)
					model.setEtsStsFlg(etsStsFlg[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (ifSysKndCd[i] != null)
					model.setIfSysKndCd(ifSysKndCd[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (trspWoOfcCtyCdSeq[i] != null)
					model.setTrspWoOfcCtyCdSeq(trspWoOfcCtyCdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoiceInquirySecondExcelFormVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoiceInquirySecondExcelFormVO[]
	 */
	public SearchInvoiceInquirySecondExcelFormVO[] getSearchInvoiceInquirySecondExcelFormVOs(){
		SearchInvoiceInquirySecondExcelFormVO[] vos = (SearchInvoiceInquirySecondExcelFormVO[])models.toArray(new SearchInvoiceInquirySecondExcelFormVO[models.size()]);
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
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayMzdCd = this.invPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvCalcLgcTpCd = this.trspInvCalcLgcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvCalcLgcTpNm = this.trspInvCalcLgcTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invGttlAmt = this.invGttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invHldFlg = this.invHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spInvRmk = this.spInvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt = this.tollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvAudStsCd = this.trspInvAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSysKndNm = this.ifSysKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invWhldTaxAmt = this.invWhldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmt = this.woTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChkTrnsNo = this.invChkTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBzcAmt = this.invBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uplnSoFlg = this.uplnSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSbcAmt = this.invSbcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgVatAmt = this.scgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvAudStsNm = this.trspInvAudStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrNm = this.invVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt = this.invVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTotAmt = this.invTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEtcAddAmt = this.invEtcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etsStsFlg = this.etsStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSysKndCd = this.ifSysKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCdSeq = this.trspWoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
