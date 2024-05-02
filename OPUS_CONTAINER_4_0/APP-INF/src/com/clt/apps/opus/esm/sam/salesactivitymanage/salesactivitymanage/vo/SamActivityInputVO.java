/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamActivityInputVO.java
*@FileTitle : SamActivityInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.06.21 이관샨 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo;

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
 * @author 이관샨
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamActivityInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamActivityInputVO> models = new ArrayList<SamActivityInputVO>();
	
	/* Column Info */
	private String mgrComment = null;
	/* Column Info */
	private String customerCd = null;
	/* Column Info */
	private String officeCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String purpose = null;
	/* Column Info */
	private String searchType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String purpose1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slsCode = null;
	/* Column Info */
	private String purpose2 = null;
	/* Column Info */
	private String cusName = null;
	/* Column Info */
	private String srepCmtDesc = null;
	/* Column Info */
	private String activity = null;
	/* Column Info */
	private String slsMgrCmtDesc = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String actualDt = null;
	/* Column Info */
	private String slsName = null;
	/* Column Info */
	private String teamCd = null;
	/* Column Info */
	private String planDt = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String callReport = null;
	/* Column Info */
	private String activityNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String salesRepCd = null;
	/* Column Info */
	private String cusCode = null;
	/* Column Info */
	private String channel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamActivityInputVO() {}

	public SamActivityInputVO(String ibflag, String pagerows, String activityNo, String slsCode, String slsName, String cusCode, String cusName, String mgrComment, String purpose, String callReport, String planDt, String actualDt, String creDt, String creUsrId, String custLglEngNm, String srepCmtDesc, String slsMgrCmtDesc, String purpose1, String purpose2, String channel, String officeCd, String salesRepCd, String teamCd, String searchType, String status, String toDate, String fromDate, String activity, String customerCd) {
		this.mgrComment = mgrComment;
		this.customerCd = customerCd;
		this.officeCd = officeCd;
		this.creDt = creDt;
		this.purpose = purpose;
		this.searchType = searchType;
		this.pagerows = pagerows;
		this.purpose1 = purpose1;
		this.ibflag = ibflag;
		this.slsCode = slsCode;
		this.purpose2 = purpose2;
		this.cusName = cusName;
		this.srepCmtDesc = srepCmtDesc;
		this.activity = activity;
		this.slsMgrCmtDesc = slsMgrCmtDesc;
		this.status = status;
		this.actualDt = actualDt;
		this.slsName = slsName;
		this.teamCd = teamCd;
		this.planDt = planDt;
		this.toDate = toDate;
		this.custLglEngNm = custLglEngNm;
		this.callReport = callReport;
		this.activityNo = activityNo;
		this.creUsrId = creUsrId;
		this.fromDate = fromDate;
		this.salesRepCd = salesRepCd;
		this.cusCode = cusCode;
		this.channel = channel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mgr_comment", getMgrComment());
		this.hashColumns.put("customer_cd", getCustomerCd());
		this.hashColumns.put("office_cd", getOfficeCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("purpose", getPurpose());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("purpose1", getPurpose1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_code", getSlsCode());
		this.hashColumns.put("purpose2", getPurpose2());
		this.hashColumns.put("cus_name", getCusName());
		this.hashColumns.put("srep_cmt_desc", getSrepCmtDesc());
		this.hashColumns.put("activity", getActivity());
		this.hashColumns.put("sls_mgr_cmt_desc", getSlsMgrCmtDesc());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("actual_dt", getActualDt());
		this.hashColumns.put("sls_name", getSlsName());
		this.hashColumns.put("team_cd", getTeamCd());
		this.hashColumns.put("plan_dt", getPlanDt());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("call_report", getCallReport());
		this.hashColumns.put("activity_no", getActivityNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("sales_rep_cd", getSalesRepCd());
		this.hashColumns.put("cus_code", getCusCode());
		this.hashColumns.put("channel", getChannel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mgr_comment", "mgrComment");
		this.hashFields.put("customer_cd", "customerCd");
		this.hashFields.put("office_cd", "officeCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("purpose", "purpose");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("purpose1", "purpose1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_code", "slsCode");
		this.hashFields.put("purpose2", "purpose2");
		this.hashFields.put("cus_name", "cusName");
		this.hashFields.put("srep_cmt_desc", "srepCmtDesc");
		this.hashFields.put("activity", "activity");
		this.hashFields.put("sls_mgr_cmt_desc", "slsMgrCmtDesc");
		this.hashFields.put("status", "status");
		this.hashFields.put("actual_dt", "actualDt");
		this.hashFields.put("sls_name", "slsName");
		this.hashFields.put("team_cd", "teamCd");
		this.hashFields.put("plan_dt", "planDt");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("call_report", "callReport");
		this.hashFields.put("activity_no", "activityNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("sales_rep_cd", "salesRepCd");
		this.hashFields.put("cus_code", "cusCode");
		this.hashFields.put("channel", "channel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mgrComment
	 */
	public String getMgrComment() {
		return this.mgrComment;
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
	 * @return officeCd
	 */
	public String getOfficeCd() {
		return this.officeCd;
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
	 * @return purpose
	 */
	public String getPurpose() {
		return this.purpose;
	}
	
	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
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
	 * @return purpose1
	 */
	public String getPurpose1() {
		return this.purpose1;
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
	 * @return slsCode
	 */
	public String getSlsCode() {
		return this.slsCode;
	}
	
	/**
	 * Column Info
	 * @return purpose2
	 */
	public String getPurpose2() {
		return this.purpose2;
	}
	
	/**
	 * Column Info
	 * @return cusName
	 */
	public String getCusName() {
		return this.cusName;
	}
	
	/**
	 * Column Info
	 * @return srepCmtDesc
	 */
	public String getSrepCmtDesc() {
		return this.srepCmtDesc;
	}
	
	/**
	 * Column Info
	 * @return activity
	 */
	public String getActivity() {
		return this.activity;
	}
	
	/**
	 * Column Info
	 * @return slsMgrCmtDesc
	 */
	public String getSlsMgrCmtDesc() {
		return this.slsMgrCmtDesc;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return actualDt
	 */
	public String getActualDt() {
		return this.actualDt;
	}
	
	/**
	 * Column Info
	 * @return slsName
	 */
	public String getSlsName() {
		return this.slsName;
	}
	
	/**
	 * Column Info
	 * @return teamCd
	 */
	public String getTeamCd() {
		return this.teamCd;
	}
	
	/**
	 * Column Info
	 * @return planDt
	 */
	public String getPlanDt() {
		return this.planDt;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return callReport
	 */
	public String getCallReport() {
		return this.callReport;
	}
	
	/**
	 * Column Info
	 * @return activityNo
	 */
	public String getActivityNo() {
		return this.activityNo;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return salesRepCd
	 */
	public String getSalesRepCd() {
		return this.salesRepCd;
	}
	
	/**
	 * Column Info
	 * @return cusCode
	 */
	public String getCusCode() {
		return this.cusCode;
	}
	
	/**
	 * Column Info
	 * @return channel
	 */
	public String getChannel() {
		return this.channel;
	}
	

	/**
	 * Column Info
	 * @param mgrComment
	 */
	public void setMgrComment(String mgrComment) {
		this.mgrComment = mgrComment;
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
	 * @param officeCd
	 */
	public void setOfficeCd(String officeCd) {
		this.officeCd = officeCd;
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
	 * @param purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
	 * @param purpose1
	 */
	public void setPurpose1(String purpose1) {
		this.purpose1 = purpose1;
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
	 * @param slsCode
	 */
	public void setSlsCode(String slsCode) {
		this.slsCode = slsCode;
	}
	
	/**
	 * Column Info
	 * @param purpose2
	 */
	public void setPurpose2(String purpose2) {
		this.purpose2 = purpose2;
	}
	
	/**
	 * Column Info
	 * @param cusName
	 */
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	
	/**
	 * Column Info
	 * @param srepCmtDesc
	 */
	public void setSrepCmtDesc(String srepCmtDesc) {
		this.srepCmtDesc = srepCmtDesc;
	}
	
	/**
	 * Column Info
	 * @param activity
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	/**
	 * Column Info
	 * @param slsMgrCmtDesc
	 */
	public void setSlsMgrCmtDesc(String slsMgrCmtDesc) {
		this.slsMgrCmtDesc = slsMgrCmtDesc;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param actualDt
	 */
	public void setActualDt(String actualDt) {
		this.actualDt = actualDt;
	}
	
	/**
	 * Column Info
	 * @param slsName
	 */
	public void setSlsName(String slsName) {
		this.slsName = slsName;
	}
	
	/**
	 * Column Info
	 * @param teamCd
	 */
	public void setTeamCd(String teamCd) {
		this.teamCd = teamCd;
	}
	
	/**
	 * Column Info
	 * @param planDt
	 */
	public void setPlanDt(String planDt) {
		this.planDt = planDt;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param callReport
	 */
	public void setCallReport(String callReport) {
		this.callReport = callReport;
	}
	
	/**
	 * Column Info
	 * @param activityNo
	 */
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param salesRepCd
	 */
	public void setSalesRepCd(String salesRepCd) {
		this.salesRepCd = salesRepCd;
	}
	
	/**
	 * Column Info
	 * @param cusCode
	 */
	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}
	
	/**
	 * Column Info
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel;
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
		setMgrComment(JSPUtil.getParameter(request, prefix + "mgr_comment", ""));
		setCustomerCd(JSPUtil.getParameter(request, prefix + "customer_cd", ""));
		setOfficeCd(JSPUtil.getParameter(request, prefix + "office_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPurpose(JSPUtil.getParameter(request, prefix + "purpose", ""));
		setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPurpose1(JSPUtil.getParameter(request, prefix + "purpose1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlsCode(JSPUtil.getParameter(request, prefix + "sls_code", ""));
		setPurpose2(JSPUtil.getParameter(request, prefix + "purpose2", ""));
		setCusName(JSPUtil.getParameter(request, prefix + "cus_name", ""));
		setSrepCmtDesc(JSPUtil.getParameter(request, prefix + "srep_cmt_desc", ""));
		setActivity(JSPUtil.getParameter(request, prefix + "activity", ""));
		setSlsMgrCmtDesc(JSPUtil.getParameter(request, prefix + "sls_mgr_cmt_desc", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setActualDt(JSPUtil.getParameter(request, prefix + "actual_dt", ""));
		setSlsName(JSPUtil.getParameter(request, prefix + "sls_name", ""));
		setTeamCd(JSPUtil.getParameter(request, prefix + "team_cd", ""));
		setPlanDt(JSPUtil.getParameter(request, prefix + "plan_dt", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCallReport(JSPUtil.getParameter(request, prefix + "call_report", ""));
		setActivityNo(JSPUtil.getParameter(request, prefix + "activity_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setSalesRepCd(JSPUtil.getParameter(request, prefix + "sales_rep_cd", ""));
		setCusCode(JSPUtil.getParameter(request, prefix + "cus_code", ""));
		setChannel(JSPUtil.getParameter(request, prefix + "channel", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamActivityInputVO[]
	 */
	public SamActivityInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamActivityInputVO[]
	 */
	public SamActivityInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamActivityInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mgrComment = (JSPUtil.getParameter(request, prefix	+ "mgr_comment", length));
			String[] customerCd = (JSPUtil.getParameter(request, prefix	+ "customer_cd", length));
			String[] officeCd = (JSPUtil.getParameter(request, prefix	+ "office_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] purpose = (JSPUtil.getParameter(request, prefix	+ "purpose", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] purpose1 = (JSPUtil.getParameter(request, prefix	+ "purpose1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsCode = (JSPUtil.getParameter(request, prefix	+ "sls_code", length));
			String[] purpose2 = (JSPUtil.getParameter(request, prefix	+ "purpose2", length));
			String[] cusName = (JSPUtil.getParameter(request, prefix	+ "cus_name", length));
			String[] srepCmtDesc = (JSPUtil.getParameter(request, prefix	+ "srep_cmt_desc", length));
			String[] activity = (JSPUtil.getParameter(request, prefix	+ "activity", length));
			String[] slsMgrCmtDesc = (JSPUtil.getParameter(request, prefix	+ "sls_mgr_cmt_desc", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] actualDt = (JSPUtil.getParameter(request, prefix	+ "actual_dt", length));
			String[] slsName = (JSPUtil.getParameter(request, prefix	+ "sls_name", length));
			String[] teamCd = (JSPUtil.getParameter(request, prefix	+ "team_cd", length));
			String[] planDt = (JSPUtil.getParameter(request, prefix	+ "plan_dt", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] callReport = (JSPUtil.getParameter(request, prefix	+ "call_report", length));
			String[] activityNo = (JSPUtil.getParameter(request, prefix	+ "activity_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] salesRepCd = (JSPUtil.getParameter(request, prefix	+ "sales_rep_cd", length));
			String[] cusCode = (JSPUtil.getParameter(request, prefix	+ "cus_code", length));
			String[] channel = (JSPUtil.getParameter(request, prefix	+ "channel", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamActivityInputVO();
				if (mgrComment[i] != null)
					model.setMgrComment(mgrComment[i]);
				if (customerCd[i] != null)
					model.setCustomerCd(customerCd[i]);
				if (officeCd[i] != null)
					model.setOfficeCd(officeCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (purpose[i] != null)
					model.setPurpose(purpose[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (purpose1[i] != null)
					model.setPurpose1(purpose1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsCode[i] != null)
					model.setSlsCode(slsCode[i]);
				if (purpose2[i] != null)
					model.setPurpose2(purpose2[i]);
				if (cusName[i] != null)
					model.setCusName(cusName[i]);
				if (srepCmtDesc[i] != null)
					model.setSrepCmtDesc(srepCmtDesc[i]);
				if (activity[i] != null)
					model.setActivity(activity[i]);
				if (slsMgrCmtDesc[i] != null)
					model.setSlsMgrCmtDesc(slsMgrCmtDesc[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (actualDt[i] != null)
					model.setActualDt(actualDt[i]);
				if (slsName[i] != null)
					model.setSlsName(slsName[i]);
				if (teamCd[i] != null)
					model.setTeamCd(teamCd[i]);
				if (planDt[i] != null)
					model.setPlanDt(planDt[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (callReport[i] != null)
					model.setCallReport(callReport[i]);
				if (activityNo[i] != null)
					model.setActivityNo(activityNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (salesRepCd[i] != null)
					model.setSalesRepCd(salesRepCd[i]);
				if (cusCode[i] != null)
					model.setCusCode(cusCode[i]);
				if (channel[i] != null)
					model.setChannel(channel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamActivityInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamActivityInputVO[]
	 */
	public SamActivityInputVO[] getSamActivityInputVOs(){
		SamActivityInputVO[] vos = (SamActivityInputVO[])models.toArray(new SamActivityInputVO[models.size()]);
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
		this.mgrComment = this.mgrComment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCd = this.customerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeCd = this.officeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purpose = this.purpose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purpose1 = this.purpose1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsCode = this.slsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purpose2 = this.purpose2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusName = this.cusName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCmtDesc = this.srepCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.activity = this.activity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsMgrCmtDesc = this.slsMgrCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualDt = this.actualDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsName = this.slsName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamCd = this.teamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planDt = this.planDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callReport = this.callReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.activityNo = this.activityNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRepCd = this.salesRepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusCode = this.cusCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.channel = this.channel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
