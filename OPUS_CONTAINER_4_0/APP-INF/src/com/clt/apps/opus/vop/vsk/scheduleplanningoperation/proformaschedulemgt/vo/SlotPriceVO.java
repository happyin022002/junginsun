/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SlotPriceVO.java
*@FileTitle : SlotPriceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.20 서창열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

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
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SlotPriceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlotPriceVO> models = new ArrayList<SlotPriceVO>();
	
	/* Column Info */
	private String n1stVslClssKnt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String sltPrcWrkYr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String n3rdVslClssKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String bnkPrc = null;
	/* Column Info */
	private String n2ndVslClssKnt = null;
	/* Column Info */
	private String n3rdVslClssCd = null;
	/* Column Info */
	private String n2ndVslClssCd = null;
	/* Column Info */
	private String n1stVslClssCd = null;
	/* Column Info */
	private String vpsEtaFmDt = null;
	/* Column Info */
	private String vpsEtaToDt = null;
	/* Column Info */
	private String ttlAvg = null;
	/* Column Info */
	private String vslCsl1 = null;
	/* Column Info */
	private String vslCsl2 = null;
	/* Column Info */
	private String vslCsl3 = null;
	/* Column Info */
	private String slotSum = null;
	/* Column Info */
	private String eventNav = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String leftHeader = null;
	/* Column Info */
	private String seaDay = null;
	/* Column Info */
	private String maneDay = null;
	/* Column Info */
	private String portDay = null;
	/* Column Info */
	private String durDay = null;
	/* Column Info */
	private String seaHrs = null;
	/* Column Info */
	private String maneHrs = null;
	/* Column Info */
	private String portHrs = null;
	/* Column Info */
	private String durHrs = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlotPriceVO() {}

	public SlotPriceVO(String ibflag, String pagerows, String n1stVslClssCd, String n1stVslClssKnt, String n2ndVslClssCd, String n2ndVslClssKnt, String n3rdVslClssCd, String n3rdVslClssKnt, String bnkPrc, String vslSlanCd, String pfSvcTpCd, String sltPrcWrkYr, String bseQtrCd, String vpsEtaFmDt, String vpsEtaToDt, String ttlAvg, String vslCsl1, String vslCsl2, String vslCsl3, String slotSum, String eventNav, String creUsrId, String creDt, String updUsrId, String updDt, String leftHeader, String seaDay, String maneDay, String portDay, String durDay, String durHrs, String seaHrs, String maneHrs, String portHrs) {
		this.n1stVslClssKnt = n1stVslClssKnt;
		this.vslSlanCd = vslSlanCd;
		this.sltPrcWrkYr = sltPrcWrkYr;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.n3rdVslClssKnt = n3rdVslClssKnt;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.bnkPrc = bnkPrc;
		this.n2ndVslClssKnt = n2ndVslClssKnt;
		this.n3rdVslClssCd = n3rdVslClssCd;
		this.n2ndVslClssCd = n2ndVslClssCd;
		this.n1stVslClssCd = n1stVslClssCd;
		this.vpsEtaFmDt = vpsEtaFmDt;
		this.vpsEtaToDt = vpsEtaToDt;
		this.ttlAvg = ttlAvg;
		this.vslCsl1 = vslCsl1;
		this.vslCsl2 = vslCsl2;
		this.vslCsl3 = vslCsl3;
		this.slotSum = slotSum;
		this.eventNav = eventNav;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.leftHeader = leftHeader;
		this.seaDay = seaDay;
		this.maneDay = maneDay;
		this.portDay = portDay;
		this.durDay = durDay;
		this.durHrs = durHrs;
		this.seaHrs = seaHrs;
		this.maneHrs = maneHrs;
		this.portHrs = portHrs;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_vsl_clss_knt", getN1stVslClssKnt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("slt_prc_wrk_yr", getSltPrcWrkYr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("n3rd_vsl_clss_knt", getN3rdVslClssKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("bnk_prc", getBnkPrc());
		this.hashColumns.put("n2nd_vsl_clss_knt", getN2ndVslClssKnt());
		this.hashColumns.put("n3rd_vsl_clss_cd", getN3rdVslClssCd());
		this.hashColumns.put("n2nd_vsl_clss_cd", getN2ndVslClssCd());
		this.hashColumns.put("n1st_vsl_clss_cd", getN1stVslClssCd());
		this.hashColumns.put("vpsEtaFmDt", getVpsEtaFmDt());
		this.hashColumns.put("vpsEtaToDt", getVpsEtaToDt());
		this.hashColumns.put("ttl_avg", getTtlAvg());
		this.hashColumns.put("vsl_csl1", getVslCsl1());
		this.hashColumns.put("vsl_csl2", getVslCsl2());
		this.hashColumns.put("vsl_csl3", getVslCsl3());
		this.hashColumns.put("slot_sum", getSlotSum());
		this.hashColumns.put("eventNav", getEventNav());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("left_header", getLeftHeader());
		this.hashColumns.put("sea_day", getSeaDay());
		this.hashColumns.put("mane_day", getManeDay());
		this.hashColumns.put("port_day", getPortDay());
		this.hashColumns.put("dur_day", getDurDay());
		this.hashColumns.put("sea_hrs", getSeaHrs());
		this.hashColumns.put("mane_hrs", getManeHrs());
		this.hashColumns.put("port_hrs", getPortHrs());
		this.hashColumns.put("dur_hrs", getDurHrs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_vsl_clss_knt", "n1stVslClssKnt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("slt_prc_wrk_yr", "sltPrcWrkYr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("n3rd_vsl_clss_knt", "n3rdVslClssKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("bnk_prc", "bnkPrc");
		this.hashFields.put("n2nd_vsl_clss_knt", "n2ndVslClssKnt");
		this.hashFields.put("n3rd_vsl_clss_cd", "n3rdVslClssCd");
		this.hashFields.put("n2nd_vsl_clss_cd", "n2ndVslClssCd");
		this.hashFields.put("n1st_vsl_clss_cd", "n1stVslClssCd");
		this.hashFields.put("vpsEtaFmDt", "vpsEtaFmDt");
		this.hashFields.put("vpsEtaToDt", "vpsEtaToDt");
		
		this.hashFields.put("ttl_avg", "ttlAvg");
		this.hashFields.put("vsl_csl1", "vslCsl1");
		this.hashFields.put("vsl_csl2", "vslCsl2");
		this.hashFields.put("vsl_csl3", "vslCsl3");
		this.hashFields.put("slot_sum", "slotSum");
		this.hashFields.put("eventNav", "eventNav");
		
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("left_header", "leftHeader");
		
		this.hashFields.put("sea_day", "seaDay");
		this.hashFields.put("mane_day", "maneDay");
		this.hashFields.put("port_day", "portDay");
		this.hashFields.put("dur_day", "durDay");
		
		this.hashFields.put("sea_hrs", "seaHrs");
		this.hashFields.put("mane_hrs", "maneHrs");
		this.hashFields.put("port_hrs", "portHrs");
		this.hashFields.put("dur_hrs", "durHrs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssKnt
	 */
	public String getN1stVslClssKnt() {
		return this.n1stVslClssKnt;
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
	 * @return sltPrcWrkYr
	 */
	public String getSltPrcWrkYr() {
		return this.sltPrcWrkYr;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslClssKnt
	 */
	public String getN3rdVslClssKnt() {
		return this.n3rdVslClssKnt;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return bnkPrc
	 */
	public String getBnkPrc() {
		return this.bnkPrc;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssKnt
	 */
	public String getN2ndVslClssKnt() {
		return this.n2ndVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslClssCd
	 */
	public String getN3rdVslClssCd() {
		return this.n3rdVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssCd
	 */
	public String getN2ndVslClssCd() {
		return this.n2ndVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getN1stVslClssCd() {
		return this.n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVpsEtaFmDt() {
		return this.vpsEtaFmDt;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVpsEtaToDt() {
		return this.vpsEtaToDt;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getTtlAvg() {
		return this.ttlAvg;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVslCsl1() {
		return this.vslCsl1;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVslCsl2() {
		return this.vslCsl2;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getVslCsl3() {
		return this.vslCsl3;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getSlotSum() {
		return this.slotSum;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getEventNav() {
		return this.eventNav;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return leftHeader
	 */
	public String getLeftHeader() {
		return this.leftHeader;
	}
	
	/**
	 * Column Info
	 * @return seaDay
	 */
	public String getSeaDay() {
		return this.seaDay;
	}
	
	/**
	 * Column Info
	 * @return maneDay
	 */
	public String getManeDay() {
		return this.maneDay;
	}
	
	/**
	 * Column Info
	 * @return portDay
	 */
	public String getPortDay() {
		return this.portDay;
	}
	
	/**
	 * Column Info
	 * @return durDay
	 */
	public String getDurDay() {
		return this.durDay;
	}
	
	/**
	 * Column Info
	 * @return durHrs
	 */
	public String getDurHrs() {
		return this.durHrs;
	}
	
	/**
	 * Column Info
	 * @return seaHrs
	 */
	public String getSeaHrs() {
		return this.seaHrs;
	}
	
	/**
	 * Column Info
	 * @return maneHrs
	 */
	public String getManeHrs() {
		return this.maneHrs;
	}
	
	/**
	 * Column Info
	 * @return portHrs
	 */
	public String getPortHrs() {
		return this.portHrs;
	}
	

	/**
	 * Column Info
	 * @param n1stVslClssKnt
	 */
	public void setN1stVslClssKnt(String n1stVslClssKnt) {
		this.n1stVslClssKnt = n1stVslClssKnt;
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
	 * @param sltPrcWrkYr
	 */
	public void setSltPrcWrkYr(String sltPrcWrkYr) {
		this.sltPrcWrkYr = sltPrcWrkYr;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslClssKnt
	 */
	public void setN3rdVslClssKnt(String n3rdVslClssKnt) {
		this.n3rdVslClssKnt = n3rdVslClssKnt;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param bnkPrc
	 */
	public void setBnkPrc(String bnkPrc) {
		this.bnkPrc = bnkPrc;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssKnt
	 */
	public void setN2ndVslClssKnt(String n2ndVslClssKnt) {
		this.n2ndVslClssKnt = n2ndVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslClssCd
	 */
	public void setN3rdVslClssCd(String n3rdVslClssCd) {
		this.n3rdVslClssCd = n3rdVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssCd
	 */
	public void setN2ndVslClssCd(String n2ndVslClssCd) {
		this.n2ndVslClssCd = n2ndVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setN1stVslClssCd(String n1stVslClssCd) {
		this.n1stVslClssCd = n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVpsEtaFmDt(String vpsEtaFmDt) {
		this.vpsEtaFmDt = vpsEtaFmDt;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVpsEtaToDt(String vpsEtaToDt) {
		this.vpsEtaToDt = vpsEtaToDt;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setTtlAvg(String ttlAvg) {
		this.ttlAvg = ttlAvg;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVslCsl1(String vslCsl1) {
		this.vslCsl1 = vslCsl1;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVslCsl2(String vslCsl2) {
		this.vslCsl2 = vslCsl2;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setVslCsl3(String vslCsl3) {
		this.vslCsl3 = vslCsl3;
	}
	
	/** 
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setSlotSum(String slotSum) {
		this.slotSum = slotSum;
	}
	
	/** 
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setEventNav(String eventNav) {
		this.eventNav = eventNav;
	}
	
	/** 
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/** 
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/** 
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/** 
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/** 
	 * Column Info
	 * @param leftHeader
	 */
	public void setLeftHeader(String leftHeader) {
		this.leftHeader = leftHeader;
	}
	
	/** 
	 * Column Info
	 * @param seaDay
	 */
	public void setSeaDay(String seaDay) {
		this.seaDay = seaDay;
	}
	
	/** 
	 * Column Info
	 * @param maneDay
	 */
	public void setManeDay(String maneDay) {
		this.maneDay = maneDay;
	}
	
	/** 
	 * Column Info
	 * @param portDay
	 */
	public void setPortDay(String portDay) {
		this.portDay = portDay;
	}
	
	/** 
	 * Column Info
	 * @param durDay
	 */
	public void setDurDay(String durDay) {
		this.durDay = durDay;
	}
	
	/** 
	 * Column Info
	 * @param durHrs
	 */
	public void setDurHrs(String durHrs) {
		this.durHrs = durHrs;
	}
	
	/** 
	 * Column Info
	 * @param seaHrs
	 */
	public void setSeaHrs(String seaHrs) {
		this.seaHrs = seaHrs;
	}
	
	/** 
	 * Column Info
	 * @param maneHrs
	 */
	public void setManeHrs(String maneHrs) {
		this.maneHrs = maneHrs;
	}
	
	/** 
	 * Column Info
	 * @param portHrs
	 */
	public void setPortHrs(String portHrs) {
		this.portHrs = portHrs;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN1stVslClssKnt(JSPUtil.getParameter(request, "n1st_vsl_clss_knt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setSltPrcWrkYr(JSPUtil.getParameter(request, "slt_prc_wrk_yr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setN3rdVslClssKnt(JSPUtil.getParameter(request, "n3rd_vsl_clss_knt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setBnkPrc(JSPUtil.getParameter(request, "bnk_prc", ""));
		setN2ndVslClssKnt(JSPUtil.getParameter(request, "n2nd_vsl_clss_knt", ""));
		setN3rdVslClssCd(JSPUtil.getParameter(request, "n3rd_vsl_clss_cd", ""));
		setN2ndVslClssCd(JSPUtil.getParameter(request, "n2nd_vsl_clss_cd", ""));
		setN1stVslClssCd(JSPUtil.getParameter(request, "n1st_vsl_clss_cd", ""));
		setVpsEtaFmDt(JSPUtil.getParameter(request, "vpsEtaFmDt", ""));
		setVpsEtaToDt(JSPUtil.getParameter(request, "vpsEtaToDt", ""));
		
		setTtlAvg(JSPUtil.getParameter(request, "ttl_avg", ""));
		setVslCsl1(JSPUtil.getParameter(request, "vsl_csl1", ""));
		setVslCsl2(JSPUtil.getParameter(request, "vsl_csl2", ""));
		setVslCsl3(JSPUtil.getParameter(request, "vsl_csl3", ""));
		setSlotSum(JSPUtil.getParameter(request, "slot_sum", ""));
		setEventNav(JSPUtil.getParameter(request, "eventNav", ""));
		
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLeftHeader(JSPUtil.getParameter(request, "left_header", ""));
		
		setSeaDay(JSPUtil.getParameter(request, "sea_day", ""));
		setManeDay(JSPUtil.getParameter(request, "mane_day", ""));
		setPortDay(JSPUtil.getParameter(request, "port_day", ""));
		setDurDay(JSPUtil.getParameter(request, "dur_day", ""));
		
		setSeaHrs(JSPUtil.getParameter(request, "sea_hrs", ""));
		setManeHrs(JSPUtil.getParameter(request, "mane_hrs", ""));
		setPortHrs(JSPUtil.getParameter(request, "port_hrs", ""));
		setDurHrs(JSPUtil.getParameter(request, "dur_hrs", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlotPriceVO[]
	 */
	public SlotPriceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlotPriceVO[]
	 */
	public SlotPriceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlotPriceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n1stVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_knt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] sltPrcWrkYr = (JSPUtil.getParameter(request, prefix	+ "slt_prc_wrk_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] n3rdVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] bnkPrc = (JSPUtil.getParameter(request, prefix	+ "bnk_prc", length));
			String[] n2ndVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_knt", length));
			String[] n3rdVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_cd", length));
			String[] n2ndVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_cd", length));
			String[] n1stVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_cd", length));
			String[] vpsEtaFmDt = (JSPUtil.getParameter(request, prefix	+ "vpsEtaFmDt", length));
			String[] vpsEtaToDt = (JSPUtil.getParameter(request, prefix	+ "vpsEtaToDt", length));
			
			String[] ttlAvg = (JSPUtil.getParameter(request, prefix	+ "ttl_avg", length));
			String[] vslCsl1 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl1", length));
			String[] vslCsl2 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl2", length));
			String[] vslCsl3 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl3", length));
			String[] slotSum = (JSPUtil.getParameter(request, prefix	+ "slot_sum", length));
			String[] eventNav = (JSPUtil.getParameter(request, prefix	+ "eventNav", length));
			
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] leftHeader = (JSPUtil.getParameter(request, prefix	+ "left_header", length));
			
			String[] seaDay = (JSPUtil.getParameter(request, prefix	+ "sea_day", length));
			String[] maneDay = (JSPUtil.getParameter(request, prefix	+ "mane_day", length));
			String[] portDay = (JSPUtil.getParameter(request, prefix	+ "port_day", length));
			String[] durDay = (JSPUtil.getParameter(request, prefix	+ "dur_day", length));
			
			String[] seaHrs = (JSPUtil.getParameter(request, prefix	+ "sea_hrs", length));
			String[] maneHrs = (JSPUtil.getParameter(request, prefix	+ "mane_hrs", length));
			String[] portHrs = (JSPUtil.getParameter(request, prefix	+ "port_hrs", length));
			String[] durHrs = (JSPUtil.getParameter(request, prefix	+ "dur_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new SlotPriceVO();
				if (n1stVslClssKnt[i] != null)
					model.setN1stVslClssKnt(n1stVslClssKnt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (sltPrcWrkYr[i] != null)
					model.setSltPrcWrkYr(sltPrcWrkYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (n3rdVslClssKnt[i] != null)
					model.setN3rdVslClssKnt(n3rdVslClssKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (bnkPrc[i] != null)
					model.setBnkPrc(bnkPrc[i]);
				if (n2ndVslClssKnt[i] != null)
					model.setN2ndVslClssKnt(n2ndVslClssKnt[i]);
				if (n3rdVslClssCd[i] != null)
					model.setN3rdVslClssCd(n3rdVslClssCd[i]);
				if (n2ndVslClssCd[i] != null)
					model.setN2ndVslClssCd(n2ndVslClssCd[i]);
				if (n1stVslClssCd[i] != null)
					model.setN1stVslClssCd(n1stVslClssCd[i]);
				if (vpsEtaFmDt[i] != null)
					model.setVpsEtaFmDt(vpsEtaFmDt[i]);
				if (vpsEtaToDt[i] != null)
					model.setVpsEtaToDt(vpsEtaToDt[i]);
				
				if (ttlAvg[i] != null)
					model.setTtlAvg(ttlAvg[i]);
				if (vslCsl1[i] != null)
					model.setVslCsl1(vslCsl1[i]);
				if (vslCsl2[i] != null)
					model.setVslCsl2(vslCsl2[i]);
				if (vslCsl3[i] != null)
					model.setVslCsl3(vslCsl3[i]);
				if (slotSum[i] != null)
					model.setSlotSum(slotSum[i]);
				if (eventNav[i] != null)
					model.setEventNav(eventNav[i]);
				
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (leftHeader[i] != null)
					model.setLeftHeader(leftHeader[i]);
				
				if (seaDay[i] != null)
					model.setSeaDay(seaDay[i]);
				if (maneDay[i] != null)
					model.setManeDay(maneDay[i]);
				if (portDay[i] != null)
					model.setPortDay(portDay[i]);
				if (durDay[i] != null)
					model.setDurDay(durDay[i]);
				
				if (seaHrs[i] != null)
					model.setSeaHrs(seaHrs[i]);
				if (maneHrs[i] != null)
					model.setManeHrs(maneHrs[i]);
				if (portHrs[i] != null)
					model.setPortHrs(portHrs[i]);
				if (durHrs[i] != null)
					model.setDurHrs(durHrs[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlotPriceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlotPriceVO[]
	 */
	public SlotPriceVO[] getSlotPriceVOs(){
		SlotPriceVO[] vos = (SlotPriceVO[])models.toArray(new SlotPriceVO[models.size()]);
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
		this.n1stVslClssKnt = this.n1stVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcWrkYr = this.sltPrcWrkYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssKnt = this.n3rdVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkPrc = this.bnkPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssKnt = this.n2ndVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssCd = this.n3rdVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssCd = this.n2ndVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssCd = this.n1stVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaFmDt = this.vpsEtaFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaToDt  = this.vpsEtaToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.ttlAvg  = this.ttlAvg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl1  = this.vslCsl1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl2  = this.vslCsl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl3  = this.vslCsl3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slotSum  = this.slotSum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventNav  = this.eventNav.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.creUsrId  = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt  = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId  = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt  = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leftHeader  = this.leftHeader.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.seaDay  = this.seaDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maneDay  = this.maneDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDay  = this.portDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durDay  = this.durDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.seaHrs  = this.seaHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maneHrs  = this.maneHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portHrs  = this.portHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durHrs  = this.durHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
