/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomLocalDateVO.java
*@FileTitle : CustomLocalDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.01.19 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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

public class CustomLocalDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomLocalDateVO> models = new ArrayList<CustomLocalDateVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String locTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String workEnable = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomLocalDateVO() {}

	public CustomLocalDateVO(String ibflag, String pagerows, String ofcCd, String locTime, String workEnable) {
		this.ofcCd = ofcCd;
		this.locTime = locTime;
		this.ibflag = ibflag;
		this.workEnable = workEnable;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("loc_time", getLocTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("work_enable", getWorkEnable());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("loc_time", "locTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("work_enable", "workEnable");
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
	 * @return locTime
	 */
	public String getLocTime() {
		return this.locTime;
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
	 * @return workEnable
	 */
	public String getWorkEnable() {
		return this.workEnable;
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
	 * @param locTime
	 */
	public void setLocTime(String locTime) {
		this.locTime = locTime;
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
	 * @param workEnable
	 */
	public void setWorkEnable(String workEnable) {
		this.workEnable = workEnable;
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
		setLocTime(JSPUtil.getParameter(request, prefix + "loc_time", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWorkEnable(JSPUtil.getParameter(request, prefix + "work_enable", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomLocalDateVO[]
	 */
	public CustomLocalDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomLocalDateVO[]
	 */
	public CustomLocalDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomLocalDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] locTime = (JSPUtil.getParameter(request, prefix	+ "loc_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] workEnable = (JSPUtil.getParameter(request, prefix	+ "work_enable", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomLocalDateVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (locTime[i] != null)
					model.setLocTime(locTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (workEnable[i] != null)
					model.setWorkEnable(workEnable[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomLocalDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomLocalDateVO[]
	 */
	public CustomLocalDateVO[] getCustomLocalDateVOs(){
		CustomLocalDateVO[] vos = (CustomLocalDateVO[])models.toArray(new CustomLocalDateVO[models.size()]);
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
		this.locTime = this.locTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workEnable = this.workEnable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
