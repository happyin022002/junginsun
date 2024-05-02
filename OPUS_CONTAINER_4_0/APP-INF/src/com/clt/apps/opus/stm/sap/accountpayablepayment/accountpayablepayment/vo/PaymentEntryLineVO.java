/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentEntryLineVO.java
*@FileTitle : PaymentEntryLineVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.25 차상영 
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
 * @author 차상영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PaymentEntryLineVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentEntryLineVO> models = new ArrayList<PaymentEntryLineVO>();
	
	/* Column Info */
	private String xterBankAcctSeq = null;
	/* Column Info */
	private String paySkdNo = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String paySeq = null;
	/* Column Info */
	private String acctgDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String liabCdCmbSeq = null;
	/* Column Info */
	private String invPaySeq = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String payFuncAmt = null;
	/* Column Info */
	private String remitVndrNo = null;
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentEntryLineVO() {}

	public PaymentEntryLineVO(String ibflag, String pagerows, String invPaySeq, String paySeq, String invNo, String invDt, String invAmt, String acctgDt, String invDesc, String payAmt, String payFuncAmt, String liabCdCmbSeq, String xterBankAcctSeq, String remitVndrNo, String paySkdNo, String invSeq, String usrId) {
		this.xterBankAcctSeq = xterBankAcctSeq;
		this.paySkdNo = paySkdNo;
		this.invSeq = invSeq;
		this.paySeq = paySeq;
		this.acctgDt = acctgDt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.invDesc = invDesc;
		this.usrId = usrId;
		this.payAmt = payAmt;
		this.liabCdCmbSeq = liabCdCmbSeq;
		this.invPaySeq = invPaySeq;
		this.invAmt = invAmt;
		this.payFuncAmt = payFuncAmt;
		this.remitVndrNo = remitVndrNo;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());
		this.hashColumns.put("pay_skd_no", getPaySkdNo());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("pay_seq", getPaySeq());
		this.hashColumns.put("acctg_dt", getAcctgDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());
		this.hashColumns.put("inv_pay_seq", getInvPaySeq());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("pay_func_amt", getPayFuncAmt());
		this.hashColumns.put("remit_vndr_no", getRemitVndrNo());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("pay_skd_no", "paySkdNo");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pay_seq", "paySeq");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("inv_pay_seq", "invPaySeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("pay_func_amt", "payFuncAmt");
		this.hashFields.put("remit_vndr_no", "remitVndrNo");
		this.hashFields.put("inv_dt", "invDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xterBankAcctSeq
	 */
	public String getXterBankAcctSeq() {
		return this.xterBankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @return paySkdNo
	 */
	public String getPaySkdNo() {
		return this.paySkdNo;
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
	 * @return paySeq
	 */
	public String getPaySeq() {
		return this.paySeq;
	}
	
	/**
	 * Column Info
	 * @return acctgDt
	 */
	public String getAcctgDt() {
		return this.acctgDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return liabCdCmbSeq
	 */
	public String getLiabCdCmbSeq() {
		return this.liabCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return invPaySeq
	 */
	public String getInvPaySeq() {
		return this.invPaySeq;
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
	 * @return payFuncAmt
	 */
	public String getPayFuncAmt() {
		return this.payFuncAmt;
	}
	
	/**
	 * Column Info
	 * @return remitVndrNo
	 */
	public String getRemitVndrNo() {
		return this.remitVndrNo;
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
	 * @param xterBankAcctSeq
	 */
	public void setXterBankAcctSeq(String xterBankAcctSeq) {
		this.xterBankAcctSeq = xterBankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @param paySkdNo
	 */
	public void setPaySkdNo(String paySkdNo) {
		this.paySkdNo = paySkdNo;
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
	 * @param paySeq
	 */
	public void setPaySeq(String paySeq) {
		this.paySeq = paySeq;
	}
	
	/**
	 * Column Info
	 * @param acctgDt
	 */
	public void setAcctgDt(String acctgDt) {
		this.acctgDt = acctgDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param liabCdCmbSeq
	 */
	public void setLiabCdCmbSeq(String liabCdCmbSeq) {
		this.liabCdCmbSeq = liabCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param invPaySeq
	 */
	public void setInvPaySeq(String invPaySeq) {
		this.invPaySeq = invPaySeq;
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
	 * @param payFuncAmt
	 */
	public void setPayFuncAmt(String payFuncAmt) {
		this.payFuncAmt = payFuncAmt;
	}
	
	/**
	 * Column Info
	 * @param remitVndrNo
	 */
	public void setRemitVndrNo(String remitVndrNo) {
		this.remitVndrNo = remitVndrNo;
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
		setXterBankAcctSeq(JSPUtil.getParameter(request, prefix + "xter_bank_acct_seq", ""));
		setPaySkdNo(JSPUtil.getParameter(request, prefix + "pay_skd_no", ""));
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setPaySeq(JSPUtil.getParameter(request, prefix + "pay_seq", ""));
		setAcctgDt(JSPUtil.getParameter(request, prefix + "acctg_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request, prefix + "liab_cd_cmb_seq", ""));
		setInvPaySeq(JSPUtil.getParameter(request, prefix + "inv_pay_seq", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setPayFuncAmt(JSPUtil.getParameter(request, prefix + "pay_func_amt", ""));
		setRemitVndrNo(JSPUtil.getParameter(request, prefix + "remit_vndr_no", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentEntryLineVO[]
	 */
	public PaymentEntryLineVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentEntryLineVO[]
	 */
	public PaymentEntryLineVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentEntryLineVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xterBankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "xter_bank_acct_seq", length));
			String[] paySkdNo = (JSPUtil.getParameter(request, prefix	+ "pay_skd_no", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] paySeq = (JSPUtil.getParameter(request, prefix	+ "pay_seq", length));
			String[] acctgDt = (JSPUtil.getParameter(request, prefix	+ "acctg_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] liabCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "liab_cd_cmb_seq", length));
			String[] invPaySeq = (JSPUtil.getParameter(request, prefix	+ "inv_pay_seq", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] payFuncAmt = (JSPUtil.getParameter(request, prefix	+ "pay_func_amt", length));
			String[] remitVndrNo = (JSPUtil.getParameter(request, prefix	+ "remit_vndr_no", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentEntryLineVO();
				if (xterBankAcctSeq[i] != null)
					model.setXterBankAcctSeq(xterBankAcctSeq[i]);
				if (paySkdNo[i] != null)
					model.setPaySkdNo(paySkdNo[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (paySeq[i] != null)
					model.setPaySeq(paySeq[i]);
				if (acctgDt[i] != null)
					model.setAcctgDt(acctgDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (liabCdCmbSeq[i] != null)
					model.setLiabCdCmbSeq(liabCdCmbSeq[i]);
				if (invPaySeq[i] != null)
					model.setInvPaySeq(invPaySeq[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (payFuncAmt[i] != null)
					model.setPayFuncAmt(payFuncAmt[i]);
				if (remitVndrNo[i] != null)
					model.setRemitVndrNo(remitVndrNo[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentEntryLineVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentEntryLineVO[]
	 */
	public PaymentEntryLineVO[] getPaymentEntryLineVOs(){
		PaymentEntryLineVO[] vos = (PaymentEntryLineVO[])models.toArray(new PaymentEntryLineVO[models.size()]);
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
		this.xterBankAcctSeq = this.xterBankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySkdNo = this.paySkdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq = this.paySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt = this.acctgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq = this.liabCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPaySeq = this.invPaySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payFuncAmt = this.payFuncAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitVndrNo = this.remitVndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
