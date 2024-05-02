/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchTrsTesAcclDataVO.java
*@FileTitle : SearchTrsTesAcclDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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

public class SearchTrsTesAcclDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTrsTesAcclDataVO> models = new ArrayList<SearchTrsTesAcclDataVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String acclSeq = null;
	/* Column Info */
	private String acclQty = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmBcDivCd = null;
	/* Column Info */
	private String errFlg = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String bizUtId = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String cxlDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String estmQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String actQty = null;
	/* Column Info */
	private String estmUcAmt = null;
	/* Column Info */
	private String actPlcCd = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actCostAmt = null;
	/* Column Info */
	private String sysSrcId = null;
	/* Column Info */
	private String estmIocDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTrsTesAcclDataVO() {}

	public SearchTrsTesAcclDataVO(String ibflag, String pagerows, String exeYrmon, String sysSrcId, String revYrmon, String acctCd, String acclSeq, String bizUtId, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String estmVvdTpCd, String estmIocDivCd, String estmBcDivCd, String nodCd, String estmCostAmt, String actCostAmt, String acclCostAmt, String bkgNo, String bkgNoSplit, String cntrTpszCd, String rlaneCd, String cntrQty, String creUsrId, String creDt, String updUsrId, String updDt, String cxlFlg, String cxlDt, String estmQty, String actQty, String acclQty, String vndrNo, String estmUcAmt, String coaCostSrcCd, String actPlcCd, String actDt, String loclCurrCd, String slanCd, String woNo, String ctrlOfcCd, String errFlg, String errDesc) {
		this.vslCd = vslCd;
		this.coaCostSrcCd = coaCostSrcCd;
		this.cxlFlg = cxlFlg;
		this.creDt = creDt;
		this.rlaneCd = rlaneCd;
		this.acclSeq = acclSeq;
		this.acclQty = acclQty;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.estmBcDivCd = estmBcDivCd;
		this.errFlg = errFlg;
		this.acctCd = acctCd;
		this.cntrTpszCd = cntrTpszCd;
		this.woNo = woNo;
		this.bizUtId = bizUtId;
		this.cntrQty = cntrQty;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.bkgNoSplit = bkgNoSplit;
		this.loclCurrCd = loclCurrCd;
		this.cxlDt = cxlDt;
		this.skdVoyNo = skdVoyNo;
		this.acclCostAmt = acclCostAmt;
		this.ctrlOfcCd = ctrlOfcCd;
		this.estmQty = estmQty;
		this.skdDirCd = skdDirCd;
		this.estmVvdTpCd = estmVvdTpCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.errDesc = errDesc;
		this.slanCd = slanCd;
		this.actDt = actDt;
		this.actQty = actQty;
		this.estmUcAmt = estmUcAmt;
		this.actPlcCd = actPlcCd;
		this.nodCd = nodCd;
		this.actCostAmt = actCostAmt;
		this.sysSrcId = sysSrcId;
		this.estmIocDivCd = estmIocDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("accl_seq", getAcclSeq());
		this.hashColumns.put("accl_qty", getAcclQty());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_bc_div_cd", getEstmBcDivCd());
		this.hashColumns.put("err_flg", getErrFlg());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("biz_ut_id", getBizUtId());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cxl_dt", getCxlDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("estm_qty", getEstmQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("act_qty", getActQty());
		this.hashColumns.put("estm_uc_amt", getEstmUcAmt());
		this.hashColumns.put("act_plc_cd", getActPlcCd());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_cost_amt", getActCostAmt());
		this.hashColumns.put("sys_src_id", getSysSrcId());
		this.hashColumns.put("estm_ioc_div_cd", getEstmIocDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("accl_seq", "acclSeq");
		this.hashFields.put("accl_qty", "acclQty");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_bc_div_cd", "estmBcDivCd");
		this.hashFields.put("err_flg", "errFlg");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("biz_ut_id", "bizUtId");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cxl_dt", "cxlDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("estm_qty", "estmQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("act_qty", "actQty");
		this.hashFields.put("estm_uc_amt", "estmUcAmt");
		this.hashFields.put("act_plc_cd", "actPlcCd");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_cost_amt", "actCostAmt");
		this.hashFields.put("sys_src_id", "sysSrcId");
		this.hashFields.put("estm_ioc_div_cd", "estmIocDivCd");
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return acclSeq
	 */
	public String getAcclSeq() {
		return this.acclSeq;
	}
	
	/**
	 * Column Info
	 * @return acclQty
	 */
	public String getAcclQty() {
		return this.acclQty;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return estmBcDivCd
	 */
	public String getEstmBcDivCd() {
		return this.estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @return errFlg
	 */
	public String getErrFlg() {
		return this.errFlg;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return bizUtId
	 */
	public String getBizUtId() {
		return this.bizUtId;
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
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return cxlDt
	 */
	public String getCxlDt() {
		return this.cxlDt;
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
	 * @return acclCostAmt
	 */
	public String getAcclCostAmt() {
		return this.acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return estmQty
	 */
	public String getEstmQty() {
		return this.estmQty;
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
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return actQty
	 */
	public String getActQty() {
		return this.actQty;
	}
	
	/**
	 * Column Info
	 * @return estmUcAmt
	 */
	public String getEstmUcAmt() {
		return this.estmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return actPlcCd
	 */
	public String getActPlcCd() {
		return this.actPlcCd;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return actCostAmt
	 */
	public String getActCostAmt() {
		return this.actCostAmt;
	}
	
	/**
	 * Column Info
	 * @return sysSrcId
	 */
	public String getSysSrcId() {
		return this.sysSrcId;
	}
	
	/**
	 * Column Info
	 * @return estmIocDivCd
	 */
	public String getEstmIocDivCd() {
		return this.estmIocDivCd;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param acclSeq
	 */
	public void setAcclSeq(String acclSeq) {
		this.acclSeq = acclSeq;
	}
	
	/**
	 * Column Info
	 * @param acclQty
	 */
	public void setAcclQty(String acclQty) {
		this.acclQty = acclQty;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param estmBcDivCd
	 */
	public void setEstmBcDivCd(String estmBcDivCd) {
		this.estmBcDivCd = estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @param errFlg
	 */
	public void setErrFlg(String errFlg) {
		this.errFlg = errFlg;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param bizUtId
	 */
	public void setBizUtId(String bizUtId) {
		this.bizUtId = bizUtId;
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
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param cxlDt
	 */
	public void setCxlDt(String cxlDt) {
		this.cxlDt = cxlDt;
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
	 * @param acclCostAmt
	 */
	public void setAcclCostAmt(String acclCostAmt) {
		this.acclCostAmt = acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param estmQty
	 */
	public void setEstmQty(String estmQty) {
		this.estmQty = estmQty;
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
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param actQty
	 */
	public void setActQty(String actQty) {
		this.actQty = actQty;
	}
	
	/**
	 * Column Info
	 * @param estmUcAmt
	 */
	public void setEstmUcAmt(String estmUcAmt) {
		this.estmUcAmt = estmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param actPlcCd
	 */
	public void setActPlcCd(String actPlcCd) {
		this.actPlcCd = actPlcCd;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param actCostAmt
	 */
	public void setActCostAmt(String actCostAmt) {
		this.actCostAmt = actCostAmt;
	}
	
	/**
	 * Column Info
	 * @param sysSrcId
	 */
	public void setSysSrcId(String sysSrcId) {
		this.sysSrcId = sysSrcId;
	}
	
	/**
	 * Column Info
	 * @param estmIocDivCd
	 */
	public void setEstmIocDivCd(String estmIocDivCd) {
		this.estmIocDivCd = estmIocDivCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, prefix + "coa_cost_src_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAcclSeq(JSPUtil.getParameter(request, prefix + "accl_seq", ""));
		setAcclQty(JSPUtil.getParameter(request, prefix + "accl_qty", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, prefix + "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEstmBcDivCd(JSPUtil.getParameter(request, prefix + "estm_bc_div_cd", ""));
		setErrFlg(JSPUtil.getParameter(request, prefix + "err_flg", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setBizUtId(JSPUtil.getParameter(request, prefix + "biz_ut_id", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCxlDt(JSPUtil.getParameter(request, prefix + "cxl_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, prefix + "accl_cost_amt", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setEstmQty(JSPUtil.getParameter(request, prefix + "estm_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setActQty(JSPUtil.getParameter(request, prefix + "act_qty", ""));
		setEstmUcAmt(JSPUtil.getParameter(request, prefix + "estm_uc_amt", ""));
		setActPlcCd(JSPUtil.getParameter(request, prefix + "act_plc_cd", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setActCostAmt(JSPUtil.getParameter(request, prefix + "act_cost_amt", ""));
		setSysSrcId(JSPUtil.getParameter(request, prefix + "sys_src_id", ""));
		setEstmIocDivCd(JSPUtil.getParameter(request, prefix + "estm_ioc_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTrsTesAcclDataVO[]
	 */
	public SearchTrsTesAcclDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTrsTesAcclDataVO[]
	 */
	public SearchTrsTesAcclDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTrsTesAcclDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] acclSeq = (JSPUtil.getParameter(request, prefix	+ "accl_seq", length));
			String[] acclQty = (JSPUtil.getParameter(request, prefix	+ "accl_qty", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmBcDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_bc_div_cd", length));
			String[] errFlg = (JSPUtil.getParameter(request, prefix	+ "err_flg", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] bizUtId = (JSPUtil.getParameter(request, prefix	+ "biz_ut_id", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] cxlDt = (JSPUtil.getParameter(request, prefix	+ "cxl_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] estmQty = (JSPUtil.getParameter(request, prefix	+ "estm_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] actQty = (JSPUtil.getParameter(request, prefix	+ "act_qty", length));
			String[] estmUcAmt = (JSPUtil.getParameter(request, prefix	+ "estm_uc_amt", length));
			String[] actPlcCd = (JSPUtil.getParameter(request, prefix	+ "act_plc_cd", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] actCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt", length));
			String[] sysSrcId = (JSPUtil.getParameter(request, prefix	+ "sys_src_id", length));
			String[] estmIocDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_ioc_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTrsTesAcclDataVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (acclSeq[i] != null)
					model.setAcclSeq(acclSeq[i]);
				if (acclQty[i] != null)
					model.setAcclQty(acclQty[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmBcDivCd[i] != null)
					model.setEstmBcDivCd(estmBcDivCd[i]);
				if (errFlg[i] != null)
					model.setErrFlg(errFlg[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (bizUtId[i] != null)
					model.setBizUtId(bizUtId[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (cxlDt[i] != null)
					model.setCxlDt(cxlDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (estmQty[i] != null)
					model.setEstmQty(estmQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (actQty[i] != null)
					model.setActQty(actQty[i]);
				if (estmUcAmt[i] != null)
					model.setEstmUcAmt(estmUcAmt[i]);
				if (actPlcCd[i] != null)
					model.setActPlcCd(actPlcCd[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actCostAmt[i] != null)
					model.setActCostAmt(actCostAmt[i]);
				if (sysSrcId[i] != null)
					model.setSysSrcId(sysSrcId[i]);
				if (estmIocDivCd[i] != null)
					model.setEstmIocDivCd(estmIocDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTrsTesAcclDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTrsTesAcclDataVO[]
	 */
	public SearchTrsTesAcclDataVO[] getSearchTrsTesAcclDataVOs(){
		SearchTrsTesAcclDataVO[] vos = (SearchTrsTesAcclDataVO[])models.toArray(new SearchTrsTesAcclDataVO[models.size()]);
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
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclSeq = this.acclSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclQty = this.acclQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmBcDivCd = this.estmBcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errFlg = this.errFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizUtId = this.bizUtId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDt = this.cxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmQty = this.estmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actQty = this.actQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmUcAmt = this.estmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPlcCd = this.actPlcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmt = this.actCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcId = this.sysSrcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIocDivCd = this.estmIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
