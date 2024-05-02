/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MGSInvoiceImportAuditINVO.java
*@FileTitle : MGSInvoiceImportAuditINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.28 조재성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSInvoiceImportAuditINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSInvoiceImportAuditINVO> models = new ArrayList<MGSInvoiceImportAuditINVO>();
	
	/* Column Info */
	private String invLseRtAmt = null;
	/* Column Info */
	private String crSmryAmt = null;
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
	private String costYrmon = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String taxSmryAmt = null;
	/* Column Info */
	private String invChgTpNm = null;
	/* Column Info */
	private String invEqOffhDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String lseChgStsCd = null;
	/* Column Info */
	private String invEqOnhLocNm = null;
	/* Column Info */
	private String audUmchEqAsetStsCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String invBilEndDt = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String invEqNo = null;
	/* Column Info */
	private String lseChgAmt = null;
	/* Column Info */
	private String lseRtAmt = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String lseChgAudStsCd = null;
	/* Column Info */
	private String invTaxAmt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String vrfyRsltDesc = null;
	/* Column Info */
	private String invLseUseDys = null;
	/* Column Info */
	private String lseChgAudRsltRsnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invEqOffhLocNm = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String invBilStDt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invCrAmt = null;
	/* Column Info */
	private String audUmchEqStsEvntYdCd = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String vrfyScsFlg = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String invEqOnhDt = null;
	/* Column Info */
	private String lseUseDys = null;
	/* Column Info */
	private String payLseChgStsCd = null;
	/* Column Info */
	private String invLseChgAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSInvoiceImportAuditINVO() {}

	public MGSInvoiceImportAuditINVO(String ibflag, String pagerows, String invLseRtAmt, String currCd, String lseChgAudStsCd, String invTaxAmt, String crSmryAmt, String chgCreSeq, String invCustEqNo, String vrfyRsltDesc, String invLseUseDys, String audUmchEqStsEvntDt, String lseChgAudRsltRsnCd, String chgCd, String costYrmon, String eqNo, String invEqOffhLocNm, String eqAsetStsCd, String costCd, String taxSmryAmt, String invBilStDt, String invChgTpNm, String acctCd, String invEqOffhDt, String updUsrId, String invCrAmt, String audUmchEqStsEvntYdCd, String invRefNo, String vrfyScsFlg, String agmtSeq, String lseChgStsCd, String invEqOnhLocNm, String audUmchEqAsetStsCd, String agmtLstmCd, String eqKndCd, String invNo, String creUsrId, String invBilEndDt, String agmtOfcCtyCd, String invEqNo, String invSmryAmt, String invEqOnhDt, String lseChgAmt, String lseRtAmt, String agmtVerNo, String lseUseDys, String payLseChgStsCd, String invLseChgAmt, String invSeq) {
		this.invLseRtAmt = invLseRtAmt;
		this.crSmryAmt = crSmryAmt;
		this.chgCreSeq = chgCreSeq;
		this.invCustEqNo = invCustEqNo;
		this.audUmchEqStsEvntDt = audUmchEqStsEvntDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.costYrmon = costYrmon;
		this.costCd = costCd;
		this.eqAsetStsCd = eqAsetStsCd;
		this.taxSmryAmt = taxSmryAmt;
		this.invChgTpNm = invChgTpNm;
		this.invEqOffhDt = invEqOffhDt;
		this.updUsrId = updUsrId;
		this.agmtSeq = agmtSeq;
		this.lseChgStsCd = lseChgStsCd;
		this.invEqOnhLocNm = invEqOnhLocNm;
		this.audUmchEqAsetStsCd = audUmchEqAsetStsCd;
		this.agmtLstmCd = agmtLstmCd;
		this.creUsrId = creUsrId;
		this.invBilEndDt = invBilEndDt;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.invEqNo = invEqNo;
		this.lseChgAmt = lseChgAmt;
		this.lseRtAmt = lseRtAmt;
		this.agmtVerNo = agmtVerNo;
		this.currCd = currCd;
		this.lseChgAudStsCd = lseChgAudStsCd;
		this.invTaxAmt = invTaxAmt;
		this.invSeq = invSeq;
		this.vrfyRsltDesc = vrfyRsltDesc;
		this.invLseUseDys = invLseUseDys;
		this.lseChgAudRsltRsnCd = lseChgAudRsltRsnCd;
		this.ibflag = ibflag;
		this.invEqOffhLocNm = invEqOffhLocNm;
		this.eqNo = eqNo;
		this.invBilStDt = invBilStDt;
		this.acctCd = acctCd;
		this.invCrAmt = invCrAmt;
		this.audUmchEqStsEvntYdCd = audUmchEqStsEvntYdCd;
		this.invRefNo = invRefNo;
		this.vrfyScsFlg = vrfyScsFlg;
		this.eqKndCd = eqKndCd;
		this.invNo = invNo;
		this.invSmryAmt = invSmryAmt;
		this.invEqOnhDt = invEqOnhDt;
		this.lseUseDys = lseUseDys;
		this.payLseChgStsCd = payLseChgStsCd;
		this.invLseChgAmt = invLseChgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_lse_rt_amt", getInvLseRtAmt());
		this.hashColumns.put("cr_smry_amt", getCrSmryAmt());
		this.hashColumns.put("chg_cre_seq", getChgCreSeq());
		this.hashColumns.put("inv_cust_eq_no", getInvCustEqNo());
		this.hashColumns.put("aud_umch_eq_sts_evnt_dt", getAudUmchEqStsEvntDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("tax_smry_amt", getTaxSmryAmt());
		this.hashColumns.put("inv_chg_tp_nm", getInvChgTpNm());
		this.hashColumns.put("inv_eq_offh_dt", getInvEqOffhDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("lse_chg_sts_cd", getLseChgStsCd());
		this.hashColumns.put("inv_eq_onh_loc_nm", getInvEqOnhLocNm());
		this.hashColumns.put("aud_umch_eq_aset_sts_cd", getAudUmchEqAsetStsCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inv_bil_end_dt", getInvBilEndDt());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("inv_eq_no", getInvEqNo());
		this.hashColumns.put("lse_chg_amt", getLseChgAmt());
		this.hashColumns.put("lse_rt_amt", getLseRtAmt());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("lse_chg_aud_sts_cd", getLseChgAudStsCd());
		this.hashColumns.put("inv_tax_amt", getInvTaxAmt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("vrfy_rslt_desc", getVrfyRsltDesc());
		this.hashColumns.put("inv_lse_use_dys", getInvLseUseDys());
		this.hashColumns.put("lse_chg_aud_rslt_rsn_cd", getLseChgAudRsltRsnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_eq_offh_loc_nm", getInvEqOffhLocNm());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inv_bil_st_dt", getInvBilStDt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_cr_amt", getInvCrAmt());
		this.hashColumns.put("aud_umch_eq_sts_evnt_yd_cd", getAudUmchEqStsEvntYdCd());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("vrfy_scs_flg", getVrfyScsFlg());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("inv_eq_onh_dt", getInvEqOnhDt());
		this.hashColumns.put("lse_use_dys", getLseUseDys());
		this.hashColumns.put("pay_lse_chg_sts_cd", getPayLseChgStsCd());
		this.hashColumns.put("inv_lse_chg_amt", getInvLseChgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_lse_rt_amt", "invLseRtAmt");
		this.hashFields.put("cr_smry_amt", "crSmryAmt");
		this.hashFields.put("chg_cre_seq", "chgCreSeq");
		this.hashFields.put("inv_cust_eq_no", "invCustEqNo");
		this.hashFields.put("aud_umch_eq_sts_evnt_dt", "audUmchEqStsEvntDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("tax_smry_amt", "taxSmryAmt");
		this.hashFields.put("inv_chg_tp_nm", "invChgTpNm");
		this.hashFields.put("inv_eq_offh_dt", "invEqOffhDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("lse_chg_sts_cd", "lseChgStsCd");
		this.hashFields.put("inv_eq_onh_loc_nm", "invEqOnhLocNm");
		this.hashFields.put("aud_umch_eq_aset_sts_cd", "audUmchEqAsetStsCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_bil_end_dt", "invBilEndDt");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("inv_eq_no", "invEqNo");
		this.hashFields.put("lse_chg_amt", "lseChgAmt");
		this.hashFields.put("lse_rt_amt", "lseRtAmt");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("lse_chg_aud_sts_cd", "lseChgAudStsCd");
		this.hashFields.put("inv_tax_amt", "invTaxAmt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("vrfy_rslt_desc", "vrfyRsltDesc");
		this.hashFields.put("inv_lse_use_dys", "invLseUseDys");
		this.hashFields.put("lse_chg_aud_rslt_rsn_cd", "lseChgAudRsltRsnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_eq_offh_loc_nm", "invEqOffhLocNm");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inv_bil_st_dt", "invBilStDt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_cr_amt", "invCrAmt");
		this.hashFields.put("aud_umch_eq_sts_evnt_yd_cd", "audUmchEqStsEvntYdCd");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("vrfy_scs_flg", "vrfyScsFlg");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("inv_eq_onh_dt", "invEqOnhDt");
		this.hashFields.put("lse_use_dys", "lseUseDys");
		this.hashFields.put("pay_lse_chg_sts_cd", "payLseChgStsCd");
		this.hashFields.put("inv_lse_chg_amt", "invLseChgAmt");
		return this.hashFields;
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
	 * @return crSmryAmt
	 */
	public String getCrSmryAmt() {
		return this.crSmryAmt;
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
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @return taxSmryAmt
	 */
	public String getTaxSmryAmt() {
		return this.taxSmryAmt;
	}
	
	/**
	 * Column Info
	 * @return invChgTpNm
	 */
	public String getInvChgTpNm() {
		return this.invChgTpNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return lseChgStsCd
	 */
	public String getLseChgStsCd() {
		return this.lseChgStsCd;
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
	 * @return audUmchEqAsetStsCd
	 */
	public String getAudUmchEqAsetStsCd() {
		return this.audUmchEqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
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
	 * @return invBilEndDt
	 */
	public String getInvBilEndDt() {
		return this.invBilEndDt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return vrfyRsltDesc
	 */
	public String getVrfyRsltDesc() {
		return this.vrfyRsltDesc;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return invCrAmt
	 */
	public String getInvCrAmt() {
		return this.invCrAmt;
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
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
	}
	
	/**
	 * Column Info
	 * @return vrfyScsFlg
	 */
	public String getVrfyScsFlg() {
		return this.vrfyScsFlg;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return invSmryAmt
	 */
	public String getInvSmryAmt() {
		return this.invSmryAmt;
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
	 * @return lseUseDys
	 */
	public String getLseUseDys() {
		return this.lseUseDys;
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
	 * @return invLseChgAmt
	 */
	public String getInvLseChgAmt() {
		return this.invLseChgAmt;
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
	 * @param crSmryAmt
	 */
	public void setCrSmryAmt(String crSmryAmt) {
		this.crSmryAmt = crSmryAmt;
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
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @param taxSmryAmt
	 */
	public void setTaxSmryAmt(String taxSmryAmt) {
		this.taxSmryAmt = taxSmryAmt;
	}
	
	/**
	 * Column Info
	 * @param invChgTpNm
	 */
	public void setInvChgTpNm(String invChgTpNm) {
		this.invChgTpNm = invChgTpNm;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param lseChgStsCd
	 */
	public void setLseChgStsCd(String lseChgStsCd) {
		this.lseChgStsCd = lseChgStsCd;
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
	 * @param audUmchEqAsetStsCd
	 */
	public void setAudUmchEqAsetStsCd(String audUmchEqAsetStsCd) {
		this.audUmchEqAsetStsCd = audUmchEqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
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
	 * @param invBilEndDt
	 */
	public void setInvBilEndDt(String invBilEndDt) {
		this.invBilEndDt = invBilEndDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param vrfyRsltDesc
	 */
	public void setVrfyRsltDesc(String vrfyRsltDesc) {
		this.vrfyRsltDesc = vrfyRsltDesc;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param invCrAmt
	 */
	public void setInvCrAmt(String invCrAmt) {
		this.invCrAmt = invCrAmt;
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
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
	}
	
	/**
	 * Column Info
	 * @param vrfyScsFlg
	 */
	public void setVrfyScsFlg(String vrfyScsFlg) {
		this.vrfyScsFlg = vrfyScsFlg;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param invSmryAmt
	 */
	public void setInvSmryAmt(String invSmryAmt) {
		this.invSmryAmt = invSmryAmt;
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
	 * @param lseUseDys
	 */
	public void setLseUseDys(String lseUseDys) {
		this.lseUseDys = lseUseDys;
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
	 * @param invLseChgAmt
	 */
	public void setInvLseChgAmt(String invLseChgAmt) {
		this.invLseChgAmt = invLseChgAmt;
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
		setInvLseRtAmt(JSPUtil.getParameter(request, prefix + "inv_lse_rt_amt", ""));
		setCrSmryAmt(JSPUtil.getParameter(request, prefix + "cr_smry_amt", ""));
		setChgCreSeq(JSPUtil.getParameter(request, prefix + "chg_cre_seq", ""));
		setInvCustEqNo(JSPUtil.getParameter(request, prefix + "inv_cust_eq_no", ""));
		setAudUmchEqStsEvntDt(JSPUtil.getParameter(request, prefix + "aud_umch_eq_sts_evnt_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, prefix + "eq_aset_sts_cd", ""));
		setTaxSmryAmt(JSPUtil.getParameter(request, prefix + "tax_smry_amt", ""));
		setInvChgTpNm(JSPUtil.getParameter(request, prefix + "inv_chg_tp_nm", ""));
		setInvEqOffhDt(JSPUtil.getParameter(request, prefix + "inv_eq_offh_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setLseChgStsCd(JSPUtil.getParameter(request, prefix + "lse_chg_sts_cd", ""));
		setInvEqOnhLocNm(JSPUtil.getParameter(request, prefix + "inv_eq_onh_loc_nm", ""));
		setAudUmchEqAsetStsCd(JSPUtil.getParameter(request, prefix + "aud_umch_eq_aset_sts_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInvBilEndDt(JSPUtil.getParameter(request, prefix + "inv_bil_end_dt", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setInvEqNo(JSPUtil.getParameter(request, prefix + "inv_eq_no", ""));
		setLseChgAmt(JSPUtil.getParameter(request, prefix + "lse_chg_amt", ""));
		setLseRtAmt(JSPUtil.getParameter(request, prefix + "lse_rt_amt", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setLseChgAudStsCd(JSPUtil.getParameter(request, prefix + "lse_chg_aud_sts_cd", ""));
		setInvTaxAmt(JSPUtil.getParameter(request, prefix + "inv_tax_amt", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setVrfyRsltDesc(JSPUtil.getParameter(request, prefix + "vrfy_rslt_desc", ""));
		setInvLseUseDys(JSPUtil.getParameter(request, prefix + "inv_lse_use_dys", ""));
		setLseChgAudRsltRsnCd(JSPUtil.getParameter(request, prefix + "lse_chg_aud_rslt_rsn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvEqOffhLocNm(JSPUtil.getParameter(request, prefix + "inv_eq_offh_loc_nm", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInvBilStDt(JSPUtil.getParameter(request, prefix + "inv_bil_st_dt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvCrAmt(JSPUtil.getParameter(request, prefix + "inv_cr_amt", ""));
		setAudUmchEqStsEvntYdCd(JSPUtil.getParameter(request, prefix + "aud_umch_eq_sts_evnt_yd_cd", ""));
		setInvRefNo(JSPUtil.getParameter(request, prefix + "inv_ref_no", ""));
		setVrfyScsFlg(JSPUtil.getParameter(request, prefix + "vrfy_scs_flg", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, prefix + "inv_smry_amt", ""));
		setInvEqOnhDt(JSPUtil.getParameter(request, prefix + "inv_eq_onh_dt", ""));
		setLseUseDys(JSPUtil.getParameter(request, prefix + "lse_use_dys", ""));
		setPayLseChgStsCd(JSPUtil.getParameter(request, prefix + "pay_lse_chg_sts_cd", ""));
		setInvLseChgAmt(JSPUtil.getParameter(request, prefix + "inv_lse_chg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSInvoiceImportAuditINVO[]
	 */
	public MGSInvoiceImportAuditINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSInvoiceImportAuditINVO[]
	 */
	public MGSInvoiceImportAuditINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSInvoiceImportAuditINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invLseRtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_rt_amt", length));
			String[] crSmryAmt = (JSPUtil.getParameter(request, prefix	+ "cr_smry_amt", length));
			String[] chgCreSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cre_seq", length));
			String[] invCustEqNo = (JSPUtil.getParameter(request, prefix	+ "inv_cust_eq_no", length));
			String[] audUmchEqStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_sts_evnt_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] taxSmryAmt = (JSPUtil.getParameter(request, prefix	+ "tax_smry_amt", length));
			String[] invChgTpNm = (JSPUtil.getParameter(request, prefix	+ "inv_chg_tp_nm", length));
			String[] invEqOffhDt = (JSPUtil.getParameter(request, prefix	+ "inv_eq_offh_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] lseChgStsCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_sts_cd", length));
			String[] invEqOnhLocNm = (JSPUtil.getParameter(request, prefix	+ "inv_eq_onh_loc_nm", length));
			String[] audUmchEqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_aset_sts_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] invBilEndDt = (JSPUtil.getParameter(request, prefix	+ "inv_bil_end_dt", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] invEqNo = (JSPUtil.getParameter(request, prefix	+ "inv_eq_no", length));
			String[] lseChgAmt = (JSPUtil.getParameter(request, prefix	+ "lse_chg_amt", length));
			String[] lseRtAmt = (JSPUtil.getParameter(request, prefix	+ "lse_rt_amt", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] lseChgAudStsCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_aud_sts_cd", length));
			String[] invTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_amt", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] vrfyRsltDesc = (JSPUtil.getParameter(request, prefix	+ "vrfy_rslt_desc", length));
			String[] invLseUseDys = (JSPUtil.getParameter(request, prefix	+ "inv_lse_use_dys", length));
			String[] lseChgAudRsltRsnCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_aud_rslt_rsn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invEqOffhLocNm = (JSPUtil.getParameter(request, prefix	+ "inv_eq_offh_loc_nm", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] invBilStDt = (JSPUtil.getParameter(request, prefix	+ "inv_bil_st_dt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invCrAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cr_amt", length));
			String[] audUmchEqStsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_sts_evnt_yd_cd", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] vrfyScsFlg = (JSPUtil.getParameter(request, prefix	+ "vrfy_scs_flg", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] invEqOnhDt = (JSPUtil.getParameter(request, prefix	+ "inv_eq_onh_dt", length));
			String[] lseUseDys = (JSPUtil.getParameter(request, prefix	+ "lse_use_dys", length));
			String[] payLseChgStsCd = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_sts_cd", length));
			String[] invLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_chg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSInvoiceImportAuditINVO();
				if (invLseRtAmt[i] != null)
					model.setInvLseRtAmt(invLseRtAmt[i]);
				if (crSmryAmt[i] != null)
					model.setCrSmryAmt(crSmryAmt[i]);
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
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (taxSmryAmt[i] != null)
					model.setTaxSmryAmt(taxSmryAmt[i]);
				if (invChgTpNm[i] != null)
					model.setInvChgTpNm(invChgTpNm[i]);
				if (invEqOffhDt[i] != null)
					model.setInvEqOffhDt(invEqOffhDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (lseChgStsCd[i] != null)
					model.setLseChgStsCd(lseChgStsCd[i]);
				if (invEqOnhLocNm[i] != null)
					model.setInvEqOnhLocNm(invEqOnhLocNm[i]);
				if (audUmchEqAsetStsCd[i] != null)
					model.setAudUmchEqAsetStsCd(audUmchEqAsetStsCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (invBilEndDt[i] != null)
					model.setInvBilEndDt(invBilEndDt[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (invEqNo[i] != null)
					model.setInvEqNo(invEqNo[i]);
				if (lseChgAmt[i] != null)
					model.setLseChgAmt(lseChgAmt[i]);
				if (lseRtAmt[i] != null)
					model.setLseRtAmt(lseRtAmt[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (lseChgAudStsCd[i] != null)
					model.setLseChgAudStsCd(lseChgAudStsCd[i]);
				if (invTaxAmt[i] != null)
					model.setInvTaxAmt(invTaxAmt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (vrfyRsltDesc[i] != null)
					model.setVrfyRsltDesc(vrfyRsltDesc[i]);
				if (invLseUseDys[i] != null)
					model.setInvLseUseDys(invLseUseDys[i]);
				if (lseChgAudRsltRsnCd[i] != null)
					model.setLseChgAudRsltRsnCd(lseChgAudRsltRsnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invEqOffhLocNm[i] != null)
					model.setInvEqOffhLocNm(invEqOffhLocNm[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (invBilStDt[i] != null)
					model.setInvBilStDt(invBilStDt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invCrAmt[i] != null)
					model.setInvCrAmt(invCrAmt[i]);
				if (audUmchEqStsEvntYdCd[i] != null)
					model.setAudUmchEqStsEvntYdCd(audUmchEqStsEvntYdCd[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (vrfyScsFlg[i] != null)
					model.setVrfyScsFlg(vrfyScsFlg[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (invEqOnhDt[i] != null)
					model.setInvEqOnhDt(invEqOnhDt[i]);
				if (lseUseDys[i] != null)
					model.setLseUseDys(lseUseDys[i]);
				if (payLseChgStsCd[i] != null)
					model.setPayLseChgStsCd(payLseChgStsCd[i]);
				if (invLseChgAmt[i] != null)
					model.setInvLseChgAmt(invLseChgAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSInvoiceImportAuditINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSInvoiceImportAuditINVO[]
	 */
	public MGSInvoiceImportAuditINVO[] getMGSInvoiceImportAuditINVOs(){
		MGSInvoiceImportAuditINVO[] vos = (MGSInvoiceImportAuditINVO[])models.toArray(new MGSInvoiceImportAuditINVO[models.size()]);
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
		this.invLseRtAmt = this.invLseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crSmryAmt = this.crSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCreSeq = this.chgCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustEqNo = this.invCustEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqStsEvntDt = this.audUmchEqStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxSmryAmt = this.taxSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgTpNm = this.invChgTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOffhDt = this.invEqOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgStsCd = this.lseChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOnhLocNm = this.invEqOnhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqAsetStsCd = this.audUmchEqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilEndDt = this.invBilEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqNo = this.invEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAmt = this.lseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRtAmt = this.lseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAudStsCd = this.lseChgAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxAmt = this.invTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfyRsltDesc = this.vrfyRsltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseUseDys = this.invLseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAudRsltRsnCd = this.lseChgAudRsltRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOffhLocNm = this.invEqOffhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilStDt = this.invBilStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCrAmt = this.invCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqStsEvntYdCd = this.audUmchEqStsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfyScsFlg = this.vrfyScsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOnhDt = this.invEqOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseUseDys = this.lseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgStsCd = this.payLseChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseChgAmt = this.invLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
