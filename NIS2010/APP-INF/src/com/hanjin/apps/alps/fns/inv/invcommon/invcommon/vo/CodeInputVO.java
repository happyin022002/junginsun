/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeInputVO.java
*@FileTitle : CodeInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.11.22 이석준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 이석준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class CodeInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodeInputVO> models = new ArrayList<CodeInputVO>();
	
	/* Column Info */
	private String codeDesc = null;
	/* Column Info */
	private String col4 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String col1 = null;
	/* Column Info */
	private String col3 = null;
	/* Column Info */
	private String col2 = null;
	/* Column Info */
	private String code = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodeInputVO() {}

	public CodeInputVO(String ibflag, String pagerows, String gubun, String code, String codeDesc, String col1, String col2, String col3, String col4) {
		this.codeDesc = codeDesc;
		this.col4 = col4;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.col1 = col1;
		this.col3 = col3;
		this.col2 = col2;
		this.code = code;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("code_desc", getCodeDesc());
		this.hashColumns.put("col4", getCol4());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("col1", getCol1());
		this.hashColumns.put("col3", getCol3());
		this.hashColumns.put("col2", getCol2());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("code_desc", "codeDesc");
		this.hashFields.put("col4", "col4");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("col1", "col1");
		this.hashFields.put("col3", "col3");
		this.hashFields.put("col2", "col2");
		this.hashFields.put("code", "code");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return codeDesc
	 */
	public String getCodeDesc() {
		return this.codeDesc;
	}
	
	/**
	 * Column Info
	 * @return col4
	 */
	public String getCol4() {
		return this.col4;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return col1
	 */
	public String getCol1() {
		return this.col1;
	}
	
	/**
	 * Column Info
	 * @return col3
	 */
	public String getCol3() {
		return this.col3;
	}
	
	/**
	 * Column Info
	 * @return col2
	 */
	public String getCol2() {
		return this.col2;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @param codeDesc
	 */
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	/**
	 * Column Info
	 * @param col4
	 */
	public void setCol4(String col4) {
		this.col4 = col4;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param col1
	 */
	public void setCol1(String col1) {
		this.col1 = col1;
	}
	
	/**
	 * Column Info
	 * @param col3
	 */
	public void setCol3(String col3) {
		this.col3 = col3;
	}
	
	/**
	 * Column Info
	 * @param col2
	 */
	public void setCol2(String col2) {
		this.col2 = col2;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
		setCodeDesc(JSPUtil.getParameter(request, prefix + "code_desc", ""));
		setCol4(JSPUtil.getParameter(request, prefix + "col4", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setCol1(JSPUtil.getParameter(request, prefix + "col1", ""));
		setCol3(JSPUtil.getParameter(request, prefix + "col3", ""));
		setCol2(JSPUtil.getParameter(request, prefix + "col2", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodeInputVO[]
	 */
	public CodeInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodeInputVO[]
	 */
	public CodeInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodeInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] codeDesc = (JSPUtil.getParameter(request, prefix	+ "code_desc", length));
			String[] col4 = (JSPUtil.getParameter(request, prefix	+ "col4", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] col1 = (JSPUtil.getParameter(request, prefix	+ "col1", length));
			String[] col3 = (JSPUtil.getParameter(request, prefix	+ "col3", length));
			String[] col2 = (JSPUtil.getParameter(request, prefix	+ "col2", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodeInputVO();
				if (codeDesc[i] != null)
					model.setCodeDesc(codeDesc[i]);
				if (col4[i] != null)
					model.setCol4(col4[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (col1[i] != null)
					model.setCol1(col1[i]);
				if (col3[i] != null)
					model.setCol3(col3[i]);
				if (col2[i] != null)
					model.setCol2(col2[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodeInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodeInputVO[]
	 */
	public CodeInputVO[] getCodeInputVOs(){
		CodeInputVO[] vos = (CodeInputVO[])models.toArray(new CodeInputVO[models.size()]);
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
		this.codeDesc = this.codeDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col4 = this.col4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col1 = this.col1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col3 = this.col3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col2 = this.col2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
