/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtComRDFaxEmailSendInfoVO.java
*@FileTitle : DmtComRDFaxEmailSendInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.12.14 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtComRDFaxEmailSendInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtComRDFaxEmailSendInfoVO> models = new ArrayList<DmtComRDFaxEmailSendInfoVO>();
	
	/* Column Info */
	private String rdFxemlFaxSndrId = null;
	/* Column Info */
	private String rdFxemlTitle = null;
	/* Column Info */
	private String rdFxemlDocTp = null;
	/* Column Info */
	private String offcd = null;
	/* Column Info */
	private String rdFxemlEmlSndrAdd = null;
	/* Column Info */
	private String rdFxemlFileName = null;
	/* Column Info */
	private String rdFxemlBatFlg = null;
	/* Column Info */
	private String rdFxemlEmlAtchFile = null;
	/* Column Info */
	private String rdFxemlRdParam = null;
	/* Column Info */
	private String rdFxemlEmlRcvrAdd = null;
	/* Column Info */
	private String payc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rdFxemlEmlTmpltParam = null;
	/* Column Info */
	private String rdFxemlEmlCcrcvrAdd = null;
	/* Column Info */
	private String mailctnt = null;
	/* Column Info */
	private String rdFxemlEmlTemplt = null;
	/* Column Info */
	private String invno = null;
	/* Column Info */
	private String creof = null;
	/* Column Info */
	private String rdFxemlSysCd = null;
	/* Column Info */
	private String rdFxemlEmlSndrNm = null;
	/* Column Info */
	private String rdFxemlEmlBccrcvrAdd = null;
	/* Column Info */
	private String rdFxemlFaxNo = null;
	/* Column Info : case when should fix sender email */
	private String rdFxemlEmlSndrFixed = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtComRDFaxEmailSendInfoVO() {}

	public DmtComRDFaxEmailSendInfoVO(String ibflag, String pagerows, String rdFxemlFaxSndrId, String rdFxemlTitle, String rdFxemlDocTp, String offcd, String rdFxemlEmlSndrAdd, String rdFxemlFileName, String rdFxemlBatFlg, String rdFxemlEmlAtchFile, String rdFxemlRdParam, String rdFxemlEmlRcvrAdd, String rdFxemlEmlCcrcvrAdd, String rdFxemlEmlBccrcvrAdd, String payc, String rdFxemlEmlTmpltParam, String mailctnt, String rdFxemlEmlTemplt, String invno, String rdFxemlEmlSndrNm, String rdFxemlSysCd, String rdFxemlFaxNo, String creof, String rdFxemlEmlSndrFixed) {
		this.rdFxemlFaxSndrId = rdFxemlFaxSndrId;
		this.rdFxemlTitle = rdFxemlTitle;
		this.rdFxemlDocTp = rdFxemlDocTp;
		this.offcd = offcd;
		this.rdFxemlEmlSndrAdd = rdFxemlEmlSndrAdd;
		this.rdFxemlFileName = rdFxemlFileName;
		this.rdFxemlBatFlg = rdFxemlBatFlg;
		this.rdFxemlEmlAtchFile = rdFxemlEmlAtchFile;
		this.rdFxemlRdParam = rdFxemlRdParam;
		this.rdFxemlEmlRcvrAdd = rdFxemlEmlRcvrAdd;
		this.payc = payc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rdFxemlEmlTmpltParam = rdFxemlEmlTmpltParam;
		this.rdFxemlEmlCcrcvrAdd = rdFxemlEmlCcrcvrAdd;
		this.mailctnt = mailctnt;
		this.rdFxemlEmlTemplt = rdFxemlEmlTemplt;
		this.invno = invno;
		this.rdFxemlSysCd = rdFxemlSysCd;
		this.rdFxemlEmlSndrNm = rdFxemlEmlSndrNm;
		this.rdFxemlEmlBccrcvrAdd = rdFxemlEmlBccrcvrAdd;
		this.rdFxemlFaxNo = rdFxemlFaxNo;
		this.creof = creof;
		this.rdFxemlEmlSndrFixed = rdFxemlEmlSndrFixed;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rd_fxeml_fax_sndr_id", getRdFxemlFaxSndrId());
		this.hashColumns.put("rd_fxeml_title", getRdFxemlTitle());
		this.hashColumns.put("rd_fxeml_doc_tp", getRdFxemlDocTp());
		this.hashColumns.put("offcd", getOffcd());
		this.hashColumns.put("rd_fxeml_eml_sndr_add", getRdFxemlEmlSndrAdd());
		this.hashColumns.put("rd_fxeml_file_name", getRdFxemlFileName());
		this.hashColumns.put("rd_fxeml_bat_flg", getRdFxemlBatFlg());
		this.hashColumns.put("rd_fxeml_eml_atch_file", getRdFxemlEmlAtchFile());
		this.hashColumns.put("rd_fxeml_rd_param", getRdFxemlRdParam());
		this.hashColumns.put("rd_fxeml_eml_rcvr_add", getRdFxemlEmlRcvrAdd());
		this.hashColumns.put("payc", getPayc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rd_fxeml_eml_tmplt_param", getRdFxemlEmlTmpltParam());
		this.hashColumns.put("rd_fxeml_eml_ccrcvr_add", getRdFxemlEmlCcrcvrAdd());
		this.hashColumns.put("mailctnt", getMailctnt());
		this.hashColumns.put("rd_fxeml_eml_templt", getRdFxemlEmlTemplt());
		this.hashColumns.put("invno", getInvno());
		this.hashColumns.put("rd_fxeml_sys_cd", getRdFxemlSysCd());
		this.hashColumns.put("rd_fxeml_eml_sndr_nm", getRdFxemlEmlSndrNm());
		this.hashColumns.put("rd_fxeml_eml_bccrcvr_add", getRdFxemlEmlBccrcvrAdd());
		this.hashColumns.put("rd_fxeml_fax_no", getRdFxemlFaxNo());
		this.hashColumns.put("creof", getCreof());
		this.hashColumns.put("rd_fxeml_eml_sndr_fixed", getRdFxemlEmlSndrFixed());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rd_fxeml_fax_sndr_id", "rdFxemlFaxSndrId");
		this.hashFields.put("rd_fxeml_title", "rdFxemlTitle");
		this.hashFields.put("rd_fxeml_doc_tp", "rdFxemlDocTp");
		this.hashFields.put("offcd", "offcd");
		this.hashFields.put("rd_fxeml_eml_sndr_add", "rdFxemlEmlSndrAdd");
		this.hashFields.put("rd_fxeml_file_name", "rdFxemlFileName");
		this.hashFields.put("rd_fxeml_bat_flg", "rdFxemlBatFlg");
		this.hashFields.put("rd_fxeml_eml_atch_file", "rdFxemlEmlAtchFile");
		this.hashFields.put("rd_fxeml_rd_param", "rdFxemlRdParam");
		this.hashFields.put("rd_fxeml_eml_rcvr_add", "rdFxemlEmlRcvrAdd");
		this.hashFields.put("payc", "payc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rd_fxeml_eml_tmplt_param", "rdFxemlEmlTmpltParam");
		this.hashFields.put("rd_fxeml_eml_ccrcvr_add", "rdFxemlEmlCcrcvrAdd");
		this.hashFields.put("mailctnt", "mailctnt");
		this.hashFields.put("rd_fxeml_eml_templt", "rdFxemlEmlTemplt");
		this.hashFields.put("invno", "invno");
		this.hashFields.put("rd_fxeml_sys_cd", "rdFxemlSysCd");
		this.hashFields.put("rd_fxeml_eml_sndr_nm", "rdFxemlEmlSndrNm");
		this.hashFields.put("rd_fxeml_eml_bccrcvr_add", "rdFxemlEmlBccrcvrAdd");
		this.hashFields.put("rd_fxeml_fax_no", "rdFxemlFaxNo");
		this.hashFields.put("creof", "creof");
		this.hashFields.put("rd_fxeml_eml_sndr_fixed", "rdFxemlEmlSndrFixed");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlFaxSndrId
	 */
	public String getRdFxemlFaxSndrId() {
		return this.rdFxemlFaxSndrId;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlTitle
	 */
	public String getRdFxemlTitle() {
		return this.rdFxemlTitle;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlDocTp
	 */
	public String getRdFxemlDocTp() {
		return this.rdFxemlDocTp;
	}
	
	/**
	 * Column Info
	 * @return offcd
	 */
	public String getOffcd() {
		return this.offcd;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlSndrAdd
	 */
	public String getRdFxemlEmlSndrAdd() {
		return this.rdFxemlEmlSndrAdd;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlFileName
	 */
	public String getRdFxemlFileName() {
		return this.rdFxemlFileName;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlBatFlg
	 */
	public String getRdFxemlBatFlg() {
		return this.rdFxemlBatFlg;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlAtchFile
	 */
	public String getRdFxemlEmlAtchFile() {
		return this.rdFxemlEmlAtchFile;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlRdParam
	 */
	public String getRdFxemlRdParam() {
		return this.rdFxemlRdParam;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlRcvrAdd
	 */
	public String getRdFxemlEmlRcvrAdd() {
		return this.rdFxemlEmlRcvrAdd;
	}
	
	/**
	 * Column Info
	 * @return payc
	 */
	public String getPayc() {
		return this.payc;
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
	 * @return rdFxemlEmlTmpltParam
	 */
	public String getRdFxemlEmlTmpltParam() {
		return this.rdFxemlEmlTmpltParam;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlCcrcvrAdd
	 */
	public String getRdFxemlEmlCcrcvrAdd() {
		return this.rdFxemlEmlCcrcvrAdd;
	}
	
	/**
	 * Column Info
	 * @return mailctnt
	 */
	public String getMailctnt() {
		return this.mailctnt;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlTemplt
	 */
	public String getRdFxemlEmlTemplt() {
		return this.rdFxemlEmlTemplt;
	}
	
	/**
	 * Column Info
	 * @return invno
	 */
	public String getInvno() {
		return this.invno;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlSysCd
	 */
	public String getRdFxemlSysCd() {
		return this.rdFxemlSysCd;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlSndrNm
	 */
	public String getRdFxemlEmlSndrNm() {
		return this.rdFxemlEmlSndrNm;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlEmlBccrcvrAdd
	 */
	public String getRdFxemlEmlBccrcvrAdd() {
		return this.rdFxemlEmlBccrcvrAdd;
	}
	
	/**
	 * Column Info
	 * @return rdFxemlFaxNo
	 */
	public String getRdFxemlFaxNo() {
		return this.rdFxemlFaxNo;
	}
	
	public String getCreof() {
		return this.creof;
	}

	/**
	 * Column Info
	 * @param rdFxemlFaxSndrId
	 */
	public void setRdFxemlFaxSndrId(String rdFxemlFaxSndrId) {
		this.rdFxemlFaxSndrId = rdFxemlFaxSndrId;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlTitle
	 */
	public void setRdFxemlTitle(String rdFxemlTitle) {
		this.rdFxemlTitle = rdFxemlTitle;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlDocTp
	 */
	public void setRdFxemlDocTp(String rdFxemlDocTp) {
		this.rdFxemlDocTp = rdFxemlDocTp;
	}
	
	/**
	 * Column Info
	 * @param offcd
	 */
	public void setOffcd(String offcd) {
		this.offcd = offcd;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlSndrAdd
	 */
	public void setRdFxemlEmlSndrAdd(String rdFxemlEmlSndrAdd) {
		this.rdFxemlEmlSndrAdd = rdFxemlEmlSndrAdd;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlFileName
	 */
	public void setRdFxemlFileName(String rdFxemlFileName) {
		this.rdFxemlFileName = rdFxemlFileName;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlBatFlg
	 */
	public void setRdFxemlBatFlg(String rdFxemlBatFlg) {
		this.rdFxemlBatFlg = rdFxemlBatFlg;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlAtchFile
	 */
	public void setRdFxemlEmlAtchFile(String rdFxemlEmlAtchFile) {
		this.rdFxemlEmlAtchFile = rdFxemlEmlAtchFile;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlRdParam
	 */
	public void setRdFxemlRdParam(String rdFxemlRdParam) {
		this.rdFxemlRdParam = rdFxemlRdParam;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlRcvrAdd
	 */
	public void setRdFxemlEmlRcvrAdd(String rdFxemlEmlRcvrAdd) {
		this.rdFxemlEmlRcvrAdd = rdFxemlEmlRcvrAdd;
	}
	
	/**
	 * Column Info
	 * @param payc
	 */
	public void setPayc(String payc) {
		this.payc = payc;
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
	 * @param rdFxemlEmlTmpltParam
	 */
	public void setRdFxemlEmlTmpltParam(String rdFxemlEmlTmpltParam) {
		this.rdFxemlEmlTmpltParam = rdFxemlEmlTmpltParam;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlCcrcvrAdd
	 */
	public void setRdFxemlEmlCcrcvrAdd(String rdFxemlEmlCcrcvrAdd) {
		this.rdFxemlEmlCcrcvrAdd = rdFxemlEmlCcrcvrAdd;
	}
	
	/**
	 * Column Info
	 * @param mailctnt
	 */
	public void setMailctnt(String mailctnt) {
		this.mailctnt = mailctnt;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlTemplt
	 */
	public void setRdFxemlEmlTemplt(String rdFxemlEmlTemplt) {
		this.rdFxemlEmlTemplt = rdFxemlEmlTemplt;
	}
	
	/**
	 * Column Info
	 * @param invno
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlSysCd
	 */
	public void setRdFxemlSysCd(String rdFxemlSysCd) {
		this.rdFxemlSysCd = rdFxemlSysCd;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlSndrNm
	 */
	public void setRdFxemlEmlSndrNm(String rdFxemlEmlSndrNm) {
		this.rdFxemlEmlSndrNm = rdFxemlEmlSndrNm;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlEmlBccrcvrAdd
	 */
	public void setRdFxemlEmlBccrcvrAdd(String rdFxemlEmlBccrcvrAdd) {
		this.rdFxemlEmlBccrcvrAdd = rdFxemlEmlBccrcvrAdd;
	}
	
	/**
	 * Column Info
	 * @param rdFxemlFaxNo
	 */
	public void setRdFxemlFaxNo(String rdFxemlFaxNo) {
		this.rdFxemlFaxNo = rdFxemlFaxNo;
	}
	
	public void setCreof(String creof) {
		this.creof = creof;
	}

	public String getRdFxemlEmlSndrFixed() {
		return rdFxemlEmlSndrFixed;
	}

	public void setRdFxemlEmlSndrFixed(String rdFxemlEmlSndrFixed) {
		this.rdFxemlEmlSndrFixed = rdFxemlEmlSndrFixed;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRdFxemlFaxSndrId(JSPUtil.getParameter(request, "rd_fxeml_fax_sndr_id", ""));
		setRdFxemlTitle(JSPUtil.getParameter(request, "rd_fxeml_title", ""));
		setRdFxemlDocTp(JSPUtil.getParameter(request, "rd_fxeml_doc_tp", ""));
		setOffcd(JSPUtil.getParameter(request, "offcd", ""));
		setRdFxemlEmlSndrAdd(JSPUtil.getParameter(request, "rd_fxeml_eml_sndr_add", ""));
		setRdFxemlFileName(JSPUtil.getParameter(request, "rd_fxeml_file_name", ""));
		setRdFxemlBatFlg(JSPUtil.getParameter(request, "rd_fxeml_bat_flg", ""));
		setRdFxemlEmlAtchFile(JSPUtil.getParameter(request, "rd_fxeml_eml_atch_file", ""));
		setRdFxemlRdParam(JSPUtil.getParameter(request, "rd_fxeml_rd_param", ""));
		setRdFxemlEmlRcvrAdd(JSPUtil.getParameter(request, "rd_fxeml_eml_rcvr_add", ""));
		setPayc(JSPUtil.getParameter(request, "payc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRdFxemlEmlTmpltParam(JSPUtil.getParameter(request, "rd_fxeml_eml_tmplt_param", ""));
		setRdFxemlEmlCcrcvrAdd(JSPUtil.getParameter(request, "rd_fxeml_eml_ccrcvr_add", ""));
		setMailctnt(JSPUtil.getParameter(request, "mailctnt", ""));
		setRdFxemlEmlTemplt(JSPUtil.getParameter(request, "rd_fxeml_eml_templt", ""));
		setInvno(JSPUtil.getParameter(request, "invno", ""));
		setRdFxemlSysCd(JSPUtil.getParameter(request, "rd_fxeml_sys_cd", ""));
		setRdFxemlEmlSndrNm(JSPUtil.getParameter(request, "rd_fxeml_eml_sndr_nm", ""));
		setRdFxemlEmlBccrcvrAdd(JSPUtil.getParameter(request, "rd_fxeml_eml_bccrcvr_add", ""));
		setRdFxemlFaxNo(JSPUtil.getParameter(request, "rd_fxeml_fax_no", ""));
		setCreof(JSPUtil.getParameter(request, "creof", ""));
		setRdFxemlEmlSndrFixed(JSPUtil.getParameter(request, "rd_fxeml_eml_sndr_fixed", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtComRDFaxEmailSendInfoVO[]
	 */
	public DmtComRDFaxEmailSendInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtComRDFaxEmailSendInfoVO[]
	 */
	public DmtComRDFaxEmailSendInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtComRDFaxEmailSendInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rdFxemlFaxSndrId = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_fax_sndr_id", length));
			String[] rdFxemlTitle = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_title", length));
			String[] rdFxemlDocTp = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_doc_tp", length));
			String[] offcd = (JSPUtil.getParameter(request, prefix	+ "offcd", length));
			String[] rdFxemlEmlSndrAdd = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_sndr_add", length));
			String[] rdFxemlFileName = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_file_name", length));
			String[] rdFxemlBatFlg = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_bat_flg", length));
			String[] rdFxemlEmlAtchFile = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_atch_file", length));
			String[] rdFxemlRdParam = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_rd_param", length));
			String[] rdFxemlEmlRcvrAdd = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_rcvr_add", length));
			String[] payc = (JSPUtil.getParameter(request, prefix	+ "payc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rdFxemlEmlTmpltParam = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_tmplt_param", length));
			String[] rdFxemlEmlCcrcvrAdd = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_ccrcvr_add", length));
			String[] mailctnt = (JSPUtil.getParameter(request, prefix	+ "mailctnt", length));
			String[] rdFxemlEmlTemplt = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_templt", length));
			String[] invno = (JSPUtil.getParameter(request, prefix	+ "invno", length));
			String[] rdFxemlSysCd = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_sys_cd", length));
			String[] rdFxemlEmlSndrNm = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_sndr_nm", length));
			String[] rdFxemlEmlBccrcvrAdd = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_bccrcvr_add", length));
			String[] rdFxemlFaxNo = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_fax_no", length));
			String[] creof = (JSPUtil.getParameter(request, prefix	+ "creof", length));
			String[] rdFxemlEmlSndrFixed = (JSPUtil.getParameter(request, prefix	+ "rd_fxeml_eml_sndr_fixed", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtComRDFaxEmailSendInfoVO();
				if (rdFxemlFaxSndrId[i] != null)
					model.setRdFxemlFaxSndrId(rdFxemlFaxSndrId[i]);
				if (rdFxemlTitle[i] != null)
					model.setRdFxemlTitle(rdFxemlTitle[i]);
				if (rdFxemlDocTp[i] != null)
					model.setRdFxemlDocTp(rdFxemlDocTp[i]);
				if (offcd[i] != null)
					model.setOffcd(offcd[i]);
				if (rdFxemlEmlSndrAdd[i] != null)
					model.setRdFxemlEmlSndrAdd(rdFxemlEmlSndrAdd[i]);
				if (rdFxemlFileName[i] != null)
					model.setRdFxemlFileName(rdFxemlFileName[i]);
				if (rdFxemlBatFlg[i] != null)
					model.setRdFxemlBatFlg(rdFxemlBatFlg[i]);
				if (rdFxemlEmlAtchFile[i] != null)
					model.setRdFxemlEmlAtchFile(rdFxemlEmlAtchFile[i]);
				if (rdFxemlRdParam[i] != null)
					model.setRdFxemlRdParam(rdFxemlRdParam[i]);
				if (rdFxemlEmlRcvrAdd[i] != null)
					model.setRdFxemlEmlRcvrAdd(rdFxemlEmlRcvrAdd[i]);
				if (payc[i] != null)
					model.setPayc(payc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rdFxemlEmlTmpltParam[i] != null)
					model.setRdFxemlEmlTmpltParam(rdFxemlEmlTmpltParam[i]);
				if (rdFxemlEmlCcrcvrAdd[i] != null)
					model.setRdFxemlEmlCcrcvrAdd(rdFxemlEmlCcrcvrAdd[i]);
				if (mailctnt[i] != null)
					model.setMailctnt(mailctnt[i]);
				if (rdFxemlEmlTemplt[i] != null)
					model.setRdFxemlEmlTemplt(rdFxemlEmlTemplt[i]);
				if (invno[i] != null)
					model.setInvno(invno[i]);
				if (rdFxemlSysCd[i] != null)
					model.setRdFxemlSysCd(rdFxemlSysCd[i]);
				if (rdFxemlEmlSndrNm[i] != null)
					model.setRdFxemlEmlSndrNm(rdFxemlEmlSndrNm[i]);
				if (rdFxemlEmlBccrcvrAdd[i] != null)
					model.setRdFxemlEmlBccrcvrAdd(rdFxemlEmlBccrcvrAdd[i]);
				if (rdFxemlFaxNo[i] != null)
					model.setRdFxemlFaxNo(rdFxemlFaxNo[i]);
				if (creof[i] != null)
					model.setCreof(creof[i]);
				if (rdFxemlEmlSndrFixed[i] != null)
					model.setRdFxemlEmlSndrFixed(rdFxemlEmlSndrFixed[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtComRDFaxEmailSendInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtComRDFaxEmailSendInfoVO[]
	 */
	public DmtComRDFaxEmailSendInfoVO[] getDmtComRDFaxEmailSendInfoVOs(){
		DmtComRDFaxEmailSendInfoVO[] vos = (DmtComRDFaxEmailSendInfoVO[])models.toArray(new DmtComRDFaxEmailSendInfoVO[models.size()]);
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
		this.rdFxemlFaxSndrId = this.rdFxemlFaxSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlTitle = this.rdFxemlTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlDocTp = this.rdFxemlDocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offcd = this.offcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlSndrAdd = this.rdFxemlEmlSndrAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlFileName = this.rdFxemlFileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlBatFlg = this.rdFxemlBatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlAtchFile = this.rdFxemlEmlAtchFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlRdParam = this.rdFxemlRdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlRcvrAdd = this.rdFxemlEmlRcvrAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payc = this.payc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlTmpltParam = this.rdFxemlEmlTmpltParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlCcrcvrAdd = this.rdFxemlEmlCcrcvrAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mailctnt = this.mailctnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlTemplt = this.rdFxemlEmlTemplt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invno = this.invno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlSysCd = this.rdFxemlSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlSndrNm = this.rdFxemlEmlSndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlBccrcvrAdd = this.rdFxemlEmlBccrcvrAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlFaxNo = this.rdFxemlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creof = this.creof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFxemlEmlSndrFixed = this.rdFxemlEmlSndrFixed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
