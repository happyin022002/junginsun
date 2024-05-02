/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EasPayrInfoVO.java
*@FileTitle : EasPayrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate :2013.09.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.11 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EasPayrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EasPayrInfoVO> models = new ArrayList<EasPayrInfoVO>();
	
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String issDivNm = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String easPayrOtsRmk = null;
	/* Column Info */
	private String jobTp = null;
	/* Column Info */
	private String payrNm = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String n3rdEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String easPayrVndrFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String n2ndEml = null;
	/* Column Info */
	private String cntcPntFaxNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cntcPntPhnNo = null;
	/* Column Info */
	private String n1stEml = null;
	/* Column Info */
	private String cntcPntNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String zipCdCtnt = null;
	/* Column Info */
	private String custCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EasPayrInfoVO() {}

	public EasPayrInfoVO(String ibflag, String pagerows, String svrId, String custCd, String custCntCd, String custSeq, String custRgstNo, String issDivNm, String payrNm, String custAddr, String zipCdCtnt, String cntcPntNm, String cntcPntPhnNo, String cntcPntFaxNo, String easPayrVndrFlg, String n1stEml, String n2ndEml, String n3rdEml, String easPayrOtsRmk, String creUsrId, String creOfcCd, String updUsrId, String updOfcCd, String ofcCd, String jobTp, String gubun) {
		this.gubun = gubun;
		this.issDivNm = issDivNm;
		this.custAddr = custAddr;
		this.easPayrOtsRmk = easPayrOtsRmk;
		this.jobTp = jobTp;
		this.payrNm = payrNm;
		this.custRgstNo = custRgstNo;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.n3rdEml = n3rdEml;
		this.ibflag = ibflag;
		this.easPayrVndrFlg = easPayrVndrFlg;
		this.creOfcCd = creOfcCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.n2ndEml = n2ndEml;
		this.cntcPntFaxNo = cntcPntFaxNo;
		this.custSeq = custSeq;
		this.cntcPntPhnNo = cntcPntPhnNo;
		this.n1stEml = n1stEml;
		this.cntcPntNm = cntcPntNm;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.zipCdCtnt = zipCdCtnt;
		this.custCd = custCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("iss_div_nm", getIssDivNm());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("eas_payr_ots_rmk", getEasPayrOtsRmk());
		this.hashColumns.put("job_tp", getJobTp());
		this.hashColumns.put("payr_nm", getPayrNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("n3rd_eml", getn3rdEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eas_payr_vndr_flg", getEasPayrVndrFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("n2nd_eml", getN2ndEml());
		this.hashColumns.put("cntc_pnt_fax_no", getCntcPntFaxNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntc_pnt_phn_no", getCntcPntPhnNo());
		this.hashColumns.put("n1st_eml", getN1stEml());
		this.hashColumns.put("cntc_pnt_nm", getCntcPntNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("zip_cd_ctnt", getZipCdCtnt());
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
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("eas_payr_ots_rmk", "easPayrOtsRmk");
		this.hashFields.put("job_tp", "jobTp");
		this.hashFields.put("payr_nm", "payrNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("n3rd_eml", "n3rdEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eas_payr_vndr_flg", "easPayrVndrFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("n2nd_eml", "n2ndEml");
		this.hashFields.put("cntc_pnt_fax_no", "cntcPntFaxNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntc_pnt_phn_no", "cntcPntPhnNo");
		this.hashFields.put("n1st_eml", "n1stEml");
		this.hashFields.put("cntc_pnt_nm", "cntcPntNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("zip_cd_ctnt", "zipCdCtnt");
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
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return easPayrOtsRmk
	 */
	public String getEasPayrOtsRmk() {
		return this.easPayrOtsRmk;
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
	 * @return payrNm
	 */
	public String getPayrNm() {
		return this.payrNm;
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
	 * @return n3rdEml
	 */
	public String getn3rdEml() {
		return this.n3rdEml;
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
	 * @return easPayrVndrFlg
	 */
	public String getEasPayrVndrFlg() {
		return this.easPayrVndrFlg;
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
	 * @return n2ndEml
	 */
	public String getN2ndEml() {
		return this.n2ndEml;
	}
	
	/**
	 * Column Info
	 * @return cntcPntFaxNo
	 */
	public String getCntcPntFaxNo() {
		return this.cntcPntFaxNo;
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
	 * @return cntcPntPhnNo
	 */
	public String getCntcPntPhnNo() {
		return this.cntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @return n1stEml
	 */
	public String getN1stEml() {
		return this.n1stEml;
	}
	
	/**
	 * Column Info
	 * @return cntcPntNm
	 */
	public String getCntcPntNm() {
		return this.cntcPntNm;
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
	 * @return zipCdCtnt
	 */
	public String getZipCdCtnt() {
		return this.zipCdCtnt;
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
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param easPayrOtsRmk
	 */
	public void setEasPayrOtsRmk(String easPayrOtsRmk) {
		this.easPayrOtsRmk = easPayrOtsRmk;
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
	 * @param payrNm
	 */
	public void setPayrNm(String payrNm) {
		this.payrNm = payrNm;
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
	 * @param n3rdEml
	 */
	public void setN3rdEml(String n3rdEml) {
		this.n3rdEml = n3rdEml;
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
	 * @param easPayrVndrFlg
	 */
	public void setEasPayrVndrFlg(String easPayrVndrFlg) {
		this.easPayrVndrFlg = easPayrVndrFlg;
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
	 * @param n2ndEml
	 */
	public void setN2ndEml(String n2ndEml) {
		this.n2ndEml = n2ndEml;
	}
	
	/**
	 * Column Info
	 * @param cntcPntFaxNo
	 */
	public void setCntcPntFaxNo(String cntcPntFaxNo) {
		this.cntcPntFaxNo = cntcPntFaxNo;
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
	 * @param cntcPntPhnNo
	 */
	public void setCntcPntPhnNo(String cntcPntPhnNo) {
		this.cntcPntPhnNo = cntcPntPhnNo;
	}
	
	/**
	 * Column Info
	 * @param n1stEml
	 */
	public void setN1stEml(String n1stEml) {
		this.n1stEml = n1stEml;
	}
	
	/**
	 * Column Info
	 * @param cntcPntNm
	 */
	public void setCntcPntNm(String cntcPntNm) {
		this.cntcPntNm = cntcPntNm;
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
	 * @param zipCdCtnt
	 */
	public void setZipCdCtnt(String zipCdCtnt) {
		this.zipCdCtnt = zipCdCtnt;
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
		setCustAddr(JSPUtil.getParameter(request, "cust_addr", ""));
		setEasPayrOtsRmk(JSPUtil.getParameter(request, "eas_payr_ots_rmk", ""));
		setJobTp(JSPUtil.getParameter(request, "job_tp", ""));
		setPayrNm(JSPUtil.getParameter(request, "payr_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setN3rdEml(JSPUtil.getParameter(request, "n3rd_eml", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEasPayrVndrFlg(JSPUtil.getParameter(request, "eas_payr_vndr_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setN2ndEml(JSPUtil.getParameter(request, "n2nd_eml", ""));
		setCntcPntFaxNo(JSPUtil.getParameter(request, "cntc_pnt_fax_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCntcPntPhnNo(JSPUtil.getParameter(request, "cntc_pnt_phn_no", ""));
		setN1stEml(JSPUtil.getParameter(request, "n1st_eml", ""));
		setCntcPntNm(JSPUtil.getParameter(request, "cntc_pnt_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setZipCdCtnt(JSPUtil.getParameter(request, "zip_cd_ctnt", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EasPayrInfoVO[]
	 */
	public EasPayrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EasPayrInfoVO[]
	 */
	public EasPayrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EasPayrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] issDivNm = (JSPUtil.getParameter(request, prefix	+ "iss_div_nm", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] easPayrOtsRmk = (JSPUtil.getParameter(request, prefix	+ "eas_payr_ots_rmk", length));
			String[] jobTp = (JSPUtil.getParameter(request, prefix	+ "job_tp", length));
			String[] payrNm = (JSPUtil.getParameter(request, prefix	+ "payr_nm", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] n3rdEml = (JSPUtil.getParameter(request, prefix	+ "n3rd_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] easPayrVndrFlg = (JSPUtil.getParameter(request, prefix	+ "eas_payr_vndr_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] n2ndEml = (JSPUtil.getParameter(request, prefix	+ "n2nd_eml", length));
			String[] cntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_fax_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_phn_no", length));
			String[] n1stEml = (JSPUtil.getParameter(request, prefix	+ "n1st_eml", length));
			String[] cntcPntNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] zipCdCtnt = (JSPUtil.getParameter(request, prefix	+ "zip_cd_ctnt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EasPayrInfoVO();
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (issDivNm[i] != null)
					model.setIssDivNm(issDivNm[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (easPayrOtsRmk[i] != null)
					model.setEasPayrOtsRmk(easPayrOtsRmk[i]);
				if (jobTp[i] != null)
					model.setJobTp(jobTp[i]);
				if (payrNm[i] != null)
					model.setPayrNm(payrNm[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (n3rdEml[i] != null)
					model.setN3rdEml(n3rdEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (easPayrVndrFlg[i] != null)
					model.setEasPayrVndrFlg(easPayrVndrFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (n2ndEml[i] != null)
					model.setN2ndEml(n2ndEml[i]);
				if (cntcPntFaxNo[i] != null)
					model.setCntcPntFaxNo(cntcPntFaxNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cntcPntPhnNo[i] != null)
					model.setCntcPntPhnNo(cntcPntPhnNo[i]);
				if (n1stEml[i] != null)
					model.setN1stEml(n1stEml[i]);
				if (cntcPntNm[i] != null)
					model.setCntcPntNm(cntcPntNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (zipCdCtnt[i] != null)
					model.setZipCdCtnt(zipCdCtnt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEasPayrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EasPayrInfoVO[]
	 */
	public EasPayrInfoVO[] getEasPayrInfoVOs(){
		EasPayrInfoVO[] vos = (EasPayrInfoVO[])models.toArray(new EasPayrInfoVO[models.size()]);
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
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.easPayrOtsRmk = this.easPayrOtsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobTp = this.jobTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrNm = this.payrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdEml = this.n3rdEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.easPayrVndrFlg = this.easPayrVndrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndEml = this.n2ndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntFaxNo = this.cntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntPhnNo = this.cntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stEml = this.n1stEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntNm = this.cntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCdCtnt = this.zipCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
