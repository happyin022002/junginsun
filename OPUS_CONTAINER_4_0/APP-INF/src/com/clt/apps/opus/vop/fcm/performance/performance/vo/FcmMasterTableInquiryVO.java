/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FcmMasterTableInquiryVO.java
*@FileTitle : FcmMasterTableInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2015.01.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.fcm.performance.performance.vo;

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

public class FcmMasterTableInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmMasterTableInquiryVO> models = new ArrayList<FcmMasterTableInquiryVO>();
	
	/* Column Info */
	private String revFoAmnt = null;
	/* Column Info */
	private String totalSailTime = null;
	/* Column Info */
	private String revDoPrice = null;
	/* Column Info */
	private String revMonth = null;
	/* Column Info */
	private String revDir = null;
	/* Column Info */
	private String revYear = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eeoiDcapa = null;
	/* Column Info */
	private String skedVoyage = null;
	/* Column Info */
	private String skedEndEta = null;
	/* Column Info */
	private String revFoQty = null;
	/* Column Info */
	private String conFoDo = null;
	/* Column Info */
	private String totalPortFo = null;
	/* Column Info */
	private String skedStartPort = null;
	/* Column Info */
	private String totalMilesIn = null;
	/* Column Info */
	private String skedStartZd = null;
	/* Column Info */
	private String revVessel = null;
	/* Column Info */
	private String eeoiBsa = null;
	/* Column Info */
	private String eeoiOc = null;
	/* Column Info */
	private String pfTtlTime = null;
	/* Column Info */
	private String pfDistance = null;
	/* Column Info */
	private String pfSeaTime = null;
	/* Column Info */
	private String revVoyno = null;
	/* Column Info */
	private String totalObsMile = null;
	/* Column Info */
	private String pfManuOut = null;
	/* Column Info */
	private String pfPortTime = null;
	/* Column Info */
	private String pfManuIn = null;
	/* Column Info */
	private String totalPortDo = null;
	/* Column Info */
	private String conSea = null;
	/* Column Info */
	private String pfType = null;
	/* Column Info */
	private String revDoQty = null;
	/* Column Info */
	private String pfCspeed = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalMilesEng = null;
	/* Column Info */
	private String totalMilesOut = null;
	/* Column Info */
	private String skedEndPort = null;
	/* Column Info */
	private String pfSpd = null;
	/* Column Info */
	private String skedStartEta = null;
	/* Column Info */
	private String totalAverSpd = null;
	/* Column Info */
	private String eeoiGubun = null;
	/* Column Info */
	private String revLane = null;
	/* Column Info */
	private String revDoAmnt = null;
	/* Column Info */
	private String conPort = null;
	/* Column Info */
	private String revTrade = null;
	/* Column Info */
	private String eeoiCalBsa = null;
	/* Column Info */
	private String eeoiCalDcapa = null;
	/* Column Info */
	private String revFoPrice = null;
	/* Column Info */
	private String skedEndZd = null;
	/* Column Info */
	private String totalMiles = null;
	/* Column Info */
	private String pfBufferTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FcmMasterTableInquiryVO() {}

	public FcmMasterTableInquiryVO(String ibflag, String pagerows, String revYear, String revMonth, String revVessel, String revVoyno, String revDir, String revTrade, String revLane, String revFoQty, String revFoPrice, String revFoAmnt, String revDoQty, String revDoPrice, String revDoAmnt, String skedStartPort, String skedStartZd, String skedStartEta, String skedEndPort, String skedEndZd, String skedEndEta, String skedVoyage, String pfType, String pfDistance, String pfSpd, String pfSeaTime, String pfBufferTime, String pfCspeed, String pfManuIn, String pfManuOut, String pfPortTime, String pfTtlTime, String conFoDo, String conSea, String conPort, String totalObsMile, String totalMilesEng, String totalMilesIn, String totalMilesOut, String totalMiles, String totalSailTime, String totalPortFo, String totalPortDo, String totalAverSpd, String eeoiBsa, String eeoiDcapa, String eeoiOc, String eeoiGubun, String eeoiCalBsa, String eeoiCalDcapa) {
		this.revFoAmnt = revFoAmnt;
		this.totalSailTime = totalSailTime;
		this.revDoPrice = revDoPrice;
		this.revMonth = revMonth;
		this.revDir = revDir;
		this.revYear = revYear;
		this.pagerows = pagerows;
		this.eeoiDcapa = eeoiDcapa;
		this.skedVoyage = skedVoyage;
		this.skedEndEta = skedEndEta;
		this.revFoQty = revFoQty;
		this.conFoDo = conFoDo;
		this.totalPortFo = totalPortFo;
		this.skedStartPort = skedStartPort;
		this.totalMilesIn = totalMilesIn;
		this.skedStartZd = skedStartZd;
		this.revVessel = revVessel;
		this.eeoiBsa = eeoiBsa;
		this.eeoiOc = eeoiOc;
		this.pfTtlTime = pfTtlTime;
		this.pfDistance = pfDistance;
		this.pfSeaTime = pfSeaTime;
		this.revVoyno = revVoyno;
		this.totalObsMile = totalObsMile;
		this.pfManuOut = pfManuOut;
		this.pfPortTime = pfPortTime;
		this.pfManuIn = pfManuIn;
		this.totalPortDo = totalPortDo;
		this.conSea = conSea;
		this.pfType = pfType;
		this.revDoQty = revDoQty;
		this.pfCspeed = pfCspeed;
		this.ibflag = ibflag;
		this.totalMilesEng = totalMilesEng;
		this.totalMilesOut = totalMilesOut;
		this.skedEndPort = skedEndPort;
		this.pfSpd = pfSpd;
		this.skedStartEta = skedStartEta;
		this.totalAverSpd = totalAverSpd;
		this.eeoiGubun = eeoiGubun;
		this.revLane = revLane;
		this.revDoAmnt = revDoAmnt;
		this.conPort = conPort;
		this.revTrade = revTrade;
		this.eeoiCalBsa = eeoiCalBsa;
		this.eeoiCalDcapa = eeoiCalDcapa;
		this.revFoPrice = revFoPrice;
		this.skedEndZd = skedEndZd;
		this.totalMiles = totalMiles;
		this.pfBufferTime = pfBufferTime;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_fo_amnt", getRevFoAmnt());
		this.hashColumns.put("total_sail_time", getTotalSailTime());
		this.hashColumns.put("rev_do_price", getRevDoPrice());
		this.hashColumns.put("rev_month", getRevMonth());
		this.hashColumns.put("rev_dir", getRevDir());
		this.hashColumns.put("rev_year", getRevYear());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eeoi_dcapa", getEeoiDcapa());
		this.hashColumns.put("sked_voyage", getSkedVoyage());
		this.hashColumns.put("sked_end_eta", getSkedEndEta());
		this.hashColumns.put("rev_fo_qty", getRevFoQty());
		this.hashColumns.put("con_fo_do", getConFoDo());
		this.hashColumns.put("total_port_fo", getTotalPortFo());
		this.hashColumns.put("sked_start_port", getSkedStartPort());
		this.hashColumns.put("total_miles_in", getTotalMilesIn());
		this.hashColumns.put("sked_start_zd", getSkedStartZd());
		this.hashColumns.put("rev_vessel", getRevVessel());
		this.hashColumns.put("eeoi_bsa", getEeoiBsa());
		this.hashColumns.put("eeoi_oc", getEeoiOc());
		this.hashColumns.put("pf_ttl_time", getPfTtlTime());
		this.hashColumns.put("pf_distance", getPfDistance());
		this.hashColumns.put("pf_sea_time", getPfSeaTime());
		this.hashColumns.put("rev_voyno", getRevVoyno());
		this.hashColumns.put("total_obs_mile", getTotalObsMile());
		this.hashColumns.put("pf_manu_out", getPfManuOut());
		this.hashColumns.put("pf_port_time", getPfPortTime());
		this.hashColumns.put("pf_manu_in", getPfManuIn());
		this.hashColumns.put("total_port_do", getTotalPortDo());
		this.hashColumns.put("con_sea", getConSea());
		this.hashColumns.put("pf_type", getPfType());
		this.hashColumns.put("rev_do_qty", getRevDoQty());
		this.hashColumns.put("pf_cspeed", getPfCspeed());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_miles_eng", getTotalMilesEng());
		this.hashColumns.put("total_miles_out", getTotalMilesOut());
		this.hashColumns.put("sked_end_port", getSkedEndPort());
		this.hashColumns.put("pf_spd", getPfSpd());
		this.hashColumns.put("sked_start_eta", getSkedStartEta());
		this.hashColumns.put("total_aver_spd", getTotalAverSpd());
		this.hashColumns.put("eeoi_gubun", getEeoiGubun());
		this.hashColumns.put("rev_lane", getRevLane());
		this.hashColumns.put("rev_do_amnt", getRevDoAmnt());
		this.hashColumns.put("con_port", getConPort());
		this.hashColumns.put("rev_trade", getRevTrade());
		this.hashColumns.put("eeoi_cal_bsa", getEeoiCalBsa());
		this.hashColumns.put("eeoi_cal_dcapa", getEeoiCalDcapa());
		this.hashColumns.put("rev_fo_price", getRevFoPrice());
		this.hashColumns.put("sked_end_zd", getSkedEndZd());
		this.hashColumns.put("total_miles", getTotalMiles());
		this.hashColumns.put("pf_buffer_time", getPfBufferTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_fo_amnt", "revFoAmnt");
		this.hashFields.put("total_sail_time", "totalSailTime");
		this.hashFields.put("rev_do_price", "revDoPrice");
		this.hashFields.put("rev_month", "revMonth");
		this.hashFields.put("rev_dir", "revDir");
		this.hashFields.put("rev_year", "revYear");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eeoi_dcapa", "eeoiDcapa");
		this.hashFields.put("sked_voyage", "skedVoyage");
		this.hashFields.put("sked_end_eta", "skedEndEta");
		this.hashFields.put("rev_fo_qty", "revFoQty");
		this.hashFields.put("con_fo_do", "conFoDo");
		this.hashFields.put("total_port_fo", "totalPortFo");
		this.hashFields.put("sked_start_port", "skedStartPort");
		this.hashFields.put("total_miles_in", "totalMilesIn");
		this.hashFields.put("sked_start_zd", "skedStartZd");
		this.hashFields.put("rev_vessel", "revVessel");
		this.hashFields.put("eeoi_bsa", "eeoiBsa");
		this.hashFields.put("eeoi_oc", "eeoiOc");
		this.hashFields.put("pf_ttl_time", "pfTtlTime");
		this.hashFields.put("pf_distance", "pfDistance");
		this.hashFields.put("pf_sea_time", "pfSeaTime");
		this.hashFields.put("rev_voyno", "revVoyno");
		this.hashFields.put("total_obs_mile", "totalObsMile");
		this.hashFields.put("pf_manu_out", "pfManuOut");
		this.hashFields.put("pf_port_time", "pfPortTime");
		this.hashFields.put("pf_manu_in", "pfManuIn");
		this.hashFields.put("total_port_do", "totalPortDo");
		this.hashFields.put("con_sea", "conSea");
		this.hashFields.put("pf_type", "pfType");
		this.hashFields.put("rev_do_qty", "revDoQty");
		this.hashFields.put("pf_cspeed", "pfCspeed");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_miles_eng", "totalMilesEng");
		this.hashFields.put("total_miles_out", "totalMilesOut");
		this.hashFields.put("sked_end_port", "skedEndPort");
		this.hashFields.put("pf_spd", "pfSpd");
		this.hashFields.put("sked_start_eta", "skedStartEta");
		this.hashFields.put("total_aver_spd", "totalAverSpd");
		this.hashFields.put("eeoi_gubun", "eeoiGubun");
		this.hashFields.put("rev_lane", "revLane");
		this.hashFields.put("rev_do_amnt", "revDoAmnt");
		this.hashFields.put("con_port", "conPort");
		this.hashFields.put("rev_trade", "revTrade");
		this.hashFields.put("eeoi_cal_bsa", "eeoiCalBsa");
		this.hashFields.put("eeoi_cal_dcapa", "eeoiCalDcapa");
		this.hashFields.put("rev_fo_price", "revFoPrice");
		this.hashFields.put("sked_end_zd", "skedEndZd");
		this.hashFields.put("total_miles", "totalMiles");
		this.hashFields.put("pf_buffer_time", "pfBufferTime");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revFoAmnt
	 */
	public String getRevFoAmnt() {
		return this.revFoAmnt;
	}
	
	/**
	 * Column Info
	 * @return totalSailTime
	 */
	public String getTotalSailTime() {
		return this.totalSailTime;
	}
	
	/**
	 * Column Info
	 * @return revDoPrice
	 */
	public String getRevDoPrice() {
		return this.revDoPrice;
	}
	
	/**
	 * Column Info
	 * @return revMonth
	 */
	public String getRevMonth() {
		return this.revMonth;
	}
	
	/**
	 * Column Info
	 * @return revDir
	 */
	public String getRevDir() {
		return this.revDir;
	}
	
	/**
	 * Column Info
	 * @return revYear
	 */
	public String getRevYear() {
		return this.revYear;
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
	 * @return eeoiDcapa
	 */
	public String getEeoiDcapa() {
		return this.eeoiDcapa;
	}
	
	/**
	 * Column Info
	 * @return skedVoyage
	 */
	public String getSkedVoyage() {
		return this.skedVoyage;
	}
	
	/**
	 * Column Info
	 * @return skedEndEta
	 */
	public String getSkedEndEta() {
		return this.skedEndEta;
	}
	
	/**
	 * Column Info
	 * @return revFoQty
	 */
	public String getRevFoQty() {
		return this.revFoQty;
	}
	
	/**
	 * Column Info
	 * @return conFoDo
	 */
	public String getConFoDo() {
		return this.conFoDo;
	}
	
	/**
	 * Column Info
	 * @return totalPortFo
	 */
	public String getTotalPortFo() {
		return this.totalPortFo;
	}
	
	/**
	 * Column Info
	 * @return skedStartPort
	 */
	public String getSkedStartPort() {
		return this.skedStartPort;
	}
	
	/**
	 * Column Info
	 * @return totalMilesIn
	 */
	public String getTotalMilesIn() {
		return this.totalMilesIn;
	}
	
	/**
	 * Column Info
	 * @return skedStartZd
	 */
	public String getSkedStartZd() {
		return this.skedStartZd;
	}
	
	/**
	 * Column Info
	 * @return revVessel
	 */
	public String getRevVessel() {
		return this.revVessel;
	}
	
	/**
	 * Column Info
	 * @return eeoiBsa
	 */
	public String getEeoiBsa() {
		return this.eeoiBsa;
	}
	
	/**
	 * Column Info
	 * @return eeoiOc
	 */
	public String getEeoiOc() {
		return this.eeoiOc;
	}
	
	/**
	 * Column Info
	 * @return pfTtlTime
	 */
	public String getPfTtlTime() {
		return this.pfTtlTime;
	}
	
	/**
	 * Column Info
	 * @return pfDistance
	 */
	public String getPfDistance() {
		return this.pfDistance;
	}
	
	/**
	 * Column Info
	 * @return pfSeaTime
	 */
	public String getPfSeaTime() {
		return this.pfSeaTime;
	}
	
	/**
	 * Column Info
	 * @return revVoyno
	 */
	public String getRevVoyno() {
		return this.revVoyno;
	}
	
	/**
	 * Column Info
	 * @return totalObsMile
	 */
	public String getTotalObsMile() {
		return this.totalObsMile;
	}
	
	/**
	 * Column Info
	 * @return pfManuOut
	 */
	public String getPfManuOut() {
		return this.pfManuOut;
	}
	
	/**
	 * Column Info
	 * @return pfPortTime
	 */
	public String getPfPortTime() {
		return this.pfPortTime;
	}
	
	/**
	 * Column Info
	 * @return pfManuIn
	 */
	public String getPfManuIn() {
		return this.pfManuIn;
	}
	
	/**
	 * Column Info
	 * @return totalPortDo
	 */
	public String getTotalPortDo() {
		return this.totalPortDo;
	}
	
	/**
	 * Column Info
	 * @return conSea
	 */
	public String getConSea() {
		return this.conSea;
	}
	
	/**
	 * Column Info
	 * @return pfType
	 */
	public String getPfType() {
		return this.pfType;
	}
	
	/**
	 * Column Info
	 * @return revDoQty
	 */
	public String getRevDoQty() {
		return this.revDoQty;
	}
	
	/**
	 * Column Info
	 * @return pfCspeed
	 */
	public String getPfCspeed() {
		return this.pfCspeed;
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
	 * @return totalMilesEng
	 */
	public String getTotalMilesEng() {
		return this.totalMilesEng;
	}
	
	/**
	 * Column Info
	 * @return totalMilesOut
	 */
	public String getTotalMilesOut() {
		return this.totalMilesOut;
	}
	
	/**
	 * Column Info
	 * @return skedEndPort
	 */
	public String getSkedEndPort() {
		return this.skedEndPort;
	}
	
	/**
	 * Column Info
	 * @return pfSpd
	 */
	public String getPfSpd() {
		return this.pfSpd;
	}
	
	/**
	 * Column Info
	 * @return skedStartEta
	 */
	public String getSkedStartEta() {
		return this.skedStartEta;
	}
	
	/**
	 * Column Info
	 * @return totalAverSpd
	 */
	public String getTotalAverSpd() {
		return this.totalAverSpd;
	}
	
	/**
	 * Column Info
	 * @return eeoiGubun
	 */
	public String getEeoiGubun() {
		return this.eeoiGubun;
	}
	
	/**
	 * Column Info
	 * @return revLane
	 */
	public String getRevLane() {
		return this.revLane;
	}
	
	/**
	 * Column Info
	 * @return revDoAmnt
	 */
	public String getRevDoAmnt() {
		return this.revDoAmnt;
	}
	
	/**
	 * Column Info
	 * @return conPort
	 */
	public String getConPort() {
		return this.conPort;
	}
	
	/**
	 * Column Info
	 * @return revTrade
	 */
	public String getRevTrade() {
		return this.revTrade;
	}
	
	/**
	 * Column Info
	 * @return eeoiCalBsa
	 */
	public String getEeoiCalBsa() {
		return this.eeoiCalBsa;
	}
	
	/**
	 * Column Info
	 * @return eeoiCalDcapa
	 */
	public String getEeoiCalDcapa() {
		return this.eeoiCalDcapa;
	}
	
	/**
	 * Column Info
	 * @return revFoPrice
	 */
	public String getRevFoPrice() {
		return this.revFoPrice;
	}
	
	/**
	 * Column Info
	 * @return skedEndZd
	 */
	public String getSkedEndZd() {
		return this.skedEndZd;
	}
	
	/**
	 * Column Info
	 * @return totalMiles
	 */
	public String getTotalMiles() {
		return this.totalMiles;
	}
	
	/**
	 * Column Info
	 * @return pfBufferTime
	 */
	public String getPfBufferTime() {
		return this.pfBufferTime;
	}
	

	/**
	 * Column Info
	 * @param revFoAmnt
	 */
	public void setRevFoAmnt(String revFoAmnt) {
		this.revFoAmnt = revFoAmnt;
	}
	
	/**
	 * Column Info
	 * @param totalSailTime
	 */
	public void setTotalSailTime(String totalSailTime) {
		this.totalSailTime = totalSailTime;
	}
	
	/**
	 * Column Info
	 * @param revDoPrice
	 */
	public void setRevDoPrice(String revDoPrice) {
		this.revDoPrice = revDoPrice;
	}
	
	/**
	 * Column Info
	 * @param revMonth
	 */
	public void setRevMonth(String revMonth) {
		this.revMonth = revMonth;
	}
	
	/**
	 * Column Info
	 * @param revDir
	 */
	public void setRevDir(String revDir) {
		this.revDir = revDir;
	}
	
	/**
	 * Column Info
	 * @param revYear
	 */
	public void setRevYear(String revYear) {
		this.revYear = revYear;
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
	 * @param eeoiDcapa
	 */
	public void setEeoiDcapa(String eeoiDcapa) {
		this.eeoiDcapa = eeoiDcapa;
	}
	
	/**
	 * Column Info
	 * @param skedVoyage
	 */
	public void setSkedVoyage(String skedVoyage) {
		this.skedVoyage = skedVoyage;
	}
	
	/**
	 * Column Info
	 * @param skedEndEta
	 */
	public void setSkedEndEta(String skedEndEta) {
		this.skedEndEta = skedEndEta;
	}
	
	/**
	 * Column Info
	 * @param revFoQty
	 */
	public void setRevFoQty(String revFoQty) {
		this.revFoQty = revFoQty;
	}
	
	/**
	 * Column Info
	 * @param conFoDo
	 */
	public void setConFoDo(String conFoDo) {
		this.conFoDo = conFoDo;
	}
	
	/**
	 * Column Info
	 * @param totalPortFo
	 */
	public void setTotalPortFo(String totalPortFo) {
		this.totalPortFo = totalPortFo;
	}
	
	/**
	 * Column Info
	 * @param skedStartPort
	 */
	public void setSkedStartPort(String skedStartPort) {
		this.skedStartPort = skedStartPort;
	}
	
	/**
	 * Column Info
	 * @param totalMilesIn
	 */
	public void setTotalMilesIn(String totalMilesIn) {
		this.totalMilesIn = totalMilesIn;
	}
	
	/**
	 * Column Info
	 * @param skedStartZd
	 */
	public void setSkedStartZd(String skedStartZd) {
		this.skedStartZd = skedStartZd;
	}
	
	/**
	 * Column Info
	 * @param revVessel
	 */
	public void setRevVessel(String revVessel) {
		this.revVessel = revVessel;
	}
	
	/**
	 * Column Info
	 * @param eeoiBsa
	 */
	public void setEeoiBsa(String eeoiBsa) {
		this.eeoiBsa = eeoiBsa;
	}
	
	/**
	 * Column Info
	 * @param eeoiOc
	 */
	public void setEeoiOc(String eeoiOc) {
		this.eeoiOc = eeoiOc;
	}
	
	/**
	 * Column Info
	 * @param pfTtlTime
	 */
	public void setPfTtlTime(String pfTtlTime) {
		this.pfTtlTime = pfTtlTime;
	}
	
	/**
	 * Column Info
	 * @param pfDistance
	 */
	public void setPfDistance(String pfDistance) {
		this.pfDistance = pfDistance;
	}
	
	/**
	 * Column Info
	 * @param pfSeaTime
	 */
	public void setPfSeaTime(String pfSeaTime) {
		this.pfSeaTime = pfSeaTime;
	}
	
	/**
	 * Column Info
	 * @param revVoyno
	 */
	public void setRevVoyno(String revVoyno) {
		this.revVoyno = revVoyno;
	}
	
	/**
	 * Column Info
	 * @param totalObsMile
	 */
	public void setTotalObsMile(String totalObsMile) {
		this.totalObsMile = totalObsMile;
	}
	
	/**
	 * Column Info
	 * @param pfManuOut
	 */
	public void setPfManuOut(String pfManuOut) {
		this.pfManuOut = pfManuOut;
	}
	
	/**
	 * Column Info
	 * @param pfPortTime
	 */
	public void setPfPortTime(String pfPortTime) {
		this.pfPortTime = pfPortTime;
	}
	
	/**
	 * Column Info
	 * @param pfManuIn
	 */
	public void setPfManuIn(String pfManuIn) {
		this.pfManuIn = pfManuIn;
	}
	
	/**
	 * Column Info
	 * @param totalPortDo
	 */
	public void setTotalPortDo(String totalPortDo) {
		this.totalPortDo = totalPortDo;
	}
	
	/**
	 * Column Info
	 * @param conSea
	 */
	public void setConSea(String conSea) {
		this.conSea = conSea;
	}
	
	/**
	 * Column Info
	 * @param pfType
	 */
	public void setPfType(String pfType) {
		this.pfType = pfType;
	}
	
	/**
	 * Column Info
	 * @param revDoQty
	 */
	public void setRevDoQty(String revDoQty) {
		this.revDoQty = revDoQty;
	}
	
	/**
	 * Column Info
	 * @param pfCspeed
	 */
	public void setPfCspeed(String pfCspeed) {
		this.pfCspeed = pfCspeed;
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
	 * @param totalMilesEng
	 */
	public void setTotalMilesEng(String totalMilesEng) {
		this.totalMilesEng = totalMilesEng;
	}
	
	/**
	 * Column Info
	 * @param totalMilesOut
	 */
	public void setTotalMilesOut(String totalMilesOut) {
		this.totalMilesOut = totalMilesOut;
	}
	
	/**
	 * Column Info
	 * @param skedEndPort
	 */
	public void setSkedEndPort(String skedEndPort) {
		this.skedEndPort = skedEndPort;
	}
	
	/**
	 * Column Info
	 * @param pfSpd
	 */
	public void setPfSpd(String pfSpd) {
		this.pfSpd = pfSpd;
	}
	
	/**
	 * Column Info
	 * @param skedStartEta
	 */
	public void setSkedStartEta(String skedStartEta) {
		this.skedStartEta = skedStartEta;
	}
	
	/**
	 * Column Info
	 * @param totalAverSpd
	 */
	public void setTotalAverSpd(String totalAverSpd) {
		this.totalAverSpd = totalAverSpd;
	}
	
	/**
	 * Column Info
	 * @param eeoiGubun
	 */
	public void setEeoiGubun(String eeoiGubun) {
		this.eeoiGubun = eeoiGubun;
	}
	
	/**
	 * Column Info
	 * @param revLane
	 */
	public void setRevLane(String revLane) {
		this.revLane = revLane;
	}
	
	/**
	 * Column Info
	 * @param revDoAmnt
	 */
	public void setRevDoAmnt(String revDoAmnt) {
		this.revDoAmnt = revDoAmnt;
	}
	
	/**
	 * Column Info
	 * @param conPort
	 */
	public void setConPort(String conPort) {
		this.conPort = conPort;
	}
	
	/**
	 * Column Info
	 * @param revTrade
	 */
	public void setRevTrade(String revTrade) {
		this.revTrade = revTrade;
	}
	
	/**
	 * Column Info
	 * @param eeoiCalBsa
	 */
	public void setEeoiCalBsa(String eeoiCalBsa) {
		this.eeoiCalBsa = eeoiCalBsa;
	}
	
	/**
	 * Column Info
	 * @param eeoiCalDcapa
	 */
	public void setEeoiCalDcapa(String eeoiCalDcapa) {
		this.eeoiCalDcapa = eeoiCalDcapa;
	}
	
	/**
	 * Column Info
	 * @param revFoPrice
	 */
	public void setRevFoPrice(String revFoPrice) {
		this.revFoPrice = revFoPrice;
	}
	
	/**
	 * Column Info
	 * @param skedEndZd
	 */
	public void setSkedEndZd(String skedEndZd) {
		this.skedEndZd = skedEndZd;
	}
	
	/**
	 * Column Info
	 * @param totalMiles
	 */
	public void setTotalMiles(String totalMiles) {
		this.totalMiles = totalMiles;
	}
	
	/**
	 * Column Info
	 * @param pfBufferTime
	 */
	public void setPfBufferTime(String pfBufferTime) {
		this.pfBufferTime = pfBufferTime;
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
		setRevFoAmnt(JSPUtil.getParameter(request, prefix + "rev_fo_amnt", ""));
		setTotalSailTime(JSPUtil.getParameter(request, prefix + "total_sail_time", ""));
		setRevDoPrice(JSPUtil.getParameter(request, prefix + "rev_do_price", ""));
		setRevMonth(JSPUtil.getParameter(request, prefix + "rev_month", ""));
		setRevDir(JSPUtil.getParameter(request, prefix + "rev_dir", ""));
		setRevYear(JSPUtil.getParameter(request, prefix + "rev_year", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEeoiDcapa(JSPUtil.getParameter(request, prefix + "eeoi_dcapa", ""));
		setSkedVoyage(JSPUtil.getParameter(request, prefix + "sked_voyage", ""));
		setSkedEndEta(JSPUtil.getParameter(request, prefix + "sked_end_eta", ""));
		setRevFoQty(JSPUtil.getParameter(request, prefix + "rev_fo_qty", ""));
		setConFoDo(JSPUtil.getParameter(request, prefix + "con_fo_do", ""));
		setTotalPortFo(JSPUtil.getParameter(request, prefix + "total_port_fo", ""));
		setSkedStartPort(JSPUtil.getParameter(request, prefix + "sked_start_port", ""));
		setTotalMilesIn(JSPUtil.getParameter(request, prefix + "total_miles_in", ""));
		setSkedStartZd(JSPUtil.getParameter(request, prefix + "sked_start_zd", ""));
		setRevVessel(JSPUtil.getParameter(request, prefix + "rev_vessel", ""));
		setEeoiBsa(JSPUtil.getParameter(request, prefix + "eeoi_bsa", ""));
		setEeoiOc(JSPUtil.getParameter(request, prefix + "eeoi_oc", ""));
		setPfTtlTime(JSPUtil.getParameter(request, prefix + "pf_ttl_time", ""));
		setPfDistance(JSPUtil.getParameter(request, prefix + "pf_distance", ""));
		setPfSeaTime(JSPUtil.getParameter(request, prefix + "pf_sea_time", ""));
		setRevVoyno(JSPUtil.getParameter(request, prefix + "rev_voyno", ""));
		setTotalObsMile(JSPUtil.getParameter(request, prefix + "total_obs_mile", ""));
		setPfManuOut(JSPUtil.getParameter(request, prefix + "pf_manu_out", ""));
		setPfPortTime(JSPUtil.getParameter(request, prefix + "pf_port_time", ""));
		setPfManuIn(JSPUtil.getParameter(request, prefix + "pf_manu_in", ""));
		setTotalPortDo(JSPUtil.getParameter(request, prefix + "total_port_do", ""));
		setConSea(JSPUtil.getParameter(request, prefix + "con_sea", ""));
		setPfType(JSPUtil.getParameter(request, prefix + "pf_type", ""));
		setRevDoQty(JSPUtil.getParameter(request, prefix + "rev_do_qty", ""));
		setPfCspeed(JSPUtil.getParameter(request, prefix + "pf_cspeed", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalMilesEng(JSPUtil.getParameter(request, prefix + "total_miles_eng", ""));
		setTotalMilesOut(JSPUtil.getParameter(request, prefix + "total_miles_out", ""));
		setSkedEndPort(JSPUtil.getParameter(request, prefix + "sked_end_port", ""));
		setPfSpd(JSPUtil.getParameter(request, prefix + "pf_spd", ""));
		setSkedStartEta(JSPUtil.getParameter(request, prefix + "sked_start_eta", ""));
		setTotalAverSpd(JSPUtil.getParameter(request, prefix + "total_aver_spd", ""));
		setEeoiGubun(JSPUtil.getParameter(request, prefix + "eeoi_gubun", ""));
		setRevLane(JSPUtil.getParameter(request, prefix + "rev_lane", ""));
		setRevDoAmnt(JSPUtil.getParameter(request, prefix + "rev_do_amnt", ""));
		setConPort(JSPUtil.getParameter(request, prefix + "con_port", ""));
		setRevTrade(JSPUtil.getParameter(request, prefix + "rev_trade", ""));
		setEeoiCalBsa(JSPUtil.getParameter(request, prefix + "eeoi_cal_bsa", ""));
		setEeoiCalDcapa(JSPUtil.getParameter(request, prefix + "eeoi_cal_dcapa", ""));
		setRevFoPrice(JSPUtil.getParameter(request, prefix + "rev_fo_price", ""));
		setSkedEndZd(JSPUtil.getParameter(request, prefix + "sked_end_zd", ""));
		setTotalMiles(JSPUtil.getParameter(request, prefix + "total_miles", ""));
		setPfBufferTime(JSPUtil.getParameter(request, prefix + "pf_buffer_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TestVO[]
	 */
	public FcmMasterTableInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TestVO[]
	 */
	public FcmMasterTableInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmMasterTableInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revFoAmnt = (JSPUtil.getParameter(request, prefix	+ "rev_fo_amnt", length));
			String[] totalSailTime = (JSPUtil.getParameter(request, prefix	+ "total_sail_time", length));
			String[] revDoPrice = (JSPUtil.getParameter(request, prefix	+ "rev_do_price", length));
			String[] revMonth = (JSPUtil.getParameter(request, prefix	+ "rev_month", length));
			String[] revDir = (JSPUtil.getParameter(request, prefix	+ "rev_dir", length));
			String[] revYear = (JSPUtil.getParameter(request, prefix	+ "rev_year", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eeoiDcapa = (JSPUtil.getParameter(request, prefix	+ "eeoi_dcapa", length));
			String[] skedVoyage = (JSPUtil.getParameter(request, prefix	+ "sked_voyage", length));
			String[] skedEndEta = (JSPUtil.getParameter(request, prefix	+ "sked_end_eta", length));
			String[] revFoQty = (JSPUtil.getParameter(request, prefix	+ "rev_fo_qty", length));
			String[] conFoDo = (JSPUtil.getParameter(request, prefix	+ "con_fo_do", length));
			String[] totalPortFo = (JSPUtil.getParameter(request, prefix	+ "total_port_fo", length));
			String[] skedStartPort = (JSPUtil.getParameter(request, prefix	+ "sked_start_port", length));
			String[] totalMilesIn = (JSPUtil.getParameter(request, prefix	+ "total_miles_in", length));
			String[] skedStartZd = (JSPUtil.getParameter(request, prefix	+ "sked_start_zd", length));
			String[] revVessel = (JSPUtil.getParameter(request, prefix	+ "rev_vessel", length));
			String[] eeoiBsa = (JSPUtil.getParameter(request, prefix	+ "eeoi_bsa", length));
			String[] eeoiOc = (JSPUtil.getParameter(request, prefix	+ "eeoi_oc", length));
			String[] pfTtlTime = (JSPUtil.getParameter(request, prefix	+ "pf_ttl_time", length));
			String[] pfDistance = (JSPUtil.getParameter(request, prefix	+ "pf_distance", length));
			String[] pfSeaTime = (JSPUtil.getParameter(request, prefix	+ "pf_sea_time", length));
			String[] revVoyno = (JSPUtil.getParameter(request, prefix	+ "rev_voyno", length));
			String[] totalObsMile = (JSPUtil.getParameter(request, prefix	+ "total_obs_mile", length));
			String[] pfManuOut = (JSPUtil.getParameter(request, prefix	+ "pf_manu_out", length));
			String[] pfPortTime = (JSPUtil.getParameter(request, prefix	+ "pf_port_time", length));
			String[] pfManuIn = (JSPUtil.getParameter(request, prefix	+ "pf_manu_in", length));
			String[] totalPortDo = (JSPUtil.getParameter(request, prefix	+ "total_port_do", length));
			String[] conSea = (JSPUtil.getParameter(request, prefix	+ "con_sea", length));
			String[] pfType = (JSPUtil.getParameter(request, prefix	+ "pf_type", length));
			String[] revDoQty = (JSPUtil.getParameter(request, prefix	+ "rev_do_qty", length));
			String[] pfCspeed = (JSPUtil.getParameter(request, prefix	+ "pf_cspeed", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalMilesEng = (JSPUtil.getParameter(request, prefix	+ "total_miles_eng", length));
			String[] totalMilesOut = (JSPUtil.getParameter(request, prefix	+ "total_miles_out", length));
			String[] skedEndPort = (JSPUtil.getParameter(request, prefix	+ "sked_end_port", length));
			String[] pfSpd = (JSPUtil.getParameter(request, prefix	+ "pf_spd", length));
			String[] skedStartEta = (JSPUtil.getParameter(request, prefix	+ "sked_start_eta", length));
			String[] totalAverSpd = (JSPUtil.getParameter(request, prefix	+ "total_aver_spd", length));
			String[] eeoiGubun = (JSPUtil.getParameter(request, prefix	+ "eeoi_gubun", length));
			String[] revLane = (JSPUtil.getParameter(request, prefix	+ "rev_lane", length));
			String[] revDoAmnt = (JSPUtil.getParameter(request, prefix	+ "rev_do_amnt", length));
			String[] conPort = (JSPUtil.getParameter(request, prefix	+ "con_port", length));
			String[] revTrade = (JSPUtil.getParameter(request, prefix	+ "rev_trade", length));
			String[] eeoiCalBsa = (JSPUtil.getParameter(request, prefix	+ "eeoi_cal_bsa", length));
			String[] eeoiCalDcapa = (JSPUtil.getParameter(request, prefix	+ "eeoi_cal_dcapa", length));
			String[] revFoPrice = (JSPUtil.getParameter(request, prefix	+ "rev_fo_price", length));
			String[] skedEndZd = (JSPUtil.getParameter(request, prefix	+ "sked_end_zd", length));
			String[] totalMiles = (JSPUtil.getParameter(request, prefix	+ "total_miles", length));
			String[] pfBufferTime = (JSPUtil.getParameter(request, prefix	+ "pf_buffer_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmMasterTableInquiryVO();
				if (revFoAmnt[i] != null)
					model.setRevFoAmnt(revFoAmnt[i]);
				if (totalSailTime[i] != null)
					model.setTotalSailTime(totalSailTime[i]);
				if (revDoPrice[i] != null)
					model.setRevDoPrice(revDoPrice[i]);
				if (revMonth[i] != null)
					model.setRevMonth(revMonth[i]);
				if (revDir[i] != null)
					model.setRevDir(revDir[i]);
				if (revYear[i] != null)
					model.setRevYear(revYear[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eeoiDcapa[i] != null)
					model.setEeoiDcapa(eeoiDcapa[i]);
				if (skedVoyage[i] != null)
					model.setSkedVoyage(skedVoyage[i]);
				if (skedEndEta[i] != null)
					model.setSkedEndEta(skedEndEta[i]);
				if (revFoQty[i] != null)
					model.setRevFoQty(revFoQty[i]);
				if (conFoDo[i] != null)
					model.setConFoDo(conFoDo[i]);
				if (totalPortFo[i] != null)
					model.setTotalPortFo(totalPortFo[i]);
				if (skedStartPort[i] != null)
					model.setSkedStartPort(skedStartPort[i]);
				if (totalMilesIn[i] != null)
					model.setTotalMilesIn(totalMilesIn[i]);
				if (skedStartZd[i] != null)
					model.setSkedStartZd(skedStartZd[i]);
				if (revVessel[i] != null)
					model.setRevVessel(revVessel[i]);
				if (eeoiBsa[i] != null)
					model.setEeoiBsa(eeoiBsa[i]);
				if (eeoiOc[i] != null)
					model.setEeoiOc(eeoiOc[i]);
				if (pfTtlTime[i] != null)
					model.setPfTtlTime(pfTtlTime[i]);
				if (pfDistance[i] != null)
					model.setPfDistance(pfDistance[i]);
				if (pfSeaTime[i] != null)
					model.setPfSeaTime(pfSeaTime[i]);
				if (revVoyno[i] != null)
					model.setRevVoyno(revVoyno[i]);
				if (totalObsMile[i] != null)
					model.setTotalObsMile(totalObsMile[i]);
				if (pfManuOut[i] != null)
					model.setPfManuOut(pfManuOut[i]);
				if (pfPortTime[i] != null)
					model.setPfPortTime(pfPortTime[i]);
				if (pfManuIn[i] != null)
					model.setPfManuIn(pfManuIn[i]);
				if (totalPortDo[i] != null)
					model.setTotalPortDo(totalPortDo[i]);
				if (conSea[i] != null)
					model.setConSea(conSea[i]);
				if (pfType[i] != null)
					model.setPfType(pfType[i]);
				if (revDoQty[i] != null)
					model.setRevDoQty(revDoQty[i]);
				if (pfCspeed[i] != null)
					model.setPfCspeed(pfCspeed[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalMilesEng[i] != null)
					model.setTotalMilesEng(totalMilesEng[i]);
				if (totalMilesOut[i] != null)
					model.setTotalMilesOut(totalMilesOut[i]);
				if (skedEndPort[i] != null)
					model.setSkedEndPort(skedEndPort[i]);
				if (pfSpd[i] != null)
					model.setPfSpd(pfSpd[i]);
				if (skedStartEta[i] != null)
					model.setSkedStartEta(skedStartEta[i]);
				if (totalAverSpd[i] != null)
					model.setTotalAverSpd(totalAverSpd[i]);
				if (eeoiGubun[i] != null)
					model.setEeoiGubun(eeoiGubun[i]);
				if (revLane[i] != null)
					model.setRevLane(revLane[i]);
				if (revDoAmnt[i] != null)
					model.setRevDoAmnt(revDoAmnt[i]);
				if (conPort[i] != null)
					model.setConPort(conPort[i]);
				if (revTrade[i] != null)
					model.setRevTrade(revTrade[i]);
				if (eeoiCalBsa[i] != null)
					model.setEeoiCalBsa(eeoiCalBsa[i]);
				if (eeoiCalDcapa[i] != null)
					model.setEeoiCalDcapa(eeoiCalDcapa[i]);
				if (revFoPrice[i] != null)
					model.setRevFoPrice(revFoPrice[i]);
				if (skedEndZd[i] != null)
					model.setSkedEndZd(skedEndZd[i]);
				if (totalMiles[i] != null)
					model.setTotalMiles(totalMiles[i]);
				if (pfBufferTime[i] != null)
					model.setPfBufferTime(pfBufferTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TestVO[]
	 */
	public FcmMasterTableInquiryVO[] getTestVOs(){
		FcmMasterTableInquiryVO[] vos = (FcmMasterTableInquiryVO[])models.toArray(new FcmMasterTableInquiryVO[models.size()]);
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
		this.revFoAmnt = this.revFoAmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSailTime = this.totalSailTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDoPrice = this.revDoPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMonth = this.revMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDir = this.revDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYear = this.revYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeoiDcapa = this.eeoiDcapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedVoyage = this.skedVoyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedEndEta = this.skedEndEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revFoQty = this.revFoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conFoDo = this.conFoDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPortFo = this.totalPortFo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedStartPort = this.skedStartPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMilesIn = this.totalMilesIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedStartZd = this.skedStartZd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVessel = this.revVessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeoiBsa = this.eeoiBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeoiOc = this.eeoiOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfTtlTime = this.pfTtlTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfDistance = this.pfDistance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSeaTime = this.pfSeaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVoyno = this.revVoyno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalObsMile = this.totalObsMile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfManuOut = this.pfManuOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfPortTime = this.pfPortTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfManuIn = this.pfManuIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalPortDo = this.totalPortDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conSea = this.conSea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfType = this.pfType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDoQty = this.revDoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfCspeed = this.pfCspeed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMilesEng = this.totalMilesEng .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMilesOut = this.totalMilesOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedEndPort = this.skedEndPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSpd = this.pfSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedStartEta = this.skedStartEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAverSpd = this.totalAverSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeoiGubun = this.eeoiGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revLane = this.revLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDoAmnt = this.revDoAmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conPort = this.conPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTrade = this.revTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeoiCalBsa = this.eeoiCalBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeoiCalDcapa = this.eeoiCalDcapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revFoPrice = this.revFoPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skedEndZd = this.skedEndZd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMiles = this.totalMiles .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfBufferTime = this.pfBufferTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
