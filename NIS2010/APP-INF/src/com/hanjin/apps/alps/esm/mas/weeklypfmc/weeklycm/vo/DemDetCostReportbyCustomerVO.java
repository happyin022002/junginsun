/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetCostReportbyCustomerVO.java
*@FileTitle : DemDetCostReportbyCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.12
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.12 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemDetCostReportbyCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemDetCostReportbyCustomerVO> models = new ArrayList<DemDetCostReportbyCustomerVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String chssDemAmt = null;
	/* Column Info */
	private String chssOrgDemAmt = null;
	/* Column Info */
	private String fSc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fStatus = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String stoEqAmt = null;
	/* Column Info */
	private String fDel = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String fTpsz = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String cmpb2 = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String cntrOrgDemAmt = null;
	/* Column Info */
	private String fPor = null;
	/* Column Info */
	private String fRfa = null;
	/* Column Info */
	private String cmpb = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String dmdtComAmt = null;
	/* Column Info */
	private String dmdtComAmt2 = null;
	/* Column Info */
	private String cntrDemAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String fDemdet = null;
	/* Column Info */
	private String stoDemAmt = null;
	/* Column Info */
	private String fCOfc = null;
	/* Column Info */
	private String fYear = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DemDetCostReportbyCustomerVO() {}

	public DemDetCostReportbyCustomerVO(String ibflag, String pagerows, String ctrtOfcCd, String porCd, String delCd, String scNo, String rfaNo, String cntrTpszCd, String bkgQty, String cmpb, String stoEqAmt, String cntrOrgDemAmt, String chssOrgDemAmt, String stoDemAmt, String cntrDemAmt, String chssDemAmt, String cmpb2, String fCOfc, String fPor, String fDel, String fTpsz, String fSc, String fRfa, String costYrmon, String costWk, String status, String dmdtComAmt, String cntrQty, String dmdtComAmt2, String fChkprd, String fYear, String fFmMon, String fToMon, String fFmWk, String fToWk, String fDemdet, String fStatus) {
		this.porCd = porCd;
		this.fChkprd = fChkprd;
		this.fFmMon = fFmMon;
		this.chssDemAmt = chssDemAmt;
		this.chssOrgDemAmt = chssOrgDemAmt;
		this.fSc = fSc;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.fStatus = fStatus;
		this.costYrmon = costYrmon;
		this.stoEqAmt = stoEqAmt;
		this.fDel = fDel;
		this.bkgQty = bkgQty;
		this.scNo = scNo;
		this.ctrtOfcCd = ctrtOfcCd;
		this.fTpsz = fTpsz;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrQty = cntrQty;
		this.fFmWk = fFmWk;
		this.cmpb2 = cmpb2;
		this.status = status;
		this.delCd = delCd;
		this.fToMon = fToMon;
		this.cntrOrgDemAmt = cntrOrgDemAmt;
		this.fPor = fPor;
		this.fRfa = fRfa;
		this.cmpb = cmpb;
		this.fToWk = fToWk;
		this.dmdtComAmt = dmdtComAmt;
		this.dmdtComAmt2 = dmdtComAmt2;
		this.cntrDemAmt = cntrDemAmt;
		this.costWk = costWk;
		this.fDemdet = fDemdet;
		this.stoDemAmt = stoDemAmt;
		this.fCOfc = fCOfc;
		this.fYear = fYear;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("chss_dem_amt", getChssDemAmt());
		this.hashColumns.put("chss_org_dem_amt", getChssOrgDemAmt());
		this.hashColumns.put("f_sc", getFSc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_status", getFStatus());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("sto_eq_amt", getStoEqAmt());
		this.hashColumns.put("f_del", getFDel());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("f_tpsz", getFTpsz());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("cmpb2", getCmpb2());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("cntr_org_dem_amt", getCntrOrgDemAmt());
		this.hashColumns.put("f_por", getFPor());
		this.hashColumns.put("f_rfa", getFRfa());
		this.hashColumns.put("cmpb", getCmpb());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("dmdt_com_amt", getDmdtComAmt());
		this.hashColumns.put("dmdt_com_amt2", getDmdtComAmt2());
		this.hashColumns.put("cntr_dem_amt", getCntrDemAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("f_demdet", getFDemdet());
		this.hashColumns.put("sto_dem_amt", getStoDemAmt());
		this.hashColumns.put("f_c_ofc", getFCOfc());
		this.hashColumns.put("f_year", getFYear());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("chss_dem_amt", "chssDemAmt");
		this.hashFields.put("chss_org_dem_amt", "chssOrgDemAmt");
		this.hashFields.put("f_sc", "fSc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_status", "fStatus");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("sto_eq_amt", "stoEqAmt");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("f_tpsz", "fTpsz");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("cmpb2", "cmpb2");
		this.hashFields.put("status", "status");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("cntr_org_dem_amt", "cntrOrgDemAmt");
		this.hashFields.put("f_por", "fPor");
		this.hashFields.put("f_rfa", "fRfa");
		this.hashFields.put("cmpb", "cmpb");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("dmdt_com_amt", "dmdtComAmt");
		this.hashFields.put("dmdt_com_amt2", "dmdtComAmt2");
		this.hashFields.put("cntr_dem_amt", "cntrDemAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("f_demdet", "fDemdet");
		this.hashFields.put("sto_dem_amt", "stoDemAmt");
		this.hashFields.put("f_c_ofc", "fCOfc");
		this.hashFields.put("f_year", "fYear");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return fChkprd
	 */
	public String getFChkprd() {
		return this.fChkprd;
	}
	
	/**
	 * Column Info
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return chssDemAmt
	 */
	public String getChssDemAmt() {
		return this.chssDemAmt;
	}
	
	/**
	 * Column Info
	 * @return chssOrgDemAmt
	 */
	public String getChssOrgDemAmt() {
		return this.chssOrgDemAmt;
	}
	
	/**
	 * Column Info
	 * @return fSc
	 */
	public String getFSc() {
		return this.fSc;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return fStatus
	 */
	public String getFStatus() {
		return this.fStatus;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return stoEqAmt
	 */
	public String getStoEqAmt() {
		return this.stoEqAmt;
	}
	
	/**
	 * Column Info
	 * @return fDel
	 */
	public String getFDel() {
		return this.fDel;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fTpsz
	 */
	public String getFTpsz() {
		return this.fTpsz;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return cmpb2
	 */
	public String getCmpb2() {
		return this.cmpb2;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return fToMon
	 */
	public String getFToMon() {
		return this.fToMon;
	}
	
	/**
	 * Column Info
	 * @return cntrOrgDemAmt
	 */
	public String getCntrOrgDemAmt() {
		return this.cntrOrgDemAmt;
	}
	
	/**
	 * Column Info
	 * @return fPor
	 */
	public String getFPor() {
		return this.fPor;
	}
	
	/**
	 * Column Info
	 * @return fRfa
	 */
	public String getFRfa() {
		return this.fRfa;
	}
	
	/**
	 * Column Info
	 * @return cmpb
	 */
	public String getCmpb() {
		return this.cmpb;
	}
	
	/**
	 * Column Info
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
	}
	
	/**
	 * Column Info
	 * @return dmdtComAmt
	 */
	public String getDmdtComAmt() {
		return this.dmdtComAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtComAmt2
	 */
	public String getDmdtComAmt2() {
		return this.dmdtComAmt2;
	}
	
	/**
	 * Column Info
	 * @return cntrDemAmt
	 */
	public String getCntrDemAmt() {
		return this.cntrDemAmt;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return fDemdet
	 */
	public String getFDemdet() {
		return this.fDemdet;
	}
	
	/**
	 * Column Info
	 * @return stoDemAmt
	 */
	public String getStoDemAmt() {
		return this.stoDemAmt;
	}
	
	/**
	 * Column Info
	 * @return fCOfc
	 */
	public String getFCOfc() {
		return this.fCOfc;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
	}
	
	/**
	 * Column Info
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}
	
	/**
	 * Column Info
	 * @param chssDemAmt
	 */
	public void setChssDemAmt(String chssDemAmt) {
		this.chssDemAmt = chssDemAmt;
	}
	
	/**
	 * Column Info
	 * @param chssOrgDemAmt
	 */
	public void setChssOrgDemAmt(String chssOrgDemAmt) {
		this.chssOrgDemAmt = chssOrgDemAmt;
	}
	
	/**
	 * Column Info
	 * @param fSc
	 */
	public void setFSc(String fSc) {
		this.fSc = fSc;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param fStatus
	 */
	public void setFStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param stoEqAmt
	 */
	public void setStoEqAmt(String stoEqAmt) {
		this.stoEqAmt = stoEqAmt;
	}
	
	/**
	 * Column Info
	 * @param fDel
	 */
	public void setFDel(String fDel) {
		this.fDel = fDel;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fTpsz
	 */
	public void setFTpsz(String fTpsz) {
		this.fTpsz = fTpsz;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param cmpb2
	 */
	public void setCmpb2(String cmpb2) {
		this.cmpb2 = cmpb2;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param fToMon
	 */
	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}
	
	/**
	 * Column Info
	 * @param cntrOrgDemAmt
	 */
	public void setCntrOrgDemAmt(String cntrOrgDemAmt) {
		this.cntrOrgDemAmt = cntrOrgDemAmt;
	}
	
	/**
	 * Column Info
	 * @param fPor
	 */
	public void setFPor(String fPor) {
		this.fPor = fPor;
	}
	
	/**
	 * Column Info
	 * @param fRfa
	 */
	public void setFRfa(String fRfa) {
		this.fRfa = fRfa;
	}
	
	/**
	 * Column Info
	 * @param cmpb
	 */
	public void setCmpb(String cmpb) {
		this.cmpb = cmpb;
	}
	
	/**
	 * Column Info
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
	}
	
	/**
	 * Column Info
	 * @param dmdtComAmt
	 */
	public void setDmdtComAmt(String dmdtComAmt) {
		this.dmdtComAmt = dmdtComAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtComAmt2
	 */
	public void setDmdtComAmt2(String dmdtComAmt2) {
		this.dmdtComAmt2 = dmdtComAmt2;
	}
	
	/**
	 * Column Info
	 * @param cntrDemAmt
	 */
	public void setCntrDemAmt(String cntrDemAmt) {
		this.cntrDemAmt = cntrDemAmt;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param fDemdet
	 */
	public void setFDemdet(String fDemdet) {
		this.fDemdet = fDemdet;
	}
	
	/**
	 * Column Info
	 * @param stoDemAmt
	 */
	public void setStoDemAmt(String stoDemAmt) {
		this.stoDemAmt = stoDemAmt;
	}
	
	/**
	 * Column Info
	 * @param fCOfc
	 */
	public void setFCOfc(String fCOfc) {
		this.fCOfc = fCOfc;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setChssDemAmt(JSPUtil.getParameter(request, prefix + "chss_dem_amt", ""));
		setChssOrgDemAmt(JSPUtil.getParameter(request, prefix + "chss_org_dem_amt", ""));
		setFSc(JSPUtil.getParameter(request, prefix + "f_sc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFStatus(JSPUtil.getParameter(request, prefix + "f_status", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setStoEqAmt(JSPUtil.getParameter(request, prefix + "sto_eq_amt", ""));
		setFDel(JSPUtil.getParameter(request, prefix + "f_del", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setFTpsz(JSPUtil.getParameter(request, prefix + "f_tpsz", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setCmpb2(JSPUtil.getParameter(request, prefix + "cmpb2", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setCntrOrgDemAmt(JSPUtil.getParameter(request, prefix + "cntr_org_dem_amt", ""));
		setFPor(JSPUtil.getParameter(request, prefix + "f_por", ""));
		setFRfa(JSPUtil.getParameter(request, prefix + "f_rfa", ""));
		setCmpb(JSPUtil.getParameter(request, prefix + "cmpb", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setDmdtComAmt(JSPUtil.getParameter(request, prefix + "dmdt_com_amt", ""));
		setDmdtComAmt2(JSPUtil.getParameter(request, prefix + "dmdt_com_amt2", ""));
		setCntrDemAmt(JSPUtil.getParameter(request, prefix + "cntr_dem_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setFDemdet(JSPUtil.getParameter(request, prefix + "f_demdet", ""));
		setStoDemAmt(JSPUtil.getParameter(request, prefix + "sto_dem_amt", ""));
		setFCOfc(JSPUtil.getParameter(request, prefix + "f_c_ofc", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemDetCostReportbyCustomerVO[]
	 */
	public DemDetCostReportbyCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemDetCostReportbyCustomerVO[]
	 */
	public DemDetCostReportbyCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemDetCostReportbyCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] chssDemAmt = (JSPUtil.getParameter(request, prefix	+ "chss_dem_amt", length));
			String[] chssOrgDemAmt = (JSPUtil.getParameter(request, prefix	+ "chss_org_dem_amt", length));
			String[] fSc = (JSPUtil.getParameter(request, prefix	+ "f_sc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fStatus = (JSPUtil.getParameter(request, prefix	+ "f_status", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] stoEqAmt = (JSPUtil.getParameter(request, prefix	+ "sto_eq_amt", length));
			String[] fDel = (JSPUtil.getParameter(request, prefix	+ "f_del", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] fTpsz = (JSPUtil.getParameter(request, prefix	+ "f_tpsz", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] cmpb2 = (JSPUtil.getParameter(request, prefix	+ "cmpb2", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] cntrOrgDemAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_org_dem_amt", length));
			String[] fPor = (JSPUtil.getParameter(request, prefix	+ "f_por", length));
			String[] fRfa = (JSPUtil.getParameter(request, prefix	+ "f_rfa", length));
			String[] cmpb = (JSPUtil.getParameter(request, prefix	+ "cmpb", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] dmdtComAmt = (JSPUtil.getParameter(request, prefix	+ "dmdt_com_amt", length));
			String[] dmdtComAmt2 = (JSPUtil.getParameter(request, prefix	+ "dmdt_com_amt2", length));
			String[] cntrDemAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_dem_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] fDemdet = (JSPUtil.getParameter(request, prefix	+ "f_demdet", length));
			String[] stoDemAmt = (JSPUtil.getParameter(request, prefix	+ "sto_dem_amt", length));
			String[] fCOfc = (JSPUtil.getParameter(request, prefix	+ "f_c_ofc", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemDetCostReportbyCustomerVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (chssDemAmt[i] != null)
					model.setChssDemAmt(chssDemAmt[i]);
				if (chssOrgDemAmt[i] != null)
					model.setChssOrgDemAmt(chssOrgDemAmt[i]);
				if (fSc[i] != null)
					model.setFSc(fSc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fStatus[i] != null)
					model.setFStatus(fStatus[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (stoEqAmt[i] != null)
					model.setStoEqAmt(stoEqAmt[i]);
				if (fDel[i] != null)
					model.setFDel(fDel[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (fTpsz[i] != null)
					model.setFTpsz(fTpsz[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (cmpb2[i] != null)
					model.setCmpb2(cmpb2[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (cntrOrgDemAmt[i] != null)
					model.setCntrOrgDemAmt(cntrOrgDemAmt[i]);
				if (fPor[i] != null)
					model.setFPor(fPor[i]);
				if (fRfa[i] != null)
					model.setFRfa(fRfa[i]);
				if (cmpb[i] != null)
					model.setCmpb(cmpb[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (dmdtComAmt[i] != null)
					model.setDmdtComAmt(dmdtComAmt[i]);
				if (dmdtComAmt2[i] != null)
					model.setDmdtComAmt2(dmdtComAmt2[i]);
				if (cntrDemAmt[i] != null)
					model.setCntrDemAmt(cntrDemAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (fDemdet[i] != null)
					model.setFDemdet(fDemdet[i]);
				if (stoDemAmt[i] != null)
					model.setStoDemAmt(stoDemAmt[i]);
				if (fCOfc[i] != null)
					model.setFCOfc(fCOfc[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemDetCostReportbyCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemDetCostReportbyCustomerVO[]
	 */
	public DemDetCostReportbyCustomerVO[] getDemDetCostReportbyCustomerVOs(){
		DemDetCostReportbyCustomerVO[] vos = (DemDetCostReportbyCustomerVO[])models.toArray(new DemDetCostReportbyCustomerVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssDemAmt = this.chssDemAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOrgDemAmt = this.chssOrgDemAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSc = this.fSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStatus = this.fStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoEqAmt = this.stoEqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel = this.fDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTpsz = this.fTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb2 = this.cmpb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOrgDemAmt = this.cntrOrgDemAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPor = this.fPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfa = this.fRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb = this.cmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtComAmt = this.dmdtComAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtComAmt2 = this.dmdtComAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDemAmt = this.cntrDemAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDemdet = this.fDemdet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDemAmt = this.stoDemAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCOfc = this.fCOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
