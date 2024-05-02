/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueTVAListVO.java
*@FileTitle : InvoiceIssueTVAListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.22 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceIssueTVAListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceIssueTVAListVO> models = new ArrayList<InvoiceIssueTVAListVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String nonTaxableAmt = null;
	/* Column Info */
	private String tvaLcl = null;
	/* Column Info */
	private String vatNo = null;
	/* Column Info */
	private String customer = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String taxableAmt = null;
	/* Column Info */
	private String frtUsd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String eqvLcl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgLcl = null;
	/* Column Info */
	private String ttlLcl = null;
	/* Column Info */
	private String arIfNo = null;

	// SGNBB 조회시 사용하는 컬럼 추가
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String vdtTtl = null;
	/* Column Info */
	private String vttTtl = null;
	/* Column Info */
	private String dhfVnd = null;
	/* Column Info */
	private String dhfUsd = null;
	/* Column Info */
	private String ddfVnd = null;
	/* Column Info */
	private String ddfUsd = null;
	/* Column Info */
	private String obsVnd = null;
	/* Column Info */
	private String obsUsd = null;
	/* Column Info */
	private String othVnd = null;
	/* Column Info */
	private String othUsd = null;
	/* Column Info */
	private String dthVnd = null;
	/* Column Info */
	private String dthUsd = null;
	/* Column Info */
	private String ddcVnd = null;
	/* Column Info */
	private String ddcUsd = null;
	/* Column Info */
	private String orcVnd = null;
	/* Column Info */
	private String orcUsd = null;
	
	// SYDBB 조회시 사용하는 컬럼 추가
	/* Column Info */
	private String cmrAud = null;
	/* Column Info */
	private String cmrUsd = null;
	/* Column Info */
	private String dhfAud = null;
	/* Column Info */
	private String dthAud = null;
	/* Column Info */
	private String ehcAud = null;
	/* Column Info */
	private String ehcUsd = null;
	/* Column Info */
	private String dtsAud = null;
	/* Column Info */
	private String dtsUsd = null;
	/* Column Info */
	private String dpsAud = null;
	/* Column Info */
	private String dpsUsd = null;
	/* Column Info */
	private String dtcAud = null;
	/* Column Info */
	private String dtcUsd = null;
	/* Column Info */
	private String astAud = null;
	/* Column Info */
	private String astUsd = null;
	/* Column Info */
	private String tvaAud = null;
	/* Column Info */
	private String tvaUsd = null;
	/* Column Info */
	private String nonTaxableAud = null;
	/* Column Info */
	private String nonTaxableUsd = null;
	/* Column Info */
	private String lclAmt = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String grandTotal = null;
	
	// SGNBB 조회시 사용하는 컬럼 NEW
	private String invType     = null;
	private String actInvNo     = null;
	private String actCustCd    = null;
	private String custRgstNo   = null;
	private String netAmt       = null;
	private String vatAmt       = null;
	private String grossAmt     = null;
	private String invXchRt     = null;
	private String updUsrId     = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceIssueTVAListVO() {}

	public InvoiceIssueTVAListVO(String ibflag, String pagerows, String arIfNo, String issDt, String customer, String invNo, String vvd, String ioBndCd, String port, String sailArrDt, String blSrcNo, String revTpCd, String frtUsd, String usdXchRt, String eqvLcl, String tvaLcl, String chgLcl, String ttlLcl, String vatNo, String taxableAmt, String nonTaxableAmt, String glEffDt, String dpPrcsKnt, String custLglEngNm, String vdtTtl, String vttTtl, String dhfVnd, String dhfUsd, String ddfVnd, String ddfUsd, String obsVnd, String obsUsd, String othVnd, String othUsd, String dthVnd, String dthUsd, String ddcVnd, String ddcUsd, String orcVnd, String orcUsd, String cmrAud, String cmrUsd, String dhfAud,  String dthAud, String ehcAud, String ehcUsd, String dtsAud, String dtsUsd, String dpsAud, String dpsUsd, String dtcAud, String dtcUsd, String astAud, String astUsd, String tvaAud, String tvaUsd, String nonTaxableAud, String nonTaxableUsd, String lclAmt, String usdAmt, String grandTotal, String invType, String actInvNo, String actCustCd, String custRgstNo, String netAmt, String vatAmt, String grossAmt, String invXchRt, String updUsrId) {
		this.port = port;
		this.blSrcNo = blSrcNo;
		this.glEffDt = glEffDt;
		this.usdXchRt = usdXchRt;
		this.nonTaxableAmt = nonTaxableAmt;
		this.tvaLcl = tvaLcl;
		this.vatNo = vatNo;
		this.customer = customer;
		this.ioBndCd = ioBndCd;
		this.sailArrDt = sailArrDt;
		this.revTpCd = revTpCd;
		this.taxableAmt = taxableAmt;
		this.frtUsd = frtUsd;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.invNo = invNo;
		this.vvd = vvd;
		this.issDt = issDt;
		this.eqvLcl = eqvLcl;
		this.ibflag = ibflag;
		this.chgLcl = chgLcl;
		this.ttlLcl = ttlLcl;
		this.arIfNo = arIfNo;
		
		this.custLglEngNm = custLglEngNm;
		this.vdtTtl = vdtTtl;
		this.vttTtl = vttTtl;
		this.dhfVnd = dhfVnd;
		this.dhfUsd = dhfUsd;
		this.ddfVnd = ddfVnd;
		this.ddfUsd = ddfUsd;
		this.obsVnd = obsVnd;
		this.obsUsd = obsUsd;
		this.othVnd = othVnd;
		this.othUsd = othUsd;
		this.dthVnd = dthVnd;
		this.dthUsd = dthUsd;
		this.ddcVnd = ddcVnd;
		this.ddcUsd = ddcUsd;
		this.orcVnd = orcVnd;
		this.orcUsd = orcUsd;
		
		this.cmrAud = cmrAud;
		this.cmrUsd = cmrUsd;
		this.dhfAud = dhfAud;
		this.dthAud = dthAud;
		this.ehcAud = ehcAud;
		this.ehcUsd = ehcUsd;
		this.dtsAud = dtsAud;
		this.dtsUsd = dtsUsd;
		this.dpsAud = dpsAud;
		this.dpsUsd = dpsUsd;
		this.dtcAud = dtcAud;
		this.dtcUsd = dtcUsd;
		this.astAud = astAud;
		this.astUsd = astUsd;
		this.tvaAud = tvaAud;
		this.tvaUsd = tvaUsd;
		this.nonTaxableAud = nonTaxableAud;
		this.nonTaxableUsd = nonTaxableUsd;
		this.lclAmt = lclAmt;
		this.usdAmt = usdAmt;
		this.cmrAud = cmrAud;
		this.grandTotal = grandTotal;
		
		this.invType   	= invType;
		this.actInvNo   = actInvNo;
		this.actCustCd  = actCustCd;
		this.custRgstNo = custRgstNo;
		this.netAmt     = netAmt;
		this.vatAmt     = vatAmt;
		this.grossAmt   = grossAmt;
		this.invXchRt   = invXchRt;
		this.updUsrId   = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("non_taxable_amt", getNonTaxableAmt());
		this.hashColumns.put("tva_lcl", getTvaLcl());
		this.hashColumns.put("vat_no", getVatNo());
		this.hashColumns.put("customer", getCustomer());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("taxable_amt", getTaxableAmt());
		this.hashColumns.put("frt_usd", getFrtUsd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("eqv_lcl", getEqvLcl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_lcl", getChgLcl());
		this.hashColumns.put("ttl_lcl", getTtlLcl());
		this.hashColumns.put("ar_if_no", getArIfNo());
		
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vdt_ttl", getVdtTtl());
		this.hashColumns.put("vtt_ttl", getVttTtl());
		this.hashColumns.put("dhf_vnd", getDhfVnd());
		this.hashColumns.put("dhf_usd", getDhfUsd());
		this.hashColumns.put("ddf_vnd", getDdfVnd());
		this.hashColumns.put("ddf_usd", getDdfUsd());
		this.hashColumns.put("obs_vnd", getObsVnd());
		this.hashColumns.put("obs_usd", getObsUsd());
		this.hashColumns.put("oth_vnd", getOthVnd());
		this.hashColumns.put("oth_usd", getOthUsd());
		this.hashColumns.put("dth_vnd", getDthVnd());
		this.hashColumns.put("dth_usd", getDthUsd());
		this.hashColumns.put("ddc_vnd", getDdcVnd());
		this.hashColumns.put("ddc_usd", getDdcUsd());
		this.hashColumns.put("orc_vnd", getOrcVnd());
		this.hashColumns.put("orc_usd", getOrcUsd());
		
		this.hashColumns.put("cmr_aud", getCmrAud());
		this.hashColumns.put("cmr_usd", getCmrUsd());
		this.hashColumns.put("dhf_aud", getDhfAud());
		this.hashColumns.put("dth_aud", getDthAud());
		this.hashColumns.put("ehc_aud", getEhcAud());
		this.hashColumns.put("ehc_usd", getEhcUsd());
		this.hashColumns.put("dts_aud", getDtsAud());
		this.hashColumns.put("dts_usd", getDtsUsd());
		this.hashColumns.put("dps_aud", getDpsAud());
		this.hashColumns.put("dps_usd", getDpsUsd());
		this.hashColumns.put("dtc_aud", getDtcAud());
		this.hashColumns.put("dtc_usd", getDtcUsd());
		this.hashColumns.put("ast_aud", getAstAud());
		this.hashColumns.put("ast_usd", getAstUsd());
		this.hashColumns.put("tva_aud", getTvaAud());
		this.hashColumns.put("tva_usd", getTvaUsd());
		this.hashColumns.put("non_taxable_aud", getNonTaxableAud());
		this.hashColumns.put("non_taxable_usd", getNonTaxableUsd());
		this.hashColumns.put("lcl_amt", getLclAmt());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("grand_total", getGrandTotal());
		
		this.hashColumns.put("inv_type"		 ,getInvType());
		this.hashColumns.put("act_inv_no"    ,getActInvNo());
		this.hashColumns.put("act_cust_cd"   ,getActCustCd());
		this.hashColumns.put("cust_rgst_no"  ,getCustRgstNo());
		this.hashColumns.put("net_amt"       ,getNetAmt());
		this.hashColumns.put("vat_amt"       ,getVatAmt());
		this.hashColumns.put("gross_amt"     ,getGrossAmt());
		this.hashColumns.put("inv_xch_rt"    ,getInvXchRt());
		this.hashColumns.put("upd_usr_id"    ,getUpdUsrId());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("non_taxable_amt", "nonTaxableAmt");
		this.hashFields.put("tva_lcl", "tvaLcl");
		this.hashFields.put("vat_no", "vatNo");
		this.hashFields.put("customer", "customer");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("taxable_amt", "taxableAmt");
		this.hashFields.put("frt_usd", "frtUsd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("eqv_lcl", "eqvLcl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_lcl", "chgLcl");
		this.hashFields.put("ttl_lcl", "ttlLcl");
		this.hashFields.put("ar_if_no", "arIfNo");
		
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vdt_ttl", "vdtTtl");
		this.hashFields.put("vtt_ttl", "vttTtl");
		this.hashFields.put("dhf_vnd", "dhfVnd");
		this.hashFields.put("dhf_usd", "dhfUsd");
		this.hashFields.put("ddf_vnd", "ddfVnd");
		this.hashFields.put("ddf_usd", "ddfUsd");
		this.hashFields.put("obs_vnd", "obsVnd");
		this.hashFields.put("obs_usd", "obsUsd");
		this.hashFields.put("oth_vnd", "othVnd");
		this.hashFields.put("oth_usd", "othUsd");
		this.hashFields.put("dth_vnd", "dthVnd");
		this.hashFields.put("dth_usd", "dthUsd");
		this.hashFields.put("ddc_vnd", "ddcVnd");
		this.hashFields.put("ddc_usd", "ddcUsd");
		this.hashFields.put("orc_vnd", "orcVnd");
		this.hashFields.put("orc_usd", "orcUsd");
		
		this.hashFields.put("cmr_aud", "cmrAud");
		this.hashFields.put("cmr_usd", "cmrUsd");
		this.hashFields.put("dhf_aud", "dhfAud");
		this.hashFields.put("dth_aud", "dthAud");
		this.hashFields.put("ehc_aud", "ehcAud");
		this.hashFields.put("ehc_usd", "ehcUsd");
		this.hashFields.put("dts_aud", "dtsAud");
		this.hashFields.put("dts_usd", "dtsUsd");
		this.hashFields.put("dps_aud", "dpsAud");
		this.hashFields.put("dps_usd", "dpsUsd");
		this.hashFields.put("dtc_aud", "dtcAud");
		this.hashFields.put("dtc_usd", "dtcUsd");
		this.hashFields.put("ast_aud", "astAud");
		this.hashFields.put("ast_usd", "astUsd");
		this.hashFields.put("tva_aud", "tvaAud");
		this.hashFields.put("tva_usd", "tvaUsd");
		this.hashFields.put("non_taxable_aud", "nonTaxableAud");
		this.hashFields.put("non_taxable_usd", "nonTaxableUsd");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("grand_total", "grandTotal");
		
		this.hashFields.put("inv_type", 	"invType");
		this.hashFields.put("act_inv_no",   "actInvNo");
		this.hashFields.put("act_cust_cd",  "actCustCd");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("net_amt",      "netAmt");
		this.hashFields.put("vat_amt",      "vatAmt");
		this.hashFields.put("gross_amt",    "grossAmt");
		this.hashFields.put("inv_xch_rt",   "invXchRt");
		this.hashFields.put("upd_usr_id",   "updUsrId");
		
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
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
	}
	
	/**
	 * Column Info
	 * @return nonTaxableAmt
	 */
	public String getNonTaxableAmt() {
		return this.nonTaxableAmt;
	}
	
	/**
	 * Column Info
	 * @return tvaLcl
	 */
	public String getTvaLcl() {
		return this.tvaLcl;
	}
	
	/**
	 * Column Info
	 * @return vatNo
	 */
	public String getVatNo() {
		return this.vatNo;
	}
	
	/**
	 * Column Info
	 * @return customer
	 */
	public String getCustomer() {
		return this.customer;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return taxableAmt
	 */
	public String getTaxableAmt() {
		return this.taxableAmt;
	}
	
	/**
	 * Column Info
	 * @return frtUsd
	 */
	public String getFrtUsd() {
		return this.frtUsd;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return eqvLcl
	 */
	public String getEqvLcl() {
		return this.eqvLcl;
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
	 * @return chgLcl
	 */
	public String getChgLcl() {
		return this.chgLcl;
	}
	
	/**
	 * Column Info
	 * @return ttlLcl
	 */
	public String getTtlLcl() {
		return this.ttlLcl;
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
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}
	
	/**
	 * Column Info
	 * @param nonTaxableAmt
	 */
	public void setNonTaxableAmt(String nonTaxableAmt) {
		this.nonTaxableAmt = nonTaxableAmt;
	}
	
	/**
	 * Column Info
	 * @param tvaLcl
	 */
	public void setTvaLcl(String tvaLcl) {
		this.tvaLcl = tvaLcl;
	}
	
	/**
	 * Column Info
	 * @param vatNo
	 */
	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}
	
	/**
	 * Column Info
	 * @param customer
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param taxableAmt
	 */
	public void setTaxableAmt(String taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	
	/**
	 * Column Info
	 * @param frtUsd
	 */
	public void setFrtUsd(String frtUsd) {
		this.frtUsd = frtUsd;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param eqvLcl
	 */
	public void setEqvLcl(String eqvLcl) {
		this.eqvLcl = eqvLcl;
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
	 * @param chgLcl
	 */
	public void setChgLcl(String chgLcl) {
		this.chgLcl = chgLcl;
	}
	
	/**
	 * Column Info
	 * @param ttlLcl
	 */
	public void setTtlLcl(String ttlLcl) {
		this.ttlLcl = ttlLcl;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	public String getVdtTtl() {
		return vdtTtl;
	}

	public void setVdtTtl(String vdtTtl) {
		this.vdtTtl = vdtTtl;
	}

	public String getVttTtl() {
		return vttTtl;
	}

	public void setVttTtl(String vttTtl) {
		this.vttTtl = vttTtl;
	}

	public String getDhfVnd() {
		return dhfVnd;
	}

	public void setDhfVnd(String dhfVnd) {
		this.dhfVnd = dhfVnd;
	}

	public String getDhfUsd() {
		return dhfUsd;
	}

	public void setDhfUsd(String dhfUsd) {
		this.dhfUsd = dhfUsd;
	}

	public String getDdfVnd() {
		return ddfVnd;
	}

	public void setDdfVnd(String ddfVnd) {
		this.ddfVnd = ddfVnd;
	}

	public String getDdfUsd() {
		return ddfUsd;
	}

	public void setDdfUsd(String ddfUsd) {
		this.ddfUsd = ddfUsd;
	}

	public String getObsVnd() {
		return obsVnd;
	}

	public void setObsVnd(String obsVnd) {
		this.obsVnd = obsVnd;
	}

	public String getObsUsd() {
		return obsUsd;
	}

	public void setObsUsd(String obsUsd) {
		this.obsUsd = obsUsd;
	}

	public String getOthVnd() {
		return othVnd;
	}

	public void setOthVnd(String othVnd) {
		this.othVnd = othVnd;
	}

	public String getOthUsd() {
		return othUsd;
	}

	public void setOthUsd(String othUsd) {
		this.othUsd = othUsd;
	}

	public String getDthVnd() {
		return dthVnd;
	}

	public void setDthVnd(String dthVnd) {
		this.dthVnd = dthVnd;
	}

	public String getDthUsd() {
		return dthUsd;
	}

	public void setDthUsd(String dthUsd) {
		this.dthUsd = dthUsd;
	}

	public String getDdcVnd() {
		return ddcVnd;
	}

	public void setDdcVnd(String ddcVnd) {
		this.ddcVnd = ddcVnd;
	}

	public String getDdcUsd() {
		return ddcUsd;
	}

	public void setDdcUsd(String ddcUsd) {
		this.ddcUsd = ddcUsd;
	}

	public String getOrcVnd() {
		return orcVnd;
	}

	public void setOrcVnd(String orcVnd) {
		this.orcVnd = orcVnd;
	}

	public String getOrcUsd() {
		return orcUsd;
	}

	public void setOrcUsd(String orcUsd) {
		this.orcUsd = orcUsd;
	}

	public String getCmrAud() {
		return cmrAud;
	}

	public void setCmrAud(String cmrAud) {
		this.cmrAud = cmrAud;
	}

	public String getCmrUsd() {
		return cmrUsd;
	}

	public void setCmrUsd(String cmrUsd) {
		this.cmrUsd = cmrUsd;
	}

	public String getDhfAud() {
		return dhfAud;
	}

	public void setDhfAud(String dhfAud) {
		this.dhfAud = dhfAud;
	}

	public String getDthAud() {
		return dthAud;
	}

	public void setDthAud(String dthAud) {
		this.dthAud = dthAud;
	}

	public String getEhcAud() {
		return ehcAud;
	}

	public void setEhcAud(String ehcAud) {
		this.ehcAud = ehcAud;
	}

	public String getEhcUsd() {
		return ehcUsd;
	}

	public void setEhcUsd(String ehcUsd) {
		this.ehcUsd = ehcUsd;
	}

	public String getDtsAud() {
		return dtsAud;
	}

	public void setDtsAud(String dtsAud) {
		this.dtsAud = dtsAud;
	}

	public String getDtsUsd() {
		return dtsUsd;
	}

	public void setDtsUsd(String dtsUsd) {
		this.dtsUsd = dtsUsd;
	}

	public String getDpsAud() {
		return dpsAud;
	}

	public void setDpsAud(String dpsAud) {
		this.dpsAud = dpsAud;
	}

	public String getDpsUsd() {
		return dpsUsd;
	}

	public void setDpsUsd(String dpsUsd) {
		this.dpsUsd = dpsUsd;
	}

	public String getDtcAud() {
		return dtcAud;
	}

	public void setDtcAud(String dtcAud) {
		this.dtcAud = dtcAud;
	}

	public String getDtcUsd() {
		return dtcUsd;
	}

	public void setDtcUsd(String dtcUsd) {
		this.dtcUsd = dtcUsd;
	}

	public String getAstAud() {
		return astAud;
	}

	public void setAstAud(String astAud) {
		this.astAud = astAud;
	}

	public String getAstUsd() {
		return astUsd;
	}

	public void setAstUsd(String astUsd) {
		this.astUsd = astUsd;
	}

	public String getTvaAud() {
		return tvaAud;
	}

	public void setTvaAud(String tvaAud) {
		this.tvaAud = tvaAud;
	}

	public String getTvaUsd() {
		return tvaUsd;
	}

	public void setTvaUsd(String tvaUsd) {
		this.tvaUsd = tvaUsd;
	}

	public String getNonTaxableAud() {
		return nonTaxableAud;
	}

	public void setNonTaxableAud(String nonTaxableAud) {
		this.nonTaxableAud = nonTaxableAud;
	}

	public String getNonTaxableUsd() {
		return nonTaxableUsd;
	}

	public void setNonTaxableUsd(String nonTaxableUsd) {
		this.nonTaxableUsd = nonTaxableUsd;
	}

	public String getLclAmt() {
		return lclAmt;
	}

	public void setLclAmt(String lclAmt) {
		this.lclAmt = lclAmt;
	}

	public String getUsdAmt() {
		return usdAmt;
	}

	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public String getActInvNo() {
		return actInvNo;
	}

	public void setActInvNo(String actInvNo) {
		this.actInvNo = actInvNo;
	}

	public String getActCustCd() {
		return actCustCd;
	}

	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}

	public String getCustRgstNo() {
		return custRgstNo;
	}

	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}

	public String getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(String netAmt) {
		this.netAmt = netAmt;
	}

	public String getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
	}

	public String getGrossAmt() {
		return grossAmt;
	}

	public void setGrossAmt(String grossAmt) {
		this.grossAmt = grossAmt;
	}

	public String getInvXchRt() {
		return invXchRt;
	}

	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setUsdXchRt(JSPUtil.getParameter(request, "usd_xch_rt", ""));
		setNonTaxableAmt(JSPUtil.getParameter(request, "non_taxable_amt", ""));
		setTvaLcl(JSPUtil.getParameter(request, "tva_lcl", ""));
		setVatNo(JSPUtil.getParameter(request, "vat_no", ""));
		setCustomer(JSPUtil.getParameter(request, "customer", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setTaxableAmt(JSPUtil.getParameter(request, "taxable_amt", ""));
		setFrtUsd(JSPUtil.getParameter(request, "frt_usd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setEqvLcl(JSPUtil.getParameter(request, "eqv_lcl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChgLcl(JSPUtil.getParameter(request, "chg_lcl", ""));
		setTtlLcl(JSPUtil.getParameter(request, "ttl_lcl", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setVdtTtl(JSPUtil.getParameter(request, "vdt_ttl", ""));
		setVttTtl(JSPUtil.getParameter(request, "vtt_ttl", ""));
		setDhfVnd(JSPUtil.getParameter(request, "dhf_vnd", ""));
		setDhfUsd(JSPUtil.getParameter(request, "dhf_usd", ""));
		setDdfVnd(JSPUtil.getParameter(request, "ddf_vnd", ""));
		setDdfUsd(JSPUtil.getParameter(request, "ddf_usd", ""));
		setObsVnd(JSPUtil.getParameter(request, "obs_vnd", ""));
		setObsUsd(JSPUtil.getParameter(request, "obs_usd", ""));
		setOthVnd(JSPUtil.getParameter(request, "oth_vnd", ""));
		setOthUsd(JSPUtil.getParameter(request, "oth_usd", ""));
		setDthVnd(JSPUtil.getParameter(request, "dth_vnd", ""));
		setDthUsd(JSPUtil.getParameter(request, "dth_usd", ""));
		setDdcVnd(JSPUtil.getParameter(request, "ddc_vnd", ""));
		setDdcUsd(JSPUtil.getParameter(request, "ddc_usd", ""));
		setOrcVnd(JSPUtil.getParameter(request, "orc_vnd", ""));
		setOrcUsd(JSPUtil.getParameter(request, "orc_usd", ""));
		
		setCmrAud(JSPUtil.getParameter(request, "cmr_aud", ""));
		setCmrUsd(JSPUtil.getParameter(request, "cmr_usd", ""));
		setDhfAud(JSPUtil.getParameter(request, "dhf_aud", ""));
		setDthAud(JSPUtil.getParameter(request, "dth_aud", ""));
		setEhcAud(JSPUtil.getParameter(request, "ehc_aud", ""));
		setEhcUsd(JSPUtil.getParameter(request, "ehc_usd", ""));
		setDtsAud(JSPUtil.getParameter(request, "dts_aud", ""));
		setDtsUsd(JSPUtil.getParameter(request, "dts_usd", ""));
		setDpsAud(JSPUtil.getParameter(request, "dps_aud", ""));
		setDpsUsd(JSPUtil.getParameter(request, "dps_usd", ""));
		setDtcAud(JSPUtil.getParameter(request, "dtc_aud", ""));
		setDtcUsd(JSPUtil.getParameter(request, "dtc_usd", ""));
		setAstAud(JSPUtil.getParameter(request, "ast_aud", ""));
		setAstUsd(JSPUtil.getParameter(request, "ast_usd", ""));
		setTvaAud(JSPUtil.getParameter(request, "tva_aud", ""));
		setTvaUsd(JSPUtil.getParameter(request, "tva_usd", ""));
		setNonTaxableAud(JSPUtil.getParameter(request, "non_taxable_aud", ""));
		setNonTaxableUsd(JSPUtil.getParameter(request, "non_taxable_usd", ""));
		setLclAmt(JSPUtil.getParameter(request, "lcl_amt", ""));
		setUsdAmt(JSPUtil.getParameter(request, "usd_amt", ""));
		setGrandTotal(JSPUtil.getParameter(request, "grand_total", ""));
		
		setInvType(JSPUtil.getParameter(request, "inv_type", ""));
		setActInvNo(JSPUtil.getParameter(request, "act_inv_no", ""));
		setActCustCd(JSPUtil.getParameter(request, "act_cust_cd", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setNetAmt(JSPUtil.getParameter(request, "net_amt", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setGrossAmt(JSPUtil.getParameter(request, "gross_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueTVAListVO[]
	 */
	public InvoiceIssueTVAListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueTVAListVO[]
	 */
	public InvoiceIssueTVAListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceIssueTVAListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] nonTaxableAmt = (JSPUtil.getParameter(request, prefix	+ "non_taxable_amt", length));
			String[] tvaLcl = (JSPUtil.getParameter(request, prefix	+ "tva_lcl", length));
			String[] vatNo = (JSPUtil.getParameter(request, prefix	+ "vat_no", length));
			String[] customer = (JSPUtil.getParameter(request, prefix	+ "customer", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] taxableAmt = (JSPUtil.getParameter(request, prefix	+ "taxable_amt", length));
			String[] frtUsd = (JSPUtil.getParameter(request, prefix	+ "frt_usd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] eqvLcl = (JSPUtil.getParameter(request, prefix	+ "eqv_lcl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgLcl = (JSPUtil.getParameter(request, prefix	+ "chg_lcl", length));
			String[] ttlLcl = (JSPUtil.getParameter(request, prefix	+ "ttl_lcl", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));

			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] vdtTtl = (JSPUtil.getParameter(request, prefix	+ "vdt_ttl", length));
			String[] vttTtl = (JSPUtil.getParameter(request, prefix	+ "vtt_ttl", length));
			String[] dhfVnd = (JSPUtil.getParameter(request, prefix	+ "dhf_vnd", length));
			String[] dhfUsd = (JSPUtil.getParameter(request, prefix	+ "dhf_usd", length));
			String[] ddfVnd = (JSPUtil.getParameter(request, prefix	+ "ddf_vnd", length));
			String[] ddfUsd = (JSPUtil.getParameter(request, prefix	+ "ddf_usd", length));
			String[] obsVnd = (JSPUtil.getParameter(request, prefix	+ "obs_vnd", length));
			String[] obsUsd = (JSPUtil.getParameter(request, prefix	+ "obs_usd", length));
			String[] othVnd = (JSPUtil.getParameter(request, prefix	+ "oth_vnd", length));
			String[] othUsd = (JSPUtil.getParameter(request, prefix	+ "oth_usd", length));
			String[] dthVnd = (JSPUtil.getParameter(request, prefix	+ "dth_vnd", length));
			String[] dthUsd = (JSPUtil.getParameter(request, prefix	+ "dth_usd", length));
			String[] ddcVnd = (JSPUtil.getParameter(request, prefix	+ "ddc_vnd", length));
			String[] ddcUsd = (JSPUtil.getParameter(request, prefix	+ "ddc_usd", length));
			String[] orcVnd = (JSPUtil.getParameter(request, prefix	+ "orc_vnd", length));
			String[] orcUsd = (JSPUtil.getParameter(request, prefix	+ "orc_usd", length));
			
			String[] cmrAud = (JSPUtil.getParameter(request, prefix	+ "cmr_aud", length));
			String[] cmrUsd = (JSPUtil.getParameter(request, prefix	+ "cmr_usd", length));
			String[] dhfAud = (JSPUtil.getParameter(request, prefix	+ "dhf_aud", length));
			String[] dthAud = (JSPUtil.getParameter(request, prefix	+ "dth_aud", length));
			String[] ehcAud = (JSPUtil.getParameter(request, prefix	+ "ehc_aud", length));
			String[] ehcUsd = (JSPUtil.getParameter(request, prefix	+ "ehc_usd", length));
			String[] dtsAud = (JSPUtil.getParameter(request, prefix	+ "dts_aud", length));
			String[] dtsUsd = (JSPUtil.getParameter(request, prefix	+ "dts_usd", length));
			String[] dpsAud = (JSPUtil.getParameter(request, prefix	+ "dps_aud", length));
			String[] dpsUsd = (JSPUtil.getParameter(request, prefix	+ "dps_usd", length));
			String[] dtcAud = (JSPUtil.getParameter(request, prefix	+ "dtc_aud", length));
			String[] dtcUsd = (JSPUtil.getParameter(request, prefix	+ "dtc_usd", length));
			String[] astAud = (JSPUtil.getParameter(request, prefix	+ "ast_aud", length));
			String[] astUsd = (JSPUtil.getParameter(request, prefix	+ "ast_usd", length));
			String[] tvaAud = (JSPUtil.getParameter(request, prefix	+ "tva_aud", length));
			String[] tvaUsd = (JSPUtil.getParameter(request, prefix	+ "tva_usd", length));
			String[] nonTaxableAud = (JSPUtil.getParameter(request, prefix	+ "non_taxable_aud", length));
			String[] nonTaxableUsd = (JSPUtil.getParameter(request, prefix	+ "non_taxable_usd", length));
			String[] lclAmt = (JSPUtil.getParameter(request, prefix	+ "lcl_amt", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] grandTotal = (JSPUtil.getParameter(request, prefix	+ "grand_total", length));
			String[] invType = (JSPUtil.getParameter(request, prefix	+ "inv_type", length));
			
			String[] actInvNo = (JSPUtil.getParameter(request, prefix	+ "act_inv_no", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] netAmt = (JSPUtil.getParameter(request, prefix	+ "net_amt", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] grossAmt = (JSPUtil.getParameter(request, prefix	+ "gross_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));			
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceIssueTVAListVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (nonTaxableAmt[i] != null)
					model.setNonTaxableAmt(nonTaxableAmt[i]);
				if (tvaLcl[i] != null)
					model.setTvaLcl(tvaLcl[i]);
				if (vatNo[i] != null)
					model.setVatNo(vatNo[i]);
				if (customer[i] != null)
					model.setCustomer(customer[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (taxableAmt[i] != null)
					model.setTaxableAmt(taxableAmt[i]);
				if (frtUsd[i] != null)
					model.setFrtUsd(frtUsd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (eqvLcl[i] != null)
					model.setEqvLcl(eqvLcl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgLcl[i] != null)
					model.setChgLcl(chgLcl[i]);
				if (ttlLcl[i] != null)
					model.setTtlLcl(ttlLcl[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);

				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vdtTtl[i] != null)
					model.setVdtTtl(vdtTtl[i]);
				if (vttTtl[i] != null)
					model.setVttTtl(vttTtl[i]);
				if (dhfVnd[i] != null)
					model.setDhfVnd(dhfVnd[i]);
				if (dhfUsd[i] != null)
					model.setDhfUsd(dhfUsd[i]);
				if (ddfVnd[i] != null)
					model.setDdfVnd(ddfVnd[i]);
				if (ddfUsd[i] != null)
					model.setDdfUsd(ddfUsd[i]);
				if (obsVnd[i] != null)
					model.setObsVnd(obsVnd[i]);
				if (obsUsd[i] != null)
					model.setObsUsd(obsUsd[i]);
				if (othVnd[i] != null)
					model.setOthVnd(othVnd[i]);
				if (othUsd[i] != null)
					model.setOthUsd(othUsd[i]);
				if (dthVnd[i] != null)
					model.setDthVnd(dthVnd[i]);
				if (dthUsd[i] != null)
					model.setDthUsd(dthUsd[i]);
				if (ddcVnd[i] != null)
					model.setDthVnd(dthVnd[i]);
				if (ddcUsd[i] != null)
					model.setDdcUsd(ddcUsd[i]);
				if (orcVnd[i] != null)
					model.setOrcVnd(orcVnd[i]);
				if (orcUsd[i] != null)
					model.setOrcUsd(orcUsd[i]);
				
				if (cmrAud[i] != null)
					model.setCmrAud(cmrAud[i]);
				if (cmrUsd[i] != null)
					model.setCmrUsd(cmrUsd[i]);
				if (dhfAud[i] != null)
					model.setDhfAud(dhfAud[i]);
				if (dthAud[i] != null)
					model.setDthAud(dthAud[i]);
				if (ehcAud[i] != null)
					model.setEhcAud(ehcAud[i]);
				if (ehcUsd[i] != null)
					model.setEhcUsd(ehcUsd[i]);
				if (dtsAud[i] != null)
					model.setDtsAud(dtsAud[i]);
				if (dtsUsd[i] != null)
					model.setDtsUsd(dtsUsd[i]);
				if (dpsAud[i] != null)
					model.setDpsAud(dpsAud[i]);
				if (dpsUsd[i] != null)
					model.setDpsUsd(dpsUsd[i]);
				if (dtcAud[i] != null)
					model.setDtcAud(dtcAud[i]);
				if (dtcUsd[i] != null)
					model.setDtcUsd(dtcUsd[i]);
				if (astAud[i] != null)
					model.setAstAud(astAud[i]);
				if (astUsd[i] != null)
					model.setAstUsd(astUsd[i]);
				if (tvaAud[i] != null)
					model.setTvaAud(tvaAud[i]);
				if (tvaUsd[i] != null)
					model.setTvaUsd(tvaUsd[i]);
				if (nonTaxableAud[i] != null)
					model.setNonTaxableAud(nonTaxableAud[i]);
				if (nonTaxableUsd[i] != null)
					model.setNonTaxableUsd(nonTaxableUsd[i]);
				if (lclAmt[i] != null)
					model.setLclAmt(lclAmt[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (grandTotal[i] != null)
					model.setGrandTotal(grandTotal[i]);
				
				if (invType[i] != null)
					model.setInvType(invType[i]);
				if (actInvNo[i] != null)
					model.setActInvNo(actInvNo[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (netAmt[i] != null)
					model.setNetAmt(netAmt[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (grossAmt[i] != null)
					model.setGrossAmt(grossAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceIssueTVAListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceIssueTVAListVO[]
	 */
	public InvoiceIssueTVAListVO[] getInvoiceIssueTVAListVOs(){
		InvoiceIssueTVAListVO[] vos = (InvoiceIssueTVAListVO[])models.toArray(new InvoiceIssueTVAListVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonTaxableAmt = this.nonTaxableAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaLcl = this.tvaLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatNo = this.vatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customer = this.customer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxableAmt = this.taxableAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtUsd = this.frtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqvLcl = this.eqvLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgLcl = this.chgLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLcl = this.ttlLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdtTtl = this.vdtTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vttTtl = this.vttTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfVnd = this.dhfVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfUsd = this.dhfUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddfVnd = this.ddfVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddfUsd = this.ddfUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsVnd = this.obsVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obsUsd = this.obsUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othVnd = this.othVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othUsd = this.othUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthVnd = this.dthVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthUsd = this.dthUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddcVnd = this.ddcVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddcUsd = this.ddcUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orcVnd = this.orcVnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orcUsd = this.orcUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.cmrAud = this.cmrAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmrUsd = this.cmrUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfAud = this.dhfAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dthAud = this.dthAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ehcAud = this.ehcAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ehcUsd = this.ehcUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtsAud = this.dtsAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtsUsd = this.dtsUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpsAud = this.dpsAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpsUsd = this.dpsUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtcAud = this.dtcAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtcUsd = this.dtcUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.astAud = this.astAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.astUsd = this.astUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaAud = this.tvaAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaUsd = this.tvaUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonTaxableAud = this.nonTaxableAud .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonTaxableUsd = this.nonTaxableUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt = this.lclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTotal = this.grandTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.invType = this.invType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo = this.actInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netAmt = this.netAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossAmt = this.grossAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
