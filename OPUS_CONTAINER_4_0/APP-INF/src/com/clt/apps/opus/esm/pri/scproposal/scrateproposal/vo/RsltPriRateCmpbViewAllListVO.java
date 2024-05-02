/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRateCmpbViewAllListVO.java
*@FileTitle : RsltPriRateCmpbViewAllListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.12 송민석 
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

public class RsltPriRateCmpbViewAllListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRateCmpbViewAllListVO> models = new ArrayList<RsltPriRateCmpbViewAllListVO>();
	
	/* Column Info */
	private String dstRoutPntLocDefCd = null;
	/* Column Info */
	private String prsScgAmt = null;
	/* Column Info */
	private String rateType = null;
	/* Column Info */
	private String prsRespbCmUcAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String dstRoutViaPortDefCd = null;
	/* Column Info */
	private String oriRoutViaPortDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oriRoutPntLocDefCd = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String prsRespbOpfitUcAmt = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String gRateType = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String prsRespbCmpbAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String prsGidCmpbAmt = null;
	/* Column Info */
	private String sRateType = null;
	/* Column Info */
	private String prsRespbOpbAmt = null;
	/* Column Info */
	private String propNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRateCmpbViewAllListVO() {}

	public RsltPriRateCmpbViewAllListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String prcCmdtDefCd, String oriRoutPntLocDefCd, String dstRoutPntLocDefCd, String oriRoutViaPortDefCd, String dstRoutViaPortDefCd, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String prsScgAmt, String prsRespbCmUcAmt, String prsRespbCmpbAmt, String prsGidCmpbAmt, String diff, String prsRespbOpfitUcAmt, String prsRespbOpbAmt, String gRateType, String sRateType, String rateType) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
		this.prsScgAmt = prsScgAmt;
		this.rateType = rateType;
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.diff = diff;
		this.svcScpCd = svcScpCd;
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
		this.oriRoutViaPortDefCd = oriRoutViaPortDefCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oriRoutPntLocDefCd = oriRoutPntLocDefCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.gRateType = gRateType;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.prsGidCmpbAmt = prsGidCmpbAmt;
		this.sRateType = sRateType;
		this.prsRespbOpbAmt = prsRespbOpbAmt;
		this.propNo = propNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dst_rout_pnt_loc_def_cd", getDstRoutPntLocDefCd());
		this.hashColumns.put("prs_scg_amt", getPrsScgAmt());
		this.hashColumns.put("rate_type", getRateType());
		this.hashColumns.put("prs_respb_cm_uc_amt", getPrsRespbCmUcAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dst_rout_via_port_def_cd", getDstRoutViaPortDefCd());
		this.hashColumns.put("ori_rout_via_port_def_cd", getOriRoutViaPortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ori_rout_pnt_loc_def_cd", getOriRoutPntLocDefCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("prs_respb_opfit_uc_amt", getPrsRespbOpfitUcAmt());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("g_rate_type", getGRateType());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("prs_respb_cmpb_amt", getPrsRespbCmpbAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("prs_gid_cmpb_amt", getPrsGidCmpbAmt());
		this.hashColumns.put("s_rate_type", getSRateType());
		this.hashColumns.put("prs_respb_opb_amt", getPrsRespbOpbAmt());
		this.hashColumns.put("prop_no", getPropNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dst_rout_pnt_loc_def_cd", "dstRoutPntLocDefCd");
		this.hashFields.put("prs_scg_amt", "prsScgAmt");
		this.hashFields.put("rate_type", "rateType");
		this.hashFields.put("prs_respb_cm_uc_amt", "prsRespbCmUcAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dst_rout_via_port_def_cd", "dstRoutViaPortDefCd");
		this.hashFields.put("ori_rout_via_port_def_cd", "oriRoutViaPortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ori_rout_pnt_loc_def_cd", "oriRoutPntLocDefCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("prs_respb_opfit_uc_amt", "prsRespbOpfitUcAmt");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("g_rate_type", "gRateType");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("prs_respb_cmpb_amt", "prsRespbCmpbAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("prs_gid_cmpb_amt", "prsGidCmpbAmt");
		this.hashFields.put("s_rate_type", "sRateType");
		this.hashFields.put("prs_respb_opb_amt", "prsRespbOpbAmt");
		this.hashFields.put("prop_no", "propNo");
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
	 * @return prsScgAmt
	 */
	public String getPrsScgAmt() {
		return this.prsScgAmt;
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
	 * @return prsRespbCmUcAmt
	 */
	public String getPrsRespbCmUcAmt() {
		return this.prsRespbCmUcAmt;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
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
	 * @return dstRoutViaPortDefCd
	 */
	public String getDstRoutViaPortDefCd() {
		return this.dstRoutViaPortDefCd;
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
	 * @return prsRespbOpfitUcAmt
	 */
	public String getPrsRespbOpfitUcAmt() {
		return this.prsRespbOpfitUcAmt;
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
	 * @return gRateType
	 */
	public String getGRateType() {
		return this.gRateType;
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
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRespbCmpbAmt
	 */
	public String getPrsRespbCmpbAmt() {
		return this.prsRespbCmpbAmt;
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
	 * @return prsGidCmpbAmt
	 */
	public String getPrsGidCmpbAmt() {
		return this.prsGidCmpbAmt;
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
	 * @return prsRespbOpbAmt
	 */
	public String getPrsRespbOpbAmt() {
		return this.prsRespbOpbAmt;
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
	 * @param dstRoutPntLocDefCd
	 */
	public void setDstRoutPntLocDefCd(String dstRoutPntLocDefCd) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param prsScgAmt
	 */
	public void setPrsScgAmt(String prsScgAmt) {
		this.prsScgAmt = prsScgAmt;
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
	 * @param prsRespbCmUcAmt
	 */
	public void setPrsRespbCmUcAmt(String prsRespbCmUcAmt) {
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
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
	 * @param dstRoutViaPortDefCd
	 */
	public void setDstRoutViaPortDefCd(String dstRoutViaPortDefCd) {
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
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
	 * @param prsRespbOpfitUcAmt
	 */
	public void setPrsRespbOpfitUcAmt(String prsRespbOpfitUcAmt) {
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
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
	 * @param gRateType
	 */
	public void setGRateType(String gRateType) {
		this.gRateType = gRateType;
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
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRespbCmpbAmt
	 */
	public void setPrsRespbCmpbAmt(String prsRespbCmpbAmt) {
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
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
	 * @param prsGidCmpbAmt
	 */
	public void setPrsGidCmpbAmt(String prsGidCmpbAmt) {
		this.prsGidCmpbAmt = prsGidCmpbAmt;
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
	 * @param prsRespbOpbAmt
	 */
	public void setPrsRespbOpbAmt(String prsRespbOpbAmt) {
		this.prsRespbOpbAmt = prsRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDstRoutPntLocDefCd(JSPUtil.getParameter(request, "dst_rout_pnt_loc_def_cd", ""));
		setPrsScgAmt(JSPUtil.getParameter(request, "prs_scg_amt", ""));
		setRateType(JSPUtil.getParameter(request, "rate_type", ""));
		setPrsRespbCmUcAmt(JSPUtil.getParameter(request, "prs_respb_cm_uc_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setDiff(JSPUtil.getParameter(request, "diff", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setDstRoutViaPortDefCd(JSPUtil.getParameter(request, "dst_rout_via_port_def_cd", ""));
		setOriRoutViaPortDefCd(JSPUtil.getParameter(request, "ori_rout_via_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOriRoutPntLocDefCd(JSPUtil.getParameter(request, "ori_rout_pnt_loc_def_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd", ""));
		setPrsRespbOpfitUcAmt(JSPUtil.getParameter(request, "prs_respb_opfit_uc_amt", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setGRateType(JSPUtil.getParameter(request, "g_rate_type", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, "prop_frt_rt_amt", ""));
		setPrsRespbCmpbAmt(JSPUtil.getParameter(request, "prs_respb_cmpb_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setPrsGidCmpbAmt(JSPUtil.getParameter(request, "prs_gid_cmpb_amt", ""));
		setSRateType(JSPUtil.getParameter(request, "s_rate_type", ""));
		setPrsRespbOpbAmt(JSPUtil.getParameter(request, "prs_respb_opb_amt", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRateCmpbViewAllListVO[]
	 */
	public RsltPriRateCmpbViewAllListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRateCmpbViewAllListVO[]
	 */
	public RsltPriRateCmpbViewAllListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRateCmpbViewAllListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dstRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_pnt_loc_def_cd", length));
			String[] prsScgAmt = (JSPUtil.getParameter(request, prefix	+ "prs_scg_amt", length));
			String[] rateType = (JSPUtil.getParameter(request, prefix	+ "rate_type", length));
			String[] prsRespbCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cm_uc_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] dstRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_via_port_def_cd", length));
			String[] oriRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_via_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oriRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_pnt_loc_def_cd", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] prsRespbOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opfit_uc_amt", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] gRateType = (JSPUtil.getParameter(request, prefix	+ "g_rate_type", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] prsRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cmpb_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] prsGidCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_gid_cmpb_amt", length));
			String[] sRateType = (JSPUtil.getParameter(request, prefix	+ "s_rate_type", length));
			String[] prsRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opb_amt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRateCmpbViewAllListVO();
				if (dstRoutPntLocDefCd[i] != null)
					model.setDstRoutPntLocDefCd(dstRoutPntLocDefCd[i]);
				if (prsScgAmt[i] != null)
					model.setPrsScgAmt(prsScgAmt[i]);
				if (rateType[i] != null)
					model.setRateType(rateType[i]);
				if (prsRespbCmUcAmt[i] != null)
					model.setPrsRespbCmUcAmt(prsRespbCmUcAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (dstRoutViaPortDefCd[i] != null)
					model.setDstRoutViaPortDefCd(dstRoutViaPortDefCd[i]);
				if (oriRoutViaPortDefCd[i] != null)
					model.setOriRoutViaPortDefCd(oriRoutViaPortDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oriRoutPntLocDefCd[i] != null)
					model.setOriRoutPntLocDefCd(oriRoutPntLocDefCd[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (prsRespbOpfitUcAmt[i] != null)
					model.setPrsRespbOpfitUcAmt(prsRespbOpfitUcAmt[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (gRateType[i] != null)
					model.setGRateType(gRateType[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (prsRespbCmpbAmt[i] != null)
					model.setPrsRespbCmpbAmt(prsRespbCmpbAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (prsGidCmpbAmt[i] != null)
					model.setPrsGidCmpbAmt(prsGidCmpbAmt[i]);
				if (sRateType[i] != null)
					model.setSRateType(sRateType[i]);
				if (prsRespbOpbAmt[i] != null)
					model.setPrsRespbOpbAmt(prsRespbOpbAmt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRateCmpbViewAllListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRateCmpbViewAllListVO[]
	 */
	public RsltPriRateCmpbViewAllListVO[] getRsltPriRateCmpbViewAllListVOs(){
		RsltPriRateCmpbViewAllListVO[] vos = (RsltPriRateCmpbViewAllListVO[])models.toArray(new RsltPriRateCmpbViewAllListVO[models.size()]);
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
		this.prsScgAmt = this.prsScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateType = this.rateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmUcAmt = this.prsRespbCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstRoutViaPortDefCd = this.dstRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutViaPortDefCd = this.oriRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutPntLocDefCd = this.oriRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpfitUcAmt = this.prsRespbOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRateType = this.gRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmpbAmt = this.prsRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsGidCmpbAmt = this.prsGidCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRateType = this.sRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpbAmt = this.prsRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
