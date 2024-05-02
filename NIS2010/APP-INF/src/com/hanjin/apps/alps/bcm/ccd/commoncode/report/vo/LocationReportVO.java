/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LocationReportVO.java
*@FileTitle : LocationReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.22  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LocationReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LocationReportVO> models = new ArrayList<LocationReportVO>();
	
	/* Column Info */
	private String lonUtCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String gmtHrs = null;
	/* Column Info */
	private String unLocCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String cmlZnFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locAmsPortCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String locChrCd = null;
	/* Column Info */
	private String locLoclLangNm = null;
	/* Column Info */
	private String repZnCd = null;
	/* Column Info */
	private String callPortFlg = null;
	/* Column Info */
	private String unLocIndCd = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String latUtCd = null;
	/* Column Info */
	private String locGrdNo = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String eqRtnYdCd = null;
	/* Column Info */
	private String locLon = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String portInlndFlg = null;
	/* Column Info */
	private String fincCtrlOfcCd = null;
	/* Column Info */
	private String locLat = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String locTpCd = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Column Info */
	private String modiLocCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LocationReportVO() {}

	public LocationReportVO(String ibflag, String pagerows, String locCd, String locNm, String locLoclLangNm, String locChrCd, String callPortFlg, String portInlndFlg, String locTpCd, String contiCd, String scontiCd, String cntCd, String rgnCd, String steCd, String sccCd, String repZnCd, String unLocIndCd, String unLocCd, String slsOfcCd, String eqCtrlOfcCd, String fincCtrlOfcCd, String mtyPkupYdCd, String eqRtnYdCd, String hubLocCd, String locGrdNo, String zipCd, String gmtHrs, String locAmsPortCd, String cstmsCd, String cmlZnFlg, String locLat, String latUtCd, String locLon, String lonUtCd, String deltFlg, String modiLocCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.lonUtCd = lonUtCd;
		this.contiCd = contiCd;
		this.rgnCd = rgnCd;
		this.gmtHrs = gmtHrs;
		this.unLocCd = unLocCd;
		this.deltFlg = deltFlg;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.cstmsCd = cstmsCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.cmlZnFlg = cmlZnFlg;
		this.pagerows = pagerows;
		this.locAmsPortCd = locAmsPortCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.slsOfcCd = slsOfcCd;
		this.locChrCd = locChrCd;
		this.locLoclLangNm = locLoclLangNm;
		this.repZnCd = repZnCd;
		this.callPortFlg = callPortFlg;
		this.unLocIndCd = unLocIndCd;
		this.locNm = locNm;
		this.latUtCd = latUtCd;
		this.locGrdNo = locGrdNo;
		this.sccCd = sccCd;
		this.eqRtnYdCd = eqRtnYdCd;
		this.locLon = locLon;
		this.zipCd = zipCd;
		this.portInlndFlg = portInlndFlg;
		this.fincCtrlOfcCd = fincCtrlOfcCd;
		this.locLat = locLat;
		this.steCd = steCd;
		this.locTpCd = locTpCd;
		this.hubLocCd = hubLocCd;
		this.scontiCd = scontiCd;
		this.modiLocCd = modiLocCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lon_ut_cd", getLonUtCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("gmt_hrs", getGmtHrs());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("cml_zn_flg", getCmlZnFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_ams_port_cd", getLocAmsPortCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("loc_chr_cd", getLocChrCd());
		this.hashColumns.put("loc_locl_lang_nm", getLocLoclLangNm());
		this.hashColumns.put("rep_zn_cd", getRepZnCd());
		this.hashColumns.put("call_port_flg", getCallPortFlg());
		this.hashColumns.put("un_loc_ind_cd", getUnLocIndCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("lat_ut_cd", getLatUtCd());
		this.hashColumns.put("loc_grd_no", getLocGrdNo());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("eq_rtn_yd_cd", getEqRtnYdCd());
		this.hashColumns.put("loc_lon", getLocLon());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("port_inlnd_flg", getPortInlndFlg());
		this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
		this.hashColumns.put("loc_lat", getLocLat());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("modi_loc_cd", getModiLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lon_ut_cd", "lonUtCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("gmt_hrs", "gmtHrs");
		this.hashFields.put("un_loc_cd", "unLocCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("cml_zn_flg", "cmlZnFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_ams_port_cd", "locAmsPortCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("loc_chr_cd", "locChrCd");
		this.hashFields.put("loc_locl_lang_nm", "locLoclLangNm");
		this.hashFields.put("rep_zn_cd", "repZnCd");
		this.hashFields.put("call_port_flg", "callPortFlg");
		this.hashFields.put("un_loc_ind_cd", "unLocIndCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("lat_ut_cd", "latUtCd");
		this.hashFields.put("loc_grd_no", "locGrdNo");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("eq_rtn_yd_cd", "eqRtnYdCd");
		this.hashFields.put("loc_lon", "locLon");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("port_inlnd_flg", "portInlndFlg");
		this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
		this.hashFields.put("loc_lat", "locLat");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("modi_loc_cd", "modiLocCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lonUtCd
	 */
	public String getLonUtCd() {
		return this.lonUtCd;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return gmtHrs
	 */
	public String getGmtHrs() {
		return this.gmtHrs;
	}
	
	/**
	 * Column Info
	 * @return unLocCd
	 */
	public String getUnLocCd() {
		return this.unLocCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return cmlZnFlg
	 */
	public String getCmlZnFlg() {
		return this.cmlZnFlg;
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
	 * @return locAmsPortCd
	 */
	public String getLocAmsPortCd() {
		return this.locAmsPortCd;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return locChrCd
	 */
	public String getLocChrCd() {
		return this.locChrCd;
	}
	
	/**
	 * Column Info
	 * @return locLoclLangNm
	 */
	public String getLocLoclLangNm() {
		return this.locLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @return repZnCd
	 */
	public String getRepZnCd() {
		return this.repZnCd;
	}
	
	/**
	 * Column Info
	 * @return callPortFlg
	 */
	public String getCallPortFlg() {
		return this.callPortFlg;
	}
	
	/**
	 * Column Info
	 * @return unLocIndCd
	 */
	public String getUnLocIndCd() {
		return this.unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return latUtCd
	 */
	public String getLatUtCd() {
		return this.latUtCd;
	}
	
	/**
	 * Column Info
	 * @return locGrdNo
	 */
	public String getLocGrdNo() {
		return this.locGrdNo;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return eqRtnYdCd
	 */
	public String getEqRtnYdCd() {
		return this.eqRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return locLon
	 */
	public String getLocLon() {
		return this.locLon;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return portInlndFlg
	 */
	public String getPortInlndFlg() {
		return this.portInlndFlg;
	}
	
	/**
	 * Column Info
	 * @return fincCtrlOfcCd
	 */
	public String getFincCtrlOfcCd() {
		return this.fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return locLat
	 */
	public String getLocLat() {
		return this.locLat;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}

	/**
	 * Column Info
	 * @return modiLocCd
	 */
	public String getModiLocCd() {
		return this.modiLocCd;
	}

	/**
	 * Column Info
	 * @param lonUtCd
	 */
	public void setLonUtCd(String lonUtCd) {
		this.lonUtCd = lonUtCd;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param gmtHrs
	 */
	public void setGmtHrs(String gmtHrs) {
		this.gmtHrs = gmtHrs;
	}
	
	/**
	 * Column Info
	 * @param unLocCd
	 */
	public void setUnLocCd(String unLocCd) {
		this.unLocCd = unLocCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param cmlZnFlg
	 */
	public void setCmlZnFlg(String cmlZnFlg) {
		this.cmlZnFlg = cmlZnFlg;
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
	 * @param locAmsPortCd
	 */
	public void setLocAmsPortCd(String locAmsPortCd) {
		this.locAmsPortCd = locAmsPortCd;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param locChrCd
	 */
	public void setLocChrCd(String locChrCd) {
		this.locChrCd = locChrCd;
	}
	
	/**
	 * Column Info
	 * @param locLoclLangNm
	 */
	public void setLocLoclLangNm(String locLoclLangNm) {
		this.locLoclLangNm = locLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @param repZnCd
	 */
	public void setRepZnCd(String repZnCd) {
		this.repZnCd = repZnCd;
	}
	
	/**
	 * Column Info
	 * @param callPortFlg
	 */
	public void setCallPortFlg(String callPortFlg) {
		this.callPortFlg = callPortFlg;
	}
	
	/**
	 * Column Info
	 * @param unLocIndCd
	 */
	public void setUnLocIndCd(String unLocIndCd) {
		this.unLocIndCd = unLocIndCd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param latUtCd
	 */
	public void setLatUtCd(String latUtCd) {
		this.latUtCd = latUtCd;
	}
	
	/**
	 * Column Info
	 * @param locGrdNo
	 */
	public void setLocGrdNo(String locGrdNo) {
		this.locGrdNo = locGrdNo;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param eqRtnYdCd
	 */
	public void setEqRtnYdCd(String eqRtnYdCd) {
		this.eqRtnYdCd = eqRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param locLon
	 */
	public void setLocLon(String locLon) {
		this.locLon = locLon;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param portInlndFlg
	 */
	public void setPortInlndFlg(String portInlndFlg) {
		this.portInlndFlg = portInlndFlg;
	}
	
	/**
	 * Column Info
	 * @param fincCtrlOfcCd
	 */
	public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
		this.fincCtrlOfcCd = fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param locLat
	 */
	public void setLocLat(String locLat) {
		this.locLat = locLat;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Column Info
	 * @param modiLocCd
	 */
	public void setModiLocCd(String modiLocCd) {
		this.modiLocCd = modiLocCd;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setLonUtCd(JSPUtil.getParameter(request, prefix + "lon_ut_cd", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setGmtHrs(JSPUtil.getParameter(request, prefix + "gmt_hrs", ""));
		setUnLocCd(JSPUtil.getParameter(request, prefix + "un_loc_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setCstmsCd(JSPUtil.getParameter(request, prefix + "cstms_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setCmlZnFlg(JSPUtil.getParameter(request, prefix + "cml_zn_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocAmsPortCd(JSPUtil.getParameter(request, prefix + "loc_ams_port_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setLocChrCd(JSPUtil.getParameter(request, prefix + "loc_chr_cd", ""));
		setLocLoclLangNm(JSPUtil.getParameter(request, prefix + "loc_locl_lang_nm", ""));
		setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
		setCallPortFlg(JSPUtil.getParameter(request, prefix + "call_port_flg", ""));
		setUnLocIndCd(JSPUtil.getParameter(request, prefix + "un_loc_ind_cd", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setLatUtCd(JSPUtil.getParameter(request, prefix + "lat_ut_cd", ""));
		setLocGrdNo(JSPUtil.getParameter(request, prefix + "loc_grd_no", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setEqRtnYdCd(JSPUtil.getParameter(request, prefix + "eq_rtn_yd_cd", ""));
		setLocLon(JSPUtil.getParameter(request, prefix + "loc_lon", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setPortInlndFlg(JSPUtil.getParameter(request, prefix + "port_inlnd_flg", ""));
		setFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "finc_ctrl_ofc_cd", ""));
		setLocLat(JSPUtil.getParameter(request, prefix + "loc_lat", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
		setModiLocCd(JSPUtil.getParameter(request, prefix + "modi_loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationReportVO[]
	 */
	public LocationReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LocationReportVO[]
	 */
	public LocationReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lonUtCd = (JSPUtil.getParameter(request, prefix	+ "lon_ut_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] gmtHrs = (JSPUtil.getParameter(request, prefix	+ "gmt_hrs", length));
			String[] unLocCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] cmlZnFlg = (JSPUtil.getParameter(request, prefix	+ "cml_zn_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locAmsPortCd = (JSPUtil.getParameter(request, prefix	+ "loc_ams_port_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] locChrCd = (JSPUtil.getParameter(request, prefix	+ "loc_chr_cd", length));
			String[] locLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "loc_locl_lang_nm", length));
			String[] repZnCd = (JSPUtil.getParameter(request, prefix	+ "rep_zn_cd", length));
			String[] callPortFlg = (JSPUtil.getParameter(request, prefix	+ "call_port_flg", length));
			String[] unLocIndCd = (JSPUtil.getParameter(request, prefix	+ "un_loc_ind_cd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] latUtCd = (JSPUtil.getParameter(request, prefix	+ "lat_ut_cd", length));
			String[] locGrdNo = (JSPUtil.getParameter(request, prefix	+ "loc_grd_no", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] eqRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "eq_rtn_yd_cd", length));
			String[] locLon = (JSPUtil.getParameter(request, prefix	+ "loc_lon", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] portInlndFlg = (JSPUtil.getParameter(request, prefix	+ "port_inlnd_flg", length));
			String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ctrl_ofc_cd", length));
			String[] locLat = (JSPUtil.getParameter(request, prefix	+ "loc_lat", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] modiLocCd = (JSPUtil.getParameter(request, prefix	+ "modi_loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new LocationReportVO();
				if (lonUtCd[i] != null)
					model.setLonUtCd(lonUtCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (gmtHrs[i] != null)
					model.setGmtHrs(gmtHrs[i]);
				if (unLocCd[i] != null)
					model.setUnLocCd(unLocCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (cmlZnFlg[i] != null)
					model.setCmlZnFlg(cmlZnFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locAmsPortCd[i] != null)
					model.setLocAmsPortCd(locAmsPortCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (locChrCd[i] != null)
					model.setLocChrCd(locChrCd[i]);
				if (locLoclLangNm[i] != null)
					model.setLocLoclLangNm(locLoclLangNm[i]);
				if (repZnCd[i] != null)
					model.setRepZnCd(repZnCd[i]);
				if (callPortFlg[i] != null)
					model.setCallPortFlg(callPortFlg[i]);
				if (unLocIndCd[i] != null)
					model.setUnLocIndCd(unLocIndCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (latUtCd[i] != null)
					model.setLatUtCd(latUtCd[i]);
				if (locGrdNo[i] != null)
					model.setLocGrdNo(locGrdNo[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (eqRtnYdCd[i] != null)
					model.setEqRtnYdCd(eqRtnYdCd[i]);
				if (locLon[i] != null)
					model.setLocLon(locLon[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (portInlndFlg[i] != null)
					model.setPortInlndFlg(portInlndFlg[i]);
				if (fincCtrlOfcCd[i] != null)
					model.setFincCtrlOfcCd(fincCtrlOfcCd[i]);
				if (locLat[i] != null)
					model.setLocLat(locLat[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (modiLocCd[i] != null)
					model.setModiLocCd(modiLocCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationReportVO[]
	 */
	public LocationReportVO[] getLocationReportVOs(){
		LocationReportVO[] vos = (LocationReportVO[])models.toArray(new LocationReportVO[models.size()]);
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
		this.lonUtCd = this.lonUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtHrs = this.gmtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd = this.unLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmlZnFlg = this.cmlZnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmsPortCd = this.locAmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChrCd = this.locChrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLoclLangNm = this.locLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repZnCd = this.repZnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callPortFlg = this.callPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocIndCd = this.unLocIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.latUtCd = this.latUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrdNo = this.locGrdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRtnYdCd = this.eqRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLon = this.locLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInlndFlg = this.portInlndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincCtrlOfcCd = this.fincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLat = this.locLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiLocCd = this.modiLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
