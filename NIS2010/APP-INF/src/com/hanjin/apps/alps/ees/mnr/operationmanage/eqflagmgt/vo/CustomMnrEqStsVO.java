/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrEqStsVO.java
*@FileTitle : CustomMnrEqStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2011.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrEqStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrEqStsVO> models = new ArrayList<CustomMnrEqStsVO>();
	
	/* Column Info */
	private String mnrScrpFlg = null;
	/* Column Info */
	private String mnrDonaFlgDt = null;
	/* Column Info */
	private String mnrDmgFlgYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrDispSelTpCd = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* Column Info */
	private String mnrFlgInpDt = null;
	/* Column Info */
	private String mnrHngrBarTpCd = null;
	/* Column Info */
	private String pLocTp = null;
	/* Column Info */
	private String mnrLostHngrQty = null;
	/* Column Info */
	private String mnrDispSelFlg = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String utPrice = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrDispSelFlgYdCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String mnrFlgTpCd = null;
	/* Column Info */
	private String eqMdlNm = null;
	/* Column Info */
	private String mnrDispFlgDt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mnrHngrFlg = null;
	/* Column Info */
	private String tmpMnrHngrTrfCd = null;
	/* Column Info */
	private String mnrHngrDmgQty = null;
	/* Column Info */
	private String mnrFlgCmplDt = null;
	/* Column Info */
	private String mnrFlgRmk = null;
	/* Column Info */
	private String mtrlCd = null;
	/* Column Info */
	private String rprCostAmt = null;
	/* Column Info */
	private String manuDt = null;
	/* Column Info */
	private String barIfChk = null;
	/* Column Info */
	private String tmpMnrStsRmk = null;
	/* Column Info */
	private String pLocCd = null;
	/* Column Info */
	private String mnrTariffType = null;
	/* Column Info */
	private String hngrBarAmdQty = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String mnrDmgFlgDtOverDay = null;
	/* Column Info */
	private String tmpMnrHngrRckCd = null;
	/* Column Info */
	private String mnrFlgInpTpCd = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String mnrDonaFlgYdCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mnrDmgFlg = null;
	/* Column Info */
	private String tmpMnrHngrTrfOtrDesc = null;
	/* Column Info */
	private String recentHngrBarAtchKnt = null;
	/* Column Info */
	private String mnrHngrRckCd = null;
	/* Column Info */
	private String mnrTtlLssFlgYdCd = null;
	/* Column Info */
	private String dispStsNm = null;
	/* Column Info */
	private String mnrStsFlg = null;
	/* Column Info */
	private String mnrTtlLssFlg = null;
	/* Column Info */
	private String tmpActInvtQty = null;
	/* Column Info */
	private String mnrDonaFlg = null;
	/* Column Info */
	private String mnrHngrTrfOtrDesc = null;
	/* Column Info */
	private String mtrlNm = null;
	/* Column Info */
	private String mnrTtlLssFlgDt = null;
	/* Column Info */
	private String hngrBarTtlQty = null;
	/* Column Info */
	private String sdaysDt = null;
	/* Column Info */
	private String mstDmgFlag = null;
	/* Column Info */
	private String tmpMnrLostHngrQty = null;
	/* Column Info */
	private String eqMvmtIdNo = null;
	/* Column Info */
	private String mnrDispHngrQty = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String mnrDispFlg = null;
	/* Column Info */
	private String hngrBarAtchKnt = null;
	/* Column Info */
	private String mnrOrgHngrBarTpCd = null;
	/* Column Info */
	private String mnrDispFlgYdCd = null;
	/* Column Info */
	private String mnrHngrFlgDt = null;
	/* Column Info */
	private String mnrScrpFlgDt = null;
	/* Column Info */
	private String dvValue = null;
	/* Column Info */
	private String tmpMnrHngrDmgQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrFlgSeq = null;
	/* Column Info */
	private String eqMvmtYr = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String eqMkrNm = null;
	/* Column Info */
	private String mnrScrpFlgYdCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String verifyResult = null;
	/* Column Info */
	private String mnrStsRmk = null;
	/* Column Info */
	private String mnrRprFlgDt = null;
	/* Column Info */
	private String mnrRprFlgYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String mnrHngrDtlOffrDesc = null;
	/* Column Info */
	private String mnrDispSelFlgDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrHngrFlgYdCd = null;
	/* Column Info */
	private String mnrFlgYdCd = null;
	/* Column Info */
	private String mvmtCd = null;
	/* Column Info */
	private String tmpMnrDispHngrQty = null;
	/* Column Info */
	private String actInvtQty = null;
	/* Column Info */
	private String tmpMnrHngrBarTpCd = null;
	/* Column Info */
	private String mnrDmgFlgDt = null;
	/* Column Info */
	private String mnrRprFlg = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String mnrHngrTrfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrEqStsVO() {}

	public CustomMnrEqStsVO(String ibflag, String pagerows, String mnrScrpFlg, String mnrDonaFlgDt, String mnrDmgFlgYdCd, String mnrDispSelTpCd, String mnrOrdOfcCtyCd, String mnrFlgInpDt, String pLocTp, String mnrHngrBarTpCd, String mnrLostHngrQty, String mnrDispSelFlg, String dispRsnCd, String utPrice, String updUsrId, String mnrDispSelFlgYdCd, String dispNo, String mnrFlgTpCd, String eqMdlNm, String mnrDispFlgDt, String eqTpszCd, String bkgNo, String mnrHngrFlg, String tmpMnrHngrTrfCd, String mnrFlgRmk, String mnrFlgCmplDt, String mnrHngrDmgQty, String mtrlCd, String rprCostAmt, String manuDt, String barIfChk, String tmpMnrStsRmk, String pLocCd, String mnrTariffType, String hngrBarAmdQty, String cnmvStsCd, String woNo, String rprQty, String mnrDmgFlgDtOverDay, String tmpMnrHngrRckCd, String costDtlCd, String mnrFlgInpTpCd, String eqKndCd, String mnrDonaFlgYdCd, String mnrDmgFlg, String ofcCd, String tmpMnrHngrTrfOtrDesc, String recentHngrBarAtchKnt, String mnrHngrRckCd, String mnrTtlLssFlgYdCd, String dispStsNm, String mnrStsFlg, String mnrTtlLssFlg, String tmpActInvtQty, String mnrDonaFlg, String mnrHngrTrfOtrDesc, String mtrlNm, String mnrTtlLssFlgDt, String hngrBarTtlQty, String sdaysDt, String mstDmgFlag, String tmpMnrLostHngrQty, String eqMvmtIdNo, String mnrDispHngrQty, String lstmCd, String mnrDispFlg, String hngrBarAtchKnt, String mnrOrgHngrBarTpCd, String mnrDispFlgYdCd, String mnrHngrFlgDt, String mnrScrpFlgDt, String dvValue, String tmpMnrHngrDmgQty, String creUsrId, String mnrFlgSeq, String eqMvmtYr, String mvmtDt, String eqMkrNm, String mnrScrpFlgYdCd, String creDt, String crntYdCd, String mnrStsRmk, String mnrRprFlgDt, String mnrRprFlgYdCd, String eqNo, String creOfcCd, String mnrHngrDtlOffrDesc, String mnrDispSelFlgDt, String updDt, String mnrHngrFlgYdCd, String mnrFlgYdCd, String mvmtCd, String tmpMnrDispHngrQty, String actInvtQty, String tmpMnrHngrBarTpCd, String mnrDmgFlgDt, String mnrRprFlg, String mnrOrdSeq, String mnrHngrTrfCd, String verifyResult) {
		this.mnrScrpFlg = mnrScrpFlg;
		this.mnrDonaFlgDt = mnrDonaFlgDt;
		this.mnrDmgFlgYdCd = mnrDmgFlgYdCd;
		this.pagerows = pagerows;
		this.mnrDispSelTpCd = mnrDispSelTpCd;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.mnrFlgInpDt = mnrFlgInpDt;
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
		this.pLocTp = pLocTp;
		this.mnrLostHngrQty = mnrLostHngrQty;
		this.mnrDispSelFlg = mnrDispSelFlg;
		this.dispRsnCd = dispRsnCd;
		this.utPrice = utPrice;
		this.updUsrId = updUsrId;
		this.mnrDispSelFlgYdCd = mnrDispSelFlgYdCd;
		this.dispNo = dispNo;
		this.mnrFlgTpCd = mnrFlgTpCd;
		this.eqMdlNm = eqMdlNm;
		this.mnrDispFlgDt = mnrDispFlgDt;
		this.eqTpszCd = eqTpszCd;
		this.bkgNo = bkgNo;
		this.mnrHngrFlg = mnrHngrFlg;
		this.tmpMnrHngrTrfCd = tmpMnrHngrTrfCd;
		this.mnrHngrDmgQty = mnrHngrDmgQty;
		this.mnrFlgCmplDt = mnrFlgCmplDt;
		this.mnrFlgRmk = mnrFlgRmk;
		this.mtrlCd = mtrlCd;
		this.rprCostAmt = rprCostAmt;
		this.manuDt = manuDt;
		this.barIfChk = barIfChk;
		this.tmpMnrStsRmk = tmpMnrStsRmk;
		this.pLocCd = pLocCd;
		this.mnrTariffType = mnrTariffType;
		this.hngrBarAmdQty = hngrBarAmdQty;
		this.cnmvStsCd = cnmvStsCd;
		this.rprQty = rprQty;
		this.woNo = woNo;
		this.mnrDmgFlgDtOverDay = mnrDmgFlgDtOverDay;
		this.tmpMnrHngrRckCd = tmpMnrHngrRckCd;
		this.mnrFlgInpTpCd = mnrFlgInpTpCd;
		this.costDtlCd = costDtlCd;
		this.eqKndCd = eqKndCd;
		this.mnrDonaFlgYdCd = mnrDonaFlgYdCd;
		this.ofcCd = ofcCd;
		this.mnrDmgFlg = mnrDmgFlg;
		this.tmpMnrHngrTrfOtrDesc = tmpMnrHngrTrfOtrDesc;
		this.recentHngrBarAtchKnt = recentHngrBarAtchKnt;
		this.mnrHngrRckCd = mnrHngrRckCd;
		this.mnrTtlLssFlgYdCd = mnrTtlLssFlgYdCd;
		this.dispStsNm = dispStsNm;
		this.mnrStsFlg = mnrStsFlg;
		this.mnrTtlLssFlg = mnrTtlLssFlg;
		this.tmpActInvtQty = tmpActInvtQty;
		this.mnrDonaFlg = mnrDonaFlg;
		this.mnrHngrTrfOtrDesc = mnrHngrTrfOtrDesc;
		this.mtrlNm = mtrlNm;
		this.mnrTtlLssFlgDt = mnrTtlLssFlgDt;
		this.hngrBarTtlQty = hngrBarTtlQty;
		this.sdaysDt = sdaysDt;
		this.mstDmgFlag = mstDmgFlag;
		this.tmpMnrLostHngrQty = tmpMnrLostHngrQty;
		this.eqMvmtIdNo = eqMvmtIdNo;
		this.mnrDispHngrQty = mnrDispHngrQty;
		this.lstmCd = lstmCd;
		this.mnrDispFlg = mnrDispFlg;
		this.hngrBarAtchKnt = hngrBarAtchKnt;
		this.mnrOrgHngrBarTpCd = mnrOrgHngrBarTpCd;
		this.mnrDispFlgYdCd = mnrDispFlgYdCd;
		this.mnrHngrFlgDt = mnrHngrFlgDt;
		this.mnrScrpFlgDt = mnrScrpFlgDt;
		this.dvValue = dvValue;
		this.tmpMnrHngrDmgQty = tmpMnrHngrDmgQty;
		this.creUsrId = creUsrId;
		this.mnrFlgSeq = mnrFlgSeq;
		this.eqMvmtYr = eqMvmtYr;
		this.mvmtDt = mvmtDt;
		this.eqMkrNm = eqMkrNm;
		this.mnrScrpFlgYdCd = mnrScrpFlgYdCd;
		this.creDt = creDt;
		this.crntYdCd = crntYdCd;
		this.verifyResult = verifyResult;
		this.mnrStsRmk = mnrStsRmk;
		this.mnrRprFlgDt = mnrRprFlgDt;
		this.mnrRprFlgYdCd = mnrRprFlgYdCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.creOfcCd = creOfcCd;
		this.mnrHngrDtlOffrDesc = mnrHngrDtlOffrDesc;
		this.mnrDispSelFlgDt = mnrDispSelFlgDt;
		this.updDt = updDt;
		this.mnrHngrFlgYdCd = mnrHngrFlgYdCd;
		this.mnrFlgYdCd = mnrFlgYdCd;
		this.mvmtCd = mvmtCd;
		this.tmpMnrDispHngrQty = tmpMnrDispHngrQty;
		this.actInvtQty = actInvtQty;
		this.tmpMnrHngrBarTpCd = tmpMnrHngrBarTpCd;
		this.mnrDmgFlgDt = mnrDmgFlgDt;
		this.mnrRprFlg = mnrRprFlg;
		this.mnrOrdSeq = mnrOrdSeq;
		this.mnrHngrTrfCd = mnrHngrTrfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_scrp_flg", getMnrScrpFlg());
		this.hashColumns.put("mnr_dona_flg_dt", getMnrDonaFlgDt());
		this.hashColumns.put("mnr_dmg_flg_yd_cd", getMnrDmgFlgYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_disp_sel_tp_cd", getMnrDispSelTpCd());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("mnr_flg_inp_dt", getMnrFlgInpDt());
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());
		this.hashColumns.put("p_loc_tp", getPLocTp());
		this.hashColumns.put("mnr_lost_hngr_qty", getMnrLostHngrQty());
		this.hashColumns.put("mnr_disp_sel_flg", getMnrDispSelFlg());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("ut_price", getUtPrice());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_disp_sel_flg_yd_cd", getMnrDispSelFlgYdCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("mnr_flg_tp_cd", getMnrFlgTpCd());
		this.hashColumns.put("eq_mdl_nm", getEqMdlNm());
		this.hashColumns.put("mnr_disp_flg_dt", getMnrDispFlgDt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mnr_hngr_flg", getMnrHngrFlg());
		this.hashColumns.put("tmp_mnr_hngr_trf_cd", getTmpMnrHngrTrfCd());
		this.hashColumns.put("mnr_hngr_dmg_qty", getMnrHngrDmgQty());
		this.hashColumns.put("mnr_flg_cmpl_dt", getMnrFlgCmplDt());
		this.hashColumns.put("mnr_flg_rmk", getMnrFlgRmk());
		this.hashColumns.put("mtrl_cd", getMtrlCd());
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());
		this.hashColumns.put("manu_dt", getManuDt());
		this.hashColumns.put("bar_if_chk", getBarIfChk());
		this.hashColumns.put("tmp_mnr_sts_rmk", getTmpMnrStsRmk());
		this.hashColumns.put("p_loc_cd", getPLocCd());
		this.hashColumns.put("mnr_tariff_type", getMnrTariffType());
		this.hashColumns.put("hngr_bar_amd_qty", getHngrBarAmdQty());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("mnr_dmg_flg_dt_over_day", getMnrDmgFlgDtOverDay());
		this.hashColumns.put("tmp_mnr_hngr_rck_cd", getTmpMnrHngrRckCd());
		this.hashColumns.put("mnr_flg_inp_tp_cd", getMnrFlgInpTpCd());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("mnr_dona_flg_yd_cd", getMnrDonaFlgYdCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mnr_dmg_flg", getMnrDmgFlg());
		this.hashColumns.put("tmp_mnr_hngr_trf_otr_desc", getTmpMnrHngrTrfOtrDesc());
		this.hashColumns.put("recent_hngr_bar_atch_knt", getRecentHngrBarAtchKnt());
		this.hashColumns.put("mnr_hngr_rck_cd", getMnrHngrRckCd());
		this.hashColumns.put("mnr_ttl_lss_flg_yd_cd", getMnrTtlLssFlgYdCd());
		this.hashColumns.put("disp_sts_nm", getDispStsNm());
		this.hashColumns.put("mnr_sts_flg", getMnrStsFlg());
		this.hashColumns.put("mnr_ttl_lss_flg", getMnrTtlLssFlg());
		this.hashColumns.put("tmp_act_invt_qty", getTmpActInvtQty());
		this.hashColumns.put("mnr_dona_flg", getMnrDonaFlg());
		this.hashColumns.put("mnr_hngr_trf_otr_desc", getMnrHngrTrfOtrDesc());
		this.hashColumns.put("mtrl_nm", getMtrlNm());
		this.hashColumns.put("mnr_ttl_lss_flg_dt", getMnrTtlLssFlgDt());
		this.hashColumns.put("hngr_bar_ttl_qty", getHngrBarTtlQty());
		this.hashColumns.put("sdays_dt", getSdaysDt());
		this.hashColumns.put("mst_dmg_flag", getMstDmgFlag());
		this.hashColumns.put("tmp_mnr_lost_hngr_qty", getTmpMnrLostHngrQty());
		this.hashColumns.put("eq_mvmt_id_no", getEqMvmtIdNo());
		this.hashColumns.put("mnr_disp_hngr_qty", getMnrDispHngrQty());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("mnr_disp_flg", getMnrDispFlg());
		this.hashColumns.put("hngr_bar_atch_knt", getHngrBarAtchKnt());
		this.hashColumns.put("mnr_org_hngr_bar_tp_cd", getMnrOrgHngrBarTpCd());
		this.hashColumns.put("mnr_disp_flg_yd_cd", getMnrDispFlgYdCd());
		this.hashColumns.put("mnr_hngr_flg_dt", getMnrHngrFlgDt());
		this.hashColumns.put("mnr_scrp_flg_dt", getMnrScrpFlgDt());
		this.hashColumns.put("dv_value", getDvValue());
		this.hashColumns.put("tmp_mnr_hngr_dmg_qty", getTmpMnrHngrDmgQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_flg_seq", getMnrFlgSeq());
		this.hashColumns.put("eq_mvmt_yr", getEqMvmtYr());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("eq_mkr_nm", getEqMkrNm());
		this.hashColumns.put("mnr_scrp_flg_yd_cd", getMnrScrpFlgYdCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("verify_result", getVerifyResult());
		this.hashColumns.put("mnr_sts_rmk", getMnrStsRmk());
		this.hashColumns.put("mnr_rpr_flg_dt", getMnrRprFlgDt());
		this.hashColumns.put("mnr_rpr_flg_yd_cd", getMnrRprFlgYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("mnr_hngr_dtl_offr_desc", getMnrHngrDtlOffrDesc());
		this.hashColumns.put("mnr_disp_sel_flg_dt", getMnrDispSelFlgDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_hngr_flg_yd_cd", getMnrHngrFlgYdCd());
		this.hashColumns.put("mnr_flg_yd_cd", getMnrFlgYdCd());
		this.hashColumns.put("mvmt_cd", getMvmtCd());
		this.hashColumns.put("tmp_mnr_disp_hngr_qty", getTmpMnrDispHngrQty());
		this.hashColumns.put("act_invt_qty", getActInvtQty());
		this.hashColumns.put("tmp_mnr_hngr_bar_tp_cd", getTmpMnrHngrBarTpCd());
		this.hashColumns.put("mnr_dmg_flg_dt", getMnrDmgFlgDt());
		this.hashColumns.put("mnr_rpr_flg", getMnrRprFlg());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("mnr_hngr_trf_cd", getMnrHngrTrfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_scrp_flg", "mnrScrpFlg");
		this.hashFields.put("mnr_dona_flg_dt", "mnrDonaFlgDt");
		this.hashFields.put("mnr_dmg_flg_yd_cd", "mnrDmgFlgYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_disp_sel_tp_cd", "mnrDispSelTpCd");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("mnr_flg_inp_dt", "mnrFlgInpDt");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("p_loc_tp", "pLocTp");
		this.hashFields.put("mnr_lost_hngr_qty", "mnrLostHngrQty");
		this.hashFields.put("mnr_disp_sel_flg", "mnrDispSelFlg");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("ut_price", "utPrice");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_disp_sel_flg_yd_cd", "mnrDispSelFlgYdCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_flg_tp_cd", "mnrFlgTpCd");
		this.hashFields.put("eq_mdl_nm", "eqMdlNm");
		this.hashFields.put("mnr_disp_flg_dt", "mnrDispFlgDt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mnr_hngr_flg", "mnrHngrFlg");
		this.hashFields.put("tmp_mnr_hngr_trf_cd", "tmpMnrHngrTrfCd");
		this.hashFields.put("mnr_hngr_dmg_qty", "mnrHngrDmgQty");
		this.hashFields.put("mnr_flg_cmpl_dt", "mnrFlgCmplDt");
		this.hashFields.put("mnr_flg_rmk", "mnrFlgRmk");
		this.hashFields.put("mtrl_cd", "mtrlCd");
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("manu_dt", "manuDt");
		this.hashFields.put("bar_if_chk", "barIfChk");
		this.hashFields.put("tmp_mnr_sts_rmk", "tmpMnrStsRmk");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("mnr_tariff_type", "mnrTariffType");
		this.hashFields.put("hngr_bar_amd_qty", "hngrBarAmdQty");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("mnr_dmg_flg_dt_over_day", "mnrDmgFlgDtOverDay");
		this.hashFields.put("tmp_mnr_hngr_rck_cd", "tmpMnrHngrRckCd");
		this.hashFields.put("mnr_flg_inp_tp_cd", "mnrFlgInpTpCd");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("mnr_dona_flg_yd_cd", "mnrDonaFlgYdCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mnr_dmg_flg", "mnrDmgFlg");
		this.hashFields.put("tmp_mnr_hngr_trf_otr_desc", "tmpMnrHngrTrfOtrDesc");
		this.hashFields.put("recent_hngr_bar_atch_knt", "recentHngrBarAtchKnt");
		this.hashFields.put("mnr_hngr_rck_cd", "mnrHngrRckCd");
		this.hashFields.put("mnr_ttl_lss_flg_yd_cd", "mnrTtlLssFlgYdCd");
		this.hashFields.put("disp_sts_nm", "dispStsNm");
		this.hashFields.put("mnr_sts_flg", "mnrStsFlg");
		this.hashFields.put("mnr_ttl_lss_flg", "mnrTtlLssFlg");
		this.hashFields.put("tmp_act_invt_qty", "tmpActInvtQty");
		this.hashFields.put("mnr_dona_flg", "mnrDonaFlg");
		this.hashFields.put("mnr_hngr_trf_otr_desc", "mnrHngrTrfOtrDesc");
		this.hashFields.put("mtrl_nm", "mtrlNm");
		this.hashFields.put("mnr_ttl_lss_flg_dt", "mnrTtlLssFlgDt");
		this.hashFields.put("hngr_bar_ttl_qty", "hngrBarTtlQty");
		this.hashFields.put("sdays_dt", "sdaysDt");
		this.hashFields.put("mst_dmg_flag", "mstDmgFlag");
		this.hashFields.put("tmp_mnr_lost_hngr_qty", "tmpMnrLostHngrQty");
		this.hashFields.put("eq_mvmt_id_no", "eqMvmtIdNo");
		this.hashFields.put("mnr_disp_hngr_qty", "mnrDispHngrQty");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mnr_disp_flg", "mnrDispFlg");
		this.hashFields.put("hngr_bar_atch_knt", "hngrBarAtchKnt");
		this.hashFields.put("mnr_org_hngr_bar_tp_cd", "mnrOrgHngrBarTpCd");
		this.hashFields.put("mnr_disp_flg_yd_cd", "mnrDispFlgYdCd");
		this.hashFields.put("mnr_hngr_flg_dt", "mnrHngrFlgDt");
		this.hashFields.put("mnr_scrp_flg_dt", "mnrScrpFlgDt");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("tmp_mnr_hngr_dmg_qty", "tmpMnrHngrDmgQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_flg_seq", "mnrFlgSeq");
		this.hashFields.put("eq_mvmt_yr", "eqMvmtYr");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("eq_mkr_nm", "eqMkrNm");
		this.hashFields.put("mnr_scrp_flg_yd_cd", "mnrScrpFlgYdCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("verify_result", "verifyResult");
		this.hashFields.put("mnr_sts_rmk", "mnrStsRmk");
		this.hashFields.put("mnr_rpr_flg_dt", "mnrRprFlgDt");
		this.hashFields.put("mnr_rpr_flg_yd_cd", "mnrRprFlgYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("mnr_hngr_dtl_offr_desc", "mnrHngrDtlOffrDesc");
		this.hashFields.put("mnr_disp_sel_flg_dt", "mnrDispSelFlgDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_hngr_flg_yd_cd", "mnrHngrFlgYdCd");
		this.hashFields.put("mnr_flg_yd_cd", "mnrFlgYdCd");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("tmp_mnr_disp_hngr_qty", "tmpMnrDispHngrQty");
		this.hashFields.put("act_invt_qty", "actInvtQty");
		this.hashFields.put("tmp_mnr_hngr_bar_tp_cd", "tmpMnrHngrBarTpCd");
		this.hashFields.put("mnr_dmg_flg_dt", "mnrDmgFlgDt");
		this.hashFields.put("mnr_rpr_flg", "mnrRprFlg");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("mnr_hngr_trf_cd", "mnrHngrTrfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrScrpFlg
	 */
	public String getMnrScrpFlg() {
		return this.mnrScrpFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrDonaFlgDt
	 */
	public String getMnrDonaFlgDt() {
		return this.mnrDonaFlgDt;
	}
	
	/**
	 * Column Info
	 * @return mnrDmgFlgYdCd
	 */
	public String getMnrDmgFlgYdCd() {
		return this.mnrDmgFlgYdCd;
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
	 * @return mnrDispSelTpCd
	 */
	public String getMnrDispSelTpCd() {
		return this.mnrDispSelTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgInpDt
	 */
	public String getMnrFlgInpDt() {
		return this.mnrFlgInpDt;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrBarTpCd
	 */
	public String getMnrHngrBarTpCd() {
		return this.mnrHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return pLocTp
	 */
	public String getPLocTp() {
		return this.pLocTp;
	}
	
	/**
	 * Column Info
	 * @return mnrLostHngrQty
	 */
	public String getMnrLostHngrQty() {
		return this.mnrLostHngrQty;
	}
	
	/**
	 * Column Info
	 * @return mnrDispSelFlg
	 */
	public String getMnrDispSelFlg() {
		return this.mnrDispSelFlg;
	}
	
	/**
	 * Column Info
	 * @return dispRsnCd
	 */
	public String getDispRsnCd() {
		return this.dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @return utPrice
	 */
	public String getUtPrice() {
		return this.utPrice;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return mnrDispSelFlgYdCd
	 */
	public String getMnrDispSelFlgYdCd() {
		return this.mnrDispSelFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgTpCd
	 */
	public String getMnrFlgTpCd() {
		return this.mnrFlgTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqMdlNm
	 */
	public String getEqMdlNm() {
		return this.eqMdlNm;
	}
	
	/**
	 * Column Info
	 * @return mnrDispFlgDt
	 */
	public String getMnrDispFlgDt() {
		return this.mnrDispFlgDt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrFlg
	 */
	public String getMnrHngrFlg() {
		return this.mnrHngrFlg;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrHngrTrfCd
	 */
	public String getTmpMnrHngrTrfCd() {
		return this.tmpMnrHngrTrfCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrDmgQty
	 */
	public String getMnrHngrDmgQty() {
		return this.mnrHngrDmgQty;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgCmplDt
	 */
	public String getMnrFlgCmplDt() {
		return this.mnrFlgCmplDt;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgRmk
	 */
	public String getMnrFlgRmk() {
		return this.mnrFlgRmk;
	}
	
	/**
	 * Column Info
	 * @return mtrlCd
	 */
	public String getMtrlCd() {
		return this.mtrlCd;
	}
	
	/**
	 * Column Info
	 * @return rprCostAmt
	 */
	public String getRprCostAmt() {
		return this.rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @return manuDt
	 */
	public String getManuDt() {
		return this.manuDt;
	}
	
	/**
	 * Column Info
	 * @return barIfChk
	 */
	public String getBarIfChk() {
		return this.barIfChk;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrStsRmk
	 */
	public String getTmpMnrStsRmk() {
		return this.tmpMnrStsRmk;
	}
	
	/**
	 * Column Info
	 * @return pLocCd
	 */
	public String getPLocCd() {
		return this.pLocCd;
	}
	
	/**
	 * Column Info
	 * @return mnrTariffType
	 */
	public String getMnrTariffType() {
		return this.mnrTariffType;
	}
	
	/**
	 * Column Info
	 * @return hngrBarAmdQty
	 */
	public String getHngrBarAmdQty() {
		return this.hngrBarAmdQty;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
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
	 * @return mnrDmgFlgDtOverDay
	 */
	public String getMnrDmgFlgDtOverDay() {
		return this.mnrDmgFlgDtOverDay;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrHngrRckCd
	 */
	public String getTmpMnrHngrRckCd() {
		return this.tmpMnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgInpTpCd
	 */
	public String getMnrFlgInpTpCd() {
		return this.mnrFlgInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDonaFlgYdCd
	 */
	public String getMnrDonaFlgYdCd() {
		return this.mnrDonaFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDmgFlg
	 */
	public String getMnrDmgFlg() {
		return this.mnrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrHngrTrfOtrDesc
	 */
	public String getTmpMnrHngrTrfOtrDesc() {
		return this.tmpMnrHngrTrfOtrDesc;
	}
	
	/**
	 * Column Info
	 * @return recentHngrBarAtchKnt
	 */
	public String getRecentHngrBarAtchKnt() {
		return this.recentHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrRckCd
	 */
	public String getMnrHngrRckCd() {
		return this.mnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return mnrTtlLssFlgYdCd
	 */
	public String getMnrTtlLssFlgYdCd() {
		return this.mnrTtlLssFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return dispStsNm
	 */
	public String getDispStsNm() {
		return this.dispStsNm;
	}
	
	/**
	 * Column Info
	 * @return mnrStsFlg
	 */
	public String getMnrStsFlg() {
		return this.mnrStsFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrTtlLssFlg
	 */
	public String getMnrTtlLssFlg() {
		return this.mnrTtlLssFlg;
	}
	
	/**
	 * Column Info
	 * @return tmpActInvtQty
	 */
	public String getTmpActInvtQty() {
		return this.tmpActInvtQty;
	}
	
	/**
	 * Column Info
	 * @return mnrDonaFlg
	 */
	public String getMnrDonaFlg() {
		return this.mnrDonaFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrTrfOtrDesc
	 */
	public String getMnrHngrTrfOtrDesc() {
		return this.mnrHngrTrfOtrDesc;
	}
	
	/**
	 * Column Info
	 * @return mtrlNm
	 */
	public String getMtrlNm() {
		return this.mtrlNm;
	}
	
	/**
	 * Column Info
	 * @return mnrTtlLssFlgDt
	 */
	public String getMnrTtlLssFlgDt() {
		return this.mnrTtlLssFlgDt;
	}
	
	/**
	 * Column Info
	 * @return hngrBarTtlQty
	 */
	public String getHngrBarTtlQty() {
		return this.hngrBarTtlQty;
	}
	
	/**
	 * Column Info
	 * @return sdaysDt
	 */
	public String getSdaysDt() {
		return this.sdaysDt;
	}
	
	/**
	 * Column Info
	 * @return mstDmgFlag
	 */
	public String getMstDmgFlag() {
		return this.mstDmgFlag;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrLostHngrQty
	 */
	public String getTmpMnrLostHngrQty() {
		return this.tmpMnrLostHngrQty;
	}
	
	/**
	 * Column Info
	 * @return eqMvmtIdNo
	 */
	public String getEqMvmtIdNo() {
		return this.eqMvmtIdNo;
	}
	
	/**
	 * Column Info
	 * @return mnrDispHngrQty
	 */
	public String getMnrDispHngrQty() {
		return this.mnrDispHngrQty;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispFlg
	 */
	public String getMnrDispFlg() {
		return this.mnrDispFlg;
	}
	
	/**
	 * Column Info
	 * @return hngrBarAtchKnt
	 */
	public String getHngrBarAtchKnt() {
		return this.hngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return mnrOrgHngrBarTpCd
	 */
	public String getMnrOrgHngrBarTpCd() {
		return this.mnrOrgHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispFlgYdCd
	 */
	public String getMnrDispFlgYdCd() {
		return this.mnrDispFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrFlgDt
	 */
	public String getMnrHngrFlgDt() {
		return this.mnrHngrFlgDt;
	}
	
	/**
	 * Column Info
	 * @return mnrScrpFlgDt
	 */
	public String getMnrScrpFlgDt() {
		return this.mnrScrpFlgDt;
	}
	
	/**
	 * Column Info
	 * @return dvValue
	 */
	public String getDvValue() {
		return this.dvValue;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrHngrDmgQty
	 */
	public String getTmpMnrHngrDmgQty() {
		return this.tmpMnrHngrDmgQty;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgSeq
	 */
	public String getMnrFlgSeq() {
		return this.mnrFlgSeq;
	}
	
	/**
	 * Column Info
	 * @return eqMvmtYr
	 */
	public String getEqMvmtYr() {
		return this.eqMvmtYr;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return eqMkrNm
	 */
	public String getEqMkrNm() {
		return this.eqMkrNm;
	}
	
	/**
	 * Column Info
	 * @return mnrScrpFlgYdCd
	 */
	public String getMnrScrpFlgYdCd() {
		return this.mnrScrpFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return verifyResult
	 */
	public String getVerifyResult() {
		return this.verifyResult;
	}
	
	/**
	 * Column Info
	 * @return mnrStsRmk
	 */
	public String getMnrStsRmk() {
		return this.mnrStsRmk;
	}
	
	/**
	 * Column Info
	 * @return mnrRprFlgDt
	 */
	public String getMnrRprFlgDt() {
		return this.mnrRprFlgDt;
	}
	
	/**
	 * Column Info
	 * @return mnrRprFlgYdCd
	 */
	public String getMnrRprFlgYdCd() {
		return this.mnrRprFlgYdCd;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrDtlOffrDesc
	 */
	public String getMnrHngrDtlOffrDesc() {
		return this.mnrHngrDtlOffrDesc;
	}
	
	/**
	 * Column Info
	 * @return mnrDispSelFlgDt
	 */
	public String getMnrDispSelFlgDt() {
		return this.mnrDispSelFlgDt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrFlgYdCd
	 */
	public String getMnrHngrFlgYdCd() {
		return this.mnrHngrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return mnrFlgYdCd
	 */
	public String getMnrFlgYdCd() {
		return this.mnrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtCd
	 */
	public String getMvmtCd() {
		return this.mvmtCd;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrDispHngrQty
	 */
	public String getTmpMnrDispHngrQty() {
		return this.tmpMnrDispHngrQty;
	}
	
	/**
	 * Column Info
	 * @return actInvtQty
	 */
	public String getActInvtQty() {
		return this.actInvtQty;
	}
	
	/**
	 * Column Info
	 * @return tmpMnrHngrBarTpCd
	 */
	public String getTmpMnrHngrBarTpCd() {
		return this.tmpMnrHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDmgFlgDt
	 */
	public String getMnrDmgFlgDt() {
		return this.mnrDmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @return mnrRprFlg
	 */
	public String getMnrRprFlg() {
		return this.mnrRprFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrTrfCd
	 */
	public String getMnrHngrTrfCd() {
		return this.mnrHngrTrfCd;
	}
	

	/**
	 * Column Info
	 * @param mnrScrpFlg
	 */
	public void setMnrScrpFlg(String mnrScrpFlg) {
		this.mnrScrpFlg = mnrScrpFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrDonaFlgDt
	 */
	public void setMnrDonaFlgDt(String mnrDonaFlgDt) {
		this.mnrDonaFlgDt = mnrDonaFlgDt;
	}
	
	/**
	 * Column Info
	 * @param mnrDmgFlgYdCd
	 */
	public void setMnrDmgFlgYdCd(String mnrDmgFlgYdCd) {
		this.mnrDmgFlgYdCd = mnrDmgFlgYdCd;
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
	 * @param mnrDispSelTpCd
	 */
	public void setMnrDispSelTpCd(String mnrDispSelTpCd) {
		this.mnrDispSelTpCd = mnrDispSelTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgInpDt
	 */
	public void setMnrFlgInpDt(String mnrFlgInpDt) {
		this.mnrFlgInpDt = mnrFlgInpDt;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrBarTpCd
	 */
	public void setMnrHngrBarTpCd(String mnrHngrBarTpCd) {
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param pLocTp
	 */
	public void setPLocTp(String pLocTp) {
		this.pLocTp = pLocTp;
	}
	
	/**
	 * Column Info
	 * @param mnrLostHngrQty
	 */
	public void setMnrLostHngrQty(String mnrLostHngrQty) {
		this.mnrLostHngrQty = mnrLostHngrQty;
	}
	
	/**
	 * Column Info
	 * @param mnrDispSelFlg
	 */
	public void setMnrDispSelFlg(String mnrDispSelFlg) {
		this.mnrDispSelFlg = mnrDispSelFlg;
	}
	
	/**
	 * Column Info
	 * @param dispRsnCd
	 */
	public void setDispRsnCd(String dispRsnCd) {
		this.dispRsnCd = dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @param utPrice
	 */
	public void setUtPrice(String utPrice) {
		this.utPrice = utPrice;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param mnrDispSelFlgYdCd
	 */
	public void setMnrDispSelFlgYdCd(String mnrDispSelFlgYdCd) {
		this.mnrDispSelFlgYdCd = mnrDispSelFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgTpCd
	 */
	public void setMnrFlgTpCd(String mnrFlgTpCd) {
		this.mnrFlgTpCd = mnrFlgTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqMdlNm
	 */
	public void setEqMdlNm(String eqMdlNm) {
		this.eqMdlNm = eqMdlNm;
	}
	
	/**
	 * Column Info
	 * @param mnrDispFlgDt
	 */
	public void setMnrDispFlgDt(String mnrDispFlgDt) {
		this.mnrDispFlgDt = mnrDispFlgDt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrFlg
	 */
	public void setMnrHngrFlg(String mnrHngrFlg) {
		this.mnrHngrFlg = mnrHngrFlg;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrHngrTrfCd
	 */
	public void setTmpMnrHngrTrfCd(String tmpMnrHngrTrfCd) {
		this.tmpMnrHngrTrfCd = tmpMnrHngrTrfCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrDmgQty
	 */
	public void setMnrHngrDmgQty(String mnrHngrDmgQty) {
		this.mnrHngrDmgQty = mnrHngrDmgQty;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgCmplDt
	 */
	public void setMnrFlgCmplDt(String mnrFlgCmplDt) {
		this.mnrFlgCmplDt = mnrFlgCmplDt;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgRmk
	 */
	public void setMnrFlgRmk(String mnrFlgRmk) {
		this.mnrFlgRmk = mnrFlgRmk;
	}
	
	/**
	 * Column Info
	 * @param mtrlCd
	 */
	public void setMtrlCd(String mtrlCd) {
		this.mtrlCd = mtrlCd;
	}
	
	/**
	 * Column Info
	 * @param rprCostAmt
	 */
	public void setRprCostAmt(String rprCostAmt) {
		this.rprCostAmt = rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @param manuDt
	 */
	public void setManuDt(String manuDt) {
		this.manuDt = manuDt;
	}
	
	/**
	 * Column Info
	 * @param barIfChk
	 */
	public void setBarIfChk(String barIfChk) {
		this.barIfChk = barIfChk;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrStsRmk
	 */
	public void setTmpMnrStsRmk(String tmpMnrStsRmk) {
		this.tmpMnrStsRmk = tmpMnrStsRmk;
	}
	
	/**
	 * Column Info
	 * @param pLocCd
	 */
	public void setPLocCd(String pLocCd) {
		this.pLocCd = pLocCd;
	}
	
	/**
	 * Column Info
	 * @param mnrTariffType
	 */
	public void setMnrTariffType(String mnrTariffType) {
		this.mnrTariffType = mnrTariffType;
	}
	
	/**
	 * Column Info
	 * @param hngrBarAmdQty
	 */
	public void setHngrBarAmdQty(String hngrBarAmdQty) {
		this.hngrBarAmdQty = hngrBarAmdQty;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
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
	 * @param mnrDmgFlgDtOverDay
	 */
	public void setMnrDmgFlgDtOverDay(String mnrDmgFlgDtOverDay) {
		this.mnrDmgFlgDtOverDay = mnrDmgFlgDtOverDay;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrHngrRckCd
	 */
	public void setTmpMnrHngrRckCd(String tmpMnrHngrRckCd) {
		this.tmpMnrHngrRckCd = tmpMnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgInpTpCd
	 */
	public void setMnrFlgInpTpCd(String mnrFlgInpTpCd) {
		this.mnrFlgInpTpCd = mnrFlgInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDonaFlgYdCd
	 */
	public void setMnrDonaFlgYdCd(String mnrDonaFlgYdCd) {
		this.mnrDonaFlgYdCd = mnrDonaFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDmgFlg
	 */
	public void setMnrDmgFlg(String mnrDmgFlg) {
		this.mnrDmgFlg = mnrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrHngrTrfOtrDesc
	 */
	public void setTmpMnrHngrTrfOtrDesc(String tmpMnrHngrTrfOtrDesc) {
		this.tmpMnrHngrTrfOtrDesc = tmpMnrHngrTrfOtrDesc;
	}
	
	/**
	 * Column Info
	 * @param recentHngrBarAtchKnt
	 */
	public void setRecentHngrBarAtchKnt(String recentHngrBarAtchKnt) {
		this.recentHngrBarAtchKnt = recentHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrRckCd
	 */
	public void setMnrHngrRckCd(String mnrHngrRckCd) {
		this.mnrHngrRckCd = mnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param mnrTtlLssFlgYdCd
	 */
	public void setMnrTtlLssFlgYdCd(String mnrTtlLssFlgYdCd) {
		this.mnrTtlLssFlgYdCd = mnrTtlLssFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param dispStsNm
	 */
	public void setDispStsNm(String dispStsNm) {
		this.dispStsNm = dispStsNm;
	}
	
	/**
	 * Column Info
	 * @param mnrStsFlg
	 */
	public void setMnrStsFlg(String mnrStsFlg) {
		this.mnrStsFlg = mnrStsFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrTtlLssFlg
	 */
	public void setMnrTtlLssFlg(String mnrTtlLssFlg) {
		this.mnrTtlLssFlg = mnrTtlLssFlg;
	}
	
	/**
	 * Column Info
	 * @param tmpActInvtQty
	 */
	public void setTmpActInvtQty(String tmpActInvtQty) {
		this.tmpActInvtQty = tmpActInvtQty;
	}
	
	/**
	 * Column Info
	 * @param mnrDonaFlg
	 */
	public void setMnrDonaFlg(String mnrDonaFlg) {
		this.mnrDonaFlg = mnrDonaFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrTrfOtrDesc
	 */
	public void setMnrHngrTrfOtrDesc(String mnrHngrTrfOtrDesc) {
		this.mnrHngrTrfOtrDesc = mnrHngrTrfOtrDesc;
	}
	
	/**
	 * Column Info
	 * @param mtrlNm
	 */
	public void setMtrlNm(String mtrlNm) {
		this.mtrlNm = mtrlNm;
	}
	
	/**
	 * Column Info
	 * @param mnrTtlLssFlgDt
	 */
	public void setMnrTtlLssFlgDt(String mnrTtlLssFlgDt) {
		this.mnrTtlLssFlgDt = mnrTtlLssFlgDt;
	}
	
	/**
	 * Column Info
	 * @param hngrBarTtlQty
	 */
	public void setHngrBarTtlQty(String hngrBarTtlQty) {
		this.hngrBarTtlQty = hngrBarTtlQty;
	}
	
	/**
	 * Column Info
	 * @param sdaysDt
	 */
	public void setSdaysDt(String sdaysDt) {
		this.sdaysDt = sdaysDt;
	}
	
	/**
	 * Column Info
	 * @param mstDmgFlag
	 */
	public void setMstDmgFlag(String mstDmgFlag) {
		this.mstDmgFlag = mstDmgFlag;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrLostHngrQty
	 */
	public void setTmpMnrLostHngrQty(String tmpMnrLostHngrQty) {
		this.tmpMnrLostHngrQty = tmpMnrLostHngrQty;
	}
	
	/**
	 * Column Info
	 * @param eqMvmtIdNo
	 */
	public void setEqMvmtIdNo(String eqMvmtIdNo) {
		this.eqMvmtIdNo = eqMvmtIdNo;
	}
	
	/**
	 * Column Info
	 * @param mnrDispHngrQty
	 */
	public void setMnrDispHngrQty(String mnrDispHngrQty) {
		this.mnrDispHngrQty = mnrDispHngrQty;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispFlg
	 */
	public void setMnrDispFlg(String mnrDispFlg) {
		this.mnrDispFlg = mnrDispFlg;
	}
	
	/**
	 * Column Info
	 * @param hngrBarAtchKnt
	 */
	public void setHngrBarAtchKnt(String hngrBarAtchKnt) {
		this.hngrBarAtchKnt = hngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param mnrOrgHngrBarTpCd
	 */
	public void setMnrOrgHngrBarTpCd(String mnrOrgHngrBarTpCd) {
		this.mnrOrgHngrBarTpCd = mnrOrgHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispFlgYdCd
	 */
	public void setMnrDispFlgYdCd(String mnrDispFlgYdCd) {
		this.mnrDispFlgYdCd = mnrDispFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrFlgDt
	 */
	public void setMnrHngrFlgDt(String mnrHngrFlgDt) {
		this.mnrHngrFlgDt = mnrHngrFlgDt;
	}
	
	/**
	 * Column Info
	 * @param mnrScrpFlgDt
	 */
	public void setMnrScrpFlgDt(String mnrScrpFlgDt) {
		this.mnrScrpFlgDt = mnrScrpFlgDt;
	}
	
	/**
	 * Column Info
	 * @param dvValue
	 */
	public void setDvValue(String dvValue) {
		this.dvValue = dvValue;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrHngrDmgQty
	 */
	public void setTmpMnrHngrDmgQty(String tmpMnrHngrDmgQty) {
		this.tmpMnrHngrDmgQty = tmpMnrHngrDmgQty;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgSeq
	 */
	public void setMnrFlgSeq(String mnrFlgSeq) {
		this.mnrFlgSeq = mnrFlgSeq;
	}
	
	/**
	 * Column Info
	 * @param eqMvmtYr
	 */
	public void setEqMvmtYr(String eqMvmtYr) {
		this.eqMvmtYr = eqMvmtYr;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param eqMkrNm
	 */
	public void setEqMkrNm(String eqMkrNm) {
		this.eqMkrNm = eqMkrNm;
	}
	
	/**
	 * Column Info
	 * @param mnrScrpFlgYdCd
	 */
	public void setMnrScrpFlgYdCd(String mnrScrpFlgYdCd) {
		this.mnrScrpFlgYdCd = mnrScrpFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param verifyResult
	 */
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	
	/**
	 * Column Info
	 * @param mnrStsRmk
	 */
	public void setMnrStsRmk(String mnrStsRmk) {
		this.mnrStsRmk = mnrStsRmk;
	}
	
	/**
	 * Column Info
	 * @param mnrRprFlgDt
	 */
	public void setMnrRprFlgDt(String mnrRprFlgDt) {
		this.mnrRprFlgDt = mnrRprFlgDt;
	}
	
	/**
	 * Column Info
	 * @param mnrRprFlgYdCd
	 */
	public void setMnrRprFlgYdCd(String mnrRprFlgYdCd) {
		this.mnrRprFlgYdCd = mnrRprFlgYdCd;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrDtlOffrDesc
	 */
	public void setMnrHngrDtlOffrDesc(String mnrHngrDtlOffrDesc) {
		this.mnrHngrDtlOffrDesc = mnrHngrDtlOffrDesc;
	}
	
	/**
	 * Column Info
	 * @param mnrDispSelFlgDt
	 */
	public void setMnrDispSelFlgDt(String mnrDispSelFlgDt) {
		this.mnrDispSelFlgDt = mnrDispSelFlgDt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrFlgYdCd
	 */
	public void setMnrHngrFlgYdCd(String mnrHngrFlgYdCd) {
		this.mnrHngrFlgYdCd = mnrHngrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param mnrFlgYdCd
	 */
	public void setMnrFlgYdCd(String mnrFlgYdCd) {
		this.mnrFlgYdCd = mnrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtCd
	 */
	public void setMvmtCd(String mvmtCd) {
		this.mvmtCd = mvmtCd;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrDispHngrQty
	 */
	public void setTmpMnrDispHngrQty(String tmpMnrDispHngrQty) {
		this.tmpMnrDispHngrQty = tmpMnrDispHngrQty;
	}
	
	/**
	 * Column Info
	 * @param actInvtQty
	 */
	public void setActInvtQty(String actInvtQty) {
		this.actInvtQty = actInvtQty;
	}
	
	/**
	 * Column Info
	 * @param tmpMnrHngrBarTpCd
	 */
	public void setTmpMnrHngrBarTpCd(String tmpMnrHngrBarTpCd) {
		this.tmpMnrHngrBarTpCd = tmpMnrHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDmgFlgDt
	 */
	public void setMnrDmgFlgDt(String mnrDmgFlgDt) {
		this.mnrDmgFlgDt = mnrDmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @param mnrRprFlg
	 */
	public void setMnrRprFlg(String mnrRprFlg) {
		this.mnrRprFlg = mnrRprFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrTrfCd
	 */
	public void setMnrHngrTrfCd(String mnrHngrTrfCd) {
		this.mnrHngrTrfCd = mnrHngrTrfCd;
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
		setMnrScrpFlg(JSPUtil.getParameter(request, prefix + "mnr_scrp_flg", ""));
		setMnrDonaFlgDt(JSPUtil.getParameter(request, prefix + "mnr_dona_flg_dt", ""));
		setMnrDmgFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_dmg_flg_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrDispSelTpCd(JSPUtil.getParameter(request, prefix + "mnr_disp_sel_tp_cd", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setMnrFlgInpDt(JSPUtil.getParameter(request, prefix + "mnr_flg_inp_dt", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_bar_tp_cd", ""));
		setPLocTp(JSPUtil.getParameter(request, prefix + "p_loc_tp", ""));
		setMnrLostHngrQty(JSPUtil.getParameter(request, prefix + "mnr_lost_hngr_qty", ""));
		setMnrDispSelFlg(JSPUtil.getParameter(request, prefix + "mnr_disp_sel_flg", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setUtPrice(JSPUtil.getParameter(request, prefix + "ut_price", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMnrDispSelFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_disp_sel_flg_yd_cd", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setMnrFlgTpCd(JSPUtil.getParameter(request, prefix + "mnr_flg_tp_cd", ""));
		setEqMdlNm(JSPUtil.getParameter(request, prefix + "eq_mdl_nm", ""));
		setMnrDispFlgDt(JSPUtil.getParameter(request, prefix + "mnr_disp_flg_dt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMnrHngrFlg(JSPUtil.getParameter(request, prefix + "mnr_hngr_flg", ""));
		setTmpMnrHngrTrfCd(JSPUtil.getParameter(request, prefix + "tmp_mnr_hngr_trf_cd", ""));
		setMnrHngrDmgQty(JSPUtil.getParameter(request, prefix + "mnr_hngr_dmg_qty", ""));
		setMnrFlgCmplDt(JSPUtil.getParameter(request, prefix + "mnr_flg_cmpl_dt", ""));
		setMnrFlgRmk(JSPUtil.getParameter(request, prefix + "mnr_flg_rmk", ""));
		setMtrlCd(JSPUtil.getParameter(request, prefix + "mtrl_cd", ""));
		setRprCostAmt(JSPUtil.getParameter(request, prefix + "rpr_cost_amt", ""));
		setManuDt(JSPUtil.getParameter(request, prefix + "manu_dt", ""));
		setBarIfChk(JSPUtil.getParameter(request, prefix + "bar_if_chk", ""));
		setTmpMnrStsRmk(JSPUtil.getParameter(request, prefix + "tmp_mnr_sts_rmk", ""));
		setPLocCd(JSPUtil.getParameter(request, prefix + "p_loc_cd", ""));
		setMnrTariffType(JSPUtil.getParameter(request, prefix + "mnr_tariff_type", ""));
		setHngrBarAmdQty(JSPUtil.getParameter(request, prefix + "hngr_bar_amd_qty", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setMnrDmgFlgDtOverDay(JSPUtil.getParameter(request, prefix + "mnr_dmg_flg_dt_over_day", ""));
		setTmpMnrHngrRckCd(JSPUtil.getParameter(request, prefix + "tmp_mnr_hngr_rck_cd", ""));
		setMnrFlgInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_flg_inp_tp_cd", ""));
		setCostDtlCd(JSPUtil.getParameter(request, prefix + "cost_dtl_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setMnrDonaFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_dona_flg_yd_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMnrDmgFlg(JSPUtil.getParameter(request, prefix + "mnr_dmg_flg", ""));
		setTmpMnrHngrTrfOtrDesc(JSPUtil.getParameter(request, prefix + "tmp_mnr_hngr_trf_otr_desc", ""));
		setRecentHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "recent_hngr_bar_atch_knt", ""));
		setMnrHngrRckCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_rck_cd", ""));
		setMnrTtlLssFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_ttl_lss_flg_yd_cd", ""));
		setDispStsNm(JSPUtil.getParameter(request, prefix + "disp_sts_nm", ""));
		setMnrStsFlg(JSPUtil.getParameter(request, prefix + "mnr_sts_flg", ""));
		setMnrTtlLssFlg(JSPUtil.getParameter(request, prefix + "mnr_ttl_lss_flg", ""));
		setTmpActInvtQty(JSPUtil.getParameter(request, prefix + "tmp_act_invt_qty", ""));
		setMnrDonaFlg(JSPUtil.getParameter(request, prefix + "mnr_dona_flg", ""));
		setMnrHngrTrfOtrDesc(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_otr_desc", ""));
		setMtrlNm(JSPUtil.getParameter(request, prefix + "mtrl_nm", ""));
		setMnrTtlLssFlgDt(JSPUtil.getParameter(request, prefix + "mnr_ttl_lss_flg_dt", ""));
		setHngrBarTtlQty(JSPUtil.getParameter(request, prefix + "hngr_bar_ttl_qty", ""));
		setSdaysDt(JSPUtil.getParameter(request, prefix + "sdays_dt", ""));
		setMstDmgFlag(JSPUtil.getParameter(request, prefix + "mst_dmg_flag", ""));
		setTmpMnrLostHngrQty(JSPUtil.getParameter(request, prefix + "tmp_mnr_lost_hngr_qty", ""));
		setEqMvmtIdNo(JSPUtil.getParameter(request, prefix + "eq_mvmt_id_no", ""));
		setMnrDispHngrQty(JSPUtil.getParameter(request, prefix + "mnr_disp_hngr_qty", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setMnrDispFlg(JSPUtil.getParameter(request, prefix + "mnr_disp_flg", ""));
		setHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "hngr_bar_atch_knt", ""));
		setMnrOrgHngrBarTpCd(JSPUtil.getParameter(request, prefix + "mnr_org_hngr_bar_tp_cd", ""));
		setMnrDispFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_disp_flg_yd_cd", ""));
		setMnrHngrFlgDt(JSPUtil.getParameter(request, prefix + "mnr_hngr_flg_dt", ""));
		setMnrScrpFlgDt(JSPUtil.getParameter(request, prefix + "mnr_scrp_flg_dt", ""));
		setDvValue(JSPUtil.getParameter(request, prefix + "dv_value", ""));
		setTmpMnrHngrDmgQty(JSPUtil.getParameter(request, prefix + "tmp_mnr_hngr_dmg_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMnrFlgSeq(JSPUtil.getParameter(request, prefix + "mnr_flg_seq", ""));
		setEqMvmtYr(JSPUtil.getParameter(request, prefix + "eq_mvmt_yr", ""));
		setMvmtDt(JSPUtil.getParameter(request, prefix + "mvmt_dt", ""));
		setEqMkrNm(JSPUtil.getParameter(request, prefix + "eq_mkr_nm", ""));
		setMnrScrpFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_scrp_flg_yd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setVerifyResult(JSPUtil.getParameter(request, prefix + "verify_result", ""));
		setMnrStsRmk(JSPUtil.getParameter(request, prefix + "mnr_sts_rmk", ""));
		setMnrRprFlgDt(JSPUtil.getParameter(request, prefix + "mnr_rpr_flg_dt", ""));
		setMnrRprFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_rpr_flg_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setMnrHngrDtlOffrDesc(JSPUtil.getParameter(request, prefix + "mnr_hngr_dtl_offr_desc", ""));
		setMnrDispSelFlgDt(JSPUtil.getParameter(request, prefix + "mnr_disp_sel_flg_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMnrHngrFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_flg_yd_cd", ""));
		setMnrFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_flg_yd_cd", ""));
		setMvmtCd(JSPUtil.getParameter(request, prefix + "mvmt_cd", ""));
		setTmpMnrDispHngrQty(JSPUtil.getParameter(request, prefix + "tmp_mnr_disp_hngr_qty", ""));
		setActInvtQty(JSPUtil.getParameter(request, prefix + "act_invt_qty", ""));
		setTmpMnrHngrBarTpCd(JSPUtil.getParameter(request, prefix + "tmp_mnr_hngr_bar_tp_cd", ""));
		setMnrDmgFlgDt(JSPUtil.getParameter(request, prefix + "mnr_dmg_flg_dt", ""));
		setMnrRprFlg(JSPUtil.getParameter(request, prefix + "mnr_rpr_flg", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setMnrHngrTrfCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrEqStsVO[]
	 */
	public CustomMnrEqStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrEqStsVO[]
	 */
	public CustomMnrEqStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrEqStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrScrpFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_scrp_flg", length));
			String[] mnrDonaFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_dona_flg_dt", length));
			String[] mnrDmgFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_dmg_flg_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrDispSelTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_tp_cd", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] mnrFlgInpDt = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_inp_dt", length));
			String[] mnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_cd", length));
			String[] pLocTp = (JSPUtil.getParameter(request, prefix	+ "p_loc_tp", length));
			String[] mnrLostHngrQty = (JSPUtil.getParameter(request, prefix	+ "mnr_lost_hngr_qty", length));
			String[] mnrDispSelFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_flg", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] utPrice = (JSPUtil.getParameter(request, prefix	+ "ut_price", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrDispSelFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_flg_yd_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] mnrFlgTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_tp_cd", length));
			String[] eqMdlNm = (JSPUtil.getParameter(request, prefix	+ "eq_mdl_nm", length));
			String[] mnrDispFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_flg_dt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mnrHngrFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_flg", length));
			String[] tmpMnrHngrTrfCd = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_hngr_trf_cd", length));
			String[] mnrHngrDmgQty = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_dmg_qty", length));
			String[] mnrFlgCmplDt = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_cmpl_dt", length));
			String[] mnrFlgRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_rmk", length));
			String[] mtrlCd = (JSPUtil.getParameter(request, prefix	+ "mtrl_cd", length));
			String[] rprCostAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_amt", length));
			String[] manuDt = (JSPUtil.getParameter(request, prefix	+ "manu_dt", length));
			String[] barIfChk = (JSPUtil.getParameter(request, prefix	+ "bar_if_chk", length));
			String[] tmpMnrStsRmk = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_sts_rmk", length));
			String[] pLocCd = (JSPUtil.getParameter(request, prefix	+ "p_loc_cd", length));
			String[] mnrTariffType = (JSPUtil.getParameter(request, prefix	+ "mnr_tariff_type", length));
			String[] hngrBarAmdQty = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_amd_qty", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] mnrDmgFlgDtOverDay = (JSPUtil.getParameter(request, prefix	+ "mnr_dmg_flg_dt_over_day", length));
			String[] tmpMnrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_hngr_rck_cd", length));
			String[] mnrFlgInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_inp_tp_cd", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] mnrDonaFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_dona_flg_yd_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mnrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_dmg_flg", length));
			String[] tmpMnrHngrTrfOtrDesc = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_hngr_trf_otr_desc", length));
			String[] recentHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "recent_hngr_bar_atch_knt", length));
			String[] mnrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_rck_cd", length));
			String[] mnrTtlLssFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ttl_lss_flg_yd_cd", length));
			String[] dispStsNm = (JSPUtil.getParameter(request, prefix	+ "disp_sts_nm", length));
			String[] mnrStsFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_sts_flg", length));
			String[] mnrTtlLssFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_ttl_lss_flg", length));
			String[] tmpActInvtQty = (JSPUtil.getParameter(request, prefix	+ "tmp_act_invt_qty", length));
			String[] mnrDonaFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_dona_flg", length));
			String[] mnrHngrTrfOtrDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_otr_desc", length));
			String[] mtrlNm = (JSPUtil.getParameter(request, prefix	+ "mtrl_nm", length));
			String[] mnrTtlLssFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_ttl_lss_flg_dt", length));
			String[] hngrBarTtlQty = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_ttl_qty", length));
			String[] sdaysDt = (JSPUtil.getParameter(request, prefix	+ "sdays_dt", length));
			String[] mstDmgFlag = (JSPUtil.getParameter(request, prefix	+ "mst_dmg_flag", length));
			String[] tmpMnrLostHngrQty = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_lost_hngr_qty", length));
			String[] eqMvmtIdNo = (JSPUtil.getParameter(request, prefix	+ "eq_mvmt_id_no", length));
			String[] mnrDispHngrQty = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_hngr_qty", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] mnrDispFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_flg", length));
			String[] hngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "hngr_bar_atch_knt", length));
			String[] mnrOrgHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_org_hngr_bar_tp_cd", length));
			String[] mnrDispFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_flg_yd_cd", length));
			String[] mnrHngrFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_flg_dt", length));
			String[] mnrScrpFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_scrp_flg_dt", length));
			String[] dvValue = (JSPUtil.getParameter(request, prefix	+ "dv_value", length));
			String[] tmpMnrHngrDmgQty = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_hngr_dmg_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrFlgSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_seq", length));
			String[] eqMvmtYr = (JSPUtil.getParameter(request, prefix	+ "eq_mvmt_yr", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] eqMkrNm = (JSPUtil.getParameter(request, prefix	+ "eq_mkr_nm", length));
			String[] mnrScrpFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_scrp_flg_yd_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] verifyResult = (JSPUtil.getParameter(request, prefix	+ "verify_result", length));
			String[] mnrStsRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_sts_rmk", length));
			String[] mnrRprFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_rpr_flg_dt", length));
			String[] mnrRprFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rpr_flg_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] mnrHngrDtlOffrDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_dtl_offr_desc", length));
			String[] mnrDispSelFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_flg_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrHngrFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_flg_yd_cd", length));
			String[] mnrFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_flg_yd_cd", length));
			String[] mvmtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cd", length));
			String[] tmpMnrDispHngrQty = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_disp_hngr_qty", length));
			String[] actInvtQty = (JSPUtil.getParameter(request, prefix	+ "act_invt_qty", length));
			String[] tmpMnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "tmp_mnr_hngr_bar_tp_cd", length));
			String[] mnrDmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_dmg_flg_dt", length));
			String[] mnrRprFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_rpr_flg", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] mnrHngrTrfCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrEqStsVO();
				if (mnrScrpFlg[i] != null)
					model.setMnrScrpFlg(mnrScrpFlg[i]);
				if (mnrDonaFlgDt[i] != null)
					model.setMnrDonaFlgDt(mnrDonaFlgDt[i]);
				if (mnrDmgFlgYdCd[i] != null)
					model.setMnrDmgFlgYdCd(mnrDmgFlgYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrDispSelTpCd[i] != null)
					model.setMnrDispSelTpCd(mnrDispSelTpCd[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (mnrFlgInpDt[i] != null)
					model.setMnrFlgInpDt(mnrFlgInpDt[i]);
				if (mnrHngrBarTpCd[i] != null)
					model.setMnrHngrBarTpCd(mnrHngrBarTpCd[i]);
				if (pLocTp[i] != null)
					model.setPLocTp(pLocTp[i]);
				if (mnrLostHngrQty[i] != null)
					model.setMnrLostHngrQty(mnrLostHngrQty[i]);
				if (mnrDispSelFlg[i] != null)
					model.setMnrDispSelFlg(mnrDispSelFlg[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (utPrice[i] != null)
					model.setUtPrice(utPrice[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrDispSelFlgYdCd[i] != null)
					model.setMnrDispSelFlgYdCd(mnrDispSelFlgYdCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (mnrFlgTpCd[i] != null)
					model.setMnrFlgTpCd(mnrFlgTpCd[i]);
				if (eqMdlNm[i] != null)
					model.setEqMdlNm(eqMdlNm[i]);
				if (mnrDispFlgDt[i] != null)
					model.setMnrDispFlgDt(mnrDispFlgDt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mnrHngrFlg[i] != null)
					model.setMnrHngrFlg(mnrHngrFlg[i]);
				if (tmpMnrHngrTrfCd[i] != null)
					model.setTmpMnrHngrTrfCd(tmpMnrHngrTrfCd[i]);
				if (mnrHngrDmgQty[i] != null)
					model.setMnrHngrDmgQty(mnrHngrDmgQty[i]);
				if (mnrFlgCmplDt[i] != null)
					model.setMnrFlgCmplDt(mnrFlgCmplDt[i]);
				if (mnrFlgRmk[i] != null)
					model.setMnrFlgRmk(mnrFlgRmk[i]);
				if (mtrlCd[i] != null)
					model.setMtrlCd(mtrlCd[i]);
				if (rprCostAmt[i] != null)
					model.setRprCostAmt(rprCostAmt[i]);
				if (manuDt[i] != null)
					model.setManuDt(manuDt[i]);
				if (barIfChk[i] != null)
					model.setBarIfChk(barIfChk[i]);
				if (tmpMnrStsRmk[i] != null)
					model.setTmpMnrStsRmk(tmpMnrStsRmk[i]);
				if (pLocCd[i] != null)
					model.setPLocCd(pLocCd[i]);
				if (mnrTariffType[i] != null)
					model.setMnrTariffType(mnrTariffType[i]);
				if (hngrBarAmdQty[i] != null)
					model.setHngrBarAmdQty(hngrBarAmdQty[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (mnrDmgFlgDtOverDay[i] != null)
					model.setMnrDmgFlgDtOverDay(mnrDmgFlgDtOverDay[i]);
				if (tmpMnrHngrRckCd[i] != null)
					model.setTmpMnrHngrRckCd(tmpMnrHngrRckCd[i]);
				if (mnrFlgInpTpCd[i] != null)
					model.setMnrFlgInpTpCd(mnrFlgInpTpCd[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (mnrDonaFlgYdCd[i] != null)
					model.setMnrDonaFlgYdCd(mnrDonaFlgYdCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mnrDmgFlg[i] != null)
					model.setMnrDmgFlg(mnrDmgFlg[i]);
				if (tmpMnrHngrTrfOtrDesc[i] != null)
					model.setTmpMnrHngrTrfOtrDesc(tmpMnrHngrTrfOtrDesc[i]);
				if (recentHngrBarAtchKnt[i] != null)
					model.setRecentHngrBarAtchKnt(recentHngrBarAtchKnt[i]);
				if (mnrHngrRckCd[i] != null)
					model.setMnrHngrRckCd(mnrHngrRckCd[i]);
				if (mnrTtlLssFlgYdCd[i] != null)
					model.setMnrTtlLssFlgYdCd(mnrTtlLssFlgYdCd[i]);
				if (dispStsNm[i] != null)
					model.setDispStsNm(dispStsNm[i]);
				if (mnrStsFlg[i] != null)
					model.setMnrStsFlg(mnrStsFlg[i]);
				if (mnrTtlLssFlg[i] != null)
					model.setMnrTtlLssFlg(mnrTtlLssFlg[i]);
				if (tmpActInvtQty[i] != null)
					model.setTmpActInvtQty(tmpActInvtQty[i]);
				if (mnrDonaFlg[i] != null)
					model.setMnrDonaFlg(mnrDonaFlg[i]);
				if (mnrHngrTrfOtrDesc[i] != null)
					model.setMnrHngrTrfOtrDesc(mnrHngrTrfOtrDesc[i]);
				if (mtrlNm[i] != null)
					model.setMtrlNm(mtrlNm[i]);
				if (mnrTtlLssFlgDt[i] != null)
					model.setMnrTtlLssFlgDt(mnrTtlLssFlgDt[i]);
				if (hngrBarTtlQty[i] != null)
					model.setHngrBarTtlQty(hngrBarTtlQty[i]);
				if (sdaysDt[i] != null)
					model.setSdaysDt(sdaysDt[i]);
				if (mstDmgFlag[i] != null)
					model.setMstDmgFlag(mstDmgFlag[i]);
				if (tmpMnrLostHngrQty[i] != null)
					model.setTmpMnrLostHngrQty(tmpMnrLostHngrQty[i]);
				if (eqMvmtIdNo[i] != null)
					model.setEqMvmtIdNo(eqMvmtIdNo[i]);
				if (mnrDispHngrQty[i] != null)
					model.setMnrDispHngrQty(mnrDispHngrQty[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (mnrDispFlg[i] != null)
					model.setMnrDispFlg(mnrDispFlg[i]);
				if (hngrBarAtchKnt[i] != null)
					model.setHngrBarAtchKnt(hngrBarAtchKnt[i]);
				if (mnrOrgHngrBarTpCd[i] != null)
					model.setMnrOrgHngrBarTpCd(mnrOrgHngrBarTpCd[i]);
				if (mnrDispFlgYdCd[i] != null)
					model.setMnrDispFlgYdCd(mnrDispFlgYdCd[i]);
				if (mnrHngrFlgDt[i] != null)
					model.setMnrHngrFlgDt(mnrHngrFlgDt[i]);
				if (mnrScrpFlgDt[i] != null)
					model.setMnrScrpFlgDt(mnrScrpFlgDt[i]);
				if (dvValue[i] != null)
					model.setDvValue(dvValue[i]);
				if (tmpMnrHngrDmgQty[i] != null)
					model.setTmpMnrHngrDmgQty(tmpMnrHngrDmgQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrFlgSeq[i] != null)
					model.setMnrFlgSeq(mnrFlgSeq[i]);
				if (eqMvmtYr[i] != null)
					model.setEqMvmtYr(eqMvmtYr[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (eqMkrNm[i] != null)
					model.setEqMkrNm(eqMkrNm[i]);
				if (mnrScrpFlgYdCd[i] != null)
					model.setMnrScrpFlgYdCd(mnrScrpFlgYdCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (verifyResult[i] != null)
					model.setVerifyResult(verifyResult[i]);
				if (mnrStsRmk[i] != null)
					model.setMnrStsRmk(mnrStsRmk[i]);
				if (mnrRprFlgDt[i] != null)
					model.setMnrRprFlgDt(mnrRprFlgDt[i]);
				if (mnrRprFlgYdCd[i] != null)
					model.setMnrRprFlgYdCd(mnrRprFlgYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (mnrHngrDtlOffrDesc[i] != null)
					model.setMnrHngrDtlOffrDesc(mnrHngrDtlOffrDesc[i]);
				if (mnrDispSelFlgDt[i] != null)
					model.setMnrDispSelFlgDt(mnrDispSelFlgDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrHngrFlgYdCd[i] != null)
					model.setMnrHngrFlgYdCd(mnrHngrFlgYdCd[i]);
				if (mnrFlgYdCd[i] != null)
					model.setMnrFlgYdCd(mnrFlgYdCd[i]);
				if (mvmtCd[i] != null)
					model.setMvmtCd(mvmtCd[i]);
				if (tmpMnrDispHngrQty[i] != null)
					model.setTmpMnrDispHngrQty(tmpMnrDispHngrQty[i]);
				if (actInvtQty[i] != null)
					model.setActInvtQty(actInvtQty[i]);
				if (tmpMnrHngrBarTpCd[i] != null)
					model.setTmpMnrHngrBarTpCd(tmpMnrHngrBarTpCd[i]);
				if (mnrDmgFlgDt[i] != null)
					model.setMnrDmgFlgDt(mnrDmgFlgDt[i]);
				if (mnrRprFlg[i] != null)
					model.setMnrRprFlg(mnrRprFlg[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (mnrHngrTrfCd[i] != null)
					model.setMnrHngrTrfCd(mnrHngrTrfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrEqStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrEqStsVO[]
	 */
	public CustomMnrEqStsVO[] getCustomMnrEqStsVOs(){
		CustomMnrEqStsVO[] vos = (CustomMnrEqStsVO[])models.toArray(new CustomMnrEqStsVO[models.size()]);
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
		this.mnrScrpFlg = this.mnrScrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDonaFlgDt = this.mnrDonaFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDmgFlgYdCd = this.mnrDmgFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelTpCd = this.mnrDispSelTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgInpDt = this.mnrFlgInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd = this.mnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocTp = this.pLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLostHngrQty = this.mnrLostHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelFlg = this.mnrDispSelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.utPrice = this.utPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelFlgYdCd = this.mnrDispSelFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgTpCd = this.mnrFlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMdlNm = this.eqMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispFlgDt = this.mnrDispFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlg = this.mnrHngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrHngrTrfCd = this.tmpMnrHngrTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDmgQty = this.mnrHngrDmgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgCmplDt = this.mnrFlgCmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgRmk = this.mnrFlgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCd = this.mtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprCostAmt = this.rprCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuDt = this.manuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barIfChk = this.barIfChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrStsRmk = this.tmpMnrStsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd = this.pLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTariffType = this.mnrTariffType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarAmdQty = this.hngrBarAmdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDmgFlgDtOverDay = this.mnrDmgFlgDtOverDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrHngrRckCd = this.tmpMnrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgInpTpCd = this.mnrFlgInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDonaFlgYdCd = this.mnrDonaFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDmgFlg = this.mnrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrHngrTrfOtrDesc = this.tmpMnrHngrTrfOtrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentHngrBarAtchKnt = this.recentHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrRckCd = this.mnrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTtlLssFlgYdCd = this.mnrTtlLssFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsNm = this.dispStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsFlg = this.mnrStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTtlLssFlg = this.mnrTtlLssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpActInvtQty = this.tmpActInvtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDonaFlg = this.mnrDonaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfOtrDesc = this.mnrHngrTrfOtrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlNm = this.mtrlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTtlLssFlgDt = this.mnrTtlLssFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarTtlQty = this.hngrBarTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdaysDt = this.sdaysDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstDmgFlag = this.mstDmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrLostHngrQty = this.tmpMnrLostHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMvmtIdNo = this.eqMvmtIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispHngrQty = this.mnrDispHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispFlg = this.mnrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrBarAtchKnt = this.hngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrgHngrBarTpCd = this.mnrOrgHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispFlgYdCd = this.mnrDispFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlgDt = this.mnrHngrFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrScrpFlgDt = this.mnrScrpFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue = this.dvValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrHngrDmgQty = this.tmpMnrHngrDmgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgSeq = this.mnrFlgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMvmtYr = this.eqMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMkrNm = this.eqMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrScrpFlgYdCd = this.mnrScrpFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verifyResult = this.verifyResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsRmk = this.mnrStsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRprFlgDt = this.mnrRprFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRprFlgYdCd = this.mnrRprFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDtlOffrDesc = this.mnrHngrDtlOffrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelFlgDt = this.mnrDispSelFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlgYdCd = this.mnrHngrFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrFlgYdCd = this.mnrFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd = this.mvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrDispHngrQty = this.tmpMnrDispHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvtQty = this.actInvtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpMnrHngrBarTpCd = this.tmpMnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDmgFlgDt = this.mnrDmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRprFlg = this.mnrRprFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfCd = this.mnrHngrTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
