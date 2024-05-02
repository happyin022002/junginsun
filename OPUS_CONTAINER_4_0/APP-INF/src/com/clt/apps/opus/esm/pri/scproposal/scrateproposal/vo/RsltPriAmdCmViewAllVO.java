/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriAmdCmViewAllVO.java
*@FileTitle : RsltPriAmdCmViewAllVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.24 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class RsltPriAmdCmViewAllVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriAmdCmViewAllVO> models = new ArrayList<RsltPriAmdCmViewAllVO>();
	
	/* Column Info */
	private String dstRoutPntLocDefCd = null;
	/* Column Info */
	private String crntCm = null;
	/* Column Info */
	private String rateType = null;
	/* Column Info */
	private String prsRmnRespbCmpbAmt = null;
	/* Column Info */
	private String crntShare = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String prsCrntRespbOpbAmt = null;
	/* Column Info */
	private String dstRoutViaPortDefCd = null;
	/* Column Info */
	private String pfmcUnit = null;
	/* Column Info */
	private String sumShare = null;
	/* Column Info */
	private String oriRoutViaPortDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prsRatUtCd = null;
	/* Column Info */
	private String sumOp = null;
	/* Column Info */
	private String sumCm = null;
	/* Column Info */
	private String oriRoutPntLocDefCd = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String rmnCm = null;
	/* Column Info */
	private String prsCrntLodQty = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String rmnOp = null;
	/* Column Info */
	private String prsSumOpbAmt = null;
	/* Column Info */
	private String gRateType = null;
	/* Column Info */
	private String prsSumCmpbAmt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String crntOp = null;
	/* Column Info */
	private String prsRmnRespbOpbAmt = null;
	/* Column Info */
	private String prsSumLodQty = null;
	/* Column Info */
	private String prsRmnLodQty = null;
	/* Column Info */
	private String prsCrntRespbCmpbAmt = null;
	/* Column Info */
	private String oriPrsRmnLodQty = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String sRateType = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String rmnShare = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriAmdCmViewAllVO() {}

	public RsltPriAmdCmViewAllVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String routSeq, String prcCmdtDefCd, String oriRoutPntLocDefCd, String dstRoutPntLocDefCd, String oriRoutViaPortDefCd, String dstRoutViaPortDefCd, String prsCrntLodQty, String crntShare, String prsCrntRespbCmpbAmt, String crntCm, String prsRmnLodQty, String rmnShare, String prsRmnRespbCmpbAmt, String rmnCm, String prsCrntRespbOpbAmt, String crntOp, String prsRmnRespbOpbAmt, String rmnOp, String gRateType, String sRateType, String prsSumLodQty, String sumShare, String prsSumCmpbAmt, String sumCm, String prsSumOpbAmt, String sumOp, String prsRatUtCd, String cntrSzCd, String oriPrsRmnLodQty, String pfmcUnit, String rateType) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
		this.crntCm = crntCm;
		this.rateType = rateType;
		this.prsRmnRespbCmpbAmt = prsRmnRespbCmpbAmt;
		this.crntShare = crntShare;
		this.amdtSeq = amdtSeq;
		this.cntrSzCd = cntrSzCd;
		this.svcScpCd = svcScpCd;
		this.prsCrntRespbOpbAmt = prsCrntRespbOpbAmt;
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
		this.pfmcUnit = pfmcUnit;
		this.sumShare = sumShare;
		this.oriRoutViaPortDefCd = oriRoutViaPortDefCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.prsRatUtCd = prsRatUtCd;
		this.sumOp = sumOp;
		this.sumCm = sumCm;
		this.oriRoutPntLocDefCd = oriRoutPntLocDefCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.rmnCm = rmnCm;
		this.prsCrntLodQty = prsCrntLodQty;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.rmnOp = rmnOp;
		this.prsSumOpbAmt = prsSumOpbAmt;
		this.gRateType = gRateType;
		this.prsSumCmpbAmt = prsSumCmpbAmt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.crntOp = crntOp;
		this.prsRmnRespbOpbAmt = prsRmnRespbOpbAmt;
		this.prsSumLodQty = prsSumLodQty;
		this.prsRmnLodQty = prsRmnLodQty;
		this.prsCrntRespbCmpbAmt = prsCrntRespbCmpbAmt;
		this.oriPrsRmnLodQty = oriPrsRmnLodQty;
		this.routSeq = routSeq;
		this.sRateType = sRateType;
		this.propNo = propNo;
		this.rmnShare = rmnShare;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dst_rout_pnt_loc_def_cd", getDstRoutPntLocDefCd());
		this.hashColumns.put("crnt_cm", getCrntCm());
		this.hashColumns.put("rate_type", getRateType());
		this.hashColumns.put("prs_rmn_respb_cmpb_amt", getPrsRmnRespbCmpbAmt());
		this.hashColumns.put("crnt_share", getCrntShare());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prs_crnt_respb_opb_amt", getPrsCrntRespbOpbAmt());
		this.hashColumns.put("dst_rout_via_port_def_cd", getDstRoutViaPortDefCd());
		this.hashColumns.put("pfmc_unit", getPfmcUnit());
		this.hashColumns.put("sum_share", getSumShare());
		this.hashColumns.put("ori_rout_via_port_def_cd", getOriRoutViaPortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prs_rat_ut_cd", getPrsRatUtCd());
		this.hashColumns.put("sum_op", getSumOp());
		this.hashColumns.put("sum_cm", getSumCm());
		this.hashColumns.put("ori_rout_pnt_loc_def_cd", getOriRoutPntLocDefCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("rmn_cm", getRmnCm());
		this.hashColumns.put("prs_crnt_lod_qty", getPrsCrntLodQty());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("rmn_op", getRmnOp());
		this.hashColumns.put("prs_sum_opb_amt", getPrsSumOpbAmt());
		this.hashColumns.put("g_rate_type", getGRateType());
		this.hashColumns.put("prs_sum_cmpb_amt", getPrsSumCmpbAmt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("crnt_op", getCrntOp());
		this.hashColumns.put("prs_rmn_respb_opb_amt", getPrsRmnRespbOpbAmt());
		this.hashColumns.put("prs_sum_lod_qty", getPrsSumLodQty());
		this.hashColumns.put("prs_rmn_lod_qty", getPrsRmnLodQty());
		this.hashColumns.put("prs_crnt_respb_cmpb_amt", getPrsCrntRespbCmpbAmt());
		this.hashColumns.put("ori_prs_rmn_lod_qty", getOriPrsRmnLodQty());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("s_rate_type", getSRateType());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("rmn_share", getRmnShare());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dst_rout_pnt_loc_def_cd", "dstRoutPntLocDefCd");
		this.hashFields.put("crnt_cm", "crntCm");
		this.hashFields.put("rate_type", "rateType");
		this.hashFields.put("prs_rmn_respb_cmpb_amt", "prsRmnRespbCmpbAmt");
		this.hashFields.put("crnt_share", "crntShare");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prs_crnt_respb_opb_amt", "prsCrntRespbOpbAmt");
		this.hashFields.put("dst_rout_via_port_def_cd", "dstRoutViaPortDefCd");
		this.hashFields.put("pfmc_unit", "pfmcUnit");
		this.hashFields.put("sum_share", "sumShare");
		this.hashFields.put("ori_rout_via_port_def_cd", "oriRoutViaPortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prs_rat_ut_cd", "prsRatUtCd");
		this.hashFields.put("sum_op", "sumOp");
		this.hashFields.put("sum_cm", "sumCm");
		this.hashFields.put("ori_rout_pnt_loc_def_cd", "oriRoutPntLocDefCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("rmn_cm", "rmnCm");
		this.hashFields.put("prs_crnt_lod_qty", "prsCrntLodQty");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("rmn_op", "rmnOp");
		this.hashFields.put("prs_sum_opb_amt", "prsSumOpbAmt");
		this.hashFields.put("g_rate_type", "gRateType");
		this.hashFields.put("prs_sum_cmpb_amt", "prsSumCmpbAmt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("crnt_op", "crntOp");
		this.hashFields.put("prs_rmn_respb_opb_amt", "prsRmnRespbOpbAmt");
		this.hashFields.put("prs_sum_lod_qty", "prsSumLodQty");
		this.hashFields.put("prs_rmn_lod_qty", "prsRmnLodQty");
		this.hashFields.put("prs_crnt_respb_cmpb_amt", "prsCrntRespbCmpbAmt");
		this.hashFields.put("ori_prs_rmn_lod_qty", "oriPrsRmnLodQty");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("s_rate_type", "sRateType");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("rmn_share", "rmnShare");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dstRoutPntLocDefCd
	 */
	public String getDstRoutPntLocDefCd() {
		return this.dstRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return crntCm
	 */
	public String getCrntCm() {
		return this.crntCm;
	}
	
	/**
	 * Column Info
	 * @return rateType
	 */
	public String getRateType() {
		return this.rateType;
	}
	
	/**
	 * Column Info
	 * @return prsRmnRespbCmpbAmt
	 */
	public String getPrsRmnRespbCmpbAmt() {
		return this.prsRmnRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return crntShare
	 */
	public String getCrntShare() {
		return this.crntShare;
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
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
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
	 * @return prsCrntRespbOpbAmt
	 */
	public String getPrsCrntRespbOpbAmt() {
		return this.prsCrntRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return dstRoutViaPortDefCd
	 */
	public String getDstRoutViaPortDefCd() {
		return this.dstRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return pfmcUnit
	 */
	public String getPfmcUnit() {
		return this.pfmcUnit;
	}
	
	/**
	 * Column Info
	 * @return sumShare
	 */
	public String getSumShare() {
		return this.sumShare;
	}
	
	/**
	 * Column Info
	 * @return oriRoutViaPortDefCd
	 */
	public String getOriRoutViaPortDefCd() {
		return this.oriRoutViaPortDefCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return prsRatUtCd
	 */
	public String getPrsRatUtCd() {
		return this.prsRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return sumOp
	 */
	public String getSumOp() {
		return this.sumOp;
	}
	
	/**
	 * Column Info
	 * @return sumCm
	 */
	public String getSumCm() {
		return this.sumCm;
	}
	
	/**
	 * Column Info
	 * @return oriRoutPntLocDefCd
	 */
	public String getOriRoutPntLocDefCd() {
		return this.oriRoutPntLocDefCd;
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
	 * @return rmnCm
	 */
	public String getRmnCm() {
		return this.rmnCm;
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
	 * @return rmnOp
	 */
	public String getRmnOp() {
		return this.rmnOp;
	}
	
	/**
	 * Column Info
	 * @return prsSumOpbAmt
	 */
	public String getPrsSumOpbAmt() {
		return this.prsSumOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return gRateType
	 */
	public String getGRateType() {
		return this.gRateType;
	}
	
	/**
	 * Column Info
	 * @return prsSumCmpbAmt
	 */
	public String getPrsSumCmpbAmt() {
		return this.prsSumCmpbAmt;
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
	 * @return crntOp
	 */
	public String getCrntOp() {
		return this.crntOp;
	}
	
	/**
	 * Column Info
	 * @return prsRmnRespbOpbAmt
	 */
	public String getPrsRmnRespbOpbAmt() {
		return this.prsRmnRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsSumLodQty
	 */
	public String getPrsSumLodQty() {
		return this.prsSumLodQty;
	}
	
	/**
	 * Column Info
	 * @return prsRmnLodQty
	 */
	public String getPrsRmnLodQty() {
		return this.prsRmnLodQty;
	}
	
	/**
	 * Column Info
	 * @return prsCrntRespbCmpbAmt
	 */
	public String getPrsCrntRespbCmpbAmt() {
		return this.prsCrntRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return oriPrsRmnLodQty
	 */
	public String getOriPrsRmnLodQty() {
		return this.oriPrsRmnLodQty;
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
	 * @return sRateType
	 */
	public String getSRateType() {
		return this.sRateType;
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
	 * @return rmnShare
	 */
	public String getRmnShare() {
		return this.rmnShare;
	}
	

	/**
	 * Column Info
	 * @param dstRoutPntLocDefCd
	 */
	public void setDstRoutPntLocDefCd(String dstRoutPntLocDefCd) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param crntCm
	 */
	public void setCrntCm(String crntCm) {
		this.crntCm = crntCm;
	}
	
	/**
	 * Column Info
	 * @param rateType
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	
	/**
	 * Column Info
	 * @param prsRmnRespbCmpbAmt
	 */
	public void setPrsRmnRespbCmpbAmt(String prsRmnRespbCmpbAmt) {
		this.prsRmnRespbCmpbAmt = prsRmnRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param crntShare
	 */
	public void setCrntShare(String crntShare) {
		this.crntShare = crntShare;
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
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
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
	 * @param prsCrntRespbOpbAmt
	 */
	public void setPrsCrntRespbOpbAmt(String prsCrntRespbOpbAmt) {
		this.prsCrntRespbOpbAmt = prsCrntRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param dstRoutViaPortDefCd
	 */
	public void setDstRoutViaPortDefCd(String dstRoutViaPortDefCd) {
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param pfmcUnit
	 */
	public void setPfmcUnit(String pfmcUnit) {
		this.pfmcUnit = pfmcUnit;
	}
	
	/**
	 * Column Info
	 * @param sumShare
	 */
	public void setSumShare(String sumShare) {
		this.sumShare = sumShare;
	}
	
	/**
	 * Column Info
	 * @param oriRoutViaPortDefCd
	 */
	public void setOriRoutViaPortDefCd(String oriRoutViaPortDefCd) {
		this.oriRoutViaPortDefCd = oriRoutViaPortDefCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param prsRatUtCd
	 */
	public void setPrsRatUtCd(String prsRatUtCd) {
		this.prsRatUtCd = prsRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param sumOp
	 */
	public void setSumOp(String sumOp) {
		this.sumOp = sumOp;
	}
	
	/**
	 * Column Info
	 * @param sumCm
	 */
	public void setSumCm(String sumCm) {
		this.sumCm = sumCm;
	}
	
	/**
	 * Column Info
	 * @param oriRoutPntLocDefCd
	 */
	public void setOriRoutPntLocDefCd(String oriRoutPntLocDefCd) {
		this.oriRoutPntLocDefCd = oriRoutPntLocDefCd;
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
	 * @param rmnCm
	 */
	public void setRmnCm(String rmnCm) {
		this.rmnCm = rmnCm;
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
	 * @param rmnOp
	 */
	public void setRmnOp(String rmnOp) {
		this.rmnOp = rmnOp;
	}
	
	/**
	 * Column Info
	 * @param prsSumOpbAmt
	 */
	public void setPrsSumOpbAmt(String prsSumOpbAmt) {
		this.prsSumOpbAmt = prsSumOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param gRateType
	 */
	public void setGRateType(String gRateType) {
		this.gRateType = gRateType;
	}
	
	/**
	 * Column Info
	 * @param prsSumCmpbAmt
	 */
	public void setPrsSumCmpbAmt(String prsSumCmpbAmt) {
		this.prsSumCmpbAmt = prsSumCmpbAmt;
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
	 * @param crntOp
	 */
	public void setCrntOp(String crntOp) {
		this.crntOp = crntOp;
	}
	
	/**
	 * Column Info
	 * @param prsRmnRespbOpbAmt
	 */
	public void setPrsRmnRespbOpbAmt(String prsRmnRespbOpbAmt) {
		this.prsRmnRespbOpbAmt = prsRmnRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsSumLodQty
	 */
	public void setPrsSumLodQty(String prsSumLodQty) {
		this.prsSumLodQty = prsSumLodQty;
	}
	
	/**
	 * Column Info
	 * @param prsRmnLodQty
	 */
	public void setPrsRmnLodQty(String prsRmnLodQty) {
		this.prsRmnLodQty = prsRmnLodQty;
	}
	
	/**
	 * Column Info
	 * @param prsCrntRespbCmpbAmt
	 */
	public void setPrsCrntRespbCmpbAmt(String prsCrntRespbCmpbAmt) {
		this.prsCrntRespbCmpbAmt = prsCrntRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param oriPrsRmnLodQty
	 */
	public void setOriPrsRmnLodQty(String oriPrsRmnLodQty) {
		this.oriPrsRmnLodQty = oriPrsRmnLodQty;
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
	 * @param sRateType
	 */
	public void setSRateType(String sRateType) {
		this.sRateType = sRateType;
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
	 * @param rmnShare
	 */
	public void setRmnShare(String rmnShare) {
		this.rmnShare = rmnShare;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDstRoutPntLocDefCd(JSPUtil.getParameter(request, "dst_rout_pnt_loc_def_cd", ""));
		setCrntCm(JSPUtil.getParameter(request, "crnt_cm", ""));
		setRateType(JSPUtil.getParameter(request, "rate_type", ""));
		setPrsRmnRespbCmpbAmt(JSPUtil.getParameter(request, "prs_rmn_respb_cmpb_amt", ""));
		setCrntShare(JSPUtil.getParameter(request, "crnt_share", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setPrsCrntRespbOpbAmt(JSPUtil.getParameter(request, "prs_crnt_respb_opb_amt", ""));
		setDstRoutViaPortDefCd(JSPUtil.getParameter(request, "dst_rout_via_port_def_cd", ""));
		setPfmcUnit(JSPUtil.getParameter(request, "pfmc_unit", ""));
		setSumShare(JSPUtil.getParameter(request, "sum_share", ""));
		setOriRoutViaPortDefCd(JSPUtil.getParameter(request, "ori_rout_via_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrsRatUtCd(JSPUtil.getParameter(request, "prs_rat_ut_cd", ""));
		setSumOp(JSPUtil.getParameter(request, "sum_op", ""));
		setSumCm(JSPUtil.getParameter(request, "sum_cm", ""));
		setOriRoutPntLocDefCd(JSPUtil.getParameter(request, "ori_rout_pnt_loc_def_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd", ""));
		setRmnCm(JSPUtil.getParameter(request, "rmn_cm", ""));
		setPrsCrntLodQty(JSPUtil.getParameter(request, "prs_crnt_lod_qty", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setRmnOp(JSPUtil.getParameter(request, "rmn_op", ""));
		setPrsSumOpbAmt(JSPUtil.getParameter(request, "prs_sum_opb_amt", ""));
		setGRateType(JSPUtil.getParameter(request, "g_rate_type", ""));
		setPrsSumCmpbAmt(JSPUtil.getParameter(request, "prs_sum_cmpb_amt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setCrntOp(JSPUtil.getParameter(request, "crnt_op", ""));
		setPrsRmnRespbOpbAmt(JSPUtil.getParameter(request, "prs_rmn_respb_opb_amt", ""));
		setPrsSumLodQty(JSPUtil.getParameter(request, "prs_sum_lod_qty", ""));
		setPrsRmnLodQty(JSPUtil.getParameter(request, "prs_rmn_lod_qty", ""));
		setPrsCrntRespbCmpbAmt(JSPUtil.getParameter(request, "prs_crnt_respb_cmpb_amt", ""));
		setOriPrsRmnLodQty(JSPUtil.getParameter(request, "ori_prs_rmn_lod_qty", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setSRateType(JSPUtil.getParameter(request, "s_rate_type", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setRmnShare(JSPUtil.getParameter(request, "rmn_share", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriAmdCmViewAllVO[]
	 */
	public RsltPriAmdCmViewAllVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriAmdCmViewAllVO[]
	 */
	public RsltPriAmdCmViewAllVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriAmdCmViewAllVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dstRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_pnt_loc_def_cd", length));
			String[] crntCm = (JSPUtil.getParameter(request, prefix	+ "crnt_cm", length));
			String[] rateType = (JSPUtil.getParameter(request, prefix	+ "rate_type", length));
			String[] prsRmnRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_rmn_respb_cmpb_amt", length));
			String[] crntShare = (JSPUtil.getParameter(request, prefix	+ "crnt_share", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] prsCrntRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_respb_opb_amt", length));
			String[] dstRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_via_port_def_cd", length));
			String[] pfmcUnit = (JSPUtil.getParameter(request, prefix	+ "pfmc_unit", length));
			String[] sumShare = (JSPUtil.getParameter(request, prefix	+ "sum_share", length));
			String[] oriRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_via_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prsRatUtCd = (JSPUtil.getParameter(request, prefix	+ "prs_rat_ut_cd", length));
			String[] sumOp = (JSPUtil.getParameter(request, prefix	+ "sum_op", length));
			String[] sumCm = (JSPUtil.getParameter(request, prefix	+ "sum_cm", length));
			String[] oriRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_pnt_loc_def_cd", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] rmnCm = (JSPUtil.getParameter(request, prefix	+ "rmn_cm", length));
			String[] prsCrntLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_lod_qty", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] rmnOp = (JSPUtil.getParameter(request, prefix	+ "rmn_op", length));
			String[] prsSumOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_sum_opb_amt", length));
			String[] gRateType = (JSPUtil.getParameter(request, prefix	+ "g_rate_type", length));
			String[] prsSumCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_sum_cmpb_amt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] crntOp = (JSPUtil.getParameter(request, prefix	+ "crnt_op", length));
			String[] prsRmnRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_rmn_respb_opb_amt", length));
			String[] prsSumLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_sum_lod_qty", length));
			String[] prsRmnLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_rmn_lod_qty", length));
			String[] prsCrntRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_crnt_respb_cmpb_amt", length));
			String[] oriPrsRmnLodQty = (JSPUtil.getParameter(request, prefix	+ "ori_prs_rmn_lod_qty", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] sRateType = (JSPUtil.getParameter(request, prefix	+ "s_rate_type", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] rmnShare = (JSPUtil.getParameter(request, prefix	+ "rmn_share", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriAmdCmViewAllVO();
				if (dstRoutPntLocDefCd[i] != null)
					model.setDstRoutPntLocDefCd(dstRoutPntLocDefCd[i]);
				if (crntCm[i] != null)
					model.setCrntCm(crntCm[i]);
				if (rateType[i] != null)
					model.setRateType(rateType[i]);
				if (prsRmnRespbCmpbAmt[i] != null)
					model.setPrsRmnRespbCmpbAmt(prsRmnRespbCmpbAmt[i]);
				if (crntShare[i] != null)
					model.setCrntShare(crntShare[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (prsCrntRespbOpbAmt[i] != null)
					model.setPrsCrntRespbOpbAmt(prsCrntRespbOpbAmt[i]);
				if (dstRoutViaPortDefCd[i] != null)
					model.setDstRoutViaPortDefCd(dstRoutViaPortDefCd[i]);
				if (pfmcUnit[i] != null)
					model.setPfmcUnit(pfmcUnit[i]);
				if (sumShare[i] != null)
					model.setSumShare(sumShare[i]);
				if (oriRoutViaPortDefCd[i] != null)
					model.setOriRoutViaPortDefCd(oriRoutViaPortDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prsRatUtCd[i] != null)
					model.setPrsRatUtCd(prsRatUtCd[i]);
				if (sumOp[i] != null)
					model.setSumOp(sumOp[i]);
				if (sumCm[i] != null)
					model.setSumCm(sumCm[i]);
				if (oriRoutPntLocDefCd[i] != null)
					model.setOriRoutPntLocDefCd(oriRoutPntLocDefCd[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (rmnCm[i] != null)
					model.setRmnCm(rmnCm[i]);
				if (prsCrntLodQty[i] != null)
					model.setPrsCrntLodQty(prsCrntLodQty[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (rmnOp[i] != null)
					model.setRmnOp(rmnOp[i]);
				if (prsSumOpbAmt[i] != null)
					model.setPrsSumOpbAmt(prsSumOpbAmt[i]);
				if (gRateType[i] != null)
					model.setGRateType(gRateType[i]);
				if (prsSumCmpbAmt[i] != null)
					model.setPrsSumCmpbAmt(prsSumCmpbAmt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (crntOp[i] != null)
					model.setCrntOp(crntOp[i]);
				if (prsRmnRespbOpbAmt[i] != null)
					model.setPrsRmnRespbOpbAmt(prsRmnRespbOpbAmt[i]);
				if (prsSumLodQty[i] != null)
					model.setPrsSumLodQty(prsSumLodQty[i]);
				if (prsRmnLodQty[i] != null)
					model.setPrsRmnLodQty(prsRmnLodQty[i]);
				if (prsCrntRespbCmpbAmt[i] != null)
					model.setPrsCrntRespbCmpbAmt(prsCrntRespbCmpbAmt[i]);
				if (oriPrsRmnLodQty[i] != null)
					model.setOriPrsRmnLodQty(oriPrsRmnLodQty[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (sRateType[i] != null)
					model.setSRateType(sRateType[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (rmnShare[i] != null)
					model.setRmnShare(rmnShare[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriAmdCmViewAllVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriAmdCmViewAllVO[]
	 */
	public RsltPriAmdCmViewAllVO[] getRsltPriAmdCmViewAllVOs(){
		RsltPriAmdCmViewAllVO[] vos = (RsltPriAmdCmViewAllVO[])models.toArray(new RsltPriAmdCmViewAllVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.dstRoutPntLocDefCd = this.dstRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCm = this.crntCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateType = this.rateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRmnRespbCmpbAmt = this.prsRmnRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntShare = this.crntShare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntRespbOpbAmt = this.prsCrntRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstRoutViaPortDefCd = this.dstRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcUnit = this.pfmcUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumShare = this.sumShare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutViaPortDefCd = this.oriRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRatUtCd = this.prsRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumOp = this.sumOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCm = this.sumCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutPntLocDefCd = this.oriRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnCm = this.rmnCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntLodQty = this.prsCrntLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnOp = this.rmnOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsSumOpbAmt = this.prsSumOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRateType = this.gRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsSumCmpbAmt = this.prsSumCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntOp = this.crntOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRmnRespbOpbAmt = this.prsRmnRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsSumLodQty = this.prsSumLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRmnLodQty = this.prsRmnLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntRespbCmpbAmt = this.prsCrntRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriPrsRmnLodQty = this.oriPrsRmnLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRateType = this.sRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnShare = this.rmnShare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
