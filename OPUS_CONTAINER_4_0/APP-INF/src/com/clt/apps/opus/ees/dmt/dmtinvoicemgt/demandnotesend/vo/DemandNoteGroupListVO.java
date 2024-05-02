/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNoteGroupListVO.java
*@FileTitle : DemandNoteGroupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.11.20 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemandNoteGroupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemandNoteGroupListVO> models = new ArrayList<DemandNoteGroupListVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String orgCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fxFtOvrDys = null;
	/* Column Info */
	private String ftCmncDtRd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dcAmt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String arActNm = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String payerCd = null;
	/* Column Info */
	private String toMvmtDtRd = null;
	/* Column Info */
	private String svcProvdrNm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String loc = null;
	/* Column Info */
	private String arActCd = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String invDcAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String ftEndDtRd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String fmMvmtDtRd = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String svrId = null;
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
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String invOrgAmt = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String exptAmt = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String svcProvdrCd = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DemandNoteGroupListVO() {}

	public DemandNoteGroupListVO(String ibflag, String pagerows, String vvdCd, String loc, String cntrTpszCd, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String fmMvmtDtRd, String toMvmtDtRd, String ftCmncDtRd, String ftEndDtRd, String ftDys, String fxFtOvrDys, String bkgNo, String blNo, String cntrNo, String dmdtChgStsCd, String ofcCd, String fmMvmtYdCd, String port, String dmdtTrfCd, String payerCd, String payerNm, String shipperCd, String shipperNm, String cneeCd, String cneeNm, String ntfyCd, String ntfyNm, String arActCd, String arActNm, String svcProvdrCd, String svcProvdrNm, String scNo, String rfaNo, String invCurrCd, String invChgAmt, String invOrgAmt, String invDcAmt, String orgCurrCd, String orgChgAmt, String exptAmt, String dcAmt, String bilAmt, String invXchRt, String svrId, String cntrCycNo, String dmdtChgLocDivCd, String chgSeq, String dmdtInvNo, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd) {
		this.cneeCd = cneeCd;
		this.vslCd = vslCd;
		this.blNo = blNo;
		this.orgCurrCd = orgCurrCd;
		this.pagerows = pagerows;
		this.fxFtOvrDys = fxFtOvrDys;
		this.ftCmncDtRd = ftCmncDtRd;
		this.polCd = polCd;
		this.dcAmt = dcAmt;
		this.vvdCd = vvdCd;
		this.shipperNm = shipperNm;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.shipperCd = shipperCd;
		this.arActNm = arActNm;
		this.dmdtTrfCd = dmdtTrfCd;
		this.invXchRt = invXchRt;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.payerCd = payerCd;
		this.toMvmtDtRd = toMvmtDtRd;
		this.svcProvdrNm = svcProvdrNm;
		this.skdVoyNo = skdVoyNo;
		this.loc = loc;
		this.arActCd = arActCd;
		this.ftCmncDt = ftCmncDt;
		this.podCd = podCd;
		this.invDcAmt = invDcAmt;
		this.bkgNo = bkgNo;
		this.fmMvmtDt = fmMvmtDt;
		this.port = port;
		this.ftEndDtRd = ftEndDtRd;
		this.cntrCycNo = cntrCycNo;
		this.chgSeq = chgSeq;
		this.fmMvmtDtRd = fmMvmtDtRd;
		this.bilAmt = bilAmt;
		this.rfaNo = rfaNo;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.payerNm = payerNm;
		this.ftEndDt = ftEndDt;
		this.toMvmtDt = toMvmtDt;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.invOrgAmt = invOrgAmt;
		this.invChgAmt = invChgAmt;
		this.exptAmt = exptAmt;
		this.dmdtInvNo = dmdtInvNo;
		this.invCurrCd = invCurrCd;
		this.ntfyNm = ntfyNm;
		this.skdDirCd = skdDirCd;
		this.ntfyCd = ntfyCd;
		this.svcProvdrCd = svcProvdrCd;
		this.ofcCd = ofcCd;
		this.cneeNm = cneeNm;
		this.ftDys = ftDys;
		this.cntrNo = cntrNo;
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		this.hashColumns.put("ft_cmnc_dt_rd", getFtCmncDtRd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("ar_act_nm", getArActNm());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("payer_cd", getPayerCd());
		this.hashColumns.put("to_mvmt_dt_rd", getToMvmtDtRd());
		this.hashColumns.put("svc_provdr_nm", getSvcProvdrNm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("ar_act_cd", getArActCd());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("inv_dc_amt", getInvDcAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("ft_end_dt_rd", getFtEndDtRd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("fm_mvmt_dt_rd", getFmMvmtDtRd());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("payer_nm", getPayerNm());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("inv_org_amt", getInvOrgAmt());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("expt_amt", getExptAmt());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("svc_provdr_cd", getSvcProvdrCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		this.hashFields.put("ft_cmnc_dt_rd", "ftCmncDtRd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("ar_act_nm", "arActNm");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("payer_cd", "payerCd");
		this.hashFields.put("to_mvmt_dt_rd", "toMvmtDtRd");
		this.hashFields.put("svc_provdr_nm", "svcProvdrNm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("ar_act_cd", "arActCd");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("inv_dc_amt", "invDcAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("port", "port");
		this.hashFields.put("ft_end_dt_rd", "ftEndDtRd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("fm_mvmt_dt_rd", "fmMvmtDtRd");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("payer_nm", "payerNm");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("inv_org_amt", "invOrgAmt");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("expt_amt", "exptAmt");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("svc_provdr_cd", "svcProvdrCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return orgCurrCd
	 */
	public String getOrgCurrCd() {
		return this.orgCurrCd;
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
	 * @return ftCmncDtRd
	 */
	public String getFtCmncDtRd() {
		return this.ftCmncDtRd;
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
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
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
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return toMvmtDtRd
	 */
	public String getToMvmtDtRd() {
		return this.toMvmtDtRd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return invDcAmt
	 */
	public String getInvDcAmt() {
		return this.invDcAmt;
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
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return ftEndDtRd
	 */
	public String getFtEndDtRd() {
		return this.ftEndDtRd;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDtRd
	 */
	public String getFmMvmtDtRd() {
		return this.fmMvmtDtRd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return invOrgAmt
	 */
	public String getInvOrgAmt() {
		return this.invOrgAmt;
	}
	
	/**
	 * Column Info
	 * @return invChgAmt
	 */
	public String getInvChgAmt() {
		return this.invChgAmt;
	}
	
	/**
	 * Column Info
	 * @return exptAmt
	 */
	public String getExptAmt() {
		return this.exptAmt;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return svcProvdrCd
	 */
	public String getSvcProvdrCd() {
		return this.svcProvdrCd;
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
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param orgCurrCd
	 */
	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
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
	 * @param ftCmncDtRd
	 */
	public void setFtCmncDtRd(String ftCmncDtRd) {
		this.ftCmncDtRd = ftCmncDtRd;
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
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
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
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param toMvmtDtRd
	 */
	public void setToMvmtDtRd(String toMvmtDtRd) {
		this.toMvmtDtRd = toMvmtDtRd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param invDcAmt
	 */
	public void setInvDcAmt(String invDcAmt) {
		this.invDcAmt = invDcAmt;
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
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param ftEndDtRd
	 */
	public void setFtEndDtRd(String ftEndDtRd) {
		this.ftEndDtRd = ftEndDtRd;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDtRd
	 */
	public void setFmMvmtDtRd(String fmMvmtDtRd) {
		this.fmMvmtDtRd = fmMvmtDtRd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param invOrgAmt
	 */
	public void setInvOrgAmt(String invOrgAmt) {
		this.invOrgAmt = invOrgAmt;
	}
	
	/**
	 * Column Info
	 * @param invChgAmt
	 */
	public void setInvChgAmt(String invChgAmt) {
		this.invChgAmt = invChgAmt;
	}
	
	/**
	 * Column Info
	 * @param exptAmt
	 */
	public void setExptAmt(String exptAmt) {
		this.exptAmt = exptAmt;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param svcProvdrCd
	 */
	public void setSvcProvdrCd(String svcProvdrCd) {
		this.svcProvdrCd = svcProvdrCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCneeCd(JSPUtil.getParameter(request, "cnee_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, "org_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, "fx_ft_ovr_dys", ""));
		setFtCmncDtRd(JSPUtil.getParameter(request, "ft_cmnc_dt_rd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setShipperNm(JSPUtil.getParameter(request, "shipper_nm", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setShipperCd(JSPUtil.getParameter(request, "shipper_cd", ""));
		setArActNm(JSPUtil.getParameter(request, "ar_act_nm", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setPayerCd(JSPUtil.getParameter(request, "payer_cd", ""));
		setToMvmtDtRd(JSPUtil.getParameter(request, "to_mvmt_dt_rd", ""));
		setSvcProvdrNm(JSPUtil.getParameter(request, "svc_provdr_nm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setLoc(JSPUtil.getParameter(request, "loc", ""));
		setArActCd(JSPUtil.getParameter(request, "ar_act_cd", ""));
		setFtCmncDt(JSPUtil.getParameter(request, "ft_cmnc_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setInvDcAmt(JSPUtil.getParameter(request, "inv_dc_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, "fm_mvmt_dt", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setFtEndDtRd(JSPUtil.getParameter(request, "ft_end_dt_rd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setFmMvmtDtRd(JSPUtil.getParameter(request, "fm_mvmt_dt_rd", ""));
		setBilAmt(JSPUtil.getParameter(request, "bil_amt", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setPayerNm(JSPUtil.getParameter(request, "payer_nm", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, "fm_mvmt_yd_cd", ""));
		setInvOrgAmt(JSPUtil.getParameter(request, "inv_org_amt", ""));
		setInvChgAmt(JSPUtil.getParameter(request, "inv_chg_amt", ""));
		setExptAmt(JSPUtil.getParameter(request, "expt_amt", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, "dmdt_inv_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setNtfyCd(JSPUtil.getParameter(request, "ntfy_cd", ""));
		setSvcProvdrCd(JSPUtil.getParameter(request, "svc_provdr_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, "org_chg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemandNoteGroupListVO[]
	 */
	public DemandNoteGroupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemandNoteGroupListVO[]
	 */
	public DemandNoteGroupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemandNoteGroupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			String[] ftCmncDtRd = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt_rd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] arActNm = (JSPUtil.getParameter(request, prefix	+ "ar_act_nm", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] payerCd = (JSPUtil.getParameter(request, prefix	+ "payer_cd", length));
			String[] toMvmtDtRd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt_rd", length));
			String[] svcProvdrNm = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_nm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "loc", length));
			String[] arActCd = (JSPUtil.getParameter(request, prefix	+ "ar_act_cd", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] invDcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_dc_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] ftEndDtRd = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt_rd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] fmMvmtDtRd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt_rd", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] payerNm = (JSPUtil.getParameter(request, prefix	+ "payer_nm", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] invOrgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_org_amt", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] exptAmt = (JSPUtil.getParameter(request, prefix	+ "expt_amt", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] svcProvdrCd = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemandNoteGroupListVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				if (ftCmncDtRd[i] != null)
					model.setFtCmncDtRd(ftCmncDtRd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (arActNm[i] != null)
					model.setArActNm(arActNm[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (payerCd[i] != null)
					model.setPayerCd(payerCd[i]);
				if (toMvmtDtRd[i] != null)
					model.setToMvmtDtRd(toMvmtDtRd[i]);
				if (svcProvdrNm[i] != null)
					model.setSvcProvdrNm(svcProvdrNm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (arActCd[i] != null)
					model.setArActCd(arActCd[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (invDcAmt[i] != null)
					model.setInvDcAmt(invDcAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (ftEndDtRd[i] != null)
					model.setFtEndDtRd(ftEndDtRd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (fmMvmtDtRd[i] != null)
					model.setFmMvmtDtRd(fmMvmtDtRd[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
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
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (invOrgAmt[i] != null)
					model.setInvOrgAmt(invOrgAmt[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (exptAmt[i] != null)
					model.setExptAmt(exptAmt[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (svcProvdrCd[i] != null)
					model.setSvcProvdrCd(svcProvdrCd[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemandNoteGroupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemandNoteGroupListVO[]
	 */
	public DemandNoteGroupListVO[] getDemandNoteGroupListVOs(){
		DemandNoteGroupListVO[] vos = (DemandNoteGroupListVO[])models.toArray(new DemandNoteGroupListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDtRd = this.ftCmncDtRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActNm = this.arActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCd = this.payerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDtRd = this.toMvmtDtRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrNm = this.svcProvdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActCd = this.arActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDcAmt = this.invDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDtRd = this.ftEndDtRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDtRd = this.fmMvmtDtRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerNm = this.payerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOrgAmt = this.invOrgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptAmt = this.exptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrCd = this.svcProvdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
