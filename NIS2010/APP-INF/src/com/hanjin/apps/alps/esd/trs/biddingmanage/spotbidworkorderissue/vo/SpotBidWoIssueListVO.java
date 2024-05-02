package com.hanjin.apps.alps.esd.trs.biddingmanage.spotbidworkorderissue.vo;

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

public class SpotBidWoIssueListVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<SpotBidWoIssueListVO> models = new ArrayList<SpotBidWoIssueListVO>();
	private String ibVvdCd = null;
	private String n3ptyBzcTpCd = null;
	private String troCfmUpdTm = null;
	private String cgoTpCd = null;
	private String poLocalCurrTotAmt = null;
	private String poVatScgRt = null;
	private String orgCurrCd = null;
	private String poScg1Rt = null;
	private String trspAgmtRtTpNm = null;
	private String lnkDistDivCd = null;
	private String pagerows = null;
	private String n3ptyBzcCustSeq = null;
	private String dorPstCd = null;
	private String poFuelScgRt = null;
	private String tVvd = null;
	private String trspFrstFlg = null;
	private String trspSoTpNm = null;
	private String poUsdCurrTotAmt = null;
	private String tollFeeAmt = null;
	private String custCntCd = null;
	private String poCustNomiTrkrFlg = null;
	private String cgoTpNm = null;
	private String cntFlg = null;
	private String cntrWgt = null;
	private String trspSoCmbTpCd = null;
	private String mtyRrFlg = null;
	private String troCfmUsrId = null;
	private String trspCostDtlModNm = null;
	private String poBasicRt = null;
	private String woRjctDt = null;
	private String actCustCd = null;
	private String eqTpszCd = null;
	private String poWtrRcvTermCd = null;
	private String woTotAmt = null;
	private String negoAmt = null;
	private String bkgNo = null;
	private String n3ptyBzcDesc = null;
	private String fctryNm = null;
	private String bundlingFlg = null;
	private String cancelCheck = null;
	private String poAgmtUpdDt = null;
	private String distance = null;
	private String interRmk = null;
	private String cmdtCd = null;
	private String bkgQty = null;
	private String n3ptyBzcCustCntCd = null;
	private String poTrspAgmtRtTpNm = null;
	private String agmtMorCnddtAplyFlg = null;
	private String dorNodCd = null;
	private String fmYardValue = null;
	private String fmLocValue = null;
	private String trspCrrModCd = null;
	private String viaYardValue = null;
	private String poWtrDeTermCd = null;
	private String shprCustNm = null;
	private String deliTimeHms = null;
	private String trspAgmtWyTpCd = null;
	private String trspRjctRsnCd = null;
	private String lstNodPlnDt = null;
	private String poOverWgtScgRt = null;
	private String mcntrBdlGrpSeq = null;
	private String eqKndCd = null;
	private String bzcAmt = null;
	private String trspWoOfcCtyCd = null;
	private String fuelScgAmt = null;
	private String n3ptyBzcOfcCd = null;
	private String fmNodCd = null;
	private String custCntCdSeq = null;
	private String n3ptyBilFlg = null;
	private String toLocValue = null;
	private String distanceUom = null;
	private String woCreNm = null;
	private String viaLocValue = null;
	private String cneeCustNm = null;
	private String costActGrpSeq = null;
	private String woRjctIndct = null;
	private String n1stNodPlnDt = null;
	private String viaNodCd = null;
	private String n3ptyBzcAmt = null;
	private String n1stNodPlnTm = null;
	private String cntrKgsWgt = null;
	private String ttlDist = null;
	private String toNodCd = null;
	private String ovwtTriAxlFlg = null;
	private String troCnfm = null;
	private String dtnUseFlg = null;
	private String trspCrrModNm = null;
	private String bundlingNo = null;
	private String n3ptyBzcVndrSeq = null;
	private String trspSoSeq = null;
	private String dorDeAddr = null;
	private String copNo = null;
	private String woIssueDt = null;
	private String soCreNm = null;
	private String lstNodPlnTm = null;
	private String poTrspAgmtSeq = null;
	private String blNo = null;
	private String spclCgoCntrTpCd = null;
	private String trspAgmtRtTpCd = null;
	private String poScg2Rt = null;
	private String vndrNm = null;
	private String ctrtNo = null;
	private String hzdMtrlFlg = null;
	private String cntcPsonFaxNo = null;
	private String poTrspAgmtRtTpCd = null;
	private String dorNodPlnDt = null;
	private String trspCostDtlModCd = null;
	private String poTrspAgmtOfcCtyCd = null;
	private String mltStopDeFlg = null;
	private String scNo = null;
	private String wgtUtCd = null;
	private String trspSoCmbTpNm = null;
	private String woBlNoIssFlg = null;
	private String trspSoTpCd = null;
	private String revCurrCd = null;
	private String woRmk = null;
	private String defaultSpFlg = null;
	private String trspWoSeq = null;
	private String trspDfltVndrFlg = null;
	private String surchargeKey = null;
	private String fdrVvd = null;
	private String poCustSeq = null;
	private String cntcPsonPhnNo = null;
	private String soCreDt = null;
	private String cntrLbsWgt = null;
	private String poSpType = null;
	private String bkgspe = null;
	private String deliTimeDt = null;
	private String costActGrpCd = null;
	private String vndrSeq = null;
	private String wgtMeasUtCd = null;
	private String trspSoOfcCtyCdSeq = null;
	private String troCfmOfcCd = null;
	private String poCfmFlg = null;
	private String contiCd = null;
	private String ctrtCnt = null;
	private String currCd = null;
	private String poRtnMsg = null;
	private String toYardValue = null;
	private String creDt = null;
	private String refId = null;
	private String mcntrBdlSeq = null;
	private String trspRqstBkgFlg = null;
	private String trspSoOfcCtyCd = null;
	private String lane = null;
	private String n3ptyBzcCurrCd = null;
	private String rfaNo = null;
	private String poCustCntCd = null;
	private String ibflag = null;
	private String eqNo = null;
	private String poCustCntCdSeq = null;
	private String woEdiUseFlg = null;
	private String dorYardValue = null;
	private String creOfcCd = null;
	private String cntcPsonNm = null;
	private String poAgmtRtSeq = null;
	private String moreCandidates = null;
	private String spclInstrRmk = null;
	private String presetVndrSeq = null;
	private String revenue = null;
	private String etcAddAmt = null;
	private String appoTimeHms = null;
	private String woTotAmtUsd = null;
	private String trspBndCd = null;
	private String poWayType = null;
	private String troSeq = null;
	private String dorNodPlnTm = null;
	private String custSeq = null;
	private String spType = null;
	private String orgNegoAmt = null;
	private String troCfmUpdDt = null;
	private String bkgTroNo = null;
	private String poRtnCd = null;
	private String poScg3Rt = null;
	private String rejectedCheck = null;
	private String appoTimeDt = null;
	private String obVvdCd = null;
	private String poLocalCurrCd = null;
	private String dorLocValue = null;
	private String ntfyCustNm = null;
	private String trspWoOfcCtyCdSeq = null;
	private String trspSoCmbSeq = null;
	private String custNomiTrkrFlg = null;
	private String spotBidVndrCnt = null;
	private String spotBidVndrInfo = null;
	private String spotBidDueDt = null;
	private String spotBidNo = null;
	/* Pair Member */
	private String spotBidWinUsdAmt = null;
	private String spotBidWinAmt = null;
	private String spotBidWinCurrCd = null;
	private String spotBidWinVndrNm = null;
	private String spotBidWinVndrSeq = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SpotBidWoIssueListVO() {}

	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("n3pty_bzc_tp_cd", getN3ptyBzcTpCd());
		this.hashColumns.put("tro_cfm_upd_tm", getTroCfmUpdTm());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("po_local_curr_tot_amt", getPoLocalCurrTotAmt());
		this.hashColumns.put("po_vat_scg_rt", getPoVatScgRt());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("po_scg1_rt", getPoScg1Rt());
		this.hashColumns.put("trsp_agmt_rt_tp_nm", getTrspAgmtRtTpNm());
		this.hashColumns.put("lnk_dist_div_cd", getLnkDistDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_bzc_cust_seq", getN3ptyBzcCustSeq());
		this.hashColumns.put("dor_pst_cd", getDorPstCd());
		this.hashColumns.put("po_fuel_scg_rt", getPoFuelScgRt());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		this.hashColumns.put("trsp_so_tp_nm", getTrspSoTpNm());
		this.hashColumns.put("po_usd_curr_tot_amt", getPoUsdCurrTotAmt());
		this.hashColumns.put("toll_fee_amt", getTollFeeAmt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("po_cust_nomi_trkr_flg", getPoCustNomiTrkrFlg());
		this.hashColumns.put("cgo_tp_nm", getCgoTpNm());
		this.hashColumns.put("cnt_flg", getCntFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("mty_rr_flg", getMtyRrFlg());
		this.hashColumns.put("tro_cfm_usr_id", getTroCfmUsrId());
		this.hashColumns.put("trsp_cost_dtl_mod_nm", getTrspCostDtlModNm());
		this.hashColumns.put("po_basic_rt", getPoBasicRt());
		this.hashColumns.put("wo_rjct_dt", getWoRjctDt());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("po_wtr_rcv_term_cd", getPoWtrRcvTermCd());
		this.hashColumns.put("wo_tot_amt", getWoTotAmt());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("n3pty_bzc_desc", getN3ptyBzcDesc());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("bundling_flg", getBundlingFlg());
		this.hashColumns.put("cancel_check", getCancelCheck());
		this.hashColumns.put("po_agmt_upd_dt", getPoAgmtUpdDt());
		this.hashColumns.put("distance", getDistance());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("n3pty_bzc_cust_cnt_cd", getN3ptyBzcCustCntCd());
		this.hashColumns.put("po_trsp_agmt_rt_tp_nm", getPoTrspAgmtRtTpNm());
		this.hashColumns.put("agmt_mor_cnddt_aply_flg", getAgmtMorCnddtAplyFlg());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("fm_yard_value", getFmYardValue());
		this.hashColumns.put("fm_loc_value", getFmLocValue());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("via_yard_value", getViaYardValue());
		this.hashColumns.put("po_wtr_de_term_cd", getPoWtrDeTermCd());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("deli_time_hms", getDeliTimeHms());
		this.hashColumns.put("trsp_agmt_wy_tp_cd", getTrspAgmtWyTpCd());
		this.hashColumns.put("trsp_rjct_rsn_cd", getTrspRjctRsnCd());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("po_over_wgt_scg_rt", getPoOverWgtScgRt());
		this.hashColumns.put("mcntr_bdl_grp_seq", getMcntrBdlGrpSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("n3pty_bzc_ofc_cd", getN3ptyBzcOfcCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("cust_cnt_cd_seq", getCustCntCdSeq());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("to_loc_value", getToLocValue());
		this.hashColumns.put("distance_uom", getDistanceUom());
		this.hashColumns.put("wo_cre_nm", getWoCreNm());
		this.hashColumns.put("via_loc_value", getViaLocValue());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("wo_rjct_indct", getWoRjctIndct());
		this.hashColumns.put("n1st_nod_pln_dt", getN1stNodPlnDt());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("n3pty_bzc_amt", getN3ptyBzcAmt());
		this.hashColumns.put("n1st_nod_pln_tm", getN1stNodPlnTm());
		this.hashColumns.put("cntr_kgs_wgt", getCntrKgsWgt());
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("ovwt_tri_axl_flg", getOvwtTriAxlFlg());
		this.hashColumns.put("tro_cnfm", getTroCnfm());
		this.hashColumns.put("dtn_use_flg", getDtnUseFlg());
		this.hashColumns.put("trsp_crr_mod_nm", getTrspCrrModNm());
		this.hashColumns.put("bundling_no", getBundlingNo());
		this.hashColumns.put("n3pty_bzc_vndr_seq", getN3ptyBzcVndrSeq());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("dor_de_addr", getDorDeAddr());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("wo_issue_dt", getWoIssueDt());
		this.hashColumns.put("so_cre_nm", getSoCreNm());
		this.hashColumns.put("lst_nod_pln_tm", getLstNodPlnTm());
		this.hashColumns.put("po_trsp_agmt_seq", getPoTrspAgmtSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("po_scg2_rt", getPoScg2Rt());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("hzd_mtrl_flg", getHzdMtrlFlg());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("po_trsp_agmt_rt_tp_cd", getPoTrspAgmtRtTpCd());
		this.hashColumns.put("dor_nod_pln_dt", getDorNodPlnDt());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("po_trsp_agmt_ofc_cty_cd", getPoTrspAgmtOfcCtyCd());
		this.hashColumns.put("mlt_stop_de_flg", getMltStopDeFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("trsp_so_cmb_tp_nm", getTrspSoCmbTpNm());
		this.hashColumns.put("wo_bl_no_iss_flg", getWoBlNoIssFlg());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("rev_curr_cd", getRevCurrCd());
		this.hashColumns.put("wo_rmk", getWoRmk());
		this.hashColumns.put("default_sp_flg", getDefaultSpFlg());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trsp_dflt_vndr_flg", getTrspDfltVndrFlg());
		this.hashColumns.put("surcharge_key", getSurchargeKey());
		this.hashColumns.put("fdr_vvd", getFdrVvd());
		this.hashColumns.put("po_cust_seq", getPoCustSeq());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("cntr_lbs_wgt", getCntrLbsWgt());
		this.hashColumns.put("po_sp_type", getPoSpType());
		this.hashColumns.put("bkgspe", getBkgspe());
		this.hashColumns.put("deli_time_dt", getDeliTimeDt());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("tro_cfm_ofc_cd", getTroCfmOfcCd());
		this.hashColumns.put("po_cfm_flg", getPoCfmFlg());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("ctrt_cnt", getCtrtCnt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("po_rtn_msg", getPoRtnMsg());
		this.hashColumns.put("to_yard_value", getToYardValue());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("mcntr_bdl_seq", getMcntrBdlSeq());
		this.hashColumns.put("trsp_rqst_bkg_flg", getTrspRqstBkgFlg());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("n3pty_bzc_curr_cd", getN3ptyBzcCurrCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("po_cust_cnt_cd", getPoCustCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("po_cust_cnt_cd_seq", getPoCustCntCdSeq());
		this.hashColumns.put("wo_edi_use_flg", getWoEdiUseFlg());
		this.hashColumns.put("dor_yard_value", getDorYardValue());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("po_agmt_rt_seq", getPoAgmtRtSeq());
		this.hashColumns.put("more_candidates", getMoreCandidates());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("preset_vndr_seq", getPresetVndrSeq());
		this.hashColumns.put("revenue", getRevenue());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("appo_time_hms", getAppoTimeHms());
		this.hashColumns.put("wo_tot_amt_usd", getWoTotAmtUsd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("po_way_type", getPoWayType());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("dor_nod_pln_tm", getDorNodPlnTm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sp_type", getSpType());
		this.hashColumns.put("org_nego_amt", getOrgNegoAmt());
		this.hashColumns.put("tro_cfm_upd_dt", getTroCfmUpdDt());
		this.hashColumns.put("bkg_tro_no", getBkgTroNo());
		this.hashColumns.put("po_rtn_cd", getPoRtnCd());
		this.hashColumns.put("po_scg3_rt", getPoScg3Rt());
		this.hashColumns.put("rejected_check", getRejectedCheck());
		this.hashColumns.put("appo_time_dt", getAppoTimeDt());
		this.hashColumns.put("ob_vvd_cd", getObVvdCd());
		this.hashColumns.put("po_local_curr_cd", getPoLocalCurrCd());
		this.hashColumns.put("dor_loc_value", getDorLocValue());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("trsp_wo_ofc_cty_cd_seq", getTrspWoOfcCtyCdSeq());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		this.hashColumns.put("spot_bid_vndr_cnt", getSpotBidVndrCnt());
		this.hashColumns.put("spot_bid_vndr_info", getSpotBidVndrInfo());
		this.hashColumns.put("spot_bid_due_dt", getSpotBidDueDt());
		this.hashColumns.put("spot_bid_no", getSpotBidNo());
		this.hashColumns.put("spot_bid_win_usd_amt", getSpotBidWinUsdAmt());
		this.hashColumns.put("spot_bid_win_amt", getSpotBidWinAmt());
		this.hashColumns.put("spot_bid_win_curr_cd", getSpotBidWinCurrCd());
		this.hashColumns.put("spot_bid_win_vndr_nm", getSpotBidWinVndrNm());
		this.hashColumns.put("spot_bid_win_vndr_seq", getSpotBidWinVndrSeq());
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("n3pty_bzc_tp_cd", "n3ptyBzcTpCd");
		this.hashFields.put("tro_cfm_upd_tm", "troCfmUpdTm");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("po_local_curr_tot_amt", "poLocalCurrTotAmt");
		this.hashFields.put("po_vat_scg_rt", "poVatScgRt");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("po_scg1_rt", "poScg1Rt");
		this.hashFields.put("trsp_agmt_rt_tp_nm", "trspAgmtRtTpNm");
		this.hashFields.put("lnk_dist_div_cd", "lnkDistDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_bzc_cust_seq", "n3ptyBzcCustSeq");
		this.hashFields.put("dor_pst_cd", "dorPstCd");
		this.hashFields.put("po_fuel_scg_rt", "poFuelScgRt");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		this.hashFields.put("trsp_so_tp_nm", "trspSoTpNm");
		this.hashFields.put("po_usd_curr_tot_amt", "poUsdCurrTotAmt");
		this.hashFields.put("toll_fee_amt", "tollFeeAmt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("po_cust_nomi_trkr_flg", "poCustNomiTrkrFlg");
		this.hashFields.put("cgo_tp_nm", "cgoTpNm");
		this.hashFields.put("cnt_flg", "cntFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("mty_rr_flg", "mtyRrFlg");
		this.hashFields.put("tro_cfm_usr_id", "troCfmUsrId");
		this.hashFields.put("trsp_cost_dtl_mod_nm", "trspCostDtlModNm");
		this.hashFields.put("po_basic_rt", "poBasicRt");
		this.hashFields.put("wo_rjct_dt", "woRjctDt");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("po_wtr_rcv_term_cd", "poWtrRcvTermCd");
		this.hashFields.put("wo_tot_amt", "woTotAmt");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("n3pty_bzc_desc", "n3ptyBzcDesc");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("bundling_flg", "bundlingFlg");
		this.hashFields.put("cancel_check", "cancelCheck");
		this.hashFields.put("po_agmt_upd_dt", "poAgmtUpdDt");
		this.hashFields.put("distance", "distance");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("n3pty_bzc_cust_cnt_cd", "n3ptyBzcCustCntCd");
		this.hashFields.put("po_trsp_agmt_rt_tp_nm", "poTrspAgmtRtTpNm");
		this.hashFields.put("agmt_mor_cnddt_aply_flg", "agmtMorCnddtAplyFlg");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("fm_yard_value", "fmYardValue");
		this.hashFields.put("fm_loc_value", "fmLocValue");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("via_yard_value", "viaYardValue");
		this.hashFields.put("po_wtr_de_term_cd", "poWtrDeTermCd");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("deli_time_hms", "deliTimeHms");
		this.hashFields.put("trsp_agmt_wy_tp_cd", "trspAgmtWyTpCd");
		this.hashFields.put("trsp_rjct_rsn_cd", "trspRjctRsnCd");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("po_over_wgt_scg_rt", "poOverWgtScgRt");
		this.hashFields.put("mcntr_bdl_grp_seq", "mcntrBdlGrpSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("n3pty_bzc_ofc_cd", "n3ptyBzcOfcCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("cust_cnt_cd_seq", "custCntCdSeq");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("to_loc_value", "toLocValue");
		this.hashFields.put("distance_uom", "distanceUom");
		this.hashFields.put("wo_cre_nm", "woCreNm");
		this.hashFields.put("via_loc_value", "viaLocValue");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("wo_rjct_indct", "woRjctIndct");
		this.hashFields.put("n1st_nod_pln_dt", "n1stNodPlnDt");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("n3pty_bzc_amt", "n3ptyBzcAmt");
		this.hashFields.put("n1st_nod_pln_tm", "n1stNodPlnTm");
		this.hashFields.put("cntr_kgs_wgt", "cntrKgsWgt");
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("ovwt_tri_axl_flg", "ovwtTriAxlFlg");
		this.hashFields.put("tro_cnfm", "troCnfm");
		this.hashFields.put("dtn_use_flg", "dtnUseFlg");
		this.hashFields.put("trsp_crr_mod_nm", "trspCrrModNm");
		this.hashFields.put("bundling_no", "bundlingNo");
		this.hashFields.put("n3pty_bzc_vndr_seq", "n3ptyBzcVndrSeq");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("dor_de_addr", "dorDeAddr");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("wo_issue_dt", "woIssueDt");
		this.hashFields.put("so_cre_nm", "soCreNm");
		this.hashFields.put("lst_nod_pln_tm", "lstNodPlnTm");
		this.hashFields.put("po_trsp_agmt_seq", "poTrspAgmtSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("po_scg2_rt", "poScg2Rt");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("hzd_mtrl_flg", "hzdMtrlFlg");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("po_trsp_agmt_rt_tp_cd", "poTrspAgmtRtTpCd");
		this.hashFields.put("dor_nod_pln_dt", "dorNodPlnDt");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("po_trsp_agmt_ofc_cty_cd", "poTrspAgmtOfcCtyCd");
		this.hashFields.put("mlt_stop_de_flg", "mltStopDeFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("trsp_so_cmb_tp_nm", "trspSoCmbTpNm");
		this.hashFields.put("wo_bl_no_iss_flg", "woBlNoIssFlg");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("rev_curr_cd", "revCurrCd");
		this.hashFields.put("wo_rmk", "woRmk");
		this.hashFields.put("default_sp_flg", "defaultSpFlg");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trsp_dflt_vndr_flg", "trspDfltVndrFlg");
		this.hashFields.put("surcharge_key", "surchargeKey");
		this.hashFields.put("fdr_vvd", "fdrVvd");
		this.hashFields.put("po_cust_seq", "poCustSeq");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("cntr_lbs_wgt", "cntrLbsWgt");
		this.hashFields.put("po_sp_type", "poSpType");
		this.hashFields.put("bkgspe", "bkgspe");
		this.hashFields.put("deli_time_dt", "deliTimeDt");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("tro_cfm_ofc_cd", "troCfmOfcCd");
		this.hashFields.put("po_cfm_flg", "poCfmFlg");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("ctrt_cnt", "ctrtCnt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("po_rtn_msg", "poRtnMsg");
		this.hashFields.put("to_yard_value", "toYardValue");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("mcntr_bdl_seq", "mcntrBdlSeq");
		this.hashFields.put("trsp_rqst_bkg_flg", "trspRqstBkgFlg");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("n3pty_bzc_curr_cd", "n3ptyBzcCurrCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("po_cust_cnt_cd", "poCustCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("po_cust_cnt_cd_seq", "poCustCntCdSeq");
		this.hashFields.put("wo_edi_use_flg", "woEdiUseFlg");
		this.hashFields.put("dor_yard_value", "dorYardValue");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("po_agmt_rt_seq", "poAgmtRtSeq");
		this.hashFields.put("more_candidates", "moreCandidates");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("preset_vndr_seq", "presetVndrSeq");
		this.hashFields.put("revenue", "revenue");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("appo_time_hms", "appoTimeHms");
		this.hashFields.put("wo_tot_amt_usd", "woTotAmtUsd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("po_way_type", "poWayType");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("dor_nod_pln_tm", "dorNodPlnTm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sp_type", "spType");
		this.hashFields.put("org_nego_amt", "orgNegoAmt");
		this.hashFields.put("tro_cfm_upd_dt", "troCfmUpdDt");
		this.hashFields.put("bkg_tro_no", "bkgTroNo");
		this.hashFields.put("po_rtn_cd", "poRtnCd");
		this.hashFields.put("po_scg3_rt", "poScg3Rt");
		this.hashFields.put("rejected_check", "rejectedCheck");
		this.hashFields.put("appo_time_dt", "appoTimeDt");
		this.hashFields.put("ob_vvd_cd", "obVvdCd");
		this.hashFields.put("po_local_curr_cd", "poLocalCurrCd");
		this.hashFields.put("dor_loc_value", "dorLocValue");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("trsp_wo_ofc_cty_cd_seq", "trspWoOfcCtyCdSeq");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
		this.hashFields.put("spot_bid_vndr_cnt", "spotBidVndrCnt");
		this.hashFields.put("spot_bid_vndr_info", "spotBidVndrInfo");
		this.hashFields.put("spot_bid_due_dt", "spotBidDueDt");
		this.hashFields.put("spot_bid_no", "spotBidNo");
		this.hashFields.put("spot_bid_win_usd_amt", "spotBidWinUsdAmt");
		this.hashFields.put("spot_bid_win_amt", "spotBidWinAmt");
		this.hashFields.put("spot_bid_win_curr_cd", "spotBidWinCurrCd");
		this.hashFields.put("spot_bid_win_vndr_nm", "spotBidWinVndrNm");
		this.hashFields.put("spot_bid_win_vndr_seq", "spotBidWinVndrSeq");
		return this.hashFields;
	}
	public String getIbVvdCd() {
		return this.ibVvdCd;
	}

	public String getN3ptyBzcTpCd() {
		return this.n3ptyBzcTpCd;
	}

	public String getTroCfmUpdTm() {
		return this.troCfmUpdTm;
	}

	public String getCgoTpCd() {
		return this.cgoTpCd;
	}

	public String getPoLocalCurrTotAmt() {
		return this.poLocalCurrTotAmt;
	}

	public String getPoVatScgRt() {
		return this.poVatScgRt;
	}

	public String getOrgCurrCd() {
		return this.orgCurrCd;
	}

	public String getPoScg1Rt() {
		return this.poScg1Rt;
	}

	public String getTrspAgmtRtTpNm() {
		return this.trspAgmtRtTpNm;
	}

	public String getLnkDistDivCd() {
		return this.lnkDistDivCd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getN3ptyBzcCustSeq() {
		return this.n3ptyBzcCustSeq;
	}

	public String getDorPstCd() {
		return this.dorPstCd;
	}

	public String getPoFuelScgRt() {
		return this.poFuelScgRt;
	}

	public String getTVvd() {
		return this.tVvd;
	}

	public String getTrspFrstFlg() {
		return this.trspFrstFlg;
	}

	public String getTrspSoTpNm() {
		return this.trspSoTpNm;
	}

	public String getPoUsdCurrTotAmt() {
		return this.poUsdCurrTotAmt;
	}

	public String getTollFeeAmt() {
		return this.tollFeeAmt;
	}

	public String getCustCntCd() {
		return this.custCntCd;
	}

	public String getPoCustNomiTrkrFlg() {
		return this.poCustNomiTrkrFlg;
	}

	public String getCgoTpNm() {
		return this.cgoTpNm;
	}

	public String getCntFlg() {
		return this.cntFlg;
	}

	public String getCntrWgt() {
		return this.cntrWgt;
	}

	public String getTrspSoCmbTpCd() {
		return this.trspSoCmbTpCd;
	}

	public String getMtyRrFlg() {
		return this.mtyRrFlg;
	}

	public String getTroCfmUsrId() {
		return this.troCfmUsrId;
	}

	public String getTrspCostDtlModNm() {
		return this.trspCostDtlModNm;
	}

	public String getPoBasicRt() {
		return this.poBasicRt;
	}

	public String getWoRjctDt() {
		return this.woRjctDt;
	}

	public String getActCustCd() {
		return this.actCustCd;
	}

	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	public String getPoWtrRcvTermCd() {
		return this.poWtrRcvTermCd;
	}

	public String getWoTotAmt() {
		return this.woTotAmt;
	}

	public String getNegoAmt() {
		return this.negoAmt;
	}

	public String getBkgNo() {
		return this.bkgNo;
	}

	public String getN3ptyBzcDesc() {
		return this.n3ptyBzcDesc;
	}

	public String getFctryNm() {
		return this.fctryNm;
	}

	public String getBundlingFlg() {
		return this.bundlingFlg;
	}

	public String getCancelCheck() {
		return this.cancelCheck;
	}

	public String getPoAgmtUpdDt() {
		return this.poAgmtUpdDt;
	}

	public String getDistance() {
		return this.distance;
	}

	public String getInterRmk() {
		return this.interRmk;
	}

	public String getCmdtCd() {
		return this.cmdtCd;
	}

	public String getBkgQty() {
		return this.bkgQty;
	}

	public String getN3ptyBzcCustCntCd() {
		return this.n3ptyBzcCustCntCd;
	}

	public String getPoTrspAgmtRtTpNm() {
		return this.poTrspAgmtRtTpNm;
	}

	public String getAgmtMorCnddtAplyFlg() {
		return this.agmtMorCnddtAplyFlg;
	}

	public String getDorNodCd() {
		return this.dorNodCd;
	}

	public String getFmYardValue() {
		return this.fmYardValue;
	}

	public String getFmLocValue() {
		return this.fmLocValue;
	}

	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}

	public String getViaYardValue() {
		return this.viaYardValue;
	}

	public String getPoWtrDeTermCd() {
		return this.poWtrDeTermCd;
	}

	public String getShprCustNm() {
		return this.shprCustNm;
	}

	public String getDeliTimeHms() {
		return this.deliTimeHms;
	}

	public String getTrspAgmtWyTpCd() {
		return this.trspAgmtWyTpCd;
	}

	public String getTrspRjctRsnCd() {
		return this.trspRjctRsnCd;
	}

	public String getLstNodPlnDt() {
		return this.lstNodPlnDt;
	}

	public String getPoOverWgtScgRt() {
		return this.poOverWgtScgRt;
	}

	public String getMcntrBdlGrpSeq() {
		return this.mcntrBdlGrpSeq;
	}

	public String getEqKndCd() {
		return this.eqKndCd;
	}

	public String getBzcAmt() {
		return this.bzcAmt;
	}

	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}

	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}

	public String getN3ptyBzcOfcCd() {
		return this.n3ptyBzcOfcCd;
	}

	public String getFmNodCd() {
		return this.fmNodCd;
	}

	public String getCustCntCdSeq() {
		return this.custCntCdSeq;
	}

	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}

	public String getToLocValue() {
		return this.toLocValue;
	}

	public String getDistanceUom() {
		return this.distanceUom;
	}

	public String getWoCreNm() {
		return this.woCreNm;
	}

	public String getViaLocValue() {
		return this.viaLocValue;
	}

	public String getCneeCustNm() {
		return this.cneeCustNm;
	}

	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}

	public String getWoRjctIndct() {
		return this.woRjctIndct;
	}

	public String getN1stNodPlnDt() {
		return this.n1stNodPlnDt;
	}

	public String getViaNodCd() {
		return this.viaNodCd;
	}

	public String getN3ptyBzcAmt() {
		return this.n3ptyBzcAmt;
	}

	public String getN1stNodPlnTm() {
		return this.n1stNodPlnTm;
	}

	public String getCntrKgsWgt() {
		return this.cntrKgsWgt;
	}

	public String getTtlDist() {
		return this.ttlDist;
	}

	public String getToNodCd() {
		return this.toNodCd;
	}

	public String getOvwtTriAxlFlg() {
		return this.ovwtTriAxlFlg;
	}

	public String getTroCnfm() {
		return this.troCnfm;
	}

	public String getDtnUseFlg() {
		return this.dtnUseFlg;
	}

	public String getTrspCrrModNm() {
		return this.trspCrrModNm;
	}

	public String getBundlingNo() {
		return this.bundlingNo;
	}

	public String getN3ptyBzcVndrSeq() {
		return this.n3ptyBzcVndrSeq;
	}

	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}

	public String getDorDeAddr() {
		return this.dorDeAddr;
	}

	public String getCopNo() {
		return this.copNo;
	}

	public String getWoIssueDt() {
		return this.woIssueDt;
	}

	public String getSoCreNm() {
		return this.soCreNm;
	}

	public String getLstNodPlnTm() {
		return this.lstNodPlnTm;
	}

	public String getPoTrspAgmtSeq() {
		return this.poTrspAgmtSeq;
	}

	public String getBlNo() {
		return this.blNo;
	}

	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
	}

	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
	}

	public String getPoScg2Rt() {
		return this.poScg2Rt;
	}

	public String getVndrNm() {
		return this.vndrNm;
	}

	public String getCtrtNo() {
		return this.ctrtNo;
	}

	public String getHzdMtrlFlg() {
		return this.hzdMtrlFlg;
	}

	public String getCntcPsonFaxNo() {
		return this.cntcPsonFaxNo;
	}

	public String getPoTrspAgmtRtTpCd() {
		return this.poTrspAgmtRtTpCd;
	}

	public String getDorNodPlnDt() {
		return this.dorNodPlnDt;
	}

	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}

	public String getPoTrspAgmtOfcCtyCd() {
		return this.poTrspAgmtOfcCtyCd;
	}

	public String getMltStopDeFlg() {
		return this.mltStopDeFlg;
	}

	public String getScNo() {
		return this.scNo;
	}

	public String getWgtUtCd() {
		return this.wgtUtCd;
	}

	public String getTrspSoCmbTpNm() {
		return this.trspSoCmbTpNm;
	}

	public String getWoBlNoIssFlg() {
		return this.woBlNoIssFlg;
	}

	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
	}

	public String getRevCurrCd() {
		return this.revCurrCd;
	}

	public String getWoRmk() {
		return this.woRmk;
	}

	public String getDefaultSpFlg() {
		return this.defaultSpFlg;
	}

	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}

	public String getTrspDfltVndrFlg() {
		return this.trspDfltVndrFlg;
	}

	public String getSurchargeKey() {
		return this.surchargeKey;
	}

	public String getFdrVvd() {
		return this.fdrVvd;
	}

	public String getPoCustSeq() {
		return this.poCustSeq;
	}

	public String getCntcPsonPhnNo() {
		return this.cntcPsonPhnNo;
	}

	public String getSoCreDt() {
		return this.soCreDt;
	}

	public String getCntrLbsWgt() {
		return this.cntrLbsWgt;
	}

	public String getPoSpType() {
		return this.poSpType;
	}

	public String getBkgspe() {
		return this.bkgspe;
	}

	public String getDeliTimeDt() {
		return this.deliTimeDt;
	}

	public String getCostActGrpCd() {
		return this.costActGrpCd;
	}

	public String getVndrSeq() {
		return this.vndrSeq;
	}

	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}

	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}

	public String getTroCfmOfcCd() {
		return this.troCfmOfcCd;
	}

	public String getPoCfmFlg() {
		return this.poCfmFlg;
	}

	public String getContiCd() {
		return this.contiCd;
	}

	public String getCtrtCnt() {
		return this.ctrtCnt;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public String getPoRtnMsg() {
		return this.poRtnMsg;
	}

	public String getToYardValue() {
		return this.toYardValue;
	}

	public String getCreDt() {
		return this.creDt;
	}

	public String getRefId() {
		return this.refId;
	}

	public String getMcntrBdlSeq() {
		return this.mcntrBdlSeq;
	}

	public String getTrspRqstBkgFlg() {
		return this.trspRqstBkgFlg;
	}

	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}

	public String getLane() {
		return this.lane;
	}

	public String getN3ptyBzcCurrCd() {
		return this.n3ptyBzcCurrCd;
	}

	public String getRfaNo() {
		return this.rfaNo;
	}

	public String getPoCustCntCd() {
		return this.poCustCntCd;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getEqNo() {
		return this.eqNo;
	}

	public String getPoCustCntCdSeq() {
		return this.poCustCntCdSeq;
	}

	public String getWoEdiUseFlg() {
		return this.woEdiUseFlg;
	}

	public String getDorYardValue() {
		return this.dorYardValue;
	}

	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}

	public String getPoAgmtRtSeq() {
		return this.poAgmtRtSeq;
	}

	public String getMoreCandidates() {
		return this.moreCandidates;
	}

	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}

	public String getPresetVndrSeq() {
		return this.presetVndrSeq;
	}

	public String getRevenue() {
		return this.revenue;
	}

	public String getEtcAddAmt() {
		return this.etcAddAmt;
	}

	public String getAppoTimeHms() {
		return this.appoTimeHms;
	}

	public String getWoTotAmtUsd() {
		return this.woTotAmtUsd;
	}

	public String getTrspBndCd() {
		return this.trspBndCd;
	}

	public String getPoWayType() {
		return this.poWayType;
	}

	public String getTroSeq() {
		return this.troSeq;
	}

	public String getDorNodPlnTm() {
		return this.dorNodPlnTm;
	}

	public String getCustSeq() {
		return this.custSeq;
	}

	public String getSpType() {
		return this.spType;
	}

	public String getOrgNegoAmt() {
		return this.orgNegoAmt;
	}

	public String getTroCfmUpdDt() {
		return this.troCfmUpdDt;
	}

	public String getBkgTroNo() {
		return this.bkgTroNo;
	}

	public String getPoRtnCd() {
		return this.poRtnCd;
	}

	public String getPoScg3Rt() {
		return this.poScg3Rt;
	}

	public String getRejectedCheck() {
		return this.rejectedCheck;
	}

	public String getAppoTimeDt() {
		return this.appoTimeDt;
	}

	public String getObVvdCd() {
		return this.obVvdCd;
	}

	public String getPoLocalCurrCd() {
		return this.poLocalCurrCd;
	}

	public String getDorLocValue() {
		return this.dorLocValue;
	}

	public String getNtfyCustNm() {
		return this.ntfyCustNm;
	}

	public String getTrspWoOfcCtyCdSeq() {
		return this.trspWoOfcCtyCdSeq;
	}

	public String getTrspSoCmbSeq() {
		return this.trspSoCmbSeq;
	}

	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
	}

	public String getSpotBidVndrCnt() {
		return this.spotBidVndrCnt;
	}

	public String getSpotBidVndrInfo() {
		return this.spotBidVndrInfo;
	}

	public String getSpotBidDueDt() {
		return this.spotBidDueDt;
	}

	public String getSpotBidNo() {
		return this.spotBidNo;
	}

	public String getSpotBidWinUsdAmt() {
		return this.spotBidWinUsdAmt;
	}

	public String getSpotBidWinAmt() {
		return this.spotBidWinAmt;
	}

	public String getSpotBidWinCurrCd() {
		return this.spotBidWinCurrCd;
	}

	public String getSpotBidWinVndrNm() {
		return this.spotBidWinVndrNm;
	}

	public String getSpotBidWinVndrSeq() {
		return this.spotBidWinVndrSeq;
	}

	public void setIbVvdCd(String ibVvdCd) {
		this.ibVvdCd = ibVvdCd;
	}

	public void setN3ptyBzcTpCd(String n3ptyBzcTpCd) {
		this.n3ptyBzcTpCd = n3ptyBzcTpCd;
	}

	public void setTroCfmUpdTm(String troCfmUpdTm) {
		this.troCfmUpdTm = troCfmUpdTm;
	}

	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	public void setPoLocalCurrTotAmt(String poLocalCurrTotAmt) {
		this.poLocalCurrTotAmt = poLocalCurrTotAmt;
	}

	public void setPoVatScgRt(String poVatScgRt) {
		this.poVatScgRt = poVatScgRt;
	}

	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
	}

	public void setPoScg1Rt(String poScg1Rt) {
		this.poScg1Rt = poScg1Rt;
	}

	public void setTrspAgmtRtTpNm(String trspAgmtRtTpNm) {
		this.trspAgmtRtTpNm = trspAgmtRtTpNm;
	}

	public void setLnkDistDivCd(String lnkDistDivCd) {
		this.lnkDistDivCd = lnkDistDivCd;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setN3ptyBzcCustSeq(String n3ptyBzcCustSeq) {
		this.n3ptyBzcCustSeq = n3ptyBzcCustSeq;
	}

	public void setDorPstCd(String dorPstCd) {
		this.dorPstCd = dorPstCd;
	}

	public void setPoFuelScgRt(String poFuelScgRt) {
		this.poFuelScgRt = poFuelScgRt;
	}

	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}

	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
	}

	public void setTrspSoTpNm(String trspSoTpNm) {
		this.trspSoTpNm = trspSoTpNm;
	}

	public void setPoUsdCurrTotAmt(String poUsdCurrTotAmt) {
		this.poUsdCurrTotAmt = poUsdCurrTotAmt;
	}

	public void setTollFeeAmt(String tollFeeAmt) {
		this.tollFeeAmt = tollFeeAmt;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public void setPoCustNomiTrkrFlg(String poCustNomiTrkrFlg) {
		this.poCustNomiTrkrFlg = poCustNomiTrkrFlg;
	}

	public void setCgoTpNm(String cgoTpNm) {
		this.cgoTpNm = cgoTpNm;
	}

	public void setCntFlg(String cntFlg) {
		this.cntFlg = cntFlg;
	}

	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	public void setTrspSoCmbTpCd(String trspSoCmbTpCd) {
		this.trspSoCmbTpCd = trspSoCmbTpCd;
	}

	public void setMtyRrFlg(String mtyRrFlg) {
		this.mtyRrFlg = mtyRrFlg;
	}

	public void setTroCfmUsrId(String troCfmUsrId) {
		this.troCfmUsrId = troCfmUsrId;
	}

	public void setTrspCostDtlModNm(String trspCostDtlModNm) {
		this.trspCostDtlModNm = trspCostDtlModNm;
	}

	public void setPoBasicRt(String poBasicRt) {
		this.poBasicRt = poBasicRt;
	}

	public void setWoRjctDt(String woRjctDt) {
		this.woRjctDt = woRjctDt;
	}

	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	public void setPoWtrRcvTermCd(String poWtrRcvTermCd) {
		this.poWtrRcvTermCd = poWtrRcvTermCd;
	}

	public void setWoTotAmt(String woTotAmt) {
		this.woTotAmt = woTotAmt;
	}

	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public void setN3ptyBzcDesc(String n3ptyBzcDesc) {
		this.n3ptyBzcDesc = n3ptyBzcDesc;
	}

	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}

	public void setBundlingFlg(String bundlingFlg) {
		this.bundlingFlg = bundlingFlg;
	}

	public void setCancelCheck(String cancelCheck) {
		this.cancelCheck = cancelCheck;
	}

	public void setPoAgmtUpdDt(String poAgmtUpdDt) {
		this.poAgmtUpdDt = poAgmtUpdDt;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}

	public void setN3ptyBzcCustCntCd(String n3ptyBzcCustCntCd) {
		this.n3ptyBzcCustCntCd = n3ptyBzcCustCntCd;
	}

	public void setPoTrspAgmtRtTpNm(String poTrspAgmtRtTpNm) {
		this.poTrspAgmtRtTpNm = poTrspAgmtRtTpNm;
	}

	public void setAgmtMorCnddtAplyFlg(String agmtMorCnddtAplyFlg) {
		this.agmtMorCnddtAplyFlg = agmtMorCnddtAplyFlg;
	}

	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}

	public void setFmYardValue(String fmYardValue) {
		this.fmYardValue = fmYardValue;
	}

	public void setFmLocValue(String fmLocValue) {
		this.fmLocValue = fmLocValue;
	}

	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}

	public void setViaYardValue(String viaYardValue) {
		this.viaYardValue = viaYardValue;
	}

	public void setPoWtrDeTermCd(String poWtrDeTermCd) {
		this.poWtrDeTermCd = poWtrDeTermCd;
	}

	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}

	public void setDeliTimeHms(String deliTimeHms) {
		this.deliTimeHms = deliTimeHms;
	}

	public void setTrspAgmtWyTpCd(String trspAgmtWyTpCd) {
		this.trspAgmtWyTpCd = trspAgmtWyTpCd;
	}

	public void setTrspRjctRsnCd(String trspRjctRsnCd) {
		this.trspRjctRsnCd = trspRjctRsnCd;
	}

	public void setLstNodPlnDt(String lstNodPlnDt) {
		this.lstNodPlnDt = lstNodPlnDt;
	}

	public void setPoOverWgtScgRt(String poOverWgtScgRt) {
		this.poOverWgtScgRt = poOverWgtScgRt;
	}

	public void setMcntrBdlGrpSeq(String mcntrBdlGrpSeq) {
		this.mcntrBdlGrpSeq = mcntrBdlGrpSeq;
	}

	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}

	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}

	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}

	public void setN3ptyBzcOfcCd(String n3ptyBzcOfcCd) {
		this.n3ptyBzcOfcCd = n3ptyBzcOfcCd;
	}

	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}

	public void setCustCntCdSeq(String custCntCdSeq) {
		this.custCntCdSeq = custCntCdSeq;
	}

	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}

	public void setToLocValue(String toLocValue) {
		this.toLocValue = toLocValue;
	}

	public void setDistanceUom(String distanceUom) {
		this.distanceUom = distanceUom;
	}

	public void setWoCreNm(String woCreNm) {
		this.woCreNm = woCreNm;
	}

	public void setViaLocValue(String viaLocValue) {
		this.viaLocValue = viaLocValue;
	}

	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
	}

	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}

	public void setWoRjctIndct(String woRjctIndct) {
		this.woRjctIndct = woRjctIndct;
	}

	public void setN1stNodPlnDt(String n1stNodPlnDt) {
		this.n1stNodPlnDt = n1stNodPlnDt;
	}

	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}

	public void setN3ptyBzcAmt(String n3ptyBzcAmt) {
		this.n3ptyBzcAmt = n3ptyBzcAmt;
	}

	public void setN1stNodPlnTm(String n1stNodPlnTm) {
		this.n1stNodPlnTm = n1stNodPlnTm;
	}

	public void setCntrKgsWgt(String cntrKgsWgt) {
		this.cntrKgsWgt = cntrKgsWgt;
	}

	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
	}

	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	public void setOvwtTriAxlFlg(String ovwtTriAxlFlg) {
		this.ovwtTriAxlFlg = ovwtTriAxlFlg;
	}

	public void setTroCnfm(String troCnfm) {
		this.troCnfm = troCnfm;
	}

	public void setDtnUseFlg(String dtnUseFlg) {
		this.dtnUseFlg = dtnUseFlg;
	}

	public void setTrspCrrModNm(String trspCrrModNm) {
		this.trspCrrModNm = trspCrrModNm;
	}

	public void setBundlingNo(String bundlingNo) {
		this.bundlingNo = bundlingNo;
	}

	public void setN3ptyBzcVndrSeq(String n3ptyBzcVndrSeq) {
		this.n3ptyBzcVndrSeq = n3ptyBzcVndrSeq;
	}

	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	public void setDorDeAddr(String dorDeAddr) {
		this.dorDeAddr = dorDeAddr;
	}

	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	public void setWoIssueDt(String woIssueDt) {
		this.woIssueDt = woIssueDt;
	}

	public void setSoCreNm(String soCreNm) {
		this.soCreNm = soCreNm;
	}

	public void setLstNodPlnTm(String lstNodPlnTm) {
		this.lstNodPlnTm = lstNodPlnTm;
	}

	public void setPoTrspAgmtSeq(String poTrspAgmtSeq) {
		this.poTrspAgmtSeq = poTrspAgmtSeq;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
	}

	public void setPoScg2Rt(String poScg2Rt) {
		this.poScg2Rt = poScg2Rt;
	}

	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}

	public void setHzdMtrlFlg(String hzdMtrlFlg) {
		this.hzdMtrlFlg = hzdMtrlFlg;
	}

	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
	}

	public void setPoTrspAgmtRtTpCd(String poTrspAgmtRtTpCd) {
		this.poTrspAgmtRtTpCd = poTrspAgmtRtTpCd;
	}

	public void setDorNodPlnDt(String dorNodPlnDt) {
		this.dorNodPlnDt = dorNodPlnDt;
	}

	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}

	public void setPoTrspAgmtOfcCtyCd(String poTrspAgmtOfcCtyCd) {
		this.poTrspAgmtOfcCtyCd = poTrspAgmtOfcCtyCd;
	}

	public void setMltStopDeFlg(String mltStopDeFlg) {
		this.mltStopDeFlg = mltStopDeFlg;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	public void setTrspSoCmbTpNm(String trspSoCmbTpNm) {
		this.trspSoCmbTpNm = trspSoCmbTpNm;
	}

	public void setWoBlNoIssFlg(String woBlNoIssFlg) {
		this.woBlNoIssFlg = woBlNoIssFlg;
	}

	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}

	public void setRevCurrCd(String revCurrCd) {
		this.revCurrCd = revCurrCd;
	}

	public void setWoRmk(String woRmk) {
		this.woRmk = woRmk;
	}

	public void setDefaultSpFlg(String defaultSpFlg) {
		this.defaultSpFlg = defaultSpFlg;
	}

	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}

	public void setTrspDfltVndrFlg(String trspDfltVndrFlg) {
		this.trspDfltVndrFlg = trspDfltVndrFlg;
	}

	public void setSurchargeKey(String surchargeKey) {
		this.surchargeKey = surchargeKey;
	}

	public void setFdrVvd(String fdrVvd) {
		this.fdrVvd = fdrVvd;
	}

	public void setPoCustSeq(String poCustSeq) {
		this.poCustSeq = poCustSeq;
	}

	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
	}

	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
	}

	public void setCntrLbsWgt(String cntrLbsWgt) {
		this.cntrLbsWgt = cntrLbsWgt;
	}

	public void setPoSpType(String poSpType) {
		this.poSpType = poSpType;
	}

	public void setBkgspe(String bkgspe) {
		this.bkgspe = bkgspe;
	}

	public void setDeliTimeDt(String deliTimeDt) {
		this.deliTimeDt = deliTimeDt;
	}

	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}

	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}

	public void setTroCfmOfcCd(String troCfmOfcCd) {
		this.troCfmOfcCd = troCfmOfcCd;
	}

	public void setPoCfmFlg(String poCfmFlg) {
		this.poCfmFlg = poCfmFlg;
	}

	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}

	public void setCtrtCnt(String ctrtCnt) {
		this.ctrtCnt = ctrtCnt;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public void setPoRtnMsg(String poRtnMsg) {
		this.poRtnMsg = poRtnMsg;
	}

	public void setToYardValue(String toYardValue) {
		this.toYardValue = toYardValue;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public void setMcntrBdlSeq(String mcntrBdlSeq) {
		this.mcntrBdlSeq = mcntrBdlSeq;
	}

	public void setTrspRqstBkgFlg(String trspRqstBkgFlg) {
		this.trspRqstBkgFlg = trspRqstBkgFlg;
	}

	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public void setN3ptyBzcCurrCd(String n3ptyBzcCurrCd) {
		this.n3ptyBzcCurrCd = n3ptyBzcCurrCd;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public void setPoCustCntCd(String poCustCntCd) {
		this.poCustCntCd = poCustCntCd;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	public void setPoCustCntCdSeq(String poCustCntCdSeq) {
		this.poCustCntCdSeq = poCustCntCdSeq;
	}

	public void setWoEdiUseFlg(String woEdiUseFlg) {
		this.woEdiUseFlg = woEdiUseFlg;
	}

	public void setDorYardValue(String dorYardValue) {
		this.dorYardValue = dorYardValue;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}

	public void setPoAgmtRtSeq(String poAgmtRtSeq) {
		this.poAgmtRtSeq = poAgmtRtSeq;
	}

	public void setMoreCandidates(String moreCandidates) {
		this.moreCandidates = moreCandidates;
	}

	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}

	public void setPresetVndrSeq(String presetVndrSeq) {
		this.presetVndrSeq = presetVndrSeq;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
	}

	public void setAppoTimeHms(String appoTimeHms) {
		this.appoTimeHms = appoTimeHms;
	}

	public void setWoTotAmtUsd(String woTotAmtUsd) {
		this.woTotAmtUsd = woTotAmtUsd;
	}

	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}

	public void setPoWayType(String poWayType) {
		this.poWayType = poWayType;
	}

	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}

	public void setDorNodPlnTm(String dorNodPlnTm) {
		this.dorNodPlnTm = dorNodPlnTm;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public void setOrgNegoAmt(String orgNegoAmt) {
		this.orgNegoAmt = orgNegoAmt;
	}

	public void setTroCfmUpdDt(String troCfmUpdDt) {
		this.troCfmUpdDt = troCfmUpdDt;
	}

	public void setBkgTroNo(String bkgTroNo) {
		this.bkgTroNo = bkgTroNo;
	}

	public void setPoRtnCd(String poRtnCd) {
		this.poRtnCd = poRtnCd;
	}

	public void setPoScg3Rt(String poScg3Rt) {
		this.poScg3Rt = poScg3Rt;
	}

	public void setRejectedCheck(String rejectedCheck) {
		this.rejectedCheck = rejectedCheck;
	}

	public void setAppoTimeDt(String appoTimeDt) {
		this.appoTimeDt = appoTimeDt;
	}

	public void setObVvdCd(String obVvdCd) {
		this.obVvdCd = obVvdCd;
	}

	public void setPoLocalCurrCd(String poLocalCurrCd) {
		this.poLocalCurrCd = poLocalCurrCd;
	}

	public void setDorLocValue(String dorLocValue) {
		this.dorLocValue = dorLocValue;
	}

	public void setNtfyCustNm(String ntfyCustNm) {
		this.ntfyCustNm = ntfyCustNm;
	}

	public void setTrspWoOfcCtyCdSeq(String trspWoOfcCtyCdSeq) {
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
	}

	public void setTrspSoCmbSeq(String trspSoCmbSeq) {
		this.trspSoCmbSeq = trspSoCmbSeq;
	}

	public void setCustNomiTrkrFlg(String custNomiTrkrFlg) {
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}

	public void setSpotBidVndrCnt(String spotBidVndrCnt) {
		this.spotBidVndrCnt = spotBidVndrCnt;
	}

	public void setSpotBidVndrInfo(String spotBidVndrInfo) {
		this.spotBidVndrInfo = spotBidVndrInfo;
	}

	public void setSpotBidDueDt(String spotBidDueDt) {
		this.spotBidDueDt = spotBidDueDt;
	}

	public void setSpotBidNo(String spotBidNo) {
		this.spotBidNo = spotBidNo;
	}

	public void setSpotBidWinUsdAmt(String spotBidWinUsdAmt) {
		this.spotBidWinUsdAmt = spotBidWinUsdAmt;
	}

	public void setSpotBidWinAmt(String spotBidWinAmt) {
		this.spotBidWinAmt = spotBidWinAmt;
	}

	public void setSpotBidWinCurrCd(String spotBidWinCurrCd) {
		this.spotBidWinCurrCd = spotBidWinCurrCd;
	}

	public void setSpotBidWinVndrNm(String spotBidWinVndrNm) {
		this.spotBidWinVndrNm = spotBidWinVndrNm;
	}

	public void setSpotBidWinVndrSeq(String spotBidWinVndrSeq) {
		this.spotBidWinVndrSeq = spotBidWinVndrSeq;
	}

	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setN3ptyBzcTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_tp_cd", ""));
		setTroCfmUpdTm(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_tm", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPoLocalCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_local_curr_tot_amt", ""));
		setPoVatScgRt(JSPUtil.getParameter(request, prefix + "po_vat_scg_rt", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, prefix + "org_curr_cd", ""));
		setPoScg1Rt(JSPUtil.getParameter(request, prefix + "po_scg1_rt", ""));
		setTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_nm", ""));
		setLnkDistDivCd(JSPUtil.getParameter(request, prefix + "lnk_dist_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyBzcCustSeq(JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_seq", ""));
		setDorPstCd(JSPUtil.getParameter(request, prefix + "dor_pst_cd", ""));
		setPoFuelScgRt(JSPUtil.getParameter(request, prefix + "po_fuel_scg_rt", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, prefix + "trsp_frst_flg", ""));
		setTrspSoTpNm(JSPUtil.getParameter(request, prefix + "trsp_so_tp_nm", ""));
		setPoUsdCurrTotAmt(JSPUtil.getParameter(request, prefix + "po_usd_curr_tot_amt", ""));
		setTollFeeAmt(JSPUtil.getParameter(request, prefix + "toll_fee_amt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPoCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "po_cust_nomi_trkr_flg", ""));
		setCgoTpNm(JSPUtil.getParameter(request, prefix + "cgo_tp_nm", ""));
		setCntFlg(JSPUtil.getParameter(request, prefix + "cnt_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_cd", ""));
		setMtyRrFlg(JSPUtil.getParameter(request, prefix + "mty_rr_flg", ""));
		setTroCfmUsrId(JSPUtil.getParameter(request, prefix + "tro_cfm_usr_id", ""));
		setTrspCostDtlModNm(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_nm", ""));
		setPoBasicRt(JSPUtil.getParameter(request, prefix + "po_basic_rt", ""));
		setWoRjctDt(JSPUtil.getParameter(request, prefix + "wo_rjct_dt", ""));
		setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPoWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "po_wtr_rcv_term_cd", ""));
		setWoTotAmt(JSPUtil.getParameter(request, prefix + "wo_tot_amt", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setN3ptyBzcDesc(JSPUtil.getParameter(request, prefix + "n3pty_bzc_desc", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setBundlingFlg(JSPUtil.getParameter(request, prefix + "bundling_flg", ""));
		setCancelCheck(JSPUtil.getParameter(request, prefix + "cancel_check", ""));
		setPoAgmtUpdDt(JSPUtil.getParameter(request, prefix + "po_agmt_upd_dt", ""));
		setDistance(JSPUtil.getParameter(request, prefix + "distance", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setN3ptyBzcCustCntCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_cust_cnt_cd", ""));
		setPoTrspAgmtRtTpNm(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_nm", ""));
		setAgmtMorCnddtAplyFlg(JSPUtil.getParameter(request, prefix + "agmt_mor_cnddt_aply_flg", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setFmYardValue(JSPUtil.getParameter(request, prefix + "fm_yard_value", ""));
		setFmLocValue(JSPUtil.getParameter(request, prefix + "fm_loc_value", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setViaYardValue(JSPUtil.getParameter(request, prefix + "via_yard_value", ""));
		setPoWtrDeTermCd(JSPUtil.getParameter(request, prefix + "po_wtr_de_term_cd", ""));
		setShprCustNm(JSPUtil.getParameter(request, prefix + "shpr_cust_nm", ""));
		setDeliTimeHms(JSPUtil.getParameter(request, prefix + "deli_time_hms", ""));
		setTrspAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_wy_tp_cd", ""));
		setTrspRjctRsnCd(JSPUtil.getParameter(request, prefix + "trsp_rjct_rsn_cd", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", ""));
		setPoOverWgtScgRt(JSPUtil.getParameter(request, prefix + "po_over_wgt_scg_rt", ""));
		setMcntrBdlGrpSeq(JSPUtil.getParameter(request, prefix + "mcntr_bdl_grp_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setN3ptyBzcOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_ofc_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setCustCntCdSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_cd_seq", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setToLocValue(JSPUtil.getParameter(request, prefix + "to_loc_value", ""));
		setDistanceUom(JSPUtil.getParameter(request, prefix + "distance_uom", ""));
		setWoCreNm(JSPUtil.getParameter(request, prefix + "wo_cre_nm", ""));
		setViaLocValue(JSPUtil.getParameter(request, prefix + "via_loc_value", ""));
		setCneeCustNm(JSPUtil.getParameter(request, prefix + "cnee_cust_nm", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setWoRjctIndct(JSPUtil.getParameter(request, prefix + "wo_rjct_indct", ""));
		setN1stNodPlnDt(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setN3ptyBzcAmt(JSPUtil.getParameter(request, prefix + "n3pty_bzc_amt", ""));
		setN1stNodPlnTm(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_tm", ""));
		setCntrKgsWgt(JSPUtil.getParameter(request, prefix + "cntr_kgs_wgt", ""));
		setTtlDist(JSPUtil.getParameter(request, prefix + "ttl_dist", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setOvwtTriAxlFlg(JSPUtil.getParameter(request, prefix + "ovwt_tri_axl_flg", ""));
		setTroCnfm(JSPUtil.getParameter(request, prefix + "tro_cnfm", ""));
		setDtnUseFlg(JSPUtil.getParameter(request, prefix + "dtn_use_flg", ""));
		setTrspCrrModNm(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_nm", ""));
		setBundlingNo(JSPUtil.getParameter(request, prefix + "bundling_no", ""));
		setN3ptyBzcVndrSeq(JSPUtil.getParameter(request, prefix + "n3pty_bzc_vndr_seq", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setDorDeAddr(JSPUtil.getParameter(request, prefix + "dor_de_addr", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setWoIssueDt(JSPUtil.getParameter(request, prefix + "wo_issue_dt", ""));
		setSoCreNm(JSPUtil.getParameter(request, prefix + "so_cre_nm", ""));
		setLstNodPlnTm(JSPUtil.getParameter(request, prefix + "lst_nod_pln_tm", ""));
		setPoTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setPoScg2Rt(JSPUtil.getParameter(request, prefix + "po_scg2_rt", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setHzdMtrlFlg(JSPUtil.getParameter(request, prefix + "hzd_mtrl_flg", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setPoTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_rt_tp_cd", ""));
		setDorNodPlnDt(JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setPoTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "po_trsp_agmt_ofc_cty_cd", ""));
		setMltStopDeFlg(JSPUtil.getParameter(request, prefix + "mlt_stop_de_flg", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setTrspSoCmbTpNm(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_nm", ""));
		setWoBlNoIssFlg(JSPUtil.getParameter(request, prefix + "wo_bl_no_iss_flg", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setRevCurrCd(JSPUtil.getParameter(request, prefix + "rev_curr_cd", ""));
		setWoRmk(JSPUtil.getParameter(request, prefix + "wo_rmk", ""));
		setDefaultSpFlg(JSPUtil.getParameter(request, prefix + "default_sp_flg", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setTrspDfltVndrFlg(JSPUtil.getParameter(request, prefix + "trsp_dflt_vndr_flg", ""));
		setSurchargeKey(JSPUtil.getParameter(request, prefix + "surcharge_key", ""));
		setFdrVvd(JSPUtil.getParameter(request, prefix + "fdr_vvd", ""));
		setPoCustSeq(JSPUtil.getParameter(request, prefix + "po_cust_seq", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setSoCreDt(JSPUtil.getParameter(request, prefix + "so_cre_dt", ""));
		setCntrLbsWgt(JSPUtil.getParameter(request, prefix + "cntr_lbs_wgt", ""));
		setPoSpType(JSPUtil.getParameter(request, prefix + "po_sp_type", ""));
		setBkgspe(JSPUtil.getParameter(request, prefix + "bkgspe", ""));
		setDeliTimeDt(JSPUtil.getParameter(request, prefix + "deli_time_dt", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", ""));
		setTroCfmOfcCd(JSPUtil.getParameter(request, prefix + "tro_cfm_ofc_cd", ""));
		setPoCfmFlg(JSPUtil.getParameter(request, prefix + "po_cfm_flg", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setCtrtCnt(JSPUtil.getParameter(request, prefix + "ctrt_cnt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPoRtnMsg(JSPUtil.getParameter(request, prefix + "po_rtn_msg", ""));
		setToYardValue(JSPUtil.getParameter(request, prefix + "to_yard_value", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setMcntrBdlSeq(JSPUtil.getParameter(request, prefix + "mcntr_bdl_seq", ""));
		setTrspRqstBkgFlg(JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setN3ptyBzcCurrCd(JSPUtil.getParameter(request, prefix + "n3pty_bzc_curr_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPoCustCntCd(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPoCustCntCdSeq(JSPUtil.getParameter(request, prefix + "po_cust_cnt_cd_seq", ""));
		setWoEdiUseFlg(JSPUtil.getParameter(request, prefix + "wo_edi_use_flg", ""));
		setDorYardValue(JSPUtil.getParameter(request, prefix + "dor_yard_value", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setPoAgmtRtSeq(JSPUtil.getParameter(request, prefix + "po_agmt_rt_seq", ""));
		setMoreCandidates(JSPUtil.getParameter(request, prefix + "more_candidates", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setPresetVndrSeq(JSPUtil.getParameter(request, prefix + "preset_vndr_seq", ""));
		setRevenue(JSPUtil.getParameter(request, prefix + "revenue", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setAppoTimeHms(JSPUtil.getParameter(request, prefix + "appo_time_hms", ""));
		setWoTotAmtUsd(JSPUtil.getParameter(request, prefix + "wo_tot_amt_usd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setPoWayType(JSPUtil.getParameter(request, prefix + "po_way_type", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setDorNodPlnTm(JSPUtil.getParameter(request, prefix + "dor_nod_pln_tm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSpType(JSPUtil.getParameter(request, prefix + "sp_type", ""));
		setOrgNegoAmt(JSPUtil.getParameter(request, prefix + "org_nego_amt", ""));
		setTroCfmUpdDt(JSPUtil.getParameter(request, prefix + "tro_cfm_upd_dt", ""));
		setBkgTroNo(JSPUtil.getParameter(request, prefix + "bkg_tro_no", ""));
		setPoRtnCd(JSPUtil.getParameter(request, prefix + "po_rtn_cd", ""));
		setPoScg3Rt(JSPUtil.getParameter(request, prefix + "po_scg3_rt", ""));
		setRejectedCheck(JSPUtil.getParameter(request, prefix + "rejected_check", ""));
		setAppoTimeDt(JSPUtil.getParameter(request, prefix + "appo_time_dt", ""));
		setObVvdCd(JSPUtil.getParameter(request, prefix + "ob_vvd_cd", ""));
		setPoLocalCurrCd(JSPUtil.getParameter(request, prefix + "po_local_curr_cd", ""));
		setDorLocValue(JSPUtil.getParameter(request, prefix + "dor_loc_value", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, prefix + "ntfy_cust_nm", ""));
		setTrspWoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd_seq", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_seq", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", ""));
		setSpotBidVndrCnt(JSPUtil.getParameter(request, prefix + "spot_bid_vndr_cnt", ""));
		setSpotBidVndrInfo(JSPUtil.getParameter(request, prefix + "spot_bid_vndr_info", ""));
		setSpotBidDueDt(JSPUtil.getParameter(request, prefix + "spot_bid_due_dt", ""));
		setSpotBidNo(JSPUtil.getParameter(request, prefix + "spot_bid_no", ""));
		setSpotBidWinUsdAmt(JSPUtil.getParameter(request, prefix + "spot_bid_win_usd_amt", ""));
		setSpotBidWinAmt(JSPUtil.getParameter(request, prefix + "spot_bid_win_amt", ""));
		setSpotBidWinCurrCd(JSPUtil.getParameter(request, prefix + "spot_bid_win_curr_cd", ""));
		setSpotBidWinVndrNm(JSPUtil.getParameter(request, prefix + "spot_bid_win_vndr_nm", ""));
		setSpotBidWinVndrSeq(JSPUtil.getParameter(request, prefix + "spot_bid_win_vndr_seq", ""));
	}

	public SpotBidWoIssueListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SpotBidWoIssueListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpotBidWoIssueListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if(tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] n3ptyBzcTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_tp_cd", length));
			String[] troCfmUpdTm = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_upd_tm", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] poLocalCurrTotAmt = (JSPUtil.getParameter(request, prefix	+ "po_local_curr_tot_amt", length));
			String[] poVatScgRt = (JSPUtil.getParameter(request, prefix	+ "po_vat_scg_rt", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] poScg1Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg1_rt", length));
			String[] trspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_nm", length));
			String[] lnkDistDivCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dist_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyBzcCustSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_cust_seq", length));
			String[] dorPstCd = (JSPUtil.getParameter(request, prefix	+ "dor_pst_cd", length));
			String[] poFuelScgRt = (JSPUtil.getParameter(request, prefix	+ "po_fuel_scg_rt", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_frst_flg", length));
			String[] trspSoTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_nm", length));
			String[] poUsdCurrTotAmt = (JSPUtil.getParameter(request, prefix	+ "po_usd_curr_tot_amt", length));
			String[] tollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] poCustNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "po_cust_nomi_trkr_flg", length));
			String[] cgoTpNm = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_nm", length));
			String[] cntFlg = (JSPUtil.getParameter(request, prefix	+ "cnt_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_cd", length));
			String[] mtyRrFlg = (JSPUtil.getParameter(request, prefix	+ "mty_rr_flg", length));
			String[] troCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_usr_id", length));
			String[] trspCostDtlModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_nm", length));
			String[] poBasicRt = (JSPUtil.getParameter(request, prefix	+ "po_basic_rt", length));
			String[] woRjctDt = (JSPUtil.getParameter(request, prefix	+ "wo_rjct_dt", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] poWtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "po_wtr_rcv_term_cd", length));
			String[] woTotAmt = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] n3ptyBzcDesc = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_desc", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] bundlingFlg = (JSPUtil.getParameter(request, prefix	+ "bundling_flg", length));
			String[] cancelCheck = (JSPUtil.getParameter(request, prefix	+ "cancel_check", length));
			String[] poAgmtUpdDt = (JSPUtil.getParameter(request, prefix	+ "po_agmt_upd_dt", length));
			String[] distance = (JSPUtil.getParameter(request, prefix	+ "distance", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] n3ptyBzcCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_cust_cnt_cd", length));
			String[] poTrspAgmtRtTpNm = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_rt_tp_nm", length));
			String[] agmtMorCnddtAplyFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_mor_cnddt_aply_flg", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] fmYardValue = (JSPUtil.getParameter(request, prefix	+ "fm_yard_value", length));
			String[] fmLocValue = (JSPUtil.getParameter(request, prefix	+ "fm_loc_value", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] viaYardValue = (JSPUtil.getParameter(request, prefix	+ "via_yard_value", length));
			String[] poWtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "po_wtr_de_term_cd", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] deliTimeHms = (JSPUtil.getParameter(request, prefix	+ "deli_time_hms", length));
			String[] trspAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_wy_tp_cd", length));
			String[] trspRjctRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsp_rjct_rsn_cd", length));
			String[] lstNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_dt", length));
			String[] poOverWgtScgRt = (JSPUtil.getParameter(request, prefix	+ "po_over_wgt_scg_rt", length));
			String[] mcntrBdlGrpSeq = (JSPUtil.getParameter(request, prefix	+ "mcntr_bdl_grp_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] n3ptyBzcOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_ofc_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] custCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_seq", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] toLocValue = (JSPUtil.getParameter(request, prefix	+ "to_loc_value", length));
			String[] distanceUom = (JSPUtil.getParameter(request, prefix	+ "distance_uom", length));
			String[] woCreNm = (JSPUtil.getParameter(request, prefix	+ "wo_cre_nm", length));
			String[] viaLocValue = (JSPUtil.getParameter(request, prefix	+ "via_loc_value", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_nm", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] woRjctIndct = (JSPUtil.getParameter(request, prefix	+ "wo_rjct_indct", length));
			String[] n1stNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_dt", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] n3ptyBzcAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_amt", length));
			String[] n1stNodPlnTm = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_tm", length));
			String[] cntrKgsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_kgs_wgt", length));
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] ovwtTriAxlFlg = (JSPUtil.getParameter(request, prefix	+ "ovwt_tri_axl_flg", length));
			String[] troCnfm = (JSPUtil.getParameter(request, prefix	+ "tro_cnfm", length));
			String[] dtnUseFlg = (JSPUtil.getParameter(request, prefix	+ "dtn_use_flg", length));
			String[] trspCrrModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_nm", length));
			String[] bundlingNo = (JSPUtil.getParameter(request, prefix	+ "bundling_no", length));
			String[] n3ptyBzcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_vndr_seq", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] dorDeAddr = (JSPUtil.getParameter(request, prefix	+ "dor_de_addr", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] woIssueDt = (JSPUtil.getParameter(request, prefix	+ "wo_issue_dt", length));
			String[] soCreNm = (JSPUtil.getParameter(request, prefix	+ "so_cre_nm", length));
			String[] lstNodPlnTm = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_tm", length));
			String[] poTrspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cntr_tp_cd", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] poScg2Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg2_rt", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] hzdMtrlFlg = (JSPUtil.getParameter(request, prefix	+ "hzd_mtrl_flg", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] poTrspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_rt_tp_cd", length));
			String[] dorNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_dt", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] poTrspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "po_trsp_agmt_ofc_cty_cd", length));
			String[] mltStopDeFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_stop_de_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] trspSoCmbTpNm = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_nm", length));
			String[] woBlNoIssFlg = (JSPUtil.getParameter(request, prefix	+ "wo_bl_no_iss_flg", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] revCurrCd = (JSPUtil.getParameter(request, prefix	+ "rev_curr_cd", length));
			String[] woRmk = (JSPUtil.getParameter(request, prefix	+ "wo_rmk", length));
			String[] defaultSpFlg = (JSPUtil.getParameter(request, prefix	+ "default_sp_flg", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trspDfltVndrFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_dflt_vndr_flg", length));
			String[] surchargeKey = (JSPUtil.getParameter(request, prefix	+ "surcharge_key", length));
			String[] fdrVvd = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd", length));
			String[] poCustSeq = (JSPUtil.getParameter(request, prefix	+ "po_cust_seq", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix	+ "so_cre_dt", length));
			String[] cntrLbsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_lbs_wgt", length));
			String[] poSpType = (JSPUtil.getParameter(request, prefix	+ "po_sp_type", length));
			String[] bkgspe = (JSPUtil.getParameter(request, prefix	+ "bkgspe", length));
			String[] deliTimeDt = (JSPUtil.getParameter(request, prefix	+ "deli_time_dt", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd_seq", length));
			String[] troCfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_ofc_cd", length));
			String[] poCfmFlg = (JSPUtil.getParameter(request, prefix	+ "po_cfm_flg", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] ctrtCnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_cnt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] poRtnMsg = (JSPUtil.getParameter(request, prefix	+ "po_rtn_msg", length));
			String[] toYardValue = (JSPUtil.getParameter(request, prefix	+ "to_yard_value", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] mcntrBdlSeq = (JSPUtil.getParameter(request, prefix	+ "mcntr_bdl_seq", length));
			String[] trspRqstBkgFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_bkg_flg", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] n3ptyBzcCurrCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bzc_curr_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] poCustCntCd = (JSPUtil.getParameter(request, prefix	+ "po_cust_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] poCustCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "po_cust_cnt_cd_seq", length));
			String[] woEdiUseFlg = (JSPUtil.getParameter(request, prefix	+ "wo_edi_use_flg", length));
			String[] dorYardValue = (JSPUtil.getParameter(request, prefix	+ "dor_yard_value", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] poAgmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "po_agmt_rt_seq", length));
			String[] moreCandidates = (JSPUtil.getParameter(request, prefix	+ "more_candidates", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] presetVndrSeq = (JSPUtil.getParameter(request, prefix	+ "preset_vndr_seq", length));
			String[] revenue = (JSPUtil.getParameter(request, prefix	+ "revenue", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] appoTimeHms = (JSPUtil.getParameter(request, prefix	+ "appo_time_hms", length));
			String[] woTotAmtUsd = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt_usd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] poWayType = (JSPUtil.getParameter(request, prefix	+ "po_way_type", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] dorNodPlnTm = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_tm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] spType = (JSPUtil.getParameter(request, prefix	+ "sp_type", length));
			String[] orgNegoAmt = (JSPUtil.getParameter(request, prefix	+ "org_nego_amt", length));
			String[] troCfmUpdDt = (JSPUtil.getParameter(request, prefix	+ "tro_cfm_upd_dt", length));
			String[] bkgTroNo = (JSPUtil.getParameter(request, prefix	+ "bkg_tro_no", length));
			String[] poRtnCd = (JSPUtil.getParameter(request, prefix	+ "po_rtn_cd", length));
			String[] poScg3Rt = (JSPUtil.getParameter(request, prefix	+ "po_scg3_rt", length));
			String[] rejectedCheck = (JSPUtil.getParameter(request, prefix	+ "rejected_check", length));
			String[] appoTimeDt = (JSPUtil.getParameter(request, prefix	+ "appo_time_dt", length));
			String[] obVvdCd = (JSPUtil.getParameter(request, prefix	+ "ob_vvd_cd", length));
			String[] poLocalCurrCd = (JSPUtil.getParameter(request, prefix	+ "po_local_curr_cd", length));
			String[] dorLocValue = (JSPUtil.getParameter(request, prefix	+ "dor_loc_value", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_nm", length));
			String[] trspWoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd_seq", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_seq", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_flg", length));
			String[] spotBidVndrCnt = (JSPUtil.getParameter(request, prefix	+ "spot_bid_vndr_cnt", length));
			String[] spotBidVndrInfo = (JSPUtil.getParameter(request, prefix	+ "spot_bid_vndr_info", length));
			String[] spotBidDueDt = (JSPUtil.getParameter(request, prefix	+ "spot_bid_due_dt", length));
			String[] spotBidNo = (JSPUtil.getParameter(request, prefix	+ "spot_bid_no", length));
			String[] spotBidWinUsdAmt = (JSPUtil.getParameter(request, prefix	+ "spot_bid_win_usd_amt", length));
			String[] spotBidWinAmt = (JSPUtil.getParameter(request, prefix	+ "spot_bid_win_amt", length));
			String[] spotBidWinCurrCd = (JSPUtil.getParameter(request, prefix	+ "spot_bid_win_curr_cd", length));
			String[] spotBidWinVndrNm = (JSPUtil.getParameter(request, prefix	+ "spot_bid_win_vndr_nm", length));
			String[] spotBidWinVndrSeq = (JSPUtil.getParameter(request, prefix	+ "spot_bid_win_vndr_seq", length));
			for (int i = 0; i < length; i++) {
				model = new SpotBidWoIssueListVO();
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (n3ptyBzcTpCd[i] != null)
					model.setN3ptyBzcTpCd(n3ptyBzcTpCd[i]);
				if (troCfmUpdTm[i] != null)
					model.setTroCfmUpdTm(troCfmUpdTm[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (poLocalCurrTotAmt[i] != null)
					model.setPoLocalCurrTotAmt(poLocalCurrTotAmt[i]);
				if (poVatScgRt[i] != null)
					model.setPoVatScgRt(poVatScgRt[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (poScg1Rt[i] != null)
					model.setPoScg1Rt(poScg1Rt[i]);
				if (trspAgmtRtTpNm[i] != null)
					model.setTrspAgmtRtTpNm(trspAgmtRtTpNm[i]);
				if (lnkDistDivCd[i] != null)
					model.setLnkDistDivCd(lnkDistDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyBzcCustSeq[i] != null)
					model.setN3ptyBzcCustSeq(n3ptyBzcCustSeq[i]);
				if (dorPstCd[i] != null)
					model.setDorPstCd(dorPstCd[i]);
				if (poFuelScgRt[i] != null)
					model.setPoFuelScgRt(poFuelScgRt[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				if (trspSoTpNm[i] != null)
					model.setTrspSoTpNm(trspSoTpNm[i]);
				if (poUsdCurrTotAmt[i] != null)
					model.setPoUsdCurrTotAmt(poUsdCurrTotAmt[i]);
				if (tollFeeAmt[i] != null)
					model.setTollFeeAmt(tollFeeAmt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (poCustNomiTrkrFlg[i] != null)
					model.setPoCustNomiTrkrFlg(poCustNomiTrkrFlg[i]);
				if (cgoTpNm[i] != null)
					model.setCgoTpNm(cgoTpNm[i]);
				if (cntFlg[i] != null)
					model.setCntFlg(cntFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (mtyRrFlg[i] != null)
					model.setMtyRrFlg(mtyRrFlg[i]);
				if (troCfmUsrId[i] != null)
					model.setTroCfmUsrId(troCfmUsrId[i]);
				if (trspCostDtlModNm[i] != null)
					model.setTrspCostDtlModNm(trspCostDtlModNm[i]);
				if (poBasicRt[i] != null)
					model.setPoBasicRt(poBasicRt[i]);
				if (woRjctDt[i] != null)
					model.setWoRjctDt(woRjctDt[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (poWtrRcvTermCd[i] != null)
					model.setPoWtrRcvTermCd(poWtrRcvTermCd[i]);
				if (woTotAmt[i] != null)
					model.setWoTotAmt(woTotAmt[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (n3ptyBzcDesc[i] != null)
					model.setN3ptyBzcDesc(n3ptyBzcDesc[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (bundlingFlg[i] != null)
					model.setBundlingFlg(bundlingFlg[i]);
				if (cancelCheck[i] != null)
					model.setCancelCheck(cancelCheck[i]);
				if (poAgmtUpdDt[i] != null)
					model.setPoAgmtUpdDt(poAgmtUpdDt[i]);
				if (distance[i] != null)
					model.setDistance(distance[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (n3ptyBzcCustCntCd[i] != null)
					model.setN3ptyBzcCustCntCd(n3ptyBzcCustCntCd[i]);
				if (poTrspAgmtRtTpNm[i] != null)
					model.setPoTrspAgmtRtTpNm(poTrspAgmtRtTpNm[i]);
				if (agmtMorCnddtAplyFlg[i] != null)
					model.setAgmtMorCnddtAplyFlg(agmtMorCnddtAplyFlg[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (fmYardValue[i] != null)
					model.setFmYardValue(fmYardValue[i]);
				if (fmLocValue[i] != null)
					model.setFmLocValue(fmLocValue[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (viaYardValue[i] != null)
					model.setViaYardValue(viaYardValue[i]);
				if (poWtrDeTermCd[i] != null)
					model.setPoWtrDeTermCd(poWtrDeTermCd[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (deliTimeHms[i] != null)
					model.setDeliTimeHms(deliTimeHms[i]);
				if (trspAgmtWyTpCd[i] != null)
					model.setTrspAgmtWyTpCd(trspAgmtWyTpCd[i]);
				if (trspRjctRsnCd[i] != null)
					model.setTrspRjctRsnCd(trspRjctRsnCd[i]);
				if (lstNodPlnDt[i] != null)
					model.setLstNodPlnDt(lstNodPlnDt[i]);
				if (poOverWgtScgRt[i] != null)
					model.setPoOverWgtScgRt(poOverWgtScgRt[i]);
				if (mcntrBdlGrpSeq[i] != null)
					model.setMcntrBdlGrpSeq(mcntrBdlGrpSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (n3ptyBzcOfcCd[i] != null)
					model.setN3ptyBzcOfcCd(n3ptyBzcOfcCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (custCntCdSeq[i] != null)
					model.setCustCntCdSeq(custCntCdSeq[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (toLocValue[i] != null)
					model.setToLocValue(toLocValue[i]);
				if (distanceUom[i] != null)
					model.setDistanceUom(distanceUom[i]);
				if (woCreNm[i] != null)
					model.setWoCreNm(woCreNm[i]);
				if (viaLocValue[i] != null)
					model.setViaLocValue(viaLocValue[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (woRjctIndct[i] != null)
					model.setWoRjctIndct(woRjctIndct[i]);
				if (n1stNodPlnDt[i] != null)
					model.setN1stNodPlnDt(n1stNodPlnDt[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (n3ptyBzcAmt[i] != null)
					model.setN3ptyBzcAmt(n3ptyBzcAmt[i]);
				if (n1stNodPlnTm[i] != null)
					model.setN1stNodPlnTm(n1stNodPlnTm[i]);
				if (cntrKgsWgt[i] != null)
					model.setCntrKgsWgt(cntrKgsWgt[i]);
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (ovwtTriAxlFlg[i] != null)
					model.setOvwtTriAxlFlg(ovwtTriAxlFlg[i]);
				if (troCnfm[i] != null)
					model.setTroCnfm(troCnfm[i]);
				if (dtnUseFlg[i] != null)
					model.setDtnUseFlg(dtnUseFlg[i]);
				if (trspCrrModNm[i] != null)
					model.setTrspCrrModNm(trspCrrModNm[i]);
				if (bundlingNo[i] != null)
					model.setBundlingNo(bundlingNo[i]);
				if (n3ptyBzcVndrSeq[i] != null)
					model.setN3ptyBzcVndrSeq(n3ptyBzcVndrSeq[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (dorDeAddr[i] != null)
					model.setDorDeAddr(dorDeAddr[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (woIssueDt[i] != null)
					model.setWoIssueDt(woIssueDt[i]);
				if (soCreNm[i] != null)
					model.setSoCreNm(soCreNm[i]);
				if (lstNodPlnTm[i] != null)
					model.setLstNodPlnTm(lstNodPlnTm[i]);
				if (poTrspAgmtSeq[i] != null)
					model.setPoTrspAgmtSeq(poTrspAgmtSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (poScg2Rt[i] != null)
					model.setPoScg2Rt(poScg2Rt[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (hzdMtrlFlg[i] != null)
					model.setHzdMtrlFlg(hzdMtrlFlg[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (poTrspAgmtRtTpCd[i] != null)
					model.setPoTrspAgmtRtTpCd(poTrspAgmtRtTpCd[i]);
				if (dorNodPlnDt[i] != null)
					model.setDorNodPlnDt(dorNodPlnDt[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (poTrspAgmtOfcCtyCd[i] != null)
					model.setPoTrspAgmtOfcCtyCd(poTrspAgmtOfcCtyCd[i]);
				if (mltStopDeFlg[i] != null)
					model.setMltStopDeFlg(mltStopDeFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (trspSoCmbTpNm[i] != null)
					model.setTrspSoCmbTpNm(trspSoCmbTpNm[i]);
				if (woBlNoIssFlg[i] != null)
					model.setWoBlNoIssFlg(woBlNoIssFlg[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (revCurrCd[i] != null)
					model.setRevCurrCd(revCurrCd[i]);
				if (woRmk[i] != null)
					model.setWoRmk(woRmk[i]);
				if (defaultSpFlg[i] != null)
					model.setDefaultSpFlg(defaultSpFlg[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trspDfltVndrFlg[i] != null)
					model.setTrspDfltVndrFlg(trspDfltVndrFlg[i]);
				if (surchargeKey[i] != null)
					model.setSurchargeKey(surchargeKey[i]);
				if (fdrVvd[i] != null)
					model.setFdrVvd(fdrVvd[i]);
				if (poCustSeq[i] != null)
					model.setPoCustSeq(poCustSeq[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (cntrLbsWgt[i] != null)
					model.setCntrLbsWgt(cntrLbsWgt[i]);
				if (poSpType[i] != null)
					model.setPoSpType(poSpType[i]);
				if (bkgspe[i] != null)
					model.setBkgspe(bkgspe[i]);
				if (deliTimeDt[i] != null)
					model.setDeliTimeDt(deliTimeDt[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (troCfmOfcCd[i] != null)
					model.setTroCfmOfcCd(troCfmOfcCd[i]);
				if (poCfmFlg[i] != null)
					model.setPoCfmFlg(poCfmFlg[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (ctrtCnt[i] != null)
					model.setCtrtCnt(ctrtCnt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (poRtnMsg[i] != null)
					model.setPoRtnMsg(poRtnMsg[i]);
				if (toYardValue[i] != null)
					model.setToYardValue(toYardValue[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (mcntrBdlSeq[i] != null)
					model.setMcntrBdlSeq(mcntrBdlSeq[i]);
				if (trspRqstBkgFlg[i] != null)
					model.setTrspRqstBkgFlg(trspRqstBkgFlg[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (n3ptyBzcCurrCd[i] != null)
					model.setN3ptyBzcCurrCd(n3ptyBzcCurrCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (poCustCntCd[i] != null)
					model.setPoCustCntCd(poCustCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (poCustCntCdSeq[i] != null)
					model.setPoCustCntCdSeq(poCustCntCdSeq[i]);
				if (woEdiUseFlg[i] != null)
					model.setWoEdiUseFlg(woEdiUseFlg[i]);
				if (dorYardValue[i] != null)
					model.setDorYardValue(dorYardValue[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (poAgmtRtSeq[i] != null)
					model.setPoAgmtRtSeq(poAgmtRtSeq[i]);
				if (moreCandidates[i] != null)
					model.setMoreCandidates(moreCandidates[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (presetVndrSeq[i] != null)
					model.setPresetVndrSeq(presetVndrSeq[i]);
				if (revenue[i] != null)
					model.setRevenue(revenue[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (appoTimeHms[i] != null)
					model.setAppoTimeHms(appoTimeHms[i]);
				if (woTotAmtUsd[i] != null)
					model.setWoTotAmtUsd(woTotAmtUsd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (poWayType[i] != null)
					model.setPoWayType(poWayType[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (dorNodPlnTm[i] != null)
					model.setDorNodPlnTm(dorNodPlnTm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (spType[i] != null)
					model.setSpType(spType[i]);
				if (orgNegoAmt[i] != null)
					model.setOrgNegoAmt(orgNegoAmt[i]);
				if (troCfmUpdDt[i] != null)
					model.setTroCfmUpdDt(troCfmUpdDt[i]);
				if (bkgTroNo[i] != null)
					model.setBkgTroNo(bkgTroNo[i]);
				if (poRtnCd[i] != null)
					model.setPoRtnCd(poRtnCd[i]);
				if (poScg3Rt[i] != null)
					model.setPoScg3Rt(poScg3Rt[i]);
				if (rejectedCheck[i] != null)
					model.setRejectedCheck(rejectedCheck[i]);
				if (appoTimeDt[i] != null)
					model.setAppoTimeDt(appoTimeDt[i]);
				if (obVvdCd[i] != null)
					model.setObVvdCd(obVvdCd[i]);
				if (poLocalCurrCd[i] != null)
					model.setPoLocalCurrCd(poLocalCurrCd[i]);
				if (dorLocValue[i] != null)
					model.setDorLocValue(dorLocValue[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (trspWoOfcCtyCdSeq[i] != null)
					model.setTrspWoOfcCtyCdSeq(trspWoOfcCtyCdSeq[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				if (spotBidVndrCnt[i] != null)
					model.setSpotBidVndrCnt(spotBidVndrCnt[i]);
				if (spotBidVndrInfo[i] != null)
					model.setSpotBidVndrInfo(spotBidVndrInfo[i]);
				if (spotBidDueDt[i] != null)
					model.setSpotBidDueDt(spotBidDueDt[i]);
				if (spotBidNo[i] != null)
					model.setSpotBidNo(spotBidNo[i]);
				if (spotBidWinUsdAmt[i] != null)
					model.setSpotBidWinUsdAmt(spotBidWinUsdAmt[i]);
				if (spotBidWinAmt[i] != null)
					model.setSpotBidWinAmt(spotBidWinAmt[i]);
				if (spotBidWinCurrCd[i] != null)
					model.setSpotBidWinCurrCd(spotBidWinCurrCd[i]);
				if (spotBidWinVndrNm[i] != null)
					model.setSpotBidWinVndrNm(spotBidWinVndrNm[i]);
				if (spotBidWinVndrSeq[i] != null)
					model.setSpotBidWinVndrSeq(spotBidWinVndrSeq[i]);
				models.add(model);
			}
		 } catch (Exception e) {
			return null;
		}
		return getSpotBidWoIssueListVOs();
	}

	public SpotBidWoIssueListVO[] getSpotBidWoIssueListVOs(){
		SpotBidWoIssueListVO[] vos = (SpotBidWoIssueListVO[])models.toArray(new SpotBidWoIssueListVO[models.size()]);
		return vos;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}

	public void unDataFormat(){
		this.ibVvdCd = this.ibVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcTpCd = this.n3ptyBzcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdTm = this.troCfmUpdTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrTotAmt = this.poLocalCurrTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poVatScgRt = this.poVatScgRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg1Rt = this.poScg1Rt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpNm = this.trspAgmtRtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDistDivCd = this.lnkDistDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCustSeq = this.n3ptyBzcCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstCd = this.dorPstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poFuelScgRt = this.poFuelScgRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpNm = this.trspSoTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poUsdCurrTotAmt = this.poUsdCurrTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt = this.tollFeeAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustNomiTrkrFlg = this.poCustNomiTrkrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpNm = this.cgoTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntFlg = this.cntFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRrFlg = this.mtyRrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUsrId = this.troCfmUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModNm = this.trspCostDtlModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poBasicRt = this.poBasicRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctDt = this.woRjctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWtrRcvTermCd = this.poWtrRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmt = this.woTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcDesc = this.n3ptyBzcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundlingFlg = this.bundlingFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelCheck = this.cancelCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poAgmtUpdDt = this.poAgmtUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distance = this.distance.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCustCntCd = this.n3ptyBzcCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpNm = this.poTrspAgmtRtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtMorCnddtAplyFlg = this.agmtMorCnddtAplyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardValue = this.fmYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocValue = this.fmLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaYardValue = this.viaYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWtrDeTermCd = this.poWtrDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliTimeHms = this.deliTimeHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtWyTpCd = this.trspAgmtWyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRjctRsnCd = this.trspRjctRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt = this.lstNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poOverWgtScgRt = this.poOverWgtScgRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrBdlGrpSeq = this.mcntrBdlGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcOfcCd = this.n3ptyBzcOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdSeq = this.custCntCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocValue = this.toLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distanceUom = this.distanceUom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreNm = this.woCreNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocValue = this.viaLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctIndct = this.woRjctIndct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDt = this.n1stNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcAmt = this.n3ptyBzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnTm = this.n1stNodPlnTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKgsWgt = this.cntrKgsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDist = this.ttlDist.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwtTriAxlFlg = this.ovwtTriAxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCnfm = this.troCnfm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtnUseFlg = this.dtnUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModNm = this.trspCrrModNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bundlingNo = this.bundlingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcVndrSeq = this.n3ptyBzcVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorDeAddr = this.dorDeAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssueDt = this.woIssueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreNm = this.soCreNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnTm = this.lstNodPlnTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtSeq = this.poTrspAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg2Rt = this.poScg2Rt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdMtrlFlg = this.hzdMtrlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtRtTpCd = this.poTrspAgmtRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDt = this.dorNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poTrspAgmtOfcCtyCd = this.poTrspAgmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltStopDeFlg = this.mltStopDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpNm = this.trspSoCmbTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woBlNoIssFlg = this.woBlNoIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCurrCd = this.revCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRmk = this.woRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.defaultSpFlg = this.defaultSpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDfltVndrFlg = this.trspDfltVndrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeKey = this.surchargeKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvd = this.fdrVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustSeq = this.poCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLbsWgt = this.cntrLbsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poSpType = this.poSpType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspe = this.bkgspe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deliTimeDt = this.deliTimeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmOfcCd = this.troCfmOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCfmFlg = this.poCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCnt = this.ctrtCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnMsg = this.poRtnMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardValue = this.toYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrBdlSeq = this.mcntrBdlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstBkgFlg = this.trspRqstBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBzcCurrCd = this.n3ptyBzcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCd = this.poCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poCustCntCdSeq = this.poCustCntCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woEdiUseFlg = this.woEdiUseFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorYardValue = this.dorYardValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poAgmtRtSeq = this.poAgmtRtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moreCandidates = this.moreCandidates.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.presetVndrSeq = this.presetVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenue = this.revenue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appoTimeHms = this.appoTimeHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmtUsd = this.woTotAmtUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poWayType = this.poWayType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnTm = this.dorNodPlnTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spType = this.spType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNegoAmt = this.orgNegoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCfmUpdDt = this.troCfmUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTroNo = this.bkgTroNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poRtnCd = this.poRtnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poScg3Rt = this.poScg3Rt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectedCheck = this.rejectedCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appoTimeDt = this.appoTimeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obVvdCd = this.obVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poLocalCurrCd = this.poLocalCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocValue = this.dorLocValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCdSeq = this.trspWoOfcCtyCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidVndrCnt = this.spotBidVndrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidVndrInfo = this.spotBidVndrInfo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidDueDt = this.spotBidDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidNo = this.spotBidNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidWinUsdAmt = this.spotBidWinUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidWinAmt = this.spotBidWinAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidWinCurrCd = this.spotBidWinCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidWinVndrNm = this.spotBidWinVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidWinVndrSeq = this.spotBidWinVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}