/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APTransactionVO.java
*@FileTitle : APTransactionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

import java.lang.reflect.Field;
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

public class APTransactionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APTransactionVO> models = new ArrayList<APTransactionVO>();
	
	/* Column Info */
	private String transactionId = null;
	/* Column Info */
	private String paymentLclAmount = null;
	/* Column Info */
	private String bankAccountSeq = null;
	/* Column Info */
	private String exchangeRate = null;
	/* Column Info */
	private String referenceNumber = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String lclAmount = null;
	/* Column Info */
	private String paymentAmount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String referenceType = null;
	/* Column Info */
	private String batchName = null;
	/* Column Info */
	private String calAmount = null;
	/* Column Info */
	private String description = null;
	/* Column Info */
	private String calLclAmount = null;
	/* Column Info */
	private String currencyCode = null;
	/* Column Info */
	private String typeMeaning = null;
	/* Column Info */
	private String currPoint = null;
	/* Column Info */
	private String slipStatus = null;
	/* Column Info */
	private String receiptAmount = null;
	/* Column Info */
	private String receiptLclAmount = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String agentName = null;
	/* Column Info */
	private String clearedDate = null;
	/* Column Info */
	private String trxNumber = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APTransactionVO() {}

	public APTransactionVO(String ibflag, String pagerows, String typeMeaning, String bankAccountSeq, String trxNumber, String currencyCode, String amount, String calAmount, String paymentAmount, String receiptAmount, String clearedDate, String agentName, String batchName, String source, String transactionId, String description, String exchangeRate, String lclAmount, String calLclAmount, String paymentLclAmount, String receiptLclAmount, String referenceType, String referenceNumber, String slipStatus, String currPoint) {
		this.transactionId = transactionId;
		this.paymentLclAmount = paymentLclAmount;
		this.bankAccountSeq = bankAccountSeq;
		this.exchangeRate = exchangeRate;
		this.referenceNumber = referenceNumber;
		this.pagerows = pagerows;
		this.amount = amount;
		this.lclAmount = lclAmount;
		this.paymentAmount = paymentAmount;
		this.ibflag = ibflag;
		this.referenceType = referenceType;
		this.batchName = batchName;
		this.calAmount = calAmount;
		this.description = description;
		this.calLclAmount = calLclAmount;
		this.currencyCode = currencyCode;
		this.typeMeaning = typeMeaning;
		this.currPoint = currPoint;
		this.slipStatus = slipStatus;
		this.receiptAmount = receiptAmount;
		this.receiptLclAmount = receiptLclAmount;
		this.source = source;
		this.agentName = agentName;
		this.clearedDate = clearedDate;
		this.trxNumber = trxNumber;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("transaction_id", getTransactionId());
		this.hashColumns.put("payment_lcl_amount", getPaymentLclAmount());
		this.hashColumns.put("bank_account_seq", getBankAccountSeq());
		this.hashColumns.put("exchange_rate", getExchangeRate());
		this.hashColumns.put("reference_number", getReferenceNumber());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("lcl_amount", getLclAmount());
		this.hashColumns.put("payment_amount", getPaymentAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("reference_type", getReferenceType());
		this.hashColumns.put("batch_name", getBatchName());
		this.hashColumns.put("cal_amount", getCalAmount());
		this.hashColumns.put("description", getDescription());
		this.hashColumns.put("cal_lcl_amount", getCalLclAmount());
		this.hashColumns.put("currency_code", getCurrencyCode());
		this.hashColumns.put("type_meaning", getTypeMeaning());
		this.hashColumns.put("curr_point", getCurrPoint());
		this.hashColumns.put("slip_status", getSlipStatus());
		this.hashColumns.put("receipt_amount", getReceiptAmount());
		this.hashColumns.put("receipt_lcl_amount", getReceiptLclAmount());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("agent_name", getAgentName());
		this.hashColumns.put("cleared_date", getClearedDate());
		this.hashColumns.put("trx_number", getTrxNumber());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("transaction_id", "transactionId");
		this.hashFields.put("payment_lcl_amount", "paymentLclAmount");
		this.hashFields.put("bank_account_seq", "bankAccountSeq");
		this.hashFields.put("exchange_rate", "exchangeRate");
		this.hashFields.put("reference_number", "referenceNumber");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("lcl_amount", "lclAmount");
		this.hashFields.put("payment_amount", "paymentAmount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("reference_type", "referenceType");
		this.hashFields.put("batch_name", "batchName");
		this.hashFields.put("cal_amount", "calAmount");
		this.hashFields.put("description", "description");
		this.hashFields.put("cal_lcl_amount", "calLclAmount");
		this.hashFields.put("currency_code", "currencyCode");
		this.hashFields.put("type_meaning", "typeMeaning");
		this.hashFields.put("curr_point", "currPoint");
		this.hashFields.put("slip_status", "slipStatus");
		this.hashFields.put("receipt_amount", "receiptAmount");
		this.hashFields.put("receipt_lcl_amount", "receiptLclAmount");
		this.hashFields.put("source", "source");
		this.hashFields.put("agent_name", "agentName");
		this.hashFields.put("cleared_date", "clearedDate");
		this.hashFields.put("trx_number", "trxNumber");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return transactionId
	 */
	public String getTransactionId() {
		return this.transactionId;
	}
	
	/**
	 * Column Info
	 * @return paymentLclAmount
	 */
	public String getPaymentLclAmount() {
		return this.paymentLclAmount;
	}
	
	/**
	 * Column Info
	 * @return bankAccountSeq
	 */
	public String getBankAccountSeq() {
		return this.bankAccountSeq;
	}
	
	/**
	 * Column Info
	 * @return exchangeRate
	 */
	public String getExchangeRate() {
		return this.exchangeRate;
	}
	
	/**
	 * Column Info
	 * @return referenceNumber
	 */
	public String getReferenceNumber() {
		return this.referenceNumber;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return lclAmount
	 */
	public String getLclAmount() {
		return this.lclAmount;
	}
	
	/**
	 * Column Info
	 * @return paymentAmount
	 */
	public String getPaymentAmount() {
		return this.paymentAmount;
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
	 * @return referenceType
	 */
	public String getReferenceType() {
		return this.referenceType;
	}
	
	/**
	 * Column Info
	 * @return batchName
	 */
	public String getBatchName() {
		return this.batchName;
	}
	
	/**
	 * Column Info
	 * @return calAmount
	 */
	public String getCalAmount() {
		return this.calAmount;
	}
	
	/**
	 * Column Info
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Column Info
	 * @return calLclAmount
	 */
	public String getCalLclAmount() {
		return this.calLclAmount;
	}
	
	/**
	 * Column Info
	 * @return currencyCode
	 */
	public String getCurrencyCode() {
		return this.currencyCode;
	}
	
	/**
	 * Column Info
	 * @return typeMeaning
	 */
	public String getTypeMeaning() {
		return this.typeMeaning;
	}
	
	/**
	 * Column Info
	 * @return currPoint
	 */
	public String getCurrPoint() {
		return this.currPoint;
	}
	
	/**
	 * Column Info
	 * @return slipStatus
	 */
	public String getSlipStatus() {
		return this.slipStatus;
	}
	
	/**
	 * Column Info
	 * @return receiptAmount
	 */
	public String getReceiptAmount() {
		return this.receiptAmount;
	}
	
	/**
	 * Column Info
	 * @return receiptLclAmount
	 */
	public String getReceiptLclAmount() {
		return this.receiptLclAmount;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return agentName
	 */
	public String getAgentName() {
		return this.agentName;
	}
	
	/**
	 * Column Info
	 * @return clearedDate
	 */
	public String getClearedDate() {
		return this.clearedDate;
	}
	
	/**
	 * Column Info
	 * @return trxNumber
	 */
	public String getTrxNumber() {
		return this.trxNumber;
	}
	

	/**
	 * Column Info
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	/**
	 * Column Info
	 * @param paymentLclAmount
	 */
	public void setPaymentLclAmount(String paymentLclAmount) {
		this.paymentLclAmount = paymentLclAmount;
	}
	
	/**
	 * Column Info
	 * @param bankAccountSeq
	 */
	public void setBankAccountSeq(String bankAccountSeq) {
		this.bankAccountSeq = bankAccountSeq;
	}
	
	/**
	 * Column Info
	 * @param exchangeRate
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	/**
	 * Column Info
	 * @param referenceNumber
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param lclAmount
	 */
	public void setLclAmount(String lclAmount) {
		this.lclAmount = lclAmount;
	}
	
	/**
	 * Column Info
	 * @param paymentAmount
	 */
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
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
	 * @param referenceType
	 */
	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}
	
	/**
	 * Column Info
	 * @param batchName
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	/**
	 * Column Info
	 * @param calAmount
	 */
	public void setCalAmount(String calAmount) {
		this.calAmount = calAmount;
	}
	
	/**
	 * Column Info
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Column Info
	 * @param calLclAmount
	 */
	public void setCalLclAmount(String calLclAmount) {
		this.calLclAmount = calLclAmount;
	}
	
	/**
	 * Column Info
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	/**
	 * Column Info
	 * @param typeMeaning
	 */
	public void setTypeMeaning(String typeMeaning) {
		this.typeMeaning = typeMeaning;
	}
	
	/**
	 * Column Info
	 * @param currPoint
	 */
	public void setCurrPoint(String currPoint) {
		this.currPoint = currPoint;
	}
	
	/**
	 * Column Info
	 * @param slipStatus
	 */
	public void setSlipStatus(String slipStatus) {
		this.slipStatus = slipStatus;
	}
	
	/**
	 * Column Info
	 * @param receiptAmount
	 */
	public void setReceiptAmount(String receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	
	/**
	 * Column Info
	 * @param receiptLclAmount
	 */
	public void setReceiptLclAmount(String receiptLclAmount) {
		this.receiptLclAmount = receiptLclAmount;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	/**
	 * Column Info
	 * @param clearedDate
	 */
	public void setClearedDate(String clearedDate) {
		this.clearedDate = clearedDate;
	}
	
	/**
	 * Column Info
	 * @param trxNumber
	 */
	public void setTrxNumber(String trxNumber) {
		this.trxNumber = trxNumber;
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
		setTransactionId(JSPUtil.getParameter(request, prefix + "transaction_id", ""));
		setPaymentLclAmount(JSPUtil.getParameter(request, prefix + "payment_lcl_amount", ""));
		setBankAccountSeq(JSPUtil.getParameter(request, prefix + "bank_account_seq", ""));
		setExchangeRate(JSPUtil.getParameter(request, prefix + "exchange_rate", ""));
		setReferenceNumber(JSPUtil.getParameter(request, prefix + "reference_number", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setLclAmount(JSPUtil.getParameter(request, prefix + "lcl_amount", ""));
		setPaymentAmount(JSPUtil.getParameter(request, prefix + "payment_amount", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setReferenceType(JSPUtil.getParameter(request, prefix + "reference_type", ""));
		setBatchName(JSPUtil.getParameter(request, prefix + "batch_name", ""));
		setCalAmount(JSPUtil.getParameter(request, prefix + "cal_amount", ""));
		setDescription(JSPUtil.getParameter(request, prefix + "description", ""));
		setCalLclAmount(JSPUtil.getParameter(request, prefix + "cal_lcl_amount", ""));
		setCurrencyCode(JSPUtil.getParameter(request, prefix + "currency_code", ""));
		setTypeMeaning(JSPUtil.getParameter(request, prefix + "type_meaning", ""));
		setCurrPoint(JSPUtil.getParameter(request, prefix + "curr_point", ""));
		setSlipStatus(JSPUtil.getParameter(request, prefix + "slip_status", ""));
		setReceiptAmount(JSPUtil.getParameter(request, prefix + "receipt_amount", ""));
		setReceiptLclAmount(JSPUtil.getParameter(request, prefix + "receipt_lcl_amount", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setAgentName(JSPUtil.getParameter(request, prefix + "agent_name", ""));
		setClearedDate(JSPUtil.getParameter(request, prefix + "cleared_date", ""));
		setTrxNumber(JSPUtil.getParameter(request, prefix + "trx_number", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APTransactionVO[]
	 */
	public APTransactionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APTransactionVO[]
	 */
	public APTransactionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APTransactionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] transactionId = (JSPUtil.getParameter(request, prefix	+ "transaction_id", length));
			String[] paymentLclAmount = (JSPUtil.getParameter(request, prefix	+ "payment_lcl_amount", length));
			String[] bankAccountSeq = (JSPUtil.getParameter(request, prefix	+ "bank_account_seq", length));
			String[] exchangeRate = (JSPUtil.getParameter(request, prefix	+ "exchange_rate", length));
			String[] referenceNumber = (JSPUtil.getParameter(request, prefix	+ "reference_number", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] lclAmount = (JSPUtil.getParameter(request, prefix	+ "lcl_amount", length));
			String[] paymentAmount = (JSPUtil.getParameter(request, prefix	+ "payment_amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] referenceType = (JSPUtil.getParameter(request, prefix	+ "reference_type", length));
			String[] batchName = (JSPUtil.getParameter(request, prefix	+ "batch_name", length));
			String[] calAmount = (JSPUtil.getParameter(request, prefix	+ "cal_amount", length));
			String[] description = (JSPUtil.getParameter(request, prefix	+ "description", length));
			String[] calLclAmount = (JSPUtil.getParameter(request, prefix	+ "cal_lcl_amount", length));
			String[] currencyCode = (JSPUtil.getParameter(request, prefix	+ "currency_code", length));
			String[] typeMeaning = (JSPUtil.getParameter(request, prefix	+ "type_meaning", length));
			String[] currPoint = (JSPUtil.getParameter(request, prefix	+ "curr_point", length));
			String[] slipStatus = (JSPUtil.getParameter(request, prefix	+ "slip_status", length));
			String[] receiptAmount = (JSPUtil.getParameter(request, prefix	+ "receipt_amount", length));
			String[] receiptLclAmount = (JSPUtil.getParameter(request, prefix	+ "receipt_lcl_amount", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] agentName = (JSPUtil.getParameter(request, prefix	+ "agent_name", length));
			String[] clearedDate = (JSPUtil.getParameter(request, prefix	+ "cleared_date", length));
			String[] trxNumber = (JSPUtil.getParameter(request, prefix	+ "trx_number", length));
			
			for (int i = 0; i < length; i++) {
				model = new APTransactionVO();
				if (transactionId[i] != null)
					model.setTransactionId(transactionId[i]);
				if (paymentLclAmount[i] != null)
					model.setPaymentLclAmount(paymentLclAmount[i]);
				if (bankAccountSeq[i] != null)
					model.setBankAccountSeq(bankAccountSeq[i]);
				if (exchangeRate[i] != null)
					model.setExchangeRate(exchangeRate[i]);
				if (referenceNumber[i] != null)
					model.setReferenceNumber(referenceNumber[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (lclAmount[i] != null)
					model.setLclAmount(lclAmount[i]);
				if (paymentAmount[i] != null)
					model.setPaymentAmount(paymentAmount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (referenceType[i] != null)
					model.setReferenceType(referenceType[i]);
				if (batchName[i] != null)
					model.setBatchName(batchName[i]);
				if (calAmount[i] != null)
					model.setCalAmount(calAmount[i]);
				if (description[i] != null)
					model.setDescription(description[i]);
				if (calLclAmount[i] != null)
					model.setCalLclAmount(calLclAmount[i]);
				if (currencyCode[i] != null)
					model.setCurrencyCode(currencyCode[i]);
				if (typeMeaning[i] != null)
					model.setTypeMeaning(typeMeaning[i]);
				if (currPoint[i] != null)
					model.setCurrPoint(currPoint[i]);
				if (slipStatus[i] != null)
					model.setSlipStatus(slipStatus[i]);
				if (receiptAmount[i] != null)
					model.setReceiptAmount(receiptAmount[i]);
				if (receiptLclAmount[i] != null)
					model.setReceiptLclAmount(receiptLclAmount[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (agentName[i] != null)
					model.setAgentName(agentName[i]);
				if (clearedDate[i] != null)
					model.setClearedDate(clearedDate[i]);
				if (trxNumber[i] != null)
					model.setTrxNumber(trxNumber[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPTransactionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APTransactionVO[]
	 */
	public APTransactionVO[] getAPTransactionVOs(){
		APTransactionVO[] vos = (APTransactionVO[])models.toArray(new APTransactionVO[models.size()]);
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
		this.transactionId = this.transactionId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentLclAmount = this.paymentLclAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAccountSeq = this.bankAccountSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exchangeRate = this.exchangeRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.referenceNumber = this.referenceNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmount = this.lclAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentAmount = this.paymentAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.referenceType = this.referenceType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchName = this.batchName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calAmount = this.calAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description = this.description .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calLclAmount = this.calLclAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currencyCode = this.currencyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeMeaning = this.typeMeaning .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPoint = this.currPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipStatus = this.slipStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiptAmount = this.receiptAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiptLclAmount = this.receiptLclAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agentName = this.agentName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clearedDate = this.clearedDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trxNumber = this.trxNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
