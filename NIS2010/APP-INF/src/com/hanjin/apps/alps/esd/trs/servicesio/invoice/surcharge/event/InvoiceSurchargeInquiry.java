/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceSurchargeInquiry.java
*@FileTitle : SPP TRS Invoice Surcharge Value Object 
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : vendorCode 추가
* 2007-04-10 subghwan cho : parentVendorCode 추가
*@LastModifyDate : 2007-04-10
*@LastModifier : sunghwan cho
*@LastVersion : 1.2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event;

/**
 * Value Object<br>
 * - SPP TRS Invoice Surcharge Value Object <br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceSurchargeInquiry {
	private String additionalLabor = "";
	private String bargeLowWater = "";
	private String chassisUsage = "";
	private String chassisType = "";
	private String dropPull = "";
	private String dryRun = "";
	private String realiableParty = "";
	private String ferryCost = "";
	private String fine = "";
	private String cause = "";
	private String fumigation = "";
	private String cost = "";
	private String genSetUsage = "";
	private String genSetType = "";
	private String hazmat = "";
	private String inspection = "";
	private String inspectionType = "";
	private String liftingCharge = "";
	private String numberOfLifting = "";
	private String liftingCause = "";
	private String multipleDelivery = "";
	private String stopLocation = "";
	private String overSize = "";
	private String overWeight = "";
	private String grossWeight = "";
	private String prePull = "";
	private String incurredDate = "";
	private String redirectionCharge = "";
	private String scaleStop = "";
	private String scaleStopPlace = "";
	private String storage = "";
	private String storageDays = "";
	private String streetTurn = "";
	private String outboundBookingNo = "";
	private String sundayRunning = "";
	private String swingFlip = "";
	private String tDOCFee = "";
	private String toil = "";
	private String waitingCharges = "";
	private String waitingHour = "";
	private String other = "";
	private String remark = "";
	private String surchargeTotalAmount = "";
	//2007-01-11 추가:조성환  
	private String bookingNo = "";
	private String serviceNo = "";
	private String workOrderNo = "";
	private String invoiceNo = "";
	private String equipmentNo = "";
	//2007-04-10 추가:조성환
	private String vendorCode = "";
	private String parentVendorCode = "";
	//2007-10-17 추가 by KJJ
	private String cgoTpCd = "";
	private String chassisDrayage = "";
	private String chassisDrayageType = "";
	private String chassisNo = "";
	private String incurredDt = "";
		
	public String getCgo_tp_cd() {
		return cgoTpCd;
	}
	public void setCgo_tp_cd(String cgo_tp_cd) {
		this.cgoTpCd = cgo_tp_cd;
	}
	/**
	 * 
	 * @return
	 */
	public String getAdditionalLabor() {
		return additionalLabor;
	}
	/**
	 * 
	 * @param additionalLabor
	 */
	public void setAdditionalLabor(String additionalLabor) {
		this.additionalLabor = additionalLabor;
	}
	/**
	 * 
	 * @return
	 */
	public String getBargeLowWater() {
		return bargeLowWater;
	}
	/**
	 * 
	 * @param bargeLowWater
	 */
	public void setBargeLowWater(String bargeLowWater) {
		this.bargeLowWater = bargeLowWater;
	}
	/**
	 * 
	 * @return
	 */
	public String getCause() {
		return cause;
	}
	/**
	 * 
	 * @param cause
	 */
	public void setCause(String cause) {
		this.cause = cause;
	}
	/**
	 * 
	 * @return
	 */
	public String getChassisType() {
		return chassisType;
	}
	/**
	 * 
	 * @param chassisType
	 */
	public void setChassisType(String chassisType) {
		this.chassisType = chassisType;
	}
	/**
	 * 
	 * @return
	 */
	public String getChassisUsage() {
		return chassisUsage;
	}
	/**
	 * 
	 * @param chassisUsage
	 */
	public void setChassisUsage(String chassisUsage) {
		this.chassisUsage = chassisUsage;
	}
	/**
	 * 
	 * @return
	 */
	public String getCost() {
		return cost;
	}
	/**
	 * 
	 * @param cost
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	/**
	 * 
	 * @return
	 */
	public String getDrop_Pull() {
		return dropPull;
	}
	/**
	 * 
	 * @param drop_Pull
	 */
	public void setDrop_Pull(String drop_Pull) {
		this.dropPull = drop_Pull;
	}
	/**
	 * 
	 * @return
	 */
	public String getDryRun() {
		return dryRun;
	}
	/**
	 * 
	 * @param dryRun
	 */
	public void setDryRun(String dryRun) {
		this.dryRun = dryRun;
	}
	/**
	 * 
	 * @return
	 */
	public String getFerryCost() {
		return ferryCost;
	}
	/**
	 * 
	 * @param ferryCost
	 */
	public void setFerryCost(String ferryCost) {
		this.ferryCost = ferryCost;
	}
	/**
	 * 
	 * @return
	 */
	public String getFine() {
		return fine;
	}
	/**
	 * 
	 * @param fine
	 */
	public void setFine(String fine) {
		this.fine = fine;
	}
	/**
	 * 
	 * @return
	 */
	public String getFumigation() {
		return fumigation;
	}
	/**
	 * 
	 * @param fumigation
	 */
	public void setFumigation(String fumigation) {
		this.fumigation = fumigation;
	}
	/**
	 * 
	 * @return
	 */
	public String getGenSetType() {
		return genSetType;
	}
	/**
	 * 
	 * @param genSetType
	 */
	public void setGenSetType(String genSetType) {
		this.genSetType = genSetType;
	}
	/**
	 * 
	 * @return
	 */
	public String getGenSetUsage() {
		return genSetUsage;
	}
	/**
	 * 
	 * @param genSetUsage
	 */
	public void setGenSetUsage(String genSetUsage) {
		this.genSetUsage = genSetUsage;
	}
	/**
	 * 
	 * @return
	 */
	public String getGrossWeight() {
		return grossWeight;
	}
	/**
	 * 
	 * @param grossWeight
	 */
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	/**
	 * 
	 * @return
	 */
	public String getHazmat() {
		return hazmat;
	}
	/**
	 * 
	 * @param hazmat
	 */
	public void setHazmat(String hazmat) {
		this.hazmat = hazmat;
	}
	/**
	 * 
	 * @return
	 */
	public String getIncurredDate() {
		return incurredDate;
	}
	/**
	 * 
	 * @param incurredDate
	 */
	public void setIncurredDate(String incurredDate) {
		this.incurredDate = incurredDate;
	}
	/**
	 * 
	 * @return
	 */
	public String getInspection() {
		return inspection;
	}
	/**
	 * 
	 * @param inspection
	 */
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	/**
	 * 
	 * @return
	 */
	public String getInspectionType() {
		return inspectionType;
	}
	/**
	 * 
	 * @param inspectionType
	 */
	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}
	/**
	 * 
	 * @return
	 */
	public String getLiftingCause() {
		return liftingCause;
	}
	/**
	 * 
	 * @param liftingCause
	 */
	public void setLiftingCause(String liftingCause) {
		this.liftingCause = liftingCause;
	}
	/**
	 * 
	 * @return
	 */
	public String getLiftingCharge() {
		return liftingCharge;
	}
	/**
	 * 
	 * @param liftingCharge
	 */
	public void setLiftingCharge(String liftingCharge) {
		this.liftingCharge = liftingCharge;
	}
	/**
	 * 
	 * @return
	 */
	public String getMultipleDelivery() {
		return multipleDelivery;
	}
	/**
	 * 
	 * @param multipleDelivery
	 */
	public void setMultipleDelivery(String multipleDelivery) {
		this.multipleDelivery = multipleDelivery;
	}
	/**
	 * 
	 * @return
	 */
	public String getNumberOfLifting() {
		return numberOfLifting;
	}
	/**
	 * 
	 * @param numberOfLifting
	 */
	public void setNumberOfLifting(String numberOfLifting) {
		this.numberOfLifting = numberOfLifting;
	}
	/**
	 * 
	 * @return
	 */
	public String getOther() {
		return other;
	}
	/**
	 * 
	 * @param other
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * 
	 * @return
	 */
	public String getOutboundBookingNo() {
		return outboundBookingNo;
	}
	/**
	 * 
	 * @param outboundBookingNo
	 */
	public void setOutboundBookingNo(String outboundBookingNo) {
		this.outboundBookingNo = outboundBookingNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getOverSize() {
		return overSize;
	}
	/**
	 * 
	 * @param overSize
	 */
	public void setOverSize(String overSize) {
		this.overSize = overSize;
	}
	/**
	 * 
	 * @return
	 */
	public String getOverWeight() {
		return overWeight;
	}
	/**
	 * 
	 * @param overWeight
	 */
	public void setOverWeight(String overWeight) {
		this.overWeight = overWeight;
	}
	/**
	 * 
	 * @return
	 */
	public String getPrePull() {
		return prePull;
	}
	/**
	 * 
	 * @param prePull
	 */
	public void setPrePull(String prePull) {
		this.prePull = prePull;
	}
	/**
	 * 
	 * @return
	 */
	public String getRealiableParty() {
		return realiableParty;
	}
	/**
	 * 
	 * @param realiableParty
	 */
	public void setRealiableParty(String realiableParty) {
		this.realiableParty = realiableParty;
	}
	/**
	 * 
	 * @return
	 */
	public String getRedirectionCharge() {
		return redirectionCharge;
	}
	/**
	 * 
	 * @param redirectionCharge
	 */
	public void setRedirectionCharge(String redirectionCharge) {
		this.redirectionCharge = redirectionCharge;
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
	public String getScaleStop() {
		return scaleStop;
	}
	/**
	 * 
	 * @param scaleStop
	 */
	public void setScaleStop(String scaleStop) {
		this.scaleStop = scaleStop;
	}
	/**
	 * 
	 * @return
	 */
	public String getScaleStopPlace() {
		return scaleStopPlace;
	}
	/**
	 * 
	 * @param scaleStopPlace
	 */
	public void setScaleStopPlace(String scaleStopPlace) {
		this.scaleStopPlace = scaleStopPlace;
	}
	/**
	 * 
	 * @return
	 */
	public String getStopLocation() {
		return stopLocation;
	}
	/**
	 * 
	 * @param stopLocation
	 */
	public void setStopLocation(String stopLocation) {
		this.stopLocation = stopLocation;
	}
	/**
	 * 
	 * @return
	 */
	public String getStorage() {
		return storage;
	}
	/**
	 * 
	 * @param storage
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}
	/**
	 * 
	 * @return
	 */
	public String getStorageDays() {
		return storageDays;
	}
	/**
	 * 
	 * @param storageDays
	 */
	public void setStorageDays(String storageDays) {
		this.storageDays = storageDays;
	}
	/**
	 * 
	 * @return
	 */
	public String getStreetTurn() {
		return streetTurn;
	}
	/**
	 * 
	 * @param streetTurn
	 */
	public void setStreetTurn(String streetTurn) {
		this.streetTurn = streetTurn;
	}
	/**
	 * 
	 * @return
	 */
	public String getSundayRunning() {
		return sundayRunning;
	}
	/**
	 * 
	 * @param sundayRunning
	 */
	public void setSundayRunning(String sundayRunning) {
		this.sundayRunning = sundayRunning;
	}
	/**
	 * 
	 * @return
	 */
	public String getSurchargeTotalAmount() {
		return surchargeTotalAmount;
	}
	/**
	 * 
	 * @param surchargeTotalAmount
	 */
	public void setSurchargeTotalAmount(String surchargeTotalAmount) {
		this.surchargeTotalAmount = surchargeTotalAmount;
	}
	/**
	 * 
	 * @return
	 */
	public String getSwing_flip() {
		return swingFlip;
	}
	/**
	 * 
	 * @param swing_flip
	 */
	public void setSwing_flip(String swing_flip) {
		this.swingFlip = swing_flip;
	}
	/**
	 * 
	 * @return
	 */
	public String getTDOCFee() {
		return tDOCFee;
	}
	/**
	 * 
	 * @param fee
	 */
	public void setTDOCFee(String fee) {
		tDOCFee = fee;
	}
	/**
	 * 
	 * @return
	 */
	public String getToil() {
		return toil;
	}
	/**
	 * 
	 * @param toil
	 */
	public void setToil(String toil) {
		this.toil = toil;
	}
	/**
	 * 
	 * @return
	 */
	public String getWaitingCharges() {
		return waitingCharges;
	}
	/**
	 * 
	 * @param waitingCharges
	 */
	public void setWaitingCharges(String waitingCharges) {
		this.waitingCharges = waitingCharges;
	}
	/**
	 * 
	 * @return
	 */
	public String getWaitingHour() {
		return waitingHour;
	}
	/**
	 * 
	 * @param waitingHour
	 */
	public void setWaitingHour(String waitingHour) {
		this.waitingHour = waitingHour;
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
	public String getServiceNo() {
		return serviceNo;
	}
	/**
	 * 
	 * @param serviceNo
	 */
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
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
	public String getInvoiceNo() {
		return invoiceNo;
	}
	/**
	 * 
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	 * @return
	 */
	public String getChassisDrayageType() {
		return chassisDrayageType;
	}
	/**
	 * 
	 * @param chassisType
	 */
	public void setChassisDrayageType(String chassisDrayageType) {
		this.chassisDrayageType = chassisDrayageType;
	}
	/**
	 * 
	 * @return
	 */
	public String getChassisDrayage() {
		return chassisDrayage;
	}
	/**
	 * 
	 * @param chassisUsage
	 */
	public void setChassisDrayage(String chassisDrayage) {
		this.chassisDrayage = chassisDrayage;
	}
	/**
	 * 
	 * @return
	 */
	public String getChssNo() {
		return chassisNo;
	}
	/**
	 * 
	 * @param IncurredDt
	 */
	public void setChssNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	/**
	 * 
	 * @return
	 */
	public String getIncurDt() {
		return incurredDt;
	}
	/**
	 * 
	 * @param incurredDt
	 */
	public void setIncurDt(String incurredDt) {
		this.incurredDt = incurredDt;
	}

	
}