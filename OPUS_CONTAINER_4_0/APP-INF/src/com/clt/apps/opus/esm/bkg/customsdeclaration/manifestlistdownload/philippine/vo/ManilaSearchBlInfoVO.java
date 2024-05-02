/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ManilaSearchBlInfoVO.java
*@FileTitle : ManilaSearchBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

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

public class ManilaSearchBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchBlInfoVO> models = new ArrayList<ManilaSearchBlInfoVO>();
	
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String shipperAddress3 = null;
	/* Column Info */
	private String shipperAddress4 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String etlCargoType = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String notifyAddress1 = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String notifyAddress2 = null;
	/* Column Info */
	private String notifyAddress3 = null;
	/* Column Info */
	private String notifyAddress4 = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String countryOrigin = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String shipperName2 = null;
	/* Column Info */
	private String shipperName1 = null;
	/* Column Info */
	private String notifyName1 = null;
	/* Column Info */
	private String notifyName2 = null;
	/* Column Info */
	private String shipperAddress2 = null;
	/* Column Info */
	private String shipperAddress1 = null;
	/* Column Info */
	private String consigneeName2 = null;
	/* Column Info */
	private String regNumber2 = null;
	/* Column Info */
	private String volume = null;
	/* Column Info */
	private String consigneeAddress4 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String consigneeAddress3 = null;
	/* Column Info */
	private String consigneeName1 = null;
	/* Column Info */
	private String consigneeAddress2 = null;
	/* Column Info */
	private String consigneeAddress1 = null;
	/* Column Info */
	private String totalCntr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ManilaSearchBlInfoVO() {}

	public ManilaSearchBlInfoVO(String ibflag, String pagerows, String blNo, String cargoType, String consigneeAddress1, String consigneeAddress2, String consigneeAddress3, String consigneeAddress4, String consigneeName1, String consigneeName2, String countryOrigin, String etlCargoType, String notifyAddress1, String notifyAddress2, String notifyAddress3, String notifyAddress4, String notifyName1, String notifyName2, String pod, String regNumber2, String seq, String shipperAddress1, String shipperAddress2, String shipperAddress3, String shipperAddress4, String shipperName1, String shipperName2, String totalCntr, String volume, String weight, String year) {
		this.weight = weight;
		this.shipperAddress3 = shipperAddress3;
		this.shipperAddress4 = shipperAddress4;
		this.blNo = blNo;
		this.etlCargoType = etlCargoType;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.notifyAddress1 = notifyAddress1;
		this.cargoType = cargoType;
		this.notifyAddress2 = notifyAddress2;
		this.notifyAddress3 = notifyAddress3;
		this.notifyAddress4 = notifyAddress4;
		this.year = year;
		this.countryOrigin = countryOrigin;
		this.pod = pod;
		this.shipperName2 = shipperName2;
		this.shipperName1 = shipperName1;
		this.notifyName1 = notifyName1;
		this.notifyName2 = notifyName2;
		this.shipperAddress2 = shipperAddress2;
		this.shipperAddress1 = shipperAddress1;
		this.consigneeName2 = consigneeName2;
		this.regNumber2 = regNumber2;
		this.volume = volume;
		this.consigneeAddress4 = consigneeAddress4;
		this.seq = seq;
		this.consigneeAddress3 = consigneeAddress3;
		this.consigneeName1 = consigneeName1;
		this.consigneeAddress2 = consigneeAddress2;
		this.consigneeAddress1 = consigneeAddress1;
		this.totalCntr = totalCntr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("shipper_address3", getShipperAddress3());
		this.hashColumns.put("shipper_address4", getShipperAddress4());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("etl_cargo_type", getEtlCargoType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("notify_address1", getNotifyAddress1());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("notify_address2", getNotifyAddress2());
		this.hashColumns.put("notify_address3", getNotifyAddress3());
		this.hashColumns.put("notify_address4", getNotifyAddress4());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("country_origin", getCountryOrigin());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("shipper_name2", getShipperName2());
		this.hashColumns.put("shipper_name1", getShipperName1());
		this.hashColumns.put("notify_name1", getNotifyName1());
		this.hashColumns.put("notify_name2", getNotifyName2());
		this.hashColumns.put("shipper_address2", getShipperAddress2());
		this.hashColumns.put("shipper_address1", getShipperAddress1());
		this.hashColumns.put("consignee_name2", getConsigneeName2());
		this.hashColumns.put("reg_number2", getRegNumber2());
		this.hashColumns.put("volume", getVolume());
		this.hashColumns.put("consignee_address4", getConsigneeAddress4());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("consignee_address3", getConsigneeAddress3());
		this.hashColumns.put("consignee_name1", getConsigneeName1());
		this.hashColumns.put("consignee_address2", getConsigneeAddress2());
		this.hashColumns.put("consignee_address1", getConsigneeAddress1());
		this.hashColumns.put("total_cntr", getTotalCntr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("weight", "weight");
		this.hashFields.put("shipper_address3", "shipperAddress3");
		this.hashFields.put("shipper_address4", "shipperAddress4");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("etl_cargo_type", "etlCargoType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("notify_address1", "notifyAddress1");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("notify_address2", "notifyAddress2");
		this.hashFields.put("notify_address3", "notifyAddress3");
		this.hashFields.put("notify_address4", "notifyAddress4");
		this.hashFields.put("year", "year");
		this.hashFields.put("country_origin", "countryOrigin");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("shipper_name2", "shipperName2");
		this.hashFields.put("shipper_name1", "shipperName1");
		this.hashFields.put("notify_name1", "notifyName1");
		this.hashFields.put("notify_name2", "notifyName2");
		this.hashFields.put("shipper_address2", "shipperAddress2");
		this.hashFields.put("shipper_address1", "shipperAddress1");
		this.hashFields.put("consignee_name2", "consigneeName2");
		this.hashFields.put("reg_number2", "regNumber2");
		this.hashFields.put("volume", "volume");
		this.hashFields.put("consignee_address4", "consigneeAddress4");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("consignee_address3", "consigneeAddress3");
		this.hashFields.put("consignee_name1", "consigneeName1");
		this.hashFields.put("consignee_address2", "consigneeAddress2");
		this.hashFields.put("consignee_address1", "consigneeAddress1");
		this.hashFields.put("total_cntr", "totalCntr");
		return this.hashFields;
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
	 * @return shipperAddress3
	 */
	public String getShipperAddress3() {
		return this.shipperAddress3;
	}
	
	/**
	 * Column Info
	 * @return shipperAddress4
	 */
	public String getShipperAddress4() {
		return this.shipperAddress4;
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
	 * @return etlCargoType
	 */
	public String getEtlCargoType() {
		return this.etlCargoType;
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
	 * @return notifyAddress1
	 */
	public String getNotifyAddress1() {
		return this.notifyAddress1;
	}
	
	/**
	 * Column Info
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}
	
	/**
	 * Column Info
	 * @return notifyAddress2
	 */
	public String getNotifyAddress2() {
		return this.notifyAddress2;
	}
	
	/**
	 * Column Info
	 * @return notifyAddress3
	 */
	public String getNotifyAddress3() {
		return this.notifyAddress3;
	}
	
	/**
	 * Column Info
	 * @return notifyAddress4
	 */
	public String getNotifyAddress4() {
		return this.notifyAddress4;
	}
	
	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}
	
	/**
	 * Column Info
	 * @return countryOrigin
	 */
	public String getCountryOrigin() {
		return this.countryOrigin;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return shipperName2
	 */
	public String getShipperName2() {
		return this.shipperName2;
	}
	
	/**
	 * Column Info
	 * @return shipperName1
	 */
	public String getShipperName1() {
		return this.shipperName1;
	}
	
	/**
	 * Column Info
	 * @return notifyName1
	 */
	public String getNotifyName1() {
		return this.notifyName1;
	}
	
	/**
	 * Column Info
	 * @return notifyName2
	 */
	public String getNotifyName2() {
		return this.notifyName2;
	}
	
	/**
	 * Column Info
	 * @return shipperAddress2
	 */
	public String getShipperAddress2() {
		return this.shipperAddress2;
	}
	
	/**
	 * Column Info
	 * @return shipperAddress1
	 */
	public String getShipperAddress1() {
		return this.shipperAddress1;
	}
	
	/**
	 * Column Info
	 * @return consigneeName2
	 */
	public String getConsigneeName2() {
		return this.consigneeName2;
	}
	
	/**
	 * Column Info
	 * @return regNumber2
	 */
	public String getRegNumber2() {
		return this.regNumber2;
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
	 * @return consigneeAddress4
	 */
	public String getConsigneeAddress4() {
		return this.consigneeAddress4;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return consigneeAddress3
	 */
	public String getConsigneeAddress3() {
		return this.consigneeAddress3;
	}
	
	/**
	 * Column Info
	 * @return consigneeName1
	 */
	public String getConsigneeName1() {
		return this.consigneeName1;
	}
	
	/**
	 * Column Info
	 * @return consigneeAddress2
	 */
	public String getConsigneeAddress2() {
		return this.consigneeAddress2;
	}
	
	/**
	 * Column Info
	 * @return consigneeAddress1
	 */
	public String getConsigneeAddress1() {
		return this.consigneeAddress1;
	}
	
	/**
	 * Column Info
	 * @return totalCntr
	 */
	public String getTotalCntr() {
		return this.totalCntr;
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
	 * @param shipperAddress3
	 */
	public void setShipperAddress3(String shipperAddress3) {
		this.shipperAddress3 = shipperAddress3;
	}
	
	/**
	 * Column Info
	 * @param shipperAddress4
	 */
	public void setShipperAddress4(String shipperAddress4) {
		this.shipperAddress4 = shipperAddress4;
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
	 * @param etlCargoType
	 */
	public void setEtlCargoType(String etlCargoType) {
		this.etlCargoType = etlCargoType;
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
	 * @param notifyAddress1
	 */
	public void setNotifyAddress1(String notifyAddress1) {
		this.notifyAddress1 = notifyAddress1;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param notifyAddress2
	 */
	public void setNotifyAddress2(String notifyAddress2) {
		this.notifyAddress2 = notifyAddress2;
	}
	
	/**
	 * Column Info
	 * @param notifyAddress3
	 */
	public void setNotifyAddress3(String notifyAddress3) {
		this.notifyAddress3 = notifyAddress3;
	}
	
	/**
	 * Column Info
	 * @param notifyAddress4
	 */
	public void setNotifyAddress4(String notifyAddress4) {
		this.notifyAddress4 = notifyAddress4;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Column Info
	 * @param countryOrigin
	 */
	public void setCountryOrigin(String countryOrigin) {
		this.countryOrigin = countryOrigin;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param shipperName2
	 */
	public void setShipperName2(String shipperName2) {
		this.shipperName2 = shipperName2;
	}
	
	/**
	 * Column Info
	 * @param shipperName1
	 */
	public void setShipperName1(String shipperName1) {
		this.shipperName1 = shipperName1;
	}
	
	/**
	 * Column Info
	 * @param notifyName1
	 */
	public void setNotifyName1(String notifyName1) {
		this.notifyName1 = notifyName1;
	}
	
	/**
	 * Column Info
	 * @param notifyName2
	 */
	public void setNotifyName2(String notifyName2) {
		this.notifyName2 = notifyName2;
	}
	
	/**
	 * Column Info
	 * @param shipperAddress2
	 */
	public void setShipperAddress2(String shipperAddress2) {
		this.shipperAddress2 = shipperAddress2;
	}
	
	/**
	 * Column Info
	 * @param shipperAddress1
	 */
	public void setShipperAddress1(String shipperAddress1) {
		this.shipperAddress1 = shipperAddress1;
	}
	
	/**
	 * Column Info
	 * @param consigneeName2
	 */
	public void setConsigneeName2(String consigneeName2) {
		this.consigneeName2 = consigneeName2;
	}
	
	/**
	 * Column Info
	 * @param regNumber2
	 */
	public void setRegNumber2(String regNumber2) {
		this.regNumber2 = regNumber2;
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
	 * @param consigneeAddress4
	 */
	public void setConsigneeAddress4(String consigneeAddress4) {
		this.consigneeAddress4 = consigneeAddress4;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param consigneeAddress3
	 */
	public void setConsigneeAddress3(String consigneeAddress3) {
		this.consigneeAddress3 = consigneeAddress3;
	}
	
	/**
	 * Column Info
	 * @param consigneeName1
	 */
	public void setConsigneeName1(String consigneeName1) {
		this.consigneeName1 = consigneeName1;
	}
	
	/**
	 * Column Info
	 * @param consigneeAddress2
	 */
	public void setConsigneeAddress2(String consigneeAddress2) {
		this.consigneeAddress2 = consigneeAddress2;
	}
	
	/**
	 * Column Info
	 * @param consigneeAddress1
	 */
	public void setConsigneeAddress1(String consigneeAddress1) {
		this.consigneeAddress1 = consigneeAddress1;
	}
	
	/**
	 * Column Info
	 * @param totalCntr
	 */
	public void setTotalCntr(String totalCntr) {
		this.totalCntr = totalCntr;
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
		setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
		setShipperAddress3(JSPUtil.getParameter(request, prefix + "shipper_address3", ""));
		setShipperAddress4(JSPUtil.getParameter(request, prefix + "shipper_address4", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEtlCargoType(JSPUtil.getParameter(request, prefix + "etl_cargo_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNotifyAddress1(JSPUtil.getParameter(request, prefix + "notify_address1", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setNotifyAddress2(JSPUtil.getParameter(request, prefix + "notify_address2", ""));
		setNotifyAddress3(JSPUtil.getParameter(request, prefix + "notify_address3", ""));
		setNotifyAddress4(JSPUtil.getParameter(request, prefix + "notify_address4", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setCountryOrigin(JSPUtil.getParameter(request, prefix + "country_origin", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setShipperName2(JSPUtil.getParameter(request, prefix + "shipper_name2", ""));
		setShipperName1(JSPUtil.getParameter(request, prefix + "shipper_name1", ""));
		setNotifyName1(JSPUtil.getParameter(request, prefix + "notify_name1", ""));
		setNotifyName2(JSPUtil.getParameter(request, prefix + "notify_name2", ""));
		setShipperAddress2(JSPUtil.getParameter(request, prefix + "shipper_address2", ""));
		setShipperAddress1(JSPUtil.getParameter(request, prefix + "shipper_address1", ""));
		setConsigneeName2(JSPUtil.getParameter(request, prefix + "consignee_name2", ""));
		setRegNumber2(JSPUtil.getParameter(request, prefix + "reg_number2", ""));
		setVolume(JSPUtil.getParameter(request, prefix + "volume", ""));
		setConsigneeAddress4(JSPUtil.getParameter(request, prefix + "consignee_address4", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setConsigneeAddress3(JSPUtil.getParameter(request, prefix + "consignee_address3", ""));
		setConsigneeName1(JSPUtil.getParameter(request, prefix + "consignee_name1", ""));
		setConsigneeAddress2(JSPUtil.getParameter(request, prefix + "consignee_address2", ""));
		setConsigneeAddress1(JSPUtil.getParameter(request, prefix + "consignee_address1", ""));
		setTotalCntr(JSPUtil.getParameter(request, prefix + "total_cntr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchBlInfoVO[]
	 */
	public ManilaSearchBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchBlInfoVO[]
	 */
	public ManilaSearchBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] shipperAddress3 = (JSPUtil.getParameter(request, prefix	+ "shipper_address3", length));
			String[] shipperAddress4 = (JSPUtil.getParameter(request, prefix	+ "shipper_address4", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] etlCargoType = (JSPUtil.getParameter(request, prefix	+ "etl_cargo_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] notifyAddress1 = (JSPUtil.getParameter(request, prefix	+ "notify_address1", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] notifyAddress2 = (JSPUtil.getParameter(request, prefix	+ "notify_address2", length));
			String[] notifyAddress3 = (JSPUtil.getParameter(request, prefix	+ "notify_address3", length));
			String[] notifyAddress4 = (JSPUtil.getParameter(request, prefix	+ "notify_address4", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] countryOrigin = (JSPUtil.getParameter(request, prefix	+ "country_origin", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] shipperName2 = (JSPUtil.getParameter(request, prefix	+ "shipper_name2", length));
			String[] shipperName1 = (JSPUtil.getParameter(request, prefix	+ "shipper_name1", length));
			String[] notifyName1 = (JSPUtil.getParameter(request, prefix	+ "notify_name1", length));
			String[] notifyName2 = (JSPUtil.getParameter(request, prefix	+ "notify_name2", length));
			String[] shipperAddress2 = (JSPUtil.getParameter(request, prefix	+ "shipper_address2", length));
			String[] shipperAddress1 = (JSPUtil.getParameter(request, prefix	+ "shipper_address1", length));
			String[] consigneeName2 = (JSPUtil.getParameter(request, prefix	+ "consignee_name2", length));
			String[] regNumber2 = (JSPUtil.getParameter(request, prefix	+ "reg_number2", length));
			String[] volume = (JSPUtil.getParameter(request, prefix	+ "volume", length));
			String[] consigneeAddress4 = (JSPUtil.getParameter(request, prefix	+ "consignee_address4", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] consigneeAddress3 = (JSPUtil.getParameter(request, prefix	+ "consignee_address3", length));
			String[] consigneeName1 = (JSPUtil.getParameter(request, prefix	+ "consignee_name1", length));
			String[] consigneeAddress2 = (JSPUtil.getParameter(request, prefix	+ "consignee_address2", length));
			String[] consigneeAddress1 = (JSPUtil.getParameter(request, prefix	+ "consignee_address1", length));
			String[] totalCntr = (JSPUtil.getParameter(request, prefix	+ "total_cntr", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchBlInfoVO();
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (shipperAddress3[i] != null)
					model.setShipperAddress3(shipperAddress3[i]);
				if (shipperAddress4[i] != null)
					model.setShipperAddress4(shipperAddress4[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (etlCargoType[i] != null)
					model.setEtlCargoType(etlCargoType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (notifyAddress1[i] != null)
					model.setNotifyAddress1(notifyAddress1[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (notifyAddress2[i] != null)
					model.setNotifyAddress2(notifyAddress2[i]);
				if (notifyAddress3[i] != null)
					model.setNotifyAddress3(notifyAddress3[i]);
				if (notifyAddress4[i] != null)
					model.setNotifyAddress4(notifyAddress4[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (countryOrigin[i] != null)
					model.setCountryOrigin(countryOrigin[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (shipperName2[i] != null)
					model.setShipperName2(shipperName2[i]);
				if (shipperName1[i] != null)
					model.setShipperName1(shipperName1[i]);
				if (notifyName1[i] != null)
					model.setNotifyName1(notifyName1[i]);
				if (notifyName2[i] != null)
					model.setNotifyName2(notifyName2[i]);
				if (shipperAddress2[i] != null)
					model.setShipperAddress2(shipperAddress2[i]);
				if (shipperAddress1[i] != null)
					model.setShipperAddress1(shipperAddress1[i]);
				if (consigneeName2[i] != null)
					model.setConsigneeName2(consigneeName2[i]);
				if (regNumber2[i] != null)
					model.setRegNumber2(regNumber2[i]);
				if (volume[i] != null)
					model.setVolume(volume[i]);
				if (consigneeAddress4[i] != null)
					model.setConsigneeAddress4(consigneeAddress4[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (consigneeAddress3[i] != null)
					model.setConsigneeAddress3(consigneeAddress3[i]);
				if (consigneeName1[i] != null)
					model.setConsigneeName1(consigneeName1[i]);
				if (consigneeAddress2[i] != null)
					model.setConsigneeAddress2(consigneeAddress2[i]);
				if (consigneeAddress1[i] != null)
					model.setConsigneeAddress1(consigneeAddress1[i]);
				if (totalCntr[i] != null)
					model.setTotalCntr(totalCntr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchBlInfoVO[]
	 */
	public ManilaSearchBlInfoVO[] getManilaSearchBlInfoVOs(){
		ManilaSearchBlInfoVO[] vos = (ManilaSearchBlInfoVO[])models.toArray(new ManilaSearchBlInfoVO[models.size()]);
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
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperAddress3 = this.shipperAddress3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperAddress4 = this.shipperAddress4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etlCargoType = this.etlCargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyAddress1 = this.notifyAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyAddress2 = this.notifyAddress2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyAddress3 = this.notifyAddress3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyAddress4 = this.notifyAddress4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryOrigin = this.countryOrigin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperName2 = this.shipperName2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperName1 = this.shipperName1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyName1 = this.notifyName1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notifyName2 = this.notifyName2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperAddress2 = this.shipperAddress2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperAddress1 = this.shipperAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeName2 = this.consigneeName2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNumber2 = this.regNumber2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volume = this.volume .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeAddress4 = this.consigneeAddress4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeAddress3 = this.consigneeAddress3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeName1 = this.consigneeName1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeAddress2 = this.consigneeAddress2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeAddress1 = this.consigneeAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCntr = this.totalCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
