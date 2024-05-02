/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommVendorVO.java
*@FileTitle : AGNCommVendorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.20 김영오
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGNCommVendorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AGNCommVendorVO> models = new ArrayList<AGNCommVendorVO>();

	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrName = null;
	/* Column Info */
	private String vndrCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AGNCommVendorVO() {}

	public AGNCommVendorVO(String ibflag, String pagerows, String vndrCode, String vndrName, String agnCd) {
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.vndrName = vndrName;
		this.vndrCode = vndrCode;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_name", getVndrName());
		this.hashColumns.put("vndr_code", getVndrCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_name", "vndrName");
		this.hashFields.put("vndr_code", "vndrCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return vndrName
	 */
	public String getVndrName() {
		return this.vndrName;
	}

	/**
	 * Column Info
	 * @return vndrCode
	 */
	public String getVndrCode() {
		return this.vndrCode;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param vndrName
	 */
	public void setVndrName(String vndrName) {
		this.vndrName = vndrName;
	}

	/**
	 * Column Info
	 * @param vndrCode
	 */
	public void setVndrCode(String vndrCode) {
		this.vndrCode = vndrCode;
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
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrName(JSPUtil.getParameter(request, prefix + "vndr_name", ""));
		setVndrCode(JSPUtil.getParameter(request, prefix + "vndr_code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommVendorVO[]
	 */
	public AGNCommVendorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AGNCommVendorVO[]
	 */
	public AGNCommVendorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommVendorVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrName = (JSPUtil.getParameter(request, prefix	+ "vndr_name", length));
			String[] vndrCode = (JSPUtil.getParameter(request, prefix	+ "vndr_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new AGNCommVendorVO();
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrName[i] != null)
					model.setVndrName(vndrName[i]);
				if (vndrCode[i] != null)
					model.setVndrCode(vndrCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommVendorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommVendorVO[]
	 */
	public AGNCommVendorVO[] getAGNCommVendorVOs(){
		AGNCommVendorVO[] vos = (AGNCommVendorVO[])models.toArray(new AGNCommVendorVO[models.size()]);
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
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrName = this.vndrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCode = this.vndrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
