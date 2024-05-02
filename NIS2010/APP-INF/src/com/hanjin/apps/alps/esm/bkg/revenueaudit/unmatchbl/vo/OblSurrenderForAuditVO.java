/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OblSurrenderForAuditVO.java
*@FileTitle : OblSurrenderForAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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

public class OblSurrenderForAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OblSurrenderForAuditVO> models = new ArrayList<OblSurrenderForAuditVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String searchDate = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	/* Column Info */
	private String blCnt = null;
	
	
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String chgAmdRsn = null;
	/* Column Info */
	private String chgAmdRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OblSurrenderForAuditVO() {}

	public OblSurrenderForAuditVO(String ibflag, String pagerows, String bkgNo, String rtAplyDt, String blNo, String svcScpCd, String porCd, String polCd, String podCd, String delCd, String bkgCtrtTpCd, String ctrtNo, String oblRdemOfcCd, String currCd, String chgUtAmt, String ratAsQty, String ratUtCd, String chgAmt, String frtInclXcldDivCd, String invCurrCd, String invChgAmt, String blCnt, String bkgRhqCd, String bkgOfcCd, String searchDate, String fmDt, String toDt, String tVvd, String bdrFlg, String chgAmdRmk, String chgAmdRsn, String aproUsrNm, String aproDt, String aproOfcCd, String aproFlg) {
		this.porCd = porCd;
		this.currCd = currCd;
		this.bdrFlg = bdrFlg;
		this.svcScpCd = svcScpCd;
		this.rtAplyDt = rtAplyDt;
		this.bkgRhqCd = bkgRhqCd;
		this.searchDate = searchDate;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.tVvd = tVvd;
		this.chgAmt = chgAmt;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.chgUtAmt = chgUtAmt;
		this.bkgOfcCd = bkgOfcCd;
		this.fmDt = fmDt;
		this.invChgAmt = invChgAmt;
		this.delCd = delCd;
		this.ratUtCd = ratUtCd;
		this.invCurrCd = invCurrCd;
		this.toDt = toDt;
		this.podCd = podCd;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
		this.bkgNo = bkgNo;
		this.ratAsQty = ratAsQty;
		this.oblRdemOfcCd = oblRdemOfcCd;
		this.blCnt = blCnt;
		
		this.aproFlg = aproFlg;
		this.aproOfcCd = aproOfcCd;
		this.aproDt = aproDt;
		this.aproUsrNm = aproUsrNm;
		this.chgAmdRsn = chgAmdRsn;
		this.chgAmdRmk = chgAmdRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("search_date", getSearchDate());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		this.hashColumns.put("bl_cnt", getBlCnt());
		
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("chg_amd_rsn", getChgAmdRsn());
		this.hashColumns.put("chg_amd_rmk", getChgAmdRmk());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("search_date", "searchDate");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		this.hashFields.put("bl_cnt", "blCnt");
		
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("chg_amd_rsn", "chgAmdRsn");
		this.hashFields.put("chg_amd_rmk", "chgAmdRmk");
		
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return searchDate
	 */
	public String getSearchDate() {
		return this.searchDate;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
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
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
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
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	/**
	 * Column Info
	 * @return chgAmdRsn
	 */
	public String getChgAmdRsn() {
		return this.chgAmdRsn;
	}
	/**
	 * Column Info
	 * @return chgAmdRmk
	 */
	public String getChgAmdRmk() {
		return this.chgAmdRmk;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param searchDate
	 */
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
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
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param frtInclXcldDivCd
	 */
	public void setFrtInclXcldDivCd(String frtInclXcldDivCd) {
		this.frtInclXcldDivCd = frtInclXcldDivCd;
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
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}
	
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	/**
	 * Column Info
	 * @param chgAmdRsn
	 */
	public void setChgAmdRsn(String chgAmdRsn) {
		this.chgAmdRsn = chgAmdRsn;
	}
	/**
	 * Column Info
	 * @param chgAmdRmk
	 */
	public void setChgAmdRmk(String chgAmdRmk) {
		this.chgAmdRmk = chgAmdRmk;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setSearchDate(JSPUtil.getParameter(request, prefix + "search_date", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, prefix + "obl_rdem_ofc_cd", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setChgAmdRsn(JSPUtil.getParameter(request, prefix + "chg_amd_rsn", ""));
		setChgAmdRmk(JSPUtil.getParameter(request, prefix + "chg_amd_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OblSurrenderForAuditVO[]
	 */
	public OblSurrenderForAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OblSurrenderForAuditVO[]
	 */
	public OblSurrenderForAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OblSurrenderForAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] searchDate = (JSPUtil.getParameter(request, prefix	+ "search_date", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] chgAmdRsn = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rsn", length));
			String[] chgAmdRmk = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new OblSurrenderForAuditVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (searchDate[i] != null)
					model.setSearchDate(searchDate[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (chgAmdRsn[i] != null)
					model.setChgAmdRsn(chgAmdRsn[i]);
				if (chgAmdRmk[i] != null)
					model.setChgAmdRmk(chgAmdRmk[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOblSurrenderForAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OblSurrenderForAuditVO[]
	 */
	public OblSurrenderForAuditVO[] getOblSurrenderForAuditVOs(){
		OblSurrenderForAuditVO[] vos = (OblSurrenderForAuditVO[])models.toArray(new OblSurrenderForAuditVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDate = this.searchDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRsn = this.chgAmdRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRmk = this.chgAmdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
