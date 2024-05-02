/**
 * Copyright(c) 2010 CyberLogitec
 * @FileName : CusCtmMovementVO.java
 * @FileTitle : CusCtmMovementVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2010.10.18
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2010.10.18 김상수 
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
 *                     자동생성 로직이 탈수있도록 소스수정
 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
 * 2016.06.02 김상현 1.1 [CHM-201641731] VGM 항목 추가                     
 */

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object.
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CusCtmMovementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CusCtmMovementVO> models = new ArrayList<CusCtmMovementVO>();
	
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String mvmtInpTpCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mtyRepoVlRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String substRuleCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrActCd = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String cntrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String inpYdCd = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ctmUiYn = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String pType2 = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String pType1 = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String ctrtOfcCtyCd = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String lstrmCd = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String xxlink = null;
	/* Column Info */
	private String cntrSvrId = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String bbulkFlg = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String newFlg = null;
	/* Column Info */
	private String cntrStsSeq = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String inlndTrspLicNo = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrHngrRckFlg = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String chgMvmtDtFlg = null;
	/* Column Info */
	private String ioFixFlag = null;
	/* Column Info */
	private String cnmvCorrRsn = null;
	/* Column Info */
	private String atchFileSavId = null;
	/* Column Info */
	private String inpDivFlg = null;
	/* Column Info */
	private String cnmvHisSeq = null;
	/* Column Info */
	private String modiTp = null;
	/* Column Info */
	private String datDivFlg = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String vgmWgtQty = null;
	/* Column Info */
	private String vgmVrfyDt = null;
	/* Column Info */
	private String vgmSigCtnt = null;
	/* Column Info */
	private String vgmRefNo = null;
	/* Column Info */
	private String vgmWgtPtyCtnt = null;
	/* Column Info */
	private String vgmVrfyOrdCtnt = null;
	/* Column Info */
	private String n2ndCnmvCycNo = null;
	/* Column Info */
	private String n2ndMvmtStsCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CusCtmMovementVO() {}

	public CusCtmMovementVO(String ibflag, String pagerows, String aciacDivCd, String bkgCgoTpCd, String bkgKnt, String bkgNo, String bkgNoSplit, String bkgRcvTermCd, String blNo, String callSgnNo, String checkDigit, String chssNo, String cnmvCoCd, String cnmvCycNo, String cnmvEvntDt, String cnmvIdNo, String cnmvLvlNo, String cnmvRmk, String cnmvSeq, String cnmvSplitNo, String cnmvYr, String cntrActCd, String cntrDispFlg, String cntrDmgFlg, String cntrHngrBarAtchKnt, String cntrHngrRckFlg, String cntrId, String cntrNo, String cntrRfubFlg, String cntrSealNo, String cntrStsSeq, String cntrSvrId, String cntrTpszCd, String cntrXchCd, String creDt, String creLoclDt, String creUsrId, String crntSkdDirCd, String crntSkdVoyNo, String crntVslCd, String ctmUiYn, String ctrtOfcCtyCd, String ctrtSeq, String destYdCd, String errMsg, String evntDt, String fcntrFlg, String gmtDt, String imdtExtFlg, String inlndTrspLicNo, String inpYdCd, String lloydNo, String locCd, String lstmCd, String lstrmCd, String mgstNo, String mtyRepoVlRmk, String mvmtCreTpCd, String mvmtEdiMsgAreaCd, String mvmtEdiMsgSeq, String mvmtEdiMsgTpId, String mvmtEdiMsgYrmondy, String mvmtEdiTpCd, String mvmtInpTpCd, String mvmtStsCd, String mvmtTrspModCd, String newFlg, String obCntrFlg, String ofcCd, String orgYdCd, String pkupNo, String podCd, String polCd, String preStsFlg, String pType1, String pType2, String spclCgoFlg, String substRuleCd, String trnkSkdDirCd, String trnkSkdVoyNo, String trnkVslCd, String updDt, String updLoclDt, String updUsrId, String usrNm, String vndrSeq, String vvdCd, String wblNo, String xxlink, String bbulkFlg, String chgMvmtDtFlg, String ioFixFlag, String cnmvCorrRsn, String atchFileSavId, String inpDivFlg, String cnmvHisSeq, String modiTp, String datDivFlg, String vgmMzdTpCd, String vgmWgtUtCd, String vgmWgtQty, String vgmVrfyDt, String vgmSigCtnt, String vgmRefNo, String vgmWgtPtyCtnt, String vgmVrfyOrdCtnt) {
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.gmtDt = gmtDt;
		this.cnmvSeq = cnmvSeq;
		this.mvmtInpTpCd = mvmtInpTpCd;
		this.chssNo = chssNo;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.destYdCd = destYdCd;
		this.ctrtSeq = ctrtSeq;
		this.blNo = blNo;
		this.mtyRepoVlRmk = mtyRepoVlRmk;
		this.pagerows = pagerows;
		this.substRuleCd = substRuleCd;
		this.polCd = polCd;
		this.locCd = locCd;
		this.vvdCd = vvdCd;
		this.cntrActCd = cntrActCd;
		this.cntrXchCd = cntrXchCd;
		this.cntrId = cntrId;
		this.cntrTpszCd = cntrTpszCd;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.cntrRfubFlg = cntrRfubFlg;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.evntDt = evntDt;
		this.inpYdCd = inpYdCd;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.callSgnNo = callSgnNo;
		this.ctmUiYn = ctmUiYn;
		this.wblNo = wblNo;
		this.updLoclDt = updLoclDt;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.aciacDivCd = aciacDivCd;
		this.cnmvIdNo = cnmvIdNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.lloydNo = lloydNo;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.cnmvRmk = cnmvRmk;
		this.creLoclDt = creLoclDt;
		this.vndrSeq = vndrSeq;
		this.pType2 = pType2;
		this.errMsg = errMsg;
		this.trnkVslCd = trnkVslCd;
		this.pType1 = pType1;
		this.cntrDispFlg = cntrDispFlg;
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.pkupNo = pkupNo;
		this.cnmvCycNo = cnmvCycNo;
		this.lstrmCd = lstrmCd;
		this.cnmvLvlNo = cnmvLvlNo;
		this.checkDigit = checkDigit;
		this.creDt = creDt;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.xxlink = xxlink;
		this.cntrSvrId = cntrSvrId;
		this.fcntrFlg = fcntrFlg;
		this.bbulkFlg = bbulkFlg;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.cntrDmgFlg = cntrDmgFlg;
		this.cnmvSplitNo = cnmvSplitNo;
		this.ibflag = ibflag;
		this.bkgKnt = bkgKnt;
		this.usrNm = usrNm;
		this.updDt = updDt;
		this.newFlg = newFlg;
		this.cntrStsSeq = cntrStsSeq;
		this.bkgNoSplit = bkgNoSplit;
		this.inlndTrspLicNo = inlndTrspLicNo;
		this.crntSkdDirCd = crntSkdDirCd;
		this.preStsFlg = preStsFlg;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.cntrHngrRckFlg = cntrHngrRckFlg;
		this.obCntrFlg = obCntrFlg;
		this.ofcCd = ofcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.cntrNo = cntrNo;
		this.cntrSealNo = cntrSealNo;
		this.imdtExtFlg = imdtExtFlg;
		this.cnmvYr = cnmvYr;
		this.cnmvCoCd = cnmvCoCd;
		this.crntVslCd = crntVslCd;
		this.chgMvmtDtFlg = chgMvmtDtFlg;
		this.ioFixFlag = ioFixFlag;
		this.cnmvCorrRsn = cnmvCorrRsn;
		this.atchFileSavId = atchFileSavId;
		this.inpDivFlg = inpDivFlg;
		this.cnmvHisSeq = cnmvHisSeq;
		this.modiTp = modiTp;
		this.datDivFlg = datDivFlg;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.vgmWgtQty = vgmWgtQty;
		this.vgmVrfyDt = vgmVrfyDt;
		this.vgmSigCtnt = vgmSigCtnt;
		this.vgmRefNo = vgmRefNo;
		this.vgmWgtPtyCtnt = vgmWgtPtyCtnt;
		this.vgmVrfyOrdCtnt = vgmVrfyOrdCtnt;
		this.n2ndCnmvCycNo = n2ndCnmvCycNo;
		this.n2ndMvmtStsCd = n2ndMvmtStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("gmt_dt", getGmtDt());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("mvmt_inp_tp_cd", getMvmtInpTpCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mty_repo_vl_rmk", getMtyRepoVlRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("subst_rule_cd", getSubstRuleCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_act_cd", getCntrActCd());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("cntr_id", getCntrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("inp_yd_cd", getInpYdCd());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ctm_ui_yn", getCtmUiYn());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("p_type2", getPType2());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("p_type1", getPType1());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("ctrt_ofc_cty_cd", getCtrtOfcCtyCd());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("lstrm_cd", getLstrmCd());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("xxlink", getXxlink());
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("bbulk_flg", getBbulkFlg());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("new_flg", getNewFlg());
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("inlnd_trsp_lic_no", getInlndTrspLicNo());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("chg_mvmt_dt_flg", getChgMvmtDtFlg());
		this.hashColumns.put("io_fix_flag", getIoFixFlag());
		this.hashColumns.put("cnmv_corr_rsn", getCnmvCorrRsn());
		this.hashColumns.put("atch_file_sav_id", getAtchFileSavId());
		this.hashColumns.put("inp_div_flg", getInpDivFlg());
		this.hashColumns.put("cnmv_his_seq", getCnmvHisSeq());
		this.hashColumns.put("modi_tp", getModiTp());
		this.hashColumns.put("dat_div_flg", getDatDivFlg());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("vgm_wgt_qty", getVgmWgtQty());
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
		this.hashColumns.put("vgm_sig_ctnt", getVgmSigCtnt());
		this.hashColumns.put("vgm_ref_no", getVgmRefNo());
		this.hashColumns.put("vgm_wgt_pty_ctnt", getVgmWgtPtyCtnt());
		this.hashColumns.put("vgm_vrfy_ord_ctnt", getVgmVrfyOrdCtnt());
		this.hashColumns.put("n2nd_cnmv_cyc_no", getN2ndCnmvCycNo());
		this.hashColumns.put("n2nd_mvmt_sts_cd", getN2ndMvmtStsCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("mvmt_inp_tp_cd", "mvmtInpTpCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mty_repo_vl_rmk", "mtyRepoVlRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("subst_rule_cd", "substRuleCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_act_cd", "cntrActCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("inp_yd_cd", "inpYdCd");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ctm_ui_yn", "ctmUiYn");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("p_type2", "pType2");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("p_type1", "pType1");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("ctrt_ofc_cty_cd", "ctrtOfcCtyCd");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("lstrm_cd", "lstrmCd");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("xxlink", "xxlink");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("bbulk_flg", "bbulkFlg");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("new_flg", "newFlg");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("inlnd_trsp_lic_no", "inlndTrspLicNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("chg_mvmt_dt_flg", "chgMvmtDtFlg");
		this.hashFields.put("io_fix_flag", "ioFixFlag");
		this.hashFields.put("cnmv_corr_rsn", "cnmvCorrRsn");
		this.hashFields.put("atch_file_sav_id", "atchFileSavId");
		this.hashFields.put("inp_div_flg", "inpDivFlg");
		this.hashFields.put("cnmv_his_seq", "cnmvHisSeq");
		this.hashFields.put("modi_tp", "modiTp");
		this.hashFields.put("dat_div_flg", "datDivFlg");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("vgm_wgt_qty", "vgmWgtQty");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("vgm_sig_ctnt", "vgmSigCtnt");
		this.hashFields.put("vgm_ref_no", "vgmRefNo");
		this.hashFields.put("vgm_wgt_pty_ctnt", "vgmWgtPtyCtnt");
		this.hashFields.put("vgm_vrfy_ord_ctnt", "vgmVrfyOrdCtnt");
		this.hashFields.put("n2nd_cnmv_cyc_no", "n2ndCnmvCycNo");
		this.hashFields.put("n2nd_mvmt_sts_cd", "n2ndMvmtStsCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return gmtDt
	 */
	public String getGmtDt() {
		return this.gmtDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return mvmtInpTpCd
	 */
	public String getMvmtInpTpCd() {
		return this.mvmtInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgSeq
	 */
	public String getMvmtEdiMsgSeq() {
		return this.mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return mtyRepoVlRmk
	 */
	public String getMtyRepoVlRmk() {
		return this.mtyRepoVlRmk;
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
	 * @return substRuleCd
	 */
	public String getSubstRuleCd() {
		return this.substRuleCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrActCd
	 */
	public String getCntrActCd() {
		return this.cntrActCd;
	}
	
	/**
	 * Column Info
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @return cntrId
	 */
	public String getCntrId() {
		return this.cntrId;
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
	 * @return mvmtEdiTpCd
	 */
	public String getMvmtEdiTpCd() {
		return this.mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return inpYdCd
	 */
	public String getInpYdCd() {
		return this.inpYdCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgAreaCd
	 */
	public String getMvmtEdiMsgAreaCd() {
		return this.mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return ctmUiYn
	 */
	public String getCtmUiYn() {
		return this.ctmUiYn;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgYrmondy
	 */
	public String getMvmtEdiMsgYrmondy() {
		return this.mvmtEdiMsgYrmondy;
	}
	
	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
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
	 * @return pType2
	 */
	public String getPType2() {
		return this.pType2;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @return pType1
	 */
	public String getPType1() {
		return this.pType1;
	}
	
	/**
	 * Column Info
	 * @return cntrDispFlg
	 */
	public String getCntrDispFlg() {
		return this.cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCtyCd
	 */
	public String getCtrtOfcCtyCd() {
		return this.ctrtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return lstrmCd
	 */
	public String getLstrmCd() {
		return this.lstrmCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvLvlNo
	 */
	public String getCnmvLvlNo() {
		return this.cnmvLvlNo;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
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
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return xxlink
	 */
	public String getXxlink() {
		return this.xxlink;
	}
	
	/**
	 * Column Info
	 * @return cntrSvrId
	 */
	public String getCntrSvrId() {
		return this.cntrSvrId;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @return bbulkFlg
	 */
	public String getBbulkFlg() {
		return this.bbulkFlg;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdDirCd
	 */
	public String getTrnkSkdDirCd() {
		return this.trnkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
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
	 * @return bkgKnt
	 */
	public String getBkgKnt() {
		return this.bkgKnt;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return newFlg
	 */
	public String getNewFlg() {
		return this.newFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrStsSeq
	 */
	public String getCntrStsSeq() {
		return this.cntrStsSeq;
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
	 * @return inlndTrspLicNo
	 */
	public String getInlndTrspLicNo() {
		return this.inlndTrspLicNo;
	}
	
	/**
	 * Column Info
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return preStsFlg
	 */
	public String getPreStsFlg() {
		return this.preStsFlg;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckFlg
	 */
	public String getCntrHngrRckFlg() {
		return this.cntrHngrRckFlg;
	}
	
	/**
	 * Column Info
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}
	
	/**
	 * Column Info
	 * @return chgMvmtDtFlg
	 */
	public String getChgMvmtDtFlg() {
		return this.chgMvmtDtFlg;
	}
	
	/**
	 * Column Info
	 * @return ioFixFlag
	 */
	public String getIoFixFlag() {
		return this.ioFixFlag;
	}

	/**
	 * Column Info
	 * @return cnmvCorrRsn
	 */
	public String getCnmvCorrRsn() {
		return this.cnmvCorrRsn;
	}

	/**
	 * Column Info
	 * @return atchFileSavId
	 */
	public String getAtchFileSavId() {
		return this.atchFileSavId;
	}

	/**
	 * Column Info
	 * @return inpDivFlg
	 */
	public String getInpDivFlg() {
		return this.inpDivFlg;
	}

	/**
	 * Column Info
	 * @return cnmvHisSeq
	 */
	public String getCnmvHisSeq() {
		return this.cnmvHisSeq;
	}

	/**
	 * Column Info
	 * @return modiTp
	 */
	public String getModiTp() {
		return this.modiTp;
	}

	/**
	 * Column Info
	 * @return datDivFlg
	 */
	public String getDatDivFlg() {
		return this.datDivFlg;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmMzdTpCd() {
		return vgmMzdTpCd;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmWgtUtCd() {
		return vgmWgtUtCd;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmWgtQty() {
		return vgmWgtQty;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmVrfyDt() {
		return vgmVrfyDt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmSigCtnt() {
		return vgmSigCtnt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmRefNo() {
		return vgmRefNo;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmWgtPtyCtnt() {
		return vgmWgtPtyCtnt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmVrfyOrdCtnt() {
		return vgmVrfyOrdCtnt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getN2ndCnmvCycNo() {
		return n2ndCnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return
	 */
	public String getN2ndMvmtStsCd() {
		return n2ndMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param gmtDt
	 */
	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param mvmtInpTpCd
	 */
	public void setMvmtInpTpCd(String mvmtInpTpCd) {
		this.mvmtInpTpCd = mvmtInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgSeq
	 */
	public void setMvmtEdiMsgSeq(String mvmtEdiMsgSeq) {
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param mtyRepoVlRmk
	 */
	public void setMtyRepoVlRmk(String mtyRepoVlRmk) {
		this.mtyRepoVlRmk = mtyRepoVlRmk;
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
	 * @param substRuleCd
	 */
	public void setSubstRuleCd(String substRuleCd) {
		this.substRuleCd = substRuleCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrActCd
	 */
	public void setCntrActCd(String cntrActCd) {
		this.cntrActCd = cntrActCd;
	}
	
	/**
	 * Column Info
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @param cntrId
	 */
	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
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
	 * @param mvmtEdiTpCd
	 */
	public void setMvmtEdiTpCd(String mvmtEdiTpCd) {
		this.mvmtEdiTpCd = mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param inpYdCd
	 */
	public void setInpYdCd(String inpYdCd) {
		this.inpYdCd = inpYdCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgAreaCd
	 */
	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param ctmUiYn
	 */
	public void setCtmUiYn(String ctmUiYn) {
		this.ctmUiYn = ctmUiYn;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgYrmondy
	 */
	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
	}
	
	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
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
	 * @param pType2
	 */
	public void setPType2(String pType2) {
		this.pType2 = pType2;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @param pType1
	 */
	public void setPType1(String pType1) {
		this.pType1 = pType1;
	}
	
	/**
	 * Column Info
	 * @param cntrDispFlg
	 */
	public void setCntrDispFlg(String cntrDispFlg) {
		this.cntrDispFlg = cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCtyCd
	 */
	public void setCtrtOfcCtyCd(String ctrtOfcCtyCd) {
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param lstrmCd
	 */
	public void setLstrmCd(String lstrmCd) {
		this.lstrmCd = lstrmCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
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
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param xxlink
	 */
	public void setXxlink(String xxlink) {
		this.xxlink = xxlink;
	}
	
	/**
	 * Column Info
	 * @param cntrSvrId
	 */
	public void setCntrSvrId(String cntrSvrId) {
		this.cntrSvrId = cntrSvrId;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @param bbulkFlg
	 */
	public void setBbulkFlg(String bbulkFlg) {
		this.bbulkFlg = bbulkFlg;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdDirCd
	 */
	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
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
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param newFlg
	 */
	public void setNewFlg(String newFlg) {
		this.newFlg = newFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrStsSeq
	 */
	public void setCntrStsSeq(String cntrStsSeq) {
		this.cntrStsSeq = cntrStsSeq;
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
	 * @param inlndTrspLicNo
	 */
	public void setInlndTrspLicNo(String inlndTrspLicNo) {
		this.inlndTrspLicNo = inlndTrspLicNo;
	}
	
	/**
	 * Column Info
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param preStsFlg
	 */
	public void setPreStsFlg(String preStsFlg) {
		this.preStsFlg = preStsFlg;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckFlg
	 */
	public void setCntrHngrRckFlg(String cntrHngrRckFlg) {
		this.cntrHngrRckFlg = cntrHngrRckFlg;
	}
	
	/**
	 * Column Info
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}
	
	/**
	 * Column Info
	 * @param chgMvmtDtFlg
	 */
	public void setChgMvmtDtFlg(String chgMvmtDtFlg) {
		this.chgMvmtDtFlg = chgMvmtDtFlg;
	}
	
	/**
	 * Column Info
	 * @param ioFixFlag
	 */
	public void setIoFixFlag(String ioFixFlag) {
		this.ioFixFlag = ioFixFlag;
	}

	/**
	 * Column Info
	 * @param cnmvCorrRsn
	 */
	public void setCnmvCorrRsn(String cnmvCorrRsn) {
		this.cnmvCorrRsn = cnmvCorrRsn;
	}

	/**
	 * Column Info
	 * @param atchFileSavId
	 */
	public void setAtchFileSavId(String atchFileSavId) {
		this.atchFileSavId = atchFileSavId;
	}

	/**
	 * Column Info
	 * @param inpDivFlg
	 */
	public void setInpDivFlg(String inpDivFlg) {
		this.inpDivFlg = inpDivFlg;
	}

	/**
	 * Column Info
	 * @param cnmvHisSeq
	 */
	public void setCnmvHisSeq(String cnmvHisSeq) {
		this.cnmvHisSeq = cnmvHisSeq;
	}

	/**
	 * Column Info
	 * @param modiTp
	 */
	public void setModiTp(String modiTp) {
		this.modiTp = modiTp;
	}

	/**
	 * Column Info
	 * @param datDivFlg
	 */
	public void setDatDivFlg(String datDivFlg) {
		this.datDivFlg = datDivFlg;
	}

	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
	}

	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}

	/**
	 * Column Info
	 * @param vgmWgtQty
	 */
	public void setVgmWgtQty(String vgmWgtQty) {
		this.vgmWgtQty = vgmWgtQty;
	}

	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
	}

	/**
	 * Column Info
	 * @param vgmSigCtnt
	 */
	public void setVgmSigCtnt(String vgmSigCtnt) {
		this.vgmSigCtnt = vgmSigCtnt;
	}

	/**
	 * Column Info
	 * @param vgmRefNo
	 */
	public void setVgmRefNo(String vgmRefNo) {
		this.vgmRefNo = vgmRefNo;
	}

	/**
	 * Column Info
	 * @param vgmWgtPtyCtnt
	 */
	public void setVgmWgtPtyCtnt(String vgmWgtPtyCtnt) {
		this.vgmWgtPtyCtnt = vgmWgtPtyCtnt;
	}

	/**
	 * Column Info
	 * @param vgmVrfyOrdCtnt
	 */
	public void setVgmVrfyOrdCtnt(String vgmVrfyOrdCtnt) {
		this.vgmVrfyOrdCtnt = vgmVrfyOrdCtnt;
	}

	/**
	 * Column Info
	 * @param n2ndCnmvCycNo
	 */
	public void setN2ndCnmvCycNo(String n2ndCnmvCycNo) {
		this.n2ndCnmvCycNo = n2ndCnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndCnmvCycNo
	 */
	public void setN2ndMvmtStsCd(String n2ndCnmvCycNo) {
		this.n2ndCnmvCycNo = n2ndMvmtStsCd;
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
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setMvmtInpTpCd(JSPUtil.getParameter(request, prefix + "mvmt_inp_tp_cd", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_seq", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setCtrtSeq(JSPUtil.getParameter(request, prefix + "ctrt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMtyRepoVlRmk(JSPUtil.getParameter(request, prefix + "mty_repo_vl_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSubstRuleCd(JSPUtil.getParameter(request, prefix + "subst_rule_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrActCd(JSPUtil.getParameter(request, prefix + "cntr_act_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request, prefix + "cntr_xch_cd", ""));
		setCntrId(JSPUtil.getParameter(request, prefix + "cntr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_tp_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "cntr_hngr_bar_atch_knt", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, prefix + "cntr_rfub_flg", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setInpYdCd(JSPUtil.getParameter(request, prefix + "inp_yd_cd", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_area_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setCtmUiYn(JSPUtil.getParameter(request, prefix + "ctm_ui_yn", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_yrmondy", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPType2(JSPUtil.getParameter(request, prefix + "p_type2", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, prefix + "trnk_vsl_cd", ""));
		setPType1(JSPUtil.getParameter(request, prefix + "p_type1", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, prefix + "cntr_disp_flg", ""));
		setCtrtOfcCtyCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cty_cd", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, prefix + "trnk_skd_voy_no", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setLstrmCd(JSPUtil.getParameter(request, prefix + "lstrm_cd", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, prefix + "cnmv_lvl_no", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setXxlink(JSPUtil.getParameter(request, prefix + "xxlink", ""));
		setCntrSvrId(JSPUtil.getParameter(request, prefix + "cntr_svr_id", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setBbulkFlg(JSPUtil.getParameter(request, prefix + "bbulk_flg", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, prefix + "trnk_skd_dir_cd", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgKnt(JSPUtil.getParameter(request, prefix + "bkg_knt", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNewFlg(JSPUtil.getParameter(request, prefix + "new_flg", ""));
		setCntrStsSeq(JSPUtil.getParameter(request, prefix + "cntr_sts_seq", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setInlndTrspLicNo(JSPUtil.getParameter(request, prefix + "inlnd_trsp_lic_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setPreStsFlg(JSPUtil.getParameter(request, prefix + "pre_sts_flg", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_flg", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setChgMvmtDtFlg(JSPUtil.getParameter(request, prefix + "chg_mvmt_dt_flg", ""));
		setIoFixFlag(JSPUtil.getParameter(request, prefix + "io_fix_flag", ""));
		setCnmvCorrRsn(JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn", ""));
		setAtchFileSavId(JSPUtil.getParameter(request, prefix + "atch_file_sav_id", ""));
		setInpDivFlg(JSPUtil.getParameter(request, prefix + "inp_div_flg", ""));
		setCnmvHisSeq(JSPUtil.getParameter(request, prefix + "cnmv_his_seq", ""));
		setModiTp(JSPUtil.getParameter(request, prefix + "modi_tp", ""));
		setDatDivFlg(JSPUtil.getParameter(request, prefix + "dat_div_flg", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setVgmWgtQty(JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
		setVgmSigCtnt(JSPUtil.getParameter(request, prefix + "vgm_sig_ctnt", ""));
		setVgmRefNo(JSPUtil.getParameter(request, prefix + "vgm_ref_no", ""));
		setVgmWgtPtyCtnt(JSPUtil.getParameter(request, prefix + "vgm_wgt_pty_ctnt", ""));
		setVgmVrfyOrdCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_ord_ctnt", ""));
		setN2ndCnmvCycNo(JSPUtil.getParameter(request, prefix + "n2nd_cnmv_cyc_no", ""));
		setN2ndMvmtStsCd(JSPUtil.getParameter(request, prefix + "n2nd_mvmt_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CusCtmMovementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] gmtDt = (JSPUtil.getParameter(request, prefix	+ "gmt_dt", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] mvmtInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_inp_tp_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mtyRepoVlRmk = (JSPUtil.getParameter(request, prefix	+ "mty_repo_vl_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] substRuleCd = (JSPUtil.getParameter(request, prefix	+ "subst_rule_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrActCd = (JSPUtil.getParameter(request, prefix	+ "cntr_act_cd", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] cntrId = (JSPUtil.getParameter(request, prefix	+ "cntr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] inpYdCd = (JSPUtil.getParameter(request, prefix	+ "inp_yd_cd", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ctmUiYn = (JSPUtil.getParameter(request, prefix	+ "ctm_ui_yn", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] pType2 = (JSPUtil.getParameter(request, prefix	+ "p_type2", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] pType1 = (JSPUtil.getParameter(request, prefix	+ "p_type1", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] ctrtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cty_cd", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] lstrmCd = (JSPUtil.getParameter(request, prefix	+ "lstrm_cd", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] xxlink = (JSPUtil.getParameter(request, prefix	+ "xxlink", length));
			String[] cntrSvrId = (JSPUtil.getParameter(request, prefix	+ "cntr_svr_id", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] bbulkFlg = (JSPUtil.getParameter(request, prefix	+ "bbulk_flg", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] newFlg = (JSPUtil.getParameter(request, prefix	+ "new_flg", length));
			String[] cntrStsSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_seq", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] inlndTrspLicNo = (JSPUtil.getParameter(request, prefix	+ "inlnd_trsp_lic_no", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] preStsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_sts_flg", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cntrHngrRckFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_flg", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] chgMvmtDtFlg = (JSPUtil.getParameter(request, prefix	+ "chg_mvmt_dt_flg", length));
			String[] ioFixFlag = (JSPUtil.getParameter(request, prefix	+ "io_fix_flag", length));
			String[] cnmvCorrRsn = (JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn", length));
			String[] atchFileSavId = (JSPUtil.getParameter(request, prefix + "atch_file_sav_id", length));
			String[] inpDivFlg = (JSPUtil.getParameter(request, prefix + "inp_div_flg", length));
			String[] cnmvHisSeq = (JSPUtil.getParameter(request, prefix + "cnmv_his_seq", length));
			String[] modiTp = (JSPUtil.getParameter(request, prefix + "modi_tp", length));
			String[] datDivFlg = (JSPUtil.getParameter(request, prefix + "dat_div_flg", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));
			String[] vgmWgtQty = (JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", length));
			String[] vgmSigCtnt = (JSPUtil.getParameter(request, prefix + "vgm_sig_ctnt", length));
			String[] vgmRefNo = (JSPUtil.getParameter(request, prefix + "vgm_ref_no", length));
			String[] vgmWgtPtyCtnt = (JSPUtil.getParameter(request, prefix + "vgm_wgt_pty_ctnt", length));
			String[] vgmVrfyOrdCtnt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_ord_ctnt", length));
			String[] n2ndCnmvCycNo = (JSPUtil.getParameter(request, prefix + "n2nd_cnmv_cyc_no", length));
			String[] n2ndMvmtStsCd = (JSPUtil.getParameter(request, prefix + "n2nd_mvmt_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CusCtmMovementVO();
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (gmtDt[i] != null)
					model.setGmtDt(gmtDt[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (mvmtInpTpCd[i] != null)
					model.setMvmtInpTpCd(mvmtInpTpCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mtyRepoVlRmk[i] != null)
					model.setMtyRepoVlRmk(mtyRepoVlRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (substRuleCd[i] != null)
					model.setSubstRuleCd(substRuleCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrActCd[i] != null)
					model.setCntrActCd(cntrActCd[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (cntrId[i] != null)
					model.setCntrId(cntrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (inpYdCd[i] != null)
					model.setInpYdCd(inpYdCd[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ctmUiYn[i] != null)
					model.setCtmUiYn(ctmUiYn[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (pType2[i] != null)
					model.setPType2(pType2[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (pType1[i] != null)
					model.setPType1(pType1[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (ctrtOfcCtyCd[i] != null)
					model.setCtrtOfcCtyCd(ctrtOfcCtyCd[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (lstrmCd[i] != null)
					model.setLstrmCd(lstrmCd[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (xxlink[i] != null)
					model.setXxlink(xxlink[i]);
				if (cntrSvrId[i] != null)
					model.setCntrSvrId(cntrSvrId[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (bbulkFlg[i] != null)
					model.setBbulkFlg(bbulkFlg[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (newFlg[i] != null)
					model.setNewFlg(newFlg[i]);
				if (cntrStsSeq[i] != null)
					model.setCntrStsSeq(cntrStsSeq[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (inlndTrspLicNo[i] != null)
					model.setInlndTrspLicNo(inlndTrspLicNo[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (preStsFlg[i] != null)
					model.setPreStsFlg(preStsFlg[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cntrHngrRckFlg[i] != null)
					model.setCntrHngrRckFlg(cntrHngrRckFlg[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (chgMvmtDtFlg[i] != null)
					model.setChgMvmtDtFlg(chgMvmtDtFlg[i]);
				if (ioFixFlag[i] != null)
					model.setIoFixFlag(ioFixFlag[i]);
				if (cnmvCorrRsn[i] != null)
					model.setCnmvCorrRsn(cnmvCorrRsn[i]);
				if (atchFileSavId[i] != null)
					model.setAtchFileSavId(atchFileSavId[i]);
				if (inpDivFlg[i] != null)
					model.setInpDivFlg(inpDivFlg[i]);
				if (cnmvHisSeq[i] != null)
					model.setCnmvHisSeq(cnmvHisSeq[i]);
				if (modiTp[i] != null)
					model.setModiTp(modiTp[i]);
				if (datDivFlg[i] != null)
					model.setDatDivFlg(datDivFlg[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (vgmWgtQty[i] != null)
					model.setVgmWgtQty(vgmWgtQty[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				if (vgmSigCtnt[i] != null)
					model.setVgmSigCtnt(vgmSigCtnt[i]);
				if (vgmRefNo[i] != null)
					model.setVgmRefNo(vgmRefNo[i]);
				if (vgmWgtPtyCtnt[i] != null)
					model.setVgmWgtPtyCtnt(vgmWgtPtyCtnt[i]);
				if (vgmVrfyOrdCtnt[i] != null)
					model.setVgmVrfyOrdCtnt(vgmVrfyOrdCtnt[i]);
				if (n2ndCnmvCycNo[i] != null)
					model.setN2ndCnmvCycNo(n2ndCnmvCycNo[i]);
				if (n2ndMvmtStsCd[i] != null)
					model.setN2ndMvmtStsCd(n2ndMvmtStsCd[i]);
				models.add(model);
			}
		} catch (Exception e) {
			return null;
		}
		return getCusCtmMovementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[] getCusCtmMovementVOs(){
		CusCtmMovementVO[] vos = (CusCtmMovementVO[])models.toArray(new CusCtmMovementVO[models.size()]);
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
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt = this.gmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtInpTpCd = this.mvmtInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoVlRmk = this.mtyRepoVlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substRuleCd = this.substRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrActCd = this.cntrActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId = this.cntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYdCd = this.inpYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctmUiYn = this.ctmUiYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType2 = this.pType2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType1 = this.pType1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCtyCd = this.ctrtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstrmCd = this.lstrmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xxlink = this.xxlink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId = this.cntrSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbulkFlg = this.bbulkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFlg = this.newFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq = this.cntrStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTrspLicNo = this.inlndTrspLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg = this.preStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg = this.cntrHngrRckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgMvmtDtFlg = this.chgMvmtDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioFixFlag = this.ioFixFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCorrRsn = this.cnmvCorrRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileSavId = this.atchFileSavId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDivFlg = this.inpDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisSeq = this.cnmvHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiTp = this.modiTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datDivFlg = this.datDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtQty = this.vgmWgtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSigCtnt = this.vgmSigCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmRefNo = this.vgmRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtPtyCtnt = this.vgmWgtPtyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyOrdCtnt = this.vgmVrfyOrdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndCnmvCycNo = this.n2ndCnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndMvmtStsCd = this.n2ndMvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
