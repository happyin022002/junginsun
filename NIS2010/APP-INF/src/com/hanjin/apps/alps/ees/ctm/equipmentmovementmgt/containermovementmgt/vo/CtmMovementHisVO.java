/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CtmMovementHisVO.java
*@FileTitle : CtmMovementHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CtmMovementHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CtmMovementHisVO> models = new ArrayList<CtmMovementHisVO>();
	
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String cnmvCorrRsn = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inpYdCd = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String cntrHngrRckFlg = null;
	/* Column Info */
	private String ctrtOfcCtyCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String chssMgstMvmtRmk = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String atchFileSavId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cntrActCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String inlndTrspLicNo = null;
	/* Column Info */
	private String cntrStsSeq = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String cnmvHisSeq = null;
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String modiTp = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String mvmtInpTpCd = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String inpDivFlg = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String mtyRepoVlRmk = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String datDivFlg = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String substRuleCd = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CtmMovementHisVO() {}

	public CtmMovementHisVO(String ibflag, String pagerows, String cntrNo, String cnmvYr, String cnmvIdNo, String cnmvHisSeq, String modiTp, String datDivFlg, String inpDivFlg, String cnmvSeq, String cnmvSplitNo, String cntrTpszCd, String mvmtStsCd, String bkgCgoTpCd, String cnmvCycNo, String cnmvLvlNo, String cnmvEvntDt, String destYdCd, String inpYdCd, String orgYdCd, String cntCd, String crntVslCd, String crntSkdVoyNo, String crntSkdDirCd, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String chssNo, String mgstNo, String cntrSealNo, String cntrDmgFlg, String fcntrFlg, String obCntrFlg, String bkgRcvTermCd, String vndrSeq, String mvmtTrspModCd, String locCd, String cnmvRmk, String chssMgstMvmtRmk, String usrNm, String mvmtCreTpCd, String substRuleCd, String spclCgoFlg, String bkgNo, String bkgKnt, String blNo, String cntrHngrRckFlg, String cntrHngrBarAtchKnt, String cntrActCd, String cntrRfubFlg, String cntrDispFlg, String imdtExtFlg, String cntrXchCd, String inlndTrspLicNo, String ctrtOfcCtyCd, String ctrtSeq, String mvmtEdiTpCd, String mvmtEdiMsgTpId, String mvmtEdiMsgAreaCd, String mvmtEdiMsgYrmondy, String mvmtEdiMsgSeq, String wblNo, String pkupNo, String cntrStsSeq, String callSgnNo, String lloydNo, String mtyRepoVlRmk, String mvmtInpTpCd, String cnmvCoCd, String sysAreaGrpId, String ofcCd, String preStsFlg, String cnmvCorrRsn, String atchFileSavId, String gmtDt, String creLoclDt, String updLoclDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.blNo = blNo;
		this.sysAreaGrpId = sysAreaGrpId;
		this.bkgNo = bkgNo;
		this.cntCd = cntCd;
		this.updUsrId = updUsrId;
		this.cnmvLvlNo = cnmvLvlNo;
		this.pkupNo = pkupNo;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.cnmvIdNo = cnmvIdNo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.preStsFlg = preStsFlg;
		this.crntVslCd = crntVslCd;
		this.wblNo = wblNo;
		this.cnmvCorrRsn = cnmvCorrRsn;
		this.destYdCd = destYdCd;
		this.cntrDmgFlg = cntrDmgFlg;
		this.cntrSealNo = cntrSealNo;
		this.ctrtSeq = ctrtSeq;
		this.bkgKnt = bkgKnt;
		this.cnmvSeq = cnmvSeq;
		this.pagerows = pagerows;
		this.inpYdCd = inpYdCd;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.gmtDt = gmtDt;
		this.ofcCd = ofcCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.cnmvEvntDt = cnmvEvntDt;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.cntrHngrRckFlg = cntrHngrRckFlg;
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.trnkVslCd = trnkVslCd;
		this.chssMgstMvmtRmk = chssMgstMvmtRmk;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtStsCd = mvmtStsCd;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.creDt = creDt;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.vndrSeq = vndrSeq;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.atchFileSavId = atchFileSavId;
		this.cntrTpszCd = cntrTpszCd;
		this.cnmvYr = cnmvYr;
		this.cntrActCd = cntrActCd;
		this.updDt = updDt;
		this.inlndTrspLicNo = inlndTrspLicNo;
		this.cntrStsSeq = cntrStsSeq;
		this.cnmvCoCd = cnmvCoCd;
		this.ibflag = ibflag;
		this.cntrRfubFlg = cntrRfubFlg;
		this.cnmvHisSeq = cnmvHisSeq;
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.modiTp = modiTp;
		this.obCntrFlg = obCntrFlg;
		this.callSgnNo = callSgnNo;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.mvmtInpTpCd = mvmtInpTpCd;
		this.imdtExtFlg = imdtExtFlg;
		this.creUsrId = creUsrId;
		this.inpDivFlg = inpDivFlg;
		this.updLoclDt = updLoclDt;
		this.cnmvSplitNo = cnmvSplitNo;
		this.cntrDispFlg = cntrDispFlg;
		this.usrNm = usrNm;
		this.cnmvCycNo = cnmvCycNo;
		this.mtyRepoVlRmk = mtyRepoVlRmk;
		this.lloydNo = lloydNo;
		this.crntSkdDirCd = crntSkdDirCd;
		this.fcntrFlg = fcntrFlg;
		this.creLoclDt = creLoclDt;
		this.orgYdCd = orgYdCd;
		this.locCd = locCd;
		this.cnmvRmk = cnmvRmk;
		this.datDivFlg = datDivFlg;
		this.cntrXchCd = cntrXchCd;
		this.substRuleCd = substRuleCd;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.chssNo = chssNo;
		this.mgstNo = mgstNo;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("cnmv_corr_rsn", getCnmvCorrRsn());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inp_yd_cd", getInpYdCd());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("gmt_dt", getGmtDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());
		this.hashColumns.put("ctrt_ofc_cty_cd", getCtrtOfcCtyCd());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("chss_mgst_mvmt_rmk", getChssMgstMvmtRmk());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("atch_file_sav_id", getAtchFileSavId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cntr_act_cd", getCntrActCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inlnd_trsp_lic_no", getInlndTrspLicNo());
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("cnmv_his_seq", getCnmvHisSeq());
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("modi_tp", getModiTp());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("mvmt_inp_tp_cd", getMvmtInpTpCd());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inp_div_flg", getInpDivFlg());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("mty_repo_vl_rmk", getMtyRepoVlRmk());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("dat_div_flg", getDatDivFlg());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("subst_rule_cd", getSubstRuleCd());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("cnmv_corr_rsn", "cnmvCorrRsn");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inp_yd_cd", "inpYdCd");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("ctrt_ofc_cty_cd", "ctrtOfcCtyCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("chss_mgst_mvmt_rmk", "chssMgstMvmtRmk");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("atch_file_sav_id", "atchFileSavId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cntr_act_cd", "cntrActCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inlnd_trsp_lic_no", "inlndTrspLicNo");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("cnmv_his_seq", "cnmvHisSeq");
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("modi_tp", "modiTp");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("mvmt_inp_tp_cd", "mvmtInpTpCd");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inp_div_flg", "inpDivFlg");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("mty_repo_vl_rmk", "mtyRepoVlRmk");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("dat_div_flg", "datDivFlg");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("subst_rule_cd", "substRuleCd");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
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
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return cnmvLvlNo
	 */
	public String getCnmvLvlNo() {
		return this.cnmvLvlNo;
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
	 * @return mvmtEdiTpCd
	 */
	public String getMvmtEdiTpCd() {
		return this.mvmtEdiTpCd;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
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
	 * @return cnmvCorrRsn
	 */
	public String getCnmvCorrRsn() {
		return this.cnmvCorrRsn;
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
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
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
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
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
	 * @return inpYdCd
	 */
	public String getInpYdCd() {
		return this.inpYdCd;
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
	 * @return gmtDt
	 */
	public String getGmtDt() {
		return this.gmtDt;
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
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
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
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
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
	 * @return ctrtOfcCtyCd
	 */
	public String getCtrtOfcCtyCd() {
		return this.ctrtOfcCtyCd;
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
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @return chssMgstMvmtRmk
	 */
	public String getChssMgstMvmtRmk() {
		return this.chssMgstMvmtRmk;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return mvmtEdiMsgYrmondy
	 */
	public String getMvmtEdiMsgYrmondy() {
		return this.mvmtEdiMsgYrmondy;
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
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return cntrActCd
	 */
	public String getCntrActCd() {
		return this.cntrActCd;
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
	 * @return inlndTrspLicNo
	 */
	public String getInlndTrspLicNo() {
		return this.inlndTrspLicNo;
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
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
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
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
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
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
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
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
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
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
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
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
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
	 * @return inpDivFlg
	 */
	public String getInpDivFlg() {
		return this.inpDivFlg;
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
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return mtyRepoVlRmk
	 */
	public String getMtyRepoVlRmk() {
		return this.mtyRepoVlRmk;
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
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
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
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return datDivFlg
	 */
	public String getDatDivFlg() {
		return this.datDivFlg;
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
	 * @return substRuleCd
	 */
	public String getSubstRuleCd() {
		return this.substRuleCd;
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
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
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
	 * @param mvmtEdiTpCd
	 */
	public void setMvmtEdiTpCd(String mvmtEdiTpCd) {
		this.mvmtEdiTpCd = mvmtEdiTpCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
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
	 * @param cnmvCorrRsn
	 */
	public void setCnmvCorrRsn(String cnmvCorrRsn) {
		this.cnmvCorrRsn = cnmvCorrRsn;
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
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
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
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
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
	 * @param inpYdCd
	 */
	public void setInpYdCd(String inpYdCd) {
		this.inpYdCd = inpYdCd;
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
	 * @param gmtDt
	 */
	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
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
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
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
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
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
	 * @param ctrtOfcCtyCd
	 */
	public void setCtrtOfcCtyCd(String ctrtOfcCtyCd) {
		this.ctrtOfcCtyCd = ctrtOfcCtyCd;
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
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @param chssMgstMvmtRmk
	 */
	public void setChssMgstMvmtRmk(String chssMgstMvmtRmk) {
		this.chssMgstMvmtRmk = chssMgstMvmtRmk;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param mvmtEdiMsgYrmondy
	 */
	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
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
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param cntrActCd
	 */
	public void setCntrActCd(String cntrActCd) {
		this.cntrActCd = cntrActCd;
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
	 * @param inlndTrspLicNo
	 */
	public void setInlndTrspLicNo(String inlndTrspLicNo) {
		this.inlndTrspLicNo = inlndTrspLicNo;
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
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
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
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
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
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
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
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
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
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
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
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
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
	 * @param inpDivFlg
	 */
	public void setInpDivFlg(String inpDivFlg) {
		this.inpDivFlg = inpDivFlg;
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
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param mtyRepoVlRmk
	 */
	public void setMtyRepoVlRmk(String mtyRepoVlRmk) {
		this.mtyRepoVlRmk = mtyRepoVlRmk;
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
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
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
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param datDivFlg
	 */
	public void setDatDivFlg(String datDivFlg) {
		this.datDivFlg = datDivFlg;
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
	 * @param substRuleCd
	 */
	public void setSubstRuleCd(String substRuleCd) {
		this.substRuleCd = substRuleCd;
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
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, prefix + "cnmv_lvl_no", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_tp_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setPreStsFlg(JSPUtil.getParameter(request, prefix + "pre_sts_flg", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setCnmvCorrRsn(JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCtrtSeq(JSPUtil.getParameter(request, prefix + "ctrt_seq", ""));
		setBkgKnt(JSPUtil.getParameter(request, prefix + "bkg_knt", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInpYdCd(JSPUtil.getParameter(request, prefix + "inp_yd_cd", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, prefix + "trnk_skd_voy_no", ""));
		setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "cntr_hngr_bar_atch_knt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_flg", ""));
		setCtrtOfcCtyCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cty_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_seq", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, prefix + "trnk_vsl_cd", ""));
		setChssMgstMvmtRmk(JSPUtil.getParameter(request, prefix + "chss_mgst_mvmt_rmk", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, prefix + "trnk_skd_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_yrmondy", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setAtchFileSavId(JSPUtil.getParameter(request, prefix + "atch_file_sav_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCntrActCd(JSPUtil.getParameter(request, prefix + "cntr_act_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInlndTrspLicNo(JSPUtil.getParameter(request, prefix + "inlnd_trsp_lic_no", ""));
		setCntrStsSeq(JSPUtil.getParameter(request, prefix + "cntr_sts_seq", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, prefix + "cntr_rfub_flg", ""));
		setCnmvHisSeq(JSPUtil.getParameter(request, prefix + "cnmv_his_seq", ""));
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setModiTp(JSPUtil.getParameter(request, prefix + "modi_tp", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setMvmtInpTpCd(JSPUtil.getParameter(request, prefix + "mvmt_inp_tp_cd", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInpDivFlg(JSPUtil.getParameter(request, prefix + "inp_div_flg", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, prefix + "cntr_disp_flg", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setMtyRepoVlRmk(JSPUtil.getParameter(request, prefix + "mty_repo_vl_rmk", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setDatDivFlg(JSPUtil.getParameter(request, prefix + "dat_div_flg", ""));
		setCntrXchCd(JSPUtil.getParameter(request, prefix + "cntr_xch_cd", ""));
		setSubstRuleCd(JSPUtil.getParameter(request, prefix + "subst_rule_cd", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_area_cd", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmMovementHisVO[]
	 */
	public CtmMovementHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CtmMovementHisVO[]
	 */
	public CtmMovementHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmMovementHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] preStsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_sts_flg", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] cnmvCorrRsn = (JSPUtil.getParameter(request, prefix	+ "cnmv_corr_rsn", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inpYdCd = (JSPUtil.getParameter(request, prefix	+ "inp_yd_cd", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] gmtDt = (JSPUtil.getParameter(request, prefix	+ "gmt_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] cntrHngrRckFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_flg", length));
			String[] ctrtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cty_cd", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] chssMgstMvmtRmk = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_mvmt_rmk", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] atchFileSavId = (JSPUtil.getParameter(request, prefix	+ "atch_file_sav_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cntrActCd = (JSPUtil.getParameter(request, prefix	+ "cntr_act_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] inlndTrspLicNo = (JSPUtil.getParameter(request, prefix	+ "inlnd_trsp_lic_no", length));
			String[] cntrStsSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_seq", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] cnmvHisSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_his_seq", length));
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] modiTp = (JSPUtil.getParameter(request, prefix	+ "modi_tp", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] mvmtInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_inp_tp_cd", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] inpDivFlg = (JSPUtil.getParameter(request, prefix	+ "inp_div_flg", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] mtyRepoVlRmk = (JSPUtil.getParameter(request, prefix	+ "mty_repo_vl_rmk", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] datDivFlg = (JSPUtil.getParameter(request, prefix	+ "dat_div_flg", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] substRuleCd = (JSPUtil.getParameter(request, prefix	+ "subst_rule_cd", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CtmMovementHisVO();
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (preStsFlg[i] != null)
					model.setPreStsFlg(preStsFlg[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (cnmvCorrRsn[i] != null)
					model.setCnmvCorrRsn(cnmvCorrRsn[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inpYdCd[i] != null)
					model.setInpYdCd(inpYdCd[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (gmtDt[i] != null)
					model.setGmtDt(gmtDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (cntrHngrRckFlg[i] != null)
					model.setCntrHngrRckFlg(cntrHngrRckFlg[i]);
				if (ctrtOfcCtyCd[i] != null)
					model.setCtrtOfcCtyCd(ctrtOfcCtyCd[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (chssMgstMvmtRmk[i] != null)
					model.setChssMgstMvmtRmk(chssMgstMvmtRmk[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (atchFileSavId[i] != null)
					model.setAtchFileSavId(atchFileSavId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cntrActCd[i] != null)
					model.setCntrActCd(cntrActCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (inlndTrspLicNo[i] != null)
					model.setInlndTrspLicNo(inlndTrspLicNo[i]);
				if (cntrStsSeq[i] != null)
					model.setCntrStsSeq(cntrStsSeq[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (cnmvHisSeq[i] != null)
					model.setCnmvHisSeq(cnmvHisSeq[i]);
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (modiTp[i] != null)
					model.setModiTp(modiTp[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (mvmtInpTpCd[i] != null)
					model.setMvmtInpTpCd(mvmtInpTpCd[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (inpDivFlg[i] != null)
					model.setInpDivFlg(inpDivFlg[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (mtyRepoVlRmk[i] != null)
					model.setMtyRepoVlRmk(mtyRepoVlRmk[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (datDivFlg[i] != null)
					model.setDatDivFlg(datDivFlg[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (substRuleCd[i] != null)
					model.setSubstRuleCd(substRuleCd[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCtmMovementHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmMovementHisVO[]
	 */
	public CtmMovementHisVO[] getCtmMovementHisVOs(){
		CtmMovementHisVO[] vos = (CtmMovementHisVO[])models.toArray(new CtmMovementHisVO[models.size()]);
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
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg = this.preStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCorrRsn = this.cnmvCorrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYdCd = this.inpYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt = this.gmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg = this.cntrHngrRckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCtyCd = this.ctrtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstMvmtRmk = this.chssMgstMvmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileSavId = this.atchFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrActCd = this.cntrActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTrspLicNo = this.inlndTrspLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq = this.cntrStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisSeq = this.cnmvHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiTp = this.modiTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtInpTpCd = this.mvmtInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDivFlg = this.inpDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoVlRmk = this.mtyRepoVlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datDivFlg = this.datDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substRuleCd = this.substRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
