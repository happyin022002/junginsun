/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerSealInquiryVO.java
*@FileTitle : ContainerSealInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo;

//import java.lang.reflect.Field;
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

public class ContainerSealInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContainerSealInquiryVO> models = new ArrayList<ContainerSealInquiryVO>();
	
	/* Column Info */
	private String mm09 = null;
	/* Column Info */
	private String n1stSerRngSealNo = null;
	/* Column Info */
	private String planHalf = null;
	/* Column Info */
	private String mm08 = null;
	/* Column Info */
	private String frYy = null;
	/* Column Info */
	private String backEndJobKey2 = null;
	/* Column Info */
	private String mm01 = null;
	/* Column Info */
	private String sealKndNm = null;
	/* Column Info */
	private String mm03 = null;
	/* Column Info */
	private String mm02 = null;
	/* Column Info */
	private String toYy = null;
	/* Column Info */
	private String mm05 = null;
	/* Column Info */
	private String mm04 = null;
	/* Column Info */
	private String mm07 = null;
	/* Column Info */
	private String backEndJobKey1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mm06 = null;
	/* Column Info */
	private String plnQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String planYear = null;
	/* Column Info */
	private String mm10 = null;
	/* Column Info */
	private String sealNoPfxNm = null;
	/* Column Info */
	private String mmTtl = null;
	/* Column Info */
	private String frMm = null;
	/* Column Info */
	private String cntrSealLostQty = null;
	/* Column Info */
	private String sealDelim = null;
	/* Column Info */
	private String mm13 = null;
	/* Column Info */
	private String mm12 = null;
	/* Column Info */
	private String mm11 = null;
	/* Column Info */
	private String currQty = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String toMm = null;
	/* Column Info */
	private String lstSerRngSealNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ContainerSealInquiryVO() {}

	public ContainerSealInquiryVO(String ibflag, String pagerows, String ofcCd, String planYear, String planHalf, String sealKndNm, String plnQty, String sealNoPfxNm, String n1stSerRngSealNo, String sealDelim, String lstSerRngSealNo, String mm01, String mm02, String mm03, String mm04, String mm05, String mm06, String mm07, String mm08, String mm09, String mm10, String mm11, String mm12, String mmTtl, String mm13, String cntrSealLostQty, String currQty, String frYy, String frMm, String toMm, String toYy, String backEndJobKey1, String backEndJobKey2) {
		this.mm09 = mm09;
		this.n1stSerRngSealNo = n1stSerRngSealNo;
		this.planHalf = planHalf;
		this.mm08 = mm08;
		this.frYy = frYy;
		this.backEndJobKey2 = backEndJobKey2;
		this.mm01 = mm01;
		this.sealKndNm = sealKndNm;
		this.mm03 = mm03;
		this.mm02 = mm02;
		this.toYy = toYy;
		this.mm05 = mm05;
		this.mm04 = mm04;
		this.mm07 = mm07;
		this.backEndJobKey1 = backEndJobKey1;
		this.pagerows = pagerows;
		this.mm06 = mm06;
		this.plnQty = plnQty;
		this.ibflag = ibflag;
		this.planYear = planYear;
		this.mm10 = mm10;
		this.sealNoPfxNm = sealNoPfxNm;
		this.mmTtl = mmTtl;
		this.frMm = frMm;
		this.cntrSealLostQty = cntrSealLostQty;
		this.sealDelim = sealDelim;
		this.mm13 = mm13;
		this.mm12 = mm12;
		this.mm11 = mm11;
		this.currQty = currQty;
		this.ofcCd = ofcCd;
		this.toMm = toMm;
		this.lstSerRngSealNo = lstSerRngSealNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mm_09", getMm09());
		this.hashColumns.put("n1st_ser_rng_seal_no", getN1stSerRngSealNo());
		this.hashColumns.put("plan_half", getPlanHalf());
		this.hashColumns.put("mm_08", getMm08());
		this.hashColumns.put("fr_yy", getFrYy());
		this.hashColumns.put("back_end_job_key2", getBackEndJobKey2());
		this.hashColumns.put("mm_01", getMm01());
		this.hashColumns.put("seal_knd_nm", getSealKndNm());
		this.hashColumns.put("mm_03", getMm03());
		this.hashColumns.put("mm_02", getMm02());
		this.hashColumns.put("to_yy", getToYy());
		this.hashColumns.put("mm_05", getMm05());
		this.hashColumns.put("mm_04", getMm04());
		this.hashColumns.put("mm_07", getMm07());
		this.hashColumns.put("back_end_job_key1", getBackEndJobKey1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mm_06", getMm06());
		this.hashColumns.put("pln_qty", getPlnQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("plan_year", getPlanYear());
		this.hashColumns.put("mm_10", getMm10());
		this.hashColumns.put("seal_no_pfx_nm", getSealNoPfxNm());
		this.hashColumns.put("mm_ttl", getMmTtl());
		this.hashColumns.put("fr_mm", getFrMm());
		this.hashColumns.put("cntr_seal_lost_qty", getCntrSealLostQty());
		this.hashColumns.put("seal_delim", getSealDelim());
		this.hashColumns.put("mm_13", getMm13());
		this.hashColumns.put("mm_12", getMm12());
		this.hashColumns.put("mm_11", getMm11());
		this.hashColumns.put("curr_qty", getCurrQty());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("to_mm", getToMm());
		this.hashColumns.put("lst_ser_rng_seal_no", getLstSerRngSealNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mm_09", "mm09");
		this.hashFields.put("n1st_ser_rng_seal_no", "n1stSerRngSealNo");
		this.hashFields.put("plan_half", "planHalf");
		this.hashFields.put("mm_08", "mm08");
		this.hashFields.put("fr_yy", "frYy");
		this.hashFields.put("back_end_job_key2", "backEndJobKey2");
		this.hashFields.put("mm_01", "mm01");
		this.hashFields.put("seal_knd_nm", "sealKndNm");
		this.hashFields.put("mm_03", "mm03");
		this.hashFields.put("mm_02", "mm02");
		this.hashFields.put("to_yy", "toYy");
		this.hashFields.put("mm_05", "mm05");
		this.hashFields.put("mm_04", "mm04");
		this.hashFields.put("mm_07", "mm07");
		this.hashFields.put("back_end_job_key1", "backEndJobKey1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mm_06", "mm06");
		this.hashFields.put("pln_qty", "plnQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("plan_year", "planYear");
		this.hashFields.put("mm_10", "mm10");
		this.hashFields.put("seal_no_pfx_nm", "sealNoPfxNm");
		this.hashFields.put("mm_ttl", "mmTtl");
		this.hashFields.put("fr_mm", "frMm");
		this.hashFields.put("cntr_seal_lost_qty", "cntrSealLostQty");
		this.hashFields.put("seal_delim", "sealDelim");
		this.hashFields.put("mm_13", "mm13");
		this.hashFields.put("mm_12", "mm12");
		this.hashFields.put("mm_11", "mm11");
		this.hashFields.put("curr_qty", "currQty");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("to_mm", "toMm");
		this.hashFields.put("lst_ser_rng_seal_no", "lstSerRngSealNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mm09
	 */
	public String getMm09() {
		return this.mm09;
	}
	
	/**
	 * Column Info
	 * @return n1stSerRngSealNo
	 */
	public String getN1stSerRngSealNo() {
		return this.n1stSerRngSealNo;
	}
	
	/**
	 * Column Info
	 * @return planHalf
	 */
	public String getPlanHalf() {
		return this.planHalf;
	}
	
	/**
	 * Column Info
	 * @return mm08
	 */
	public String getMm08() {
		return this.mm08;
	}
	
	/**
	 * Column Info
	 * @return frYy
	 */
	public String getFrYy() {
		return this.frYy;
	}
	
	/**
	 * Column Info
	 * @return backEndJobKey2
	 */
	public String getBackEndJobKey2() {
		return this.backEndJobKey2;
	}
	
	/**
	 * Column Info
	 * @return mm01
	 */
	public String getMm01() {
		return this.mm01;
	}
	
	/**
	 * Column Info
	 * @return sealKndNm
	 */
	public String getSealKndNm() {
		return this.sealKndNm;
	}
	
	/**
	 * Column Info
	 * @return mm03
	 */
	public String getMm03() {
		return this.mm03;
	}
	
	/**
	 * Column Info
	 * @return mm02
	 */
	public String getMm02() {
		return this.mm02;
	}
	
	/**
	 * Column Info
	 * @return toYy
	 */
	public String getToYy() {
		return this.toYy;
	}
	
	/**
	 * Column Info
	 * @return mm05
	 */
	public String getMm05() {
		return this.mm05;
	}
	
	/**
	 * Column Info
	 * @return mm04
	 */
	public String getMm04() {
		return this.mm04;
	}
	
	/**
	 * Column Info
	 * @return mm07
	 */
	public String getMm07() {
		return this.mm07;
	}
	
	/**
	 * Column Info
	 * @return backEndJobKey1
	 */
	public String getBackEndJobKey1() {
		return this.backEndJobKey1;
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
	 * @return mm06
	 */
	public String getMm06() {
		return this.mm06;
	}
	
	/**
	 * Column Info
	 * @return plnQty
	 */
	public String getPlnQty() {
		return this.plnQty;
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
	 * @return planYear
	 */
	public String getPlanYear() {
		return this.planYear;
	}
	
	/**
	 * Column Info
	 * @return mm10
	 */
	public String getMm10() {
		return this.mm10;
	}
	
	/**
	 * Column Info
	 * @return sealNoPfxNm
	 */
	public String getSealNoPfxNm() {
		return this.sealNoPfxNm;
	}
	
	/**
	 * Column Info
	 * @return mmTtl
	 */
	public String getMmTtl() {
		return this.mmTtl;
	}
	
	/**
	 * Column Info
	 * @return frMm
	 */
	public String getFrMm() {
		return this.frMm;
	}
	
	/**
	 * Column Info
	 * @return cntrSealLostQty
	 */
	public String getCntrSealLostQty() {
		return this.cntrSealLostQty;
	}
	
	/**
	 * Column Info
	 * @return sealDelim
	 */
	public String getSealDelim() {
		return this.sealDelim;
	}
	
	/**
	 * Column Info
	 * @return mm13
	 */
	public String getMm13() {
		return this.mm13;
	}
	
	/**
	 * Column Info
	 * @return mm12
	 */
	public String getMm12() {
		return this.mm12;
	}
	
	/**
	 * Column Info
	 * @return mm11
	 */
	public String getMm11() {
		return this.mm11;
	}
	
	/**
	 * Column Info
	 * @return currQty
	 */
	public String getCurrQty() {
		return this.currQty;
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
	 * @return toMm
	 */
	public String getToMm() {
		return this.toMm;
	}
	
	/**
	 * Column Info
	 * @return lstSerRngSealNo
	 */
	public String getLstSerRngSealNo() {
		return this.lstSerRngSealNo;
	}
	

	/**
	 * Column Info
	 * @param mm09
	 */
	public void setMm09(String mm09) {
		this.mm09 = mm09;
	}
	
	/**
	 * Column Info
	 * @param n1stSerRngSealNo
	 */
	public void setN1stSerRngSealNo(String n1stSerRngSealNo) {
		this.n1stSerRngSealNo = n1stSerRngSealNo;
	}
	
	/**
	 * Column Info
	 * @param planHalf
	 */
	public void setPlanHalf(String planHalf) {
		this.planHalf = planHalf;
	}
	
	/**
	 * Column Info
	 * @param mm08
	 */
	public void setMm08(String mm08) {
		this.mm08 = mm08;
	}
	
	/**
	 * Column Info
	 * @param frYy
	 */
	public void setFrYy(String frYy) {
		this.frYy = frYy;
	}
	
	/**
	 * Column Info
	 * @param backEndJobKey2
	 */
	public void setBackEndJobKey2(String backEndJobKey2) {
		this.backEndJobKey2 = backEndJobKey2;
	}
	
	/**
	 * Column Info
	 * @param mm01
	 */
	public void setMm01(String mm01) {
		this.mm01 = mm01;
	}
	
	/**
	 * Column Info
	 * @param sealKndNm
	 */
	public void setSealKndNm(String sealKndNm) {
		this.sealKndNm = sealKndNm;
	}
	
	/**
	 * Column Info
	 * @param mm03
	 */
	public void setMm03(String mm03) {
		this.mm03 = mm03;
	}
	
	/**
	 * Column Info
	 * @param mm02
	 */
	public void setMm02(String mm02) {
		this.mm02 = mm02;
	}
	
	/**
	 * Column Info
	 * @param toYy
	 */
	public void setToYy(String toYy) {
		this.toYy = toYy;
	}
	
	/**
	 * Column Info
	 * @param mm05
	 */
	public void setMm05(String mm05) {
		this.mm05 = mm05;
	}
	
	/**
	 * Column Info
	 * @param mm04
	 */
	public void setMm04(String mm04) {
		this.mm04 = mm04;
	}
	
	/**
	 * Column Info
	 * @param mm07
	 */
	public void setMm07(String mm07) {
		this.mm07 = mm07;
	}
	
	/**
	 * Column Info
	 * @param backEndJobKey1
	 */
	public void setBackEndJobKey1(String backEndJobKey1) {
		this.backEndJobKey1 = backEndJobKey1;
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
	 * @param mm06
	 */
	public void setMm06(String mm06) {
		this.mm06 = mm06;
	}
	
	/**
	 * Column Info
	 * @param plnQty
	 */
	public void setPlnQty(String plnQty) {
		this.plnQty = plnQty;
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
	 * @param planYear
	 */
	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}
	
	/**
	 * Column Info
	 * @param mm10
	 */
	public void setMm10(String mm10) {
		this.mm10 = mm10;
	}
	
	/**
	 * Column Info
	 * @param sealNoPfxNm
	 */
	public void setSealNoPfxNm(String sealNoPfxNm) {
		this.sealNoPfxNm = sealNoPfxNm;
	}
	
	/**
	 * Column Info
	 * @param mmTtl
	 */
	public void setMmTtl(String mmTtl) {
		this.mmTtl = mmTtl;
	}
	
	/**
	 * Column Info
	 * @param frMm
	 */
	public void setFrMm(String frMm) {
		this.frMm = frMm;
	}
	
	/**
	 * Column Info
	 * @param cntrSealLostQty
	 */
	public void setCntrSealLostQty(String cntrSealLostQty) {
		this.cntrSealLostQty = cntrSealLostQty;
	}
	
	/**
	 * Column Info
	 * @param sealDelim
	 */
	public void setSealDelim(String sealDelim) {
		this.sealDelim = sealDelim;
	}
	
	/**
	 * Column Info
	 * @param mm13
	 */
	public void setMm13(String mm13) {
		this.mm13 = mm13;
	}
	
	/**
	 * Column Info
	 * @param mm12
	 */
	public void setMm12(String mm12) {
		this.mm12 = mm12;
	}
	
	/**
	 * Column Info
	 * @param mm11
	 */
	public void setMm11(String mm11) {
		this.mm11 = mm11;
	}
	
	/**
	 * Column Info
	 * @param currQty
	 */
	public void setCurrQty(String currQty) {
		this.currQty = currQty;
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
	 * @param toMm
	 */
	public void setToMm(String toMm) {
		this.toMm = toMm;
	}
	
	/**
	 * Column Info
	 * @param lstSerRngSealNo
	 */
	public void setLstSerRngSealNo(String lstSerRngSealNo) {
		this.lstSerRngSealNo = lstSerRngSealNo;
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
		setMm09(JSPUtil.getParameter(request, prefix + "mm_09", ""));
		setN1stSerRngSealNo(JSPUtil.getParameter(request, prefix + "n1st_ser_rng_seal_no", ""));
		setPlanHalf(JSPUtil.getParameter(request, prefix + "plan_half", ""));
		setMm08(JSPUtil.getParameter(request, prefix + "mm_08", ""));
		setFrYy(JSPUtil.getParameter(request, prefix + "fr_yy", ""));
		setBackEndJobKey2(JSPUtil.getParameter(request, prefix + "back_end_job_key2", ""));
		setMm01(JSPUtil.getParameter(request, prefix + "mm_01", ""));
		setSealKndNm(JSPUtil.getParameter(request, prefix + "seal_knd_nm", ""));
		setMm03(JSPUtil.getParameter(request, prefix + "mm_03", ""));
		setMm02(JSPUtil.getParameter(request, prefix + "mm_02", ""));
		setToYy(JSPUtil.getParameter(request, prefix + "to_yy", ""));
		setMm05(JSPUtil.getParameter(request, prefix + "mm_05", ""));
		setMm04(JSPUtil.getParameter(request, prefix + "mm_04", ""));
		setMm07(JSPUtil.getParameter(request, prefix + "mm_07", ""));
		setBackEndJobKey1(JSPUtil.getParameter(request, prefix + "back_end_job_key1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMm06(JSPUtil.getParameter(request, prefix + "mm_06", ""));
		setPlnQty(JSPUtil.getParameter(request, prefix + "pln_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPlanYear(JSPUtil.getParameter(request, prefix + "plan_year", ""));
		setMm10(JSPUtil.getParameter(request, prefix + "mm_10", ""));
		setSealNoPfxNm(JSPUtil.getParameter(request, prefix + "seal_no_pfx_nm", ""));
		setMmTtl(JSPUtil.getParameter(request, prefix + "mm_ttl", ""));
		setFrMm(JSPUtil.getParameter(request, prefix + "fr_mm", ""));
		setCntrSealLostQty(JSPUtil.getParameter(request, prefix + "cntr_seal_lost_qty", ""));
		setSealDelim(JSPUtil.getParameter(request, prefix + "seal_delim", ""));
		setMm13(JSPUtil.getParameter(request, prefix + "mm_13", ""));
		setMm12(JSPUtil.getParameter(request, prefix + "mm_12", ""));
		setMm11(JSPUtil.getParameter(request, prefix + "mm_11", ""));
		setCurrQty(JSPUtil.getParameter(request, prefix + "curr_qty", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setToMm(JSPUtil.getParameter(request, prefix + "to_mm", ""));
		setLstSerRngSealNo(JSPUtil.getParameter(request, prefix + "lst_ser_rng_seal_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerSealInquiryVO[]
	 */
	public ContainerSealInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerSealInquiryVO[]
	 */
	public ContainerSealInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContainerSealInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mm09 = (JSPUtil.getParameter(request, prefix	+ "mm_09", length));
			String[] n1stSerRngSealNo = (JSPUtil.getParameter(request, prefix	+ "n1st_ser_rng_seal_no", length));
			String[] planHalf = (JSPUtil.getParameter(request, prefix	+ "plan_half", length));
			String[] mm08 = (JSPUtil.getParameter(request, prefix	+ "mm_08", length));
			String[] frYy = (JSPUtil.getParameter(request, prefix	+ "fr_yy", length));
			String[] backEndJobKey2 = (JSPUtil.getParameter(request, prefix	+ "back_end_job_key2", length));
			String[] mm01 = (JSPUtil.getParameter(request, prefix	+ "mm_01", length));
			String[] sealKndNm = (JSPUtil.getParameter(request, prefix	+ "seal_knd_nm", length));
			String[] mm03 = (JSPUtil.getParameter(request, prefix	+ "mm_03", length));
			String[] mm02 = (JSPUtil.getParameter(request, prefix	+ "mm_02", length));
			String[] toYy = (JSPUtil.getParameter(request, prefix	+ "to_yy", length));
			String[] mm05 = (JSPUtil.getParameter(request, prefix	+ "mm_05", length));
			String[] mm04 = (JSPUtil.getParameter(request, prefix	+ "mm_04", length));
			String[] mm07 = (JSPUtil.getParameter(request, prefix	+ "mm_07", length));
			String[] backEndJobKey1 = (JSPUtil.getParameter(request, prefix	+ "back_end_job_key1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mm06 = (JSPUtil.getParameter(request, prefix	+ "mm_06", length));
			String[] plnQty = (JSPUtil.getParameter(request, prefix	+ "pln_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] planYear = (JSPUtil.getParameter(request, prefix	+ "plan_year", length));
			String[] mm10 = (JSPUtil.getParameter(request, prefix	+ "mm_10", length));
			String[] sealNoPfxNm = (JSPUtil.getParameter(request, prefix	+ "seal_no_pfx_nm", length));
			String[] mmTtl = (JSPUtil.getParameter(request, prefix	+ "mm_ttl", length));
			String[] frMm = (JSPUtil.getParameter(request, prefix	+ "fr_mm", length));
			String[] cntrSealLostQty = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_lost_qty", length));
			String[] sealDelim = (JSPUtil.getParameter(request, prefix	+ "seal_delim", length));
			String[] mm13 = (JSPUtil.getParameter(request, prefix	+ "mm_13", length));
			String[] mm12 = (JSPUtil.getParameter(request, prefix	+ "mm_12", length));
			String[] mm11 = (JSPUtil.getParameter(request, prefix	+ "mm_11", length));
			String[] currQty = (JSPUtil.getParameter(request, prefix	+ "curr_qty", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] toMm = (JSPUtil.getParameter(request, prefix	+ "to_mm", length));
			String[] lstSerRngSealNo = (JSPUtil.getParameter(request, prefix	+ "lst_ser_rng_seal_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ContainerSealInquiryVO();
				if (mm09[i] != null)
					model.setMm09(mm09[i]);
				if (n1stSerRngSealNo[i] != null)
					model.setN1stSerRngSealNo(n1stSerRngSealNo[i]);
				if (planHalf[i] != null)
					model.setPlanHalf(planHalf[i]);
				if (mm08[i] != null)
					model.setMm08(mm08[i]);
				if (frYy[i] != null)
					model.setFrYy(frYy[i]);
				if (backEndJobKey2[i] != null)
					model.setBackEndJobKey2(backEndJobKey2[i]);
				if (mm01[i] != null)
					model.setMm01(mm01[i]);
				if (sealKndNm[i] != null)
					model.setSealKndNm(sealKndNm[i]);
				if (mm03[i] != null)
					model.setMm03(mm03[i]);
				if (mm02[i] != null)
					model.setMm02(mm02[i]);
				if (toYy[i] != null)
					model.setToYy(toYy[i]);
				if (mm05[i] != null)
					model.setMm05(mm05[i]);
				if (mm04[i] != null)
					model.setMm04(mm04[i]);
				if (mm07[i] != null)
					model.setMm07(mm07[i]);
				if (backEndJobKey1[i] != null)
					model.setBackEndJobKey1(backEndJobKey1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mm06[i] != null)
					model.setMm06(mm06[i]);
				if (plnQty[i] != null)
					model.setPlnQty(plnQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (planYear[i] != null)
					model.setPlanYear(planYear[i]);
				if (mm10[i] != null)
					model.setMm10(mm10[i]);
				if (sealNoPfxNm[i] != null)
					model.setSealNoPfxNm(sealNoPfxNm[i]);
				if (mmTtl[i] != null)
					model.setMmTtl(mmTtl[i]);
				if (frMm[i] != null)
					model.setFrMm(frMm[i]);
				if (cntrSealLostQty[i] != null)
					model.setCntrSealLostQty(cntrSealLostQty[i]);
				if (sealDelim[i] != null)
					model.setSealDelim(sealDelim[i]);
				if (mm13[i] != null)
					model.setMm13(mm13[i]);
				if (mm12[i] != null)
					model.setMm12(mm12[i]);
				if (mm11[i] != null)
					model.setMm11(mm11[i]);
				if (currQty[i] != null)
					model.setCurrQty(currQty[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (toMm[i] != null)
					model.setToMm(toMm[i]);
				if (lstSerRngSealNo[i] != null)
					model.setLstSerRngSealNo(lstSerRngSealNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getContainerSealInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ContainerSealInquiryVO[]
	 */
	public ContainerSealInquiryVO[] getContainerSealInquiryVOs(){
		ContainerSealInquiryVO[] vos = (ContainerSealInquiryVO[])models.toArray(new ContainerSealInquiryVO[models.size()]);
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
		this.mm09 = this.mm09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSerRngSealNo = this.n1stSerRngSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planHalf = this.planHalf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm08 = this.mm08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYy = this.frYy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backEndJobKey2 = this.backEndJobKey2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm01 = this.mm01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndNm = this.sealKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm03 = this.mm03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm02 = this.mm02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYy = this.toYy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm05 = this.mm05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm04 = this.mm04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm07 = this.mm07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backEndJobKey1 = this.backEndJobKey1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm06 = this.mm06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnQty = this.plnQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planYear = this.planYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm10 = this.mm10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoPfxNm = this.sealNoPfxNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mmTtl = this.mmTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frMm = this.frMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealLostQty = this.cntrSealLostQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealDelim = this.sealDelim .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm13 = this.mm13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm12 = this.mm12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mm11 = this.mm11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currQty = this.currQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMm = this.toMm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSerRngSealNo = this.lstSerRngSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
