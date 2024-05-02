/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtPayrInfoVO.java
*@FileTitle : DmtPayrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.26 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtPayrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtPayrInfoVO> models = new ArrayList<DmtPayrInfoVO>();
	
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String issDivNm = null;
	/* Column Info */
	private String dmdtPayrAddr = null;
	/* Column Info */
	private String dmdtPayrOtsRmk = null;
	/* Column Info */
	private String jobTp = null;
	/* Column Info */
	private String dmdtPayrNm = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String dmdtPayrN3rdEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtPayrVndrFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String dmdtPayrN2ndEml = null;
	/* Column Info */
	private String dmdtPayrFaxNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String dmdtPayrPhnNo = null;
	/* Column Info */
	private String dmdtPayrN1stEml = null;
	/* Column Info */
	private String dmdtPayrCntcPntNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dmdtPayrZipCtnt = null;
	/* Column Info */
	private String custCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtPayrInfoVO() {}

	public DmtPayrInfoVO(String ibflag, String pagerows, String svrId, String custCd, String custCntCd, String custSeq, String custRgstNo, String issDivNm, String dmdtPayrNm, String dmdtPayrAddr, String dmdtPayrZipCtnt, String dmdtPayrCntcPntNm, String dmdtPayrPhnNo, String dmdtPayrFaxNo, String dmdtPayrVndrFlg, String dmdtPayrN1stEml, String dmdtPayrN2ndEml, String dmdtPayrN3rdEml, String dmdtPayrOtsRmk, String creUsrId, String creOfcCd, String updUsrId, String updOfcCd, String ofcCd, String jobTp, String gubun) {
		this.gubun = gubun;
		this.issDivNm = issDivNm;
		this.dmdtPayrAddr = dmdtPayrAddr;
		this.dmdtPayrOtsRmk = dmdtPayrOtsRmk;
		this.jobTp = jobTp;
		this.dmdtPayrNm = dmdtPayrNm;
		this.custRgstNo = custRgstNo;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.dmdtPayrN3rdEml = dmdtPayrN3rdEml;
		this.ibflag = ibflag;
		this.dmdtPayrVndrFlg = dmdtPayrVndrFlg;
		this.creOfcCd = creOfcCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.dmdtPayrN2ndEml = dmdtPayrN2ndEml;
		this.dmdtPayrFaxNo = dmdtPayrFaxNo;
		this.custSeq = custSeq;
		this.dmdtPayrPhnNo = dmdtPayrPhnNo;
		this.dmdtPayrN1stEml = dmdtPayrN1stEml;
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.dmdtPayrZipCtnt = dmdtPayrZipCtnt;
		this.custCd = custCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("iss_div_nm", getIssDivNm());
		this.hashColumns.put("dmdt_payr_addr", getDmdtPayrAddr());
		this.hashColumns.put("dmdt_payr_ots_rmk", getDmdtPayrOtsRmk());
		this.hashColumns.put("job_tp", getJobTp());
		this.hashColumns.put("dmdt_payr_nm", getDmdtPayrNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("dmdt_payr_n3rd_eml", getDmdtPayrN3rdEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_payr_vndr_flg", getDmdtPayrVndrFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("dmdt_payr_n2nd_eml", getDmdtPayrN2ndEml());
		this.hashColumns.put("dmdt_payr_fax_no", getDmdtPayrFaxNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("dmdt_payr_phn_no", getDmdtPayrPhnNo());
		this.hashColumns.put("dmdt_payr_n1st_eml", getDmdtPayrN1stEml());
		this.hashColumns.put("dmdt_payr_cntc_pnt_nm", getDmdtPayrCntcPntNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dmdt_payr_zip_ctnt", getDmdtPayrZipCtnt());
		this.hashColumns.put("cust_cd", getCustCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("iss_div_nm", "issDivNm");
		this.hashFields.put("dmdt_payr_addr", "dmdtPayrAddr");
		this.hashFields.put("dmdt_payr_ots_rmk", "dmdtPayrOtsRmk");
		this.hashFields.put("job_tp", "jobTp");
		this.hashFields.put("dmdt_payr_nm", "dmdtPayrNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("dmdt_payr_n3rd_eml", "dmdtPayrN3rdEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_payr_vndr_flg", "dmdtPayrVndrFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("dmdt_payr_n2nd_eml", "dmdtPayrN2ndEml");
		this.hashFields.put("dmdt_payr_fax_no", "dmdtPayrFaxNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("dmdt_payr_phn_no", "dmdtPayrPhnNo");
		this.hashFields.put("dmdt_payr_n1st_eml", "dmdtPayrN1stEml");
		this.hashFields.put("dmdt_payr_cntc_pnt_nm", "dmdtPayrCntcPntNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dmdt_payr_zip_ctnt", "dmdtPayrZipCtnt");
		this.hashFields.put("cust_cd", "custCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return issDivNm
	 */
	public String getIssDivNm() {
		return this.issDivNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrAddr
	 */
	public String getDmdtPayrAddr() {
		return this.dmdtPayrAddr;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrOtsRmk
	 */
	public String getDmdtPayrOtsRmk() {
		return this.dmdtPayrOtsRmk;
	}
	
	/**
	 * Column Info
	 * @return jobTp
	 */
	public String getJobTp() {
		return this.jobTp;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrNm
	 */
	public String getDmdtPayrNm() {
		return this.dmdtPayrNm;
	}
	
	/**
	 * Column Info
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
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
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrN3rdEml
	 */
	public String getDmdtPayrN3rdEml() {
		return this.dmdtPayrN3rdEml;
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
	 * @return dmdtPayrVndrFlg
	 */
	public String getDmdtPayrVndrFlg() {
		return this.dmdtPayrVndrFlg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrN2ndEml
	 */
	public String getDmdtPayrN2ndEml() {
		return this.dmdtPayrN2ndEml;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrFaxNo
	 */
	public String getDmdtPayrFaxNo() {
		return this.dmdtPayrFaxNo;
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
	 * @return dmdtPayrPhnNo
	 */
	public String getDmdtPayrPhnNo() {
		return this.dmdtPayrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrN1stEml
	 */
	public String getDmdtPayrN1stEml() {
		return this.dmdtPayrN1stEml;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrCntcPntNm
	 */
	public String getDmdtPayrCntcPntNm() {
		return this.dmdtPayrCntcPntNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrZipCtnt
	 */
	public String getDmdtPayrZipCtnt() {
		return this.dmdtPayrZipCtnt;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param issDivNm
	 */
	public void setIssDivNm(String issDivNm) {
		this.issDivNm = issDivNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrAddr
	 */
	public void setDmdtPayrAddr(String dmdtPayrAddr) {
		this.dmdtPayrAddr = dmdtPayrAddr;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrOtsRmk
	 */
	public void setDmdtPayrOtsRmk(String dmdtPayrOtsRmk) {
		this.dmdtPayrOtsRmk = dmdtPayrOtsRmk;
	}
	
	/**
	 * Column Info
	 * @param jobTp
	 */
	public void setJobTp(String jobTp) {
		this.jobTp = jobTp;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrNm
	 */
	public void setDmdtPayrNm(String dmdtPayrNm) {
		this.dmdtPayrNm = dmdtPayrNm;
	}
	
	/**
	 * Column Info
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrN3rdEml
	 */
	public void setDmdtPayrN3rdEml(String dmdtPayrN3rdEml) {
		this.dmdtPayrN3rdEml = dmdtPayrN3rdEml;
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
	 * @param dmdtPayrVndrFlg
	 */
	public void setDmdtPayrVndrFlg(String dmdtPayrVndrFlg) {
		this.dmdtPayrVndrFlg = dmdtPayrVndrFlg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrN2ndEml
	 */
	public void setDmdtPayrN2ndEml(String dmdtPayrN2ndEml) {
		this.dmdtPayrN2ndEml = dmdtPayrN2ndEml;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrFaxNo
	 */
	public void setDmdtPayrFaxNo(String dmdtPayrFaxNo) {
		this.dmdtPayrFaxNo = dmdtPayrFaxNo;
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
	 * @param dmdtPayrPhnNo
	 */
	public void setDmdtPayrPhnNo(String dmdtPayrPhnNo) {
		this.dmdtPayrPhnNo = dmdtPayrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrN1stEml
	 */
	public void setDmdtPayrN1stEml(String dmdtPayrN1stEml) {
		this.dmdtPayrN1stEml = dmdtPayrN1stEml;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrCntcPntNm
	 */
	public void setDmdtPayrCntcPntNm(String dmdtPayrCntcPntNm) {
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrZipCtnt
	 */
	public void setDmdtPayrZipCtnt(String dmdtPayrZipCtnt) {
		this.dmdtPayrZipCtnt = dmdtPayrZipCtnt;
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
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setIssDivNm(JSPUtil.getParameter(request, "iss_div_nm", ""));
		setDmdtPayrAddr(JSPUtil.getParameter(request, "dmdt_payr_addr", ""));
		setDmdtPayrOtsRmk(JSPUtil.getParameter(request, "dmdt_payr_ots_rmk", ""));
		setJobTp(JSPUtil.getParameter(request, "job_tp", ""));
		setDmdtPayrNm(JSPUtil.getParameter(request, "dmdt_payr_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setDmdtPayrN3rdEml(JSPUtil.getParameter(request, "dmdt_payr_n3rd_eml", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtPayrVndrFlg(JSPUtil.getParameter(request, "dmdt_payr_vndr_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setDmdtPayrN2ndEml(JSPUtil.getParameter(request, "dmdt_payr_n2nd_eml", ""));
		setDmdtPayrFaxNo(JSPUtil.getParameter(request, "dmdt_payr_fax_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setDmdtPayrPhnNo(JSPUtil.getParameter(request, "dmdt_payr_phn_no", ""));
		setDmdtPayrN1stEml(JSPUtil.getParameter(request, "dmdt_payr_n1st_eml", ""));
		setDmdtPayrCntcPntNm(JSPUtil.getParameter(request, "dmdt_payr_cntc_pnt_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDmdtPayrZipCtnt(JSPUtil.getParameter(request, "dmdt_payr_zip_ctnt", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtPayrInfoVO[]
	 */
	public DmtPayrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtPayrInfoVO[]
	 */
	public DmtPayrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtPayrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] issDivNm = (JSPUtil.getParameter(request, prefix	+ "iss_div_nm", length));
			String[] dmdtPayrAddr = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_addr", length));
			String[] dmdtPayrOtsRmk = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_ots_rmk", length));
			String[] jobTp = (JSPUtil.getParameter(request, prefix	+ "job_tp", length));
			String[] dmdtPayrNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_nm", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] dmdtPayrN3rdEml = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_n3rd_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtPayrVndrFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_vndr_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] dmdtPayrN2ndEml = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_n2nd_eml", length));
			String[] dmdtPayrFaxNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_fax_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] dmdtPayrPhnNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_phn_no", length));
			String[] dmdtPayrN1stEml = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_n1st_eml", length));
			String[] dmdtPayrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_cntc_pnt_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dmdtPayrZipCtnt = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_zip_ctnt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtPayrInfoVO();
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (issDivNm[i] != null)
					model.setIssDivNm(issDivNm[i]);
				if (dmdtPayrAddr[i] != null)
					model.setDmdtPayrAddr(dmdtPayrAddr[i]);
				if (dmdtPayrOtsRmk[i] != null)
					model.setDmdtPayrOtsRmk(dmdtPayrOtsRmk[i]);
				if (jobTp[i] != null)
					model.setJobTp(jobTp[i]);
				if (dmdtPayrNm[i] != null)
					model.setDmdtPayrNm(dmdtPayrNm[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (dmdtPayrN3rdEml[i] != null)
					model.setDmdtPayrN3rdEml(dmdtPayrN3rdEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtPayrVndrFlg[i] != null)
					model.setDmdtPayrVndrFlg(dmdtPayrVndrFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (dmdtPayrN2ndEml[i] != null)
					model.setDmdtPayrN2ndEml(dmdtPayrN2ndEml[i]);
				if (dmdtPayrFaxNo[i] != null)
					model.setDmdtPayrFaxNo(dmdtPayrFaxNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (dmdtPayrPhnNo[i] != null)
					model.setDmdtPayrPhnNo(dmdtPayrPhnNo[i]);
				if (dmdtPayrN1stEml[i] != null)
					model.setDmdtPayrN1stEml(dmdtPayrN1stEml[i]);
				if (dmdtPayrCntcPntNm[i] != null)
					model.setDmdtPayrCntcPntNm(dmdtPayrCntcPntNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dmdtPayrZipCtnt[i] != null)
					model.setDmdtPayrZipCtnt(dmdtPayrZipCtnt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtPayrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtPayrInfoVO[]
	 */
	public DmtPayrInfoVO[] getDmtPayrInfoVOs(){
		DmtPayrInfoVO[] vos = (DmtPayrInfoVO[])models.toArray(new DmtPayrInfoVO[models.size()]);
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
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivNm = this.issDivNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrAddr = this.dmdtPayrAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrOtsRmk = this.dmdtPayrOtsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobTp = this.jobTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrNm = this.dmdtPayrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrN3rdEml = this.dmdtPayrN3rdEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrVndrFlg = this.dmdtPayrVndrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrN2ndEml = this.dmdtPayrN2ndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrFaxNo = this.dmdtPayrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrPhnNo = this.dmdtPayrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrN1stEml = this.dmdtPayrN1stEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrCntcPntNm = this.dmdtPayrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrZipCtnt = this.dmdtPayrZipCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
