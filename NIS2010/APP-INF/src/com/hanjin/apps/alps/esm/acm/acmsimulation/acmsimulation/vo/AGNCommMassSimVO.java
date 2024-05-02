/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AGNCommMassSimVO.java
*@FileTitle : AGNCommMassSimVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.27  
* 1.0 Creation
* 
* 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo;

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

public class AGNCommMassSimVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGNCommMassSimVO> models = new ArrayList<AGNCommMassSimVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String clcRmk = null;
	/* Column Info */
	private String simAgmtSmlNo = null;
	/* Column Info */
	private String actAgmtSmlNo = null;
	/* Column Info */
	private String simNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String bkgDateTo = null;
	/* Column Info */
	private String agmtDiv = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String saArrDtFm = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String saArrDtTo = null;
	/* Column Info */
	private String simAgmtNo = null;
	/* Column Info */
	private String agmtNo2 = null;
	/* Column Info */
	private String agmtNo1 = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String portDiv = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvdDiv = null;
	/* Column Info */
	private String routeDiv = null;
	/* Column Info */
	private String ttlBkg = null;
	/* Column Info */
	private String bkgDateFm = null;
	/* Column Info */
	private String ofcDiv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AGNCommMassSimVO() {}

	public AGNCommMassSimVO(String ibflag, String pagerows, String dateFm, String acTpCd, String agmtNo2, String agmtNo1, String dateTo, String clcRmk, String ioBndCd, String portDiv, String agnCd, String ofcCd, String agmtDiv, String locCd, String vvdCd, String usrId, String dateDiv, String vvdDiv, String routeDiv, String acStsCd, String ttlBkg, String ofcDiv, String simNo, String bkgNo, String saArrDtFm, String saArrDtTo, String agnAgmtNo, String bkgDateFm, String bkgDateTo, String simAgmtNo, String actAgmtSmlNo, String simAgmtSmlNo) {
		this.dateFm = dateFm;
		this.clcRmk = clcRmk;
		this.simAgmtSmlNo = simAgmtSmlNo;
		this.actAgmtSmlNo = actAgmtSmlNo;
		this.simNo = simNo;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.bkgDateTo = bkgDateTo;
		this.agmtDiv = agmtDiv;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.saArrDtFm = saArrDtFm;
		this.dateDiv = dateDiv;
		this.acStsCd = acStsCd;
		this.acTpCd = acTpCd;
		this.saArrDtTo = saArrDtTo;
		this.simAgmtNo = simAgmtNo;
		this.agmtNo2 = agmtNo2;
		this.agmtNo1 = agmtNo1;
		this.dateTo = dateTo;
		this.ioBndCd = ioBndCd;
		this.portDiv = portDiv;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.vvdDiv = vvdDiv;
		this.routeDiv = routeDiv;
		this.ttlBkg = ttlBkg;
		this.bkgDateFm = bkgDateFm;
		this.ofcDiv = ofcDiv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("clc_rmk", getClcRmk());
		this.hashColumns.put("sim_agmt_sml_no", getSimAgmtSmlNo());
		this.hashColumns.put("act_agmt_sml_no", getActAgmtSmlNo());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("bkg_date_to", getBkgDateTo());
		this.hashColumns.put("agmt_div", getAgmtDiv());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sa_arr_dt_fm", getSaArrDtFm());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("sa_arr_dt_to", getSaArrDtTo());
		this.hashColumns.put("sim_agmt_no", getSimAgmtNo());
		this.hashColumns.put("agmt_no2", getAgmtNo2());
		this.hashColumns.put("agmt_no1", getAgmtNo1());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("port_div", getPortDiv());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd_div", getVvdDiv());
		this.hashColumns.put("route_div", getRouteDiv());
		this.hashColumns.put("ttl_bkg", getTtlBkg());
		this.hashColumns.put("bkg_date_fm", getBkgDateFm());
		this.hashColumns.put("ofc_div", getOfcDiv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("clc_rmk", "clcRmk");
		this.hashFields.put("sim_agmt_sml_no", "simAgmtSmlNo");
		this.hashFields.put("act_agmt_sml_no", "actAgmtSmlNo");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("bkg_date_to", "bkgDateTo");
		this.hashFields.put("agmt_div", "agmtDiv");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sa_arr_dt_fm", "saArrDtFm");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("sa_arr_dt_to", "saArrDtTo");
		this.hashFields.put("sim_agmt_no", "simAgmtNo");
		this.hashFields.put("agmt_no2", "agmtNo2");
		this.hashFields.put("agmt_no1", "agmtNo1");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("port_div", "portDiv");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd_div", "vvdDiv");
		this.hashFields.put("route_div", "routeDiv");
		this.hashFields.put("ttl_bkg", "ttlBkg");
		this.hashFields.put("bkg_date_fm", "bkgDateFm");
		this.hashFields.put("ofc_div", "ofcDiv");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}
	
	/**
	 * Column Info
	 * @return clcRmk
	 */
	public String getClcRmk() {
		return this.clcRmk;
	}
	
	/**
	 * Column Info
	 * @return simAgmtSmlNo
	 */
	public String getSimAgmtSmlNo() {
		return this.simAgmtSmlNo;
	}
	
	/**
	 * Column Info
	 * @return actAgmtSmlNo
	 */
	public String getActAgmtSmlNo() {
		return this.actAgmtSmlNo;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return bkgDateTo
	 */
	public String getBkgDateTo() {
		return this.bkgDateTo;
	}
	
	/**
	 * Column Info
	 * @return agmtDiv
	 */
	public String getAgmtDiv() {
		return this.agmtDiv;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return saArrDtFm
	 */
	public String getSaArrDtFm() {
		return this.saArrDtFm;
	}
	
	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}
	
	/**
	 * Column Info
	 * @return acStsCd
	 */
	public String getAcStsCd() {
		return this.acStsCd;
	}
	
	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}
	
	/**
	 * Column Info
	 * @return saArrDtTo
	 */
	public String getSaArrDtTo() {
		return this.saArrDtTo;
	}
	
	/**
	 * Column Info
	 * @return simAgmtNo
	 */
	public String getSimAgmtNo() {
		return this.simAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return agmtNo2
	 */
	public String getAgmtNo2() {
		return this.agmtNo2;
	}
	
	/**
	 * Column Info
	 * @return agmtNo1
	 */
	public String getAgmtNo1() {
		return this.agmtNo1;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return portDiv
	 */
	public String getPortDiv() {
		return this.portDiv;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return vvdDiv
	 */
	public String getVvdDiv() {
		return this.vvdDiv;
	}
	
	/**
	 * Column Info
	 * @return routeDiv
	 */
	public String getRouteDiv() {
		return this.routeDiv;
	}
	
	/**
	 * Column Info
	 * @return ttlBkg
	 */
	public String getTtlBkg() {
		return this.ttlBkg;
	}
	
	/**
	 * Column Info
	 * @return bkgDateFm
	 */
	public String getBkgDateFm() {
		return this.bkgDateFm;
	}
	
	/**
	 * Column Info
	 * @return ofcDiv
	 */
	public String getOfcDiv() {
		return this.ofcDiv;
	}
	

	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}
	
	/**
	 * Column Info
	 * @param clcRmk
	 */
	public void setClcRmk(String clcRmk) {
		this.clcRmk = clcRmk;
	}
	
	/**
	 * Column Info
	 * @param simAgmtSmlNo
	 */
	public void setSimAgmtSmlNo(String simAgmtSmlNo) {
		this.simAgmtSmlNo = simAgmtSmlNo;
	}
	
	/**
	 * Column Info
	 * @param actAgmtSmlNo
	 */
	public void setActAgmtSmlNo(String actAgmtSmlNo) {
		this.actAgmtSmlNo = actAgmtSmlNo;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param bkgDateTo
	 */
	public void setBkgDateTo(String bkgDateTo) {
		this.bkgDateTo = bkgDateTo;
	}
	
	/**
	 * Column Info
	 * @param agmtDiv
	 */
	public void setAgmtDiv(String agmtDiv) {
		this.agmtDiv = agmtDiv;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param saArrDtFm
	 */
	public void setSaArrDtFm(String saArrDtFm) {
		this.saArrDtFm = saArrDtFm;
	}
	
	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}
	
	/**
	 * Column Info
	 * @param acStsCd
	 */
	public void setAcStsCd(String acStsCd) {
		this.acStsCd = acStsCd;
	}
	
	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}
	
	/**
	 * Column Info
	 * @param saArrDtTo
	 */
	public void setSaArrDtTo(String saArrDtTo) {
		this.saArrDtTo = saArrDtTo;
	}
	
	/**
	 * Column Info
	 * @param simAgmtNo
	 */
	public void setSimAgmtNo(String simAgmtNo) {
		this.simAgmtNo = simAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param agmtNo2
	 */
	public void setAgmtNo2(String agmtNo2) {
		this.agmtNo2 = agmtNo2;
	}
	
	/**
	 * Column Info
	 * @param agmtNo1
	 */
	public void setAgmtNo1(String agmtNo1) {
		this.agmtNo1 = agmtNo1;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param portDiv
	 */
	public void setPortDiv(String portDiv) {
		this.portDiv = portDiv;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param vvdDiv
	 */
	public void setVvdDiv(String vvdDiv) {
		this.vvdDiv = vvdDiv;
	}
	
	/**
	 * Column Info
	 * @param routeDiv
	 */
	public void setRouteDiv(String routeDiv) {
		this.routeDiv = routeDiv;
	}
	
	/**
	 * Column Info
	 * @param ttlBkg
	 */
	public void setTtlBkg(String ttlBkg) {
		this.ttlBkg = ttlBkg;
	}
	
	/**
	 * Column Info
	 * @param bkgDateFm
	 */
	public void setBkgDateFm(String bkgDateFm) {
		this.bkgDateFm = bkgDateFm;
	}
	
	/**
	 * Column Info
	 * @param ofcDiv
	 */
	public void setOfcDiv(String ofcDiv) {
		this.ofcDiv = ofcDiv;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setClcRmk(JSPUtil.getParameter(request, prefix + "clc_rmk", ""));
		setSimAgmtSmlNo(JSPUtil.getParameter(request, prefix + "sim_agmt_sml_no", ""));
		setActAgmtSmlNo(JSPUtil.getParameter(request, prefix + "act_agmt_sml_no", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setBkgDateTo(JSPUtil.getParameter(request, prefix + "bkg_date_to", ""));
		setAgmtDiv(JSPUtil.getParameter(request, prefix + "agmt_div", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSaArrDtFm(JSPUtil.getParameter(request, prefix + "sa_arr_dt_fm", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setSaArrDtTo(JSPUtil.getParameter(request, prefix + "sa_arr_dt_to", ""));
		setSimAgmtNo(JSPUtil.getParameter(request, prefix + "sim_agmt_no", ""));
		setAgmtNo2(JSPUtil.getParameter(request, prefix + "agmt_no2", ""));
		setAgmtNo1(JSPUtil.getParameter(request, prefix + "agmt_no1", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPortDiv(JSPUtil.getParameter(request, prefix + "port_div", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVvdDiv(JSPUtil.getParameter(request, prefix + "vvd_div", ""));
		setRouteDiv(JSPUtil.getParameter(request, prefix + "route_div", ""));
		setTtlBkg(JSPUtil.getParameter(request, prefix + "ttl_bkg", ""));
		setBkgDateFm(JSPUtil.getParameter(request, prefix + "bkg_date_fm", ""));
		setOfcDiv(JSPUtil.getParameter(request, prefix + "ofc_div", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommMassSimVO[]
	 */
	public AGNCommMassSimVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGNCommMassSimVO[]
	 */
	public AGNCommMassSimVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommMassSimVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] clcRmk = (JSPUtil.getParameter(request, prefix	+ "clc_rmk", length));
			String[] simAgmtSmlNo = (JSPUtil.getParameter(request, prefix	+ "sim_agmt_sml_no", length));
			String[] actAgmtSmlNo = (JSPUtil.getParameter(request, prefix	+ "act_agmt_sml_no", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] bkgDateTo = (JSPUtil.getParameter(request, prefix	+ "bkg_date_to", length));
			String[] agmtDiv = (JSPUtil.getParameter(request, prefix	+ "agmt_div", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] saArrDtFm = (JSPUtil.getParameter(request, prefix	+ "sa_arr_dt_fm", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] saArrDtTo = (JSPUtil.getParameter(request, prefix	+ "sa_arr_dt_to", length));
			String[] simAgmtNo = (JSPUtil.getParameter(request, prefix	+ "sim_agmt_no", length));
			String[] agmtNo2 = (JSPUtil.getParameter(request, prefix	+ "agmt_no2", length));
			String[] agmtNo1 = (JSPUtil.getParameter(request, prefix	+ "agmt_no1", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] portDiv = (JSPUtil.getParameter(request, prefix	+ "port_div", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvdDiv = (JSPUtil.getParameter(request, prefix	+ "vvd_div", length));
			String[] routeDiv = (JSPUtil.getParameter(request, prefix	+ "route_div", length));
			String[] ttlBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg", length));
			String[] bkgDateFm = (JSPUtil.getParameter(request, prefix	+ "bkg_date_fm", length));
			String[] ofcDiv = (JSPUtil.getParameter(request, prefix	+ "ofc_div", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGNCommMassSimVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (clcRmk[i] != null)
					model.setClcRmk(clcRmk[i]);
				if (simAgmtSmlNo[i] != null)
					model.setSimAgmtSmlNo(simAgmtSmlNo[i]);
				if (actAgmtSmlNo[i] != null)
					model.setActAgmtSmlNo(actAgmtSmlNo[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (bkgDateTo[i] != null)
					model.setBkgDateTo(bkgDateTo[i]);
				if (agmtDiv[i] != null)
					model.setAgmtDiv(agmtDiv[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (saArrDtFm[i] != null)
					model.setSaArrDtFm(saArrDtFm[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (saArrDtTo[i] != null)
					model.setSaArrDtTo(saArrDtTo[i]);
				if (simAgmtNo[i] != null)
					model.setSimAgmtNo(simAgmtNo[i]);
				if (agmtNo2[i] != null)
					model.setAgmtNo2(agmtNo2[i]);
				if (agmtNo1[i] != null)
					model.setAgmtNo1(agmtNo1[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (portDiv[i] != null)
					model.setPortDiv(portDiv[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvdDiv[i] != null)
					model.setVvdDiv(vvdDiv[i]);
				if (routeDiv[i] != null)
					model.setRouteDiv(routeDiv[i]);
				if (ttlBkg[i] != null)
					model.setTtlBkg(ttlBkg[i]);
				if (bkgDateFm[i] != null)
					model.setBkgDateFm(bkgDateFm[i]);
				if (ofcDiv[i] != null)
					model.setOfcDiv(ofcDiv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommMassSimVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommMassSimVO[]
	 */
	public AGNCommMassSimVO[] getAGNCommMassSimVOs(){
		AGNCommMassSimVO[] vos = (AGNCommMassSimVO[])models.toArray(new AGNCommMassSimVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clcRmk = this.clcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simAgmtSmlNo = this.simAgmtSmlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAgmtSmlNo = this.actAgmtSmlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateTo = this.bkgDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDiv = this.agmtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saArrDtFm = this.saArrDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saArrDtTo = this.saArrDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simAgmtNo = this.simAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo2 = this.agmtNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo1 = this.agmtNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDiv = this.portDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDiv = this.vvdDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeDiv = this.routeDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkg = this.ttlBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateFm = this.bkgDateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcDiv = this.ofcDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
