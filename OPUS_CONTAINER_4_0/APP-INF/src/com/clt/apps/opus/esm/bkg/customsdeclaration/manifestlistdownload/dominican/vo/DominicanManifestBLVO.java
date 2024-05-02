/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestBLVO.java
*@FileTitle : DominicanManifestBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo;

import java.lang.reflect.Field;
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

public class DominicanManifestBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DominicanManifestBLVO> models = new ArrayList<DominicanManifestBLVO>();
	
	/* Column Info */
	private String consignorCode = null;
	/* Column Info */
	private String packageQty = null;
	/* Column Info */
	private String expressType = null;
	/* Column Info */
	private String consigneeFax = null;
	/* Column Info */
	private String notifyZoneName = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String consignorTel = null;
	/* Column Info */
	private String consignorDocumentNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String consigneeZoneName = null;
	/* Column Info */
	private String notifyCode = null;
	/* Column Info */
	private String consignorType = null;
	/* Column Info */
	private String consignorZipCode = null;
	/* Column Info */
	private String notifyName = null;
	/* Column Info */
	private String packageUnitCode = null;
	/* Column Info */
	private String notifyType = null;
	/* Column Info */
	private String value = null;
	/* Column Info */
	private String flightCharge = null;
	/* Column Info */
	private String consigneeName = null;
	/* Column Info */
	private String consignorCity = null;
	/* Column Info */
	private String consignorZoneName = null;
	/* Column Info */
	private String notifyStreet = null;
	/* Column Info */
	private String grossWeight = null;
	/* Column Info */
	private String notifyCity = null;
	/* Column Info */
	private String consignorDocumentType = null;
	/* Column Info */
	private String consignorCountryCode = null;
	/* Column Info */
	private String consigneeZipCode = null;
	/* Column Info */
	private String consignorEmail = null;
	/* Column Info */
	private String goodsName = null;
	/* Column Info */
	private String consignorStreet = null;
	/* Column Info */
	private String consigneeTel = null;
	/* Column Info */
	private String consigneeCity = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String consigneeDocumentNo = null;
	/* Column Info */
	private String notifyZipCode = null;
	/* Column Info */
	private String consigneeCountryCode = null;
	/* Column Info */
	private String notifyFax = null;
	/* Column Info */
	private String consigneeStreet = null;
	/* Column Info */
	private String consigneeDocumentType = null;
	/* Column Info */
	private String consigneeCode = null;
	/* Column Info */
	private String consignorName = null;
	/* Column Info */
	private String notifyDocumentNo = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String transitType = null;
	/* Column Info */
	private String loadingPortCode = null;
	/* Column Info */
	private String notifyDocumentType = null;
	/* Column Info */
	private String notifyCountryCode = null;
	/* Column Info */
	private String notifyTel = null;
	/* Column Info */
	private String consigneeType = null;
	/* Column Info */
	private String notifyEmail = null;
	/* Column Info */
	private String volume = null;
	/* Column Info */
	private String lastPortCode = null;
	/* Column Info */
	private String consigneeEmail = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DominicanManifestBLVO() {}

	public DominicanManifestBLVO(String ibflag, String pagerows, String blNo, String blType, String transitType, String lastPortCode, String loadingPortCode, String goodsName, String packageUnitCode, String packageQty, String grossWeight, String value, String flightCharge, String volume, String expressType, String consignorType, String consignorCode, String consignorTel, String consignorCountryCode, String consignorName, String consignorDocumentType, String consignorDocumentNo, String consignorEmail, String consigneeFax, String consignorZipCode, String consignorStreet, String consignorZoneName, String consignorCity, String consigneeType, String consigneeCode, String consigneeTel, String consigneeCountryCode, String consigneeName, String consigneeDocumentType, String consigneeDocumentNo, String consigneeEmail, String consigneeZipCode, String consigneeStreet, String consigneeZoneName, String consigneeCity, String notifyType, String notifyCode, String notifyCountryCode, String notifyDocumentType, String notifyDocumentNo, String notifyName, String notifyEmail, String notifyTel, String notifyFax, String notifyZipCode, String notifyStreet, String notifyZoneName, String notifyCity) {
		this.consignorCode = consignorCode;
		this.packageQty = packageQty;
		this.expressType = expressType;
		this.consigneeFax = consigneeFax;
		this.notifyZoneName = notifyZoneName;
		this.blNo = blNo;
		this.consignorTel = consignorTel;
		this.consignorDocumentNo = consignorDocumentNo;
		this.pagerows = pagerows;
		this.consigneeZoneName = consigneeZoneName;
		this.notifyCode = notifyCode;
		this.consignorType = consignorType;
		this.consignorZipCode = consignorZipCode;
		this.notifyName = notifyName;
		this.packageUnitCode = packageUnitCode;
		this.notifyType = notifyType;
		this.value = value;
		this.flightCharge = flightCharge;
		this.consigneeName = consigneeName;
		this.consignorCity = consignorCity;
		this.consignorZoneName = consignorZoneName;
		this.notifyStreet = notifyStreet;
		this.grossWeight = grossWeight;
		this.notifyCity = notifyCity;
		this.consignorDocumentType = consignorDocumentType;
		this.consignorCountryCode = consignorCountryCode;
		this.consigneeZipCode = consigneeZipCode;
		this.consignorEmail = consignorEmail;
		this.goodsName = goodsName;
		this.consignorStreet = consignorStreet;
		this.consigneeTel = consigneeTel;
		this.consigneeCity = consigneeCity;
		this.ibflag = ibflag;
		this.consigneeDocumentNo = consigneeDocumentNo;
		this.notifyZipCode = notifyZipCode;
		this.consigneeCountryCode = consigneeCountryCode;
		this.notifyFax = notifyFax;
		this.consigneeStreet = consigneeStreet;
		this.consigneeDocumentType = consigneeDocumentType;
		this.consigneeCode = consigneeCode;
		this.consignorName = consignorName;
		this.notifyDocumentNo = notifyDocumentNo;
		this.blType = blType;
		this.transitType = transitType;
		this.loadingPortCode = loadingPortCode;
		this.notifyDocumentType = notifyDocumentType;
		this.notifyCountryCode = notifyCountryCode;
		this.notifyTel = notifyTel;
		this.consigneeType = consigneeType;
		this.notifyEmail = notifyEmail;
		this.volume = volume;
		this.lastPortCode = lastPortCode;
		this.consigneeEmail = consigneeEmail;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("consignor_code", getConsignorCode());
		this.hashColumns.put("package_qty", getPackageQty());
		this.hashColumns.put("express_type", getExpressType());
		this.hashColumns.put("consignee_fax", getConsigneeFax());
		this.hashColumns.put("notify_zone_name", getNotifyZoneName());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("consignor_tel", getConsignorTel());
		this.hashColumns.put("consignor_document_no", getConsignorDocumentNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("consignee_zone_name", getConsigneeZoneName());
		this.hashColumns.put("notify_code", getNotifyCode());
		this.hashColumns.put("consignor_type", getConsignorType());
		this.hashColumns.put("consignor_zip_code", getConsignorZipCode());
		this.hashColumns.put("notify_name", getNotifyName());
		this.hashColumns.put("package_unit_code", getPackageUnitCode());
		this.hashColumns.put("notify_type", getNotifyType());
		this.hashColumns.put("value", getValue());
		this.hashColumns.put("flight_charge", getFlightCharge());
		this.hashColumns.put("consignee_name", getConsigneeName());
		this.hashColumns.put("consignor_city", getConsignorCity());
		this.hashColumns.put("consignor_zone_name", getConsignorZoneName());
		this.hashColumns.put("notify_street", getNotifyStreet());
		this.hashColumns.put("gross_weight", getGrossWeight());
		this.hashColumns.put("notify_city", getNotifyCity());
		this.hashColumns.put("consignor_document_type", getConsignorDocumentType());
		this.hashColumns.put("consignor_country_code", getConsignorCountryCode());
		this.hashColumns.put("consignee_zip_code", getConsigneeZipCode());
		this.hashColumns.put("consignor_email", getConsignorEmail());
		this.hashColumns.put("goods_name", getGoodsName());
		this.hashColumns.put("consignor_street", getConsignorStreet());
		this.hashColumns.put("consignee_tel", getConsigneeTel());
		this.hashColumns.put("consignee_city", getConsigneeCity());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("consignee_document_no", getConsigneeDocumentNo());
		this.hashColumns.put("notify_zip_code", getNotifyZipCode());
		this.hashColumns.put("consignee_country_code", getConsigneeCountryCode());
		this.hashColumns.put("notify_fax", getNotifyFax());
		this.hashColumns.put("consignee_street", getConsigneeStreet());
		this.hashColumns.put("consignee_document_type", getConsigneeDocumentType());
		this.hashColumns.put("consignee_code", getConsigneeCode());
		this.hashColumns.put("consignor_name", getConsignorName());
		this.hashColumns.put("notify_document_no", getNotifyDocumentNo());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("transit_type", getTransitType());
		this.hashColumns.put("loading_port_code", getLoadingPortCode());
		this.hashColumns.put("notify_document_type", getNotifyDocumentType());
		this.hashColumns.put("notify_country_code", getNotifyCountryCode());
		this.hashColumns.put("notify_tel", getNotifyTel());
		this.hashColumns.put("consignee_type", getConsigneeType());
		this.hashColumns.put("notify_email", getNotifyEmail());
		this.hashColumns.put("volume", getVolume());
		this.hashColumns.put("last_port_code", getLastPortCode());
		this.hashColumns.put("consignee_email", getConsigneeEmail());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("consignor_code", "consignorCode");
		this.hashFields.put("package_qty", "packageQty");
		this.hashFields.put("express_type", "expressType");
		this.hashFields.put("consignee_fax", "consigneeFax");
		this.hashFields.put("notify_zone_name", "notifyZoneName");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("consignor_tel", "consignorTel");
		this.hashFields.put("consignor_document_no", "consignorDocumentNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("consignee_zone_name", "consigneeZoneName");
		this.hashFields.put("notify_code", "notifyCode");
		this.hashFields.put("consignor_type", "consignorType");
		this.hashFields.put("consignor_zip_code", "consignorZipCode");
		this.hashFields.put("notify_name", "notifyName");
		this.hashFields.put("package_unit_code", "packageUnitCode");
		this.hashFields.put("notify_type", "notifyType");
		this.hashFields.put("value", "value");
		this.hashFields.put("flight_charge", "flightCharge");
		this.hashFields.put("consignee_name", "consigneeName");
		this.hashFields.put("consignor_city", "consignorCity");
		this.hashFields.put("consignor_zone_name", "consignorZoneName");
		this.hashFields.put("notify_street", "notifyStreet");
		this.hashFields.put("gross_weight", "grossWeight");
		this.hashFields.put("notify_city", "notifyCity");
		this.hashFields.put("consignor_document_type", "consignorDocumentType");
		this.hashFields.put("consignor_country_code", "consignorCountryCode");
		this.hashFields.put("consignee_zip_code", "consigneeZipCode");
		this.hashFields.put("consignor_email", "consignorEmail");
		this.hashFields.put("goods_name", "goodsName");
		this.hashFields.put("consignor_street", "consignorStreet");
		this.hashFields.put("consignee_tel", "consigneeTel");
		this.hashFields.put("consignee_city", "consigneeCity");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("consignee_document_no", "consigneeDocumentNo");
		this.hashFields.put("notify_zip_code", "notifyZipCode");
		this.hashFields.put("consignee_country_code", "consigneeCountryCode");
		this.hashFields.put("notify_fax", "notifyFax");
		this.hashFields.put("consignee_street", "consigneeStreet");
		this.hashFields.put("consignee_document_type", "consigneeDocumentType");
		this.hashFields.put("consignee_code", "consigneeCode");
		this.hashFields.put("consignor_name", "consignorName");
		this.hashFields.put("notify_document_no", "notifyDocumentNo");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("transit_type", "transitType");
		this.hashFields.put("loading_port_code", "loadingPortCode");
		this.hashFields.put("notify_document_type", "notifyDocumentType");
		this.hashFields.put("notify_country_code", "notifyCountryCode");
		this.hashFields.put("notify_tel", "notifyTel");
		this.hashFields.put("consignee_type", "consigneeType");
		this.hashFields.put("notify_email", "notifyEmail");
		this.hashFields.put("volume", "volume");
		this.hashFields.put("last_port_code", "lastPortCode");
		this.hashFields.put("consignee_email", "consigneeEmail");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return consignorCode
	 */
	public String getConsignorCode() {
		return this.consignorCode;
	}
	
	/**
	 * Column Info
	 * @return packageQty
	 */
	public String getPackageQty() {
		return this.packageQty;
	}
	
	/**
	 * Column Info
	 * @return expressType
	 */
	public String getExpressType() {
		return this.expressType;
	}
	
	/**
	 * Column Info
	 * @return consigneeFax
	 */
	public String getConsigneeFax() {
		return this.consigneeFax;
	}
	
	/**
	 * Column Info
	 * @return notifyZoneName
	 */
	public String getNotifyZoneName() {
		return this.notifyZoneName;
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
	 * @return consignorTel
	 */
	public String getConsignorTel() {
		return this.consignorTel;
	}
	
	/**
	 * Column Info
	 * @return consignorDocumentNo
	 */
	public String getConsignorDocumentNo() {
		return this.consignorDocumentNo;
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
	 * @return consigneeZoneName
	 */
	public String getConsigneeZoneName() {
		return this.consigneeZoneName;
	}
	
	/**
	 * Column Info
	 * @return notifyCode
	 */
	public String getNotifyCode() {
		return this.notifyCode;
	}
	
	/**
	 * Column Info
	 * @return consignorType
	 */
	public String getConsignorType() {
		return this.consignorType;
	}
	
	/**
	 * Column Info
	 * @return consignorZipCode
	 */
	public String getConsignorZipCode() {
		return this.consignorZipCode;
	}
	
	/**
	 * Column Info
	 * @return notifyName
	 */
	public String getNotifyName() {
		return this.notifyName;
	}
	
	/**
	 * Column Info
	 * @return packageUnitCode
	 */
	public String getPackageUnitCode() {
		return this.packageUnitCode;
	}
	
	/**
	 * Column Info
	 * @return notifyType
	 */
	public String getNotifyType() {
		return this.notifyType;
	}
	
	/**
	 * Column Info
	 * @return value
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Column Info
	 * @return flightCharge
	 */
	public String getFlightCharge() {
		return this.flightCharge;
	}
	
	/**
	 * Column Info
	 * @return consigneeName
	 */
	public String getConsigneeName() {
		return this.consigneeName;
	}
	
	/**
	 * Column Info
	 * @return consignorCity
	 */
	public String getConsignorCity() {
		return this.consignorCity;
	}
	
	/**
	 * Column Info
	 * @return consignorZoneName
	 */
	public String getConsignorZoneName() {
		return this.consignorZoneName;
	}
	
	/**
	 * Column Info
	 * @return notifyStreet
	 */
	public String getNotifyStreet() {
		return this.notifyStreet;
	}
	
	/**
	 * Column Info
	 * @return grossWeight
	 */
	public String getGrossWeight() {
		return this.grossWeight;
	}
	
	/**
	 * Column Info
	 * @return notifyCity
	 */
	public String getNotifyCity() {
		return this.notifyCity;
	}
	
	/**
	 * Column Info
	 * @return consignorDocumentType
	 */
	public String getConsignorDocumentType() {
		return this.consignorDocumentType;
	}
	
	/**
	 * Column Info
	 * @return consignorCountryCode
	 */
	public String getConsignorCountryCode() {
		return this.consignorCountryCode;
	}
	
	/**
	 * Column Info
	 * @return consigneeZipCode
	 */
	public String getConsigneeZipCode() {
		return this.consigneeZipCode;
	}
	
	/**
	 * Column Info
	 * @return consignorEmail
	 */
	public String getConsignorEmail() {
		return this.consignorEmail;
	}
	
	/**
	 * Column Info
	 * @return goodsName
	 */
	public String getGoodsName() {
		return this.goodsName;
	}
	
	/**
	 * Column Info
	 * @return consignorStreet
	 */
	public String getConsignorStreet() {
		return this.consignorStreet;
	}
	
	/**
	 * Column Info
	 * @return consigneeTel
	 */
	public String getConsigneeTel() {
		return this.consigneeTel;
	}
	
	/**
	 * Column Info
	 * @return consigneeCity
	 */
	public String getConsigneeCity() {
		return this.consigneeCity;
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
	 * @return consigneeDocumentNo
	 */
	public String getConsigneeDocumentNo() {
		return this.consigneeDocumentNo;
	}
	
	/**
	 * Column Info
	 * @return notifyZipCode
	 */
	public String getNotifyZipCode() {
		return this.notifyZipCode;
	}
	
	/**
	 * Column Info
	 * @return consigneeCountryCode
	 */
	public String getConsigneeCountryCode() {
		return this.consigneeCountryCode;
	}
	
	/**
	 * Column Info
	 * @return notifyFax
	 */
	public String getNotifyFax() {
		return this.notifyFax;
	}
	
	/**
	 * Column Info
	 * @return consigneeStreet
	 */
	public String getConsigneeStreet() {
		return this.consigneeStreet;
	}
	
	/**
	 * Column Info
	 * @return consigneeDocumentType
	 */
	public String getConsigneeDocumentType() {
		return this.consigneeDocumentType;
	}
	
	/**
	 * Column Info
	 * @return consigneeCode
	 */
	public String getConsigneeCode() {
		return this.consigneeCode;
	}
	
	/**
	 * Column Info
	 * @return consignorName
	 */
	public String getConsignorName() {
		return this.consignorName;
	}
	
	/**
	 * Column Info
	 * @return notifyDocumentNo
	 */
	public String getNotifyDocumentNo() {
		return this.notifyDocumentNo;
	}
	
	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
	}
	
	/**
	 * Column Info
	 * @return transitType
	 */
	public String getTransitType() {
		return this.transitType;
	}
	
	/**
	 * Column Info
	 * @return loadingPortCode
	 */
	public String getLoadingPortCode() {
		return this.loadingPortCode;
	}
	
	/**
	 * Column Info
	 * @return notifyDocumentType
	 */
	public String getNotifyDocumentType() {
		return this.notifyDocumentType;
	}
	
	/**
	 * Column Info
	 * @return notifyCountryCode
	 */
	public String getNotifyCountryCode() {
		return this.notifyCountryCode;
	}
	
	/**
	 * Column Info
	 * @return notifyTel
	 */
	public String getNotifyTel() {
		return this.notifyTel;
	}
	
	/**
	 * Column Info
	 * @return consigneeType
	 */
	public String getConsigneeType() {
		return this.consigneeType;
	}
	
	/**
	 * Column Info
	 * @return notifyEmail
	 */
	public String getNotifyEmail() {
		return this.notifyEmail;
	}
	
	/**
	 * Column Info
	 * @return volume
	 */
	public String getVolume() {
		return this.volume;
	}
	
	/**
	 * Column Info
	 * @return lastPortCode
	 */
	public String getLastPortCode() {
		return this.lastPortCode;
	}
	
	/**
	 * Column Info
	 * @return consigneeEmail
	 */
	public String getConsigneeEmail() {
		return this.consigneeEmail;
	}
	

	/**
	 * Column Info
	 * @param consignorCode
	 */
	public void setConsignorCode(String consignorCode) {
		this.consignorCode = consignorCode;
	}
	
	/**
	 * Column Info
	 * @param packageQty
	 */
	public void setPackageQty(String packageQty) {
		this.packageQty = packageQty;
	}
	
	/**
	 * Column Info
	 * @param expressType
	 */
	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}
	
	/**
	 * Column Info
	 * @param consigneeFax
	 */
	public void setConsigneeFax(String consigneeFax) {
		this.consigneeFax = consigneeFax;
	}
	
	/**
	 * Column Info
	 * @param notifyZoneName
	 */
	public void setNotifyZoneName(String notifyZoneName) {
		this.notifyZoneName = notifyZoneName;
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
	 * @param consignorTel
	 */
	public void setConsignorTel(String consignorTel) {
		this.consignorTel = consignorTel;
	}
	
	/**
	 * Column Info
	 * @param consignorDocumentNo
	 */
	public void setConsignorDocumentNo(String consignorDocumentNo) {
		this.consignorDocumentNo = consignorDocumentNo;
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
	 * @param consigneeZoneName
	 */
	public void setConsigneeZoneName(String consigneeZoneName) {
		this.consigneeZoneName = consigneeZoneName;
	}
	
	/**
	 * Column Info
	 * @param notifyCode
	 */
	public void setNotifyCode(String notifyCode) {
		this.notifyCode = notifyCode;
	}
	
	/**
	 * Column Info
	 * @param consignorType
	 */
	public void setConsignorType(String consignorType) {
		this.consignorType = consignorType;
	}
	
	/**
	 * Column Info
	 * @param consignorZipCode
	 */
	public void setConsignorZipCode(String consignorZipCode) {
		this.consignorZipCode = consignorZipCode;
	}
	
	/**
	 * Column Info
	 * @param notifyName
	 */
	public void setNotifyName(String notifyName) {
		this.notifyName = notifyName;
	}
	
	/**
	 * Column Info
	 * @param packageUnitCode
	 */
	public void setPackageUnitCode(String packageUnitCode) {
		this.packageUnitCode = packageUnitCode;
	}
	
	/**
	 * Column Info
	 * @param notifyType
	 */
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	
	/**
	 * Column Info
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Column Info
	 * @param flightCharge
	 */
	public void setFlightCharge(String flightCharge) {
		this.flightCharge = flightCharge;
	}
	
	/**
	 * Column Info
	 * @param consigneeName
	 */
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	
	/**
	 * Column Info
	 * @param consignorCity
	 */
	public void setConsignorCity(String consignorCity) {
		this.consignorCity = consignorCity;
	}
	
	/**
	 * Column Info
	 * @param consignorZoneName
	 */
	public void setConsignorZoneName(String consignorZoneName) {
		this.consignorZoneName = consignorZoneName;
	}
	
	/**
	 * Column Info
	 * @param notifyStreet
	 */
	public void setNotifyStreet(String notifyStreet) {
		this.notifyStreet = notifyStreet;
	}
	
	/**
	 * Column Info
	 * @param grossWeight
	 */
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	
	/**
	 * Column Info
	 * @param notifyCity
	 */
	public void setNotifyCity(String notifyCity) {
		this.notifyCity = notifyCity;
	}
	
	/**
	 * Column Info
	 * @param consignorDocumentType
	 */
	public void setConsignorDocumentType(String consignorDocumentType) {
		this.consignorDocumentType = consignorDocumentType;
	}
	
	/**
	 * Column Info
	 * @param consignorCountryCode
	 */
	public void setConsignorCountryCode(String consignorCountryCode) {
		this.consignorCountryCode = consignorCountryCode;
	}
	
	/**
	 * Column Info
	 * @param consigneeZipCode
	 */
	public void setConsigneeZipCode(String consigneeZipCode) {
		this.consigneeZipCode = consigneeZipCode;
	}
	
	/**
	 * Column Info
	 * @param consignorEmail
	 */
	public void setConsignorEmail(String consignorEmail) {
		this.consignorEmail = consignorEmail;
	}
	
	/**
	 * Column Info
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	/**
	 * Column Info
	 * @param consignorStreet
	 */
	public void setConsignorStreet(String consignorStreet) {
		this.consignorStreet = consignorStreet;
	}
	
	/**
	 * Column Info
	 * @param consigneeTel
	 */
	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}
	
	/**
	 * Column Info
	 * @param consigneeCity
	 */
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
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
	 * @param consigneeDocumentNo
	 */
	public void setConsigneeDocumentNo(String consigneeDocumentNo) {
		this.consigneeDocumentNo = consigneeDocumentNo;
	}
	
	/**
	 * Column Info
	 * @param notifyZipCode
	 */
	public void setNotifyZipCode(String notifyZipCode) {
		this.notifyZipCode = notifyZipCode;
	}
	
	/**
	 * Column Info
	 * @param consigneeCountryCode
	 */
	public void setConsigneeCountryCode(String consigneeCountryCode) {
		this.consigneeCountryCode = consigneeCountryCode;
	}
	
	/**
	 * Column Info
	 * @param notifyFax
	 */
	public void setNotifyFax(String notifyFax) {
		this.notifyFax = notifyFax;
	}
	
	/**
	 * Column Info
	 * @param consigneeStreet
	 */
	public void setConsigneeStreet(String consigneeStreet) {
		this.consigneeStreet = consigneeStreet;
	}
	
	/**
	 * Column Info
	 * @param consigneeDocumentType
	 */
	public void setConsigneeDocumentType(String consigneeDocumentType) {
		this.consigneeDocumentType = consigneeDocumentType;
	}
	
	/**
	 * Column Info
	 * @param consigneeCode
	 */
	public void setConsigneeCode(String consigneeCode) {
		this.consigneeCode = consigneeCode;
	}
	
	/**
	 * Column Info
	 * @param consignorName
	 */
	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}
	
	/**
	 * Column Info
	 * @param notifyDocumentNo
	 */
	public void setNotifyDocumentNo(String notifyDocumentNo) {
		this.notifyDocumentNo = notifyDocumentNo;
	}
	
	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
	}
	
	/**
	 * Column Info
	 * @param transitType
	 */
	public void setTransitType(String transitType) {
		this.transitType = transitType;
	}
	
	/**
	 * Column Info
	 * @param loadingPortCode
	 */
	public void setLoadingPortCode(String loadingPortCode) {
		this.loadingPortCode = loadingPortCode;
	}
	
	/**
	 * Column Info
	 * @param notifyDocumentType
	 */
	public void setNotifyDocumentType(String notifyDocumentType) {
		this.notifyDocumentType = notifyDocumentType;
	}
	
	/**
	 * Column Info
	 * @param notifyCountryCode
	 */
	public void setNotifyCountryCode(String notifyCountryCode) {
		this.notifyCountryCode = notifyCountryCode;
	}
	
	/**
	 * Column Info
	 * @param notifyTel
	 */
	public void setNotifyTel(String notifyTel) {
		this.notifyTel = notifyTel;
	}
	
	/**
	 * Column Info
	 * @param consigneeType
	 */
	public void setConsigneeType(String consigneeType) {
		this.consigneeType = consigneeType;
	}
	
	/**
	 * Column Info
	 * @param notifyEmail
	 */
	public void setNotifyEmail(String notifyEmail) {
		this.notifyEmail = notifyEmail;
	}
	
	/**
	 * Column Info
	 * @param volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	/**
	 * Column Info
	 * @param lastPortCode
	 */
	public void setLastPortCode(String lastPortCode) {
		this.lastPortCode = lastPortCode;
	}
	
	/**
	 * Column Info
	 * @param consigneeEmail
	 */
	public void setConsigneeEmail(String consigneeEmail) {
		this.consigneeEmail = consigneeEmail;
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
		setConsignorCode(JSPUtil.getParameter(request, prefix + "consignor_code", ""));
		setPackageQty(JSPUtil.getParameter(request, prefix + "package_qty", ""));
		setExpressType(JSPUtil.getParameter(request, prefix + "express_type", ""));
		setConsigneeFax(JSPUtil.getParameter(request, prefix + "consignee_fax", ""));
		setNotifyZoneName(JSPUtil.getParameter(request, prefix + "notify_zone_name", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setConsignorTel(JSPUtil.getParameter(request, prefix + "consignor_tel", ""));
		setConsignorDocumentNo(JSPUtil.getParameter(request, prefix + "consignor_document_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setConsigneeZoneName(JSPUtil.getParameter(request, prefix + "consignee_zone_name", ""));
		setNotifyCode(JSPUtil.getParameter(request, prefix + "notify_code", ""));
		setConsignorType(JSPUtil.getParameter(request, prefix + "consignor_type", ""));
		setConsignorZipCode(JSPUtil.getParameter(request, prefix + "consignor_zip_code", ""));
		setNotifyName(JSPUtil.getParameter(request, prefix + "notify_name", ""));
		setPackageUnitCode(JSPUtil.getParameter(request, prefix + "package_unit_code", ""));
		setNotifyType(JSPUtil.getParameter(request, prefix + "notify_type", ""));
		setValue(JSPUtil.getParameter(request, prefix + "value", ""));
		setFlightCharge(JSPUtil.getParameter(request, prefix + "flight_charge", ""));
		setConsigneeName(JSPUtil.getParameter(request, prefix + "consignee_name", ""));
		setConsignorCity(JSPUtil.getParameter(request, prefix + "consignor_city", ""));
		setConsignorZoneName(JSPUtil.getParameter(request, prefix + "consignor_zone_name", ""));
		setNotifyStreet(JSPUtil.getParameter(request, prefix + "notify_street", ""));
		setGrossWeight(JSPUtil.getParameter(request, prefix + "gross_weight", ""));
		setNotifyCity(JSPUtil.getParameter(request, prefix + "notify_city", ""));
		setConsignorDocumentType(JSPUtil.getParameter(request, prefix + "consignor_document_type", ""));
		setConsignorCountryCode(JSPUtil.getParameter(request, prefix + "consignor_country_code", ""));
		setConsigneeZipCode(JSPUtil.getParameter(request, prefix + "consignee_zip_code", ""));
		setConsignorEmail(JSPUtil.getParameter(request, prefix + "consignor_email", ""));
		setGoodsName(JSPUtil.getParameter(request, prefix + "goods_name", ""));
		setConsignorStreet(JSPUtil.getParameter(request, prefix + "consignor_street", ""));
		setConsigneeTel(JSPUtil.getParameter(request, prefix + "consignee_tel", ""));
		setConsigneeCity(JSPUtil.getParameter(request, prefix + "consignee_city", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setConsigneeDocumentNo(JSPUtil.getParameter(request, prefix + "consignee_document_no", ""));
		setNotifyZipCode(JSPUtil.getParameter(request, prefix + "notify_zip_code", ""));
		setConsigneeCountryCode(JSPUtil.getParameter(request, prefix + "consignee_country_code", ""));
		setNotifyFax(JSPUtil.getParameter(request, prefix + "notify_fax", ""));
		setConsigneeStreet(JSPUtil.getParameter(request, prefix + "consignee_street", ""));
		setConsigneeDocumentType(JSPUtil.getParameter(request, prefix + "consignee_document_type", ""));
		setConsigneeCode(JSPUtil.getParameter(request, prefix + "consignee_code", ""));
		setConsignorName(JSPUtil.getParameter(request, prefix + "consignor_name", ""));
		setNotifyDocumentNo(JSPUtil.getParameter(request, prefix + "notify_document_no", ""));
		setBlType(JSPUtil.getParameter(request, prefix + "bl_type", ""));
		setTransitType(JSPUtil.getParameter(request, prefix + "transit_type", ""));
		setLoadingPortCode(JSPUtil.getParameter(request, prefix + "loading_port_code", ""));
		setNotifyDocumentType(JSPUtil.getParameter(request, prefix + "notify_document_type", ""));
		setNotifyCountryCode(JSPUtil.getParameter(request, prefix + "notify_country_code", ""));
		setNotifyTel(JSPUtil.getParameter(request, prefix + "notify_tel", ""));
		setConsigneeType(JSPUtil.getParameter(request, prefix + "consignee_type", ""));
		setNotifyEmail(JSPUtil.getParameter(request, prefix + "notify_email", ""));
		setVolume(JSPUtil.getParameter(request, prefix + "volume", ""));
		setLastPortCode(JSPUtil.getParameter(request, prefix + "last_port_code", ""));
		setConsigneeEmail(JSPUtil.getParameter(request, prefix + "consignee_email", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DominicanManifestBLVO[]
	 */
	public DominicanManifestBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DominicanManifestBLVO[]
	 */
	public DominicanManifestBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DominicanManifestBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] consignorCode = (JSPUtil.getParameter(request, prefix	+ "consignor_code", length));
			String[] packageQty = (JSPUtil.getParameter(request, prefix	+ "package_qty", length));
			String[] expressType = (JSPUtil.getParameter(request, prefix	+ "express_type", length));
			String[] consigneeFax = (JSPUtil.getParameter(request, prefix	+ "consignee_fax", length));
			String[] notifyZoneName = (JSPUtil.getParameter(request, prefix	+ "notify_zone_name", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] consignorTel = (JSPUtil.getParameter(request, prefix	+ "consignor_tel", length));
			String[] consignorDocumentNo = (JSPUtil.getParameter(request, prefix	+ "consignor_document_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] consigneeZoneName = (JSPUtil.getParameter(request, prefix	+ "consignee_zone_name", length));
			String[] notifyCode = (JSPUtil.getParameter(request, prefix	+ "notify_code", length));
			String[] consignorType = (JSPUtil.getParameter(request, prefix	+ "consignor_type", length));
			String[] consignorZipCode = (JSPUtil.getParameter(request, prefix	+ "consignor_zip_code", length));
			String[] notifyName = (JSPUtil.getParameter(request, prefix	+ "notify_name", length));
			String[] packageUnitCode = (JSPUtil.getParameter(request, prefix	+ "package_unit_code", length));
			String[] notifyType = (JSPUtil.getParameter(request, prefix	+ "notify_type", length));
			String[] value = (JSPUtil.getParameter(request, prefix	+ "value", length));
			String[] flightCharge = (JSPUtil.getParameter(request, prefix	+ "flight_charge", length));
			String[] consigneeName = (JSPUtil.getParameter(request, prefix	+ "consignee_name", length));
			String[] consignorCity = (JSPUtil.getParameter(request, prefix	+ "consignor_city", length));
			String[] consignorZoneName = (JSPUtil.getParameter(request, prefix	+ "consignor_zone_name", length));
			String[] notifyStreet = (JSPUtil.getParameter(request, prefix	+ "notify_street", length));
			String[] grossWeight = (JSPUtil.getParameter(request, prefix	+ "gross_weight", length));
			String[] notifyCity = (JSPUtil.getParameter(request, prefix	+ "notify_city", length));
			String[] consignorDocumentType = (JSPUtil.getParameter(request, prefix	+ "consignor_document_type", length));
			String[] consignorCountryCode = (JSPUtil.getParameter(request, prefix	+ "consignor_country_code", length));
			String[] consigneeZipCode = (JSPUtil.getParameter(request, prefix	+ "consignee_zip_code", length));
			String[] consignorEmail = (JSPUtil.getParameter(request, prefix	+ "consignor_email", length));
			String[] goodsName = (JSPUtil.getParameter(request, prefix	+ "goods_name", length));
			String[] consignorStreet = (JSPUtil.getParameter(request, prefix	+ "consignor_street", length));
			String[] consigneeTel = (JSPUtil.getParameter(request, prefix	+ "consignee_tel", length));
			String[] consigneeCity = (JSPUtil.getParameter(request, prefix	+ "consignee_city", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] consigneeDocumentNo = (JSPUtil.getParameter(request, prefix	+ "consignee_document_no", length));
			String[] notifyZipCode = (JSPUtil.getParameter(request, prefix	+ "notify_zip_code", length));
			String[] consigneeCountryCode = (JSPUtil.getParameter(request, prefix	+ "consignee_country_code", length));
			String[] notifyFax = (JSPUtil.getParameter(request, prefix	+ "notify_fax", length));
			String[] consigneeStreet = (JSPUtil.getParameter(request, prefix	+ "consignee_street", length));
			String[] consigneeDocumentType = (JSPUtil.getParameter(request, prefix	+ "consignee_document_type", length));
			String[] consigneeCode = (JSPUtil.getParameter(request, prefix	+ "consignee_code", length));
			String[] consignorName = (JSPUtil.getParameter(request, prefix	+ "consignor_name", length));
			String[] notifyDocumentNo = (JSPUtil.getParameter(request, prefix	+ "notify_document_no", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] transitType = (JSPUtil.getParameter(request, prefix	+ "transit_type", length));
			String[] loadingPortCode = (JSPUtil.getParameter(request, prefix	+ "loading_port_code", length));
			String[] notifyDocumentType = (JSPUtil.getParameter(request, prefix	+ "notify_document_type", length));
			String[] notifyCountryCode = (JSPUtil.getParameter(request, prefix	+ "notify_country_code", length));
			String[] notifyTel = (JSPUtil.getParameter(request, prefix	+ "notify_tel", length));
			String[] consigneeType = (JSPUtil.getParameter(request, prefix	+ "consignee_type", length));
			String[] notifyEmail = (JSPUtil.getParameter(request, prefix	+ "notify_email", length));
			String[] volume = (JSPUtil.getParameter(request, prefix	+ "volume", length));
			String[] lastPortCode = (JSPUtil.getParameter(request, prefix	+ "last_port_code", length));
			String[] consigneeEmail = (JSPUtil.getParameter(request, prefix	+ "consignee_email", length));
			
			for (int i = 0; i < length; i++) {
				model = new DominicanManifestBLVO();
				if (consignorCode[i] != null)
					model.setConsignorCode(consignorCode[i]);
				if (packageQty[i] != null)
					model.setPackageQty(packageQty[i]);
				if (expressType[i] != null)
					model.setExpressType(expressType[i]);
				if (consigneeFax[i] != null)
					model.setConsigneeFax(consigneeFax[i]);
				if (notifyZoneName[i] != null)
					model.setNotifyZoneName(notifyZoneName[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (consignorTel[i] != null)
					model.setConsignorTel(consignorTel[i]);
				if (consignorDocumentNo[i] != null)
					model.setConsignorDocumentNo(consignorDocumentNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (consigneeZoneName[i] != null)
					model.setConsigneeZoneName(consigneeZoneName[i]);
				if (notifyCode[i] != null)
					model.setNotifyCode(notifyCode[i]);
				if (consignorType[i] != null)
					model.setConsignorType(consignorType[i]);
				if (consignorZipCode[i] != null)
					model.setConsignorZipCode(consignorZipCode[i]);
				if (notifyName[i] != null)
					model.setNotifyName(notifyName[i]);
				if (packageUnitCode[i] != null)
					model.setPackageUnitCode(packageUnitCode[i]);
				if (notifyType[i] != null)
					model.setNotifyType(notifyType[i]);
				if (value[i] != null)
					model.setValue(value[i]);
				if (flightCharge[i] != null)
					model.setFlightCharge(flightCharge[i]);
				if (consigneeName[i] != null)
					model.setConsigneeName(consigneeName[i]);
				if (consignorCity[i] != null)
					model.setConsignorCity(consignorCity[i]);
				if (consignorZoneName[i] != null)
					model.setConsignorZoneName(consignorZoneName[i]);
				if (notifyStreet[i] != null)
					model.setNotifyStreet(notifyStreet[i]);
				if (grossWeight[i] != null)
					model.setGrossWeight(grossWeight[i]);
				if (notifyCity[i] != null)
					model.setNotifyCity(notifyCity[i]);
				if (consignorDocumentType[i] != null)
					model.setConsignorDocumentType(consignorDocumentType[i]);
				if (consignorCountryCode[i] != null)
					model.setConsignorCountryCode(consignorCountryCode[i]);
				if (consigneeZipCode[i] != null)
					model.setConsigneeZipCode(consigneeZipCode[i]);
				if (consignorEmail[i] != null)
					model.setConsignorEmail(consignorEmail[i]);
				if (goodsName[i] != null)
					model.setGoodsName(goodsName[i]);
				if (consignorStreet[i] != null)
					model.setConsignorStreet(consignorStreet[i]);
				if (consigneeTel[i] != null)
					model.setConsigneeTel(consigneeTel[i]);
				if (consigneeCity[i] != null)
					model.setConsigneeCity(consigneeCity[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (consigneeDocumentNo[i] != null)
					model.setConsigneeDocumentNo(consigneeDocumentNo[i]);
				if (notifyZipCode[i] != null)
					model.setNotifyZipCode(notifyZipCode[i]);
				if (consigneeCountryCode[i] != null)
					model.setConsigneeCountryCode(consigneeCountryCode[i]);
				if (notifyFax[i] != null)
					model.setNotifyFax(notifyFax[i]);
				if (consigneeStreet[i] != null)
					model.setConsigneeStreet(consigneeStreet[i]);
				if (consigneeDocumentType[i] != null)
					model.setConsigneeDocumentType(consigneeDocumentType[i]);
				if (consigneeCode[i] != null)
					model.setConsigneeCode(consigneeCode[i]);
				if (consignorName[i] != null)
					model.setConsignorName(consignorName[i]);
				if (notifyDocumentNo[i] != null)
					model.setNotifyDocumentNo(notifyDocumentNo[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (transitType[i] != null)
					model.setTransitType(transitType[i]);
				if (loadingPortCode[i] != null)
					model.setLoadingPortCode(loadingPortCode[i]);
				if (notifyDocumentType[i] != null)
					model.setNotifyDocumentType(notifyDocumentType[i]);
				if (notifyCountryCode[i] != null)
					model.setNotifyCountryCode(notifyCountryCode[i]);
				if (notifyTel[i] != null)
					model.setNotifyTel(notifyTel[i]);
				if (consigneeType[i] != null)
					model.setConsigneeType(consigneeType[i]);
				if (notifyEmail[i] != null)
					model.setNotifyEmail(notifyEmail[i]);
				if (volume[i] != null)
					model.setVolume(volume[i]);
				if (lastPortCode[i] != null)
					model.setLastPortCode(lastPortCode[i]);
				if (consigneeEmail[i] != null)
					model.setConsigneeEmail(consigneeEmail[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDominicanManifestBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DominicanManifestBLVO[]
	 */
	public DominicanManifestBLVO[] getDominicanManifestBLVOs(){
		DominicanManifestBLVO[] vos = (DominicanManifestBLVO[])models.toArray(new DominicanManifestBLVO[models.size()]);
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
		this.consignorCode = this.consignorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packageQty = this.packageQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expressType = this.expressType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeFax = this.consigneeFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyZoneName = this.notifyZoneName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorTel = this.consignorTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorDocumentNo = this.consignorDocumentNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeZoneName = this.consigneeZoneName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyCode = this.notifyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorType = this.consignorType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorZipCode = this.consignorZipCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyName = this.notifyName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packageUnitCode = this.packageUnitCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyType = this.notifyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value = this.value .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flightCharge = this.flightCharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeName = this.consigneeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorCity = this.consignorCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorZoneName = this.consignorZoneName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyStreet = this.notifyStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossWeight = this.grossWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyCity = this.notifyCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorDocumentType = this.consignorDocumentType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorCountryCode = this.consignorCountryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeZipCode = this.consigneeZipCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorEmail = this.consignorEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsName = this.goodsName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorStreet = this.consignorStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeTel = this.consigneeTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeCity = this.consigneeCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeDocumentNo = this.consigneeDocumentNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyZipCode = this.notifyZipCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeCountryCode = this.consigneeCountryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyFax = this.notifyFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeStreet = this.consigneeStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeDocumentType = this.consigneeDocumentType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeCode = this.consigneeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignorName = this.consignorName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyDocumentNo = this.notifyDocumentNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transitType = this.transitType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadingPortCode = this.loadingPortCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyDocumentType = this.notifyDocumentType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyCountryCode = this.notifyCountryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyTel = this.notifyTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeType = this.consigneeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyEmail = this.notifyEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volume = this.volume .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPortCode = this.lastPortCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeEmail = this.consigneeEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
