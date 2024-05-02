/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqDayMgmtVO.java
*@FileTitle : EqDayMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier :  최덕우
*@LastVersion : 1.0
* 2016.08.25  최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo;

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
 * @author  최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqDayMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqDayMgmtVO> models = new ArrayList<EqDayMgmtVO>();
	
	/* Column Info */
	private String tsRout = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String fLaneCd = null;
	/* Column Info */
	private String fDelCd = null;
	/* Column Info */
	private String ibFullLandTtDys = null;
	/* Column Info */
	private String mtLand = null;
	/* Column Info */
	private String tpszCd = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String orgRailDys = null;
	/* Column Info */
	private String locationDel = null;
	/* Column Info */
	private String fEqItm = null;
	/* Column Info */
	private String fPorCd = null;
	/* Column Info */
	private String locationPor = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String destRailDys = null;
	/* Column Info */
	private String locationByDel = null;
	/* Column Info */
	private String mtSeaDys = null;
	/* Column Info */
	private String locationByPor = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String destMtyLandDys = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dysDmtExptSea = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String fullDmt = null;
	/* Column Info */
	private String orgMtyLandDys = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fEqDays = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqDayMgmtVO() {}

	public EqDayMgmtVO(String ibflag, String pagerows, String costYrmon, String porCd, String polCd, String podCd, String delCd, String tsRout, String tpszCd, String laneCd, String seaDys, String ibFullLandTtDys, String orgMtyLandDys, String destMtyLandDys, String fCntrTpszCd, String fCostYrmon, String fPorCd, String fDelCd, String fLaneCd, String creUsrId, String updUsrId, String fEqItm, String fEqDays, String orgRailDys, String destRailDys, String fullDmt, String mtSeaDys, String locationByPor, String locationPor, String locationByDel, String locationDel, String mtLand, String dysDmtExptSea, String code) {
		this.tsRout = tsRout;
		this.porCd = porCd;
		this.laneCd = laneCd;
		this.fLaneCd = fLaneCd;
		this.fDelCd = fDelCd;
		this.ibFullLandTtDys = ibFullLandTtDys;
		this.mtLand = mtLand;
		this.tpszCd = tpszCd;
		this.fCntrTpszCd = fCntrTpszCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.orgRailDys = orgRailDys;
		this.locationDel = locationDel;
		this.fEqItm = fEqItm;
		this.fPorCd = fPorCd;
		this.locationPor = locationPor;
		this.updUsrId = updUsrId;
		this.destRailDys = destRailDys;
		this.locationByDel = locationByDel;
		this.mtSeaDys = mtSeaDys;
		this.locationByPor = locationByPor;
		this.fCostYrmon = fCostYrmon;
		this.destMtyLandDys = destMtyLandDys;
		this.delCd = delCd;
		this.dysDmtExptSea = dysDmtExptSea;
		this.code = code;
		this.fullDmt = fullDmt;
		this.orgMtyLandDys = orgMtyLandDys;
		this.seaDys = seaDys;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.fEqDays = fEqDays;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts_rout", getTsRout());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("f_lane_cd", getFLaneCd());
		this.hashColumns.put("f_del_cd", getFDelCd());
		this.hashColumns.put("ib_full_land_tt_dys", getIbFullLandTtDys());
		this.hashColumns.put("mt_land", getMtLand());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("org_rail_dys", getOrgRailDys());
		this.hashColumns.put("location_del", getLocationDel());
		this.hashColumns.put("f_eq_itm", getFEqItm());
		this.hashColumns.put("f_por_cd", getFPorCd());
		this.hashColumns.put("location_por", getLocationPor());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dest_rail_dys", getDestRailDys());
		this.hashColumns.put("location_by_del", getLocationByDel());
		this.hashColumns.put("mt_sea_dys", getMtSeaDys());
		this.hashColumns.put("location_by_por", getLocationByPor());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("dest_mty_land_dys", getDestMtyLandDys());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dys_dmt_expt_sea", getDysDmtExptSea());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("full_dmt", getFullDmt());
		this.hashColumns.put("org_mty_land_dys", getOrgMtyLandDys());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("f_eq_days", getFEqDays());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts_rout", "tsRout");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("f_lane_cd", "fLaneCd");
		this.hashFields.put("f_del_cd", "fDelCd");
		this.hashFields.put("ib_full_land_tt_dys", "ibFullLandTtDys");
		this.hashFields.put("mt_land", "mtLand");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("org_rail_dys", "orgRailDys");
		this.hashFields.put("location_del", "locationDel");
		this.hashFields.put("f_eq_itm", "fEqItm");
		this.hashFields.put("f_por_cd", "fPorCd");
		this.hashFields.put("location_por", "locationPor");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dest_rail_dys", "destRailDys");
		this.hashFields.put("location_by_del", "locationByDel");
		this.hashFields.put("mt_sea_dys", "mtSeaDys");
		this.hashFields.put("location_by_por", "locationByPor");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("dest_mty_land_dys", "destMtyLandDys");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dys_dmt_expt_sea", "dysDmtExptSea");
		this.hashFields.put("code", "code");
		this.hashFields.put("full_dmt", "fullDmt");
		this.hashFields.put("org_mty_land_dys", "orgMtyLandDys");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("f_eq_days", "fEqDays");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tsRout
	 */
	public String getTsRout() {
		return this.tsRout;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return fLaneCd
	 */
	public String getFLaneCd() {
		return this.fLaneCd;
	}
	
	/**
	 * Column Info
	 * @return fDelCd
	 */
	public String getFDelCd() {
		return this.fDelCd;
	}
	
	/**
	 * Column Info
	 * @return ibFullLandTtDys
	 */
	public String getIbFullLandTtDys() {
		return this.ibFullLandTtDys;
	}
	
	/**
	 * Column Info
	 * @return mtLand
	 */
	public String getMtLand() {
		return this.mtLand;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return orgRailDys
	 */
	public String getOrgRailDys() {
		return this.orgRailDys;
	}
	
	/**
	 * Column Info
	 * @return locationDel
	 */
	public String getLocationDel() {
		return this.locationDel;
	}
	
	/**
	 * Column Info
	 * @return fEqItm
	 */
	public String getFEqItm() {
		return this.fEqItm;
	}
	
	/**
	 * Column Info
	 * @return fPorCd
	 */
	public String getFPorCd() {
		return this.fPorCd;
	}
	
	/**
	 * Column Info
	 * @return locationPor
	 */
	public String getLocationPor() {
		return this.locationPor;
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
	 * @return destRailDys
	 */
	public String getDestRailDys() {
		return this.destRailDys;
	}
	
	/**
	 * Column Info
	 * @return locationByDel
	 */
	public String getLocationByDel() {
		return this.locationByDel;
	}
	
	/**
	 * Column Info
	 * @return mtSeaDys
	 */
	public String getMtSeaDys() {
		return this.mtSeaDys;
	}
	
	/**
	 * Column Info
	 * @return locationByPor
	 */
	public String getLocationByPor() {
		return this.locationByPor;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return destMtyLandDys
	 */
	public String getDestMtyLandDys() {
		return this.destMtyLandDys;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return dysDmtExptSea
	 */
	public String getDysDmtExptSea() {
		return this.dysDmtExptSea;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return fullDmt
	 */
	public String getFullDmt() {
		return this.fullDmt;
	}
	
	/**
	 * Column Info
	 * @return orgMtyLandDys
	 */
	public String getOrgMtyLandDys() {
		return this.orgMtyLandDys;
	}
	
	/**
	 * Column Info
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fEqDays
	 */
	public String getFEqDays() {
		return this.fEqDays;
	}
	

	/**
	 * Column Info
	 * @param tsRout
	 */
	public void setTsRout(String tsRout) {
		this.tsRout = tsRout;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param fLaneCd
	 */
	public void setFLaneCd(String fLaneCd) {
		this.fLaneCd = fLaneCd;
	}
	
	/**
	 * Column Info
	 * @param fDelCd
	 */
	public void setFDelCd(String fDelCd) {
		this.fDelCd = fDelCd;
	}
	
	/**
	 * Column Info
	 * @param ibFullLandTtDys
	 */
	public void setIbFullLandTtDys(String ibFullLandTtDys) {
		this.ibFullLandTtDys = ibFullLandTtDys;
	}
	
	/**
	 * Column Info
	 * @param mtLand
	 */
	public void setMtLand(String mtLand) {
		this.mtLand = mtLand;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param orgRailDys
	 */
	public void setOrgRailDys(String orgRailDys) {
		this.orgRailDys = orgRailDys;
	}
	
	/**
	 * Column Info
	 * @param locationDel
	 */
	public void setLocationDel(String locationDel) {
		this.locationDel = locationDel;
	}
	
	/**
	 * Column Info
	 * @param fEqItm
	 */
	public void setFEqItm(String fEqItm) {
		this.fEqItm = fEqItm;
	}
	
	/**
	 * Column Info
	 * @param fPorCd
	 */
	public void setFPorCd(String fPorCd) {
		this.fPorCd = fPorCd;
	}
	
	/**
	 * Column Info
	 * @param locationPor
	 */
	public void setLocationPor(String locationPor) {
		this.locationPor = locationPor;
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
	 * @param destRailDys
	 */
	public void setDestRailDys(String destRailDys) {
		this.destRailDys = destRailDys;
	}
	
	/**
	 * Column Info
	 * @param locationByDel
	 */
	public void setLocationByDel(String locationByDel) {
		this.locationByDel = locationByDel;
	}
	
	/**
	 * Column Info
	 * @param mtSeaDys
	 */
	public void setMtSeaDys(String mtSeaDys) {
		this.mtSeaDys = mtSeaDys;
	}
	
	/**
	 * Column Info
	 * @param locationByPor
	 */
	public void setLocationByPor(String locationByPor) {
		this.locationByPor = locationByPor;
	}
	
	/**
	 * Column Info
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param destMtyLandDys
	 */
	public void setDestMtyLandDys(String destMtyLandDys) {
		this.destMtyLandDys = destMtyLandDys;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param dysDmtExptSea
	 */
	public void setDysDmtExptSea(String dysDmtExptSea) {
		this.dysDmtExptSea = dysDmtExptSea;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param fullDmt
	 */
	public void setFullDmt(String fullDmt) {
		this.fullDmt = fullDmt;
	}
	
	/**
	 * Column Info
	 * @param orgMtyLandDys
	 */
	public void setOrgMtyLandDys(String orgMtyLandDys) {
		this.orgMtyLandDys = orgMtyLandDys;
	}
	
	/**
	 * Column Info
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fEqDays
	 */
	public void setFEqDays(String fEqDays) {
		this.fEqDays = fEqDays;
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
		setTsRout(JSPUtil.getParameter(request, prefix + "ts_rout", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setFLaneCd(JSPUtil.getParameter(request, prefix + "f_lane_cd", ""));
		setFDelCd(JSPUtil.getParameter(request, prefix + "f_del_cd", ""));
		setIbFullLandTtDys(JSPUtil.getParameter(request, prefix + "ib_full_land_tt_dys", ""));
		setMtLand(JSPUtil.getParameter(request, prefix + "mt_land", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setOrgRailDys(JSPUtil.getParameter(request, prefix + "org_rail_dys", ""));
		setLocationDel(JSPUtil.getParameter(request, prefix + "location_del", ""));
		setFEqItm(JSPUtil.getParameter(request, prefix + "f_eq_itm", ""));
		setFPorCd(JSPUtil.getParameter(request, prefix + "f_por_cd", ""));
		setLocationPor(JSPUtil.getParameter(request, prefix + "location_por", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDestRailDys(JSPUtil.getParameter(request, prefix + "dest_rail_dys", ""));
		setLocationByDel(JSPUtil.getParameter(request, prefix + "location_by_del", ""));
		setMtSeaDys(JSPUtil.getParameter(request, prefix + "mt_sea_dys", ""));
		setLocationByPor(JSPUtil.getParameter(request, prefix + "location_by_por", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setDestMtyLandDys(JSPUtil.getParameter(request, prefix + "dest_mty_land_dys", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDysDmtExptSea(JSPUtil.getParameter(request, prefix + "dys_dmt_expt_sea", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setFullDmt(JSPUtil.getParameter(request, prefix + "full_dmt", ""));
		setOrgMtyLandDys(JSPUtil.getParameter(request, prefix + "org_mty_land_dys", ""));
		setSeaDys(JSPUtil.getParameter(request, prefix + "sea_dys", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFEqDays(JSPUtil.getParameter(request, prefix + "f_eq_days", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqDayMgmtVO[]
	 */
	public EqDayMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqDayMgmtVO[]
	 */
	public EqDayMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqDayMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tsRout = (JSPUtil.getParameter(request, prefix	+ "ts_rout", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] fLaneCd = (JSPUtil.getParameter(request, prefix	+ "f_lane_cd", length));
			String[] fDelCd = (JSPUtil.getParameter(request, prefix	+ "f_del_cd", length));
			String[] ibFullLandTtDys = (JSPUtil.getParameter(request, prefix	+ "ib_full_land_tt_dys", length));
			String[] mtLand = (JSPUtil.getParameter(request, prefix	+ "mt_land", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] orgRailDys = (JSPUtil.getParameter(request, prefix	+ "org_rail_dys", length));
			String[] locationDel = (JSPUtil.getParameter(request, prefix	+ "location_del", length));
			String[] fEqItm = (JSPUtil.getParameter(request, prefix	+ "f_eq_itm", length));
			String[] fPorCd = (JSPUtil.getParameter(request, prefix	+ "f_por_cd", length));
			String[] locationPor = (JSPUtil.getParameter(request, prefix	+ "location_por", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] destRailDys = (JSPUtil.getParameter(request, prefix	+ "dest_rail_dys", length));
			String[] locationByDel = (JSPUtil.getParameter(request, prefix	+ "location_by_del", length));
			String[] mtSeaDys = (JSPUtil.getParameter(request, prefix	+ "mt_sea_dys", length));
			String[] locationByPor = (JSPUtil.getParameter(request, prefix	+ "location_by_por", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] destMtyLandDys = (JSPUtil.getParameter(request, prefix	+ "dest_mty_land_dys", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dysDmtExptSea = (JSPUtil.getParameter(request, prefix	+ "dys_dmt_expt_sea", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] fullDmt = (JSPUtil.getParameter(request, prefix	+ "full_dmt", length));
			String[] orgMtyLandDys = (JSPUtil.getParameter(request, prefix	+ "org_mty_land_dys", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fEqDays = (JSPUtil.getParameter(request, prefix	+ "f_eq_days", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqDayMgmtVO();
				if (tsRout[i] != null)
					model.setTsRout(tsRout[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (fLaneCd[i] != null)
					model.setFLaneCd(fLaneCd[i]);
				if (fDelCd[i] != null)
					model.setFDelCd(fDelCd[i]);
				if (ibFullLandTtDys[i] != null)
					model.setIbFullLandTtDys(ibFullLandTtDys[i]);
				if (mtLand[i] != null)
					model.setMtLand(mtLand[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (orgRailDys[i] != null)
					model.setOrgRailDys(orgRailDys[i]);
				if (locationDel[i] != null)
					model.setLocationDel(locationDel[i]);
				if (fEqItm[i] != null)
					model.setFEqItm(fEqItm[i]);
				if (fPorCd[i] != null)
					model.setFPorCd(fPorCd[i]);
				if (locationPor[i] != null)
					model.setLocationPor(locationPor[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (destRailDys[i] != null)
					model.setDestRailDys(destRailDys[i]);
				if (locationByDel[i] != null)
					model.setLocationByDel(locationByDel[i]);
				if (mtSeaDys[i] != null)
					model.setMtSeaDys(mtSeaDys[i]);
				if (locationByPor[i] != null)
					model.setLocationByPor(locationByPor[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (destMtyLandDys[i] != null)
					model.setDestMtyLandDys(destMtyLandDys[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dysDmtExptSea[i] != null)
					model.setDysDmtExptSea(dysDmtExptSea[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (fullDmt[i] != null)
					model.setFullDmt(fullDmt[i]);
				if (orgMtyLandDys[i] != null)
					model.setOrgMtyLandDys(orgMtyLandDys[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fEqDays[i] != null)
					model.setFEqDays(fEqDays[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqDayMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqDayMgmtVO[]
	 */
	public EqDayMgmtVO[] getEqDayMgmtVOs(){
		EqDayMgmtVO[] vos = (EqDayMgmtVO[])models.toArray(new EqDayMgmtVO[models.size()]);
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
		this.tsRout = this.tsRout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLaneCd = this.fLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDelCd = this.fDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFullLandTtDys = this.ibFullLandTtDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtLand = this.mtLand .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRailDys = this.orgRailDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationDel = this.locationDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEqItm = this.fEqItm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPorCd = this.fPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationPor = this.locationPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRailDys = this.destRailDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationByDel = this.locationByDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtSeaDys = this.mtSeaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationByPor = this.locationByPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destMtyLandDys = this.destMtyLandDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dysDmtExptSea = this.dysDmtExptSea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullDmt = this.fullDmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMtyLandDys = this.orgMtyLandDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEqDays = this.fEqDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
