/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDummyWeekVO.java
*@FileTitle : ForecastReportDummyWeekVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo;

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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ForecastReportDummyWeekVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ForecastReportDummyWeekVO> models = new ArrayList<ForecastReportDummyWeekVO>();
	
	/* Column Info */
	private String f6 = null;
	/* Column Info */
	private String p1F = null;
	/* Column Info */
	private String f7 = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String p1 = null;
	/* Column Info */
	private String p2F = null;
	/* Column Info */
	private String c0F = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String c0 = null;
	/* Column Info */
	private String f1F = null;
	/* Column Info */
	private String f7F = null;
	/* Column Info */
	private String f2F = null;
	/* Column Info */
	private String f1 = null;
	/* Column Info */
	private String f5F = null;
	/* Column Info */
	private String f4F = null;
	/* Column Info */
	private String f3 = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String f6F = null;
	/* Column Info */
	private String f3F = null;
	/* Column Info */
	private String f4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ForecastReportDummyWeekVO() {}

	public ForecastReportDummyWeekVO(String ibflag, String pagerows, String p2, String p1, String c0, String f1, String f2, String f3, String f4, String f5, String f6, String f7, String p2F, String p1F, String c0F, String f1F, String f2F, String f3F, String f4F, String f5F, String f6F, String f7F) {
		this.f6 = f6;
		this.p1F = p1F;
		this.f7 = f7;
		this.p2 = p2;
		this.p1 = p1;
		this.p2F = p2F;
		this.c0F = c0F;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.c0 = c0;
		this.f1F = f1F;
		this.f7F = f7F;
		this.f2F = f2F;
		this.f1 = f1;
		this.f5F = f5F;
		this.f4F = f4F;
		this.f3 = f3;
		this.f2 = f2;
		this.f5 = f5;
		this.f6F = f6F;
		this.f3F = f3F;
		this.f4 = f4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f6", getF6());
		this.hashColumns.put("p1_f", getP1F());
		this.hashColumns.put("f7", getF7());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("p1", getP1());
		this.hashColumns.put("p2_f", getP2F());
		this.hashColumns.put("c0_f", getC0F());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c0", getC0());
		this.hashColumns.put("f1_f", getF1F());
		this.hashColumns.put("f7_f", getF7F());
		this.hashColumns.put("f2_f", getF2F());
		this.hashColumns.put("f1", getF1());
		this.hashColumns.put("f5_f", getF5F());
		this.hashColumns.put("f4_f", getF4F());
		this.hashColumns.put("f3", getF3());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("f6_f", getF6F());
		this.hashColumns.put("f3_f", getF3F());
		this.hashColumns.put("f4", getF4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f6", "f6");
		this.hashFields.put("p1_f", "p1F");
		this.hashFields.put("f7", "f7");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("p1", "p1");
		this.hashFields.put("p2_f", "p2F");
		this.hashFields.put("c0_f", "c0F");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c0", "c0");
		this.hashFields.put("f1_f", "f1F");
		this.hashFields.put("f7_f", "f7F");
		this.hashFields.put("f2_f", "f2F");
		this.hashFields.put("f1", "f1");
		this.hashFields.put("f5_f", "f5F");
		this.hashFields.put("f4_f", "f4F");
		this.hashFields.put("f3", "f3");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("f6_f", "f6F");
		this.hashFields.put("f3_f", "f3F");
		this.hashFields.put("f4", "f4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return f6
	 */
	public String getF6() {
		return this.f6;
	}
	
	/**
	 * Column Info
	 * @return p1F
	 */
	public String getP1F() {
		return this.p1F;
	}
	
	/**
	 * Column Info
	 * @return f7
	 */
	public String getF7() {
		return this.f7;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return p1
	 */
	public String getP1() {
		return this.p1;
	}
	
	/**
	 * Column Info
	 * @return p2F
	 */
	public String getP2F() {
		return this.p2F;
	}
	
	/**
	 * Column Info
	 * @return c0F
	 */
	public String getC0F() {
		return this.c0F;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return c0
	 */
	public String getC0() {
		return this.c0;
	}
	
	/**
	 * Column Info
	 * @return f1F
	 */
	public String getF1F() {
		return this.f1F;
	}
	
	/**
	 * Column Info
	 * @return f7F
	 */
	public String getF7F() {
		return this.f7F;
	}
	
	/**
	 * Column Info
	 * @return f2F
	 */
	public String getF2F() {
		return this.f2F;
	}
	
	/**
	 * Column Info
	 * @return f1
	 */
	public String getF1() {
		return this.f1;
	}
	
	/**
	 * Column Info
	 * @return f5F
	 */
	public String getF5F() {
		return this.f5F;
	}
	
	/**
	 * Column Info
	 * @return f4F
	 */
	public String getF4F() {
		return this.f4F;
	}
	
	/**
	 * Column Info
	 * @return f3
	 */
	public String getF3() {
		return this.f3;
	}
	
	/**
	 * Column Info
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return f6F
	 */
	public String getF6F() {
		return this.f6F;
	}
	
	/**
	 * Column Info
	 * @return f3F
	 */
	public String getF3F() {
		return this.f3F;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	

	/**
	 * Column Info
	 * @param f6
	 */
	public void setF6(String f6) {
		this.f6 = f6;
	}
	
	/**
	 * Column Info
	 * @param p1F
	 */
	public void setP1F(String p1F) {
		this.p1F = p1F;
	}
	
	/**
	 * Column Info
	 * @param f7
	 */
	public void setF7(String f7) {
		this.f7 = f7;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param p1
	 */
	public void setP1(String p1) {
		this.p1 = p1;
	}
	
	/**
	 * Column Info
	 * @param p2F
	 */
	public void setP2F(String p2F) {
		this.p2F = p2F;
	}
	
	/**
	 * Column Info
	 * @param c0F
	 */
	public void setC0F(String c0F) {
		this.c0F = c0F;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param c0
	 */
	public void setC0(String c0) {
		this.c0 = c0;
	}
	
	/**
	 * Column Info
	 * @param f1F
	 */
	public void setF1F(String f1F) {
		this.f1F = f1F;
	}
	
	/**
	 * Column Info
	 * @param f7F
	 */
	public void setF7F(String f7F) {
		this.f7F = f7F;
	}
	
	/**
	 * Column Info
	 * @param f2F
	 */
	public void setF2F(String f2F) {
		this.f2F = f2F;
	}
	
	/**
	 * Column Info
	 * @param f1
	 */
	public void setF1(String f1) {
		this.f1 = f1;
	}
	
	/**
	 * Column Info
	 * @param f5F
	 */
	public void setF5F(String f5F) {
		this.f5F = f5F;
	}
	
	/**
	 * Column Info
	 * @param f4F
	 */
	public void setF4F(String f4F) {
		this.f4F = f4F;
	}
	
	/**
	 * Column Info
	 * @param f3
	 */
	public void setF3(String f3) {
		this.f3 = f3;
	}
	
	/**
	 * Column Info
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param f6F
	 */
	public void setF6F(String f6F) {
		this.f6F = f6F;
	}
	
	/**
	 * Column Info
	 * @param f3F
	 */
	public void setF3F(String f3F) {
		this.f3F = f3F;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
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
		setF6(JSPUtil.getParameter(request, prefix + "f6", ""));
		setP1F(JSPUtil.getParameter(request, prefix + "p1_f", ""));
		setF7(JSPUtil.getParameter(request, prefix + "f7", ""));
		setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
		setP1(JSPUtil.getParameter(request, prefix + "p1", ""));
		setP2F(JSPUtil.getParameter(request, prefix + "p2_f", ""));
		setC0F(JSPUtil.getParameter(request, prefix + "c0_f", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setC0(JSPUtil.getParameter(request, prefix + "c0", ""));
		setF1F(JSPUtil.getParameter(request, prefix + "f1_f", ""));
		setF7F(JSPUtil.getParameter(request, prefix + "f7_f", ""));
		setF2F(JSPUtil.getParameter(request, prefix + "f2_f", ""));
		setF1(JSPUtil.getParameter(request, prefix + "f1", ""));
		setF5F(JSPUtil.getParameter(request, prefix + "f5_f", ""));
		setF4F(JSPUtil.getParameter(request, prefix + "f4_f", ""));
		setF3(JSPUtil.getParameter(request, prefix + "f3", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
		setF6F(JSPUtil.getParameter(request, prefix + "f6_f", ""));
		setF3F(JSPUtil.getParameter(request, prefix + "f3_f", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ForecastReportDummyWeekVO[]
	 */
	public ForecastReportDummyWeekVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ForecastReportDummyWeekVO[]
	 */
	public ForecastReportDummyWeekVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ForecastReportDummyWeekVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] f6 = (JSPUtil.getParameter(request, prefix	+ "f6", length));
			String[] p1F = (JSPUtil.getParameter(request, prefix	+ "p1_f", length));
			String[] f7 = (JSPUtil.getParameter(request, prefix	+ "f7", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] p1 = (JSPUtil.getParameter(request, prefix	+ "p1", length));
			String[] p2F = (JSPUtil.getParameter(request, prefix	+ "p2_f", length));
			String[] c0F = (JSPUtil.getParameter(request, prefix	+ "c0_f", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] c0 = (JSPUtil.getParameter(request, prefix	+ "c0", length));
			String[] f1F = (JSPUtil.getParameter(request, prefix	+ "f1_f", length));
			String[] f7F = (JSPUtil.getParameter(request, prefix	+ "f7_f", length));
			String[] f2F = (JSPUtil.getParameter(request, prefix	+ "f2_f", length));
			String[] f1 = (JSPUtil.getParameter(request, prefix	+ "f1", length));
			String[] f5F = (JSPUtil.getParameter(request, prefix	+ "f5_f", length));
			String[] f4F = (JSPUtil.getParameter(request, prefix	+ "f4_f", length));
			String[] f3 = (JSPUtil.getParameter(request, prefix	+ "f3", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] f6F = (JSPUtil.getParameter(request, prefix	+ "f6_f", length));
			String[] f3F = (JSPUtil.getParameter(request, prefix	+ "f3_f", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			
			for (int i = 0; i < length; i++) {
				model = new ForecastReportDummyWeekVO();
				if (f6[i] != null)
					model.setF6(f6[i]);
				if (p1F[i] != null)
					model.setP1F(p1F[i]);
				if (f7[i] != null)
					model.setF7(f7[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (p1[i] != null)
					model.setP1(p1[i]);
				if (p2F[i] != null)
					model.setP2F(p2F[i]);
				if (c0F[i] != null)
					model.setC0F(c0F[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (c0[i] != null)
					model.setC0(c0[i]);
				if (f1F[i] != null)
					model.setF1F(f1F[i]);
				if (f7F[i] != null)
					model.setF7F(f7F[i]);
				if (f2F[i] != null)
					model.setF2F(f2F[i]);
				if (f1[i] != null)
					model.setF1(f1[i]);
				if (f5F[i] != null)
					model.setF5F(f5F[i]);
				if (f4F[i] != null)
					model.setF4F(f4F[i]);
				if (f3[i] != null)
					model.setF3(f3[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (f6F[i] != null)
					model.setF6F(f6F[i]);
				if (f3F[i] != null)
					model.setF3F(f3F[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getForecastReportDummyWeekVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ForecastReportDummyWeekVO[]
	 */
	public ForecastReportDummyWeekVO[] getForecastReportDummyWeekVOs(){
		ForecastReportDummyWeekVO[] vos = (ForecastReportDummyWeekVO[])models.toArray(new ForecastReportDummyWeekVO[models.size()]);
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
		this.f6 = this.f6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p1F = this.p1F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f7 = this.f7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p1 = this.p1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2F = this.p2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c0F = this.c0F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c0 = this.c0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f1F = this.f1F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f7F = this.f7F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2F = this.f2F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f1 = this.f1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5F = this.f5F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4F = this.f4F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f3 = this.f3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f6F = this.f6F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f3F = this.f3F .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
