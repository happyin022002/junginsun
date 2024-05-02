/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BankBalanceByOfficeCondVO.java
*@FileTitle : BankBalanceByOfficeCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.07  
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

public class BankBalanceByOfficeCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BankBalanceByOfficeCondVO> models = new ArrayList<BankBalanceByOfficeCondVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ctrlOfc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bankAcctTpSubCd = null;
	/* Column Info */
	private String bankStmtDt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String bankAcctTpMnCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BankBalanceByOfficeCondVO() {}

	public BankBalanceByOfficeCondVO(String ibflag, String pagerows, String ctrlOfc, String ofcCd, String bankStmtDt, String invCurrCd, String bankAcctTpMnCd, String bankAcctTpSubCd) {
		this.ofcCd = ofcCd;
		this.ctrlOfc = ctrlOfc;
		this.ibflag = ibflag;
		this.bankAcctTpSubCd = bankAcctTpSubCd;
		this.bankStmtDt = bankStmtDt;
		this.invCurrCd = invCurrCd;
		this.bankAcctTpMnCd = bankAcctTpMnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ctrl_ofc", getCtrlOfc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bank_acct_tp_sub_cd", getBankAcctTpSubCd());
		this.hashColumns.put("bank_stmt_dt", getBankStmtDt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("bank_acct_tp_mn_cd", getBankAcctTpMnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ctrl_ofc", "ctrlOfc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bank_acct_tp_sub_cd", "bankAcctTpSubCd");
		this.hashFields.put("bank_stmt_dt", "bankStmtDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("bank_acct_tp_mn_cd", "bankAcctTpMnCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfc
	 */
	public String getCtrlOfc() {
		return this.ctrlOfc;
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
	 * @return bankAcctTpSubCd
	 */
	public String getBankAcctTpSubCd() {
		return this.bankAcctTpSubCd;
	}
	
	/**
	 * Column Info
	 * @return bankStmtDt
	 */
	public String getBankStmtDt() {
		return this.bankStmtDt;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpMnCd
	 */
	public String getBankAcctTpMnCd() {
		return this.bankAcctTpMnCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfc
	 */
	public void setCtrlOfc(String ctrlOfc) {
		this.ctrlOfc = ctrlOfc;
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
	 * @param bankAcctTpSubCd
	 */
	public void setBankAcctTpSubCd(String bankAcctTpSubCd) {
		this.bankAcctTpSubCd = bankAcctTpSubCd;
	}
	
	/**
	 * Column Info
	 * @param bankStmtDt
	 */
	public void setBankStmtDt(String bankStmtDt) {
		this.bankStmtDt = bankStmtDt;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpMnCd
	 */
	public void setBankAcctTpMnCd(String bankAcctTpMnCd) {
		this.bankAcctTpMnCd = bankAcctTpMnCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCtrlOfc(JSPUtil.getParameter(request, prefix + "ctrl_ofc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBankAcctTpSubCd(JSPUtil.getParameter(request, prefix + "bank_acct_tp_sub_cd", ""));
		setBankStmtDt(JSPUtil.getParameter(request, prefix + "bank_stmt_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setBankAcctTpMnCd(JSPUtil.getParameter(request, prefix + "bank_acct_tp_mn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankBalanceByOfficeCondVO[]
	 */
	public BankBalanceByOfficeCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BankBalanceByOfficeCondVO[]
	 */
	public BankBalanceByOfficeCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BankBalanceByOfficeCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ctrlOfc = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bankAcctTpSubCd = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_sub_cd", length));
			String[] bankStmtDt = (JSPUtil.getParameter(request, prefix	+ "bank_stmt_dt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] bankAcctTpMnCd = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_mn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BankBalanceByOfficeCondVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ctrlOfc[i] != null)
					model.setCtrlOfc(ctrlOfc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bankAcctTpSubCd[i] != null)
					model.setBankAcctTpSubCd(bankAcctTpSubCd[i]);
				if (bankStmtDt[i] != null)
					model.setBankStmtDt(bankStmtDt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (bankAcctTpMnCd[i] != null)
					model.setBankAcctTpMnCd(bankAcctTpMnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBankBalanceByOfficeCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BankBalanceByOfficeCondVO[]
	 */
	public BankBalanceByOfficeCondVO[] getBankBalanceByOfficeCondVOs(){
		BankBalanceByOfficeCondVO[] vos = (BankBalanceByOfficeCondVO[])models.toArray(new BankBalanceByOfficeCondVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfc = this.ctrlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpSubCd = this.bankAcctTpSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtDt = this.bankStmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpMnCd = this.bankAcctTpMnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
