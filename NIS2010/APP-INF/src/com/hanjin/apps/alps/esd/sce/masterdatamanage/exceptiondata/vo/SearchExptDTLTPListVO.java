/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExptDTLTPListVO.java
*@FileTitle : SearchExptDTLTPListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.15 이중환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExptDTLTPListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExptDTLTPListVO> models = new ArrayList<SearchExptDTLTPListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exptCd = null;
	/* Column Info */
	private String exptCdNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExptDTLTPListVO() {}

	public SearchExptDTLTPListVO(String ibflag, String pagerows, String exptCd, String exptCdNm) {
		this.ibflag = ibflag;
		this.exptCd = exptCd;
		this.exptCdNm = exptCdNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expt_cd", getExptCd());
		this.hashColumns.put("expt_cd_nm", getExptCdNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expt_cd", "exptCd");
		this.hashFields.put("expt_cd_nm", "exptCdNm");
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
	 * @return exptCd
	 */
	public String getExptCd() {
		return this.exptCd;
	}
	
	/**
	 * Column Info
	 * @return exptCdNm
	 */
	public String getExptCdNm() {
		return this.exptCdNm;
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
	 * @param exptCd
	 */
	public void setExptCd(String exptCd) {
		this.exptCd = exptCd;
	}
	
	/**
	 * Column Info
	 * @param exptCdNm
	 */
	public void setExptCdNm(String exptCdNm) {
		this.exptCdNm = exptCdNm;
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
		setExptCd(JSPUtil.getParameter(request, "expt_cd", ""));
		setExptCdNm(JSPUtil.getParameter(request, "expt_cd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExptDTLTPListVO[]
	 */
	public SearchExptDTLTPListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExptDTLTPListVO[]
	 */
	public SearchExptDTLTPListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExptDTLTPListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exptCd = (JSPUtil.getParameter(request, prefix	+ "expt_cd", length));
			String[] exptCdNm = (JSPUtil.getParameter(request, prefix	+ "expt_cd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExptDTLTPListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exptCd[i] != null)
					model.setExptCd(exptCd[i]);
				if (exptCdNm[i] != null)
					model.setExptCdNm(exptCdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExptDTLTPListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExptDTLTPListVO[]
	 */
	public SearchExptDTLTPListVO[] getSearchExptDTLTPListVOs(){
		SearchExptDTLTPListVO[] vos = (SearchExptDTLTPListVO[])models.toArray(new SearchExptDTLTPListVO[models.size()]);
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
		this.exptCd = this.exptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptCdNm = this.exptCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}