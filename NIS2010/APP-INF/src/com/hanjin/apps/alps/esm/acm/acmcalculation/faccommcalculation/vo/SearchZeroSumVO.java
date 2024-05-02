/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchZeroSumVO.java
*@FileTitle : SearchZeroSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchZeroSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchZeroSumVO> models = new ArrayList<SearchZeroSumVO>();
	
	/* Column Info */
	private String ffStepRow = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agnZeroSum = null;
	/* Column Info */
	private String agnStepRow = null;
	/* Column Info */
	private String ffZeroSum = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchZeroSumVO() {}

	public SearchZeroSumVO(String ibflag, String pagerows, String ffStepRow, String ffZeroSum, String agnStepRow, String agnZeroSum) {
		this.ffStepRow = ffStepRow;
		this.ibflag = ibflag;
		this.agnZeroSum = agnZeroSum;
		this.agnStepRow = agnStepRow;
		this.ffZeroSum = ffZeroSum;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ff_step_row", getFfStepRow());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agn_zero_sum", getAgnZeroSum());
		this.hashColumns.put("agn_step_row", getAgnStepRow());
		this.hashColumns.put("ff_zero_sum", getFfZeroSum());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ff_step_row", "ffStepRow");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agn_zero_sum", "agnZeroSum");
		this.hashFields.put("agn_step_row", "agnStepRow");
		this.hashFields.put("ff_zero_sum", "ffZeroSum");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ffStepRow
	 */
	public String getFfStepRow() {
		return this.ffStepRow;
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
	 * @return agnZeroSum
	 */
	public String getAgnZeroSum() {
		return this.agnZeroSum;
	}
	
	/**
	 * Column Info
	 * @return agnStepRow
	 */
	public String getAgnStepRow() {
		return this.agnStepRow;
	}
	
	/**
	 * Column Info
	 * @return ffZeroSum
	 */
	public String getFfZeroSum() {
		return this.ffZeroSum;
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
	 * @param ffStepRow
	 */
	public void setFfStepRow(String ffStepRow) {
		this.ffStepRow = ffStepRow;
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
	 * @param agnZeroSum
	 */
	public void setAgnZeroSum(String agnZeroSum) {
		this.agnZeroSum = agnZeroSum;
	}
	
	/**
	 * Column Info
	 * @param agnStepRow
	 */
	public void setAgnStepRow(String agnStepRow) {
		this.agnStepRow = agnStepRow;
	}
	
	/**
	 * Column Info
	 * @param ffZeroSum
	 */
	public void setFfZeroSum(String ffZeroSum) {
		this.ffZeroSum = ffZeroSum;
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
		setFfStepRow(JSPUtil.getParameter(request, prefix + "ff_step_row", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAgnZeroSum(JSPUtil.getParameter(request, prefix + "agn_zero_sum", ""));
		setAgnStepRow(JSPUtil.getParameter(request, prefix + "agn_step_row", ""));
		setFfZeroSum(JSPUtil.getParameter(request, prefix + "ff_zero_sum", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchZeroSumVO[]
	 */
	public SearchZeroSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchZeroSumVO[]
	 */
	public SearchZeroSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchZeroSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ffStepRow = (JSPUtil.getParameter(request, prefix	+ "ff_step_row", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agnZeroSum = (JSPUtil.getParameter(request, prefix	+ "agn_zero_sum", length));
			String[] agnStepRow = (JSPUtil.getParameter(request, prefix	+ "agn_step_row", length));
			String[] ffZeroSum = (JSPUtil.getParameter(request, prefix	+ "ff_zero_sum", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchZeroSumVO();
				if (ffStepRow[i] != null)
					model.setFfStepRow(ffStepRow[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agnZeroSum[i] != null)
					model.setAgnZeroSum(agnZeroSum[i]);
				if (agnStepRow[i] != null)
					model.setAgnStepRow(agnStepRow[i]);
				if (ffZeroSum[i] != null)
					model.setFfZeroSum(ffZeroSum[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchZeroSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchZeroSumVO[]
	 */
	public SearchZeroSumVO[] getSearchZeroSumVOs(){
		SearchZeroSumVO[] vos = (SearchZeroSumVO[])models.toArray(new SearchZeroSumVO[models.size()]);
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
		this.ffStepRow = this.ffStepRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnZeroSum = this.agnZeroSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnStepRow = this.agnStepRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffZeroSum = this.ffZeroSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
