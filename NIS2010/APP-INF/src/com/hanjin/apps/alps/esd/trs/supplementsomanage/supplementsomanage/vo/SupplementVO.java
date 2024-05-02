/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SupplementVO.java
*@FileTitle : SupplementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SupplementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SupplementVO> models = new ArrayList<SupplementVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String chssMgstBdlSeq = null;
	/* Column Info */
	private String toNodCdSub = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String dorDeAddr = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String mltStopDeFlg = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String trnsRqstOfcCd = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dorNodCdSub = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String trspSoCmbTpCd = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String surchargeKey = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trnsRqstRsn = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String splIssRsn = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String repoRefNo = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dorSvcTpCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String ovrWgtScgAmt = null;
	/* Column Info */
	private String trnsRqstUsrId = null;
	/* Column Info */
	private String railCmbThruTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String amountKind = null;
	/* Column Info */
	private String agmtWayType = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String trspPurpRsn = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String fmNodCdSub = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String viaNodCdSub = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String repoRefSeq = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String cmbSoRltStsFlg = null;
	/* Column Info */
	private String actGrpCd = null;
	/* Column Info */
	private String agmtRateType = null;
	/* Column Info */
	private String chssMgstTrspTpCd = null;
	/* Column Info */
	private String trspSoCmbSeq = null;
	/* Column Info */
	private String custNomiTrkrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SupplementVO() {}

	public SupplementVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String actGrpCd, String fmNodCd, String toNodCd, String viaNodCd, String dorNodCd, String fmNodCdSub, String toNodCdSub, String viaNodCdSub, String dorNodCdSub, String eqKndCd, String eqTpszCd, String trspBndCd, String eqNo, String bkgNo, String bkgNoSplit, String blNo, String blNoTp, String blNoChk, String lgsCostCd, String trspCostDtlModCd, String trspCrrModCd, String trspSoStsCd, String trspSoTpCd, String railCmbThruTpCd, String n3ptyBilFlg, String currCd, String bzcAmt, String etcAddAmt, String fuelScgAmt, String negoAmt, String ovrWgtScgAmt, String cntrWgt, String wgtMeasUtCd, String cgoTpCd, String cmdtCd, String dorSvcTpCd, String dorDeAddr, String mltStopDeFlg, String splIssRsn, String trspPurpRsn, String trnsRqstOfcCd, String trnsRqstUsrId, String trnsRqstRsn, String cmbSoRltStsFlg, String trspWoOfcCtyCd, String trspWoSeq, String repoRefNo, String repoRefSeq, String chssMgstBdlSeq, String chssMgstTrspTpCd, String interRmk, String spclInstrRmk, String creOfcCd, String creDt, String creUsrId, String updDt, String updUsrId, String deltFlg, String vndrSeq, String trspSoCmbTpCd, String trspSoCmbSeq, String surchargeKey, String agmtOfcCtyCd, String agmtSeq, String agmtRateType, String agmtWayType, String custNomiTrkrFlg, String custCntCd, String custSeq, String amountKind, String refNo) {
		this.toNodCd = toNodCd;
		this.chssMgstBdlSeq = chssMgstBdlSeq;
		this.toNodCdSub = toNodCdSub;
		this.trspSoSeq = trspSoSeq;
		this.dorDeAddr = dorDeAddr;
		this.cgoTpCd = cgoTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blNoChk = blNoChk;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.mltStopDeFlg = mltStopDeFlg;
		this.blNoTp = blNoTp;
		this.trnsRqstOfcCd = trnsRqstOfcCd;
		this.trspSoTpCd = trspSoTpCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.dorNodCdSub = dorNodCdSub;
		this.cntrWgt = cntrWgt;
		this.trspSoCmbTpCd = trspSoCmbTpCd;
		this.trspWoSeq = trspWoSeq;
		this.surchargeKey = surchargeKey;
		this.agmtSeq = agmtSeq;
		this.eqTpszCd = eqTpszCd;
		this.negoAmt = negoAmt;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.trnsRqstRsn = trnsRqstRsn;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.currCd = currCd;
		this.splIssRsn = splIssRsn;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.interRmk = interRmk;
		this.repoRefNo = repoRefNo;
		this.cmdtCd = cmdtCd;
		this.creOfcCd = creOfcCd;
		this.dorSvcTpCd = dorSvcTpCd;
		this.dorNodCd = dorNodCd;
		this.trspSoStsCd = trspSoStsCd;
		this.spclInstrRmk = spclInstrRmk;
		this.trspCrrModCd = trspCrrModCd;
		this.ovrWgtScgAmt = ovrWgtScgAmt;
		this.trnsRqstUsrId = trnsRqstUsrId;
		this.railCmbThruTpCd = railCmbThruTpCd;
		this.updDt = updDt;
		this.etcAddAmt = etcAddAmt;
		this.trspBndCd = trspBndCd;
		this.amountKind = amountKind;
		this.agmtWayType = agmtWayType;
		this.bkgNoSplit = bkgNoSplit;
		this.trspPurpRsn = trspPurpRsn;
		this.custSeq = custSeq;
		this.bzcAmt = bzcAmt;
		this.fmNodCdSub = fmNodCdSub;
		this.fuelScgAmt = fuelScgAmt;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.fmNodCd = fmNodCd;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.viaNodCdSub = viaNodCdSub;
		this.lgsCostCd = lgsCostCd;
		this.refNo = refNo;
		this.repoRefSeq = repoRefSeq;
		this.viaNodCd = viaNodCd;
		this.eqKndCd = eqKndCd;
		this.cmbSoRltStsFlg = cmbSoRltStsFlg;
		this.actGrpCd = actGrpCd;
		this.agmtRateType = agmtRateType;
		this.chssMgstTrspTpCd = chssMgstTrspTpCd;
		this.trspSoCmbSeq = trspSoCmbSeq;
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("chss_mgst_bdl_seq", getChssMgstBdlSeq());
		this.hashColumns.put("to_nod_cd_sub", getToNodCdSub());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("dor_de_addr", getDorDeAddr());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("mlt_stop_de_flg", getMltStopDeFlg());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("trns_rqst_ofc_cd", getTrnsRqstOfcCd());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dor_nod_cd_sub", getDorNodCdSub());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("surcharge_key", getSurchargeKey());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trns_rqst_rsn", getTrnsRqstRsn());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("spl_iss_rsn", getSplIssRsn());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("repo_ref_no", getRepoRefNo());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dor_svc_tp_cd", getDorSvcTpCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("ovr_wgt_scg_amt", getOvrWgtScgAmt());
		this.hashColumns.put("trns_rqst_usr_id", getTrnsRqstUsrId());
		this.hashColumns.put("rail_cmb_thru_tp_cd", getRailCmbThruTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("amount_kind", getAmountKind());
		this.hashColumns.put("agmt_way_type", getAgmtWayType());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("trsp_purp_rsn", getTrspPurpRsn());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("fm_nod_cd_sub", getFmNodCdSub());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("via_nod_cd_sub", getViaNodCdSub());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("repo_ref_seq", getRepoRefSeq());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("cmb_so_rlt_sts_flg", getCmbSoRltStsFlg());
		this.hashColumns.put("act_grp_cd", getActGrpCd());
		this.hashColumns.put("agmt_rate_type", getAgmtRateType());
		this.hashColumns.put("chss_mgst_trsp_tp_cd", getChssMgstTrspTpCd());
		this.hashColumns.put("trsp_so_cmb_seq", getTrspSoCmbSeq());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("chss_mgst_bdl_seq", "chssMgstBdlSeq");
		this.hashFields.put("to_nod_cd_sub", "toNodCdSub");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("dor_de_addr", "dorDeAddr");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("mlt_stop_de_flg", "mltStopDeFlg");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("trns_rqst_ofc_cd", "trnsRqstOfcCd");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dor_nod_cd_sub", "dorNodCdSub");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("surcharge_key", "surchargeKey");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trns_rqst_rsn", "trnsRqstRsn");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("spl_iss_rsn", "splIssRsn");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("repo_ref_no", "repoRefNo");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dor_svc_tp_cd", "dorSvcTpCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("ovr_wgt_scg_amt", "ovrWgtScgAmt");
		this.hashFields.put("trns_rqst_usr_id", "trnsRqstUsrId");
		this.hashFields.put("rail_cmb_thru_tp_cd", "railCmbThruTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("amount_kind", "amountKind");
		this.hashFields.put("agmt_way_type", "agmtWayType");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("trsp_purp_rsn", "trspPurpRsn");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("fm_nod_cd_sub", "fmNodCdSub");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("via_nod_cd_sub", "viaNodCdSub");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("repo_ref_seq", "repoRefSeq");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("eqKndCd", "eqKndCd");
		this.hashFields.put("cmb_so_rlt_sts_flg", "cmbSoRltStsFlg");
		this.hashFields.put("act_grp_cd", "actGrpCd");
		this.hashFields.put("agmt_rate_type", "agmtRateType");
		this.hashFields.put("chss_mgst_trsp_tp_cd", "chssMgstTrspTpCd");
		this.hashFields.put("trsp_so_cmb_seq", "trspSoCmbSeq");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return chssMgstBdlSeq
	 */
	public String getChssMgstBdlSeq() {
		return this.chssMgstBdlSeq;
	}
	
	/**
	 * Column Info
	 * @return toNodCdSub
	 */
	public String getToNodCdSub() {
		return this.toNodCdSub;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return dorDeAddr
	 */
	public String getDorDeAddr() {
		return this.dorDeAddr;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
	}
	
	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return mltStopDeFlg
	 */
	public String getMltStopDeFlg() {
		return this.mltStopDeFlg;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return trnsRqstOfcCd
	 */
	public String getTrnsRqstOfcCd() {
		return this.trnsRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return dorNodCdSub
	 */
	public String getDorNodCdSub() {
		return this.dorNodCdSub;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbTpCd
	 */
	public String getTrspSoCmbTpCd() {
		return this.trspSoCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return surchargeKey
	 */
	public String getSurchargeKey() {
		return this.surchargeKey;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return trnsRqstRsn
	 */
	public String getTrnsRqstRsn() {
		return this.trnsRqstRsn;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return wgtMeasUtCd
	 */
	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return splIssRsn
	 */
	public String getSplIssRsn() {
		return this.splIssRsn;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return repoRefNo
	 */
	public String getRepoRefNo() {
		return this.repoRefNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return dorSvcTpCd
	 */
	public String getDorSvcTpCd() {
		return this.dorSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtScgAmt
	 */
	public String getOvrWgtScgAmt() {
		return this.ovrWgtScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trnsRqstUsrId
	 */
	public String getTrnsRqstUsrId() {
		return this.trnsRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return railCmbThruTpCd
	 */
	public String getRailCmbThruTpCd() {
		return this.railCmbThruTpCd;
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
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return amountKind
	 */
	public String getAmountKind() {
		return this.amountKind;
	}
	
	/**
	 * Column Info
	 * @return agmtWayType
	 */
	public String getAgmtWayType() {
		return this.agmtWayType;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return trspPurpRsn
	 */
	public String getTrspPurpRsn() {
		return this.trspPurpRsn;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}
	
	/**
	 * Column Info
	 * @return fmNodCdSub
	 */
	public String getFmNodCdSub() {
		return this.fmNodCdSub;
	}
	
	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @return viaNodCdSub
	 */
	public String getViaNodCdSub() {
		return this.viaNodCdSub;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return repoRefSeq
	 */
	public String getRepoRefSeq() {
		return this.repoRefSeq;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
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
	 * @return cmbSoRltStsFlg
	 */
	public String getCmbSoRltStsFlg() {
		return this.cmbSoRltStsFlg;
	}
	
	/**
	 * Column Info
	 * @return actGrpCd
	 */
	public String getActGrpCd() {
		return this.actGrpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtRateType
	 */
	public String getAgmtRateType() {
		return this.agmtRateType;
	}
	
	/**
	 * Column Info
	 * @return chssMgstTrspTpCd
	 */
	public String getChssMgstTrspTpCd() {
		return this.chssMgstTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbSeq
	 */
	public String getTrspSoCmbSeq() {
		return this.trspSoCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFlg
	 */
	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param chssMgstBdlSeq
	 */
	public void setChssMgstBdlSeq(String chssMgstBdlSeq) {
		this.chssMgstBdlSeq = chssMgstBdlSeq;
	}
	
	/**
	 * Column Info
	 * @param toNodCdSub
	 */
	public void setToNodCdSub(String toNodCdSub) {
		this.toNodCdSub = toNodCdSub;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param dorDeAddr
	 */
	public void setDorDeAddr(String dorDeAddr) {
		this.dorDeAddr = dorDeAddr;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
	}
	
	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param mltStopDeFlg
	 */
	public void setMltStopDeFlg(String mltStopDeFlg) {
		this.mltStopDeFlg = mltStopDeFlg;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param trnsRqstOfcCd
	 */
	public void setTrnsRqstOfcCd(String trnsRqstOfcCd) {
		this.trnsRqstOfcCd = trnsRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param dorNodCdSub
	 */
	public void setDorNodCdSub(String dorNodCdSub) {
		this.dorNodCdSub = dorNodCdSub;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param trspSoCmbTpCd
	 */
	public void setTrspSoCmbTpCd(String trspSoCmbTpCd) {
		this.trspSoCmbTpCd = trspSoCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param surchargeKey
	 */
	public void setSurchargeKey(String surchargeKey) {
		this.surchargeKey = surchargeKey;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param trnsRqstRsn
	 */
	public void setTrnsRqstRsn(String trnsRqstRsn) {
		this.trnsRqstRsn = trnsRqstRsn;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param wgtMeasUtCd
	 */
	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param splIssRsn
	 */
	public void setSplIssRsn(String splIssRsn) {
		this.splIssRsn = splIssRsn;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param repoRefNo
	 */
	public void setRepoRefNo(String repoRefNo) {
		this.repoRefNo = repoRefNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param dorSvcTpCd
	 */
	public void setDorSvcTpCd(String dorSvcTpCd) {
		this.dorSvcTpCd = dorSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtScgAmt
	 */
	public void setOvrWgtScgAmt(String ovrWgtScgAmt) {
		this.ovrWgtScgAmt = ovrWgtScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trnsRqstUsrId
	 */
	public void setTrnsRqstUsrId(String trnsRqstUsrId) {
		this.trnsRqstUsrId = trnsRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param railCmbThruTpCd
	 */
	public void setRailCmbThruTpCd(String railCmbThruTpCd) {
		this.railCmbThruTpCd = railCmbThruTpCd;
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
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param amountKind
	 */
	public void setAmountKind(String amountKind) {
		this.amountKind = amountKind;
	}
	
	/**
	 * Column Info
	 * @param agmtWayType
	 */
	public void setAgmtWayType(String agmtWayType) {
		this.agmtWayType = agmtWayType;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param trspPurpRsn
	 */
	public void setTrspPurpRsn(String trspPurpRsn) {
		this.trspPurpRsn = trspPurpRsn;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}
	
	/**
	 * Column Info
	 * @param fmNodCdSub
	 */
	public void setFmNodCdSub(String fmNodCdSub) {
		this.fmNodCdSub = fmNodCdSub;
	}
	
	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @param viaNodCdSub
	 */
	public void setViaNodCdSub(String viaNodCdSub) {
		this.viaNodCdSub = viaNodCdSub;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param repoRefSeq
	 */
	public void setRepoRefSeq(String repoRefSeq) {
		this.repoRefSeq = repoRefSeq;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
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
	 * @param cmbSoRltStsFlg
	 */
	public void setCmbSoRltStsFlg(String cmbSoRltStsFlg) {
		this.cmbSoRltStsFlg = cmbSoRltStsFlg;
	}
	
	/**
	 * Column Info
	 * @param actGrpCd
	 */
	public void setActGrpCd(String actGrpCd) {
		this.actGrpCd = actGrpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtRateType
	 */
	public void setAgmtRateType(String agmtRateType) {
		this.agmtRateType = agmtRateType;
	}
	
	/**
	 * Column Info
	 * @param chssMgstTrspTpCd
	 */
	public void setChssMgstTrspTpCd(String chssMgstTrspTpCd) {
		this.chssMgstTrspTpCd = chssMgstTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoCmbSeq
	 */
	public void setTrspSoCmbSeq(String trspSoCmbSeq) {
		this.trspSoCmbSeq = trspSoCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrFlg
	 */
	public void setCustNomiTrkrFlg(String custNomiTrkrFlg) {
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setChssMgstBdlSeq(JSPUtil.getParameter(request, "chss_mgst_bdl_seq", ""));
		setToNodCdSub(JSPUtil.getParameter(request, "to_nod_cd_sub", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setDorDeAddr(JSPUtil.getParameter(request, "dor_de_addr", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, "trsp_cost_dtl_mod_cd", ""));
		setMltStopDeFlg(JSPUtil.getParameter(request, "mlt_stop_de_flg", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setTrnsRqstOfcCd(JSPUtil.getParameter(request, "trns_rqst_ofc_cd", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, "trsp_so_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDorNodCdSub(JSPUtil.getParameter(request, "dor_nod_cd_sub", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, "trsp_so_cmb_tp_cd", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setSurchargeKey(JSPUtil.getParameter(request, "surcharge_key", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, "nego_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTrnsRqstRsn(JSPUtil.getParameter(request, "trns_rqst_rsn", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, "wgt_meas_ut_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSplIssRsn(JSPUtil.getParameter(request, "spl_iss_rsn", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setRepoRefNo(JSPUtil.getParameter(request, "repo_ref_no", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setDorSvcTpCd(JSPUtil.getParameter(request, "dor_svc_tp_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, "dor_nod_cd", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, "trsp_so_sts_cd", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, "spcl_instr_rmk", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, "trsp_crr_mod_cd", ""));
		setOvrWgtScgAmt(JSPUtil.getParameter(request, "ovr_wgt_scg_amt", ""));
		setTrnsRqstUsrId(JSPUtil.getParameter(request, "trns_rqst_usr_id", ""));
		setRailCmbThruTpCd(JSPUtil.getParameter(request, "rail_cmb_thru_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, "etc_add_amt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd", ""));
		setAmountKind(JSPUtil.getParameter(request, "amount_kind", ""));
		setAgmtWayType(JSPUtil.getParameter(request, "agmt_way_type", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setTrspPurpRsn(JSPUtil.getParameter(request, "trsp_purp_rsn", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setBzcAmt(JSPUtil.getParameter(request, "bzc_amt", ""));
		setFmNodCdSub(JSPUtil.getParameter(request, "fm_nod_cd_sub", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, "fuel_scg_amt", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, "n3pty_bil_flg", ""));
		setViaNodCdSub(JSPUtil.getParameter(request, "via_nod_cd_sub", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setRepoRefSeq(JSPUtil.getParameter(request, "repo_ref_seq", ""));
		setViaNodCd(JSPUtil.getParameter(request, "via_nod_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCmbSoRltStsFlg(JSPUtil.getParameter(request, "cmb_so_rlt_sts_flg", ""));
		setActGrpCd(JSPUtil.getParameter(request, "act_grp_cd", ""));
		setAgmtRateType(JSPUtil.getParameter(request, "agmt_rate_type", ""));
		setChssMgstTrspTpCd(JSPUtil.getParameter(request, "chss_mgst_trsp_tp_cd", ""));
		setTrspSoCmbSeq(JSPUtil.getParameter(request, "trsp_so_cmb_seq", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, "cust_nomi_trkr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SupplementVO[]
	 */
	public SupplementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SupplementVO[]
	 */
	public SupplementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SupplementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] chssMgstBdlSeq = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_bdl_seq", length));
			String[] toNodCdSub = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd_sub", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] dorDeAddr = (JSPUtil.getParameter(request, prefix	+ "dor_de_addr", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] mltStopDeFlg = (JSPUtil.getParameter(request, prefix	+ "mlt_stop_de_flg", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] trnsRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_rqst_ofc_cd", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dorNodCdSub = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd_sub", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_cd", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] surchargeKey = (JSPUtil.getParameter(request, prefix	+ "surcharge_key", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trnsRqstRsn = (JSPUtil.getParameter(request, prefix	+ "trns_rqst_rsn", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_meas_ut_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] splIssRsn = (JSPUtil.getParameter(request, prefix	+ "spl_iss_rsn", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] repoRefNo = (JSPUtil.getParameter(request, prefix	+ "repo_ref_no", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dorSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "dor_svc_tp_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] ovrWgtScgAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_scg_amt", length));
			String[] trnsRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_rqst_usr_id", length));
			String[] railCmbThruTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_cmb_thru_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] amountKind = (JSPUtil.getParameter(request, prefix	+ "amount_kind", length));
			String[] agmtWayType = (JSPUtil.getParameter(request, prefix	+ "agmt_way_type", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] trspPurpRsn = (JSPUtil.getParameter(request, prefix	+ "trsp_purp_rsn", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] fmNodCdSub = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd_sub", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] viaNodCdSub = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd_sub", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] repoRefSeq = (JSPUtil.getParameter(request, prefix	+ "repo_ref_seq", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] cmbSoRltStsFlg = (JSPUtil.getParameter(request, prefix	+ "cmb_so_rlt_sts_flg", length));
			String[] actGrpCd = (JSPUtil.getParameter(request, prefix	+ "act_grp_cd", length));
			String[] agmtRateType = (JSPUtil.getParameter(request, prefix	+ "agmt_rate_type", length));
			String[] chssMgstTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_trsp_tp_cd", length));
			String[] trspSoCmbSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_seq", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SupplementVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (chssMgstBdlSeq[i] != null)
					model.setChssMgstBdlSeq(chssMgstBdlSeq[i]);
				if (toNodCdSub[i] != null)
					model.setToNodCdSub(toNodCdSub[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (dorDeAddr[i] != null)
					model.setDorDeAddr(dorDeAddr[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (mltStopDeFlg[i] != null)
					model.setMltStopDeFlg(mltStopDeFlg[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (trnsRqstOfcCd[i] != null)
					model.setTrnsRqstOfcCd(trnsRqstOfcCd[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dorNodCdSub[i] != null)
					model.setDorNodCdSub(dorNodCdSub[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (surchargeKey[i] != null)
					model.setSurchargeKey(surchargeKey[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trnsRqstRsn[i] != null)
					model.setTrnsRqstRsn(trnsRqstRsn[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (splIssRsn[i] != null)
					model.setSplIssRsn(splIssRsn[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (repoRefNo[i] != null)
					model.setRepoRefNo(repoRefNo[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dorSvcTpCd[i] != null)
					model.setDorSvcTpCd(dorSvcTpCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (ovrWgtScgAmt[i] != null)
					model.setOvrWgtScgAmt(ovrWgtScgAmt[i]);
				if (trnsRqstUsrId[i] != null)
					model.setTrnsRqstUsrId(trnsRqstUsrId[i]);
				if (railCmbThruTpCd[i] != null)
					model.setRailCmbThruTpCd(railCmbThruTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (amountKind[i] != null)
					model.setAmountKind(amountKind[i]);
				if (agmtWayType[i] != null)
					model.setAgmtWayType(agmtWayType[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (trspPurpRsn[i] != null)
					model.setTrspPurpRsn(trspPurpRsn[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (fmNodCdSub[i] != null)
					model.setFmNodCdSub(fmNodCdSub[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (viaNodCdSub[i] != null)
					model.setViaNodCdSub(viaNodCdSub[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (repoRefSeq[i] != null)
					model.setRepoRefSeq(repoRefSeq[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (cmbSoRltStsFlg[i] != null)
					model.setCmbSoRltStsFlg(cmbSoRltStsFlg[i]);
				if (actGrpCd[i] != null)
					model.setActGrpCd(actGrpCd[i]);
				if (agmtRateType[i] != null)
					model.setAgmtRateType(agmtRateType[i]);
				if (chssMgstTrspTpCd[i] != null)
					model.setChssMgstTrspTpCd(chssMgstTrspTpCd[i]);
				if (trspSoCmbSeq[i] != null)
					model.setTrspSoCmbSeq(trspSoCmbSeq[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSupplementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SupplementVO[]
	 */
	public SupplementVO[] getSupplementVOs(){
		SupplementVO[] vos = (SupplementVO[])models.toArray(new SupplementVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstBdlSeq = this.chssMgstBdlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCdSub = this.toNodCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorDeAddr = this.dorDeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltStopDeFlg = this.mltStopDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRqstOfcCd = this.trnsRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCdSub = this.dorNodCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeKey = this.surchargeKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRqstRsn = this.trnsRqstRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splIssRsn = this.splIssRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRefNo = this.repoRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorSvcTpCd = this.dorSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtScgAmt = this.ovrWgtScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRqstUsrId = this.trnsRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCmbThruTpCd = this.railCmbThruTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountKind = this.amountKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWayType = this.agmtWayType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspPurpRsn = this.trspPurpRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCdSub = this.fmNodCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCdSub = this.viaNodCdSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRefSeq = this.repoRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbSoRltStsFlg = this.cmbSoRltStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGrpCd = this.actGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRateType = this.agmtRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstTrspTpCd = this.chssMgstTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbSeq = this.trspSoCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
