/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomerListByBLVO.java
*@FileTitle : CustomerListByBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.24 임옥영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomerListByBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerListByBLVO> models = new ArrayList<CustomerListByBLVO>();
	
	/* Column Info */
	private String sNm1 = null;
	/* Column Info */
	private String fCust = null;
	/* Column Info */
	private String cCust = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cNm1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cNm2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nCust = null;
	/* Column Info */
	private String sCust = null;
	/* Column Info */
	private String nNm2 = null;
	/* Column Info */
	private String nNm1 = null;
	/* Column Info */
	private String sNm2 = null;
	/* Column Info */
	private String fNm2 = null;
	/* Column Info */
	private String fNm1 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaNo = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomerListByBLVO() {}

	public CustomerListByBLVO(String ibflag, String pagerows, String blNo, String sCust, String sNm1, String sNm2, String cCust, String cNm1, String cNm2, String nCust, String nNm1, String nNm2, String fCust, String fNm1, String fNm2) {
		this.sNm1 = sNm1;
		this.fCust = fCust;
		this.cCust = cCust;
		this.blNo = blNo;
		this.cNm1 = cNm1;
		this.pagerows = pagerows;
		this.cNm2 = cNm2;
		this.ibflag = ibflag;
		this.nCust = nCust;
		this.sCust = sCust;
		this.nNm2 = nNm2;
		this.nNm1 = nNm1;
		this.sNm2 = sNm2;
		this.fNm2 = fNm2;
		this.fNm1 = fNm1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_nm1", getSNm1());
		this.hashColumns.put("f_cust", getFCust());
		this.hashColumns.put("c_cust", getCCust());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("c_nm1", getCNm1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("c_nm2", getCNm2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n_cust", getNCust());
		this.hashColumns.put("s_cust", getSCust());
		this.hashColumns.put("n_nm2", getNNm2());
		this.hashColumns.put("n_nm1", getNNm1());
		this.hashColumns.put("s_nm2", getSNm2());
		this.hashColumns.put("f_nm2", getFNm2());
		this.hashColumns.put("f_nm1", getFNm1());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_nm1", "sNm1");
		this.hashFields.put("f_cust", "fCust");
		this.hashFields.put("c_cust", "cCust");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("c_nm1", "cNm1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("c_nm2", "cNm2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n_cust", "nCust");
		this.hashFields.put("s_cust", "sCust");
		this.hashFields.put("n_nm2", "nNm2");
		this.hashFields.put("n_nm1", "nNm1");
		this.hashFields.put("s_nm2", "sNm2");
		this.hashFields.put("f_nm2", "fNm2");
		this.hashFields.put("f_nm1", "fNm1");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sNm1
	 */
	public String getSNm1() {
		return this.sNm1;
	}
	
	/**
	 * Column Info
	 * @return fCust
	 */
	public String getFCust() {
		return this.fCust;
	}
	
	/**
	 * Column Info
	 * @return cCust
	 */
	public String getCCust() {
		return this.cCust;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cNm1
	 */
	public String getCNm1() {
		return this.cNm1;
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
	 * @return cNm2
	 */
	public String getCNm2() {
		return this.cNm2;
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
	 * @return nCust
	 */
	public String getNCust() {
		return this.nCust;
	}
	
	/**
	 * Column Info
	 * @return sCust
	 */
	public String getSCust() {
		return this.sCust;
	}
	
	/**
	 * Column Info
	 * @return nNm2
	 */
	public String getNNm2() {
		return this.nNm2;
	}
	
	/**
	 * Column Info
	 * @return nNm1
	 */
	public String getNNm1() {
		return this.nNm1;
	}
	
	/**
	 * Column Info
	 * @return sNm2
	 */
	public String getSNm2() {
		return this.sNm2;
	}
	
	/**
	 * Column Info
	 * @return fNm2
	 */
	public String getFNm2() {
		return this.fNm2;
	}
	
	/**
	 * Column Info
	 * @return fNm1
	 */
	public String getFNm1() {
		return this.fNm1;
	}
	
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}	
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	/**
	 * Column Info
	 * @param sNm1
	 */
	public void setSNm1(String sNm1) {
		this.sNm1 = sNm1;
	}
	
	/**
	 * Column Info
	 * @param fCust
	 */
	public void setFCust(String fCust) {
		this.fCust = fCust;
	}
	
	/**
	 * Column Info
	 * @param cCust
	 */
	public void setCCust(String cCust) {
		this.cCust = cCust;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cNm1
	 */
	public void setCNm1(String cNm1) {
		this.cNm1 = cNm1;
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
	 * @param cNm2
	 */
	public void setCNm2(String cNm2) {
		this.cNm2 = cNm2;
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
	 * @param nCust
	 */
	public void setNCust(String nCust) {
		this.nCust = nCust;
	}
	
	/**
	 * Column Info
	 * @param sCust
	 */
	public void setSCust(String sCust) {
		this.sCust = sCust;
	}
	
	/**
	 * Column Info
	 * @param nNm2
	 */
	public void setNNm2(String nNm2) {
		this.nNm2 = nNm2;
	}
	
	/**
	 * Column Info
	 * @param nNm1
	 */
	public void setNNm1(String nNm1) {
		this.nNm1 = nNm1;
	}
	
	/**
	 * Column Info
	 * @param sNm2
	 */
	public void setSNm2(String sNm2) {
		this.sNm2 = sNm2;
	}
	
	/**
	 * Column Info
	 * @param fNm2
	 */
	public void setFNm2(String fNm2) {
		this.fNm2 = fNm2;
	}
	
	/**
	 * Column Info
	 * @param fNm1
	 */
	public void setFNm1(String fNm1) {
		this.fNm1 = fNm1;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
		setSNm1(JSPUtil.getParameter(request, prefix + "s_nm1", ""));
		setFCust(JSPUtil.getParameter(request, prefix + "f_cust", ""));
		setCCust(JSPUtil.getParameter(request, prefix + "c_cust", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCNm1(JSPUtil.getParameter(request, prefix + "c_nm1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCNm2(JSPUtil.getParameter(request, prefix + "c_nm2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNCust(JSPUtil.getParameter(request, prefix + "n_cust", ""));
		setSCust(JSPUtil.getParameter(request, prefix + "s_cust", ""));
		setNNm2(JSPUtil.getParameter(request, prefix + "n_nm2", ""));
		setNNm1(JSPUtil.getParameter(request, prefix + "n_nm1", ""));
		setSNm2(JSPUtil.getParameter(request, prefix + "s_nm2", ""));
		setFNm2(JSPUtil.getParameter(request, prefix + "f_nm2", ""));
		setFNm1(JSPUtil.getParameter(request, prefix + "f_nm1", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerListByBLVO[]
	 */
	public CustomerListByBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerListByBLVO[]
	 */
	public CustomerListByBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerListByBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sNm1 = (JSPUtil.getParameter(request, prefix	+ "s_nm1", length));
			String[] fCust = (JSPUtil.getParameter(request, prefix	+ "f_cust", length));
			String[] cCust = (JSPUtil.getParameter(request, prefix	+ "c_cust", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cNm1 = (JSPUtil.getParameter(request, prefix	+ "c_nm1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cNm2 = (JSPUtil.getParameter(request, prefix	+ "c_nm2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nCust = (JSPUtil.getParameter(request, prefix	+ "n_cust", length));
			String[] sCust = (JSPUtil.getParameter(request, prefix	+ "s_cust", length));
			String[] nNm2 = (JSPUtil.getParameter(request, prefix	+ "n_nm2", length));
			String[] nNm1 = (JSPUtil.getParameter(request, prefix	+ "n_nm1", length));
			String[] sNm2 = (JSPUtil.getParameter(request, prefix	+ "s_nm2", length));
			String[] fNm2 = (JSPUtil.getParameter(request, prefix	+ "f_nm2", length));
			String[] fNm1 = (JSPUtil.getParameter(request, prefix	+ "f_nm1", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerListByBLVO();
				if (sNm1[i] != null)
					model.setSNm1(sNm1[i]);
				if (fCust[i] != null)
					model.setFCust(fCust[i]);
				if (cCust[i] != null)
					model.setCCust(cCust[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cNm1[i] != null)
					model.setCNm1(cNm1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cNm2[i] != null)
					model.setCNm2(cNm2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nCust[i] != null)
					model.setNCust(nCust[i]);
				if (sCust[i] != null)
					model.setSCust(sCust[i]);
				if (nNm2[i] != null)
					model.setNNm2(nNm2[i]);
				if (nNm1[i] != null)
					model.setNNm1(nNm1[i]);
				if (sNm2[i] != null)
					model.setSNm2(sNm2[i]);
				if (fNm2[i] != null)
					model.setFNm2(fNm2[i]);
				if (fNm1[i] != null)
					model.setFNm1(fNm1[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerListByBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerListByBLVO[]
	 */
	public CustomerListByBLVO[] getCustomerListByBLVOs(){
		CustomerListByBLVO[] vos = (CustomerListByBLVO[])models.toArray(new CustomerListByBLVO[models.size()]);
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
		this.sNm1 = this.sNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCust = this.fCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCust = this.cCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNm1 = this.cNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNm2 = this.cNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCust = this.nCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCust = this.sCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nNm2 = this.nNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nNm1 = this.nNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNm2 = this.sNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNm2 = this.fNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNm1 = this.fNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
