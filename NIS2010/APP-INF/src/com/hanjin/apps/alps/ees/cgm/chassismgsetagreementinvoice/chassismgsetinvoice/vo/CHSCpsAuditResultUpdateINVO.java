/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CHSCpsAuditResultUpdateINVO.java
 *@FileTitle : CHSCpsAuditResultUpdateINVO
 *Open Issues : CHM-201430040
 *Change history :
 *@LastModifyDate : 2014.05.30
 *@LastModifier : Chang Young Kim
 *@LastVersion : 1.0
 * 2014.05.30  
 * 1.0 Creation Chang Young Kim
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSCpsAuditResultUpdateINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSCpsAuditResultUpdateINVO> models = new ArrayList<CHSCpsAuditResultUpdateINVO>();
	
	/* Column Info */
	private String eqFmMvmtDt = null;
	/* Column Info */
	private String invLseRtAmt = null;
	/* Column Info */
	private String invTaxRtAmt = null;
	/* Column Info */
	private String chgCreSeq = null;
	/* Column Info */
	private String invCustEqNo = null;
	/* Column Info */
	private String audUmchEqStsEvntDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invScNo = null;
	/* Column Info */
	private String invBilUtDys = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String payBilUtDys = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String invEqOffhDt = null;
	/* Column Info */
	private String lseTaxRtAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String payTaxAmt = null;
	/* Column Info */
	private String payLseChgTtlAmt = null;
	/* Column Info */
	private String invBkgTermCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String invEqOnhLocNm = null;
	/* Column Info */
	private String invBkgNo = null;
	/* Column Info */
	private String audUmchEqAsetStsCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eqToYdCd = null;
	/* Column Info */
	private String invBilEndDt = null;
	/* Column Info */
	private String eqFmMvmtCd = null;
	/* Column Info */
	private String eqToMvmtCd = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String invEqNo = null;
	/* Column Info */
	private String invLseChgTtlAmt = null;
	/* Column Info */
	private String eqOffhDt = null;
	/* Column Info */
	private String lseChgAmt = null;
	/* Column Info */
	private String lseRtAmt = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String payTaxRtAmt = null;
	/* Column Info */
	private String eqOffhLocCd = null;
	/* Column Info */
	private String lseChgAudStsCd = null;
	/* Column Info */
	private String invTaxAmt = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String lseTaxAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqBilStDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String invLseUseDys = null;
	/* Column Info */
	private String lseChgAudRsltRsnCd = null;
	/* Column Info */
	private String payLseUseDys = null;
	/* Column Info */
	private String payLseChgAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String invEqOffhLocNm = null;
	/* Column Info */
	private String eqOnhLocCd = null;
	/* Column Info */
	private String invBilStDt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invCrAmt = null;
	/* Column Info */
	private String lseBilUtDys = null;
	/* Column Info */
	private String invYdCd = null;
	/* Column Info */
	private String audUmchEqStsEvntYdCd = null;
	/* Column Info */
	private String payChgAudRmk = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqToMvmtDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String payLseRtAmt = null;
	/* Column Info */
	private String eqFmYdCd = null;
	/* Column Info */
	private String eqOnhDt = null;
	/* Column Info */
	private String payCrAmt = null;
	/* Column Info */
	private String invEqOnhDt = null;
	/* Column Info */
	private String lseChgTtlAmt = null;
	/* Column Info */
	private String lseUseDys = null;
	/* Column Info */
	private String eqBilEndDt = null;
	/* Column Info */
	private String invLseChgAmt = null;
	/* Column Info */
	private String payLseChgStsCd = null;
	/* Column Info */
	private String costYrmonSeq = null;		
	/* Column Info */
	private String seq = null;
	/* Column Info	*/
	private String updtKey = null;
	/* Column Info	*/
	private String delChk = null;
	/* Column Info */
	private String vndrPayChgRmk = null;
	/* Column Info */
	private String vndrPayChgCmtCtnt = null;
	/* Column Info */
	private String vndrPayChgCrStyCtnt = null;
	/* Column Info */
	private String vndrPayChgCrDueCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSCpsAuditResultUpdateINVO() {}

	public CHSCpsAuditResultUpdateINVO(String ibflag, String pagerows, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String costYrmon, String eqNo, String chgCd, String chgSeq, String eqKndCd, String lseChgAudStsCd, String lseChgAudRsltRsnCd, String lseUseDys, String lseRtAmt, String lseChgAmt, String eqOnhDt, String eqOnhLocCd, String eqOffhDt, String eqOffhLocCd, String eqBilStDt, String eqBilEndDt, String invNo, String invRefNo, String invEqNo, String invCustEqNo, String invEqOnhDt, String invEqOnhLocNm, String invEqOffhDt, String invEqOffhLocNm, String invBilStDt, String invBilEndDt, String invLseUseDys, String invLseRtAmt, String invLseChgAmt, String invTaxAmt, String invCrAmt, String audUmchEqStsEvntYdCd, String audUmchEqAsetStsCd, String audUmchEqStsEvntDt, String payLseChgStsCd, String payLseUseDys, String payLseRtAmt, String payLseChgAmt, String payCrAmt, String payTaxAmt, String payInvSeq, String costCd, String acctCd, String payChgAudRmk, String creUsrId, String creDt, String updUsrId, String updDt, String eqTpszCd, String eqFmYdCd, String eqFmMvmtCd, String eqFmMvmtDt, String eqToYdCd, String eqToMvmtCd, String eqToMvmtDt, String invYdCd, String invBilUtDys, String invBkgNo, String invBkgTermCd, String invScNo, String invCustCntCd, String invCustSeq, String payBilUtDys, String invLseChgTtlAmt, String invTaxRtAmt, String payLseChgTtlAmt, String payTaxRtAmt, String lseBilUtDys, String lseChgTtlAmt, String lseTaxRtAmt, String lseTaxAmt, String chgCreSeq, String costYrmonSeq, String seq, String updtKey, String delChk, String vndrPayChgRmk, String vndrPayChgCmtCtnt, String vndrPayChgCrStyCtnt, String vndrPayChgCrDueCtnt) {
		this.eqFmMvmtDt = eqFmMvmtDt;
		this.invLseRtAmt = invLseRtAmt;
		this.invTaxRtAmt = invTaxRtAmt;
		this.chgCreSeq = chgCreSeq;
		this.invCustEqNo = invCustEqNo;
		this.audUmchEqStsEvntDt = audUmchEqStsEvntDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.invScNo = invScNo;
		this.invBilUtDys = invBilUtDys;
		this.costYrmon = costYrmon;
		this.costCd = costCd;
		this.payBilUtDys = payBilUtDys;
		this.invCustCntCd = invCustCntCd;
		this.invEqOffhDt = invEqOffhDt;
		this.lseTaxRtAmt = lseTaxRtAmt;
		this.updUsrId = updUsrId;
		this.payTaxAmt = payTaxAmt;
		this.payLseChgTtlAmt = payLseChgTtlAmt;
		this.invBkgTermCd = invBkgTermCd;
		this.agmtSeq = agmtSeq;
		this.invEqOnhLocNm = invEqOnhLocNm;
		this.invBkgNo = invBkgNo;
		this.audUmchEqAsetStsCd = audUmchEqAsetStsCd;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.eqToYdCd = eqToYdCd;
		this.invBilEndDt = invBilEndDt;
		this.eqFmMvmtCd = eqFmMvmtCd;
		this.eqToMvmtCd = eqToMvmtCd;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.invEqNo = invEqNo;
		this.invLseChgTtlAmt = invLseChgTtlAmt;
		this.eqOffhDt = eqOffhDt;
		this.lseChgAmt = lseChgAmt;
		this.lseRtAmt = lseRtAmt;
		this.agmtVerNo = agmtVerNo;
		this.payTaxRtAmt = payTaxRtAmt;
		this.eqOffhLocCd = eqOffhLocCd;
		this.lseChgAudStsCd = lseChgAudStsCd;
		this.invTaxAmt = invTaxAmt;
		this.payInvSeq = payInvSeq;
		this.lseTaxAmt = lseTaxAmt;
		this.creDt = creDt;
		this.eqBilStDt = eqBilStDt;
		this.chgSeq = chgSeq;
		this.invLseUseDys = invLseUseDys;
		this.lseChgAudRsltRsnCd = lseChgAudRsltRsnCd;
		this.payLseUseDys = payLseUseDys;
		this.payLseChgAmt = payLseChgAmt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.invEqOffhLocNm = invEqOffhLocNm;
		this.eqOnhLocCd = eqOnhLocCd;
		this.invBilStDt = invBilStDt;
		this.acctCd = acctCd;
		this.updDt = updDt;
		this.invCrAmt = invCrAmt;
		this.lseBilUtDys = lseBilUtDys;
		this.invYdCd = invYdCd;
		this.audUmchEqStsEvntYdCd = audUmchEqStsEvntYdCd;
		this.payChgAudRmk = payChgAudRmk;
		this.invRefNo = invRefNo;
		this.invCustSeq = invCustSeq;
		this.eqKndCd = eqKndCd;
		this.eqToMvmtDt = eqToMvmtDt;
		this.invNo = invNo;
		this.payLseRtAmt = payLseRtAmt;
		this.eqFmYdCd = eqFmYdCd;
		this.eqOnhDt = eqOnhDt;
		this.payCrAmt = payCrAmt;
		this.invEqOnhDt = invEqOnhDt;
		this.lseChgTtlAmt = lseChgTtlAmt;
		this.lseUseDys = lseUseDys;
		this.eqBilEndDt = eqBilEndDt;
		this.invLseChgAmt = invLseChgAmt;
		this.payLseChgStsCd = payLseChgStsCd;
		this.costYrmonSeq = costYrmonSeq;
		this.seq = seq;
		this.updtKey = updtKey;
		this.delChk = delChk;
		this.vndrPayChgRmk = vndrPayChgRmk;
		this.vndrPayChgCmtCtnt = vndrPayChgCmtCtnt;
		this.vndrPayChgCrStyCtnt = vndrPayChgCrStyCtnt;
		this.vndrPayChgCrDueCtnt = vndrPayChgCrDueCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_fm_mvmt_dt", getEqFmMvmtDt());
		this.hashColumns.put("inv_lse_rt_amt", getInvLseRtAmt());
		this.hashColumns.put("inv_tax_rt_amt", getInvTaxRtAmt());
		this.hashColumns.put("chg_cre_seq", getChgCreSeq());
		this.hashColumns.put("inv_cust_eq_no", getInvCustEqNo());
		this.hashColumns.put("aud_umch_eq_sts_evnt_dt", getAudUmchEqStsEvntDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_sc_no", getInvScNo());
		this.hashColumns.put("inv_bil_ut_dys", getInvBilUtDys());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("pay_bil_ut_dys", getPayBilUtDys());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("inv_eq_offh_dt", getInvEqOffhDt());
		this.hashColumns.put("lse_tax_rt_amt", getLseTaxRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pay_tax_amt", getPayTaxAmt());
		this.hashColumns.put("pay_lse_chg_ttl_amt", getPayLseChgTtlAmt());
		this.hashColumns.put("inv_bkg_term_cd", getInvBkgTermCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("inv_eq_onh_loc_nm", getInvEqOnhLocNm());
		this.hashColumns.put("inv_bkg_no", getInvBkgNo());
		this.hashColumns.put("aud_umch_eq_aset_sts_cd", getAudUmchEqAsetStsCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_to_yd_cd", getEqToYdCd());
		this.hashColumns.put("inv_bil_end_dt", getInvBilEndDt());
		this.hashColumns.put("eq_fm_mvmt_cd", getEqFmMvmtCd());
		this.hashColumns.put("eq_to_mvmt_cd", getEqToMvmtCd());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("inv_eq_no", getInvEqNo());
		this.hashColumns.put("inv_lse_chg_ttl_amt", getInvLseChgTtlAmt());
		this.hashColumns.put("eq_offh_dt", getEqOffhDt());
		this.hashColumns.put("lse_chg_amt", getLseChgAmt());
		this.hashColumns.put("lse_rt_amt", getLseRtAmt());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("pay_tax_rt_amt", getPayTaxRtAmt());
		this.hashColumns.put("eq_offh_loc_cd", getEqOffhLocCd());
		this.hashColumns.put("lse_chg_aud_sts_cd", getLseChgAudStsCd());
		this.hashColumns.put("inv_tax_amt", getInvTaxAmt());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("lse_tax_amt", getLseTaxAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_bil_st_dt", getEqBilStDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("inv_lse_use_dys", getInvLseUseDys());
		this.hashColumns.put("lse_chg_aud_rslt_rsn_cd", getLseChgAudRsltRsnCd());
		this.hashColumns.put("pay_lse_use_dys", getPayLseUseDys());
		this.hashColumns.put("pay_lse_chg_amt", getPayLseChgAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inv_eq_offh_loc_nm", getInvEqOffhLocNm());
		this.hashColumns.put("eq_onh_loc_cd", getEqOnhLocCd());
		this.hashColumns.put("inv_bil_st_dt", getInvBilStDt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_cr_amt", getInvCrAmt());
		this.hashColumns.put("lse_bil_ut_dys", getLseBilUtDys());
		this.hashColumns.put("inv_yd_cd", getInvYdCd());
		this.hashColumns.put("aud_umch_eq_sts_evnt_yd_cd", getAudUmchEqStsEvntYdCd());
		this.hashColumns.put("pay_chg_aud_rmk", getPayChgAudRmk());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_to_mvmt_dt", getEqToMvmtDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pay_lse_rt_amt", getPayLseRtAmt());
		this.hashColumns.put("eq_fm_yd_cd", getEqFmYdCd());
		this.hashColumns.put("eq_onh_dt", getEqOnhDt());
		this.hashColumns.put("pay_cr_amt", getPayCrAmt());
		this.hashColumns.put("inv_eq_onh_dt", getInvEqOnhDt());
		this.hashColumns.put("lse_chg_ttl_amt", getLseChgTtlAmt());
		this.hashColumns.put("lse_use_dys", getLseUseDys());
		this.hashColumns.put("eq_bil_end_dt", getEqBilEndDt());
		this.hashColumns.put("inv_lse_chg_amt", getInvLseChgAmt());
		this.hashColumns.put("pay_lse_chg_sts_cd", getPayLseChgStsCd());
		this.hashColumns.put("cost_yrmon_seq", getCostYrmonSeq());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("updt_key", getUpdtKey());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("vndr_pay_chg_rmk", getVndrPayChgRmk());
		this.hashColumns.put("vndr_pay_chg_cmt_ctnt", getVndrPayChgCmtCtnt());
		this.hashColumns.put("vndr_pay_chg_cr_sty_ctnt", getVndrPayChgCrStyCtnt());
		this.hashColumns.put("vndr_pay_chg_cr_due_ctnt", getVndrPayChgCrDueCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_fm_mvmt_dt", "eqFmMvmtDt");
		this.hashFields.put("inv_lse_rt_amt", "invLseRtAmt");
		this.hashFields.put("inv_tax_rt_amt", "invTaxRtAmt");
		this.hashFields.put("chg_cre_seq", "chgCreSeq");
		this.hashFields.put("inv_cust_eq_no", "invCustEqNo");
		this.hashFields.put("aud_umch_eq_sts_evnt_dt", "audUmchEqStsEvntDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_sc_no", "invScNo");
		this.hashFields.put("inv_bil_ut_dys", "invBilUtDys");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("pay_bil_ut_dys", "payBilUtDys");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("inv_eq_offh_dt", "invEqOffhDt");
		this.hashFields.put("lse_tax_rt_amt", "lseTaxRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pay_tax_amt", "payTaxAmt");
		this.hashFields.put("pay_lse_chg_ttl_amt", "payLseChgTtlAmt");
		this.hashFields.put("inv_bkg_term_cd", "invBkgTermCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("inv_eq_onh_loc_nm", "invEqOnhLocNm");
		this.hashFields.put("inv_bkg_no", "invBkgNo");
		this.hashFields.put("aud_umch_eq_aset_sts_cd", "audUmchEqAsetStsCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_to_yd_cd", "eqToYdCd");
		this.hashFields.put("inv_bil_end_dt", "invBilEndDt");
		this.hashFields.put("eq_fm_mvmt_cd", "eqFmMvmtCd");
		this.hashFields.put("eq_to_mvmt_cd", "eqToMvmtCd");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("inv_eq_no", "invEqNo");
		this.hashFields.put("inv_lse_chg_ttl_amt", "invLseChgTtlAmt");
		this.hashFields.put("eq_offh_dt", "eqOffhDt");
		this.hashFields.put("lse_chg_amt", "lseChgAmt");
		this.hashFields.put("lse_rt_amt", "lseRtAmt");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("pay_tax_rt_amt", "payTaxRtAmt");
		this.hashFields.put("eq_offh_loc_cd", "eqOffhLocCd");
		this.hashFields.put("lse_chg_aud_sts_cd", "lseChgAudStsCd");
		this.hashFields.put("inv_tax_amt", "invTaxAmt");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("lse_tax_amt", "lseTaxAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_bil_st_dt", "eqBilStDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_lse_use_dys", "invLseUseDys");
		this.hashFields.put("lse_chg_aud_rslt_rsn_cd", "lseChgAudRsltRsnCd");
		this.hashFields.put("pay_lse_use_dys", "payLseUseDys");
		this.hashFields.put("pay_lse_chg_amt", "payLseChgAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inv_eq_offh_loc_nm", "invEqOffhLocNm");
		this.hashFields.put("eq_onh_loc_cd", "eqOnhLocCd");
		this.hashFields.put("inv_bil_st_dt", "invBilStDt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_cr_amt", "invCrAmt");
		this.hashFields.put("lse_bil_ut_dys", "lseBilUtDys");
		this.hashFields.put("inv_yd_cd", "invYdCd");
		this.hashFields.put("aud_umch_eq_sts_evnt_yd_cd", "audUmchEqStsEvntYdCd");
		this.hashFields.put("pay_chg_aud_rmk", "payChgAudRmk");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_to_mvmt_dt", "eqToMvmtDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pay_lse_rt_amt", "payLseRtAmt");
		this.hashFields.put("eq_fm_yd_cd", "eqFmYdCd");
		this.hashFields.put("eq_onh_dt", "eqOnhDt");
		this.hashFields.put("pay_cr_amt", "payCrAmt");
		this.hashFields.put("inv_eq_onh_dt", "invEqOnhDt");
		this.hashFields.put("lse_chg_ttl_amt", "lseChgTtlAmt");
		this.hashFields.put("lse_use_dys", "lseUseDys");
		this.hashFields.put("eq_bil_end_dt", "eqBilEndDt");
		this.hashFields.put("inv_lse_chg_amt", "invLseChgAmt");
		this.hashFields.put("pay_lse_chg_sts_cd", "payLseChgStsCd");
		this.hashFields.put("cost_yrmon_seq", "costYrmonSeq");		
		this.hashFields.put("seq", "seq");
		this.hashFields.put("updt_key", "updtKey");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("vndr_pay_chg_rmk", "vndrPayChgRmk");
		this.hashFields.put("vndr_pay_chg_cmt_ctnt", "vndrPayChgCmtCtnt");
		this.hashFields.put("vndr_pay_chg_cr_sty_ctnt", "vndrPayChgCrStyCtnt");
		this.hashFields.put("vndr_pay_chg_cr_due_ctnt", "vndrPayChgCrDueCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqFmMvmtDt
	 */
	public String getEqFmMvmtDt() {
		return this.eqFmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return invLseRtAmt
	 */
	public String getInvLseRtAmt() {
		return this.invLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @return invTaxRtAmt
	 */
	public String getInvTaxRtAmt() {
		return this.invTaxRtAmt;
	}
	
	/**
	 * Column Info
	 * @return chgCreSeq
	 */
	public String getChgCreSeq() {
		return this.chgCreSeq;
	}
	
	/**
	 * Column Info
	 * @return invCustEqNo
	 */
	public String getInvCustEqNo() {
		return this.invCustEqNo;
	}
	
	/**
	 * Column Info
	 * @return audUmchEqStsEvntDt
	 */
	public String getAudUmchEqStsEvntDt() {
		return this.audUmchEqStsEvntDt;
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
	 * @return invScNo
	 */
	public String getInvScNo() {
		return this.invScNo;
	}
	
	/**
	 * Column Info
	 * @return invBilUtDys
	 */
	public String getInvBilUtDys() {
		return this.invBilUtDys;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return payBilUtDys
	 */
	public String getPayBilUtDys() {
		return this.payBilUtDys;
	}
	
	/**
	 * Column Info
	 * @return invCustCntCd
	 */
	public String getInvCustCntCd() {
		return this.invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return invEqOffhDt
	 */
	public String getInvEqOffhDt() {
		return this.invEqOffhDt;
	}
	
	/**
	 * Column Info
	 * @return lseTaxRtAmt
	 */
	public String getLseTaxRtAmt() {
		return this.lseTaxRtAmt;
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
	 * @return payTaxAmt
	 */
	public String getPayTaxAmt() {
		return this.payTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return payLseChgTtlAmt
	 */
	public String getPayLseChgTtlAmt() {
		return this.payLseChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invBkgTermCd
	 */
	public String getInvBkgTermCd() {
		return this.invBkgTermCd;
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
	 * @return invEqOnhLocNm
	 */
	public String getInvEqOnhLocNm() {
		return this.invEqOnhLocNm;
	}
	
	/**
	 * Column Info
	 * @return invBkgNo
	 */
	public String getInvBkgNo() {
		return this.invBkgNo;
	}
	
	/**
	 * Column Info
	 * @return audUmchEqAsetStsCd
	 */
	public String getAudUmchEqAsetStsCd() {
		return this.audUmchEqAsetStsCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return eqToYdCd
	 */
	public String getEqToYdCd() {
		return this.eqToYdCd;
	}
	
	/**
	 * Column Info
	 * @return invBilEndDt
	 */
	public String getInvBilEndDt() {
		return this.invBilEndDt;
	}
	
	/**
	 * Column Info
	 * @return eqFmMvmtCd
	 */
	public String getEqFmMvmtCd() {
		return this.eqFmMvmtCd;
	}
	
	/**
	 * Column Info
	 * @return eqToMvmtCd
	 */
	public String getEqToMvmtCd() {
		return this.eqToMvmtCd;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return invEqNo
	 */
	public String getInvEqNo() {
		return this.invEqNo;
	}
	
	/**
	 * Column Info
	 * @return invLseChgTtlAmt
	 */
	public String getInvLseChgTtlAmt() {
		return this.invLseChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return eqOffhDt
	 */
	public String getEqOffhDt() {
		return this.eqOffhDt;
	}
	
	/**
	 * Column Info
	 * @return lseChgAmt
	 */
	public String getLseChgAmt() {
		return this.lseChgAmt;
	}
	
	/**
	 * Column Info
	 * @return lseRtAmt
	 */
	public String getLseRtAmt() {
		return this.lseRtAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return payTaxRtAmt
	 */
	public String getPayTaxRtAmt() {
		return this.payTaxRtAmt;
	}
	
	/**
	 * Column Info
	 * @return eqOffhLocCd
	 */
	public String getEqOffhLocCd() {
		return this.eqOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @return lseChgAudStsCd
	 */
	public String getLseChgAudStsCd() {
		return this.lseChgAudStsCd;
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
	 * @return payInvSeq
	 */
	public String getPayInvSeq() {
		return this.payInvSeq;
	}
	
	/**
	 * Column Info
	 * @return lseTaxAmt
	 */
	public String getLseTaxAmt() {
		return this.lseTaxAmt;
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
	 * @return eqBilStDt
	 */
	public String getEqBilStDt() {
		return this.eqBilStDt;
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
	 * @return invLseUseDys
	 */
	public String getInvLseUseDys() {
		return this.invLseUseDys;
	}
	
	/**
	 * Column Info
	 * @return lseChgAudRsltRsnCd
	 */
	public String getLseChgAudRsltRsnCd() {
		return this.lseChgAudRsltRsnCd;
	}
	
	/**
	 * Column Info
	 * @return payLseUseDys
	 */
	public String getPayLseUseDys() {
		return this.payLseUseDys;
	}
	
	/**
	 * Column Info
	 * @return payLseChgAmt
	 */
	public String getPayLseChgAmt() {
		return this.payLseChgAmt;
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
	 * @return invEqOffhLocNm
	 */
	public String getInvEqOffhLocNm() {
		return this.invEqOffhLocNm;
	}
	
	/**
	 * Column Info
	 * @return eqOnhLocCd
	 */
	public String getEqOnhLocCd() {
		return this.eqOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @return invBilStDt
	 */
	public String getInvBilStDt() {
		return this.invBilStDt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return invCrAmt
	 */
	public String getInvCrAmt() {
		return this.invCrAmt;
	}
	
	/**
	 * Column Info
	 * @return lseBilUtDys
	 */
	public String getLseBilUtDys() {
		return this.lseBilUtDys;
	}
	
	/**
	 * Column Info
	 * @return invYdCd
	 */
	public String getInvYdCd() {
		return this.invYdCd;
	}
	
	/**
	 * Column Info
	 * @return audUmchEqStsEvntYdCd
	 */
	public String getAudUmchEqStsEvntYdCd() {
		return this.audUmchEqStsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return payChgAudRmk
	 */
	public String getPayChgAudRmk() {
		return this.payChgAudRmk;
	}
	
	/**
	 * Column Info
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
	}
	
	/**
	 * Column Info
	 * @return invCustSeq
	 */
	public String getInvCustSeq() {
		return this.invCustSeq;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqToMvmtDt
	 */
	public String getEqToMvmtDt() {
		return this.eqToMvmtDt;
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
	 * @return payLseRtAmt
	 */
	public String getPayLseRtAmt() {
		return this.payLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @return eqFmYdCd
	 */
	public String getEqFmYdCd() {
		return this.eqFmYdCd;
	}
	
	/**
	 * Column Info
	 * @return eqOnhDt
	 */
	public String getEqOnhDt() {
		return this.eqOnhDt;
	}
	
	/**
	 * Column Info
	 * @return payCrAmt
	 */
	public String getPayCrAmt() {
		return this.payCrAmt;
	}
	
	/**
	 * Column Info
	 * @return invEqOnhDt
	 */
	public String getInvEqOnhDt() {
		return this.invEqOnhDt;
	}
	
	/**
	 * Column Info
	 * @return lseChgTtlAmt
	 */
	public String getLseChgTtlAmt() {
		return this.lseChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return lseUseDys
	 */
	public String getLseUseDys() {
		return this.lseUseDys;
	}
	
	/**
	 * Column Info
	 * @return eqBilEndDt
	 */
	public String getEqBilEndDt() {
		return this.eqBilEndDt;
	}
	
	/**
	 * Column Info
	 * @return invLseChgAmt
	 */
	public String getInvLseChgAmt() {
		return this.invLseChgAmt;
	}
	
	/**
	 * Column Info
	 * @return payLseChgStsCd
	 */
	public String getPayLseChgStsCd() {
		return this.payLseChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrPayChgRmk
	 */
	public String getVndrPayChgRmk() {
		return this.vndrPayChgRmk;
	}

	/**
	 * Column Info
	 * @return vndrPayChgCmtCtnt
	 */
	public String getVndrPayChgCmtCtnt() {
		return this.vndrPayChgCmtCtnt;
	}

	/**
	 * Column Info
	 * @return vndrPayChgCrStyCtnt
	 */
	public String getVndrPayChgCrStyCtnt() {
		return this.vndrPayChgCrStyCtnt;
	}

	/**
	 * Column Info
	 * @return vndrPayChgCrDueCtnt
	 */
	public String getVndrPayChgCrDueCtnt() {
		return this.vndrPayChgCrDueCtnt;
	}
	
	/**
	 * Column Info
	 * @param eqFmMvmtDt
	 */
	public void setEqFmMvmtDt(String eqFmMvmtDt) {
		this.eqFmMvmtDt = eqFmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param invLseRtAmt
	 */
	public void setInvLseRtAmt(String invLseRtAmt) {
		this.invLseRtAmt = invLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @param invTaxRtAmt
	 */
	public void setInvTaxRtAmt(String invTaxRtAmt) {
		this.invTaxRtAmt = invTaxRtAmt;
	}
	
	/**
	 * Column Info
	 * @param chgCreSeq
	 */
	public void setChgCreSeq(String chgCreSeq) {
		this.chgCreSeq = chgCreSeq;
	}
	
	/**
	 * Column Info
	 * @param invCustEqNo
	 */
	public void setInvCustEqNo(String invCustEqNo) {
		this.invCustEqNo = invCustEqNo;
	}
	
	/**
	 * Column Info
	 * @param audUmchEqStsEvntDt
	 */
	public void setAudUmchEqStsEvntDt(String audUmchEqStsEvntDt) {
		this.audUmchEqStsEvntDt = audUmchEqStsEvntDt;
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
	 * @param invScNo
	 */
	public void setInvScNo(String invScNo) {
		this.invScNo = invScNo;
	}
	
	/**
	 * Column Info
	 * @param invBilUtDys
	 */
	public void setInvBilUtDys(String invBilUtDys) {
		this.invBilUtDys = invBilUtDys;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param payBilUtDys
	 */
	public void setPayBilUtDys(String payBilUtDys) {
		this.payBilUtDys = payBilUtDys;
	}
	
	/**
	 * Column Info
	 * @param invCustCntCd
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param invEqOffhDt
	 */
	public void setInvEqOffhDt(String invEqOffhDt) {
		this.invEqOffhDt = invEqOffhDt;
	}
	
	/**
	 * Column Info
	 * @param lseTaxRtAmt
	 */
	public void setLseTaxRtAmt(String lseTaxRtAmt) {
		this.lseTaxRtAmt = lseTaxRtAmt;
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
	 * @param payTaxAmt
	 */
	public void setPayTaxAmt(String payTaxAmt) {
		this.payTaxAmt = payTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param payLseChgTtlAmt
	 */
	public void setPayLseChgTtlAmt(String payLseChgTtlAmt) {
		this.payLseChgTtlAmt = payLseChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invBkgTermCd
	 */
	public void setInvBkgTermCd(String invBkgTermCd) {
		this.invBkgTermCd = invBkgTermCd;
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
	 * @param invEqOnhLocNm
	 */
	public void setInvEqOnhLocNm(String invEqOnhLocNm) {
		this.invEqOnhLocNm = invEqOnhLocNm;
	}
	
	/**
	 * Column Info
	 * @param invBkgNo
	 */
	public void setInvBkgNo(String invBkgNo) {
		this.invBkgNo = invBkgNo;
	}
	
	/**
	 * Column Info
	 * @param audUmchEqAsetStsCd
	 */
	public void setAudUmchEqAsetStsCd(String audUmchEqAsetStsCd) {
		this.audUmchEqAsetStsCd = audUmchEqAsetStsCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param eqToYdCd
	 */
	public void setEqToYdCd(String eqToYdCd) {
		this.eqToYdCd = eqToYdCd;
	}
	
	/**
	 * Column Info
	 * @param invBilEndDt
	 */
	public void setInvBilEndDt(String invBilEndDt) {
		this.invBilEndDt = invBilEndDt;
	}
	
	/**
	 * Column Info
	 * @param eqFmMvmtCd
	 */
	public void setEqFmMvmtCd(String eqFmMvmtCd) {
		this.eqFmMvmtCd = eqFmMvmtCd;
	}
	
	/**
	 * Column Info
	 * @param eqToMvmtCd
	 */
	public void setEqToMvmtCd(String eqToMvmtCd) {
		this.eqToMvmtCd = eqToMvmtCd;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param invEqNo
	 */
	public void setInvEqNo(String invEqNo) {
		this.invEqNo = invEqNo;
	}
	
	/**
	 * Column Info
	 * @param invLseChgTtlAmt
	 */
	public void setInvLseChgTtlAmt(String invLseChgTtlAmt) {
		this.invLseChgTtlAmt = invLseChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param eqOffhDt
	 */
	public void setEqOffhDt(String eqOffhDt) {
		this.eqOffhDt = eqOffhDt;
	}
	
	/**
	 * Column Info
	 * @param lseChgAmt
	 */
	public void setLseChgAmt(String lseChgAmt) {
		this.lseChgAmt = lseChgAmt;
	}
	
	/**
	 * Column Info
	 * @param lseRtAmt
	 */
	public void setLseRtAmt(String lseRtAmt) {
		this.lseRtAmt = lseRtAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param payTaxRtAmt
	 */
	public void setPayTaxRtAmt(String payTaxRtAmt) {
		this.payTaxRtAmt = payTaxRtAmt;
	}
	
	/**
	 * Column Info
	 * @param eqOffhLocCd
	 */
	public void setEqOffhLocCd(String eqOffhLocCd) {
		this.eqOffhLocCd = eqOffhLocCd;
	}
	
	/**
	 * Column Info
	 * @param lseChgAudStsCd
	 */
	public void setLseChgAudStsCd(String lseChgAudStsCd) {
		this.lseChgAudStsCd = lseChgAudStsCd;
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
	 * @param payInvSeq
	 */
	public void setPayInvSeq(String payInvSeq) {
		this.payInvSeq = payInvSeq;
	}
	
	/**
	 * Column Info
	 * @param lseTaxAmt
	 */
	public void setLseTaxAmt(String lseTaxAmt) {
		this.lseTaxAmt = lseTaxAmt;
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
	 * @param eqBilStDt
	 */
	public void setEqBilStDt(String eqBilStDt) {
		this.eqBilStDt = eqBilStDt;
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
	 * @param invLseUseDys
	 */
	public void setInvLseUseDys(String invLseUseDys) {
		this.invLseUseDys = invLseUseDys;
	}
	
	/**
	 * Column Info
	 * @param lseChgAudRsltRsnCd
	 */
	public void setLseChgAudRsltRsnCd(String lseChgAudRsltRsnCd) {
		this.lseChgAudRsltRsnCd = lseChgAudRsltRsnCd;
	}
	
	/**
	 * Column Info
	 * @param payLseUseDys
	 */
	public void setPayLseUseDys(String payLseUseDys) {
		this.payLseUseDys = payLseUseDys;
	}
	
	/**
	 * Column Info
	 * @param payLseChgAmt
	 */
	public void setPayLseChgAmt(String payLseChgAmt) {
		this.payLseChgAmt = payLseChgAmt;
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
	 * @param invEqOffhLocNm
	 */
	public void setInvEqOffhLocNm(String invEqOffhLocNm) {
		this.invEqOffhLocNm = invEqOffhLocNm;
	}
	
	/**
	 * Column Info
	 * @param eqOnhLocCd
	 */
	public void setEqOnhLocCd(String eqOnhLocCd) {
		this.eqOnhLocCd = eqOnhLocCd;
	}
	
	/**
	 * Column Info
	 * @param invBilStDt
	 */
	public void setInvBilStDt(String invBilStDt) {
		this.invBilStDt = invBilStDt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param invCrAmt
	 */
	public void setInvCrAmt(String invCrAmt) {
		this.invCrAmt = invCrAmt;
	}
	
	/**
	 * Column Info
	 * @param lseBilUtDys
	 */
	public void setLseBilUtDys(String lseBilUtDys) {
		this.lseBilUtDys = lseBilUtDys;
	}
	
	/**
	 * Column Info
	 * @param invYdCd
	 */
	public void setInvYdCd(String invYdCd) {
		this.invYdCd = invYdCd;
	}
	
	/**
	 * Column Info
	 * @param audUmchEqStsEvntYdCd
	 */
	public void setAudUmchEqStsEvntYdCd(String audUmchEqStsEvntYdCd) {
		this.audUmchEqStsEvntYdCd = audUmchEqStsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param payChgAudRmk
	 */
	public void setPayChgAudRmk(String payChgAudRmk) {
		this.payChgAudRmk = payChgAudRmk;
	}
	
	/**
	 * Column Info
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
	}
	
	/**
	 * Column Info
	 * @param invCustSeq
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqToMvmtDt
	 */
	public void setEqToMvmtDt(String eqToMvmtDt) {
		this.eqToMvmtDt = eqToMvmtDt;
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
	 * @param payLseRtAmt
	 */
	public void setPayLseRtAmt(String payLseRtAmt) {
		this.payLseRtAmt = payLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @param eqFmYdCd
	 */
	public void setEqFmYdCd(String eqFmYdCd) {
		this.eqFmYdCd = eqFmYdCd;
	}
	
	/**
	 * Column Info
	 * @param eqOnhDt
	 */
	public void setEqOnhDt(String eqOnhDt) {
		this.eqOnhDt = eqOnhDt;
	}
	
	/**
	 * Column Info
	 * @param payCrAmt
	 */
	public void setPayCrAmt(String payCrAmt) {
		this.payCrAmt = payCrAmt;
	}
	
	/**
	 * Column Info
	 * @param invEqOnhDt
	 */
	public void setInvEqOnhDt(String invEqOnhDt) {
		this.invEqOnhDt = invEqOnhDt;
	}
	
	/**
	 * Column Info
	 * @param lseChgTtlAmt
	 */
	public void setLseChgTtlAmt(String lseChgTtlAmt) {
		this.lseChgTtlAmt = lseChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param lseUseDys
	 */
	public void setLseUseDys(String lseUseDys) {
		this.lseUseDys = lseUseDys;
	}
	
	/**
	 * Column Info
	 * @param eqBilEndDt
	 */
	public void setEqBilEndDt(String eqBilEndDt) {
		this.eqBilEndDt = eqBilEndDt;
	}
	
	/**
	 * Column Info
	 * @param invLseChgAmt
	 */
	public void setInvLseChgAmt(String invLseChgAmt) {
		this.invLseChgAmt = invLseChgAmt;
	}
	
	/**
	 * Column Info
	 * @param payLseChgStsCd
	 */
	public void setPayLseChgStsCd(String payLseChgStsCd) {
		this.payLseChgStsCd = payLseChgStsCd;
	}
	
	/**
	* Column Info
	* @param costYrmonSeq
	*/
	public void setCostYrmonSeq(String costYrmonSeq) {
		this.costYrmonSeq = costYrmonSeq;
	}
 
	/**
	 * Column Info
	 * @return costYrmonSeq
	 */
	public String getCostYrmonSeq() {
		 return this.costYrmonSeq;
	 }
	
	/**
	* Column Info
	* @param seq
	*/
	public void setSeq(String seq) {
		this.seq = seq;
	}
 
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		 return	this.seq;
	}
	
	/**
	 * Column Info
	 * @param updtKey
	 */
	public void setUpdtKey(String updtKey) {
		this.updtKey = updtKey;
	}
	
	/**
	 * Column Info
	 * @return updtKey
	 */
	 public String getUpdtKey() {
		 return this.updtKey;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void	setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	 public String getDelChk() {
		 return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return vndrPayChgRmk
	 */
	public void setVndrPayChgRmk(String vndrPayChgRmk) {
		this.vndrPayChgRmk = vndrPayChgRmk;
	}
	
	/**
	 * Column Info
	 * @return vndrPayChgCmtCtnt
	 */
	public void setVndrPayChgCmtCtnt(String vndrPayChgCmtCtnt) {
		this.vndrPayChgCmtCtnt = vndrPayChgCmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return vndrPayChgCrStyCtnt
	 */
	public void setVndrPayChgCrStyCtnt(String vndrPayChgCrStyCtnt) {
		this.vndrPayChgCrStyCtnt = vndrPayChgCrStyCtnt;
	}
	
	/**
	 * Column Info
	 * @return vndrPayChgCrDueCtnt
	 */
	public void setVndrPayChgCrDueCtnt(String vndrPayChgCrDueCtnt) {
		this.vndrPayChgCrDueCtnt = vndrPayChgCrDueCtnt;
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
		setEqFmMvmtDt(JSPUtil.getParameter(request, prefix + "eq_fm_mvmt_dt", ""));
		setInvLseRtAmt(JSPUtil.getParameter(request, prefix + "inv_lse_rt_amt", ""));
		setInvTaxRtAmt(JSPUtil.getParameter(request, prefix + "inv_tax_rt_amt", ""));
		setChgCreSeq(JSPUtil.getParameter(request, prefix + "chg_cre_seq", ""));
		setInvCustEqNo(JSPUtil.getParameter(request, prefix + "inv_cust_eq_no", ""));
		setAudUmchEqStsEvntDt(JSPUtil.getParameter(request, prefix + "aud_umch_eq_sts_evnt_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvScNo(JSPUtil.getParameter(request, prefix + "inv_sc_no", ""));
		setInvBilUtDys(JSPUtil.getParameter(request, prefix + "inv_bil_ut_dys", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setPayBilUtDys(JSPUtil.getParameter(request, prefix + "pay_bil_ut_dys", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, prefix + "inv_cust_cnt_cd", ""));
		setInvEqOffhDt(JSPUtil.getParameter(request, prefix + "inv_eq_offh_dt", ""));
		setLseTaxRtAmt(JSPUtil.getParameter(request, prefix + "lse_tax_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPayTaxAmt(JSPUtil.getParameter(request, prefix + "pay_tax_amt", ""));
		setPayLseChgTtlAmt(JSPUtil.getParameter(request, prefix + "pay_lse_chg_ttl_amt", ""));
		setInvBkgTermCd(JSPUtil.getParameter(request, prefix + "inv_bkg_term_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setInvEqOnhLocNm(JSPUtil.getParameter(request, prefix + "inv_eq_onh_loc_nm", ""));
		setInvBkgNo(JSPUtil.getParameter(request, prefix + "inv_bkg_no", ""));
		setAudUmchEqAsetStsCd(JSPUtil.getParameter(request, prefix + "aud_umch_eq_aset_sts_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEqToYdCd(JSPUtil.getParameter(request, prefix + "eq_to_yd_cd", ""));
		setInvBilEndDt(JSPUtil.getParameter(request, prefix + "inv_bil_end_dt", ""));
		setEqFmMvmtCd(JSPUtil.getParameter(request, prefix + "eq_fm_mvmt_cd", ""));
		setEqToMvmtCd(JSPUtil.getParameter(request, prefix + "eq_to_mvmt_cd", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setInvEqNo(JSPUtil.getParameter(request, prefix + "inv_eq_no", ""));
		setInvLseChgTtlAmt(JSPUtil.getParameter(request, prefix + "inv_lse_chg_ttl_amt", ""));
		setEqOffhDt(JSPUtil.getParameter(request, prefix + "eq_offh_dt", ""));
		setLseChgAmt(JSPUtil.getParameter(request, prefix + "lse_chg_amt", ""));
		setLseRtAmt(JSPUtil.getParameter(request, prefix + "lse_rt_amt", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setPayTaxRtAmt(JSPUtil.getParameter(request, prefix + "pay_tax_rt_amt", ""));
		setEqOffhLocCd(JSPUtil.getParameter(request, prefix + "eq_offh_loc_cd", ""));
		setLseChgAudStsCd(JSPUtil.getParameter(request, prefix + "lse_chg_aud_sts_cd", ""));
		setInvTaxAmt(JSPUtil.getParameter(request, prefix + "inv_tax_amt", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setLseTaxAmt(JSPUtil.getParameter(request, prefix + "lse_tax_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEqBilStDt(JSPUtil.getParameter(request, prefix + "eq_bil_st_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setInvLseUseDys(JSPUtil.getParameter(request, prefix + "inv_lse_use_dys", ""));
		setLseChgAudRsltRsnCd(JSPUtil.getParameter(request, prefix + "lse_chg_aud_rslt_rsn_cd", ""));
		setPayLseUseDys(JSPUtil.getParameter(request, prefix + "pay_lse_use_dys", ""));
		setPayLseChgAmt(JSPUtil.getParameter(request, prefix + "pay_lse_chg_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInvEqOffhLocNm(JSPUtil.getParameter(request, prefix + "inv_eq_offh_loc_nm", ""));
		setEqOnhLocCd(JSPUtil.getParameter(request, prefix + "eq_onh_loc_cd", ""));
		setInvBilStDt(JSPUtil.getParameter(request, prefix + "inv_bil_st_dt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvCrAmt(JSPUtil.getParameter(request, prefix + "inv_cr_amt", ""));
		setLseBilUtDys(JSPUtil.getParameter(request, prefix + "lse_bil_ut_dys", ""));
		setInvYdCd(JSPUtil.getParameter(request, prefix + "inv_yd_cd", ""));
		setAudUmchEqStsEvntYdCd(JSPUtil.getParameter(request, prefix + "aud_umch_eq_sts_evnt_yd_cd", ""));
		setPayChgAudRmk(JSPUtil.getParameter(request, prefix + "pay_chg_aud_rmk", ""));
		setInvRefNo(JSPUtil.getParameter(request, prefix + "inv_ref_no", ""));
		setInvCustSeq(JSPUtil.getParameter(request, prefix + "inv_cust_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEqToMvmtDt(JSPUtil.getParameter(request, prefix + "eq_to_mvmt_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setPayLseRtAmt(JSPUtil.getParameter(request, prefix + "pay_lse_rt_amt", ""));
		setEqFmYdCd(JSPUtil.getParameter(request, prefix + "eq_fm_yd_cd", ""));
		setEqOnhDt(JSPUtil.getParameter(request, prefix + "eq_onh_dt", ""));
		setPayCrAmt(JSPUtil.getParameter(request, prefix + "pay_cr_amt", ""));
		setInvEqOnhDt(JSPUtil.getParameter(request, prefix + "inv_eq_onh_dt", ""));
		setLseChgTtlAmt(JSPUtil.getParameter(request, prefix + "lse_chg_ttl_amt", ""));
		setLseUseDys(JSPUtil.getParameter(request, prefix + "lse_use_dys", ""));
		setEqBilEndDt(JSPUtil.getParameter(request, prefix + "eq_bil_end_dt", ""));
		setInvLseChgAmt(JSPUtil.getParameter(request, prefix + "inv_lse_chg_amt", ""));
		setPayLseChgStsCd(JSPUtil.getParameter(request, prefix + "pay_lse_chg_sts_cd", ""));
		setCostYrmonSeq(JSPUtil.getParameter(request, prefix + "cost_yrmon_seq", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setUpdtKey(JSPUtil.getParameter(request, prefix + "updt_key", ""));
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setVndrPayChgRmk(JSPUtil.getParameter(request, prefix + "vndr_pay_chg_rmk", ""));
		setVndrPayChgCmtCtnt(JSPUtil.getParameter(request, prefix + "vndr_pay_chg_cmt_ctnt", ""));
		setVndrPayChgCrStyCtnt(JSPUtil.getParameter(request, prefix + "vndr_pay_chg_cr_sty_ctnt", ""));
		setVndrPayChgCrDueCtnt(JSPUtil.getParameter(request, prefix + "vndr_pay_chg_cr_due_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSCpsAuditResultUpdateINVO[]
	 */
	public CHSCpsAuditResultUpdateINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSCpsAuditResultUpdateINVO[]
	 */
	public CHSCpsAuditResultUpdateINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSCpsAuditResultUpdateINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqFmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "eq_fm_mvmt_dt", length));
			String[] invLseRtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_rt_amt", length));
			String[] invTaxRtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt_amt", length));
			String[] chgCreSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cre_seq", length));
			String[] invCustEqNo = (JSPUtil.getParameter(request, prefix	+ "inv_cust_eq_no", length));
			String[] audUmchEqStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_sts_evnt_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invScNo = (JSPUtil.getParameter(request, prefix	+ "inv_sc_no", length));
			String[] invBilUtDys = (JSPUtil.getParameter(request, prefix	+ "inv_bil_ut_dys", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] payBilUtDys = (JSPUtil.getParameter(request, prefix	+ "pay_bil_ut_dys", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] invEqOffhDt = (JSPUtil.getParameter(request, prefix	+ "inv_eq_offh_dt", length));
			String[] lseTaxRtAmt = (JSPUtil.getParameter(request, prefix	+ "lse_tax_rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] payTaxAmt = (JSPUtil.getParameter(request, prefix	+ "pay_tax_amt", length));
			String[] payLseChgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_ttl_amt", length));
			String[] invBkgTermCd = (JSPUtil.getParameter(request, prefix	+ "inv_bkg_term_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] invEqOnhLocNm = (JSPUtil.getParameter(request, prefix	+ "inv_eq_onh_loc_nm", length));
			String[] invBkgNo = (JSPUtil.getParameter(request, prefix	+ "inv_bkg_no", length));
			String[] audUmchEqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_aset_sts_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eqToYdCd = (JSPUtil.getParameter(request, prefix	+ "eq_to_yd_cd", length));
			String[] invBilEndDt = (JSPUtil.getParameter(request, prefix	+ "inv_bil_end_dt", length));
			String[] eqFmMvmtCd = (JSPUtil.getParameter(request, prefix	+ "eq_fm_mvmt_cd", length));
			String[] eqToMvmtCd = (JSPUtil.getParameter(request, prefix	+ "eq_to_mvmt_cd", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] invEqNo = (JSPUtil.getParameter(request, prefix	+ "inv_eq_no", length));
			String[] invLseChgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_chg_ttl_amt", length));
			String[] eqOffhDt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_dt", length));
			String[] lseChgAmt = (JSPUtil.getParameter(request, prefix	+ "lse_chg_amt", length));
			String[] lseRtAmt = (JSPUtil.getParameter(request, prefix	+ "lse_rt_amt", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] payTaxRtAmt = (JSPUtil.getParameter(request, prefix	+ "pay_tax_rt_amt", length));
			String[] eqOffhLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_offh_loc_cd", length));
			String[] lseChgAudStsCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_aud_sts_cd", length));
			String[] invTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_amt", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] lseTaxAmt = (JSPUtil.getParameter(request, prefix	+ "lse_tax_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqBilStDt = (JSPUtil.getParameter(request, prefix	+ "eq_bil_st_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] invLseUseDys = (JSPUtil.getParameter(request, prefix	+ "inv_lse_use_dys", length));
			String[] lseChgAudRsltRsnCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_aud_rslt_rsn_cd", length));
			String[] payLseUseDys = (JSPUtil.getParameter(request, prefix	+ "pay_lse_use_dys", length));
			String[] payLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] invEqOffhLocNm = (JSPUtil.getParameter(request, prefix	+ "inv_eq_offh_loc_nm", length));
			String[] eqOnhLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_onh_loc_cd", length));
			String[] invBilStDt = (JSPUtil.getParameter(request, prefix	+ "inv_bil_st_dt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invCrAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cr_amt", length));
			String[] lseBilUtDys = (JSPUtil.getParameter(request, prefix	+ "lse_bil_ut_dys", length));
			String[] invYdCd = (JSPUtil.getParameter(request, prefix	+ "inv_yd_cd", length));
			String[] audUmchEqStsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_sts_evnt_yd_cd", length));
			String[] payChgAudRmk = (JSPUtil.getParameter(request, prefix	+ "pay_chg_aud_rmk", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqToMvmtDt = (JSPUtil.getParameter(request, prefix	+ "eq_to_mvmt_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] payLseRtAmt = (JSPUtil.getParameter(request, prefix	+ "pay_lse_rt_amt", length));
			String[] eqFmYdCd = (JSPUtil.getParameter(request, prefix	+ "eq_fm_yd_cd", length));
			String[] eqOnhDt = (JSPUtil.getParameter(request, prefix	+ "eq_onh_dt", length));
			String[] payCrAmt = (JSPUtil.getParameter(request, prefix	+ "pay_cr_amt", length));
			String[] invEqOnhDt = (JSPUtil.getParameter(request, prefix	+ "inv_eq_onh_dt", length));
			String[] lseChgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "lse_chg_ttl_amt", length));
			String[] lseUseDys = (JSPUtil.getParameter(request, prefix	+ "lse_use_dys", length));
			String[] eqBilEndDt = (JSPUtil.getParameter(request, prefix	+ "eq_bil_end_dt", length));
			String[] invLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_chg_amt", length));
			String[] payLseChgStsCd = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_sts_cd", length));
			String[] costYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon_seq", length));
			String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
			String[] updtKey = (JSPUtil.getParameter(request, prefix + "updt_key", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix + "del_chk", length));
			String[] vndrPayChgRmk = (JSPUtil.getParameter(request, prefix + "vndr_pay_chg_rmk", length));
			String[] vndrPayChgCmtCtnt = (JSPUtil.getParameter(request, prefix + "vndr_pay_chg_cmt_ctnt", length));
			String[] vndrPayChgCrStyCtnt = (JSPUtil.getParameter(request, prefix + "vndr_pay_chg_cr_sty_ctnt", length));
			String[] vndrPayChgCrDueCtnt = (JSPUtil.getParameter(request, prefix + "vndr_pay_chg_cr_due_ctnt", length));
			for (int i = 0; i < length; i++) {
				model = new CHSCpsAuditResultUpdateINVO();
				if (eqFmMvmtDt[i] != null)
					model.setEqFmMvmtDt(eqFmMvmtDt[i]);
				if (invLseRtAmt[i] != null)
					model.setInvLseRtAmt(invLseRtAmt[i]);
				if (invTaxRtAmt[i] != null)
					model.setInvTaxRtAmt(invTaxRtAmt[i]);
				if (chgCreSeq[i] != null)
					model.setChgCreSeq(chgCreSeq[i]);
				if (invCustEqNo[i] != null)
					model.setInvCustEqNo(invCustEqNo[i]);
				if (audUmchEqStsEvntDt[i] != null)
					model.setAudUmchEqStsEvntDt(audUmchEqStsEvntDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invScNo[i] != null)
					model.setInvScNo(invScNo[i]);
				if (invBilUtDys[i] != null)
					model.setInvBilUtDys(invBilUtDys[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (payBilUtDys[i] != null)
					model.setPayBilUtDys(payBilUtDys[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (invEqOffhDt[i] != null)
					model.setInvEqOffhDt(invEqOffhDt[i]);
				if (lseTaxRtAmt[i] != null)
					model.setLseTaxRtAmt(lseTaxRtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (payTaxAmt[i] != null)
					model.setPayTaxAmt(payTaxAmt[i]);
				if (payLseChgTtlAmt[i] != null)
					model.setPayLseChgTtlAmt(payLseChgTtlAmt[i]);
				if (invBkgTermCd[i] != null)
					model.setInvBkgTermCd(invBkgTermCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (invEqOnhLocNm[i] != null)
					model.setInvEqOnhLocNm(invEqOnhLocNm[i]);
				if (invBkgNo[i] != null)
					model.setInvBkgNo(invBkgNo[i]);
				if (audUmchEqAsetStsCd[i] != null)
					model.setAudUmchEqAsetStsCd(audUmchEqAsetStsCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqToYdCd[i] != null)
					model.setEqToYdCd(eqToYdCd[i]);
				if (invBilEndDt[i] != null)
					model.setInvBilEndDt(invBilEndDt[i]);
				if (eqFmMvmtCd[i] != null)
					model.setEqFmMvmtCd(eqFmMvmtCd[i]);
				if (eqToMvmtCd[i] != null)
					model.setEqToMvmtCd(eqToMvmtCd[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (invEqNo[i] != null)
					model.setInvEqNo(invEqNo[i]);
				if (invLseChgTtlAmt[i] != null)
					model.setInvLseChgTtlAmt(invLseChgTtlAmt[i]);
				if (eqOffhDt[i] != null)
					model.setEqOffhDt(eqOffhDt[i]);
				if (lseChgAmt[i] != null)
					model.setLseChgAmt(lseChgAmt[i]);
				if (lseRtAmt[i] != null)
					model.setLseRtAmt(lseRtAmt[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (payTaxRtAmt[i] != null)
					model.setPayTaxRtAmt(payTaxRtAmt[i]);
				if (eqOffhLocCd[i] != null)
					model.setEqOffhLocCd(eqOffhLocCd[i]);
				if (lseChgAudStsCd[i] != null)
					model.setLseChgAudStsCd(lseChgAudStsCd[i]);
				if (invTaxAmt[i] != null)
					model.setInvTaxAmt(invTaxAmt[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (lseTaxAmt[i] != null)
					model.setLseTaxAmt(lseTaxAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqBilStDt[i] != null)
					model.setEqBilStDt(eqBilStDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (invLseUseDys[i] != null)
					model.setInvLseUseDys(invLseUseDys[i]);
				if (lseChgAudRsltRsnCd[i] != null)
					model.setLseChgAudRsltRsnCd(lseChgAudRsltRsnCd[i]);
				if (payLseUseDys[i] != null)
					model.setPayLseUseDys(payLseUseDys[i]);
				if (payLseChgAmt[i] != null)
					model.setPayLseChgAmt(payLseChgAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (invEqOffhLocNm[i] != null)
					model.setInvEqOffhLocNm(invEqOffhLocNm[i]);
				if (eqOnhLocCd[i] != null)
					model.setEqOnhLocCd(eqOnhLocCd[i]);
				if (invBilStDt[i] != null)
					model.setInvBilStDt(invBilStDt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invCrAmt[i] != null)
					model.setInvCrAmt(invCrAmt[i]);
				if (lseBilUtDys[i] != null)
					model.setLseBilUtDys(lseBilUtDys[i]);
				if (invYdCd[i] != null)
					model.setInvYdCd(invYdCd[i]);
				if (audUmchEqStsEvntYdCd[i] != null)
					model.setAudUmchEqStsEvntYdCd(audUmchEqStsEvntYdCd[i]);
				if (payChgAudRmk[i] != null)
					model.setPayChgAudRmk(payChgAudRmk[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqToMvmtDt[i] != null)
					model.setEqToMvmtDt(eqToMvmtDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (payLseRtAmt[i] != null)
					model.setPayLseRtAmt(payLseRtAmt[i]);
				if (eqFmYdCd[i] != null)
					model.setEqFmYdCd(eqFmYdCd[i]);
				if (eqOnhDt[i] != null)
					model.setEqOnhDt(eqOnhDt[i]);
				if (payCrAmt[i] != null)
					model.setPayCrAmt(payCrAmt[i]);
				if (invEqOnhDt[i] != null)
					model.setInvEqOnhDt(invEqOnhDt[i]);
				if (lseChgTtlAmt[i] != null)
					model.setLseChgTtlAmt(lseChgTtlAmt[i]);
				if (lseUseDys[i] != null)
					model.setLseUseDys(lseUseDys[i]);
				if (eqBilEndDt[i] != null)
					model.setEqBilEndDt(eqBilEndDt[i]);
				if (invLseChgAmt[i] != null)
					model.setInvLseChgAmt(invLseChgAmt[i]);
				if (payLseChgStsCd[i] != null)
					model.setPayLseChgStsCd(payLseChgStsCd[i]);
				if (costYrmonSeq[i] != null)
					model.setCostYrmonSeq(costYrmonSeq[i]);				
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if ( updtKey[i] != null)
					model.setUpdtKey(updtKey[i]);
				if ( delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (vndrPayChgRmk[i] != null)
					model.setVndrPayChgRmk(vndrPayChgRmk[i]);
				if (vndrPayChgCmtCtnt[i] != null)
					model.setVndrPayChgCmtCtnt(vndrPayChgCmtCtnt[i]);
				if (vndrPayChgCrStyCtnt[i] != null)
					model.setVndrPayChgCrStyCtnt(vndrPayChgCrStyCtnt[i]);
				if (vndrPayChgCrDueCtnt[i] != null)
					model.setVndrPayChgCrDueCtnt(vndrPayChgCrDueCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSCpsAuditResultUpdateINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSCpsAuditResultUpdateINVO[]
	 */
	public CHSCpsAuditResultUpdateINVO[] getCHSCpsAuditResultUpdateINVOs(){
		CHSCpsAuditResultUpdateINVO[] vos = (CHSCpsAuditResultUpdateINVO[])models.toArray(new CHSCpsAuditResultUpdateINVO[models.size()]);
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
		this.eqFmMvmtDt = this.eqFmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseRtAmt = this.invLseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRtAmt = this.invTaxRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCreSeq = this.chgCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustEqNo = this.invCustEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqStsEvntDt = this.audUmchEqStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invScNo = this.invScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilUtDys = this.invBilUtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBilUtDys = this.payBilUtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOffhDt = this.invEqOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseTaxRtAmt = this.lseTaxRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTaxAmt = this.payTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgTtlAmt = this.payLseChgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBkgTermCd = this.invBkgTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOnhLocNm = this.invEqOnhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBkgNo = this.invBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqAsetStsCd = this.audUmchEqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqToYdCd = this.eqToYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilEndDt = this.invBilEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqFmMvmtCd = this.eqFmMvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqToMvmtCd = this.eqToMvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqNo = this.invEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseChgTtlAmt = this.invLseChgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhDt = this.eqOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAmt = this.lseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRtAmt = this.lseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTaxRtAmt = this.payTaxRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhLocCd = this.eqOffhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAudStsCd = this.lseChgAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxAmt = this.invTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseTaxAmt = this.lseTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqBilStDt = this.eqBilStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseUseDys = this.invLseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAudRsltRsnCd = this.lseChgAudRsltRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseUseDys = this.payLseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgAmt = this.payLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOffhLocNm = this.invEqOffhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOnhLocCd = this.eqOnhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilStDt = this.invBilStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCrAmt = this.invCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseBilUtDys = this.lseBilUtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invYdCd = this.invYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqStsEvntYdCd = this.audUmchEqStsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payChgAudRmk = this.payChgAudRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqToMvmtDt = this.eqToMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseRtAmt = this.payLseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqFmYdCd = this.eqFmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOnhDt = this.eqOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCrAmt = this.payCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOnhDt = this.invEqOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgTtlAmt = this.lseChgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseUseDys = this.lseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqBilEndDt = this.eqBilEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseChgAmt = this.invLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgStsCd = this.payLseChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonSeq = this.costYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updtKey = this.updtKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPayChgRmk = this.vndrPayChgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPayChgCmtCtnt = this.vndrPayChgCmtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPayChgCrStyCtnt = this.vndrPayChgCrStyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPayChgCrDueCtnt = this.vndrPayChgCrDueCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
