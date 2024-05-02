/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommListVO.java
*@FileTitle : FACCommListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.30 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmaudit.facommaudit.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FACCommListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FACCommListVO> models = new ArrayList<FACCommListVO>();

	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String facBxAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String facRmk = null;
	/* Column Info */
	private String facSeq = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String facOfcCd = null;
	/* Column Info */
	private String bkgSpclFeuQty = null;
	/* Column Info */
	private String facAgmtSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String cntrCrntAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String facSpclFeuAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String crntAmt = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String facDryFeuAmt = null;
	/* Column Info */
	private String facDivCd = null;
	/* Column Info */
	private String oldCrntAmt = null;
	/* Column Info */
	private String facRfTeuAmt = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ppdAmt = null;
	/* Column Info */
	private String facRfFeuAmt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String facSpclTeuAmt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String blCrntAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String facDivCd1 = null;
	/* Column Info */
	private String bkgDryTeuQty = null;
	/* Column Info */
	private String facDryTeuAmt = null;
	/* Column Info */
	private String bkgDryFeuQty = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String ofcOption = null;
	/* Column Info */
	private String bkgRfFeuQty = null;
	/* Column Info */
	private String bkgRfTeuQty = null;
	/* Column Info */
	private String facStsCd = null;
	/* Column Info */
	private String bkgSpclTeuQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FACCommListVO() {}

	public FACCommListVO(String ibflag, String pagerows, String dateFm, String dateTo, String dateDiv, String ofcOption, String arOfcCd, String vvdCd, String facSeq, String ffCntSeq, String custLglEngNm, String bkgNo, String blNo, String bkgStsCd, String vvd, String vslDepDt, String blCrntAmt, String currCd, String crntAmt, String bkgBxQty, String facBxAmt, String bkgDryTeuQty, String facDryTeuAmt, String bkgDryFeuQty, String facDryFeuAmt, String bkgRfTeuQty, String facRfTeuAmt, String bkgRfFeuQty, String facRfFeuAmt, String bkgSpclTeuQty, String facSpclTeuAmt, String bkgSpclFeuQty, String facSpclFeuAmt, String cntrCrntAmt, String ppdAmt, String ifAmt, String facStsCd, String facRmk, String ifDt, String slsOfcCd, String facOfcCd, String ffCntCd, String ffSeq, String facAgmtSeq, String facDivCd, String facDivCd1, String oldCrntAmt) {
		this.ifDt = ifDt;
		this.dateFm = dateFm;
		this.facBxAmt = facBxAmt;
		this.currCd = currCd;
		this.facRmk = facRmk;
		this.facSeq = facSeq;
		this.bkgStsCd = bkgStsCd;
		this.facOfcCd = facOfcCd;
		this.bkgSpclFeuQty = bkgSpclFeuQty;
		this.facAgmtSeq = facAgmtSeq;
		this.blNo = blNo;
		this.ffCntSeq = ffCntSeq;
		this.cntrCrntAmt = cntrCrntAmt;
		this.pagerows = pagerows;
		this.facSpclFeuAmt = facSpclFeuAmt;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.ffSeq = ffSeq;
		this.slsOfcCd = slsOfcCd;
		this.crntAmt = crntAmt;
		this.dateDiv = dateDiv;
		this.bkgBxQty = bkgBxQty;
		this.vslDepDt = vslDepDt;
		this.facDryFeuAmt = facDryFeuAmt;
		this.facDivCd = facDivCd;
		this.oldCrntAmt = oldCrntAmt;
		this.facRfTeuAmt = facRfTeuAmt;
		this.dateTo = dateTo;
		this.ppdAmt = ppdAmt;
		this.facRfFeuAmt = facRfFeuAmt;
		this.arOfcCd = arOfcCd;
		this.custLglEngNm = custLglEngNm;
		this.facSpclTeuAmt = facSpclTeuAmt;
		this.vvd = vvd;
		this.blCrntAmt = blCrntAmt;
		this.bkgNo = bkgNo;
		this.facDivCd1 = facDivCd1;
		this.bkgDryTeuQty = bkgDryTeuQty;
		this.facDryTeuAmt = facDryTeuAmt;
		this.bkgDryFeuQty = bkgDryFeuQty;
		this.ffCntCd = ffCntCd;
		this.ifAmt = ifAmt;
		this.ofcOption = ofcOption;
		this.bkgRfFeuQty = bkgRfFeuQty;
		this.bkgRfTeuQty = bkgRfTeuQty;
		this.facStsCd = facStsCd;
		this.bkgSpclTeuQty = bkgSpclTeuQty;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("fac_bx_amt", getFacBxAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fac_rmk", getFacRmk());
		this.hashColumns.put("fac_seq", getFacSeq());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("fac_ofc_cd", getFacOfcCd());
		this.hashColumns.put("bkg_spcl_feu_qty", getBkgSpclFeuQty());
		this.hashColumns.put("fac_agmt_seq", getFacAgmtSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("cntr_crnt_amt", getCntrCrntAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fac_spcl_feu_amt", getFacSpclFeuAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("crnt_amt", getCrntAmt());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("fac_dry_feu_amt", getFacDryFeuAmt());
		this.hashColumns.put("fac_div_cd", getFacDivCd());
		this.hashColumns.put("old_crnt_amt", getOldCrntAmt());
		this.hashColumns.put("fac_rf_teu_amt", getFacRfTeuAmt());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("ppd_amt", getPpdAmt());
		this.hashColumns.put("fac_rf_feu_amt", getFacRfFeuAmt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("fac_spcl_teu_amt", getFacSpclTeuAmt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bl_crnt_amt", getBlCrntAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fac_div_cd_1", getFacDivCd1());
		this.hashColumns.put("bkg_dry_teu_qty", getBkgDryTeuQty());
		this.hashColumns.put("fac_dry_teu_amt", getFacDryTeuAmt());
		this.hashColumns.put("bkg_dry_feu_qty", getBkgDryFeuQty());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("ofc_option", getOfcOption());
		this.hashColumns.put("bkg_rf_feu_qty", getBkgRfFeuQty());
		this.hashColumns.put("bkg_rf_teu_qty", getBkgRfTeuQty());
		this.hashColumns.put("fac_sts_cd", getFacStsCd());
		this.hashColumns.put("bkg_spcl_teu_qty", getBkgSpclTeuQty());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("fac_bx_amt", "facBxAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fac_rmk", "facRmk");
		this.hashFields.put("fac_seq", "facSeq");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("fac_ofc_cd", "facOfcCd");
		this.hashFields.put("bkg_spcl_feu_qty", "bkgSpclFeuQty");
		this.hashFields.put("fac_agmt_seq", "facAgmtSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("cntr_crnt_amt", "cntrCrntAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fac_spcl_feu_amt", "facSpclFeuAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("crnt_amt", "crntAmt");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("fac_dry_feu_amt", "facDryFeuAmt");
		this.hashFields.put("fac_div_cd", "facDivCd");
		this.hashFields.put("old_crnt_amt", "oldCrntAmt");
		this.hashFields.put("fac_rf_teu_amt", "facRfTeuAmt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("fac_rf_feu_amt", "facRfFeuAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("fac_spcl_teu_amt", "facSpclTeuAmt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bl_crnt_amt", "blCrntAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fac_div_cd_1", "facDivCd1");
		this.hashFields.put("bkg_dry_teu_qty", "bkgDryTeuQty");
		this.hashFields.put("fac_dry_teu_amt", "facDryTeuAmt");
		this.hashFields.put("bkg_dry_feu_qty", "bkgDryFeuQty");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("ofc_option", "ofcOption");
		this.hashFields.put("bkg_rf_feu_qty", "bkgRfFeuQty");
		this.hashFields.put("bkg_rf_teu_qty", "bkgRfTeuQty");
		this.hashFields.put("fac_sts_cd", "facStsCd");
		this.hashFields.put("bkg_spcl_teu_qty", "bkgSpclTeuQty");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}

	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}

	/**
	 * Column Info
	 * @return facBxAmt
	 */
	public String getFacBxAmt() {
		return this.facBxAmt;
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
	 * @return facRmk
	 */
	public String getFacRmk() {
		return this.facRmk;
	}

	/**
	 * Column Info
	 * @return facSeq
	 */
	public String getFacSeq() {
		return this.facSeq;
	}

	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}

	/**
	 * Column Info
	 * @return facOfcCd
	 */
	public String getFacOfcCd() {
		return this.facOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgSpclFeuQty
	 */
	public String getBkgSpclFeuQty() {
		return this.bkgSpclFeuQty;
	}

	/**
	 * Column Info
	 * @return facAgmtSeq
	 */
	public String getFacAgmtSeq() {
		return this.facAgmtSeq;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
	}

	/**
	 * Column Info
	 * @return cntrCrntAmt
	 */
	public String getCntrCrntAmt() {
		return this.cntrCrntAmt;
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
	 * @return facSpclFeuAmt
	 */
	public String getFacSpclFeuAmt() {
		return this.facSpclFeuAmt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
	}

	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}

	/**
	 * Column Info
	 * @return crntAmt
	 */
	public String getCrntAmt() {
		return this.crntAmt;
	}

	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}

	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}

	/**
	 * Column Info
	 * @return vslDepDt
	 */
	public String getVslDepDt() {
		return this.vslDepDt;
	}

	/**
	 * Column Info
	 * @return facDryFeuAmt
	 */
	public String getFacDryFeuAmt() {
		return this.facDryFeuAmt;
	}

	/**
	 * Column Info
	 * @return facDivCd
	 */
	public String getFacDivCd() {
		return this.facDivCd;
	}

	/**
	 * Column Info
	 * @return oldCrntAmt
	 */
	public String getOldCrntAmt() {
		return this.oldCrntAmt;
	}

	/**
	 * Column Info
	 * @return facRfTeuAmt
	 */
	public String getFacRfTeuAmt() {
		return this.facRfTeuAmt;
	}

	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}

	/**
	 * Column Info
	 * @return ppdAmt
	 */
	public String getPpdAmt() {
		return this.ppdAmt;
	}

	/**
	 * Column Info
	 * @return facRfFeuAmt
	 */
	public String getFacRfFeuAmt() {
		return this.facRfFeuAmt;
	}

	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return facSpclTeuAmt
	 */
	public String getFacSpclTeuAmt() {
		return this.facSpclTeuAmt;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return blCrntAmt
	 */
	public String getBlCrntAmt() {
		return this.blCrntAmt;
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
	 * @return facDivCd1
	 */
	public String getFacDivCd1() {
		return this.facDivCd1;
	}

	/**
	 * Column Info
	 * @return bkgDryTeuQty
	 */
	public String getBkgDryTeuQty() {
		return this.bkgDryTeuQty;
	}

	/**
	 * Column Info
	 * @return facDryTeuAmt
	 */
	public String getFacDryTeuAmt() {
		return this.facDryTeuAmt;
	}

	/**
	 * Column Info
	 * @return bkgDryFeuQty
	 */
	public String getBkgDryFeuQty() {
		return this.bkgDryFeuQty;
	}

	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}

	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}

	/**
	 * Column Info
	 * @return ofcOption
	 */
	public String getOfcOption() {
		return this.ofcOption;
	}

	/**
	 * Column Info
	 * @return bkgRfFeuQty
	 */
	public String getBkgRfFeuQty() {
		return this.bkgRfFeuQty;
	}

	/**
	 * Column Info
	 * @return bkgRfTeuQty
	 */
	public String getBkgRfTeuQty() {
		return this.bkgRfTeuQty;
	}

	/**
	 * Column Info
	 * @return facStsCd
	 */
	public String getFacStsCd() {
		return this.facStsCd;
	}

	/**
	 * Column Info
	 * @return bkgSpclTeuQty
	 */
	public String getBkgSpclTeuQty() {
		return this.bkgSpclTeuQty;
	}


	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}

	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}

	/**
	 * Column Info
	 * @param facBxAmt
	 */
	public void setFacBxAmt(String facBxAmt) {
		this.facBxAmt = facBxAmt;
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
	 * @param facRmk
	 */
	public void setFacRmk(String facRmk) {
		this.facRmk = facRmk;
	}

	/**
	 * Column Info
	 * @param facSeq
	 */
	public void setFacSeq(String facSeq) {
		this.facSeq = facSeq;
	}

	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * Column Info
	 * @param facOfcCd
	 */
	public void setFacOfcCd(String facOfcCd) {
		this.facOfcCd = facOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgSpclFeuQty
	 */
	public void setBkgSpclFeuQty(String bkgSpclFeuQty) {
		this.bkgSpclFeuQty = bkgSpclFeuQty;
	}

	/**
	 * Column Info
	 * @param facAgmtSeq
	 */
	public void setFacAgmtSeq(String facAgmtSeq) {
		this.facAgmtSeq = facAgmtSeq;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
	}

	/**
	 * Column Info
	 * @param cntrCrntAmt
	 */
	public void setCntrCrntAmt(String cntrCrntAmt) {
		this.cntrCrntAmt = cntrCrntAmt;
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
	 * @param facSpclFeuAmt
	 */
	public void setFacSpclFeuAmt(String facSpclFeuAmt) {
		this.facSpclFeuAmt = facSpclFeuAmt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
	}

	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}

	/**
	 * Column Info
	 * @param crntAmt
	 */
	public void setCrntAmt(String crntAmt) {
		this.crntAmt = crntAmt;
	}

	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}

	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}

	/**
	 * Column Info
	 * @param vslDepDt
	 */
	public void setVslDepDt(String vslDepDt) {
		this.vslDepDt = vslDepDt;
	}

	/**
	 * Column Info
	 * @param facDryFeuAmt
	 */
	public void setFacDryFeuAmt(String facDryFeuAmt) {
		this.facDryFeuAmt = facDryFeuAmt;
	}

	/**
	 * Column Info
	 * @param facDivCd
	 */
	public void setFacDivCd(String facDivCd) {
		this.facDivCd = facDivCd;
	}

	/**
	 * Column Info
	 * @param oldCrntAmt
	 */
	public void setOldCrntAmt(String oldCrntAmt) {
		this.oldCrntAmt = oldCrntAmt;
	}

	/**
	 * Column Info
	 * @param facRfTeuAmt
	 */
	public void setFacRfTeuAmt(String facRfTeuAmt) {
		this.facRfTeuAmt = facRfTeuAmt;
	}

	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * Column Info
	 * @param ppdAmt
	 */
	public void setPpdAmt(String ppdAmt) {
		this.ppdAmt = ppdAmt;
	}

	/**
	 * Column Info
	 * @param facRfFeuAmt
	 */
	public void setFacRfFeuAmt(String facRfFeuAmt) {
		this.facRfFeuAmt = facRfFeuAmt;
	}

	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param facSpclTeuAmt
	 */
	public void setFacSpclTeuAmt(String facSpclTeuAmt) {
		this.facSpclTeuAmt = facSpclTeuAmt;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param blCrntAmt
	 */
	public void setBlCrntAmt(String blCrntAmt) {
		this.blCrntAmt = blCrntAmt;
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
	 * @param facDivCd1
	 */
	public void setFacDivCd1(String facDivCd1) {
		this.facDivCd1 = facDivCd1;
	}

	/**
	 * Column Info
	 * @param bkgDryTeuQty
	 */
	public void setBkgDryTeuQty(String bkgDryTeuQty) {
		this.bkgDryTeuQty = bkgDryTeuQty;
	}

	/**
	 * Column Info
	 * @param facDryTeuAmt
	 */
	public void setFacDryTeuAmt(String facDryTeuAmt) {
		this.facDryTeuAmt = facDryTeuAmt;
	}

	/**
	 * Column Info
	 * @param bkgDryFeuQty
	 */
	public void setBkgDryFeuQty(String bkgDryFeuQty) {
		this.bkgDryFeuQty = bkgDryFeuQty;
	}

	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}

	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}

	/**
	 * Column Info
	 * @param ofcOption
	 */
	public void setOfcOption(String ofcOption) {
		this.ofcOption = ofcOption;
	}

	/**
	 * Column Info
	 * @param bkgRfFeuQty
	 */
	public void setBkgRfFeuQty(String bkgRfFeuQty) {
		this.bkgRfFeuQty = bkgRfFeuQty;
	}

	/**
	 * Column Info
	 * @param bkgRfTeuQty
	 */
	public void setBkgRfTeuQty(String bkgRfTeuQty) {
		this.bkgRfTeuQty = bkgRfTeuQty;
	}

	/**
	 * Column Info
	 * @param facStsCd
	 */
	public void setFacStsCd(String facStsCd) {
		this.facStsCd = facStsCd;
	}

	/**
	 * Column Info
	 * @param bkgSpclTeuQty
	 */
	public void setBkgSpclTeuQty(String bkgSpclTeuQty) {
		this.bkgSpclTeuQty = bkgSpclTeuQty;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setFacBxAmt(JSPUtil.getParameter(request, prefix + "fac_bx_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFacRmk(JSPUtil.getParameter(request, prefix + "fac_rmk", ""));
		setFacSeq(JSPUtil.getParameter(request, prefix + "fac_seq", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFacOfcCd(JSPUtil.getParameter(request, prefix + "fac_ofc_cd", ""));
		setBkgSpclFeuQty(JSPUtil.getParameter(request, prefix + "bkg_spcl_feu_qty", ""));
		setFacAgmtSeq(JSPUtil.getParameter(request, prefix + "fac_agmt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setCntrCrntAmt(JSPUtil.getParameter(request, prefix + "cntr_crnt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFacSpclFeuAmt(JSPUtil.getParameter(request, prefix + "fac_spcl_feu_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setCrntAmt(JSPUtil.getParameter(request, prefix + "crnt_amt", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setFacDryFeuAmt(JSPUtil.getParameter(request, prefix + "fac_dry_feu_amt", ""));
		setFacDivCd(JSPUtil.getParameter(request, prefix + "fac_div_cd", ""));
		setOldCrntAmt(JSPUtil.getParameter(request, prefix + "old_crnt_amt", ""));
		setFacRfTeuAmt(JSPUtil.getParameter(request, prefix + "fac_rf_teu_amt", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setPpdAmt(JSPUtil.getParameter(request, prefix + "ppd_amt", ""));
		setFacRfFeuAmt(JSPUtil.getParameter(request, prefix + "fac_rf_feu_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setFacSpclTeuAmt(JSPUtil.getParameter(request, prefix + "fac_spcl_teu_amt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBlCrntAmt(JSPUtil.getParameter(request, prefix + "bl_crnt_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFacDivCd1(JSPUtil.getParameter(request, prefix + "fac_div_cd_1", ""));
		setBkgDryTeuQty(JSPUtil.getParameter(request, prefix + "bkg_dry_teu_qty", ""));
		setFacDryTeuAmt(JSPUtil.getParameter(request, prefix + "fac_dry_teu_amt", ""));
		setBkgDryFeuQty(JSPUtil.getParameter(request, prefix + "bkg_dry_feu_qty", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setOfcOption(JSPUtil.getParameter(request, prefix + "ofc_option", ""));
		setBkgRfFeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_feu_qty", ""));
		setBkgRfTeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_teu_qty", ""));
		setFacStsCd(JSPUtil.getParameter(request, prefix + "fac_sts_cd", ""));
		setBkgSpclTeuQty(JSPUtil.getParameter(request, prefix + "bkg_spcl_teu_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FACCommListVO[]
	 */
	public FACCommListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FACCommListVO[]
	 */
	public FACCommListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FACCommListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] facBxAmt = (JSPUtil.getParameter(request, prefix	+ "fac_bx_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] facRmk = (JSPUtil.getParameter(request, prefix	+ "fac_rmk", length));
			String[] facSeq = (JSPUtil.getParameter(request, prefix	+ "fac_seq", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] facOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_ofc_cd", length));
			String[] bkgSpclFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_spcl_feu_qty", length));
			String[] facAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "fac_agmt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] cntrCrntAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_crnt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] facSpclFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_feu_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] crntAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_amt", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] facDryFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_dry_feu_amt", length));
			String[] facDivCd = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd", length));
			String[] oldCrntAmt = (JSPUtil.getParameter(request, prefix	+ "old_crnt_amt", length));
			String[] facRfTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_teu_amt", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ppdAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_amt", length));
			String[] facRfFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_feu_amt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] facSpclTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_teu_amt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] blCrntAmt = (JSPUtil.getParameter(request, prefix	+ "bl_crnt_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] facDivCd1 = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd_1", length));
			String[] bkgDryTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_dry_teu_qty", length));
			String[] facDryTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_dry_teu_amt", length));
			String[] bkgDryFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_dry_feu_qty", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] ofcOption = (JSPUtil.getParameter(request, prefix	+ "ofc_option", length));
			String[] bkgRfFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_feu_qty", length));
			String[] bkgRfTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_teu_qty", length));
			String[] facStsCd = (JSPUtil.getParameter(request, prefix	+ "fac_sts_cd", length));
			String[] bkgSpclTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_spcl_teu_qty", length));

			for (int i = 0; i < length; i++) {
				model = new FACCommListVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (facBxAmt[i] != null)
					model.setFacBxAmt(facBxAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (facRmk[i] != null)
					model.setFacRmk(facRmk[i]);
				if (facSeq[i] != null)
					model.setFacSeq(facSeq[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (facOfcCd[i] != null)
					model.setFacOfcCd(facOfcCd[i]);
				if (bkgSpclFeuQty[i] != null)
					model.setBkgSpclFeuQty(bkgSpclFeuQty[i]);
				if (facAgmtSeq[i] != null)
					model.setFacAgmtSeq(facAgmtSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (cntrCrntAmt[i] != null)
					model.setCntrCrntAmt(cntrCrntAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (facSpclFeuAmt[i] != null)
					model.setFacSpclFeuAmt(facSpclFeuAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (crntAmt[i] != null)
					model.setCrntAmt(crntAmt[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (facDryFeuAmt[i] != null)
					model.setFacDryFeuAmt(facDryFeuAmt[i]);
				if (facDivCd[i] != null)
					model.setFacDivCd(facDivCd[i]);
				if (oldCrntAmt[i] != null)
					model.setOldCrntAmt(oldCrntAmt[i]);
				if (facRfTeuAmt[i] != null)
					model.setFacRfTeuAmt(facRfTeuAmt[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ppdAmt[i] != null)
					model.setPpdAmt(ppdAmt[i]);
				if (facRfFeuAmt[i] != null)
					model.setFacRfFeuAmt(facRfFeuAmt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (facSpclTeuAmt[i] != null)
					model.setFacSpclTeuAmt(facSpclTeuAmt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (blCrntAmt[i] != null)
					model.setBlCrntAmt(blCrntAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (facDivCd1[i] != null)
					model.setFacDivCd1(facDivCd1[i]);
				if (bkgDryTeuQty[i] != null)
					model.setBkgDryTeuQty(bkgDryTeuQty[i]);
				if (facDryTeuAmt[i] != null)
					model.setFacDryTeuAmt(facDryTeuAmt[i]);
				if (bkgDryFeuQty[i] != null)
					model.setBkgDryFeuQty(bkgDryFeuQty[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (ofcOption[i] != null)
					model.setOfcOption(ofcOption[i]);
				if (bkgRfFeuQty[i] != null)
					model.setBkgRfFeuQty(bkgRfFeuQty[i]);
				if (bkgRfTeuQty[i] != null)
					model.setBkgRfTeuQty(bkgRfTeuQty[i]);
				if (facStsCd[i] != null)
					model.setFacStsCd(facStsCd[i]);
				if (bkgSpclTeuQty[i] != null)
					model.setBkgSpclTeuQty(bkgSpclTeuQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFACCommListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FACCommListVO[]
	 */
	public FACCommListVO[] getFACCommListVOs(){
		FACCommListVO[] vos = (FACCommListVO[])models.toArray(new FACCommListVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBxAmt = this.facBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRmk = this.facRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSeq = this.facSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facOfcCd = this.facOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpclFeuQty = this.bkgSpclFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAgmtSeq = this.facAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCrntAmt = this.cntrCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclFeuAmt = this.facSpclFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAmt = this.crntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDryFeuAmt = this.facDryFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd = this.facDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCrntAmt = this.oldCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfTeuAmt = this.facRfTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt = this.ppdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfFeuAmt = this.facRfFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclTeuAmt = this.facSpclTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCrntAmt = this.blCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd1 = this.facDivCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDryTeuQty = this.bkgDryTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDryTeuAmt = this.facDryTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDryFeuQty = this.bkgDryFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcOption = this.ofcOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfFeuQty = this.bkgRfFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfTeuQty = this.bkgRfTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facStsCd = this.facStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpclTeuQty = this.bkgSpclTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
