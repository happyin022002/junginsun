/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : APCInvoiceVO.java
*@FileTitle : APCInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class APCInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APCInvoiceVO> models = new ArrayList<APCInvoiceVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String chgRefNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String invTtlLoclAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String payCond = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String ediHdrSeq = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String mergeChk = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String ediTpCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String custCrFlg = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String invDeltDivCd = null;
	/* Column Info */
	private String revTpSrcCd = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String tvaFlg = null;
	/* Column Info */
	private String ediSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APCInvoiceVO() {}

	public APCInvoiceVO(String ibflag, String pagerows, String porCd, String vslCd, String currCd, String gubun, String custNm, String svcScpCd, String invTtlLoclAmt, String trfRtAmt, String chgSeq, String payCond, String sailArrDt, String blNo, String chgCd, String rfaNo, String polCd, String vvdCd, String scNo, String arIfNo, String chgAmt, String actCustCntCd, String ediHdrSeq, String ediSndFlg, String invDt, String perTpCd, String actCustSeq, String loclCurrCd, String delCd, String skdVoyNo, String mergeChk, String ioBndCd, String ediTpCd, String skdDirCd, String arOfcCd, String custCrFlg, String podCd, String vvd, String invNo, String bkgNo, String slanCd, String custCd, String revTpSrcCd, String ratAsCntrQty, String ediSndDt, String tvaFlg, String chgRefNo, String invDeltDivCd) {
		this.porCd = porCd;
		this.chgRefNo = chgRefNo;
		this.vslCd = vslCd;
		this.gubun = gubun;
		this.currCd = currCd;
		this.custNm = custNm;
		this.invTtlLoclAmt = invTtlLoclAmt;
		this.svcScpCd = svcScpCd;
		this.trfRtAmt = trfRtAmt;
		this.chgSeq = chgSeq;
		this.payCond = payCond;
		this.sailArrDt = sailArrDt;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.scNo = scNo;
		this.arIfNo = arIfNo;
		this.chgAmt = chgAmt;
		this.actCustCntCd = actCustCntCd;
		this.ediHdrSeq = ediHdrSeq;
		this.ediSndFlg = ediSndFlg;
		this.invDt = invDt;
		this.perTpCd = perTpCd;
		this.loclCurrCd = loclCurrCd;
		this.actCustSeq = actCustSeq;
		this.delCd = delCd;
		this.mergeChk = mergeChk;
		this.skdVoyNo = skdVoyNo;
		this.ioBndCd = ioBndCd;
		this.ediTpCd = ediTpCd;
		this.arOfcCd = arOfcCd;
		this.skdDirCd = skdDirCd;
		this.custCrFlg = custCrFlg;
		this.invNo = invNo;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.custCd = custCd;
		this.invDeltDivCd = invDeltDivCd;
		this.revTpSrcCd = revTpSrcCd;
		this.ratAsCntrQty = ratAsCntrQty;
		this.tvaFlg = tvaFlg;
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("chg_ref_no", getChgRefNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("pay_cond", getPayCond());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("edi_hdr_seq", getEdiHdrSeq());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("merge_chk", getMergeChk());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("edi_tp_cd", getEdiTpCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("tva_flg", getTvaFlg());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("chg_ref_no", "chgRefNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("pay_cond", "payCond");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("edi_hdr_seq", "ediHdrSeq");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("merge_chk", "mergeChk");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("edi_tp_cd", "ediTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		return this.hashFields;
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
	 * @return chgRefNo
	 */
	public String getChgRefNo() {
		return this.chgRefNo;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return invTtlLoclAmt
	 */
	public String getInvTtlLoclAmt() {
		return this.invTtlLoclAmt;
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
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
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
	 * @return payCond
	 */
	public String getPayCond() {
		return this.payCond;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ediHdrSeq
	 */
	public String getEdiHdrSeq() {
		return this.ediHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return mergeChk
	 */
	public String getMergeChk() {
		return this.mergeChk;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return ediTpCd
	 */
	public String getEdiTpCd() {
		return this.ediTpCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return custCrFlg
	 */
	public String getCustCrFlg() {
		return this.custCrFlg;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return invDeltDivCd
	 */
	public String getInvDeltDivCd() {
		return this.invDeltDivCd;
	}
	
	/**
	 * Column Info
	 * @return revTpSrcCd
	 */
	public String getRevTpSrcCd() {
		return this.revTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @return tvaFlg
	 */
	public String getTvaFlg() {
		return this.tvaFlg;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
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
	 * @param chgRefNo
	 */
	public void setChgRefNo(String chgRefNo) {
		this.chgRefNo = chgRefNo;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param invTtlLoclAmt
	 */
	public void setInvTtlLoclAmt(String invTtlLoclAmt) {
		this.invTtlLoclAmt = invTtlLoclAmt;
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
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
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
	 * @param payCond
	 */
	public void setPayCond(String payCond) {
		this.payCond = payCond;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ediHdrSeq
	 */
	public void setEdiHdrSeq(String ediHdrSeq) {
		this.ediHdrSeq = ediHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param mergeChk
	 */
	public void setMergeChk(String mergeChk) {
		this.mergeChk = mergeChk;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param ediTpCd
	 */
	public void setEdiTpCd(String ediTpCd) {
		this.ediTpCd = ediTpCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param custCrFlg
	 */
	public void setCustCrFlg(String custCrFlg) {
		this.custCrFlg = custCrFlg;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param invDeltDivCd
	 */
	public void setInvDeltDivCd(String invDeltDivCd) {
		this.invDeltDivCd = invDeltDivCd;
	}
	
	/**
	 * Column Info
	 * @param revTpSrcCd
	 */
	public void setRevTpSrcCd(String revTpSrcCd) {
		this.revTpSrcCd = revTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @param tvaFlg
	 */
	public void setTvaFlg(String tvaFlg) {
		this.tvaFlg = tvaFlg;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setChgRefNo(JSPUtil.getParameter(request, prefix + "chg_ref_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request, prefix + "inv_ttl_locl_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, prefix + "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setPayCond(JSPUtil.getParameter(request, prefix + "pay_cond", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setEdiHdrSeq(JSPUtil.getParameter(request, prefix + "edi_hdr_seq", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, prefix + "edi_snd_flg", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setPerTpCd(JSPUtil.getParameter(request, prefix + "per_tp_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setMergeChk(JSPUtil.getParameter(request, prefix + "merge_chk", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setEdiTpCd(JSPUtil.getParameter(request, prefix + "edi_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCustCrFlg(JSPUtil.getParameter(request, prefix + "cust_cr_flg", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request, prefix + "inv_delt_div_cd", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request, prefix + "rev_tp_src_cd", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, prefix + "rat_as_cntr_qty", ""));
		setTvaFlg(JSPUtil.getParameter(request, prefix + "tva_flg", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APCInvoiceVO[]
	 */
	public APCInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APCInvoiceVO[]
	 */
	public APCInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APCInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] chgRefNo = (JSPUtil.getParameter(request, prefix	+ "chg_ref_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] invTtlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_locl_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] payCond = (JSPUtil.getParameter(request, prefix	+ "pay_cond", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] ediHdrSeq = (JSPUtil.getParameter(request, prefix	+ "edi_hdr_seq", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] mergeChk = (JSPUtil.getParameter(request, prefix	+ "merge_chk", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] ediTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_tp_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] custCrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_cr_flg", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] invDeltDivCd = (JSPUtil.getParameter(request, prefix	+ "inv_delt_div_cd", length));
			String[] revTpSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_src_cd", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] tvaFlg = (JSPUtil.getParameter(request, prefix	+ "tva_flg", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new APCInvoiceVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (chgRefNo[i] != null)
					model.setChgRefNo(chgRefNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (invTtlLoclAmt[i] != null)
					model.setInvTtlLoclAmt(invTtlLoclAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (payCond[i] != null)
					model.setPayCond(payCond[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (ediHdrSeq[i] != null)
					model.setEdiHdrSeq(ediHdrSeq[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (mergeChk[i] != null)
					model.setMergeChk(mergeChk[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (ediTpCd[i] != null)
					model.setEdiTpCd(ediTpCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (custCrFlg[i] != null)
					model.setCustCrFlg(custCrFlg[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (invDeltDivCd[i] != null)
					model.setInvDeltDivCd(invDeltDivCd[i]);
				if (revTpSrcCd[i] != null)
					model.setRevTpSrcCd(revTpSrcCd[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (tvaFlg[i] != null)
					model.setTvaFlg(tvaFlg[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPCInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APCInvoiceVO[]
	 */
	public APCInvoiceVO[] getAPCInvoiceVOs(){
		APCInvoiceVO[] vos = (APCInvoiceVO[])models.toArray(new APCInvoiceVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRefNo = this.chgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt = this.invTtlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCond = this.payCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHdrSeq = this.ediHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mergeChk = this.mergeChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTpCd = this.ediTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg = this.custCrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd = this.invDeltDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd = this.revTpSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg = this.tvaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
