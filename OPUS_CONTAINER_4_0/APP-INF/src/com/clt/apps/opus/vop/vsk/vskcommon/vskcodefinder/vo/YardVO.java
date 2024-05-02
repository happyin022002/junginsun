/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : YardVO.java
*@FileTitle : YardVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.03 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class YardVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<YardVO> models = new ArrayList<YardVO>();
	
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String countryCd = null;
	/* Column Info */
	private String ydKind = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public YardVO() {}

	public YardVO(String ibflag, String pagerows, String locCd, String ydKind, String ydCd, String ydNm, String countryCd, String mnvrInHrs, String mnvrOutHrs) {
		this.mnvrInHrs = mnvrInHrs;
		this.mnvrOutHrs = mnvrOutHrs;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.ydNm = ydNm;
		this.countryCd = countryCd;
		this.ydKind = ydKind;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("country_cd", getCountryCd());
		this.hashColumns.put("yd_kind", getYdKind());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("country_cd", "countryCd");
		this.hashFields.put("yd_kind", "ydKind");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutHrs
	 */
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return countryCd
	 */
	public String getCountryCd() {
		return this.countryCd;
	}
	
	/**
	 * Column Info
	 * @return ydKind
	 */
	public String getYdKind() {
		return this.ydKind;
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
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutHrs
	 */
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param countryCd
	 */
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}
	
	/**
	 * Column Info
	 * @param ydKind
	 */
	public void setYdKind(String ydKind) {
		this.ydKind = ydKind;
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
		setMnvrInHrs(JSPUtil.getParameter(request, "mnvr_in_hrs", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, "mnvr_out_hrs", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setCountryCd(JSPUtil.getParameter(request, "country_cd", ""));
		setYdKind(JSPUtil.getParameter(request, "yd_kind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardVO[]
	 */
	public YardVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardVO[]
	 */
	public YardVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		YardVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] countryCd = (JSPUtil.getParameter(request, prefix	+ "country_cd", length));
			String[] ydKind = (JSPUtil.getParameter(request, prefix	+ "yd_kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new YardVO();
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (countryCd[i] != null)
					model.setCountryCd(countryCd[i]);
				if (ydKind[i] != null)
					model.setYdKind(ydKind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getYardVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return YardVO[]
	 */
	public YardVO[] getYardVOs(){
		YardVO[] vos = (YardVO[])models.toArray(new YardVO[models.size()]);
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
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCd = this.countryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydKind = this.ydKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
