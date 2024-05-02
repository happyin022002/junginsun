/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriRateCmpbViewAllListVO.java
*@FileTitle : RsltPriRateCmpbViewAllListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.07 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

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

public class RsltPriRateCmpbViewAllListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRateCmpbViewAllListVO> models = new ArrayList<RsltPriRateCmpbViewAllListVO>();
	
	/* Column Info */
	private String dstRoutPntLocDefCd = null;
	/* Column Info */
	private String prsScgAmt = null;
	/* Column Info */
	private String prsRespbCmUcAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
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
	private String prsRespbOpfitUcAmt = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
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
	private String prsRespbOpbAmt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String custCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRateCmpbViewAllListVO() {}

	public RsltPriRateCmpbViewAllListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String prcCmdtDefCd, String prcCmdtDefNm, String custCd, String custNm, String oriRoutPntLocDefCd, String dstRoutPntLocDefCd, String oriRoutViaPortDefCd, String dstRoutViaPortDefCd, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String prsScgAmt, String prsRespbCmUcAmt, String prsRespbCmpbAmt, String prsGidCmpbAmt, String diff, String prsRespbOpfitUcAmt, String prsRespbOpbAmt) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
		this.prsScgAmt = prsScgAmt;
		this.prsRespbCmUcAmt = prsRespbCmUcAmt;
		this.currCd = currCd;
		this.custNm = custNm;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.diff = diff;
		this.svcScpCd = svcScpCd;
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
		this.oriRoutViaPortDefCd = oriRoutViaPortDefCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oriRoutPntLocDefCd = oriRoutPntLocDefCd;
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.prsRespbCmpbAmt = prsRespbCmpbAmt;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.prsGidCmpbAmt = prsGidCmpbAmt;
		this.prsRespbOpbAmt = prsRespbOpbAmt;
		this.propNo = propNo;
		this.custCd = custCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dst_rout_pnt_loc_def_cd", getDstRoutPntLocDefCd());
		this.hashColumns.put("prs_scg_amt", getPrsScgAmt());
		this.hashColumns.put("prs_respb_cm_uc_amt", getPrsRespbCmUcAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dst_rout_via_port_def_cd", getDstRoutViaPortDefCd());
		this.hashColumns.put("ori_rout_via_port_def_cd", getOriRoutViaPortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ori_rout_pnt_loc_def_cd", getOriRoutPntLocDefCd());
		this.hashColumns.put("prs_respb_opfit_uc_amt", getPrsRespbOpfitUcAmt());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("prs_respb_cmpb_amt", getPrsRespbCmpbAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("prs_gid_cmpb_amt", getPrsGidCmpbAmt());
		this.hashColumns.put("prs_respb_opb_amt", getPrsRespbOpbAmt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cust_cd", getCustCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dst_rout_pnt_loc_def_cd", "dstRoutPntLocDefCd");
		this.hashFields.put("prs_scg_amt", "prsScgAmt");
		this.hashFields.put("prs_respb_cm_uc_amt", "prsRespbCmUcAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dst_rout_via_port_def_cd", "dstRoutViaPortDefCd");
		this.hashFields.put("ori_rout_via_port_def_cd", "oriRoutViaPortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ori_rout_pnt_loc_def_cd", "oriRoutPntLocDefCd");
		this.hashFields.put("prs_respb_opfit_uc_amt", "prsRespbOpfitUcAmt");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("prs_respb_cmpb_amt", "prsRespbCmpbAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("prs_gid_cmpb_amt", "prsGidCmpbAmt");
		this.hashFields.put("prs_respb_opb_amt", "prsRespbOpbAmt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cust_cd", "custCd");
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return prsRespbOpfitUcAmt
	 */
	public String getPrsRespbOpfitUcAmt() {
		return this.prsRespbOpfitUcAmt;
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
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param prsRespbOpfitUcAmt
	 */
	public void setPrsRespbOpfitUcAmt(String prsRespbOpfitUcAmt) {
		this.prsRespbOpfitUcAmt = prsRespbOpfitUcAmt;
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
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
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
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
		setDstRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dst_rout_pnt_loc_def_cd", ""));
		setPrsScgAmt(JSPUtil.getParameter(request, prefix + "prs_scg_amt", ""));
		setPrsRespbCmUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cm_uc_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDstRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dst_rout_via_port_def_cd", ""));
		setOriRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "ori_rout_via_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOriRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "ori_rout_pnt_loc_def_cd", ""));
		setPrsRespbOpfitUcAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opfit_uc_amt", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setPrsRespbCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_cmpb_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPrsGidCmpbAmt(JSPUtil.getParameter(request, prefix + "prs_gid_cmpb_amt", ""));
		setPrsRespbOpbAmt(JSPUtil.getParameter(request, prefix + "prs_respb_opb_amt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
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
			String[] prsRespbCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cm_uc_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] dstRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_via_port_def_cd", length));
			String[] oriRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_via_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oriRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_pnt_loc_def_cd", length));
			String[] prsRespbOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opfit_uc_amt", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] prsRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_cmpb_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] prsGidCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_gid_cmpb_amt", length));
			String[] prsRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_respb_opb_amt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRateCmpbViewAllListVO();
				if (dstRoutPntLocDefCd[i] != null)
					model.setDstRoutPntLocDefCd(dstRoutPntLocDefCd[i]);
				if (prsScgAmt[i] != null)
					model.setPrsScgAmt(prsScgAmt[i]);
				if (prsRespbCmUcAmt[i] != null)
					model.setPrsRespbCmUcAmt(prsRespbCmUcAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
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
				if (prsRespbOpfitUcAmt[i] != null)
					model.setPrsRespbOpfitUcAmt(prsRespbOpfitUcAmt[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
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
				if (prsRespbOpbAmt[i] != null)
					model.setPrsRespbOpbAmt(prsRespbOpbAmt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
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
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.dstRoutPntLocDefCd = this.dstRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsScgAmt = this.prsScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmUcAmt = this.prsRespbCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstRoutViaPortDefCd = this.dstRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutViaPortDefCd = this.oriRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutPntLocDefCd = this.oriRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpfitUcAmt = this.prsRespbOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbCmpbAmt = this.prsRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsGidCmpbAmt = this.prsGidCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRespbOpbAmt = this.prsRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
