/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ModelConditionVO.java
*@FileTitle      : ModelConditionVO  -> Used to Pre, Constraints Menu 
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.vo;

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
 * @author 성미영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class ModelConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModelConditionVO> models = new ArrayList<ModelConditionVO>();
	
	/* Column Info */
	private String customerCd = null;
	/* Column Info */
	private String periodYr1 = null;
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String approvalCondStatus = null;
	/* Column Info */
	private String periodYr2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String customerCo = null;
	/* Column Info */
	private String contractOffice = null;
	/* Column Info */
	private String periodWk1 = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String periodWk2 = null;
	
	private String customerGrp = null;
	
	private String repTrade = null;
	
	private String sub_trade = null;	

	/* Column Info */
	private String year   = null; //year 
	/* Column Info */
	private String fmStep = null; //fm_step 
	/* Column Info */
	private String toStep = null; //to_step 
	/* Column Info */
	private String intervalTime = null;
	
	
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String pol = null;
	
	private String grpFlg = null;
	private String step = null;
	private String sts = null;
	private String quarter = null;
	private String trdCd = null;
	private String dirCd = null;
	private String ofcCd = null; 
	private String isNewVersion = null;
	private String portCd = null;
	
	
	/* Column Info */
	private String periodYear1 = null;
	/* Column Info */
	private String periodYear2 = null;
	/* Column Info */
	private String periodMonth1 = null;
	/* Column Info */
	private String periodMonth2 = null;

	
	/* Column Info */
	private String year1 = null;
	private String week1 = null;
	private String year2 = null;
	private String week2 = null;
	private String customerGroupCo = null;
	private String customerGroupCd = null;
	private String subtrade = null;
	private String chkCommand = null;
	
	/* Column Info */
	private String tgt_grp_cd = null;
	
	private String sel = null;
	
	private String office = null;
	
	private String rlane_cd = null;
	
	
	
	
	
	public String getIsNewVersion() {
		return isNewVersion;
	}

	public void setIsNewVersion(String isNewVersion) {
		this.isNewVersion = isNewVersion;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getTrdCd() {
		return trdCd;
	}

	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}

	public String getDirCd() {
		return dirCd;
	}

	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getSub_trade() {
		return sub_trade;
	}

	public void setSub_trade(String sub_trade) {
		this.sub_trade = sub_trade;
	}
	

	public Collection<ModelConditionVO> getModels() {
		return models;
	}

	public void setModels(Collection<ModelConditionVO> models) {
		this.models = models;
	}


	public HashMap<String, String> getHashColumns() {
		return hashColumns;
	}

	public void setHashColumns(HashMap<String, String> hashColumns) {
		this.hashColumns = hashColumns;
	}

	public HashMap<String, String> getHashFields() {
		return hashFields;
	}

	public void setHashFields(HashMap<String, String> hashFields) {
		this.hashFields = hashFields;
	}

	public String getRepTrade() {
		return repTrade;
	}

	public void setRepTrade(String repTrade) {
		this.repTrade = repTrade;
	}
	
	public String getFmStep() {
		return fmStep;
	}

	public void setFmStep(String fmStep) {
		this.fmStep = fmStep;
	}

	public String getToStep() {
		return toStep;
	}

	public void setToStep(String toStep) {
		this.toStep = toStep;
	}

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}	
	
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getPortCd() {
		return portCd;
	}
	
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}


	
	public String getPeriodYear1() {
		return periodYear1;
	}

	public void setPeriodYear1(String periodYear1) {
		this.periodYear1 = periodYear1;
	}

	public String getPeriodYear2() {
		return periodYear2;
	}

	public void setPeriodYear2(String periodYear2) {
		this.periodYear2 = periodYear2;
	}

	public String getPeriodMonth1() {
		return periodMonth1;
	}

	public void setPeriodMonth1(String periodMonth1) {
		this.periodMonth1 = periodMonth1;
	}

	public String getPeriodMonth2() {
		return periodMonth2;
	}

	public void setPeriodMonth2(String periodMonth2) {
		this.periodMonth2 = periodMonth2;
	}




	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getWeek1() {
		return week1;
	}

	public void setWeek1(String week1) {
		this.week1 = week1;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getWeek2() {
		return week2;
	}

	public void setWeek2(String week2) {
		this.week2 = week2;
	}

	public String getCustomerGroupCo() {
		return customerGroupCo;
	}

	public void setCustomerGroupCo(String customerGroupCo) {
		this.customerGroupCo = customerGroupCo;
	}

	public String getCustomerGroupCd() {
		return customerGroupCd;
	}

	public void setCustomerGroupCd(String customerGroupCd) {
		this.customerGroupCd = customerGroupCd;
	}

	public String getSubtrade() {
		return subtrade;
	}

	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
	}


	public String getTgt_grp_cd() {
		return tgt_grp_cd;
	}

	public void setTgt_grp_cd(String tgt_grp_cd) {
		this.tgt_grp_cd = tgt_grp_cd;
	}
    
	public String getSel() {
		return sel;
	}
	public void setSel(String sel) {
		this.sel = sel;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getRlane_cd() {
		return rlane_cd;
	}
	public void setRlane_cd(String rlane_cd) {
		this.rlane_cd = rlane_cd;
	}
	
	public String getChkCommand() {
		return chkCommand;
	}

	public void setChkCommand(String chkCommand) {
		this.chkCommand = chkCommand;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModelConditionVO() {}

	public ModelConditionVO(String ibflag, String pagerows, String periodYr1, String periodWk1, String periodYr2, String periodWk2, String contractOffice, String customerCo, String customerCd, String lane, String bound, String salesOffice, String polCd, String approvalCondStatus, String trade, String pol,String year,String fmStep ,String toStep ,String intervalTime, String portCd, String periodYear1, String periodYear2, String periodMonth1, String periodMonth2, String year1, String week1, String year2, String week2, String customerGroupCo, String customerGroupCd, String subtrade, String tgt_grp_cd, String sel, String office, String rlane_cd) {
		this.customerCd = customerCd;
		this.periodYr1 = periodYr1;
		this.salesOffice = salesOffice;
		this.approvalCondStatus = approvalCondStatus;
		this.periodYr2 = periodYr2;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.customerCo = customerCo;
		this.contractOffice = contractOffice;
		this.periodWk1 = periodWk1;
		this.bound = bound;
		this.periodWk2 = periodWk2;
		this.trade = trade;
		this.pol = pol;
		this.year = year;
		this.fmStep = fmStep;
		this.toStep = toStep;
		this.intervalTime = intervalTime;
		this.periodYear1 = periodYear1;
		this.periodYear2 = periodYear2;
		this.periodMonth1 = periodMonth1;
		this.periodMonth2 = periodMonth2;
		this.year1 = year1;
		this.week1 = week1;
		this.year2 = year2;
		this.week2 = week2;
		this.customerGroupCo = customerGroupCo;
		this.customerGroupCd = customerGroupCd;
		this.subtrade = subtrade;
		this.tgt_grp_cd = tgt_grp_cd;
		this.sel = sel; 
		this.office = office;
		this.rlane_cd = rlane_cd;
		
				
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("customerCd", getCustomerCd());
		this.hashColumns.put("period_yr1", getPeriodYr1());
		this.hashColumns.put("salesOffice", getSalesOffice());
		this.hashColumns.put("approvalCondStatus", getApprovalCondStatus());
		this.hashColumns.put("period_yr2", getPeriodYr2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("customerCo", getCustomerCo());
		this.hashColumns.put("contractOffice", getContractOffice());
		this.hashColumns.put("period_wk1", getPeriodWk1());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("period_wk2", getPeriodWk2());
		this.hashColumns.put("customerGrp", getCustomerGrp());		
		this.hashColumns.put("sub_trade", getSub_trade());		
		this.hashColumns.put("rep_trade", getRepTrade());	
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("pol",   getPol());
		this.hashColumns.put("year",   getYear());
		this.hashColumns.put("fmStep", getFmStep());	
		this.hashColumns.put("toStep", getToStep());	
		this.hashColumns.put("intervalTime", getIntervalTime());	
		this.hashColumns.put("grp_flg", getGrpFlg());	
		this.hashColumns.put("step", getStep());	
		this.hashColumns.put("sts", getSts());	
		this.hashColumns.put("quarter", getQuarter());	
		this.hashColumns.put("trd_cd", getTrdCd());	
		this.hashColumns.put("dir_cd", getDirCd());	
		this.hashColumns.put("ofc_cd", getOfcCd());	
		this.hashColumns.put("is_new_version", getIsNewVersion());	
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("period_year1", getPeriodYear1());
		this.hashColumns.put("period_year2", getPeriodYear2());
		this.hashColumns.put("period_month1", getPeriodMonth1());
		this.hashColumns.put("period_month2", getPeriodMonth2());
		this.hashColumns.put("year1", getYear1());	
		this.hashColumns.put("week1", getWeek1());	
		this.hashColumns.put("year2", getYear2());
		this.hashColumns.put("week2", getWeek2());
		this.hashColumns.put("customerGroupCo", getCustomerGroupCo());
		this.hashColumns.put("customerGroupCd", getCustomerGroupCd());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("tgt_grp_cd", getTgt_grp_cd());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("rlane_cd", getRlane_cd());
			
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("customerCd", "customerCd");
		this.hashFields.put("period_yr1", "period_yr1");
		this.hashFields.put("salesOffice", "salesOffice");
		this.hashFields.put("approvalCondStatus", "approvalCondStatus");
		this.hashFields.put("period_yr2", "period_yr2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "pol_cd");
		this.hashFields.put("customerCo", "customerCo");
		this.hashFields.put("contractOffice", "contractOffice");
		this.hashFields.put("period_wk1", "period_wk1");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("period_wk2", "period_wk2");
		this.hashFields.put("customerGrp", "customerGrp");	
		this.hashFields.put("sub_trade", "sub_trade");		
		this.hashFields.put("rep_trade", "rep_trade");	
		this.hashFields.put("trade", "trade");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("grp_flg", "grp_flg");
		this.hashFields.put("step", "step");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("quarter", "quarter");
		this.hashFields.put("trd_cd", "trd_cd");
		this.hashFields.put("dir_cd", "dir_cd");
		this.hashFields.put("ofc_cd", "ofc_cd");
		this.hashFields.put("is_new_version", "is_new_version");
		this.hashFields.put("port_cd", "port_cd");
		this.hashFields.put("period_year1", "periodYear1");
		this.hashFields.put("period_year2", "periodYear2");
		this.hashFields.put("period_month1", "periodMonth1");
		this.hashFields.put("period_month2", "periodMonth2");
		this.hashFields.put("year1", "year1");
		this.hashFields.put("week1", "week1");
		this.hashFields.put("year2", "year2");
		this.hashFields.put("week2", "week2");
		this.hashFields.put("customerGroupCo", "customerGroupCo");
		this.hashFields.put("customerGroupCd", "customerGroupCd");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("tgt_grp_cd", "tgt_grp_cd");
		this.hashFields.put("sel", "sel"); 
		this.hashFields.put("office", "office");
		this.hashFields.put("rlane_cd", "rlane_cd"); 
		
		
		return this.hashFields;
	}
	
	
	
	
	public String getGrpFlg() {
		return grpFlg;
	}

	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getCustomerGrp() {
		return customerGrp;
	}

	public void setCustomerGrp(String customerGrp) {
		this.customerGrp = customerGrp;
	}

	/**
	 * Column Info
	 * @return customerCd
	 */
	public String getCustomerCd() {
		return this.customerCd;
	}
	
	/**
	 * Column Info
	 * @return periodYr1
	 */
	public String getPeriodYr1() {
		return this.periodYr1;
	}
	
	/**
	 * Column Info
	 * @return salesOffice
	 */
	public String getSalesOffice() {
		return this.salesOffice;
	}
	
	/**
	 * Column Info
	 * @return approvalCondStatus
	 */
	public String getApprovalCondStatus() {
		return this.approvalCondStatus;
	}
	
	/**
	 * Column Info
	 * @return periodYr2
	 */
	public String getPeriodYr2() {
		return this.periodYr2;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return customerCo
	 */
	public String getCustomerCo() {
		return this.customerCo;
	}
	
	/**
	 * Column Info
	 * @return contractOffice
	 */
	public String getContractOffice() {
		return this.contractOffice;
	}
	
	/**
	 * Column Info
	 * @return periodWk1
	 */
	public String getPeriodWk1() {
		return this.periodWk1;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return periodWk2
	 */
	public String getPeriodWk2() {
		return this.periodWk2;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @param customerCd
	 */
	public void setCustomerCd(String customerCd) {
		this.customerCd = customerCd;
	}
	
	/**
	 * Column Info
	 * @param periodYr1
	 */
	public void setPeriodYr1(String periodYr1) {
		this.periodYr1 = periodYr1;
	}
	
	/**
	 * Column Info
	 * @param salesOffice
	 */
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	
	/**
	 * Column Info
	 * @param approvalCondStatus
	 */
	public void setApprovalCondStatus(String approvalCondStatus) {
		this.approvalCondStatus = approvalCondStatus;
	}
	
	/**
	 * Column Info
	 * @param periodYr2
	 */
	public void setPeriodYr2(String periodYr2) {
		this.periodYr2 = periodYr2;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param customerCo
	 */
	public void setCustomerCo(String customerCo) {
		this.customerCo = customerCo;
	}
	
	/**
	 * Column Info
	 * @param contractOffice
	 */
	public void setContractOffice(String contractOffice) {
		this.contractOffice = contractOffice;
	}
	
	/**
	 * Column Info
	 * @param periodWk1
	 */
	public void setPeriodWk1(String periodWk1) {
		this.periodWk1 = periodWk1;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param periodWk2
	 */
	public void setPeriodWk2(String periodWk2) {
		this.periodWk2 = periodWk2;
	}
		
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustomerCd(JSPUtil.getParameter(request, "customerCd", ""));
		setPeriodYr1(JSPUtil.getParameter(request, "period_yr1", ""));
		setSalesOffice(JSPUtil.getParameter(request, "salesOffice", ""));
		setApprovalCondStatus(JSPUtil.getParameter(request, "approvalCondStatus", ""));
		setPeriodYr2(JSPUtil.getParameter(request, "period_yr2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCustomerCo(JSPUtil.getParameter(request, "customerCo", ""));
		setContractOffice(JSPUtil.getParameter(request, "contractOffice", ""));
		setPeriodWk1(JSPUtil.getParameter(request, "period_wk1", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setPeriodWk2(JSPUtil.getParameter(request, "period_wk2", ""));
		setCustomerGrp(JSPUtil.getParameter(request, "customerGrp", ""));		
		setRepTrade(JSPUtil.getParameter(request, "rep_trade", ""));
		setSub_trade(JSPUtil.getParameter(request, "sub_trade", ""));	
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setFmStep(JSPUtil.getParameter(request, "fm_step", ""));
		setToStep(JSPUtil.getParameter(request, "to_step", ""));
		setIntervalTime(JSPUtil.getParameter(request, "intervalTime", ""));
		setStep(JSPUtil.getParameter(request, "step", ""));	
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
		setQuarter(JSPUtil.getParameter(request, "quarter", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIsNewVersion(JSPUtil.getParameter(request, "is_new_version", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPeriodYear1(JSPUtil.getParameter(request, "period_year1", ""));
		setPeriodYear2(JSPUtil.getParameter(request, "period_year2", ""));
		setPeriodMonth1(JSPUtil.getParameter(request, "period_month1", ""));
		setPeriodMonth2(JSPUtil.getParameter(request, "period_month2", ""));
		setYear1(JSPUtil.getParameter(request, "year1", ""));
		setWeek1(JSPUtil.getParameter(request, "week1", ""));
		setYear2(JSPUtil.getParameter(request, "year2", ""));
		setWeek2(JSPUtil.getParameter(request, "week2", ""));
		setCustomerGroupCo(JSPUtil.getParameter(request, "customerGroupCo", ""));
		setCustomerGroupCd(JSPUtil.getParameter(request, "customerGroupCd", ""));
		setSubtrade(JSPUtil.getParameter(request, "subtrade", ""));
		setTgt_grp_cd(JSPUtil.getParameter(request, "tgt_grp_cd", ""));
		setSel(JSPUtil.getParameter(request, "sel", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setRlane_cd(JSPUtil.getParameter(request, "rlane_cd", ""));
				
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConditionVO[]
	 */
	public ModelConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConditionVO[]
	 */
	public ModelConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModelConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] customerCd = (JSPUtil.getParameter(request, prefix	+ "customerCd", length));
			String[] periodYr1 = (JSPUtil.getParameter(request, prefix	+ "period_yr1", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "salesOffice", length));
			String[] approvalCondStatus = (JSPUtil.getParameter(request, prefix	+ "approvalCondStatus", length));
			String[] periodYr2 = (JSPUtil.getParameter(request, prefix	+ "period_yr2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] customerCo = (JSPUtil.getParameter(request, prefix	+ "customerCo", length));
			String[] contractOffice = (JSPUtil.getParameter(request, prefix	+ "contractOffice", length));
			String[] periodWk1 = (JSPUtil.getParameter(request, prefix	+ "period_wk1", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] periodWk2 = (JSPUtil.getParameter(request, prefix	+ "period_wk2", length));
			String[] customerGrp = (JSPUtil.getParameter(request, prefix	+ "customerGrp", length));			
			String[] repTrade = (JSPUtil.getParameter(request, prefix	+ "rep_trade", length));
			String[] sub_trade = (JSPUtil.getParameter(request, prefix	+ "sub_trade", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] fmStep = (JSPUtil.getParameter(request, prefix	+ "fmStep", length));
			String[] toStep = (JSPUtil.getParameter(request, prefix	+ "toStep", length));
			String[] intervalTime = (JSPUtil.getParameter(request, prefix	+ "intervalTime", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] step = (JSPUtil.getParameter(request, prefix	+ "step", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] quarter = (JSPUtil.getParameter(request, prefix	+ "quarter", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] isNewVersion = (JSPUtil.getParameter(request, prefix	+ "is_new_version", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] periodYear1 = (JSPUtil.getParameter(request, prefix	+ "period_year1", length));
			String[] periodYear2 = (JSPUtil.getParameter(request, prefix	+ "period_year2", length));
			String[] periodMonth1 = (JSPUtil.getParameter(request, prefix	+ "period_month1", length));
			String[] periodMonth2 = (JSPUtil.getParameter(request, prefix	+ "period_month2", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] rlane_cd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));

			
			
			
			for (int i = 0; i < length; i++) {
				model = new ModelConditionVO();
				if (customerCd[i] != null)
					model.setCustomerCd(customerCd[i]);
				if (periodYr1[i] != null)
					model.setPeriodYr1(periodYr1[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (approvalCondStatus[i] != null)
					model.setApprovalCondStatus(approvalCondStatus[i]);
				if (periodYr2[i] != null)
					model.setPeriodYr2(periodYr2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (customerCo[i] != null)
					model.setCustomerCo(customerCo[i]);
				if (contractOffice[i] != null)
					model.setContractOffice(contractOffice[i]);
				if (periodWk1[i] != null)
					model.setPeriodWk1(periodWk1[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (periodWk2[i] != null)
					model.setPeriodWk2(periodWk2[i]);
				if (customerGrp[i] != null)
					model.setCustomerGrp(customerGrp[i]);
				if (repTrade[i] != null)
					model.setRepTrade(repTrade[i]);				
				if (sub_trade[i] != null)
					model.setSub_trade(sub_trade[i]);	
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);		
				if (year[i] != null)
					model.setYear(year[i]);		
				if (fmStep[i] != null)
					model.setFmStep(fmStep[i]);		
				if (toStep[i] != null)
					model.setToStep(toStep[i]);		
				if (intervalTime[i] != null)
					model.setIntervalTime(intervalTime[i]);		
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);		
				if (step[i] != null)
					model.setStep(step[i]);		
				if (sts[i] != null)
					model.setSts(sts[i]);		
				if (quarter[i] != null)
					model.setQuarter(quarter[i]);		
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);		
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);		
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);		
				if (isNewVersion[i] != null)
					model.setIsNewVersion(isNewVersion[i]);		
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (periodYear1[i] != null)
					model.setPeriodYear1(periodYear1[i]);
				if (periodYear2[i] != null)
					model.setPeriodYear2(periodYear2[i]);
				if (periodMonth1[i] != null)
					model.setPeriodMonth1(periodMonth1[i]);
				if (periodMonth2[i] != null)
					model.setPeriodMonth2(periodMonth2[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (rlane_cd[i] != null)
					model.setRlane_cd(rlane_cd[i]);

					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SqlNameVO[]
	 */
	public ModelConditionVO[] getConditionVOs(){
		ModelConditionVO[] vos = (ModelConditionVO[])models.toArray(new ModelConditionVO[models.size()]);
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
		this.customerCd = this.customerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodYr1 = this.periodYr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalCondStatus = this.approvalCondStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodYr2 = this.periodYr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCo = this.customerCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractOffice = this.contractOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodWk1 = this.periodWk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodWk2 = this.periodWk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerGrp = this.customerGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrade = this.repTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.sub_trade = this.sub_trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmStep = this.fmStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toStep = this.toStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intervalTime = this.intervalTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.step = this.step .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quarter = this.quarter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isNewVersion = this.isNewVersion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlane_cd = this.rlane_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
	}
}
