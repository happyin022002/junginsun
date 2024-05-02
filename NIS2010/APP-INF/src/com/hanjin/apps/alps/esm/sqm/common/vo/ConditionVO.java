/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ConditionVO.java
*@FileTitle : ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.08.10 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.common.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConditionVO> models = new ArrayList<ConditionVO>();
	
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fOrgCd = null;
	/* Column Info */
	private String fBseWk = null;
	/* Column Info */
	private String fQtaTgtCd = null;
	/* Column Info */
	private String fTrdDir = null;
	/* Column Info */
	private String fAplyFlg = null;
	/* Column Info */
	private String fChkWeek = null;
	/* Column Info */
	private String fHoTeamCd = null;
	/* Column Info */
	private String fAcctTgtCd = null;
	/* Column Info */
	private String fIasSctrFlg = null;
	/* Column Info */
	private String fBseTpCd = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String fHulBndCd = null;
	/* Column Info */
	private String fChkAlocQta = null;
	/* Column Info */
	private String fBatId = null;
	/* Column Info */
	private String fCustGrpId = null;
	/* Column Info */
	private String fObDivCd = null;
	/* Column Info */
	private String fPfSvcTpCd = null;
	/* Column Info */
	private String fCrntQtaCd = null;
	/* Column Info */
	private String fCrntBseYr = null;
	/* Column Info */
	private String fPortionLink = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fChkPair = null;
	/* Column Info */
	private String fIasRgnCd = null;
	/* Column Info */
	private String fQtaStepCd = null;
	/* Column Info */
	private String fOfcVwCd = null;
	/* Column Info */
	private String fGubun = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fIoBound = null;
	/* Column Info */
	private String fCCnt = null;
	/* Column Info */
	private String fClick = null;
	/* Column Info */
	private String fConvDirCd = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String fDisMas = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String fYearTpCd = null;
	/* Column Info */
	private String chkWeek = null;
	/* Column Info */
	private String fSrcTrdCd = null;
	/* Column Info */
	private String fChkDecimal = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fSqmMnSctrFlg = null;
	/* Column Info */
	private String fBseYr = null;
	/* Column Info */
	private String fSubTrdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fChkRpbCmpb = null;
	/* Column Info */
	private String fOfcLvl = null;
	/* Column Info */
	private String fRdFlg = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fSrcRgnOfcCd = null;
	/* Column Info */
	private String fSrcRhqCd = null;
	/* Column Info */
	private String fAddFlg = null;
	/* Column Info */
	private String fActiveFlg = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fPfGrpCd = null;
	/* Column Info */
	private String fRgnOfcCd = null;
	/* Column Info */
	private String fChkVvd = null;
	/* Column Info */
	private String fLaneDirCd = null;
	/* Column Info */
	private String fBseMon = null;
	/* Column Info */
	private String fBseQtrCd = null;
	/* Column Info */
	private String fPolCd = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fDgFlg = null;
	/* Column Info */
	private String fNewRlaneCd = null;
	/* Column Info */
	private String fPodCd = null;
	/* Column Info */
	private String fBatStsCd = null;
	/* Column Info */
	private String fSpclTgtCd = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fSrcRlaneCd = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fActFlag = null;
	/* Column Info */
	private String fDuration = null;
	/* Column Info */
	private String fDecimalFlg = null;
	/* Column Info */
	private String fUsrId = null;
	/* Column Info */
	private String fSqmCngTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ConditionVO() {}

	public ConditionVO(String ibflag, String pagerows, String fTrdCd, String fOrgCd, String fBseWk, String fQtaTgtCd, String fTrdDir, String fAplyFlg, String fChkWeek, String fHoTeamCd, String fAcctTgtCd, String fIasSctrFlg, String fBseTpCd, String fSkdVoyNo, String fHulBndCd, String fChkAlocQta, String fCustGrpId, String fObDivCd, String fCrntQtaCd, String fCrntBseYr, String fPortionLink, String fChkPair, String fIasRgnCd, String fQtaStepCd, String fOfcVwCd, String fGubun, String fToMon, String fIoBound, String fCCnt, String fClick, String fConvDirCd, String fRhqCd, String fDisMas, String fCntrTpszCd, String fYearTpCd, String chkWeek, String fSrcTrdCd, String fChkDecimal, String fSkdDirCd, String fFmWk, String fSqmMnSctrFlg, String fBseYr, String fSubTrdCd, String fChkRpbCmpb, String fOfcLvl, String fRdFlg, String fVslCd, String fSrcRgnOfcCd, String fSrcRhqCd, String fAddFlg, String fActiveFlg, String fRlaneCd, String fPfGrpCd, String fRgnOfcCd, String fChkVvd, String fLaneDirCd, String fBseMon, String fBseQtrCd, String fPolCd, String fFmMon, String fDgFlg, String fNewRlaneCd, String fPodCd, String fSpclTgtCd, String fToWk, String fSrcRlaneCd, String fDirCd, String fActFlag, String fDuration, String fDecimalFlg, String fUsrId, String fSqmCngTpCd, String fPfSvcTpCd, String fBatId, String fBatStsCd) {
		this.fTrdCd = fTrdCd;
		this.fOrgCd = fOrgCd;
		this.fBseWk = fBseWk;
		this.fQtaTgtCd = fQtaTgtCd;
		this.fTrdDir = fTrdDir;
		this.fAplyFlg = fAplyFlg;
		this.fChkWeek = fChkWeek;
		this.fHoTeamCd = fHoTeamCd;
		this.fAcctTgtCd = fAcctTgtCd;
		this.fIasSctrFlg = fIasSctrFlg;
		this.fBseTpCd = fBseTpCd;
		this.fSkdVoyNo = fSkdVoyNo;
		this.fHulBndCd = fHulBndCd;
		this.fChkAlocQta = fChkAlocQta;
		this.fBatId = fBatId;
		this.fCustGrpId = fCustGrpId;
		this.fObDivCd = fObDivCd;
		this.fPfSvcTpCd = fPfSvcTpCd;
		this.fCrntQtaCd = fCrntQtaCd;
		this.fCrntBseYr = fCrntBseYr;
		this.fPortionLink = fPortionLink;
		this.pagerows = pagerows;
		this.fChkPair = fChkPair;
		this.fIasRgnCd = fIasRgnCd;
		this.fQtaStepCd = fQtaStepCd;
		this.fOfcVwCd = fOfcVwCd;
		this.fGubun = fGubun;
		this.fToMon = fToMon;
		this.fIoBound = fIoBound;
		this.fCCnt = fCCnt;
		this.fClick = fClick;
		this.fConvDirCd = fConvDirCd;
		this.fRhqCd = fRhqCd;
		this.fDisMas = fDisMas;
		this.fCntrTpszCd = fCntrTpszCd;
		this.fYearTpCd = fYearTpCd;
		this.chkWeek = chkWeek;
		this.fSrcTrdCd = fSrcTrdCd;
		this.fChkDecimal = fChkDecimal;
		this.fSkdDirCd = fSkdDirCd;
		this.fFmWk = fFmWk;
		this.fSqmMnSctrFlg = fSqmMnSctrFlg;
		this.fBseYr = fBseYr;
		this.fSubTrdCd = fSubTrdCd;
		this.ibflag = ibflag;
		this.fChkRpbCmpb = fChkRpbCmpb;
		this.fOfcLvl = fOfcLvl;
		this.fRdFlg = fRdFlg;
		this.fVslCd = fVslCd;
		this.fSrcRgnOfcCd = fSrcRgnOfcCd;
		this.fSrcRhqCd = fSrcRhqCd;
		this.fAddFlg = fAddFlg;
		this.fActiveFlg = fActiveFlg;
		this.fRlaneCd = fRlaneCd;
		this.fPfGrpCd = fPfGrpCd;
		this.fRgnOfcCd = fRgnOfcCd;
		this.fChkVvd = fChkVvd;
		this.fLaneDirCd = fLaneDirCd;
		this.fBseMon = fBseMon;
		this.fBseQtrCd = fBseQtrCd;
		this.fPolCd = fPolCd;
		this.fFmMon = fFmMon;
		this.fDgFlg = fDgFlg;
		this.fNewRlaneCd = fNewRlaneCd;
		this.fPodCd = fPodCd;
		this.fBatStsCd = fBatStsCd;
		this.fSpclTgtCd = fSpclTgtCd;
		this.fToWk = fToWk;
		this.fSrcRlaneCd = fSrcRlaneCd;
		this.fDirCd = fDirCd;
		this.fActFlag = fActFlag;
		this.fDuration = fDuration;
		this.fDecimalFlg = fDecimalFlg;
		this.fUsrId = fUsrId;
		this.fSqmCngTpCd = fSqmCngTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_org_cd", getFOrgCd());
		this.hashColumns.put("f_bse_wk", getFBseWk());
		this.hashColumns.put("f_qta_tgt_cd", getFQtaTgtCd());
		this.hashColumns.put("f_trd_dir", getFTrdDir());
		this.hashColumns.put("f_aply_flg", getFAplyFlg());
		this.hashColumns.put("f_chk_week", getFChkWeek());
		this.hashColumns.put("f_ho_team_cd", getFHoTeamCd());
		this.hashColumns.put("f_acct_tgt_cd", getFAcctTgtCd());
		this.hashColumns.put("f_ias_sctr_flg", getFIasSctrFlg());
		this.hashColumns.put("f_bse_tp_cd", getFBseTpCd());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("f_hul_bnd_cd", getFHulBndCd());
		this.hashColumns.put("f_chk_aloc_qta", getFChkAlocQta());
		this.hashColumns.put("f_bat_id", getFBatId());
		this.hashColumns.put("f_cust_grp_id", getFCustGrpId());
		this.hashColumns.put("f_ob_div_cd", getFObDivCd());
		this.hashColumns.put("f_pf_svc_tp_cd", getFPfSvcTpCd());
		this.hashColumns.put("f_crnt_qta_cd", getFCrntQtaCd());
		this.hashColumns.put("f_crnt_bse_yr", getFCrntBseYr());
		this.hashColumns.put("f_portion_link", getFPortionLink());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_chk_pair", getFChkPair());
		this.hashColumns.put("f_ias_rgn_cd", getFIasRgnCd());
		this.hashColumns.put("f_qta_step_cd", getFQtaStepCd());
		this.hashColumns.put("f_ofc_vw_cd", getFOfcVwCd());
		this.hashColumns.put("f_gubun", getFGubun());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_io_bound", getFIoBound());
		this.hashColumns.put("f_c_cnt", getFCCnt());
		this.hashColumns.put("f_click", getFClick());
		this.hashColumns.put("f_conv_dir_cd", getFConvDirCd());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("f_dis_mas", getFDisMas());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("f_year_tp_cd", getFYearTpCd());
		this.hashColumns.put("chk_week", getChkWeek());
		this.hashColumns.put("f_src_trd_cd", getFSrcTrdCd());
		this.hashColumns.put("f_chk_decimal", getFChkDecimal());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_sqm_mn_sctr_flg", getFSqmMnSctrFlg());
		this.hashColumns.put("f_bse_yr", getFBseYr());
		this.hashColumns.put("f_sub_trd_cd", getFSubTrdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_chk_rpb_cmpb", getFChkRpbCmpb());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_rd_flg", getFRdFlg());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_src_rgn_ofc_cd", getFSrcRgnOfcCd());
		this.hashColumns.put("f_src_rhq_cd", getFSrcRhqCd());
		this.hashColumns.put("f_add_flg", getFAddFlg());
		this.hashColumns.put("f_active_flg", getFActiveFlg());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_pf_grp_cd", getFPfGrpCd());
		this.hashColumns.put("f_rgn_ofc_cd", getFRgnOfcCd());
		this.hashColumns.put("f_chk_vvd", getFChkVvd());
		this.hashColumns.put("f_lane_dir_cd", getFLaneDirCd());
		this.hashColumns.put("f_bse_mon", getFBseMon());
		this.hashColumns.put("f_bse_qtr_cd", getFBseQtrCd());
		this.hashColumns.put("f_pol_cd", getFPolCd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_dg_flg", getFDgFlg());
		this.hashColumns.put("f_new_rlane_cd", getFNewRlaneCd());
		this.hashColumns.put("f_pod_cd", getFPodCd());
		this.hashColumns.put("f_bat_sts_cd", getFBatStsCd());
		this.hashColumns.put("f_spcl_tgt_cd", getFSpclTgtCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_src_rlane_cd", getFSrcRlaneCd());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_act_flag", getFActFlag());
		this.hashColumns.put("f_duration", getFDuration());
		this.hashColumns.put("f_decimal_flg", getFDecimalFlg());
		this.hashColumns.put("f_usr_id", getFUsrId());
		this.hashColumns.put("f_sqm_cng_tp_cd", getFSqmCngTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_org_cd", "fOrgCd");
		this.hashFields.put("f_bse_wk", "fBseWk");
		this.hashFields.put("f_qta_tgt_cd", "fQtaTgtCd");
		this.hashFields.put("f_trd_dir", "fTrdDir");
		this.hashFields.put("f_aply_flg", "fAplyFlg");
		this.hashFields.put("f_chk_week", "fChkWeek");
		this.hashFields.put("f_ho_team_cd", "fHoTeamCd");
		this.hashFields.put("f_acct_tgt_cd", "fAcctTgtCd");
		this.hashFields.put("f_ias_sctr_flg", "fIasSctrFlg");
		this.hashFields.put("f_bse_tp_cd", "fBseTpCd");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("f_hul_bnd_cd", "fHulBndCd");
		this.hashFields.put("f_chk_aloc_qta", "fChkAlocQta");
		this.hashFields.put("f_bat_id", "fBatId");
		this.hashFields.put("f_cust_grp_id", "fCustGrpId");
		this.hashFields.put("f_ob_div_cd", "fObDivCd");
		this.hashFields.put("f_pf_svc_tp_cd", "fPfSvcTpCd");
		this.hashFields.put("f_crnt_qta_cd", "fCrntQtaCd");
		this.hashFields.put("f_crnt_bse_yr", "fCrntBseYr");
		this.hashFields.put("f_portion_link", "fPortionLink");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_chk_pair", "fChkPair");
		this.hashFields.put("f_ias_rgn_cd", "fIasRgnCd");
		this.hashFields.put("f_qta_step_cd", "fQtaStepCd");
		this.hashFields.put("f_ofc_vw_cd", "fOfcVwCd");
		this.hashFields.put("f_gubun", "fGubun");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_io_bound", "fIoBound");
		this.hashFields.put("f_c_cnt", "fCCnt");
		this.hashFields.put("f_click", "fClick");
		this.hashFields.put("f_conv_dir_cd", "fConvDirCd");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("f_dis_mas", "fDisMas");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("f_year_tp_cd", "fYearTpCd");
		this.hashFields.put("chk_week", "chkWeek");
		this.hashFields.put("f_src_trd_cd", "fSrcTrdCd");
		this.hashFields.put("f_chk_decimal", "fChkDecimal");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_sqm_mn_sctr_flg", "fSqmMnSctrFlg");
		this.hashFields.put("f_bse_yr", "fBseYr");
		this.hashFields.put("f_sub_trd_cd", "fSubTrdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_chk_rpb_cmpb", "fChkRpbCmpb");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_rd_flg", "fRdFlg");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_src_rgn_ofc_cd", "fSrcRgnOfcCd");
		this.hashFields.put("f_src_rhq_cd", "fSrcRhqCd");
		this.hashFields.put("f_add_flg", "fAddFlg");
		this.hashFields.put("f_active_flg", "fActiveFlg");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_pf_grp_cd", "fPfGrpCd");
		this.hashFields.put("f_rgn_ofc_cd", "fRgnOfcCd");
		this.hashFields.put("f_chk_vvd", "fChkVvd");
		this.hashFields.put("f_lane_dir_cd", "fLaneDirCd");
		this.hashFields.put("f_bse_mon", "fBseMon");
		this.hashFields.put("f_bse_qtr_cd", "fBseQtrCd");
		this.hashFields.put("f_pol_cd", "fPolCd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_dg_flg", "fDgFlg");
		this.hashFields.put("f_new_rlane_cd", "fNewRlaneCd");
		this.hashFields.put("f_pod_cd", "fPodCd");
		this.hashFields.put("f_bat_sts_cd", "fBatStsCd");
		this.hashFields.put("f_spcl_tgt_cd", "fSpclTgtCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_src_rlane_cd", "fSrcRlaneCd");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_act_flag", "fActFlag");
		this.hashFields.put("f_duration", "fDuration");
		this.hashFields.put("f_decimal_flg", "fDecimalFlg");
		this.hashFields.put("f_usr_id", "fUsrId");
		this.hashFields.put("f_sqm_cng_tp_cd", "fSqmCngTpCd");
		return this.hashFields;
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
	 * @return fOrgCd
	 */
	public String getFOrgCd() {
		return this.fOrgCd;
	}
	
	/**
	 * Column Info
	 * @return fBseWk
	 */
	public String getFBseWk() {
		return this.fBseWk;
	}
	
	/**
	 * Column Info
	 * @return fQtaTgtCd
	 */
	public String getFQtaTgtCd() {
		return this.fQtaTgtCd;
	}
	
	/**
	 * Column Info
	 * @return fTrdDir
	 */
	public String getFTrdDir() {
		return this.fTrdDir;
	}
	
	/**
	 * Column Info
	 * @return fAplyFlg
	 */
	public String getFAplyFlg() {
		return this.fAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return fChkWeek
	 */
	public String getFChkWeek() {
		return this.fChkWeek;
	}
	
	/**
	 * Column Info
	 * @return fHoTeamCd
	 */
	public String getFHoTeamCd() {
		return this.fHoTeamCd;
	}
	
	/**
	 * Column Info
	 * @return fAcctTgtCd
	 */
	public String getFAcctTgtCd() {
		return this.fAcctTgtCd;
	}
	
	/**
	 * Column Info
	 * @return fIasSctrFlg
	 */
	public String getFIasSctrFlg() {
		return this.fIasSctrFlg;
	}
	
	/**
	 * Column Info
	 * @return fBseTpCd
	 */
	public String getFBseTpCd() {
		return this.fBseTpCd;
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
	 * @return fHulBndCd
	 */
	public String getFHulBndCd() {
		return this.fHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return fChkAlocQta
	 */
	public String getFChkAlocQta() {
		return this.fChkAlocQta;
	}
	
	/**
	 * Column Info
	 * @return fBatId
	 */
	public String getFBatId() {
		return this.fBatId;
	}
	
	/**
	 * Column Info
	 * @return fCustGrpId
	 */
	public String getFCustGrpId() {
		return this.fCustGrpId;
	}
	
	/**
	 * Column Info
	 * @return fObDivCd
	 */
	public String getFObDivCd() {
		return this.fObDivCd;
	}
	
	/**
	 * Column Info
	 * @return fPfSvcTpCd
	 */
	public String getFPfSvcTpCd() {
		return this.fPfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return fCrntQtaCd
	 */
	public String getFCrntQtaCd() {
		return this.fCrntQtaCd;
	}
	
	/**
	 * Column Info
	 * @return fCrntBseYr
	 */
	public String getFCrntBseYr() {
		return this.fCrntBseYr;
	}
	
	/**
	 * Column Info
	 * @return fPortionLink
	 */
	public String getFPortionLink() {
		return this.fPortionLink;
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
	 * @return fChkPair
	 */
	public String getFChkPair() {
		return this.fChkPair;
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
	 * @return fQtaStepCd
	 */
	public String getFQtaStepCd() {
		return this.fQtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return fOfcVwCd
	 */
	public String getFOfcVwCd() {
		return this.fOfcVwCd;
	}
	
	/**
	 * Column Info
	 * @return fGubun
	 */
	public String getFGubun() {
		return this.fGubun;
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
	 * @return fIoBound
	 */
	public String getFIoBound() {
		return this.fIoBound;
	}
	
	/**
	 * Column Info
	 * @return fCCnt
	 */
	public String getFCCnt() {
		return this.fCCnt;
	}
	
	/**
	 * Column Info
	 * @return fClick
	 */
	public String getFClick() {
		return this.fClick;
	}
	
	/**
	 * Column Info
	 * @return fConvDirCd
	 */
	public String getFConvDirCd() {
		return this.fConvDirCd;
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
	 * @return fDisMas
	 */
	public String getFDisMas() {
		return this.fDisMas;
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
	 * @return fYearTpCd
	 */
	public String getFYearTpCd() {
		return this.fYearTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkWeek
	 */
	public String getChkWeek() {
		return this.chkWeek;
	}
	
	/**
	 * Column Info
	 * @return fSrcTrdCd
	 */
	public String getFSrcTrdCd() {
		return this.fSrcTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fChkDecimal
	 */
	public String getFChkDecimal() {
		return this.fChkDecimal;
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
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}
	
	/**
	 * Column Info
	 * @return fSqmMnSctrFlg
	 */
	public String getFSqmMnSctrFlg() {
		return this.fSqmMnSctrFlg;
	}
	
	/**
	 * Column Info
	 * @return fBseYr
	 */
	public String getFBseYr() {
		return this.fBseYr;
	}
	
	/**
	 * Column Info
	 * @return fSubTrdCd
	 */
	public String getFSubTrdCd() {
		return this.fSubTrdCd;
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
	 * @return fChkRpbCmpb
	 */
	public String getFChkRpbCmpb() {
		return this.fChkRpbCmpb;
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
	 * @return fRdFlg
	 */
	public String getFRdFlg() {
		return this.fRdFlg;
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
	 * @return fSrcRgnOfcCd
	 */
	public String getFSrcRgnOfcCd() {
		return this.fSrcRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fSrcRhqCd
	 */
	public String getFSrcRhqCd() {
		return this.fSrcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fAddFlg
	 */
	public String getFAddFlg() {
		return this.fAddFlg;
	}
	
	/**
	 * Column Info
	 * @return fActiveFlg
	 */
	public String getFActiveFlg() {
		return this.fActiveFlg;
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
	 * @return fPfGrpCd
	 */
	public String getFPfGrpCd() {
		return this.fPfGrpCd;
	}
	
	/**
	 * Column Info
	 * @return fRgnOfcCd
	 */
	public String getFRgnOfcCd() {
		return this.fRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fChkVvd
	 */
	public String getFChkVvd() {
		return this.fChkVvd;
	}
	
	/**
	 * Column Info
	 * @return fLaneDirCd
	 */
	public String getFLaneDirCd() {
		return this.fLaneDirCd;
	}
	
	/**
	 * Column Info
	 * @return fBseMon
	 */
	public String getFBseMon() {
		return this.fBseMon;
	}
	
	/**
	 * Column Info
	 * @return fBseQtrCd
	 */
	public String getFBseQtrCd() {
		return this.fBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return fPolCd
	 */
	public String getFPolCd() {
		return this.fPolCd;
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
	 * @return fDgFlg
	 */
	public String getFDgFlg() {
		return this.fDgFlg;
	}
	
	/**
	 * Column Info
	 * @return fNewRlaneCd
	 */
	public String getFNewRlaneCd() {
		return this.fNewRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fPodCd
	 */
	public String getFPodCd() {
		return this.fPodCd;
	}
	
	/**
	 * Column Info
	 * @return fBatStsCd
	 */
	public String getFBatStsCd() {
		return this.fBatStsCd;
	}
	
	/**
	 * Column Info
	 * @return fSpclTgtCd
	 */
	public String getFSpclTgtCd() {
		return this.fSpclTgtCd;
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
	 * @return fSrcRlaneCd
	 */
	public String getFSrcRlaneCd() {
		return this.fSrcRlaneCd;
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
	 * @return fActFlag
	 */
	public String getFActFlag() {
		return this.fActFlag;
	}
	
	/**
	 * Column Info
	 * @return fDuration
	 */
	public String getFDuration() {
		return this.fDuration;
	}
	
	/**
	 * Column Info
	 * @return fDecimalFlg
	 */
	public String getFDecimalFlg() {
		return this.fDecimalFlg;
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
	 * @return fSqmCngTpCd
	 */
	public String getFSqmCngTpCd() {
		return this.fSqmCngTpCd;
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
	 * @param fOrgCd
	 */
	public void setFOrgCd(String fOrgCd) {
		this.fOrgCd = fOrgCd;
	}
	
	/**
	 * Column Info
	 * @param fBseWk
	 */
	public void setFBseWk(String fBseWk) {
		this.fBseWk = fBseWk;
	}
	
	/**
	 * Column Info
	 * @param fQtaTgtCd
	 */
	public void setFQtaTgtCd(String fQtaTgtCd) {
		this.fQtaTgtCd = fQtaTgtCd;
	}
	
	/**
	 * Column Info
	 * @param fTrdDir
	 */
	public void setFTrdDir(String fTrdDir) {
		this.fTrdDir = fTrdDir;
	}
	
	/**
	 * Column Info
	 * @param fAplyFlg
	 */
	public void setFAplyFlg(String fAplyFlg) {
		this.fAplyFlg = fAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param fChkWeek
	 */
	public void setFChkWeek(String fChkWeek) {
		this.fChkWeek = fChkWeek;
	}
	
	/**
	 * Column Info
	 * @param fHoTeamCd
	 */
	public void setFHoTeamCd(String fHoTeamCd) {
		this.fHoTeamCd = fHoTeamCd;
	}
	
	/**
	 * Column Info
	 * @param fAcctTgtCd
	 */
	public void setFAcctTgtCd(String fAcctTgtCd) {
		this.fAcctTgtCd = fAcctTgtCd;
	}
	
	/**
	 * Column Info
	 * @param fIasSctrFlg
	 */
	public void setFIasSctrFlg(String fIasSctrFlg) {
		this.fIasSctrFlg = fIasSctrFlg;
	}
	
	/**
	 * Column Info
	 * @param fBseTpCd
	 */
	public void setFBseTpCd(String fBseTpCd) {
		this.fBseTpCd = fBseTpCd;
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
	 * @param fHulBndCd
	 */
	public void setFHulBndCd(String fHulBndCd) {
		this.fHulBndCd = fHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param fChkAlocQta
	 */
	public void setFChkAlocQta(String fChkAlocQta) {
		this.fChkAlocQta = fChkAlocQta;
	}
	
	/**
	 * Column Info
	 * @param fBatId
	 */
	public void setFBatId(String fBatId) {
		this.fBatId = fBatId;
	}
	
	/**
	 * Column Info
	 * @param fCustGrpId
	 */
	public void setFCustGrpId(String fCustGrpId) {
		this.fCustGrpId = fCustGrpId;
	}
	
	/**
	 * Column Info
	 * @param fObDivCd
	 */
	public void setFObDivCd(String fObDivCd) {
		this.fObDivCd = fObDivCd;
	}
	
	/**
	 * Column Info
	 * @param fPfSvcTpCd
	 */
	public void setFPfSvcTpCd(String fPfSvcTpCd) {
		this.fPfSvcTpCd = fPfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param fCrntQtaCd
	 */
	public void setFCrntQtaCd(String fCrntQtaCd) {
		this.fCrntQtaCd = fCrntQtaCd;
	}
	
	/**
	 * Column Info
	 * @param fCrntBseYr
	 */
	public void setFCrntBseYr(String fCrntBseYr) {
		this.fCrntBseYr = fCrntBseYr;
	}
	
	/**
	 * Column Info
	 * @param fPortionLink
	 */
	public void setFPortionLink(String fPortionLink) {
		this.fPortionLink = fPortionLink;
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
	 * @param fChkPair
	 */
	public void setFChkPair(String fChkPair) {
		this.fChkPair = fChkPair;
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
	 * @param fQtaStepCd
	 */
	public void setFQtaStepCd(String fQtaStepCd) {
		this.fQtaStepCd = fQtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param fOfcVwCd
	 */
	public void setFOfcVwCd(String fOfcVwCd) {
		this.fOfcVwCd = fOfcVwCd;
	}
	
	/**
	 * Column Info
	 * @param fGubun
	 */
	public void setFGubun(String fGubun) {
		this.fGubun = fGubun;
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
	 * @param fIoBound
	 */
	public void setFIoBound(String fIoBound) {
		this.fIoBound = fIoBound;
	}
	
	/**
	 * Column Info
	 * @param fCCnt
	 */
	public void setFCCnt(String fCCnt) {
		this.fCCnt = fCCnt;
	}
	
	/**
	 * Column Info
	 * @param fClick
	 */
	public void setFClick(String fClick) {
		this.fClick = fClick;
	}
	
	/**
	 * Column Info
	 * @param fConvDirCd
	 */
	public void setFConvDirCd(String fConvDirCd) {
		this.fConvDirCd = fConvDirCd;
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
	 * @param fDisMas
	 */
	public void setFDisMas(String fDisMas) {
		this.fDisMas = fDisMas;
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
	 * @param fYearTpCd
	 */
	public void setFYearTpCd(String fYearTpCd) {
		this.fYearTpCd = fYearTpCd;
	}
	
	/**
	 * Column Info
	 * @param chkWeek
	 */
	public void setChkWeek(String chkWeek) {
		this.chkWeek = chkWeek;
	}
	
	/**
	 * Column Info
	 * @param fSrcTrdCd
	 */
	public void setFSrcTrdCd(String fSrcTrdCd) {
		this.fSrcTrdCd = fSrcTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fChkDecimal
	 */
	public void setFChkDecimal(String fChkDecimal) {
		this.fChkDecimal = fChkDecimal;
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
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param fSqmMnSctrFlg
	 */
	public void setFSqmMnSctrFlg(String fSqmMnSctrFlg) {
		this.fSqmMnSctrFlg = fSqmMnSctrFlg;
	}
	
	/**
	 * Column Info
	 * @param fBseYr
	 */
	public void setFBseYr(String fBseYr) {
		this.fBseYr = fBseYr;
	}
	
	/**
	 * Column Info
	 * @param fSubTrdCd
	 */
	public void setFSubTrdCd(String fSubTrdCd) {
		this.fSubTrdCd = fSubTrdCd;
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
	 * @param fChkRpbCmpb
	 */
	public void setFChkRpbCmpb(String fChkRpbCmpb) {
		this.fChkRpbCmpb = fChkRpbCmpb;
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
	 * @param fRdFlg
	 */
	public void setFRdFlg(String fRdFlg) {
		this.fRdFlg = fRdFlg;
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
	 * @param fSrcRgnOfcCd
	 */
	public void setFSrcRgnOfcCd(String fSrcRgnOfcCd) {
		this.fSrcRgnOfcCd = fSrcRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fSrcRhqCd
	 */
	public void setFSrcRhqCd(String fSrcRhqCd) {
		this.fSrcRhqCd = fSrcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fAddFlg
	 */
	public void setFAddFlg(String fAddFlg) {
		this.fAddFlg = fAddFlg;
	}
	
	/**
	 * Column Info
	 * @param fActiveFlg
	 */
	public void setFActiveFlg(String fActiveFlg) {
		this.fActiveFlg = fActiveFlg;
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
	 * @param fPfGrpCd
	 */
	public void setFPfGrpCd(String fPfGrpCd) {
		this.fPfGrpCd = fPfGrpCd;
	}
	
	/**
	 * Column Info
	 * @param fRgnOfcCd
	 */
	public void setFRgnOfcCd(String fRgnOfcCd) {
		this.fRgnOfcCd = fRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fChkVvd
	 */
	public void setFChkVvd(String fChkVvd) {
		this.fChkVvd = fChkVvd;
	}
	
	/**
	 * Column Info
	 * @param fLaneDirCd
	 */
	public void setFLaneDirCd(String fLaneDirCd) {
		this.fLaneDirCd = fLaneDirCd;
	}
	
	/**
	 * Column Info
	 * @param fBseMon
	 */
	public void setFBseMon(String fBseMon) {
		this.fBseMon = fBseMon;
	}
	
	/**
	 * Column Info
	 * @param fBseQtrCd
	 */
	public void setFBseQtrCd(String fBseQtrCd) {
		this.fBseQtrCd = fBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param fPolCd
	 */
	public void setFPolCd(String fPolCd) {
		this.fPolCd = fPolCd;
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
	 * @param fDgFlg
	 */
	public void setFDgFlg(String fDgFlg) {
		this.fDgFlg = fDgFlg;
	}
	
	/**
	 * Column Info
	 * @param fNewRlaneCd
	 */
	public void setFNewRlaneCd(String fNewRlaneCd) {
		this.fNewRlaneCd = fNewRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fPodCd
	 */
	public void setFPodCd(String fPodCd) {
		this.fPodCd = fPodCd;
	}
	
	/**
	 * Column Info
	 * @param fBatStsCd
	 */
	public void setFBatStsCd(String fBatStsCd) {
		this.fBatStsCd = fBatStsCd;
	}
	
	/**
	 * Column Info
	 * @param fSpclTgtCd
	 */
	public void setFSpclTgtCd(String fSpclTgtCd) {
		this.fSpclTgtCd = fSpclTgtCd;
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
	 * @param fSrcRlaneCd
	 */
	public void setFSrcRlaneCd(String fSrcRlaneCd) {
		this.fSrcRlaneCd = fSrcRlaneCd;
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
	 * @param fActFlag
	 */
	public void setFActFlag(String fActFlag) {
		this.fActFlag = fActFlag;
	}
	
	/**
	 * Column Info
	 * @param fDuration
	 */
	public void setFDuration(String fDuration) {
		this.fDuration = fDuration;
	}
	
	/**
	 * Column Info
	 * @param fDecimalFlg
	 */
	public void setFDecimalFlg(String fDecimalFlg) {
		this.fDecimalFlg = fDecimalFlg;
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
	 * @param fSqmCngTpCd
	 */
	public void setFSqmCngTpCd(String fSqmCngTpCd) {
		this.fSqmCngTpCd = fSqmCngTpCd;
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
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setFOrgCd(JSPUtil.getParameter(request, prefix + "f_org_cd", ""));
		setFBseWk(JSPUtil.getParameter(request, prefix + "f_bse_wk", ""));
		setFQtaTgtCd(JSPUtil.getParameter(request, prefix + "f_qta_tgt_cd", ""));
		setFTrdDir(JSPUtil.getParameter(request, prefix + "f_trd_dir", ""));
		setFAplyFlg(JSPUtil.getParameter(request, prefix + "f_aply_flg", ""));
		setFChkWeek(JSPUtil.getParameter(request, prefix + "f_chk_week", ""));
		setFHoTeamCd(JSPUtil.getParameter(request, prefix + "f_ho_team_cd", ""));
		setFAcctTgtCd(JSPUtil.getParameter(request, prefix + "f_acct_tgt_cd", ""));
		setFIasSctrFlg(JSPUtil.getParameter(request, prefix + "f_ias_sctr_flg", ""));
		setFBseTpCd(JSPUtil.getParameter(request, prefix + "f_bse_tp_cd", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
		setFHulBndCd(JSPUtil.getParameter(request, prefix + "f_hul_bnd_cd", ""));
		setFChkAlocQta(JSPUtil.getParameter(request, prefix + "f_chk_aloc_qta", ""));
		setFBatId(JSPUtil.getParameter(request, prefix + "f_bat_id", ""));
		setFCustGrpId(JSPUtil.getParameter(request, prefix + "f_cust_grp_id", ""));
		setFObDivCd(JSPUtil.getParameter(request, prefix + "f_ob_div_cd", ""));
		setFPfSvcTpCd(JSPUtil.getParameter(request, prefix + "f_pf_svc_tp_cd", ""));
		setFCrntQtaCd(JSPUtil.getParameter(request, prefix + "f_crnt_qta_cd", ""));
		setFCrntBseYr(JSPUtil.getParameter(request, prefix + "f_crnt_bse_yr", ""));
		setFPortionLink(JSPUtil.getParameter(request, prefix + "f_portion_link", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFChkPair(JSPUtil.getParameter(request, prefix + "f_chk_pair", ""));
		setFIasRgnCd(JSPUtil.getParameter(request, prefix + "f_ias_rgn_cd", ""));
		setFQtaStepCd(JSPUtil.getParameter(request, prefix + "f_qta_step_cd", ""));
		setFOfcVwCd(JSPUtil.getParameter(request, prefix + "f_ofc_vw_cd", ""));
		setFGubun(JSPUtil.getParameter(request, prefix + "f_gubun", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFIoBound(JSPUtil.getParameter(request, prefix + "f_io_bound", ""));
		setFCCnt(JSPUtil.getParameter(request, prefix + "f_c_cnt", ""));
		setFClick(JSPUtil.getParameter(request, prefix + "f_click", ""));
		setFConvDirCd(JSPUtil.getParameter(request, prefix + "f_conv_dir_cd", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setFDisMas(JSPUtil.getParameter(request, prefix + "f_dis_mas", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setFYearTpCd(JSPUtil.getParameter(request, prefix + "f_year_tp_cd", ""));
		setChkWeek(JSPUtil.getParameter(request, prefix + "chk_week", ""));
		setFSrcTrdCd(JSPUtil.getParameter(request, prefix + "f_src_trd_cd", ""));
		setFChkDecimal(JSPUtil.getParameter(request, prefix + "f_chk_decimal", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFSqmMnSctrFlg(JSPUtil.getParameter(request, prefix + "f_sqm_mn_sctr_flg", ""));
		setFBseYr(JSPUtil.getParameter(request, prefix + "f_bse_yr", ""));
		setFSubTrdCd(JSPUtil.getParameter(request, prefix + "f_sub_trd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFChkRpbCmpb(JSPUtil.getParameter(request, prefix + "f_chk_rpb_cmpb", ""));
		setFOfcLvl(JSPUtil.getParameter(request, prefix + "f_ofc_lvl", ""));
		setFRdFlg(JSPUtil.getParameter(request, prefix + "f_rd_flg", ""));
		setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
		setFSrcRgnOfcCd(JSPUtil.getParameter(request, prefix + "f_src_rgn_ofc_cd", ""));
		setFSrcRhqCd(JSPUtil.getParameter(request, prefix + "f_src_rhq_cd", ""));
		setFAddFlg(JSPUtil.getParameter(request, prefix + "f_add_flg", ""));
		setFActiveFlg(JSPUtil.getParameter(request, prefix + "f_active_flg", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setFPfGrpCd(JSPUtil.getParameter(request, prefix + "f_pf_grp_cd", ""));
		setFRgnOfcCd(JSPUtil.getParameter(request, prefix + "f_rgn_ofc_cd", ""));
		setFChkVvd(JSPUtil.getParameter(request, prefix + "f_chk_vvd", ""));
		setFLaneDirCd(JSPUtil.getParameter(request, prefix + "f_lane_dir_cd", ""));
		setFBseMon(JSPUtil.getParameter(request, prefix + "f_bse_mon", ""));
		setFBseQtrCd(JSPUtil.getParameter(request, prefix + "f_bse_qtr_cd", ""));
		setFPolCd(JSPUtil.getParameter(request, prefix + "f_pol_cd", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFDgFlg(JSPUtil.getParameter(request, prefix + "f_dg_flg", ""));
		setFNewRlaneCd(JSPUtil.getParameter(request, prefix + "f_new_rlane_cd", ""));
		setFPodCd(JSPUtil.getParameter(request, prefix + "f_pod_cd", ""));
		setFBatStsCd(JSPUtil.getParameter(request, prefix + "f_bat_sts_cd", ""));
		setFSpclTgtCd(JSPUtil.getParameter(request, prefix + "f_spcl_tgt_cd", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setFSrcRlaneCd(JSPUtil.getParameter(request, prefix + "f_src_rlane_cd", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setFActFlag(JSPUtil.getParameter(request, prefix + "f_act_flag", ""));
		setFDuration(JSPUtil.getParameter(request, prefix + "f_duration", ""));
		setFDecimalFlg(JSPUtil.getParameter(request, prefix + "f_decimal_flg", ""));
		setFUsrId(JSPUtil.getParameter(request, prefix + "f_usr_id", ""));
		setFSqmCngTpCd(JSPUtil.getParameter(request, prefix + "f_sqm_cng_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConditionVO[]
	 */
	public ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConditionVO[]
	 */
	public ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fOrgCd = (JSPUtil.getParameter(request, prefix	+ "f_org_cd", length));
			String[] fBseWk = (JSPUtil.getParameter(request, prefix	+ "f_bse_wk", length));
			String[] fQtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_qta_tgt_cd", length));
			String[] fTrdDir = (JSPUtil.getParameter(request, prefix	+ "f_trd_dir", length));
			String[] fAplyFlg = (JSPUtil.getParameter(request, prefix	+ "f_aply_flg", length));
			String[] fChkWeek = (JSPUtil.getParameter(request, prefix	+ "f_chk_week", length));
			String[] fHoTeamCd = (JSPUtil.getParameter(request, prefix	+ "f_ho_team_cd", length));
			String[] fAcctTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_acct_tgt_cd", length));
			String[] fIasSctrFlg = (JSPUtil.getParameter(request, prefix	+ "f_ias_sctr_flg", length));
			String[] fBseTpCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_tp_cd", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] fHulBndCd = (JSPUtil.getParameter(request, prefix	+ "f_hul_bnd_cd", length));
			String[] fChkAlocQta = (JSPUtil.getParameter(request, prefix	+ "f_chk_aloc_qta", length));
			String[] fBatId = (JSPUtil.getParameter(request, prefix	+ "f_bat_id", length));
			String[] fCustGrpId = (JSPUtil.getParameter(request, prefix	+ "f_cust_grp_id", length));
			String[] fObDivCd = (JSPUtil.getParameter(request, prefix	+ "f_ob_div_cd", length));
			String[] fPfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "f_pf_svc_tp_cd", length));
			String[] fCrntQtaCd = (JSPUtil.getParameter(request, prefix	+ "f_crnt_qta_cd", length));
			String[] fCrntBseYr = (JSPUtil.getParameter(request, prefix	+ "f_crnt_bse_yr", length));
			String[] fPortionLink = (JSPUtil.getParameter(request, prefix	+ "f_portion_link", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fChkPair = (JSPUtil.getParameter(request, prefix	+ "f_chk_pair", length));
			String[] fIasRgnCd = (JSPUtil.getParameter(request, prefix	+ "f_ias_rgn_cd", length));
			String[] fQtaStepCd = (JSPUtil.getParameter(request, prefix	+ "f_qta_step_cd", length));
			String[] fOfcVwCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw_cd", length));
			String[] fGubun = (JSPUtil.getParameter(request, prefix	+ "f_gubun", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fIoBound = (JSPUtil.getParameter(request, prefix	+ "f_io_bound", length));
			String[] fCCnt = (JSPUtil.getParameter(request, prefix	+ "f_c_cnt", length));
			String[] fClick = (JSPUtil.getParameter(request, prefix	+ "f_click", length));
			String[] fConvDirCd = (JSPUtil.getParameter(request, prefix	+ "f_conv_dir_cd", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] fDisMas = (JSPUtil.getParameter(request, prefix	+ "f_dis_mas", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] fYearTpCd = (JSPUtil.getParameter(request, prefix	+ "f_year_tp_cd", length));
			String[] chkWeek = (JSPUtil.getParameter(request, prefix	+ "chk_week", length));
			String[] fSrcTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_src_trd_cd", length));
			String[] fChkDecimal = (JSPUtil.getParameter(request, prefix	+ "f_chk_decimal", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fSqmMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "f_sqm_mn_sctr_flg", length));
			String[] fBseYr = (JSPUtil.getParameter(request, prefix	+ "f_bse_yr", length));
			String[] fSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_trd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fChkRpbCmpb = (JSPUtil.getParameter(request, prefix	+ "f_chk_rpb_cmpb", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fRdFlg = (JSPUtil.getParameter(request, prefix	+ "f_rd_flg", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fSrcRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_src_rgn_ofc_cd", length));
			String[] fSrcRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_src_rhq_cd", length));
			String[] fAddFlg = (JSPUtil.getParameter(request, prefix	+ "f_add_flg", length));
			String[] fActiveFlg = (JSPUtil.getParameter(request, prefix	+ "f_active_flg", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fPfGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_pf_grp_cd", length));
			String[] fRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_rgn_ofc_cd", length));
			String[] fChkVvd = (JSPUtil.getParameter(request, prefix	+ "f_chk_vvd", length));
			String[] fLaneDirCd = (JSPUtil.getParameter(request, prefix	+ "f_lane_dir_cd", length));
			String[] fBseMon = (JSPUtil.getParameter(request, prefix	+ "f_bse_mon", length));
			String[] fBseQtrCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_qtr_cd", length));
			String[] fPolCd = (JSPUtil.getParameter(request, prefix	+ "f_pol_cd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fDgFlg = (JSPUtil.getParameter(request, prefix	+ "f_dg_flg", length));
			String[] fNewRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_new_rlane_cd", length));
			String[] fPodCd = (JSPUtil.getParameter(request, prefix	+ "f_pod_cd", length));
			String[] fBatStsCd = (JSPUtil.getParameter(request, prefix	+ "f_bat_sts_cd", length));
			String[] fSpclTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_spcl_tgt_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fSrcRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_src_rlane_cd", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fActFlag = (JSPUtil.getParameter(request, prefix	+ "f_act_flag", length));
			String[] fDuration = (JSPUtil.getParameter(request, prefix	+ "f_duration", length));
			String[] fDecimalFlg = (JSPUtil.getParameter(request, prefix	+ "f_decimal_flg", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			String[] fSqmCngTpCd = (JSPUtil.getParameter(request, prefix	+ "f_sqm_cng_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ConditionVO();
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fOrgCd[i] != null)
					model.setFOrgCd(fOrgCd[i]);
				if (fBseWk[i] != null)
					model.setFBseWk(fBseWk[i]);
				if (fQtaTgtCd[i] != null)
					model.setFQtaTgtCd(fQtaTgtCd[i]);
				if (fTrdDir[i] != null)
					model.setFTrdDir(fTrdDir[i]);
				if (fAplyFlg[i] != null)
					model.setFAplyFlg(fAplyFlg[i]);
				if (fChkWeek[i] != null)
					model.setFChkWeek(fChkWeek[i]);
				if (fHoTeamCd[i] != null)
					model.setFHoTeamCd(fHoTeamCd[i]);
				if (fAcctTgtCd[i] != null)
					model.setFAcctTgtCd(fAcctTgtCd[i]);
				if (fIasSctrFlg[i] != null)
					model.setFIasSctrFlg(fIasSctrFlg[i]);
				if (fBseTpCd[i] != null)
					model.setFBseTpCd(fBseTpCd[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (fHulBndCd[i] != null)
					model.setFHulBndCd(fHulBndCd[i]);
				if (fChkAlocQta[i] != null)
					model.setFChkAlocQta(fChkAlocQta[i]);
				if (fBatId[i] != null)
					model.setFBatId(fBatId[i]);
				if (fCustGrpId[i] != null)
					model.setFCustGrpId(fCustGrpId[i]);
				if (fObDivCd[i] != null)
					model.setFObDivCd(fObDivCd[i]);
				if (fPfSvcTpCd[i] != null)
					model.setFPfSvcTpCd(fPfSvcTpCd[i]);
				if (fCrntQtaCd[i] != null)
					model.setFCrntQtaCd(fCrntQtaCd[i]);
				if (fCrntBseYr[i] != null)
					model.setFCrntBseYr(fCrntBseYr[i]);
				if (fPortionLink[i] != null)
					model.setFPortionLink(fPortionLink[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fChkPair[i] != null)
					model.setFChkPair(fChkPair[i]);
				if (fIasRgnCd[i] != null)
					model.setFIasRgnCd(fIasRgnCd[i]);
				if (fQtaStepCd[i] != null)
					model.setFQtaStepCd(fQtaStepCd[i]);
				if (fOfcVwCd[i] != null)
					model.setFOfcVwCd(fOfcVwCd[i]);
				if (fGubun[i] != null)
					model.setFGubun(fGubun[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fIoBound[i] != null)
					model.setFIoBound(fIoBound[i]);
				if (fCCnt[i] != null)
					model.setFCCnt(fCCnt[i]);
				if (fClick[i] != null)
					model.setFClick(fClick[i]);
				if (fConvDirCd[i] != null)
					model.setFConvDirCd(fConvDirCd[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (fDisMas[i] != null)
					model.setFDisMas(fDisMas[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (fYearTpCd[i] != null)
					model.setFYearTpCd(fYearTpCd[i]);
				if (chkWeek[i] != null)
					model.setChkWeek(chkWeek[i]);
				if (fSrcTrdCd[i] != null)
					model.setFSrcTrdCd(fSrcTrdCd[i]);
				if (fChkDecimal[i] != null)
					model.setFChkDecimal(fChkDecimal[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fSqmMnSctrFlg[i] != null)
					model.setFSqmMnSctrFlg(fSqmMnSctrFlg[i]);
				if (fBseYr[i] != null)
					model.setFBseYr(fBseYr[i]);
				if (fSubTrdCd[i] != null)
					model.setFSubTrdCd(fSubTrdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fChkRpbCmpb[i] != null)
					model.setFChkRpbCmpb(fChkRpbCmpb[i]);
				if (fOfcLvl[i] != null)
					model.setFOfcLvl(fOfcLvl[i]);
				if (fRdFlg[i] != null)
					model.setFRdFlg(fRdFlg[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fSrcRgnOfcCd[i] != null)
					model.setFSrcRgnOfcCd(fSrcRgnOfcCd[i]);
				if (fSrcRhqCd[i] != null)
					model.setFSrcRhqCd(fSrcRhqCd[i]);
				if (fAddFlg[i] != null)
					model.setFAddFlg(fAddFlg[i]);
				if (fActiveFlg[i] != null)
					model.setFActiveFlg(fActiveFlg[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fPfGrpCd[i] != null)
					model.setFPfGrpCd(fPfGrpCd[i]);
				if (fRgnOfcCd[i] != null)
					model.setFRgnOfcCd(fRgnOfcCd[i]);
				if (fChkVvd[i] != null)
					model.setFChkVvd(fChkVvd[i]);
				if (fLaneDirCd[i] != null)
					model.setFLaneDirCd(fLaneDirCd[i]);
				if (fBseMon[i] != null)
					model.setFBseMon(fBseMon[i]);
				if (fBseQtrCd[i] != null)
					model.setFBseQtrCd(fBseQtrCd[i]);
				if (fPolCd[i] != null)
					model.setFPolCd(fPolCd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fDgFlg[i] != null)
					model.setFDgFlg(fDgFlg[i]);
				if (fNewRlaneCd[i] != null)
					model.setFNewRlaneCd(fNewRlaneCd[i]);
				if (fPodCd[i] != null)
					model.setFPodCd(fPodCd[i]);
				if (fBatStsCd[i] != null)
					model.setFBatStsCd(fBatStsCd[i]);
				if (fSpclTgtCd[i] != null)
					model.setFSpclTgtCd(fSpclTgtCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fSrcRlaneCd[i] != null)
					model.setFSrcRlaneCd(fSrcRlaneCd[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fActFlag[i] != null)
					model.setFActFlag(fActFlag[i]);
				if (fDuration[i] != null)
					model.setFDuration(fDuration[i]);
				if (fDecimalFlg[i] != null)
					model.setFDecimalFlg(fDecimalFlg[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				if (fSqmCngTpCd[i] != null)
					model.setFSqmCngTpCd(fSqmCngTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConditionVO[]
	 */
	public ConditionVO[] getConditionVOs(){
		ConditionVO[] vos = (ConditionVO[])models.toArray(new ConditionVO[models.size()]);
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
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOrgCd = this.fOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseWk = this.fBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQtaTgtCd = this.fQtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdDir = this.fTrdDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAplyFlg = this.fAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkWeek = this.fChkWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHoTeamCd = this.fHoTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctTgtCd = this.fAcctTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIasSctrFlg = this.fIasSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseTpCd = this.fBseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHulBndCd = this.fHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkAlocQta = this.fChkAlocQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBatId = this.fBatId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustGrpId = this.fCustGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fObDivCd = this.fObDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPfSvcTpCd = this.fPfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCrntQtaCd = this.fCrntQtaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCrntBseYr = this.fCrntBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPortionLink = this.fPortionLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkPair = this.fChkPair .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIasRgnCd = this.fIasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQtaStepCd = this.fQtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVwCd = this.fOfcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGubun = this.fGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIoBound = this.fIoBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCCnt = this.fCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fClick = this.fClick .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fConvDirCd = this.fConvDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDisMas = this.fDisMas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearTpCd = this.fYearTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkWeek = this.chkWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcTrdCd = this.fSrcTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkDecimal = this.fChkDecimal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSqmMnSctrFlg = this.fSqmMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseYr = this.fBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubTrdCd = this.fSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkRpbCmpb = this.fChkRpbCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRdFlg = this.fRdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcRgnOfcCd = this.fSrcRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcRhqCd = this.fSrcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAddFlg = this.fAddFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActiveFlg = this.fActiveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPfGrpCd = this.fPfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRgnOfcCd = this.fRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkVvd = this.fChkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLaneDirCd = this.fLaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseMon = this.fBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseQtrCd = this.fBseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPolCd = this.fPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDgFlg = this.fDgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNewRlaneCd = this.fNewRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodCd = this.fPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBatStsCd = this.fBatStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSpclTgtCd = this.fSpclTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcRlaneCd = this.fSrcRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActFlag = this.fActFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDuration = this.fDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDecimalFlg = this.fDecimalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSqmCngTpCd = this.fSqmCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
