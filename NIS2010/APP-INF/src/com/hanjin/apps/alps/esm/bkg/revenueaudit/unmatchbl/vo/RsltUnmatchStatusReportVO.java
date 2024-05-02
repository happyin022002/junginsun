/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltUnmatchStatusReportVO.java
*@FileTitle : RsltUnmatchStatusReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.02.08 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltUnmatchStatusReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltUnmatchStatusReportVO> models = new ArrayList<RsltUnmatchStatusReportVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String uECnt = null;
	/* Column Info */
	private String uBCnt = null;
	/* Column Info */
	private String sBCnt = null;
	/* Column Info */
	private String stlMnlDiffAmt = null;
	/* Column Info */
	private String sCCnt = null;
	/* Column Info */
	private String settleTerm = null;
	/* Column Info */
	private String uACnt = null;
	/* Column Info */
	private String uAlCnt = null;
	/* Column Info */
	private String uAllCnt = null;
	/* Column Info */
	private String blUCnt = null;
	/* Column Info */
	private String uCCnt = null;
	/* Column Info */
	private String uFCnt = null;
	/* Column Info */
	private String uGCnt = null;
	/* Column Info */
	private String sFCnt = null;
	/* Column Info */
	private String sGCnt = null;
	/* Column Info */
	private String blSCnt = null;
	/* Column Info */
	private String rtAplyDtFrom = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtAplyDtTo = null;
	/* Column Info */
	private String sECnt = null;
	/* Column Info */
	private String sACnt = null;
	/* Column Info */
	private String sAlCnt = null;
	/* Column Info */
	private String sAllCnt = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String uDCnt = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String sDCnt = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String ttlBkgCnt = null;
	/* Column Info */
	private String errBlTtl = null;
	/* Column Info */
	private String errRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltUnmatchStatusReportVO() {}

	public RsltUnmatchStatusReportVO(String uAlCnt,String uAllCnt,String sAlCnt,String sAllCnt, String ibflag, String pagerows, String rctRhqCd, String bkgOfcCd, String settleTerm, String blUCnt, String blSCnt, String uACnt, String uBCnt, String uCCnt, String uDCnt, String uECnt, String uFCnt, String uGCnt, String sACnt, String sBCnt, String sCCnt, String sDCnt, String sECnt, String sFCnt, String sGCnt, String stlMnlDiffAmt, String rtAplyDtFrom, String rtAplyDtTo, String bkgCtrtTpCd, String autoRatFlg, String dateType, String ttlBkgCnt, String errBlTtl, String errRto) {
		this.bkgOfcCd = bkgOfcCd;
		this.uECnt = uECnt;
		this.uBCnt = uBCnt;
		this.sBCnt = sBCnt;
		this.stlMnlDiffAmt = stlMnlDiffAmt;
		this.sCCnt = sCCnt;
		this.settleTerm = settleTerm;
		this.uACnt = uACnt;
		this.uAlCnt = uAlCnt;
		this.uAllCnt = uAllCnt;
		this.blUCnt = blUCnt;
		this.uCCnt = uCCnt;
		this.uFCnt = uFCnt;
		this.uGCnt = uGCnt;
		this.sFCnt = sFCnt;
		this.sGCnt = sGCnt;
		this.blSCnt = blSCnt;
		this.rtAplyDtFrom = rtAplyDtFrom;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rtAplyDtTo = rtAplyDtTo;
		this.sECnt = sECnt;
		this.sACnt = sACnt;
		this.sAlCnt = sAlCnt;
		this.sAllCnt = sAllCnt;
		this.autoRatFlg = autoRatFlg;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.uDCnt = uDCnt;
		this.rctRhqCd = rctRhqCd;
		this.sDCnt = sDCnt;
		this.dateType = dateType;
		this.ttlBkgCnt = ttlBkgCnt;
		this.errBlTtl = errBlTtl;
		this.errRto = errRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("u_e_cnt", getUECnt());
		this.hashColumns.put("u_b_cnt", getUBCnt());
		this.hashColumns.put("s_b_cnt", getSBCnt());
		this.hashColumns.put("stl_mnl_diff_amt", getStlMnlDiffAmt());
		this.hashColumns.put("s_c_cnt", getSCCnt());
		this.hashColumns.put("settle_term", getSettleTerm());
		this.hashColumns.put("u_a_cnt", getUACnt());
		this.hashColumns.put("u_al_cnt", getUAlCnt());
		this.hashColumns.put("u_all_cnt", getUAllCnt());
		
		this.hashColumns.put("bl_u_cnt", getBlUCnt());
		this.hashColumns.put("u_c_cnt", getUCCnt());
		this.hashColumns.put("u_f_cnt", getUFCnt());
		this.hashColumns.put("u_g_cnt", getUGCnt());
		this.hashColumns.put("s_f_cnt", getSFCnt());
		this.hashColumns.put("s_g_cnt", getSGCnt());
		this.hashColumns.put("bl_s_cnt", getBlSCnt());
		this.hashColumns.put("rt_aply_dt_from", getRtAplyDtFrom());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_aply_dt_to", getRtAplyDtTo());
		this.hashColumns.put("s_e_cnt", getSECnt());
		this.hashColumns.put("s_a_cnt", getSACnt());
		this.hashColumns.put("s_al_cnt", getSAlCnt());
		this.hashColumns.put("s_all_cnt", getSAllCnt());
		
		
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("u_d_cnt", getUDCnt());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("s_d_cnt", getSDCnt());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("ttl_bkg_cnt", getTtlBkgCnt());
		this.hashColumns.put("err_bl_ttl", getErrBlTtl());
		this.hashColumns.put("err_rto", getErrRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("u_e_cnt", "uECnt");
		this.hashFields.put("u_b_cnt", "uBCnt");
		this.hashFields.put("s_b_cnt", "sBCnt");
		this.hashFields.put("stl_mnl_diff_amt", "stlMnlDiffAmt");
		this.hashFields.put("s_c_cnt", "sCCnt");
		this.hashFields.put("settle_term", "settleTerm");
		this.hashFields.put("u_a_cnt", "uACnt");
		this.hashFields.put("u_al_cnt", "uAlCnt");
		this.hashFields.put("u_all_cnt", "uAllCnt");
		
		this.hashFields.put("bl_u_cnt", "blUCnt");
		this.hashFields.put("u_c_cnt", "uCCnt");
		this.hashFields.put("u_f_cnt", "uFCnt");
		this.hashFields.put("u_g_cnt", "uGCnt");
		this.hashFields.put("s_f_cnt", "sFCnt");
		this.hashFields.put("s_g_cnt", "sGCnt");
		this.hashFields.put("bl_s_cnt", "blSCnt");
		this.hashFields.put("rt_aply_dt_from", "rtAplyDtFrom");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_aply_dt_to", "rtAplyDtTo");
		this.hashFields.put("s_e_cnt", "sECnt");
		this.hashFields.put("s_a_cnt", "sACnt");
		this.hashFields.put("s_al_cnt", "sAlCnt");
		this.hashFields.put("s_all_cnt", "sAllCnt");
		
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("u_d_cnt", "uDCnt");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("s_d_cnt", "sDCnt");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("ttl_bkg_cnt", "ttlBkgCnt");
		this.hashFields.put("err_bl_ttl", "errBlTtl");
		this.hashFields.put("err_rto", "errRto");
		return this.hashFields;
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
	 * @return uECnt
	 */
	public String getUECnt() {
		return this.uECnt;
	}
	
	/**
	 * Column Info
	 * @return uBCnt
	 */
	public String getUBCnt() {
		return this.uBCnt;
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
	 * @return stlMnlDiffAmt
	 */
	public String getStlMnlDiffAmt() {
		return this.stlMnlDiffAmt;
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
	 * @return settleTerm
	 */
	public String getSettleTerm() {
		return this.settleTerm;
	}
	
	/**
	 * Column Info
	 * @return uACnt
	 */
	public String getUACnt() {
		return this.uACnt;
	}
	
	/**
	 * Column Info
	 * @return uACnt
	 */
	public String getUAlCnt() {
		return this.uAlCnt;
	}
	
	/**
	 * Column Info
	 * @return uACnt
	 */
	public String getUAllCnt() {
		return this.uAllCnt;
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
	 * @return uCCnt
	 */
	public String getUCCnt() {
		return this.uCCnt;
	}
	
	/**
	 * Column Info
	 * @return uFCnt
	 */
	public String getUFCnt() {
		return this.uFCnt;
	}
	
	/**
	 * Column Info
	 * @return uGCnt
	 */
	public String getUGCnt() {
		return this.uGCnt;
	}
	
	/**
	 * Column Info
	 * @return sFCnt
	 */
	public String getSFCnt() {
		return this.sFCnt;
	}
	
	/**
	 * Column Info
	 * @return sGCnt
	 */
	public String getSGCnt() {
		return this.sGCnt;
	}
	
	/**
	 * Column Info
	 * @return blSCnt
	 */
	public String getBlSCnt() {
		return this.blSCnt;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDtFrom
	 */
	public String getRtAplyDtFrom() {
		return this.rtAplyDtFrom;
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
	 * @return rtAplyDtTo
	 */
	public String getRtAplyDtTo() {
		return this.rtAplyDtTo;
	}
	
	/**
	 * Column Info
	 * @return sECnt
	 */
	public String getSECnt() {
		return this.sECnt;
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
	 * @return sACnt
	 */
	public String getSAlCnt() {
		return this.sAlCnt;
	}
	
	/**
	 * Column Info
	 * @return sACnt
	 */
	public String getSAllCnt() {
		return this.sAllCnt;
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
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return uDCnt
	 */
	public String getUDCnt() {
		return this.uDCnt;
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
	 * @return sDCnt
	 */
	public String getSDCnt() {
		return this.sDCnt;
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
	 * @return ttlBkgCnt
	 */
	public String getTtlBkgCnt() {
		return this.ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return errBlTtl
	 */
	public String getErrBlTtl() {
		return this.errBlTtl;
	}
	
	/**
	 * Column Info
	 * @return errRto
	 */
	public String getErrRto() {
		return this.errRto;
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
	 * @param uECnt
	 */
	public void setUECnt(String uECnt) {
		this.uECnt = uECnt;
	}
	
	/**
	 * Column Info
	 * @param uBCnt
	 */
	public void setUBCnt(String uBCnt) {
		this.uBCnt = uBCnt;
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
	 * @param stlMnlDiffAmt
	 */
	public void setStlMnlDiffAmt(String stlMnlDiffAmt) {
		this.stlMnlDiffAmt = stlMnlDiffAmt;
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
	 * @param settleTerm
	 */
	public void setSettleTerm(String settleTerm) {
		this.settleTerm = settleTerm;
	}
	
	/**
	 * Column Info
	 * @param uACnt
	 */
	public void setUACnt(String uACnt) {
		this.uACnt = uACnt;
	}
	
	/**
	 * Column Info
	 * @param uACnt
	 */
	public void setUAlCnt(String uAlCnt) {
		this.uAlCnt = uAlCnt;
	}
	
	/**
	 * Column Info
	 * @param uACnt
	 */
	public void setUAllCnt(String uAllCnt) {
		this.uAllCnt = uAllCnt;
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
	 * @param uCCnt
	 */
	public void setUCCnt(String uCCnt) {
		this.uCCnt = uCCnt;
	}
	
	/**
	 * Column Info
	 * @param uFCnt
	 */
	public void setUFCnt(String uFCnt) {
		this.uFCnt = uFCnt;
	}
	
	/**
	 * Column Info
	 * @param uGCnt
	 */
	public void setUGCnt(String uGCnt) {
		this.uGCnt = uGCnt;
	}
	
	/**
	 * Column Info
	 * @param sFCnt
	 */
	public void setSFCnt(String sFCnt) {
		this.sFCnt = sFCnt;
	}
	
	/**
	 * Column Info
	 * @param sGCnt
	 */
	public void setSGCnt(String sGCnt) {
		this.sGCnt = sGCnt;
	}
	
	/**
	 * Column Info
	 * @param blSCnt
	 */
	public void setBlSCnt(String blSCnt) {
		this.blSCnt = blSCnt;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDtFrom
	 */
	public void setRtAplyDtFrom(String rtAplyDtFrom) {
		this.rtAplyDtFrom = rtAplyDtFrom;
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
	 * @param rtAplyDtTo
	 */
	public void setRtAplyDtTo(String rtAplyDtTo) {
		this.rtAplyDtTo = rtAplyDtTo;
	}
	
	/**
	 * Column Info
	 * @param sECnt
	 */
	public void setSECnt(String sECnt) {
		this.sECnt = sECnt;
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
	 * @param sACnt
	 */
	public void setSAlCnt(String sAlCnt) {
		this.sAlCnt = sAlCnt;
	}
	
	/**
	 * Column Info
	 * @param sACnt
	 */
	public void setSAllCnt(String sAllCnt) {
		this.sAllCnt = sAllCnt;
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
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param uDCnt
	 */
	public void setUDCnt(String uDCnt) {
		this.uDCnt = uDCnt;
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
	 * @param sDCnt
	 */
	public void setSDCnt(String sDCnt) {
		this.sDCnt = sDCnt;
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
	 * @param ttlBkgCnt
	 */
	public void setTtlBkgCnt(String ttlBkgCnt) {
		this.ttlBkgCnt = ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param errBlTtl
	 */
	public void setErrBlTtl(String errBlTtl) {
		this.errBlTtl = errBlTtl;
	}
	
	/**
	 * Column Info
	 * @param errRto
	 */
	public void setErrRto(String errRto) {
		this.errRto = errRto;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setUECnt(JSPUtil.getParameter(request, prefix + "u_e_cnt", ""));
		setUBCnt(JSPUtil.getParameter(request, prefix + "u_b_cnt", ""));
		setSBCnt(JSPUtil.getParameter(request, prefix + "s_b_cnt", ""));
		setStlMnlDiffAmt(JSPUtil.getParameter(request, prefix + "stl_mnl_diff_amt", ""));
		setSCCnt(JSPUtil.getParameter(request, prefix + "s_c_cnt", ""));
		setSettleTerm(JSPUtil.getParameter(request, prefix + "settle_term", ""));
		setUACnt(JSPUtil.getParameter(request, prefix + "u_a_cnt", ""));
		setUAlCnt(JSPUtil.getParameter(request, prefix + "u_al_cnt", ""));
		setUAllCnt(JSPUtil.getParameter(request, prefix + "u_all_cnt", ""));
		
		setBlUCnt(JSPUtil.getParameter(request, prefix + "bl_u_cnt", ""));
		setUCCnt(JSPUtil.getParameter(request, prefix + "u_c_cnt", ""));
		setUFCnt(JSPUtil.getParameter(request, prefix + "u_f_cnt", ""));
		setUGCnt(JSPUtil.getParameter(request, prefix + "u_g_cnt", ""));
		setSFCnt(JSPUtil.getParameter(request, prefix + "s_f_cnt", ""));
		setSGCnt(JSPUtil.getParameter(request, prefix + "s_g_cnt", ""));
		setBlSCnt(JSPUtil.getParameter(request, prefix + "bl_s_cnt", ""));
		setRtAplyDtFrom(JSPUtil.getParameter(request, prefix + "rt_aply_dt_from", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtAplyDtTo(JSPUtil.getParameter(request, prefix + "rt_aply_dt_to", ""));
		setSECnt(JSPUtil.getParameter(request, prefix + "s_e_cnt", ""));
		setSACnt(JSPUtil.getParameter(request, prefix + "s_a_cnt", ""));
		setSAlCnt(JSPUtil.getParameter(request, prefix + "s_al_cnt", ""));
		setSAllCnt(JSPUtil.getParameter(request, prefix + "s_all_cnt", ""));
		
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setUDCnt(JSPUtil.getParameter(request, prefix + "u_d_cnt", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setSDCnt(JSPUtil.getParameter(request, prefix + "s_d_cnt", ""));
		setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
		setTtlBkgCnt(JSPUtil.getParameter(request, prefix + "ttl_bkg_cnt", ""));
		setErrBlTtl(JSPUtil.getParameter(request, prefix + "err_bl_ttl", ""));
		setErrRto(JSPUtil.getParameter(request, prefix + "err_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltUnmatchStatusReportVO[]
	 */
	public RsltUnmatchStatusReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltUnmatchStatusReportVO[]
	 */
	public RsltUnmatchStatusReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltUnmatchStatusReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] uECnt = (JSPUtil.getParameter(request, prefix	+ "u_e_cnt", length));
			String[] uBCnt = (JSPUtil.getParameter(request, prefix	+ "u_b_cnt", length));
			String[] sBCnt = (JSPUtil.getParameter(request, prefix	+ "s_b_cnt", length));
			String[] stlMnlDiffAmt = (JSPUtil.getParameter(request, prefix	+ "stl_mnl_diff_amt", length));
			String[] sCCnt = (JSPUtil.getParameter(request, prefix	+ "s_c_cnt", length));
			String[] settleTerm = (JSPUtil.getParameter(request, prefix	+ "settle_term", length));
			String[] uACnt = (JSPUtil.getParameter(request, prefix	+ "u_a_cnt", length));
			String[] uAlCnt = (JSPUtil.getParameter(request, prefix	+ "u_al_cnt", length));
			String[] uAllCnt = (JSPUtil.getParameter(request, prefix	+ "u_all_cnt", length));
			
			String[] blUCnt = (JSPUtil.getParameter(request, prefix	+ "bl_u_cnt", length));
			String[] uCCnt = (JSPUtil.getParameter(request, prefix	+ "u_c_cnt", length));
			String[] uFCnt = (JSPUtil.getParameter(request, prefix	+ "u_f_cnt", length));
			String[] uGCnt = (JSPUtil.getParameter(request, prefix	+ "u_g_cnt", length));
			String[] sFCnt = (JSPUtil.getParameter(request, prefix	+ "s_f_cnt", length));
			String[] sGCnt = (JSPUtil.getParameter(request, prefix	+ "s_g_cnt", length));
			String[] blSCnt = (JSPUtil.getParameter(request, prefix	+ "bl_s_cnt", length));
			String[] rtAplyDtFrom = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt_from", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtAplyDtTo = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt_to", length));
			String[] sECnt = (JSPUtil.getParameter(request, prefix	+ "s_e_cnt", length));
			String[] sACnt = (JSPUtil.getParameter(request, prefix	+ "s_a_cnt", length));
			String[] sAlCnt = (JSPUtil.getParameter(request, prefix	+ "s_al_cnt", length));
			String[] sAllCnt = (JSPUtil.getParameter(request, prefix	+ "s_all_cnt", length));
			
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] uDCnt = (JSPUtil.getParameter(request, prefix	+ "u_d_cnt", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] sDCnt = (JSPUtil.getParameter(request, prefix	+ "s_d_cnt", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] ttlBkgCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg_cnt", length));
			String[] errBlTtl = (JSPUtil.getParameter(request, prefix	+ "err_bl_ttl", length));
			String[] errRto = (JSPUtil.getParameter(request, prefix	+ "err_rto", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltUnmatchStatusReportVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (uECnt[i] != null)
					model.setUECnt(uECnt[i]);
				if (uBCnt[i] != null)
					model.setUBCnt(uBCnt[i]);
				if (sBCnt[i] != null)
					model.setSBCnt(sBCnt[i]);
				if (stlMnlDiffAmt[i] != null)
					model.setStlMnlDiffAmt(stlMnlDiffAmt[i]);
				if (sCCnt[i] != null)
					model.setSCCnt(sCCnt[i]);
				if (settleTerm[i] != null)
					model.setSettleTerm(settleTerm[i]);
				if (uACnt[i] != null)
					model.setUACnt(uACnt[i]);
				if (uAlCnt[i] != null)
					model.setUAlCnt(uAlCnt[i]);
				if (uAllCnt[i] != null)
					model.setUAllCnt(uAllCnt[i]);
				
				if (blUCnt[i] != null)
					model.setBlUCnt(blUCnt[i]);
				if (uCCnt[i] != null)
					model.setUCCnt(uCCnt[i]);
				if (uFCnt[i] != null)
					model.setUFCnt(uFCnt[i]);
				if (uGCnt[i] != null)
					model.setUGCnt(uGCnt[i]);
				if (sFCnt[i] != null)
					model.setSFCnt(sFCnt[i]);
				if (sGCnt[i] != null)
					model.setSGCnt(sGCnt[i]);
				if (blSCnt[i] != null)
					model.setBlSCnt(blSCnt[i]);
				if (rtAplyDtFrom[i] != null)
					model.setRtAplyDtFrom(rtAplyDtFrom[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtAplyDtTo[i] != null)
					model.setRtAplyDtTo(rtAplyDtTo[i]);
				if (sECnt[i] != null)
					model.setSECnt(sECnt[i]);
				if (sACnt[i] != null)
					model.setSACnt(sACnt[i]);
				if (sAlCnt[i] != null)
					model.setSAlCnt(sAlCnt[i]);
				if (sAllCnt[i] != null)
					model.setSAllCnt(sAllCnt[i]);
				
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (uDCnt[i] != null)
					model.setUDCnt(uDCnt[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (sDCnt[i] != null)
					model.setSDCnt(sDCnt[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (ttlBkgCnt[i] != null)
					model.setTtlBkgCnt(ttlBkgCnt[i]);
				if (errBlTtl[i] != null)
					model.setErrBlTtl(errBlTtl[i]);
				if (errRto[i] != null)
					model.setErrRto(errRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltUnmatchStatusReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltUnmatchStatusReportVO[]
	 */
	public RsltUnmatchStatusReportVO[] getRsltUnmatchStatusReportVOs(){
		RsltUnmatchStatusReportVO[] vos = (RsltUnmatchStatusReportVO[])models.toArray(new RsltUnmatchStatusReportVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uECnt = this.uECnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uBCnt = this.uBCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBCnt = this.sBCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlMnlDiffAmt = this.stlMnlDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCCnt = this.sCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.settleTerm = this.settleTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uACnt = this.uACnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uAlCnt = this.uAlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uAllCnt = this.uAllCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.blUCnt = this.blUCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uCCnt = this.uCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uFCnt = this.uFCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uGCnt = this.uGCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFCnt = this.sFCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGCnt = this.sGCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSCnt = this.blSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDtFrom = this.rtAplyDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDtTo = this.rtAplyDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sECnt = this.sECnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sACnt = this.sACnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAlCnt = this.sAlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAllCnt = this.sAllCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uDCnt = this.uDCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDCnt = this.sDCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkgCnt = this.ttlBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errBlTtl = this.errBlTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errRto = this.errRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
