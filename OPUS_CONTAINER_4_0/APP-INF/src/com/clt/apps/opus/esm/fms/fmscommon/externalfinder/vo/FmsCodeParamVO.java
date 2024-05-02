/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FmsCodeParamVO.java
*@FileTitle : FmsCodeParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

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
public class FmsCodeParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FmsCodeParamVO> models = new ArrayList<FmsCodeParamVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String code = null;

	/* Column Info */
	private String name = null;

	/* Column Info */
	private String sortKey = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String comCode = null;

	/* Column Info */
	private String comText = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FmsCodeParamVO() {}

	public FmsCodeParamVO(String ibflag, String pagerows, String code, String name, String sortKey, String ofcCd, String comCode, String comText) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.code = code;
		this.name = name;
		this.sortKey = sortKey;
		this.ofcCd = ofcCd;
		this.comCode = comCode;
		this.comText = comText;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("sort_key", getSortKey());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("com_code", getComCode());
		this.hashColumns.put("com_text", getComText());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("code", "code");
		this.hashFields.put("name", "name");
		this.hashFields.put("sort_key", "sortKey");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("com_code", "comCode");
		this.hashFields.put("com_text", "comText");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 
	 * @return String code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 *
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 *
	 * @param String sortKey
	 */
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}
	
	/**
	 * 
	 * @return String sortKey
	 */
	public String getSortKey() {
		return this.sortKey;
	}
	
	/**
	 *
	 * @param String ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 
	 * @return String ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 *
	 * @param String comCode
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	
	/**
	 * 
	 * @return String comCode
	 */
	public String getComCode() {
		return this.comCode;
	}
	
	/**
	 *
	 * @param String comText
	 */
	public void setComText(String comText) {
		this.comText = comText;
	}
	
	/**
	 * 
	 * @return String comText
	 */
	public String getComText() {
		return this.comText;
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
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setSortKey(JSPUtil.getParameter(request, prefix + "sort_key", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setComCode(JSPUtil.getParameter(request, prefix + "com_code", ""));
		setComText(JSPUtil.getParameter(request, prefix + "com_text", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FmsCodeParamVO[]
	 */
	public FmsCodeParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FmsCodeParamVO[]
	 */
	public FmsCodeParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FmsCodeParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] sortKey = (JSPUtil.getParameter(request, prefix	+ "sort_key", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] comCode = (JSPUtil.getParameter(request, prefix	+ "com_code", length));
			String[] comText = (JSPUtil.getParameter(request, prefix	+ "com_text", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new FmsCodeParamVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (code[i] != null) 
					model.setCode(code[i]);
				if (name[i] != null) 
					model.setName(name[i]);
				if (sortKey[i] != null) 
					model.setSortKey(sortKey[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (comCode[i] != null) 
					model.setComCode(comCode[i]);
				if (comText[i] != null) 
					model.setComText(comText[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFmsCodeParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FmsCodeParamVO[]
	 */
	public FmsCodeParamVO[] getFmsCodeParamVOs(){
		FmsCodeParamVO[] vos = (FmsCodeParamVO[])models.toArray(new FmsCodeParamVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortKey = this.sortKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCode = this.comCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comText = this.comText .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}