/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ForecastAccuracyOptionVO.java
*@FileTitle : ForecastAccuracyOptionVO
*Open Issues :
*Change history : 1. CHM-201322369, Location 검색조건 추가, 2013-01-21, 신용찬 수석
*@LastModifyDate : 2011.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo;

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

public class ForecastAccuracyOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ForecastAccuracyOptionVO> models = new ArrayList<ForecastAccuracyOptionVO>();
	
	/* Column Info */
	private String searchFlag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String fmWeek = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String foreCast = null;
	/* Column Info */
	private String locTpCd = null;
	/* Column Info */
	private String bound = null;
	/* Page Number */
	private String pagerows = null;
	
	private String divFlag = null;       //div_flag
	private String locTpCdSecond = null; //loc_tp_cd_second
	private String locCdSecond   = null; //loc_cd_second

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ForecastAccuracyOptionVO() {}

	public ForecastAccuracyOptionVO(String ibflag, String pagerows, String searchFlag, String fmWeek, String locCd, String toWeek, String foreCast, String bound, String locTpCd, String tpsztype, String divFlag, String locTpCdSecond, String locCdSecond) {
		this.searchFlag = searchFlag;
		this.locCd = locCd;
		this.fmWeek = fmWeek;
		this.ibflag = ibflag;
		this.toWeek = toWeek;
		this.tpsztype = tpsztype;
		this.foreCast = foreCast;
		this.locTpCd = locTpCd;
		this.bound = bound;
		this.pagerows = pagerows;
		this.divFlag = divFlag;	
		this.locTpCdSecond = locTpCdSecond;		
		this.locCdSecond = locCdSecond;				
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_flag", getSearchFlag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("fm_week", getFmWeek());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("fore_cast", getForeCast());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("pagerows", getPagerows());
		
		this.hashColumns.put("div_flag", getDivFlag());
		this.hashColumns.put("loc_tp_cd_second", getLocTpCdSecond());
		this.hashColumns.put("loc_cd_second", getLocCdSecond());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_flag", "searchFlag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("fm_week", "fmWeek");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("fore_cast", "foreCast");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("pagerows", "pagerows");

		this.hashFields.put("div_flag", "divFlag");
		this.hashFields.put("loc_tp_cd_second", "locTpCdSecond");
		this.hashFields.put("loc_cd_second", "locCdSecond");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchFlag
	 */
	public String getSearchFlag() {
		return this.searchFlag;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return fmWeek
	 */
	public String getFmWeek() {
		return this.fmWeek;
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
	 * @return toWeek
	 */
	public String getToWeek() {
		return this.toWeek;
	}
	
	/**
	 * Column Info
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return foreCast
	 */
	public String getForeCast() {
		return this.foreCast;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * div flag
	 * @return pagerows
	 */
	public String getDivFlag() {
		return this.divFlag;
	}
	
	/**
	 * loc type code second
	 * @return loctpCdSecond
	 */
	public String getLocTpCdSecond() {
		return this.locTpCdSecond;
	}
	
	/**
	 * loc cd second
	 * @return locCdSecond
	 */
	public String getLocCdSecond() {
		return this.locCdSecond;
	}	
	

	/**
	 * Column Info
	 * @param searchFlag
	 */
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param fmWeek
	 */
	public void setFmWeek(String fmWeek) {
		this.fmWeek = fmWeek;
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
	 * @param toWeek
	 */
	public void setToWeek(String toWeek) {
		this.toWeek = toWeek;
	}
	
	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param foreCast
	 */
	public void setForeCast(String foreCast) {
		this.foreCast = foreCast;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setDivFlag(String divFlag) {
		this.divFlag = divFlag;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setLocTpCdSecond(String locTpCdSecond) {
		this.locTpCdSecond = locTpCdSecond;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setLocCdSecond(String locCdSecond) {
		this.locCdSecond = locCdSecond;
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
		setSearchFlag(JSPUtil.getParameter(request, prefix + "search_flag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setFmWeek(JSPUtil.getParameter(request, prefix + "fm_week", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToWeek(JSPUtil.getParameter(request, prefix + "to_week", ""));
		setTpsztype(JSPUtil.getParameter(request, prefix + "tpsztype", ""));
		setForeCast(JSPUtil.getParameter(request, prefix + "fore_cast", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));

		setDivFlag(JSPUtil.getParameter(request, prefix + "div_flag", ""));
		setLocTpCdSecond(JSPUtil.getParameter(request, prefix + "loc_tp_cd_second", ""));
		setLocCdSecond(JSPUtil.getParameter(request, prefix + "loc_cd_second", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ForecastAccuracyOptionVO[]
	 */
	public ForecastAccuracyOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ForecastAccuracyOptionVO[]
	 */
	public ForecastAccuracyOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ForecastAccuracyOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchFlag = (JSPUtil.getParameter(request, prefix	+ "search_flag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] fmWeek = (JSPUtil.getParameter(request, prefix	+ "fm_week", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] foreCast = (JSPUtil.getParameter(request, prefix	+ "fore_cast", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			String[] divFlag = (JSPUtil.getParameter(request, prefix	+ "div_flg", length));
			String[] locTpCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_second", length));
			String[] locCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_cd_second", length));
			
			for (int i = 0; i < length; i++) {
				model = new ForecastAccuracyOptionVO();
				if (searchFlag[i] != null)
					model.setSearchFlag(searchFlag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (fmWeek[i] != null)
					model.setFmWeek(fmWeek[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (foreCast[i] != null)
					model.setForeCast(foreCast[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				if (pagerows[i] != null)
					model.setDivFlag(divFlag[i]);
				if (pagerows[i] != null)
					model.setLocTpCdSecond(locTpCdSecond[i]);
				if (pagerows[i] != null)
					model.setLocCdSecond(locCdSecond[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getForecastAccuracyOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ForecastAccuracyOptionVO[]
	 */
	public ForecastAccuracyOptionVO[] getForecastAccuracyOptionVOs(){
		ForecastAccuracyOptionVO[] vos = (ForecastAccuracyOptionVO[])models.toArray(new ForecastAccuracyOptionVO[models.size()]);
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
		this.searchFlag = this.searchFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWeek = this.fmWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foreCast = this.foreCast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divFlag = this.divFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdSecond = this.locTpCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdSecond = this.locCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
