/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchTruckInvoiceFileImportVO.java
*@FileTitle : SearchTruckInvoiceFileImportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.03.15 양봉준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo;

import java.lang.reflect.Field;
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
 * @author 양봉준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTruckInvoiceFileImportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTruckInvoiceFileImportVO> models = new ArrayList<SearchTruckInvoiceFileImportVO>();
	
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String dorDeAddr = null;
	/* Column Info */
	private String trspInvCalcLgcTpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String orgEqNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String creTm = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String surchargeKey = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String orgEqTpszCd = null;
	/* Column Info */
	private String woTotAmt = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String orgGateOutDt = null;
	/* Column Info */
	private String invBzcAmt = null;
	/* Column Info */
	private String trspSoOfcCtyCdSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String toYardValue = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String verifyResult = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String trspMtyCostModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String dorYardValue = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dorSvcTpCd = null;
	/* Column Info */
	private String fmLocValue = null;
	/* Column Info */
	private String fmYardValue = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String viaYardValue = null;
	/* Column Info */
	private String cntrSubFlg = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String invEtcAddAmt = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String toLocValue = null;
	/* Column Info */
	private String viaLocValue = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String destGateInDt = null;
	/* Column Info */
	private String dorLocValue = null;
	/* Column Info */
	private String trspWoOfcCtyCdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTruckInvoiceFileImportVO() {}

	public SearchTruckInvoiceFileImportVO(String ibflag, String pagerows, String eqNo, String orgEqNo, String eqTpszCd, String orgEqTpszCd, String eqKndCd, String fmLocValue, String fmYardValue, String viaLocValue, String viaYardValue, String toLocValue, String toYardValue, String dorLocValue, String dorYardValue, String custCntCd, String custSeq, String dorDeAddr, String currCd, String bzcAmt, String negoAmt, String fuelScgAmt, String etcAddAmt, String woTotAmt, String trspInvCalcLgcTpCd, String invXchRt, String invCurrCd, String invBzcAmt, String invEtcAddAmt, String trspWoOfcCtyCd, String trspWoSeq, String trspWoOfcCtyCdSeq, String creDt, String creTm, String bkgNo, String blNo, String cgoTpCd, String spclCgoCntrTpCd, String trspBndCd, String trspCostDtlModCd, String dorSvcTpCd, String n3ptyBilFlg, String verifyResult, String interRmk, String spclInstrRmk, String cntrNo, String cntrTpszCd, String orgGateOutDt, String destGateInDt, String trspSoOfcCtyCdSeq, String trspSoOfcCtyCd, String trspSoSeq, String surchargeKey, String trspMtyCostModCd, String trspSoTpCd, String creOfcCd, String costActGrpCd, String cntrSubFlg) {
		this.trspSoSeq = trspSoSeq;
		this.dorDeAddr = dorDeAddr;
		this.trspInvCalcLgcTpCd = trspInvCalcLgcTpCd;
		this.cgoTpCd = cgoTpCd;
		this.orgEqNo = orgEqNo;
		this.blNo = blNo;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.pagerows = pagerows;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.cntrTpszCd = cntrTpszCd;
		this.creTm = creTm;
		this.trspSoTpCd = trspSoTpCd;
		this.custCntCd = custCntCd;
		this.invXchRt = invXchRt;
		this.trspWoSeq = trspWoSeq;
		this.surchargeKey = surchargeKey;
		this.eqTpszCd = eqTpszCd;
		this.orgEqTpszCd = orgEqTpszCd;
		this.woTotAmt = woTotAmt;
		this.negoAmt = negoAmt;
		this.costActGrpCd = costActGrpCd;
		this.bkgNo = bkgNo;
		this.orgGateOutDt = orgGateOutDt;
		this.invBzcAmt = invBzcAmt;
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
		this.currCd = currCd;
		this.toYardValue = toYardValue;
		this.creDt = creDt;
		this.verifyResult = verifyResult;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.trspMtyCostModCd = trspMtyCostModCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.interRmk = interRmk;
		this.dorYardValue = dorYardValue;
		this.creOfcCd = creOfcCd;
		this.dorSvcTpCd = dorSvcTpCd;
		this.fmLocValue = fmLocValue;
		this.fmYardValue = fmYardValue;
		this.spclInstrRmk = spclInstrRmk;
		this.viaYardValue = viaYardValue;
		this.cntrSubFlg = cntrSubFlg;
		this.etcAddAmt = etcAddAmt;
		this.trspBndCd = trspBndCd;
		this.eqKndCd = eqKndCd;
		this.bzcAmt = bzcAmt;
		this.custSeq = custSeq;
		this.invCurrCd = invCurrCd;
		this.fuelScgAmt = fuelScgAmt;
		this.invEtcAddAmt = invEtcAddAmt;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.toLocValue = toLocValue;
		this.viaLocValue = viaLocValue;
		this.cntrNo = cntrNo;
		this.destGateInDt = destGateInDt;
		this.dorLocValue = dorLocValue;
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("dor_de_addr", getDorDeAddr());
		this.hashColumns.put("trsp_inv_calc_lgc_tp_cd", getTrspInvCalcLgcTpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("org_eq_no", getOrgEqNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cre_tm", getCreTm());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("surcharge_key", getSurchargeKey());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("org_eq_tpsz_cd", getOrgEqTpszCd());
		this.hashColumns.put("wo_tot_amt", getWoTotAmt());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("org_gate_out_dt", getOrgGateOutDt());
		this.hashColumns.put("inv_bzc_amt", getInvBzcAmt());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("to_yard_value", getToYardValue());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("verify_result", getVerifyResult());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("trsp_mty_cost_mod_cd", getTrspMtyCostModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("dor_yard_value", getDorYardValue());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dor_svc_tp_cd", getDorSvcTpCd());
		this.hashColumns.put("fm_loc_value", getFmLocValue());
		this.hashColumns.put("fm_yard_value", getFmYardValue());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("via_yard_value", getViaYardValue());
		this.hashColumns.put("cntr_sub_flg", getCntrSubFlg());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("inv_etc_add_amt", getInvEtcAddAmt());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("to_loc_value", getToLocValue());
		this.hashColumns.put("via_loc_value", getViaLocValue());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dest_gate_in_dt", getDestGateInDt());
		this.hashColumns.put("dor_loc_value", getDorLocValue());
		this.hashColumns.put("trsp_wo_ofc_cty_cd_seq", getTrspWoOfcCtyCdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("dor_de_addr", "dorDeAddr");
		this.hashFields.put("trsp_inv_calc_lgc_tp_cd", "trspInvCalcLgcTpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("org_eq_no", "orgEqNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cre_tm", "creTm");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("surcharge_key", "surchargeKey");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("org_eq_tpsz_cd", "orgEqTpszCd");
		this.hashFields.put("wo_tot_amt", "woTotAmt");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("org_gate_out_dt", "orgGateOutDt");
		this.hashFields.put("inv_bzc_amt", "invBzcAmt");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("to_yard_value", "toYardValue");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("verify_result", "verifyResult");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("trsp_mty_cost_mod_cd", "trspMtyCostModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("dor_yard_value", "dorYardValue");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dor_svc_tp_cd", "dorSvcTpCd");
		this.hashFields.put("fm_loc_value", "fmLocValue");
		this.hashFields.put("fm_yard_value", "fmYardValue");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("via_yard_value", "viaYardValue");
		this.hashFields.put("cntr_sub_flg", "cntrSubFlg");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("inv_etc_add_amt", "invEtcAddAmt");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("to_loc_value", "toLocValue");
		this.hashFields.put("via_loc_value", "viaLocValue");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dest_gate_in_dt", "destGateInDt");
		this.hashFields.put("dor_loc_value", "dorLocValue");
		this.hashFields.put("trsp_wo_ofc_cty_cd_seq", "trspWoOfcCtyCdSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return dorDeAddr
	 */
	public String getDorDeAddr() {
		return this.dorDeAddr;
	}
	
	/**
	 * Column Info
	 * @return trspInvCalcLgcTpCd
	 */
	public String getTrspInvCalcLgcTpCd() {
		return this.trspInvCalcLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgEqNo
	 */
	public String getOrgEqNo() {
		return this.orgEqNo;
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
	 * @return spclCgoCntrTpCd
	 */
	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
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
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
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
	 * @return creTm
	 */
	public String getCreTm() {
		return this.creTm;
	}
	
	/**
	 * Column Info
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return surchargeKey
	 */
	public String getSurchargeKey() {
		return this.surchargeKey;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return orgEqTpszCd
	 */
	public String getOrgEqTpszCd() {
		return this.orgEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return woTotAmt
	 */
	public String getWoTotAmt() {
		return this.woTotAmt;
	}
	
	/**
	 * Column Info
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
	}
	
	/**
	 * Column Info
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
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
	 * @return orgGateOutDt
	 */
	public String getOrgGateOutDt() {
		return this.orgGateOutDt;
	}
	
	/**
	 * Column Info
	 * @return invBzcAmt
	 */
	public String getInvBzcAmt() {
		return this.invBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCdSeq
	 */
	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return toYardValue
	 */
	public String getToYardValue() {
		return this.toYardValue;
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
	 * @return verifyResult
	 */
	public String getVerifyResult() {
		return this.verifyResult;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trspMtyCostModCd
	 */
	public String getTrspMtyCostModCd() {
		return this.trspMtyCostModCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return dorYardValue
	 */
	public String getDorYardValue() {
		return this.dorYardValue;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dorSvcTpCd
	 */
	public String getDorSvcTpCd() {
		return this.dorSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmLocValue
	 */
	public String getFmLocValue() {
		return this.fmLocValue;
	}
	
	/**
	 * Column Info
	 * @return fmYardValue
	 */
	public String getFmYardValue() {
		return this.fmYardValue;
	}
	
	/**
	 * Column Info
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @return viaYardValue
	 */
	public String getViaYardValue() {
		return this.viaYardValue;
	}
	
	/**
	 * Column Info
	 * @return cntrSubFlg
	 */
	public String getCntrSubFlg() {
		return this.cntrSubFlg;
	}
	
	/**
	 * Column Info
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return invEtcAddAmt
	 */
	public String getInvEtcAddAmt() {
		return this.invEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @return toLocValue
	 */
	public String getToLocValue() {
		return this.toLocValue;
	}
	
	/**
	 * Column Info
	 * @return viaLocValue
	 */
	public String getViaLocValue() {
		return this.viaLocValue;
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
	 * @return destGateInDt
	 */
	public String getDestGateInDt() {
		return this.destGateInDt;
	}
	
	/**
	 * Column Info
	 * @return dorLocValue
	 */
	public String getDorLocValue() {
		return this.dorLocValue;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCdSeq
	 */
	public String getTrspWoOfcCtyCdSeq() {
		return this.trspWoOfcCtyCdSeq;
	}
	

	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param dorDeAddr
	 */
	public void setDorDeAddr(String dorDeAddr) {
		this.dorDeAddr = dorDeAddr;
	}
	
	/**
	 * Column Info
	 * @param trspInvCalcLgcTpCd
	 */
	public void setTrspInvCalcLgcTpCd(String trspInvCalcLgcTpCd) {
		this.trspInvCalcLgcTpCd = trspInvCalcLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgEqNo
	 */
	public void setOrgEqNo(String orgEqNo) {
		this.orgEqNo = orgEqNo;
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
	 * @param spclCgoCntrTpCd
	 */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
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
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
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
	 * @param creTm
	 */
	public void setCreTm(String creTm) {
		this.creTm = creTm;
	}
	
	/**
	 * Column Info
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param surchargeKey
	 */
	public void setSurchargeKey(String surchargeKey) {
		this.surchargeKey = surchargeKey;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param orgEqTpszCd
	 */
	public void setOrgEqTpszCd(String orgEqTpszCd) {
		this.orgEqTpszCd = orgEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param woTotAmt
	 */
	public void setWoTotAmt(String woTotAmt) {
		this.woTotAmt = woTotAmt;
	}
	
	/**
	 * Column Info
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}
	
	/**
	 * Column Info
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
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
	 * @param orgGateOutDt
	 */
	public void setOrgGateOutDt(String orgGateOutDt) {
		this.orgGateOutDt = orgGateOutDt;
	}
	
	/**
	 * Column Info
	 * @param invBzcAmt
	 */
	public void setInvBzcAmt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCdSeq
	 */
	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param toYardValue
	 */
	public void setToYardValue(String toYardValue) {
		this.toYardValue = toYardValue;
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
	 * @param verifyResult
	 */
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trspMtyCostModCd
	 */
	public void setTrspMtyCostModCd(String trspMtyCostModCd) {
		this.trspMtyCostModCd = trspMtyCostModCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param dorYardValue
	 */
	public void setDorYardValue(String dorYardValue) {
		this.dorYardValue = dorYardValue;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dorSvcTpCd
	 */
	public void setDorSvcTpCd(String dorSvcTpCd) {
		this.dorSvcTpCd = dorSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmLocValue
	 */
	public void setFmLocValue(String fmLocValue) {
		this.fmLocValue = fmLocValue;
	}
	
	/**
	 * Column Info
	 * @param fmYardValue
	 */
	public void setFmYardValue(String fmYardValue) {
		this.fmYardValue = fmYardValue;
	}
	
	/**
	 * Column Info
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @param viaYardValue
	 */
	public void setViaYardValue(String viaYardValue) {
		this.viaYardValue = viaYardValue;
	}
	
	/**
	 * Column Info
	 * @param cntrSubFlg
	 */
	public void setCntrSubFlg(String cntrSubFlg) {
		this.cntrSubFlg = cntrSubFlg;
	}
	
	/**
	 * Column Info
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param invEtcAddAmt
	 */
	public void setInvEtcAddAmt(String invEtcAddAmt) {
		this.invEtcAddAmt = invEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @param toLocValue
	 */
	public void setToLocValue(String toLocValue) {
		this.toLocValue = toLocValue;
	}
	
	/**
	 * Column Info
	 * @param viaLocValue
	 */
	public void setViaLocValue(String viaLocValue) {
		this.viaLocValue = viaLocValue;
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
	 * @param destGateInDt
	 */
	public void setDestGateInDt(String destGateInDt) {
		this.destGateInDt = destGateInDt;
	}
	
	/**
	 * Column Info
	 * @param dorLocValue
	 */
	public void setDorLocValue(String dorLocValue) {
		this.dorLocValue = dorLocValue;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCdSeq
	 */
	public void setTrspWoOfcCtyCdSeq(String trspWoOfcCtyCdSeq) {
		this.trspWoOfcCtyCdSeq = trspWoOfcCtyCdSeq;
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
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setDorDeAddr(JSPUtil.getParameter(request, prefix + "dor_de_addr", ""));
		setTrspInvCalcLgcTpCd(JSPUtil.getParameter(request, prefix + "trsp_inv_calc_lgc_tp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setOrgEqNo(JSPUtil.getParameter(request, prefix + "org_eq_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCreTm(JSPUtil.getParameter(request, prefix + "cre_tm", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setSurchargeKey(JSPUtil.getParameter(request, prefix + "surcharge_key", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setOrgEqTpszCd(JSPUtil.getParameter(request, prefix + "org_eq_tpsz_cd", ""));
		setWoTotAmt(JSPUtil.getParameter(request, prefix + "wo_tot_amt", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOrgGateOutDt(JSPUtil.getParameter(request, prefix + "org_gate_out_dt", ""));
		setInvBzcAmt(JSPUtil.getParameter(request, prefix + "inv_bzc_amt", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setToYardValue(JSPUtil.getParameter(request, prefix + "to_yard_value", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVerifyResult(JSPUtil.getParameter(request, prefix + "verify_result", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setTrspMtyCostModCd(JSPUtil.getParameter(request, prefix + "trsp_mty_cost_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setDorYardValue(JSPUtil.getParameter(request, prefix + "dor_yard_value", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setDorSvcTpCd(JSPUtil.getParameter(request, prefix + "dor_svc_tp_cd", ""));
		setFmLocValue(JSPUtil.getParameter(request, prefix + "fm_loc_value", ""));
		setFmYardValue(JSPUtil.getParameter(request, prefix + "fm_yard_value", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setViaYardValue(JSPUtil.getParameter(request, prefix + "via_yard_value", ""));
		setCntrSubFlg(JSPUtil.getParameter(request, prefix + "cntr_sub_flg", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setInvEtcAddAmt(JSPUtil.getParameter(request, prefix + "inv_etc_add_amt", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setToLocValue(JSPUtil.getParameter(request, prefix + "to_loc_value", ""));
		setViaLocValue(JSPUtil.getParameter(request, prefix + "via_loc_value", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDestGateInDt(JSPUtil.getParameter(request, prefix + "dest_gate_in_dt", ""));
		setDorLocValue(JSPUtil.getParameter(request, prefix + "dor_loc_value", ""));
		setTrspWoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTruckInvoiceFileImportVO[]
	 */
	public SearchTruckInvoiceFileImportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTruckInvoiceFileImportVO[]
	 */
	public SearchTruckInvoiceFileImportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTruckInvoiceFileImportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] dorDeAddr = (JSPUtil.getParameter(request, prefix	+ "dor_de_addr", length));
			String[] trspInvCalcLgcTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_inv_calc_lgc_tp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] orgEqNo = (JSPUtil.getParameter(request, prefix	+ "org_eq_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cntr_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] creTm = (JSPUtil.getParameter(request, prefix	+ "cre_tm", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] surchargeKey = (JSPUtil.getParameter(request, prefix	+ "surcharge_key", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] orgEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "org_eq_tpsz_cd", length));
			String[] woTotAmt = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] orgGateOutDt = (JSPUtil.getParameter(request, prefix	+ "org_gate_out_dt", length));
			String[] invBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bzc_amt", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] toYardValue = (JSPUtil.getParameter(request, prefix	+ "to_yard_value", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] verifyResult = (JSPUtil.getParameter(request, prefix	+ "verify_result", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] trspMtyCostModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mty_cost_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] dorYardValue = (JSPUtil.getParameter(request, prefix	+ "dor_yard_value", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dorSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "dor_svc_tp_cd", length));
			String[] fmLocValue = (JSPUtil.getParameter(request, prefix	+ "fm_loc_value", length));
			String[] fmYardValue = (JSPUtil.getParameter(request, prefix	+ "fm_yard_value", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] viaYardValue = (JSPUtil.getParameter(request, prefix	+ "via_yard_value", length));
			String[] cntrSubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_sub_flg", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] invEtcAddAmt = (JSPUtil.getParameter(request, prefix	+ "inv_etc_add_amt", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] toLocValue = (JSPUtil.getParameter(request, prefix	+ "to_loc_value", length));
			String[] viaLocValue = (JSPUtil.getParameter(request, prefix	+ "via_loc_value", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] destGateInDt = (JSPUtil.getParameter(request, prefix	+ "dest_gate_in_dt", length));
			String[] dorLocValue = (JSPUtil.getParameter(request, prefix	+ "dor_loc_value", length));
			String[] trspWoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTruckInvoiceFileImportVO();
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (dorDeAddr[i] != null)
					model.setDorDeAddr(dorDeAddr[i]);
				if (trspInvCalcLgcTpCd[i] != null)
					model.setTrspInvCalcLgcTpCd(trspInvCalcLgcTpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (orgEqNo[i] != null)
					model.setOrgEqNo(orgEqNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (creTm[i] != null)
					model.setCreTm(creTm[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (surchargeKey[i] != null)
					model.setSurchargeKey(surchargeKey[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (orgEqTpszCd[i] != null)
					model.setOrgEqTpszCd(orgEqTpszCd[i]);
				if (woTotAmt[i] != null)
					model.setWoTotAmt(woTotAmt[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (orgGateOutDt[i] != null)
					model.setOrgGateOutDt(orgGateOutDt[i]);
				if (invBzcAmt[i] != null)
					model.setInvBzcAmt(invBzcAmt[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (toYardValue[i] != null)
					model.setToYardValue(toYardValue[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (verifyResult[i] != null)
					model.setVerifyResult(verifyResult[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (trspMtyCostModCd[i] != null)
					model.setTrspMtyCostModCd(trspMtyCostModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (dorYardValue[i] != null)
					model.setDorYardValue(dorYardValue[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dorSvcTpCd[i] != null)
					model.setDorSvcTpCd(dorSvcTpCd[i]);
				if (fmLocValue[i] != null)
					model.setFmLocValue(fmLocValue[i]);
				if (fmYardValue[i] != null)
					model.setFmYardValue(fmYardValue[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (viaYardValue[i] != null)
					model.setViaYardValue(viaYardValue[i]);
				if (cntrSubFlg[i] != null)
					model.setCntrSubFlg(cntrSubFlg[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (invEtcAddAmt[i] != null)
					model.setInvEtcAddAmt(invEtcAddAmt[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (toLocValue[i] != null)
					model.setToLocValue(toLocValue[i]);
				if (viaLocValue[i] != null)
					model.setViaLocValue(viaLocValue[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (destGateInDt[i] != null)
					model.setDestGateInDt(destGateInDt[i]);
				if (dorLocValue[i] != null)
					model.setDorLocValue(dorLocValue[i]);
				if (trspWoOfcCtyCdSeq[i] != null)
					model.setTrspWoOfcCtyCdSeq(trspWoOfcCtyCdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTruckInvoiceFileImportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTruckInvoiceFileImportVO[]
	 */
	public SearchTruckInvoiceFileImportVO[] getSearchTruckInvoiceFileImportVOs(){
		SearchTruckInvoiceFileImportVO[] vos = (SearchTruckInvoiceFileImportVO[])models.toArray(new SearchTruckInvoiceFileImportVO[models.size()]);
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
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorDeAddr = this.dorDeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspInvCalcLgcTpCd = this.trspInvCalcLgcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEqNo = this.orgEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTm = this.creTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surchargeKey = this.surchargeKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEqTpszCd = this.orgEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmt = this.woTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutDt = this.orgGateOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBzcAmt = this.invBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardValue = this.toYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verifyResult = this.verifyResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyCostModCd = this.trspMtyCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorYardValue = this.dorYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorSvcTpCd = this.dorSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocValue = this.fmLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardValue = this.fmYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaYardValue = this.viaYardValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSubFlg = this.cntrSubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEtcAddAmt = this.invEtcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocValue = this.toLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaLocValue = this.viaLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateInDt = this.destGateInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocValue = this.dorLocValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCdSeq = this.trspWoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
