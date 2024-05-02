/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepoPfmcConditionVO.java
*@FileTitle : RepoPfmcConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2010.01.18 김기식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo;

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
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepoPfmcConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepoPfmcConditionVO> models = new ArrayList<RepoPfmcConditionVO>();
	
	/* Column Info */
	private String fUsaMode = null;
	/* Column Info */
	private String fExclSts = null;
	/* Column Info */
	private String fSchMode = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fRCmdt = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fSc = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fChtbiz = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String strDisplay = null;
	/* Column Info */
	private String fDel = null;
	/* Column Info */
	private String fSlsOfcCd = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fProVw = null;
	/* Column Info */
	private String fProObj = null;
	/* Column Info */
	private String fOpView = null;
	/* Column Info */
	private String fVvd2 = null;
	/* Column Info */
	private String fVvd3 = null;
	/* Column Info */
	private String fOfcLvl = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fPol = null;
	/* Column Info */
	private String fBkgNo = null;
	/* Column Info */
	private String fVvd1 = null;
	/* Column Info */
	private String fOfcVw = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String fPor = null;
	/* Column Info */
	private String fRfa = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fLoclLang = null;
	/* Column Info */
	private String fProLvl = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fCmdt = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fShipper = null;
	/* Column Info */
	private String fPod = null;
	/* Column Info */
	private String fYear = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepoPfmcConditionVO() {}

	public RepoPfmcConditionVO(String ibflag, String pagerows, String fUsaMode, String fExclSts, String fSchMode, String fChkprd, String fFmMon, String fDirCd, String fRCmdt, String fSc, String fRhqCd, String fCntrTpszCd, String fChtbiz, String strDisplay, String fDel, String fSlsOfcCd, String fVslCd, String fProVw, String fProObj, String fOpView, String fVvd2, String fVvd3, String fOfcLvl, String fCostYrmon, String fFmWk, String fBkgNo, String fPol, String fVvd1, String fSkdDirCd, String fOfcVw, String fToMon, String fSkdVoyNo, String fRfa, String fPor, String fOfcCd, String fTrdCd, String fToWk, String fProLvl, String fLoclLang, String fCmdt, String fRlaneCd, String fShipper, String fPod, String fYear) {
		this.fUsaMode = fUsaMode;
		this.fExclSts = fExclSts;
		this.fSchMode = fSchMode;
		this.fChkprd = fChkprd;
		this.fFmMon = fFmMon;
		this.fRCmdt = fRCmdt;
		this.fDirCd = fDirCd;
		this.fSc = fSc;
		this.fRhqCd = fRhqCd;
		this.fCntrTpszCd = fCntrTpszCd;
		this.pagerows = pagerows;
		this.fChtbiz = fChtbiz;
		this.ibflag = ibflag;
		this.strDisplay = strDisplay;
		this.fDel = fDel;
		this.fSlsOfcCd = fSlsOfcCd;
		this.fVslCd = fVslCd;
		this.fProVw = fProVw;
		this.fProObj = fProObj;
		this.fOpView = fOpView;
		this.fVvd2 = fVvd2;
		this.fVvd3 = fVvd3;
		this.fOfcLvl = fOfcLvl;
		this.fCostYrmon = fCostYrmon;
		this.fFmWk = fFmWk;
		this.fPol = fPol;
		this.fBkgNo = fBkgNo;
		this.fVvd1 = fVvd1;
		this.fOfcVw = fOfcVw;
		this.fSkdDirCd = fSkdDirCd;
		this.fToMon = fToMon;
		this.fSkdVoyNo = fSkdVoyNo;
		this.fPor = fPor;
		this.fRfa = fRfa;
		this.fOfcCd = fOfcCd;
		this.fTrdCd = fTrdCd;
		this.fLoclLang = fLoclLang;
		this.fProLvl = fProLvl;
		this.fToWk = fToWk;
		this.fCmdt = fCmdt;
		this.fRlaneCd = fRlaneCd;
		this.fShipper = fShipper;
		this.fPod = fPod;
		this.fYear = fYear;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_usa_mode", getFUsaMode());
		this.hashColumns.put("f_excl_sts", getFExclSts());
		this.hashColumns.put("f_sch_mode", getFSchMode());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_r_cmdt", getFRCmdt());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_sc", getFSc());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_chtbiz", getFChtbiz());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("str_display", getStrDisplay());
		this.hashColumns.put("f_del", getFDel());
		this.hashColumns.put("f_sls_ofc_cd", getFSlsOfcCd());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_pro_vw", getFProVw());
		this.hashColumns.put("f_pro_obj", getFProObj());
		this.hashColumns.put("f_op_view", getFOpView());
		this.hashColumns.put("f_vvd2", getFVvd2());
		this.hashColumns.put("f_vvd3", getFVvd3());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_pol", getFPol());
		this.hashColumns.put("f_bkg_no", getFBkgNo());
		this.hashColumns.put("f_vvd1", getFVvd1());
		this.hashColumns.put("f_ofc_vw", getFOfcVw());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("f_por", getFPor());
		this.hashColumns.put("f_rfa", getFRfa());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_locl_lang", getFLoclLang());
		this.hashColumns.put("f_pro_lvl", getFProLvl());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_cmdt", getFCmdt());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_shipper", getFShipper());
		this.hashColumns.put("f_pod", getFPod());
		this.hashColumns.put("f_year", getFYear());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_usa_mode", "fUsaMode");
		this.hashFields.put("f_excl_sts", "fExclSts");
		this.hashFields.put("f_sch_mode", "fSchMode");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_r_cmdt", "fRCmdt");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_sc", "fSc");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_chtbiz", "fChtbiz");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("str_display", "strDisplay");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("f_sls_ofc_cd", "fSlsOfcCd");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_pro_vw", "fProVw");
		this.hashFields.put("f_pro_obj", "fProObj");
		this.hashFields.put("f_op_view", "fOpView");
		this.hashFields.put("f_vvd2", "fVvd2");
		this.hashFields.put("f_vvd3", "fVvd3");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_pol", "fPol");
		this.hashFields.put("f_bkg_no", "fBkgNo");
		this.hashFields.put("f_vvd1", "fVvd1");
		this.hashFields.put("f_ofc_vw", "fOfcVw");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("f_por", "fPor");
		this.hashFields.put("f_rfa", "fRfa");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_locl_lang", "fLoclLang");
		this.hashFields.put("f_pro_lvl", "fProLvl");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_cmdt", "fCmdt");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_shipper", "fShipper");
		this.hashFields.put("f_pod", "fPod");
		this.hashFields.put("f_year", "fYear");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fUsaMode
	 */
	public String getFUsaMode() {
		return this.fUsaMode;
	}
	
	/**
	 * Column Info
	 * @return fExclSts
	 */
	public String getFExclSts() {
		return this.fExclSts;
	}
	
	/**
	 * Column Info
	 * @return fSchMode
	 */
	public String getFSchMode() {
		return this.fSchMode;
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
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return fRCmdt
	 */
	public String getFRCmdt() {
		return this.fRCmdt;
	}
	
	/**
	 * Column Info
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
	}
	
	/**
	 * Column Info
	 * @return fSc
	 */
	public String getFSc() {
		return this.fSc;
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
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
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
	 * @return fChtbiz
	 */
	public String getFChtbiz() {
		return this.fChtbiz;
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
	 * @return strDisplay
	 */
	public String getStrDisplay() {
		return this.strDisplay;
	}
	
	/**
	 * Column Info
	 * @return fDel
	 */
	public String getFDel() {
		return this.fDel;
	}
	
	/**
	 * Column Info
	 * @return fSlsOfcCd
	 */
	public String getFSlsOfcCd() {
		return this.fSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fVslCd
	 */
	public String getFVslCd() {
		return this.fVslCd;
	}
	
	/**
	 * Column Info
	 * @return fProVw
	 */
	public String getFProVw() {
		return this.fProVw;
	}
	
	/**
	 * Column Info
	 * @return fProObj
	 */
	public String getFProObj() {
		return this.fProObj;
	}
	
	/**
	 * Column Info
	 * @return fOpView
	 */
	public String getFOpView() {
		return this.fOpView;
	}
	
	/**
	 * Column Info
	 * @return fVvd2
	 */
	public String getFVvd2() {
		return this.fVvd2;
	}
	
	/**
	 * Column Info
	 * @return fVvd3
	 */
	public String getFVvd3() {
		return this.fVvd3;
	}
	
	/**
	 * Column Info
	 * @return fOfcLvl
	 */
	public String getFOfcLvl() {
		return this.fOfcLvl;
	}
	
	/**
	 * Column Info
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
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
	 * @return fPol
	 */
	public String getFPol() {
		return this.fPol;
	}
	
	/**
	 * Column Info
	 * @return fBkgNo
	 */
	public String getFBkgNo() {
		return this.fBkgNo;
	}
	
	/**
	 * Column Info
	 * @return fVvd1
	 */
	public String getFVvd1() {
		return this.fVvd1;
	}
	
	/**
	 * Column Info
	 * @return fOfcVw
	 */
	public String getFOfcVw() {
		return this.fOfcVw;
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
	 * @return fSkdVoyNo
	 */
	public String getFSkdVoyNo() {
		return this.fSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return fPor
	 */
	public String getFPor() {
		return this.fPor;
	}
	
	/**
	 * Column Info
	 * @return fRfa
	 */
	public String getFRfa() {
		return this.fRfa;
	}
	
	/**
	 * Column Info
	 * @return fOfcCd
	 */
	public String getFOfcCd() {
		return this.fOfcCd;
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
	 * @return fLoclLang
	 */
	public String getFLoclLang() {
		return this.fLoclLang;
	}
	
	/**
	 * Column Info
	 * @return fProLvl
	 */
	public String getFProLvl() {
		return this.fProLvl;
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
	 * @return fCmdt
	 */
	public String getFCmdt() {
		return this.fCmdt;
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
	 * @return fShipper
	 */
	public String getFShipper() {
		return this.fShipper;
	}
	
	/**
	 * Column Info
	 * @return fPod
	 */
	public String getFPod() {
		return this.fPod;
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
	 * @param fUsaMode
	 */
	public void setFUsaMode(String fUsaMode) {
		this.fUsaMode = fUsaMode;
	}
	
	/**
	 * Column Info
	 * @param fExclSts
	 */
	public void setFExclSts(String fExclSts) {
		this.fExclSts = fExclSts;
	}
	
	/**
	 * Column Info
	 * @param fSchMode
	 */
	public void setFSchMode(String fSchMode) {
		this.fSchMode = fSchMode;
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
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}
	
	/**
	 * Column Info
	 * @param fRCmdt
	 */
	public void setFRCmdt(String fRCmdt) {
		this.fRCmdt = fRCmdt;
	}
	
	/**
	 * Column Info
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
	}
	
	/**
	 * Column Info
	 * @param fSc
	 */
	public void setFSc(String fSc) {
		this.fSc = fSc;
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
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
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
	 * @param fChtbiz
	 */
	public void setFChtbiz(String fChtbiz) {
		this.fChtbiz = fChtbiz;
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
	 * @param strDisplay
	 */
	public void setStrDisplay(String strDisplay) {
		this.strDisplay = strDisplay;
	}
	
	/**
	 * Column Info
	 * @param fDel
	 */
	public void setFDel(String fDel) {
		this.fDel = fDel;
	}
	
	/**
	 * Column Info
	 * @param fSlsOfcCd
	 */
	public void setFSlsOfcCd(String fSlsOfcCd) {
		this.fSlsOfcCd = fSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fVslCd
	 */
	public void setFVslCd(String fVslCd) {
		this.fVslCd = fVslCd;
	}
	
	/**
	 * Column Info
	 * @param fProVw
	 */
	public void setFProVw(String fProVw) {
		this.fProVw = fProVw;
	}
	
	/**
	 * Column Info
	 * @param fProObj
	 */
	public void setFProObj(String fProObj) {
		this.fProObj = fProObj;
	}
	
	/**
	 * Column Info
	 * @param fOpView
	 */
	public void setFOpView(String fOpView) {
		this.fOpView = fOpView;
	}
	
	/**
	 * Column Info
	 * @param fVvd2
	 */
	public void setFVvd2(String fVvd2) {
		this.fVvd2 = fVvd2;
	}
	
	/**
	 * Column Info
	 * @param fVvd3
	 */
	public void setFVvd3(String fVvd3) {
		this.fVvd3 = fVvd3;
	}
	
	/**
	 * Column Info
	 * @param fOfcLvl
	 */
	public void setFOfcLvl(String fOfcLvl) {
		this.fOfcLvl = fOfcLvl;
	}
	
	/**
	 * Column Info
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
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
	 * @param fPol
	 */
	public void setFPol(String fPol) {
		this.fPol = fPol;
	}
	
	/**
	 * Column Info
	 * @param fBkgNo
	 */
	public void setFBkgNo(String fBkgNo) {
		this.fBkgNo = fBkgNo;
	}
	
	/**
	 * Column Info
	 * @param fVvd1
	 */
	public void setFVvd1(String fVvd1) {
		this.fVvd1 = fVvd1;
	}
	
	/**
	 * Column Info
	 * @param fOfcVw
	 */
	public void setFOfcVw(String fOfcVw) {
		this.fOfcVw = fOfcVw;
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
	 * @param fSkdVoyNo
	 */
	public void setFSkdVoyNo(String fSkdVoyNo) {
		this.fSkdVoyNo = fSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param fPor
	 */
	public void setFPor(String fPor) {
		this.fPor = fPor;
	}
	
	/**
	 * Column Info
	 * @param fRfa
	 */
	public void setFRfa(String fRfa) {
		this.fRfa = fRfa;
	}
	
	/**
	 * Column Info
	 * @param fOfcCd
	 */
	public void setFOfcCd(String fOfcCd) {
		this.fOfcCd = fOfcCd;
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
	 * @param fLoclLang
	 */
	public void setFLoclLang(String fLoclLang) {
		this.fLoclLang = fLoclLang;
	}
	
	/**
	 * Column Info
	 * @param fProLvl
	 */
	public void setFProLvl(String fProLvl) {
		this.fProLvl = fProLvl;
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
	 * @param fCmdt
	 */
	public void setFCmdt(String fCmdt) {
		this.fCmdt = fCmdt;
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
	 * @param fShipper
	 */
	public void setFShipper(String fShipper) {
		this.fShipper = fShipper;
	}
	
	/**
	 * Column Info
	 * @param fPod
	 */
	public void setFPod(String fPod) {
		this.fPod = fPod;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFUsaMode(JSPUtil.getParameter(request, "f_usa_mode", ""));
		setFExclSts(JSPUtil.getParameter(request, "f_excl_sts", ""));
		setFSchMode(JSPUtil.getParameter(request, "f_sch_mode", ""));
		setFChkprd(JSPUtil.getParameter(request, "f_chkprd", ""));
		setFFmMon(JSPUtil.getParameter(request, "f_fm_mon", ""));
		setFRCmdt(JSPUtil.getParameter(request, "f_r_cmdt", ""));
		setFDirCd(JSPUtil.getParameter(request, "f_dir_cd", ""));
		setFSc(JSPUtil.getParameter(request, "f_sc", ""));
		setFRhqCd(JSPUtil.getParameter(request, "f_rhq_cd", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, "f_cntr_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFChtbiz(JSPUtil.getParameter(request, "f_chtbiz", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStrDisplay(JSPUtil.getParameter(request, "str_display", ""));
		setFDel(JSPUtil.getParameter(request, "f_del", ""));
		setFSlsOfcCd(JSPUtil.getParameter(request, "f_sls_ofc_cd", ""));
		setFVslCd(JSPUtil.getParameter(request, "f_vsl_cd", ""));
		setFProVw(JSPUtil.getParameter(request, "f_pro_vw", ""));
		setFProObj(JSPUtil.getParameter(request, "f_pro_obj", ""));
		setFOpView(JSPUtil.getParameter(request, "f_op_view", ""));
		setFVvd2(JSPUtil.getParameter(request, "f_vvd2", ""));
		setFVvd3(JSPUtil.getParameter(request, "f_vvd3", ""));
		setFOfcLvl(JSPUtil.getParameter(request, "f_ofc_lvl", ""));
		setFCostYrmon(JSPUtil.getParameter(request, "f_cost_yrmon", ""));
		setFFmWk(JSPUtil.getParameter(request, "f_fm_wk", ""));
		setFPol(JSPUtil.getParameter(request, "f_pol", ""));
		setFBkgNo(JSPUtil.getParameter(request, "f_bkg_no", ""));
		setFVvd1(JSPUtil.getParameter(request, "f_vvd1", ""));
		setFOfcVw(JSPUtil.getParameter(request, "f_ofc_vw", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, "f_skd_dir_cd", ""));
		setFToMon(JSPUtil.getParameter(request, "f_to_mon", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, "f_skd_voy_no", ""));
		setFPor(JSPUtil.getParameter(request, "f_por", ""));
		setFRfa(JSPUtil.getParameter(request, "f_rfa", ""));
		setFOfcCd(JSPUtil.getParameter(request, "f_ofc_cd", ""));
		setFTrdCd(JSPUtil.getParameter(request, "f_trd_cd", ""));
		setFLoclLang(JSPUtil.getParameter(request, "f_locl_lang", ""));
		setFProLvl(JSPUtil.getParameter(request, "f_pro_lvl", ""));
		setFToWk(JSPUtil.getParameter(request, "f_to_wk", ""));
		setFCmdt(JSPUtil.getParameter(request, "f_cmdt", ""));
		setFRlaneCd(JSPUtil.getParameter(request, "f_rlane_cd", ""));
		setFShipper(JSPUtil.getParameter(request, "f_shipper", ""));
		setFPod(JSPUtil.getParameter(request, "f_pod", ""));
		setFYear(JSPUtil.getParameter(request, "f_year", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepoPfmcConditionVO[]
	 */
	public RepoPfmcConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepoPfmcConditionVO[]
	 */
	public RepoPfmcConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepoPfmcConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fUsaMode = (JSPUtil.getParameter(request, prefix	+ "f_usa_mode", length));
			String[] fExclSts = (JSPUtil.getParameter(request, prefix	+ "f_excl_sts", length));
			String[] fSchMode = (JSPUtil.getParameter(request, prefix	+ "f_sch_mode", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fRCmdt = (JSPUtil.getParameter(request, prefix	+ "f_r_cmdt", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fSc = (JSPUtil.getParameter(request, prefix	+ "f_sc", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fChtbiz = (JSPUtil.getParameter(request, prefix	+ "f_chtbiz", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] strDisplay = (JSPUtil.getParameter(request, prefix	+ "str_display", length));
			String[] fDel = (JSPUtil.getParameter(request, prefix	+ "f_del", length));
			String[] fSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sls_ofc_cd", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fProVw = (JSPUtil.getParameter(request, prefix	+ "f_pro_vw", length));
			String[] fProObj = (JSPUtil.getParameter(request, prefix	+ "f_pro_obj", length));
			String[] fOpView = (JSPUtil.getParameter(request, prefix	+ "f_op_view", length));
			String[] fVvd2 = (JSPUtil.getParameter(request, prefix	+ "f_vvd2", length));
			String[] fVvd3 = (JSPUtil.getParameter(request, prefix	+ "f_vvd3", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fPol = (JSPUtil.getParameter(request, prefix	+ "f_pol", length));
			String[] fBkgNo = (JSPUtil.getParameter(request, prefix	+ "f_bkg_no", length));
			String[] fVvd1 = (JSPUtil.getParameter(request, prefix	+ "f_vvd1", length));
			String[] fOfcVw = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] fPor = (JSPUtil.getParameter(request, prefix	+ "f_por", length));
			String[] fRfa = (JSPUtil.getParameter(request, prefix	+ "f_rfa", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fLoclLang = (JSPUtil.getParameter(request, prefix	+ "f_locl_lang", length));
			String[] fProLvl = (JSPUtil.getParameter(request, prefix	+ "f_pro_lvl", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fCmdt = (JSPUtil.getParameter(request, prefix	+ "f_cmdt", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fShipper = (JSPUtil.getParameter(request, prefix	+ "f_shipper", length));
			String[] fPod = (JSPUtil.getParameter(request, prefix	+ "f_pod", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepoPfmcConditionVO();
				if (fUsaMode[i] != null)
					model.setFUsaMode(fUsaMode[i]);
				if (fExclSts[i] != null)
					model.setFExclSts(fExclSts[i]);
				if (fSchMode[i] != null)
					model.setFSchMode(fSchMode[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fRCmdt[i] != null)
					model.setFRCmdt(fRCmdt[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fSc[i] != null)
					model.setFSc(fSc[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fChtbiz[i] != null)
					model.setFChtbiz(fChtbiz[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (strDisplay[i] != null)
					model.setStrDisplay(strDisplay[i]);
				if (fDel[i] != null)
					model.setFDel(fDel[i]);
				if (fSlsOfcCd[i] != null)
					model.setFSlsOfcCd(fSlsOfcCd[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fProVw[i] != null)
					model.setFProVw(fProVw[i]);
				if (fProObj[i] != null)
					model.setFProObj(fProObj[i]);
				if (fOpView[i] != null)
					model.setFOpView(fOpView[i]);
				if (fVvd2[i] != null)
					model.setFVvd2(fVvd2[i]);
				if (fVvd3[i] != null)
					model.setFVvd3(fVvd3[i]);
				if (fOfcLvl[i] != null)
					model.setFOfcLvl(fOfcLvl[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fPol[i] != null)
					model.setFPol(fPol[i]);
				if (fBkgNo[i] != null)
					model.setFBkgNo(fBkgNo[i]);
				if (fVvd1[i] != null)
					model.setFVvd1(fVvd1[i]);
				if (fOfcVw[i] != null)
					model.setFOfcVw(fOfcVw[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (fPor[i] != null)
					model.setFPor(fPor[i]);
				if (fRfa[i] != null)
					model.setFRfa(fRfa[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fLoclLang[i] != null)
					model.setFLoclLang(fLoclLang[i]);
				if (fProLvl[i] != null)
					model.setFProLvl(fProLvl[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fCmdt[i] != null)
					model.setFCmdt(fCmdt[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fShipper[i] != null)
					model.setFShipper(fShipper[i]);
				if (fPod[i] != null)
					model.setFPod(fPod[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepoPfmcConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepoPfmcConditionVO[]
	 */
	public RepoPfmcConditionVO[] getRepoPfmcConditionVOs(){
		RepoPfmcConditionVO[] vos = (RepoPfmcConditionVO[])models.toArray(new RepoPfmcConditionVO[models.size()]);
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
		this.fUsaMode = this.fUsaMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExclSts = this.fExclSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSchMode = this.fSchMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRCmdt = this.fRCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSc = this.fSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChtbiz = this.fChtbiz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strDisplay = this.strDisplay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel = this.fDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsOfcCd = this.fSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProVw = this.fProVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProObj = this.fProObj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOpView = this.fOpView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd2 = this.fVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd3 = this.fVvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPol = this.fPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgNo = this.fBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd1 = this.fVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVw = this.fOfcVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPor = this.fPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfa = this.fRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLoclLang = this.fLoclLang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProLvl = this.fProLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmdt = this.fCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fShipper = this.fShipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPod = this.fPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
