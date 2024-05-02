/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConditionVO.java
*@FileTitle : ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.common.vo;

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

public class ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConditionVO> models = new ArrayList<ConditionVO>();
	
	/* Column Info */
	private String fHoTeamCd = null;
	/* Column Info */
	private String fBseWk = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fFnlBsaCapa = null;
	/* Column Info */
	private String fBseMon = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String fRhqCd = null;
	/* Column Info */
	private String fDgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fOrgCd = null;
	/* Column Info */
	private String fGubun = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fCCnt = null;
	/* Column Info */
	private String fBseQtrCd = null;
	/* Column Info */
	private String chkWeek = null;
	/* Column Info */
	private String fOfcLvl = null;
	/* Column Info */
	private String fClick = null;
	/* Column Info */
	private String fPortionLink = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fNewRlaneCd = null;
	/* Column Info */
	private String fObDivCd = null;
	/* Column Info */
	private String fCsqMnSctrFlg = null;
	/* Column Info */
	private String fIasSctrFlg = null;
	/* Column Info */
	private String fPfGrpCd = null;
	/* Column Info */
	private String fDecimalFlg = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String fSrcTrdCd = null;
	/* Column Info */
	private String fBseTpCd = null;
	/* Column Info */
	private String fUsrId = null;
	/* Column Info */
	private String fChkAlocQta = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fIoBound = null;
	/* Column Info */
	private String fChkDecimal = null;
	/* Column Info */
	private String fAplyFlg = null;
	/* Column Info */
	private String fAcctTgtCd = null;
	/* Column Info */
	private String fQtaStepCd = null;
	/* Column Info */
	private String fQtaTgtCd = null;
	/* Column Info */
	private String fAddFlg = null;
	/* Column Info */
	private String fBseYr = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Column Info */
	private String fSrcRlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fYearTpCd = null;
	/* Column Info */
	private String fSrcRhqCd = null;
	/* Column Info */
	private String fChkVvd = null;
	/* Column Info */
	private String fRgnOfcCd = null;
	/* Column Info */
	private String fDeletedFlg = null;
	/* Column Info */
	private String fPodCd = null;
	/* Column Info */
	private String fRdFlg = null;
	/* Column Info */
	private String fSrcRgnOfcCd = null;
	/* Column Info */
	private String fActFlag = null;
	/* Column Info */
	private String fCsqCngTpCd = null;
	/* Column Info */
	private String fOfcVwCd = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String fChkWeek = null;
	/* Column Info */
	private String fLaneDirCd = null;
	/* Column Info */
	private String fChkPair = null;
	/* Column Info */
	private String fCrntBseYr = null;
	/* Column Info */
	private String fDuration = null;
	/* Column Info */
	private String fSubTrdCd = null;
	/* Column Info */
	private String fCustGrpId = null;
	/* Column Info */
	private String fPolCd = null;
	/* Column Info */
	private String fConvDirCd = null;
	/* Column Info */
	private String fCrntQtaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ConditionVO() {}

	public ConditionVO(String ibflag, String pagerows, String fHoTeamCd, String fFmMon, String fBseMon, String fDirCd, String fRhqCd, String fOrgCd, String fGubun, String fVslCd, String fBseQtrCd, String fPortionLink, String fClick, String fOfcLvl, String fNewRlaneCd, String fFmWk, String fObDivCd, String fCsqCngTpCd, String fDecimalFlg, String fToMon, String fSrcTrdCd, String fSkdVoyNo, String fBseTpCd, String fUsrId, String fChkAlocQta, String fTrdCd, String fToWk, String fRlaneCd, String fIoBound, String fChkDecimal, String fAplyFlg, String fAcctTgtCd, String fQtaStepCd, String fQtaTgtCd, String fBseYr, String fSrcRlaneCd, String fYearTpCd, String fSrcRhqCd, String fChkVvd, String fRgnOfcCd, String fSrcRgnOfcCd, String fOfcVwCd, String fSkdDirCd, String fChkWeek, String fLaneDirCd, String fCrntBseYr, String fDuration, String fSubTrdCd, String fCustGrpId, String fConvDirCd, String fCrntQtaCd, String fBseWk, String fPfGrpCd, String fIasSctrFlg, String fPolCd, String fPodCd, String fActFlag, String fCCnt, String fAddFlg, String fChkPair, String chkWeek, String fCntrTpszCd, String fDgFlg, String fRdFlg, String fCsqMnSctrFlg, String fFnlBsaCapa, String fDeletedFlg) {
		this.fHoTeamCd = fHoTeamCd;
		this.fBseWk = fBseWk;
		this.fFmMon = fFmMon;
		this.fFnlBsaCapa = fFnlBsaCapa;
		this.fBseMon = fBseMon;
		this.fDirCd = fDirCd;
		this.fRhqCd = fRhqCd;
		this.fDgFlg = fDgFlg;
		this.pagerows = pagerows;
		this.fOrgCd = fOrgCd;
		this.fGubun = fGubun;
		this.fVslCd = fVslCd;
		this.fCCnt = fCCnt;
		this.fBseQtrCd = fBseQtrCd;
		this.chkWeek = chkWeek;
		this.fOfcLvl = fOfcLvl;
		this.fClick = fClick;
		this.fPortionLink = fPortionLink;
		this.fFmWk = fFmWk;
		this.fNewRlaneCd = fNewRlaneCd;
		this.fObDivCd = fObDivCd;
		this.fCsqMnSctrFlg = fCsqMnSctrFlg;
		this.fIasSctrFlg = fIasSctrFlg;
		this.fPfGrpCd = fPfGrpCd;
		this.fDecimalFlg = fDecimalFlg;
		this.fToMon = fToMon;
		this.fSkdVoyNo = fSkdVoyNo;
		this.fSrcTrdCd = fSrcTrdCd;
		this.fBseTpCd = fBseTpCd;
		this.fUsrId = fUsrId;
		this.fChkAlocQta = fChkAlocQta;
		this.fTrdCd = fTrdCd;
		this.fToWk = fToWk;
		this.fRlaneCd = fRlaneCd;
		this.fIoBound = fIoBound;
		this.fChkDecimal = fChkDecimal;
		this.fAplyFlg = fAplyFlg;
		this.fAcctTgtCd = fAcctTgtCd;
		this.fQtaStepCd = fQtaStepCd;
		this.fQtaTgtCd = fQtaTgtCd;
		this.fAddFlg = fAddFlg;
		this.fBseYr = fBseYr;
		this.fCntrTpszCd = fCntrTpszCd;
		this.fSrcRlaneCd = fSrcRlaneCd;
		this.ibflag = ibflag;
		this.fYearTpCd = fYearTpCd;
		this.fSrcRhqCd = fSrcRhqCd;
		this.fChkVvd = fChkVvd;
		this.fRgnOfcCd = fRgnOfcCd;
		this.fDeletedFlg = fDeletedFlg;
		this.fPodCd = fPodCd;
		this.fRdFlg = fRdFlg;
		this.fSrcRgnOfcCd = fSrcRgnOfcCd;
		this.fActFlag = fActFlag;
		this.fCsqCngTpCd = fCsqCngTpCd;
		this.fOfcVwCd = fOfcVwCd;
		this.fSkdDirCd = fSkdDirCd;
		this.fChkWeek = fChkWeek;
		this.fLaneDirCd = fLaneDirCd;
		this.fChkPair = fChkPair;
		this.fCrntBseYr = fCrntBseYr;
		this.fDuration = fDuration;
		this.fSubTrdCd = fSubTrdCd;
		this.fCustGrpId = fCustGrpId;
		this.fPolCd = fPolCd;
		this.fConvDirCd = fConvDirCd;
		this.fCrntQtaCd = fCrntQtaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_ho_team_cd", getFHoTeamCd());
		this.hashColumns.put("f_bse_wk", getFBseWk());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_fnl_bsa_capa", getFFnlBsaCapa());
		this.hashColumns.put("f_bse_mon", getFBseMon());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("f_rhq_cd", getFRhqCd());
		this.hashColumns.put("f_dg_flg", getFDgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_org_cd", getFOrgCd());
		this.hashColumns.put("f_gubun", getFGubun());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_c_cnt", getFCCnt());
		this.hashColumns.put("f_bse_qtr_cd", getFBseQtrCd());
		this.hashColumns.put("chk_week", getChkWeek());
		this.hashColumns.put("f_ofc_lvl", getFOfcLvl());
		this.hashColumns.put("f_click", getFClick());
		this.hashColumns.put("f_portion_link", getFPortionLink());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_new_rlane_cd", getFNewRlaneCd());
		this.hashColumns.put("f_ob_div_cd", getFObDivCd());
		this.hashColumns.put("f_csq_mn_sctr_flg", getFCsqMnSctrFlg());
		this.hashColumns.put("f_ias_sctr_flg", getFIasSctrFlg());
		this.hashColumns.put("f_pf_grp_cd", getFPfGrpCd());
		this.hashColumns.put("f_decimal_flg", getFDecimalFlg());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("f_src_trd_cd", getFSrcTrdCd());
		this.hashColumns.put("f_bse_tp_cd", getFBseTpCd());
		this.hashColumns.put("f_usr_id", getFUsrId());
		this.hashColumns.put("f_chk_aloc_qta", getFChkAlocQta());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_io_bound", getFIoBound());
		this.hashColumns.put("f_chk_decimal", getFChkDecimal());
		this.hashColumns.put("f_aply_flg", getFAplyFlg());
		this.hashColumns.put("f_acct_tgt_cd", getFAcctTgtCd());
		this.hashColumns.put("f_qta_step_cd", getFQtaStepCd());
		this.hashColumns.put("f_qta_tgt_cd", getFQtaTgtCd());
		this.hashColumns.put("f_add_flg", getFAddFlg());
		this.hashColumns.put("f_bse_yr", getFBseYr());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("f_src_rlane_cd", getFSrcRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_year_tp_cd", getFYearTpCd());
		this.hashColumns.put("f_src_rhq_cd", getFSrcRhqCd());
		this.hashColumns.put("f_chk_vvd", getFChkVvd());
		this.hashColumns.put("f_rgn_ofc_cd", getFRgnOfcCd());
		this.hashColumns.put("f_deleted_flg", getFDeletedFlg());
		this.hashColumns.put("f_pod_cd", getFPodCd());
		this.hashColumns.put("f_rd_flg", getFRdFlg());
		this.hashColumns.put("f_src_rgn_ofc_cd", getFSrcRgnOfcCd());
		this.hashColumns.put("f_act_flag", getFActFlag());
		this.hashColumns.put("f_csq_cng_tp_cd", getFCsqCngTpCd());
		this.hashColumns.put("f_ofc_vw_cd", getFOfcVwCd());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("f_chk_week", getFChkWeek());
		this.hashColumns.put("f_lane_dir_cd", getFLaneDirCd());
		this.hashColumns.put("f_chk_pair", getFChkPair());
		this.hashColumns.put("f_crnt_bse_yr", getFCrntBseYr());
		this.hashColumns.put("f_duration", getFDuration());
		this.hashColumns.put("f_sub_trd_cd", getFSubTrdCd());
		this.hashColumns.put("f_cust_grp_id", getFCustGrpId());
		this.hashColumns.put("f_pol_cd", getFPolCd());
		this.hashColumns.put("f_conv_dir_cd", getFConvDirCd());
		this.hashColumns.put("f_crnt_qta_cd", getFCrntQtaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_ho_team_cd", "fHoTeamCd");
		this.hashFields.put("f_bse_wk", "fBseWk");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_fnl_bsa_capa", "fFnlBsaCapa");
		this.hashFields.put("f_bse_mon", "fBseMon");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("f_rhq_cd", "fRhqCd");
		this.hashFields.put("f_dg_flg", "fDgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_org_cd", "fOrgCd");
		this.hashFields.put("f_gubun", "fGubun");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_c_cnt", "fCCnt");
		this.hashFields.put("f_bse_qtr_cd", "fBseQtrCd");
		this.hashFields.put("chk_week", "chkWeek");
		this.hashFields.put("f_ofc_lvl", "fOfcLvl");
		this.hashFields.put("f_click", "fClick");
		this.hashFields.put("f_portion_link", "fPortionLink");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_new_rlane_cd", "fNewRlaneCd");
		this.hashFields.put("f_ob_div_cd", "fObDivCd");
		this.hashFields.put("f_csq_mn_sctr_flg", "fCsqMnSctrFlg");
		this.hashFields.put("f_ias_sctr_flg", "fIasSctrFlg");
		this.hashFields.put("f_pf_grp_cd", "fPfGrpCd");
		this.hashFields.put("f_decimal_flg", "fDecimalFlg");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("f_src_trd_cd", "fSrcTrdCd");
		this.hashFields.put("f_bse_tp_cd", "fBseTpCd");
		this.hashFields.put("f_usr_id", "fUsrId");
		this.hashFields.put("f_chk_aloc_qta", "fChkAlocQta");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_io_bound", "fIoBound");
		this.hashFields.put("f_chk_decimal", "fChkDecimal");
		this.hashFields.put("f_aply_flg", "fAplyFlg");
		this.hashFields.put("f_acct_tgt_cd", "fAcctTgtCd");
		this.hashFields.put("f_qta_step_cd", "fQtaStepCd");
		this.hashFields.put("f_qta_tgt_cd", "fQtaTgtCd");
		this.hashFields.put("f_add_flg", "fAddFlg");
		this.hashFields.put("f_bse_yr", "fBseYr");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("f_src_rlane_cd", "fSrcRlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_year_tp_cd", "fYearTpCd");
		this.hashFields.put("f_src_rhq_cd", "fSrcRhqCd");
		this.hashFields.put("f_chk_vvd", "fChkVvd");
		this.hashFields.put("f_rgn_ofc_cd", "fRgnOfcCd");
		this.hashFields.put("f_deleted_flg", "fDeletedFlg");
		this.hashFields.put("f_pod_cd", "fPodCd");
		this.hashFields.put("f_rd_flg", "fRdFlg");
		this.hashFields.put("f_src_rgn_ofc_cd", "fSrcRgnOfcCd");
		this.hashFields.put("f_act_flag", "fActFlag");
		this.hashFields.put("f_csq_cng_tp_cd", "fCsqCngTpCd");
		this.hashFields.put("f_ofc_vw_cd", "fOfcVwCd");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("f_chk_week", "fChkWeek");
		this.hashFields.put("f_lane_dir_cd", "fLaneDirCd");
		this.hashFields.put("f_chk_pair", "fChkPair");
		this.hashFields.put("f_crnt_bse_yr", "fCrntBseYr");
		this.hashFields.put("f_duration", "fDuration");
		this.hashFields.put("f_sub_trd_cd", "fSubTrdCd");
		this.hashFields.put("f_cust_grp_id", "fCustGrpId");
		this.hashFields.put("f_pol_cd", "fPolCd");
		this.hashFields.put("f_conv_dir_cd", "fConvDirCd");
		this.hashFields.put("f_crnt_qta_cd", "fCrntQtaCd");
		return this.hashFields;
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
	 * @return fBseWk
	 */
	public String getFBseWk() {
		return this.fBseWk;
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
	 * @return fFnlBsaCapa
	 */
	public String getFFnlBsaCapa() {
		return this.fFnlBsaCapa;
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
	 * @return fDgFlg
	 */
	public String getFDgFlg() {
		return this.fDgFlg;
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
	 * @return fOrgCd
	 */
	public String getFOrgCd() {
		return this.fOrgCd;
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
	 * @return fVslCd
	 */
	public String getFVslCd() {
		return this.fVslCd;
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
	 * @return fBseQtrCd
	 */
	public String getFBseQtrCd() {
		return this.fBseQtrCd;
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
	 * @return fOfcLvl
	 */
	public String getFOfcLvl() {
		return this.fOfcLvl;
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
	 * @return fPortionLink
	 */
	public String getFPortionLink() {
		return this.fPortionLink;
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
	 * @return fNewRlaneCd
	 */
	public String getFNewRlaneCd() {
		return this.fNewRlaneCd;
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
	 * @return fCsqMnSctrFlg
	 */
	public String getFCsqMnSctrFlg() {
		return this.fCsqMnSctrFlg;
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
	 * @return fPfGrpCd
	 */
	public String getFPfGrpCd() {
		return this.fPfGrpCd;
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
	 * @return fSrcTrdCd
	 */
	public String getFSrcTrdCd() {
		return this.fSrcTrdCd;
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
	 * @return fUsrId
	 */
	public String getFUsrId() {
		return this.fUsrId;
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
	 * @return fRlaneCd
	 */
	public String getFRlaneCd() {
		return this.fRlaneCd;
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
	 * @return fChkDecimal
	 */
	public String getFChkDecimal() {
		return this.fChkDecimal;
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
	 * @return fAcctTgtCd
	 */
	public String getFAcctTgtCd() {
		return this.fAcctTgtCd;
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
	 * @return fQtaTgtCd
	 */
	public String getFQtaTgtCd() {
		return this.fQtaTgtCd;
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
	 * @return fBseYr
	 */
	public String getFBseYr() {
		return this.fBseYr;
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
	 * @return fSrcRlaneCd
	 */
	public String getFSrcRlaneCd() {
		return this.fSrcRlaneCd;
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
	 * @return fYearTpCd
	 */
	public String getFYearTpCd() {
		return this.fYearTpCd;
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
	 * @return fChkVvd
	 */
	public String getFChkVvd() {
		return this.fChkVvd;
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
	 * @return fDeletedFlg
	 */
	public String getFDeletedFlg() {
		return this.fDeletedFlg;
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
	 * @return fRdFlg
	 */
	public String getFRdFlg() {
		return this.fRdFlg;
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
	 * @return fActFlag
	 */
	public String getFActFlag() {
		return this.fActFlag;
	}
	
	/**
	 * Column Info
	 * @return fCsqCngTpCd
	 */
	public String getFCsqCngTpCd() {
		return this.fCsqCngTpCd;
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
	 * @return fSkdDirCd
	 */
	public String getFSkdDirCd() {
		return this.fSkdDirCd;
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
	 * @return fLaneDirCd
	 */
	public String getFLaneDirCd() {
		return this.fLaneDirCd;
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
	 * @return fCrntBseYr
	 */
	public String getFCrntBseYr() {
		return this.fCrntBseYr;
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
	 * @return fSubTrdCd
	 */
	public String getFSubTrdCd() {
		return this.fSubTrdCd;
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
	 * @return fPolCd
	 */
	public String getFPolCd() {
		return this.fPolCd;
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
	 * @return fCrntQtaCd
	 */
	public String getFCrntQtaCd() {
		return this.fCrntQtaCd;
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
	 * @param fBseWk
	 */
	public void setFBseWk(String fBseWk) {
		this.fBseWk = fBseWk;
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
	 * @param fFnlBsaCapa
	 */
	public void setFFnlBsaCapa(String fFnlBsaCapa) {
		this.fFnlBsaCapa = fFnlBsaCapa;
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
	 * @param fDgFlg
	 */
	public void setFDgFlg(String fDgFlg) {
		this.fDgFlg = fDgFlg;
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
	 * @param fOrgCd
	 */
	public void setFOrgCd(String fOrgCd) {
		this.fOrgCd = fOrgCd;
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
	 * @param fVslCd
	 */
	public void setFVslCd(String fVslCd) {
		this.fVslCd = fVslCd;
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
	 * @param fBseQtrCd
	 */
	public void setFBseQtrCd(String fBseQtrCd) {
		this.fBseQtrCd = fBseQtrCd;
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
	 * @param fOfcLvl
	 */
	public void setFOfcLvl(String fOfcLvl) {
		this.fOfcLvl = fOfcLvl;
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
	 * @param fPortionLink
	 */
	public void setFPortionLink(String fPortionLink) {
		this.fPortionLink = fPortionLink;
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
	 * @param fNewRlaneCd
	 */
	public void setFNewRlaneCd(String fNewRlaneCd) {
		this.fNewRlaneCd = fNewRlaneCd;
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
	 * @param fCsqMnSctrFlg
	 */
	public void setFCsqMnSctrFlg(String fCsqMnSctrFlg) {
		this.fCsqMnSctrFlg = fCsqMnSctrFlg;
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
	 * @param fPfGrpCd
	 */
	public void setFPfGrpCd(String fPfGrpCd) {
		this.fPfGrpCd = fPfGrpCd;
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
	 * @param fSrcTrdCd
	 */
	public void setFSrcTrdCd(String fSrcTrdCd) {
		this.fSrcTrdCd = fSrcTrdCd;
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
	 * @param fUsrId
	 */
	public void setFUsrId(String fUsrId) {
		this.fUsrId = fUsrId;
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
	 * @param fRlaneCd
	 */
	public void setFRlaneCd(String fRlaneCd) {
		this.fRlaneCd = fRlaneCd;
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
	 * @param fChkDecimal
	 */
	public void setFChkDecimal(String fChkDecimal) {
		this.fChkDecimal = fChkDecimal;
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
	 * @param fAcctTgtCd
	 */
	public void setFAcctTgtCd(String fAcctTgtCd) {
		this.fAcctTgtCd = fAcctTgtCd;
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
	 * @param fQtaTgtCd
	 */
	public void setFQtaTgtCd(String fQtaTgtCd) {
		this.fQtaTgtCd = fQtaTgtCd;
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
	 * @param fBseYr
	 */
	public void setFBseYr(String fBseYr) {
		this.fBseYr = fBseYr;
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
	 * @param fSrcRlaneCd
	 */
	public void setFSrcRlaneCd(String fSrcRlaneCd) {
		this.fSrcRlaneCd = fSrcRlaneCd;
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
	 * @param fYearTpCd
	 */
	public void setFYearTpCd(String fYearTpCd) {
		this.fYearTpCd = fYearTpCd;
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
	 * @param fChkVvd
	 */
	public void setFChkVvd(String fChkVvd) {
		this.fChkVvd = fChkVvd;
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
	 * @param fDeletedFlg
	 */
	public void setFDeletedFlg(String fDeletedFlg) {
		this.fDeletedFlg = fDeletedFlg;
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
	 * @param fRdFlg
	 */
	public void setFRdFlg(String fRdFlg) {
		this.fRdFlg = fRdFlg;
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
	 * @param fActFlag
	 */
	public void setFActFlag(String fActFlag) {
		this.fActFlag = fActFlag;
	}
	
	/**
	 * Column Info
	 * @param fCsqCngTpCd
	 */
	public void setFCsqCngTpCd(String fCsqCngTpCd) {
		this.fCsqCngTpCd = fCsqCngTpCd;
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
	 * @param fSkdDirCd
	 */
	public void setFSkdDirCd(String fSkdDirCd) {
		this.fSkdDirCd = fSkdDirCd;
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
	 * @param fLaneDirCd
	 */
	public void setFLaneDirCd(String fLaneDirCd) {
		this.fLaneDirCd = fLaneDirCd;
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
	 * @param fCrntBseYr
	 */
	public void setFCrntBseYr(String fCrntBseYr) {
		this.fCrntBseYr = fCrntBseYr;
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
	 * @param fSubTrdCd
	 */
	public void setFSubTrdCd(String fSubTrdCd) {
		this.fSubTrdCd = fSubTrdCd;
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
	 * @param fPolCd
	 */
	public void setFPolCd(String fPolCd) {
		this.fPolCd = fPolCd;
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
	 * @param fCrntQtaCd
	 */
	public void setFCrntQtaCd(String fCrntQtaCd) {
		this.fCrntQtaCd = fCrntQtaCd;
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
		setFHoTeamCd(JSPUtil.getParameter(request, prefix + "f_ho_team_cd", ""));
		setFBseWk(JSPUtil.getParameter(request, prefix + "f_bse_wk", ""));
		setFFmMon(JSPUtil.getParameter(request, prefix + "f_fm_mon", ""));
		setFFnlBsaCapa(JSPUtil.getParameter(request, prefix + "f_fnl_bsa_capa", ""));
		setFBseMon(JSPUtil.getParameter(request, prefix + "f_bse_mon", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setFRhqCd(JSPUtil.getParameter(request, prefix + "f_rhq_cd", ""));
		setFDgFlg(JSPUtil.getParameter(request, prefix + "f_dg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFOrgCd(JSPUtil.getParameter(request, prefix + "f_org_cd", ""));
		setFGubun(JSPUtil.getParameter(request, prefix + "f_gubun", ""));
		setFVslCd(JSPUtil.getParameter(request, prefix + "f_vsl_cd", ""));
		setFCCnt(JSPUtil.getParameter(request, prefix + "f_c_cnt", ""));
		setFBseQtrCd(JSPUtil.getParameter(request, prefix + "f_bse_qtr_cd", ""));
		setChkWeek(JSPUtil.getParameter(request, prefix + "chk_week", ""));
		setFOfcLvl(JSPUtil.getParameter(request, prefix + "f_ofc_lvl", ""));
		setFClick(JSPUtil.getParameter(request, prefix + "f_click", ""));
		setFPortionLink(JSPUtil.getParameter(request, prefix + "f_portion_link", ""));
		setFFmWk(JSPUtil.getParameter(request, prefix + "f_fm_wk", ""));
		setFNewRlaneCd(JSPUtil.getParameter(request, prefix + "f_new_rlane_cd", ""));
		setFObDivCd(JSPUtil.getParameter(request, prefix + "f_ob_div_cd", ""));
		setFCsqMnSctrFlg(JSPUtil.getParameter(request, prefix + "f_csq_mn_sctr_flg", ""));
		setFIasSctrFlg(JSPUtil.getParameter(request, prefix + "f_ias_sctr_flg", ""));
		setFPfGrpCd(JSPUtil.getParameter(request, prefix + "f_pf_grp_cd", ""));
		setFDecimalFlg(JSPUtil.getParameter(request, prefix + "f_decimal_flg", ""));
		setFToMon(JSPUtil.getParameter(request, prefix + "f_to_mon", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, prefix + "f_skd_voy_no", ""));
		setFSrcTrdCd(JSPUtil.getParameter(request, prefix + "f_src_trd_cd", ""));
		setFBseTpCd(JSPUtil.getParameter(request, prefix + "f_bse_tp_cd", ""));
		setFUsrId(JSPUtil.getParameter(request, prefix + "f_usr_id", ""));
		setFChkAlocQta(JSPUtil.getParameter(request, prefix + "f_chk_aloc_qta", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setFToWk(JSPUtil.getParameter(request, prefix + "f_to_wk", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setFIoBound(JSPUtil.getParameter(request, prefix + "f_io_bound", ""));
		setFChkDecimal(JSPUtil.getParameter(request, prefix + "f_chk_decimal", ""));
		setFAplyFlg(JSPUtil.getParameter(request, prefix + "f_aply_flg", ""));
		setFAcctTgtCd(JSPUtil.getParameter(request, prefix + "f_acct_tgt_cd", ""));
		setFQtaStepCd(JSPUtil.getParameter(request, prefix + "f_qta_step_cd", ""));
		setFQtaTgtCd(JSPUtil.getParameter(request, prefix + "f_qta_tgt_cd", ""));
		setFAddFlg(JSPUtil.getParameter(request, prefix + "f_add_flg", ""));
		setFBseYr(JSPUtil.getParameter(request, prefix + "f_bse_yr", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setFSrcRlaneCd(JSPUtil.getParameter(request, prefix + "f_src_rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFYearTpCd(JSPUtil.getParameter(request, prefix + "f_year_tp_cd", ""));
		setFSrcRhqCd(JSPUtil.getParameter(request, prefix + "f_src_rhq_cd", ""));
		setFChkVvd(JSPUtil.getParameter(request, prefix + "f_chk_vvd", ""));
		setFRgnOfcCd(JSPUtil.getParameter(request, prefix + "f_rgn_ofc_cd", ""));
		setFDeletedFlg(JSPUtil.getParameter(request, prefix + "f_deleted_flg", ""));
		setFPodCd(JSPUtil.getParameter(request, prefix + "f_pod_cd", ""));
		setFRdFlg(JSPUtil.getParameter(request, prefix + "f_rd_flg", ""));
		setFSrcRgnOfcCd(JSPUtil.getParameter(request, prefix + "f_src_rgn_ofc_cd", ""));
		setFActFlag(JSPUtil.getParameter(request, prefix + "f_act_flag", ""));
		setFCsqCngTpCd(JSPUtil.getParameter(request, prefix + "f_csq_cng_tp_cd", ""));
		setFOfcVwCd(JSPUtil.getParameter(request, prefix + "f_ofc_vw_cd", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, prefix + "f_skd_dir_cd", ""));
		setFChkWeek(JSPUtil.getParameter(request, prefix + "f_chk_week", ""));
		setFLaneDirCd(JSPUtil.getParameter(request, prefix + "f_lane_dir_cd", ""));
		setFChkPair(JSPUtil.getParameter(request, prefix + "f_chk_pair", ""));
		setFCrntBseYr(JSPUtil.getParameter(request, prefix + "f_crnt_bse_yr", ""));
		setFDuration(JSPUtil.getParameter(request, prefix + "f_duration", ""));
		setFSubTrdCd(JSPUtil.getParameter(request, prefix + "f_sub_trd_cd", ""));
		setFCustGrpId(JSPUtil.getParameter(request, prefix + "f_cust_grp_id", ""));
		setFPolCd(JSPUtil.getParameter(request, prefix + "f_pol_cd", ""));
		setFConvDirCd(JSPUtil.getParameter(request, prefix + "f_conv_dir_cd", ""));
		setFCrntQtaCd(JSPUtil.getParameter(request, prefix + "f_crnt_qta_cd", ""));
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
			String[] fHoTeamCd = (JSPUtil.getParameter(request, prefix	+ "f_ho_team_cd", length));
			String[] fBseWk = (JSPUtil.getParameter(request, prefix	+ "f_bse_wk", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "f_fnl_bsa_capa", length));
			String[] fBseMon = (JSPUtil.getParameter(request, prefix	+ "f_bse_mon", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] fRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_rhq_cd", length));
			String[] fDgFlg = (JSPUtil.getParameter(request, prefix	+ "f_dg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fOrgCd = (JSPUtil.getParameter(request, prefix	+ "f_org_cd", length));
			String[] fGubun = (JSPUtil.getParameter(request, prefix	+ "f_gubun", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fCCnt = (JSPUtil.getParameter(request, prefix	+ "f_c_cnt", length));
			String[] fBseQtrCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_qtr_cd", length));
			String[] chkWeek = (JSPUtil.getParameter(request, prefix	+ "chk_week", length));
			String[] fOfcLvl = (JSPUtil.getParameter(request, prefix	+ "f_ofc_lvl", length));
			String[] fClick = (JSPUtil.getParameter(request, prefix	+ "f_click", length));
			String[] fPortionLink = (JSPUtil.getParameter(request, prefix	+ "f_portion_link", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fNewRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_new_rlane_cd", length));
			String[] fObDivCd = (JSPUtil.getParameter(request, prefix	+ "f_ob_div_cd", length));
			String[] fCsqMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "f_csq_mn_sctr_flg", length));
			String[] fIasSctrFlg = (JSPUtil.getParameter(request, prefix	+ "f_ias_sctr_flg", length));
			String[] fPfGrpCd = (JSPUtil.getParameter(request, prefix	+ "f_pf_grp_cd", length));
			String[] fDecimalFlg = (JSPUtil.getParameter(request, prefix	+ "f_decimal_flg", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] fSrcTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_src_trd_cd", length));
			String[] fBseTpCd = (JSPUtil.getParameter(request, prefix	+ "f_bse_tp_cd", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			String[] fChkAlocQta = (JSPUtil.getParameter(request, prefix	+ "f_chk_aloc_qta", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fIoBound = (JSPUtil.getParameter(request, prefix	+ "f_io_bound", length));
			String[] fChkDecimal = (JSPUtil.getParameter(request, prefix	+ "f_chk_decimal", length));
			String[] fAplyFlg = (JSPUtil.getParameter(request, prefix	+ "f_aply_flg", length));
			String[] fAcctTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_acct_tgt_cd", length));
			String[] fQtaStepCd = (JSPUtil.getParameter(request, prefix	+ "f_qta_step_cd", length));
			String[] fQtaTgtCd = (JSPUtil.getParameter(request, prefix	+ "f_qta_tgt_cd", length));
			String[] fAddFlg = (JSPUtil.getParameter(request, prefix	+ "f_add_flg", length));
			String[] fBseYr = (JSPUtil.getParameter(request, prefix	+ "f_bse_yr", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] fSrcRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_src_rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fYearTpCd = (JSPUtil.getParameter(request, prefix	+ "f_year_tp_cd", length));
			String[] fSrcRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_src_rhq_cd", length));
			String[] fChkVvd = (JSPUtil.getParameter(request, prefix	+ "f_chk_vvd", length));
			String[] fRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_rgn_ofc_cd", length));
			String[] fDeletedFlg = (JSPUtil.getParameter(request, prefix	+ "f_deleted_flg", length));
			String[] fPodCd = (JSPUtil.getParameter(request, prefix	+ "f_pod_cd", length));
			String[] fRdFlg = (JSPUtil.getParameter(request, prefix	+ "f_rd_flg", length));
			String[] fSrcRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_src_rgn_ofc_cd", length));
			String[] fActFlag = (JSPUtil.getParameter(request, prefix	+ "f_act_flag", length));
			String[] fCsqCngTpCd = (JSPUtil.getParameter(request, prefix	+ "f_csq_cng_tp_cd", length));
			String[] fOfcVwCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_vw_cd", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fChkWeek = (JSPUtil.getParameter(request, prefix	+ "f_chk_week", length));
			String[] fLaneDirCd = (JSPUtil.getParameter(request, prefix	+ "f_lane_dir_cd", length));
			String[] fChkPair = (JSPUtil.getParameter(request, prefix	+ "f_chk_pair", length));
			String[] fCrntBseYr = (JSPUtil.getParameter(request, prefix	+ "f_crnt_bse_yr", length));
			String[] fDuration = (JSPUtil.getParameter(request, prefix	+ "f_duration", length));
			String[] fSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_sub_trd_cd", length));
			String[] fCustGrpId = (JSPUtil.getParameter(request, prefix	+ "f_cust_grp_id", length));
			String[] fPolCd = (JSPUtil.getParameter(request, prefix	+ "f_pol_cd", length));
			String[] fConvDirCd = (JSPUtil.getParameter(request, prefix	+ "f_conv_dir_cd", length));
			String[] fCrntQtaCd = (JSPUtil.getParameter(request, prefix	+ "f_crnt_qta_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ConditionVO();
				if (fHoTeamCd[i] != null)
					model.setFHoTeamCd(fHoTeamCd[i]);
				if (fBseWk[i] != null)
					model.setFBseWk(fBseWk[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fFnlBsaCapa[i] != null)
					model.setFFnlBsaCapa(fFnlBsaCapa[i]);
				if (fBseMon[i] != null)
					model.setFBseMon(fBseMon[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (fRhqCd[i] != null)
					model.setFRhqCd(fRhqCd[i]);
				if (fDgFlg[i] != null)
					model.setFDgFlg(fDgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fOrgCd[i] != null)
					model.setFOrgCd(fOrgCd[i]);
				if (fGubun[i] != null)
					model.setFGubun(fGubun[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fCCnt[i] != null)
					model.setFCCnt(fCCnt[i]);
				if (fBseQtrCd[i] != null)
					model.setFBseQtrCd(fBseQtrCd[i]);
				if (chkWeek[i] != null)
					model.setChkWeek(chkWeek[i]);
				if (fOfcLvl[i] != null)
					model.setFOfcLvl(fOfcLvl[i]);
				if (fClick[i] != null)
					model.setFClick(fClick[i]);
				if (fPortionLink[i] != null)
					model.setFPortionLink(fPortionLink[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fNewRlaneCd[i] != null)
					model.setFNewRlaneCd(fNewRlaneCd[i]);
				if (fObDivCd[i] != null)
					model.setFObDivCd(fObDivCd[i]);
				if (fCsqMnSctrFlg[i] != null)
					model.setFCsqMnSctrFlg(fCsqMnSctrFlg[i]);
				if (fIasSctrFlg[i] != null)
					model.setFIasSctrFlg(fIasSctrFlg[i]);
				if (fPfGrpCd[i] != null)
					model.setFPfGrpCd(fPfGrpCd[i]);
				if (fDecimalFlg[i] != null)
					model.setFDecimalFlg(fDecimalFlg[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (fSrcTrdCd[i] != null)
					model.setFSrcTrdCd(fSrcTrdCd[i]);
				if (fBseTpCd[i] != null)
					model.setFBseTpCd(fBseTpCd[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				if (fChkAlocQta[i] != null)
					model.setFChkAlocQta(fChkAlocQta[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fIoBound[i] != null)
					model.setFIoBound(fIoBound[i]);
				if (fChkDecimal[i] != null)
					model.setFChkDecimal(fChkDecimal[i]);
				if (fAplyFlg[i] != null)
					model.setFAplyFlg(fAplyFlg[i]);
				if (fAcctTgtCd[i] != null)
					model.setFAcctTgtCd(fAcctTgtCd[i]);
				if (fQtaStepCd[i] != null)
					model.setFQtaStepCd(fQtaStepCd[i]);
				if (fQtaTgtCd[i] != null)
					model.setFQtaTgtCd(fQtaTgtCd[i]);
				if (fAddFlg[i] != null)
					model.setFAddFlg(fAddFlg[i]);
				if (fBseYr[i] != null)
					model.setFBseYr(fBseYr[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (fSrcRlaneCd[i] != null)
					model.setFSrcRlaneCd(fSrcRlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fYearTpCd[i] != null)
					model.setFYearTpCd(fYearTpCd[i]);
				if (fSrcRhqCd[i] != null)
					model.setFSrcRhqCd(fSrcRhqCd[i]);
				if (fChkVvd[i] != null)
					model.setFChkVvd(fChkVvd[i]);
				if (fRgnOfcCd[i] != null)
					model.setFRgnOfcCd(fRgnOfcCd[i]);
				if (fDeletedFlg[i] != null)
					model.setFDeletedFlg(fDeletedFlg[i]);
				if (fPodCd[i] != null)
					model.setFPodCd(fPodCd[i]);
				if (fRdFlg[i] != null)
					model.setFRdFlg(fRdFlg[i]);
				if (fSrcRgnOfcCd[i] != null)
					model.setFSrcRgnOfcCd(fSrcRgnOfcCd[i]);
				if (fActFlag[i] != null)
					model.setFActFlag(fActFlag[i]);
				if (fCsqCngTpCd[i] != null)
					model.setFCsqCngTpCd(fCsqCngTpCd[i]);
				if (fOfcVwCd[i] != null)
					model.setFOfcVwCd(fOfcVwCd[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (fChkWeek[i] != null)
					model.setFChkWeek(fChkWeek[i]);
				if (fLaneDirCd[i] != null)
					model.setFLaneDirCd(fLaneDirCd[i]);
				if (fChkPair[i] != null)
					model.setFChkPair(fChkPair[i]);
				if (fCrntBseYr[i] != null)
					model.setFCrntBseYr(fCrntBseYr[i]);
				if (fDuration[i] != null)
					model.setFDuration(fDuration[i]);
				if (fSubTrdCd[i] != null)
					model.setFSubTrdCd(fSubTrdCd[i]);
				if (fCustGrpId[i] != null)
					model.setFCustGrpId(fCustGrpId[i]);
				if (fPolCd[i] != null)
					model.setFPolCd(fPolCd[i]);
				if (fConvDirCd[i] != null)
					model.setFConvDirCd(fConvDirCd[i]);
				if (fCrntQtaCd[i] != null)
					model.setFCrntQtaCd(fCrntQtaCd[i]);
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
		this.fHoTeamCd = this.fHoTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseWk = this.fBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFnlBsaCapa = this.fFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseMon = this.fBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRhqCd = this.fRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDgFlg = this.fDgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOrgCd = this.fOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGubun = this.fGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCCnt = this.fCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseQtrCd = this.fBseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkWeek = this.chkWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcLvl = this.fOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fClick = this.fClick .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPortionLink = this.fPortionLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fNewRlaneCd = this.fNewRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fObDivCd = this.fObDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCsqMnSctrFlg = this.fCsqMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIasSctrFlg = this.fIasSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPfGrpCd = this.fPfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDecimalFlg = this.fDecimalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcTrdCd = this.fSrcTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseTpCd = this.fBseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkAlocQta = this.fChkAlocQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIoBound = this.fIoBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkDecimal = this.fChkDecimal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAplyFlg = this.fAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAcctTgtCd = this.fAcctTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQtaStepCd = this.fQtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fQtaTgtCd = this.fQtaTgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAddFlg = this.fAddFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBseYr = this.fBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcRlaneCd = this.fSrcRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearTpCd = this.fYearTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcRhqCd = this.fSrcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkVvd = this.fChkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRgnOfcCd = this.fRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDeletedFlg = this.fDeletedFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodCd = this.fPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRdFlg = this.fRdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSrcRgnOfcCd = this.fSrcRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActFlag = this.fActFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCsqCngTpCd = this.fCsqCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcVwCd = this.fOfcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkWeek = this.fChkWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLaneDirCd = this.fLaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkPair = this.fChkPair .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCrntBseYr = this.fCrntBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDuration = this.fDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubTrdCd = this.fSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustGrpId = this.fCustGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPolCd = this.fPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fConvDirCd = this.fConvDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCrntQtaCd = this.fCrntQtaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
