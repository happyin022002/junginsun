/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PSACntrBaseInfoVO.java
*@FileTitle : PSACntrBaseInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class PSACntrBaseInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PSACntrBaseInfoVO> models = new ArrayList<PSACntrBaseInfoVO>();
	
	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String subIdType = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String subAddress2 = null;
	/* Column Info */
	private String bBkgIdType = null;
	/* Column Info */
	private String subAddress3 = null;
	/* Column Info */
	private String subAddress1 = null;
	/* Column Info */
	private String podBkgLoc = null;
	/* Column Info */
	private String bBkgId = null;
	/* Column Info */
	private String subMode = null;
	/* Column Info */
	private String subAuthorized = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String podBkgLocType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subContact = null;
	/* Column Info */
	private String subMeansType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subPhone = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String subNation = null;
	/* Column Info */
	private String dType = null;
	/* Column Info */
	private String subPartyType = null;
	/* Column Info */
	private String lBkgIdType = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String pPolCd = null;
	/* Column Info */
	private String bkgDateType = null;
	/* Column Info */
	private String subName = null;
	/* Column Info */
	private String iso = null;
	/* Column Info */
	private String subId = null;
	/* Column Info */
	private String subVvd = null;
	/* Column Info */
	private String bkgDate = null;
	/* Column Info */
	private String subRef = null;
	/* Column Info */
	private String subPartyId = null;
	/* Column Info */
	private String polBkgLocType = null;
	/* Column Info */
	private String subFax = null;
	/* Column Info */
	private String pBoundCd = null;
	/* Column Info */
	private String subLicense = null;
	/* Column Info */
	private String pPodCd = null;
	/* Column Info */
	private String subConVvd = null;
	/* Column Info */
	private String subSsr = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String subAddress5 = null;
	/* Column Info */
	private String polBkgLoc = null;
	/* Column Info */
	private String imex = null;
	/* Column Info */
	private String subAddress4 = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String lBkgId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PSACntrBaseInfoVO() {}

	public PSACntrBaseInfoVO(String ibflag, String pagerows, String cntrtsCd, String bkgCgoTpCd, String subIdType, String subAddress2, String subAddress3, String bBkgIdType, String subAddress1, String bBkgId, String podBkgLoc, String subMode, String subAuthorized, String blNo, String podBkgLocType, String subContact, String subMeansType, String subPhone, String vvdCd, String usrId, String subNation, String dType, String subPartyType, String lBkgIdType, String portCd, String pPolCd, String bkgDateType, String subName, String iso, String subId, String subVvd, String subConVvd, String subRef, String bkgDate, String subPartyId, String polBkgLocType, String pBoundCd, String subFax, String pPodCd, String subLicense, String subSsr, String cntrNo, String subAddress5, String subAddress4, String imex, String polBkgLoc, String msgSndNo, String lBkgId) {
		this.cntrtsCd = cntrtsCd;
		this.subIdType = subIdType;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.subAddress2 = subAddress2;
		this.bBkgIdType = bBkgIdType;
		this.subAddress3 = subAddress3;
		this.subAddress1 = subAddress1;
		this.podBkgLoc = podBkgLoc;
		this.bBkgId = bBkgId;
		this.subMode = subMode;
		this.subAuthorized = subAuthorized;
		this.blNo = blNo;
		this.podBkgLocType = podBkgLocType;
		this.pagerows = pagerows;
		this.subContact = subContact;
		this.subMeansType = subMeansType;
		this.ibflag = ibflag;
		this.subPhone = subPhone;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.subNation = subNation;
		this.dType = dType;
		this.subPartyType = subPartyType;
		this.lBkgIdType = lBkgIdType;
		this.portCd = portCd;
		this.pPolCd = pPolCd;
		this.bkgDateType = bkgDateType;
		this.subName = subName;
		this.iso = iso;
		this.subId = subId;
		this.subVvd = subVvd;
		this.bkgDate = bkgDate;
		this.subRef = subRef;
		this.subPartyId = subPartyId;
		this.polBkgLocType = polBkgLocType;
		this.subFax = subFax;
		this.pBoundCd = pBoundCd;
		this.subLicense = subLicense;
		this.pPodCd = pPodCd;
		this.subConVvd = subConVvd;
		this.subSsr = subSsr;
		this.cntrNo = cntrNo;
		this.subAddress5 = subAddress5;
		this.polBkgLoc = polBkgLoc;
		this.imex = imex;
		this.subAddress4 = subAddress4;
		this.msgSndNo = msgSndNo;
		this.lBkgId = lBkgId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("sub_id_type", getSubIdType());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("sub_address2", getSubAddress2());
		this.hashColumns.put("b_bkg_id_type", getBBkgIdType());
		this.hashColumns.put("sub_address3", getSubAddress3());
		this.hashColumns.put("sub_address1", getSubAddress1());
		this.hashColumns.put("pod_bkg_loc", getPodBkgLoc());
		this.hashColumns.put("b_bkg_id", getBBkgId());
		this.hashColumns.put("sub_mode", getSubMode());
		this.hashColumns.put("sub_authorized", getSubAuthorized());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pod_bkg_loc_type", getPodBkgLocType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_contact", getSubContact());
		this.hashColumns.put("sub_means_type", getSubMeansType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_phone", getSubPhone());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sub_nation", getSubNation());
		this.hashColumns.put("d_type", getDType());
		this.hashColumns.put("sub_party_type", getSubPartyType());
		this.hashColumns.put("l_bkg_id_type", getLBkgIdType());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		this.hashColumns.put("bkg_date_type", getBkgDateType());
		this.hashColumns.put("sub_name", getSubName());
		this.hashColumns.put("iso", getIso());
		this.hashColumns.put("sub_id", getSubId());
		this.hashColumns.put("sub_vvd", getSubVvd());
		this.hashColumns.put("bkg_date", getBkgDate());
		this.hashColumns.put("sub_ref", getSubRef());
		this.hashColumns.put("sub_party_id", getSubPartyId());
		this.hashColumns.put("pol_bkg_loc_type", getPolBkgLocType());
		this.hashColumns.put("sub_fax", getSubFax());
		this.hashColumns.put("p_bound_cd", getPBoundCd());
		this.hashColumns.put("sub_license", getSubLicense());
		this.hashColumns.put("p_pod_cd", getPPodCd());
		this.hashColumns.put("sub_con_vvd", getSubConVvd());
		this.hashColumns.put("sub_ssr", getSubSsr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sub_address5", getSubAddress5());
		this.hashColumns.put("pol_bkg_loc", getPolBkgLoc());
		this.hashColumns.put("imex", getImex());
		this.hashColumns.put("sub_address4", getSubAddress4());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("l_bkg_id", getLBkgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("sub_id_type", "subIdType");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("sub_address2", "subAddress2");
		this.hashFields.put("b_bkg_id_type", "bBkgIdType");
		this.hashFields.put("sub_address3", "subAddress3");
		this.hashFields.put("sub_address1", "subAddress1");
		this.hashFields.put("pod_bkg_loc", "podBkgLoc");
		this.hashFields.put("b_bkg_id", "bBkgId");
		this.hashFields.put("sub_mode", "subMode");
		this.hashFields.put("sub_authorized", "subAuthorized");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pod_bkg_loc_type", "podBkgLocType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_contact", "subContact");
		this.hashFields.put("sub_means_type", "subMeansType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_phone", "subPhone");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sub_nation", "subNation");
		this.hashFields.put("d_type", "dType");
		this.hashFields.put("sub_party_type", "subPartyType");
		this.hashFields.put("l_bkg_id_type", "lBkgIdType");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("p_pol_cd", "pPolCd");
		this.hashFields.put("bkg_date_type", "bkgDateType");
		this.hashFields.put("sub_name", "subName");
		this.hashFields.put("iso", "iso");
		this.hashFields.put("sub_id", "subId");
		this.hashFields.put("sub_vvd", "subVvd");
		this.hashFields.put("bkg_date", "bkgDate");
		this.hashFields.put("sub_ref", "subRef");
		this.hashFields.put("sub_party_id", "subPartyId");
		this.hashFields.put("pol_bkg_loc_type", "polBkgLocType");
		this.hashFields.put("sub_fax", "subFax");
		this.hashFields.put("p_bound_cd", "pBoundCd");
		this.hashFields.put("sub_license", "subLicense");
		this.hashFields.put("p_pod_cd", "pPodCd");
		this.hashFields.put("sub_con_vvd", "subConVvd");
		this.hashFields.put("sub_ssr", "subSsr");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sub_address5", "subAddress5");
		this.hashFields.put("pol_bkg_loc", "polBkgLoc");
		this.hashFields.put("imex", "imex");
		this.hashFields.put("sub_address4", "subAddress4");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("l_bkg_id", "lBkgId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrtsCd
	 */
	public String getCntrtsCd() {
		return this.cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @return subIdType
	 */
	public String getSubIdType() {
		return this.subIdType;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return subAddress2
	 */
	public String getSubAddress2() {
		return this.subAddress2;
	}
	
	/**
	 * Column Info
	 * @return bBkgIdType
	 */
	public String getBBkgIdType() {
		return this.bBkgIdType;
	}
	
	/**
	 * Column Info
	 * @return subAddress3
	 */
	public String getSubAddress3() {
		return this.subAddress3;
	}
	
	/**
	 * Column Info
	 * @return subAddress1
	 */
	public String getSubAddress1() {
		return this.subAddress1;
	}
	
	/**
	 * Column Info
	 * @return podBkgLoc
	 */
	public String getPodBkgLoc() {
		return this.podBkgLoc;
	}
	
	/**
	 * Column Info
	 * @return bBkgId
	 */
	public String getBBkgId() {
		return this.bBkgId;
	}
	
	/**
	 * Column Info
	 * @return subMode
	 */
	public String getSubMode() {
		return this.subMode;
	}
	
	/**
	 * Column Info
	 * @return subAuthorized
	 */
	public String getSubAuthorized() {
		return this.subAuthorized;
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
	 * @return podBkgLocType
	 */
	public String getPodBkgLocType() {
		return this.podBkgLocType;
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
	 * @return subContact
	 */
	public String getSubContact() {
		return this.subContact;
	}
	
	/**
	 * Column Info
	 * @return subMeansType
	 */
	public String getSubMeansType() {
		return this.subMeansType;
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
	 * @return subPhone
	 */
	public String getSubPhone() {
		return this.subPhone;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return subNation
	 */
	public String getSubNation() {
		return this.subNation;
	}
	
	/**
	 * Column Info
	 * @return dType
	 */
	public String getDType() {
		return this.dType;
	}
	
	/**
	 * Column Info
	 * @return subPartyType
	 */
	public String getSubPartyType() {
		return this.subPartyType;
	}
	
	/**
	 * Column Info
	 * @return lBkgIdType
	 */
	public String getLBkgIdType() {
		return this.lBkgIdType;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDateType
	 */
	public String getBkgDateType() {
		return this.bkgDateType;
	}
	
	/**
	 * Column Info
	 * @return subName
	 */
	public String getSubName() {
		return this.subName;
	}
	
	/**
	 * Column Info
	 * @return iso
	 */
	public String getIso() {
		return this.iso;
	}
	
	/**
	 * Column Info
	 * @return subId
	 */
	public String getSubId() {
		return this.subId;
	}
	
	/**
	 * Column Info
	 * @return subVvd
	 */
	public String getSubVvd() {
		return this.subVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgDate
	 */
	public String getBkgDate() {
		return this.bkgDate;
	}
	
	/**
	 * Column Info
	 * @return subRef
	 */
	public String getSubRef() {
		return this.subRef;
	}
	
	/**
	 * Column Info
	 * @return subPartyId
	 */
	public String getSubPartyId() {
		return this.subPartyId;
	}
	
	/**
	 * Column Info
	 * @return polBkgLocType
	 */
	public String getPolBkgLocType() {
		return this.polBkgLocType;
	}
	
	/**
	 * Column Info
	 * @return subFax
	 */
	public String getSubFax() {
		return this.subFax;
	}
	
	/**
	 * Column Info
	 * @return pBoundCd
	 */
	public String getPBoundCd() {
		return this.pBoundCd;
	}
	
	/**
	 * Column Info
	 * @return subLicense
	 */
	public String getSubLicense() {
		return this.subLicense;
	}
	
	/**
	 * Column Info
	 * @return pPodCd
	 */
	public String getPPodCd() {
		return this.pPodCd;
	}
	
	/**
	 * Column Info
	 * @return subConVvd
	 */
	public String getSubConVvd() {
		return this.subConVvd;
	}
	
	/**
	 * Column Info
	 * @return subSsr
	 */
	public String getSubSsr() {
		return this.subSsr;
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
	 * @return subAddress5
	 */
	public String getSubAddress5() {
		return this.subAddress5;
	}
	
	/**
	 * Column Info
	 * @return polBkgLoc
	 */
	public String getPolBkgLoc() {
		return this.polBkgLoc;
	}
	
	/**
	 * Column Info
	 * @return imex
	 */
	public String getImex() {
		return this.imex;
	}
	
	/**
	 * Column Info
	 * @return subAddress4
	 */
	public String getSubAddress4() {
		return this.subAddress4;
	}
	
	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}
	
	/**
	 * Column Info
	 * @return lBkgId
	 */
	public String getLBkgId() {
		return this.lBkgId;
	}
	

	/**
	 * Column Info
	 * @param cntrtsCd
	 */
	public void setCntrtsCd(String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @param subIdType
	 */
	public void setSubIdType(String subIdType) {
		this.subIdType = subIdType;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param subAddress2
	 */
	public void setSubAddress2(String subAddress2) {
		this.subAddress2 = subAddress2;
	}
	
	/**
	 * Column Info
	 * @param bBkgIdType
	 */
	public void setBBkgIdType(String bBkgIdType) {
		this.bBkgIdType = bBkgIdType;
	}
	
	/**
	 * Column Info
	 * @param subAddress3
	 */
	public void setSubAddress3(String subAddress3) {
		this.subAddress3 = subAddress3;
	}
	
	/**
	 * Column Info
	 * @param subAddress1
	 */
	public void setSubAddress1(String subAddress1) {
		this.subAddress1 = subAddress1;
	}
	
	/**
	 * Column Info
	 * @param podBkgLoc
	 */
	public void setPodBkgLoc(String podBkgLoc) {
		this.podBkgLoc = podBkgLoc;
	}
	
	/**
	 * Column Info
	 * @param bBkgId
	 */
	public void setBBkgId(String bBkgId) {
		this.bBkgId = bBkgId;
	}
	
	/**
	 * Column Info
	 * @param subMode
	 */
	public void setSubMode(String subMode) {
		this.subMode = subMode;
	}
	
	/**
	 * Column Info
	 * @param subAuthorized
	 */
	public void setSubAuthorized(String subAuthorized) {
		this.subAuthorized = subAuthorized;
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
	 * @param podBkgLocType
	 */
	public void setPodBkgLocType(String podBkgLocType) {
		this.podBkgLocType = podBkgLocType;
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
	 * @param subContact
	 */
	public void setSubContact(String subContact) {
		this.subContact = subContact;
	}
	
	/**
	 * Column Info
	 * @param subMeansType
	 */
	public void setSubMeansType(String subMeansType) {
		this.subMeansType = subMeansType;
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
	 * @param subPhone
	 */
	public void setSubPhone(String subPhone) {
		this.subPhone = subPhone;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param subNation
	 */
	public void setSubNation(String subNation) {
		this.subNation = subNation;
	}
	
	/**
	 * Column Info
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType;
	}
	
	/**
	 * Column Info
	 * @param subPartyType
	 */
	public void setSubPartyType(String subPartyType) {
		this.subPartyType = subPartyType;
	}
	
	/**
	 * Column Info
	 * @param lBkgIdType
	 */
	public void setLBkgIdType(String lBkgIdType) {
		this.lBkgIdType = lBkgIdType;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDateType
	 */
	public void setBkgDateType(String bkgDateType) {
		this.bkgDateType = bkgDateType;
	}
	
	/**
	 * Column Info
	 * @param subName
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	/**
	 * Column Info
	 * @param iso
	 */
	public void setIso(String iso) {
		this.iso = iso;
	}
	
	/**
	 * Column Info
	 * @param subId
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	
	/**
	 * Column Info
	 * @param subVvd
	 */
	public void setSubVvd(String subVvd) {
		this.subVvd = subVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgDate
	 */
	public void setBkgDate(String bkgDate) {
		this.bkgDate = bkgDate;
	}
	
	/**
	 * Column Info
	 * @param subRef
	 */
	public void setSubRef(String subRef) {
		this.subRef = subRef;
	}
	
	/**
	 * Column Info
	 * @param subPartyId
	 */
	public void setSubPartyId(String subPartyId) {
		this.subPartyId = subPartyId;
	}
	
	/**
	 * Column Info
	 * @param polBkgLocType
	 */
	public void setPolBkgLocType(String polBkgLocType) {
		this.polBkgLocType = polBkgLocType;
	}
	
	/**
	 * Column Info
	 * @param subFax
	 */
	public void setSubFax(String subFax) {
		this.subFax = subFax;
	}
	
	/**
	 * Column Info
	 * @param pBoundCd
	 */
	public void setPBoundCd(String pBoundCd) {
		this.pBoundCd = pBoundCd;
	}
	
	/**
	 * Column Info
	 * @param subLicense
	 */
	public void setSubLicense(String subLicense) {
		this.subLicense = subLicense;
	}
	
	/**
	 * Column Info
	 * @param pPodCd
	 */
	public void setPPodCd(String pPodCd) {
		this.pPodCd = pPodCd;
	}
	
	/**
	 * Column Info
	 * @param subConVvd
	 */
	public void setSubConVvd(String subConVvd) {
		this.subConVvd = subConVvd;
	}
	
	/**
	 * Column Info
	 * @param subSsr
	 */
	public void setSubSsr(String subSsr) {
		this.subSsr = subSsr;
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
	 * @param subAddress5
	 */
	public void setSubAddress5(String subAddress5) {
		this.subAddress5 = subAddress5;
	}
	
	/**
	 * Column Info
	 * @param polBkgLoc
	 */
	public void setPolBkgLoc(String polBkgLoc) {
		this.polBkgLoc = polBkgLoc;
	}
	
	/**
	 * Column Info
	 * @param imex
	 */
	public void setImex(String imex) {
		this.imex = imex;
	}
	
	/**
	 * Column Info
	 * @param subAddress4
	 */
	public void setSubAddress4(String subAddress4) {
		this.subAddress4 = subAddress4;
	}
	
	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * Column Info
	 * @param lBkgId
	 */
	public void setLBkgId(String lBkgId) {
		this.lBkgId = lBkgId;
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
		setCntrtsCd(JSPUtil.getParameter(request, prefix + "cntrts_cd", ""));
		setSubIdType(JSPUtil.getParameter(request, prefix + "sub_id_type", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setSubAddress2(JSPUtil.getParameter(request, prefix + "sub_address2", ""));
		setBBkgIdType(JSPUtil.getParameter(request, prefix + "b_bkg_id_type", ""));
		setSubAddress3(JSPUtil.getParameter(request, prefix + "sub_address3", ""));
		setSubAddress1(JSPUtil.getParameter(request, prefix + "sub_address1", ""));
		setPodBkgLoc(JSPUtil.getParameter(request, prefix + "pod_bkg_loc", ""));
		setBBkgId(JSPUtil.getParameter(request, prefix + "b_bkg_id", ""));
		setSubMode(JSPUtil.getParameter(request, prefix + "sub_mode", ""));
		setSubAuthorized(JSPUtil.getParameter(request, prefix + "sub_authorized", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPodBkgLocType(JSPUtil.getParameter(request, prefix + "pod_bkg_loc_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSubContact(JSPUtil.getParameter(request, prefix + "sub_contact", ""));
		setSubMeansType(JSPUtil.getParameter(request, prefix + "sub_means_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubPhone(JSPUtil.getParameter(request, prefix + "sub_phone", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSubNation(JSPUtil.getParameter(request, prefix + "sub_nation", ""));
		setDType(JSPUtil.getParameter(request, prefix + "d_type", ""));
		setSubPartyType(JSPUtil.getParameter(request, prefix + "sub_party_type", ""));
		setLBkgIdType(JSPUtil.getParameter(request, prefix + "l_bkg_id_type", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
		setBkgDateType(JSPUtil.getParameter(request, prefix + "bkg_date_type", ""));
		setSubName(JSPUtil.getParameter(request, prefix + "sub_name", ""));
		setIso(JSPUtil.getParameter(request, prefix + "iso", ""));
		setSubId(JSPUtil.getParameter(request, prefix + "sub_id", ""));
		setSubVvd(JSPUtil.getParameter(request, prefix + "sub_vvd", ""));
		setBkgDate(JSPUtil.getParameter(request, prefix + "bkg_date", ""));
		setSubRef(JSPUtil.getParameter(request, prefix + "sub_ref", ""));
		setSubPartyId(JSPUtil.getParameter(request, prefix + "sub_party_id", ""));
		setPolBkgLocType(JSPUtil.getParameter(request, prefix + "pol_bkg_loc_type", ""));
		setSubFax(JSPUtil.getParameter(request, prefix + "sub_fax", ""));
		setPBoundCd(JSPUtil.getParameter(request, prefix + "p_bound_cd", ""));
		setSubLicense(JSPUtil.getParameter(request, prefix + "sub_license", ""));
		setPPodCd(JSPUtil.getParameter(request, prefix + "p_pod_cd", ""));
		setSubConVvd(JSPUtil.getParameter(request, prefix + "sub_con_vvd", ""));
		setSubSsr(JSPUtil.getParameter(request, prefix + "sub_ssr", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSubAddress5(JSPUtil.getParameter(request, prefix + "sub_address5", ""));
		setPolBkgLoc(JSPUtil.getParameter(request, prefix + "pol_bkg_loc", ""));
		setImex(JSPUtil.getParameter(request, prefix + "imex", ""));
		setSubAddress4(JSPUtil.getParameter(request, prefix + "sub_address4", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setLBkgId(JSPUtil.getParameter(request, prefix + "l_bkg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PSACntrBaseInfoVO[]
	 */
	public PSACntrBaseInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PSACntrBaseInfoVO[]
	 */
	public PSACntrBaseInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PSACntrBaseInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] subIdType = (JSPUtil.getParameter(request, prefix	+ "sub_id_type", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] subAddress2 = (JSPUtil.getParameter(request, prefix	+ "sub_address2", length));
			String[] bBkgIdType = (JSPUtil.getParameter(request, prefix	+ "b_bkg_id_type", length));
			String[] subAddress3 = (JSPUtil.getParameter(request, prefix	+ "sub_address3", length));
			String[] subAddress1 = (JSPUtil.getParameter(request, prefix	+ "sub_address1", length));
			String[] podBkgLoc = (JSPUtil.getParameter(request, prefix	+ "pod_bkg_loc", length));
			String[] bBkgId = (JSPUtil.getParameter(request, prefix	+ "b_bkg_id", length));
			String[] subMode = (JSPUtil.getParameter(request, prefix	+ "sub_mode", length));
			String[] subAuthorized = (JSPUtil.getParameter(request, prefix	+ "sub_authorized", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] podBkgLocType = (JSPUtil.getParameter(request, prefix	+ "pod_bkg_loc_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subContact = (JSPUtil.getParameter(request, prefix	+ "sub_contact", length));
			String[] subMeansType = (JSPUtil.getParameter(request, prefix	+ "sub_means_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subPhone = (JSPUtil.getParameter(request, prefix	+ "sub_phone", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] subNation = (JSPUtil.getParameter(request, prefix	+ "sub_nation", length));
			String[] dType = (JSPUtil.getParameter(request, prefix	+ "d_type", length));
			String[] subPartyType = (JSPUtil.getParameter(request, prefix	+ "sub_party_type", length));
			String[] lBkgIdType = (JSPUtil.getParameter(request, prefix	+ "l_bkg_id_type", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			String[] bkgDateType = (JSPUtil.getParameter(request, prefix	+ "bkg_date_type", length));
			String[] subName = (JSPUtil.getParameter(request, prefix	+ "sub_name", length));
			String[] iso = (JSPUtil.getParameter(request, prefix	+ "iso", length));
			String[] subId = (JSPUtil.getParameter(request, prefix	+ "sub_id", length));
			String[] subVvd = (JSPUtil.getParameter(request, prefix	+ "sub_vvd", length));
			String[] bkgDate = (JSPUtil.getParameter(request, prefix	+ "bkg_date", length));
			String[] subRef = (JSPUtil.getParameter(request, prefix	+ "sub_ref", length));
			String[] subPartyId = (JSPUtil.getParameter(request, prefix	+ "sub_party_id", length));
			String[] polBkgLocType = (JSPUtil.getParameter(request, prefix	+ "pol_bkg_loc_type", length));
			String[] subFax = (JSPUtil.getParameter(request, prefix	+ "sub_fax", length));
			String[] pBoundCd = (JSPUtil.getParameter(request, prefix	+ "p_bound_cd", length));
			String[] subLicense = (JSPUtil.getParameter(request, prefix	+ "sub_license", length));
			String[] pPodCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_cd", length));
			String[] subConVvd = (JSPUtil.getParameter(request, prefix	+ "sub_con_vvd", length));
			String[] subSsr = (JSPUtil.getParameter(request, prefix	+ "sub_ssr", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] subAddress5 = (JSPUtil.getParameter(request, prefix	+ "sub_address5", length));
			String[] polBkgLoc = (JSPUtil.getParameter(request, prefix	+ "pol_bkg_loc", length));
			String[] imex = (JSPUtil.getParameter(request, prefix	+ "imex", length));
			String[] subAddress4 = (JSPUtil.getParameter(request, prefix	+ "sub_address4", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] lBkgId = (JSPUtil.getParameter(request, prefix	+ "l_bkg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PSACntrBaseInfoVO();
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (subIdType[i] != null)
					model.setSubIdType(subIdType[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (subAddress2[i] != null)
					model.setSubAddress2(subAddress2[i]);
				if (bBkgIdType[i] != null)
					model.setBBkgIdType(bBkgIdType[i]);
				if (subAddress3[i] != null)
					model.setSubAddress3(subAddress3[i]);
				if (subAddress1[i] != null)
					model.setSubAddress1(subAddress1[i]);
				if (podBkgLoc[i] != null)
					model.setPodBkgLoc(podBkgLoc[i]);
				if (bBkgId[i] != null)
					model.setBBkgId(bBkgId[i]);
				if (subMode[i] != null)
					model.setSubMode(subMode[i]);
				if (subAuthorized[i] != null)
					model.setSubAuthorized(subAuthorized[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (podBkgLocType[i] != null)
					model.setPodBkgLocType(podBkgLocType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subContact[i] != null)
					model.setSubContact(subContact[i]);
				if (subMeansType[i] != null)
					model.setSubMeansType(subMeansType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subPhone[i] != null)
					model.setSubPhone(subPhone[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (subNation[i] != null)
					model.setSubNation(subNation[i]);
				if (dType[i] != null)
					model.setDType(dType[i]);
				if (subPartyType[i] != null)
					model.setSubPartyType(subPartyType[i]);
				if (lBkgIdType[i] != null)
					model.setLBkgIdType(lBkgIdType[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				if (bkgDateType[i] != null)
					model.setBkgDateType(bkgDateType[i]);
				if (subName[i] != null)
					model.setSubName(subName[i]);
				if (iso[i] != null)
					model.setIso(iso[i]);
				if (subId[i] != null)
					model.setSubId(subId[i]);
				if (subVvd[i] != null)
					model.setSubVvd(subVvd[i]);
				if (bkgDate[i] != null)
					model.setBkgDate(bkgDate[i]);
				if (subRef[i] != null)
					model.setSubRef(subRef[i]);
				if (subPartyId[i] != null)
					model.setSubPartyId(subPartyId[i]);
				if (polBkgLocType[i] != null)
					model.setPolBkgLocType(polBkgLocType[i]);
				if (subFax[i] != null)
					model.setSubFax(subFax[i]);
				if (pBoundCd[i] != null)
					model.setPBoundCd(pBoundCd[i]);
				if (subLicense[i] != null)
					model.setSubLicense(subLicense[i]);
				if (pPodCd[i] != null)
					model.setPPodCd(pPodCd[i]);
				if (subConVvd[i] != null)
					model.setSubConVvd(subConVvd[i]);
				if (subSsr[i] != null)
					model.setSubSsr(subSsr[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (subAddress5[i] != null)
					model.setSubAddress5(subAddress5[i]);
				if (polBkgLoc[i] != null)
					model.setPolBkgLoc(polBkgLoc[i]);
				if (imex[i] != null)
					model.setImex(imex[i]);
				if (subAddress4[i] != null)
					model.setSubAddress4(subAddress4[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (lBkgId[i] != null)
					model.setLBkgId(lBkgId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPSACntrBaseInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PSACntrBaseInfoVO[]
	 */
	public PSACntrBaseInfoVO[] getPSACntrBaseInfoVOs(){
		PSACntrBaseInfoVO[] vos = (PSACntrBaseInfoVO[])models.toArray(new PSACntrBaseInfoVO[models.size()]);
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
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subIdType = this.subIdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAddress2 = this.subAddress2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBkgIdType = this.bBkgIdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAddress3 = this.subAddress3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAddress1 = this.subAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBkgLoc = this.podBkgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBkgId = this.bBkgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subMode = this.subMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAuthorized = this.subAuthorized .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBkgLocType = this.podBkgLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subContact = this.subContact .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subMeansType = this.subMeansType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPhone = this.subPhone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNation = this.subNation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dType = this.dType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPartyType = this.subPartyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lBkgIdType = this.lBkgIdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateType = this.bkgDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subName = this.subName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iso = this.iso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subId = this.subId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subVvd = this.subVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDate = this.bkgDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subRef = this.subRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPartyId = this.subPartyId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polBkgLocType = this.polBkgLocType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subFax = this.subFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBoundCd = this.pBoundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLicense = this.subLicense .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodCd = this.pPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subConVvd = this.subConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSsr = this.subSsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAddress5 = this.subAddress5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polBkgLoc = this.polBkgLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imex = this.imex .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAddress4 = this.subAddress4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lBkgId = this.lBkgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
