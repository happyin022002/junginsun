/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PaymentLetterMDMInfoVO.java
*@FileTitle : PaymentLetterMDMInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class PaymentLetterMDMInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentLetterMDMInfoVO> models = new ArrayList<PaymentLetterMDMInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String qeqFmt = null;
	/* Column Info */
	private String supYn = null;
	/* Column Info */
	private String custFlg = null;
	/* Column Info */
	private String custEml = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentLetterMDMInfoVO() {}

	public PaymentLetterMDMInfoVO(String ibflag, String pagerows, String faxNo, String qeqFmt, String custEml, String custFlg, String supYn, String custNm) {
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.faxNo = faxNo;
		this.qeqFmt = qeqFmt;
		this.supYn = supYn;
		this.custFlg = custFlg;
		this.custEml = custEml;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("qeq_fmt", getQeqFmt());
		this.hashColumns.put("sup_yn", getSupYn());
		this.hashColumns.put("cust_flg", getCustFlg());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("qeq_fmt", "qeqFmt");
		this.hashFields.put("sup_yn", "supYn");
		this.hashFields.put("cust_flg", "custFlg");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return qeqFmt
	 */
	public String getQeqFmt() {
		return this.qeqFmt;
	}
	
	/**
	 * Column Info
	 * @return supYn
	 */
	public String getSupYn() {
		return this.supYn;
	}
	
	/**
	 * Column Info
	 * @return custFlg
	 */
	public String getCustFlg() {
		return this.custFlg;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param qeqFmt
	 */
	public void setQeqFmt(String qeqFmt) {
		this.qeqFmt = qeqFmt;
	}
	
	/**
	 * Column Info
	 * @param supYn
	 */
	public void setSupYn(String supYn) {
		this.supYn = supYn;
	}
	
	/**
	 * Column Info
	 * @param custFlg
	 */
	public void setCustFlg(String custFlg) {
		this.custFlg = custFlg;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setQeqFmt(JSPUtil.getParameter(request, prefix + "qeq_fmt", ""));
		setSupYn(JSPUtil.getParameter(request, prefix + "sup_yn", ""));
		setCustFlg(JSPUtil.getParameter(request, prefix + "cust_flg", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentLetterMDMInfoVO[]
	 */
	public PaymentLetterMDMInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentLetterMDMInfoVO[]
	 */
	public PaymentLetterMDMInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentLetterMDMInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] qeqFmt = (JSPUtil.getParameter(request, prefix	+ "qeq_fmt", length));
			String[] supYn = (JSPUtil.getParameter(request, prefix	+ "sup_yn", length));
			String[] custFlg = (JSPUtil.getParameter(request, prefix	+ "cust_flg", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentLetterMDMInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (qeqFmt[i] != null)
					model.setQeqFmt(qeqFmt[i]);
				if (supYn[i] != null)
					model.setSupYn(supYn[i]);
				if (custFlg[i] != null)
					model.setCustFlg(custFlg[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentLetterMDMInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentLetterMDMInfoVO[]
	 */
	public PaymentLetterMDMInfoVO[] getPaymentLetterMDMInfoVOs(){
		PaymentLetterMDMInfoVO[] vos = (PaymentLetterMDMInfoVO[])models.toArray(new PaymentLetterMDMInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qeqFmt = this.qeqFmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supYn = this.supYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFlg = this.custFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
