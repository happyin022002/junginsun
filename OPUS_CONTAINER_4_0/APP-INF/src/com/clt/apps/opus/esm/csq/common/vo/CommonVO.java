/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonVO.java
*@FileTitle      : CommonVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.10
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.10 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.common.vo;

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
 * @author CSQ USER
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	private Collection<CommonVO> models = new ArrayList<CommonVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String codeName = null;
	/* Column Info */
	private String codeParam = null;
	/* Column Info */
	private String allFlag = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommonVO() {}
	
	public CommonVO(String ibflag, String pagerows, String codeName, String codeParam, String allFlag) {
		this.ibflag		= ibflag;
		this.pagerows	= pagerows;
		this.codeName	= codeName;
		this.codeParam	= codeParam;
		this.allFlag	= allFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("code_name", getCodeName());
		this.hashColumns.put("code_param", getCodeParam());
		this.hashColumns.put("all_flag", getAllFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("code_name", "codeName");
		this.hashFields.put("code_param", "codeParam");
		this.hashFields.put("all_flag", "allFlag");
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return codeName
	 */
	public String getCodeName() {
		return this.codeName;
	}
	
	/**
	 * Column Info
	 * @return codeParam
	 */
	public String getCodeParam() {
		return this.codeParam;
	}
	
	/**
	 * Column Info
	 * @return allFlag
	 */
	public String getAllFlag() {
		return this.allFlag;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param trdCd
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	/**
	 * Column Info
	 * @param codeParam
	 */
	public void setCodeParam(String codeParam) {
		this.codeParam = codeParam;
	}
	
	/**
	 * Column Info
	 * @param allFlag
	 */
	public void setAllFlag(String allFlag) {
		this.allFlag = allFlag;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCodeName(JSPUtil.getParameter(request, prefix + "code_name", ""));
		setCodeParam(JSPUtil.getParameter(request, prefix + "code_param", ""));
		setAllFlag(JSPUtil.getParameter(request, prefix + "all_flag", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommonVO[]
	 */
	public CommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CommonVO[]
	 */
	public CommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommonVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if (tmp == null)
   			return null;
  		
  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
		try {
			String[] ibflag		= (JSPUtil.getParameter(request, prefix	+ "ibflag",		length));
			String[] pagerows	= (JSPUtil.getParameter(request, prefix	+ "pagerows",	length));
			String[] codeName	= (JSPUtil.getParameter(request, prefix	+ "code_name",	length));
			String[] codeParam	= (JSPUtil.getParameter(request, prefix	+ "code_param",	length));
			String[] allFlag	= (JSPUtil.getParameter(request, prefix	+ "all_flag",	length));

			for (int i = 0; i < length; i++) {
				model = new CommonVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (codeName[i] != null)
					model.setCodeName(codeName[i]);
				if (codeParam[i] != null)
					model.setCodeParam(codeParam[i]);
				if (allFlag[i] != null)
					model.setAllFlag(allFlag[i]);
				models.add(model);
			}
			
		} catch (Exception e) {
			return null;
		}
		return getCommonVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return CommonVO[]
	 */
	public CommonVO[] getCommonVOs(){
		CommonVO[] vos = (CommonVO[])models.toArray(new CommonVO[models.size()]);
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
		this.ibflag		= this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows	= this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeName	= this.codeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeParam	= this.codeParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allFlag	= this.allFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}