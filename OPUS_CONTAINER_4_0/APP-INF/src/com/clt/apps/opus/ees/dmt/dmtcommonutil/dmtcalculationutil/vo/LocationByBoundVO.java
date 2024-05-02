/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationByBoundVO.java
*@FileTitle : LocationByBoundVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.27 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class LocationByBoundVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LocationByBoundVO> models = new ArrayList<LocationByBoundVO>();
	
	/* Column Info */
	private String bkgStateCd = null;
	/* Column Info */
	private String bkgLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCntCd = null;
	/* Column Info */
	private String bkgRgnCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LocationByBoundVO() {}

	public LocationByBoundVO(String ibflag, String pagerows, String bkgCntCd, String bkgRgnCd, String bkgStateCd, String bkgLocCd) {
		this.bkgStateCd = bkgStateCd;
		this.bkgLocCd = bkgLocCd;
		this.ibflag = ibflag;
		this.bkgCntCd = bkgCntCd;
		this.bkgRgnCd = bkgRgnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_state_cd", getBkgStateCd());
		this.hashColumns.put("bkg_loc_cd", getBkgLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_cnt_cd", getBkgCntCd());
		this.hashColumns.put("bkg_rgn_cd", getBkgRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_state_cd", "bkgStateCd");
		this.hashFields.put("bkg_loc_cd", "bkgLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_cnt_cd", "bkgCntCd");
		this.hashFields.put("bkg_rgn_cd", "bkgRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgStateCd
	 */
	public String getBkgStateCd() {
		return this.bkgStateCd;
	}
	
	/**
	 * Column Info
	 * @return bkgLocCd
	 */
	public String getBkgLocCd() {
		return this.bkgLocCd;
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
	 * @return bkgCntCd
	 */
	public String getBkgCntCd() {
		return this.bkgCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRgnCd
	 */
	public String getBkgRgnCd() {
		return this.bkgRgnCd;
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
	 * @param bkgStateCd
	 */
	public void setBkgStateCd(String bkgStateCd) {
		this.bkgStateCd = bkgStateCd;
	}
	
	/**
	 * Column Info
	 * @param bkgLocCd
	 */
	public void setBkgLocCd(String bkgLocCd) {
		this.bkgLocCd = bkgLocCd;
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
	 * @param bkgCntCd
	 */
	public void setBkgCntCd(String bkgCntCd) {
		this.bkgCntCd = bkgCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRgnCd
	 */
	public void setBkgRgnCd(String bkgRgnCd) {
		this.bkgRgnCd = bkgRgnCd;
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
		setBkgStateCd(JSPUtil.getParameter(request, "bkg_state_cd", ""));
		setBkgLocCd(JSPUtil.getParameter(request, "bkg_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgCntCd(JSPUtil.getParameter(request, "bkg_cnt_cd", ""));
		setBkgRgnCd(JSPUtil.getParameter(request, "bkg_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationByBoundVO[]
	 */
	public LocationByBoundVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationByBoundVO[]
	 */
	public LocationByBoundVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationByBoundVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgStateCd = (JSPUtil.getParameter(request, prefix	+ "bkg_state_cd".trim(), length));
			String[] bkgLocCd = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt_cd".trim(), length));
			String[] bkgRgnCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rgn_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new LocationByBoundVO();
				if (bkgStateCd[i] != null)
					model.setBkgStateCd(bkgStateCd[i]);
				if (bkgLocCd[i] != null)
					model.setBkgLocCd(bkgLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgCntCd[i] != null)
					model.setBkgCntCd(bkgCntCd[i]);
				if (bkgRgnCd[i] != null)
					model.setBkgRgnCd(bkgRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationByBoundVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationByBoundVO[]
	 */
	public LocationByBoundVO[] getLocationByBoundVOs(){
		LocationByBoundVO[] vos = (LocationByBoundVO[])models.toArray(new LocationByBoundVO[models.size()]);
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
		this.bkgStateCd = this.bkgStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocCd = this.bkgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntCd = this.bkgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRgnCd = this.bkgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
