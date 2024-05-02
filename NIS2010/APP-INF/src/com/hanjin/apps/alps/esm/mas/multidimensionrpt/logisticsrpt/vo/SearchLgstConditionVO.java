/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchLgstConditionVO.java
*@FileTitle : SearchLgstConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo;

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

public class SearchLgstConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLgstConditionVO> models = new ArrayList<SearchLgstConditionVO>();
	
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fLgsMnKpiCd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fInOut = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String sCostYrmon2 = null;
	/* Column Info */
	private String fIncldMt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sLoad = null;
	/* Column Info */
	private String fIsnodeDisplay = null;
	/* Column Info */
	private String sRlaneCd = null;
	/* Column Info */
	private String sCostWk2 = null;
	/* Column Info */
	private String sRhqCd = null;
	/* Column Info */
	private String fExcldCrrHlg = null;
	/* Column Info */
	private String fIslaneDisplay = null;
	/* Column Info */
	private String fLgsKpi3Cd = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String sCntrOfcCd = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fIstpszDisplay = null;
	/* Column Info */
	private String fKpiType = null;
	/* Column Info */
	private String sSkdDirCd = null;
	/* Column Info */
	private String sTrdCd = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fSplitMw = null;
	/* Column Info */
	private String fIncldTml = null;
	/* Column Info */
	private String fIncldRmon = null;
	/* Column Info */
	private String fCtrlOfcCd = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fLgsKpiCostGrpCd = null;
	/* Column Info */
	private String sLgsKpiCostGrpCd = null;
	/* Column Info */
	private String fNodCd = null;
	/* Column Info */
	private String fReport = null;
	/* Column Info */
	private String sKpiCd = null;
	/* Column Info */
	private String fLgsKpiCd = null;
	/* Column Info */
	private String fNodCd3 = null;
	/* Column Info */
	private String fNodCd2 = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String fNodCd4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchLgstConditionVO() {}

	public SearchLgstConditionVO(String ibflag, String pagerows, String fChkprd, String fCtrlOfcCd, String fFmMon, String fFmWk, String fIncldMt, String fIncldRmon, String fIncldTml, String fInOut, String fIslaneDisplay, String fIsnodeDisplay, String fIstpszDisplay, String fKpiType, String fLgsKpiCd, String fLgsKpiCostGrpCd, String fLgsMnKpiCd, String fNodCd, String fNodCd2, String fNodCd3, String fNodCd4, String fReport, String fRhqCd, String fRlaneCd, String fSkdDirCd, String fSlsMon, String fSplitMw, String fToMon, String fToWk, String fTrdCd, String fYear, String sCntrOfcCd, String sCostWk2, String sCostYrmon2, String sKpiCd, String sLgsKpiCostGrpCd, String sLoad, String sRhqCd, String sRlaneCd, String sSkdDirCd, String sTrdCd, String fExcldCrrHlg, String fLgsKpi3Cd) {
		this.fChkprd = fChkprd;
		this.fLgsMnKpiCd = fLgsMnKpiCd;
		this.fFmMon = fFmMon;
		this.fInOut = fInOut;
		this.fSlsMon = fSlsMon;
		this.fRhqCd = fRhqCd;
		this.sCostYrmon2 = sCostYrmon2;
		this.fIncldMt = fIncldMt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sLoad = sLoad;
		this.fIsnodeDisplay = fIsnodeDisplay;
		this.sRlaneCd = sRlaneCd;
		this.sCostWk2 = sCostWk2;
		this.sRhqCd = sRhqCd;
		this.fExcldCrrHlg = fExcldCrrHlg;
		this.fIslaneDisplay = fIslaneDisplay;
		this.fLgsKpi3Cd = fLgsKpi3Cd;
		this.fFmWk = fFmWk;
		this.sCntrOfcCd = sCntrOfcCd;
		this.fSkdDirCd = fSkdDirCd;
		this.fToMon = fToMon;
		this.fIstpszDisplay = fIstpszDisplay;
		this.fKpiType = fKpiType;
		this.sSkdDirCd = sSkdDirCd;
		this.sTrdCd = sTrdCd;
		this.fTrdCd = fTrdCd;
		this.fToWk = fToWk;
		this.fSplitMw = fSplitMw;
		this.fIncldTml = fIncldTml;
		this.fIncldRmon = fIncldRmon;
		this.fCtrlOfcCd = fCtrlOfcCd;
		this.fRlaneCd = fRlaneCd;
		this.fLgsKpiCostGrpCd = fLgsKpiCostGrpCd;
		this.sLgsKpiCostGrpCd = sLgsKpiCostGrpCd;
		this.fNodCd = fNodCd;
		this.fReport = fReport;
		this.sKpiCd = sKpiCd;
		this.fLgsKpiCd = fLgsKpiCd;
		this.fNodCd3 = fNodCd3;
		this.fNodCd2 = fNodCd2;
		this.fYear = fYear;
		this.fNodCd4 = fNodCd4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_lgs_mn_kpi_cd", getFLgsMnKpiCd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_in_out", getFInOut());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("s_cost_yrmon2", getSCostYrmon2());
		this.hashColumns.put("f_incld_mt", getFIncldMt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_load", getSLoad());
		this.hashColumns.put("f_isnode_display", getFIsnodeDisplay());
		this.hashColumns.put("s_rlane_cd", getSRlaneCd());
		this.hashColumns.put("s_cost_wk2", getSCostWk2());
		this.hashColumns.put("s_rhq_cd", getSRhqCd());
		this.hashColumns.put("f_excld_crr_hlg", getFExcldCrrHlg());
		this.hashColumns.put("f_islane_display", getFIslaneDisplay());
		this.hashColumns.put("f_lgs_kpi3_cd", getFLgsKpi3Cd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("s_cntr_ofc_cd", getSCntrOfcCd());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_istpsz_display", getFIstpszDisplay());
		this.hashColumns.put("f_kpi_type", getFKpiType());
		this.hashColumns.put("s_skd_dir_cd", getSSkdDirCd());
		this.hashColumns.put("s_trd_cd", getSTrdCd());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_split_mw", getFSplitMw());
		this.hashColumns.put("f_incld_tml", getFIncldTml());
		this.hashColumns.put("f_incld_rmon", getFIncldRmon());
		this.hashColumns.put("f_ctrl_ofc_cd", getFCtrlOfcCd());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_lgs_kpi_cost_grp_cd", getFLgsKpiCostGrpCd());
		this.hashColumns.put("s_lgs_kpi_cost_grp_cd", getSLgsKpiCostGrpCd());
		this.hashColumns.put("f_nod_cd", getFNodCd());
		this.hashColumns.put("f_report", getFReport());
		this.hashColumns.put("s_kpi_cd", getSKpiCd());
		this.hashColumns.put("f_lgs_kpi_cd", getFLgsKpiCd());
		this.hashColumns.put("f_nod_cd3", getFNodCd3());
		this.hashColumns.put("f_nod_cd2", getFNodCd2());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("f_nod_cd4", getFNodCd4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_lgs_mn_kpi_cd", "fLgsMnKpiCd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_in_out", "fInOut");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("s_cost_yrmon2", "sCostYrmon2");
		this.hashFields.put("f_incld_mt", "fIncldMt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_load", "sLoad");
		this.hashFields.put("f_isnode_display", "fIsnodeDisplay");
		this.hashFields.put("s_rlane_cd", "sRlaneCd");
		this.hashFields.put("s_cost_wk2", "sCostWk2");
		this.hashFields.put("s_rhq_cd", "sRhqCd");
		this.hashFields.put("f_excld_crr_hlg", "fExcldCrrHlg");
		this.hashFields.put("f_islane_display", "fIslaneDisplay");
		this.hashFields.put("f_lgs_kpi3_cd", "fLgsKpi3Cd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("s_cntr_ofc_cd", "sCntrOfcCd");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_istpsz_display", "fIstpszDisplay");
		this.hashFields.put("f_kpi_type", "fKpiType");
		this.hashFields.put("s_skd_dir_cd", "sSkdDirCd");
		this.hashFields.put("s_trd_cd", "sTrdCd");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_split_mw", "fSplitMw");
		this.hashFields.put("f_incld_tml", "fIncldTml");
		this.hashFields.put("f_incld_rmon", "fIncldRmon");
		this.hashFields.put("f_ctrl_ofc_cd", "fCtrlOfcCd");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_lgs_kpi_cost_grp_cd", "fLgsKpiCostGrpCd");
		this.hashFields.put("s_lgs_kpi_cost_grp_cd", "sLgsKpiCostGrpCd");
		this.hashFields.put("f_nod_cd", "fNodCd");
		this.hashFields.put("f_report", "fReport");
		this.hashFields.put("s_kpi_cd", "sKpiCd");
		this.hashFields.put("f_lgs_kpi_cd", "fLgsKpiCd");
		this.hashFields.put("f_nod_cd3", "fNodCd3");
		this.hashFields.put("f_nod_cd2", "fNodCd2");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("f_nod_cd4", "fNodCd4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fChkprd
	 */
	public String getFChkprd() {
		return this.fChkprd;
	}
	
	/**
	 * Column Info
	 * @return fLgsMnKpiCd
	 */
	public String getFLgsMnKpiCd() {
		return this.fLgsMnKpiCd;
	}
	
	/**
	 * Column Info
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return fInOut
	 */
	public String getFInOut() {
		return this.fInOut;
	}
	
	/**
	 * Column Info
	 * @return fSlsMon
	 */
	public String getFSlsMon() {
		return this.fSlsMon;
	}
	
	/**
	 * Column Info
	 * @return fRhqCd
	 */
	public String getFRhqCd() {
		return this.fRhqCd;
	}
	
	/**
	 * Column Info
	 * @return sCostYrmon2
	 */
	public String getSCostYrmon2() {
		return this.sCostYrmon2;
	}
	
	/**
	 * Column Info
	 * @return fIncldMt
	 */
	public String getFIncldMt() {
		return this.fIncldMt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return sLoad
	 */
	public String getSLoad() {
		return this.sLoad;
	}
	
	/**
	 * Column Info
	 * @return fIsnodeDisplay
	 */
	public String getFIsnodeDisplay() {
		return this.fIsnodeDisplay;
	}
	
	/**
	 * Column Info
	 * @return sRlaneCd
	 */
	public String getSRlaneCd() {
		return this.sRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return sCostWk2
	 */
	public String getSCostWk2() {
		return this.sCostWk2;
	}
	
	/**
	 * Column Info
	 * @return sRhqCd
	 */
	public String getSRhqCd() {
		return this.sRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fExcldCrrHlg
	 */
	public String getFExcldCrrHlg() {
		return this.fExcldCrrHlg;
	}
	
	/**
	 * Column Info
	 * @return fIslaneDisplay
	 */
	public String getFIslaneDisplay() {
		return this.fIslaneDisplay;
	}
	
	/**
	 * Column Info
	 * @return fLgsKpi3Cd
	 */
	public String getFLgsKpi3Cd() {
		return this.fLgsKpi3Cd;
	}
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return sCntrOfcCd
	 */
	public String getSCntrOfcCd() {
		return this.sCntrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fSkdDirCd
	 */
	public String getFSkdDirCd() {
		return this.fSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return fToMon
	 */
	public String getFToMon() {
		return this.fToMon;
	}
	
	/**
	 * Column Info
	 * @return fIstpszDisplay
	 */
	public String getFIstpszDisplay() {
		return this.fIstpszDisplay;
	}
	
	/**
	 * Column Info
	 * @return fKpiType
	 */
	public String getFKpiType() {
		return this.fKpiType;
	}
	
	/**
	 * Column Info
	 * @return sSkdDirCd
	 */
	public String getSSkdDirCd() {
		return this.sSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return sTrdCd
	 */
	public String getSTrdCd() {
		return this.sTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
	}
	
	/**
	 * Column Info
	 * @return fSplitMw
	 */
	public String getFSplitMw() {
		return this.fSplitMw;
	}
	
	/**
	 * Column Info
	 * @return fIncldTml
	 */
	public String getFIncldTml() {
		return this.fIncldTml;
	}
	
	/**
	 * Column Info
	 * @return fIncldRmon
	 */
	public String getFIncldRmon() {
		return this.fIncldRmon;
	}
	
	/**
	 * Column Info
	 * @return fCtrlOfcCd
	 */
	public String getFCtrlOfcCd() {
		return this.fCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fRlaneCd
	 */
	public String getFRlaneCd() {
		return this.fRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fLgsKpiCostGrpCd
	 */
	public String getFLgsKpiCostGrpCd() {
		return this.fLgsKpiCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sLgsKpiCostGrpCd
	 */
	public String getSLgsKpiCostGrpCd() {
		return this.sLgsKpiCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return fNodCd
	 */
	public String getFNodCd() {
		return this.fNodCd;
	}
	
	/**
	 * Column Info
	 * @return fReport
	 */
	public String getFReport() {
		return this.fReport;
	}
	
	/**
	 * Column Info
	 * @return sKpiCd
	 */
	public String getSKpiCd() {
		return this.sKpiCd;
	}
	
	/**
	 * Column Info
	 * @return fLgsKpiCd
	 */
	public String getFLgsKpiCd() {
		return this.fLgsKpiCd;
	}
	
	/**
	 * Column Info
	 * @return fNodCd3
	 */
	public String getFNodCd3() {
		return this.fNodCd3;
	}
	
	/**
	 * Column Info
	 * @return fNodCd2
	 */
	public String getFNodCd2() {
		return this.fNodCd2;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	
	/**
	 * Column Info
	 * @return fNodCd4
	 */
	public String getFNodCd4() {
		return this.fNodCd4;
	}
	

	/**
	 * Column Info
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
	}
	
	/**
	 * Column Info
	 * @param fLgsMnKpiCd
	 */
	public void setFLgsMnKpiCd(String fLgsMnKpiCd) {
		this.fLgsMnKpiCd = fLgsMnKpiCd;
	}
	
	/**
	 * Column Info
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}
	
	/**
	 * Column Info
	 * @param fInOut
	 */
	public void setFInOut(String fInOut) {
		this.fInOut = fInOut;
	}
	
	/**
	 * Column Info
	 * @param fSlsMon
	 */
	public void setFSlsMon(String fSlsMon) {
		this.fSlsMon = fSlsMon;
	}
	
	/**
	 * Column Info
	 * @param fRhqCd
	 */
	public void setFRhqCd(String fRhqCd) {
		this.fRhqCd = fRhqCd;
	}
	
	/**
	 * Column Info
	 * @param sCostYrmon2
	 */
	public void setSCostYrmon2(String sCostYrmon2) {
		this.sCostYrmon2 = sCostYrmon2;
	}
	
	/**
	 * Column Info
	 * @param fIncldMt
	 */
	public void setFIncldMt(String fIncldMt) {
		this.fIncldMt = fIncldMt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param sLoad
	 */
	public void setSLoad(String sLoad) {
		this.sLoad = sLoad;
	}
	
	/**
	 * Column Info
	 * @param fIsnodeDisplay
	 */
	public void setFIsnodeDisplay(String fIsnodeDisplay) {
		this.fIsnodeDisplay = fIsnodeDisplay;
	}
	
	/**
	 * Column Info
	 * @param sRlaneCd
	 */
	public void setSRlaneCd(String sRlaneCd) {
		this.sRlaneCd = sRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param sCostWk2
	 */
	public void setSCostWk2(String sCostWk2) {
		this.sCostWk2 = sCostWk2;
	}
	
	/**
	 * Column Info
	 * @param sRhqCd
	 */
	public void setSRhqCd(String sRhqCd) {
		this.sRhqCd = sRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fExcldCrrHlg
	 */
	public void setFExcldCrrHlg(String fExcldCrrHlg) {
		this.fExcldCrrHlg = fExcldCrrHlg;
	}
	
	/**
	 * Column Info
	 * @param fIslaneDisplay
	 */
	public void setFIslaneDisplay(String fIslaneDisplay) {
		this.fIslaneDisplay = fIslaneDisplay;
	}
	
	/**
	 * Column Info
	 * @param fLgsKpi3Cd
	 */
	public void setFLgsKpi3Cd(String fLgsKpi3Cd) {
		this.fLgsKpi3Cd = fLgsKpi3Cd;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param sCntrOfcCd
	 */
	public void setSCntrOfcCd(String sCntrOfcCd) {
		this.sCntrOfcCd = sCntrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fSkdDirCd
	 */
	public void setFSkdDirCd(String fSkdDirCd) {
		this.fSkdDirCd = fSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param fToMon
	 */
	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}
	
	/**
	 * Column Info
	 * @param fIstpszDisplay
	 */
	public void setFIstpszDisplay(String fIstpszDisplay) {
		this.fIstpszDisplay = fIstpszDisplay;
	}
	
	/**
	 * Column Info
	 * @param fKpiType
	 */
	public void setFKpiType(String fKpiType) {
		this.fKpiType = fKpiType;
	}
	
	/**
	 * Column Info
	 * @param sSkdDirCd
	 */
	public void setSSkdDirCd(String sSkdDirCd) {
		this.sSkdDirCd = sSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param sTrdCd
	 */
	public void setSTrdCd(String sTrdCd) {
		this.sTrdCd = sTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fTrdCd
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
	}
	
	/**
	 * Column Info
	 * @param fSplitMw
	 */
	public void setFSplitMw(String fSplitMw) {
		this.fSplitMw = fSplitMw;
	}
	
	/**
	 * Column Info
	 * @param fIncldTml
	 */
	public void setFIncldTml(String fIncldTml) {
		this.fIncldTml = fIncldTml;
	}
	
	/**
	 * Column Info
	 * @param fIncldRmon
	 */
	public void setFIncldRmon(String fIncldRmon) {
		this.fIncldRmon = fIncldRmon;
	}
	
	/**
	 * Column Info
	 * @param fCtrlOfcCd
	 */
	public void setFCtrlOfcCd(String fCtrlOfcCd) {
		this.fCtrlOfcCd = fCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fRlaneCd
	 */
	public void setFRlaneCd(String fRlaneCd) {
		this.fRlaneCd = fRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fLgsKpiCostGrpCd
	 */
	public void setFLgsKpiCostGrpCd(String fLgsKpiCostGrpCd) {
		this.fLgsKpiCostGrpCd = fLgsKpiCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sLgsKpiCostGrpCd
	 */
	public void setSLgsKpiCostGrpCd(String sLgsKpiCostGrpCd) {
		this.sLgsKpiCostGrpCd = sLgsKpiCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param fNodCd
	 */
	public void setFNodCd(String fNodCd) {
		this.fNodCd = fNodCd;
	}
	
	/**
	 * Column Info
	 * @param fReport
	 */
	public void setFReport(String fReport) {
		this.fReport = fReport;
	}
	
	/**
	 * Column Info
	 * @param sKpiCd
	 */
	public void setSKpiCd(String sKpiCd) {
		this.sKpiCd = sKpiCd;
	}
	
	/**
	 * Column Info
	 * @param fLgsKpiCd
	 */
	public void setFLgsKpiCd(String fLgsKpiCd) {
		this.fLgsKpiCd = fLgsKpiCd;
	}
	
	/**
	 * Column Info
	 * @param fNodCd3
	 */
	public void setFNodCd3(String fNodCd3) {
		this.fNodCd3 = fNodCd3;
	}
	
	/**
	 * Column Info
	 * @param fNodCd2
	 */
	public void setFNodCd2(String fNodCd2) {
		this.fNodCd2 = fNodCd2;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
	}
	
	/**
	 * Column Info
	 * @param fNodCd4
	 */
	public void setFNodCd4(String fNodCd4) {
		this.fNodCd4 = fNodCd4;
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
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFLgsMnKpiCd(JSPUtil.getParameter(request, prefix + "f_lgs_mn_kpi_cd", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFInOut(JSPUtil.getParameter(request, prefix + "f_in_out", ""));
		setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setSCostYrmon2(JSPUtil.getParameter(request, prefix + "s_cost_yrmon2", ""));
		setFIncldMt(JSPUtil.getParameter(request, prefix + "f_incld_mt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSLoad(JSPUtil.getParameter(request, prefix + "s_load", ""));
		setFIsnodeDisplay(JSPUtil.getParameter(request, prefix + "f_isnode_display", ""));
		setSRlaneCd(JSPUtil.getParameter(request, prefix + "s_rlane_cd", ""));
		setSCostWk2(JSPUtil.getParameter(request, prefix + "s_cost_wk2", ""));
		setSRhqCd(JSPUtil.getParameter(request, prefix + "s_rhq_cd", ""));
		setFExcldCrrHlg(JSPUtil.getParameter(request, prefix + "f_excld_crr_hlg", ""));
		setFIslaneDisplay(JSPUtil.getParameter(request, prefix + "f_islane_display", ""));
		setFLgsKpi3Cd(JSPUtil.getParameter(request, prefix + "f_lgs_kpi3_cd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setSCntrOfcCd(JSPUtil.getParameter(request, prefix + "s_cntr_ofc_cd", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFIstpszDisplay(JSPUtil.getParameter(request, prefix + "f_istpsz_display", ""));
		setFKpiType(JSPUtil.getParameter(request, prefix + "f_kpi_type", ""));
		setSSkdDirCd(JSPUtil.getParameter(request, prefix + "s_skd_dir_cd", ""));
		setSTrdCd(JSPUtil.getParameter(request, prefix + "s_trd_cd", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setFSplitMw(JSPUtil.getParameter(request, prefix + "f_split_mw", ""));
		setFIncldTml(JSPUtil.getParameter(request, prefix + "f_incld_tml", ""));
		setFIncldRmon(JSPUtil.getParameter(request, prefix + "f_incld_rmon", ""));
		setFCtrlOfcCd(JSPUtil.getParameter(request, prefix + "f_ctrl_ofc_cd", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setFLgsKpiCostGrpCd(JSPUtil.getParameter(request, prefix + "f_lgs_kpi_cost_grp_cd", ""));
		setSLgsKpiCostGrpCd(JSPUtil.getParameter(request, prefix + "s_lgs_kpi_cost_grp_cd", ""));
		setFNodCd(JSPUtil.getParameter(request, prefix + "f_nod_cd", ""));
		setFReport(JSPUtil.getParameter(request, prefix + "f_report", ""));
		setSKpiCd(JSPUtil.getParameter(request, prefix + "s_kpi_cd", ""));
		setFLgsKpiCd(JSPUtil.getParameter(request, prefix + "f_lgs_kpi_cd", ""));
		setFNodCd3(JSPUtil.getParameter(request, prefix + "f_nod_cd3", ""));
		setFNodCd2(JSPUtil.getParameter(request, prefix + "f_nod_cd2", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setFNodCd4(JSPUtil.getParameter(request, prefix + "f_nod_cd4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLgstConditionVO[]
	 */
	public SearchLgstConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLgstConditionVO[]
	 */
	public SearchLgstConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLgstConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fLgsMnKpiCd = (JSPUtil.getParameter(request, prefix	+ "f_lgs_mn_kpi_cd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fInOut = (JSPUtil.getParameter(request, prefix	+ "f_in_out", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] sCostYrmon2 = (JSPUtil.getParameter(request, prefix	+ "s_cost_yrmon2", length));
			String[] fIncldMt = (JSPUtil.getParameter(request, prefix	+ "f_incld_mt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sLoad = (JSPUtil.getParameter(request, prefix	+ "s_load", length));
			String[] fIsnodeDisplay = (JSPUtil.getParameter(request, prefix	+ "f_isnode_display", length));
			String[] sRlaneCd = (JSPUtil.getParameter(request, prefix	+ "s_rlane_cd", length));
			String[] sCostWk2 = (JSPUtil.getParameter(request, prefix	+ "s_cost_wk2", length));
			String[] sRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd", length));
			String[] fExcldCrrHlg = (JSPUtil.getParameter(request, prefix	+ "f_excld_crr_hlg", length));
			String[] fIslaneDisplay = (JSPUtil.getParameter(request, prefix	+ "f_islane_display", length));
			String[] fLgsKpi3Cd = (JSPUtil.getParameter(request, prefix	+ "f_lgs_kpi3_cd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] sCntrOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_cntr_ofc_cd", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fIstpszDisplay = (JSPUtil.getParameter(request, prefix	+ "f_istpsz_display", length));
			String[] fKpiType = (JSPUtil.getParameter(request, prefix	+ "f_kpi_type", length));
			String[] sSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "s_skd_dir_cd", length));
			String[] sTrdCd = (JSPUtil.getParameter(request, prefix	+ "s_trd_cd", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fSplitMw = (JSPUtil.getParameter(request, prefix	+ "f_split_mw", length));
			String[] fIncldTml = (JSPUtil.getParameter(request, prefix	+ "f_incld_tml", length));
			String[] fIncldRmon = (JSPUtil.getParameter(request, prefix	+ "f_incld_rmon", length));
			String[] fCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ctrl_ofc_cd", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fLgsKpiCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_lgs_kpi_cost_grp_cd", length));
			String[] sLgsKpiCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "s_lgs_kpi_cost_grp_cd", length));
			String[] fNodCd = (JSPUtil.getParameter(request, prefix	+ "f_nod_cd", length));
			String[] fReport = (JSPUtil.getParameter(request, prefix	+ "f_report", length));
			String[] sKpiCd = (JSPUtil.getParameter(request, prefix	+ "s_kpi_cd", length));
			String[] fLgsKpiCd = (JSPUtil.getParameter(request, prefix	+ "f_lgs_kpi_cd", length));
			String[] fNodCd3 = (JSPUtil.getParameter(request, prefix	+ "f_nod_cd3", length));
			String[] fNodCd2 = (JSPUtil.getParameter(request, prefix	+ "f_nod_cd2", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] fNodCd4 = (JSPUtil.getParameter(request, prefix	+ "f_nod_cd4", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLgstConditionVO();
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fLgsMnKpiCd[i] != null)
					model.setFLgsMnKpiCd(fLgsMnKpiCd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fInOut[i] != null)
					model.setFInOut(fInOut[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (sCostYrmon2[i] != null)
					model.setSCostYrmon2(sCostYrmon2[i]);
				if (fIncldMt[i] != null)
					model.setFIncldMt(fIncldMt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sLoad[i] != null)
					model.setSLoad(sLoad[i]);
				if (fIsnodeDisplay[i] != null)
					model.setFIsnodeDisplay(fIsnodeDisplay[i]);
				if (sRlaneCd[i] != null)
					model.setSRlaneCd(sRlaneCd[i]);
				if (sCostWk2[i] != null)
					model.setSCostWk2(sCostWk2[i]);
				if (sRhqCd[i] != null)
					model.setSRhqCd(sRhqCd[i]);
				if (fExcldCrrHlg[i] != null)
					model.setFExcldCrrHlg(fExcldCrrHlg[i]);
				if (fIslaneDisplay[i] != null)
					model.setFIslaneDisplay(fIslaneDisplay[i]);
				if (fLgsKpi3Cd[i] != null)
					model.setFLgsKpi3Cd(fLgsKpi3Cd[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (sCntrOfcCd[i] != null)
					model.setSCntrOfcCd(sCntrOfcCd[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fIstpszDisplay[i] != null)
					model.setFIstpszDisplay(fIstpszDisplay[i]);
				if (fKpiType[i] != null)
					model.setFKpiType(fKpiType[i]);
				if (sSkdDirCd[i] != null)
					model.setSSkdDirCd(sSkdDirCd[i]);
				if (sTrdCd[i] != null)
					model.setSTrdCd(sTrdCd[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fSplitMw[i] != null)
					model.setFSplitMw(fSplitMw[i]);
				if (fIncldTml[i] != null)
					model.setFIncldTml(fIncldTml[i]);
				if (fIncldRmon[i] != null)
					model.setFIncldRmon(fIncldRmon[i]);
				if (fCtrlOfcCd[i] != null)
					model.setFCtrlOfcCd(fCtrlOfcCd[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fLgsKpiCostGrpCd[i] != null)
					model.setFLgsKpiCostGrpCd(fLgsKpiCostGrpCd[i]);
				if (sLgsKpiCostGrpCd[i] != null)
					model.setSLgsKpiCostGrpCd(sLgsKpiCostGrpCd[i]);
				if (fNodCd[i] != null)
					model.setFNodCd(fNodCd[i]);
				if (fReport[i] != null)
					model.setFReport(fReport[i]);
				if (sKpiCd[i] != null)
					model.setSKpiCd(sKpiCd[i]);
				if (fLgsKpiCd[i] != null)
					model.setFLgsKpiCd(fLgsKpiCd[i]);
				if (fNodCd3[i] != null)
					model.setFNodCd3(fNodCd3[i]);
				if (fNodCd2[i] != null)
					model.setFNodCd2(fNodCd2[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (fNodCd4[i] != null)
					model.setFNodCd4(fNodCd4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLgstConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLgstConditionVO[]
	 */
	public SearchLgstConditionVO[] getSearchLgstConditionVOs(){
		SearchLgstConditionVO[] vos = (SearchLgstConditionVO[])models.toArray(new SearchLgstConditionVO[models.size()]);
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
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLgsMnKpiCd = this.fLgsMnKpiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fInOut = this.fInOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostYrmon2 = this.sCostYrmon2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIncldMt = this.fIncldMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLoad = this.sLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIsnodeDisplay = this.fIsnodeDisplay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRlaneCd = this.sRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCostWk2 = this.sCostWk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCd = this.sRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExcldCrrHlg = this.fExcldCrrHlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIslaneDisplay = this.fIslaneDisplay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLgsKpi3Cd = this.fLgsKpi3Cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrOfcCd = this.sCntrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIstpszDisplay = this.fIstpszDisplay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fKpiType = this.fKpiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSkdDirCd = this.sSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdCd = this.sTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSplitMw = this.fSplitMw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIncldTml = this.fIncldTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIncldRmon = this.fIncldRmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrlOfcCd = this.fCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLgsKpiCostGrpCd = this.fLgsKpiCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLgsKpiCostGrpCd = this.sLgsKpiCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodCd = this.fNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReport = this.fReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sKpiCd = this.sKpiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLgsKpiCd = this.fLgsKpiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodCd3 = this.fNodCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodCd2 = this.fNodCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNodCd4 = this.fNodCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
