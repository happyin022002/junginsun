/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InInterrstServiceVO.java
*@FileTitle : InInterrstServiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.09 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InInterrstServiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InInterrstServiceVO> models = new ArrayList<InInterrstServiceVO>();
	
	/* Column Info */
	private String iRate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String principal = null;
	/* Column Info */
	private String pmtDiem = null;
	/* Column Info */
	private String pmt = null;
	/* Column Info */
	private String nPayment = null;
	/* Column Info */
	private String quantity = null;
	/* Column Info */
	private String paymentTerm = null;
	/* Column Info */
	private String uPrice = null;
	/* Column Info */
	private String iType = null;
	/* Column Info */
	private String contractPeriod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InInterrstServiceVO() {}

	public InInterrstServiceVO(String ibflag, String pagerows, String contractPeriod, 
			String paymentTerm, String principal, String quantity, String iRate, 
			String uPrice, String nPayment, String pmt, String pmtDiem, String iType) {
		this.iRate = iRate;
		this.ibflag = ibflag;
		this.principal = principal;
		this.pmtDiem = pmtDiem;
		this.pmt = pmt;
		this.nPayment = nPayment;
		this.quantity = quantity;
		this.paymentTerm = paymentTerm;
		this.uPrice = uPrice;
		this.contractPeriod = contractPeriod;
		this.pagerows = pagerows;
		this.iType=iType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("i_rate", getIRate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("principal", getPrincipal());
		this.hashColumns.put("pmt_diem", getPmtDiem());
		this.hashColumns.put("pmt", getPmt());
		this.hashColumns.put("n_payment", getNPayment());
		this.hashColumns.put("quantity", getQuantity());
		this.hashColumns.put("payment_term", getPaymentTerm());
		this.hashColumns.put("u_price", getUPrice());
		this.hashColumns.put("contract_period", getContractPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("i_type", getIType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("i_rate", "iRate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("principal", "principal");
		this.hashFields.put("pmt_diem", "pmtDiem");
		this.hashFields.put("pmt", "pmt");
		this.hashFields.put("n_payment", "nPayment");
		this.hashFields.put("quantity", "quantity");
		this.hashFields.put("payment_term", "paymentTerm");
		this.hashFields.put("u_price", "uPrice");
		this.hashFields.put("contract_period", "contractPeriod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iType", "iType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iRate
	 */
	public String getIRate() {
		return this.iRate;
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
	 * @return principal
	 */
	public String getPrincipal() {
		return this.principal;
	}
	
	/**
	 * Column Info
	 * @return pmtDiem
	 */
	public String getPmtDiem() {
		return this.pmtDiem;
	}
	
	/**
	 * Column Info
	 * @return pmt
	 */
	public String getPmt() {
		return this.pmt;
	}
	
	/**
	 * Column Info
	 * @return nPayment
	 */
	public String getNPayment() {
		return this.nPayment;
	}
	
	/**
	 * Column Info
	 * @return quantity
	 */
	public String getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Column Info
	 * @return paymentTerm
	 */
	public String getPaymentTerm() {
		return this.paymentTerm;
	}
	
	/**
	 * Column Info
	 * @return uPrice
	 */
	public String getUPrice() {
		return this.uPrice;
	}
	
	/**
	 * Column Info
	 * @return contractPeriod
	 */
	public String getContractPeriod() {
		return this.contractPeriod;
	}
	
	/**
	 * Column Info
	 * @param iType
	 */
	public String getIType() {
		return iType;
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
	 * @param iRate
	 */
	public void setIRate(String iRate) {
		this.iRate = iRate;
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
	 * @param principal
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	/**
	 * Column Info
	 * @param pmtDiem
	 */
	public void setPmtDiem(String pmtDiem) {
		this.pmtDiem = pmtDiem;
	}
	
	/**
	 * Column Info
	 * @param pmt
	 */
	public void setPmt(String pmt) {
		this.pmt = pmt;
	}
	
	/**
	 * Column Info
	 * @param nPayment
	 */
	public void setNPayment(String nPayment) {
		this.nPayment = nPayment;
	}
	
	/**
	 * Column Info
	 * @param quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Column Info
	 * @param paymentTerm
	 */
	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
	
	/**
	 * Column Info
	 * @param uPrice
	 */
	public void setUPrice(String uPrice) {
		this.uPrice = uPrice;
	}
	
	/**
	 * Column Info
	 * @param contractPeriod
	 */
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	
	
	/**
	 * Column Info
	 * @param iType
	 */
	public void setIType(String type) {
		iType = type;
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
		setIRate(JSPUtil.getParameter(request, prefix + "i_rate", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrincipal(JSPUtil.getParameter(request, prefix + "principal", ""));
		setPmtDiem(JSPUtil.getParameter(request, prefix + "pmt_diem", ""));
		setPmt(JSPUtil.getParameter(request, prefix + "pmt", ""));
		setNPayment(JSPUtil.getParameter(request, prefix + "n_payment", ""));
		setQuantity(JSPUtil.getParameter(request, prefix + "quantity", ""));
		setPaymentTerm(JSPUtil.getParameter(request, prefix + "payment_term", ""));
		setUPrice(JSPUtil.getParameter(request, prefix + "u_price", ""));
		setContractPeriod(JSPUtil.getParameter(request, prefix + "contract_period", ""));
		setIType(JSPUtil.getParameter(request, prefix + "payment_method", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InInterrstServiceVO[]
	 */
	public InInterrstServiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InInterrstServiceVO[]
	 */
	public InInterrstServiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InInterrstServiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iRate = (JSPUtil.getParameter(request, prefix	+ "i_rate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] principal = (JSPUtil.getParameter(request, prefix	+ "principal", length));
			String[] pmtDiem = (JSPUtil.getParameter(request, prefix	+ "pmt_diem", length));
			String[] pmt = (JSPUtil.getParameter(request, prefix	+ "pmt", length));
			String[] nPayment = (JSPUtil.getParameter(request, prefix	+ "n_payment", length));
			String[] quantity = (JSPUtil.getParameter(request, prefix	+ "quantity", length));
			String[] paymentTerm = (JSPUtil.getParameter(request, prefix	+ "payment_term", length));
			String[] uPrice = (JSPUtil.getParameter(request, prefix	+ "u_price", length));
			String[] contractPeriod = (JSPUtil.getParameter(request, prefix	+ "contract_period", length));
			String[] iType = (JSPUtil.getParameter(request, prefix	+ "payment_method", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InInterrstServiceVO();
				if (iRate[i] != null)
					model.setIRate(iRate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (principal[i] != null)
					model.setPrincipal(principal[i]);
				if (pmtDiem[i] != null)
					model.setPmtDiem(pmtDiem[i]);
				if (pmt[i] != null)
					model.setPmt(pmt[i]);
				if (nPayment[i] != null)
					model.setNPayment(nPayment[i]);
				if (quantity[i] != null)
					model.setQuantity(quantity[i]);
				if (paymentTerm[i] != null)
					model.setPaymentTerm(paymentTerm[i]);
				if (uPrice[i] != null)
					model.setUPrice(uPrice[i]);
				if (contractPeriod[i] != null)
					model.setContractPeriod(contractPeriod[i]);
				if (iType[i] != null)
					model.setIType(iType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInInterrstServiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InInterrstServiceVO[]
	 */
	public InInterrstServiceVO[] getInInterrstServiceVOs(){
		InInterrstServiceVO[] vos = (InInterrstServiceVO[])models.toArray(new InInterrstServiceVO[models.size()]);
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
		this.iRate = this.iRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.principal = this.principal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmtDiem = this.pmtDiem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmt = this.pmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nPayment = this.nPayment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quantity = this.quantity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentTerm = this.paymentTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uPrice = this.uPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractPeriod = this.contractPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
