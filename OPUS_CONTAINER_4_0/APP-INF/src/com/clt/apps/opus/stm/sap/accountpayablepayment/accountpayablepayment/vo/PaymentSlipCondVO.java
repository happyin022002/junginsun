/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentSlipCondVO.java
*@FileTitle : PaymentSlipCondVO
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

public class PaymentSlipCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentSlipCondVO> models = new ArrayList<PaymentSlipCondVO>();
	
	/* Column Info */
	private String vndrPayGrpCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String docSeq = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String payDtTo = null;
	/* Column Info */
	private String currTp = null;
	/* Column Info */
	private String payDtFr = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Column Info */
	private String payBatNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentSlipCondVO() {}

	public PaymentSlipCondVO(String ibflag, String pagerows, String ofcCd, String payDtFr, String payDtTo, String currTp, String vndrPayGrpCd, String payBatNm, String payMzdLuCd, String vndrNo, String bankAcctNm, String docSeq) {
		this.vndrPayGrpCd = vndrPayGrpCd;
		this.ofcCd = ofcCd;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.docSeq = docSeq;
		this.payMzdLuCd = payMzdLuCd;
		this.payDtTo = payDtTo;
		this.currTp = currTp;
		this.payDtFr = payDtFr;
		this.bankAcctNm = bankAcctNm;
		this.payBatNm = payBatNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_pay_grp_cd", getVndrPayGrpCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("doc_seq", getDocSeq());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("pay_dt_to", getPayDtTo());
		this.hashColumns.put("curr_tp", getCurrTp());
		this.hashColumns.put("pay_dt_fr", getPayDtFr());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("pay_bat_nm", getPayBatNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_pay_grp_cd", "vndrPayGrpCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("doc_seq", "docSeq");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("pay_dt_to", "payDtTo");
		this.hashFields.put("curr_tp", "currTp");
		this.hashFields.put("pay_dt_fr", "payDtFr");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrPayGrpCd
	 */
	public String getVndrPayGrpCd() {
		return this.vndrPayGrpCd;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return docSeq
	 */
	public String getDocSeq() {
		return this.docSeq;
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
	 * @return payDtTo
	 */
	public String getPayDtTo() {
		return this.payDtTo;
	}
	
	/**
	 * Column Info
	 * @return currTp
	 */
	public String getCurrTp() {
		return this.currTp;
	}
	
	/**
	 * Column Info
	 * @return payDtFr
	 */
	public String getPayDtFr() {
		return this.payDtFr;
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
	 * @param vndrPayGrpCd
	 */
	public void setVndrPayGrpCd(String vndrPayGrpCd) {
		this.vndrPayGrpCd = vndrPayGrpCd;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param docSeq
	 */
	public void setDocSeq(String docSeq) {
		this.docSeq = docSeq;
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
	 * @param payDtTo
	 */
	public void setPayDtTo(String payDtTo) {
		this.payDtTo = payDtTo;
	}
	
	/**
	 * Column Info
	 * @param currTp
	 */
	public void setCurrTp(String currTp) {
		this.currTp = currTp;
	}
	
	/**
	 * Column Info
	 * @param payDtFr
	 */
	public void setPayDtFr(String payDtFr) {
		this.payDtFr = payDtFr;
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
		setVndrPayGrpCd(JSPUtil.getParameter(request, prefix + "vndr_pay_grp_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDocSeq(JSPUtil.getParameter(request, prefix + "doc_seq", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setPayDtTo(JSPUtil.getParameter(request, prefix + "pay_dt_to", ""));
		setCurrTp(JSPUtil.getParameter(request, prefix + "curr_tp", ""));
		setPayDtFr(JSPUtil.getParameter(request, prefix + "pay_dt_fr", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setPayBatNm(JSPUtil.getParameter(request, prefix + "pay_bat_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentSlipCondVO[]
	 */
	public PaymentSlipCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentSlipCondVO[]
	 */
	public PaymentSlipCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentSlipCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrPayGrpCd = (JSPUtil.getParameter(request, prefix	+ "vndr_pay_grp_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] docSeq = (JSPUtil.getParameter(request, prefix	+ "doc_seq", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] payDtTo = (JSPUtil.getParameter(request, prefix	+ "pay_dt_to", length));
			String[] currTp = (JSPUtil.getParameter(request, prefix	+ "curr_tp", length));
			String[] payDtFr = (JSPUtil.getParameter(request, prefix	+ "pay_dt_fr", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] payBatNm = (JSPUtil.getParameter(request, prefix	+ "pay_bat_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentSlipCondVO();
				if (vndrPayGrpCd[i] != null)
					model.setVndrPayGrpCd(vndrPayGrpCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (docSeq[i] != null)
					model.setDocSeq(docSeq[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (payDtTo[i] != null)
					model.setPayDtTo(payDtTo[i]);
				if (currTp[i] != null)
					model.setCurrTp(currTp[i]);
				if (payDtFr[i] != null)
					model.setPayDtFr(payDtFr[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (payBatNm[i] != null)
					model.setPayBatNm(payBatNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentSlipCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentSlipCondVO[]
	 */
	public PaymentSlipCondVO[] getPaymentSlipCondVOs(){
		PaymentSlipCondVO[] vos = (PaymentSlipCondVO[])models.toArray(new PaymentSlipCondVO[models.size()]);
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
		this.vndrPayGrpCd = this.vndrPayGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docSeq = this.docSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtTo = this.payDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currTp = this.currTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDtFr = this.payDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm = this.payBatNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
