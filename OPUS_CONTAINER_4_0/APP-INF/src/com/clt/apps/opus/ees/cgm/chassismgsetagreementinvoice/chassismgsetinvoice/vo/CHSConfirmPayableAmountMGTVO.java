/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CHSConfirmPayableAmountMGTVO.java
*@FileTitle : CHSConfirmPayableAmountMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.04 조재성 
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

public class CHSConfirmPayableAmountMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSConfirmPayableAmountMGTVO> models = new ArrayList<CHSConfirmPayableAmountMGTVO>();
	
	/* Column Info */
	private String invLseRtAmt = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String invCustEqNo = null;
	/* Column Info */
	private String chgCreSeq = null;
	/* Column Info */
	private String audUmchEqStsEvntDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String stsEvntDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String invUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String invEqOnhLocNm = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String audUmchEqAsetStsCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String invBilEndDt = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String invEqNo = null;
	/* Column Info */
	private String lseChgAmt = null;
	/* Column Info */
	private String eqOffhDt = null;
	/* Column Info */
	private String lseRtAmt = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String eqOffhLocCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String lseChgAudStsCd = null;
	/* Column Info */
	private String invTaxAmt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String eqBilStDt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String invLseUseDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String invEqOffhLocNm = null;
	/* Column Info */
	private String invBilStDt = null;
	/* Column Info */
	private String eqOnhLocCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String invCrAmt = null;
	/* Column Info */
	private String audUmchEqStsEvntYdCd = null;
	/* Column Info */
	private String payChgAudRmk = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String chgSmryAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String eqOnhDt = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String lseUseDys = null;
	/* Column Info */
	private String invLseChgAmt = null;
	/* Column Info */
	private String payLseChgStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSConfirmPayableAmountMGTVO() {}

	public CHSConfirmPayableAmountMGTVO(String ibflag, String pagerows, String invCustEqNo, String eqNo, String invNo, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String agmtNo, String agmtLstmCd, String eqTpszCd, String invRefNo, String lseChgAudStsCd, String chgCd, String chgSeq, String eqOnhLocCd, String eqOnhDt, String eqBilStDt, String eqOffhLocCd, String eqOffhDt, String lseUseDys, String lseRtAmt, String lseChgAmt, String invEqNo, String invBilStDt, String invBilEndDt, String invEqOnhLocNm, String invEqOffhLocNm, String invLseUseDys, String invLseRtAmt, String invTaxAmt, String invCrAmt, String invLseChgAmt, String audUmchEqStsEvntYdCd, String audUmchEqStsEvntDt, String audUmchEqAsetStsCd, String payChgAudRmk, String costYrmon, String eqKndCd, String chgCreSeq, String vndrSeq, String vndrLglEngNm, String eqAsetStsCd, String stsEvntDt, String payLseChgStsCd, String costCd, String acctCd, String creUsrId, String updUsrId, String payInvSeq, String currCd, String costOfcCd, String issOfcCd, String chgSmryAmt, String invSmryAmt, String invDt, String invUsrId, String intgCdValDpDesc) {
		this.invLseRtAmt = invLseRtAmt;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.issOfcCd = issOfcCd;
		this.invCustEqNo = invCustEqNo;
		this.chgCreSeq = chgCreSeq;
		this.audUmchEqStsEvntDt = audUmchEqStsEvntDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.costYrmon = costYrmon;
		this.eqAsetStsCd = eqAsetStsCd;
		this.costCd = costCd;
		this.stsEvntDt = stsEvntDt;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
		this.invUsrId = invUsrId;
		this.agmtSeq = agmtSeq;
		this.invEqOnhLocNm = invEqOnhLocNm;
		this.agmtNo = agmtNo;
		this.audUmchEqAsetStsCd = audUmchEqAsetStsCd;
		this.agmtLstmCd = agmtLstmCd;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.invBilEndDt = invBilEndDt;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.invEqNo = invEqNo;
		this.lseChgAmt = lseChgAmt;
		this.eqOffhDt = eqOffhDt;
		this.lseRtAmt = lseRtAmt;
		this.agmtVerNo = agmtVerNo;
		this.eqOffhLocCd = eqOffhLocCd;
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.lseChgAudStsCd = lseChgAudStsCd;
		this.invTaxAmt = invTaxAmt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.eqBilStDt = eqBilStDt;
		this.chgSeq = chgSeq;
		this.invLseUseDys = invLseUseDys;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.invEqOffhLocNm = invEqOffhLocNm;
		this.invBilStDt = invBilStDt;
		this.eqOnhLocCd = eqOnhLocCd;
		this.acctCd = acctCd;
		this.invCrAmt = invCrAmt;
		this.audUmchEqStsEvntYdCd = audUmchEqStsEvntYdCd;
		this.payChgAudRmk = payChgAudRmk;
		this.costOfcCd = costOfcCd;
		this.invRefNo = invRefNo;
		this.eqKndCd = eqKndCd;
		this.chgSmryAmt = chgSmryAmt;
		this.invNo = invNo;
		this.eqOnhDt = eqOnhDt;
		this.invSmryAmt = invSmryAmt;
		this.lseUseDys = lseUseDys;
		this.invLseChgAmt = invLseChgAmt;
		this.payLseChgStsCd = payLseChgStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_lse_rt_amt", getInvLseRtAmt());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("inv_cust_eq_no", getInvCustEqNo());
		this.hashColumns.put("chg_cre_seq", getChgCreSeq());
		this.hashColumns.put("aud_umch_eq_sts_evnt_dt", getAudUmchEqStsEvntDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("sts_evnt_dt", getStsEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("inv_usr_id", getInvUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("inv_eq_onh_loc_nm", getInvEqOnhLocNm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("aud_umch_eq_aset_sts_cd", getAudUmchEqAsetStsCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inv_bil_end_dt", getInvBilEndDt());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("inv_eq_no", getInvEqNo());
		this.hashColumns.put("lse_chg_amt", getLseChgAmt());
		this.hashColumns.put("eq_offh_dt", getEqOffhDt());
		this.hashColumns.put("lse_rt_amt", getLseRtAmt());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("eq_offh_loc_cd", getEqOffhLocCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("lse_chg_aud_sts_cd", getLseChgAudStsCd());
		this.hashColumns.put("inv_tax_amt", getInvTaxAmt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("eq_bil_st_dt", getEqBilStDt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("inv_lse_use_dys", getInvLseUseDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inv_eq_offh_loc_nm", getInvEqOffhLocNm());
		this.hashColumns.put("inv_bil_st_dt", getInvBilStDt());
		this.hashColumns.put("eq_onh_loc_cd", getEqOnhLocCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("inv_cr_amt", getInvCrAmt());
		this.hashColumns.put("aud_umch_eq_sts_evnt_yd_cd", getAudUmchEqStsEvntYdCd());
		this.hashColumns.put("pay_chg_aud_rmk", getPayChgAudRmk());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("chg_smry_amt", getChgSmryAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("eq_onh_dt", getEqOnhDt());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("lse_use_dys", getLseUseDys());
		this.hashColumns.put("inv_lse_chg_amt", getInvLseChgAmt());
		this.hashColumns.put("pay_lse_chg_sts_cd", getPayLseChgStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_lse_rt_amt", "invLseRtAmt");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("inv_cust_eq_no", "invCustEqNo");
		this.hashFields.put("chg_cre_seq", "chgCreSeq");
		this.hashFields.put("aud_umch_eq_sts_evnt_dt", "audUmchEqStsEvntDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("sts_evnt_dt", "stsEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("inv_usr_id", "invUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("inv_eq_onh_loc_nm", "invEqOnhLocNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("aud_umch_eq_aset_sts_cd", "audUmchEqAsetStsCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_bil_end_dt", "invBilEndDt");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("inv_eq_no", "invEqNo");
		this.hashFields.put("lse_chg_amt", "lseChgAmt");
		this.hashFields.put("eq_offh_dt", "eqOffhDt");
		this.hashFields.put("lse_rt_amt", "lseRtAmt");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("eq_offh_loc_cd", "eqOffhLocCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("lse_chg_aud_sts_cd", "lseChgAudStsCd");
		this.hashFields.put("inv_tax_amt", "invTaxAmt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("eq_bil_st_dt", "eqBilStDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_lse_use_dys", "invLseUseDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inv_eq_offh_loc_nm", "invEqOffhLocNm");
		this.hashFields.put("inv_bil_st_dt", "invBilStDt");
		this.hashFields.put("eq_onh_loc_cd", "eqOnhLocCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_cr_amt", "invCrAmt");
		this.hashFields.put("aud_umch_eq_sts_evnt_yd_cd", "audUmchEqStsEvntYdCd");
		this.hashFields.put("pay_chg_aud_rmk", "payChgAudRmk");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("chg_smry_amt", "chgSmryAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("eq_onh_dt", "eqOnhDt");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("lse_use_dys", "lseUseDys");
		this.hashFields.put("inv_lse_chg_amt", "invLseChgAmt");
		this.hashFields.put("pay_lse_chg_sts_cd", "payLseChgStsCd");
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
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
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
	 * @return chgCreSeq
	 */
	public String getChgCreSeq() {
		return this.chgCreSeq;
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
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
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
	 * @return stsEvntDt
	 */
	public String getStsEvntDt() {
		return this.stsEvntDt;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return invUsrId
	 */
	public String getInvUsrId() {
		return this.invUsrId;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return eqOffhDt
	 */
	public String getEqOffhDt() {
		return this.eqOffhDt;
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
	 * @return eqOffhLocCd
	 */
	public String getEqOffhLocCd() {
		return this.eqOffhLocCd;
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
	 * @return payInvSeq
	 */
	public String getPayInvSeq() {
		return this.payInvSeq;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return invBilStDt
	 */
	public String getInvBilStDt() {
		return this.invBilStDt;
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
	 * @return payChgAudRmk
	 */
	public String getPayChgAudRmk() {
		return this.payChgAudRmk;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return chgSmryAmt
	 */
	public String getChgSmryAmt() {
		return this.chgSmryAmt;
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
	 * @return eqOnhDt
	 */
	public String getEqOnhDt() {
		return this.eqOnhDt;
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
	 * @return lseUseDys
	 */
	public String getLseUseDys() {
		return this.lseUseDys;
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
	 * @param invLseRtAmt
	 */
	public void setInvLseRtAmt(String invLseRtAmt) {
		this.invLseRtAmt = invLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
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
	 * @param chgCreSeq
	 */
	public void setChgCreSeq(String chgCreSeq) {
		this.chgCreSeq = chgCreSeq;
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
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
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
	 * @param stsEvntDt
	 */
	public void setStsEvntDt(String stsEvntDt) {
		this.stsEvntDt = stsEvntDt;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param invUsrId
	 */
	public void setInvUsrId(String invUsrId) {
		this.invUsrId = invUsrId;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param eqOffhDt
	 */
	public void setEqOffhDt(String eqOffhDt) {
		this.eqOffhDt = eqOffhDt;
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
	 * @param eqOffhLocCd
	 */
	public void setEqOffhLocCd(String eqOffhLocCd) {
		this.eqOffhLocCd = eqOffhLocCd;
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
	 * @param payInvSeq
	 */
	public void setPayInvSeq(String payInvSeq) {
		this.payInvSeq = payInvSeq;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param invBilStDt
	 */
	public void setInvBilStDt(String invBilStDt) {
		this.invBilStDt = invBilStDt;
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
	 * @param payChgAudRmk
	 */
	public void setPayChgAudRmk(String payChgAudRmk) {
		this.payChgAudRmk = payChgAudRmk;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param chgSmryAmt
	 */
	public void setChgSmryAmt(String chgSmryAmt) {
		this.chgSmryAmt = chgSmryAmt;
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
	 * @param eqOnhDt
	 */
	public void setEqOnhDt(String eqOnhDt) {
		this.eqOnhDt = eqOnhDt;
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
	 * @param lseUseDys
	 */
	public void setLseUseDys(String lseUseDys) {
		this.lseUseDys = lseUseDys;
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
		setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setInvCustEqNo(JSPUtil.getParameter(request, prefix + "inv_cust_eq_no", ""));
		setChgCreSeq(JSPUtil.getParameter(request, prefix + "chg_cre_seq", ""));
		setAudUmchEqStsEvntDt(JSPUtil.getParameter(request, prefix + "aud_umch_eq_sts_evnt_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, prefix + "eq_aset_sts_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setStsEvntDt(JSPUtil.getParameter(request, prefix + "sts_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setInvUsrId(JSPUtil.getParameter(request, prefix + "inv_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setInvEqOnhLocNm(JSPUtil.getParameter(request, prefix + "inv_eq_onh_loc_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setAudUmchEqAsetStsCd(JSPUtil.getParameter(request, prefix + "aud_umch_eq_aset_sts_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInvBilEndDt(JSPUtil.getParameter(request, prefix + "inv_bil_end_dt", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setInvEqNo(JSPUtil.getParameter(request, prefix + "inv_eq_no", ""));
		setLseChgAmt(JSPUtil.getParameter(request, prefix + "lse_chg_amt", ""));
		setEqOffhDt(JSPUtil.getParameter(request, prefix + "eq_offh_dt", ""));
		setLseRtAmt(JSPUtil.getParameter(request, prefix + "lse_rt_amt", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setEqOffhLocCd(JSPUtil.getParameter(request, prefix + "eq_offh_loc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setLseChgAudStsCd(JSPUtil.getParameter(request, prefix + "lse_chg_aud_sts_cd", ""));
		setInvTaxAmt(JSPUtil.getParameter(request, prefix + "inv_tax_amt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setEqBilStDt(JSPUtil.getParameter(request, prefix + "eq_bil_st_dt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setInvLseUseDys(JSPUtil.getParameter(request, prefix + "inv_lse_use_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInvEqOffhLocNm(JSPUtil.getParameter(request, prefix + "inv_eq_offh_loc_nm", ""));
		setInvBilStDt(JSPUtil.getParameter(request, prefix + "inv_bil_st_dt", ""));
		setEqOnhLocCd(JSPUtil.getParameter(request, prefix + "eq_onh_loc_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInvCrAmt(JSPUtil.getParameter(request, prefix + "inv_cr_amt", ""));
		setAudUmchEqStsEvntYdCd(JSPUtil.getParameter(request, prefix + "aud_umch_eq_sts_evnt_yd_cd", ""));
		setPayChgAudRmk(JSPUtil.getParameter(request, prefix + "pay_chg_aud_rmk", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setInvRefNo(JSPUtil.getParameter(request, prefix + "inv_ref_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setChgSmryAmt(JSPUtil.getParameter(request, prefix + "chg_smry_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setEqOnhDt(JSPUtil.getParameter(request, prefix + "eq_onh_dt", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, prefix + "inv_smry_amt", ""));
		setLseUseDys(JSPUtil.getParameter(request, prefix + "lse_use_dys", ""));
		setInvLseChgAmt(JSPUtil.getParameter(request, prefix + "inv_lse_chg_amt", ""));
		setPayLseChgStsCd(JSPUtil.getParameter(request, prefix + "pay_lse_chg_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSConfirmPayableAmountMGTVO[]
	 */
	public CHSConfirmPayableAmountMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSConfirmPayableAmountMGTVO[]
	 */
	public CHSConfirmPayableAmountMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSConfirmPayableAmountMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invLseRtAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_rt_amt", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] invCustEqNo = (JSPUtil.getParameter(request, prefix	+ "inv_cust_eq_no", length));
			String[] chgCreSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cre_seq", length));
			String[] audUmchEqStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_sts_evnt_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] stsEvntDt = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] invUsrId = (JSPUtil.getParameter(request, prefix	+ "inv_usr_id", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] invEqOnhLocNm = (JSPUtil.getParameter(request, prefix	+ "inv_eq_onh_loc_nm", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] audUmchEqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_aset_sts_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] invBilEndDt = (JSPUtil.getParameter(request, prefix	+ "inv_bil_end_dt", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] invEqNo = (JSPUtil.getParameter(request, prefix	+ "inv_eq_no", length));
			String[] lseChgAmt = (JSPUtil.getParameter(request, prefix	+ "lse_chg_amt", length));
			String[] eqOffhDt = (JSPUtil.getParameter(request, prefix	+ "eq_offh_dt", length));
			String[] lseRtAmt = (JSPUtil.getParameter(request, prefix	+ "lse_rt_amt", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] eqOffhLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_offh_loc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] lseChgAudStsCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_aud_sts_cd", length));
			String[] invTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_amt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] eqBilStDt = (JSPUtil.getParameter(request, prefix	+ "eq_bil_st_dt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] invLseUseDys = (JSPUtil.getParameter(request, prefix	+ "inv_lse_use_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] invEqOffhLocNm = (JSPUtil.getParameter(request, prefix	+ "inv_eq_offh_loc_nm", length));
			String[] invBilStDt = (JSPUtil.getParameter(request, prefix	+ "inv_bil_st_dt", length));
			String[] eqOnhLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_onh_loc_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] invCrAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cr_amt", length));
			String[] audUmchEqStsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "aud_umch_eq_sts_evnt_yd_cd", length));
			String[] payChgAudRmk = (JSPUtil.getParameter(request, prefix	+ "pay_chg_aud_rmk", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] chgSmryAmt = (JSPUtil.getParameter(request, prefix	+ "chg_smry_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] eqOnhDt = (JSPUtil.getParameter(request, prefix	+ "eq_onh_dt", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] lseUseDys = (JSPUtil.getParameter(request, prefix	+ "lse_use_dys", length));
			String[] invLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_lse_chg_amt", length));
			String[] payLseChgStsCd = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSConfirmPayableAmountMGTVO();
				if (invLseRtAmt[i] != null)
					model.setInvLseRtAmt(invLseRtAmt[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (invCustEqNo[i] != null)
					model.setInvCustEqNo(invCustEqNo[i]);
				if (chgCreSeq[i] != null)
					model.setChgCreSeq(chgCreSeq[i]);
				if (audUmchEqStsEvntDt[i] != null)
					model.setAudUmchEqStsEvntDt(audUmchEqStsEvntDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (stsEvntDt[i] != null)
					model.setStsEvntDt(stsEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (invUsrId[i] != null)
					model.setInvUsrId(invUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (invEqOnhLocNm[i] != null)
					model.setInvEqOnhLocNm(invEqOnhLocNm[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (audUmchEqAsetStsCd[i] != null)
					model.setAudUmchEqAsetStsCd(audUmchEqAsetStsCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (invBilEndDt[i] != null)
					model.setInvBilEndDt(invBilEndDt[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (invEqNo[i] != null)
					model.setInvEqNo(invEqNo[i]);
				if (lseChgAmt[i] != null)
					model.setLseChgAmt(lseChgAmt[i]);
				if (eqOffhDt[i] != null)
					model.setEqOffhDt(eqOffhDt[i]);
				if (lseRtAmt[i] != null)
					model.setLseRtAmt(lseRtAmt[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (eqOffhLocCd[i] != null)
					model.setEqOffhLocCd(eqOffhLocCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (lseChgAudStsCd[i] != null)
					model.setLseChgAudStsCd(lseChgAudStsCd[i]);
				if (invTaxAmt[i] != null)
					model.setInvTaxAmt(invTaxAmt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (eqBilStDt[i] != null)
					model.setEqBilStDt(eqBilStDt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (invLseUseDys[i] != null)
					model.setInvLseUseDys(invLseUseDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (invEqOffhLocNm[i] != null)
					model.setInvEqOffhLocNm(invEqOffhLocNm[i]);
				if (invBilStDt[i] != null)
					model.setInvBilStDt(invBilStDt[i]);
				if (eqOnhLocCd[i] != null)
					model.setEqOnhLocCd(eqOnhLocCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (invCrAmt[i] != null)
					model.setInvCrAmt(invCrAmt[i]);
				if (audUmchEqStsEvntYdCd[i] != null)
					model.setAudUmchEqStsEvntYdCd(audUmchEqStsEvntYdCd[i]);
				if (payChgAudRmk[i] != null)
					model.setPayChgAudRmk(payChgAudRmk[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (chgSmryAmt[i] != null)
					model.setChgSmryAmt(chgSmryAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (eqOnhDt[i] != null)
					model.setEqOnhDt(eqOnhDt[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (lseUseDys[i] != null)
					model.setLseUseDys(lseUseDys[i]);
				if (invLseChgAmt[i] != null)
					model.setInvLseChgAmt(invLseChgAmt[i]);
				if (payLseChgStsCd[i] != null)
					model.setPayLseChgStsCd(payLseChgStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSConfirmPayableAmountMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSConfirmPayableAmountMGTVO[]
	 */
	public CHSConfirmPayableAmountMGTVO[] getCHSConfirmPayableAmountMGTVOs(){
		CHSConfirmPayableAmountMGTVO[] vos = (CHSConfirmPayableAmountMGTVO[])models.toArray(new CHSConfirmPayableAmountMGTVO[models.size()]);
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
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustEqNo = this.invCustEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCreSeq = this.chgCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqStsEvntDt = this.audUmchEqStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDt = this.stsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsrId = this.invUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOnhLocNm = this.invEqOnhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqAsetStsCd = this.audUmchEqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilEndDt = this.invBilEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqNo = this.invEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAmt = this.lseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhDt = this.eqOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRtAmt = this.lseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOffhLocCd = this.eqOffhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgAudStsCd = this.lseChgAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxAmt = this.invTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqBilStDt = this.eqBilStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseUseDys = this.invLseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEqOffhLocNm = this.invEqOffhLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilStDt = this.invBilStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOnhLocCd = this.eqOnhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCrAmt = this.invCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audUmchEqStsEvntYdCd = this.audUmchEqStsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payChgAudRmk = this.payChgAudRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSmryAmt = this.chgSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOnhDt = this.eqOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseUseDys = this.lseUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLseChgAmt = this.invLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgStsCd = this.payLseChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
