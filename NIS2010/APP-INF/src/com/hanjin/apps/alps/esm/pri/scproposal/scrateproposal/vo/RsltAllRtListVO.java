/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RsltAllRtListVO.java
*@FileTitle : RsltAllRtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.01
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.11.01 이관샨 
* 1.0 Creation
* 2013.03.11 전윤주 [SRM-201333847] FRC_SCG_AMT 추가
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo;

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
 * @author 이관샨
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltAllRtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltAllRtListVO> models = new ArrayList<RsltAllRtListVO>();
	
	/* Column Info */
	private String bucScgAmt = null;
	/* Column Info */
	private String frcScgAmt = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String pscScgAmt = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String totalAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bletDpSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String griCtnt = null;
	/* Column Info */
	private String rtCtnt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String cnoteCtnt = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String rnoteCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltAllRtListVO() {}

	public RsltAllRtListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String bletDpSeq, String prcCmdtDefNm, String custLglEngNm, String cnoteCtnt, String routSeq, String orgRoutPntLocDefNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefNm, String dirCallFlg, String rnoteCtnt, String rtCtnt, String griCtnt, String bucScgAmt, String frcScgAmt, String pscScgAmt, String totalAmt) {
		this.bucScgAmt = bucScgAmt;
		this.frcScgAmt = frcScgAmt;
		this.dirCallFlg = dirCallFlg;
		this.pscScgAmt = pscScgAmt;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.totalAmt = totalAmt;
		this.pagerows = pagerows;
		this.bletDpSeq = bletDpSeq;
		this.custLglEngNm = custLglEngNm;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.griCtnt = griCtnt;
		this.rtCtnt = rtCtnt;
		this.propNo = propNo;
		this.cnoteCtnt = cnoteCtnt;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.rnoteCtnt = rnoteCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("buc_scg_amt", getBucScgAmt());
		this.hashColumns.put("frc_scg_amt", getFrcScgAmt());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("psc_scg_amt", getPscScgAmt());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("blet_dp_seq", getBletDpSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("gri_ctnt", getGriCtnt());
		this.hashColumns.put("rt_ctnt", getRtCtnt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cnote_ctnt", getCnoteCtnt());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("rnote_ctnt", getRnoteCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("buc_scg_amt", "bucScgAmt");
		this.hashFields.put("frc_scg_amt", "frcScgAmt");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("psc_scg_amt", "pscScgAmt");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("blet_dp_seq", "bletDpSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("gri_ctnt", "griCtnt");
		this.hashFields.put("rt_ctnt", "rtCtnt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cnote_ctnt", "cnoteCtnt");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("rnote_ctnt", "rnoteCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bucScgAmt
	 */
	public String getBucScgAmt() {
		return this.bucScgAmt;
	}
	
	/**
	 * Column Info
	 * @return frcScgAmt
	 */
	public String getFrcScgAmt() {
		return this.frcScgAmt;
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
	 * @return pscScgAmt
	 */
	public String getPscScgAmt() {
		return this.pscScgAmt;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
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
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
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
	 * @return bletDpSeq
	 */
	public String getBletDpSeq() {
		return this.bletDpSeq;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return griCtnt
	 */
	public String getGriCtnt() {
		return this.griCtnt;
	}
	
	/**
	 * Column Info
	 * @return rtCtnt
	 */
	public String getRtCtnt() {
		return this.rtCtnt;
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
	 * @return cnoteCtnt
	 */
	public String getCnoteCtnt() {
		return this.cnoteCtnt;
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
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
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
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return rnoteCtnt
	 */
	public String getRnoteCtnt() {
		return this.rnoteCtnt;
	}
	

	/**
	 * Column Info
	 * @param bucScgAmt
	 */
	public void setBucScgAmt(String bucScgAmt) {
		this.bucScgAmt = bucScgAmt;
	}
	
	/**
	 * Column Info
	 * @param frcScgAmt
	 */
	public void setFrcScgAmt(String frcScgAmt) {
		this.frcScgAmt = frcScgAmt;
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
	 * @param pscScgAmt
	 */
	public void setPscScgAmt(String pscScgAmt) {
		this.pscScgAmt = pscScgAmt;
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
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
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
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @param bletDpSeq
	 */
	public void setBletDpSeq(String bletDpSeq) {
		this.bletDpSeq = bletDpSeq;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param griCtnt
	 */
	public void setGriCtnt(String griCtnt) {
		this.griCtnt = griCtnt;
	}
	
	/**
	 * Column Info
	 * @param rtCtnt
	 */
	public void setRtCtnt(String rtCtnt) {
		this.rtCtnt = rtCtnt;
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
	 * @param cnoteCtnt
	 */
	public void setCnoteCtnt(String cnoteCtnt) {
		this.cnoteCtnt = cnoteCtnt;
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
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
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
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param rnoteCtnt
	 */
	public void setRnoteCtnt(String rnoteCtnt) {
		this.rnoteCtnt = rnoteCtnt;
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
		setBucScgAmt(JSPUtil.getParameter(request, prefix + "buc_scg_amt", ""));
		setFrcScgAmt(JSPUtil.getParameter(request, prefix + "frc_scg_amt", ""));
		setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
		setPscScgAmt(JSPUtil.getParameter(request, prefix + "psc_scg_amt", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBletDpSeq(JSPUtil.getParameter(request, prefix + "blet_dp_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setGriCtnt(JSPUtil.getParameter(request, prefix + "gri_ctnt", ""));
		setRtCtnt(JSPUtil.getParameter(request, prefix + "rt_ctnt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCnoteCtnt(JSPUtil.getParameter(request, prefix + "cnote_ctnt", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setRnoteCtnt(JSPUtil.getParameter(request, prefix + "rnote_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltAllRtListVO[]
	 */
	public RsltAllRtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltAllRtListVO[]
	 */
	public RsltAllRtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltAllRtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bucScgAmt = (JSPUtil.getParameter(request, prefix	+ "buc_scg_amt", length));
			String[] frcScgAmt = (JSPUtil.getParameter(request, prefix	+ "frc_scg_amt", length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] pscScgAmt = (JSPUtil.getParameter(request, prefix	+ "psc_scg_amt", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bletDpSeq = (JSPUtil.getParameter(request, prefix	+ "blet_dp_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] griCtnt = (JSPUtil.getParameter(request, prefix	+ "gri_ctnt", length));
			String[] rtCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_ctnt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] cnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "cnote_ctnt", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] rnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "rnote_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltAllRtListVO();
				if (bucScgAmt[i] != null)
					model.setBucScgAmt(bucScgAmt[i]);
				if (frcScgAmt[i] != null)
					model.setFrcScgAmt(frcScgAmt[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (pscScgAmt[i] != null)
					model.setPscScgAmt(pscScgAmt[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bletDpSeq[i] != null)
					model.setBletDpSeq(bletDpSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (griCtnt[i] != null)
					model.setGriCtnt(griCtnt[i]);
				if (rtCtnt[i] != null)
					model.setRtCtnt(rtCtnt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (cnoteCtnt[i] != null)
					model.setCnoteCtnt(cnoteCtnt[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (rnoteCtnt[i] != null)
					model.setRnoteCtnt(rnoteCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltAllRtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltAllRtListVO[]
	 */
	public RsltAllRtListVO[] getRsltAllRtListVOs(){
		RsltAllRtListVO[] vos = (RsltAllRtListVO[])models.toArray(new RsltAllRtListVO[models.size()]);
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
		this.bucScgAmt = this.bucScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frcScgAmt = this.frcScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscScgAmt = this.pscScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bletDpSeq = this.bletDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griCtnt = this.griCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCtnt = this.rtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnoteCtnt = this.cnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnoteCtnt = this.rnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
