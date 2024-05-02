/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementAnalysisVO.java
*@FileTitle : SettlementAnalysisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.02.08 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SettlementAnalysisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SettlementAnalysisVO> models = new ArrayList<SettlementAnalysisVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String timeBarred2 = null;
	/* Column Info */
	private String withdrawn = null;
	/* Column Info */
	private String paidDp2 = null;
	/* Column Info */
	private String insRecovered2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String outstandingP2 = null;
	/* Column Info */
	private String withdrawn2 = null;
	/* Column Info */
	private String reportBy = null;
	/* Column Info */
	private String insRecoveredP2 = null;
	/* Column Info */
	private String tenderDefence = null;
	/* Column Info */
	private String dataSeq2 = null;
	/* Column Info */
	private String paidDpP2 = null;
	/* Column Info */
	private String totalRecovered2 = null;
	/* Column Info */
	private String insRecovered = null;
	/* Column Info */
	private String insRecoveredP = null;
	/* Column Info */
	private String netPaidP2 = null;
	/* Column Info */
	private String lpRecoveredP = null;
	/* Column Info */
	private String reportBy2 = null;
	/* Column Info */
	private String totalRecoveredP2 = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String netPaid = null;
	/* Column Info */
	private String dataSeq = null;
	/* Column Info */
	private String claimed2 = null;
	/* Column Info */
	private String outstandingP = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String lpRecovered2 = null;
	/* Column Info */
	private String dismissed2 = null;
	/* Column Info */
	private String repudiated2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String paid = null;
	/* Column Info */
	private String timeBarred = null;
	/* Column Info */
	private String totalRecovered = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String netPaid2 = null;
	/* Column Info */
	private String outstanding = null;
	/* Column Info */
	private String div2 = null;
	/* Column Info */
	private String dismissed = null;
	/* Column Info */
	private String tot2 = null;
	/* Column Info */
	private String paidDpP = null;
	/* Column Info */
	private String paid2 = null;
	/* Column Info */
	private String outstanding2 = null;
	/* Column Info */
	private String paidDp = null;
	/* Column Info */
	private String lpRecoveredP2 = null;
	/* Column Info */
	private String lpRecovered = null;
	/* Column Info */
	private String repudiated = null;
	/* Column Info */
	private String netPaidP = null;
	/* Column Info */
	private String totalRecoveredP = null;
	/* Column Info */
	private String claimed = null;
	/* Column Info */
	private String tenderDefence2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SettlementAnalysisVO() {}

	public SettlementAnalysisVO(String ibflag, String pagerows, String dataSeq, String reportBy, String div, String claimed, String paid, String timeBarred, String withdrawn, String repudiated, String tenderDefence, String dismissed, String tot, String outstanding, String outstandingP, String paidDp, String paidDpP, String lpRecovered, String lpRecoveredP, String insRecovered, String insRecoveredP, String totalRecovered, String totalRecoveredP, String netPaid, String netPaidP, String dataSeq2, String reportBy2, String div2, String claimed2, String paid2, String timeBarred2, String withdrawn2, String repudiated2, String tenderDefence2, String dismissed2, String tot2, String outstanding2, String outstandingP2, String paidDp2, String paidDpP2, String lpRecovered2, String lpRecoveredP2, String insRecovered2, String insRecoveredP2, String totalRecovered2, String totalRecoveredP2, String netPaid2, String netPaidP2, String rowNum, String total) {
		this.total = total;
		this.timeBarred2 = timeBarred2;
		this.withdrawn = withdrawn;
		this.paidDp2 = paidDp2;
		this.insRecovered2 = insRecovered2;
		this.pagerows = pagerows;
		this.outstandingP2 = outstandingP2;
		this.withdrawn2 = withdrawn2;
		this.reportBy = reportBy;
		this.insRecoveredP2 = insRecoveredP2;
		this.tenderDefence = tenderDefence;
		this.dataSeq2 = dataSeq2;
		this.paidDpP2 = paidDpP2;
		this.totalRecovered2 = totalRecovered2;
		this.insRecovered = insRecovered;
		this.insRecoveredP = insRecoveredP;
		this.netPaidP2 = netPaidP2;
		this.lpRecoveredP = lpRecoveredP;
		this.reportBy2 = reportBy2;
		this.totalRecoveredP2 = totalRecoveredP2;
		this.rowNum = rowNum;
		this.netPaid = netPaid;
		this.dataSeq = dataSeq;
		this.claimed2 = claimed2;
		this.outstandingP = outstandingP;
		this.div = div;
		this.lpRecovered2 = lpRecovered2;
		this.dismissed2 = dismissed2;
		this.repudiated2 = repudiated2;
		this.ibflag = ibflag;
		this.paid = paid;
		this.timeBarred = timeBarred;
		this.totalRecovered = totalRecovered;
		this.tot = tot;
		this.netPaid2 = netPaid2;
		this.outstanding = outstanding;
		this.div2 = div2;
		this.dismissed = dismissed;
		this.tot2 = tot2;
		this.paidDpP = paidDpP;
		this.paid2 = paid2;
		this.outstanding2 = outstanding2;
		this.paidDp = paidDp;
		this.lpRecoveredP2 = lpRecoveredP2;
		this.lpRecovered = lpRecovered;
		this.repudiated = repudiated;
		this.netPaidP = netPaidP;
		this.totalRecoveredP = totalRecoveredP;
		this.claimed = claimed;
		this.tenderDefence2 = tenderDefence2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("time_barred2", getTimeBarred2());
		this.hashColumns.put("withdrawn", getWithdrawn());
		this.hashColumns.put("paid_dp2", getPaidDp2());
		this.hashColumns.put("ins_recovered2", getInsRecovered2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("outstanding_p2", getOutstandingP2());
		this.hashColumns.put("withdrawn2", getWithdrawn2());
		this.hashColumns.put("report_by", getReportBy());
		this.hashColumns.put("ins_recovered_p2", getInsRecoveredP2());
		this.hashColumns.put("tender_defence", getTenderDefence());
		this.hashColumns.put("data_seq2", getDataSeq2());
		this.hashColumns.put("paid_dp_p2", getPaidDpP2());
		this.hashColumns.put("total_recovered2", getTotalRecovered2());
		this.hashColumns.put("ins_recovered", getInsRecovered());
		this.hashColumns.put("ins_recovered_p", getInsRecoveredP());
		this.hashColumns.put("net_paid_p2", getNetPaidP2());
		this.hashColumns.put("lp_recovered_p", getLpRecoveredP());
		this.hashColumns.put("report_by2", getReportBy2());
		this.hashColumns.put("total_recovered_p2", getTotalRecoveredP2());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("net_paid", getNetPaid());
		this.hashColumns.put("data_seq", getDataSeq());
		this.hashColumns.put("claimed2", getClaimed2());
		this.hashColumns.put("outstanding_p", getOutstandingP());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("lp_recovered2", getLpRecovered2());
		this.hashColumns.put("dismissed2", getDismissed2());
		this.hashColumns.put("repudiated2", getRepudiated2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("paid", getPaid());
		this.hashColumns.put("time_barred", getTimeBarred());
		this.hashColumns.put("total_recovered", getTotalRecovered());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("net_paid2", getNetPaid2());
		this.hashColumns.put("outstanding", getOutstanding());
		this.hashColumns.put("div2", getDiv2());
		this.hashColumns.put("dismissed", getDismissed());
		this.hashColumns.put("tot2", getTot2());
		this.hashColumns.put("paid_dp_p", getPaidDpP());
		this.hashColumns.put("paid2", getPaid2());
		this.hashColumns.put("outstanding2", getOutstanding2());
		this.hashColumns.put("paid_dp", getPaidDp());
		this.hashColumns.put("lp_recovered_p2", getLpRecoveredP2());
		this.hashColumns.put("lp_recovered", getLpRecovered());
		this.hashColumns.put("repudiated", getRepudiated());
		this.hashColumns.put("net_paid_p", getNetPaidP());
		this.hashColumns.put("total_recovered_p", getTotalRecoveredP());
		this.hashColumns.put("claimed", getClaimed());
		this.hashColumns.put("tender_defence2", getTenderDefence2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("time_barred2", "timeBarred2");
		this.hashFields.put("withdrawn", "withdrawn");
		this.hashFields.put("paid_dp2", "paidDp2");
		this.hashFields.put("ins_recovered2", "insRecovered2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("outstanding_p2", "outstandingP2");
		this.hashFields.put("withdrawn2", "withdrawn2");
		this.hashFields.put("report_by", "reportBy");
		this.hashFields.put("ins_recovered_p2", "insRecoveredP2");
		this.hashFields.put("tender_defence", "tenderDefence");
		this.hashFields.put("data_seq2", "dataSeq2");
		this.hashFields.put("paid_dp_p2", "paidDpP2");
		this.hashFields.put("total_recovered2", "totalRecovered2");
		this.hashFields.put("ins_recovered", "insRecovered");
		this.hashFields.put("ins_recovered_p", "insRecoveredP");
		this.hashFields.put("net_paid_p2", "netPaidP2");
		this.hashFields.put("lp_recovered_p", "lpRecoveredP");
		this.hashFields.put("report_by2", "reportBy2");
		this.hashFields.put("total_recovered_p2", "totalRecoveredP2");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("net_paid", "netPaid");
		this.hashFields.put("data_seq", "dataSeq");
		this.hashFields.put("claimed2", "claimed2");
		this.hashFields.put("outstanding_p", "outstandingP");
		this.hashFields.put("div", "div");
		this.hashFields.put("lp_recovered2", "lpRecovered2");
		this.hashFields.put("dismissed2", "dismissed2");
		this.hashFields.put("repudiated2", "repudiated2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("paid", "paid");
		this.hashFields.put("time_barred", "timeBarred");
		this.hashFields.put("total_recovered", "totalRecovered");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("net_paid2", "netPaid2");
		this.hashFields.put("outstanding", "outstanding");
		this.hashFields.put("div2", "div2");
		this.hashFields.put("dismissed", "dismissed");
		this.hashFields.put("tot2", "tot2");
		this.hashFields.put("paid_dp_p", "paidDpP");
		this.hashFields.put("paid2", "paid2");
		this.hashFields.put("outstanding2", "outstanding2");
		this.hashFields.put("paid_dp", "paidDp");
		this.hashFields.put("lp_recovered_p2", "lpRecoveredP2");
		this.hashFields.put("lp_recovered", "lpRecovered");
		this.hashFields.put("repudiated", "repudiated");
		this.hashFields.put("net_paid_p", "netPaidP");
		this.hashFields.put("total_recovered_p", "totalRecoveredP");
		this.hashFields.put("claimed", "claimed");
		this.hashFields.put("tender_defence2", "tenderDefence2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return timeBarred2
	 */
	public String getTimeBarred2() {
		return this.timeBarred2;
	}
	
	/**
	 * Column Info
	 * @return withdrawn
	 */
	public String getWithdrawn() {
		return this.withdrawn;
	}
	
	/**
	 * Column Info
	 * @return paidDp2
	 */
	public String getPaidDp2() {
		return this.paidDp2;
	}
	
	/**
	 * Column Info
	 * @return insRecovered2
	 */
	public String getInsRecovered2() {
		return this.insRecovered2;
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
	 * @return outstandingP2
	 */
	public String getOutstandingP2() {
		return this.outstandingP2;
	}
	
	/**
	 * Column Info
	 * @return withdrawn2
	 */
	public String getWithdrawn2() {
		return this.withdrawn2;
	}
	
	/**
	 * Column Info
	 * @return reportBy
	 */
	public String getReportBy() {
		return this.reportBy;
	}
	
	/**
	 * Column Info
	 * @return insRecoveredP2
	 */
	public String getInsRecoveredP2() {
		return this.insRecoveredP2;
	}
	
	/**
	 * Column Info
	 * @return tenderDefence
	 */
	public String getTenderDefence() {
		return this.tenderDefence;
	}
	
	/**
	 * Column Info
	 * @return dataSeq2
	 */
	public String getDataSeq2() {
		return this.dataSeq2;
	}
	
	/**
	 * Column Info
	 * @return paidDpP2
	 */
	public String getPaidDpP2() {
		return this.paidDpP2;
	}
	
	/**
	 * Column Info
	 * @return totalRecovered2
	 */
	public String getTotalRecovered2() {
		return this.totalRecovered2;
	}
	
	/**
	 * Column Info
	 * @return insRecovered
	 */
	public String getInsRecovered() {
		return this.insRecovered;
	}
	
	/**
	 * Column Info
	 * @return insRecoveredP
	 */
	public String getInsRecoveredP() {
		return this.insRecoveredP;
	}
	
	/**
	 * Column Info
	 * @return netPaidP2
	 */
	public String getNetPaidP2() {
		return this.netPaidP2;
	}
	
	/**
	 * Column Info
	 * @return lpRecoveredP
	 */
	public String getLpRecoveredP() {
		return this.lpRecoveredP;
	}
	
	/**
	 * Column Info
	 * @return reportBy2
	 */
	public String getReportBy2() {
		return this.reportBy2;
	}
	
	/**
	 * Column Info
	 * @return totalRecoveredP2
	 */
	public String getTotalRecoveredP2() {
		return this.totalRecoveredP2;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return netPaid
	 */
	public String getNetPaid() {
		return this.netPaid;
	}
	
	/**
	 * Column Info
	 * @return dataSeq
	 */
	public String getDataSeq() {
		return this.dataSeq;
	}
	
	/**
	 * Column Info
	 * @return claimed2
	 */
	public String getClaimed2() {
		return this.claimed2;
	}
	
	/**
	 * Column Info
	 * @return outstandingP
	 */
	public String getOutstandingP() {
		return this.outstandingP;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return lpRecovered2
	 */
	public String getLpRecovered2() {
		return this.lpRecovered2;
	}
	
	/**
	 * Column Info
	 * @return dismissed2
	 */
	public String getDismissed2() {
		return this.dismissed2;
	}
	
	/**
	 * Column Info
	 * @return repudiated2
	 */
	public String getRepudiated2() {
		return this.repudiated2;
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
	 * @return paid
	 */
	public String getPaid() {
		return this.paid;
	}
	
	/**
	 * Column Info
	 * @return timeBarred
	 */
	public String getTimeBarred() {
		return this.timeBarred;
	}
	
	/**
	 * Column Info
	 * @return totalRecovered
	 */
	public String getTotalRecovered() {
		return this.totalRecovered;
	}
	
	/**
	 * Column Info
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}
	
	/**
	 * Column Info
	 * @return netPaid2
	 */
	public String getNetPaid2() {
		return this.netPaid2;
	}
	
	/**
	 * Column Info
	 * @return outstanding
	 */
	public String getOutstanding() {
		return this.outstanding;
	}
	
	/**
	 * Column Info
	 * @return div2
	 */
	public String getDiv2() {
		return this.div2;
	}
	
	/**
	 * Column Info
	 * @return dismissed
	 */
	public String getDismissed() {
		return this.dismissed;
	}
	
	/**
	 * Column Info
	 * @return tot2
	 */
	public String getTot2() {
		return this.tot2;
	}
	
	/**
	 * Column Info
	 * @return paidDpP
	 */
	public String getPaidDpP() {
		return this.paidDpP;
	}
	
	/**
	 * Column Info
	 * @return paid2
	 */
	public String getPaid2() {
		return this.paid2;
	}
	
	/**
	 * Column Info
	 * @return outstanding2
	 */
	public String getOutstanding2() {
		return this.outstanding2;
	}
	
	/**
	 * Column Info
	 * @return paidDp
	 */
	public String getPaidDp() {
		return this.paidDp;
	}
	
	/**
	 * Column Info
	 * @return lpRecoveredP2
	 */
	public String getLpRecoveredP2() {
		return this.lpRecoveredP2;
	}
	
	/**
	 * Column Info
	 * @return lpRecovered
	 */
	public String getLpRecovered() {
		return this.lpRecovered;
	}
	
	/**
	 * Column Info
	 * @return repudiated
	 */
	public String getRepudiated() {
		return this.repudiated;
	}
	
	/**
	 * Column Info
	 * @return netPaidP
	 */
	public String getNetPaidP() {
		return this.netPaidP;
	}
	
	/**
	 * Column Info
	 * @return totalRecoveredP
	 */
	public String getTotalRecoveredP() {
		return this.totalRecoveredP;
	}
	
	/**
	 * Column Info
	 * @return claimed
	 */
	public String getClaimed() {
		return this.claimed;
	}
	
	/**
	 * Column Info
	 * @return tenderDefence2
	 */
	public String getTenderDefence2() {
		return this.tenderDefence2;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param timeBarred2
	 */
	public void setTimeBarred2(String timeBarred2) {
		this.timeBarred2 = timeBarred2;
	}
	
	/**
	 * Column Info
	 * @param withdrawn
	 */
	public void setWithdrawn(String withdrawn) {
		this.withdrawn = withdrawn;
	}
	
	/**
	 * Column Info
	 * @param paidDp2
	 */
	public void setPaidDp2(String paidDp2) {
		this.paidDp2 = paidDp2;
	}
	
	/**
	 * Column Info
	 * @param insRecovered2
	 */
	public void setInsRecovered2(String insRecovered2) {
		this.insRecovered2 = insRecovered2;
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
	 * @param outstandingP2
	 */
	public void setOutstandingP2(String outstandingP2) {
		this.outstandingP2 = outstandingP2;
	}
	
	/**
	 * Column Info
	 * @param withdrawn2
	 */
	public void setWithdrawn2(String withdrawn2) {
		this.withdrawn2 = withdrawn2;
	}
	
	/**
	 * Column Info
	 * @param reportBy
	 */
	public void setReportBy(String reportBy) {
		this.reportBy = reportBy;
	}
	
	/**
	 * Column Info
	 * @param insRecoveredP2
	 */
	public void setInsRecoveredP2(String insRecoveredP2) {
		this.insRecoveredP2 = insRecoveredP2;
	}
	
	/**
	 * Column Info
	 * @param tenderDefence
	 */
	public void setTenderDefence(String tenderDefence) {
		this.tenderDefence = tenderDefence;
	}
	
	/**
	 * Column Info
	 * @param dataSeq2
	 */
	public void setDataSeq2(String dataSeq2) {
		this.dataSeq2 = dataSeq2;
	}
	
	/**
	 * Column Info
	 * @param paidDpP2
	 */
	public void setPaidDpP2(String paidDpP2) {
		this.paidDpP2 = paidDpP2;
	}
	
	/**
	 * Column Info
	 * @param totalRecovered2
	 */
	public void setTotalRecovered2(String totalRecovered2) {
		this.totalRecovered2 = totalRecovered2;
	}
	
	/**
	 * Column Info
	 * @param insRecovered
	 */
	public void setInsRecovered(String insRecovered) {
		this.insRecovered = insRecovered;
	}
	
	/**
	 * Column Info
	 * @param insRecoveredP
	 */
	public void setInsRecoveredP(String insRecoveredP) {
		this.insRecoveredP = insRecoveredP;
	}
	
	/**
	 * Column Info
	 * @param netPaidP2
	 */
	public void setNetPaidP2(String netPaidP2) {
		this.netPaidP2 = netPaidP2;
	}
	
	/**
	 * Column Info
	 * @param lpRecoveredP
	 */
	public void setLpRecoveredP(String lpRecoveredP) {
		this.lpRecoveredP = lpRecoveredP;
	}
	
	/**
	 * Column Info
	 * @param reportBy2
	 */
	public void setReportBy2(String reportBy2) {
		this.reportBy2 = reportBy2;
	}
	
	/**
	 * Column Info
	 * @param totalRecoveredP2
	 */
	public void setTotalRecoveredP2(String totalRecoveredP2) {
		this.totalRecoveredP2 = totalRecoveredP2;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param netPaid
	 */
	public void setNetPaid(String netPaid) {
		this.netPaid = netPaid;
	}
	
	/**
	 * Column Info
	 * @param dataSeq
	 */
	public void setDataSeq(String dataSeq) {
		this.dataSeq = dataSeq;
	}
	
	/**
	 * Column Info
	 * @param claimed2
	 */
	public void setClaimed2(String claimed2) {
		this.claimed2 = claimed2;
	}
	
	/**
	 * Column Info
	 * @param outstandingP
	 */
	public void setOutstandingP(String outstandingP) {
		this.outstandingP = outstandingP;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param lpRecovered2
	 */
	public void setLpRecovered2(String lpRecovered2) {
		this.lpRecovered2 = lpRecovered2;
	}
	
	/**
	 * Column Info
	 * @param dismissed2
	 */
	public void setDismissed2(String dismissed2) {
		this.dismissed2 = dismissed2;
	}
	
	/**
	 * Column Info
	 * @param repudiated2
	 */
	public void setRepudiated2(String repudiated2) {
		this.repudiated2 = repudiated2;
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
	 * @param paid
	 */
	public void setPaid(String paid) {
		this.paid = paid;
	}
	
	/**
	 * Column Info
	 * @param timeBarred
	 */
	public void setTimeBarred(String timeBarred) {
		this.timeBarred = timeBarred;
	}
	
	/**
	 * Column Info
	 * @param totalRecovered
	 */
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}
	
	/**
	 * Column Info
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	
	/**
	 * Column Info
	 * @param netPaid2
	 */
	public void setNetPaid2(String netPaid2) {
		this.netPaid2 = netPaid2;
	}
	
	/**
	 * Column Info
	 * @param outstanding
	 */
	public void setOutstanding(String outstanding) {
		this.outstanding = outstanding;
	}
	
	/**
	 * Column Info
	 * @param div2
	 */
	public void setDiv2(String div2) {
		this.div2 = div2;
	}
	
	/**
	 * Column Info
	 * @param dismissed
	 */
	public void setDismissed(String dismissed) {
		this.dismissed = dismissed;
	}
	
	/**
	 * Column Info
	 * @param tot2
	 */
	public void setTot2(String tot2) {
		this.tot2 = tot2;
	}
	
	/**
	 * Column Info
	 * @param paidDpP
	 */
	public void setPaidDpP(String paidDpP) {
		this.paidDpP = paidDpP;
	}
	
	/**
	 * Column Info
	 * @param paid2
	 */
	public void setPaid2(String paid2) {
		this.paid2 = paid2;
	}
	
	/**
	 * Column Info
	 * @param outstanding2
	 */
	public void setOutstanding2(String outstanding2) {
		this.outstanding2 = outstanding2;
	}
	
	/**
	 * Column Info
	 * @param paidDp
	 */
	public void setPaidDp(String paidDp) {
		this.paidDp = paidDp;
	}
	
	/**
	 * Column Info
	 * @param lpRecoveredP2
	 */
	public void setLpRecoveredP2(String lpRecoveredP2) {
		this.lpRecoveredP2 = lpRecoveredP2;
	}
	
	/**
	 * Column Info
	 * @param lpRecovered
	 */
	public void setLpRecovered(String lpRecovered) {
		this.lpRecovered = lpRecovered;
	}
	
	/**
	 * Column Info
	 * @param repudiated
	 */
	public void setRepudiated(String repudiated) {
		this.repudiated = repudiated;
	}
	
	/**
	 * Column Info
	 * @param netPaidP
	 */
	public void setNetPaidP(String netPaidP) {
		this.netPaidP = netPaidP;
	}
	
	/**
	 * Column Info
	 * @param totalRecoveredP
	 */
	public void setTotalRecoveredP(String totalRecoveredP) {
		this.totalRecoveredP = totalRecoveredP;
	}
	
	/**
	 * Column Info
	 * @param claimed
	 */
	public void setClaimed(String claimed) {
		this.claimed = claimed;
	}
	
	/**
	 * Column Info
	 * @param tenderDefence2
	 */
	public void setTenderDefence2(String tenderDefence2) {
		this.tenderDefence2 = tenderDefence2;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setTimeBarred2(JSPUtil.getParameter(request, prefix + "time_barred2", ""));
		setWithdrawn(JSPUtil.getParameter(request, prefix + "withdrawn", ""));
		setPaidDp2(JSPUtil.getParameter(request, prefix + "paid_dp2", ""));
		setInsRecovered2(JSPUtil.getParameter(request, prefix + "ins_recovered2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOutstandingP2(JSPUtil.getParameter(request, prefix + "outstanding_p2", ""));
		setWithdrawn2(JSPUtil.getParameter(request, prefix + "withdrawn2", ""));
		setReportBy(JSPUtil.getParameter(request, prefix + "report_by", ""));
		setInsRecoveredP2(JSPUtil.getParameter(request, prefix + "ins_recovered_p2", ""));
		setTenderDefence(JSPUtil.getParameter(request, prefix + "tender_defence", ""));
		setDataSeq2(JSPUtil.getParameter(request, prefix + "data_seq2", ""));
		setPaidDpP2(JSPUtil.getParameter(request, prefix + "paid_dp_p2", ""));
		setTotalRecovered2(JSPUtil.getParameter(request, prefix + "total_recovered2", ""));
		setInsRecovered(JSPUtil.getParameter(request, prefix + "ins_recovered", ""));
		setInsRecoveredP(JSPUtil.getParameter(request, prefix + "ins_recovered_p", ""));
		setNetPaidP2(JSPUtil.getParameter(request, prefix + "net_paid_p2", ""));
		setLpRecoveredP(JSPUtil.getParameter(request, prefix + "lp_recovered_p", ""));
		setReportBy2(JSPUtil.getParameter(request, prefix + "report_by2", ""));
		setTotalRecoveredP2(JSPUtil.getParameter(request, prefix + "total_recovered_p2", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setNetPaid(JSPUtil.getParameter(request, prefix + "net_paid", ""));
		setDataSeq(JSPUtil.getParameter(request, prefix + "data_seq", ""));
		setClaimed2(JSPUtil.getParameter(request, prefix + "claimed2", ""));
		setOutstandingP(JSPUtil.getParameter(request, prefix + "outstanding_p", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setLpRecovered2(JSPUtil.getParameter(request, prefix + "lp_recovered2", ""));
		setDismissed2(JSPUtil.getParameter(request, prefix + "dismissed2", ""));
		setRepudiated2(JSPUtil.getParameter(request, prefix + "repudiated2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPaid(JSPUtil.getParameter(request, prefix + "paid", ""));
		setTimeBarred(JSPUtil.getParameter(request, prefix + "time_barred", ""));
		setTotalRecovered(JSPUtil.getParameter(request, prefix + "total_recovered", ""));
		setTot(JSPUtil.getParameter(request, prefix + "tot", ""));
		setNetPaid2(JSPUtil.getParameter(request, prefix + "net_paid2", ""));
		setOutstanding(JSPUtil.getParameter(request, prefix + "outstanding", ""));
		setDiv2(JSPUtil.getParameter(request, prefix + "div2", ""));
		setDismissed(JSPUtil.getParameter(request, prefix + "dismissed", ""));
		setTot2(JSPUtil.getParameter(request, prefix + "tot2", ""));
		setPaidDpP(JSPUtil.getParameter(request, prefix + "paid_dp_p", ""));
		setPaid2(JSPUtil.getParameter(request, prefix + "paid2", ""));
		setOutstanding2(JSPUtil.getParameter(request, prefix + "outstanding2", ""));
		setPaidDp(JSPUtil.getParameter(request, prefix + "paid_dp", ""));
		setLpRecoveredP2(JSPUtil.getParameter(request, prefix + "lp_recovered_p2", ""));
		setLpRecovered(JSPUtil.getParameter(request, prefix + "lp_recovered", ""));
		setRepudiated(JSPUtil.getParameter(request, prefix + "repudiated", ""));
		setNetPaidP(JSPUtil.getParameter(request, prefix + "net_paid_p", ""));
		setTotalRecoveredP(JSPUtil.getParameter(request, prefix + "total_recovered_p", ""));
		setClaimed(JSPUtil.getParameter(request, prefix + "claimed", ""));
		setTenderDefence2(JSPUtil.getParameter(request, prefix + "tender_defence2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementAnalysisVO[]
	 */
	public SettlementAnalysisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SettlementAnalysisVO[]
	 */
	public SettlementAnalysisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SettlementAnalysisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] timeBarred2 = (JSPUtil.getParameter(request, prefix	+ "time_barred2", length));
			String[] withdrawn = (JSPUtil.getParameter(request, prefix	+ "withdrawn", length));
			String[] paidDp2 = (JSPUtil.getParameter(request, prefix	+ "paid_dp2", length));
			String[] insRecovered2 = (JSPUtil.getParameter(request, prefix	+ "ins_recovered2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] outstandingP2 = (JSPUtil.getParameter(request, prefix	+ "outstanding_p2", length));
			String[] withdrawn2 = (JSPUtil.getParameter(request, prefix	+ "withdrawn2", length));
			String[] reportBy = (JSPUtil.getParameter(request, prefix	+ "report_by", length));
			String[] insRecoveredP2 = (JSPUtil.getParameter(request, prefix	+ "ins_recovered_p2", length));
			String[] tenderDefence = (JSPUtil.getParameter(request, prefix	+ "tender_defence", length));
			String[] dataSeq2 = (JSPUtil.getParameter(request, prefix	+ "data_seq2", length));
			String[] paidDpP2 = (JSPUtil.getParameter(request, prefix	+ "paid_dp_p2", length));
			String[] totalRecovered2 = (JSPUtil.getParameter(request, prefix	+ "total_recovered2", length));
			String[] insRecovered = (JSPUtil.getParameter(request, prefix	+ "ins_recovered", length));
			String[] insRecoveredP = (JSPUtil.getParameter(request, prefix	+ "ins_recovered_p", length));
			String[] netPaidP2 = (JSPUtil.getParameter(request, prefix	+ "net_paid_p2", length));
			String[] lpRecoveredP = (JSPUtil.getParameter(request, prefix	+ "lp_recovered_p", length));
			String[] reportBy2 = (JSPUtil.getParameter(request, prefix	+ "report_by2", length));
			String[] totalRecoveredP2 = (JSPUtil.getParameter(request, prefix	+ "total_recovered_p2", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] netPaid = (JSPUtil.getParameter(request, prefix	+ "net_paid", length));
			String[] dataSeq = (JSPUtil.getParameter(request, prefix	+ "data_seq", length));
			String[] claimed2 = (JSPUtil.getParameter(request, prefix	+ "claimed2", length));
			String[] outstandingP = (JSPUtil.getParameter(request, prefix	+ "outstanding_p", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] lpRecovered2 = (JSPUtil.getParameter(request, prefix	+ "lp_recovered2", length));
			String[] dismissed2 = (JSPUtil.getParameter(request, prefix	+ "dismissed2", length));
			String[] repudiated2 = (JSPUtil.getParameter(request, prefix	+ "repudiated2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] paid = (JSPUtil.getParameter(request, prefix	+ "paid", length));
			String[] timeBarred = (JSPUtil.getParameter(request, prefix	+ "time_barred", length));
			String[] totalRecovered = (JSPUtil.getParameter(request, prefix	+ "total_recovered", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			String[] netPaid2 = (JSPUtil.getParameter(request, prefix	+ "net_paid2", length));
			String[] outstanding = (JSPUtil.getParameter(request, prefix	+ "outstanding", length));
			String[] div2 = (JSPUtil.getParameter(request, prefix	+ "div2", length));
			String[] dismissed = (JSPUtil.getParameter(request, prefix	+ "dismissed", length));
			String[] tot2 = (JSPUtil.getParameter(request, prefix	+ "tot2", length));
			String[] paidDpP = (JSPUtil.getParameter(request, prefix	+ "paid_dp_p", length));
			String[] paid2 = (JSPUtil.getParameter(request, prefix	+ "paid2", length));
			String[] outstanding2 = (JSPUtil.getParameter(request, prefix	+ "outstanding2", length));
			String[] paidDp = (JSPUtil.getParameter(request, prefix	+ "paid_dp", length));
			String[] lpRecoveredP2 = (JSPUtil.getParameter(request, prefix	+ "lp_recovered_p2", length));
			String[] lpRecovered = (JSPUtil.getParameter(request, prefix	+ "lp_recovered", length));
			String[] repudiated = (JSPUtil.getParameter(request, prefix	+ "repudiated", length));
			String[] netPaidP = (JSPUtil.getParameter(request, prefix	+ "net_paid_p", length));
			String[] totalRecoveredP = (JSPUtil.getParameter(request, prefix	+ "total_recovered_p", length));
			String[] claimed = (JSPUtil.getParameter(request, prefix	+ "claimed", length));
			String[] tenderDefence2 = (JSPUtil.getParameter(request, prefix	+ "tender_defence2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SettlementAnalysisVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (timeBarred2[i] != null)
					model.setTimeBarred2(timeBarred2[i]);
				if (withdrawn[i] != null)
					model.setWithdrawn(withdrawn[i]);
				if (paidDp2[i] != null)
					model.setPaidDp2(paidDp2[i]);
				if (insRecovered2[i] != null)
					model.setInsRecovered2(insRecovered2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (outstandingP2[i] != null)
					model.setOutstandingP2(outstandingP2[i]);
				if (withdrawn2[i] != null)
					model.setWithdrawn2(withdrawn2[i]);
				if (reportBy[i] != null)
					model.setReportBy(reportBy[i]);
				if (insRecoveredP2[i] != null)
					model.setInsRecoveredP2(insRecoveredP2[i]);
				if (tenderDefence[i] != null)
					model.setTenderDefence(tenderDefence[i]);
				if (dataSeq2[i] != null)
					model.setDataSeq2(dataSeq2[i]);
				if (paidDpP2[i] != null)
					model.setPaidDpP2(paidDpP2[i]);
				if (totalRecovered2[i] != null)
					model.setTotalRecovered2(totalRecovered2[i]);
				if (insRecovered[i] != null)
					model.setInsRecovered(insRecovered[i]);
				if (insRecoveredP[i] != null)
					model.setInsRecoveredP(insRecoveredP[i]);
				if (netPaidP2[i] != null)
					model.setNetPaidP2(netPaidP2[i]);
				if (lpRecoveredP[i] != null)
					model.setLpRecoveredP(lpRecoveredP[i]);
				if (reportBy2[i] != null)
					model.setReportBy2(reportBy2[i]);
				if (totalRecoveredP2[i] != null)
					model.setTotalRecoveredP2(totalRecoveredP2[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (netPaid[i] != null)
					model.setNetPaid(netPaid[i]);
				if (dataSeq[i] != null)
					model.setDataSeq(dataSeq[i]);
				if (claimed2[i] != null)
					model.setClaimed2(claimed2[i]);
				if (outstandingP[i] != null)
					model.setOutstandingP(outstandingP[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (lpRecovered2[i] != null)
					model.setLpRecovered2(lpRecovered2[i]);
				if (dismissed2[i] != null)
					model.setDismissed2(dismissed2[i]);
				if (repudiated2[i] != null)
					model.setRepudiated2(repudiated2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (paid[i] != null)
					model.setPaid(paid[i]);
				if (timeBarred[i] != null)
					model.setTimeBarred(timeBarred[i]);
				if (totalRecovered[i] != null)
					model.setTotalRecovered(totalRecovered[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (netPaid2[i] != null)
					model.setNetPaid2(netPaid2[i]);
				if (outstanding[i] != null)
					model.setOutstanding(outstanding[i]);
				if (div2[i] != null)
					model.setDiv2(div2[i]);
				if (dismissed[i] != null)
					model.setDismissed(dismissed[i]);
				if (tot2[i] != null)
					model.setTot2(tot2[i]);
				if (paidDpP[i] != null)
					model.setPaidDpP(paidDpP[i]);
				if (paid2[i] != null)
					model.setPaid2(paid2[i]);
				if (outstanding2[i] != null)
					model.setOutstanding2(outstanding2[i]);
				if (paidDp[i] != null)
					model.setPaidDp(paidDp[i]);
				if (lpRecoveredP2[i] != null)
					model.setLpRecoveredP2(lpRecoveredP2[i]);
				if (lpRecovered[i] != null)
					model.setLpRecovered(lpRecovered[i]);
				if (repudiated[i] != null)
					model.setRepudiated(repudiated[i]);
				if (netPaidP[i] != null)
					model.setNetPaidP(netPaidP[i]);
				if (totalRecoveredP[i] != null)
					model.setTotalRecoveredP(totalRecoveredP[i]);
				if (claimed[i] != null)
					model.setClaimed(claimed[i]);
				if (tenderDefence2[i] != null)
					model.setTenderDefence2(tenderDefence2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSettlementAnalysisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SettlementAnalysisVO[]
	 */
	public SettlementAnalysisVO[] getSettlementAnalysisVOs(){
		SettlementAnalysisVO[] vos = (SettlementAnalysisVO[])models.toArray(new SettlementAnalysisVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeBarred2 = this.timeBarred2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.withdrawn = this.withdrawn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paidDp2 = this.paidDp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insRecovered2 = this.insRecovered2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outstandingP2 = this.outstandingP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.withdrawn2 = this.withdrawn2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportBy = this.reportBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insRecoveredP2 = this.insRecoveredP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tenderDefence = this.tenderDefence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataSeq2 = this.dataSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paidDpP2 = this.paidDpP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRecovered2 = this.totalRecovered2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insRecovered = this.insRecovered .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insRecoveredP = this.insRecoveredP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netPaidP2 = this.netPaidP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lpRecoveredP = this.lpRecoveredP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportBy2 = this.reportBy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRecoveredP2 = this.totalRecoveredP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netPaid = this.netPaid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataSeq = this.dataSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimed2 = this.claimed2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outstandingP = this.outstandingP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lpRecovered2 = this.lpRecovered2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dismissed2 = this.dismissed2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repudiated2 = this.repudiated2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paid = this.paid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timeBarred = this.timeBarred .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRecovered = this.totalRecovered .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netPaid2 = this.netPaid2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outstanding = this.outstanding .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div2 = this.div2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dismissed = this.dismissed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot2 = this.tot2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paidDpP = this.paidDpP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paid2 = this.paid2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outstanding2 = this.outstanding2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paidDp = this.paidDp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lpRecoveredP2 = this.lpRecoveredP2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lpRecovered = this.lpRecovered .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repudiated = this.repudiated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netPaidP = this.netPaidP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRecoveredP = this.totalRecoveredP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimed = this.claimed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tenderDefence2 = this.tenderDefence2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
