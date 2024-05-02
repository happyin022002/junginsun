/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchCustomerInqryCondVO.java
*@FileTitle : SearchCustomerInqryCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.22
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.05.22 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCustomerInqryCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerInqryCondVO> models = new ArrayList<SearchCustomerInqryCondVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String noUse = null;
	/* Column Info */
	private String bklst = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String include = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String areaCd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String cust = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerInqryCondVO() {}

	public SearchCustomerInqryCondVO(String ibflag, String pagerows, String iPage, String custCd, String custNm, String ofcCd, String include, String cust, String ctyNm, String steCd, String zipCd, String areaCd, String noUse, String bklst) {
		this.custNm = custNm;
		this.noUse = noUse;
		this.bklst = bklst;
		this.pagerows = pagerows;
		this.include = include;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.custCd = custCd;
		this.zipCd = zipCd;
		this.iPage = iPage;
		this.ctyNm = ctyNm;
		this.areaCd = areaCd;
		this.steCd = steCd;
		this.cust = cust;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("no_use", getNoUse());
		this.hashColumns.put("bklst", getBklst());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("include", getInclude());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("area_cd", getAreaCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cust", getCust());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("no_use", "noUse");
		this.hashFields.put("bklst", "bklst");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("include", "include");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("area_cd", "areaCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cust", "cust");
		return this.hashFields;
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
	 * @return noUse
	 */
	public String getNoUse() {
		return this.noUse;
	}
	
	/**
	 * Column Info
	 * @return bklst
	 */
	public String getBklst() {
		return this.bklst;
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
	 * @return include
	 */
	public String getInclude() {
		return this.include;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return areaCd
	 */
	public String getAreaCd() {
		return this.areaCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return cust
	 */
	public String getCust() {
		return this.cust;
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
	 * @param noUse
	 */
	public void setNoUse(String noUse) {
		this.noUse = noUse;
	}
	
	/**
	 * Column Info
	 * @param bklst
	 */
	public void setBklst(String bklst) {
		this.bklst = bklst;
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
	 * @param include
	 */
	public void setInclude(String include) {
		this.include = include;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param areaCd
	 */
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param cust
	 */
	public void setCust(String cust) {
		this.cust = cust;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setNoUse(JSPUtil.getParameter(request, prefix + "no_use", ""));
		setBklst(JSPUtil.getParameter(request, prefix + "bklst", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInclude(JSPUtil.getParameter(request, prefix + "include", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setAreaCd(JSPUtil.getParameter(request, prefix + "area_cd", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setCust(JSPUtil.getParameter(request, prefix + "cust", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerInqryCondVO[]
	 */
	public SearchCustomerInqryCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCustomerInqryCondVO[]
	 */
	public SearchCustomerInqryCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerInqryCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] noUse = (JSPUtil.getParameter(request, prefix	+ "no_use", length));
			String[] bklst = (JSPUtil.getParameter(request, prefix	+ "bklst", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] include = (JSPUtil.getParameter(request, prefix	+ "include", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] areaCd = (JSPUtil.getParameter(request, prefix	+ "area_cd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] cust = (JSPUtil.getParameter(request, prefix	+ "cust", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerInqryCondVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (noUse[i] != null)
					model.setNoUse(noUse[i]);
				if (bklst[i] != null)
					model.setBklst(bklst[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (include[i] != null)
					model.setInclude(include[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (areaCd[i] != null)
					model.setAreaCd(areaCd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (cust[i] != null)
					model.setCust(cust[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerInqryCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerInqryCondVO[]
	 */
	public SearchCustomerInqryCondVO[] getSearchCustomerInqryCondVOs(){
		SearchCustomerInqryCondVO[] vos = (SearchCustomerInqryCondVO[])models.toArray(new SearchCustomerInqryCondVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUse = this.noUse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bklst = this.bklst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.include = this.include .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCd = this.areaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cust = this.cust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
