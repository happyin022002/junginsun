/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AutoMtBkgVO.java
 *@FileTitle : AutoMtBkgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.08.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.08.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.eqr.automtbkgmgt.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class AutoMtBkgVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AutoMtBkgVO>  models =	new	ArrayList<AutoMtBkgVO>(); 


	/*	Column Info	*/
	private  String	 apCtrlOfcCd   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 fmYdCd   =  null;
	/*	Column Info	*/
	private  String	 toYdCd   =  null;
	/*	Column Info	*/
	private  String	 coCd   =  null;
	/*	Column Info	*/
	private  String	 mtyBkgNo   =  null;
	/*	Column Info	*/
	private  String	 cmBkgNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 checkCase   =  null;
	/*	Column Info	*/
	private  String	 cnmvYr   =  null;
	/*	Column Info	*/
	private  String	 cnmvIdNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvSeq   =  null;
	/*	Column Info	*/
	private  String	 cnmvSplitNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtStsCd   =  null;
	/*	Column Info	*/
	private  String	 bkgCgoTpCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvCycNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvLvlNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvEvntDt   =  null;
	/*	Column Info	*/
	private  String	 destYdCd   =  null;
	/*	Column Info	*/
	private  String	 inpYdCd   =  null;
	/*	Column Info	*/
	private  String	 orgYdCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVslCd   =  null;
	/*	Column Info	*/
	private  String	 trnkSkdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 trnkSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 chssNo   =  null;
	/*	Column Info	*/
	private  String	 mgstNo   =  null;
	/*	Column Info	*/
	private  String	 cntrSealNo   =  null;
	/*	Column Info	*/
	private  String	 cntrDmgFlg   =  null;
	/*	Column Info	*/
	private  String	 fcntrFlg   =  null;
	/*	Column Info	*/
	private  String	 obCntrFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgRcvTermCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 mvmtTrspModCd   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvRmk   =  null;
	/*	Column Info	*/
	private  String	 chssMgstMvmtRmk   =  null;
	/*	Column Info	*/
	private  String	 usNm   =  null;
	/*	Column Info	*/
	private  String	 mvmtCreTpCd   =  null;
	/*	Column Info	*/
	private  String	 substRuleCd   =  null;
	/*	Column Info	*/
	private  String	 spclCgoFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgKnt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrBarAtchKnt   =  null;
	/*	Column Info	*/
	private  String	 cntrActCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRfubFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrDispFlg   =  null;
	/*	Column Info	*/
	private  String	 imdtExtFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrXchCd   =  null;
	/*	Column Info	*/
	private  String	 inlndTrspLicNo   =  null;
	/*	Column Info	*/
	private  String	 ctrtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 ctrtSeq   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiTpCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgTpId   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgAreaCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgYrmondy   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgSeq   =  null;
	/*	Column Info	*/
	private  String	 wblNo   =  null;
	/*	Column Info	*/
	private  String	 pkupNo   =  null;
	/*	Column Info	*/
	private  String	 cntrStsSeq   =  null;
	/*	Column Info	*/
	private  String	 callSgnNo   =  null;
	/*	Column Info	*/
	private  String	 lloydNo   =  null;
	/*	Column Info	*/
	private  String	 mtyRepoVlRmk   =  null;
	/*	Column Info	*/
	private  String	 mvmtInpTpCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvCoCd   =  null;
	/*	Column Info	*/
	private  String	 sysAreaGrpId   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 preStsFlg   =  null;
	/*	Column Info	*/
	private  String	 gmtDt   =  null;
	/*	Column Info	*/
	private  String	 creLoclDt   =  null;
	/*	Column Info	*/
	private  String	 updLoclDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 woNo   =  null;
	/*	Column Info	*/
	private  String	 ediVvdCd   =  null;
	/*	Column Info	*/
	private  String	 tirNo   =  null;
	/*	Column Info	*/
	private  String	 mtyPlnNo   =  null;
	/*	Column Info	*/
	private  String	 mtyRepoNo   =  null;
	/*	Column Info	*/
	private  String	 ediCrrNo   =  null;
	/*	Column Info	*/
	private  String	 trspDocNo   =  null;
	/*	Column Info	*/
	private  String	 oscaBkgFlg   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblValDesc   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNmDesc   =  null;
	/*	Column Info	*/
	private  String	 edwUpdDt   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 vslLocCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AutoMtBkgVO(){}

	public AutoMtBkgVO(String apCtrlOfcCd,String cntrNo,String vslCd,String skdVoyNo,String skdDirCd,String fmYdCd,String toYdCd,String coCd,String mtyBkgNo,String cmBkgNo,String bkgNo,String checkCase,String cnmvYr,String cnmvIdNo,String cnmvSeq,String cnmvSplitNo,String cntrTpszCd,String mvmtStsCd,String bkgCgoTpCd,String cnmvCycNo,String cnmvLvlNo,String cnmvEvntDt,String destYdCd,String inpYdCd,String orgYdCd,String trnkVslCd,String trnkSkdVoyNo,String trnkSkdDirCd,String chssNo,String mgstNo,String cntrSealNo,String cntrDmgFlg,String fcntrFlg,String obCntrFlg,String bkgRcvTermCd,String vndrSeq,String mvmtTrspModCd,String locCd,String cnmvRmk,String chssMgstMvmtRmk,String usNm,String mvmtCreTpCd,String substRuleCd,String spclCgoFlg,String bkgKnt,String blNo,String cntrHngrRckFlg,String cntrHngrBarAtchKnt,String cntrActCd,String cntrRfubFlg,String cntrDispFlg,String imdtExtFlg,String cntrXchCd,String inlndTrspLicNo,String ctrtOfcCtyCd,String ctrtSeq,String mvmtEdiTpCd,String mvmtEdiMsgTpId,String mvmtEdiMsgAreaCd,String mvmtEdiMsgYrmondy,String mvmtEdiMsgSeq,String wblNo,String pkupNo,String cntrStsSeq,String callSgnNo,String lloydNo,String mtyRepoVlRmk,String mvmtInpTpCd,String cnmvCoCd,String sysAreaGrpId,String ofcCd,String preStsFlg,String gmtDt,String creLoclDt,String updLoclDt,String creUsrId,String creDt,String updUsrId,String updDt,String woNo,String ediVvdCd,String tirNo,String mtyPlnNo,String mtyRepoNo,String ediCrrNo,String trspDocNo,String oscaBkgFlg,String rstrUsgLblValDesc,String rstrUsgLblNmDesc,String edwUpdDt,String slanCd,String vslLocCd)	{
		this.apCtrlOfcCd  = apCtrlOfcCd ;
		this.cntrNo  = cntrNo ;
		this.vslCd  = vslCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.skdDirCd  = skdDirCd ;
		this.fmYdCd  = fmYdCd ;
		this.toYdCd  = toYdCd ;
		this.coCd  = coCd ;
		this.mtyBkgNo  = mtyBkgNo ;
		this.cmBkgNo  = cmBkgNo ;
		this.bkgNo  = bkgNo ;
		this.checkCase  = checkCase ;
		this.cnmvYr  = cnmvYr ;
		this.cnmvIdNo  = cnmvIdNo ;
		this.cnmvSeq  = cnmvSeq ;
		this.cnmvSplitNo  = cnmvSplitNo ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.mvmtStsCd  = mvmtStsCd ;
		this.bkgCgoTpCd  = bkgCgoTpCd ;
		this.cnmvCycNo  = cnmvCycNo ;
		this.cnmvLvlNo  = cnmvLvlNo ;
		this.cnmvEvntDt  = cnmvEvntDt ;
		this.destYdCd  = destYdCd ;
		this.inpYdCd  = inpYdCd ;
		this.orgYdCd  = orgYdCd ;
		this.trnkVslCd  = trnkVslCd ;
		this.trnkSkdVoyNo  = trnkSkdVoyNo ;
		this.trnkSkdDirCd  = trnkSkdDirCd ;
		this.chssNo  = chssNo ;
		this.mgstNo  = mgstNo ;
		this.cntrSealNo  = cntrSealNo ;
		this.cntrDmgFlg  = cntrDmgFlg ;
		this.fcntrFlg  = fcntrFlg ;
		this.obCntrFlg  = obCntrFlg ;
		this.bkgRcvTermCd  = bkgRcvTermCd ;
		this.vndrSeq  = vndrSeq ;
		this.mvmtTrspModCd  = mvmtTrspModCd ;
		this.locCd  = locCd ;
		this.cnmvRmk  = cnmvRmk ;
		this.chssMgstMvmtRmk  = chssMgstMvmtRmk ;
		this.usNm  = usNm ;
		this.mvmtCreTpCd  = mvmtCreTpCd ;
		this.substRuleCd  = substRuleCd ;
		this.spclCgoFlg  = spclCgoFlg ;
		this.bkgKnt  = bkgKnt ;
		this.blNo  = blNo ;
		this.cntrHngrRckFlg  = cntrHngrRckFlg ;
		this.cntrHngrBarAtchKnt  = cntrHngrBarAtchKnt ;
		this.cntrActCd  = cntrActCd ;
		this.cntrRfubFlg  = cntrRfubFlg ;
		this.cntrDispFlg  = cntrDispFlg ;
		this.imdtExtFlg  = imdtExtFlg ;
		this.cntrXchCd  = cntrXchCd ;
		this.inlndTrspLicNo  = inlndTrspLicNo ;
		this.ctrtOfcCtyCd  = ctrtOfcCtyCd ;
		this.ctrtSeq  = ctrtSeq ;
		this.mvmtEdiTpCd  = mvmtEdiTpCd ;
		this.mvmtEdiMsgTpId  = mvmtEdiMsgTpId ;
		this.mvmtEdiMsgAreaCd  = mvmtEdiMsgAreaCd ;
		this.mvmtEdiMsgYrmondy  = mvmtEdiMsgYrmondy ;
		this.mvmtEdiMsgSeq  = mvmtEdiMsgSeq ;
		this.wblNo  = wblNo ;
		this.pkupNo  = pkupNo ;
		this.cntrStsSeq  = cntrStsSeq ;
		this.callSgnNo  = callSgnNo ;
		this.lloydNo  = lloydNo ;
		this.mtyRepoVlRmk  = mtyRepoVlRmk ;
		this.mvmtInpTpCd  = mvmtInpTpCd ;
		this.cnmvCoCd  = cnmvCoCd ;
		this.sysAreaGrpId  = sysAreaGrpId ;
		this.ofcCd  = ofcCd ;
		this.preStsFlg  = preStsFlg ;
		this.gmtDt  = gmtDt ;
		this.creLoclDt  = creLoclDt ;
		this.updLoclDt  = updLoclDt ;
		this.creUsrId  = creUsrId ;
		this.creDt  = creDt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.woNo  = woNo ;
		this.ediVvdCd  = ediVvdCd ;
		this.tirNo  = tirNo ;
		this.mtyPlnNo  = mtyPlnNo ;
		this.mtyRepoNo  = mtyRepoNo ;
		this.ediCrrNo  = ediCrrNo ;
		this.trspDocNo  = trspDocNo ;
		this.oscaBkgFlg  = oscaBkgFlg ;
		this.rstrUsgLblValDesc  = rstrUsgLblValDesc ;
		this.rstrUsgLblNmDesc  = rstrUsgLblNmDesc ;
		this.edwUpdDt  = edwUpdDt ;
		this.slanCd  = slanCd ;
		this.vslLocCd  = vslLocCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("fm_yd_cd", getFmYdCd());		
		this.hashColumns.put("to_yd_cd", getToYdCd());		
		this.hashColumns.put("co_cd", getCoCd());		
		this.hashColumns.put("mty_bkg_no", getMtyBkgNo());		
		this.hashColumns.put("cm_bkg_no", getCmBkgNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("check_case", getCheckCase());		
		this.hashColumns.put("cnmv_yr", getCnmvYr());		
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());		
		this.hashColumns.put("cnmv_seq", getCnmvSeq());		
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());		
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());		
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());		
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());		
		this.hashColumns.put("dest_yd_cd", getDestYdCd());		
		this.hashColumns.put("inp_yd_cd", getInpYdCd());		
		this.hashColumns.put("org_yd_cd", getOrgYdCd());		
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());		
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());		
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());		
		this.hashColumns.put("chss_no", getChssNo());		
		this.hashColumns.put("mgst_no", getMgstNo());		
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());		
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());		
		this.hashColumns.put("fcntr_flg", getFcntrFlg());		
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());		
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());		
		this.hashColumns.put("chss_mgst_mvmt_rmk", getChssMgstMvmtRmk());		
		this.hashColumns.put("us_nm", getUsNm());		
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());		
		this.hashColumns.put("subst_rule_cd", getSubstRuleCd());		
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());		
		this.hashColumns.put("bkg_knt", getBkgKnt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());		
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());		
		this.hashColumns.put("cntr_act_cd", getCntrActCd());		
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());		
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());		
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());		
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());		
		this.hashColumns.put("inlnd_trsp_lic_no", getInlndTrspLicNo());		
		this.hashColumns.put("ctrt_ofc_cty_cd", getCtrtOfcCtyCd());		
		this.hashColumns.put("ctrt_seq", getCtrtSeq());		
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());		
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());		
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());		
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());		
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());		
		this.hashColumns.put("wbl_no", getWblNo());		
		this.hashColumns.put("pkup_no", getPkupNo());		
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());		
		this.hashColumns.put("call_sgn_no", getCallSgnNo());		
		this.hashColumns.put("lloyd_no", getLloydNo());		
		this.hashColumns.put("mty_repo_vl_rmk", getMtyRepoVlRmk());		
		this.hashColumns.put("mvmt_inp_tp_cd", getMvmtInpTpCd());		
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());		
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());		
		this.hashColumns.put("gmt_dt", getGmtDt());		
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());		
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("wo_no", getWoNo());		
		this.hashColumns.put("edi_vvd_cd", getEdiVvdCd());		
		this.hashColumns.put("tir_no", getTirNo());		
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());		
		this.hashColumns.put("mty_repo_no", getMtyRepoNo());		
		this.hashColumns.put("edi_crr_no", getEdiCrrNo());		
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());		
		this.hashColumns.put("osca_bkg_flg", getOscaBkgFlg());		
		this.hashColumns.put("rstr_usg_lbl_val_desc", getRstrUsgLblValDesc());		
		this.hashColumns.put("rstr_usg_lbl_nm_desc", getRstrUsgLblNmDesc());		
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("vsl_loc_cd", getVslLocCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("mty_bkg_no", "mtyBkgNo");
		this.hashFields.put("cm_bkg_no", "cmBkgNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("check_case", "checkCase");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("inp_yd_cd", "inpYdCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("chss_mgst_mvmt_rmk", "chssMgstMvmtRmk");
		this.hashFields.put("us_nm", "usNm");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("subst_rule_cd", "substRuleCd");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_act_cd", "cntrActCd");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("inlnd_trsp_lic_no", "inlndTrspLicNo");
		this.hashFields.put("ctrt_ofc_cty_cd", "ctrtOfcCtyCd");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("mty_repo_vl_rmk", "mtyRepoVlRmk");
		this.hashFields.put("mvmt_inp_tp_cd", "mvmtInpTpCd");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("edi_vvd_cd", "ediVvdCd");
		this.hashFields.put("tir_no", "tirNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("mty_repo_no", "mtyRepoNo");
		this.hashFields.put("edi_crr_no", "ediCrrNo");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("osca_bkg_flg", "oscaBkgFlg");
		this.hashFields.put("rstr_usg_lbl_val_desc", "rstrUsgLblValDesc");
		this.hashFields.put("rstr_usg_lbl_nm_desc", "rstrUsgLblNmDesc");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_loc_cd", "vslLocCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  apCtrlOfcCd
	*/
	public void	setApCtrlOfcCd( String	apCtrlOfcCd ) {
		this.apCtrlOfcCd =	apCtrlOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	apCtrlOfcCd
	 */
	 public	 String	getApCtrlOfcCd() {
		 return	this.apCtrlOfcCd;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
	 } 
 	/**
	* Column Info
	* @param  fmYdCd
	*/
	public void	setFmYdCd( String	fmYdCd ) {
		this.fmYdCd =	fmYdCd;
	}
 
	/**
	 * Column Info
	 * @return	fmYdCd
	 */
	 public	 String	getFmYdCd() {
		 return	this.fmYdCd;
	 } 
 	/**
	* Column Info
	* @param  toYdCd
	*/
	public void	setToYdCd( String	toYdCd ) {
		this.toYdCd =	toYdCd;
	}
 
	/**
	 * Column Info
	 * @return	toYdCd
	 */
	 public	 String	getToYdCd() {
		 return	this.toYdCd;
	 } 
 	/**
	* Column Info
	* @param  coCd
	*/
	public void	setCoCd( String	coCd ) {
		this.coCd =	coCd;
	}
 
	/**
	 * Column Info
	 * @return	coCd
	 */
	 public	 String	getCoCd() {
		 return	this.coCd;
	 } 
 	/**
	* Column Info
	* @param  mtyBkgNo
	*/
	public void	setMtyBkgNo( String	mtyBkgNo ) {
		this.mtyBkgNo =	mtyBkgNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyBkgNo
	 */
	 public	 String	getMtyBkgNo() {
		 return	this.mtyBkgNo;
	 } 
 	/**
	* Column Info
	* @param  cmBkgNo
	*/
	public void	setCmBkgNo( String	cmBkgNo ) {
		this.cmBkgNo =	cmBkgNo;
	}
 
	/**
	 * Column Info
	 * @return	cmBkgNo
	 */
	 public	 String	getCmBkgNo() {
		 return	this.cmBkgNo;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  checkCase
	*/
	public void	setCheckCase( String	checkCase ) {
		this.checkCase =	checkCase;
	}
 
	/**
	 * Column Info
	 * @return	checkCase
	 */
	 public	 String	getCheckCase() {
		 return	this.checkCase;
	 } 
 	/**
	* Column Info
	* @param  cnmvYr
	*/
	public void	setCnmvYr( String	cnmvYr ) {
		this.cnmvYr =	cnmvYr;
	}
 
	/**
	 * Column Info
	 * @return	cnmvYr
	 */
	 public	 String	getCnmvYr() {
		 return	this.cnmvYr;
	 } 
 	/**
	* Column Info
	* @param  cnmvIdNo
	*/
	public void	setCnmvIdNo( String	cnmvIdNo ) {
		this.cnmvIdNo =	cnmvIdNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvIdNo
	 */
	 public	 String	getCnmvIdNo() {
		 return	this.cnmvIdNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvSeq
	*/
	public void	setCnmvSeq( String	cnmvSeq ) {
		this.cnmvSeq =	cnmvSeq;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSeq
	 */
	 public	 String	getCnmvSeq() {
		 return	this.cnmvSeq;
	 } 
 	/**
	* Column Info
	* @param  cnmvSplitNo
	*/
	public void	setCnmvSplitNo( String	cnmvSplitNo ) {
		this.cnmvSplitNo =	cnmvSplitNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSplitNo
	 */
	 public	 String	getCnmvSplitNo() {
		 return	this.cnmvSplitNo;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtStsCd
	*/
	public void	setMvmtStsCd( String	mvmtStsCd ) {
		this.mvmtStsCd =	mvmtStsCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtStsCd
	 */
	 public	 String	getMvmtStsCd() {
		 return	this.mvmtStsCd;
	 } 
 	/**
	* Column Info
	* @param  bkgCgoTpCd
	*/
	public void	setBkgCgoTpCd( String	bkgCgoTpCd ) {
		this.bkgCgoTpCd =	bkgCgoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCgoTpCd
	 */
	 public	 String	getBkgCgoTpCd() {
		 return	this.bkgCgoTpCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvCycNo
	*/
	public void	setCnmvCycNo( String	cnmvCycNo ) {
		this.cnmvCycNo =	cnmvCycNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCycNo
	 */
	 public	 String	getCnmvCycNo() {
		 return	this.cnmvCycNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvLvlNo
	*/
	public void	setCnmvLvlNo( String	cnmvLvlNo ) {
		this.cnmvLvlNo =	cnmvLvlNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvLvlNo
	 */
	 public	 String	getCnmvLvlNo() {
		 return	this.cnmvLvlNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvEvntDt
	*/
	public void	setCnmvEvntDt( String	cnmvEvntDt ) {
		this.cnmvEvntDt =	cnmvEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvEvntDt
	 */
	 public	 String	getCnmvEvntDt() {
		 return	this.cnmvEvntDt;
	 } 
 	/**
	* Column Info
	* @param  destYdCd
	*/
	public void	setDestYdCd( String	destYdCd ) {
		this.destYdCd =	destYdCd;
	}
 
	/**
	 * Column Info
	 * @return	destYdCd
	 */
	 public	 String	getDestYdCd() {
		 return	this.destYdCd;
	 } 
 	/**
	* Column Info
	* @param  inpYdCd
	*/
	public void	setInpYdCd( String	inpYdCd ) {
		this.inpYdCd =	inpYdCd;
	}
 
	/**
	 * Column Info
	 * @return	inpYdCd
	 */
	 public	 String	getInpYdCd() {
		 return	this.inpYdCd;
	 } 
 	/**
	* Column Info
	* @param  orgYdCd
	*/
	public void	setOrgYdCd( String	orgYdCd ) {
		this.orgYdCd =	orgYdCd;
	}
 
	/**
	 * Column Info
	 * @return	orgYdCd
	 */
	 public	 String	getOrgYdCd() {
		 return	this.orgYdCd;
	 } 
 	/**
	* Column Info
	* @param  trnkVslCd
	*/
	public void	setTrnkVslCd( String	trnkVslCd ) {
		this.trnkVslCd =	trnkVslCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkVslCd
	 */
	 public	 String	getTrnkVslCd() {
		 return	this.trnkVslCd;
	 } 
 	/**
	* Column Info
	* @param  trnkSkdVoyNo
	*/
	public void	setTrnkSkdVoyNo( String	trnkSkdVoyNo ) {
		this.trnkSkdVoyNo =	trnkSkdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	trnkSkdVoyNo
	 */
	 public	 String	getTrnkSkdVoyNo() {
		 return	this.trnkSkdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  trnkSkdDirCd
	*/
	public void	setTrnkSkdDirCd( String	trnkSkdDirCd ) {
		this.trnkSkdDirCd =	trnkSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkSkdDirCd
	 */
	 public	 String	getTrnkSkdDirCd() {
		 return	this.trnkSkdDirCd;
	 } 
 	/**
	* Column Info
	* @param  chssNo
	*/
	public void	setChssNo( String	chssNo ) {
		this.chssNo =	chssNo;
	}
 
	/**
	 * Column Info
	 * @return	chssNo
	 */
	 public	 String	getChssNo() {
		 return	this.chssNo;
	 } 
 	/**
	* Column Info
	* @param  mgstNo
	*/
	public void	setMgstNo( String	mgstNo ) {
		this.mgstNo =	mgstNo;
	}
 
	/**
	 * Column Info
	 * @return	mgstNo
	 */
	 public	 String	getMgstNo() {
		 return	this.mgstNo;
	 } 
 	/**
	* Column Info
	* @param  cntrSealNo
	*/
	public void	setCntrSealNo( String	cntrSealNo ) {
		this.cntrSealNo =	cntrSealNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSealNo
	 */
	 public	 String	getCntrSealNo() {
		 return	this.cntrSealNo;
	 } 
 	/**
	* Column Info
	* @param  cntrDmgFlg
	*/
	public void	setCntrDmgFlg( String	cntrDmgFlg ) {
		this.cntrDmgFlg =	cntrDmgFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrDmgFlg
	 */
	 public	 String	getCntrDmgFlg() {
		 return	this.cntrDmgFlg;
	 } 
 	/**
	* Column Info
	* @param  fcntrFlg
	*/
	public void	setFcntrFlg( String	fcntrFlg ) {
		this.fcntrFlg =	fcntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	fcntrFlg
	 */
	 public	 String	getFcntrFlg() {
		 return	this.fcntrFlg;
	 } 
 	/**
	* Column Info
	* @param  obCntrFlg
	*/
	public void	setObCntrFlg( String	obCntrFlg ) {
		this.obCntrFlg =	obCntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	obCntrFlg
	 */
	 public	 String	getObCntrFlg() {
		 return	this.obCntrFlg;
	 } 
 	/**
	* Column Info
	* @param  bkgRcvTermCd
	*/
	public void	setBkgRcvTermCd( String	bkgRcvTermCd ) {
		this.bkgRcvTermCd =	bkgRcvTermCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgRcvTermCd
	 */
	 public	 String	getBkgRcvTermCd() {
		 return	this.bkgRcvTermCd;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  mvmtTrspModCd
	*/
	public void	setMvmtTrspModCd( String	mvmtTrspModCd ) {
		this.mvmtTrspModCd =	mvmtTrspModCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtTrspModCd
	 */
	 public	 String	getMvmtTrspModCd() {
		 return	this.mvmtTrspModCd;
	 } 
 	/**
	* Column Info
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvRmk
	*/
	public void	setCnmvRmk( String	cnmvRmk ) {
		this.cnmvRmk =	cnmvRmk;
	}
 
	/**
	 * Column Info
	 * @return	cnmvRmk
	 */
	 public	 String	getCnmvRmk() {
		 return	this.cnmvRmk;
	 } 
 	/**
	* Column Info
	* @param  chssMgstMvmtRmk
	*/
	public void	setChssMgstMvmtRmk( String	chssMgstMvmtRmk ) {
		this.chssMgstMvmtRmk =	chssMgstMvmtRmk;
	}
 
	/**
	 * Column Info
	 * @return	chssMgstMvmtRmk
	 */
	 public	 String	getChssMgstMvmtRmk() {
		 return	this.chssMgstMvmtRmk;
	 } 
 	/**
	* Column Info
	* @param  usNm
	*/
	public void	setUsNm( String	usNm ) {
		this.usNm =	usNm;
	}
 
	/**
	 * Column Info
	 * @return	usNm
	 */
	 public	 String	getUsNm() {
		 return	this.usNm;
	 } 
 	/**
	* Column Info
	* @param  mvmtCreTpCd
	*/
	public void	setMvmtCreTpCd( String	mvmtCreTpCd ) {
		this.mvmtCreTpCd =	mvmtCreTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtCreTpCd
	 */
	 public	 String	getMvmtCreTpCd() {
		 return	this.mvmtCreTpCd;
	 } 
 	/**
	* Column Info
	* @param  substRuleCd
	*/
	public void	setSubstRuleCd( String	substRuleCd ) {
		this.substRuleCd =	substRuleCd;
	}
 
	/**
	 * Column Info
	 * @return	substRuleCd
	 */
	 public	 String	getSubstRuleCd() {
		 return	this.substRuleCd;
	 } 
 	/**
	* Column Info
	* @param  spclCgoFlg
	*/
	public void	setSpclCgoFlg( String	spclCgoFlg ) {
		this.spclCgoFlg =	spclCgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	spclCgoFlg
	 */
	 public	 String	getSpclCgoFlg() {
		 return	this.spclCgoFlg;
	 } 
 	/**
	* Column Info
	* @param  bkgKnt
	*/
	public void	setBkgKnt( String	bkgKnt ) {
		this.bkgKnt =	bkgKnt;
	}
 
	/**
	 * Column Info
	 * @return	bkgKnt
	 */
	 public	 String	getBkgKnt() {
		 return	this.bkgKnt;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrRckFlg
	*/
	public void	setCntrHngrRckFlg( String	cntrHngrRckFlg ) {
		this.cntrHngrRckFlg =	cntrHngrRckFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckFlg
	 */
	 public	 String	getCntrHngrRckFlg() {
		 return	this.cntrHngrRckFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrBarAtchKnt
	*/
	public void	setCntrHngrBarAtchKnt( String	cntrHngrBarAtchKnt ) {
		this.cntrHngrBarAtchKnt =	cntrHngrBarAtchKnt;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrBarAtchKnt
	 */
	 public	 String	getCntrHngrBarAtchKnt() {
		 return	this.cntrHngrBarAtchKnt;
	 } 
 	/**
	* Column Info
	* @param  cntrActCd
	*/
	public void	setCntrActCd( String	cntrActCd ) {
		this.cntrActCd =	cntrActCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrActCd
	 */
	 public	 String	getCntrActCd() {
		 return	this.cntrActCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRfubFlg
	*/
	public void	setCntrRfubFlg( String	cntrRfubFlg ) {
		this.cntrRfubFlg =	cntrRfubFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrRfubFlg
	 */
	 public	 String	getCntrRfubFlg() {
		 return	this.cntrRfubFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrDispFlg
	*/
	public void	setCntrDispFlg( String	cntrDispFlg ) {
		this.cntrDispFlg =	cntrDispFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrDispFlg
	 */
	 public	 String	getCntrDispFlg() {
		 return	this.cntrDispFlg;
	 } 
 	/**
	* Column Info
	* @param  imdtExtFlg
	*/
	public void	setImdtExtFlg( String	imdtExtFlg ) {
		this.imdtExtFlg =	imdtExtFlg;
	}
 
	/**
	 * Column Info
	 * @return	imdtExtFlg
	 */
	 public	 String	getImdtExtFlg() {
		 return	this.imdtExtFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrXchCd
	*/
	public void	setCntrXchCd( String	cntrXchCd ) {
		this.cntrXchCd =	cntrXchCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrXchCd
	 */
	 public	 String	getCntrXchCd() {
		 return	this.cntrXchCd;
	 } 
 	/**
	* Column Info
	* @param  inlndTrspLicNo
	*/
	public void	setInlndTrspLicNo( String	inlndTrspLicNo ) {
		this.inlndTrspLicNo =	inlndTrspLicNo;
	}
 
	/**
	 * Column Info
	 * @return	inlndTrspLicNo
	 */
	 public	 String	getInlndTrspLicNo() {
		 return	this.inlndTrspLicNo;
	 } 
 	/**
	* Column Info
	* @param  ctrtOfcCtyCd
	*/
	public void	setCtrtOfcCtyCd( String	ctrtOfcCtyCd ) {
		this.ctrtOfcCtyCd =	ctrtOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	ctrtOfcCtyCd
	 */
	 public	 String	getCtrtOfcCtyCd() {
		 return	this.ctrtOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  ctrtSeq
	*/
	public void	setCtrtSeq( String	ctrtSeq ) {
		this.ctrtSeq =	ctrtSeq;
	}
 
	/**
	 * Column Info
	 * @return	ctrtSeq
	 */
	 public	 String	getCtrtSeq() {
		 return	this.ctrtSeq;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiTpCd
	*/
	public void	setMvmtEdiTpCd( String	mvmtEdiTpCd ) {
		this.mvmtEdiTpCd =	mvmtEdiTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiTpCd
	 */
	 public	 String	getMvmtEdiTpCd() {
		 return	this.mvmtEdiTpCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgTpId
	*/
	public void	setMvmtEdiMsgTpId( String	mvmtEdiMsgTpId ) {
		this.mvmtEdiMsgTpId =	mvmtEdiMsgTpId;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgTpId
	 */
	 public	 String	getMvmtEdiMsgTpId() {
		 return	this.mvmtEdiMsgTpId;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgAreaCd
	*/
	public void	setMvmtEdiMsgAreaCd( String	mvmtEdiMsgAreaCd ) {
		this.mvmtEdiMsgAreaCd =	mvmtEdiMsgAreaCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgAreaCd
	 */
	 public	 String	getMvmtEdiMsgAreaCd() {
		 return	this.mvmtEdiMsgAreaCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgYrmondy
	*/
	public void	setMvmtEdiMsgYrmondy( String	mvmtEdiMsgYrmondy ) {
		this.mvmtEdiMsgYrmondy =	mvmtEdiMsgYrmondy;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgYrmondy
	 */
	 public	 String	getMvmtEdiMsgYrmondy() {
		 return	this.mvmtEdiMsgYrmondy;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgSeq
	*/
	public void	setMvmtEdiMsgSeq( String	mvmtEdiMsgSeq ) {
		this.mvmtEdiMsgSeq =	mvmtEdiMsgSeq;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgSeq
	 */
	 public	 String	getMvmtEdiMsgSeq() {
		 return	this.mvmtEdiMsgSeq;
	 } 
 	/**
	* Column Info
	* @param  wblNo
	*/
	public void	setWblNo( String	wblNo ) {
		this.wblNo =	wblNo;
	}
 
	/**
	 * Column Info
	 * @return	wblNo
	 */
	 public	 String	getWblNo() {
		 return	this.wblNo;
	 } 
 	/**
	* Column Info
	* @param  pkupNo
	*/
	public void	setPkupNo( String	pkupNo ) {
		this.pkupNo =	pkupNo;
	}
 
	/**
	 * Column Info
	 * @return	pkupNo
	 */
	 public	 String	getPkupNo() {
		 return	this.pkupNo;
	 } 
 	/**
	* Column Info
	* @param  cntrStsSeq
	*/
	public void	setCntrStsSeq( String	cntrStsSeq ) {
		this.cntrStsSeq =	cntrStsSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsSeq
	 */
	 public	 String	getCntrStsSeq() {
		 return	this.cntrStsSeq;
	 } 
 	/**
	* Column Info
	* @param  callSgnNo
	*/
	public void	setCallSgnNo( String	callSgnNo ) {
		this.callSgnNo =	callSgnNo;
	}
 
	/**
	 * Column Info
	 * @return	callSgnNo
	 */
	 public	 String	getCallSgnNo() {
		 return	this.callSgnNo;
	 } 
 	/**
	* Column Info
	* @param  lloydNo
	*/
	public void	setLloydNo( String	lloydNo ) {
		this.lloydNo =	lloydNo;
	}
 
	/**
	 * Column Info
	 * @return	lloydNo
	 */
	 public	 String	getLloydNo() {
		 return	this.lloydNo;
	 } 
 	/**
	* Column Info
	* @param  mtyRepoVlRmk
	*/
	public void	setMtyRepoVlRmk( String	mtyRepoVlRmk ) {
		this.mtyRepoVlRmk =	mtyRepoVlRmk;
	}
 
	/**
	 * Column Info
	 * @return	mtyRepoVlRmk
	 */
	 public	 String	getMtyRepoVlRmk() {
		 return	this.mtyRepoVlRmk;
	 } 
 	/**
	* Column Info
	* @param  mvmtInpTpCd
	*/
	public void	setMvmtInpTpCd( String	mvmtInpTpCd ) {
		this.mvmtInpTpCd =	mvmtInpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtInpTpCd
	 */
	 public	 String	getMvmtInpTpCd() {
		 return	this.mvmtInpTpCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvCoCd
	*/
	public void	setCnmvCoCd( String	cnmvCoCd ) {
		this.cnmvCoCd =	cnmvCoCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCoCd
	 */
	 public	 String	getCnmvCoCd() {
		 return	this.cnmvCoCd;
	 } 
 	/**
	* Column Info
	* @param  sysAreaGrpId
	*/
	public void	setSysAreaGrpId( String	sysAreaGrpId ) {
		this.sysAreaGrpId =	sysAreaGrpId;
	}
 
	/**
	 * Column Info
	 * @return	sysAreaGrpId
	 */
	 public	 String	getSysAreaGrpId() {
		 return	this.sysAreaGrpId;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  preStsFlg
	*/
	public void	setPreStsFlg( String	preStsFlg ) {
		this.preStsFlg =	preStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	preStsFlg
	 */
	 public	 String	getPreStsFlg() {
		 return	this.preStsFlg;
	 } 
 	/**
	* Column Info
	* @param  gmtDt
	*/
	public void	setGmtDt( String	gmtDt ) {
		this.gmtDt =	gmtDt;
	}
 
	/**
	 * Column Info
	 * @return	gmtDt
	 */
	 public	 String	getGmtDt() {
		 return	this.gmtDt;
	 } 
 	/**
	* Column Info
	* @param  creLoclDt
	*/
	public void	setCreLoclDt( String	creLoclDt ) {
		this.creLoclDt =	creLoclDt;
	}
 
	/**
	 * Column Info
	 * @return	creLoclDt
	 */
	 public	 String	getCreLoclDt() {
		 return	this.creLoclDt;
	 } 
 	/**
	* Column Info
	* @param  updLoclDt
	*/
	public void	setUpdLoclDt( String	updLoclDt ) {
		this.updLoclDt =	updLoclDt;
	}
 
	/**
	 * Column Info
	 * @return	updLoclDt
	 */
	 public	 String	getUpdLoclDt() {
		 return	this.updLoclDt;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	 String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  woNo
	*/
	public void	setWoNo( String	woNo ) {
		this.woNo =	woNo;
	}
 
	/**
	 * Column Info
	 * @return	woNo
	 */
	 public	 String	getWoNo() {
		 return	this.woNo;
	 } 
 	/**
	* Column Info
	* @param  ediVvdCd
	*/
	public void	setEdiVvdCd( String	ediVvdCd ) {
		this.ediVvdCd =	ediVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	ediVvdCd
	 */
	 public	 String	getEdiVvdCd() {
		 return	this.ediVvdCd;
	 } 
 	/**
	* Column Info
	* @param  tirNo
	*/
	public void	setTirNo( String	tirNo ) {
		this.tirNo =	tirNo;
	}
 
	/**
	 * Column Info
	 * @return	tirNo
	 */
	 public	 String	getTirNo() {
		 return	this.tirNo;
	 } 
 	/**
	* Column Info
	* @param  mtyPlnNo
	*/
	public void	setMtyPlnNo( String	mtyPlnNo ) {
		this.mtyPlnNo =	mtyPlnNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyPlnNo
	 */
	 public	 String	getMtyPlnNo() {
		 return	this.mtyPlnNo;
	 } 
 	/**
	* Column Info
	* @param  mtyRepoNo
	*/
	public void	setMtyRepoNo( String	mtyRepoNo ) {
		this.mtyRepoNo =	mtyRepoNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyRepoNo
	 */
	 public	 String	getMtyRepoNo() {
		 return	this.mtyRepoNo;
	 } 
 	/**
	* Column Info
	* @param  ediCrrNo
	*/
	public void	setEdiCrrNo( String	ediCrrNo ) {
		this.ediCrrNo =	ediCrrNo;
	}
 
	/**
	 * Column Info
	 * @return	ediCrrNo
	 */
	 public	 String	getEdiCrrNo() {
		 return	this.ediCrrNo;
	 } 
 	/**
	* Column Info
	* @param  trspDocNo
	*/
	public void	setTrspDocNo( String	trspDocNo ) {
		this.trspDocNo =	trspDocNo;
	}
 
	/**
	 * Column Info
	 * @return	trspDocNo
	 */
	 public	 String	getTrspDocNo() {
		 return	this.trspDocNo;
	 } 
 	/**
	* Column Info
	* @param  oscaBkgFlg
	*/
	public void	setOscaBkgFlg( String	oscaBkgFlg ) {
		this.oscaBkgFlg =	oscaBkgFlg;
	}
 
	/**
	 * Column Info
	 * @return	oscaBkgFlg
	 */
	 public	 String	getOscaBkgFlg() {
		 return	this.oscaBkgFlg;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblValDesc
	*/
	public void	setRstrUsgLblValDesc( String	rstrUsgLblValDesc ) {
		this.rstrUsgLblValDesc =	rstrUsgLblValDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblValDesc
	 */
	 public	 String	getRstrUsgLblValDesc() {
		 return	this.rstrUsgLblValDesc;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblNmDesc
	*/
	public void	setRstrUsgLblNmDesc( String	rstrUsgLblNmDesc ) {
		this.rstrUsgLblNmDesc =	rstrUsgLblNmDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblNmDesc
	 */
	 public	 String	getRstrUsgLblNmDesc() {
		 return	this.rstrUsgLblNmDesc;
	 } 
 	/**
	* Column Info
	* @param  edwUpdDt
	*/
	public void	setEdwUpdDt( String	edwUpdDt ) {
		this.edwUpdDt =	edwUpdDt;
	}
 
	/**
	 * Column Info
	 * @return	edwUpdDt
	 */
	 public	 String	getEdwUpdDt() {
		 return	this.edwUpdDt;
	 } 
 	/**
	* Column Info
	* @param  slanCd
	*/
	public void	setSlanCd( String	slanCd ) {
		this.slanCd =	slanCd;
	}
 
	/**
	 * Column Info
	 * @return	slanCd
	 */
	 public	 String	getSlanCd() {
		 return	this.slanCd;
	 } 
 	/**
	* Column Info
	* @param  vslLocCd
	*/
	public void	setVslLocCd( String	vslLocCd ) {
		this.vslLocCd =	vslLocCd;
	}
 
	/**
	 * Column Info
	 * @return	vslLocCd
	 */
	 public	 String	getVslLocCd() {
		 return	this.vslLocCd;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setApCtrlOfcCd(JSPUtil.getParameter(request,	prefix + "ap_ctrl_ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request,	prefix + "fm_yd_cd", ""));
		setToYdCd(JSPUtil.getParameter(request,	prefix + "to_yd_cd", ""));
		setCoCd(JSPUtil.getParameter(request,	prefix + "co_cd", ""));
		setMtyBkgNo(JSPUtil.getParameter(request,	prefix + "mty_bkg_no", ""));
		setCmBkgNo(JSPUtil.getParameter(request,	prefix + "cm_bkg_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCheckCase(JSPUtil.getParameter(request,	prefix + "check_case", ""));
		setCnmvYr(JSPUtil.getParameter(request,	prefix + "cnmv_yr", ""));
		setCnmvIdNo(JSPUtil.getParameter(request,	prefix + "cnmv_id_no", ""));
		setCnmvSeq(JSPUtil.getParameter(request,	prefix + "cnmv_seq", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request,	prefix + "cnmv_split_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request,	prefix + "mvmt_sts_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cgo_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request,	prefix + "cnmv_cyc_no", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request,	prefix + "cnmv_lvl_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request,	prefix + "cnmv_evnt_dt", ""));
		setDestYdCd(JSPUtil.getParameter(request,	prefix + "dest_yd_cd", ""));
		setInpYdCd(JSPUtil.getParameter(request,	prefix + "inp_yd_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request,	prefix + "org_yd_cd", ""));
		setTrnkVslCd(JSPUtil.getParameter(request,	prefix + "trnk_vsl_cd", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request,	prefix + "trnk_skd_voy_no", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request,	prefix + "trnk_skd_dir_cd", ""));
		setChssNo(JSPUtil.getParameter(request,	prefix + "chss_no", ""));
		setMgstNo(JSPUtil.getParameter(request,	prefix + "mgst_no", ""));
		setCntrSealNo(JSPUtil.getParameter(request,	prefix + "cntr_seal_no", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request,	prefix + "cntr_dmg_flg", ""));
		setFcntrFlg(JSPUtil.getParameter(request,	prefix + "fcntr_flg", ""));
		setObCntrFlg(JSPUtil.getParameter(request,	prefix + "ob_cntr_flg", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request,	prefix + "bkg_rcv_term_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request,	prefix + "mvmt_trsp_mod_cd", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setCnmvRmk(JSPUtil.getParameter(request,	prefix + "cnmv_rmk", ""));
		setChssMgstMvmtRmk(JSPUtil.getParameter(request,	prefix + "chss_mgst_mvmt_rmk", ""));
		setUsNm(JSPUtil.getParameter(request,	prefix + "us_nm", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_cre_tp_cd", ""));
		setSubstRuleCd(JSPUtil.getParameter(request,	prefix + "subst_rule_cd", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request,	prefix + "spcl_cgo_flg", ""));
		setBkgKnt(JSPUtil.getParameter(request,	prefix + "bkg_knt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_flg", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request,	prefix + "cntr_hngr_bar_atch_knt", ""));
		setCntrActCd(JSPUtil.getParameter(request,	prefix + "cntr_act_cd", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request,	prefix + "cntr_rfub_flg", ""));
		setCntrDispFlg(JSPUtil.getParameter(request,	prefix + "cntr_disp_flg", ""));
		setImdtExtFlg(JSPUtil.getParameter(request,	prefix + "imdt_ext_flg", ""));
		setCntrXchCd(JSPUtil.getParameter(request,	prefix + "cntr_xch_cd", ""));
		setInlndTrspLicNo(JSPUtil.getParameter(request,	prefix + "inlnd_trsp_lic_no", ""));
		setCtrtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "ctrt_ofc_cty_cd", ""));
		setCtrtSeq(JSPUtil.getParameter(request,	prefix + "ctrt_seq", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_tp_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_tp_id", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_area_cd", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_yrmondy", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_seq", ""));
		setWblNo(JSPUtil.getParameter(request,	prefix + "wbl_no", ""));
		setPkupNo(JSPUtil.getParameter(request,	prefix + "pkup_no", ""));
		setCntrStsSeq(JSPUtil.getParameter(request,	prefix + "cntr_sts_seq", ""));
		setCallSgnNo(JSPUtil.getParameter(request,	prefix + "call_sgn_no", ""));
		setLloydNo(JSPUtil.getParameter(request,	prefix + "lloyd_no", ""));
		setMtyRepoVlRmk(JSPUtil.getParameter(request,	prefix + "mty_repo_vl_rmk", ""));
		setMvmtInpTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_inp_tp_cd", ""));
		setCnmvCoCd(JSPUtil.getParameter(request,	prefix + "cnmv_co_cd", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request,	prefix + "sys_area_grp_id", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setPreStsFlg(JSPUtil.getParameter(request,	prefix + "pre_sts_flg", ""));
		setGmtDt(JSPUtil.getParameter(request,	prefix + "gmt_dt", ""));
		setCreLoclDt(JSPUtil.getParameter(request,	prefix + "cre_locl_dt", ""));
		setUpdLoclDt(JSPUtil.getParameter(request,	prefix + "upd_locl_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setWoNo(JSPUtil.getParameter(request,	prefix + "wo_no", ""));
		setEdiVvdCd(JSPUtil.getParameter(request,	prefix + "edi_vvd_cd", ""));
		setTirNo(JSPUtil.getParameter(request,	prefix + "tir_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request,	prefix + "mty_pln_no", ""));
		setMtyRepoNo(JSPUtil.getParameter(request,	prefix + "mty_repo_no", ""));
		setEdiCrrNo(JSPUtil.getParameter(request,	prefix + "edi_crr_no", ""));
		setTrspDocNo(JSPUtil.getParameter(request,	prefix + "trsp_doc_no", ""));
		setOscaBkgFlg(JSPUtil.getParameter(request,	prefix + "osca_bkg_flg", ""));
		setRstrUsgLblValDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_val_desc", ""));
		setRstrUsgLblNmDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm_desc", ""));
		setEdwUpdDt(JSPUtil.getParameter(request,	prefix + "edw_upd_dt", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setVslLocCd(JSPUtil.getParameter(request,	prefix + "vsl_loc_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AutoMtBkgVO[]
	 */
	public AutoMtBkgVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AutoMtBkgVO[]
	 */
	public AutoMtBkgVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AutoMtBkgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] apCtrlOfcCd =	(JSPUtil.getParameter(request, prefix +	"ap_ctrl_ofc_cd".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] fmYdCd =	(JSPUtil.getParameter(request, prefix +	"fm_yd_cd".trim(),	length));
				String[] toYdCd =	(JSPUtil.getParameter(request, prefix +	"to_yd_cd".trim(),	length));
				String[] coCd =	(JSPUtil.getParameter(request, prefix +	"co_cd".trim(),	length));
				String[] mtyBkgNo =	(JSPUtil.getParameter(request, prefix +	"mty_bkg_no".trim(),	length));
				String[] cmBkgNo =	(JSPUtil.getParameter(request, prefix +	"cm_bkg_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] checkCase =	(JSPUtil.getParameter(request, prefix +	"check_case".trim(),	length));
				String[] cnmvYr =	(JSPUtil.getParameter(request, prefix +	"cnmv_yr".trim(),	length));
				String[] cnmvIdNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_id_no".trim(),	length));
				String[] cnmvSeq =	(JSPUtil.getParameter(request, prefix +	"cnmv_seq".trim(),	length));
				String[] cnmvSplitNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_split_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] mvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_sts_cd".trim(),	length));
				String[] bkgCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cgo_tp_cd".trim(),	length));
				String[] cnmvCycNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_cyc_no".trim(),	length));
				String[] cnmvLvlNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_lvl_no".trim(),	length));
				String[] cnmvEvntDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_evnt_dt".trim(),	length));
				String[] destYdCd =	(JSPUtil.getParameter(request, prefix +	"dest_yd_cd".trim(),	length));
				String[] inpYdCd =	(JSPUtil.getParameter(request, prefix +	"inp_yd_cd".trim(),	length));
				String[] orgYdCd =	(JSPUtil.getParameter(request, prefix +	"org_yd_cd".trim(),	length));
				String[] trnkVslCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vsl_cd".trim(),	length));
				String[] trnkSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"trnk_skd_voy_no".trim(),	length));
				String[] trnkSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"trnk_skd_dir_cd".trim(),	length));
				String[] chssNo =	(JSPUtil.getParameter(request, prefix +	"chss_no".trim(),	length));
				String[] mgstNo =	(JSPUtil.getParameter(request, prefix +	"mgst_no".trim(),	length));
				String[] cntrSealNo =	(JSPUtil.getParameter(request, prefix +	"cntr_seal_no".trim(),	length));
				String[] cntrDmgFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_dmg_flg".trim(),	length));
				String[] fcntrFlg =	(JSPUtil.getParameter(request, prefix +	"fcntr_flg".trim(),	length));
				String[] obCntrFlg =	(JSPUtil.getParameter(request, prefix +	"ob_cntr_flg".trim(),	length));
				String[] bkgRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"bkg_rcv_term_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] mvmtTrspModCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_trsp_mod_cd".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] cnmvRmk =	(JSPUtil.getParameter(request, prefix +	"cnmv_rmk".trim(),	length));
				String[] chssMgstMvmtRmk =	(JSPUtil.getParameter(request, prefix +	"chss_mgst_mvmt_rmk".trim(),	length));
				String[] usNm =	(JSPUtil.getParameter(request, prefix +	"us_nm".trim(),	length));
				String[] mvmtCreTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_cre_tp_cd".trim(),	length));
				String[] substRuleCd =	(JSPUtil.getParameter(request, prefix +	"subst_rule_cd".trim(),	length));
				String[] spclCgoFlg =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_flg".trim(),	length));
				String[] bkgKnt =	(JSPUtil.getParameter(request, prefix +	"bkg_knt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] cntrHngrRckFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_flg".trim(),	length));
				String[] cntrHngrBarAtchKnt =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_bar_atch_knt".trim(),	length));
				String[] cntrActCd =	(JSPUtil.getParameter(request, prefix +	"cntr_act_cd".trim(),	length));
				String[] cntrRfubFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_rfub_flg".trim(),	length));
				String[] cntrDispFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_disp_flg".trim(),	length));
				String[] imdtExtFlg =	(JSPUtil.getParameter(request, prefix +	"imdt_ext_flg".trim(),	length));
				String[] cntrXchCd =	(JSPUtil.getParameter(request, prefix +	"cntr_xch_cd".trim(),	length));
				String[] inlndTrspLicNo =	(JSPUtil.getParameter(request, prefix +	"inlnd_trsp_lic_no".trim(),	length));
				String[] ctrtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"ctrt_ofc_cty_cd".trim(),	length));
				String[] ctrtSeq =	(JSPUtil.getParameter(request, prefix +	"ctrt_seq".trim(),	length));
				String[] mvmtEdiTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_tp_cd".trim(),	length));
				String[] mvmtEdiMsgTpId =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_tp_id".trim(),	length));
				String[] mvmtEdiMsgAreaCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_area_cd".trim(),	length));
				String[] mvmtEdiMsgYrmondy =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_yrmondy".trim(),	length));
				String[] mvmtEdiMsgSeq =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_seq".trim(),	length));
				String[] wblNo =	(JSPUtil.getParameter(request, prefix +	"wbl_no".trim(),	length));
				String[] pkupNo =	(JSPUtil.getParameter(request, prefix +	"pkup_no".trim(),	length));
				String[] cntrStsSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_seq".trim(),	length));
				String[] callSgnNo =	(JSPUtil.getParameter(request, prefix +	"call_sgn_no".trim(),	length));
				String[] lloydNo =	(JSPUtil.getParameter(request, prefix +	"lloyd_no".trim(),	length));
				String[] mtyRepoVlRmk =	(JSPUtil.getParameter(request, prefix +	"mty_repo_vl_rmk".trim(),	length));
				String[] mvmtInpTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_inp_tp_cd".trim(),	length));
				String[] cnmvCoCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_co_cd".trim(),	length));
				String[] sysAreaGrpId =	(JSPUtil.getParameter(request, prefix +	"sys_area_grp_id".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] preStsFlg =	(JSPUtil.getParameter(request, prefix +	"pre_sts_flg".trim(),	length));
				String[] gmtDt =	(JSPUtil.getParameter(request, prefix +	"gmt_dt".trim(),	length));
				String[] creLoclDt =	(JSPUtil.getParameter(request, prefix +	"cre_locl_dt".trim(),	length));
				String[] updLoclDt =	(JSPUtil.getParameter(request, prefix +	"upd_locl_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] woNo =	(JSPUtil.getParameter(request, prefix +	"wo_no".trim(),	length));
				String[] ediVvdCd =	(JSPUtil.getParameter(request, prefix +	"edi_vvd_cd".trim(),	length));
				String[] tirNo =	(JSPUtil.getParameter(request, prefix +	"tir_no".trim(),	length));
				String[] mtyPlnNo =	(JSPUtil.getParameter(request, prefix +	"mty_pln_no".trim(),	length));
				String[] mtyRepoNo =	(JSPUtil.getParameter(request, prefix +	"mty_repo_no".trim(),	length));
				String[] ediCrrNo =	(JSPUtil.getParameter(request, prefix +	"edi_crr_no".trim(),	length));
				String[] trspDocNo =	(JSPUtil.getParameter(request, prefix +	"trsp_doc_no".trim(),	length));
				String[] oscaBkgFlg =	(JSPUtil.getParameter(request, prefix +	"osca_bkg_flg".trim(),	length));
				String[] rstrUsgLblValDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_val_desc".trim(),	length));
				String[] rstrUsgLblNmDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm_desc".trim(),	length));
				String[] edwUpdDt =	(JSPUtil.getParameter(request, prefix +	"edw_upd_dt".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] vslLocCd =	(JSPUtil.getParameter(request, prefix +	"vsl_loc_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AutoMtBkgVO();
						if ( apCtrlOfcCd[i] !=	null)
						model.setApCtrlOfcCd( apCtrlOfcCd[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( fmYdCd[i] !=	null)
						model.setFmYdCd( fmYdCd[i]);
						if ( toYdCd[i] !=	null)
						model.setToYdCd( toYdCd[i]);
						if ( coCd[i] !=	null)
						model.setCoCd( coCd[i]);
						if ( mtyBkgNo[i] !=	null)
						model.setMtyBkgNo( mtyBkgNo[i]);
						if ( cmBkgNo[i] !=	null)
						model.setCmBkgNo( cmBkgNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( checkCase[i] !=	null)
						model.setCheckCase( checkCase[i]);
						if ( cnmvYr[i] !=	null)
						model.setCnmvYr( cnmvYr[i]);
						if ( cnmvIdNo[i] !=	null)
						model.setCnmvIdNo( cnmvIdNo[i]);
						if ( cnmvSeq[i] !=	null)
						model.setCnmvSeq( cnmvSeq[i]);
						if ( cnmvSplitNo[i] !=	null)
						model.setCnmvSplitNo( cnmvSplitNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( mvmtStsCd[i] !=	null)
						model.setMvmtStsCd( mvmtStsCd[i]);
						if ( bkgCgoTpCd[i] !=	null)
						model.setBkgCgoTpCd( bkgCgoTpCd[i]);
						if ( cnmvCycNo[i] !=	null)
						model.setCnmvCycNo( cnmvCycNo[i]);
						if ( cnmvLvlNo[i] !=	null)
						model.setCnmvLvlNo( cnmvLvlNo[i]);
						if ( cnmvEvntDt[i] !=	null)
						model.setCnmvEvntDt( cnmvEvntDt[i]);
						if ( destYdCd[i] !=	null)
						model.setDestYdCd( destYdCd[i]);
						if ( inpYdCd[i] !=	null)
						model.setInpYdCd( inpYdCd[i]);
						if ( orgYdCd[i] !=	null)
						model.setOrgYdCd( orgYdCd[i]);
						if ( trnkVslCd[i] !=	null)
						model.setTrnkVslCd( trnkVslCd[i]);
						if ( trnkSkdVoyNo[i] !=	null)
						model.setTrnkSkdVoyNo( trnkSkdVoyNo[i]);
						if ( trnkSkdDirCd[i] !=	null)
						model.setTrnkSkdDirCd( trnkSkdDirCd[i]);
						if ( chssNo[i] !=	null)
						model.setChssNo( chssNo[i]);
						if ( mgstNo[i] !=	null)
						model.setMgstNo( mgstNo[i]);
						if ( cntrSealNo[i] !=	null)
						model.setCntrSealNo( cntrSealNo[i]);
						if ( cntrDmgFlg[i] !=	null)
						model.setCntrDmgFlg( cntrDmgFlg[i]);
						if ( fcntrFlg[i] !=	null)
						model.setFcntrFlg( fcntrFlg[i]);
						if ( obCntrFlg[i] !=	null)
						model.setObCntrFlg( obCntrFlg[i]);
						if ( bkgRcvTermCd[i] !=	null)
						model.setBkgRcvTermCd( bkgRcvTermCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( mvmtTrspModCd[i] !=	null)
						model.setMvmtTrspModCd( mvmtTrspModCd[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( cnmvRmk[i] !=	null)
						model.setCnmvRmk( cnmvRmk[i]);
						if ( chssMgstMvmtRmk[i] !=	null)
						model.setChssMgstMvmtRmk( chssMgstMvmtRmk[i]);
						if ( usNm[i] !=	null)
						model.setUsNm( usNm[i]);
						if ( mvmtCreTpCd[i] !=	null)
						model.setMvmtCreTpCd( mvmtCreTpCd[i]);
						if ( substRuleCd[i] !=	null)
						model.setSubstRuleCd( substRuleCd[i]);
						if ( spclCgoFlg[i] !=	null)
						model.setSpclCgoFlg( spclCgoFlg[i]);
						if ( bkgKnt[i] !=	null)
						model.setBkgKnt( bkgKnt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( cntrHngrRckFlg[i] !=	null)
						model.setCntrHngrRckFlg( cntrHngrRckFlg[i]);
						if ( cntrHngrBarAtchKnt[i] !=	null)
						model.setCntrHngrBarAtchKnt( cntrHngrBarAtchKnt[i]);
						if ( cntrActCd[i] !=	null)
						model.setCntrActCd( cntrActCd[i]);
						if ( cntrRfubFlg[i] !=	null)
						model.setCntrRfubFlg( cntrRfubFlg[i]);
						if ( cntrDispFlg[i] !=	null)
						model.setCntrDispFlg( cntrDispFlg[i]);
						if ( imdtExtFlg[i] !=	null)
						model.setImdtExtFlg( imdtExtFlg[i]);
						if ( cntrXchCd[i] !=	null)
						model.setCntrXchCd( cntrXchCd[i]);
						if ( inlndTrspLicNo[i] !=	null)
						model.setInlndTrspLicNo( inlndTrspLicNo[i]);
						if ( ctrtOfcCtyCd[i] !=	null)
						model.setCtrtOfcCtyCd( ctrtOfcCtyCd[i]);
						if ( ctrtSeq[i] !=	null)
						model.setCtrtSeq( ctrtSeq[i]);
						if ( mvmtEdiTpCd[i] !=	null)
						model.setMvmtEdiTpCd( mvmtEdiTpCd[i]);
						if ( mvmtEdiMsgTpId[i] !=	null)
						model.setMvmtEdiMsgTpId( mvmtEdiMsgTpId[i]);
						if ( mvmtEdiMsgAreaCd[i] !=	null)
						model.setMvmtEdiMsgAreaCd( mvmtEdiMsgAreaCd[i]);
						if ( mvmtEdiMsgYrmondy[i] !=	null)
						model.setMvmtEdiMsgYrmondy( mvmtEdiMsgYrmondy[i]);
						if ( mvmtEdiMsgSeq[i] !=	null)
						model.setMvmtEdiMsgSeq( mvmtEdiMsgSeq[i]);
						if ( wblNo[i] !=	null)
						model.setWblNo( wblNo[i]);
						if ( pkupNo[i] !=	null)
						model.setPkupNo( pkupNo[i]);
						if ( cntrStsSeq[i] !=	null)
						model.setCntrStsSeq( cntrStsSeq[i]);
						if ( callSgnNo[i] !=	null)
						model.setCallSgnNo( callSgnNo[i]);
						if ( lloydNo[i] !=	null)
						model.setLloydNo( lloydNo[i]);
						if ( mtyRepoVlRmk[i] !=	null)
						model.setMtyRepoVlRmk( mtyRepoVlRmk[i]);
						if ( mvmtInpTpCd[i] !=	null)
						model.setMvmtInpTpCd( mvmtInpTpCd[i]);
						if ( cnmvCoCd[i] !=	null)
						model.setCnmvCoCd( cnmvCoCd[i]);
						if ( sysAreaGrpId[i] !=	null)
						model.setSysAreaGrpId( sysAreaGrpId[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( preStsFlg[i] !=	null)
						model.setPreStsFlg( preStsFlg[i]);
						if ( gmtDt[i] !=	null)
						model.setGmtDt( gmtDt[i]);
						if ( creLoclDt[i] !=	null)
						model.setCreLoclDt( creLoclDt[i]);
						if ( updLoclDt[i] !=	null)
						model.setUpdLoclDt( updLoclDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( woNo[i] !=	null)
						model.setWoNo( woNo[i]);
						if ( ediVvdCd[i] !=	null)
						model.setEdiVvdCd( ediVvdCd[i]);
						if ( tirNo[i] !=	null)
						model.setTirNo( tirNo[i]);
						if ( mtyPlnNo[i] !=	null)
						model.setMtyPlnNo( mtyPlnNo[i]);
						if ( mtyRepoNo[i] !=	null)
						model.setMtyRepoNo( mtyRepoNo[i]);
						if ( ediCrrNo[i] !=	null)
						model.setEdiCrrNo( ediCrrNo[i]);
						if ( trspDocNo[i] !=	null)
						model.setTrspDocNo( trspDocNo[i]);
						if ( oscaBkgFlg[i] !=	null)
						model.setOscaBkgFlg( oscaBkgFlg[i]);
						if ( rstrUsgLblValDesc[i] !=	null)
						model.setRstrUsgLblValDesc( rstrUsgLblValDesc[i]);
						if ( rstrUsgLblNmDesc[i] !=	null)
						model.setRstrUsgLblNmDesc( rstrUsgLblNmDesc[i]);
						if ( edwUpdDt[i] !=	null)
						model.setEdwUpdDt( edwUpdDt[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( vslLocCd[i] !=	null)
						model.setVslLocCd( vslLocCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAutoMtBkgVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AutoMtBkgVO[]
	 */
	public AutoMtBkgVO[]	 getAutoMtBkgVOs(){
		AutoMtBkgVO[] vos = (AutoMtBkgVO[])models.toArray(new	AutoMtBkgVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.apCtrlOfcCd =	this.apCtrlOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd =	this.fmYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd =	this.toYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd =	this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgNo =	this.mtyBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmBkgNo =	this.cmBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkCase =	this.checkCase.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr =	this.cnmvYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo =	this.cnmvIdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq =	this.cnmvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo =	this.cnmvSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd =	this.mvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd =	this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo =	this.cnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo =	this.cnmvLvlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt =	this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd =	this.destYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYdCd =	this.inpYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd =	this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd =	this.trnkVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo =	this.trnkSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd =	this.trnkSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo =	this.chssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo =	this.mgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo =	this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg =	this.cntrDmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg =	this.fcntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg =	this.obCntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd =	this.bkgRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd =	this.mvmtTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk =	this.cnmvRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstMvmtRmk =	this.chssMgstMvmtRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usNm =	this.usNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd =	this.mvmtCreTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substRuleCd =	this.substRuleCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg =	this.spclCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt =	this.bkgKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg =	this.cntrHngrRckFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt =	this.cntrHngrBarAtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrActCd =	this.cntrActCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg =	this.cntrRfubFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg =	this.cntrDispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg =	this.imdtExtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd =	this.cntrXchCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTrspLicNo =	this.inlndTrspLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCtyCd =	this.ctrtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq =	this.ctrtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd =	this.mvmtEdiTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId =	this.mvmtEdiMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd =	this.mvmtEdiMsgAreaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy =	this.mvmtEdiMsgYrmondy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq =	this.mvmtEdiMsgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo =	this.wblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo =	this.pkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq =	this.cntrStsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo =	this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo =	this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoVlRmk =	this.mtyRepoVlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtInpTpCd =	this.mvmtInpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd =	this.cnmvCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId =	this.sysAreaGrpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg =	this.preStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt =	this.gmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt =	this.creLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt =	this.updLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo =	this.woNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVvdCd =	this.ediVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tirNo =	this.tirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo =	this.mtyPlnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoNo =	this.mtyRepoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCrrNo =	this.ediCrrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo =	this.trspDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oscaBkgFlg =	this.oscaBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblValDesc =	this.rstrUsgLblValDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNmDesc =	this.rstrUsgLblNmDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt =	this.edwUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLocCd =	this.vslLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}