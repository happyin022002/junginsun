/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ADIDASEdiMainVO.java
*@FileTitle : ADIDASEdiMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class ADIDASEdiMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ADIDASEdiMainVO> models = new ArrayList<ADIDASEdiMainVO>();
	
	/* Column Info */
	private String ptName = null;
	/* Column Info */
	private String blOnBoardDate = null;
	/* Column Info */
	private String bkgRemark = null;
	/* Column Info */
	private String ptZipCd = null;
	/* Column Info */
	private String ptVatId = null;
	/* Column Info */
	private String blPolCd = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String rdTermPrecarriage = null;
	/* Column Info */
	private String invDueDate = null;
	/* Column Info */
	private String ptCountryCd = null;
	/* Column Info */
	private String ptAddress1 = null;
	/* Column Info */
	private String polDate = null;
	/* Column Info */
	private String ptAddress3 = null;
	/* Column Info */
	private String ptAddress2 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ptAddress4 = null;
	/* Column Info */
	private String extCustRef = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ptAddress = null;
	/* Column Info */
	private String blPodCd = null;
	/* Column Info */
	private String rdTermOncarriage = null;
	/* Column Info */
	private String invNumber = null;
	/* Column Info */
	private String bkgVvd = null;
	/* Column Info */
	private String fullVslNm = null;
	/* Column Info */
	private String blPolNm = null;
	/* Column Info */
	private String invRefNumber = null;
	/* Column Info */
	private String invCreationDate = null;
	/* Column Info */
	private String blDelNm = null;
	/* Column Info */
	private String invRefCreationDate = null;
	/* Column Info */
	private String ptCd = null;
	/* Column Info */
	private String ptStProvCd = null;
	/* Column Info */
	private String blPorCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ptIfrAddress1 = null;
	/* Column Info */
	private String ptCityName = null;
	/* Column Info */
	private String blPorNm = null;
	/* Column Info */
	private String fcPayat = null;
	/* Column Info */
	private String blDelCd = null;
	/* Column Info */
	private String blPodNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ADIDASEdiMainVO() {}

	public ADIDASEdiMainVO(String ibflag, String pagerows, String invNumber, String invRefNumber, String invRefCreationDate, String invCreationDate, String ptCd, String invDueDate, String extCustRef, String ptName, String ptAddress, String ptAddress1, String ptIfrAddress1, String ptAddress2, String ptAddress3, String ptAddress4, String ptVatId, String fullVslNm, String bkgVvd, String blPorCd, String blPorNm, String blPolCd, String blPolNm, String blPodCd, String blPodNm, String blDelCd, String blDelNm, String polDate, String podDate, String blNo, String bkgNo, String blOnBoardDate, String rdTermPrecarriage, String rdTermOncarriage, String ptCityName, String ptStProvCd, String ptZipCd, String ptCountryCd, String vslFlag, String bkgRemark, String fcPayat) {
		this.ptName = ptName;
		this.blOnBoardDate = blOnBoardDate;
		this.bkgRemark = bkgRemark;
		this.ptZipCd = ptZipCd;
		this.ptVatId = ptVatId;
		this.blPolCd = blPolCd;
		this.vslFlag = vslFlag;
		this.rdTermPrecarriage = rdTermPrecarriage;
		this.invDueDate = invDueDate;
		this.ptCountryCd = ptCountryCd;
		this.ptAddress1 = ptAddress1;
		this.polDate = polDate;
		this.ptAddress3 = ptAddress3;
		this.ptAddress2 = ptAddress2;
		this.blNo = blNo;
		this.ptAddress4 = ptAddress4;
		this.extCustRef = extCustRef;
		this.pagerows = pagerows;
		this.podDate = podDate;
		this.ibflag = ibflag;
		this.ptAddress = ptAddress;
		this.blPodCd = blPodCd;
		this.rdTermOncarriage = rdTermOncarriage;
		this.invNumber = invNumber;
		this.bkgVvd = bkgVvd;
		this.fullVslNm = fullVslNm;
		this.blPolNm = blPolNm;
		this.invRefNumber = invRefNumber;
		this.invCreationDate = invCreationDate;
		this.blDelNm = blDelNm;
		this.invRefCreationDate = invRefCreationDate;
		this.ptCd = ptCd;
		this.ptStProvCd = ptStProvCd;
		this.blPorCd = blPorCd;
		this.bkgNo = bkgNo;
		this.ptIfrAddress1 = ptIfrAddress1;
		this.ptCityName = ptCityName;
		this.blPorNm = blPorNm;
		this.fcPayat = fcPayat;
		this.blDelCd = blDelCd;
		this.blPodNm = blPodNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pt_name", getPtName());
		this.hashColumns.put("bl_on_board_date", getBlOnBoardDate());
		this.hashColumns.put("bkg_remark", getBkgRemark());
		this.hashColumns.put("pt_zip_cd", getPtZipCd());
		this.hashColumns.put("pt_vat_id", getPtVatId());
		this.hashColumns.put("bl_pol_cd", getBlPolCd());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("rd_term_precarriage", getRdTermPrecarriage());
		this.hashColumns.put("inv_due_date", getInvDueDate());
		this.hashColumns.put("pt_country_cd", getPtCountryCd());
		this.hashColumns.put("pt_address1", getPtAddress1());
		this.hashColumns.put("pol_date", getPolDate());
		this.hashColumns.put("pt_address3", getPtAddress3());
		this.hashColumns.put("pt_address2", getPtAddress2());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pt_address4", getPtAddress4());
		this.hashColumns.put("ext_cust_ref", getExtCustRef());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_date", getPodDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pt_address", getPtAddress());
		this.hashColumns.put("bl_pod_cd", getBlPodCd());
		this.hashColumns.put("rd_term_oncarriage", getRdTermOncarriage());
		this.hashColumns.put("inv_number", getInvNumber());
		this.hashColumns.put("bkg_vvd", getBkgVvd());
		this.hashColumns.put("full_vsl_nm", getFullVslNm());
		this.hashColumns.put("bl_pol_nm", getBlPolNm());
		this.hashColumns.put("inv_ref_number", getInvRefNumber());
		this.hashColumns.put("inv_creation_date", getInvCreationDate());
		this.hashColumns.put("bl_del_nm", getBlDelNm());
		this.hashColumns.put("inv_ref_creation_date", getInvRefCreationDate());
		this.hashColumns.put("pt_cd", getPtCd());
		this.hashColumns.put("pt_st_prov_cd", getPtStProvCd());
		this.hashColumns.put("bl_por_cd", getBlPorCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pt_ifr_address1", getPtIfrAddress1());
		this.hashColumns.put("pt_city_name", getPtCityName());
		this.hashColumns.put("bl_por_nm", getBlPorNm());
		this.hashColumns.put("fc_payat", getFcPayat());
		this.hashColumns.put("bl_del_cd", getBlDelCd());
		this.hashColumns.put("bl_pod_nm", getBlPodNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pt_name", "ptName");
		this.hashFields.put("bl_on_board_date", "blOnBoardDate");
		this.hashFields.put("bkg_remark", "bkgRemark");
		this.hashFields.put("pt_zip_cd", "ptZipCd");
		this.hashFields.put("pt_vat_id", "ptVatId");
		this.hashFields.put("bl_pol_cd", "blPolCd");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("rd_term_precarriage", "rdTermPrecarriage");
		this.hashFields.put("inv_due_date", "invDueDate");
		this.hashFields.put("pt_country_cd", "ptCountryCd");
		this.hashFields.put("pt_address1", "ptAddress1");
		this.hashFields.put("pol_date", "polDate");
		this.hashFields.put("pt_address3", "ptAddress3");
		this.hashFields.put("pt_address2", "ptAddress2");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pt_address4", "ptAddress4");
		this.hashFields.put("ext_cust_ref", "extCustRef");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_date", "podDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pt_address", "ptAddress");
		this.hashFields.put("bl_pod_cd", "blPodCd");
		this.hashFields.put("rd_term_oncarriage", "rdTermOncarriage");
		this.hashFields.put("inv_number", "invNumber");
		this.hashFields.put("bkg_vvd", "bkgVvd");
		this.hashFields.put("full_vsl_nm", "fullVslNm");
		this.hashFields.put("bl_pol_nm", "blPolNm");
		this.hashFields.put("inv_ref_number", "invRefNumber");
		this.hashFields.put("inv_creation_date", "invCreationDate");
		this.hashFields.put("bl_del_nm", "blDelNm");
		this.hashFields.put("inv_ref_creation_date", "invRefCreationDate");
		this.hashFields.put("pt_cd", "ptCd");
		this.hashFields.put("pt_st_prov_cd", "ptStProvCd");
		this.hashFields.put("bl_por_cd", "blPorCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pt_ifr_address1", "ptIfrAddress1");
		this.hashFields.put("pt_city_name", "ptCityName");
		this.hashFields.put("bl_por_nm", "blPorNm");
		this.hashFields.put("fc_payat", "fcPayat");
		this.hashFields.put("bl_del_cd", "blDelCd");
		this.hashFields.put("bl_pod_nm", "blPodNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ptName
	 */
	public String getPtName() {
		return this.ptName;
	}
	
	/**
	 * Column Info
	 * @return blOnBoardDate
	 */
	public String getBlOnBoardDate() {
		return this.blOnBoardDate;
	}
	
	/**
	 * Column Info
	 * @return bkgRemark
	 */
	public String getBkgRemark() {
		return this.bkgRemark;
	}
	
	/**
	 * Column Info
	 * @return ptZipCd
	 */
	public String getPtZipCd() {
		return this.ptZipCd;
	}
	
	/**
	 * Column Info
	 * @return ptVatId
	 */
	public String getPtVatId() {
		return this.ptVatId;
	}
	
	/**
	 * Column Info
	 * @return blPolCd
	 */
	public String getBlPolCd() {
		return this.blPolCd;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return rdTermPrecarriage
	 */
	public String getRdTermPrecarriage() {
		return this.rdTermPrecarriage;
	}
	
	/**
	 * Column Info
	 * @return invDueDate
	 */
	public String getInvDueDate() {
		return this.invDueDate;
	}
	
	/**
	 * Column Info
	 * @return ptCountryCd
	 */
	public String getPtCountryCd() {
		return this.ptCountryCd;
	}
	
	/**
	 * Column Info
	 * @return ptAddress1
	 */
	public String getPtAddress1() {
		return this.ptAddress1;
	}
	
	/**
	 * Column Info
	 * @return polDate
	 */
	public String getPolDate() {
		return this.polDate;
	}
	
	/**
	 * Column Info
	 * @return ptAddress3
	 */
	public String getPtAddress3() {
		return this.ptAddress3;
	}
	
	/**
	 * Column Info
	 * @return ptAddress2
	 */
	public String getPtAddress2() {
		return this.ptAddress2;
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
	 * @return ptAddress4
	 */
	public String getPtAddress4() {
		return this.ptAddress4;
	}
	
	/**
	 * Column Info
	 * @return extCustRef
	 */
	public String getExtCustRef() {
		return this.extCustRef;
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
	 * @return podDate
	 */
	public String getPodDate() {
		return this.podDate;
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
	 * @return ptAddress
	 */
	public String getPtAddress() {
		return this.ptAddress;
	}
	
	/**
	 * Column Info
	 * @return blPodCd
	 */
	public String getBlPodCd() {
		return this.blPodCd;
	}
	
	/**
	 * Column Info
	 * @return rdTermOncarriage
	 */
	public String getRdTermOncarriage() {
		return this.rdTermOncarriage;
	}
	
	/**
	 * Column Info
	 * @return invNumber
	 */
	public String getInvNumber() {
		return this.invNumber;
	}
	
	/**
	 * Column Info
	 * @return bkgVvd
	 */
	public String getBkgVvd() {
		return this.bkgVvd;
	}
	
	/**
	 * Column Info
	 * @return fullVslNm
	 */
	public String getFullVslNm() {
		return this.fullVslNm;
	}
	
	/**
	 * Column Info
	 * @return blPolNm
	 */
	public String getBlPolNm() {
		return this.blPolNm;
	}
	
	/**
	 * Column Info
	 * @return invRefNumber
	 */
	public String getInvRefNumber() {
		return this.invRefNumber;
	}
	
	/**
	 * Column Info
	 * @return invCreationDate
	 */
	public String getInvCreationDate() {
		return this.invCreationDate;
	}
	
	/**
	 * Column Info
	 * @return blDelNm
	 */
	public String getBlDelNm() {
		return this.blDelNm;
	}
	
	/**
	 * Column Info
	 * @return invRefCreationDate
	 */
	public String getInvRefCreationDate() {
		return this.invRefCreationDate;
	}
	
	/**
	 * Column Info
	 * @return ptCd
	 */
	public String getPtCd() {
		return this.ptCd;
	}
	
	/**
	 * Column Info
	 * @return ptStProvCd
	 */
	public String getPtStProvCd() {
		return this.ptStProvCd;
	}
	
	/**
	 * Column Info
	 * @return blPorCd
	 */
	public String getBlPorCd() {
		return this.blPorCd;
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
	 * @return ptIfrAddress1
	 */
	public String getPtIfrAddress1() {
		return this.ptIfrAddress1;
	}
	
	/**
	 * Column Info
	 * @return ptCityName
	 */
	public String getPtCityName() {
		return this.ptCityName;
	}
	
	/**
	 * Column Info
	 * @return blPorNm
	 */
	public String getBlPorNm() {
		return this.blPorNm;
	}
	
	/**
	 * Column Info
	 * @return fcPayat
	 */
	public String getFcPayat() {
		return this.fcPayat;
	}
	
	/**
	 * Column Info
	 * @return blDelCd
	 */
	public String getBlDelCd() {
		return this.blDelCd;
	}
	
	/**
	 * Column Info
	 * @return blPodNm
	 */
	public String getBlPodNm() {
		return this.blPodNm;
	}
	

	/**
	 * Column Info
	 * @param ptName
	 */
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	
	/**
	 * Column Info
	 * @param blOnBoardDate
	 */
	public void setBlOnBoardDate(String blOnBoardDate) {
		this.blOnBoardDate = blOnBoardDate;
	}
	
	/**
	 * Column Info
	 * @param bkgRemark
	 */
	public void setBkgRemark(String bkgRemark) {
		this.bkgRemark = bkgRemark;
	}
	
	/**
	 * Column Info
	 * @param ptZipCd
	 */
	public void setPtZipCd(String ptZipCd) {
		this.ptZipCd = ptZipCd;
	}
	
	/**
	 * Column Info
	 * @param ptVatId
	 */
	public void setPtVatId(String ptVatId) {
		this.ptVatId = ptVatId;
	}
	
	/**
	 * Column Info
	 * @param blPolCd
	 */
	public void setBlPolCd(String blPolCd) {
		this.blPolCd = blPolCd;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param rdTermPrecarriage
	 */
	public void setRdTermPrecarriage(String rdTermPrecarriage) {
		this.rdTermPrecarriage = rdTermPrecarriage;
	}
	
	/**
	 * Column Info
	 * @param invDueDate
	 */
	public void setInvDueDate(String invDueDate) {
		this.invDueDate = invDueDate;
	}
	
	/**
	 * Column Info
	 * @param ptCountryCd
	 */
	public void setPtCountryCd(String ptCountryCd) {
		this.ptCountryCd = ptCountryCd;
	}
	
	/**
	 * Column Info
	 * @param ptAddress1
	 */
	public void setPtAddress1(String ptAddress1) {
		this.ptAddress1 = ptAddress1;
	}
	
	/**
	 * Column Info
	 * @param polDate
	 */
	public void setPolDate(String polDate) {
		this.polDate = polDate;
	}
	
	/**
	 * Column Info
	 * @param ptAddress3
	 */
	public void setPtAddress3(String ptAddress3) {
		this.ptAddress3 = ptAddress3;
	}
	
	/**
	 * Column Info
	 * @param ptAddress2
	 */
	public void setPtAddress2(String ptAddress2) {
		this.ptAddress2 = ptAddress2;
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
	 * @param ptAddress4
	 */
	public void setPtAddress4(String ptAddress4) {
		this.ptAddress4 = ptAddress4;
	}
	
	/**
	 * Column Info
	 * @param extCustRef
	 */
	public void setExtCustRef(String extCustRef) {
		this.extCustRef = extCustRef;
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
	 * @param podDate
	 */
	public void setPodDate(String podDate) {
		this.podDate = podDate;
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
	 * @param ptAddress
	 */
	public void setPtAddress(String ptAddress) {
		this.ptAddress = ptAddress;
	}
	
	/**
	 * Column Info
	 * @param blPodCd
	 */
	public void setBlPodCd(String blPodCd) {
		this.blPodCd = blPodCd;
	}
	
	/**
	 * Column Info
	 * @param rdTermOncarriage
	 */
	public void setRdTermOncarriage(String rdTermOncarriage) {
		this.rdTermOncarriage = rdTermOncarriage;
	}
	
	/**
	 * Column Info
	 * @param invNumber
	 */
	public void setInvNumber(String invNumber) {
		this.invNumber = invNumber;
	}
	
	/**
	 * Column Info
	 * @param bkgVvd
	 */
	public void setBkgVvd(String bkgVvd) {
		this.bkgVvd = bkgVvd;
	}
	
	/**
	 * Column Info
	 * @param fullVslNm
	 */
	public void setFullVslNm(String fullVslNm) {
		this.fullVslNm = fullVslNm;
	}
	
	/**
	 * Column Info
	 * @param blPolNm
	 */
	public void setBlPolNm(String blPolNm) {
		this.blPolNm = blPolNm;
	}
	
	/**
	 * Column Info
	 * @param invRefNumber
	 */
	public void setInvRefNumber(String invRefNumber) {
		this.invRefNumber = invRefNumber;
	}
	
	/**
	 * Column Info
	 * @param invCreationDate
	 */
	public void setInvCreationDate(String invCreationDate) {
		this.invCreationDate = invCreationDate;
	}
	
	/**
	 * Column Info
	 * @param blDelNm
	 */
	public void setBlDelNm(String blDelNm) {
		this.blDelNm = blDelNm;
	}
	
	/**
	 * Column Info
	 * @param invRefCreationDate
	 */
	public void setInvRefCreationDate(String invRefCreationDate) {
		this.invRefCreationDate = invRefCreationDate;
	}
	
	/**
	 * Column Info
	 * @param ptCd
	 */
	public void setPtCd(String ptCd) {
		this.ptCd = ptCd;
	}
	
	/**
	 * Column Info
	 * @param ptStProvCd
	 */
	public void setPtStProvCd(String ptStProvCd) {
		this.ptStProvCd = ptStProvCd;
	}
	
	/**
	 * Column Info
	 * @param blPorCd
	 */
	public void setBlPorCd(String blPorCd) {
		this.blPorCd = blPorCd;
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
	 * @param ptIfrAddress1
	 */
	public void setPtIfrAddress1(String ptIfrAddress1) {
		this.ptIfrAddress1 = ptIfrAddress1;
	}
	
	/**
	 * Column Info
	 * @param ptCityName
	 */
	public void setPtCityName(String ptCityName) {
		this.ptCityName = ptCityName;
	}
	
	/**
	 * Column Info
	 * @param blPorNm
	 */
	public void setBlPorNm(String blPorNm) {
		this.blPorNm = blPorNm;
	}
	
	/**
	 * Column Info
	 * @param fcPayat
	 */
	public void setFcPayat(String fcPayat) {
		this.fcPayat = fcPayat;
	}
	
	/**
	 * Column Info
	 * @param blDelCd
	 */
	public void setBlDelCd(String blDelCd) {
		this.blDelCd = blDelCd;
	}
	
	/**
	 * Column Info
	 * @param blPodNm
	 */
	public void setBlPodNm(String blPodNm) {
		this.blPodNm = blPodNm;
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
		setPtName(JSPUtil.getParameter(request, prefix + "pt_name", ""));
		setBlOnBoardDate(JSPUtil.getParameter(request, prefix + "bl_on_board_date", ""));
		setBkgRemark(JSPUtil.getParameter(request, prefix + "bkg_remark", ""));
		setPtZipCd(JSPUtil.getParameter(request, prefix + "pt_zip_cd", ""));
		setPtVatId(JSPUtil.getParameter(request, prefix + "pt_vat_id", ""));
		setBlPolCd(JSPUtil.getParameter(request, prefix + "bl_pol_cd", ""));
		setVslFlag(JSPUtil.getParameter(request, prefix + "vsl_flag", ""));
		setRdTermPrecarriage(JSPUtil.getParameter(request, prefix + "rd_term_precarriage", ""));
		setInvDueDate(JSPUtil.getParameter(request, prefix + "inv_due_date", ""));
		setPtCountryCd(JSPUtil.getParameter(request, prefix + "pt_country_cd", ""));
		setPtAddress1(JSPUtil.getParameter(request, prefix + "pt_address1", ""));
		setPolDate(JSPUtil.getParameter(request, prefix + "pol_date", ""));
		setPtAddress3(JSPUtil.getParameter(request, prefix + "pt_address3", ""));
		setPtAddress2(JSPUtil.getParameter(request, prefix + "pt_address2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPtAddress4(JSPUtil.getParameter(request, prefix + "pt_address4", ""));
		setExtCustRef(JSPUtil.getParameter(request, prefix + "ext_cust_ref", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodDate(JSPUtil.getParameter(request, prefix + "pod_date", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPtAddress(JSPUtil.getParameter(request, prefix + "pt_address", ""));
		setBlPodCd(JSPUtil.getParameter(request, prefix + "bl_pod_cd", ""));
		setRdTermOncarriage(JSPUtil.getParameter(request, prefix + "rd_term_oncarriage", ""));
		setInvNumber(JSPUtil.getParameter(request, prefix + "inv_number", ""));
		setBkgVvd(JSPUtil.getParameter(request, prefix + "bkg_vvd", ""));
		setFullVslNm(JSPUtil.getParameter(request, prefix + "full_vsl_nm", ""));
		setBlPolNm(JSPUtil.getParameter(request, prefix + "bl_pol_nm", ""));
		setInvRefNumber(JSPUtil.getParameter(request, prefix + "inv_ref_number", ""));
		setInvCreationDate(JSPUtil.getParameter(request, prefix + "inv_creation_date", ""));
		setBlDelNm(JSPUtil.getParameter(request, prefix + "bl_del_nm", ""));
		setInvRefCreationDate(JSPUtil.getParameter(request, prefix + "inv_ref_creation_date", ""));
		setPtCd(JSPUtil.getParameter(request, prefix + "pt_cd", ""));
		setPtStProvCd(JSPUtil.getParameter(request, prefix + "pt_st_prov_cd", ""));
		setBlPorCd(JSPUtil.getParameter(request, prefix + "bl_por_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPtIfrAddress1(JSPUtil.getParameter(request, prefix + "pt_ifr_address1", ""));
		setPtCityName(JSPUtil.getParameter(request, prefix + "pt_city_name", ""));
		setBlPorNm(JSPUtil.getParameter(request, prefix + "bl_por_nm", ""));
		setFcPayat(JSPUtil.getParameter(request, prefix + "fc_payat", ""));
		setBlDelCd(JSPUtil.getParameter(request, prefix + "bl_del_cd", ""));
		setBlPodNm(JSPUtil.getParameter(request, prefix + "bl_pod_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ADIDASEdiMainVO[]
	 */
	public ADIDASEdiMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ADIDASEdiMainVO[]
	 */
	public ADIDASEdiMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ADIDASEdiMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ptName = (JSPUtil.getParameter(request, prefix	+ "pt_name", length));
			String[] blOnBoardDate = (JSPUtil.getParameter(request, prefix	+ "bl_on_board_date", length));
			String[] bkgRemark = (JSPUtil.getParameter(request, prefix	+ "bkg_remark", length));
			String[] ptZipCd = (JSPUtil.getParameter(request, prefix	+ "pt_zip_cd", length));
			String[] ptVatId = (JSPUtil.getParameter(request, prefix	+ "pt_vat_id", length));
			String[] blPolCd = (JSPUtil.getParameter(request, prefix	+ "bl_pol_cd", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] rdTermPrecarriage = (JSPUtil.getParameter(request, prefix	+ "rd_term_precarriage", length));
			String[] invDueDate = (JSPUtil.getParameter(request, prefix	+ "inv_due_date", length));
			String[] ptCountryCd = (JSPUtil.getParameter(request, prefix	+ "pt_country_cd", length));
			String[] ptAddress1 = (JSPUtil.getParameter(request, prefix	+ "pt_address1", length));
			String[] polDate = (JSPUtil.getParameter(request, prefix	+ "pol_date", length));
			String[] ptAddress3 = (JSPUtil.getParameter(request, prefix	+ "pt_address3", length));
			String[] ptAddress2 = (JSPUtil.getParameter(request, prefix	+ "pt_address2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ptAddress4 = (JSPUtil.getParameter(request, prefix	+ "pt_address4", length));
			String[] extCustRef = (JSPUtil.getParameter(request, prefix	+ "ext_cust_ref", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podDate = (JSPUtil.getParameter(request, prefix	+ "pod_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ptAddress = (JSPUtil.getParameter(request, prefix	+ "pt_address", length));
			String[] blPodCd = (JSPUtil.getParameter(request, prefix	+ "bl_pod_cd", length));
			String[] rdTermOncarriage = (JSPUtil.getParameter(request, prefix	+ "rd_term_oncarriage", length));
			String[] invNumber = (JSPUtil.getParameter(request, prefix	+ "inv_number", length));
			String[] bkgVvd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd", length));
			String[] fullVslNm = (JSPUtil.getParameter(request, prefix	+ "full_vsl_nm", length));
			String[] blPolNm = (JSPUtil.getParameter(request, prefix	+ "bl_pol_nm", length));
			String[] invRefNumber = (JSPUtil.getParameter(request, prefix	+ "inv_ref_number", length));
			String[] invCreationDate = (JSPUtil.getParameter(request, prefix	+ "inv_creation_date", length));
			String[] blDelNm = (JSPUtil.getParameter(request, prefix	+ "bl_del_nm", length));
			String[] invRefCreationDate = (JSPUtil.getParameter(request, prefix	+ "inv_ref_creation_date", length));
			String[] ptCd = (JSPUtil.getParameter(request, prefix	+ "pt_cd", length));
			String[] ptStProvCd = (JSPUtil.getParameter(request, prefix	+ "pt_st_prov_cd", length));
			String[] blPorCd = (JSPUtil.getParameter(request, prefix	+ "bl_por_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ptIfrAddress1 = (JSPUtil.getParameter(request, prefix	+ "pt_ifr_address1", length));
			String[] ptCityName = (JSPUtil.getParameter(request, prefix	+ "pt_city_name", length));
			String[] blPorNm = (JSPUtil.getParameter(request, prefix	+ "bl_por_nm", length));
			String[] fcPayat = (JSPUtil.getParameter(request, prefix	+ "fc_payat", length));
			String[] blDelCd = (JSPUtil.getParameter(request, prefix	+ "bl_del_cd", length));
			String[] blPodNm = (JSPUtil.getParameter(request, prefix	+ "bl_pod_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new ADIDASEdiMainVO();
				if (ptName[i] != null)
					model.setPtName(ptName[i]);
				if (blOnBoardDate[i] != null)
					model.setBlOnBoardDate(blOnBoardDate[i]);
				if (bkgRemark[i] != null)
					model.setBkgRemark(bkgRemark[i]);
				if (ptZipCd[i] != null)
					model.setPtZipCd(ptZipCd[i]);
				if (ptVatId[i] != null)
					model.setPtVatId(ptVatId[i]);
				if (blPolCd[i] != null)
					model.setBlPolCd(blPolCd[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (rdTermPrecarriage[i] != null)
					model.setRdTermPrecarriage(rdTermPrecarriage[i]);
				if (invDueDate[i] != null)
					model.setInvDueDate(invDueDate[i]);
				if (ptCountryCd[i] != null)
					model.setPtCountryCd(ptCountryCd[i]);
				if (ptAddress1[i] != null)
					model.setPtAddress1(ptAddress1[i]);
				if (polDate[i] != null)
					model.setPolDate(polDate[i]);
				if (ptAddress3[i] != null)
					model.setPtAddress3(ptAddress3[i]);
				if (ptAddress2[i] != null)
					model.setPtAddress2(ptAddress2[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ptAddress4[i] != null)
					model.setPtAddress4(ptAddress4[i]);
				if (extCustRef[i] != null)
					model.setExtCustRef(extCustRef[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podDate[i] != null)
					model.setPodDate(podDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ptAddress[i] != null)
					model.setPtAddress(ptAddress[i]);
				if (blPodCd[i] != null)
					model.setBlPodCd(blPodCd[i]);
				if (rdTermOncarriage[i] != null)
					model.setRdTermOncarriage(rdTermOncarriage[i]);
				if (invNumber[i] != null)
					model.setInvNumber(invNumber[i]);
				if (bkgVvd[i] != null)
					model.setBkgVvd(bkgVvd[i]);
				if (fullVslNm[i] != null)
					model.setFullVslNm(fullVslNm[i]);
				if (blPolNm[i] != null)
					model.setBlPolNm(blPolNm[i]);
				if (invRefNumber[i] != null)
					model.setInvRefNumber(invRefNumber[i]);
				if (invCreationDate[i] != null)
					model.setInvCreationDate(invCreationDate[i]);
				if (blDelNm[i] != null)
					model.setBlDelNm(blDelNm[i]);
				if (invRefCreationDate[i] != null)
					model.setInvRefCreationDate(invRefCreationDate[i]);
				if (ptCd[i] != null)
					model.setPtCd(ptCd[i]);
				if (ptStProvCd[i] != null)
					model.setPtStProvCd(ptStProvCd[i]);
				if (blPorCd[i] != null)
					model.setBlPorCd(blPorCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ptIfrAddress1[i] != null)
					model.setPtIfrAddress1(ptIfrAddress1[i]);
				if (ptCityName[i] != null)
					model.setPtCityName(ptCityName[i]);
				if (blPorNm[i] != null)
					model.setBlPorNm(blPorNm[i]);
				if (fcPayat[i] != null)
					model.setFcPayat(fcPayat[i]);
				if (blDelCd[i] != null)
					model.setBlDelCd(blDelCd[i]);
				if (blPodNm[i] != null)
					model.setBlPodNm(blPodNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getADIDASEdiMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ADIDASEdiMainVO[]
	 */
	public ADIDASEdiMainVO[] getADIDASEdiMainVOs(){
		ADIDASEdiMainVO[] vos = (ADIDASEdiMainVO[])models.toArray(new ADIDASEdiMainVO[models.size()]);
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
		this.ptName = this.ptName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOnBoardDate = this.blOnBoardDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRemark = this.bkgRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptZipCd = this.ptZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptVatId = this.ptVatId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPolCd = this.blPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTermPrecarriage = this.rdTermPrecarriage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDate = this.invDueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCountryCd = this.ptCountryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress1 = this.ptAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDate = this.polDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress3 = this.ptAddress3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress2 = this.ptAddress2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress4 = this.ptAddress4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.extCustRef = this.extCustRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDate = this.podDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress = this.ptAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPodCd = this.blPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTermOncarriage = this.rdTermOncarriage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNumber = this.invNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvd = this.bkgVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullVslNm = this.fullVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPolNm = this.blPolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNumber = this.invRefNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCreationDate = this.invCreationDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDelNm = this.blDelNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefCreationDate = this.invRefCreationDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCd = this.ptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptStProvCd = this.ptStProvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPorCd = this.blPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptIfrAddress1 = this.ptIfrAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCityName = this.ptCityName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPorNm = this.blPorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcPayat = this.fcPayat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDelCd = this.blDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPodNm = this.blPodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
