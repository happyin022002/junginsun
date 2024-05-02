/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchConditionVO.java
*@FileTitle : SearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.05.21 최성민 
* 1.0 Creation
* 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchConditionVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchConditionVO> models = new ArrayList<SearchConditionVO>();

    /* Column Info */
    private String fSvcTrnsPrcCntCd = null;

    /* Column Info */
    private String fCboRcc = null;

    /* Column Info */
    private String fFmMon = null;

    /* Column Info */
    private String fSelclass = null;

    /* Column Info */
    private String fMasCd = null;

    /* Column Info */
    private String fCobtrade = null;

    /* Column Info */
    private String fMtPuYdCd = null;

    /* Column Info */
    private String fPodEccCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fStrtomonth = null;

    /* Column Info */
    private String fTo = null;

    /* Column Info */
    private String fSrepCd = null;

    /* Column Info */
    private String fVslCd = null;

    /* Column Info */
    private String fSelcost = null;

    /* Column Info */
    private String fAvgGrpCd = null;

    /* Column Info */
    private String fOfcTeamCd = null;

    /* Column Info */
    private String fStrtoweek = null;

    /* Column Info */
    private String fCostUseTpCd = null;

    /* Column Info */
    private String fRlaneCd = null;

    /* Column Info */
    private String fBkgPorCd = null;

    /* Column Info */
    private String fStrvoyage = null;

    /* Column Info */
    private String fStrfmmonth = null;

    /* Column Info */
    private String fDividename = null;

    /* Column Info */
    private String fChkprd = null;

    /* Column Info */
    private String fQtr = null;

    /* Column Info */
    private String fTmlCd = null;

    /* Column Info */
    private String fOtrRegionalAcct = null;

    /* Column Info */
    private String fSocSts = null;

    /* Column Info */
    private String fLocalAcct = null;

    /* Column Info */
    private String fFromEcc = null;

    /* Column Info */
    private String fSdate = null;

    /* Column Info */
    private String fCustSeq = null;

    /* Column Info */
    private String fCbotrade = null;

    /* Column Info */
    private String fEmon = null;

    /* Column Info */
    private String fProVw = null;

    /* Column Info */
    private String fYearmonth = null;

    /* Column Info */
    private String fToEccCd = null;

    /* Column Info */
    private String fShpr = null;

    /* Column Info */
    private String fShprCd = null;

    /* Column Info */
    private String fOtrStrgAcct = null;

    /* Column Info */
    private String fVessel = null;

    /* Column Info */
    private String fFromEccCd = null;

    /* Column Info */
    private String fCommLocCd = null;

    /* Column Info */
    private String fPor = null;

    /* Column Info */
    private String fRfa = null;

    /* Column Info */
    private String fOtrRfCoreAcct = null;

    /* Column Info */
    private String fIncludeTs = null;

    /* Column Info */
    private String fFixedRate = null;

    /* Column Info */
    private String fOfcCd = null;

    /* Column Info */
    private String fSubTrdCd = null;

    /* Column Info */
    private String fLccCd = null;

    /* Column Info */
    private String fRfaNo = null;

    /* Column Info */
    private String fSimNo = null;

    /* Column Info */
    private String fHulBndCd = null;

    /* Column Info */
    private String fDirCd = null;

    /* Column Info */
    private String fUsaBkgModCd = null;

    /* Column Info */
    private String fOpLaneTpCd = null;

    /* Column Info */
    private String fFullMtyCd = null;

    /* Column Info */
    private String fMdmChargeTypeCd = null;

    /* Column Info */
    private String fWkSts = null;

    /* Column Info */
    private String fSelrlane = null;

    /* Column Info */
    private String fStrtype = null;

    /* Column Info */
    private String fRevYrmon = null;

    /* Column Info */
    private String fCobdir = null;

    /* Column Info */
    private String fMtyLccCd = null;

    /* Column Info */
    private String fOfcLvl = null;

    /* Column Info */
    private String fHeader = null;

    /* Column Info */
    private String fOfcVw = null;

    /* Column Info */
    private String fSpclCgoAwkFlg = null;

    /* Column Info */
    private String fScNo = null;

    /* Column Info */
    private String fUsrId = null;

    /* Column Info */
    private String fKeyAcctGroupCd = null;

    /* Column Info */
    private String fToWk = null;

    /* Column Info */
    private String fSpclCgoDgFlg = null;

    /* Column Info */
    private String fCboslane = null;

    /* Column Info */
    private String fHDirCd = null;

    /* Column Info */
    private String fSpclCgoRfFlg = null;

    /* Column Info */
    private String fStrdir = null;

    /* Column Info */
    private String fChkprevcre = null;

    /* Column Info */
    private String fStrfmweek = null;

    /* Column Info */
    private String fSlanCd = null;

    /* Column Info */
    private String fFrom = null;

    /* Column Info */
    private String fEccCd2 = null;

    /* Column Info */
    private String fActGrpCd = null;

    /* Column Info */
    private String fChkBsazrflg = null;

    /* Column Info */
    private String fVoyage = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String fMtyRccCd = null;

    /* Column Info */
    private String fXLev = null;

    /* Column Info */
    private String fChkdel = null;

    /* Column Info */
    private String fSlsOfcCd = null;

    /* Column Info */
    private String fLoclCurrCd = null;

    /* Column Info */
    private String fCboLcc = null;

    /* Column Info */
    private String fToEcc = null;

    /* Column Info */
    private String fHRlaneCd = null;

    /* Column Info */
    private String fSmon = null;

    /* Column Info */
    private String fCostLocGrpCd = null;

    /* Column Info */
    private String fIasSubGrpCd = null;

    /* Column Info */
    private String fSelioc = null;

    /* Column Info */
    private String fMltTrdGroupCd = null;

    /* Column Info */
    private String fSkdDirCd = null;

    /* Column Info */
    private String fDir = null;

    /* Column Info */
    private String fCostFmMon = null;

    /* Column Info */
    private String fPolPodCd = null;

    /* Column Info */
    private String fCalcTermCd = null;

    /* Column Info */
    private String fInout = null;

    /* Column Info */
    private String istrade = null;

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
    private String fRdInd = null;

    /* Column Info */
    private String fExclSts = null;

    /* Column Info */
    private String fTaaNo = null;

    /* Column Info */
    private String fRccCd = null;

    /* Column Info */
    private String fHIocCd = null;

    /* Column Info */
    private String fDur = null;

    /* Column Info */
    private String fRfCoreAcctCd = null;

    /* Column Info */
    private String fWtrTermCd = null;

    /* Column Info */
    private String fStrtrade = null;

    /* Column Info */
    private String fSavename = null;

    /* Column Info */
    private String fExclSub = null;

    /* Column Info */
    private String fCustTp = null;

    /* Column Info */
    private String fBkgPodCd = null;

    /* Column Info */
    private String fBkgDelCd = null;

    /* Column Info */
    private String fMdmChargeCd = null;

    /* Column Info */
    private String fRoutNo = null;

    /* Column Info */
    private String fViewTpsz = null;

    /* Column Info */
    private String fBkgPolCd = null;

    /* Column Info */
    private String fStrprcnm = null;

    /* Column Info */
    private String fToMon = null;

    /* Column Info */
    private String fRaAcctGroupCd = null;

    /* Column Info */
    private String fSim = null;

    /* Column Info */
    private String fTrdCd = null;

    /* Column Info */
    private String fSimDt = null;

    /* Column Info */
    private String fBkgSts = null;

    /* Column Info */
    private String fMtPuCd = null;

    /* Column Info */
    private String fIocCd = null;

    /* Column Info */
    private String fEweek = null;

    /* Column Info */
    private String fEccCd = null;

    /* Column Info */
    private String fSelvessel = null;

    /* Column Info */
    private String fRevPolCd = null;

    /* Column Info */
    private String fMtyEccCd = null;

    /* Column Info */
    private String fTypeCd = null;

    /* Column Info */
    private String fCoblane = null;

    /* Column Info */
    private String fUcCd = null;

    /* Column Info */
    private String fCntrTpszCd = null;

    /* Column Info */
    private String fDel = null;

    /* Column Info */
    private String fRaAcctIndvlCd = null;

    /* Column Info */
    private String fOtrGlobalAcct = null;

    /* Column Info */
    private String fSrcMon = null;

    /* Column Info */
    private String fOriDest = null;

    /* Column Info */
    private String fLgsKpi3Cd = null;

    /* Column Info */
    private String fGroup = null;

    /* Column Info */
    private String fTtlAmt = null;

    /* Column Info */
    private String fBkgNo = null;

    /* Column Info */
    private String fCostYr = null;

    /* Column Info */
    private String fCustCntCd = null;

    /* Column Info */
    private String fProLvl = null;

    /* Column Info */
    private String fSaTrdIndvlCd = null;

    /* Column Info */
    private String fHTrdCd = null;

    /* Column Info */
    private String fShipper = null;

    /* Column Info */
    private String fPod = null;

    /* Column Info */
    private String fYearweek = null;

    /* Column Info */
    private String fCobioc = null;

    /* Column Info */
    private String fYrtype = null;

    /* Column Info */
    private String fOfcActCd = null;

    /* Column Info */
    private String f3td = null;

    /* Column Info */
    private String fRhqCd = null;

    /* Column Info */
    private String fSlsMon = null;

    /* Column Info */
    private String fKeyAcctIndvlCd = null;

    /* Column Info */
    private String fLocCd = null;

    /* Column Info */
    private String fCustRhqCd = null;

    /* Column Info */
    private String fCmdtCd = null;

    /* Column Info */
    private String fOtrKeyAcct = null;

    /* Column Info */
    private String fOpView = null;

    /* Column Info */
    private String fSaTrdGroupCd = null;

    /* Column Info */
    private String fCrrCd = null;

    /* Column Info */
    private String f2nd = null;

    /* Column Info */
    private String fSelgroup = null;

    /* Column Info */
    private String fSweek = null;

    /* Column Info */
    private String fFmWk = null;

    /* Column Info */
    private String fCobcost = null;

    /* Column Info */
    private String fSpclCgoCd = null;

    /* Column Info */
    private String fMltTrdIndvlCd = null;

    /* Column Info */
    private String fSkdVoyNo = null;

    /* Column Info */
    private String fDirSts = null;

    /* Column Info */
    private String fWkCd = null;

    /* Column Info */
    private String fHeadernm = null;

    /* Column Info */
    private String fTrdSts = null;

    /* Column Info */
    private String fTrdDirCd = null;

    /* Column Info */
    private String fLoc = null;

    /* Column Info */
    private String fPctlNo = null;

    /* Column Info */
    private String fCboEcc = null;

    /* Column Info */
    private String fYear = null;

    /* Column Info */
    private String fMon = null;

    /* Column Info */
    private String fSpclCgoBbFlg = null;

    /* Column Info */
    private String fBkgDisp = null;

    /* Column Info */
    private String fSeldir = null;

    /* Column Info */
    private String fStsCd = null;

    /* Column Info */
    private String fAvgSuvgrp = null;

    /* Column Info */
    private String fStrchkprd = null;

    /* Column Info */
    private String fTarMon = null;

    /* Column Info */
    private String fVopCd = null;

    /* Column Info */
    private String fCostYrmon = null;

    /* Column Info */
    private String fIasRgnCd = null;

    /* Column Info */
    private String fSeltrade = null;

    /* Column Info */
    private String fStrlane = null;

    /* Column Info */
    private String fEcc = null;

    /* Column Info */
    private String fVslCd2 = null;

    /* Column Info */
    private String fBkgNoSplit = null;

    /* Column Info */
    private String fSelcapa = null;

    /* Column Info */
    private String f4th = null;

    /* Column Info */
    private String dateCheckFlag = null;

    /* Column Info */
    private String fLoclTsStsCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchConditionVO() {
    }

    public SearchConditionVO(String ibflag, String pagerows, String fSvcTrnsPrcCntCd, String fCboRcc, String fFmMon, String fSelclass, String fCobtrade, String fMtPuYdCd, String fPodEccCd, String fStrtomonth, String fTo, String fVslCd, String fSelcost, String fAvgGrpCd, String fCostUseTpCd, String fStrtoweek, String fRlaneCd, String fBkgPorCd, String fStrvoyage, String fStrfmmonth, String fDividename, String fChkprd, String fTmlCd, String fOtrRegionalAcct, String fSocSts, String fFromEcc, String fSdate, String fCustSeq, String fCbotrade, String fEmon, String fProVw, String fYearmonth, String fToEccCd, String fShpr, String fShprCd, String fOtrStrgAcct, String fVessel, String fFromEccCd, String fCommLocCd, String fPor, String fRfa, String fOtrRfCoreAcct, String fOfcCd, String fSubTrdCd, String fLccCd, String fRfaNo, String fSimNo, String fDirCd, String fUsaBkgModCd, String fOpLaneTpCd, String fFullMtyCd, String fMdmChargeTypeCd, String fWkSts, String fSelrlane, String fRevYrmon, String fStrtype, String fCobdir, String fMtyLccCd, String fOfcLvl, String fHeader, String fOfcVw, String fSpclCgoAwkFlg, String fScNo, String fKeyAcctGroupCd, String fSpclCgoDgFlg, String fToWk, String fHDirCd, String fCboslane, String fSpclCgoRfFlg, String fStrdir, String fChkprevcre, String fStrfmweek, String fSlanCd, String fFrom, String fEccCd2, String fChkBsazrflg, String fActGrpCd, String fVoyage, String fMtyRccCd, String fChkdel, String fXLev, String fSlsOfcCd, String fLoclCurrCd, String fCboLcc, String fHRlaneCd, String fToEcc, String fSmon, String fCostLocGrpCd, String fIasSubGrpCd, String fMltTrdGroupCd, String fSelioc, String fSkdDirCd, String fDir, String fCostFmMon, String fCalcTermCd, String fInout, String istrade, String fSelslane, String fRevPodCd, String fStrvessel, String fStryear, String f1st, String fRdInd, String fExclSts, String fTaaNo, String fRccCd, String fHIocCd, String fRfCoreAcctCd, String fWtrTermCd, String fStrtrade, String fSavename, String fExclSub, String fBkgPodCd, String fBkgDelCd, String fMdmChargeCd, String fRoutNo, String fViewTpsz, String fBkgPolCd, String fStrprcnm, String fToMon, String fRaAcctGroupCd, String fSim, String fTrdCd, String fSimDt, String fBkgSts, String fMtPuCd, String fIocCd, String fEweek, String fEccCd, String fSelvessel, String fRevPolCd, String fMtyEccCd, String fTypeCd, String fCoblane, String fCntrTpszCd, String fDel, String fRaAcctIndvlCd, String fOtrGlobalAcct, String fSrcMon, String fOriDest, String fGroup, String fBkgNo, String fCostYr, String fCustCntCd, String fProLvl, String fSaTrdIndvlCd, String fHTrdCd, String fShipper, String fPod, String fYearweek, String fCobioc, String fYrtype, String fOfcActCd, String f3td, String fRhqCd, String fSlsMon, String fKeyAcctIndvlCd, String fLocCd, String fCmdtCd, String fOtrKeyAcct, String fOpView, String fSaTrdGroupCd, String fCrrCd, String f2nd, String fSelgroup, String fSweek, String fFmWk, String fCobcost, String fMltTrdIndvlCd, String fSkdVoyNo, String fDirSts, String fWkCd, String fHeadernm, String fLoc, String fPctlNo, String fCboEcc, String fYear, String fMon, String fSpclCgoBbFlg, String fBkgDisp, String fSeldir, String fAvgSuvgrp, String fStrchkprd, String fTarMon, String fVopCd, String fMasCd, String fCostYrmon, String fSeltrade, String fStrlane, String fEcc, String fVslCd2, String fBkgNoSplit, String fSelcapa, String f4th, String fSrepCd, String fIasRgnCd, String fHulBndCd, String fOfcTeamCd, String fCustRhqCd, String fLocalAcct, String fCustTp, String fTrdDirCd, String fTrdSts, String fStsCd, String fUcCd, String fUsrId, String fPolPodCd, String fSpclCgoCd, String fLgsKpi3Cd, String fTtlAmt, String fDur, String fIncludeTs, String fFixedRate, String fQtr, String dateCheckFlag, String fLoclTsStsCd) {
        this.fSvcTrnsPrcCntCd = fSvcTrnsPrcCntCd;
        this.fCboRcc = fCboRcc;
        this.fFmMon = fFmMon;
        this.fSelclass = fSelclass;
        this.fMasCd = fMasCd;
        this.fCobtrade = fCobtrade;
        this.fMtPuYdCd = fMtPuYdCd;
        this.fPodEccCd = fPodEccCd;
        this.pagerows = pagerows;
        this.fStrtomonth = fStrtomonth;
        this.fTo = fTo;
        this.fSrepCd = fSrepCd;
        this.fVslCd = fVslCd;
        this.fSelcost = fSelcost;
        this.fAvgGrpCd = fAvgGrpCd;
        this.fOfcTeamCd = fOfcTeamCd;
        this.fStrtoweek = fStrtoweek;
        this.fCostUseTpCd = fCostUseTpCd;
        this.fRlaneCd = fRlaneCd;
        this.fBkgPorCd = fBkgPorCd;
        this.fStrvoyage = fStrvoyage;
        this.fStrfmmonth = fStrfmmonth;
        this.fDividename = fDividename;
        this.fChkprd = fChkprd;
        this.fQtr = fQtr;
        this.fTmlCd = fTmlCd;
        this.fOtrRegionalAcct = fOtrRegionalAcct;
        this.fSocSts = fSocSts;
        this.fLocalAcct = fLocalAcct;
        this.fFromEcc = fFromEcc;
        this.fSdate = fSdate;
        this.fCustSeq = fCustSeq;
        this.fCbotrade = fCbotrade;
        this.fEmon = fEmon;
        this.fProVw = fProVw;
        this.fYearmonth = fYearmonth;
        this.fToEccCd = fToEccCd;
        this.fShpr = fShpr;
        this.fShprCd = fShprCd;
        this.fOtrStrgAcct = fOtrStrgAcct;
        this.fVessel = fVessel;
        this.fFromEccCd = fFromEccCd;
        this.fCommLocCd = fCommLocCd;
        this.fPor = fPor;
        this.fRfa = fRfa;
        this.fOtrRfCoreAcct = fOtrRfCoreAcct;
        this.fIncludeTs = fIncludeTs;
        this.fFixedRate = fFixedRate;
        this.fOfcCd = fOfcCd;
        this.fSubTrdCd = fSubTrdCd;
        this.fLccCd = fLccCd;
        this.fRfaNo = fRfaNo;
        this.fSimNo = fSimNo;
        this.fHulBndCd = fHulBndCd;
        this.fDirCd = fDirCd;
        this.fUsaBkgModCd = fUsaBkgModCd;
        this.fOpLaneTpCd = fOpLaneTpCd;
        this.fFullMtyCd = fFullMtyCd;
        this.fMdmChargeTypeCd = fMdmChargeTypeCd;
        this.fWkSts = fWkSts;
        this.fSelrlane = fSelrlane;
        this.fStrtype = fStrtype;
        this.fRevYrmon = fRevYrmon;
        this.fCobdir = fCobdir;
        this.fMtyLccCd = fMtyLccCd;
        this.fOfcLvl = fOfcLvl;
        this.fHeader = fHeader;
        this.fOfcVw = fOfcVw;
        this.fSpclCgoAwkFlg = fSpclCgoAwkFlg;
        this.fScNo = fScNo;
        this.fUsrId = fUsrId;
        this.fKeyAcctGroupCd = fKeyAcctGroupCd;
        this.fToWk = fToWk;
        this.fSpclCgoDgFlg = fSpclCgoDgFlg;
        this.fCboslane = fCboslane;
        this.fHDirCd = fHDirCd;
        this.fSpclCgoRfFlg = fSpclCgoRfFlg;
        this.fStrdir = fStrdir;
        this.fChkprevcre = fChkprevcre;
        this.fStrfmweek = fStrfmweek;
        this.fSlanCd = fSlanCd;
        this.fFrom = fFrom;
        this.fEccCd2 = fEccCd2;
        this.fActGrpCd = fActGrpCd;
        this.fChkBsazrflg = fChkBsazrflg;
        this.fVoyage = fVoyage;
        this.ibflag = ibflag;
        this.fMtyRccCd = fMtyRccCd;
        this.fXLev = fXLev;
        this.fChkdel = fChkdel;
        this.fSlsOfcCd = fSlsOfcCd;
        this.fLoclCurrCd = fLoclCurrCd;
        this.fCboLcc = fCboLcc;
        this.fToEcc = fToEcc;
        this.fHRlaneCd = fHRlaneCd;
        this.fSmon = fSmon;
        this.fCostLocGrpCd = fCostLocGrpCd;
        this.fIasSubGrpCd = fIasSubGrpCd;
        this.fSelioc = fSelioc;
        this.fMltTrdGroupCd = fMltTrdGroupCd;
        this.fSkdDirCd = fSkdDirCd;
        this.fDir = fDir;
        this.fCostFmMon = fCostFmMon;
        this.fPolPodCd = fPolPodCd;
        this.fCalcTermCd = fCalcTermCd;
        this.fInout = fInout;
        this.istrade = istrade;
        this.fSelslane = fSelslane;
        this.fRevPodCd = fRevPodCd;
        this.fStrvessel = fStrvessel;
        this.fStryear = fStryear;
        this.f1st = f1st;
        this.fRdInd = fRdInd;
        this.fExclSts = fExclSts;
        this.fTaaNo = fTaaNo;
        this.fRccCd = fRccCd;
        this.fHIocCd = fHIocCd;
        this.fDur = fDur;
        this.fRfCoreAcctCd = fRfCoreAcctCd;
        this.fWtrTermCd = fWtrTermCd;
        this.fStrtrade = fStrtrade;
        this.fSavename = fSavename;
        this.fExclSub = fExclSub;
        this.fCustTp = fCustTp;
        this.fBkgPodCd = fBkgPodCd;
        this.fBkgDelCd = fBkgDelCd;
        this.fMdmChargeCd = fMdmChargeCd;
        this.fRoutNo = fRoutNo;
        this.fViewTpsz = fViewTpsz;
        this.fBkgPolCd = fBkgPolCd;
        this.fStrprcnm = fStrprcnm;
        this.fToMon = fToMon;
        this.fRaAcctGroupCd = fRaAcctGroupCd;
        this.fSim = fSim;
        this.fTrdCd = fTrdCd;
        this.fSimDt = fSimDt;
        this.fBkgSts = fBkgSts;
        this.fMtPuCd = fMtPuCd;
        this.fIocCd = fIocCd;
        this.fEweek = fEweek;
        this.fEccCd = fEccCd;
        this.fSelvessel = fSelvessel;
        this.fRevPolCd = fRevPolCd;
        this.fMtyEccCd = fMtyEccCd;
        this.fTypeCd = fTypeCd;
        this.fCoblane = fCoblane;
        this.fUcCd = fUcCd;
        this.fCntrTpszCd = fCntrTpszCd;
        this.fDel = fDel;
        this.fRaAcctIndvlCd = fRaAcctIndvlCd;
        this.fOtrGlobalAcct = fOtrGlobalAcct;
        this.fSrcMon = fSrcMon;
        this.fOriDest = fOriDest;
        this.fLgsKpi3Cd = fLgsKpi3Cd;
        this.fGroup = fGroup;
        this.fTtlAmt = fTtlAmt;
        this.fBkgNo = fBkgNo;
        this.fCostYr = fCostYr;
        this.fCustCntCd = fCustCntCd;
        this.fProLvl = fProLvl;
        this.fSaTrdIndvlCd = fSaTrdIndvlCd;
        this.fHTrdCd = fHTrdCd;
        this.fShipper = fShipper;
        this.fPod = fPod;
        this.fYearweek = fYearweek;
        this.fCobioc = fCobioc;
        this.fYrtype = fYrtype;
        this.fOfcActCd = fOfcActCd;
        this.f3td = f3td;
        this.fRhqCd = fRhqCd;
        this.fSlsMon = fSlsMon;
        this.fKeyAcctIndvlCd = fKeyAcctIndvlCd;
        this.fLocCd = fLocCd;
        this.fCustRhqCd = fCustRhqCd;
        this.fCmdtCd = fCmdtCd;
        this.fOtrKeyAcct = fOtrKeyAcct;
        this.fOpView = fOpView;
        this.fSaTrdGroupCd = fSaTrdGroupCd;
        this.fCrrCd = fCrrCd;
        this.f2nd = f2nd;
        this.fSelgroup = fSelgroup;
        this.fSweek = fSweek;
        this.fFmWk = fFmWk;
        this.fCobcost = fCobcost;
        this.fSpclCgoCd = fSpclCgoCd;
        this.fMltTrdIndvlCd = fMltTrdIndvlCd;
        this.fSkdVoyNo = fSkdVoyNo;
        this.fDirSts = fDirSts;
        this.fWkCd = fWkCd;
        this.fHeadernm = fHeadernm;
        this.fTrdSts = fTrdSts;
        this.fTrdDirCd = fTrdDirCd;
        this.fLoc = fLoc;
        this.fPctlNo = fPctlNo;
        this.fCboEcc = fCboEcc;
        this.fYear = fYear;
        this.fMon = fMon;
        this.fSpclCgoBbFlg = fSpclCgoBbFlg;
        this.fBkgDisp = fBkgDisp;
        this.fSeldir = fSeldir;
        this.fStsCd = fStsCd;
        this.fAvgSuvgrp = fAvgSuvgrp;
        this.fStrchkprd = fStrchkprd;
        this.fTarMon = fTarMon;
        this.fVopCd = fVopCd;
        this.fCostYrmon = fCostYrmon;
        this.fIasRgnCd = fIasRgnCd;
        this.fSeltrade = fSeltrade;
        this.fStrlane = fStrlane;
        this.fEcc = fEcc;
        this.fVslCd2 = fVslCd2;
        this.fBkgNoSplit = fBkgNoSplit;
        this.fSelcapa = fSelcapa;
        this.f4th = f4th;
        this.dateCheckFlag = dateCheckFlag;
        this.fLoclTsStsCd = fLoclTsStsCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("f_svc_trns_prc_cnt_cd", getFSvcTrnsPrcCntCd());
        this.hashColumns.put("f_cbo_rcc", getFCboRcc());
        this.hashColumns.put("f_fm_mon", getFFmMon());
        this.hashColumns.put("f_selclass", getFSelclass());
        this.hashColumns.put("f_mas_cd", getFMasCd());
        this.hashColumns.put("f_cobtrade", getFCobtrade());
        this.hashColumns.put("f_mt_pu_yd_cd", getFMtPuYdCd());
        this.hashColumns.put("f_pod_ecc_cd", getFPodEccCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("f_strtomonth", getFStrtomonth());
        this.hashColumns.put("f_to", getFTo());
        this.hashColumns.put("f_srep_cd", getFSrepCd());
        this.hashColumns.put("f_vsl_cd", getFVslCd());
        this.hashColumns.put("f_selcost", getFSelcost());
        this.hashColumns.put("f_avg_grp_cd", getFAvgGrpCd());
        this.hashColumns.put("f_ofc_team_cd", getFOfcTeamCd());
        this.hashColumns.put("f_strtoweek", getFStrtoweek());
        this.hashColumns.put("f_cost_use_tp_cd", getFCostUseTpCd());
        this.hashColumns.put("f_rlane_cd", getFRlaneCd());
        this.hashColumns.put("f_bkg_por_cd", getFBkgPorCd());
        this.hashColumns.put("f_strvoyage", getFStrvoyage());
        this.hashColumns.put("f_strfmmonth", getFStrfmmonth());
        this.hashColumns.put("f_dividename", getFDividename());
        this.hashColumns.put("f_chkprd", getFChkprd());
        this.hashColumns.put("f_qtr", getFQtr());
        this.hashColumns.put("f_tml_cd", getFTmlCd());
        this.hashColumns.put("f_otr_regional_acct", getFOtrRegionalAcct());
        this.hashColumns.put("f_soc_sts", getFSocSts());
        this.hashColumns.put("f_local_acct", getFLocalAcct());
        this.hashColumns.put("f_from_ecc", getFFromEcc());
        this.hashColumns.put("f_sdate", getFSdate());
        this.hashColumns.put("f_cust_seq", getFCustSeq());
        this.hashColumns.put("f_cbotrade", getFCbotrade());
        this.hashColumns.put("f_emon", getFEmon());
        this.hashColumns.put("f_pro_vw", getFProVw());
        this.hashColumns.put("f_yearmonth", getFYearmonth());
        this.hashColumns.put("f_to_ecc_cd", getFToEccCd());
        this.hashColumns.put("f_shpr", getFShpr());
        this.hashColumns.put("f_shpr_cd", getFShprCd());
        this.hashColumns.put("f_otr_strg_acct", getFOtrStrgAcct());
        this.hashColumns.put("f_vessel", getFVessel());
        this.hashColumns.put("f_from_ecc_cd", getFFromEccCd());
        this.hashColumns.put("f_comm_loc_cd", getFCommLocCd());
        this.hashColumns.put("f_por", getFPor());
        this.hashColumns.put("f_rfa", getFRfa());
        this.hashColumns.put("f_otr_rf_core_acct", getFOtrRfCoreAcct());
        this.hashColumns.put("f_include_ts", getFIncludeTs());
        this.hashColumns.put("f_fixed_rate", getFFixedRate());
        this.hashColumns.put("f_ofc_cd", getFOfcCd());
        this.hashColumns.put("f_sub_trd_cd", getFSubTrdCd());
        this.hashColumns.put("f_lcc_cd", getFLccCd());
        this.hashColumns.put("f_rfa_no", getFRfaNo());
        this.hashColumns.put("f_sim_no", getFSimNo());
        this.hashColumns.put("f_hul_bnd_cd", getFHulBndCd());
        this.hashColumns.put("f_dir_cd", getFDirCd());
        this.hashColumns.put("f_usa_bkg_mod_cd", getFUsaBkgModCd());
        this.hashColumns.put("f_op_lane_tp_cd", getFOpLaneTpCd());
        this.hashColumns.put("f_full_mty_cd", getFFullMtyCd());
        this.hashColumns.put("f_mdm_charge_type_cd", getFMdmChargeTypeCd());
        this.hashColumns.put("f_wk_sts", getFWkSts());
        this.hashColumns.put("f_selrlane", getFSelrlane());
        this.hashColumns.put("f_strtype", getFStrtype());
        this.hashColumns.put("f_rev_yrmon", getFRevYrmon());
        this.hashColumns.put("f_cobdir", getFCobdir());
        this.hashColumns.put("f_mty_lcc_cd", getFMtyLccCd());
        this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
        this.hashColumns.put("f_header", getFHeader());
        this.hashColumns.put("f_ofc_vw", getFOfcVw());
        this.hashColumns.put("f_spcl_cgo_awk_flg", getFSpclCgoAwkFlg());
        this.hashColumns.put("f_sc_no", getFScNo());
        this.hashColumns.put("f_usr_id", getFUsrId());
        this.hashColumns.put("f_key_acct_group_cd", getFKeyAcctGroupCd());
        this.hashColumns.put("f_to_wk", getFToWk());
        this.hashColumns.put("f_spcl_cgo_dg_flg", getFSpclCgoDgFlg());
        this.hashColumns.put("f_cboslane", getFCboslane());
        this.hashColumns.put("f_h_dir_cd", getFHDirCd());
        this.hashColumns.put("f_spcl_cgo_rf_flg", getFSpclCgoRfFlg());
        this.hashColumns.put("f_strdir", getFStrdir());
        this.hashColumns.put("f_chkprevcre", getFChkprevcre());
        this.hashColumns.put("f_strfmweek", getFStrfmweek());
        this.hashColumns.put("f_slan_cd", getFSlanCd());
        this.hashColumns.put("f_from", getFFrom());
        this.hashColumns.put("f_ecc_cd2", getFEccCd2());
        this.hashColumns.put("f_act_grp_cd", getFActGrpCd());
        this.hashColumns.put("f_chk_bsazrflg", getFChkBsazrflg());
        this.hashColumns.put("f_voyage", getFVoyage());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("f_mty_rcc_cd", getFMtyRccCd());
        this.hashColumns.put("f_x_lev", getFXLev());
        this.hashColumns.put("f_chkdel", getFChkdel());
        this.hashColumns.put("f_sls_ofc_cd", getFSlsOfcCd());
        this.hashColumns.put("f_locl_curr_cd", getFLoclCurrCd());
        this.hashColumns.put("f_cbo_lcc", getFCboLcc());
        this.hashColumns.put("f_to_ecc", getFToEcc());
        this.hashColumns.put("f_h_rlane_cd", getFHRlaneCd());
        this.hashColumns.put("f_smon", getFSmon());
        this.hashColumns.put("f_cost_loc_grp_cd", getFCostLocGrpCd());
        this.hashColumns.put("f_ias_sub_grp_cd", getFIasSubGrpCd());
        this.hashColumns.put("f_selioc", getFSelioc());
        this.hashColumns.put("f_mlt_trd_group_cd", getFMltTrdGroupCd());
        this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
        this.hashColumns.put("f_dir", getFDir());
        this.hashColumns.put("f_cost_fm_mon", getFCostFmMon());
        this.hashColumns.put("f_pol_pod_cd", getFPolPodCd());
        this.hashColumns.put("f_calc_term_cd", getFCalcTermCd());
        this.hashColumns.put("f_inout", getFInout());
        this.hashColumns.put("istrade", getIstrade());
        this.hashColumns.put("f_selslane", getFSelslane());
        this.hashColumns.put("f_rev_pod_cd", getFRevPodCd());
        this.hashColumns.put("f_strvessel", getFStrvessel());
        this.hashColumns.put("f_stryear", getFStryear());
        this.hashColumns.put("f_1st", getF1st());
        this.hashColumns.put("f_rd_ind", getFRdInd());
        this.hashColumns.put("f_excl_sts", getFExclSts());
        this.hashColumns.put("f_taa_no", getFTaaNo());
        this.hashColumns.put("f_rcc_cd", getFRccCd());
        this.hashColumns.put("f_h_ioc_cd", getFHIocCd());
        this.hashColumns.put("f_dur", getFDur());
        this.hashColumns.put("f_rf_core_acct_cd", getFRfCoreAcctCd());
        this.hashColumns.put("f_wtr_term_cd", getFWtrTermCd());
        this.hashColumns.put("f_strtrade", getFStrtrade());
        this.hashColumns.put("f_savename", getFSavename());
        this.hashColumns.put("f_excl_sub", getFExclSub());
        this.hashColumns.put("f_cust_tp", getFCustTp());
        this.hashColumns.put("f_bkg_pod_cd", getFBkgPodCd());
        this.hashColumns.put("f_bkg_del_cd", getFBkgDelCd());
        this.hashColumns.put("f_mdm_charge_cd", getFMdmChargeCd());
        this.hashColumns.put("f_rout_no", getFRoutNo());
        this.hashColumns.put("f_view_tpsz", getFViewTpsz());
        this.hashColumns.put("f_bkg_pol_cd", getFBkgPolCd());
        this.hashColumns.put("f_strprcnm", getFStrprcnm());
        this.hashColumns.put("f_to_mon", getFToMon());
        this.hashColumns.put("f_ra_acct_group_cd", getFRaAcctGroupCd());
        this.hashColumns.put("f_sim", getFSim());
        this.hashColumns.put("f_trd_cd", getFTrdCd());
        this.hashColumns.put("f_sim_dt", getFSimDt());
        this.hashColumns.put("f_bkg_sts", getFBkgSts());
        this.hashColumns.put("f_mt_pu_cd", getFMtPuCd());
        this.hashColumns.put("f_ioc_cd", getFIocCd());
        this.hashColumns.put("f_eweek", getFEweek());
        this.hashColumns.put("f_ecc_cd", getFEccCd());
        this.hashColumns.put("f_selvessel", getFSelvessel());
        this.hashColumns.put("f_rev_pol_cd", getFRevPolCd());
        this.hashColumns.put("f_mty_ecc_cd", getFMtyEccCd());
        this.hashColumns.put("f_type_cd", getFTypeCd());
        this.hashColumns.put("f_coblane", getFCoblane());
        this.hashColumns.put("f_uc_cd", getFUcCd());
        this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
        this.hashColumns.put("f_del", getFDel());
        this.hashColumns.put("f_ra_acct_indvl_cd", getFRaAcctIndvlCd());
        this.hashColumns.put("f_otr_global_acct", getFOtrGlobalAcct());
        this.hashColumns.put("f_src_mon", getFSrcMon());
        this.hashColumns.put("f_ori_dest", getFOriDest());
        this.hashColumns.put("f_lgs_kpi3_cd", getFLgsKpi3Cd());
        this.hashColumns.put("f_group", getFGroup());
        this.hashColumns.put("f_ttl_amt", getFTtlAmt());
        this.hashColumns.put("f_bkg_no", getFBkgNo());
        this.hashColumns.put("f_cost_yr", getFCostYr());
        this.hashColumns.put("f_cust_cnt_cd", getFCustCntCd());
        this.hashColumns.put("f_pro_lvl", getFProLvl());
        this.hashColumns.put("f_sa_trd_indvl_cd", getFSaTrdIndvlCd());
        this.hashColumns.put("f_h_trd_cd", getFHTrdCd());
        this.hashColumns.put("f_shipper", getFShipper());
        this.hashColumns.put("f_pod", getFPod());
        this.hashColumns.put("f_yearweek", getFYearweek());
        this.hashColumns.put("f_cobioc", getFCobioc());
        this.hashColumns.put("f_yrtype", getFYrtype());
        this.hashColumns.put("f_ofc_act_cd", getFOfcActCd());
        this.hashColumns.put("f_3td", getF3td());
        this.hashColumns.put("f_rhq_cd", getFRhqCd());
        this.hashColumns.put("f_sls_mon", getFSlsMon());
        this.hashColumns.put("f_key_acct_indvl_cd", getFKeyAcctIndvlCd());
        this.hashColumns.put("f_loc_cd", getFLocCd());
        this.hashColumns.put("f_cust_rhq_cd", getFCustRhqCd());
        this.hashColumns.put("f_cmdt_cd", getFCmdtCd());
        this.hashColumns.put("f_otr_key_acct", getFOtrKeyAcct());
        this.hashColumns.put("f_op_view", getFOpView());
        this.hashColumns.put("f_sa_trd_group_cd", getFSaTrdGroupCd());
        this.hashColumns.put("f_crr_cd", getFCrrCd());
        this.hashColumns.put("f_2nd", getF2nd());
        this.hashColumns.put("f_selgroup", getFSelgroup());
        this.hashColumns.put("f_sweek", getFSweek());
        this.hashColumns.put("f_fm_wk", getFFmWk());
        this.hashColumns.put("f_cobcost", getFCobcost());
        this.hashColumns.put("f_spcl_cgo_cd", getFSpclCgoCd());
        this.hashColumns.put("f_mlt_trd_indvl_cd", getFMltTrdIndvlCd());
        this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
        this.hashColumns.put("f_dir_sts", getFDirSts());
        this.hashColumns.put("f_wk_cd", getFWkCd());
        this.hashColumns.put("f_headernm", getFHeadernm());
        this.hashColumns.put("f_trd_sts", getFTrdSts());
        this.hashColumns.put("f_trd_dir_cd", getFTrdDirCd());
        this.hashColumns.put("f_loc", getFLoc());
        this.hashColumns.put("f_pctl_no", getFPctlNo());
        this.hashColumns.put("f_cbo_ecc", getFCboEcc());
        this.hashColumns.put("f_year", getFYear());
        this.hashColumns.put("f_mon", getFMon());
        this.hashColumns.put("f_spcl_cgo_bb_flg", getFSpclCgoBbFlg());
        this.hashColumns.put("f_bkg_disp", getFBkgDisp());
        this.hashColumns.put("f_seldir", getFSeldir());
        this.hashColumns.put("f_sts_cd", getFStsCd());
        this.hashColumns.put("f_avg_suvgrp", getFAvgSuvgrp());
        this.hashColumns.put("f_strchkprd", getFStrchkprd());
        this.hashColumns.put("f_tar_mon", getFTarMon());
        this.hashColumns.put("f_vop_cd", getFVopCd());
        this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
        this.hashColumns.put("f_ias_rgn_cd", getFIasRgnCd());
        this.hashColumns.put("f_seltrade", getFSeltrade());
        this.hashColumns.put("f_strlane", getFStrlane());
        this.hashColumns.put("f_ecc", getFEcc());
        this.hashColumns.put("f_vsl_cd2", getFVslCd2());
        this.hashColumns.put("f_bkg_no_split", getFBkgNoSplit());
        this.hashColumns.put("f_selcapa", getFSelcapa());
        this.hashColumns.put("f_4th", getF4th());
        this.hashColumns.put("date_check_flag", getDateCheckFlag());
        this.hashColumns.put("f_locl_ts_sts_cd", getFLoclTsStsCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("f_svc_trns_prc_cnt_cd", "fSvcTrnsPrcCntCd");
        this.hashFields.put("f_cbo_rcc", "fCboRcc");
        this.hashFields.put("f_fm_mon", "fFmMon");
        this.hashFields.put("f_selclass", "fSelclass");
        this.hashFields.put("f_mas_cd", "fMasCd");
        this.hashFields.put("f_cobtrade", "fCobtrade");
        this.hashFields.put("f_mt_pu_yd_cd", "fMtPuYdCd");
        this.hashFields.put("f_pod_ecc_cd", "fPodEccCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("f_strtomonth", "fStrtomonth");
        this.hashFields.put("f_to", "fTo");
        this.hashFields.put("f_srep_cd", "fSrepCd");
        this.hashFields.put("f_vsl_cd", "fVslCd");
        this.hashFields.put("f_selcost", "fSelcost");
        this.hashFields.put("f_avg_grp_cd", "fAvgGrpCd");
        this.hashFields.put("f_ofc_team_cd", "fOfcTeamCd");
        this.hashFields.put("f_strtoweek", "fStrtoweek");
        this.hashFields.put("f_cost_use_tp_cd", "fCostUseTpCd");
        this.hashFields.put("f_rlane_cd", "fRlaneCd");
        this.hashFields.put("f_bkg_por_cd", "fBkgPorCd");
        this.hashFields.put("f_strvoyage", "fStrvoyage");
        this.hashFields.put("f_strfmmonth", "fStrfmmonth");
        this.hashFields.put("f_dividename", "fDividename");
        this.hashFields.put("f_chkprd", "fChkprd");
        this.hashFields.put("f_qtr", "fQtr");
        this.hashFields.put("f_tml_cd", "fTmlCd");
        this.hashFields.put("f_otr_regional_acct", "fOtrRegionalAcct");
        this.hashFields.put("f_soc_sts", "fSocSts");
        this.hashFields.put("f_local_acct", "fLocalAcct");
        this.hashFields.put("f_from_ecc", "fFromEcc");
        this.hashFields.put("f_sdate", "fSdate");
        this.hashFields.put("f_cust_seq", "fCustSeq");
        this.hashFields.put("f_cbotrade", "fCbotrade");
        this.hashFields.put("f_emon", "fEmon");
        this.hashFields.put("f_pro_vw", "fProVw");
        this.hashFields.put("f_yearmonth", "fYearmonth");
        this.hashFields.put("f_to_ecc_cd", "fToEccCd");
        this.hashFields.put("f_shpr", "fShpr");
        this.hashFields.put("f_shpr_cd", "fShprCd");
        this.hashFields.put("f_otr_strg_acct", "fOtrStrgAcct");
        this.hashFields.put("f_vessel", "fVessel");
        this.hashFields.put("f_from_ecc_cd", "fFromEccCd");
        this.hashFields.put("f_comm_loc_cd", "fCommLocCd");
        this.hashFields.put("f_por", "fPor");
        this.hashFields.put("f_rfa", "fRfa");
        this.hashFields.put("f_otr_rf_core_acct", "fOtrRfCoreAcct");
        this.hashFields.put("f_include_ts", "fIncludeTs");
        this.hashFields.put("f_fixed_rate", "fFixedRate");
        this.hashFields.put("f_ofc_cd", "fOfcCd");
        this.hashFields.put("f_sub_trd_cd", "fSubTrdCd");
        this.hashFields.put("f_lcc_cd", "fLccCd");
        this.hashFields.put("f_rfa_no", "fRfaNo");
        this.hashFields.put("f_sim_no", "fSimNo");
        this.hashFields.put("f_hul_bnd_cd", "fHulBndCd");
        this.hashFields.put("f_dir_cd", "fDirCd");
        this.hashFields.put("f_usa_bkg_mod_cd", "fUsaBkgModCd");
        this.hashFields.put("f_op_lane_tp_cd", "fOpLaneTpCd");
        this.hashFields.put("f_full_mty_cd", "fFullMtyCd");
        this.hashFields.put("f_mdm_charge_type_cd", "fMdmChargeTypeCd");
        this.hashFields.put("f_wk_sts", "fWkSts");
        this.hashFields.put("f_selrlane", "fSelrlane");
        this.hashFields.put("f_strtype", "fStrtype");
        this.hashFields.put("f_rev_yrmon", "fRevYrmon");
        this.hashFields.put("f_cobdir", "fCobdir");
        this.hashFields.put("f_mty_lcc_cd", "fMtyLccCd");
        this.hashFields.put("f_ofc_lvl", "fOfcLvl");
        this.hashFields.put("f_header", "fHeader");
        this.hashFields.put("f_ofc_vw", "fOfcVw");
        this.hashFields.put("f_spcl_cgo_awk_flg", "fSpclCgoAwkFlg");
        this.hashFields.put("f_sc_no", "fScNo");
        this.hashFields.put("f_usr_id", "fUsrId");
        this.hashFields.put("f_key_acct_group_cd", "fKeyAcctGroupCd");
        this.hashFields.put("f_to_wk", "fToWk");
        this.hashFields.put("f_spcl_cgo_dg_flg", "fSpclCgoDgFlg");
        this.hashFields.put("f_cboslane", "fCboslane");
        this.hashFields.put("f_h_dir_cd", "fHDirCd");
        this.hashFields.put("f_spcl_cgo_rf_flg", "fSpclCgoRfFlg");
        this.hashFields.put("f_strdir", "fStrdir");
        this.hashFields.put("f_chkprevcre", "fChkprevcre");
        this.hashFields.put("f_strfmweek", "fStrfmweek");
        this.hashFields.put("f_slan_cd", "fSlanCd");
        this.hashFields.put("f_from", "fFrom");
        this.hashFields.put("f_ecc_cd2", "fEccCd2");
        this.hashFields.put("f_act_grp_cd", "fActGrpCd");
        this.hashFields.put("f_chk_bsazrflg", "fChkBsazrflg");
        this.hashFields.put("f_voyage", "fVoyage");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("f_mty_rcc_cd", "fMtyRccCd");
        this.hashFields.put("f_x_lev", "fXLev");
        this.hashFields.put("f_chkdel", "fChkdel");
        this.hashFields.put("f_sls_ofc_cd", "fSlsOfcCd");
        this.hashFields.put("f_locl_curr_cd", "fLoclCurrCd");
        this.hashFields.put("f_cbo_lcc", "fCboLcc");
        this.hashFields.put("f_to_ecc", "fToEcc");
        this.hashFields.put("f_h_rlane_cd", "fHRlaneCd");
        this.hashFields.put("f_smon", "fSmon");
        this.hashFields.put("f_cost_loc_grp_cd", "fCostLocGrpCd");
        this.hashFields.put("f_ias_sub_grp_cd", "fIasSubGrpCd");
        this.hashFields.put("f_selioc", "fSelioc");
        this.hashFields.put("f_mlt_trd_group_cd", "fMltTrdGroupCd");
        this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
        this.hashFields.put("f_dir", "fDir");
        this.hashFields.put("f_cost_fm_mon", "fCostFmMon");
        this.hashFields.put("f_pol_pod_cd", "fPolPodCd");
        this.hashFields.put("f_calc_term_cd", "fCalcTermCd");
        this.hashFields.put("f_inout", "fInout");
        this.hashFields.put("istrade", "istrade");
        this.hashFields.put("f_selslane", "fSelslane");
        this.hashFields.put("f_rev_pod_cd", "fRevPodCd");
        this.hashFields.put("f_strvessel", "fStrvessel");
        this.hashFields.put("f_stryear", "fStryear");
        this.hashFields.put("f_1st", "f1st");
        this.hashFields.put("f_rd_ind", "fRdInd");
        this.hashFields.put("f_excl_sts", "fExclSts");
        this.hashFields.put("f_taa_no", "fTaaNo");
        this.hashFields.put("f_rcc_cd", "fRccCd");
        this.hashFields.put("f_h_ioc_cd", "fHIocCd");
        this.hashFields.put("f_dur", "fDur");
        this.hashFields.put("f_rf_core_acct_cd", "fRfCoreAcctCd");
        this.hashFields.put("f_wtr_term_cd", "fWtrTermCd");
        this.hashFields.put("f_strtrade", "fStrtrade");
        this.hashFields.put("f_savename", "fSavename");
        this.hashFields.put("f_excl_sub", "fExclSub");
        this.hashFields.put("f_cust_tp", "fCustTp");
        this.hashFields.put("f_bkg_pod_cd", "fBkgPodCd");
        this.hashFields.put("f_bkg_del_cd", "fBkgDelCd");
        this.hashFields.put("f_mdm_charge_cd", "fMdmChargeCd");
        this.hashFields.put("f_rout_no", "fRoutNo");
        this.hashFields.put("f_view_tpsz", "fViewTpsz");
        this.hashFields.put("f_bkg_pol_cd", "fBkgPolCd");
        this.hashFields.put("f_strprcnm", "fStrprcnm");
        this.hashFields.put("f_to_mon", "fToMon");
        this.hashFields.put("f_ra_acct_group_cd", "fRaAcctGroupCd");
        this.hashFields.put("f_sim", "fSim");
        this.hashFields.put("f_trd_cd", "fTrdCd");
        this.hashFields.put("f_sim_dt", "fSimDt");
        this.hashFields.put("f_bkg_sts", "fBkgSts");
        this.hashFields.put("f_mt_pu_cd", "fMtPuCd");
        this.hashFields.put("f_ioc_cd", "fIocCd");
        this.hashFields.put("f_eweek", "fEweek");
        this.hashFields.put("f_ecc_cd", "fEccCd");
        this.hashFields.put("f_selvessel", "fSelvessel");
        this.hashFields.put("f_rev_pol_cd", "fRevPolCd");
        this.hashFields.put("f_mty_ecc_cd", "fMtyEccCd");
        this.hashFields.put("f_type_cd", "fTypeCd");
        this.hashFields.put("f_coblane", "fCoblane");
        this.hashFields.put("f_uc_cd", "fUcCd");
        this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
        this.hashFields.put("f_del", "fDel");
        this.hashFields.put("f_ra_acct_indvl_cd", "fRaAcctIndvlCd");
        this.hashFields.put("f_otr_global_acct", "fOtrGlobalAcct");
        this.hashFields.put("f_src_mon", "fSrcMon");
        this.hashFields.put("f_ori_dest", "fOriDest");
        this.hashFields.put("f_lgs_kpi3_cd", "fLgsKpi3Cd");
        this.hashFields.put("f_group", "fGroup");
        this.hashFields.put("f_ttl_amt", "fTtlAmt");
        this.hashFields.put("f_bkg_no", "fBkgNo");
        this.hashFields.put("f_cost_yr", "fCostYr");
        this.hashFields.put("f_cust_cnt_cd", "fCustCntCd");
        this.hashFields.put("f_pro_lvl", "fProLvl");
        this.hashFields.put("f_sa_trd_indvl_cd", "fSaTrdIndvlCd");
        this.hashFields.put("f_h_trd_cd", "fHTrdCd");
        this.hashFields.put("f_shipper", "fShipper");
        this.hashFields.put("f_pod", "fPod");
        this.hashFields.put("f_yearweek", "fYearweek");
        this.hashFields.put("f_cobioc", "fCobioc");
        this.hashFields.put("f_yrtype", "fYrtype");
        this.hashFields.put("f_ofc_act_cd", "fOfcActCd");
        this.hashFields.put("f_3td", "f3td");
        this.hashFields.put("f_rhq_cd", "fRhqCd");
        this.hashFields.put("f_sls_mon", "fSlsMon");
        this.hashFields.put("f_key_acct_indvl_cd", "fKeyAcctIndvlCd");
        this.hashFields.put("f_loc_cd", "fLocCd");
        this.hashFields.put("f_cust_rhq_cd", "fCustRhqCd");
        this.hashFields.put("f_cmdt_cd", "fCmdtCd");
        this.hashFields.put("f_otr_key_acct", "fOtrKeyAcct");
        this.hashFields.put("f_op_view", "fOpView");
        this.hashFields.put("f_sa_trd_group_cd", "fSaTrdGroupCd");
        this.hashFields.put("f_crr_cd", "fCrrCd");
        this.hashFields.put("f_2nd", "f2nd");
        this.hashFields.put("f_selgroup", "fSelgroup");
        this.hashFields.put("f_sweek", "fSweek");
        this.hashFields.put("f_fm_wk", "fFmWk");
        this.hashFields.put("f_cobcost", "fCobcost");
        this.hashFields.put("f_spcl_cgo_cd", "fSpclCgoCd");
        this.hashFields.put("f_mlt_trd_indvl_cd", "fMltTrdIndvlCd");
        this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
        this.hashFields.put("f_dir_sts", "fDirSts");
        this.hashFields.put("f_wk_cd", "fWkCd");
        this.hashFields.put("f_headernm", "fHeadernm");
        this.hashFields.put("f_trd_sts", "fTrdSts");
        this.hashFields.put("f_trd_dir_cd", "fTrdDirCd");
        this.hashFields.put("f_loc", "fLoc");
        this.hashFields.put("f_pctl_no", "fPctlNo");
        this.hashFields.put("f_cbo_ecc", "fCboEcc");
        this.hashFields.put("f_year", "fYear");
        this.hashFields.put("f_mon", "fMon");
        this.hashFields.put("f_spcl_cgo_bb_flg", "fSpclCgoBbFlg");
        this.hashFields.put("f_bkg_disp", "fBkgDisp");
        this.hashFields.put("f_seldir", "fSeldir");
        this.hashFields.put("f_sts_cd", "fStsCd");
        this.hashFields.put("f_avg_suvgrp", "fAvgSuvgrp");
        this.hashFields.put("f_strchkprd", "fStrchkprd");
        this.hashFields.put("f_tar_mon", "fTarMon");
        this.hashFields.put("f_vop_cd", "fVopCd");
        this.hashFields.put("f_cost_yrmon", "fCostYrmon");
        this.hashFields.put("f_ias_rgn_cd", "fIasRgnCd");
        this.hashFields.put("f_seltrade", "fSeltrade");
        this.hashFields.put("f_strlane", "fStrlane");
        this.hashFields.put("f_ecc", "fEcc");
        this.hashFields.put("f_vsl_cd2", "fVslCd2");
        this.hashFields.put("f_bkg_no_split", "fBkgNoSplit");
        this.hashFields.put("f_selcapa", "fSelcapa");
        this.hashFields.put("f_4th", "f4th");
        this.hashFields.put("date_check_flag", "dateCheckFlag");
        this.hashFields.put("f_locl_ts_sts_cd", "fLoclTsStsCd");
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
	 * @return fMasCd
	 */
    public String getFMasCd() {
        return this.fMasCd;
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
	 * @return fMtPuYdCd
	 */
    public String getFMtPuYdCd() {
        return this.fMtPuYdCd;
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
	 * @return fSrepCd
	 */
    public String getFSrepCd() {
        return this.fSrepCd;
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
	 * @return fAvgGrpCd
	 */
    public String getFAvgGrpCd() {
        return this.fAvgGrpCd;
    }

    /**
	 * Column Info
	 * @return fOfcTeamCd
	 */
    public String getFOfcTeamCd() {
        return this.fOfcTeamCd;
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
	 * @return fCostUseTpCd
	 */
    public String getFCostUseTpCd() {
        return this.fCostUseTpCd;
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
	 * @return fStrvoyage
	 */
    public String getFStrvoyage() {
        return this.fStrvoyage;
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
	 * @return fDividename
	 */
    public String getFDividename() {
        return this.fDividename;
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
	 * @return fQtr
	 */
    public String getFQtr() {
        return this.fQtr;
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
	 * @return fOtrRegionalAcct
	 */
    public String getFOtrRegionalAcct() {
        return this.fOtrRegionalAcct;
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
	 * @return fLocalAcct
	 */
    public String getFLocalAcct() {
        return this.fLocalAcct;
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
	 * @return fSdate
	 */
    public String getFSdate() {
        return this.fSdate;
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
	 * @return fShpr
	 */
    public String getFShpr() {
        return this.fShpr;
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
	 * @return fOtrStrgAcct
	 */
    public String getFOtrStrgAcct() {
        return this.fOtrStrgAcct;
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
	 * @return fOtrRfCoreAcct
	 */
    public String getFOtrRfCoreAcct() {
        return this.fOtrRfCoreAcct;
    }

    /**
	 * Column Info
	 * @return fIncludeTs
	 */
    public String getFIncludeTs() {
        return this.fIncludeTs;
    }

    /**
	 * Column Info
	 * @return fFixedRate
	 */
    public String getFFixedRate() {
        return this.fFixedRate;
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
	 * @return fRfaNo
	 */
    public String getFRfaNo() {
        return this.fRfaNo;
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
	 * @return fHulBndCd
	 */
    public String getFHulBndCd() {
        return this.fHulBndCd;
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
	 * @return fFullMtyCd
	 */
    public String getFFullMtyCd() {
        return this.fFullMtyCd;
    }

    /**
	 * Column Info
	 * @return fMdmChargeTypeCd
	 */
    public String getFMdmChargeTypeCd() {
        return this.fMdmChargeTypeCd;
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
	 * @return fOfcLvl
	 */
    public String getFOfcLvl() {
        return this.fOfcLvl;
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
	 * @return fScNo
	 */
    public String getFScNo() {
        return this.fScNo;
    }

    /**
	 * Column Info
	 * @return fUsrId
	 */
    public String getFUsrId() {
        return this.fUsrId;
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
	 * @return fToWk
	 */
    public String getFToWk() {
        return this.fToWk;
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
	 * @return fCboslane
	 */
    public String getFCboslane() {
        return this.fCboslane;
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
	 * @return fActGrpCd
	 */
    public String getFActGrpCd() {
        return this.fActGrpCd;
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
	 * @return fVoyage
	 */
    public String getFVoyage() {
        return this.fVoyage;
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
	 * @return fXLev
	 */
    public String getFXLev() {
        return this.fXLev;
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
	 * @return fToEcc
	 */
    public String getFToEcc() {
        return this.fToEcc;
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
	 * @return fSmon
	 */
    public String getFSmon() {
        return this.fSmon;
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
	 * @return fIasSubGrpCd
	 */
    public String getFIasSubGrpCd() {
        return this.fIasSubGrpCd;
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
	 * @return fMltTrdGroupCd
	 */
    public String getFMltTrdGroupCd() {
        return this.fMltTrdGroupCd;
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
	 * @return fPolPodCd
	 */
    public String getFPolPodCd() {
        return this.fPolPodCd;
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
	 * @return fRdInd
	 */
    public String getFRdInd() {
        return this.fRdInd;
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
	 * @return fDur
	 */
    public String getFDur() {
        return this.fDur;
    }

    /**
	 * Column Info
	 * @return fRfCoreAcctCd
	 */
    public String getFRfCoreAcctCd() {
        return this.fRfCoreAcctCd;
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
	 * @return fSavename
	 */
    public String getFSavename() {
        return this.fSavename;
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
	 * @return fCustTp
	 */
    public String getFCustTp() {
        return this.fCustTp;
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
	 * @return fMdmChargeCd
	 */
    public String getFMdmChargeCd() {
        return this.fMdmChargeCd;
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
	 * @return fRaAcctGroupCd
	 */
    public String getFRaAcctGroupCd() {
        return this.fRaAcctGroupCd;
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
	 * @return fMtPuCd
	 */
    public String getFMtPuCd() {
        return this.fMtPuCd;
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
	 * @return fMtyEccCd
	 */
    public String getFMtyEccCd() {
        return this.fMtyEccCd;
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
	 * @return fUcCd
	 */
    public String getFUcCd() {
        return this.fUcCd;
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
	 * @return fDel
	 */
    public String getFDel() {
        return this.fDel;
    }

    /**
	 * Column Info
	 * @return fRaAcctIndvlCd
	 */
    public String getFRaAcctIndvlCd() {
        return this.fRaAcctIndvlCd;
    }

    /**
	 * Column Info
	 * @return fOtrGlobalAcct
	 */
    public String getFOtrGlobalAcct() {
        return this.fOtrGlobalAcct;
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
	 * @return fOriDest
	 */
    public String getFOriDest() {
        return this.fOriDest;
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
	 * @return fGroup
	 */
    public String getFGroup() {
        return this.fGroup;
    }

    /**
	 * Column Info
	 * @return fTtlAmt
	 */
    public String getFTtlAmt() {
        return this.fTtlAmt;
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
	 * @return fCostYr
	 */
    public String getFCostYr() {
        return this.fCostYr;
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
	 * @return fSaTrdIndvlCd
	 */
    public String getFSaTrdIndvlCd() {
        return this.fSaTrdIndvlCd;
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
	 * @return fPod
	 */
    public String getFPod() {
        return this.fPod;
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
	 * @return fYrtype
	 */
    public String getFYrtype() {
        return this.fYrtype;
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
	 * @return f3td
	 */
    public String getF3td() {
        return this.f3td;
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
	 * @return fCustRhqCd
	 */
    public String getFCustRhqCd() {
        return this.fCustRhqCd;
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
	 * @return fOtrKeyAcct
	 */
    public String getFOtrKeyAcct() {
        return this.fOtrKeyAcct;
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
	 * @return fSaTrdGroupCd
	 */
    public String getFSaTrdGroupCd() {
        return this.fSaTrdGroupCd;
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
	 * @return f2nd
	 */
    public String getF2nd() {
        return this.f2nd;
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
	 * @return fCobcost
	 */
    public String getFCobcost() {
        return this.fCobcost;
    }

    /**
	 * Column Info
	 * @return fSpclCgoCd
	 */
    public String getFSpclCgoCd() {
        return this.fSpclCgoCd;
    }

    /**
	 * Column Info
	 * @return fMltTrdIndvlCd
	 */
    public String getFMltTrdIndvlCd() {
        return this.fMltTrdIndvlCd;
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
	 * @return fHeadernm
	 */
    public String getFHeadernm() {
        return this.fHeadernm;
    }

    /**
	 * Column Info
	 * @return fTrdSts
	 */
    public String getFTrdSts() {
        return this.fTrdSts;
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
	 * @return fLoc
	 */
    public String getFLoc() {
        return this.fLoc;
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
	 * @return fMon
	 */
    public String getFMon() {
        return this.fMon;
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
	 * @return fBkgDisp
	 */
    public String getFBkgDisp() {
        return this.fBkgDisp;
    }

    /**
	 * Column Info
	 * @return fSeldir
	 */
    public String getFSeldir() {
        return this.fSeldir;
    }

    /**
	 * Column Info
	 * @return fStsCd
	 */
    public String getFStsCd() {
        return this.fStsCd;
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
	 * @return fStrchkprd
	 */
    public String getFStrchkprd() {
        return this.fStrchkprd;
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
	 * @return fVopCd
	 */
    public String getFVopCd() {
        return this.fVopCd;
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
	 * @return fEcc
	 */
    public String getFEcc() {
        return this.fEcc;
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
	 * @return fBkgNoSplit
	 */
    public String getFBkgNoSplit() {
        return this.fBkgNoSplit;
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
	 * @return f4th
	 */
    public String getF4th() {
        return this.f4th;
    }

    /**
	 * Column Info
	 * @return dateCheckFlag
	 */
    public String getDateCheckFlag() {
        return this.dateCheckFlag;
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
	 * @param fMasCd
	 */
    public void setFMasCd(String fMasCd) {
        this.fMasCd = fMasCd;
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
	 * @param fMtPuYdCd
	 */
    public void setFMtPuYdCd(String fMtPuYdCd) {
        this.fMtPuYdCd = fMtPuYdCd;
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
	 * @param fSrepCd
	 */
    public void setFSrepCd(String fSrepCd) {
        this.fSrepCd = fSrepCd;
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
	 * @param fAvgGrpCd
	 */
    public void setFAvgGrpCd(String fAvgGrpCd) {
        this.fAvgGrpCd = fAvgGrpCd;
    }

    /**
	 * Column Info
	 * @param fOfcTeamCd
	 */
    public void setFOfcTeamCd(String fOfcTeamCd) {
        this.fOfcTeamCd = fOfcTeamCd;
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
	 * @param fCostUseTpCd
	 */
    public void setFCostUseTpCd(String fCostUseTpCd) {
        this.fCostUseTpCd = fCostUseTpCd;
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
	 * @param fStrvoyage
	 */
    public void setFStrvoyage(String fStrvoyage) {
        this.fStrvoyage = fStrvoyage;
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
	 * @param fDividename
	 */
    public void setFDividename(String fDividename) {
        this.fDividename = fDividename;
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
	 * @param fQtr
	 */
    public void setFQtr(String fQtr) {
        this.fQtr = fQtr;
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
	 * @param fOtrRegionalAcct
	 */
    public void setFOtrRegionalAcct(String fOtrRegionalAcct) {
        this.fOtrRegionalAcct = fOtrRegionalAcct;
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
	 * @param fLocalAcct
	 */
    public void setFLocalAcct(String fLocalAcct) {
        this.fLocalAcct = fLocalAcct;
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
	 * @param fSdate
	 */
    public void setFSdate(String fSdate) {
        this.fSdate = fSdate;
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
	 * @param fShpr
	 */
    public void setFShpr(String fShpr) {
        this.fShpr = fShpr;
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
	 * @param fOtrStrgAcct
	 */
    public void setFOtrStrgAcct(String fOtrStrgAcct) {
        this.fOtrStrgAcct = fOtrStrgAcct;
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
	 * @param fOtrRfCoreAcct
	 */
    public void setFOtrRfCoreAcct(String fOtrRfCoreAcct) {
        this.fOtrRfCoreAcct = fOtrRfCoreAcct;
    }

    /**
	 * Column Info
	 * @param fIncludeTs
	 */
    public void setFIncludeTs(String fIncludeTs) {
        this.fIncludeTs = fIncludeTs;
    }

    /**
	 * Column Info
	 * @param fFixedRate
	 */
    public void setFFixedRate(String fFixedRate) {
        this.fFixedRate = fFixedRate;
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
	 * @param fRfaNo
	 */
    public void setFRfaNo(String fRfaNo) {
        this.fRfaNo = fRfaNo;
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
	 * @param fHulBndCd
	 */
    public void setFHulBndCd(String fHulBndCd) {
        this.fHulBndCd = fHulBndCd;
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
	 * @param fFullMtyCd
	 */
    public void setFFullMtyCd(String fFullMtyCd) {
        this.fFullMtyCd = fFullMtyCd;
    }

    /**
	 * Column Info
	 * @param fMdmChargeTypeCd
	 */
    public void setFMdmChargeTypeCd(String fMdmChargeTypeCd) {
        this.fMdmChargeTypeCd = fMdmChargeTypeCd;
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
	 * @param fOfcLvl
	 */
    public void setFOfcLvl(String fOfcLvl) {
        this.fOfcLvl = fOfcLvl;
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
	 * @param fScNo
	 */
    public void setFScNo(String fScNo) {
        this.fScNo = fScNo;
    }

    /**
	 * Column Info
	 * @param fUsrId
	 */
    public void setFUsrId(String fUsrId) {
        this.fUsrId = fUsrId;
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
	 * @param fToWk
	 */
    public void setFToWk(String fToWk) {
        this.fToWk = fToWk;
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
	 * @param fCboslane
	 */
    public void setFCboslane(String fCboslane) {
        this.fCboslane = fCboslane;
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
	 * @param fActGrpCd
	 */
    public void setFActGrpCd(String fActGrpCd) {
        this.fActGrpCd = fActGrpCd;
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
	 * @param fVoyage
	 */
    public void setFVoyage(String fVoyage) {
        this.fVoyage = fVoyage;
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
	 * @param fXLev
	 */
    public void setFXLev(String fXLev) {
        this.fXLev = fXLev;
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
	 * @param fToEcc
	 */
    public void setFToEcc(String fToEcc) {
        this.fToEcc = fToEcc;
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
	 * @param fSmon
	 */
    public void setFSmon(String fSmon) {
        this.fSmon = fSmon;
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
	 * @param fIasSubGrpCd
	 */
    public void setFIasSubGrpCd(String fIasSubGrpCd) {
        this.fIasSubGrpCd = fIasSubGrpCd;
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
	 * @param fMltTrdGroupCd
	 */
    public void setFMltTrdGroupCd(String fMltTrdGroupCd) {
        this.fMltTrdGroupCd = fMltTrdGroupCd;
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
	 * @param fPolPodCd
	 */
    public void setFPolPodCd(String fPolPodCd) {
        this.fPolPodCd = fPolPodCd;
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
	 * @param fRdInd
	 */
    public void setFRdInd(String fRdInd) {
        this.fRdInd = fRdInd;
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
	 * @param fDur
	 */
    public void setFDur(String fDur) {
        this.fDur = fDur;
    }

    /**
	 * Column Info
	 * @param fRfCoreAcctCd
	 */
    public void setFRfCoreAcctCd(String fRfCoreAcctCd) {
        this.fRfCoreAcctCd = fRfCoreAcctCd;
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
	 * @param fSavename
	 */
    public void setFSavename(String fSavename) {
        this.fSavename = fSavename;
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
	 * @param fCustTp
	 */
    public void setFCustTp(String fCustTp) {
        this.fCustTp = fCustTp;
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
	 * @param fMdmChargeCd
	 */
    public void setFMdmChargeCd(String fMdmChargeCd) {
        this.fMdmChargeCd = fMdmChargeCd;
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
	 * @param fRaAcctGroupCd
	 */
    public void setFRaAcctGroupCd(String fRaAcctGroupCd) {
        this.fRaAcctGroupCd = fRaAcctGroupCd;
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
	 * @param fMtPuCd
	 */
    public void setFMtPuCd(String fMtPuCd) {
        this.fMtPuCd = fMtPuCd;
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
	 * @param fMtyEccCd
	 */
    public void setFMtyEccCd(String fMtyEccCd) {
        this.fMtyEccCd = fMtyEccCd;
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
	 * @param fUcCd
	 */
    public void setFUcCd(String fUcCd) {
        this.fUcCd = fUcCd;
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
	 * @param fDel
	 */
    public void setFDel(String fDel) {
        this.fDel = fDel;
    }

    /**
	 * Column Info
	 * @param fRaAcctIndvlCd
	 */
    public void setFRaAcctIndvlCd(String fRaAcctIndvlCd) {
        this.fRaAcctIndvlCd = fRaAcctIndvlCd;
    }

    /**
	 * Column Info
	 * @param fOtrGlobalAcct
	 */
    public void setFOtrGlobalAcct(String fOtrGlobalAcct) {
        this.fOtrGlobalAcct = fOtrGlobalAcct;
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
	 * @param fOriDest
	 */
    public void setFOriDest(String fOriDest) {
        this.fOriDest = fOriDest;
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
	 * @param fGroup
	 */
    public void setFGroup(String fGroup) {
        this.fGroup = fGroup;
    }

    /**
	 * Column Info
	 * @param fTtlAmt
	 */
    public void setFTtlAmt(String fTtlAmt) {
        this.fTtlAmt = fTtlAmt;
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
	 * @param fCostYr
	 */
    public void setFCostYr(String fCostYr) {
        this.fCostYr = fCostYr;
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
	 * @param fSaTrdIndvlCd
	 */
    public void setFSaTrdIndvlCd(String fSaTrdIndvlCd) {
        this.fSaTrdIndvlCd = fSaTrdIndvlCd;
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
	 * @param fPod
	 */
    public void setFPod(String fPod) {
        this.fPod = fPod;
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
	 * @param fYrtype
	 */
    public void setFYrtype(String fYrtype) {
        this.fYrtype = fYrtype;
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
	 * @param f3td
	 */
    public void setF3td(String f3td) {
        this.f3td = f3td;
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
	 * @param fCustRhqCd
	 */
    public void setFCustRhqCd(String fCustRhqCd) {
        this.fCustRhqCd = fCustRhqCd;
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
	 * @param fOtrKeyAcct
	 */
    public void setFOtrKeyAcct(String fOtrKeyAcct) {
        this.fOtrKeyAcct = fOtrKeyAcct;
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
	 * @param fSaTrdGroupCd
	 */
    public void setFSaTrdGroupCd(String fSaTrdGroupCd) {
        this.fSaTrdGroupCd = fSaTrdGroupCd;
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
	 * @param f2nd
	 */
    public void setF2nd(String f2nd) {
        this.f2nd = f2nd;
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
	 * @param fCobcost
	 */
    public void setFCobcost(String fCobcost) {
        this.fCobcost = fCobcost;
    }

    /**
	 * Column Info
	 * @param fSpclCgoCd
	 */
    public void setFSpclCgoCd(String fSpclCgoCd) {
        this.fSpclCgoCd = fSpclCgoCd;
    }

    /**
	 * Column Info
	 * @param fMltTrdIndvlCd
	 */
    public void setFMltTrdIndvlCd(String fMltTrdIndvlCd) {
        this.fMltTrdIndvlCd = fMltTrdIndvlCd;
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
	 * @param fHeadernm
	 */
    public void setFHeadernm(String fHeadernm) {
        this.fHeadernm = fHeadernm;
    }

    /**
	 * Column Info
	 * @param fTrdSts
	 */
    public void setFTrdSts(String fTrdSts) {
        this.fTrdSts = fTrdSts;
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
	 * @param fLoc
	 */
    public void setFLoc(String fLoc) {
        this.fLoc = fLoc;
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
	 * @param fMon
	 */
    public void setFMon(String fMon) {
        this.fMon = fMon;
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
	 * @param fBkgDisp
	 */
    public void setFBkgDisp(String fBkgDisp) {
        this.fBkgDisp = fBkgDisp;
    }

    /**
	 * Column Info
	 * @param fSeldir
	 */
    public void setFSeldir(String fSeldir) {
        this.fSeldir = fSeldir;
    }

    /**
	 * Column Info
	 * @param fStsCd
	 */
    public void setFStsCd(String fStsCd) {
        this.fStsCd = fStsCd;
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
	 * @param fStrchkprd
	 */
    public void setFStrchkprd(String fStrchkprd) {
        this.fStrchkprd = fStrchkprd;
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
	 * @param fVopCd
	 */
    public void setFVopCd(String fVopCd) {
        this.fVopCd = fVopCd;
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
	 * @param fEcc
	 */
    public void setFEcc(String fEcc) {
        this.fEcc = fEcc;
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
	 * @param fBkgNoSplit
	 */
    public void setFBkgNoSplit(String fBkgNoSplit) {
        this.fBkgNoSplit = fBkgNoSplit;
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
	 * @param f4th
	 */
    public void setF4th(String f4th) {
        this.f4th = f4th;
    }

    /**
	 * Column Info
	 * @param dateCheckFlag
	 */
    public void setDateCheckFlag(String dateCheckFlag) {
        this.dateCheckFlag = dateCheckFlag;
    }

    public void setFLoclTsStsCd(String fLoclTsStsCd) {
        this.fLoclTsStsCd = fLoclTsStsCd;
    }

    public String getFLoclTsStsCd() {
        return this.fLoclTsStsCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setFSvcTrnsPrcCntCd(JSPUtil.getParameter(request, prefix + "f_svc_trns_prc_cnt_cd", ""));
        setFCboRcc(JSPUtil.getParameter(request, prefix + "f_cbo_rcc", ""));
        setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
        setFSelclass(JSPUtil.getParameter(request, prefix + "f_selclass", ""));
        setFMasCd(JSPUtil.getParameter(request, prefix + "f_mas_cd", ""));
        setFCobtrade(JSPUtil.getParameter(request, prefix + "f_cobtrade", ""));
        setFMtPuYdCd(JSPUtil.getParameter(request, prefix + "f_mt_pu_yd_cd", ""));
        setFPodEccCd(JSPUtil.getParameter(request, prefix + "f_pod_ecc_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFStrtomonth(JSPUtil.getParameter(request, prefix + "f_strtomonth", ""));
        setFTo(JSPUtil.getParameter(request, prefix + "f_to", ""));
        setFSrepCd(JSPUtil.getParameter(request, prefix + "f_srep_cd", ""));
        setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
        setFSelcost(JSPUtil.getParameter(request, prefix + "f_selcost", ""));
        setFAvgGrpCd(JSPUtil.getParameter(request, prefix + "f_avg_grp_cd", ""));
        setFOfcTeamCd(JSPUtil.getParameter(request, prefix + "f_ofc_team_cd", ""));
        setFStrtoweek(JSPUtil.getParameter(request, prefix + "f_strtoweek", ""));
        setFCostUseTpCd(JSPUtil.getParameter(request, prefix + "f_cost_use_tp_cd", ""));
        setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
        setFBkgPorCd(JSPUtil.getParameter(request, prefix + "f_bkg_por_cd", ""));
        setFStrvoyage(JSPUtil.getParameter(request, prefix + "f_strvoyage", ""));
        setFStrfmmonth(JSPUtil.getParameter(request, prefix + "f_strfmmonth", ""));
        setFDividename(JSPUtil.getParameter(request, prefix + "f_dividename", ""));
        setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
        setFQtr(JSPUtil.getParameter(request, prefix + "f_qtr", ""));
        setFTmlCd(JSPUtil.getParameter(request, prefix + "f_tml_cd", ""));
        setFOtrRegionalAcct(JSPUtil.getParameter(request, prefix + "f_otr_regional_acct", ""));
        setFSocSts(JSPUtil.getParameter(request, prefix + "f_soc_sts", ""));
        setFLocalAcct(JSPUtil.getParameter(request, prefix + "f_local_acct", ""));
        setFFromEcc(JSPUtil.getParameter(request, prefix + "f_from_ecc", ""));
        setFSdate(JSPUtil.getParameter(request, prefix + "f_sdate", ""));
        setFCustSeq(JSPUtil.getParameter(request, prefix + "f_cust_seq", ""));
        setFCbotrade(JSPUtil.getParameter(request, prefix + "f_cbotrade", ""));
        setFEmon(JSPUtil.getParameter(request, prefix + "f_emon", ""));
        setFProVw(JSPUtil.getParameter(request, prefix + "f_pro_vw", ""));
        setFYearmonth(JSPUtil.getParameter(request, prefix + "f_yearmonth", ""));
        setFToEccCd(JSPUtil.getParameter(request, prefix + "f_to_ecc_cd", ""));
        setFShpr(JSPUtil.getParameter(request, prefix + "f_shpr", ""));
        setFShprCd(JSPUtil.getParameter(request, prefix + "f_shpr_cd", ""));
        setFOtrStrgAcct(JSPUtil.getParameter(request, prefix + "f_otr_strg_acct", ""));
        setFVessel(JSPUtil.getParameter(request, prefix + "f_vessel", ""));
        setFFromEccCd(JSPUtil.getParameter(request, prefix + "f_from_ecc_cd", ""));
        setFCommLocCd(JSPUtil.getParameter(request, prefix + "f_comm_loc_cd", ""));
        setFPor(JSPUtil.getParameter(request, prefix + "f_por", ""));
        setFRfa(JSPUtil.getParameter(request, prefix + "f_rfa", ""));
        setFOtrRfCoreAcct(JSPUtil.getParameter(request, prefix + "f_otr_rf_core_acct", ""));
        setFIncludeTs(JSPUtil.getParameter(request, prefix + "f_include_ts", ""));
        setFFixedRate(JSPUtil.getParameter(request, prefix + "f_fixed_rate", ""));
        setFOfcCd(JSPUtil.getParameter(request, prefix + "f_ofc_cd", ""));
        setFSubTrdCd(JSPUtil.getParameter(request, prefix + "f_sub_trd_cd", ""));
        setFLccCd(JSPUtil.getParameter(request, prefix + "f_lcc_cd", ""));
        setFRfaNo(JSPUtil.getParameter(request, prefix + "f_rfa_no", ""));
        setFSimNo(JSPUtil.getParameter(request, prefix + "f_sim_no", ""));
        setFHulBndCd(JSPUtil.getParameter(request, prefix + "f_hul_bnd_cd", ""));
        setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
        setFUsaBkgModCd(JSPUtil.getParameter(request, prefix + "f_usa_bkg_mod_cd", ""));
        setFOpLaneTpCd(JSPUtil.getParameter(request, prefix + "f_op_lane_tp_cd", ""));
        setFFullMtyCd(JSPUtil.getParameter(request, prefix + "f_full_mty_cd", ""));
        setFMdmChargeTypeCd(JSPUtil.getParameter(request, prefix + "f_mdm_charge_type_cd", ""));
        setFWkSts(JSPUtil.getParameter(request, prefix + "f_wk_sts", ""));
        setFSelrlane(JSPUtil.getParameter(request, prefix + "f_selrlane", ""));
        setFStrtype(JSPUtil.getParameter(request, prefix + "f_strtype", ""));
        setFRevYrmon(JSPUtil.getParameter(request, prefix + "f_rev_yrmon", ""));
        setFCobdir(JSPUtil.getParameter(request, prefix + "f_cobdir", ""));
        setFMtyLccCd(JSPUtil.getParameter(request, prefix + "f_mty_lcc_cd", ""));
        setFOfcLvl(JSPUtil.getParameter(request, prefix + "f_ofc_lvl", ""));
        setFHeader(JSPUtil.getParameter(request, prefix + "f_header", ""));
        setFOfcVw(JSPUtil.getParameter(request, prefix + "f_ofc_vw", ""));
        setFSpclCgoAwkFlg(JSPUtil.getParameter(request, prefix + "f_spcl_cgo_awk_flg", ""));
        setFScNo(JSPUtil.getParameter(request, prefix + "f_sc_no", ""));
        setFUsrId(JSPUtil.getParameter(request, prefix + "f_usr_id", ""));
        setFKeyAcctGroupCd(JSPUtil.getParameter(request, prefix + "f_key_acct_group_cd", ""));
        setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
        setFSpclCgoDgFlg(JSPUtil.getParameter(request, prefix + "f_spcl_cgo_dg_flg", ""));
        setFCboslane(JSPUtil.getParameter(request, prefix + "f_cboslane", ""));
        setFHDirCd(JSPUtil.getParameter(request, prefix + "f_h_dir_cd", ""));
        setFSpclCgoRfFlg(JSPUtil.getParameter(request, prefix + "f_spcl_cgo_rf_flg", ""));
        setFStrdir(JSPUtil.getParameter(request, prefix + "f_strdir", ""));
        setFChkprevcre(JSPUtil.getParameter(request, prefix + "f_chkprevcre", ""));
        setFStrfmweek(JSPUtil.getParameter(request, prefix + "f_strfmweek", ""));
        setFSlanCd(JSPUtil.getParameter(request, prefix + "f_slan_cd", ""));
        setFFrom(JSPUtil.getParameter(request, prefix + "f_from", ""));
        setFEccCd2(JSPUtil.getParameter(request, prefix + "f_ecc_cd2", ""));
        setFActGrpCd(JSPUtil.getParameter(request, prefix + "f_act_grp_cd", ""));
        setFChkBsazrflg(JSPUtil.getParameter(request, prefix + "f_chk_bsazrflg", ""));
        setFVoyage(JSPUtil.getParameter(request, prefix + "f_voyage", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setFMtyRccCd(JSPUtil.getParameter(request, prefix + "f_mty_rcc_cd", ""));
        setFXLev(JSPUtil.getParameter(request, prefix + "f_x_lev", ""));
        setFChkdel(JSPUtil.getParameter(request, prefix + "f_chkdel", ""));
        setFSlsOfcCd(JSPUtil.getParameter(request, prefix + "f_sls_ofc_cd", ""));
        setFLoclCurrCd(JSPUtil.getParameter(request, prefix + "f_locl_curr_cd", ""));
        setFCboLcc(JSPUtil.getParameter(request, prefix + "f_cbo_lcc", ""));
        setFToEcc(JSPUtil.getParameter(request, prefix + "f_to_ecc", ""));
        setFHRlaneCd(JSPUtil.getParameter(request, prefix + "f_h_rlane_cd", ""));
        setFSmon(JSPUtil.getParameter(request, prefix + "f_smon", ""));
        setFCostLocGrpCd(JSPUtil.getParameter(request, prefix + "f_cost_loc_grp_cd", ""));
        setFIasSubGrpCd(JSPUtil.getParameter(request, prefix + "f_ias_sub_grp_cd", ""));
        setFSelioc(JSPUtil.getParameter(request, prefix + "f_selioc", ""));
        setFMltTrdGroupCd(JSPUtil.getParameter(request, prefix + "f_mlt_trd_group_cd", ""));
        setFSkdDirCd(JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", ""));
        setFDir(JSPUtil.getParameter(request, prefix + "f_dir", ""));
        setFCostFmMon(JSPUtil.getParameter(request, prefix + "f_cost_fm_mon", ""));
        setFPolPodCd(JSPUtil.getParameter(request, prefix + "f_pol_pod_cd", ""));
        setFCalcTermCd(JSPUtil.getParameter(request, prefix + "f_calc_term_cd", ""));
        setFInout(JSPUtil.getParameter(request, prefix + "f_inout", ""));
        setIstrade(JSPUtil.getParameter(request, prefix + "istrade", ""));
        setFSelslane(JSPUtil.getParameter(request, prefix + "f_selslane", ""));
        setFRevPodCd(JSPUtil.getParameter(request, prefix + "f_rev_pod_cd", ""));
        setFStrvessel(JSPUtil.getParameter(request, prefix + "f_strvessel", ""));
        setFStryear(JSPUtil.getParameter(request, prefix + "f_stryear", ""));
        setF1st(JSPUtil.getParameter(request, prefix + "f_1st", ""));
        setFRdInd(JSPUtil.getParameter(request, prefix + "f_rd_ind", ""));
        setFExclSts(JSPUtil.getParameter(request, prefix + "f_excl_sts", ""));
        setFTaaNo(JSPUtil.getParameter(request, prefix + "f_taa_no", ""));
        setFRccCd(JSPUtil.getParameter(request, prefix + "f_rcc_cd", ""));
        setFHIocCd(JSPUtil.getParameter(request, prefix + "f_h_ioc_cd", ""));
        setFDur(JSPUtil.getParameter(request, prefix + "f_dur", ""));
        setFRfCoreAcctCd(JSPUtil.getParameter(request, prefix + "f_rf_core_acct_cd", ""));
        setFWtrTermCd(JSPUtil.getParameter(request, prefix + "f_wtr_term_cd", ""));
        setFStrtrade(JSPUtil.getParameter(request, prefix + "f_strtrade", ""));
        setFSavename(JSPUtil.getParameter(request, prefix + "f_savename", ""));
        setFExclSub(JSPUtil.getParameter(request, prefix + "f_excl_sub", ""));
        setFCustTp(JSPUtil.getParameter(request, prefix + "f_cust_tp", ""));
        setFBkgPodCd(JSPUtil.getParameter(request, prefix + "f_bkg_pod_cd", ""));
        setFBkgDelCd(JSPUtil.getParameter(request, prefix + "f_bkg_del_cd", ""));
        setFMdmChargeCd(JSPUtil.getParameter(request, prefix + "f_mdm_charge_cd", ""));
        setFRoutNo(JSPUtil.getParameter(request, prefix + "f_rout_no", ""));
        setFViewTpsz(JSPUtil.getParameter(request, prefix + "f_view_tpsz", ""));
        setFBkgPolCd(JSPUtil.getParameter(request, prefix + "f_bkg_pol_cd", ""));
        setFStrprcnm(JSPUtil.getParameter(request, prefix + "f_strprcnm", ""));
        setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
        setFRaAcctGroupCd(JSPUtil.getParameter(request, prefix + "f_ra_acct_group_cd", ""));
        setFSim(JSPUtil.getParameter(request, prefix + "f_sim", ""));
        setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
        setFSimDt(JSPUtil.getParameter(request, prefix + "f_sim_dt", ""));
        setFBkgSts(JSPUtil.getParameter(request, prefix + "f_bkg_sts", ""));
        setFMtPuCd(JSPUtil.getParameter(request, prefix + "f_mt_pu_cd", ""));
        setFIocCd(JSPUtil.getParameter(request, prefix + "f_ioc_cd", ""));
        setFEweek(JSPUtil.getParameter(request, prefix + "f_eweek", ""));
        setFEccCd(JSPUtil.getParameter(request, prefix + "f_ecc_cd", ""));
        setFSelvessel(JSPUtil.getParameter(request, prefix + "f_selvessel", ""));
        setFRevPolCd(JSPUtil.getParameter(request, prefix + "f_rev_pol_cd", ""));
        setFMtyEccCd(JSPUtil.getParameter(request, prefix + "f_mty_ecc_cd", ""));
        setFTypeCd(JSPUtil.getParameter(request, prefix + "f_type_cd", ""));
        setFCoblane(JSPUtil.getParameter(request, prefix + "f_coblane", ""));
        setFUcCd(JSPUtil.getParameter(request, prefix + "f_uc_cd", ""));
        setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
        setFDel(JSPUtil.getParameter(request, prefix + "f_del", ""));
        setFRaAcctIndvlCd(JSPUtil.getParameter(request, prefix + "f_ra_acct_indvl_cd", ""));
        setFOtrGlobalAcct(JSPUtil.getParameter(request, prefix + "f_otr_global_acct", ""));
        setFSrcMon(JSPUtil.getParameter(request, prefix + "f_src_mon", ""));
        setFOriDest(JSPUtil.getParameter(request, prefix + "f_ori_dest", ""));
        setFLgsKpi3Cd(JSPUtil.getParameter(request, prefix + "f_lgs_kpi3_cd", ""));
        setFGroup(JSPUtil.getParameter(request, prefix + "f_group", ""));
        setFTtlAmt(JSPUtil.getParameter(request, prefix + "f_ttl_amt", ""));
        setFBkgNo(JSPUtil.getParameter(request, prefix + "f_bkg_no", ""));
        setFCostYr(JSPUtil.getParameter(request, prefix + "f_cost_yr", ""));
        setFCustCntCd(JSPUtil.getParameter(request, prefix + "f_cust_cnt_cd", ""));
        setFProLvl(JSPUtil.getParameter(request, prefix + "f_pro_lvl", ""));
        setFSaTrdIndvlCd(JSPUtil.getParameter(request, prefix + "f_sa_trd_indvl_cd", ""));
        setFHTrdCd(JSPUtil.getParameter(request, prefix + "f_h_trd_cd", ""));
        setFShipper(JSPUtil.getParameter(request, prefix + "f_shipper", ""));
        setFPod(JSPUtil.getParameter(request, prefix + "f_pod", ""));
        setFYearweek(JSPUtil.getParameter(request, prefix + "f_yearweek", ""));
        setFCobioc(JSPUtil.getParameter(request, prefix + "f_cobioc", ""));
        setFYrtype(JSPUtil.getParameter(request, prefix + "f_yrtype", ""));
        setFOfcActCd(JSPUtil.getParameter(request, prefix + "f_ofc_act_cd", ""));
        setF3td(JSPUtil.getParameter(request, prefix + "f_3td", ""));
        setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
        setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
        setFKeyAcctIndvlCd(JSPUtil.getParameter(request, prefix + "f_key_acct_indvl_cd", ""));
        setFLocCd(JSPUtil.getParameter(request, prefix + "f_loc_cd", ""));
        setFCustRhqCd(JSPUtil.getParameter(request, prefix + "f_cust_rhq_cd", ""));
        setFCmdtCd(JSPUtil.getParameter(request, prefix + "f_cmdt_cd", ""));
        setFOtrKeyAcct(JSPUtil.getParameter(request, prefix + "f_otr_key_acct", ""));
        setFOpView(JSPUtil.getParameter(request, prefix + "f_op_view", ""));
        setFSaTrdGroupCd(JSPUtil.getParameter(request, prefix + "f_sa_trd_group_cd", ""));
        setFCrrCd(JSPUtil.getParameter(request, prefix + "f_crr_cd", ""));
        setF2nd(JSPUtil.getParameter(request, prefix + "f_2nd", ""));
        setFSelgroup(JSPUtil.getParameter(request, prefix + "f_selgroup", ""));
        setFSweek(JSPUtil.getParameter(request, prefix + "f_sweek", ""));
        setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
        setFCobcost(JSPUtil.getParameter(request, prefix + "f_cobcost", ""));
        setFSpclCgoCd(JSPUtil.getParameter(request, prefix + "f_spcl_cgo_cd", ""));
        setFMltTrdIndvlCd(JSPUtil.getParameter(request, prefix + "f_mlt_trd_indvl_cd", ""));
        setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
        setFDirSts(JSPUtil.getParameter(request, prefix + "f_dir_sts", ""));
        setFWkCd(JSPUtil.getParameter(request, prefix + "f_wk_cd", ""));
        setFHeadernm(JSPUtil.getParameter(request, prefix + "f_headernm", ""));
        setFTrdSts(JSPUtil.getParameter(request, prefix + "f_trd_sts", ""));
        setFTrdDirCd(JSPUtil.getParameter(request, prefix + "f_trd_dir_cd", ""));
        setFLoc(JSPUtil.getParameter(request, prefix + "f_loc", ""));
        setFPctlNo(JSPUtil.getParameter(request, prefix + "f_pctl_no", ""));
        setFCboEcc(JSPUtil.getParameter(request, prefix + "f_cbo_ecc", ""));
        setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
        setFMon(JSPUtil.getParameter(request, prefix + "f_mon", ""));
        setFSpclCgoBbFlg(JSPUtil.getParameter(request, prefix + "f_spcl_cgo_bb_flg", ""));
        setFBkgDisp(JSPUtil.getParameter(request, prefix + "f_bkg_disp", ""));
        setFSeldir(JSPUtil.getParameter(request, prefix + "f_seldir", ""));
        setFStsCd(JSPUtil.getParameter(request, prefix + "f_sts_cd", ""));
        setFAvgSuvgrp(JSPUtil.getParameter(request, prefix + "f_avg_suvgrp", ""));
        setFStrchkprd(JSPUtil.getParameter(request, prefix + "f_strchkprd", ""));
        setFTarMon(JSPUtil.getParameter(request, prefix + "f_tar_mon", ""));
        setFVopCd(JSPUtil.getParameter(request, prefix + "f_vop_cd", ""));
        setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
        setFIasRgnCd(JSPUtil.getParameter(request, prefix + "f_ias_rgn_cd", ""));
        setFSeltrade(JSPUtil.getParameter(request, prefix + "f_seltrade", ""));
        setFStrlane(JSPUtil.getParameter(request, prefix + "f_strlane", ""));
        setFEcc(JSPUtil.getParameter(request, prefix + "f_ecc", ""));
        setFVslCd2(JSPUtil.getParameter(request, prefix + "f_vsl_cd2", ""));
        setFBkgNoSplit(JSPUtil.getParameter(request, prefix + "f_bkg_no_split", ""));
        setFSelcapa(JSPUtil.getParameter(request, prefix + "f_selcapa", ""));
        setF4th(JSPUtil.getParameter(request, prefix + "f_4th", ""));
        setFLoclTsStsCd(JSPUtil.getParameter(request, prefix + "f_locl_ts_sts_cd", ""));
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
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] fSvcTrnsPrcCntCd = (JSPUtil.getParameter(request, prefix + "f_svc_trns_prc_cnt_cd", length));
            String[] fCboRcc = (JSPUtil.getParameter(request, prefix + "f_cbo_rcc", length));
            String[] fFmMon = (JSPUtil.getParameter(request, prefix + "f_fm_mon", length));
            String[] fSelclass = (JSPUtil.getParameter(request, prefix + "f_selclass", length));
            String[] fMasCd = (JSPUtil.getParameter(request, prefix + "f_mas_cd", length));
            String[] fCobtrade = (JSPUtil.getParameter(request, prefix + "f_cobtrade", length));
            String[] fMtPuYdCd = (JSPUtil.getParameter(request, prefix + "f_mt_pu_yd_cd", length));
            String[] fPodEccCd = (JSPUtil.getParameter(request, prefix + "f_pod_ecc_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fStrtomonth = (JSPUtil.getParameter(request, prefix + "f_strtomonth", length));
            String[] fTo = (JSPUtil.getParameter(request, prefix + "f_to", length));
            String[] fSrepCd = (JSPUtil.getParameter(request, prefix + "f_srep_cd", length));
            String[] fVslCd = (JSPUtil.getParameter(request, prefix + "f_vsl_cd", length));
            String[] fSelcost = (JSPUtil.getParameter(request, prefix + "f_selcost", length));
            String[] fAvgGrpCd = (JSPUtil.getParameter(request, prefix + "f_avg_grp_cd", length));
            String[] fOfcTeamCd = (JSPUtil.getParameter(request, prefix + "f_ofc_team_cd", length));
            String[] fStrtoweek = (JSPUtil.getParameter(request, prefix + "f_strtoweek", length));
            String[] fCostUseTpCd = (JSPUtil.getParameter(request, prefix + "f_cost_use_tp_cd", length));
            String[] fRlaneCd = (JSPUtil.getParameter(request, prefix + "f_rlane_cd", length));
            String[] fBkgPorCd = (JSPUtil.getParameter(request, prefix + "f_bkg_por_cd", length));
            String[] fStrvoyage = (JSPUtil.getParameter(request, prefix + "f_strvoyage", length));
            String[] fStrfmmonth = (JSPUtil.getParameter(request, prefix + "f_strfmmonth", length));
            String[] fDividename = (JSPUtil.getParameter(request, prefix + "f_dividename", length));
            String[] fChkprd = (JSPUtil.getParameter(request, prefix + "f_chkprd", length));
            String[] fQtr = (JSPUtil.getParameter(request, prefix + "f_qtr", length));
            String[] fTmlCd = (JSPUtil.getParameter(request, prefix + "f_tml_cd", length));
            String[] fOtrRegionalAcct = (JSPUtil.getParameter(request, prefix + "f_otr_regional_acct", length));
            String[] fSocSts = (JSPUtil.getParameter(request, prefix + "f_soc_sts", length));
            String[] fLocalAcct = (JSPUtil.getParameter(request, prefix + "f_local_acct", length));
            String[] fFromEcc = (JSPUtil.getParameter(request, prefix + "f_from_ecc", length));
            String[] fSdate = (JSPUtil.getParameter(request, prefix + "f_sdate", length));
            String[] fCustSeq = (JSPUtil.getParameter(request, prefix + "f_cust_seq", length));
            String[] fCbotrade = (JSPUtil.getParameter(request, prefix + "f_cbotrade", length));
            String[] fEmon = (JSPUtil.getParameter(request, prefix + "f_emon", length));
            String[] fProVw = (JSPUtil.getParameter(request, prefix + "f_pro_vw", length));
            String[] fYearmonth = (JSPUtil.getParameter(request, prefix + "f_yearmonth", length));
            String[] fToEccCd = (JSPUtil.getParameter(request, prefix + "f_to_ecc_cd", length));
            String[] fShpr = (JSPUtil.getParameter(request, prefix + "f_shpr", length));
            String[] fShprCd = (JSPUtil.getParameter(request, prefix + "f_shpr_cd", length));
            String[] fOtrStrgAcct = (JSPUtil.getParameter(request, prefix + "f_otr_strg_acct", length));
            String[] fVessel = (JSPUtil.getParameter(request, prefix + "f_vessel", length));
            String[] fFromEccCd = (JSPUtil.getParameter(request, prefix + "f_from_ecc_cd", length));
            String[] fCommLocCd = (JSPUtil.getParameter(request, prefix + "f_comm_loc_cd", length));
            String[] fPor = (JSPUtil.getParameter(request, prefix + "f_por", length));
            String[] fRfa = (JSPUtil.getParameter(request, prefix + "f_rfa", length));
            String[] fOtrRfCoreAcct = (JSPUtil.getParameter(request, prefix + "f_otr_rf_core_acct", length));
            String[] fIncludeTs = (JSPUtil.getParameter(request, prefix + "f_include_ts", length));
            String[] fFixedRate = (JSPUtil.getParameter(request, prefix + "f_fixed_rate", length));
            String[] fOfcCd = (JSPUtil.getParameter(request, prefix + "f_ofc_cd", length));
            String[] fSubTrdCd = (JSPUtil.getParameter(request, prefix + "f_sub_trd_cd", length));
            String[] fLccCd = (JSPUtil.getParameter(request, prefix + "f_lcc_cd", length));
            String[] fRfaNo = (JSPUtil.getParameter(request, prefix + "f_rfa_no", length));
            String[] fSimNo = (JSPUtil.getParameter(request, prefix + "f_sim_no", length));
            String[] fHulBndCd = (JSPUtil.getParameter(request, prefix + "f_hul_bnd_cd", length));
            String[] fDirCd = (JSPUtil.getParameter(request, prefix + "f_dir_cd", length));
            String[] fUsaBkgModCd = (JSPUtil.getParameter(request, prefix + "f_usa_bkg_mod_cd", length));
            String[] fOpLaneTpCd = (JSPUtil.getParameter(request, prefix + "f_op_lane_tp_cd", length));
            String[] fFullMtyCd = (JSPUtil.getParameter(request, prefix + "f_full_mty_cd", length));
            String[] fMdmChargeTypeCd = (JSPUtil.getParameter(request, prefix + "f_mdm_charge_type_cd", length));
            String[] fWkSts = (JSPUtil.getParameter(request, prefix + "f_wk_sts", length));
            String[] fSelrlane = (JSPUtil.getParameter(request, prefix + "f_selrlane", length));
            String[] fStrtype = (JSPUtil.getParameter(request, prefix + "f_strtype", length));
            String[] fRevYrmon = (JSPUtil.getParameter(request, prefix + "f_rev_yrmon", length));
            String[] fCobdir = (JSPUtil.getParameter(request, prefix + "f_cobdir", length));
            String[] fMtyLccCd = (JSPUtil.getParameter(request, prefix + "f_mty_lcc_cd", length));
            String[] fOfcLvl = (JSPUtil.getParameter(request, prefix + "f_ofc_lvl", length));
            String[] fHeader = (JSPUtil.getParameter(request, prefix + "f_header", length));
            String[] fOfcVw = (JSPUtil.getParameter(request, prefix + "f_ofc_vw", length));
            String[] fSpclCgoAwkFlg = (JSPUtil.getParameter(request, prefix + "f_spcl_cgo_awk_flg", length));
            String[] fScNo = (JSPUtil.getParameter(request, prefix + "f_sc_no", length));
            String[] fUsrId = (JSPUtil.getParameter(request, prefix + "f_usr_id", length));
            String[] fKeyAcctGroupCd = (JSPUtil.getParameter(request, prefix + "f_key_acct_group_cd", length));
            String[] fToWk = (JSPUtil.getParameter(request, prefix + "f_to_wk", length));
            String[] fSpclCgoDgFlg = (JSPUtil.getParameter(request, prefix + "f_spcl_cgo_dg_flg", length));
            String[] fCboslane = (JSPUtil.getParameter(request, prefix + "f_cboslane", length));
            String[] fHDirCd = (JSPUtil.getParameter(request, prefix + "f_h_dir_cd", length));
            String[] fSpclCgoRfFlg = (JSPUtil.getParameter(request, prefix + "f_spcl_cgo_rf_flg", length));
            String[] fStrdir = (JSPUtil.getParameter(request, prefix + "f_strdir", length));
            String[] fChkprevcre = (JSPUtil.getParameter(request, prefix + "f_chkprevcre", length));
            String[] fStrfmweek = (JSPUtil.getParameter(request, prefix + "f_strfmweek", length));
            String[] fSlanCd = (JSPUtil.getParameter(request, prefix + "f_slan_cd", length));
            String[] fFrom = (JSPUtil.getParameter(request, prefix + "f_from", length));
            String[] fEccCd2 = (JSPUtil.getParameter(request, prefix + "f_ecc_cd2", length));
            String[] fActGrpCd = (JSPUtil.getParameter(request, prefix + "f_act_grp_cd", length));
            String[] fChkBsazrflg = (JSPUtil.getParameter(request, prefix + "f_chk_bsazrflg", length));
            String[] fVoyage = (JSPUtil.getParameter(request, prefix + "f_voyage", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] fMtyRccCd = (JSPUtil.getParameter(request, prefix + "f_mty_rcc_cd", length));
            String[] fXLev = (JSPUtil.getParameter(request, prefix + "f_x_lev", length));
            String[] fChkdel = (JSPUtil.getParameter(request, prefix + "f_chkdel", length));
            String[] fSlsOfcCd = (JSPUtil.getParameter(request, prefix + "f_sls_ofc_cd", length));
            String[] fLoclCurrCd = (JSPUtil.getParameter(request, prefix + "f_locl_curr_cd", length));
            String[] fCboLcc = (JSPUtil.getParameter(request, prefix + "f_cbo_lcc", length));
            String[] fToEcc = (JSPUtil.getParameter(request, prefix + "f_to_ecc", length));
            String[] fHRlaneCd = (JSPUtil.getParameter(request, prefix + "f_h_rlane_cd", length));
            String[] fSmon = (JSPUtil.getParameter(request, prefix + "f_smon", length));
            String[] fCostLocGrpCd = (JSPUtil.getParameter(request, prefix + "f_cost_loc_grp_cd", length));
            String[] fIasSubGrpCd = (JSPUtil.getParameter(request, prefix + "f_ias_sub_grp_cd", length));
            String[] fSelioc = (JSPUtil.getParameter(request, prefix + "f_selioc", length));
            String[] fMltTrdGroupCd = (JSPUtil.getParameter(request, prefix + "f_mlt_trd_group_cd", length));
            String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", length));
            String[] fDir = (JSPUtil.getParameter(request, prefix + "f_dir", length));
            String[] fCostFmMon = (JSPUtil.getParameter(request, prefix + "f_cost_fm_mon", length));
            String[] fPolPodCd = (JSPUtil.getParameter(request, prefix + "f_pol_pod_cd", length));
            String[] fCalcTermCd = (JSPUtil.getParameter(request, prefix + "f_calc_term_cd", length));
            String[] fInout = (JSPUtil.getParameter(request, prefix + "f_inout", length));
            String[] istrade = (JSPUtil.getParameter(request, prefix + "istrade", length));
            String[] fSelslane = (JSPUtil.getParameter(request, prefix + "f_selslane", length));
            String[] fRevPodCd = (JSPUtil.getParameter(request, prefix + "f_rev_pod_cd", length));
            String[] fStrvessel = (JSPUtil.getParameter(request, prefix + "f_strvessel", length));
            String[] fStryear = (JSPUtil.getParameter(request, prefix + "f_stryear", length));
            String[] f1st = (JSPUtil.getParameter(request, prefix + "f_1st", length));
            String[] fRdInd = (JSPUtil.getParameter(request, prefix + "f_rd_ind", length));
            String[] fExclSts = (JSPUtil.getParameter(request, prefix + "f_excl_sts", length));
            String[] fTaaNo = (JSPUtil.getParameter(request, prefix + "f_taa_no", length));
            String[] fRccCd = (JSPUtil.getParameter(request, prefix + "f_rcc_cd", length));
            String[] fHIocCd = (JSPUtil.getParameter(request, prefix + "f_h_ioc_cd", length));
            String[] fDur = (JSPUtil.getParameter(request, prefix + "f_dur", length));
            String[] fRfCoreAcctCd = (JSPUtil.getParameter(request, prefix + "f_rf_core_acct_cd", length));
            String[] fWtrTermCd = (JSPUtil.getParameter(request, prefix + "f_wtr_term_cd", length));
            String[] fStrtrade = (JSPUtil.getParameter(request, prefix + "f_strtrade", length));
            String[] fSavename = (JSPUtil.getParameter(request, prefix + "f_savename", length));
            String[] fExclSub = (JSPUtil.getParameter(request, prefix + "f_excl_sub", length));
            String[] fCustTp = (JSPUtil.getParameter(request, prefix + "f_cust_tp", length));
            String[] fBkgPodCd = (JSPUtil.getParameter(request, prefix + "f_bkg_pod_cd", length));
            String[] fBkgDelCd = (JSPUtil.getParameter(request, prefix + "f_bkg_del_cd", length));
            String[] fMdmChargeCd = (JSPUtil.getParameter(request, prefix + "f_mdm_charge_cd", length));
            String[] fRoutNo = (JSPUtil.getParameter(request, prefix + "f_rout_no", length));
            String[] fViewTpsz = (JSPUtil.getParameter(request, prefix + "f_view_tpsz", length));
            String[] fBkgPolCd = (JSPUtil.getParameter(request, prefix + "f_bkg_pol_cd", length));
            String[] fStrprcnm = (JSPUtil.getParameter(request, prefix + "f_strprcnm", length));
            String[] fToMon = (JSPUtil.getParameter(request, prefix + "f_to_mon", length));
            String[] fRaAcctGroupCd = (JSPUtil.getParameter(request, prefix + "f_ra_acct_group_cd", length));
            String[] fSim = (JSPUtil.getParameter(request, prefix + "f_sim", length));
            String[] fTrdCd = (JSPUtil.getParameter(request, prefix + "f_trd_cd", length));
            String[] fSimDt = (JSPUtil.getParameter(request, prefix + "f_sim_dt", length));
            String[] fBkgSts = (JSPUtil.getParameter(request, prefix + "f_bkg_sts", length));
            String[] fMtPuCd = (JSPUtil.getParameter(request, prefix + "f_mt_pu_cd", length));
            String[] fIocCd = (JSPUtil.getParameter(request, prefix + "f_ioc_cd", length));
            String[] fEweek = (JSPUtil.getParameter(request, prefix + "f_eweek", length));
            String[] fEccCd = (JSPUtil.getParameter(request, prefix + "f_ecc_cd", length));
            String[] fSelvessel = (JSPUtil.getParameter(request, prefix + "f_selvessel", length));
            String[] fRevPolCd = (JSPUtil.getParameter(request, prefix + "f_rev_pol_cd", length));
            String[] fMtyEccCd = (JSPUtil.getParameter(request, prefix + "f_mty_ecc_cd", length));
            String[] fTypeCd = (JSPUtil.getParameter(request, prefix + "f_type_cd", length));
            String[] fCoblane = (JSPUtil.getParameter(request, prefix + "f_coblane", length));
            String[] fUcCd = (JSPUtil.getParameter(request, prefix + "f_uc_cd", length));
            String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", length));
            String[] fDel = (JSPUtil.getParameter(request, prefix + "f_del", length));
            String[] fRaAcctIndvlCd = (JSPUtil.getParameter(request, prefix + "f_ra_acct_indvl_cd", length));
            String[] fOtrGlobalAcct = (JSPUtil.getParameter(request, prefix + "f_otr_global_acct", length));
            String[] fSrcMon = (JSPUtil.getParameter(request, prefix + "f_src_mon", length));
            String[] fOriDest = (JSPUtil.getParameter(request, prefix + "f_ori_dest", length));
            String[] fLgsKpi3Cd = (JSPUtil.getParameter(request, prefix + "f_lgs_kpi3_cd", length));
            String[] fGroup = (JSPUtil.getParameter(request, prefix + "f_group", length));
            String[] fTtlAmt = (JSPUtil.getParameter(request, prefix + "f_ttl_amt", length));
            String[] fBkgNo = (JSPUtil.getParameter(request, prefix + "f_bkg_no", length));
            String[] fCostYr = (JSPUtil.getParameter(request, prefix + "f_cost_yr", length));
            String[] fCustCntCd = (JSPUtil.getParameter(request, prefix + "f_cust_cnt_cd", length));
            String[] fProLvl = (JSPUtil.getParameter(request, prefix + "f_pro_lvl", length));
            String[] fSaTrdIndvlCd = (JSPUtil.getParameter(request, prefix + "f_sa_trd_indvl_cd", length));
            String[] fHTrdCd = (JSPUtil.getParameter(request, prefix + "f_h_trd_cd", length));
            String[] fShipper = (JSPUtil.getParameter(request, prefix + "f_shipper", length));
            String[] fPod = (JSPUtil.getParameter(request, prefix + "f_pod", length));
            String[] fYearweek = (JSPUtil.getParameter(request, prefix + "f_yearweek", length));
            String[] fCobioc = (JSPUtil.getParameter(request, prefix + "f_cobioc", length));
            String[] fYrtype = (JSPUtil.getParameter(request, prefix + "f_yrtype", length));
            String[] fOfcActCd = (JSPUtil.getParameter(request, prefix + "f_ofc_act_cd", length));
            String[] f3td = (JSPUtil.getParameter(request, prefix + "f_3td", length));
            String[] fRhqCd = (JSPUtil.getParameter(request, prefix + "f_rhq_cd", length));
            String[] fSlsMon = (JSPUtil.getParameter(request, prefix + "f_sls_mon", length));
            String[] fKeyAcctIndvlCd = (JSPUtil.getParameter(request, prefix + "f_key_acct_indvl_cd", length));
            String[] fLocCd = (JSPUtil.getParameter(request, prefix + "f_loc_cd", length));
            String[] fCustRhqCd = (JSPUtil.getParameter(request, prefix + "f_cust_rhq_cd", length));
            String[] fCmdtCd = (JSPUtil.getParameter(request, prefix + "f_cmdt_cd", length));
            String[] fOtrKeyAcct = (JSPUtil.getParameter(request, prefix + "f_otr_key_acct", length));
            String[] fOpView = (JSPUtil.getParameter(request, prefix + "f_op_view", length));
            String[] fSaTrdGroupCd = (JSPUtil.getParameter(request, prefix + "f_sa_trd_group_cd", length));
            String[] fCrrCd = (JSPUtil.getParameter(request, prefix + "f_crr_cd", length));
            String[] f2nd = (JSPUtil.getParameter(request, prefix + "f_2nd", length));
            String[] fSelgroup = (JSPUtil.getParameter(request, prefix + "f_selgroup", length));
            String[] fSweek = (JSPUtil.getParameter(request, prefix + "f_sweek", length));
            String[] fFmWk = (JSPUtil.getParameter(request, prefix + "f_fm_wk", length));
            String[] fCobcost = (JSPUtil.getParameter(request, prefix + "f_cobcost", length));
            String[] fSpclCgoCd = (JSPUtil.getParameter(request, prefix + "f_spcl_cgo_cd", length));
            String[] fMltTrdIndvlCd = (JSPUtil.getParameter(request, prefix + "f_mlt_trd_indvl_cd", length));
            String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix + "f_skd_voy_no", length));
            String[] fDirSts = (JSPUtil.getParameter(request, prefix + "f_dir_sts", length));
            String[] fWkCd = (JSPUtil.getParameter(request, prefix + "f_wk_cd", length));
            String[] fHeadernm = (JSPUtil.getParameter(request, prefix + "f_headernm", length));
            String[] fTrdSts = (JSPUtil.getParameter(request, prefix + "f_trd_sts", length));
            String[] fTrdDirCd = (JSPUtil.getParameter(request, prefix + "f_trd_dir_cd", length));
            String[] fLoc = (JSPUtil.getParameter(request, prefix + "f_loc", length));
            String[] fPctlNo = (JSPUtil.getParameter(request, prefix + "f_pctl_no", length));
            String[] fCboEcc = (JSPUtil.getParameter(request, prefix + "f_cbo_ecc", length));
            String[] fYear = (JSPUtil.getParameter(request, prefix + "f_year", length));
            String[] fMon = (JSPUtil.getParameter(request, prefix + "f_mon", length));
            String[] fSpclCgoBbFlg = (JSPUtil.getParameter(request, prefix + "f_spcl_cgo_bb_flg", length));
            String[] fBkgDisp = (JSPUtil.getParameter(request, prefix + "f_bkg_disp", length));
            String[] fSeldir = (JSPUtil.getParameter(request, prefix + "f_seldir", length));
            String[] fStsCd = (JSPUtil.getParameter(request, prefix + "f_sts_cd", length));
            String[] fAvgSuvgrp = (JSPUtil.getParameter(request, prefix + "f_avg_suvgrp", length));
            String[] fStrchkprd = (JSPUtil.getParameter(request, prefix + "f_strchkprd", length));
            String[] fTarMon = (JSPUtil.getParameter(request, prefix + "f_tar_mon", length));
            String[] fVopCd = (JSPUtil.getParameter(request, prefix + "f_vop_cd", length));
            String[] fCostYrmon = (JSPUtil.getParameter(request, prefix + "f_cost_yrmon", length));
            String[] fIasRgnCd = (JSPUtil.getParameter(request, prefix + "f_ias_rgn_cd", length));
            String[] fSeltrade = (JSPUtil.getParameter(request, prefix + "f_seltrade", length));
            String[] fStrlane = (JSPUtil.getParameter(request, prefix + "f_strlane", length));
            String[] fEcc = (JSPUtil.getParameter(request, prefix + "f_ecc", length));
            String[] fVslCd2 = (JSPUtil.getParameter(request, prefix + "f_vsl_cd2", length));
            String[] fBkgNoSplit = (JSPUtil.getParameter(request, prefix + "f_bkg_no_split", length));
            String[] fSelcapa = (JSPUtil.getParameter(request, prefix + "f_selcapa", length));
            String[] f4th = (JSPUtil.getParameter(request, prefix + "f_4th", length));
            String[] dateCheckFlag = (JSPUtil.getParameter(request, prefix + "date_check_flag", length));
            String[] fLoclTsStsCd = (JSPUtil.getParameter(request, prefix + "f_locl_ts_sts_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchConditionVO();
                if (fSvcTrnsPrcCntCd[i] != null)
                    model.setFSvcTrnsPrcCntCd(fSvcTrnsPrcCntCd[i]);
                if (fCboRcc[i] != null)
                    model.setFCboRcc(fCboRcc[i]);
                if (fFmMon[i] != null)
                    model.setFFmMon(fFmMon[i]);
                if (fSelclass[i] != null)
                    model.setFSelclass(fSelclass[i]);
                if (fMasCd[i] != null)
                    model.setFMasCd(fMasCd[i]);
                if (fCobtrade[i] != null)
                    model.setFCobtrade(fCobtrade[i]);
                if (fMtPuYdCd[i] != null)
                    model.setFMtPuYdCd(fMtPuYdCd[i]);
                if (fPodEccCd[i] != null)
                    model.setFPodEccCd(fPodEccCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fStrtomonth[i] != null)
                    model.setFStrtomonth(fStrtomonth[i]);
                if (fTo[i] != null)
                    model.setFTo(fTo[i]);
                if (fSrepCd[i] != null)
                    model.setFSrepCd(fSrepCd[i]);
                if (fVslCd[i] != null)
                    model.setFVslCd(fVslCd[i]);
                if (fSelcost[i] != null)
                    model.setFSelcost(fSelcost[i]);
                if (fAvgGrpCd[i] != null)
                    model.setFAvgGrpCd(fAvgGrpCd[i]);
                if (fOfcTeamCd[i] != null)
                    model.setFOfcTeamCd(fOfcTeamCd[i]);
                if (fStrtoweek[i] != null)
                    model.setFStrtoweek(fStrtoweek[i]);
                if (fCostUseTpCd[i] != null)
                    model.setFCostUseTpCd(fCostUseTpCd[i]);
                if (fRlaneCd[i] != null)
                    model.setFRlaneCd(fRlaneCd[i]);
                if (fBkgPorCd[i] != null)
                    model.setFBkgPorCd(fBkgPorCd[i]);
                if (fStrvoyage[i] != null)
                    model.setFStrvoyage(fStrvoyage[i]);
                if (fStrfmmonth[i] != null)
                    model.setFStrfmmonth(fStrfmmonth[i]);
                if (fDividename[i] != null)
                    model.setFDividename(fDividename[i]);
                if (fChkprd[i] != null)
                    model.setFChkprd(fChkprd[i]);
                if (fQtr[i] != null)
                    model.setFQtr(fQtr[i]);
                if (fTmlCd[i] != null)
                    model.setFTmlCd(fTmlCd[i]);
                if (fOtrRegionalAcct[i] != null)
                    model.setFOtrRegionalAcct(fOtrRegionalAcct[i]);
                if (fSocSts[i] != null)
                    model.setFSocSts(fSocSts[i]);
                if (fLocalAcct[i] != null)
                    model.setFLocalAcct(fLocalAcct[i]);
                if (fFromEcc[i] != null)
                    model.setFFromEcc(fFromEcc[i]);
                if (fSdate[i] != null)
                    model.setFSdate(fSdate[i]);
                if (fCustSeq[i] != null)
                    model.setFCustSeq(fCustSeq[i]);
                if (fCbotrade[i] != null)
                    model.setFCbotrade(fCbotrade[i]);
                if (fEmon[i] != null)
                    model.setFEmon(fEmon[i]);
                if (fProVw[i] != null)
                    model.setFProVw(fProVw[i]);
                if (fYearmonth[i] != null)
                    model.setFYearmonth(fYearmonth[i]);
                if (fToEccCd[i] != null)
                    model.setFToEccCd(fToEccCd[i]);
                if (fShpr[i] != null)
                    model.setFShpr(fShpr[i]);
                if (fShprCd[i] != null)
                    model.setFShprCd(fShprCd[i]);
                if (fOtrStrgAcct[i] != null)
                    model.setFOtrStrgAcct(fOtrStrgAcct[i]);
                if (fVessel[i] != null)
                    model.setFVessel(fVessel[i]);
                if (fFromEccCd[i] != null)
                    model.setFFromEccCd(fFromEccCd[i]);
                if (fCommLocCd[i] != null)
                    model.setFCommLocCd(fCommLocCd[i]);
                if (fPor[i] != null)
                    model.setFPor(fPor[i]);
                if (fRfa[i] != null)
                    model.setFRfa(fRfa[i]);
                if (fOtrRfCoreAcct[i] != null)
                    model.setFOtrRfCoreAcct(fOtrRfCoreAcct[i]);
                if (fIncludeTs[i] != null)
                    model.setFIncludeTs(fIncludeTs[i]);
                if (fFixedRate[i] != null)
                    model.setFFixedRate(fFixedRate[i]);
                if (fOfcCd[i] != null)
                    model.setFOfcCd(fOfcCd[i]);
                if (fSubTrdCd[i] != null)
                    model.setFSubTrdCd(fSubTrdCd[i]);
                if (fLccCd[i] != null)
                    model.setFLccCd(fLccCd[i]);
                if (fRfaNo[i] != null)
                    model.setFRfaNo(fRfaNo[i]);
                if (fSimNo[i] != null)
                    model.setFSimNo(fSimNo[i]);
                if (fHulBndCd[i] != null)
                    model.setFHulBndCd(fHulBndCd[i]);
                if (fDirCd[i] != null)
                    model.setFDirCd(fDirCd[i]);
                if (fUsaBkgModCd[i] != null)
                    model.setFUsaBkgModCd(fUsaBkgModCd[i]);
                if (fOpLaneTpCd[i] != null)
                    model.setFOpLaneTpCd(fOpLaneTpCd[i]);
                if (fFullMtyCd[i] != null)
                    model.setFFullMtyCd(fFullMtyCd[i]);
                if (fMdmChargeTypeCd[i] != null)
                    model.setFMdmChargeTypeCd(fMdmChargeTypeCd[i]);
                if (fWkSts[i] != null)
                    model.setFWkSts(fWkSts[i]);
                if (fSelrlane[i] != null)
                    model.setFSelrlane(fSelrlane[i]);
                if (fStrtype[i] != null)
                    model.setFStrtype(fStrtype[i]);
                if (fRevYrmon[i] != null)
                    model.setFRevYrmon(fRevYrmon[i]);
                if (fCobdir[i] != null)
                    model.setFCobdir(fCobdir[i]);
                if (fMtyLccCd[i] != null)
                    model.setFMtyLccCd(fMtyLccCd[i]);
                if (fOfcLvl[i] != null)
                    model.setFOfcLvl(fOfcLvl[i]);
                if (fHeader[i] != null)
                    model.setFHeader(fHeader[i]);
                if (fOfcVw[i] != null)
                    model.setFOfcVw(fOfcVw[i]);
                if (fSpclCgoAwkFlg[i] != null)
                    model.setFSpclCgoAwkFlg(fSpclCgoAwkFlg[i]);
                if (fScNo[i] != null)
                    model.setFScNo(fScNo[i]);
                if (fUsrId[i] != null)
                    model.setFUsrId(fUsrId[i]);
                if (fKeyAcctGroupCd[i] != null)
                    model.setFKeyAcctGroupCd(fKeyAcctGroupCd[i]);
                if (fToWk[i] != null)
                    model.setFToWk(fToWk[i]);
                if (fSpclCgoDgFlg[i] != null)
                    model.setFSpclCgoDgFlg(fSpclCgoDgFlg[i]);
                if (fCboslane[i] != null)
                    model.setFCboslane(fCboslane[i]);
                if (fHDirCd[i] != null)
                    model.setFHDirCd(fHDirCd[i]);
                if (fSpclCgoRfFlg[i] != null)
                    model.setFSpclCgoRfFlg(fSpclCgoRfFlg[i]);
                if (fStrdir[i] != null)
                    model.setFStrdir(fStrdir[i]);
                if (fChkprevcre[i] != null)
                    model.setFChkprevcre(fChkprevcre[i]);
                if (fStrfmweek[i] != null)
                    model.setFStrfmweek(fStrfmweek[i]);
                if (fSlanCd[i] != null)
                    model.setFSlanCd(fSlanCd[i]);
                if (fFrom[i] != null)
                    model.setFFrom(fFrom[i]);
                if (fEccCd2[i] != null)
                    model.setFEccCd2(fEccCd2[i]);
                if (fActGrpCd[i] != null)
                    model.setFActGrpCd(fActGrpCd[i]);
                if (fChkBsazrflg[i] != null)
                    model.setFChkBsazrflg(fChkBsazrflg[i]);
                if (fVoyage[i] != null)
                    model.setFVoyage(fVoyage[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (fMtyRccCd[i] != null)
                    model.setFMtyRccCd(fMtyRccCd[i]);
                if (fXLev[i] != null)
                    model.setFXLev(fXLev[i]);
                if (fChkdel[i] != null)
                    model.setFChkdel(fChkdel[i]);
                if (fSlsOfcCd[i] != null)
                    model.setFSlsOfcCd(fSlsOfcCd[i]);
                if (fLoclCurrCd[i] != null)
                    model.setFLoclCurrCd(fLoclCurrCd[i]);
                if (fCboLcc[i] != null)
                    model.setFCboLcc(fCboLcc[i]);
                if (fToEcc[i] != null)
                    model.setFToEcc(fToEcc[i]);
                if (fHRlaneCd[i] != null)
                    model.setFHRlaneCd(fHRlaneCd[i]);
                if (fSmon[i] != null)
                    model.setFSmon(fSmon[i]);
                if (fCostLocGrpCd[i] != null)
                    model.setFCostLocGrpCd(fCostLocGrpCd[i]);
                if (fIasSubGrpCd[i] != null)
                    model.setFIasSubGrpCd(fIasSubGrpCd[i]);
                if (fSelioc[i] != null)
                    model.setFSelioc(fSelioc[i]);
                if (fMltTrdGroupCd[i] != null)
                    model.setFMltTrdGroupCd(fMltTrdGroupCd[i]);
                if (fSkdDirCd[i] != null)
                    model.setFSkdDirCd(fSkdDirCd[i]);
                if (fDir[i] != null)
                    model.setFDir(fDir[i]);
                if (fCostFmMon[i] != null)
                    model.setFCostFmMon(fCostFmMon[i]);
                if (fPolPodCd[i] != null)
                    model.setFPolPodCd(fPolPodCd[i]);
                if (fCalcTermCd[i] != null)
                    model.setFCalcTermCd(fCalcTermCd[i]);
                if (fInout[i] != null)
                    model.setFInout(fInout[i]);
                if (istrade[i] != null)
                    model.setIstrade(istrade[i]);
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
                if (fRdInd[i] != null)
                    model.setFRdInd(fRdInd[i]);
                if (fExclSts[i] != null)
                    model.setFExclSts(fExclSts[i]);
                if (fTaaNo[i] != null)
                    model.setFTaaNo(fTaaNo[i]);
                if (fRccCd[i] != null)
                    model.setFRccCd(fRccCd[i]);
                if (fHIocCd[i] != null)
                    model.setFHIocCd(fHIocCd[i]);
                if (fDur[i] != null)
                    model.setFDur(fDur[i]);
                if (fRfCoreAcctCd[i] != null)
                    model.setFRfCoreAcctCd(fRfCoreAcctCd[i]);
                if (fWtrTermCd[i] != null)
                    model.setFWtrTermCd(fWtrTermCd[i]);
                if (fStrtrade[i] != null)
                    model.setFStrtrade(fStrtrade[i]);
                if (fSavename[i] != null)
                    model.setFSavename(fSavename[i]);
                if (fExclSub[i] != null)
                    model.setFExclSub(fExclSub[i]);
                if (fCustTp[i] != null)
                    model.setFCustTp(fCustTp[i]);
                if (fBkgPodCd[i] != null)
                    model.setFBkgPodCd(fBkgPodCd[i]);
                if (fBkgDelCd[i] != null)
                    model.setFBkgDelCd(fBkgDelCd[i]);
                if (fMdmChargeCd[i] != null)
                    model.setFMdmChargeCd(fMdmChargeCd[i]);
                if (fRoutNo[i] != null)
                    model.setFRoutNo(fRoutNo[i]);
                if (fViewTpsz[i] != null)
                    model.setFViewTpsz(fViewTpsz[i]);
                if (fBkgPolCd[i] != null)
                    model.setFBkgPolCd(fBkgPolCd[i]);
                if (fStrprcnm[i] != null)
                    model.setFStrprcnm(fStrprcnm[i]);
                if (fToMon[i] != null)
                    model.setFToMon(fToMon[i]);
                if (fRaAcctGroupCd[i] != null)
                    model.setFRaAcctGroupCd(fRaAcctGroupCd[i]);
                if (fSim[i] != null)
                    model.setFSim(fSim[i]);
                if (fTrdCd[i] != null)
                    model.setFTrdCd(fTrdCd[i]);
                if (fSimDt[i] != null)
                    model.setFSimDt(fSimDt[i]);
                if (fBkgSts[i] != null)
                    model.setFBkgSts(fBkgSts[i]);
                if (fMtPuCd[i] != null)
                    model.setFMtPuCd(fMtPuCd[i]);
                if (fIocCd[i] != null)
                    model.setFIocCd(fIocCd[i]);
                if (fEweek[i] != null)
                    model.setFEweek(fEweek[i]);
                if (fEccCd[i] != null)
                    model.setFEccCd(fEccCd[i]);
                if (fSelvessel[i] != null)
                    model.setFSelvessel(fSelvessel[i]);
                if (fRevPolCd[i] != null)
                    model.setFRevPolCd(fRevPolCd[i]);
                if (fMtyEccCd[i] != null)
                    model.setFMtyEccCd(fMtyEccCd[i]);
                if (fTypeCd[i] != null)
                    model.setFTypeCd(fTypeCd[i]);
                if (fCoblane[i] != null)
                    model.setFCoblane(fCoblane[i]);
                if (fUcCd[i] != null)
                    model.setFUcCd(fUcCd[i]);
                if (fCntrTpszCd[i] != null)
                    model.setFCntrTpszCd(fCntrTpszCd[i]);
                if (fDel[i] != null)
                    model.setFDel(fDel[i]);
                if (fRaAcctIndvlCd[i] != null)
                    model.setFRaAcctIndvlCd(fRaAcctIndvlCd[i]);
                if (fOtrGlobalAcct[i] != null)
                    model.setFOtrGlobalAcct(fOtrGlobalAcct[i]);
                if (fSrcMon[i] != null)
                    model.setFSrcMon(fSrcMon[i]);
                if (fOriDest[i] != null)
                    model.setFOriDest(fOriDest[i]);
                if (fLgsKpi3Cd[i] != null)
                    model.setFLgsKpi3Cd(fLgsKpi3Cd[i]);
                if (fGroup[i] != null)
                    model.setFGroup(fGroup[i]);
                if (fTtlAmt[i] != null)
                    model.setFTtlAmt(fTtlAmt[i]);
                if (fBkgNo[i] != null)
                    model.setFBkgNo(fBkgNo[i]);
                if (fCostYr[i] != null)
                    model.setFCostYr(fCostYr[i]);
                if (fCustCntCd[i] != null)
                    model.setFCustCntCd(fCustCntCd[i]);
                if (fProLvl[i] != null)
                    model.setFProLvl(fProLvl[i]);
                if (fSaTrdIndvlCd[i] != null)
                    model.setFSaTrdIndvlCd(fSaTrdIndvlCd[i]);
                if (fHTrdCd[i] != null)
                    model.setFHTrdCd(fHTrdCd[i]);
                if (fShipper[i] != null)
                    model.setFShipper(fShipper[i]);
                if (fPod[i] != null)
                    model.setFPod(fPod[i]);
                if (fYearweek[i] != null)
                    model.setFYearweek(fYearweek[i]);
                if (fCobioc[i] != null)
                    model.setFCobioc(fCobioc[i]);
                if (fYrtype[i] != null)
                    model.setFYrtype(fYrtype[i]);
                if (fOfcActCd[i] != null)
                    model.setFOfcActCd(fOfcActCd[i]);
                if (f3td[i] != null)
                    model.setF3td(f3td[i]);
                if (fRhqCd[i] != null)
                    model.setFRhqCd(fRhqCd[i]);
                if (fSlsMon[i] != null)
                    model.setFSlsMon(fSlsMon[i]);
                if (fKeyAcctIndvlCd[i] != null)
                    model.setFKeyAcctIndvlCd(fKeyAcctIndvlCd[i]);
                if (fLocCd[i] != null)
                    model.setFLocCd(fLocCd[i]);
                if (fCustRhqCd[i] != null)
                    model.setFCustRhqCd(fCustRhqCd[i]);
                if (fCmdtCd[i] != null)
                    model.setFCmdtCd(fCmdtCd[i]);
                if (fOtrKeyAcct[i] != null)
                    model.setFOtrKeyAcct(fOtrKeyAcct[i]);
                if (fOpView[i] != null)
                    model.setFOpView(fOpView[i]);
                if (fSaTrdGroupCd[i] != null)
                    model.setFSaTrdGroupCd(fSaTrdGroupCd[i]);
                if (fCrrCd[i] != null)
                    model.setFCrrCd(fCrrCd[i]);
                if (f2nd[i] != null)
                    model.setF2nd(f2nd[i]);
                if (fSelgroup[i] != null)
                    model.setFSelgroup(fSelgroup[i]);
                if (fSweek[i] != null)
                    model.setFSweek(fSweek[i]);
                if (fFmWk[i] != null)
                    model.setFFmWk(fFmWk[i]);
                if (fCobcost[i] != null)
                    model.setFCobcost(fCobcost[i]);
                if (fSpclCgoCd[i] != null)
                    model.setFSpclCgoCd(fSpclCgoCd[i]);
                if (fMltTrdIndvlCd[i] != null)
                    model.setFMltTrdIndvlCd(fMltTrdIndvlCd[i]);
                if (fSkdVoyNo[i] != null)
                    model.setFSkdVoyNo(fSkdVoyNo[i]);
                if (fDirSts[i] != null)
                    model.setFDirSts(fDirSts[i]);
                if (fWkCd[i] != null)
                    model.setFWkCd(fWkCd[i]);
                if (fHeadernm[i] != null)
                    model.setFHeadernm(fHeadernm[i]);
                if (fTrdSts[i] != null)
                    model.setFTrdSts(fTrdSts[i]);
                if (fTrdDirCd[i] != null)
                    model.setFTrdDirCd(fTrdDirCd[i]);
                if (fLoc[i] != null)
                    model.setFLoc(fLoc[i]);
                if (fPctlNo[i] != null)
                    model.setFPctlNo(fPctlNo[i]);
                if (fCboEcc[i] != null)
                    model.setFCboEcc(fCboEcc[i]);
                if (fYear[i] != null)
                    model.setFYear(fYear[i]);
                if (fMon[i] != null)
                    model.setFMon(fMon[i]);
                if (fSpclCgoBbFlg[i] != null)
                    model.setFSpclCgoBbFlg(fSpclCgoBbFlg[i]);
                if (fBkgDisp[i] != null)
                    model.setFBkgDisp(fBkgDisp[i]);
                if (fSeldir[i] != null)
                    model.setFSeldir(fSeldir[i]);
                if (fStsCd[i] != null)
                    model.setFStsCd(fStsCd[i]);
                if (fAvgSuvgrp[i] != null)
                    model.setFAvgSuvgrp(fAvgSuvgrp[i]);
                if (fStrchkprd[i] != null)
                    model.setFStrchkprd(fStrchkprd[i]);
                if (fTarMon[i] != null)
                    model.setFTarMon(fTarMon[i]);
                if (fVopCd[i] != null)
                    model.setFVopCd(fVopCd[i]);
                if (fCostYrmon[i] != null)
                    model.setFCostYrmon(fCostYrmon[i]);
                if (fIasRgnCd[i] != null)
                    model.setFIasRgnCd(fIasRgnCd[i]);
                if (fSeltrade[i] != null)
                    model.setFSeltrade(fSeltrade[i]);
                if (fStrlane[i] != null)
                    model.setFStrlane(fStrlane[i]);
                if (fEcc[i] != null)
                    model.setFEcc(fEcc[i]);
                if (fVslCd2[i] != null)
                    model.setFVslCd2(fVslCd2[i]);
                if (fBkgNoSplit[i] != null)
                    model.setFBkgNoSplit(fBkgNoSplit[i]);
                if (fSelcapa[i] != null)
                    model.setFSelcapa(fSelcapa[i]);
                if (f4th[i] != null)
                    model.setF4th(f4th[i]);
                if (dateCheckFlag[i] != null)
                    model.setDateCheckFlag(dateCheckFlag[i]);
                if (fLoclTsStsCd[i] != null) 
		    		model.setFLoclTsStsCd(fLoclTsStsCd[i]);
				/* Add a Method line, do not delete */
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
    public SearchConditionVO[] getSearchConditionVOs() {
        SearchConditionVO[] vos = (SearchConditionVO[]) models.toArray(new SearchConditionVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.fSvcTrnsPrcCntCd = this.fSvcTrnsPrcCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCboRcc = this.fCboRcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFmMon = this.fFmMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelclass = this.fSelclass.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMasCd = this.fMasCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCobtrade = this.fCobtrade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtPuYdCd = this.fMtPuYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPodEccCd = this.fPodEccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrtomonth = this.fStrtomonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTo = this.fTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSrepCd = this.fSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fVslCd = this.fVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelcost = this.fSelcost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fAvgGrpCd = this.fAvgGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOfcTeamCd = this.fOfcTeamCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrtoweek = this.fStrtoweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCostUseTpCd = this.fCostUseTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRlaneCd = this.fRlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgPorCd = this.fBkgPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrvoyage = this.fStrvoyage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrfmmonth = this.fStrfmmonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fDividename = this.fDividename.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fChkprd = this.fChkprd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fQtr = this.fQtr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTmlCd = this.fTmlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOtrRegionalAcct = this.fOtrRegionalAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSocSts = this.fSocSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLocalAcct = this.fLocalAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFromEcc = this.fFromEcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSdate = this.fSdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCustSeq = this.fCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCbotrade = this.fCbotrade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fEmon = this.fEmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fProVw = this.fProVw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fYearmonth = this.fYearmonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fToEccCd = this.fToEccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fShpr = this.fShpr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fShprCd = this.fShprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOtrStrgAcct = this.fOtrStrgAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fVessel = this.fVessel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFromEccCd = this.fFromEccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCommLocCd = this.fCommLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPor = this.fPor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRfa = this.fRfa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOtrRfCoreAcct = this.fOtrRfCoreAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fIncludeTs = this.fIncludeTs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFixedRate = this.fFixedRate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOfcCd = this.fOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSubTrdCd = this.fSubTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLccCd = this.fLccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRfaNo = this.fRfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSimNo = this.fSimNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHulBndCd = this.fHulBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fDirCd = this.fDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fUsaBkgModCd = this.fUsaBkgModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOpLaneTpCd = this.fOpLaneTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFullMtyCd = this.fFullMtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMdmChargeTypeCd = this.fMdmChargeTypeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fWkSts = this.fWkSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelrlane = this.fSelrlane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrtype = this.fStrtype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRevYrmon = this.fRevYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCobdir = this.fCobdir.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyLccCd = this.fMtyLccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOfcLvl = this.fOfcLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHeader = this.fHeader.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOfcVw = this.fOfcVw.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSpclCgoAwkFlg = this.fSpclCgoAwkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fScNo = this.fScNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fUsrId = this.fUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fKeyAcctGroupCd = this.fKeyAcctGroupCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fToWk = this.fToWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSpclCgoDgFlg = this.fSpclCgoDgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCboslane = this.fCboslane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHDirCd = this.fHDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSpclCgoRfFlg = this.fSpclCgoRfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrdir = this.fStrdir.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fChkprevcre = this.fChkprevcre.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrfmweek = this.fStrfmweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSlanCd = this.fSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFrom = this.fFrom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fEccCd2 = this.fEccCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fActGrpCd = this.fActGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fChkBsazrflg = this.fChkBsazrflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fVoyage = this.fVoyage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyRccCd = this.fMtyRccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fXLev = this.fXLev.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fChkdel = this.fChkdel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSlsOfcCd = this.fSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLoclCurrCd = this.fLoclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCboLcc = this.fCboLcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fToEcc = this.fToEcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHRlaneCd = this.fHRlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSmon = this.fSmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCostLocGrpCd = this.fCostLocGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fIasSubGrpCd = this.fIasSubGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelioc = this.fSelioc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMltTrdGroupCd = this.fMltTrdGroupCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSkdDirCd = this.fSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fDir = this.fDir.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCostFmMon = this.fCostFmMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPolPodCd = this.fPolPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCalcTermCd = this.fCalcTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fInout = this.fInout.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.istrade = this.istrade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelslane = this.fSelslane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRevPodCd = this.fRevPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrvessel = this.fStrvessel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStryear = this.fStryear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f1st = this.f1st.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRdInd = this.fRdInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fExclSts = this.fExclSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTaaNo = this.fTaaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRccCd = this.fRccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHIocCd = this.fHIocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fDur = this.fDur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRfCoreAcctCd = this.fRfCoreAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fWtrTermCd = this.fWtrTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrtrade = this.fStrtrade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSavename = this.fSavename.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fExclSub = this.fExclSub.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCustTp = this.fCustTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgPodCd = this.fBkgPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgDelCd = this.fBkgDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMdmChargeCd = this.fMdmChargeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRoutNo = this.fRoutNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fViewTpsz = this.fViewTpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgPolCd = this.fBkgPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrprcnm = this.fStrprcnm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fToMon = this.fToMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRaAcctGroupCd = this.fRaAcctGroupCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSim = this.fSim.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTrdCd = this.fTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSimDt = this.fSimDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgSts = this.fBkgSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtPuCd = this.fMtPuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fIocCd = this.fIocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fEweek = this.fEweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fEccCd = this.fEccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelvessel = this.fSelvessel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRevPolCd = this.fRevPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyEccCd = this.fMtyEccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTypeCd = this.fTypeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCoblane = this.fCoblane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fUcCd = this.fUcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCntrTpszCd = this.fCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fDel = this.fDel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRaAcctIndvlCd = this.fRaAcctIndvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOtrGlobalAcct = this.fOtrGlobalAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSrcMon = this.fSrcMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOriDest = this.fOriDest.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLgsKpi3Cd = this.fLgsKpi3Cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fGroup = this.fGroup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTtlAmt = this.fTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgNo = this.fBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCostYr = this.fCostYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCustCntCd = this.fCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fProLvl = this.fProLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSaTrdIndvlCd = this.fSaTrdIndvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHTrdCd = this.fHTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fShipper = this.fShipper.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPod = this.fPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fYearweek = this.fYearweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCobioc = this.fCobioc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fYrtype = this.fYrtype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOfcActCd = this.fOfcActCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f3td = this.f3td.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRhqCd = this.fRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSlsMon = this.fSlsMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fKeyAcctIndvlCd = this.fKeyAcctIndvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLocCd = this.fLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCustRhqCd = this.fCustRhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCmdtCd = this.fCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOtrKeyAcct = this.fOtrKeyAcct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOpView = this.fOpView.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSaTrdGroupCd = this.fSaTrdGroupCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCrrCd = this.fCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f2nd = this.f2nd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelgroup = this.fSelgroup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSweek = this.fSweek.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fFmWk = this.fFmWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCobcost = this.fCobcost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSpclCgoCd = this.fSpclCgoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMltTrdIndvlCd = this.fMltTrdIndvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSkdVoyNo = this.fSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fDirSts = this.fDirSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fWkCd = this.fWkCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fHeadernm = this.fHeadernm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTrdSts = this.fTrdSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTrdDirCd = this.fTrdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLoc = this.fLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPctlNo = this.fPctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCboEcc = this.fCboEcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fYear = this.fYear.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMon = this.fMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSpclCgoBbFlg = this.fSpclCgoBbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgDisp = this.fBkgDisp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSeldir = this.fSeldir.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStsCd = this.fStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fAvgSuvgrp = this.fAvgSuvgrp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrchkprd = this.fStrchkprd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fTarMon = this.fTarMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fVopCd = this.fVopCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCostYrmon = this.fCostYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fIasRgnCd = this.fIasRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSeltrade = this.fSeltrade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStrlane = this.fStrlane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fEcc = this.fEcc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fVslCd2 = this.fVslCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fBkgNoSplit = this.fBkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fSelcapa = this.fSelcapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.f4th = this.f4th.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dateCheckFlag = this.f4th.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fLoclTsStsCd = this.fLoclTsStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
