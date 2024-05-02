/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RepoPfmcConditionVO.java
*@FileTitle : RepoPfmcConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.30 최성민 
* 1.0 Creation
* 2014.01.02 김수정 [CHM-201327858] [COA] IAS P&L 추가
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepoPfmcConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepoPfmcConditionVO> models = new ArrayList<RepoPfmcConditionVO>();
	
	/* Column Info */
	private String fExclSts = null;
	/* Column Info */
	private String fTab = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fOpView = null;
	/* Column Info */
	private String fOfcLvl = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fOfcVw = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fIskorean = null;
	/* Column Info */
	private String fIskoreanA = null;
	/* Column Info */
	private String fTrdDirCd = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String fUsaMode = null;
	/* Column Info */
	private String fSchMode = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fRCmdt = null;
	/* Column Info */
	private String fSc = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fChtbiz = null;
	/* Column Info */
	private String fDel = null;
	/* Column Info */
	private String strDisplay = null;
	/* Column Info */
	private String fSlsOfcCd = null;
	/* Column Info */
	private String fProVw = null;
	/* Column Info */
	private String fProObj = null;
	/* Column Info */
	private String fVvd2 = null;
	/* Column Info */
	private String fVvd3 = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String fIasRgnCd = null;
	/* Column Info */
	private String fBkgNo = null;
	/* Column Info */
	private String fPol = null;
	/* Column Info */
	private String fVvd1 = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fRfa = null;
	/* Column Info */
	private String fPor = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String fProLvl = null;
	/* Column Info */
	private String fCmdt = null;
	/* Column Info */
	private String fSubTrdCd = null;
	/* Column Info */
	private String fShipper = null;
	/* Column Info */
	private String fPod = null;
	/* Column Info */
	private String fInitCost = null;
	/* Column Info */
	private String fIasFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepoPfmcConditionVO() {}

	public RepoPfmcConditionVO(String ibflag, String pagerows, String fUsaMode, String fExclSts, String fSchMode, String fChkprd, String fFmMon, String fDirCd, String fRCmdt, String fSc, String fRhqCd, String fCntrTpszCd, String fChtbiz, String strDisplay, String fDel, String fSlsOfcCd, String fVslCd, String fProVw, String fProObj, String fOpView, String fVvd2, String fVvd3, String fOfcLvl, String fCostYrmon, String fFmWk, String fBkgNo, String fPol, String fVvd1, String fSkdDirCd, String fOfcVw, String fToMon, String fSkdVoyNo, String fRfa, String fPor, String fOfcCd, String fTrdCd, String fToWk, String fProLvl, String fIskorean, String fIskoreanA, String fCmdt, String fRlaneCd, String fShipper, String fPod, String fYear, String fSlsMon, String fTab, String fSubTrdCd, String fTrdDirCd, String fIasRgnCd, String fInitCost, String fIasFlg) {
		this.fExclSts = fExclSts;
		this.fTab = fTab;
		this.fFmMon = fFmMon;
		this.fDirCd = fDirCd;
		this.fRhqCd = fRhqCd;
		this.fSlsMon = fSlsMon;
		this.pagerows = pagerows;
		this.fVslCd = fVslCd;
		this.fOpView = fOpView;
		this.fOfcLvl = fOfcLvl;
		this.fFmWk = fFmWk;
		this.fOfcVw = fOfcVw;
		this.fToMon = fToMon;
		this.fSkdVoyNo = fSkdVoyNo;
		this.fTrdCd = fTrdCd;
		this.fToWk = fToWk;
		this.fIskorean = fIskorean;
		this.fIskoreanA = fIskoreanA;
		this.fTrdDirCd = fTrdDirCd;
		this.fRlaneCd = fRlaneCd;
		this.fYear = fYear;
		this.fUsaMode = fUsaMode;
		this.fSchMode = fSchMode;
		this.fChkprd = fChkprd;
		this.fRCmdt = fRCmdt;
		this.fSc = fSc;
		this.fCntrTpszCd = fCntrTpszCd;
		this.ibflag = ibflag;
		this.fChtbiz = fChtbiz;
		this.fDel = fDel;
		this.strDisplay = strDisplay;
		this.fSlsOfcCd = fSlsOfcCd;
		this.fProVw = fProVw;
		this.fProObj = fProObj;
		this.fVvd2 = fVvd2;
		this.fVvd3 = fVvd3;
		this.fCostYrmon = fCostYrmon;
		this.fIasRgnCd = fIasRgnCd;
		this.fBkgNo = fBkgNo;
		this.fPol = fPol;
		this.fVvd1 = fVvd1;
		this.fSkdDirCd = fSkdDirCd;
		this.fRfa = fRfa;
		this.fPor = fPor;
		this.fOfcCd = fOfcCd;
		this.fProLvl = fProLvl;
		this.fCmdt = fCmdt;
		this.fSubTrdCd = fSubTrdCd;
		this.fShipper = fShipper;
		this.fPod = fPod;
		this.fInitCost = fInitCost;
		this.fIasFlg = fIasFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_excl_sts", getFExclSts());
		this.hashColumns.put("f_tab", getFTab());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_op_view", getFOpView());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_ofc_vw", getFOfcVw());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_iskorean", getFIskorean());
		this.hashColumns.put("f_iskorean_a", getFIskoreanA());
		this.hashColumns.put("f_trd_dir_cd", getFTrdDirCd());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("f_usa_mode", getFUsaMode());
		this.hashColumns.put("f_sch_mode", getFSchMode());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_r_cmdt", getFRCmdt());
		this.hashColumns.put("f_sc", getFSc());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_chtbiz", getFChtbiz());
		this.hashColumns.put("f_del", getFDel());
		this.hashColumns.put("str_display", getStrDisplay());
		this.hashColumns.put("f_sls_ofc_cd", getFSlsOfcCd());
		this.hashColumns.put("f_pro_vw", getFProVw());
		this.hashColumns.put("f_pro_obj", getFProObj());
		this.hashColumns.put("f_vvd2", getFVvd2());
		this.hashColumns.put("f_vvd3", getFVvd3());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("f_ias_rgn_cd", getFIasRgnCd());
		this.hashColumns.put("f_bkg_no", getFBkgNo());
		this.hashColumns.put("f_pol", getFPol());
		this.hashColumns.put("f_vvd1", getFVvd1());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_rfa", getFRfa());
		this.hashColumns.put("f_por", getFPor());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("f_pro_lvl", getFProLvl());
		this.hashColumns.put("f_cmdt", getFCmdt());
		this.hashColumns.put("f_sub_trd_cd", getFSubTrdCd());
		this.hashColumns.put("f_shipper", getFShipper());
		this.hashColumns.put("f_pod", getFPod());
		this.hashColumns.put("f_init_cost", getFInitCost());
		this.hashColumns.put("f_ias_flg", getFIasFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_excl_sts", "fExclSts");
		this.hashFields.put("f_tab", "fTab");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_op_view", "fOpView");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_ofc_vw", "fOfcVw");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_iskorean", "fIskorean");
		this.hashFields.put("f_iskorean_a", "fIskoreanA");
		this.hashFields.put("f_trd_dir_cd", "fTrdDirCd");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("f_usa_mode", "fUsaMode");
		this.hashFields.put("f_sch_mode", "fSchMode");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_r_cmdt", "fRCmdt");
		this.hashFields.put("f_sc", "fSc");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_chtbiz", "fChtbiz");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("str_display", "strDisplay");
		this.hashFields.put("f_sls_ofc_cd", "fSlsOfcCd");
		this.hashFields.put("f_pro_vw", "fProVw");
		this.hashFields.put("f_pro_obj", "fProObj");
		this.hashFields.put("f_vvd2", "fVvd2");
		this.hashFields.put("f_vvd3", "fVvd3");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("f_ias_rgn_cd", "fIasRgnCd");
		this.hashFields.put("f_bkg_no", "fBkgNo");
		this.hashFields.put("f_pol", "fPol");
		this.hashFields.put("f_vvd1", "fVvd1");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_rfa", "fRfa");
		this.hashFields.put("f_por", "fPor");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("f_pro_lvl", "fProLvl");
		this.hashFields.put("f_cmdt", "fCmdt");
		this.hashFields.put("f_sub_trd_cd", "fSubTrdCd");
		this.hashFields.put("f_shipper", "fShipper");
		this.hashFields.put("f_pod", "fPod");
		this.hashFields.put("f_init_cost", "fInitCost");
		this.hashFields.put("f_ias_flg", "fIasFlg");
		return this.hashFields;
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
	 * @return fTab
	 */
	public String getFTab() {
		return this.fTab;
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
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
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
	 * @return fSlsMon
	 */
	public String getFSlsMon() {
		return this.fSlsMon;
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
	 * @return fVslCd
	 */
	public String getFVslCd() {
		return this.fVslCd;
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
	 * @return fOfcLvl
	 */
	public String getFOfcLvl() {
		return this.fOfcLvl;
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
	 * @return fOfcVw
	 */
	public String getFOfcVw() {
		return this.fOfcVw;
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
	 * @return fIskorean
	 */
	public String getFIskorean() {
		return this.fIskorean;
	}
	
	/**
	 * Column Info
	 * @return fIskoreanA
	 */
	public String getFIskoreanA() {
		return this.fIskoreanA;
	}
	
	/**
	 * Column Info
	 * @return fTrdDirCd
	 */
	public String getFTrdDirCd() {
		return this.fTrdDirCd;
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
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
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
	 * @return fRCmdt
	 */
	public String getFRCmdt() {
		return this.fRCmdt;
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
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
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
	 * @return fChtbiz
	 */
	public String getFChtbiz() {
		return this.fChtbiz;
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
	 * @return strDisplay
	 */
	public String getStrDisplay() {
		return this.strDisplay;
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
	 * @return fCostYrmon
	 */
	public String getFCostYrmon() {
		return this.fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return fIasRgnCd
	 */
	public String getFIasRgnCd() {
		return this.fIasRgnCd;
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
	 * @return fPol
	 */
	public String getFPol() {
		return this.fPol;
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
	 * @return fSkdDirCd
	 */
	public String getFSkdDirCd() {
		return this.fSkdDirCd;
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
	 * @return fPor
	 */
	public String getFPor() {
		return this.fPor;
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
	 * @return fProLvl
	 */
	public String getFProLvl() {
		return this.fProLvl;
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
	 * @return fSubTrdCd
	 */
	public String getFSubTrdCd() {
		return this.fSubTrdCd;
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
	 * @return fInitCost
	 */
	public String getFInitCost() {
		return this.fInitCost;
	}
	
	/**
	 * Column Info
	 * @return fIasFlg
	 */
	public String getFIasFlg() {
		return this.fIasFlg;
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
	 * @param fTab
	 */
	public void setFTab(String fTab) {
		this.fTab = fTab;
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
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
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
	 * @param fSlsMon
	 */
	public void setFSlsMon(String fSlsMon) {
		this.fSlsMon = fSlsMon;
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
	 * @param fVslCd
	 */
	public void setFVslCd(String fVslCd) {
		this.fVslCd = fVslCd;
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
	 * @param fOfcLvl
	 */
	public void setFOfcLvl(String fOfcLvl) {
		this.fOfcLvl = fOfcLvl;
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
	 * @param fOfcVw
	 */
	public void setFOfcVw(String fOfcVw) {
		this.fOfcVw = fOfcVw;
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
	 * @param fIskorean
	 */
	public void setFIskorean(String fIskorean) {
		this.fIskorean = fIskorean;
	}
	
	/**
	 * Column Info
	 * @param fIskoreanA
	 */
	public void setFIskoreanA(String fIskoreanA) {
		this.fIskoreanA = fIskoreanA;
	}
	
	/**
	 * Column Info
	 * @param fTrdDirCd
	 */
	public void setFTrdDirCd(String fTrdDirCd) {
		this.fTrdDirCd = fTrdDirCd;
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
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
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
	 * @param fRCmdt
	 */
	public void setFRCmdt(String fRCmdt) {
		this.fRCmdt = fRCmdt;
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
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
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
	 * @param fChtbiz
	 */
	public void setFChtbiz(String fChtbiz) {
		this.fChtbiz = fChtbiz;
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
	 * @param strDisplay
	 */
	public void setStrDisplay(String strDisplay) {
		this.strDisplay = strDisplay;
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
	 * @param fCostYrmon
	 */
	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param fIasRgnCd
	 */
	public void setFIasRgnCd(String fIasRgnCd) {
		this.fIasRgnCd = fIasRgnCd;
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
	 * @param fPol
	 */
	public void setFPol(String fPol) {
		this.fPol = fPol;
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
	 * @param fSkdDirCd
	 */
	public void setFSkdDirCd(String fSkdDirCd) {
		this.fSkdDirCd = fSkdDirCd;
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
	 * @param fPor
	 */
	public void setFPor(String fPor) {
		this.fPor = fPor;
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
	 * @param fProLvl
	 */
	public void setFProLvl(String fProLvl) {
		this.fProLvl = fProLvl;
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
	 * @param fSubTrdCd
	 */
	public void setFSubTrdCd(String fSubTrdCd) {
		this.fSubTrdCd = fSubTrdCd;
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
	 * @param fInitCost
	 */
	public void setFInitCost(String fInitCost) {
		this.fInitCost = fInitCost;
	}
	
	/**
	 * Column Info
	 * @param fIasFlg
	 */
	public void setFIasFlg(String fIasFlg) {
		this.fIasFlg = fIasFlg;
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
		setFExclSts(JSPUtil.getParameter(request, prefix + "f_excl_sts", ""));
		setFTab(JSPUtil.getParameter(request, prefix + "f_tab", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
		setFOpView(JSPUtil.getParameter(request, prefix + "f_op_view", ""));
		setFOfcLvl(JSPUtil.getParameter(request, prefix + "f_ofc_lvl", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFOfcVw(JSPUtil.getParameter(request, prefix + "f_ofc_vw", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setFIskorean(JSPUtil.getParameter(request, prefix + "f_iskorean", ""));
		setFIskoreanA(JSPUtil.getParameter(request, prefix + "f_iskorean_a", ""));
		setFTrdDirCd(JSPUtil.getParameter(request, prefix + "f_trd_dir_cd", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setFUsaMode(JSPUtil.getParameter(request, prefix + "f_usa_mode", ""));
		setFSchMode(JSPUtil.getParameter(request, prefix + "f_sch_mode", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFRCmdt(JSPUtil.getParameter(request, prefix + "f_r_cmdt", ""));
		setFSc(JSPUtil.getParameter(request, prefix + "f_sc", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFChtbiz(JSPUtil.getParameter(request, prefix + "f_chtbiz", ""));
		setFDel(JSPUtil.getParameter(request, prefix + "f_del", ""));
		setStrDisplay(JSPUtil.getParameter(request, prefix + "str_display", ""));
		setFSlsOfcCd(JSPUtil.getParameter(request, prefix + "f_sls_ofc_cd", ""));
		setFProVw(JSPUtil.getParameter(request, prefix + "f_pro_vw", ""));
		setFProObj(JSPUtil.getParameter(request, prefix + "f_pro_obj", ""));
		setFVvd2(JSPUtil.getParameter(request, prefix + "f_vvd2", ""));
		setFVvd3(JSPUtil.getParameter(request, prefix + "f_vvd3", ""));
		setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setFIasRgnCd(JSPUtil.getParameter(request, prefix + "f_ias_rgn_cd", ""));
		setFBkgNo(JSPUtil.getParameter(request, prefix + "f_bkg_no", ""));
		setFPol(JSPUtil.getParameter(request, prefix + "f_pol", ""));
		setFVvd1(JSPUtil.getParameter(request, prefix + "f_vvd1", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", ""));
		setFRfa(JSPUtil.getParameter(request, prefix + "f_rfa", ""));
		setFPor(JSPUtil.getParameter(request, prefix + "f_por", ""));
		setFOfcCd(JSPUtil.getParameter(request, prefix + "f_ofc_cd", ""));
		setFProLvl(JSPUtil.getParameter(request, prefix + "f_pro_lvl", ""));
		setFCmdt(JSPUtil.getParameter(request, prefix + "f_cmdt", ""));
		setFSubTrdCd(JSPUtil.getParameter(request, prefix + "f_sub_trd_cd", ""));
		setFShipper(JSPUtil.getParameter(request, prefix + "f_shipper", ""));
		setFPod(JSPUtil.getParameter(request, prefix + "f_pod", ""));
		setFInitCost(JSPUtil.getParameter(request, prefix + "f_init_cost", ""));
		setFIasFlg(JSPUtil.getParameter(request, prefix + "f_ias_flg", ""));
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
			String[] fExclSts = (JSPUtil.getParameter(request, prefix	+ "f_excl_sts", length));
			String[] fTab = (JSPUtil.getParameter(request, prefix	+ "f_tab", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fOpView = (JSPUtil.getParameter(request, prefix	+ "f_op_view", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fOfcVw = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fIskorean = (JSPUtil.getParameter(request, prefix	+ "f_iskorean", length));
			String[] fIskoreanA = (JSPUtil.getParameter(request, prefix	+ "f_iskorean_a", length));
			String[] fTrdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_dir_cd", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] fUsaMode = (JSPUtil.getParameter(request, prefix	+ "f_usa_mode", length));
			String[] fSchMode = (JSPUtil.getParameter(request, prefix	+ "f_sch_mode", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fRCmdt = (JSPUtil.getParameter(request, prefix	+ "f_r_cmdt", length));
			String[] fSc = (JSPUtil.getParameter(request, prefix	+ "f_sc", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fChtbiz = (JSPUtil.getParameter(request, prefix	+ "f_chtbiz", length));
			String[] fDel = (JSPUtil.getParameter(request, prefix	+ "f_del", length));
			String[] strDisplay = (JSPUtil.getParameter(request, prefix	+ "str_display", length));
			String[] fSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sls_ofc_cd", length));
			String[] fProVw = (JSPUtil.getParameter(request, prefix	+ "f_pro_vw", length));
			String[] fProObj = (JSPUtil.getParameter(request, prefix	+ "f_pro_obj", length));
			String[] fVvd2 = (JSPUtil.getParameter(request, prefix	+ "f_vvd2", length));
			String[] fVvd3 = (JSPUtil.getParameter(request, prefix	+ "f_vvd3", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] fIasRgnCd = (JSPUtil.getParameter(request, prefix	+ "f_ias_rgn_cd", length));
			String[] fBkgNo = (JSPUtil.getParameter(request, prefix	+ "f_bkg_no", length));
			String[] fPol = (JSPUtil.getParameter(request, prefix	+ "f_pol", length));
			String[] fVvd1 = (JSPUtil.getParameter(request, prefix	+ "f_vvd1", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fRfa = (JSPUtil.getParameter(request, prefix	+ "f_rfa", length));
			String[] fPor = (JSPUtil.getParameter(request, prefix	+ "f_por", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] fProLvl = (JSPUtil.getParameter(request, prefix	+ "f_pro_lvl", length));
			String[] fCmdt = (JSPUtil.getParameter(request, prefix	+ "f_cmdt", length));
			String[] fSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_trd_cd", length));
			String[] fShipper = (JSPUtil.getParameter(request, prefix	+ "f_shipper", length));
			String[] fPod = (JSPUtil.getParameter(request, prefix	+ "f_pod", length));
			String[] fInitCost = (JSPUtil.getParameter(request, prefix	+ "f_init_cost", length));
			String[] fIasFlg = (JSPUtil.getParameter(request, prefix	+ "f_ias_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepoPfmcConditionVO();
				if (fExclSts[i] != null)
					model.setFExclSts(fExclSts[i]);
				if (fTab[i] != null)
					model.setFTab(fTab[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fOpView[i] != null)
					model.setFOpView(fOpView[i]);
				if (fOfcLvl[i] != null)
					model.setFOfcLvl(fOfcLvl[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fOfcVw[i] != null)
					model.setFOfcVw(fOfcVw[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fIskorean[i] != null)
					model.setFIskorean(fIskorean[i]);
				if (fIskoreanA[i] != null)
					model.setFIskoreanA(fIskoreanA[i]);
				if (fTrdDirCd[i] != null)
					model.setFTrdDirCd(fTrdDirCd[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (fUsaMode[i] != null)
					model.setFUsaMode(fUsaMode[i]);
				if (fSchMode[i] != null)
					model.setFSchMode(fSchMode[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fRCmdt[i] != null)
					model.setFRCmdt(fRCmdt[i]);
				if (fSc[i] != null)
					model.setFSc(fSc[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fChtbiz[i] != null)
					model.setFChtbiz(fChtbiz[i]);
				if (fDel[i] != null)
					model.setFDel(fDel[i]);
				if (strDisplay[i] != null)
					model.setStrDisplay(strDisplay[i]);
				if (fSlsOfcCd[i] != null)
					model.setFSlsOfcCd(fSlsOfcCd[i]);
				if (fProVw[i] != null)
					model.setFProVw(fProVw[i]);
				if (fProObj[i] != null)
					model.setFProObj(fProObj[i]);
				if (fVvd2[i] != null)
					model.setFVvd2(fVvd2[i]);
				if (fVvd3[i] != null)
					model.setFVvd3(fVvd3[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (fIasRgnCd[i] != null)
					model.setFIasRgnCd(fIasRgnCd[i]);
				if (fBkgNo[i] != null)
					model.setFBkgNo(fBkgNo[i]);
				if (fPol[i] != null)
					model.setFPol(fPol[i]);
				if (fVvd1[i] != null)
					model.setFVvd1(fVvd1[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fRfa[i] != null)
					model.setFRfa(fRfa[i]);
				if (fPor[i] != null)
					model.setFPor(fPor[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (fProLvl[i] != null)
					model.setFProLvl(fProLvl[i]);
				if (fCmdt[i] != null)
					model.setFCmdt(fCmdt[i]);
				if (fSubTrdCd[i] != null)
					model.setFSubTrdCd(fSubTrdCd[i]);
				if (fShipper[i] != null)
					model.setFShipper(fShipper[i]);
				if (fPod[i] != null)
					model.setFPod(fPod[i]);
				if (fInitCost[i] != null)
					model.setFInitCost(fInitCost[i]);
				if (fIasFlg[i] != null)
					model.setFIasFlg(fIasFlg[i]);
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
		this.fExclSts = this.fExclSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTab = this.fTab .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOpView = this.fOpView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVw = this.fOfcVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIskorean = this.fIskorean .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIskoreanA = this.fIskoreanA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdDirCd = this.fTrdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsaMode = this.fUsaMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSchMode = this.fSchMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRCmdt = this.fRCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSc = this.fSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChtbiz = this.fChtbiz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel = this.fDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strDisplay = this.strDisplay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsOfcCd = this.fSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProVw = this.fProVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProObj = this.fProObj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd2 = this.fVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd3 = this.fVvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIasRgnCd = this.fIasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgNo = this.fBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPol = this.fPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVvd1 = this.fVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfa = this.fRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPor = this.fPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProLvl = this.fProLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmdt = this.fCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubTrdCd = this.fSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fShipper = this.fShipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPod = this.fPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fInitCost = this.fInitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIasFlg = this.fIasFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
