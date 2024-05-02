/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentPossibleInvoiceListVO.java
*@FileTitle : PaymentPossibleInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24  
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

public class PaymentPossibleInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentPossibleInvoiceListVO> models = new ArrayList<PaymentPossibleInvoiceListVO>();
	
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String payBatNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String payCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String payBatSeq = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentPossibleInvoiceListVO() {}

	public PaymentPossibleInvoiceListVO(String ibflag, String pagerows, String invNo, String invSeq, String invDt, String vndrNo, String vndrLglEngNm, String payCurrCd, String invAmt, String dueDt, String invDesc, String payAmt, String bankAcctNo, String payBatSeq, String payBatNm) {
		this.bankAcctNo = bankAcctNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.invSeq = invSeq;
		this.payBatNm = payBatNm;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.payCurrCd = payCurrCd;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.invDesc = invDesc;
		this.payBatSeq = payBatSeq;
		this.payAmt = payAmt;
		this.invAmt = invAmt;
		this.dueDt = dueDt;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pay_bat_nm", getPayBatNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("pay_bat_seq", getPayBatSeq());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("pay_bat_seq", "payBatSeq");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return payBatNm
	 */
	public String getPayBatNm() {
		return this.payBatNm;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return payCurrCd
	 */
	public String getPayCurrCd() {
		return this.payCurrCd;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return payBatSeq
	 */
	public String getPayBatSeq() {
		return this.payBatSeq;
	}
	
	/**
	 * Column Info
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param payBatNm
	 */
	public void setPayBatNm(String payBatNm) {
		this.payBatNm = payBatNm;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param payCurrCd
	 */
	public void setPayCurrCd(String payCurrCd) {
		this.payCurrCd = payCurrCd;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param payBatSeq
	 */
	public void setPayBatSeq(String payBatSeq) {
		this.payBatSeq = payBatSeq;
	}
	
	/**
	 * Column Info
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPayBatNm(JSPUtil.getParameter(request, prefix + "pay_bat_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setPayCurrCd(JSPUtil.getParameter(request, prefix + "pay_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setPayBatSeq(JSPUtil.getParameter(request, prefix + "pay_bat_seq", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentPossibleInvoiceListVO[]
	 */
	public PaymentPossibleInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentPossibleInvoiceListVO[]
	 */
	public PaymentPossibleInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentPossibleInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] payBatNm = (JSPUtil.getParameter(request, prefix	+ "pay_bat_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] payCurrCd = (JSPUtil.getParameter(request, prefix	+ "pay_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] payBatSeq = (JSPUtil.getParameter(request, prefix	+ "pay_bat_seq", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentPossibleInvoiceListVO();
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (payBatNm[i] != null)
					model.setPayBatNm(payBatNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (payCurrCd[i] != null)
					model.setPayCurrCd(payCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (payBatSeq[i] != null)
					model.setPayBatSeq(payBatSeq[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentPossibleInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentPossibleInvoiceListVO[]
	 */
	public PaymentPossibleInvoiceListVO[] getPaymentPossibleInvoiceListVOs(){
		PaymentPossibleInvoiceListVO[] vos = (PaymentPossibleInvoiceListVO[])models.toArray(new PaymentPossibleInvoiceListVO[models.size()]);
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
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm = this.payBatNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd = this.payCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatSeq = this.payBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
