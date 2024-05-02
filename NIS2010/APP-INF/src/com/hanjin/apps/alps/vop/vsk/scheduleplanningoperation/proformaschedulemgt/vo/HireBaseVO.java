/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HireBaseVO.java
*@FileTitle : HireBaseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.21 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

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
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HireBaseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HireBaseVO> models = new ArrayList<HireBaseVO>();
	
	/* Column Info */
	private String mtxFoilPortTtlQty = null;
	/* Column Info */
	private String mtxFoilSeaTtlQty = null;
	/* Column Info */
	private String mtxFoilMnvrTtlQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslOwnrFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String sltPrcTtlAmt = null;
	/* Column Info */
	private String vslCsl1 = null;
	/* Column Info */
	private String sltPrcOneWyAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String vslClssCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String mtxFoilMnvrDyQty = null;
	/* Column Info */
	private String mtxFoilPortDyQty = null;
	/* Column Info */
	private String chrgHirTtlAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chrgHirTeuAmt = null;
	/* Column Info */
	private String ttlAvg = null;
	/* Column Info */
	private String ownrHirTtlAmt = null;
	/* Column Info */
	private String mtxFoilTtlQty = null;
	/* Column Info */
	private String ownrHirTeuAmt = null;
	/* Column Info */
	private String sltPrcWrkYr = null;
	/* Column Info */
	private String peAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bnkExpnAmt = null;
	/* Column Info */
	private String vslCsl2 = null;
	/* Column Info */
	private String vslCsl3 = null;
	/* Column Info */
	private String mtxFoilSeaDyQty = null;
	/* Column Info */
	private String sltPrcRndAmt = null;
	/* Column Info */
	private String ttlMfo = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String leftHeader = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HireBaseVO() {}

	public HireBaseVO(String ibflag, String pagerows, String vslSlanCd, String pfSvcTpCd, String sltPrcWrkYr, String bseQtrCd, String vslClssCd, String peAmt, String mtxFoilSeaDyQty, String mtxFoilSeaTtlQty, String mtxFoilMnvrDyQty, String mtxFoilMnvrTtlQty, String mtxFoilPortDyQty, String mtxFoilPortTtlQty, String mtxFoilTtlQty, String bnkExpnAmt, String vslOwnrFlg, String ownrHirTeuAmt, String ownrHirTtlAmt, String chrgHirTeuAmt, String chrgHirTtlAmt, String sltPrcTtlAmt, String sltPrcRndAmt, String sltPrcOneWyAmt, String creUsrId, String creDt, String updUsrId, String updDt, String ttlMfo, String vslCsl1, String vslCsl2, String vslCsl3, String ttlAvg, String flag, String leftHeader) {
		this.mtxFoilPortTtlQty = mtxFoilPortTtlQty;
		this.mtxFoilSeaTtlQty = mtxFoilSeaTtlQty;
		this.mtxFoilMnvrTtlQty = mtxFoilMnvrTtlQty;
		this.creDt = creDt;
		this.vslOwnrFlg = vslOwnrFlg;
		this.vslSlanCd = vslSlanCd;
		this.sltPrcTtlAmt = sltPrcTtlAmt;
		this.vslCsl1 = vslCsl1;
		this.sltPrcOneWyAmt = sltPrcOneWyAmt;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.vslClssCd = vslClssCd;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.mtxFoilMnvrDyQty = mtxFoilMnvrDyQty;
		this.mtxFoilPortDyQty = mtxFoilPortDyQty;
		this.chrgHirTtlAmt = chrgHirTtlAmt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.chrgHirTeuAmt = chrgHirTeuAmt;
		this.ttlAvg = ttlAvg;
		this.ownrHirTtlAmt = ownrHirTtlAmt;
		this.mtxFoilTtlQty = mtxFoilTtlQty;
		this.ownrHirTeuAmt = ownrHirTeuAmt;
		this.sltPrcWrkYr = sltPrcWrkYr;
		this.peAmt = peAmt;
		this.creUsrId = creUsrId;
		this.bnkExpnAmt = bnkExpnAmt;
		this.vslCsl2 = vslCsl2;
		this.vslCsl3 = vslCsl3;
		this.mtxFoilSeaDyQty = mtxFoilSeaDyQty;
		this.sltPrcRndAmt = sltPrcRndAmt;
		this.ttlMfo = ttlMfo;
		this.flag = flag;
		this.leftHeader = leftHeader;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mtx_foil_port_ttl_qty", getMtxFoilPortTtlQty());
		this.hashColumns.put("mtx_foil_sea_ttl_qty", getMtxFoilSeaTtlQty());
		this.hashColumns.put("mtx_foil_mnvr_ttl_qty", getMtxFoilMnvrTtlQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_ownr_flg", getVslOwnrFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("slt_prc_ttl_amt", getSltPrcTtlAmt());
		this.hashColumns.put("vsl_csl1", getVslCsl1());
		this.hashColumns.put("slt_prc_one_wy_amt", getSltPrcOneWyAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("mtx_foil_mnvr_dy_qty", getMtxFoilMnvrDyQty());
		this.hashColumns.put("mtx_foil_port_dy_qty", getMtxFoilPortDyQty());
		this.hashColumns.put("chrg_hir_ttl_amt", getChrgHirTtlAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chrg_hir_teu_amt", getChrgHirTeuAmt());
		this.hashColumns.put("ttl_avg", getTtlAvg());
		this.hashColumns.put("ownr_hir_ttl_amt", getOwnrHirTtlAmt());
		this.hashColumns.put("mtx_foil_ttl_qty", getMtxFoilTtlQty());
		this.hashColumns.put("ownr_hir_teu_amt", getOwnrHirTeuAmt());
		this.hashColumns.put("slt_prc_wrk_yr", getSltPrcWrkYr());
		this.hashColumns.put("pe_amt", getPeAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bnk_expn_amt", getBnkExpnAmt());
		this.hashColumns.put("vsl_csl2", getVslCsl2());
		this.hashColumns.put("vsl_csl3", getVslCsl3());
		this.hashColumns.put("mtx_foil_sea_dy_qty", getMtxFoilSeaDyQty());
		this.hashColumns.put("slt_prc_rnd_amt", getSltPrcRndAmt());
		this.hashColumns.put("ttl_mfo", getTtlMfo());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("left_header", getLeftHeader());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mtx_foil_port_ttl_qty", "mtxFoilPortTtlQty");
		this.hashFields.put("mtx_foil_sea_ttl_qty", "mtxFoilSeaTtlQty");
		this.hashFields.put("mtx_foil_mnvr_ttl_qty", "mtxFoilMnvrTtlQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_ownr_flg", "vslOwnrFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("slt_prc_ttl_amt", "sltPrcTtlAmt");
		this.hashFields.put("vsl_csl1", "vslCsl1");
		this.hashFields.put("slt_prc_one_wy_amt", "sltPrcOneWyAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("mtx_foil_mnvr_dy_qty", "mtxFoilMnvrDyQty");
		this.hashFields.put("mtx_foil_port_dy_qty", "mtxFoilPortDyQty");
		this.hashFields.put("chrg_hir_ttl_amt", "chrgHirTtlAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chrg_hir_teu_amt", "chrgHirTeuAmt");
		this.hashFields.put("ttl_avg", "ttlAvg");
		this.hashFields.put("ownr_hir_ttl_amt", "ownrHirTtlAmt");
		this.hashFields.put("mtx_foil_ttl_qty", "mtxFoilTtlQty");
		this.hashFields.put("ownr_hir_teu_amt", "ownrHirTeuAmt");
		this.hashFields.put("slt_prc_wrk_yr", "sltPrcWrkYr");
		this.hashFields.put("pe_amt", "peAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bnk_expn_amt", "bnkExpnAmt");
		this.hashFields.put("vsl_csl2", "vslCsl2");
		this.hashFields.put("vsl_csl3", "vslCsl3");
		this.hashFields.put("mtx_foil_sea_dy_qty", "mtxFoilSeaDyQty");
		this.hashFields.put("slt_prc_rnd_amt", "sltPrcRndAmt");
		this.hashFields.put("ttl_mfo", "ttlMfo");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("left_header", "leftHeader");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilPortTtlQty
	 */
	public String getMtxFoilPortTtlQty() {
		return this.mtxFoilPortTtlQty;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilSeaTtlQty
	 */
	public String getMtxFoilSeaTtlQty() {
		return this.mtxFoilSeaTtlQty;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilMnvrTtlQty
	 */
	public String getMtxFoilMnvrTtlQty() {
		return this.mtxFoilMnvrTtlQty;
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
	 * @return vslOwnrFlg
	 */
	public String getVslOwnrFlg() {
		return this.vslOwnrFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return sltPrcTtlAmt
	 */
	public String getSltPrcTtlAmt() {
		return this.sltPrcTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return vslCsl1
	 */
	public String getVslCsl1() {
		return this.vslCsl1;
	}
	
	/**
	 * Column Info
	 * @return sltPrcOneWyAmt
	 */
	public String getSltPrcOneWyAmt() {
		return this.sltPrcOneWyAmt;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilMnvrDyQty
	 */
	public String getMtxFoilMnvrDyQty() {
		return this.mtxFoilMnvrDyQty;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilPortDyQty
	 */
	public String getMtxFoilPortDyQty() {
		return this.mtxFoilPortDyQty;
	}
	
	/**
	 * Column Info
	 * @return chrgHirTtlAmt
	 */
	public String getChrgHirTtlAmt() {
		return this.chrgHirTtlAmt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return chrgHirTeuAmt
	 */
	public String getChrgHirTeuAmt() {
		return this.chrgHirTeuAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAvg
	 */
	public String getTtlAvg() {
		return this.ttlAvg;
	}
	
	/**
	 * Column Info
	 * @return ownrHirTtlAmt
	 */
	public String getOwnrHirTtlAmt() {
		return this.ownrHirTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilTtlQty
	 */
	public String getMtxFoilTtlQty() {
		return this.mtxFoilTtlQty;
	}
	
	/**
	 * Column Info
	 * @return ownrHirTeuAmt
	 */
	public String getOwnrHirTeuAmt() {
		return this.ownrHirTeuAmt;
	}
	
	/**
	 * Column Info
	 * @return sltPrcWrkYr
	 */
	public String getSltPrcWrkYr() {
		return this.sltPrcWrkYr;
	}
	
	/**
	 * Column Info
	 * @return peAmt
	 */
	public String getPeAmt() {
		return this.peAmt;
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
	 * @return bnkExpnAmt
	 */
	public String getBnkExpnAmt() {
		return this.bnkExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return vslCsl2
	 */
	public String getVslCsl2() {
		return this.vslCsl2;
	}
	
	/**
	 * Column Info
	 * @return vslCls3
	 */
	public String getVslCsl3() {
		return this.vslCsl3;
	}
	
	/**
	 * Column Info
	 * @return mtxFoilSeaDyQty
	 */
	public String getMtxFoilSeaDyQty() {
		return this.mtxFoilSeaDyQty;
	}
	
	/**
	 * Column Info
	 * @return sltPrcRndAmt
	 */
	public String getSltPrcRndAmt() {
		return this.sltPrcRndAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlMfo
	 */
	public String getTtlMfo() {
		return this.ttlMfo;
	}
	
	/**
	 * Column Info
	 * @return ttlMfo
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return LeftHeader
	 */
	public String getLeftHeader() {
		return this.leftHeader;
	}
	

	/**
	 * Column Info
	 * @param mtxFoilPortTtlQty
	 */
	public void setMtxFoilPortTtlQty(String mtxFoilPortTtlQty) {
		this.mtxFoilPortTtlQty = mtxFoilPortTtlQty;
	}
	
	/**
	 * Column Info
	 * @param mtxFoilSeaTtlQty
	 */
	public void setMtxFoilSeaTtlQty(String mtxFoilSeaTtlQty) {
		this.mtxFoilSeaTtlQty = mtxFoilSeaTtlQty;
	}
	
	/**
	 * Column Info
	 * @param mtxFoilMnvrTtlQty
	 */
	public void setMtxFoilMnvrTtlQty(String mtxFoilMnvrTtlQty) {
		this.mtxFoilMnvrTtlQty = mtxFoilMnvrTtlQty;
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
	 * @param vslOwnrFlg
	 */
	public void setVslOwnrFlg(String vslOwnrFlg) {
		this.vslOwnrFlg = vslOwnrFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param sltPrcTtlAmt
	 */
	public void setSltPrcTtlAmt(String sltPrcTtlAmt) {
		this.sltPrcTtlAmt = sltPrcTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param vslCsl1
	 */
	public void setVslCsl1(String vslCsl1) {
		this.vslCsl1 = vslCsl1;
	}
	
	/**
	 * Column Info
	 * @param sltPrcOneWyAmt
	 */
	public void setSltPrcOneWyAmt(String sltPrcOneWyAmt) {
		this.sltPrcOneWyAmt = sltPrcOneWyAmt;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param mtxFoilMnvrDyQty
	 */
	public void setMtxFoilMnvrDyQty(String mtxFoilMnvrDyQty) {
		this.mtxFoilMnvrDyQty = mtxFoilMnvrDyQty;
	}
	
	/**
	 * Column Info
	 * @param mtxFoilPortDyQty
	 */
	public void setMtxFoilPortDyQty(String mtxFoilPortDyQty) {
		this.mtxFoilPortDyQty = mtxFoilPortDyQty;
	}
	
	/**
	 * Column Info
	 * @param chrgHirTtlAmt
	 */
	public void setChrgHirTtlAmt(String chrgHirTtlAmt) {
		this.chrgHirTtlAmt = chrgHirTtlAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param chrgHirTeuAmt
	 */
	public void setChrgHirTeuAmt(String chrgHirTeuAmt) {
		this.chrgHirTeuAmt = chrgHirTeuAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAvg
	 */
	public void setTtlAvg(String ttlAvg) {
		this.ttlAvg = ttlAvg;
	}
	
	/**
	 * Column Info
	 * @param ownrHirTtlAmt
	 */
	public void setOwnrHirTtlAmt(String ownrHirTtlAmt) {
		this.ownrHirTtlAmt = ownrHirTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param mtxFoilTtlQty
	 */
	public void setMtxFoilTtlQty(String mtxFoilTtlQty) {
		this.mtxFoilTtlQty = mtxFoilTtlQty;
	}
	
	/**
	 * Column Info
	 * @param ownrHirTeuAmt
	 */
	public void setOwnrHirTeuAmt(String ownrHirTeuAmt) {
		this.ownrHirTeuAmt = ownrHirTeuAmt;
	}
	
	/**
	 * Column Info
	 * @param sltPrcWrkYr
	 */
	public void setSltPrcWrkYr(String sltPrcWrkYr) {
		this.sltPrcWrkYr = sltPrcWrkYr;
	}
	
	/**
	 * Column Info
	 * @param peAmt
	 */
	public void setPeAmt(String peAmt) {
		this.peAmt = peAmt;
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
	 * @param bnkExpnAmt
	 */
	public void setBnkExpnAmt(String bnkExpnAmt) {
		this.bnkExpnAmt = bnkExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param vslCsl2
	 */
	public void setVslCsl2(String vslCsl2) {
		this.vslCsl2 = vslCsl2;
	}
	
	/**
	 * Column Info
	 * @param vslCsl3
	 */
	public void setVslCsl3(String vslCsl3) {
		this.vslCsl3 = vslCsl3;
	}
	
	/**
	 * Column Info
	 * @param mtxFoilSeaDyQty
	 */
	public void setMtxFoilSeaDyQty(String mtxFoilSeaDyQty) {
		this.mtxFoilSeaDyQty = mtxFoilSeaDyQty;
	}
	
	/**
	 * Column Info
	 * @param sltPrcRndAmt
	 */
	public void setSltPrcRndAmt(String sltPrcRndAmt) {
		this.sltPrcRndAmt = sltPrcRndAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlMfo
	 */
	public void setTtlMfo(String ttlMfo) {
		this.ttlMfo = ttlMfo;
	}
	
	/**
	 * Column Info
	 * @param ttlMfo
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param LeftHeader
	 */
	public void setLeftHeader(String leftHeader) {
		this.leftHeader = leftHeader;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMtxFoilPortTtlQty(JSPUtil.getParameter(request, "mtx_foil_port_ttl_qty", ""));
		setMtxFoilSeaTtlQty(JSPUtil.getParameter(request, "mtx_foil_sea_ttl_qty", ""));
		setMtxFoilMnvrTtlQty(JSPUtil.getParameter(request, "mtx_foil_mnvr_ttl_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVslOwnrFlg(JSPUtil.getParameter(request, "vsl_ownr_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setSltPrcTtlAmt(JSPUtil.getParameter(request, "slt_prc_ttl_amt", ""));
		setVslCsl1(JSPUtil.getParameter(request, "vsl_csl1", ""));
		setSltPrcOneWyAmt(JSPUtil.getParameter(request, "slt_prc_one_wy_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setVslClssCd(JSPUtil.getParameter(request, "vsl_clss_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setMtxFoilMnvrDyQty(JSPUtil.getParameter(request, "mtx_foil_mnvr_dy_qty", ""));
		setMtxFoilPortDyQty(JSPUtil.getParameter(request, "mtx_foil_port_dy_qty", ""));
		setChrgHirTtlAmt(JSPUtil.getParameter(request, "chrg_hir_ttl_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setChrgHirTeuAmt(JSPUtil.getParameter(request, "chrg_hir_teu_amt", ""));
		setTtlAvg(JSPUtil.getParameter(request, "ttl_avg", ""));
		setOwnrHirTtlAmt(JSPUtil.getParameter(request, "ownr_hir_ttl_amt", ""));
		setMtxFoilTtlQty(JSPUtil.getParameter(request, "mtx_foil_ttl_qty", ""));
		setOwnrHirTeuAmt(JSPUtil.getParameter(request, "ownr_hir_teu_amt", ""));
		setSltPrcWrkYr(JSPUtil.getParameter(request, "slt_prc_wrk_yr", ""));
		setPeAmt(JSPUtil.getParameter(request, "pe_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBnkExpnAmt(JSPUtil.getParameter(request, "bnk_expn_amt", ""));
		setVslCsl2(JSPUtil.getParameter(request, "vsl_csl2", ""));
		setVslCsl3(JSPUtil.getParameter(request, "vsl_csl3", ""));
		setMtxFoilSeaDyQty(JSPUtil.getParameter(request, "mtx_foil_sea_dy_qty", ""));
		setSltPrcRndAmt(JSPUtil.getParameter(request, "slt_prc_rnd_amt", ""));
		setTtlMfo(JSPUtil.getParameter(request, "ttl_mfo", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setLeftHeader(JSPUtil.getParameter(request, "left_header", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HireBaseVO[]
	 */
	public HireBaseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HireBaseVO[]
	 */
	public HireBaseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HireBaseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mtxFoilPortTtlQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_port_ttl_qty", length));
			String[] mtxFoilSeaTtlQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_sea_ttl_qty", length));
			String[] mtxFoilMnvrTtlQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_mnvr_ttl_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslOwnrFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_ownr_flg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] sltPrcTtlAmt = (JSPUtil.getParameter(request, prefix	+ "slt_prc_ttl_amt", length));
			String[] vslCsl1 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl1", length));
			String[] sltPrcOneWyAmt = (JSPUtil.getParameter(request, prefix	+ "slt_prc_one_wy_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] mtxFoilMnvrDyQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_mnvr_dy_qty", length));
			String[] mtxFoilPortDyQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_port_dy_qty", length));
			String[] chrgHirTtlAmt = (JSPUtil.getParameter(request, prefix	+ "chrg_hir_ttl_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chrgHirTeuAmt = (JSPUtil.getParameter(request, prefix	+ "chrg_hir_teu_amt", length));
			String[] ttlAvg = (JSPUtil.getParameter(request, prefix	+ "ttl_avg", length));
			String[] ownrHirTtlAmt = (JSPUtil.getParameter(request, prefix	+ "ownr_hir_ttl_amt", length));
			String[] mtxFoilTtlQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_ttl_qty", length));
			String[] ownrHirTeuAmt = (JSPUtil.getParameter(request, prefix	+ "ownr_hir_teu_amt", length));
			String[] sltPrcWrkYr = (JSPUtil.getParameter(request, prefix	+ "slt_prc_wrk_yr", length));
			String[] peAmt = (JSPUtil.getParameter(request, prefix	+ "pe_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bnkExpnAmt = (JSPUtil.getParameter(request, prefix	+ "bnk_expn_amt", length));
			String[] vslCsl2 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl2", length));
			String[] vslCsl3 = (JSPUtil.getParameter(request, prefix	+ "vsl_csl3", length));
			String[] mtxFoilSeaDyQty = (JSPUtil.getParameter(request, prefix	+ "mtx_foil_sea_dy_qty", length));
			String[] sltPrcRndAmt = (JSPUtil.getParameter(request, prefix	+ "slt_prc_rnd_amt", length));
			String[] ttlMfo = (JSPUtil.getParameter(request, prefix	+ "ttl_mfo", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] leftHeader = (JSPUtil.getParameter(request, prefix	+ "left_header", length));
			
			for (int i = 0; i < length; i++) {
				model = new HireBaseVO();
				if (mtxFoilPortTtlQty[i] != null)
					model.setMtxFoilPortTtlQty(mtxFoilPortTtlQty[i]);
				if (mtxFoilSeaTtlQty[i] != null)
					model.setMtxFoilSeaTtlQty(mtxFoilSeaTtlQty[i]);
				if (mtxFoilMnvrTtlQty[i] != null)
					model.setMtxFoilMnvrTtlQty(mtxFoilMnvrTtlQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslOwnrFlg[i] != null)
					model.setVslOwnrFlg(vslOwnrFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (sltPrcTtlAmt[i] != null)
					model.setSltPrcTtlAmt(sltPrcTtlAmt[i]);
				if (vslCsl1[i] != null)
					model.setVslCsl1(vslCsl1[i]);
				if (sltPrcOneWyAmt[i] != null)
					model.setSltPrcOneWyAmt(sltPrcOneWyAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (mtxFoilMnvrDyQty[i] != null)
					model.setMtxFoilMnvrDyQty(mtxFoilMnvrDyQty[i]);
				if (mtxFoilPortDyQty[i] != null)
					model.setMtxFoilPortDyQty(mtxFoilPortDyQty[i]);
				if (chrgHirTtlAmt[i] != null)
					model.setChrgHirTtlAmt(chrgHirTtlAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chrgHirTeuAmt[i] != null)
					model.setChrgHirTeuAmt(chrgHirTeuAmt[i]);
				if (ttlAvg[i] != null)
					model.setTtlAvg(ttlAvg[i]);
				if (ownrHirTtlAmt[i] != null)
					model.setOwnrHirTtlAmt(ownrHirTtlAmt[i]);
				if (mtxFoilTtlQty[i] != null)
					model.setMtxFoilTtlQty(mtxFoilTtlQty[i]);
				if (ownrHirTeuAmt[i] != null)
					model.setOwnrHirTeuAmt(ownrHirTeuAmt[i]);
				if (sltPrcWrkYr[i] != null)
					model.setSltPrcWrkYr(sltPrcWrkYr[i]);
				if (peAmt[i] != null)
					model.setPeAmt(peAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bnkExpnAmt[i] != null)
					model.setBnkExpnAmt(bnkExpnAmt[i]);
				if (vslCsl2[i] != null)
					model.setVslCsl2(vslCsl2[i]);
				if (vslCsl3[i] != null)
					model.setVslCsl3(vslCsl3[i]);
				if (mtxFoilSeaDyQty[i] != null)
					model.setMtxFoilSeaDyQty(mtxFoilSeaDyQty[i]);
				if (sltPrcRndAmt[i] != null)
					model.setSltPrcRndAmt(sltPrcRndAmt[i]);
				if (ttlMfo[i] != null)
					model.setTtlMfo(ttlMfo[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (leftHeader[i] != null)
					model.setLeftHeader(leftHeader[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHireBaseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HireBaseVO[]
	 */
	public HireBaseVO[] getHireBaseVOs(){
		HireBaseVO[] vos = (HireBaseVO[])models.toArray(new HireBaseVO[models.size()]);
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
		this.mtxFoilPortTtlQty = this.mtxFoilPortTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtxFoilSeaTtlQty = this.mtxFoilSeaTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtxFoilMnvrTtlQty = this.mtxFoilMnvrTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnrFlg = this.vslOwnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcTtlAmt = this.sltPrcTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl1 = this.vslCsl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcOneWyAmt = this.sltPrcOneWyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtxFoilMnvrDyQty = this.mtxFoilMnvrDyQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtxFoilPortDyQty = this.mtxFoilPortDyQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chrgHirTtlAmt = this.chrgHirTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chrgHirTeuAmt = this.chrgHirTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAvg = this.ttlAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrHirTtlAmt = this.ownrHirTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtxFoilTtlQty = this.mtxFoilTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrHirTeuAmt = this.ownrHirTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcWrkYr = this.sltPrcWrkYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.peAmt = this.peAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkExpnAmt = this.bnkExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl2 = this.vslCsl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCsl3 = this.vslCsl3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtxFoilSeaDyQty = this.mtxFoilSeaDyQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcRndAmt = this.sltPrcRndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMfo = this.ttlMfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leftHeader = this.leftHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
