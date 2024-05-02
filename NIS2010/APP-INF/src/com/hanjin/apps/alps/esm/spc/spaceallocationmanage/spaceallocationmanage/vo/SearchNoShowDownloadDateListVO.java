/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNoShowDownloadDateListVO.java
*@FileTitle : SearchNoShowDownloadDateListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.05 한상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNoShowDownloadDateListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNoShowDownloadDateListVO> models = new ArrayList<SearchNoShowDownloadDateListVO>();
	
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String bseYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dwnLodDy = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String sweek = null;
	/* Column Info */
	private String exeDt = null;
	/* Column Info */
	private String week = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNoShowDownloadDateListVO() {}

	public SearchNoShowDownloadDateListVO(String ibflag, String pagerows, String bseYrmon, String bseMon, String dwnLodDy, String sweek, String week, String days, String exeDt) {
		this.bseMon = bseMon;
		this.bseYrmon = bseYrmon;
		this.ibflag = ibflag;
		this.dwnLodDy = dwnLodDy;
		this.days = days;
		this.sweek = sweek;
		this.exeDt = exeDt;
		this.week = week;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dwn_lod_dy", getDwnLodDy());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("sweek", getSweek());
		this.hashColumns.put("exe_dt", getExeDt());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dwn_lod_dy", "dwnLodDy");
		this.hashFields.put("days", "days");
		this.hashFields.put("sweek", "sweek");
		this.hashFields.put("exe_dt", "exeDt");
		this.hashFields.put("week", "week");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
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
	 * @return dwnLodDy
	 */
	public String getDwnLodDy() {
		return this.dwnLodDy;
	}
	
	/**
	 * Column Info
	 * @return days
	 */
	public String getDays() {
		return this.days;
	}
	
	/**
	 * Column Info
	 * @return sweek
	 */
	public String getSweek() {
		return this.sweek;
	}
	
	/**
	 * Column Info
	 * @return exeDt
	 */
	public String getExeDt() {
		return this.exeDt;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
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
	 * @param dwnLodDy
	 */
	public void setDwnLodDy(String dwnLodDy) {
		this.dwnLodDy = dwnLodDy;
	}
	
	/**
	 * Column Info
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
	}
	
	/**
	 * Column Info
	 * @param sweek
	 */
	public void setSweek(String sweek) {
		this.sweek = sweek;
	}
	
	/**
	 * Column Info
	 * @param exeDt
	 */
	public void setExeDt(String exeDt) {
		this.exeDt = exeDt;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setBseYrmon(JSPUtil.getParameter(request, "bse_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDwnLodDy(JSPUtil.getParameter(request, "dwn_lod_dy", ""));
		setDays(JSPUtil.getParameter(request, "days", ""));
		setSweek(JSPUtil.getParameter(request, "sweek", ""));
		setExeDt(JSPUtil.getParameter(request, "exe_dt", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNoShowDownloadDateListVO[]
	 */
	public SearchNoShowDownloadDateListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNoShowDownloadDateListVO[]
	 */
	public SearchNoShowDownloadDateListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNoShowDownloadDateListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dwnLodDy = (JSPUtil.getParameter(request, prefix	+ "dwn_lod_dy", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] sweek = (JSPUtil.getParameter(request, prefix	+ "sweek", length));
			String[] exeDt = (JSPUtil.getParameter(request, prefix	+ "exe_dt", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNoShowDownloadDateListVO();
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dwnLodDy[i] != null)
					model.setDwnLodDy(dwnLodDy[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (sweek[i] != null)
					model.setSweek(sweek[i]);
				if (exeDt[i] != null)
					model.setExeDt(exeDt[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNoShowDownloadDateListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNoShowDownloadDateListVO[]
	 */
	public SearchNoShowDownloadDateListVO[] getSearchNoShowDownloadDateListVOs(){
		SearchNoShowDownloadDateListVO[] vos = (SearchNoShowDownloadDateListVO[])models.toArray(new SearchNoShowDownloadDateListVO[models.size()]);
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
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwnLodDy = this.dwnLodDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sweek = this.sweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeDt = this.exeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
