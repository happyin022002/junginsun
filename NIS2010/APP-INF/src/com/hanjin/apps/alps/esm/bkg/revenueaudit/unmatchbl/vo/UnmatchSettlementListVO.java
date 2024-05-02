/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnmatchSettlementListVO.java
*@FileTitle : UnmatchSettlementListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
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

public class UnmatchSettlementListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnmatchSettlementListVO> models = new ArrayList<UnmatchSettlementListVO>();
	
	/* Column Info */
	private String sCCnt = null;
	/* Column Info */
	private String sBStlPrd = null;
	/* Column Info */
	private String blUCnt = null;
	/* Column Info */
	private String kpiLessThan6 = null;
	/* Column Info */
	private String kpi2LessThan6 = null;
	/* Column Info */
	private String blSCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rtAplyDtFrom = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blUStlPrd = null;
	/* Column Info */
	private String sOCnt = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String sCStlPrd = null;
	/* Column Info */
	private String sAStlPrd = null;
	/* Column Info */
	private String blUAvgStlPrd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String sBCnt = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String sMCnt = null;
	/* Column Info */
	private String sMStlPrd = null;
	/* Column Info */
	private String ttlBlCnt = null;
	/* Column Info */
	private String rtAplyDtTo = null;
	/* Column Info */
	private String ttlAvgStlPrd = null;
	/* Column Info */
	private String kpiMoreThan6 = null;
	/* Column Info */
	private String kpi2MoreThan6 = null;
	/* Column Info */
	private String blSStlPrd = null;
	/* Column Info */
	private String ttlStlPrd = null;
	/* Column Info */
	private String sACnt = null;
	/* Column Info */
	private String sOStlPrd = null;
	/* Column Info */
	private String blSAvgStlPrd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UnmatchSettlementListVO() {}

	public UnmatchSettlementListVO(String ibflag, String pagerows, String rctRhqCd, String sBCnt, String sBStlPrd, String sACnt, String sAStlPrd, String sMCnt, String sMStlPrd, String sOCnt, String sOStlPrd, String sCCnt, String sCStlPrd, String blSCnt, String blSStlPrd, String blSAvgStlPrd, String blUCnt, String blUStlPrd, String blUAvgStlPrd, String ttlBlCnt, String ttlStlPrd, String ttlAvgStlPrd, String kpiMoreThan6, String kpiLessThan6, String kpi2MoreThan6, String kpi2LessThan6, String rtAplyDtFrom, String rtAplyDtTo, String bkgOfcCd, String bkgCtrtTpCd, String autoRatFlg, String dateType) {
		this.sCCnt = sCCnt;
		this.sBStlPrd = sBStlPrd;
		this.blUCnt = blUCnt;
		this.kpiLessThan6 = kpiLessThan6;
		this.kpi2LessThan6 = kpi2LessThan6;
		this.blSCnt = blSCnt;
		this.pagerows = pagerows;
		this.rtAplyDtFrom = rtAplyDtFrom;
		this.ibflag = ibflag;
		this.blUStlPrd = blUStlPrd;
		this.sOCnt = sOCnt;
		this.autoRatFlg = autoRatFlg;
		this.sCStlPrd = sCStlPrd;
		this.sAStlPrd = sAStlPrd;
		this.blUAvgStlPrd = blUAvgStlPrd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.rctRhqCd = rctRhqCd;
		this.bkgOfcCd = bkgOfcCd;
		this.sBCnt = sBCnt;
		this.dateType = dateType;
		this.sMCnt = sMCnt;
		this.sMStlPrd = sMStlPrd;
		this.ttlBlCnt = ttlBlCnt;
		this.rtAplyDtTo = rtAplyDtTo;
		this.ttlAvgStlPrd = ttlAvgStlPrd;
		this.kpiMoreThan6 = kpiMoreThan6;
		this.kpi2MoreThan6 = kpi2MoreThan6;
		this.blSStlPrd = blSStlPrd;
		this.ttlStlPrd = ttlStlPrd;
		this.sACnt = sACnt;
		this.sOStlPrd = sOStlPrd;
		this.blSAvgStlPrd = blSAvgStlPrd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_c_cnt", getSCCnt());
		this.hashColumns.put("s_b_stl_prd", getSBStlPrd());
		this.hashColumns.put("bl_u_cnt", getBlUCnt());
		this.hashColumns.put("kpi_less_than6", getKpiLessThan6());
		this.hashColumns.put("kpi2_less_than6", getKpi2LessThan6());
		this.hashColumns.put("bl_s_cnt", getBlSCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rt_aply_dt_from", getRtAplyDtFrom());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_u_stl_prd", getBlUStlPrd());
		this.hashColumns.put("s_o_cnt", getSOCnt());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("s_c_stl_prd", getSCStlPrd());
		this.hashColumns.put("s_a_stl_prd", getSAStlPrd());
		this.hashColumns.put("bl_u_avg_stl_prd", getBlUAvgStlPrd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("s_b_cnt", getSBCnt());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("s_m_cnt", getSMCnt());
		this.hashColumns.put("s_m_stl_prd", getSMStlPrd());
		this.hashColumns.put("ttl_bl_cnt", getTtlBlCnt());
		this.hashColumns.put("rt_aply_dt_to", getRtAplyDtTo());
		this.hashColumns.put("ttl_avg_stl_prd", getTtlAvgStlPrd());
		this.hashColumns.put("kpi_more_than6", getKpiMoreThan6());
		this.hashColumns.put("kpi2_more_than6", getKpi2MoreThan6());
		this.hashColumns.put("bl_s_stl_prd", getBlSStlPrd());
		this.hashColumns.put("ttl_stl_prd", getTtlStlPrd());
		this.hashColumns.put("s_a_cnt", getSACnt());
		this.hashColumns.put("s_o_stl_prd", getSOStlPrd());
		this.hashColumns.put("bl_s_avg_stl_prd", getBlSAvgStlPrd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_c_cnt", "sCCnt");
		this.hashFields.put("s_b_stl_prd", "sBStlPrd");
		this.hashFields.put("bl_u_cnt", "blUCnt");
		this.hashFields.put("kpi_less_than6", "kpiLessThan6");
		this.hashFields.put("kpi2_less_than6", "kpi2LessThan6");
		this.hashFields.put("bl_s_cnt", "blSCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rt_aply_dt_from", "rtAplyDtFrom");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_u_stl_prd", "blUStlPrd");
		this.hashFields.put("s_o_cnt", "sOCnt");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("s_c_stl_prd", "sCStlPrd");
		this.hashFields.put("s_a_stl_prd", "sAStlPrd");
		this.hashFields.put("bl_u_avg_stl_prd", "blUAvgStlPrd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("s_b_cnt", "sBCnt");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("s_m_cnt", "sMCnt");
		this.hashFields.put("s_m_stl_prd", "sMStlPrd");
		this.hashFields.put("ttl_bl_cnt", "ttlBlCnt");
		this.hashFields.put("rt_aply_dt_to", "rtAplyDtTo");
		this.hashFields.put("ttl_avg_stl_prd", "ttlAvgStlPrd");
		this.hashFields.put("kpi_more_than6", "kpiMoreThan6");
		this.hashFields.put("kpi2_more_than6", "kpi2MoreThan6");
		this.hashFields.put("bl_s_stl_prd", "blSStlPrd");
		this.hashFields.put("ttl_stl_prd", "ttlStlPrd");
		this.hashFields.put("s_a_cnt", "sACnt");
		this.hashFields.put("s_o_stl_prd", "sOStlPrd");
		this.hashFields.put("bl_s_avg_stl_prd", "blSAvgStlPrd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCCnt
	 */
	public String getSCCnt() {
		return this.sCCnt;
	}
	
	/**
	 * Column Info
	 * @return sBStlPrd
	 */
	public String getSBStlPrd() {
		return this.sBStlPrd;
	}
	
	/**
	 * Column Info
	 * @return blUCnt
	 */
	public String getBlUCnt() {
		return this.blUCnt;
	}
	
	/**
	 * Column Info
	 * @return kpiLessThan6
	 */
	public String getKpiLessThan6() {
		return this.kpiLessThan6;
	}
	
	/**
	 * Column Info
	 * @return kpi2LessThan6
	 */
	public String getKpi2LessThan6() {
		return this.kpi2LessThan6;
	}
	
	/**
	 * Column Info
	 * @return blSCnt
	 */
	public String getBlSCnt() {
		return this.blSCnt;
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
	 * @return rtAplyDtFrom
	 */
	public String getRtAplyDtFrom() {
		return this.rtAplyDtFrom;
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
	 * @return blUStlPrd
	 */
	public String getBlUStlPrd() {
		return this.blUStlPrd;
	}
	
	/**
	 * Column Info
	 * @return sOCnt
	 */
	public String getSOCnt() {
		return this.sOCnt;
	}
	
	/**
	 * Column Info
	 * @return autoRatFlg
	 */
	public String getAutoRatFlg() {
		return this.autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return sCStlPrd
	 */
	public String getSCStlPrd() {
		return this.sCStlPrd;
	}
	
	/**
	 * Column Info
	 * @return sAStlPrd
	 */
	public String getSAStlPrd() {
		return this.sAStlPrd;
	}
	
	/**
	 * Column Info
	 * @return blUAvgStlPrd
	 */
	public String getBlUAvgStlPrd() {
		return this.blUAvgStlPrd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rctRhqCd
	 */
	public String getRctRhqCd() {
		return this.rctRhqCd;
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
	 * @return sBCnt
	 */
	public String getSBCnt() {
		return this.sBCnt;
	}
	
	/**
	 * Column Info
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
	}
	
	/**
	 * Column Info
	 * @return sMCnt
	 */
	public String getSMCnt() {
		return this.sMCnt;
	}
	
	/**
	 * Column Info
	 * @return sMStlPrd
	 */
	public String getSMStlPrd() {
		return this.sMStlPrd;
	}
	
	/**
	 * Column Info
	 * @return ttlBlCnt
	 */
	public String getTtlBlCnt() {
		return this.ttlBlCnt;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDtTo
	 */
	public String getRtAplyDtTo() {
		return this.rtAplyDtTo;
	}
	
	/**
	 * Column Info
	 * @return ttlAvgStlPrd
	 */
	public String getTtlAvgStlPrd() {
		return this.ttlAvgStlPrd;
	}
	
	/**
	 * Column Info
	 * @return kpiMoreThan6
	 */
	public String getKpiMoreThan6() {
		return this.kpiMoreThan6;
	}
	
	/**
	 * Column Info
	 * @return kpi2MoreThan6
	 */
	public String getKpi2MoreThan6() {
		return this.kpi2MoreThan6;
	}
	
	/**
	 * Column Info
	 * @return blSStlPrd
	 */
	public String getBlSStlPrd() {
		return this.blSStlPrd;
	}
	
	/**
	 * Column Info
	 * @return ttlStlPrd
	 */
	public String getTtlStlPrd() {
		return this.ttlStlPrd;
	}
	
	/**
	 * Column Info
	 * @return sACnt
	 */
	public String getSACnt() {
		return this.sACnt;
	}
	
	/**
	 * Column Info
	 * @return sOStlPrd
	 */
	public String getSOStlPrd() {
		return this.sOStlPrd;
	}
	
	/**
	 * Column Info
	 * @return blSAvgStlPrd
	 */
	public String getBlSAvgStlPrd() {
		return this.blSAvgStlPrd;
	}
	

	/**
	 * Column Info
	 * @param sCCnt
	 */
	public void setSCCnt(String sCCnt) {
		this.sCCnt = sCCnt;
	}
	
	/**
	 * Column Info
	 * @param sBStlPrd
	 */
	public void setSBStlPrd(String sBStlPrd) {
		this.sBStlPrd = sBStlPrd;
	}
	
	/**
	 * Column Info
	 * @param blUCnt
	 */
	public void setBlUCnt(String blUCnt) {
		this.blUCnt = blUCnt;
	}
	
	/**
	 * Column Info
	 * @param kpiLessThan6
	 */
	public void setKpiLessThan6(String kpiLessThan6) {
		this.kpiLessThan6 = kpiLessThan6;
	}
	
	/**
	 * Column Info
	 * @param kpi2LessThan6
	 */
	public void setKpi2LessThan6(String kpi2LessThan6) {
		this.kpi2LessThan6 = kpi2LessThan6;
	}
	
	/**
	 * Column Info
	 * @param blSCnt
	 */
	public void setBlSCnt(String blSCnt) {
		this.blSCnt = blSCnt;
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
	 * @param rtAplyDtFrom
	 */
	public void setRtAplyDtFrom(String rtAplyDtFrom) {
		this.rtAplyDtFrom = rtAplyDtFrom;
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
	 * @param blUStlPrd
	 */
	public void setBlUStlPrd(String blUStlPrd) {
		this.blUStlPrd = blUStlPrd;
	}
	
	/**
	 * Column Info
	 * @param sOCnt
	 */
	public void setSOCnt(String sOCnt) {
		this.sOCnt = sOCnt;
	}
	
	/**
	 * Column Info
	 * @param autoRatFlg
	 */
	public void setAutoRatFlg(String autoRatFlg) {
		this.autoRatFlg = autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param sCStlPrd
	 */
	public void setSCStlPrd(String sCStlPrd) {
		this.sCStlPrd = sCStlPrd;
	}
	
	/**
	 * Column Info
	 * @param sAStlPrd
	 */
	public void setSAStlPrd(String sAStlPrd) {
		this.sAStlPrd = sAStlPrd;
	}
	
	/**
	 * Column Info
	 * @param blUAvgStlPrd
	 */
	public void setBlUAvgStlPrd(String blUAvgStlPrd) {
		this.blUAvgStlPrd = blUAvgStlPrd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rctRhqCd
	 */
	public void setRctRhqCd(String rctRhqCd) {
		this.rctRhqCd = rctRhqCd;
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
	 * @param sBCnt
	 */
	public void setSBCnt(String sBCnt) {
		this.sBCnt = sBCnt;
	}
	
	/**
	 * Column Info
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	/**
	 * Column Info
	 * @param sMCnt
	 */
	public void setSMCnt(String sMCnt) {
		this.sMCnt = sMCnt;
	}
	
	/**
	 * Column Info
	 * @param sMStlPrd
	 */
	public void setSMStlPrd(String sMStlPrd) {
		this.sMStlPrd = sMStlPrd;
	}
	
	/**
	 * Column Info
	 * @param ttlBlCnt
	 */
	public void setTtlBlCnt(String ttlBlCnt) {
		this.ttlBlCnt = ttlBlCnt;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDtTo
	 */
	public void setRtAplyDtTo(String rtAplyDtTo) {
		this.rtAplyDtTo = rtAplyDtTo;
	}
	
	/**
	 * Column Info
	 * @param ttlAvgStlPrd
	 */
	public void setTtlAvgStlPrd(String ttlAvgStlPrd) {
		this.ttlAvgStlPrd = ttlAvgStlPrd;
	}
	
	/**
	 * Column Info
	 * @param kpiMoreThan6
	 */
	public void setKpiMoreThan6(String kpiMoreThan6) {
		this.kpiMoreThan6 = kpiMoreThan6;
	}
	
	/**
	 * Column Info
	 * @param kpi2MoreThan6
	 */
	public void setKpi2MoreThan6(String kpi2MoreThan6) {
		this.kpi2MoreThan6 = kpi2MoreThan6;
	}
	
	/**
	 * Column Info
	 * @param blSStlPrd
	 */
	public void setBlSStlPrd(String blSStlPrd) {
		this.blSStlPrd = blSStlPrd;
	}
	
	/**
	 * Column Info
	 * @param ttlStlPrd
	 */
	public void setTtlStlPrd(String ttlStlPrd) {
		this.ttlStlPrd = ttlStlPrd;
	}
	
	/**
	 * Column Info
	 * @param sACnt
	 */
	public void setSACnt(String sACnt) {
		this.sACnt = sACnt;
	}
	
	/**
	 * Column Info
	 * @param sOStlPrd
	 */
	public void setSOStlPrd(String sOStlPrd) {
		this.sOStlPrd = sOStlPrd;
	}
	
	/**
	 * Column Info
	 * @param blSAvgStlPrd
	 */
	public void setBlSAvgStlPrd(String blSAvgStlPrd) {
		this.blSAvgStlPrd = blSAvgStlPrd;
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
		setSCCnt(JSPUtil.getParameter(request, prefix + "s_c_cnt", ""));
		setSBStlPrd(JSPUtil.getParameter(request, prefix + "s_b_stl_prd", ""));
		setBlUCnt(JSPUtil.getParameter(request, prefix + "bl_u_cnt", ""));
		setKpiLessThan6(JSPUtil.getParameter(request, prefix + "kpi_less_than6", ""));
		setKpi2LessThan6(JSPUtil.getParameter(request, prefix + "kpi2_less_than6", ""));
		setBlSCnt(JSPUtil.getParameter(request, prefix + "bl_s_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRtAplyDtFrom(JSPUtil.getParameter(request, prefix + "rt_aply_dt_from", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlUStlPrd(JSPUtil.getParameter(request, prefix + "bl_u_stl_prd", ""));
		setSOCnt(JSPUtil.getParameter(request, prefix + "s_o_cnt", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setSCStlPrd(JSPUtil.getParameter(request, prefix + "s_c_stl_prd", ""));
		setSAStlPrd(JSPUtil.getParameter(request, prefix + "s_a_stl_prd", ""));
		setBlUAvgStlPrd(JSPUtil.getParameter(request, prefix + "bl_u_avg_stl_prd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setSBCnt(JSPUtil.getParameter(request, prefix + "s_b_cnt", ""));
		setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
		setSMCnt(JSPUtil.getParameter(request, prefix + "s_m_cnt", ""));
		setSMStlPrd(JSPUtil.getParameter(request, prefix + "s_m_stl_prd", ""));
		setTtlBlCnt(JSPUtil.getParameter(request, prefix + "ttl_bl_cnt", ""));
		setRtAplyDtTo(JSPUtil.getParameter(request, prefix + "rt_aply_dt_to", ""));
		setTtlAvgStlPrd(JSPUtil.getParameter(request, prefix + "ttl_avg_stl_prd", ""));
		setKpiMoreThan6(JSPUtil.getParameter(request, prefix + "kpi_more_than6", ""));
		setKpi2MoreThan6(JSPUtil.getParameter(request, prefix + "kpi2_more_than6", ""));
		setBlSStlPrd(JSPUtil.getParameter(request, prefix + "bl_s_stl_prd", ""));
		setTtlStlPrd(JSPUtil.getParameter(request, prefix + "ttl_stl_prd", ""));
		setSACnt(JSPUtil.getParameter(request, prefix + "s_a_cnt", ""));
		setSOStlPrd(JSPUtil.getParameter(request, prefix + "s_o_stl_prd", ""));
		setBlSAvgStlPrd(JSPUtil.getParameter(request, prefix + "bl_s_avg_stl_prd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnmatchSettlementListVO[]
	 */
	public UnmatchSettlementListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnmatchSettlementListVO[]
	 */
	public UnmatchSettlementListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnmatchSettlementListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCCnt = (JSPUtil.getParameter(request, prefix	+ "s_c_cnt", length));
			String[] sBStlPrd = (JSPUtil.getParameter(request, prefix	+ "s_b_stl_prd", length));
			String[] blUCnt = (JSPUtil.getParameter(request, prefix	+ "bl_u_cnt", length));
			String[] kpiLessThan6 = (JSPUtil.getParameter(request, prefix	+ "kpi_less_than6", length));
			String[] kpi2LessThan6 = (JSPUtil.getParameter(request, prefix	+ "kpi2_less_than6", length));
			String[] blSCnt = (JSPUtil.getParameter(request, prefix	+ "bl_s_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rtAplyDtFrom = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt_from", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blUStlPrd = (JSPUtil.getParameter(request, prefix	+ "bl_u_stl_prd", length));
			String[] sOCnt = (JSPUtil.getParameter(request, prefix	+ "s_o_cnt", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] sCStlPrd = (JSPUtil.getParameter(request, prefix	+ "s_c_stl_prd", length));
			String[] sAStlPrd = (JSPUtil.getParameter(request, prefix	+ "s_a_stl_prd", length));
			String[] blUAvgStlPrd = (JSPUtil.getParameter(request, prefix	+ "bl_u_avg_stl_prd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] sBCnt = (JSPUtil.getParameter(request, prefix	+ "s_b_cnt", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] sMCnt = (JSPUtil.getParameter(request, prefix	+ "s_m_cnt", length));
			String[] sMStlPrd = (JSPUtil.getParameter(request, prefix	+ "s_m_stl_prd", length));
			String[] ttlBlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_bl_cnt", length));
			String[] rtAplyDtTo = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt_to", length));
			String[] ttlAvgStlPrd = (JSPUtil.getParameter(request, prefix	+ "ttl_avg_stl_prd", length));
			String[] kpiMoreThan6 = (JSPUtil.getParameter(request, prefix	+ "kpi_more_than6", length));
			String[] kpi2MoreThan6 = (JSPUtil.getParameter(request, prefix	+ "kpi2_more_than6", length));
			String[] blSStlPrd = (JSPUtil.getParameter(request, prefix	+ "bl_s_stl_prd", length));
			String[] ttlStlPrd = (JSPUtil.getParameter(request, prefix	+ "ttl_stl_prd", length));
			String[] sACnt = (JSPUtil.getParameter(request, prefix	+ "s_a_cnt", length));
			String[] sOStlPrd = (JSPUtil.getParameter(request, prefix	+ "s_o_stl_prd", length));
			String[] blSAvgStlPrd = (JSPUtil.getParameter(request, prefix	+ "bl_s_avg_stl_prd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnmatchSettlementListVO();
				if (sCCnt[i] != null)
					model.setSCCnt(sCCnt[i]);
				if (sBStlPrd[i] != null)
					model.setSBStlPrd(sBStlPrd[i]);
				if (blUCnt[i] != null)
					model.setBlUCnt(blUCnt[i]);
				if (kpiLessThan6[i] != null)
					model.setKpiLessThan6(kpiLessThan6[i]);
				if (kpi2LessThan6[i] != null)
					model.setKpi2LessThan6(kpi2LessThan6[i]);
				if (blSCnt[i] != null)
					model.setBlSCnt(blSCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rtAplyDtFrom[i] != null)
					model.setRtAplyDtFrom(rtAplyDtFrom[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blUStlPrd[i] != null)
					model.setBlUStlPrd(blUStlPrd[i]);
				if (sOCnt[i] != null)
					model.setSOCnt(sOCnt[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (sCStlPrd[i] != null)
					model.setSCStlPrd(sCStlPrd[i]);
				if (sAStlPrd[i] != null)
					model.setSAStlPrd(sAStlPrd[i]);
				if (blUAvgStlPrd[i] != null)
					model.setBlUAvgStlPrd(blUAvgStlPrd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (sBCnt[i] != null)
					model.setSBCnt(sBCnt[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (sMCnt[i] != null)
					model.setSMCnt(sMCnt[i]);
				if (sMStlPrd[i] != null)
					model.setSMStlPrd(sMStlPrd[i]);
				if (ttlBlCnt[i] != null)
					model.setTtlBlCnt(ttlBlCnt[i]);
				if (rtAplyDtTo[i] != null)
					model.setRtAplyDtTo(rtAplyDtTo[i]);
				if (ttlAvgStlPrd[i] != null)
					model.setTtlAvgStlPrd(ttlAvgStlPrd[i]);
				if (kpiMoreThan6[i] != null)
					model.setKpiMoreThan6(kpiMoreThan6[i]);
				if (kpi2MoreThan6[i] != null)
					model.setKpi2MoreThan6(kpi2MoreThan6[i]);
				if (blSStlPrd[i] != null)
					model.setBlSStlPrd(blSStlPrd[i]);
				if (ttlStlPrd[i] != null)
					model.setTtlStlPrd(ttlStlPrd[i]);
				if (sACnt[i] != null)
					model.setSACnt(sACnt[i]);
				if (sOStlPrd[i] != null)
					model.setSOStlPrd(sOStlPrd[i]);
				if (blSAvgStlPrd[i] != null)
					model.setBlSAvgStlPrd(blSAvgStlPrd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnmatchSettlementListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnmatchSettlementListVO[]
	 */
	public UnmatchSettlementListVO[] getUnmatchSettlementListVOs(){
		UnmatchSettlementListVO[] vos = (UnmatchSettlementListVO[])models.toArray(new UnmatchSettlementListVO[models.size()]);
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
		this.sCCnt = this.sCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBStlPrd = this.sBStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blUCnt = this.blUCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiLessThan6 = this.kpiLessThan6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpi2LessThan6 = this.kpi2LessThan6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSCnt = this.blSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDtFrom = this.rtAplyDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blUStlPrd = this.blUStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOCnt = this.sOCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCStlPrd = this.sCStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAStlPrd = this.sAStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blUAvgStlPrd = this.blUAvgStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBCnt = this.sBCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMCnt = this.sMCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMStlPrd = this.sMStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBlCnt = this.ttlBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDtTo = this.rtAplyDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAvgStlPrd = this.ttlAvgStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiMoreThan6 = this.kpiMoreThan6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpi2MoreThan6 = this.kpi2MoreThan6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSStlPrd = this.blSStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlStlPrd = this.ttlStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sACnt = this.sACnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOStlPrd = this.sOStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSAvgStlPrd = this.blSAvgStlPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
