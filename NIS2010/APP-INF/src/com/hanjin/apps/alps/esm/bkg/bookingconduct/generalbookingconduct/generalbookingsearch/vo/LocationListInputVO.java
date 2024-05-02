/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationListInputVO.java
*@FileTitle : LocationListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.12.03 김병규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LocationListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LocationListInputVO> models = new ArrayList<LocationListInputVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locationCd2 = null;
	/* Column Info */
	private String locEqOfc = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String locationCd = null;
	/* Column Info */
	private String unLocIndCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String state = null;	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LocationListInputVO() {}

	public LocationListInputVO(String ibflag, String pagerows, String locationCd, String locationCd2, String rccCd, String cntCd, String unLocIndCd, String locNm, String locEqOfc, String state) {
		this.ibflag = ibflag;
		this.locationCd2 = locationCd2;
		this.locEqOfc = locEqOfc;
		this.cntCd = cntCd;
		this.locationCd = locationCd;
		this.unLocIndCd = unLocIndCd;
		this.rccCd = rccCd;
		this.locNm = locNm;
		this.state = state;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("location_cd2", getLocationCd2());
		this.hashColumns.put("loc_eq_ofc", getLocEqOfc());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("location_cd", getLocationCd());
		this.hashColumns.put("un_loc_ind_cd", getUnLocIndCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("state", getState());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("location_cd2", "locationCd2");
		this.hashFields.put("loc_eq_ofc", "locEqOfc");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("location_cd", "locationCd");
		this.hashFields.put("un_loc_ind_cd", "unLocIndCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("state", "state");
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
	 * @return locationCd2
	 */
	public String getLocationCd2() {
		return this.locationCd2;
	}
	
	/**
	 * Column Info
	 * @return locEqOfc
	 */
	public String getLocEqOfc() {
		return this.locEqOfc;
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
	 * @return locationCd
	 */
	public String getLocationCd() {
		return this.locationCd;
	}
	
	/**
	 * Column Info
	 * @return unLocIndCd
	 */
	public String getUnLocIndCd() {
		return this.unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}

	/**
	 * Column Info
	 * @return state
	 */
	public String getState() {
		return this.state;
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
	 * @param locationCd2
	 */
	public void setLocationCd2(String locationCd2) {
		this.locationCd2 = locationCd2;
	}
	
	/**
	 * Column Info
	 * @param locEqOfc
	 */
	public void setLocEqOfc(String locEqOfc) {
		this.locEqOfc = locEqOfc;
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
	 * @param locationCd
	 */
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}
	
	/**
	 * Column Info
	 * @param unLocIndCd
	 */
	public void setUnLocIndCd(String unLocIndCd) {
		this.unLocIndCd = unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}

	/**
	 * Column Info
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
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
		setLocationCd2(JSPUtil.getParameter(request, "location_cd2", ""));
		setLocEqOfc(JSPUtil.getParameter(request, "loc_eq_ofc", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setLocationCd(JSPUtil.getParameter(request, "location_cd", ""));
		setUnLocIndCd(JSPUtil.getParameter(request, "un_loc_ind_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setState(JSPUtil.getParameter(request, "state", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationListInputVO[]
	 */
	public LocationListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationListInputVO[]
	 */
	public LocationListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locationCd2 = (JSPUtil.getParameter(request, prefix	+ "location_cd2", length));
			String[] locEqOfc = (JSPUtil.getParameter(request, prefix	+ "loc_eq_ofc", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] locationCd = (JSPUtil.getParameter(request, prefix	+ "location_cd", length));
			String[] unLocIndCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_ind_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] state = (JSPUtil.getParameter(request, prefix	+ "state", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new LocationListInputVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locationCd2[i] != null)
					model.setLocationCd2(locationCd2[i]);
				if (locEqOfc[i] != null)
					model.setLocEqOfc(locEqOfc[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (locationCd[i] != null)
					model.setLocationCd(locationCd[i]);
				if (unLocIndCd[i] != null)
					model.setUnLocIndCd(unLocIndCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (state[i] != null)
					model.setState(state[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationListInputVO[]
	 */
	public LocationListInputVO[] getLocationListInputVOs(){
		LocationListInputVO[] vos = (LocationListInputVO[])models.toArray(new LocationListInputVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCd2 = this.locationCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locEqOfc = this.locEqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCd = this.locationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocIndCd = this.unLocIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.state = this.state .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
