/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InternalBankAcctVO.java
*@FileTitle : InternalBankAcctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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

public class InternalBankAcctVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InternalBankAcctVO> models = new ArrayList<InternalBankAcctVO>();
	
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String bankAcctMinorType = null;
	/* Column Info */
	private String bankAcctName = null;
	/* Column Info */
	private String currencyCode = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String assetCodeCombinationId = null;
	/* Column Info */
	private String bankName = null;
	/* Column Info */
	private String apControlOfficeCode = null;
	/* Column Info */
	private String bankAcctMinor = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bankNameAlt = null;
	/* Column Info */
	private String apOfficeCode = null;
	/* Column Info */
	private String bankBranchSeq = null;
	/* Column Info */
	private String bankBranchName = null;
	/* Column Info */
	private String bankAcctMajor = null;
	/* Column Info */
	private String bankBranchNameAlt = null;
	/* Column Info */
	private String bankAcctMajorType = null;
	/* Column Info */
	private String arOfficeCode = null;
	/* Column Info */
	private String arControlOfficeCode = null;
	/* Column Info */
	private String bankAcctNumber = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InternalBankAcctVO() {}

	public InternalBankAcctVO(String ibflag, String pagerows, String bankAcctSeq, String bankAcctNumber, String bankAcctName, String bankBranchSeq, String bankName, String bankNameAlt, String bankBranchName, String bankBranchNameAlt, String apOfficeCode, String apControlOfficeCode, String arOfficeCode, String arControlOfficeCode, String bankAcctMajorType, String bankAcctMinorType, String bankAcctMajor, String bankAcctMinor, String assetCodeCombinationId, String currencyCode, String countryCode) {
		this.bankAcctSeq = bankAcctSeq;
		this.bankAcctMinorType = bankAcctMinorType;
		this.bankAcctName = bankAcctName;
		this.currencyCode = currencyCode;
		this.countryCode = countryCode;
		this.assetCodeCombinationId = assetCodeCombinationId;
		this.bankName = bankName;
		this.apControlOfficeCode = apControlOfficeCode;
		this.bankAcctMinor = bankAcctMinor;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bankNameAlt = bankNameAlt;
		this.apOfficeCode = apOfficeCode;
		this.bankBranchSeq = bankBranchSeq;
		this.bankBranchName = bankBranchName;
		this.bankAcctMajor = bankAcctMajor;
		this.bankBranchNameAlt = bankBranchNameAlt;
		this.bankAcctMajorType = bankAcctMajorType;
		this.arOfficeCode = arOfficeCode;
		this.arControlOfficeCode = arControlOfficeCode;
		this.bankAcctNumber = bankAcctNumber;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("bank_acct_minor_type", getBankAcctMinorType());
		this.hashColumns.put("bank_acct_name", getBankAcctName());
		this.hashColumns.put("currency_code", getCurrencyCode());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("asset_code_combination_id", getAssetCodeCombinationId());
		this.hashColumns.put("bank_name", getBankName());
		this.hashColumns.put("ap_control_office_code", getApControlOfficeCode());
		this.hashColumns.put("bank_acct_minor", getBankAcctMinor());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bank_name_alt", getBankNameAlt());
		this.hashColumns.put("ap_office_code", getApOfficeCode());
		this.hashColumns.put("bank_branch_seq", getBankBranchSeq());
		this.hashColumns.put("bank_branch_name", getBankBranchName());
		this.hashColumns.put("bank_acct_major", getBankAcctMajor());
		this.hashColumns.put("bank_branch_name_alt", getBankBranchNameAlt());
		this.hashColumns.put("bank_acct_major_type", getBankAcctMajorType());
		this.hashColumns.put("ar_office_code", getArOfficeCode());
		this.hashColumns.put("ar_control_office_code", getArControlOfficeCode());
		this.hashColumns.put("bank_acct_number", getBankAcctNumber());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("bank_acct_minor_type", "bankAcctMinorType");
		this.hashFields.put("bank_acct_name", "bankAcctName");
		this.hashFields.put("currency_code", "currencyCode");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("asset_code_combination_id", "assetCodeCombinationId");
		this.hashFields.put("bank_name", "bankName");
		this.hashFields.put("ap_control_office_code", "apControlOfficeCode");
		this.hashFields.put("bank_acct_minor", "bankAcctMinor");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bank_name_alt", "bankNameAlt");
		this.hashFields.put("ap_office_code", "apOfficeCode");
		this.hashFields.put("bank_branch_seq", "bankBranchSeq");
		this.hashFields.put("bank_branch_name", "bankBranchName");
		this.hashFields.put("bank_acct_major", "bankAcctMajor");
		this.hashFields.put("bank_branch_name_alt", "bankBranchNameAlt");
		this.hashFields.put("bank_acct_major_type", "bankAcctMajorType");
		this.hashFields.put("ar_office_code", "arOfficeCode");
		this.hashFields.put("ar_control_office_code", "arControlOfficeCode");
		this.hashFields.put("bank_acct_number", "bankAcctNumber");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctSeq
	 */
	public String getBankAcctSeq() {
		return this.bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @return bankAcctMinorType
	 */
	public String getBankAcctMinorType() {
		return this.bankAcctMinorType;
	}
	
	/**
	 * Column Info
	 * @return bankAcctName
	 */
	public String getBankAcctName() {
		return this.bankAcctName;
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
	 * @return countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
	}
	
	/**
	 * Column Info
	 * @return assetCodeCombinationId
	 */
	public String getAssetCodeCombinationId() {
		return this.assetCodeCombinationId;
	}
	
	/**
	 * Column Info
	 * @return bankName
	 */
	public String getBankName() {
		return this.bankName;
	}
	
	/**
	 * Column Info
	 * @return apControlOfficeCode
	 */
	public String getApControlOfficeCode() {
		return this.apControlOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return bankAcctMinor
	 */
	public String getBankAcctMinor() {
		return this.bankAcctMinor;
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
	 * @return bankNameAlt
	 */
	public String getBankNameAlt() {
		return this.bankNameAlt;
	}
	
	/**
	 * Column Info
	 * @return apOfficeCode
	 */
	public String getApOfficeCode() {
		return this.apOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return bankBranchSeq
	 */
	public String getBankBranchSeq() {
		return this.bankBranchSeq;
	}
	
	/**
	 * Column Info
	 * @return bankBranchName
	 */
	public String getBankBranchName() {
		return this.bankBranchName;
	}
	
	/**
	 * Column Info
	 * @return bankAcctMajor
	 */
	public String getBankAcctMajor() {
		return this.bankAcctMajor;
	}
	
	/**
	 * Column Info
	 * @return bankBranchNameAlt
	 */
	public String getBankBranchNameAlt() {
		return this.bankBranchNameAlt;
	}
	
	/**
	 * Column Info
	 * @return bankAcctMajorType
	 */
	public String getBankAcctMajorType() {
		return this.bankAcctMajorType;
	}
	
	/**
	 * Column Info
	 * @return arOfficeCode
	 */
	public String getArOfficeCode() {
		return this.arOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return arControlOfficeCode
	 */
	public String getArControlOfficeCode() {
		return this.arControlOfficeCode;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNumber
	 */
	public String getBankAcctNumber() {
		return this.bankAcctNumber;
	}
	

	/**
	 * Column Info
	 * @param bankAcctSeq
	 */
	public void setBankAcctSeq(String bankAcctSeq) {
		this.bankAcctSeq = bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @param bankAcctMinorType
	 */
	public void setBankAcctMinorType(String bankAcctMinorType) {
		this.bankAcctMinorType = bankAcctMinorType;
	}
	
	/**
	 * Column Info
	 * @param bankAcctName
	 */
	public void setBankAcctName(String bankAcctName) {
		this.bankAcctName = bankAcctName;
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
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * Column Info
	 * @param assetCodeCombinationId
	 */
	public void setAssetCodeCombinationId(String assetCodeCombinationId) {
		this.assetCodeCombinationId = assetCodeCombinationId;
	}
	
	/**
	 * Column Info
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/**
	 * Column Info
	 * @param apControlOfficeCode
	 */
	public void setApControlOfficeCode(String apControlOfficeCode) {
		this.apControlOfficeCode = apControlOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param bankAcctMinor
	 */
	public void setBankAcctMinor(String bankAcctMinor) {
		this.bankAcctMinor = bankAcctMinor;
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
	 * @param bankNameAlt
	 */
	public void setBankNameAlt(String bankNameAlt) {
		this.bankNameAlt = bankNameAlt;
	}
	
	/**
	 * Column Info
	 * @param apOfficeCode
	 */
	public void setApOfficeCode(String apOfficeCode) {
		this.apOfficeCode = apOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param bankBranchSeq
	 */
	public void setBankBranchSeq(String bankBranchSeq) {
		this.bankBranchSeq = bankBranchSeq;
	}
	
	/**
	 * Column Info
	 * @param bankBranchName
	 */
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
	
	/**
	 * Column Info
	 * @param bankAcctMajor
	 */
	public void setBankAcctMajor(String bankAcctMajor) {
		this.bankAcctMajor = bankAcctMajor;
	}
	
	/**
	 * Column Info
	 * @param bankBranchNameAlt
	 */
	public void setBankBranchNameAlt(String bankBranchNameAlt) {
		this.bankBranchNameAlt = bankBranchNameAlt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctMajorType
	 */
	public void setBankAcctMajorType(String bankAcctMajorType) {
		this.bankAcctMajorType = bankAcctMajorType;
	}
	
	/**
	 * Column Info
	 * @param arOfficeCode
	 */
	public void setArOfficeCode(String arOfficeCode) {
		this.arOfficeCode = arOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param arControlOfficeCode
	 */
	public void setArControlOfficeCode(String arControlOfficeCode) {
		this.arControlOfficeCode = arControlOfficeCode;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNumber
	 */
	public void setBankAcctNumber(String bankAcctNumber) {
		this.bankAcctNumber = bankAcctNumber;
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
		setBankAcctSeq(JSPUtil.getParameter(request, prefix + "bank_acct_seq", ""));
		setBankAcctMinorType(JSPUtil.getParameter(request, prefix + "bank_acct_minor_type", ""));
		setBankAcctName(JSPUtil.getParameter(request, prefix + "bank_acct_name", ""));
		setCurrencyCode(JSPUtil.getParameter(request, prefix + "currency_code", ""));
		setCountryCode(JSPUtil.getParameter(request, prefix + "country_code", ""));
		setAssetCodeCombinationId(JSPUtil.getParameter(request, prefix + "asset_code_combination_id", ""));
		setBankName(JSPUtil.getParameter(request, prefix + "bank_name", ""));
		setApControlOfficeCode(JSPUtil.getParameter(request, prefix + "ap_control_office_code", ""));
		setBankAcctMinor(JSPUtil.getParameter(request, prefix + "bank_acct_minor", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBankNameAlt(JSPUtil.getParameter(request, prefix + "bank_name_alt", ""));
		setApOfficeCode(JSPUtil.getParameter(request, prefix + "ap_office_code", ""));
		setBankBranchSeq(JSPUtil.getParameter(request, prefix + "bank_branch_seq", ""));
		setBankBranchName(JSPUtil.getParameter(request, prefix + "bank_branch_name", ""));
		setBankAcctMajor(JSPUtil.getParameter(request, prefix + "bank_acct_major", ""));
		setBankBranchNameAlt(JSPUtil.getParameter(request, prefix + "bank_branch_name_alt", ""));
		setBankAcctMajorType(JSPUtil.getParameter(request, prefix + "bank_acct_major_type", ""));
		setArOfficeCode(JSPUtil.getParameter(request, prefix + "ar_office_code", ""));
		setArControlOfficeCode(JSPUtil.getParameter(request, prefix + "ar_control_office_code", ""));
		setBankAcctNumber(JSPUtil.getParameter(request, prefix + "bank_acct_number", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InternalBankAcctVO[]
	 */
	public InternalBankAcctVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InternalBankAcctVO[]
	 */
	public InternalBankAcctVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InternalBankAcctVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] bankAcctMinorType = (JSPUtil.getParameter(request, prefix	+ "bank_acct_minor_type", length));
			String[] bankAcctName = (JSPUtil.getParameter(request, prefix	+ "bank_acct_name", length));
			String[] currencyCode = (JSPUtil.getParameter(request, prefix	+ "currency_code", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix	+ "country_code", length));
			String[] assetCodeCombinationId = (JSPUtil.getParameter(request, prefix	+ "asset_code_combination_id", length));
			String[] bankName = (JSPUtil.getParameter(request, prefix	+ "bank_name", length));
			String[] apControlOfficeCode = (JSPUtil.getParameter(request, prefix	+ "ap_control_office_code", length));
			String[] bankAcctMinor = (JSPUtil.getParameter(request, prefix	+ "bank_acct_minor", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bankNameAlt = (JSPUtil.getParameter(request, prefix	+ "bank_name_alt", length));
			String[] apOfficeCode = (JSPUtil.getParameter(request, prefix	+ "ap_office_code", length));
			String[] bankBranchSeq = (JSPUtil.getParameter(request, prefix	+ "bank_branch_seq", length));
			String[] bankBranchName = (JSPUtil.getParameter(request, prefix	+ "bank_branch_name", length));
			String[] bankAcctMajor = (JSPUtil.getParameter(request, prefix	+ "bank_acct_major", length));
			String[] bankBranchNameAlt = (JSPUtil.getParameter(request, prefix	+ "bank_branch_name_alt", length));
			String[] bankAcctMajorType = (JSPUtil.getParameter(request, prefix	+ "bank_acct_major_type", length));
			String[] arOfficeCode = (JSPUtil.getParameter(request, prefix	+ "ar_office_code", length));
			String[] arControlOfficeCode = (JSPUtil.getParameter(request, prefix	+ "ar_control_office_code", length));
			String[] bankAcctNumber = (JSPUtil.getParameter(request, prefix	+ "bank_acct_number", length));
			
			for (int i = 0; i < length; i++) {
				model = new InternalBankAcctVO();
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (bankAcctMinorType[i] != null)
					model.setBankAcctMinorType(bankAcctMinorType[i]);
				if (bankAcctName[i] != null)
					model.setBankAcctName(bankAcctName[i]);
				if (currencyCode[i] != null)
					model.setCurrencyCode(currencyCode[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (assetCodeCombinationId[i] != null)
					model.setAssetCodeCombinationId(assetCodeCombinationId[i]);
				if (bankName[i] != null)
					model.setBankName(bankName[i]);
				if (apControlOfficeCode[i] != null)
					model.setApControlOfficeCode(apControlOfficeCode[i]);
				if (bankAcctMinor[i] != null)
					model.setBankAcctMinor(bankAcctMinor[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bankNameAlt[i] != null)
					model.setBankNameAlt(bankNameAlt[i]);
				if (apOfficeCode[i] != null)
					model.setApOfficeCode(apOfficeCode[i]);
				if (bankBranchSeq[i] != null)
					model.setBankBranchSeq(bankBranchSeq[i]);
				if (bankBranchName[i] != null)
					model.setBankBranchName(bankBranchName[i]);
				if (bankAcctMajor[i] != null)
					model.setBankAcctMajor(bankAcctMajor[i]);
				if (bankBranchNameAlt[i] != null)
					model.setBankBranchNameAlt(bankBranchNameAlt[i]);
				if (bankAcctMajorType[i] != null)
					model.setBankAcctMajorType(bankAcctMajorType[i]);
				if (arOfficeCode[i] != null)
					model.setArOfficeCode(arOfficeCode[i]);
				if (arControlOfficeCode[i] != null)
					model.setArControlOfficeCode(arControlOfficeCode[i]);
				if (bankAcctNumber[i] != null)
					model.setBankAcctNumber(bankAcctNumber[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInternalBankAcctVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InternalBankAcctVO[]
	 */
	public InternalBankAcctVO[] getInternalBankAcctVOs(){
		InternalBankAcctVO[] vos = (InternalBankAcctVO[])models.toArray(new InternalBankAcctVO[models.size()]);
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
		this.bankAcctSeq = this.bankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctMinorType = this.bankAcctMinorType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctName = this.bankAcctName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currencyCode = this.currencyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assetCodeCombinationId = this.assetCodeCombinationId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankName = this.bankName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apControlOfficeCode = this.apControlOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctMinor = this.bankAcctMinor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNameAlt = this.bankNameAlt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfficeCode = this.apOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBranchSeq = this.bankBranchSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBranchName = this.bankBranchName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctMajor = this.bankAcctMajor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBranchNameAlt = this.bankBranchNameAlt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctMajorType = this.bankAcctMajorType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfficeCode = this.arOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arControlOfficeCode = this.arControlOfficeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNumber = this.bankAcctNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
