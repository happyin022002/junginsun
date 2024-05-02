/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMTCostListVO.java
*@FileTitle : SearchMTCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.08.12 박수훈 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 - 생성자 주석 추가
* 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCostListVO> models = new ArrayList<SearchMTCostListVO>();
	
	/* Column Info */
	private String eqStatus = null;
	/* Column Info */
	private String pCostYrmon = null;
	/* Column Info */
	private String imbalRto = null;
	/* Column Info */
	private String cntrObQty = null;
	/* Column Info */
	private String calcuTrans = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pCntrIoVolStsCd = null;
	/* Column Info */
	private String pOriDest = null;
	/* Column Info */
	private String vol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mtyTzHrs = null;
	/* Column Info */
	private String cntrIoVolStsCd = null;
	/* Column Info */
	private String pFcntrEccCd = null;
	/* Column Info */
	private String calcuSteve = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String cntrImbalRto = null;
	/* Column Info */
	private String simStvgUcAmt = null;
	/* Column Info */
	private String cntrImbalQty = null;
	/* Column Info */
	private String fcntrEccCd = null;
	/* Column Info */
	private String simTrspUcAmt = null;
	/* Column Info */
	private String oriDestCd = null;
	/* Column Info */
	private String calcuDays = null;
	/* Column Info */
	private String pCntrTpszCd = null;
	/* Column Info */
	private String cntrIbQty = null;
	/* Column Info */
	private String orgSimTrspUcAmt = null;
	/* Column Info */
	private String orgSimStvgUcAmt = null;
	/* Column Info */
	private String simTtlUcAmt = null;
	/* Column Info */
	private String orgSimTtlUcAmt = null;
	/* Column Info */
	private String mnlRqstFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * SearchMTCostListVO 생성자
	 */
	public SearchMTCostListVO() {}
	/**
	 * SearchMTCostListVO 생성자
	 * @param ibflag
	 * @param pagerows
	 */
	public SearchMTCostListVO(String ibflag, String pagerows, String costYrmon, String eccCd, String cntrIoVolStsCd, String eqStatus, String imbalRto, String oriDestCd, String cntrTpszCd, String vol, String simStvgUcAmt, String calcuSteve, String simTrspUcAmt, String calcuTrans, String mtyTzHrs, String calcuDays, String pOriDest, String pCostYrmon, String pCntrTpszCd, String pFcntrEccCd, String pCntrIoVolStsCd, String fcntrEccCd, String cntrImbalRto, String cntrImbalQty, String cntrIbQty, String cntrObQty, String orgSimTrspUcAmt, String orgSimStvgUcAmt, String simTtlUcAmt, String orgSimTtlUcAmt, String mnlRqstFlg) {
		this.eqStatus = eqStatus;
		this.pCostYrmon = pCostYrmon;
		this.imbalRto = imbalRto;
		this.cntrObQty = cntrObQty;
		this.calcuTrans = calcuTrans;
		this.pagerows = pagerows;
		this.pCntrIoVolStsCd = pCntrIoVolStsCd;
		this.pOriDest = pOriDest;
		this.vol = vol;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.mtyTzHrs = mtyTzHrs;
		this.cntrIoVolStsCd = cntrIoVolStsCd;
		this.pFcntrEccCd = pFcntrEccCd;
		this.calcuSteve = calcuSteve;
		this.eccCd = eccCd;
		this.cntrImbalRto = cntrImbalRto;
		this.simStvgUcAmt = simStvgUcAmt;
		this.cntrImbalQty = cntrImbalQty;
		this.fcntrEccCd = fcntrEccCd;
		this.simTrspUcAmt = simTrspUcAmt;
		this.oriDestCd = oriDestCd;
		this.calcuDays = calcuDays;
		this.pCntrTpszCd = pCntrTpszCd;
		this.cntrIbQty = cntrIbQty;
		this.orgSimTrspUcAmt = orgSimTrspUcAmt;
		this.orgSimStvgUcAmt = orgSimStvgUcAmt;
		this.simTtlUcAmt = simTtlUcAmt;
		this.orgSimTtlUcAmt = orgSimTtlUcAmt;
		this.mnlRqstFlg = mnlRqstFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_status", getEqStatus());
		this.hashColumns.put("p_cost_yrmon", getPCostYrmon());
		this.hashColumns.put("imbal_rto", getImbalRto());
		this.hashColumns.put("cntr_ob_qty", getCntrObQty());
		this.hashColumns.put("calcu_trans", getCalcuTrans());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_cntr_io_vol_sts_cd", getPCntrIoVolStsCd());
		this.hashColumns.put("p_ori_dest", getPOriDest());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mty_tz_hrs", getMtyTzHrs());
		this.hashColumns.put("cntr_io_vol_sts_cd", getCntrIoVolStsCd());
		this.hashColumns.put("p_fcntr_ecc_cd", getPFcntrEccCd());
		this.hashColumns.put("calcu_steve", getCalcuSteve());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cntr_imbal_rto", getCntrImbalRto());
		this.hashColumns.put("sim_stvg_uc_amt", getSimStvgUcAmt());
		this.hashColumns.put("cntr_imbal_qty", getCntrImbalQty());
		this.hashColumns.put("fcntr_ecc_cd", getFcntrEccCd());
		this.hashColumns.put("sim_trsp_uc_amt", getSimTrspUcAmt());
		this.hashColumns.put("ori_dest_cd", getOriDestCd());
		this.hashColumns.put("calcu_days", getCalcuDays());
		this.hashColumns.put("p_cntr_tpsz_cd", getPCntrTpszCd());
		this.hashColumns.put("cntr_ib_qty", getCntrIbQty());
		this.hashColumns.put("org_sim_trsp_uc_amt", getOrgSimTrspUcAmt());
		this.hashColumns.put("org_sim_stvg_uc_amt", getOrgSimStvgUcAmt());
		this.hashColumns.put("sim_ttl_uc_amt", getSimTtlUcAmt());
		this.hashColumns.put("org_sim_ttl_uc_amt", getOrgSimTtlUcAmt());
		this.hashColumns.put("mnl_rqst_flg", getMnlRqstFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_status", "eqStatus");
		this.hashFields.put("p_cost_yrmon", "pCostYrmon");
		this.hashFields.put("imbal_rto", "imbalRto");
		this.hashFields.put("cntr_ob_qty", "cntrObQty");
		this.hashFields.put("calcu_trans", "calcuTrans");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_cntr_io_vol_sts_cd", "pCntrIoVolStsCd");
		this.hashFields.put("p_ori_dest", "pOriDest");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mty_tz_hrs", "mtyTzHrs");
		this.hashFields.put("cntr_io_vol_sts_cd", "cntrIoVolStsCd");
		this.hashFields.put("p_fcntr_ecc_cd", "pFcntrEccCd");
		this.hashFields.put("calcu_steve", "calcuSteve");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cntr_imbal_rto", "cntrImbalRto");
		this.hashFields.put("sim_stvg_uc_amt", "simStvgUcAmt");
		this.hashFields.put("cntr_imbal_qty", "cntrImbalQty");
		this.hashFields.put("fcntr_ecc_cd", "fcntrEccCd");
		this.hashFields.put("sim_trsp_uc_amt", "simTrspUcAmt");
		this.hashFields.put("ori_dest_cd", "oriDestCd");
		this.hashFields.put("calcu_days", "calcuDays");
		this.hashFields.put("p_cntr_tpsz_cd", "pCntrTpszCd");
		this.hashFields.put("cntr_ib_qty", "cntrIbQty");
		this.hashFields.put("org_sim_trsp_uc_amt", "orgSimTrspUcAmt");
		this.hashFields.put("org_sim_stvg_uc_amt", "orgSimStvgUcAmt");
		this.hashFields.put("sim_ttl_uc_amt", "simTtlUcAmt");
		this.hashFields.put("org_sim_ttl_uc_amt", "orgSimTtlUcAmt");
		this.hashFields.put("mnl_rqst_flg", "mnlRqstFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqStatus
	 */
	public String getEqStatus() {
		return this.eqStatus;
	}
	
	/**
	 * Column Info
	 * @return pCostYrmon
	 */
	public String getPCostYrmon() {
		return this.pCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return imbalRto
	 */
	public String getImbalRto() {
		return this.imbalRto;
	}
	
	/**
	 * Column Info
	 * @return cntrObQty
	 */
	public String getCntrObQty() {
		return this.cntrObQty;
	}
	
	/**
	 * Column Info
	 * @return calcuTrans
	 */
	public String getCalcuTrans() {
		return this.calcuTrans;
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
	 * @return pCntrIoVolStsCd
	 */
	public String getPCntrIoVolStsCd() {
		return this.pCntrIoVolStsCd;
	}
	
	/**
	 * Column Info
	 * @return pOriDest
	 */
	public String getPOriDest() {
		return this.pOriDest;
	}
	
	/**
	 * Column Info
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return mtyTzHrs
	 */
	public String getMtyTzHrs() {
		return this.mtyTzHrs;
	}
	
	/**
	 * Column Info
	 * @return cntrIoVolStsCd
	 */
	public String getCntrIoVolStsCd() {
		return this.cntrIoVolStsCd;
	}
	
	/**
	 * Column Info
	 * @return pFcntrEccCd
	 */
	public String getPFcntrEccCd() {
		return this.pFcntrEccCd;
	}
	
	/**
	 * Column Info
	 * @return calcuSteve
	 */
	public String getCalcuSteve() {
		return this.calcuSteve;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return cntrImbalRto
	 */
	public String getCntrImbalRto() {
		return this.cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @return simStvgUcAmt
	 */
	public String getSimStvgUcAmt() {
		return this.simStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrImbalQty
	 */
	public String getCntrImbalQty() {
		return this.cntrImbalQty;
	}
	
	/**
	 * Column Info
	 * @return fcntrEccCd
	 */
	public String getFcntrEccCd() {
		return this.fcntrEccCd;
	}
	
	/**
	 * Column Info
	 * @return simTrspUcAmt
	 */
	public String getSimTrspUcAmt() {
		return this.simTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @return oriDestCd
	 */
	public String getOriDestCd() {
		return this.oriDestCd;
	}
	
	/**
	 * Column Info
	 * @return calcuDays
	 */
	public String getCalcuDays() {
		return this.calcuDays;
	}
	
	/**
	 * Column Info
	 * @return pCntrTpszCd
	 */
	public String getPCntrTpszCd() {
		return this.pCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrIbQty
	 */
	public String getCntrIbQty() {
		return this.cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @return orgSimTrspUcAmt
	 */
	public String getOrgSimTrspUcAmt() {
		return this.orgSimTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @return orgSimStvgUcAmt
	 */
	public String getOrgSimStvgUcAmt() {
		return this.orgSimStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return simTtlUcAmt
	 */
	public String getSimTtlUcAmt() {
		return this.simTtlUcAmt;
	}
	
	/**
	 * Column Info
	 * @return orgSimTtlUcAmt
	 */
	public String getOrgSimTtlUcAmt() {
		return this.orgSimTtlUcAmt;
	}
	
	/**
	 * Column Info
	 * @return mnlRqstFlg
	 */
	public String getMnlRqstFlg() {
		return this.mnlRqstFlg;
	}
	

	/**
	 * Column Info
	 * @param eqStatus
	 */
	public void setEqStatus(String eqStatus) {
		this.eqStatus = eqStatus;
	}
	
	/**
	 * Column Info
	 * @param pCostYrmon
	 */
	public void setPCostYrmon(String pCostYrmon) {
		this.pCostYrmon = pCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param imbalRto
	 */
	public void setImbalRto(String imbalRto) {
		this.imbalRto = imbalRto;
	}
	
	/**
	 * Column Info
	 * @param cntrObQty
	 */
	public void setCntrObQty(String cntrObQty) {
		this.cntrObQty = cntrObQty;
	}
	
	/**
	 * Column Info
	 * @param calcuTrans
	 */
	public void setCalcuTrans(String calcuTrans) {
		this.calcuTrans = calcuTrans;
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
	 * @param pCntrIoVolStsCd
	 */
	public void setPCntrIoVolStsCd(String pCntrIoVolStsCd) {
		this.pCntrIoVolStsCd = pCntrIoVolStsCd;
	}
	
	/**
	 * Column Info
	 * @param pOriDest
	 */
	public void setPOriDest(String pOriDest) {
		this.pOriDest = pOriDest;
	}
	
	/**
	 * Column Info
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param mtyTzHrs
	 */
	public void setMtyTzHrs(String mtyTzHrs) {
		this.mtyTzHrs = mtyTzHrs;
	}
	
	/**
	 * Column Info
	 * @param cntrIoVolStsCd
	 */
	public void setCntrIoVolStsCd(String cntrIoVolStsCd) {
		this.cntrIoVolStsCd = cntrIoVolStsCd;
	}
	
	/**
	 * Column Info
	 * @param pFcntrEccCd
	 */
	public void setPFcntrEccCd(String pFcntrEccCd) {
		this.pFcntrEccCd = pFcntrEccCd;
	}
	
	/**
	 * Column Info
	 * @param calcuSteve
	 */
	public void setCalcuSteve(String calcuSteve) {
		this.calcuSteve = calcuSteve;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param cntrImbalRto
	 */
	public void setCntrImbalRto(String cntrImbalRto) {
		this.cntrImbalRto = cntrImbalRto;
	}
	
	/**
	 * Column Info
	 * @param simStvgUcAmt
	 */
	public void setSimStvgUcAmt(String simStvgUcAmt) {
		this.simStvgUcAmt = simStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrImbalQty
	 */
	public void setCntrImbalQty(String cntrImbalQty) {
		this.cntrImbalQty = cntrImbalQty;
	}
	
	/**
	 * Column Info
	 * @param fcntrEccCd
	 */
	public void setFcntrEccCd(String fcntrEccCd) {
		this.fcntrEccCd = fcntrEccCd;
	}
	
	/**
	 * Column Info
	 * @param simTrspUcAmt
	 */
	public void setSimTrspUcAmt(String simTrspUcAmt) {
		this.simTrspUcAmt = simTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @param oriDestCd
	 */
	public void setOriDestCd(String oriDestCd) {
		this.oriDestCd = oriDestCd;
	}
	
	/**
	 * Column Info
	 * @param calcuDays
	 */
	public void setCalcuDays(String calcuDays) {
		this.calcuDays = calcuDays;
	}
	
	/**
	 * Column Info
	 * @param pCntrTpszCd
	 */
	public void setPCntrTpszCd(String pCntrTpszCd) {
		this.pCntrTpszCd = pCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrIbQty
	 */
	public void setCntrIbQty(String cntrIbQty) {
		this.cntrIbQty = cntrIbQty;
	}
	
	/**
	 * Column Info
	 * @param orgSimTrspUcAmt
	 */
	public void setOrgSimTrspUcAmt(String orgSimTrspUcAmt) {
		this.orgSimTrspUcAmt = orgSimTrspUcAmt;
	}
	
	/**
	 * Column Info
	 * @param orgSimStvgUcAmt
	 */
	public void setOrgSimStvgUcAmt(String orgSimStvgUcAmt) {
		this.orgSimStvgUcAmt = orgSimStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param simTtlUcAmt
	 */
	public void setSimTtlUcAmt(String simTtlUcAmt) {
		this.simTtlUcAmt = simTtlUcAmt;
	}
	
	/**
	 * Column Info
	 * @param orgSimTtlUcAmt
	 */
	public void setOrgSimTtlUcAmt(String orgSimTtlUcAmt) {
		this.orgSimTtlUcAmt = orgSimTtlUcAmt;
	}
	
	/**
	 * Column Info
	 * @param mnlRqstFlg
	 */
	public void setMnlRqstFlg(String mnlRqstFlg) {
		this.mnlRqstFlg = mnlRqstFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEqStatus(JSPUtil.getParameter(request, "eq_status", ""));
		setPCostYrmon(JSPUtil.getParameter(request, "p_cost_yrmon", ""));
		setImbalRto(JSPUtil.getParameter(request, "imbal_rto", ""));
		setCntrObQty(JSPUtil.getParameter(request, "cntr_ob_qty", ""));
		setCalcuTrans(JSPUtil.getParameter(request, "calcu_trans", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPCntrIoVolStsCd(JSPUtil.getParameter(request, "p_cntr_io_vol_sts_cd", ""));
		setPOriDest(JSPUtil.getParameter(request, "p_ori_dest", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setMtyTzHrs(JSPUtil.getParameter(request, "mty_tz_hrs", ""));
		setCntrIoVolStsCd(JSPUtil.getParameter(request, "cntr_io_vol_sts_cd", ""));
		setPFcntrEccCd(JSPUtil.getParameter(request, "p_fcntr_ecc_cd", ""));
		setCalcuSteve(JSPUtil.getParameter(request, "calcu_steve", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setCntrImbalRto(JSPUtil.getParameter(request, "cntr_imbal_rto", ""));
		setSimStvgUcAmt(JSPUtil.getParameter(request, "sim_stvg_uc_amt", ""));
		setCntrImbalQty(JSPUtil.getParameter(request, "cntr_imbal_qty", ""));
		setFcntrEccCd(JSPUtil.getParameter(request, "fcntr_ecc_cd", ""));
		setSimTrspUcAmt(JSPUtil.getParameter(request, "sim_trsp_uc_amt", ""));
		setOriDestCd(JSPUtil.getParameter(request, "ori_dest_cd", ""));
		setCalcuDays(JSPUtil.getParameter(request, "calcu_days", ""));
		setPCntrTpszCd(JSPUtil.getParameter(request, "p_cntr_tpsz_cd", ""));
		setCntrIbQty(JSPUtil.getParameter(request, "cntr_ib_qty", ""));
		setOrgSimTrspUcAmt(JSPUtil.getParameter(request, "org_sim_trsp_uc_amt", ""));
		setOrgSimStvgUcAmt(JSPUtil.getParameter(request, "org_sim_stvg_uc_amt", ""));
		setSimTtlUcAmt(JSPUtil.getParameter(request, "sim_ttl_uc_amt", ""));
		setOrgSimTtlUcAmt(JSPUtil.getParameter(request, "org_sim_ttl_uc_amt", ""));
		setMnlRqstFlg(JSPUtil.getParameter(request, "mnl_rqst_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCostListVO[]
	 */
	public SearchMTCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCostListVO[]
	 */
	public SearchMTCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqStatus = (JSPUtil.getParameter(request, prefix	+ "eq_status", length));
			String[] pCostYrmon = (JSPUtil.getParameter(request, prefix	+ "p_cost_yrmon", length));
			String[] imbalRto = (JSPUtil.getParameter(request, prefix	+ "imbal_rto", length));
			String[] cntrObQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ob_qty", length));
			String[] calcuTrans = (JSPUtil.getParameter(request, prefix	+ "calcu_trans", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pCntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_io_vol_sts_cd", length));
			String[] pOriDest = (JSPUtil.getParameter(request, prefix	+ "p_ori_dest", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mtyTzHrs = (JSPUtil.getParameter(request, prefix	+ "mty_tz_hrs", length));
			String[] cntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_io_vol_sts_cd", length));
			String[] pFcntrEccCd = (JSPUtil.getParameter(request, prefix	+ "p_fcntr_ecc_cd", length));
			String[] calcuSteve = (JSPUtil.getParameter(request, prefix	+ "calcu_steve", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] cntrImbalRto = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_rto", length));
			String[] simStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_stvg_uc_amt", length));
			String[] cntrImbalQty = (JSPUtil.getParameter(request, prefix	+ "cntr_imbal_qty", length));
			String[] fcntrEccCd = (JSPUtil.getParameter(request, prefix	+ "fcntr_ecc_cd", length));
			String[] simTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_trsp_uc_amt", length));
			String[] oriDestCd = (JSPUtil.getParameter(request, prefix	+ "ori_dest_cd", length));
			String[] calcuDays = (JSPUtil.getParameter(request, prefix	+ "calcu_days", length));
			String[] pCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_tpsz_cd", length));
			String[] cntrIbQty = (JSPUtil.getParameter(request, prefix	+ "cntr_ib_qty", length));
			String[] orgSimTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_sim_trsp_uc_amt", length));
			String[] orgSimStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_sim_stvg_uc_amt", length));
			String[] simTtlUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_ttl_uc_amt", length));
			String[] orgSimTtlUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_sim_ttl_uc_amt", length));
			String[] mnlRqstFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_rqst_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCostListVO();
				if (eqStatus[i] != null)
					model.setEqStatus(eqStatus[i]);
				if (pCostYrmon[i] != null)
					model.setPCostYrmon(pCostYrmon[i]);
				if (imbalRto[i] != null)
					model.setImbalRto(imbalRto[i]);
				if (cntrObQty[i] != null)
					model.setCntrObQty(cntrObQty[i]);
				if (calcuTrans[i] != null)
					model.setCalcuTrans(calcuTrans[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pCntrIoVolStsCd[i] != null)
					model.setPCntrIoVolStsCd(pCntrIoVolStsCd[i]);
				if (pOriDest[i] != null)
					model.setPOriDest(pOriDest[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mtyTzHrs[i] != null)
					model.setMtyTzHrs(mtyTzHrs[i]);
				if (cntrIoVolStsCd[i] != null)
					model.setCntrIoVolStsCd(cntrIoVolStsCd[i]);
				if (pFcntrEccCd[i] != null)
					model.setPFcntrEccCd(pFcntrEccCd[i]);
				if (calcuSteve[i] != null)
					model.setCalcuSteve(calcuSteve[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (cntrImbalRto[i] != null)
					model.setCntrImbalRto(cntrImbalRto[i]);
				if (simStvgUcAmt[i] != null)
					model.setSimStvgUcAmt(simStvgUcAmt[i]);
				if (cntrImbalQty[i] != null)
					model.setCntrImbalQty(cntrImbalQty[i]);
				if (fcntrEccCd[i] != null)
					model.setFcntrEccCd(fcntrEccCd[i]);
				if (simTrspUcAmt[i] != null)
					model.setSimTrspUcAmt(simTrspUcAmt[i]);
				if (oriDestCd[i] != null)
					model.setOriDestCd(oriDestCd[i]);
				if (calcuDays[i] != null)
					model.setCalcuDays(calcuDays[i]);
				if (pCntrTpszCd[i] != null)
					model.setPCntrTpszCd(pCntrTpszCd[i]);
				if (cntrIbQty[i] != null)
					model.setCntrIbQty(cntrIbQty[i]);
				if (orgSimTrspUcAmt[i] != null)
					model.setOrgSimTrspUcAmt(orgSimTrspUcAmt[i]);
				if (orgSimStvgUcAmt[i] != null)
					model.setOrgSimStvgUcAmt(orgSimStvgUcAmt[i]);
				if (simTtlUcAmt[i] != null)
					model.setSimTtlUcAmt(simTtlUcAmt[i]);
				if (orgSimTtlUcAmt[i] != null)
					model.setOrgSimTtlUcAmt(orgSimTtlUcAmt[i]);
				if (mnlRqstFlg[i] != null)
					model.setMnlRqstFlg(mnlRqstFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCostListVO[]
	 */
	public SearchMTCostListVO[] getSearchMTCostListVOs(){
		SearchMTCostListVO[] vos = (SearchMTCostListVO[])models.toArray(new SearchMTCostListVO[models.size()]);
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
		this.eqStatus = this.eqStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCostYrmon = this.pCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imbalRto = this.imbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrObQty = this.cntrObQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuTrans = this.calcuTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrIoVolStsCd = this.pCntrIoVolStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOriDest = this.pOriDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTzHrs = this.mtyTzHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIoVolStsCd = this.cntrIoVolStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFcntrEccCd = this.pFcntrEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuSteve = this.calcuSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImbalRto = this.cntrImbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simStvgUcAmt = this.simStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImbalQty = this.cntrImbalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrEccCd = this.fcntrEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTrspUcAmt = this.simTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriDestCd = this.oriDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuDays = this.calcuDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrTpszCd = this.pCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIbQty = this.cntrIbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSimTrspUcAmt = this.orgSimTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSimStvgUcAmt = this.orgSimStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTtlUcAmt = this.simTtlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSimTtlUcAmt = this.orgSimTtlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlRqstFlg = this.mnlRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
