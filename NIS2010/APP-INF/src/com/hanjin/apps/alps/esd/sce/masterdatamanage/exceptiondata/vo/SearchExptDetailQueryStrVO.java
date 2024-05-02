/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExptDetailQueryStrVO.java
*@FileTitle : SearchExptDetailQueryStrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.14 이중환 
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

public class SearchExptDetailQueryStrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExptDetailQueryStrVO> models = new ArrayList<SearchExptDetailQueryStrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
//	private String ibflag = null;
	/* Column Info */
	private String fFmExptCd = null;
	/* Column Info */
	private String fToExptCd = null;
	/* Column Info */
	private String fValidation = null;
	/* Column Info */
	private String fCopExptTpDtlCd = null;
	/* Page Number */
//	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExptDetailQueryStrVO() {}

	public SearchExptDetailQueryStrVO(String ibflag, String pagerows, String fFmExptCd, String fCopExptTpDtlCd, String fValidation, String fToExptCd) {
//		this.ibflag = ibflag;
		this.fFmExptCd = fFmExptCd;
		this.fToExptCd = fToExptCd;
		this.fValidation = fValidation;
		this.fCopExptTpDtlCd = fCopExptTpDtlCd;
//		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
//		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_fm_expt_cd", getFFmExptCd());
		this.hashColumns.put("f_to_expt_cd", getFToExptCd());
		this.hashColumns.put("f_validation", getFValidation());
		this.hashColumns.put("f_cop_expt_tp_dtl_cd", getFCopExptTpDtlCd());
//		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_fm_expt_cd", "fFmExptCd");
		this.hashFields.put("f_to_expt_cd", "fToExptCd");
		this.hashFields.put("f_validation", "fValidation");
		this.hashFields.put("f_cop_expt_tp_dtl_cd", "fCopExptTpDtlCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
//	public String getIbflag() {
//		return this.ibflag;
//	}
	
	/**
	 * Column Info
	 * @return fFmExptCd
	 */
	public String getFFmExptCd() {
		return this.fFmExptCd;
	}
	
	/**
	 * Column Info
	 * @return fToExptCd
	 */
	public String getFToExptCd() {
		return this.fToExptCd;
	}
	
	/**
	 * Column Info
	 * @return fValidation
	 */
	public String getFValidation() {
		return this.fValidation;
	}
	
	/**
	 * Column Info
	 * @return fCopExptTpDtlCd
	 */
	public String getFCopExptTpDtlCd() {
		return this.fCopExptTpDtlCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
//	public String getPagerows() {
//		return this.pagerows;
//	}
	

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
//	public void setIbflag(String ibflag) {
//		this.ibflag = ibflag;
//	}
	
	/**
	 * Column Info
	 * @param fFmExptCd
	 */
	public void setFFmExptCd(String fFmExptCd) {
		this.fFmExptCd = fFmExptCd;
	}
	
	/**
	 * Column Info
	 * @param fToExptCd
	 */
	public void setFToExptCd(String fToExptCd) {
		this.fToExptCd = fToExptCd;
	}
	
	/**
	 * Column Info
	 * @param fValidation
	 */
	public void setFValidation(String fValidation) {
		this.fValidation = fValidation;
	}
	
	/**
	 * Column Info
	 * @param fCopExptTpDtlCd
	 */
	public void setFCopExptTpDtlCd(String fCopExptTpDtlCd) {
		this.fCopExptTpDtlCd = fCopExptTpDtlCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
//	public void setPagerows(String pagerows) {
//		this.pagerows = pagerows;
//	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
//		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFFmExptCd(JSPUtil.getParameter(request, "f_fm_expt_cd", ""));
		setFToExptCd(JSPUtil.getParameter(request, "f_to_expt_cd", ""));
		setFValidation(JSPUtil.getParameter(request, "f_validation", ""));
		setFCopExptTpDtlCd(JSPUtil.getParameter(request, "f_cop_expt_tp_dtl_cd", ""));
//		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExptDetailQueryStrVO[]
	 */
	public SearchExptDetailQueryStrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExptDetailQueryStrVO[]
	 */
	public SearchExptDetailQueryStrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExptDetailQueryStrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fFmExptCd = (JSPUtil.getParameter(request, prefix	+ "f_fm_expt_cd", length));
			String[] fToExptCd = (JSPUtil.getParameter(request, prefix	+ "f_to_expt_cd", length));
			String[] fValidation = (JSPUtil.getParameter(request, prefix	+ "f_validation", length));
			String[] fCopExptTpDtlCd = (JSPUtil.getParameter(request, prefix	+ "f_cop_expt_tp_dtl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExptDetailQueryStrVO();
//				if (ibflag[i] != null)
//					model.setIbflag(ibflag[i]);
				if (fFmExptCd[i] != null)
					model.setFFmExptCd(fFmExptCd[i]);
				if (fToExptCd[i] != null)
					model.setFToExptCd(fToExptCd[i]);
				if (fValidation[i] != null)
					model.setFValidation(fValidation[i]);
				if (fCopExptTpDtlCd[i] != null)
					model.setFCopExptTpDtlCd(fCopExptTpDtlCd[i]);
//				if (pagerows[i] != null)
//					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExptDetailQueryStrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExptDetailQueryStrVO[]
	 */
	public SearchExptDetailQueryStrVO[] getSearchExptDetailQueryStrVOs(){
		SearchExptDetailQueryStrVO[] vos = (SearchExptDetailQueryStrVO[])models.toArray(new SearchExptDetailQueryStrVO[models.size()]);
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
//		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmExptCd = this.fFmExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToExptCd = this.fToExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fValidation = this.fValidation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopExptTpDtlCd = this.fCopExptTpDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
