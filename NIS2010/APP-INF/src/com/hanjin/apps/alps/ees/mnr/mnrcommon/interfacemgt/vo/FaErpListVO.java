/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FaErpListVO.java
*@FileTitle : FaErpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.08
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.08 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
	
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FaErpListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FaErpListVO> models = new ArrayList<FaErpListVO>();
	
	/* Column Info */
	private String assignedTo = null;
	/* Column Info */
	private String transactionDateEntered = null;
	/* Column Info */
	private String invoiceNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String distributionId = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String objectVersionNumber = null;
	/* Column Info */
	private String periodOfAddition = null;
	/* Column Info */
	private String costRetired = null;
	/* Column Info */
	private String interfaceFlag = null;
	/* Column Info */
	private String soldTo = null;
	/* Column Info */
	private String expenseCcid = null;
	/* Column Info */
	private String lclAmt = null;
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String locationCcid = null;
	/* Column Info */
	private String retirementId = null;
	/* Column Info */
	private String errorDescription = null;
	/* Column Info */
	private String transactionTypeCode = null;
	/* Column Info */
	private String calculateGainLoss = null;
	/* Column Info */
	private String attribute4 = null;
	/* Column Info */
	private String attribute5 = null;
	/* Column Info */
	private String attribute6 = null;
	/* Column Info */
	private String queueStatus = null;
	/* Column Info */
	private String attribute7 = null;
	/* Column Info */
	private String createdBy = null;
	/* Column Info */
	private String attribute8 = null;
	/* Column Info */
	private String attribute9 = null;
	/* Column Info */
	private String lastUpdateLogin = null;
	/* Column Info */
	private String tagNumber = null;
	/* Column Info */
	private String attribute10 = null;
	/* Column Info */
	private String attribute1 = null;
	/* Column Info */
	private String attribute2 = null;
	/* Column Info */
	private String attribute3 = null;
	/* Column Info */
	private String retirementTypeCode = null;
	/* Column Info */
	private String unitsAssigned = null;
	/* Column Info */
	private String proceedsOfSale = null;
	/* Column Info */
	private String costOfRemoval = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String assetId = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String tradeInAssetId = null;
	/* Column Info */
	private String transactionUnits = null;
	/* Column Info */
	private String lclCurr = null;
	/* Column Info */
	private String lastUpdateDate = null;
	/* Column Info */
	private String creationDate = null;
	/* Column Info */
	private String retirementProrateConvention = null;
	/* Column Info */
	private String lastUpdatedBy = null;
	/* Column Info */
	private String dateRetired = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String bookTypeCode = null;
	/* Column Info */
	private String unitsRetired = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FaErpListVO() {}

	public FaErpListVO(String ibflag, String pagerows, String assignedTo, String transactionDateEntered, String invoiceNo, String distributionId, String rnum, String objectVersionNumber, String periodOfAddition, String costRetired, String interfaceFlag, String soldTo, String expenseCcid, String lifid, String retirementId, String locationCcid, String errorDescription, String transactionTypeCode, String calculateGainLoss, String attribute4, String attribute5, String queueStatus, String attribute6, String attribute7, String createdBy, String attribute8, String attribute9, String lastUpdateLogin, String tagNumber, String attribute10, String attribute1, String attribute2, String attribute3, String retirementTypeCode, String unitsAssigned, String proceedsOfSale, String costOfRemoval, String assetId, String totalCount, String tradeInAssetId, String transactionUnits, String lastUpdateDate, String creationDate, String retirementProrateConvention, String lastUpdatedBy, String dateRetired, String seq, String bookTypeCode, String unitsRetired, String lclAmt, String lclCurr) {
		this.assignedTo = assignedTo;
		this.transactionDateEntered = transactionDateEntered;
		this.invoiceNo = invoiceNo;
		this.pagerows = pagerows;
		this.distributionId = distributionId;
		this.rnum = rnum;
		this.objectVersionNumber = objectVersionNumber;
		this.periodOfAddition = periodOfAddition;
		this.costRetired = costRetired;
		this.interfaceFlag = interfaceFlag;
		this.soldTo = soldTo;
		this.expenseCcid = expenseCcid;
		this.lclAmt = lclAmt;
		this.lifid = lifid;
		this.locationCcid = locationCcid;
		this.retirementId = retirementId;
		this.errorDescription = errorDescription;
		this.transactionTypeCode = transactionTypeCode;
		this.calculateGainLoss = calculateGainLoss;
		this.attribute4 = attribute4;
		this.attribute5 = attribute5;
		this.attribute6 = attribute6;
		this.queueStatus = queueStatus;
		this.attribute7 = attribute7;
		this.createdBy = createdBy;
		this.attribute8 = attribute8;
		this.attribute9 = attribute9;
		this.lastUpdateLogin = lastUpdateLogin;
		this.tagNumber = tagNumber;
		this.attribute10 = attribute10;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.retirementTypeCode = retirementTypeCode;
		this.unitsAssigned = unitsAssigned;
		this.proceedsOfSale = proceedsOfSale;
		this.costOfRemoval = costOfRemoval;
		this.ibflag = ibflag;
		this.assetId = assetId;
		this.totalCount = totalCount;
		this.tradeInAssetId = tradeInAssetId;
		this.transactionUnits = transactionUnits;
		this.lclCurr = lclCurr;
		this.lastUpdateDate = lastUpdateDate;
		this.creationDate = creationDate;
		this.retirementProrateConvention = retirementProrateConvention;
		this.lastUpdatedBy = lastUpdatedBy;
		this.dateRetired = dateRetired;
		this.seq = seq;
		this.bookTypeCode = bookTypeCode;
		this.unitsRetired = unitsRetired;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("assigned_to", getAssignedTo());
		this.hashColumns.put("transaction_date_entered", getTransactionDateEntered());
		this.hashColumns.put("invoice_no", getInvoiceNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("distribution_id", getDistributionId());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("object_version_number", getObjectVersionNumber());
		this.hashColumns.put("period_of_addition", getPeriodOfAddition());
		this.hashColumns.put("cost_retired", getCostRetired());
		this.hashColumns.put("interface_flag", getInterfaceFlag());
		this.hashColumns.put("sold_to", getSoldTo());
		this.hashColumns.put("expense_ccid", getExpenseCcid());
		this.hashColumns.put("lcl_amt", getLclAmt());
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("location_ccid", getLocationCcid());
		this.hashColumns.put("retirement_id", getRetirementId());
		this.hashColumns.put("error_description", getErrorDescription());
		this.hashColumns.put("transaction_type_code", getTransactionTypeCode());
		this.hashColumns.put("calculate_gain_loss", getCalculateGainLoss());
		this.hashColumns.put("attribute4", getAttribute4());
		this.hashColumns.put("attribute5", getAttribute5());
		this.hashColumns.put("attribute6", getAttribute6());
		this.hashColumns.put("queue_status", getQueueStatus());
		this.hashColumns.put("attribute7", getAttribute7());
		this.hashColumns.put("created_by", getCreatedBy());
		this.hashColumns.put("attribute8", getAttribute8());
		this.hashColumns.put("attribute9", getAttribute9());
		this.hashColumns.put("last_update_login", getLastUpdateLogin());
		this.hashColumns.put("tag_number", getTagNumber());
		this.hashColumns.put("attribute10", getAttribute10());
		this.hashColumns.put("attribute1", getAttribute1());
		this.hashColumns.put("attribute2", getAttribute2());
		this.hashColumns.put("attribute3", getAttribute3());
		this.hashColumns.put("retirement_type_code", getRetirementTypeCode());
		this.hashColumns.put("units_assigned", getUnitsAssigned());
		this.hashColumns.put("proceeds_of_sale", getProceedsOfSale());
		this.hashColumns.put("cost_of_removal", getCostOfRemoval());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("asset_id", getAssetId());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("trade_in_asset_id", getTradeInAssetId());
		this.hashColumns.put("transaction_units", getTransactionUnits());
		this.hashColumns.put("lcl_curr", getLclCurr());
		this.hashColumns.put("last_update_date", getLastUpdateDate());
		this.hashColumns.put("creation_date", getCreationDate());
		this.hashColumns.put("retirement_prorate_convention", getRetirementProrateConvention());
		this.hashColumns.put("last_updated_by", getLastUpdatedBy());
		this.hashColumns.put("date_retired", getDateRetired());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("book_type_code", getBookTypeCode());
		this.hashColumns.put("units_retired", getUnitsRetired());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("assigned_to", "assignedTo");
		this.hashFields.put("transaction_date_entered", "transactionDateEntered");
		this.hashFields.put("invoice_no", "invoiceNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("distribution_id", "distributionId");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("object_version_number", "objectVersionNumber");
		this.hashFields.put("period_of_addition", "periodOfAddition");
		this.hashFields.put("cost_retired", "costRetired");
		this.hashFields.put("interface_flag", "interfaceFlag");
		this.hashFields.put("sold_to", "soldTo");
		this.hashFields.put("expense_ccid", "expenseCcid");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("location_ccid", "locationCcid");
		this.hashFields.put("retirement_id", "retirementId");
		this.hashFields.put("error_description", "errorDescription");
		this.hashFields.put("transaction_type_code", "transactionTypeCode");
		this.hashFields.put("calculate_gain_loss", "calculateGainLoss");
		this.hashFields.put("attribute4", "attribute4");
		this.hashFields.put("attribute5", "attribute5");
		this.hashFields.put("attribute6", "attribute6");
		this.hashFields.put("queue_status", "queueStatus");
		this.hashFields.put("attribute7", "attribute7");
		this.hashFields.put("created_by", "createdBy");
		this.hashFields.put("attribute8", "attribute8");
		this.hashFields.put("attribute9", "attribute9");
		this.hashFields.put("last_update_login", "lastUpdateLogin");
		this.hashFields.put("tag_number", "tagNumber");
		this.hashFields.put("attribute10", "attribute10");
		this.hashFields.put("attribute1", "attribute1");
		this.hashFields.put("attribute2", "attribute2");
		this.hashFields.put("attribute3", "attribute3");
		this.hashFields.put("retirement_type_code", "retirementTypeCode");
		this.hashFields.put("units_assigned", "unitsAssigned");
		this.hashFields.put("proceeds_of_sale", "proceedsOfSale");
		this.hashFields.put("cost_of_removal", "costOfRemoval");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("asset_id", "assetId");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("trade_in_asset_id", "tradeInAssetId");
		this.hashFields.put("transaction_units", "transactionUnits");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("last_update_date", "lastUpdateDate");
		this.hashFields.put("creation_date", "creationDate");
		this.hashFields.put("retirement_prorate_convention", "retirementProrateConvention");
		this.hashFields.put("last_updated_by", "lastUpdatedBy");
		this.hashFields.put("date_retired", "dateRetired");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("book_type_code", "bookTypeCode");
		this.hashFields.put("units_retired", "unitsRetired");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return assignedTo
	 */
	public String getAssignedTo() {
		return this.assignedTo;
	}
	
	/**
	 * Column Info
	 * @return transactionDateEntered
	 */
	public String getTransactionDateEntered() {
		return this.transactionDateEntered;
	}
	
	/**
	 * Column Info
	 * @return invoiceNo
	 */
	public String getInvoiceNo() {
		return this.invoiceNo;
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
	 * @return distributionId
	 */
	public String getDistributionId() {
		return this.distributionId;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return objectVersionNumber
	 */
	public String getObjectVersionNumber() {
		return this.objectVersionNumber;
	}
	
	/**
	 * Column Info
	 * @return periodOfAddition
	 */
	public String getPeriodOfAddition() {
		return this.periodOfAddition;
	}
	
	/**
	 * Column Info
	 * @return costRetired
	 */
	public String getCostRetired() {
		return this.costRetired;
	}
	
	/**
	 * Column Info
	 * @return interfaceFlag
	 */
	public String getInterfaceFlag() {
		return this.interfaceFlag;
	}
	
	/**
	 * Column Info
	 * @return soldTo
	 */
	public String getSoldTo() {
		return this.soldTo;
	}
	
	/**
	 * Column Info
	 * @return expenseCcid
	 */
	public String getExpenseCcid() {
		return this.expenseCcid;
	}
	
	/**
	 * Column Info
	 * @return lclAmt
	 */
	public String getLclAmt() {
		return this.lclAmt;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return locationCcid
	 */
	public String getLocationCcid() {
		return this.locationCcid;
	}
	
	/**
	 * Column Info
	 * @return retirementId
	 */
	public String getRetirementId() {
		return this.retirementId;
	}
	
	/**
	 * Column Info
	 * @return errorDescription
	 */
	public String getErrorDescription() {
		return this.errorDescription;
	}
	
	/**
	 * Column Info
	 * @return transactionTypeCode
	 */
	public String getTransactionTypeCode() {
		return this.transactionTypeCode;
	}
	
	/**
	 * Column Info
	 * @return calculateGainLoss
	 */
	public String getCalculateGainLoss() {
		return this.calculateGainLoss;
	}
	
	/**
	 * Column Info
	 * @return attribute4
	 */
	public String getAttribute4() {
		return this.attribute4;
	}
	
	/**
	 * Column Info
	 * @return attribute5
	 */
	public String getAttribute5() {
		return this.attribute5;
	}
	
	/**
	 * Column Info
	 * @return attribute6
	 */
	public String getAttribute6() {
		return this.attribute6;
	}
	
	/**
	 * Column Info
	 * @return queueStatus
	 */
	public String getQueueStatus() {
		return this.queueStatus;
	}
	
	/**
	 * Column Info
	 * @return attribute7
	 */
	public String getAttribute7() {
		return this.attribute7;
	}
	
	/**
	 * Column Info
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	/**
	 * Column Info
	 * @return attribute8
	 */
	public String getAttribute8() {
		return this.attribute8;
	}
	
	/**
	 * Column Info
	 * @return attribute9
	 */
	public String getAttribute9() {
		return this.attribute9;
	}
	
	/**
	 * Column Info
	 * @return lastUpdateLogin
	 */
	public String getLastUpdateLogin() {
		return this.lastUpdateLogin;
	}
	
	/**
	 * Column Info
	 * @return tagNumber
	 */
	public String getTagNumber() {
		return this.tagNumber;
	}
	
	/**
	 * Column Info
	 * @return attribute10
	 */
	public String getAttribute10() {
		return this.attribute10;
	}
	
	/**
	 * Column Info
	 * @return attribute1
	 */
	public String getAttribute1() {
		return this.attribute1;
	}
	
	/**
	 * Column Info
	 * @return attribute2
	 */
	public String getAttribute2() {
		return this.attribute2;
	}
	
	/**
	 * Column Info
	 * @return attribute3
	 */
	public String getAttribute3() {
		return this.attribute3;
	}
	
	/**
	 * Column Info
	 * @return retirementTypeCode
	 */
	public String getRetirementTypeCode() {
		return this.retirementTypeCode;
	}
	
	/**
	 * Column Info
	 * @return unitsAssigned
	 */
	public String getUnitsAssigned() {
		return this.unitsAssigned;
	}
	
	/**
	 * Column Info
	 * @return proceedsOfSale
	 */
	public String getProceedsOfSale() {
		return this.proceedsOfSale;
	}
	
	/**
	 * Column Info
	 * @return costOfRemoval
	 */
	public String getCostOfRemoval() {
		return this.costOfRemoval;
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
	 * @return assetId
	 */
	public String getAssetId() {
		return this.assetId;
	}
	
	/**
	 * Column Info
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return tradeInAssetId
	 */
	public String getTradeInAssetId() {
		return this.tradeInAssetId;
	}
	
	/**
	 * Column Info
	 * @return transactionUnits
	 */
	public String getTransactionUnits() {
		return this.transactionUnits;
	}
	
	/**
	 * Column Info
	 * @return lclCurr
	 */
	public String getLclCurr() {
		return this.lclCurr;
	}
	
	/**
	 * Column Info
	 * @return lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return this.lastUpdateDate;
	}
	
	/**
	 * Column Info
	 * @return creationDate
	 */
	public String getCreationDate() {
		return this.creationDate;
	}
	
	/**
	 * Column Info
	 * @return retirementProrateConvention
	 */
	public String getRetirementProrateConvention() {
		return this.retirementProrateConvention;
	}
	
	/**
	 * Column Info
	 * @return lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}
	
	/**
	 * Column Info
	 * @return dateRetired
	 */
	public String getDateRetired() {
		return this.dateRetired;
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
	 * @return bookTypeCode
	 */
	public String getBookTypeCode() {
		return this.bookTypeCode;
	}
	
	/**
	 * Column Info
	 * @return unitsRetired
	 */
	public String getUnitsRetired() {
		return this.unitsRetired;
	}
	

	/**
	 * Column Info
	 * @param assignedTo
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	/**
	 * Column Info
	 * @param transactionDateEntered
	 */
	public void setTransactionDateEntered(String transactionDateEntered) {
		this.transactionDateEntered = transactionDateEntered;
	}
	
	/**
	 * Column Info
	 * @param invoiceNo
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	 * @param distributionId
	 */
	public void setDistributionId(String distributionId) {
		this.distributionId = distributionId;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param objectVersionNumber
	 */
	public void setObjectVersionNumber(String objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}
	
	/**
	 * Column Info
	 * @param periodOfAddition
	 */
	public void setPeriodOfAddition(String periodOfAddition) {
		this.periodOfAddition = periodOfAddition;
	}
	
	/**
	 * Column Info
	 * @param costRetired
	 */
	public void setCostRetired(String costRetired) {
		this.costRetired = costRetired;
	}
	
	/**
	 * Column Info
	 * @param interfaceFlag
	 */
	public void setInterfaceFlag(String interfaceFlag) {
		this.interfaceFlag = interfaceFlag;
	}
	
	/**
	 * Column Info
	 * @param soldTo
	 */
	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}
	
	/**
	 * Column Info
	 * @param expenseCcid
	 */
	public void setExpenseCcid(String expenseCcid) {
		this.expenseCcid = expenseCcid;
	}
	
	/**
	 * Column Info
	 * @param lclAmt
	 */
	public void setLclAmt(String lclAmt) {
		this.lclAmt = lclAmt;
	}
	
	/**
	 * Column Info
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param locationCcid
	 */
	public void setLocationCcid(String locationCcid) {
		this.locationCcid = locationCcid;
	}
	
	/**
	 * Column Info
	 * @param retirementId
	 */
	public void setRetirementId(String retirementId) {
		this.retirementId = retirementId;
	}
	
	/**
	 * Column Info
	 * @param errorDescription
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	/**
	 * Column Info
	 * @param transactionTypeCode
	 */
	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}
	
	/**
	 * Column Info
	 * @param calculateGainLoss
	 */
	public void setCalculateGainLoss(String calculateGainLoss) {
		this.calculateGainLoss = calculateGainLoss;
	}
	
	/**
	 * Column Info
	 * @param attribute4
	 */
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	
	/**
	 * Column Info
	 * @param attribute5
	 */
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	
	/**
	 * Column Info
	 * @param attribute6
	 */
	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}
	
	/**
	 * Column Info
	 * @param queueStatus
	 */
	public void setQueueStatus(String queueStatus) {
		this.queueStatus = queueStatus;
	}
	
	/**
	 * Column Info
	 * @param attribute7
	 */
	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}
	
	/**
	 * Column Info
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Column Info
	 * @param attribute8
	 */
	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}
	
	/**
	 * Column Info
	 * @param attribute9
	 */
	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}
	
	/**
	 * Column Info
	 * @param lastUpdateLogin
	 */
	public void setLastUpdateLogin(String lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}
	
	/**
	 * Column Info
	 * @param tagNumber
	 */
	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}
	
	/**
	 * Column Info
	 * @param attribute10
	 */
	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}
	
	/**
	 * Column Info
	 * @param attribute1
	 */
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	/**
	 * Column Info
	 * @param attribute2
	 */
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	
	/**
	 * Column Info
	 * @param attribute3
	 */
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	
	/**
	 * Column Info
	 * @param retirementTypeCode
	 */
	public void setRetirementTypeCode(String retirementTypeCode) {
		this.retirementTypeCode = retirementTypeCode;
	}
	
	/**
	 * Column Info
	 * @param unitsAssigned
	 */
	public void setUnitsAssigned(String unitsAssigned) {
		this.unitsAssigned = unitsAssigned;
	}
	
	/**
	 * Column Info
	 * @param proceedsOfSale
	 */
	public void setProceedsOfSale(String proceedsOfSale) {
		this.proceedsOfSale = proceedsOfSale;
	}
	
	/**
	 * Column Info
	 * @param costOfRemoval
	 */
	public void setCostOfRemoval(String costOfRemoval) {
		this.costOfRemoval = costOfRemoval;
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
	 * @param assetId
	 */
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	
	/**
	 * Column Info
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param tradeInAssetId
	 */
	public void setTradeInAssetId(String tradeInAssetId) {
		this.tradeInAssetId = tradeInAssetId;
	}
	
	/**
	 * Column Info
	 * @param transactionUnits
	 */
	public void setTransactionUnits(String transactionUnits) {
		this.transactionUnits = transactionUnits;
	}
	
	/**
	 * Column Info
	 * @param lclCurr
	 */
	public void setLclCurr(String lclCurr) {
		this.lclCurr = lclCurr;
	}
	
	/**
	 * Column Info
	 * @param lastUpdateDate
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	/**
	 * Column Info
	 * @param creationDate
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * Column Info
	 * @param retirementProrateConvention
	 */
	public void setRetirementProrateConvention(String retirementProrateConvention) {
		this.retirementProrateConvention = retirementProrateConvention;
	}
	
	/**
	 * Column Info
	 * @param lastUpdatedBy
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	/**
	 * Column Info
	 * @param dateRetired
	 */
	public void setDateRetired(String dateRetired) {
		this.dateRetired = dateRetired;
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
	 * @param bookTypeCode
	 */
	public void setBookTypeCode(String bookTypeCode) {
		this.bookTypeCode = bookTypeCode;
	}
	
	/**
	 * Column Info
	 * @param unitsRetired
	 */
	public void setUnitsRetired(String unitsRetired) {
		this.unitsRetired = unitsRetired;
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
		setAssignedTo(JSPUtil.getParameter(request, prefix + "assigned_to", ""));
		setTransactionDateEntered(JSPUtil.getParameter(request, prefix + "transaction_date_entered", ""));
		setInvoiceNo(JSPUtil.getParameter(request, prefix + "invoice_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDistributionId(JSPUtil.getParameter(request, prefix + "distribution_id", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setObjectVersionNumber(JSPUtil.getParameter(request, prefix + "object_version_number", ""));
		setPeriodOfAddition(JSPUtil.getParameter(request, prefix + "period_of_addition", ""));
		setCostRetired(JSPUtil.getParameter(request, prefix + "cost_retired", ""));
		setInterfaceFlag(JSPUtil.getParameter(request, prefix + "interface_flag", ""));
		setSoldTo(JSPUtil.getParameter(request, prefix + "sold_to", ""));
		setExpenseCcid(JSPUtil.getParameter(request, prefix + "expense_ccid", ""));
		setLclAmt(JSPUtil.getParameter(request, prefix + "lcl_amt", ""));
		setLifid(JSPUtil.getParameter(request, prefix + "lifid", ""));
		setLocationCcid(JSPUtil.getParameter(request, prefix + "location_ccid", ""));
		setRetirementId(JSPUtil.getParameter(request, prefix + "retirement_id", ""));
		setErrorDescription(JSPUtil.getParameter(request, prefix + "error_description", ""));
		setTransactionTypeCode(JSPUtil.getParameter(request, prefix + "transaction_type_code", ""));
		setCalculateGainLoss(JSPUtil.getParameter(request, prefix + "calculate_gain_loss", ""));
		setAttribute4(JSPUtil.getParameter(request, prefix + "attribute4", ""));
		setAttribute5(JSPUtil.getParameter(request, prefix + "attribute5", ""));
		setAttribute6(JSPUtil.getParameter(request, prefix + "attribute6", ""));
		setQueueStatus(JSPUtil.getParameter(request, prefix + "queue_status", ""));
		setAttribute7(JSPUtil.getParameter(request, prefix + "attribute7", ""));
		setCreatedBy(JSPUtil.getParameter(request, prefix + "created_by", ""));
		setAttribute8(JSPUtil.getParameter(request, prefix + "attribute8", ""));
		setAttribute9(JSPUtil.getParameter(request, prefix + "attribute9", ""));
		setLastUpdateLogin(JSPUtil.getParameter(request, prefix + "last_update_login", ""));
		setTagNumber(JSPUtil.getParameter(request, prefix + "tag_number", ""));
		setAttribute10(JSPUtil.getParameter(request, prefix + "attribute10", ""));
		setAttribute1(JSPUtil.getParameter(request, prefix + "attribute1", ""));
		setAttribute2(JSPUtil.getParameter(request, prefix + "attribute2", ""));
		setAttribute3(JSPUtil.getParameter(request, prefix + "attribute3", ""));
		setRetirementTypeCode(JSPUtil.getParameter(request, prefix + "retirement_type_code", ""));
		setUnitsAssigned(JSPUtil.getParameter(request, prefix + "units_assigned", ""));
		setProceedsOfSale(JSPUtil.getParameter(request, prefix + "proceeds_of_sale", ""));
		setCostOfRemoval(JSPUtil.getParameter(request, prefix + "cost_of_removal", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAssetId(JSPUtil.getParameter(request, prefix + "asset_id", ""));
		setTotalCount(JSPUtil.getParameter(request, prefix + "total_count", ""));
		setTradeInAssetId(JSPUtil.getParameter(request, prefix + "trade_in_asset_id", ""));
		setTransactionUnits(JSPUtil.getParameter(request, prefix + "transaction_units", ""));
		setLclCurr(JSPUtil.getParameter(request, prefix + "lcl_curr", ""));
		setLastUpdateDate(JSPUtil.getParameter(request, prefix + "last_update_date", ""));
		setCreationDate(JSPUtil.getParameter(request, prefix + "creation_date", ""));
		setRetirementProrateConvention(JSPUtil.getParameter(request, prefix + "retirement_prorate_convention", ""));
		setLastUpdatedBy(JSPUtil.getParameter(request, prefix + "last_updated_by", ""));
		setDateRetired(JSPUtil.getParameter(request, prefix + "date_retired", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setBookTypeCode(JSPUtil.getParameter(request, prefix + "book_type_code", ""));
		setUnitsRetired(JSPUtil.getParameter(request, prefix + "units_retired", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FaErpListVO[]
	 */
	public FaErpListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FaErpListVO[]
	 */
	public FaErpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FaErpListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] assignedTo = (JSPUtil.getParameter(request, prefix	+ "assigned_to", length));
			String[] transactionDateEntered = (JSPUtil.getParameter(request, prefix	+ "transaction_date_entered", length));
			String[] invoiceNo = (JSPUtil.getParameter(request, prefix	+ "invoice_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] distributionId = (JSPUtil.getParameter(request, prefix	+ "distribution_id", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] objectVersionNumber = (JSPUtil.getParameter(request, prefix	+ "object_version_number", length));
			String[] periodOfAddition = (JSPUtil.getParameter(request, prefix	+ "period_of_addition", length));
			String[] costRetired = (JSPUtil.getParameter(request, prefix	+ "cost_retired", length));
			String[] interfaceFlag = (JSPUtil.getParameter(request, prefix	+ "interface_flag", length));
			String[] soldTo = (JSPUtil.getParameter(request, prefix	+ "sold_to", length));
			String[] expenseCcid = (JSPUtil.getParameter(request, prefix	+ "expense_ccid", length));
			String[] lclAmt = (JSPUtil.getParameter(request, prefix	+ "lcl_amt", length));
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] locationCcid = (JSPUtil.getParameter(request, prefix	+ "location_ccid", length));
			String[] retirementId = (JSPUtil.getParameter(request, prefix	+ "retirement_id", length));
			String[] errorDescription = (JSPUtil.getParameter(request, prefix	+ "error_description", length));
			String[] transactionTypeCode = (JSPUtil.getParameter(request, prefix	+ "transaction_type_code", length));
			String[] calculateGainLoss = (JSPUtil.getParameter(request, prefix	+ "calculate_gain_loss", length));
			String[] attribute4 = (JSPUtil.getParameter(request, prefix	+ "attribute4", length));
			String[] attribute5 = (JSPUtil.getParameter(request, prefix	+ "attribute5", length));
			String[] attribute6 = (JSPUtil.getParameter(request, prefix	+ "attribute6", length));
			String[] queueStatus = (JSPUtil.getParameter(request, prefix	+ "queue_status", length));
			String[] attribute7 = (JSPUtil.getParameter(request, prefix	+ "attribute7", length));
			String[] createdBy = (JSPUtil.getParameter(request, prefix	+ "created_by", length));
			String[] attribute8 = (JSPUtil.getParameter(request, prefix	+ "attribute8", length));
			String[] attribute9 = (JSPUtil.getParameter(request, prefix	+ "attribute9", length));
			String[] lastUpdateLogin = (JSPUtil.getParameter(request, prefix	+ "last_update_login", length));
			String[] tagNumber = (JSPUtil.getParameter(request, prefix	+ "tag_number", length));
			String[] attribute10 = (JSPUtil.getParameter(request, prefix	+ "attribute10", length));
			String[] attribute1 = (JSPUtil.getParameter(request, prefix	+ "attribute1", length));
			String[] attribute2 = (JSPUtil.getParameter(request, prefix	+ "attribute2", length));
			String[] attribute3 = (JSPUtil.getParameter(request, prefix	+ "attribute3", length));
			String[] retirementTypeCode = (JSPUtil.getParameter(request, prefix	+ "retirement_type_code", length));
			String[] unitsAssigned = (JSPUtil.getParameter(request, prefix	+ "units_assigned", length));
			String[] proceedsOfSale = (JSPUtil.getParameter(request, prefix	+ "proceeds_of_sale", length));
			String[] costOfRemoval = (JSPUtil.getParameter(request, prefix	+ "cost_of_removal", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] assetId = (JSPUtil.getParameter(request, prefix	+ "asset_id", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] tradeInAssetId = (JSPUtil.getParameter(request, prefix	+ "trade_in_asset_id", length));
			String[] transactionUnits = (JSPUtil.getParameter(request, prefix	+ "transaction_units", length));
			String[] lclCurr = (JSPUtil.getParameter(request, prefix	+ "lcl_curr", length));
			String[] lastUpdateDate = (JSPUtil.getParameter(request, prefix	+ "last_update_date", length));
			String[] creationDate = (JSPUtil.getParameter(request, prefix	+ "creation_date", length));
			String[] retirementProrateConvention = (JSPUtil.getParameter(request, prefix	+ "retirement_prorate_convention", length));
			String[] lastUpdatedBy = (JSPUtil.getParameter(request, prefix	+ "last_updated_by", length));
			String[] dateRetired = (JSPUtil.getParameter(request, prefix	+ "date_retired", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] bookTypeCode = (JSPUtil.getParameter(request, prefix	+ "book_type_code", length));
			String[] unitsRetired = (JSPUtil.getParameter(request, prefix	+ "units_retired", length));
			
			for (int i = 0; i < length; i++) {
				model = new FaErpListVO();
				if (assignedTo[i] != null)
					model.setAssignedTo(assignedTo[i]);
				if (transactionDateEntered[i] != null)
					model.setTransactionDateEntered(transactionDateEntered[i]);
				if (invoiceNo[i] != null)
					model.setInvoiceNo(invoiceNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (distributionId[i] != null)
					model.setDistributionId(distributionId[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (objectVersionNumber[i] != null)
					model.setObjectVersionNumber(objectVersionNumber[i]);
				if (periodOfAddition[i] != null)
					model.setPeriodOfAddition(periodOfAddition[i]);
				if (costRetired[i] != null)
					model.setCostRetired(costRetired[i]);
				if (interfaceFlag[i] != null)
					model.setInterfaceFlag(interfaceFlag[i]);
				if (soldTo[i] != null)
					model.setSoldTo(soldTo[i]);
				if (expenseCcid[i] != null)
					model.setExpenseCcid(expenseCcid[i]);
				if (lclAmt[i] != null)
					model.setLclAmt(lclAmt[i]);
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (locationCcid[i] != null)
					model.setLocationCcid(locationCcid[i]);
				if (retirementId[i] != null)
					model.setRetirementId(retirementId[i]);
				if (errorDescription[i] != null)
					model.setErrorDescription(errorDescription[i]);
				if (transactionTypeCode[i] != null)
					model.setTransactionTypeCode(transactionTypeCode[i]);
				if (calculateGainLoss[i] != null)
					model.setCalculateGainLoss(calculateGainLoss[i]);
				if (attribute4[i] != null)
					model.setAttribute4(attribute4[i]);
				if (attribute5[i] != null)
					model.setAttribute5(attribute5[i]);
				if (attribute6[i] != null)
					model.setAttribute6(attribute6[i]);
				if (queueStatus[i] != null)
					model.setQueueStatus(queueStatus[i]);
				if (attribute7[i] != null)
					model.setAttribute7(attribute7[i]);
				if (createdBy[i] != null)
					model.setCreatedBy(createdBy[i]);
				if (attribute8[i] != null)
					model.setAttribute8(attribute8[i]);
				if (attribute9[i] != null)
					model.setAttribute9(attribute9[i]);
				if (lastUpdateLogin[i] != null)
					model.setLastUpdateLogin(lastUpdateLogin[i]);
				if (tagNumber[i] != null)
					model.setTagNumber(tagNumber[i]);
				if (attribute10[i] != null)
					model.setAttribute10(attribute10[i]);
				if (attribute1[i] != null)
					model.setAttribute1(attribute1[i]);
				if (attribute2[i] != null)
					model.setAttribute2(attribute2[i]);
				if (attribute3[i] != null)
					model.setAttribute3(attribute3[i]);
				if (retirementTypeCode[i] != null)
					model.setRetirementTypeCode(retirementTypeCode[i]);
				if (unitsAssigned[i] != null)
					model.setUnitsAssigned(unitsAssigned[i]);
				if (proceedsOfSale[i] != null)
					model.setProceedsOfSale(proceedsOfSale[i]);
				if (costOfRemoval[i] != null)
					model.setCostOfRemoval(costOfRemoval[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (assetId[i] != null)
					model.setAssetId(assetId[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (tradeInAssetId[i] != null)
					model.setTradeInAssetId(tradeInAssetId[i]);
				if (transactionUnits[i] != null)
					model.setTransactionUnits(transactionUnits[i]);
				if (lclCurr[i] != null)
					model.setLclCurr(lclCurr[i]);
				if (lastUpdateDate[i] != null)
					model.setLastUpdateDate(lastUpdateDate[i]);
				if (creationDate[i] != null)
					model.setCreationDate(creationDate[i]);
				if (retirementProrateConvention[i] != null)
					model.setRetirementProrateConvention(retirementProrateConvention[i]);
				if (lastUpdatedBy[i] != null)
					model.setLastUpdatedBy(lastUpdatedBy[i]);
				if (dateRetired[i] != null)
					model.setDateRetired(dateRetired[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (bookTypeCode[i] != null)
					model.setBookTypeCode(bookTypeCode[i]);
				if (unitsRetired[i] != null)
					model.setUnitsRetired(unitsRetired[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFaErpListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FaErpListVO[]
	 */
	public FaErpListVO[] getFaErpListVOs(){
		FaErpListVO[] vos = (FaErpListVO[])models.toArray(new FaErpListVO[models.size()]);
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
		this.assignedTo = this.assignedTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transactionDateEntered = this.transactionDateEntered .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceNo = this.invoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distributionId = this.distributionId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objectVersionNumber = this.objectVersionNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodOfAddition = this.periodOfAddition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRetired = this.costRetired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interfaceFlag = this.interfaceFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soldTo = this.soldTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expenseCcid = this.expenseCcid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt = this.lclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCcid = this.locationCcid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retirementId = this.retirementId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorDescription = this.errorDescription .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transactionTypeCode = this.transactionTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calculateGainLoss = this.calculateGainLoss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute4 = this.attribute4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute5 = this.attribute5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute6 = this.attribute6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueStatus = this.queueStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute7 = this.attribute7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdBy = this.createdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute8 = this.attribute8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute9 = this.attribute9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdateLogin = this.lastUpdateLogin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tagNumber = this.tagNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute10 = this.attribute10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute1 = this.attribute1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute2 = this.attribute2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute3 = this.attribute3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retirementTypeCode = this.retirementTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitsAssigned = this.unitsAssigned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proceedsOfSale = this.proceedsOfSale .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfRemoval = this.costOfRemoval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assetId = this.assetId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeInAssetId = this.tradeInAssetId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transactionUnits = this.transactionUnits .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr = this.lclCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdateDate = this.lastUpdateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationDate = this.creationDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retirementProrateConvention = this.retirementProrateConvention .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdatedBy = this.lastUpdatedBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateRetired = this.dateRetired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookTypeCode = this.bookTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitsRetired = this.unitsRetired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
