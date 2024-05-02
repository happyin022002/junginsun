/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDocumentationInfoVO.java
*@FileTitle : SearchDocumentationInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.21 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDocumentationInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDocumentationInfoVO> models = new ArrayList<SearchDocumentationInfoVO>();
	
	/* Column Info */
	private String occDate = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String except = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String occTime = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDocumentationInfoVO() {}

	public SearchDocumentationInfoVO(String ibflag, String pagerows, String actCd, String actNm, String occDate, String occTime, String except) {
		this.occDate = occDate;
		this.actCd = actCd;
		this.except = except;
		this.ibflag = ibflag;
		this.actNm = actNm;
		this.occTime = occTime;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("occ_date", getOccDate());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("except", getExcept());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("occ_time", getOccTime());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("occ_date", "occDate");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("except", "except");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("occ_time", "occTime");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return occDate
	 */
	public String getOccDate() {
		return this.occDate;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return except
	 */
	public String getExcept() {
		return this.except;
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
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return occTime
	 */
	public String getOccTime() {
		return this.occTime;
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
	 * @param occDate
	 */
	public void setOccDate(String occDate) {
		this.occDate = occDate;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param except
	 */
	public void setExcept(String except) {
		this.except = except;
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
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param occTime
	 */
	public void setOccTime(String occTime) {
		this.occTime = occTime;
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
		setOccDate(JSPUtil.getParameter(request, prefix + "occ_date", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setExcept(JSPUtil.getParameter(request, prefix + "except", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActNm(JSPUtil.getParameter(request, prefix + "act_nm", ""));
		setOccTime(JSPUtil.getParameter(request, prefix + "occ_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDocumentationInfoVO[]
	 */
	public SearchDocumentationInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDocumentationInfoVO[]
	 */
	public SearchDocumentationInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDocumentationInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] occDate = (JSPUtil.getParameter(request, prefix	+ "occ_date", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] except = (JSPUtil.getParameter(request, prefix	+ "except", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] occTime = (JSPUtil.getParameter(request, prefix	+ "occ_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDocumentationInfoVO();
				if (occDate[i] != null)
					model.setOccDate(occDate[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (except[i] != null)
					model.setExcept(except[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (occTime[i] != null)
					model.setOccTime(occTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDocumentationInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDocumentationInfoVO[]
	 */
	public SearchDocumentationInfoVO[] getSearchDocumentationInfoVOs(){
		SearchDocumentationInfoVO[] vos = (SearchDocumentationInfoVO[])models.toArray(new SearchDocumentationInfoVO[models.size()]);
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
		this.occDate = this.occDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.except = this.except .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.occTime = this.occTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
