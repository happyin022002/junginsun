/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SarDtrbVO.java
*@FileTitle : SarDtrbVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SarDtrbVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SarDtrbVO> models = new ArrayList<SarDtrbVO>();
	
	/* Column Info */
	private String glInpDrAmt = null;
	/* Column Info */
	private String inpDrAmt = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String glCurrCd = null;
	/* Column Info */
	private String dtrbSrcTblCd = null;
	/* Column Info */
	private String glDtrbSrcTpCd = null;
	/* Column Info */
	private String funcCurrRt = null;
	/* Column Info */
	private String glInpCrAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String recAcctAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adjHisSeq = null;
	/* Column Info */
	private String diffFlg = null;
	/* Column Info */
	private String acctDrAmt = null;
	/* Column Info */
	private String otsHisSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgAdjHisSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String acctCrAmt = null;
	/* Column Info */
	private String dtrbSrcTpCd = null;
	/* Column Info */
	private String glCrsCurrAmt = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String glAcctCrAmt = null;
	/* Column Info */
	private String cdCmbSeq = null;
	/* Column Info */
	private String convXchRtFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String inpCrAmt = null;
	/* Column Info */
	private String orzSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String glAcctDrAmt = null;
	/* Column Info */
	private String glCrsExRate = null;
	/* Column Info */
	private String adjDt = null;
	/* Column Info */
	private String glCrsCurrCd = null;
	/* Column Info */
	private String dtrbSrcSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SarDtrbVO() {}

	public SarDtrbVO(String ibflag, String pagerows, String chgTpCd, String inpDrAmt, String dtrbSrcTblCd, String funcCurrRt, String recAcctAmt, String dpPrcsKnt, String adjHisSeq, String diffFlg, String acctDrAmt, String otsHisSeq, String updUsrId, String orgAdjHisSeq, String custCntCd, String acctCrAmt, String dtrbSrcTpCd, String glCrsCurrAmt, String blCurrCd, String adjAmt, String cdCmbSeq, String convXchRtFlg, String custSeq, String inpCrAmt, String orzSeq, String creUsrId, String glCrsExRate, String glCrsCurrCd, String adjDt, String dtrbSrcSeq, String glCurrCd, String glInpDrAmt, String glInpCrAmt, String glDtrbSrcTpCd, String glAcctDrAmt, String glAcctCrAmt) {
		this.glInpDrAmt = glInpDrAmt;
		this.inpDrAmt = inpDrAmt;
		this.chgTpCd = chgTpCd;
		this.glCurrCd = glCurrCd;
		this.dtrbSrcTblCd = dtrbSrcTblCd;
		this.glDtrbSrcTpCd = glDtrbSrcTpCd;
		this.funcCurrRt = funcCurrRt;
		this.glInpCrAmt = glInpCrAmt;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.recAcctAmt = recAcctAmt;
		this.ibflag = ibflag;
		this.adjHisSeq = adjHisSeq;
		this.diffFlg = diffFlg;
		this.acctDrAmt = acctDrAmt;
		this.otsHisSeq = otsHisSeq;
		this.updUsrId = updUsrId;
		this.orgAdjHisSeq = orgAdjHisSeq;
		this.custCntCd = custCntCd;
		this.acctCrAmt = acctCrAmt;
		this.dtrbSrcTpCd = dtrbSrcTpCd;
		this.glCrsCurrAmt = glCrsCurrAmt;
		this.blCurrCd = blCurrCd;
		this.adjAmt = adjAmt;
		this.glAcctCrAmt = glAcctCrAmt;
		this.cdCmbSeq = cdCmbSeq;
		this.convXchRtFlg = convXchRtFlg;
		this.custSeq = custSeq;
		this.inpCrAmt = inpCrAmt;
		this.orzSeq = orzSeq;
		this.creUsrId = creUsrId;
		this.glAcctDrAmt = glAcctDrAmt;
		this.glCrsExRate = glCrsExRate;
		this.adjDt = adjDt;
		this.glCrsCurrCd = glCrsCurrCd;
		this.dtrbSrcSeq = dtrbSrcSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_inp_dr_amt", getGlInpDrAmt());
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("gl_curr_cd", getGlCurrCd());
		this.hashColumns.put("dtrb_src_tbl_cd", getDtrbSrcTblCd());
		this.hashColumns.put("gl_dtrb_src_tp_cd", getGlDtrbSrcTpCd());
		this.hashColumns.put("func_curr_rt", getFuncCurrRt());
		this.hashColumns.put("gl_inp_cr_amt", getGlInpCrAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("rec_acct_amt", getRecAcctAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adj_his_seq", getAdjHisSeq());
		this.hashColumns.put("diff_flg", getDiffFlg());
		this.hashColumns.put("acct_dr_amt", getAcctDrAmt());
		this.hashColumns.put("ots_his_seq", getOtsHisSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_adj_his_seq", getOrgAdjHisSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("acct_cr_amt", getAcctCrAmt());
		this.hashColumns.put("dtrb_src_tp_cd", getDtrbSrcTpCd());
		this.hashColumns.put("gl_crs_curr_amt", getGlCrsCurrAmt());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("gl_acct_cr_amt", getGlAcctCrAmt());
		this.hashColumns.put("cd_cmb_seq", getCdCmbSeq());
		this.hashColumns.put("conv_xch_rt_flg", getConvXchRtFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());
		this.hashColumns.put("orz_seq", getOrzSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("gl_acct_dr_amt", getGlAcctDrAmt());
		this.hashColumns.put("gl_crs_ex_rate", getGlCrsExRate());
		this.hashColumns.put("adj_dt", getAdjDt());
		this.hashColumns.put("gl_crs_curr_cd", getGlCrsCurrCd());
		this.hashColumns.put("dtrb_src_seq", getDtrbSrcSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gl_inp_dr_amt", "glInpDrAmt");
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("gl_curr_cd", "glCurrCd");
		this.hashFields.put("dtrb_src_tbl_cd", "dtrbSrcTblCd");
		this.hashFields.put("gl_dtrb_src_tp_cd", "glDtrbSrcTpCd");
		this.hashFields.put("func_curr_rt", "funcCurrRt");
		this.hashFields.put("gl_inp_cr_amt", "glInpCrAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("rec_acct_amt", "recAcctAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adj_his_seq", "adjHisSeq");
		this.hashFields.put("diff_flg", "diffFlg");
		this.hashFields.put("acct_dr_amt", "acctDrAmt");
		this.hashFields.put("ots_his_seq", "otsHisSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_adj_his_seq", "orgAdjHisSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("acct_cr_amt", "acctCrAmt");
		this.hashFields.put("dtrb_src_tp_cd", "dtrbSrcTpCd");
		this.hashFields.put("gl_crs_curr_amt", "glCrsCurrAmt");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("gl_acct_cr_amt", "glAcctCrAmt");
		this.hashFields.put("cd_cmb_seq", "cdCmbSeq");
		this.hashFields.put("conv_xch_rt_flg", "convXchRtFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("orz_seq", "orzSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("gl_acct_dr_amt", "glAcctDrAmt");
		this.hashFields.put("gl_crs_ex_rate", "glCrsExRate");
		this.hashFields.put("adj_dt", "adjDt");
		this.hashFields.put("gl_crs_curr_cd", "glCrsCurrCd");
		this.hashFields.put("dtrb_src_seq", "dtrbSrcSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glInpDrAmt
	 */
	public String getGlInpDrAmt() {
		return this.glInpDrAmt;
	}
	
	/**
	 * Column Info
	 * @return inpDrAmt
	 */
	public String getInpDrAmt() {
		return this.inpDrAmt;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
	}
	
	/**
	 * Column Info
	 * @return glCurrCd
	 */
	public String getGlCurrCd() {
		return this.glCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbSrcTblCd
	 */
	public String getDtrbSrcTblCd() {
		return this.dtrbSrcTblCd;
	}
	
	/**
	 * Column Info
	 * @return glDtrbSrcTpCd
	 */
	public String getGlDtrbSrcTpCd() {
		return this.glDtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return funcCurrRt
	 */
	public String getFuncCurrRt() {
		return this.funcCurrRt;
	}
	
	/**
	 * Column Info
	 * @return glInpCrAmt
	 */
	public String getGlInpCrAmt() {
		return this.glInpCrAmt;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return recAcctAmt
	 */
	public String getRecAcctAmt() {
		return this.recAcctAmt;
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
	 * @return adjHisSeq
	 */
	public String getAdjHisSeq() {
		return this.adjHisSeq;
	}
	
	/**
	 * Column Info
	 * @return diffFlg
	 */
	public String getDiffFlg() {
		return this.diffFlg;
	}
	
	/**
	 * Column Info
	 * @return acctDrAmt
	 */
	public String getAcctDrAmt() {
		return this.acctDrAmt;
	}
	
	/**
	 * Column Info
	 * @return otsHisSeq
	 */
	public String getOtsHisSeq() {
		return this.otsHisSeq;
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
	 * @return orgAdjHisSeq
	 */
	public String getOrgAdjHisSeq() {
		return this.orgAdjHisSeq;
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
	 * @return acctCrAmt
	 */
	public String getAcctCrAmt() {
		return this.acctCrAmt;
	}
	
	/**
	 * Column Info
	 * @return dtrbSrcTpCd
	 */
	public String getDtrbSrcTpCd() {
		return this.dtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return glCrsCurrAmt
	 */
	public String getGlCrsCurrAmt() {
		return this.glCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
	}
	
	/**
	 * Column Info
	 * @return glAcctCrAmt
	 */
	public String getGlAcctCrAmt() {
		return this.glAcctCrAmt;
	}
	
	/**
	 * Column Info
	 * @return cdCmbSeq
	 */
	public String getCdCmbSeq() {
		return this.cdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return convXchRtFlg
	 */
	public String getConvXchRtFlg() {
		return this.convXchRtFlg;
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
	 * @return inpCrAmt
	 */
	public String getInpCrAmt() {
		return this.inpCrAmt;
	}
	
	/**
	 * Column Info
	 * @return orzSeq
	 */
	public String getOrzSeq() {
		return this.orzSeq;
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
	 * @return glAcctDrAmt
	 */
	public String getGlAcctDrAmt() {
		return this.glAcctDrAmt;
	}
	
	/**
	 * Column Info
	 * @return glCrsExRate
	 */
	public String getGlCrsExRate() {
		return this.glCrsExRate;
	}
	
	/**
	 * Column Info
	 * @return adjDt
	 */
	public String getAdjDt() {
		return this.adjDt;
	}
	
	/**
	 * Column Info
	 * @return glCrsCurrCd
	 */
	public String getGlCrsCurrCd() {
		return this.glCrsCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbSrcSeq
	 */
	public String getDtrbSrcSeq() {
		return this.dtrbSrcSeq;
	}
	

	/**
	 * Column Info
	 * @param glInpDrAmt
	 */
	public void setGlInpDrAmt(String glInpDrAmt) {
		this.glInpDrAmt = glInpDrAmt;
	}
	
	/**
	 * Column Info
	 * @param inpDrAmt
	 */
	public void setInpDrAmt(String inpDrAmt) {
		this.inpDrAmt = inpDrAmt;
	}
	
	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
	}
	
	/**
	 * Column Info
	 * @param glCurrCd
	 */
	public void setGlCurrCd(String glCurrCd) {
		this.glCurrCd = glCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbSrcTblCd
	 */
	public void setDtrbSrcTblCd(String dtrbSrcTblCd) {
		this.dtrbSrcTblCd = dtrbSrcTblCd;
	}
	
	/**
	 * Column Info
	 * @param glDtrbSrcTpCd
	 */
	public void setGlDtrbSrcTpCd(String glDtrbSrcTpCd) {
		this.glDtrbSrcTpCd = glDtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param funcCurrRt
	 */
	public void setFuncCurrRt(String funcCurrRt) {
		this.funcCurrRt = funcCurrRt;
	}
	
	/**
	 * Column Info
	 * @param glInpCrAmt
	 */
	public void setGlInpCrAmt(String glInpCrAmt) {
		this.glInpCrAmt = glInpCrAmt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param recAcctAmt
	 */
	public void setRecAcctAmt(String recAcctAmt) {
		this.recAcctAmt = recAcctAmt;
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
	 * @param adjHisSeq
	 */
	public void setAdjHisSeq(String adjHisSeq) {
		this.adjHisSeq = adjHisSeq;
	}
	
	/**
	 * Column Info
	 * @param diffFlg
	 */
	public void setDiffFlg(String diffFlg) {
		this.diffFlg = diffFlg;
	}
	
	/**
	 * Column Info
	 * @param acctDrAmt
	 */
	public void setAcctDrAmt(String acctDrAmt) {
		this.acctDrAmt = acctDrAmt;
	}
	
	/**
	 * Column Info
	 * @param otsHisSeq
	 */
	public void setOtsHisSeq(String otsHisSeq) {
		this.otsHisSeq = otsHisSeq;
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
	 * @param orgAdjHisSeq
	 */
	public void setOrgAdjHisSeq(String orgAdjHisSeq) {
		this.orgAdjHisSeq = orgAdjHisSeq;
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
	 * @param acctCrAmt
	 */
	public void setAcctCrAmt(String acctCrAmt) {
		this.acctCrAmt = acctCrAmt;
	}
	
	/**
	 * Column Info
	 * @param dtrbSrcTpCd
	 */
	public void setDtrbSrcTpCd(String dtrbSrcTpCd) {
		this.dtrbSrcTpCd = dtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param glCrsCurrAmt
	 */
	public void setGlCrsCurrAmt(String glCrsCurrAmt) {
		this.glCrsCurrAmt = glCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
	}
	
	/**
	 * Column Info
	 * @param glAcctCrAmt
	 */
	public void setGlAcctCrAmt(String glAcctCrAmt) {
		this.glAcctCrAmt = glAcctCrAmt;
	}
	
	/**
	 * Column Info
	 * @param cdCmbSeq
	 */
	public void setCdCmbSeq(String cdCmbSeq) {
		this.cdCmbSeq = cdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param convXchRtFlg
	 */
	public void setConvXchRtFlg(String convXchRtFlg) {
		this.convXchRtFlg = convXchRtFlg;
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
	 * @param inpCrAmt
	 */
	public void setInpCrAmt(String inpCrAmt) {
		this.inpCrAmt = inpCrAmt;
	}
	
	/**
	 * Column Info
	 * @param orzSeq
	 */
	public void setOrzSeq(String orzSeq) {
		this.orzSeq = orzSeq;
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
	 * @param glAcctDrAmt
	 */
	public void setGlAcctDrAmt(String glAcctDrAmt) {
		this.glAcctDrAmt = glAcctDrAmt;
	}
	
	/**
	 * Column Info
	 * @param glCrsExRate
	 */
	public void setGlCrsExRate(String glCrsExRate) {
		this.glCrsExRate = glCrsExRate;
	}
	
	/**
	 * Column Info
	 * @param adjDt
	 */
	public void setAdjDt(String adjDt) {
		this.adjDt = adjDt;
	}
	
	/**
	 * Column Info
	 * @param glCrsCurrCd
	 */
	public void setGlCrsCurrCd(String glCrsCurrCd) {
		this.glCrsCurrCd = glCrsCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbSrcSeq
	 */
	public void setDtrbSrcSeq(String dtrbSrcSeq) {
		this.dtrbSrcSeq = dtrbSrcSeq;
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
		setGlInpDrAmt(JSPUtil.getParameter(request, prefix + "gl_inp_dr_amt", ""));
		setInpDrAmt(JSPUtil.getParameter(request, prefix + "inp_dr_amt", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setGlCurrCd(JSPUtil.getParameter(request, prefix + "gl_curr_cd", ""));
		setDtrbSrcTblCd(JSPUtil.getParameter(request, prefix + "dtrb_src_tbl_cd", ""));
		setGlDtrbSrcTpCd(JSPUtil.getParameter(request, prefix + "gl_dtrb_src_tp_cd", ""));
		setFuncCurrRt(JSPUtil.getParameter(request, prefix + "func_curr_rt", ""));
		setGlInpCrAmt(JSPUtil.getParameter(request, prefix + "gl_inp_cr_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setRecAcctAmt(JSPUtil.getParameter(request, prefix + "rec_acct_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAdjHisSeq(JSPUtil.getParameter(request, prefix + "adj_his_seq", ""));
		setDiffFlg(JSPUtil.getParameter(request, prefix + "diff_flg", ""));
		setAcctDrAmt(JSPUtil.getParameter(request, prefix + "acct_dr_amt", ""));
		setOtsHisSeq(JSPUtil.getParameter(request, prefix + "ots_his_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOrgAdjHisSeq(JSPUtil.getParameter(request, prefix + "org_adj_his_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setAcctCrAmt(JSPUtil.getParameter(request, prefix + "acct_cr_amt", ""));
		setDtrbSrcTpCd(JSPUtil.getParameter(request, prefix + "dtrb_src_tp_cd", ""));
		setGlCrsCurrAmt(JSPUtil.getParameter(request, prefix + "gl_crs_curr_amt", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setGlAcctCrAmt(JSPUtil.getParameter(request, prefix + "gl_acct_cr_amt", ""));
		setCdCmbSeq(JSPUtil.getParameter(request, prefix + "cd_cmb_seq", ""));
		setConvXchRtFlg(JSPUtil.getParameter(request, prefix + "conv_xch_rt_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setInpCrAmt(JSPUtil.getParameter(request, prefix + "inp_cr_amt", ""));
		setOrzSeq(JSPUtil.getParameter(request, prefix + "orz_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setGlAcctDrAmt(JSPUtil.getParameter(request, prefix + "gl_acct_dr_amt", ""));
		setGlCrsExRate(JSPUtil.getParameter(request, prefix + "gl_crs_ex_rate", ""));
		setAdjDt(JSPUtil.getParameter(request, prefix + "adj_dt", ""));
		setGlCrsCurrCd(JSPUtil.getParameter(request, prefix + "gl_crs_curr_cd", ""));
		setDtrbSrcSeq(JSPUtil.getParameter(request, prefix + "dtrb_src_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SarDtrbVO[]
	 */
	public SarDtrbVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SarDtrbVO[]
	 */
	public SarDtrbVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SarDtrbVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glInpDrAmt = (JSPUtil.getParameter(request, prefix	+ "gl_inp_dr_amt", length));
			String[] inpDrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_dr_amt", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] glCurrCd = (JSPUtil.getParameter(request, prefix	+ "gl_curr_cd", length));
			String[] dtrbSrcTblCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_tbl_cd", length));
			String[] glDtrbSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "gl_dtrb_src_tp_cd", length));
			String[] funcCurrRt = (JSPUtil.getParameter(request, prefix	+ "func_curr_rt", length));
			String[] glInpCrAmt = (JSPUtil.getParameter(request, prefix	+ "gl_inp_cr_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] recAcctAmt = (JSPUtil.getParameter(request, prefix	+ "rec_acct_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adjHisSeq = (JSPUtil.getParameter(request, prefix	+ "adj_his_seq", length));
			String[] diffFlg = (JSPUtil.getParameter(request, prefix	+ "diff_flg", length));
			String[] acctDrAmt = (JSPUtil.getParameter(request, prefix	+ "acct_dr_amt", length));
			String[] otsHisSeq = (JSPUtil.getParameter(request, prefix	+ "ots_his_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgAdjHisSeq = (JSPUtil.getParameter(request, prefix	+ "org_adj_his_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] acctCrAmt = (JSPUtil.getParameter(request, prefix	+ "acct_cr_amt", length));
			String[] dtrbSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_tp_cd", length));
			String[] glCrsCurrAmt = (JSPUtil.getParameter(request, prefix	+ "gl_crs_curr_amt", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] glAcctCrAmt = (JSPUtil.getParameter(request, prefix	+ "gl_acct_cr_amt", length));
			String[] cdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "cd_cmb_seq", length));
			String[] convXchRtFlg = (JSPUtil.getParameter(request, prefix	+ "conv_xch_rt_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] inpCrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_cr_amt", length));
			String[] orzSeq = (JSPUtil.getParameter(request, prefix	+ "orz_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] glAcctDrAmt = (JSPUtil.getParameter(request, prefix	+ "gl_acct_dr_amt", length));
			String[] glCrsExRate = (JSPUtil.getParameter(request, prefix	+ "gl_crs_ex_rate", length));
			String[] adjDt = (JSPUtil.getParameter(request, prefix	+ "adj_dt", length));
			String[] glCrsCurrCd = (JSPUtil.getParameter(request, prefix	+ "gl_crs_curr_cd", length));
			String[] dtrbSrcSeq = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SarDtrbVO();
				if (glInpDrAmt[i] != null)
					model.setGlInpDrAmt(glInpDrAmt[i]);
				if (inpDrAmt[i] != null)
					model.setInpDrAmt(inpDrAmt[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (glCurrCd[i] != null)
					model.setGlCurrCd(glCurrCd[i]);
				if (dtrbSrcTblCd[i] != null)
					model.setDtrbSrcTblCd(dtrbSrcTblCd[i]);
				if (glDtrbSrcTpCd[i] != null)
					model.setGlDtrbSrcTpCd(glDtrbSrcTpCd[i]);
				if (funcCurrRt[i] != null)
					model.setFuncCurrRt(funcCurrRt[i]);
				if (glInpCrAmt[i] != null)
					model.setGlInpCrAmt(glInpCrAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (recAcctAmt[i] != null)
					model.setRecAcctAmt(recAcctAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adjHisSeq[i] != null)
					model.setAdjHisSeq(adjHisSeq[i]);
				if (diffFlg[i] != null)
					model.setDiffFlg(diffFlg[i]);
				if (acctDrAmt[i] != null)
					model.setAcctDrAmt(acctDrAmt[i]);
				if (otsHisSeq[i] != null)
					model.setOtsHisSeq(otsHisSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgAdjHisSeq[i] != null)
					model.setOrgAdjHisSeq(orgAdjHisSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (acctCrAmt[i] != null)
					model.setAcctCrAmt(acctCrAmt[i]);
				if (dtrbSrcTpCd[i] != null)
					model.setDtrbSrcTpCd(dtrbSrcTpCd[i]);
				if (glCrsCurrAmt[i] != null)
					model.setGlCrsCurrAmt(glCrsCurrAmt[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (glAcctCrAmt[i] != null)
					model.setGlAcctCrAmt(glAcctCrAmt[i]);
				if (cdCmbSeq[i] != null)
					model.setCdCmbSeq(cdCmbSeq[i]);
				if (convXchRtFlg[i] != null)
					model.setConvXchRtFlg(convXchRtFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (inpCrAmt[i] != null)
					model.setInpCrAmt(inpCrAmt[i]);
				if (orzSeq[i] != null)
					model.setOrzSeq(orzSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (glAcctDrAmt[i] != null)
					model.setGlAcctDrAmt(glAcctDrAmt[i]);
				if (glCrsExRate[i] != null)
					model.setGlCrsExRate(glCrsExRate[i]);
				if (adjDt[i] != null)
					model.setAdjDt(adjDt[i]);
				if (glCrsCurrCd[i] != null)
					model.setGlCrsCurrCd(glCrsCurrCd[i]);
				if (dtrbSrcSeq[i] != null)
					model.setDtrbSrcSeq(dtrbSrcSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSarDtrbVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SarDtrbVO[]
	 */
	public SarDtrbVO[] getSarDtrbVOs(){
		SarDtrbVO[] vos = (SarDtrbVO[])models.toArray(new SarDtrbVO[models.size()]);
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
		this.glInpDrAmt = this.glInpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDrAmt = this.inpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCurrCd = this.glCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTblCd = this.dtrbSrcTblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDtrbSrcTpCd = this.glDtrbSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCurrRt = this.funcCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glInpCrAmt = this.glInpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recAcctAmt = this.recAcctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjHisSeq = this.adjHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffFlg = this.diffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDrAmt = this.acctDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisSeq = this.otsHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAdjHisSeq = this.orgAdjHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCrAmt = this.acctCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTpCd = this.dtrbSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCrsCurrAmt = this.glCrsCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glAcctCrAmt = this.glAcctCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdCmbSeq = this.cdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRtFlg = this.convXchRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt = this.inpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orzSeq = this.orzSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glAcctDrAmt = this.glAcctDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCrsExRate = this.glCrsExRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjDt = this.adjDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glCrsCurrCd = this.glCrsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcSeq = this.dtrbSrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
