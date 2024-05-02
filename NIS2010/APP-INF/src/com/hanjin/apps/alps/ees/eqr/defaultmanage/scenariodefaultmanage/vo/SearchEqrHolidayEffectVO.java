/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEqrHolidayEffectVO.java
*@FileTitle : SearchEqrHolidayEffectVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 운영2팀 정은호
*@LastVersion : 1.0
* 2009.07.09 운영2팀 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 운영2팀 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEqrHolidayEffectVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEqrHolidayEffectVO> models = new ArrayList<SearchEqrHolidayEffectVO>();
	
	/* Column Info */
	private String apply = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String holRmk = null;
	/* Column Info */
	private String holYr = null;
	/* Column Info */
	private String stDt = null;
	/* Column Info */
	private String stDy = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rccDivFlg = null;
	/* Column Info */
	private String holNm = null;
	/* Column Info */
	private String endDy = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEqrHolidayEffectVO() {}

	public SearchEqrHolidayEffectVO(String ibflag, String pagerows, String holYr, String cntCd, String cntNm, String stDt, String stDy, String endDt, String endDy, String duration, String week, String apply, String holNm, String holRmk, String rccDivFlg, String deltFlg) {
		this.apply = apply;
		this.deltFlg = deltFlg;
		this.endDt = endDt;
		this.holRmk = holRmk;
		this.holYr = holYr;
		this.stDt = stDt;
		this.stDy = stDy;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.duration = duration;
		this.cntCd = cntCd;
		this.rccDivFlg = rccDivFlg;
		this.holNm = holNm;
		this.endDy = endDy;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apply", getApply());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("hol_rmk", getHolRmk());
		this.hashColumns.put("hol_yr", getHolYr());
		this.hashColumns.put("st_dt", getStDt());
		this.hashColumns.put("st_dy", getStDy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rcc_div_flg", getRccDivFlg());
		this.hashColumns.put("hol_nm", getHolNm());
		this.hashColumns.put("end_dy", getEndDy());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apply", "apply");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("hol_rmk", "holRmk");
		this.hashFields.put("hol_yr", "holYr");
		this.hashFields.put("st_dt", "stDt");
		this.hashFields.put("st_dy", "stDy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rcc_div_flg", "rccDivFlg");
		this.hashFields.put("hol_nm", "holNm");
		this.hashFields.put("end_dy", "endDy");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apply
	 */
	public String getApply() {
		return this.apply;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return holRmk
	 */
	public String getHolRmk() {
		return this.holRmk;
	}
	
	/**
	 * Column Info
	 * @return holYr
	 */
	public String getHolYr() {
		return this.holYr;
	}
	
	/**
	 * Column Info
	 * @return stDt
	 */
	public String getStDt() {
		return this.stDt;
	}
	
	/**
	 * Column Info
	 * @return stDy
	 */
	public String getStDy() {
		return this.stDy;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return rccDivFlg
	 */
	public String getRccDivFlg() {
		return this.rccDivFlg;
	}
	
	/**
	 * Column Info
	 * @return holNm
	 */
	public String getHolNm() {
		return this.holNm;
	}
	
	/**
	 * Column Info
	 * @return endDy
	 */
	public String getEndDy() {
		return this.endDy;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param apply
	 */
	public void setApply(String apply) {
		this.apply = apply;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param holRmk
	 */
	public void setHolRmk(String holRmk) {
		this.holRmk = holRmk;
	}
	
	/**
	 * Column Info
	 * @param holYr
	 */
	public void setHolYr(String holYr) {
		this.holYr = holYr;
	}
	
	/**
	 * Column Info
	 * @param stDt
	 */
	public void setStDt(String stDt) {
		this.stDt = stDt;
	}
	
	/**
	 * Column Info
	 * @param stDy
	 */
	public void setStDy(String stDy) {
		this.stDy = stDy;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param rccDivFlg
	 */
	public void setRccDivFlg(String rccDivFlg) {
		this.rccDivFlg = rccDivFlg;
	}
	
	/**
	 * Column Info
	 * @param holNm
	 */
	public void setHolNm(String holNm) {
		this.holNm = holNm;
	}
	
	/**
	 * Column Info
	 * @param endDy
	 */
	public void setEndDy(String endDy) {
		this.endDy = endDy;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setApply(JSPUtil.getParameter(request, "apply", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setHolRmk(JSPUtil.getParameter(request, "hol_rmk", ""));
		setHolYr(JSPUtil.getParameter(request, "hol_yr", ""));
		setStDt(JSPUtil.getParameter(request, "st_dt", ""));
		setStDy(JSPUtil.getParameter(request, "st_dy", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setRccDivFlg(JSPUtil.getParameter(request, "rcc_div_flg", ""));
		setHolNm(JSPUtil.getParameter(request, "hol_nm", ""));
		setEndDy(JSPUtil.getParameter(request, "end_dy", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEqrHolidayEffectVO[]
	 */
	public SearchEqrHolidayEffectVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEqrHolidayEffectVO[]
	 */
	public SearchEqrHolidayEffectVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEqrHolidayEffectVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apply = (JSPUtil.getParameter(request, prefix	+ "apply", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] holRmk = (JSPUtil.getParameter(request, prefix	+ "hol_rmk", length));
			String[] holYr = (JSPUtil.getParameter(request, prefix	+ "hol_yr", length));
			String[] stDt = (JSPUtil.getParameter(request, prefix	+ "st_dt", length));
			String[] stDy = (JSPUtil.getParameter(request, prefix	+ "st_dy", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] rccDivFlg = (JSPUtil.getParameter(request, prefix	+ "rcc_div_flg", length));
			String[] holNm = (JSPUtil.getParameter(request, prefix	+ "hol_nm", length));
			String[] endDy = (JSPUtil.getParameter(request, prefix	+ "end_dy", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEqrHolidayEffectVO();
				if (apply[i] != null)
					model.setApply(apply[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (holRmk[i] != null)
					model.setHolRmk(holRmk[i]);
				if (holYr[i] != null)
					model.setHolYr(holYr[i]);
				if (stDt[i] != null)
					model.setStDt(stDt[i]);
				if (stDy[i] != null)
					model.setStDy(stDy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rccDivFlg[i] != null)
					model.setRccDivFlg(rccDivFlg[i]);
				if (holNm[i] != null)
					model.setHolNm(holNm[i]);
				if (endDy[i] != null)
					model.setEndDy(endDy[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEqrHolidayEffectVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEqrHolidayEffectVO[]
	 */
	public SearchEqrHolidayEffectVO[] getSearchEqrHolidayEffectVOs(){
		SearchEqrHolidayEffectVO[] vos = (SearchEqrHolidayEffectVO[])models.toArray(new SearchEqrHolidayEffectVO[models.size()]);
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
		this.apply = this.apply .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holRmk = this.holRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holYr = this.holYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDt = this.stDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDy = this.stDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDivFlg = this.rccDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holNm = this.holNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDy = this.endDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
