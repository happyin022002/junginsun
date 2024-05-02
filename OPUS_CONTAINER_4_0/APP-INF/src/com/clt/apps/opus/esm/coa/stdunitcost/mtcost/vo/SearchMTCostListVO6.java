/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMTCostListVO6.java
*@FileTitle : SearchMTCostListVO6
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.26 박수훈 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 - 생성자 주석 추가
* 2010.02.16 임옥영 품질검토 결과 반영 
* Line No. 117 :  : shall be matched with name of parameter(eqStatus vs ibflag)
* Line No. 117 :  : shall be matched with name of parameter(calcuSteve vs pagerows)
* Line No. 117 :  : shall be matched with name of parameter(pCostYrmon vs costYrmon)
* Line No. 117 :  : shall be matched with name of parameter(imbalRto vs rccCd)
* Line No. 117 :  : shall be matched with name of parameter(rccCd vs cntrIoVolStsCd)
* Line No. 117 :  : shall be matched with name of parameter(calcuTrans vs eqStatus)
* Line No. 117 :  : shall be matched with name of parameter(pCntrIoVolStsCd vs imbalRto)
* Line No. 117 :  : shall be matched with name of parameter(pagerows vs oriDest)
* Line No. 117 :  : shall be matched with name of parameter(simStvgUcAmt vs cntrTpszCd)
* Line No. 117 :  : shall be matched with name of parameter(simTrspUcAmt vs vol)
* Line No. 117 :  : shall be matched with name of parameter(ibflag vs simStvgUcAmt)
* Line No. 117 :  : shall be matched with name of parameter(vol vs calcuSteve)
* Line No. 117 :  : shall be matched with name of parameter(costYrmon vs simTrspUcAmt)
* Line No. 117 :  : shall be matched with name of parameter(pCntrTpszCd vs calcuTrans)
* Line No. 117 :  : shall be matched with name of parameter(calcuDays vs simTzDys)
* Line No. 117 :  : shall be matched with name of parameter(cntrTpszCd vs calcuDays)
* Line No. 117 :  : shall be matched with name of parameter(oriDest vs pCostYrmon)
* Line No. 117 :  : shall be matched with name of parameter(simTzDys vs pCntrTpszCd)
* Line No. 117 :  : shall be matched with name of parameter(cntrIoVolStsCd vs pCntrIoVolStsCd)


=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCostListVO6 extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCostListVO6> models = new ArrayList<SearchMTCostListVO6>();
	
	/* Column Info */
	private String eqStatus = null;
	/* Column Info */
	private String calcuSteve = null;
	/* Column Info */
	private String pCostYrmon = null;
	/* Column Info */
	private String imbalRto = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String calcuTrans = null;
	/* Column Info */
	private String pCntrIoVolStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String simStvgUcAmt = null;
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

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	/**
	 * SearchMTCostListVO6 생성자
	 */
	public SearchMTCostListVO6() {}

	/**
	 * SearchMTCostListVO6 생성자
	 * 
	 * @param String ibflag
	 * @param String pagerows
	 * @param String costYrmon
	 * @param String rccCd
	 * @param String cntrIoVolStsCd
	 * @param String eqStatus
	 * @param String imbalRto
	 * @param String oriDest
	 * @param String cntrTpszCd
	 * @param String vol
	 * @param String simStvgUcAmt
	 * @param String calcuSteve
	 * @param String simTrspUcAmt
	 * @param String calcuTrans
	 * @param String simTzDys
	 * @param String calcuDays
	 * @param String pCostYrmon
	 * @param String pCntrTpszCd
	 * @param String pFcntrEccCd
	 * @param String pCntrIoVolStsCd
	 */
	public SearchMTCostListVO6(String ibflag, String pagerows, String costYrmon, String rccCd, String cntrIoVolStsCd, String eqStatus, String imbalRto, String oriDest, String cntrTpszCd, String vol, String simStvgUcAmt, String calcuSteve, String simTrspUcAmt, String calcuTrans, String simTzDys, String calcuDays, String pCostYrmon, String pCntrTpszCd, String pFcntrEccCd, String pCntrIoVolStsCd) {
		this.eqStatus = eqStatus;
		this.calcuSteve = calcuSteve;
		this.pCostYrmon = pCostYrmon;
		this.imbalRto = imbalRto;
		this.rccCd = rccCd;
		this.calcuTrans = calcuTrans;
		this.pCntrIoVolStsCd = pCntrIoVolStsCd;
		this.pagerows = pagerows;
		this.simStvgUcAmt = simStvgUcAmt;
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
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("calcu_trans", getCalcuTrans());
		this.hashColumns.put("p_cntr_io_vol_sts_cd", getPCntrIoVolStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sim_stvg_uc_amt", getSimStvgUcAmt());
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
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("calcu_trans", "calcuTrans");
		this.hashFields.put("p_cntr_io_vol_sts_cd", "pCntrIoVolStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sim_stvg_uc_amt", "simStvgUcAmt");
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
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEqStatus(JSPUtil.getParameter(request, "eq_status", ""));
		setCalcuSteve(JSPUtil.getParameter(request, "calcu_steve", ""));
		setPCostYrmon(JSPUtil.getParameter(request, "p_cost_yrmon", ""));
		setImbalRto(JSPUtil.getParameter(request, "imbal_rto", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setCalcuTrans(JSPUtil.getParameter(request, "calcu_trans", ""));
		setPCntrIoVolStsCd(JSPUtil.getParameter(request, "p_cntr_io_vol_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSimStvgUcAmt(JSPUtil.getParameter(request, "sim_stvg_uc_amt", ""));
		setSimTrspUcAmt(JSPUtil.getParameter(request, "sim_trsp_uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setPCntrTpszCd(JSPUtil.getParameter(request, "p_cntr_tpsz_cd", ""));
		setCalcuDays(JSPUtil.getParameter(request, "calcu_days", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOriDest(JSPUtil.getParameter(request, "ori_dest", ""));
		setSimTzDys(JSPUtil.getParameter(request, "sim_tz_dys", ""));
		setPFcntrEccCd(JSPUtil.getParameter(request, "p_fcntr_ecc_cd", ""));
		setCntrIoVolStsCd(JSPUtil.getParameter(request, "cntr_io_vol_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCostListVO6[]
	 */
	public SearchMTCostListVO6[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCostListVO6[]
	 */
	public SearchMTCostListVO6[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCostListVO6 model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s_eqStatus = (JSPUtil.getParameter(request, prefix	+ "eq_status", length));
			String[] s_calcuSteve = (JSPUtil.getParameter(request, prefix	+ "calcu_steve", length));
			String[] s_pCostYrmon = (JSPUtil.getParameter(request, prefix	+ "p_cost_yrmon", length));
			String[] s_imbalRto = (JSPUtil.getParameter(request, prefix	+ "imbal_rto", length));
			String[] s_rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] s_calcuTrans = (JSPUtil.getParameter(request, prefix	+ "calcu_trans", length));
			String[] s_pCntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_io_vol_sts_cd", length));
			String[] s_pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s_simStvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_stvg_uc_amt", length));
			String[] s_simTrspUcAmt = (JSPUtil.getParameter(request, prefix	+ "sim_trsp_uc_amt", length));
			String[] s_ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s_vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] s_costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] s_pCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_tpsz_cd", length));
			String[] s_calcuDays = (JSPUtil.getParameter(request, prefix	+ "calcu_days", length));
			String[] s_cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] s_oriDest = (JSPUtil.getParameter(request, prefix	+ "ori_dest", length));
			String[] s_simTzDys = (JSPUtil.getParameter(request, prefix	+ "sim_tz_dys", length));
			String[] s_pFcntrEccCd = (JSPUtil.getParameter(request, prefix	+ "p_fcntr_ecc_cd", length));
			String[] s_cntrIoVolStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_io_vol_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCostListVO6();
				if (s_eqStatus[i] != null)
					model.setEqStatus(s_eqStatus[i]);
				if (s_calcuSteve[i] != null)
					model.setCalcuSteve(s_calcuSteve[i]);
				if (s_pCostYrmon[i] != null)
					model.setPCostYrmon(s_pCostYrmon[i]);
				if (s_imbalRto[i] != null)
					model.setImbalRto(s_imbalRto[i]);
				if (s_rccCd[i] != null)
					model.setRccCd(s_rccCd[i]);
				if (s_calcuTrans[i] != null)
					model.setCalcuTrans(s_calcuTrans[i]);
				if (s_pCntrIoVolStsCd[i] != null)
					model.setPCntrIoVolStsCd(s_pCntrIoVolStsCd[i]);
				if (s_pagerows[i] != null)
					model.setPagerows(s_pagerows[i]);
				if (s_simStvgUcAmt[i] != null)
					model.setSimStvgUcAmt(s_simStvgUcAmt[i]);
				if (s_simTrspUcAmt[i] != null)
					model.setSimTrspUcAmt(s_simTrspUcAmt[i]);
				if (s_ibflag[i] != null)
					model.setIbflag(s_ibflag[i]);
				if (s_vol[i] != null)
					model.setVol(s_vol[i]);
				if (s_costYrmon[i] != null)
					model.setCostYrmon(s_costYrmon[i]);
				if (s_pCntrTpszCd[i] != null)
					model.setPCntrTpszCd(s_pCntrTpszCd[i]);
				if (s_calcuDays[i] != null)
					model.setCalcuDays(s_calcuDays[i]);
				if (s_cntrTpszCd[i] != null)
					model.setCntrTpszCd(s_cntrTpszCd[i]);
				if (s_oriDest[i] != null)
					model.setOriDest(s_oriDest[i]);
				if (s_simTzDys[i] != null)
					model.setSimTzDys(s_simTzDys[i]);
				if (s_pFcntrEccCd[i] != null)
					model.setPFcntrEccCd(s_pFcntrEccCd[i]);
				if (s_cntrIoVolStsCd[i] != null)
					model.setCntrIoVolStsCd(s_cntrIoVolStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCostListVO6s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCostListVO6[]
	 */
	public SearchMTCostListVO6[] getSearchMTCostListVO6s(){
		SearchMTCostListVO6[] vos = (SearchMTCostListVO6[])models.toArray(new SearchMTCostListVO6[models.size()]);
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
		this.calcuSteve = this.calcuSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCostYrmon = this.pCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imbalRto = this.imbalRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcuTrans = this.calcuTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrIoVolStsCd = this.pCntrIoVolStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simStvgUcAmt = this.simStvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
	}
}