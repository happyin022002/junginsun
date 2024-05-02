/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ForecastAccuracyOptionVO.java
*@FileTitle : ForecastAccuracyOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.12.30 김종준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ForecastAccuracyOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ForecastAccuracyOptionVO> models = new ArrayList<ForecastAccuracyOptionVO>();
	
	/* Column Info */
	private String searchFlag = null;
	/* Column Info */
	private String fmWeek = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toWeek = null;
	/* Column Info */
	private String foreCast = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String locTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ForecastAccuracyOptionVO() {}

	public ForecastAccuracyOptionVO(String ibflag, String pagerows, String locCd, String locTpCd, String fmWeek, String toWeek, String foreCast, String searchFlag, String bound) {
		this.searchFlag = searchFlag;
		this.fmWeek = fmWeek;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.toWeek = toWeek;
		this.foreCast = foreCast;
		this.bound = bound;
		this.locTpCd = locTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_flag", getSearchFlag());
		this.hashColumns.put("fm_week", getFmWeek());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_week", getToWeek());
		this.hashColumns.put("fore_cast", getForeCast());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_flag", "searchFlag");
		this.hashFields.put("fm_week", "fmWeek");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_week", "toWeek");
		this.hashFields.put("fore_cast", "foreCast");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return fmWeek
	 */
	public String getFmWeek() {
		return this.fmWeek;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return foreCast
	 */
	public String getForeCast() {
		return this.foreCast;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
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
	 * @param searchFlag
	 */
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	
	/**
	 * Column Info
	 * @param fmWeek
	 */
	public void setFmWeek(String fmWeek) {
		this.fmWeek = fmWeek;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param foreCast
	 */
	public void setForeCast(String foreCast) {
		this.foreCast = foreCast;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
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
		setSearchFlag(JSPUtil.getParameter(request, "search_flag", ""));
		setFmWeek(JSPUtil.getParameter(request, "fm_week", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToWeek(JSPUtil.getParameter(request, "to_week", ""));
		setForeCast(JSPUtil.getParameter(request, "fore_cast", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setLocTpCd(JSPUtil.getParameter(request, "loc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
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
			String[] fmWeek = (JSPUtil.getParameter(request, prefix	+ "fm_week", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toWeek = (JSPUtil.getParameter(request, prefix	+ "to_week", length));
			String[] foreCast = (JSPUtil.getParameter(request, prefix	+ "fore_cast", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ForecastAccuracyOptionVO();
				if (searchFlag[i] != null)
					model.setSearchFlag(searchFlag[i]);
				if (fmWeek[i] != null)
					model.setFmWeek(fmWeek[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toWeek[i] != null)
					model.setToWeek(toWeek[i]);
				if (foreCast[i] != null)
					model.setForeCast(foreCast[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.searchFlag = this.searchFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWeek = this.fmWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWeek = this.toWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foreCast = this.foreCast .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
