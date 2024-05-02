/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RsltSearchRFARateSearchListVO.java
*@FileTitle : RsltSearchRFARateSearchListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : Chloe Mijin SEO
*@LastVersion : 1.0
* 2014.04.29 Chloe Mijin SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Chloe Mijin SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchRFARateSearchListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchRFARateSearchListVO> models = new ArrayList<RsltSearchRFARateSearchListVO>();
	
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String propScpSrepCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String destPntLocDefCd = null;
	/* Column Info */
	private String fnlFrtRt = null;
	/* Column Info */
	private String routViaPortDefCdDest = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fnlMqc = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String destViaNm = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String isPrerate = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String routViaPortDefCdOri = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String rateUsd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String prsCrntLodQty = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String rowSubsumGroup = null;
	/* Column Info */
	private String routPntLocDefCdDest = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String fnlBofAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String orgPntLocDefCd = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String rfaCtrtTpCd = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String routPntLocDefCdOri = null;
	/* Column Info */
	private String orgViaNm = null;
	/* Column Info */
	private String subsumGroup = null;
	/* Column Info */
	private String propScpOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltSearchRFARateSearchListVO() {}

	public RsltSearchRFARateSearchListVO(String ibflag, String pagerows, String ctrtCustCntCd, String propScpSrepCd, String currCd, String custNm, String prcCgoTpCd, String svcScpCd, String fnlFrtRt, String destPntLocDefCd, String routViaPortDefCdDest, String chgCd, String fnlFrtRtAmt, String fnlMqc, String rfaNo, String effDt, String destViaNm, String rate, String isPrerate, String rcvDeTermCd, String routViaPortDefCdOri, String expDt, String rateUsd, String custCntCd, String prsCrntLodQty, String prcCmdtDefCd, String ctrtCustSeq, String routPntLocDefCdDest, String rowSubsumGroup, String cmdtHdrSeq, String fnlMqcQty, String ratUtCd, String custSeq, String rtSeq, String cmdtNm, String routSeq, String prcCtrtCustTpCd, String orgPntLocDefCd, String diffAmt, String rfaCtrtTpCd, String routPntLocDefCdOri, String actCustNm, String orgViaNm, String subsumGroup, String propScpOfcCd, String fnlBofAmt) {
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.propScpSrepCd = propScpSrepCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.custNm = custNm;
		this.svcScpCd = svcScpCd;
		this.destPntLocDefCd = destPntLocDefCd;
		this.fnlFrtRt = fnlFrtRt;
		this.routViaPortDefCdDest = routViaPortDefCdDest;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.fnlMqc = fnlMqc;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.destViaNm = destViaNm;
		this.rate = rate;
		this.isPrerate = isPrerate;
		this.rcvDeTermCd = rcvDeTermCd;
		this.routViaPortDefCdOri = routViaPortDefCdOri;
		this.expDt = expDt;
		this.rateUsd = rateUsd;
		this.custCntCd = custCntCd;
		this.prsCrntLodQty = prsCrntLodQty;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.rowSubsumGroup = rowSubsumGroup;
		this.routPntLocDefCdDest = routPntLocDefCdDest;
		this.ctrtCustSeq = ctrtCustSeq;
		this.fnlMqcQty = fnlMqcQty;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.fnlBofAmt = fnlBofAmt;
		this.ratUtCd = ratUtCd;
		this.custSeq = custSeq;
		this.cmdtNm = cmdtNm;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.orgPntLocDefCd = orgPntLocDefCd;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.diffAmt = diffAmt;
		this.rfaCtrtTpCd = rfaCtrtTpCd;
		this.actCustNm = actCustNm;
		this.routPntLocDefCdOri = routPntLocDefCdOri;
		this.orgViaNm = orgViaNm;
		this.subsumGroup = subsumGroup;
		this.propScpOfcCd = propScpOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("prop_scp_srep_cd", getPropScpSrepCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dest_pnt_loc_def_cd", getDestPntLocDefCd());
		this.hashColumns.put("fnl_frt_rt", getFnlFrtRt());
		this.hashColumns.put("rout_via_port_def_cd_dest", getRoutViaPortDefCdDest());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fnl_mqc", getFnlMqc());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("dest_via_nm", getDestViaNm());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("is_prerate", getIsPrerate());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("rout_via_port_def_cd_ori", getRoutViaPortDefCdOri());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("rate_usd", getRateUsd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("prs_crnt_lod_qty", getPrsCrntLodQty());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("row_subsum_group", getRowSubsumGroup());
		this.hashColumns.put("rout_pnt_loc_def_cd_dest", getRoutPntLocDefCdDest());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("fnl_bof_amt", getFnlBofAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("org_pnt_loc_def_cd", getOrgPntLocDefCd());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("rfa_ctrt_tp_cd", getRfaCtrtTpCd());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("rout_pnt_loc_def_cd_ori", getRoutPntLocDefCdOri());
		this.hashColumns.put("org_via_nm", getOrgViaNm());
		this.hashColumns.put("subsum_group", getSubsumGroup());
		this.hashColumns.put("prop_scp_ofc_cd", getPropScpOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("prop_scp_srep_cd", "propScpSrepCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dest_pnt_loc_def_cd", "destPntLocDefCd");
		this.hashFields.put("fnl_frt_rt", "fnlFrtRt");
		this.hashFields.put("rout_via_port_def_cd_dest", "routViaPortDefCdDest");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fnl_mqc", "fnlMqc");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("dest_via_nm", "destViaNm");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("is_prerate", "isPrerate");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("rout_via_port_def_cd_ori", "routViaPortDefCdOri");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("rate_usd", "rateUsd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("prs_crnt_lod_qty", "prsCrntLodQty");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("row_subsum_group", "rowSubsumGroup");
		this.hashFields.put("rout_pnt_loc_def_cd_dest", "routPntLocDefCdDest");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("fnl_bof_amt", "fnlBofAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("org_pnt_loc_def_cd", "orgPntLocDefCd");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("rfa_ctrt_tp_cd", "rfaCtrtTpCd");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("rout_pnt_loc_def_cd_ori", "routPntLocDefCdOri");
		this.hashFields.put("org_via_nm", "orgViaNm");
		this.hashFields.put("subsum_group", "subsumGroup");
		this.hashFields.put("prop_scp_ofc_cd", "propScpOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return destPntLocDefCd
	 */
	public String getDestPntLocDefCd() {
		return this.destPntLocDefCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return destViaNm
	 */
	public String getDestViaNm() {
		return this.destViaNm;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return isPrerate
	 */
	public String getIsPrerate() {
		return this.isPrerate;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return rateUsd
	 */
	public String getRateUsd() {
		return this.rateUsd;
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
	 * @return prsCrntLodQty
	 */
	public String getPrsCrntLodQty() {
		return this.prsCrntLodQty;
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
	 * @return rowSubsumGroup
	 */
	public String getRowSubsumGroup() {
		return this.rowSubsumGroup;
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
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlBofAmt
	 */
	public String getFnlBofAmt() {
		return this.fnlBofAmt;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
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
	 * @return orgPntLocDefCd
	 */
	public String getOrgPntLocDefCd() {
		return this.orgPntLocDefCd;
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
	 * @return diffAmt
	 */
	public String getDiffAmt() {
		return this.diffAmt;
	}
	
	/**
	 * Column Info
	 * @return rfaCtrtTpCd
	 */
	public String getRfaCtrtTpCd() {
		return this.rfaCtrtTpCd;
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
	 * @return routPntLocDefCdOri
	 */
	public String getRoutPntLocDefCdOri() {
		return this.routPntLocDefCdOri;
	}
	
	/**
	 * Column Info
	 * @return orgViaNm
	 */
	public String getOrgViaNm() {
		return this.orgViaNm;
	}
	
	/**
	 * Column Info
	 * @return subsumGroup
	 */
	public String getSubsumGroup() {
		return this.subsumGroup;
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
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param destPntLocDefCd
	 */
	public void setDestPntLocDefCd(String destPntLocDefCd) {
		this.destPntLocDefCd = destPntLocDefCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param destViaNm
	 */
	public void setDestViaNm(String destViaNm) {
		this.destViaNm = destViaNm;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param isPrerate
	 */
	public void setIsPrerate(String isPrerate) {
		this.isPrerate = isPrerate;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * @param rateUsd
	 */
	public void setRateUsd(String rateUsd) {
		this.rateUsd = rateUsd;
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
	 * @param prsCrntLodQty
	 */
	public void setPrsCrntLodQty(String prsCrntLodQty) {
		this.prsCrntLodQty = prsCrntLodQty;
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
	 * @param rowSubsumGroup
	 */
	public void setRowSubsumGroup(String rowSubsumGroup) {
		this.rowSubsumGroup = rowSubsumGroup;
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
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
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
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlBofAmt
	 */
	public void setFnlBofAmt(String fnlBofAmt) {
		this.fnlBofAmt = fnlBofAmt;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
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
	 * @param orgPntLocDefCd
	 */
	public void setOrgPntLocDefCd(String orgPntLocDefCd) {
		this.orgPntLocDefCd = orgPntLocDefCd;
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
	 * @param diffAmt
	 */
	public void setDiffAmt(String diffAmt) {
		this.diffAmt = diffAmt;
	}
	
	/**
	 * Column Info
	 * @param rfaCtrtTpCd
	 */
	public void setRfaCtrtTpCd(String rfaCtrtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
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
	 * @param routPntLocDefCdOri
	 */
	public void setRoutPntLocDefCdOri(String routPntLocDefCdOri) {
		this.routPntLocDefCdOri = routPntLocDefCdOri;
	}
	
	/**
	 * Column Info
	 * @param orgViaNm
	 */
	public void setOrgViaNm(String orgViaNm) {
		this.orgViaNm = orgViaNm;
	}
	
	/**
	 * Column Info
	 * @param subsumGroup
	 */
	public void setSubsumGroup(String subsumGroup) {
		this.subsumGroup = subsumGroup;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcCd
	 */
	public void setPropScpOfcCd(String propScpOfcCd) {
		this.propScpOfcCd = propScpOfcCd;
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
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setPropScpSrepCd(JSPUtil.getParameter(request, prefix + "prop_scp_srep_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDestPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_pnt_loc_def_cd", ""));
		setFnlFrtRt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt", ""));
		setRoutViaPortDefCdDest(JSPUtil.getParameter(request, prefix + "rout_via_port_def_cd_dest", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFnlMqc(JSPUtil.getParameter(request, prefix + "fnl_mqc", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setDestViaNm(JSPUtil.getParameter(request, prefix + "dest_via_nm", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setIsPrerate(JSPUtil.getParameter(request, prefix + "is_prerate", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setRoutViaPortDefCdOri(JSPUtil.getParameter(request, prefix + "rout_via_port_def_cd_ori", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setRateUsd(JSPUtil.getParameter(request, prefix + "rate_usd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPrsCrntLodQty(JSPUtil.getParameter(request, prefix + "prs_crnt_lod_qty", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setRowSubsumGroup(JSPUtil.getParameter(request, prefix + "row_subsum_group", ""));
		setRoutPntLocDefCdDest(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd_dest", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, prefix + "fnl_mqc_qty", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setFnlBofAmt(JSPUtil.getParameter(request, prefix + "fnl_bof_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setOrgPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_pnt_loc_def_cd", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setDiffAmt(JSPUtil.getParameter(request, prefix + "diff_amt", ""));
		setRfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_cd", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setRoutPntLocDefCdOri(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd_ori", ""));
		setOrgViaNm(JSPUtil.getParameter(request, prefix + "org_via_nm", ""));
		setSubsumGroup(JSPUtil.getParameter(request, prefix + "subsum_group", ""));
		setPropScpOfcCd(JSPUtil.getParameter(request, prefix + "prop_scp_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchRFARateSearchListVO[]
	 */
	public RsltSearchRFARateSearchListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchRFARateSearchListVO[]
	 */
	public RsltSearchRFARateSearchListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchRFARateSearchListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] propScpSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_srep_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] destPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_pnt_loc_def_cd", length));
			String[] fnlFrtRt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt", length));
			String[] routViaPortDefCdDest = (JSPUtil.getParameter(request, prefix	+ "rout_via_port_def_cd_dest", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fnlMqc = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] destViaNm = (JSPUtil.getParameter(request, prefix	+ "dest_via_nm", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] isPrerate = (JSPUtil.getParameter(request, prefix	+ "is_prerate", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] routViaPortDefCdOri = (JSPUtil.getParameter(request, prefix	+ "rout_via_port_def_cd_ori", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] rateUsd = (JSPUtil.getParameter(request, prefix	+ "rate_usd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] prsCrntLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_lod_qty", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] rowSubsumGroup = (JSPUtil.getParameter(request, prefix	+ "row_subsum_group", length));
			String[] routPntLocDefCdDest = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd_dest", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] fnlBofAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_bof_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] orgPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_pnt_loc_def_cd", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] rfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_cd", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] routPntLocDefCdOri = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd_ori", length));
			String[] orgViaNm = (JSPUtil.getParameter(request, prefix	+ "org_via_nm", length));
			String[] subsumGroup = (JSPUtil.getParameter(request, prefix	+ "subsum_group", length));
			String[] propScpOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchRFARateSearchListVO();
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (propScpSrepCd[i] != null)
					model.setPropScpSrepCd(propScpSrepCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (destPntLocDefCd[i] != null)
					model.setDestPntLocDefCd(destPntLocDefCd[i]);
				if (fnlFrtRt[i] != null)
					model.setFnlFrtRt(fnlFrtRt[i]);
				if (routViaPortDefCdDest[i] != null)
					model.setRoutViaPortDefCdDest(routViaPortDefCdDest[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fnlMqc[i] != null)
					model.setFnlMqc(fnlMqc[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (destViaNm[i] != null)
					model.setDestViaNm(destViaNm[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (isPrerate[i] != null)
					model.setIsPrerate(isPrerate[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (routViaPortDefCdOri[i] != null)
					model.setRoutViaPortDefCdOri(routViaPortDefCdOri[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (rateUsd[i] != null)
					model.setRateUsd(rateUsd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (prsCrntLodQty[i] != null)
					model.setPrsCrntLodQty(prsCrntLodQty[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (rowSubsumGroup[i] != null)
					model.setRowSubsumGroup(rowSubsumGroup[i]);
				if (routPntLocDefCdDest[i] != null)
					model.setRoutPntLocDefCdDest(routPntLocDefCdDest[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (fnlBofAmt[i] != null)
					model.setFnlBofAmt(fnlBofAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (orgPntLocDefCd[i] != null)
					model.setOrgPntLocDefCd(orgPntLocDefCd[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (rfaCtrtTpCd[i] != null)
					model.setRfaCtrtTpCd(rfaCtrtTpCd[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (routPntLocDefCdOri[i] != null)
					model.setRoutPntLocDefCdOri(routPntLocDefCdOri[i]);
				if (orgViaNm[i] != null)
					model.setOrgViaNm(orgViaNm[i]);
				if (subsumGroup[i] != null)
					model.setSubsumGroup(subsumGroup[i]);
				if (propScpOfcCd[i] != null)
					model.setPropScpOfcCd(propScpOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchRFARateSearchListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchRFARateSearchListVO[]
	 */
	public RsltSearchRFARateSearchListVO[] getRsltSearchRFARateSearchListVOs(){
		RsltSearchRFARateSearchListVO[] vos = (RsltSearchRFARateSearchListVO[])models.toArray(new RsltSearchRFARateSearchListVO[models.size()]);
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
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSrepCd = this.propScpSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPntLocDefCd = this.destPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRt = this.fnlFrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routViaPortDefCdDest = this.routViaPortDefCdDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqc = this.fnlMqc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaNm = this.destViaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isPrerate = this.isPrerate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routViaPortDefCdOri = this.routViaPortDefCdOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateUsd = this.rateUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntLodQty = this.prsCrntLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSubsumGroup = this.rowSubsumGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCdDest = this.routPntLocDefCdDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBofAmt = this.fnlBofAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPntLocDefCd = this.orgPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCtrtTpCd = this.rfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCdOri = this.routPntLocDefCdOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaNm = this.orgViaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsumGroup = this.subsumGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcCd = this.propScpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
