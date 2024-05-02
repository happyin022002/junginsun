/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchStsListVO.java
*@FileTitle : SearchStsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.01 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchStsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStsListVO> models = new ArrayList<SearchStsListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String csDesc = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String stndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStsListVO() {}

	public SearchStsListVO(String ibflag, String pagerows, String stndCd, String csDesc, String custCd) {
		this.ibflag = ibflag;
		this.csDesc = csDesc;
		this.custCd = custCd;
		this.stndCd = stndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cs_desc", getCsDesc());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("stnd_cd", getStndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cs_desc", "csDesc");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("stnd_cd", "stndCd");
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
	 * @return csDesc
	 */
	public String getCsDesc() {
		return this.csDesc;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return stndCd
	 */
	public String getStndCd() {
		return this.stndCd;
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
	 * @param csDesc
	 */
	public void setCsDesc(String csDesc) {
		this.csDesc = csDesc;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param stndCd
	 */
	public void setStndCd(String stndCd) {
		this.stndCd = stndCd;
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
		setCsDesc(JSPUtil.getParameter(request, "cs_desc", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setStndCd(JSPUtil.getParameter(request, "stnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStsListVO[]
	 */
	public SearchStsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStsListVO[]
	 */
	public SearchStsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] csDesc = (JSPUtil.getParameter(request, prefix	+ "cs_desc", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] stndCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStsListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (csDesc[i] != null)
					model.setCsDesc(csDesc[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (stndCd[i] != null)
					model.setStndCd(stndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStsListVO[]
	 */
	public SearchStsListVO[] getSearchStsListVOs(){
		SearchStsListVO[] vos = (SearchStsListVO[])models.toArray(new SearchStsListVO[models.size()]);
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
		this.csDesc = this.csDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCd = this.stndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
