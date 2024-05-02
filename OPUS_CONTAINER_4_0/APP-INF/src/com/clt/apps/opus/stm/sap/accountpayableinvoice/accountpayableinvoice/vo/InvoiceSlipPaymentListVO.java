/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceSlipPaymentListVO.java
*@FileTitle : InvoiceSlipPaymentListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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

public class InvoiceSlipPaymentListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceSlipPaymentListVO> models = new ArrayList<InvoiceSlipPaymentListVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payNo = null;
	/* Column Info */
	private String docSeq = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String acctgPstFlg = null;
	/* Column Info */
	private String payTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceSlipPaymentListVO() {}

	public InvoiceSlipPaymentListVO(String ibflag, String pagerows, String bankAcctNo, String payNo, String payMzdLuCd, String payTpCd, String docSeq, String currCd, String payDt, String acctgPstFlg, String payAmt) {
		this.payDt = payDt;
		this.bankAcctNo = bankAcctNo;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.payNo = payNo;
		this.docSeq = docSeq;
		this.payMzdLuCd = payMzdLuCd;
		this.payAmt = payAmt;
		this.acctgPstFlg = acctgPstFlg;
		this.payTpCd = payTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_no", getPayNo());
		this.hashColumns.put("doc_seq", getDocSeq());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("acctg_pst_flg", getAcctgPstFlg());
		this.hashColumns.put("pay_tp_cd", getPayTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_no", "payNo");
		this.hashFields.put("doc_seq", "docSeq");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("acctg_pst_flg", "acctgPstFlg");
		this.hashFields.put("pay_tp_cd", "payTpCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return payNo
	 */
	public String getPayNo() {
		return this.payNo;
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
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return acctgPstFlg
	 */
	public String getAcctgPstFlg() {
		return this.acctgPstFlg;
	}
	
	/**
	 * Column Info
	 * @return payTpCd
	 */
	public String getPayTpCd() {
		return this.payTpCd;
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
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param payNo
	 */
	public void setPayNo(String payNo) {
		this.payNo = payNo;
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
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param acctgPstFlg
	 */
	public void setAcctgPstFlg(String acctgPstFlg) {
		this.acctgPstFlg = acctgPstFlg;
	}
	
	/**
	 * Column Info
	 * @param payTpCd
	 */
	public void setPayTpCd(String payTpCd) {
		this.payTpCd = payTpCd;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayNo(JSPUtil.getParameter(request, prefix + "pay_no", ""));
		setDocSeq(JSPUtil.getParameter(request, prefix + "doc_seq", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setAcctgPstFlg(JSPUtil.getParameter(request, prefix + "acctg_pst_flg", ""));
		setPayTpCd(JSPUtil.getParameter(request, prefix + "pay_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceSlipPaymentListVO[]
	 */
	public InvoiceSlipPaymentListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceSlipPaymentListVO[]
	 */
	public InvoiceSlipPaymentListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceSlipPaymentListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payNo = (JSPUtil.getParameter(request, prefix	+ "pay_no", length));
			String[] docSeq = (JSPUtil.getParameter(request, prefix	+ "doc_seq", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] acctgPstFlg = (JSPUtil.getParameter(request, prefix	+ "acctg_pst_flg", length));
			String[] payTpCd = (JSPUtil.getParameter(request, prefix	+ "pay_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceSlipPaymentListVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payNo[i] != null)
					model.setPayNo(payNo[i]);
				if (docSeq[i] != null)
					model.setDocSeq(docSeq[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (acctgPstFlg[i] != null)
					model.setAcctgPstFlg(acctgPstFlg[i]);
				if (payTpCd[i] != null)
					model.setPayTpCd(payTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceSlipPaymentListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceSlipPaymentListVO[]
	 */
	public InvoiceSlipPaymentListVO[] getInvoiceSlipPaymentListVOs(){
		InvoiceSlipPaymentListVO[] vos = (InvoiceSlipPaymentListVO[])models.toArray(new InvoiceSlipPaymentListVO[models.size()]);
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
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payNo = this.payNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docSeq = this.docSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgPstFlg = this.acctgPstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTpCd = this.payTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
