/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationInquiry.java
*@FileTitle : SPP TRS Equipment List Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-01-29 sunghwan cho : 요건상세화에 따른 항목추가
* 2007-03-23 sunghwan cho : EQ선택시 동일 OFC Code 체크 요건에 따른 officeCode 추가
* 2007-04-10 subghwan cho : vendorCode 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.4
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Value Object<br>
 * - SPP TRS Equipment List Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationInquiry {
	private int seq = 0;
	private String workOrderNo = "";
	private String workOrderType = "";
	private int subSeq = 0;
	private String equipmentNoType = "";
	private String equipmentNoTypeNm = "";
	private String equipmentNo = "";
	private String typeSize = "";
	private String tpszCd = "";
	private String tpszIsoCd = "";
	private String bookingNo = "";
	private String blNo = "";
	private String fromNode = "";
	private String fromNodeCd = "";
	private String viaNode = "";
	private String viaNodeCd = "";
	private String toNode = "";
	private String toNodeCd = "";
	private String doorNode = "";
	private String doorNodeCd = "";
	private String vndrSeq = "";
	private String apntDt = "";
	private String deDt = "";
	private String serviceOrderNo = "";
	private String trspBndCd	= "";
	private String invVatAmt = "";
	//Creation Detail부분
	private String workOrderCurrency = "";
	private String workOrderBasicAmount = "";
	private String workOrderSurchargeFuel = "";
	private String workOrderSurchargeVat = "";
	private String workOrderSurchargeOverweight = "";
	private String workOrderSurchargeAdditional = "";
	
	private String workOrderSurchargeNegoAmt = "";
	private String workOrderSurchargeBzcAmt = "";
	private String workOrderSurchargeEtcAddAmt = "";
	private String workOrderSurchargeTollFeeAmt = "";
	
	private String workOrderTTLAmount = "";
	private String surcharge = "";
	private String remark = "";
	//Hidden Status Flag
	private String processStatus = "";	//삭제여부
	//2007-01-29 추가
	private String invoiceBasicAmount = "";
	private String invoiceTTLAmount = "";
	private String exchangeRate = "";
	private String exchangeCalculationLogicType = "";
	//2007-03-23 추가
	private String officeCode = "";
	//2007-04-10 추가
	private String vendorCode = "";
	private String parentVendorCode = "";
	private String woCurrencyCode = "";
	//2007-10-17 by KJJ: TRS 요청으로 Cargo Full/Empty 구분 추가.
	private String cgoTpCd = "";
	private String trspSoTpCd ="";
	private String woCreDt ="";
	private String loclCopCreDt ="";
	//2015.09.02
	// Door Delivery Date 입력시 Local Cop Creation Date Validation을 위해 추가
	private String cnmvVdstsDt  = "";
	
	//2015.10.07
	// W/O Detail 에 Bid No 컬럼 추가
	private String spotBidNo = "";
	
	/**
	 * @return spot_bid_no 리턴합니다.
	 */
	public String getSpot_bid_no() {
		return spotBidNo;
	}
	/**
	 * @param spot_bid_no 설정하려는 spot_bid_no.
	 */
	public void setSpot_bid_no(String spot_bid_no) {
		this.spotBidNo = spot_bid_no;
	}
	/**
	 * @return cnmv_vdsts_dt 리턴합니다.
	 */
	public String getCnmv_vdsts_dt() {
		return cnmvVdstsDt;
	}
	/**
	 * @param cnmv_vdsts_dt 설정하려는 cnmv_vdsts_dt을.
	 */
	public void setCnmv_vdsts_dt(String cnmv_vdsts_dt) {
		this.cnmvVdstsDt = cnmv_vdsts_dt;
	}
	/**
	 * @return the workOrderSurchargeTollFeeAmt
	 */
	public String getWorkOrderSurchargeTollFeeAmt() {
		return workOrderSurchargeTollFeeAmt;
	}
	/**
	 * @param workOrderSurchargeTollFeeAmt the workOrderSurchargeTollFeeAmt to set
	 */
	public void setWorkOrderSurchargeTollFeeAmt(String workOrderSurchargeTollFeeAmt) {
		this.workOrderSurchargeTollFeeAmt = workOrderSurchargeTollFeeAmt;
	}
	public String getLocl_cop_cre_dt() {
		return loclCopCreDt;
	}
	public void setLocl_cop_cre_dt(String locl_cop_cre_dt) {
		this.loclCopCreDt = locl_cop_cre_dt;
	}
	
	public String getWo_cre_dt() {
		return woCreDt;
	}
	public void setWo_cre_dt(String wo_cre_dt) {
		this.woCreDt = wo_cre_dt;
	}
	/**
	 * 생성자
	 *
	 */
	public InvoiceCreationInquiry() {
	}
	/**
	 * 
	 * @return
	 */
	public String getWoCurrencyCode() {
		return woCurrencyCode;
	}
	/**
	 * 
	 * @param bookingNo
	 */
	public void setWoCurrencyCode(String woCurrencyCode) {
		this.woCurrencyCode = woCurrencyCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookingNo() {
		return bookingNo;
	}
	/**
	 * 
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDoorNode() {
		return doorNode;
	}
	/**
	 * 
	 * @param doorNode
	 */
	public void setDoorNode(String doorNode) {
		this.doorNode = StringEscapeUtils.escapeXml(doorNode);
	}
	/**
	 * 
	 * @return
	 */
	public String getEquipmentNo() {
		return equipmentNo;
	}
	/**
	 * 
	 * @param equipmentNo
	 */
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getFromNode() {
		return fromNode;
	}
	/**
	 * 
	 * @param fromNode
	 */
	public void setFromNode(String fromNode) {
		this.fromNode = StringEscapeUtils.escapeXml(fromNode);
	}
	/**
	 * 
	 * @return
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * 
	 * @param seq
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * 
	 * @return
	 */
	public int getSubSeq() {
		return subSeq;
	}
	/**
	 * 
	 * @param subSeq
	 */
	public void setSubSeq(int subSeq) {
		this.subSeq = subSeq;
	}
	/**
	 * 
	 * @return
	 */
	public String getToNode() {
		return toNode;
	}
	/**
	 * 
	 * @param toNode
	 */
	public void setToNode(String toNode) {
		this.toNode = StringEscapeUtils.escapeXml(toNode);
	}
	/**
	 * 
	 * @return
	 */
	public String getTypeSize() {
		return typeSize;
	}
	/**
	 * 
	 * @param typeSize
	 */
	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
	}
	/**
	 * 
	 * @return
	 */
	public String getViaNode() {
		return viaNode;
	}
	/**
	 * 
	 * @param viaNode
	 */
	public void setViaNode(String viaNode) {
		this.viaNode = StringEscapeUtils.escapeXml(viaNode);
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderNo() {
		return workOrderNo;
	}
	/**
	 * 
	 * @param workOrderNo
	 */
	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getApnt_dt() {
		return apntDt;
	}
	/**
	 * 
	 * @param apnt_dt
	 */
	public void setApnt_dt(String apnt_dt) {
		this.apntDt = apnt_dt;
	}
	/**
	 * 
	 * @return
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * 
	 * @param bl_no
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}
	/**
	 * 
	 * @return
	 */
	public String getDe_dt() {
		return deDt;
	}
	/**
	 * 
	 * @param de_dt
	 */
	public void setDe_dt(String de_dt) {
		this.deDt = de_dt;
	}
	/**
	 * 
	 * @return
	 */
	public String getDoorNode_cd() {
		return doorNodeCd;
	}
	/**
	 * 
	 * @param doorNode_cd
	 */
	public void setDoorNode_cd(String doorNode_cd) {
		this.doorNodeCd = doorNode_cd;
	}
	/**
	 * 
	 * @return
	 */
	public String getEquipmentNoType() {
		return equipmentNoType;
	}
	/**
	 * 
	 * @param equipmentNoType
	 */
	public void setEquipmentNoType(String equipmentNoType) {
		this.equipmentNoType = equipmentNoType;
	}
	/**
	 * 
	 * @return
	 */
	public String getFromNode_cd() {
		return fromNodeCd;
	}
	/**
	 * 
	 * @param fromNode_cd
	 */
	public void setFromNode_cd(String fromNode_cd) {
		this.fromNodeCd = fromNode_cd;
	}
	/**
	 * 
	 * @return
	 */
	public String getServiceOrderNo() {
		return serviceOrderNo;
	}
	/**
	 * 
	 * @param serviceNo
	 */
	public void setServiceOrderNo(String serviceNo) {
		this.serviceOrderNo = serviceNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getToNode_cd() {
		return toNodeCd;
	}
	/**
	 * 
	 * @param toNode_cd
	 */
	public void setToNode_cd(String toNode_cd) {
		this.toNodeCd = toNode_cd;
	}
	/**
	 * 
	 * @return
	 */
	public String getTpsz_cd() {
		return tpszCd;
	}
	/**
	 * 
	 * @param tpsz_cd
	 */
	public void setTpsz_cd(String tpsz_cd) {
		this.tpszCd = tpsz_cd;
	}
	

	/**
	 * 
	 * @return
	 */
	public String getTpsz_iso_cd() {
		return tpszIsoCd;
	}
	/**
	 * 
	 * @param tpsz_iso_cd
	 */
	public void setTpsz_iso_cd(String tpsz_iso_cd) {
		this.tpszIsoCd = tpsz_iso_cd;
	}
	/**
	 * 
	 * @return
	 */
	public String getViaNode_cd() {
		return viaNodeCd;
	}
	/**
	 * 
	 * @param viaNode_cd
	 */
	public void setViaNode_cd(String viaNode_cd) {
		this.viaNodeCd = viaNode_cd;
	}
	/**
	 * 
	 * @return
	 */
	public String getVndr_seq() {
		return vndrSeq;
	}
	/**
	 * 
	 * @param vndr_seq
	 */
	public void setVndr_seq(String vndr_seq) {
		this.vndrSeq = vndr_seq;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderType() {
		return workOrderType;
	}
	/**
	 * 
	 * @param workOrderType
	 */
	public void setWorkOrderType(String workOrderType) {
		this.workOrderType = workOrderType;
	}
	/**
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 
	 * @return
	 */
	public String getSurcharge() {
		return surcharge;
	}
	/**
	 * 
	 * @param surcharge
	 */
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderBasicAmount() {
		return workOrderBasicAmount;
	}
	/**
	 * 
	 * @param workOrderBasicAmount
	 */
	public void setWorkOrderBasicAmount(String workOrderBasicAmount) {
		this.workOrderBasicAmount = workOrderBasicAmount;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderCurrency() {
		return workOrderCurrency;
	}
	/**
	 * 
	 * @param workOrderCurrency
	 */
	public void setWorkOrderCurrency(String workOrderCurrency) {
		this.workOrderCurrency = workOrderCurrency;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderSurchargeAdditional() {
		return workOrderSurchargeAdditional;
	}
	/**
	 * 
	 * @param workOrderSurchargeAdditional
	 */
	public void setWorkOrderSurchargeAdditional(String workOrderSurchargeAdditional) {
		this.workOrderSurchargeAdditional = workOrderSurchargeAdditional;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderSurchargeFuel() {
		return workOrderSurchargeFuel;
	}
	/**
	 * 
	 * @param workOrderSurchargeFuel
	 */
	public void setWorkOrderSurchargeFuel(String workOrderSurchargeFuel) {
		this.workOrderSurchargeFuel = workOrderSurchargeFuel;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderSurchargeVat() {
		return workOrderSurchargeVat;
	}
	/**
	 * 
	 * @param workOrderSurchargeVat
	 */
	public void setWorkOrderSurchargeVat(String workOrderSurchargeVat) {
		this.workOrderSurchargeVat = workOrderSurchargeVat;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderSurchargeOverweight() {
		return workOrderSurchargeOverweight;
	}
	/**
	 * 
	 * @param workOrderSurchargeOverweight
	 */
	public void setWorkOrderSurchargeOverweight(String workOrderSurchargeOverweight) {
		this.workOrderSurchargeOverweight = workOrderSurchargeOverweight;
	}
	/**
	 * 
	 * @return
	 */
	public String getWorkOrderTTLAmount() {
		return workOrderTTLAmount;
	}
	/**
	 * 
	 * @param workOrderTTLAmount
	 */
	public void setWorkOrderTTLAmount(String workOrderTTLAmount) {
		this.workOrderTTLAmount = workOrderTTLAmount;
	}
	/**
	 * 
	 * @return
	 */
	public String getEquipmentNoType_nm() {
		return equipmentNoTypeNm;
	}
	/**
	 * 
	 * @param equipmentNoType_nm
	 */
	public void setEquipmentNoType_nm(String equipmentNoType_nm) {
		this.equipmentNoTypeNm = equipmentNoType_nm;
	}
	/**
	 * 
	 * @return
	 */
	public String getProcessStatus() {
		return processStatus;
	}
	/**
	 * 
	 * @param processStatus
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	/**
	 * 
	 * @return
	 */
	public String getInvoiceBasicAmount() {
		return invoiceBasicAmount;
	}
	/**
	 * 
	 * @param invoiceBasicAmount
	 */
	public void setInvoiceBasicAmount(String invoiceBasicAmount) {
		this.invoiceBasicAmount = invoiceBasicAmount;
	}
	/**
	 * 
	 * @return
	 */
	public String getInvoiceTTLAmount() {
		return invoiceTTLAmount;
	}
	/**
	 * 
	 * @param invoiceTTLAmount
	 */
	public void setInvoiceTTLAmount(String invoiceTTLAmount) {
		this.invoiceTTLAmount = invoiceTTLAmount;
	}
	/**
	 * 
	 * @return
	 */
	public String getExchangeCalculationLogicType() {
		return exchangeCalculationLogicType;
	}
	/**
	 * 
	 * @param exchangeCalculationLogicType
	 */
	public void setExchangeCalculationLogicType(String exchangeCalculationLogicType) {
		this.exchangeCalculationLogicType = exchangeCalculationLogicType;
	}
	/**
	 * 
	 * @return
	 */
	public String getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * 
	 * @param exchangeRate
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	/**
	 * 
	 * @return
	 */
	public String getOfficeCode() {
		return officeCode;
	}
	/**
	 * 
	 * @param officeCode
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getParentVendorCode() {
		return parentVendorCode;
	}
	/**
	 * 
	 * @param parentVendorCode
	 */
	public void setParentVendorCode(String parentVendorCode) {
		this.parentVendorCode = parentVendorCode;
	}
	/**
	 * 
	 * @return
	 */
	public String getVendorCode() {
		return vendorCode;
	}
	/**
	 * 
	 * @param vendorCode
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	
	
	/**
	 * 
	 * @param trsp_bnd_cd
	 */
	public void setTrsp_bnd_cd(String trsp_bnd_cd) {
		this.trspBndCd = trsp_bnd_cd;
	}
	
		/**
	 * 
	 * @param trspBndCd
	 */
	public String getTrsp_bnd_cd() {
		return trspBndCd;
	}
	
	/**
	 * 
	 * @return cgoTpCd
	 */
	public String getCgo_tp_cd() {
		return cgoTpCd;
	}
	
	/**
	 * 
	 * @param cgo_tp_cd
	 */
	public void setCgo_tp_cd(String cgo_tp_cd) {
		this.cgoTpCd = cgo_tp_cd;
	}
	/**
	 * 
	 * @return trspSoTpCd
	 */
	public String getTrsp_so_tp_cd() {
		return trspSoTpCd;
	}
	
	/**
	 * 
	 * @param cgoTpCd
	 */
	public void setTrsp_so_tp_cd(String trsp_so_tp_cd) {
		this.trspSoTpCd = trsp_so_tp_cd;
	}
	
	/**
	 * @return Returns the workOrderSurchargeBzcAmt.
	 */
	public String getWorkOrderSurchargeBzcAmt() {
		return workOrderSurchargeBzcAmt;
	}
	/**
	 * @param workOrderSurchargeBzcAmt The workOrderSurchargeBzcAmt to set.
	 */
	public void setWorkOrderSurchargeBzcAmt(String workOrderSurchargeBzcAmt) {
		this.workOrderSurchargeBzcAmt = workOrderSurchargeBzcAmt;
	}
	/**
	 * @return Returns the workOrderSurchargeNegoAmt.
	 */
	public String getWorkOrderSurchargeNegoAmt() {
		return workOrderSurchargeNegoAmt;
	}
	/**
	 * @param workOrderSurchargeNegoAmt The workOrderSurchargeNegoAmt to set.
	 */
	public void setWorkOrderSurchargeNegoAmt(String workOrderSurchargeNegoAmt) {
		this.workOrderSurchargeNegoAmt = workOrderSurchargeNegoAmt;
	}
	/**
	 * @return Returns the workOrderSurchargeEtcAddAmt.
	 */
	public String getWorkOrderSurchargeEtcAddAmt() {
		return workOrderSurchargeEtcAddAmt;
	}
	/**
	 * @param workOrderSurchargeEtcAddAmt The workOrderSurchargeEtcAddAmt to set.
	 */
	public void setWorkOrderSurchargeEtcAddAmt(String workOrderSurchargeEtcAddAmt) {
		this.workOrderSurchargeEtcAddAmt = workOrderSurchargeEtcAddAmt;
	}
	/**
	 * @return Returns the inv_vat_amt.
	 */
	public String getInv_vat_amt() {
		return invVatAmt;
	}
	/**
	 * @param inv_vat_amt The inv_vat_amt to set.
	 */
	public void setInv_vat_amt(String inv_vat_amt) {
		this.invVatAmt = inv_vat_amt;
	}

	
	
	
}