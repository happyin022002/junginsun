/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlCargoManifestInVO.java
*@FileTitle : BlCargoManifestInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.13 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCargoManifestInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCargoManifestInVO> models = new ArrayList<BlCargoManifestInVO>();
	
	/* Column Info */
	private String orderByTitle = null;
	/* Column Info */
	private String orderBy = null;
	/* Column Info */
	private String cargoRoute = null;
	/* Column Info */
	private String brPorCd = null;
	/* Column Info */
	private String modeType = null;
	/* Column Info */
	private String fdrVvdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fdrPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fdrPodYdCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String fdrPolYdCd = null;
	/* Column Info */
	private String brDelCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String brPolCd = null;
	/* Column Info */
	private String brPodCd = null;
	/* Column Info */
	private String fdrPodCd = null;
	/* Column Info */
	private String podYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCargoManifestInVO() {}

	public BlCargoManifestInVO(String ibflag, String pagerows, String modeType, String vvdCd, String polCd, String polYdCd, String podCd, String podYdCd, String cargoType, String cargoRoute, String brPorCd, String brPolCd, String brPodCd, String brDelCd, String fdrVvdCd, String fdrPolCd, String fdrPolYdCd, String fdrPodCd, String fdrPodYdCd, String orderByTitle, String orderBy) {
		this.orderByTitle = orderByTitle;
		this.orderBy = orderBy;
		this.cargoRoute = cargoRoute;
		this.brPorCd = brPorCd;
		this.modeType = modeType;
		this.fdrVvdCd = fdrVvdCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.fdrPolCd = fdrPolCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.fdrPodYdCd = fdrPodYdCd;
		this.vvdCd = vvdCd;
		this.fdrPolYdCd = fdrPolYdCd;
		this.brDelCd = brDelCd;
		this.polYdCd = polYdCd;
		this.cargoType = cargoType;
		this.brPolCd = brPolCd;
		this.brPodCd = brPodCd;
		this.fdrPodCd = fdrPodCd;
		this.podYdCd = podYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("order_by_title", getOrderByTitle());
		this.hashColumns.put("order_by", getOrderBy());
		this.hashColumns.put("cargo_route", getCargoRoute());
		this.hashColumns.put("br_por_cd", getBrPorCd());
		this.hashColumns.put("mode_type", getModeType());
		this.hashColumns.put("fdr_vvd_cd", getFdrVvdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fdr_pol_cd", getFdrPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("fdr_pod_yd_cd", getFdrPodYdCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("fdr_pol_yd_cd", getFdrPolYdCd());
		this.hashColumns.put("br_del_cd", getBrDelCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("br_pol_cd", getBrPolCd());
		this.hashColumns.put("br_pod_cd", getBrPodCd());
		this.hashColumns.put("fdr_pod_cd", getFdrPodCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("order_by_title", "orderByTitle");
		this.hashFields.put("order_by", "orderBy");
		this.hashFields.put("cargo_route", "cargoRoute");
		this.hashFields.put("br_por_cd", "brPorCd");
		this.hashFields.put("mode_type", "modeType");
		this.hashFields.put("fdr_vvd_cd", "fdrVvdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fdr_pol_cd", "fdrPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("fdr_pod_yd_cd", "fdrPodYdCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("fdr_pol_yd_cd", "fdrPolYdCd");
		this.hashFields.put("br_del_cd", "brDelCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("br_pol_cd", "brPolCd");
		this.hashFields.put("br_pod_cd", "brPodCd");
		this.hashFields.put("fdr_pod_cd", "fdrPodCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orderByTitle
	 */
	public String getOrderByTitle() {
		return this.orderByTitle;
	}
	
	/**
	 * Column Info
	 * @return orderBy
	 */
	public String getOrderBy() {
		return this.orderBy;
	}
	
	/**
	 * Column Info
	 * @return cargoRoute
	 */
	public String getCargoRoute() {
		return this.cargoRoute;
	}
	
	/**
	 * Column Info
	 * @return brPorCd
	 */
	public String getBrPorCd() {
		return this.brPorCd;
	}
	
	/**
	 * Column Info
	 * @return modeType
	 */
	public String getModeType() {
		return this.modeType;
	}
	
	/**
	 * Column Info
	 * @return fdrVvdCd
	 */
	public String getFdrVvdCd() {
		return this.fdrVvdCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return fdrPolCd
	 */
	public String getFdrPolCd() {
		return this.fdrPolCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return fdrPodYdCd
	 */
	public String getFdrPodYdCd() {
		return this.fdrPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return fdrPolYdCd
	 */
	public String getFdrPolYdCd() {
		return this.fdrPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return brDelCd
	 */
	public String getBrDelCd() {
		return this.brDelCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}
	
	/**
	 * Column Info
	 * @return brPolCd
	 */
	public String getBrPolCd() {
		return this.brPolCd;
	}
	
	/**
	 * Column Info
	 * @return brPodCd
	 */
	public String getBrPodCd() {
		return this.brPodCd;
	}
	
	/**
	 * Column Info
	 * @return fdrPodCd
	 */
	public String getFdrPodCd() {
		return this.fdrPodCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	

	/**
	 * Column Info
	 * @param orderByTitle
	 */
	public void setOrderByTitle(String orderByTitle) {
		this.orderByTitle = orderByTitle;
	}
	
	/**
	 * Column Info
	 * @param orderBy
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	/**
	 * Column Info
	 * @param cargoRoute
	 */
	public void setCargoRoute(String cargoRoute) {
		this.cargoRoute = cargoRoute;
	}
	
	/**
	 * Column Info
	 * @param brPorCd
	 */
	public void setBrPorCd(String brPorCd) {
		this.brPorCd = brPorCd;
	}
	
	/**
	 * Column Info
	 * @param modeType
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}
	
	/**
	 * Column Info
	 * @param fdrVvdCd
	 */
	public void setFdrVvdCd(String fdrVvdCd) {
		this.fdrVvdCd = fdrVvdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param fdrPolCd
	 */
	public void setFdrPolCd(String fdrPolCd) {
		this.fdrPolCd = fdrPolCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param fdrPodYdCd
	 */
	public void setFdrPodYdCd(String fdrPodYdCd) {
		this.fdrPodYdCd = fdrPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param fdrPolYdCd
	 */
	public void setFdrPolYdCd(String fdrPolYdCd) {
		this.fdrPolYdCd = fdrPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param brDelCd
	 */
	public void setBrDelCd(String brDelCd) {
		this.brDelCd = brDelCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param brPolCd
	 */
	public void setBrPolCd(String brPolCd) {
		this.brPolCd = brPolCd;
	}
	
	/**
	 * Column Info
	 * @param brPodCd
	 */
	public void setBrPodCd(String brPodCd) {
		this.brPodCd = brPodCd;
	}
	
	/**
	 * Column Info
	 * @param fdrPodCd
	 */
	public void setFdrPodCd(String fdrPodCd) {
		this.fdrPodCd = fdrPodCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOrderByTitle(JSPUtil.getParameter(request, "order_by_title", ""));
		setOrderBy(JSPUtil.getParameter(request, "order_by", ""));
		setCargoRoute(JSPUtil.getParameter(request, "cargo_route", ""));
		setBrPorCd(JSPUtil.getParameter(request, "br_por_cd", ""));
		setModeType(JSPUtil.getParameter(request, "mode_type", ""));
		setFdrVvdCd(JSPUtil.getParameter(request, "fdr_vvd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setFdrPolCd(JSPUtil.getParameter(request, "fdr_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFdrPodYdCd(JSPUtil.getParameter(request, "fdr_pod_yd_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setFdrPolYdCd(JSPUtil.getParameter(request, "fdr_pol_yd_cd", ""));
		setBrDelCd(JSPUtil.getParameter(request, "br_del_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setCargoType(JSPUtil.getParameter(request, "cargo_type", ""));
		setBrPolCd(JSPUtil.getParameter(request, "br_pol_cd", ""));
		setBrPodCd(JSPUtil.getParameter(request, "br_pod_cd", ""));
		setFdrPodCd(JSPUtil.getParameter(request, "fdr_pod_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCargoManifestInVO[]
	 */
	public BlCargoManifestInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCargoManifestInVO[]
	 */
	public BlCargoManifestInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCargoManifestInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orderByTitle = (JSPUtil.getParameter(request, prefix	+ "order_by_title", length));
			String[] orderBy = (JSPUtil.getParameter(request, prefix	+ "order_by", length));
			String[] cargoRoute = (JSPUtil.getParameter(request, prefix	+ "cargo_route", length));
			String[] brPorCd = (JSPUtil.getParameter(request, prefix	+ "br_por_cd", length));
			String[] modeType = (JSPUtil.getParameter(request, prefix	+ "mode_type", length));
			String[] fdrVvdCd = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fdrPolCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fdrPodYdCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pod_yd_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] fdrPolYdCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pol_yd_cd", length));
			String[] brDelCd = (JSPUtil.getParameter(request, prefix	+ "br_del_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] brPolCd = (JSPUtil.getParameter(request, prefix	+ "br_pol_cd", length));
			String[] brPodCd = (JSPUtil.getParameter(request, prefix	+ "br_pod_cd", length));
			String[] fdrPodCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pod_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCargoManifestInVO();
				if (orderByTitle[i] != null)
					model.setOrderByTitle(orderByTitle[i]);
				if (orderBy[i] != null)
					model.setOrderBy(orderBy[i]);
				if (cargoRoute[i] != null)
					model.setCargoRoute(cargoRoute[i]);
				if (brPorCd[i] != null)
					model.setBrPorCd(brPorCd[i]);
				if (modeType[i] != null)
					model.setModeType(modeType[i]);
				if (fdrVvdCd[i] != null)
					model.setFdrVvdCd(fdrVvdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fdrPolCd[i] != null)
					model.setFdrPolCd(fdrPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fdrPodYdCd[i] != null)
					model.setFdrPodYdCd(fdrPodYdCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (fdrPolYdCd[i] != null)
					model.setFdrPolYdCd(fdrPolYdCd[i]);
				if (brDelCd[i] != null)
					model.setBrDelCd(brDelCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (brPolCd[i] != null)
					model.setBrPolCd(brPolCd[i]);
				if (brPodCd[i] != null)
					model.setBrPodCd(brPodCd[i]);
				if (fdrPodCd[i] != null)
					model.setFdrPodCd(fdrPodCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCargoManifestInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCargoManifestInVO[]
	 */
	public BlCargoManifestInVO[] getBlCargoManifestInVOs(){
		BlCargoManifestInVO[] vos = (BlCargoManifestInVO[])models.toArray(new BlCargoManifestInVO[models.size()]);
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
		this.orderByTitle = this.orderByTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderBy = this.orderBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoRoute = this.cargoRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brPorCd = this.brPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeType = this.modeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvdCd = this.fdrVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPolCd = this.fdrPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPodYdCd = this.fdrPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPolYdCd = this.fdrPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brDelCd = this.brDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brPolCd = this.brPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brPodCd = this.brPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPodCd = this.fdrPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
