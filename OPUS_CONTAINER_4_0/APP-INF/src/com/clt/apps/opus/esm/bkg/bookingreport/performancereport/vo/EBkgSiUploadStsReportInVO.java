/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBkgSiUploadStsReportInVO.java
*@FileTitle : EBkgSiUploadStsReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.06 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EBkgSiUploadStsReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EBkgSiUploadStsReportInVO> models = new ArrayList<EBkgSiUploadStsReportInVO>();
	
	/* Column Info */
	private String durationMonth = null;
	/* Column Info */
	private String bPf = null;
	/* Column Info */
	private String durationYear = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String lsToDt = null;
	/* Column Info */
	private String docTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bTtl = null;
	/* Column Info */
	private String durationToWeek = null;
	/* Column Info */
	private String lsFromDt = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String gso = null;
	/* Column Info */
	private String mon = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String durationFromDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sTtl = null;
	/* Column Info */
	private String salOfc = null;
	/* Column Info */
	private String delay = null;
	/* Column Info */
	private String sPf = null;
	/* Column Info */
	private String sX = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String sR = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sP = null;
	/* Column Info */
	private String sort = null;
	/* Column Info */
	private String iPageNo = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String sF = null;
	/* Column Info */
	private String bkgUpldStsCd = null;
	/* Column Info */
	private String sD = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String regionCd = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String serverId = null;
	/* Column Info */
	private String durationFromWeek = null;
	/* Column Info */
	private String docTpS = null;
	/* Column Info */
	private String bR = null;
	/* Column Info */
	private String bX = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String bP = null;
	/* Column Info */
	private String durationToDt = null;
	/* Column Info */
	private String bD = null;
	/* Column Info */
	private String docTpB = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String bF = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EBkgSiUploadStsReportInVO() {}

	public EBkgSiUploadStsReportInVO(String ibflag, String pagerows, String regionCd, String gso, String bkgOfc, String mon, String bTtl, String bX, String bF, String bR, String bD, String bP, String bPf, String sTtl, String sX, String sF, String sR, String sD, String sP, String sPf, String sort, String docTpCd, String docTpB, String docTpS, String bkgUpldStsCd, String xterRqstNo, String porCd, String polCd, String podCd, String delCd, String delay, String bkgNo, String lsFromDt, String lsToDt, String serverId, String salOfc, String duration, String frDt, String toDt, String reportType, String durationYear, String durationMonth, String durationFromWeek, String durationToWeek, String durationFromDt, String durationToDt, String totalCnt, String rowNum, String iPageNo) {
		this.durationMonth = durationMonth;
		this.bPf = bPf;
		this.durationYear = durationYear;
		this.reportType = reportType;
		this.lsToDt = lsToDt;
		this.docTpCd = docTpCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.bTtl = bTtl;
		this.durationToWeek = durationToWeek;
		this.lsFromDt = lsFromDt;
		this.totalCnt = totalCnt;
		this.delCd = delCd;
		this.gso = gso;
		this.mon = mon;
		this.podCd = podCd;
		this.toDt = toDt;
		this.durationFromDt = durationFromDt;
		this.bkgNo = bkgNo;
		this.sTtl = sTtl;
		this.salOfc = salOfc;
		this.delay = delay;
		this.sPf = sPf;
		this.sX = sX;
		this.rowNum = rowNum;
		this.sR = sR;
		this.porCd = porCd;
		this.sP = sP;
		this.sort = sort;
		this.iPageNo = iPageNo;
		this.frDt = frDt;
		this.sF = sF;
		this.bkgUpldStsCd = bkgUpldStsCd;
		this.sD = sD;
		this.ibflag = ibflag;
		this.regionCd = regionCd;
		this.bkgOfc = bkgOfc;
		this.serverId = serverId;
		this.durationFromWeek = durationFromWeek;
		this.docTpS = docTpS;
		this.bR = bR;
		this.bX = bX;
		this.duration = duration;
		this.bP = bP;
		this.durationToDt = durationToDt;
		this.bD = bD;
		this.docTpB = docTpB;
		this.xterRqstNo = xterRqstNo;
		this.bF = bF;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("duration_month", getDurationMonth());
		this.hashColumns.put("b_pf", getBPf());
		this.hashColumns.put("duration_year", getDurationYear());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("ls_to_dt", getLsToDt());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("b_ttl", getBTtl());
		this.hashColumns.put("duration_to_week", getDurationToWeek());
		this.hashColumns.put("ls_from_dt", getLsFromDt());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("gso", getGso());
		this.hashColumns.put("mon", getMon());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("duration_from_dt", getDurationFromDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("s_ttl", getSTtl());
		this.hashColumns.put("sal_ofc", getSalOfc());
		this.hashColumns.put("delay", getDelay());
		this.hashColumns.put("s_pf", getSPf());
		this.hashColumns.put("s_x", getSX());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("s_r", getSR());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_p", getSP());
		this.hashColumns.put("sort", getSort());
		this.hashColumns.put("i_page_no", getIPageNo());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("s_f", getSF());
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
		this.hashColumns.put("s_d", getSD());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("region_cd", getRegionCd());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("server_id", getServerId());
		this.hashColumns.put("duration_from_week", getDurationFromWeek());
		this.hashColumns.put("doc_tp_s", getDocTpS());
		this.hashColumns.put("b_r", getBR());
		this.hashColumns.put("b_x", getBX());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("b_p", getBP());
		this.hashColumns.put("duration_to_dt", getDurationToDt());
		this.hashColumns.put("b_d", getBD());
		this.hashColumns.put("doc_tp_b", getDocTpB());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("b_f", getBF());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("duration_month", "durationMonth");
		this.hashFields.put("b_pf", "bPf");
		this.hashFields.put("duration_year", "durationYear");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("ls_to_dt", "lsToDt");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("b_ttl", "bTtl");
		this.hashFields.put("duration_to_week", "durationToWeek");
		this.hashFields.put("ls_from_dt", "lsFromDt");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("gso", "gso");
		this.hashFields.put("mon", "mon");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("duration_from_dt", "durationFromDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("s_ttl", "sTtl");
		this.hashFields.put("sal_ofc", "salOfc");
		this.hashFields.put("delay", "delay");
		this.hashFields.put("s_pf", "sPf");
		this.hashFields.put("s_x", "sX");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("s_r", "sR");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_p", "sP");
		this.hashFields.put("sort", "sort");
		this.hashFields.put("i_page_no", "iPageNo");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("s_f", "sF");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("s_d", "sD");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("region_cd", "regionCd");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("server_id", "serverId");
		this.hashFields.put("duration_from_week", "durationFromWeek");
		this.hashFields.put("doc_tp_s", "docTpS");
		this.hashFields.put("b_r", "bR");
		this.hashFields.put("b_x", "bX");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("b_p", "bP");
		this.hashFields.put("duration_to_dt", "durationToDt");
		this.hashFields.put("b_d", "bD");
		this.hashFields.put("doc_tp_b", "docTpB");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("b_f", "bF");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return durationMonth
	 */
	public String getDurationMonth() {
		return this.durationMonth;
	}
	
	/**
	 * Column Info
	 * @return bPf
	 */
	public String getBPf() {
		return this.bPf;
	}
	
	/**
	 * Column Info
	 * @return durationYear
	 */
	public String getDurationYear() {
		return this.durationYear;
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
	 * @return lsToDt
	 */
	public String getLsToDt() {
		return this.lsToDt;
	}
	
	/**
	 * Column Info
	 * @return docTpCd
	 */
	public String getDocTpCd() {
		return this.docTpCd;
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
	 * Column Info
	 * @return bTtl
	 */
	public String getBTtl() {
		return this.bTtl;
	}
	
	/**
	 * Column Info
	 * @return durationToWeek
	 */
	public String getDurationToWeek() {
		return this.durationToWeek;
	}
	
	/**
	 * Column Info
	 * @return lsFromDt
	 */
	public String getLsFromDt() {
		return this.lsFromDt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return gso
	 */
	public String getGso() {
		return this.gso;
	}
	
	/**
	 * Column Info
	 * @return mon
	 */
	public String getMon() {
		return this.mon;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return durationFromDt
	 */
	public String getDurationFromDt() {
		return this.durationFromDt;
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
	 * @return sTtl
	 */
	public String getSTtl() {
		return this.sTtl;
	}
	
	/**
	 * Column Info
	 * @return salOfc
	 */
	public String getSalOfc() {
		return this.salOfc;
	}
	
	/**
	 * Column Info
	 * @return delay
	 */
	public String getDelay() {
		return this.delay;
	}
	
	/**
	 * Column Info
	 * @return sPf
	 */
	public String getSPf() {
		return this.sPf;
	}
	
	/**
	 * Column Info
	 * @return sX
	 */
	public String getSX() {
		return this.sX;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return sR
	 */
	public String getSR() {
		return this.sR;
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
	 * @return sP
	 */
	public String getSP() {
		return this.sP;
	}
	
	/**
	 * Column Info
	 * @return sort
	 */
	public String getSort() {
		return this.sort;
	}
	
	/**
	 * Column Info
	 * @return iPageNo
	 */
	public String getIPageNo() {
		return this.iPageNo;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return sF
	 */
	public String getSF() {
		return this.sF;
	}
	
	/**
	 * Column Info
	 * @return bkgUpldStsCd
	 */
	public String getBkgUpldStsCd() {
		return this.bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @return sD
	 */
	public String getSD() {
		return this.sD;
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
	 * @return regionCd
	 */
	public String getRegionCd() {
		return this.regionCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return serverId
	 */
	public String getServerId() {
		return this.serverId;
	}
	
	/**
	 * Column Info
	 * @return durationFromWeek
	 */
	public String getDurationFromWeek() {
		return this.durationFromWeek;
	}
	
	/**
	 * Column Info
	 * @return docTpS
	 */
	public String getDocTpS() {
		return this.docTpS;
	}
	
	/**
	 * Column Info
	 * @return bR
	 */
	public String getBR() {
		return this.bR;
	}
	
	/**
	 * Column Info
	 * @return bX
	 */
	public String getBX() {
		return this.bX;
	}
	
	/**
	 * Column Info
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return bP
	 */
	public String getBP() {
		return this.bP;
	}
	
	/**
	 * Column Info
	 * @return durationToDt
	 */
	public String getDurationToDt() {
		return this.durationToDt;
	}
	
	/**
	 * Column Info
	 * @return bD
	 */
	public String getBD() {
		return this.bD;
	}
	
	/**
	 * Column Info
	 * @return docTpB
	 */
	public String getDocTpB() {
		return this.docTpB;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return bF
	 */
	public String getBF() {
		return this.bF;
	}
	

	/**
	 * Column Info
	 * @param durationMonth
	 */
	public void setDurationMonth(String durationMonth) {
		this.durationMonth = durationMonth;
	}
	
	/**
	 * Column Info
	 * @param bPf
	 */
	public void setBPf(String bPf) {
		this.bPf = bPf;
	}
	
	/**
	 * Column Info
	 * @param durationYear
	 */
	public void setDurationYear(String durationYear) {
		this.durationYear = durationYear;
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
	 * @param lsToDt
	 */
	public void setLsToDt(String lsToDt) {
		this.lsToDt = lsToDt;
	}
	
	/**
	 * Column Info
	 * @param docTpCd
	 */
	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
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
	 * Column Info
	 * @param bTtl
	 */
	public void setBTtl(String bTtl) {
		this.bTtl = bTtl;
	}
	
	/**
	 * Column Info
	 * @param durationToWeek
	 */
	public void setDurationToWeek(String durationToWeek) {
		this.durationToWeek = durationToWeek;
	}
	
	/**
	 * Column Info
	 * @param lsFromDt
	 */
	public void setLsFromDt(String lsFromDt) {
		this.lsFromDt = lsFromDt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param gso
	 */
	public void setGso(String gso) {
		this.gso = gso;
	}
	
	/**
	 * Column Info
	 * @param mon
	 */
	public void setMon(String mon) {
		this.mon = mon;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param durationFromDt
	 */
	public void setDurationFromDt(String durationFromDt) {
		this.durationFromDt = durationFromDt;
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
	 * @param sTtl
	 */
	public void setSTtl(String sTtl) {
		this.sTtl = sTtl;
	}
	
	/**
	 * Column Info
	 * @param salOfc
	 */
	public void setSalOfc(String salOfc) {
		this.salOfc = salOfc;
	}
	
	/**
	 * Column Info
	 * @param delay
	 */
	public void setDelay(String delay) {
		this.delay = delay;
	}
	
	/**
	 * Column Info
	 * @param sPf
	 */
	public void setSPf(String sPf) {
		this.sPf = sPf;
	}
	
	/**
	 * Column Info
	 * @param sX
	 */
	public void setSX(String sX) {
		this.sX = sX;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param sR
	 */
	public void setSR(String sR) {
		this.sR = sR;
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
	 * @param sP
	 */
	public void setSP(String sP) {
		this.sP = sP;
	}
	
	/**
	 * Column Info
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	/**
	 * Column Info
	 * @param iPageNo
	 */
	public void setIPageNo(String iPageNo) {
		this.iPageNo = iPageNo;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param sF
	 */
	public void setSF(String sF) {
		this.sF = sF;
	}
	
	/**
	 * Column Info
	 * @param bkgUpldStsCd
	 */
	public void setBkgUpldStsCd(String bkgUpldStsCd) {
		this.bkgUpldStsCd = bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @param sD
	 */
	public void setSD(String sD) {
		this.sD = sD;
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
	 * @param regionCd
	 */
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param serverId
	 */
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	
	/**
	 * Column Info
	 * @param durationFromWeek
	 */
	public void setDurationFromWeek(String durationFromWeek) {
		this.durationFromWeek = durationFromWeek;
	}
	
	/**
	 * Column Info
	 * @param docTpS
	 */
	public void setDocTpS(String docTpS) {
		this.docTpS = docTpS;
	}
	
	/**
	 * Column Info
	 * @param bR
	 */
	public void setBR(String bR) {
		this.bR = bR;
	}
	
	/**
	 * Column Info
	 * @param bX
	 */
	public void setBX(String bX) {
		this.bX = bX;
	}
	
	/**
	 * Column Info
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param bP
	 */
	public void setBP(String bP) {
		this.bP = bP;
	}
	
	/**
	 * Column Info
	 * @param durationToDt
	 */
	public void setDurationToDt(String durationToDt) {
		this.durationToDt = durationToDt;
	}
	
	/**
	 * Column Info
	 * @param bD
	 */
	public void setBD(String bD) {
		this.bD = bD;
	}
	
	/**
	 * Column Info
	 * @param docTpB
	 */
	public void setDocTpB(String docTpB) {
		this.docTpB = docTpB;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param bF
	 */
	public void setBF(String bF) {
		this.bF = bF;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDurationMonth(JSPUtil.getParameter(request, "duration_month", ""));
		setBPf(JSPUtil.getParameter(request, "b_pf", ""));
		setDurationYear(JSPUtil.getParameter(request, "duration_year", ""));
		setReportType(JSPUtil.getParameter(request, "report_type", ""));
		setLsToDt(JSPUtil.getParameter(request, "ls_to_dt", ""));
		setDocTpCd(JSPUtil.getParameter(request, "doc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBTtl(JSPUtil.getParameter(request, "b_ttl", ""));
		setDurationToWeek(JSPUtil.getParameter(request, "duration_to_week", ""));
		setLsFromDt(JSPUtil.getParameter(request, "ls_from_dt", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setGso(JSPUtil.getParameter(request, "gso", ""));
		setMon(JSPUtil.getParameter(request, "mon", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setDurationFromDt(JSPUtil.getParameter(request, "duration_from_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSTtl(JSPUtil.getParameter(request, "s_ttl", ""));
		setSalOfc(JSPUtil.getParameter(request, "sal_ofc", ""));
		setDelay(JSPUtil.getParameter(request, "delay", ""));
		setSPf(JSPUtil.getParameter(request, "s_pf", ""));
		setSX(JSPUtil.getParameter(request, "s_x", ""));
		setRowNum(JSPUtil.getParameter(request, "row_num", ""));
		setSR(JSPUtil.getParameter(request, "s_r", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSP(JSPUtil.getParameter(request, "s_p", ""));
		setSort(JSPUtil.getParameter(request, "sort", ""));
		setIPageNo(JSPUtil.getParameter(request, "i_page_no", ""));
		setFrDt(JSPUtil.getParameter(request, "fr_dt", ""));
		setSF(JSPUtil.getParameter(request, "s_f", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request, "bkg_upld_sts_cd", ""));
		setSD(JSPUtil.getParameter(request, "s_d", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRegionCd(JSPUtil.getParameter(request, "region_cd", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setServerId(JSPUtil.getParameter(request, "server_id", ""));
		setDurationFromWeek(JSPUtil.getParameter(request, "duration_from_week", ""));
		setDocTpS(JSPUtil.getParameter(request, "doc_tp_s", ""));
		setBR(JSPUtil.getParameter(request, "b_r", ""));
		setBX(JSPUtil.getParameter(request, "b_x", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setBP(JSPUtil.getParameter(request, "b_p", ""));
		setDurationToDt(JSPUtil.getParameter(request, "duration_to_dt", ""));
		setBD(JSPUtil.getParameter(request, "b_d", ""));
		setDocTpB(JSPUtil.getParameter(request, "doc_tp_b", ""));
		setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no", ""));
		setBF(JSPUtil.getParameter(request, "b_f", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EBkgSiUploadStsReportInVO[]
	 */
	public EBkgSiUploadStsReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EBkgSiUploadStsReportInVO[]
	 */
	public EBkgSiUploadStsReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EBkgSiUploadStsReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] durationMonth = (JSPUtil.getParameter(request, prefix	+ "duration_month", length));
			String[] bPf = (JSPUtil.getParameter(request, prefix	+ "b_pf", length));
			String[] durationYear = (JSPUtil.getParameter(request, prefix	+ "duration_year", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] lsToDt = (JSPUtil.getParameter(request, prefix	+ "ls_to_dt", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bTtl = (JSPUtil.getParameter(request, prefix	+ "b_ttl", length));
			String[] durationToWeek = (JSPUtil.getParameter(request, prefix	+ "duration_to_week", length));
			String[] lsFromDt = (JSPUtil.getParameter(request, prefix	+ "ls_from_dt", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] gso = (JSPUtil.getParameter(request, prefix	+ "gso", length));
			String[] mon = (JSPUtil.getParameter(request, prefix	+ "mon", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] durationFromDt = (JSPUtil.getParameter(request, prefix	+ "duration_from_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sTtl = (JSPUtil.getParameter(request, prefix	+ "s_ttl", length));
			String[] salOfc = (JSPUtil.getParameter(request, prefix	+ "sal_ofc", length));
			String[] delay = (JSPUtil.getParameter(request, prefix	+ "delay", length));
			String[] sPf = (JSPUtil.getParameter(request, prefix	+ "s_pf", length));
			String[] sX = (JSPUtil.getParameter(request, prefix	+ "s_x", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] sR = (JSPUtil.getParameter(request, prefix	+ "s_r", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] sP = (JSPUtil.getParameter(request, prefix	+ "s_p", length));
			String[] sort = (JSPUtil.getParameter(request, prefix	+ "sort", length));
			String[] iPageNo = (JSPUtil.getParameter(request, prefix	+ "i_page_no", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] sF = (JSPUtil.getParameter(request, prefix	+ "s_f", length));
			String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_cd", length));
			String[] sD = (JSPUtil.getParameter(request, prefix	+ "s_d", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] regionCd = (JSPUtil.getParameter(request, prefix	+ "region_cd", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] serverId = (JSPUtil.getParameter(request, prefix	+ "server_id", length));
			String[] durationFromWeek = (JSPUtil.getParameter(request, prefix	+ "duration_from_week", length));
			String[] docTpS = (JSPUtil.getParameter(request, prefix	+ "doc_tp_s", length));
			String[] bR = (JSPUtil.getParameter(request, prefix	+ "b_r", length));
			String[] bX = (JSPUtil.getParameter(request, prefix	+ "b_x", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] bP = (JSPUtil.getParameter(request, prefix	+ "b_p", length));
			String[] durationToDt = (JSPUtil.getParameter(request, prefix	+ "duration_to_dt", length));
			String[] bD = (JSPUtil.getParameter(request, prefix	+ "b_d", length));
			String[] docTpB = (JSPUtil.getParameter(request, prefix	+ "doc_tp_b", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] bF = (JSPUtil.getParameter(request, prefix	+ "b_f", length));
			
			for (int i = 0; i < length; i++) {
				model = new EBkgSiUploadStsReportInVO();
				if (durationMonth[i] != null)
					model.setDurationMonth(durationMonth[i]);
				if (bPf[i] != null)
					model.setBPf(bPf[i]);
				if (durationYear[i] != null)
					model.setDurationYear(durationYear[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (lsToDt[i] != null)
					model.setLsToDt(lsToDt[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bTtl[i] != null)
					model.setBTtl(bTtl[i]);
				if (durationToWeek[i] != null)
					model.setDurationToWeek(durationToWeek[i]);
				if (lsFromDt[i] != null)
					model.setLsFromDt(lsFromDt[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (gso[i] != null)
					model.setGso(gso[i]);
				if (mon[i] != null)
					model.setMon(mon[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (durationFromDt[i] != null)
					model.setDurationFromDt(durationFromDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sTtl[i] != null)
					model.setSTtl(sTtl[i]);
				if (salOfc[i] != null)
					model.setSalOfc(salOfc[i]);
				if (delay[i] != null)
					model.setDelay(delay[i]);
				if (sPf[i] != null)
					model.setSPf(sPf[i]);
				if (sX[i] != null)
					model.setSX(sX[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (sR[i] != null)
					model.setSR(sR[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sP[i] != null)
					model.setSP(sP[i]);
				if (sort[i] != null)
					model.setSort(sort[i]);
				if (iPageNo[i] != null)
					model.setIPageNo(iPageNo[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (sF[i] != null)
					model.setSF(sF[i]);
				if (bkgUpldStsCd[i] != null)
					model.setBkgUpldStsCd(bkgUpldStsCd[i]);
				if (sD[i] != null)
					model.setSD(sD[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (regionCd[i] != null)
					model.setRegionCd(regionCd[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (serverId[i] != null)
					model.setServerId(serverId[i]);
				if (durationFromWeek[i] != null)
					model.setDurationFromWeek(durationFromWeek[i]);
				if (docTpS[i] != null)
					model.setDocTpS(docTpS[i]);
				if (bR[i] != null)
					model.setBR(bR[i]);
				if (bX[i] != null)
					model.setBX(bX[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (bP[i] != null)
					model.setBP(bP[i]);
				if (durationToDt[i] != null)
					model.setDurationToDt(durationToDt[i]);
				if (bD[i] != null)
					model.setBD(bD[i]);
				if (docTpB[i] != null)
					model.setDocTpB(docTpB[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (bF[i] != null)
					model.setBF(bF[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEBkgSiUploadStsReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EBkgSiUploadStsReportInVO[]
	 */
	public EBkgSiUploadStsReportInVO[] getEBkgSiUploadStsReportInVOs(){
		EBkgSiUploadStsReportInVO[] vos = (EBkgSiUploadStsReportInVO[])models.toArray(new EBkgSiUploadStsReportInVO[models.size()]);
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
		this.durationMonth = this.durationMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPf = this.bPf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationYear = this.durationYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsToDt = this.lsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bTtl = this.bTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationToWeek = this.durationToWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsFromDt = this.lsFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gso = this.gso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mon = this.mon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationFromDt = this.durationFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTtl = this.sTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salOfc = this.salOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delay = this.delay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPf = this.sPf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sX = this.sX .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sR = this.sR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sP = this.sP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sort = this.sort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPageNo = this.iPageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sF = this.sF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd = this.bkgUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sD = this.sD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionCd = this.regionCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serverId = this.serverId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationFromWeek = this.durationFromWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpS = this.docTpS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bR = this.bR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bX = this.bX .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bP = this.bP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationToDt = this.durationToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bD = this.bD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpB = this.docTpB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bF = this.bF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
