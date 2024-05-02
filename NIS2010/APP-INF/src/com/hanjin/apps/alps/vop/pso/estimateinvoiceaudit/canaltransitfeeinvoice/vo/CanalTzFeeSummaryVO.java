/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CanalTzFeeSummaryVO.java
*@FileTitle : CanalTzFeeSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo;

import java.lang.reflect.Field;
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
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeSummaryVO> models = new ArrayList<CanalTzFeeSummaryVO>();
	
	/* Column Info */
	private String lgsCostCd2 = null;
	/* Column Info */
	private String lgsCostCd3 = null;
	/* Column Info */
	private String lgsCostCd4 = null;
	/* Column Info */
	private String lgsCostCd5 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lgsCostCd1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String lgsCostCd7 = null;
	/* Column Info */
	private String lgsCostCd13 = null;
	/* Column Info */
	private String lgsCostCd6 = null;
	/* Column Info */
	private String lgsCostCd9 = null;
	/* Column Info */
	private String lgsCostCd8 = null;
	/* Column Info */
	private String lgsCostCd10 = null;
	/* Column Info */
	private String lgsCostCd12 = null;
	/* Column Info */
	private String lgsCostCd11 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CanalTzFeeSummaryVO() {}

	public CanalTzFeeSummaryVO(String ibflag, String pagerows, String title, String lgsCostCd1, String lgsCostCd2, String lgsCostCd3, String lgsCostCd4, String lgsCostCd5, String lgsCostCd6, String lgsCostCd7, String lgsCostCd8, String lgsCostCd9, String lgsCostCd10, String lgsCostCd11, String lgsCostCd12, String lgsCostCd13) {
		this.lgsCostCd2 = lgsCostCd2;
		this.lgsCostCd3 = lgsCostCd3;
		this.lgsCostCd4 = lgsCostCd4;
		this.lgsCostCd5 = lgsCostCd5;
		this.pagerows = pagerows;
		this.lgsCostCd1 = lgsCostCd1;
		this.ibflag = ibflag;
		this.title = title;
		this.lgsCostCd7 = lgsCostCd7;
		this.lgsCostCd13 = lgsCostCd13;
		this.lgsCostCd6 = lgsCostCd6;
		this.lgsCostCd9 = lgsCostCd9;
		this.lgsCostCd8 = lgsCostCd8;
		this.lgsCostCd10 = lgsCostCd10;
		this.lgsCostCd12 = lgsCostCd12;
		this.lgsCostCd11 = lgsCostCd11;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lgs_cost_cd2", getLgsCostCd2());
		this.hashColumns.put("lgs_cost_cd3", getLgsCostCd3());
		this.hashColumns.put("lgs_cost_cd4", getLgsCostCd4());
		this.hashColumns.put("lgs_cost_cd5", getLgsCostCd5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lgs_cost_cd1", getLgsCostCd1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("lgs_cost_cd7", getLgsCostCd7());
		this.hashColumns.put("lgs_cost_cd13", getLgsCostCd13());
		this.hashColumns.put("lgs_cost_cd6", getLgsCostCd6());
		this.hashColumns.put("lgs_cost_cd9", getLgsCostCd9());
		this.hashColumns.put("lgs_cost_cd8", getLgsCostCd8());
		this.hashColumns.put("lgs_cost_cd10", getLgsCostCd10());
		this.hashColumns.put("lgs_cost_cd12", getLgsCostCd12());
		this.hashColumns.put("lgs_cost_cd11", getLgsCostCd11());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lgs_cost_cd2", "lgsCostCd2");
		this.hashFields.put("lgs_cost_cd3", "lgsCostCd3");
		this.hashFields.put("lgs_cost_cd4", "lgsCostCd4");
		this.hashFields.put("lgs_cost_cd5", "lgsCostCd5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lgs_cost_cd1", "lgsCostCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("lgs_cost_cd7", "lgsCostCd7");
		this.hashFields.put("lgs_cost_cd13", "lgsCostCd13");
		this.hashFields.put("lgs_cost_cd6", "lgsCostCd6");
		this.hashFields.put("lgs_cost_cd9", "lgsCostCd9");
		this.hashFields.put("lgs_cost_cd8", "lgsCostCd8");
		this.hashFields.put("lgs_cost_cd10", "lgsCostCd10");
		this.hashFields.put("lgs_cost_cd12", "lgsCostCd12");
		this.hashFields.put("lgs_cost_cd11", "lgsCostCd11");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd2
	 */
	public String getLgsCostCd2() {
		return this.lgsCostCd2;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd3
	 */
	public String getLgsCostCd3() {
		return this.lgsCostCd3;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd4
	 */
	public String getLgsCostCd4() {
		return this.lgsCostCd4;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd5
	 */
	public String getLgsCostCd5() {
		return this.lgsCostCd5;
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
	 * @return lgsCostCd1
	 */
	public String getLgsCostCd1() {
		return this.lgsCostCd1;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd7
	 */
	public String getLgsCostCd7() {
		return this.lgsCostCd7;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd13
	 */
	public String getLgsCostCd13() {
		return this.lgsCostCd13;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd6
	 */
	public String getLgsCostCd6() {
		return this.lgsCostCd6;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd9
	 */
	public String getLgsCostCd9() {
		return this.lgsCostCd9;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd8
	 */
	public String getLgsCostCd8() {
		return this.lgsCostCd8;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd10
	 */
	public String getLgsCostCd10() {
		return this.lgsCostCd10;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd12
	 */
	public String getLgsCostCd12() {
		return this.lgsCostCd12;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd11
	 */
	public String getLgsCostCd11() {
		return this.lgsCostCd11;
	}
	

	/**
	 * Column Info
	 * @param lgsCostCd2
	 */
	public void setLgsCostCd2(String lgsCostCd2) {
		this.lgsCostCd2 = lgsCostCd2;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd3
	 */
	public void setLgsCostCd3(String lgsCostCd3) {
		this.lgsCostCd3 = lgsCostCd3;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd4
	 */
	public void setLgsCostCd4(String lgsCostCd4) {
		this.lgsCostCd4 = lgsCostCd4;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd5
	 */
	public void setLgsCostCd5(String lgsCostCd5) {
		this.lgsCostCd5 = lgsCostCd5;
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
	 * @param lgsCostCd1
	 */
	public void setLgsCostCd1(String lgsCostCd1) {
		this.lgsCostCd1 = lgsCostCd1;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd7
	 */
	public void setLgsCostCd7(String lgsCostCd7) {
		this.lgsCostCd7 = lgsCostCd7;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd13
	 */
	public void setLgsCostCd13(String lgsCostCd13) {
		this.lgsCostCd13 = lgsCostCd13;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd6
	 */
	public void setLgsCostCd6(String lgsCostCd6) {
		this.lgsCostCd6 = lgsCostCd6;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd9
	 */
	public void setLgsCostCd9(String lgsCostCd9) {
		this.lgsCostCd9 = lgsCostCd9;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd8
	 */
	public void setLgsCostCd8(String lgsCostCd8) {
		this.lgsCostCd8 = lgsCostCd8;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd10
	 */
	public void setLgsCostCd10(String lgsCostCd10) {
		this.lgsCostCd10 = lgsCostCd10;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd12
	 */
	public void setLgsCostCd12(String lgsCostCd12) {
		this.lgsCostCd12 = lgsCostCd12;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd11
	 */
	public void setLgsCostCd11(String lgsCostCd11) {
		this.lgsCostCd11 = lgsCostCd11;
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
		setLgsCostCd2(JSPUtil.getParameter(request, prefix + "lgs_cost_cd2", ""));
		setLgsCostCd3(JSPUtil.getParameter(request, prefix + "lgs_cost_cd3", ""));
		setLgsCostCd4(JSPUtil.getParameter(request, prefix + "lgs_cost_cd4", ""));
		setLgsCostCd5(JSPUtil.getParameter(request, prefix + "lgs_cost_cd5", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLgsCostCd1(JSPUtil.getParameter(request, prefix + "lgs_cost_cd1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setLgsCostCd7(JSPUtil.getParameter(request, prefix + "lgs_cost_cd7", ""));
		setLgsCostCd13(JSPUtil.getParameter(request, prefix + "lgs_cost_cd13", ""));
		setLgsCostCd6(JSPUtil.getParameter(request, prefix + "lgs_cost_cd6", ""));
		setLgsCostCd9(JSPUtil.getParameter(request, prefix + "lgs_cost_cd9", ""));
		setLgsCostCd8(JSPUtil.getParameter(request, prefix + "lgs_cost_cd8", ""));
		setLgsCostCd10(JSPUtil.getParameter(request, prefix + "lgs_cost_cd10", ""));
		setLgsCostCd12(JSPUtil.getParameter(request, prefix + "lgs_cost_cd12", ""));
		setLgsCostCd11(JSPUtil.getParameter(request, prefix + "lgs_cost_cd11", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeSummaryVO[]
	 */
	public CanalTzFeeSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeSummaryVO[]
	 */
	public CanalTzFeeSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lgsCostCd2 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd2", length));
			String[] lgsCostCd3 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd3", length));
			String[] lgsCostCd4 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd4", length));
			String[] lgsCostCd5 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lgsCostCd1 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] lgsCostCd7 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd7", length));
			String[] lgsCostCd13 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd13", length));
			String[] lgsCostCd6 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd6", length));
			String[] lgsCostCd9 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd9", length));
			String[] lgsCostCd8 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd8", length));
			String[] lgsCostCd10 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd10", length));
			String[] lgsCostCd12 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd12", length));
			String[] lgsCostCd11 = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd11", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeSummaryVO();
				if (lgsCostCd2[i] != null)
					model.setLgsCostCd2(lgsCostCd2[i]);
				if (lgsCostCd3[i] != null)
					model.setLgsCostCd3(lgsCostCd3[i]);
				if (lgsCostCd4[i] != null)
					model.setLgsCostCd4(lgsCostCd4[i]);
				if (lgsCostCd5[i] != null)
					model.setLgsCostCd5(lgsCostCd5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lgsCostCd1[i] != null)
					model.setLgsCostCd1(lgsCostCd1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (lgsCostCd7[i] != null)
					model.setLgsCostCd7(lgsCostCd7[i]);
				if (lgsCostCd13[i] != null)
					model.setLgsCostCd13(lgsCostCd13[i]);
				if (lgsCostCd6[i] != null)
					model.setLgsCostCd6(lgsCostCd6[i]);
				if (lgsCostCd9[i] != null)
					model.setLgsCostCd9(lgsCostCd9[i]);
				if (lgsCostCd8[i] != null)
					model.setLgsCostCd8(lgsCostCd8[i]);
				if (lgsCostCd10[i] != null)
					model.setLgsCostCd10(lgsCostCd10[i]);
				if (lgsCostCd12[i] != null)
					model.setLgsCostCd12(lgsCostCd12[i]);
				if (lgsCostCd11[i] != null)
					model.setLgsCostCd11(lgsCostCd11[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeSummaryVO[]
	 */
	public CanalTzFeeSummaryVO[] getCanalTzFeeSummaryVOs(){
		CanalTzFeeSummaryVO[] vos = (CanalTzFeeSummaryVO[])models.toArray(new CanalTzFeeSummaryVO[models.size()]);
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
		this.lgsCostCd2 = this.lgsCostCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd3 = this.lgsCostCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd4 = this.lgsCostCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd5 = this.lgsCostCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd1 = this.lgsCostCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd7 = this.lgsCostCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd13 = this.lgsCostCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd6 = this.lgsCostCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd9 = this.lgsCostCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd8 = this.lgsCostCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd10 = this.lgsCostCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd12 = this.lgsCostCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd11 = this.lgsCostCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
