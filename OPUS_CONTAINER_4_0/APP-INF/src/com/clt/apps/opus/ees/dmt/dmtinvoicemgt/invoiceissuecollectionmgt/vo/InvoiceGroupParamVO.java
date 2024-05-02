/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceGroupParamVO.java
*@FileTitle : InvoiceGroupParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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

public class InvoiceGroupParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceGroupParamVO> models = new ArrayList<InvoiceGroupParamVO>();
	
	/* Column Info */
	private String payerCd = null;
	/* Column Info */
	private String invQty = null;
	/* Column Info */
	private String sGroupBy = null;
	/* Column Info */
	private String sChargeType = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String errCode = null;
	/* Column Info */
	private String totBilAmt = null;
	/* Column Info */
	private String issueDate = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String usrOfc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String backendjobId = null;
	/* Column Info */
	private String totTaxAmt = null;
	/* Column Info */
	private String payerNm = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String totPayableAmt = null;
	/* Column Info */
	private String usrName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceGroupParamVO() {}

	public InvoiceGroupParamVO(String ibflag, String pagerows, String invQty, String totBilAmt, String totTaxAmt, String totPayableAmt, String payerCd, String payerNm, String issueDate, String usrOfc, String invCurrCd, String usrName, String taxAmt, String sGroupBy, String sChargeType, String errCode, String errMsg, String backendjobId, String backendjobKey) {
		this.payerCd = payerCd;
		this.invQty = invQty;
		this.sGroupBy = sGroupBy;
		this.sChargeType = sChargeType;
		this.backendjobKey = backendjobKey;
		this.errCode = errCode;
		this.totBilAmt = totBilAmt;
		this.issueDate = issueDate;
		this.invCurrCd = invCurrCd;
		this.usrOfc = usrOfc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.backendjobId = backendjobId;
		this.totTaxAmt = totTaxAmt;
		this.payerNm = payerNm;
		this.errMsg = errMsg;
		this.totPayableAmt = totPayableAmt;
		this.usrName = usrName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("payer_cd", getPayerCd());
		this.hashColumns.put("inv_qty", getInvQty());
		this.hashColumns.put("s_group_by", getSGroupBy());
		this.hashColumns.put("s_charge_type", getSChargeType());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("tot_bil_amt", getTotBilAmt());
		this.hashColumns.put("issue_date", getIssueDate());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("usr_ofc", getUsrOfc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("backendjob_id", getBackendjobId());
		this.hashColumns.put("tot_tax_amt", getTotTaxAmt());
		this.hashColumns.put("payer_nm", getPayerNm());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("tot_payable_amt", getTotPayableAmt());
		this.hashColumns.put("usr_name", getUsrName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("payer_cd", "payerCd");
		this.hashFields.put("inv_qty", "invQty");
		this.hashFields.put("s_group_by", "sGroupBy");
		this.hashFields.put("s_charge_type", "sChargeType");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("tot_bil_amt", "totBilAmt");
		this.hashFields.put("issue_date", "issueDate");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("usr_ofc", "usrOfc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("backendjob_id", "backendjobId");
		this.hashFields.put("tot_tax_amt", "totTaxAmt");
		this.hashFields.put("payer_nm", "payerNm");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("tot_payable_amt", "totPayableAmt");
		this.hashFields.put("usr_name", "usrName");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payerCd
	 */
	public String getPayerCd() {
		return this.payerCd;
	}
	
	/**
	 * Column Info
	 * @return invQty
	 */
	public String getInvQty() {
		return this.invQty;
	}
	
	/**
	 * Column Info
	 * @return sGroupBy
	 */
	public String getSGroupBy() {
		return this.sGroupBy;
	}
	
	/**
	 * Column Info
	 * @return sChargeType
	 */
	public String getSChargeType() {
		return this.sChargeType;
	}
	
	/**
	 * Column Info
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
	}
	
	/**
	 * Column Info
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
	}
	
	/**
	 * Column Info
	 * @return totBilAmt
	 */
	public String getTotBilAmt() {
		return this.totBilAmt;
	}
	
	/**
	 * Column Info
	 * @return issueDate
	 */
	public String getIssueDate() {
		return this.issueDate;
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
	 * @return usrOfc
	 */
	public String getUsrOfc() {
		return this.usrOfc;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return backendjobId
	 */
	public String getBackendjobId() {
		return this.backendjobId;
	}
	
	/**
	 * Column Info
	 * @return totTaxAmt
	 */
	public String getTotTaxAmt() {
		return this.totTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return payerNm
	 */
	public String getPayerNm() {
		return this.payerNm;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return totPayableAmt
	 */
	public String getTotPayableAmt() {
		return this.totPayableAmt;
	}
	
	/**
	 * Column Info
	 * @return usrName
	 */
	public String getUsrName() {
		return this.usrName;
	}
	

	/**
	 * Column Info
	 * @param payerCd
	 */
	public void setPayerCd(String payerCd) {
		this.payerCd = payerCd;
	}
	
	/**
	 * Column Info
	 * @param invQty
	 */
	public void setInvQty(String invQty) {
		this.invQty = invQty;
	}
	
	/**
	 * Column Info
	 * @param sGroupBy
	 */
	public void setSGroupBy(String sGroupBy) {
		this.sGroupBy = sGroupBy;
	}
	
	/**
	 * Column Info
	 * @param sChargeType
	 */
	public void setSChargeType(String sChargeType) {
		this.sChargeType = sChargeType;
	}
	
	/**
	 * Column Info
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	/**
	 * Column Info
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	/**
	 * Column Info
	 * @param totBilAmt
	 */
	public void setTotBilAmt(String totBilAmt) {
		this.totBilAmt = totBilAmt;
	}
	
	/**
	 * Column Info
	 * @param issueDate
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
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
	 * @param usrOfc
	 */
	public void setUsrOfc(String usrOfc) {
		this.usrOfc = usrOfc;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param backendjobId
	 */
	public void setBackendjobId(String backendjobId) {
		this.backendjobId = backendjobId;
	}
	
	/**
	 * Column Info
	 * @param totTaxAmt
	 */
	public void setTotTaxAmt(String totTaxAmt) {
		this.totTaxAmt = totTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param payerNm
	 */
	public void setPayerNm(String payerNm) {
		this.payerNm = payerNm;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param totPayableAmt
	 */
	public void setTotPayableAmt(String totPayableAmt) {
		this.totPayableAmt = totPayableAmt;
	}
	
	/**
	 * Column Info
	 * @param usrName
	 */
	public void setUsrName(String usrName) {
		this.usrName = usrName;
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
		setPayerCd(JSPUtil.getParameter(request, prefix + "payer_cd", ""));
		setInvQty(JSPUtil.getParameter(request, prefix + "inv_qty", ""));
		setSGroupBy(JSPUtil.getParameter(request, prefix + "s_group_by", ""));
		setSChargeType(JSPUtil.getParameter(request, prefix + "s_charge_type", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
		setTotBilAmt(JSPUtil.getParameter(request, prefix + "tot_bil_amt", ""));
		setIssueDate(JSPUtil.getParameter(request, prefix + "issue_date", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setUsrOfc(JSPUtil.getParameter(request, prefix + "usr_ofc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setBackendjobId(JSPUtil.getParameter(request, prefix + "backendjob_id", ""));
		setTotTaxAmt(JSPUtil.getParameter(request, prefix + "tot_tax_amt", ""));
		setPayerNm(JSPUtil.getParameter(request, prefix + "payer_nm", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setTotPayableAmt(JSPUtil.getParameter(request, prefix + "tot_payable_amt", ""));
		setUsrName(JSPUtil.getParameter(request, prefix + "usr_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceGroupParamVO[]
	 */
	public InvoiceGroupParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceGroupParamVO[]
	 */
	public InvoiceGroupParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceGroupParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payerCd = (JSPUtil.getParameter(request, prefix	+ "payer_cd", length));
			String[] invQty = (JSPUtil.getParameter(request, prefix	+ "inv_qty", length));
			String[] sGroupBy = (JSPUtil.getParameter(request, prefix	+ "s_group_by", length));
			String[] sChargeType = (JSPUtil.getParameter(request, prefix	+ "s_charge_type", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] totBilAmt = (JSPUtil.getParameter(request, prefix	+ "tot_bil_amt", length));
			String[] issueDate = (JSPUtil.getParameter(request, prefix	+ "issue_date", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] usrOfc = (JSPUtil.getParameter(request, prefix	+ "usr_ofc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] backendjobId = (JSPUtil.getParameter(request, prefix	+ "backendjob_id", length));
			String[] totTaxAmt = (JSPUtil.getParameter(request, prefix	+ "tot_tax_amt", length));
			String[] payerNm = (JSPUtil.getParameter(request, prefix	+ "payer_nm", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] totPayableAmt = (JSPUtil.getParameter(request, prefix	+ "tot_payable_amt", length));
			String[] usrName = (JSPUtil.getParameter(request, prefix	+ "usr_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceGroupParamVO();
				if (payerCd[i] != null)
					model.setPayerCd(payerCd[i]);
				if (invQty[i] != null)
					model.setInvQty(invQty[i]);
				if (sGroupBy[i] != null)
					model.setSGroupBy(sGroupBy[i]);
				if (sChargeType[i] != null)
					model.setSChargeType(sChargeType[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (totBilAmt[i] != null)
					model.setTotBilAmt(totBilAmt[i]);
				if (issueDate[i] != null)
					model.setIssueDate(issueDate[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (usrOfc[i] != null)
					model.setUsrOfc(usrOfc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (backendjobId[i] != null)
					model.setBackendjobId(backendjobId[i]);
				if (totTaxAmt[i] != null)
					model.setTotTaxAmt(totTaxAmt[i]);
				if (payerNm[i] != null)
					model.setPayerNm(payerNm[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (totPayableAmt[i] != null)
					model.setTotPayableAmt(totPayableAmt[i]);
				if (usrName[i] != null)
					model.setUsrName(usrName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceGroupParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceGroupParamVO[]
	 */
	public InvoiceGroupParamVO[] getInvoiceGroupParamVOs(){
		InvoiceGroupParamVO[] vos = (InvoiceGroupParamVO[])models.toArray(new InvoiceGroupParamVO[models.size()]);
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
		this.payerCd = this.payerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invQty = this.invQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroupBy = this.sGroupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChargeType = this.sChargeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBilAmt = this.totBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDate = this.issueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfc = this.usrOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobId = this.backendjobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTaxAmt = this.totTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerNm = this.payerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totPayableAmt = this.totPayableAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrName = this.usrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
