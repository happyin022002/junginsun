/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GrpBlPrtInVO.java
*@FileTitle : GrpBlPrtInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo;

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

public class GrpBlPrtInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlPrtInVO> models = new ArrayList<GrpBlPrtInVO>();
	
	/* Column Info */
	private String descInlndSvcModCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bookingPolCd = null;
	/* Column Info */
	private String advShtgCdS = null;
	/* Column Info */
	private String bkgCgoTpCdF = null;
	/* Column Info */
	private String vvdPrePol = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String advShtgCdA = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String docUsrCd = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String oblIssFromDt = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String querySort = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String shprOwnrCntrFlg = null;
	/* Column Info */
	private String aesItnY = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgStsCdW = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String vvdPolLocal = null;
	/* Column Info */
	private String orgScontiCd = null;
	/* Column Info */
	private String bookingRcvTermCd = null;
	/* Column Info */
	private String bookingDelCd = null;
	/* Column Info */
	private String bkgStsCdF = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String masterBlNo = null;
	/* Column Info */
	private String masterBkgNo = null;
	/* Column Info */
	private String bookingPodCd = null;
	/* Column Info */
	private String wtRsnHldFlg = null;
	/* Column Info */
	private String stopCargo = null;
	/* Column Info */
	private String eqPorCd = null;
	/* Column Info */
	private String spclHideFlg = null;
	/* Column Info */
	private String caedY = null;
	/* Column Info */
	private String oblIssToDt = null;
	/* Column Info */
	private String caedN = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String bkgRsnSpclCgoFlg = null;
	/* Column Info */
	private String vvdPodCd = null;
	/* Column Info */
	private String bookingPorCd = null;
	/* Column Info */
	private String revenueR = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String revenueN = null;
	/* Column Info */
	private String hogDeFlg = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String eqDelCd = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String fdGrdFlg = null;
	/* Column Info */
	private String oblIssDate = null;
	/* Column Info */
	private String vvdPostPod = null;
	/* Column Info */
	private String descScontiCd = null;
	/* Column Info */
	private String orgSvcModCd = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String eqSubstFlg = null;
	/* Column Info */
	private String scRfaChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String railBlkCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String custTpCdS = null;
	/* Column Info */
	private String revenue = null;
	/* Column Info */
	private String custTpCdN = null;
	/* Column Info */
	private String vvdPodLocal = null;
	/* Column Info */
	private String vvdPostVvd = null;
	/* Column Info */
	private String custTpCdF = null;
	/* Column Info */
	private String custTpCdG = null;
	/* Column Info */
	private String vvdPolTs = null;
	/* Column Info */
	private String vvdPreVvd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String aesItnN = null;
	/* Column Info */
	private String custTpCdC = null;
	/* Column Info */
	private String twnSoNo = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String vvdPolCd = null;
	/* Column Info */
	private String custTpCdA = null;
	/* Column Info */
	private String vvdPodTs = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String bkgCgoTpCdR = null;
	/* Column Info */
	private String bookingDeTermCd = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String bkgCgoTpCdP = null;
	/* Column Info */
	private String repCmdtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlPrtInVO() {}

	public GrpBlPrtInVO(String ibflag, String pagerows, String descInlndSvcModCd, String bkgCgoTpCd, String bookingPolCd, String advShtgCdS, String bkgCgoTpCdF, String vvdPrePol, String obSrepCd, String advShtgCdA, String oblIssUsrId, String docUsrCd, String prctFlg, String oblIssFromDt, String querySort, String stwgCd, String shprOwnrCntrFlg, String obSlsOfcCd, String aesItnY, String bkgStsCdW, String custCntCd, String oblIssOfcCd, String bkgOfcCd, String custRefNo, String awkCgoFlg, String vvdPolLocal, String orgScontiCd, String bookingRcvTermCd, String bookingDelCd, String bkgStsCdF, String vvd, String masterBlNo, String masterBkgNo, String bookingPodCd, String wtRsnHldFlg, String stopCargo, String eqPorCd, String spclHideFlg, String caedY, String oblIssToDt, String caedN, String rcFlg, String bkgRsnSpclCgoFlg, String vvdPodCd, String bookingPorCd, String revenueR, String custNm, String revenueN, String hogDeFlg, String rdCgoFlg, String bkgStsCd, String fdGrdFlg, String eqCtrlOfcCd, String eqDelCd, String vvdPostPod, String descScontiCd, String orgSvcModCd, String advShtgCd, String eqSubstFlg, String scRfaChk, String railBlkCd, String cmdtCd, String bbCgoFlg, String dcgoFlg, String vslPrePstCd, String custTpCd, String custTpCdS, String revenue, String custTpCdN, String vvdPodLocal, String vvdPostVvd, String custTpCdF, String custTpCdG, String vvdPolTs, String aesItnN, String custSeq, String vvdPreVvd, String twnSoNo, String custTpCdC, String vvdPolCd, String cmdtNm, String custTpCdA, String vvdPodTs, String scRfaNo, String bkgCgoTpCdR, String bookingDeTermCd, String bkgCgoTpCdP, String hngrFlg, String repCmdtCd, String oblIssDate) {
		this.descInlndSvcModCd = descInlndSvcModCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bookingPolCd = bookingPolCd;
		this.advShtgCdS = advShtgCdS;
		this.bkgCgoTpCdF = bkgCgoTpCdF;
		this.vvdPrePol = vvdPrePol;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.advShtgCdA = advShtgCdA;
		this.oblIssUsrId = oblIssUsrId;
		this.docUsrCd = docUsrCd;
		this.prctFlg = prctFlg;
		this.oblIssFromDt = oblIssFromDt;
		this.stwgCd = stwgCd;
		this.querySort = querySort;
		this.obSlsOfcCd = obSlsOfcCd;
		this.shprOwnrCntrFlg = shprOwnrCntrFlg;
		this.aesItnY = aesItnY;
		this.custCntCd = custCntCd;
		this.bkgStsCdW = bkgStsCdW;
		this.oblIssOfcCd = oblIssOfcCd;
		this.bkgOfcCd = bkgOfcCd;
		this.custRefNo = custRefNo;
		this.awkCgoFlg = awkCgoFlg;
		this.vvdPolLocal = vvdPolLocal;
		this.orgScontiCd = orgScontiCd;
		this.bookingRcvTermCd = bookingRcvTermCd;
		this.bookingDelCd = bookingDelCd;
		this.bkgStsCdF = bkgStsCdF;
		this.vvd = vvd;
		this.masterBlNo = masterBlNo;
		this.masterBkgNo = masterBkgNo;
		this.bookingPodCd = bookingPodCd;
		this.wtRsnHldFlg = wtRsnHldFlg;
		this.stopCargo = stopCargo;
		this.eqPorCd = eqPorCd;
		this.spclHideFlg = spclHideFlg;
		this.caedY = caedY;
		this.oblIssToDt = oblIssToDt;
		this.caedN = caedN;
		this.rcFlg = rcFlg;
		this.bkgRsnSpclCgoFlg = bkgRsnSpclCgoFlg;
		this.vvdPodCd = vvdPodCd;
		this.bookingPorCd = bookingPorCd;
		this.revenueR = revenueR;
		this.custNm = custNm;
		this.revenueN = revenueN;
		this.hogDeFlg = hogDeFlg;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgStsCd = bkgStsCd;
		this.eqDelCd = eqDelCd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.fdGrdFlg = fdGrdFlg;
		this.oblIssDate = oblIssDate;
		this.vvdPostPod = vvdPostPod;
		this.descScontiCd = descScontiCd;
		this.orgSvcModCd = orgSvcModCd;
		this.advShtgCd = advShtgCd;
		this.eqSubstFlg = eqSubstFlg;
		this.scRfaChk = scRfaChk;
		this.ibflag = ibflag;
		this.railBlkCd = railBlkCd;
		this.cmdtCd = cmdtCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.vslPrePstCd = vslPrePstCd;
		this.custTpCd = custTpCd;
		this.custTpCdS = custTpCdS;
		this.revenue = revenue;
		this.custTpCdN = custTpCdN;
		this.vvdPodLocal = vvdPodLocal;
		this.vvdPostVvd = vvdPostVvd;
		this.custTpCdF = custTpCdF;
		this.custTpCdG = custTpCdG;
		this.vvdPolTs = vvdPolTs;
		this.vvdPreVvd = vvdPreVvd;
		this.custSeq = custSeq;
		this.aesItnN = aesItnN;
		this.custTpCdC = custTpCdC;
		this.twnSoNo = twnSoNo;
		this.cmdtNm = cmdtNm;
		this.vvdPolCd = vvdPolCd;
		this.custTpCdA = custTpCdA;
		this.vvdPodTs = vvdPodTs;
		this.scRfaNo = scRfaNo;
		this.bkgCgoTpCdR = bkgCgoTpCdR;
		this.bookingDeTermCd = bookingDeTermCd;
		this.hngrFlg = hngrFlg;
		this.bkgCgoTpCdP = bkgCgoTpCdP;
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("desc_inlnd_svc_mod_cd", getDescInlndSvcModCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("booking_pol_cd", getBookingPolCd());
		this.hashColumns.put("adv_shtg_cd_s", getAdvShtgCdS());
		this.hashColumns.put("bkg_cgo_tp_cd_f", getBkgCgoTpCdF());
		this.hashColumns.put("vvd_pre_pol", getVvdPrePol());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("adv_shtg_cd_a", getAdvShtgCdA());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("doc_usr_cd", getDocUsrCd());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("obl_iss_from_dt", getOblIssFromDt());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("query_sort", getQuerySort());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("shpr_ownr_cntr_flg", getShprOwnrCntrFlg());
		this.hashColumns.put("aes_itn_y", getAesItnY());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_sts_cd_w", getBkgStsCdW());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("vvd_pol_local", getVvdPolLocal());
		this.hashColumns.put("org_sconti_cd", getOrgScontiCd());
		this.hashColumns.put("booking_rcv_term_cd", getBookingRcvTermCd());
		this.hashColumns.put("booking_del_cd", getBookingDelCd());
		this.hashColumns.put("bkg_sts_cd_f", getBkgStsCdF());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("master_bl_no", getMasterBlNo());
		this.hashColumns.put("master_bkg_no", getMasterBkgNo());
		this.hashColumns.put("booking_pod_cd", getBookingPodCd());
		this.hashColumns.put("wt_rsn_hld_flg", getWtRsnHldFlg());
		this.hashColumns.put("stop_cargo", getStopCargo());
		this.hashColumns.put("eq_por_cd", getEqPorCd());
		this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
		this.hashColumns.put("caed_y", getCaedY());
		this.hashColumns.put("obl_iss_to_dt", getOblIssToDt());
		this.hashColumns.put("caed_n", getCaedN());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("bkg_rsn_spcl_cgo_flg", getBkgRsnSpclCgoFlg());
		this.hashColumns.put("vvd_pod_cd", getVvdPodCd());
		this.hashColumns.put("booking_por_cd", getBookingPorCd());
		this.hashColumns.put("revenue_r", getRevenueR());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("revenue_n", getRevenueN());
		this.hashColumns.put("hog_de_flg", getHogDeFlg());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("eq_del_cd", getEqDelCd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
		this.hashColumns.put("obl_iss_date", getOblIssDate());
		this.hashColumns.put("vvd_post_pod", getVvdPostPod());
		this.hashColumns.put("desc_sconti_cd", getDescScontiCd());
		this.hashColumns.put("org_svc_mod_cd", getOrgSvcModCd());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
		this.hashColumns.put("sc_rfa_chk", getScRfaChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rail_blk_cd", getRailBlkCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cust_tp_cd_s", getCustTpCdS());
		this.hashColumns.put("revenue", getRevenue());
		this.hashColumns.put("cust_tp_cd_n", getCustTpCdN());
		this.hashColumns.put("vvd_pod_local", getVvdPodLocal());
		this.hashColumns.put("vvd_post_vvd", getVvdPostVvd());
		this.hashColumns.put("cust_tp_cd_f", getCustTpCdF());
		this.hashColumns.put("cust_tp_cd_g", getCustTpCdG());
		this.hashColumns.put("vvd_pol_ts", getVvdPolTs());
		this.hashColumns.put("vvd_pre_vvd", getVvdPreVvd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("aes_itn_n", getAesItnN());
		this.hashColumns.put("cust_tp_cd_c", getCustTpCdC());
		this.hashColumns.put("twn_so_no", getTwnSoNo());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("vvd_pol_cd", getVvdPolCd());
		this.hashColumns.put("cust_tp_cd_a", getCustTpCdA());
		this.hashColumns.put("vvd_pod_ts", getVvdPodTs());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("bkg_cgo_tp_cd_r", getBkgCgoTpCdR());
		this.hashColumns.put("booking_de_term_cd", getBookingDeTermCd());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("bkg_cgo_tp_cd_p", getBkgCgoTpCdP());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("desc_inlnd_svc_mod_cd", "descInlndSvcModCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("booking_pol_cd", "bookingPolCd");
		this.hashFields.put("adv_shtg_cd_s", "advShtgCdS");
		this.hashFields.put("bkg_cgo_tp_cd_f", "bkgCgoTpCdF");
		this.hashFields.put("vvd_pre_pol", "vvdPrePol");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("adv_shtg_cd_a", "advShtgCdA");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("doc_usr_cd", "docUsrCd");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("obl_iss_from_dt", "oblIssFromDt");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("query_sort", "querySort");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("shpr_ownr_cntr_flg", "shprOwnrCntrFlg");
		this.hashFields.put("aes_itn_y", "aesItnY");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_sts_cd_w", "bkgStsCdW");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("vvd_pol_local", "vvdPolLocal");
		this.hashFields.put("org_sconti_cd", "orgScontiCd");
		this.hashFields.put("booking_rcv_term_cd", "bookingRcvTermCd");
		this.hashFields.put("booking_del_cd", "bookingDelCd");
		this.hashFields.put("bkg_sts_cd_f", "bkgStsCdF");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("master_bl_no", "masterBlNo");
		this.hashFields.put("master_bkg_no", "masterBkgNo");
		this.hashFields.put("booking_pod_cd", "bookingPodCd");
		this.hashFields.put("wt_rsn_hld_flg", "wtRsnHldFlg");
		this.hashFields.put("stop_cargo", "stopCargo");
		this.hashFields.put("eq_por_cd", "eqPorCd");
		this.hashFields.put("spcl_hide_flg", "spclHideFlg");
		this.hashFields.put("caed_y", "caedY");
		this.hashFields.put("obl_iss_to_dt", "oblIssToDt");
		this.hashFields.put("caed_n", "caedN");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("bkg_rsn_spcl_cgo_flg", "bkgRsnSpclCgoFlg");
		this.hashFields.put("vvd_pod_cd", "vvdPodCd");
		this.hashFields.put("booking_por_cd", "bookingPorCd");
		this.hashFields.put("revenue_r", "revenueR");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("revenue_n", "revenueN");
		this.hashFields.put("hog_de_flg", "hogDeFlg");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("eq_del_cd", "eqDelCd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("fd_grd_flg", "fdGrdFlg");
		this.hashFields.put("obl_iss_date", "oblIssDate");
		this.hashFields.put("vvd_post_pod", "vvdPostPod");
		this.hashFields.put("desc_sconti_cd", "descScontiCd");
		this.hashFields.put("org_svc_mod_cd", "orgSvcModCd");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("eq_subst_flg", "eqSubstFlg");
		this.hashFields.put("sc_rfa_chk", "scRfaChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rail_blk_cd", "railBlkCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("cust_tp_cd_s", "custTpCdS");
		this.hashFields.put("revenue", "revenue");
		this.hashFields.put("cust_tp_cd_n", "custTpCdN");
		this.hashFields.put("vvd_pod_local", "vvdPodLocal");
		this.hashFields.put("vvd_post_vvd", "vvdPostVvd");
		this.hashFields.put("cust_tp_cd_f", "custTpCdF");
		this.hashFields.put("cust_tp_cd_g", "custTpCdG");
		this.hashFields.put("vvd_pol_ts", "vvdPolTs");
		this.hashFields.put("vvd_pre_vvd", "vvdPreVvd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("aes_itn_n", "aesItnN");
		this.hashFields.put("cust_tp_cd_c", "custTpCdC");
		this.hashFields.put("twn_so_no", "twnSoNo");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("vvd_pol_cd", "vvdPolCd");
		this.hashFields.put("cust_tp_cd_a", "custTpCdA");
		this.hashFields.put("vvd_pod_ts", "vvdPodTs");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("bkg_cgo_tp_cd_r", "bkgCgoTpCdR");
		this.hashFields.put("booking_de_term_cd", "bookingDeTermCd");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("bkg_cgo_tp_cd_p", "bkgCgoTpCdP");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return descInlndSvcModCd
	 */
	public String getDescInlndSvcModCd() {
		return this.descInlndSvcModCd;
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
	 * @return bookingPolCd
	 */
	public String getBookingPolCd() {
		return this.bookingPolCd;
	}
	
	/**
	 * Column Info
	 * @return advShtgCdS
	 */
	public String getAdvShtgCdS() {
		return this.advShtgCdS;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCdF
	 */
	public String getBkgCgoTpCdF() {
		return this.bkgCgoTpCdF;
	}
	
	/**
	 * Column Info
	 * @return vvdPrePol
	 */
	public String getVvdPrePol() {
		return this.vvdPrePol;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return advShtgCdA
	 */
	public String getAdvShtgCdA() {
		return this.advShtgCdA;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return docUsrCd
	 */
	public String getDocUsrCd() {
		return this.docUsrCd;
	}
	
	/**
	 * Column Info
	 * @return prctFlg
	 */
	public String getPrctFlg() {
		return this.prctFlg;
	}
	
	/**
	 * Column Info
	 * @return oblIssFromDt
	 */
	public String getOblIssFromDt() {
		return this.oblIssFromDt;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return querySort
	 */
	public String getQuerySort() {
		return this.querySort;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return shprOwnrCntrFlg
	 */
	public String getShprOwnrCntrFlg() {
		return this.shprOwnrCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return aesItnY
	 */
	public String getAesItnY() {
		return this.aesItnY;
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
	 * @return bkgStsCdW
	 */
	public String getBkgStsCdW() {
		return this.bkgStsCdW;
	}
	
	/**
	 * Column Info
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdPolLocal
	 */
	public String getVvdPolLocal() {
		return this.vvdPolLocal;
	}
	
	/**
	 * Column Info
	 * @return orgScontiCd
	 */
	public String getOrgScontiCd() {
		return this.orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @return bookingRcvTermCd
	 */
	public String getBookingRcvTermCd() {
		return this.bookingRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bookingDelCd
	 */
	public String getBookingDelCd() {
		return this.bookingDelCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCdF
	 */
	public String getBkgStsCdF() {
		return this.bkgStsCdF;
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
	 * @return masterBlNo
	 */
	public String getMasterBlNo() {
		return this.masterBlNo;
	}
	
	/**
	 * Column Info
	 * @return masterBkgNo
	 */
	public String getMasterBkgNo() {
		return this.masterBkgNo;
	}
	
	/**
	 * Column Info
	 * @return bookingPodCd
	 */
	public String getBookingPodCd() {
		return this.bookingPodCd;
	}
	
	/**
	 * Column Info
	 * @return wtRsnHldFlg
	 */
	public String getWtRsnHldFlg() {
		return this.wtRsnHldFlg;
	}
	
	/**
	 * Column Info
	 * @return stopCargo
	 */
	public String getStopCargo() {
		return this.stopCargo;
	}
	
	/**
	 * Column Info
	 * @return eqPorCd
	 */
	public String getEqPorCd() {
		return this.eqPorCd;
	}
	
	/**
	 * Column Info
	 * @return spclHideFlg
	 */
	public String getSpclHideFlg() {
		return this.spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @return caedY
	 */
	public String getCaedY() {
		return this.caedY;
	}
	
	/**
	 * Column Info
	 * @return oblIssToDt
	 */
	public String getOblIssToDt() {
		return this.oblIssToDt;
	}
	
	/**
	 * Column Info
	 * @return caedN
	 */
	public String getCaedN() {
		return this.caedN;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgRsnSpclCgoFlg
	 */
	public String getBkgRsnSpclCgoFlg() {
		return this.bkgRsnSpclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdPodCd
	 */
	public String getVvdPodCd() {
		return this.vvdPodCd;
	}
	
	/**
	 * Column Info
	 * @return bookingPorCd
	 */
	public String getBookingPorCd() {
		return this.bookingPorCd;
	}
	
	/**
	 * Column Info
	 * @return revenueR
	 */
	public String getRevenueR() {
		return this.revenueR;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return revenueN
	 */
	public String getRevenueN() {
		return this.revenueN;
	}
	
	/**
	 * Column Info
	 * @return hogDeFlg
	 */
	public String getHogDeFlg() {
		return this.hogDeFlg;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqDelCd
	 */
	public String getEqDelCd() {
		return this.eqDelCd;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fdGrdFlg
	 */
	public String getFdGrdFlg() {
		return this.fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @return oblIssDate
	 */
	public String getOblIssDate() {
		return this.oblIssDate;
	}
	
	/**
	 * Column Info
	 * @return vvdPostPod
	 */
	public String getVvdPostPod() {
		return this.vvdPostPod;
	}
	
	/**
	 * Column Info
	 * @return descScontiCd
	 */
	public String getDescScontiCd() {
		return this.descScontiCd;
	}
	
	/**
	 * Column Info
	 * @return orgSvcModCd
	 */
	public String getOrgSvcModCd() {
		return this.orgSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return advShtgCd
	 */
	public String getAdvShtgCd() {
		return this.advShtgCd;
	}
	
	/**
	 * Column Info
	 * @return eqSubstFlg
	 */
	public String getEqSubstFlg() {
		return this.eqSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return scRfaChk
	 */
	public String getScRfaChk() {
		return this.scRfaChk;
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
	 * @return railBlkCd
	 */
	public String getRailBlkCd() {
		return this.railBlkCd;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdS
	 */
	public String getCustTpCdS() {
		return this.custTpCdS;
	}
	
	/**
	 * Column Info
	 * @return revenue
	 */
	public String getRevenue() {
		return this.revenue;
	}
	
	/**
	 * Column Info
	 * @return custTpCdN
	 */
	public String getCustTpCdN() {
		return this.custTpCdN;
	}
	
	/**
	 * Column Info
	 * @return vvdPodLocal
	 */
	public String getVvdPodLocal() {
		return this.vvdPodLocal;
	}
	
	/**
	 * Column Info
	 * @return vvdPostVvd
	 */
	public String getVvdPostVvd() {
		return this.vvdPostVvd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdF
	 */
	public String getCustTpCdF() {
		return this.custTpCdF;
	}
	
	/**
	 * Column Info
	 * @return custTpCdG
	 */
	public String getCustTpCdG() {
		return this.custTpCdG;
	}
	
	/**
	 * Column Info
	 * @return vvdPolTs
	 */
	public String getVvdPolTs() {
		return this.vvdPolTs;
	}
	
	/**
	 * Column Info
	 * @return vvdPreVvd
	 */
	public String getVvdPreVvd() {
		return this.vvdPreVvd;
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
	 * @return aesItnN
	 */
	public String getAesItnN() {
		return this.aesItnN;
	}
	
	/**
	 * Column Info
	 * @return custTpCdC
	 */
	public String getCustTpCdC() {
		return this.custTpCdC;
	}
	
	/**
	 * Column Info
	 * @return twnSoNo
	 */
	public String getTwnSoNo() {
		return this.twnSoNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return vvdPolCd
	 */
	public String getVvdPolCd() {
		return this.vvdPolCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdA
	 */
	public String getCustTpCdA() {
		return this.custTpCdA;
	}
	
	/**
	 * Column Info
	 * @return vvdPodTs
	 */
	public String getVvdPodTs() {
		return this.vvdPodTs;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCdR
	 */
	public String getBkgCgoTpCdR() {
		return this.bkgCgoTpCdR;
	}
	
	/**
	 * Column Info
	 * @return bookingDeTermCd
	 */
	public String getBookingDeTermCd() {
		return this.bookingDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCdP
	 */
	public String getBkgCgoTpCdP() {
		return this.bkgCgoTpCdP;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	

	/**
	 * Column Info
	 * @param descInlndSvcModCd
	 */
	public void setDescInlndSvcModCd(String descInlndSvcModCd) {
		this.descInlndSvcModCd = descInlndSvcModCd;
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
	 * @param bookingPolCd
	 */
	public void setBookingPolCd(String bookingPolCd) {
		this.bookingPolCd = bookingPolCd;
	}
	
	/**
	 * Column Info
	 * @param advShtgCdS
	 */
	public void setAdvShtgCdS(String advShtgCdS) {
		this.advShtgCdS = advShtgCdS;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCdF
	 */
	public void setBkgCgoTpCdF(String bkgCgoTpCdF) {
		this.bkgCgoTpCdF = bkgCgoTpCdF;
	}
	
	/**
	 * Column Info
	 * @param vvdPrePol
	 */
	public void setVvdPrePol(String vvdPrePol) {
		this.vvdPrePol = vvdPrePol;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param advShtgCdA
	 */
	public void setAdvShtgCdA(String advShtgCdA) {
		this.advShtgCdA = advShtgCdA;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param docUsrCd
	 */
	public void setDocUsrCd(String docUsrCd) {
		this.docUsrCd = docUsrCd;
	}
	
	/**
	 * Column Info
	 * @param prctFlg
	 */
	public void setPrctFlg(String prctFlg) {
		this.prctFlg = prctFlg;
	}
	
	/**
	 * Column Info
	 * @param oblIssFromDt
	 */
	public void setOblIssFromDt(String oblIssFromDt) {
		this.oblIssFromDt = oblIssFromDt;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param querySort
	 */
	public void setQuerySort(String querySort) {
		this.querySort = querySort;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param shprOwnrCntrFlg
	 */
	public void setShprOwnrCntrFlg(String shprOwnrCntrFlg) {
		this.shprOwnrCntrFlg = shprOwnrCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param aesItnY
	 */
	public void setAesItnY(String aesItnY) {
		this.aesItnY = aesItnY;
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
	 * @param bkgStsCdW
	 */
	public void setBkgStsCdW(String bkgStsCdW) {
		this.bkgStsCdW = bkgStsCdW;
	}
	
	/**
	 * Column Info
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdPolLocal
	 */
	public void setVvdPolLocal(String vvdPolLocal) {
		this.vvdPolLocal = vvdPolLocal;
	}
	
	/**
	 * Column Info
	 * @param orgScontiCd
	 */
	public void setOrgScontiCd(String orgScontiCd) {
		this.orgScontiCd = orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @param bookingRcvTermCd
	 */
	public void setBookingRcvTermCd(String bookingRcvTermCd) {
		this.bookingRcvTermCd = bookingRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bookingDelCd
	 */
	public void setBookingDelCd(String bookingDelCd) {
		this.bookingDelCd = bookingDelCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCdF
	 */
	public void setBkgStsCdF(String bkgStsCdF) {
		this.bkgStsCdF = bkgStsCdF;
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
	 * @param masterBlNo
	 */
	public void setMasterBlNo(String masterBlNo) {
		this.masterBlNo = masterBlNo;
	}
	
	/**
	 * Column Info
	 * @param masterBkgNo
	 */
	public void setMasterBkgNo(String masterBkgNo) {
		this.masterBkgNo = masterBkgNo;
	}
	
	/**
	 * Column Info
	 * @param bookingPodCd
	 */
	public void setBookingPodCd(String bookingPodCd) {
		this.bookingPodCd = bookingPodCd;
	}
	
	/**
	 * Column Info
	 * @param wtRsnHldFlg
	 */
	public void setWtRsnHldFlg(String wtRsnHldFlg) {
		this.wtRsnHldFlg = wtRsnHldFlg;
	}
	
	/**
	 * Column Info
	 * @param stopCargo
	 */
	public void setStopCargo(String stopCargo) {
		this.stopCargo = stopCargo;
	}
	
	/**
	 * Column Info
	 * @param eqPorCd
	 */
	public void setEqPorCd(String eqPorCd) {
		this.eqPorCd = eqPorCd;
	}
	
	/**
	 * Column Info
	 * @param spclHideFlg
	 */
	public void setSpclHideFlg(String spclHideFlg) {
		this.spclHideFlg = spclHideFlg;
	}
	
	/**
	 * Column Info
	 * @param caedY
	 */
	public void setCaedY(String caedY) {
		this.caedY = caedY;
	}
	
	/**
	 * Column Info
	 * @param oblIssToDt
	 */
	public void setOblIssToDt(String oblIssToDt) {
		this.oblIssToDt = oblIssToDt;
	}
	
	/**
	 * Column Info
	 * @param caedN
	 */
	public void setCaedN(String caedN) {
		this.caedN = caedN;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgRsnSpclCgoFlg
	 */
	public void setBkgRsnSpclCgoFlg(String bkgRsnSpclCgoFlg) {
		this.bkgRsnSpclCgoFlg = bkgRsnSpclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdPodCd
	 */
	public void setVvdPodCd(String vvdPodCd) {
		this.vvdPodCd = vvdPodCd;
	}
	
	/**
	 * Column Info
	 * @param bookingPorCd
	 */
	public void setBookingPorCd(String bookingPorCd) {
		this.bookingPorCd = bookingPorCd;
	}
	
	/**
	 * Column Info
	 * @param revenueR
	 */
	public void setRevenueR(String revenueR) {
		this.revenueR = revenueR;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param revenueN
	 */
	public void setRevenueN(String revenueN) {
		this.revenueN = revenueN;
	}
	
	/**
	 * Column Info
	 * @param hogDeFlg
	 */
	public void setHogDeFlg(String hogDeFlg) {
		this.hogDeFlg = hogDeFlg;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqDelCd
	 */
	public void setEqDelCd(String eqDelCd) {
		this.eqDelCd = eqDelCd;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fdGrdFlg
	 */
	public void setFdGrdFlg(String fdGrdFlg) {
		this.fdGrdFlg = fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @param oblIssDate
	 */
	public void setOblIssDate(String oblIssDate) {
		this.oblIssDate = oblIssDate;
	}
	
	/**
	 * Column Info
	 * @param vvdPostPod
	 */
	public void setVvdPostPod(String vvdPostPod) {
		this.vvdPostPod = vvdPostPod;
	}
	
	/**
	 * Column Info
	 * @param descScontiCd
	 */
	public void setDescScontiCd(String descScontiCd) {
		this.descScontiCd = descScontiCd;
	}
	
	/**
	 * Column Info
	 * @param orgSvcModCd
	 */
	public void setOrgSvcModCd(String orgSvcModCd) {
		this.orgSvcModCd = orgSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param advShtgCd
	 */
	public void setAdvShtgCd(String advShtgCd) {
		this.advShtgCd = advShtgCd;
	}
	
	/**
	 * Column Info
	 * @param eqSubstFlg
	 */
	public void setEqSubstFlg(String eqSubstFlg) {
		this.eqSubstFlg = eqSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param scRfaChk
	 */
	public void setScRfaChk(String scRfaChk) {
		this.scRfaChk = scRfaChk;
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
	 * @param railBlkCd
	 */
	public void setRailBlkCd(String railBlkCd) {
		this.railBlkCd = railBlkCd;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdS
	 */
	public void setCustTpCdS(String custTpCdS) {
		this.custTpCdS = custTpCdS;
	}
	
	/**
	 * Column Info
	 * @param revenue
	 */
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	
	/**
	 * Column Info
	 * @param custTpCdN
	 */
	public void setCustTpCdN(String custTpCdN) {
		this.custTpCdN = custTpCdN;
	}
	
	/**
	 * Column Info
	 * @param vvdPodLocal
	 */
	public void setVvdPodLocal(String vvdPodLocal) {
		this.vvdPodLocal = vvdPodLocal;
	}
	
	/**
	 * Column Info
	 * @param vvdPostVvd
	 */
	public void setVvdPostVvd(String vvdPostVvd) {
		this.vvdPostVvd = vvdPostVvd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdF
	 */
	public void setCustTpCdF(String custTpCdF) {
		this.custTpCdF = custTpCdF;
	}
	
	/**
	 * Column Info
	 * @param custTpCdG
	 */
	public void setCustTpCdG(String custTpCdG) {
		this.custTpCdG = custTpCdG;
	}
	
	/**
	 * Column Info
	 * @param vvdPolTs
	 */
	public void setVvdPolTs(String vvdPolTs) {
		this.vvdPolTs = vvdPolTs;
	}
	
	/**
	 * Column Info
	 * @param vvdPreVvd
	 */
	public void setVvdPreVvd(String vvdPreVvd) {
		this.vvdPreVvd = vvdPreVvd;
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
	 * @param aesItnN
	 */
	public void setAesItnN(String aesItnN) {
		this.aesItnN = aesItnN;
	}
	
	/**
	 * Column Info
	 * @param custTpCdC
	 */
	public void setCustTpCdC(String custTpCdC) {
		this.custTpCdC = custTpCdC;
	}
	
	/**
	 * Column Info
	 * @param twnSoNo
	 */
	public void setTwnSoNo(String twnSoNo) {
		this.twnSoNo = twnSoNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param vvdPolCd
	 */
	public void setVvdPolCd(String vvdPolCd) {
		this.vvdPolCd = vvdPolCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdA
	 */
	public void setCustTpCdA(String custTpCdA) {
		this.custTpCdA = custTpCdA;
	}
	
	/**
	 * Column Info
	 * @param vvdPodTs
	 */
	public void setVvdPodTs(String vvdPodTs) {
		this.vvdPodTs = vvdPodTs;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCdR
	 */
	public void setBkgCgoTpCdR(String bkgCgoTpCdR) {
		this.bkgCgoTpCdR = bkgCgoTpCdR;
	}
	
	/**
	 * Column Info
	 * @param bookingDeTermCd
	 */
	public void setBookingDeTermCd(String bookingDeTermCd) {
		this.bookingDeTermCd = bookingDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCdP
	 */
	public void setBkgCgoTpCdP(String bkgCgoTpCdP) {
		this.bkgCgoTpCdP = bkgCgoTpCdP;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
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
		setDescInlndSvcModCd(JSPUtil.getParameter(request, prefix + "desc_inlnd_svc_mod_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setBookingPolCd(JSPUtil.getParameter(request, prefix + "booking_pol_cd", ""));
		setAdvShtgCdS(JSPUtil.getParameter(request, prefix + "adv_shtg_cd_s", ""));
		setBkgCgoTpCdF(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd_f", ""));
		setVvdPrePol(JSPUtil.getParameter(request, prefix + "vvd_pre_pol", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setAdvShtgCdA(JSPUtil.getParameter(request, prefix + "adv_shtg_cd_a", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, prefix + "obl_iss_usr_id", ""));
		setDocUsrCd(JSPUtil.getParameter(request, prefix + "doc_usr_cd", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setOblIssFromDt(JSPUtil.getParameter(request, prefix + "obl_iss_from_dt", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setQuerySort(JSPUtil.getParameter(request, prefix + "query_sort", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setShprOwnrCntrFlg(JSPUtil.getParameter(request, prefix + "shpr_ownr_cntr_flg", ""));
		setAesItnY(JSPUtil.getParameter(request, prefix + "aes_itn_y", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgStsCdW(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_w", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setVvdPolLocal(JSPUtil.getParameter(request, prefix + "vvd_pol_local", ""));
		setOrgScontiCd(JSPUtil.getParameter(request, prefix + "org_sconti_cd", ""));
		setBookingRcvTermCd(JSPUtil.getParameter(request, prefix + "booking_rcv_term_cd", ""));
		setBookingDelCd(JSPUtil.getParameter(request, prefix + "booking_del_cd", ""));
		setBkgStsCdF(JSPUtil.getParameter(request, prefix + "bkg_sts_cd_f", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setMasterBlNo(JSPUtil.getParameter(request, prefix + "master_bl_no", ""));
		setMasterBkgNo(JSPUtil.getParameter(request, prefix + "master_bkg_no", ""));
		setBookingPodCd(JSPUtil.getParameter(request, prefix + "booking_pod_cd", ""));
		setWtRsnHldFlg(JSPUtil.getParameter(request, prefix + "wt_rsn_hld_flg", ""));
		setStopCargo(JSPUtil.getParameter(request, prefix + "stop_cargo", ""));
		setEqPorCd(JSPUtil.getParameter(request, prefix + "eq_por_cd", ""));
		setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
		setCaedY(JSPUtil.getParameter(request, prefix + "caed_y", ""));
		setOblIssToDt(JSPUtil.getParameter(request, prefix + "obl_iss_to_dt", ""));
		setCaedN(JSPUtil.getParameter(request, prefix + "caed_n", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setBkgRsnSpclCgoFlg(JSPUtil.getParameter(request, prefix + "bkg_rsn_spcl_cgo_flg", ""));
		setVvdPodCd(JSPUtil.getParameter(request, prefix + "vvd_pod_cd", ""));
		setBookingPorCd(JSPUtil.getParameter(request, prefix + "booking_por_cd", ""));
		setRevenueR(JSPUtil.getParameter(request, prefix + "revenue_r", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setRevenueN(JSPUtil.getParameter(request, prefix + "revenue_n", ""));
		setHogDeFlg(JSPUtil.getParameter(request, prefix + "hog_de_flg", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setEqDelCd(JSPUtil.getParameter(request, prefix + "eq_del_cd", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
		setOblIssDate(JSPUtil.getParameter(request, prefix + "obl_iss_date", ""));
		setVvdPostPod(JSPUtil.getParameter(request, prefix + "vvd_post_pod", ""));
		setDescScontiCd(JSPUtil.getParameter(request, prefix + "desc_sconti_cd", ""));
		setOrgSvcModCd(JSPUtil.getParameter(request, prefix + "org_svc_mod_cd", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, prefix + "adv_shtg_cd", ""));
		setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
		setScRfaChk(JSPUtil.getParameter(request, prefix + "sc_rfa_chk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRailBlkCd(JSPUtil.getParameter(request, prefix + "rail_blk_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setCustTpCdS(JSPUtil.getParameter(request, prefix + "cust_tp_cd_s", ""));
		setRevenue(JSPUtil.getParameter(request, prefix + "revenue", ""));
		setCustTpCdN(JSPUtil.getParameter(request, prefix + "cust_tp_cd_n", ""));
		setVvdPodLocal(JSPUtil.getParameter(request, prefix + "vvd_pod_local", ""));
		setVvdPostVvd(JSPUtil.getParameter(request, prefix + "vvd_post_vvd", ""));
		setCustTpCdF(JSPUtil.getParameter(request, prefix + "cust_tp_cd_f", ""));
		setCustTpCdG(JSPUtil.getParameter(request, prefix + "cust_tp_cd_g", ""));
		setVvdPolTs(JSPUtil.getParameter(request, prefix + "vvd_pol_ts", ""));
		setVvdPreVvd(JSPUtil.getParameter(request, prefix + "vvd_pre_vvd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setAesItnN(JSPUtil.getParameter(request, prefix + "aes_itn_n", ""));
		setCustTpCdC(JSPUtil.getParameter(request, prefix + "cust_tp_cd_c", ""));
		setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setVvdPolCd(JSPUtil.getParameter(request, prefix + "vvd_pol_cd", ""));
		setCustTpCdA(JSPUtil.getParameter(request, prefix + "cust_tp_cd_a", ""));
		setVvdPodTs(JSPUtil.getParameter(request, prefix + "vvd_pod_ts", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setBkgCgoTpCdR(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd_r", ""));
		setBookingDeTermCd(JSPUtil.getParameter(request, prefix + "booking_de_term_cd", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setBkgCgoTpCdP(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd_p", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrpBlPrtInVO[]
	 */
	public GrpBlPrtInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GrpBlPrtInVO[]
	 */
	public GrpBlPrtInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrpBlPrtInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] descInlndSvcModCd = (JSPUtil.getParameter(request, prefix	+ "desc_inlnd_svc_mod_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bookingPolCd = (JSPUtil.getParameter(request, prefix	+ "booking_pol_cd", length));
			String[] advShtgCdS = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd_s", length));
			String[] bkgCgoTpCdF = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd_f", length));
			String[] vvdPrePol = (JSPUtil.getParameter(request, prefix	+ "vvd_pre_pol", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] advShtgCdA = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd_a", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] docUsrCd = (JSPUtil.getParameter(request, prefix	+ "doc_usr_cd", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] oblIssFromDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_from_dt", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] querySort = (JSPUtil.getParameter(request, prefix	+ "query_sort", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] shprOwnrCntrFlg = (JSPUtil.getParameter(request, prefix	+ "shpr_ownr_cntr_flg", length));
			String[] aesItnY = (JSPUtil.getParameter(request, prefix	+ "aes_itn_y", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgStsCdW = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_w", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] vvdPolLocal = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_local", length));
			String[] orgScontiCd = (JSPUtil.getParameter(request, prefix	+ "org_sconti_cd", length));
			String[] bookingRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "booking_rcv_term_cd", length));
			String[] bookingDelCd = (JSPUtil.getParameter(request, prefix	+ "booking_del_cd", length));
			String[] bkgStsCdF = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd_f", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] masterBlNo = (JSPUtil.getParameter(request, prefix	+ "master_bl_no", length));
			String[] masterBkgNo = (JSPUtil.getParameter(request, prefix	+ "master_bkg_no", length));
			String[] bookingPodCd = (JSPUtil.getParameter(request, prefix	+ "booking_pod_cd", length));
			String[] wtRsnHldFlg = (JSPUtil.getParameter(request, prefix	+ "wt_rsn_hld_flg", length));
			String[] stopCargo = (JSPUtil.getParameter(request, prefix	+ "stop_cargo", length));
			String[] eqPorCd = (JSPUtil.getParameter(request, prefix	+ "eq_por_cd", length));
			String[] spclHideFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_flg", length));
			String[] caedY = (JSPUtil.getParameter(request, prefix	+ "caed_y", length));
			String[] oblIssToDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_to_dt", length));
			String[] caedN = (JSPUtil.getParameter(request, prefix	+ "caed_n", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] bkgRsnSpclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_rsn_spcl_cgo_flg", length));
			String[] vvdPodCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_cd", length));
			String[] bookingPorCd = (JSPUtil.getParameter(request, prefix	+ "booking_por_cd", length));
			String[] revenueR = (JSPUtil.getParameter(request, prefix	+ "revenue_r", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] revenueN = (JSPUtil.getParameter(request, prefix	+ "revenue_n", length));
			String[] hogDeFlg = (JSPUtil.getParameter(request, prefix	+ "hog_de_flg", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] eqDelCd = (JSPUtil.getParameter(request, prefix	+ "eq_del_cd", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_flg", length));
			String[] oblIssDate = (JSPUtil.getParameter(request, prefix	+ "obl_iss_date", length));
			String[] vvdPostPod = (JSPUtil.getParameter(request, prefix	+ "vvd_post_pod", length));
			String[] descScontiCd = (JSPUtil.getParameter(request, prefix	+ "desc_sconti_cd", length));
			String[] orgSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_svc_mod_cd", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix	+ "eq_subst_flg", length));
			String[] scRfaChk = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] railBlkCd = (JSPUtil.getParameter(request, prefix	+ "rail_blk_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] custTpCdS = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_s", length));
			String[] revenue = (JSPUtil.getParameter(request, prefix	+ "revenue", length));
			String[] custTpCdN = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_n", length));
			String[] vvdPodLocal = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_local", length));
			String[] vvdPostVvd = (JSPUtil.getParameter(request, prefix	+ "vvd_post_vvd", length));
			String[] custTpCdF = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_f", length));
			String[] custTpCdG = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_g", length));
			String[] vvdPolTs = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_ts", length));
			String[] vvdPreVvd = (JSPUtil.getParameter(request, prefix	+ "vvd_pre_vvd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] aesItnN = (JSPUtil.getParameter(request, prefix	+ "aes_itn_n", length));
			String[] custTpCdC = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_c", length));
			String[] twnSoNo = (JSPUtil.getParameter(request, prefix	+ "twn_so_no", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] vvdPolCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_cd", length));
			String[] custTpCdA = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_a", length));
			String[] vvdPodTs = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_ts", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] bkgCgoTpCdR = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd_r", length));
			String[] bookingDeTermCd = (JSPUtil.getParameter(request, prefix	+ "booking_de_term_cd", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] bkgCgoTpCdP = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd_p", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlPrtInVO();
				if (descInlndSvcModCd[i] != null)
					model.setDescInlndSvcModCd(descInlndSvcModCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bookingPolCd[i] != null)
					model.setBookingPolCd(bookingPolCd[i]);
				if (advShtgCdS[i] != null)
					model.setAdvShtgCdS(advShtgCdS[i]);
				if (bkgCgoTpCdF[i] != null)
					model.setBkgCgoTpCdF(bkgCgoTpCdF[i]);
				if (vvdPrePol[i] != null)
					model.setVvdPrePol(vvdPrePol[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (advShtgCdA[i] != null)
					model.setAdvShtgCdA(advShtgCdA[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (docUsrCd[i] != null)
					model.setDocUsrCd(docUsrCd[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (oblIssFromDt[i] != null)
					model.setOblIssFromDt(oblIssFromDt[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (querySort[i] != null)
					model.setQuerySort(querySort[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (shprOwnrCntrFlg[i] != null)
					model.setShprOwnrCntrFlg(shprOwnrCntrFlg[i]);
				if (aesItnY[i] != null)
					model.setAesItnY(aesItnY[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgStsCdW[i] != null)
					model.setBkgStsCdW(bkgStsCdW[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (vvdPolLocal[i] != null)
					model.setVvdPolLocal(vvdPolLocal[i]);
				if (orgScontiCd[i] != null)
					model.setOrgScontiCd(orgScontiCd[i]);
				if (bookingRcvTermCd[i] != null)
					model.setBookingRcvTermCd(bookingRcvTermCd[i]);
				if (bookingDelCd[i] != null)
					model.setBookingDelCd(bookingDelCd[i]);
				if (bkgStsCdF[i] != null)
					model.setBkgStsCdF(bkgStsCdF[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (masterBlNo[i] != null)
					model.setMasterBlNo(masterBlNo[i]);
				if (masterBkgNo[i] != null)
					model.setMasterBkgNo(masterBkgNo[i]);
				if (bookingPodCd[i] != null)
					model.setBookingPodCd(bookingPodCd[i]);
				if (wtRsnHldFlg[i] != null)
					model.setWtRsnHldFlg(wtRsnHldFlg[i]);
				if (stopCargo[i] != null)
					model.setStopCargo(stopCargo[i]);
				if (eqPorCd[i] != null)
					model.setEqPorCd(eqPorCd[i]);
				if (spclHideFlg[i] != null)
					model.setSpclHideFlg(spclHideFlg[i]);
				if (caedY[i] != null)
					model.setCaedY(caedY[i]);
				if (oblIssToDt[i] != null)
					model.setOblIssToDt(oblIssToDt[i]);
				if (caedN[i] != null)
					model.setCaedN(caedN[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (bkgRsnSpclCgoFlg[i] != null)
					model.setBkgRsnSpclCgoFlg(bkgRsnSpclCgoFlg[i]);
				if (vvdPodCd[i] != null)
					model.setVvdPodCd(vvdPodCd[i]);
				if (bookingPorCd[i] != null)
					model.setBookingPorCd(bookingPorCd[i]);
				if (revenueR[i] != null)
					model.setRevenueR(revenueR[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (revenueN[i] != null)
					model.setRevenueN(revenueN[i]);
				if (hogDeFlg[i] != null)
					model.setHogDeFlg(hogDeFlg[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (eqDelCd[i] != null)
					model.setEqDelCd(eqDelCd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (fdGrdFlg[i] != null)
					model.setFdGrdFlg(fdGrdFlg[i]);
				if (oblIssDate[i] != null)
					model.setOblIssDate(oblIssDate[i]);
				if (vvdPostPod[i] != null)
					model.setVvdPostPod(vvdPostPod[i]);
				if (descScontiCd[i] != null)
					model.setDescScontiCd(descScontiCd[i]);
				if (orgSvcModCd[i] != null)
					model.setOrgSvcModCd(orgSvcModCd[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (eqSubstFlg[i] != null)
					model.setEqSubstFlg(eqSubstFlg[i]);
				if (scRfaChk[i] != null)
					model.setScRfaChk(scRfaChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (railBlkCd[i] != null)
					model.setRailBlkCd(railBlkCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (custTpCdS[i] != null)
					model.setCustTpCdS(custTpCdS[i]);
				if (revenue[i] != null)
					model.setRevenue(revenue[i]);
				if (custTpCdN[i] != null)
					model.setCustTpCdN(custTpCdN[i]);
				if (vvdPodLocal[i] != null)
					model.setVvdPodLocal(vvdPodLocal[i]);
				if (vvdPostVvd[i] != null)
					model.setVvdPostVvd(vvdPostVvd[i]);
				if (custTpCdF[i] != null)
					model.setCustTpCdF(custTpCdF[i]);
				if (custTpCdG[i] != null)
					model.setCustTpCdG(custTpCdG[i]);
				if (vvdPolTs[i] != null)
					model.setVvdPolTs(vvdPolTs[i]);
				if (vvdPreVvd[i] != null)
					model.setVvdPreVvd(vvdPreVvd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (aesItnN[i] != null)
					model.setAesItnN(aesItnN[i]);
				if (custTpCdC[i] != null)
					model.setCustTpCdC(custTpCdC[i]);
				if (twnSoNo[i] != null)
					model.setTwnSoNo(twnSoNo[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (vvdPolCd[i] != null)
					model.setVvdPolCd(vvdPolCd[i]);
				if (custTpCdA[i] != null)
					model.setCustTpCdA(custTpCdA[i]);
				if (vvdPodTs[i] != null)
					model.setVvdPodTs(vvdPodTs[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (bkgCgoTpCdR[i] != null)
					model.setBkgCgoTpCdR(bkgCgoTpCdR[i]);
				if (bookingDeTermCd[i] != null)
					model.setBookingDeTermCd(bookingDeTermCd[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (bkgCgoTpCdP[i] != null)
					model.setBkgCgoTpCdP(bkgCgoTpCdP[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrpBlPrtInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrpBlPrtInVO[]
	 */
	public GrpBlPrtInVO[] getGrpBlPrtInVOs(){
		GrpBlPrtInVO[] vos = (GrpBlPrtInVO[])models.toArray(new GrpBlPrtInVO[models.size()]);
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
		this.descInlndSvcModCd = this.descInlndSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingPolCd = this.bookingPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCdS = this.advShtgCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCdF = this.bkgCgoTpCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPrePol = this.vvdPrePol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCdA = this.advShtgCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrCd = this.docUsrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFromDt = this.oblIssFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.querySort = this.querySort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprOwnrCntrFlg = this.shprOwnrCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesItnY = this.aesItnY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdW = this.bkgStsCdW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolLocal = this.vvdPolLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgScontiCd = this.orgScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingRcvTermCd = this.bookingRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingDelCd = this.bookingDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCdF = this.bkgStsCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterBlNo = this.masterBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterBkgNo = this.masterBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingPodCd = this.bookingPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtRsnHldFlg = this.wtRsnHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopCargo = this.stopCargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPorCd = this.eqPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideFlg = this.spclHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedY = this.caedY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssToDt = this.oblIssToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caedN = this.caedN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRsnSpclCgoFlg = this.bkgRsnSpclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodCd = this.vvdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingPorCd = this.bookingPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueR = this.revenueR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueN = this.revenueN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hogDeFlg = this.hogDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDelCd = this.eqDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdFlg = this.fdGrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDate = this.oblIssDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPostPod = this.vvdPostPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descScontiCd = this.descScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSvcModCd = this.orgSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstFlg = this.eqSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaChk = this.scRfaChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBlkCd = this.railBlkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdS = this.custTpCdS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenue = this.revenue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdN = this.custTpCdN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodLocal = this.vvdPodLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPostVvd = this.vvdPostVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdF = this.custTpCdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdG = this.custTpCdG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolTs = this.vvdPolTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPreVvd = this.vvdPreVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesItnN = this.aesItnN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdC = this.custTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnSoNo = this.twnSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolCd = this.vvdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdA = this.custTpCdA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodTs = this.vvdPodTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCdR = this.bkgCgoTpCdR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingDeTermCd = this.bookingDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCdP = this.bkgCgoTpCdP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
