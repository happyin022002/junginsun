/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LocationInfoVO.java
*@FileTitle : LocationInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
 
public class LocationInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LocationInfoVO> models = new ArrayList<LocationInfoVO>();
	
	/* Column Info */
	private String locAmsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qualifier = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String steCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public LocationInfoVO() {}

	public LocationInfoVO(String ibflag, String pagerows, String locNm, String qualifier, String locAmsPortCd, String steCd) {
		this.locAmsPortCd = locAmsPortCd;
		this.ibflag = ibflag;
		this.qualifier = qualifier;
		this.locNm = locNm;
		this.steCd = steCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qualifier", getQualifier());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qualifier", "qualifier");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locAmsPortCd
	 */
	public String getLocAmsPortCd() {
		return this.locAmsPortCd;
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
	 * @return qualifier
	 */
	public String getQualifier() {
		return this.qualifier;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param locAmsPortCd
	 */
	public void setLocAmsPortCd(String locAmsPortCd) {
		this.locAmsPortCd = locAmsPortCd;
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
	 * @param qualifier
	 */
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
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
		setLocAmsPortCd(JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setQualifier(JSPUtil.getParameter(request, prefix + "qualifier", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationInfoVO[]
	 */
	public LocationInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationInfoVO[]
	 */
	public LocationInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix	+ "loc_ams_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qualifier = (JSPUtil.getParameter(request, prefix	+ "qualifier", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new LocationInfoVO();
				if (locAmsPortCd[i] != null)
					model.setLocAmsPortCd(locAmsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qualifier[i] != null)
					model.setQualifier(qualifier[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationInfoVO[]
	 */
	public LocationInfoVO[] getLocationInfoVOs(){
		LocationInfoVO[] vos = (LocationInfoVO[])models.toArray(new LocationInfoVO[models.size()]);
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
		this.locAmsPortCd = this.locAmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qualifier = this.qualifier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
