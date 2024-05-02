/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EU24RcvErrorCodeTableVO.java
*@FileTitle : EU24RcvErrorCodeTableVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.20 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EU24RcvErrorCodeTableVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EU24RcvErrorCodeTableVO> models = new ArrayList<EU24RcvErrorCodeTableVO>();
	
	/* Column Info */
	private String eu24ErrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String errorCode = null;
	/* Column Info */
	private String errorDescription = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EU24RcvErrorCodeTableVO() {}

	public EU24RcvErrorCodeTableVO(String ibflag, String pagerows, String cntCd, String eu24ErrCd, String errorCode, String errorDescription, String remark) {
		this.eu24ErrCd = eu24ErrCd;
		this.ibflag = ibflag;
		this.remark = remark;
		this.cntCd = cntCd;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eu24_err_cd", getEu24ErrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("error_code", getErrorCode());
		this.hashColumns.put("error_description", getErrorDescription());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eu24_err_cd", "eu24ErrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("error_code", "errorCode");
		this.hashFields.put("error_description", "errorDescription");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eu24ErrCd
	 */
	public String getEu24ErrCd() {
		return this.eu24ErrCd;
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
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return errorCode
	 */
	public String getErrorCode() {
		return this.errorCode;
	}
	
	/**
	 * Column Info
	 * @return errorDescription
	 */
	public String getErrorDescription() {
		return this.errorDescription;
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
	 * @param eu24ErrCd
	 */
	public void setEu24ErrCd(String eu24ErrCd) {
		this.eu24ErrCd = eu24ErrCd;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * Column Info
	 * @param errorDescription
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
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
		setEu24ErrCd(JSPUtil.getParameter(request, prefix + "eu24_err_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setErrorCode(JSPUtil.getParameter(request, prefix + "error_code", ""));
		setErrorDescription(JSPUtil.getParameter(request, prefix + "error_description", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EU24RcvErrorCodeTableVO[]
	 */
	public EU24RcvErrorCodeTableVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EU24RcvErrorCodeTableVO[]
	 */
	public EU24RcvErrorCodeTableVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EU24RcvErrorCodeTableVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eu24ErrCd = (JSPUtil.getParameter(request, prefix	+ "eu24_err_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] errorCode = (JSPUtil.getParameter(request, prefix	+ "error_code", length));
			String[] errorDescription = (JSPUtil.getParameter(request, prefix	+ "error_description", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EU24RcvErrorCodeTableVO();
				if (eu24ErrCd[i] != null)
					model.setEu24ErrCd(eu24ErrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (errorCode[i] != null)
					model.setErrorCode(errorCode[i]);
				if (errorDescription[i] != null)
					model.setErrorDescription(errorDescription[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEU24RcvErrorCodeTableVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EU24RcvErrorCodeTableVO[]
	 */
	public EU24RcvErrorCodeTableVO[] getEU24RcvErrorCodeTableVOs(){
		EU24RcvErrorCodeTableVO[] vos = (EU24RcvErrorCodeTableVO[])models.toArray(new EU24RcvErrorCodeTableVO[models.size()]);
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
		this.eu24ErrCd = this.eu24ErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorCode = this.errorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorDescription = this.errorDescription .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
