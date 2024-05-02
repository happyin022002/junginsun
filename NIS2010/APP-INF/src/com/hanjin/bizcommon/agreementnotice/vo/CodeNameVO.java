/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CodeNameVO.java
*@FileTitle : CodeNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.03
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.03 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnotice.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodeNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodeNameVO> models = new ArrayList<CodeNameVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String cd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String codeGuNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CodeNameVO() {}

	public CodeNameVO(String ibflag, String pagerows, String cd, String nm ,String codeGuNm) {
		this.ibflag = ibflag;
		this.nm = nm;
		this.cd = cd;
		this.pagerows = pagerows;
		this.codeGuNm = codeGuNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("code_gubun", getCodeGuNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("cd", "cd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("code_gubun", "codeGuNm");
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
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	
	/**
	 * Column Info
	 * @return cd
	 */
	public String getCd() {
		return this.cd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	/**
	 * Column Info
	 * @param cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	
/**
	 * @return the codeGuNm
	 */
	public String getCodeGuNm() {
		return codeGuNm;
	}

	/**
	 * @param codeGuNm the codeGuNm to set
	 */
	public void setCodeGuNm(String codeGuNm) {
		this.codeGuNm = codeGuNm;
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
		setNm(JSPUtil.getParameter(request, prefix + "nm", ""));
		setCd(JSPUtil.getParameter(request, prefix + "cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCodeGuNm(JSPUtil.getParameter(request, prefix + "code_gubun", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodeNameVO[]
	 */
	public CodeNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodeNameVO[]
	 */
	public CodeNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodeNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] code_gubun = (JSPUtil.getParameter(request, prefix	+ "code_gubun", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodeNameVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (code_gubun[i] != null)
					model.setCodeGuNm(code_gubun[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodeNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodeNameVO[]
	 */
	public CodeNameVO[] getCodeNameVOs(){
		CodeNameVO[] vos = (CodeNameVO[])models.toArray(new CodeNameVO[models.size()]);
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
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeGuNm = this.codeGuNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
