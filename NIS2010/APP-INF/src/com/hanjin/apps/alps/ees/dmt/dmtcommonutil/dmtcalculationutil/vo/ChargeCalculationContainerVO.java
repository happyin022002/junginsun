/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationContainerVO.java
*@FileTitle : ChargeCalculationContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.01.05 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeCalculationContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeCalculationContainerVO> models = new ArrayList<ChargeCalculationContainerVO>();
	
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String cvrgCmbSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String aftExptAdjSeq = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String cstopNo = null;
	/* Column Info */
	private String cmdtOvrDys = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String msgCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String cmdtTrfSeq = null;
	/* Column Info */
	private String aftExptAmt = null;
	/* Column Info */
	private String aftExptAproNo = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String ofcRhq = null;
	/* Column Info */
	private String bbDeTermCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String scRfaExptOvrDys = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bbRcvTermCd = null;
	/* Column Info */
	private String bzcTrfAplyDt = null;
	/* Column Info */
	private String cstopIdx = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String salOfc = null;
	/* Column Info */
	private String bzcTrfSeq = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String brhScNo = null;
	/* Column Info */
	private String brhRfaNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String scRfaExptAplyDt = null;
	/* Column Info */
	private String salRhq = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String rfaExptAproNo = null;
	/* Column Info */
	private String cmdtExptAplyDt = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String bilAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCdC = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String aftExptOvrDys = null;
	/* Column Info */
	private String mtDate = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String bzcTrfGrpSeq = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String cmdtExptAmt = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String orgFtOvrDys = null;
	/* Column Info */
	private String scRfaAmt = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Number */
	private String bzcDmdtDeTermCd = null;
	/* Column Number */
	private String bzcDmdtDeTermNm = null;

	/* Column Info */
	private List<String> cstopNoList = null;

	/**
	 * Column Info
	 * @return this.cstopNoVOS
	 */
	public void setCStopNoList(List<String> cstopNoList) {
		this.cstopNoList = cstopNoList;
	}
	
	/**
	 * Column Info
	 * @return List<String>
	 */
	public List<String> getCStopNoList() {
		return cstopNoList;
	}
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeCalculationContainerVO() {}

	public ChargeCalculationContainerVO(String ibflag, String pagerows, String cntrTp, String blNo, String brhScNo, String brhRfaNo, String cmdtCd, String repCmdtCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String rdCgoFlg, String bbCgoFlg, String socFlg, String cntrPrtFlg, String advShtgCd, String porCd, String podCd, String polCd, String delCd, String salOfc, String salRhq, String dmdtCgoTpCd, String bkgQty, String vslCd, String skdVoyNo, String skdDirCd, String vpsEtaDt, String ofcCd, String ofcRhq, String bbRcvTermCd, String bbDeTermCd, String ftDys, String ftCmncDt, String ftEndDt, String fxFtOvrDys, String orgFtOvrDys, String scRfaExptOvrDys, String aftExptOvrDys, String bzcTrfCurrCd, String dmdtTrfAplyTpCd, String orgChgAmt, String scRfaExptAmt, String aftExptDcAmt, String bilAmt, String dmdtChgStsCd, String scRfaAmt, String aftExptAmt, String bzcTrfSeq, String bzcTrfGrpSeq, String rfaExptAproNo, String rfaExptDarNo, String rfaExptMapgSeq, String rfaExptVerSeq, String rfaRqstDtlSeq, String cvrgCmbSeq, String aftExptAproNo, String aftExptDarNo, String aftExptAdjSeq, String scNo, String scExptVerSeq, String scExptGrpSeq, String cmdtCdC, String cmdtTrfSeq, String cmdtOvrDys, String cmdtExptAmt, String toMvmtDt, String toMvmtYdCd, String toMvmtStsCd, String cstopIdx, String cstopNo, String bzcTrfAplyDt, String cmdtExptAplyDt, String scRfaExptAplyDt, String mtDate, String msgCd, String msgDesc, String bzcDmdtDeTermCd, String bzcDmdtDeTermNm) {
		this.cvrgCmbSeq = cvrgCmbSeq;
		this.vslCd = vslCd;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.msgDesc = msgDesc;
		this.aftExptDcAmt = aftExptDcAmt;
		this.scExptVerSeq = scExptVerSeq;
		this.aftExptAdjSeq = aftExptAdjSeq;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.cstopNo = cstopNo;
		this.cmdtOvrDys = cmdtOvrDys;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.msgCd = msgCd;
		this.polCd = polCd;
		this.scNo = scNo;
		this.rfaExptDarNo = rfaExptDarNo;
		this.cmdtTrfSeq = cmdtTrfSeq;
		this.aftExptAmt = aftExptAmt;
		this.aftExptAproNo = aftExptAproNo;
		this.cntrPrtFlg = cntrPrtFlg;
		this.ofcRhq = ofcRhq;
		this.bbDeTermCd = bbDeTermCd;
		this.awkCgoFlg = awkCgoFlg;
		this.scRfaExptOvrDys = scRfaExptOvrDys;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.bbRcvTermCd = bbRcvTermCd;
		this.bzcTrfAplyDt = bzcTrfAplyDt;
		this.cstopIdx = cstopIdx;
		this.ftCmncDt = ftCmncDt;
		this.podCd = podCd;
		this.salOfc = salOfc;
		this.bzcTrfSeq = bzcTrfSeq;
		this.rcFlg = rcFlg;
		this.brhScNo = brhScNo;
		this.brhRfaNo = brhRfaNo;
		this.porCd = porCd;
		this.scRfaExptAplyDt = scRfaExptAplyDt;
		this.salRhq = salRhq;
		this.rdCgoFlg = rdCgoFlg;
		this.scRfaExptAmt = scRfaExptAmt;
		this.rfaExptAproNo = rfaExptAproNo;
		this.cmdtExptAplyDt = cmdtExptAplyDt;
		this.advShtgCd = advShtgCd;
		this.vpsEtaDt = vpsEtaDt;
		this.bilAmt = bilAmt;
		this.ibflag = ibflag;
		this.cmdtCdC = cmdtCdC;
		this.aftExptDarNo = aftExptDarNo;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.cmdtCd = cmdtCd;
		this.aftExptOvrDys = aftExptOvrDys;
		this.mtDate = mtDate;
		this.bkgQty = bkgQty;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.bzcTrfGrpSeq = bzcTrfGrpSeq;
		this.ftEndDt = ftEndDt;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.toMvmtDt = toMvmtDt;
		this.cmdtExptAmt = cmdtExptAmt;
		this.toMvmtStsCd = toMvmtStsCd;
		this.scExptGrpSeq = scExptGrpSeq;
		this.skdDirCd = skdDirCd;
		this.socFlg = socFlg;
		this.ofcCd = ofcCd;
		this.cntrTp = cntrTp;
		this.ftDys = ftDys;
		this.orgFtOvrDys = orgFtOvrDys;
		this.scRfaAmt = scRfaAmt;
		this.orgChgAmt = orgChgAmt;
		this.toMvmtYdCd = toMvmtYdCd;
		this.repCmdtCd = repCmdtCd;
		this.bzcDmdtDeTermCd = bzcDmdtDeTermCd;
		this.bzcDmdtDeTermNm = bzcDmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cvrg_cmb_seq", getCvrgCmbSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("aft_expt_adj_seq", getAftExptAdjSeq());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("cstop_no", getCstopNo());
		this.hashColumns.put("cmdt_ovr_dys", getCmdtOvrDys());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("cmdt_trf_seq", getCmdtTrfSeq());
		this.hashColumns.put("aft_expt_amt", getAftExptAmt());
		this.hashColumns.put("aft_expt_apro_no", getAftExptAproNo());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ofc_rhq", getOfcRhq());
		this.hashColumns.put("bb_de_term_cd", getBbDeTermCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("sc_rfa_expt_ovr_dys", getScRfaExptOvrDys());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bb_rcv_term_cd", getBbRcvTermCd());
		this.hashColumns.put("bzc_trf_aply_dt", getBzcTrfAplyDt());
		this.hashColumns.put("cstop_idx", getCstopIdx());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sal_ofc", getSalOfc());
		this.hashColumns.put("bzc_trf_seq", getBzcTrfSeq());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("brh_sc_no", getBrhScNo());
		this.hashColumns.put("brh_rfa_no", getBrhRfaNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("sc_rfa_expt_aply_dt", getScRfaExptAplyDt());
		this.hashColumns.put("sal_rhq", getSalRhq());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("rfa_expt_apro_no", getRfaExptAproNo());
		this.hashColumns.put("cmdt_expt_aply_dt", getCmdtExptAplyDt());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd_c", getCmdtCdC());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("aft_expt_ovr_dys", getAftExptOvrDys());
		this.hashColumns.put("mt_date", getMtDate());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("bzc_trf_grp_seq", getBzcTrfGrpSeq());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("org_ft_ovr_dys", getOrgFtOvrDys());
		this.hashColumns.put("sc_rfa_amt", getScRfaAmt());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("bzc_dmdt_de_term_cd", getBzcDmdtDeTermCd());
		this.hashColumns.put("bzc_dmdt_de_term_nm", getBzcDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cvrg_cmb_seq", "cvrgCmbSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("aft_expt_adj_seq", "aftExptAdjSeq");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("cstop_no", "cstopNo");
		this.hashFields.put("cmdt_ovr_dys", "cmdtOvrDys");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("cmdt_trf_seq", "cmdtTrfSeq");
		this.hashFields.put("aft_expt_amt", "aftExptAmt");
		this.hashFields.put("aft_expt_apro_no", "aftExptAproNo");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ofc_rhq", "ofcRhq");
		this.hashFields.put("bb_de_term_cd", "bbDeTermCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("sc_rfa_expt_ovr_dys", "scRfaExptOvrDys");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bb_rcv_term_cd", "bbRcvTermCd");
		this.hashFields.put("bzc_trf_aply_dt", "bzcTrfAplyDt");
		this.hashFields.put("cstop_idx", "cstopIdx");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sal_ofc", "salOfc");
		this.hashFields.put("bzc_trf_seq", "bzcTrfSeq");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("brh_sc_no", "brhScNo");
		this.hashFields.put("brh_rfa_no", "brhRfaNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("sc_rfa_expt_aply_dt", "scRfaExptAplyDt");
		this.hashFields.put("sal_rhq", "salRhq");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("rfa_expt_apro_no", "rfaExptAproNo");
		this.hashFields.put("cmdt_expt_aply_dt", "cmdtExptAplyDt");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd_c", "cmdtCdC");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("aft_expt_ovr_dys", "aftExptOvrDys");
		this.hashFields.put("mt_date", "mtDate");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("bzc_trf_grp_seq", "bzcTrfGrpSeq");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("org_ft_ovr_dys", "orgFtOvrDys");
		this.hashFields.put("sc_rfa_amt", "scRfaAmt");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("bzc_dmdt_de_term_cd", "bzcDmdtDeTermCd");
		this.hashFields.put("bzc_dmdt_de_term_nm", "bzcDmdtDeTermNm");
		
		return this.hashFields;
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
	 * @return cvrgCmbSeq
	 */
	public String getCvrgCmbSeq() {
		return this.cvrgCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
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
	 * @return cstopNo
	 */
	public String getCstopNo() {
		return this.cstopNo;
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
	 * @return msgCd
	 */
	public String getMsgCd() {
		return this.msgCd;
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
	 * @return aftExptAproNo
	 */
	public String getAftExptAproNo() {
		return this.aftExptAproNo;
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
	 * @return ofcRhq
	 */
	public String getOfcRhq() {
		return this.ofcRhq;
	}
	
	/**
	 * Column Info
	 * @return bbDeTermCd
	 */
	public String getBbDeTermCd() {
		return this.bbDeTermCd;
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
	 * @return scRfaExptOvrDys
	 */
	public String getScRfaExptOvrDys() {
		return this.scRfaExptOvrDys;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bbRcvTermCd
	 */
	public String getBbRcvTermCd() {
		return this.bbRcvTermCd;
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
	 * @return cstopIdx
	 */
	public String getCstopIdx() {
		return this.cstopIdx;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return salOfc
	 */
	public String getSalOfc() {
		return this.salOfc;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return brhScNo
	 */
	public String getBrhScNo() {
		return this.brhScNo;
	}
	
	/**
	 * Column Info
	 * @return brhRfaNo
	 */
	public String getBrhRfaNo() {
		return this.brhRfaNo;
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
	 * @return scRfaExptAplyDt
	 */
	public String getScRfaExptAplyDt() {
		return this.scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @return salRhq
	 */
	public String getSalRhq() {
		return this.salRhq;
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
	 * @return scRfaExptAmt
	 */
	public String getScRfaExptAmt() {
		return this.scRfaExptAmt;
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
	 * @return cmdtExptAplyDt
	 */
	public String getCmdtExptAplyDt() {
		return this.cmdtExptAplyDt;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
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
	 * @return cmdtCdC
	 */
	public String getCmdtCdC() {
		return this.cmdtCdC;
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
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
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
	 * @return aftExptOvrDys
	 */
	public String getAftExptOvrDys() {
		return this.aftExptOvrDys;
	}
	
	/**
	 * Column Info
	 * @return mtDate
	 */
	public String getMtDate() {
		return this.mtDate;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
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
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
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
	 * @return cmdtExptAmt
	 */
	public String getCmdtExptAmt() {
		return this.cmdtExptAmt;
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
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
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
	 * @return orgFtOvrDys
	 */
	public String getOrgFtOvrDys() {
		return this.orgFtOvrDys;
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
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param cvrgCmbSeq
	 */
	public void setCvrgCmbSeq(String cvrgCmbSeq) {
		this.cvrgCmbSeq = cvrgCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
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
	 * @param cstopNo
	 */
	public void setCstopNo(String cstopNo) {
		this.cstopNo = cstopNo;
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
	 * @param msgCd
	 */
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
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
	 * @param aftExptAproNo
	 */
	public void setAftExptAproNo(String aftExptAproNo) {
		this.aftExptAproNo = aftExptAproNo;
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
	 * @param ofcRhq
	 */
	public void setOfcRhq(String ofcRhq) {
		this.ofcRhq = ofcRhq;
	}
	
	/**
	 * Column Info
	 * @param bbDeTermCd
	 */
	public void setBbDeTermCd(String bbDeTermCd) {
		this.bbDeTermCd = bbDeTermCd;
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
	 * @param scRfaExptOvrDys
	 */
	public void setScRfaExptOvrDys(String scRfaExptOvrDys) {
		this.scRfaExptOvrDys = scRfaExptOvrDys;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bbRcvTermCd
	 */
	public void setBbRcvTermCd(String bbRcvTermCd) {
		this.bbRcvTermCd = bbRcvTermCd;
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
	 * @param cstopIdx
	 */
	public void setCstopIdx(String cstopIdx) {
		this.cstopIdx = cstopIdx;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param salOfc
	 */
	public void setSalOfc(String salOfc) {
		this.salOfc = salOfc;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param brhScNo
	 */
	public void setBrhScNo(String brhScNo) {
		this.brhScNo = brhScNo;
	}
	
	/**
	 * Column Info
	 * @param brhRfaNo
	 */
	public void setBrhRfaNo(String brhRfaNo) {
		this.brhRfaNo = brhRfaNo;
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
	 * @param scRfaExptAplyDt
	 */
	public void setScRfaExptAplyDt(String scRfaExptAplyDt) {
		this.scRfaExptAplyDt = scRfaExptAplyDt;
	}
	
	/**
	 * Column Info
	 * @param salRhq
	 */
	public void setSalRhq(String salRhq) {
		this.salRhq = salRhq;
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
	 * @param scRfaExptAmt
	 */
	public void setScRfaExptAmt(String scRfaExptAmt) {
		this.scRfaExptAmt = scRfaExptAmt;
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
	 * @param cmdtExptAplyDt
	 */
	public void setCmdtExptAplyDt(String cmdtExptAplyDt) {
		this.cmdtExptAplyDt = cmdtExptAplyDt;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
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
	 * @param cmdtCdC
	 */
	public void setCmdtCdC(String cmdtCdC) {
		this.cmdtCdC = cmdtCdC;
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
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
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
	 * @param aftExptOvrDys
	 */
	public void setAftExptOvrDys(String aftExptOvrDys) {
		this.aftExptOvrDys = aftExptOvrDys;
	}
	
	/**
	 * Column Info
	 * @param mtDate
	 */
	public void setMtDate(String mtDate) {
		this.mtDate = mtDate;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
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
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
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
	 * @param cmdtExptAmt
	 */
	public void setCmdtExptAmt(String cmdtExptAmt) {
		this.cmdtExptAmt = cmdtExptAmt;
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
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
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
	 * @param orgFtOvrDys
	 */
	public void setOrgFtOvrDys(String orgFtOvrDys) {
		this.orgFtOvrDys = orgFtOvrDys;
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
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
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
		setCvrgCmbSeq(JSPUtil.getParameter(request, "cvrg_cmb_seq", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, "bzc_trf_curr_cd", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, "aft_expt_dc_amt", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, "sc_expt_ver_seq", ""));
		setAftExptAdjSeq(JSPUtil.getParameter(request, "aft_expt_adj_seq", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, "dmdt_trf_aply_tp_cd", ""));
		setCstopNo(JSPUtil.getParameter(request, "cstop_no", ""));
		setCmdtOvrDys(JSPUtil.getParameter(request, "cmdt_ovr_dys", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, "fx_ft_ovr_dys", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, "rfa_expt_dar_no", ""));
		setCmdtTrfSeq(JSPUtil.getParameter(request, "cmdt_trf_seq", ""));
		setAftExptAmt(JSPUtil.getParameter(request, "aft_expt_amt", ""));
		setAftExptAproNo(JSPUtil.getParameter(request, "aft_expt_apro_no", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setOfcRhq(JSPUtil.getParameter(request, "ofc_rhq", ""));
		setBbDeTermCd(JSPUtil.getParameter(request, "bb_de_term_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setScRfaExptOvrDys(JSPUtil.getParameter(request, "sc_rfa_expt_ovr_dys", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBbRcvTermCd(JSPUtil.getParameter(request, "bb_rcv_term_cd", ""));
		setBzcTrfAplyDt(JSPUtil.getParameter(request, "bzc_trf_aply_dt", ""));
		setCstopIdx(JSPUtil.getParameter(request, "cstop_idx", ""));
		setFtCmncDt(JSPUtil.getParameter(request, "ft_cmnc_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSalOfc(JSPUtil.getParameter(request, "sal_ofc", ""));
		setBzcTrfSeq(JSPUtil.getParameter(request, "bzc_trf_seq", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setBrhScNo(JSPUtil.getParameter(request, "brh_sc_no", ""));
		setBrhRfaNo(JSPUtil.getParameter(request, "brh_rfa_no", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setScRfaExptAplyDt(JSPUtil.getParameter(request, "sc_rfa_expt_aply_dt", ""));
		setSalRhq(JSPUtil.getParameter(request, "sal_rhq", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, "sc_rfa_expt_amt", ""));
		setRfaExptAproNo(JSPUtil.getParameter(request, "rfa_expt_apro_no", ""));
		setCmdtExptAplyDt(JSPUtil.getParameter(request, "cmdt_expt_aply_dt", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, "adv_shtg_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setBilAmt(JSPUtil.getParameter(request, "bil_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCdC(JSPUtil.getParameter(request, "cmdt_cd_c", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, "aft_expt_dar_no", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, "rfa_expt_mapg_seq", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setAftExptOvrDys(JSPUtil.getParameter(request, "aft_expt_ovr_dys", ""));
		setMtDate(JSPUtil.getParameter(request, "mt_date", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, "rfa_rqst_dtl_seq", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, "rfa_expt_ver_seq", ""));
		setBzcTrfGrpSeq(JSPUtil.getParameter(request, "bzc_trf_grp_seq", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, "dmdt_cgo_tp_cd", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setCmdtExptAmt(JSPUtil.getParameter(request, "cmdt_expt_amt", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, "to_mvmt_sts_cd", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, "sc_expt_grp_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCntrTp(JSPUtil.getParameter(request, "cntr_tp", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setOrgFtOvrDys(JSPUtil.getParameter(request, "org_ft_ovr_dys", ""));
		setScRfaAmt(JSPUtil.getParameter(request, "sc_rfa_amt", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, "org_chg_amt", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, "to_mvmt_yd_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setBzcDmdtDeTermCd(JSPUtil.getParameter(request, "bzc_dmdt_de_term_cd", ""));
		setBzcDmdtDeTermNm(JSPUtil.getParameter(request, "bzc_dmdt_de_term_nm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeCalculationContainerVO[]
	 */
	public ChargeCalculationContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeCalculationContainerVO[]
	 */
	public ChargeCalculationContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeCalculationContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cvrgCmbSeq = (JSPUtil.getParameter(request, prefix	+ "cvrg_cmb_seq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] aftExptAdjSeq = (JSPUtil.getParameter(request, prefix	+ "aft_expt_adj_seq", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] cstopNo = (JSPUtil.getParameter(request, prefix	+ "cstop_no", length));
			String[] cmdtOvrDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_ovr_dys", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] cmdtTrfSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_trf_seq", length));
			String[] aftExptAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_amt", length));
			String[] aftExptAproNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_apro_no", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] ofcRhq = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq", length));
			String[] bbDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bb_de_term_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] scRfaExptOvrDys = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_ovr_dys", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bbRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bb_rcv_term_cd", length));
			String[] bzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_aply_dt", length));
			String[] cstopIdx = (JSPUtil.getParameter(request, prefix	+ "cstop_idx", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] salOfc = (JSPUtil.getParameter(request, prefix	+ "sal_ofc", length));
			String[] bzcTrfSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_seq", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] brhScNo = (JSPUtil.getParameter(request, prefix	+ "brh_sc_no", length));
			String[] brhRfaNo = (JSPUtil.getParameter(request, prefix	+ "brh_rfa_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] scRfaExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_aply_dt", length));
			String[] salRhq = (JSPUtil.getParameter(request, prefix	+ "sal_rhq", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] rfaExptAproNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_apro_no", length));
			String[] cmdtExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_aply_dt", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCdC = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd_c", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] aftExptOvrDys = (JSPUtil.getParameter(request, prefix	+ "aft_expt_ovr_dys", length));
			String[] mtDate = (JSPUtil.getParameter(request, prefix	+ "mt_date", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] bzcTrfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_grp_seq", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_amt", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] orgFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "org_ft_ovr_dys", length));
			String[] scRfaAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_amt", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] bzcDmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_cd", length));
			String[] bzcDmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "bzc_dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeCalculationContainerVO();
				if (cvrgCmbSeq[i] != null)
					model.setCvrgCmbSeq(cvrgCmbSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (aftExptAdjSeq[i] != null)
					model.setAftExptAdjSeq(aftExptAdjSeq[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (cstopNo[i] != null)
					model.setCstopNo(cstopNo[i]);
				if (cmdtOvrDys[i] != null)
					model.setCmdtOvrDys(cmdtOvrDys[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (cmdtTrfSeq[i] != null)
					model.setCmdtTrfSeq(cmdtTrfSeq[i]);
				if (aftExptAmt[i] != null)
					model.setAftExptAmt(aftExptAmt[i]);
				if (aftExptAproNo[i] != null)
					model.setAftExptAproNo(aftExptAproNo[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (ofcRhq[i] != null)
					model.setOfcRhq(ofcRhq[i]);
				if (bbDeTermCd[i] != null)
					model.setBbDeTermCd(bbDeTermCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (scRfaExptOvrDys[i] != null)
					model.setScRfaExptOvrDys(scRfaExptOvrDys[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bbRcvTermCd[i] != null)
					model.setBbRcvTermCd(bbRcvTermCd[i]);
				if (bzcTrfAplyDt[i] != null)
					model.setBzcTrfAplyDt(bzcTrfAplyDt[i]);
				if (cstopIdx[i] != null)
					model.setCstopIdx(cstopIdx[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (salOfc[i] != null)
					model.setSalOfc(salOfc[i]);
				if (bzcTrfSeq[i] != null)
					model.setBzcTrfSeq(bzcTrfSeq[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (brhScNo[i] != null)
					model.setBrhScNo(brhScNo[i]);
				if (brhRfaNo[i] != null)
					model.setBrhRfaNo(brhRfaNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (scRfaExptAplyDt[i] != null)
					model.setScRfaExptAplyDt(scRfaExptAplyDt[i]);
				if (salRhq[i] != null)
					model.setSalRhq(salRhq[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (rfaExptAproNo[i] != null)
					model.setRfaExptAproNo(rfaExptAproNo[i]);
				if (cmdtExptAplyDt[i] != null)
					model.setCmdtExptAplyDt(cmdtExptAplyDt[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCdC[i] != null)
					model.setCmdtCdC(cmdtCdC[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (aftExptOvrDys[i] != null)
					model.setAftExptOvrDys(aftExptOvrDys[i]);
				if (mtDate[i] != null)
					model.setMtDate(mtDate[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (bzcTrfGrpSeq[i] != null)
					model.setBzcTrfGrpSeq(bzcTrfGrpSeq[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (cmdtExptAmt[i] != null)
					model.setCmdtExptAmt(cmdtExptAmt[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (orgFtOvrDys[i] != null)
					model.setOrgFtOvrDys(orgFtOvrDys[i]);
				if (scRfaAmt[i] != null)
					model.setScRfaAmt(scRfaAmt[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (bzcDmdtDeTermCd[i] != null)
					model.setBzcDmdtDeTermCd(bzcDmdtDeTermCd[i]);
				if (bzcDmdtDeTermNm[i] != null)
					model.setBzcDmdtDeTermCd(bzcDmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeCalculationContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeCalculationContainerVO[]
	 */
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOs(){
		ChargeCalculationContainerVO[] vos = (ChargeCalculationContainerVO[])models.toArray(new ChargeCalculationContainerVO[models.size()]);
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
		this.cvrgCmbSeq = this.cvrgCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAdjSeq = this.aftExptAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopNo = this.cstopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtOvrDys = this.cmdtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTrfSeq = this.cmdtTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAmt = this.aftExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptAproNo = this.aftExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhq = this.ofcRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbDeTermCd = this.bbDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptOvrDys = this.scRfaExptOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbRcvTermCd = this.bbRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfAplyDt = this.bzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstopIdx = this.cstopIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salOfc = this.salOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfSeq = this.bzcTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brhScNo = this.brhScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brhRfaNo = this.brhRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAplyDt = this.scRfaExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salRhq = this.salRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptAproNo = this.rfaExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAplyDt = this.cmdtExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCdC = this.cmdtCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptOvrDys = this.aftExptOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDate = this.mtDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfGrpSeq = this.bzcTrfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAmt = this.cmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFtOvrDys = this.orgFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaAmt = this.scRfaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermCd = this.bzcDmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcDmdtDeTermNm = this.bzcDmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
