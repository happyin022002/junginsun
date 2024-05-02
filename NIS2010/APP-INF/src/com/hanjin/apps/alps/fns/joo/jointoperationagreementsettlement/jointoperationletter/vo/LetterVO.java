/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LetterVO.java
*@FileTitle : LetterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.12 장강철 
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

public class LetterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LetterVO> models = new ArrayList<LetterVO>();
	
	/* Column Info */
	private String ccRcvrEmlCtnt = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String n3rdStmtCtnt = null;
	/* Column Info */
	private String trdCd = null;
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
	private String joLtrStlSeq = null;
	/* Column Info */
	private String emlDt = null;
	/* Column Info */
	private String joBalAmt = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String ttlStlAmt = null;
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
	private String greeting = null;
	/* Column Info */
	private String ltrSndrCoNm = null;
	/* Column Info */
	private String ltrTitCtnt = null;
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String faxProcStsCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String jointOperationLetterTemplat = null;
	/* Column Info */
	private String letterNo = null;
	/* Column Info */
	private String sndrNm = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String joSndMzdCd = null;
	/* Column Info */
	private String ltrRcvrCntcPsonNm = null;
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String xtnPhnNo = null;
	/* Column Info */
	private String joLtrNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sendType = null;
	/* Column Info */
	private String n2ndStmtCtnt = null;
	/* Column Info */
	private String sendFaxNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String sendTypeFax = null;
	/* Column Info */
	private String joTmpltNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String jbEngNm = null;
	/* Column Info */
	private String stlRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String joLtrTmpltSeq = null;
	/* Column Info */
	private String tmplparam = null;
	/* Column Info */
	private String tmplmrd = null;
	/* Column Info */
	private String keys = null;
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
	private String ltrCcRcvrCntcPsonNmCtnt = null;
	/* Column Info */
	private String rcvrInfoCtnt = null;
	/* Column Info */
	private String joPrnrAmt = null;
	/* Column Info */
	private String joLtrSeq = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String joCntcFaxNoCtnt = null;
	/* Column Info */
	private String attachYn = null;
	/* Column Info */
	private String sendTypeMail = null;
	/* Column Info */
	private String joTmpltNoSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LetterVO() {}

	public LetterVO(String ibflag, String pagerows, String greeting, String usrNm, String usrEml, String jbEngNm, String ofcCd, String xtnPhnNo, String faxNo, String attachYn, String joTmpltNoSeq, String joLtrTmpltSeq, String bankStmtCtnt, String joTmpltNo, String usrId, String joHjsAmt, String joPrnrAmt, String joBalAmt, String sendType, String sendFaxNo, String rlaneCd, String letterNo, String subSysCd, String ttlAmt, String stlRmk, String content, String title, String sendTypeFax, String sendTypeMail, String tmplmrd, String tmplparam, String fileSavId, String keys, String joLtrStlSeq, String joLtrSeq, String joLtrTpCd, String trdCd, String ltrIssDt, String ltrRcvrCoNm, String ltrRcvrCntcPsonNm, String ltrCcRcvrCntcPsonNmCtnt, String ltrSndrCoNm, String sndrNm, String ltrTitCtnt, String ttlStlAmt, String joSndMzdCd, String joLtrNo, String ofcAddr, String n1stStmtCtnt, String n2ndStmtCtnt, String n3rdStmtCtnt, String sigStmtCtnt, String acctYrmon, String joCrrCd, String reDivrCd, String stlCmbSeq, String sndrEml, String rcvrEml, String ccRcvrEmlCtnt, String emlProcStsCd, String emlSndNo, String emlDt, String joCntcFaxNoCtnt, String rcvrInfoCtnt, String faxProcStsCd, String faxSndNo, String faxDt, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId, String jointOperationLetterTemplat) {
		this.ccRcvrEmlCtnt = ccRcvrEmlCtnt;
		this.sndrEml = sndrEml;
		this.n3rdStmtCtnt = n3rdStmtCtnt;
		this.trdCd = trdCd;
		this.ttlAmt = ttlAmt;
		this.rlaneCd = rlaneCd;
		this.sigStmtCtnt = sigStmtCtnt;
		this.joHjsAmt = joHjsAmt;
		this.pagerows = pagerows;
		this.emlProcStsCd = emlProcStsCd;
		this.joLtrStlSeq = joLtrStlSeq;
		this.emlDt = emlDt;
		this.joBalAmt = joBalAmt;
		this.usrEml = usrEml;
		this.ttlStlAmt = ttlStlAmt;
		this.n1stStmtCtnt = n1stStmtCtnt;
		this.faxDt = faxDt;
		this.ofcAddr = ofcAddr;
		this.updUsrId = updUsrId;
		this.ltrRcvrCoNm = ltrRcvrCoNm;
		this.greeting = greeting;
		this.ltrSndrCoNm = ltrSndrCoNm;
		this.ltrTitCtnt = ltrTitCtnt;
		this.content = content;
		this.creUsrId = creUsrId;
		this.rcvrEml = rcvrEml;
		this.acctYrmon = acctYrmon;
		this.faxProcStsCd = faxProcStsCd;
		this.faxNo = faxNo;
		this.jointOperationLetterTemplat = jointOperationLetterTemplat;
		this.letterNo = letterNo;
		this.sndrNm = sndrNm;
		this.faxSndNo = faxSndNo;
		this.stlCmbSeq = stlCmbSeq;
		this.joSndMzdCd = joSndMzdCd;
		this.ltrRcvrCntcPsonNm = ltrRcvrCntcPsonNm;
		this.subSysCd = subSysCd;
		this.xtnPhnNo = xtnPhnNo;
		this.joLtrNo = joLtrNo;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.sendType = sendType;
		this.n2ndStmtCtnt = n2ndStmtCtnt;
		this.sendFaxNo = sendFaxNo;
		this.ibflag = ibflag;
		this.title = title;
		this.sendTypeFax = sendTypeFax;
		this.joTmpltNo = joTmpltNo;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.jbEngNm = jbEngNm;
		this.stlRmk = stlRmk;
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.joLtrTmpltSeq = joLtrTmpltSeq;
		this.tmplparam = tmplparam;
		this.tmplmrd = tmplmrd;
		this.keys = keys;
		this.ltrIssDt = ltrIssDt;
		this.joCrrCd = joCrrCd;
		this.emlSndNo = emlSndNo;
		this.ofcCd = ofcCd;
		this.bankStmtCtnt = bankStmtCtnt;
		this.joLtrTpCd = joLtrTpCd;
		this.ltrCcRcvrCntcPsonNmCtnt = ltrCcRcvrCntcPsonNmCtnt;
		this.rcvrInfoCtnt = rcvrInfoCtnt;
		this.joPrnrAmt = joPrnrAmt;
		this.joLtrSeq = joLtrSeq;
		this.reDivrCd = reDivrCd;
		this.joCntcFaxNoCtnt = joCntcFaxNoCtnt;
		this.attachYn = attachYn;
		this.sendTypeMail = sendTypeMail;
		this.joTmpltNoSeq = joTmpltNoSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cc_rcvr_eml_ctnt", getCcRcvrEmlCtnt());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("n3rd_stmt_ctnt", getN3rdStmtCtnt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sig_stmt_ctnt", getSigStmtCtnt());
		this.hashColumns.put("jo_hjs_amt", getJoHjsAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		this.hashColumns.put("jo_ltr_stl_seq", getJoLtrStlSeq());
		this.hashColumns.put("eml_dt", getEmlDt());
		this.hashColumns.put("jo_bal_amt", getJoBalAmt());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("ttl_stl_amt", getTtlStlAmt());
		this.hashColumns.put("n1st_stmt_ctnt", getN1stStmtCtnt());
		this.hashColumns.put("fax_dt", getFaxDt());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ltr_rcvr_co_nm", getLtrRcvrCoNm());
		this.hashColumns.put("greeting", getGreeting());
		this.hashColumns.put("ltr_sndr_co_nm", getLtrSndrCoNm());
		this.hashColumns.put("ltr_tit_ctnt", getLtrTitCtnt());
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("joint_operation_letter_templat", getJointOperationLetterTemplat());
		this.hashColumns.put("letter_no", getLetterNo());
		this.hashColumns.put("sndr_nm", getSndrNm());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("jo_snd_mzd_cd", getJoSndMzdCd());
		this.hashColumns.put("ltr_rcvr_cntc_pson_nm", getLtrRcvrCntcPsonNm());
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("xtn_phn_no", getXtnPhnNo());
		this.hashColumns.put("jo_ltr_no", getJoLtrNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("send_type", getSendType());
		this.hashColumns.put("n2nd_stmt_ctnt", getN2ndStmtCtnt());
		this.hashColumns.put("send_fax_no", getSendFaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("send_type_fax", getSendTypeFax());
		this.hashColumns.put("jo_tmplt_no", getJoTmpltNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("jb_eng_nm", getJbEngNm());
		this.hashColumns.put("stl_rmk", getStlRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("jo_ltr_tmplt_seq", getJoLtrTmpltSeq());
		this.hashColumns.put("tmplparam", getTmplparam());
		this.hashColumns.put("tmplmrd", getTmplmrd());
		this.hashColumns.put("keys", getKeys());
		this.hashColumns.put("ltr_iss_dt", getLtrIssDt());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bank_stmt_ctnt", getBankStmtCtnt());
		this.hashColumns.put("jo_ltr_tp_cd", getJoLtrTpCd());
		this.hashColumns.put("ltr_cc_rcvr_cntc_pson_nm_ctnt", getLtrCcRcvrCntcPsonNmCtnt());
		this.hashColumns.put("rcvr_info_ctnt", getRcvrInfoCtnt());
		this.hashColumns.put("jo_prnr_amt", getJoPrnrAmt());
		this.hashColumns.put("jo_ltr_seq", getJoLtrSeq());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("jo_cntc_fax_no_ctnt", getJoCntcFaxNoCtnt());
		this.hashColumns.put("attach_yn", getAttachYn());
		this.hashColumns.put("send_type_mail", getSendTypeMail());
		this.hashColumns.put("jo_tmplt_no_seq", getJoTmpltNoSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cc_rcvr_eml_ctnt", "ccRcvrEmlCtnt");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("n3rd_stmt_ctnt", "n3rdStmtCtnt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sig_stmt_ctnt", "sigStmtCtnt");
		this.hashFields.put("jo_hjs_amt", "joHjsAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		this.hashFields.put("jo_ltr_stl_seq", "joLtrStlSeq");
		this.hashFields.put("eml_dt", "emlDt");
		this.hashFields.put("jo_bal_amt", "joBalAmt");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("ttl_stl_amt", "ttlStlAmt");
		this.hashFields.put("n1st_stmt_ctnt", "n1stStmtCtnt");
		this.hashFields.put("fax_dt", "faxDt");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ltr_rcvr_co_nm", "ltrRcvrCoNm");
		this.hashFields.put("greeting", "greeting");
		this.hashFields.put("ltr_sndr_co_nm", "ltrSndrCoNm");
		this.hashFields.put("ltr_tit_ctnt", "ltrTitCtnt");
		this.hashFields.put("content", "content");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("joint_operation_letter_templat", "jointOperationLetterTemplat");
		this.hashFields.put("letter_no", "letterNo");
		this.hashFields.put("sndr_nm", "sndrNm");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("jo_snd_mzd_cd", "joSndMzdCd");
		this.hashFields.put("ltr_rcvr_cntc_pson_nm", "ltrRcvrCntcPsonNm");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("xtn_phn_no", "xtnPhnNo");
		this.hashFields.put("jo_ltr_no", "joLtrNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("n2nd_stmt_ctnt", "n2ndStmtCtnt");
		this.hashFields.put("send_fax_no", "sendFaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("send_type_fax", "sendTypeFax");
		this.hashFields.put("jo_tmplt_no", "joTmpltNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("jb_eng_nm", "jbEngNm");
		this.hashFields.put("stl_rmk", "stlRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("jo_ltr_tmplt_seq", "joLtrTmpltSeq");
		this.hashFields.put("tmplparam", "tmplparam");
		this.hashFields.put("tmplmrd", "tmplmrd");
		this.hashFields.put("keys", "keys");
		this.hashFields.put("ltr_iss_dt", "ltrIssDt");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bank_stmt_ctnt", "bankStmtCtnt");
		this.hashFields.put("jo_ltr_tp_cd", "joLtrTpCd");
		this.hashFields.put("ltr_cc_rcvr_cntc_pson_nm_ctnt", "ltrCcRcvrCntcPsonNmCtnt");
		this.hashFields.put("rcvr_info_ctnt", "rcvrInfoCtnt");
		this.hashFields.put("jo_prnr_amt", "joPrnrAmt");
		this.hashFields.put("jo_ltr_seq", "joLtrSeq");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("jo_cntc_fax_no_ctnt", "joCntcFaxNoCtnt");
		this.hashFields.put("attach_yn", "attachYn");
		this.hashFields.put("send_type_mail", "sendTypeMail");
		this.hashFields.put("jo_tmplt_no_seq", "joTmpltNoSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ccRcvrEmlCtnt
	 */
	public String getCcRcvrEmlCtnt() {
		return this.ccRcvrEmlCtnt;
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
	 * @return n3rdStmtCtnt
	 */
	public String getN3rdStmtCtnt() {
		return this.n3rdStmtCtnt;
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
	 * @return joLtrStlSeq
	 */
	public String getJoLtrStlSeq() {
		return this.joLtrStlSeq;
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
	 * @return joBalAmt
	 */
	public String getJoBalAmt() {
		return this.joBalAmt;
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
	 * @return ttlStlAmt
	 */
	public String getTtlStlAmt() {
		return this.ttlStlAmt;
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
	 * @return greeting
	 */
	public String getGreeting() {
		return this.greeting;
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
	 * @return content
	 */
	public String getContent() {
		return this.content;
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
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
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
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
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
	 * @return jointOperationLetterTemplat
	 */
	public String getJointOperationLetterTemplat() {
		return this.jointOperationLetterTemplat;
	}
	
	/**
	 * Column Info
	 * @return letterNo
	 */
	public String getLetterNo() {
		return this.letterNo;
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
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
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
	 * @return ltrRcvrCntcPsonNm
	 */
	public String getLtrRcvrCntcPsonNm() {
		return this.ltrRcvrCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
	}
	
	/**
	 * Column Info
	 * @return xtnPhnNo
	 */
	public String getXtnPhnNo() {
		return this.xtnPhnNo;
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
	 * @return sendType
	 */
	public String getSendType() {
		return this.sendType;
	}
	
	/**
	 * Column Info
	 * @return n2ndStmtCtnt
	 */
	public String getN2ndStmtCtnt() {
		return this.n2ndStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return sendFaxNo
	 */
	public String getSendFaxNo() {
		return this.sendFaxNo;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return sendTypeFax
	 */
	public String getSendTypeFax() {
		return this.sendTypeFax;
	}
	
	/**
	 * Column Info
	 * @return joTmpltNo
	 */
	public String getJoTmpltNo() {
		return this.joTmpltNo;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return jbEngNm
	 */
	public String getJbEngNm() {
		return this.jbEngNm;
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
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return joLtrTmpltSeq
	 */
	public String getJoLtrTmpltSeq() {
		return this.joLtrTmpltSeq;
	}
	
	/**
	 * Column Info
	 * @return tmplparam
	 */
	public String getTmplparam() {
		return this.tmplparam;
	}
	
	/**
	 * Column Info
	 * @return tmplmrd
	 */
	public String getTmplmrd() {
		return this.tmplmrd;
	}
	
	/**
	 * Column Info
	 * @return keys
	 */
	public String getKeys() {
		return this.keys;
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
	 * @return ltrCcRcvrCntcPsonNmCtnt
	 */
	public String getLtrCcRcvrCntcPsonNmCtnt() {
		return this.ltrCcRcvrCntcPsonNmCtnt;
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
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return joCntcFaxNoCtnt
	 */
	public String getJoCntcFaxNoCtnt() {
		return this.joCntcFaxNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return attachYn
	 */
	public String getAttachYn() {
		return this.attachYn;
	}
	
	/**
	 * Column Info
	 * @return sendTypeMail
	 */
	public String getSendTypeMail() {
		return this.sendTypeMail;
	}
	
	/**
	 * Column Info
	 * @return joTmpltNoSeq
	 */
	public String getJoTmpltNoSeq() {
		return this.joTmpltNoSeq;
	}
	

	/**
	 * Column Info
	 * @param ccRcvrEmlCtnt
	 */
	public void setCcRcvrEmlCtnt(String ccRcvrEmlCtnt) {
		this.ccRcvrEmlCtnt = ccRcvrEmlCtnt;
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
	 * @param n3rdStmtCtnt
	 */
	public void setN3rdStmtCtnt(String n3rdStmtCtnt) {
		this.n3rdStmtCtnt = n3rdStmtCtnt;
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
	 * @param joLtrStlSeq
	 */
	public void setJoLtrStlSeq(String joLtrStlSeq) {
		this.joLtrStlSeq = joLtrStlSeq;
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
	 * @param joBalAmt
	 */
	public void setJoBalAmt(String joBalAmt) {
		this.joBalAmt = joBalAmt;
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
	 * @param ttlStlAmt
	 */
	public void setTtlStlAmt(String ttlStlAmt) {
		this.ttlStlAmt = ttlStlAmt;
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
	 * @param greeting
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
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
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
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
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
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
	 * @param jointOperationLetterTemplat
	 */
	public void setJointOperationLetterTemplat(String jointOperationLetterTemplat) {
		this.jointOperationLetterTemplat = jointOperationLetterTemplat;
	}
	
	/**
	 * Column Info
	 * @param letterNo
	 */
	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
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
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
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
	 * @param ltrRcvrCntcPsonNm
	 */
	public void setLtrRcvrCntcPsonNm(String ltrRcvrCntcPsonNm) {
		this.ltrRcvrCntcPsonNm = ltrRcvrCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	/**
	 * Column Info
	 * @param xtnPhnNo
	 */
	public void setXtnPhnNo(String xtnPhnNo) {
		this.xtnPhnNo = xtnPhnNo;
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
	 * @param sendType
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	/**
	 * Column Info
	 * @param n2ndStmtCtnt
	 */
	public void setN2ndStmtCtnt(String n2ndStmtCtnt) {
		this.n2ndStmtCtnt = n2ndStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param sendFaxNo
	 */
	public void setSendFaxNo(String sendFaxNo) {
		this.sendFaxNo = sendFaxNo;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param sendTypeFax
	 */
	public void setSendTypeFax(String sendTypeFax) {
		this.sendTypeFax = sendTypeFax;
	}
	
	/**
	 * Column Info
	 * @param joTmpltNo
	 */
	public void setJoTmpltNo(String joTmpltNo) {
		this.joTmpltNo = joTmpltNo;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param jbEngNm
	 */
	public void setJbEngNm(String jbEngNm) {
		this.jbEngNm = jbEngNm;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param joLtrTmpltSeq
	 */
	public void setJoLtrTmpltSeq(String joLtrTmpltSeq) {
		this.joLtrTmpltSeq = joLtrTmpltSeq;
	}
	
	/**
	 * Column Info
	 * @param tmplparam
	 */
	public void setTmplparam(String tmplparam) {
		this.tmplparam = tmplparam;
	}
	
	/**
	 * Column Info
	 * @param tmplmrd
	 */
	public void setTmplmrd(String tmplmrd) {
		this.tmplmrd = tmplmrd;
	}
	
	/**
	 * Column Info
	 * @param keys
	 */
	public void setKeys(String keys) {
		this.keys = keys;
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
	 * @param ltrCcRcvrCntcPsonNmCtnt
	 */
	public void setLtrCcRcvrCntcPsonNmCtnt(String ltrCcRcvrCntcPsonNmCtnt) {
		this.ltrCcRcvrCntcPsonNmCtnt = ltrCcRcvrCntcPsonNmCtnt;
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
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param joCntcFaxNoCtnt
	 */
	public void setJoCntcFaxNoCtnt(String joCntcFaxNoCtnt) {
		this.joCntcFaxNoCtnt = joCntcFaxNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param attachYn
	 */
	public void setAttachYn(String attachYn) {
		this.attachYn = attachYn;
	}
	
	/**
	 * Column Info
	 * @param sendTypeMail
	 */
	public void setSendTypeMail(String sendTypeMail) {
		this.sendTypeMail = sendTypeMail;
	}
	
	/**
	 * Column Info
	 * @param joTmpltNoSeq
	 */
	public void setJoTmpltNoSeq(String joTmpltNoSeq) {
		this.joTmpltNoSeq = joTmpltNoSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCcRcvrEmlCtnt(JSPUtil.getParameter(request, "cc_rcvr_eml_ctnt", ""));
		setSndrEml(JSPUtil.getParameter(request, "sndr_eml", ""));
		setN3rdStmtCtnt(JSPUtil.getParameter(request, "n3rd_stmt_ctnt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSigStmtCtnt(JSPUtil.getParameter(request, "sig_stmt_ctnt", ""));
		setJoHjsAmt(JSPUtil.getParameter(request, "jo_hjs_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
		setJoLtrStlSeq(JSPUtil.getParameter(request, "jo_ltr_stl_seq", ""));
		setEmlDt(JSPUtil.getParameter(request, "eml_dt", ""));
		setJoBalAmt(JSPUtil.getParameter(request, "jo_bal_amt", ""));
		setUsrEml(JSPUtil.getParameter(request, "usr_eml", ""));
		setTtlStlAmt(JSPUtil.getParameter(request, "ttl_stl_amt", ""));
		setN1stStmtCtnt(JSPUtil.getParameter(request, "n1st_stmt_ctnt", ""));
		setFaxDt(JSPUtil.getParameter(request, "fax_dt", ""));
		setOfcAddr(JSPUtil.getParameter(request, "ofc_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLtrRcvrCoNm(JSPUtil.getParameter(request, "ltr_rcvr_co_nm", ""));
		setGreeting(JSPUtil.getParameter(request, "greeting", ""));
		setLtrSndrCoNm(JSPUtil.getParameter(request, "ltr_sndr_co_nm", ""));
		setLtrTitCtnt(JSPUtil.getParameter(request, "ltr_tit_ctnt", ""));
		setContent(JSPUtil.getParameter(request, "content", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRcvrEml(JSPUtil.getParameter(request, "rcvr_eml", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setJointOperationLetterTemplat(JSPUtil.getParameter(request, "joint_operation_letter_templat", ""));
		setLetterNo(JSPUtil.getParameter(request, "letter_no", ""));
		setSndrNm(JSPUtil.getParameter(request, "sndr_nm", ""));
		setFaxSndNo(JSPUtil.getParameter(request, "fax_snd_no", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setJoSndMzdCd(JSPUtil.getParameter(request, "jo_snd_mzd_cd", ""));
		setLtrRcvrCntcPsonNm(JSPUtil.getParameter(request, "ltr_rcvr_cntc_pson_nm", ""));
		setSubSysCd(JSPUtil.getParameter(request, "sub_sys_cd", ""));
		setXtnPhnNo(JSPUtil.getParameter(request, "xtn_phn_no", ""));
		setJoLtrNo(JSPUtil.getParameter(request, "jo_ltr_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSendType(JSPUtil.getParameter(request, "send_type", ""));
		setN2ndStmtCtnt(JSPUtil.getParameter(request, "n2nd_stmt_ctnt", ""));
		setSendFaxNo(JSPUtil.getParameter(request, "send_fax_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setSendTypeFax(JSPUtil.getParameter(request, "send_type_fax", ""));
		setJoTmpltNo(JSPUtil.getParameter(request, "jo_tmplt_no", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setJbEngNm(JSPUtil.getParameter(request, "jb_eng_nm", ""));
		setStlRmk(JSPUtil.getParameter(request, "stl_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setJoLtrTmpltSeq(JSPUtil.getParameter(request, "jo_ltr_tmplt_seq", ""));
		setTmplparam(JSPUtil.getParameter(request, "tmplparam", ""));
		setTmplmrd(JSPUtil.getParameter(request, "tmplmrd", ""));
		setKeys(JSPUtil.getParameter(request, "keys", ""));
		setLtrIssDt(JSPUtil.getParameter(request, "ltr_iss_dt", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setEmlSndNo(JSPUtil.getParameter(request, "eml_snd_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBankStmtCtnt(JSPUtil.getParameter(request, "bank_stmt_ctnt", ""));
		setJoLtrTpCd(JSPUtil.getParameter(request, "jo_ltr_tp_cd", ""));
		setLtrCcRcvrCntcPsonNmCtnt(JSPUtil.getParameter(request, "ltr_cc_rcvr_cntc_pson_nm_ctnt", ""));
		setRcvrInfoCtnt(JSPUtil.getParameter(request, "rcvr_info_ctnt", ""));
		setJoPrnrAmt(JSPUtil.getParameter(request, "jo_prnr_amt", ""));
		setJoLtrSeq(JSPUtil.getParameter(request, "jo_ltr_seq", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setJoCntcFaxNoCtnt(JSPUtil.getParameter(request, "jo_cntc_fax_no_ctnt", ""));
		setAttachYn(JSPUtil.getParameter(request, "attach_yn", ""));
		setSendTypeMail(JSPUtil.getParameter(request, "send_type_mail", ""));
		setJoTmpltNoSeq(JSPUtil.getParameter(request, "jo_tmplt_no_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LetterVO[]
	 */
	public LetterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LetterVO[]
	 */
	public LetterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LetterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ccRcvrEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "cc_rcvr_eml_ctnt", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] n3rdStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_stmt_ctnt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] sigStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "sig_stmt_ctnt", length));
			String[] joHjsAmt = (JSPUtil.getParameter(request, prefix	+ "jo_hjs_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "eml_proc_sts_cd", length));
			String[] joLtrStlSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_stl_seq", length));
			String[] emlDt = (JSPUtil.getParameter(request, prefix	+ "eml_dt", length));
			String[] joBalAmt = (JSPUtil.getParameter(request, prefix	+ "jo_bal_amt", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] ttlStlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_stl_amt", length));
			String[] n1stStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n1st_stmt_ctnt", length));
			String[] faxDt = (JSPUtil.getParameter(request, prefix	+ "fax_dt", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ltrRcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "ltr_rcvr_co_nm", length));
			String[] greeting = (JSPUtil.getParameter(request, prefix	+ "greeting", length));
			String[] ltrSndrCoNm = (JSPUtil.getParameter(request, prefix	+ "ltr_sndr_co_nm", length));
			String[] ltrTitCtnt = (JSPUtil.getParameter(request, prefix	+ "ltr_tit_ctnt", length));
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix	+ "fax_proc_sts_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] jointOperationLetterTemplat = (JSPUtil.getParameter(request, prefix	+ "joint_operation_letter_templat", length));
			String[] letterNo = (JSPUtil.getParameter(request, prefix	+ "letter_no", length));
			String[] sndrNm = (JSPUtil.getParameter(request, prefix	+ "sndr_nm", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] joSndMzdCd = (JSPUtil.getParameter(request, prefix	+ "jo_snd_mzd_cd", length));
			String[] ltrRcvrCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ltr_rcvr_cntc_pson_nm", length));
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] xtnPhnNo = (JSPUtil.getParameter(request, prefix	+ "xtn_phn_no", length));
			String[] joLtrNo = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sendType = (JSPUtil.getParameter(request, prefix	+ "send_type", length));
			String[] n2ndStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_stmt_ctnt", length));
			String[] sendFaxNo = (JSPUtil.getParameter(request, prefix	+ "send_fax_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] sendTypeFax = (JSPUtil.getParameter(request, prefix	+ "send_type_fax", length));
			String[] joTmpltNo = (JSPUtil.getParameter(request, prefix	+ "jo_tmplt_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] jbEngNm = (JSPUtil.getParameter(request, prefix	+ "jb_eng_nm", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] joLtrTmpltSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_tmplt_seq", length));
			String[] tmplparam = (JSPUtil.getParameter(request, prefix	+ "tmplparam", length));
			String[] tmplmrd = (JSPUtil.getParameter(request, prefix	+ "tmplmrd", length));
			String[] keys = (JSPUtil.getParameter(request, prefix	+ "keys", length));
			String[] ltrIssDt = (JSPUtil.getParameter(request, prefix	+ "ltr_iss_dt", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bankStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "bank_stmt_ctnt", length));
			String[] joLtrTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_tp_cd", length));
			String[] ltrCcRcvrCntcPsonNmCtnt = (JSPUtil.getParameter(request, prefix	+ "ltr_cc_rcvr_cntc_pson_nm_ctnt", length));
			String[] rcvrInfoCtnt = (JSPUtil.getParameter(request, prefix	+ "rcvr_info_ctnt", length));
			String[] joPrnrAmt = (JSPUtil.getParameter(request, prefix	+ "jo_prnr_amt", length));
			String[] joLtrSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_seq", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] joCntcFaxNoCtnt = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_fax_no_ctnt", length));
			String[] attachYn = (JSPUtil.getParameter(request, prefix	+ "attach_yn", length));
			String[] sendTypeMail = (JSPUtil.getParameter(request, prefix	+ "send_type_mail", length));
			String[] joTmpltNoSeq = (JSPUtil.getParameter(request, prefix	+ "jo_tmplt_no_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new LetterVO();
				if (ccRcvrEmlCtnt[i] != null)
					model.setCcRcvrEmlCtnt(ccRcvrEmlCtnt[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (n3rdStmtCtnt[i] != null)
					model.setN3rdStmtCtnt(n3rdStmtCtnt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
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
				if (joLtrStlSeq[i] != null)
					model.setJoLtrStlSeq(joLtrStlSeq[i]);
				if (emlDt[i] != null)
					model.setEmlDt(emlDt[i]);
				if (joBalAmt[i] != null)
					model.setJoBalAmt(joBalAmt[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (ttlStlAmt[i] != null)
					model.setTtlStlAmt(ttlStlAmt[i]);
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
				if (greeting[i] != null)
					model.setGreeting(greeting[i]);
				if (ltrSndrCoNm[i] != null)
					model.setLtrSndrCoNm(ltrSndrCoNm[i]);
				if (ltrTitCtnt[i] != null)
					model.setLtrTitCtnt(ltrTitCtnt[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (jointOperationLetterTemplat[i] != null)
					model.setJointOperationLetterTemplat(jointOperationLetterTemplat[i]);
				if (letterNo[i] != null)
					model.setLetterNo(letterNo[i]);
				if (sndrNm[i] != null)
					model.setSndrNm(sndrNm[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (joSndMzdCd[i] != null)
					model.setJoSndMzdCd(joSndMzdCd[i]);
				if (ltrRcvrCntcPsonNm[i] != null)
					model.setLtrRcvrCntcPsonNm(ltrRcvrCntcPsonNm[i]);
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (xtnPhnNo[i] != null)
					model.setXtnPhnNo(xtnPhnNo[i]);
				if (joLtrNo[i] != null)
					model.setJoLtrNo(joLtrNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sendType[i] != null)
					model.setSendType(sendType[i]);
				if (n2ndStmtCtnt[i] != null)
					model.setN2ndStmtCtnt(n2ndStmtCtnt[i]);
				if (sendFaxNo[i] != null)
					model.setSendFaxNo(sendFaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (sendTypeFax[i] != null)
					model.setSendTypeFax(sendTypeFax[i]);
				if (joTmpltNo[i] != null)
					model.setJoTmpltNo(joTmpltNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (jbEngNm[i] != null)
					model.setJbEngNm(jbEngNm[i]);
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (joLtrTmpltSeq[i] != null)
					model.setJoLtrTmpltSeq(joLtrTmpltSeq[i]);
				if (tmplparam[i] != null)
					model.setTmplparam(tmplparam[i]);
				if (tmplmrd[i] != null)
					model.setTmplmrd(tmplmrd[i]);
				if (keys[i] != null)
					model.setKeys(keys[i]);
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
				if (ltrCcRcvrCntcPsonNmCtnt[i] != null)
					model.setLtrCcRcvrCntcPsonNmCtnt(ltrCcRcvrCntcPsonNmCtnt[i]);
				if (rcvrInfoCtnt[i] != null)
					model.setRcvrInfoCtnt(rcvrInfoCtnt[i]);
				if (joPrnrAmt[i] != null)
					model.setJoPrnrAmt(joPrnrAmt[i]);
				if (joLtrSeq[i] != null)
					model.setJoLtrSeq(joLtrSeq[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (joCntcFaxNoCtnt[i] != null)
					model.setJoCntcFaxNoCtnt(joCntcFaxNoCtnt[i]);
				if (attachYn[i] != null)
					model.setAttachYn(attachYn[i]);
				if (sendTypeMail[i] != null)
					model.setSendTypeMail(sendTypeMail[i]);
				if (joTmpltNoSeq[i] != null)
					model.setJoTmpltNoSeq(joTmpltNoSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLetterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LetterVO[]
	 */
	public LetterVO[] getLetterVOs(){
		LetterVO[] vos = (LetterVO[])models.toArray(new LetterVO[models.size()]);
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
		this.ccRcvrEmlCtnt = this.ccRcvrEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdStmtCtnt = this.n3rdStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sigStmtCtnt = this.sigStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joHjsAmt = this.joHjsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrStlSeq = this.joLtrStlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDt = this.emlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBalAmt = this.joBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlStlAmt = this.ttlStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stStmtCtnt = this.n1stStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxDt = this.faxDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrRcvrCoNm = this.ltrRcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.greeting = this.greeting .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrSndrCoNm = this.ltrSndrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrTitCtnt = this.ltrTitCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jointOperationLetterTemplat = this.jointOperationLetterTemplat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.letterNo = this.letterNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrNm = this.sndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSndMzdCd = this.joSndMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrRcvrCntcPsonNm = this.ltrRcvrCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtnPhnNo = this.xtnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrNo = this.joLtrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType = this.sendType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndStmtCtnt = this.n2ndStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFaxNo = this.sendFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendTypeFax = this.sendTypeFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTmpltNo = this.joTmpltNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbEngNm = this.jbEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrTmpltSeq = this.joLtrTmpltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplparam = this.tmplparam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplmrd = this.tmplmrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keys = this.keys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrIssDt = this.ltrIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtCtnt = this.bankStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrTpCd = this.joLtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrCcRcvrCntcPsonNmCtnt = this.ltrCcRcvrCntcPsonNmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrInfoCtnt = this.rcvrInfoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrnrAmt = this.joPrnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrSeq = this.joLtrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcFaxNoCtnt = this.joCntcFaxNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachYn = this.attachYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendTypeMail = this.sendTypeMail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTmpltNoSeq = this.joTmpltNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
