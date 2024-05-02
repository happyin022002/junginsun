/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentSlipListVO.java
*@FileTitle : PaymentSlipListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.14  
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

public class PaymentSlipListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentSlipListVO> models = new ArrayList<PaymentSlipListVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String payVoidDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String docSeq = null;
	/* Column Info */
	private String paySteNm = null;
	/* Column Info */
	private String paySeq = null;
	/* Column Info */
	private String payBatNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Column Info */
	private String payTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentSlipListVO() {}

	public PaymentSlipListVO(String ibflag, String pagerows, String paySeq, String payTpCd, String vndrNm, String vndrNo, String bankAcctNm, String docSeq, String payDt, String ofcCd, String currCd, String payAmt, String payMzdLuCd, String payVoidDt, String paySteNm, String payBatNm, String usrNm) {
		this.payDt = payDt;
		this.payVoidDt = payVoidDt;
		this.currCd = currCd;
		this.docSeq = docSeq;
		this.paySteNm = paySteNm;
		this.paySeq = paySeq;
		this.payBatNm = payBatNm;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.payMzdLuCd = payMzdLuCd;
		this.usrNm = usrNm;
		this.payAmt = payAmt;
		this.bankAcctNm = bankAcctNm;
		this.payTpCd = payTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("pay_void_dt", getPayVoidDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("doc_seq", getDocSeq());
		this.hashColumns.put("pay_ste_nm", getPaySteNm());
		this.hashColumns.put("pay_seq", getPaySeq());
		this.hashColumns.put("pay_bat_nm", getPayBatNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("pay_tp_cd", getPayTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("pay_void_dt", "payVoidDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("doc_seq", "docSeq");
		this.hashFields.put("pay_ste_nm", "paySteNm");
		this.hashFields.put("pay_seq", "paySeq");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("pay_tp_cd", "payTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return payVoidDt
	 */
	public String getPayVoidDt() {
		return this.payVoidDt;
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
	 * @return docSeq
	 */
	public String getDocSeq() {
		return this.docSeq;
	}
	
	/**
	 * Column Info
	 * @return paySteNm
	 */
	public String getPaySteNm() {
		return this.paySteNm;
	}
	
	/**
	 * Column Info
	 * @return paySeq
	 */
	public String getPaySeq() {
		return this.paySeq;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return bankAcctNm
	 */
	public String getBankAcctNm() {
		return this.bankAcctNm;
	}
	
	/**
	 * Column Info
	 * @return payTpCd
	 */
	public String getPayTpCd() {
		return this.payTpCd;
	}
	

	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param payVoidDt
	 */
	public void setPayVoidDt(String payVoidDt) {
		this.payVoidDt = payVoidDt;
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
	 * @param docSeq
	 */
	public void setDocSeq(String docSeq) {
		this.docSeq = docSeq;
	}
	
	/**
	 * Column Info
	 * @param paySteNm
	 */
	public void setPaySteNm(String paySteNm) {
		this.paySteNm = paySteNm;
	}
	
	/**
	 * Column Info
	 * @param paySeq
	 */
	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
	}
	
	/**
	 * Column Info
	 * @param payTpCd
	 */
	public void setPayTpCd(String payTpCd) {
		this.payTpCd = payTpCd;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setPayVoidDt(JSPUtil.getParameter(request, prefix + "pay_void_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDocSeq(JSPUtil.getParameter(request, prefix + "doc_seq", ""));
		setPaySteNm(JSPUtil.getParameter(request, prefix + "pay_ste_nm", ""));
		setPaySeq(JSPUtil.getParameter(request, prefix + "pay_seq", ""));
		setPayBatNm(JSPUtil.getParameter(request, prefix + "pay_bat_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setPayTpCd(JSPUtil.getParameter(request, prefix + "pay_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentSlipListVO[]
	 */
	public PaymentSlipListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentSlipListVO[]
	 */
	public PaymentSlipListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentSlipListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] payVoidDt = (JSPUtil.getParameter(request, prefix	+ "pay_void_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] docSeq = (JSPUtil.getParameter(request, prefix	+ "doc_seq", length));
			String[] paySteNm = (JSPUtil.getParameter(request, prefix	+ "pay_ste_nm", length));
			String[] paySeq = (JSPUtil.getParameter(request, prefix	+ "pay_seq", length));
			String[] payBatNm = (JSPUtil.getParameter(request, prefix	+ "pay_bat_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] payTpCd = (JSPUtil.getParameter(request, prefix	+ "pay_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentSlipListVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (payVoidDt[i] != null)
					model.setPayVoidDt(payVoidDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (docSeq[i] != null)
					model.setDocSeq(docSeq[i]);
				if (paySteNm[i] != null)
					model.setPaySteNm(paySteNm[i]);
				if (paySeq[i] != null)
					model.setPaySeq(paySeq[i]);
				if (payBatNm[i] != null)
					model.setPayBatNm(payBatNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (payTpCd[i] != null)
					model.setPayTpCd(payTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentSlipListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentSlipListVO[]
	 */
	public PaymentSlipListVO[] getPaymentSlipListVOs(){
		PaymentSlipListVO[] vos = (PaymentSlipListVO[])models.toArray(new PaymentSlipListVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVoidDt = this.payVoidDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docSeq = this.docSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySteNm = this.paySteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq = this.paySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm = this.payBatNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTpCd = this.payTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
