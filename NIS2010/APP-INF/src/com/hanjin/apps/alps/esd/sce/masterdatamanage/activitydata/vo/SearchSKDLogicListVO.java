/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSKDLogicListVO.java
*@FileTitle : SearchSKDLogicListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.06 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSKDLogicListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSKDLogicListVO> models = new ArrayList<SearchSKDLogicListVO>();
	
	/* Column Info */
	private String copFomlCd = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String pCopSkdLgcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String srchAll = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String copSkdLgcNo = null;
	/* Column Info */
	private String fomlPctNo = null;
	/* Column Info */
	private String fomlTmHrs = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSKDLogicListVO() {}

	public SearchSKDLogicListVO(String ibflag, String pagerows, String copSkdLgcNo, String actCd, String actNm, String copFomlCd, String fomlTmHrs, String fomlPctNo, String fmEffDt, String toEffDt, String srchAll, String pCopSkdLgcNo) {
		this.copFomlCd = copFomlCd;
		this.actCd = actCd;
		this.pCopSkdLgcNo = pCopSkdLgcNo;
		this.ibflag = ibflag;
		this.actNm = actNm;
		this.fmEffDt = fmEffDt;
		this.srchAll = srchAll;
		this.toEffDt = toEffDt;
		this.copSkdLgcNo = copSkdLgcNo;
		this.fomlPctNo = fomlPctNo;
		this.fomlTmHrs = fomlTmHrs;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cop_foml_cd", getCopFomlCd());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("p_cop_skd_lgc_no", getPCopSkdLgcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("srch_all", getSrchAll());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("cop_skd_lgc_no", getCopSkdLgcNo());
		this.hashColumns.put("foml_pct_no", getFomlPctNo());
		this.hashColumns.put("foml_tm_hrs", getFomlTmHrs());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cop_foml_cd", "copFomlCd");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("p_cop_skd_lgc_no", "pCopSkdLgcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("srch_all", "srchAll");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("cop_skd_lgc_no", "copSkdLgcNo");
		this.hashFields.put("foml_pct_no", "fomlPctNo");
		this.hashFields.put("foml_tm_hrs", "fomlTmHrs");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return copFomlCd
	 */
	public String getCopFomlCd() {
		return this.copFomlCd;
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
	 * @return pCopSkdLgcNo
	 */
	public String getPCopSkdLgcNo() {
		return this.pCopSkdLgcNo;
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
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return srchAll
	 */
	public String getSrchAll() {
		return this.srchAll;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return copSkdLgcNo
	 */
	public String getCopSkdLgcNo() {
		return this.copSkdLgcNo;
	}
	
	/**
	 * Column Info
	 * @return fomlPctNo
	 */
	public String getFomlPctNo() {
		return this.fomlPctNo;
	}
	
	/**
	 * Column Info
	 * @return fomlTmHrs
	 */
	public String getFomlTmHrs() {
		return this.fomlTmHrs;
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
	 * @param copFomlCd
	 */
	public void setCopFomlCd(String copFomlCd) {
		this.copFomlCd = copFomlCd;
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
	 * @param pCopSkdLgcNo
	 */
	public void setPCopSkdLgcNo(String pCopSkdLgcNo) {
		this.pCopSkdLgcNo = pCopSkdLgcNo;
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
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param srchAll
	 */
	public void setSrchAll(String srchAll) {
		this.srchAll = srchAll;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param copSkdLgcNo
	 */
	public void setCopSkdLgcNo(String copSkdLgcNo) {
		this.copSkdLgcNo = copSkdLgcNo;
	}
	
	/**
	 * Column Info
	 * @param fomlPctNo
	 */
	public void setFomlPctNo(String fomlPctNo) {
		this.fomlPctNo = fomlPctNo;
	}
	
	/**
	 * Column Info
	 * @param fomlTmHrs
	 */
	public void setFomlTmHrs(String fomlTmHrs) {
		this.fomlTmHrs = fomlTmHrs;
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
		setCopFomlCd(JSPUtil.getParameter(request, "cop_foml_cd", ""));
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setPCopSkdLgcNo(JSPUtil.getParameter(request, "p_cop_skd_lgc_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setFmEffDt(JSPUtil.getParameter(request, "fm_eff_dt", ""));
		setSrchAll(JSPUtil.getParameter(request, "srch_all", ""));
		setToEffDt(JSPUtil.getParameter(request, "to_eff_dt", ""));
		setCopSkdLgcNo(JSPUtil.getParameter(request, "cop_skd_lgc_no", ""));
		setFomlPctNo(JSPUtil.getParameter(request, "foml_pct_no", ""));
		setFomlTmHrs(JSPUtil.getParameter(request, "foml_tm_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSKDLogicListVO[]
	 */
	public SearchSKDLogicListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSKDLogicListVO[]
	 */
	public SearchSKDLogicListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSKDLogicListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] copFomlCd = (JSPUtil.getParameter(request, prefix	+ "cop_foml_cd", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] pCopSkdLgcNo = (JSPUtil.getParameter(request, prefix	+ "p_cop_skd_lgc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] srchAll = (JSPUtil.getParameter(request, prefix	+ "srch_all", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] copSkdLgcNo = (JSPUtil.getParameter(request, prefix	+ "cop_skd_lgc_no", length));
			String[] fomlPctNo = (JSPUtil.getParameter(request, prefix	+ "foml_pct_no", length));
			String[] fomlTmHrs = (JSPUtil.getParameter(request, prefix	+ "foml_tm_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSKDLogicListVO();
				if (copFomlCd[i] != null)
					model.setCopFomlCd(copFomlCd[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (pCopSkdLgcNo[i] != null)
					model.setPCopSkdLgcNo(pCopSkdLgcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (srchAll[i] != null)
					model.setSrchAll(srchAll[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (copSkdLgcNo[i] != null)
					model.setCopSkdLgcNo(copSkdLgcNo[i]);
				if (fomlPctNo[i] != null)
					model.setFomlPctNo(fomlPctNo[i]);
				if (fomlTmHrs[i] != null)
					model.setFomlTmHrs(fomlTmHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSKDLogicListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSKDLogicListVO[]
	 */
	public SearchSKDLogicListVO[] getSearchSKDLogicListVOs(){
		SearchSKDLogicListVO[] vos = (SearchSKDLogicListVO[])models.toArray(new SearchSKDLogicListVO[models.size()]);
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
		this.copFomlCd = this.copFomlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCopSkdLgcNo = this.pCopSkdLgcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchAll = this.srchAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSkdLgcNo = this.copSkdLgcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlPctNo = this.fomlPctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlTmHrs = this.fomlTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
