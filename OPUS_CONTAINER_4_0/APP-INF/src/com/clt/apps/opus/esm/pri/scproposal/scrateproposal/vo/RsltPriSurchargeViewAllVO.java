/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriSurchargeViewAllVO.java
*@FileTitle : RsltPriSurchargeViewAllVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.20 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo;

import java.lang.reflect.Field;
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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSurchargeViewAllVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSurchargeViewAllVO> models = new ArrayList<RsltPriSurchargeViewAllVO>();
	
	/* Column Info */
	private String sGenSpclRtTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String griRnoteCtnt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totSurcharge = null;
	/* Column Info */
	private String surchargeCurrCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String rateCurrCd = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String surchargeCnoteCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String creYmd = null;
	/* Column Info */
	private String adjScgUsdAmt = null;
	/* Column Info */
	private String surchargeRnoteCtnt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String othersCnoteCtnt = null;
	/* Column Info */
	private String adjScgAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String bkgRatUtCd = null;
	/* Column Info */
	private String trfScgAmt = null;
	/* Column Info */
	private String orgN1stCmncAmdtSeq = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String demdetCnoteCtnt = null;
	/* Column Info */
	private String othersRnoteCtnt = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String demdetRnoteCtnt = null;
	/* Column Info */
	private String noteDpSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gGenSpclRtTpCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String griCnoteCtnt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSurchargeViewAllVO() {}

	public RsltPriSurchargeViewAllVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String prcCmdtDefNm, String gGenSpclRtTpCd, String sGenSpclRtTpCd, String actCustNm, String orgRoutPntLocDefCd, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String griRnoteCtnt, String surchargeRnoteCtnt, String demdetRnoteCtnt, String othersRnoteCtnt, String griCnoteCtnt, String surchargeCnoteCtnt, String demdetCnoteCtnt, String othersCnoteCtnt, String dirCallFlg, String ratUtCd, String prcCgoTpCd, String rateCurrCd, String frtRtAmt, String porCd, String polCd, String podCd, String delCd, String totSurcharge, String creYmd, String chgCd, String bkgRatUtCd, String surchargeCurrCd, String trfScgAmt, String adjScgAmt, String adjScgUsdAmt, String noteDpSeq, String n1stCmncAmdtSeq, String orgN1stCmncAmdtSeq, String creUsrId, String creDt, String updUsrId, String updDt, String seq) {
		this.sGenSpclRtTpCd = sGenSpclRtTpCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.griRnoteCtnt = griRnoteCtnt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.totSurcharge = totSurcharge;
		this.surchargeCurrCd = surchargeCurrCd;
		this.polCd = polCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.rateCurrCd = rateCurrCd;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.surchargeCnoteCtnt = surchargeCnoteCtnt;
		this.updUsrId = updUsrId;
		this.dirCallFlg = dirCallFlg;
		this.creYmd = creYmd;
		this.adjScgUsdAmt = adjScgUsdAmt;
		this.surchargeRnoteCtnt = surchargeRnoteCtnt;
		this.delCd = delCd;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.ratUtCd = ratUtCd;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.podCd = podCd;
		this.othersCnoteCtnt = othersCnoteCtnt;
		this.adjScgAmt = adjScgAmt;
		this.creUsrId = creUsrId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.bkgRatUtCd = bkgRatUtCd;
		this.trfScgAmt = trfScgAmt;
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
		this.porCd = porCd;
		this.demdetCnoteCtnt = demdetCnoteCtnt;
		this.othersRnoteCtnt = othersRnoteCtnt;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.creDt = creDt;
		this.demdetRnoteCtnt = demdetRnoteCtnt;
		this.noteDpSeq = noteDpSeq;
		this.ibflag = ibflag;
		this.gGenSpclRtTpCd = gGenSpclRtTpCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.updDt = updDt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.griCnoteCtnt = griCnoteCtnt;
		this.propNo = propNo;
		this.actCustNm = actCustNm;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.frtRtAmt = frtRtAmt;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_gen_spcl_rt_tp_cd", getSGenSpclRtTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("gri_rnote_ctnt", getGriRnoteCtnt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot_surcharge", getTotSurcharge());
		this.hashColumns.put("surcharge_curr_cd", getSurchargeCurrCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("rate_curr_cd", getRateCurrCd());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("surcharge_cnote_ctnt", getSurchargeCnoteCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("cre_ymd", getCreYmd());
		this.hashColumns.put("adj_scg_usd_amt", getAdjScgUsdAmt());
		this.hashColumns.put("surcharge_rnote_ctnt", getSurchargeRnoteCtnt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("others_cnote_ctnt", getOthersCnoteCtnt());
		this.hashColumns.put("adj_scg_amt", getAdjScgAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		this.hashColumns.put("trf_scg_amt", getTrfScgAmt());
		this.hashColumns.put("org_n1st_cmnc_amdt_seq", getOrgN1stCmncAmdtSeq());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("demdet_cnote_ctnt", getDemdetCnoteCtnt());
		this.hashColumns.put("others_rnote_ctnt", getOthersRnoteCtnt());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("demdet_rnote_ctnt", getDemdetRnoteCtnt());
		this.hashColumns.put("note_dp_seq", getNoteDpSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("g_gen_spcl_rt_tp_cd", getGGenSpclRtTpCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("gri_cnote_ctnt", getGriCnoteCtnt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_gen_spcl_rt_tp_cd", "sGenSpclRtTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("gri_rnote_ctnt", "griRnoteCtnt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot_surcharge", "totSurcharge");
		this.hashFields.put("surcharge_curr_cd", "surchargeCurrCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("rate_curr_cd", "rateCurrCd");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("surcharge_cnote_ctnt", "surchargeCnoteCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("cre_ymd", "creYmd");
		this.hashFields.put("adj_scg_usd_amt", "adjScgUsdAmt");
		this.hashFields.put("surcharge_rnote_ctnt", "surchargeRnoteCtnt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("others_cnote_ctnt", "othersCnoteCtnt");
		this.hashFields.put("adj_scg_amt", "adjScgAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
		this.hashFields.put("trf_scg_amt", "trfScgAmt");
		this.hashFields.put("org_n1st_cmnc_amdt_seq", "orgN1stCmncAmdtSeq");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("demdet_cnote_ctnt", "demdetCnoteCtnt");
		this.hashFields.put("others_rnote_ctnt", "othersRnoteCtnt");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("demdet_rnote_ctnt", "demdetRnoteCtnt");
		this.hashFields.put("note_dp_seq", "noteDpSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("g_gen_spcl_rt_tp_cd", "gGenSpclRtTpCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("gri_cnote_ctnt", "griCnoteCtnt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sGenSpclRtTpCd
	 */
	public String getSGenSpclRtTpCd() {
		return this.sGenSpclRtTpCd;
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
	 * @return griRnoteCtnt
	 */
	public String getGriRnoteCtnt() {
		return this.griRnoteCtnt;
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
	 * @return totSurcharge
	 */
	public String getTotSurcharge() {
		return this.totSurcharge;
	}
	
	/**
	 * Column Info
	 * @return surchargeCurrCd
	 */
	public String getSurchargeCurrCd() {
		return this.surchargeCurrCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return rateCurrCd
	 */
	public String getRateCurrCd() {
		return this.rateCurrCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return surchargeCnoteCtnt
	 */
	public String getSurchargeCnoteCtnt() {
		return this.surchargeCnoteCtnt;
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
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return creYmd
	 */
	public String getCreYmd() {
		return this.creYmd;
	}
	
	/**
	 * Column Info
	 * @return adjScgUsdAmt
	 */
	public String getAdjScgUsdAmt() {
		return this.adjScgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return surchargeRnoteCtnt
	 */
	public String getSurchargeRnoteCtnt() {
		return this.surchargeRnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return othersCnoteCtnt
	 */
	public String getOthersCnoteCtnt() {
		return this.othersCnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return adjScgAmt
	 */
	public String getAdjScgAmt() {
		return this.adjScgAmt;
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
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgRatUtCd
	 */
	public String getBkgRatUtCd() {
		return this.bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return trfScgAmt
	 */
	public String getTrfScgAmt() {
		return this.trfScgAmt;
	}
	
	/**
	 * Column Info
	 * @return orgN1stCmncAmdtSeq
	 */
	public String getOrgN1stCmncAmdtSeq() {
		return this.orgN1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return demdetCnoteCtnt
	 */
	public String getDemdetCnoteCtnt() {
		return this.demdetCnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return othersRnoteCtnt
	 */
	public String getOthersRnoteCtnt() {
		return this.othersRnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return demdetRnoteCtnt
	 */
	public String getDemdetRnoteCtnt() {
		return this.demdetRnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @return noteDpSeq
	 */
	public String getNoteDpSeq() {
		return this.noteDpSeq;
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
	 * @return gGenSpclRtTpCd
	 */
	public String getGGenSpclRtTpCd() {
		return this.gGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return griCnoteCtnt
	 */
	public String getGriCnoteCtnt() {
		return this.griCnoteCtnt;
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
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	

	/**
	 * Column Info
	 * @param sGenSpclRtTpCd
	 */
	public void setSGenSpclRtTpCd(String sGenSpclRtTpCd) {
		this.sGenSpclRtTpCd = sGenSpclRtTpCd;
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
	 * @param griRnoteCtnt
	 */
	public void setGriRnoteCtnt(String griRnoteCtnt) {
		this.griRnoteCtnt = griRnoteCtnt;
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
	 * @param totSurcharge
	 */
	public void setTotSurcharge(String totSurcharge) {
		this.totSurcharge = totSurcharge;
	}
	
	/**
	 * Column Info
	 * @param surchargeCurrCd
	 */
	public void setSurchargeCurrCd(String surchargeCurrCd) {
		this.surchargeCurrCd = surchargeCurrCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param rateCurrCd
	 */
	public void setRateCurrCd(String rateCurrCd) {
		this.rateCurrCd = rateCurrCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param surchargeCnoteCtnt
	 */
	public void setSurchargeCnoteCtnt(String surchargeCnoteCtnt) {
		this.surchargeCnoteCtnt = surchargeCnoteCtnt;
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
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param creYmd
	 */
	public void setCreYmd(String creYmd) {
		this.creYmd = creYmd;
	}
	
	/**
	 * Column Info
	 * @param adjScgUsdAmt
	 */
	public void setAdjScgUsdAmt(String adjScgUsdAmt) {
		this.adjScgUsdAmt = adjScgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param surchargeRnoteCtnt
	 */
	public void setSurchargeRnoteCtnt(String surchargeRnoteCtnt) {
		this.surchargeRnoteCtnt = surchargeRnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param othersCnoteCtnt
	 */
	public void setOthersCnoteCtnt(String othersCnoteCtnt) {
		this.othersCnoteCtnt = othersCnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param adjScgAmt
	 */
	public void setAdjScgAmt(String adjScgAmt) {
		this.adjScgAmt = adjScgAmt;
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
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgRatUtCd
	 */
	public void setBkgRatUtCd(String bkgRatUtCd) {
		this.bkgRatUtCd = bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param trfScgAmt
	 */
	public void setTrfScgAmt(String trfScgAmt) {
		this.trfScgAmt = trfScgAmt;
	}
	
	/**
	 * Column Info
	 * @param orgN1stCmncAmdtSeq
	 */
	public void setOrgN1stCmncAmdtSeq(String orgN1stCmncAmdtSeq) {
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param demdetCnoteCtnt
	 */
	public void setDemdetCnoteCtnt(String demdetCnoteCtnt) {
		this.demdetCnoteCtnt = demdetCnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param othersRnoteCtnt
	 */
	public void setOthersRnoteCtnt(String othersRnoteCtnt) {
		this.othersRnoteCtnt = othersRnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param demdetRnoteCtnt
	 */
	public void setDemdetRnoteCtnt(String demdetRnoteCtnt) {
		this.demdetRnoteCtnt = demdetRnoteCtnt;
	}
	
	/**
	 * Column Info
	 * @param noteDpSeq
	 */
	public void setNoteDpSeq(String noteDpSeq) {
		this.noteDpSeq = noteDpSeq;
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
	 * @param gGenSpclRtTpCd
	 */
	public void setGGenSpclRtTpCd(String gGenSpclRtTpCd) {
		this.gGenSpclRtTpCd = gGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
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
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param griCnoteCtnt
	 */
	public void setGriCnoteCtnt(String griCnoteCtnt) {
		this.griCnoteCtnt = griCnoteCtnt;
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
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param frtRtAmt
	 */
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setSGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "s_gen_spcl_rt_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setGriRnoteCtnt(JSPUtil.getParameter(request, prefix + "gri_rnote_ctnt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTotSurcharge(JSPUtil.getParameter(request, prefix + "tot_surcharge", ""));
		setSurchargeCurrCd(JSPUtil.getParameter(request, prefix + "surcharge_curr_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setRateCurrCd(JSPUtil.getParameter(request, prefix + "rate_curr_cd", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setSurchargeCnoteCtnt(JSPUtil.getParameter(request, prefix + "surcharge_cnote_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
		setCreYmd(JSPUtil.getParameter(request, prefix + "cre_ymd", ""));
		setAdjScgUsdAmt(JSPUtil.getParameter(request, prefix + "adj_scg_usd_amt", ""));
		setSurchargeRnoteCtnt(JSPUtil.getParameter(request, prefix + "surcharge_rnote_ctnt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOthersCnoteCtnt(JSPUtil.getParameter(request, prefix + "others_cnote_ctnt", ""));
		setAdjScgAmt(JSPUtil.getParameter(request, prefix + "adj_scg_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request, prefix + "bkg_rat_ut_cd", ""));
		setTrfScgAmt(JSPUtil.getParameter(request, prefix + "trf_scg_amt", ""));
		setOrgN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "org_n1st_cmnc_amdt_seq", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDemdetCnoteCtnt(JSPUtil.getParameter(request, prefix + "demdet_cnote_ctnt", ""));
		setOthersRnoteCtnt(JSPUtil.getParameter(request, prefix + "others_rnote_ctnt", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDemdetRnoteCtnt(JSPUtil.getParameter(request, prefix + "demdet_rnote_ctnt", ""));
		setNoteDpSeq(JSPUtil.getParameter(request, prefix + "note_dp_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "g_gen_spcl_rt_tp_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setGriCnoteCtnt(JSPUtil.getParameter(request, prefix + "gri_cnote_ctnt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSurchargeViewAllVO[]
	 */
	public RsltPriSurchargeViewAllVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSurchargeViewAllVO[]
	 */
	public RsltPriSurchargeViewAllVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSurchargeViewAllVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "s_gen_spcl_rt_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] griRnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "gri_rnote_ctnt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totSurcharge = (JSPUtil.getParameter(request, prefix	+ "tot_surcharge", length));
			String[] surchargeCurrCd = (JSPUtil.getParameter(request, prefix	+ "surcharge_curr_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] rateCurrCd = (JSPUtil.getParameter(request, prefix	+ "rate_curr_cd", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] surchargeCnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "surcharge_cnote_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] creYmd = (JSPUtil.getParameter(request, prefix	+ "cre_ymd", length));
			String[] adjScgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "adj_scg_usd_amt", length));
			String[] surchargeRnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "surcharge_rnote_ctnt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] othersCnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "others_cnote_ctnt", length));
			String[] adjScgAmt = (JSPUtil.getParameter(request, prefix	+ "adj_scg_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] bkgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd", length));
			String[] trfScgAmt = (JSPUtil.getParameter(request, prefix	+ "trf_scg_amt", length));
			String[] orgN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "org_n1st_cmnc_amdt_seq", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] demdetCnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "demdet_cnote_ctnt", length));
			String[] othersRnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "others_rnote_ctnt", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] demdetRnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "demdet_rnote_ctnt", length));
			String[] noteDpSeq = (JSPUtil.getParameter(request, prefix	+ "note_dp_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "g_gen_spcl_rt_tp_cd", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] griCnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "gri_cnote_ctnt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSurchargeViewAllVO();
				if (sGenSpclRtTpCd[i] != null)
					model.setSGenSpclRtTpCd(sGenSpclRtTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (griRnoteCtnt[i] != null)
					model.setGriRnoteCtnt(griRnoteCtnt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totSurcharge[i] != null)
					model.setTotSurcharge(totSurcharge[i]);
				if (surchargeCurrCd[i] != null)
					model.setSurchargeCurrCd(surchargeCurrCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (rateCurrCd[i] != null)
					model.setRateCurrCd(rateCurrCd[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (surchargeCnoteCtnt[i] != null)
					model.setSurchargeCnoteCtnt(surchargeCnoteCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (creYmd[i] != null)
					model.setCreYmd(creYmd[i]);
				if (adjScgUsdAmt[i] != null)
					model.setAdjScgUsdAmt(adjScgUsdAmt[i]);
				if (surchargeRnoteCtnt[i] != null)
					model.setSurchargeRnoteCtnt(surchargeRnoteCtnt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (othersCnoteCtnt[i] != null)
					model.setOthersCnoteCtnt(othersCnoteCtnt[i]);
				if (adjScgAmt[i] != null)
					model.setAdjScgAmt(adjScgAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (bkgRatUtCd[i] != null)
					model.setBkgRatUtCd(bkgRatUtCd[i]);
				if (trfScgAmt[i] != null)
					model.setTrfScgAmt(trfScgAmt[i]);
				if (orgN1stCmncAmdtSeq[i] != null)
					model.setOrgN1stCmncAmdtSeq(orgN1stCmncAmdtSeq[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (demdetCnoteCtnt[i] != null)
					model.setDemdetCnoteCtnt(demdetCnoteCtnt[i]);
				if (othersRnoteCtnt[i] != null)
					model.setOthersRnoteCtnt(othersRnoteCtnt[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (demdetRnoteCtnt[i] != null)
					model.setDemdetRnoteCtnt(demdetRnoteCtnt[i]);
				if (noteDpSeq[i] != null)
					model.setNoteDpSeq(noteDpSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gGenSpclRtTpCd[i] != null)
					model.setGGenSpclRtTpCd(gGenSpclRtTpCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (griCnoteCtnt[i] != null)
					model.setGriCnoteCtnt(griCnoteCtnt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSurchargeViewAllVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSurchargeViewAllVO[]
	 */
	public RsltPriSurchargeViewAllVO[] getRsltPriSurchargeViewAllVOs(){
		RsltPriSurchargeViewAllVO[] vos = (RsltPriSurchargeViewAllVO[])models.toArray(new RsltPriSurchargeViewAllVO[models.size()]);
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
		this.sGenSpclRtTpCd = this.sGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griRnoteCtnt = this.griRnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSurcharge = this.totSurcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeCurrCd = this.surchargeCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCurrCd = this.rateCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeCnoteCtnt = this.surchargeCnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creYmd = this.creYmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjScgUsdAmt = this.adjScgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeRnoteCtnt = this.surchargeRnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othersCnoteCtnt = this.othersCnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjScgAmt = this.adjScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd = this.bkgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfScgAmt = this.trfScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgN1stCmncAmdtSeq = this.orgN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demdetCnoteCtnt = this.demdetCnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othersRnoteCtnt = this.othersRnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demdetRnoteCtnt = this.demdetRnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteDpSeq = this.noteDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gGenSpclRtTpCd = this.gGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griCnoteCtnt = this.griCnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
