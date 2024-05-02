/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ViewAllRatesListPagingVO.java
*@FileTitle : ViewAllRatesListPagingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.21 김대호 
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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ViewAllRatesListPagingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ViewAllRatesListPagingVO> models = new ArrayList<ViewAllRatesListPagingVO>();
	
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destRoutPntLocCntCd = null;
	/* Column Info */
	private String cnoteCtnt = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String rnoteCtnt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String orgRoutPntLocSteCd = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String orgRoutPntLocCntCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String endRow = null;
	/* Column Info */
	private String destRoutPntLocSteCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String startRow = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String rowNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ViewAllRatesListPagingVO() {}

	public ViewAllRatesListPagingVO(String ibflag, String pagerows, String rowNo, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String cmdtHdrSeq, String prcCmdtDefNm, String custLglEngNm, String cnoteCtnt, String routSeq, String orgRoutPntLocDefCd, String orgRoutPntLocCntCd, String orgRoutPntLocSteCd, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocCntCd, String destRoutPntLocSteCd, String rnoteCtnt, String rtSeq, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String srcInfoCd, String pageNo, String startRow, String endRow) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.destRoutPntLocCntCd = destRoutPntLocCntCd;
		this.cnoteCtnt = cnoteCtnt;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.rnoteCtnt = rnoteCtnt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.srcInfoCd = srcInfoCd;
		this.orgRoutPntLocSteCd = orgRoutPntLocSteCd;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.orgRoutPntLocCntCd = orgRoutPntLocCntCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.ratUtCd = ratUtCd;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.custLglEngNm = custLglEngNm;
		this.endRow = endRow;
		this.destRoutPntLocSteCd = destRoutPntLocSteCd;
		this.propNo = propNo;
		this.startRow = startRow;
		this.pageNo = pageNo;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.rowNo = rowNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_rout_pnt_loc_cnt_cd", getDestRoutPntLocCntCd());
		this.hashColumns.put("cnote_ctnt", getCnoteCtnt());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("rnote_ctnt", getRnoteCtnt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("org_rout_pnt_loc_ste_cd", getOrgRoutPntLocSteCd());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("org_rout_pnt_loc_cnt_cd", getOrgRoutPntLocCntCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("end_row", getEndRow());
		this.hashColumns.put("dest_rout_pnt_loc_ste_cd", getDestRoutPntLocSteCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("start_row", getStartRow());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("row_no", getRowNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_rout_pnt_loc_cnt_cd", "destRoutPntLocCntCd");
		this.hashFields.put("cnote_ctnt", "cnoteCtnt");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("rnote_ctnt", "rnoteCtnt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("org_rout_pnt_loc_ste_cd", "orgRoutPntLocSteCd");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("org_rout_pnt_loc_cnt_cd", "orgRoutPntLocCntCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("end_row", "endRow");
		this.hashFields.put("dest_rout_pnt_loc_ste_cd", "destRoutPntLocSteCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("start_row", "startRow");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("row_no", "rowNo");
		return this.hashFields;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return destRoutPntLocCntCd
	 */
	public String getDestRoutPntLocCntCd() {
		return this.destRoutPntLocCntCd;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocSteCd
	 */
	public String getOrgRoutPntLocSteCd() {
		return this.orgRoutPntLocSteCd;
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
	 * @return orgRoutPntLocCntCd
	 */
	public String getOrgRoutPntLocCntCd() {
		return this.orgRoutPntLocCntCd;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return endRow
	 */
	public String getEndRow() {
		return this.endRow;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocSteCd
	 */
	public String getDestRoutPntLocSteCd() {
		return this.destRoutPntLocSteCd;
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
	 * @return startRow
	 */
	public String getStartRow() {
		return this.startRow;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
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
	 * @return rowNo
	 */
	public String getRowNo() {
		return this.rowNo;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param destRoutPntLocCntCd
	 */
	public void setDestRoutPntLocCntCd(String destRoutPntLocCntCd) {
		this.destRoutPntLocCntCd = destRoutPntLocCntCd;
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
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocSteCd
	 */
	public void setOrgRoutPntLocSteCd(String orgRoutPntLocSteCd) {
		this.orgRoutPntLocSteCd = orgRoutPntLocSteCd;
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
	 * @param orgRoutPntLocCntCd
	 */
	public void setOrgRoutPntLocCntCd(String orgRoutPntLocCntCd) {
		this.orgRoutPntLocCntCd = orgRoutPntLocCntCd;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param endRow
	 */
	public void setEndRow(String endRow) {
		this.endRow = endRow;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocSteCd
	 */
	public void setDestRoutPntLocSteCd(String destRoutPntLocSteCd) {
		this.destRoutPntLocSteCd = destRoutPntLocSteCd;
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
	 * @param startRow
	 */
	public void setStartRow(String startRow) {
		this.startRow = startRow;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
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
	 * @param rowNo
	 */
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
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
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDestRoutPntLocCntCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_cnt_cd", ""));
		setCnoteCtnt(JSPUtil.getParameter(request, prefix + "cnote_ctnt", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setRnoteCtnt(JSPUtil.getParameter(request, prefix + "rnote_ctnt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setOrgRoutPntLocSteCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_ste_cd", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setOrgRoutPntLocCntCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_cnt_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setEndRow(JSPUtil.getParameter(request, prefix + "end_row", ""));
		setDestRoutPntLocSteCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_ste_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setStartRow(JSPUtil.getParameter(request, prefix + "start_row", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setRowNo(JSPUtil.getParameter(request, prefix + "row_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ViewAllRatesListPagingVO[]
	 */
	public ViewAllRatesListPagingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ViewAllRatesListPagingVO[]
	 */
	public ViewAllRatesListPagingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ViewAllRatesListPagingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] destRoutPntLocCntCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_cnt_cd", length));
			String[] cnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "cnote_ctnt", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] rnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "rnote_ctnt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] orgRoutPntLocSteCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_ste_cd", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] orgRoutPntLocCntCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_cnt_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] endRow = (JSPUtil.getParameter(request, prefix	+ "end_row", length));
			String[] destRoutPntLocSteCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_ste_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] startRow = (JSPUtil.getParameter(request, prefix	+ "start_row", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] rowNo = (JSPUtil.getParameter(request, prefix	+ "row_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ViewAllRatesListPagingVO();
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destRoutPntLocCntCd[i] != null)
					model.setDestRoutPntLocCntCd(destRoutPntLocCntCd[i]);
				if (cnoteCtnt[i] != null)
					model.setCnoteCtnt(cnoteCtnt[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (rnoteCtnt[i] != null)
					model.setRnoteCtnt(rnoteCtnt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (orgRoutPntLocSteCd[i] != null)
					model.setOrgRoutPntLocSteCd(orgRoutPntLocSteCd[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (orgRoutPntLocCntCd[i] != null)
					model.setOrgRoutPntLocCntCd(orgRoutPntLocCntCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (endRow[i] != null)
					model.setEndRow(endRow[i]);
				if (destRoutPntLocSteCd[i] != null)
					model.setDestRoutPntLocSteCd(destRoutPntLocSteCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (startRow[i] != null)
					model.setStartRow(startRow[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (rowNo[i] != null)
					model.setRowNo(rowNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getViewAllRatesListPagingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ViewAllRatesListPagingVO[]
	 */
	public ViewAllRatesListPagingVO[] getViewAllRatesListPagingVOs(){
		ViewAllRatesListPagingVO[] vos = (ViewAllRatesListPagingVO[])models.toArray(new ViewAllRatesListPagingVO[models.size()]);
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
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocCntCd = this.destRoutPntLocCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnoteCtnt = this.cnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnoteCtnt = this.rnoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocSteCd = this.orgRoutPntLocSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocCntCd = this.orgRoutPntLocCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endRow = this.endRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocSteCd = this.destRoutPntLocSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startRow = this.startRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNo = this.rowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
