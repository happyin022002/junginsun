/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnApprovalCsrVO.java
*@FileTitle : UnApprovalCsrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.approval.vo;

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
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnApprovalCsrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnApprovalCsrVO> models = new ArrayList<UnApprovalCsrVO>();
	
	/* Column Info */
	private String aproTtlAmt = null;
	/* Column Info */
	private String apstsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invEffDt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String ofcNm = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agmtDocCfmCd = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String fileUpldFlg = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String asaAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtFileCfmCd = null;
	/* Column Info */
	private String invKnt = null;
	/* Column Info */
	private String payDueDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String rqstStDt = null;
	/* Column Info */
	private String crntAproSeq = null;
	/* Column Info */
	private String appyn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UnApprovalCsrVO() {}

	public UnApprovalCsrVO(String ibflag, String pagerows, String glDt, String currCd, String subSysCd, String crntAproSeq, String creDt, String aproUsrNm, String aproOfcCd, String rqstStDt, String usrNm, String payDueDt, String invKnt, String invEffDt, String invDt, String aproRmk, String csrNo, String costOfcCd, String arHdQtrOfcCd, String agmtFileCfmCd, String appyn, String fileUpldFlg, String ofcNm, String ofcCd, String creUsrId, String aproRqstNo, String aproUsrId, String aproTtlAmt, String vndrSeq, String agmtDocCfmCd, String apstsCd, String asaNo, String asaAmt) {
		this.aproTtlAmt = aproTtlAmt;
		this.apstsCd = apstsCd;
		this.ibflag = ibflag;
		this.invEffDt = invEffDt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.aproUsrId = aproUsrId;
		this.ofcNm = ofcNm;
		this.aproOfcCd = aproOfcCd;
		this.csrNo = csrNo;
		this.subSysCd = subSysCd;
		this.creUsrId = creUsrId;
		this.agmtDocCfmCd = agmtDocCfmCd;
		this.aproRmk = aproRmk;
		this.usrNm = usrNm;
		this.fileUpldFlg = fileUpldFlg;
		this.invDt = invDt;
		this.asaNo = asaNo;
		this.asaAmt = asaAmt;
		this.pagerows = pagerows;
		this.costOfcCd = costOfcCd;
		this.ofcCd = ofcCd;
		this.aproUsrNm = aproUsrNm;
		this.glDt = glDt;
		this.currCd = currCd;
		this.creDt = creDt;
		this.agmtFileCfmCd = agmtFileCfmCd;
		this.invKnt = invKnt;
		this.payDueDt = payDueDt;
		this.vndrSeq = vndrSeq;
		this.aproRqstNo = aproRqstNo;
		this.rqstStDt = rqstStDt;
		this.crntAproSeq = crntAproSeq;
		this.appyn = appyn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_ttl_amt", getAproTtlAmt());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_eff_dt", getInvEffDt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("ofc_nm", getOfcNm());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agmt_doc_cfm_cd", getAgmtDocCfmCd());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("file_upld_flg", getFileUpldFlg());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("asa_amt", getAsaAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_file_cfm_cd", getAgmtFileCfmCd());
		this.hashColumns.put("inv_knt", getInvKnt());
		this.hashColumns.put("pay_due_dt", getPayDueDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("rqst_st_dt", getRqstStDt());
		this.hashColumns.put("crnt_apro_seq", getCrntAproSeq());
		this.hashColumns.put("appyn", getAppyn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_ttl_amt", "aproTtlAmt");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_eff_dt", "invEffDt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("ofc_nm", "ofcNm");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_doc_cfm_cd", "agmtDocCfmCd");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("file_upld_flg", "fileUpldFlg");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("asa_amt", "asaAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_file_cfm_cd", "agmtFileCfmCd");
		this.hashFields.put("inv_knt", "invKnt");
		this.hashFields.put("pay_due_dt", "payDueDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("crnt_apro_seq", "crntAproSeq");
		this.hashFields.put("appyn", "appyn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproTtlAmt
	 */
	public String getAproTtlAmt() {
		return this.aproTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return apstsCd
	 */
	public String getApstsCd() {
		return this.apstsCd;
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
	 * @return invEffDt
	 */
	public String getInvEffDt() {
		return this.invEffDt;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return ofcNm
	 */
	public String getOfcNm() {
		return this.ofcNm;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
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
	 * @return agmtDocCfmCd
	 */
	public String getAgmtDocCfmCd() {
		return this.agmtDocCfmCd;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return fileUpldFlg
	 */
	public String getFileUpldFlg() {
		return this.fileUpldFlg;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return asaAmt
	 */
	public String getAsaAmt() {
		return this.asaAmt;
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
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return agmtFileCfmCd
	 */
	public String getAgmtFileCfmCd() {
		return this.agmtFileCfmCd;
	}
	
	/**
	 * Column Info
	 * @return invKnt
	 */
	public String getInvKnt() {
		return this.invKnt;
	}
	
	/**
	 * Column Info
	 * @return payDueDt
	 */
	public String getPayDueDt() {
		return this.payDueDt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return rqstStDt
	 */
	public String getRqstStDt() {
		return this.rqstStDt;
	}
	
	/**
	 * Column Info
	 * @return crntAproSeq
	 */
	public String getCrntAproSeq() {
		return this.crntAproSeq;
	}
	
	/**
	 * Column Info
	 * @return appyn
	 */
	public String getAppyn() {
		return this.appyn;
	}
	

	/**
	 * Column Info
	 * @param aproTtlAmt
	 */
	public void setAproTtlAmt(String aproTtlAmt) {
		this.aproTtlAmt = aproTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param apstsCd
	 */
	public void setApstsCd(String apstsCd) {
		this.apstsCd = apstsCd;
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
	 * @param invEffDt
	 */
	public void setInvEffDt(String invEffDt) {
		this.invEffDt = invEffDt;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param ofcNm
	 */
	public void setOfcNm(String ofcNm) {
		this.ofcNm = ofcNm;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
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
	 * @param agmtDocCfmCd
	 */
	public void setAgmtDocCfmCd(String agmtDocCfmCd) {
		this.agmtDocCfmCd = agmtDocCfmCd;
	}
	
	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param fileUpldFlg
	 */
	public void setFileUpldFlg(String fileUpldFlg) {
		this.fileUpldFlg = fileUpldFlg;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param asaAmt
	 */
	public void setAsaAmt(String asaAmt) {
		this.asaAmt = asaAmt;
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
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param agmtFileCfmCd
	 */
	public void setAgmtFileCfmCd(String agmtFileCfmCd) {
		this.agmtFileCfmCd = agmtFileCfmCd;
	}
	
	/**
	 * Column Info
	 * @param invKnt
	 */
	public void setInvKnt(String invKnt) {
		this.invKnt = invKnt;
	}
	
	/**
	 * Column Info
	 * @param payDueDt
	 */
	public void setPayDueDt(String payDueDt) {
		this.payDueDt = payDueDt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param rqstStDt
	 */
	public void setRqstStDt(String rqstStDt) {
		this.rqstStDt = rqstStDt;
	}
	
	/**
	 * Column Info
	 * @param crntAproSeq
	 */
	public void setCrntAproSeq(String crntAproSeq) {
		this.crntAproSeq = crntAproSeq;
	}
	
	/**
	 * Column Info
	 * @param appyn
	 */
	public void setAppyn(String appyn) {
		this.appyn = appyn;
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
		setAproTtlAmt(JSPUtil.getParameter(request, prefix + "apro_ttl_amt", ""));
		setApstsCd(JSPUtil.getParameter(request, prefix + "apsts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvEffDt(JSPUtil.getParameter(request, prefix + "inv_eff_dt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setOfcNm(JSPUtil.getParameter(request, prefix + "ofc_nm", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setSubSysCd(JSPUtil.getParameter(request, prefix + "sub_sys_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAgmtDocCfmCd(JSPUtil.getParameter(request, prefix + "agmt_doc_cfm_cd", ""));
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setFileUpldFlg(JSPUtil.getParameter(request, prefix + "file_upld_flg", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setAsaAmt(JSPUtil.getParameter(request, prefix + "asa_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAgmtFileCfmCd(JSPUtil.getParameter(request, prefix + "agmt_file_cfm_cd", ""));
		setInvKnt(JSPUtil.getParameter(request, prefix + "inv_knt", ""));
		setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setRqstStDt(JSPUtil.getParameter(request, prefix + "rqst_st_dt", ""));
		setCrntAproSeq(JSPUtil.getParameter(request, prefix + "crnt_apro_seq", ""));
		setAppyn(JSPUtil.getParameter(request, prefix + "appyn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnApprovalCsrVO[]
	 */
	public UnApprovalCsrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnApprovalCsrVO[]
	 */
	public UnApprovalCsrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnApprovalCsrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproTtlAmt = (JSPUtil.getParameter(request, prefix	+ "apro_ttl_amt", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invEffDt = (JSPUtil.getParameter(request, prefix	+ "inv_eff_dt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] ofcNm = (JSPUtil.getParameter(request, prefix	+ "ofc_nm", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agmtDocCfmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_doc_cfm_cd", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] fileUpldFlg = (JSPUtil.getParameter(request, prefix	+ "file_upld_flg", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] asaAmt = (JSPUtil.getParameter(request, prefix	+ "asa_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtFileCfmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_file_cfm_cd", length));
			String[] invKnt = (JSPUtil.getParameter(request, prefix	+ "inv_knt", length));
			String[] payDueDt = (JSPUtil.getParameter(request, prefix	+ "pay_due_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] rqstStDt = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt", length));
			String[] crntAproSeq = (JSPUtil.getParameter(request, prefix	+ "crnt_apro_seq", length));
			String[] appyn = (JSPUtil.getParameter(request, prefix	+ "appyn", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnApprovalCsrVO();
				if (aproTtlAmt[i] != null)
					model.setAproTtlAmt(aproTtlAmt[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invEffDt[i] != null)
					model.setInvEffDt(invEffDt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (ofcNm[i] != null)
					model.setOfcNm(ofcNm[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agmtDocCfmCd[i] != null)
					model.setAgmtDocCfmCd(agmtDocCfmCd[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (fileUpldFlg[i] != null)
					model.setFileUpldFlg(fileUpldFlg[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (asaAmt[i] != null)
					model.setAsaAmt(asaAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtFileCfmCd[i] != null)
					model.setAgmtFileCfmCd(agmtFileCfmCd[i]);
				if (invKnt[i] != null)
					model.setInvKnt(invKnt[i]);
				if (payDueDt[i] != null)
					model.setPayDueDt(payDueDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (rqstStDt[i] != null)
					model.setRqstStDt(rqstStDt[i]);
				if (crntAproSeq[i] != null)
					model.setCrntAproSeq(crntAproSeq[i]);
				if (appyn[i] != null)
					model.setAppyn(appyn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnApprovalCsrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnApprovalCsrVO[]
	 */
	public UnApprovalCsrVO[] getUnApprovalCsrVOs(){
		UnApprovalCsrVO[] vos = (UnApprovalCsrVO[])models.toArray(new UnApprovalCsrVO[models.size()]);
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
		this.aproTtlAmt = this.aproTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffDt = this.invEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcNm = this.ofcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocCfmCd = this.agmtDocCfmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUpldFlg = this.fileUpldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaAmt = this.asaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFileCfmCd = this.agmtFileCfmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invKnt = this.invKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDueDt = this.payDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt = this.rqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAproSeq = this.crntAproSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appyn = this.appyn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
