/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : NewCCTManageVO.java
 *@FileTitle : NewCCTManageVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.18  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

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
	private String vgmXcldHolHolFlg = null;
	/* Column Info */
	private String cctOldType = null;
	/* Column Info */
	private String cctType = null;
	/* Column Info */
	private String vgmClzDyCd = null;
	/* Column Info */
	private String holiFlag = null;
	/* Column Info */
	private String vgmClzHr = null;
	/* Column Info */
	private String satFlag = null;
	/* Column Info */
	private String vgmXcldHolSunFlg = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String cctDay = null;
	/* Column Info */
	private String cctHour = null;
	/* Column Info */
	private String orgDeleteFlag = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String vgmXcldHolSatFlg = null;
	/* Column Info */
	private String yardCode = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String deleteFlag = null;
	/* Column Info */
	private String vgmXcldHolFriFlg = null;
	/* Column Info */
	private String friFlag = null;
	/* Column Info */
	private String vgmClzTpCd = null;
	/* Column Info */
	private String cctTime = null;
	/* Column Info */
	private String vgmClzFileFlg = null;
	/* Column Info */
	private String cctFileFlg = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String laneDirCode = null;
	/* Column Info */
	private String ydBseCalcFlg = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String sunFlag = null;
	/* Column Info */
	private String vgmClzHrmnt = null;
	/* Column Info */
	private String vgmYdBseCalcFlg = null;
	/* Column Info */
	private String countryCode = null;
	/* Column Info */
	private String statusCode = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public NewCCTManageVO() {
	}

	public NewCCTManageVO(String ibflag, String pagerows, String cctOldType, String cctTime, String cctType, String holiFlag, String cctFileFlg, String satFlag, String locationCode, String cctHour, String cctDay, String orgDeleteFlag, String laneDirCode, String ydBseCalcFlg, String yardCode,
			String userId, String cargoType, String laneCode, String sunFlag, String deleteFlag, String friFlag, String vgmClzTpCd, String vgmClzHr, String vgmClzFileFlg, String vgmYdBseCalcFlg, String vgmClzDyCd, String vgmClzHrmnt, String vgmXcldHolFriFlg, String vgmXcldHolSatFlg,
			String vgmXcldHolSunFlg, String vgmXcldHolHolFlg, String countryCode, String statusCode) {
		this.vgmXcldHolHolFlg = vgmXcldHolHolFlg;
		this.cctOldType = cctOldType;
		this.cctType = cctType;
		this.vgmClzDyCd = vgmClzDyCd;
		this.holiFlag = holiFlag;
		this.vgmClzHr = vgmClzHr;
		this.satFlag = satFlag;
		this.vgmXcldHolSunFlg = vgmXcldHolSunFlg;
		this.pagerows = pagerows;
		this.cctDay = cctDay;
		this.cctHour = cctHour;
		this.orgDeleteFlag = orgDeleteFlag;
		this.ibflag = ibflag;
		this.vgmXcldHolSatFlg = vgmXcldHolSatFlg;
		this.yardCode = yardCode;
		this.userId = userId;
		this.cargoType = cargoType;
		this.deleteFlag = deleteFlag;
		this.vgmXcldHolFriFlg = vgmXcldHolFriFlg;
		this.friFlag = friFlag;
		this.vgmClzTpCd = vgmClzTpCd;
		this.cctTime = cctTime;
		this.vgmClzFileFlg = vgmClzFileFlg;
		this.cctFileFlg = cctFileFlg;
		this.locationCode = locationCode;
		this.laneDirCode = laneDirCode;
		this.ydBseCalcFlg = ydBseCalcFlg;
		this.laneCode = laneCode;
		this.sunFlag = sunFlag;
		this.vgmClzHrmnt = vgmClzHrmnt;
		this.vgmYdBseCalcFlg = vgmYdBseCalcFlg;
		this.countryCode = countryCode;
		this.statusCode = statusCode;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("vgm_xcld_hol_hol_flg", getVgmXcldHolHolFlg());
		this.hashColumns.put("cct_old_type", getCctOldType());
		this.hashColumns.put("cct_type", getCctType());
		this.hashColumns.put("vgm_clz_dy_cd", getVgmClzDyCd());
		this.hashColumns.put("holi_flag", getHoliFlag());
		this.hashColumns.put("vgm_clz_hr", getVgmClzHr());
		this.hashColumns.put("sat_flag", getSatFlag());
		this.hashColumns.put("vgm_xcld_hol_sun_flg", getVgmXcldHolSunFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cct_day", getCctDay());
		this.hashColumns.put("cct_hour", getCctHour());
		this.hashColumns.put("org_delete_flag", getOrgDeleteFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vgm_xcld_hol_sat_flg", getVgmXcldHolSatFlg());
		this.hashColumns.put("yard_code", getYardCode());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("delete_flag", getDeleteFlag());
		this.hashColumns.put("vgm_xcld_hol_fri_flg", getVgmXcldHolFriFlg());
		this.hashColumns.put("fri_flag", getFriFlag());
		this.hashColumns.put("vgm_clz_tp_cd", getVgmClzTpCd());
		this.hashColumns.put("cct_time", getCctTime());
		this.hashColumns.put("vgm_clz_file_flg", getVgmClzFileFlg());
		this.hashColumns.put("cct_file_flg", getCctFileFlg());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("lane_dir_code", getLaneDirCode());
		this.hashColumns.put("yd_bse_calc_flg", getYdBseCalcFlg());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("sun_flag", getSunFlag());
		this.hashColumns.put("vgm_clz_hrmnt", getVgmClzHrmnt());
		this.hashColumns.put("vgm_yd_bse_calc_flg", getVgmYdBseCalcFlg());
		this.hashColumns.put("country_code", getCountryCode());
		this.hashColumns.put("status_code", getStatusCode());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("vgm_xcld_hol_hol_flg", "vgmXcldHolHolFlg");
		this.hashFields.put("cct_old_type", "cctOldType");
		this.hashFields.put("cct_type", "cctType");
		this.hashFields.put("vgm_clz_dy_cd", "vgmClzDyCd");
		this.hashFields.put("holi_flag", "holiFlag");
		this.hashFields.put("vgm_clz_hr", "vgmClzHr");
		this.hashFields.put("sat_flag", "satFlag");
		this.hashFields.put("vgm_xcld_hol_sun_flg", "vgmXcldHolSunFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cct_day", "cctDay");
		this.hashFields.put("cct_hour", "cctHour");
		this.hashFields.put("org_delete_flag", "orgDeleteFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vgm_xcld_hol_sat_flg", "vgmXcldHolSatFlg");
		this.hashFields.put("yard_code", "yardCode");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("delete_flag", "deleteFlag");
		this.hashFields.put("vgm_xcld_hol_fri_flg", "vgmXcldHolFriFlg");
		this.hashFields.put("fri_flag", "friFlag");
		this.hashFields.put("vgm_clz_tp_cd", "vgmClzTpCd");
		this.hashFields.put("cct_time", "cctTime");
		this.hashFields.put("vgm_clz_file_flg", "vgmClzFileFlg");
		this.hashFields.put("cct_file_flg", "cctFileFlg");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("lane_dir_code", "laneDirCode");
		this.hashFields.put("yd_bse_calc_flg", "ydBseCalcFlg");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("sun_flag", "sunFlag");
		this.hashFields.put("vgm_clz_hrmnt", "vgmClzHrmnt");
		this.hashFields.put("vgm_yd_bse_calc_flg", "vgmYdBseCalcFlg");
		this.hashFields.put("country_code", "countryCode");
		this.hashFields.put("status_code", "statusCode");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmXcldHolHolFlg
	 */
	public String getVgmXcldHolHolFlg() {
		return this.vgmXcldHolHolFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return cctOldType
	 */
	public String getCctOldType() {
		return this.cctOldType;
	}

	/**
	 * Column Info
	 * 
	 * @return cctType
	 */
	public String getCctType() {
		return this.cctType;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmClzDyCd
	 */
	public String getVgmClzDyCd() {
		return this.vgmClzDyCd;
	}

	/**
	 * Column Info
	 * 
	 * @return holiFlag
	 */
	public String getHoliFlag() {
		return this.holiFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmClzHr
	 */
	public String getVgmClzHr() {
		return this.vgmClzHr;
	}

	/**
	 * Column Info
	 * 
	 * @return satFlag
	 */
	public String getSatFlag() {
		return this.satFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmXcldHolSunFlg
	 */
	public String getVgmXcldHolSunFlg() {
		return this.vgmXcldHolSunFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return cctDay
	 */
	public String getCctDay() {
		return this.cctDay;
	}

	/**
	 * Column Info
	 * 
	 * @return cctHour
	 */
	public String getCctHour() {
		return this.cctHour;
	}

	/**
	 * Column Info
	 * 
	 * @return orgDeleteFlag
	 */
	public String getOrgDeleteFlag() {
		return this.orgDeleteFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmXcldHolSatFlg
	 */
	public String getVgmXcldHolSatFlg() {
		return this.vgmXcldHolSatFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return yardCode
	 */
	public String getYardCode() {
		return this.yardCode;
	}

	/**
	 * Column Info
	 * 
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * 
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}

	/**
	 * Column Info
	 * 
	 * @return deleteFlag
	 */
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmXcldHolFriFlg
	 */
	public String getVgmXcldHolFriFlg() {
		return this.vgmXcldHolFriFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return friFlag
	 */
	public String getFriFlag() {
		return this.friFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmClzTpCd
	 */
	public String getVgmClzTpCd() {
		return this.vgmClzTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cctTime
	 */
	public String getCctTime() {
		return this.cctTime;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmClzFileFlg
	 */
	public String getVgmClzFileFlg() {
		return this.vgmClzFileFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return cctFileFlg
	 */
	public String getCctFileFlg() {
		return this.cctFileFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}

	/**
	 * Column Info
	 * 
	 * @return laneDirCode
	 */
	public String getLaneDirCode() {
		return this.laneDirCode;
	}

	/**
	 * Column Info
	 * 
	 * @return ydBseCalcFlg
	 */
	public String getYdBseCalcFlg() {
		return this.ydBseCalcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return laneCode
	 */
	public String getLaneCode() {
		return this.laneCode;
	}

	/**
	 * Column Info
	 * 
	 * @return sunFlag
	 */
	public String getSunFlag() {
		return this.sunFlag;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmClzHrmnt
	 */
	public String getVgmClzHrmnt() {
		return this.vgmClzHrmnt;
	}

	/**
	 * Column Info
	 * 
	 * @return vgmYdBseCalcFlg
	 */
	public String getVgmYdBseCalcFlg() {
		return this.vgmYdBseCalcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmXcldHolHolFlg
	 */
	public void setVgmXcldHolHolFlg(String vgmXcldHolHolFlg) {
		this.vgmXcldHolHolFlg = vgmXcldHolHolFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cctOldType
	 */
	public void setCctOldType(String cctOldType) {
		this.cctOldType = cctOldType;
	}

	/**
	 * Column Info
	 * 
	 * @param cctType
	 */
	public void setCctType(String cctType) {
		this.cctType = cctType;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmClzDyCd
	 */
	public void setVgmClzDyCd(String vgmClzDyCd) {
		this.vgmClzDyCd = vgmClzDyCd;
	}

	/**
	 * Column Info
	 * 
	 * @param holiFlag
	 */
	public void setHoliFlag(String holiFlag) {
		this.holiFlag = holiFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmClzHr
	 */
	public void setVgmClzHr(String vgmClzHr) {
		this.vgmClzHr = vgmClzHr;
	}

	/**
	 * Column Info
	 * 
	 * @param satFlag
	 */
	public void setSatFlag(String satFlag) {
		this.satFlag = satFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmXcldHolSunFlg
	 */
	public void setVgmXcldHolSunFlg(String vgmXcldHolSunFlg) {
		this.vgmXcldHolSunFlg = vgmXcldHolSunFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param cctDay
	 */
	public void setCctDay(String cctDay) {
		this.cctDay = cctDay;
	}

	/**
	 * Column Info
	 * 
	 * @param cctHour
	 */
	public void setCctHour(String cctHour) {
		this.cctHour = cctHour;
	}

	/**
	 * Column Info
	 * 
	 * @param orgDeleteFlag
	 */
	public void setOrgDeleteFlag(String orgDeleteFlag) {
		this.orgDeleteFlag = orgDeleteFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmXcldHolSatFlg
	 */
	public void setVgmXcldHolSatFlg(String vgmXcldHolSatFlg) {
		this.vgmXcldHolSatFlg = vgmXcldHolSatFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param yardCode
	 */
	public void setYardCode(String yardCode) {
		this.yardCode = yardCode;
	}

	/**
	 * Column Info
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * 
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	/**
	 * Column Info
	 * 
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmXcldHolFriFlg
	 */
	public void setVgmXcldHolFriFlg(String vgmXcldHolFriFlg) {
		this.vgmXcldHolFriFlg = vgmXcldHolFriFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param friFlag
	 */
	public void setFriFlag(String friFlag) {
		this.friFlag = friFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmClzTpCd
	 */
	public void setVgmClzTpCd(String vgmClzTpCd) {
		this.vgmClzTpCd = vgmClzTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cctTime
	 */
	public void setCctTime(String cctTime) {
		this.cctTime = cctTime;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmClzFileFlg
	 */
	public void setVgmClzFileFlg(String vgmClzFileFlg) {
		this.vgmClzFileFlg = vgmClzFileFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cctFileFlg
	 */
	public void setCctFileFlg(String cctFileFlg) {
		this.cctFileFlg = cctFileFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * Column Info
	 * 
	 * @param laneDirCode
	 */
	public void setLaneDirCode(String laneDirCode) {
		this.laneDirCode = laneDirCode;
	}

	/**
	 * Column Info
	 * 
	 * @param ydBseCalcFlg
	 */
	public void setYdBseCalcFlg(String ydBseCalcFlg) {
		this.ydBseCalcFlg = ydBseCalcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param laneCode
	 */
	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
	}

	/**
	 * Column Info
	 * 
	 * @param sunFlag
	 */
	public void setSunFlag(String sunFlag) {
		this.sunFlag = sunFlag;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmClzHrmnt
	 */
	public void setVgmClzHrmnt(String vgmClzHrmnt) {
		this.vgmClzHrmnt = vgmClzHrmnt;
	}

	/**
	 * Column Info
	 * 
	 * @param vgmYdBseCalcFlg
	 */
	public void setVgmYdBseCalcFlg(String vgmYdBseCalcFlg) {
		this.vgmYdBseCalcFlg = vgmYdBseCalcFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Column Info
	 * 
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Column Info
	 * 
	 * @param statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVgmXcldHolHolFlg(JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_hol_flg", ""));
		setCctOldType(JSPUtil.getParameter(request, prefix + "cct_old_type", ""));
		setCctType(JSPUtil.getParameter(request, prefix + "cct_type", ""));
		setVgmClzDyCd(JSPUtil.getParameter(request, prefix + "vgm_clz_dy_cd", ""));
		setHoliFlag(JSPUtil.getParameter(request, prefix + "holi_flag", ""));
		setVgmClzHr(JSPUtil.getParameter(request, prefix + "vgm_clz_hr", ""));
		setSatFlag(JSPUtil.getParameter(request, prefix + "sat_flag", ""));
		setVgmXcldHolSunFlg(JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_sun_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCctDay(JSPUtil.getParameter(request, prefix + "cct_day", ""));
		setCctHour(JSPUtil.getParameter(request, prefix + "cct_hour", ""));
		setOrgDeleteFlag(JSPUtil.getParameter(request, prefix + "org_delete_flag", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVgmXcldHolSatFlg(JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_sat_flg", ""));
		setYardCode(JSPUtil.getParameter(request, prefix + "yard_code", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCargoType(JSPUtil.getParameter(request, prefix + "cargo_type", ""));
		setDeleteFlag(JSPUtil.getParameter(request, prefix + "delete_flag", ""));
		setVgmXcldHolFriFlg(JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_fri_flg", ""));
		setFriFlag(JSPUtil.getParameter(request, prefix + "fri_flag", ""));
		setVgmClzTpCd(JSPUtil.getParameter(request, prefix + "vgm_clz_tp_cd", ""));
		setCctTime(JSPUtil.getParameter(request, prefix + "cct_time", ""));
		setVgmClzFileFlg(JSPUtil.getParameter(request, prefix + "vgm_clz_file_flg", ""));
		setCctFileFlg(JSPUtil.getParameter(request, prefix + "cct_file_flg", ""));
		setLocationCode(JSPUtil.getParameter(request, prefix + "location_code", ""));
		setLaneDirCode(JSPUtil.getParameter(request, prefix + "lane_dir_code", ""));
		setYdBseCalcFlg(JSPUtil.getParameter(request, prefix + "yd_bse_calc_flg", ""));
		setLaneCode(JSPUtil.getParameter(request, prefix + "lane_code", ""));
		setSunFlag(JSPUtil.getParameter(request, prefix + "sun_flag", ""));
		setVgmClzHrmnt(JSPUtil.getParameter(request, prefix + "vgm_clz_hrmnt", ""));
		setVgmYdBseCalcFlg(JSPUtil.getParameter(request, prefix + "vgm_yd_bse_calc_flg", ""));
		setCountryCode(JSPUtil.getParameter(request, prefix + "country_code", ""));
		setStatusCode(JSPUtil.getParameter(request, prefix + "status_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return NewCCTManageVO[]
	 */
	public NewCCTManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return NewCCTManageVO[]
	 */
	public NewCCTManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewCCTManageVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vgmXcldHolHolFlg = (JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_hol_flg", length));
			String[] cctOldType = (JSPUtil.getParameter(request, prefix + "cct_old_type", length));
			String[] cctType = (JSPUtil.getParameter(request, prefix + "cct_type", length));
			String[] vgmClzDyCd = (JSPUtil.getParameter(request, prefix + "vgm_clz_dy_cd", length));
			String[] holiFlag = (JSPUtil.getParameter(request, prefix + "holi_flag", length));
			String[] vgmClzHr = (JSPUtil.getParameter(request, prefix + "vgm_clz_hr", length));
			String[] satFlag = (JSPUtil.getParameter(request, prefix + "sat_flag", length));
			String[] vgmXcldHolSunFlg = (JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_sun_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] cctDay = (JSPUtil.getParameter(request, prefix + "cct_day", length));
			String[] cctHour = (JSPUtil.getParameter(request, prefix + "cct_hour", length));
			String[] orgDeleteFlag = (JSPUtil.getParameter(request, prefix + "org_delete_flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] vgmXcldHolSatFlg = (JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_sat_flg", length));
			String[] yardCode = (JSPUtil.getParameter(request, prefix + "yard_code", length));
			String[] userId = (JSPUtil.getParameter(request, prefix + "user_id", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix + "cargo_type", length));
			String[] deleteFlag = (JSPUtil.getParameter(request, prefix + "delete_flag", length));
			String[] vgmXcldHolFriFlg = (JSPUtil.getParameter(request, prefix + "vgm_xcld_hol_fri_flg", length));
			String[] friFlag = (JSPUtil.getParameter(request, prefix + "fri_flag", length));
			String[] vgmClzTpCd = (JSPUtil.getParameter(request, prefix + "vgm_clz_tp_cd", length));
			String[] cctTime = (JSPUtil.getParameter(request, prefix + "cct_time", length));
			String[] vgmClzFileFlg = (JSPUtil.getParameter(request, prefix + "vgm_clz_file_flg", length));
			String[] cctFileFlg = (JSPUtil.getParameter(request, prefix + "cct_file_flg", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix + "location_code", length));
			String[] laneDirCode = (JSPUtil.getParameter(request, prefix + "lane_dir_code", length));
			String[] ydBseCalcFlg = (JSPUtil.getParameter(request, prefix + "yd_bse_calc_flg", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix + "lane_code", length));
			String[] sunFlag = (JSPUtil.getParameter(request, prefix + "sun_flag", length));
			String[] vgmClzHrmnt = (JSPUtil.getParameter(request, prefix + "vgm_clz_hrmnt", length));
			String[] vgmYdBseCalcFlg = (JSPUtil.getParameter(request, prefix + "vgm_yd_bse_calc_flg", length));
			String[] countryCode = (JSPUtil.getParameter(request, prefix + "country_code", length));
			String[] statusCode = (JSPUtil.getParameter(request, prefix + "status_code", length));

			for (int i = 0; i < length; i++) {
				model = new NewCCTManageVO();
				if (vgmXcldHolHolFlg[i] != null)
					model.setVgmXcldHolHolFlg(vgmXcldHolHolFlg[i]);
				if (cctOldType[i] != null)
					model.setCctOldType(cctOldType[i]);
				if (cctType[i] != null)
					model.setCctType(cctType[i]);
				if (vgmClzDyCd[i] != null)
					model.setVgmClzDyCd(vgmClzDyCd[i]);
				if (holiFlag[i] != null)
					model.setHoliFlag(holiFlag[i]);
				if (vgmClzHr[i] != null)
					model.setVgmClzHr(vgmClzHr[i]);
				if (satFlag[i] != null)
					model.setSatFlag(satFlag[i]);
				if (vgmXcldHolSunFlg[i] != null)
					model.setVgmXcldHolSunFlg(vgmXcldHolSunFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cctDay[i] != null)
					model.setCctDay(cctDay[i]);
				if (cctHour[i] != null)
					model.setCctHour(cctHour[i]);
				if (orgDeleteFlag[i] != null)
					model.setOrgDeleteFlag(orgDeleteFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vgmXcldHolSatFlg[i] != null)
					model.setVgmXcldHolSatFlg(vgmXcldHolSatFlg[i]);
				if (yardCode[i] != null)
					model.setYardCode(yardCode[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (deleteFlag[i] != null)
					model.setDeleteFlag(deleteFlag[i]);
				if (vgmXcldHolFriFlg[i] != null)
					model.setVgmXcldHolFriFlg(vgmXcldHolFriFlg[i]);
				if (friFlag[i] != null)
					model.setFriFlag(friFlag[i]);
				if (vgmClzTpCd[i] != null)
					model.setVgmClzTpCd(vgmClzTpCd[i]);
				if (cctTime[i] != null)
					model.setCctTime(cctTime[i]);
				if (vgmClzFileFlg[i] != null)
					model.setVgmClzFileFlg(vgmClzFileFlg[i]);
				if (cctFileFlg[i] != null)
					model.setCctFileFlg(cctFileFlg[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (laneDirCode[i] != null)
					model.setLaneDirCode(laneDirCode[i]);
				if (ydBseCalcFlg[i] != null)
					model.setYdBseCalcFlg(ydBseCalcFlg[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (sunFlag[i] != null)
					model.setSunFlag(sunFlag[i]);
				if (vgmClzHrmnt[i] != null)
					model.setVgmClzHrmnt(vgmClzHrmnt[i]);
				if (vgmYdBseCalcFlg[i] != null)
					model.setVgmYdBseCalcFlg(vgmYdBseCalcFlg[i]);
				if (countryCode[i] != null)
					model.setCountryCode(countryCode[i]);
				if (statusCode[i] != null)
					model.setStatusCode(statusCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewCCTManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return NewCCTManageVO[]
	 */
	public NewCCTManageVO[] getNewCCTManageVOs() {
		NewCCTManageVO[] vos = (NewCCTManageVO[]) models.toArray(new NewCCTManageVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.vgmXcldHolHolFlg = this.vgmXcldHolHolFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctOldType = this.cctOldType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctType = this.cctType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzDyCd = this.vgmClzDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holiFlag = this.holiFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzHr = this.vgmClzHr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.satFlag = this.satFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmXcldHolSunFlg = this.vgmXcldHolSunFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDay = this.cctDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctHour = this.cctHour.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDeleteFlag = this.orgDeleteFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmXcldHolSatFlg = this.vgmXcldHolSatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCode = this.yardCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deleteFlag = this.deleteFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmXcldHolFriFlg = this.vgmXcldHolFriFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.friFlag = this.friFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzTpCd = this.vgmClzTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctTime = this.cctTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzFileFlg = this.vgmClzFileFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctFileFlg = this.cctFileFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneDirCode = this.laneDirCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydBseCalcFlg = this.ydBseCalcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sunFlag = this.sunFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmClzHrmnt = this.vgmClzHrmnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmYdBseCalcFlg = this.vgmYdBseCalcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.countryCode = this.countryCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCode = this.statusCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
