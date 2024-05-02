/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DmtChgCalcVO.java
*@FileTitle : DmtChgCalcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.02.17 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtChgCalcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtChgCalcVO> models = new ArrayList<DmtChgCalcVO>();
	
	/* Column Info */
	private String corrRmk = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String fmMvmtYr = null;
	/* Column Info */
	private String dulTpExptFlg = null;
	/* Column Info */
	private String webCreDt = null;
	/* Column Info */
	private String deltOfcCd = null;
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String cmdtOvrDys = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cmdtTrfSeq = null;
	/* Column Info */
	private String aftExptAmt = null;
	/* Column Info */
	private String toMvmtSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String aftExptAproNo = null;
	/* Column Info */
	private String rlseOfc = null;
	/* Column Info */
	private String scRfaExptOvrDys = null;
	/* Column Info */
	private String bzcTrfAplyDt = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String li = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dO = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String bzcTrfSeq = null;
	/* Column Info */
	private String ch = null;
	/* Column Info */
	private String cxlBkgChgFlg = null;
	/* Column Info */
	private String webCreUsrId = null;
	/* Column Info */
	private String dmdtArIfCd = null;
	/* Column Info */
	private String rollOvr = null;
	/* Column Info */
	private String scRfaExptAplyDt = null;
	/* Column Info */
	private String notCreBalFlg = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String cntrInvAmt = null;
	/* Column Info */
	private String rfaExptAproNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String cmdtExptAplyDt = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String toMvmtYr = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String aftExptOvrDys = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String webNtfyPicNm = null;
	/* Column Info */
	private String bzcTrfGrpSeq = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String webIndFlg = null;
	/* Column Info */
	private String cmdtExptAmt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String webNtfyPicTelcmNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String chgType = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String fmMvmtSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String webMtyDt = null;
	/* Column Info */
	private String orgFtOvrDys = null;
	/* Column Info */
	private String toMvmtSplitNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fmMvmtSplitNo = null;
	/* Column Info */
	private String scRfaAmt = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String uclmFlg = null;
	/* Column Number */
	private String bzcDmdtDeTermCd = null;
	/* Column Number */
	private String bzcDmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtChgCalcVO() {}

	public DmtChgCalcVO(String ibflag, String pagerows, String bkgNo, String blNo, String svrId, String dmdtChgStsCd, String cntrNo, String cntrCycNo, String dmdtChgLocDivCd, String ofcCd, String ofcRhqCd, String chgSeq, String cntrTpszCd, String fmMvmtYdCd, String toMvmtYdCd, String fmMvmtStsCd, String toMvmtStsCd, String dmdtTrfCd, String ftDys, String fxFtOvrDys, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String bzcTrfCurrCd, String orgChgAmt, String scRfaExptAmt, String aftExptDcAmt, String bilAmt, String chgType, String socFlg, String li, String ch, String dO, String rlseOfc, String cltOfcCd, String ofcTrnsFlg, String rollOvr, String dmdtInvNo, String issDt, String invCurrCd, String cntrInvAmt, String dmdtArIfCd, String webIndFlg, String webCreDt, String webMtyDt, String webNtfyPicNm, String dulTpExptFlg, String cxlBkgChgFlg, String notCreBalFlg, String orgFtOvrDys, String scRfaExptOvrDys, String aftExptOvrDys, String dmdtTrfAplyTpCd, String scRfaAmt, String aftExptAmt, String bzcTrfSeq, String bzcTrfGrpSeq, String bzcTrfAplyDt, String rfaExptAproNo, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String aftExptAproNo, String aftExptDarNo, String aftExptAdjSeq, String scNo, String scExptVerSeq, String scExptGrpSeq, String scRfaExptAplyDt, String corrRmk, String cmdtCd, String cmdtTrfSeq, String cmdtExptAplyDt, String cmdtOvrDys, String cmdtExptAmt, String creUsrId, String creOfcCd, String updDt, String updUsrId, String updOfcCd, String deltUsrId, String deltOfcCd, String custCntCd, String custSeq, String actCntCd, String actCustSeq, String fmMvmtYr, String fmMvmtSeq, String fmMvmtSplitNo, String toMvmtYr, String toMvmtSeq, String toMvmtSplitNo, String webNtfyPicTelcmNo, String webCreUsrId, String uclmFlg, String bzcDmdtDeTermCd, String bzcDmdtDeTermNm) {
		this.corrRmk = corrRmk;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.fmMvmtYr = fmMvmtYr;
		this.dulTpExptFlg = dulTpExptFlg;
		this.webCreDt = webCreDt;
		this.deltOfcCd = deltOfcCd;
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.aftExptDcAmt = aftExptDcAmt;
		this.scExptVerSeq = scExptVerSeq;
		this.cltOfcCd = cltOfcCd;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.cmdtOvrDys = cmdtOvrDys;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.scNo = scNo;
		this.rfaExptDarNo = rfaExptDarNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cmdtTrfSeq = cmdtTrfSeq;
		this.aftExptAmt = aftExptAmt;
		this.toMvmtSeq = toMvmtSeq;
		this.custCntCd = custCntCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.aftExptAproNo = aftExptAproNo;
		this.rlseOfc = rlseOfc;
		this.scRfaExptOvrDys = scRfaExptOvrDys;
		this.bzcTrfAplyDt = bzcTrfAplyDt;
		this.ftCmncDt = ftCmncDt;
		this.li = li;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.dO = dO;
		this.fmMvmtDt = fmMvmtDt;
		this.bzcTrfSeq = bzcTrfSeq;
		this.ch = ch;
		this.cxlBkgChgFlg = cxlBkgChgFlg;
		this.webCreUsrId = webCreUsrId;
		this.dmdtArIfCd = dmdtArIfCd;
		this.rollOvr = rollOvr;
		this.scRfaExptAplyDt = scRfaExptAplyDt;
		this.notCreBalFlg = notCreBalFlg;
		this.cntrCycNo = cntrCycNo;
		this.scRfaExptAmt = scRfaExptAmt;
		this.cntrInvAmt = cntrInvAmt;
		this.rfaExptAproNo = rfaExptAproNo;
		this.chgSeq = chgSeq;
		this.cmdtExptAplyDt = cmdtExptAplyDt;
		this.bilAmt = bilAmt;
		this.toMvmtYr = toMvmtYr;
		this.svrId = svrId;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.actCntCd = actCntCd;
		this.cmdtCd = cmdtCd;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.aftExptOvrDys = aftExptOvrDys;
		this.creOfcCd = creOfcCd;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.webNtfyPicNm = webNtfyPicNm;
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
		this.ftEndDt = ftEndDt;
		this.webIndFlg = webIndFlg;
		this.cmdtExptAmt = cmdtExptAmt;
		this.toMvmtDt = toMvmtDt;
		this.webNtfyPicTelcmNo = webNtfyPicTelcmNo;
		this.updDt = updDt;
		this.ofcRhqCd = ofcRhqCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.chgType = chgType;
		this.toMvmtStsCd = toMvmtStsCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.actCustSeq = actCustSeq;
		this.dmdtInvNo = dmdtInvNo;
		this.fmMvmtSeq = fmMvmtSeq;
		this.custSeq = custSeq;
		this.scExptGrpSeq = scExptGrpSeq;
		this.invCurrCd = invCurrCd;
		this.socFlg = socFlg;
		this.ofcCd = ofcCd;
		this.ftDys = ftDys;
		this.webMtyDt = webMtyDt;
		this.orgFtOvrDys = orgFtOvrDys;
		this.toMvmtSplitNo = toMvmtSplitNo;
		this.cntrNo = cntrNo;
		this.fmMvmtSplitNo = fmMvmtSplitNo;
		this.scRfaAmt = scRfaAmt;
		this.orgChgAmt = orgChgAmt;
		this.toMvmtYdCd = toMvmtYdCd;
		this.deltUsrId = deltUsrId;
		this.uclmFlg = uclmFlg;
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_rmk", getCorrRmk());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("fm_mvmt_yr", getFmMvmtYr());
		this.hashColumns.put("dul_tp_expt_flg", getDulTpExptFlg());
		this.hashColumns.put("web_cre_dt", getWebCreDt());
		this.hashColumns.put("delt_ofc_cd", getDeltOfcCd());
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("cmdt_ovr_dys", getCmdtOvrDys());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cmdt_trf_seq", getCmdtTrfSeq());
		this.hashColumns.put("aft_expt_amt", getAftExptAmt());
		this.hashColumns.put("to_mvmt_seq", getToMvmtSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("aft_expt_apro_no", getAftExptAproNo());
		this.hashColumns.put("rlse_ofc", getRlseOfc());
		this.hashColumns.put("sc_rfa_expt_ovr_dys", getScRfaExptOvrDys());
		this.hashColumns.put("bzc_trf_aply_dt", getBzcTrfAplyDt());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("li", getLi());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("d_o", getDO());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("bzc_trf_seq", getBzcTrfSeq());
		this.hashColumns.put("ch", getCh());
		this.hashColumns.put("cxl_bkg_chg_flg", getCxlBkgChgFlg());
		this.hashColumns.put("web_cre_usr_id", getWebCreUsrId());
		this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
		this.hashColumns.put("roll_ovr", getRollOvr());
		this.hashColumns.put("sc_rfa_expt_aply_dt", getScRfaExptAplyDt());
		this.hashColumns.put("not_cre_bal_flg", getNotCreBalFlg());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("cntr_inv_amt", getCntrInvAmt());
		this.hashColumns.put("rfa_expt_apro_no", getRfaExptAproNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("cmdt_expt_aply_dt", getCmdtExptAplyDt());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("to_mvmt_yr", getToMvmtYr());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("aft_expt_ovr_dys", getAftExptOvrDys());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("web_ntfy_pic_nm", getWebNtfyPicNm());
		this.hashColumns.put("bzc_trf_grp_seq", getBzcTrfGrpSeq());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("web_ind_flg", getWebIndFlg());
		this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("web_ntfy_pic_telcm_no", getWebNtfyPicTelcmNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("fm_mvmt_seq", getFmMvmtSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("web_mty_dt", getWebMtyDt());
		this.hashColumns.put("org_ft_ovr_dys", getOrgFtOvrDys());
		this.hashColumns.put("to_mvmt_split_no", getToMvmtSplitNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fm_mvmt_split_no", getFmMvmtSplitNo());
		this.hashColumns.put("sc_rfa_amt", getScRfaAmt());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("uclm_flg", getUclmFlg());
		this.hashColumns.put("bzc_dmdt_de_term_cd", getBzcDmdtDeTermCd());
		this.hashColumns.put("bzc_dmdt_de_term_nm", getBzcDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_rmk", "corrRmk");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("fm_mvmt_yr", "fmMvmtYr");
		this.hashFields.put("dul_tp_expt_flg", "dulTpExptFlg");
		this.hashFields.put("web_cre_dt", "webCreDt");
		this.hashFields.put("delt_ofc_cd", "deltOfcCd");
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("cmdt_ovr_dys", "cmdtOvrDys");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cmdt_trf_seq", "cmdtTrfSeq");
		this.hashFields.put("aft_expt_amt", "aftExptAmt");
		this.hashFields.put("to_mvmt_seq", "toMvmtSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("aft_expt_apro_no", "aftExptAproNo");
		this.hashFields.put("rlse_ofc", "rlseOfc");
		this.hashFields.put("sc_rfa_expt_ovr_dys", "scRfaExptOvrDys");
		this.hashFields.put("bzc_trf_aply_dt", "bzcTrfAplyDt");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("li", "li");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("d_o", "dO");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("bzc_trf_seq", "bzcTrfSeq");
		this.hashFields.put("ch", "ch");
		this.hashFields.put("cxl_bkg_chg_flg", "cxlBkgChgFlg");
		this.hashFields.put("web_cre_usr_id", "webCreUsrId");
		this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
		this.hashFields.put("roll_ovr", "rollOvr");
		this.hashFields.put("sc_rfa_expt_aply_dt", "scRfaExptAplyDt");
		this.hashFields.put("not_cre_bal_flg", "notCreBalFlg");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("cntr_inv_amt", "cntrInvAmt");
		this.hashFields.put("rfa_expt_apro_no", "rfaExptAproNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("cmdt_expt_aply_dt", "cmdtExptAplyDt");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("to_mvmt_yr", "toMvmtYr");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("aft_expt_ovr_dys", "aftExptOvrDys");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("web_ntfy_pic_nm", "webNtfyPicNm");
		this.hashFields.put("bzc_trf_grp_seq", "bzcTrfGrpSeq");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("web_ind_flg", "webIndFlg");
		this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("web_ntfy_pic_telcm_no", "webNtfyPicTelcmNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("fm_mvmt_seq", "fmMvmtSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("web_mty_dt", "webMtyDt");
		this.hashFields.put("org_ft_ovr_dys", "orgFtOvrDys");
		this.hashFields.put("to_mvmt_split_no", "toMvmtSplitNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fm_mvmt_split_no", "fmMvmtSplitNo");
		this.hashFields.put("sc_rfa_amt", "scRfaAmt");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("uclm_flg", "uclmFlg");
		this.hashFields.put("bzc_dmdt_de_term_cd", "bzcDmdtDeTermCd");
		this.hashFields.put("bzc_dmdt_de_term_nm", "bzcDmdtDeTermNm");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrRmk
	 */
	public String getCorrRmk() {
		return this.corrRmk;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return this.bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYr
	 */
	public String getFmMvmtYr() {
		return this.fmMvmtYr;
	}
	
	/**
	 * Column Info
	 * @return dulTpExptFlg
	 */
	public String getDulTpExptFlg() {
		return this.dulTpExptFlg;
	}
	
	/**
	 * Column Info
	 * @return webCreDt
	 */
	public String getWebCreDt() {
		return this.webCreDt;
	}
	
	/**
	 * Column Info
	 * @return deltOfcCd
	 */
	public String getDeltOfcCd() {
		return this.deltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTrnsFlg
	 */
	public String getOfcTrnsFlg() {
		return this.ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return aftExptDcAmt
	 */
	public String getAftExptDcAmt() {
		return this.aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aftExptAdjSeq
	 */
	public String getAftExptAdjSeq() {
		return this.aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfAplyTpCd
	 */
	public String getDmdtTrfAplyTpCd() {
		return this.dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtOvrDys
	 */
	public String getCmdtOvrDys() {
		return this.cmdtOvrDys;
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
	 * @return fxFtOvrDys
	 */
	public String getFxFtOvrDys() {
		return this.fxFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtTrfSeq
	 */
	public String getCmdtTrfSeq() {
		return this.cmdtTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return aftExptAmt
	 */
	public String getAftExptAmt() {
		return this.aftExptAmt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtSeq
	 */
	public String getToMvmtSeq() {
		return this.toMvmtSeq;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return aftExptAproNo
	 */
	public String getAftExptAproNo() {
		return this.aftExptAproNo;
	}
	
	/**
	 * Column Info
	 * @return rlseOfc
	 */
	public String getRlseOfc() {
		return this.rlseOfc;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptOvrDys
	 */
	public String getScRfaExptOvrDys() {
		return this.scRfaExptOvrDys;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfAplyDt
	 */
	public String getBzcTrfAplyDt() {
		return this.bzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @return ftCmncDt
	 */
	public String getFtCmncDt() {
		return this.ftCmncDt;
	}
	
	/**
	 * Column Info
	 * @return li
	 */
	public String getLi() {
		return this.li;
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
	 * @return dO
	 */
	public String getDO() {
		return this.dO;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfSeq
	 */
	public String getBzcTrfSeq() {
		return this.bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return ch
	 */
	public String getCh() {
		return this.ch;
	}
	
	/**
	 * Column Info
	 * @return cxlBkgChgFlg
	 */
	public String getCxlBkgChgFlg() {
		return this.cxlBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @return webCreUsrId
	 */
	public String getWebCreUsrId() {
		return this.webCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return dmdtArIfCd
	 */
	public String getDmdtArIfCd() {
		return this.dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @return rollOvr
	 */
	public String getRollOvr() {
		return this.rollOvr;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAplyDt
	 */
	public String getScRfaExptAplyDt() {
		return this.scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @return notCreBalFlg
	 */
	public String getNotCreBalFlg() {
		return this.notCreBalFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrInvAmt
	 */
	public String getCntrInvAmt() {
		return this.cntrInvAmt;
	}
	
	/**
	 * Column Info
	 * @return rfaExptAproNo
	 */
	public String getRfaExptAproNo() {
		return this.rfaExptAproNo;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtExptAplyDt
	 */
	public String getCmdtExptAplyDt() {
		return this.cmdtExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYr
	 */
	public String getToMvmtYr() {
		return this.toMvmtYr;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return aftExptOvrDys
	 */
	public String getAftExptOvrDys() {
		return this.aftExptOvrDys;
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
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return webNtfyPicNm
	 */
	public String getWebNtfyPicNm() {
		return this.webNtfyPicNm;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfGrpSeq
	 */
	public String getBzcTrfGrpSeq() {
		return this.bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return webIndFlg
	 */
	public String getWebIndFlg() {
		return this.webIndFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtExptAmt
	 */
	public String getCmdtExptAmt() {
		return this.cmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return webNtfyPicTelcmNo
	 */
	public String getWebNtfyPicTelcmNo() {
		return this.webNtfyPicTelcmNo;
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
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return this.ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return chgType
	 */
	public String getChgType() {
		return this.chgType;
	}
	
	/**
	 * Column Info
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtSeq
	 */
	public String getFmMvmtSeq() {
		return this.fmMvmtSeq;
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
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
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
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return webMtyDt
	 */
	public String getWebMtyDt() {
		return this.webMtyDt;
	}
	
	/**
	 * Column Info
	 * @return orgFtOvrDys
	 */
	public String getOrgFtOvrDys() {
		return this.orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return toMvmtSplitNo
	 */
	public String getToMvmtSplitNo() {
		return this.toMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtSplitNo
	 */
	public String getFmMvmtSplitNo() {
		return this.fmMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @return scRfaAmt
	 */
	public String getScRfaAmt() {
		return this.scRfaAmt;
	}
	
	/**
	 * Column Info
	 * @return orgChgAmt
	 */
	public String getOrgChgAmt() {
		return this.orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public String getUclmFlg() {
		return this.uclmFlg;
	}
	
	/**
	 * Column Info
	 * @return bzcDmdtDeTermCd
	 */
	public String getBzcDmdtDeTermCd() {
		return this.bzcDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return bzcDmdtDeTermNm
	 */
	public String getBzcDmdtDeTermNm() {
		return this.bzcDmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param corrRmk
	 */
	public void setCorrRmk(String corrRmk) {
		this.corrRmk = corrRmk;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYr
	 */
	public void setFmMvmtYr(String fmMvmtYr) {
		this.fmMvmtYr = fmMvmtYr;
	}
	
	/**
	 * Column Info
	 * @param dulTpExptFlg
	 */
	public void setDulTpExptFlg(String dulTpExptFlg) {
		this.dulTpExptFlg = dulTpExptFlg;
	}
	
	/**
	 * Column Info
	 * @param webCreDt
	 */
	public void setWebCreDt(String webCreDt) {
		this.webCreDt = webCreDt;
	}
	
	/**
	 * Column Info
	 * @param deltOfcCd
	 */
	public void setDeltOfcCd(String deltOfcCd) {
		this.deltOfcCd = deltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTrnsFlg
	 */
	public void setOfcTrnsFlg(String ofcTrnsFlg) {
		this.ofcTrnsFlg = ofcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param aftExptDcAmt
	 */
	public void setAftExptDcAmt(String aftExptDcAmt) {
		this.aftExptDcAmt = aftExptDcAmt;
	}
	
	/**
	 * Column Info
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aftExptAdjSeq
	 */
	public void setAftExptAdjSeq(String aftExptAdjSeq) {
		this.aftExptAdjSeq = aftExptAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfAplyTpCd
	 */
	public void setDmdtTrfAplyTpCd(String dmdtTrfAplyTpCd) {
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtOvrDys
	 */
	public void setCmdtOvrDys(String cmdtOvrDys) {
		this.cmdtOvrDys = cmdtOvrDys;
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
	 * @param fxFtOvrDys
	 */
	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtTrfSeq
	 */
	public void setCmdtTrfSeq(String cmdtTrfSeq) {
		this.cmdtTrfSeq = cmdtTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param aftExptAmt
	 */
	public void setAftExptAmt(String aftExptAmt) {
		this.aftExptAmt = aftExptAmt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtSeq
	 */
	public void setToMvmtSeq(String toMvmtSeq) {
		this.toMvmtSeq = toMvmtSeq;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param aftExptAproNo
	 */
	public void setAftExptAproNo(String aftExptAproNo) {
		this.aftExptAproNo = aftExptAproNo;
	}
	
	/**
	 * Column Info
	 * @param rlseOfc
	 */
	public void setRlseOfc(String rlseOfc) {
		this.rlseOfc = rlseOfc;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptOvrDys
	 */
	public void setScRfaExptOvrDys(String scRfaExptOvrDys) {
		this.scRfaExptOvrDys = scRfaExptOvrDys;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfAplyDt
	 */
	public void setBzcTrfAplyDt(String bzcTrfAplyDt) {
		this.bzcTrfAplyDt = bzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @param ftCmncDt
	 */
	public void setFtCmncDt(String ftCmncDt) {
		this.ftCmncDt = ftCmncDt;
	}
	
	/**
	 * Column Info
	 * @param li
	 */
	public void setLi(String li) {
		this.li = li;
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
	 * @param dO
	 */
	public void setDO(String dO) {
		this.dO = dO;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfSeq
	 */
	public void setBzcTrfSeq(String bzcTrfSeq) {
		this.bzcTrfSeq = bzcTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param ch
	 */
	public void setCh(String ch) {
		this.ch = ch;
	}
	
	/**
	 * Column Info
	 * @param cxlBkgChgFlg
	 */
	public void setCxlBkgChgFlg(String cxlBkgChgFlg) {
		this.cxlBkgChgFlg = cxlBkgChgFlg;
	}
	
	/**
	 * Column Info
	 * @param webCreUsrId
	 */
	public void setWebCreUsrId(String webCreUsrId) {
		this.webCreUsrId = webCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param dmdtArIfCd
	 */
	public void setDmdtArIfCd(String dmdtArIfCd) {
		this.dmdtArIfCd = dmdtArIfCd;
	}
	
	/**
	 * Column Info
	 * @param rollOvr
	 */
	public void setRollOvr(String rollOvr) {
		this.rollOvr = rollOvr;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAplyDt
	 */
	public void setScRfaExptAplyDt(String scRfaExptAplyDt) {
		this.scRfaExptAplyDt = scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @param notCreBalFlg
	 */
	public void setNotCreBalFlg(String notCreBalFlg) {
		this.notCreBalFlg = notCreBalFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrInvAmt
	 */
	public void setCntrInvAmt(String cntrInvAmt) {
		this.cntrInvAmt = cntrInvAmt;
	}
	
	/**
	 * Column Info
	 * @param rfaExptAproNo
	 */
	public void setRfaExptAproNo(String rfaExptAproNo) {
		this.rfaExptAproNo = rfaExptAproNo;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtExptAplyDt
	 */
	public void setCmdtExptAplyDt(String cmdtExptAplyDt) {
		this.cmdtExptAplyDt = cmdtExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYr
	 */
	public void setToMvmtYr(String toMvmtYr) {
		this.toMvmtYr = toMvmtYr;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param aftExptOvrDys
	 */
	public void setAftExptOvrDys(String aftExptOvrDys) {
		this.aftExptOvrDys = aftExptOvrDys;
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
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param webNtfyPicNm
	 */
	public void setWebNtfyPicNm(String webNtfyPicNm) {
		this.webNtfyPicNm = webNtfyPicNm;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfGrpSeq
	 */
	public void setBzcTrfGrpSeq(String bzcTrfGrpSeq) {
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param webIndFlg
	 */
	public void setWebIndFlg(String webIndFlg) {
		this.webIndFlg = webIndFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtExptAmt
	 */
	public void setCmdtExptAmt(String cmdtExptAmt) {
		this.cmdtExptAmt = cmdtExptAmt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param webNtfyPicTelcmNo
	 */
	public void setWebNtfyPicTelcmNo(String webNtfyPicTelcmNo) {
		this.webNtfyPicTelcmNo = webNtfyPicTelcmNo;
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
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param chgType
	 */
	public void setChgType(String chgType) {
		this.chgType = chgType;
	}
	
	/**
	 * Column Info
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtSeq
	 */
	public void setFmMvmtSeq(String fmMvmtSeq) {
		this.fmMvmtSeq = fmMvmtSeq;
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
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
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
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param webMtyDt
	 */
	public void setWebMtyDt(String webMtyDt) {
		this.webMtyDt = webMtyDt;
	}
	
	/**
	 * Column Info
	 * @param orgFtOvrDys
	 */
	public void setOrgFtOvrDys(String orgFtOvrDys) {
		this.orgFtOvrDys = orgFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param toMvmtSplitNo
	 */
	public void setToMvmtSplitNo(String toMvmtSplitNo) {
		this.toMvmtSplitNo = toMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtSplitNo
	 */
	public void setFmMvmtSplitNo(String fmMvmtSplitNo) {
		this.fmMvmtSplitNo = fmMvmtSplitNo;
	}
	
	/**
	 * Column Info
	 * @param scRfaAmt
	 */
	public void setScRfaAmt(String scRfaAmt) {
		this.scRfaAmt = scRfaAmt;
	}
	
	/**
	 * Column Info
	 * @param orgChgAmt
	 */
	public void setOrgChgAmt(String orgChgAmt) {
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * Column Info
	 * @param uclmFlg
	 */
	public void setUclmFlg(String uclmFlg) {
		this.uclmFlg = uclmFlg;
	}
	
	/**
	 * Column Info
	 * @param bzcDmdtDeTermCd
	 */
	public void setBzcDmdtDeTermCd(String bzcDmdtDeTermCd) {
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param bzcDmdtDeTermNm
	 */
	public void setBzcDmdtDeTermNm(String bzcDmdtDeTermNm) {
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
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
		setCorrRmk(JSPUtil.getParameter(request, prefix + "corr_rmk", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setFmMvmtYr(JSPUtil.getParameter(request, prefix + "fm_mvmt_yr", ""));
		setDulTpExptFlg(JSPUtil.getParameter(request, prefix + "dul_tp_expt_flg", ""));
		setWebCreDt(JSPUtil.getParameter(request, prefix + "web_cre_dt", ""));
		setDeltOfcCd(JSPUtil.getParameter(request, prefix + "delt_ofc_cd", ""));
		setOfcTrnsFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_flg", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, prefix + "sc_expt_ver_seq", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, prefix + "aft_expt_adj_seq", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_aply_tp_cd", ""));
		setCmdtOvrDys(JSPUtil.getParameter(request, prefix + "cmdt_ovr_dys", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCmdtTrfSeq(JSPUtil.getParameter(request, prefix + "cmdt_trf_seq", ""));
		setAftExptAmt(JSPUtil.getParameter(request, prefix + "aft_expt_amt", ""));
		setToMvmtSeq(JSPUtil.getParameter(request, prefix + "to_mvmt_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setAftExptAproNo(JSPUtil.getParameter(request, prefix + "aft_expt_apro_no", ""));
		setRlseOfc(JSPUtil.getParameter(request, prefix + "rlse_ofc", ""));
		setScRfaExptOvrDys(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_ovr_dys", ""));
		setBzcTrfAplyDt(JSPUtil.getParameter(request, prefix + "bzc_trf_aply_dt", ""));
		setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
		setLi(JSPUtil.getParameter(request, prefix + "li", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDO(JSPUtil.getParameter(request, prefix + "d_o", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setBzcTrfSeq(JSPUtil.getParameter(request, prefix + "bzc_trf_seq", ""));
		setCh(JSPUtil.getParameter(request, prefix + "ch", ""));
		setCxlBkgChgFlg(JSPUtil.getParameter(request, prefix + "cxl_bkg_chg_flg", ""));
		setWebCreUsrId(JSPUtil.getParameter(request, prefix + "web_cre_usr_id", ""));
		setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
		setRollOvr(JSPUtil.getParameter(request, prefix + "roll_ovr", ""));
		setScRfaExptAplyDt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_aply_dt", ""));
		setNotCreBalFlg(JSPUtil.getParameter(request, prefix + "not_cre_bal_flg", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
		setCntrInvAmt(JSPUtil.getParameter(request, prefix + "cntr_inv_amt", ""));
		setRfaExptAproNo(JSPUtil.getParameter(request, prefix + "rfa_expt_apro_no", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setCmdtExptAplyDt(JSPUtil.getParameter(request, prefix + "cmdt_expt_aply_dt", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setToMvmtYr(JSPUtil.getParameter(request, prefix + "to_mvmt_yr", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", ""));
		setAftExptOvrDys(JSPUtil.getParameter(request, prefix + "aft_expt_ovr_dys", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", ""));
		setWebNtfyPicNm(JSPUtil.getParameter(request, prefix + "web_ntfy_pic_nm", ""));
		setBzcTrfGrpSeq(JSPUtil.getParameter(request, prefix + "bzc_trf_grp_seq", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setWebIndFlg(JSPUtil.getParameter(request, prefix + "web_ind_flg", ""));
		setCmdtExptAmt(JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setWebNtfyPicTelcmNo(JSPUtil.getParameter(request, prefix + "web_ntfy_pic_telcm_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setFmMvmtSeq(JSPUtil.getParameter(request, prefix + "fm_mvmt_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, prefix + "sc_expt_grp_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
		setWebMtyDt(JSPUtil.getParameter(request, prefix + "web_mty_dt", ""));
		setOrgFtOvrDys(JSPUtil.getParameter(request, prefix + "org_ft_ovr_dys", ""));
		setToMvmtSplitNo(JSPUtil.getParameter(request, prefix + "to_mvmt_split_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFmMvmtSplitNo(JSPUtil.getParameter(request, prefix + "fm_mvmt_split_no", ""));
		setScRfaAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_amt", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setUclmFlg(JSPUtil.getParameter(request, prefix + "uclm_flg", ""));
		setBzcDmdtDeTermCd(JSPUtil.getParameter(request, prefix + "bzc_dmdt_de_term_cd", ""));
		setBzcDmdtDeTermNm(JSPUtil.getParameter(request, prefix + "bzc_dmdt_de_term_nm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtChgCalcVO[]
	 */
	public DmtChgCalcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtChgCalcVO[]
	 */
	public DmtChgCalcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtChgCalcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrRmk = (JSPUtil.getParameter(request, prefix	+ "corr_rmk", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] fmMvmtYr = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yr", length));
			String[] dulTpExptFlg = (JSPUtil.getParameter(request, prefix	+ "dul_tp_expt_flg", length));
			String[] webCreDt = (JSPUtil.getParameter(request, prefix	+ "web_cre_dt", length));
			String[] deltOfcCd = (JSPUtil.getParameter(request, prefix	+ "delt_ofc_cd", length));
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] cmdtOvrDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_ovr_dys", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cmdtTrfSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_trf_seq", length));
			String[] aftExptAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_amt", length));
			String[] toMvmtSeq = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] aftExptAproNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_apro_no", length));
			String[] rlseOfc = (JSPUtil.getParameter(request, prefix	+ "rlse_ofc", length));
			String[] scRfaExptOvrDys = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_ovr_dys", length));
			String[] bzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_aply_dt", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] li = (JSPUtil.getParameter(request, prefix	+ "li", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dO = (JSPUtil.getParameter(request, prefix	+ "d_o", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] bzcTrfSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_seq", length));
			String[] ch = (JSPUtil.getParameter(request, prefix	+ "ch", length));
			String[] cxlBkgChgFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_bkg_chg_flg", length));
			String[] webCreUsrId = (JSPUtil.getParameter(request, prefix	+ "web_cre_usr_id", length));
			String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_if_cd", length));
			String[] rollOvr = (JSPUtil.getParameter(request, prefix	+ "roll_ovr", length));
			String[] scRfaExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_aply_dt", length));
			String[] notCreBalFlg = (JSPUtil.getParameter(request, prefix	+ "not_cre_bal_flg", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] cntrInvAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_inv_amt", length));
			String[] rfaExptAproNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_apro_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] cmdtExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_aply_dt", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] toMvmtYr = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yr", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] aftExptOvrDys = (JSPUtil.getParameter(request, prefix	+ "aft_expt_ovr_dys", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] webNtfyPicNm = (JSPUtil.getParameter(request, prefix	+ "web_ntfy_pic_nm", length));
			String[] bzcTrfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_grp_seq", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] webIndFlg = (JSPUtil.getParameter(request, prefix	+ "web_ind_flg", length));
			String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_amt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] webNtfyPicTelcmNo = (JSPUtil.getParameter(request, prefix	+ "web_ntfy_pic_telcm_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] fmMvmtSeq = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] webMtyDt = (JSPUtil.getParameter(request, prefix	+ "web_mty_dt", length));
			String[] orgFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "org_ft_ovr_dys", length));
			String[] toMvmtSplitNo = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_split_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fmMvmtSplitNo = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_split_no", length));
			String[] scRfaAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_amt", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] uclmFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_flg", length));
			String[] bzcDmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_cd", length));
			String[] bzcDmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtChgCalcVO();
				if (corrRmk[i] != null)
					model.setCorrRmk(corrRmk[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (fmMvmtYr[i] != null)
					model.setFmMvmtYr(fmMvmtYr[i]);
				if (dulTpExptFlg[i] != null)
					model.setDulTpExptFlg(dulTpExptFlg[i]);
				if (webCreDt[i] != null)
					model.setWebCreDt(webCreDt[i]);
				if (deltOfcCd[i] != null)
					model.setDeltOfcCd(deltOfcCd[i]);
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (cmdtOvrDys[i] != null)
					model.setCmdtOvrDys(cmdtOvrDys[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cmdtTrfSeq[i] != null)
					model.setCmdtTrfSeq(cmdtTrfSeq[i]);
				if (aftExptAmt[i] != null)
					model.setAftExptAmt(aftExptAmt[i]);
				if (toMvmtSeq[i] != null)
					model.setToMvmtSeq(toMvmtSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (aftExptAproNo[i] != null)
					model.setAftExptAproNo(aftExptAproNo[i]);
				if (rlseOfc[i] != null)
					model.setRlseOfc(rlseOfc[i]);
				if (scRfaExptOvrDys[i] != null)
					model.setScRfaExptOvrDys(scRfaExptOvrDys[i]);
				if (bzcTrfAplyDt[i] != null)
					model.setBzcTrfAplyDt(bzcTrfAplyDt[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (li[i] != null)
					model.setLi(li[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dO[i] != null)
					model.setDO(dO[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (bzcTrfSeq[i] != null)
					model.setBzcTrfSeq(bzcTrfSeq[i]);
				if (ch[i] != null)
					model.setCh(ch[i]);
				if (cxlBkgChgFlg[i] != null)
					model.setCxlBkgChgFlg(cxlBkgChgFlg[i]);
				if (webCreUsrId[i] != null)
					model.setWebCreUsrId(webCreUsrId[i]);
				if (dmdtArIfCd[i] != null)
					model.setDmdtArIfCd(dmdtArIfCd[i]);
				if (rollOvr[i] != null)
					model.setRollOvr(rollOvr[i]);
				if (scRfaExptAplyDt[i] != null)
					model.setScRfaExptAplyDt(scRfaExptAplyDt[i]);
				if (notCreBalFlg[i] != null)
					model.setNotCreBalFlg(notCreBalFlg[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (cntrInvAmt[i] != null)
					model.setCntrInvAmt(cntrInvAmt[i]);
				if (rfaExptAproNo[i] != null)
					model.setRfaExptAproNo(rfaExptAproNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (cmdtExptAplyDt[i] != null)
					model.setCmdtExptAplyDt(cmdtExptAplyDt[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (toMvmtYr[i] != null)
					model.setToMvmtYr(toMvmtYr[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (aftExptOvrDys[i] != null)
					model.setAftExptOvrDys(aftExptOvrDys[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (webNtfyPicNm[i] != null)
					model.setWebNtfyPicNm(webNtfyPicNm[i]);
				if (bzcTrfGrpSeq[i] != null)
					model.setBzcTrfGrpSeq(bzcTrfGrpSeq[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (webIndFlg[i] != null)
					model.setWebIndFlg(webIndFlg[i]);
				if (cmdtExptAmt[i] != null)
					model.setCmdtExptAmt(cmdtExptAmt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (webNtfyPicTelcmNo[i] != null)
					model.setWebNtfyPicTelcmNo(webNtfyPicTelcmNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (chgType[i] != null)
					model.setChgType(chgType[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (fmMvmtSeq[i] != null)
					model.setFmMvmtSeq(fmMvmtSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (webMtyDt[i] != null)
					model.setWebMtyDt(webMtyDt[i]);
				if (orgFtOvrDys[i] != null)
					model.setOrgFtOvrDys(orgFtOvrDys[i]);
				if (toMvmtSplitNo[i] != null)
					model.setToMvmtSplitNo(toMvmtSplitNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fmMvmtSplitNo[i] != null)
					model.setFmMvmtSplitNo(fmMvmtSplitNo[i]);
				if (scRfaAmt[i] != null)
					model.setScRfaAmt(scRfaAmt[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (uclmFlg[i] != null)
					model.setUclmFlg(uclmFlg[i]);
				if (bzcDmdtDeTermCd[i] != null)
					model.setBzcDmdtDeTermCd(bzcDmdtDeTermCd[i]);
				if (bzcDmdtDeTermNm[i] != null)
					model.setBzcDmdtDeTermNm(bzcDmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtChgCalcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtChgCalcVO[]
	 */
	public DmtChgCalcVO[] getDmtChgCalcVOs(){
		DmtChgCalcVO[] vos = (DmtChgCalcVO[])models.toArray(new DmtChgCalcVO[models.size()]);
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
		this.corrRmk = this.corrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYr = this.fmMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulTpExptFlg = this.dulTpExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreDt = this.webCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltOfcCd = this.deltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtOvrDys = this.cmdtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTrfSeq = this.cmdtTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAmt = this.aftExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtSeq = this.toMvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAproNo = this.aftExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseOfc = this.rlseOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptOvrDys = this.scRfaExptOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfAplyDt = this.bzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.li = this.li .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dO = this.dO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfSeq = this.bzcTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ch = this.ch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlBkgChgFlg = this.cxlBkgChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webCreUsrId = this.webCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArIfCd = this.dmdtArIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvr = this.rollOvr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAplyDt = this.scRfaExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notCreBalFlg = this.notCreBalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInvAmt = this.cntrInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptAproNo = this.rfaExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAplyDt = this.cmdtExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYr = this.toMvmtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptOvrDys = this.aftExptOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webNtfyPicNm = this.webNtfyPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfGrpSeq = this.bzcTrfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webIndFlg = this.webIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAmt = this.cmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webNtfyPicTelcmNo = this.webNtfyPicTelcmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtSeq = this.fmMvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webMtyDt = this.webMtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFtOvrDys = this.orgFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtSplitNo = this.toMvmtSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtSplitNo = this.fmMvmtSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaAmt = this.scRfaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFlg = this.uclmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermCd = this.bzcDmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermNm = this.bzcDmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
