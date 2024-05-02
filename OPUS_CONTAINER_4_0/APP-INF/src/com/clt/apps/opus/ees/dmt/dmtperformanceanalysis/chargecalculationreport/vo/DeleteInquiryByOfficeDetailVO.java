/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DeleteInquiryByOfficeDetailVO.java
*@FileTitle : DeleteInquiryByOfficeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.02.23 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo;

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

public class DeleteInquiryByOfficeDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeleteInquiryByOfficeDetailVO> models = new ArrayList<DeleteInquiryByOfficeDetailVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String corrRmk = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String ofcTrnsFlg = null;
	/* Column Info */
	private String aftExptDcAmt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String arActNm = null;
	/* Column Info */
	private String delDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String payerCd = null;
	/* Column Info */
	private String delUsrNm = null;
	/* Column Info */
	private String svcProvdrNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String arActCd = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String deltRsnDesc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String li = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dO = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String ch = null;
	/* Column Info */
	private String delOfc = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rollOvr = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String scRfaExptAmt = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String payerNm = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String toMvmtDt = null;
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
	private String ntfyNm = null;
	/* Column Info */
	private String svcProvdrCd = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String orgChgAmt = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String ofcCdDeltRsnCdList = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DeleteInquiryByOfficeDetailVO() {}

	public DeleteInquiryByOfficeDetailVO(String ibflag, String pagerows, String svrId, String dmdtChgStsCd, String ofcCd, String ofcRhqCd, String deltRsnDesc, String dmdtTrfCd, String cntrNo, String cntrTpszCd, String fmMvmtYdCd, String toMvmtYdCd, String fmMvmtStsCd, String toMvmtStsCd, String ftDys, String fxFtOvrDys, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String bzcTrfCurrCd, String orgChgAmt, String scRfaExptAmt, String aftExptDcAmt, String bilAmt, String bkgNo, String blNo, String vvdCd, String lane, String porCd, String polCd, String podCd, String delCd, String bkgRcvTermCd, String bkgDeTermCd, String scNo, String rfaNo, String chgType, String chgSeq, String socFlg, String li, String ch, String dO, String ofcTrnsFlg, String rollOvr, String cntrCycNo, String dmdtChgLocDivCd, String corrRmk, String payerCd, String payerNm, String shipperCd, String shipperNm, String cneeCd, String cneeNm, String ntfyCd, String ntfyNm, String arActCd, String arActNm, String svcProvdrCd, String svcProvdrNm, String delDt, String delOfc, String delUsrNm,String status, String ofcCdDeltRsnCdList) {
		this.cneeCd = cneeCd;
		this.corrRmk = corrRmk;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.ofcTrnsFlg = ofcTrnsFlg;
		this.aftExptDcAmt = aftExptDcAmt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.polCd = polCd;
		this.shipperNm = shipperNm;
		this.vvdCd = vvdCd;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.shipperCd = shipperCd;
		this.arActNm = arActNm;
		this.delDt = delDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.payerCd = payerCd;
		this.delUsrNm = delUsrNm;
		this.svcProvdrNm = svcProvdrNm;
		this.delCd = delCd;
		this.arActCd = arActCd;
		this.ftCmncDt = ftCmncDt;
		this.deltRsnDesc = deltRsnDesc;
		this.podCd = podCd;
		this.li = li;
		this.bkgNo = bkgNo;
		this.dO = dO;
		this.fmMvmtDt = fmMvmtDt;
		this.ch = ch;
		this.delOfc = delOfc;
		this.porCd = porCd;
		this.rollOvr = rollOvr;
		this.cntrCycNo = cntrCycNo;
		this.scRfaExptAmt = scRfaExptAmt;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.chgSeq = chgSeq;
		this.bilAmt = bilAmt;
		this.lane = lane;
		this.svrId = svrId;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.payerNm = payerNm;
		this.ftEndDt = ftEndDt;
		this.toMvmtDt = toMvmtDt;
		this.ofcRhqCd = ofcRhqCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.chgType = chgType;
		this.toMvmtStsCd = toMvmtStsCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.ntfyNm = ntfyNm;
		this.svcProvdrCd = svcProvdrCd;
		this.ntfyCd = ntfyCd;
		this.socFlg = socFlg;
		this.ofcCd = ofcCd;
		this.cneeNm = cneeNm;
		this.ftDys = ftDys;
		this.cntrNo = cntrNo;
		this.orgChgAmt = orgChgAmt;
		this.toMvmtYdCd = toMvmtYdCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.status = status;
		this.ofcCdDeltRsnCdList = ofcCdDeltRsnCdList;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("corr_rmk", getCorrRmk());
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
		this.hashColumns.put("ofc_trns_flg", getOfcTrnsFlg());
		this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("ar_act_nm", getArActNm());
		this.hashColumns.put("del_dt", getDelDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("payer_cd", getPayerCd());
		this.hashColumns.put("del_usr_nm", getDelUsrNm());
		this.hashColumns.put("svc_provdr_nm", getSvcProvdrNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ar_act_cd", getArActCd());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("delt_rsn_desc", getDeltRsnDesc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("li", getLi());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("d_o", getDO());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("ch", getCh());
		this.hashColumns.put("del_ofc", getDelOfc());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("roll_ovr", getRollOvr());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("payer_nm", getPayerNm());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("svc_provdr_cd", getSvcProvdrCd());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("ofc_cd_delt_rsn_cd_list", getOfcCdDeltRsnCdList());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("corr_rmk", "corrRmk");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("ofc_trns_flg", "ofcTrnsFlg");
		this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("ar_act_nm", "arActNm");
		this.hashFields.put("del_dt", "delDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("payer_cd", "payerCd");
		this.hashFields.put("del_usr_nm", "delUsrNm");
		this.hashFields.put("svc_provdr_nm", "svcProvdrNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ar_act_cd", "arActCd");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("delt_rsn_desc", "deltRsnDesc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("li", "li");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("d_o", "dO");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("ch", "ch");
		this.hashFields.put("del_ofc", "delOfc");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("roll_ovr", "rollOvr");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("payer_nm", "payerNm");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("svc_provdr_cd", "svcProvdrCd");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("ofc_cd_delt_rsn_cd_list", "ofcCdDeltRsnCdList");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return shipperCd
	 */
	public String getShipperCd() {
		return this.shipperCd;
	}
	
	/**
	 * Column Info
	 * @return arActNm
	 */
	public String getArActNm() {
		return this.arActNm;
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
	 * @return payerCd
	 */
	public String getPayerCd() {
		return this.payerCd;
	}
	
	/**
	 * Column Info
	 * @return delUsrNm
	 */
	public String getDelUsrNm() {
		return this.delUsrNm;
	}
	
	/**
	 * Column Info
	 * @return svcProvdrNm
	 */
	public String getSvcProvdrNm() {
		return this.svcProvdrNm;
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
	 * @return arActCd
	 */
	public String getArActCd() {
		return this.arActCd;
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
	 * @return deltRsnDesc
	 */
	public String getDeltRsnDesc() {
		return this.deltRsnDesc;
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
	 * @return li
	 */
	public String getLi() {
		return this.li;
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
	 * @return ch
	 */
	public String getCh() {
		return this.ch;
	}
	
	/**
	 * Column Info
	 * @return delOfc
	 */
	public String getDelOfc() {
		return this.delOfc;
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
	 * @return rollOvr
	 */
	public String getRollOvr() {
		return this.rollOvr;
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
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
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
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return dmdtChgStsCd
	 */
	public String getDmdtChgStsCd() {
		return this.dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return payerNm
	 */
	public String getPayerNm() {
		return this.payerNm;
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
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
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
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return svcProvdrCd
	 */
	public String getSvcProvdrCd() {
		return this.svcProvdrCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	/**
	 * Column Info
	 * @return ofcCdDeltRsnCdList
	 */
	public String getOfcCdDeltRsnCdList() {
		return this.ofcCdDeltRsnCdList;
	}
	

	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param shipperCd
	 */
	public void setShipperCd(String shipperCd) {
		this.shipperCd = shipperCd;
	}
	
	/**
	 * Column Info
	 * @param arActNm
	 */
	public void setArActNm(String arActNm) {
		this.arActNm = arActNm;
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
	 * @param payerCd
	 */
	public void setPayerCd(String payerCd) {
		this.payerCd = payerCd;
	}
	
	/**
	 * Column Info
	 * @param delUsrNm
	 */
	public void setDelUsrNm(String delUsrNm) {
		this.delUsrNm = delUsrNm;
	}
	
	/**
	 * Column Info
	 * @param svcProvdrNm
	 */
	public void setSvcProvdrNm(String svcProvdrNm) {
		this.svcProvdrNm = svcProvdrNm;
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
	 * @param arActCd
	 */
	public void setArActCd(String arActCd) {
		this.arActCd = arActCd;
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
	 * @param deltRsnDesc
	 */
	public void setDeltRsnDesc(String deltRsnDesc) {
		this.deltRsnDesc = deltRsnDesc;
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
	 * @param li
	 */
	public void setLi(String li) {
		this.li = li;
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
	 * @param ch
	 */
	public void setCh(String ch) {
		this.ch = ch;
	}
	
	/**
	 * Column Info
	 * @param delOfc
	 */
	public void setDelOfc(String delOfc) {
		this.delOfc = delOfc;
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
	 * @param rollOvr
	 */
	public void setRollOvr(String rollOvr) {
		this.rollOvr = rollOvr;
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
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
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
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param payerNm
	 */
	public void setPayerNm(String payerNm) {
		this.payerNm = payerNm;
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
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
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
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param svcProvdrCd
	 */
	public void setSvcProvdrCd(String svcProvdrCd) {
		this.svcProvdrCd = svcProvdrCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param ofcCdDeltRsnCdList
	 */
	public void setOfcCdDeltRsnCdList(String ofcCdDeltRsnCdList) {
		this.ofcCdDeltRsnCdList = ofcCdDeltRsnCdList;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setCorrRmk(JSPUtil.getParameter(request, prefix + "corr_rmk", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
		setOfcTrnsFlg(JSPUtil.getParameter(request, prefix + "ofc_trns_flg", ""));
		setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setShipperCd(JSPUtil.getParameter(request, prefix + "shipper_cd", ""));
		setArActNm(JSPUtil.getParameter(request, prefix + "ar_act_nm", ""));
		setDelDt(JSPUtil.getParameter(request, prefix + "del_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setPayerCd(JSPUtil.getParameter(request, prefix + "payer_cd", ""));
		setDelUsrNm(JSPUtil.getParameter(request, prefix + "del_usr_nm", ""));
		setSvcProvdrNm(JSPUtil.getParameter(request, prefix + "svc_provdr_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setArActCd(JSPUtil.getParameter(request, prefix + "ar_act_cd", ""));
		setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
		setDeltRsnDesc(JSPUtil.getParameter(request, prefix + "delt_rsn_desc", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setLi(JSPUtil.getParameter(request, prefix + "li", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDO(JSPUtil.getParameter(request, prefix + "d_o", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setCh(JSPUtil.getParameter(request, prefix + "ch", ""));
		setDelOfc(JSPUtil.getParameter(request, prefix + "del_ofc", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRollOvr(JSPUtil.getParameter(request, prefix + "roll_ovr", ""));
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_sts_cd", ""));
		setPayerNm(JSPUtil.getParameter(request, prefix + "payer_nm", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setSvcProvdrCd(JSPUtil.getParameter(request, prefix + "svc_provdr_cd", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setOfcCdDeltRsnCdList(JSPUtil.getParameter(request, prefix + "ofc_cd_delt_rsn_cd_list", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeleteInquiryByOfficeDetailVO[]
	 */
	public DeleteInquiryByOfficeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeleteInquiryByOfficeDetailVO[]
	 */
	public DeleteInquiryByOfficeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeleteInquiryByOfficeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] corrRmk = (JSPUtil.getParameter(request, prefix	+ "corr_rmk", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));
			String[] ofcTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_trns_flg", length));
			String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dc_amt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] arActNm = (JSPUtil.getParameter(request, prefix	+ "ar_act_nm", length));
			String[] delDt = (JSPUtil.getParameter(request, prefix	+ "del_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] payerCd = (JSPUtil.getParameter(request, prefix	+ "payer_cd", length));
			String[] delUsrNm = (JSPUtil.getParameter(request, prefix	+ "del_usr_nm", length));
			String[] svcProvdrNm = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] arActCd = (JSPUtil.getParameter(request, prefix	+ "ar_act_cd", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] deltRsnDesc = (JSPUtil.getParameter(request, prefix	+ "delt_rsn_desc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] li = (JSPUtil.getParameter(request, prefix	+ "li", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dO = (JSPUtil.getParameter(request, prefix	+ "d_o", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] ch = (JSPUtil.getParameter(request, prefix	+ "ch", length));
			String[] delOfc = (JSPUtil.getParameter(request, prefix	+ "del_ofc", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rollOvr = (JSPUtil.getParameter(request, prefix	+ "roll_ovr", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_expt_amt", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] payerNm = (JSPUtil.getParameter(request, prefix	+ "payer_nm", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] svcProvdrCd = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_cd", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] ofcCdDeltRsnCdList = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_delt_rsn_cd_list", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeleteInquiryByOfficeDetailVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (corrRmk[i] != null)
					model.setCorrRmk(corrRmk[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (ofcTrnsFlg[i] != null)
					model.setOfcTrnsFlg(ofcTrnsFlg[i]);
				if (aftExptDcAmt[i] != null)
					model.setAftExptDcAmt(aftExptDcAmt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (arActNm[i] != null)
					model.setArActNm(arActNm[i]);
				if (delDt[i] != null)
					model.setDelDt(delDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (payerCd[i] != null)
					model.setPayerCd(payerCd[i]);
				if (delUsrNm[i] != null)
					model.setDelUsrNm(delUsrNm[i]);
				if (svcProvdrNm[i] != null)
					model.setSvcProvdrNm(svcProvdrNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (arActCd[i] != null)
					model.setArActCd(arActCd[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (deltRsnDesc[i] != null)
					model.setDeltRsnDesc(deltRsnDesc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (li[i] != null)
					model.setLi(li[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dO[i] != null)
					model.setDO(dO[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (ch[i] != null)
					model.setCh(ch[i]);
				if (delOfc[i] != null)
					model.setDelOfc(delOfc[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rollOvr[i] != null)
					model.setRollOvr(rollOvr[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (scRfaExptAmt[i] != null)
					model.setScRfaExptAmt(scRfaExptAmt[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (payerNm[i] != null)
					model.setPayerNm(payerNm[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
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
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (svcProvdrCd[i] != null)
					model.setSvcProvdrCd(svcProvdrCd[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (ofcCdDeltRsnCdList[i] != null)
					model.setOfcCdDeltRsnCdList(ofcCdDeltRsnCdList[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeleteInquiryByOfficeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeleteInquiryByOfficeDetailVO[]
	 */
	public DeleteInquiryByOfficeDetailVO[] getDeleteInquiryByOfficeDetailVOs(){
		DeleteInquiryByOfficeDetailVO[] vos = (DeleteInquiryByOfficeDetailVO[])models.toArray(new DeleteInquiryByOfficeDetailVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRmk = this.corrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTrnsFlg = this.ofcTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDcAmt = this.aftExptDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActNm = this.arActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDt = this.delDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCd = this.payerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delUsrNm = this.delUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrNm = this.svcProvdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActCd = this.arActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRsnDesc = this.deltRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.li = this.li .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dO = this.dO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ch = this.ch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delOfc = this.delOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvr = this.rollOvr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaExptAmt = this.scRfaExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerNm = this.payerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrCd = this.svcProvdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdDeltRsnCdList = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
