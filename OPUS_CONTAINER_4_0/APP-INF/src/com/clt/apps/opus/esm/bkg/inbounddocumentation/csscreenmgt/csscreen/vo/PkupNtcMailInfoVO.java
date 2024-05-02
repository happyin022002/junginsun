/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PkupNtcMailInfoVO.java
*@FileTitle : PkupNtcMailInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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

public class PkupNtcMailInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcMailInfoVO> models = new ArrayList<PkupNtcMailInfoVO>();
	
	/* Column Info */
	private String pkupNtcFomCd = null;
	/* Column Info */
	private String emlSndRsltNm5 = null;
	/* Column Info */
	private String ntcEml1 = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String ntcEml2 = null;
	/* Column Info */
	private String ntcEml3 = null;
	/* Column Info */
	private String ntcEml4 = null;
	/* Column Info */
	private String ntcEml5 = null;
	/* Column Info */
	private String emlSndGdt = null;
	/* Column Info */
	private String emlSndRsltCd2 = null;
	/* Column Info */
	private String emlSndRsltCd1 = null;
	/* Column Info */
	private String emlSndRsltNm3 = null;
	/* Column Info */
	private String emlSndRsltCd4 = null;
	/* Column Info */
	private String emlSndRsltNm4 = null;
	/* Column Info */
	private String emlSndRsltCd3 = null;
	/* Column Info */
	private String emlSndRsltNm1 = null;
	/* Column Info */
	private String emlSndRsltNm2 = null;
	/* Column Info */
	private String emlSndRsltCd5 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pkupNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcMailInfoVO() {}

	public PkupNtcMailInfoVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String pkupNo, String pkupNtcFomCd, String diffRmk, String ntcEml1, String ntcEml2, String ntcEml3, String ntcEml4, String ntcEml5, String emlSndRsltCd1, String emlSndRsltCd2, String emlSndRsltCd3, String emlSndRsltCd4, String emlSndRsltCd5, String emlSndRsltNm1, String emlSndRsltNm2, String emlSndRsltNm3, String emlSndRsltNm4, String emlSndRsltNm5, String emlSndDt, String emlSndGdt) {
		this.pkupNtcFomCd = pkupNtcFomCd;
		this.emlSndRsltNm5 = emlSndRsltNm5;
		this.ntcEml1 = ntcEml1;
		this.emlSndDt = emlSndDt;
		this.ntcEml2 = ntcEml2;
		this.ntcEml3 = ntcEml3;
		this.ntcEml4 = ntcEml4;
		this.ntcEml5 = ntcEml5;
		this.emlSndGdt = emlSndGdt;
		this.emlSndRsltCd2 = emlSndRsltCd2;
		this.emlSndRsltCd1 = emlSndRsltCd1;
		this.emlSndRsltNm3 = emlSndRsltNm3;
		this.emlSndRsltCd4 = emlSndRsltCd4;
		this.emlSndRsltNm4 = emlSndRsltNm4;
		this.emlSndRsltCd3 = emlSndRsltCd3;
		this.emlSndRsltNm1 = emlSndRsltNm1;
		this.emlSndRsltNm2 = emlSndRsltNm2;
		this.emlSndRsltCd5 = emlSndRsltCd5;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.cntrNo = cntrNo;
		this.pkupNo = pkupNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pkup_ntc_fom_cd", getPkupNtcFomCd());
		this.hashColumns.put("eml_snd_rslt_nm5", getEmlSndRsltNm5());
		this.hashColumns.put("ntc_eml1", getNtcEml1());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("ntc_eml2", getNtcEml2());
		this.hashColumns.put("ntc_eml3", getNtcEml3());
		this.hashColumns.put("ntc_eml4", getNtcEml4());
		this.hashColumns.put("ntc_eml5", getNtcEml5());
		this.hashColumns.put("eml_snd_gdt", getEmlSndGdt());
		this.hashColumns.put("eml_snd_rslt_cd2", getEmlSndRsltCd2());
		this.hashColumns.put("eml_snd_rslt_cd1", getEmlSndRsltCd1());
		this.hashColumns.put("eml_snd_rslt_nm3", getEmlSndRsltNm3());
		this.hashColumns.put("eml_snd_rslt_cd4", getEmlSndRsltCd4());
		this.hashColumns.put("eml_snd_rslt_nm4", getEmlSndRsltNm4());
		this.hashColumns.put("eml_snd_rslt_cd3", getEmlSndRsltCd3());
		this.hashColumns.put("eml_snd_rslt_nm1", getEmlSndRsltNm1());
		this.hashColumns.put("eml_snd_rslt_nm2", getEmlSndRsltNm2());
		this.hashColumns.put("eml_snd_rslt_cd5", getEmlSndRsltCd5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pkup_no", getPkupNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pkup_ntc_fom_cd", "pkupNtcFomCd");
		this.hashFields.put("eml_snd_rslt_nm5", "emlSndRsltNm5");
		this.hashFields.put("ntc_eml1", "ntcEml1");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("ntc_eml2", "ntcEml2");
		this.hashFields.put("ntc_eml3", "ntcEml3");
		this.hashFields.put("ntc_eml4", "ntcEml4");
		this.hashFields.put("ntc_eml5", "ntcEml5");
		this.hashFields.put("eml_snd_gdt", "emlSndGdt");
		this.hashFields.put("eml_snd_rslt_cd2", "emlSndRsltCd2");
		this.hashFields.put("eml_snd_rslt_cd1", "emlSndRsltCd1");
		this.hashFields.put("eml_snd_rslt_nm3", "emlSndRsltNm3");
		this.hashFields.put("eml_snd_rslt_cd4", "emlSndRsltCd4");
		this.hashFields.put("eml_snd_rslt_nm4", "emlSndRsltNm4");
		this.hashFields.put("eml_snd_rslt_cd3", "emlSndRsltCd3");
		this.hashFields.put("eml_snd_rslt_nm1", "emlSndRsltNm1");
		this.hashFields.put("eml_snd_rslt_nm2", "emlSndRsltNm2");
		this.hashFields.put("eml_snd_rslt_cd5", "emlSndRsltCd5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pkup_no", "pkupNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcFomCd
	 */
	public String getPkupNtcFomCd() {
		return this.pkupNtcFomCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltNm5
	 */
	public String getEmlSndRsltNm5() {
		return this.emlSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @return ntcEml1
	 */
	public String getNtcEml1() {
		return this.ntcEml1;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return ntcEml2
	 */
	public String getNtcEml2() {
		return this.ntcEml2;
	}
	
	/**
	 * Column Info
	 * @return ntcEml3
	 */
	public String getNtcEml3() {
		return this.ntcEml3;
	}
	
	/**
	 * Column Info
	 * @return ntcEml4
	 */
	public String getNtcEml4() {
		return this.ntcEml4;
	}
	
	/**
	 * Column Info
	 * @return ntcEml5
	 */
	public String getNtcEml5() {
		return this.ntcEml5;
	}
	
	/**
	 * Column Info
	 * @return emlSndGdt
	 */
	public String getEmlSndGdt() {
		return this.emlSndGdt;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltCd2
	 */
	public String getEmlSndRsltCd2() {
		return this.emlSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltCd1
	 */
	public String getEmlSndRsltCd1() {
		return this.emlSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltNm3
	 */
	public String getEmlSndRsltNm3() {
		return this.emlSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltCd4
	 */
	public String getEmlSndRsltCd4() {
		return this.emlSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltNm4
	 */
	public String getEmlSndRsltNm4() {
		return this.emlSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltCd3
	 */
	public String getEmlSndRsltCd3() {
		return this.emlSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltNm1
	 */
	public String getEmlSndRsltNm1() {
		return this.emlSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltNm2
	 */
	public String getEmlSndRsltNm2() {
		return this.emlSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltCd5
	 */
	public String getEmlSndRsltCd5() {
		return this.emlSndRsltCd5;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	

	/**
	 * Column Info
	 * @param pkupNtcFomCd
	 */
	public void setPkupNtcFomCd(String pkupNtcFomCd) {
		this.pkupNtcFomCd = pkupNtcFomCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltNm5
	 */
	public void setEmlSndRsltNm5(String emlSndRsltNm5) {
		this.emlSndRsltNm5 = emlSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @param ntcEml1
	 */
	public void setNtcEml1(String ntcEml1) {
		this.ntcEml1 = ntcEml1;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param ntcEml2
	 */
	public void setNtcEml2(String ntcEml2) {
		this.ntcEml2 = ntcEml2;
	}
	
	/**
	 * Column Info
	 * @param ntcEml3
	 */
	public void setNtcEml3(String ntcEml3) {
		this.ntcEml3 = ntcEml3;
	}
	
	/**
	 * Column Info
	 * @param ntcEml4
	 */
	public void setNtcEml4(String ntcEml4) {
		this.ntcEml4 = ntcEml4;
	}
	
	/**
	 * Column Info
	 * @param ntcEml5
	 */
	public void setNtcEml5(String ntcEml5) {
		this.ntcEml5 = ntcEml5;
	}
	
	/**
	 * Column Info
	 * @param emlSndGdt
	 */
	public void setEmlSndGdt(String emlSndGdt) {
		this.emlSndGdt = emlSndGdt;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltCd2
	 */
	public void setEmlSndRsltCd2(String emlSndRsltCd2) {
		this.emlSndRsltCd2 = emlSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltCd1
	 */
	public void setEmlSndRsltCd1(String emlSndRsltCd1) {
		this.emlSndRsltCd1 = emlSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltNm3
	 */
	public void setEmlSndRsltNm3(String emlSndRsltNm3) {
		this.emlSndRsltNm3 = emlSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltCd4
	 */
	public void setEmlSndRsltCd4(String emlSndRsltCd4) {
		this.emlSndRsltCd4 = emlSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltNm4
	 */
	public void setEmlSndRsltNm4(String emlSndRsltNm4) {
		this.emlSndRsltNm4 = emlSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltCd3
	 */
	public void setEmlSndRsltCd3(String emlSndRsltCd3) {
		this.emlSndRsltCd3 = emlSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltNm1
	 */
	public void setEmlSndRsltNm1(String emlSndRsltNm1) {
		this.emlSndRsltNm1 = emlSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltNm2
	 */
	public void setEmlSndRsltNm2(String emlSndRsltNm2) {
		this.emlSndRsltNm2 = emlSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltCd5
	 */
	public void setEmlSndRsltCd5(String emlSndRsltCd5) {
		this.emlSndRsltCd5 = emlSndRsltCd5;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPkupNtcFomCd(JSPUtil.getParameter(request, "pkup_ntc_fom_cd", ""));
		setEmlSndRsltNm5(JSPUtil.getParameter(request, "eml_snd_rslt_nm5", ""));
		setNtcEml1(JSPUtil.getParameter(request, "ntc_eml1", ""));
		setEmlSndDt(JSPUtil.getParameter(request, "eml_snd_dt", ""));
		setNtcEml2(JSPUtil.getParameter(request, "ntc_eml2", ""));
		setNtcEml3(JSPUtil.getParameter(request, "ntc_eml3", ""));
		setNtcEml4(JSPUtil.getParameter(request, "ntc_eml4", ""));
		setNtcEml5(JSPUtil.getParameter(request, "ntc_eml5", ""));
		setEmlSndGdt(JSPUtil.getParameter(request, "eml_snd_gdt", ""));
		setEmlSndRsltCd2(JSPUtil.getParameter(request, "eml_snd_rslt_cd2", ""));
		setEmlSndRsltCd1(JSPUtil.getParameter(request, "eml_snd_rslt_cd1", ""));
		setEmlSndRsltNm3(JSPUtil.getParameter(request, "eml_snd_rslt_nm3", ""));
		setEmlSndRsltCd4(JSPUtil.getParameter(request, "eml_snd_rslt_cd4", ""));
		setEmlSndRsltNm4(JSPUtil.getParameter(request, "eml_snd_rslt_nm4", ""));
		setEmlSndRsltCd3(JSPUtil.getParameter(request, "eml_snd_rslt_cd3", ""));
		setEmlSndRsltNm1(JSPUtil.getParameter(request, "eml_snd_rslt_nm1", ""));
		setEmlSndRsltNm2(JSPUtil.getParameter(request, "eml_snd_rslt_nm2", ""));
		setEmlSndRsltCd5(JSPUtil.getParameter(request, "eml_snd_rslt_cd5", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcMailInfoVO[]
	 */
	public PkupNtcMailInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcMailInfoVO[]
	 */
	public PkupNtcMailInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcMailInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pkupNtcFomCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_fom_cd", length));
			String[] emlSndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm5", length));
			String[] ntcEml1 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml1", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] ntcEml2 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml2", length));
			String[] ntcEml3 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml3", length));
			String[] ntcEml4 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml4", length));
			String[] ntcEml5 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml5", length));
			String[] emlSndGdt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_gdt", length));
			String[] emlSndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd2", length));
			String[] emlSndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd1", length));
			String[] emlSndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm3", length));
			String[] emlSndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd4", length));
			String[] emlSndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm4", length));
			String[] emlSndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd3", length));
			String[] emlSndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm1", length));
			String[] emlSndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm2", length));
			String[] emlSndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcMailInfoVO();
				if (pkupNtcFomCd[i] != null)
					model.setPkupNtcFomCd(pkupNtcFomCd[i]);
				if (emlSndRsltNm5[i] != null)
					model.setEmlSndRsltNm5(emlSndRsltNm5[i]);
				if (ntcEml1[i] != null)
					model.setNtcEml1(ntcEml1[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (ntcEml2[i] != null)
					model.setNtcEml2(ntcEml2[i]);
				if (ntcEml3[i] != null)
					model.setNtcEml3(ntcEml3[i]);
				if (ntcEml4[i] != null)
					model.setNtcEml4(ntcEml4[i]);
				if (ntcEml5[i] != null)
					model.setNtcEml5(ntcEml5[i]);
				if (emlSndGdt[i] != null)
					model.setEmlSndGdt(emlSndGdt[i]);
				if (emlSndRsltCd2[i] != null)
					model.setEmlSndRsltCd2(emlSndRsltCd2[i]);
				if (emlSndRsltCd1[i] != null)
					model.setEmlSndRsltCd1(emlSndRsltCd1[i]);
				if (emlSndRsltNm3[i] != null)
					model.setEmlSndRsltNm3(emlSndRsltNm3[i]);
				if (emlSndRsltCd4[i] != null)
					model.setEmlSndRsltCd4(emlSndRsltCd4[i]);
				if (emlSndRsltNm4[i] != null)
					model.setEmlSndRsltNm4(emlSndRsltNm4[i]);
				if (emlSndRsltCd3[i] != null)
					model.setEmlSndRsltCd3(emlSndRsltCd3[i]);
				if (emlSndRsltNm1[i] != null)
					model.setEmlSndRsltNm1(emlSndRsltNm1[i]);
				if (emlSndRsltNm2[i] != null)
					model.setEmlSndRsltNm2(emlSndRsltNm2[i]);
				if (emlSndRsltCd5[i] != null)
					model.setEmlSndRsltCd5(emlSndRsltCd5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcMailInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcMailInfoVO[]
	 */
	public PkupNtcMailInfoVO[] getPkupNtcMailInfoVOs(){
		PkupNtcMailInfoVO[] vos = (PkupNtcMailInfoVO[])models.toArray(new PkupNtcMailInfoVO[models.size()]);
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
		this.pkupNtcFomCd = this.pkupNtcFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm5 = this.emlSndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml1 = this.ntcEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml2 = this.ntcEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml3 = this.ntcEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml4 = this.ntcEml4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml5 = this.ntcEml5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndGdt = this.emlSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltCd2 = this.emlSndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltCd1 = this.emlSndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm3 = this.emlSndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltCd4 = this.emlSndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm4 = this.emlSndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltCd3 = this.emlSndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm1 = this.emlSndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm2 = this.emlSndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltCd5 = this.emlSndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
