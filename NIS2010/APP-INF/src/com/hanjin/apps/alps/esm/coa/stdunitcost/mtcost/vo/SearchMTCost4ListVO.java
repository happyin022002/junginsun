/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchMTCost4ListVO.java
*@FileTitle : SearchMTCost4ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.07.12 최성민 
* 1.0 Creation
* 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCost4ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCost4ListVO> models = new ArrayList<SearchMTCost4ListVO>();
	
	/* Column Info */
	private String eqStatus = null;
	/* Column Info */
	private String calcuSteve = null;
	/* Column Info */
	private String pCostYrmon = null;
	/* Column Info */
	private String imbalRto = null;
	/* Column Info */
	private String calcuTrans = null;
	/* Column Info */
	private String pCntrIoVolStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String simStvgUcAmt = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String simTrspUcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String pCntrTpszCd = null;
	/* Column Info */
	private String calcuDays = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String oriDest = null;
	/* Column Info */
	private String simTzDys = null;
	/* Column Info */
	private String pFcntrEccCd = null;
	/* Column Info */
	private String cntrIoVolStsCd = null;
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
	
	public SearchMTCost4ListVO() {}

	public SearchMTCost4ListVO(String ibflag, String pagerows, String costYrmon, String lccCd, String cntrIoVolStsCd, String eqStatus, String imbalRto, String oriDest, String cntrTpszCd, String vol, String simStvgUcAmt, String calcuSteve, String simTrspUcAmt, String calcuTrans, String simTzDys, String calcuDays, String pCntrIoVolStsCd, String pCntrTpszCd, String pCostYrmon, String pFcntrEccCd, String orgSimTrspUcAmt, String orgSimStvgUcAmt, String simTtlUcAmt, String orgSimTtlUcAmt, String mnlRqstFlg) {
		this.eqStatus = eqStatus;
		this.calcuSteve = calcuSteve;
		this.pCostYrmon = pCostYrmon;
		this.imbalRto = imbalRto;
		this.calcuTrans = calcuTrans;
		this.pCntrIoVolStsCd = pCntrIoVolStsCd;
		this.pagerows = pagerows;
		this.simStvgUcAmt = simStvgUcAmt;
		this.lccCd = lccCd;
		this.simTrspUcAmt = simTrspUcAmt;
		this.ibflag = ibflag;
		this.vol = vol;
		this.costYrmon = costYrmon;
		this.pCntrTpszCd = pCntrTpszCd;
		this.calcuDays = calcuDays;
		this.cntrTpszCd = cntrTpszCd;
		this.oriDest = oriDest;
		this.simTzDys = simTzDys;
		this.pFcntrEccCd = pFcntrEccCd;
		this.cntrIoVolStsCd = cntrIoVolStsCd;
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
		this.hashColumns.put("calcu_steve", getCalcuSteve());
		this.hashColumns.put("p_cost_yrmon", getPCostYrmon());
		this.hashColumns.put("imbal_rto", getImbalRto());
		this.hashColumns.put("calcu_trans", getCalcuTrans());
		this.hashColumns.put("p_cntr_io_vol_sts_cd", getPCntrIoVolStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sim_stvg_uc_amt", getSimStvgUcAmt());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("sim_trsp_uc_amt", getSimTrspUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("p_cntr_tpsz_cd", getPCntrTpszCd());
		this.hashColumns.put("calcu_days", getCalcuDays());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ori_dest", getOriDest());
		this.hashColumns.put("sim_tz_dys", getSimTzDys());
		this.hashColumns.put("p_fcntr_ecc_cd", getPFcntrEccCd());
		this.hashColumns.put("cntr_io_vol_sts_cd", getCntrIoVolStsCd());
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
		this.hashFields.put("calcu_steve", "calcuSteve");
		this.hashFields.put("p_cost_yrmon", "pCostYrmon");
		this.hashFields.put("imbal_rto", "imbalRto");
		this.hashFields.put("calcu_trans", "calcuTrans");
		this.hashFields.put("p_cntr_io_vol_sts_cd", "pCntrIoVolStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sim_stvg_uc_amt", "simStvgUcAmt");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("sim_trsp_uc_amt", "simTrspUcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("p_cntr_tpsz_cd", "pCntrTpszCd");
		this.hashFields.put("calcu_days", "calcuDays");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ori_dest", "oriDest");
		this.hashFields.put("sim_tz_dys", "simTzDys");
		this.hashFields.put("p_fcntr_ecc_cd", "pFcntrEccCd");
		this.hashFields.put("cntr_io_vol_sts_cd", "cntrIoVolStsCd");
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
	 * @return calcuSteve
	 */
	public String getCalcuSteve() {
		return this.calcuSteve;
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
	 * @return calcuTrans
	 */
	public String getCalcuTrans() {
		return this.calcuTrans;
	}
	
	/**
	 * Column Info
	 * @return pCntrIoVolStsCd
	 */
	public String getPCntrIoVolStsCd() {
		return this.pCntrIoVolStsCd;
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
	 * @return simStvgUcAmt
	 */
	public String getSimStvgUcAmt() {
		return this.simStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return simTrspUcAmt
	 */
	public String getSimTrspUcAmt() {
		return this.simTrspUcAmt;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
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
	 * @return pCntrTpszCd
	 */
	public String getPCntrTpszCd() {
		return this.pCntrTpszCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return oriDest
	 */
	public String getOriDest() {
		return this.oriDest;
	}
	
	/**
	 * Column Info
	 * @return simTzDys
	 */
	public String getSimTzDys() {
		return this.simTzDys;
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
	 * @return cntrIoVolStsCd
	 */
	public String getCntrIoVolStsCd() {
		return this.cntrIoVolStsCd;
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
	 * @param calcuSteve
	 */
	public void setCalcuSteve(String calcuSteve) {
		this.calcuSteve = calcuSteve;
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
	 * @param calcuTrans
	 */
	public void setCalcuTrans(String calcuTrans) {
		this.calcuTrans = calcuTrans;
	}
	
	/**
	 * Column Info
	 * @param pCntrIoVolStsCd
	 */
	public void setPCntrIoVolStsCd(String pCntrIoVolStsCd) {
		this.pCntrIoVolStsCd = pCntrIoVolStsCd;
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
	 * @param simStvgUcAmt
	 */
	public void setSimStvgUcAmt(String simStvgUcAmt) {
		this.simStvgUcAmt = simStvgUcAmt;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param simTrspUcAmt
	 */
	public void setSimTrspUcAmt(String simTrspUcAmt) {
		this.simTrspUcAmt = simTrspUcAmt;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
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
	 * @param pCntrTpszCd
	 */
	public void setPCntrTpszCd(String pCntrTpszCd) {
		this.pCntrTpszCd = pCntrTpszCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param oriDest
	 */
	public void setOriDest(String oriDest) {
		this.oriDest = oriDest;
	}
	
	/**
	 * Column Info
	 * @param simTzDys
	 */
	public void setSimTzDys(String simTzDys) {
		this.simTzDys = simTzDys;
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
	 * @param cntrIoVolStsCd
	 */
	public void setCntrIoVolStsCd(String cntrIoVolStsCd) {
		this.cntrIoVolStsCd = cntrIoVolStsCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setEqStatus(JSPUtil.getParameter(request, prefix + "eq_status", ""));
		setCalcuSteve(JSPUtil.getParameter(request, prefix + "calcu_steve", ""));
		setPCostYrmon(JSPUtil.getParameter(request, prefix + "p_cost_yrmon", ""));
		setImbalRto(JSPUtil.getParameter(request, prefix + "imbal_rto", ""));
		setCalcuTrans(JSPUtil.getParameter(request, prefix + "calcu_trans", ""));
		setPCntrIoVolStsCd(JSPUtil.getParameter(request, prefix + "p_cntr_io_vol_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSimStvgUcAmt(JSPUtil.getParameter(request, prefix + "sim_stvg_uc_amt", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setSimTrspUcAmt(JSPUtil.getParameter(request, prefix + "sim_trsp_uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setPCntrTpszCd(JSPUtil.getParameter(request, prefix + "p_cntr_tpsz_cd", ""));
		setCalcuDays(JSPUtil.getParameter(request, prefix + "calcu_days", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOriDest(JSPUtil.getParameter(request, prefix + "ori_dest", ""));
		setSimTzDys(JSPUtil.getParameter(request, prefix + "sim_tz_dys", ""));
		setPFcntrEccCd(JSPUtil.getParameter(request, prefix + "p_fcntr_ecc_cd", ""));
		setCntrIoVolStsCd(JSPUtil.getParameter(request, prefix + "cntr_io_vol_sts_cd", ""));
		setOrgSimTrspUcAmt(JSPUtil.getParameter(request, "org_sim_trsp_uc_amt", ""));
		setOrgSimStvgUcAmt(JSPUtil.getParameter(request, "org_sim_stvg_uc_amt", ""));
		setSimTtlUcAmt(JSPUtil.getParameter(request, "sim_ttl_uc_amt", ""));
		setOrgSimTtlUcAmt(JSPUtil.getParameter(request, "org_sim_ttl_uc_amt", ""));
		setMnlRqstFlg(JSPUtil.getParameter(request, "mnl_rqst_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCost4ListVO[]
	 */
	public SearchMTCost4ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCost4ListVO[]
	 */
	public SearchMTCost4ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCost4ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqStatus = (JSPUtil.getParameter(request, prefix	+ "eq_status", length));
			String[] calcuSteve = (JSPUtil.getParameter(request, prefix	+ "calcu_steve", length));
			String[] pCostYrmon = (JSPUtil.getParameter(request, prefix	+ "p_cost_yrmon", length));
			String[] imbalRto = (JSPUtil.getParameter(request, prefix	+ "imbal_rto", length));
			String[] calcuTrans = (JSPUtil.getParameter(request, prefix	+ "calcu_trans", length));
			String[] pCntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_io_vol_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] simStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_stvg_uc_amt", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] simTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_trsp_uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] pCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_tpsz_cd", length));
			String[] calcuDays = (JSPUtil.getParameter(request, prefix	+ "calcu_days", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] oriDest = (JSPUtil.getParameter(request, prefix	+ "ori_dest", length));
			String[] simTzDys = (JSPUtil.getParameter(request, prefix	+ "sim_tz_dys", length));
			String[] pFcntrEccCd = (JSPUtil.getParameter(request, prefix	+ "p_fcntr_ecc_cd", length));
			String[] cntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_io_vol_sts_cd", length));
			String[] orgSimTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_sim_trsp_uc_amt", length));
			String[] orgSimStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_sim_stvg_uc_amt", length));
			String[] simTtlUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_ttl_uc_amt", length));
			String[] orgSimTtlUcAmt = (JSPUtil.getParameter(request, prefix	+ "org_sim_ttl_uc_amt", length));
			String[] mnlRqstFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_rqst_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCost4ListVO();
				if (eqStatus[i] != null)
					model.setEqStatus(eqStatus[i]);
				if (calcuSteve[i] != null)
					model.setCalcuSteve(calcuSteve[i]);
				if (pCostYrmon[i] != null)
					model.setPCostYrmon(pCostYrmon[i]);
				if (imbalRto[i] != null)
					model.setImbalRto(imbalRto[i]);
				if (calcuTrans[i] != null)
					model.setCalcuTrans(calcuTrans[i]);
				if (pCntrIoVolStsCd[i] != null)
					model.setPCntrIoVolStsCd(pCntrIoVolStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (simStvgUcAmt[i] != null)
					model.setSimStvgUcAmt(simStvgUcAmt[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (simTrspUcAmt[i] != null)
					model.setSimTrspUcAmt(simTrspUcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (pCntrTpszCd[i] != null)
					model.setPCntrTpszCd(pCntrTpszCd[i]);
				if (calcuDays[i] != null)
					model.setCalcuDays(calcuDays[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (oriDest[i] != null)
					model.setOriDest(oriDest[i]);
				if (simTzDys[i] != null)
					model.setSimTzDys(simTzDys[i]);
				if (pFcntrEccCd[i] != null)
					model.setPFcntrEccCd(pFcntrEccCd[i]);
				if (cntrIoVolStsCd[i] != null)
					model.setCntrIoVolStsCd(cntrIoVolStsCd[i]);
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
		return getSearchMTCost4ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCost4ListVO[]
	 */
	public SearchMTCost4ListVO[] getSearchMTCost4ListVOs(){
		SearchMTCost4ListVO[] vos = (SearchMTCost4ListVO[])models.toArray(new SearchMTCost4ListVO[models.size()]);
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
		this.eqStatus = this.eqStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuSteve = this.calcuSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCostYrmon = this.pCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imbalRto = this.imbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuTrans = this.calcuTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrIoVolStsCd = this.pCntrIoVolStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simStvgUcAmt = this.simStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTrspUcAmt = this.simTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrTpszCd = this.pCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuDays = this.calcuDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriDest = this.oriDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTzDys = this.simTzDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFcntrEccCd = this.pFcntrEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrIoVolStsCd = this.cntrIoVolStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSimTrspUcAmt = this.orgSimTrspUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSimStvgUcAmt = this.orgSimStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTtlUcAmt = this.simTtlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSimTtlUcAmt = this.orgSimTtlUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlRqstFlg = this.mnlRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
