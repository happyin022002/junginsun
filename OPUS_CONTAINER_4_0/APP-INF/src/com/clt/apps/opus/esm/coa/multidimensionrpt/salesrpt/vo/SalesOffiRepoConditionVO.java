/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SalesOffiRepoConditionVO.java
*@FileTitle : SalesOffiRepoConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.27 윤진영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo;

import java.lang.reflect.Field;
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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SalesOffiRepoConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SalesOffiRepoConditionVO> models = new ArrayList<SalesOffiRepoConditionVO>();
	
	/* Column Info */
	private String fOfcSts = null;
	/* Column Info */
	private String fExclSts = null;
	/* Column Info */
	private String fTaaNo = null;
	/* Column Info */
	private String fRptItem = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fIscmdt = null;
	/* Column Info */
	private String fUsaBkgModCd = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String fSlsMon = null;
	/* Column Info */
	private String fCobTrade = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCurrWeek = null;
	/* Column Info */
	private String fWkSts = null;
	/* Column Info */
	private String fBkgDelCd = null;
	/* Column Info */
	private String fSrepCd = null;
	/* Column Info */
	private String fIssc = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fIstpsz = null;
	/* Column Info */
	private String fUsrOfcLvl = null;
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
	private String fScNo = null;
	/* Column Info */
	private String fDirSts = null;
	/* Column Info */
	private String fUsrOfcCd = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fToDate = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fBkgSts = null;
	/* Column Info */
	private String fFmDate = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fBkgPorCd = null;
	/* Column Info */
	private String fIocCd = null;
	/* Column Info */
	private String fRevPolCd = null;
	/* Column Info */
	private String fCobLane = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String fRfSts = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fMon = null;
	/* Column Info */
	private String fIssrep = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String fWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fSlsOfcCd = null;
	/* Column Info */
	private String fProVw = null;
	/* Column Info */
	private String fCobSubtrade = null;
	/* Column Info */
	private String fShprCd = null;
	/* Column Info */
	private String fCobBound = null;
	/* Column Info */
	private String fBkgNo = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fRfa = null;
	/* Column Info */
	private String fPrdCd = null;
	/* Column Info */
	private String fOfcLvl2 = null;
	/* Column Info */
	private String fOfcLvl1 = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String fPrevWeek = null;
	/* Column Info */
	private String fProLvl = null;
	/* Column Info */
	private String fYear2 = null;
	/* Column Info */
	private String fExcel = null;
	/* Column Info */
	private String fIsvvd = null;
	/* Column Info */
	private String fIsweek = null;
	/* Column Info */
	private String fStpFlg = null;
	/* Column Info */
	private String fRevPodCd = null;
	/* Column Info */
	private String fIsbkg = null;
	/* Column Info */
	private String fIsshpr = null;
	/* Column Info */
	private String fIsroute = null;
	/* Column Info */
	private String fRfaNo = null;
	/* Column Info */
	private String fRepCmdtCd = null;
	
	//SJH.20141218.ADD
	/* Column Info */
	private String fSvcScpCd = null;
	/* Column Info */
	private String fBkgPolCd = null;
	/* Column Info */
	private String fBkgPodCd = null;
	/* Column Info */
	private String fCustGrpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SalesOffiRepoConditionVO() {}

	public SalesOffiRepoConditionVO(String ibflag, String pagerows, String fOfcSts, String fExclSts, String fRptItem, String fFmMon, String fDirCd, String fIscmdt, String fUsaBkgModCd, String fRhqCd, String fSlsMon, String fCobTrade, String fCurrWeek, String fWkSts, String fBkgDelCd, String fSrepCd, String fVslCd, String fIssc, String fUsrOfcLvl, String fOfcLvl, String fFmWk, String fOfcVw, String fToMon, String fSkdVoyNo, String fScNo, String fDirSts, String fUsrOfcCd, String fTrdCd, String fToDate, String fToWk, String fBkgSts, String fFmDate, String fRlaneCd, String fBkgPorCd, String fIocCd, String fRevPolCd, String fCobLane, String fYear, String fRfSts, String fChkprd, String fMon, String fIssrep, String fWk, String fSlsOfcCd, String fProVw, String fCobSubtrade, String fShprCd, String fCobBound, String fBkgNo, String fSkdDirCd, String fRfa, String fOfcLvl2, String fOfcLvl1, String fOfcCd, String fPrevWeek, String fProLvl, String fExcel, String fYear2, String fIsweek, String fIsvvd, String fStpFlg, String fRevPodCd, String fIsroute, String fIsshpr, String fIsbkg, String fIstpsz, String fRepCmdtCd, String fRfaNo, String fPrdCd, String fTaaNo, String fCntrTpszCd, String fSvcScpCd, String fBkgPolCd, String fBkgPodCd, String fCustGrpNm) {
		this.fOfcSts = fOfcSts;
		this.fExclSts = fExclSts;
		this.fTaaNo = fTaaNo;
		this.fRptItem = fRptItem;
		this.fFmMon = fFmMon;
		this.fDirCd = fDirCd;
		this.fIscmdt = fIscmdt;
		this.fUsaBkgModCd = fUsaBkgModCd;
		this.fRhqCd = fRhqCd;
		this.fSlsMon = fSlsMon;
		this.fCobTrade = fCobTrade;
		this.pagerows = pagerows;
		this.fCurrWeek = fCurrWeek;
		this.fWkSts = fWkSts;
		this.fBkgDelCd = fBkgDelCd;
		this.fSrepCd = fSrepCd;
		this.fIssc = fIssc;
		this.fVslCd = fVslCd;
		this.fIstpsz = fIstpsz;
		this.fUsrOfcLvl = fUsrOfcLvl;
		this.fOfcLvl = fOfcLvl;
		this.fFmWk = fFmWk;
		this.fOfcVw = fOfcVw;
		this.fToMon = fToMon;
		this.fSkdVoyNo = fSkdVoyNo;
		this.fScNo = fScNo;
		this.fDirSts = fDirSts;
		this.fUsrOfcCd = fUsrOfcCd;
		this.fTrdCd = fTrdCd;
		this.fToDate = fToDate;
		this.fToWk = fToWk;
		this.fBkgSts = fBkgSts;
		this.fFmDate = fFmDate;
		this.fRlaneCd = fRlaneCd;
		this.fBkgPorCd = fBkgPorCd;
		this.fIocCd = fIocCd;
		this.fRevPolCd = fRevPolCd;
		this.fCobLane = fCobLane;
		this.fYear = fYear;
		this.fRfSts = fRfSts;
		this.fChkprd = fChkprd;
		this.fMon = fMon;
		this.fIssrep = fIssrep;
		this.fCntrTpszCd = fCntrTpszCd;
		this.fWk = fWk;
		this.ibflag = ibflag;
		this.fSlsOfcCd = fSlsOfcCd;
		this.fProVw = fProVw;
		this.fCobSubtrade = fCobSubtrade;
		this.fShprCd = fShprCd;
		this.fCobBound = fCobBound;
		this.fBkgNo = fBkgNo;
		this.fSkdDirCd = fSkdDirCd;
		this.fRfa = fRfa;
		this.fPrdCd = fPrdCd;
		this.fOfcLvl2 = fOfcLvl2;
		this.fOfcLvl1 = fOfcLvl1;
		this.fOfcCd = fOfcCd;
		this.fPrevWeek = fPrevWeek;
		this.fProLvl = fProLvl;
		this.fYear2 = fYear2;
		this.fExcel = fExcel;
		this.fIsvvd = fIsvvd;
		this.fIsweek = fIsweek;
		this.fStpFlg = fStpFlg;
		this.fRevPodCd = fRevPodCd;
		this.fIsbkg = fIsbkg;
		this.fIsshpr = fIsshpr;
		this.fIsroute = fIsroute;
		this.fRfaNo = fRfaNo;
		this.fRepCmdtCd = fRepCmdtCd;
		//SJH.20141218.ADD
		this.fSvcScpCd = fSvcScpCd;
		this.fBkgPolCd = fBkgPolCd;
		this.fBkgPodCd = fBkgPodCd;
		this.fCustGrpNm = fCustGrpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_ofc_sts", getFOfcSts());
		this.hashColumns.put("f_excl_sts", getFExclSts());
		this.hashColumns.put("f_taa_no", getFTaaNo());
		this.hashColumns.put("f_rpt_item", getFRptItem());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_iscmdt", getFIscmdt());
		this.hashColumns.put("f_usa_bkg_mod_cd", getFUsaBkgModCd());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("f_sls_mon", getFSlsMon());
		this.hashColumns.put("f_cob_trade", getFCobTrade());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_curr_week", getFCurrWeek());
		this.hashColumns.put("f_wk_sts", getFWkSts());
		this.hashColumns.put("f_bkg_del_cd", getFBkgDelCd());
		this.hashColumns.put("f_srep_cd", getFSrepCd());
		this.hashColumns.put("f_issc", getFIssc());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_istpsz", getFIstpsz());
		this.hashColumns.put("f_usr_ofc_lvl", getFUsrOfcLvl());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_ofc_vw", getFOfcVw());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("f_sc_no", getFScNo());
		this.hashColumns.put("f_dir_sts", getFDirSts());
		this.hashColumns.put("f_usr_ofc_cd", getFUsrOfcCd());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_to_date", getFToDate());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_bkg_sts", getFBkgSts());
		this.hashColumns.put("f_fm_date", getFFmDate());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_bkg_por_cd", getFBkgPorCd());
		this.hashColumns.put("f_ioc_cd", getFIocCd());
		this.hashColumns.put("f_rev_pol_cd", getFRevPolCd());
		this.hashColumns.put("f_cob_lane", getFCobLane());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("f_rf_sts", getFRfSts());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_mon", getFMon());
		this.hashColumns.put("f_issrep", getFIssrep());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("f_wk", getFWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_sls_ofc_cd", getFSlsOfcCd());
		this.hashColumns.put("f_pro_vw", getFProVw());
		this.hashColumns.put("f_cob_subtrade", getFCobSubtrade());
		this.hashColumns.put("f_shpr_cd", getFShprCd());
		this.hashColumns.put("f_cob_bound", getFCobBound());
		this.hashColumns.put("f_bkg_no", getFBkgNo());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_rfa", getFRfa());
		this.hashColumns.put("f_prd_cd", getFPrdCd());
		this.hashColumns.put("f_ofc_lvl2", getFOfcLvl2());
		this.hashColumns.put("f_ofc_lvl1", getFOfcLvl1());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("f_prev_week", getFPrevWeek());
		this.hashColumns.put("f_pro_lvl", getFProLvl());
		this.hashColumns.put("f_year2", getFYear2());
		this.hashColumns.put("f_excel", getFExcel());
		this.hashColumns.put("f_isvvd", getFIsvvd());
		this.hashColumns.put("f_isweek", getFIsweek());
		this.hashColumns.put("f_stp_flg", getFStpFlg());
		this.hashColumns.put("f_rev_pod_cd", getFRevPodCd());
		this.hashColumns.put("f_isbkg", getFIsbkg());
		this.hashColumns.put("f_isshpr", getFIsshpr());
		this.hashColumns.put("f_isroute", getFIsroute());
		this.hashColumns.put("f_rfa_no", getFRfaNo());
		this.hashColumns.put("f_rep_cmdt_cd", getFRepCmdtCd());
		//SJH.20141218.ADD
		this.hashColumns.put("f_svc_scp_cd", getFSvcScpCd());
		this.hashColumns.put("f_bkg_pol_cd", getFBkgPolCd());
		this.hashColumns.put("f_bkg_pod_cd", getFBkgPodCd());
		this.hashColumns.put("f_cust_grp_nm", getFCustGrpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_ofc_sts", "fOfcSts");
		this.hashFields.put("f_excl_sts", "fExclSts");
		this.hashFields.put("f_taa_no", "fTaaNo");
		this.hashFields.put("f_rpt_item", "fRptItem");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_iscmdt", "fIscmdt");
		this.hashFields.put("f_usa_bkg_mod_cd", "fUsaBkgModCd");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("f_sls_mon", "fSlsMon");
		this.hashFields.put("f_cob_trade", "fCobTrade");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_curr_week", "fCurrWeek");
		this.hashFields.put("f_wk_sts", "fWkSts");
		this.hashFields.put("f_bkg_del_cd", "fBkgDelCd");
		this.hashFields.put("f_srep_cd", "fSrepCd");
		this.hashFields.put("f_issc", "fIssc");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_istpsz", "fIstpsz");
		this.hashFields.put("f_usr_ofc_lvl", "fUsrOfcLvl");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_ofc_vw", "fOfcVw");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("f_sc_no", "fScNo");
		this.hashFields.put("f_dir_sts", "fDirSts");
		this.hashFields.put("f_usr_ofc_cd", "fUsrOfcCd");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_to_date", "fToDate");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_bkg_sts", "fBkgSts");
		this.hashFields.put("f_fm_date", "fFmDate");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_bkg_por_cd", "fBkgPorCd");
		this.hashFields.put("f_ioc_cd", "fIocCd");
		this.hashFields.put("f_rev_pol_cd", "fRevPolCd");
		this.hashFields.put("f_cob_lane", "fCobLane");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("f_rf_sts", "fRfSts");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_mon", "fMon");
		this.hashFields.put("f_issrep", "fIssrep");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("f_wk", "fWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_sls_ofc_cd", "fSlsOfcCd");
		this.hashFields.put("f_pro_vw", "fProVw");
		this.hashFields.put("f_cob_subtrade", "fCobSubtrade");
		this.hashFields.put("f_shpr_cd", "fShprCd");
		this.hashFields.put("f_cob_bound", "fCobBound");
		this.hashFields.put("f_bkg_no", "fBkgNo");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_rfa", "fRfa");
		this.hashFields.put("f_prd_cd", "fPrdCd");
		this.hashFields.put("f_ofc_lvl2", "fOfcLvl2");
		this.hashFields.put("f_ofc_lvl1", "fOfcLvl1");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("f_prev_week", "fPrevWeek");
		this.hashFields.put("f_pro_lvl", "fProLvl");
		this.hashFields.put("f_year2", "fYear2");
		this.hashFields.put("f_excel", "fExcel");
		this.hashFields.put("f_isvvd", "fIsvvd");
		this.hashFields.put("f_isweek", "fIsweek");
		this.hashFields.put("f_stp_flg", "fStpFlg");
		this.hashFields.put("f_rev_pod_cd", "fRevPodCd");
		this.hashFields.put("f_isbkg", "fIsbkg");
		this.hashFields.put("f_isshpr", "fIsshpr");
		this.hashFields.put("f_isroute", "fIsroute");
		this.hashFields.put("f_rfa_no", "fRfaNo");
		this.hashFields.put("f_rep_cmdt_cd", "fRepCmdtCd");
		//SJH.20141218.ADD
		this.hashFields.put("f_svc_scp_cd", "fSvcScpCd");
		this.hashFields.put("f_bkg_pol_cd", "fBkgPolCd");
		this.hashFields.put("f_bkg_pod_cd", "fBkgPodCd");
		this.hashFields.put("f_cust_grp_nm", "fCustGrpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fOfcSts
	 */
	public String getFOfcSts() {
		return this.fOfcSts;
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
	 * @return fRptItem
	 */
	public String getFRptItem() {
		return this.fRptItem;
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
	 * @return fIscmdt
	 */
	public String getFIscmdt() {
		return this.fIscmdt;
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
	 * @return fCobTrade
	 */
	public String getFCobTrade() {
		return this.fCobTrade;
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
	 * @return fCurrWeek
	 */
	public String getFCurrWeek() {
		return this.fCurrWeek;
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
	 * @return fBkgDelCd
	 */
	public String getFBkgDelCd() {
		return this.fBkgDelCd;
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
	 * @return fIssc
	 */
	public String getFIssc() {
		return this.fIssc;
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
	 * @return fIstpsz
	 */
	public String getFIstpsz() {
		return this.fIstpsz;
	}
	
	/**
	 * Column Info
	 * @return fUsrOfcLvl
	 */
	public String getFUsrOfcLvl() {
		return this.fUsrOfcLvl;
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
	 * @return fUsrOfcCd
	 */
	public String getFUsrOfcCd() {
		return this.fUsrOfcCd;
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
	 * @return fToDate
	 */
	public String getFToDate() {
		return this.fToDate;
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
	 * @return fBkgSts
	 */
	public String getFBkgSts() {
		return this.fBkgSts;
	}
	
	/**
	 * Column Info
	 * @return fFmDate
	 */
	public String getFFmDate() {
		return this.fFmDate;
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
	 * @return fRevPolCd
	 */
	public String getFRevPolCd() {
		return this.fRevPolCd;
	}
	
	/**
	 * Column Info
	 * @return fCobLane
	 */
	public String getFCobLane() {
		return this.fCobLane;
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
	 * @return fRfSts
	 */
	public String getFRfSts() {
		return this.fRfSts;
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
	 * @return fMon
	 */
	public String getFMon() {
		return this.fMon;
	}
	
	/**
	 * Column Info
	 * @return fIssrep
	 */
	public String getFIssrep() {
		return this.fIssrep;
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
	 * @return fWk
	 */
	public String getFWk() {
		return this.fWk;
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
	 * @return fCobSubtrade
	 */
	public String getFCobSubtrade() {
		return this.fCobSubtrade;
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
	 * @return fCobBound
	 */
	public String getFCobBound() {
		return this.fCobBound;
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
	 * @return fPrdCd
	 */
	public String getFPrdCd() {
		return this.fPrdCd;
	}
	
	/**
	 * Column Info
	 * @return fOfcLvl2
	 */
	public String getFOfcLvl2() {
		return this.fOfcLvl2;
	}
	
	/**
	 * Column Info
	 * @return fOfcLvl1
	 */
	public String getFOfcLvl1() {
		return this.fOfcLvl1;
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
	 * @return fPrevWeek
	 */
	public String getFPrevWeek() {
		return this.fPrevWeek;
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
	 * @return fYear2
	 */
	public String getFYear2() {
		return this.fYear2;
	}
	
	/**
	 * Column Info
	 * @return fExcel
	 */
	public String getFExcel() {
		return this.fExcel;
	}
	
	/**
	 * Column Info
	 * @return fIsvvd
	 */
	public String getFIsvvd() {
		return this.fIsvvd;
	}
	
	/**
	 * Column Info
	 * @return fIsweek
	 */
	public String getFIsweek() {
		return this.fIsweek;
	}
	
	/**
	 * Column Info
	 * @return fStpFlg
	 */
	public String getFStpFlg() {
		return this.fStpFlg;
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
	 * @return fIsbkg
	 */
	public String getFIsbkg() {
		return this.fIsbkg;
	}
	
	/**
	 * Column Info
	 * @return fIsshpr
	 */
	public String getFIsshpr() {
		return this.fIsshpr;
	}
	
	/**
	 * Column Info
	 * @return fIsroute
	 */
	public String getFIsroute() {
		return this.fIsroute;
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
	 * @return fRepCmdtCd
	 */
	public String getFRepCmdtCd() {
		return this.fRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return fSvcScpCd
	 * @author SJH.20141218.ADD
	 */
	public String getFSvcScpCd() {
		return this.fSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgPolCd
	 * @author SJH.20141218.ADD
	 */
	public String getFBkgPolCd() {
		return this.fBkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgPodCd
	 * @author SJH.20141218.ADD
	 */
	public String getFBkgPodCd() {
		return this.fBkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return fCustGrpNm
	 * @author SJH.20141218.ADD
	 */
	public String getFCustGrpNm() {
		return this.fCustGrpNm;
	}	
	

	/**
	 * Column Info
	 * @param fOfcSts
	 */
	public void setFOfcSts(String fOfcSts) {
		this.fOfcSts = fOfcSts;
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
	 * @param fRptItem
	 */
	public void setFRptItem(String fRptItem) {
		this.fRptItem = fRptItem;
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
	 * @param fIscmdt
	 */
	public void setFIscmdt(String fIscmdt) {
		this.fIscmdt = fIscmdt;
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
	 * @param fCobTrade
	 */
	public void setFCobTrade(String fCobTrade) {
		this.fCobTrade = fCobTrade;
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
	 * @param fCurrWeek
	 */
	public void setFCurrWeek(String fCurrWeek) {
		this.fCurrWeek = fCurrWeek;
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
	 * @param fBkgDelCd
	 */
	public void setFBkgDelCd(String fBkgDelCd) {
		this.fBkgDelCd = fBkgDelCd;
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
	 * @param fIssc
	 */
	public void setFIssc(String fIssc) {
		this.fIssc = fIssc;
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
	 * @param fIstpsz
	 */
	public void setFIstpsz(String fIstpsz) {
		this.fIstpsz = fIstpsz;
	}
	
	/**
	 * Column Info
	 * @param fUsrOfcLvl
	 */
	public void setFUsrOfcLvl(String fUsrOfcLvl) {
		this.fUsrOfcLvl = fUsrOfcLvl;
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
	 * @param fUsrOfcCd
	 */
	public void setFUsrOfcCd(String fUsrOfcCd) {
		this.fUsrOfcCd = fUsrOfcCd;
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
	 * @param fToDate
	 */
	public void setFToDate(String fToDate) {
		this.fToDate = fToDate;
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
	 * @param fBkgSts
	 */
	public void setFBkgSts(String fBkgSts) {
		this.fBkgSts = fBkgSts;
	}
	
	/**
	 * Column Info
	 * @param fFmDate
	 */
	public void setFFmDate(String fFmDate) {
		this.fFmDate = fFmDate;
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
	 * @param fRevPolCd
	 */
	public void setFRevPolCd(String fRevPolCd) {
		this.fRevPolCd = fRevPolCd;
	}
	
	/**
	 * Column Info
	 * @param fCobLane
	 */
	public void setFCobLane(String fCobLane) {
		this.fCobLane = fCobLane;
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
	 * @param fRfSts
	 */
	public void setFRfSts(String fRfSts) {
		this.fRfSts = fRfSts;
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
	 * @param fMon
	 */
	public void setFMon(String fMon) {
		this.fMon = fMon;
	}
	
	/**
	 * Column Info
	 * @param fIssrep
	 */
	public void setFIssrep(String fIssrep) {
		this.fIssrep = fIssrep;
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
	 * @param fWk
	 */
	public void setFWk(String fWk) {
		this.fWk = fWk;
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
	 * @param fCobSubtrade
	 */
	public void setFCobSubtrade(String fCobSubtrade) {
		this.fCobSubtrade = fCobSubtrade;
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
	 * @param fCobBound
	 */
	public void setFCobBound(String fCobBound) {
		this.fCobBound = fCobBound;
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
	 * @param fPrdCd
	 */
	public void setFPrdCd(String fPrdCd) {
		this.fPrdCd = fPrdCd;
	}
	
	/**
	 * Column Info
	 * @param fOfcLvl2
	 */
	public void setFOfcLvl2(String fOfcLvl2) {
		this.fOfcLvl2 = fOfcLvl2;
	}
	
	/**
	 * Column Info
	 * @param fOfcLvl1
	 */
	public void setFOfcLvl1(String fOfcLvl1) {
		this.fOfcLvl1 = fOfcLvl1;
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
	 * @param fPrevWeek
	 */
	public void setFPrevWeek(String fPrevWeek) {
		this.fPrevWeek = fPrevWeek;
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
	 * @param fYear2
	 */
	public void setFYear2(String fYear2) {
		this.fYear2 = fYear2;
	}
	
	/**
	 * Column Info
	 * @param fExcel
	 */
	public void setFExcel(String fExcel) {
		this.fExcel = fExcel;
	}
	
	/**
	 * Column Info
	 * @param fIsvvd
	 */
	public void setFIsvvd(String fIsvvd) {
		this.fIsvvd = fIsvvd;
	}
	
	/**
	 * Column Info
	 * @param fIsweek
	 */
	public void setFIsweek(String fIsweek) {
		this.fIsweek = fIsweek;
	}
	
	/**
	 * Column Info
	 * @param fStpFlg
	 */
	public void setFStpFlg(String fStpFlg) {
		this.fStpFlg = fStpFlg;
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
	 * @param fIsbkg
	 */
	public void setFIsbkg(String fIsbkg) {
		this.fIsbkg = fIsbkg;
	}
	
	/**
	 * Column Info
	 * @param fIsshpr
	 */
	public void setFIsshpr(String fIsshpr) {
		this.fIsshpr = fIsshpr;
	}
	
	/**
	 * Column Info
	 * @param fIsroute
	 */
	public void setFIsroute(String fIsroute) {
		this.fIsroute = fIsroute;
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
	 * @param fRepCmdtCd
	 */
	public void setFRepCmdtCd(String fRepCmdtCd) {
		this.fRepCmdtCd = fRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param fSvcScpCd
	 * @author SJH.20141218.ADD
	 */
	public void setFSvcScpCd(String fSvcScpCd) {
		this.fSvcScpCd = fSvcScpCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgPolCd
	 * @author SJH.20141218.ADD
	 */
	public void setFBkgPolCd(String fBkgPolCd) {
		this.fBkgPolCd = fBkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgPodCd
	 * @author SJH.20141218.ADD
	 */
	public void setFBkgPodCd(String fBkgPodCd) {
		this.fBkgPodCd = fBkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param fCustGrpNm
	 * @author SJH.20141218.ADD
	 */
	public void setFCustGrpNm(String fCustGrpNm) {
		this.fCustGrpNm = fCustGrpNm;
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
		setFOfcSts(JSPUtil.getParameter(request, prefix + "f_ofc_sts", ""));
		setFExclSts(JSPUtil.getParameter(request, prefix + "f_excl_sts", ""));
		setFTaaNo(JSPUtil.getParameter(request, prefix + "f_taa_no", ""));
		setFRptItem(JSPUtil.getParameter(request, prefix + "f_rpt_item", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setFIscmdt(JSPUtil.getParameter(request, prefix + "f_iscmdt", ""));
		setFUsaBkgModCd(JSPUtil.getParameter(request, prefix + "f_usa_bkg_mod_cd", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setFSlsMon(JSPUtil.getParameter(request, prefix + "f_sls_mon", ""));
		setFCobTrade(JSPUtil.getParameter(request, prefix + "f_cob_trade", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFCurrWeek(JSPUtil.getParameter(request, prefix + "f_curr_week", ""));
		setFWkSts(JSPUtil.getParameter(request, prefix + "f_wk_sts", ""));
		setFBkgDelCd(JSPUtil.getParameter(request, prefix + "f_bkg_del_cd", ""));
		setFSrepCd(JSPUtil.getParameter(request, prefix + "f_srep_cd", ""));
		setFIssc(JSPUtil.getParameter(request, prefix + "f_issc", ""));
		setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
		setFIstpsz(JSPUtil.getParameter(request, prefix + "f_istpsz", ""));
		setFUsrOfcLvl(JSPUtil.getParameter(request, prefix + "f_usr_ofc_lvl", ""));
		setFOfcLvl(JSPUtil.getParameter(request, prefix + "f_ofc_lvl", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFOfcVw(JSPUtil.getParameter(request, prefix + "f_ofc_vw", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
		setFScNo(JSPUtil.getParameter(request, prefix + "f_sc_no", ""));
		setFDirSts(JSPUtil.getParameter(request, prefix + "f_dir_sts", ""));
		setFUsrOfcCd(JSPUtil.getParameter(request, prefix + "f_usr_ofc_cd", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setFToDate(JSPUtil.getParameter(request, prefix + "f_to_date", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setFBkgSts(JSPUtil.getParameter(request, prefix + "f_bkg_sts", ""));
		setFFmDate(JSPUtil.getParameter(request, prefix + "f_fm_date", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setFBkgPorCd(JSPUtil.getParameter(request, prefix + "f_bkg_por_cd", ""));
		setFIocCd(JSPUtil.getParameter(request, prefix + "f_ioc_cd", ""));
		setFRevPolCd(JSPUtil.getParameter(request, prefix + "f_rev_pol_cd", ""));
		setFCobLane(JSPUtil.getParameter(request, prefix + "f_cob_lane", ""));
		setFYear(JSPUtil.getParameter(request, prefix + "f_year", ""));
		setFRfSts(JSPUtil.getParameter(request, prefix + "f_rf_sts", ""));
		setFChkprd(JSPUtil.getParameter(request, prefix + "f_chkprd", ""));
		setFMon(JSPUtil.getParameter(request, prefix + "f_mon", ""));
		setFIssrep(JSPUtil.getParameter(request, prefix + "f_issrep", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setFWk(JSPUtil.getParameter(request, prefix + "f_wk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFSlsOfcCd(JSPUtil.getParameter(request, prefix + "f_sls_ofc_cd", ""));
		setFProVw(JSPUtil.getParameter(request, prefix + "f_pro_vw", ""));
		setFCobSubtrade(JSPUtil.getParameter(request, prefix + "f_cob_subtrade", ""));
		setFShprCd(JSPUtil.getParameter(request, prefix + "f_shpr_cd", ""));
		setFCobBound(JSPUtil.getParameter(request, prefix + "f_cob_bound", ""));
		setFBkgNo(JSPUtil.getParameter(request, prefix + "f_bkg_no", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", ""));
		setFRfa(JSPUtil.getParameter(request, prefix + "f_rfa", ""));
		setFPrdCd(JSPUtil.getParameter(request, prefix + "f_prd_cd", ""));
		setFOfcLvl2(JSPUtil.getParameter(request, prefix + "f_ofc_lvl2", ""));
		setFOfcLvl1(JSPUtil.getParameter(request, prefix + "f_ofc_lvl1", ""));
		setFOfcCd(JSPUtil.getParameter(request, prefix + "f_ofc_cd", ""));
		setFPrevWeek(JSPUtil.getParameter(request, prefix + "f_prev_week", ""));
		setFProLvl(JSPUtil.getParameter(request, prefix + "f_pro_lvl", ""));
		setFYear2(JSPUtil.getParameter(request, prefix + "f_year2", ""));
		setFExcel(JSPUtil.getParameter(request, prefix + "f_excel", ""));
		setFIsvvd(JSPUtil.getParameter(request, prefix + "f_isvvd", ""));
		setFIsweek(JSPUtil.getParameter(request, prefix + "f_isweek", ""));
		setFStpFlg(JSPUtil.getParameter(request, prefix + "f_stp_flg", ""));
		setFRevPodCd(JSPUtil.getParameter(request, prefix + "f_rev_pod_cd", ""));
		setFIsbkg(JSPUtil.getParameter(request, prefix + "f_isbkg", ""));
		setFIsshpr(JSPUtil.getParameter(request, prefix + "f_isshpr", ""));
		setFIsroute(JSPUtil.getParameter(request, prefix + "f_isroute", ""));
		setFRfaNo(JSPUtil.getParameter(request, prefix + "f_rfa_no", ""));
		setFRepCmdtCd(JSPUtil.getParameter(request, prefix + "f_rep_cmdt_cd", ""));
		//SJH.20141218.ADD
		setFSvcScpCd(JSPUtil.getParameter(request, prefix + "f_svc_scp_cd", ""));
		setFBkgPolCd(JSPUtil.getParameter(request, prefix + "f_bkg_pol_cd", ""));
		setFBkgPodCd(JSPUtil.getParameter(request, prefix + "f_bkg_pod_cd", ""));
		setFCustGrpNm(JSPUtil.getParameter(request, prefix + "f_cust_grp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SalesOffiRepoConditionVO[]
	 */
	public SalesOffiRepoConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SalesOffiRepoConditionVO[]
	 */
	public SalesOffiRepoConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SalesOffiRepoConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fOfcSts = (JSPUtil.getParameter(request, prefix	+ "f_ofc_sts", length));
			String[] fExclSts = (JSPUtil.getParameter(request, prefix	+ "f_excl_sts", length));
			String[] fTaaNo = (JSPUtil.getParameter(request, prefix	+ "f_taa_no", length));
			String[] fRptItem = (JSPUtil.getParameter(request, prefix	+ "f_rpt_item", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fIscmdt = (JSPUtil.getParameter(request, prefix	+ "f_iscmdt", length));
			String[] fUsaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "f_usa_bkg_mod_cd", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] fSlsMon = (JSPUtil.getParameter(request, prefix	+ "f_sls_mon", length));
			String[] fCobTrade = (JSPUtil.getParameter(request, prefix	+ "f_cob_trade", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fCurrWeek = (JSPUtil.getParameter(request, prefix	+ "f_curr_week", length));
			String[] fWkSts = (JSPUtil.getParameter(request, prefix	+ "f_wk_sts", length));
			String[] fBkgDelCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_del_cd", length));
			String[] fSrepCd = (JSPUtil.getParameter(request, prefix	+ "f_srep_cd", length));
			String[] fIssc = (JSPUtil.getParameter(request, prefix	+ "f_issc", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fIstpsz = (JSPUtil.getParameter(request, prefix	+ "f_istpsz", length));
			String[] fUsrOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_usr_ofc_lvl", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fOfcVw = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] fScNo = (JSPUtil.getParameter(request, prefix	+ "f_sc_no", length));
			String[] fDirSts = (JSPUtil.getParameter(request, prefix	+ "f_dir_sts", length));
			String[] fUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_usr_ofc_cd", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fToDate = (JSPUtil.getParameter(request, prefix	+ "f_to_date", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fBkgSts = (JSPUtil.getParameter(request, prefix	+ "f_bkg_sts", length));
			String[] fFmDate = (JSPUtil.getParameter(request, prefix	+ "f_fm_date", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fBkgPorCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_por_cd", length));
			String[] fIocCd = (JSPUtil.getParameter(request, prefix	+ "f_ioc_cd", length));
			String[] fRevPolCd = (JSPUtil.getParameter(request, prefix	+ "f_rev_pol_cd", length));
			String[] fCobLane = (JSPUtil.getParameter(request, prefix	+ "f_cob_lane", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] fRfSts = (JSPUtil.getParameter(request, prefix	+ "f_rf_sts", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fMon = (JSPUtil.getParameter(request, prefix	+ "f_mon", length));
			String[] fIssrep = (JSPUtil.getParameter(request, prefix	+ "f_issrep", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] fWk = (JSPUtil.getParameter(request, prefix	+ "f_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_sls_ofc_cd", length));
			String[] fProVw = (JSPUtil.getParameter(request, prefix	+ "f_pro_vw", length));
			String[] fCobSubtrade = (JSPUtil.getParameter(request, prefix	+ "f_cob_subtrade", length));
			String[] fShprCd = (JSPUtil.getParameter(request, prefix	+ "f_shpr_cd", length));
			String[] fCobBound = (JSPUtil.getParameter(request, prefix	+ "f_cob_bound", length));
			String[] fBkgNo = (JSPUtil.getParameter(request, prefix	+ "f_bkg_no", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fRfa = (JSPUtil.getParameter(request, prefix	+ "f_rfa", length));
			String[] fPrdCd = (JSPUtil.getParameter(request, prefix	+ "f_prd_cd", length));
			String[] fOfcLvl2 = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl2", length));
			String[] fOfcLvl1 = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl1", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] fPrevWeek = (JSPUtil.getParameter(request, prefix	+ "f_prev_week", length));
			String[] fProLvl = (JSPUtil.getParameter(request, prefix	+ "f_pro_lvl", length));
			String[] fYear2 = (JSPUtil.getParameter(request, prefix	+ "f_year2", length));
			String[] fExcel = (JSPUtil.getParameter(request, prefix	+ "f_excel", length));
			String[] fIsvvd = (JSPUtil.getParameter(request, prefix	+ "f_isvvd", length));
			String[] fIsweek = (JSPUtil.getParameter(request, prefix	+ "f_isweek", length));
			String[] fStpFlg = (JSPUtil.getParameter(request, prefix	+ "f_stp_flg", length));
			String[] fRevPodCd = (JSPUtil.getParameter(request, prefix	+ "f_rev_pod_cd", length));
			String[] fIsbkg = (JSPUtil.getParameter(request, prefix	+ "f_isbkg", length));
			String[] fIsshpr = (JSPUtil.getParameter(request, prefix	+ "f_isshpr", length));
			String[] fIsroute = (JSPUtil.getParameter(request, prefix	+ "f_isroute", length));
			String[] fRfaNo = (JSPUtil.getParameter(request, prefix	+ "f_rfa_no", length));
			String[] fRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "f_rep_cmdt_cd", length));
			//SJH.20141218.ADD
			String[] fSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "f_svc_scp_cd", length));
			String[] fBkgPolCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_pol_cd", length));
			String[] fBkgPodCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_pod_cd", length));
			String[] fCustGrpNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_grp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SalesOffiRepoConditionVO();
				if (fOfcSts[i] != null)
					model.setFOfcSts(fOfcSts[i]);
				if (fExclSts[i] != null)
					model.setFExclSts(fExclSts[i]);
				if (fTaaNo[i] != null)
					model.setFTaaNo(fTaaNo[i]);
				if (fRptItem[i] != null)
					model.setFRptItem(fRptItem[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fIscmdt[i] != null)
					model.setFIscmdt(fIscmdt[i]);
				if (fUsaBkgModCd[i] != null)
					model.setFUsaBkgModCd(fUsaBkgModCd[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (fSlsMon[i] != null)
					model.setFSlsMon(fSlsMon[i]);
				if (fCobTrade[i] != null)
					model.setFCobTrade(fCobTrade[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCurrWeek[i] != null)
					model.setFCurrWeek(fCurrWeek[i]);
				if (fWkSts[i] != null)
					model.setFWkSts(fWkSts[i]);
				if (fBkgDelCd[i] != null)
					model.setFBkgDelCd(fBkgDelCd[i]);
				if (fSrepCd[i] != null)
					model.setFSrepCd(fSrepCd[i]);
				if (fIssc[i] != null)
					model.setFIssc(fIssc[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fIstpsz[i] != null)
					model.setFIstpsz(fIstpsz[i]);
				if (fUsrOfcLvl[i] != null)
					model.setFUsrOfcLvl(fUsrOfcLvl[i]);
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
				if (fScNo[i] != null)
					model.setFScNo(fScNo[i]);
				if (fDirSts[i] != null)
					model.setFDirSts(fDirSts[i]);
				if (fUsrOfcCd[i] != null)
					model.setFUsrOfcCd(fUsrOfcCd[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fToDate[i] != null)
					model.setFToDate(fToDate[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fBkgSts[i] != null)
					model.setFBkgSts(fBkgSts[i]);
				if (fFmDate[i] != null)
					model.setFFmDate(fFmDate[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fBkgPorCd[i] != null)
					model.setFBkgPorCd(fBkgPorCd[i]);
				if (fIocCd[i] != null)
					model.setFIocCd(fIocCd[i]);
				if (fRevPolCd[i] != null)
					model.setFRevPolCd(fRevPolCd[i]);
				if (fCobLane[i] != null)
					model.setFCobLane(fCobLane[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (fRfSts[i] != null)
					model.setFRfSts(fRfSts[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fMon[i] != null)
					model.setFMon(fMon[i]);
				if (fIssrep[i] != null)
					model.setFIssrep(fIssrep[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (fWk[i] != null)
					model.setFWk(fWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fSlsOfcCd[i] != null)
					model.setFSlsOfcCd(fSlsOfcCd[i]);
				if (fProVw[i] != null)
					model.setFProVw(fProVw[i]);
				if (fCobSubtrade[i] != null)
					model.setFCobSubtrade(fCobSubtrade[i]);
				if (fShprCd[i] != null)
					model.setFShprCd(fShprCd[i]);
				if (fCobBound[i] != null)
					model.setFCobBound(fCobBound[i]);
				if (fBkgNo[i] != null)
					model.setFBkgNo(fBkgNo[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fRfa[i] != null)
					model.setFRfa(fRfa[i]);
				if (fPrdCd[i] != null)
					model.setFPrdCd(fPrdCd[i]);
				if (fOfcLvl2[i] != null)
					model.setFOfcLvl2(fOfcLvl2[i]);
				if (fOfcLvl1[i] != null)
					model.setFOfcLvl1(fOfcLvl1[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (fPrevWeek[i] != null)
					model.setFPrevWeek(fPrevWeek[i]);
				if (fProLvl[i] != null)
					model.setFProLvl(fProLvl[i]);
				if (fYear2[i] != null)
					model.setFYear2(fYear2[i]);
				if (fExcel[i] != null)
					model.setFExcel(fExcel[i]);
				if (fIsvvd[i] != null)
					model.setFIsvvd(fIsvvd[i]);
				if (fIsweek[i] != null)
					model.setFIsweek(fIsweek[i]);
				if (fStpFlg[i] != null)
					model.setFStpFlg(fStpFlg[i]);
				if (fRevPodCd[i] != null)
					model.setFRevPodCd(fRevPodCd[i]);
				if (fIsbkg[i] != null)
					model.setFIsbkg(fIsbkg[i]);
				if (fIsshpr[i] != null)
					model.setFIsshpr(fIsshpr[i]);
				if (fIsroute[i] != null)
					model.setFIsroute(fIsroute[i]);
				if (fRfaNo[i] != null)
					model.setFRfaNo(fRfaNo[i]);
				if (fRepCmdtCd[i] != null)
					model.setFRepCmdtCd(fRepCmdtCd[i]);				
				//SJH.20141218.ADD
				if (fSvcScpCd[i] != null)
					model.setFSvcScpCd(fSvcScpCd[i]);
				if (fBkgPolCd[i] != null)
					model.setFBkgPolCd(fBkgPolCd[i]);
				if (fBkgPodCd[i] != null)
					model.setFBkgPodCd(fBkgPodCd[i]);
				if (fCustGrpNm[i] != null)
					model.setFCustGrpNm(fCustGrpNm[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSalesOffiRepoConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SalesOffiRepoConditionVO[]
	 */
	public SalesOffiRepoConditionVO[] getSalesOffiRepoConditionVOs(){
		SalesOffiRepoConditionVO[] vos = (SalesOffiRepoConditionVO[])models.toArray(new SalesOffiRepoConditionVO[models.size()]);
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
		this.fOfcSts = this.fOfcSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExclSts = this.fExclSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTaaNo = this.fTaaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRptItem = this.fRptItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIscmdt = this.fIscmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsaBkgModCd = this.fUsaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsMon = this.fSlsMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobTrade = this.fCobTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCurrWeek = this.fCurrWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fWkSts = this.fWkSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgDelCd = this.fBkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrepCd = this.fSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIssc = this.fIssc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIstpsz = this.fIstpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrOfcLvl = this.fUsrOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVw = this.fOfcVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScNo = this.fScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirSts = this.fDirSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrOfcCd = this.fUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToDate = this.fToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgSts = this.fBkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmDate = this.fFmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPorCd = this.fBkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIocCd = this.fIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevPolCd = this.fRevPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobLane = this.fCobLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfSts = this.fRfSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMon = this.fMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIssrep = this.fIssrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fWk = this.fWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsOfcCd = this.fSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProVw = this.fProVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobSubtrade = this.fCobSubtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fShprCd = this.fShprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCobBound = this.fCobBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgNo = this.fBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfa = this.fRfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPrdCd = this.fPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl2 = this.fOfcLvl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl1 = this.fOfcLvl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPrevWeek = this.fPrevWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProLvl = this.fProLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear2 = this.fYear2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExcel = this.fExcel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIsvvd = this.fIsvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIsweek = this.fIsweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStpFlg = this.fStpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRevPodCd = this.fRevPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIsbkg = this.fIsbkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIsshpr = this.fIsshpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIsroute = this.fIsroute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfaNo = this.fRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRepCmdtCd = this.fRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//SJH.20141218.ADD
		this.fSvcScpCd = this.fSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPolCd = this.fBkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPodCd = this.fBkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustGrpNm = this.fCustGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
