/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNoteListVO.java
*@FileTitle : DemandNoteListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.23 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class DemandNoteListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemandNoteListVO> models = new ArrayList<DemandNoteListVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String orgCurrCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String payerNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String arActNm = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String payerCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String invOrgAmt = null;
	/* Column Info */
	private String exptAmt = null;
	/* Column Info */
	private String invChgAmt = null;
	/* Column Info */
	private String svcProvdrNm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String arActCd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String svcProvdrCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String invDcAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String orgChgAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DemandNoteListVO() {}

	public DemandNoteListVO(String ibflag, String pagerows, String bkgNo, String blNo, String cntrQty, String cntrNo, String dmdtChgStsCd, String ofcCd, String fmMvmtYdCd, String port, String dmdtTrfCd, String payerCd, String payerNm, String shipperCd, String shipperNm, String cneeCd, String cneeNm, String ntfyCd, String ntfyNm, String arActCd, String arActNm, String svcProvdrCd, String svcProvdrNm, String scNo, String rfaNo, String invCurrCd, String invChgAmt, String invOrgAmt, String invDcAmt, String orgCurrCd, String orgChgAmt, String exptAmt, String dcAmt, String bilAmt, String invXchRt, String svrId, String cntrCycNo, String dmdtChgLocDivCd, String chgSeq, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd) {
		this.port = port;
		this.cneeCd = cneeCd;
		this.vslCd = vslCd;
		this.cntrCycNo = cntrCycNo;
		this.chgSeq = chgSeq;
		this.bilAmt = bilAmt;
		this.orgCurrCd = orgCurrCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.svrId = svrId;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.dcAmt = dcAmt;
		this.ibflag = ibflag;
		this.dmdtChgStsCd = dmdtChgStsCd;
		this.shipperNm = shipperNm;
		this.payerNm = payerNm;
		this.scNo = scNo;
		this.shipperCd = shipperCd;
		this.cntrQty = cntrQty;
		this.arActNm = arActNm;
		this.invXchRt = invXchRt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.payerCd = payerCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.invOrgAmt = invOrgAmt;
		this.exptAmt = exptAmt;
		this.invChgAmt = invChgAmt;
		this.svcProvdrNm = svcProvdrNm;
		this.skdVoyNo = skdVoyNo;
		this.invCurrCd = invCurrCd;
		this.arActCd = arActCd;
		this.ntfyNm = ntfyNm;
		this.skdDirCd = skdDirCd;
		this.ntfyCd = ntfyCd;
		this.svcProvdrCd = svcProvdrCd;
		this.podCd = podCd;
		this.invDcAmt = invDcAmt;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.cntrNo = cntrNo;
		this.orgChgAmt = orgChgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("org_curr_cd", getOrgCurrCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("payer_nm", getPayerNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("ar_act_nm", getArActNm());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("payer_cd", getPayerCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("inv_org_amt", getInvOrgAmt());
		this.hashColumns.put("expt_amt", getExptAmt());
		this.hashColumns.put("inv_chg_amt", getInvChgAmt());
		this.hashColumns.put("svc_provdr_nm", getSvcProvdrNm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("ar_act_cd", getArActCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("svc_provdr_cd", getSvcProvdrCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("inv_dc_amt", getInvDcAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("org_chg_amt", getOrgChgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("org_curr_cd", "orgCurrCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("payer_nm", "payerNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("ar_act_nm", "arActNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("payer_cd", "payerCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("inv_org_amt", "invOrgAmt");
		this.hashFields.put("expt_amt", "exptAmt");
		this.hashFields.put("inv_chg_amt", "invChgAmt");
		this.hashFields.put("svc_provdr_nm", "svcProvdrNm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("ar_act_cd", "arActCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("svc_provdr_cd", "svcProvdrCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("inv_dc_amt", "invDcAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("org_chg_amt", "orgChgAmt");
		return this.hashFields;
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
	 * @return bilAmt
	 */
	public String getBilAmt() {
		return this.bilAmt;
	}
	
	/**
	 * Column Info
	 * @return orgCurrCd
	 */
	public String getOrgCurrCd() {
		return this.orgCurrCd;
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
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return exptAmt
	 */
	public String getExptAmt() {
		return this.exptAmt;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
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
	 * @param bilAmt
	 */
	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}
	
	/**
	 * Column Info
	 * @param orgCurrCd
	 */
	public void setOrgCurrCd(String orgCurrCd) {
		this.orgCurrCd = orgCurrCd;
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
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param exptAmt
	 */
	public void setExptAmt(String exptAmt) {
		this.exptAmt = exptAmt;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
		setPort(JSPUtil.getParameter(request, "port", ""));
		setCneeCd(JSPUtil.getParameter(request, "cnee_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setBilAmt(JSPUtil.getParameter(request, "bil_amt", ""));
		setOrgCurrCd(JSPUtil.getParameter(request, "org_curr_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDcAmt(JSPUtil.getParameter(request, "dc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		setShipperNm(JSPUtil.getParameter(request, "shipper_nm", ""));
		setPayerNm(JSPUtil.getParameter(request, "payer_nm", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setShipperCd(JSPUtil.getParameter(request, "shipper_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setArActNm(JSPUtil.getParameter(request, "ar_act_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setPayerCd(JSPUtil.getParameter(request, "payer_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, "fm_mvmt_yd_cd", ""));
		setInvOrgAmt(JSPUtil.getParameter(request, "inv_org_amt", ""));
		setExptAmt(JSPUtil.getParameter(request, "expt_amt", ""));
		setInvChgAmt(JSPUtil.getParameter(request, "inv_chg_amt", ""));
		setSvcProvdrNm(JSPUtil.getParameter(request, "svc_provdr_nm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setArActCd(JSPUtil.getParameter(request, "ar_act_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, "ntfy_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setNtfyCd(JSPUtil.getParameter(request, "ntfy_cd", ""));
		setSvcProvdrCd(JSPUtil.getParameter(request, "svc_provdr_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setInvDcAmt(JSPUtil.getParameter(request, "inv_dc_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOrgChgAmt(JSPUtil.getParameter(request, "org_chg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemandNoteListVO[]
	 */
	public DemandNoteListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemandNoteListVO[]
	 */
	public DemandNoteListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemandNoteListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] orgCurrCd = (JSPUtil.getParameter(request, prefix	+ "org_curr_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] payerNm = (JSPUtil.getParameter(request, prefix	+ "payer_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] arActNm = (JSPUtil.getParameter(request, prefix	+ "ar_act_nm", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] payerCd = (JSPUtil.getParameter(request, prefix	+ "payer_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] invOrgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_org_amt", length));
			String[] exptAmt = (JSPUtil.getParameter(request, prefix	+ "expt_amt", length));
			String[] invChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_chg_amt", length));
			String[] svcProvdrNm = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_nm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] arActCd = (JSPUtil.getParameter(request, prefix	+ "ar_act_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] svcProvdrCd = (JSPUtil.getParameter(request, prefix	+ "svc_provdr_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] invDcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_dc_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] orgChgAmt = (JSPUtil.getParameter(request, prefix	+ "org_chg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemandNoteListVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (orgCurrCd[i] != null)
					model.setOrgCurrCd(orgCurrCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (payerNm[i] != null)
					model.setPayerNm(payerNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (arActNm[i] != null)
					model.setArActNm(arActNm[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (payerCd[i] != null)
					model.setPayerCd(payerCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (invOrgAmt[i] != null)
					model.setInvOrgAmt(invOrgAmt[i]);
				if (exptAmt[i] != null)
					model.setExptAmt(exptAmt[i]);
				if (invChgAmt[i] != null)
					model.setInvChgAmt(invChgAmt[i]);
				if (svcProvdrNm[i] != null)
					model.setSvcProvdrNm(svcProvdrNm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (arActCd[i] != null)
					model.setArActCd(arActCd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (svcProvdrCd[i] != null)
					model.setSvcProvdrCd(svcProvdrCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (invDcAmt[i] != null)
					model.setInvDcAmt(invDcAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (orgChgAmt[i] != null)
					model.setOrgChgAmt(orgChgAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemandNoteListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemandNoteListVO[]
	 */
	public DemandNoteListVO[] getDemandNoteListVOs(){
		DemandNoteListVO[] vos = (DemandNoteListVO[])models.toArray(new DemandNoteListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCurrCd = this.orgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerNm = this.payerNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActNm = this.arActNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCd = this.payerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOrgAmt = this.invOrgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptAmt = this.exptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChgAmt = this.invChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrNm = this.svcProvdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arActCd = this.arActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcProvdrCd = this.svcProvdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDcAmt = this.invDcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgAmt = this.orgChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
