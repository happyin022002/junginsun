/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchReportByInputterUserGroupListVO.java
*@FileTitle : SearchReportByInputterUserGroupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.07.11 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchReportByInputterUserGroupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchReportByInputterUserGroupListVO> models = new ArrayList<SearchReportByInputterUserGroupListVO>();
	
	/* Column Info */
	private String totAmendPoint = null;
	/* Column Info */
	private String totOriPoint = null;
	/* Column Info */
	private String totOriEdiSiCnt = null;
	/* Column Info */
	private String totOriSeaTime = null;
	/* Column Info */
	private String totRiderHblPoint = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totRiderHblCnt = null;
	/* Column Info */
	private String totOriSiCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totOriFaxTime = null;
	/* Column Info */
	private String totOriSeaSiCnt = null;
	/* Column Info */
	private String totRiderHblTime = null;
	/* Column Info */
	private String hisCount = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String totOriFaxSiCnt = null;
	/* Column Info */
	private String totAmendAvgTime = null;
	/* Column Info */
	private String totCmCnt = null;
	/* Column Info */
	private String totOrderAvgTime = null;
	/* Column Info */
	private String totOriEmailTime = null;
	/* Column Info */
	private String totRiderHblAvgTime = null;
	/* Column Info */
	private String avgOriTime = null;
	/* Column Info */
	private String totCntrCnt = null;
	/* Column Info */
	private String totOrderTime = null;
	/* Column Info */
	private String totCstmsMfTpCdCnt = null;
	/* Column Info */
	private String totHblMailFaxCnt = null;
	/* Column Info */
	private String totAmendTime = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String totOriEmailSiCnt = null;
	/* Column Info */
	private String totOriEdiTime = null;
	/* Column Info */
	private String totAmendCnt = null;
	/* Column Info */
	private String totOrderCnt = null;
	/* Column Info */
	private String blCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchReportByInputterUserGroupListVO() {}

	public SearchReportByInputterUserGroupListVO(String ibflag, String pagerows, String userId, String userNm, String hisCount, String blCnt, String totOriSiCnt, String avgOriTime, String totOriPoint, String totOriEdiSiCnt, String totOriEdiTime, String totOriEmailSiCnt, String totOriEmailTime, String totOriFaxSiCnt, String totOriFaxTime, String totOriSeaSiCnt, String totOriSeaTime, String totAmendCnt, String totAmendTime, String totAmendAvgTime, String totAmendPoint, String totRiderHblCnt, String totRiderHblTime, String totRiderHblAvgTime, String totRiderHblPoint, String totOrderCnt, String totOrderTime, String totOrderAvgTime, String totHblMailFaxCnt, String totCmCnt, String totCntrCnt, String totCstmsMfTpCdCnt) {
		this.totAmendPoint = totAmendPoint;
		this.totOriPoint = totOriPoint;
		this.totOriEdiSiCnt = totOriEdiSiCnt;
		this.totOriSeaTime = totOriSeaTime;
		this.totRiderHblPoint = totRiderHblPoint;
		this.pagerows = pagerows;
		this.totRiderHblCnt = totRiderHblCnt;
		this.totOriSiCnt = totOriSiCnt;
		this.ibflag = ibflag;
		this.totOriFaxTime = totOriFaxTime;
		this.totOriSeaSiCnt = totOriSeaSiCnt;
		this.totRiderHblTime = totRiderHblTime;
		this.hisCount = hisCount;
		this.userId = userId;
		this.totOriFaxSiCnt = totOriFaxSiCnt;
		this.totAmendAvgTime = totAmendAvgTime;
		this.totCmCnt = totCmCnt;
		this.totOrderAvgTime = totOrderAvgTime;
		this.totOriEmailTime = totOriEmailTime;
		this.totRiderHblAvgTime = totRiderHblAvgTime;
		this.avgOriTime = avgOriTime;
		this.totCntrCnt = totCntrCnt;
		this.totOrderTime = totOrderTime;
		this.totCstmsMfTpCdCnt = totCstmsMfTpCdCnt;
		this.totHblMailFaxCnt = totHblMailFaxCnt;
		this.totAmendTime = totAmendTime;
		this.userNm = userNm;
		this.totOriEmailSiCnt = totOriEmailSiCnt;
		this.totOriEdiTime = totOriEdiTime;
		this.totAmendCnt = totAmendCnt;
		this.totOrderCnt = totOrderCnt;
		this.blCnt = blCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_amend_point", getTotAmendPoint());
		this.hashColumns.put("tot_ori_point", getTotOriPoint());
		this.hashColumns.put("tot_ori_edi_si_cnt", getTotOriEdiSiCnt());
		this.hashColumns.put("tot_ori_sea_time", getTotOriSeaTime());
		this.hashColumns.put("tot_rider_hbl_point", getTotRiderHblPoint());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot_rider_hbl_cnt", getTotRiderHblCnt());
		this.hashColumns.put("tot_ori_si_cnt", getTotOriSiCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_ori_fax_time", getTotOriFaxTime());
		this.hashColumns.put("tot_ori_sea_si_cnt", getTotOriSeaSiCnt());
		this.hashColumns.put("tot_rider_hbl_time", getTotRiderHblTime());
		this.hashColumns.put("his_count", getHisCount());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("tot_ori_fax_si_cnt", getTotOriFaxSiCnt());
		this.hashColumns.put("tot_amend_avg_time", getTotAmendAvgTime());
		this.hashColumns.put("tot_cm_cnt", getTotCmCnt());
		this.hashColumns.put("tot_order_avg_time", getTotOrderAvgTime());
		this.hashColumns.put("tot_ori_email_time", getTotOriEmailTime());
		this.hashColumns.put("tot_rider_hbl_avg_time", getTotRiderHblAvgTime());
		this.hashColumns.put("avg_ori_time", getAvgOriTime());
		this.hashColumns.put("tot_cntr_cnt", getTotCntrCnt());
		this.hashColumns.put("tot_order_time", getTotOrderTime());
		this.hashColumns.put("tot_cstms_mf_tp_cd_cnt", getTotCstmsMfTpCdCnt());
		this.hashColumns.put("tot_hbl_mail_fax_cnt", getTotHblMailFaxCnt());
		this.hashColumns.put("tot_amend_time", getTotAmendTime());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("tot_ori_email_si_cnt", getTotOriEmailSiCnt());
		this.hashColumns.put("tot_ori_edi_time", getTotOriEdiTime());
		this.hashColumns.put("tot_amend_cnt", getTotAmendCnt());
		this.hashColumns.put("tot_order_cnt", getTotOrderCnt());
		this.hashColumns.put("bl_cnt", getBlCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_amend_point", "totAmendPoint");
		this.hashFields.put("tot_ori_point", "totOriPoint");
		this.hashFields.put("tot_ori_edi_si_cnt", "totOriEdiSiCnt");
		this.hashFields.put("tot_ori_sea_time", "totOriSeaTime");
		this.hashFields.put("tot_rider_hbl_point", "totRiderHblPoint");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot_rider_hbl_cnt", "totRiderHblCnt");
		this.hashFields.put("tot_ori_si_cnt", "totOriSiCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_ori_fax_time", "totOriFaxTime");
		this.hashFields.put("tot_ori_sea_si_cnt", "totOriSeaSiCnt");
		this.hashFields.put("tot_rider_hbl_time", "totRiderHblTime");
		this.hashFields.put("his_count", "hisCount");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("tot_ori_fax_si_cnt", "totOriFaxSiCnt");
		this.hashFields.put("tot_amend_avg_time", "totAmendAvgTime");
		this.hashFields.put("tot_cm_cnt", "totCmCnt");
		this.hashFields.put("tot_order_avg_time", "totOrderAvgTime");
		this.hashFields.put("tot_ori_email_time", "totOriEmailTime");
		this.hashFields.put("tot_rider_hbl_avg_time", "totRiderHblAvgTime");
		this.hashFields.put("avg_ori_time", "avgOriTime");
		this.hashFields.put("tot_cntr_cnt", "totCntrCnt");
		this.hashFields.put("tot_order_time", "totOrderTime");
		this.hashFields.put("tot_cstms_mf_tp_cd_cnt", "totCstmsMfTpCdCnt");
		this.hashFields.put("tot_hbl_mail_fax_cnt", "totHblMailFaxCnt");
		this.hashFields.put("tot_amend_time", "totAmendTime");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("tot_ori_email_si_cnt", "totOriEmailSiCnt");
		this.hashFields.put("tot_ori_edi_time", "totOriEdiTime");
		this.hashFields.put("tot_amend_cnt", "totAmendCnt");
		this.hashFields.put("tot_order_cnt", "totOrderCnt");
		this.hashFields.put("bl_cnt", "blCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totAmendPoint
	 */
	public String getTotAmendPoint() {
		return this.totAmendPoint;
	}
	
	/**
	 * Column Info
	 * @return totOriPoint
	 */
	public String getTotOriPoint() {
		return this.totOriPoint;
	}
	
	/**
	 * Column Info
	 * @return totOriEdiSiCnt
	 */
	public String getTotOriEdiSiCnt() {
		return this.totOriEdiSiCnt;
	}
	
	/**
	 * Column Info
	 * @return totOriSeaTime
	 */
	public String getTotOriSeaTime() {
		return this.totOriSeaTime;
	}
	
	/**
	 * Column Info
	 * @return totRiderHblPoint
	 */
	public String getTotRiderHblPoint() {
		return this.totRiderHblPoint;
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
	 * @return totRiderHblCnt
	 */
	public String getTotRiderHblCnt() {
		return this.totRiderHblCnt;
	}
	
	/**
	 * Column Info
	 * @return totOriSiCnt
	 */
	public String getTotOriSiCnt() {
		return this.totOriSiCnt;
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
	 * @return totOriFaxTime
	 */
	public String getTotOriFaxTime() {
		return this.totOriFaxTime;
	}
	
	/**
	 * Column Info
	 * @return totOriSeaSiCnt
	 */
	public String getTotOriSeaSiCnt() {
		return this.totOriSeaSiCnt;
	}
	
	/**
	 * Column Info
	 * @return totRiderHblTime
	 */
	public String getTotRiderHblTime() {
		return this.totRiderHblTime;
	}
	
	/**
	 * Column Info
	 * @return hisCount
	 */
	public String getHisCount() {
		return this.hisCount;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return totOriFaxSiCnt
	 */
	public String getTotOriFaxSiCnt() {
		return this.totOriFaxSiCnt;
	}
	
	/**
	 * Column Info
	 * @return totAmendAvgTime
	 */
	public String getTotAmendAvgTime() {
		return this.totAmendAvgTime;
	}
	
	/**
	 * Column Info
	 * @return totCmCnt
	 */
	public String getTotCmCnt() {
		return this.totCmCnt;
	}
	
	/**
	 * Column Info
	 * @return totOrderAvgTime
	 */
	public String getTotOrderAvgTime() {
		return this.totOrderAvgTime;
	}
	
	/**
	 * Column Info
	 * @return totOriEmailTime
	 */
	public String getTotOriEmailTime() {
		return this.totOriEmailTime;
	}
	
	/**
	 * Column Info
	 * @return totRiderHblAvgTime
	 */
	public String getTotRiderHblAvgTime() {
		return this.totRiderHblAvgTime;
	}
	
	/**
	 * Column Info
	 * @return avgOriTime
	 */
	public String getAvgOriTime() {
		return this.avgOriTime;
	}
	
	/**
	 * Column Info
	 * @return totCntrCnt
	 */
	public String getTotCntrCnt() {
		return this.totCntrCnt;
	}
	
	/**
	 * Column Info
	 * @return totOrderTime
	 */
	public String getTotOrderTime() {
		return this.totOrderTime;
	}
	
	/**
	 * Column Info
	 * @return totCstmsMfTpCdCnt
	 */
	public String getTotCstmsMfTpCdCnt() {
		return this.totCstmsMfTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @return totHblMailFaxCnt
	 */
	public String getTotHblMailFaxCnt() {
		return this.totHblMailFaxCnt;
	}
	
	/**
	 * Column Info
	 * @return totAmendTime
	 */
	public String getTotAmendTime() {
		return this.totAmendTime;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return totOriEmailSiCnt
	 */
	public String getTotOriEmailSiCnt() {
		return this.totOriEmailSiCnt;
	}
	
	/**
	 * Column Info
	 * @return totOriEdiTime
	 */
	public String getTotOriEdiTime() {
		return this.totOriEdiTime;
	}
	
	/**
	 * Column Info
	 * @return totAmendCnt
	 */
	public String getTotAmendCnt() {
		return this.totAmendCnt;
	}
	
	/**
	 * Column Info
	 * @return totOrderCnt
	 */
	public String getTotOrderCnt() {
		return this.totOrderCnt;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	

	/**
	 * Column Info
	 * @param totAmendPoint
	 */
	public void setTotAmendPoint(String totAmendPoint) {
		this.totAmendPoint = totAmendPoint;
	}
	
	/**
	 * Column Info
	 * @param totOriPoint
	 */
	public void setTotOriPoint(String totOriPoint) {
		this.totOriPoint = totOriPoint;
	}
	
	/**
	 * Column Info
	 * @param totOriEdiSiCnt
	 */
	public void setTotOriEdiSiCnt(String totOriEdiSiCnt) {
		this.totOriEdiSiCnt = totOriEdiSiCnt;
	}
	
	/**
	 * Column Info
	 * @param totOriSeaTime
	 */
	public void setTotOriSeaTime(String totOriSeaTime) {
		this.totOriSeaTime = totOriSeaTime;
	}
	
	/**
	 * Column Info
	 * @param totRiderHblPoint
	 */
	public void setTotRiderHblPoint(String totRiderHblPoint) {
		this.totRiderHblPoint = totRiderHblPoint;
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
	 * @param totRiderHblCnt
	 */
	public void setTotRiderHblCnt(String totRiderHblCnt) {
		this.totRiderHblCnt = totRiderHblCnt;
	}
	
	/**
	 * Column Info
	 * @param totOriSiCnt
	 */
	public void setTotOriSiCnt(String totOriSiCnt) {
		this.totOriSiCnt = totOriSiCnt;
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
	 * @param totOriFaxTime
	 */
	public void setTotOriFaxTime(String totOriFaxTime) {
		this.totOriFaxTime = totOriFaxTime;
	}
	
	/**
	 * Column Info
	 * @param totOriSeaSiCnt
	 */
	public void setTotOriSeaSiCnt(String totOriSeaSiCnt) {
		this.totOriSeaSiCnt = totOriSeaSiCnt;
	}
	
	/**
	 * Column Info
	 * @param totRiderHblTime
	 */
	public void setTotRiderHblTime(String totRiderHblTime) {
		this.totRiderHblTime = totRiderHblTime;
	}
	
	/**
	 * Column Info
	 * @param hisCount
	 */
	public void setHisCount(String hisCount) {
		this.hisCount = hisCount;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param totOriFaxSiCnt
	 */
	public void setTotOriFaxSiCnt(String totOriFaxSiCnt) {
		this.totOriFaxSiCnt = totOriFaxSiCnt;
	}
	
	/**
	 * Column Info
	 * @param totAmendAvgTime
	 */
	public void setTotAmendAvgTime(String totAmendAvgTime) {
		this.totAmendAvgTime = totAmendAvgTime;
	}
	
	/**
	 * Column Info
	 * @param totCmCnt
	 */
	public void setTotCmCnt(String totCmCnt) {
		this.totCmCnt = totCmCnt;
	}
	
	/**
	 * Column Info
	 * @param totOrderAvgTime
	 */
	public void setTotOrderAvgTime(String totOrderAvgTime) {
		this.totOrderAvgTime = totOrderAvgTime;
	}
	
	/**
	 * Column Info
	 * @param totOriEmailTime
	 */
	public void setTotOriEmailTime(String totOriEmailTime) {
		this.totOriEmailTime = totOriEmailTime;
	}
	
	/**
	 * Column Info
	 * @param totRiderHblAvgTime
	 */
	public void setTotRiderHblAvgTime(String totRiderHblAvgTime) {
		this.totRiderHblAvgTime = totRiderHblAvgTime;
	}
	
	/**
	 * Column Info
	 * @param avgOriTime
	 */
	public void setAvgOriTime(String avgOriTime) {
		this.avgOriTime = avgOriTime;
	}
	
	/**
	 * Column Info
	 * @param totCntrCnt
	 */
	public void setTotCntrCnt(String totCntrCnt) {
		this.totCntrCnt = totCntrCnt;
	}
	
	/**
	 * Column Info
	 * @param totOrderTime
	 */
	public void setTotOrderTime(String totOrderTime) {
		this.totOrderTime = totOrderTime;
	}
	
	/**
	 * Column Info
	 * @param totCstmsMfTpCdCnt
	 */
	public void setTotCstmsMfTpCdCnt(String totCstmsMfTpCdCnt) {
		this.totCstmsMfTpCdCnt = totCstmsMfTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @param totHblMailFaxCnt
	 */
	public void setTotHblMailFaxCnt(String totHblMailFaxCnt) {
		this.totHblMailFaxCnt = totHblMailFaxCnt;
	}
	
	/**
	 * Column Info
	 * @param totAmendTime
	 */
	public void setTotAmendTime(String totAmendTime) {
		this.totAmendTime = totAmendTime;
	}
	
	/**
	 * Column Info
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * Column Info
	 * @param totOriEmailSiCnt
	 */
	public void setTotOriEmailSiCnt(String totOriEmailSiCnt) {
		this.totOriEmailSiCnt = totOriEmailSiCnt;
	}
	
	/**
	 * Column Info
	 * @param totOriEdiTime
	 */
	public void setTotOriEdiTime(String totOriEdiTime) {
		this.totOriEdiTime = totOriEdiTime;
	}
	
	/**
	 * Column Info
	 * @param totAmendCnt
	 */
	public void setTotAmendCnt(String totAmendCnt) {
		this.totAmendCnt = totAmendCnt;
	}
	
	/**
	 * Column Info
	 * @param totOrderCnt
	 */
	public void setTotOrderCnt(String totOrderCnt) {
		this.totOrderCnt = totOrderCnt;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setTotAmendPoint(JSPUtil.getParameter(request, prefix + "tot_amend_point", ""));
		setTotOriPoint(JSPUtil.getParameter(request, prefix + "tot_ori_point", ""));
		setTotOriEdiSiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_edi_si_cnt", ""));
		setTotOriSeaTime(JSPUtil.getParameter(request, prefix + "tot_ori_sea_time", ""));
		setTotRiderHblPoint(JSPUtil.getParameter(request, prefix + "tot_rider_hbl_point", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTotRiderHblCnt(JSPUtil.getParameter(request, prefix + "tot_rider_hbl_cnt", ""));
		setTotOriSiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_si_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotOriFaxTime(JSPUtil.getParameter(request, prefix + "tot_ori_fax_time", ""));
		setTotOriSeaSiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_sea_si_cnt", ""));
		setTotRiderHblTime(JSPUtil.getParameter(request, prefix + "tot_rider_hbl_time", ""));
		setHisCount(JSPUtil.getParameter(request, prefix + "his_count", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setTotOriFaxSiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_fax_si_cnt", ""));
		setTotAmendAvgTime(JSPUtil.getParameter(request, prefix + "tot_amend_avg_time", ""));
		setTotCmCnt(JSPUtil.getParameter(request, prefix + "tot_cm_cnt", ""));
		setTotOrderAvgTime(JSPUtil.getParameter(request, prefix + "tot_order_avg_time", ""));
		setTotOriEmailTime(JSPUtil.getParameter(request, prefix + "tot_ori_email_time", ""));
		setTotRiderHblAvgTime(JSPUtil.getParameter(request, prefix + "tot_rider_hbl_avg_time", ""));
		setAvgOriTime(JSPUtil.getParameter(request, prefix + "avg_ori_time", ""));
		setTotCntrCnt(JSPUtil.getParameter(request, prefix + "tot_cntr_cnt", ""));
		setTotOrderTime(JSPUtil.getParameter(request, prefix + "tot_order_time", ""));
		setTotCstmsMfTpCdCnt(JSPUtil.getParameter(request, prefix + "tot_cstms_mf_tp_cd_cnt", ""));
		setTotHblMailFaxCnt(JSPUtil.getParameter(request, prefix + "tot_hbl_mail_fax_cnt", ""));
		setTotAmendTime(JSPUtil.getParameter(request, prefix + "tot_amend_time", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setTotOriEmailSiCnt(JSPUtil.getParameter(request, prefix + "tot_ori_email_si_cnt", ""));
		setTotOriEdiTime(JSPUtil.getParameter(request, prefix + "tot_ori_edi_time", ""));
		setTotAmendCnt(JSPUtil.getParameter(request, prefix + "tot_amend_cnt", ""));
		setTotOrderCnt(JSPUtil.getParameter(request, prefix + "tot_order_cnt", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchReportByInputterUserGroupListVO[]
	 */
	public SearchReportByInputterUserGroupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchReportByInputterUserGroupListVO[]
	 */
	public SearchReportByInputterUserGroupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchReportByInputterUserGroupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totAmendPoint = (JSPUtil.getParameter(request, prefix	+ "tot_amend_point", length));
			String[] totOriPoint = (JSPUtil.getParameter(request, prefix	+ "tot_ori_point", length));
			String[] totOriEdiSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_edi_si_cnt", length));
			String[] totOriSeaTime = (JSPUtil.getParameter(request, prefix	+ "tot_ori_sea_time", length));
			String[] totRiderHblPoint = (JSPUtil.getParameter(request, prefix	+ "tot_rider_hbl_point", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totRiderHblCnt = (JSPUtil.getParameter(request, prefix	+ "tot_rider_hbl_cnt", length));
			String[] totOriSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_si_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totOriFaxTime = (JSPUtil.getParameter(request, prefix	+ "tot_ori_fax_time", length));
			String[] totOriSeaSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_sea_si_cnt", length));
			String[] totRiderHblTime = (JSPUtil.getParameter(request, prefix	+ "tot_rider_hbl_time", length));
			String[] hisCount = (JSPUtil.getParameter(request, prefix	+ "his_count", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] totOriFaxSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_fax_si_cnt", length));
			String[] totAmendAvgTime = (JSPUtil.getParameter(request, prefix	+ "tot_amend_avg_time", length));
			String[] totCmCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cm_cnt", length));
			String[] totOrderAvgTime = (JSPUtil.getParameter(request, prefix	+ "tot_order_avg_time", length));
			String[] totOriEmailTime = (JSPUtil.getParameter(request, prefix	+ "tot_ori_email_time", length));
			String[] totRiderHblAvgTime = (JSPUtil.getParameter(request, prefix	+ "tot_rider_hbl_avg_time", length));
			String[] avgOriTime = (JSPUtil.getParameter(request, prefix	+ "avg_ori_time", length));
			String[] totCntrCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cntr_cnt", length));
			String[] totOrderTime = (JSPUtil.getParameter(request, prefix	+ "tot_order_time", length));
			String[] totCstmsMfTpCdCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cstms_mf_tp_cd_cnt", length));
			String[] totHblMailFaxCnt = (JSPUtil.getParameter(request, prefix	+ "tot_hbl_mail_fax_cnt", length));
			String[] totAmendTime = (JSPUtil.getParameter(request, prefix	+ "tot_amend_time", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] totOriEmailSiCnt = (JSPUtil.getParameter(request, prefix	+ "tot_ori_email_si_cnt", length));
			String[] totOriEdiTime = (JSPUtil.getParameter(request, prefix	+ "tot_ori_edi_time", length));
			String[] totAmendCnt = (JSPUtil.getParameter(request, prefix	+ "tot_amend_cnt", length));
			String[] totOrderCnt = (JSPUtil.getParameter(request, prefix	+ "tot_order_cnt", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchReportByInputterUserGroupListVO();
				if (totAmendPoint[i] != null)
					model.setTotAmendPoint(totAmendPoint[i]);
				if (totOriPoint[i] != null)
					model.setTotOriPoint(totOriPoint[i]);
				if (totOriEdiSiCnt[i] != null)
					model.setTotOriEdiSiCnt(totOriEdiSiCnt[i]);
				if (totOriSeaTime[i] != null)
					model.setTotOriSeaTime(totOriSeaTime[i]);
				if (totRiderHblPoint[i] != null)
					model.setTotRiderHblPoint(totRiderHblPoint[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totRiderHblCnt[i] != null)
					model.setTotRiderHblCnt(totRiderHblCnt[i]);
				if (totOriSiCnt[i] != null)
					model.setTotOriSiCnt(totOriSiCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totOriFaxTime[i] != null)
					model.setTotOriFaxTime(totOriFaxTime[i]);
				if (totOriSeaSiCnt[i] != null)
					model.setTotOriSeaSiCnt(totOriSeaSiCnt[i]);
				if (totRiderHblTime[i] != null)
					model.setTotRiderHblTime(totRiderHblTime[i]);
				if (hisCount[i] != null)
					model.setHisCount(hisCount[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (totOriFaxSiCnt[i] != null)
					model.setTotOriFaxSiCnt(totOriFaxSiCnt[i]);
				if (totAmendAvgTime[i] != null)
					model.setTotAmendAvgTime(totAmendAvgTime[i]);
				if (totCmCnt[i] != null)
					model.setTotCmCnt(totCmCnt[i]);
				if (totOrderAvgTime[i] != null)
					model.setTotOrderAvgTime(totOrderAvgTime[i]);
				if (totOriEmailTime[i] != null)
					model.setTotOriEmailTime(totOriEmailTime[i]);
				if (totRiderHblAvgTime[i] != null)
					model.setTotRiderHblAvgTime(totRiderHblAvgTime[i]);
				if (avgOriTime[i] != null)
					model.setAvgOriTime(avgOriTime[i]);
				if (totCntrCnt[i] != null)
					model.setTotCntrCnt(totCntrCnt[i]);
				if (totOrderTime[i] != null)
					model.setTotOrderTime(totOrderTime[i]);
				if (totCstmsMfTpCdCnt[i] != null)
					model.setTotCstmsMfTpCdCnt(totCstmsMfTpCdCnt[i]);
				if (totHblMailFaxCnt[i] != null)
					model.setTotHblMailFaxCnt(totHblMailFaxCnt[i]);
				if (totAmendTime[i] != null)
					model.setTotAmendTime(totAmendTime[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (totOriEmailSiCnt[i] != null)
					model.setTotOriEmailSiCnt(totOriEmailSiCnt[i]);
				if (totOriEdiTime[i] != null)
					model.setTotOriEdiTime(totOriEdiTime[i]);
				if (totAmendCnt[i] != null)
					model.setTotAmendCnt(totAmendCnt[i]);
				if (totOrderCnt[i] != null)
					model.setTotOrderCnt(totOrderCnt[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchReportByInputterUserGroupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchReportByInputterUserGroupListVO[]
	 */
	public SearchReportByInputterUserGroupListVO[] getSearchReportByInputterUserGroupListVOs(){
		SearchReportByInputterUserGroupListVO[] vos = (SearchReportByInputterUserGroupListVO[])models.toArray(new SearchReportByInputterUserGroupListVO[models.size()]);
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
		this.totAmendPoint = this.totAmendPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriPoint = this.totOriPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriEdiSiCnt = this.totOriEdiSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriSeaTime = this.totOriSeaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRiderHblPoint = this.totRiderHblPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRiderHblCnt = this.totRiderHblCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriSiCnt = this.totOriSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriFaxTime = this.totOriFaxTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriSeaSiCnt = this.totOriSeaSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRiderHblTime = this.totRiderHblTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCount = this.hisCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriFaxSiCnt = this.totOriFaxSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmendAvgTime = this.totAmendAvgTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCmCnt = this.totCmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOrderAvgTime = this.totOrderAvgTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriEmailTime = this.totOriEmailTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totRiderHblAvgTime = this.totRiderHblAvgTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgOriTime = this.avgOriTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCntrCnt = this.totCntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOrderTime = this.totOrderTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCstmsMfTpCdCnt = this.totCstmsMfTpCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHblMailFaxCnt = this.totHblMailFaxCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmendTime = this.totAmendTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriEmailSiCnt = this.totOriEmailSiCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOriEdiTime = this.totOriEdiTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmendCnt = this.totAmendCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totOrderCnt = this.totOrderCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
