/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NonAutoratedChargeVO.java
*@FileTitle : NonAutoratedChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.22  
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

public class NonAutoratedChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NonAutoratedChargeVO> models = new ArrayList<NonAutoratedChargeVO>();
	
	/* Column Info */
	private String hisCurrCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String searchDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgAutoRatCd = null;
	/* Column Info */
	private String ctrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rtCngHis = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String bkgChgAmt = null;
	/* Column Info */
	private String hisRatAsQty = null;
	/* Column Info */
	private String hisChgAmt = null;
	/* Column Info */
	private String hisRatUtCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String hisChgCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String bkgCurrCd = null;
	/* Column Info */
	private String bkgChgUtAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String hisChgUtAmt = null;
	/* Column Info */
	private String bkgRatAsQty = null;
	/* Column Info */
	private String bkgChgCd = null;
	/* Column Info */
	private String bkgRatUtCd = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String autoRatCd = null;
	/* Column Info */
	private String chgCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NonAutoratedChargeVO() {}

	public NonAutoratedChargeVO(String ibflag, String pagerows, String bkgRhqCd, String bkgOfcCd, String bkgNo, String rtAplyDt, String bdrFlg, String cmdtCd, String cmdtNm, String svcScpCd, String rtCngHis, String porCd, String polCd, String podCd, String delCd, String bkgCtrtTpCd, String ctrtNo, String bkgChgCd, String bkgCurrCd, String bkgChgUtAmt, String bkgRatUtCd, String bkgRatAsQty, String bkgChgAmt, String bkgAutoRatCd, String hisChgCd, String hisCurrCd, String hisChgUtAmt, String hisRatUtCd, String hisRatAsQty, String hisChgAmt, String blCnt, String searchDate, String fmDt, String toDt, String chgCd, String autoRatCd) {
		this.hisCurrCd = hisCurrCd;
		this.porCd = porCd;
		this.svcScpCd = svcScpCd;
		this.bdrFlg = bdrFlg;
		this.rtAplyDt = rtAplyDt;
		this.bkgRhqCd = bkgRhqCd;
		this.searchDate = searchDate;
		this.pagerows = pagerows;
		this.bkgAutoRatCd = bkgAutoRatCd;
		this.ctrtNo = ctrtNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.rtCngHis = rtCngHis;
		this.cmdtCd = cmdtCd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.bkgChgAmt = bkgChgAmt;
		this.hisRatAsQty = hisRatAsQty;
		this.hisChgAmt = hisChgAmt;
		this.hisRatUtCd = hisRatUtCd;
		this.bkgOfcCd = bkgOfcCd;
		this.hisChgCd = hisChgCd;
		this.fmDt = fmDt;
		this.bkgCurrCd = bkgCurrCd;
		this.bkgChgUtAmt = bkgChgUtAmt;
		this.delCd = delCd;
		this.cmdtNm = cmdtNm;
		this.toDt = toDt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.hisChgUtAmt = hisChgUtAmt;
		this.bkgRatAsQty = bkgRatAsQty;
		this.bkgChgCd = bkgChgCd;
		this.bkgRatUtCd = bkgRatUtCd;
		this.blCnt = blCnt;
		this.autoRatCd = autoRatCd;
		this.chgCd = chgCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("his_curr_cd", getHisCurrCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("search_date", getSearchDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_auto_rat_cd", getBkgAutoRatCd());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rt_cng_his", getRtCngHis());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("bkg_chg_amt", getBkgChgAmt());
		this.hashColumns.put("his_rat_as_qty", getHisRatAsQty());
		this.hashColumns.put("his_chg_amt", getHisChgAmt());
		this.hashColumns.put("his_rat_ut_cd", getHisRatUtCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("his_chg_cd", getHisChgCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("bkg_curr_cd", getBkgCurrCd());
		this.hashColumns.put("bkg_chg_ut_amt", getBkgChgUtAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("his_chg_ut_amt", getHisChgUtAmt());
		this.hashColumns.put("bkg_rat_as_qty", getBkgRatAsQty());
		this.hashColumns.put("bkg_chg_cd", getBkgChgCd());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("auto_rat_cd", getAutoRatCd());
		this.hashColumns.put("chg_cd", getChgCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("his_curr_cd", "hisCurrCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("search_date", "searchDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_auto_rat_cd", "bkgAutoRatCd");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rt_cng_his", "rtCngHis");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("bkg_chg_amt", "bkgChgAmt");
		this.hashFields.put("his_rat_as_qty", "hisRatAsQty");
		this.hashFields.put("his_chg_amt", "hisChgAmt");
		this.hashFields.put("his_rat_ut_cd", "hisRatUtCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("his_chg_cd", "hisChgCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("bkg_curr_cd", "bkgCurrCd");
		this.hashFields.put("bkg_chg_ut_amt", "bkgChgUtAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("his_chg_ut_amt", "hisChgUtAmt");
		this.hashFields.put("bkg_rat_as_qty", "bkgRatAsQty");
		this.hashFields.put("bkg_chg_cd", "bkgChgCd");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("auto_rat_cd", "autoRatCd");
		this.hashFields.put("chg_cd", "chgCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hisCurrCd
	 */
	public String getHisCurrCd() {
		return this.hisCurrCd;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return autoRatCd
	 */
	public String getAutoRatCd() {
		return this.autoRatCd;
	}
	
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return bkgAutoRatCd
	 */
	public String getBkgAutoRatCd() {
		return this.bkgAutoRatCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return rtCngHis
	 */
	public String getRtCngHis() {
		return this.rtCngHis;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return bkgChgAmt
	 */
	public String getBkgChgAmt() {
		return this.bkgChgAmt;
	}
	
	/**
	 * Column Info
	 * @return hisRatAsQty
	 */
	public String getHisRatAsQty() {
		return this.hisRatAsQty;
	}
	
	/**
	 * Column Info
	 * @return hisChgAmt
	 */
	public String getHisChgAmt() {
		return this.hisChgAmt;
	}
	
	/**
	 * Column Info
	 * @return hisRatUtCd
	 */
	public String getHisRatUtCd() {
		return this.hisRatUtCd;
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
	 * @return hisChgCd
	 */
	public String getHisChgCd() {
		return this.hisChgCd;
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
	 * @return bkgCurrCd
	 */
	public String getBkgCurrCd() {
		return this.bkgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return bkgChgUtAmt
	 */
	public String getBkgChgUtAmt() {
		return this.bkgChgUtAmt;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return hisChgUtAmt
	 */
	public String getHisChgUtAmt() {
		return this.hisChgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgRatAsQty
	 */
	public String getBkgRatAsQty() {
		return this.bkgRatAsQty;
	}
	
	/**
	 * Column Info
	 * @return bkgChgCd
	 */
	public String getBkgChgCd() {
		return this.bkgChgCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRatUtCd
	 */
	public String getBkgRatUtCd() {
		return this.bkgRatUtCd;
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
	 * @param hisCurrCd
	 */
	public void setHisCurrCd(String hisCurrCd) {
		this.hisCurrCd = hisCurrCd;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param bkgAutoRatCd
	 */
	public void setBkgAutoRatCd(String bkgAutoRatCd) {
		this.bkgAutoRatCd = bkgAutoRatCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param autoRatCd
	 */
	public void setAutoRatCd(String autoRatCd) {
		this.autoRatCd = autoRatCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	/**
	 * Column Info
	 * @param rtCngHis
	 */
	public void setRtCngHis(String rtCngHis) {
		this.rtCngHis = rtCngHis;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param bkgChgAmt
	 */
	public void setBkgChgAmt(String bkgChgAmt) {
		this.bkgChgAmt = bkgChgAmt;
	}
	
	/**
	 * Column Info
	 * @param hisRatAsQty
	 */
	public void setHisRatAsQty(String hisRatAsQty) {
		this.hisRatAsQty = hisRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param hisChgAmt
	 */
	public void setHisChgAmt(String hisChgAmt) {
		this.hisChgAmt = hisChgAmt;
	}
	
	/**
	 * Column Info
	 * @param hisRatUtCd
	 */
	public void setHisRatUtCd(String hisRatUtCd) {
		this.hisRatUtCd = hisRatUtCd;
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
	 * @param hisChgCd
	 */
	public void setHisChgCd(String hisChgCd) {
		this.hisChgCd = hisChgCd;
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
	 * @param bkgCurrCd
	 */
	public void setBkgCurrCd(String bkgCurrCd) {
		this.bkgCurrCd = bkgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param bkgChgUtAmt
	 */
	public void setBkgChgUtAmt(String bkgChgUtAmt) {
		this.bkgChgUtAmt = bkgChgUtAmt;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param hisChgUtAmt
	 */
	public void setHisChgUtAmt(String hisChgUtAmt) {
		this.hisChgUtAmt = hisChgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgRatAsQty
	 */
	public void setBkgRatAsQty(String bkgRatAsQty) {
		this.bkgRatAsQty = bkgRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param bkgChgCd
	 */
	public void setBkgChgCd(String bkgChgCd) {
		this.bkgChgCd = bkgChgCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRatUtCd
	 */
	public void setBkgRatUtCd(String bkgRatUtCd) {
		this.bkgRatUtCd = bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setHisCurrCd(JSPUtil.getParameter(request, prefix + "his_curr_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setSearchDate(JSPUtil.getParameter(request, prefix + "search_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgAutoRatCd(JSPUtil.getParameter(request, prefix + "bkg_auto_rat_cd", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRtCngHis(JSPUtil.getParameter(request, prefix + "rt_cng_his", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setBkgChgAmt(JSPUtil.getParameter(request, prefix + "bkg_chg_amt", ""));
		setHisRatAsQty(JSPUtil.getParameter(request, prefix + "his_rat_as_qty", ""));
		setHisChgAmt(JSPUtil.getParameter(request, prefix + "his_chg_amt", ""));
		setHisRatUtCd(JSPUtil.getParameter(request, prefix + "his_rat_ut_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setHisChgCd(JSPUtil.getParameter(request, prefix + "his_chg_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setBkgCurrCd(JSPUtil.getParameter(request, prefix + "bkg_curr_cd", ""));
		setBkgChgUtAmt(JSPUtil.getParameter(request, prefix + "bkg_chg_ut_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHisChgUtAmt(JSPUtil.getParameter(request, prefix + "his_chg_ut_amt", ""));
		setBkgRatAsQty(JSPUtil.getParameter(request, prefix + "bkg_rat_as_qty", ""));
		setBkgChgCd(JSPUtil.getParameter(request, prefix + "bkg_chg_cd", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request, prefix + "bkg_rat_ut_cd", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setAutoRatCd(JSPUtil.getParameter(request, prefix + "auto_rat_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NonAutoratedChargeVO[]
	 */
	public NonAutoratedChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NonAutoratedChargeVO[]
	 */
	public NonAutoratedChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NonAutoratedChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hisCurrCd = (JSPUtil.getParameter(request, prefix	+ "his_curr_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] searchDate = (JSPUtil.getParameter(request, prefix	+ "search_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgAutoRatCd = (JSPUtil.getParameter(request, prefix	+ "bkg_auto_rat_cd", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rtCngHis = (JSPUtil.getParameter(request, prefix	+ "rt_cng_his", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] bkgChgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_chg_amt", length));
			String[] hisRatAsQty = (JSPUtil.getParameter(request, prefix	+ "his_rat_as_qty", length));
			String[] hisChgAmt = (JSPUtil.getParameter(request, prefix	+ "his_chg_amt", length));
			String[] hisRatUtCd = (JSPUtil.getParameter(request, prefix	+ "his_rat_ut_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] hisChgCd = (JSPUtil.getParameter(request, prefix	+ "his_chg_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] bkgCurrCd = (JSPUtil.getParameter(request, prefix	+ "bkg_curr_cd", length));
			String[] bkgChgUtAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_chg_ut_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hisChgUtAmt = (JSPUtil.getParameter(request, prefix	+ "his_chg_ut_amt", length));
			String[] bkgRatAsQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_as_qty", length));
			String[] bkgChgCd = (JSPUtil.getParameter(request, prefix	+ "bkg_chg_cd", length));
			String[] bkgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] autoRatCd = (JSPUtil.getParameter(request, prefix	+ "auto_rat_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NonAutoratedChargeVO();
				if (hisCurrCd[i] != null)
					model.setHisCurrCd(hisCurrCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (searchDate[i] != null)
					model.setSearchDate(searchDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgAutoRatCd[i] != null)
					model.setBkgAutoRatCd(bkgAutoRatCd[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rtCngHis[i] != null)
					model.setRtCngHis(rtCngHis[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (bkgChgAmt[i] != null)
					model.setBkgChgAmt(bkgChgAmt[i]);
				if (hisRatAsQty[i] != null)
					model.setHisRatAsQty(hisRatAsQty[i]);
				if (hisChgAmt[i] != null)
					model.setHisChgAmt(hisChgAmt[i]);
				if (hisRatUtCd[i] != null)
					model.setHisRatUtCd(hisRatUtCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (hisChgCd[i] != null)
					model.setHisChgCd(hisChgCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (bkgCurrCd[i] != null)
					model.setBkgCurrCd(bkgCurrCd[i]);
				if (bkgChgUtAmt[i] != null)
					model.setBkgChgUtAmt(bkgChgUtAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (hisChgUtAmt[i] != null)
					model.setHisChgUtAmt(hisChgUtAmt[i]);
				if (bkgRatAsQty[i] != null)
					model.setBkgRatAsQty(bkgRatAsQty[i]);
				if (bkgChgCd[i] != null)
					model.setBkgChgCd(bkgChgCd[i]);
				if (bkgRatUtCd[i] != null)
					model.setBkgRatUtCd(bkgRatUtCd[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (autoRatCd[i] != null)
					model.setAutoRatCd(autoRatCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNonAutoratedChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NonAutoratedChargeVO[]
	 */
	public NonAutoratedChargeVO[] getNonAutoratedChargeVOs(){
		NonAutoratedChargeVO[] vos = (NonAutoratedChargeVO[])models.toArray(new NonAutoratedChargeVO[models.size()]);
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
		this.hisCurrCd = this.hisCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDate = this.searchDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAutoRatCd = this.bkgAutoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCngHis = this.rtCngHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgChgAmt = this.bkgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisRatAsQty = this.hisRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisChgAmt = this.hisChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisRatUtCd = this.hisRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisChgCd = this.hisChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCurrCd = this.bkgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgChgUtAmt = this.bkgChgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisChgUtAmt = this.hisChgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatAsQty = this.bkgRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgChgCd = this.bkgChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd = this.bkgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatCd = this.autoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
