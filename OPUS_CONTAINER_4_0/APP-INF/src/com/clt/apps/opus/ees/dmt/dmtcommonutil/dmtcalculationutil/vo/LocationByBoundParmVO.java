/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationByBoundParmVO.java
*@FileTitle : LocationByBoundParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.23 최성환 
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
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LocationByBoundParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LocationByBoundParmVO> models = new ArrayList<LocationByBoundParmVO>();
	
	/* Column Info */
	private String delRgnCd = null;
	/* Column Info */
	private String delLocCd = null;
	/* Column Info */
	private String porStateCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String ioBnd = null;
	/* Column Info */
	private String delStateCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String porLocCd = null;
	/* Column Info */
	private String polCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polLocCd = null;
	/* Column Info */
	private String polRgnCd = null;
	/* Column Info */
	private String porRgnCd = null;
	/* Column Info */
	private String polStateCd = null;
	/* Column Info */
	private String porCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LocationByBoundParmVO() {}

	public LocationByBoundParmVO(String ibflag, String pagerows, String ioBnd, String polCntCd, String polRgnCd, String polStateCd, String polLocCd, String porCntCd, String porRgnCd, String porStateCd, String porLocCd, String delCntCd, String delRgnCd, String delStateCd, String delLocCd) {
		this.delRgnCd = delRgnCd;
		this.delLocCd = delLocCd;
		this.porStateCd = porStateCd;
		this.delCntCd = delCntCd;
		this.ioBnd = ioBnd;
		this.delStateCd = delStateCd;
		this.pagerows = pagerows;
		this.porLocCd = porLocCd;
		this.polCntCd = polCntCd;
		this.ibflag = ibflag;
		this.polLocCd = polLocCd;
		this.polRgnCd = polRgnCd;
		this.porRgnCd = porRgnCd;
		this.polStateCd = polStateCd;
		this.porCntCd = porCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_rgn_cd", getDelRgnCd());
		this.hashColumns.put("del_loc_cd", getDelLocCd());
		this.hashColumns.put("por_state_cd", getPorStateCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("io_bnd", getIoBnd());
		this.hashColumns.put("del_state_cd", getDelStateCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("por_loc_cd", getPorLocCd());
		this.hashColumns.put("pol_cnt_cd", getPolCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_loc_cd", getPolLocCd());
		this.hashColumns.put("pol_rgn_cd", getPolRgnCd());
		this.hashColumns.put("por_rgn_cd", getPorRgnCd());
		this.hashColumns.put("pol_state_cd", getPolStateCd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_rgn_cd", "delRgnCd");
		this.hashFields.put("del_loc_cd", "delLocCd");
		this.hashFields.put("por_state_cd", "porStateCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("io_bnd", "ioBnd");
		this.hashFields.put("del_state_cd", "delStateCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("por_loc_cd", "porLocCd");
		this.hashFields.put("pol_cnt_cd", "polCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_loc_cd", "polLocCd");
		this.hashFields.put("pol_rgn_cd", "polRgnCd");
		this.hashFields.put("por_rgn_cd", "porRgnCd");
		this.hashFields.put("pol_state_cd", "polStateCd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delRgnCd
	 */
	public String getDelRgnCd() {
		return this.delRgnCd;
	}
	
	/**
	 * Column Info
	 * @return delLocCd
	 */
	public String getDelLocCd() {
		return this.delLocCd;
	}
	
	/**
	 * Column Info
	 * @return porStateCd
	 */
	public String getPorStateCd() {
		return this.porStateCd;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public String getIoBnd() {
		return this.ioBnd;
	}
	
	/**
	 * Column Info
	 * @return delStateCd
	 */
	public String getDelStateCd() {
		return this.delStateCd;
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
	 * @return porLocCd
	 */
	public String getPorLocCd() {
		return this.porLocCd;
	}
	
	/**
	 * Column Info
	 * @return polCntCd
	 */
	public String getPolCntCd() {
		return this.polCntCd;
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
	 * @return polLocCd
	 */
	public String getPolLocCd() {
		return this.polLocCd;
	}
	
	/**
	 * Column Info
	 * @return polRgnCd
	 */
	public String getPolRgnCd() {
		return this.polRgnCd;
	}
	
	/**
	 * Column Info
	 * @return porRgnCd
	 */
	public String getPorRgnCd() {
		return this.porRgnCd;
	}
	
	/**
	 * Column Info
	 * @return polStateCd
	 */
	public String getPolStateCd() {
		return this.polStateCd;
	}
	
	/**
	 * Column Info
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
	}
	

	/**
	 * Column Info
	 * @param delRgnCd
	 */
	public void setDelRgnCd(String delRgnCd) {
		this.delRgnCd = delRgnCd;
	}
	
	/**
	 * Column Info
	 * @param delLocCd
	 */
	public void setDelLocCd(String delLocCd) {
		this.delLocCd = delLocCd;
	}
	
	/**
	 * Column Info
	 * @param porStateCd
	 */
	public void setPorStateCd(String porStateCd) {
		this.porStateCd = porStateCd;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param ioBnd
	 */
	public void setIoBnd(String ioBnd) {
		this.ioBnd = ioBnd;
	}
	
	/**
	 * Column Info
	 * @param delStateCd
	 */
	public void setDelStateCd(String delStateCd) {
		this.delStateCd = delStateCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param porLocCd
	 */
	public void setPorLocCd(String porLocCd) {
		this.porLocCd = porLocCd;
	}
	
	/**
	 * Column Info
	 * @param polCntCd
	 */
	public void setPolCntCd(String polCntCd) {
		this.polCntCd = polCntCd;
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
	 * @param polLocCd
	 */
	public void setPolLocCd(String polLocCd) {
		this.polLocCd = polLocCd;
	}
	
	/**
	 * Column Info
	 * @param polRgnCd
	 */
	public void setPolRgnCd(String polRgnCd) {
		this.polRgnCd = polRgnCd;
	}
	
	/**
	 * Column Info
	 * @param porRgnCd
	 */
	public void setPorRgnCd(String porRgnCd) {
		this.porRgnCd = porRgnCd;
	}
	
	/**
	 * Column Info
	 * @param polStateCd
	 */
	public void setPolStateCd(String polStateCd) {
		this.polStateCd = polStateCd;
	}
	
	/**
	 * Column Info
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDelRgnCd(JSPUtil.getParameter(request, "del_rgn_cd", ""));
		setDelLocCd(JSPUtil.getParameter(request, "del_loc_cd", ""));
		setPorStateCd(JSPUtil.getParameter(request, "por_state_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
		setIoBnd(JSPUtil.getParameter(request, "io_bnd", ""));
		setDelStateCd(JSPUtil.getParameter(request, "del_state_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPorLocCd(JSPUtil.getParameter(request, "por_loc_cd", ""));
		setPolCntCd(JSPUtil.getParameter(request, "pol_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolLocCd(JSPUtil.getParameter(request, "pol_loc_cd", ""));
		setPolRgnCd(JSPUtil.getParameter(request, "pol_rgn_cd", ""));
		setPorRgnCd(JSPUtil.getParameter(request, "por_rgn_cd", ""));
		setPolStateCd(JSPUtil.getParameter(request, "pol_state_cd", ""));
		setPorCntCd(JSPUtil.getParameter(request, "por_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationByBoundParmVO[]
	 */
	public LocationByBoundParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationByBoundParmVO[]
	 */
	public LocationByBoundParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationByBoundParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delRgnCd = (JSPUtil.getParameter(request, prefix	+ "del_rgn_cd", length));
			String[] delLocCd = (JSPUtil.getParameter(request, prefix	+ "del_loc_cd", length));
			String[] porStateCd = (JSPUtil.getParameter(request, prefix	+ "por_state_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] ioBnd = (JSPUtil.getParameter(request, prefix	+ "io_bnd", length));
			String[] delStateCd = (JSPUtil.getParameter(request, prefix	+ "del_state_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] porLocCd = (JSPUtil.getParameter(request, prefix	+ "por_loc_cd", length));
			String[] polCntCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polLocCd = (JSPUtil.getParameter(request, prefix	+ "pol_loc_cd", length));
			String[] polRgnCd = (JSPUtil.getParameter(request, prefix	+ "pol_rgn_cd", length));
			String[] porRgnCd = (JSPUtil.getParameter(request, prefix	+ "por_rgn_cd", length));
			String[] polStateCd = (JSPUtil.getParameter(request, prefix	+ "pol_state_cd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new LocationByBoundParmVO();
				if (delRgnCd[i] != null)
					model.setDelRgnCd(delRgnCd[i]);
				if (delLocCd[i] != null)
					model.setDelLocCd(delLocCd[i]);
				if (porStateCd[i] != null)
					model.setPorStateCd(porStateCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (ioBnd[i] != null)
					model.setIoBnd(ioBnd[i]);
				if (delStateCd[i] != null)
					model.setDelStateCd(delStateCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (porLocCd[i] != null)
					model.setPorLocCd(porLocCd[i]);
				if (polCntCd[i] != null)
					model.setPolCntCd(polCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polLocCd[i] != null)
					model.setPolLocCd(polLocCd[i]);
				if (polRgnCd[i] != null)
					model.setPolRgnCd(polRgnCd[i]);
				if (porRgnCd[i] != null)
					model.setPorRgnCd(porRgnCd[i]);
				if (polStateCd[i] != null)
					model.setPolStateCd(polStateCd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationByBoundParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationByBoundParmVO[]
	 */
	public LocationByBoundParmVO[] getLocationByBoundParmVOs(){
		LocationByBoundParmVO[] vos = (LocationByBoundParmVO[])models.toArray(new LocationByBoundParmVO[models.size()]);
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
		this.delRgnCd = this.delRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delLocCd = this.delLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porStateCd = this.porStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBnd = this.ioBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delStateCd = this.delStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porLocCd = this.porLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntCd = this.polCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocCd = this.polLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRgnCd = this.polRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRgnCd = this.porRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polStateCd = this.polStateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
