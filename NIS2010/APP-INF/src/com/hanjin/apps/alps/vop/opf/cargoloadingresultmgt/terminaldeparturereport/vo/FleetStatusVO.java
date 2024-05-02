/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FleetStatusVO.java
*@FileTitle : FleetStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : YONG JOON LEE 
*@LastVersion : 1.4
* 2014.12.05  이용준
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FleetStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FleetStatusVO> models = new ArrayList<FleetStatusVO>();
	
	/* Column Info */
	private String coBsaW = null;
	/* Column Info */
	private String eaHjs = null;
	/* Column Info */
	private String hjsBsaW = null;
	/* Column Info */
	private String chtrBsaRtoE = null;
	/* Column Info */
	private String hjsBsaRtoE = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlBsaW = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String coBsaE = null;
	/* Column Info */
	private String svcDurDys = null;
	/* Column Info */
	private String hjsVslChtNm = null;
	/* Column Info */
	private String fleetStatus = null;
	/* Column Info */
	private String hjsBsaE = null;
	/* Column Info */
	private String chtrBsaRtoW = null;
	/* Column Info */
	private String portRot = null;
	/* Column Info */
	private String hjsVslOwnNm = null;
	/* Column Info */
	private String ttlBsaE = null;
	/* Column Info */
	private String bsaType = null;
	/* Column Info */
	private String vslType = null;
	/* Column Info */
	private String vslCdCnt = null;
	/* Column Info */
	private String laneOthers = null;
	/* Column Info */
	private String yrWk = null;
	/* Column Info */
	private String eaOthers = null;
	/* Column Info */
	private String pDate = null;
	/* Column Info */
	private String carrierCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String hjsBsaRtoW = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String ownrSeq = null;
	/* Column Info */
	private String laneHjs = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String laneTotal = null;
	/* Column Info */
	private String vslQtyTtl = null;
	/* Column Info */
	private String eaTotal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FleetStatusVO() {}

	public FleetStatusVO(String ibflag, String pagerows, String vslType, String ownerNm, String carrierCd, String pDate, String bsaType, String seq, String yrWk, String slanCd, String svcDurDys, String fleetStatus, String vslCdCnt, String vslQtyTtl, String hjsVslOwnNm, String hjsVslChtNm, String ttlBsaW, String ttlBsaE, String hjsBsaW, String hjsBsaE, String coBsaW, String coBsaE, String hjsBsaRtoW, String hjsBsaRtoE, String chtrBsaRtoW, String chtrBsaRtoE, String portRot, String laneHjs, String laneOthers, String laneTotal, String eaHjs, String eaOthers, String eaTotal) {
		this.coBsaW = coBsaW;
		this.eaHjs = eaHjs;
		this.hjsBsaW = hjsBsaW;
		this.chtrBsaRtoE = chtrBsaRtoE;
		this.hjsBsaRtoE = hjsBsaRtoE;
		this.pagerows = pagerows;
		this.ttlBsaW = ttlBsaW;
		this.ibflag = ibflag;
		this.coBsaE = coBsaE;
		this.svcDurDys = svcDurDys;
		this.hjsVslChtNm = hjsVslChtNm;
		this.fleetStatus = fleetStatus;
		this.hjsBsaE = hjsBsaE;
		this.chtrBsaRtoW = chtrBsaRtoW;
		this.portRot = portRot;
		this.hjsVslOwnNm = hjsVslOwnNm;
		this.ttlBsaE = ttlBsaE;
		this.bsaType = bsaType;
		this.vslType = vslType;
		this.vslCdCnt = vslCdCnt;
		this.laneOthers = laneOthers;
		this.yrWk = yrWk;
		this.eaOthers = eaOthers;
		this.pDate = pDate;
		this.carrierCd = carrierCd;
		this.slanCd = slanCd;
		this.hjsBsaRtoW = hjsBsaRtoW;
		this.ownrNm = ownrNm;
		this.ownrSeq = ownrSeq;
		this.laneHjs = laneHjs;
		this.seq = seq;
		this.laneTotal = laneTotal;
		this.vslQtyTtl = vslQtyTtl;
		this.eaTotal = eaTotal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("co_bsa_w", getCoBsaW());
		this.hashColumns.put("ea_hjs", getEaHjs());
		this.hashColumns.put("hjs_bsa_w", getHjsBsaW());
		this.hashColumns.put("chtr_bsa_rto_e", getChtrBsaRtoE());
		this.hashColumns.put("hjs_bsa_rto_e", getHjsBsaRtoE());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_bsa_w", getTtlBsaW());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("co_bsa_e", getCoBsaE());
		this.hashColumns.put("svc_dur_dys", getSvcDurDys());
		this.hashColumns.put("hjs_vsl_cht_nm", getHjsVslChtNm());
		this.hashColumns.put("fleet_status", getFleetStatus());
		this.hashColumns.put("hjs_bsa_e", getHjsBsaE());
		this.hashColumns.put("chtr_bsa_rto_w", getChtrBsaRtoW());
		this.hashColumns.put("port_rot", getPortRot());
		this.hashColumns.put("hjs_vsl_own_nm", getHjsVslOwnNm());
		this.hashColumns.put("ttl_bsa_e", getTtlBsaE());
		this.hashColumns.put("bsa_type", getBsaType());
		this.hashColumns.put("vsl_type", getVslType());
		this.hashColumns.put("vsl_cd_cnt", getVslCdCnt());
		this.hashColumns.put("lane_others", getLaneOthers());
		this.hashColumns.put("yr_wk", getYrWk());
		this.hashColumns.put("ea_others", getEaOthers());
		this.hashColumns.put("p_date", getPDate());
		this.hashColumns.put("carrier_cd", getCarrierCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("hjs_bsa_rto_w", getHjsBsaRtoW());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("lane_hjs", getLaneHjs());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("lane_total", getLaneTotal());
		this.hashColumns.put("vsl_qty_ttl", getVslQtyTtl());
		this.hashColumns.put("ea_total", getEaTotal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("co_bsa_w", "coBsaW");
		this.hashFields.put("ea_hjs", "eaHjs");
		this.hashFields.put("hjs_bsa_w", "hjsBsaW");
		this.hashFields.put("chtr_bsa_rto_e", "chtrBsaRtoE");
		this.hashFields.put("hjs_bsa_rto_e", "hjsBsaRtoE");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_bsa_w", "ttlBsaW");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("co_bsa_e", "coBsaE");
		this.hashFields.put("svc_dur_dys", "svcDurDys");
		this.hashFields.put("hjs_vsl_cht_nm", "hjsVslChtNm");
		this.hashFields.put("fleet_status", "fleetStatus");
		this.hashFields.put("hjs_bsa_e", "hjsBsaE");
		this.hashFields.put("chtr_bsa_rto_w", "chtrBsaRtoW");
		this.hashFields.put("port_rot", "portRot");
		this.hashFields.put("hjs_vsl_own_nm", "hjsVslOwnNm");
		this.hashFields.put("ttl_bsa_e", "ttlBsaE");
		this.hashFields.put("bsa_type", "bsaType");
		this.hashFields.put("vsl_type", "vslType");
		this.hashFields.put("vsl_cd_cnt", "vslCdCnt");
		this.hashFields.put("lane_others", "laneOthers");
		this.hashFields.put("yr_wk", "yrWk");
		this.hashFields.put("ea_others", "eaOthers");
		this.hashFields.put("p_date", "pDate");
		this.hashFields.put("carrier_cd", "carrierCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("hjs_bsa_rto_w", "hjsBsaRtoW");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("lane_hjs", "laneHjs");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("lane_total", "laneTotal");
		this.hashFields.put("vsl_qty_ttl", "vslQtyTtl");
		this.hashFields.put("ea_total", "eaTotal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coBsaW
	 */
	public String getCoBsaW() {
		return this.coBsaW;
	}
	
	/**
	 * Column Info
	 * @return eaHjs
	 */
	public String getEaHjs() {
		return this.eaHjs;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaW
	 */
	public String getHjsBsaW() {
		return this.hjsBsaW;
	}
	
	/**
	 * Column Info
	 * @return chtrBsaRtoE
	 */
	public String getChtrBsaRtoE() {
		return this.chtrBsaRtoE;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaRtoE
	 */
	public String getHjsBsaRtoE() {
		return this.hjsBsaRtoE;
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
	 * @return ttlBsaW
	 */
	public String getTtlBsaW() {
		return this.ttlBsaW;
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
	 * @return coBsaE
	 */
	public String getCoBsaE() {
		return this.coBsaE;
	}
	
	/**
	 * Column Info
	 * @return svcDurDys
	 */
	public String getSvcDurDys() {
		return this.svcDurDys;
	}
	
	/**
	 * Column Info
	 * @return hjsVslChtNm
	 */
	public String getHjsVslChtNm() {
		return this.hjsVslChtNm;
	}
	
	/**
	 * Column Info
	 * @return fleetStatus
	 */
	public String getFleetStatus() {
		return this.fleetStatus;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaE
	 */
	public String getHjsBsaE() {
		return this.hjsBsaE;
	}
	
	/**
	 * Column Info
	 * @return chtrBsaRtoW
	 */
	public String getChtrBsaRtoW() {
		return this.chtrBsaRtoW;
	}
	
	/**
	 * Column Info
	 * @return portRot
	 */
	public String getPortRot() {
		return this.portRot;
	}
	
	/**
	 * Column Info
	 * @return hjsVslOwnNm
	 */
	public String getHjsVslOwnNm() {
		return this.hjsVslOwnNm;
	}
	
	/**
	 * Column Info
	 * @return ttlBsaE
	 */
	public String getTtlBsaE() {
		return this.ttlBsaE;
	}
	
	/**
	 * Column Info
	 * @return bsaType
	 */
	public String getBsaType() {
		return this.bsaType;
	}
	
	/**
	 * Column Info
	 * @return vslType
	 */
	public String getVslType() {
		return this.vslType;
	}
	
	/**
	 * Column Info
	 * @return vslCdCnt
	 */
	public String getVslCdCnt() {
		return this.vslCdCnt;
	}
	
	/**
	 * Column Info
	 * @return laneOthers
	 */
	public String getLaneOthers() {
		return this.laneOthers;
	}
	
	/**
	 * Column Info
	 * @return yrWk
	 */
	public String getYrWk() {
		return this.yrWk;
	}
	
	/**
	 * Column Info
	 * @return eaOthers
	 */
	public String getEaOthers() {
		return this.eaOthers;
	}
	
	/**
	 * Column Info
	 * @return pDate
	 */
	public String getPDate() {
		return this.pDate;
	}
	
	/**
	 * Column Info
	 * @return carrierCd
	 */
	public String getCarrierCd() {
		return this.carrierCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaRtoW
	 */
	public String getHjsBsaRtoW() {
		return this.hjsBsaRtoW;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return ownrSeq
	 */
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	
	/**
	 * Column Info
	 * @return laneHjs
	 */
	public String getLaneHjs() {
		return this.laneHjs;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return laneTotal
	 */
	public String getLaneTotal() {
		return this.laneTotal;
	}
	
	/**
	 * Column Info
	 * @return vslQtyTtl
	 */
	public String getVslQtyTtl() {
		return this.vslQtyTtl;
	}
	
	/**
	 * Column Info
	 * @return eaTotal
	 */
	public String getEaTotal() {
		return this.eaTotal;
	}
	

	/**
	 * Column Info
	 * @param coBsaW
	 */
	public void setCoBsaW(String coBsaW) {
		this.coBsaW = coBsaW;
	}
	
	/**
	 * Column Info
	 * @param eaHjs
	 */
	public void setEaHjs(String eaHjs) {
		this.eaHjs = eaHjs;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaW
	 */
	public void setHjsBsaW(String hjsBsaW) {
		this.hjsBsaW = hjsBsaW;
	}
	
	/**
	 * Column Info
	 * @param chtrBsaRtoE
	 */
	public void setChtrBsaRtoE(String chtrBsaRtoE) {
		this.chtrBsaRtoE = chtrBsaRtoE;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaRtoE
	 */
	public void setHjsBsaRtoE(String hjsBsaRtoE) {
		this.hjsBsaRtoE = hjsBsaRtoE;
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
	 * @param ttlBsaW
	 */
	public void setTtlBsaW(String ttlBsaW) {
		this.ttlBsaW = ttlBsaW;
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
	 * @param coBsaE
	 */
	public void setCoBsaE(String coBsaE) {
		this.coBsaE = coBsaE;
	}
	
	/**
	 * Column Info
	 * @param svcDurDys
	 */
	public void setSvcDurDys(String svcDurDys) {
		this.svcDurDys = svcDurDys;
	}
	
	/**
	 * Column Info
	 * @param hjsVslChtNm
	 */
	public void setHjsVslChtNm(String hjsVslChtNm) {
		this.hjsVslChtNm = hjsVslChtNm;
	}
	
	/**
	 * Column Info
	 * @param fleetStatus
	 */
	public void setFleetStatus(String fleetStatus) {
		this.fleetStatus = fleetStatus;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaE
	 */
	public void setHjsBsaE(String hjsBsaE) {
		this.hjsBsaE = hjsBsaE;
	}
	
	/**
	 * Column Info
	 * @param chtrBsaRtoW
	 */
	public void setChtrBsaRtoW(String chtrBsaRtoW) {
		this.chtrBsaRtoW = chtrBsaRtoW;
	}
	
	/**
	 * Column Info
	 * @param portRot
	 */
	public void setPortRot(String portRot) {
		this.portRot = portRot;
	}
	
	/**
	 * Column Info
	 * @param hjsVslOwnNm
	 */
	public void setHjsVslOwnNm(String hjsVslOwnNm) {
		this.hjsVslOwnNm = hjsVslOwnNm;
	}
	
	/**
	 * Column Info
	 * @param ttlBsaE
	 */
	public void setTtlBsaE(String ttlBsaE) {
		this.ttlBsaE = ttlBsaE;
	}
	
	/**
	 * Column Info
	 * @param bsaType
	 */
	public void setBsaType(String bsaType) {
		this.bsaType = bsaType;
	}
	
	/**
	 * Column Info
	 * @param vslType
	 */
	public void setVslType(String vslType) {
		this.vslType = vslType;
	}
	
	/**
	 * Column Info
	 * @param vslCdCnt
	 */
	public void setVslCdCnt(String vslCdCnt) {
		this.vslCdCnt = vslCdCnt;
	}
	
	/**
	 * Column Info
	 * @param laneOthers
	 */
	public void setLaneOthers(String laneOthers) {
		this.laneOthers = laneOthers;
	}
	
	/**
	 * Column Info
	 * @param yrWk
	 */
	public void setYrWk(String yrWk) {
		this.yrWk = yrWk;
	}
	
	/**
	 * Column Info
	 * @param eaOthers
	 */
	public void setEaOthers(String eaOthers) {
		this.eaOthers = eaOthers;
	}
	
	/**
	 * Column Info
	 * @param pDate
	 */
	public void setPDate(String pDate) {
		this.pDate = pDate;
	}
	
	/**
	 * Column Info
	 * @param carrierCd
	 */
	public void setCarrierCd(String carrierCd) {
		this.carrierCd = carrierCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaRtoW
	 */
	public void setHjsBsaRtoW(String hjsBsaRtoW) {
		this.hjsBsaRtoW = hjsBsaRtoW;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param ownrSeq
	 */
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
	}
	
	/**
	 * Column Info
	 * @param laneHjs
	 */
	public void setLaneHjs(String laneHjs) {
		this.laneHjs = laneHjs;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param laneTotal
	 */
	public void setLaneTotal(String laneTotal) {
		this.laneTotal = laneTotal;
	}
	
	/**
	 * Column Info
	 * @param vslQtyTtl
	 */
	public void setVslQtyTtl(String vslQtyTtl) {
		this.vslQtyTtl = vslQtyTtl;
	}
	
	/**
	 * Column Info
	 * @param eaTotal
	 */
	public void setEaTotal(String eaTotal) {
		this.eaTotal = eaTotal;
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
		setCoBsaW(JSPUtil.getParameter(request, prefix + "co_bsa_w", ""));
		setEaHjs(JSPUtil.getParameter(request, prefix + "ea_hjs", ""));
		setHjsBsaW(JSPUtil.getParameter(request, prefix + "hjs_bsa_w", ""));
		setChtrBsaRtoE(JSPUtil.getParameter(request, prefix + "chtr_bsa_rto_e", ""));
		setHjsBsaRtoE(JSPUtil.getParameter(request, prefix + "hjs_bsa_rto_e", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlBsaW(JSPUtil.getParameter(request, prefix + "ttl_bsa_w", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCoBsaE(JSPUtil.getParameter(request, prefix + "co_bsa_e", ""));
		setSvcDurDys(JSPUtil.getParameter(request, prefix + "svc_dur_dys", ""));
		setHjsVslChtNm(JSPUtil.getParameter(request, prefix + "hjs_vsl_cht_nm", ""));
		setFleetStatus(JSPUtil.getParameter(request, prefix + "fleet_status", ""));
		setHjsBsaE(JSPUtil.getParameter(request, prefix + "hjs_bsa_e", ""));
		setChtrBsaRtoW(JSPUtil.getParameter(request, prefix + "chtr_bsa_rto_w", ""));
		setPortRot(JSPUtil.getParameter(request, prefix + "port_rot", ""));
		setHjsVslOwnNm(JSPUtil.getParameter(request, prefix + "hjs_vsl_own_nm", ""));
		setTtlBsaE(JSPUtil.getParameter(request, prefix + "ttl_bsa_e", ""));
		setBsaType(JSPUtil.getParameter(request, prefix + "bsa_type", ""));
		setVslType(JSPUtil.getParameter(request, prefix + "vsl_type", ""));
		setVslCdCnt(JSPUtil.getParameter(request, prefix + "vsl_cd_cnt", ""));
		setLaneOthers(JSPUtil.getParameter(request, prefix + "lane_others", ""));
		setYrWk(JSPUtil.getParameter(request, prefix + "yr_wk", ""));
		setEaOthers(JSPUtil.getParameter(request, prefix + "ea_others", ""));
		setPDate(JSPUtil.getParameter(request, prefix + "p_date", ""));
		setCarrierCd(JSPUtil.getParameter(request, prefix + "carrier_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setHjsBsaRtoW(JSPUtil.getParameter(request, prefix + "hjs_bsa_rto_w", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setOwnrSeq(JSPUtil.getParameter(request, prefix + "ownr_seq", ""));
		setLaneHjs(JSPUtil.getParameter(request, prefix + "lane_hjs", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setLaneTotal(JSPUtil.getParameter(request, prefix + "lane_total", ""));
		setVslQtyTtl(JSPUtil.getParameter(request, prefix + "vsl_qty_ttl", ""));
		setEaTotal(JSPUtil.getParameter(request, prefix + "ea_total", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FleetStatusVO[]
	 */
	public FleetStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FleetStatusVO[]
	 */
	public FleetStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FleetStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coBsaW = (JSPUtil.getParameter(request, prefix	+ "co_bsa_w", length));
			String[] eaHjs = (JSPUtil.getParameter(request, prefix	+ "ea_hjs", length));
			String[] hjsBsaW = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_w", length));
			String[] chtrBsaRtoE = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_rto_e", length));
			String[] hjsBsaRtoE = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_rto_e", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlBsaW = (JSPUtil.getParameter(request, prefix	+ "ttl_bsa_w", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] coBsaE = (JSPUtil.getParameter(request, prefix	+ "co_bsa_e", length));
			String[] svcDurDys = (JSPUtil.getParameter(request, prefix	+ "svc_dur_dys", length));
			String[] hjsVslChtNm = (JSPUtil.getParameter(request, prefix	+ "hjs_vsl_cht_nm", length));
			String[] fleetStatus = (JSPUtil.getParameter(request, prefix	+ "fleet_status", length));
			String[] hjsBsaE = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_e", length));
			String[] chtrBsaRtoW = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_rto_w", length));
			String[] portRot = (JSPUtil.getParameter(request, prefix	+ "port_rot", length));
			String[] hjsVslOwnNm = (JSPUtil.getParameter(request, prefix	+ "hjs_vsl_own_nm", length));
			String[] ttlBsaE = (JSPUtil.getParameter(request, prefix	+ "ttl_bsa_e", length));
			String[] bsaType = (JSPUtil.getParameter(request, prefix	+ "bsa_type", length));
			String[] vslType = (JSPUtil.getParameter(request, prefix	+ "vsl_type", length));
			String[] vslCdCnt = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_cnt", length));
			String[] laneOthers = (JSPUtil.getParameter(request, prefix	+ "lane_others", length));
			String[] yrWk = (JSPUtil.getParameter(request, prefix	+ "yr_wk", length));
			String[] eaOthers = (JSPUtil.getParameter(request, prefix	+ "ea_others", length));
			String[] pDate = (JSPUtil.getParameter(request, prefix	+ "p_date", length));
			String[] carrierCd = (JSPUtil.getParameter(request, prefix	+ "carrier_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] hjsBsaRtoW = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_rto_w", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq", length));
			String[] laneHjs = (JSPUtil.getParameter(request, prefix	+ "lane_hjs", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] laneTotal = (JSPUtil.getParameter(request, prefix	+ "lane_total", length));
			String[] vslQtyTtl = (JSPUtil.getParameter(request, prefix	+ "vsl_qty_ttl", length));
			String[] eaTotal = (JSPUtil.getParameter(request, prefix	+ "ea_total", length));
			
			for (int i = 0; i < length; i++) {
				model = new FleetStatusVO();
				if (coBsaW[i] != null)
					model.setCoBsaW(coBsaW[i]);
				if (eaHjs[i] != null)
					model.setEaHjs(eaHjs[i]);
				if (hjsBsaW[i] != null)
					model.setHjsBsaW(hjsBsaW[i]);
				if (chtrBsaRtoE[i] != null)
					model.setChtrBsaRtoE(chtrBsaRtoE[i]);
				if (hjsBsaRtoE[i] != null)
					model.setHjsBsaRtoE(hjsBsaRtoE[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlBsaW[i] != null)
					model.setTtlBsaW(ttlBsaW[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (coBsaE[i] != null)
					model.setCoBsaE(coBsaE[i]);
				if (svcDurDys[i] != null)
					model.setSvcDurDys(svcDurDys[i]);
				if (hjsVslChtNm[i] != null)
					model.setHjsVslChtNm(hjsVslChtNm[i]);
				if (fleetStatus[i] != null)
					model.setFleetStatus(fleetStatus[i]);
				if (hjsBsaE[i] != null)
					model.setHjsBsaE(hjsBsaE[i]);
				if (chtrBsaRtoW[i] != null)
					model.setChtrBsaRtoW(chtrBsaRtoW[i]);
				if (portRot[i] != null)
					model.setPortRot(portRot[i]);
				if (hjsVslOwnNm[i] != null)
					model.setHjsVslOwnNm(hjsVslOwnNm[i]);
				if (ttlBsaE[i] != null)
					model.setTtlBsaE(ttlBsaE[i]);
				if (bsaType[i] != null)
					model.setBsaType(bsaType[i]);
				if (vslType[i] != null)
					model.setVslType(vslType[i]);
				if (vslCdCnt[i] != null)
					model.setVslCdCnt(vslCdCnt[i]);
				if (laneOthers[i] != null)
					model.setLaneOthers(laneOthers[i]);
				if (yrWk[i] != null)
					model.setYrWk(yrWk[i]);
				if (eaOthers[i] != null)
					model.setEaOthers(eaOthers[i]);
				if (pDate[i] != null)
					model.setPDate(pDate[i]);
				if (carrierCd[i] != null)
					model.setCarrierCd(carrierCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (hjsBsaRtoW[i] != null)
					model.setHjsBsaRtoW(hjsBsaRtoW[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (laneHjs[i] != null)
					model.setLaneHjs(laneHjs[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (laneTotal[i] != null)
					model.setLaneTotal(laneTotal[i]);
				if (vslQtyTtl[i] != null)
					model.setVslQtyTtl(vslQtyTtl[i]);
				if (eaTotal[i] != null)
					model.setEaTotal(eaTotal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFleetStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FleetStatusVO[]
	 */
	public FleetStatusVO[] getFleetStatusVOs(){
		FleetStatusVO[] vos = (FleetStatusVO[])models.toArray(new FleetStatusVO[models.size()]);
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
		this.coBsaW = this.coBsaW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaHjs = this.eaHjs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaW = this.hjsBsaW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaRtoE = this.chtrBsaRtoE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaRtoE = this.hjsBsaRtoE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBsaW = this.ttlBsaW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coBsaE = this.coBsaE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDurDys = this.svcDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsVslChtNm = this.hjsVslChtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fleetStatus = this.fleetStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaE = this.hjsBsaE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaRtoW = this.chtrBsaRtoW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRot = this.portRot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsVslOwnNm = this.hjsVslOwnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBsaE = this.ttlBsaE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaType = this.bsaType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslType = this.vslType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdCnt = this.vslCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneOthers = this.laneOthers .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrWk = this.yrWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaOthers = this.eaOthers .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate = this.pDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCd = this.carrierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaRtoW = this.hjsBsaRtoW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneHjs = this.laneHjs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneTotal = this.laneTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslQtyTtl = this.vslQtyTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaTotal = this.eaTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
