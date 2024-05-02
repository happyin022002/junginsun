/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchGeneralExpenseVO.java
*@FileTitle : SearchGeneralExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.02.24 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchGeneralExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchGeneralExpenseVO> models = new ArrayList<SearchGeneralExpenseVO>();
	
	/* Column Info */
	private String ucAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yrmon3 = null;
	/* Column Info */
	private String yrmon4 = null;
	/* Column Info */
	private String yrmon5 = null;
	/* Column Info */
	private String yrmon6 = null;
	/* Column Info */
	private String yrmon2 = null;
	/* Column Info */
	private String yrmon1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchGeneralExpenseVO() {}

	public SearchGeneralExpenseVO(String ibflag, String pagerows, String ucAmt, String yrmon1, String yrmon2, String yrmon3, String yrmon4, String yrmon5, String yrmon6) {
		this.ucAmt = ucAmt;
		this.ibflag = ibflag;
		this.yrmon3 = yrmon3;
		this.yrmon4 = yrmon4;
		this.yrmon5 = yrmon5;
		this.yrmon6 = yrmon6;
		this.yrmon2 = yrmon2;
		this.yrmon1 = yrmon1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("uc_amt", getUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yrmon3", getYrmon3());
		this.hashColumns.put("yrmon4", getYrmon4());
		this.hashColumns.put("yrmon5", getYrmon5());
		this.hashColumns.put("yrmon6", getYrmon6());
		this.hashColumns.put("yrmon2", getYrmon2());
		this.hashColumns.put("yrmon1", getYrmon1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("uc_amt", "ucAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yrmon3", "yrmon3");
		this.hashFields.put("yrmon4", "yrmon4");
		this.hashFields.put("yrmon5", "yrmon5");
		this.hashFields.put("yrmon6", "yrmon6");
		this.hashFields.put("yrmon2", "yrmon2");
		this.hashFields.put("yrmon1", "yrmon1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ucAmt
	 */
	public String getUcAmt() {
		return this.ucAmt;
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
	 * @return yrmon3
	 */
	public String getYrmon3() {
		return this.yrmon3;
	}
	
	/**
	 * Column Info
	 * @return yrmon4
	 */
	public String getYrmon4() {
		return this.yrmon4;
	}
	
	/**
	 * Column Info
	 * @return yrmon5
	 */
	public String getYrmon5() {
		return this.yrmon5;
	}
	
	/**
	 * Column Info
	 * @return yrmon6
	 */
	public String getYrmon6() {
		return this.yrmon6;
	}
	
	/**
	 * Column Info
	 * @return yrmon2
	 */
	public String getYrmon2() {
		return this.yrmon2;
	}
	
	/**
	 * Column Info
	 * @return yrmon1
	 */
	public String getYrmon1() {
		return this.yrmon1;
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
	 * @param ucAmt
	 */
	public void setUcAmt(String ucAmt) {
		this.ucAmt = ucAmt;
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
	 * @param yrmon3
	 */
	public void setYrmon3(String yrmon3) {
		this.yrmon3 = yrmon3;
	}
	
	/**
	 * Column Info
	 * @param yrmon4
	 */
	public void setYrmon4(String yrmon4) {
		this.yrmon4 = yrmon4;
	}
	
	/**
	 * Column Info
	 * @param yrmon5
	 */
	public void setYrmon5(String yrmon5) {
		this.yrmon5 = yrmon5;
	}
	
	/**
	 * Column Info
	 * @param yrmon6
	 */
	public void setYrmon6(String yrmon6) {
		this.yrmon6 = yrmon6;
	}
	
	/**
	 * Column Info
	 * @param yrmon2
	 */
	public void setYrmon2(String yrmon2) {
		this.yrmon2 = yrmon2;
	}
	
	/**
	 * Column Info
	 * @param yrmon1
	 */
	public void setYrmon1(String yrmon1) {
		this.yrmon1 = yrmon1;
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
		setUcAmt(JSPUtil.getParameter(request, prefix + "uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYrmon3(JSPUtil.getParameter(request, prefix + "yrmon3", ""));
		setYrmon4(JSPUtil.getParameter(request, prefix + "yrmon4", ""));
		setYrmon5(JSPUtil.getParameter(request, prefix + "yrmon5", ""));
		setYrmon6(JSPUtil.getParameter(request, prefix + "yrmon6", ""));
		setYrmon2(JSPUtil.getParameter(request, prefix + "yrmon2", ""));
		setYrmon1(JSPUtil.getParameter(request, prefix + "yrmon1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchGeneralExpenseVO[]
	 */
	public SearchGeneralExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchGeneralExpenseVO[]
	 */
	public SearchGeneralExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchGeneralExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ucAmt = (JSPUtil.getParameter(request, prefix	+ "uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yrmon3 = (JSPUtil.getParameter(request, prefix	+ "yrmon3", length));
			String[] yrmon4 = (JSPUtil.getParameter(request, prefix	+ "yrmon4", length));
			String[] yrmon5 = (JSPUtil.getParameter(request, prefix	+ "yrmon5", length));
			String[] yrmon6 = (JSPUtil.getParameter(request, prefix	+ "yrmon6", length));
			String[] yrmon2 = (JSPUtil.getParameter(request, prefix	+ "yrmon2", length));
			String[] yrmon1 = (JSPUtil.getParameter(request, prefix	+ "yrmon1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchGeneralExpenseVO();
				if (ucAmt[i] != null)
					model.setUcAmt(ucAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yrmon3[i] != null)
					model.setYrmon3(yrmon3[i]);
				if (yrmon4[i] != null)
					model.setYrmon4(yrmon4[i]);
				if (yrmon5[i] != null)
					model.setYrmon5(yrmon5[i]);
				if (yrmon6[i] != null)
					model.setYrmon6(yrmon6[i]);
				if (yrmon2[i] != null)
					model.setYrmon2(yrmon2[i]);
				if (yrmon1[i] != null)
					model.setYrmon1(yrmon1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchGeneralExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchGeneralExpenseVO[]
	 */
	public SearchGeneralExpenseVO[] getSearchGeneralExpenseVOs(){
		SearchGeneralExpenseVO[] vos = (SearchGeneralExpenseVO[])models.toArray(new SearchGeneralExpenseVO[models.size()]);
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
		this.ucAmt = this.ucAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon3 = this.yrmon3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon4 = this.yrmon4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon5 = this.yrmon5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon6 = this.yrmon6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon2 = this.yrmon2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon1 = this.yrmon1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
