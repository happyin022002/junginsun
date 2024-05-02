/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SettlementRFVO.java
 *@FileTitle : SettlementRFVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.13
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.01.13 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class SettlementRFVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SettlementRFVO>  models =	new	ArrayList<SettlementRFVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String stlSeq20 = null;
	/*	Column Info	*/
	private String vslCd = null;
	/*	Column Info	*/
	private String stlDupFlg20 = null;
	/*	Column Info	*/
	private String rfScgPrc40 = null;
	/*	Column Info	*/
	private String slipNo = null;
	/*	Column Info	*/
	private String etaDt = null;
	/*	Column Info	*/
	private String rfScgPrc20 = null;
	/*	Column Info	*/
	private String fmPortCd = null;
	/*	Column Info	*/
	private String dupFlg = null;
	/*	Column Info	*/
	private String trdCd = null;
	/*	Column Info	*/
	private String rlaneCd = null;
	/*	Column Info	*/
	private String joStlItmCd = null;
	/*	Column Info	*/
	private String stlSeq40 = null;
	/*	Column Info	*/
	private String revDirCd = null;
	/*	Column Info	*/
	private String stlLstFlg40 = null;
	/*	Column Info	*/
	private String usdSltBsaQty40 = null;
	/*	Column Info	*/
	private String ucBssPortCd = null;
	/*	Column Info	*/
	private String stlLoclAmt20 = null;
	/*	Column Info	*/
	private String joMnuNm = null;
	/*	Column Info	*/
	private String stlBzcPortCd = null;
	/*	Column Info	*/
	private String stlAdjFlg20 = null;
	/*	Column Info	*/
	private String stlAdjFlg40 = null;
	/*	Column Info	*/
	private String rvsCmbFlg = null;
	/*	Column Info	*/
	private String rvsCmbType = null;
	/*	Column Info	*/
	private String usdSltBsaQty20 = null;
	/*	Column Info	*/
	private String ucBssPortEtdDt = null;
	/*	Column Info	*/
	private String stlLoclAmt40 = null;
	/*	Column Info	*/
	private String rfScgStlTpCd = null;
	/*	Column Info	*/
	private String stlDupFlg40 = null;
	/*	Column Info	*/
	private String stlVvdSeq = null;
	/*	Column Info	*/
	private String toPortCd1 = null;
	/*	Column Info	*/
	private String iocCd = null;
	/*	Column Info	*/
	private String fmPortCd1 = null;
	/*	Column Info	*/
	private String loclCurrCd = null;
	/*	Column Info	*/
	private String skdVoyNo = null;
	/*	Column Info	*/
	private String joCrrCd = null;
	/*	Column Info	*/
	private String skdDirCd = null;
	/*	Column Info	*/
	private String stlLstFlg20 = null;
	/*	Column Info	*/
	private String rvsCmbFlg40 = null;
	/*	Column Info	*/
	private String rvsCmbFlg20 = null;
	/*	Column Info	*/
	private String acctYrmon = null;
	/*	Column Info	*/
	private String reDivrCd = null;
	/*	Column Info	*/
	private String vvdSumAmt = null;
	/*	Column Info	*/
	private String toPortCd = null;
	/*	Column Info	*/
	private String stlCmbSeq = null;
	/*	Column Info	*/
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public SettlementRFVO(){}

	public SettlementRFVO(String ibflag,String pagerows,String stlSeq20,String vslCd,String stlDupFlg20,String rfScgPrc40,String slipNo,String etaDt,String rfScgPrc20,String fmPortCd,String dupFlg,String trdCd,String rlaneCd,String joStlItmCd,String stlSeq40,String revDirCd,String stlLstFlg40,String usdSltBsaQty40,String ucBssPortCd,String stlLoclAmt20,String joMnuNm,String stlBzcPortCd,String stlAdjFlg20,String stlAdjFlg40,String rvsCmbFlg,String rvsCmbType,String usdSltBsaQty20,String ucBssPortEtdDt,String stlLoclAmt40,String rfScgStlTpCd,String stlDupFlg40,String stlVvdSeq,String toPortCd1,String iocCd,String fmPortCd1,String loclCurrCd,String skdVoyNo,String joCrrCd,String skdDirCd,String stlLstFlg20,String rvsCmbFlg40,String rvsCmbFlg20,String acctYrmon,String reDivrCd,String vvdSumAmt,String toPortCd,String stlCmbSeq,String scontiCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.stlSeq20 = stlSeq20;
		this.vslCd = vslCd;
		this.stlDupFlg20 = stlDupFlg20;
		this.rfScgPrc40 = rfScgPrc40;
		this.slipNo = slipNo;
		this.etaDt = etaDt;
		this.rfScgPrc20 = rfScgPrc20;
		this.fmPortCd = fmPortCd;
		this.dupFlg = dupFlg;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joStlItmCd = joStlItmCd;
		this.stlSeq40 = stlSeq40;
		this.revDirCd = revDirCd;
		this.stlLstFlg40 = stlLstFlg40;
		this.usdSltBsaQty40 = usdSltBsaQty40;
		this.ucBssPortCd = ucBssPortCd;
		this.stlLoclAmt20 = stlLoclAmt20;
		this.joMnuNm = joMnuNm;
		this.stlBzcPortCd = stlBzcPortCd;
		this.stlAdjFlg20 = stlAdjFlg20;
		this.stlAdjFlg40 = stlAdjFlg40;
		this.rvsCmbFlg = rvsCmbFlg;
		this.rvsCmbType = rvsCmbType;
		this.usdSltBsaQty20 = usdSltBsaQty20;
		this.ucBssPortEtdDt = ucBssPortEtdDt;
		this.stlLoclAmt40 = stlLoclAmt40;
		this.rfScgStlTpCd = rfScgStlTpCd;
		this.stlDupFlg40 = stlDupFlg40;
		this.stlVvdSeq = stlVvdSeq;
		this.toPortCd1 = toPortCd1;
		this.iocCd = iocCd;
		this.fmPortCd1 = fmPortCd1;
		this.loclCurrCd = loclCurrCd;
		this.skdVoyNo = skdVoyNo;
		this.joCrrCd = joCrrCd;
		this.skdDirCd = skdDirCd;
		this.stlLstFlg20 = stlLstFlg20;
		this.rvsCmbFlg40 = rvsCmbFlg40;
		this.rvsCmbFlg20 = rvsCmbFlg20;
		this.acctYrmon = acctYrmon;
		this.reDivrCd = reDivrCd;
		this.vvdSumAmt = vvdSumAmt;
		this.toPortCd = toPortCd;
		this.stlCmbSeq = stlCmbSeq;
		this.scontiCd = scontiCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("stl_seq_20", getStlSeq20());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("stl_dup_flg_20", getStlDupFlg20());
		this.hashColumns.put("rf_scg_prc_40", getRfScgPrc40());
		this.hashColumns.put("slip_no", getSlipNo());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("rf_scg_prc_20", getRfScgPrc20());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("dup_flg", getDupFlg());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("stl_seq_40", getStlSeq40());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("stl_lst_flg_40", getStlLstFlg40());
		this.hashColumns.put("usd_slt_bsa_qty_40", getUsdSltBsaQty40());
		this.hashColumns.put("uc_bss_port_cd", getUcBssPortCd());
		this.hashColumns.put("stl_locl_amt_20", getStlLoclAmt20());
		this.hashColumns.put("jo_mnu_nm", getJoMnuNm());
		this.hashColumns.put("stl_bzc_port_cd", getStlBzcPortCd());
		this.hashColumns.put("stl_adj_flg_20", getStlAdjFlg20());
		this.hashColumns.put("stl_adj_flg_40", getStlAdjFlg40());
		this.hashColumns.put("rvs_cmb_flg", getRvsCmbFlg());
		this.hashColumns.put("rvs_cmb_type", getRvsCmbType());
		this.hashColumns.put("usd_slt_bsa_qty_20", getUsdSltBsaQty20());
		this.hashColumns.put("uc_bss_port_etd_dt", getUcBssPortEtdDt());
		this.hashColumns.put("stl_locl_amt_40", getStlLoclAmt40());
		this.hashColumns.put("rf_scg_stl_tp_cd", getRfScgStlTpCd());
		this.hashColumns.put("stl_dup_flg_40", getStlDupFlg40());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("to_port_cd1", getToPortCd1());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("fm_port_cd1", getFmPortCd1());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("stl_lst_flg_20", getStlLstFlg20());
		this.hashColumns.put("rvs_cmb_flg_40", getRvsCmbFlg40());
		this.hashColumns.put("rvs_cmb_flg_20", getRvsCmbFlg20());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("vvd_sum_amt", getVvdSumAmt());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("sconti_cd", getScontiCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("stl_seq_20", "stlSeq20");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stl_dup_flg_20", "stlDupFlg20");
		this.hashFields.put("rf_scg_prc_40", "rfScgPrc40");
		this.hashFields.put("slip_no", "slipNo");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("rf_scg_prc_20", "rfScgPrc20");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("dup_flg", "dupFlg");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("stl_seq_40", "stlSeq40");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("stl_lst_flg_40", "stlLstFlg40");
		this.hashFields.put("usd_slt_bsa_qty_40", "usdSltBsaQty40");
		this.hashFields.put("uc_bss_port_cd", "ucBssPortCd");
		this.hashFields.put("stl_locl_amt_20", "stlLoclAmt20");
		this.hashFields.put("jo_mnu_nm", "joMnuNm");
		this.hashFields.put("stl_bzc_port_cd", "stlBzcPortCd");
		this.hashFields.put("stl_adj_flg_20", "stlAdjFlg20");
		this.hashFields.put("stl_adj_flg_40", "stlAdjFlg40");
		this.hashFields.put("rvs_cmb_flg", "rvsCmbFlg");
		this.hashFields.put("rvs_cmb_type", "rvsCmbType");
		this.hashFields.put("usd_slt_bsa_qty_20", "usdSltBsaQty20");
		this.hashFields.put("uc_bss_port_etd_dt", "ucBssPortEtdDt");
		this.hashFields.put("stl_locl_amt_40", "stlLoclAmt40");
		this.hashFields.put("rf_scg_stl_tp_cd", "rfScgStlTpCd");
		this.hashFields.put("stl_dup_flg_40", "stlDupFlg40");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("to_port_cd1", "toPortCd1");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("fm_port_cd1", "fmPortCd1");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("stl_lst_flg_20", "stlLstFlg20");
		this.hashFields.put("rvs_cmb_flg_40", "rvsCmbFlg40");
		this.hashFields.put("rvs_cmb_flg_20", "rvsCmbFlg20");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("vvd_sum_amt", "vvdSumAmt");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("sconti_cd", "scontiCd");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return stlSeq20
	 */
	public	String getStlSeq20() {
		return	this.stlSeq20;
	}

	/**
	 * Column Info
	 * @return vslCd
	 */
	public	String getVslCd() {
		return	this.vslCd;
	}

	/**
	 * Column Info
	 * @return stlDupFlg20
	 */
	public	String getStlDupFlg20() {
		return	this.stlDupFlg20;
	}

	/**
	 * Column Info
	 * @return rfScgPrc40
	 */
	public	String getRfScgPrc40() {
		return	this.rfScgPrc40;
	}

	/**
	 * Column Info
	 * @return slipNo
	 */
	public	String getSlipNo() {
		return	this.slipNo;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public	String getEtaDt() {
		return	this.etaDt;
	}

	/**
	 * Column Info
	 * @return rfScgPrc20
	 */
	public	String getRfScgPrc20() {
		return	this.rfScgPrc20;
	}

	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public	String getFmPortCd() {
		return	this.fmPortCd;
	}

	/**
	 * Column Info
	 * @return dupFlg
	 */
	public	String getDupFlg() {
		return	this.dupFlg;
	}

	/**
	 * Column Info
	 * @return trdCd
	 */
	public	String getTrdCd() {
		return	this.trdCd;
	}

	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public	String getRlaneCd() {
		return	this.rlaneCd;
	}

	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public	String getJoStlItmCd() {
		return	this.joStlItmCd;
	}

	/**
	 * Column Info
	 * @return stlSeq40
	 */
	public	String getStlSeq40() {
		return	this.stlSeq40;
	}

	/**
	 * Column Info
	 * @return revDirCd
	 */
	public	String getRevDirCd() {
		return	this.revDirCd;
	}

	/**
	 * Column Info
	 * @return stlLstFlg40
	 */
	public	String getStlLstFlg40() {
		return	this.stlLstFlg40;
	}

	/**
	 * Column Info
	 * @return usdSltBsaQty40
	 */
	public	String getUsdSltBsaQty40() {
		return	this.usdSltBsaQty40;
	}

	/**
	 * Column Info
	 * @return ucBssPortCd
	 */
	public	String getUcBssPortCd() {
		return	this.ucBssPortCd;
	}

	/**
	 * Column Info
	 * @return stlLoclAmt20
	 */
	public	String getStlLoclAmt20() {
		return	this.stlLoclAmt20;
	}

	/**
	 * Column Info
	 * @return joMnuNm
	 */
	public	String getJoMnuNm() {
		return	this.joMnuNm;
	}

	/**
	 * Column Info
	 * @return stlBzcPortCd
	 */
	public	String getStlBzcPortCd() {
		return	this.stlBzcPortCd;
	}

	/**
	 * Column Info
	 * @return stlAdjFlg20
	 */
	public	String getStlAdjFlg20() {
		return	this.stlAdjFlg20;
	}

	/**
	 * Column Info
	 * @return stlAdjFlg40
	 */
	public	String getStlAdjFlg40() {
		return	this.stlAdjFlg40;
	}

	/**
	 * Column Info
	 * @return rvsCmbFlg
	 */
	public	String getRvsCmbFlg() {
		return	this.rvsCmbFlg;
	}

	/**
	 * Column Info
	 * @return rvsCmbType
	 */
	public	String getRvsCmbType() {
		return	this.rvsCmbType;
	}

	/**
	 * Column Info
	 * @return usdSltBsaQty20
	 */
	public	String getUsdSltBsaQty20() {
		return	this.usdSltBsaQty20;
	}

	/**
	 * Column Info
	 * @return ucBssPortEtdDt
	 */
	public	String getUcBssPortEtdDt() {
		return	this.ucBssPortEtdDt;
	}

	/**
	 * Column Info
	 * @return stlLoclAmt40
	 */
	public	String getStlLoclAmt40() {
		return	this.stlLoclAmt40;
	}

	/**
	 * Column Info
	 * @return rfScgStlTpCd
	 */
	public	String getRfScgStlTpCd() {
		return	this.rfScgStlTpCd;
	}

	/**
	 * Column Info
	 * @return stlDupFlg40
	 */
	public	String getStlDupFlg40() {
		return	this.stlDupFlg40;
	}

	/**
	 * Column Info
	 * @return stlVvdSeq
	 */
	public	String getStlVvdSeq() {
		return	this.stlVvdSeq;
	}

	/**
	 * Column Info
	 * @return toPortCd1
	 */
	public	String getToPortCd1() {
		return	this.toPortCd1;
	}

	/**
	 * Column Info
	 * @return iocCd
	 */
	public	String getIocCd() {
		return	this.iocCd;
	}

	/**
	 * Column Info
	 * @return fmPortCd1
	 */
	public	String getFmPortCd1() {
		return	this.fmPortCd1;
	}

	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public	String getLoclCurrCd() {
		return	this.loclCurrCd;
	}

	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public	String getSkdVoyNo() {
		return	this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public	String getJoCrrCd() {
		return	this.joCrrCd;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public	String getSkdDirCd() {
		return	this.skdDirCd;
	}

	/**
	 * Column Info
	 * @return stlLstFlg20
	 */
	public	String getStlLstFlg20() {
		return	this.stlLstFlg20;
	}

	/**
	 * Column Info
	 * @return rvsCmbFlg40
	 */
	public	String getRvsCmbFlg40() {
		return	this.rvsCmbFlg40;
	}

	/**
	 * Column Info
	 * @return rvsCmbFlg20
	 */
	public	String getRvsCmbFlg20() {
		return	this.rvsCmbFlg20;
	}

	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public	String getAcctYrmon() {
		return	this.acctYrmon;
	}

	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public	String getReDivrCd() {
		return	this.reDivrCd;
	}

	/**
	 * Column Info
	 * @return vvdSumAmt
	 */
	public	String getVvdSumAmt() {
		return	this.vvdSumAmt;
	}

	/**
	 * Column Info
	 * @return toPortCd
	 */
	public	String getToPortCd() {
		return	this.toPortCd;
	}

	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public	String getStlCmbSeq() {
		return	this.stlCmbSeq;
	}

	/**
	 * Column Info
	 * @return scontiCd
	 */
	public	String getScontiCd() {
		return	this.scontiCd;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  stlSeq20
 	 */
	public void	setStlSeq20(String stlSeq20 ) {
		this.stlSeq20 =	stlSeq20;
	}
 	/**
	 * Column Info
	 * @param  vslCd
 	 */
	public void	setVslCd(String vslCd ) {
		this.vslCd =	vslCd;
	}
 	/**
	 * Column Info
	 * @param  stlDupFlg20
 	 */
	public void	setStlDupFlg20(String stlDupFlg20 ) {
		this.stlDupFlg20 =	stlDupFlg20;
	}
 	/**
	 * Column Info
	 * @param  rfScgPrc40
 	 */
	public void	setRfScgPrc40(String rfScgPrc40 ) {
		this.rfScgPrc40 =	rfScgPrc40;
	}
 	/**
	 * Column Info
	 * @param  slipNo
 	 */
	public void	setSlipNo(String slipNo ) {
		this.slipNo =	slipNo;
	}
 	/**
	 * Column Info
	 * @param  etaDt
 	 */
	public void	setEtaDt(String etaDt ) {
		this.etaDt =	etaDt;
	}
 	/**
	 * Column Info
	 * @param  rfScgPrc20
 	 */
	public void	setRfScgPrc20(String rfScgPrc20 ) {
		this.rfScgPrc20 =	rfScgPrc20;
	}
 	/**
	 * Column Info
	 * @param  fmPortCd
 	 */
	public void	setFmPortCd(String fmPortCd ) {
		this.fmPortCd =	fmPortCd;
	}
 	/**
	 * Column Info
	 * @param  dupFlg
 	 */
	public void	setDupFlg(String dupFlg ) {
		this.dupFlg =	dupFlg;
	}
 	/**
	 * Column Info
	 * @param  trdCd
 	 */
	public void	setTrdCd(String trdCd ) {
		this.trdCd =	trdCd;
	}
 	/**
	 * Column Info
	 * @param  rlaneCd
 	 */
	public void	setRlaneCd(String rlaneCd ) {
		this.rlaneCd =	rlaneCd;
	}
 	/**
	 * Column Info
	 * @param  joStlItmCd
 	 */
	public void	setJoStlItmCd(String joStlItmCd ) {
		this.joStlItmCd =	joStlItmCd;
	}
 	/**
	 * Column Info
	 * @param  stlSeq40
 	 */
	public void	setStlSeq40(String stlSeq40 ) {
		this.stlSeq40 =	stlSeq40;
	}
 	/**
	 * Column Info
	 * @param  revDirCd
 	 */
	public void	setRevDirCd(String revDirCd ) {
		this.revDirCd =	revDirCd;
	}
 	/**
	 * Column Info
	 * @param  stlLstFlg40
 	 */
	public void	setStlLstFlg40(String stlLstFlg40 ) {
		this.stlLstFlg40 =	stlLstFlg40;
	}
 	/**
	 * Column Info
	 * @param  usdSltBsaQty40
 	 */
	public void	setUsdSltBsaQty40(String usdSltBsaQty40 ) {
		this.usdSltBsaQty40 =	usdSltBsaQty40;
	}
 	/**
	 * Column Info
	 * @param  ucBssPortCd
 	 */
	public void	setUcBssPortCd(String ucBssPortCd ) {
		this.ucBssPortCd =	ucBssPortCd;
	}
 	/**
	 * Column Info
	 * @param  stlLoclAmt20
 	 */
	public void	setStlLoclAmt20(String stlLoclAmt20 ) {
		this.stlLoclAmt20 =	stlLoclAmt20;
	}
 	/**
	 * Column Info
	 * @param  joMnuNm
 	 */
	public void	setJoMnuNm(String joMnuNm ) {
		this.joMnuNm =	joMnuNm;
	}
 	/**
	 * Column Info
	 * @param  stlBzcPortCd
 	 */
	public void	setStlBzcPortCd(String stlBzcPortCd ) {
		this.stlBzcPortCd =	stlBzcPortCd;
	}
 	/**
	 * Column Info
	 * @param  stlAdjFlg20
 	 */
	public void	setStlAdjFlg20(String stlAdjFlg20 ) {
		this.stlAdjFlg20 =	stlAdjFlg20;
	}
 	/**
	 * Column Info
	 * @param  stlAdjFlg40
 	 */
	public void	setStlAdjFlg40(String stlAdjFlg40 ) {
		this.stlAdjFlg40 =	stlAdjFlg40;
	}
 	/**
	 * Column Info
	 * @param  rvsCmbFlg
 	 */
	public void	setRvsCmbFlg(String rvsCmbFlg ) {
		this.rvsCmbFlg =	rvsCmbFlg;
	}
 	/**
	 * Column Info
	 * @param  rvsCmbType
 	 */
	public void	setRvsCmbType(String rvsCmbType ) {
		this.rvsCmbType =	rvsCmbType;
	}
 	/**
	 * Column Info
	 * @param  usdSltBsaQty20
 	 */
	public void	setUsdSltBsaQty20(String usdSltBsaQty20 ) {
		this.usdSltBsaQty20 =	usdSltBsaQty20;
	}
 	/**
	 * Column Info
	 * @param  ucBssPortEtdDt
 	 */
	public void	setUcBssPortEtdDt(String ucBssPortEtdDt ) {
		this.ucBssPortEtdDt =	ucBssPortEtdDt;
	}
 	/**
	 * Column Info
	 * @param  stlLoclAmt40
 	 */
	public void	setStlLoclAmt40(String stlLoclAmt40 ) {
		this.stlLoclAmt40 =	stlLoclAmt40;
	}
 	/**
	 * Column Info
	 * @param  rfScgStlTpCd
 	 */
	public void	setRfScgStlTpCd(String rfScgStlTpCd ) {
		this.rfScgStlTpCd =	rfScgStlTpCd;
	}
 	/**
	 * Column Info
	 * @param  stlDupFlg40
 	 */
	public void	setStlDupFlg40(String stlDupFlg40 ) {
		this.stlDupFlg40 =	stlDupFlg40;
	}
 	/**
	 * Column Info
	 * @param  stlVvdSeq
 	 */
	public void	setStlVvdSeq(String stlVvdSeq ) {
		this.stlVvdSeq =	stlVvdSeq;
	}
 	/**
	 * Column Info
	 * @param  toPortCd1
 	 */
	public void	setToPortCd1(String toPortCd1 ) {
		this.toPortCd1 =	toPortCd1;
	}
 	/**
	 * Column Info
	 * @param  iocCd
 	 */
	public void	setIocCd(String iocCd ) {
		this.iocCd =	iocCd;
	}
 	/**
	 * Column Info
	 * @param  fmPortCd1
 	 */
	public void	setFmPortCd1(String fmPortCd1 ) {
		this.fmPortCd1 =	fmPortCd1;
	}
 	/**
	 * Column Info
	 * @param  loclCurrCd
 	 */
	public void	setLoclCurrCd(String loclCurrCd ) {
		this.loclCurrCd =	loclCurrCd;
	}
 	/**
	 * Column Info
	 * @param  skdVoyNo
 	 */
	public void	setSkdVoyNo(String skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 	/**
	 * Column Info
	 * @param  joCrrCd
 	 */
	public void	setJoCrrCd(String joCrrCd ) {
		this.joCrrCd =	joCrrCd;
	}
 	/**
	 * Column Info
	 * @param  skdDirCd
 	 */
	public void	setSkdDirCd(String skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 	/**
	 * Column Info
	 * @param  stlLstFlg20
 	 */
	public void	setStlLstFlg20(String stlLstFlg20 ) {
		this.stlLstFlg20 =	stlLstFlg20;
	}
 	/**
	 * Column Info
	 * @param  rvsCmbFlg40
 	 */
	public void	setRvsCmbFlg40(String rvsCmbFlg40 ) {
		this.rvsCmbFlg40 =	rvsCmbFlg40;
	}
 	/**
	 * Column Info
	 * @param  rvsCmbFlg20
 	 */
	public void	setRvsCmbFlg20(String rvsCmbFlg20 ) {
		this.rvsCmbFlg20 =	rvsCmbFlg20;
	}
 	/**
	 * Column Info
	 * @param  acctYrmon
 	 */
	public void	setAcctYrmon(String acctYrmon ) {
		this.acctYrmon =	acctYrmon;
	}
 	/**
	 * Column Info
	 * @param  reDivrCd
 	 */
	public void	setReDivrCd(String reDivrCd ) {
		this.reDivrCd =	reDivrCd;
	}
 	/**
	 * Column Info
	 * @param  vvdSumAmt
 	 */
	public void	setVvdSumAmt(String vvdSumAmt ) {
		this.vvdSumAmt =	vvdSumAmt;
	}
 	/**
	 * Column Info
	 * @param  toPortCd
 	 */
	public void	setToPortCd(String toPortCd ) {
		this.toPortCd =	toPortCd;
	}
 	/**
	 * Column Info
	 * @param  stlCmbSeq
 	 */
	public void	setStlCmbSeq(String stlCmbSeq ) {
		this.stlCmbSeq =	stlCmbSeq;
	}
 	/**
	 * Column Info
	 * @param  scontiCd
 	 */
	public void	setScontiCd(String scontiCd ) {
		this.scontiCd =	scontiCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setStlSeq20(JSPUtil.getParameter(request,	prefix + "stl_seq_20", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setStlDupFlg20(JSPUtil.getParameter(request,	prefix + "stl_dup_flg_20", ""));
		setRfScgPrc40(JSPUtil.getParameter(request,	prefix + "rf_scg_prc_40", ""));
		setSlipNo(JSPUtil.getParameter(request,	prefix + "slip_no", ""));
		setEtaDt(JSPUtil.getParameter(request,	prefix + "eta_dt", ""));
		setRfScgPrc20(JSPUtil.getParameter(request,	prefix + "rf_scg_prc_20", ""));
		setFmPortCd(JSPUtil.getParameter(request,	prefix + "fm_port_cd", ""));
		setDupFlg(JSPUtil.getParameter(request,	prefix + "dup_flg", ""));
		setTrdCd(JSPUtil.getParameter(request,	prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request,	prefix + "rlane_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request,	prefix + "jo_stl_itm_cd", ""));
		setStlSeq40(JSPUtil.getParameter(request,	prefix + "stl_seq_40", ""));
		setRevDirCd(JSPUtil.getParameter(request,	prefix + "rev_dir_cd", ""));
		setStlLstFlg40(JSPUtil.getParameter(request,	prefix + "stl_lst_flg_40", ""));
		setUsdSltBsaQty40(JSPUtil.getParameter(request,	prefix + "usd_slt_bsa_qty_40", ""));
		setUcBssPortCd(JSPUtil.getParameter(request,	prefix + "uc_bss_port_cd", ""));
		setStlLoclAmt20(JSPUtil.getParameter(request,	prefix + "stl_locl_amt_20", ""));
		setJoMnuNm(JSPUtil.getParameter(request,	prefix + "jo_mnu_nm", ""));
		setStlBzcPortCd(JSPUtil.getParameter(request,	prefix + "stl_bzc_port_cd", ""));
		setStlAdjFlg20(JSPUtil.getParameter(request,	prefix + "stl_adj_flg_20", ""));
		setStlAdjFlg40(JSPUtil.getParameter(request,	prefix + "stl_adj_flg_40", ""));
		setRvsCmbFlg(JSPUtil.getParameter(request,	prefix + "rvs_cmb_flg", ""));
		setRvsCmbType(JSPUtil.getParameter(request,	prefix + "rvs_cmb_type", ""));
		setUsdSltBsaQty20(JSPUtil.getParameter(request,	prefix + "usd_slt_bsa_qty_20", ""));
		setUcBssPortEtdDt(JSPUtil.getParameter(request,	prefix + "uc_bss_port_etd_dt", ""));
		setStlLoclAmt40(JSPUtil.getParameter(request,	prefix + "stl_locl_amt_40", ""));
		setRfScgStlTpCd(JSPUtil.getParameter(request,	prefix + "rf_scg_stl_tp_cd", ""));
		setStlDupFlg40(JSPUtil.getParameter(request,	prefix + "stl_dup_flg_40", ""));
		setStlVvdSeq(JSPUtil.getParameter(request,	prefix + "stl_vvd_seq", ""));
		setToPortCd1(JSPUtil.getParameter(request,	prefix + "to_port_cd1", ""));
		setIocCd(JSPUtil.getParameter(request,	prefix + "ioc_cd", ""));
		setFmPortCd1(JSPUtil.getParameter(request,	prefix + "fm_port_cd1", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request,	prefix + "jo_crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setStlLstFlg20(JSPUtil.getParameter(request,	prefix + "stl_lst_flg_20", ""));
		setRvsCmbFlg40(JSPUtil.getParameter(request,	prefix + "rvs_cmb_flg_40", ""));
		setRvsCmbFlg20(JSPUtil.getParameter(request,	prefix + "rvs_cmb_flg_20", ""));
		setAcctYrmon(JSPUtil.getParameter(request,	prefix + "acct_yrmon", ""));
		setReDivrCd(JSPUtil.getParameter(request,	prefix + "re_divr_cd", ""));
		setVvdSumAmt(JSPUtil.getParameter(request,	prefix + "vvd_sum_amt", ""));
		setToPortCd(JSPUtil.getParameter(request,	prefix + "to_port_cd", ""));
		setStlCmbSeq(JSPUtil.getParameter(request,	prefix + "stl_cmb_seq", ""));
		setScontiCd(JSPUtil.getParameter(request,	prefix + "sconti_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementRFVO[]
	 */
	public SettlementRFVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SettlementRFVO[]
	 */
	public SettlementRFVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SettlementRFVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] stlSeq20 =	(JSPUtil.getParameter(request, prefix +	"stl_seq_20",	length));
			String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd",	length));
			String[] stlDupFlg20 =	(JSPUtil.getParameter(request, prefix +	"stl_dup_flg_20",	length));
			String[] rfScgPrc40 =	(JSPUtil.getParameter(request, prefix +	"rf_scg_prc_40",	length));
			String[] slipNo =	(JSPUtil.getParameter(request, prefix +	"slip_no",	length));
			String[] etaDt =	(JSPUtil.getParameter(request, prefix +	"eta_dt",	length));
			String[] rfScgPrc20 =	(JSPUtil.getParameter(request, prefix +	"rf_scg_prc_20",	length));
			String[] fmPortCd =	(JSPUtil.getParameter(request, prefix +	"fm_port_cd",	length));
			String[] dupFlg =	(JSPUtil.getParameter(request, prefix +	"dup_flg",	length));
			String[] trdCd =	(JSPUtil.getParameter(request, prefix +	"trd_cd",	length));
			String[] rlaneCd =	(JSPUtil.getParameter(request, prefix +	"rlane_cd",	length));
			String[] joStlItmCd =	(JSPUtil.getParameter(request, prefix +	"jo_stl_itm_cd",	length));
			String[] stlSeq40 =	(JSPUtil.getParameter(request, prefix +	"stl_seq_40",	length));
			String[] revDirCd =	(JSPUtil.getParameter(request, prefix +	"rev_dir_cd",	length));
			String[] stlLstFlg40 =	(JSPUtil.getParameter(request, prefix +	"stl_lst_flg_40",	length));
			String[] usdSltBsaQty40 =	(JSPUtil.getParameter(request, prefix +	"usd_slt_bsa_qty_40",	length));
			String[] ucBssPortCd =	(JSPUtil.getParameter(request, prefix +	"uc_bss_port_cd",	length));
			String[] stlLoclAmt20 =	(JSPUtil.getParameter(request, prefix +	"stl_locl_amt_20",	length));
			String[] joMnuNm =	(JSPUtil.getParameter(request, prefix +	"jo_mnu_nm",	length));
			String[] stlBzcPortCd =	(JSPUtil.getParameter(request, prefix +	"stl_bzc_port_cd",	length));
			String[] stlAdjFlg20 =	(JSPUtil.getParameter(request, prefix +	"stl_adj_flg_20",	length));
			String[] stlAdjFlg40 =	(JSPUtil.getParameter(request, prefix +	"stl_adj_flg_40",	length));
			String[] rvsCmbFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_cmb_flg",	length));
			String[] rvsCmbType =	(JSPUtil.getParameter(request, prefix +	"rvs_cmb_type",	length));
			String[] usdSltBsaQty20 =	(JSPUtil.getParameter(request, prefix +	"usd_slt_bsa_qty_20",	length));
			String[] ucBssPortEtdDt =	(JSPUtil.getParameter(request, prefix +	"uc_bss_port_etd_dt",	length));
			String[] stlLoclAmt40 =	(JSPUtil.getParameter(request, prefix +	"stl_locl_amt_40",	length));
			String[] rfScgStlTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_scg_stl_tp_cd",	length));
			String[] stlDupFlg40 =	(JSPUtil.getParameter(request, prefix +	"stl_dup_flg_40",	length));
			String[] stlVvdSeq =	(JSPUtil.getParameter(request, prefix +	"stl_vvd_seq",	length));
			String[] toPortCd1 =	(JSPUtil.getParameter(request, prefix +	"to_port_cd1",	length));
			String[] iocCd =	(JSPUtil.getParameter(request, prefix +	"ioc_cd",	length));
			String[] fmPortCd1 =	(JSPUtil.getParameter(request, prefix +	"fm_port_cd1",	length));
			String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd",	length));
			String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no",	length));
			String[] joCrrCd =	(JSPUtil.getParameter(request, prefix +	"jo_crr_cd",	length));
			String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd",	length));
			String[] stlLstFlg20 =	(JSPUtil.getParameter(request, prefix +	"stl_lst_flg_20",	length));
			String[] rvsCmbFlg40 =	(JSPUtil.getParameter(request, prefix +	"rvs_cmb_flg_40",	length));
			String[] rvsCmbFlg20 =	(JSPUtil.getParameter(request, prefix +	"rvs_cmb_flg_20",	length));
			String[] acctYrmon =	(JSPUtil.getParameter(request, prefix +	"acct_yrmon",	length));
			String[] reDivrCd =	(JSPUtil.getParameter(request, prefix +	"re_divr_cd",	length));
			String[] vvdSumAmt =	(JSPUtil.getParameter(request, prefix +	"vvd_sum_amt",	length));
			String[] toPortCd =	(JSPUtil.getParameter(request, prefix +	"to_port_cd",	length));
			String[] stlCmbSeq =	(JSPUtil.getParameter(request, prefix +	"stl_cmb_seq",	length));
			String[] scontiCd =	(JSPUtil.getParameter(request, prefix +	"sconti_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	SettlementRFVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( stlSeq20[i] !=	null)
					model.setStlSeq20( stlSeq20[i]);
				if ( vslCd[i] !=	null)
					model.setVslCd( vslCd[i]);
				if ( stlDupFlg20[i] !=	null)
					model.setStlDupFlg20( stlDupFlg20[i]);
				if ( rfScgPrc40[i] !=	null)
					model.setRfScgPrc40( rfScgPrc40[i]);
				if ( slipNo[i] !=	null)
					model.setSlipNo( slipNo[i]);
				if ( etaDt[i] !=	null)
					model.setEtaDt( etaDt[i]);
				if ( rfScgPrc20[i] !=	null)
					model.setRfScgPrc20( rfScgPrc20[i]);
				if ( fmPortCd[i] !=	null)
					model.setFmPortCd( fmPortCd[i]);
				if ( dupFlg[i] !=	null)
					model.setDupFlg( dupFlg[i]);
				if ( trdCd[i] !=	null)
					model.setTrdCd( trdCd[i]);
				if ( rlaneCd[i] !=	null)
					model.setRlaneCd( rlaneCd[i]);
				if ( joStlItmCd[i] !=	null)
					model.setJoStlItmCd( joStlItmCd[i]);
				if ( stlSeq40[i] !=	null)
					model.setStlSeq40( stlSeq40[i]);
				if ( revDirCd[i] !=	null)
					model.setRevDirCd( revDirCd[i]);
				if ( stlLstFlg40[i] !=	null)
					model.setStlLstFlg40( stlLstFlg40[i]);
				if ( usdSltBsaQty40[i] !=	null)
					model.setUsdSltBsaQty40( usdSltBsaQty40[i]);
				if ( ucBssPortCd[i] !=	null)
					model.setUcBssPortCd( ucBssPortCd[i]);
				if ( stlLoclAmt20[i] !=	null)
					model.setStlLoclAmt20( stlLoclAmt20[i]);
				if ( joMnuNm[i] !=	null)
					model.setJoMnuNm( joMnuNm[i]);
				if ( stlBzcPortCd[i] !=	null)
					model.setStlBzcPortCd( stlBzcPortCd[i]);
				if ( stlAdjFlg20[i] !=	null)
					model.setStlAdjFlg20( stlAdjFlg20[i]);
				if ( stlAdjFlg40[i] !=	null)
					model.setStlAdjFlg40( stlAdjFlg40[i]);
				if ( rvsCmbFlg[i] !=	null)
					model.setRvsCmbFlg( rvsCmbFlg[i]);
				if ( rvsCmbType[i] !=	null)
					model.setRvsCmbType( rvsCmbType[i]);
				if ( usdSltBsaQty20[i] !=	null)
					model.setUsdSltBsaQty20( usdSltBsaQty20[i]);
				if ( ucBssPortEtdDt[i] !=	null)
					model.setUcBssPortEtdDt( ucBssPortEtdDt[i]);
				if ( stlLoclAmt40[i] !=	null)
					model.setStlLoclAmt40( stlLoclAmt40[i]);
				if ( rfScgStlTpCd[i] !=	null)
					model.setRfScgStlTpCd( rfScgStlTpCd[i]);
				if ( stlDupFlg40[i] !=	null)
					model.setStlDupFlg40( stlDupFlg40[i]);
				if ( stlVvdSeq[i] !=	null)
					model.setStlVvdSeq( stlVvdSeq[i]);
				if ( toPortCd1[i] !=	null)
					model.setToPortCd1( toPortCd1[i]);
				if ( iocCd[i] !=	null)
					model.setIocCd( iocCd[i]);
				if ( fmPortCd1[i] !=	null)
					model.setFmPortCd1( fmPortCd1[i]);
				if ( loclCurrCd[i] !=	null)
					model.setLoclCurrCd( loclCurrCd[i]);
				if ( skdVoyNo[i] !=	null)
					model.setSkdVoyNo( skdVoyNo[i]);
				if ( joCrrCd[i] !=	null)
					model.setJoCrrCd( joCrrCd[i]);
				if ( skdDirCd[i] !=	null)
					model.setSkdDirCd( skdDirCd[i]);
				if ( stlLstFlg20[i] !=	null)
					model.setStlLstFlg20( stlLstFlg20[i]);
				if ( rvsCmbFlg40[i] !=	null)
					model.setRvsCmbFlg40( rvsCmbFlg40[i]);
				if ( rvsCmbFlg20[i] !=	null)
					model.setRvsCmbFlg20( rvsCmbFlg20[i]);
				if ( acctYrmon[i] !=	null)
					model.setAcctYrmon( acctYrmon[i]);
				if ( reDivrCd[i] !=	null)
					model.setReDivrCd( reDivrCd[i]);
				if ( vvdSumAmt[i] !=	null)
					model.setVvdSumAmt( vvdSumAmt[i]);
				if ( toPortCd[i] !=	null)
					model.setToPortCd( toPortCd[i]);
				if ( stlCmbSeq[i] !=	null)
					model.setStlCmbSeq( stlCmbSeq[i]);
				if ( scontiCd[i] !=	null)
					model.setScontiCd( scontiCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getSettlementRFVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SettlementRFVO[]
	 */
	public SettlementRFVO[]	 getSettlementRFVOs(){
		SettlementRFVO[] vos = (SettlementRFVO[])models.toArray(new	SettlementRFVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSeq20 =	this.stlSeq20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDupFlg20 =	this.stlDupFlg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgPrc40 =	this.rfScgPrc40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipNo =	this.slipNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt =	this.etaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgPrc20 =	this.rfScgPrc20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd =	this.fmPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg =	this.dupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd =	this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd =	this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd =	this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSeq40 =	this.stlSeq40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd =	this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLstFlg40 =	this.stlLstFlg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSltBsaQty40 =	this.usdSltBsaQty40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucBssPortCd =	this.ucBssPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt20 =	this.stlLoclAmt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joMnuNm =	this.joMnuNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlBzcPortCd =	this.stlBzcPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAdjFlg20 =	this.stlAdjFlg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAdjFlg40 =	this.stlAdjFlg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCmbFlg =	this.rvsCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCmbType =	this.rvsCmbType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSltBsaQty20 =	this.usdSltBsaQty20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucBssPortEtdDt =	this.ucBssPortEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt40 =	this.stlLoclAmt40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgStlTpCd =	this.rfScgStlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDupFlg40 =	this.stlDupFlg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq =	this.stlVvdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd1 =	this.toPortCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd =	this.iocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd1 =	this.fmPortCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd =	this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLstFlg20 =	this.stlLstFlg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCmbFlg40 =	this.rvsCmbFlg40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsCmbFlg20 =	this.rvsCmbFlg20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon =	this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd =	this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSumAmt =	this.vvdSumAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd =	this.toPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq =	this.stlCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd =	this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}