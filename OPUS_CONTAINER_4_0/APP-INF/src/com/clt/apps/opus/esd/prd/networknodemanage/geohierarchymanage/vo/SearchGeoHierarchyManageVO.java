/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchGeoHierarchyManageVO.java
*@FileTitle : SearchGeoHierarchyManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class SearchGeoHierarchyManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchGeoHierarchyManageVO> models = new ArrayList<SearchGeoHierarchyManageVO>();
	
	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String znDivBselCd = null;
	/* Column Info */
	private String gmtHrs = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String portInlndCd = null;
	/* Column Info */
	private String portInlndFlg = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locAmsPortCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cntNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgBlPfxCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String locChrCd = null;
	/* Column Info */
	private String repZnCd = null;
	/* Column Info */
	private String regionCode = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String subcontiCode = null;
	/* Column Info */
	private String callPortFlg = null;
	/* Column Info */
	private String rgnNm = null;
	/* Column Info */
	private String unLocIndCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String customers = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String comercialZone = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String locGrdNo = null;
	/* Column Info */
	private String eqRtnYdCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String fincCtrlOfcCd = null;
	/* Column Info */
	private String senEqOfcCd = null;
	/* Column Info */
	private String contiCode = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchGeoHierarchyManageVO() {}

	public SearchGeoHierarchyManageVO(String ibflag, String pagerows, String contiCd, String contiNm, String scontiCd, String scontiNm, String cntCd, String cntNm, String znDivBselCd, String rgnCd, String rgnNm, String locCd, String locNm, String remark, String steCd, String steNm, String unLocIndCd, String unLocCd, String locGrdNo, String rccCd, String lccCd, String eccCd, String sccCd, String locChrCd, String slsOfcCd, String eqCtrlOfcCd, String fincCtrlOfcCd, String senEqOfcCd, String bkgBlPfxCd, String comercialZone, String customers, String repZnCd, String eqRtnYdCd, String locAmsPortCd, String gmtHrs, String portInlndCd, String callPortFlg, String mtyPkupYdCd, String contiCode, String subcontiCode, String countryCode, String regionCode, String locationCode, String portInlndFlg) {
		this.scontiNm = scontiNm;
		this.contiCd = contiCd;
		this.rgnCd = rgnCd;
		this.znDivBselCd = znDivBselCd;
		this.gmtHrs = gmtHrs;
		this.unLocCd = unLocCd;
		this.remark = remark;
		this.portInlndCd = portInlndCd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.pagerows = pagerows;
		this.locAmsPortCd = locAmsPortCd;
		this.locCd = locCd;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.bkgBlPfxCd = bkgBlPfxCd;
		this.cntCd = cntCd;
		this.slsOfcCd = slsOfcCd;
		this.locChrCd = locChrCd;
		this.repZnCd = repZnCd;
		this.regionCode = regionCode;
		this.eccCd = eccCd;
		this.countryCode = countryCode;
		this.subcontiCode = subcontiCode;
		this.callPortFlg = callPortFlg;
		this.rgnNm = rgnNm;
		this.unLocIndCd = unLocIndCd;
		this.rccCd = rccCd;
		this.customers = customers;
		this.locNm = locNm;
		this.locationCode = locationCode;
		this.comercialZone = comercialZone;
		this.lccCd = lccCd;
		this.locGrdNo = locGrdNo;
		this.eqRtnYdCd = eqRtnYdCd;
		this.sccCd = sccCd;
		this.steNm = steNm;
		this.contiNm = contiNm;
		this.fincCtrlOfcCd = fincCtrlOfcCd;
		this.senEqOfcCd = senEqOfcCd;
		this.contiCode = contiCode;
		this.steCd = steCd;
		this.scontiCd = scontiCd;
		this.portInlndFlg = portInlndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("zn_div_bsel_cd", getZnDivBselCd());
		this.hashColumns.put("gmt_hrs", getGmtHrs());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("port_inlnd_cd", getPortInlndCd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_bl_pfx_cd", getBkgBlPfxCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("loc_chr_cd", getLocChrCd());
		this.hashColumns.put("rep_zn_cd", getRepZnCd());
		this.hashColumns.put("region_code", getRegionCode());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("subconti_code", getSubcontiCode());
		this.hashColumns.put("call_port_flg", getCallPortFlg());
		this.hashColumns.put("rgn_nm", getRgnNm());
		this.hashColumns.put("un_loc_ind_cd", getUnLocIndCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("customers", getCustomers());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("comercial_zone", getComercialZone());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("loc_grd_no", getLocGrdNo());
		this.hashColumns.put("eq_rtn_yd_cd", getEqRtnYdCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
		this.hashColumns.put("sen_eq_ofc_cd", getSenEqOfcCd());
		this.hashColumns.put("conti_code", getContiCode());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("port_inlnd_flg", getPortInlndFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("zn_div_bsel_cd", "znDivBselCd");
		this.hashFields.put("gmt_hrs", "gmtHrs");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("port_inlnd_cd", "portInlndCd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_bl_pfx_cd", "bkgBlPfxCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("loc_chr_cd", "locChrCd");
		this.hashFields.put("rep_zn_cd", "repZnCd");
		this.hashFields.put("region_code", "regionCode");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("subconti_code", "subcontiCode");
		this.hashFields.put("call_port_flg", "callPortFlg");
		this.hashFields.put("rgn_nm", "rgnNm");
		this.hashFields.put("un_loc_ind_cd", "unLocIndCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("customers", "customers");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("comercial_zone", "comercialZone");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("loc_grd_no", "locGrdNo");
		this.hashFields.put("eq_rtn_yd_cd", "eqRtnYdCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
		this.hashFields.put("sen_eq_ofc_cd", "senEqOfcCd");
		this.hashFields.put("conti_code", "contiCode");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("port_inlnd_flg", "portInlndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return znDivBselCd
	 */
	public String getZnDivBselCd() {
		return this.znDivBselCd;
	}
	
	/**
	 * Column Info
	 * @return gmtHrs
	 */
	public String getGmtHrs() {
		return this.gmtHrs;
	}
	
	/**
	 * Column Info
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return portInlndCd
	 */
	public String getPortInlndCd() {
		return this.portInlndCd;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
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
	 * @return locAmsPortCd
	 */
	public String getLocAmsPortCd() {
		return this.locAmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return bkgBlPfxCd
	 */
	public String getBkgBlPfxCd() {
		return this.bkgBlPfxCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return locChrCd
	 */
	public String getLocChrCd() {
		return this.locChrCd;
	}
	
	/**
	 * Column Info
	 * @return repZnCd
	 */
	public String getRepZnCd() {
		return this.repZnCd;
	}
	
	/**
	 * Column Info
	 * @return regionCode
	 */
	public String getRegionCode() {
		return this.regionCode;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
	
	/**
	 * Column Info
	 * @return subcontiCode
	 */
	public String getSubcontiCode() {
		return this.subcontiCode;
	}
	
	/**
	 * Column Info
	 * @return callPortFlg
	 */
	public String getCallPortFlg() {
		return this.callPortFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnNm
	 */
	public String getRgnNm() {
		return this.rgnNm;
	}
	
	/**
	 * Column Info
	 * @return unLocIndCd
	 */
	public String getUnLocIndCd() {
		return this.unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return customers
	 */
	public String getCustomers() {
		return this.customers;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	/**
	 * Column Info
	 * @return comercialZone
	 */
	public String getComercialZone() {
		return this.comercialZone;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return locGrdNo
	 */
	public String getLocGrdNo() {
		return this.locGrdNo;
	}
	
	/**
	 * Column Info
	 * @return eqRtnYdCd
	 */
	public String getEqRtnYdCd() {
		return this.eqRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
	}
	
	/**
	 * Column Info
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return fincCtrlOfcCd
	 */
	public String getFincCtrlOfcCd() {
		return this.fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return senEqOfcCd
	 */
	public String getSenEqOfcCd() {
		return this.senEqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return contiCode
	 */
	public String getContiCode() {
		return this.contiCode;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	

	public String getPortInlndFlg() {
		return portInlndFlg;
	}

	public void setPortInlndFlg(String portInlndFlg) {
		this.portInlndFlg = portInlndFlg;
	}

	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param znDivBselCd
	 */
	public void setZnDivBselCd(String znDivBselCd) {
		this.znDivBselCd = znDivBselCd;
	}
	
	/**
	 * Column Info
	 * @param gmtHrs
	 */
	public void setGmtHrs(String gmtHrs) {
		this.gmtHrs = gmtHrs;
	}
	
	/**
	 * Column Info
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param portInlndCd
	 */
	public void setPortInlndCd(String portInlndCd) {
		this.portInlndCd = portInlndCd;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
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
	 * @param locAmsPortCd
	 */
	public void setLocAmsPortCd(String locAmsPortCd) {
		this.locAmsPortCd = locAmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param bkgBlPfxCd
	 */
	public void setBkgBlPfxCd(String bkgBlPfxCd) {
		this.bkgBlPfxCd = bkgBlPfxCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param locChrCd
	 */
	public void setLocChrCd(String locChrCd) {
		this.locChrCd = locChrCd;
	}
	
	/**
	 * Column Info
	 * @param repZnCd
	 */
	public void setRepZnCd(String repZnCd) {
		this.repZnCd = repZnCd;
	}
	
	/**
	 * Column Info
	 * @param regionCode
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * Column Info
	 * @param subcontiCode
	 */
	public void setSubcontiCode(String subcontiCode) {
		this.subcontiCode = subcontiCode;
	}
	
	/**
	 * Column Info
	 * @param callPortFlg
	 */
	public void setCallPortFlg(String callPortFlg) {
		this.callPortFlg = callPortFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnNm
	 */
	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
	}
	
	/**
	 * Column Info
	 * @param unLocIndCd
	 */
	public void setUnLocIndCd(String unLocIndCd) {
		this.unLocIndCd = unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param customers
	 */
	public void setCustomers(String customers) {
		this.customers = customers;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Column Info
	 * @param comercialZone
	 */
	public void setComercialZone(String comercialZone) {
		this.comercialZone = comercialZone;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param locGrdNo
	 */
	public void setLocGrdNo(String locGrdNo) {
		this.locGrdNo = locGrdNo;
	}
	
	/**
	 * Column Info
	 * @param eqRtnYdCd
	 */
	public void setEqRtnYdCd(String eqRtnYdCd) {
		this.eqRtnYdCd = eqRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param fincCtrlOfcCd
	 */
	public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
		this.fincCtrlOfcCd = fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param senEqOfcCd
	 */
	public void setSenEqOfcCd(String senEqOfcCd) {
		this.senEqOfcCd = senEqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param contiCode
	 */
	public void setContiCode(String contiCode) {
		this.contiCode = contiCode;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setZnDivBselCd(JSPUtil.getParameter(request, "zn_div_bsel_cd", ""));
		setGmtHrs(JSPUtil.getParameter(request, "gmt_hrs", ""));
		setUnLocCd(JSPUtil.getParameter(request, "un_loc_cd", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setPortInlndCd(JSPUtil.getParameter(request, "port_inlnd_cd", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, "mty_pkup_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocAmsPortCd(JSPUtil.getParameter(request, "loc_ams_port_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgBlPfxCd(JSPUtil.getParameter(request, "bkg_bl_pfx_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setLocChrCd(JSPUtil.getParameter(request, "loc_chr_cd", ""));
		setRepZnCd(JSPUtil.getParameter(request, "rep_zn_cd", ""));
		setRegionCode(JSPUtil.getParameter(request, "region_code", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setCountryCode(JSPUtil.getParameter(request, "country_code", ""));
		setSubcontiCode(JSPUtil.getParameter(request, "subconti_code", ""));
		setCallPortFlg(JSPUtil.getParameter(request, "call_port_flg", ""));
		setRgnNm(JSPUtil.getParameter(request, "rgn_nm", ""));
		setUnLocIndCd(JSPUtil.getParameter(request, "un_loc_ind_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setCustomers(JSPUtil.getParameter(request, "customers", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setLocationCode(JSPUtil.getParameter(request, "location_code", ""));
		setComercialZone(JSPUtil.getParameter(request, "comercial_zone", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setLocGrdNo(JSPUtil.getParameter(request, "loc_grd_no", ""));
		setEqRtnYdCd(JSPUtil.getParameter(request, "eq_rtn_yd_cd", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setSteNm(JSPUtil.getParameter(request, "ste_nm", ""));
		setContiNm(JSPUtil.getParameter(request, "conti_nm", ""));
		setFincCtrlOfcCd(JSPUtil.getParameter(request, "finc_ctrl_ofc_cd", ""));
		setSenEqOfcCd(JSPUtil.getParameter(request, "sen_eq_ofc_cd", ""));
		setContiCode(JSPUtil.getParameter(request, "conti_code", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPortInlndFlg(JSPUtil.getParameter(request, "port_inlnd_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchGeoHierarchyManageVO[]
	 */
	public SearchGeoHierarchyManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchGeoHierarchyManageVO[]
	 */
	public SearchGeoHierarchyManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchGeoHierarchyManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] znDivBselCd = (JSPUtil.getParameter(request, prefix	+ "zn_div_bsel_cd", length));
			String[] gmtHrs = (JSPUtil.getParameter(request, prefix	+ "gmt_hrs", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] portInlndCd = (JSPUtil.getParameter(request, prefix	+ "port_inlnd_cd", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix	+ "loc_ams_port_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgBlPfxCd = (JSPUtil.getParameter(request, prefix	+ "bkg_bl_pfx_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] locChrCd = (JSPUtil.getParameter(request, prefix	+ "loc_chr_cd", length));
			String[] repZnCd = (JSPUtil.getParameter(request, prefix	+ "rep_zn_cd", length));
			String[] regionCode = (JSPUtil.getParameter(request, prefix	+ "region_code", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix	+ "country_code", length));
			String[] subcontiCode = (JSPUtil.getParameter(request, prefix	+ "subconti_code", length));
			String[] callPortFlg = (JSPUtil.getParameter(request, prefix	+ "call_port_flg", length));
			String[] rgnNm = (JSPUtil.getParameter(request, prefix	+ "rgn_nm", length));
			String[] unLocIndCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_ind_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] customers = (JSPUtil.getParameter(request, prefix	+ "customers", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] comercialZone = (JSPUtil.getParameter(request, prefix	+ "comercial_zone", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] locGrdNo = (JSPUtil.getParameter(request, prefix	+ "loc_grd_no", length));
			String[] eqRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "eq_rtn_yd_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ctrl_ofc_cd", length));
			String[] senEqOfcCd = (JSPUtil.getParameter(request, prefix	+ "sen_eq_ofc_cd", length));
			String[] contiCode = (JSPUtil.getParameter(request, prefix	+ "conti_code", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] portInlndFlg = (JSPUtil.getParameter(request, prefix	+ "port_inlnd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchGeoHierarchyManageVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (znDivBselCd[i] != null)
					model.setZnDivBselCd(znDivBselCd[i]);
				if (gmtHrs[i] != null)
					model.setGmtHrs(gmtHrs[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (portInlndCd[i] != null)
					model.setPortInlndCd(portInlndCd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locAmsPortCd[i] != null)
					model.setLocAmsPortCd(locAmsPortCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgBlPfxCd[i] != null)
					model.setBkgBlPfxCd(bkgBlPfxCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (locChrCd[i] != null)
					model.setLocChrCd(locChrCd[i]);
				if (repZnCd[i] != null)
					model.setRepZnCd(repZnCd[i]);
				if (regionCode[i] != null)
					model.setRegionCode(regionCode[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (subcontiCode[i] != null)
					model.setSubcontiCode(subcontiCode[i]);
				if (callPortFlg[i] != null)
					model.setCallPortFlg(callPortFlg[i]);
				if (rgnNm[i] != null)
					model.setRgnNm(rgnNm[i]);
				if (unLocIndCd[i] != null)
					model.setUnLocIndCd(unLocIndCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (customers[i] != null)
					model.setCustomers(customers[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (comercialZone[i] != null)
					model.setComercialZone(comercialZone[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (locGrdNo[i] != null)
					model.setLocGrdNo(locGrdNo[i]);
				if (eqRtnYdCd[i] != null)
					model.setEqRtnYdCd(eqRtnYdCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (fincCtrlOfcCd[i] != null)
					model.setFincCtrlOfcCd(fincCtrlOfcCd[i]);
				if (senEqOfcCd[i] != null)
					model.setSenEqOfcCd(senEqOfcCd[i]);
				if (contiCode[i] != null)
					model.setContiCode(contiCode[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (portInlndFlg[i] != null)
					model.setPortInlndFlg(portInlndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchGeoHierarchyManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchGeoHierarchyManageVO[]
	 */
	public SearchGeoHierarchyManageVO[] getSearchGeoHierarchyManageVOs(){
		SearchGeoHierarchyManageVO[] vos = (SearchGeoHierarchyManageVO[])models.toArray(new SearchGeoHierarchyManageVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znDivBselCd = this.znDivBselCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtHrs = this.gmtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInlndCd = this.portInlndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmsPortCd = this.locAmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlPfxCd = this.bkgBlPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChrCd = this.locChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repZnCd = this.repZnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionCode = this.regionCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subcontiCode = this.subcontiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callPortFlg = this.callPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnNm = this.rgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocIndCd = this.unLocIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customers = this.customers .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comercialZone = this.comercialZone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrdNo = this.locGrdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRtnYdCd = this.eqRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincCtrlOfcCd = this.fincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senEqOfcCd = this.senEqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCode = this.contiCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInlndFlg = this.portInlndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
