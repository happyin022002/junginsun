/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : UncollectedCargoVO.java
*@FileTitle : UncollectedCargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo;

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

public class UncollectedCargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UncollectedCargoVO> models = new ArrayList<UncollectedCargoVO>();
	
	/* Column Info */
	private String ucOfcTrnsFlg = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String ucSeq = null;
	/* Column Info */
	private String ucDispOptCd = null;
	/* Column Info */
	private String ucCgoLocNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ucCtrtRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String otsInsurCvrAmt = null;
	/* Column Info */
	private String cmdt = null;
	/* Column Info */
	private String porDt = null;
	/* Column Info */
	private String ucRsnCd = null;
	/* Column Info */
	private String frwd = null;
	/* Column Info */
	private String ucDys = null;
	/* Column Info */
	private String ucCsNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String ucStsCd = null;
	/* Column Info */
	private String abanLtrCneeDt = null;
	/* Column Info */
	private String delDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String otsOtrCostDt = null;
	/* Column Info */
	private String ucPiclbCd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String prepaid = null;
	/* Column Info */
	private String otsOtrCostAmt = null;
	/* Column Info */
	private String otsOftAmt = null;
	/* Column Info */
	private String ucRsnDesc = null;
	/* Column Info */
	private String ucCrntUsdAmt = null;
	/* Column Info */
	private String ucOblHldCd = null;
	/* Column Info */
	private String ctrtTtlVolCtnt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String otsRcvrAmt = null;
	/* Column Info */
	private String ucPiclbRefNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String otsRmk = null;
	/* Column Info */
	private String kntrUpdId = null;
	/* Column Info */
	private String cneeUcDt = null;
	/* Column Info */
	private String ucCgoN3rdNtcDt = null;
	/* Column Info */
	private String ucInvAmt = null;
	/* Column Info */
	private String abanLtrShprDt = null;
	/* Column Info */
	private String collect = null;
	/* Column Info */
	private String otsStoAmt = null;
	/* Column Info */
	private String hndlBrncCd = null;
	/* Column Info */
	private String cntrList = null;
	/* Column Info */
	private String hndlUpdId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ucCtrtTtlVol = null;
	/* Column Info */
	private String today = null;
	/* Column Info */
	private String ucCrntAmt = null;
	/* Column Info */
	private String ucClzDt = null;
	/* Column Info */
	private String ucCgoFnlNtcDt = null;
	/* Column Info */
	private String ucCgoNtcRmk = null;
	/* Column Info */
	private String ucInvXchRt = null;
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hndlUpdDt = null;
	/* Column Info */
	private String ucDchgDys = null;
	/* Column Info */
	private String kntrUpdDt = null;
	/* Column Info */
	private String ucDoIssDt = null;
	/* Column Info */
	private String noti = null;
	/* Column Info */
	private String kntrRhqCd = null;
	/* Column Info */
	private String otsStoDt = null;
	/* Column Info */
	private String kntrBrncCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hndlHdlrUsrId = null;
	/* Column Info */
	private String hndlHdlrUsrNm = null;
	/* Column Info */
	private String otsDmdtDt = null;
	/* Column Info */
	private String kntrOfcOpinDesc = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String hndlRhqCd = null;
	/* Column Info */
	private String hndlOfcOpinDesc = null;
	/* Column Info */
	private String otsOtrAmt = null;
	/* Column Info */
	private String ucCrntXchRt = null;
	/* Column Info */
	private String ucInvCurrCd = null;
	/* Column Info */
	private String ucCgoN2ndNtcDt = null;
	/* Column Info */
	private String fileCnt = null;
	/* Column Info */
	private String ucRopnFlg = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String kntrHdlrUsrId = null;
	/* Column Info */
	private String kntrHdlrUsrNm = null;
	/* Column Info */
	private String factFndActDesc = null;
	/* Column Info */
	private String ucInvUsdAmt = null;
	/* Column Info */
	private String ucCrntCurrCd = null;
	/* Column Info */
	private String ucCgoN1stNtcDt = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String otsDmdtAmt = null;
	/* Column Info */
	private String podEta = null;
	/* Column Info */
	private String managerMemo = null;
	/* Column Info */
	private String isAuthority = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UncollectedCargoVO() {}

	public UncollectedCargoVO(String ibflag, String pagerows, String ucCsNo, String blNo, String ucSeq, String hndlRhqCd, String hndlBrncCd, String hndlHdlrUsrId,String hndlHdlrUsrNm, String hndlUpdId, String hndlUpdDt, String kntrRhqCd, String kntrBrncCd, String kntrHdlrUsrId, String kntrHdlrUsrNm, String kntrUpdId, String kntrUpdDt, String ucStsCd, String ucRopnFlg, String ucOfcTrnsFlg, String cneeUcDt, String ucClzDt, String ucDys, String ucDchgDys, String ctrtTtlVolCtnt, String ucCtrtTtlVol, String cntrList, String ucCtrtRmk, String ucRsnCd, String ucRsnDesc, String ucInvAmt, String ucInvCurrCd, String ucInvXchRt, String ucInvUsdAmt, String ucCrntAmt, String ucCrntCurrCd, String ucCrntXchRt, String ucCrntUsdAmt, String ucOblHldCd, String ucPiclbCd, String ucPiclbRefNo, String ucDoIssDt, String ucDispOptCd, String abanLtrShprDt, String abanLtrCneeDt, String ucCgoLocNm, String ucCgoN1stNtcDt, String ucCgoN2ndNtcDt, String ucCgoN3rdNtcDt, String ucCgoFnlNtcDt, String ucCgoNtcRmk, String otsOftAmt, String otsOtrAmt, String otsDmdtAmt, String otsDmdtDt, String otsStoAmt, String otsStoDt, String otsOtrCostAmt, String otsOtrCostDt, String otsRcvrAmt, String otsInsurCvrAmt, String otsRmk, String factFndActDesc, String hndlOfcOpinDesc, String kntrOfcOpinDesc, String creUsrId, String creDt, String updUsrId, String updDt, String vvd, String vslNm, String por, String porDt, String pol, String pod, String delCd, String delDt, String polEtd, String podEta, String shpr, String cnee, String noti, String frwd, String cmdt, String prepaid, String collect, String today, String fileCnt, String managerMemo,String isAuthority) {
		this.ucOfcTrnsFlg = ucOfcTrnsFlg;
		this.por = por;
		this.ucSeq = ucSeq;
		this.ucDispOptCd = ucDispOptCd;
		this.ucCgoLocNm = ucCgoLocNm;
		this.blNo = blNo;
		this.ucCtrtRmk = ucCtrtRmk;
		this.pagerows = pagerows;
		this.otsInsurCvrAmt = otsInsurCvrAmt;
		this.cmdt = cmdt;
		this.porDt = porDt;
		this.ucRsnCd = ucRsnCd;
		this.frwd = frwd;
		this.ucDys = ucDys;
		this.ucCsNo = ucCsNo;
		this.pol = pol;
		this.ucStsCd = ucStsCd;
		this.abanLtrCneeDt = abanLtrCneeDt;
		this.delDt = delDt;
		this.updUsrId = updUsrId;
		this.otsOtrCostDt = otsOtrCostDt;
		this.ucPiclbCd = ucPiclbCd;
		this.pod = pod;
		this.prepaid = prepaid;
		this.otsOtrCostAmt = otsOtrCostAmt;
		this.otsOftAmt = otsOftAmt;
		this.ucRsnDesc = ucRsnDesc;
		this.ucCrntUsdAmt = ucCrntUsdAmt;
		this.ucOblHldCd = ucOblHldCd;
		this.ctrtTtlVolCtnt = ctrtTtlVolCtnt;
		this.delCd = delCd;
		this.otsRcvrAmt = otsRcvrAmt;
		this.ucPiclbRefNo = ucPiclbRefNo;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.otsRmk = otsRmk;
		this.kntrUpdId = kntrUpdId;
		this.cneeUcDt = cneeUcDt;
		this.ucCgoN3rdNtcDt = ucCgoN3rdNtcDt;
		this.ucInvAmt = ucInvAmt;
		this.abanLtrShprDt = abanLtrShprDt;
		this.collect = collect;
		this.otsStoAmt = otsStoAmt;
		this.hndlBrncCd = hndlBrncCd;
		this.cntrList = cntrList;
		this.hndlUpdId = hndlUpdId;
		this.creDt = creDt;
		this.ucCtrtTtlVol = ucCtrtTtlVol;
		this.today = today;
		this.ucCrntAmt = ucCrntAmt;
		this.ucClzDt = ucClzDt;
		this.ucCgoFnlNtcDt = ucCgoFnlNtcDt;
		this.ucCgoNtcRmk = ucCgoNtcRmk;
		this.ucInvXchRt = ucInvXchRt;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.hndlUpdDt = hndlUpdDt;
		this.ucDchgDys = ucDchgDys;
		this.kntrUpdDt = kntrUpdDt;
		this.ucDoIssDt = ucDoIssDt;
		this.noti = noti;
		this.kntrRhqCd = kntrRhqCd;
		this.otsStoDt = otsStoDt;
		this.kntrBrncCd = kntrBrncCd;
		this.updDt = updDt;
		this.hndlHdlrUsrId = hndlHdlrUsrId;
		this.hndlHdlrUsrNm = hndlHdlrUsrNm;
		this.otsDmdtDt = otsDmdtDt;
		this.kntrOfcOpinDesc = kntrOfcOpinDesc;
		this.vslNm = vslNm;
		this.hndlRhqCd = hndlRhqCd;
		this.hndlOfcOpinDesc = hndlOfcOpinDesc;
		this.otsOtrAmt = otsOtrAmt;
		this.ucCrntXchRt = ucCrntXchRt;
		this.ucInvCurrCd = ucInvCurrCd;
		this.ucCgoN2ndNtcDt = ucCgoN2ndNtcDt;
		this.fileCnt = fileCnt;
		this.ucRopnFlg = ucRopnFlg;
		this.cnee = cnee;
		this.kntrHdlrUsrId = kntrHdlrUsrId;
		this.kntrHdlrUsrNm = kntrHdlrUsrNm;
		this.factFndActDesc = factFndActDesc;
		this.ucInvUsdAmt = ucInvUsdAmt;
		this.ucCrntCurrCd = ucCrntCurrCd;
		this.ucCgoN1stNtcDt = ucCgoN1stNtcDt;
		this.shpr = shpr;
		this.otsDmdtAmt = otsDmdtAmt;
		this.podEta = podEta;
		this.managerMemo = managerMemo;
		this.isAuthority = isAuthority;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("uc_ofc_trns_flg", getUcOfcTrnsFlg());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("uc_seq", getUcSeq());
		this.hashColumns.put("uc_disp_opt_cd", getUcDispOptCd());
		this.hashColumns.put("uc_cgo_loc_nm", getUcCgoLocNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("uc_ctrt_rmk", getUcCtrtRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ots_insur_cvr_amt", getOtsInsurCvrAmt());
		this.hashColumns.put("cmdt", getCmdt());
		this.hashColumns.put("por_dt", getPorDt());
		this.hashColumns.put("uc_rsn_cd", getUcRsnCd());
		this.hashColumns.put("frwd", getFrwd());
		this.hashColumns.put("uc_dys", getUcDys());
		this.hashColumns.put("uc_cs_no", getUcCsNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("uc_sts_cd", getUcStsCd());
		this.hashColumns.put("aban_ltr_cnee_dt", getAbanLtrCneeDt());
		this.hashColumns.put("del_dt", getDelDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ots_otr_cost_dt", getOtsOtrCostDt());
		this.hashColumns.put("uc_piclb_cd", getUcPiclbCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("prepaid", getPrepaid());
		this.hashColumns.put("ots_otr_cost_amt", getOtsOtrCostAmt());
		this.hashColumns.put("ots_oft_amt", getOtsOftAmt());
		this.hashColumns.put("uc_rsn_desc", getUcRsnDesc());
		this.hashColumns.put("uc_crnt_usd_amt", getUcCrntUsdAmt());
		this.hashColumns.put("uc_obl_hld_cd", getUcOblHldCd());
		this.hashColumns.put("ctrt_ttl_vol_ctnt", getCtrtTtlVolCtnt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ots_rcvr_amt", getOtsRcvrAmt());
		this.hashColumns.put("uc_piclb_ref_no", getUcPiclbRefNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ots_rmk", getOtsRmk());
		this.hashColumns.put("kntr_upd_id", getKntrUpdId());
		this.hashColumns.put("cnee_uc_dt", getCneeUcDt());
		this.hashColumns.put("uc_cgo_n3rd_ntc_dt", getUcCgoN3rdNtcDt());
		this.hashColumns.put("uc_inv_amt", getUcInvAmt());
		this.hashColumns.put("aban_ltr_shpr_dt", getAbanLtrShprDt());
		this.hashColumns.put("collect", getCollect());
		this.hashColumns.put("ots_sto_amt", getOtsStoAmt());
		this.hashColumns.put("hndl_brnc_cd", getHndlBrncCd());
		this.hashColumns.put("cntr_list", getCntrList());
		this.hashColumns.put("hndl_upd_id", getHndlUpdId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("uc_ctrt_ttl_vol", getUcCtrtTtlVol());
		this.hashColumns.put("today", getToday());
		this.hashColumns.put("uc_crnt_amt", getUcCrntAmt());
		this.hashColumns.put("uc_clz_dt", getUcClzDt());
		this.hashColumns.put("uc_cgo_fnl_ntc_dt", getUcCgoFnlNtcDt());
		this.hashColumns.put("uc_cgo_ntc_rmk", getUcCgoNtcRmk());
		this.hashColumns.put("uc_inv_xch_rt", getUcInvXchRt());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hndl_upd_dt", getHndlUpdDt());
		this.hashColumns.put("uc_dchg_dys", getUcDchgDys());
		this.hashColumns.put("kntr_upd_dt", getKntrUpdDt());
		this.hashColumns.put("uc_do_iss_dt", getUcDoIssDt());
		this.hashColumns.put("noti", getNoti());
		this.hashColumns.put("kntr_rhq_cd", getKntrRhqCd());
		this.hashColumns.put("ots_sto_dt", getOtsStoDt());
		this.hashColumns.put("kntr_brnc_cd", getKntrBrncCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hndl_hdlr_usr_id", getHndlHdlrUsrId());
		this.hashColumns.put("hndl_hdlr_usr_nm", getHndlHdlrUsrNm());
		this.hashColumns.put("ots_dmdt_dt", getOtsDmdtDt());
		this.hashColumns.put("kntr_ofc_opin_desc", getKntrOfcOpinDesc());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("hndl_rhq_cd", getHndlRhqCd());
		this.hashColumns.put("hndl_ofc_opin_desc", getHndlOfcOpinDesc());
		this.hashColumns.put("ots_otr_amt", getOtsOtrAmt());
		this.hashColumns.put("uc_crnt_xch_rt", getUcCrntXchRt());
		this.hashColumns.put("uc_inv_curr_cd", getUcInvCurrCd());
		this.hashColumns.put("uc_cgo_n2nd_ntc_dt", getUcCgoN2ndNtcDt());
		this.hashColumns.put("file_cnt", getFileCnt());
		this.hashColumns.put("uc_ropn_flg", getUcRopnFlg());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("kntr_hdlr_usr_id", getKntrHdlrUsrId());
		this.hashColumns.put("kntr_hdlr_usr_nm", getKntrHdlrUsrNm());
		this.hashColumns.put("fact_fnd_act_desc", getFactFndActDesc());
		this.hashColumns.put("uc_inv_usd_amt", getUcInvUsdAmt());
		this.hashColumns.put("uc_crnt_curr_cd", getUcCrntCurrCd());
		this.hashColumns.put("uc_cgo_n1st_ntc_dt", getUcCgoN1stNtcDt());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("ots_dmdt_amt", getOtsDmdtAmt());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("manager_memo", getManagerMemo());
		this.hashColumns.put("isauthority", getIsAuthority());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("uc_ofc_trns_flg", "ucOfcTrnsFlg");
		this.hashFields.put("por", "por");
		this.hashFields.put("uc_seq", "ucSeq");
		this.hashFields.put("uc_disp_opt_cd", "ucDispOptCd");
		this.hashFields.put("uc_cgo_loc_nm", "ucCgoLocNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("uc_ctrt_rmk", "ucCtrtRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ots_insur_cvr_amt", "otsInsurCvrAmt");
		this.hashFields.put("cmdt", "cmdt");
		this.hashFields.put("por_dt", "porDt");
		this.hashFields.put("uc_rsn_cd", "ucRsnCd");
		this.hashFields.put("frwd", "frwd");
		this.hashFields.put("uc_dys", "ucDys");
		this.hashFields.put("uc_cs_no", "ucCsNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("uc_sts_cd", "ucStsCd");
		this.hashFields.put("aban_ltr_cnee_dt", "abanLtrCneeDt");
		this.hashFields.put("del_dt", "delDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ots_otr_cost_dt", "otsOtrCostDt");
		this.hashFields.put("uc_piclb_cd", "ucPiclbCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("prepaid", "prepaid");
		this.hashFields.put("ots_otr_cost_amt", "otsOtrCostAmt");
		this.hashFields.put("ots_oft_amt", "otsOftAmt");
		this.hashFields.put("uc_rsn_desc", "ucRsnDesc");
		this.hashFields.put("uc_crnt_usd_amt", "ucCrntUsdAmt");
		this.hashFields.put("uc_obl_hld_cd", "ucOblHldCd");
		this.hashFields.put("ctrt_ttl_vol_ctnt", "ctrtTtlVolCtnt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ots_rcvr_amt", "otsRcvrAmt");
		this.hashFields.put("uc_piclb_ref_no", "ucPiclbRefNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("kntr_upd_id", "kntrUpdId");
		this.hashFields.put("cnee_uc_dt", "cneeUcDt");
		this.hashFields.put("uc_cgo_n3rd_ntc_dt", "ucCgoN3rdNtcDt");
		this.hashFields.put("uc_inv_amt", "ucInvAmt");
		this.hashFields.put("aban_ltr_shpr_dt", "abanLtrShprDt");
		this.hashFields.put("collect", "collect");
		this.hashFields.put("ots_sto_amt", "otsStoAmt");
		this.hashFields.put("hndl_brnc_cd", "hndlBrncCd");
		this.hashFields.put("cntr_list", "cntrList");
		this.hashFields.put("hndl_upd_id", "hndlUpdId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("uc_ctrt_ttl_vol", "ucCtrtTtlVol");
		this.hashFields.put("today", "today");
		this.hashFields.put("uc_crnt_amt", "ucCrntAmt");
		this.hashFields.put("uc_clz_dt", "ucClzDt");
		this.hashFields.put("uc_cgo_fnl_ntc_dt", "ucCgoFnlNtcDt");
		this.hashFields.put("uc_cgo_ntc_rmk", "ucCgoNtcRmk");
		this.hashFields.put("uc_inv_xch_rt", "ucInvXchRt");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hndl_upd_dt", "hndlUpdDt");
		this.hashFields.put("uc_dchg_dys", "ucDchgDys");
		this.hashFields.put("kntr_upd_dt", "kntrUpdDt");
		this.hashFields.put("uc_do_iss_dt", "ucDoIssDt");
		this.hashFields.put("noti", "noti");
		this.hashFields.put("kntr_rhq_cd", "kntrRhqCd");
		this.hashFields.put("ots_sto_dt", "otsStoDt");
		this.hashFields.put("kntr_brnc_cd", "kntrBrncCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hndl_hdlr_usr_id", "hndlHdlrUsrId");
		this.hashFields.put("hndl_hdlr_usr_nm", "hndlHdlrUsrNm");
		this.hashFields.put("ots_dmdt_dt", "otsDmdtDt");
		this.hashFields.put("kntr_ofc_opin_desc", "kntrOfcOpinDesc");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("hndl_rhq_cd", "hndlRhqCd");
		this.hashFields.put("hndl_ofc_opin_desc", "hndlOfcOpinDesc");
		this.hashFields.put("ots_otr_amt", "otsOtrAmt");
		this.hashFields.put("uc_crnt_xch_rt", "ucCrntXchRt");
		this.hashFields.put("uc_inv_curr_cd", "ucInvCurrCd");
		this.hashFields.put("uc_cgo_n2nd_ntc_dt", "ucCgoN2ndNtcDt");
		this.hashFields.put("file_cnt", "fileCnt");
		this.hashFields.put("uc_ropn_flg", "ucRopnFlg");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("kntr_hdlr_usr_id", "kntrHdlrUsrId");
		this.hashFields.put("kntr_hdlr_usr_nm", "kntrHdlrUsrNm");
		this.hashFields.put("fact_fnd_act_desc", "factFndActDesc");
		this.hashFields.put("uc_inv_usd_amt", "ucInvUsdAmt");
		this.hashFields.put("uc_crnt_curr_cd", "ucCrntCurrCd");
		this.hashFields.put("uc_cgo_n1st_ntc_dt", "ucCgoN1stNtcDt");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("ots_dmdt_amt", "otsDmdtAmt");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("manager_memo", "managerMemo");
		this.hashFields.put("isauthority", "isAuthority");
		return this.hashFields;
	}
	
	public String getKntrHdlrUsrNm() {
		return kntrHdlrUsrNm;
	}

	public void setKntrHdlrUsrNm(String kntrHdlrUsrNm) {
		this.kntrHdlrUsrNm = kntrHdlrUsrNm;
	}

	/**
	 * Column Info
	 * @return ucOfcTrnsFlg
	 */
	public String getUcOfcTrnsFlg() {
		return this.ucOfcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return ucSeq
	 */
	public String getUcSeq() {
		return this.ucSeq;
	}
	
	/**
	 * Column Info
	 * @return ucDispOptCd
	 */
	public String getUcDispOptCd() {
		return this.ucDispOptCd;
	}
	
	/**
	 * Column Info
	 * @return ucCgoLocNm
	 */
	public String getUcCgoLocNm() {
		return this.ucCgoLocNm;
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
	 * @return ucCtrtRmk
	 */
	public String getUcCtrtRmk() {
		return this.ucCtrtRmk;
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
	 * @return otsInsurCvrAmt
	 */
	public String getOtsInsurCvrAmt() {
		return this.otsInsurCvrAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdt
	 */
	public String getCmdt() {
		return this.cmdt;
	}
	
	/**
	 * Column Info
	 * @return porDt
	 */
	public String getPorDt() {
		return this.porDt;
	}
	
	/**
	 * Column Info
	 * @return ucRsnCd
	 */
	public String getUcRsnCd() {
		return this.ucRsnCd;
	}
	
	/**
	 * Column Info
	 * @return frwd
	 */
	public String getFrwd() {
		return this.frwd;
	}
	
	/**
	 * Column Info
	 * @return ucDys
	 */
	public String getUcDys() {
		return this.ucDys;
	}
	
	/**
	 * Column Info
	 * @return ucCsNo
	 */
	public String getUcCsNo() {
		return this.ucCsNo;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return ucStsCd
	 */
	public String getUcStsCd() {
		return this.ucStsCd;
	}
	
	/**
	 * Column Info
	 * @return abanLtrCneeDt
	 */
	public String getAbanLtrCneeDt() {
		return this.abanLtrCneeDt;
	}
	
	/**
	 * Column Info
	 * @return delDt
	 */
	public String getDelDt() {
		return this.delDt;
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
	 * @return otsOtrCostDt
	 */
	public String getOtsOtrCostDt() {
		return this.otsOtrCostDt;
	}
	
	/**
	 * Column Info
	 * @return ucPiclbCd
	 */
	public String getUcPiclbCd() {
		return this.ucPiclbCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return prepaid
	 */
	public String getPrepaid() {
		return this.prepaid;
	}
	
	/**
	 * Column Info
	 * @return otsOtrCostAmt
	 */
	public String getOtsOtrCostAmt() {
		return this.otsOtrCostAmt;
	}
	
	/**
	 * Column Info
	 * @return otsOftAmt
	 */
	public String getOtsOftAmt() {
		return this.otsOftAmt;
	}
	
	/**
	 * Column Info
	 * @return ucRsnDesc
	 */
	public String getUcRsnDesc() {
		return this.ucRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return ucCrntUsdAmt
	 */
	public String getUcCrntUsdAmt() {
		return this.ucCrntUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ucOblHldCd
	 */
	public String getUcOblHldCd() {
		return this.ucOblHldCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtTtlVolCtnt
	 */
	public String getCtrtTtlVolCtnt() {
		return this.ctrtTtlVolCtnt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return otsRcvrAmt
	 */
	public String getOtsRcvrAmt() {
		return this.otsRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @return ucPiclbRefNo
	 */
	public String getUcPiclbRefNo() {
		return this.ucPiclbRefNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return otsRmk
	 */
	public String getOtsRmk() {
		return this.otsRmk;
	}
	
	/**
	 * Column Info
	 * @return kntrUpdId
	 */
	public String getKntrUpdId() {
		return this.kntrUpdId;
	}
	
	/**
	 * Column Info
	 * @return cneeUcDt
	 */
	public String getCneeUcDt() {
		return this.cneeUcDt;
	}
	
	/**
	 * Column Info
	 * @return ucCgoN3rdNtcDt
	 */
	public String getUcCgoN3rdNtcDt() {
		return this.ucCgoN3rdNtcDt;
	}
	
	/**
	 * Column Info
	 * @return ucInvAmt
	 */
	public String getUcInvAmt() {
		return this.ucInvAmt;
	}
	
	/**
	 * Column Info
	 * @return abanLtrShprDt
	 */
	public String getAbanLtrShprDt() {
		return this.abanLtrShprDt;
	}
	
	/**
	 * Column Info
	 * @return collect
	 */
	public String getCollect() {
		return this.collect;
	}
	
	/**
	 * Column Info
	 * @return otsStoAmt
	 */
	public String getOtsStoAmt() {
		return this.otsStoAmt;
	}
	
	/**
	 * Column Info
	 * @return hndlBrncCd
	 */
	public String getHndlBrncCd() {
		return this.hndlBrncCd;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	
	/**
	 * Column Info
	 * @return hndlUpdId
	 */
	public String getHndlUpdId() {
		return this.hndlUpdId;
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
	 * @return ucCtrtTtlVol
	 */
	public String getUcCtrtTtlVol() {
		return this.ucCtrtTtlVol;
	}
	
	/**
	 * Column Info
	 * @return today
	 */
	public String getToday() {
		return this.today;
	}
	
	/**
	 * Column Info
	 * @return ucCrntAmt
	 */
	public String getUcCrntAmt() {
		return this.ucCrntAmt;
	}
	
	/**
	 * Column Info
	 * @return ucClzDt
	 */
	public String getUcClzDt() {
		return this.ucClzDt;
	}
	
	/**
	 * Column Info
	 * @return ucCgoFnlNtcDt
	 */
	public String getUcCgoFnlNtcDt() {
		return this.ucCgoFnlNtcDt;
	}
	
	/**
	 * Column Info
	 * @return ucCgoNtcRmk
	 */
	public String getUcCgoNtcRmk() {
		return this.ucCgoNtcRmk;
	}
	
	/**
	 * Column Info
	 * @return ucInvXchRt
	 */
	public String getUcInvXchRt() {
		return this.ucInvXchRt;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return hndlUpdDt
	 */
	public String getHndlUpdDt() {
		return this.hndlUpdDt;
	}
	
	/**
	 * Column Info
	 * @return ucDchgDys
	 */
	public String getUcDchgDys() {
		return this.ucDchgDys;
	}
	
	/**
	 * Column Info
	 * @return kntrUpdDt
	 */
	public String getKntrUpdDt() {
		return this.kntrUpdDt;
	}
	
	/**
	 * Column Info
	 * @return ucDoIssDt
	 */
	public String getUcDoIssDt() {
		return this.ucDoIssDt;
	}
	
	/**
	 * Column Info
	 * @return noti
	 */
	public String getNoti() {
		return this.noti;
	}
	
	/**
	 * Column Info
	 * @return kntrRhqCd
	 */
	public String getKntrRhqCd() {
		return this.kntrRhqCd;
	}
	
	/**
	 * Column Info
	 * @return otsStoDt
	 */
	public String getOtsStoDt() {
		return this.otsStoDt;
	}
	
	/**
	 * Column Info
	 * @return kntrBrncCd
	 */
	public String getKntrBrncCd() {
		return this.kntrBrncCd;
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
	 * @return hndlHdlrUsrId
	 */
	public String getHndlHdlrUsrId() {
		return this.hndlHdlrUsrId;
	}
	
	public String getHndlHdlrUsrNm() {
		return hndlHdlrUsrNm;
	}

	public void setHndlHdlrUsrNm(String hndlHdlrUsrNm) {
		this.hndlHdlrUsrNm = hndlHdlrUsrNm;
	}

	/**
	 * Column Info
	 * @return otsDmdtDt
	 */
	public String getOtsDmdtDt() {
		return this.otsDmdtDt;
	}
	
	/**
	 * Column Info
	 * @return kntrOfcOpinDesc
	 */
	public String getKntrOfcOpinDesc() {
		return this.kntrOfcOpinDesc;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return hndlRhqCd
	 */
	public String getHndlRhqCd() {
		return this.hndlRhqCd;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcOpinDesc
	 */
	public String getHndlOfcOpinDesc() {
		return this.hndlOfcOpinDesc;
	}
	
	/**
	 * Column Info
	 * @return otsOtrAmt
	 */
	public String getOtsOtrAmt() {
		return this.otsOtrAmt;
	}
	
	/**
	 * Column Info
	 * @return ucCrntXchRt
	 */
	public String getUcCrntXchRt() {
		return this.ucCrntXchRt;
	}
	
	/**
	 * Column Info
	 * @return ucInvCurrCd
	 */
	public String getUcInvCurrCd() {
		return this.ucInvCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ucCgoN2ndNtcDt
	 */
	public String getUcCgoN2ndNtcDt() {
		return this.ucCgoN2ndNtcDt;
	}
	
	/**
	 * Column Info
	 * @return fileCnt
	 */
	public String getFileCnt() {
		return this.fileCnt;
	}
	
	/**
	 * Column Info
	 * @return ucRopnFlg
	 */
	public String getUcRopnFlg() {
		return this.ucRopnFlg;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return kntrHdlrUsrId
	 */
	public String getKntrHdlrUsrId() {
		return this.kntrHdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return factFndActDesc
	 */
	public String getFactFndActDesc() {
		return this.factFndActDesc;
	}
	
	/**
	 * Column Info
	 * @return ucInvUsdAmt
	 */
	public String getUcInvUsdAmt() {
		return this.ucInvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ucCrntCurrCd
	 */
	public String getUcCrntCurrCd() {
		return this.ucCrntCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ucCgoN1stNtcDt
	 */
	public String getUcCgoN1stNtcDt() {
		return this.ucCgoN1stNtcDt;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return otsDmdtAmt
	 */
	public String getOtsDmdtAmt() {
		return this.otsDmdtAmt;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param ucOfcTrnsFlg
	 */
	public void setUcOfcTrnsFlg(String ucOfcTrnsFlg) {
		this.ucOfcTrnsFlg = ucOfcTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param ucSeq
	 */
	public void setUcSeq(String ucSeq) {
		this.ucSeq = ucSeq;
	}
	
	/**
	 * Column Info
	 * @param ucDispOptCd
	 */
	public void setUcDispOptCd(String ucDispOptCd) {
		this.ucDispOptCd = ucDispOptCd;
	}
	
	/**
	 * Column Info
	 * @param ucCgoLocNm
	 */
	public void setUcCgoLocNm(String ucCgoLocNm) {
		this.ucCgoLocNm = ucCgoLocNm;
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
	 * @param ucCtrtRmk
	 */
	public void setUcCtrtRmk(String ucCtrtRmk) {
		this.ucCtrtRmk = ucCtrtRmk;
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
	 * @param otsInsurCvrAmt
	 */
	public void setOtsInsurCvrAmt(String otsInsurCvrAmt) {
		this.otsInsurCvrAmt = otsInsurCvrAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdt
	 */
	public void setCmdt(String cmdt) {
		this.cmdt = cmdt;
	}
	
	/**
	 * Column Info
	 * @param porDt
	 */
	public void setPorDt(String porDt) {
		this.porDt = porDt;
	}
	
	/**
	 * Column Info
	 * @param ucRsnCd
	 */
	public void setUcRsnCd(String ucRsnCd) {
		this.ucRsnCd = ucRsnCd;
	}
	
	/**
	 * Column Info
	 * @param frwd
	 */
	public void setFrwd(String frwd) {
		this.frwd = frwd;
	}
	
	/**
	 * Column Info
	 * @param ucDys
	 */
	public void setUcDys(String ucDys) {
		this.ucDys = ucDys;
	}
	
	/**
	 * Column Info
	 * @param ucCsNo
	 */
	public void setUcCsNo(String ucCsNo) {
		this.ucCsNo = ucCsNo;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param ucStsCd
	 */
	public void setUcStsCd(String ucStsCd) {
		this.ucStsCd = ucStsCd;
	}
	
	/**
	 * Column Info
	 * @param abanLtrCneeDt
	 */
	public void setAbanLtrCneeDt(String abanLtrCneeDt) {
		this.abanLtrCneeDt = abanLtrCneeDt;
	}
	
	/**
	 * Column Info
	 * @param delDt
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
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
	 * @param otsOtrCostDt
	 */
	public void setOtsOtrCostDt(String otsOtrCostDt) {
		this.otsOtrCostDt = otsOtrCostDt;
	}
	
	/**
	 * Column Info
	 * @param ucPiclbCd
	 */
	public void setUcPiclbCd(String ucPiclbCd) {
		this.ucPiclbCd = ucPiclbCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param prepaid
	 */
	public void setPrepaid(String prepaid) {
		this.prepaid = prepaid;
	}
	
	/**
	 * Column Info
	 * @param otsOtrCostAmt
	 */
	public void setOtsOtrCostAmt(String otsOtrCostAmt) {
		this.otsOtrCostAmt = otsOtrCostAmt;
	}
	
	/**
	 * Column Info
	 * @param otsOftAmt
	 */
	public void setOtsOftAmt(String otsOftAmt) {
		this.otsOftAmt = otsOftAmt;
	}
	
	/**
	 * Column Info
	 * @param ucRsnDesc
	 */
	public void setUcRsnDesc(String ucRsnDesc) {
		this.ucRsnDesc = ucRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param ucCrntUsdAmt
	 */
	public void setUcCrntUsdAmt(String ucCrntUsdAmt) {
		this.ucCrntUsdAmt = ucCrntUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ucOblHldCd
	 */
	public void setUcOblHldCd(String ucOblHldCd) {
		this.ucOblHldCd = ucOblHldCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtTtlVolCtnt
	 */
	public void setCtrtTtlVolCtnt(String ctrtTtlVolCtnt) {
		this.ctrtTtlVolCtnt = ctrtTtlVolCtnt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param otsRcvrAmt
	 */
	public void setOtsRcvrAmt(String otsRcvrAmt) {
		this.otsRcvrAmt = otsRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @param ucPiclbRefNo
	 */
	public void setUcPiclbRefNo(String ucPiclbRefNo) {
		this.ucPiclbRefNo = ucPiclbRefNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param otsRmk
	 */
	public void setOtsRmk(String otsRmk) {
		this.otsRmk = otsRmk;
	}
	
	/**
	 * Column Info
	 * @param kntrUpdId
	 */
	public void setKntrUpdId(String kntrUpdId) {
		this.kntrUpdId = kntrUpdId;
	}
	
	/**
	 * Column Info
	 * @param cneeUcDt
	 */
	public void setCneeUcDt(String cneeUcDt) {
		this.cneeUcDt = cneeUcDt;
	}
	
	/**
	 * Column Info
	 * @param ucCgoN3rdNtcDt
	 */
	public void setUcCgoN3rdNtcDt(String ucCgoN3rdNtcDt) {
		this.ucCgoN3rdNtcDt = ucCgoN3rdNtcDt;
	}
	
	/**
	 * Column Info
	 * @param ucInvAmt
	 */
	public void setUcInvAmt(String ucInvAmt) {
		this.ucInvAmt = ucInvAmt;
	}
	
	/**
	 * Column Info
	 * @param abanLtrShprDt
	 */
	public void setAbanLtrShprDt(String abanLtrShprDt) {
		this.abanLtrShprDt = abanLtrShprDt;
	}
	
	/**
	 * Column Info
	 * @param collect
	 */
	public void setCollect(String collect) {
		this.collect = collect;
	}
	
	/**
	 * Column Info
	 * @param otsStoAmt
	 */
	public void setOtsStoAmt(String otsStoAmt) {
		this.otsStoAmt = otsStoAmt;
	}
	
	/**
	 * Column Info
	 * @param hndlBrncCd
	 */
	public void setHndlBrncCd(String hndlBrncCd) {
		this.hndlBrncCd = hndlBrncCd;
	}
	
	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
	}
	
	/**
	 * Column Info
	 * @param hndlUpdId
	 */
	public void setHndlUpdId(String hndlUpdId) {
		this.hndlUpdId = hndlUpdId;
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
	 * @param ucCtrtTtlVol
	 */
	public void setUcCtrtTtlVol(String ucCtrtTtlVol) {
		this.ucCtrtTtlVol = ucCtrtTtlVol;
	}
	
	/**
	 * Column Info
	 * @param today
	 */
	public void setToday(String today) {
		this.today = today;
	}
	
	/**
	 * Column Info
	 * @param ucCrntAmt
	 */
	public void setUcCrntAmt(String ucCrntAmt) {
		this.ucCrntAmt = ucCrntAmt;
	}
	
	/**
	 * Column Info
	 * @param ucClzDt
	 */
	public void setUcClzDt(String ucClzDt) {
		this.ucClzDt = ucClzDt;
	}
	
	/**
	 * Column Info
	 * @param ucCgoFnlNtcDt
	 */
	public void setUcCgoFnlNtcDt(String ucCgoFnlNtcDt) {
		this.ucCgoFnlNtcDt = ucCgoFnlNtcDt;
	}
	
	/**
	 * Column Info
	 * @param ucCgoNtcRmk
	 */
	public void setUcCgoNtcRmk(String ucCgoNtcRmk) {
		this.ucCgoNtcRmk = ucCgoNtcRmk;
	}
	
	/**
	 * Column Info
	 * @param ucInvXchRt
	 */
	public void setUcInvXchRt(String ucInvXchRt) {
		this.ucInvXchRt = ucInvXchRt;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param hndlUpdDt
	 */
	public void setHndlUpdDt(String hndlUpdDt) {
		this.hndlUpdDt = hndlUpdDt;
	}
	
	/**
	 * Column Info
	 * @param ucDchgDys
	 */
	public void setUcDchgDys(String ucDchgDys) {
		this.ucDchgDys = ucDchgDys;
	}
	
	/**
	 * Column Info
	 * @param kntrUpdDt
	 */
	public void setKntrUpdDt(String kntrUpdDt) {
		this.kntrUpdDt = kntrUpdDt;
	}
	
	/**
	 * Column Info
	 * @param ucDoIssDt
	 */
	public void setUcDoIssDt(String ucDoIssDt) {
		this.ucDoIssDt = ucDoIssDt;
	}
	
	/**
	 * Column Info
	 * @param noti
	 */
	public void setNoti(String noti) {
		this.noti = noti;
	}
	
	/**
	 * Column Info
	 * @param kntrRhqCd
	 */
	public void setKntrRhqCd(String kntrRhqCd) {
		this.kntrRhqCd = kntrRhqCd;
	}
	
	/**
	 * Column Info
	 * @param otsStoDt
	 */
	public void setOtsStoDt(String otsStoDt) {
		this.otsStoDt = otsStoDt;
	}
	
	/**
	 * Column Info
	 * @param kntrBrncCd
	 */
	public void setKntrBrncCd(String kntrBrncCd) {
		this.kntrBrncCd = kntrBrncCd;
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
	 * @param hndlHdlrUsrId
	 */
	public void setHndlHdlrUsrId(String hndlHdlrUsrId) {
		this.hndlHdlrUsrId = hndlHdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param otsDmdtDt
	 */
	public void setOtsDmdtDt(String otsDmdtDt) {
		this.otsDmdtDt = otsDmdtDt;
	}
	
	/**
	 * Column Info
	 * @param kntrOfcOpinDesc
	 */
	public void setKntrOfcOpinDesc(String kntrOfcOpinDesc) {
		this.kntrOfcOpinDesc = kntrOfcOpinDesc;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param hndlRhqCd
	 */
	public void setHndlRhqCd(String hndlRhqCd) {
		this.hndlRhqCd = hndlRhqCd;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcOpinDesc
	 */
	public void setHndlOfcOpinDesc(String hndlOfcOpinDesc) {
		this.hndlOfcOpinDesc = hndlOfcOpinDesc;
	}
	
	/**
	 * Column Info
	 * @param otsOtrAmt
	 */
	public void setOtsOtrAmt(String otsOtrAmt) {
		this.otsOtrAmt = otsOtrAmt;
	}
	
	/**
	 * Column Info
	 * @param ucCrntXchRt
	 */
	public void setUcCrntXchRt(String ucCrntXchRt) {
		this.ucCrntXchRt = ucCrntXchRt;
	}
	
	/**
	 * Column Info
	 * @param ucInvCurrCd
	 */
	public void setUcInvCurrCd(String ucInvCurrCd) {
		this.ucInvCurrCd = ucInvCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ucCgoN2ndNtcDt
	 */
	public void setUcCgoN2ndNtcDt(String ucCgoN2ndNtcDt) {
		this.ucCgoN2ndNtcDt = ucCgoN2ndNtcDt;
	}
	
	/**
	 * Column Info
	 * @param fileCnt
	 */
	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}
	
	/**
	 * Column Info
	 * @param ucRopnFlg
	 */
	public void setUcRopnFlg(String ucRopnFlg) {
		this.ucRopnFlg = ucRopnFlg;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param kntrHdlrUsrId
	 */
	public void setKntrHdlrUsrId(String kntrHdlrUsrId) {
		this.kntrHdlrUsrId = kntrHdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param factFndActDesc
	 */
	public void setFactFndActDesc(String factFndActDesc) {
		this.factFndActDesc = factFndActDesc;
	}
	
	/**
	 * Column Info
	 * @param ucInvUsdAmt
	 */
	public void setUcInvUsdAmt(String ucInvUsdAmt) {
		this.ucInvUsdAmt = ucInvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ucCrntCurrCd
	 */
	public void setUcCrntCurrCd(String ucCrntCurrCd) {
		this.ucCrntCurrCd = ucCrntCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ucCgoN1stNtcDt
	 */
	public void setUcCgoN1stNtcDt(String ucCgoN1stNtcDt) {
		this.ucCgoN1stNtcDt = ucCgoN1stNtcDt;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param otsDmdtAmt
	 */
	public void setOtsDmdtAmt(String otsDmdtAmt) {
		this.otsDmdtAmt = otsDmdtAmt;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}
	
	

	public String getManagerMemo() {
	    return managerMemo;
    }

    public void setManagerMemo(String managerMemo) {
	    this.managerMemo = managerMemo;
    }

	public String getIsAuthority() {
		return isAuthority;
	}

	public void setIsAuthority(String isAuthority) {
		this.isAuthority = isAuthority;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUcOfcTrnsFlg(JSPUtil.getParameter(request, prefix + "uc_ofc_trns_flg", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setUcSeq(JSPUtil.getParameter(request, prefix + "uc_seq", ""));
		setUcDispOptCd(JSPUtil.getParameter(request, prefix + "uc_disp_opt_cd", ""));
		setUcCgoLocNm(JSPUtil.getParameter(request, prefix + "uc_cgo_loc_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setUcCtrtRmk(JSPUtil.getParameter(request, prefix + "uc_ctrt_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOtsInsurCvrAmt(JSPUtil.getParameter(request, prefix + "ots_insur_cvr_amt", ""));
		setCmdt(JSPUtil.getParameter(request, prefix + "cmdt", ""));
		setPorDt(JSPUtil.getParameter(request, prefix + "por_dt", ""));
		setUcRsnCd(JSPUtil.getParameter(request, prefix + "uc_rsn_cd", ""));
		setFrwd(JSPUtil.getParameter(request, prefix + "frwd", ""));
		setUcDys(JSPUtil.getParameter(request, prefix + "uc_dys", ""));
		setUcCsNo(JSPUtil.getParameter(request, prefix + "uc_cs_no", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setUcStsCd(JSPUtil.getParameter(request, prefix + "uc_sts_cd", ""));
		setAbanLtrCneeDt(JSPUtil.getParameter(request, prefix + "aban_ltr_cnee_dt", ""));
		setDelDt(JSPUtil.getParameter(request, prefix + "del_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOtsOtrCostDt(JSPUtil.getParameter(request, prefix + "ots_otr_cost_dt", ""));
		setUcPiclbCd(JSPUtil.getParameter(request, prefix + "uc_piclb_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPrepaid(JSPUtil.getParameter(request, prefix + "prepaid", ""));
		setOtsOtrCostAmt(JSPUtil.getParameter(request, prefix + "ots_otr_cost_amt", ""));
		setOtsOftAmt(JSPUtil.getParameter(request, prefix + "ots_oft_amt", ""));
		setUcRsnDesc(JSPUtil.getParameter(request, prefix + "uc_rsn_desc", ""));
		setUcCrntUsdAmt(JSPUtil.getParameter(request, prefix + "uc_crnt_usd_amt", ""));
		setUcOblHldCd(JSPUtil.getParameter(request, prefix + "uc_obl_hld_cd", ""));
		setCtrtTtlVolCtnt(JSPUtil.getParameter(request, prefix + "ctrt_ttl_vol_ctnt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOtsRcvrAmt(JSPUtil.getParameter(request, prefix + "ots_rcvr_amt", ""));
		setUcPiclbRefNo(JSPUtil.getParameter(request, prefix + "uc_piclb_ref_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOtsRmk(JSPUtil.getParameter(request, prefix + "ots_rmk", ""));
		setKntrUpdId(JSPUtil.getParameter(request, prefix + "kntr_upd_id", ""));
		setCneeUcDt(JSPUtil.getParameter(request, prefix + "cnee_uc_dt", ""));
		setUcCgoN3rdNtcDt(JSPUtil.getParameter(request, prefix + "uc_cgo_n3rd_ntc_dt", ""));
		setUcInvAmt(JSPUtil.getParameter(request, prefix + "uc_inv_amt", ""));
		setAbanLtrShprDt(JSPUtil.getParameter(request, prefix + "aban_ltr_shpr_dt", ""));
		setCollect(JSPUtil.getParameter(request, prefix + "collect", ""));
		setOtsStoAmt(JSPUtil.getParameter(request, prefix + "ots_sto_amt", ""));
		setHndlBrncCd(JSPUtil.getParameter(request, prefix + "hndl_brnc_cd", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
		setHndlUpdId(JSPUtil.getParameter(request, prefix + "hndl_upd_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUcCtrtTtlVol(JSPUtil.getParameter(request, prefix + "uc_ctrt_ttl_vol", ""));
		setToday(JSPUtil.getParameter(request, prefix + "today", ""));
		setUcCrntAmt(JSPUtil.getParameter(request, prefix + "uc_crnt_amt", ""));
		setUcClzDt(JSPUtil.getParameter(request, prefix + "uc_clz_dt", ""));
		setUcCgoFnlNtcDt(JSPUtil.getParameter(request, prefix + "uc_cgo_fnl_ntc_dt", ""));
		setUcCgoNtcRmk(JSPUtil.getParameter(request, prefix + "uc_cgo_ntc_rmk", ""));
		setUcInvXchRt(JSPUtil.getParameter(request, prefix + "uc_inv_xch_rt", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHndlUpdDt(JSPUtil.getParameter(request, prefix + "hndl_upd_dt", ""));
		setUcDchgDys(JSPUtil.getParameter(request, prefix + "uc_dchg_dys", ""));
		setKntrUpdDt(JSPUtil.getParameter(request, prefix + "kntr_upd_dt", ""));
		setUcDoIssDt(JSPUtil.getParameter(request, prefix + "uc_do_iss_dt", ""));
		setNoti(JSPUtil.getParameter(request, prefix + "noti", ""));
		setKntrRhqCd(JSPUtil.getParameter(request, prefix + "kntr_rhq_cd", ""));
		setOtsStoDt(JSPUtil.getParameter(request, prefix + "ots_sto_dt", ""));
		setKntrBrncCd(JSPUtil.getParameter(request, prefix + "kntr_brnc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setHndlHdlrUsrId(JSPUtil.getParameter(request, prefix + "hndl_hdlr_usr_id", ""));
		setHndlHdlrUsrNm(JSPUtil.getParameter(request, prefix + "hndl_hdlr_usr_nm", ""));
		setOtsDmdtDt(JSPUtil.getParameter(request, prefix + "ots_dmdt_dt", ""));
		setKntrOfcOpinDesc(JSPUtil.getParameter(request, prefix + "kntr_ofc_opin_desc", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setHndlRhqCd(JSPUtil.getParameter(request, prefix + "hndl_rhq_cd", ""));
		setHndlOfcOpinDesc(JSPUtil.getParameter(request, prefix + "hndl_ofc_opin_desc", ""));
		setOtsOtrAmt(JSPUtil.getParameter(request, prefix + "ots_otr_amt", ""));
		setUcCrntXchRt(JSPUtil.getParameter(request, prefix + "uc_crnt_xch_rt", ""));
		setUcInvCurrCd(JSPUtil.getParameter(request, prefix + "uc_inv_curr_cd", ""));
		setUcCgoN2ndNtcDt(JSPUtil.getParameter(request, prefix + "uc_cgo_n2nd_ntc_dt", ""));
		setFileCnt(JSPUtil.getParameter(request, prefix + "file_cnt", ""));
		setUcRopnFlg(JSPUtil.getParameter(request, prefix + "uc_ropn_flg", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setKntrHdlrUsrId(JSPUtil.getParameter(request, prefix + "kntr_hdlr_usr_id", ""));
		setKntrHdlrUsrNm(JSPUtil.getParameter(request, prefix + "kntr_hdlr_usr_nm", ""));
		setFactFndActDesc(JSPUtil.getParameter(request, prefix + "fact_fnd_act_desc", ""));
		setUcInvUsdAmt(JSPUtil.getParameter(request, prefix + "uc_inv_usd_amt", ""));
		setUcCrntCurrCd(JSPUtil.getParameter(request, prefix + "uc_crnt_curr_cd", ""));
		setUcCgoN1stNtcDt(JSPUtil.getParameter(request, prefix + "uc_cgo_n1st_ntc_dt", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setOtsDmdtAmt(JSPUtil.getParameter(request, prefix + "ots_dmdt_amt", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
		setManagerMemo(JSPUtil.getParameter(request, prefix + "manager_memo", ""));
		setIsAuthority(JSPUtil.getParameter(request, prefix + "isauthority", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UncollectedCargoVO[]
	 */
	public UncollectedCargoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UncollectedCargoVO[]
	 */
	public UncollectedCargoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UncollectedCargoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ucOfcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "uc_ofc_trns_flg", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] ucSeq = (JSPUtil.getParameter(request, prefix	+ "uc_seq", length));
			String[] ucDispOptCd = (JSPUtil.getParameter(request, prefix	+ "uc_disp_opt_cd", length));
			String[] ucCgoLocNm = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_loc_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ucCtrtRmk = (JSPUtil.getParameter(request, prefix	+ "uc_ctrt_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] otsInsurCvrAmt = (JSPUtil.getParameter(request, prefix	+ "ots_insur_cvr_amt", length));
			String[] cmdt = (JSPUtil.getParameter(request, prefix	+ "cmdt", length));
			String[] porDt = (JSPUtil.getParameter(request, prefix	+ "por_dt", length));
			String[] ucRsnCd = (JSPUtil.getParameter(request, prefix	+ "uc_rsn_cd", length));
			String[] frwd = (JSPUtil.getParameter(request, prefix	+ "frwd", length));
			String[] ucDys = (JSPUtil.getParameter(request, prefix	+ "uc_dys", length));
			String[] ucCsNo = (JSPUtil.getParameter(request, prefix	+ "uc_cs_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] ucStsCd = (JSPUtil.getParameter(request, prefix	+ "uc_sts_cd", length));
			String[] abanLtrCneeDt = (JSPUtil.getParameter(request, prefix	+ "aban_ltr_cnee_dt", length));
			String[] delDt = (JSPUtil.getParameter(request, prefix	+ "del_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] otsOtrCostDt = (JSPUtil.getParameter(request, prefix	+ "ots_otr_cost_dt", length));
			String[] ucPiclbCd = (JSPUtil.getParameter(request, prefix	+ "uc_piclb_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] prepaid = (JSPUtil.getParameter(request, prefix	+ "prepaid", length));
			String[] otsOtrCostAmt = (JSPUtil.getParameter(request, prefix	+ "ots_otr_cost_amt", length));
			String[] otsOftAmt = (JSPUtil.getParameter(request, prefix	+ "ots_oft_amt", length));
			String[] ucRsnDesc = (JSPUtil.getParameter(request, prefix	+ "uc_rsn_desc", length));
			String[] ucCrntUsdAmt = (JSPUtil.getParameter(request, prefix	+ "uc_crnt_usd_amt", length));
			String[] ucOblHldCd = (JSPUtil.getParameter(request, prefix	+ "uc_obl_hld_cd", length));
			String[] ctrtTtlVolCtnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_ttl_vol_ctnt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] otsRcvrAmt = (JSPUtil.getParameter(request, prefix	+ "ots_rcvr_amt", length));
			String[] ucPiclbRefNo = (JSPUtil.getParameter(request, prefix	+ "uc_piclb_ref_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] otsRmk = (JSPUtil.getParameter(request, prefix	+ "ots_rmk", length));
			String[] kntrUpdId = (JSPUtil.getParameter(request, prefix	+ "kntr_upd_id", length));
			String[] cneeUcDt = (JSPUtil.getParameter(request, prefix	+ "cnee_uc_dt", length));
			String[] ucCgoN3rdNtcDt = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_n3rd_ntc_dt", length));
			String[] ucInvAmt = (JSPUtil.getParameter(request, prefix	+ "uc_inv_amt", length));
			String[] abanLtrShprDt = (JSPUtil.getParameter(request, prefix	+ "aban_ltr_shpr_dt", length));
			String[] collect = (JSPUtil.getParameter(request, prefix	+ "collect", length));
			String[] otsStoAmt = (JSPUtil.getParameter(request, prefix	+ "ots_sto_amt", length));
			String[] hndlBrncCd = (JSPUtil.getParameter(request, prefix	+ "hndl_brnc_cd", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			String[] hndlUpdId = (JSPUtil.getParameter(request, prefix	+ "hndl_upd_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ucCtrtTtlVol = (JSPUtil.getParameter(request, prefix	+ "uc_ctrt_ttl_vol", length));
			String[] today = (JSPUtil.getParameter(request, prefix	+ "today", length));
			String[] ucCrntAmt = (JSPUtil.getParameter(request, prefix	+ "uc_crnt_amt", length));
			String[] ucClzDt = (JSPUtil.getParameter(request, prefix	+ "uc_clz_dt", length));
			String[] ucCgoFnlNtcDt = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_fnl_ntc_dt", length));
			String[] ucCgoNtcRmk = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_ntc_rmk", length));
			String[] ucInvXchRt = (JSPUtil.getParameter(request, prefix	+ "uc_inv_xch_rt", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hndlUpdDt = (JSPUtil.getParameter(request, prefix	+ "hndl_upd_dt", length));
			String[] ucDchgDys = (JSPUtil.getParameter(request, prefix	+ "uc_dchg_dys", length));
			String[] kntrUpdDt = (JSPUtil.getParameter(request, prefix	+ "kntr_upd_dt", length));
			String[] ucDoIssDt = (JSPUtil.getParameter(request, prefix	+ "uc_do_iss_dt", length));
			String[] noti = (JSPUtil.getParameter(request, prefix	+ "noti", length));
			String[] kntrRhqCd = (JSPUtil.getParameter(request, prefix	+ "kntr_rhq_cd", length));
			String[] otsStoDt = (JSPUtil.getParameter(request, prefix	+ "ots_sto_dt", length));
			String[] kntrBrncCd = (JSPUtil.getParameter(request, prefix	+ "kntr_brnc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hndlHdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hndl_hdlr_usr_id", length));
			String[] hndlHdlrUsrNm = (JSPUtil.getParameter(request, prefix	+ "hndl_hdlr_usr_nm", length));
			String[] otsDmdtDt = (JSPUtil.getParameter(request, prefix	+ "ots_dmdt_dt", length));
			String[] kntrOfcOpinDesc = (JSPUtil.getParameter(request, prefix	+ "kntr_ofc_opin_desc", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] hndlRhqCd = (JSPUtil.getParameter(request, prefix	+ "hndl_rhq_cd", length));
			String[] hndlOfcOpinDesc = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_opin_desc", length));
			String[] otsOtrAmt = (JSPUtil.getParameter(request, prefix	+ "ots_otr_amt", length));
			String[] ucCrntXchRt = (JSPUtil.getParameter(request, prefix	+ "uc_crnt_xch_rt", length));
			String[] ucInvCurrCd = (JSPUtil.getParameter(request, prefix	+ "uc_inv_curr_cd", length));
			String[] ucCgoN2ndNtcDt = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_n2nd_ntc_dt", length));
			String[] fileCnt = (JSPUtil.getParameter(request, prefix	+ "file_cnt", length));
			String[] ucRopnFlg = (JSPUtil.getParameter(request, prefix	+ "uc_ropn_flg", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] kntrHdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "kntr_hdlr_usr_id", length));
			String[] kntrHdlrUsrNm = (JSPUtil.getParameter(request, prefix	+ "kntr_hdlr_usr_nm", length));
			String[] factFndActDesc = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_act_desc", length));
			String[] ucInvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "uc_inv_usd_amt", length));
			String[] ucCrntCurrCd = (JSPUtil.getParameter(request, prefix	+ "uc_crnt_curr_cd", length));
			String[] ucCgoN1stNtcDt = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_n1st_ntc_dt", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] otsDmdtAmt = (JSPUtil.getParameter(request, prefix	+ "ots_dmdt_amt", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));			
			String[] managerMemo = (JSPUtil.getParameter(request, prefix	+ "manager_memo", length));
			String[] isAuthority = (JSPUtil.getParameter(request, prefix	+ "isauthority", length));
			
			for (int i = 0; i < length; i++) {
				model = new UncollectedCargoVO();
				if (ucOfcTrnsFlg[i] != null)
					model.setUcOfcTrnsFlg(ucOfcTrnsFlg[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (ucSeq[i] != null)
					model.setUcSeq(ucSeq[i]);
				if (ucDispOptCd[i] != null)
					model.setUcDispOptCd(ucDispOptCd[i]);
				if (ucCgoLocNm[i] != null)
					model.setUcCgoLocNm(ucCgoLocNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ucCtrtRmk[i] != null)
					model.setUcCtrtRmk(ucCtrtRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (otsInsurCvrAmt[i] != null)
					model.setOtsInsurCvrAmt(otsInsurCvrAmt[i]);
				if (cmdt[i] != null)
					model.setCmdt(cmdt[i]);
				if (porDt[i] != null)
					model.setPorDt(porDt[i]);
				if (ucRsnCd[i] != null)
					model.setUcRsnCd(ucRsnCd[i]);
				if (frwd[i] != null)
					model.setFrwd(frwd[i]);
				if (ucDys[i] != null)
					model.setUcDys(ucDys[i]);
				if (ucCsNo[i] != null)
					model.setUcCsNo(ucCsNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (ucStsCd[i] != null)
					model.setUcStsCd(ucStsCd[i]);
				if (abanLtrCneeDt[i] != null)
					model.setAbanLtrCneeDt(abanLtrCneeDt[i]);
				if (delDt[i] != null)
					model.setDelDt(delDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (otsOtrCostDt[i] != null)
					model.setOtsOtrCostDt(otsOtrCostDt[i]);
				if (ucPiclbCd[i] != null)
					model.setUcPiclbCd(ucPiclbCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (prepaid[i] != null)
					model.setPrepaid(prepaid[i]);
				if (otsOtrCostAmt[i] != null)
					model.setOtsOtrCostAmt(otsOtrCostAmt[i]);
				if (otsOftAmt[i] != null)
					model.setOtsOftAmt(otsOftAmt[i]);
				if (ucRsnDesc[i] != null)
					model.setUcRsnDesc(ucRsnDesc[i]);
				if (ucCrntUsdAmt[i] != null)
					model.setUcCrntUsdAmt(ucCrntUsdAmt[i]);
				if (ucOblHldCd[i] != null)
					model.setUcOblHldCd(ucOblHldCd[i]);
				if (ctrtTtlVolCtnt[i] != null)
					model.setCtrtTtlVolCtnt(ctrtTtlVolCtnt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (otsRcvrAmt[i] != null)
					model.setOtsRcvrAmt(otsRcvrAmt[i]);
				if (ucPiclbRefNo[i] != null)
					model.setUcPiclbRefNo(ucPiclbRefNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (otsRmk[i] != null)
					model.setOtsRmk(otsRmk[i]);
				if (kntrUpdId[i] != null)
					model.setKntrUpdId(kntrUpdId[i]);
				if (cneeUcDt[i] != null)
					model.setCneeUcDt(cneeUcDt[i]);
				if (ucCgoN3rdNtcDt[i] != null)
					model.setUcCgoN3rdNtcDt(ucCgoN3rdNtcDt[i]);
				if (ucInvAmt[i] != null)
					model.setUcInvAmt(ucInvAmt[i]);
				if (abanLtrShprDt[i] != null)
					model.setAbanLtrShprDt(abanLtrShprDt[i]);
				if (collect[i] != null)
					model.setCollect(collect[i]);
				if (otsStoAmt[i] != null)
					model.setOtsStoAmt(otsStoAmt[i]);
				if (hndlBrncCd[i] != null)
					model.setHndlBrncCd(hndlBrncCd[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				if (hndlUpdId[i] != null)
					model.setHndlUpdId(hndlUpdId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ucCtrtTtlVol[i] != null)
					model.setUcCtrtTtlVol(ucCtrtTtlVol[i]);
				if (today[i] != null)
					model.setToday(today[i]);
				if (ucCrntAmt[i] != null)
					model.setUcCrntAmt(ucCrntAmt[i]);
				if (ucClzDt[i] != null)
					model.setUcClzDt(ucClzDt[i]);
				if (ucCgoFnlNtcDt[i] != null)
					model.setUcCgoFnlNtcDt(ucCgoFnlNtcDt[i]);
				if (ucCgoNtcRmk[i] != null)
					model.setUcCgoNtcRmk(ucCgoNtcRmk[i]);
				if (ucInvXchRt[i] != null)
					model.setUcInvXchRt(ucInvXchRt[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hndlUpdDt[i] != null)
					model.setHndlUpdDt(hndlUpdDt[i]);
				if (ucDchgDys[i] != null)
					model.setUcDchgDys(ucDchgDys[i]);
				if (kntrUpdDt[i] != null)
					model.setKntrUpdDt(kntrUpdDt[i]);
				if (ucDoIssDt[i] != null)
					model.setUcDoIssDt(ucDoIssDt[i]);
				if (noti[i] != null)
					model.setNoti(noti[i]);
				if (kntrRhqCd[i] != null)
					model.setKntrRhqCd(kntrRhqCd[i]);
				if (otsStoDt[i] != null)
					model.setOtsStoDt(otsStoDt[i]);
				if (kntrBrncCd[i] != null)
					model.setKntrBrncCd(kntrBrncCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hndlHdlrUsrId[i] != null)
					model.setHndlHdlrUsrId(hndlHdlrUsrId[i]);
				if (hndlHdlrUsrNm[i] != null)
					model.setHndlHdlrUsrNm(hndlHdlrUsrNm[i]);
				if (otsDmdtDt[i] != null)
					model.setOtsDmdtDt(otsDmdtDt[i]);
				if (kntrOfcOpinDesc[i] != null)
					model.setKntrOfcOpinDesc(kntrOfcOpinDesc[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (hndlRhqCd[i] != null)
					model.setHndlRhqCd(hndlRhqCd[i]);
				if (hndlOfcOpinDesc[i] != null)
					model.setHndlOfcOpinDesc(hndlOfcOpinDesc[i]);
				if (otsOtrAmt[i] != null)
					model.setOtsOtrAmt(otsOtrAmt[i]);
				if (ucCrntXchRt[i] != null)
					model.setUcCrntXchRt(ucCrntXchRt[i]);
				if (ucInvCurrCd[i] != null)
					model.setUcInvCurrCd(ucInvCurrCd[i]);
				if (ucCgoN2ndNtcDt[i] != null)
					model.setUcCgoN2ndNtcDt(ucCgoN2ndNtcDt[i]);
				if (fileCnt[i] != null)
					model.setFileCnt(fileCnt[i]);
				if (ucRopnFlg[i] != null)
					model.setUcRopnFlg(ucRopnFlg[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (kntrHdlrUsrId[i] != null)
					model.setKntrHdlrUsrId(kntrHdlrUsrId[i]);
				if (kntrHdlrUsrNm[i] != null)
					model.setKntrHdlrUsrId(kntrHdlrUsrNm[i]);
				if (factFndActDesc[i] != null)
					model.setFactFndActDesc(factFndActDesc[i]);
				if (ucInvUsdAmt[i] != null)
					model.setUcInvUsdAmt(ucInvUsdAmt[i]);
				if (ucCrntCurrCd[i] != null)
					model.setUcCrntCurrCd(ucCrntCurrCd[i]);
				if (ucCgoN1stNtcDt[i] != null)
					model.setUcCgoN1stNtcDt(ucCgoN1stNtcDt[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (otsDmdtAmt[i] != null)
					model.setOtsDmdtAmt(otsDmdtAmt[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (managerMemo[i] != null)
					model.setManagerMemo(managerMemo[i]);
				if (isAuthority[i] != null)
					model.setIsAuthority(isAuthority[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUncollectedCargoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UncollectedCargoVO[]
	 */
	public UncollectedCargoVO[] getUncollectedCargoVOs(){
		UncollectedCargoVO[] vos = (UncollectedCargoVO[])models.toArray(new UncollectedCargoVO[models.size()]);
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
		this.ucOfcTrnsFlg = this.ucOfcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucSeq = this.ucSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucDispOptCd = this.ucDispOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoLocNm = this.ucCgoLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCtrtRmk = this.ucCtrtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsInsurCvrAmt = this.otsInsurCvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdt = this.cmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDt = this.porDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucRsnCd = this.ucRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frwd = this.frwd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucDys = this.ucDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCsNo = this.ucCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucStsCd = this.ucStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abanLtrCneeDt = this.abanLtrCneeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDt = this.delDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOtrCostDt = this.otsOtrCostDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucPiclbCd = this.ucPiclbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepaid = this.prepaid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOtrCostAmt = this.otsOtrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOftAmt = this.otsOftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucRsnDesc = this.ucRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCrntUsdAmt = this.ucCrntUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucOblHldCd = this.ucOblHldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTtlVolCtnt = this.ctrtTtlVolCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRcvrAmt = this.otsRcvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucPiclbRefNo = this.ucPiclbRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk = this.otsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrUpdId = this.kntrUpdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeUcDt = this.cneeUcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoN3rdNtcDt = this.ucCgoN3rdNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucInvAmt = this.ucInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abanLtrShprDt = this.abanLtrShprDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collect = this.collect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStoAmt = this.otsStoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlBrncCd = this.hndlBrncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlUpdId = this.hndlUpdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCtrtTtlVol = this.ucCtrtTtlVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.today = this.today .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCrntAmt = this.ucCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucClzDt = this.ucClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoFnlNtcDt = this.ucCgoFnlNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoNtcRmk = this.ucCgoNtcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucInvXchRt = this.ucInvXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlUpdDt = this.hndlUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucDchgDys = this.ucDchgDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrUpdDt = this.kntrUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucDoIssDt = this.ucDoIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noti = this.noti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrRhqCd = this.kntrRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStoDt = this.otsStoDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrBrncCd = this.kntrBrncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlHdlrUsrId = this.hndlHdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlHdlrUsrNm = this.hndlHdlrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDmdtDt = this.otsDmdtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrOfcOpinDesc = this.kntrOfcOpinDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlRhqCd = this.hndlRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcOpinDesc = this.hndlOfcOpinDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOtrAmt = this.otsOtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCrntXchRt = this.ucCrntXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucInvCurrCd = this.ucInvCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoN2ndNtcDt = this.ucCgoN2ndNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileCnt = this.fileCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucRopnFlg = this.ucRopnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrHdlrUsrId = this.kntrHdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kntrHdlrUsrNm = this.kntrHdlrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factFndActDesc = this.factFndActDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucInvUsdAmt = this.ucInvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCrntCurrCd = this.ucCrntCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoN1stNtcDt = this.ucCgoN1stNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDmdtAmt = this.otsDmdtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
