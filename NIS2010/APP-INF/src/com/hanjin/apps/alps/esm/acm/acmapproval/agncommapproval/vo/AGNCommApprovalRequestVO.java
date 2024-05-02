/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommApprovalRequestVO.java
*@FileTitle : AGNCommApprovalRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.06
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.01.06 이윤정 1.0 Creation
* 2014.12.09 김상현 1.6 [CHM-201433178] Split 04-GW에서 ERP로 계약서 첨부 FLAG 송부
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
  
public class AGNCommApprovalRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGNCommApprovalRequestVO> models = new ArrayList<AGNCommApprovalRequestVO>();
	
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dtrbCnt = null;
	/* Column Info */
	private String fincRgnCd = null;
	/* Column Info */
	private String asaCurrCd = null;
	/* Column Info */
	private String whldTaxRt = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String sRevChg = null;
	/* Column Info */
	private String errBkgCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errBkgNo = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String audNo = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errVvd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String tjOfcCd = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String calcNo = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String payGrpLuCd = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String errVvdBkgNo = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String invTermDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String asaCnt = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String coaIntrCmpyCd = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String localDt = null;
	/* Column Info */
	private String approvedYN = null;	//10만불 이하 Approval 로직여부 vo 추가
	/* Column Info */
	private String agmtDocCfmCd = null;
	/* Column Info */
	private String gwAgmtDocCfmCd = null;
	/* Column Info */
	private String agmtFileCfmCd = null;
	/* Column Info */
	private String agmtEvidCfmFnlCd = null;
	/* Column Info */
	private String csrGenExpnAcctFlg = null;
	/* Column Info */
	private String csrAproTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGNCommApprovalRequestVO() {}

	public AGNCommApprovalRequestVO(String ibflag, String pagerows, String audNo, String asaNo, String invDt, String arOfcCd, String agnCd, String invTaxRt, String creUsrId, String updUsrId, String usrNm, String usrEml, String sRevChg, String asaCnt, String asaCurrCd, String localDt, String errBkgNo, String errBkgCreDt, String fincRgnCd, String coaIntrCmpyCd, String errVvdBkgNo, String errVvd, String vndrSeq, String apCtrCd, String arHdQtrOfcCd, String csrNo, String tjOfcCd, String dtrbCnt, String vndrNo, String invTermDt, String csrCurrCd, String csrAmt, String glDt, String currCd, String vndrTermNm, String invDesc, String payMzdLuCd, String payGrpLuCd, String apOfcCd, String calcNo, String whldTaxRt, String approvedYN, String agmtDocCfmCd, String gwAgmtDocCfmCd, String agmtFileCfmCd, String agmtEvidCfmFnlCd, String csrGenExpnAcctFlg, String csrAproTpCd) {
		this.glDt = glDt;
		this.currCd = currCd;
		this.dtrbCnt = dtrbCnt;
		this.fincRgnCd = fincRgnCd;
		this.asaCurrCd = asaCurrCd;
		this.whldTaxRt = whldTaxRt;
		this.csrCurrCd = csrCurrCd;
		this.sRevChg = sRevChg;
		this.errBkgCreDt = errBkgCreDt;
		this.pagerows = pagerows;
		this.errBkgNo = errBkgNo;
		this.agnCd = agnCd;
		this.audNo = audNo;
		this.invDesc = invDesc;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.errVvd = errVvd;
		this.usrNm = usrNm;
		this.tjOfcCd = tjOfcCd;
		this.usrEml = usrEml;
		this.invTaxRt = invTaxRt;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
		this.csrNo = csrNo;
		this.calcNo = calcNo;
		this.apOfcCd = apOfcCd;
		this.payGrpLuCd = payGrpLuCd;
		this.vndrTermNm = vndrTermNm;
		this.errVvdBkgNo = errVvdBkgNo;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.arOfcCd = arOfcCd;
		this.creUsrId = creUsrId;
		this.payMzdLuCd = payMzdLuCd;
		this.invTermDt = invTermDt;
		this.vndrSeq = vndrSeq;
		this.asaCnt = asaCnt;
		this.csrAmt = csrAmt;
		this.asaNo = asaNo;
		this.coaIntrCmpyCd = coaIntrCmpyCd;
		this.apCtrCd = apCtrCd;
		this.localDt = localDt;
		this.approvedYN = approvedYN;
		this.agmtDocCfmCd = agmtDocCfmCd;
		this.gwAgmtDocCfmCd = gwAgmtDocCfmCd;
		this.agmtFileCfmCd = agmtFileCfmCd;
		this.agmtEvidCfmFnlCd = agmtEvidCfmFnlCd;
		this.csrGenExpnAcctFlg = csrGenExpnAcctFlg;
		this.csrAproTpCd = csrAproTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dtrb_cnt", getDtrbCnt());
		this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
		this.hashColumns.put("asa_curr_cd", getAsaCurrCd());
		this.hashColumns.put("whld_tax_rt", getWhldTaxRt());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("s_rev_chg", getSRevChg());
		this.hashColumns.put("err_bkg_cre_dt", getErrBkgCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("err_bkg_no", getErrBkgNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_vvd", getErrVvd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("tj_ofc_cd", getTjOfcCd());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("calc_no", getCalcNo());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("err_vvd_bkg_no", getErrVvdBkgNo());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("inv_term_dt", getInvTermDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("asa_cnt", getAsaCnt());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("coa_intr_cmpy_cd", getCoaIntrCmpyCd());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("local_dt", getLocalDt());
		this.hashColumns.put("approved_yn", getApprovedYN());
		this.hashColumns.put("agmt_doc_cfm_cd", getAgmtDocCfmCd());
		this.hashColumns.put("gw_agmt_doc_cfm_cd", getGwAgmtDocCfmCd());
		this.hashColumns.put("agmt_file_cfm_cd", getAgmtFileCfmCd());
		this.hashColumns.put("agmt_evid_cfm_fnl_cd", getAgmtEvidCfmFnlCd());
		this.hashColumns.put("csr_gen_expn_acct_flg", getCsrGenExpnAcctFlg());
		this.hashColumns.put("csr_apro_tp_cd", getCsrAproTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dtrb_cnt", "dtrbCnt");
		this.hashFields.put("finc_rgn_cd", "fincRgnCd");
		this.hashFields.put("asa_curr_cd", "asaCurrCd");
		this.hashFields.put("whld_tax_rt", "whldTaxRt");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("s_rev_chg", "sRevChg");
		this.hashFields.put("err_bkg_cre_dt", "errBkgCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("err_bkg_no", "errBkgNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_vvd", "errVvd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("tj_ofc_cd", "tjOfcCd");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("calc_no", "calcNo");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("err_vvd_bkg_no", "errVvdBkgNo");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("asa_cnt", "asaCnt");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("coa_intr_cmpy_cd", "coaIntrCmpyCd");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("local_dt", "localDt");
		this.hashFields.put("approved_yn", "approvedYN");
		this.hashFields.put("agmt_doc_cfm_cd", "agmtDocCfmCd");
		this.hashFields.put("gw_agmt_doc_cfm_cd", "gwAgmtDocCfmCd");
		this.hashFields.put("agmt_file_cfm_cd", "agmtFileCfmCd");
		this.hashFields.put("agmt_evid_cfm_fnl_cd", "agmtEvidCfmFnlCd");
		this.hashFields.put("csr_gen_expn_acct_flg", "csrGenExpnAcctFlg");
		this.hashFields.put("csr_apro_tp_cd", "csrAproTpCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return approvedYN
	 */
	public String getApprovedYN() {
		return approvedYN;
	}

	/**
	 * Column Info
	 * @return approvedYN
	 */
	public void setApprovedYN(String approvedYN) {
		this.approvedYN = approvedYN;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbCnt
	 */
	public String getDtrbCnt() {
		return this.dtrbCnt;
	}
	
	/**
	 * Column Info
	 * @return fincRgnCd
	 */
	public String getFincRgnCd() {
		return this.fincRgnCd;
	}
	
	/**
	 * Column Info
	 * @return asaCurrCd
	 */
	public String getAsaCurrCd() {
		return this.asaCurrCd;
	}
	
	/**
	 * Column Info
	 * @return whldTaxRt
	 */
	public String getWhldTaxRt() {
		return this.whldTaxRt;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sRevChg
	 */
	public String getSRevChg() {
		return this.sRevChg;
	}
	
	/**
	 * Column Info
	 * @return errBkgCreDt
	 */
	public String getErrBkgCreDt() {
		return this.errBkgCreDt;
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
	 * @return errBkgNo
	 */
	public String getErrBkgNo() {
		return this.errBkgNo;
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
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return errVvd
	 */
	public String getErrVvd() {
		return this.errVvd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return tjOfcCd
	 */
	public String getTjOfcCd() {
		return this.tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return calcNo
	 */
	public String getCalcNo() {
		return this.calcNo;
	}
	
	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return payGrpLuCd
	 */
	public String getPayGrpLuCd() {
		return this.payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return errVvdBkgNo
	 */
	public String getErrVvdBkgNo() {
		return this.errVvdBkgNo;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return invTermDt
	 */
	public String getInvTermDt() {
		return this.invTermDt;
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
	 * @return asaCnt
	 */
	public String getAsaCnt() {
		return this.asaCnt;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
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
	 * @return coaIntrCmpyCd
	 */
	public String getCoaIntrCmpyCd() {
		return this.coaIntrCmpyCd;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}
	
	/**
	 * Column Info
	 * @return localDt
	 */
	public String getLocalDt() {
		return this.localDt;
	}

	/**
	 * Column Info
	 * @return agmtDocCfmCd
	 */
	public String getAgmtDocCfmCd() {
		return this.agmtDocCfmCd;
	}

	/**
	 * Column Info
	 * @return gwAgmtDocCfmCd
	 */
	public String getGwAgmtDocCfmCd() {
		return this.gwAgmtDocCfmCd;
	}

	/**
	 * Column Info
	 * @return agmtFileCfmCd
	 */
	public String getAgmtFileCfmCd() {
		return agmtFileCfmCd;
	}

	/**
	 * Column Info
	 * @return agmtEvidCfmFnlCd
	 */
	public String getAgmtEvidCfmFnlCd() {
		return agmtEvidCfmFnlCd;
	}

	/**
	 * Column Info
	 * @return csrGenExpnAcctFlg
	 */
	public String getCsrGenExpnAcctFlg() {
		return csrGenExpnAcctFlg;
	}

	/**
	 * Column Info
	 * @return csrAproTpCd
	 */
	public String getCsrAproTpCd() {
		return csrAproTpCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbCnt
	 */
	public void setDtrbCnt(String dtrbCnt) {
		this.dtrbCnt = dtrbCnt;
	}
	
	/**
	 * Column Info
	 * @param fincRgnCd
	 */
	public void setFincRgnCd(String fincRgnCd) {
		this.fincRgnCd = fincRgnCd;
	}
	
	/**
	 * Column Info
	 * @param asaCurrCd
	 */
	public void setAsaCurrCd(String asaCurrCd) {
		this.asaCurrCd = asaCurrCd;
	}
	
	/**
	 * Column Info
	 * @param whldTaxRt
	 */
	public void setWhldTaxRt(String whldTaxRt) {
		this.whldTaxRt = whldTaxRt;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sRevChg
	 */
	public void setSRevChg(String sRevChg) {
		this.sRevChg = sRevChg;
	}
	
	/**
	 * Column Info
	 * @param errBkgCreDt
	 */
	public void setErrBkgCreDt(String errBkgCreDt) {
		this.errBkgCreDt = errBkgCreDt;
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
	 * @param errBkgNo
	 */
	public void setErrBkgNo(String errBkgNo) {
		this.errBkgNo = errBkgNo;
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
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param errVvd
	 */
	public void setErrVvd(String errVvd) {
		this.errVvd = errVvd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param tjOfcCd
	 */
	public void setTjOfcCd(String tjOfcCd) {
		this.tjOfcCd = tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param calcNo
	 */
	public void setCalcNo(String calcNo) {
		this.calcNo = calcNo;
	}
	
	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param payGrpLuCd
	 */
	public void setPayGrpLuCd(String payGrpLuCd) {
		this.payGrpLuCd = payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param errVvdBkgNo
	 */
	public void setErrVvdBkgNo(String errVvdBkgNo) {
		this.errVvdBkgNo = errVvdBkgNo;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param invTermDt
	 */
	public void setInvTermDt(String invTermDt) {
		this.invTermDt = invTermDt;
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
	 * @param asaCnt
	 */
	public void setAsaCnt(String asaCnt) {
		this.asaCnt = asaCnt;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
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
	 * @param coaIntrCmpyCd
	 */
	public void setCoaIntrCmpyCd(String coaIntrCmpyCd) {
		this.coaIntrCmpyCd = coaIntrCmpyCd;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}
	
	/**
	 * Column Info
	 * @param localDt
	 */
	public void setLocalDt(String localDt) {
		this.localDt = localDt;
	}

	/**
	 * Column Info
	 * @param agmtDocCfmCd
	 */
	public void setAgmtDocCfmCd(String agmtDocCfmCd) {
		this.agmtDocCfmCd = agmtDocCfmCd;
	}

	/**
	 * Column Info
	 * @param gwAgmtDocCfmCd
	 */
	public void setGwAgmtDocCfmCd(String gwAgmtDocCfmCd) {
		this.gwAgmtDocCfmCd = gwAgmtDocCfmCd;
	}

	/**
	 * Column Info
	 * @param agmtFileCfmCd
	 */
	public void setAgmtFileCfmCd(String agmtFileCfmCd) {
		this.agmtFileCfmCd = agmtFileCfmCd;
	}

	/**
	 * Column Info
	 * @param agmtEvidCfmFnlCd
	 */
	public void setAgmtEvidCfmFnlCd(String agmtEvidCfmFnlCd) {
		this.agmtEvidCfmFnlCd = agmtEvidCfmFnlCd;
	}

	/**
	 * Column Info
	 * @param csrGenExpnAcctFlg
	 */
	public void setCsrGenExpnAcctFlg(String csrGenExpnAcctFlg) {
		this.csrGenExpnAcctFlg = csrGenExpnAcctFlg;
	}

	/**
	 * Column Info
	 * @param csrAproTpCd
	 */
	public void setCsrAproTpCd(String csrAproTpCd) {
		this.csrAproTpCd = csrAproTpCd;
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
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDtrbCnt(JSPUtil.getParameter(request, prefix + "dtrb_cnt", ""));
		setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
		setAsaCurrCd(JSPUtil.getParameter(request, prefix + "asa_curr_cd", ""));
		setWhldTaxRt(JSPUtil.getParameter(request, prefix + "whld_tax_rt", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setSRevChg(JSPUtil.getParameter(request, prefix + "s_rev_chg", ""));
		setErrBkgCreDt(JSPUtil.getParameter(request, prefix + "err_bkg_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setErrBkgNo(JSPUtil.getParameter(request, prefix + "err_bkg_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrVvd(JSPUtil.getParameter(request, prefix + "err_vvd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setTjOfcCd(JSPUtil.getParameter(request, prefix + "tj_ofc_cd", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setInvTaxRt(JSPUtil.getParameter(request, prefix + "inv_tax_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setCalcNo(JSPUtil.getParameter(request, prefix + "calc_no", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request, prefix + "pay_grp_lu_cd", ""));
		setVndrTermNm(JSPUtil.getParameter(request, prefix + "vndr_term_nm", ""));
		setErrVvdBkgNo(JSPUtil.getParameter(request, prefix + "err_vvd_bkg_no", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setInvTermDt(JSPUtil.getParameter(request, prefix + "inv_term_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAsaCnt(JSPUtil.getParameter(request, prefix + "asa_cnt", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setCoaIntrCmpyCd(JSPUtil.getParameter(request, prefix + "coa_intr_cmpy_cd", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setLocalDt(JSPUtil.getParameter(request, prefix + "local_dt", ""));
		setLocalDt(JSPUtil.getParameter(request, prefix + "approved_yn", ""));
		setAgmtDocCfmCd(JSPUtil.getParameter(request, prefix + "agmt_doc_cfm_cd", ""));
		setGwAgmtDocCfmCd(JSPUtil.getParameter(request, prefix + "gw_agmt_doc_cfm_cd", ""));
		setAgmtFileCfmCd(JSPUtil.getParameter(request, prefix + "agmt_file_cfm_cd", ""));
		setAgmtEvidCfmFnlCd(JSPUtil.getParameter(request, prefix + "agmt_evid_cfm_fnl_cd", ""));
		setCsrGenExpnAcctFlg(JSPUtil.getParameter(request, prefix + "csr_gen_expn_acct_flg", ""));
		setCsrAproTpCd(JSPUtil.getParameter(request, prefix + "csr_apro_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommApprovalRequestVO[]
	 */
	public AGNCommApprovalRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGNCommApprovalRequestVO[]
	 */
	public AGNCommApprovalRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommApprovalRequestVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dtrbCnt = (JSPUtil.getParameter(request, prefix	+ "dtrb_cnt", length));
			String[] fincRgnCd = (JSPUtil.getParameter(request, prefix	+ "finc_rgn_cd", length));
			String[] asaCurrCd = (JSPUtil.getParameter(request, prefix	+ "asa_curr_cd", length));
			String[] whldTaxRt = (JSPUtil.getParameter(request, prefix	+ "whld_tax_rt", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] sRevChg = (JSPUtil.getParameter(request, prefix	+ "s_rev_chg", length));
			String[] errBkgCreDt = (JSPUtil.getParameter(request, prefix	+ "err_bkg_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errBkgNo = (JSPUtil.getParameter(request, prefix	+ "err_bkg_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errVvd = (JSPUtil.getParameter(request, prefix	+ "err_vvd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] tjOfcCd = (JSPUtil.getParameter(request, prefix	+ "tj_ofc_cd", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] calcNo = (JSPUtil.getParameter(request, prefix	+ "calc_no", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] payGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_grp_lu_cd", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] errVvdBkgNo = (JSPUtil.getParameter(request, prefix	+ "err_vvd_bkg_no", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] invTermDt = (JSPUtil.getParameter(request, prefix	+ "inv_term_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] asaCnt = (JSPUtil.getParameter(request, prefix	+ "asa_cnt", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] coaIntrCmpyCd = (JSPUtil.getParameter(request, prefix	+ "coa_intr_cmpy_cd", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] localDt = (JSPUtil.getParameter(request, prefix	+ "local_dt", length));
			String[] approvedYN = (JSPUtil.getParameter(request, prefix	+ "approved_yn", length));
			String[] agmtDocCfmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_cfm_cd", length));
			String[] gwAgmtDocCfmCd = (JSPUtil.getParameter(request, prefix	+ "gw_agmt_doc_cfm_cd", length));
			String[] agmtFileCfmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_file_cfm_cd", length));
			String[] agmtEvidCfmFnlCd = (JSPUtil.getParameter(request, prefix	+ "agmt_evid_cfm_fnl_cd", length));
			String[] csrGenExpnAcctFlg = (JSPUtil.getParameter(request, prefix	+ "csr_gen_expn_acct_flg", length));
			String[] csrAproTpCd = (JSPUtil.getParameter(request, prefix + "csr_apro_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new AGNCommApprovalRequestVO();
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dtrbCnt[i] != null)
					model.setDtrbCnt(dtrbCnt[i]);
				if (fincRgnCd[i] != null)
					model.setFincRgnCd(fincRgnCd[i]);
				if (asaCurrCd[i] != null)
					model.setAsaCurrCd(asaCurrCd[i]);
				if (whldTaxRt[i] != null)
					model.setWhldTaxRt(whldTaxRt[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (sRevChg[i] != null)
					model.setSRevChg(sRevChg[i]);
				if (errBkgCreDt[i] != null)
					model.setErrBkgCreDt(errBkgCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errBkgNo[i] != null)
					model.setErrBkgNo(errBkgNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errVvd[i] != null)
					model.setErrVvd(errVvd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (tjOfcCd[i] != null)
					model.setTjOfcCd(tjOfcCd[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (calcNo[i] != null)
					model.setCalcNo(calcNo[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (payGrpLuCd[i] != null)
					model.setPayGrpLuCd(payGrpLuCd[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (errVvdBkgNo[i] != null)
					model.setErrVvdBkgNo(errVvdBkgNo[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (invTermDt[i] != null)
					model.setInvTermDt(invTermDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (asaCnt[i] != null)
					model.setAsaCnt(asaCnt[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (coaIntrCmpyCd[i] != null)
					model.setCoaIntrCmpyCd(coaIntrCmpyCd[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (localDt[i] != null)
					model.setLocalDt(localDt[i]);
				if (approvedYN[i] != null)
					model.setApprovedYN(approvedYN[i]);
				if (agmtDocCfmCd[i] != null)
					model.setAgmtDocCfmCd(agmtDocCfmCd[i]);
				if (gwAgmtDocCfmCd[i] != null)
					model.setGwAgmtDocCfmCd(gwAgmtDocCfmCd[i]);
				if (agmtFileCfmCd[i] != null)
					model.setAgmtFileCfmCd(agmtFileCfmCd[i]);
				if (agmtEvidCfmFnlCd[i] != null)
					model.setAgmtEvidCfmFnlCd(agmtEvidCfmFnlCd[i]);
				if (csrGenExpnAcctFlg[i] != null)
					model.setCsrGenExpnAcctFlg(csrGenExpnAcctFlg[i]);
				if (csrAproTpCd[i] != null)
					model.setCsrAproTpCd(csrAproTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommApprovalRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommApprovalRequestVO[]
	 */
	public AGNCommApprovalRequestVO[] getAGNCommApprovalRequestVOs(){
		AGNCommApprovalRequestVO[] vos = (AGNCommApprovalRequestVO[])models.toArray(new AGNCommApprovalRequestVO[models.size()]);
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
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCnt = this.dtrbCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincRgnCd = this.fincRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCurrCd = this.asaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxRt = this.whldTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRevChg = this.sRevChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errBkgCreDt = this.errBkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errBkgNo = this.errBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvd = this.errVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjOfcCd = this.tjOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcNo = this.calcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd = this.payGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errVvdBkgNo = this.errVvdBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt = this.invTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCnt = this.asaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaIntrCmpyCd = this.coaIntrCmpyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localDt = this.localDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvedYN = this.approvedYN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocCfmCd = this.agmtDocCfmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwAgmtDocCfmCd = this.gwAgmtDocCfmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFileCfmCd = this.agmtFileCfmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtEvidCfmFnlCd = this.agmtEvidCfmFnlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrGenExpnAcctFlg = this.csrGenExpnAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAproTpCd = this.csrAproTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
