/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsProposalSummaryRevenueDetailVO.java
*@FileTitle : RsltPrsProposalSummaryRevenueDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.23 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPrsProposalSummaryRevenueDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsProposalSummaryRevenueDetailVO> models = new ArrayList<RsltPrsProposalSummaryRevenueDetailVO>();
	
	/* Column Info */
	private String loadNew = null;
	/* Column Info */
	private String oftAmtPrevious = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String gRev = null;
	/* Column Info */
	private String gRevPrevious = null;
	/* Column Info */
	private String bucScgAmtDiff = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pscScgAmtDiff = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loadPrevious = null;
	/* Column Info */
	private String pscScgAmtPrevious = null;
	/* Column Info */
	private String ifcScgAmt = null;
	/* Column Info */
	private String othersScgAmtPrevious = null;
	/* Column Info */
	private String ifcScgAmtPrevious = null;
	/* Column Info */
	private String oftAmt = null;
	/* Column Info */
	private String contractNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String bucScgAmt = null;
	/* Column Info */
	private String pscScgAmt = null;
	/* Column Info */
	private String ifcScgAmtDiff = null;
	/* Column Info */
	private String propOfcNm = null;
	/* Column Info */
	private String gRevDiff = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String othersScgAmtDiff = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String loadDiff = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String bucScgAmtPrevious = null;
	/* Column Info */
	private String othersScgAmt = null;
	/* Column Info */
	private String oftAmtDiff = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsProposalSummaryRevenueDetailVO() {}

	public RsltPrsProposalSummaryRevenueDetailVO(String ibflag, String pagerows, String bucScgAmt, String ifcScgAmt, String pscScgAmt, String othersScgAmt, String oftAmt, String bucScgAmtPrevious, String ifcScgAmtPrevious, String pscScgAmtPrevious, String othersScgAmtPrevious, String oftAmtPrevious, String propOfcCd, String propOfcNm, String propNo, String amdtSeq, String custCntCd, String custSeq, String ctrtEffDt, String ctrtExpDt, String ctrtPtyNm, String gRev, String loadNew, String loadPrevious, String gRevPrevious, String loadDiff, String gRevDiff, String oftAmtDiff, String bucScgAmtDiff, String ifcScgAmtDiff, String pscScgAmtDiff, String othersScgAmtDiff, String contractNm) {
		this.loadNew = loadNew;
		this.oftAmtPrevious = oftAmtPrevious;
		this.ctrtEffDt = ctrtEffDt;
		this.amdtSeq = amdtSeq;
		this.gRev = gRev;
		this.gRevPrevious = gRevPrevious;
		this.bucScgAmtDiff = bucScgAmtDiff;
		this.pagerows = pagerows;
		this.pscScgAmtDiff = pscScgAmtDiff;
		this.ibflag = ibflag;
		this.loadPrevious = loadPrevious;
		this.pscScgAmtPrevious = pscScgAmtPrevious;
		this.ifcScgAmt = ifcScgAmt;
		this.othersScgAmtPrevious = othersScgAmtPrevious;
		this.ifcScgAmtPrevious = ifcScgAmtPrevious;
		this.oftAmt = oftAmt;
		this.contractNm = contractNm;
		this.custCntCd = custCntCd;
		this.ctrtExpDt = ctrtExpDt;
		this.bucScgAmt = bucScgAmt;
		this.pscScgAmt = pscScgAmt;
		this.ifcScgAmtDiff = ifcScgAmtDiff;
		this.propOfcNm = propOfcNm;
		this.gRevDiff = gRevDiff;
		this.custSeq = custSeq;
		this.othersScgAmtDiff = othersScgAmtDiff;
		this.ctrtPtyNm = ctrtPtyNm;
		this.loadDiff = loadDiff;
		this.propOfcCd = propOfcCd;
		this.propNo = propNo;
		this.bucScgAmtPrevious = bucScgAmtPrevious;
		this.othersScgAmt = othersScgAmt;
		this.oftAmtDiff = oftAmtDiff;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("load_new", getLoadNew());
		this.hashColumns.put("oft_amt_previous", getOftAmtPrevious());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("g_rev", getGRev());
		this.hashColumns.put("g_rev_previous", getGRevPrevious());
		this.hashColumns.put("buc_scg_amt_diff", getBucScgAmtDiff());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("psc_scg_amt_diff", getPscScgAmtDiff());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("load_previous", getLoadPrevious());
		this.hashColumns.put("psc_scg_amt_previous", getPscScgAmtPrevious());
		this.hashColumns.put("ifc_scg_amt", getIfcScgAmt());
		this.hashColumns.put("others_scg_amt_previous", getOthersScgAmtPrevious());
		this.hashColumns.put("ifc_scg_amt_previous", getIfcScgAmtPrevious());
		this.hashColumns.put("oft_amt", getOftAmt());
		this.hashColumns.put("contract_nm", getContractNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("buc_scg_amt", getBucScgAmt());
		this.hashColumns.put("psc_scg_amt", getPscScgAmt());
		this.hashColumns.put("ifc_scg_amt_diff", getIfcScgAmtDiff());
		this.hashColumns.put("prop_ofc_nm", getPropOfcNm());
		this.hashColumns.put("g_rev_diff", getGRevDiff());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("others_scg_amt_diff", getOthersScgAmtDiff());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("load_diff", getLoadDiff());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("buc_scg_amt_previous", getBucScgAmtPrevious());
		this.hashColumns.put("others_scg_amt", getOthersScgAmt());
		this.hashColumns.put("oft_amt_diff", getOftAmtDiff());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("load_new", "loadNew");
		this.hashFields.put("oft_amt_previous", "oftAmtPrevious");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("g_rev", "gRev");
		this.hashFields.put("g_rev_previous", "gRevPrevious");
		this.hashFields.put("buc_scg_amt_diff", "bucScgAmtDiff");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("psc_scg_amt_diff", "pscScgAmtDiff");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("load_previous", "loadPrevious");
		this.hashFields.put("psc_scg_amt_previous", "pscScgAmtPrevious");
		this.hashFields.put("ifc_scg_amt", "ifcScgAmt");
		this.hashFields.put("others_scg_amt_previous", "othersScgAmtPrevious");
		this.hashFields.put("ifc_scg_amt_previous", "ifcScgAmtPrevious");
		this.hashFields.put("oft_amt", "oftAmt");
		this.hashFields.put("contract_nm", "contractNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("buc_scg_amt", "bucScgAmt");
		this.hashFields.put("psc_scg_amt", "pscScgAmt");
		this.hashFields.put("ifc_scg_amt_diff", "ifcScgAmtDiff");
		this.hashFields.put("prop_ofc_nm", "propOfcNm");
		this.hashFields.put("g_rev_diff", "gRevDiff");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("others_scg_amt_diff", "othersScgAmtDiff");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("load_diff", "loadDiff");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("buc_scg_amt_previous", "bucScgAmtPrevious");
		this.hashFields.put("others_scg_amt", "othersScgAmt");
		this.hashFields.put("oft_amt_diff", "oftAmtDiff");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loadNew
	 */
	public String getLoadNew() {
		return this.loadNew;
	}
	
	/**
	 * Column Info
	 * @return oftAmtPrevious
	 */
	public String getOftAmtPrevious() {
		return this.oftAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * @return gRev
	 */
	public String getGRev() {
		return this.gRev;
	}
	
	/**
	 * Column Info
	 * @return gRevPrevious
	 */
	public String getGRevPrevious() {
		return this.gRevPrevious;
	}
	
	/**
	 * Column Info
	 * @return bucScgAmtDiff
	 */
	public String getBucScgAmtDiff() {
		return this.bucScgAmtDiff;
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
	 * @return pscScgAmtDiff
	 */
	public String getPscScgAmtDiff() {
		return this.pscScgAmtDiff;
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
	 * @return loadPrevious
	 */
	public String getLoadPrevious() {
		return this.loadPrevious;
	}
	
	/**
	 * Column Info
	 * @return pscScgAmtPrevious
	 */
	public String getPscScgAmtPrevious() {
		return this.pscScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @return ifcScgAmt
	 */
	public String getIfcScgAmt() {
		return this.ifcScgAmt;
	}
	
	/**
	 * Column Info
	 * @return othersScgAmtPrevious
	 */
	public String getOthersScgAmtPrevious() {
		return this.othersScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @return ifcScgAmtPrevious
	 */
	public String getIfcScgAmtPrevious() {
		return this.ifcScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @return oftAmt
	 */
	public String getOftAmt() {
		return this.oftAmt;
	}
	
	/**
	 * Column Info
	 * @return contractNm
	 */
	public String getContractNm() {
		return this.contractNm;
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
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @return pscScgAmt
	 */
	public String getPscScgAmt() {
		return this.pscScgAmt;
	}
	
	/**
	 * Column Info
	 * @return ifcScgAmtDiff
	 */
	public String getIfcScgAmtDiff() {
		return this.ifcScgAmtDiff;
	}
	
	/**
	 * Column Info
	 * @return propOfcNm
	 */
	public String getPropOfcNm() {
		return this.propOfcNm;
	}
	
	/**
	 * Column Info
	 * @return gRevDiff
	 */
	public String getGRevDiff() {
		return this.gRevDiff;
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
	 * @return othersScgAmtDiff
	 */
	public String getOthersScgAmtDiff() {
		return this.othersScgAmtDiff;
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
	 * @return loadDiff
	 */
	public String getLoadDiff() {
		return this.loadDiff;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
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
	 * @return bucScgAmtPrevious
	 */
	public String getBucScgAmtPrevious() {
		return this.bucScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @return othersScgAmt
	 */
	public String getOthersScgAmt() {
		return this.othersScgAmt;
	}
	
	/**
	 * Column Info
	 * @return oftAmtDiff
	 */
	public String getOftAmtDiff() {
		return this.oftAmtDiff;
	}
	

	/**
	 * Column Info
	 * @param loadNew
	 */
	public void setLoadNew(String loadNew) {
		this.loadNew = loadNew;
	}
	
	/**
	 * Column Info
	 * @param oftAmtPrevious
	 */
	public void setOftAmtPrevious(String oftAmtPrevious) {
		this.oftAmtPrevious = oftAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * @param gRev
	 */
	public void setGRev(String gRev) {
		this.gRev = gRev;
	}
	
	/**
	 * Column Info
	 * @param gRevPrevious
	 */
	public void setGRevPrevious(String gRevPrevious) {
		this.gRevPrevious = gRevPrevious;
	}
	
	/**
	 * Column Info
	 * @param bucScgAmtDiff
	 */
	public void setBucScgAmtDiff(String bucScgAmtDiff) {
		this.bucScgAmtDiff = bucScgAmtDiff;
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
	 * @param pscScgAmtDiff
	 */
	public void setPscScgAmtDiff(String pscScgAmtDiff) {
		this.pscScgAmtDiff = pscScgAmtDiff;
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
	 * @param loadPrevious
	 */
	public void setLoadPrevious(String loadPrevious) {
		this.loadPrevious = loadPrevious;
	}
	
	/**
	 * Column Info
	 * @param pscScgAmtPrevious
	 */
	public void setPscScgAmtPrevious(String pscScgAmtPrevious) {
		this.pscScgAmtPrevious = pscScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @param ifcScgAmt
	 */
	public void setIfcScgAmt(String ifcScgAmt) {
		this.ifcScgAmt = ifcScgAmt;
	}
	
	/**
	 * Column Info
	 * @param othersScgAmtPrevious
	 */
	public void setOthersScgAmtPrevious(String othersScgAmtPrevious) {
		this.othersScgAmtPrevious = othersScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @param ifcScgAmtPrevious
	 */
	public void setIfcScgAmtPrevious(String ifcScgAmtPrevious) {
		this.ifcScgAmtPrevious = ifcScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @param oftAmt
	 */
	public void setOftAmt(String oftAmt) {
		this.oftAmt = oftAmt;
	}
	
	/**
	 * Column Info
	 * @param contractNm
	 */
	public void setContractNm(String contractNm) {
		this.contractNm = contractNm;
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
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
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
	 * @param pscScgAmt
	 */
	public void setPscScgAmt(String pscScgAmt) {
		this.pscScgAmt = pscScgAmt;
	}
	
	/**
	 * Column Info
	 * @param ifcScgAmtDiff
	 */
	public void setIfcScgAmtDiff(String ifcScgAmtDiff) {
		this.ifcScgAmtDiff = ifcScgAmtDiff;
	}
	
	/**
	 * Column Info
	 * @param propOfcNm
	 */
	public void setPropOfcNm(String propOfcNm) {
		this.propOfcNm = propOfcNm;
	}
	
	/**
	 * Column Info
	 * @param gRevDiff
	 */
	public void setGRevDiff(String gRevDiff) {
		this.gRevDiff = gRevDiff;
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
	 * @param othersScgAmtDiff
	 */
	public void setOthersScgAmtDiff(String othersScgAmtDiff) {
		this.othersScgAmtDiff = othersScgAmtDiff;
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
	 * @param loadDiff
	 */
	public void setLoadDiff(String loadDiff) {
		this.loadDiff = loadDiff;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
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
	 * @param bucScgAmtPrevious
	 */
	public void setBucScgAmtPrevious(String bucScgAmtPrevious) {
		this.bucScgAmtPrevious = bucScgAmtPrevious;
	}
	
	/**
	 * Column Info
	 * @param othersScgAmt
	 */
	public void setOthersScgAmt(String othersScgAmt) {
		this.othersScgAmt = othersScgAmt;
	}
	
	/**
	 * Column Info
	 * @param oftAmtDiff
	 */
	public void setOftAmtDiff(String oftAmtDiff) {
		this.oftAmtDiff = oftAmtDiff;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLoadNew(JSPUtil.getParameter(request, "load_new", ""));
		setOftAmtPrevious(JSPUtil.getParameter(request, "oft_amt_previous", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setGRev(JSPUtil.getParameter(request, "g_rev", ""));
		setGRevPrevious(JSPUtil.getParameter(request, "g_rev_previous", ""));
		setBucScgAmtDiff(JSPUtil.getParameter(request, "buc_scg_amt_diff", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPscScgAmtDiff(JSPUtil.getParameter(request, "psc_scg_amt_diff", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLoadPrevious(JSPUtil.getParameter(request, "load_previous", ""));
		setPscScgAmtPrevious(JSPUtil.getParameter(request, "psc_scg_amt_previous", ""));
		setIfcScgAmt(JSPUtil.getParameter(request, "ifc_scg_amt", ""));
		setOthersScgAmtPrevious(JSPUtil.getParameter(request, "others_scg_amt_previous", ""));
		setIfcScgAmtPrevious(JSPUtil.getParameter(request, "ifc_scg_amt_previous", ""));
		setOftAmt(JSPUtil.getParameter(request, "oft_amt", ""));
		setContractNm(JSPUtil.getParameter(request, "contract_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
		setBucScgAmt(JSPUtil.getParameter(request, "buc_scg_amt", ""));
		setPscScgAmt(JSPUtil.getParameter(request, "psc_scg_amt", ""));
		setIfcScgAmtDiff(JSPUtil.getParameter(request, "ifc_scg_amt_diff", ""));
		setPropOfcNm(JSPUtil.getParameter(request, "prop_ofc_nm", ""));
		setGRevDiff(JSPUtil.getParameter(request, "g_rev_diff", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOthersScgAmtDiff(JSPUtil.getParameter(request, "others_scg_amt_diff", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setLoadDiff(JSPUtil.getParameter(request, "load_diff", ""));
		setPropOfcCd(JSPUtil.getParameter(request, "prop_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setBucScgAmtPrevious(JSPUtil.getParameter(request, "buc_scg_amt_previous", ""));
		setOthersScgAmt(JSPUtil.getParameter(request, "others_scg_amt", ""));
		setOftAmtDiff(JSPUtil.getParameter(request, "oft_amt_diff", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsProposalSummaryRevenueDetailVO[]
	 */
	public RsltPrsProposalSummaryRevenueDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsProposalSummaryRevenueDetailVO[]
	 */
	public RsltPrsProposalSummaryRevenueDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsProposalSummaryRevenueDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loadNew = (JSPUtil.getParameter(request, prefix	+ "load_new", length));
			String[] oftAmtPrevious = (JSPUtil.getParameter(request, prefix	+ "oft_amt_previous", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] gRev = (JSPUtil.getParameter(request, prefix	+ "g_rev", length));
			String[] gRevPrevious = (JSPUtil.getParameter(request, prefix	+ "g_rev_previous", length));
			String[] bucScgAmtDiff = (JSPUtil.getParameter(request, prefix	+ "buc_scg_amt_diff", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pscScgAmtDiff = (JSPUtil.getParameter(request, prefix	+ "psc_scg_amt_diff", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loadPrevious = (JSPUtil.getParameter(request, prefix	+ "load_previous", length));
			String[] pscScgAmtPrevious = (JSPUtil.getParameter(request, prefix	+ "psc_scg_amt_previous", length));
			String[] ifcScgAmt = (JSPUtil.getParameter(request, prefix	+ "ifc_scg_amt", length));
			String[] othersScgAmtPrevious = (JSPUtil.getParameter(request, prefix	+ "others_scg_amt_previous", length));
			String[] ifcScgAmtPrevious = (JSPUtil.getParameter(request, prefix	+ "ifc_scg_amt_previous", length));
			String[] oftAmt = (JSPUtil.getParameter(request, prefix	+ "oft_amt", length));
			String[] contractNm = (JSPUtil.getParameter(request, prefix	+ "contract_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] bucScgAmt = (JSPUtil.getParameter(request, prefix	+ "buc_scg_amt", length));
			String[] pscScgAmt = (JSPUtil.getParameter(request, prefix	+ "psc_scg_amt", length));
			String[] ifcScgAmtDiff = (JSPUtil.getParameter(request, prefix	+ "ifc_scg_amt_diff", length));
			String[] propOfcNm = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_nm", length));
			String[] gRevDiff = (JSPUtil.getParameter(request, prefix	+ "g_rev_diff", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] othersScgAmtDiff = (JSPUtil.getParameter(request, prefix	+ "others_scg_amt_diff", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] loadDiff = (JSPUtil.getParameter(request, prefix	+ "load_diff", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] bucScgAmtPrevious = (JSPUtil.getParameter(request, prefix	+ "buc_scg_amt_previous", length));
			String[] othersScgAmt = (JSPUtil.getParameter(request, prefix	+ "others_scg_amt", length));
			String[] oftAmtDiff = (JSPUtil.getParameter(request, prefix	+ "oft_amt_diff", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsProposalSummaryRevenueDetailVO();
				if (loadNew[i] != null)
					model.setLoadNew(loadNew[i]);
				if (oftAmtPrevious[i] != null)
					model.setOftAmtPrevious(oftAmtPrevious[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (gRev[i] != null)
					model.setGRev(gRev[i]);
				if (gRevPrevious[i] != null)
					model.setGRevPrevious(gRevPrevious[i]);
				if (bucScgAmtDiff[i] != null)
					model.setBucScgAmtDiff(bucScgAmtDiff[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pscScgAmtDiff[i] != null)
					model.setPscScgAmtDiff(pscScgAmtDiff[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loadPrevious[i] != null)
					model.setLoadPrevious(loadPrevious[i]);
				if (pscScgAmtPrevious[i] != null)
					model.setPscScgAmtPrevious(pscScgAmtPrevious[i]);
				if (ifcScgAmt[i] != null)
					model.setIfcScgAmt(ifcScgAmt[i]);
				if (othersScgAmtPrevious[i] != null)
					model.setOthersScgAmtPrevious(othersScgAmtPrevious[i]);
				if (ifcScgAmtPrevious[i] != null)
					model.setIfcScgAmtPrevious(ifcScgAmtPrevious[i]);
				if (oftAmt[i] != null)
					model.setOftAmt(oftAmt[i]);
				if (contractNm[i] != null)
					model.setContractNm(contractNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (bucScgAmt[i] != null)
					model.setBucScgAmt(bucScgAmt[i]);
				if (pscScgAmt[i] != null)
					model.setPscScgAmt(pscScgAmt[i]);
				if (ifcScgAmtDiff[i] != null)
					model.setIfcScgAmtDiff(ifcScgAmtDiff[i]);
				if (propOfcNm[i] != null)
					model.setPropOfcNm(propOfcNm[i]);
				if (gRevDiff[i] != null)
					model.setGRevDiff(gRevDiff[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (othersScgAmtDiff[i] != null)
					model.setOthersScgAmtDiff(othersScgAmtDiff[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (loadDiff[i] != null)
					model.setLoadDiff(loadDiff[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (bucScgAmtPrevious[i] != null)
					model.setBucScgAmtPrevious(bucScgAmtPrevious[i]);
				if (othersScgAmt[i] != null)
					model.setOthersScgAmt(othersScgAmt[i]);
				if (oftAmtDiff[i] != null)
					model.setOftAmtDiff(oftAmtDiff[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsProposalSummaryRevenueDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsProposalSummaryRevenueDetailVO[]
	 */
	public RsltPrsProposalSummaryRevenueDetailVO[] getRsltPrsProposalSummaryRevenueDetailVOs(){
		RsltPrsProposalSummaryRevenueDetailVO[] vos = (RsltPrsProposalSummaryRevenueDetailVO[])models.toArray(new RsltPrsProposalSummaryRevenueDetailVO[models.size()]);
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
		this.loadNew = this.loadNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmtPrevious = this.oftAmtPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRev = this.gRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRevPrevious = this.gRevPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucScgAmtDiff = this.bucScgAmtDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscScgAmtDiff = this.pscScgAmtDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadPrevious = this.loadPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscScgAmtPrevious = this.pscScgAmtPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcScgAmt = this.ifcScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othersScgAmtPrevious = this.othersScgAmtPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcScgAmtPrevious = this.ifcScgAmtPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmt = this.oftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNm = this.contractNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucScgAmt = this.bucScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscScgAmt = this.pscScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifcScgAmtDiff = this.ifcScgAmtDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcNm = this.propOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRevDiff = this.gRevDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othersScgAmtDiff = this.othersScgAmtDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadDiff = this.loadDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bucScgAmtPrevious = this.bucScgAmtPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othersScgAmt = this.othersScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmtDiff = this.oftAmtDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
