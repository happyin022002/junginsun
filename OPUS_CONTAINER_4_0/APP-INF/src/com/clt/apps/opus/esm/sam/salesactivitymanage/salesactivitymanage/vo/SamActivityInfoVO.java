/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamActivityInfoVO.java
*@FileTitle : SamActivityInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.30
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.05.30 이관샨 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo;

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

public class SamActivityInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamActivityInfoVO> models = new ArrayList<SamActivityInfoVO>();
	
	/* Column Info */
	private String purpose1 = null;
	/* Column Info */
	private String slsMgrCmtDesc = null;
	/* Column Info */
	private String actualDt = null;
	/* Column Info */
	private String slsName = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mgrCmt = null;
	/* Column Info */
	private String planDt = null;
	/* Column Info */
	private String purpose = null;
	/* Column Info */
	private String purpose2 = null;
	/* Column Info */
	private String slsRepCmt = null;
	/* Column Info */
	private String channel = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String callReport = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String activityNo = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String slsCode = null;
	/* Column Info */
	private String cusCode = null;
	/* Column Info */
	private String cusName = null;
	/* Column Info */
	private String creUserId = null;
	/* Column Info */
	private String srepCmtDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamActivityInfoVO() {}

	public SamActivityInfoVO(String ibflag, String pagerows, String activityNo, String slsCode, String slsName, String cusCode, String cusName, String purpose1, String purpose, String callReport, String planDt, String actualDt, String creDt, String creUsrId, String channel, String srepCmtDesc, String slsMgrCmtDesc, String slsRepCmt, String purpose2, String mgrCmt, String actDt, String creUserId) {
		this.purpose1 = purpose1;
		this.slsMgrCmtDesc = slsMgrCmtDesc;
		this.actualDt = actualDt;
		this.slsName = slsName;
		this.creDt = creDt;
		this.mgrCmt = mgrCmt;
		this.planDt = planDt;
		this.purpose = purpose;
		this.purpose2 = purpose2;
		this.slsRepCmt = slsRepCmt;
		this.channel = channel;
		this.pagerows = pagerows;
		this.callReport = callReport;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.activityNo = activityNo;
		this.actDt = actDt;
		this.slsCode = slsCode;
		this.cusCode = cusCode;
		this.cusName = cusName;
		this.creUserId = creUserId;
		this.srepCmtDesc = srepCmtDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("purpose1", getPurpose1());
		this.hashColumns.put("sls_mgr_cmt_desc", getSlsMgrCmtDesc());
		this.hashColumns.put("actual_dt", getActualDt());
		this.hashColumns.put("sls_name", getSlsName());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mgr_cmt", getMgrCmt());
		this.hashColumns.put("plan_dt", getPlanDt());
		this.hashColumns.put("purpose", getPurpose());
		this.hashColumns.put("purpose2", getPurpose2());
		this.hashColumns.put("sls_rep_cmt", getSlsRepCmt());
		this.hashColumns.put("channel", getChannel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("call_report", getCallReport());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("activity_no", getActivityNo());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("sls_code", getSlsCode());
		this.hashColumns.put("cus_code", getCusCode());
		this.hashColumns.put("cus_name", getCusName());
		this.hashColumns.put("cre_user_id", getCreUserId());
		this.hashColumns.put("srep_cmt_desc", getSrepCmtDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("purpose1", "purpose1");
		this.hashFields.put("sls_mgr_cmt_desc", "slsMgrCmtDesc");
		this.hashFields.put("actual_dt", "actualDt");
		this.hashFields.put("sls_name", "slsName");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mgr_cmt", "mgrCmt");
		this.hashFields.put("plan_dt", "planDt");
		this.hashFields.put("purpose", "purpose");
		this.hashFields.put("purpose2", "purpose2");
		this.hashFields.put("sls_rep_cmt", "slsRepCmt");
		this.hashFields.put("channel", "channel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("call_report", "callReport");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("activity_no", "activityNo");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("sls_code", "slsCode");
		this.hashFields.put("cus_code", "cusCode");
		this.hashFields.put("cus_name", "cusName");
		this.hashFields.put("cre_user_id", "creUserId");
		this.hashFields.put("srep_cmt_desc", "srepCmtDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return purpose1
	 */
	public String getPurpose1() {
		return this.purpose1;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return mgrCmt
	 */
	public String getMgrCmt() {
		return this.mgrCmt;
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
	 * @return purpose
	 */
	public String getPurpose() {
		return this.purpose;
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
	 * @return slsRepCmt
	 */
	public String getSlsRepCmt() {
		return this.slsRepCmt;
	}
	
	/**
	 * Column Info
	 * @return channel
	 */
	public String getChannel() {
		return this.channel;
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
	 * @return callReport
	 */
	public String getCallReport() {
		return this.callReport;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return activityNo
	 */
	public String getActivityNo() {
		return this.activityNo;
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
	 * @return slsCode
	 */
	public String getSlsCode() {
		return this.slsCode;
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
	 * @return cusName
	 */
	public String getCusName() {
		return this.cusName;
	}
	
	/**
	 * Column Info
	 * @return creUserId
	 */
	public String getCreUserId() {
		return this.creUserId;
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
	 * @param purpose1
	 */
	public void setPurpose1(String purpose1) {
		this.purpose1 = purpose1;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param mgrCmt
	 */
	public void setMgrCmt(String mgrCmt) {
		this.mgrCmt = mgrCmt;
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
	 * @param purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
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
	 * @param slsRepCmt
	 */
	public void setSlsRepCmt(String slsRepCmt) {
		this.slsRepCmt = slsRepCmt;
	}
	
	/**
	 * Column Info
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel;
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
	 * @param callReport
	 */
	public void setCallReport(String callReport) {
		this.callReport = callReport;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param activityNo
	 */
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
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
	 * @param slsCode
	 */
	public void setSlsCode(String slsCode) {
		this.slsCode = slsCode;
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
	 * @param cusName
	 */
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	
	/**
	 * Column Info
	 * @param creUserId
	 */
	public void setCreUserId(String creUserId) {
		this.creUserId = creUserId;
	}
	
	/**
	 * Column Info
	 * @param srepCmtDesc
	 */
	public void setSrepCmtDesc(String srepCmtDesc) {
		this.srepCmtDesc = srepCmtDesc;
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
		setPurpose1(JSPUtil.getParameter(request, prefix + "purpose1", ""));
		setSlsMgrCmtDesc(JSPUtil.getParameter(request, prefix + "sls_mgr_cmt_desc", ""));
		setActualDt(JSPUtil.getParameter(request, prefix + "actual_dt", ""));
		setSlsName(JSPUtil.getParameter(request, prefix + "sls_name", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMgrCmt(JSPUtil.getParameter(request, prefix + "mgr_cmt", ""));
		setPlanDt(JSPUtil.getParameter(request, prefix + "plan_dt", ""));
		setPurpose(JSPUtil.getParameter(request, prefix + "purpose", ""));
		setPurpose2(JSPUtil.getParameter(request, prefix + "purpose2", ""));
		setSlsRepCmt(JSPUtil.getParameter(request, prefix + "sls_rep_cmt", ""));
		setChannel(JSPUtil.getParameter(request, prefix + "channel", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCallReport(JSPUtil.getParameter(request, prefix + "call_report", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActivityNo(JSPUtil.getParameter(request, prefix + "activity_no", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setSlsCode(JSPUtil.getParameter(request, prefix + "sls_code", ""));
		setCusCode(JSPUtil.getParameter(request, prefix + "cus_code", ""));
		setCusName(JSPUtil.getParameter(request, prefix + "cus_name", ""));
		setCreUserId(JSPUtil.getParameter(request, prefix + "cre_user_id", ""));
		setSrepCmtDesc(JSPUtil.getParameter(request, prefix + "srep_cmt_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamActivityInfoVO[]
	 */
	public SamActivityInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamActivityInfoVO[]
	 */
	public SamActivityInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamActivityInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] purpose1 = (JSPUtil.getParameter(request, prefix	+ "purpose1", length));
			String[] slsMgrCmtDesc = (JSPUtil.getParameter(request, prefix	+ "sls_mgr_cmt_desc", length));
			String[] actualDt = (JSPUtil.getParameter(request, prefix	+ "actual_dt", length));
			String[] slsName = (JSPUtil.getParameter(request, prefix	+ "sls_name", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mgrCmt = (JSPUtil.getParameter(request, prefix	+ "mgr_cmt", length));
			String[] planDt = (JSPUtil.getParameter(request, prefix	+ "plan_dt", length));
			String[] purpose = (JSPUtil.getParameter(request, prefix	+ "purpose", length));
			String[] purpose2 = (JSPUtil.getParameter(request, prefix	+ "purpose2", length));
			String[] slsRepCmt = (JSPUtil.getParameter(request, prefix	+ "sls_rep_cmt", length));
			String[] channel = (JSPUtil.getParameter(request, prefix	+ "channel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] callReport = (JSPUtil.getParameter(request, prefix	+ "call_report", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] activityNo = (JSPUtil.getParameter(request, prefix	+ "activity_no", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] slsCode = (JSPUtil.getParameter(request, prefix	+ "sls_code", length));
			String[] cusCode = (JSPUtil.getParameter(request, prefix	+ "cus_code", length));
			String[] cusName = (JSPUtil.getParameter(request, prefix	+ "cus_name", length));
			String[] creUserId = (JSPUtil.getParameter(request, prefix	+ "cre_user_id", length));
			String[] srepCmtDesc = (JSPUtil.getParameter(request, prefix	+ "srep_cmt_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamActivityInfoVO();
				if (purpose1[i] != null)
					model.setPurpose1(purpose1[i]);
				if (slsMgrCmtDesc[i] != null)
					model.setSlsMgrCmtDesc(slsMgrCmtDesc[i]);
				if (actualDt[i] != null)
					model.setActualDt(actualDt[i]);
				if (slsName[i] != null)
					model.setSlsName(slsName[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mgrCmt[i] != null)
					model.setMgrCmt(mgrCmt[i]);
				if (planDt[i] != null)
					model.setPlanDt(planDt[i]);
				if (purpose[i] != null)
					model.setPurpose(purpose[i]);
				if (purpose2[i] != null)
					model.setPurpose2(purpose2[i]);
				if (slsRepCmt[i] != null)
					model.setSlsRepCmt(slsRepCmt[i]);
				if (channel[i] != null)
					model.setChannel(channel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (callReport[i] != null)
					model.setCallReport(callReport[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (activityNo[i] != null)
					model.setActivityNo(activityNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (slsCode[i] != null)
					model.setSlsCode(slsCode[i]);
				if (cusCode[i] != null)
					model.setCusCode(cusCode[i]);
				if (cusName[i] != null)
					model.setCusName(cusName[i]);
				if (creUserId[i] != null)
					model.setCreUserId(creUserId[i]);
				if (srepCmtDesc[i] != null)
					model.setSrepCmtDesc(srepCmtDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamActivityInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamActivityInfoVO[]
	 */
	public SamActivityInfoVO[] getSamActivityInfoVOs(){
		SamActivityInfoVO[] vos = (SamActivityInfoVO[])models.toArray(new SamActivityInfoVO[models.size()]);
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
		this.purpose1 = this.purpose1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsMgrCmtDesc = this.slsMgrCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualDt = this.actualDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsName = this.slsName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrCmt = this.mgrCmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planDt = this.planDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purpose = this.purpose .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purpose2 = this.purpose2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRepCmt = this.slsRepCmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.channel = this.channel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callReport = this.callReport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.activityNo = this.activityNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsCode = this.slsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusCode = this.cusCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusName = this.cusName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUserId = this.creUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCmtDesc = this.srepCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
