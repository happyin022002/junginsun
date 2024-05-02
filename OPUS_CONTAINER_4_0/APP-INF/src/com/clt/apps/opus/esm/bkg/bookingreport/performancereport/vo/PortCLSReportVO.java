/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortCLSReportVO.java
*@FileTitle : PortCLSReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.05.12 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortCLSReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortCLSReportVO> models = new ArrayList<PortCLSReportVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String bkTotCnt = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String cnBalanceCnt = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String brhCfmIndNm = null;
	/* Column Info */
	private String cntrFirmCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bkChargeCnt = null;
	/* Column Info */
	private String bkPercent = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrBalanceCnt = null;
	/* Column Info */
	private String cnTotCnt = null;
	/* Column Info */
	private String siFlg = null;
	/* Column Info */
	private String rtFirmCnt = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String contBalanceCnt = null;
	/* Column Info */
	private String cnPercent = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dummyFlag = null;
	/* Column Info */
	private String brhCfmInd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String rtPercent = null;
	/* Column Info */
	private String laneInd = null;
	/* Column Info */
	private String contTotCnt = null;
	/* Column Info */
	private String dtType = null;
	/* Column Info */
	private String bkgStf = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkNonChargeCnt = null;
	/* Column Info */
	private String contActCnt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String cntrTotCnt = null;
	/* Column Info */
	private String contDummyCnt = null;
	/* Column Info */
	private String bkgLane = null;
	/* Column Info */
	private String rtNonChargeCnt = null;
	/* Column Info */
	private String cntrPercent = null;
	/* Column Info */
	private String cntrCfmFlg = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String rtTotCnt = null;
	/* Column Info */
	private String contPercent = null;
	/* Column Info */
	private String cnCodeCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortCLSReportVO() {}

	public PortCLSReportVO(String ibflag, String pagerows, String rnum, String bkgNo, String blNo, String shprCd, String shprNm, String polCd, String brhCfmInd, String brhCfmIndNm, String atd, String etd, String vvdCd, String bkgLane, String laneInd, String bkgStsCd, String siFlg, String cneeCd, String cneeNm, String bkgOfcCd, String bkgStf, String ctrtNo, String dummyFlag, String cntrCfmFlg, String scNo, String rfaNo, String taaNo, String rhqCd, String rowsPerPage, String currPage, String totalCnt, String totCnt, String bkTotCnt, String rtTotCnt, String cntrTotCnt, String cnTotCnt, String contTotCnt, String bkChargeCnt, String rtFirmCnt, String cntrFirmCnt, String cnCodeCnt, String contActCnt, String contDummyCnt, String cntrBalanceCnt, String cnBalanceCnt, String contBalanceCnt, String bkNonChargeCnt, String rtNonChargeCnt, String bkPercent, String rtPercent, String cntrPercent, String cnPercent, String contPercent, String reportType, String dtType) {
		this.cneeCd = cneeCd;
		this.bkTotCnt = bkTotCnt;
		this.reportType = reportType;
		this.cnBalanceCnt = cnBalanceCnt;
		this.etd = etd;
		this.blNo = blNo;
		this.brhCfmIndNm = brhCfmIndNm;
		this.cntrFirmCnt = cntrFirmCnt;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.rowsPerPage = rowsPerPage;
		this.currPage = currPage;
		this.vvdCd = vvdCd;
		this.bkChargeCnt = bkChargeCnt;
		this.bkPercent = bkPercent;
		this.rnum = rnum;
		this.scNo = scNo;
		this.cntrBalanceCnt = cntrBalanceCnt;
		this.cnTotCnt = cnTotCnt;
		this.siFlg = siFlg;
		this.rtFirmCnt = rtFirmCnt;
		this.totalCnt = totalCnt;
		this.shprCd = shprCd;
		this.bkgOfcCd = bkgOfcCd;
		this.totCnt = totCnt;
		this.rhqCd = rhqCd;
		this.contBalanceCnt = contBalanceCnt;
		this.cnPercent = cnPercent;
		this.bkgNo = bkgNo;
		this.dummyFlag = dummyFlag;
		this.brhCfmInd = brhCfmInd;
		this.bkgStsCd = bkgStsCd;
		this.rtPercent = rtPercent;
		this.laneInd = laneInd;
		this.contTotCnt = contTotCnt;
		this.dtType = dtType;
		this.bkgStf = bkgStf;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.bkNonChargeCnt = bkNonChargeCnt;
		this.contActCnt = contActCnt;
		this.shprNm = shprNm;
		this.atd = atd;
		this.cntrTotCnt = cntrTotCnt;
		this.contDummyCnt = contDummyCnt;
		this.bkgLane = bkgLane;
		this.rtNonChargeCnt = rtNonChargeCnt;
		this.cntrPercent = cntrPercent;
		this.cntrCfmFlg = cntrCfmFlg;
		this.cneeNm = cneeNm;
		this.taaNo = taaNo;
		this.rtTotCnt = rtTotCnt;
		this.contPercent = contPercent;
		this.cnCodeCnt = cnCodeCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("bk_tot_cnt", getBkTotCnt());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("cn_balance_cnt", getCnBalanceCnt());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("brh_cfm_ind_nm", getBrhCfmIndNm());
		this.hashColumns.put("cntr_firm_cnt", getCntrFirmCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bk_charge_cnt", getBkChargeCnt());
		this.hashColumns.put("bk_percent", getBkPercent());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_balance_cnt", getCntrBalanceCnt());
		this.hashColumns.put("cn_tot_cnt", getCnTotCnt());
		this.hashColumns.put("si_flg", getSiFlg());
		this.hashColumns.put("rt_firm_cnt", getRtFirmCnt());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cont_balance_cnt", getContBalanceCnt());
		this.hashColumns.put("cn_percent", getCnPercent());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dummy_flag", getDummyFlag());
		this.hashColumns.put("brh_cfm_ind", getBrhCfmInd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("rt_percent", getRtPercent());
		this.hashColumns.put("lane_ind", getLaneInd());
		this.hashColumns.put("cont_tot_cnt", getContTotCnt());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("bkg_stf", getBkgStf());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bk_non_charge_cnt", getBkNonChargeCnt());
		this.hashColumns.put("cont_act_cnt", getContActCnt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("cntr_tot_cnt", getCntrTotCnt());
		this.hashColumns.put("cont_dummy_cnt", getContDummyCnt());
		this.hashColumns.put("bkg_lane", getBkgLane());
		this.hashColumns.put("rt_non_charge_cnt", getRtNonChargeCnt());
		this.hashColumns.put("cntr_percent", getCntrPercent());
		this.hashColumns.put("cntr_cfm_flg", getCntrCfmFlg());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("rt_tot_cnt", getRtTotCnt());
		this.hashColumns.put("cont_percent", getContPercent());
		this.hashColumns.put("cn_code_cnt", getCnCodeCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("bk_tot_cnt", "bkTotCnt");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("cn_balance_cnt", "cnBalanceCnt");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("brh_cfm_ind_nm", "brhCfmIndNm");
		this.hashFields.put("cntr_firm_cnt", "cntrFirmCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bk_charge_cnt", "bkChargeCnt");
		this.hashFields.put("bk_percent", "bkPercent");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_balance_cnt", "cntrBalanceCnt");
		this.hashFields.put("cn_tot_cnt", "cnTotCnt");
		this.hashFields.put("si_flg", "siFlg");
		this.hashFields.put("rt_firm_cnt", "rtFirmCnt");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cont_balance_cnt", "contBalanceCnt");
		this.hashFields.put("cn_percent", "cnPercent");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dummy_flag", "dummyFlag");
		this.hashFields.put("brh_cfm_ind", "brhCfmInd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("rt_percent", "rtPercent");
		this.hashFields.put("lane_ind", "laneInd");
		this.hashFields.put("cont_tot_cnt", "contTotCnt");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("bkg_stf", "bkgStf");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bk_non_charge_cnt", "bkNonChargeCnt");
		this.hashFields.put("cont_act_cnt", "contActCnt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("cntr_tot_cnt", "cntrTotCnt");
		this.hashFields.put("cont_dummy_cnt", "contDummyCnt");
		this.hashFields.put("bkg_lane", "bkgLane");
		this.hashFields.put("rt_non_charge_cnt", "rtNonChargeCnt");
		this.hashFields.put("cntr_percent", "cntrPercent");
		this.hashFields.put("cntr_cfm_flg", "cntrCfmFlg");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("rt_tot_cnt", "rtTotCnt");
		this.hashFields.put("cont_percent", "contPercent");
		this.hashFields.put("cn_code_cnt", "cnCodeCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return bkTotCnt
	 */
	public String getBkTotCnt() {
		return this.bkTotCnt;
	}
	
	/**
	 * Column Info
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
	}
	
	/**
	 * Column Info
	 * @return cnBalanceCnt
	 */
	public String getCnBalanceCnt() {
		return this.cnBalanceCnt;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return brhCfmIndNm
	 */
	public String getBrhCfmIndNm() {
		return this.brhCfmIndNm;
	}
	
	/**
	 * Column Info
	 * @return cntrFirmCnt
	 */
	public String getCntrFirmCnt() {
		return this.cntrFirmCnt;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
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
	 * @return bkChargeCnt
	 */
	public String getBkChargeCnt() {
		return this.bkChargeCnt;
	}
	
	/**
	 * Column Info
	 * @return bkPercent
	 */
	public String getBkPercent() {
		return this.bkPercent;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrBalanceCnt
	 */
	public String getCntrBalanceCnt() {
		return this.cntrBalanceCnt;
	}
	
	/**
	 * Column Info
	 * @return cnTotCnt
	 */
	public String getCnTotCnt() {
		return this.cnTotCnt;
	}
	
	/**
	 * Column Info
	 * @return siFlg
	 */
	public String getSiFlg() {
		return this.siFlg;
	}
	
	/**
	 * Column Info
	 * @return rtFirmCnt
	 */
	public String getRtFirmCnt() {
		return this.rtFirmCnt;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return contBalanceCnt
	 */
	public String getContBalanceCnt() {
		return this.contBalanceCnt;
	}
	
	/**
	 * Column Info
	 * @return cnPercent
	 */
	public String getCnPercent() {
		return this.cnPercent;
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
	 * @return dummyFlag
	 */
	public String getDummyFlag() {
		return this.dummyFlag;
	}
	
	/**
	 * Column Info
	 * @return brhCfmInd
	 */
	public String getBrhCfmInd() {
		return this.brhCfmInd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return rtPercent
	 */
	public String getRtPercent() {
		return this.rtPercent;
	}
	
	/**
	 * Column Info
	 * @return laneInd
	 */
	public String getLaneInd() {
		return this.laneInd;
	}
	
	/**
	 * Column Info
	 * @return contTotCnt
	 */
	public String getContTotCnt() {
		return this.contTotCnt;
	}
	
	/**
	 * Column Info
	 * @return dtType
	 */
	public String getDtType() {
		return this.dtType;
	}
	
	/**
	 * Column Info
	 * @return bkgStf
	 */
	public String getBkgStf() {
		return this.bkgStf;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return bkNonChargeCnt
	 */
	public String getBkNonChargeCnt() {
		return this.bkNonChargeCnt;
	}
	
	/**
	 * Column Info
	 * @return contActCnt
	 */
	public String getContActCnt() {
		return this.contActCnt;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return cntrTotCnt
	 */
	public String getCntrTotCnt() {
		return this.cntrTotCnt;
	}
	
	/**
	 * Column Info
	 * @return contDummyCnt
	 */
	public String getContDummyCnt() {
		return this.contDummyCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgLane
	 */
	public String getBkgLane() {
		return this.bkgLane;
	}
	
	/**
	 * Column Info
	 * @return rtNonChargeCnt
	 */
	public String getRtNonChargeCnt() {
		return this.rtNonChargeCnt;
	}
	
	/**
	 * Column Info
	 * @return cntrPercent
	 */
	public String getCntrPercent() {
		return this.cntrPercent;
	}
	
	/**
	 * Column Info
	 * @return cntrCfmFlg
	 */
	public String getCntrCfmFlg() {
		return this.cntrCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return rtTotCnt
	 */
	public String getRtTotCnt() {
		return this.rtTotCnt;
	}
	
	/**
	 * Column Info
	 * @return contPercent
	 */
	public String getContPercent() {
		return this.contPercent;
	}
	
	/**
	 * Column Info
	 * @return cnCodeCnt
	 */
	public String getCnCodeCnt() {
		return this.cnCodeCnt;
	}
	

	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param bkTotCnt
	 */
	public void setBkTotCnt(String bkTotCnt) {
		this.bkTotCnt = bkTotCnt;
	}
	
	/**
	 * Column Info
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * Column Info
	 * @param cnBalanceCnt
	 */
	public void setCnBalanceCnt(String cnBalanceCnt) {
		this.cnBalanceCnt = cnBalanceCnt;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param brhCfmIndNm
	 */
	public void setBrhCfmIndNm(String brhCfmIndNm) {
		this.brhCfmIndNm = brhCfmIndNm;
	}
	
	/**
	 * Column Info
	 * @param cntrFirmCnt
	 */
	public void setCntrFirmCnt(String cntrFirmCnt) {
		this.cntrFirmCnt = cntrFirmCnt;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
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
	 * @param bkChargeCnt
	 */
	public void setBkChargeCnt(String bkChargeCnt) {
		this.bkChargeCnt = bkChargeCnt;
	}
	
	/**
	 * Column Info
	 * @param bkPercent
	 */
	public void setBkPercent(String bkPercent) {
		this.bkPercent = bkPercent;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntrBalanceCnt
	 */
	public void setCntrBalanceCnt(String cntrBalanceCnt) {
		this.cntrBalanceCnt = cntrBalanceCnt;
	}
	
	/**
	 * Column Info
	 * @param cnTotCnt
	 */
	public void setCnTotCnt(String cnTotCnt) {
		this.cnTotCnt = cnTotCnt;
	}
	
	/**
	 * Column Info
	 * @param siFlg
	 */
	public void setSiFlg(String siFlg) {
		this.siFlg = siFlg;
	}
	
	/**
	 * Column Info
	 * @param rtFirmCnt
	 */
	public void setRtFirmCnt(String rtFirmCnt) {
		this.rtFirmCnt = rtFirmCnt;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param contBalanceCnt
	 */
	public void setContBalanceCnt(String contBalanceCnt) {
		this.contBalanceCnt = contBalanceCnt;
	}
	
	/**
	 * Column Info
	 * @param cnPercent
	 */
	public void setCnPercent(String cnPercent) {
		this.cnPercent = cnPercent;
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
	 * @param dummyFlag
	 */
	public void setDummyFlag(String dummyFlag) {
		this.dummyFlag = dummyFlag;
	}
	
	/**
	 * Column Info
	 * @param brhCfmInd
	 */
	public void setBrhCfmInd(String brhCfmInd) {
		this.brhCfmInd = brhCfmInd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param rtPercent
	 */
	public void setRtPercent(String rtPercent) {
		this.rtPercent = rtPercent;
	}
	
	/**
	 * Column Info
	 * @param laneInd
	 */
	public void setLaneInd(String laneInd) {
		this.laneInd = laneInd;
	}
	
	/**
	 * Column Info
	 * @param contTotCnt
	 */
	public void setContTotCnt(String contTotCnt) {
		this.contTotCnt = contTotCnt;
	}
	
	/**
	 * Column Info
	 * @param dtType
	 */
	public void setDtType(String dtType) {
		this.dtType = dtType;
	}
	
	/**
	 * Column Info
	 * @param bkgStf
	 */
	public void setBkgStf(String bkgStf) {
		this.bkgStf = bkgStf;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param bkNonChargeCnt
	 */
	public void setBkNonChargeCnt(String bkNonChargeCnt) {
		this.bkNonChargeCnt = bkNonChargeCnt;
	}
	
	/**
	 * Column Info
	 * @param contActCnt
	 */
	public void setContActCnt(String contActCnt) {
		this.contActCnt = contActCnt;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param cntrTotCnt
	 */
	public void setCntrTotCnt(String cntrTotCnt) {
		this.cntrTotCnt = cntrTotCnt;
	}
	
	/**
	 * Column Info
	 * @param contDummyCnt
	 */
	public void setContDummyCnt(String contDummyCnt) {
		this.contDummyCnt = contDummyCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgLane
	 */
	public void setBkgLane(String bkgLane) {
		this.bkgLane = bkgLane;
	}
	
	/**
	 * Column Info
	 * @param rtNonChargeCnt
	 */
	public void setRtNonChargeCnt(String rtNonChargeCnt) {
		this.rtNonChargeCnt = rtNonChargeCnt;
	}
	
	/**
	 * Column Info
	 * @param cntrPercent
	 */
	public void setCntrPercent(String cntrPercent) {
		this.cntrPercent = cntrPercent;
	}
	
	/**
	 * Column Info
	 * @param cntrCfmFlg
	 */
	public void setCntrCfmFlg(String cntrCfmFlg) {
		this.cntrCfmFlg = cntrCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}
	
	/**
	 * Column Info
	 * @param rtTotCnt
	 */
	public void setRtTotCnt(String rtTotCnt) {
		this.rtTotCnt = rtTotCnt;
	}
	
	/**
	 * Column Info
	 * @param contPercent
	 */
	public void setContPercent(String contPercent) {
		this.contPercent = contPercent;
	}
	
	/**
	 * Column Info
	 * @param cnCodeCnt
	 */
	public void setCnCodeCnt(String cnCodeCnt) {
		this.cnCodeCnt = cnCodeCnt;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setBkTotCnt(JSPUtil.getParameter(request, prefix + "bk_tot_cnt", ""));
		setReportType(JSPUtil.getParameter(request, prefix + "report_type", ""));
		setCnBalanceCnt(JSPUtil.getParameter(request, prefix + "cn_balance_cnt", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBrhCfmIndNm(JSPUtil.getParameter(request, prefix + "brh_cfm_ind_nm", ""));
		setCntrFirmCnt(JSPUtil.getParameter(request, prefix + "cntr_firm_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBkChargeCnt(JSPUtil.getParameter(request, prefix + "bk_charge_cnt", ""));
		setBkPercent(JSPUtil.getParameter(request, prefix + "bk_percent", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrBalanceCnt(JSPUtil.getParameter(request, prefix + "cntr_balance_cnt", ""));
		setCnTotCnt(JSPUtil.getParameter(request, prefix + "cn_tot_cnt", ""));
		setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
		setRtFirmCnt(JSPUtil.getParameter(request, prefix + "rt_firm_cnt", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setContBalanceCnt(JSPUtil.getParameter(request, prefix + "cont_balance_cnt", ""));
		setCnPercent(JSPUtil.getParameter(request, prefix + "cn_percent", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDummyFlag(JSPUtil.getParameter(request, prefix + "dummy_flag", ""));
		setBrhCfmInd(JSPUtil.getParameter(request, prefix + "brh_cfm_ind", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setRtPercent(JSPUtil.getParameter(request, prefix + "rt_percent", ""));
		setLaneInd(JSPUtil.getParameter(request, prefix + "lane_ind", ""));
		setContTotCnt(JSPUtil.getParameter(request, prefix + "cont_tot_cnt", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setBkgStf(JSPUtil.getParameter(request, prefix + "bkg_stf", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkNonChargeCnt(JSPUtil.getParameter(request, prefix + "bk_non_charge_cnt", ""));
		setContActCnt(JSPUtil.getParameter(request, prefix + "cont_act_cnt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setCntrTotCnt(JSPUtil.getParameter(request, prefix + "cntr_tot_cnt", ""));
		setContDummyCnt(JSPUtil.getParameter(request, prefix + "cont_dummy_cnt", ""));
		setBkgLane(JSPUtil.getParameter(request, prefix + "bkg_lane", ""));
		setRtNonChargeCnt(JSPUtil.getParameter(request, prefix + "rt_non_charge_cnt", ""));
		setCntrPercent(JSPUtil.getParameter(request, prefix + "cntr_percent", ""));
		setCntrCfmFlg(JSPUtil.getParameter(request, prefix + "cntr_cfm_flg", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setRtTotCnt(JSPUtil.getParameter(request, prefix + "rt_tot_cnt", ""));
		setContPercent(JSPUtil.getParameter(request, prefix + "cont_percent", ""));
		setCnCodeCnt(JSPUtil.getParameter(request, prefix + "cn_code_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortCLSReportVO[]
	 */
	public PortCLSReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortCLSReportVO[]
	 */
	public PortCLSReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortCLSReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] bkTotCnt = (JSPUtil.getParameter(request, prefix	+ "bk_tot_cnt", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] cnBalanceCnt = (JSPUtil.getParameter(request, prefix	+ "cn_balance_cnt", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] brhCfmIndNm = (JSPUtil.getParameter(request, prefix	+ "brh_cfm_ind_nm", length));
			String[] cntrFirmCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_firm_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bkChargeCnt = (JSPUtil.getParameter(request, prefix	+ "bk_charge_cnt", length));
			String[] bkPercent = (JSPUtil.getParameter(request, prefix	+ "bk_percent", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrBalanceCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_balance_cnt", length));
			String[] cnTotCnt = (JSPUtil.getParameter(request, prefix	+ "cn_tot_cnt", length));
			String[] siFlg = (JSPUtil.getParameter(request, prefix	+ "si_flg", length));
			String[] rtFirmCnt = (JSPUtil.getParameter(request, prefix	+ "rt_firm_cnt", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] contBalanceCnt = (JSPUtil.getParameter(request, prefix	+ "cont_balance_cnt", length));
			String[] cnPercent = (JSPUtil.getParameter(request, prefix	+ "cn_percent", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dummyFlag = (JSPUtil.getParameter(request, prefix	+ "dummy_flag", length));
			String[] brhCfmInd = (JSPUtil.getParameter(request, prefix	+ "brh_cfm_ind", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] rtPercent = (JSPUtil.getParameter(request, prefix	+ "rt_percent", length));
			String[] laneInd = (JSPUtil.getParameter(request, prefix	+ "lane_ind", length));
			String[] contTotCnt = (JSPUtil.getParameter(request, prefix	+ "cont_tot_cnt", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] bkgStf = (JSPUtil.getParameter(request, prefix	+ "bkg_stf", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkNonChargeCnt = (JSPUtil.getParameter(request, prefix	+ "bk_non_charge_cnt", length));
			String[] contActCnt = (JSPUtil.getParameter(request, prefix	+ "cont_act_cnt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] cntrTotCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_tot_cnt", length));
			String[] contDummyCnt = (JSPUtil.getParameter(request, prefix	+ "cont_dummy_cnt", length));
			String[] bkgLane = (JSPUtil.getParameter(request, prefix	+ "bkg_lane", length));
			String[] rtNonChargeCnt = (JSPUtil.getParameter(request, prefix	+ "rt_non_charge_cnt", length));
			String[] cntrPercent = (JSPUtil.getParameter(request, prefix	+ "cntr_percent", length));
			String[] cntrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_cfm_flg", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] rtTotCnt = (JSPUtil.getParameter(request, prefix	+ "rt_tot_cnt", length));
			String[] contPercent = (JSPUtil.getParameter(request, prefix	+ "cont_percent", length));
			String[] cnCodeCnt = (JSPUtil.getParameter(request, prefix	+ "cn_code_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortCLSReportVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (bkTotCnt[i] != null)
					model.setBkTotCnt(bkTotCnt[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (cnBalanceCnt[i] != null)
					model.setCnBalanceCnt(cnBalanceCnt[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (brhCfmIndNm[i] != null)
					model.setBrhCfmIndNm(brhCfmIndNm[i]);
				if (cntrFirmCnt[i] != null)
					model.setCntrFirmCnt(cntrFirmCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bkChargeCnt[i] != null)
					model.setBkChargeCnt(bkChargeCnt[i]);
				if (bkPercent[i] != null)
					model.setBkPercent(bkPercent[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrBalanceCnt[i] != null)
					model.setCntrBalanceCnt(cntrBalanceCnt[i]);
				if (cnTotCnt[i] != null)
					model.setCnTotCnt(cnTotCnt[i]);
				if (siFlg[i] != null)
					model.setSiFlg(siFlg[i]);
				if (rtFirmCnt[i] != null)
					model.setRtFirmCnt(rtFirmCnt[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (contBalanceCnt[i] != null)
					model.setContBalanceCnt(contBalanceCnt[i]);
				if (cnPercent[i] != null)
					model.setCnPercent(cnPercent[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dummyFlag[i] != null)
					model.setDummyFlag(dummyFlag[i]);
				if (brhCfmInd[i] != null)
					model.setBrhCfmInd(brhCfmInd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (rtPercent[i] != null)
					model.setRtPercent(rtPercent[i]);
				if (laneInd[i] != null)
					model.setLaneInd(laneInd[i]);
				if (contTotCnt[i] != null)
					model.setContTotCnt(contTotCnt[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (bkgStf[i] != null)
					model.setBkgStf(bkgStf[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkNonChargeCnt[i] != null)
					model.setBkNonChargeCnt(bkNonChargeCnt[i]);
				if (contActCnt[i] != null)
					model.setContActCnt(contActCnt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (cntrTotCnt[i] != null)
					model.setCntrTotCnt(cntrTotCnt[i]);
				if (contDummyCnt[i] != null)
					model.setContDummyCnt(contDummyCnt[i]);
				if (bkgLane[i] != null)
					model.setBkgLane(bkgLane[i]);
				if (rtNonChargeCnt[i] != null)
					model.setRtNonChargeCnt(rtNonChargeCnt[i]);
				if (cntrPercent[i] != null)
					model.setCntrPercent(cntrPercent[i]);
				if (cntrCfmFlg[i] != null)
					model.setCntrCfmFlg(cntrCfmFlg[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (rtTotCnt[i] != null)
					model.setRtTotCnt(rtTotCnt[i]);
				if (contPercent[i] != null)
					model.setContPercent(contPercent[i]);
				if (cnCodeCnt[i] != null)
					model.setCnCodeCnt(cnCodeCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortCLSReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortCLSReportVO[]
	 */
	public PortCLSReportVO[] getPortCLSReportVOs(){
		PortCLSReportVO[] vos = (PortCLSReportVO[])models.toArray(new PortCLSReportVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkTotCnt = this.bkTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnBalanceCnt = this.cnBalanceCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brhCfmIndNm = this.brhCfmIndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFirmCnt = this.cntrFirmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkChargeCnt = this.bkChargeCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkPercent = this.bkPercent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBalanceCnt = this.cntrBalanceCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnTotCnt = this.cnTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siFlg = this.siFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFirmCnt = this.rtFirmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contBalanceCnt = this.contBalanceCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnPercent = this.cnPercent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dummyFlag = this.dummyFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brhCfmInd = this.brhCfmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPercent = this.rtPercent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneInd = this.laneInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contTotCnt = this.contTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStf = this.bkgStf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkNonChargeCnt = this.bkNonChargeCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contActCnt = this.contActCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotCnt = this.cntrTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contDummyCnt = this.contDummyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLane = this.bkgLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtNonChargeCnt = this.rtNonChargeCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPercent = this.cntrPercent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfmFlg = this.cntrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTotCnt = this.rtTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contPercent = this.contPercent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCodeCnt = this.cnCodeCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
