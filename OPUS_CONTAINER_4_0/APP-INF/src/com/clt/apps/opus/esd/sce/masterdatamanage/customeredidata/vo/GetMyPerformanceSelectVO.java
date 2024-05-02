/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetMyPerformanceSelectVO.java
*@FileTitle : GetMyPerformanceSelectVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.21 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetMyPerformanceSelectVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetMyPerformanceSelectVO> models = new ArrayList<GetMyPerformanceSelectVO>();
	
	/* Column Info */
	private String d = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String b = null;
	/* Column Info */
	private String c = null;
	/* Column Info */
	private String a = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetMyPerformanceSelectVO() {}

	public GetMyPerformanceSelectVO(String ibflag, String pagerows, String a, String b, String c, String d) {
		this.d = d;
		this.ibflag = ibflag;
		this.b = b;
		this.c = c;
		this.a = a;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d", getD());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("b", getB());
		this.hashColumns.put("c", getC());
		this.hashColumns.put("a", getA());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d", "d");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("b", "b");
		this.hashFields.put("c", "c");
		this.hashFields.put("a", "a");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return d
	 */
	public String getD() {
		return this.d;
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
	 * @return b
	 */
	public String getB() {
		return this.b;
	}
	
	/**
	 * Column Info
	 * @return c
	 */
	public String getC() {
		return this.c;
	}
	
	/**
	 * Column Info
	 * @return a
	 */
	public String getA() {
		return this.a;
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
	 * @param d
	 */
	public void setD(String d) {
		this.d = d;
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
	 * @param b
	 */
	public void setB(String b) {
		this.b = b;
	}
	
	/**
	 * Column Info
	 * @param c
	 */
	public void setC(String c) {
		this.c = c;
	}
	
	/**
	 * Column Info
	 * @param a
	 */
	public void setA(String a) {
		this.a = a;
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
		setD(JSPUtil.getParameter(request, "d", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setB(JSPUtil.getParameter(request, "b", ""));
		setC(JSPUtil.getParameter(request, "c", ""));
		setA(JSPUtil.getParameter(request, "a", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetMyPerformanceSelectVO[]
	 */
	public GetMyPerformanceSelectVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetMyPerformanceSelectVO[]
	 */
	public GetMyPerformanceSelectVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetMyPerformanceSelectVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] d = (JSPUtil.getParameter(request, prefix	+ "d", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] b = (JSPUtil.getParameter(request, prefix	+ "b", length));
			String[] c = (JSPUtil.getParameter(request, prefix	+ "c", length));
			String[] a = (JSPUtil.getParameter(request, prefix	+ "a", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetMyPerformanceSelectVO();
				if (d[i] != null)
					model.setD(d[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (b[i] != null)
					model.setB(b[i]);
				if (c[i] != null)
					model.setC(c[i]);
				if (a[i] != null)
					model.setA(a[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetMyPerformanceSelectVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetMyPerformanceSelectVO[]
	 */
	public GetMyPerformanceSelectVO[] getGetMyPerformanceSelectVOs(){
		GetMyPerformanceSelectVO[] vos = (GetMyPerformanceSelectVO[])models.toArray(new GetMyPerformanceSelectVO[models.size()]);
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
		this.d = this.d .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b = this.b .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c = this.c .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a = this.a .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
