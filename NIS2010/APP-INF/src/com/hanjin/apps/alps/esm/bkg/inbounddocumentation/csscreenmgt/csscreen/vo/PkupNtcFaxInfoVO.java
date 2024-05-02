/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PkupNtcFaxInfoVO.java
*@FileTitle : PkupNtcFaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNtcFaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcFaxInfoVO> models = new ArrayList<PkupNtcFaxInfoVO>();
	
	/* Column Info */
	private String pkupNtcFomCd = null;
	/* Column Info */
	private String faxNo1 = null;
	/* Column Info */
	private String faxSndGdt = null;
	/* Column Info */
	private String faxNo5 = null;
	/* Column Info */
	private String faxNo4 = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String faxSndRsltNm3 = null;
	/* Column Info */
	private String faxSndRsltNm2 = null;
	/* Column Info */
	private String faxSndRsltNm1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String faxSndRsltNm4 = null;
	/* Column Info */
	private String faxSndRsltNm5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String faxSndRsltCd1 = null;
	/* Column Info */
	private String faxSndRsltCd2 = null;
	/* Column Info */
	private String faxSndRsltCd3 = null;
	/* Column Info */
	private String faxSndRsltCd4 = null;
	/* Column Info */
	private String faxSndRsltCd5 = null;
	/* Column Info */
	private String pkupNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcFaxInfoVO() {}

	public PkupNtcFaxInfoVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String pkupNo, String pkupNtcFomCd, String diffRmk, String faxNo1, String faxNo2, String faxNo3, String faxNo4, String faxNo5, String faxSndRsltCd1, String faxSndRsltCd2, String faxSndRsltCd3, String faxSndRsltCd4, String faxSndRsltCd5, String faxSndRsltNm1, String faxSndRsltNm2, String faxSndRsltNm3, String faxSndRsltNm4, String faxSndRsltNm5, String faxSndDt, String faxSndGdt) {
		this.pkupNtcFomCd = pkupNtcFomCd;
		this.faxNo1 = faxNo1;
		this.faxSndGdt = faxSndGdt;
		this.faxNo5 = faxNo5;
		this.faxNo4 = faxNo4;
		this.faxNo3 = faxNo3;
		this.faxNo2 = faxNo2;
		this.faxSndRsltNm3 = faxSndRsltNm3;
		this.faxSndRsltNm2 = faxSndRsltNm2;
		this.faxSndRsltNm1 = faxSndRsltNm1;
		this.pagerows = pagerows;
		this.faxSndRsltNm4 = faxSndRsltNm4;
		this.faxSndRsltNm5 = faxSndRsltNm5;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.cntrNo = cntrNo;
		this.faxSndDt = faxSndDt;
		this.faxSndRsltCd1 = faxSndRsltCd1;
		this.faxSndRsltCd2 = faxSndRsltCd2;
		this.faxSndRsltCd3 = faxSndRsltCd3;
		this.faxSndRsltCd4 = faxSndRsltCd4;
		this.faxSndRsltCd5 = faxSndRsltCd5;
		this.pkupNo = pkupNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pkup_ntc_fom_cd", getPkupNtcFomCd());
		this.hashColumns.put("fax_no1", getFaxNo1());
		this.hashColumns.put("fax_snd_gdt", getFaxSndGdt());
		this.hashColumns.put("fax_no5", getFaxNo5());
		this.hashColumns.put("fax_no4", getFaxNo4());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("fax_snd_rslt_nm3", getFaxSndRsltNm3());
		this.hashColumns.put("fax_snd_rslt_nm2", getFaxSndRsltNm2());
		this.hashColumns.put("fax_snd_rslt_nm1", getFaxSndRsltNm1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fax_snd_rslt_nm4", getFaxSndRsltNm4());
		this.hashColumns.put("fax_snd_rslt_nm5", getFaxSndRsltNm5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("fax_snd_rslt_cd1", getFaxSndRsltCd1());
		this.hashColumns.put("fax_snd_rslt_cd2", getFaxSndRsltCd2());
		this.hashColumns.put("fax_snd_rslt_cd3", getFaxSndRsltCd3());
		this.hashColumns.put("fax_snd_rslt_cd4", getFaxSndRsltCd4());
		this.hashColumns.put("fax_snd_rslt_cd5", getFaxSndRsltCd5());
		this.hashColumns.put("pkup_no", getPkupNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pkup_ntc_fom_cd", "pkupNtcFomCd");
		this.hashFields.put("fax_no1", "faxNo1");
		this.hashFields.put("fax_snd_gdt", "faxSndGdt");
		this.hashFields.put("fax_no5", "faxNo5");
		this.hashFields.put("fax_no4", "faxNo4");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("fax_snd_rslt_nm3", "faxSndRsltNm3");
		this.hashFields.put("fax_snd_rslt_nm2", "faxSndRsltNm2");
		this.hashFields.put("fax_snd_rslt_nm1", "faxSndRsltNm1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fax_snd_rslt_nm4", "faxSndRsltNm4");
		this.hashFields.put("fax_snd_rslt_nm5", "faxSndRsltNm5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("fax_snd_rslt_cd1", "faxSndRsltCd1");
		this.hashFields.put("fax_snd_rslt_cd2", "faxSndRsltCd2");
		this.hashFields.put("fax_snd_rslt_cd3", "faxSndRsltCd3");
		this.hashFields.put("fax_snd_rslt_cd4", "faxSndRsltCd4");
		this.hashFields.put("fax_snd_rslt_cd5", "faxSndRsltCd5");
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
	 * @return faxNo1
	 */
	public String getFaxNo1() {
		return this.faxNo1;
	}
	
	/**
	 * Column Info
	 * @return faxSndGdt
	 */
	public String getFaxSndGdt() {
		return this.faxSndGdt;
	}
	
	/**
	 * Column Info
	 * @return faxNo5
	 */
	public String getFaxNo5() {
		return this.faxNo5;
	}
	
	/**
	 * Column Info
	 * @return faxNo4
	 */
	public String getFaxNo4() {
		return this.faxNo4;
	}
	
	/**
	 * Column Info
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}
	
	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltNm3
	 */
	public String getFaxSndRsltNm3() {
		return this.faxSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltNm2
	 */
	public String getFaxSndRsltNm2() {
		return this.faxSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltNm1
	 */
	public String getFaxSndRsltNm1() {
		return this.faxSndRsltNm1;
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
	 * @return faxSndRsltNm4
	 */
	public String getFaxSndRsltNm4() {
		return this.faxSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltNm5
	 */
	public String getFaxSndRsltNm5() {
		return this.faxSndRsltNm5;
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
	 * @return faxSndDt
	 */
	public String getFaxSndDt() {
		return this.faxSndDt;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltCd1
	 */
	public String getFaxSndRsltCd1() {
		return this.faxSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltCd2
	 */
	public String getFaxSndRsltCd2() {
		return this.faxSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltCd3
	 */
	public String getFaxSndRsltCd3() {
		return this.faxSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltCd4
	 */
	public String getFaxSndRsltCd4() {
		return this.faxSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltCd5
	 */
	public String getFaxSndRsltCd5() {
		return this.faxSndRsltCd5;
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
	 * @param faxNo1
	 */
	public void setFaxNo1(String faxNo1) {
		this.faxNo1 = faxNo1;
	}
	
	/**
	 * Column Info
	 * @param faxSndGdt
	 */
	public void setFaxSndGdt(String faxSndGdt) {
		this.faxSndGdt = faxSndGdt;
	}
	
	/**
	 * Column Info
	 * @param faxNo5
	 */
	public void setFaxNo5(String faxNo5) {
		this.faxNo5 = faxNo5;
	}
	
	/**
	 * Column Info
	 * @param faxNo4
	 */
	public void setFaxNo4(String faxNo4) {
		this.faxNo4 = faxNo4;
	}
	
	/**
	 * Column Info
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}
	
	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltNm3
	 */
	public void setFaxSndRsltNm3(String faxSndRsltNm3) {
		this.faxSndRsltNm3 = faxSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltNm2
	 */
	public void setFaxSndRsltNm2(String faxSndRsltNm2) {
		this.faxSndRsltNm2 = faxSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltNm1
	 */
	public void setFaxSndRsltNm1(String faxSndRsltNm1) {
		this.faxSndRsltNm1 = faxSndRsltNm1;
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
	 * @param faxSndRsltNm4
	 */
	public void setFaxSndRsltNm4(String faxSndRsltNm4) {
		this.faxSndRsltNm4 = faxSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltNm5
	 */
	public void setFaxSndRsltNm5(String faxSndRsltNm5) {
		this.faxSndRsltNm5 = faxSndRsltNm5;
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
	 * @param faxSndDt
	 */
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltCd1
	 */
	public void setFaxSndRsltCd1(String faxSndRsltCd1) {
		this.faxSndRsltCd1 = faxSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltCd2
	 */
	public void setFaxSndRsltCd2(String faxSndRsltCd2) {
		this.faxSndRsltCd2 = faxSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltCd3
	 */
	public void setFaxSndRsltCd3(String faxSndRsltCd3) {
		this.faxSndRsltCd3 = faxSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltCd4
	 */
	public void setFaxSndRsltCd4(String faxSndRsltCd4) {
		this.faxSndRsltCd4 = faxSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltCd5
	 */
	public void setFaxSndRsltCd5(String faxSndRsltCd5) {
		this.faxSndRsltCd5 = faxSndRsltCd5;
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
		setFaxNo1(JSPUtil.getParameter(request, "fax_no1", ""));
		setFaxSndGdt(JSPUtil.getParameter(request, "fax_snd_gdt", ""));
		setFaxNo5(JSPUtil.getParameter(request, "fax_no5", ""));
		setFaxNo4(JSPUtil.getParameter(request, "fax_no4", ""));
		setFaxNo3(JSPUtil.getParameter(request, "fax_no3", ""));
		setFaxNo2(JSPUtil.getParameter(request, "fax_no2", ""));
		setFaxSndRsltNm3(JSPUtil.getParameter(request, "fax_snd_rslt_nm3", ""));
		setFaxSndRsltNm2(JSPUtil.getParameter(request, "fax_snd_rslt_nm2", ""));
		setFaxSndRsltNm1(JSPUtil.getParameter(request, "fax_snd_rslt_nm1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFaxSndRsltNm4(JSPUtil.getParameter(request, "fax_snd_rslt_nm4", ""));
		setFaxSndRsltNm5(JSPUtil.getParameter(request, "fax_snd_rslt_nm5", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFaxSndDt(JSPUtil.getParameter(request, "fax_snd_dt", ""));
		setFaxSndRsltCd1(JSPUtil.getParameter(request, "fax_snd_rslt_cd1", ""));
		setFaxSndRsltCd2(JSPUtil.getParameter(request, "fax_snd_rslt_cd2", ""));
		setFaxSndRsltCd3(JSPUtil.getParameter(request, "fax_snd_rslt_cd3", ""));
		setFaxSndRsltCd4(JSPUtil.getParameter(request, "fax_snd_rslt_cd4", ""));
		setFaxSndRsltCd5(JSPUtil.getParameter(request, "fax_snd_rslt_cd5", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcFaxInfoVO[]
	 */
	public PkupNtcFaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcFaxInfoVO[]
	 */
	public PkupNtcFaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcFaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pkupNtcFomCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_fom_cd", length));
			String[] faxNo1 = (JSPUtil.getParameter(request, prefix	+ "fax_no1", length));
			String[] faxSndGdt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_gdt", length));
			String[] faxNo5 = (JSPUtil.getParameter(request, prefix	+ "fax_no5", length));
			String[] faxNo4 = (JSPUtil.getParameter(request, prefix	+ "fax_no4", length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3", length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2", length));
			String[] faxSndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm3", length));
			String[] faxSndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm2", length));
			String[] faxSndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] faxSndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm4", length));
			String[] faxSndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] faxSndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd1", length));
			String[] faxSndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd2", length));
			String[] faxSndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd3", length));
			String[] faxSndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd4", length));
			String[] faxSndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd5", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcFaxInfoVO();
				if (pkupNtcFomCd[i] != null)
					model.setPkupNtcFomCd(pkupNtcFomCd[i]);
				if (faxNo1[i] != null)
					model.setFaxNo1(faxNo1[i]);
				if (faxSndGdt[i] != null)
					model.setFaxSndGdt(faxSndGdt[i]);
				if (faxNo5[i] != null)
					model.setFaxNo5(faxNo5[i]);
				if (faxNo4[i] != null)
					model.setFaxNo4(faxNo4[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (faxSndRsltNm3[i] != null)
					model.setFaxSndRsltNm3(faxSndRsltNm3[i]);
				if (faxSndRsltNm2[i] != null)
					model.setFaxSndRsltNm2(faxSndRsltNm2[i]);
				if (faxSndRsltNm1[i] != null)
					model.setFaxSndRsltNm1(faxSndRsltNm1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (faxSndRsltNm4[i] != null)
					model.setFaxSndRsltNm4(faxSndRsltNm4[i]);
				if (faxSndRsltNm5[i] != null)
					model.setFaxSndRsltNm5(faxSndRsltNm5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (faxSndRsltCd1[i] != null)
					model.setFaxSndRsltCd1(faxSndRsltCd1[i]);
				if (faxSndRsltCd2[i] != null)
					model.setFaxSndRsltCd2(faxSndRsltCd2[i]);
				if (faxSndRsltCd3[i] != null)
					model.setFaxSndRsltCd3(faxSndRsltCd3[i]);
				if (faxSndRsltCd4[i] != null)
					model.setFaxSndRsltCd4(faxSndRsltCd4[i]);
				if (faxSndRsltCd5[i] != null)
					model.setFaxSndRsltCd5(faxSndRsltCd5[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcFaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcFaxInfoVO[]
	 */
	public PkupNtcFaxInfoVO[] getPkupNtcFaxInfoVOs(){
		PkupNtcFaxInfoVO[] vos = (PkupNtcFaxInfoVO[])models.toArray(new PkupNtcFaxInfoVO[models.size()]);
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
		this.faxNo1 = this.faxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndGdt = this.faxSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo5 = this.faxNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo4 = this.faxNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm3 = this.faxSndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm2 = this.faxSndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm1 = this.faxSndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm4 = this.faxSndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm5 = this.faxSndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd1 = this.faxSndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd2 = this.faxSndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd3 = this.faxSndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd4 = this.faxSndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd5 = this.faxSndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
