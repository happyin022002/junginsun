/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EdiFlatFileVO.java
*@FileTitle : EdiFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.31
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.07.31 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdiFlatFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiFlatFileVO> models = new ArrayList<EdiFlatFileVO>();
	
	/* Column Info */
	private String flatFile3 = null;
	/* Column Info */
	private String flatFile1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flatFile2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdiFlatFileVO() {}

	public EdiFlatFileVO(String ibflag, String pagerows, String flatFile1, String flatFile2, String flatFile3) {
		this.flatFile3 = flatFile3;
		this.flatFile1 = flatFile1;
		this.ibflag = ibflag;
		this.flatFile2 = flatFile2;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flat_file3", getFlatFile3());
		this.hashColumns.put("flat_file1", getFlatFile1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flat_file2", getFlatFile2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flat_file3", "flatFile3");
		this.hashFields.put("flat_file1", "flatFile1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flat_file2", "flatFile2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return flatFile3
	 */
	public String getFlatFile3() {
		return this.flatFile3;
	}
	
	/**
	 * Column Info
	 * @return flatFile1
	 */
	public String getFlatFile1() {
		return this.flatFile1;
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
	 * @return flatFile2
	 */
	public String getFlatFile2() {
		return this.flatFile2;
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
	 * @param flatFile3
	 */
	public void setFlatFile3(String flatFile3) {
		this.flatFile3 = flatFile3;
	}
	
	/**
	 * Column Info
	 * @param flatFile1
	 */
	public void setFlatFile1(String flatFile1) {
		this.flatFile1 = flatFile1;
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
	 * @param flatFile2
	 */
	public void setFlatFile2(String flatFile2) {
		this.flatFile2 = flatFile2;
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
		setFlatFile3(JSPUtil.getParameter(request, prefix + "flat_file3", ""));
		setFlatFile1(JSPUtil.getParameter(request, prefix + "flat_file1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFlatFile2(JSPUtil.getParameter(request, prefix + "flat_file2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiFlatFileVO[]
	 */
	public EdiFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiFlatFileVO[]
	 */
	public EdiFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiFlatFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] flatFile3 = (JSPUtil.getParameter(request, prefix	+ "flat_file3", length));
			String[] flatFile1 = (JSPUtil.getParameter(request, prefix	+ "flat_file1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flatFile2 = (JSPUtil.getParameter(request, prefix	+ "flat_file2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiFlatFileVO();
				if (flatFile3[i] != null)
					model.setFlatFile3(flatFile3[i]);
				if (flatFile1[i] != null)
					model.setFlatFile1(flatFile1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flatFile2[i] != null)
					model.setFlatFile2(flatFile2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiFlatFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiFlatFileVO[]
	 */
	public EdiFlatFileVO[] getEdiFlatFileVOs(){
		EdiFlatFileVO[] vos = (EdiFlatFileVO[])models.toArray(new EdiFlatFileVO[models.size()]);
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
		this.flatFile3 = this.flatFile3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile1 = this.flatFile1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile2 = this.flatFile2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
