/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BrManifestListDetailVO.java
*@FileTitle : BrManifestListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
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

public class BrManifestListDetailVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrManifestListDetailVO> models = new ArrayList<BrManifestListDetailVO>();
	
	/* Column Info */
	private String ncmMultiNo = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String measure = null;
	/* Column Info */
	private String ncmNo = null;
	/* Column Info */
	private String cap = null;
	/* Column Info */
	private String shprTaxNo = null;
	/* Column Info */
	private String ncmMultiPop = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String obCneeTaxNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String obShprTaxNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String blGroup = null;
	/* Column Info */
	private String notifyCustNm = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ncmMultiFlg = null;
	/* Column Info */
	private String obNtfyTaxNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String shipperCustNm = null;
	/* Column Info */
	private String cneeTaxNo = null;
	/* Column Info */
	private String consigneeCustNm = null;
	/* Column Info */
	private String brzDeclNo = null;
	/* Column Info */
	private String oft = null;
	/* Column Info */
	private String bookingCmdtNm = null;
	/* Column Info */
	private String obBrzDeclNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ifFlag = null;
	/* Column Info */
	private String brMid = null;
	/* Column Info */
	private String keyBlNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String brDuv = null;
	/* Column Info */
	private String searchBkgCgoTpCd = null;
	/* Column Info */
	private String ntfyTaxNo = null;
	/* Column Info */
	private String mergeBlNo = null;
	/* Column Info */
	private String naStfFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrManifestListDetailVO() {}

	public BrManifestListDetailVO(String ibflag, String pagerows, String blNo, String mergeBlNo, String blGroup, String bkgNo, String searchBkgCgoTpCd, String custToOrdFlg, String shipperCustNm, String obShprTaxNo, String shprTaxNo, String consigneeCustNm, String obCneeTaxNo, String cneeTaxNo, String notifyCustNm, String obNtfyTaxNo, String ntfyTaxNo, String brzDeclNo, String obBrzDeclNo, String keyBlNo, String ifFlag, String cntrNo, String pckQty, String pckTpCd, String weight, String wgtUtCd, String measure, String measUtCd, String bookingCmdtNm, String cntrMfSeq, String ncmNo, String ncmMultiPop, String ncmMultiFlg, String ncmMultiNo, String cstmsDesc, String vvdCd, String polCd, String podCd, String oft, String cap, String delCd, String brDuv, String brMid, String naStfFlg) {
		this.ncmMultiNo = ncmMultiNo;
		this.weight = weight;
		this.measure = measure;
		this.ncmNo = ncmNo;
		this.cap = cap;
		this.shprTaxNo = shprTaxNo;
		this.ncmMultiPop = ncmMultiPop;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.obCneeTaxNo = obCneeTaxNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.obShprTaxNo = obShprTaxNo;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cstmsDesc = cstmsDesc;
		this.wgtUtCd = wgtUtCd;
		this.blGroup = blGroup;
		this.notifyCustNm = notifyCustNm;
		this.pckQty = pckQty;
		this.custToOrdFlg = custToOrdFlg;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.ncmMultiFlg = ncmMultiFlg;
		this.obNtfyTaxNo = obNtfyTaxNo;
		this.delCd = delCd;
		this.shipperCustNm = shipperCustNm;
		this.cneeTaxNo = cneeTaxNo;
		this.consigneeCustNm = consigneeCustNm;
		this.brzDeclNo = brzDeclNo;
		this.oft = oft;
		this.bookingCmdtNm = bookingCmdtNm;
		this.obBrzDeclNo = obBrzDeclNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ifFlag = ifFlag;
		this.brMid = brMid;
		this.keyBlNo = keyBlNo;
		this.cntrNo = cntrNo;
		this.brDuv = brDuv;
		this.searchBkgCgoTpCd = searchBkgCgoTpCd;
		this.ntfyTaxNo = ntfyTaxNo;
		this.mergeBlNo = mergeBlNo;
		this.naStfFlg = naStfFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ncm_multi_no", getNcmMultiNo());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("measure", getMeasure());
		this.hashColumns.put("ncm_no", getNcmNo());
		this.hashColumns.put("cap", getCap());
		this.hashColumns.put("shpr_tax_no", getShprTaxNo());
		this.hashColumns.put("ncm_multi_pop", getNcmMultiPop());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("ob_cnee_tax_no", getObCneeTaxNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ob_shpr_tax_no", getObShprTaxNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("bl_group", getBlGroup());
		this.hashColumns.put("notify_cust_nm", getNotifyCustNm());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ncm_multi_flg", getNcmMultiFlg());
		this.hashColumns.put("ob_ntfy_tax_no", getObNtfyTaxNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("shipper_cust_nm", getShipperCustNm());
		this.hashColumns.put("cnee_tax_no", getCneeTaxNo());
		this.hashColumns.put("consignee_cust_nm", getConsigneeCustNm());
		this.hashColumns.put("brz_decl_no", getBrzDeclNo());
		this.hashColumns.put("oft", getOft());
		this.hashColumns.put("booking_cmdt_nm", getBookingCmdtNm());
		this.hashColumns.put("ob_brz_decl_no", getObBrzDeclNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("if_flag", getIfFlag());
		this.hashColumns.put("br_mid", getBrMid());
		this.hashColumns.put("key_bl_no", getKeyBlNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("br_duv", getBrDuv());
		this.hashColumns.put("search_bkg_cgo_tp_cd", getSearchBkgCgoTpCd());
		this.hashColumns.put("ntfy_tax_no", getNtfyTaxNo());
		this.hashColumns.put("merge_bl_no", getMergeBlNo());
		this.hashColumns.put("na_stf_flg", getNaStfFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ncm_multi_no", "ncmMultiNo");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("measure", "measure");
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("cap", "cap");
		this.hashFields.put("shpr_tax_no", "shprTaxNo");
		this.hashFields.put("ncm_multi_pop", "ncmMultiPop");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("ob_cnee_tax_no", "obCneeTaxNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ob_shpr_tax_no", "obShprTaxNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("bl_group", "blGroup");
		this.hashFields.put("notify_cust_nm", "notifyCustNm");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ncm_multi_flg", "ncmMultiFlg");
		this.hashFields.put("ob_ntfy_tax_no", "obNtfyTaxNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("shipper_cust_nm", "shipperCustNm");
		this.hashFields.put("cnee_tax_no", "cneeTaxNo");
		this.hashFields.put("consignee_cust_nm", "consigneeCustNm");
		this.hashFields.put("brz_decl_no", "brzDeclNo");
		this.hashFields.put("oft", "oft");
		this.hashFields.put("booking_cmdt_nm", "bookingCmdtNm");
		this.hashFields.put("ob_brz_decl_no", "obBrzDeclNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("if_flag", "ifFlag");
		this.hashFields.put("br_mid", "brMid");
		this.hashFields.put("key_bl_no", "keyBlNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("br_duv", "brDuv");
		this.hashFields.put("search_bkg_cgo_tp_cd", "searchBkgCgoTpCd");
		this.hashFields.put("ntfy_tax_no", "ntfyTaxNo");
		this.hashFields.put("merge_bl_no", "mergeBlNo");
		this.hashFields.put("na_stf_flg", "naStfFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ncmMultiNo
	 */
	public String getNcmMultiNo() {
		return this.ncmMultiNo;
	}
	
	/**
	 * Column Info
	 * @return weight
	 */
	public String getWeight() {
		return this.weight;
	}
	
	/**
	 * Column Info
	 * @return measure
	 */
	public String getMeasure() {
		return this.measure;
	}
	
	/**
	 * Column Info
	 * @return ncmNo
	 */
	public String getNcmNo() {
		return this.ncmNo;
	}
	
	/**
	 * Column Info
	 * @return cap
	 */
	public String getCap() {
		return this.cap;
	}
	
	/**
	 * Column Info
	 * @return shprTaxNo
	 */
	public String getShprTaxNo() {
		return this.shprTaxNo;
	}
	
	/**
	 * Column Info
	 * @return ncmMultiPop
	 */
	public String getNcmMultiPop() {
		return this.ncmMultiPop;
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
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @return obCneeTaxNo
	 */
	public String getObCneeTaxNo() {
		return this.obCneeTaxNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return obShprTaxNo
	 */
	public String getObShprTaxNo() {
		return this.obShprTaxNo;
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
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return blGroup
	 */
	public String getBlGroup() {
		return this.blGroup;
	}
	
	/**
	 * Column Info
	 * @return notifyCustNm
	 */
	public String getNotifyCustNm() {
		return this.notifyCustNm;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return ncmMultiFlg
	 */
	public String getNcmMultiFlg() {
		return this.ncmMultiFlg;
	}
	
	/**
	 * Column Info
	 * @return obNtfyTaxNo
	 */
	public String getObNtfyTaxNo() {
		return this.obNtfyTaxNo;
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
	 * @return shipperCustNm
	 */
	public String getShipperCustNm() {
		return this.shipperCustNm;
	}
	
	/**
	 * Column Info
	 * @return cneeTaxNo
	 */
	public String getCneeTaxNo() {
		return this.cneeTaxNo;
	}
	
	/**
	 * Column Info
	 * @return consigneeCustNm
	 */
	public String getConsigneeCustNm() {
		return this.consigneeCustNm;
	}
	
	/**
	 * Column Info
	 * @return brzDeclNo
	 */
	public String getBrzDeclNo() {
		return this.brzDeclNo;
	}
	
	/**
	 * Column Info
	 * @return oft
	 */
	public String getOft() {
		return this.oft;
	}
	
	/**
	 * Column Info
	 * @return bookingCmdtNm
	 */
	public String getBookingCmdtNm() {
		return this.bookingCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return obBrzDeclNo
	 */
	public String getObBrzDeclNo() {
		return this.obBrzDeclNo;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return ifFlag
	 */
	public String getIfFlag() {
		return this.ifFlag;
	}
	
	/**
	 * Column Info
	 * @return brMid
	 */
	public String getBrMid() {
		return this.brMid;
	}
	
	/**
	 * Column Info
	 * @return keyBlNo
	 */
	public String getKeyBlNo() {
		return this.keyBlNo;
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
	 * @return brDuv
	 */
	public String getBrDuv() {
		return this.brDuv;
	}
	
	/**
	 * Column Info
	 * @return searchBkgCgoTpCd
	 */
	public String getSearchBkgCgoTpCd() {
		return this.searchBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyTaxNo
	 */
	public String getNtfyTaxNo() {
		return this.ntfyTaxNo;
	}
	
	/**
	 * Column Info
	 * @return mergeBlNo
	 */
	public String getMergeBlNo() {
		return this.mergeBlNo;
	}
	
	/**
	 * Column Info
	 * @return naStfFlg
	 */
	public String getNaStfFlg() {
		return this.naStfFlg;
	}

	/**
	 * Column Info
	 * @param ncmMultiNo
	 */
	public void setNcmMultiNo(String ncmMultiNo) {
		this.ncmMultiNo = ncmMultiNo;
	}
	
	/**
	 * Column Info
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	/**
	 * Column Info
	 * @param measure
	 */
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	/**
	 * Column Info
	 * @param ncmNo
	 */
	public void setNcmNo(String ncmNo) {
		this.ncmNo = ncmNo;
	}
	
	/**
	 * Column Info
	 * @param cap
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	/**
	 * Column Info
	 * @param shprTaxNo
	 */
	public void setShprTaxNo(String shprTaxNo) {
		this.shprTaxNo = shprTaxNo;
	}
	
	/**
	 * Column Info
	 * @param ncmMultiPop
	 */
	public void setNcmMultiPop(String ncmMultiPop) {
		this.ncmMultiPop = ncmMultiPop;
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
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @param obCneeTaxNo
	 */
	public void setObCneeTaxNo(String obCneeTaxNo) {
		this.obCneeTaxNo = obCneeTaxNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param obShprTaxNo
	 */
	public void setObShprTaxNo(String obShprTaxNo) {
		this.obShprTaxNo = obShprTaxNo;
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
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param blGroup
	 */
	public void setBlGroup(String blGroup) {
		this.blGroup = blGroup;
	}
	
	/**
	 * Column Info
	 * @param notifyCustNm
	 */
	public void setNotifyCustNm(String notifyCustNm) {
		this.notifyCustNm = notifyCustNm;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param ncmMultiFlg
	 */
	public void setNcmMultiFlg(String ncmMultiFlg) {
		this.ncmMultiFlg = ncmMultiFlg;
	}
	
	/**
	 * Column Info
	 * @param obNtfyTaxNo
	 */
	public void setObNtfyTaxNo(String obNtfyTaxNo) {
		this.obNtfyTaxNo = obNtfyTaxNo;
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
	 * @param shipperCustNm
	 */
	public void setShipperCustNm(String shipperCustNm) {
		this.shipperCustNm = shipperCustNm;
	}
	
	/**
	 * Column Info
	 * @param cneeTaxNo
	 */
	public void setCneeTaxNo(String cneeTaxNo) {
		this.cneeTaxNo = cneeTaxNo;
	}
	
	/**
	 * Column Info
	 * @param consigneeCustNm
	 */
	public void setConsigneeCustNm(String consigneeCustNm) {
		this.consigneeCustNm = consigneeCustNm;
	}
	
	/**
	 * Column Info
	 * @param brzDeclNo
	 */
	public void setBrzDeclNo(String brzDeclNo) {
		this.brzDeclNo = brzDeclNo;
	}
	
	/**
	 * Column Info
	 * @param oft
	 */
	public void setOft(String oft) {
		this.oft = oft;
	}
	
	/**
	 * Column Info
	 * @param bookingCmdtNm
	 */
	public void setBookingCmdtNm(String bookingCmdtNm) {
		this.bookingCmdtNm = bookingCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param obBrzDeclNo
	 */
	public void setObBrzDeclNo(String obBrzDeclNo) {
		this.obBrzDeclNo = obBrzDeclNo;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param ifFlag
	 */
	public void setIfFlag(String ifFlag) {
		this.ifFlag = ifFlag;
	}
	
	/**
	 * Column Info
	 * @param brMid
	 */
	public void setBrMid(String brMid) {
		this.brMid = brMid;
	}
	
	/**
	 * Column Info
	 * @param keyBlNo
	 */
	public void setKeyBlNo(String keyBlNo) {
		this.keyBlNo = keyBlNo;
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
	 * @param brDuv
	 */
	public void setBrDuv(String brDuv) {
		this.brDuv = brDuv;
	}
	
	/**
	 * Column Info
	 * @param searchBkgCgoTpCd
	 */
	public void setSearchBkgCgoTpCd(String searchBkgCgoTpCd) {
		this.searchBkgCgoTpCd = searchBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyTaxNo
	 */
	public void setNtfyTaxNo(String ntfyTaxNo) {
		this.ntfyTaxNo = ntfyTaxNo;
	}
	
	/**
	 * Column Info
	 * @param mergeBlNo
	 */
	public void setMergeBlNo(String mergeBlNo) {
		this.mergeBlNo = mergeBlNo;
	}
	
	/**
	 * Column Info
	 * @param naStfFlg
	 */
	public void setNaStfFlg(String naStfFlg) {
		this.naStfFlg = naStfFlg;
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
		setNcmMultiNo(JSPUtil.getParameter(request, prefix + "ncm_multi_no", ""));
		setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
		setMeasure(JSPUtil.getParameter(request, prefix + "measure", ""));
		setNcmNo(JSPUtil.getParameter(request, prefix + "ncm_no", ""));
		setCap(JSPUtil.getParameter(request, prefix + "cap", ""));
		setShprTaxNo(JSPUtil.getParameter(request, prefix + "shpr_tax_no", ""));
		setNcmMultiPop(JSPUtil.getParameter(request, prefix + "ncm_multi_pop", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setObCneeTaxNo(JSPUtil.getParameter(request, prefix + "ob_cnee_tax_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setObShprTaxNo(JSPUtil.getParameter(request, prefix + "ob_shpr_tax_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setBlGroup(JSPUtil.getParameter(request, prefix + "bl_group", ""));
		setNotifyCustNm(JSPUtil.getParameter(request, prefix + "notify_cust_nm", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setNcmMultiFlg(JSPUtil.getParameter(request, prefix + "ncm_multi_flg", ""));
		setObNtfyTaxNo(JSPUtil.getParameter(request, prefix + "ob_ntfy_tax_no", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setShipperCustNm(JSPUtil.getParameter(request, prefix + "shipper_cust_nm", ""));
		setCneeTaxNo(JSPUtil.getParameter(request, prefix + "cnee_tax_no", ""));
		setConsigneeCustNm(JSPUtil.getParameter(request, prefix + "consignee_cust_nm", ""));
		setBrzDeclNo(JSPUtil.getParameter(request, prefix + "brz_decl_no", ""));
		setOft(JSPUtil.getParameter(request, prefix + "oft", ""));
		setBookingCmdtNm(JSPUtil.getParameter(request, prefix + "booking_cmdt_nm", ""));
		setObBrzDeclNo(JSPUtil.getParameter(request, prefix + "ob_brz_decl_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIfFlag(JSPUtil.getParameter(request, prefix + "if_flag", ""));
		setBrMid(JSPUtil.getParameter(request, prefix + "br_mid", ""));
		setKeyBlNo(JSPUtil.getParameter(request, prefix + "key_bl_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBrDuv(JSPUtil.getParameter(request, prefix + "br_duv", ""));
		setSearchBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "search_bkg_cgo_tp_cd", ""));
		setNtfyTaxNo(JSPUtil.getParameter(request, prefix + "ntfy_tax_no", ""));
		setMergeBlNo(JSPUtil.getParameter(request, prefix + "merge_bl_no", ""));
		setNaStfFlg(JSPUtil.getParameter(request, prefix + "na_stf_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrManifestListDetailVO[]
	 */
	public BrManifestListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrManifestListDetailVO[]
	 */
	public BrManifestListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrManifestListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ncmMultiNo = (JSPUtil.getParameter(request, prefix	+ "ncm_multi_no", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] measure = (JSPUtil.getParameter(request, prefix	+ "measure", length));
			String[] ncmNo = (JSPUtil.getParameter(request, prefix	+ "ncm_no", length));
			String[] cap = (JSPUtil.getParameter(request, prefix	+ "cap", length));
			String[] shprTaxNo = (JSPUtil.getParameter(request, prefix	+ "shpr_tax_no", length));
			String[] ncmMultiPop = (JSPUtil.getParameter(request, prefix	+ "ncm_multi_pop", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] obCneeTaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_cnee_tax_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] obShprTaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_shpr_tax_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] blGroup = (JSPUtil.getParameter(request, prefix	+ "bl_group", length));
			String[] notifyCustNm = (JSPUtil.getParameter(request, prefix	+ "notify_cust_nm", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ncmMultiFlg = (JSPUtil.getParameter(request, prefix	+ "ncm_multi_flg", length));
			String[] obNtfyTaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_ntfy_tax_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] shipperCustNm = (JSPUtil.getParameter(request, prefix	+ "shipper_cust_nm", length));
			String[] cneeTaxNo = (JSPUtil.getParameter(request, prefix	+ "cnee_tax_no", length));
			String[] consigneeCustNm = (JSPUtil.getParameter(request, prefix	+ "consignee_cust_nm", length));
			String[] brzDeclNo = (JSPUtil.getParameter(request, prefix	+ "brz_decl_no", length));
			String[] oft = (JSPUtil.getParameter(request, prefix	+ "oft", length));
			String[] bookingCmdtNm = (JSPUtil.getParameter(request, prefix	+ "booking_cmdt_nm", length));
			String[] obBrzDeclNo = (JSPUtil.getParameter(request, prefix	+ "ob_brz_decl_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ifFlag = (JSPUtil.getParameter(request, prefix	+ "if_flag", length));
			String[] brMid = (JSPUtil.getParameter(request, prefix	+ "br_mid", length));
			String[] keyBlNo = (JSPUtil.getParameter(request, prefix	+ "key_bl_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] brDuv = (JSPUtil.getParameter(request, prefix	+ "br_duv", length));
			String[] searchBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "search_bkg_cgo_tp_cd", length));
			String[] ntfyTaxNo = (JSPUtil.getParameter(request, prefix	+ "ntfy_tax_no", length));
			String[] mergeBlNo = (JSPUtil.getParameter(request, prefix	+ "merge_bl_no", length));
			String[] naStfFlg = (JSPUtil.getParameter(request, prefix	+ "na_stf_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrManifestListDetailVO();
				if (ncmMultiNo[i] != null)
					model.setNcmMultiNo(ncmMultiNo[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (measure[i] != null)
					model.setMeasure(measure[i]);
				if (ncmNo[i] != null)
					model.setNcmNo(ncmNo[i]);
				if (cap[i] != null)
					model.setCap(cap[i]);
				if (shprTaxNo[i] != null)
					model.setShprTaxNo(shprTaxNo[i]);
				if (ncmMultiPop[i] != null)
					model.setNcmMultiPop(ncmMultiPop[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (obCneeTaxNo[i] != null)
					model.setObCneeTaxNo(obCneeTaxNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (obShprTaxNo[i] != null)
					model.setObShprTaxNo(obShprTaxNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (blGroup[i] != null)
					model.setBlGroup(blGroup[i]);
				if (notifyCustNm[i] != null)
					model.setNotifyCustNm(notifyCustNm[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ncmMultiFlg[i] != null)
					model.setNcmMultiFlg(ncmMultiFlg[i]);
				if (obNtfyTaxNo[i] != null)
					model.setObNtfyTaxNo(obNtfyTaxNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (shipperCustNm[i] != null)
					model.setShipperCustNm(shipperCustNm[i]);
				if (cneeTaxNo[i] != null)
					model.setCneeTaxNo(cneeTaxNo[i]);
				if (consigneeCustNm[i] != null)
					model.setConsigneeCustNm(consigneeCustNm[i]);
				if (brzDeclNo[i] != null)
					model.setBrzDeclNo(brzDeclNo[i]);
				if (oft[i] != null)
					model.setOft(oft[i]);
				if (bookingCmdtNm[i] != null)
					model.setBookingCmdtNm(bookingCmdtNm[i]);
				if (obBrzDeclNo[i] != null)
					model.setObBrzDeclNo(obBrzDeclNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ifFlag[i] != null)
					model.setIfFlag(ifFlag[i]);
				if (brMid[i] != null)
					model.setBrMid(brMid[i]);
				if (keyBlNo[i] != null)
					model.setKeyBlNo(keyBlNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (brDuv[i] != null)
					model.setBrDuv(brDuv[i]);
				if (searchBkgCgoTpCd[i] != null)
					model.setSearchBkgCgoTpCd(searchBkgCgoTpCd[i]);
				if (ntfyTaxNo[i] != null)
					model.setNtfyTaxNo(ntfyTaxNo[i]);
				if (mergeBlNo[i] != null)
					model.setMergeBlNo(mergeBlNo[i]);
				if (naStfFlg[i] != null)
					model.setNaStfFlg(naStfFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrManifestListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrManifestListDetailVO[]
	 */
	public BrManifestListDetailVO[] getBrManifestListDetailVOs(){
		BrManifestListDetailVO[] vos = (BrManifestListDetailVO[])models.toArray(new BrManifestListDetailVO[models.size()]);
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
		this.ncmMultiNo = this.ncmMultiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measure = this.measure .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmNo = this.ncmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cap = this.cap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTaxNo = this.shprTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmMultiPop = this.ncmMultiPop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCneeTaxNo = this.obCneeTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obShprTaxNo = this.obShprTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blGroup = this.blGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyCustNm = this.notifyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmMultiFlg = this.ncmMultiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obNtfyTaxNo = this.obNtfyTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCustNm = this.shipperCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTaxNo = this.cneeTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeCustNm = this.consigneeCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzDeclNo = this.brzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oft = this.oft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingCmdtNm = this.bookingCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBrzDeclNo = this.obBrzDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlag = this.ifFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brMid = this.brMid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyBlNo = this.keyBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brDuv = this.brDuv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchBkgCgoTpCd = this.searchBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTaxNo = this.ntfyTaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeBlNo = this.mergeBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naStfFlg = this.naStfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
