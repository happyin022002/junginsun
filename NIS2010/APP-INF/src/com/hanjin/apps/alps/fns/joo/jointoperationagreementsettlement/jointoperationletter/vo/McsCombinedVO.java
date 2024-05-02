/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : McsCombinedVO.java
*@FileTitle : McsCombinedVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.18 장강철 
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

public class McsCombinedVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<McsCombinedVO> models = new ArrayList<McsCombinedVO>();
	
	/* Column Info */
	private String joLtrNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ccRcvrEml = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String n3rdStmtCtnt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String sigStmtCtnt = null;
	/* Column Info */
	private String n2ndStmtCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlProcStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ltrCcRcvrCntcPsonNm = null;
	/* Column Info */
	private String emlDt = null;
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
	private String stlRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String joCrrAuthCd = null;
	/* Column Info */
	private String ltrRcvrCoNm = null;
	/* Column Info */
	private String ltrIssDt = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String ltrSndrCoNm = null;
	/* Column Info */
	private String ltrTitCtnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String joCntcFaxNo = null;
	/* Column Info */
	private String joLtrTpCd = null;
	/* Column Info */
	private String rcvrInfoCtnt = null;
	/* Column Info */
	private String joLtrSeq = null;
	/* Column Info */
	private String faxProcStsCd = null;
	/* Column Info */
	private String reDivrCd = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public McsCombinedVO() {}

	public McsCombinedVO(String ibflag, String pagerows, String stlRmk, String ttlAmt, String rlaneCd, String joLtrSeq, String joLtrTpCd, String trdCd, String ofcCd, String ltrIssDt, String ltrRcvrCoNm, String ltrRcvrCntcPsonNm, String ltrCcRcvrCntcPsonNm, String ltrSndrCoNm, String sndrNm, String ltrTitCtnt, String ttlStlAmt, String joSndMzdCd, String joLtrNo, String ofcAddr, String n1stStmtCtnt, String n2ndStmtCtnt, String n3rdStmtCtnt, String sigStmtCtnt, String acctYrmon, String joCrrCd, String reDivrCd, String stlCmbSeq, String sndrEml, String rcvrEml, String ccRcvrEml, String emlProcStsCd, String emlSndNo, String emlDt, String joCntcFaxNo, String rcvrInfoCtnt, String faxProcStsCd, String faxSndNo, String faxDt, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId, String joCrrAuthCd) {
		this.joLtrNo = joLtrNo;
		this.deltFlg = deltFlg;
		this.ccRcvrEml = ccRcvrEml;
		this.creDt = creDt;
		this.sndrEml = sndrEml;
		this.trdCd = trdCd;
		this.n3rdStmtCtnt = n3rdStmtCtnt;
		this.rlaneCd = rlaneCd;
		this.ttlAmt = ttlAmt;
		this.sigStmtCtnt = sigStmtCtnt;
		this.n2ndStmtCtnt = n2ndStmtCtnt;
		this.pagerows = pagerows;
		this.emlProcStsCd = emlProcStsCd;
		this.ibflag = ibflag;
		this.ltrCcRcvrCntcPsonNm = ltrCcRcvrCntcPsonNm;
		this.emlDt = emlDt;
		this.ttlStlAmt = ttlStlAmt;
		this.n1stStmtCtnt = n1stStmtCtnt;
		this.faxDt = faxDt;
		this.ofcAddr = ofcAddr;
		this.updUsrId = updUsrId;
		this.stlRmk = stlRmk;
		this.updDt = updDt;
		this.joCrrAuthCd = joCrrAuthCd;
		this.ltrRcvrCoNm = ltrRcvrCoNm;
		this.ltrIssDt = ltrIssDt;
		this.joCrrCd = joCrrCd;
		this.emlSndNo = emlSndNo;
		this.ltrSndrCoNm = ltrSndrCoNm;
		this.ltrTitCtnt = ltrTitCtnt;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.rcvrEml = rcvrEml;
		this.acctYrmon = acctYrmon;
		this.joCntcFaxNo = joCntcFaxNo;
		this.joLtrTpCd = joLtrTpCd;
		this.rcvrInfoCtnt = rcvrInfoCtnt;
		this.joLtrSeq = joLtrSeq;
		this.faxProcStsCd = faxProcStsCd;
		this.reDivrCd = reDivrCd;
		this.sndrNm = sndrNm;
		this.faxSndNo = faxSndNo;
		this.stlCmbSeq = stlCmbSeq;
		this.joSndMzdCd = joSndMzdCd;
		this.ltrRcvrCntcPsonNm = ltrRcvrCntcPsonNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("jo_ltr_no", getJoLtrNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cc_rcvr_eml", getCcRcvrEml());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("n3rd_stmt_ctnt", getN3rdStmtCtnt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("sig_stmt_ctnt", getSigStmtCtnt());
		this.hashColumns.put("n2nd_stmt_ctnt", getN2ndStmtCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ltr_cc_rcvr_cntc_pson_nm", getLtrCcRcvrCntcPsonNm());
		this.hashColumns.put("eml_dt", getEmlDt());
		this.hashColumns.put("ttl_stl_amt", getTtlStlAmt());
		this.hashColumns.put("n1st_stmt_ctnt", getN1stStmtCtnt());
		this.hashColumns.put("fax_dt", getFaxDt());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stl_rmk", getStlRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jo_crr_auth_cd", getJoCrrAuthCd());
		this.hashColumns.put("ltr_rcvr_co_nm", getLtrRcvrCoNm());
		this.hashColumns.put("ltr_iss_dt", getLtrIssDt());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("ltr_sndr_co_nm", getLtrSndrCoNm());
		this.hashColumns.put("ltr_tit_ctnt", getLtrTitCtnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("jo_cntc_fax_no", getJoCntcFaxNo());
		this.hashColumns.put("jo_ltr_tp_cd", getJoLtrTpCd());
		this.hashColumns.put("rcvr_info_ctnt", getRcvrInfoCtnt());
		this.hashColumns.put("jo_ltr_seq", getJoLtrSeq());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("sndr_nm", getSndrNm());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("jo_snd_mzd_cd", getJoSndMzdCd());
		this.hashColumns.put("ltr_rcvr_cntc_pson_nm", getLtrRcvrCntcPsonNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("jo_ltr_no", "joLtrNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cc_rcvr_eml", "ccRcvrEml");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("n3rd_stmt_ctnt", "n3rdStmtCtnt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("sig_stmt_ctnt", "sigStmtCtnt");
		this.hashFields.put("n2nd_stmt_ctnt", "n2ndStmtCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ltr_cc_rcvr_cntc_pson_nm", "ltrCcRcvrCntcPsonNm");
		this.hashFields.put("eml_dt", "emlDt");
		this.hashFields.put("ttl_stl_amt", "ttlStlAmt");
		this.hashFields.put("n1st_stmt_ctnt", "n1stStmtCtnt");
		this.hashFields.put("fax_dt", "faxDt");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stl_rmk", "stlRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jo_crr_auth_cd", "joCrrAuthCd");
		this.hashFields.put("ltr_rcvr_co_nm", "ltrRcvrCoNm");
		this.hashFields.put("ltr_iss_dt", "ltrIssDt");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("ltr_sndr_co_nm", "ltrSndrCoNm");
		this.hashFields.put("ltr_tit_ctnt", "ltrTitCtnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("jo_cntc_fax_no", "joCntcFaxNo");
		this.hashFields.put("jo_ltr_tp_cd", "joLtrTpCd");
		this.hashFields.put("rcvr_info_ctnt", "rcvrInfoCtnt");
		this.hashFields.put("jo_ltr_seq", "joLtrSeq");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("sndr_nm", "sndrNm");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("jo_snd_mzd_cd", "joSndMzdCd");
		this.hashFields.put("ltr_rcvr_cntc_pson_nm", "ltrRcvrCntcPsonNm");
		return this.hashFields;
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
	 * @return ccRcvrEml
	 */
	public String getCcRcvrEml() {
		return this.ccRcvrEml;
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
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return sigStmtCtnt
	 */
	public String getSigStmtCtnt() {
		return this.sigStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return n2ndStmtCtnt
	 */
	public String getN2ndStmtCtnt() {
		return this.n2ndStmtCtnt;
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
	 * @return joCrrAuthCd
	 */
	public String getJoCrrAuthCd() {
		return this.joCrrAuthCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return joCntcFaxNo
	 */
	public String getJoCntcFaxNo() {
		return this.joCntcFaxNo;
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
	 * @return rcvrInfoCtnt
	 */
	public String getRcvrInfoCtnt() {
		return this.rcvrInfoCtnt;
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
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
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
	 * @param ccRcvrEml
	 */
	public void setCcRcvrEml(String ccRcvrEml) {
		this.ccRcvrEml = ccRcvrEml;
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
	 * @param sndrEml
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param sigStmtCtnt
	 */
	public void setSigStmtCtnt(String sigStmtCtnt) {
		this.sigStmtCtnt = sigStmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param n2ndStmtCtnt
	 */
	public void setN2ndStmtCtnt(String n2ndStmtCtnt) {
		this.n2ndStmtCtnt = n2ndStmtCtnt;
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
	 * @param joCrrAuthCd
	 */
	public void setJoCrrAuthCd(String joCrrAuthCd) {
		this.joCrrAuthCd = joCrrAuthCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param joCntcFaxNo
	 */
	public void setJoCntcFaxNo(String joCntcFaxNo) {
		this.joCntcFaxNo = joCntcFaxNo;
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
	 * @param rcvrInfoCtnt
	 */
	public void setRcvrInfoCtnt(String rcvrInfoCtnt) {
		this.rcvrInfoCtnt = rcvrInfoCtnt;
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
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setJoLtrNo(JSPUtil.getParameter(request, "jo_ltr_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCcRcvrEml(JSPUtil.getParameter(request, "cc_rcvr_eml", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSndrEml(JSPUtil.getParameter(request, "sndr_eml", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setN3rdStmtCtnt(JSPUtil.getParameter(request, "n3rd_stmt_ctnt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setSigStmtCtnt(JSPUtil.getParameter(request, "sig_stmt_ctnt", ""));
		setN2ndStmtCtnt(JSPUtil.getParameter(request, "n2nd_stmt_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLtrCcRcvrCntcPsonNm(JSPUtil.getParameter(request, "ltr_cc_rcvr_cntc_pson_nm", ""));
		setEmlDt(JSPUtil.getParameter(request, "eml_dt", ""));
		setTtlStlAmt(JSPUtil.getParameter(request, "ttl_stl_amt", ""));
		setN1stStmtCtnt(JSPUtil.getParameter(request, "n1st_stmt_ctnt", ""));
		setFaxDt(JSPUtil.getParameter(request, "fax_dt", ""));
		setOfcAddr(JSPUtil.getParameter(request, "ofc_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStlRmk(JSPUtil.getParameter(request, "stl_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setJoCrrAuthCd(JSPUtil.getParameter(request, "jo_crr_auth_cd", ""));
		setLtrRcvrCoNm(JSPUtil.getParameter(request, "ltr_rcvr_co_nm", ""));
		setLtrIssDt(JSPUtil.getParameter(request, "ltr_iss_dt", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setEmlSndNo(JSPUtil.getParameter(request, "eml_snd_no", ""));
		setLtrSndrCoNm(JSPUtil.getParameter(request, "ltr_sndr_co_nm", ""));
		setLtrTitCtnt(JSPUtil.getParameter(request, "ltr_tit_ctnt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRcvrEml(JSPUtil.getParameter(request, "rcvr_eml", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setJoCntcFaxNo(JSPUtil.getParameter(request, "jo_cntc_fax_no", ""));
		setJoLtrTpCd(JSPUtil.getParameter(request, "jo_ltr_tp_cd", ""));
		setRcvrInfoCtnt(JSPUtil.getParameter(request, "rcvr_info_ctnt", ""));
		setJoLtrSeq(JSPUtil.getParameter(request, "jo_ltr_seq", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setSndrNm(JSPUtil.getParameter(request, "sndr_nm", ""));
		setFaxSndNo(JSPUtil.getParameter(request, "fax_snd_no", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setJoSndMzdCd(JSPUtil.getParameter(request, "jo_snd_mzd_cd", ""));
		setLtrRcvrCntcPsonNm(JSPUtil.getParameter(request, "ltr_rcvr_cntc_pson_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return McsCombinedVO[]
	 */
	public McsCombinedVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return McsCombinedVO[]
	 */
	public McsCombinedVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		McsCombinedVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] joLtrNo = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] ccRcvrEml = (JSPUtil.getParameter(request, prefix	+ "cc_rcvr_eml", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] n3rdStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_stmt_ctnt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] sigStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "sig_stmt_ctnt", length));
			String[] n2ndStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_stmt_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "eml_proc_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ltrCcRcvrCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ltr_cc_rcvr_cntc_pson_nm", length));
			String[] emlDt = (JSPUtil.getParameter(request, prefix	+ "eml_dt", length));
			String[] ttlStlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_stl_amt", length));
			String[] n1stStmtCtnt = (JSPUtil.getParameter(request, prefix	+ "n1st_stmt_ctnt", length));
			String[] faxDt = (JSPUtil.getParameter(request, prefix	+ "fax_dt", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] joCrrAuthCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_auth_cd", length));
			String[] ltrRcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "ltr_rcvr_co_nm", length));
			String[] ltrIssDt = (JSPUtil.getParameter(request, prefix	+ "ltr_iss_dt", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] ltrSndrCoNm = (JSPUtil.getParameter(request, prefix	+ "ltr_sndr_co_nm", length));
			String[] ltrTitCtnt = (JSPUtil.getParameter(request, prefix	+ "ltr_tit_ctnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] joCntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_fax_no", length));
			String[] joLtrTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_tp_cd", length));
			String[] rcvrInfoCtnt = (JSPUtil.getParameter(request, prefix	+ "rcvr_info_ctnt", length));
			String[] joLtrSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_seq", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix	+ "fax_proc_sts_cd", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] sndrNm = (JSPUtil.getParameter(request, prefix	+ "sndr_nm", length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] joSndMzdCd = (JSPUtil.getParameter(request, prefix	+ "jo_snd_mzd_cd", length));
			String[] ltrRcvrCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ltr_rcvr_cntc_pson_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new McsCombinedVO();
				if (joLtrNo[i] != null)
					model.setJoLtrNo(joLtrNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ccRcvrEml[i] != null)
					model.setCcRcvrEml(ccRcvrEml[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (n3rdStmtCtnt[i] != null)
					model.setN3rdStmtCtnt(n3rdStmtCtnt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (sigStmtCtnt[i] != null)
					model.setSigStmtCtnt(sigStmtCtnt[i]);
				if (n2ndStmtCtnt[i] != null)
					model.setN2ndStmtCtnt(n2ndStmtCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlProcStsCd[i] != null)
					model.setEmlProcStsCd(emlProcStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ltrCcRcvrCntcPsonNm[i] != null)
					model.setLtrCcRcvrCntcPsonNm(ltrCcRcvrCntcPsonNm[i]);
				if (emlDt[i] != null)
					model.setEmlDt(emlDt[i]);
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
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (joCrrAuthCd[i] != null)
					model.setJoCrrAuthCd(joCrrAuthCd[i]);
				if (ltrRcvrCoNm[i] != null)
					model.setLtrRcvrCoNm(ltrRcvrCoNm[i]);
				if (ltrIssDt[i] != null)
					model.setLtrIssDt(ltrIssDt[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (ltrSndrCoNm[i] != null)
					model.setLtrSndrCoNm(ltrSndrCoNm[i]);
				if (ltrTitCtnt[i] != null)
					model.setLtrTitCtnt(ltrTitCtnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (joCntcFaxNo[i] != null)
					model.setJoCntcFaxNo(joCntcFaxNo[i]);
				if (joLtrTpCd[i] != null)
					model.setJoLtrTpCd(joLtrTpCd[i]);
				if (rcvrInfoCtnt[i] != null)
					model.setRcvrInfoCtnt(rcvrInfoCtnt[i]);
				if (joLtrSeq[i] != null)
					model.setJoLtrSeq(joLtrSeq[i]);
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMcsCombinedVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return McsCombinedVO[]
	 */
	public McsCombinedVO[] getMcsCombinedVOs(){
		McsCombinedVO[] vos = (McsCombinedVO[])models.toArray(new McsCombinedVO[models.size()]);
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
		this.joLtrNo = this.joLtrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccRcvrEml = this.ccRcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdStmtCtnt = this.n3rdStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sigStmtCtnt = this.sigStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndStmtCtnt = this.n2ndStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrCcRcvrCntcPsonNm = this.ltrCcRcvrCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDt = this.emlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlStlAmt = this.ttlStlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stStmtCtnt = this.n1stStmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxDt = this.faxDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrAuthCd = this.joCrrAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrRcvrCoNm = this.ltrRcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrIssDt = this.ltrIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrSndrCoNm = this.ltrSndrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrTitCtnt = this.ltrTitCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcFaxNo = this.joCntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrTpCd = this.joLtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrInfoCtnt = this.rcvrInfoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrSeq = this.joLtrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrNm = this.sndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSndMzdCd = this.joSndMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltrRcvrCntcPsonNm = this.ltrRcvrCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
