/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WscBkgListForAuditSchVO.java
*@FileTitle : WscBkgListForAuditSchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15  
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

public class WscBkgListForAuditSchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WscBkgListForAuditSchVO> models = new ArrayList<WscBkgListForAuditSchVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String sub = null;
	/* Column Info */
	private String tpbBkgNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String cfmCurrCd = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String trsBkgNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String woRmk = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String main = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trspCostDtlMod = null;
	/* Column Info */
	private String searchOption = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String toDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WscBkgListForAuditSchVO() {}

	public WscBkgListForAuditSchVO(String ibflag, String pagerows, String bkgNo, String rcvTermCd, String deTermCd, String svcScpCd, String porCd, String polCd, String podCd, String delCd, String ctrtNo, String ratUtCd, String currCd, String chgAmt, String trsBkgNo, String eqTpszCd, String eqNo, String trspCostDtlMod, String trspCrrModCd, String fmNodCd, String toNodCd, String woRmk, String loclCreDt, String woNo, String tpbBkgNo, String main, String sub, String n3ptyNo, String cfmCurrCd, String invAmt, String bkgCnt, String searchOption, String fromDt, String toDt) {
		this.porCd = porCd;
		this.toNodCd = toNodCd;
		this.sub = sub;
		this.tpbBkgNo = tpbBkgNo;
		this.currCd = currCd;
		this.svcScpCd = svcScpCd;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.cfmCurrCd = cfmCurrCd;
		this.n3ptyNo = n3ptyNo;
		this.trsBkgNo = trsBkgNo;
		this.chgAmt = chgAmt;
		this.invAmt = invAmt;
		this.woNo = woNo;
		this.rcvTermCd = rcvTermCd;
		this.trspCrrModCd = trspCrrModCd;
		this.woRmk = woRmk;
		this.delCd = delCd;
		this.loclCreDt = loclCreDt;
		this.bkgCnt = bkgCnt;
		this.ratUtCd = ratUtCd;
		this.main = main;
		this.eqTpszCd = eqTpszCd;
		this.podCd = podCd;
		this.fmNodCd = fmNodCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.trspCostDtlMod = trspCostDtlMod;
		this.searchOption = searchOption;
		this.fromDt = fromDt;
		this.toDt = toDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("sub", getSub());
		this.hashColumns.put("tpb_bkg_no", getTpbBkgNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cfm_curr_cd", getCfmCurrCd());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("trs_bkg_no", getTrsBkgNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("wo_rmk", getWoRmk());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("main", getMain());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("search_option", getSearchOption());
		this.hashColumns.put("trsp_cost_dtl_mod", getTrspCostDtlMod());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("to_dt", getToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("sub", "sub");
		this.hashFields.put("tpb_bkg_no", "tpbBkgNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cfm_curr_cd", "cfmCurrCd");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("trs_bkg_no", "trsBkgNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("wo_rmk", "woRmk");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("main", "main");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trsp_cost_dtl_mod", "trspCostDtlMod");
		this.hashFields.put("search_option", "searchOption");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_dt", "toDt");
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
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return sub
	 */
	public String getSub() {
		return this.sub;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
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
	 * @return tpbBkgNo
	 */
	public String getTpbBkgNo() {
		return this.tpbBkgNo;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return searchOption
	 */
	public String getSearchOption() {
		return this.searchOption;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return cfmCurrCd
	 */
	public String getCfmCurrCd() {
		return this.cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return trsBkgNo
	 */
	public String getTrsBkgNo() {
		return this.trsBkgNo;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return woRmk
	 */
	public String getWoRmk() {
		return this.woRmk;
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
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
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
	 * @return main
	 */
	public String getMain() {
		return this.main;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return trspCostDtlMod
	 */
	public String getTrspCostDtlMod() {
		return this.trspCostDtlMod;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param sub
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	/**
	 * Column Info
	 * @param tpbBkgNo
	 */
	public void setTpbBkgNo(String tpbBkgNo) {
		this.tpbBkgNo = tpbBkgNo;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param cfmCurrCd
	 */
	public void setCfmCurrCd(String cfmCurrCd) {
		this.cfmCurrCd = cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param trsBkgNo
	 */
	public void setTrsBkgNo(String trsBkgNo) {
		this.trsBkgNo = trsBkgNo;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param woRmk
	 */
	public void setWoRmk(String woRmk) {
		this.woRmk = woRmk;
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
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	/**
	 * Column Info
	 * @param searchOption
	 */
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
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
	 * @param main
	 */
	public void setMain(String main) {
		this.main = main;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param trspCostDtlMod
	 */
	public void setTrspCostDtlMod(String trspCostDtlMod) {
		this.trspCostDtlMod = trspCostDtlMod;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setSub(JSPUtil.getParameter(request, prefix + "sub", ""));
		setTpbBkgNo(JSPUtil.getParameter(request, prefix + "tpb_bkg_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCfmCurrCd(JSPUtil.getParameter(request, prefix + "cfm_curr_cd", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setTrsBkgNo(JSPUtil.getParameter(request, prefix + "trs_bkg_no", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setWoRmk(JSPUtil.getParameter(request, prefix + "wo_rmk", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setMain(JSPUtil.getParameter(request, prefix + "main", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTrspCostDtlMod(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod", ""));
		setSearchOption(JSPUtil.getParameter(request, prefix + "search_option", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WscBkgListForAuditSchVO[]
	 */
	public WscBkgListForAuditSchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WscBkgListForAuditSchVO[]
	 */
	public WscBkgListForAuditSchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WscBkgListForAuditSchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] sub = (JSPUtil.getParameter(request, prefix	+ "sub", length));
			String[] tpbBkgNo = (JSPUtil.getParameter(request, prefix	+ "tpb_bkg_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] cfmCurrCd = (JSPUtil.getParameter(request, prefix	+ "cfm_curr_cd", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] trsBkgNo = (JSPUtil.getParameter(request, prefix	+ "trs_bkg_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] woRmk = (JSPUtil.getParameter(request, prefix	+ "wo_rmk", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] main = (JSPUtil.getParameter(request, prefix	+ "main", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trspCostDtlMod = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod", length));
			String[] searchOption = (JSPUtil.getParameter(request, prefix	+ "search_option", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new WscBkgListForAuditSchVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (sub[i] != null)
					model.setSub(sub[i]);
				if (tpbBkgNo[i] != null)
					model.setTpbBkgNo(tpbBkgNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (cfmCurrCd[i] != null)
					model.setCfmCurrCd(cfmCurrCd[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (trsBkgNo[i] != null)
					model.setTrsBkgNo(trsBkgNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (woRmk[i] != null)
					model.setWoRmk(woRmk[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (main[i] != null)
					model.setMain(main[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trspCostDtlMod[i] != null)
					model.setTrspCostDtlMod(trspCostDtlMod[i]);
				if (searchOption[i] != null)
					model.setSearchOption(searchOption[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWscBkgListForAuditSchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WscBkgListForAuditSchVO[]
	 */
	public WscBkgListForAuditSchVO[] getWscBkgListForAuditSchVOs(){
		WscBkgListForAuditSchVO[] vos = (WscBkgListForAuditSchVO[])models.toArray(new WscBkgListForAuditSchVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sub = this.sub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbBkgNo = this.tpbBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCurrCd = this.cfmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsBkgNo = this.trsBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRmk = this.woRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.main = this.main .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlMod = this.trspCostDtlMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchOption = this.searchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
