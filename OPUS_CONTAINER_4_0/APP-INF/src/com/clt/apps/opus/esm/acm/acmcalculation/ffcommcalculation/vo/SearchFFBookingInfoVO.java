/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFFBookingInfoVO.java
*@FileTitle : SearchFFBookingInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.13
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFFBookingInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchFFBookingInfoVO> models = new ArrayList<SearchFFBookingInfoVO>();

	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String delApOfcCd = null;
	/* Column Info */
	private String ffChgAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String flg0507 = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String newFfCmpnSeq = null;
	/* Column Info */
	private String trunkEtdDt = null;
	/* Column Info */
	private String spclDgCgoFlg = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String dblBkgFlg = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String chgArOfcCd = null;
	/* Column Info */
	private String bkgOfcAgnCd = null;
	/* Column Info */
	private String polCntCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String spclBbCgoFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ppdOfcCdChgYn = null;
	/* Column Info */
	private String porFincCtrlOfcCd = null;
	/* Column Info */
	private String bkgFincCtrlOfcCd = null;
	/* Column Info */
	private String porContiCd = null;
	/* Column Info */
	private String bslDelApOfcCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String podScontiCd = null;
	/* Column Info */
	private String ffCmpnStsCd = null;
	/* Column Info */
	private String ffCalcAmt = null;
	/* Column Info */
	private String bkgSlsOfcCd = null;
	/* Column Info */
	private String shFfCheckFlag = null;
	/* Column Info */
	private String ffCustSeq = null;
	/* Column Info */
	private String bkgSvcScpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String spclAwkCgoFlg = null;
	/* Column Info */
	private String ffFeuQty = null;
	/* Column Info */
	private String bslDelOfcCd = null;
	/* Column Info */
	private String bslDelArOfcCd = null;
	/* Column Info */
	private String podContiCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String oldFfSeq = null;
	/* Column Info */
	private String facRtOfcCd = null;
	/* Column Info */
	private String porSteCd = null;
	/* Column Info */
	private String ffOfcCd = null;
	/* Column Info */
	private String shprCustSeq = null;
	/* Column Info */
	private String ffFmcCheckFlag = null;
	/* Column Info */
	private String ffCmpnRmk = null;
	/* Column Info */
	private String referenceNo = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String delRgnCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String ffCustSeqTmp = null;
	/* Column Info */
	private String podFincCtrlOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgOfcLocCd = null;
	/* Column Info */
	private String polSteCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delArOfcCd = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgFfCntCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String delScontiCd = null;
	/* Column Info */
	private String coveredCheck = null;
	/* Column Info */
	private String podRgnCd = null;
	/* Column Info */
	private String vndrCntSeq = null;
	/* Column Info */
	private String delSteCd = null;
	/* Column Info */
	private String polFincCtrlOfcCd = null;
	/* Column Info */
	private String chgApOfcCd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String oldSumIfAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String calAgnDivFlg = null;
	/* Column Info */
	private String ffDivCd1 = null;
	/* Column Info */
	private String podCntCd = null;
	/* Column Info */
	private String oldFfCntCd = null;
	/* Column Info */
	private String polContiCd = null;
	/* Column Info */
	private String porRgnCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String porScontiCd = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String chgPpdOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String spclRcFlg = null;
	/* Column Info */
	private String delFincCtrlOfcCd = null;
	/* Column Info */
	private String svcScpCheck = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podSteCd = null;
	/* Column Info */
	private String fmcNo = null;
	/* Column Info */
	private String ffTeuQty = null;
	/* Column Info */
	private String podApOfcCd = null;
	/* Column Info */
	private String porApOfcCd = null;
	/* Column Info */
	private String polRgnCd = null;
	/* Column Info */
	private String crntAmt = null;
	/* Column Info */
	private String porArOfcCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String ffCheck = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String agnDivFlg = null;
	/* Column Info */
	private String polArOfcCd = null;
	/* Column Info */
	private String scCtrtOfcCd = null;
	/* Column Info */
	private String podArOfcCd = null;
	/* Column Info */
	private String polApOfcCd = null;
	/* Column Info */
	private String bkgShprOwnrFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgArOfcCd = null;
	/* Column Info */
	private String ffCmpnSeq = null;
	/* Column Info */
	private String bkgFfSeq = null;
	/* Column Info */
	private String delContiCd = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String polScontiCd = null;
	/* Column Info */
	private String mdmCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchFFBookingInfoVO() {}

	public SearchFFBookingInfoVO(String ibflag, String pagerows, String porCd, String porRgnCd, String porCntCd, String porSteCd, String porScontiCd, String porContiCd, String porFincCtrlOfcCd, String porArOfcCd, String porApOfcCd, String polCd, String polRgnCd, String polCntCd, String polSteCd, String polScontiCd, String polContiCd, String polFincCtrlOfcCd, String polArOfcCd, String polApOfcCd, String podCd, String podRgnCd, String podCntCd, String podSteCd, String podScontiCd, String podContiCd, String podFincCtrlOfcCd, String podArOfcCd, String podApOfcCd, String delCd, String delRgnCd, String delCntCd, String delSteCd, String delScontiCd, String delContiCd, String delFincCtrlOfcCd, String delArOfcCd, String delApOfcCd, String rcvTermCd, String deTermCd, String bkgOfcCd, String bkgFincCtrlOfcCd, String bkgArOfcCd, String bkgOfcLocCd, String bkgSlsOfcCd, String bkgStsCd, String bkgCgoTpCd, String cmdtCd, String repCmdtCd, String blNo, String dblBkgFlg, String bkgShprOwnrFlg, String bkgCreDt, String bkgOfcAgnCd, String spclDgCgoFlg, String spclRcFlg, String spclAwkCgoFlg, String spclBbCgoFlg, String preRlyPortCd, String pstRlyPortCd, String bslDelOfcCd, String bslDelArOfcCd, String bslDelApOfcCd, String ctrtOfcCd, String scNo, String rfaNo, String bkgSvcScpCd, String svcScpCheck, String coveredCheck, String shprCntCd, String shprCustSeq, String bkgFfCntCd, String bkgFfSeq, String ffCntCd, String ffSeq, String ffCustSeq, String fmcNo, String ffFmcCheckFlag, String referenceNo, String shFfCheckFlag, String ffCheck, String slsOfcCd, String scCtrtOfcCd, String bkgNo, String ppdOfcCdChgYn, String chgPpdOfcCd, String chgArOfcCd, String chgApOfcCd, String arOfcCd, String apOfcCd, String vndrCntSeq, String agnDivFlg, String calAgnDivFlg, String vndrCntCd, String vndrSeq, String ffOfcCd, String ffCalcAmt, String actCommAmt, String ffDivCd1, String facRtOfcCd, String ffCmpnSeq, String crntAmt, String userId, String trunkEtdDt, String ffCustSeqTmp, String ffTeuQty, String ffFeuQty, String oldFfCntCd, String oldFfSeq, String oldSumIfAmt, String newFfCmpnSeq, String commProcRsltRsn, String flg0507, String ffCmpnStsCd, String ffCmpnRmk, String ffChgAmt, String mdmCustTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.delApOfcCd = delApOfcCd;
		this.ffChgAmt = ffChgAmt;
		this.pagerows = pagerows;
		this.flg0507 = flg0507;
		this.ctrtOfcCd = ctrtOfcCd;
		this.newFfCmpnSeq = newFfCmpnSeq;
		this.trunkEtdDt = trunkEtdDt;
		this.spclDgCgoFlg = spclDgCgoFlg;
		this.slsOfcCd = slsOfcCd;
		this.bkgCreDt = bkgCreDt;
		this.bkgOfcCd = bkgOfcCd;
		this.dblBkgFlg = dblBkgFlg;
		this.apOfcCd = apOfcCd;
		this.shprCntCd = shprCntCd;
		this.chgArOfcCd = chgArOfcCd;
		this.bkgOfcAgnCd = bkgOfcAgnCd;
		this.polCntCd = polCntCd;
		this.podCd = podCd;
		this.spclBbCgoFlg = spclBbCgoFlg;
		this.bkgNo = bkgNo;
		this.ppdOfcCdChgYn = ppdOfcCdChgYn;
		this.porFincCtrlOfcCd = porFincCtrlOfcCd;
		this.bkgFincCtrlOfcCd = bkgFincCtrlOfcCd;
		this.porContiCd = porContiCd;
		this.bslDelApOfcCd = bslDelApOfcCd;
		this.bkgStsCd = bkgStsCd;
		this.podScontiCd = podScontiCd;
		this.ffCmpnStsCd = ffCmpnStsCd;
		this.ffCalcAmt = ffCalcAmt;
		this.bkgSlsOfcCd = bkgSlsOfcCd;
		this.shFfCheckFlag = shFfCheckFlag;
		this.ffCustSeq = ffCustSeq;
		this.bkgSvcScpCd = bkgSvcScpCd;
		this.cmdtCd = cmdtCd;
		this.spclAwkCgoFlg = spclAwkCgoFlg;
		this.ffFeuQty = ffFeuQty;
		this.bslDelOfcCd = bslDelOfcCd;
		this.bslDelArOfcCd = bslDelArOfcCd;
		this.podContiCd = podContiCd;
		this.arOfcCd = arOfcCd;
		this.oldFfSeq = oldFfSeq;
		this.facRtOfcCd = facRtOfcCd;
		this.porSteCd = porSteCd;
		this.ffOfcCd = ffOfcCd;
		this.shprCustSeq = shprCustSeq;
		this.ffFmcCheckFlag = ffFmcCheckFlag;
		this.ffCmpnRmk = ffCmpnRmk;
		this.referenceNo = referenceNo;
		this.repCmdtCd = repCmdtCd;
		this.delRgnCd = delRgnCd;
		this.vndrCntCd = vndrCntCd;
		this.ffCustSeqTmp = ffCustSeqTmp;
		this.podFincCtrlOfcCd = podFincCtrlOfcCd;
		this.blNo = blNo;
		this.bkgOfcLocCd = bkgOfcLocCd;
		this.polSteCd = polSteCd;
		this.polCd = polCd;
		this.delArOfcCd = delArOfcCd;
		this.ffSeq = ffSeq;
		this.scNo = scNo;
		this.bkgFfCntCd = bkgFfCntCd;
		this.userId = userId;
		this.actCommAmt = actCommAmt;
		this.delScontiCd = delScontiCd;
		this.coveredCheck = coveredCheck;
		this.podRgnCd = podRgnCd;
		this.vndrCntSeq = vndrCntSeq;
		this.delSteCd = delSteCd;
		this.polFincCtrlOfcCd = polFincCtrlOfcCd;
		this.chgApOfcCd = chgApOfcCd;
		this.preRlyPortCd = preRlyPortCd;
		this.delCntCd = delCntCd;
		this.oldSumIfAmt = oldSumIfAmt;
		this.delCd = delCd;
		this.calAgnDivFlg = calAgnDivFlg;
		this.ffDivCd1 = ffDivCd1;
		this.podCntCd = podCntCd;
		this.oldFfCntCd = oldFfCntCd;
		this.polContiCd = polContiCd;
		this.porRgnCd = porRgnCd;
		this.vndrSeq = vndrSeq;
		this.porScontiCd = porScontiCd;
		this.pstRlyPortCd = pstRlyPortCd;
		this.chgPpdOfcCd = chgPpdOfcCd;
		this.porCd = porCd;
		this.spclRcFlg = spclRcFlg;
		this.delFincCtrlOfcCd = delFincCtrlOfcCd;
		this.svcScpCheck = svcScpCheck;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.podSteCd = podSteCd;
		this.fmcNo = fmcNo;
		this.ffTeuQty = ffTeuQty;
		this.podApOfcCd = podApOfcCd;
		this.porApOfcCd = porApOfcCd;
		this.polRgnCd = polRgnCd;
		this.crntAmt = crntAmt;
		this.porArOfcCd = porArOfcCd;
		this.rcvTermCd = rcvTermCd;
		this.porCntCd = porCntCd;
		this.ffCheck = ffCheck;
		this.commProcRsltRsn = commProcRsltRsn;
		this.agnDivFlg = agnDivFlg;
		this.polArOfcCd = polArOfcCd;
		this.scCtrtOfcCd = scCtrtOfcCd;
		this.podArOfcCd = podArOfcCd;
		this.polApOfcCd = polApOfcCd;
		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
		this.deTermCd = deTermCd;
		this.bkgArOfcCd = bkgArOfcCd;
		this.ffCmpnSeq = ffCmpnSeq;
		this.bkgFfSeq = bkgFfSeq;
		this.delContiCd = delContiCd;
		this.ffCntCd = ffCntCd;
		this.polScontiCd = polScontiCd;
		this.mdmCustTpCd = mdmCustTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("del_ap_ofc_cd", getDelApOfcCd());
		this.hashColumns.put("ff_chg_amt", getFfChgAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flg0507", getFlg0507());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("new_ff_cmpn_seq", getNewFfCmpnSeq());
		this.hashColumns.put("trunk_etd_dt", getTrunkEtdDt());
		this.hashColumns.put("spcl_dg_cgo_flg", getSpclDgCgoFlg());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("dbl_bkg_flg", getDblBkgFlg());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("chg_ar_ofc_cd", getChgArOfcCd());
		this.hashColumns.put("bkg_ofc_agn_cd", getBkgOfcAgnCd());
		this.hashColumns.put("pol_cnt_cd", getPolCntCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("spcl_bb_cgo_flg", getSpclBbCgoFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ppd_ofc_cd_chg_yn", getPpdOfcCdChgYn());
		this.hashColumns.put("por_finc_ctrl_ofc_cd", getPorFincCtrlOfcCd());
		this.hashColumns.put("bkg_finc_ctrl_ofc_cd", getBkgFincCtrlOfcCd());
		this.hashColumns.put("por_conti_cd", getPorContiCd());
		this.hashColumns.put("bsl_del_ap_ofc_cd", getBslDelApOfcCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("pod_sconti_cd", getPodScontiCd());
		this.hashColumns.put("ff_cmpn_sts_cd", getFfCmpnStsCd());
		this.hashColumns.put("ff_calc_amt", getFfCalcAmt());
		this.hashColumns.put("bkg_sls_ofc_cd", getBkgSlsOfcCd());
		this.hashColumns.put("sh_ff_check_flag", getShFfCheckFlag());
		this.hashColumns.put("ff_cust_seq", getFfCustSeq());
		this.hashColumns.put("bkg_svc_scp_cd", getBkgSvcScpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("spcl_awk_cgo_flg", getSpclAwkCgoFlg());
		this.hashColumns.put("ff_feu_qty", getFfFeuQty());
		this.hashColumns.put("bsl_del_ofc_cd", getBslDelOfcCd());
		this.hashColumns.put("bsl_del_ar_ofc_cd", getBslDelArOfcCd());
		this.hashColumns.put("pod_conti_cd", getPodContiCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("old_ff_seq", getOldFfSeq());
		this.hashColumns.put("fac_rt_ofc_cd", getFacRtOfcCd());
		this.hashColumns.put("por_ste_cd", getPorSteCd());
		this.hashColumns.put("ff_ofc_cd", getFfOfcCd());
		this.hashColumns.put("shpr_cust_seq", getShprCustSeq());
		this.hashColumns.put("ff_fmc_check_flag", getFfFmcCheckFlag());
		this.hashColumns.put("ff_cmpn_rmk", getFfCmpnRmk());
		this.hashColumns.put("reference_no", getReferenceNo());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("del_rgn_cd", getDelRgnCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("ff_cust_seq_tmp", getFfCustSeqTmp());
		this.hashColumns.put("pod_finc_ctrl_ofc_cd", getPodFincCtrlOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_ofc_loc_cd", getBkgOfcLocCd());
		this.hashColumns.put("pol_ste_cd", getPolSteCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("del_ar_ofc_cd", getDelArOfcCd());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_ff_cnt_cd", getBkgFfCntCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("del_sconti_cd", getDelScontiCd());
		this.hashColumns.put("covered_check", getCoveredCheck());
		this.hashColumns.put("pod_rgn_cd", getPodRgnCd());
		this.hashColumns.put("vndr_cnt_seq", getVndrCntSeq());
		this.hashColumns.put("del_ste_cd", getDelSteCd());
		this.hashColumns.put("pol_finc_ctrl_ofc_cd", getPolFincCtrlOfcCd());
		this.hashColumns.put("chg_ap_ofc_cd", getChgApOfcCd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("old_sum_if_amt", getOldSumIfAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cal_agn_div_flg", getCalAgnDivFlg());
		this.hashColumns.put("ff_div_cd_1", getFfDivCd1());
		this.hashColumns.put("pod_cnt_cd", getPodCntCd());
		this.hashColumns.put("old_ff_cnt_cd", getOldFfCntCd());
		this.hashColumns.put("pol_conti_cd", getPolContiCd());
		this.hashColumns.put("por_rgn_cd", getPorRgnCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("por_sconti_cd", getPorScontiCd());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("chg_ppd_ofc_cd", getChgPpdOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("spcl_rc_flg", getSpclRcFlg());
		this.hashColumns.put("del_finc_ctrl_ofc_cd", getDelFincCtrlOfcCd());
		this.hashColumns.put("svc_scp_check", getSvcScpCheck());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_ste_cd", getPodSteCd());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("ff_teu_qty", getFfTeuQty());
		this.hashColumns.put("pod_ap_ofc_cd", getPodApOfcCd());
		this.hashColumns.put("por_ap_ofc_cd", getPorApOfcCd());
		this.hashColumns.put("pol_rgn_cd", getPolRgnCd());
		this.hashColumns.put("crnt_amt", getCrntAmt());
		this.hashColumns.put("por_ar_ofc_cd", getPorArOfcCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("ff_check", getFfCheck());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("agn_div_flg", getAgnDivFlg());
		this.hashColumns.put("pol_ar_ofc_cd", getPolArOfcCd());
		this.hashColumns.put("sc_ctrt_ofc_cd", getScCtrtOfcCd());
		this.hashColumns.put("pod_ar_ofc_cd", getPodArOfcCd());
		this.hashColumns.put("pol_ap_ofc_cd", getPolApOfcCd());
		this.hashColumns.put("bkg_shpr_ownr_flg", getBkgShprOwnrFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_ar_ofc_cd", getBkgArOfcCd());
		this.hashColumns.put("ff_cmpn_seq", getFfCmpnSeq());
		this.hashColumns.put("bkg_ff_seq", getBkgFfSeq());
		this.hashColumns.put("del_conti_cd", getDelContiCd());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("pol_sconti_cd", getPolScontiCd());
		this.hashColumns.put("mdm_cust_tp_cd", getMdmCustTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("del_ap_ofc_cd", "delApOfcCd");
		this.hashFields.put("ff_chg_amt", "ffChgAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flg0507", "flg0507");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("new_ff_cmpn_seq", "newFfCmpnSeq");
		this.hashFields.put("trunk_etd_dt", "trunkEtdDt");
		this.hashFields.put("spcl_dg_cgo_flg", "spclDgCgoFlg");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("dbl_bkg_flg", "dblBkgFlg");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("chg_ar_ofc_cd", "chgArOfcCd");
		this.hashFields.put("bkg_ofc_agn_cd", "bkgOfcAgnCd");
		this.hashFields.put("pol_cnt_cd", "polCntCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("spcl_bb_cgo_flg", "spclBbCgoFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ppd_ofc_cd_chg_yn", "ppdOfcCdChgYn");
		this.hashFields.put("por_finc_ctrl_ofc_cd", "porFincCtrlOfcCd");
		this.hashFields.put("bkg_finc_ctrl_ofc_cd", "bkgFincCtrlOfcCd");
		this.hashFields.put("por_conti_cd", "porContiCd");
		this.hashFields.put("bsl_del_ap_ofc_cd", "bslDelApOfcCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("pod_sconti_cd", "podScontiCd");
		this.hashFields.put("ff_cmpn_sts_cd", "ffCmpnStsCd");
		this.hashFields.put("ff_calc_amt", "ffCalcAmt");
		this.hashFields.put("bkg_sls_ofc_cd", "bkgSlsOfcCd");
		this.hashFields.put("sh_ff_check_flag", "shFfCheckFlag");
		this.hashFields.put("ff_cust_seq", "ffCustSeq");
		this.hashFields.put("bkg_svc_scp_cd", "bkgSvcScpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("spcl_awk_cgo_flg", "spclAwkCgoFlg");
		this.hashFields.put("ff_feu_qty", "ffFeuQty");
		this.hashFields.put("bsl_del_ofc_cd", "bslDelOfcCd");
		this.hashFields.put("bsl_del_ar_ofc_cd", "bslDelArOfcCd");
		this.hashFields.put("pod_conti_cd", "podContiCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("old_ff_seq", "oldFfSeq");
		this.hashFields.put("fac_rt_ofc_cd", "facRtOfcCd");
		this.hashFields.put("por_ste_cd", "porSteCd");
		this.hashFields.put("ff_ofc_cd", "ffOfcCd");
		this.hashFields.put("shpr_cust_seq", "shprCustSeq");
		this.hashFields.put("ff_fmc_check_flag", "ffFmcCheckFlag");
		this.hashFields.put("ff_cmpn_rmk", "ffCmpnRmk");
		this.hashFields.put("reference_no", "referenceNo");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("del_rgn_cd", "delRgnCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("ff_cust_seq_tmp", "ffCustSeqTmp");
		this.hashFields.put("pod_finc_ctrl_ofc_cd", "podFincCtrlOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_ofc_loc_cd", "bkgOfcLocCd");
		this.hashFields.put("pol_ste_cd", "polSteCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("del_ar_ofc_cd", "delArOfcCd");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_ff_cnt_cd", "bkgFfCntCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("del_sconti_cd", "delScontiCd");
		this.hashFields.put("covered_check", "coveredCheck");
		this.hashFields.put("pod_rgn_cd", "podRgnCd");
		this.hashFields.put("vndr_cnt_seq", "vndrCntSeq");
		this.hashFields.put("del_ste_cd", "delSteCd");
		this.hashFields.put("pol_finc_ctrl_ofc_cd", "polFincCtrlOfcCd");
		this.hashFields.put("chg_ap_ofc_cd", "chgApOfcCd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("old_sum_if_amt", "oldSumIfAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cal_agn_div_flg", "calAgnDivFlg");
		this.hashFields.put("ff_div_cd_1", "ffDivCd1");
		this.hashFields.put("pod_cnt_cd", "podCntCd");
		this.hashFields.put("old_ff_cnt_cd", "oldFfCntCd");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("por_rgn_cd", "porRgnCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("por_sconti_cd", "porScontiCd");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("chg_ppd_ofc_cd", "chgPpdOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("spcl_rc_flg", "spclRcFlg");
		this.hashFields.put("del_finc_ctrl_ofc_cd", "delFincCtrlOfcCd");
		this.hashFields.put("svc_scp_check", "svcScpCheck");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_ste_cd", "podSteCd");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("ff_teu_qty", "ffTeuQty");
		this.hashFields.put("pod_ap_ofc_cd", "podApOfcCd");
		this.hashFields.put("por_ap_ofc_cd", "porApOfcCd");
		this.hashFields.put("pol_rgn_cd", "polRgnCd");
		this.hashFields.put("crnt_amt", "crntAmt");
		this.hashFields.put("por_ar_ofc_cd", "porArOfcCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("ff_check", "ffCheck");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("agn_div_flg", "agnDivFlg");
		this.hashFields.put("pol_ar_ofc_cd", "polArOfcCd");
		this.hashFields.put("sc_ctrt_ofc_cd", "scCtrtOfcCd");
		this.hashFields.put("pod_ar_ofc_cd", "podArOfcCd");
		this.hashFields.put("pol_ap_ofc_cd", "polApOfcCd");
		this.hashFields.put("bkg_shpr_ownr_flg", "bkgShprOwnrFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_ar_ofc_cd", "bkgArOfcCd");
		this.hashFields.put("ff_cmpn_seq", "ffCmpnSeq");
		this.hashFields.put("bkg_ff_seq", "bkgFfSeq");
		this.hashFields.put("del_conti_cd", "delContiCd");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("pol_sconti_cd", "polScontiCd");
		this.hashFields.put("mdm_cust_tp_cd", "mdmCustTpCd");
		return this.hashFields;
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
	 * @return delApOfcCd
	 */
	public String getDelApOfcCd() {
		return this.delApOfcCd;
	}

	/**
	 * Column Info
	 * @return ffChgAmt
	 */
	public String getFfChgAmt() {
		return this.ffChgAmt;
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
	 * @return flg0507
	 */
	public String getFlg0507() {
		return this.flg0507;
	}

	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}

	/**
	 * Column Info
	 * @return newFfCmpnSeq
	 */
	public String getNewFfCmpnSeq() {
		return this.newFfCmpnSeq;
	}

	/**
	 * Column Info
	 * @return trunkEtdDt
	 */
	public String getTrunkEtdDt() {
		return this.trunkEtdDt;
	}

	/**
	 * Column Info
	 * @return spclDgCgoFlg
	 */
	public String getSpclDgCgoFlg() {
		return this.spclDgCgoFlg;
	}

	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
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
	 * @return dblBkgFlg
	 */
	public String getDblBkgFlg() {
		return this.dblBkgFlg;
	}

	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}

	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}

	/**
	 * Column Info
	 * @return chgArOfcCd
	 */
	public String getChgArOfcCd() {
		return this.chgArOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgOfcAgnCd
	 */
	public String getBkgOfcAgnCd() {
		return this.bkgOfcAgnCd;
	}

	/**
	 * Column Info
	 * @return polCntCd
	 */
	public String getPolCntCd() {
		return this.polCntCd;
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
	 * @return spclBbCgoFlg
	 */
	public String getSpclBbCgoFlg() {
		return this.spclBbCgoFlg;
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
	 * @return ppdOfcCdChgYn
	 */
	public String getPpdOfcCdChgYn() {
		return this.ppdOfcCdChgYn;
	}

	/**
	 * Column Info
	 * @return porFincCtrlOfcCd
	 */
	public String getPorFincCtrlOfcCd() {
		return this.porFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgFincCtrlOfcCd
	 */
	public String getBkgFincCtrlOfcCd() {
		return this.bkgFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @return porContiCd
	 */
	public String getPorContiCd() {
		return this.porContiCd;
	}

	/**
	 * Column Info
	 * @return bslDelApOfcCd
	 */
	public String getBslDelApOfcCd() {
		return this.bslDelApOfcCd;
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
	 * @return podScontiCd
	 */
	public String getPodScontiCd() {
		return this.podScontiCd;
	}

	/**
	 * Column Info
	 * @return ffCmpnStsCd
	 */
	public String getFfCmpnStsCd() {
		return this.ffCmpnStsCd;
	}

	/**
	 * Column Info
	 * @return ffCalcAmt
	 */
	public String getFfCalcAmt() {
		return this.ffCalcAmt;
	}

	/**
	 * Column Info
	 * @return bkgSlsOfcCd
	 */
	public String getBkgSlsOfcCd() {
		return this.bkgSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return shFfCheckFlag
	 */
	public String getShFfCheckFlag() {
		return this.shFfCheckFlag;
	}

	/**
	 * Column Info
	 * @return ffCustSeq
	 */
	public String getFfCustSeq() {
		return this.ffCustSeq;
	}

	/**
	 * Column Info
	 * @return bkgSvcScpCd
	 */
	public String getBkgSvcScpCd() {
		return this.bkgSvcScpCd;
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
	 * @return spclAwkCgoFlg
	 */
	public String getSpclAwkCgoFlg() {
		return this.spclAwkCgoFlg;
	}

	/**
	 * Column Info
	 * @return ffFeuQty
	 */
	public String getFfFeuQty() {
		return this.ffFeuQty;
	}

	/**
	 * Column Info
	 * @return bslDelOfcCd
	 */
	public String getBslDelOfcCd() {
		return this.bslDelOfcCd;
	}

	/**
	 * Column Info
	 * @return bslDelArOfcCd
	 */
	public String getBslDelArOfcCd() {
		return this.bslDelArOfcCd;
	}

	/**
	 * Column Info
	 * @return podContiCd
	 */
	public String getPodContiCd() {
		return this.podContiCd;
	}

	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	/**
	 * Column Info
	 * @return oldFfSeq
	 */
	public String getOldFfSeq() {
		return this.oldFfSeq;
	}

	/**
	 * Column Info
	 * @return facRtOfcCd
	 */
	public String getFacRtOfcCd() {
		return this.facRtOfcCd;
	}

	/**
	 * Column Info
	 * @return porSteCd
	 */
	public String getPorSteCd() {
		return this.porSteCd;
	}

	/**
	 * Column Info
	 * @return ffOfcCd
	 */
	public String getFfOfcCd() {
		return this.ffOfcCd;
	}

	/**
	 * Column Info
	 * @return shprCustSeq
	 */
	public String getShprCustSeq() {
		return this.shprCustSeq;
	}

	/**
	 * Column Info
	 * @return ffFmcCheckFlag
	 */
	public String getFfFmcCheckFlag() {
		return this.ffFmcCheckFlag;
	}

	/**
	 * Column Info
	 * @return ffCmpnRmk
	 */
	public String getFfCmpnRmk() {
		return this.ffCmpnRmk;
	}

	/**
	 * Column Info
	 * @return referenceNo
	 */
	public String getReferenceNo() {
		return this.referenceNo;
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
	 * @return delRgnCd
	 */
	public String getDelRgnCd() {
		return this.delRgnCd;
	}

	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}

	/**
	 * Column Info
	 * @return ffCustSeqTmp
	 */
	public String getFfCustSeqTmp() {
		return this.ffCustSeqTmp;
	}

	/**
	 * Column Info
	 * @return podFincCtrlOfcCd
	 */
	public String getPodFincCtrlOfcCd() {
		return this.podFincCtrlOfcCd;
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
	 * @return bkgOfcLocCd
	 */
	public String getBkgOfcLocCd() {
		return this.bkgOfcLocCd;
	}

	/**
	 * Column Info
	 * @return polSteCd
	 */
	public String getPolSteCd() {
		return this.polSteCd;
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
	 * @return delArOfcCd
	 */
	public String getDelArOfcCd() {
		return this.delArOfcCd;
	}

	/**
	 * Column Info
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
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
	 * @return bkgFfCntCd
	 */
	public String getBkgFfCntCd() {
		return this.bkgFfCntCd;
	}

	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
	}

	/**
	 * Column Info
	 * @return delScontiCd
	 */
	public String getDelScontiCd() {
		return this.delScontiCd;
	}

	/**
	 * Column Info
	 * @return coveredCheck
	 */
	public String getCoveredCheck() {
		return this.coveredCheck;
	}

	/**
	 * Column Info
	 * @return podRgnCd
	 */
	public String getPodRgnCd() {
		return this.podRgnCd;
	}

	/**
	 * Column Info
	 * @return vndrCntSeq
	 */
	public String getVndrCntSeq() {
		return this.vndrCntSeq;
	}

	/**
	 * Column Info
	 * @return delSteCd
	 */
	public String getDelSteCd() {
		return this.delSteCd;
	}

	/**
	 * Column Info
	 * @return polFincCtrlOfcCd
	 */
	public String getPolFincCtrlOfcCd() {
		return this.polFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @return chgApOfcCd
	 */
	public String getChgApOfcCd() {
		return this.chgApOfcCd;
	}

	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}

	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}

	/**
	 * Column Info
	 * @return oldSumIfAmt
	 */
	public String getOldSumIfAmt() {
		return this.oldSumIfAmt;
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
	 * @return calAgnDivFlg
	 */
	public String getCalAgnDivFlg() {
		return this.calAgnDivFlg;
	}

	/**
	 * Column Info
	 * @return ffDivCd1
	 */
	public String getFfDivCd1() {
		return this.ffDivCd1;
	}

	/**
	 * Column Info
	 * @return podCntCd
	 */
	public String getPodCntCd() {
		return this.podCntCd;
	}

	/**
	 * Column Info
	 * @return oldFfCntCd
	 */
	public String getOldFfCntCd() {
		return this.oldFfCntCd;
	}

	/**
	 * Column Info
	 * @return polContiCd
	 */
	public String getPolContiCd() {
		return this.polContiCd;
	}

	/**
	 * Column Info
	 * @return porRgnCd
	 */
	public String getPorRgnCd() {
		return this.porRgnCd;
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
	 * @return porScontiCd
	 */
	public String getPorScontiCd() {
		return this.porScontiCd;
	}

	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}

	/**
	 * Column Info
	 * @return chgPpdOfcCd
	 */
	public String getChgPpdOfcCd() {
		return this.chgPpdOfcCd;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * @return spclRcFlg
	 */
	public String getSpclRcFlg() {
		return this.spclRcFlg;
	}

	/**
	 * Column Info
	 * @return delFincCtrlOfcCd
	 */
	public String getDelFincCtrlOfcCd() {
		return this.delFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @return svcScpCheck
	 */
	public String getSvcScpCheck() {
		return this.svcScpCheck;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return podSteCd
	 */
	public String getPodSteCd() {
		return this.podSteCd;
	}

	/**
	 * Column Info
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
	}

	/**
	 * Column Info
	 * @return ffTeuQty
	 */
	public String getFfTeuQty() {
		return this.ffTeuQty;
	}

	/**
	 * Column Info
	 * @return podApOfcCd
	 */
	public String getPodApOfcCd() {
		return this.podApOfcCd;
	}

	/**
	 * Column Info
	 * @return porApOfcCd
	 */
	public String getPorApOfcCd() {
		return this.porApOfcCd;
	}

	/**
	 * Column Info
	 * @return polRgnCd
	 */
	public String getPolRgnCd() {
		return this.polRgnCd;
	}

	/**
	 * Column Info
	 * @return crntAmt
	 */
	public String getCrntAmt() {
		return this.crntAmt;
	}

	/**
	 * Column Info
	 * @return porArOfcCd
	 */
	public String getPorArOfcCd() {
		return this.porArOfcCd;
	}

	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}

	/**
	 * Column Info
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
	}

	/**
	 * Column Info
	 * @return ffCheck
	 */
	public String getFfCheck() {
		return this.ffCheck;
	}

	/**
	 * Column Info
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
	}

	/**
	 * Column Info
	 * @return agnDivFlg
	 */
	public String getAgnDivFlg() {
		return this.agnDivFlg;
	}

	/**
	 * Column Info
	 * @return polArOfcCd
	 */
	public String getPolArOfcCd() {
		return this.polArOfcCd;
	}

	/**
	 * Column Info
	 * @return scCtrtOfcCd
	 */
	public String getScCtrtOfcCd() {
		return this.scCtrtOfcCd;
	}

	/**
	 * Column Info
	 * @return podArOfcCd
	 */
	public String getPodArOfcCd() {
		return this.podArOfcCd;
	}

	/**
	 * Column Info
	 * @return polApOfcCd
	 */
	public String getPolApOfcCd() {
		return this.polApOfcCd;
	}

	/**
	 * Column Info
	 * @return bkgShprOwnrFlg
	 */
	public String getBkgShprOwnrFlg() {
		return this.bkgShprOwnrFlg;
	}

	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}

	/**
	 * Column Info
	 * @return bkgArOfcCd
	 */
	public String getBkgArOfcCd() {
		return this.bkgArOfcCd;
	}

	/**
	 * Column Info
	 * @return ffCmpnSeq
	 */
	public String getFfCmpnSeq() {
		return this.ffCmpnSeq;
	}

	/**
	 * Column Info
	 * @return bkgFfSeq
	 */
	public String getBkgFfSeq() {
		return this.bkgFfSeq;
	}

	/**
	 * Column Info
	 * @return delContiCd
	 */
	public String getDelContiCd() {
		return this.delContiCd;
	}

	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}

	/**
	 * Column Info
	 * @return polScontiCd
	 */
	public String getPolScontiCd() {
		return this.polScontiCd;
	}
	
	/**
	 * Column Info
	 * @return mdmCustTpCd
	 */
	public String getMdmCustTpCd() {
		return this.mdmCustTpCd;
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
	 * @param delApOfcCd
	 */
	public void setDelApOfcCd(String delApOfcCd) {
		this.delApOfcCd = delApOfcCd;
	}

	/**
	 * Column Info
	 * @param ffChgAmt
	 */
	public void setFfChgAmt(String ffChgAmt) {
		this.ffChgAmt = ffChgAmt;
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
	 * @param flg0507
	 */
	public void setFlg0507(String flg0507) {
		this.flg0507 = flg0507;
	}

	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	/**
	 * Column Info
	 * @param newFfCmpnSeq
	 */
	public void setNewFfCmpnSeq(String newFfCmpnSeq) {
		this.newFfCmpnSeq = newFfCmpnSeq;
	}

	/**
	 * Column Info
	 * @param trunkEtdDt
	 */
	public void setTrunkEtdDt(String trunkEtdDt) {
		this.trunkEtdDt = trunkEtdDt;
	}

	/**
	 * Column Info
	 * @param spclDgCgoFlg
	 */
	public void setSpclDgCgoFlg(String spclDgCgoFlg) {
		this.spclDgCgoFlg = spclDgCgoFlg;
	}

	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
	 * @param dblBkgFlg
	 */
	public void setDblBkgFlg(String dblBkgFlg) {
		this.dblBkgFlg = dblBkgFlg;
	}

	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}

	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}

	/**
	 * Column Info
	 * @param chgArOfcCd
	 */
	public void setChgArOfcCd(String chgArOfcCd) {
		this.chgArOfcCd = chgArOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgOfcAgnCd
	 */
	public void setBkgOfcAgnCd(String bkgOfcAgnCd) {
		this.bkgOfcAgnCd = bkgOfcAgnCd;
	}

	/**
	 * Column Info
	 * @param polCntCd
	 */
	public void setPolCntCd(String polCntCd) {
		this.polCntCd = polCntCd;
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
	 * @param spclBbCgoFlg
	 */
	public void setSpclBbCgoFlg(String spclBbCgoFlg) {
		this.spclBbCgoFlg = spclBbCgoFlg;
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
	 * @param ppdOfcCdChgYn
	 */
	public void setPpdOfcCdChgYn(String ppdOfcCdChgYn) {
		this.ppdOfcCdChgYn = ppdOfcCdChgYn;
	}

	/**
	 * Column Info
	 * @param porFincCtrlOfcCd
	 */
	public void setPorFincCtrlOfcCd(String porFincCtrlOfcCd) {
		this.porFincCtrlOfcCd = porFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgFincCtrlOfcCd
	 */
	public void setBkgFincCtrlOfcCd(String bkgFincCtrlOfcCd) {
		this.bkgFincCtrlOfcCd = bkgFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @param porContiCd
	 */
	public void setPorContiCd(String porContiCd) {
		this.porContiCd = porContiCd;
	}

	/**
	 * Column Info
	 * @param bslDelApOfcCd
	 */
	public void setBslDelApOfcCd(String bslDelApOfcCd) {
		this.bslDelApOfcCd = bslDelApOfcCd;
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
	 * @param podScontiCd
	 */
	public void setPodScontiCd(String podScontiCd) {
		this.podScontiCd = podScontiCd;
	}

	/**
	 * Column Info
	 * @param ffCmpnStsCd
	 */
	public void setFfCmpnStsCd(String ffCmpnStsCd) {
		this.ffCmpnStsCd = ffCmpnStsCd;
	}

	/**
	 * Column Info
	 * @param ffCalcAmt
	 */
	public void setFfCalcAmt(String ffCalcAmt) {
		this.ffCalcAmt = ffCalcAmt;
	}

	/**
	 * Column Info
	 * @param bkgSlsOfcCd
	 */
	public void setBkgSlsOfcCd(String bkgSlsOfcCd) {
		this.bkgSlsOfcCd = bkgSlsOfcCd;
	}

	/**
	 * Column Info
	 * @param shFfCheckFlag
	 */
	public void setShFfCheckFlag(String shFfCheckFlag) {
		this.shFfCheckFlag = shFfCheckFlag;
	}

	/**
	 * Column Info
	 * @param ffCustSeq
	 */
	public void setFfCustSeq(String ffCustSeq) {
		this.ffCustSeq = ffCustSeq;
	}

	/**
	 * Column Info
	 * @param bkgSvcScpCd
	 */
	public void setBkgSvcScpCd(String bkgSvcScpCd) {
		this.bkgSvcScpCd = bkgSvcScpCd;
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
	 * @param spclAwkCgoFlg
	 */
	public void setSpclAwkCgoFlg(String spclAwkCgoFlg) {
		this.spclAwkCgoFlg = spclAwkCgoFlg;
	}

	/**
	 * Column Info
	 * @param ffFeuQty
	 */
	public void setFfFeuQty(String ffFeuQty) {
		this.ffFeuQty = ffFeuQty;
	}

	/**
	 * Column Info
	 * @param bslDelOfcCd
	 */
	public void setBslDelOfcCd(String bslDelOfcCd) {
		this.bslDelOfcCd = bslDelOfcCd;
	}

	/**
	 * Column Info
	 * @param bslDelArOfcCd
	 */
	public void setBslDelArOfcCd(String bslDelArOfcCd) {
		this.bslDelArOfcCd = bslDelArOfcCd;
	}

	/**
	 * Column Info
	 * @param podContiCd
	 */
	public void setPodContiCd(String podContiCd) {
		this.podContiCd = podContiCd;
	}

	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Column Info
	 * @param oldFfSeq
	 */
	public void setOldFfSeq(String oldFfSeq) {
		this.oldFfSeq = oldFfSeq;
	}

	/**
	 * Column Info
	 * @param facRtOfcCd
	 */
	public void setFacRtOfcCd(String facRtOfcCd) {
		this.facRtOfcCd = facRtOfcCd;
	}

	/**
	 * Column Info
	 * @param porSteCd
	 */
	public void setPorSteCd(String porSteCd) {
		this.porSteCd = porSteCd;
	}

	/**
	 * Column Info
	 * @param ffOfcCd
	 */
	public void setFfOfcCd(String ffOfcCd) {
		this.ffOfcCd = ffOfcCd;
	}

	/**
	 * Column Info
	 * @param shprCustSeq
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
	}

	/**
	 * Column Info
	 * @param ffFmcCheckFlag
	 */
	public void setFfFmcCheckFlag(String ffFmcCheckFlag) {
		this.ffFmcCheckFlag = ffFmcCheckFlag;
	}

	/**
	 * Column Info
	 * @param ffCmpnRmk
	 */
	public void setFfCmpnRmk(String ffCmpnRmk) {
		this.ffCmpnRmk = ffCmpnRmk;
	}

	/**
	 * Column Info
	 * @param referenceNo
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}

	/**
	 * Column Info
	 * @param delRgnCd
	 */
	public void setDelRgnCd(String delRgnCd) {
		this.delRgnCd = delRgnCd;
	}

	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}

	/**
	 * Column Info
	 * @param ffCustSeqTmp
	 */
	public void setFfCustSeqTmp(String ffCustSeqTmp) {
		this.ffCustSeqTmp = ffCustSeqTmp;
	}

	/**
	 * Column Info
	 * @param podFincCtrlOfcCd
	 */
	public void setPodFincCtrlOfcCd(String podFincCtrlOfcCd) {
		this.podFincCtrlOfcCd = podFincCtrlOfcCd;
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
	 * @param bkgOfcLocCd
	 */
	public void setBkgOfcLocCd(String bkgOfcLocCd) {
		this.bkgOfcLocCd = bkgOfcLocCd;
	}

	/**
	 * Column Info
	 * @param polSteCd
	 */
	public void setPolSteCd(String polSteCd) {
		this.polSteCd = polSteCd;
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
	 * @param delArOfcCd
	 */
	public void setDelArOfcCd(String delArOfcCd) {
		this.delArOfcCd = delArOfcCd;
	}

	/**
	 * Column Info
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
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
	 * @param bkgFfCntCd
	 */
	public void setBkgFfCntCd(String bkgFfCntCd) {
		this.bkgFfCntCd = bkgFfCntCd;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
	}

	/**
	 * Column Info
	 * @param delScontiCd
	 */
	public void setDelScontiCd(String delScontiCd) {
		this.delScontiCd = delScontiCd;
	}

	/**
	 * Column Info
	 * @param coveredCheck
	 */
	public void setCoveredCheck(String coveredCheck) {
		this.coveredCheck = coveredCheck;
	}

	/**
	 * Column Info
	 * @param podRgnCd
	 */
	public void setPodRgnCd(String podRgnCd) {
		this.podRgnCd = podRgnCd;
	}

	/**
	 * Column Info
	 * @param vndrCntSeq
	 */
	public void setVndrCntSeq(String vndrCntSeq) {
		this.vndrCntSeq = vndrCntSeq;
	}

	/**
	 * Column Info
	 * @param delSteCd
	 */
	public void setDelSteCd(String delSteCd) {
		this.delSteCd = delSteCd;
	}

	/**
	 * Column Info
	 * @param polFincCtrlOfcCd
	 */
	public void setPolFincCtrlOfcCd(String polFincCtrlOfcCd) {
		this.polFincCtrlOfcCd = polFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @param chgApOfcCd
	 */
	public void setChgApOfcCd(String chgApOfcCd) {
		this.chgApOfcCd = chgApOfcCd;
	}

	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}

	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}

	/**
	 * Column Info
	 * @param oldSumIfAmt
	 */
	public void setOldSumIfAmt(String oldSumIfAmt) {
		this.oldSumIfAmt = oldSumIfAmt;
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
	 * @param calAgnDivFlg
	 */
	public void setCalAgnDivFlg(String calAgnDivFlg) {
		this.calAgnDivFlg = calAgnDivFlg;
	}

	/**
	 * Column Info
	 * @param ffDivCd1
	 */
	public void setFfDivCd1(String ffDivCd1) {
		this.ffDivCd1 = ffDivCd1;
	}

	/**
	 * Column Info
	 * @param podCntCd
	 */
	public void setPodCntCd(String podCntCd) {
		this.podCntCd = podCntCd;
	}

	/**
	 * Column Info
	 * @param oldFfCntCd
	 */
	public void setOldFfCntCd(String oldFfCntCd) {
		this.oldFfCntCd = oldFfCntCd;
	}

	/**
	 * Column Info
	 * @param polContiCd
	 */
	public void setPolContiCd(String polContiCd) {
		this.polContiCd = polContiCd;
	}

	/**
	 * Column Info
	 * @param porRgnCd
	 */
	public void setPorRgnCd(String porRgnCd) {
		this.porRgnCd = porRgnCd;
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
	 * @param porScontiCd
	 */
	public void setPorScontiCd(String porScontiCd) {
		this.porScontiCd = porScontiCd;
	}

	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}

	/**
	 * Column Info
	 * @param chgPpdOfcCd
	 */
	public void setChgPpdOfcCd(String chgPpdOfcCd) {
		this.chgPpdOfcCd = chgPpdOfcCd;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * @param spclRcFlg
	 */
	public void setSpclRcFlg(String spclRcFlg) {
		this.spclRcFlg = spclRcFlg;
	}

	/**
	 * Column Info
	 * @param delFincCtrlOfcCd
	 */
	public void setDelFincCtrlOfcCd(String delFincCtrlOfcCd) {
		this.delFincCtrlOfcCd = delFincCtrlOfcCd;
	}

	/**
	 * Column Info
	 * @param svcScpCheck
	 */
	public void setSvcScpCheck(String svcScpCheck) {
		this.svcScpCheck = svcScpCheck;
	}

	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param podSteCd
	 */
	public void setPodSteCd(String podSteCd) {
		this.podSteCd = podSteCd;
	}

	/**
	 * Column Info
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
	}

	/**
	 * Column Info
	 * @param ffTeuQty
	 */
	public void setFfTeuQty(String ffTeuQty) {
		this.ffTeuQty = ffTeuQty;
	}

	/**
	 * Column Info
	 * @param podApOfcCd
	 */
	public void setPodApOfcCd(String podApOfcCd) {
		this.podApOfcCd = podApOfcCd;
	}

	/**
	 * Column Info
	 * @param porApOfcCd
	 */
	public void setPorApOfcCd(String porApOfcCd) {
		this.porApOfcCd = porApOfcCd;
	}

	/**
	 * Column Info
	 * @param polRgnCd
	 */
	public void setPolRgnCd(String polRgnCd) {
		this.polRgnCd = polRgnCd;
	}

	/**
	 * Column Info
	 * @param crntAmt
	 */
	public void setCrntAmt(String crntAmt) {
		this.crntAmt = crntAmt;
	}

	/**
	 * Column Info
	 * @param porArOfcCd
	 */
	public void setPorArOfcCd(String porArOfcCd) {
		this.porArOfcCd = porArOfcCd;
	}

	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}

	/**
	 * Column Info
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
	}

	/**
	 * Column Info
	 * @param ffCheck
	 */
	public void setFfCheck(String ffCheck) {
		this.ffCheck = ffCheck;
	}

	/**
	 * Column Info
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
	}

	/**
	 * Column Info
	 * @param agnDivFlg
	 */
	public void setAgnDivFlg(String agnDivFlg) {
		this.agnDivFlg = agnDivFlg;
	}

	/**
	 * Column Info
	 * @param polArOfcCd
	 */
	public void setPolArOfcCd(String polArOfcCd) {
		this.polArOfcCd = polArOfcCd;
	}

	/**
	 * Column Info
	 * @param scCtrtOfcCd
	 */
	public void setScCtrtOfcCd(String scCtrtOfcCd) {
		this.scCtrtOfcCd = scCtrtOfcCd;
	}

	/**
	 * Column Info
	 * @param podArOfcCd
	 */
	public void setPodArOfcCd(String podArOfcCd) {
		this.podArOfcCd = podArOfcCd;
	}

	/**
	 * Column Info
	 * @param polApOfcCd
	 */
	public void setPolApOfcCd(String polApOfcCd) {
		this.polApOfcCd = polApOfcCd;
	}

	/**
	 * Column Info
	 * @param bkgShprOwnrFlg
	 */
	public void setBkgShprOwnrFlg(String bkgShprOwnrFlg) {
		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
	}

	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}

	/**
	 * Column Info
	 * @param bkgArOfcCd
	 */
	public void setBkgArOfcCd(String bkgArOfcCd) {
		this.bkgArOfcCd = bkgArOfcCd;
	}

	/**
	 * Column Info
	 * @param ffCmpnSeq
	 */
	public void setFfCmpnSeq(String ffCmpnSeq) {
		this.ffCmpnSeq = ffCmpnSeq;
	}

	/**
	 * Column Info
	 * @param bkgFfSeq
	 */
	public void setBkgFfSeq(String bkgFfSeq) {
		this.bkgFfSeq = bkgFfSeq;
	}

	/**
	 * Column Info
	 * @param delContiCd
	 */
	public void setDelContiCd(String delContiCd) {
		this.delContiCd = delContiCd;
	}

	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}

	/**
	 * Column Info
	 * @param polScontiCd
	 */
	public void setPolScontiCd(String polScontiCd) {
		this.polScontiCd = polScontiCd;
	}
	
	/**
	 * Column Info
	 * @param mdmCustTpCd
	 */
	public void setMdmCustTpCd(String mdmCustTpCd) {
		this.mdmCustTpCd = mdmCustTpCd;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setDelApOfcCd(JSPUtil.getParameter(request, prefix + "del_ap_ofc_cd", ""));
		setFfChgAmt(JSPUtil.getParameter(request, prefix + "ff_chg_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFlg0507(JSPUtil.getParameter(request, prefix + "flg0507", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setNewFfCmpnSeq(JSPUtil.getParameter(request, prefix + "new_ff_cmpn_seq", ""));
		setTrunkEtdDt(JSPUtil.getParameter(request, prefix + "trunk_etd_dt", ""));
		setSpclDgCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_dg_cgo_flg", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setDblBkgFlg(JSPUtil.getParameter(request, prefix + "dbl_bkg_flg", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setChgArOfcCd(JSPUtil.getParameter(request, prefix + "chg_ar_ofc_cd", ""));
		setBkgOfcAgnCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_agn_cd", ""));
		setPolCntCd(JSPUtil.getParameter(request, prefix + "pol_cnt_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSpclBbCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_bb_cgo_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPpdOfcCdChgYn(JSPUtil.getParameter(request, prefix + "ppd_ofc_cd_chg_yn", ""));
		setPorFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "por_finc_ctrl_ofc_cd", ""));
		setBkgFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "bkg_finc_ctrl_ofc_cd", ""));
		setPorContiCd(JSPUtil.getParameter(request, prefix + "por_conti_cd", ""));
		setBslDelApOfcCd(JSPUtil.getParameter(request, prefix + "bsl_del_ap_ofc_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPodScontiCd(JSPUtil.getParameter(request, prefix + "pod_sconti_cd", ""));
		setFfCmpnStsCd(JSPUtil.getParameter(request, prefix + "ff_cmpn_sts_cd", ""));
		setFfCalcAmt(JSPUtil.getParameter(request, prefix + "ff_calc_amt", ""));
		setBkgSlsOfcCd(JSPUtil.getParameter(request, prefix + "bkg_sls_ofc_cd", ""));
		setShFfCheckFlag(JSPUtil.getParameter(request, prefix + "sh_ff_check_flag", ""));
		setFfCustSeq(JSPUtil.getParameter(request, prefix + "ff_cust_seq", ""));
		setBkgSvcScpCd(JSPUtil.getParameter(request, prefix + "bkg_svc_scp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSpclAwkCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_awk_cgo_flg", ""));
		setFfFeuQty(JSPUtil.getParameter(request, prefix + "ff_feu_qty", ""));
		setBslDelOfcCd(JSPUtil.getParameter(request, prefix + "bsl_del_ofc_cd", ""));
		setBslDelArOfcCd(JSPUtil.getParameter(request, prefix + "bsl_del_ar_ofc_cd", ""));
		setPodContiCd(JSPUtil.getParameter(request, prefix + "pod_conti_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setOldFfSeq(JSPUtil.getParameter(request, prefix + "old_ff_seq", ""));
		setFacRtOfcCd(JSPUtil.getParameter(request, prefix + "fac_rt_ofc_cd", ""));
		setPorSteCd(JSPUtil.getParameter(request, prefix + "por_ste_cd", ""));
		setFfOfcCd(JSPUtil.getParameter(request, prefix + "ff_ofc_cd", ""));
		setShprCustSeq(JSPUtil.getParameter(request, prefix + "shpr_cust_seq", ""));
		setFfFmcCheckFlag(JSPUtil.getParameter(request, prefix + "ff_fmc_check_flag", ""));
		setFfCmpnRmk(JSPUtil.getParameter(request, prefix + "ff_cmpn_rmk", ""));
		setReferenceNo(JSPUtil.getParameter(request, prefix + "reference_no", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setDelRgnCd(JSPUtil.getParameter(request, prefix + "del_rgn_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setFfCustSeqTmp(JSPUtil.getParameter(request, prefix + "ff_cust_seq_tmp", ""));
		setPodFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "pod_finc_ctrl_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgOfcLocCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_loc_cd", ""));
		setPolSteCd(JSPUtil.getParameter(request, prefix + "pol_ste_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDelArOfcCd(JSPUtil.getParameter(request, prefix + "del_ar_ofc_cd", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBkgFfCntCd(JSPUtil.getParameter(request, prefix + "bkg_ff_cnt_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setActCommAmt(JSPUtil.getParameter(request, prefix + "act_comm_amt", ""));
		setDelScontiCd(JSPUtil.getParameter(request, prefix + "del_sconti_cd", ""));
		setCoveredCheck(JSPUtil.getParameter(request, prefix + "covered_check", ""));
		setPodRgnCd(JSPUtil.getParameter(request, prefix + "pod_rgn_cd", ""));
		setVndrCntSeq(JSPUtil.getParameter(request, prefix + "vndr_cnt_seq", ""));
		setDelSteCd(JSPUtil.getParameter(request, prefix + "del_ste_cd", ""));
		setPolFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "pol_finc_ctrl_ofc_cd", ""));
		setChgApOfcCd(JSPUtil.getParameter(request, prefix + "chg_ap_ofc_cd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
		setOldSumIfAmt(JSPUtil.getParameter(request, prefix + "old_sum_if_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCalAgnDivFlg(JSPUtil.getParameter(request, prefix + "cal_agn_div_flg", ""));
		setFfDivCd1(JSPUtil.getParameter(request, prefix + "ff_div_cd_1", ""));
		setPodCntCd(JSPUtil.getParameter(request, prefix + "pod_cnt_cd", ""));
		setOldFfCntCd(JSPUtil.getParameter(request, prefix + "old_ff_cnt_cd", ""));
		setPolContiCd(JSPUtil.getParameter(request, prefix + "pol_conti_cd", ""));
		setPorRgnCd(JSPUtil.getParameter(request, prefix + "por_rgn_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPorScontiCd(JSPUtil.getParameter(request, prefix + "por_sconti_cd", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setChgPpdOfcCd(JSPUtil.getParameter(request, prefix + "chg_ppd_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSpclRcFlg(JSPUtil.getParameter(request, prefix + "spcl_rc_flg", ""));
		setDelFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "del_finc_ctrl_ofc_cd", ""));
		setSvcScpCheck(JSPUtil.getParameter(request, prefix + "svc_scp_check", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodSteCd(JSPUtil.getParameter(request, prefix + "pod_ste_cd", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setFfTeuQty(JSPUtil.getParameter(request, prefix + "ff_teu_qty", ""));
		setPodApOfcCd(JSPUtil.getParameter(request, prefix + "pod_ap_ofc_cd", ""));
		setPorApOfcCd(JSPUtil.getParameter(request, prefix + "por_ap_ofc_cd", ""));
		setPolRgnCd(JSPUtil.getParameter(request, prefix + "pol_rgn_cd", ""));
		setCrntAmt(JSPUtil.getParameter(request, prefix + "crnt_amt", ""));
		setPorArOfcCd(JSPUtil.getParameter(request, prefix + "por_ar_ofc_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPorCntCd(JSPUtil.getParameter(request, prefix + "por_cnt_cd", ""));
		setFfCheck(JSPUtil.getParameter(request, prefix + "ff_check", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setAgnDivFlg(JSPUtil.getParameter(request, prefix + "agn_div_flg", ""));
		setPolArOfcCd(JSPUtil.getParameter(request, prefix + "pol_ar_ofc_cd", ""));
		setScCtrtOfcCd(JSPUtil.getParameter(request, prefix + "sc_ctrt_ofc_cd", ""));
		setPodArOfcCd(JSPUtil.getParameter(request, prefix + "pod_ar_ofc_cd", ""));
		setPolApOfcCd(JSPUtil.getParameter(request, prefix + "pol_ap_ofc_cd", ""));
		setBkgShprOwnrFlg(JSPUtil.getParameter(request, prefix + "bkg_shpr_ownr_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgArOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ar_ofc_cd", ""));
		setFfCmpnSeq(JSPUtil.getParameter(request, prefix + "ff_cmpn_seq", ""));
		setBkgFfSeq(JSPUtil.getParameter(request, prefix + "bkg_ff_seq", ""));
		setDelContiCd(JSPUtil.getParameter(request, prefix + "del_conti_cd", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setPolScontiCd(JSPUtil.getParameter(request, prefix + "pol_sconti_cd", ""));
		setMdmCustTpCd(JSPUtil.getParameter(request, prefix + "mdm_cust_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFFBookingInfoVO[]
	 */
	public SearchFFBookingInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchFFBookingInfoVO[]
	 */
	public SearchFFBookingInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFFBookingInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] delApOfcCd = (JSPUtil.getParameter(request, prefix	+ "del_ap_ofc_cd", length));
			String[] ffChgAmt = (JSPUtil.getParameter(request, prefix	+ "ff_chg_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] flg0507 = (JSPUtil.getParameter(request, prefix	+ "flg0507", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] newFfCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "new_ff_cmpn_seq", length));
			String[] trunkEtdDt = (JSPUtil.getParameter(request, prefix	+ "trunk_etd_dt", length));
			String[] spclDgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_dg_cgo_flg", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] dblBkgFlg = (JSPUtil.getParameter(request, prefix	+ "dbl_bkg_flg", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] chgArOfcCd = (JSPUtil.getParameter(request, prefix	+ "chg_ar_ofc_cd", length));
			String[] bkgOfcAgnCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_agn_cd", length));
			String[] polCntCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnt_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] spclBbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_bb_cgo_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ppdOfcCdChgYn = (JSPUtil.getParameter(request, prefix	+ "ppd_ofc_cd_chg_yn", length));
			String[] porFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "por_finc_ctrl_ofc_cd", length));
			String[] bkgFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_finc_ctrl_ofc_cd", length));
			String[] porContiCd = (JSPUtil.getParameter(request, prefix	+ "por_conti_cd", length));
			String[] bslDelApOfcCd = (JSPUtil.getParameter(request, prefix	+ "bsl_del_ap_ofc_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] podScontiCd = (JSPUtil.getParameter(request, prefix	+ "pod_sconti_cd", length));
			String[] ffCmpnStsCd = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_sts_cd", length));
			String[] ffCalcAmt = (JSPUtil.getParameter(request, prefix	+ "ff_calc_amt", length));
			String[] bkgSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sls_ofc_cd", length));
			String[] shFfCheckFlag = (JSPUtil.getParameter(request, prefix	+ "sh_ff_check_flag", length));
			String[] ffCustSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq", length));
			String[] bkgSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_svc_scp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] spclAwkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_awk_cgo_flg", length));
			String[] ffFeuQty = (JSPUtil.getParameter(request, prefix	+ "ff_feu_qty", length));
			String[] bslDelOfcCd = (JSPUtil.getParameter(request, prefix	+ "bsl_del_ofc_cd", length));
			String[] bslDelArOfcCd = (JSPUtil.getParameter(request, prefix	+ "bsl_del_ar_ofc_cd", length));
			String[] podContiCd = (JSPUtil.getParameter(request, prefix	+ "pod_conti_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] oldFfSeq = (JSPUtil.getParameter(request, prefix	+ "old_ff_seq", length));
			String[] facRtOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_rt_ofc_cd", length));
			String[] porSteCd = (JSPUtil.getParameter(request, prefix	+ "por_ste_cd", length));
			String[] ffOfcCd = (JSPUtil.getParameter(request, prefix	+ "ff_ofc_cd", length));
			String[] shprCustSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_seq", length));
			String[] ffFmcCheckFlag = (JSPUtil.getParameter(request, prefix	+ "ff_fmc_check_flag", length));
			String[] ffCmpnRmk = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_rmk", length));
			String[] referenceNo = (JSPUtil.getParameter(request, prefix	+ "reference_no", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] delRgnCd = (JSPUtil.getParameter(request, prefix	+ "del_rgn_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] ffCustSeqTmp = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq_tmp", length));
			String[] podFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "pod_finc_ctrl_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgOfcLocCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_loc_cd", length));
			String[] polSteCd = (JSPUtil.getParameter(request, prefix	+ "pol_ste_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] delArOfcCd = (JSPUtil.getParameter(request, prefix	+ "del_ar_ofc_cd", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgFfCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ff_cnt_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] delScontiCd = (JSPUtil.getParameter(request, prefix	+ "del_sconti_cd", length));
			String[] coveredCheck = (JSPUtil.getParameter(request, prefix	+ "covered_check", length));
			String[] podRgnCd = (JSPUtil.getParameter(request, prefix	+ "pod_rgn_cd", length));
			String[] vndrCntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_seq", length));
			String[] delSteCd = (JSPUtil.getParameter(request, prefix	+ "del_ste_cd", length));
			String[] polFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "pol_finc_ctrl_ofc_cd", length));
			String[] chgApOfcCd = (JSPUtil.getParameter(request, prefix	+ "chg_ap_ofc_cd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] oldSumIfAmt = (JSPUtil.getParameter(request, prefix	+ "old_sum_if_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] calAgnDivFlg = (JSPUtil.getParameter(request, prefix	+ "cal_agn_div_flg", length));
			String[] ffDivCd1 = (JSPUtil.getParameter(request, prefix	+ "ff_div_cd_1", length));
			String[] podCntCd = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_cd", length));
			String[] oldFfCntCd = (JSPUtil.getParameter(request, prefix	+ "old_ff_cnt_cd", length));
			String[] polContiCd = (JSPUtil.getParameter(request, prefix	+ "pol_conti_cd", length));
			String[] porRgnCd = (JSPUtil.getParameter(request, prefix	+ "por_rgn_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] porScontiCd = (JSPUtil.getParameter(request, prefix	+ "por_sconti_cd", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] chgPpdOfcCd = (JSPUtil.getParameter(request, prefix	+ "chg_ppd_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] spclRcFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_rc_flg", length));
			String[] delFincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "del_finc_ctrl_ofc_cd", length));
			String[] svcScpCheck = (JSPUtil.getParameter(request, prefix	+ "svc_scp_check", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podSteCd = (JSPUtil.getParameter(request, prefix	+ "pod_ste_cd", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] ffTeuQty = (JSPUtil.getParameter(request, prefix	+ "ff_teu_qty", length));
			String[] podApOfcCd = (JSPUtil.getParameter(request, prefix	+ "pod_ap_ofc_cd", length));
			String[] porApOfcCd = (JSPUtil.getParameter(request, prefix	+ "por_ap_ofc_cd", length));
			String[] polRgnCd = (JSPUtil.getParameter(request, prefix	+ "pol_rgn_cd", length));
			String[] crntAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_amt", length));
			String[] porArOfcCd = (JSPUtil.getParameter(request, prefix	+ "por_ar_ofc_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] ffCheck = (JSPUtil.getParameter(request, prefix	+ "ff_check", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] agnDivFlg = (JSPUtil.getParameter(request, prefix	+ "agn_div_flg", length));
			String[] polArOfcCd = (JSPUtil.getParameter(request, prefix	+ "pol_ar_ofc_cd", length));
			String[] scCtrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "sc_ctrt_ofc_cd", length));
			String[] podArOfcCd = (JSPUtil.getParameter(request, prefix	+ "pod_ar_ofc_cd", length));
			String[] polApOfcCd = (JSPUtil.getParameter(request, prefix	+ "pol_ap_ofc_cd", length));
			String[] bkgShprOwnrFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_shpr_ownr_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgArOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ar_ofc_cd", length));
			String[] ffCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_seq", length));
			String[] bkgFfSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_ff_seq", length));
			String[] delContiCd = (JSPUtil.getParameter(request, prefix	+ "del_conti_cd", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] polScontiCd = (JSPUtil.getParameter(request, prefix	+ "pol_sconti_cd", length));
			String[] mdmCustTpCd = (JSPUtil.getParameter(request, prefix	+ "mdm_cust_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SearchFFBookingInfoVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (delApOfcCd[i] != null)
					model.setDelApOfcCd(delApOfcCd[i]);
				if (ffChgAmt[i] != null)
					model.setFfChgAmt(ffChgAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (flg0507[i] != null)
					model.setFlg0507(flg0507[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (newFfCmpnSeq[i] != null)
					model.setNewFfCmpnSeq(newFfCmpnSeq[i]);
				if (trunkEtdDt[i] != null)
					model.setTrunkEtdDt(trunkEtdDt[i]);
				if (spclDgCgoFlg[i] != null)
					model.setSpclDgCgoFlg(spclDgCgoFlg[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (dblBkgFlg[i] != null)
					model.setDblBkgFlg(dblBkgFlg[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (chgArOfcCd[i] != null)
					model.setChgArOfcCd(chgArOfcCd[i]);
				if (bkgOfcAgnCd[i] != null)
					model.setBkgOfcAgnCd(bkgOfcAgnCd[i]);
				if (polCntCd[i] != null)
					model.setPolCntCd(polCntCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (spclBbCgoFlg[i] != null)
					model.setSpclBbCgoFlg(spclBbCgoFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ppdOfcCdChgYn[i] != null)
					model.setPpdOfcCdChgYn(ppdOfcCdChgYn[i]);
				if (porFincCtrlOfcCd[i] != null)
					model.setPorFincCtrlOfcCd(porFincCtrlOfcCd[i]);
				if (bkgFincCtrlOfcCd[i] != null)
					model.setBkgFincCtrlOfcCd(bkgFincCtrlOfcCd[i]);
				if (porContiCd[i] != null)
					model.setPorContiCd(porContiCd[i]);
				if (bslDelApOfcCd[i] != null)
					model.setBslDelApOfcCd(bslDelApOfcCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (podScontiCd[i] != null)
					model.setPodScontiCd(podScontiCd[i]);
				if (ffCmpnStsCd[i] != null)
					model.setFfCmpnStsCd(ffCmpnStsCd[i]);
				if (ffCalcAmt[i] != null)
					model.setFfCalcAmt(ffCalcAmt[i]);
				if (bkgSlsOfcCd[i] != null)
					model.setBkgSlsOfcCd(bkgSlsOfcCd[i]);
				if (shFfCheckFlag[i] != null)
					model.setShFfCheckFlag(shFfCheckFlag[i]);
				if (ffCustSeq[i] != null)
					model.setFfCustSeq(ffCustSeq[i]);
				if (bkgSvcScpCd[i] != null)
					model.setBkgSvcScpCd(bkgSvcScpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (spclAwkCgoFlg[i] != null)
					model.setSpclAwkCgoFlg(spclAwkCgoFlg[i]);
				if (ffFeuQty[i] != null)
					model.setFfFeuQty(ffFeuQty[i]);
				if (bslDelOfcCd[i] != null)
					model.setBslDelOfcCd(bslDelOfcCd[i]);
				if (bslDelArOfcCd[i] != null)
					model.setBslDelArOfcCd(bslDelArOfcCd[i]);
				if (podContiCd[i] != null)
					model.setPodContiCd(podContiCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (oldFfSeq[i] != null)
					model.setOldFfSeq(oldFfSeq[i]);
				if (facRtOfcCd[i] != null)
					model.setFacRtOfcCd(facRtOfcCd[i]);
				if (porSteCd[i] != null)
					model.setPorSteCd(porSteCd[i]);
				if (ffOfcCd[i] != null)
					model.setFfOfcCd(ffOfcCd[i]);
				if (shprCustSeq[i] != null)
					model.setShprCustSeq(shprCustSeq[i]);
				if (ffFmcCheckFlag[i] != null)
					model.setFfFmcCheckFlag(ffFmcCheckFlag[i]);
				if (ffCmpnRmk[i] != null)
					model.setFfCmpnRmk(ffCmpnRmk[i]);
				if (referenceNo[i] != null)
					model.setReferenceNo(referenceNo[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (delRgnCd[i] != null)
					model.setDelRgnCd(delRgnCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (ffCustSeqTmp[i] != null)
					model.setFfCustSeqTmp(ffCustSeqTmp[i]);
				if (podFincCtrlOfcCd[i] != null)
					model.setPodFincCtrlOfcCd(podFincCtrlOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgOfcLocCd[i] != null)
					model.setBkgOfcLocCd(bkgOfcLocCd[i]);
				if (polSteCd[i] != null)
					model.setPolSteCd(polSteCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delArOfcCd[i] != null)
					model.setDelArOfcCd(delArOfcCd[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgFfCntCd[i] != null)
					model.setBkgFfCntCd(bkgFfCntCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (delScontiCd[i] != null)
					model.setDelScontiCd(delScontiCd[i]);
				if (coveredCheck[i] != null)
					model.setCoveredCheck(coveredCheck[i]);
				if (podRgnCd[i] != null)
					model.setPodRgnCd(podRgnCd[i]);
				if (vndrCntSeq[i] != null)
					model.setVndrCntSeq(vndrCntSeq[i]);
				if (delSteCd[i] != null)
					model.setDelSteCd(delSteCd[i]);
				if (polFincCtrlOfcCd[i] != null)
					model.setPolFincCtrlOfcCd(polFincCtrlOfcCd[i]);
				if (chgApOfcCd[i] != null)
					model.setChgApOfcCd(chgApOfcCd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (oldSumIfAmt[i] != null)
					model.setOldSumIfAmt(oldSumIfAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (calAgnDivFlg[i] != null)
					model.setCalAgnDivFlg(calAgnDivFlg[i]);
				if (ffDivCd1[i] != null)
					model.setFfDivCd1(ffDivCd1[i]);
				if (podCntCd[i] != null)
					model.setPodCntCd(podCntCd[i]);
				if (oldFfCntCd[i] != null)
					model.setOldFfCntCd(oldFfCntCd[i]);
				if (polContiCd[i] != null)
					model.setPolContiCd(polContiCd[i]);
				if (porRgnCd[i] != null)
					model.setPorRgnCd(porRgnCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (porScontiCd[i] != null)
					model.setPorScontiCd(porScontiCd[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (chgPpdOfcCd[i] != null)
					model.setChgPpdOfcCd(chgPpdOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (spclRcFlg[i] != null)
					model.setSpclRcFlg(spclRcFlg[i]);
				if (delFincCtrlOfcCd[i] != null)
					model.setDelFincCtrlOfcCd(delFincCtrlOfcCd[i]);
				if (svcScpCheck[i] != null)
					model.setSvcScpCheck(svcScpCheck[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podSteCd[i] != null)
					model.setPodSteCd(podSteCd[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (ffTeuQty[i] != null)
					model.setFfTeuQty(ffTeuQty[i]);
				if (podApOfcCd[i] != null)
					model.setPodApOfcCd(podApOfcCd[i]);
				if (porApOfcCd[i] != null)
					model.setPorApOfcCd(porApOfcCd[i]);
				if (polRgnCd[i] != null)
					model.setPolRgnCd(polRgnCd[i]);
				if (crntAmt[i] != null)
					model.setCrntAmt(crntAmt[i]);
				if (porArOfcCd[i] != null)
					model.setPorArOfcCd(porArOfcCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (ffCheck[i] != null)
					model.setFfCheck(ffCheck[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (agnDivFlg[i] != null)
					model.setAgnDivFlg(agnDivFlg[i]);
				if (polArOfcCd[i] != null)
					model.setPolArOfcCd(polArOfcCd[i]);
				if (scCtrtOfcCd[i] != null)
					model.setScCtrtOfcCd(scCtrtOfcCd[i]);
				if (podArOfcCd[i] != null)
					model.setPodArOfcCd(podArOfcCd[i]);
				if (polApOfcCd[i] != null)
					model.setPolApOfcCd(polApOfcCd[i]);
				if (bkgShprOwnrFlg[i] != null)
					model.setBkgShprOwnrFlg(bkgShprOwnrFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgArOfcCd[i] != null)
					model.setBkgArOfcCd(bkgArOfcCd[i]);
				if (ffCmpnSeq[i] != null)
					model.setFfCmpnSeq(ffCmpnSeq[i]);
				if (bkgFfSeq[i] != null)
					model.setBkgFfSeq(bkgFfSeq[i]);
				if (delContiCd[i] != null)
					model.setDelContiCd(delContiCd[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (polScontiCd[i] != null)
					model.setPolScontiCd(polScontiCd[i]);
				if (mdmCustTpCd[i] != null)
					model.setMdmCustTpCd(mdmCustTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFFBookingInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFFBookingInfoVO[]
	 */
	public SearchFFBookingInfoVO[] getSearchFFBookingInfoVOs(){
		SearchFFBookingInfoVO[] vos = (SearchFFBookingInfoVO[])models.toArray(new SearchFFBookingInfoVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delApOfcCd = this.delApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffChgAmt = this.ffChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg0507 = this.flg0507 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFfCmpnSeq = this.newFfCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkEtdDt = this.trunkEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclDgCgoFlg = this.spclDgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dblBkgFlg = this.dblBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgArOfcCd = this.chgArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcAgnCd = this.bkgOfcAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntCd = this.polCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBbCgoFlg = this.spclBbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdOfcCdChgYn = this.ppdOfcCdChgYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFincCtrlOfcCd = this.porFincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFincCtrlOfcCd = this.bkgFincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porContiCd = this.porContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bslDelApOfcCd = this.bslDelApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podScontiCd = this.podScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnStsCd = this.ffCmpnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCalcAmt = this.ffCalcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSlsOfcCd = this.bkgSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shFfCheckFlag = this.shFfCheckFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeq = this.ffCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSvcScpCd = this.bkgSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAwkCgoFlg = this.spclAwkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFeuQty = this.ffFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bslDelOfcCd = this.bslDelOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bslDelArOfcCd = this.bslDelArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podContiCd = this.podContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldFfSeq = this.oldFfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRtOfcCd = this.facRtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porSteCd = this.porSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffOfcCd = this.ffOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustSeq = this.shprCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFmcCheckFlag = this.ffFmcCheckFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnRmk = this.ffCmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.referenceNo = this.referenceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRgnCd = this.delRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeqTmp = this.ffCustSeqTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFincCtrlOfcCd = this.podFincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcLocCd = this.bkgOfcLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSteCd = this.polSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delArOfcCd = this.delArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFfCntCd = this.bkgFfCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delScontiCd = this.delScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coveredCheck = this.coveredCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRgnCd = this.podRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntSeq = this.vndrCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSteCd = this.delSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFincCtrlOfcCd = this.polFincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgApOfcCd = this.chgApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSumIfAmt = this.oldSumIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calAgnDivFlg = this.calAgnDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffDivCd1 = this.ffDivCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntCd = this.podCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldFfCntCd = this.oldFfCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd = this.polContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRgnCd = this.porRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porScontiCd = this.porScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgPpdOfcCd = this.chgPpdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRcFlg = this.spclRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFincCtrlOfcCd = this.delFincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCheck = this.svcScpCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSteCd = this.podSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffTeuQty = this.ffTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podApOfcCd = this.podApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porApOfcCd = this.porApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRgnCd = this.polRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAmt = this.crntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porArOfcCd = this.porArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCheck = this.ffCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnDivFlg = this.agnDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polArOfcCd = this.polArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCtrtOfcCd = this.scCtrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podArOfcCd = this.podArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polApOfcCd = this.polApOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgShprOwnrFlg = this.bkgShprOwnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgArOfcCd = this.bkgArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnSeq = this.ffCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFfSeq = this.bkgFfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delContiCd = this.delContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polScontiCd = this.polScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmCustTpCd = this.mdmCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
