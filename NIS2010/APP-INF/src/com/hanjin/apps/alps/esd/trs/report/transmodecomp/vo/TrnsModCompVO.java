/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrnsModCompVO.java
*@FileTitle : TrnsModCompVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.transmodecomp.vo;

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

public class TrnsModCompVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrnsModCompVO> models = new ArrayList<TrnsModCompVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String soCurrCd = null;
	/* Column Info */
	private String troCnfm = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String cngRsnDesc = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String rowCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ihcSumUsd = null;
	/* Column Info */
	private String chgRtUsd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* Column Info */
	private String chgTrnsMod = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String soTotAmt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String chgAmtUsd = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String autoRatCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String woIssDt = null;
	/* Column Info */
	private String troTrnsMod = null;
	/* Column Info */
	private String compResult = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String soOfcCd = null;
	/* Column Info */
	private String inclOftFlg = null;
	/* Column Info */
	private String inlandPnl = null;
	/* Column Info */
	private String soBkgSumUsd = null;
	/* Column Info */
	private String soCreDt = null;
	/* Column Info */
	private String soTotAmtUsd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String soTrnsMod = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String troOfcCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String ratAsQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrnsModCompVO() {}

	public TrnsModCompVO(String ibflag, String pagerows, String seq, String compResult, String inlandPnl, String soNo, String trspBndCd, String trspCostDtlModCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String soOfcCd, String soCreDt, String woOfcCd, String woNo, String woIssDt, String eqNo, String eqTpszCd, String bkgNo, String soTrnsMod, String soCurrCd, String soTotAmt, String soTotAmtUsd, String soBkgSumUsd, String troTrnsMod, String troOfcCd, String troCnfm, String chgCd, String chgTrnsMod, String chgCurrCd, String chgUtAmt, String chgRtUsd, String ratAsQty, String ratUtCd, String chgAmt, String chgAmtUsd, String rowCnt, String inclOftFlg, String autoRatCd, String ihcSumUsd, String rfaNo, String scNo, String taaNo, String cngRsnDesc) {
		this.toNodCd = toNodCd;
		this.soCurrCd = soCurrCd;
		this.troCnfm = troCnfm;
		this.woOfcCd = woOfcCd;
		this.cngRsnDesc = cngRsnDesc;
		this.chgCd = chgCd;
		this.rowCnt = rowCnt;
		this.pagerows = pagerows;
		this.ihcSumUsd = ihcSumUsd;
		this.chgRtUsd = chgRtUsd;
		this.rfaNo = rfaNo;
		this.chgCurrCd = chgCurrCd;
		this.chgTrnsMod = chgTrnsMod;
		this.ibflag = ibflag;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.eqNo = eqNo;
		this.soTotAmt = soTotAmt;
		this.scNo = scNo;
		this.chgAmt = chgAmt;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.chgAmtUsd = chgAmtUsd;
		this.chgUtAmt = chgUtAmt;
		this.autoRatCd = autoRatCd;
		this.trspBndCd = trspBndCd;
		this.soNo = soNo;
		this.woIssDt = woIssDt;
		this.troTrnsMod = troTrnsMod;
		this.compResult = compResult;
		this.ratUtCd = ratUtCd;
		this.soOfcCd = soOfcCd;
		this.inclOftFlg = inclOftFlg;
		this.inlandPnl = inlandPnl;
		this.soBkgSumUsd = soBkgSumUsd;
		this.soCreDt = soCreDt;
		this.soTotAmtUsd = soTotAmtUsd;
		this.eqTpszCd = eqTpszCd;
		this.fmNodCd = fmNodCd;
		this.bkgNo = bkgNo;
		this.soTrnsMod = soTrnsMod;
		this.taaNo = taaNo;
		this.troOfcCd = troOfcCd;
		this.viaNodCd = viaNodCd;
		this.seq = seq;
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("so_curr_cd", getSoCurrCd());
		this.hashColumns.put("tro_cnfm", getTroCnfm());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("cng_rsn_desc", getCngRsnDesc());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("row_cnt", getRowCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ihc_sum_usd", getIhcSumUsd());
		this.hashColumns.put("chg_rt_usd", getChgRtUsd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("chg_trns_mod", getChgTrnsMod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("so_tot_amt", getSoTotAmt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("chg_amt_usd", getChgAmtUsd());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("auto_rat_cd", getAutoRatCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("wo_iss_dt", getWoIssDt());
		this.hashColumns.put("tro_trns_mod", getTroTrnsMod());
		this.hashColumns.put("comp_result", getCompResult());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("so_ofc_cd", getSoOfcCd());
		this.hashColumns.put("incl_oft_flg", getInclOftFlg());
		this.hashColumns.put("inland_pnl", getInlandPnl());
		this.hashColumns.put("so_bkg_sum_usd", getSoBkgSumUsd());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("so_tot_amt_usd", getSoTotAmtUsd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("so_trns_mod", getSoTrnsMod());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("tro_ofc_cd", getTroOfcCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("so_curr_cd", "soCurrCd");
		this.hashFields.put("tro_cnfm", "troCnfm");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("cng_rsn_desc", "cngRsnDesc");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("row_cnt", "rowCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ihc_sum_usd", "ihcSumUsd");
		this.hashFields.put("chg_rt_usd", "chgRtUsd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("chg_trns_mod", "chgTrnsMod");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("so_tot_amt", "soTotAmt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("chg_amt_usd", "chgAmtUsd");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("auto_rat_cd", "autoRatCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("wo_iss_dt", "woIssDt");
		this.hashFields.put("tro_trns_mod", "troTrnsMod");
		this.hashFields.put("comp_result", "compResult");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("so_ofc_cd", "soOfcCd");
		this.hashFields.put("incl_oft_flg", "inclOftFlg");
		this.hashFields.put("inland_pnl", "inlandPnl");
		this.hashFields.put("so_bkg_sum_usd", "soBkgSumUsd");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("so_tot_amt_usd", "soTotAmtUsd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("so_trns_mod", "soTrnsMod");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("tro_ofc_cd", "troOfcCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return soCurrCd
	 */
	public String getSoCurrCd() {
		return this.soCurrCd;
	}
	
	/**
	 * Column Info
	 * @return troCnfm
	 */
	public String getTroCnfm() {
		return this.troCnfm;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cngRsnDesc
	 */
	public String getCngRsnDesc() {
		return this.cngRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return rowCnt
	 */
	public String getRowCnt() {
		return this.rowCnt;
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
	 * @return ihcSumUsd
	 */
	public String getIhcSumUsd() {
		return this.ihcSumUsd;
	}
	
	/**
	 * Column Info
	 * @return chgRtUsd
	 */
	public String getChgRtUsd() {
		return this.chgRtUsd;
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
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return chgTrnsMod
	 */
	public String getChgTrnsMod() {
		return this.chgTrnsMod;
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
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
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
	 * @return soTotAmt
	 */
	public String getSoTotAmt() {
		return this.soTotAmt;
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
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return chgAmtUsd
	 */
	public String getChgAmtUsd() {
		return this.chgAmtUsd;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return autoRatCd
	 */
	public String getAutoRatCd() {
		return this.autoRatCd;
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
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return woIssDt
	 */
	public String getWoIssDt() {
		return this.woIssDt;
	}
	
	/**
	 * Column Info
	 * @return troTrnsMod
	 */
	public String getTroTrnsMod() {
		return this.troTrnsMod;
	}
	
	/**
	 * Column Info
	 * @return compResult
	 */
	public String getCompResult() {
		return this.compResult;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return soOfcCd
	 */
	public String getSoOfcCd() {
		return this.soOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inclOftFlg
	 */
	public String getInclOftFlg() {
		return this.inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return inlandPnl
	 */
	public String getInlandPnl() {
		return this.inlandPnl;
	}
	
	/**
	 * Column Info
	 * @return soBkgSumUsd
	 */
	public String getSoBkgSumUsd() {
		return this.soBkgSumUsd;
	}
	
	/**
	 * Column Info
	 * @return soCreDt
	 */
	public String getSoCreDt() {
		return this.soCreDt;
	}
	
	/**
	 * Column Info
	 * @return soTotAmtUsd
	 */
	public String getSoTotAmtUsd() {
		return this.soTotAmtUsd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return soTrnsMod
	 */
	public String getSoTrnsMod() {
		return this.soTrnsMod;
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
	 * @return troOfcCd
	 */
	public String getTroOfcCd() {
		return this.troOfcCd;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param soCurrCd
	 */
	public void setSoCurrCd(String soCurrCd) {
		this.soCurrCd = soCurrCd;
	}
	
	/**
	 * Column Info
	 * @param troCnfm
	 */
	public void setTroCnfm(String troCnfm) {
		this.troCnfm = troCnfm;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cngRsnDesc
	 */
	public void setCngRsnDesc(String cngRsnDesc) {
		this.cngRsnDesc = cngRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param rowCnt
	 */
	public void setRowCnt(String rowCnt) {
		this.rowCnt = rowCnt;
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
	 * @param ihcSumUsd
	 */
	public void setIhcSumUsd(String ihcSumUsd) {
		this.ihcSumUsd = ihcSumUsd;
	}
	
	/**
	 * Column Info
	 * @param chgRtUsd
	 */
	public void setChgRtUsd(String chgRtUsd) {
		this.chgRtUsd = chgRtUsd;
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
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param chgTrnsMod
	 */
	public void setChgTrnsMod(String chgTrnsMod) {
		this.chgTrnsMod = chgTrnsMod;
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
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
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
	 * @param soTotAmt
	 */
	public void setSoTotAmt(String soTotAmt) {
		this.soTotAmt = soTotAmt;
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
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param chgAmtUsd
	 */
	public void setChgAmtUsd(String chgAmtUsd) {
		this.chgAmtUsd = chgAmtUsd;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param autoRatCd
	 */
	public void setAutoRatCd(String autoRatCd) {
		this.autoRatCd = autoRatCd;
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
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param woIssDt
	 */
	public void setWoIssDt(String woIssDt) {
		this.woIssDt = woIssDt;
	}
	
	/**
	 * Column Info
	 * @param troTrnsMod
	 */
	public void setTroTrnsMod(String troTrnsMod) {
		this.troTrnsMod = troTrnsMod;
	}
	
	/**
	 * Column Info
	 * @param compResult
	 */
	public void setCompResult(String compResult) {
		this.compResult = compResult;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param soOfcCd
	 */
	public void setSoOfcCd(String soOfcCd) {
		this.soOfcCd = soOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inclOftFlg
	 */
	public void setInclOftFlg(String inclOftFlg) {
		this.inclOftFlg = inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param inlandPnl
	 */
	public void setInlandPnl(String inlandPnl) {
		this.inlandPnl = inlandPnl;
	}
	
	/**
	 * Column Info
	 * @param soBkgSumUsd
	 */
	public void setSoBkgSumUsd(String soBkgSumUsd) {
		this.soBkgSumUsd = soBkgSumUsd;
	}
	
	/**
	 * Column Info
	 * @param soCreDt
	 */
	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
	}
	
	/**
	 * Column Info
	 * @param soTotAmtUsd
	 */
	public void setSoTotAmtUsd(String soTotAmtUsd) {
		this.soTotAmtUsd = soTotAmtUsd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param soTrnsMod
	 */
	public void setSoTrnsMod(String soTrnsMod) {
		this.soTrnsMod = soTrnsMod;
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
	 * @param troOfcCd
	 */
	public void setTroOfcCd(String troOfcCd) {
		this.troOfcCd = troOfcCd;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setSoCurrCd(JSPUtil.getParameter(request, prefix + "so_curr_cd", ""));
		setTroCnfm(JSPUtil.getParameter(request, prefix + "tro_cnfm", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setCngRsnDesc(JSPUtil.getParameter(request, prefix + "cng_rsn_desc", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setRowCnt(JSPUtil.getParameter(request, prefix + "row_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIhcSumUsd(JSPUtil.getParameter(request, prefix + "ihc_sum_usd", ""));
		setChgRtUsd(JSPUtil.getParameter(request, prefix + "chg_rt_usd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
		setChgTrnsMod(JSPUtil.getParameter(request, prefix + "chg_trns_mod", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSoTotAmt(JSPUtil.getParameter(request, prefix + "so_tot_amt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setChgAmtUsd(JSPUtil.getParameter(request, prefix + "chg_amt_usd", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setAutoRatCd(JSPUtil.getParameter(request, prefix + "auto_rat_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setWoIssDt(JSPUtil.getParameter(request, prefix + "wo_iss_dt", ""));
		setTroTrnsMod(JSPUtil.getParameter(request, prefix + "tro_trns_mod", ""));
		setCompResult(JSPUtil.getParameter(request, prefix + "comp_result", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setSoOfcCd(JSPUtil.getParameter(request, prefix + "so_ofc_cd", ""));
		setInclOftFlg(JSPUtil.getParameter(request, prefix + "incl_oft_flg", ""));
		setInlandPnl(JSPUtil.getParameter(request, prefix + "inland_pnl", ""));
		setSoBkgSumUsd(JSPUtil.getParameter(request, prefix + "so_bkg_sum_usd", ""));
		setSoCreDt(JSPUtil.getParameter(request, prefix + "so_cre_dt", ""));
		setSoTotAmtUsd(JSPUtil.getParameter(request, prefix + "so_tot_amt_usd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSoTrnsMod(JSPUtil.getParameter(request, prefix + "so_trns_mod", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setTroOfcCd(JSPUtil.getParameter(request, prefix + "tro_ofc_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrnsModCompVO[]
	 */
	public TrnsModCompVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrnsModCompVO[]
	 */
	public TrnsModCompVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrnsModCompVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] soCurrCd = (JSPUtil.getParameter(request, prefix	+ "so_curr_cd", length));
			String[] troCnfm = (JSPUtil.getParameter(request, prefix	+ "tro_cnfm", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] cngRsnDesc = (JSPUtil.getParameter(request, prefix	+ "cng_rsn_desc", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] rowCnt = (JSPUtil.getParameter(request, prefix	+ "row_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ihcSumUsd = (JSPUtil.getParameter(request, prefix	+ "ihc_sum_usd", length));
			String[] chgRtUsd = (JSPUtil.getParameter(request, prefix	+ "chg_rt_usd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] chgTrnsMod = (JSPUtil.getParameter(request, prefix	+ "chg_trns_mod", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] soTotAmt = (JSPUtil.getParameter(request, prefix	+ "so_tot_amt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] chgAmtUsd = (JSPUtil.getParameter(request, prefix	+ "chg_amt_usd", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] autoRatCd = (JSPUtil.getParameter(request, prefix	+ "auto_rat_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] woIssDt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_dt", length));
			String[] troTrnsMod = (JSPUtil.getParameter(request, prefix	+ "tro_trns_mod", length));
			String[] compResult = (JSPUtil.getParameter(request, prefix	+ "comp_result", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] soOfcCd = (JSPUtil.getParameter(request, prefix	+ "so_ofc_cd", length));
			String[] inclOftFlg = (JSPUtil.getParameter(request, prefix	+ "incl_oft_flg", length));
			String[] inlandPnl = (JSPUtil.getParameter(request, prefix	+ "inland_pnl", length));
			String[] soBkgSumUsd = (JSPUtil.getParameter(request, prefix	+ "so_bkg_sum_usd", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix	+ "so_cre_dt", length));
			String[] soTotAmtUsd = (JSPUtil.getParameter(request, prefix	+ "so_tot_amt_usd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] soTrnsMod = (JSPUtil.getParameter(request, prefix	+ "so_trns_mod", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] troOfcCd = (JSPUtil.getParameter(request, prefix	+ "tro_ofc_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrnsModCompVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (soCurrCd[i] != null)
					model.setSoCurrCd(soCurrCd[i]);
				if (troCnfm[i] != null)
					model.setTroCnfm(troCnfm[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (cngRsnDesc[i] != null)
					model.setCngRsnDesc(cngRsnDesc[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (rowCnt[i] != null)
					model.setRowCnt(rowCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ihcSumUsd[i] != null)
					model.setIhcSumUsd(ihcSumUsd[i]);
				if (chgRtUsd[i] != null)
					model.setChgRtUsd(chgRtUsd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (chgTrnsMod[i] != null)
					model.setChgTrnsMod(chgTrnsMod[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (soTotAmt[i] != null)
					model.setSoTotAmt(soTotAmt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (chgAmtUsd[i] != null)
					model.setChgAmtUsd(chgAmtUsd[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (autoRatCd[i] != null)
					model.setAutoRatCd(autoRatCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (woIssDt[i] != null)
					model.setWoIssDt(woIssDt[i]);
				if (troTrnsMod[i] != null)
					model.setTroTrnsMod(troTrnsMod[i]);
				if (compResult[i] != null)
					model.setCompResult(compResult[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (soOfcCd[i] != null)
					model.setSoOfcCd(soOfcCd[i]);
				if (inclOftFlg[i] != null)
					model.setInclOftFlg(inclOftFlg[i]);
				if (inlandPnl[i] != null)
					model.setInlandPnl(inlandPnl[i]);
				if (soBkgSumUsd[i] != null)
					model.setSoBkgSumUsd(soBkgSumUsd[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (soTotAmtUsd[i] != null)
					model.setSoTotAmtUsd(soTotAmtUsd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (soTrnsMod[i] != null)
					model.setSoTrnsMod(soTrnsMod[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (troOfcCd[i] != null)
					model.setTroOfcCd(troOfcCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrnsModCompVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrnsModCompVO[]
	 */
	public TrnsModCompVO[] getTrnsModCompVOs(){
		TrnsModCompVO[] vos = (TrnsModCompVO[])models.toArray(new TrnsModCompVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCurrCd = this.soCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCnfm = this.troCnfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRsnDesc = this.cngRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCnt = this.rowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcSumUsd = this.ihcSumUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtUsd = this.chgRtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTrnsMod = this.chgTrnsMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soTotAmt = this.soTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmtUsd = this.chgAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatCd = this.autoRatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssDt = this.woIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troTrnsMod = this.troTrnsMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compResult = this.compResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soOfcCd = this.soOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclOftFlg = this.inclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlandPnl = this.inlandPnl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soBkgSumUsd = this.soBkgSumUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soTotAmtUsd = this.soTotAmtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soTrnsMod = this.soTrnsMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troOfcCd = this.troOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
