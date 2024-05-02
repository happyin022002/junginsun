/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentDetailCurrSumListVO.java
*@FileTitle : PaymentDetailCurrSumListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.26
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.03.26 차상영 
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

public class PaymentDetailCurrSumListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentDetailCurrSumListVO> models = new ArrayList<PaymentDetailCurrSumListVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String fromPayDt = null;
	/* Column Info */
	private String toPayDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentDetailCurrSumListVO() {}

	public PaymentDetailCurrSumListVO(String ibflag, String pagerows, String currCd, String payAmt, String ofcCd, String vndrNo, String fromPayDt, String toPayDt, String payMzdLuCd) {
		this.ofcCd = ofcCd;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.payMzdLuCd = payMzdLuCd;
		this.payAmt = payAmt;
		this.fromPayDt = fromPayDt;
		this.toPayDt = toPayDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("from_pay_dt", getFromPayDt());
		this.hashColumns.put("to_pay_dt", getToPayDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("from_pay_dt", "fromPayDt");
		this.hashFields.put("to_pay_dt", "toPayDt");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return fromPayDt
	 */
	public String getFromPayDt() {
		return this.fromPayDt;
	}
	
	/**
	 * Column Info
	 * @return toPayDt
	 */
	public String getToPayDt() {
		return this.toPayDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param fromPayDt
	 */
	public void setFromPayDt(String fromPayDt) {
		this.fromPayDt = fromPayDt;
	}
	
	/**
	 * Column Info
	 * @param toPayDt
	 */
	public void setToPayDt(String toPayDt) {
		this.toPayDt = toPayDt;
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
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setFromPayDt(JSPUtil.getParameter(request, prefix + "from_pay_dt", ""));
		setToPayDt(JSPUtil.getParameter(request, prefix + "to_pay_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentDetailCurrSumListVO[]
	 */
	public PaymentDetailCurrSumListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentDetailCurrSumListVO[]
	 */
	public PaymentDetailCurrSumListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentDetailCurrSumListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] fromPayDt = (JSPUtil.getParameter(request, prefix	+ "from_pay_dt", length));
			String[] toPayDt = (JSPUtil.getParameter(request, prefix	+ "to_pay_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentDetailCurrSumListVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (fromPayDt[i] != null)
					model.setFromPayDt(fromPayDt[i]);
				if (toPayDt[i] != null)
					model.setToPayDt(toPayDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentDetailCurrSumListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentDetailCurrSumListVO[]
	 */
	public PaymentDetailCurrSumListVO[] getPaymentDetailCurrSumListVOs(){
		PaymentDetailCurrSumListVO[] vos = (PaymentDetailCurrSumListVO[])models.toArray(new PaymentDetailCurrSumListVO[models.size()]);
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
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPayDt = this.fromPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPayDt = this.toPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
