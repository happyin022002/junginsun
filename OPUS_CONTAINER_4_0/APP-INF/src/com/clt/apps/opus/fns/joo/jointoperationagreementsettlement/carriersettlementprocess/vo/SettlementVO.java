/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementVO.java
*@FileTitle : SettlementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.20 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SettlementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SettlementVO> models = new ArrayList<SettlementVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String stlAdjFlg = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String fmPortCd = null;
	/* Column Info */
	private String preAcctYrmon = null;
	/* Column Info */
	private String stlUsdAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usdSltWgt = null;
	/* Column Info */
	private String usdSltBsaQty = null;
	/* Column Info */
	private String stlBzcPortCd = null;
	/* Column Info */
	private String stlLstFlg = null;
	/* Column Info */
	private String ucBssPortEtdDt = null;
	/* Column Info */
	private String rfScgStlTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eBsaSltPrc = null;
	/* Column Info */
	private String preStlVvdSeq = null;
	/* Column Info */
	private String adjBsaSltPrcLoclAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String fnlOwnBsaQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String rfScgPrc = null;
	/* Column Info */
	private String joStlJbCdNm = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String joStlJbCd = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String rBsaSltPrc = null;
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rVvd = null;
	/* Column Info */
	private String stlTjNo = null;
	/* Column Info */
	private String joStlItmCdNm = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ucBssPortCd = null;
	/* Column Info */
	private String stlLoclAmt = null;
	/* Column Info */
	private String joMnuNm = null;
	/* Column Info */
	private String rStlLoclAmt = null;
	/* Column Info */
	private String cmbCfmFlg = null;
	/* Column Info */
	private String eBsaQty = null;
	/* Column Info */
	private String stlVvdSeq = null;
	/* Column Info */
	private String bsaPerWgt = null;
	/* Column Info */
	private String stlRmk = null;
	/* Column Info */
	private String stlSeq = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String preStlSeq = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rBsaQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fnlBsaWgt = null;
	/* Column Info */
	private String eStlLoclAmt = null;
	/* Column Info */
	private String adjBsaQtyLoclAmt = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String eVvd = null;
	/* Column Info */
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SettlementVO() {}

	public SettlementVO(String ibflag, String pagerows, String acctYrmon, String stlVvdSeq, String stlSeq, String trdCd, String joCrrCd, String rlaneCd, String reDivrCd, String joStlItmCd, String joMnuNm, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String stlBzcPortCd, String etaDt, String joStlJbCd, String bsaQty, String bsaSltPrc, String loclCurrCd, String adjBsaQtyLoclAmt, String adjBsaSltPrcLoclAmt, String stlLoclAmt, String stlUsdAmt, String iocCd, String scontiCd, String fnlOwnBsaQty, String fnlBsaWgt, String usdSltBsaQty, String usdSltWgt, String bsaPerWgt, String fmPortCd, String toPortCd, String rfScgStlTpCd, String rfScgPrc, String stlRmk, String cmbCfmFlg, String stlCmbSeq, String stlTjNo, String stlAdjFlg, String preAcctYrmon, String preStlVvdSeq, String preStlSeq, String stlLstFlg, String creDt, String creUsrId, String updDt, String updUsrId, String ucBssPortCd, String ucBssPortEtdDt, String vvd, String joStlItmCdNm, String rVvd, String rBsaQty, String rBsaSltPrc, String rStlLoclAmt, String eVvd, String eBsaQty, String eBsaSltPrc, String eStlLoclAmt, String joStlJbCdNm, String ofcCd) {
		this.vslCd = vslCd;
		this.stlAdjFlg = stlAdjFlg;
		this.etaDt = etaDt;
		this.fmPortCd = fmPortCd;
		this.preAcctYrmon = preAcctYrmon;
		this.stlUsdAmt = stlUsdAmt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.usdSltWgt = usdSltWgt;
		this.usdSltBsaQty = usdSltBsaQty;
		this.stlBzcPortCd = stlBzcPortCd;
		this.stlLstFlg = stlLstFlg;
		this.ucBssPortEtdDt = ucBssPortEtdDt;
		this.rfScgStlTpCd = rfScgStlTpCd;
		this.updUsrId = updUsrId;
		this.eBsaSltPrc = eBsaSltPrc;
		this.preStlVvdSeq = preStlVvdSeq;
		this.adjBsaSltPrcLoclAmt = adjBsaSltPrcLoclAmt;
		this.loclCurrCd = loclCurrCd;
		this.fnlOwnBsaQty = fnlOwnBsaQty;
		this.skdVoyNo = skdVoyNo;
		this.vvd = vvd;
		this.acctYrmon = acctYrmon;
		this.creUsrId = creUsrId;
		this.bsaSltPrc = bsaSltPrc;
		this.rfScgPrc = rfScgPrc;
		this.joStlJbCdNm = joStlJbCdNm;
		this.toPortCd = toPortCd;
		this.joStlJbCd = joStlJbCd;
		this.stlCmbSeq = stlCmbSeq;
		this.rBsaSltPrc = rBsaSltPrc;
		this.bsaQty = bsaQty;
		this.creDt = creDt;
		this.rVvd = rVvd;
		this.stlTjNo = stlTjNo;
		this.joStlItmCdNm = joStlItmCdNm;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.ucBssPortCd = ucBssPortCd;
		this.stlLoclAmt = stlLoclAmt;
		this.joMnuNm = joMnuNm;
		this.rStlLoclAmt = rStlLoclAmt;
		this.cmbCfmFlg = cmbCfmFlg;
		this.eBsaQty = eBsaQty;
		this.stlVvdSeq = stlVvdSeq;
		this.bsaPerWgt = bsaPerWgt;
		this.stlRmk = stlRmk;
		this.stlSeq = stlSeq;
		this.iocCd = iocCd;
		this.updDt = updDt;
		this.preStlSeq = preStlSeq;
		this.joCrrCd = joCrrCd;
		this.rBsaQty = rBsaQty;
		this.skdDirCd = skdDirCd;
		this.ofcCd = ofcCd;
		this.fnlBsaWgt = fnlBsaWgt;
		this.eStlLoclAmt = eStlLoclAmt;
		this.adjBsaQtyLoclAmt = adjBsaQtyLoclAmt;
		this.reDivrCd = reDivrCd;
		this.eVvd = eVvd;
		this.scontiCd = scontiCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("stl_adj_flg", getStlAdjFlg());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("pre_acct_yrmon", getPreAcctYrmon());
		this.hashColumns.put("stl_usd_amt", getStlUsdAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usd_slt_wgt", getUsdSltWgt());
		this.hashColumns.put("usd_slt_bsa_qty", getUsdSltBsaQty());
		this.hashColumns.put("stl_bzc_port_cd", getStlBzcPortCd());
		this.hashColumns.put("stl_lst_flg", getStlLstFlg());
		this.hashColumns.put("uc_bss_port_etd_dt", getUcBssPortEtdDt());
		this.hashColumns.put("rf_scg_stl_tp_cd", getRfScgStlTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("e_bsa_slt_prc", getEBsaSltPrc());
		this.hashColumns.put("pre_stl_vvd_seq", getPreStlVvdSeq());
		this.hashColumns.put("adj_bsa_slt_prc_locl_amt", getAdjBsaSltPrcLoclAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("fnl_own_bsa_qty", getFnlOwnBsaQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("rf_scg_prc", getRfScgPrc());
		this.hashColumns.put("jo_stl_jb_cd_nm", getJoStlJbCdNm());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("r_bsa_slt_prc", getRBsaSltPrc());
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("r_vvd", getRVvd());
		this.hashColumns.put("stl_tj_no", getStlTjNo());
		this.hashColumns.put("jo_stl_itm_cd_nm", getJoStlItmCdNm());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uc_bss_port_cd", getUcBssPortCd());
		this.hashColumns.put("stl_locl_amt", getStlLoclAmt());
		this.hashColumns.put("jo_mnu_nm", getJoMnuNm());
		this.hashColumns.put("r_stl_locl_amt", getRStlLoclAmt());
		this.hashColumns.put("cmb_cfm_flg", getCmbCfmFlg());
		this.hashColumns.put("e_bsa_qty", getEBsaQty());
		this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
		this.hashColumns.put("bsa_per_wgt", getBsaPerWgt());
		this.hashColumns.put("stl_rmk", getStlRmk());
		this.hashColumns.put("stl_seq", getStlSeq());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pre_stl_seq", getPreStlSeq());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("r_bsa_qty", getRBsaQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fnl_bsa_wgt", getFnlBsaWgt());
		this.hashColumns.put("e_stl_locl_amt", getEStlLoclAmt());
		this.hashColumns.put("adj_bsa_qty_locl_amt", getAdjBsaQtyLoclAmt());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("e_vvd", getEVvd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stl_adj_flg", "stlAdjFlg");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("pre_acct_yrmon", "preAcctYrmon");
		this.hashFields.put("stl_usd_amt", "stlUsdAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usd_slt_wgt", "usdSltWgt");
		this.hashFields.put("usd_slt_bsa_qty", "usdSltBsaQty");
		this.hashFields.put("stl_bzc_port_cd", "stlBzcPortCd");
		this.hashFields.put("stl_lst_flg", "stlLstFlg");
		this.hashFields.put("uc_bss_port_etd_dt", "ucBssPortEtdDt");
		this.hashFields.put("rf_scg_stl_tp_cd", "rfScgStlTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("e_bsa_slt_prc", "eBsaSltPrc");
		this.hashFields.put("pre_stl_vvd_seq", "preStlVvdSeq");
		this.hashFields.put("adj_bsa_slt_prc_locl_amt", "adjBsaSltPrcLoclAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("fnl_own_bsa_qty", "fnlOwnBsaQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("rf_scg_prc", "rfScgPrc");
		this.hashFields.put("jo_stl_jb_cd_nm", "joStlJbCdNm");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("r_bsa_slt_prc", "rBsaSltPrc");
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("r_vvd", "rVvd");
		this.hashFields.put("stl_tj_no", "stlTjNo");
		this.hashFields.put("jo_stl_itm_cd_nm", "joStlItmCdNm");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uc_bss_port_cd", "ucBssPortCd");
		this.hashFields.put("stl_locl_amt", "stlLoclAmt");
		this.hashFields.put("jo_mnu_nm", "joMnuNm");
		this.hashFields.put("r_stl_locl_amt", "rStlLoclAmt");
		this.hashFields.put("cmb_cfm_flg", "cmbCfmFlg");
		this.hashFields.put("e_bsa_qty", "eBsaQty");
		this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
		this.hashFields.put("bsa_per_wgt", "bsaPerWgt");
		this.hashFields.put("stl_rmk", "stlRmk");
		this.hashFields.put("stl_seq", "stlSeq");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pre_stl_seq", "preStlSeq");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("r_bsa_qty", "rBsaQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fnl_bsa_wgt", "fnlBsaWgt");
		this.hashFields.put("e_stl_locl_amt", "eStlLoclAmt");
		this.hashFields.put("adj_bsa_qty_locl_amt", "adjBsaQtyLoclAmt");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("e_vvd", "eVvd");
		this.hashFields.put("sconti_cd", "scontiCd");
		return this.hashFields;
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
	 * @return stlAdjFlg
	 */
	public String getStlAdjFlg() {
		return this.stlAdjFlg;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getFmPortCd() {
		return this.fmPortCd;
	}
	
	/**
	 * Column Info
	 * @return preAcctYrmon
	 */
	public String getPreAcctYrmon() {
		return this.preAcctYrmon;
	}
	
	/**
	 * Column Info
	 * @return stlUsdAmt
	 */
	public String getStlUsdAmt() {
		return this.stlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return usdSltWgt
	 */
	public String getUsdSltWgt() {
		return this.usdSltWgt;
	}
	
	/**
	 * Column Info
	 * @return usdSltBsaQty
	 */
	public String getUsdSltBsaQty() {
		return this.usdSltBsaQty;
	}
	
	/**
	 * Column Info
	 * @return stlBzcPortCd
	 */
	public String getStlBzcPortCd() {
		return this.stlBzcPortCd;
	}
	
	/**
	 * Column Info
	 * @return stlLstFlg
	 */
	public String getStlLstFlg() {
		return this.stlLstFlg;
	}
	
	/**
	 * Column Info
	 * @return ucBssPortEtdDt
	 */
	public String getUcBssPortEtdDt() {
		return this.ucBssPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return rfScgStlTpCd
	 */
	public String getRfScgStlTpCd() {
		return this.rfScgStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return eBsaSltPrc
	 */
	public String getEBsaSltPrc() {
		return this.eBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return preStlVvdSeq
	 */
	public String getPreStlVvdSeq() {
		return this.preStlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return adjBsaSltPrcLoclAmt
	 */
	public String getAdjBsaSltPrcLoclAmt() {
		return this.adjBsaSltPrcLoclAmt;
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
	 * @return fnlOwnBsaQty
	 */
	public String getFnlOwnBsaQty() {
		return this.fnlOwnBsaQty;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return rfScgPrc
	 */
	public String getRfScgPrc() {
		return this.rfScgPrc;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCdNm
	 */
	public String getJoStlJbCdNm() {
		return this.joStlJbCdNm;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return rBsaSltPrc
	 */
	public String getRBsaSltPrc() {
		return this.rBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
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
	 * @return rVvd
	 */
	public String getRVvd() {
		return this.rVvd;
	}
	
	/**
	 * Column Info
	 * @return stlTjNo
	 */
	public String getStlTjNo() {
		return this.stlTjNo;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCdNm
	 */
	public String getJoStlItmCdNm() {
		return this.joStlItmCdNm;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return ucBssPortCd
	 */
	public String getUcBssPortCd() {
		return this.ucBssPortCd;
	}
	
	/**
	 * Column Info
	 * @return stlLoclAmt
	 */
	public String getStlLoclAmt() {
		return this.stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return joMnuNm
	 */
	public String getJoMnuNm() {
		return this.joMnuNm;
	}
	
	/**
	 * Column Info
	 * @return rStlLoclAmt
	 */
	public String getRStlLoclAmt() {
		return this.rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return cmbCfmFlg
	 */
	public String getCmbCfmFlg() {
		return this.cmbCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return eBsaQty
	 */
	public String getEBsaQty() {
		return this.eBsaQty;
	}
	
	/**
	 * Column Info
	 * @return stlVvdSeq
	 */
	public String getStlVvdSeq() {
		return this.stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return bsaPerWgt
	 */
	public String getBsaPerWgt() {
		return this.bsaPerWgt;
	}
	
	/**
	 * Column Info
	 * @return stlRmk
	 */
	public String getStlRmk() {
		return this.stlRmk;
	}
	
	/**
	 * Column Info
	 * @return stlSeq
	 */
	public String getStlSeq() {
		return this.stlSeq;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return preStlSeq
	 */
	public String getPreStlSeq() {
		return this.preStlSeq;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rBsaQty
	 */
	public String getRBsaQty() {
		return this.rBsaQty;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaWgt
	 */
	public String getFnlBsaWgt() {
		return this.fnlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @return eStlLoclAmt
	 */
	public String getEStlLoclAmt() {
		return this.eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return adjBsaQtyLoclAmt
	 */
	public String getAdjBsaQtyLoclAmt() {
		return this.adjBsaQtyLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return eVvd
	 */
	public String getEVvd() {
		return this.eVvd;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
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
	 * @param stlAdjFlg
	 */
	public void setStlAdjFlg(String stlAdjFlg) {
		this.stlAdjFlg = stlAdjFlg;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setFmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
	}
	
	/**
	 * Column Info
	 * @param preAcctYrmon
	 */
	public void setPreAcctYrmon(String preAcctYrmon) {
		this.preAcctYrmon = preAcctYrmon;
	}
	
	/**
	 * Column Info
	 * @param stlUsdAmt
	 */
	public void setStlUsdAmt(String stlUsdAmt) {
		this.stlUsdAmt = stlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * @param usdSltWgt
	 */
	public void setUsdSltWgt(String usdSltWgt) {
		this.usdSltWgt = usdSltWgt;
	}
	
	/**
	 * Column Info
	 * @param usdSltBsaQty
	 */
	public void setUsdSltBsaQty(String usdSltBsaQty) {
		this.usdSltBsaQty = usdSltBsaQty;
	}
	
	/**
	 * Column Info
	 * @param stlBzcPortCd
	 */
	public void setStlBzcPortCd(String stlBzcPortCd) {
		this.stlBzcPortCd = stlBzcPortCd;
	}
	
	/**
	 * Column Info
	 * @param stlLstFlg
	 */
	public void setStlLstFlg(String stlLstFlg) {
		this.stlLstFlg = stlLstFlg;
	}
	
	/**
	 * Column Info
	 * @param ucBssPortEtdDt
	 */
	public void setUcBssPortEtdDt(String ucBssPortEtdDt) {
		this.ucBssPortEtdDt = ucBssPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param rfScgStlTpCd
	 */
	public void setRfScgStlTpCd(String rfScgStlTpCd) {
		this.rfScgStlTpCd = rfScgStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param eBsaSltPrc
	 */
	public void setEBsaSltPrc(String eBsaSltPrc) {
		this.eBsaSltPrc = eBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param preStlVvdSeq
	 */
	public void setPreStlVvdSeq(String preStlVvdSeq) {
		this.preStlVvdSeq = preStlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param adjBsaSltPrcLoclAmt
	 */
	public void setAdjBsaSltPrcLoclAmt(String adjBsaSltPrcLoclAmt) {
		this.adjBsaSltPrcLoclAmt = adjBsaSltPrcLoclAmt;
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
	 * @param fnlOwnBsaQty
	 */
	public void setFnlOwnBsaQty(String fnlOwnBsaQty) {
		this.fnlOwnBsaQty = fnlOwnBsaQty;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param rfScgPrc
	 */
	public void setRfScgPrc(String rfScgPrc) {
		this.rfScgPrc = rfScgPrc;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCdNm
	 */
	public void setJoStlJbCdNm(String joStlJbCdNm) {
		this.joStlJbCdNm = joStlJbCdNm;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd) {
		this.joStlJbCd = joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param rBsaSltPrc
	 */
	public void setRBsaSltPrc(String rBsaSltPrc) {
		this.rBsaSltPrc = rBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
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
	 * @param rVvd
	 */
	public void setRVvd(String rVvd) {
		this.rVvd = rVvd;
	}
	
	/**
	 * Column Info
	 * @param stlTjNo
	 */
	public void setStlTjNo(String stlTjNo) {
		this.stlTjNo = stlTjNo;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCdNm
	 */
	public void setJoStlItmCdNm(String joStlItmCdNm) {
		this.joStlItmCdNm = joStlItmCdNm;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param ucBssPortCd
	 */
	public void setUcBssPortCd(String ucBssPortCd) {
		this.ucBssPortCd = ucBssPortCd;
	}
	
	/**
	 * Column Info
	 * @param stlLoclAmt
	 */
	public void setStlLoclAmt(String stlLoclAmt) {
		this.stlLoclAmt = stlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param joMnuNm
	 */
	public void setJoMnuNm(String joMnuNm) {
		this.joMnuNm = joMnuNm;
	}
	
	/**
	 * Column Info
	 * @param rStlLoclAmt
	 */
	public void setRStlLoclAmt(String rStlLoclAmt) {
		this.rStlLoclAmt = rStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param cmbCfmFlg
	 */
	public void setCmbCfmFlg(String cmbCfmFlg) {
		this.cmbCfmFlg = cmbCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param eBsaQty
	 */
	public void setEBsaQty(String eBsaQty) {
		this.eBsaQty = eBsaQty;
	}
	
	/**
	 * Column Info
	 * @param stlVvdSeq
	 */
	public void setStlVvdSeq(String stlVvdSeq) {
		this.stlVvdSeq = stlVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param bsaPerWgt
	 */
	public void setBsaPerWgt(String bsaPerWgt) {
		this.bsaPerWgt = bsaPerWgt;
	}
	
	/**
	 * Column Info
	 * @param stlRmk
	 */
	public void setStlRmk(String stlRmk) {
		this.stlRmk = stlRmk;
	}
	
	/**
	 * Column Info
	 * @param stlSeq
	 */
	public void setStlSeq(String stlSeq) {
		this.stlSeq = stlSeq;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param preStlSeq
	 */
	public void setPreStlSeq(String preStlSeq) {
		this.preStlSeq = preStlSeq;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rBsaQty
	 */
	public void setRBsaQty(String rBsaQty) {
		this.rBsaQty = rBsaQty;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaWgt
	 */
	public void setFnlBsaWgt(String fnlBsaWgt) {
		this.fnlBsaWgt = fnlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @param eStlLoclAmt
	 */
	public void setEStlLoclAmt(String eStlLoclAmt) {
		this.eStlLoclAmt = eStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param adjBsaQtyLoclAmt
	 */
	public void setAdjBsaQtyLoclAmt(String adjBsaQtyLoclAmt) {
		this.adjBsaQtyLoclAmt = adjBsaQtyLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param eVvd
	 */
	public void setEVvd(String eVvd) {
		this.eVvd = eVvd;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setStlAdjFlg(JSPUtil.getParameter(request, "stl_adj_flg", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setFmPortCd(JSPUtil.getParameter(request, "fm_port_cd", ""));
		setPreAcctYrmon(JSPUtil.getParameter(request, "pre_acct_yrmon", ""));
		setStlUsdAmt(JSPUtil.getParameter(request, "stl_usd_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUsdSltWgt(JSPUtil.getParameter(request, "usd_slt_wgt", ""));
		setUsdSltBsaQty(JSPUtil.getParameter(request, "usd_slt_bsa_qty", ""));
		setStlBzcPortCd(JSPUtil.getParameter(request, "stl_bzc_port_cd", ""));
		setStlLstFlg(JSPUtil.getParameter(request, "stl_lst_flg", ""));
		setUcBssPortEtdDt(JSPUtil.getParameter(request, "uc_bss_port_etd_dt", ""));
		setRfScgStlTpCd(JSPUtil.getParameter(request, "rf_scg_stl_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEBsaSltPrc(JSPUtil.getParameter(request, "e_bsa_slt_prc", ""));
		setPreStlVvdSeq(JSPUtil.getParameter(request, "pre_stl_vvd_seq", ""));
		setAdjBsaSltPrcLoclAmt(JSPUtil.getParameter(request, "adj_bsa_slt_prc_locl_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setFnlOwnBsaQty(JSPUtil.getParameter(request, "fnl_own_bsa_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, "bsa_slt_prc", ""));
		setRfScgPrc(JSPUtil.getParameter(request, "rf_scg_prc", ""));
		setJoStlJbCdNm(JSPUtil.getParameter(request, "jo_stl_jb_cd_nm", ""));
		setToPortCd(JSPUtil.getParameter(request, "to_port_cd", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, "jo_stl_jb_cd", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setRBsaSltPrc(JSPUtil.getParameter(request, "r_bsa_slt_prc", ""));
		setBsaQty(JSPUtil.getParameter(request, "bsa_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRVvd(JSPUtil.getParameter(request, "r_vvd", ""));
		setStlTjNo(JSPUtil.getParameter(request, "stl_tj_no", ""));
		setJoStlItmCdNm(JSPUtil.getParameter(request, "jo_stl_itm_cd_nm", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUcBssPortCd(JSPUtil.getParameter(request, "uc_bss_port_cd", ""));
		setStlLoclAmt(JSPUtil.getParameter(request, "stl_locl_amt", ""));
		setJoMnuNm(JSPUtil.getParameter(request, "jo_mnu_nm", ""));
		setRStlLoclAmt(JSPUtil.getParameter(request, "r_stl_locl_amt", ""));
		setCmbCfmFlg(JSPUtil.getParameter(request, "cmb_cfm_flg", ""));
		setEBsaQty(JSPUtil.getParameter(request, "e_bsa_qty", ""));
		setStlVvdSeq(JSPUtil.getParameter(request, "stl_vvd_seq", ""));
		setBsaPerWgt(JSPUtil.getParameter(request, "bsa_per_wgt", ""));
		setStlRmk(JSPUtil.getParameter(request, "stl_rmk", ""));
		setStlSeq(JSPUtil.getParameter(request, "stl_seq", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPreStlSeq(JSPUtil.getParameter(request, "pre_stl_seq", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setRBsaQty(JSPUtil.getParameter(request, "r_bsa_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setFnlBsaWgt(JSPUtil.getParameter(request, "fnl_bsa_wgt", ""));
		setEStlLoclAmt(JSPUtil.getParameter(request, "e_stl_locl_amt", ""));
		setAdjBsaQtyLoclAmt(JSPUtil.getParameter(request, "adj_bsa_qty_locl_amt", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setEVvd(JSPUtil.getParameter(request, "e_vvd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementVO[]
	 */
	public SettlementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SettlementVO[]
	 */
	public SettlementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SettlementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] stlAdjFlg = (JSPUtil.getParameter(request, prefix	+ "stl_adj_flg", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] preAcctYrmon = (JSPUtil.getParameter(request, prefix	+ "pre_acct_yrmon", length));
			String[] stlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "stl_usd_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usdSltWgt = (JSPUtil.getParameter(request, prefix	+ "usd_slt_wgt", length));
			String[] usdSltBsaQty = (JSPUtil.getParameter(request, prefix	+ "usd_slt_bsa_qty", length));
			String[] stlBzcPortCd = (JSPUtil.getParameter(request, prefix	+ "stl_bzc_port_cd", length));
			String[] stlLstFlg = (JSPUtil.getParameter(request, prefix	+ "stl_lst_flg", length));
			String[] ucBssPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "uc_bss_port_etd_dt", length));
			String[] rfScgStlTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_scg_stl_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "e_bsa_slt_prc", length));
			String[] preStlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "pre_stl_vvd_seq", length));
			String[] adjBsaSltPrcLoclAmt = (JSPUtil.getParameter(request, prefix	+ "adj_bsa_slt_prc_locl_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] fnlOwnBsaQty = (JSPUtil.getParameter(request, prefix	+ "fnl_own_bsa_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] rfScgPrc = (JSPUtil.getParameter(request, prefix	+ "rf_scg_prc", length));
			String[] joStlJbCdNm = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd_nm", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] rBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "r_bsa_slt_prc", length));
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rVvd = (JSPUtil.getParameter(request, prefix	+ "r_vvd", length));
			String[] stlTjNo = (JSPUtil.getParameter(request, prefix	+ "stl_tj_no", length));
			String[] joStlItmCdNm = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd_nm", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ucBssPortCd = (JSPUtil.getParameter(request, prefix	+ "uc_bss_port_cd", length));
			String[] stlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "stl_locl_amt", length));
			String[] joMnuNm = (JSPUtil.getParameter(request, prefix	+ "jo_mnu_nm", length));
			String[] rStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "r_stl_locl_amt", length));
			String[] cmbCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cmb_cfm_flg", length));
			String[] eBsaQty = (JSPUtil.getParameter(request, prefix	+ "e_bsa_qty", length));
			String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_seq", length));
			String[] bsaPerWgt = (JSPUtil.getParameter(request, prefix	+ "bsa_per_wgt", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			String[] stlSeq = (JSPUtil.getParameter(request, prefix	+ "stl_seq", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] preStlSeq = (JSPUtil.getParameter(request, prefix	+ "pre_stl_seq", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rBsaQty = (JSPUtil.getParameter(request, prefix	+ "r_bsa_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fnlBsaWgt = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_wgt", length));
			String[] eStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "e_stl_locl_amt", length));
			String[] adjBsaQtyLoclAmt = (JSPUtil.getParameter(request, prefix	+ "adj_bsa_qty_locl_amt", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] eVvd = (JSPUtil.getParameter(request, prefix	+ "e_vvd", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SettlementVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (stlAdjFlg[i] != null)
					model.setStlAdjFlg(stlAdjFlg[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (fmPortCd[i] != null)
					model.setFmPortCd(fmPortCd[i]);
				if (preAcctYrmon[i] != null)
					model.setPreAcctYrmon(preAcctYrmon[i]);
				if (stlUsdAmt[i] != null)
					model.setStlUsdAmt(stlUsdAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usdSltWgt[i] != null)
					model.setUsdSltWgt(usdSltWgt[i]);
				if (usdSltBsaQty[i] != null)
					model.setUsdSltBsaQty(usdSltBsaQty[i]);
				if (stlBzcPortCd[i] != null)
					model.setStlBzcPortCd(stlBzcPortCd[i]);
				if (stlLstFlg[i] != null)
					model.setStlLstFlg(stlLstFlg[i]);
				if (ucBssPortEtdDt[i] != null)
					model.setUcBssPortEtdDt(ucBssPortEtdDt[i]);
				if (rfScgStlTpCd[i] != null)
					model.setRfScgStlTpCd(rfScgStlTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eBsaSltPrc[i] != null)
					model.setEBsaSltPrc(eBsaSltPrc[i]);
				if (preStlVvdSeq[i] != null)
					model.setPreStlVvdSeq(preStlVvdSeq[i]);
				if (adjBsaSltPrcLoclAmt[i] != null)
					model.setAdjBsaSltPrcLoclAmt(adjBsaSltPrcLoclAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (fnlOwnBsaQty[i] != null)
					model.setFnlOwnBsaQty(fnlOwnBsaQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (rfScgPrc[i] != null)
					model.setRfScgPrc(rfScgPrc[i]);
				if (joStlJbCdNm[i] != null)
					model.setJoStlJbCdNm(joStlJbCdNm[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (rBsaSltPrc[i] != null)
					model.setRBsaSltPrc(rBsaSltPrc[i]);
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rVvd[i] != null)
					model.setRVvd(rVvd[i]);
				if (stlTjNo[i] != null)
					model.setStlTjNo(stlTjNo[i]);
				if (joStlItmCdNm[i] != null)
					model.setJoStlItmCdNm(joStlItmCdNm[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ucBssPortCd[i] != null)
					model.setUcBssPortCd(ucBssPortCd[i]);
				if (stlLoclAmt[i] != null)
					model.setStlLoclAmt(stlLoclAmt[i]);
				if (joMnuNm[i] != null)
					model.setJoMnuNm(joMnuNm[i]);
				if (rStlLoclAmt[i] != null)
					model.setRStlLoclAmt(rStlLoclAmt[i]);
				if (cmbCfmFlg[i] != null)
					model.setCmbCfmFlg(cmbCfmFlg[i]);
				if (eBsaQty[i] != null)
					model.setEBsaQty(eBsaQty[i]);
				if (stlVvdSeq[i] != null)
					model.setStlVvdSeq(stlVvdSeq[i]);
				if (bsaPerWgt[i] != null)
					model.setBsaPerWgt(bsaPerWgt[i]);
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				if (stlSeq[i] != null)
					model.setStlSeq(stlSeq[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (preStlSeq[i] != null)
					model.setPreStlSeq(preStlSeq[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rBsaQty[i] != null)
					model.setRBsaQty(rBsaQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fnlBsaWgt[i] != null)
					model.setFnlBsaWgt(fnlBsaWgt[i]);
				if (eStlLoclAmt[i] != null)
					model.setEStlLoclAmt(eStlLoclAmt[i]);
				if (adjBsaQtyLoclAmt[i] != null)
					model.setAdjBsaQtyLoclAmt(adjBsaQtyLoclAmt[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (eVvd[i] != null)
					model.setEVvd(eVvd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSettlementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SettlementVO[]
	 */
	public SettlementVO[] getSettlementVOs(){
		SettlementVO[] vos = (SettlementVO[])models.toArray(new SettlementVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAdjFlg = this.stlAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAcctYrmon = this.preAcctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlUsdAmt = this.stlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSltWgt = this.usdSltWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSltBsaQty = this.usdSltBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlBzcPortCd = this.stlBzcPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLstFlg = this.stlLstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucBssPortEtdDt = this.ucBssPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgStlTpCd = this.rfScgStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBsaSltPrc = this.eBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStlVvdSeq = this.preStlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjBsaSltPrcLoclAmt = this.adjBsaSltPrcLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlOwnBsaQty = this.fnlOwnBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfScgPrc = this.rfScgPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCdNm = this.joStlJbCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBsaSltPrc = this.rBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rVvd = this.rVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlTjNo = this.stlTjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCdNm = this.joStlItmCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucBssPortCd = this.ucBssPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlLoclAmt = this.stlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joMnuNm = this.joMnuNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStlLoclAmt = this.rStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbCfmFlg = this.cmbCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBsaQty = this.eBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdSeq = this.stlVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaPerWgt = this.bsaPerWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlSeq = this.stlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStlSeq = this.preStlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBsaQty = this.rBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaWgt = this.fnlBsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlLoclAmt = this.eStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjBsaQtyLoclAmt = this.adjBsaQtyLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eVvd = this.eVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
