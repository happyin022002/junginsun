/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DetailRequestExpenseVO.java
*@FileTitle : DetailRequestExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.11 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DetailRequestExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DetailRequestExpenseVO> models = new ArrayList<DetailRequestExpenseVO>();
	
	/* Column Info */
	private String perfUsdYear2 = null;
	/* Column Info */
	private String perfUsdYear3 = null;
	/* Column Info */
	private String exRateAvg = null;
	/* Column Info */
	private String lvl2Name = null;
	/* Column Info */
	private String perfLclPfmAmt = null;
	/* Column Info */
	private String perfUsdYear1 = null;
	/* Column Info */
	private String planUsdRhqAmt = null;
	/* Column Info */
	private String perfLclEstAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String planUsdOfcAmt = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String assiUsdAmt1 = null;
	/* Column Info */
	private String planLclOfcAmt = null;
	/* Column Info */
	private String assiUsdAmt2 = null;
	/* Column Info */
	private String planLclTicAmt = null;
	/* Column Info */
	private String assiUsdYear1 = null;
	/* Column Info */
	private String assiUsdYear2 = null;
	/* Column Info */
	private String lvl1Name = null;
	/* Column Info */
	private String slsOfcFlg = null;
	/* Column Info */
	private String exRatePlanPre = null;
	/* Column Info */
	private String perfUsdAmt1 = null;
	/* Column Info */
	private String rgnOfcFlg = null;
	/* Column Info */
	private String perfUsdAmt2 = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String perfUsdAmt3 = null;
	/* Column Info */
	private String yrmon = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String expnName = null;
	/* Column Info */
	private String planLclComAmt = null;
	/* Column Info */
	private String perfLclPlanAmt = null;
	/* Column Info */
	private String planUsdComAmt = null;
	/* Column Info */
	private String planUsdTicAmt = null;
	/* Column Info */
	private String planLclRhqAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String assiLclYear3 = null;
	/* Column Info */
	private String assiLclYear2 = null;
	/* Column Info */
	private String assiLclYear1 = null;
	/* Column Info */
	private String ofcExpn = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String perfLclYear3 = null;
	/* Column Info */
	private String perfLclYear2 = null;
	/* Column Info */
	private String perfLclYear1 = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String assiLclAmt3 = null;
	/* Column Info */
	private String perfLclAmt3 = null;
	/* Column Info */
	private String perfLclAmt2 = null;
	/* Column Info */
	private String assiLclAmt1 = null;
	/* Column Info */
	private String exRatePlan = null;
	/* Column Info */
	private String assiLclAmt2 = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DetailRequestExpenseVO() {}

	public DetailRequestExpenseVO(String ibflag, String pagerows, String ofcExpn, String loclCurrCd, String rqstUtVal, String yrmon, String ofcCd, String ofcCoDivCd, String rhqOfcCd, String rgnOfcFlg, String slsOfcFlg, String genExpnCd, String expnName, String ticCd, String lvl1Name, String lvl2Name, String exRatePlanPre, String exRateAvg, String exRatePlan, String perfUsdYear1, String perfUsdAmt1, String perfUsdYear2, String perfUsdAmt2, String perfUsdYear3, String perfUsdAmt3, String assiUsdYear1, String assiUsdAmt1, String assiUsdYear2, String assiUsdAmt2, String planUsdComAmt, String planUsdTicAmt, String planUsdRhqAmt, String planUsdOfcAmt, String planLclComAmt, String planLclTicAmt, String planLclRhqAmt, String planLclOfcAmt, String perfLclYear1, String perfLclEstAmt, String perfLclPfmAmt, String perfLclPlanAmt, String perfLclYear2, String perfLclAmt2, String perfLclYear3, String perfLclAmt3, String assiLclYear1, String assiLclAmt1, String assiLclYear2, String assiLclAmt2, String assiLclYear3, String assiLclAmt3) {
		this.perfUsdYear2 = perfUsdYear2;
		this.perfUsdYear3 = perfUsdYear3;
		this.exRateAvg = exRateAvg;
		this.lvl2Name = lvl2Name;
		this.perfLclPfmAmt = perfLclPfmAmt;
		this.perfUsdYear1 = perfUsdYear1;
		this.planUsdRhqAmt = planUsdRhqAmt;
		this.perfLclEstAmt = perfLclEstAmt;
		this.pagerows = pagerows;
		this.planUsdOfcAmt = planUsdOfcAmt;
		this.ofcCoDivCd = ofcCoDivCd;
		this.assiUsdAmt1 = assiUsdAmt1;
		this.planLclOfcAmt = planLclOfcAmt;
		this.assiUsdAmt2 = assiUsdAmt2;
		this.planLclTicAmt = planLclTicAmt;
		this.assiUsdYear1 = assiUsdYear1;
		this.assiUsdYear2 = assiUsdYear2;
		this.lvl1Name = lvl1Name;
		this.slsOfcFlg = slsOfcFlg;
		this.exRatePlanPre = exRatePlanPre;
		this.perfUsdAmt1 = perfUsdAmt1;
		this.rgnOfcFlg = rgnOfcFlg;
		this.perfUsdAmt2 = perfUsdAmt2;
		this.loclCurrCd = loclCurrCd;
		this.perfUsdAmt3 = perfUsdAmt3;
		this.yrmon = yrmon;
		this.rhqOfcCd = rhqOfcCd;
		this.expnName = expnName;
		this.planLclComAmt = planLclComAmt;
		this.perfLclPlanAmt = perfLclPlanAmt;
		this.planUsdComAmt = planUsdComAmt;
		this.planUsdTicAmt = planUsdTicAmt;
		this.planLclRhqAmt = planLclRhqAmt;
		this.ibflag = ibflag;
		this.assiLclYear3 = assiLclYear3;
		this.assiLclYear2 = assiLclYear2;
		this.assiLclYear1 = assiLclYear1;
		this.ofcExpn = ofcExpn;
		this.rqstUtVal = rqstUtVal;
		this.perfLclYear3 = perfLclYear3;
		this.perfLclYear2 = perfLclYear2;
		this.perfLclYear1 = perfLclYear1;
		this.genExpnCd = genExpnCd;
		this.ofcCd = ofcCd;
		this.assiLclAmt3 = assiLclAmt3;
		this.perfLclAmt3 = perfLclAmt3;
		this.perfLclAmt2 = perfLclAmt2;
		this.assiLclAmt1 = assiLclAmt1;
		this.exRatePlan = exRatePlan;
		this.assiLclAmt2 = assiLclAmt2;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("perf_usd_year2", getPerfUsdYear2());
		this.hashColumns.put("perf_usd_year3", getPerfUsdYear3());
		this.hashColumns.put("ex_rate_avg", getExRateAvg());
		this.hashColumns.put("lvl2_name", getLvl2Name());
		this.hashColumns.put("perf_lcl_pfm_amt", getPerfLclPfmAmt());
		this.hashColumns.put("perf_usd_year1", getPerfUsdYear1());
		this.hashColumns.put("plan_usd_rhq_amt", getPlanUsdRhqAmt());
		this.hashColumns.put("perf_lcl_est_amt", getPerfLclEstAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("plan_usd_ofc_amt", getPlanUsdOfcAmt());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("assi_usd_amt1", getAssiUsdAmt1());
		this.hashColumns.put("plan_lcl_ofc_amt", getPlanLclOfcAmt());
		this.hashColumns.put("assi_usd_amt2", getAssiUsdAmt2());
		this.hashColumns.put("plan_lcl_tic_amt", getPlanLclTicAmt());
		this.hashColumns.put("assi_usd_year1", getAssiUsdYear1());
		this.hashColumns.put("assi_usd_year2", getAssiUsdYear2());
		this.hashColumns.put("lvl1_name", getLvl1Name());
		this.hashColumns.put("sls_ofc_flg", getSlsOfcFlg());
		this.hashColumns.put("ex_rate_plan_pre", getExRatePlanPre());
		this.hashColumns.put("perf_usd_amt1", getPerfUsdAmt1());
		this.hashColumns.put("rgn_ofc_flg", getRgnOfcFlg());
		this.hashColumns.put("perf_usd_amt2", getPerfUsdAmt2());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("perf_usd_amt3", getPerfUsdAmt3());
		this.hashColumns.put("yrmon", getYrmon());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("expn_name", getExpnName());
		this.hashColumns.put("plan_lcl_com_amt", getPlanLclComAmt());
		this.hashColumns.put("perf_lcl_plan_amt", getPerfLclPlanAmt());
		this.hashColumns.put("plan_usd_com_amt", getPlanUsdComAmt());
		this.hashColumns.put("plan_usd_tic_amt", getPlanUsdTicAmt());
		this.hashColumns.put("plan_lcl_rhq_amt", getPlanLclRhqAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("assi_lcl_year3", getAssiLclYear3());
		this.hashColumns.put("assi_lcl_year2", getAssiLclYear2());
		this.hashColumns.put("assi_lcl_year1", getAssiLclYear1());
		this.hashColumns.put("ofc_expn", getOfcExpn());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("perf_lcl_year3", getPerfLclYear3());
		this.hashColumns.put("perf_lcl_year2", getPerfLclYear2());
		this.hashColumns.put("perf_lcl_year1", getPerfLclYear1());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("assi_lcl_amt3", getAssiLclAmt3());
		this.hashColumns.put("perf_lcl_amt3", getPerfLclAmt3());
		this.hashColumns.put("perf_lcl_amt2", getPerfLclAmt2());
		this.hashColumns.put("assi_lcl_amt1", getAssiLclAmt1());
		this.hashColumns.put("ex_rate_plan", getExRatePlan());
		this.hashColumns.put("assi_lcl_amt2", getAssiLclAmt2());
		this.hashColumns.put("tic_cd", getTicCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("perf_usd_year2", "perfUsdYear2");
		this.hashFields.put("perf_usd_year3", "perfUsdYear3");
		this.hashFields.put("ex_rate_avg", "exRateAvg");
		this.hashFields.put("lvl2_name", "lvl2Name");
		this.hashFields.put("perf_lcl_pfm_amt", "perfLclPfmAmt");
		this.hashFields.put("perf_usd_year1", "perfUsdYear1");
		this.hashFields.put("plan_usd_rhq_amt", "planUsdRhqAmt");
		this.hashFields.put("perf_lcl_est_amt", "perfLclEstAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("plan_usd_ofc_amt", "planUsdOfcAmt");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("assi_usd_amt1", "assiUsdAmt1");
		this.hashFields.put("plan_lcl_ofc_amt", "planLclOfcAmt");
		this.hashFields.put("assi_usd_amt2", "assiUsdAmt2");
		this.hashFields.put("plan_lcl_tic_amt", "planLclTicAmt");
		this.hashFields.put("assi_usd_year1", "assiUsdYear1");
		this.hashFields.put("assi_usd_year2", "assiUsdYear2");
		this.hashFields.put("lvl1_name", "lvl1Name");
		this.hashFields.put("sls_ofc_flg", "slsOfcFlg");
		this.hashFields.put("ex_rate_plan_pre", "exRatePlanPre");
		this.hashFields.put("perf_usd_amt1", "perfUsdAmt1");
		this.hashFields.put("rgn_ofc_flg", "rgnOfcFlg");
		this.hashFields.put("perf_usd_amt2", "perfUsdAmt2");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("perf_usd_amt3", "perfUsdAmt3");
		this.hashFields.put("yrmon", "yrmon");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("expn_name", "expnName");
		this.hashFields.put("plan_lcl_com_amt", "planLclComAmt");
		this.hashFields.put("perf_lcl_plan_amt", "perfLclPlanAmt");
		this.hashFields.put("plan_usd_com_amt", "planUsdComAmt");
		this.hashFields.put("plan_usd_tic_amt", "planUsdTicAmt");
		this.hashFields.put("plan_lcl_rhq_amt", "planLclRhqAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("assi_lcl_year3", "assiLclYear3");
		this.hashFields.put("assi_lcl_year2", "assiLclYear2");
		this.hashFields.put("assi_lcl_year1", "assiLclYear1");
		this.hashFields.put("ofc_expn", "ofcExpn");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("perf_lcl_year3", "perfLclYear3");
		this.hashFields.put("perf_lcl_year2", "perfLclYear2");
		this.hashFields.put("perf_lcl_year1", "perfLclYear1");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("assi_lcl_amt3", "assiLclAmt3");
		this.hashFields.put("perf_lcl_amt3", "perfLclAmt3");
		this.hashFields.put("perf_lcl_amt2", "perfLclAmt2");
		this.hashFields.put("assi_lcl_amt1", "assiLclAmt1");
		this.hashFields.put("ex_rate_plan", "exRatePlan");
		this.hashFields.put("assi_lcl_amt2", "assiLclAmt2");
		this.hashFields.put("tic_cd", "ticCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return perfUsdYear2
	 */
	public String getPerfUsdYear2() {
		return this.perfUsdYear2;
	}
	
	/**
	 * Column Info
	 * @return perfUsdYear3
	 */
	public String getPerfUsdYear3() {
		return this.perfUsdYear3;
	}
	
	/**
	 * Column Info
	 * @return exRateAvg
	 */
	public String getExRateAvg() {
		return this.exRateAvg;
	}
	
	/**
	 * Column Info
	 * @return lvl2Name
	 */
	public String getLvl2Name() {
		return this.lvl2Name;
	}
	
	/**
	 * Column Info
	 * @return perfLclPfmAmt
	 */
	public String getPerfLclPfmAmt() {
		return this.perfLclPfmAmt;
	}
	
	/**
	 * Column Info
	 * @return perfUsdYear1
	 */
	public String getPerfUsdYear1() {
		return this.perfUsdYear1;
	}
	
	/**
	 * Column Info
	 * @return planUsdRhqAmt
	 */
	public String getPlanUsdRhqAmt() {
		return this.planUsdRhqAmt;
	}
	
	/**
	 * Column Info
	 * @return perfLclEstAmt
	 */
	public String getPerfLclEstAmt() {
		return this.perfLclEstAmt;
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
	 * @return planUsdOfcAmt
	 */
	public String getPlanUsdOfcAmt() {
		return this.planUsdOfcAmt;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @return assiUsdAmt1
	 */
	public String getAssiUsdAmt1() {
		return this.assiUsdAmt1;
	}
	
	/**
	 * Column Info
	 * @return planLclOfcAmt
	 */
	public String getPlanLclOfcAmt() {
		return this.planLclOfcAmt;
	}
	
	/**
	 * Column Info
	 * @return assiUsdAmt2
	 */
	public String getAssiUsdAmt2() {
		return this.assiUsdAmt2;
	}
	
	/**
	 * Column Info
	 * @return planLclTicAmt
	 */
	public String getPlanLclTicAmt() {
		return this.planLclTicAmt;
	}
	
	/**
	 * Column Info
	 * @return assiUsdYear1
	 */
	public String getAssiUsdYear1() {
		return this.assiUsdYear1;
	}
	
	/**
	 * Column Info
	 * @return assiUsdYear2
	 */
	public String getAssiUsdYear2() {
		return this.assiUsdYear2;
	}
	
	/**
	 * Column Info
	 * @return lvl1Name
	 */
	public String getLvl1Name() {
		return this.lvl1Name;
	}
	
	/**
	 * Column Info
	 * @return slsOfcFlg
	 */
	public String getSlsOfcFlg() {
		return this.slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return exRatePlanPre
	 */
	public String getExRatePlanPre() {
		return this.exRatePlanPre;
	}
	
	/**
	 * Column Info
	 * @return perfUsdAmt1
	 */
	public String getPerfUsdAmt1() {
		return this.perfUsdAmt1;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcFlg
	 */
	public String getRgnOfcFlg() {
		return this.rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return perfUsdAmt2
	 */
	public String getPerfUsdAmt2() {
		return this.perfUsdAmt2;
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
	 * @return perfUsdAmt3
	 */
	public String getPerfUsdAmt3() {
		return this.perfUsdAmt3;
	}
	
	/**
	 * Column Info
	 * @return yrmon
	 */
	public String getYrmon() {
		return this.yrmon;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return expnName
	 */
	public String getExpnName() {
		return this.expnName;
	}
	
	/**
	 * Column Info
	 * @return planLclComAmt
	 */
	public String getPlanLclComAmt() {
		return this.planLclComAmt;
	}
	
	/**
	 * Column Info
	 * @return perfLclPlanAmt
	 */
	public String getPerfLclPlanAmt() {
		return this.perfLclPlanAmt;
	}
	
	/**
	 * Column Info
	 * @return planUsdComAmt
	 */
	public String getPlanUsdComAmt() {
		return this.planUsdComAmt;
	}
	
	/**
	 * Column Info
	 * @return planUsdTicAmt
	 */
	public String getPlanUsdTicAmt() {
		return this.planUsdTicAmt;
	}
	
	/**
	 * Column Info
	 * @return planLclRhqAmt
	 */
	public String getPlanLclRhqAmt() {
		return this.planLclRhqAmt;
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
	 * @return assiLclYear3
	 */
	public String getAssiLclYear3() {
		return this.assiLclYear3;
	}
	
	/**
	 * Column Info
	 * @return assiLclYear2
	 */
	public String getAssiLclYear2() {
		return this.assiLclYear2;
	}
	
	/**
	 * Column Info
	 * @return assiLclYear1
	 */
	public String getAssiLclYear1() {
		return this.assiLclYear1;
	}
	
	/**
	 * Column Info
	 * @return ofcExpn
	 */
	public String getOfcExpn() {
		return this.ofcExpn;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return perfLclYear3
	 */
	public String getPerfLclYear3() {
		return this.perfLclYear3;
	}
	
	/**
	 * Column Info
	 * @return perfLclYear2
	 */
	public String getPerfLclYear2() {
		return this.perfLclYear2;
	}
	
	/**
	 * Column Info
	 * @return perfLclYear1
	 */
	public String getPerfLclYear1() {
		return this.perfLclYear1;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
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
	 * @return assiLclAmt3
	 */
	public String getAssiLclAmt3() {
		return this.assiLclAmt3;
	}
	
	/**
	 * Column Info
	 * @return perfLclAmt3
	 */
	public String getPerfLclAmt3() {
		return this.perfLclAmt3;
	}
	
	/**
	 * Column Info
	 * @return perfLclAmt2
	 */
	public String getPerfLclAmt2() {
		return this.perfLclAmt2;
	}
	
	/**
	 * Column Info
	 * @return assiLclAmt1
	 */
	public String getAssiLclAmt1() {
		return this.assiLclAmt1;
	}
	
	/**
	 * Column Info
	 * @return exRatePlan
	 */
	public String getExRatePlan() {
		return this.exRatePlan;
	}
	
	/**
	 * Column Info
	 * @return assiLclAmt2
	 */
	public String getAssiLclAmt2() {
		return this.assiLclAmt2;
	}
	
	/**
	 * Column Info
	 * @return ticCd
	 */
	public String getTicCd() {
		return this.ticCd;
	}
	

	/**
	 * Column Info
	 * @param perfUsdYear2
	 */
	public void setPerfUsdYear2(String perfUsdYear2) {
		this.perfUsdYear2 = perfUsdYear2;
	}
	
	/**
	 * Column Info
	 * @param perfUsdYear3
	 */
	public void setPerfUsdYear3(String perfUsdYear3) {
		this.perfUsdYear3 = perfUsdYear3;
	}
	
	/**
	 * Column Info
	 * @param exRateAvg
	 */
	public void setExRateAvg(String exRateAvg) {
		this.exRateAvg = exRateAvg;
	}
	
	/**
	 * Column Info
	 * @param lvl2Name
	 */
	public void setLvl2Name(String lvl2Name) {
		this.lvl2Name = lvl2Name;
	}
	
	/**
	 * Column Info
	 * @param perfLclPfmAmt
	 */
	public void setPerfLclPfmAmt(String perfLclPfmAmt) {
		this.perfLclPfmAmt = perfLclPfmAmt;
	}
	
	/**
	 * Column Info
	 * @param perfUsdYear1
	 */
	public void setPerfUsdYear1(String perfUsdYear1) {
		this.perfUsdYear1 = perfUsdYear1;
	}
	
	/**
	 * Column Info
	 * @param planUsdRhqAmt
	 */
	public void setPlanUsdRhqAmt(String planUsdRhqAmt) {
		this.planUsdRhqAmt = planUsdRhqAmt;
	}
	
	/**
	 * Column Info
	 * @param perfLclEstAmt
	 */
	public void setPerfLclEstAmt(String perfLclEstAmt) {
		this.perfLclEstAmt = perfLclEstAmt;
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
	 * @param planUsdOfcAmt
	 */
	public void setPlanUsdOfcAmt(String planUsdOfcAmt) {
		this.planUsdOfcAmt = planUsdOfcAmt;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @param assiUsdAmt1
	 */
	public void setAssiUsdAmt1(String assiUsdAmt1) {
		this.assiUsdAmt1 = assiUsdAmt1;
	}
	
	/**
	 * Column Info
	 * @param planLclOfcAmt
	 */
	public void setPlanLclOfcAmt(String planLclOfcAmt) {
		this.planLclOfcAmt = planLclOfcAmt;
	}
	
	/**
	 * Column Info
	 * @param assiUsdAmt2
	 */
	public void setAssiUsdAmt2(String assiUsdAmt2) {
		this.assiUsdAmt2 = assiUsdAmt2;
	}
	
	/**
	 * Column Info
	 * @param planLclTicAmt
	 */
	public void setPlanLclTicAmt(String planLclTicAmt) {
		this.planLclTicAmt = planLclTicAmt;
	}
	
	/**
	 * Column Info
	 * @param assiUsdYear1
	 */
	public void setAssiUsdYear1(String assiUsdYear1) {
		this.assiUsdYear1 = assiUsdYear1;
	}
	
	/**
	 * Column Info
	 * @param assiUsdYear2
	 */
	public void setAssiUsdYear2(String assiUsdYear2) {
		this.assiUsdYear2 = assiUsdYear2;
	}
	
	/**
	 * Column Info
	 * @param lvl1Name
	 */
	public void setLvl1Name(String lvl1Name) {
		this.lvl1Name = lvl1Name;
	}
	
	/**
	 * Column Info
	 * @param slsOfcFlg
	 */
	public void setSlsOfcFlg(String slsOfcFlg) {
		this.slsOfcFlg = slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param exRatePlanPre
	 */
	public void setExRatePlanPre(String exRatePlanPre) {
		this.exRatePlanPre = exRatePlanPre;
	}
	
	/**
	 * Column Info
	 * @param perfUsdAmt1
	 */
	public void setPerfUsdAmt1(String perfUsdAmt1) {
		this.perfUsdAmt1 = perfUsdAmt1;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcFlg
	 */
	public void setRgnOfcFlg(String rgnOfcFlg) {
		this.rgnOfcFlg = rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param perfUsdAmt2
	 */
	public void setPerfUsdAmt2(String perfUsdAmt2) {
		this.perfUsdAmt2 = perfUsdAmt2;
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
	 * @param perfUsdAmt3
	 */
	public void setPerfUsdAmt3(String perfUsdAmt3) {
		this.perfUsdAmt3 = perfUsdAmt3;
	}
	
	/**
	 * Column Info
	 * @param yrmon
	 */
	public void setYrmon(String yrmon) {
		this.yrmon = yrmon;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param expnName
	 */
	public void setExpnName(String expnName) {
		this.expnName = expnName;
	}
	
	/**
	 * Column Info
	 * @param planLclComAmt
	 */
	public void setPlanLclComAmt(String planLclComAmt) {
		this.planLclComAmt = planLclComAmt;
	}
	
	/**
	 * Column Info
	 * @param perfLclPlanAmt
	 */
	public void setPerfLclPlanAmt(String perfLclPlanAmt) {
		this.perfLclPlanAmt = perfLclPlanAmt;
	}
	
	/**
	 * Column Info
	 * @param planUsdComAmt
	 */
	public void setPlanUsdComAmt(String planUsdComAmt) {
		this.planUsdComAmt = planUsdComAmt;
	}
	
	/**
	 * Column Info
	 * @param planUsdTicAmt
	 */
	public void setPlanUsdTicAmt(String planUsdTicAmt) {
		this.planUsdTicAmt = planUsdTicAmt;
	}
	
	/**
	 * Column Info
	 * @param planLclRhqAmt
	 */
	public void setPlanLclRhqAmt(String planLclRhqAmt) {
		this.planLclRhqAmt = planLclRhqAmt;
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
	 * @param assiLclYear3
	 */
	public void setAssiLclYear3(String assiLclYear3) {
		this.assiLclYear3 = assiLclYear3;
	}
	
	/**
	 * Column Info
	 * @param assiLclYear2
	 */
	public void setAssiLclYear2(String assiLclYear2) {
		this.assiLclYear2 = assiLclYear2;
	}
	
	/**
	 * Column Info
	 * @param assiLclYear1
	 */
	public void setAssiLclYear1(String assiLclYear1) {
		this.assiLclYear1 = assiLclYear1;
	}
	
	/**
	 * Column Info
	 * @param ofcExpn
	 */
	public void setOfcExpn(String ofcExpn) {
		this.ofcExpn = ofcExpn;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param perfLclYear3
	 */
	public void setPerfLclYear3(String perfLclYear3) {
		this.perfLclYear3 = perfLclYear3;
	}
	
	/**
	 * Column Info
	 * @param perfLclYear2
	 */
	public void setPerfLclYear2(String perfLclYear2) {
		this.perfLclYear2 = perfLclYear2;
	}
	
	/**
	 * Column Info
	 * @param perfLclYear1
	 */
	public void setPerfLclYear1(String perfLclYear1) {
		this.perfLclYear1 = perfLclYear1;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
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
	 * @param assiLclAmt3
	 */
	public void setAssiLclAmt3(String assiLclAmt3) {
		this.assiLclAmt3 = assiLclAmt3;
	}
	
	/**
	 * Column Info
	 * @param perfLclAmt3
	 */
	public void setPerfLclAmt3(String perfLclAmt3) {
		this.perfLclAmt3 = perfLclAmt3;
	}
	
	/**
	 * Column Info
	 * @param perfLclAmt2
	 */
	public void setPerfLclAmt2(String perfLclAmt2) {
		this.perfLclAmt2 = perfLclAmt2;
	}
	
	/**
	 * Column Info
	 * @param assiLclAmt1
	 */
	public void setAssiLclAmt1(String assiLclAmt1) {
		this.assiLclAmt1 = assiLclAmt1;
	}
	
	/**
	 * Column Info
	 * @param exRatePlan
	 */
	public void setExRatePlan(String exRatePlan) {
		this.exRatePlan = exRatePlan;
	}
	
	/**
	 * Column Info
	 * @param assiLclAmt2
	 */
	public void setAssiLclAmt2(String assiLclAmt2) {
		this.assiLclAmt2 = assiLclAmt2;
	}
	
	/**
	 * Column Info
	 * @param ticCd
	 */
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPerfUsdYear2(JSPUtil.getParameter(request, "perf_usd_year2", ""));
		setPerfUsdYear3(JSPUtil.getParameter(request, "perf_usd_year3", ""));
		setExRateAvg(JSPUtil.getParameter(request, "ex_rate_avg", ""));
		setLvl2Name(JSPUtil.getParameter(request, "lvl2_name", ""));
		setPerfLclPfmAmt(JSPUtil.getParameter(request, "perf_lcl_pfm_amt", ""));
		setPerfUsdYear1(JSPUtil.getParameter(request, "perf_usd_year1", ""));
		setPlanUsdRhqAmt(JSPUtil.getParameter(request, "plan_usd_rhq_amt", ""));
		setPerfLclEstAmt(JSPUtil.getParameter(request, "perf_lcl_est_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPlanUsdOfcAmt(JSPUtil.getParameter(request, "plan_usd_ofc_amt", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, "ofc_co_div_cd", ""));
		setAssiUsdAmt1(JSPUtil.getParameter(request, "assi_usd_amt1", ""));
		setPlanLclOfcAmt(JSPUtil.getParameter(request, "plan_lcl_ofc_amt", ""));
		setAssiUsdAmt2(JSPUtil.getParameter(request, "assi_usd_amt2", ""));
		setPlanLclTicAmt(JSPUtil.getParameter(request, "plan_lcl_tic_amt", ""));
		setAssiUsdYear1(JSPUtil.getParameter(request, "assi_usd_year1", ""));
		setAssiUsdYear2(JSPUtil.getParameter(request, "assi_usd_year2", ""));
		setLvl1Name(JSPUtil.getParameter(request, "lvl1_name", ""));
		setSlsOfcFlg(JSPUtil.getParameter(request, "sls_ofc_flg", ""));
		setExRatePlanPre(JSPUtil.getParameter(request, "ex_rate_plan_pre", ""));
		setPerfUsdAmt1(JSPUtil.getParameter(request, "perf_usd_amt1", ""));
		setRgnOfcFlg(JSPUtil.getParameter(request, "rgn_ofc_flg", ""));
		setPerfUsdAmt2(JSPUtil.getParameter(request, "perf_usd_amt2", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setPerfUsdAmt3(JSPUtil.getParameter(request, "perf_usd_amt3", ""));
		setYrmon(JSPUtil.getParameter(request, "yrmon", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, "rhq_ofc_cd", ""));
		setExpnName(JSPUtil.getParameter(request, "expn_name", ""));
		setPlanLclComAmt(JSPUtil.getParameter(request, "plan_lcl_com_amt", ""));
		setPerfLclPlanAmt(JSPUtil.getParameter(request, "perf_lcl_plan_amt", ""));
		setPlanUsdComAmt(JSPUtil.getParameter(request, "plan_usd_com_amt", ""));
		setPlanUsdTicAmt(JSPUtil.getParameter(request, "plan_usd_tic_amt", ""));
		setPlanLclRhqAmt(JSPUtil.getParameter(request, "plan_lcl_rhq_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAssiLclYear3(JSPUtil.getParameter(request, "assi_lcl_year3", ""));
		setAssiLclYear2(JSPUtil.getParameter(request, "assi_lcl_year2", ""));
		setAssiLclYear1(JSPUtil.getParameter(request, "assi_lcl_year1", ""));
		setOfcExpn(JSPUtil.getParameter(request, "ofc_expn", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setPerfLclYear3(JSPUtil.getParameter(request, "perf_lcl_year3", ""));
		setPerfLclYear2(JSPUtil.getParameter(request, "perf_lcl_year2", ""));
		setPerfLclYear1(JSPUtil.getParameter(request, "perf_lcl_year1", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setAssiLclAmt3(JSPUtil.getParameter(request, "assi_lcl_amt3", ""));
		setPerfLclAmt3(JSPUtil.getParameter(request, "perf_lcl_amt3", ""));
		setPerfLclAmt2(JSPUtil.getParameter(request, "perf_lcl_amt2", ""));
		setAssiLclAmt1(JSPUtil.getParameter(request, "assi_lcl_amt1", ""));
		setExRatePlan(JSPUtil.getParameter(request, "ex_rate_plan", ""));
		setAssiLclAmt2(JSPUtil.getParameter(request, "assi_lcl_amt2", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DetailRequestExpenseVO[]
	 */
	public DetailRequestExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DetailRequestExpenseVO[]
	 */
	public DetailRequestExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DetailRequestExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] perfUsdYear2 = (JSPUtil.getParameter(request, prefix	+ "perf_usd_year2", length));
			String[] perfUsdYear3 = (JSPUtil.getParameter(request, prefix	+ "perf_usd_year3", length));
			String[] exRateAvg = (JSPUtil.getParameter(request, prefix	+ "ex_rate_avg", length));
			String[] lvl2Name = (JSPUtil.getParameter(request, prefix	+ "lvl2_name", length));
			String[] perfLclPfmAmt = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_pfm_amt", length));
			String[] perfUsdYear1 = (JSPUtil.getParameter(request, prefix	+ "perf_usd_year1", length));
			String[] planUsdRhqAmt = (JSPUtil.getParameter(request, prefix	+ "plan_usd_rhq_amt", length));
			String[] perfLclEstAmt = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_est_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] planUsdOfcAmt = (JSPUtil.getParameter(request, prefix	+ "plan_usd_ofc_amt", length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd", length));
			String[] assiUsdAmt1 = (JSPUtil.getParameter(request, prefix	+ "assi_usd_amt1", length));
			String[] planLclOfcAmt = (JSPUtil.getParameter(request, prefix	+ "plan_lcl_ofc_amt", length));
			String[] assiUsdAmt2 = (JSPUtil.getParameter(request, prefix	+ "assi_usd_amt2", length));
			String[] planLclTicAmt = (JSPUtil.getParameter(request, prefix	+ "plan_lcl_tic_amt", length));
			String[] assiUsdYear1 = (JSPUtil.getParameter(request, prefix	+ "assi_usd_year1", length));
			String[] assiUsdYear2 = (JSPUtil.getParameter(request, prefix	+ "assi_usd_year2", length));
			String[] lvl1Name = (JSPUtil.getParameter(request, prefix	+ "lvl1_name", length));
			String[] slsOfcFlg = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_flg", length));
			String[] exRatePlanPre = (JSPUtil.getParameter(request, prefix	+ "ex_rate_plan_pre", length));
			String[] perfUsdAmt1 = (JSPUtil.getParameter(request, prefix	+ "perf_usd_amt1", length));
			String[] rgnOfcFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_flg", length));
			String[] perfUsdAmt2 = (JSPUtil.getParameter(request, prefix	+ "perf_usd_amt2", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] perfUsdAmt3 = (JSPUtil.getParameter(request, prefix	+ "perf_usd_amt3", length));
			String[] yrmon = (JSPUtil.getParameter(request, prefix	+ "yrmon", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] expnName = (JSPUtil.getParameter(request, prefix	+ "expn_name", length));
			String[] planLclComAmt = (JSPUtil.getParameter(request, prefix	+ "plan_lcl_com_amt", length));
			String[] perfLclPlanAmt = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_plan_amt", length));
			String[] planUsdComAmt = (JSPUtil.getParameter(request, prefix	+ "plan_usd_com_amt", length));
			String[] planUsdTicAmt = (JSPUtil.getParameter(request, prefix	+ "plan_usd_tic_amt", length));
			String[] planLclRhqAmt = (JSPUtil.getParameter(request, prefix	+ "plan_lcl_rhq_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] assiLclYear3 = (JSPUtil.getParameter(request, prefix	+ "assi_lcl_year3", length));
			String[] assiLclYear2 = (JSPUtil.getParameter(request, prefix	+ "assi_lcl_year2", length));
			String[] assiLclYear1 = (JSPUtil.getParameter(request, prefix	+ "assi_lcl_year1", length));
			String[] ofcExpn = (JSPUtil.getParameter(request, prefix	+ "ofc_expn", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] perfLclYear3 = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_year3", length));
			String[] perfLclYear2 = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_year2", length));
			String[] perfLclYear1 = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_year1", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] assiLclAmt3 = (JSPUtil.getParameter(request, prefix	+ "assi_lcl_amt3", length));
			String[] perfLclAmt3 = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_amt3", length));
			String[] perfLclAmt2 = (JSPUtil.getParameter(request, prefix	+ "perf_lcl_amt2", length));
			String[] assiLclAmt1 = (JSPUtil.getParameter(request, prefix	+ "assi_lcl_amt1", length));
			String[] exRatePlan = (JSPUtil.getParameter(request, prefix	+ "ex_rate_plan", length));
			String[] assiLclAmt2 = (JSPUtil.getParameter(request, prefix	+ "assi_lcl_amt2", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DetailRequestExpenseVO();
				if (perfUsdYear2[i] != null)
					model.setPerfUsdYear2(perfUsdYear2[i]);
				if (perfUsdYear3[i] != null)
					model.setPerfUsdYear3(perfUsdYear3[i]);
				if (exRateAvg[i] != null)
					model.setExRateAvg(exRateAvg[i]);
				if (lvl2Name[i] != null)
					model.setLvl2Name(lvl2Name[i]);
				if (perfLclPfmAmt[i] != null)
					model.setPerfLclPfmAmt(perfLclPfmAmt[i]);
				if (perfUsdYear1[i] != null)
					model.setPerfUsdYear1(perfUsdYear1[i]);
				if (planUsdRhqAmt[i] != null)
					model.setPlanUsdRhqAmt(planUsdRhqAmt[i]);
				if (perfLclEstAmt[i] != null)
					model.setPerfLclEstAmt(perfLclEstAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (planUsdOfcAmt[i] != null)
					model.setPlanUsdOfcAmt(planUsdOfcAmt[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (assiUsdAmt1[i] != null)
					model.setAssiUsdAmt1(assiUsdAmt1[i]);
				if (planLclOfcAmt[i] != null)
					model.setPlanLclOfcAmt(planLclOfcAmt[i]);
				if (assiUsdAmt2[i] != null)
					model.setAssiUsdAmt2(assiUsdAmt2[i]);
				if (planLclTicAmt[i] != null)
					model.setPlanLclTicAmt(planLclTicAmt[i]);
				if (assiUsdYear1[i] != null)
					model.setAssiUsdYear1(assiUsdYear1[i]);
				if (assiUsdYear2[i] != null)
					model.setAssiUsdYear2(assiUsdYear2[i]);
				if (lvl1Name[i] != null)
					model.setLvl1Name(lvl1Name[i]);
				if (slsOfcFlg[i] != null)
					model.setSlsOfcFlg(slsOfcFlg[i]);
				if (exRatePlanPre[i] != null)
					model.setExRatePlanPre(exRatePlanPre[i]);
				if (perfUsdAmt1[i] != null)
					model.setPerfUsdAmt1(perfUsdAmt1[i]);
				if (rgnOfcFlg[i] != null)
					model.setRgnOfcFlg(rgnOfcFlg[i]);
				if (perfUsdAmt2[i] != null)
					model.setPerfUsdAmt2(perfUsdAmt2[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (perfUsdAmt3[i] != null)
					model.setPerfUsdAmt3(perfUsdAmt3[i]);
				if (yrmon[i] != null)
					model.setYrmon(yrmon[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (expnName[i] != null)
					model.setExpnName(expnName[i]);
				if (planLclComAmt[i] != null)
					model.setPlanLclComAmt(planLclComAmt[i]);
				if (perfLclPlanAmt[i] != null)
					model.setPerfLclPlanAmt(perfLclPlanAmt[i]);
				if (planUsdComAmt[i] != null)
					model.setPlanUsdComAmt(planUsdComAmt[i]);
				if (planUsdTicAmt[i] != null)
					model.setPlanUsdTicAmt(planUsdTicAmt[i]);
				if (planLclRhqAmt[i] != null)
					model.setPlanLclRhqAmt(planLclRhqAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (assiLclYear3[i] != null)
					model.setAssiLclYear3(assiLclYear3[i]);
				if (assiLclYear2[i] != null)
					model.setAssiLclYear2(assiLclYear2[i]);
				if (assiLclYear1[i] != null)
					model.setAssiLclYear1(assiLclYear1[i]);
				if (ofcExpn[i] != null)
					model.setOfcExpn(ofcExpn[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (perfLclYear3[i] != null)
					model.setPerfLclYear3(perfLclYear3[i]);
				if (perfLclYear2[i] != null)
					model.setPerfLclYear2(perfLclYear2[i]);
				if (perfLclYear1[i] != null)
					model.setPerfLclYear1(perfLclYear1[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (assiLclAmt3[i] != null)
					model.setAssiLclAmt3(assiLclAmt3[i]);
				if (perfLclAmt3[i] != null)
					model.setPerfLclAmt3(perfLclAmt3[i]);
				if (perfLclAmt2[i] != null)
					model.setPerfLclAmt2(perfLclAmt2[i]);
				if (assiLclAmt1[i] != null)
					model.setAssiLclAmt1(assiLclAmt1[i]);
				if (exRatePlan[i] != null)
					model.setExRatePlan(exRatePlan[i]);
				if (assiLclAmt2[i] != null)
					model.setAssiLclAmt2(assiLclAmt2[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDetailRequestExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DetailRequestExpenseVO[]
	 */
	public DetailRequestExpenseVO[] getDetailRequestExpenseVOs(){
		DetailRequestExpenseVO[] vos = (DetailRequestExpenseVO[])models.toArray(new DetailRequestExpenseVO[models.size()]);
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
		this.perfUsdYear2 = this.perfUsdYear2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfUsdYear3 = this.perfUsdYear3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRateAvg = this.exRateAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl2Name = this.lvl2Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclPfmAmt = this.perfLclPfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfUsdYear1 = this.perfUsdYear1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planUsdRhqAmt = this.planUsdRhqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclEstAmt = this.perfLclEstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planUsdOfcAmt = this.planUsdOfcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiUsdAmt1 = this.assiUsdAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planLclOfcAmt = this.planLclOfcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiUsdAmt2 = this.assiUsdAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planLclTicAmt = this.planLclTicAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiUsdYear1 = this.assiUsdYear1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiUsdYear2 = this.assiUsdYear2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl1Name = this.lvl1Name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcFlg = this.slsOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRatePlanPre = this.exRatePlanPre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfUsdAmt1 = this.perfUsdAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcFlg = this.rgnOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfUsdAmt2 = this.perfUsdAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfUsdAmt3 = this.perfUsdAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmon = this.yrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnName = this.expnName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planLclComAmt = this.planLclComAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclPlanAmt = this.perfLclPlanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planUsdComAmt = this.planUsdComAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planUsdTicAmt = this.planUsdTicAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planLclRhqAmt = this.planLclRhqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiLclYear3 = this.assiLclYear3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiLclYear2 = this.assiLclYear2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiLclYear1 = this.assiLclYear1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcExpn = this.ofcExpn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclYear3 = this.perfLclYear3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclYear2 = this.perfLclYear2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclYear1 = this.perfLclYear1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiLclAmt3 = this.assiLclAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclAmt3 = this.perfLclAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfLclAmt2 = this.perfLclAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiLclAmt1 = this.assiLclAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRatePlan = this.exRatePlan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assiLclAmt2 = this.assiLclAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
