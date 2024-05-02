/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchBasicTariffXSLWeekEndVO.java
*@FileTitle : SearchBasicTariffXSLWeekEndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2010.01.05 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicTariffXSLWeekEndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicTariffXSLWeekEndVO> models = new ArrayList<SearchBasicTariffXSLWeekEndVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wknd2 = null;
	/* Column Info */
	private String wknd1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicTariffXSLWeekEndVO() {}

	public SearchBasicTariffXSLWeekEndVO(String ibflag, String pagerows, String wknd1, String wknd2) {
		this.ibflag = ibflag;
		this.wknd2 = wknd2;
		this.wknd1 = wknd1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wknd2", getWknd2());
		this.hashColumns.put("wknd1", getWknd1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wknd2", "wknd2");
		this.hashFields.put("wknd1", "wknd1");
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
	 * @return wknd2
	 */
	public String getWknd2() {
		return this.wknd2;
	}
	
	/**
	 * Column Info
	 * @return wknd1
	 */
	public String getWknd1() {
		return this.wknd1;
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
	 * @param wknd2
	 */
	public void setWknd2(String wknd2) {
		this.wknd2 = wknd2;
	}
	
	/**
	 * Column Info
	 * @param wknd1
	 */
	public void setWknd1(String wknd1) {
		this.wknd1 = wknd1;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWknd2(JSPUtil.getParameter(request, "wknd2", ""));
		setWknd1(JSPUtil.getParameter(request, "wknd1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicTariffXSLWeekEndVO[]
	 */
	public SearchBasicTariffXSLWeekEndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicTariffXSLWeekEndVO[]
	 */
	public SearchBasicTariffXSLWeekEndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicTariffXSLWeekEndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wknd2 = (JSPUtil.getParameter(request, prefix	+ "wknd2", length));
			String[] wknd1 = (JSPUtil.getParameter(request, prefix	+ "wknd1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicTariffXSLWeekEndVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wknd2[i] != null)
					model.setWknd2(wknd2[i]);
				if (wknd1[i] != null)
					model.setWknd1(wknd1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicTariffXSLWeekEndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicTariffXSLWeekEndVO[]
	 */
	public SearchBasicTariffXSLWeekEndVO[] getSearchBasicTariffXSLWeekEndVOs(){
		SearchBasicTariffXSLWeekEndVO[] vos = (SearchBasicTariffXSLWeekEndVO[])models.toArray(new SearchBasicTariffXSLWeekEndVO[models.size()]);
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
		this.wknd2 = this.wknd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wknd1 = this.wknd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
