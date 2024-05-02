/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustCondVO.java
*@FileTitle : AdjustCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
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

public class AdjustCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjustCondVO> models = new ArrayList<AdjustCondVO>();
	
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String searchTp = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String adjTp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String adjtCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String ofcEntrLvlCd = null;
	/* Column Info */
	private String adjtTpCd = null;
	/* Column Info */
	private String adjtOfcCd = null;
	/* Column Info */
	private String adjtUnapyFlg = null;
	/* Column Info */
	private String dtlAdjTpCd = null;
	/* Column Info */
	private String gainAndLssAmt = null;
	/* Column Info */
	private String adjNo = null;
	/* Column Info */
	private String adjTpCd = null;
	/* Column Info */
	private String apCrsCurrAmt = null;
	/* Column Info */
	private String rvsFlg = null;
	/* Column Info */
	private String apCurrCd = null;
	/* Column Info */
	private String adjRmk = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String acctCtnt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String otsCd = null;
	/* Column Info */
	private String adjTjTpKeyCd = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String apRmk = null;
	/* Column Info */
	private String repOtsOfcCd = null;
	/* Column Info */
	private String adjTjTpCd = null;
	/* Column Info */
	private String adjDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdjustCondVO() {}

	public AdjustCondVO(String ibflag, String pagerows, String adjDt, String adjTpCd, String adjTp, String otsOfcCd, String adjNo, String blNo, String invNo, String dtlAdjTpCd, String rvsFlg, String adjRmk, String apOfcCd, String asaNo, String vndrNo, String apCurrCd, String apCrsCurrAmt, String gainAndLssAmt, String apRmk, String searchTp, String adjtOfcCd, String rhqCd, String otsSmryCd, String otsCd, String repOtsOfcCd, String adjtTpCd, String adjtUnapyFlg, String ofcEntrLvlCd, String adjtCurrCd, String dpPrcsKnt, String acctCtnt, String adjTjTpCd, String glDt, String adjTjTpKeyCd) {
		this.glDt = glDt;
		this.searchTp = searchTp;
		this.otsSmryCd = otsSmryCd;
		this.adjTp = adjTp;
		this.blNo = blNo;
		this.adjtCurrCd = adjtCurrCd;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.ofcEntrLvlCd = ofcEntrLvlCd;
		this.adjtTpCd = adjtTpCd;
		this.adjtOfcCd = adjtOfcCd;
		this.adjtUnapyFlg = adjtUnapyFlg;
		this.dtlAdjTpCd = dtlAdjTpCd;
		this.gainAndLssAmt = gainAndLssAmt;
		this.adjNo = adjNo;
		this.adjTpCd = adjTpCd;
		this.apCrsCurrAmt = apCrsCurrAmt;
		this.rvsFlg = rvsFlg;
		this.apCurrCd = apCurrCd;
		this.adjRmk = adjRmk;
		this.apOfcCd = apOfcCd;
		this.rhqCd = rhqCd;
		this.acctCtnt = acctCtnt;
		this.invNo = invNo;
		this.otsOfcCd = otsOfcCd;
		this.otsCd = otsCd;
		this.adjTjTpKeyCd = adjTjTpKeyCd;
		this.asaNo = asaNo;
		this.apRmk = apRmk;
		this.repOtsOfcCd = repOtsOfcCd;
		this.adjTjTpCd = adjTjTpCd;
		this.adjDt = adjDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("search_tp", getSearchTp());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("adj_tp", getAdjTp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("adjt_curr_cd", getAdjtCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ofc_entr_lvl_cd", getOfcEntrLvlCd());
		this.hashColumns.put("adjt_tp_cd", getAdjtTpCd());
		this.hashColumns.put("adjt_ofc_cd", getAdjtOfcCd());
		this.hashColumns.put("adjt_unapy_flg", getAdjtUnapyFlg());
		this.hashColumns.put("dtl_adj_tp_cd", getDtlAdjTpCd());
		this.hashColumns.put("gain_and_lss_amt", getGainAndLssAmt());
		this.hashColumns.put("adj_no", getAdjNo());
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());
		this.hashColumns.put("ap_crs_curr_amt", getApCrsCurrAmt());
		this.hashColumns.put("rvs_flg", getRvsFlg());
		this.hashColumns.put("ap_curr_cd", getApCurrCd());
		this.hashColumns.put("adj_rmk", getAdjRmk());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("acct_ctnt", getAcctCtnt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("ots_cd", getOtsCd());
		this.hashColumns.put("adj_tj_tp_key_cd", getAdjTjTpKeyCd());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("ap_rmk", getApRmk());
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());
		this.hashColumns.put("adj_tj_tp_cd", getAdjTjTpCd());
		this.hashColumns.put("adj_dt", getAdjDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("search_tp", "searchTp");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("adj_tp", "adjTp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("adjt_curr_cd", "adjtCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ofc_entr_lvl_cd", "ofcEntrLvlCd");
		this.hashFields.put("adjt_tp_cd", "adjtTpCd");
		this.hashFields.put("adjt_ofc_cd", "adjtOfcCd");
		this.hashFields.put("adjt_unapy_flg", "adjtUnapyFlg");
		this.hashFields.put("dtl_adj_tp_cd", "dtlAdjTpCd");
		this.hashFields.put("gain_and_lss_amt", "gainAndLssAmt");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("ap_crs_curr_amt", "apCrsCurrAmt");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("ap_curr_cd", "apCurrCd");
		this.hashFields.put("adj_rmk", "adjRmk");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("acct_ctnt", "acctCtnt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("adj_tj_tp_key_cd", "adjTjTpKeyCd");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("ap_rmk", "apRmk");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("adj_tj_tp_cd", "adjTjTpCd");
		this.hashFields.put("adj_dt", "adjDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return searchTp
	 */
	public String getSearchTp() {
		return this.searchTp;
	}
	
	/**
	 * Column Info
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @return adjTp
	 */
	public String getAdjTp() {
		return this.adjTp;
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
	 * @return adjtCurrCd
	 */
	public String getAdjtCurrCd() {
		return this.adjtCurrCd;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return ofcEntrLvlCd
	 */
	public String getOfcEntrLvlCd() {
		return this.ofcEntrLvlCd;
	}
	
	/**
	 * Column Info
	 * @return adjtTpCd
	 */
	public String getAdjtTpCd() {
		return this.adjtTpCd;
	}
	
	/**
	 * Column Info
	 * @return adjtOfcCd
	 */
	public String getAdjtOfcCd() {
		return this.adjtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adjtUnapyFlg
	 */
	public String getAdjtUnapyFlg() {
		return this.adjtUnapyFlg;
	}
	
	/**
	 * Column Info
	 * @return dtlAdjTpCd
	 */
	public String getDtlAdjTpCd() {
		return this.dtlAdjTpCd;
	}
	
	/**
	 * Column Info
	 * @return gainAndLssAmt
	 */
	public String getGainAndLssAmt() {
		return this.gainAndLssAmt;
	}
	
	/**
	 * Column Info
	 * @return adjNo
	 */
	public String getAdjNo() {
		return this.adjNo;
	}
	
	/**
	 * Column Info
	 * @return adjTpCd
	 */
	public String getAdjTpCd() {
		return this.adjTpCd;
	}
	
	/**
	 * Column Info
	 * @return apCrsCurrAmt
	 */
	public String getApCrsCurrAmt() {
		return this.apCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return rvsFlg
	 */
	public String getRvsFlg() {
		return this.rvsFlg;
	}
	
	/**
	 * Column Info
	 * @return apCurrCd
	 */
	public String getApCurrCd() {
		return this.apCurrCd;
	}
	
	/**
	 * Column Info
	 * @return adjRmk
	 */
	public String getAdjRmk() {
		return this.adjRmk;
	}
	
	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
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
	 * @return acctCtnt
	 */
	public String getAcctCtnt() {
		return this.acctCtnt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otsCd
	 */
	public String getOtsCd() {
		return this.otsCd;
	}
	
	/**
	 * Column Info
	 * @return adjTjTpKeyCd
	 */
	public String getAdjTjTpKeyCd() {
		return this.adjTjTpKeyCd;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return apRmk
	 */
	public String getApRmk() {
		return this.apRmk;
	}
	
	/**
	 * Column Info
	 * @return repOtsOfcCd
	 */
	public String getRepOtsOfcCd() {
		return this.repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adjTjTpCd
	 */
	public String getAdjTjTpCd() {
		return this.adjTjTpCd;
	}
	
	/**
	 * Column Info
	 * @return adjDt
	 */
	public String getAdjDt() {
		return this.adjDt;
	}
	

	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param searchTp
	 */
	public void setSearchTp(String searchTp) {
		this.searchTp = searchTp;
	}
	
	/**
	 * Column Info
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @param adjTp
	 */
	public void setAdjTp(String adjTp) {
		this.adjTp = adjTp;
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
	 * @param adjtCurrCd
	 */
	public void setAdjtCurrCd(String adjtCurrCd) {
		this.adjtCurrCd = adjtCurrCd;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param ofcEntrLvlCd
	 */
	public void setOfcEntrLvlCd(String ofcEntrLvlCd) {
		this.ofcEntrLvlCd = ofcEntrLvlCd;
	}
	
	/**
	 * Column Info
	 * @param adjtTpCd
	 */
	public void setAdjtTpCd(String adjtTpCd) {
		this.adjtTpCd = adjtTpCd;
	}
	
	/**
	 * Column Info
	 * @param adjtOfcCd
	 */
	public void setAdjtOfcCd(String adjtOfcCd) {
		this.adjtOfcCd = adjtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adjtUnapyFlg
	 */
	public void setAdjtUnapyFlg(String adjtUnapyFlg) {
		this.adjtUnapyFlg = adjtUnapyFlg;
	}
	
	/**
	 * Column Info
	 * @param dtlAdjTpCd
	 */
	public void setDtlAdjTpCd(String dtlAdjTpCd) {
		this.dtlAdjTpCd = dtlAdjTpCd;
	}
	
	/**
	 * Column Info
	 * @param gainAndLssAmt
	 */
	public void setGainAndLssAmt(String gainAndLssAmt) {
		this.gainAndLssAmt = gainAndLssAmt;
	}
	
	/**
	 * Column Info
	 * @param adjNo
	 */
	public void setAdjNo(String adjNo) {
		this.adjNo = adjNo;
	}
	
	/**
	 * Column Info
	 * @param adjTpCd
	 */
	public void setAdjTpCd(String adjTpCd) {
		this.adjTpCd = adjTpCd;
	}
	
	/**
	 * Column Info
	 * @param apCrsCurrAmt
	 */
	public void setApCrsCurrAmt(String apCrsCurrAmt) {
		this.apCrsCurrAmt = apCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param rvsFlg
	 */
	public void setRvsFlg(String rvsFlg) {
		this.rvsFlg = rvsFlg;
	}
	
	/**
	 * Column Info
	 * @param apCurrCd
	 */
	public void setApCurrCd(String apCurrCd) {
		this.apCurrCd = apCurrCd;
	}
	
	/**
	 * Column Info
	 * @param adjRmk
	 */
	public void setAdjRmk(String adjRmk) {
		this.adjRmk = adjRmk;
	}
	
	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
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
	 * @param acctCtnt
	 */
	public void setAcctCtnt(String acctCtnt) {
		this.acctCtnt = acctCtnt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otsCd
	 */
	public void setOtsCd(String otsCd) {
		this.otsCd = otsCd;
	}
	
	/**
	 * Column Info
	 * @param adjTjTpKeyCd
	 */
	public void setAdjTjTpKeyCd(String adjTjTpKeyCd) {
		this.adjTjTpKeyCd = adjTjTpKeyCd;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param apRmk
	 */
	public void setApRmk(String apRmk) {
		this.apRmk = apRmk;
	}
	
	/**
	 * Column Info
	 * @param repOtsOfcCd
	 */
	public void setRepOtsOfcCd(String repOtsOfcCd) {
		this.repOtsOfcCd = repOtsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adjTjTpCd
	 */
	public void setAdjTjTpCd(String adjTjTpCd) {
		this.adjTjTpCd = adjTjTpCd;
	}
	
	/**
	 * Column Info
	 * @param adjDt
	 */
	public void setAdjDt(String adjDt) {
		this.adjDt = adjDt;
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
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setSearchTp(JSPUtil.getParameter(request, prefix + "search_tp", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, prefix + "ots_smry_cd", ""));
		setAdjTp(JSPUtil.getParameter(request, prefix + "adj_tp", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setAdjtCurrCd(JSPUtil.getParameter(request, prefix + "adjt_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setOfcEntrLvlCd(JSPUtil.getParameter(request, prefix + "ofc_entr_lvl_cd", ""));
		setAdjtTpCd(JSPUtil.getParameter(request, prefix + "adjt_tp_cd", ""));
		setAdjtOfcCd(JSPUtil.getParameter(request, prefix + "adjt_ofc_cd", ""));
		setAdjtUnapyFlg(JSPUtil.getParameter(request, prefix + "adjt_unapy_flg", ""));
		setDtlAdjTpCd(JSPUtil.getParameter(request, prefix + "dtl_adj_tp_cd", ""));
		setGainAndLssAmt(JSPUtil.getParameter(request, prefix + "gain_and_lss_amt", ""));
		setAdjNo(JSPUtil.getParameter(request, prefix + "adj_no", ""));
		setAdjTpCd(JSPUtil.getParameter(request, prefix + "adj_tp_cd", ""));
		setApCrsCurrAmt(JSPUtil.getParameter(request, prefix + "ap_crs_curr_amt", ""));
		setRvsFlg(JSPUtil.getParameter(request, prefix + "rvs_flg", ""));
		setApCurrCd(JSPUtil.getParameter(request, prefix + "ap_curr_cd", ""));
		setAdjRmk(JSPUtil.getParameter(request, prefix + "adj_rmk", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setAcctCtnt(JSPUtil.getParameter(request, prefix + "acct_ctnt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setOtsCd(JSPUtil.getParameter(request, prefix + "ots_cd", ""));
		setAdjTjTpKeyCd(JSPUtil.getParameter(request, prefix + "adj_tj_tp_key_cd", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setApRmk(JSPUtil.getParameter(request, prefix + "ap_rmk", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request, prefix + "rep_ots_ofc_cd", ""));
		setAdjTjTpCd(JSPUtil.getParameter(request, prefix + "adj_tj_tp_cd", ""));
		setAdjDt(JSPUtil.getParameter(request, prefix + "adj_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustCondVO[]
	 */
	public AdjustCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustCondVO[]
	 */
	public AdjustCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjustCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] searchTp = (JSPUtil.getParameter(request, prefix	+ "search_tp", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] adjTp = (JSPUtil.getParameter(request, prefix	+ "adj_tp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] adjtCurrCd = (JSPUtil.getParameter(request, prefix	+ "adjt_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ofcEntrLvlCd = (JSPUtil.getParameter(request, prefix	+ "ofc_entr_lvl_cd", length));
			String[] adjtTpCd = (JSPUtil.getParameter(request, prefix	+ "adjt_tp_cd", length));
			String[] adjtOfcCd = (JSPUtil.getParameter(request, prefix	+ "adjt_ofc_cd", length));
			String[] adjtUnapyFlg = (JSPUtil.getParameter(request, prefix	+ "adjt_unapy_flg", length));
			String[] dtlAdjTpCd = (JSPUtil.getParameter(request, prefix	+ "dtl_adj_tp_cd", length));
			String[] gainAndLssAmt = (JSPUtil.getParameter(request, prefix	+ "gain_and_lss_amt", length));
			String[] adjNo = (JSPUtil.getParameter(request, prefix	+ "adj_no", length));
			String[] adjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tp_cd", length));
			String[] apCrsCurrAmt = (JSPUtil.getParameter(request, prefix	+ "ap_crs_curr_amt", length));
			String[] rvsFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_flg", length));
			String[] apCurrCd = (JSPUtil.getParameter(request, prefix	+ "ap_curr_cd", length));
			String[] adjRmk = (JSPUtil.getParameter(request, prefix	+ "adj_rmk", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] acctCtnt = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] otsCd = (JSPUtil.getParameter(request, prefix	+ "ots_cd", length));
			String[] adjTjTpKeyCd = (JSPUtil.getParameter(request, prefix	+ "adj_tj_tp_key_cd", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] apRmk = (JSPUtil.getParameter(request, prefix	+ "ap_rmk", length));
			String[] repOtsOfcCd = (JSPUtil.getParameter(request, prefix	+ "rep_ots_ofc_cd", length));
			String[] adjTjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tj_tp_cd", length));
			String[] adjDt = (JSPUtil.getParameter(request, prefix	+ "adj_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjustCondVO();
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (searchTp[i] != null)
					model.setSearchTp(searchTp[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (adjTp[i] != null)
					model.setAdjTp(adjTp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (adjtCurrCd[i] != null)
					model.setAdjtCurrCd(adjtCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ofcEntrLvlCd[i] != null)
					model.setOfcEntrLvlCd(ofcEntrLvlCd[i]);
				if (adjtTpCd[i] != null)
					model.setAdjtTpCd(adjtTpCd[i]);
				if (adjtOfcCd[i] != null)
					model.setAdjtOfcCd(adjtOfcCd[i]);
				if (adjtUnapyFlg[i] != null)
					model.setAdjtUnapyFlg(adjtUnapyFlg[i]);
				if (dtlAdjTpCd[i] != null)
					model.setDtlAdjTpCd(dtlAdjTpCd[i]);
				if (gainAndLssAmt[i] != null)
					model.setGainAndLssAmt(gainAndLssAmt[i]);
				if (adjNo[i] != null)
					model.setAdjNo(adjNo[i]);
				if (adjTpCd[i] != null)
					model.setAdjTpCd(adjTpCd[i]);
				if (apCrsCurrAmt[i] != null)
					model.setApCrsCurrAmt(apCrsCurrAmt[i]);
				if (rvsFlg[i] != null)
					model.setRvsFlg(rvsFlg[i]);
				if (apCurrCd[i] != null)
					model.setApCurrCd(apCurrCd[i]);
				if (adjRmk[i] != null)
					model.setAdjRmk(adjRmk[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (acctCtnt[i] != null)
					model.setAcctCtnt(acctCtnt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (otsCd[i] != null)
					model.setOtsCd(otsCd[i]);
				if (adjTjTpKeyCd[i] != null)
					model.setAdjTjTpKeyCd(adjTjTpKeyCd[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (apRmk[i] != null)
					model.setApRmk(apRmk[i]);
				if (repOtsOfcCd[i] != null)
					model.setRepOtsOfcCd(repOtsOfcCd[i]);
				if (adjTjTpCd[i] != null)
					model.setAdjTjTpCd(adjTjTpCd[i]);
				if (adjDt[i] != null)
					model.setAdjDt(adjDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjustCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustCondVO[]
	 */
	public AdjustCondVO[] getAdjustCondVOs(){
		AdjustCondVO[] vos = (AdjustCondVO[])models.toArray(new AdjustCondVO[models.size()]);
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
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchTp = this.searchTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTp = this.adjTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjtCurrCd = this.adjtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEntrLvlCd = this.ofcEntrLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjtTpCd = this.adjtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjtOfcCd = this.adjtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjtUnapyFlg = this.adjtUnapyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlAdjTpCd = this.dtlAdjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainAndLssAmt = this.gainAndLssAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo = this.adjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd = this.adjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCrsCurrAmt = this.apCrsCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg = this.rvsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCurrCd = this.apCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRmk = this.adjRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt = this.acctCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd = this.otsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTjTpKeyCd = this.adjTjTpKeyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRmk = this.apRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd = this.repOtsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTjTpCd = this.adjTjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjDt = this.adjDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
