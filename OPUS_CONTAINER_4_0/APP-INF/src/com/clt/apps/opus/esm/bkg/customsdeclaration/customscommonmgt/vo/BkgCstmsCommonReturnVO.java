/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCstmsCommonReturnVO.java
*@FileTitle : BkgCstmsCommonReturnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo;

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

public class BkgCstmsCommonReturnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsCommonReturnVO> models = new ArrayList<BkgCstmsCommonReturnVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtnCol1 = null;
	/* Column Info */
	private String rtnCol2 = null;
	/* Column Info */
	private String rtnCol3 = null;
	/* Column Info */
	private String rtnCol9 = null;
	/* Column Info */
	private String rtnCol8 = null;
	/* Column Info */
	private String rtnCol7 = null;
	/* Column Info */
	private String rtnCol6 = null;
	/* Column Info */
	private String rtnCol5 = null;
	/* Column Info */
	private String rtnCol4 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsCommonReturnVO() {}

	public BkgCstmsCommonReturnVO(String ibflag, String pagerows, String rtnCol1, String rtnCol2, String rtnCol3, String rtnCol4, String rtnCol5, String rtnCol6, String rtnCol7, String rtnCol8, String rtnCol9) {
		this.ibflag = ibflag;
		this.rtnCol1 = rtnCol1;
		this.rtnCol2 = rtnCol2;
		this.rtnCol3 = rtnCol3;
		this.rtnCol9 = rtnCol9;
		this.rtnCol8 = rtnCol8;
		this.rtnCol7 = rtnCol7;
		this.rtnCol6 = rtnCol6;
		this.rtnCol5 = rtnCol5;
		this.rtnCol4 = rtnCol4;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rtn_col_1", getRtnCol1());
		this.hashColumns.put("rtn_col_2", getRtnCol2());
		this.hashColumns.put("rtn_col_3", getRtnCol3());
		this.hashColumns.put("rtn_col_9", getRtnCol9());
		this.hashColumns.put("rtn_col_8", getRtnCol8());
		this.hashColumns.put("rtn_col_7", getRtnCol7());
		this.hashColumns.put("rtn_col_6", getRtnCol6());
		this.hashColumns.put("rtn_col_5", getRtnCol5());
		this.hashColumns.put("rtn_col_4", getRtnCol4());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rtn_col_1", "rtnCol1");
		this.hashFields.put("rtn_col_2", "rtnCol2");
		this.hashFields.put("rtn_col_3", "rtnCol3");
		this.hashFields.put("rtn_col_9", "rtnCol9");
		this.hashFields.put("rtn_col_8", "rtnCol8");
		this.hashFields.put("rtn_col_7", "rtnCol7");
		this.hashFields.put("rtn_col_6", "rtnCol6");
		this.hashFields.put("rtn_col_5", "rtnCol5");
		this.hashFields.put("rtn_col_4", "rtnCol4");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return rtnCol1
	 */
	public String getRtnCol1() {
		return this.rtnCol1;
	}
	
	/**
	 * Column Info
	 * @return rtnCol2
	 */
	public String getRtnCol2() {
		return this.rtnCol2;
	}
	
	/**
	 * Column Info
	 * @return rtnCol3
	 */
	public String getRtnCol3() {
		return this.rtnCol3;
	}
	
	/**
	 * Column Info
	 * @return rtnCol9
	 */
	public String getRtnCol9() {
		return this.rtnCol9;
	}
	
	/**
	 * Column Info
	 * @return rtnCol8
	 */
	public String getRtnCol8() {
		return this.rtnCol8;
	}
	
	/**
	 * Column Info
	 * @return rtnCol7
	 */
	public String getRtnCol7() {
		return this.rtnCol7;
	}
	
	/**
	 * Column Info
	 * @return rtnCol6
	 */
	public String getRtnCol6() {
		return this.rtnCol6;
	}
	
	/**
	 * Column Info
	 * @return rtnCol5
	 */
	public String getRtnCol5() {
		return this.rtnCol5;
	}
	
	/**
	 * Column Info
	 * @return rtnCol4
	 */
	public String getRtnCol4() {
		return this.rtnCol4;
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
	 * @param rtnCol1
	 */
	public void setRtnCol1(String rtnCol1) {
		this.rtnCol1 = rtnCol1;
	}
	
	/**
	 * Column Info
	 * @param rtnCol2
	 */
	public void setRtnCol2(String rtnCol2) {
		this.rtnCol2 = rtnCol2;
	}
	
	/**
	 * Column Info
	 * @param rtnCol3
	 */
	public void setRtnCol3(String rtnCol3) {
		this.rtnCol3 = rtnCol3;
	}
	
	/**
	 * Column Info
	 * @param rtnCol9
	 */
	public void setRtnCol9(String rtnCol9) {
		this.rtnCol9 = rtnCol9;
	}
	
	/**
	 * Column Info
	 * @param rtnCol8
	 */
	public void setRtnCol8(String rtnCol8) {
		this.rtnCol8 = rtnCol8;
	}
	
	/**
	 * Column Info
	 * @param rtnCol7
	 */
	public void setRtnCol7(String rtnCol7) {
		this.rtnCol7 = rtnCol7;
	}
	
	/**
	 * Column Info
	 * @param rtnCol6
	 */
	public void setRtnCol6(String rtnCol6) {
		this.rtnCol6 = rtnCol6;
	}
	
	/**
	 * Column Info
	 * @param rtnCol5
	 */
	public void setRtnCol5(String rtnCol5) {
		this.rtnCol5 = rtnCol5;
	}
	
	/**
	 * Column Info
	 * @param rtnCol4
	 */
	public void setRtnCol4(String rtnCol4) {
		this.rtnCol4 = rtnCol4;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtnCol1(JSPUtil.getParameter(request, prefix + "rtn_col_1", ""));
		setRtnCol2(JSPUtil.getParameter(request, prefix + "rtn_col_2", ""));
		setRtnCol3(JSPUtil.getParameter(request, prefix + "rtn_col_3", ""));
		setRtnCol9(JSPUtil.getParameter(request, prefix + "rtn_col_9", ""));
		setRtnCol8(JSPUtil.getParameter(request, prefix + "rtn_col_8", ""));
		setRtnCol7(JSPUtil.getParameter(request, prefix + "rtn_col_7", ""));
		setRtnCol6(JSPUtil.getParameter(request, prefix + "rtn_col_6", ""));
		setRtnCol5(JSPUtil.getParameter(request, prefix + "rtn_col_5", ""));
		setRtnCol4(JSPUtil.getParameter(request, prefix + "rtn_col_4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsCommonReturnVO[]
	 */
	public BkgCstmsCommonReturnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsCommonReturnVO[]
	 */
	public BkgCstmsCommonReturnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsCommonReturnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtnCol1 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_1", length));
			String[] rtnCol2 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_2", length));
			String[] rtnCol3 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_3", length));
			String[] rtnCol9 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_9", length));
			String[] rtnCol8 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_8", length));
			String[] rtnCol7 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_7", length));
			String[] rtnCol6 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_6", length));
			String[] rtnCol5 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_5", length));
			String[] rtnCol4 = (JSPUtil.getParameter(request, prefix	+ "rtn_col_4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsCommonReturnVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtnCol1[i] != null)
					model.setRtnCol1(rtnCol1[i]);
				if (rtnCol2[i] != null)
					model.setRtnCol2(rtnCol2[i]);
				if (rtnCol3[i] != null)
					model.setRtnCol3(rtnCol3[i]);
				if (rtnCol9[i] != null)
					model.setRtnCol9(rtnCol9[i]);
				if (rtnCol8[i] != null)
					model.setRtnCol8(rtnCol8[i]);
				if (rtnCol7[i] != null)
					model.setRtnCol7(rtnCol7[i]);
				if (rtnCol6[i] != null)
					model.setRtnCol6(rtnCol6[i]);
				if (rtnCol5[i] != null)
					model.setRtnCol5(rtnCol5[i]);
				if (rtnCol4[i] != null)
					model.setRtnCol4(rtnCol4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsCommonReturnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsCommonReturnVO[]
	 */
	public BkgCstmsCommonReturnVO[] getBkgCstmsCommonReturnVOs(){
		BkgCstmsCommonReturnVO[] vos = (BkgCstmsCommonReturnVO[])models.toArray(new BkgCstmsCommonReturnVO[models.size()]);
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
		this.rtnCol1 = this.rtnCol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol2 = this.rtnCol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol3 = this.rtnCol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol9 = this.rtnCol9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol8 = this.rtnCol8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol7 = this.rtnCol7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol6 = this.rtnCol6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol5 = this.rtnCol5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnCol4 = this.rtnCol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
