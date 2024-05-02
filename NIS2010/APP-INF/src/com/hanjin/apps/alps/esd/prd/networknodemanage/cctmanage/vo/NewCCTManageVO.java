/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCCTManageVO.java
*@FileTitle : NewCCTManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class NewCCTManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NewCCTManageVO> models = new ArrayList<NewCCTManageVO>();
	
	/* Column Info */
	private String cctOldType = null;
	/* Column Info */
	private String cctType = null;
	/* Column Info */
	private String ertRcvDtFreeDy = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String holiFlag = null;
	/* Column Info */
	private String ertRcvDtSunFlg = null;
	/* Column Info */
	private String satFlag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cctDay = null;
	/* Column Info */
	private String cctHour = null;
	/* Column Info */
	private String statusCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgDeleteFlag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String yardCode = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String deleteFlag = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ertRcvDtEtaFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cctTime = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String ertRcvDtSatFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String laneDirCode = null;
	/* Column Info */
	private String ertRcvDtHolFlg = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String aplyRailCtnt = null;
	/* Column Info */
	private String sunFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NewCCTManageVO() {}

	public NewCCTManageVO(String ibflag, String pagerows, String cctTime, String cctType, String countryCode, String holiFlag, String satFlag, String statusCode, String locationCode, String cctHour, String cctDay, String laneDirCode, String yardCode, String userId, String cargoType, String laneCode, String sunFlag, String deleteFlag, String cctOldType, String orgDeleteFlag, String aplyRailCtnt, String ertRcvDtFreeDy, String ertRcvDtEtaFlg, String ertRcvDtSatFlg, String ertRcvDtSunFlg, String ertRcvDtHolFlg, String vvdCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.cctOldType = cctOldType;
		this.cctType = cctType;
		this.ertRcvDtFreeDy = ertRcvDtFreeDy;
		this.creDt = creDt;
		this.holiFlag = holiFlag;
		this.ertRcvDtSunFlg = ertRcvDtSunFlg;
		this.satFlag = satFlag;
		this.pagerows = pagerows;
		this.cctDay = cctDay;
		this.cctHour = cctHour;
		this.statusCode = statusCode;
		this.ibflag = ibflag;
		this.orgDeleteFlag = orgDeleteFlag;
		this.vvdCd = vvdCd;
		this.yardCode = yardCode;
		this.userId = userId;
		this.cargoType = cargoType;
		this.deleteFlag = deleteFlag;
		this.updUsrId = updUsrId;
		this.ertRcvDtEtaFlg = ertRcvDtEtaFlg;
		this.updDt = updDt;
		this.cctTime = cctTime;
		this.countryCode = countryCode;
		this.locationCode = locationCode;
		this.ertRcvDtSatFlg = ertRcvDtSatFlg;
		this.creUsrId = creUsrId;
		this.laneDirCode = laneDirCode;
		this.ertRcvDtHolFlg = ertRcvDtHolFlg;
		this.laneCode = laneCode;
		this.aplyRailCtnt = aplyRailCtnt;
		this.sunFlag = sunFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cct_old_type", getCctOldType());
		this.hashColumns.put("cct_type", getCctType());
		this.hashColumns.put("ert_rcv_dt_free_dy", getErtRcvDtFreeDy());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("holi_flag", getHoliFlag());
		this.hashColumns.put("ert_rcv_dt_sun_flg", getErtRcvDtSunFlg());
		this.hashColumns.put("sat_flag", getSatFlag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cct_day", getCctDay());
		this.hashColumns.put("cct_hour", getCctHour());
		this.hashColumns.put("status_code", getStatusCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_delete_flag", getOrgDeleteFlag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("yard_code", getYardCode());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("delete_flag", getDeleteFlag());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ert_rcv_dt_eta_flg", getErtRcvDtEtaFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cct_time", getCctTime());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("ert_rcv_dt_sat_flg", getErtRcvDtSatFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lane_dir_code", getLaneDirCode());
		this.hashColumns.put("ert_rcv_dt_hol_flg", getErtRcvDtHolFlg());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("aply_rail_ctnt", getAplyRailCtnt());
		this.hashColumns.put("sun_flag", getSunFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cct_old_type", "cctOldType");
		this.hashFields.put("cct_type", "cctType");
		this.hashFields.put("ert_rcv_dt_free_dy", "ertRcvDtFreeDy");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("holi_flag", "holiFlag");
		this.hashFields.put("ert_rcv_dt_sun_flg", "ertRcvDtSunFlg");
		this.hashFields.put("sat_flag", "satFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cct_day", "cctDay");
		this.hashFields.put("cct_hour", "cctHour");
		this.hashFields.put("status_code", "statusCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_delete_flag", "orgDeleteFlag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("yard_code", "yardCode");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("delete_flag", "deleteFlag");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ert_rcv_dt_eta_flg", "ertRcvDtEtaFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cct_time", "cctTime");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("ert_rcv_dt_sat_flg", "ertRcvDtSatFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lane_dir_code", "laneDirCode");
		this.hashFields.put("ert_rcv_dt_hol_flg", "ertRcvDtHolFlg");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("aply_rail_ctnt", "aplyRailCtnt");
		this.hashFields.put("sun_flag", "sunFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cctOldType
	 */
	public String getCctOldType() {
		return this.cctOldType;
	}
	
	/**
	 * Column Info
	 * @return cctType
	 */
	public String getCctType() {
		return this.cctType;
	}
	
	/**
	 * Column Info
	 * @return ertRcvDtFreeDy
	 */
	public String getErtRcvDtFreeDy() {
		return this.ertRcvDtFreeDy;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return holiFlag
	 */
	public String getHoliFlag() {
		return this.holiFlag;
	}
	
	/**
	 * Column Info
	 * @return ertRcvDtSunFlg
	 */
	public String getErtRcvDtSunFlg() {
		return this.ertRcvDtSunFlg;
	}
	
	/**
	 * Column Info
	 * @return satFlag
	 */
	public String getSatFlag() {
		return this.satFlag;
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
	 * @return cctDay
	 */
	public String getCctDay() {
		return this.cctDay;
	}
	
	/**
	 * Column Info
	 * @return cctHour
	 */
	public String getCctHour() {
		return this.cctHour;
	}
	
	/**
	 * Column Info
	 * @return statusCode
	 */
	public String getStatusCode() {
		return this.statusCode;
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
	 * @return orgDeleteFlag
	 */
	public String getOrgDeleteFlag() {
		return this.orgDeleteFlag;
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
	 * @return yardCode
	 */
	public String getYardCode() {
		return this.yardCode;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return deleteFlag
	 */
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ertRcvDtEtaFlg
	 */
	public String getErtRcvDtEtaFlg() {
		return this.ertRcvDtEtaFlg;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cctTime
	 */
	public String getCctTime() {
		return this.cctTime;
	}
	
	/**
	 * Column Info
	 * @return countryCode
	 */
	public String getCountryCode() {
		return this.countryCode;
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
	 * @return ertRcvDtSatFlg
	 */
	public String getErtRcvDtSatFlg() {
		return this.ertRcvDtSatFlg;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return laneDirCode
	 */
	public String getLaneDirCode() {
		return this.laneDirCode;
	}
	
	/**
	 * Column Info
	 * @return ertRcvDtHolFlg
	 */
	public String getErtRcvDtHolFlg() {
		return this.ertRcvDtHolFlg;
	}
	
	/**
	 * Column Info
	 * @return laneCode
	 */
	public String getLaneCode() {
		return this.laneCode;
	}
	
	/**
	 * Column Info
	 * @return aplyRailCtnt
	 */
	public String getAplyRailCtnt() {
		return this.aplyRailCtnt;
	}
	
	/**
	 * Column Info
	 * @return sunFlag
	 */
	public String getSunFlag() {
		return this.sunFlag;
	}
	

	/**
	 * Column Info
	 * @param cctOldType
	 */
	public void setCctOldType(String cctOldType) {
		this.cctOldType = cctOldType;
	}
	
	/**
	 * Column Info
	 * @param cctType
	 */
	public void setCctType(String cctType) {
		this.cctType = cctType;
	}
	
	/**
	 * Column Info
	 * @param ertRcvDtFreeDy
	 */
	public void setErtRcvDtFreeDy(String ertRcvDtFreeDy) {
		this.ertRcvDtFreeDy = ertRcvDtFreeDy;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param holiFlag
	 */
	public void setHoliFlag(String holiFlag) {
		this.holiFlag = holiFlag;
	}
	
	/**
	 * Column Info
	 * @param ertRcvDtSunFlg
	 */
	public void setErtRcvDtSunFlg(String ertRcvDtSunFlg) {
		this.ertRcvDtSunFlg = ertRcvDtSunFlg;
	}
	
	/**
	 * Column Info
	 * @param satFlag
	 */
	public void setSatFlag(String satFlag) {
		this.satFlag = satFlag;
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
	 * @param cctDay
	 */
	public void setCctDay(String cctDay) {
		this.cctDay = cctDay;
	}
	
	/**
	 * Column Info
	 * @param cctHour
	 */
	public void setCctHour(String cctHour) {
		this.cctHour = cctHour;
	}
	
	/**
	 * Column Info
	 * @param statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
	 * @param orgDeleteFlag
	 */
	public void setOrgDeleteFlag(String orgDeleteFlag) {
		this.orgDeleteFlag = orgDeleteFlag;
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
	 * @param yardCode
	 */
	public void setYardCode(String yardCode) {
		this.yardCode = yardCode;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ertRcvDtEtaFlg
	 */
	public void setErtRcvDtEtaFlg(String ertRcvDtEtaFlg) {
		this.ertRcvDtEtaFlg = ertRcvDtEtaFlg;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cctTime
	 */
	public void setCctTime(String cctTime) {
		this.cctTime = cctTime;
	}
	
	/**
	 * Column Info
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	 * @param ertRcvDtSatFlg
	 */
	public void setErtRcvDtSatFlg(String ertRcvDtSatFlg) {
		this.ertRcvDtSatFlg = ertRcvDtSatFlg;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param laneDirCode
	 */
	public void setLaneDirCode(String laneDirCode) {
		this.laneDirCode = laneDirCode;
	}
	
	/**
	 * Column Info
	 * @param ertRcvDtHolFlg
	 */
	public void setErtRcvDtHolFlg(String ertRcvDtHolFlg) {
		this.ertRcvDtHolFlg = ertRcvDtHolFlg;
	}
	
	/**
	 * Column Info
	 * @param laneCode
	 */
	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
	}
	
	/**
	 * Column Info
	 * @param aplyRailCtnt
	 */
	public void setAplyRailCtnt(String aplyRailCtnt) {
		this.aplyRailCtnt = aplyRailCtnt;
	}
	
	/**
	 * Column Info
	 * @param sunFlag
	 */
	public void setSunFlag(String sunFlag) {
		this.sunFlag = sunFlag;
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
		setCctOldType(JSPUtil.getParameter(request, prefix + "cct_old_type", ""));
		setCctType(JSPUtil.getParameter(request, prefix + "cct_type", ""));
		setErtRcvDtFreeDy(JSPUtil.getParameter(request, prefix + "ert_rcv_dt_free_dy", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setHoliFlag(JSPUtil.getParameter(request, prefix + "holi_flag", ""));
		setErtRcvDtSunFlg(JSPUtil.getParameter(request, prefix + "ert_rcv_dt_sun_flg", ""));
		setSatFlag(JSPUtil.getParameter(request, prefix + "sat_flag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCctDay(JSPUtil.getParameter(request, prefix + "cct_day", ""));
		setCctHour(JSPUtil.getParameter(request, prefix + "cct_hour", ""));
		setStatusCode(JSPUtil.getParameter(request, prefix + "status_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgDeleteFlag(JSPUtil.getParameter(request, prefix + "org_delete_flag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setYardCode(JSPUtil.getParameter(request, prefix + "yard_code", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setDeleteFlag(JSPUtil.getParameter(request, prefix + "delete_flag", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setErtRcvDtEtaFlg(JSPUtil.getParameter(request, prefix + "ert_rcv_dt_eta_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCctTime(JSPUtil.getParameter(request, prefix + "cct_time", ""));
		setCountryCode(JSPUtil.getParameter(request, prefix + "country_code", ""));
		setLocationCode(JSPUtil.getParameter(request, prefix + "location_code", ""));
		setErtRcvDtSatFlg(JSPUtil.getParameter(request, prefix + "ert_rcv_dt_sat_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLaneDirCode(JSPUtil.getParameter(request, prefix + "lane_dir_code", ""));
		setErtRcvDtHolFlg(JSPUtil.getParameter(request, prefix + "ert_rcv_dt_hol_flg", ""));
		setLaneCode(JSPUtil.getParameter(request, prefix + "lane_code", ""));
		setAplyRailCtnt(JSPUtil.getParameter(request, prefix + "aply_rail_ctnt", ""));
		setSunFlag(JSPUtil.getParameter(request, prefix + "sun_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NewCCTManageVO[]
	 */
	public NewCCTManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NewCCTManageVO[]
	 */
	public NewCCTManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewCCTManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cctOldType = (JSPUtil.getParameter(request, prefix	+ "cct_old_type", length));
			String[] cctType = (JSPUtil.getParameter(request, prefix	+ "cct_type", length));
			String[] ertRcvDtFreeDy = (JSPUtil.getParameter(request, prefix	+ "ert_rcv_dt_free_dy", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] holiFlag = (JSPUtil.getParameter(request, prefix	+ "holi_flag", length));
			String[] ertRcvDtSunFlg = (JSPUtil.getParameter(request, prefix	+ "ert_rcv_dt_sun_flg", length));
			String[] satFlag = (JSPUtil.getParameter(request, prefix	+ "sat_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cctDay = (JSPUtil.getParameter(request, prefix	+ "cct_day", length));
			String[] cctHour = (JSPUtil.getParameter(request, prefix	+ "cct_hour", length));
			String[] statusCode = (JSPUtil.getParameter(request, prefix	+ "status_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgDeleteFlag = (JSPUtil.getParameter(request, prefix	+ "org_delete_flag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] yardCode = (JSPUtil.getParameter(request, prefix	+ "yard_code", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] deleteFlag = (JSPUtil.getParameter(request, prefix	+ "delete_flag", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ertRcvDtEtaFlg = (JSPUtil.getParameter(request, prefix	+ "ert_rcv_dt_eta_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cctTime = (JSPUtil.getParameter(request, prefix	+ "cct_time", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix	+ "country_code", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] ertRcvDtSatFlg = (JSPUtil.getParameter(request, prefix	+ "ert_rcv_dt_sat_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] laneDirCode = (JSPUtil.getParameter(request, prefix	+ "lane_dir_code", length));
			String[] ertRcvDtHolFlg = (JSPUtil.getParameter(request, prefix	+ "ert_rcv_dt_hol_flg", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix	+ "lane_code", length));
			String[] aplyRailCtnt = (JSPUtil.getParameter(request, prefix	+ "aply_rail_ctnt", length));
			String[] sunFlag = (JSPUtil.getParameter(request, prefix	+ "sun_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new NewCCTManageVO();
				if (cctOldType[i] != null)
					model.setCctOldType(cctOldType[i]);
				if (cctType[i] != null)
					model.setCctType(cctType[i]);
				if (ertRcvDtFreeDy[i] != null)
					model.setErtRcvDtFreeDy(ertRcvDtFreeDy[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (holiFlag[i] != null)
					model.setHoliFlag(holiFlag[i]);
				if (ertRcvDtSunFlg[i] != null)
					model.setErtRcvDtSunFlg(ertRcvDtSunFlg[i]);
				if (satFlag[i] != null)
					model.setSatFlag(satFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cctDay[i] != null)
					model.setCctDay(cctDay[i]);
				if (cctHour[i] != null)
					model.setCctHour(cctHour[i]);
				if (statusCode[i] != null)
					model.setStatusCode(statusCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgDeleteFlag[i] != null)
					model.setOrgDeleteFlag(orgDeleteFlag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (yardCode[i] != null)
					model.setYardCode(yardCode[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (deleteFlag[i] != null)
					model.setDeleteFlag(deleteFlag[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ertRcvDtEtaFlg[i] != null)
					model.setErtRcvDtEtaFlg(ertRcvDtEtaFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cctTime[i] != null)
					model.setCctTime(cctTime[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (ertRcvDtSatFlg[i] != null)
					model.setErtRcvDtSatFlg(ertRcvDtSatFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (laneDirCode[i] != null)
					model.setLaneDirCode(laneDirCode[i]);
				if (ertRcvDtHolFlg[i] != null)
					model.setErtRcvDtHolFlg(ertRcvDtHolFlg[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (aplyRailCtnt[i] != null)
					model.setAplyRailCtnt(aplyRailCtnt[i]);
				if (sunFlag[i] != null)
					model.setSunFlag(sunFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewCCTManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NewCCTManageVO[]
	 */
	public NewCCTManageVO[] getNewCCTManageVOs(){
		NewCCTManageVO[] vos = (NewCCTManageVO[])models.toArray(new NewCCTManageVO[models.size()]);
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
		this.cctOldType = this.cctOldType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctType = this.cctType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ertRcvDtFreeDy = this.ertRcvDtFreeDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holiFlag = this.holiFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ertRcvDtSunFlg = this.ertRcvDtSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.satFlag = this.satFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDay = this.cctDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctHour = this.cctHour .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCode = this.statusCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDeleteFlag = this.orgDeleteFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCode = this.yardCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deleteFlag = this.deleteFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ertRcvDtEtaFlg = this.ertRcvDtEtaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctTime = this.cctTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ertRcvDtSatFlg = this.ertRcvDtSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneDirCode = this.laneDirCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ertRcvDtHolFlg = this.ertRcvDtHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyRailCtnt = this.aplyRailCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sunFlag = this.sunFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
