/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceCombinedVO.java
*@FileTitle : InvoiceCombinedVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.30 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceCombinedVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceCombinedVO> models = new ArrayList<InvoiceCombinedVO>();
	
	/* Column Info */
	private String ccRcvrEml = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String n3rdStmtCtnt = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String sigStmtCtnt = null;
	/* Column Info */
	private String joHjsAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlProcStsCd = null;
	/* Column Info */
	private String emlDt = null;
	/* Column Info */
	private String ttlStlAmt = null;
	/* Column Info */
	private String joBalAmt = null;
	/* Column Info */
	private String n1stStmtCtnt = null;
	/* Column Info */
	private String faxDt = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ltrRcvrCoNm = null;
	/* Column Info */
	private String joBalAmtLbl = null;
	/* Column Info */
	private String ltrSndrCoNm = null;
	/* Column Info */
	private String ltrTitCtnt = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String joCntcFaxNo = null;
	/* Column Info */
	private String faxProcStsCd = null;
	/* Column Info */
	private String sndrNm = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String joSndMzdCd = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String ltrRcvrCntcPsonNm = null;
	/* Column Info */
	private String joLtrNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndStmtCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ltrCcRcvrCntcPsonNm = null;
	/* Column Info */
	private String stlRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ltrIssDt = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bankStmtCtnt = null;
	/* Column Info */
	private String joLtrTpCd = null;
	/* Column Info */
	private String joPrnrAmt = null;
	/* Column Info */
	private String joLtrSeq = null;
	/* Column Info */
	private String rcvrInfoCtnt = null;
	/* Column Info */
	private String reDivrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceCombinedVO() {}

	public InvoiceCombinedVO(String ibflag, String pagerows, String joBalAmtLbl, String stlCmbSeq, String stlRmk, String ttlAmt, String rlaneCd, String joHjsAmt, String joPrnrAmt, String joBalAmt, String joLtrSeq, String joLtrTpCd, String trdCd, String ofcCd, String ltrIssDt, String ltrRcvrCoNm, String ltrRcvrCntcPsonNm, String ltrCcRcvrCntcPsonNm, String ltrSndrCoNm, String sndrNm, String ltrTitCtnt, String ttlStlAmt, String joSndMzdCd, String joLtrNo, String ofcAddr, String n1stStmtCtnt, String n2ndStmtCtnt, String n3rdStmtCtnt, String sigStmtCtnt, String bankStmtCtnt, String acctYrmon, String joCrrCd, String reDivrCd, String sndrEml, String rcvrEml, String ccRcvrEml, String emlProcStsCd, String emlSndNo, String emlDt, String joCntcFaxNo, String rcvrInfoCtnt, String faxProcStsCd, String faxSndNo, String faxDt, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId) {
		this.ccRcvrEml = ccRcvrEml;
		this.trdCd = trdCd;
		this.n3rdStmtCtnt = n3rdStmtCtnt;
		this.sndrEml = sndrEml;
		this.ttlAmt = ttlAmt;
		this.rlaneCd = rlaneCd;
		this.sigStmtCtnt = sigStmtCtnt;
		this.joHjsAmt = joHjsAmt;
		this.pagerows = pagerows;
		this.emlProcStsCd = emlProcStsCd;
		this.emlDt = emlDt;
		this.ttlStlAmt = ttlStlAmt;
		this.joBalAmt = joBalAmt;
		this.n1stStmtCtnt = n1stStmtCtnt;
		this.faxDt = faxDt;
		this.ofcAddr = ofcAddr;
		this.updUsrId = updUsrId;
		this.ltrRcvrCoNm = ltrRcvrCoNm;
		this.joBalAmtLbl = joBalAmtLbl;
		this.ltrSndrCoNm = ltrSndrCoNm;
		this.ltrTitCtnt = ltrTitCtnt;
		this.acctYrmon = acctYrmon;
		this.rcvrEml = rcvrEml;
		this.creUsrId = creUsrId;
		this.joCntcFaxNo = joCntcFaxNo;
		this.faxProcStsCd = faxProcStsCd;
		this.sndrNm = sndrNm;
		this.faxSndNo = faxSndNo;
		this.joSndMzdCd = joSndMzdCd;
		this.stlCmbSeq = stlCmbSeq;
		this.ltrRcvrCntcPsonNm = ltrRcvrCntcPsonNm;
		this.joLtrNo = joLtrNo;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.n2ndStmtCtnt = n2ndStmtCtnt;
		this.ibflag = ibflag;
		this.ltrCcRcvrCntcPsonNm = ltrCcRcvrCntcPsonNm;
		this.stlRmk = stlRmk;
		this.updDt = updDt;
		this.ltrIssDt = ltrIssDt;
		this.joCrrCd = joCrrCd;
		this.emlSndNo = emlSndNo;
		this.ofcCd = ofcCd;
		this.bankStmtCtnt = bankStmtCtnt;
		this.joLtrTpCd = joLtrTpCd;
		this.joPrnrAmt = joPrnrAmt;
		this.joLtrSeq = joLtrSeq;
		this.rcvrInfoCtnt = rcvrInfoCtnt;
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cc_rcvr_eml", getCcRcvrEml());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("n3rd_stmt_ctnt", getN3rdStmtCtnt());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sig_stmt_ctnt", getSigStmtCtnt());
		this.hashColumns.put("jo_hjs_amt", getJoHjsAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		this.hashColumns.put("eml_dt", getEmlDt());
		this.hashColumns.put("ttl_stl_amt", getTtlStlAmt());
		this.hashColumns.put("jo_bal_amt", getJoBalAmt());
		this.hashColumns.put("n1st_stmt_ctnt", getN1stStmtCtnt());
		this.hashColumns.put("fax_dt", getFaxDt());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ltr_rcvr_co_nm", getLtrRcvrCoNm());
		this.hashColumns.put("jo_bal_amt_lbl", getJoBalAmtLbl());
		this.hashColumns.put("ltr_sndr_co_nm", getLtrSndrCoNm());
		this.hashColumns.put("ltr_tit_ctnt", getLtrTitCtnt());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jo_cntc_fax_no", getJoCntcFaxNo());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("sndr_nm", getSndrNm());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("jo_snd_mzd_cd", getJoSndMzdCd());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("ltr_rcvr_cntc_pson_nm", getLtrRcvrCntcPsonNm());
		this.hashColumns.put("jo_ltr_no", getJoLtrNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n2nd_stmt_ctnt", getN2ndStmtCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ltr_cc_rcvr_cntc_pson_nm", getLtrCcRcvrCntcPsonNm());
		this.hashColumns.put("stl_rmk", getStlRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ltr_iss_dt", getLtrIssDt());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bank_stmt_ctnt", getBankStmtCtnt());
		this.hashColumns.put("jo_ltr_tp_cd", getJoLtrTpCd());
		this.hashColumns.put("jo_prnr_amt", getJoPrnrAmt());
		this.hashColumns.put("jo_ltr_seq", getJoLtrSeq());
		this.hashColumns.put("rcvr_info_ctnt", getRcvrInfoCtnt());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cc_rcvr_eml", "ccRcvrEml");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("n3rd_stmt_ctnt", "n3rdStmtCtnt");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sig_stmt_ctnt", "sigStmtCtnt");
		this.hashFields.put("jo_hjs_amt", "joHjsAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		this.hashFields.put("eml_dt", "emlDt");
		this.hashFields.put("ttl_stl_amt", "ttlStlAmt");
		this.hashFields.put("jo_bal_amt", "joBalAmt");
		this.hashFields.put("n1st_stmt_ctnt", "n1stStmtCtnt");
		this.hashFields.put("fax_dt", "faxDt");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ltr_rcvr_co_nm", "ltrRcvrCoNm");
		this.hashFields.put("jo_bal_amt_lbl", "joBalAmtLbl");
		this.hashFields.put("ltr_sndr_co_nm", "ltrSndrCoNm");
		this.hashFields.put("ltr_tit_ctnt", "ltrTitCtnt");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jo_cntc_fax_no", "joCntcFaxNo");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("sndr_nm", "sndrNm");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("jo_snd_mzd_cd", "joSndMzdCd");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("ltr_rcvr_cntc_pson_nm", "ltrRcvrCntcPsonNm");
		this.hashFields.put("jo_ltr_no", "joLtrNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_stmt_ctnt", "n2ndStmtCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ltr_cc_rcvr_cntc_pson_nm", "ltrCcRcvrCntcPsonNm");
		this.hashFields.put("stl_rmk", "stlRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ltr_iss_dt", "ltrIssDt");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bank_stmt_ctnt", "bankStmtCtnt");
		this.hashFields.put("jo_ltr_tp_cd", "joLtrTpCd");
		this.hashFields.put("jo_prnr_amt", "joPrnrAmt");
		this.hashFields.put("jo_ltr_seq", "joLtrSeq");
		this.hashFields.put("rcvr_info_ctnt", "rcvrInfoCtnt");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ccRcvrEml
	 */
	public String getCcRcvrEml() {
		return this.ccRcvrEml;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdStmtCtnt
	 */
	public String getN3rdStmtCtnt() {
		return this.n3rdStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return sigStmtCtnt
	 */
	public String getSigStmtCtnt() {
		return this.sigStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return joHjsAmt
	 */
	public String getJoHjsAmt() {
		return this.joHjsAmt;
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
	 * @return emlProcStsCd
	 */
	public String getEmlProcStsCd() {
		return this.emlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return emlDt
	 */
	public String getEmlDt() {
		return this.emlDt;
	}
	
	/**
	 * Column Info
	 * @return ttlStlAmt
	 */
	public String getTtlStlAmt() {
		return this.ttlStlAmt;
	}
	
	/**
	 * Column Info
	 * @return joBalAmt
	 */
	public String getJoBalAmt() {
		return this.joBalAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stStmtCtnt
	 */
	public String getN1stStmtCtnt() {
		return this.n1stStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return faxDt
	 */
	public String getFaxDt() {
		return this.faxDt;
	}
	
	/**
	 * Column Info
	 * @return ofcAddr
	 */
	public String getOfcAddr() {
		return this.ofcAddr;
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
	 * @return ltrRcvrCoNm
	 */
	public String getLtrRcvrCoNm() {
		return this.ltrRcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @return joBalAmtLbl
	 */
	public String getJoBalAmtLbl() {
		return this.joBalAmtLbl;
	}
	
	/**
	 * Column Info
	 * @return ltrSndrCoNm
	 */
	public String getLtrSndrCoNm() {
		return this.ltrSndrCoNm;
	}
	
	/**
	 * Column Info
	 * @return ltrTitCtnt
	 */
	public String getLtrTitCtnt() {
		return this.ltrTitCtnt;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
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
	 * @return joCntcFaxNo
	 */
	public String getJoCntcFaxNo() {
		return this.joCntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return sndrNm
	 */
	public String getSndrNm() {
		return this.sndrNm;
	}
	
	/**
	 * Column Info
	 * @return faxSndNo
	 */
	public String getFaxSndNo() {
		return this.faxSndNo;
	}
	
	/**
	 * Column Info
	 * @return joSndMzdCd
	 */
	public String getJoSndMzdCd() {
		return this.joSndMzdCd;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return ltrRcvrCntcPsonNm
	 */
	public String getLtrRcvrCntcPsonNm() {
		return this.ltrRcvrCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return joLtrNo
	 */
	public String getJoLtrNo() {
		return this.joLtrNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndStmtCtnt
	 */
	public String getN2ndStmtCtnt() {
		return this.n2ndStmtCtnt;
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
	 * @return ltrCcRcvrCntcPsonNm
	 */
	public String getLtrCcRcvrCntcPsonNm() {
		return this.ltrCcRcvrCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return stlRmk
	 */
	public String getStlRmk() {
		return this.stlRmk;
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
	 * @return ltrIssDt
	 */
	public String getLtrIssDt() {
		return this.ltrIssDt;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
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
	 * @return bankStmtCtnt
	 */
	public String getBankStmtCtnt() {
		return this.bankStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return joLtrTpCd
	 */
	public String getJoLtrTpCd() {
		return this.joLtrTpCd;
	}
	
	/**
	 * Column Info
	 * @return joPrnrAmt
	 */
	public String getJoPrnrAmt() {
		return this.joPrnrAmt;
	}
	
	/**
	 * Column Info
	 * @return joLtrSeq
	 */
	public String getJoLtrSeq() {
		return this.joLtrSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvrInfoCtnt
	 */
	public String getRcvrInfoCtnt() {
		return this.rcvrInfoCtnt;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	

	/**
	 * Column Info
	 * @param ccRcvrEml
	 */
	public void setCcRcvrEml(String ccRcvrEml) {
		this.ccRcvrEml = ccRcvrEml;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdStmtCtnt
	 */
	public void setN3rdStmtCtnt(String n3rdStmtCtnt) {
		this.n3rdStmtCtnt = n3rdStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param sndrEml
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param sigStmtCtnt
	 */
	public void setSigStmtCtnt(String sigStmtCtnt) {
		this.sigStmtCtnt = sigStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param joHjsAmt
	 */
	public void setJoHjsAmt(String joHjsAmt) {
		this.joHjsAmt = joHjsAmt;
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
	 * @param emlProcStsCd
	 */
	public void setEmlProcStsCd(String emlProcStsCd) {
		this.emlProcStsCd = emlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param emlDt
	 */
	public void setEmlDt(String emlDt) {
		this.emlDt = emlDt;
	}
	
	/**
	 * Column Info
	 * @param ttlStlAmt
	 */
	public void setTtlStlAmt(String ttlStlAmt) {
		this.ttlStlAmt = ttlStlAmt;
	}
	
	/**
	 * Column Info
	 * @param joBalAmt
	 */
	public void setJoBalAmt(String joBalAmt) {
		this.joBalAmt = joBalAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stStmtCtnt
	 */
	public void setN1stStmtCtnt(String n1stStmtCtnt) {
		this.n1stStmtCtnt = n1stStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param faxDt
	 */
	public void setFaxDt(String faxDt) {
		this.faxDt = faxDt;
	}
	
	/**
	 * Column Info
	 * @param ofcAddr
	 */
	public void setOfcAddr(String ofcAddr) {
		this.ofcAddr = ofcAddr;
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
	 * @param ltrRcvrCoNm
	 */
	public void setLtrRcvrCoNm(String ltrRcvrCoNm) {
		this.ltrRcvrCoNm = ltrRcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @param joBalAmtLbl
	 */
	public void setJoBalAmtLbl(String joBalAmtLbl) {
		this.joBalAmtLbl = joBalAmtLbl;
	}
	
	/**
	 * Column Info
	 * @param ltrSndrCoNm
	 */
	public void setLtrSndrCoNm(String ltrSndrCoNm) {
		this.ltrSndrCoNm = ltrSndrCoNm;
	}
	
	/**
	 * Column Info
	 * @param ltrTitCtnt
	 */
	public void setLtrTitCtnt(String ltrTitCtnt) {
		this.ltrTitCtnt = ltrTitCtnt;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
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
	 * @param joCntcFaxNo
	 */
	public void setJoCntcFaxNo(String joCntcFaxNo) {
		this.joCntcFaxNo = joCntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param sndrNm
	 */
	public void setSndrNm(String sndrNm) {
		this.sndrNm = sndrNm;
	}
	
	/**
	 * Column Info
	 * @param faxSndNo
	 */
	public void setFaxSndNo(String faxSndNo) {
		this.faxSndNo = faxSndNo;
	}
	
	/**
	 * Column Info
	 * @param joSndMzdCd
	 */
	public void setJoSndMzdCd(String joSndMzdCd) {
		this.joSndMzdCd = joSndMzdCd;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param ltrRcvrCntcPsonNm
	 */
	public void setLtrRcvrCntcPsonNm(String ltrRcvrCntcPsonNm) {
		this.ltrRcvrCntcPsonNm = ltrRcvrCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param joLtrNo
	 */
	public void setJoLtrNo(String joLtrNo) {
		this.joLtrNo = joLtrNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndStmtCtnt
	 */
	public void setN2ndStmtCtnt(String n2ndStmtCtnt) {
		this.n2ndStmtCtnt = n2ndStmtCtnt;
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
	 * @param ltrCcRcvrCntcPsonNm
	 */
	public void setLtrCcRcvrCntcPsonNm(String ltrCcRcvrCntcPsonNm) {
		this.ltrCcRcvrCntcPsonNm = ltrCcRcvrCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param stlRmk
	 */
	public void setStlRmk(String stlRmk) {
		this.stlRmk = stlRmk;
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
	 * @param ltrIssDt
	 */
	public void setLtrIssDt(String ltrIssDt) {
		this.ltrIssDt = ltrIssDt;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
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
	 * @param bankStmtCtnt
	 */
	public void setBankStmtCtnt(String bankStmtCtnt) {
		this.bankStmtCtnt = bankStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param joLtrTpCd
	 */
	public void setJoLtrTpCd(String joLtrTpCd) {
		this.joLtrTpCd = joLtrTpCd;
	}
	
	/**
	 * Column Info
	 * @param joPrnrAmt
	 */
	public void setJoPrnrAmt(String joPrnrAmt) {
		this.joPrnrAmt = joPrnrAmt;
	}
	
	/**
	 * Column Info
	 * @param joLtrSeq
	 */
	public void setJoLtrSeq(String joLtrSeq) {
		this.joLtrSeq = joLtrSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvrInfoCtnt
	 */
	public void setRcvrInfoCtnt(String rcvrInfoCtnt) {
		this.rcvrInfoCtnt = rcvrInfoCtnt;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCcRcvrEml(JSPUtil.getParameter(request, "cc_rcvr_eml", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setN3rdStmtCtnt(JSPUtil.getParameter(request, "n3rd_stmt_ctnt", ""));
		setSndrEml(JSPUtil.getParameter(request, "sndr_eml", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSigStmtCtnt(JSPUtil.getParameter(request, "sig_stmt_ctnt", ""));
		setJoHjsAmt(JSPUtil.getParameter(request, "jo_hjs_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
		setEmlDt(JSPUtil.getParameter(request, "eml_dt", ""));
		setTtlStlAmt(JSPUtil.getParameter(request, "ttl_stl_amt", ""));
		setJoBalAmt(JSPUtil.getParameter(request, "jo_bal_amt", ""));
		setN1stStmtCtnt(JSPUtil.getParameter(request, "n1st_stmt_ctnt", ""));
		setFaxDt(JSPUtil.getParameter(request, "fax_dt", ""));
		setOfcAddr(JSPUtil.getParameter(request, "ofc_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLtrRcvrCoNm(JSPUtil.getParameter(request, "ltr_rcvr_co_nm", ""));
		setJoBalAmtLbl(JSPUtil.getParameter(request, "jo_bal_amt_lbl", ""));
		setLtrSndrCoNm(JSPUtil.getParameter(request, "ltr_sndr_co_nm", ""));
		setLtrTitCtnt(JSPUtil.getParameter(request, "ltr_tit_ctnt", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setRcvrEml(JSPUtil.getParameter(request, "rcvr_eml", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setJoCntcFaxNo(JSPUtil.getParameter(request, "jo_cntc_fax_no", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setSndrNm(JSPUtil.getParameter(request, "sndr_nm", ""));
		setFaxSndNo(JSPUtil.getParameter(request, "fax_snd_no", ""));
		setJoSndMzdCd(JSPUtil.getParameter(request, "jo_snd_mzd_cd", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setLtrRcvrCntcPsonNm(JSPUtil.getParameter(request, "ltr_rcvr_cntc_pson_nm", ""));
		setJoLtrNo(JSPUtil.getParameter(request, "jo_ltr_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN2ndStmtCtnt(JSPUtil.getParameter(request, "n2nd_stmt_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLtrCcRcvrCntcPsonNm(JSPUtil.getParameter(request, "ltr_cc_rcvr_cntc_pson_nm", ""));
		setStlRmk(JSPUtil.getParameter(request, "stl_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLtrIssDt(JSPUtil.getParameter(request, "ltr_iss_dt", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setEmlSndNo(JSPUtil.getParameter(request, "eml_snd_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBankStmtCtnt(JSPUtil.getParameter(request, "bank_stmt_ctnt", ""));
		setJoLtrTpCd(JSPUtil.getParameter(request, "jo_ltr_tp_cd", ""));
		setJoPrnrAmt(JSPUtil.getParameter(request, "jo_prnr_amt", ""));
		setJoLtrSeq(JSPUtil.getParameter(request, "jo_ltr_seq", ""));
		setRcvrInfoCtnt(JSPUtil.getParameter(request, "rcvr_info_ctnt", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceCombinedVO[]
	 */
	public InvoiceCombinedVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceCombinedVO[]
	 */
	public InvoiceCombinedVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceCombinedVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ccRcvrEml = (JSPUtil.getParameter(request, prefix	+ "cc_rcvr_eml", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] n3rdStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_stmt_ctnt", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] sigStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "sig_stmt_ctnt", length));
			String[] joHjsAmt = (JSPUtil.getParameter(request, prefix	+ "jo_hjs_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "eml_proc_sts_cd", length));
			String[] emlDt = (JSPUtil.getParameter(request, prefix	+ "eml_dt", length));
			String[] ttlStlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_stl_amt", length));
			String[] joBalAmt = (JSPUtil.getParameter(request, prefix	+ "jo_bal_amt", length));
			String[] n1stStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n1st_stmt_ctnt", length));
			String[] faxDt = (JSPUtil.getParameter(request, prefix	+ "fax_dt", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ltrRcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "ltr_rcvr_co_nm", length));
			String[] joBalAmtLbl = (JSPUtil.getParameter(request, prefix	+ "jo_bal_amt_lbl", length));
			String[] ltrSndrCoNm = (JSPUtil.getParameter(request, prefix	+ "ltr_sndr_co_nm", length));
			String[] ltrTitCtnt = (JSPUtil.getParameter(request, prefix	+ "ltr_tit_ctnt", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] joCntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_fax_no", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix	+ "fax_proc_sts_cd", length));
			String[] sndrNm = (JSPUtil.getParameter(request, prefix	+ "sndr_nm", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] joSndMzdCd = (JSPUtil.getParameter(request, prefix	+ "jo_snd_mzd_cd", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] ltrRcvrCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ltr_rcvr_cntc_pson_nm", length));
			String[] joLtrNo = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n2ndStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_stmt_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ltrCcRcvrCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ltr_cc_rcvr_cntc_pson_nm", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ltrIssDt = (JSPUtil.getParameter(request, prefix	+ "ltr_iss_dt", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bankStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "bank_stmt_ctnt", length));
			String[] joLtrTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_tp_cd", length));
			String[] joPrnrAmt = (JSPUtil.getParameter(request, prefix	+ "jo_prnr_amt", length));
			String[] joLtrSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_seq", length));
			String[] rcvrInfoCtnt = (JSPUtil.getParameter(request, prefix	+ "rcvr_info_ctnt", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceCombinedVO();
				if (ccRcvrEml[i] != null)
					model.setCcRcvrEml(ccRcvrEml[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (n3rdStmtCtnt[i] != null)
					model.setN3rdStmtCtnt(n3rdStmtCtnt[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (sigStmtCtnt[i] != null)
					model.setSigStmtCtnt(sigStmtCtnt[i]);
				if (joHjsAmt[i] != null)
					model.setJoHjsAmt(joHjsAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlProcStsCd[i] != null)
					model.setEmlProcStsCd(emlProcStsCd[i]);
				if (emlDt[i] != null)
					model.setEmlDt(emlDt[i]);
				if (ttlStlAmt[i] != null)
					model.setTtlStlAmt(ttlStlAmt[i]);
				if (joBalAmt[i] != null)
					model.setJoBalAmt(joBalAmt[i]);
				if (n1stStmtCtnt[i] != null)
					model.setN1stStmtCtnt(n1stStmtCtnt[i]);
				if (faxDt[i] != null)
					model.setFaxDt(faxDt[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ltrRcvrCoNm[i] != null)
					model.setLtrRcvrCoNm(ltrRcvrCoNm[i]);
				if (joBalAmtLbl[i] != null)
					model.setJoBalAmtLbl(joBalAmtLbl[i]);
				if (ltrSndrCoNm[i] != null)
					model.setLtrSndrCoNm(ltrSndrCoNm[i]);
				if (ltrTitCtnt[i] != null)
					model.setLtrTitCtnt(ltrTitCtnt[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (joCntcFaxNo[i] != null)
					model.setJoCntcFaxNo(joCntcFaxNo[i]);
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (sndrNm[i] != null)
					model.setSndrNm(sndrNm[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (joSndMzdCd[i] != null)
					model.setJoSndMzdCd(joSndMzdCd[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (ltrRcvrCntcPsonNm[i] != null)
					model.setLtrRcvrCntcPsonNm(ltrRcvrCntcPsonNm[i]);
				if (joLtrNo[i] != null)
					model.setJoLtrNo(joLtrNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndStmtCtnt[i] != null)
					model.setN2ndStmtCtnt(n2ndStmtCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ltrCcRcvrCntcPsonNm[i] != null)
					model.setLtrCcRcvrCntcPsonNm(ltrCcRcvrCntcPsonNm[i]);
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ltrIssDt[i] != null)
					model.setLtrIssDt(ltrIssDt[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bankStmtCtnt[i] != null)
					model.setBankStmtCtnt(bankStmtCtnt[i]);
				if (joLtrTpCd[i] != null)
					model.setJoLtrTpCd(joLtrTpCd[i]);
				if (joPrnrAmt[i] != null)
					model.setJoPrnrAmt(joPrnrAmt[i]);
				if (joLtrSeq[i] != null)
					model.setJoLtrSeq(joLtrSeq[i]);
				if (rcvrInfoCtnt[i] != null)
					model.setRcvrInfoCtnt(rcvrInfoCtnt[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceCombinedVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceCombinedVO[]
	 */
	public InvoiceCombinedVO[] getInvoiceCombinedVOs(){
		InvoiceCombinedVO[] vos = (InvoiceCombinedVO[])models.toArray(new InvoiceCombinedVO[models.size()]);
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
		this.ccRcvrEml = this.ccRcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdStmtCtnt = this.n3rdStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sigStmtCtnt = this.sigStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joHjsAmt = this.joHjsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDt = this.emlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlStlAmt = this.ttlStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBalAmt = this.joBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stStmtCtnt = this.n1stStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxDt = this.faxDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrRcvrCoNm = this.ltrRcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBalAmtLbl = this.joBalAmtLbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrSndrCoNm = this.ltrSndrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrTitCtnt = this.ltrTitCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcFaxNo = this.joCntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrNm = this.sndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSndMzdCd = this.joSndMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrRcvrCntcPsonNm = this.ltrRcvrCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrNo = this.joLtrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndStmtCtnt = this.n2ndStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrCcRcvrCntcPsonNm = this.ltrCcRcvrCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrIssDt = this.ltrIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtCtnt = this.bankStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrTpCd = this.joLtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrnrAmt = this.joPrnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrSeq = this.joLtrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrInfoCtnt = this.rcvrInfoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
