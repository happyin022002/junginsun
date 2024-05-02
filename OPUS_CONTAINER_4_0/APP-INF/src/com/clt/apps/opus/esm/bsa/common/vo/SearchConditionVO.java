/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchConditionVO.java
*@FileTitle : SearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2010.03.23 김기식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.common.vo;

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

public class SearchConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchConditionVO> models = new ArrayList<SearchConditionVO>();
	
	/* Column Info */
	private String fSvcTrnsPrcCntCd = null;
	/* Column Info */
	private String fExclSts = null;
	/* Column Info */
	private String fTaaNo = null;
	/* Column Info */
	private String fCboRcc = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fSelclass = null;
	/* Column Info */
	private String fRccCd = null;
	/* Column Info */
	private String fHIocCd = null;
	/* Column Info */
	private String fWtrTermCd = null;
	/* Column Info */
	private String fStrtrade = null;
	/* Column Info */
	private String fCobtrade = null;
	/* Column Info */
	private String fSavename = null;
	/* Column Info */
	private String fPodEccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fExclSub = null;
	/* Column Info */
	private String fStrtomonth = null;
	/* Column Info */
	private String fTo = null;
	/* Column Info */
	private String fBkgPodCd = null;
	/* Column Info */
	private String fBkgDelCd = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fSelcost = null;
	/* Column Info */
	private String fRoutNo = null;
	/* Column Info */
	private String fAvgGrpCd = null;
	/* Column Info */
	private String fViewTpsz = null;
	/* Column Info */
	private String fBkgPolCd = null;
	/* Column Info */
	private String fStrprcnm = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fStrtoweek = null;
	/* Column Info */
	private String fSim = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fSimDt = null;
	/* Column Info */
	private String fBkgSts = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fBkgPorCd = null;
	/* Column Info */
	private String fIocCd = null;
	/* Column Info */
	private String fStrvoyage = null;
	/* Column Info */
	private String fEweek = null;
	/* Column Info */
	private String fEccCd = null;
	/* Column Info */
	private String fStrfmmonth = null;
	/* Column Info */
	private String fSelvessel = null;
	/* Column Info */
	private String fRevPolCd = null;
	/* Column Info */
	private String fDividename = null;
	/* Column Info */
	private String fMtyEccCd = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fTypeCd = null;
	/* Column Info */
	private String fCoblane = null;
	/* Column Info */
	private String fTmlCd = null;
	/* Column Info */
	private String fSocSts = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String fSdate = null;
	/* Column Info */
	private String fFromEcc = null;
	/* Column Info */
	private String fCustSeq = null;
	/* Column Info */
	private String fCbotrade = null;
	/* Column Info */
	private String fDel = null;
	/* Column Info */
	private String fEmon = null;
	/* Column Info */
	private String fProVw = null;
	/* Column Info */
	private String fSrcMon = null;
	/* Column Info */
	private String fYearmonth = null;
	/* Column Info */
	private String fToEccCd = null;
	/* Column Info */
	private String fOriDest = null;
	/* Column Info */
	private String fShprCd = null;
	/* Column Info */
	private String fShpr = null;
	/* Column Info */
	private String fGroup = null;
	/* Column Info */
	private String fVessel = null;
	/* Column Info */
	private String fBkgNo = null;
	/* Column Info */
	private String fFromEccCd = null;
	/* Column Info */
	private String fCommLocCd = null;
	/* Column Info */
	private String fCostYr = null;
	/* Column Info */
	private String fRfa = null;
	/* Column Info */
	private String fPor = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String fCustCntCd = null;
	/* Column Info */
	private String fProLvl = null;
	/* Column Info */
	private String fSubTrdCd = null;
	/* Column Info */
	private String fLccCd = null;
	/* Column Info */
	private String fHTrdCd = null;
	/* Column Info */
	private String fShipper = null;
	/* Column Info */
	private String fRfaNo = null;
	/* Column Info */
	private String fPod = null;
	/* Column Info */
	private String fSimNo = null;
	/* Column Info */
	private String fYearweek = null;
	/* Column Info */
	private String fCobioc = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fYrtype = null;
	/* Column Info */
	private String fUsaBkgModCd = null;
	/* Column Info */
	private String fOpLaneTpCd = null;
	/* Column Info */
	private String f3td = null;
	/* Column Info */
	private String fOfcActCd = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String fFullMtyCd = null;
	/* Column Info */
	private String fKeyAcctIndvlCd = null;
	/* Column Info */
	private String fLocCd = null;
	/* Column Info */
	private String fWkSts = null;
	/* Column Info */
	private String fSelrlane = null;
	/* Column Info */
	private String fStrtype = null;
	/* Column Info */
	private String fRevYrmon = null;
	/* Column Info */
	private String fCmdtCd = null;
	/* Column Info */
	private String fCobdir = null;
	/* Column Info */
	private String fMtyLccCd = null;
	/* Column Info */
	private String fOpView = null;
	/* Column Info */
	private String fCrrCd = null;
	/* Column Info */
	private String fSelgroup = null;
	/* Column Info */
	private String f2nd = null;
	/* Column Info */
	private String fOfcLvl = null;
	/* Column Info */
	private String fSweek = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fHeader = null;
	/* Column Info */
	private String fCobcost = null;
	/* Column Info */
	private String fOfcVw = null;
	/* Column Info */
	private String fSpclCgoAwkFlg = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String fScNo = null;
	/* Column Info */
	private String fDirSts = null;
	/* Column Info */
	private String fWkCd = null;
	/* Column Info */
	private String fKeyAcctGroupCd = null;
	/* Column Info */
	private String fHeadernm = null;
	/* Column Info */
	private String fSpclCgoDgFlg = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fLoc = null;
	/* Column Info */
	private String fHDirCd = null;
	/* Column Info */
	private String fCboslane = null;
	/* Column Info */
	private String fPctlNo = null;
	/* Column Info */
	private String fSpclCgoRfFlg = null;
	/* Column Info */
	private String fStrdir = null;
	/* Column Info */
	private String fCboEcc = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String fChkprevcre = null;
	/* Column Info */
	private String fStrfmweek = null;
	/* Column Info */
	private String fSpclCgoBbFlg = null;
	/* Column Info */
	private String fSlanCd = null;
	/* Column Info */
	private String fFrom = null;
	/* Column Info */
	private String fEccCd2 = null;
	/* Column Info */
	private String fChkBsazrflg = null;
	/* Column Info */
	private String fActGrpCd = null;
	/* Column Info */
	private String fBkgDisp = null;
	/* Column Info */
	private String fVoyage = null;
	/* Column Info */
	private String fSeldir = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fMtyRccCd = null;
	/* Column Info */
	private String fChkdel = null;
	/* Column Info */
	private String fXLev = null;
	/* Column Info */
	private String fSlsOfcCd = null;
	/* Column Info */
	private String fLoclCurrCd = null;
	/* Column Info */
	private String fCboLcc = null;
	/* Column Info */
	private String fAvgSuvgrp = null;
	/* Column Info */
	private String fHRlaneCd = null;
	/* Column Info */
	private String fStrchkprd = null;
	/* Column Info */
	private String fToEcc = null;
	/* Column Info */
	private String fSmon = null;
	/* Column Info */
	private String fTarMon = null;
	/* Column Info */
	private String fCoaCd = null;
	/* Column Info */
	private String fCostLocGrpCd = null;
	/* Column Info */
	private String fCostYrmon = null;
	/* Column Info */
	private String fSeltrade = null;
	/* Column Info */
	private String fStrlane = null;
	/* Column Info */
	private String fSelioc = null;
	/* Column Info */
	private String fEcc = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fDir = null;
	/* Column Info */
	private String fCostFmMon = null;
	/* Column Info */
	private String fCalcTermCd = null;
	/* Column Info */
	private String fVslCd2 = null;
	/* Column Info */
	private String fInout = null;
	/* Column Info */
	private String istrade = null;
	/* Column Info */
	private String fBkgNoSplit = null;
	/* Column Info */
	private String fSelslane = null;
	/* Column Info */
	private String fRevPodCd = null;
	/* Column Info */
	private String fStrvessel = null;
	/* Column Info */
	private String fStryear = null;
	/* Column Info */
	private String f1st = null;
	/* Column Info */
	private String fSelcapa = null;
	/* Column Info */
	private String fRdInd = null;
	/* Column Info */
	private String f4th = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchConditionVO() {}

	public SearchConditionVO(String ibflag, String pagerows, String fTrdCd, String fRlaneCd, String fSlanCd, String fVslCd, String fSkdVoyNo, String fDirCd, String fBkgNo, String fProVw, String fOfcVw, String fProLvl, String fOfcLvl, String fOfcCd, String fBkgPorCd, String fRevPolCd, String fRevPodCd, String fBkgDelCd, String fShprCd, String fScNo, String fRfaNo, String fKeyAcctGroupCd, String fKeyAcctIndvlCd, String fCmdtCd, String fUsaBkgModCd, String fCntrTpszCd, String fPor, String fDel, String fCostYrmon, String fCostYr, String fCostFmMon, String fCboRcc, String fCboLcc, String fCboEcc, String fLoc, String fEcc, String fXLev, String fWtrTermCd, String fCalcTermCd, String fLocCd, String fFullMtyCd, String fLoclCurrCd, String fSpclCgoDgFlg, String fSpclCgoBbFlg, String fSpclCgoAwkFlg, String fSpclCgoRfFlg, String fActGrpCd, String fCostLocGrpCd, String fFrom, String fTo, String fPod, String fEccCd, String fLccCd, String fRccCd, String fSimDt, String fSimNo, String fMtyEccCd, String fMtyLccCd, String fMtyRccCd, String fSvcTrnsPrcCntCd, String fOfcActCd, String fChkprd, String fYear, String fFmMon, String fToMon, String fFmWk, String fToWk, String fIocCd, String fPctlNo, String fEccCd2, String fRdInd, String fRoutNo, String fOriDest, String fFromEcc, String fToEcc, String fFromEccCd, String fPodEccCd, String fToEccCd, String fRevYrmon, String fCustCntCd, String fCustSeq, String fSlsMon, String fRhqCd, String fSlsOfcCd, String fExclSub, String fSkdDirCd, String fShpr, String fViewTpsz, String fBkgDisp, String fBkgSts, String fDirSts, String fSocSts, String fWkSts, String fWkCd, String istrade, String fSubTrdCd, String fCommLocCd, String fTmlCd, String f1st, String f2nd, String f3td, String f4th, String fInout, String fChkdel, String fSeltrade, String fSelrlane, String fSeldir, String fSelioc, String fSelslane, String fTypeCd, String fChkprevcre, String fYrtype, String fYearweek, String fSelclass, String fSdate, String fHeader, String fSelvessel, String fCobtrade, String fCoblane, String fVessel, String fVoyage, String fDir, String fStrprcnm, String fChkBsazrflg, String fStrchkprd, String fStryear, String fStrfmweek, String fStrtoweek, String fStrfmmonth, String fStrtomonth, String fStrtrade, String fStrlane, String fStrvessel, String fStrvoyage, String fStrdir, String fStrtype, String fCobcost, String fSelcapa, String fSmon, String fEmon, String fSweek, String fEweek, String fCobioc, String fSelcost, String fYearmonth, String fCobdir, String fCbotrade, String fCboslane, String fVslCd2, String fCrrCd, String fHTrdCd, String fHRlaneCd, String fHDirCd, String fHIocCd, String fSelgroup, String fHeadernm, String fShipper, String fRfa, String fBkgNoSplit, String fExclSts, String fGroup, String fSavename, String fDividename, String fBkgPolCd, String fBkgPodCd, String fOpView, String fAvgSuvgrp, String fAvgGrpCd, String fCoaCd, String fSrcMon, String fTarMon, String fOpLaneTpCd, String fTaaNo, String fSim) {
		this.fSvcTrnsPrcCntCd = fSvcTrnsPrcCntCd;
		this.fExclSts = fExclSts;
		this.fTaaNo = fTaaNo;
		this.fCboRcc = fCboRcc;
		this.fFmMon = fFmMon;
		this.fSelclass = fSelclass;
		this.fRccCd = fRccCd;
		this.fHIocCd = fHIocCd;
		this.fWtrTermCd = fWtrTermCd;
		this.fStrtrade = fStrtrade;
		this.fCobtrade = fCobtrade;
		this.fSavename = fSavename;
		this.fPodEccCd = fPodEccCd;
		this.pagerows = pagerows;
		this.fExclSub = fExclSub;
		this.fStrtomonth = fStrtomonth;
		this.fTo = fTo;
		this.fBkgPodCd = fBkgPodCd;
		this.fBkgDelCd = fBkgDelCd;
		this.fVslCd = fVslCd;
		this.fSelcost = fSelcost;
		this.fRoutNo = fRoutNo;
		this.fAvgGrpCd = fAvgGrpCd;
		this.fViewTpsz = fViewTpsz;
		this.fBkgPolCd = fBkgPolCd;
		this.fStrprcnm = fStrprcnm;
		this.fToMon = fToMon;
		this.fStrtoweek = fStrtoweek;
		this.fSim = fSim;
		this.fTrdCd = fTrdCd;
		this.fSimDt = fSimDt;
		this.fBkgSts = fBkgSts;
		this.fRlaneCd = fRlaneCd;
		this.fBkgPorCd = fBkgPorCd;
		this.fIocCd = fIocCd;
		this.fStrvoyage = fStrvoyage;
		this.fEweek = fEweek;
		this.fEccCd = fEccCd;
		this.fStrfmmonth = fStrfmmonth;
		this.fSelvessel = fSelvessel;
		this.fRevPolCd = fRevPolCd;
		this.fDividename = fDividename;
		this.fMtyEccCd = fMtyEccCd;
		this.fChkprd = fChkprd;
		this.fTypeCd = fTypeCd;
		this.fCoblane = fCoblane;
		this.fTmlCd = fTmlCd;
		this.fSocSts = fSocSts;
		this.fCntrTpszCd = fCntrTpszCd;
		this.fSdate = fSdate;
		this.fFromEcc = fFromEcc;
		this.fCustSeq = fCustSeq;
		this.fCbotrade = fCbotrade;
		this.fDel = fDel;
		this.fEmon = fEmon;
		this.fProVw = fProVw;
		this.fSrcMon = fSrcMon;
		this.fYearmonth = fYearmonth;
		this.fToEccCd = fToEccCd;
		this.fOriDest = fOriDest;
		this.fShprCd = fShprCd;
		this.fShpr = fShpr;
		this.fGroup = fGroup;
		this.fVessel = fVessel;
		this.fBkgNo = fBkgNo;
		this.fFromEccCd = fFromEccCd;
		this.fCommLocCd = fCommLocCd;
		this.fCostYr = fCostYr;
		this.fRfa = fRfa;
		this.fPor = fPor;
		this.fOfcCd = fOfcCd;
		this.fCustCntCd = fCustCntCd;
		this.fProLvl = fProLvl;
		this.fSubTrdCd = fSubTrdCd;
		this.fLccCd = fLccCd;
		this.fHTrdCd = fHTrdCd;
		this.fShipper = fShipper;
		this.fRfaNo = fRfaNo;
		this.fPod = fPod;
		this.fSimNo = fSimNo;
		this.fYearweek = fYearweek;
		this.fCobioc = fCobioc;
		this.fDirCd = fDirCd;
		this.fYrtype = fYrtype;
		this.fUsaBkgModCd = fUsaBkgModCd;
		this.fOpLaneTpCd = fOpLaneTpCd;
		this.f3td = f3td;
		this.fOfcActCd = fOfcActCd;
		this.fSlsMon = fSlsMon;
		this.fRhqCd = fRhqCd;
		this.fFullMtyCd = fFullMtyCd;
		this.fKeyAcctIndvlCd = fKeyAcctIndvlCd;
		this.fLocCd = fLocCd;
		this.fWkSts = fWkSts;
		this.fSelrlane = fSelrlane;
		this.fStrtype = fStrtype;
		this.fRevYrmon = fRevYrmon;
		this.fCmdtCd = fCmdtCd;
		this.fCobdir = fCobdir;
		this.fMtyLccCd = fMtyLccCd;
		this.fOpView = fOpView;
		this.fCrrCd = fCrrCd;
		this.fSelgroup = fSelgroup;
		this.f2nd = f2nd;
		this.fOfcLvl = fOfcLvl;
		this.fSweek = fSweek;
		this.fFmWk = fFmWk;
		this.fHeader = fHeader;
		this.fCobcost = fCobcost;
		this.fOfcVw = fOfcVw;
		this.fSpclCgoAwkFlg = fSpclCgoAwkFlg;
		this.fSkdVoyNo = fSkdVoyNo;
		this.fScNo = fScNo;
		this.fDirSts = fDirSts;
		this.fWkCd = fWkCd;
		this.fKeyAcctGroupCd = fKeyAcctGroupCd;
		this.fHeadernm = fHeadernm;
		this.fSpclCgoDgFlg = fSpclCgoDgFlg;
		this.fToWk = fToWk;
		this.fLoc = fLoc;
		this.fHDirCd = fHDirCd;
		this.fCboslane = fCboslane;
		this.fPctlNo = fPctlNo;
		this.fSpclCgoRfFlg = fSpclCgoRfFlg;
		this.fStrdir = fStrdir;
		this.fCboEcc = fCboEcc;
		this.fYear = fYear;
		this.fChkprevcre = fChkprevcre;
		this.fStrfmweek = fStrfmweek;
		this.fSpclCgoBbFlg = fSpclCgoBbFlg;
		this.fSlanCd = fSlanCd;
		this.fFrom = fFrom;
		this.fEccCd2 = fEccCd2;
		this.fChkBsazrflg = fChkBsazrflg;
		this.fActGrpCd = fActGrpCd;
		this.fBkgDisp = fBkgDisp;
		this.fVoyage = fVoyage;
		this.fSeldir = fSeldir;
		this.ibflag = ibflag;
		this.fMtyRccCd = fMtyRccCd;
		this.fChkdel = fChkdel;
		this.fXLev = fXLev;
		this.fSlsOfcCd = fSlsOfcCd;
		this.fLoclCurrCd = fLoclCurrCd;
		this.fCboLcc = fCboLcc;
		this.fAvgSuvgrp = fAvgSuvgrp;
		this.fHRlaneCd = fHRlaneCd;
		this.fStrchkprd = fStrchkprd;
		this.fToEcc = fToEcc;
		this.fSmon = fSmon;
		this.fTarMon = fTarMon;
		this.fCoaCd = fCoaCd;
		this.fCostLocGrpCd = fCostLocGrpCd;
		this.fCostYrmon = fCostYrmon;
		this.fSeltrade = fSeltrade;
		this.fStrlane = fStrlane;
		this.fSelioc = fSelioc;
		this.fEcc = fEcc;
		this.fSkdDirCd = fSkdDirCd;
		this.fDir = fDir;
		this.fCostFmMon = fCostFmMon;
		this.fCalcTermCd = fCalcTermCd;
		this.fVslCd2 = fVslCd2;
		this.fInout = fInout;
		this.istrade = istrade;
		this.fBkgNoSplit = fBkgNoSplit;
		this.fSelslane = fSelslane;
		this.fRevPodCd = fRevPodCd;
		this.fStrvessel = fStrvessel;
		this.fStryear = fStryear;
		this.f1st = f1st;
		this.fSelcapa = fSelcapa;
		this.fRdInd = fRdInd;
		this.f4th = f4th;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_svc_trns_prc_cnt_cd", getFSvcTrnsPrcCntCd());
		this.hashColumns.put("f_excl_sts", getFExclSts());
		this.hashColumns.put("f_taa_no", getFTaaNo());
		this.hashColumns.put("f_cbo_rcc", getFCboRcc());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_selclass", getFSelclass());
		this.hashColumns.put("f_rcc_cd", getFRccCd());
		this.hashColumns.put("f_h_ioc_cd", getFHIocCd());
		this.hashColumns.put("f_wtr_term_cd", getFWtrTermCd());
		this.hashColumns.put("f_strtrade", getFStrtrade());
		this.hashColumns.put("f_cobtrade", getFCobtrade());
		this.hashColumns.put("f_savename", getFSavename());
		this.hashColumns.put("f_pod_ecc_cd", getFPodEccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_excl_sub", getFExclSub());
		this.hashColumns.put("f_strtomonth", getFStrtomonth());
		this.hashColumns.put("f_to", getFTo());
		this.hashColumns.put("f_bkg_pod_cd", getFBkgPodCd());
		this.hashColumns.put("f_bkg_del_cd", getFBkgDelCd());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_selcost", getFSelcost());
		this.hashColumns.put("f_rout_no", getFRoutNo());
		this.hashColumns.put("f_avg_grp_cd", getFAvgGrpCd());
		this.hashColumns.put("f_view_tpsz", getFViewTpsz());
		this.hashColumns.put("f_bkg_pol_cd", getFBkgPolCd());
		this.hashColumns.put("f_strprcnm", getFStrprcnm());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_strtoweek", getFStrtoweek());
		this.hashColumns.put("f_sim", getFSim());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_sim_dt", getFSimDt());
		this.hashColumns.put("f_bkg_sts", getFBkgSts());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_bkg_por_cd", getFBkgPorCd());
		this.hashColumns.put("f_ioc_cd", getFIocCd());
		this.hashColumns.put("f_strvoyage", getFStrvoyage());
		this.hashColumns.put("f_eweek", getFEweek());
		this.hashColumns.put("f_ecc_cd", getFEccCd());
		this.hashColumns.put("f_strfmmonth", getFStrfmmonth());
		this.hashColumns.put("f_selvessel", getFSelvessel());
		this.hashColumns.put("f_rev_pol_cd", getFRevPolCd());
		this.hashColumns.put("f_dividename", getFDividename());
		this.hashColumns.put("f_mty_ecc_cd", getFMtyEccCd());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_type_cd", getFTypeCd());
		this.hashColumns.put("f_coblane", getFCoblane());
		this.hashColumns.put("f_tml_cd", getFTmlCd());
		this.hashColumns.put("f_soc_sts", getFSocSts());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("f_sdate", getFSdate());
		this.hashColumns.put("f_from_ecc", getFFromEcc());
		this.hashColumns.put("f_cust_seq", getFCustSeq());
		this.hashColumns.put("f_cbotrade", getFCbotrade());
		this.hashColumns.put("f_del", getFDel());
		this.hashColumns.put("f_emon", getFEmon());
		this.hashColumns.put("f_pro_vw", getFProVw());
		this.hashColumns.put("f_src_mon", getFSrcMon());
		this.hashColumns.put("f_yearmonth", getFYearmonth());
		this.hashColumns.put("f_to_ecc_cd", getFToEccCd());
		this.hashColumns.put("f_ori_dest", getFOriDest());
		this.hashColumns.put("f_shpr_cd", getFShprCd());
		this.hashColumns.put("f_shpr", getFShpr());
		this.hashColumns.put("f_group", getFGroup());
		this.hashColumns.put("f_vessel", getFVessel());
		this.hashColumns.put("f_bkg_no", getFBkgNo());
		this.hashColumns.put("f_from_ecc_cd", getFFromEccCd());
		this.hashColumns.put("f_comm_loc_cd", getFCommLocCd());
		this.hashColumns.put("f_cost_yr", getFCostYr());
		this.hashColumns.put("f_rfa", getFRfa());
		this.hashColumns.put("f_por", getFPor());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("f_cust_cnt_cd", getFCustCntCd());
		this.hashColumns.put("f_pro_lvl", getFProLvl());
		this.hashColumns.put("f_sub_trd_cd", getFSubTrdCd());
		this.hashColumns.put("f_lcc_cd", getFLccCd());
		this.hashColumns.put("f_h_trd_cd", getFHTrdCd());
		this.hashColumns.put("f_shipper", getFShipper());
		this.hashColumns.put("f_rfa_no", getFRfaNo());
		this.hashColumns.put("f_pod", getFPod());
		this.hashColumns.put("f_sim_no", getFSimNo());
		this.hashColumns.put("f_yearweek", getFYearweek());
		this.hashColumns.put("f_cobioc", getFCobioc());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_yrtype", getFYrtype());
		this.hashColumns.put("f_usa_bkg_mod_cd", getFUsaBkgModCd());
		this.hashColumns.put("f_op_lane_tp_cd", getFOpLaneTpCd());
		this.hashColumns.put("f_3td", getF3td());
		this.hashColumns.put("f_ofc_act_cd", getFOfcActCd());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("f_full_mty_cd", getFFullMtyCd());
		this.hashColumns.put("f_key_acct_indvl_cd", getFKeyAcctIndvlCd());
		this.hashColumns.put("f_loc_cd", getFLocCd());
		this.hashColumns.put("f_wk_sts", getFWkSts());
		this.hashColumns.put("f_selrlane", getFSelrlane());
		this.hashColumns.put("f_strtype", getFStrtype());
		this.hashColumns.put("f_rev_yrmon", getFRevYrmon());
		this.hashColumns.put("f_cmdt_cd", getFCmdtCd());
		this.hashColumns.put("f_cobdir", getFCobdir());
		this.hashColumns.put("f_mty_lcc_cd", getFMtyLccCd());
		this.hashColumns.put("f_op_view", getFOpView());
		this.hashColumns.put("f_crr_cd", getFCrrCd());
		this.hashColumns.put("f_selgroup", getFSelgroup());
		this.hashColumns.put("f_2nd", getF2nd());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_sweek", getFSweek());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_header", getFHeader());
		this.hashColumns.put("f_cobcost", getFCobcost());
		this.hashColumns.put("f_ofc_vw", getFOfcVw());
		this.hashColumns.put("f_spcl_cgo_awk_flg", getFSpclCgoAwkFlg());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("f_sc_no", getFScNo());
		this.hashColumns.put("f_dir_sts", getFDirSts());
		this.hashColumns.put("f_wk_cd", getFWkCd());
		this.hashColumns.put("f_key_acct_group_cd", getFKeyAcctGroupCd());
		this.hashColumns.put("f_headernm", getFHeadernm());
		this.hashColumns.put("f_spcl_cgo_dg_flg", getFSpclCgoDgFlg());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_loc", getFLoc());
		this.hashColumns.put("f_h_dir_cd", getFHDirCd());
		this.hashColumns.put("f_cboslane", getFCboslane());
		this.hashColumns.put("f_pctl_no", getFPctlNo());
		this.hashColumns.put("f_spcl_cgo_rf_flg", getFSpclCgoRfFlg());
		this.hashColumns.put("f_strdir", getFStrdir());
		this.hashColumns.put("f_cbo_ecc", getFCboEcc());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("f_chkprevcre", getFChkprevcre());
		this.hashColumns.put("f_strfmweek", getFStrfmweek());
		this.hashColumns.put("f_spcl_cgo_bb_flg", getFSpclCgoBbFlg());
		this.hashColumns.put("f_slan_cd", getFSlanCd());
		this.hashColumns.put("f_from", getFFrom());
		this.hashColumns.put("f_ecc_cd2", getFEccCd2());
		this.hashColumns.put("f_chk_bsazrflg", getFChkBsazrflg());
		this.hashColumns.put("f_act_grp_cd", getFActGrpCd());
		this.hashColumns.put("f_bkg_disp", getFBkgDisp());
		this.hashColumns.put("f_voyage", getFVoyage());
		this.hashColumns.put("f_seldir", getFSeldir());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_mty_rcc_cd", getFMtyRccCd());
		this.hashColumns.put("f_chkdel", getFChkdel());
		this.hashColumns.put("f_x_lev", getFXLev());
		this.hashColumns.put("f_sls_ofc_cd", getFSlsOfcCd());
		this.hashColumns.put("f_locl_curr_cd", getFLoclCurrCd());
		this.hashColumns.put("f_cbo_lcc", getFCboLcc());
		this.hashColumns.put("f_avg_suvgrp", getFAvgSuvgrp());
		this.hashColumns.put("f_h_rlane_cd", getFHRlaneCd());
		this.hashColumns.put("f_strchkprd", getFStrchkprd());
		this.hashColumns.put("f_to_ecc", getFToEcc());
		this.hashColumns.put("f_smon", getFSmon());
		this.hashColumns.put("f_tar_mon", getFTarMon());
		this.hashColumns.put("f_coa_cd", getFCoaCd());
		this.hashColumns.put("f_cost_loc_grp_cd", getFCostLocGrpCd());
		this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
		this.hashColumns.put("f_seltrade", getFSeltrade());
		this.hashColumns.put("f_strlane", getFStrlane());
		this.hashColumns.put("f_selioc", getFSelioc());
		this.hashColumns.put("f_ecc", getFEcc());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_dir", getFDir());
		this.hashColumns.put("f_cost_fm_mon", getFCostFmMon());
		this.hashColumns.put("f_calc_term_cd", getFCalcTermCd());
		this.hashColumns.put("f_vsl_cd2", getFVslCd2());
		this.hashColumns.put("f_inout", getFInout());
		this.hashColumns.put("istrade", getIstrade());
		this.hashColumns.put("f_bkg_no_split", getFBkgNoSplit());
		this.hashColumns.put("f_selslane", getFSelslane());
		this.hashColumns.put("f_rev_pod_cd", getFRevPodCd());
		this.hashColumns.put("f_strvessel", getFStrvessel());
		this.hashColumns.put("f_stryear", getFStryear());
		this.hashColumns.put("f_1st", getF1st());
		this.hashColumns.put("f_selcapa", getFSelcapa());
		this.hashColumns.put("f_rd_ind", getFRdInd());
		this.hashColumns.put("f_4th", getF4th());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_svc_trns_prc_cnt_cd", "fSvcTrnsPrcCntCd");
		this.hashFields.put("f_excl_sts", "fExclSts");
		this.hashFields.put("f_taa_no", "fTaaNo");
		this.hashFields.put("f_cbo_rcc", "fCboRcc");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_selclass", "fSelclass");
		this.hashFields.put("f_rcc_cd", "fRccCd");
		this.hashFields.put("f_h_ioc_cd", "fHIocCd");
		this.hashFields.put("f_wtr_term_cd", "fWtrTermCd");
		this.hashFields.put("f_strtrade", "fStrtrade");
		this.hashFields.put("f_cobtrade", "fCobtrade");
		this.hashFields.put("f_savename", "fSavename");
		this.hashFields.put("f_pod_ecc_cd", "fPodEccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_excl_sub", "fExclSub");
		this.hashFields.put("f_strtomonth", "fStrtomonth");
		this.hashFields.put("f_to", "fTo");
		this.hashFields.put("f_bkg_pod_cd", "fBkgPodCd");
		this.hashFields.put("f_bkg_del_cd", "fBkgDelCd");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_selcost", "fSelcost");
		this.hashFields.put("f_rout_no", "fRoutNo");
		this.hashFields.put("f_avg_grp_cd", "fAvgGrpCd");
		this.hashFields.put("f_view_tpsz", "fViewTpsz");
		this.hashFields.put("f_bkg_pol_cd", "fBkgPolCd");
		this.hashFields.put("f_strprcnm", "fStrprcnm");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_strtoweek", "fStrtoweek");
		this.hashFields.put("f_sim", "fSim");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_sim_dt", "fSimDt");
		this.hashFields.put("f_bkg_sts", "fBkgSts");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_bkg_por_cd", "fBkgPorCd");
		this.hashFields.put("f_ioc_cd", "fIocCd");
		this.hashFields.put("f_strvoyage", "fStrvoyage");
		this.hashFields.put("f_eweek", "fEweek");
		this.hashFields.put("f_ecc_cd", "fEccCd");
		this.hashFields.put("f_strfmmonth", "fStrfmmonth");
		this.hashFields.put("f_selvessel", "fSelvessel");
		this.hashFields.put("f_rev_pol_cd", "fRevPolCd");
		this.hashFields.put("f_dividename", "fDividename");
		this.hashFields.put("f_mty_ecc_cd", "fMtyEccCd");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_type_cd", "fTypeCd");
		this.hashFields.put("f_coblane", "fCoblane");
		this.hashFields.put("f_tml_cd", "fTmlCd");
		this.hashFields.put("f_soc_sts", "fSocSts");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("f_sdate", "fSdate");
		this.hashFields.put("f_from_ecc", "fFromEcc");
		this.hashFields.put("f_cust_seq", "fCustSeq");
		this.hashFields.put("f_cbotrade", "fCbotrade");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("f_emon", "fEmon");
		this.hashFields.put("f_pro_vw", "fProVw");
		this.hashFields.put("f_src_mon", "fSrcMon");
		this.hashFields.put("f_yearmonth", "fYearmonth");
		this.hashFields.put("f_to_ecc_cd", "fToEccCd");
		this.hashFields.put("f_ori_dest", "fOriDest");
		this.hashFields.put("f_shpr_cd", "fShprCd");
		this.hashFields.put("f_shpr", "fShpr");
		this.hashFields.put("f_group", "fGroup");
		this.hashFields.put("f_vessel", "fVessel");
		this.hashFields.put("f_bkg_no", "fBkgNo");
		this.hashFields.put("f_from_ecc_cd", "fFromEccCd");
		this.hashFields.put("f_comm_loc_cd", "fCommLocCd");
		this.hashFields.put("f_cost_yr", "fCostYr");
		this.hashFields.put("f_rfa", "fRfa");
		this.hashFields.put("f_por", "fPor");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("f_cust_cnt_cd", "fCustCntCd");
		this.hashFields.put("f_pro_lvl", "fProLvl");
		this.hashFields.put("f_sub_trd_cd", "fSubTrdCd");
		this.hashFields.put("f_lcc_cd", "fLccCd");
		this.hashFields.put("f_h_trd_cd", "fHTrdCd");
		this.hashFields.put("f_shipper", "fShipper");
		this.hashFields.put("f_rfa_no", "fRfaNo");
		this.hashFields.put("f_pod", "fPod");
		this.hashFields.put("f_sim_no", "fSimNo");
		this.hashFields.put("f_yearweek", "fYearweek");
		this.hashFields.put("f_cobioc", "fCobioc");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_yrtype", "fYrtype");
		this.hashFields.put("f_usa_bkg_mod_cd", "fUsaBkgModCd");
		this.hashFields.put("f_op_lane_tp_cd", "fOpLaneTpCd");
		this.hashFields.put("f_3td", "f3td");
		this.hashFields.put("f_ofc_act_cd", "fOfcActCd");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("f_full_mty_cd", "fFullMtyCd");
		this.hashFields.put("f_key_acct_indvl_cd", "fKeyAcctIndvlCd");
		this.hashFields.put("f_loc_cd", "fLocCd");
		this.hashFields.put("f_wk_sts", "fWkSts");
		this.hashFields.put("f_selrlane", "fSelrlane");
		this.hashFields.put("f_strtype", "fStrtype");
		this.hashFields.put("f_rev_yrmon", "fRevYrmon");
		this.hashFields.put("f_cmdt_cd", "fCmdtCd");
		this.hashFields.put("f_cobdir", "fCobdir");
		this.hashFields.put("f_mty_lcc_cd", "fMtyLccCd");
		this.hashFields.put("f_op_view", "fOpView");
		this.hashFields.put("f_crr_cd", "fCrrCd");
		this.hashFields.put("f_selgroup", "fSelgroup");
		this.hashFields.put("f_2nd", "f2nd");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_sweek", "fSweek");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_header", "fHeader");
		this.hashFields.put("f_cobcost", "fCobcost");
		this.hashFields.put("f_ofc_vw", "fOfcVw");
		this.hashFields.put("f_spcl_cgo_awk_flg", "fSpclCgoAwkFlg");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("f_sc_no", "fScNo");
		this.hashFields.put("f_dir_sts", "fDirSts");
		this.hashFields.put("f_wk_cd", "fWkCd");
		this.hashFields.put("f_key_acct_group_cd", "fKeyAcctGroupCd");
		this.hashFields.put("f_headernm", "fHeadernm");
		this.hashFields.put("f_spcl_cgo_dg_flg", "fSpclCgoDgFlg");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_loc", "fLoc");
		this.hashFields.put("f_h_dir_cd", "fHDirCd");
		this.hashFields.put("f_cboslane", "fCboslane");
		this.hashFields.put("f_pctl_no", "fPctlNo");
		this.hashFields.put("f_spcl_cgo_rf_flg", "fSpclCgoRfFlg");
		this.hashFields.put("f_strdir", "fStrdir");
		this.hashFields.put("f_cbo_ecc", "fCboEcc");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("f_chkprevcre", "fChkprevcre");
		this.hashFields.put("f_strfmweek", "fStrfmweek");
		this.hashFields.put("f_spcl_cgo_bb_flg", "fSpclCgoBbFlg");
		this.hashFields.put("f_slan_cd", "fSlanCd");
		this.hashFields.put("f_from", "fFrom");
		this.hashFields.put("f_ecc_cd2", "fEccCd2");
		this.hashFields.put("f_chk_bsazrflg", "fChkBsazrflg");
		this.hashFields.put("f_act_grp_cd", "fActGrpCd");
		this.hashFields.put("f_bkg_disp", "fBkgDisp");
		this.hashFields.put("f_voyage", "fVoyage");
		this.hashFields.put("f_seldir", "fSeldir");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_mty_rcc_cd", "fMtyRccCd");
		this.hashFields.put("f_chkdel", "fChkdel");
		this.hashFields.put("f_x_lev", "fXLev");
		this.hashFields.put("f_sls_ofc_cd", "fSlsOfcCd");
		this.hashFields.put("f_locl_curr_cd", "fLoclCurrCd");
		this.hashFields.put("f_cbo_lcc", "fCboLcc");
		this.hashFields.put("f_avg_suvgrp", "fAvgSuvgrp");
		this.hashFields.put("f_h_rlane_cd", "fHRlaneCd");
		this.hashFields.put("f_strchkprd", "fStrchkprd");
		this.hashFields.put("f_to_ecc", "fToEcc");
		this.hashFields.put("f_smon", "fSmon");
		this.hashFields.put("f_tar_mon", "fTarMon");
		this.hashFields.put("f_coa_cd", "fCoaCd");
		this.hashFields.put("f_cost_loc_grp_cd", "fCostLocGrpCd");
		this.hashFields.put("f_cost_yrmon", "fCostYrmon");
		this.hashFields.put("f_seltrade", "fSeltrade");
		this.hashFields.put("f_strlane", "fStrlane");
		this.hashFields.put("f_selioc", "fSelioc");
		this.hashFields.put("f_ecc", "fEcc");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_dir", "fDir");
		this.hashFields.put("f_cost_fm_mon", "fCostFmMon");
		this.hashFields.put("f_calc_term_cd", "fCalcTermCd");
		this.hashFields.put("f_vsl_cd2", "fVslCd2");
		this.hashFields.put("f_inout", "fInout");
		this.hashFields.put("istrade", "istrade");
		this.hashFields.put("f_bkg_no_split", "fBkgNoSplit");
		this.hashFields.put("f_selslane", "fSelslane");
		this.hashFields.put("f_rev_pod_cd", "fRevPodCd");
		this.hashFields.put("f_strvessel", "fStrvessel");
		this.hashFields.put("f_stryear", "fStryear");
		this.hashFields.put("f_1st", "f1st");
		this.hashFields.put("f_selcapa", "fSelcapa");
		this.hashFields.put("f_rd_ind", "fRdInd");
		this.hashFields.put("f_4th", "f4th");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fSvcTrnsPrcCntCd
	 */
	public String getFSvcTrnsPrcCntCd() {
		return this.fSvcTrnsPrcCntCd;
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
	 * @return fTaaNo
	 */
	public String getFTaaNo() {
		return this.fTaaNo;
	}
	
	/**
	 * Column Info
	 * @return fCboRcc
	 */
	public String getFCboRcc() {
		return this.fCboRcc;
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
	 * @return fSelclass
	 */
	public String getFSelclass() {
		return this.fSelclass;
	}
	
	/**
	 * Column Info
	 * @return fRccCd
	 */
	public String getFRccCd() {
		return this.fRccCd;
	}
	
	/**
	 * Column Info
	 * @return fHIocCd
	 */
	public String getFHIocCd() {
		return this.fHIocCd;
	}
	
	/**
	 * Column Info
	 * @return fWtrTermCd
	 */
	public String getFWtrTermCd() {
		return this.fWtrTermCd;
	}
	
	/**
	 * Column Info
	 * @return fStrtrade
	 */
	public String getFStrtrade() {
		return this.fStrtrade;
	}
	
	/**
	 * Column Info
	 * @return fCobtrade
	 */
	public String getFCobtrade() {
		return this.fCobtrade;
	}
	
	/**
	 * Column Info
	 * @return fSavename
	 */
	public String getFSavename() {
		return this.fSavename;
	}
	
	/**
	 * Column Info
	 * @return fPodEccCd
	 */
	public String getFPodEccCd() {
		return this.fPodEccCd;
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
	 * @return fExclSub
	 */
	public String getFExclSub() {
		return this.fExclSub;
	}
	
	/**
	 * Column Info
	 * @return fStrtomonth
	 */
	public String getFStrtomonth() {
		return this.fStrtomonth;
	}
	
	/**
	 * Column Info
	 * @return fTo
	 */
	public String getFTo() {
		return this.fTo;
	}
	
	/**
	 * Column Info
	 * @return fBkgPodCd
	 */
	public String getFBkgPodCd() {
		return this.fBkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgDelCd
	 */
	public String getFBkgDelCd() {
		return this.fBkgDelCd;
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
	 * @return fSelcost
	 */
	public String getFSelcost() {
		return this.fSelcost;
	}
	
	/**
	 * Column Info
	 * @return fRoutNo
	 */
	public String getFRoutNo() {
		return this.fRoutNo;
	}
	
	/**
	 * Column Info
	 * @return fAvgGrpCd
	 */
	public String getFAvgGrpCd() {
		return this.fAvgGrpCd;
	}
	
	/**
	 * Column Info
	 * @return fViewTpsz
	 */
	public String getFViewTpsz() {
		return this.fViewTpsz;
	}
	
	/**
	 * Column Info
	 * @return fBkgPolCd
	 */
	public String getFBkgPolCd() {
		return this.fBkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return fStrprcnm
	 */
	public String getFStrprcnm() {
		return this.fStrprcnm;
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
	 * @return fStrtoweek
	 */
	public String getFStrtoweek() {
		return this.fStrtoweek;
	}
	
	/**
	 * Column Info
	 * @return fSim
	 */
	public String getFSim() {
		return this.fSim;
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
	 * @return fSimDt
	 */
	public String getFSimDt() {
		return this.fSimDt;
	}
	
	/**
	 * Column Info
	 * @return fBkgSts
	 */
	public String getFBkgSts() {
		return this.fBkgSts;
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
	 * @return fBkgPorCd
	 */
	public String getFBkgPorCd() {
		return this.fBkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return fIocCd
	 */
	public String getFIocCd() {
		return this.fIocCd;
	}
	
	/**
	 * Column Info
	 * @return fStrvoyage
	 */
	public String getFStrvoyage() {
		return this.fStrvoyage;
	}
	
	/**
	 * Column Info
	 * @return fEweek
	 */
	public String getFEweek() {
		return this.fEweek;
	}
	
	/**
	 * Column Info
	 * @return fEccCd
	 */
	public String getFEccCd() {
		return this.fEccCd;
	}
	
	/**
	 * Column Info
	 * @return fStrfmmonth
	 */
	public String getFStrfmmonth() {
		return this.fStrfmmonth;
	}
	
	/**
	 * Column Info
	 * @return fSelvessel
	 */
	public String getFSelvessel() {
		return this.fSelvessel;
	}
	
	/**
	 * Column Info
	 * @return fRevPolCd
	 */
	public String getFRevPolCd() {
		return this.fRevPolCd;
	}
	
	/**
	 * Column Info
	 * @return fDividename
	 */
	public String getFDividename() {
		return this.fDividename;
	}
	
	/**
	 * Column Info
	 * @return fMtyEccCd
	 */
	public String getFMtyEccCd() {
		return this.fMtyEccCd;
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
	 * @return fTypeCd
	 */
	public String getFTypeCd() {
		return this.fTypeCd;
	}
	
	/**
	 * Column Info
	 * @return fCoblane
	 */
	public String getFCoblane() {
		return this.fCoblane;
	}
	
	/**
	 * Column Info
	 * @return fTmlCd
	 */
	public String getFTmlCd() {
		return this.fTmlCd;
	}
	
	/**
	 * Column Info
	 * @return fSocSts
	 */
	public String getFSocSts() {
		return this.fSocSts;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fSdate
	 */
	public String getFSdate() {
		return this.fSdate;
	}
	
	/**
	 * Column Info
	 * @return fFromEcc
	 */
	public String getFFromEcc() {
		return this.fFromEcc;
	}
	
	/**
	 * Column Info
	 * @return fCustSeq
	 */
	public String getFCustSeq() {
		return this.fCustSeq;
	}
	
	/**
	 * Column Info
	 * @return fCbotrade
	 */
	public String getFCbotrade() {
		return this.fCbotrade;
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
	 * @return fEmon
	 */
	public String getFEmon() {
		return this.fEmon;
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
	 * @return fSrcMon
	 */
	public String getFSrcMon() {
		return this.fSrcMon;
	}
	
	/**
	 * Column Info
	 * @return fYearmonth
	 */
	public String getFYearmonth() {
		return this.fYearmonth;
	}
	
	/**
	 * Column Info
	 * @return fToEccCd
	 */
	public String getFToEccCd() {
		return this.fToEccCd;
	}
	
	/**
	 * Column Info
	 * @return fOriDest
	 */
	public String getFOriDest() {
		return this.fOriDest;
	}
	
	/**
	 * Column Info
	 * @return fShprCd
	 */
	public String getFShprCd() {
		return this.fShprCd;
	}
	
	/**
	 * Column Info
	 * @return fShpr
	 */
	public String getFShpr() {
		return this.fShpr;
	}
	
	/**
	 * Column Info
	 * @return fGroup
	 */
	public String getFGroup() {
		return this.fGroup;
	}
	
	/**
	 * Column Info
	 * @return fVessel
	 */
	public String getFVessel() {
		return this.fVessel;
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
	 * @return fFromEccCd
	 */
	public String getFFromEccCd() {
		return this.fFromEccCd;
	}
	
	/**
	 * Column Info
	 * @return fCommLocCd
	 */
	public String getFCommLocCd() {
		return this.fCommLocCd;
	}
	
	/**
	 * Column Info
	 * @return fCostYr
	 */
	public String getFCostYr() {
		return this.fCostYr;
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
	 * @return fCustCntCd
	 */
	public String getFCustCntCd() {
		return this.fCustCntCd;
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
	 * @return fSubTrdCd
	 */
	public String getFSubTrdCd() {
		return this.fSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fLccCd
	 */
	public String getFLccCd() {
		return this.fLccCd;
	}
	
	/**
	 * Column Info
	 * @return fHTrdCd
	 */
	public String getFHTrdCd() {
		return this.fHTrdCd;
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
	 * @return fRfaNo
	 */
	public String getFRfaNo() {
		return this.fRfaNo;
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
	 * @return fSimNo
	 */
	public String getFSimNo() {
		return this.fSimNo;
	}
	
	/**
	 * Column Info
	 * @return fYearweek
	 */
	public String getFYearweek() {
		return this.fYearweek;
	}
	
	/**
	 * Column Info
	 * @return fCobioc
	 */
	public String getFCobioc() {
		return this.fCobioc;
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
	 * @return fYrtype
	 */
	public String getFYrtype() {
		return this.fYrtype;
	}
	
	/**
	 * Column Info
	 * @return fUsaBkgModCd
	 */
	public String getFUsaBkgModCd() {
		return this.fUsaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @return fOpLaneTpCd
	 */
	public String getFOpLaneTpCd() {
		return this.fOpLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return f3td
	 */
	public String getF3td() {
		return this.f3td;
	}
	
	/**
	 * Column Info
	 * @return fOfcActCd
	 */
	public String getFOfcActCd() {
		return this.fOfcActCd;
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
	 * @return fFullMtyCd
	 */
	public String getFFullMtyCd() {
		return this.fFullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return fKeyAcctIndvlCd
	 */
	public String getFKeyAcctIndvlCd() {
		return this.fKeyAcctIndvlCd;
	}
	
	/**
	 * Column Info
	 * @return fLocCd
	 */
	public String getFLocCd() {
		return this.fLocCd;
	}
	
	/**
	 * Column Info
	 * @return fWkSts
	 */
	public String getFWkSts() {
		return this.fWkSts;
	}
	
	/**
	 * Column Info
	 * @return fSelrlane
	 */
	public String getFSelrlane() {
		return this.fSelrlane;
	}
	
	/**
	 * Column Info
	 * @return fStrtype
	 */
	public String getFStrtype() {
		return this.fStrtype;
	}
	
	/**
	 * Column Info
	 * @return fRevYrmon
	 */
	public String getFRevYrmon() {
		return this.fRevYrmon;
	}
	
	/**
	 * Column Info
	 * @return fCmdtCd
	 */
	public String getFCmdtCd() {
		return this.fCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return fCobdir
	 */
	public String getFCobdir() {
		return this.fCobdir;
	}
	
	/**
	 * Column Info
	 * @return fMtyLccCd
	 */
	public String getFMtyLccCd() {
		return this.fMtyLccCd;
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
	 * @return fCrrCd
	 */
	public String getFCrrCd() {
		return this.fCrrCd;
	}
	
	/**
	 * Column Info
	 * @return fSelgroup
	 */
	public String getFSelgroup() {
		return this.fSelgroup;
	}
	
	/**
	 * Column Info
	 * @return f2nd
	 */
	public String getF2nd() {
		return this.f2nd;
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
	 * @return fSweek
	 */
	public String getFSweek() {
		return this.fSweek;
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
	 * @return fHeader
	 */
	public String getFHeader() {
		return this.fHeader;
	}
	
	/**
	 * Column Info
	 * @return fCobcost
	 */
	public String getFCobcost() {
		return this.fCobcost;
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
	 * @return fSpclCgoAwkFlg
	 */
	public String getFSpclCgoAwkFlg() {
		return this.fSpclCgoAwkFlg;
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
	 * @return fScNo
	 */
	public String getFScNo() {
		return this.fScNo;
	}
	
	/**
	 * Column Info
	 * @return fDirSts
	 */
	public String getFDirSts() {
		return this.fDirSts;
	}
	
	/**
	 * Column Info
	 * @return fWkCd
	 */
	public String getFWkCd() {
		return this.fWkCd;
	}
	
	/**
	 * Column Info
	 * @return fKeyAcctGroupCd
	 */
	public String getFKeyAcctGroupCd() {
		return this.fKeyAcctGroupCd;
	}
	
	/**
	 * Column Info
	 * @return fHeadernm
	 */
	public String getFHeadernm() {
		return this.fHeadernm;
	}
	
	/**
	 * Column Info
	 * @return fSpclCgoDgFlg
	 */
	public String getFSpclCgoDgFlg() {
		return this.fSpclCgoDgFlg;
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
	 * @return fLoc
	 */
	public String getFLoc() {
		return this.fLoc;
	}
	
	/**
	 * Column Info
	 * @return fHDirCd
	 */
	public String getFHDirCd() {
		return this.fHDirCd;
	}
	
	/**
	 * Column Info
	 * @return fCboslane
	 */
	public String getFCboslane() {
		return this.fCboslane;
	}
	
	/**
	 * Column Info
	 * @return fPctlNo
	 */
	public String getFPctlNo() {
		return this.fPctlNo;
	}
	
	/**
	 * Column Info
	 * @return fSpclCgoRfFlg
	 */
	public String getFSpclCgoRfFlg() {
		return this.fSpclCgoRfFlg;
	}
	
	/**
	 * Column Info
	 * @return fStrdir
	 */
	public String getFStrdir() {
		return this.fStrdir;
	}
	
	/**
	 * Column Info
	 * @return fCboEcc
	 */
	public String getFCboEcc() {
		return this.fCboEcc;
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
	 * @return fChkprevcre
	 */
	public String getFChkprevcre() {
		return this.fChkprevcre;
	}
	
	/**
	 * Column Info
	 * @return fStrfmweek
	 */
	public String getFStrfmweek() {
		return this.fStrfmweek;
	}
	
	/**
	 * Column Info
	 * @return fSpclCgoBbFlg
	 */
	public String getFSpclCgoBbFlg() {
		return this.fSpclCgoBbFlg;
	}
	
	/**
	 * Column Info
	 * @return fSlanCd
	 */
	public String getFSlanCd() {
		return this.fSlanCd;
	}
	
	/**
	 * Column Info
	 * @return fFrom
	 */
	public String getFFrom() {
		return this.fFrom;
	}
	
	/**
	 * Column Info
	 * @return fEccCd2
	 */
	public String getFEccCd2() {
		return this.fEccCd2;
	}
	
	/**
	 * Column Info
	 * @return fChkBsazrflg
	 */
	public String getFChkBsazrflg() {
		return this.fChkBsazrflg;
	}
	
	/**
	 * Column Info
	 * @return fActGrpCd
	 */
	public String getFActGrpCd() {
		return this.fActGrpCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgDisp
	 */
	public String getFBkgDisp() {
		return this.fBkgDisp;
	}
	
	/**
	 * Column Info
	 * @return fVoyage
	 */
	public String getFVoyage() {
		return this.fVoyage;
	}
	
	/**
	 * Column Info
	 * @return fSeldir
	 */
	public String getFSeldir() {
		return this.fSeldir;
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
	 * @return fMtyRccCd
	 */
	public String getFMtyRccCd() {
		return this.fMtyRccCd;
	}
	
	/**
	 * Column Info
	 * @return fChkdel
	 */
	public String getFChkdel() {
		return this.fChkdel;
	}
	
	/**
	 * Column Info
	 * @return fXLev
	 */
	public String getFXLev() {
		return this.fXLev;
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
	 * @return fLoclCurrCd
	 */
	public String getFLoclCurrCd() {
		return this.fLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fCboLcc
	 */
	public String getFCboLcc() {
		return this.fCboLcc;
	}
	
	/**
	 * Column Info
	 * @return fAvgSuvgrp
	 */
	public String getFAvgSuvgrp() {
		return this.fAvgSuvgrp;
	}
	
	/**
	 * Column Info
	 * @return fHRlaneCd
	 */
	public String getFHRlaneCd() {
		return this.fHRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fStrchkprd
	 */
	public String getFStrchkprd() {
		return this.fStrchkprd;
	}
	
	/**
	 * Column Info
	 * @return fToEcc
	 */
	public String getFToEcc() {
		return this.fToEcc;
	}
	
	/**
	 * Column Info
	 * @return fSmon
	 */
	public String getFSmon() {
		return this.fSmon;
	}
	
	/**
	 * Column Info
	 * @return fTarMon
	 */
	public String getFTarMon() {
		return this.fTarMon;
	}
	
	/**
	 * Column Info
	 * @return fCoaCd
	 */
	public String getFCoaCd() {
		return this.fCoaCd;
	}
	
	/**
	 * Column Info
	 * @return fCostLocGrpCd
	 */
	public String getFCostLocGrpCd() {
		return this.fCostLocGrpCd;
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
	 * @return fSeltrade
	 */
	public String getFSeltrade() {
		return this.fSeltrade;
	}
	
	/**
	 * Column Info
	 * @return fStrlane
	 */
	public String getFStrlane() {
		return this.fStrlane;
	}
	
	/**
	 * Column Info
	 * @return fSelioc
	 */
	public String getFSelioc() {
		return this.fSelioc;
	}
	
	/**
	 * Column Info
	 * @return fEcc
	 */
	public String getFEcc() {
		return this.fEcc;
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
	 * @return fDir
	 */
	public String getFDir() {
		return this.fDir;
	}
	
	/**
	 * Column Info
	 * @return fCostFmMon
	 */
	public String getFCostFmMon() {
		return this.fCostFmMon;
	}
	
	/**
	 * Column Info
	 * @return fCalcTermCd
	 */
	public String getFCalcTermCd() {
		return this.fCalcTermCd;
	}
	
	/**
	 * Column Info
	 * @return fVslCd2
	 */
	public String getFVslCd2() {
		return this.fVslCd2;
	}
	
	/**
	 * Column Info
	 * @return fInout
	 */
	public String getFInout() {
		return this.fInout;
	}
	
	/**
	 * Column Info
	 * @return istrade
	 */
	public String getIstrade() {
		return this.istrade;
	}
	
	/**
	 * Column Info
	 * @return fBkgNoSplit
	 */
	public String getFBkgNoSplit() {
		return this.fBkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return fSelslane
	 */
	public String getFSelslane() {
		return this.fSelslane;
	}
	
	/**
	 * Column Info
	 * @return fRevPodCd
	 */
	public String getFRevPodCd() {
		return this.fRevPodCd;
	}
	
	/**
	 * Column Info
	 * @return fStrvessel
	 */
	public String getFStrvessel() {
		return this.fStrvessel;
	}
	
	/**
	 * Column Info
	 * @return fStryear
	 */
	public String getFStryear() {
		return this.fStryear;
	}
	
	/**
	 * Column Info
	 * @return f1st
	 */
	public String getF1st() {
		return this.f1st;
	}
	
	/**
	 * Column Info
	 * @return fSelcapa
	 */
	public String getFSelcapa() {
		return this.fSelcapa;
	}
	
	/**
	 * Column Info
	 * @return fRdInd
	 */
	public String getFRdInd() {
		return this.fRdInd;
	}
	
	/**
	 * Column Info
	 * @return f4th
	 */
	public String getF4th() {
		return this.f4th;
	}
	

	/**
	 * Column Info
	 * @param fSvcTrnsPrcCntCd
	 */
	public void setFSvcTrnsPrcCntCd(String fSvcTrnsPrcCntCd) {
		this.fSvcTrnsPrcCntCd = fSvcTrnsPrcCntCd;
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
	 * @param fTaaNo
	 */
	public void setFTaaNo(String fTaaNo) {
		this.fTaaNo = fTaaNo;
	}
	
	/**
	 * Column Info
	 * @param fCboRcc
	 */
	public void setFCboRcc(String fCboRcc) {
		this.fCboRcc = fCboRcc;
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
	 * @param fSelclass
	 */
	public void setFSelclass(String fSelclass) {
		this.fSelclass = fSelclass;
	}
	
	/**
	 * Column Info
	 * @param fRccCd
	 */
	public void setFRccCd(String fRccCd) {
		this.fRccCd = fRccCd;
	}
	
	/**
	 * Column Info
	 * @param fHIocCd
	 */
	public void setFHIocCd(String fHIocCd) {
		this.fHIocCd = fHIocCd;
	}
	
	/**
	 * Column Info
	 * @param fWtrTermCd
	 */
	public void setFWtrTermCd(String fWtrTermCd) {
		this.fWtrTermCd = fWtrTermCd;
	}
	
	/**
	 * Column Info
	 * @param fStrtrade
	 */
	public void setFStrtrade(String fStrtrade) {
		this.fStrtrade = fStrtrade;
	}
	
	/**
	 * Column Info
	 * @param fCobtrade
	 */
	public void setFCobtrade(String fCobtrade) {
		this.fCobtrade = fCobtrade;
	}
	
	/**
	 * Column Info
	 * @param fSavename
	 */
	public void setFSavename(String fSavename) {
		this.fSavename = fSavename;
	}
	
	/**
	 * Column Info
	 * @param fPodEccCd
	 */
	public void setFPodEccCd(String fPodEccCd) {
		this.fPodEccCd = fPodEccCd;
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
	 * @param fExclSub
	 */
	public void setFExclSub(String fExclSub) {
		this.fExclSub = fExclSub;
	}
	
	/**
	 * Column Info
	 * @param fStrtomonth
	 */
	public void setFStrtomonth(String fStrtomonth) {
		this.fStrtomonth = fStrtomonth;
	}
	
	/**
	 * Column Info
	 * @param fTo
	 */
	public void setFTo(String fTo) {
		this.fTo = fTo;
	}
	
	/**
	 * Column Info
	 * @param fBkgPodCd
	 */
	public void setFBkgPodCd(String fBkgPodCd) {
		this.fBkgPodCd = fBkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgDelCd
	 */
	public void setFBkgDelCd(String fBkgDelCd) {
		this.fBkgDelCd = fBkgDelCd;
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
	 * @param fSelcost
	 */
	public void setFSelcost(String fSelcost) {
		this.fSelcost = fSelcost;
	}
	
	/**
	 * Column Info
	 * @param fRoutNo
	 */
	public void setFRoutNo(String fRoutNo) {
		this.fRoutNo = fRoutNo;
	}
	
	/**
	 * Column Info
	 * @param fAvgGrpCd
	 */
	public void setFAvgGrpCd(String fAvgGrpCd) {
		this.fAvgGrpCd = fAvgGrpCd;
	}
	
	/**
	 * Column Info
	 * @param fViewTpsz
	 */
	public void setFViewTpsz(String fViewTpsz) {
		this.fViewTpsz = fViewTpsz;
	}
	
	/**
	 * Column Info
	 * @param fBkgPolCd
	 */
	public void setFBkgPolCd(String fBkgPolCd) {
		this.fBkgPolCd = fBkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param fStrprcnm
	 */
	public void setFStrprcnm(String fStrprcnm) {
		this.fStrprcnm = fStrprcnm;
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
	 * @param fStrtoweek
	 */
	public void setFStrtoweek(String fStrtoweek) {
		this.fStrtoweek = fStrtoweek;
	}
	
	/**
	 * Column Info
	 * @param fSim
	 */
	public void setFSim(String fSim) {
		this.fSim = fSim;
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
	 * @param fSimDt
	 */
	public void setFSimDt(String fSimDt) {
		this.fSimDt = fSimDt;
	}
	
	/**
	 * Column Info
	 * @param fBkgSts
	 */
	public void setFBkgSts(String fBkgSts) {
		this.fBkgSts = fBkgSts;
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
	 * @param fBkgPorCd
	 */
	public void setFBkgPorCd(String fBkgPorCd) {
		this.fBkgPorCd = fBkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param fIocCd
	 */
	public void setFIocCd(String fIocCd) {
		this.fIocCd = fIocCd;
	}
	
	/**
	 * Column Info
	 * @param fStrvoyage
	 */
	public void setFStrvoyage(String fStrvoyage) {
		this.fStrvoyage = fStrvoyage;
	}
	
	/**
	 * Column Info
	 * @param fEweek
	 */
	public void setFEweek(String fEweek) {
		this.fEweek = fEweek;
	}
	
	/**
	 * Column Info
	 * @param fEccCd
	 */
	public void setFEccCd(String fEccCd) {
		this.fEccCd = fEccCd;
	}
	
	/**
	 * Column Info
	 * @param fStrfmmonth
	 */
	public void setFStrfmmonth(String fStrfmmonth) {
		this.fStrfmmonth = fStrfmmonth;
	}
	
	/**
	 * Column Info
	 * @param fSelvessel
	 */
	public void setFSelvessel(String fSelvessel) {
		this.fSelvessel = fSelvessel;
	}
	
	/**
	 * Column Info
	 * @param fRevPolCd
	 */
	public void setFRevPolCd(String fRevPolCd) {
		this.fRevPolCd = fRevPolCd;
	}
	
	/**
	 * Column Info
	 * @param fDividename
	 */
	public void setFDividename(String fDividename) {
		this.fDividename = fDividename;
	}
	
	/**
	 * Column Info
	 * @param fMtyEccCd
	 */
	public void setFMtyEccCd(String fMtyEccCd) {
		this.fMtyEccCd = fMtyEccCd;
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
	 * @param fTypeCd
	 */
	public void setFTypeCd(String fTypeCd) {
		this.fTypeCd = fTypeCd;
	}
	
	/**
	 * Column Info
	 * @param fCoblane
	 */
	public void setFCoblane(String fCoblane) {
		this.fCoblane = fCoblane;
	}
	
	/**
	 * Column Info
	 * @param fTmlCd
	 */
	public void setFTmlCd(String fTmlCd) {
		this.fTmlCd = fTmlCd;
	}
	
	/**
	 * Column Info
	 * @param fSocSts
	 */
	public void setFSocSts(String fSocSts) {
		this.fSocSts = fSocSts;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fSdate
	 */
	public void setFSdate(String fSdate) {
		this.fSdate = fSdate;
	}
	
	/**
	 * Column Info
	 * @param fFromEcc
	 */
	public void setFFromEcc(String fFromEcc) {
		this.fFromEcc = fFromEcc;
	}
	
	/**
	 * Column Info
	 * @param fCustSeq
	 */
	public void setFCustSeq(String fCustSeq) {
		this.fCustSeq = fCustSeq;
	}
	
	/**
	 * Column Info
	 * @param fCbotrade
	 */
	public void setFCbotrade(String fCbotrade) {
		this.fCbotrade = fCbotrade;
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
	 * @param fEmon
	 */
	public void setFEmon(String fEmon) {
		this.fEmon = fEmon;
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
	 * @param fSrcMon
	 */
	public void setFSrcMon(String fSrcMon) {
		this.fSrcMon = fSrcMon;
	}
	
	/**
	 * Column Info
	 * @param fYearmonth
	 */
	public void setFYearmonth(String fYearmonth) {
		this.fYearmonth = fYearmonth;
	}
	
	/**
	 * Column Info
	 * @param fToEccCd
	 */
	public void setFToEccCd(String fToEccCd) {
		this.fToEccCd = fToEccCd;
	}
	
	/**
	 * Column Info
	 * @param fOriDest
	 */
	public void setFOriDest(String fOriDest) {
		this.fOriDest = fOriDest;
	}
	
	/**
	 * Column Info
	 * @param fShprCd
	 */
	public void setFShprCd(String fShprCd) {
		this.fShprCd = fShprCd;
	}
	
	/**
	 * Column Info
	 * @param fShpr
	 */
	public void setFShpr(String fShpr) {
		this.fShpr = fShpr;
	}
	
	/**
	 * Column Info
	 * @param fGroup
	 */
	public void setFGroup(String fGroup) {
		this.fGroup = fGroup;
	}
	
	/**
	 * Column Info
	 * @param fVessel
	 */
	public void setFVessel(String fVessel) {
		this.fVessel = fVessel;
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
	 * @param fFromEccCd
	 */
	public void setFFromEccCd(String fFromEccCd) {
		this.fFromEccCd = fFromEccCd;
	}
	
	/**
	 * Column Info
	 * @param fCommLocCd
	 */
	public void setFCommLocCd(String fCommLocCd) {
		this.fCommLocCd = fCommLocCd;
	}
	
	/**
	 * Column Info
	 * @param fCostYr
	 */
	public void setFCostYr(String fCostYr) {
		this.fCostYr = fCostYr;
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
	 * @param fCustCntCd
	 */
	public void setFCustCntCd(String fCustCntCd) {
		this.fCustCntCd = fCustCntCd;
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
	 * @param fSubTrdCd
	 */
	public void setFSubTrdCd(String fSubTrdCd) {
		this.fSubTrdCd = fSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fLccCd
	 */
	public void setFLccCd(String fLccCd) {
		this.fLccCd = fLccCd;
	}
	
	/**
	 * Column Info
	 * @param fHTrdCd
	 */
	public void setFHTrdCd(String fHTrdCd) {
		this.fHTrdCd = fHTrdCd;
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
	 * @param fRfaNo
	 */
	public void setFRfaNo(String fRfaNo) {
		this.fRfaNo = fRfaNo;
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
	 * @param fSimNo
	 */
	public void setFSimNo(String fSimNo) {
		this.fSimNo = fSimNo;
	}
	
	/**
	 * Column Info
	 * @param fYearweek
	 */
	public void setFYearweek(String fYearweek) {
		this.fYearweek = fYearweek;
	}
	
	/**
	 * Column Info
	 * @param fCobioc
	 */
	public void setFCobioc(String fCobioc) {
		this.fCobioc = fCobioc;
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
	 * @param fYrtype
	 */
	public void setFYrtype(String fYrtype) {
		this.fYrtype = fYrtype;
	}
	
	/**
	 * Column Info
	 * @param fUsaBkgModCd
	 */
	public void setFUsaBkgModCd(String fUsaBkgModCd) {
		this.fUsaBkgModCd = fUsaBkgModCd;
	}
	
	/**
	 * Column Info
	 * @param fOpLaneTpCd
	 */
	public void setFOpLaneTpCd(String fOpLaneTpCd) {
		this.fOpLaneTpCd = fOpLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param f3td
	 */
	public void setF3td(String f3td) {
		this.f3td = f3td;
	}
	
	/**
	 * Column Info
	 * @param fOfcActCd
	 */
	public void setFOfcActCd(String fOfcActCd) {
		this.fOfcActCd = fOfcActCd;
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
	 * @param fFullMtyCd
	 */
	public void setFFullMtyCd(String fFullMtyCd) {
		this.fFullMtyCd = fFullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param fKeyAcctIndvlCd
	 */
	public void setFKeyAcctIndvlCd(String fKeyAcctIndvlCd) {
		this.fKeyAcctIndvlCd = fKeyAcctIndvlCd;
	}
	
	/**
	 * Column Info
	 * @param fLocCd
	 */
	public void setFLocCd(String fLocCd) {
		this.fLocCd = fLocCd;
	}
	
	/**
	 * Column Info
	 * @param fWkSts
	 */
	public void setFWkSts(String fWkSts) {
		this.fWkSts = fWkSts;
	}
	
	/**
	 * Column Info
	 * @param fSelrlane
	 */
	public void setFSelrlane(String fSelrlane) {
		this.fSelrlane = fSelrlane;
	}
	
	/**
	 * Column Info
	 * @param fStrtype
	 */
	public void setFStrtype(String fStrtype) {
		this.fStrtype = fStrtype;
	}
	
	/**
	 * Column Info
	 * @param fRevYrmon
	 */
	public void setFRevYrmon(String fRevYrmon) {
		this.fRevYrmon = fRevYrmon;
	}
	
	/**
	 * Column Info
	 * @param fCmdtCd
	 */
	public void setFCmdtCd(String fCmdtCd) {
		this.fCmdtCd = fCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param fCobdir
	 */
	public void setFCobdir(String fCobdir) {
		this.fCobdir = fCobdir;
	}
	
	/**
	 * Column Info
	 * @param fMtyLccCd
	 */
	public void setFMtyLccCd(String fMtyLccCd) {
		this.fMtyLccCd = fMtyLccCd;
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
	 * @param fCrrCd
	 */
	public void setFCrrCd(String fCrrCd) {
		this.fCrrCd = fCrrCd;
	}
	
	/**
	 * Column Info
	 * @param fSelgroup
	 */
	public void setFSelgroup(String fSelgroup) {
		this.fSelgroup = fSelgroup;
	}
	
	/**
	 * Column Info
	 * @param f2nd
	 */
	public void setF2nd(String f2nd) {
		this.f2nd = f2nd;
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
	 * @param fSweek
	 */
	public void setFSweek(String fSweek) {
		this.fSweek = fSweek;
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
	 * @param fHeader
	 */
	public void setFHeader(String fHeader) {
		this.fHeader = fHeader;
	}
	
	/**
	 * Column Info
	 * @param fCobcost
	 */
	public void setFCobcost(String fCobcost) {
		this.fCobcost = fCobcost;
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
	 * @param fSpclCgoAwkFlg
	 */
	public void setFSpclCgoAwkFlg(String fSpclCgoAwkFlg) {
		this.fSpclCgoAwkFlg = fSpclCgoAwkFlg;
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
	 * @param fScNo
	 */
	public void setFScNo(String fScNo) {
		this.fScNo = fScNo;
	}
	
	/**
	 * Column Info
	 * @param fDirSts
	 */
	public void setFDirSts(String fDirSts) {
		this.fDirSts = fDirSts;
	}
	
	/**
	 * Column Info
	 * @param fWkCd
	 */
	public void setFWkCd(String fWkCd) {
		this.fWkCd = fWkCd;
	}
	
	/**
	 * Column Info
	 * @param fKeyAcctGroupCd
	 */
	public void setFKeyAcctGroupCd(String fKeyAcctGroupCd) {
		this.fKeyAcctGroupCd = fKeyAcctGroupCd;
	}
	
	/**
	 * Column Info
	 * @param fHeadernm
	 */
	public void setFHeadernm(String fHeadernm) {
		this.fHeadernm = fHeadernm;
	}
	
	/**
	 * Column Info
	 * @param fSpclCgoDgFlg
	 */
	public void setFSpclCgoDgFlg(String fSpclCgoDgFlg) {
		this.fSpclCgoDgFlg = fSpclCgoDgFlg;
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
	 * @param fLoc
	 */
	public void setFLoc(String fLoc) {
		this.fLoc = fLoc;
	}
	
	/**
	 * Column Info
	 * @param fHDirCd
	 */
	public void setFHDirCd(String fHDirCd) {
		this.fHDirCd = fHDirCd;
	}
	
	/**
	 * Column Info
	 * @param fCboslane
	 */
	public void setFCboslane(String fCboslane) {
		this.fCboslane = fCboslane;
	}
	
	/**
	 * Column Info
	 * @param fPctlNo
	 */
	public void setFPctlNo(String fPctlNo) {
		this.fPctlNo = fPctlNo;
	}
	
	/**
	 * Column Info
	 * @param fSpclCgoRfFlg
	 */
	public void setFSpclCgoRfFlg(String fSpclCgoRfFlg) {
		this.fSpclCgoRfFlg = fSpclCgoRfFlg;
	}
	
	/**
	 * Column Info
	 * @param fStrdir
	 */
	public void setFStrdir(String fStrdir) {
		this.fStrdir = fStrdir;
	}
	
	/**
	 * Column Info
	 * @param fCboEcc
	 */
	public void setFCboEcc(String fCboEcc) {
		this.fCboEcc = fCboEcc;
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
	 * @param fChkprevcre
	 */
	public void setFChkprevcre(String fChkprevcre) {
		this.fChkprevcre = fChkprevcre;
	}
	
	/**
	 * Column Info
	 * @param fStrfmweek
	 */
	public void setFStrfmweek(String fStrfmweek) {
		this.fStrfmweek = fStrfmweek;
	}
	
	/**
	 * Column Info
	 * @param fSpclCgoBbFlg
	 */
	public void setFSpclCgoBbFlg(String fSpclCgoBbFlg) {
		this.fSpclCgoBbFlg = fSpclCgoBbFlg;
	}
	
	/**
	 * Column Info
	 * @param fSlanCd
	 */
	public void setFSlanCd(String fSlanCd) {
		this.fSlanCd = fSlanCd;
	}
	
	/**
	 * Column Info
	 * @param fFrom
	 */
	public void setFFrom(String fFrom) {
		this.fFrom = fFrom;
	}
	
	/**
	 * Column Info
	 * @param fEccCd2
	 */
	public void setFEccCd2(String fEccCd2) {
		this.fEccCd2 = fEccCd2;
	}
	
	/**
	 * Column Info
	 * @param fChkBsazrflg
	 */
	public void setFChkBsazrflg(String fChkBsazrflg) {
		this.fChkBsazrflg = fChkBsazrflg;
	}
	
	/**
	 * Column Info
	 * @param fActGrpCd
	 */
	public void setFActGrpCd(String fActGrpCd) {
		this.fActGrpCd = fActGrpCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgDisp
	 */
	public void setFBkgDisp(String fBkgDisp) {
		this.fBkgDisp = fBkgDisp;
	}
	
	/**
	 * Column Info
	 * @param fVoyage
	 */
	public void setFVoyage(String fVoyage) {
		this.fVoyage = fVoyage;
	}
	
	/**
	 * Column Info
	 * @param fSeldir
	 */
	public void setFSeldir(String fSeldir) {
		this.fSeldir = fSeldir;
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
	 * @param fMtyRccCd
	 */
	public void setFMtyRccCd(String fMtyRccCd) {
		this.fMtyRccCd = fMtyRccCd;
	}
	
	/**
	 * Column Info
	 * @param fChkdel
	 */
	public void setFChkdel(String fChkdel) {
		this.fChkdel = fChkdel;
	}
	
	/**
	 * Column Info
	 * @param fXLev
	 */
	public void setFXLev(String fXLev) {
		this.fXLev = fXLev;
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
	 * @param fLoclCurrCd
	 */
	public void setFLoclCurrCd(String fLoclCurrCd) {
		this.fLoclCurrCd = fLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fCboLcc
	 */
	public void setFCboLcc(String fCboLcc) {
		this.fCboLcc = fCboLcc;
	}
	
	/**
	 * Column Info
	 * @param fAvgSuvgrp
	 */
	public void setFAvgSuvgrp(String fAvgSuvgrp) {
		this.fAvgSuvgrp = fAvgSuvgrp;
	}
	
	/**
	 * Column Info
	 * @param fHRlaneCd
	 */
	public void setFHRlaneCd(String fHRlaneCd) {
		this.fHRlaneCd = fHRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fStrchkprd
	 */
	public void setFStrchkprd(String fStrchkprd) {
		this.fStrchkprd = fStrchkprd;
	}
	
	/**
	 * Column Info
	 * @param fToEcc
	 */
	public void setFToEcc(String fToEcc) {
		this.fToEcc = fToEcc;
	}
	
	/**
	 * Column Info
	 * @param fSmon
	 */
	public void setFSmon(String fSmon) {
		this.fSmon = fSmon;
	}
	
	/**
	 * Column Info
	 * @param fTarMon
	 */
	public void setFTarMon(String fTarMon) {
		this.fTarMon = fTarMon;
	}
	
	/**
	 * Column Info
	 * @param fCoaCd
	 */
	public void setFCoaCd(String fCoaCd) {
		this.fCoaCd = fCoaCd;
	}
	
	/**
	 * Column Info
	 * @param fCostLocGrpCd
	 */
	public void setFCostLocGrpCd(String fCostLocGrpCd) {
		this.fCostLocGrpCd = fCostLocGrpCd;
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
	 * @param fSeltrade
	 */
	public void setFSeltrade(String fSeltrade) {
		this.fSeltrade = fSeltrade;
	}
	
	/**
	 * Column Info
	 * @param fStrlane
	 */
	public void setFStrlane(String fStrlane) {
		this.fStrlane = fStrlane;
	}
	
	/**
	 * Column Info
	 * @param fSelioc
	 */
	public void setFSelioc(String fSelioc) {
		this.fSelioc = fSelioc;
	}
	
	/**
	 * Column Info
	 * @param fEcc
	 */
	public void setFEcc(String fEcc) {
		this.fEcc = fEcc;
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
	 * @param fDir
	 */
	public void setFDir(String fDir) {
		this.fDir = fDir;
	}
	
	/**
	 * Column Info
	 * @param fCostFmMon
	 */
	public void setFCostFmMon(String fCostFmMon) {
		this.fCostFmMon = fCostFmMon;
	}
	
	/**
	 * Column Info
	 * @param fCalcTermCd
	 */
	public void setFCalcTermCd(String fCalcTermCd) {
		this.fCalcTermCd = fCalcTermCd;
	}
	
	/**
	 * Column Info
	 * @param fVslCd2
	 */
	public void setFVslCd2(String fVslCd2) {
		this.fVslCd2 = fVslCd2;
	}
	
	/**
	 * Column Info
	 * @param fInout
	 */
	public void setFInout(String fInout) {
		this.fInout = fInout;
	}
	
	/**
	 * Column Info
	 * @param istrade
	 */
	public void setIstrade(String istrade) {
		this.istrade = istrade;
	}
	
	/**
	 * Column Info
	 * @param fBkgNoSplit
	 */
	public void setFBkgNoSplit(String fBkgNoSplit) {
		this.fBkgNoSplit = fBkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param fSelslane
	 */
	public void setFSelslane(String fSelslane) {
		this.fSelslane = fSelslane;
	}
	
	/**
	 * Column Info
	 * @param fRevPodCd
	 */
	public void setFRevPodCd(String fRevPodCd) {
		this.fRevPodCd = fRevPodCd;
	}
	
	/**
	 * Column Info
	 * @param fStrvessel
	 */
	public void setFStrvessel(String fStrvessel) {
		this.fStrvessel = fStrvessel;
	}
	
	/**
	 * Column Info
	 * @param fStryear
	 */
	public void setFStryear(String fStryear) {
		this.fStryear = fStryear;
	}
	
	/**
	 * Column Info
	 * @param f1st
	 */
	public void setF1st(String f1st) {
		this.f1st = f1st;
	}
	
	/**
	 * Column Info
	 * @param fSelcapa
	 */
	public void setFSelcapa(String fSelcapa) {
		this.fSelcapa = fSelcapa;
	}
	
	/**
	 * Column Info
	 * @param fRdInd
	 */
	public void setFRdInd(String fRdInd) {
		this.fRdInd = fRdInd;
	}
	
	/**
	 * Column Info
	 * @param f4th
	 */
	public void setF4th(String f4th) {
		this.f4th = f4th;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFSvcTrnsPrcCntCd(JSPUtil.getParameter(request, "f_svc_trns_prc_cnt_cd", ""));
		setFExclSts(JSPUtil.getParameter(request, "f_excl_sts", ""));
		setFTaaNo(JSPUtil.getParameter(request, "f_taa_no", ""));
		setFCboRcc(JSPUtil.getParameter(request, "f_cbo_rcc", ""));
		setFFmMon(JSPUtil.getParameter(request, "f_fm_mon", ""));
		setFSelclass(JSPUtil.getParameter(request, "f_selclass", ""));
		setFRccCd(JSPUtil.getParameter(request, "f_rcc_cd", ""));
		setFHIocCd(JSPUtil.getParameter(request, "f_h_ioc_cd", ""));
		setFWtrTermCd(JSPUtil.getParameter(request, "f_wtr_term_cd", ""));
		setFStrtrade(JSPUtil.getParameter(request, "f_strtrade", ""));
		setFCobtrade(JSPUtil.getParameter(request, "f_cobtrade", ""));
		setFSavename(JSPUtil.getParameter(request, "f_savename", ""));
		setFPodEccCd(JSPUtil.getParameter(request, "f_pod_ecc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFExclSub(JSPUtil.getParameter(request, "f_excl_sub", ""));
		setFStrtomonth(JSPUtil.getParameter(request, "f_strtomonth", ""));
		setFTo(JSPUtil.getParameter(request, "f_to", ""));
		setFBkgPodCd(JSPUtil.getParameter(request, "f_bkg_pod_cd", ""));
		setFBkgDelCd(JSPUtil.getParameter(request, "f_bkg_del_cd", ""));
		setFVslCd(JSPUtil.getParameter(request, "f_vsl_cd", ""));
		setFSelcost(JSPUtil.getParameter(request, "f_selcost", ""));
		setFRoutNo(JSPUtil.getParameter(request, "f_rout_no", ""));
		setFAvgGrpCd(JSPUtil.getParameter(request, "f_avg_grp_cd", ""));
		setFViewTpsz(JSPUtil.getParameter(request, "f_view_tpsz", ""));
		setFBkgPolCd(JSPUtil.getParameter(request, "f_bkg_pol_cd", ""));
		setFStrprcnm(JSPUtil.getParameter(request, "f_strprcnm", ""));
		setFToMon(JSPUtil.getParameter(request, "f_to_mon", ""));
		setFStrtoweek(JSPUtil.getParameter(request, "f_strtoweek", ""));
		setFSim(JSPUtil.getParameter(request, "f_sim", ""));
		setFTrdCd(JSPUtil.getParameter(request, "f_trd_cd", ""));
		setFSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setFBkgSts(JSPUtil.getParameter(request, "f_bkg_sts", ""));
		setFRlaneCd(JSPUtil.getParameter(request, "f_rlane_cd", ""));
		setFBkgPorCd(JSPUtil.getParameter(request, "f_bkg_por_cd", ""));
		setFIocCd(JSPUtil.getParameter(request, "f_ioc_cd", ""));
		setFStrvoyage(JSPUtil.getParameter(request, "f_strvoyage", ""));
		setFEweek(JSPUtil.getParameter(request, "f_eweek", ""));
		setFEccCd(JSPUtil.getParameter(request, "f_ecc_cd", ""));
		setFStrfmmonth(JSPUtil.getParameter(request, "f_strfmmonth", ""));
		setFSelvessel(JSPUtil.getParameter(request, "f_selvessel", ""));
		setFRevPolCd(JSPUtil.getParameter(request, "f_rev_pol_cd", ""));
		setFDividename(JSPUtil.getParameter(request, "f_dividename", ""));
		setFMtyEccCd(JSPUtil.getParameter(request, "f_mty_ecc_cd", ""));
		setFChkprd(JSPUtil.getParameter(request, "f_chkprd", ""));
		setFTypeCd(JSPUtil.getParameter(request, "f_type_cd", ""));
		setFCoblane(JSPUtil.getParameter(request, "f_coblane", ""));
		setFTmlCd(JSPUtil.getParameter(request, "f_tml_cd", ""));
		setFSocSts(JSPUtil.getParameter(request, "f_soc_sts", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, "f_cntr_tpsz_cd", ""));
		setFSdate(JSPUtil.getParameter(request, "f_sdate", ""));
		setFFromEcc(JSPUtil.getParameter(request, "f_from_ecc", ""));
		setFCustSeq(JSPUtil.getParameter(request, "f_cust_seq", ""));
		setFCbotrade(JSPUtil.getParameter(request, "f_cbotrade", ""));
		setFDel(JSPUtil.getParameter(request, "f_del", ""));
		setFEmon(JSPUtil.getParameter(request, "f_emon", ""));
		setFProVw(JSPUtil.getParameter(request, "f_pro_vw", ""));
		setFSrcMon(JSPUtil.getParameter(request, "f_src_mon", ""));
		setFYearmonth(JSPUtil.getParameter(request, "f_yearmonth", ""));
		setFToEccCd(JSPUtil.getParameter(request, "f_to_ecc_cd", ""));
		setFOriDest(JSPUtil.getParameter(request, "f_ori_dest", ""));
		setFShprCd(JSPUtil.getParameter(request, "f_shpr_cd", ""));
		setFShpr(JSPUtil.getParameter(request, "f_shpr", ""));
		setFGroup(JSPUtil.getParameter(request, "f_group", ""));
		setFVessel(JSPUtil.getParameter(request, "f_vessel", ""));
		setFBkgNo(JSPUtil.getParameter(request, "f_bkg_no", ""));
		setFFromEccCd(JSPUtil.getParameter(request, "f_from_ecc_cd", ""));
		setFCommLocCd(JSPUtil.getParameter(request, "f_comm_loc_cd", ""));
		setFCostYr(JSPUtil.getParameter(request, "f_cost_yr", ""));
		setFRfa(JSPUtil.getParameter(request, "f_rfa", ""));
		setFPor(JSPUtil.getParameter(request, "f_por", ""));
		setFOfcCd(JSPUtil.getParameter(request, "f_ofc_cd", ""));
		setFCustCntCd(JSPUtil.getParameter(request, "f_cust_cnt_cd", ""));
		setFProLvl(JSPUtil.getParameter(request, "f_pro_lvl", ""));
		setFSubTrdCd(JSPUtil.getParameter(request, "f_sub_trd_cd", ""));
		setFLccCd(JSPUtil.getParameter(request, "f_lcc_cd", ""));
		setFHTrdCd(JSPUtil.getParameter(request, "f_h_trd_cd", ""));
		setFShipper(JSPUtil.getParameter(request, "f_shipper", ""));
		setFRfaNo(JSPUtil.getParameter(request, "f_rfa_no", ""));
		setFPod(JSPUtil.getParameter(request, "f_pod", ""));
		setFSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
		setFYearweek(JSPUtil.getParameter(request, "f_yearweek", ""));
		setFCobioc(JSPUtil.getParameter(request, "f_cobioc", ""));
		setFDirCd(JSPUtil.getParameter(request, "f_dir_cd", ""));
		setFYrtype(JSPUtil.getParameter(request, "f_yrtype", ""));
		setFUsaBkgModCd(JSPUtil.getParameter(request, "f_usa_bkg_mod_cd", ""));
		setFOpLaneTpCd(JSPUtil.getParameter(request, "f_op_lane_tp_cd", ""));
		setF3td(JSPUtil.getParameter(request, "f_3td", ""));
		setFOfcActCd(JSPUtil.getParameter(request, "f_ofc_act_cd", ""));
		setFSlsMon(JSPUtil.getParameter(request, "f_sls_mon", ""));
		setFRhqCd(JSPUtil.getParameter(request, "f_rhq_cd", ""));
		setFFullMtyCd(JSPUtil.getParameter(request, "f_full_mty_cd", ""));
		setFKeyAcctIndvlCd(JSPUtil.getParameter(request, "f_key_acct_indvl_cd", ""));
		setFLocCd(JSPUtil.getParameter(request, "f_loc_cd", ""));
		setFWkSts(JSPUtil.getParameter(request, "f_wk_sts", ""));
		setFSelrlane(JSPUtil.getParameter(request, "f_selrlane", ""));
		setFStrtype(JSPUtil.getParameter(request, "f_strtype", ""));
		setFRevYrmon(JSPUtil.getParameter(request, "f_rev_yrmon", ""));
		setFCmdtCd(JSPUtil.getParameter(request, "f_cmdt_cd", ""));
		setFCobdir(JSPUtil.getParameter(request, "f_cobdir", ""));
		setFMtyLccCd(JSPUtil.getParameter(request, "f_mty_lcc_cd", ""));
		setFOpView(JSPUtil.getParameter(request, "f_op_view", ""));
		setFCrrCd(JSPUtil.getParameter(request, "f_crr_cd", ""));
		setFSelgroup(JSPUtil.getParameter(request, "f_selgroup", ""));
		setF2nd(JSPUtil.getParameter(request, "f_2nd", ""));
		setFOfcLvl(JSPUtil.getParameter(request, "f_ofc_lvl", ""));
		setFSweek(JSPUtil.getParameter(request, "f_sweek", ""));
		setFFmWk(JSPUtil.getParameter(request, "f_fm_wk", ""));
		setFHeader(JSPUtil.getParameter(request, "f_header", ""));
		setFCobcost(JSPUtil.getParameter(request, "f_cobcost", ""));
		setFOfcVw(JSPUtil.getParameter(request, "f_ofc_vw", ""));
		setFSpclCgoAwkFlg(JSPUtil.getParameter(request, "f_spcl_cgo_awk_flg", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, "f_skd_voy_no", ""));
		setFScNo(JSPUtil.getParameter(request, "f_sc_no", ""));
		setFDirSts(JSPUtil.getParameter(request, "f_dir_sts", ""));
		setFWkCd(JSPUtil.getParameter(request, "f_wk_cd", ""));
		setFKeyAcctGroupCd(JSPUtil.getParameter(request, "f_key_acct_group_cd", ""));
		setFHeadernm(JSPUtil.getParameter(request, "f_headernm", ""));
		setFSpclCgoDgFlg(JSPUtil.getParameter(request, "f_spcl_cgo_dg_flg", ""));
		setFToWk(JSPUtil.getParameter(request, "f_to_wk", ""));
		setFLoc(JSPUtil.getParameter(request, "f_loc", ""));
		setFHDirCd(JSPUtil.getParameter(request, "f_h_dir_cd", ""));
		setFCboslane(JSPUtil.getParameter(request, "f_cboslane", ""));
		setFPctlNo(JSPUtil.getParameter(request, "f_pctl_no", ""));
		setFSpclCgoRfFlg(JSPUtil.getParameter(request, "f_spcl_cgo_rf_flg", ""));
		setFStrdir(JSPUtil.getParameter(request, "f_strdir", ""));
		setFCboEcc(JSPUtil.getParameter(request, "f_cbo_ecc", ""));
		setFYear(JSPUtil.getParameter(request, "f_year", ""));
		setFChkprevcre(JSPUtil.getParameter(request, "f_chkprevcre", ""));
		setFStrfmweek(JSPUtil.getParameter(request, "f_strfmweek", ""));
		setFSpclCgoBbFlg(JSPUtil.getParameter(request, "f_spcl_cgo_bb_flg", ""));
		setFSlanCd(JSPUtil.getParameter(request, "f_slan_cd", ""));
		setFFrom(JSPUtil.getParameter(request, "f_from", ""));
		setFEccCd2(JSPUtil.getParameter(request, "f_ecc_cd2", ""));
		setFChkBsazrflg(JSPUtil.getParameter(request, "f_chk_bsazrflg", ""));
		setFActGrpCd(JSPUtil.getParameter(request, "f_act_grp_cd", ""));
		setFBkgDisp(JSPUtil.getParameter(request, "f_bkg_disp", ""));
		setFVoyage(JSPUtil.getParameter(request, "f_voyage", ""));
		setFSeldir(JSPUtil.getParameter(request, "f_seldir", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFMtyRccCd(JSPUtil.getParameter(request, "f_mty_rcc_cd", ""));
		setFChkdel(JSPUtil.getParameter(request, "f_chkdel", ""));
		setFXLev(JSPUtil.getParameter(request, "f_x_lev", ""));
		setFSlsOfcCd(JSPUtil.getParameter(request, "f_sls_ofc_cd", ""));
		setFLoclCurrCd(JSPUtil.getParameter(request, "f_locl_curr_cd", ""));
		setFCboLcc(JSPUtil.getParameter(request, "f_cbo_lcc", ""));
		setFAvgSuvgrp(JSPUtil.getParameter(request, "f_avg_suvgrp", ""));
		setFHRlaneCd(JSPUtil.getParameter(request, "f_h_rlane_cd", ""));
		setFStrchkprd(JSPUtil.getParameter(request, "f_strchkprd", ""));
		setFToEcc(JSPUtil.getParameter(request, "f_to_ecc", ""));
		setFSmon(JSPUtil.getParameter(request, "f_smon", ""));
		setFTarMon(JSPUtil.getParameter(request, "f_tar_mon", ""));
		setFCoaCd(JSPUtil.getParameter(request, "f_coa_cd", ""));
		setFCostLocGrpCd(JSPUtil.getParameter(request, "f_cost_loc_grp_cd", ""));
		setFCostYrmon(JSPUtil.getParameter(request, "f_cost_yrmon", ""));
		setFSeltrade(JSPUtil.getParameter(request, "f_seltrade", ""));
		setFStrlane(JSPUtil.getParameter(request, "f_strlane", ""));
		setFSelioc(JSPUtil.getParameter(request, "f_selioc", ""));
		setFEcc(JSPUtil.getParameter(request, "f_ecc", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, "f_skd_dir_cd", ""));
		setFDir(JSPUtil.getParameter(request, "f_dir", ""));
		setFCostFmMon(JSPUtil.getParameter(request, "f_cost_fm_mon", ""));
		setFCalcTermCd(JSPUtil.getParameter(request, "f_calc_term_cd", ""));
		setFVslCd2(JSPUtil.getParameter(request, "f_vsl_cd2", ""));
		setFInout(JSPUtil.getParameter(request, "f_inout", ""));
		setIstrade(JSPUtil.getParameter(request, "istrade", ""));
		setFBkgNoSplit(JSPUtil.getParameter(request, "f_bkg_no_split", ""));
		setFSelslane(JSPUtil.getParameter(request, "f_selslane", ""));
		setFRevPodCd(JSPUtil.getParameter(request, "f_rev_pod_cd", ""));
		setFStrvessel(JSPUtil.getParameter(request, "f_strvessel", ""));
		setFStryear(JSPUtil.getParameter(request, "f_stryear", ""));
		setF1st(JSPUtil.getParameter(request, "f_1st", ""));
		setFSelcapa(JSPUtil.getParameter(request, "f_selcapa", ""));
		setFRdInd(JSPUtil.getParameter(request, "f_rd_ind", ""));
		setF4th(JSPUtil.getParameter(request, "f_4th", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fSvcTrnsPrcCntCd = (JSPUtil.getParameter(request, prefix	+ "f_svc_trns_prc_cnt_cd", length));
			String[] fExclSts = (JSPUtil.getParameter(request, prefix	+ "f_excl_sts", length));
			String[] fTaaNo = (JSPUtil.getParameter(request, prefix	+ "f_taa_no", length));
			String[] fCboRcc = (JSPUtil.getParameter(request, prefix	+ "f_cbo_rcc", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fSelclass = (JSPUtil.getParameter(request, prefix	+ "f_selclass", length));
			String[] fRccCd = (JSPUtil.getParameter(request, prefix	+ "f_rcc_cd", length));
			String[] fHIocCd = (JSPUtil.getParameter(request, prefix	+ "f_h_ioc_cd", length));
			String[] fWtrTermCd = (JSPUtil.getParameter(request, prefix	+ "f_wtr_term_cd", length));
			String[] fStrtrade = (JSPUtil.getParameter(request, prefix	+ "f_strtrade", length));
			String[] fCobtrade = (JSPUtil.getParameter(request, prefix	+ "f_cobtrade", length));
			String[] fSavename = (JSPUtil.getParameter(request, prefix	+ "f_savename", length));
			String[] fPodEccCd = (JSPUtil.getParameter(request, prefix	+ "f_pod_ecc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fExclSub = (JSPUtil.getParameter(request, prefix	+ "f_excl_sub", length));
			String[] fStrtomonth = (JSPUtil.getParameter(request, prefix	+ "f_strtomonth", length));
			String[] fTo = (JSPUtil.getParameter(request, prefix	+ "f_to", length));
			String[] fBkgPodCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_pod_cd", length));
			String[] fBkgDelCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_del_cd", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fSelcost = (JSPUtil.getParameter(request, prefix	+ "f_selcost", length));
			String[] fRoutNo = (JSPUtil.getParameter(request, prefix	+ "f_rout_no", length));
			String[] fAvgGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_avg_grp_cd", length));
			String[] fViewTpsz = (JSPUtil.getParameter(request, prefix	+ "f_view_tpsz", length));
			String[] fBkgPolCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_pol_cd", length));
			String[] fStrprcnm = (JSPUtil.getParameter(request, prefix	+ "f_strprcnm", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fStrtoweek = (JSPUtil.getParameter(request, prefix	+ "f_strtoweek", length));
			String[] fSim = (JSPUtil.getParameter(request, prefix	+ "f_sim", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fSimDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] fBkgSts = (JSPUtil.getParameter(request, prefix	+ "f_bkg_sts", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fBkgPorCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_por_cd", length));
			String[] fIocCd = (JSPUtil.getParameter(request, prefix	+ "f_ioc_cd", length));
			String[] fStrvoyage = (JSPUtil.getParameter(request, prefix	+ "f_strvoyage", length));
			String[] fEweek = (JSPUtil.getParameter(request, prefix	+ "f_eweek", length));
			String[] fEccCd = (JSPUtil.getParameter(request, prefix	+ "f_ecc_cd", length));
			String[] fStrfmmonth = (JSPUtil.getParameter(request, prefix	+ "f_strfmmonth", length));
			String[] fSelvessel = (JSPUtil.getParameter(request, prefix	+ "f_selvessel", length));
			String[] fRevPolCd = (JSPUtil.getParameter(request, prefix	+ "f_rev_pol_cd", length));
			String[] fDividename = (JSPUtil.getParameter(request, prefix	+ "f_dividename", length));
			String[] fMtyEccCd = (JSPUtil.getParameter(request, prefix	+ "f_mty_ecc_cd", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fTypeCd = (JSPUtil.getParameter(request, prefix	+ "f_type_cd", length));
			String[] fCoblane = (JSPUtil.getParameter(request, prefix	+ "f_coblane", length));
			String[] fTmlCd = (JSPUtil.getParameter(request, prefix	+ "f_tml_cd", length));
			String[] fSocSts = (JSPUtil.getParameter(request, prefix	+ "f_soc_sts", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] fSdate = (JSPUtil.getParameter(request, prefix	+ "f_sdate", length));
			String[] fFromEcc = (JSPUtil.getParameter(request, prefix	+ "f_from_ecc", length));
			String[] fCustSeq = (JSPUtil.getParameter(request, prefix	+ "f_cust_seq", length));
			String[] fCbotrade = (JSPUtil.getParameter(request, prefix	+ "f_cbotrade", length));
			String[] fDel = (JSPUtil.getParameter(request, prefix	+ "f_del", length));
			String[] fEmon = (JSPUtil.getParameter(request, prefix	+ "f_emon", length));
			String[] fProVw = (JSPUtil.getParameter(request, prefix	+ "f_pro_vw", length));
			String[] fSrcMon = (JSPUtil.getParameter(request, prefix	+ "f_src_mon", length));
			String[] fYearmonth = (JSPUtil.getParameter(request, prefix	+ "f_yearmonth", length));
			String[] fToEccCd = (JSPUtil.getParameter(request, prefix	+ "f_to_ecc_cd", length));
			String[] fOriDest = (JSPUtil.getParameter(request, prefix	+ "f_ori_dest", length));
			String[] fShprCd = (JSPUtil.getParameter(request, prefix	+ "f_shpr_cd", length));
			String[] fShpr = (JSPUtil.getParameter(request, prefix	+ "f_shpr", length));
			String[] fGroup = (JSPUtil.getParameter(request, prefix	+ "f_group", length));
			String[] fVessel = (JSPUtil.getParameter(request, prefix	+ "f_vessel", length));
			String[] fBkgNo = (JSPUtil.getParameter(request, prefix	+ "f_bkg_no", length));
			String[] fFromEccCd = (JSPUtil.getParameter(request, prefix	+ "f_from_ecc_cd", length));
			String[] fCommLocCd = (JSPUtil.getParameter(request, prefix	+ "f_comm_loc_cd", length));
			String[] fCostYr = (JSPUtil.getParameter(request, prefix	+ "f_cost_yr", length));
			String[] fRfa = (JSPUtil.getParameter(request, prefix	+ "f_rfa", length));
			String[] fPor = (JSPUtil.getParameter(request, prefix	+ "f_por", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] fCustCntCd = (JSPUtil.getParameter(request, prefix	+ "f_cust_cnt_cd", length));
			String[] fProLvl = (JSPUtil.getParameter(request, prefix	+ "f_pro_lvl", length));
			String[] fSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_trd_cd", length));
			String[] fLccCd = (JSPUtil.getParameter(request, prefix	+ "f_lcc_cd", length));
			String[] fHTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_h_trd_cd", length));
			String[] fShipper = (JSPUtil.getParameter(request, prefix	+ "f_shipper", length));
			String[] fRfaNo = (JSPUtil.getParameter(request, prefix	+ "f_rfa_no", length));
			String[] fPod = (JSPUtil.getParameter(request, prefix	+ "f_pod", length));
			String[] fSimNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			String[] fYearweek = (JSPUtil.getParameter(request, prefix	+ "f_yearweek", length));
			String[] fCobioc = (JSPUtil.getParameter(request, prefix	+ "f_cobioc", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fYrtype = (JSPUtil.getParameter(request, prefix	+ "f_yrtype", length));
			String[] fUsaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "f_usa_bkg_mod_cd", length));
			String[] fOpLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "f_op_lane_tp_cd", length));
			String[] f3td = (JSPUtil.getParameter(request, prefix	+ "f_3td", length));
			String[] fOfcActCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_act_cd", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] fFullMtyCd = (JSPUtil.getParameter(request, prefix	+ "f_full_mty_cd", length));
			String[] fKeyAcctIndvlCd = (JSPUtil.getParameter(request, prefix	+ "f_key_acct_indvl_cd", length));
			String[] fLocCd = (JSPUtil.getParameter(request, prefix	+ "f_loc_cd", length));
			String[] fWkSts = (JSPUtil.getParameter(request, prefix	+ "f_wk_sts", length));
			String[] fSelrlane = (JSPUtil.getParameter(request, prefix	+ "f_selrlane", length));
			String[] fStrtype = (JSPUtil.getParameter(request, prefix	+ "f_strtype", length));
			String[] fRevYrmon = (JSPUtil.getParameter(request, prefix	+ "f_rev_yrmon", length));
			String[] fCmdtCd = (JSPUtil.getParameter(request, prefix	+ "f_cmdt_cd", length));
			String[] fCobdir = (JSPUtil.getParameter(request, prefix	+ "f_cobdir", length));
			String[] fMtyLccCd = (JSPUtil.getParameter(request, prefix	+ "f_mty_lcc_cd", length));
			String[] fOpView = (JSPUtil.getParameter(request, prefix	+ "f_op_view", length));
			String[] fCrrCd = (JSPUtil.getParameter(request, prefix	+ "f_crr_cd", length));
			String[] fSelgroup = (JSPUtil.getParameter(request, prefix	+ "f_selgroup", length));
			String[] f2nd = (JSPUtil.getParameter(request, prefix	+ "f_2nd", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fSweek = (JSPUtil.getParameter(request, prefix	+ "f_sweek", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fHeader = (JSPUtil.getParameter(request, prefix	+ "f_header", length));
			String[] fCobcost = (JSPUtil.getParameter(request, prefix	+ "f_cobcost", length));
			String[] fOfcVw = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw", length));
			String[] fSpclCgoAwkFlg = (JSPUtil.getParameter(request, prefix	+ "f_spcl_cgo_awk_flg", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] fScNo = (JSPUtil.getParameter(request, prefix	+ "f_sc_no", length));
			String[] fDirSts = (JSPUtil.getParameter(request, prefix	+ "f_dir_sts", length));
			String[] fWkCd = (JSPUtil.getParameter(request, prefix	+ "f_wk_cd", length));
			String[] fKeyAcctGroupCd = (JSPUtil.getParameter(request, prefix	+ "f_key_acct_group_cd", length));
			String[] fHeadernm = (JSPUtil.getParameter(request, prefix	+ "f_headernm", length));
			String[] fSpclCgoDgFlg = (JSPUtil.getParameter(request, prefix	+ "f_spcl_cgo_dg_flg", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fLoc = (JSPUtil.getParameter(request, prefix	+ "f_loc", length));
			String[] fHDirCd = (JSPUtil.getParameter(request, prefix	+ "f_h_dir_cd", length));
			String[] fCboslane = (JSPUtil.getParameter(request, prefix	+ "f_cboslane", length));
			String[] fPctlNo = (JSPUtil.getParameter(request, prefix	+ "f_pctl_no", length));
			String[] fSpclCgoRfFlg = (JSPUtil.getParameter(request, prefix	+ "f_spcl_cgo_rf_flg", length));
			String[] fStrdir = (JSPUtil.getParameter(request, prefix	+ "f_strdir", length));
			String[] fCboEcc = (JSPUtil.getParameter(request, prefix	+ "f_cbo_ecc", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] fChkprevcre = (JSPUtil.getParameter(request, prefix	+ "f_chkprevcre", length));
			String[] fStrfmweek = (JSPUtil.getParameter(request, prefix	+ "f_strfmweek", length));
			String[] fSpclCgoBbFlg = (JSPUtil.getParameter(request, prefix	+ "f_spcl_cgo_bb_flg", length));
			String[] fSlanCd = (JSPUtil.getParameter(request, prefix	+ "f_slan_cd", length));
			String[] fFrom = (JSPUtil.getParameter(request, prefix	+ "f_from", length));
			String[] fEccCd2 = (JSPUtil.getParameter(request, prefix	+ "f_ecc_cd2", length));
			String[] fChkBsazrflg = (JSPUtil.getParameter(request, prefix	+ "f_chk_bsazrflg", length));
			String[] fActGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_act_grp_cd", length));
			String[] fBkgDisp = (JSPUtil.getParameter(request, prefix	+ "f_bkg_disp", length));
			String[] fVoyage = (JSPUtil.getParameter(request, prefix	+ "f_voyage", length));
			String[] fSeldir = (JSPUtil.getParameter(request, prefix	+ "f_seldir", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fMtyRccCd = (JSPUtil.getParameter(request, prefix	+ "f_mty_rcc_cd", length));
			String[] fChkdel = (JSPUtil.getParameter(request, prefix	+ "f_chkdel", length));
			String[] fXLev = (JSPUtil.getParameter(request, prefix	+ "f_x_lev", length));
			String[] fSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sls_ofc_cd", length));
			String[] fLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "f_locl_curr_cd", length));
			String[] fCboLcc = (JSPUtil.getParameter(request, prefix	+ "f_cbo_lcc", length));
			String[] fAvgSuvgrp = (JSPUtil.getParameter(request, prefix	+ "f_avg_suvgrp", length));
			String[] fHRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_h_rlane_cd", length));
			String[] fStrchkprd = (JSPUtil.getParameter(request, prefix	+ "f_strchkprd", length));
			String[] fToEcc = (JSPUtil.getParameter(request, prefix	+ "f_to_ecc", length));
			String[] fSmon = (JSPUtil.getParameter(request, prefix	+ "f_smon", length));
			String[] fTarMon = (JSPUtil.getParameter(request, prefix	+ "f_tar_mon", length));
			String[] fCoaCd = (JSPUtil.getParameter(request, prefix	+ "f_coa_cd", length));
			String[] fCostLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_cost_loc_grp_cd", length));
			String[] fCostYrmon = (JSPUtil.getParameter(request, prefix	+ "f_cost_yrmon", length));
			String[] fSeltrade = (JSPUtil.getParameter(request, prefix	+ "f_seltrade", length));
			String[] fStrlane = (JSPUtil.getParameter(request, prefix	+ "f_strlane", length));
			String[] fSelioc = (JSPUtil.getParameter(request, prefix	+ "f_selioc", length));
			String[] fEcc = (JSPUtil.getParameter(request, prefix	+ "f_ecc", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fDir = (JSPUtil.getParameter(request, prefix	+ "f_dir", length));
			String[] fCostFmMon = (JSPUtil.getParameter(request, prefix	+ "f_cost_fm_mon", length));
			String[] fCalcTermCd = (JSPUtil.getParameter(request, prefix	+ "f_calc_term_cd", length));
			String[] fVslCd2 = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd2", length));
			String[] fInout = (JSPUtil.getParameter(request, prefix	+ "f_inout", length));
			String[] istrade = (JSPUtil.getParameter(request, prefix	+ "istrade", length));
			String[] fBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "f_bkg_no_split", length));
			String[] fSelslane = (JSPUtil.getParameter(request, prefix	+ "f_selslane", length));
			String[] fRevPodCd = (JSPUtil.getParameter(request, prefix	+ "f_rev_pod_cd", length));
			String[] fStrvessel = (JSPUtil.getParameter(request, prefix	+ "f_strvessel", length));
			String[] fStryear = (JSPUtil.getParameter(request, prefix	+ "f_stryear", length));
			String[] f1st = (JSPUtil.getParameter(request, prefix	+ "f_1st", length));
			String[] fSelcapa = (JSPUtil.getParameter(request, prefix	+ "f_selcapa", length));
			String[] fRdInd = (JSPUtil.getParameter(request, prefix	+ "f_rd_ind", length));
			String[] f4th = (JSPUtil.getParameter(request, prefix	+ "f_4th", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchConditionVO();
				if (fSvcTrnsPrcCntCd[i] != null)
					model.setFSvcTrnsPrcCntCd(fSvcTrnsPrcCntCd[i]);
				if (fExclSts[i] != null)
					model.setFExclSts(fExclSts[i]);
				if (fTaaNo[i] != null)
					model.setFTaaNo(fTaaNo[i]);
				if (fCboRcc[i] != null)
					model.setFCboRcc(fCboRcc[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fSelclass[i] != null)
					model.setFSelclass(fSelclass[i]);
				if (fRccCd[i] != null)
					model.setFRccCd(fRccCd[i]);
				if (fHIocCd[i] != null)
					model.setFHIocCd(fHIocCd[i]);
				if (fWtrTermCd[i] != null)
					model.setFWtrTermCd(fWtrTermCd[i]);
				if (fStrtrade[i] != null)
					model.setFStrtrade(fStrtrade[i]);
				if (fCobtrade[i] != null)
					model.setFCobtrade(fCobtrade[i]);
				if (fSavename[i] != null)
					model.setFSavename(fSavename[i]);
				if (fPodEccCd[i] != null)
					model.setFPodEccCd(fPodEccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fExclSub[i] != null)
					model.setFExclSub(fExclSub[i]);
				if (fStrtomonth[i] != null)
					model.setFStrtomonth(fStrtomonth[i]);
				if (fTo[i] != null)
					model.setFTo(fTo[i]);
				if (fBkgPodCd[i] != null)
					model.setFBkgPodCd(fBkgPodCd[i]);
				if (fBkgDelCd[i] != null)
					model.setFBkgDelCd(fBkgDelCd[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fSelcost[i] != null)
					model.setFSelcost(fSelcost[i]);
				if (fRoutNo[i] != null)
					model.setFRoutNo(fRoutNo[i]);
				if (fAvgGrpCd[i] != null)
					model.setFAvgGrpCd(fAvgGrpCd[i]);
				if (fViewTpsz[i] != null)
					model.setFViewTpsz(fViewTpsz[i]);
				if (fBkgPolCd[i] != null)
					model.setFBkgPolCd(fBkgPolCd[i]);
				if (fStrprcnm[i] != null)
					model.setFStrprcnm(fStrprcnm[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fStrtoweek[i] != null)
					model.setFStrtoweek(fStrtoweek[i]);
				if (fSim[i] != null)
					model.setFSim(fSim[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fSimDt[i] != null)
					model.setFSimDt(fSimDt[i]);
				if (fBkgSts[i] != null)
					model.setFBkgSts(fBkgSts[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fBkgPorCd[i] != null)
					model.setFBkgPorCd(fBkgPorCd[i]);
				if (fIocCd[i] != null)
					model.setFIocCd(fIocCd[i]);
				if (fStrvoyage[i] != null)
					model.setFStrvoyage(fStrvoyage[i]);
				if (fEweek[i] != null)
					model.setFEweek(fEweek[i]);
				if (fEccCd[i] != null)
					model.setFEccCd(fEccCd[i]);
				if (fStrfmmonth[i] != null)
					model.setFStrfmmonth(fStrfmmonth[i]);
				if (fSelvessel[i] != null)
					model.setFSelvessel(fSelvessel[i]);
				if (fRevPolCd[i] != null)
					model.setFRevPolCd(fRevPolCd[i]);
				if (fDividename[i] != null)
					model.setFDividename(fDividename[i]);
				if (fMtyEccCd[i] != null)
					model.setFMtyEccCd(fMtyEccCd[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fTypeCd[i] != null)
					model.setFTypeCd(fTypeCd[i]);
				if (fCoblane[i] != null)
					model.setFCoblane(fCoblane[i]);
				if (fTmlCd[i] != null)
					model.setFTmlCd(fTmlCd[i]);
				if (fSocSts[i] != null)
					model.setFSocSts(fSocSts[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (fSdate[i] != null)
					model.setFSdate(fSdate[i]);
				if (fFromEcc[i] != null)
					model.setFFromEcc(fFromEcc[i]);
				if (fCustSeq[i] != null)
					model.setFCustSeq(fCustSeq[i]);
				if (fCbotrade[i] != null)
					model.setFCbotrade(fCbotrade[i]);
				if (fDel[i] != null)
					model.setFDel(fDel[i]);
				if (fEmon[i] != null)
					model.setFEmon(fEmon[i]);
				if (fProVw[i] != null)
					model.setFProVw(fProVw[i]);
				if (fSrcMon[i] != null)
					model.setFSrcMon(fSrcMon[i]);
				if (fYearmonth[i] != null)
					model.setFYearmonth(fYearmonth[i]);
				if (fToEccCd[i] != null)
					model.setFToEccCd(fToEccCd[i]);
				if (fOriDest[i] != null)
					model.setFOriDest(fOriDest[i]);
				if (fShprCd[i] != null)
					model.setFShprCd(fShprCd[i]);
				if (fShpr[i] != null)
					model.setFShpr(fShpr[i]);
				if (fGroup[i] != null)
					model.setFGroup(fGroup[i]);
				if (fVessel[i] != null)
					model.setFVessel(fVessel[i]);
				if (fBkgNo[i] != null)
					model.setFBkgNo(fBkgNo[i]);
				if (fFromEccCd[i] != null)
					model.setFFromEccCd(fFromEccCd[i]);
				if (fCommLocCd[i] != null)
					model.setFCommLocCd(fCommLocCd[i]);
				if (fCostYr[i] != null)
					model.setFCostYr(fCostYr[i]);
				if (fRfa[i] != null)
					model.setFRfa(fRfa[i]);
				if (fPor[i] != null)
					model.setFPor(fPor[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (fCustCntCd[i] != null)
					model.setFCustCntCd(fCustCntCd[i]);
				if (fProLvl[i] != null)
					model.setFProLvl(fProLvl[i]);
				if (fSubTrdCd[i] != null)
					model.setFSubTrdCd(fSubTrdCd[i]);
				if (fLccCd[i] != null)
					model.setFLccCd(fLccCd[i]);
				if (fHTrdCd[i] != null)
					model.setFHTrdCd(fHTrdCd[i]);
				if (fShipper[i] != null)
					model.setFShipper(fShipper[i]);
				if (fRfaNo[i] != null)
					model.setFRfaNo(fRfaNo[i]);
				if (fPod[i] != null)
					model.setFPod(fPod[i]);
				if (fSimNo[i] != null)
					model.setFSimNo(fSimNo[i]);
				if (fYearweek[i] != null)
					model.setFYearweek(fYearweek[i]);
				if (fCobioc[i] != null)
					model.setFCobioc(fCobioc[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fYrtype[i] != null)
					model.setFYrtype(fYrtype[i]);
				if (fUsaBkgModCd[i] != null)
					model.setFUsaBkgModCd(fUsaBkgModCd[i]);
				if (fOpLaneTpCd[i] != null)
					model.setFOpLaneTpCd(fOpLaneTpCd[i]);
				if (f3td[i] != null)
					model.setF3td(f3td[i]);
				if (fOfcActCd[i] != null)
					model.setFOfcActCd(fOfcActCd[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (fFullMtyCd[i] != null)
					model.setFFullMtyCd(fFullMtyCd[i]);
				if (fKeyAcctIndvlCd[i] != null)
					model.setFKeyAcctIndvlCd(fKeyAcctIndvlCd[i]);
				if (fLocCd[i] != null)
					model.setFLocCd(fLocCd[i]);
				if (fWkSts[i] != null)
					model.setFWkSts(fWkSts[i]);
				if (fSelrlane[i] != null)
					model.setFSelrlane(fSelrlane[i]);
				if (fStrtype[i] != null)
					model.setFStrtype(fStrtype[i]);
				if (fRevYrmon[i] != null)
					model.setFRevYrmon(fRevYrmon[i]);
				if (fCmdtCd[i] != null)
					model.setFCmdtCd(fCmdtCd[i]);
				if (fCobdir[i] != null)
					model.setFCobdir(fCobdir[i]);
				if (fMtyLccCd[i] != null)
					model.setFMtyLccCd(fMtyLccCd[i]);
				if (fOpView[i] != null)
					model.setFOpView(fOpView[i]);
				if (fCrrCd[i] != null)
					model.setFCrrCd(fCrrCd[i]);
				if (fSelgroup[i] != null)
					model.setFSelgroup(fSelgroup[i]);
				if (f2nd[i] != null)
					model.setF2nd(f2nd[i]);
				if (fOfcLvl[i] != null)
					model.setFOfcLvl(fOfcLvl[i]);
				if (fSweek[i] != null)
					model.setFSweek(fSweek[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fHeader[i] != null)
					model.setFHeader(fHeader[i]);
				if (fCobcost[i] != null)
					model.setFCobcost(fCobcost[i]);
				if (fOfcVw[i] != null)
					model.setFOfcVw(fOfcVw[i]);
				if (fSpclCgoAwkFlg[i] != null)
					model.setFSpclCgoAwkFlg(fSpclCgoAwkFlg[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (fScNo[i] != null)
					model.setFScNo(fScNo[i]);
				if (fDirSts[i] != null)
					model.setFDirSts(fDirSts[i]);
				if (fWkCd[i] != null)
					model.setFWkCd(fWkCd[i]);
				if (fKeyAcctGroupCd[i] != null)
					model.setFKeyAcctGroupCd(fKeyAcctGroupCd[i]);
				if (fHeadernm[i] != null)
					model.setFHeadernm(fHeadernm[i]);
				if (fSpclCgoDgFlg[i] != null)
					model.setFSpclCgoDgFlg(fSpclCgoDgFlg[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fLoc[i] != null)
					model.setFLoc(fLoc[i]);
				if (fHDirCd[i] != null)
					model.setFHDirCd(fHDirCd[i]);
				if (fCboslane[i] != null)
					model.setFCboslane(fCboslane[i]);
				if (fPctlNo[i] != null)
					model.setFPctlNo(fPctlNo[i]);
				if (fSpclCgoRfFlg[i] != null)
					model.setFSpclCgoRfFlg(fSpclCgoRfFlg[i]);
				if (fStrdir[i] != null)
					model.setFStrdir(fStrdir[i]);
				if (fCboEcc[i] != null)
					model.setFCboEcc(fCboEcc[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (fChkprevcre[i] != null)
					model.setFChkprevcre(fChkprevcre[i]);
				if (fStrfmweek[i] != null)
					model.setFStrfmweek(fStrfmweek[i]);
				if (fSpclCgoBbFlg[i] != null)
					model.setFSpclCgoBbFlg(fSpclCgoBbFlg[i]);
				if (fSlanCd[i] != null)
					model.setFSlanCd(fSlanCd[i]);
				if (fFrom[i] != null)
					model.setFFrom(fFrom[i]);
				if (fEccCd2[i] != null)
					model.setFEccCd2(fEccCd2[i]);
				if (fChkBsazrflg[i] != null)
					model.setFChkBsazrflg(fChkBsazrflg[i]);
				if (fActGrpCd[i] != null)
					model.setFActGrpCd(fActGrpCd[i]);
				if (fBkgDisp[i] != null)
					model.setFBkgDisp(fBkgDisp[i]);
				if (fVoyage[i] != null)
					model.setFVoyage(fVoyage[i]);
				if (fSeldir[i] != null)
					model.setFSeldir(fSeldir[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fMtyRccCd[i] != null)
					model.setFMtyRccCd(fMtyRccCd[i]);
				if (fChkdel[i] != null)
					model.setFChkdel(fChkdel[i]);
				if (fXLev[i] != null)
					model.setFXLev(fXLev[i]);
				if (fSlsOfcCd[i] != null)
					model.setFSlsOfcCd(fSlsOfcCd[i]);
				if (fLoclCurrCd[i] != null)
					model.setFLoclCurrCd(fLoclCurrCd[i]);
				if (fCboLcc[i] != null)
					model.setFCboLcc(fCboLcc[i]);
				if (fAvgSuvgrp[i] != null)
					model.setFAvgSuvgrp(fAvgSuvgrp[i]);
				if (fHRlaneCd[i] != null)
					model.setFHRlaneCd(fHRlaneCd[i]);
				if (fStrchkprd[i] != null)
					model.setFStrchkprd(fStrchkprd[i]);
				if (fToEcc[i] != null)
					model.setFToEcc(fToEcc[i]);
				if (fSmon[i] != null)
					model.setFSmon(fSmon[i]);
				if (fTarMon[i] != null)
					model.setFTarMon(fTarMon[i]);
				if (fCoaCd[i] != null)
					model.setFCoaCd(fCoaCd[i]);
				if (fCostLocGrpCd[i] != null)
					model.setFCostLocGrpCd(fCostLocGrpCd[i]);
				if (fCostYrmon[i] != null)
					model.setFCostYrmon(fCostYrmon[i]);
				if (fSeltrade[i] != null)
					model.setFSeltrade(fSeltrade[i]);
				if (fStrlane[i] != null)
					model.setFStrlane(fStrlane[i]);
				if (fSelioc[i] != null)
					model.setFSelioc(fSelioc[i]);
				if (fEcc[i] != null)
					model.setFEcc(fEcc[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fDir[i] != null)
					model.setFDir(fDir[i]);
				if (fCostFmMon[i] != null)
					model.setFCostFmMon(fCostFmMon[i]);
				if (fCalcTermCd[i] != null)
					model.setFCalcTermCd(fCalcTermCd[i]);
				if (fVslCd2[i] != null)
					model.setFVslCd2(fVslCd2[i]);
				if (fInout[i] != null)
					model.setFInout(fInout[i]);
				if (istrade[i] != null)
					model.setIstrade(istrade[i]);
				if (fBkgNoSplit[i] != null)
					model.setFBkgNoSplit(fBkgNoSplit[i]);
				if (fSelslane[i] != null)
					model.setFSelslane(fSelslane[i]);
				if (fRevPodCd[i] != null)
					model.setFRevPodCd(fRevPodCd[i]);
				if (fStrvessel[i] != null)
					model.setFStrvessel(fStrvessel[i]);
				if (fStryear[i] != null)
					model.setFStryear(fStryear[i]);
				if (f1st[i] != null)
					model.setF1st(f1st[i]);
				if (fSelcapa[i] != null)
					model.setFSelcapa(fSelcapa[i]);
				if (fRdInd[i] != null)
					model.setFRdInd(fRdInd[i]);
				if (f4th[i] != null)
					model.setF4th(f4th[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] getSearchConditionVOs(){
		SearchConditionVO[] vos = (SearchConditionVO[])models.toArray(new SearchConditionVO[models.size()]);
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
		this.fSvcTrnsPrcCntCd = this.fSvcTrnsPrcCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExclSts = this.fExclSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTaaNo = this.fTaaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCboRcc = this.fCboRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelclass = this.fSelclass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRccCd = this.fRccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHIocCd = this.fHIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fWtrTermCd = this.fWtrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrtrade = this.fStrtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobtrade = this.fCobtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSavename = this.fSavename .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodEccCd = this.fPodEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExclSub = this.fExclSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrtomonth = this.fStrtomonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTo = this.fTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPodCd = this.fBkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgDelCd = this.fBkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelcost = this.fSelcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRoutNo = this.fRoutNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAvgGrpCd = this.fAvgGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fViewTpsz = this.fViewTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPolCd = this.fBkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrprcnm = this.fStrprcnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrtoweek = this.fStrtoweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSim = this.fSim .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimDt = this.fSimDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgSts = this.fBkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPorCd = this.fBkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIocCd = this.fIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrvoyage = this.fStrvoyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEweek = this.fEweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEccCd = this.fEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrfmmonth = this.fStrfmmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelvessel = this.fSelvessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevPolCd = this.fRevPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDividename = this.fDividename .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyEccCd = this.fMtyEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTypeCd = this.fTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCoblane = this.fCoblane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTmlCd = this.fTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSocSts = this.fSocSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSdate = this.fSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFromEcc = this.fFromEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSeq = this.fCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCbotrade = this.fCbotrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel = this.fDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEmon = this.fEmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProVw = this.fProVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcMon = this.fSrcMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearmonth = this.fYearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToEccCd = this.fToEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOriDest = this.fOriDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fShprCd = this.fShprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fShpr = this.fShpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGroup = this.fGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVessel = this.fVessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgNo = this.fBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFromEccCd = this.fFromEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCommLocCd = this.fCommLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYr = this.fCostYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfa = this.fRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPor = this.fPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCntCd = this.fCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProLvl = this.fProLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubTrdCd = this.fSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLccCd = this.fLccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHTrdCd = this.fHTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fShipper = this.fShipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfaNo = this.fRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPod = this.fPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimNo = this.fSimNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearweek = this.fYearweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobioc = this.fCobioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYrtype = this.fYrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsaBkgModCd = this.fUsaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOpLaneTpCd = this.fOpLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f3td = this.f3td .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcActCd = this.fOfcActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFullMtyCd = this.fFullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fKeyAcctIndvlCd = this.fKeyAcctIndvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLocCd = this.fLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fWkSts = this.fWkSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelrlane = this.fSelrlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrtype = this.fStrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevYrmon = this.fRevYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmdtCd = this.fCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobdir = this.fCobdir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyLccCd = this.fMtyLccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOpView = this.fOpView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCrrCd = this.fCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelgroup = this.fSelgroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2nd = this.f2nd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSweek = this.fSweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHeader = this.fHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobcost = this.fCobcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVw = this.fOfcVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclCgoAwkFlg = this.fSpclCgoAwkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScNo = this.fScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirSts = this.fDirSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fWkCd = this.fWkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fKeyAcctGroupCd = this.fKeyAcctGroupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHeadernm = this.fHeadernm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclCgoDgFlg = this.fSpclCgoDgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLoc = this.fLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHDirCd = this.fHDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCboslane = this.fCboslane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPctlNo = this.fPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclCgoRfFlg = this.fSpclCgoRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrdir = this.fStrdir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCboEcc = this.fCboEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprevcre = this.fChkprevcre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrfmweek = this.fStrfmweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclCgoBbFlg = this.fSpclCgoBbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlanCd = this.fSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFrom = this.fFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEccCd2 = this.fEccCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkBsazrflg = this.fChkBsazrflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActGrpCd = this.fActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgDisp = this.fBkgDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVoyage = this.fVoyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSeldir = this.fSeldir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMtyRccCd = this.fMtyRccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkdel = this.fChkdel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fXLev = this.fXLev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsOfcCd = this.fSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLoclCurrCd = this.fLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCboLcc = this.fCboLcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAvgSuvgrp = this.fAvgSuvgrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHRlaneCd = this.fHRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrchkprd = this.fStrchkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToEcc = this.fToEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSmon = this.fSmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTarMon = this.fTarMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCoaCd = this.fCoaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostLocGrpCd = this.fCostLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYrmon = this.fCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSeltrade = this.fSeltrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrlane = this.fStrlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelioc = this.fSelioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEcc = this.fEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDir = this.fDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostFmMon = this.fCostFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCalcTermCd = this.fCalcTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd2 = this.fVslCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fInout = this.fInout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.istrade = this.istrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgNoSplit = this.fBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelslane = this.fSelslane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevPodCd = this.fRevPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStrvessel = this.fStrvessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStryear = this.fStryear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f1st = this.f1st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelcapa = this.fSelcapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRdInd = this.fRdInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4th = this.f4th .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
