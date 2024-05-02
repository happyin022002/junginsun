/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSChargeCreationMGTVO.java
*@FileTitle : CHSChargeCreationMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.23 조재성 
* 1.0 Creation
* --------------------------------------------------------
* Change History
* 2015.04.10 Modified by Chang Young Kim
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSChargeCreationMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSChargeCreationMGTVO> models = new ArrayList<CHSChargeCreationMGTVO>();
	
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crSmryAmt = null;
	/* Column Info */
	private String chgCreSeq = null;
	/* Column Info */
	private String payLseChgAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String debitAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String taxSmryAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String lseChgStsDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String lseChgSmryAmt = null;
	/* Column Info */
	private String lseChgStsCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtSeqs = null;
	/* Column Info */
	private String invSmryAmt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String costYrmonSeq = null;
	/* Column Info */
	private String invCnt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String AgmtVerNo  = null;
	/* Column Info */
	private String orgInvNo = null;
	/* Column Info */
	private String chssCopInvTpCd = null;
	/* Column Info */
	private String lstVerFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSChargeCreationMGTVO() {}

	public CHSChargeCreationMGTVO(String ibflag, String pagerows, String delChk, String eqKndCd, String costYrmon, String agmtOfcCtyCd, String agmtSeq, String agmtNo, String agmtEffDt, String agmtExpDt, String agmtLstmCd, String vndrSeq, String vndrLglEngNm, String lseChgStsCd, String chgCreSeq, String creUsrId, String updUsrId, String agmtSeqs, String lseChgStsDesc, String lseChgSmryAmt, String invSmryAmt, String payLseChgAmt, String debitAmt, String crSmryAmt, String taxSmryAmt, String creOfcCd, String creDt, String chssPoolCd, String agmtRefNo, String costYrmonSeq, String invCnt, String invNo, String AgmtVerNo, String orgInvNo, String chssCopInvTpCd, String lstVerFlg) {
		this.agmtEffDt = agmtEffDt;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crSmryAmt = crSmryAmt;
		this.chgCreSeq = chgCreSeq;
		this.payLseChgAmt = payLseChgAmt;
		this.pagerows = pagerows;
		this.debitAmt = debitAmt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.taxSmryAmt = taxSmryAmt;
		this.creOfcCd = creOfcCd;
		this.agmtExpDt = agmtExpDt;
		this.lseChgStsDesc = lseChgStsDesc;
		this.updUsrId = updUsrId;
		this.agmtSeq = agmtSeq;
		this.lseChgSmryAmt = lseChgSmryAmt;
		this.lseChgStsCd = lseChgStsCd;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.delChk = delChk;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtSeqs = agmtSeqs;
		this.invSmryAmt = invSmryAmt;
		this.chssPoolCd = chssPoolCd;
		this.agmtRefNo = agmtRefNo;
		this.costYrmonSeq = costYrmonSeq;
		this.invCnt = invCnt;
		this.invNo = invNo;
		this.AgmtVerNo  = AgmtVerNo;
		this.orgInvNo = orgInvNo;
		this.chssCopInvTpCd = chssCopInvTpCd;
		this.lstVerFlg = lstVerFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cr_smry_amt", getCrSmryAmt());
		this.hashColumns.put("chg_cre_seq", getChgCreSeq());
		this.hashColumns.put("pay_lse_chg_amt", getPayLseChgAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("debit_amt", getDebitAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("tax_smry_amt", getTaxSmryAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("lse_chg_sts_desc", getLseChgStsDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("lse_chg_smry_amt", getLseChgSmryAmt());
		this.hashColumns.put("lse_chg_sts_cd", getLseChgStsCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_seqs", getAgmtSeqs());
		this.hashColumns.put("inv_smry_amt", getInvSmryAmt());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("cost_yrmon_seq", getCostYrmonSeq());
		this.hashColumns.put("inv_cnt", getInvCnt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("org_inv_no", getOrgInvNo());
		this.hashColumns.put("chss_cop_inv_tp_cd", getChssCopInvTpCd());
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cr_smry_amt", "crSmryAmt");
		this.hashFields.put("chg_cre_seq", "chgCreSeq");
		this.hashFields.put("pay_lse_chg_amt", "payLseChgAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("debit_amt", "debitAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("tax_smry_amt", "taxSmryAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("lse_chg_sts_desc", "lseChgStsDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("lse_chg_smry_amt", "lseChgSmryAmt");
		this.hashFields.put("lse_chg_sts_cd", "lseChgStsCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_seqs", "agmtSeqs");
		this.hashFields.put("inv_smry_amt", "invSmryAmt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("cost_yrmon_seq", "costYrmonSeq");
		this.hashFields.put("inv_cnt", "invCnt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("agmt_ver_no", "AgmtVerNo");
		this.hashFields.put("org_inv_no", "orgInvNo");
		this.hashFields.put("chss_cop_inv_tp_cd", "chssCopInvTpCd");
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtEffDt
	 */
	public String getAgmtEffDt() {
		return this.agmtEffDt;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return payLseChgAmt
	 */
	public String getPayLseChgAmt() {
		return this.payLseChgAmt;
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
	 * @return debitAmt
	 */
	public String getDebitAmt() {
		return this.debitAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtExpDt
	 */
	public String getAgmtExpDt() {
		return this.agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @return lseChgStsDesc
	 */
	public String getLseChgStsDesc() {
		return this.lseChgStsDesc;
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
	 * @return lseChgSmryAmt
	 */
	public String getLseChgSmryAmt() {
		return this.lseChgSmryAmt;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeqs
	 */
	public String getAgmtSeqs() {
		return this.agmtSeqs;
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
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
	 * @return costYrmonSeq
	 */
	public String getCostYrmonSeq() {
		return this.costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @return invCnt
	 */
	public String getInvCnt() {
		return this.invCnt;
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
	 * @return lstVerFlg
	 */
	public String getLstVerFlg() {
		return this.lstVerFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtEffDt
	 */
	public void setAgmtEffDt(String agmtEffDt) {
		this.agmtEffDt = agmtEffDt;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param payLseChgAmt
	 */
	public void setPayLseChgAmt(String payLseChgAmt) {
		this.payLseChgAmt = payLseChgAmt;
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
	 * @param debitAmt
	 */
	public void setDebitAmt(String debitAmt) {
		this.debitAmt = debitAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtExpDt
	 */
	public void setAgmtExpDt(String agmtExpDt) {
		this.agmtExpDt = agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @param lseChgStsDesc
	 */
	public void setLseChgStsDesc(String lseChgStsDesc) {
		this.lseChgStsDesc = lseChgStsDesc;
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
	 * @param lseChgSmryAmt
	 */
	public void setLseChgSmryAmt(String lseChgSmryAmt) {
		this.lseChgSmryAmt = lseChgSmryAmt;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeqs
	 */
	public void setAgmtSeqs(String agmtSeqs) {
		this.agmtSeqs = agmtSeqs;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
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
	 * @param costYrmonSeq
	 */
	public void setCostYrmonSeq(String costYrmonSeq) {
		this.costYrmonSeq = costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @param invCnt
	 */
	public void setInvCnt(String invCnt) {
		this.invCnt = invCnt;
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
	* @param AgmtVerNo
	*/
	public void setAgmtVerNo(String AgmtVerNo) {
		this.AgmtVerNo = AgmtVerNo;
	}
 
	/**
	 * Column Info
	 * @return AgmtVerNo
	 */
	 public String getAgmtVerNo() {
		 return this.AgmtVerNo;
	 }
	 
	 /**
	  * Column Info
	  * @return orgInvNo
	  */
	 public String getOrgInvNo() {
	 	return this.orgInvNo;
	 }
	 
	 /**
	  * Column Info
	  * @return orgInvNo
	  */
	 public void setOrgInvNo(String orgInvNo) {
	 	this.orgInvNo = orgInvNo;
	 }
	 
	 /**
	 * Column Info
	 * @return chssCopInvTpCd
	 */
	public String getChssCopInvTpCd() {
		return this.chssCopInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return chssCopInvTpCd
	 */
	public void setChssCopInvTpCd(String chssCopInvTpCd) {
		this.chssCopInvTpCd = chssCopInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return lstVerFlg
	 */
	public void setLstVerFlg(String lstVerFlg) {
		this.lstVerFlg = lstVerFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtEffDt(JSPUtil.getParameter(request, "agmt_eff_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCrSmryAmt(JSPUtil.getParameter(request, "cr_smry_amt", ""));
		setChgCreSeq(JSPUtil.getParameter(request, "chg_cre_seq", ""));
		setPayLseChgAmt(JSPUtil.getParameter(request, "pay_lse_chg_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDebitAmt(JSPUtil.getParameter(request, "debit_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setTaxSmryAmt(JSPUtil.getParameter(request, "tax_smry_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, "agmt_exp_dt", ""));
		setLseChgStsDesc(JSPUtil.getParameter(request, "lse_chg_sts_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setLseChgSmryAmt(JSPUtil.getParameter(request, "lse_chg_smry_amt", ""));
		setLseChgStsCd(JSPUtil.getParameter(request, "lse_chg_sts_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setAgmtSeqs(JSPUtil.getParameter(request, "agmt_seqs", ""));
		setInvSmryAmt(JSPUtil.getParameter(request, "inv_smry_amt", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setCostYrmonSeq(JSPUtil.getParameter(request, "cost_yrmon_seq", ""));
		setInvCnt(JSPUtil.getParameter(request, "inv_cnt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setOrgInvNo(JSPUtil.getParameter(request, "org_inv_no", ""));
		setChssCopInvTpCd(JSPUtil.getParameter(request, "chss_cop_inv_tp_cd", ""));
		setLstVerFlg(JSPUtil.getParameter(request, "lst_ver_flg", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSChargeCreationMGTVO[]
	 */
	public CHSChargeCreationMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSChargeCreationMGTVO[]
	 */
	public CHSChargeCreationMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSChargeCreationMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crSmryAmt = (JSPUtil.getParameter(request, prefix	+ "cr_smry_amt", length));
			String[] chgCreSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cre_seq", length));
			String[] payLseChgAmt = (JSPUtil.getParameter(request, prefix	+ "pay_lse_chg_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] debitAmt = (JSPUtil.getParameter(request, prefix	+ "debit_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] taxSmryAmt = (JSPUtil.getParameter(request, prefix	+ "tax_smry_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] lseChgStsDesc = (JSPUtil.getParameter(request, prefix	+ "lse_chg_sts_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] lseChgSmryAmt = (JSPUtil.getParameter(request, prefix	+ "lse_chg_smry_amt", length));
			String[] lseChgStsCd = (JSPUtil.getParameter(request, prefix	+ "lse_chg_sts_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] agmtSeqs = (JSPUtil.getParameter(request, prefix	+ "agmt_seqs", length));
			String[] invSmryAmt = (JSPUtil.getParameter(request, prefix	+ "inv_smry_amt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] costYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon_seq", length));
			String[] invCnt = (JSPUtil.getParameter(request, prefix	+ "inv_cnt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] AgmtVerNo =	(JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] orgInvNo = (JSPUtil.getParameter(request, prefix + "org_inv_no", length));
			String[] chssCopInvTpCd = (JSPUtil.getParameter(request, prefix + "chss_cop_inv_tp_cd", length));
			String[] lstVerFlg = (JSPUtil.getParameter(request, prefix + "lst_ver_flg", length));

			
			for (int i = 0; i < length; i++) {
				model = new CHSChargeCreationMGTVO();
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crSmryAmt[i] != null)
					model.setCrSmryAmt(crSmryAmt[i]);
				if (chgCreSeq[i] != null)
					model.setChgCreSeq(chgCreSeq[i]);
				if (payLseChgAmt[i] != null)
					model.setPayLseChgAmt(payLseChgAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (debitAmt[i] != null)
					model.setDebitAmt(debitAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (taxSmryAmt[i] != null)
					model.setTaxSmryAmt(taxSmryAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (lseChgStsDesc[i] != null)
					model.setLseChgStsDesc(lseChgStsDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (lseChgSmryAmt[i] != null)
					model.setLseChgSmryAmt(lseChgSmryAmt[i]);
				if (lseChgStsCd[i] != null)
					model.setLseChgStsCd(lseChgStsCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (agmtSeqs[i] != null)
					model.setAgmtSeqs(agmtSeqs[i]);
				if (invSmryAmt[i] != null)
					model.setInvSmryAmt(invSmryAmt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (costYrmonSeq[i] != null)
					model.setCostYrmonSeq(costYrmonSeq[i]);
				if (invCnt[i] != null)
					model.setInvCnt(invCnt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if ( AgmtVerNo[i] != null)
					model.setAgmtVerNo( AgmtVerNo[i]);
				if (orgInvNo[i] != null)
					model.setOrgInvNo(orgInvNo[i]);
				if (chssCopInvTpCd[i] != null)
					model.setChssCopInvTpCd(chssCopInvTpCd[i]);
				if (lstVerFlg[i] != null)
					model.setLstVerFlg(lstVerFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSChargeCreationMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSChargeCreationMGTVO[]
	 */
	public CHSChargeCreationMGTVO[] getCHSChargeCreationMGTVOs(){
		CHSChargeCreationMGTVO[] vos = (CHSChargeCreationMGTVO[])models.toArray(new CHSChargeCreationMGTVO[models.size()]);
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
		this.agmtEffDt = this.agmtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crSmryAmt = this.crSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCreSeq = this.chgCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLseChgAmt = this.payLseChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.debitAmt = this.debitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxSmryAmt = this.taxSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgStsDesc = this.lseChgStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgSmryAmt = this.lseChgSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseChgStsCd = this.lseChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeqs = this.agmtSeqs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSmryAmt = this.invSmryAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonSeq = this.costYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCnt = this.invCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.AgmtVerNo = this.AgmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvNo = this.orgInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCopInvTpCd = this.chssCopInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstVerFlg = this.lstVerFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
