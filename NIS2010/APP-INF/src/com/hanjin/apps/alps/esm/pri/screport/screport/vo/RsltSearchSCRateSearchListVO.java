/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltSearchSCRateSearchListVO.java
*@FileTitle : RsltSearchSCRateSearchListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.08
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.08 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCRateSearchListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCRateSearchListVO> models = new ArrayList<RsltSearchSCRateSearchListVO>();
	
	/* Column Info */
	private String destArbAmt = null;
	/* Column Info */
	private String orgViaCd = null;
	/* Column Info */
	private String propScpSrepCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fnlFrcRtAmt = null;
	/* Column Info */
	private String fnlOftRtAmt = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String fnlFrtRt = null;
	/* Column Info */
	private String routViaPortDefCdDest = null;
	/* Column Info */
	private String fnlBucRtAmt = null;
	/* Column Info */
	private String destViaCd = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fnlMqc = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String routViaPortDefCdOri = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prsCrntLodQty = null;
	/* Column Info */
	private String destCd = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String routPntLocDefCdDest = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String dorTrkaAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String chgCdTxt = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String routPntLocDefCdOri = null;
	/* Column Info */
	private String bzcOfrtRtAmt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String fnlPscRtAmt = null;
	/* Column Info */
	private String propScpOfcCd = null;
	/* Column Info */
	private String orgCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCRateSearchListVO() {}

	public RsltSearchSCRateSearchListVO(String ibflag, String pagerows, String scNo, String propNo, String ctrtPtyNm, String fnlMqcQty, String propScpOfcCd, String propScpSrepCd, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String cmdtNm, String actCustNm, String orgCd, String orgViaCd, String destViaCd, String destCd, String chgCd, String chgCdTxt, String ratUtCd, String prcCgoTpCd, String currCd, String fnlFrtRtAmt, String fnlOftRtAmt, String fnlBucRtAmt, String fnlFrcRtAmt, String fnlPscRtAmt, String bzcOfrtRtAmt, String destArbAmt, String dorTrkaAmt, String prsCrntLodQty, String effDt, String expDt, String routPntLocDefCdOri, String routPntLocDefCdDest, String routViaPortDefCdOri, String routViaPortDefCdDest, String prcCtrtCustTpCd, String prcCmdtDefCd, String fnlFrtRt, String fnlMqc) {
		this.destArbAmt = destArbAmt;
		this.orgViaCd = orgViaCd;
		this.propScpSrepCd = propScpSrepCd;
		this.currCd = currCd;
		this.fnlFrcRtAmt = fnlFrcRtAmt;
		this.fnlOftRtAmt = fnlOftRtAmt;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.fnlFrtRt = fnlFrtRt;
		this.routViaPortDefCdDest = routViaPortDefCdDest;
		this.fnlBucRtAmt = fnlBucRtAmt;
		this.destViaCd = destViaCd;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.fnlMqc = fnlMqc;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.routViaPortDefCdOri = routViaPortDefCdOri;
		this.expDt = expDt;
		this.prsCrntLodQty = prsCrntLodQty;
		this.destCd = destCd;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.routPntLocDefCdDest = routPntLocDefCdDest;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.fnlMqcQty = fnlMqcQty;
		this.dorTrkaAmt = dorTrkaAmt;
		this.ratUtCd = ratUtCd;
		this.rtSeq = rtSeq;
		this.cmdtNm = cmdtNm;
		this.routSeq = routSeq;
		this.chgCdTxt = chgCdTxt;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.ctrtPtyNm = ctrtPtyNm;
		this.routPntLocDefCdOri = routPntLocDefCdOri;
		this.bzcOfrtRtAmt = bzcOfrtRtAmt;
		this.propNo = propNo;
		this.actCustNm = actCustNm;
		this.fnlPscRtAmt = fnlPscRtAmt;
		this.propScpOfcCd = propScpOfcCd;
		this.orgCd = orgCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_arb_amt", getDestArbAmt());
		this.hashColumns.put("org_via_cd", getOrgViaCd());
		this.hashColumns.put("prop_scp_srep_cd", getPropScpSrepCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fnl_frc_rt_amt", getFnlFrcRtAmt());
		this.hashColumns.put("fnl_oft_rt_amt", getFnlOftRtAmt());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("fnl_frt_rt", getFnlFrtRt());
		this.hashColumns.put("rout_via_port_def_cd_dest", getRoutViaPortDefCdDest());
		this.hashColumns.put("fnl_buc_rt_amt", getFnlBucRtAmt());
		this.hashColumns.put("dest_via_cd", getDestViaCd());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fnl_mqc", getFnlMqc());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("rout_via_port_def_cd_ori", getRoutViaPortDefCdOri());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prs_crnt_lod_qty", getPrsCrntLodQty());
		this.hashColumns.put("dest_cd", getDestCd());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("rout_pnt_loc_def_cd_dest", getRoutPntLocDefCdDest());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("dor_trka_amt", getDorTrkaAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("chg_cd_txt", getChgCdTxt());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("rout_pnt_loc_def_cd_ori", getRoutPntLocDefCdOri());
		this.hashColumns.put("bzc_ofrt_rt_amt", getBzcOfrtRtAmt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("fnl_psc_rt_amt", getFnlPscRtAmt());
		this.hashColumns.put("prop_scp_ofc_cd", getPropScpOfcCd());
		this.hashColumns.put("org_cd", getOrgCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_arb_amt", "destArbAmt");
		this.hashFields.put("org_via_cd", "orgViaCd");
		this.hashFields.put("prop_scp_srep_cd", "propScpSrepCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fnl_frc_rt_amt", "fnlFrcRtAmt");
		this.hashFields.put("fnl_oft_rt_amt", "fnlOftRtAmt");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("fnl_frt_rt", "fnlFrtRt");
		this.hashFields.put("rout_via_port_def_cd_dest", "routViaPortDefCdDest");
		this.hashFields.put("fnl_buc_rt_amt", "fnlBucRtAmt");
		this.hashFields.put("dest_via_cd", "destViaCd");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fnl_mqc", "fnlMqc");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("rout_via_port_def_cd_ori", "routViaPortDefCdOri");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prs_crnt_lod_qty", "prsCrntLodQty");
		this.hashFields.put("dest_cd", "destCd");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("rout_pnt_loc_def_cd_dest", "routPntLocDefCdDest");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("dor_trka_amt", "dorTrkaAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("chg_cd_txt", "chgCdTxt");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("rout_pnt_loc_def_cd_ori", "routPntLocDefCdOri");
		this.hashFields.put("bzc_ofrt_rt_amt", "bzcOfrtRtAmt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("fnl_psc_rt_amt", "fnlPscRtAmt");
		this.hashFields.put("prop_scp_ofc_cd", "propScpOfcCd");
		this.hashFields.put("org_cd", "orgCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destArbAmt
	 */
	public String getDestArbAmt() {
		return this.destArbAmt;
	}
	
	/**
	 * Column Info
	 * @return orgViaCd
	 */
	public String getOrgViaCd() {
		return this.orgViaCd;
	}
	
	/**
	 * Column Info
	 * @return propScpSrepCd
	 */
	public String getPropScpSrepCd() {
		return this.propScpSrepCd;
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
	 * @return fnlFrcRtAmt
	 */
	public String getFnlFrcRtAmt() {
		return this.fnlFrcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return fnlOftRtAmt
	 */
	public String getFnlOftRtAmt() {
		return this.fnlOftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRt
	 */
	public String getFnlFrtRt() {
		return this.fnlFrtRt;
	}
	
	/**
	 * Column Info
	 * @return routViaPortDefCdDest
	 */
	public String getRoutViaPortDefCdDest() {
		return this.routViaPortDefCdDest;
	}
	
	/**
	 * Column Info
	 * @return fnlBucRtAmt
	 */
	public String getFnlBucRtAmt() {
		return this.fnlBucRtAmt;
	}
	
	/**
	 * Column Info
	 * @return destViaCd
	 */
	public String getDestViaCd() {
		return this.destViaCd;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
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
	 * @return fnlMqc
	 */
	public String getFnlMqc() {
		return this.fnlMqc;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return routViaPortDefCdOri
	 */
	public String getRoutViaPortDefCdOri() {
		return this.routViaPortDefCdOri;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return prsCrntLodQty
	 */
	public String getPrsCrntLodQty() {
		return this.prsCrntLodQty;
	}
	
	/**
	 * Column Info
	 * @return destCd
	 */
	public String getDestCd() {
		return this.destCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCdDest
	 */
	public String getRoutPntLocDefCdDest() {
		return this.routPntLocDefCdDest;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @return dorTrkaAmt
	 */
	public String getDorTrkaAmt() {
		return this.dorTrkaAmt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCdTxt
	 */
	public String getChgCdTxt() {
		return this.chgCdTxt;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCdOri
	 */
	public String getRoutPntLocDefCdOri() {
		return this.routPntLocDefCdOri;
	}
	
	/**
	 * Column Info
	 * @return bzcOfrtRtAmt
	 */
	public String getBzcOfrtRtAmt() {
		return this.bzcOfrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return fnlPscRtAmt
	 */
	public String getFnlPscRtAmt() {
		return this.fnlPscRtAmt;
	}
	
	/**
	 * Column Info
	 * @return propScpOfcCd
	 */
	public String getPropScpOfcCd() {
		return this.propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgCd
	 */
	public String getOrgCd() {
		return this.orgCd;
	}
	

	/**
	 * Column Info
	 * @param destArbAmt
	 */
	public void setDestArbAmt(String destArbAmt) {
		this.destArbAmt = destArbAmt;
	}
	
	/**
	 * Column Info
	 * @param orgViaCd
	 */
	public void setOrgViaCd(String orgViaCd) {
		this.orgViaCd = orgViaCd;
	}
	
	/**
	 * Column Info
	 * @param propScpSrepCd
	 */
	public void setPropScpSrepCd(String propScpSrepCd) {
		this.propScpSrepCd = propScpSrepCd;
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
	 * @param fnlFrcRtAmt
	 */
	public void setFnlFrcRtAmt(String fnlFrcRtAmt) {
		this.fnlFrcRtAmt = fnlFrcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param fnlOftRtAmt
	 */
	public void setFnlOftRtAmt(String fnlOftRtAmt) {
		this.fnlOftRtAmt = fnlOftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRt
	 */
	public void setFnlFrtRt(String fnlFrtRt) {
		this.fnlFrtRt = fnlFrtRt;
	}
	
	/**
	 * Column Info
	 * @param routViaPortDefCdDest
	 */
	public void setRoutViaPortDefCdDest(String routViaPortDefCdDest) {
		this.routViaPortDefCdDest = routViaPortDefCdDest;
	}
	
	/**
	 * Column Info
	 * @param fnlBucRtAmt
	 */
	public void setFnlBucRtAmt(String fnlBucRtAmt) {
		this.fnlBucRtAmt = fnlBucRtAmt;
	}
	
	/**
	 * Column Info
	 * @param destViaCd
	 */
	public void setDestViaCd(String destViaCd) {
		this.destViaCd = destViaCd;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
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
	 * @param fnlMqc
	 */
	public void setFnlMqc(String fnlMqc) {
		this.fnlMqc = fnlMqc;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param routViaPortDefCdOri
	 */
	public void setRoutViaPortDefCdOri(String routViaPortDefCdOri) {
		this.routViaPortDefCdOri = routViaPortDefCdOri;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param prsCrntLodQty
	 */
	public void setPrsCrntLodQty(String prsCrntLodQty) {
		this.prsCrntLodQty = prsCrntLodQty;
	}
	
	/**
	 * Column Info
	 * @param destCd
	 */
	public void setDestCd(String destCd) {
		this.destCd = destCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCdDest
	 */
	public void setRoutPntLocDefCdDest(String routPntLocDefCdDest) {
		this.routPntLocDefCdDest = routPntLocDefCdDest;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param dorTrkaAmt
	 */
	public void setDorTrkaAmt(String dorTrkaAmt) {
		this.dorTrkaAmt = dorTrkaAmt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCdTxt
	 */
	public void setChgCdTxt(String chgCdTxt) {
		this.chgCdTxt = chgCdTxt;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCdOri
	 */
	public void setRoutPntLocDefCdOri(String routPntLocDefCdOri) {
		this.routPntLocDefCdOri = routPntLocDefCdOri;
	}
	
	/**
	 * Column Info
	 * @param bzcOfrtRtAmt
	 */
	public void setBzcOfrtRtAmt(String bzcOfrtRtAmt) {
		this.bzcOfrtRtAmt = bzcOfrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param fnlPscRtAmt
	 */
	public void setFnlPscRtAmt(String fnlPscRtAmt) {
		this.fnlPscRtAmt = fnlPscRtAmt;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcCd
	 */
	public void setPropScpOfcCd(String propScpOfcCd) {
		this.propScpOfcCd = propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgCd
	 */
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
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
		setDestArbAmt(JSPUtil.getParameter(request, prefix + "dest_arb_amt", ""));
		setOrgViaCd(JSPUtil.getParameter(request, prefix + "org_via_cd", ""));
		setPropScpSrepCd(JSPUtil.getParameter(request, prefix + "prop_scp_srep_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFnlFrcRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frc_rt_amt", ""));
		setFnlOftRtAmt(JSPUtil.getParameter(request, prefix + "fnl_oft_rt_amt", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFnlFrtRt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt", ""));
		setRoutViaPortDefCdDest(JSPUtil.getParameter(request, prefix + "rout_via_port_def_cd_dest", ""));
		setFnlBucRtAmt(JSPUtil.getParameter(request, prefix + "fnl_buc_rt_amt", ""));
		setDestViaCd(JSPUtil.getParameter(request, prefix + "dest_via_cd", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFnlMqc(JSPUtil.getParameter(request, prefix + "fnl_mqc", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setRoutViaPortDefCdOri(JSPUtil.getParameter(request, prefix + "rout_via_port_def_cd_ori", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPrsCrntLodQty(JSPUtil.getParameter(request, prefix + "prs_crnt_lod_qty", ""));
		setDestCd(JSPUtil.getParameter(request, prefix + "dest_cd", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setRoutPntLocDefCdDest(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd_dest", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, prefix + "fnl_mqc_qty", ""));
		setDorTrkaAmt(JSPUtil.getParameter(request, prefix + "dor_trka_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setChgCdTxt(JSPUtil.getParameter(request, prefix + "chg_cd_txt", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setRoutPntLocDefCdOri(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd_ori", ""));
		setBzcOfrtRtAmt(JSPUtil.getParameter(request, prefix + "bzc_ofrt_rt_amt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setFnlPscRtAmt(JSPUtil.getParameter(request, prefix + "fnl_psc_rt_amt", ""));
		setPropScpOfcCd(JSPUtil.getParameter(request, prefix + "prop_scp_ofc_cd", ""));
		setOrgCd(JSPUtil.getParameter(request, prefix + "org_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCRateSearchListVO[]
	 */
	public RsltSearchSCRateSearchListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCRateSearchListVO[]
	 */
	public RsltSearchSCRateSearchListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCRateSearchListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destArbAmt = (JSPUtil.getParameter(request, prefix	+ "dest_arb_amt", length));
			String[] orgViaCd = (JSPUtil.getParameter(request, prefix	+ "org_via_cd", length));
			String[] propScpSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_srep_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fnlFrcRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frc_rt_amt", length));
			String[] fnlOftRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_oft_rt_amt", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] fnlFrtRt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt", length));
			String[] routViaPortDefCdDest = (JSPUtil.getParameter(request, prefix	+ "rout_via_port_def_cd_dest", length));
			String[] fnlBucRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_buc_rt_amt", length));
			String[] destViaCd = (JSPUtil.getParameter(request, prefix	+ "dest_via_cd", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fnlMqc = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] routViaPortDefCdOri = (JSPUtil.getParameter(request, prefix	+ "rout_via_port_def_cd_ori", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prsCrntLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_lod_qty", length));
			String[] destCd = (JSPUtil.getParameter(request, prefix	+ "dest_cd", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] routPntLocDefCdDest = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd_dest", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] dorTrkaAmt = (JSPUtil.getParameter(request, prefix	+ "dor_trka_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] chgCdTxt = (JSPUtil.getParameter(request, prefix	+ "chg_cd_txt", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] routPntLocDefCdOri = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd_ori", length));
			String[] bzcOfrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_ofrt_rt_amt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] fnlPscRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_psc_rt_amt", length));
			String[] propScpOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_cd", length));
			String[] orgCd = (JSPUtil.getParameter(request, prefix	+ "org_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCRateSearchListVO();
				if (destArbAmt[i] != null)
					model.setDestArbAmt(destArbAmt[i]);
				if (orgViaCd[i] != null)
					model.setOrgViaCd(orgViaCd[i]);
				if (propScpSrepCd[i] != null)
					model.setPropScpSrepCd(propScpSrepCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fnlFrcRtAmt[i] != null)
					model.setFnlFrcRtAmt(fnlFrcRtAmt[i]);
				if (fnlOftRtAmt[i] != null)
					model.setFnlOftRtAmt(fnlOftRtAmt[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (fnlFrtRt[i] != null)
					model.setFnlFrtRt(fnlFrtRt[i]);
				if (routViaPortDefCdDest[i] != null)
					model.setRoutViaPortDefCdDest(routViaPortDefCdDest[i]);
				if (fnlBucRtAmt[i] != null)
					model.setFnlBucRtAmt(fnlBucRtAmt[i]);
				if (destViaCd[i] != null)
					model.setDestViaCd(destViaCd[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fnlMqc[i] != null)
					model.setFnlMqc(fnlMqc[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (routViaPortDefCdOri[i] != null)
					model.setRoutViaPortDefCdOri(routViaPortDefCdOri[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prsCrntLodQty[i] != null)
					model.setPrsCrntLodQty(prsCrntLodQty[i]);
				if (destCd[i] != null)
					model.setDestCd(destCd[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (routPntLocDefCdDest[i] != null)
					model.setRoutPntLocDefCdDest(routPntLocDefCdDest[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (dorTrkaAmt[i] != null)
					model.setDorTrkaAmt(dorTrkaAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (chgCdTxt[i] != null)
					model.setChgCdTxt(chgCdTxt[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (routPntLocDefCdOri[i] != null)
					model.setRoutPntLocDefCdOri(routPntLocDefCdOri[i]);
				if (bzcOfrtRtAmt[i] != null)
					model.setBzcOfrtRtAmt(bzcOfrtRtAmt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (fnlPscRtAmt[i] != null)
					model.setFnlPscRtAmt(fnlPscRtAmt[i]);
				if (propScpOfcCd[i] != null)
					model.setPropScpOfcCd(propScpOfcCd[i]);
				if (orgCd[i] != null)
					model.setOrgCd(orgCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCRateSearchListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCRateSearchListVO[]
	 */
	public RsltSearchSCRateSearchListVO[] getRsltSearchSCRateSearchListVOs(){
		RsltSearchSCRateSearchListVO[] vos = (RsltSearchSCRateSearchListVO[])models.toArray(new RsltSearchSCRateSearchListVO[models.size()]);
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
		this.destArbAmt = this.destArbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaCd = this.orgViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSrepCd = this.propScpSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrcRtAmt = this.fnlFrcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlOftRtAmt = this.fnlOftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRt = this.fnlFrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routViaPortDefCdDest = this.routViaPortDefCdDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBucRtAmt = this.fnlBucRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaCd = this.destViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqc = this.fnlMqc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routViaPortDefCdOri = this.routViaPortDefCdOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntLodQty = this.prsCrntLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCd = this.destCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCdDest = this.routPntLocDefCdDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorTrkaAmt = this.dorTrkaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCdTxt = this.chgCdTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCdOri = this.routPntLocDefCdOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcOfrtRtAmt = this.bzcOfrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlPscRtAmt = this.fnlPscRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcCd = this.propScpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCd = this.orgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
