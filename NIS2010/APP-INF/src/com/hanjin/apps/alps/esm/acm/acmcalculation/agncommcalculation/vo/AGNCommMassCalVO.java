/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommMassCalVO.java
*@FileTitle : AGNCommMassCalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2013.01.28 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGNCommMassCalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGNCommMassCalVO> models = new ArrayList<AGNCommMassCalVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String agmtNo2 = null;
	/* Column Info */
	private String agmtNo1 = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String clcRmk = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portDiv = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String agmtDiv = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String vvdDiv = null;
	/* Column Info */
	private String routeDiv = null;
	/* Column Info */
	private String acStsCd = null;
	/* Column Info */
	private String ttlBkg = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String ofcDiv = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String bkgDateTo = null;
	/* Column Info */
	private String bkgDateFm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGNCommMassCalVO() {}

	public AGNCommMassCalVO(String ibflag, String pagerows, String ofcCd, String ofcDiv, String portDiv, String dateDiv, String dateFm, String dateTo, String vvdCd, String vvdDiv, String acTpCd, String agmtDiv, String agmtNo1, String agmtNo2, String acStsCd, String agnCd, String routeDiv, String locCd, String ioBndCd, String ttlBkg, String clcRmk, String usrId, String bkgNo, String bkgDateFm, String bkgDateTo, String agnAgmtNo) {
		this.dateFm = dateFm;
		this.agmtNo2 = agmtNo2;
		this.agmtNo1 = agmtNo1;
		this.dateTo = dateTo;
		this.clcRmk = clcRmk;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.portDiv = portDiv;
		this.agnCd = agnCd;
		this.ofcCd = ofcCd;
		this.agmtDiv = agmtDiv;
		this.bkgNo = bkgNo;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.dateDiv = dateDiv;
		this.vvdDiv = vvdDiv;
		this.routeDiv = routeDiv;
		this.acStsCd = acStsCd;
		this.ttlBkg = ttlBkg;
		this.acTpCd = acTpCd;
		this.ofcDiv = ofcDiv;
		this.agnAgmtNo = agnAgmtNo;
		this.bkgDateTo = bkgDateTo;
		this.bkgDateFm = bkgDateFm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("agmt_no2", getAgmtNo2());
		this.hashColumns.put("agmt_no1", getAgmtNo1());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("clc_rmk", getClcRmk());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_div", getPortDiv());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("agmt_div", getAgmtDiv());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("vvd_div", getVvdDiv());
		this.hashColumns.put("route_div", getRouteDiv());
		this.hashColumns.put("ac_sts_cd", getAcStsCd());
		this.hashColumns.put("ttl_bkg", getTtlBkg());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("ofc_div", getOfcDiv());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("bkg_date_to", getBkgDateTo());
		this.hashColumns.put("bkg_date_fm", getBkgDateFm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("agmt_no2", "agmtNo2");
		this.hashFields.put("agmt_no1", "agmtNo1");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("clc_rmk", "clcRmk");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_div", "portDiv");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("agmt_div", "agmtDiv");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("vvd_div", "vvdDiv");
		this.hashFields.put("route_div", "routeDiv");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("ttl_bkg", "ttlBkg");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("ofc_div", "ofcDiv");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("bkg_date_to", "bkgDateTo");
		this.hashFields.put("bkg_date_fm", "bkgDateFm");
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
	 * @return clcRmk
	 */
	public String getClcRmk() {
		return this.clcRmk;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return portDiv
	 */
	public String getPortDiv() {
		return this.portDiv;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return agmtDiv
	 */
	public String getAgmtDiv() {
		return this.agmtDiv;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
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
	 * @return acStsCd
	 */
	public String getAcStsCd() {
		return this.acStsCd;
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
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
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
	 * @return bkgDateFm
	 */
	public String getBkgDateFm() {
		return this.bkgDateFm;
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
	 * @param clcRmk
	 */
	public void setClcRmk(String clcRmk) {
		this.clcRmk = clcRmk;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param portDiv
	 */
	public void setPortDiv(String portDiv) {
		this.portDiv = portDiv;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param agmtDiv
	 */
	public void setAgmtDiv(String agmtDiv) {
		this.agmtDiv = agmtDiv;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
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
	 * @param acStsCd
	 */
	public void setAcStsCd(String acStsCd) {
		this.acStsCd = acStsCd;
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
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}
	
	/**
	 * Column Info
	 * @param ofcDiv
	 */
	public void setOfcDiv(String ofcDiv) {
		this.ofcDiv = ofcDiv;
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
	 * @param bkgDateFm
	 */
	public void setBkgDateFm(String bkgDateFm) {
		this.bkgDateFm = bkgDateFm;
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
		setAgmtNo2(JSPUtil.getParameter(request, prefix + "agmt_no2", ""));
		setAgmtNo1(JSPUtil.getParameter(request, prefix + "agmt_no1", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setClcRmk(JSPUtil.getParameter(request, prefix + "clc_rmk", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPortDiv(JSPUtil.getParameter(request, prefix + "port_div", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAgmtDiv(JSPUtil.getParameter(request, prefix + "agmt_div", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setVvdDiv(JSPUtil.getParameter(request, prefix + "vvd_div", ""));
		setRouteDiv(JSPUtil.getParameter(request, prefix + "route_div", ""));
		setAcStsCd(JSPUtil.getParameter(request, prefix + "ac_sts_cd", ""));
		setTtlBkg(JSPUtil.getParameter(request, prefix + "ttl_bkg", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setOfcDiv(JSPUtil.getParameter(request, prefix + "ofc_div", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setBkgDateTo(JSPUtil.getParameter(request, prefix + "bkg_date_to", ""));
		setBkgDateFm(JSPUtil.getParameter(request, prefix + "bkg_date_fm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommMassCalVO[]
	 */
	public AGNCommMassCalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGNCommMassCalVO[]
	 */
	public AGNCommMassCalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGNCommMassCalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] agmtNo2 = (JSPUtil.getParameter(request, prefix	+ "agmt_no2", length));
			String[] agmtNo1 = (JSPUtil.getParameter(request, prefix	+ "agmt_no1", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] clcRmk = (JSPUtil.getParameter(request, prefix	+ "clc_rmk", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portDiv = (JSPUtil.getParameter(request, prefix	+ "port_div", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] agmtDiv = (JSPUtil.getParameter(request, prefix	+ "agmt_div", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] vvdDiv = (JSPUtil.getParameter(request, prefix	+ "vvd_div", length));
			String[] routeDiv = (JSPUtil.getParameter(request, prefix	+ "route_div", length));
			String[] acStsCd = (JSPUtil.getParameter(request, prefix	+ "ac_sts_cd", length));
			String[] ttlBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] ofcDiv = (JSPUtil.getParameter(request, prefix	+ "ofc_div", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] bkgDateTo = (JSPUtil.getParameter(request, prefix	+ "bkg_date_to", length));
			String[] bkgDateFm = (JSPUtil.getParameter(request, prefix	+ "bkg_date_fm", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGNCommMassCalVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (agmtNo2[i] != null)
					model.setAgmtNo2(agmtNo2[i]);
				if (agmtNo1[i] != null)
					model.setAgmtNo1(agmtNo1[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (clcRmk[i] != null)
					model.setClcRmk(clcRmk[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portDiv[i] != null)
					model.setPortDiv(portDiv[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (agmtDiv[i] != null)
					model.setAgmtDiv(agmtDiv[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (vvdDiv[i] != null)
					model.setVvdDiv(vvdDiv[i]);
				if (routeDiv[i] != null)
					model.setRouteDiv(routeDiv[i]);
				if (acStsCd[i] != null)
					model.setAcStsCd(acStsCd[i]);
				if (ttlBkg[i] != null)
					model.setTtlBkg(ttlBkg[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (ofcDiv[i] != null)
					model.setOfcDiv(ofcDiv[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (bkgDateTo[i] != null)
					model.setBkgDateTo(bkgDateTo[i]);
				if (bkgDateFm[i] != null)
					model.setBkgDateFm(bkgDateFm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGNCommMassCalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGNCommMassCalVO[]
	 */
	public AGNCommMassCalVO[] getAGNCommMassCalVOs(){
		AGNCommMassCalVO[] vos = (AGNCommMassCalVO[])models.toArray(new AGNCommMassCalVO[models.size()]);
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
		this.agmtNo2 = this.agmtNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo1 = this.agmtNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clcRmk = this.clcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDiv = this.portDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDiv = this.agmtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDiv = this.vvdDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeDiv = this.routeDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd = this.acStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkg = this.ttlBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcDiv = this.ofcDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateTo = this.bkgDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateFm = this.bkgDateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
