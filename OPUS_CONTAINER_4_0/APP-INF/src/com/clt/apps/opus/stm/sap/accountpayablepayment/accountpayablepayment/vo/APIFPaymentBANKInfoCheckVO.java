/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APIFPaymentBANKInfoCheckVO.java
*@FileTitle : APIFPaymentBANKInfoCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13  
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

public class APIFPaymentBANKInfoCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APIFPaymentBANKInfoCheckVO> models = new ArrayList<APIFPaymentBANKInfoCheckVO>();
	
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APIFPaymentBANKInfoCheckVO() {}

	public APIFPaymentBANKInfoCheckVO(String ibflag, String pagerows, String bankAcctSeq, String bankAcctNo, String bankAcctNm) {
		this.bankAcctSeq = bankAcctSeq;
		this.bankAcctNo = bankAcctNo;
		this.ibflag = ibflag;
		this.bankAcctNm = bankAcctNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctSeq
	 */
	public String getBankAcctSeq() {
		return this.bankAcctSeq;
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
	 * @return bankAcctNm
	 */
	public String getBankAcctNm() {
		return this.bankAcctNm;
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
	 * @param bankAcctSeq
	 */
	public void setBankAcctSeq(String bankAcctSeq) {
		this.bankAcctSeq = bankAcctSeq;
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
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
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
		setBankAcctSeq(JSPUtil.getParameter(request, prefix + "bank_acct_seq", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APIFPaymentBANKInfoCheckVO[]
	 */
	public APIFPaymentBANKInfoCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APIFPaymentBANKInfoCheckVO[]
	 */
	public APIFPaymentBANKInfoCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APIFPaymentBANKInfoCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new APIFPaymentBANKInfoCheckVO();
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPIFPaymentBANKInfoCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APIFPaymentBANKInfoCheckVO[]
	 */
	public APIFPaymentBANKInfoCheckVO[] getAPIFPaymentBANKInfoCheckVOs(){
		APIFPaymentBANKInfoCheckVO[] vos = (APIFPaymentBANKInfoCheckVO[])models.toArray(new APIFPaymentBANKInfoCheckVO[models.size()]);
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
		this.bankAcctSeq = this.bankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
