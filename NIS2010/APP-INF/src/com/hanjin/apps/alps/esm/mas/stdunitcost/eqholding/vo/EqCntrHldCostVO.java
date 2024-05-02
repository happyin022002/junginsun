/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EqCntrHldCostVO.java
*@FileTitle : EqCntrHldCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo;

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

public class EqCntrHldCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqCntrHldCostVO> models = new ArrayList<EqCntrHldCostVO>();
	
	/* Column Info */
	private String dayAPct = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dayB = null;
	/* Column Info */
	private String dayC = null;
	/* Column Info */
	private String dayA = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String boxCnt = null;
	/* Column Info */
	private String ttlCostAmt = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String hldUcAmtNorm = null;
	/* Column Info */
	private String pdmA = null;
	/* Column Info */
	private String destRailDys = null;
	/* Column Info */
	private String pdmC = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgRailDys = null;
	/* Column Info */
	private String subTot = null;
	/* Column Info */
	private String dayBPct = null;
	/* Column Info */
	private String mtSeaDys = null;
	/* Column Info */
	private String dayACost = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String ttlDys = null;
	/* Column Info */
	private String mtLand = null;
	/* Column Info */
	private String tpszCd = null;
	/* Column Info */
	private String avgDys = null;
	/* Column Info */
	private String dysNorm = null;
	/* Column Info */
	private String fullDmt = null;
	/* Column Info */
	private String hldUcAmtNormAdj = null;
	/* Column Info */
	private String dayBCost = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqCntrHldCostVO() {}

	public EqCntrHldCostVO(String ibflag, String pagerows, String costYrmon, String tpszCd, String ttlDys, String seaDys, String orgRailDys, String destRailDys, String fullDmt, String mtLand, String subTot, String boxCnt, String avgDys, String mtSeaDys, String dayA, String dayB, String dayC, String acctCd, String acctNm, String ttlCostAmt, String dayAPct, String dayBPct, String dayACost, String dayBCost, String pdmA, String pdmC, String updUsrId, String creUsrId, String dysNorm, String hldUcAmtNorm, String hldUcAmtNormAdj) {
		this.dayAPct = dayAPct;
		this.ibflag = ibflag;
		this.dayB = dayB;
		this.dayC = dayC;
		this.dayA = dayA;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.boxCnt = boxCnt;
		this.ttlCostAmt = ttlCostAmt;
		this.costYrmon = costYrmon;
		this.acctNm = acctNm;
		this.seaDys = seaDys;
		this.hldUcAmtNorm = hldUcAmtNorm;
		this.pdmA = pdmA;
		this.destRailDys = destRailDys;
		this.pdmC = pdmC;
		this.pagerows = pagerows;
		this.orgRailDys = orgRailDys;
		this.subTot = subTot;
		this.dayBPct = dayBPct;
		this.mtSeaDys = mtSeaDys;
		this.dayACost = dayACost;
		this.acctCd = acctCd;
		this.ttlDys = ttlDys;
		this.mtLand = mtLand;
		this.tpszCd = tpszCd;
		this.avgDys = avgDys;
		this.dysNorm = dysNorm;
		this.fullDmt = fullDmt;
		this.hldUcAmtNormAdj = hldUcAmtNormAdj;
		this.dayBCost = dayBCost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("day_a_pct", getDayAPct());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("day_b", getDayB());
		this.hashColumns.put("day_c", getDayC());
		this.hashColumns.put("day_a", getDayA());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("box_cnt", getBoxCnt());
		this.hashColumns.put("ttl_cost_amt", getTtlCostAmt());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("hld_uc_amt_norm", getHldUcAmtNorm());
		this.hashColumns.put("pdm_a", getPdmA());
		this.hashColumns.put("dest_rail_dys", getDestRailDys());
		this.hashColumns.put("pdm_c", getPdmC());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_rail_dys", getOrgRailDys());
		this.hashColumns.put("sub_tot", getSubTot());
		this.hashColumns.put("day_b_pct", getDayBPct());
		this.hashColumns.put("mt_sea_dys", getMtSeaDys());
		this.hashColumns.put("day_a_cost", getDayACost());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ttl_dys", getTtlDys());
		this.hashColumns.put("mt_land", getMtLand());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("avg_dys", getAvgDys());
		this.hashColumns.put("dys_norm", getDysNorm());
		this.hashColumns.put("full_dmt", getFullDmt());
		this.hashColumns.put("hld_uc_amt_norm_adj", getHldUcAmtNormAdj());
		this.hashColumns.put("day_b_cost", getDayBCost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("day_a_pct", "dayAPct");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("day_b", "dayB");
		this.hashFields.put("day_c", "dayC");
		this.hashFields.put("day_a", "dayA");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("box_cnt", "boxCnt");
		this.hashFields.put("ttl_cost_amt", "ttlCostAmt");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("hld_uc_amt_norm", "hldUcAmtNorm");
		this.hashFields.put("pdm_a", "pdmA");
		this.hashFields.put("dest_rail_dys", "destRailDys");
		this.hashFields.put("pdm_c", "pdmC");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_rail_dys", "orgRailDys");
		this.hashFields.put("sub_tot", "subTot");
		this.hashFields.put("day_b_pct", "dayBPct");
		this.hashFields.put("mt_sea_dys", "mtSeaDys");
		this.hashFields.put("day_a_cost", "dayACost");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("mt_land", "mtLand");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("avg_dys", "avgDys");
		this.hashFields.put("dys_norm", "dysNorm");
		this.hashFields.put("full_dmt", "fullDmt");
		this.hashFields.put("hld_uc_amt_norm_adj", "hldUcAmtNormAdj");
		this.hashFields.put("day_b_cost", "dayBCost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dayAPct
	 */
	public String getDayAPct() {
		return this.dayAPct;
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
	 * @return dayB
	 */
	public String getDayB() {
		return this.dayB;
	}
	
	/**
	 * Column Info
	 * @return dayC
	 */
	public String getDayC() {
		return this.dayC;
	}
	
	/**
	 * Column Info
	 * @return dayA
	 */
	public String getDayA() {
		return this.dayA;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return boxCnt
	 */
	public String getBoxCnt() {
		return this.boxCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlCostAmt
	 */
	public String getTtlCostAmt() {
		return this.ttlCostAmt;
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
	 * @return acctNm
	 */
	public String getAcctNm() {
		return this.acctNm;
	}
	
	/**
	 * Column Info
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
	}
	
	/**
	 * Column Info
	 * @return hldUcAmtNorm
	 */
	public String getHldUcAmtNorm() {
		return this.hldUcAmtNorm;
	}
	
	/**
	 * Column Info
	 * @return pdmA
	 */
	public String getPdmA() {
		return this.pdmA;
	}
	
	/**
	 * Column Info
	 * @return destRailDys
	 */
	public String getDestRailDys() {
		return this.destRailDys;
	}
	
	/**
	 * Column Info
	 * @return pdmC
	 */
	public String getPdmC() {
		return this.pdmC;
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
	 * @return orgRailDys
	 */
	public String getOrgRailDys() {
		return this.orgRailDys;
	}
	
	/**
	 * Column Info
	 * @return subTot
	 */
	public String getSubTot() {
		return this.subTot;
	}
	
	/**
	 * Column Info
	 * @return dayBPct
	 */
	public String getDayBPct() {
		return this.dayBPct;
	}
	
	/**
	 * Column Info
	 * @return mtSeaDys
	 */
	public String getMtSeaDys() {
		return this.mtSeaDys;
	}
	
	/**
	 * Column Info
	 * @return dayACost
	 */
	public String getDayACost() {
		return this.dayACost;
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
	 * @return ttlDys
	 */
	public String getTtlDys() {
		return this.ttlDys;
	}
	
	/**
	 * Column Info
	 * @return mtLand
	 */
	public String getMtLand() {
		return this.mtLand;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
	}
	
	/**
	 * Column Info
	 * @return avgDys
	 */
	public String getAvgDys() {
		return this.avgDys;
	}
	
	/**
	 * Column Info
	 * @return dysNorm
	 */
	public String getDysNorm() {
		return this.dysNorm;
	}
	
	/**
	 * Column Info
	 * @return fullDmt
	 */
	public String getFullDmt() {
		return this.fullDmt;
	}
	
	/**
	 * Column Info
	 * @return hldUcAmtNormAdj
	 */
	public String getHldUcAmtNormAdj() {
		return this.hldUcAmtNormAdj;
	}
	
	/**
	 * Column Info
	 * @return dayBCost
	 */
	public String getDayBCost() {
		return this.dayBCost;
	}
	

	/**
	 * Column Info
	 * @param dayAPct
	 */
	public void setDayAPct(String dayAPct) {
		this.dayAPct = dayAPct;
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
	 * @param dayB
	 */
	public void setDayB(String dayB) {
		this.dayB = dayB;
	}
	
	/**
	 * Column Info
	 * @param dayC
	 */
	public void setDayC(String dayC) {
		this.dayC = dayC;
	}
	
	/**
	 * Column Info
	 * @param dayA
	 */
	public void setDayA(String dayA) {
		this.dayA = dayA;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param boxCnt
	 */
	public void setBoxCnt(String boxCnt) {
		this.boxCnt = boxCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlCostAmt
	 */
	public void setTtlCostAmt(String ttlCostAmt) {
		this.ttlCostAmt = ttlCostAmt;
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
	 * @param acctNm
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
	}
	
	/**
	 * Column Info
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
	}
	
	/**
	 * Column Info
	 * @param hldUcAmtNorm
	 */
	public void setHldUcAmtNorm(String hldUcAmtNorm) {
		this.hldUcAmtNorm = hldUcAmtNorm;
	}
	
	/**
	 * Column Info
	 * @param pdmA
	 */
	public void setPdmA(String pdmA) {
		this.pdmA = pdmA;
	}
	
	/**
	 * Column Info
	 * @param destRailDys
	 */
	public void setDestRailDys(String destRailDys) {
		this.destRailDys = destRailDys;
	}
	
	/**
	 * Column Info
	 * @param pdmC
	 */
	public void setPdmC(String pdmC) {
		this.pdmC = pdmC;
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
	 * @param orgRailDys
	 */
	public void setOrgRailDys(String orgRailDys) {
		this.orgRailDys = orgRailDys;
	}
	
	/**
	 * Column Info
	 * @param subTot
	 */
	public void setSubTot(String subTot) {
		this.subTot = subTot;
	}
	
	/**
	 * Column Info
	 * @param dayBPct
	 */
	public void setDayBPct(String dayBPct) {
		this.dayBPct = dayBPct;
	}
	
	/**
	 * Column Info
	 * @param mtSeaDys
	 */
	public void setMtSeaDys(String mtSeaDys) {
		this.mtSeaDys = mtSeaDys;
	}
	
	/**
	 * Column Info
	 * @param dayACost
	 */
	public void setDayACost(String dayACost) {
		this.dayACost = dayACost;
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
	 * @param ttlDys
	 */
	public void setTtlDys(String ttlDys) {
		this.ttlDys = ttlDys;
	}
	
	/**
	 * Column Info
	 * @param mtLand
	 */
	public void setMtLand(String mtLand) {
		this.mtLand = mtLand;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
	}
	
	/**
	 * Column Info
	 * @param avgDys
	 */
	public void setAvgDys(String avgDys) {
		this.avgDys = avgDys;
	}
	
	/**
	 * Column Info
	 * @param dysNorm
	 */
	public void setDysNorm(String dysNorm) {
		this.dysNorm = dysNorm;
	}
	
	/**
	 * Column Info
	 * @param fullDmt
	 */
	public void setFullDmt(String fullDmt) {
		this.fullDmt = fullDmt;
	}
	
	/**
	 * Column Info
	 * @param hldUcAmtNormAdj
	 */
	public void setHldUcAmtNormAdj(String hldUcAmtNormAdj) {
		this.hldUcAmtNormAdj = hldUcAmtNormAdj;
	}
	
	/**
	 * Column Info
	 * @param dayBCost
	 */
	public void setDayBCost(String dayBCost) {
		this.dayBCost = dayBCost;
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
		setDayAPct(JSPUtil.getParameter(request, prefix + "day_a_pct", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDayB(JSPUtil.getParameter(request, prefix + "day_b", ""));
		setDayC(JSPUtil.getParameter(request, prefix + "day_c", ""));
		setDayA(JSPUtil.getParameter(request, prefix + "day_a", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBoxCnt(JSPUtil.getParameter(request, prefix + "box_cnt", ""));
		setTtlCostAmt(JSPUtil.getParameter(request, prefix + "ttl_cost_amt", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setSeaDys(JSPUtil.getParameter(request, prefix + "sea_dys", ""));
		setHldUcAmtNorm(JSPUtil.getParameter(request, prefix + "hld_uc_amt_norm", ""));
		setPdmA(JSPUtil.getParameter(request, prefix + "pdm_a", ""));
		setDestRailDys(JSPUtil.getParameter(request, prefix + "dest_rail_dys", ""));
		setPdmC(JSPUtil.getParameter(request, prefix + "pdm_c", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgRailDys(JSPUtil.getParameter(request, prefix + "org_rail_dys", ""));
		setSubTot(JSPUtil.getParameter(request, prefix + "sub_tot", ""));
		setDayBPct(JSPUtil.getParameter(request, prefix + "day_b_pct", ""));
		setMtSeaDys(JSPUtil.getParameter(request, prefix + "mt_sea_dys", ""));
		setDayACost(JSPUtil.getParameter(request, prefix + "day_a_cost", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setTtlDys(JSPUtil.getParameter(request, prefix + "ttl_dys", ""));
		setMtLand(JSPUtil.getParameter(request, prefix + "mt_land", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setAvgDys(JSPUtil.getParameter(request, prefix + "avg_dys", ""));
		setDysNorm(JSPUtil.getParameter(request, prefix + "dys_norm", ""));
		setFullDmt(JSPUtil.getParameter(request, prefix + "full_dmt", ""));
		setHldUcAmtNormAdj(JSPUtil.getParameter(request, prefix + "hld_uc_amt_norm_adj", ""));
		setDayBCost(JSPUtil.getParameter(request, prefix + "day_b_cost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqCntrHldCostVO[]
	 */
	public EqCntrHldCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqCntrHldCostVO[]
	 */
	public EqCntrHldCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqCntrHldCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dayAPct = (JSPUtil.getParameter(request, prefix	+ "day_a_pct", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dayB = (JSPUtil.getParameter(request, prefix	+ "day_b", length));
			String[] dayC = (JSPUtil.getParameter(request, prefix	+ "day_c", length));
			String[] dayA = (JSPUtil.getParameter(request, prefix	+ "day_a", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] boxCnt = (JSPUtil.getParameter(request, prefix	+ "box_cnt", length));
			String[] ttlCostAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_cost_amt", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] hldUcAmtNorm = (JSPUtil.getParameter(request, prefix	+ "hld_uc_amt_norm", length));
			String[] pdmA = (JSPUtil.getParameter(request, prefix	+ "pdm_a", length));
			String[] destRailDys = (JSPUtil.getParameter(request, prefix	+ "dest_rail_dys", length));
			String[] pdmC = (JSPUtil.getParameter(request, prefix	+ "pdm_c", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgRailDys = (JSPUtil.getParameter(request, prefix	+ "org_rail_dys", length));
			String[] subTot = (JSPUtil.getParameter(request, prefix	+ "sub_tot", length));
			String[] dayBPct = (JSPUtil.getParameter(request, prefix	+ "day_b_pct", length));
			String[] mtSeaDys = (JSPUtil.getParameter(request, prefix	+ "mt_sea_dys", length));
			String[] dayACost = (JSPUtil.getParameter(request, prefix	+ "day_a_cost", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] ttlDys = (JSPUtil.getParameter(request, prefix	+ "ttl_dys", length));
			String[] mtLand = (JSPUtil.getParameter(request, prefix	+ "mt_land", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] avgDys = (JSPUtil.getParameter(request, prefix	+ "avg_dys", length));
			String[] dysNorm = (JSPUtil.getParameter(request, prefix	+ "dys_norm", length));
			String[] fullDmt = (JSPUtil.getParameter(request, prefix	+ "full_dmt", length));
			String[] hldUcAmtNormAdj = (JSPUtil.getParameter(request, prefix	+ "hld_uc_amt_norm_adj", length));
			String[] dayBCost = (JSPUtil.getParameter(request, prefix	+ "day_b_cost", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqCntrHldCostVO();
				if (dayAPct[i] != null)
					model.setDayAPct(dayAPct[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dayB[i] != null)
					model.setDayB(dayB[i]);
				if (dayC[i] != null)
					model.setDayC(dayC[i]);
				if (dayA[i] != null)
					model.setDayA(dayA[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (boxCnt[i] != null)
					model.setBoxCnt(boxCnt[i]);
				if (ttlCostAmt[i] != null)
					model.setTtlCostAmt(ttlCostAmt[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (hldUcAmtNorm[i] != null)
					model.setHldUcAmtNorm(hldUcAmtNorm[i]);
				if (pdmA[i] != null)
					model.setPdmA(pdmA[i]);
				if (destRailDys[i] != null)
					model.setDestRailDys(destRailDys[i]);
				if (pdmC[i] != null)
					model.setPdmC(pdmC[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgRailDys[i] != null)
					model.setOrgRailDys(orgRailDys[i]);
				if (subTot[i] != null)
					model.setSubTot(subTot[i]);
				if (dayBPct[i] != null)
					model.setDayBPct(dayBPct[i]);
				if (mtSeaDys[i] != null)
					model.setMtSeaDys(mtSeaDys[i]);
				if (dayACost[i] != null)
					model.setDayACost(dayACost[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ttlDys[i] != null)
					model.setTtlDys(ttlDys[i]);
				if (mtLand[i] != null)
					model.setMtLand(mtLand[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (avgDys[i] != null)
					model.setAvgDys(avgDys[i]);
				if (dysNorm[i] != null)
					model.setDysNorm(dysNorm[i]);
				if (fullDmt[i] != null)
					model.setFullDmt(fullDmt[i]);
				if (hldUcAmtNormAdj[i] != null)
					model.setHldUcAmtNormAdj(hldUcAmtNormAdj[i]);
				if (dayBCost[i] != null)
					model.setDayBCost(dayBCost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqCntrHldCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqCntrHldCostVO[]
	 */
	public EqCntrHldCostVO[] getEqCntrHldCostVOs(){
		EqCntrHldCostVO[] vos = (EqCntrHldCostVO[])models.toArray(new EqCntrHldCostVO[models.size()]);
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
		this.dayAPct = this.dayAPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayB = this.dayB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayC = this.dayC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayA = this.dayA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boxCnt = this.boxCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCostAmt = this.ttlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldUcAmtNorm = this.hldUcAmtNorm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmA = this.pdmA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRailDys = this.destRailDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmC = this.pdmC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRailDys = this.orgRailDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTot = this.subTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayBPct = this.dayBPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtSeaDys = this.mtSeaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayACost = this.dayACost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys = this.ttlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtLand = this.mtLand .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgDys = this.avgDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dysNorm = this.dysNorm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullDmt = this.fullDmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldUcAmtNormAdj = this.hldUcAmtNormAdj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayBCost = this.dayBCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
