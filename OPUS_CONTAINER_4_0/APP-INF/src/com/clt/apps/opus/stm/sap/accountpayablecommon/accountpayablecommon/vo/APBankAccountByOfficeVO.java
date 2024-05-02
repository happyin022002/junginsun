/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APBankAccountByOfficeVO.java
*@FileTitle : APBankAccountByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.01  
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

public class APBankAccountByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APBankAccountByOfficeVO> models = new ArrayList<APBankAccountByOfficeVO>();
	
	/* Column Info */
	private String apCtrlOfcCd = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String bankAcctTpSubNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String depositDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String opnOfcCd = null;
	/* Column Info */
	private String limitAmount = null;
	/* Column Info */
	private String inactDt = null;
	/* Column Info */
	private String bankBrncNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String accountHolder = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String bankAcctStDt = null;
	/* Column Info */
	private String bankAcctTpMnNm = null;
	/* Column Info */
	private String bankAcctNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APBankAccountByOfficeVO() {}

	public APBankAccountByOfficeVO(String ibflag, String pagerows, String opnOfcCd, String depositDiv, String bankAcctTpMnNm, String bankAcctTpSubNm, String bankAcctNm, String accountHolder, String bankNm, String bankBrncNm, String bankAcctNo, String currCd, String bankAcctStDt, String inactDt, String apCtrlOfcCd, String limitAmount) {
		this.apCtrlOfcCd = apCtrlOfcCd;
		this.bankAcctNo = bankAcctNo;
		this.bankAcctTpSubNm = bankAcctTpSubNm;
		this.currCd = currCd;
		this.depositDiv = depositDiv;
		this.pagerows = pagerows;
		this.opnOfcCd = opnOfcCd;
		this.limitAmount = limitAmount;
		this.inactDt = inactDt;
		this.bankBrncNm = bankBrncNm;
		this.ibflag = ibflag;
		this.accountHolder = accountHolder;
		this.bankNm = bankNm;
		this.bankAcctStDt = bankAcctStDt;
		this.bankAcctTpMnNm = bankAcctTpMnNm;
		this.bankAcctNm = bankAcctNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("bank_acct_tp_sub_nm", getBankAcctTpSubNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("deposit_div", getDepositDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("opn_ofc_cd", getOpnOfcCd());
		this.hashColumns.put("limit_amount", getLimitAmount());
		this.hashColumns.put("inact_dt", getInactDt());
		this.hashColumns.put("bank_brnc_nm", getBankBrncNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("account_holder", getAccountHolder());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("bank_acct_st_dt", getBankAcctStDt());
		this.hashColumns.put("bank_acct_tp_mn_nm", getBankAcctTpMnNm());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("bank_acct_tp_sub_nm", "bankAcctTpSubNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("deposit_div", "depositDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("opn_ofc_cd", "opnOfcCd");
		this.hashFields.put("limit_amount", "limitAmount");
		this.hashFields.put("inact_dt", "inactDt");
		this.hashFields.put("bank_brnc_nm", "bankBrncNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("account_holder", "accountHolder");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("bank_acct_st_dt", "bankAcctStDt");
		this.hashFields.put("bank_acct_tp_mn_nm", "bankAcctTpMnNm");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apCtrlOfcCd
	 */
	public String getApCtrlOfcCd() {
		return this.apCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpSubNm
	 */
	public String getBankAcctTpSubNm() {
		return this.bankAcctTpSubNm;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return depositDiv
	 */
	public String getDepositDiv() {
		return this.depositDiv;
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
	 * @return opnOfcCd
	 */
	public String getOpnOfcCd() {
		return this.opnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return limitAmount
	 */
	public String getLimitAmount() {
		return this.limitAmount;
	}
	
	/**
	 * Column Info
	 * @return inactDt
	 */
	public String getInactDt() {
		return this.inactDt;
	}
	
	/**
	 * Column Info
	 * @return bankBrncNm
	 */
	public String getBankBrncNm() {
		return this.bankBrncNm;
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
	 * @return accountHolder
	 */
	public String getAccountHolder() {
		return this.accountHolder;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return bankAcctStDt
	 */
	public String getBankAcctStDt() {
		return this.bankAcctStDt;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpMnNm
	 */
	public String getBankAcctTpMnNm() {
		return this.bankAcctTpMnNm;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNm
	 */
	public String getBankAcctNm() {
		return this.bankAcctNm;
	}
	

	/**
	 * Column Info
	 * @param apCtrlOfcCd
	 */
	public void setApCtrlOfcCd(String apCtrlOfcCd) {
		this.apCtrlOfcCd = apCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpSubNm
	 */
	public void setBankAcctTpSubNm(String bankAcctTpSubNm) {
		this.bankAcctTpSubNm = bankAcctTpSubNm;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param depositDiv
	 */
	public void setDepositDiv(String depositDiv) {
		this.depositDiv = depositDiv;
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
	 * @param opnOfcCd
	 */
	public void setOpnOfcCd(String opnOfcCd) {
		this.opnOfcCd = opnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param limitAmount
	 */
	public void setLimitAmount(String limitAmount) {
		this.limitAmount = limitAmount;
	}
	
	/**
	 * Column Info
	 * @param inactDt
	 */
	public void setInactDt(String inactDt) {
		this.inactDt = inactDt;
	}
	
	/**
	 * Column Info
	 * @param bankBrncNm
	 */
	public void setBankBrncNm(String bankBrncNm) {
		this.bankBrncNm = bankBrncNm;
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
	 * @param accountHolder
	 */
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param bankAcctStDt
	 */
	public void setBankAcctStDt(String bankAcctStDt) {
		this.bankAcctStDt = bankAcctStDt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpMnNm
	 */
	public void setBankAcctTpMnNm(String bankAcctTpMnNm) {
		this.bankAcctTpMnNm = bankAcctTpMnNm;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
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
		setApCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ap_ctrl_ofc_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setBankAcctTpSubNm(JSPUtil.getParameter(request, prefix + "bank_acct_tp_sub_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDepositDiv(JSPUtil.getParameter(request, prefix + "deposit_div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOpnOfcCd(JSPUtil.getParameter(request, prefix + "opn_ofc_cd", ""));
		setLimitAmount(JSPUtil.getParameter(request, prefix + "limit_amount", ""));
		setInactDt(JSPUtil.getParameter(request, prefix + "inact_dt", ""));
		setBankBrncNm(JSPUtil.getParameter(request, prefix + "bank_brnc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAccountHolder(JSPUtil.getParameter(request, prefix + "account_holder", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setBankAcctStDt(JSPUtil.getParameter(request, prefix + "bank_acct_st_dt", ""));
		setBankAcctTpMnNm(JSPUtil.getParameter(request, prefix + "bank_acct_tp_mn_nm", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APBankAccountByOfficeVO[]
	 */
	public APBankAccountByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APBankAccountByOfficeVO[]
	 */
	public APBankAccountByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APBankAccountByOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctrl_ofc_cd", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] bankAcctTpSubNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_sub_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] depositDiv = (JSPUtil.getParameter(request, prefix	+ "deposit_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] opnOfcCd = (JSPUtil.getParameter(request, prefix	+ "opn_ofc_cd", length));
			String[] limitAmount = (JSPUtil.getParameter(request, prefix	+ "limit_amount", length));
			String[] inactDt = (JSPUtil.getParameter(request, prefix	+ "inact_dt", length));
			String[] bankBrncNm = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] accountHolder = (JSPUtil.getParameter(request, prefix	+ "account_holder", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] bankAcctStDt = (JSPUtil.getParameter(request, prefix	+ "bank_acct_st_dt", length));
			String[] bankAcctTpMnNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_mn_nm", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new APBankAccountByOfficeVO();
				if (apCtrlOfcCd[i] != null)
					model.setApCtrlOfcCd(apCtrlOfcCd[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (bankAcctTpSubNm[i] != null)
					model.setBankAcctTpSubNm(bankAcctTpSubNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (depositDiv[i] != null)
					model.setDepositDiv(depositDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (opnOfcCd[i] != null)
					model.setOpnOfcCd(opnOfcCd[i]);
				if (limitAmount[i] != null)
					model.setLimitAmount(limitAmount[i]);
				if (inactDt[i] != null)
					model.setInactDt(inactDt[i]);
				if (bankBrncNm[i] != null)
					model.setBankBrncNm(bankBrncNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (accountHolder[i] != null)
					model.setAccountHolder(accountHolder[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (bankAcctStDt[i] != null)
					model.setBankAcctStDt(bankAcctStDt[i]);
				if (bankAcctTpMnNm[i] != null)
					model.setBankAcctTpMnNm(bankAcctTpMnNm[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPBankAccountByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APBankAccountByOfficeVO[]
	 */
	public APBankAccountByOfficeVO[] getAPBankAccountByOfficeVOs(){
		APBankAccountByOfficeVO[] vos = (APBankAccountByOfficeVO[])models.toArray(new APBankAccountByOfficeVO[models.size()]);
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
		this.apCtrlOfcCd = this.apCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpSubNm = this.bankAcctTpSubNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depositDiv = this.depositDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnOfcCd = this.opnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.limitAmount = this.limitAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactDt = this.inactDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncNm = this.bankBrncNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountHolder = this.accountHolder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctStDt = this.bankAcctStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpMnNm = this.bankAcctTpMnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
