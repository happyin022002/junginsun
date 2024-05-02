/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchZoneDetailVO.java
*@FileTitle : SearchZoneDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.10 노승배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchZoneDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchZoneDetailVO> models = new ArrayList<SearchZoneDetailVO>();
	
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String distance = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cargoHandlingTime = null;
	/* Column Info */
	private String tt = null;
	/* Column Info */
	private String representativeCode = null;
	/* Column Info */
	private String locationName = null;
	/* Column Info */
	private String representativeName = null;
	/* Column Info */
	private String zoneName = null;
	/* Column Info */
	private String zoneCode = null;
	/* Column Info */
	private String nodeCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchZoneDetailVO() {}

	public SearchZoneDetailVO(String ibflag, String pagerows, String locationCode, String locationName, String zoneCode, String zoneName, String cargoHandlingTime, String representativeCode, String representativeName, String distance, String tt, String nodeCode) {
		this.locationCode = locationCode;
		this.distance = distance;
		this.ibflag = ibflag;
		this.cargoHandlingTime = cargoHandlingTime;
		this.tt = tt;
		this.representativeCode = representativeCode;
		this.locationName = locationName;
		this.representativeName = representativeName;
		this.zoneName = zoneName;
		this.zoneCode = zoneCode;
		this.nodeCode = nodeCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("distance", getDistance());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cargo_handling_time", getCargoHandlingTime());
		this.hashColumns.put("tt", getTt());
		this.hashColumns.put("representative_code", getRepresentativeCode());
		this.hashColumns.put("location_name", getLocationName());
		this.hashColumns.put("representative_name", getRepresentativeName());
		this.hashColumns.put("zone_name", getZoneName());
		this.hashColumns.put("zone_code", getZoneCode());
		this.hashColumns.put("node_code", getNodeCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("distance", "distance");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cargo_handling_time", "cargoHandlingTime");
		this.hashFields.put("tt", "tt");
		this.hashFields.put("representative_code", "representativeCode");
		this.hashFields.put("location_name", "locationName");
		this.hashFields.put("representative_name", "representativeName");
		this.hashFields.put("zone_name", "zoneName");
		this.hashFields.put("zone_code", "zoneCode");
		this.hashFields.put("node_code", "nodeCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	/**
	 * Column Info
	 * @return distance
	 */
	public String getDistance() {
		return this.distance;
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
	 * @return cargoHandlingTime
	 */
	public String getCargoHandlingTime() {
		return this.cargoHandlingTime;
	}
	
	/**
	 * Column Info
	 * @return tt
	 */
	public String getTt() {
		return this.tt;
	}
	
	/**
	 * Column Info
	 * @return representativeCode
	 */
	public String getRepresentativeCode() {
		return this.representativeCode;
	}
	
	/**
	 * Column Info
	 * @return locationName
	 */
	public String getLocationName() {
		return this.locationName;
	}
	
	/**
	 * Column Info
	 * @return representativeName
	 */
	public String getRepresentativeName() {
		return this.representativeName;
	}
	
	/**
	 * Column Info
	 * @return zoneName
	 */
	public String getZoneName() {
		return this.zoneName;
	}
	
	/**
	 * Column Info
	 * @return zoneCode
	 */
	public String getZoneCode() {
		return this.zoneCode;
	}
	
	/**
	 * Column Info
	 * @return nodeCode
	 */
	public String getNodeCode() {
		return this.nodeCode;
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
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Column Info
	 * @param distance
	 */
	public void setDistance(String distance) {
		this.distance = distance;
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
	 * @param cargoHandlingTime
	 */
	public void setCargoHandlingTime(String cargoHandlingTime) {
		this.cargoHandlingTime = cargoHandlingTime;
	}
	
	/**
	 * Column Info
	 * @param tt
	 */
	public void setTt(String tt) {
		this.tt = tt;
	}
	
	/**
	 * Column Info
	 * @param representativeCode
	 */
	public void setRepresentativeCode(String representativeCode) {
		this.representativeCode = representativeCode;
	}
	
	/**
	 * Column Info
	 * @param locationName
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	/**
	 * Column Info
	 * @param representativeName
	 */
	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	
	/**
	 * Column Info
	 * @param zoneName
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	
	/**
	 * Column Info
	 * @param zoneCode
	 */
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	
	/**
	 * Column Info
	 * @param nodeCode
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
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
		setLocationCode(JSPUtil.getParameter(request, "location_code", ""));
		setDistance(JSPUtil.getParameter(request, "distance", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCargoHandlingTime(JSPUtil.getParameter(request, "cargo_handling_time", ""));
		setTt(JSPUtil.getParameter(request, "tt", ""));
		setRepresentativeCode(JSPUtil.getParameter(request, "representative_code", ""));
		setLocationName(JSPUtil.getParameter(request, "location_name", ""));
		setRepresentativeName(JSPUtil.getParameter(request, "representative_name", ""));
		setZoneName(JSPUtil.getParameter(request, "zone_name", ""));
		setZoneCode(JSPUtil.getParameter(request, "zone_code", ""));
		setNodeCode(JSPUtil.getParameter(request, "node_code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchZoneDetailVO[]
	 */
	public SearchZoneDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchZoneDetailVO[]
	 */
	public SearchZoneDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchZoneDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] distance = (JSPUtil.getParameter(request, prefix	+ "distance", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cargoHandlingTime = (JSPUtil.getParameter(request, prefix	+ "cargo_handling_time", length));
			String[] tt = (JSPUtil.getParameter(request, prefix	+ "tt", length));
			String[] representativeCode = (JSPUtil.getParameter(request, prefix	+ "representative_code", length));
			String[] locationName = (JSPUtil.getParameter(request, prefix	+ "location_name", length));
			String[] representativeName = (JSPUtil.getParameter(request, prefix	+ "representative_name", length));
			String[] zoneName = (JSPUtil.getParameter(request, prefix	+ "zone_name", length));
			String[] zoneCode = (JSPUtil.getParameter(request, prefix	+ "zone_code", length));
			String[] nodeCode = (JSPUtil.getParameter(request, prefix	+ "node_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchZoneDetailVO();
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (distance[i] != null)
					model.setDistance(distance[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cargoHandlingTime[i] != null)
					model.setCargoHandlingTime(cargoHandlingTime[i]);
				if (tt[i] != null)
					model.setTt(tt[i]);
				if (representativeCode[i] != null)
					model.setRepresentativeCode(representativeCode[i]);
				if (locationName[i] != null)
					model.setLocationName(locationName[i]);
				if (representativeName[i] != null)
					model.setRepresentativeName(representativeName[i]);
				if (zoneName[i] != null)
					model.setZoneName(zoneName[i]);
				if (zoneCode[i] != null)
					model.setZoneCode(zoneCode[i]);
				if (nodeCode[i] != null)
					model.setNodeCode(nodeCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchZoneDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchZoneDetailVO[]
	 */
	public SearchZoneDetailVO[] getSearchZoneDetailVOs(){
		SearchZoneDetailVO[] vos = (SearchZoneDetailVO[])models.toArray(new SearchZoneDetailVO[models.size()]);
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
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distance = this.distance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoHandlingTime = this.cargoHandlingTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tt = this.tt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.representativeCode = this.representativeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationName = this.locationName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.representativeName = this.representativeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneName = this.zoneName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneCode = this.zoneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeCode = this.nodeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
