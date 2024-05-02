/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltRtCmdtHdrListVO.java
*@FileTitle : RsltRtCmdtHdrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.27  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtCmdtHdrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtCmdtHdrListVO> models = new ArrayList<RsltRtCmdtHdrListVO>();
	
	/* Column Info */
	private String naCnt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ndCnt = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bletDpSeqProp = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String noteCtntProp = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String bletDpSeq = null;
	/* Column Info */
	private String rowProperties = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prcCmdtDefNmProp = null;
	/* Column Info */
	private String upCnt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String noteCtntTooltip = null;
	/* Column Info */
	private String custLglEngNmProp = null;
	/* Column Info */
	private String acCnt = null;
	/* Column Info */
	private String orgN1stCmncAmdtSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtCmdtHdrListVO() {}

	public RsltRtCmdtHdrListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String prcCmdtDefNm, String prcCmdtDefNmProp, String custLglEngNm, String custLglEngNmProp, String noteCtnt, String noteCtntProp, String noteCtntTooltip, String ndCnt, String naCnt, String acCnt, String upCnt, String rowProperties, String bletDpSeq, String bletDpSeqProp, String n1stCmncAmdtSeq, String orgN1stCmncAmdtSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.naCnt = naCnt;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.noteCtnt = noteCtnt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ndCnt = ndCnt;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.updUsrId = updUsrId;
		this.bletDpSeqProp = bletDpSeqProp;
		this.updDt = updDt;
		this.noteCtntProp = noteCtntProp;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.custLglEngNm = custLglEngNm;
		this.bletDpSeq = bletDpSeq;
		this.rowProperties = rowProperties;
		this.creUsrId = creUsrId;
		this.prcCmdtDefNmProp = prcCmdtDefNmProp;
		this.upCnt = upCnt;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.noteCtntTooltip = noteCtntTooltip;
		this.custLglEngNmProp = custLglEngNmProp;
		this.acCnt = acCnt;
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("na_cnt", getNaCnt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nd_cnt", getNdCnt());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("blet_dp_seq_prop", getBletDpSeqProp());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("note_ctnt_prop", getNoteCtntProp());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("blet_dp_seq", getBletDpSeq());
		this.hashColumns.put("row_properties", getRowProperties());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prc_cmdt_def_nm_prop", getPrcCmdtDefNmProp());
		this.hashColumns.put("up_cnt", getUpCnt());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("note_ctnt_tooltip", getNoteCtntTooltip());
		this.hashColumns.put("cust_lgl_eng_nm_prop", getCustLglEngNmProp());
		this.hashColumns.put("ac_cnt", getAcCnt());
		this.hashColumns.put("org_n1st_cmnc_amdt_seq", getOrgN1stCmncAmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("na_cnt", "naCnt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nd_cnt", "ndCnt");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("blet_dp_seq_prop", "bletDpSeqProp");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("note_ctnt_prop", "noteCtntProp");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("blet_dp_seq", "bletDpSeq");
		this.hashFields.put("row_properties", "rowProperties");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prc_cmdt_def_nm_prop", "prcCmdtDefNmProp");
		this.hashFields.put("up_cnt", "upCnt");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("note_ctnt_tooltip", "noteCtntTooltip");
		this.hashFields.put("cust_lgl_eng_nm_prop", "custLglEngNmProp");
		this.hashFields.put("ac_cnt", "acCnt");
		this.hashFields.put("org_n1st_cmnc_amdt_seq", "orgN1stCmncAmdtSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return naCnt
	 */
	public String getNaCnt() {
		return this.naCnt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
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
	 * @return ndCnt
	 */
	public String getNdCnt() {
		return this.ndCnt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return bletDpSeqProp
	 */
	public String getBletDpSeqProp() {
		return this.bletDpSeqProp;
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
	 * @return noteCtntProp
	 */
	public String getNoteCtntProp() {
		return this.noteCtntProp;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return rowProperties
	 */
	public String getRowProperties() {
		return this.rowProperties;
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
	 * @return prcCmdtDefNmProp
	 */
	public String getPrcCmdtDefNmProp() {
		return this.prcCmdtDefNmProp;
	}
	
	/**
	 * Column Info
	 * @return upCnt
	 */
	public String getUpCnt() {
		return this.upCnt;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return noteCtntTooltip
	 */
	public String getNoteCtntTooltip() {
		return this.noteCtntTooltip;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNmProp
	 */
	public String getCustLglEngNmProp() {
		return this.custLglEngNmProp;
	}
	
	/**
	 * Column Info
	 * @return acCnt
	 */
	public String getAcCnt() {
		return this.acCnt;
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
	 * @param naCnt
	 */
	public void setNaCnt(String naCnt) {
		this.naCnt = naCnt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
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
	 * @param ndCnt
	 */
	public void setNdCnt(String ndCnt) {
		this.ndCnt = ndCnt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param bletDpSeqProp
	 */
	public void setBletDpSeqProp(String bletDpSeqProp) {
		this.bletDpSeqProp = bletDpSeqProp;
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
	 * @param noteCtntProp
	 */
	public void setNoteCtntProp(String noteCtntProp) {
		this.noteCtntProp = noteCtntProp;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param rowProperties
	 */
	public void setRowProperties(String rowProperties) {
		this.rowProperties = rowProperties;
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
	 * @param prcCmdtDefNmProp
	 */
	public void setPrcCmdtDefNmProp(String prcCmdtDefNmProp) {
		this.prcCmdtDefNmProp = prcCmdtDefNmProp;
	}
	
	/**
	 * Column Info
	 * @param upCnt
	 */
	public void setUpCnt(String upCnt) {
		this.upCnt = upCnt;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param noteCtntTooltip
	 */
	public void setNoteCtntTooltip(String noteCtntTooltip) {
		this.noteCtntTooltip = noteCtntTooltip;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNmProp
	 */
	public void setCustLglEngNmProp(String custLglEngNmProp) {
		this.custLglEngNmProp = custLglEngNmProp;
	}
	
	/**
	 * Column Info
	 * @param acCnt
	 */
	public void setAcCnt(String acCnt) {
		this.acCnt = acCnt;
	}
	
	/**
	 * Column Info
	 * @param orgN1stCmncAmdtSeq
	 */
	public void setOrgN1stCmncAmdtSeq(String orgN1stCmncAmdtSeq) {
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
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
		setNaCnt(JSPUtil.getParameter(request, prefix + "na_cnt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNdCnt(JSPUtil.getParameter(request, prefix + "nd_cnt", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBletDpSeqProp(JSPUtil.getParameter(request, prefix + "blet_dp_seq_prop", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNoteCtntProp(JSPUtil.getParameter(request, prefix + "note_ctnt_prop", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setBletDpSeq(JSPUtil.getParameter(request, prefix + "blet_dp_seq", ""));
		setRowProperties(JSPUtil.getParameter(request, prefix + "row_properties", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPrcCmdtDefNmProp(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm_prop", ""));
		setUpCnt(JSPUtil.getParameter(request, prefix + "up_cnt", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setNoteCtntTooltip(JSPUtil.getParameter(request, prefix + "note_ctnt_tooltip", ""));
		setCustLglEngNmProp(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm_prop", ""));
		setAcCnt(JSPUtil.getParameter(request, prefix + "ac_cnt", ""));
		setOrgN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "org_n1st_cmnc_amdt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtCmdtHdrListVO[]
	 */
	public RsltRtCmdtHdrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtCmdtHdrListVO[]
	 */
	public RsltRtCmdtHdrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtCmdtHdrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] naCnt = (JSPUtil.getParameter(request, prefix	+ "na_cnt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ndCnt = (JSPUtil.getParameter(request, prefix	+ "nd_cnt", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bletDpSeqProp = (JSPUtil.getParameter(request, prefix	+ "blet_dp_seq_prop", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] noteCtntProp = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_prop", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] bletDpSeq = (JSPUtil.getParameter(request, prefix	+ "blet_dp_seq", length));
			String[] rowProperties = (JSPUtil.getParameter(request, prefix	+ "row_properties", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] prcCmdtDefNmProp = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm_prop", length));
			String[] upCnt = (JSPUtil.getParameter(request, prefix	+ "up_cnt", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] noteCtntTooltip = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_tooltip", length));
			String[] custLglEngNmProp = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm_prop", length));
			String[] acCnt = (JSPUtil.getParameter(request, prefix	+ "ac_cnt", length));
			String[] orgN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "org_n1st_cmnc_amdt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtCmdtHdrListVO();
				if (naCnt[i] != null)
					model.setNaCnt(naCnt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ndCnt[i] != null)
					model.setNdCnt(ndCnt[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bletDpSeqProp[i] != null)
					model.setBletDpSeqProp(bletDpSeqProp[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (noteCtntProp[i] != null)
					model.setNoteCtntProp(noteCtntProp[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (bletDpSeq[i] != null)
					model.setBletDpSeq(bletDpSeq[i]);
				if (rowProperties[i] != null)
					model.setRowProperties(rowProperties[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prcCmdtDefNmProp[i] != null)
					model.setPrcCmdtDefNmProp(prcCmdtDefNmProp[i]);
				if (upCnt[i] != null)
					model.setUpCnt(upCnt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (noteCtntTooltip[i] != null)
					model.setNoteCtntTooltip(noteCtntTooltip[i]);
				if (custLglEngNmProp[i] != null)
					model.setCustLglEngNmProp(custLglEngNmProp[i]);
				if (acCnt[i] != null)
					model.setAcCnt(acCnt[i]);
				if (orgN1stCmncAmdtSeq[i] != null)
					model.setOrgN1stCmncAmdtSeq(orgN1stCmncAmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtCmdtHdrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtCmdtHdrListVO[]
	 */
	public RsltRtCmdtHdrListVO[] getRsltRtCmdtHdrListVOs(){
		RsltRtCmdtHdrListVO[] vos = (RsltRtCmdtHdrListVO[])models.toArray(new RsltRtCmdtHdrListVO[models.size()]);
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
		this.naCnt = this.naCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndCnt = this.ndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bletDpSeqProp = this.bletDpSeqProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntProp = this.noteCtntProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bletDpSeq = this.bletDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowProperties = this.rowProperties .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNmProp = this.prcCmdtDefNmProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upCnt = this.upCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntTooltip = this.noteCtntTooltip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNmProp = this.custLglEngNmProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acCnt = this.acCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgN1stCmncAmdtSeq = this.orgN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
