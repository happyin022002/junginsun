/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchTIExistInformationVO.java
*@FileTitle : SearchTIExistInformationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.22 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTIExistInformationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTIExistInformationVO> models = new ArrayList<SearchTIExistInformationVO>();
	
	/* Column Info */
	private String podetd1 = null;
	/* Column Info */
	private String podetd1Gmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podeta1Gmt = null;
	/* Column Info */
	private String podeta1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTIExistInformationVO() {}

	public SearchTIExistInformationVO(String ibflag, String pagerows, String podeta1, String podeta1Gmt, String podetd1, String podetd1Gmt) {
		this.podetd1 = podetd1;
		this.podetd1Gmt = podetd1Gmt;
		this.ibflag = ibflag;
		this.podeta1Gmt = podeta1Gmt;
		this.podeta1 = podeta1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("podetd1", getPodetd1());
		this.hashColumns.put("podetd1_gmt", getPodetd1Gmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("podeta1_gmt", getPodeta1Gmt());
		this.hashColumns.put("podeta1", getPodeta1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("podetd1", "podetd1");
		this.hashFields.put("podetd1_gmt", "podetd1Gmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("podeta1_gmt", "podeta1Gmt");
		this.hashFields.put("podeta1", "podeta1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podetd1
	 */
	public String getPodetd1() {
		return this.podetd1;
	}
	
	/**
	 * Column Info
	 * @return podetd1Gmt
	 */
	public String getPodetd1Gmt() {
		return this.podetd1Gmt;
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
	 * @return podeta1Gmt
	 */
	public String getPodeta1Gmt() {
		return this.podeta1Gmt;
	}
	
	/**
	 * Column Info
	 * @return podeta1
	 */
	public String getPodeta1() {
		return this.podeta1;
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
	 * @param podetd1
	 */
	public void setPodetd1(String podetd1) {
		this.podetd1 = podetd1;
	}
	
	/**
	 * Column Info
	 * @param podetd1Gmt
	 */
	public void setPodetd1Gmt(String podetd1Gmt) {
		this.podetd1Gmt = podetd1Gmt;
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
	 * @param podeta1Gmt
	 */
	public void setPodeta1Gmt(String podeta1Gmt) {
		this.podeta1Gmt = podeta1Gmt;
	}
	
	/**
	 * Column Info
	 * @param podeta1
	 */
	public void setPodeta1(String podeta1) {
		this.podeta1 = podeta1;
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
		setPodetd1(JSPUtil.getParameter(request, prefix + "podetd1", ""));
		setPodetd1Gmt(JSPUtil.getParameter(request, prefix + "podetd1_gmt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodeta1Gmt(JSPUtil.getParameter(request, prefix + "podeta1_gmt", ""));
		setPodeta1(JSPUtil.getParameter(request, prefix + "podeta1", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTIExistInformationVO[]
	 */
	public SearchTIExistInformationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTIExistInformationVO[]
	 */
	public SearchTIExistInformationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTIExistInformationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podetd1 = (JSPUtil.getParameter(request, prefix	+ "podetd1", length));
			String[] podetd1Gmt = (JSPUtil.getParameter(request, prefix	+ "podetd1_gmt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podeta1Gmt = (JSPUtil.getParameter(request, prefix	+ "podeta1_gmt", length));
			String[] podeta1 = (JSPUtil.getParameter(request, prefix	+ "podeta1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTIExistInformationVO();
				if (podetd1[i] != null)
					model.setPodetd1(podetd1[i]);
				if (podetd1Gmt[i] != null)
					model.setPodetd1Gmt(podetd1Gmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podeta1Gmt[i] != null)
					model.setPodeta1Gmt(podeta1Gmt[i]);
				if (podeta1[i] != null)
					model.setPodeta1(podeta1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTIExistInformationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTIExistInformationVO[]
	 */
	public SearchTIExistInformationVO[] getSearchTIExistInformationVOs(){
		SearchTIExistInformationVO[] vos = (SearchTIExistInformationVO[])models.toArray(new SearchTIExistInformationVO[models.size()]);
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
		this.podetd1 = this.podetd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetd1Gmt = this.podetd1Gmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podeta1Gmt = this.podeta1Gmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podeta1 = this.podeta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
