/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFocByFreightListVO.java
*@FilecolAmt : SearchFocByFreightListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.29 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFocByFreightListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFocByFreightListVO> models = new ArrayList<SearchFocByFreightListVO>();
	
	/* Column Info */
	private String col = null;
	/* Column Info */
	private String colAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String cctAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFocByFreightListVO() {}

	public SearchFocByFreightListVO(String ibflag, String pagerows, String col, String colAmt, String cctAmt,String cct) {
		this.col = col;
		this.colAmt = colAmt;
		this.ibflag = ibflag;
		this.cct = cct;
		this.cctAmt = cctAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("col", getcol());
		this.hashColumns.put("col_amt", getcolAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cct_amt", getcctAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("col", "col");
		this.hashFields.put("col_amt", "colAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cct_amt", "cctAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return col
	 */
	public String getcol() {
		return this.col;
	}
	
	/**
	 * Column Info
	 * @return colAmt
	 */
	public String getcolAmt() {
		return this.colAmt;
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
	 * @return cct
	 */
	public String getcct() {
		return this.cct;
	}
	
	/**
	 * Column Info
	 * @return cctAmt
	 */
	public String getcctAmt() {
		return this.cctAmt;
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
	 * @param col
	 */
	public void setcol(String col) {
		this.col = col;
	}
	
	/**
	 * Column Info
	 * @param colAmt
	 */
	public void setcolAmt(String colAmt) {
		this.colAmt = colAmt;
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
	 * @param cct
	 */
	public void setcct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * Column Info
	 * @param cctAmt
	 */
	public void setcctAmt(String cctAmt) {
		this.cctAmt = cctAmt;
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
		setcol(JSPUtil.getParameter(request, "col", ""));
		setcolAmt(JSPUtil.getParameter(request, "col_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setcctAmt(JSPUtil.getParameter(request, "cct_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFocByFreightListVO[]
	 */
	public SearchFocByFreightListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFocByFreightListVO[]
	 */
	public SearchFocByFreightListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFocByFreightListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			String[] colAmt = (JSPUtil.getParameter(request, prefix	+ "col_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cctAmt = (JSPUtil.getParameter(request, prefix	+ "cct_amt", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFocByFreightListVO();
				if (col[i] != null)
					model.setcol(col[i]);
				if (colAmt[i] != null)
					model.setcolAmt(colAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cct[i] != null)
					model.setcct(cct[i]);
				if (cctAmt[i] != null)
					model.setcctAmt(cctAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFocByFreightListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFocByFreightListVO[]
	 */
	public SearchFocByFreightListVO[] getSearchFocByFreightListVOs(){
		SearchFocByFreightListVO[] vos = (SearchFocByFreightListVO[])models.toArray(new SearchFocByFreightListVO[models.size()]);
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
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colAmt = this.colAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctAmt = this.cctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
