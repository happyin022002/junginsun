/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonVO.java
*@FileTitle : CommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.09 김상수
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CommonVO> models = new ArrayList<CommonVO>();

	/* Column Info */
	private String value0 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String value9 = null;
	/* Column Info */
	private String value7 = null;
	/* Column Info */
	private String value8 = null;
	/* Column Info */
	private String value5 = null;
	/* Column Info */
	private String value6 = null;
	/* Column Info */
	private String value3 = null;
	/* Column Info */
	private String value4 = null;
	/* Column Info */
	private String value1 = null;
	/* Column Info */
	private String value2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CommonVO() {}

	public CommonVO(String ibflag, String pagerows, String value0, String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9) {
		this.value0 = value0;
		this.ibflag = ibflag;
		this.value9 = value9;
		this.value7 = value7;
		this.value8 = value8;
		this.value5 = value5;
		this.value6 = value6;
		this.value3 = value3;
		this.value4 = value4;
		this.value1 = value1;
		this.value2 = value2;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("value0", getValue0());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("value9", getValue9());
		this.hashColumns.put("value7", getValue7());
		this.hashColumns.put("value8", getValue8());
		this.hashColumns.put("value5", getValue5());
		this.hashColumns.put("value6", getValue6());
		this.hashColumns.put("value3", getValue3());
		this.hashColumns.put("value4", getValue4());
		this.hashColumns.put("value1", getValue1());
		this.hashColumns.put("value2", getValue2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("value0", "value0");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("value9", "value9");
		this.hashFields.put("value7", "value7");
		this.hashFields.put("value8", "value8");
		this.hashFields.put("value5", "value5");
		this.hashFields.put("value6", "value6");
		this.hashFields.put("value3", "value3");
		this.hashFields.put("value4", "value4");
		this.hashFields.put("value1", "value1");
		this.hashFields.put("value2", "value2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return value0
	 */
	public String getValue0() {
		return this.value0;
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
	 * @return value9
	 */
	public String getValue9() {
		return this.value9;
	}

	/**
	 * Column Info
	 * @return value7
	 */
	public String getValue7() {
		return this.value7;
	}

	/**
	 * Column Info
	 * @return value8
	 */
	public String getValue8() {
		return this.value8;
	}

	/**
	 * Column Info
	 * @return value5
	 */
	public String getValue5() {
		return this.value5;
	}

	/**
	 * Column Info
	 * @return value6
	 */
	public String getValue6() {
		return this.value6;
	}

	/**
	 * Column Info
	 * @return value3
	 */
	public String getValue3() {
		return this.value3;
	}

	/**
	 * Column Info
	 * @return value4
	 */
	public String getValue4() {
		return this.value4;
	}

	/**
	 * Column Info
	 * @return value1
	 */
	public String getValue1() {
		return this.value1;
	}

	/**
	 * Column Info
	 * @return value2
	 */
	public String getValue2() {
		return this.value2;
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
	 * @param value0
	 */
	public void setValue0(String value0) {
		this.value0 = value0;
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
	 * @param value9
	 */
	public void setValue9(String value9) {
		this.value9 = value9;
	}

	/**
	 * Column Info
	 * @param value7
	 */
	public void setValue7(String value7) {
		this.value7 = value7;
	}

	/**
	 * Column Info
	 * @param value8
	 */
	public void setValue8(String value8) {
		this.value8 = value8;
	}

	/**
	 * Column Info
	 * @param value5
	 */
	public void setValue5(String value5) {
		this.value5 = value5;
	}

	/**
	 * Column Info
	 * @param value6
	 */
	public void setValue6(String value6) {
		this.value6 = value6;
	}

	/**
	 * Column Info
	 * @param value3
	 */
	public void setValue3(String value3) {
		this.value3 = value3;
	}

	/**
	 * Column Info
	 * @param value4
	 */
	public void setValue4(String value4) {
		this.value4 = value4;
	}

	/**
	 * Column Info
	 * @param value1
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}

	/**
	 * Column Info
	 * @param value2
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
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
		setValue0(JSPUtil.getParameter(request, prefix + "value0", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setValue9(JSPUtil.getParameter(request, prefix + "value9", ""));
		setValue7(JSPUtil.getParameter(request, prefix + "value7", ""));
		setValue8(JSPUtil.getParameter(request, prefix + "value8", ""));
		setValue5(JSPUtil.getParameter(request, prefix + "value5", ""));
		setValue6(JSPUtil.getParameter(request, prefix + "value6", ""));
		setValue3(JSPUtil.getParameter(request, prefix + "value3", ""));
		setValue4(JSPUtil.getParameter(request, prefix + "value4", ""));
		setValue1(JSPUtil.getParameter(request, prefix + "value1", ""));
		setValue2(JSPUtil.getParameter(request, prefix + "value2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
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
			String[] value0 = (JSPUtil.getParameter(request, prefix	+ "value0", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] value9 = (JSPUtil.getParameter(request, prefix	+ "value9", length));
			String[] value7 = (JSPUtil.getParameter(request, prefix	+ "value7", length));
			String[] value8 = (JSPUtil.getParameter(request, prefix	+ "value8", length));
			String[] value5 = (JSPUtil.getParameter(request, prefix	+ "value5", length));
			String[] value6 = (JSPUtil.getParameter(request, prefix	+ "value6", length));
			String[] value3 = (JSPUtil.getParameter(request, prefix	+ "value3", length));
			String[] value4 = (JSPUtil.getParameter(request, prefix	+ "value4", length));
			String[] value1 = (JSPUtil.getParameter(request, prefix	+ "value1", length));
			String[] value2 = (JSPUtil.getParameter(request, prefix	+ "value2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CommonVO();
				if (value0[i] != null)
					model.setValue0(value0[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (value9[i] != null)
					model.setValue9(value9[i]);
				if (value7[i] != null)
					model.setValue7(value7[i]);
				if (value8[i] != null)
					model.setValue8(value8[i]);
				if (value5[i] != null)
					model.setValue5(value5[i]);
				if (value6[i] != null)
					model.setValue6(value6[i]);
				if (value3[i] != null)
					model.setValue3(value3[i]);
				if (value4[i] != null)
					model.setValue4(value4[i]);
				if (value1[i] != null)
					model.setValue1(value1[i]);
				if (value2[i] != null)
					model.setValue2(value2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
		this.value0 = this.value0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value9 = this.value9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value7 = this.value7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value8 = this.value8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value5 = this.value5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value6 = this.value6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value3 = this.value3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value4 = this.value4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value1 = this.value1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.value2 = this.value2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
