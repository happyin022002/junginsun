/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingCustomerVO.java
*@FileTitle : BookingCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BookingCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BookingCustomerVO> models = new ArrayList<BookingCustomerVO>();
	
	/* Column Info */
	private String custNmN = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custCdC = null;
	/* Column Info */
	private String custCdS = null;
	/* Column Info */
	private String custNmC = null;
	/* Column Info */
	private String custNmS = null;
	/* Column Info */
	private String custCdN = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BookingCustomerVO() {}

	public BookingCustomerVO(String ibflag, String pagerows, String bkgNo, String custCd, String custNm, String custCdC, String custCdS, String custCdN, String custNmC, String custNmS, String custNmN) {
		this.custNmN = custNmN;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.custCd = custCd;
		this.custCdC = custCdC;
		this.custCdS = custCdS;
		this.custNmC = custNmC;
		this.custNmS = custNmS;
		this.custCdN = custCdN;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm_n", getCustNmN());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_cd_c", getCustCdC());
		this.hashColumns.put("cust_cd_s", getCustCdS());
		this.hashColumns.put("cust_nm_c", getCustNmC());
		this.hashColumns.put("cust_nm_s", getCustNmS());
		this.hashColumns.put("cust_cd_n", getCustCdN());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm_n", "custNmN");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_cd_c", "custCdC");
		this.hashFields.put("cust_cd_s", "custCdS");
		this.hashFields.put("cust_nm_c", "custNmC");
		this.hashFields.put("cust_nm_s", "custNmS");
		this.hashFields.put("cust_cd_n", "custCdN");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNmN
	 */
	public String getCustNmN() {
		return this.custNmN;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return custCdC
	 */
	public String getCustCdC() {
		return this.custCdC;
	}
	
	/**
	 * Column Info
	 * @return custCdS
	 */
	public String getCustCdS() {
		return this.custCdS;
	}
	
	/**
	 * Column Info
	 * @return custNmC
	 */
	public String getCustNmC() {
		return this.custNmC;
	}
	
	/**
	 * Column Info
	 * @return custNmS
	 */
	public String getCustNmS() {
		return this.custNmS;
	}
	
	/**
	 * Column Info
	 * @return custCdN
	 */
	public String getCustCdN() {
		return this.custCdN;
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
	 * @param custNmN
	 */
	public void setCustNmN(String custNmN) {
		this.custNmN = custNmN;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param custCdC
	 */
	public void setCustCdC(String custCdC) {
		this.custCdC = custCdC;
	}
	
	/**
	 * Column Info
	 * @param custCdS
	 */
	public void setCustCdS(String custCdS) {
		this.custCdS = custCdS;
	}
	
	/**
	 * Column Info
	 * @param custNmC
	 */
	public void setCustNmC(String custNmC) {
		this.custNmC = custNmC;
	}
	
	/**
	 * Column Info
	 * @param custNmS
	 */
	public void setCustNmS(String custNmS) {
		this.custNmS = custNmS;
	}
	
	/**
	 * Column Info
	 * @param custCdN
	 */
	public void setCustCdN(String custCdN) {
		this.custCdN = custCdN;
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
		setCustNmN(JSPUtil.getParameter(request, "cust_nm_n", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCustCdC(JSPUtil.getParameter(request, "cust_cd_c", ""));
		setCustCdS(JSPUtil.getParameter(request, "cust_cd_s", ""));
		setCustNmC(JSPUtil.getParameter(request, "cust_nm_c", ""));
		setCustNmS(JSPUtil.getParameter(request, "cust_nm_s", ""));
		setCustCdN(JSPUtil.getParameter(request, "cust_cd_n", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BookingCustomerVO[]
	 */
	public BookingCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BookingCustomerVO[]
	 */
	public BookingCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BookingCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNmN = (JSPUtil.getParameter(request, prefix	+ "cust_nm_n", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custCdC = (JSPUtil.getParameter(request, prefix	+ "cust_cd_c", length));
			String[] custCdS = (JSPUtil.getParameter(request, prefix	+ "cust_cd_s", length));
			String[] custNmC = (JSPUtil.getParameter(request, prefix	+ "cust_nm_c", length));
			String[] custNmS = (JSPUtil.getParameter(request, prefix	+ "cust_nm_s", length));
			String[] custCdN = (JSPUtil.getParameter(request, prefix	+ "cust_cd_n", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BookingCustomerVO();
				if (custNmN[i] != null)
					model.setCustNmN(custNmN[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custCdC[i] != null)
					model.setCustCdC(custCdC[i]);
				if (custCdS[i] != null)
					model.setCustCdS(custCdS[i]);
				if (custNmC[i] != null)
					model.setCustNmC(custNmC[i]);
				if (custNmS[i] != null)
					model.setCustNmS(custNmS[i]);
				if (custCdN[i] != null)
					model.setCustCdN(custCdN[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBookingCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BookingCustomerVO[]
	 */
	public BookingCustomerVO[] getBookingCustomerVOs(){
		BookingCustomerVO[] vos = (BookingCustomerVO[])models.toArray(new BookingCustomerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.custNmN = this.custNmN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCdC = this.custCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCdS = this.custCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmC = this.custNmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNmS = this.custNmS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCdN = this.custCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
