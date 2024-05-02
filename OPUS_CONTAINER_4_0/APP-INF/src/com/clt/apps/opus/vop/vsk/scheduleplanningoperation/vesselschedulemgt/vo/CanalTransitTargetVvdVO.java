/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalTransitTargetVvdVO.java
*@FileTitle : CanalTransitTargetVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.01.06 유혁 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTransitTargetVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTransitTargetVvdVO> models = new ArrayList<CanalTransitTargetVvdVO>();
	
	/* Column Info */
	private String startDate = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String detail = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String bayCal = null;
	/* Column Info */
	private String bkgSts = null;
	/* Column Info */
	private String scgCarRatio = null;
	/* Column Info */
	private String scgLmtOptSpd = null;
	/* Column Info */
	private String endDate = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String bayLoc = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scgCarTeu = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String svcProvider = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String scgLmtOptRatio = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String scgCarPortCd = null;
	/* Column Info */
	private String surcharge = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String scgLmtActRatio = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String scgCarTier = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String scgLmtActSpd = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTransitTargetVvdVO() {}

	public CanalTransitTargetVvdVO(String ibflag, String pagerows, String startDate, String endDate, String portCd, String svcProvider, String surcharge, String vndrSeq, String vpsPortCd, String clptSeq, String ydCd, String bayLoc, String bayCal, String bound, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String bkgSts, String scgLmtOptSpd, String scgLmtOptRatio, String scgLmtActSpd, String scgLmtActRatio, String scgCarPortCd, String scgCarRatio, String scgCarTier, String scgCarTeu, String detail) {
		this.startDate = startDate;
		this.vslCd = vslCd;
		this.detail = detail;
		this.vpsEtbDt = vpsEtbDt;
		this.bayCal = bayCal;
		this.bkgSts = bkgSts;
		this.scgCarRatio = scgCarRatio;
		this.scgLmtOptSpd = scgLmtOptSpd;
		this.endDate = endDate;
		this.vslSlanCd = vslSlanCd;
		this.bayLoc = bayLoc;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.scgCarTeu = scgCarTeu;
		this.portCd = portCd;
		this.svcProvider = svcProvider;
		this.vpsEtdDt = vpsEtdDt;
		this.scgLmtOptRatio = scgLmtOptRatio;
		this.skdVoyNo = skdVoyNo;
		this.scgCarPortCd = scgCarPortCd;
		this.surcharge = surcharge;
		this.skdDirCd = skdDirCd;
		this.scgLmtActRatio = scgLmtActRatio;
		this.vvd = vvd;
		this.scgCarTier = scgCarTier;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.scgLmtActSpd = scgLmtActSpd;
		this.bound = bound;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("start_date", getStartDate());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("detail", getDetail());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("bay_cal", getBayCal());
		this.hashColumns.put("bkg_sts", getBkgSts());
		this.hashColumns.put("scg_car_ratio", getScgCarRatio());
		this.hashColumns.put("scg_lmt_opt_spd", getScgLmtOptSpd());
		this.hashColumns.put("end_date", getEndDate());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("bay_loc", getBayLoc());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scg_car_teu", getScgCarTeu());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("svc_provider", getSvcProvider());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("scg_lmt_opt_ratio", getScgLmtOptRatio());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("scg_car_port_cd", getScgCarPortCd());
		this.hashColumns.put("surcharge", getSurcharge());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("scg_lmt_act_ratio", getScgLmtActRatio());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("scg_car_tier", getScgCarTier());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("scg_lmt_act_spd", getScgLmtActSpd());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("start_date", "startDate");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("detail", "detail");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("bay_cal", "bayCal");
		this.hashFields.put("bkg_sts", "bkgSts");
		this.hashFields.put("scg_car_ratio", "scgCarRatio");
		this.hashFields.put("scg_lmt_opt_spd", "scgLmtOptSpd");
		this.hashFields.put("end_date", "endDate");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("bay_loc", "bayLoc");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scg_car_teu", "scgCarTeu");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("svc_provider", "svcProvider");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("scg_lmt_opt_ratio", "scgLmtOptRatio");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("scg_car_port_cd", "scgCarPortCd");
		this.hashFields.put("surcharge", "surcharge");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("scg_lmt_act_ratio", "scgLmtActRatio");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("scg_car_tier", "scgCarTier");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("scg_lmt_act_spd", "scgLmtActSpd");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return startDate
	 */
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return detail
	 */
	public String getDetail() {
		return this.detail;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return bayCal
	 */
	public String getBayCal() {
		return this.bayCal;
	}
	
	/**
	 * Column Info
	 * @return bkgSts
	 */
	public String getBkgSts() {
		return this.bkgSts;
	}
	
	/**
	 * Column Info
	 * @return scgCarRatio
	 */
	public String getScgCarRatio() {
		return this.scgCarRatio;
	}
	
	/**
	 * Column Info
	 * @return scgLmtOptSpd
	 */
	public String getScgLmtOptSpd() {
		return this.scgLmtOptSpd;
	}
	
	/**
	 * Column Info
	 * @return endDate
	 */
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return bayLoc
	 */
	public String getBayLoc() {
		return this.bayLoc;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return scgCarTeu
	 */
	public String getScgCarTeu() {
		return this.scgCarTeu;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return svcProvider
	 */
	public String getSvcProvider() {
		return this.svcProvider;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return scgLmtOptRatio
	 */
	public String getScgLmtOptRatio() {
		return this.scgLmtOptRatio;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return scgCarPortCd
	 */
	public String getScgCarPortCd() {
		return this.scgCarPortCd;
	}
	
	/**
	 * Column Info
	 * @return surcharge
	 */
	public String getSurcharge() {
		return this.surcharge;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return scgLmtActRatio
	 */
	public String getScgLmtActRatio() {
		return this.scgLmtActRatio;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return scgCarTier
	 */
	public String getScgCarTier() {
		return this.scgCarTier;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return scgLmtActSpd
	 */
	public String getScgLmtActSpd() {
		return this.scgLmtActSpd;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	

	/**
	 * Column Info
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param bayCal
	 */
	public void setBayCal(String bayCal) {
		this.bayCal = bayCal;
	}
	
	/**
	 * Column Info
	 * @param bkgSts
	 */
	public void setBkgSts(String bkgSts) {
		this.bkgSts = bkgSts;
	}
	
	/**
	 * Column Info
	 * @param scgCarRatio
	 */
	public void setScgCarRatio(String scgCarRatio) {
		this.scgCarRatio = scgCarRatio;
	}
	
	/**
	 * Column Info
	 * @param scgLmtOptSpd
	 */
	public void setScgLmtOptSpd(String scgLmtOptSpd) {
		this.scgLmtOptSpd = scgLmtOptSpd;
	}
	
	/**
	 * Column Info
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param bayLoc
	 */
	public void setBayLoc(String bayLoc) {
		this.bayLoc = bayLoc;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param scgCarTeu
	 */
	public void setScgCarTeu(String scgCarTeu) {
		this.scgCarTeu = scgCarTeu;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param svcProvider
	 */
	public void setSvcProvider(String svcProvider) {
		this.svcProvider = svcProvider;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param scgLmtOptRatio
	 */
	public void setScgLmtOptRatio(String scgLmtOptRatio) {
		this.scgLmtOptRatio = scgLmtOptRatio;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param scgCarPortCd
	 */
	public void setScgCarPortCd(String scgCarPortCd) {
		this.scgCarPortCd = scgCarPortCd;
	}
	
	/**
	 * Column Info
	 * @param surcharge
	 */
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param scgLmtActRatio
	 */
	public void setScgLmtActRatio(String scgLmtActRatio) {
		this.scgLmtActRatio = scgLmtActRatio;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param scgCarTier
	 */
	public void setScgCarTier(String scgCarTier) {
		this.scgCarTier = scgCarTier;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param scgLmtActSpd
	 */
	public void setScgLmtActSpd(String scgLmtActSpd) {
		this.scgLmtActSpd = scgLmtActSpd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
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
		setStartDate(JSPUtil.getParameter(request, prefix + "start_date", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDetail(JSPUtil.getParameter(request, prefix + "detail", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setBayCal(JSPUtil.getParameter(request, prefix + "bay_cal", ""));
		setBkgSts(JSPUtil.getParameter(request, prefix + "bkg_sts", ""));
		setScgCarRatio(JSPUtil.getParameter(request, prefix + "scg_car_ratio", ""));
		setScgLmtOptSpd(JSPUtil.getParameter(request, prefix + "scg_lmt_opt_spd", ""));
		setEndDate(JSPUtil.getParameter(request, prefix + "end_date", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setBayLoc(JSPUtil.getParameter(request, prefix + "bay_loc", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScgCarTeu(JSPUtil.getParameter(request, prefix + "scg_car_teu", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSvcProvider(JSPUtil.getParameter(request, prefix + "svc_provider", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setScgLmtOptRatio(JSPUtil.getParameter(request, prefix + "scg_lmt_opt_ratio", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setScgCarPortCd(JSPUtil.getParameter(request, prefix + "scg_car_port_cd", ""));
		setSurcharge(JSPUtil.getParameter(request, prefix + "surcharge", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setScgLmtActRatio(JSPUtil.getParameter(request, prefix + "scg_lmt_act_ratio", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setScgCarTier(JSPUtil.getParameter(request, prefix + "scg_car_tier", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setScgLmtActSpd(JSPUtil.getParameter(request, prefix + "scg_lmt_act_spd", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTransitTargetVvdVO[]
	 */
	public CanalTransitTargetVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTransitTargetVvdVO[]
	 */
	public CanalTransitTargetVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTransitTargetVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] startDate = (JSPUtil.getParameter(request, prefix	+ "start_date", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] detail = (JSPUtil.getParameter(request, prefix	+ "detail", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] bayCal = (JSPUtil.getParameter(request, prefix	+ "bay_cal", length));
			String[] bkgSts = (JSPUtil.getParameter(request, prefix	+ "bkg_sts", length));
			String[] scgCarRatio = (JSPUtil.getParameter(request, prefix	+ "scg_car_ratio", length));
			String[] scgLmtOptSpd = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_opt_spd", length));
			String[] endDate = (JSPUtil.getParameter(request, prefix	+ "end_date", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] bayLoc = (JSPUtil.getParameter(request, prefix	+ "bay_loc", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scgCarTeu = (JSPUtil.getParameter(request, prefix	+ "scg_car_teu", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] svcProvider = (JSPUtil.getParameter(request, prefix	+ "svc_provider", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] scgLmtOptRatio = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_opt_ratio", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] scgCarPortCd = (JSPUtil.getParameter(request, prefix	+ "scg_car_port_cd", length));
			String[] surcharge = (JSPUtil.getParameter(request, prefix	+ "surcharge", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] scgLmtActRatio = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_act_ratio", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] scgCarTier = (JSPUtil.getParameter(request, prefix	+ "scg_car_tier", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] scgLmtActSpd = (JSPUtil.getParameter(request, prefix	+ "scg_lmt_act_spd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTransitTargetVvdVO();
				if (startDate[i] != null)
					model.setStartDate(startDate[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (detail[i] != null)
					model.setDetail(detail[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (bayCal[i] != null)
					model.setBayCal(bayCal[i]);
				if (bkgSts[i] != null)
					model.setBkgSts(bkgSts[i]);
				if (scgCarRatio[i] != null)
					model.setScgCarRatio(scgCarRatio[i]);
				if (scgLmtOptSpd[i] != null)
					model.setScgLmtOptSpd(scgLmtOptSpd[i]);
				if (endDate[i] != null)
					model.setEndDate(endDate[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (bayLoc[i] != null)
					model.setBayLoc(bayLoc[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scgCarTeu[i] != null)
					model.setScgCarTeu(scgCarTeu[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (svcProvider[i] != null)
					model.setSvcProvider(svcProvider[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (scgLmtOptRatio[i] != null)
					model.setScgLmtOptRatio(scgLmtOptRatio[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (scgCarPortCd[i] != null)
					model.setScgCarPortCd(scgCarPortCd[i]);
				if (surcharge[i] != null)
					model.setSurcharge(surcharge[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (scgLmtActRatio[i] != null)
					model.setScgLmtActRatio(scgLmtActRatio[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (scgCarTier[i] != null)
					model.setScgCarTier(scgCarTier[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (scgLmtActSpd[i] != null)
					model.setScgLmtActSpd(scgLmtActSpd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTransitTargetVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTransitTargetVvdVO[]
	 */
	public CanalTransitTargetVvdVO[] getCanalTransitTargetVvdVOs(){
		CanalTransitTargetVvdVO[] vos = (CanalTransitTargetVvdVO[])models.toArray(new CanalTransitTargetVvdVO[models.size()]);
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
		this.startDate = this.startDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail = this.detail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayCal = this.bayCal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSts = this.bkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarRatio = this.scgCarRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtOptSpd = this.scgLmtOptSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate = this.endDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayLoc = this.bayLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarTeu = this.scgCarTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvider = this.svcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtOptRatio = this.scgLmtOptRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarPortCd = this.scgCarPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surcharge = this.surcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtActRatio = this.scgLmtActRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgCarTier = this.scgCarTier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgLmtActSpd = this.scgLmtActSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
