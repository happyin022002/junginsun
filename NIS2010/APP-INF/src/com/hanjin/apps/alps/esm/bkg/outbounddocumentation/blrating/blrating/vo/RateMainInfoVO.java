/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RateMainInfoVO.java
*@FileTitle : RateMainInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.03.09 이진서 
* 1.0 Creation
* 2011.03.03 정선용 [CHM-201109023-01] Booking 의 Volumn 과 Container Volumn 이 일치 하지 않는 경우 Application Date 를 빨강색으로 표시
* 2013.01.28 김진주 [CHM-201322629] [오토레이팅 보완] TXS surcharge 로직 추가 (=WSC 동일) 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RateMainInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RateMainInfoVO> models = new ArrayList<RateMainInfoVO>();
	
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String rtBlTpCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String rpPropStsCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo1 = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String scNo2 = null;
	/* Column Info */
	private String audStsCd = null;
	/* Column Info */
	private String prcGenSpclRtTpCd = null;
	/* Column Info */
	private String cobizAuthNo = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String prcRtMtchPattCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String ppdPayrCustSeq = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String mstCvrdBl = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String ppdRcvOfcCd = null;
	/* Column Info */
	private String bkgRtWhfExptCd = null;
	/* Column Info */
	private String ppdPayrCntCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String prcCmdtHdrSeq = null;
	/* Column Info */
	private String spPropStsCd = null;
	/* Column Info */
	private String cltPayrCustSeq = null;
	/* Column Info */
	private String rfaYn = null;
	/* Column Info */
	private String cltPayrCntCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtBlTpCdOld = null;
	/* Column Info */
	private String bkgSvcScpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String rmarkYn = null;
	/* Column Info */
	private String prcRoutSeq = null;
	/* Column Info */
	private String trfLnrItmNo = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String audPrfmFlg = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String brkDwnFlg = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String blCvrdTpCd = null;
	/* Column Info */
	private String volDiffFlg = null;
	/* Column Info */
	private String wscFlg = null;
	/* Column Info */
	private String txsFlg = null;
	/* Column Info */
	private String cntrWgtCmplFlg = null;
	/* Column Info */
	private String cdrFlg = null;
	/* Column Info */
	private String rwtFlg = null;
	/* Column Info */
	private String calcCtrtTpCd = null;
	/* Column Info */
	private String dhfLocCd = null;
	/* Column Info */
	private String ddcCurrCd = null;
	/* Column Info */
	private String jordanDesc = null;
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* Column Info */
	private String scNoOld = null;
	/* Column Info */
	private String rfaNoOld = null;
	/* Column Info */
	private String taaNoOld = null;
	/* Column Info */
	private String rtroFlg = null;
	/* Column Info */
	private String rtroKndCd = null;
	/* Column Info */
	private String oftAmdablFlg = null;
	/* Column Info */
	private String oldOftAmt = null;
	/* Column Info */
	private String dhfCurrCd = null;
	/* Column Info */
	private String mstRfaRoutId = null;
	/* Column Info */
	private String docInterRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RateMainInfoVO() {}

	public RateMainInfoVO(String ibflag, String pagerows, String svcScpCd, String rtAplyDt, String rtBlTpCd, String rtBlTpCdOld, String cltOfcCd, String rpPropStsCd, String blNo, String polCd, String scNo1, String userId, String scNo2, String wgtUtCd, String audStsCd, String prcGenSpclRtTpCd, String cobizAuthNo, String preRlyPortCd, String repCmdtNm, String frtTermCd, String delCd, String podCd, String bkgNo, String prcRtMtchPattCd, String rcFlg, String cntrPrtFlg, String ppdPayrCustSeq, String pstRlyPortCd, String mstCvrdBl, String porCd, String ppdRcvOfcCd, String bkgRtWhfExptCd, String ppdPayrCntCd, String custNm, String bkgStsCd, String prcCmdtHdrSeq, String spPropStsCd, String cltPayrCustSeq, String rfaYn, String cltPayrCntCd, String rfaNo, String bkgSvcScpCd, String cmdtCd, String cstmsDesc, String measQty, String bkgCtrtTpCd, String rcvTermCd, String measUtCd, String rmarkYn, String prcRoutSeq, String trfLnrItmNo, String cmdtNm, String actWgt, String blTpCd, String deTermCd, String taaNo, String audPrfmFlg, String brkDwnFlg, String hngrFlg, String special, String repCmdtCd, String blCvrdTpCd, String volDiffFlg, String wscFlg, String txsFlg, String cntrWgtCmplFlg, String cdrFlg, String rwtFlg, String calcCtrtTpCd, String dhfLocCd, String ddcCurrCd, String jordanDesc, String orgTrnsModCd, String destTrnsModCd, String scNoOld, String rfaNoOld, String taaNoOld, String rtroFlg, String rtroKndCd, String oftAmdablFlg, String oldOftAmt, String dhfCurrCd, String mstRfaRoutId, String docInterRmk) {
		this.svcScpCd = svcScpCd;
		this.rtAplyDt = rtAplyDt;
		this.rtBlTpCd = rtBlTpCd;
		this.cltOfcCd = cltOfcCd;
		this.rpPropStsCd = rpPropStsCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.scNo1 = scNo1;
		this.wgtUtCd = wgtUtCd;
		this.userId = userId;
		this.scNo2 = scNo2;
		this.audStsCd = audStsCd;
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
		this.cobizAuthNo = cobizAuthNo;
		this.preRlyPortCd = preRlyPortCd;
		this.repCmdtNm = repCmdtNm;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.prcRtMtchPattCd = prcRtMtchPattCd;
		this.rcFlg = rcFlg;
		this.cntrPrtFlg = cntrPrtFlg;
		this.ppdPayrCustSeq = ppdPayrCustSeq;
		this.pstRlyPortCd = pstRlyPortCd;
		this.mstCvrdBl = mstCvrdBl;
		this.porCd = porCd;
		this.ppdRcvOfcCd = ppdRcvOfcCd;
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
		this.ppdPayrCntCd = ppdPayrCntCd;
		this.custNm = custNm;
		this.bkgStsCd = bkgStsCd;
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
		this.spPropStsCd = spPropStsCd;
		this.cltPayrCustSeq = cltPayrCustSeq;
		this.rfaYn = rfaYn;
		this.cltPayrCntCd = cltPayrCntCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.rtBlTpCdOld = rtBlTpCdOld;
		this.bkgSvcScpCd = bkgSvcScpCd;
		this.cmdtCd = cmdtCd;
		this.cstmsDesc = cstmsDesc;
		this.measQty = measQty;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.rcvTermCd = rcvTermCd;
		this.measUtCd = measUtCd;
		this.rmarkYn = rmarkYn;
		this.prcRoutSeq = prcRoutSeq;
		this.trfLnrItmNo = trfLnrItmNo;
		this.cmdtNm = cmdtNm;
		this.blTpCd = blTpCd;
		this.actWgt = actWgt;
		this.deTermCd = deTermCd;
		this.audPrfmFlg = audPrfmFlg;
		this.taaNo = taaNo;
		this.brkDwnFlg = brkDwnFlg;
		this.hngrFlg = hngrFlg;
		this.special = special;
		this.repCmdtCd = repCmdtCd;
		this.blCvrdTpCd = blCvrdTpCd;
		this.volDiffFlg= volDiffFlg;
		this.wscFlg = wscFlg;
		this.txsFlg = txsFlg;
		this.cntrWgtCmplFlg = cntrWgtCmplFlg;
		this.cdrFlg = cdrFlg;
		this.rwtFlg = rwtFlg;
		this.calcCtrtTpCd = calcCtrtTpCd;
		this.dhfLocCd = dhfLocCd;
		this.ddcCurrCd = ddcCurrCd;
		this.jordanDesc = jordanDesc;
		this.orgTrnsModCd = orgTrnsModCd;
		this.destTrnsModCd = destTrnsModCd;
		this.scNoOld = scNoOld;
		this.rfaNoOld = rfaNoOld;
		this.taaNoOld = taaNoOld;
		this.rtroFlg = rtroFlg;
		this.rtroKndCd = rtroKndCd;
		this.oftAmdablFlg = oftAmdablFlg;
		this.oldOftAmt = oldOftAmt;
		this.dhfCurrCd = dhfCurrCd;
		this.mstRfaRoutId = mstRfaRoutId;
		this.docInterRmk = docInterRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rt_bl_tp_cd", getRtBlTpCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("rp_prop_sts_cd", getRpPropStsCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no1", getScNo1());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("sc_no2", getScNo2());
		this.hashColumns.put("aud_sts_cd", getAudStsCd());
		this.hashColumns.put("prc_gen_spcl_rt_tp_cd", getPrcGenSpclRtTpCd());
		this.hashColumns.put("cobiz_auth_no", getCobizAuthNo());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prc_rt_mtch_patt_cd", getPrcRtMtchPattCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ppd_payr_cust_seq", getPpdPayrCustSeq());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("mst_cvrd_bl", getMstCvrdBl());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("ppd_rcv_ofc_cd", getPpdRcvOfcCd());
		this.hashColumns.put("bkg_rt_whf_expt_cd", getBkgRtWhfExptCd());
		this.hashColumns.put("ppd_payr_cnt_cd", getPpdPayrCntCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
		this.hashColumns.put("sp_prop_sts_cd", getSpPropStsCd());
		this.hashColumns.put("clt_payr_cust_seq", getCltPayrCustSeq());
		this.hashColumns.put("rfa_yn", getRfaYn());
		this.hashColumns.put("clt_payr_cnt_cd", getCltPayrCntCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_bl_tp_cd_old", getRtBlTpCdOld());
		this.hashColumns.put("bkg_svc_scp_cd", getBkgSvcScpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("rmark_yn", getRmarkYn());
		this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
		this.hashColumns.put("trf_lnr_itm_no", getTrfLnrItmNo());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("aud_prfm_flg", getAudPrfmFlg());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("brk_dwn_flg", getBrkDwnFlg());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("bl_cvrd_tp_cd", getBlCvrdTpCd());
		this.hashColumns.put("vol_diff_flg", getVolDiffFlg());
		this.hashColumns.put("wsc_flg", getWscFlg());
		this.hashColumns.put("txs_flg", getTxsFlg());
		this.hashColumns.put("cntr_wgt_cmpl_flg", getCntrWgtCmplFlg());
		this.hashColumns.put("cdr_flg", getCdrFlg());
		this.hashColumns.put("rwt_flg", getRwtFlg());
		this.hashColumns.put("calc_ctrt_tp_cd", getCalcCtrtTpCd());
		this.hashColumns.put("dhf_loc_cd", getDhfLocCd());
		this.hashColumns.put("ddc_curr_cd", getDdcCurrCd());
		this.hashColumns.put("jordan_desc", getJordanDesc());
		this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		this.hashColumns.put("sc_no_old", getScNoOld());
		this.hashColumns.put("rfa_no_old", getRfaNoOld());
		this.hashColumns.put("taa_no_old", getTaaNoOld());
		this.hashColumns.put("rtro_flg", getRtroFlg());
		this.hashColumns.put("rtro_knd_cd", getRtroKndCd());
		this.hashColumns.put("oft_amdabl_flg", getOftAmdablFlg());
		this.hashColumns.put("old_oft_amt", getOldOftAmt());
		this.hashColumns.put("dhf_curr_cd", getDhfCurrCd());
		this.hashColumns.put("mst_rfa_rout_id", getMstRfaRoutId());
		this.hashColumns.put("doc_inter_rmk", getDocInterRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rt_bl_tp_cd", "rtBlTpCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("rp_prop_sts_cd", "rpPropStsCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no1", "scNo1");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("sc_no2", "scNo2");
		this.hashFields.put("aud_sts_cd", "audStsCd");
		this.hashFields.put("prc_gen_spcl_rt_tp_cd", "prcGenSpclRtTpCd");
		this.hashFields.put("cobiz_auth_no", "cobizAuthNo");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prc_rt_mtch_patt_cd", "prcRtMtchPattCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ppd_payr_cust_seq", "ppdPayrCustSeq");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("mst_cvrd_bl", "mstCvrdBl");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ppd_rcv_ofc_cd", "ppdRcvOfcCd");
		this.hashFields.put("bkg_rt_whf_expt_cd", "bkgRtWhfExptCd");
		this.hashFields.put("ppd_payr_cnt_cd", "ppdPayrCntCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
		this.hashFields.put("sp_prop_sts_cd", "spPropStsCd");
		this.hashFields.put("clt_payr_cust_seq", "cltPayrCustSeq");
		this.hashFields.put("rfa_yn", "rfaYn");
		this.hashFields.put("clt_payr_cnt_cd", "cltPayrCntCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_bl_tp_cd_old", "rtBlTpCdOld");
		this.hashFields.put("bkg_svc_scp_cd", "bkgSvcScpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("rmark_yn", "rmarkYn");
		this.hashFields.put("prc_rout_seq", "prcRoutSeq");
		this.hashFields.put("trf_lnr_itm_no", "trfLnrItmNo");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("aud_prfm_flg", "audPrfmFlg");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("brk_dwn_flg", "brkDwnFlg");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("special", "special");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("bl_cvrd_tp_cd", "blCvrdTpCd");
		this.hashFields.put("vol_diff_flg", "volDiffFlg");
		this.hashFields.put("wsc_flg", "wscFlg");
		this.hashFields.put("txs_flg", "txsFlg");
		this.hashFields.put("cntr_wgt_cmpl_flg", "cntrWgtCmplFlg");
		this.hashFields.put("cdr_flg", "cdrFlg");
		this.hashFields.put("rwt_flg", "rwtFlg");
		this.hashFields.put("calc_ctrt_tp_cd", "calcCtrtTpCd");
		this.hashFields.put("dhf_loc_cd", "dhfLocCd");
		this.hashFields.put("ddc_curr_cd", "ddcCurrCd");
		this.hashFields.put("jordan_desc", "jordanDesc");
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("sc_no_old", "scNoOld");
		this.hashFields.put("rfa_no_old", "rfaNoOld");
		this.hashFields.put("taa_no_old", "taaNoOld");
		this.hashFields.put("rtro_flg", "rtroFlg");
		this.hashFields.put("rtro_knd_cd", "rtroKndCd");
		this.hashFields.put("oft_amdabl_flg", "oftAmdablFlg");
		this.hashFields.put("old_oft_amt", "oldOftAmt");
		this.hashFields.put("dhf_curr_cd", "dhfCurrCd");
		this.hashFields.put("mst_rfa_rout_id", "mstRfaRoutId");
		this.hashFields.put("doc_inter_rmk", "docInterRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return rtBlTpCd
	 */
	public String getRtBlTpCd() {
		return this.rtBlTpCd;
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
	 * @return docInterRmk
	 */
	public String getDocInterRmk() {
		return this.docInterRmk;
	}
	
	
	/**
	 * Column Info
	 * @return mstRfaRoutId
	 */
	public String getMstRfaRoutId() {
		return this.mstRfaRoutId;
	}
	
	/**
	 * Column Info
	 * @return rpPropStsCd
	 */
	public String getRpPropStsCd() {
		return this.rpPropStsCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return scNo1
	 */
	public String getScNo1() {
		return this.scNo1;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return scNo2
	 */
	public String getScNo2() {
		return this.scNo2;
	}
	
	/**
	 * Column Info
	 * @return audStsCd
	 */
	public String getAudStsCd() {
		return this.audStsCd;
	}
	
	/**
	 * Column Info
	 * @return prcGenSpclRtTpCd
	 */
	public String getPrcGenSpclRtTpCd() {
		return this.prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return cobizAuthNo
	 */
	public String getCobizAuthNo() {
		return this.cobizAuthNo;
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
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return prcRtMtchPattCd
	 */
	public String getPrcRtMtchPattCd() {
		return this.prcRtMtchPattCd;
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
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return ppdPayrCustSeq
	 */
	public String getPpdPayrCustSeq() {
		return this.ppdPayrCustSeq;
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
	 * @return mstCvrdBl
	 */
	public String getMstCvrdBl() {
		return this.mstCvrdBl;
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
	 * @return ppdRcvOfcCd
	 */
	public String getPpdRcvOfcCd() {
		return this.ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRtWhfExptCd
	 */
	public String getBkgRtWhfExptCd() {
		return this.bkgRtWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @return ppdPayrCntCd
	 */
	public String getPpdPayrCntCd() {
		return this.ppdPayrCntCd;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtHdrSeq
	 */
	public String getPrcCmdtHdrSeq() {
		return this.prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return spPropStsCd
	 */
	public String getSpPropStsCd() {
		return this.spPropStsCd;
	}
	
	/**
	 * Column Info
	 * @return cltPayrCustSeq
	 */
	public String getCltPayrCustSeq() {
		return this.cltPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaYn
	 */
	public String getRfaYn() {
		return this.rfaYn;
	}
	
	/**
	 * Column Info
	 * @return cltPayrCntCd
	 */
	public String getCltPayrCntCd() {
		return this.cltPayrCntCd;
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
	 * @return rtBlTpCdOld
	 */
	public String getRtBlTpCdOld() {
		return this.rtBlTpCdOld;
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
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return rmarkYn
	 */
	public String getRmarkYn() {
		return this.rmarkYn;
	}
	
	/**
	 * Column Info
	 * @return prcRoutSeq
	 */
	public String getPrcRoutSeq() {
		return this.prcRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return trfLnrItmNo
	 */
	public String getTrfLnrItmNo() {
		return this.trfLnrItmNo;
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
	 * @return dhfCurrCd
	 */
	public String getDhfCurrCd() {
		return this.dhfCurrCd;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return audPrfmFlg
	 */
	public String getAudPrfmFlg() {
		return this.audPrfmFlg;
	}
	
	/**
	 * Column Info
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return brkDwnFlg
	 */
	public String getBrkDwnFlg() {
		return this.brkDwnFlg;
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
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
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
	 * @return blCvrdTpCd
	 */
	public String getBlCvrdTpCd() {
		return this.blCvrdTpCd;
	}
	/**
	 * Column Info
	 * @return volDiffFlg
	 */
	public String getVolDiffFlg() {
		return volDiffFlg;
	}
	/**
	 * Column Info
	 * @return wscFlg
	 */	
	public String getWscFlg() {
		return wscFlg;
	}

	/**
	 * Column Info
	 * @return txsFlg
	 */	
	public String getTxsFlg() {
		return txsFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtCmplFlg
	 */	
	public String getCntrWgtCmplFlg() {
		return cntrWgtCmplFlg;
	}
	
	/**
	 * Column Info
	 * @return cdrFlg
	 */	
	public String getCdrFlg() {
		return cdrFlg;
	}
	
	/**
	 * Column Info
	 * @return rwtFlg
	 */	
	public String getRwtFlg() {
		return rwtFlg;
	}
	
	/**
	 * Column Info
	 * @return calcCtrtTpCd
	 */
	public String getCalcCtrtTpCd() {
		return this.calcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return dhfLocCd
	 */
	public String getDhfLocCd() {
		return this.dhfLocCd;
	}
	
	/**
	 * Column Info
	 * @return ddcCurrCd
	 */
	public String getDdcCurrCd() {
		return this.ddcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return jordanDesc
	 */
	public String getJordanDesc() {
		return this.jordanDesc;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsModCd
	 */
	public String getOrgTrnsModCd() {
		return this.orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return scNoOld
	 */
	public String getScNoOld() {
		return this.scNoOld;
	}
	
	/**
	 * Column Info
	 * @return rfaNoOld
	 */
	public String getRfaNoOld() {
		return this.rfaNoOld;
	}
	
	/**
	 * Column Info
	 * @return taaNoOld
	 */
	public String getTaaNoOld() {
		return this.taaNoOld;
	}
	
	/**
	 * Column Info
	 * @return rtroFlg
	 */
	public String getRtroFlg() {
		return this.rtroFlg;
	}
	
	/**
	 * Column Info
	 * @return rtroKndCd
	 */
	public String getRtroKndCd() {
		return this.rtroKndCd;
	}
	
	/**
	 * Column Info
	 * @return oftAmdablFlg
	 */
	public String getOftAmdablFlg() {
		return this.oftAmdablFlg;
	}
	
	/**
	 * Column Info
	 * @return oldOftAmt
	 */
	public String getOldOftAmt() {
		return this.oldOftAmt;
	}


	/**
	 * Column Info
	 * @param volDiffFlg
	 */
	public void setVolDiffFlg(String volDiffFlg) {
		this.volDiffFlg = volDiffFlg;
	}

	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param mstRfaRoutId
	 */
	public void setMstRfaRoutId(String mstRfaRoutId) {
		this.mstRfaRoutId = mstRfaRoutId;
	}
	
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param rtBlTpCd
	 */
	public void setRtBlTpCd(String rtBlTpCd) {
		this.rtBlTpCd = rtBlTpCd;
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
	 * @param rpPropStsCd
	 */
	public void setRpPropStsCd(String rpPropStsCd) {
		this.rpPropStsCd = rpPropStsCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param scNo1
	 */
	public void setScNo1(String scNo1) {
		this.scNo1 = scNo1;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param scNo2
	 */
	public void setScNo2(String scNo2) {
		this.scNo2 = scNo2;
	}
	
	/**
	 * Column Info
	 * @param audStsCd
	 */
	public void setAudStsCd(String audStsCd) {
		this.audStsCd = audStsCd;
	}
	
	/**
	 * Column Info
	 * @param docInterRmk
	 */
	public void setDocInterRmk(String docInterRmk) {
		this.docInterRmk = docInterRmk;
	}
	
	/**
	 * Column Info
	 * @param prcGenSpclRtTpCd
	 */
	public void setPrcGenSpclRtTpCd(String prcGenSpclRtTpCd) {
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param cobizAuthNo
	 */
	public void setCobizAuthNo(String cobizAuthNo) {
		this.cobizAuthNo = cobizAuthNo;
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
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param prcRtMtchPattCd
	 */
	public void setPrcRtMtchPattCd(String prcRtMtchPattCd) {
		this.prcRtMtchPattCd = prcRtMtchPattCd;
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
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param ppdPayrCustSeq
	 */
	public void setPpdPayrCustSeq(String ppdPayrCustSeq) {
		this.ppdPayrCustSeq = ppdPayrCustSeq;
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
	 * @param mstCvrdBl
	 */
	public void setMstCvrdBl(String mstCvrdBl) {
		this.mstCvrdBl = mstCvrdBl;
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
	 * @param dhfCurrCd
	 */
	public void setDhfCurrCd(String dhfCurrCd) {
		this.dhfCurrCd = dhfCurrCd;
	}
	
	
	/**
	 * Column Info
	 * @param ppdRcvOfcCd
	 */
	public void setPpdRcvOfcCd(String ppdRcvOfcCd) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRtWhfExptCd
	 */
	public void setBkgRtWhfExptCd(String bkgRtWhfExptCd) {
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @param ppdPayrCntCd
	 */
	public void setPpdPayrCntCd(String ppdPayrCntCd) {
		this.ppdPayrCntCd = ppdPayrCntCd;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtHdrSeq
	 */
	public void setPrcCmdtHdrSeq(String prcCmdtHdrSeq) {
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param spPropStsCd
	 */
	public void setSpPropStsCd(String spPropStsCd) {
		this.spPropStsCd = spPropStsCd;
	}
	
	/**
	 * Column Info
	 * @param cltPayrCustSeq
	 */
	public void setCltPayrCustSeq(String cltPayrCustSeq) {
		this.cltPayrCustSeq = cltPayrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaYn
	 */
	public void setRfaYn(String rfaYn) {
		this.rfaYn = rfaYn;
	}
	
	/**
	 * Column Info
	 * @param cltPayrCntCd
	 */
	public void setCltPayrCntCd(String cltPayrCntCd) {
		this.cltPayrCntCd = cltPayrCntCd;
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
	 * @param rtBlTpCdOld
	 */
	public void setRtBlTpCdOld(String rtBlTpCdOld) {
		this.rtBlTpCdOld = rtBlTpCdOld;
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
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param rmarkYn
	 */
	public void setRmarkYn(String rmarkYn) {
		this.rmarkYn = rmarkYn;
	}
	
	/**
	 * Column Info
	 * @param prcRoutSeq
	 */
	public void setPrcRoutSeq(String prcRoutSeq) {
		this.prcRoutSeq = prcRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param trfLnrItmNo
	 */
	public void setTrfLnrItmNo(String trfLnrItmNo) {
		this.trfLnrItmNo = trfLnrItmNo;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param audPrfmFlg
	 */
	public void setAudPrfmFlg(String audPrfmFlg) {
		this.audPrfmFlg = audPrfmFlg;
	}
	
	/**
	 * Column Info
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}
	
	/**
	 * Column Info
	 * @param brkDwnFlg
	 */
	public void setBrkDwnFlg(String brkDwnFlg) {
		this.brkDwnFlg = brkDwnFlg;
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
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
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
	 * @param blCvrdTpCd
	 */
	public void setBlCvrdTpCd(String blCvrdTpCd) {
		this.blCvrdTpCd = blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param wscFlg
	 */
	public void setWscFlg(String wscFlg) {
		this.wscFlg = wscFlg;
	}
	
	/**
	 * Column Info
	 * @param txsFlg
	 */
	public void setTxsFlg(String txsFlg) {
		this.txsFlg = txsFlg;
	}
	
	/**
	 * Column Info
	 * @param cdrFlg
	 */
	public void setCdrFlg(String cdrFlg) {
		this.cdrFlg = cdrFlg;
	}
	
	/**
	 * Column Info
	 * @param rwtFlg
	 */
	public void setRwtFlg(String rwtFlg) {
		this.rwtFlg = rwtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtCmplFlg
	 */
	public void setCntrWgtCmplFlg(String cntrWgtCmplFlg) {
		this.cntrWgtCmplFlg = cntrWgtCmplFlg;
	}
	
	/**
	 * Column Info
	 * @param calcCtrtTpCd
	 */
	public void setCalcCtrtTpCd(String calcCtrtTpCd) {
		this.calcCtrtTpCd = calcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param dhfLocCd
	 */
	public void setDhfLocCd(String dhfLocCd) {
		this.dhfLocCd = dhfLocCd;
	}
	
	/**
	 * Column Info
	 * @param ddcCurrCd
	 */
	public void setDdcCurrCd(String ddcCurrCd) {
		this.ddcCurrCd = ddcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param jordanDesc
	 */
	public void setJordanDesc(String jordanDesc) {
		this.jordanDesc = jordanDesc;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsModCd
	 */
	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param scNoOld
	 */
	public void setScNoOld(String scNoOld) {
		this.scNoOld = scNoOld;
	}
	
	/**
	 * Column Info
	 * @param rfaNoOld
	 */
	public void setRfaNoOld(String rfaNoOld) {
		this.rfaNoOld = rfaNoOld;
	}
	
	/**
	 * Column Info
	 * @param taaNoOld
	 */
	public void setTaaNoOld(String taaNoOld) {
		this.taaNoOld = taaNoOld;
	}
	
	/**
	 * Column Info
	 * @param rtroFlg
	 */
	public void setRtroFlg(String rtroFlg) {
		this.rtroFlg = rtroFlg;
	}
	
	/**
	 * Column Info
	 * @param rtroKndCd
	 */
	public void setRtroKndCd(String rtroKndCd) {
		this.rtroKndCd = rtroKndCd;
	}
	
	/**
	 * Column Info
	 * @param oftAmdablFlg
	 */
	public void setOftAmdablFlg(String oftAmdablFlg) {
		this.oftAmdablFlg = oftAmdablFlg;
	}
	
	/**
	 * Column Info
	 * @param oldOftAmt
	 */
	public void setOldOftAmt(String oldOftAmt) {
		this.oldOftAmt = oldOftAmt;
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
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setRtBlTpCd(JSPUtil.getParameter(request, prefix + "rt_bl_tp_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setRpPropStsCd(JSPUtil.getParameter(request, prefix + "rp_prop_sts_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setScNo1(JSPUtil.getParameter(request, prefix + "sc_no1", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setScNo2(JSPUtil.getParameter(request, prefix + "sc_no2", ""));
		setAudStsCd(JSPUtil.getParameter(request, prefix + "aud_sts_cd", ""));
		setPrcGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "prc_gen_spcl_rt_tp_cd", ""));
		setCobizAuthNo(JSPUtil.getParameter(request, prefix + "cobiz_auth_no", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPrcRtMtchPattCd(JSPUtil.getParameter(request, prefix + "prc_rt_mtch_patt_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setPpdPayrCustSeq(JSPUtil.getParameter(request, prefix + "ppd_payr_cust_seq", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setMstCvrdBl(JSPUtil.getParameter(request, prefix + "mst_cvrd_bl", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPpdRcvOfcCd(JSPUtil.getParameter(request, prefix + "ppd_rcv_ofc_cd", ""));
		setBkgRtWhfExptCd(JSPUtil.getParameter(request, prefix + "bkg_rt_whf_expt_cd", ""));
		setPpdPayrCntCd(JSPUtil.getParameter(request, prefix + "ppd_payr_cnt_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPrcCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "prc_cmdt_hdr_seq", ""));
		setSpPropStsCd(JSPUtil.getParameter(request, prefix + "sp_prop_sts_cd", ""));
		setCltPayrCustSeq(JSPUtil.getParameter(request, prefix + "clt_payr_cust_seq", ""));
		setRfaYn(JSPUtil.getParameter(request, prefix + "rfa_yn", ""));
		setCltPayrCntCd(JSPUtil.getParameter(request, prefix + "clt_payr_cnt_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtBlTpCdOld(JSPUtil.getParameter(request, prefix + "rt_bl_tp_cd_old", ""));
		setBkgSvcScpCd(JSPUtil.getParameter(request, prefix + "bkg_svc_scp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setRmarkYn(JSPUtil.getParameter(request, prefix + "rmark_yn", ""));
		setPrcRoutSeq(JSPUtil.getParameter(request, prefix + "prc_rout_seq", ""));
		setTrfLnrItmNo(JSPUtil.getParameter(request, prefix + "trf_lnr_itm_no", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setAudPrfmFlg(JSPUtil.getParameter(request, prefix + "aud_prfm_flg", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setBrkDwnFlg(JSPUtil.getParameter(request, prefix + "brk_dwn_flg", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setSpecial(JSPUtil.getParameter(request, prefix + "special", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setBlCvrdTpCd(JSPUtil.getParameter(request, prefix + "bl_cvrd_tp_cd", ""));
		setVolDiffFlg(JSPUtil.getParameter(request, prefix + "vol_diff_flg", ""));
		setWscFlg(JSPUtil.getParameter(request, prefix + "wsc_flg", ""));
		setTxsFlg(JSPUtil.getParameter(request, prefix + "txs_flg", ""));
		setCntrWgtCmplFlg(JSPUtil.getParameter(request, prefix + "cntr_wgt_cmpl_flg", ""));
		setCdrFlg(JSPUtil.getParameter(request, prefix + "cdr_flg", ""));
		setRwtFlg(JSPUtil.getParameter(request, prefix + "rwt_flg", ""));
		setCalcCtrtTpCd(JSPUtil.getParameter(request, prefix + "calc_ctrt_tp_cd", ""));
		setDhfLocCd(JSPUtil.getParameter(request, prefix + "dhf_loc_cd", ""));
		setDdcCurrCd(JSPUtil.getParameter(request, prefix + "ddc_curr_cd", ""));
		setJordanDesc(JSPUtil.getParameter(request, prefix + "jordan_desc", ""));
		setOrgTrnsModCd(JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
		setScNoOld(JSPUtil.getParameter(request, prefix + "sc_no_old", ""));
		setRfaNoOld(JSPUtil.getParameter(request, prefix + "rfa_no_old", ""));
		setTaaNoOld(JSPUtil.getParameter(request, prefix + "taa_no_old", ""));
		setRtroFlg(JSPUtil.getParameter(request, prefix + "rtro_flg", ""));
		setRtroKndCd(JSPUtil.getParameter(request, prefix + "rtro_knd_cd", ""));
		setOftAmdablFlg(JSPUtil.getParameter(request, prefix + "oft_amdabl_flg", ""));
		setOldOftAmt(JSPUtil.getParameter(request, prefix + "old_oft_amt", ""));
		setDhfCurrCd(JSPUtil.getParameter(request, prefix + "dhf_curr_cd", ""));
		setMstRfaRoutId(JSPUtil.getParameter(request, prefix + "mst_rfa_rout_id", ""));
		setDocInterRmk(JSPUtil.getParameter(request, prefix + "doc_inter_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RateMainInfoVO[]
	 */
	public RateMainInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RateMainInfoVO[]
	 */
	public RateMainInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RateMainInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] rtBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] rpPropStsCd = (JSPUtil.getParameter(request, prefix	+ "rp_prop_sts_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo1 = (JSPUtil.getParameter(request, prefix	+ "sc_no1", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] scNo2 = (JSPUtil.getParameter(request, prefix	+ "sc_no2", length));
			String[] audStsCd = (JSPUtil.getParameter(request, prefix	+ "aud_sts_cd", length));
			String[] prcGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_gen_spcl_rt_tp_cd", length));
			String[] cobizAuthNo = (JSPUtil.getParameter(request, prefix	+ "cobiz_auth_no", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] prcRtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] ppdPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "ppd_payr_cust_seq", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] mstCvrdBl = (JSPUtil.getParameter(request, prefix	+ "mst_cvrd_bl", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] ppdRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_ofc_cd", length));
			String[] bkgRtWhfExptCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rt_whf_expt_cd", length));
			String[] ppdPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "ppd_payr_cnt_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_hdr_seq", length));
			String[] spPropStsCd = (JSPUtil.getParameter(request, prefix	+ "sp_prop_sts_cd", length));
			String[] cltPayrCustSeq = (JSPUtil.getParameter(request, prefix	+ "clt_payr_cust_seq", length));
			String[] rfaYn = (JSPUtil.getParameter(request, prefix	+ "rfa_yn", length));
			String[] cltPayrCntCd = (JSPUtil.getParameter(request, prefix	+ "clt_payr_cnt_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtBlTpCdOld = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_cd_old", length));
			String[] bkgSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_svc_scp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] rmarkYn = (JSPUtil.getParameter(request, prefix	+ "rmark_yn", length));
			String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rout_seq", length));
			String[] trfLnrItmNo = (JSPUtil.getParameter(request, prefix	+ "trf_lnr_itm_no", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] audPrfmFlg = (JSPUtil.getParameter(request, prefix	+ "aud_prfm_flg", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] brkDwnFlg = (JSPUtil.getParameter(request, prefix	+ "brk_dwn_flg", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] blCvrdTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_cvrd_tp_cd", length));
			String[] volDiffFlg = (JSPUtil.getParameter(request, prefix	+ "vol_diff_flg", length));
			String[] wscFlg = (JSPUtil.getParameter(request, prefix	+ "wsc_flg", length));
			String[] txsFlg = (JSPUtil.getParameter(request, prefix	+ "txs_flg", length));
			String[] cntrWgtCmplFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_cmpl_flg", length));
			String[] cdrFlg = (JSPUtil.getParameter(request, prefix	+ "cdr_flg", length));
			String[] rwtFlg = (JSPUtil.getParameter(request, prefix	+ "rwt_flg", length));
			String[] calcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_ctrt_tp_cd", length));
			String[] dhfLocCd = (JSPUtil.getParameter(request, prefix	+ "dhf_loc_cd", length));
			String[] ddcCurrCd = (JSPUtil.getParameter(request, prefix	+ "ddc_curr_cd", length));
			String[] jordanDesc = (JSPUtil.getParameter(request, prefix	+ "jordan_desc", length));
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] scNoOld = (JSPUtil.getParameter(request, prefix	+ "sc_no_old", length));
			String[] rfaNoOld = (JSPUtil.getParameter(request, prefix	+ "rfa_no_old", length));
			String[] taaNoOld = (JSPUtil.getParameter(request, prefix	+ "taa_no_old", length));
			String[] rtroFlg = (JSPUtil.getParameter(request, prefix	+ "rtro_flg", length));
			String[] rtroKndCd = (JSPUtil.getParameter(request, prefix	+ "rtro_knd_cd", length));
			String[] oftAmdablFlg = (JSPUtil.getParameter(request, prefix	+ "oft_amdabl_flg", length));
			String[] oldOftAmt = (JSPUtil.getParameter(request, prefix	+ "old_oft_amt", length));
			String[] dhfCurrCd = (JSPUtil.getParameter(request, prefix	+ "dhf_curr_cd", length));
			String[] mstRfaRoutId = (JSPUtil.getParameter(request, prefix	+ "mst_rfa_rout_id", length));
			String[] docInterRmk = (JSPUtil.getParameter(request, prefix	+ "doc_inter_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new RateMainInfoVO();
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (rtBlTpCd[i] != null)
					model.setRtBlTpCd(rtBlTpCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (rpPropStsCd[i] != null)
					model.setRpPropStsCd(rpPropStsCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo1[i] != null)
					model.setScNo1(scNo1[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (scNo2[i] != null)
					model.setScNo2(scNo2[i]);
				if (audStsCd[i] != null)
					model.setAudStsCd(audStsCd[i]);
				if (prcGenSpclRtTpCd[i] != null)
					model.setPrcGenSpclRtTpCd(prcGenSpclRtTpCd[i]);
				if (cobizAuthNo[i] != null)
					model.setCobizAuthNo(cobizAuthNo[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (prcRtMtchPattCd[i] != null)
					model.setPrcRtMtchPattCd(prcRtMtchPattCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (ppdPayrCustSeq[i] != null)
					model.setPpdPayrCustSeq(ppdPayrCustSeq[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (mstCvrdBl[i] != null)
					model.setMstCvrdBl(mstCvrdBl[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (ppdRcvOfcCd[i] != null)
					model.setPpdRcvOfcCd(ppdRcvOfcCd[i]);
				if (bkgRtWhfExptCd[i] != null)
					model.setBkgRtWhfExptCd(bkgRtWhfExptCd[i]);
				if (ppdPayrCntCd[i] != null)
					model.setPpdPayrCntCd(ppdPayrCntCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (prcCmdtHdrSeq[i] != null)
					model.setPrcCmdtHdrSeq(prcCmdtHdrSeq[i]);
				if (spPropStsCd[i] != null)
					model.setSpPropStsCd(spPropStsCd[i]);
				if (cltPayrCustSeq[i] != null)
					model.setCltPayrCustSeq(cltPayrCustSeq[i]);
				if (rfaYn[i] != null)
					model.setRfaYn(rfaYn[i]);
				if (cltPayrCntCd[i] != null)
					model.setCltPayrCntCd(cltPayrCntCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtBlTpCdOld[i] != null)
					model.setRtBlTpCdOld(rtBlTpCdOld[i]);
				if (bkgSvcScpCd[i] != null)
					model.setBkgSvcScpCd(bkgSvcScpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (rmarkYn[i] != null)
					model.setRmarkYn(rmarkYn[i]);
				if (prcRoutSeq[i] != null)
					model.setPrcRoutSeq(prcRoutSeq[i]);
				if (trfLnrItmNo[i] != null)
					model.setTrfLnrItmNo(trfLnrItmNo[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (audPrfmFlg[i] != null)
					model.setAudPrfmFlg(audPrfmFlg[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (brkDwnFlg[i] != null)
					model.setBrkDwnFlg(brkDwnFlg[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (blCvrdTpCd[i] != null)
					model.setBlCvrdTpCd(blCvrdTpCd[i]);
				if (volDiffFlg[i] != null)
					model.setVolDiffFlg(volDiffFlg[i]);
				if (wscFlg[i] != null)
					model.setWscFlg(wscFlg[i]);	
				if (txsFlg[i] != null)
					model.setTxsFlg(txsFlg[i]);	
				if (cntrWgtCmplFlg[i] != null)
					model.setCntrWgtCmplFlg(cntrWgtCmplFlg[i]);
				if (cdrFlg[i] != null)
					model.setCdrFlg(cdrFlg[i]);	
				if (rwtFlg[i] != null)
					model.setRwtFlg(rwtFlg[i]);	
				if (calcCtrtTpCd[i] != null)
					model.setCalcCtrtTpCd(calcCtrtTpCd[i]);
				if (dhfLocCd[i] != null)
					model.setDhfLocCd(dhfLocCd[i]);
				if (ddcCurrCd[i] != null)
					model.setDdcCurrCd(ddcCurrCd[i]);
				if (jordanDesc[i] != null)
					model.setJordanDesc(jordanDesc[i]);
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (scNoOld[i] != null)
					model.setScNoOld(scNoOld[i]);
				if (rfaNoOld[i] != null)
					model.setRfaNoOld(rfaNoOld[i]);
				if (taaNoOld[i] != null)
					model.setTaaNoOld(taaNoOld[i]);
				if (rtroFlg[i] != null)
					model.setRtroFlg(rtroFlg[i]);
				if (rtroKndCd[i] != null)
					model.setRtroKndCd(rtroKndCd[i]);
				if (oftAmdablFlg[i] != null)
					model.setOftAmdablFlg(oftAmdablFlg[i]);
				if (oldOftAmt[i] != null)
					model.setOldOftAmt(oldOftAmt[i]);
				if (dhfCurrCd[i] != null)
					model.setDhfCurrCd(dhfCurrCd[i]);
				if (mstRfaRoutId[i] != null)
					model.setMstRfaRoutId(mstRfaRoutId[i]);
				if (docInterRmk[i] != null)
					model.setDocInterRmk(docInterRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRateMainInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RateMainInfoVO[]
	 */
	public RateMainInfoVO[] getRateMainInfoVOs(){
		RateMainInfoVO[] vos = (RateMainInfoVO[])models.toArray(new RateMainInfoVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpCd = this.rtBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpPropStsCd = this.rpPropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo1 = this.scNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo2 = this.scNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audStsCd = this.audStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGenSpclRtTpCd = this.prcGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobizAuthNo = this.cobizAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd = this.prcRtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayrCustSeq = this.ppdPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCvrdBl = this.mstCvrdBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdRcvOfcCd = this.ppdRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRtWhfExptCd = this.bkgRtWhfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayrCntCd = this.ppdPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtHdrSeq = this.prcCmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spPropStsCd = this.spPropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltPayrCustSeq = this.cltPayrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaYn = this.rfaYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltPayrCntCd = this.cltPayrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpCdOld = this.rtBlTpCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSvcScpCd = this.bkgSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmarkYn = this.rmarkYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRoutSeq = this.prcRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfLnrItmNo = this.trfLnrItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audPrfmFlg = this.audPrfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkDwnFlg = this.brkDwnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCvrdTpCd = this.blCvrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volDiffFlg = this.volDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wscFlg = this.wscFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txsFlg = this.txsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtCmplFlg = this.cntrWgtCmplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdrFlg = this.cdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rwtFlg = this.rwtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCtrtTpCd = this.calcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfLocCd = this.dhfLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddcCurrCd = this.ddcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jordanDesc = this.jordanDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNoOld = this.scNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNoOld = this.rfaNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNoOld = this.taaNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroFlg = this.rtroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroKndCd = this.rtroKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmdablFlg = this.oftAmdablFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOftAmt = this.oldOftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfCurrCd = this.dhfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstRfaRoutId = this.mstRfaRoutId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docInterRmk = this.docInterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
