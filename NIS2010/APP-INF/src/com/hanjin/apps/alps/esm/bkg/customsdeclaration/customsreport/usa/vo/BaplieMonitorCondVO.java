/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchBaplieMonitorVO.java
*@FileTitle : SearchBaplieMonitorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.22
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.06.22 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BaplieMonitorCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BaplieMonitorCondVO> models = new ArrayList<BaplieMonitorCondVO>();
	
	/* Column Info */
	private String sndSts = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String ackKnt = null;
	/* Column Info */
	private String srchDt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String dueToDt = null;
	/* Column Info */
	private String dueToTm = null;
	/* Column Info */
	private String rejKnt = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String cstmsRslt = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String totCntrKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lPol = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String sndKnt = null;
	/* Column Info */
	private String due = null;
	/* Column Info */
	private String dueFromDt = null;
	/* Column Info */
	private String dueFromTm = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String customs = null;
	/* Column Info */
	private String miSts = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String customsGb = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BaplieMonitorCondVO() {}

	public BaplieMonitorCondVO(String ibflag, String pagerows, String crrCd, String vvd, String rhq, String lPol, String cstmsPortCd, String totCntrKnt, String cntrCnt, String sndKnt, String ackKnt, String rejKnt, String cstmsRslt, String sndSts, String sndDt, String atd, String due, String rcvDt, String miSts, String dueFromDt, String dueToDt, String dueFromTm, String dueToTm, String lane, String customs, String srchDt, String customsGb) {
		this.sndSts = sndSts;
		this.cntrCnt = cntrCnt;
		this.ackKnt = ackKnt;
		this.srchDt = srchDt;
		this.sndDt = sndDt;
		this.dueToDt = dueToDt;
		this.dueToDt = dueToTm;
		this.rejKnt = rejKnt;
		this.crrCd = crrCd;
		this.cstmsRslt = cstmsRslt;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.totCntrKnt = totCntrKnt;
		this.ibflag = ibflag;
		this.lPol = lPol;
		this.rcvDt = rcvDt;
		this.sndKnt = sndKnt;
		this.due = due;
		this.dueFromDt = dueFromDt;
		this.dueFromDt = dueFromTm;
		this.atd = atd;
		this.customs = customs;
		this.miSts = miSts;
		this.cstmsPortCd = cstmsPortCd;
		this.rhq = rhq;
		this.customsGb = customsGb;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("snd_sts", getSndSts());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("ack_knt", getAckKnt());
		this.hashColumns.put("srch_dt", getSrchDt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("due_to_dt", getDueToDt());
		this.hashColumns.put("due_to_tm", getDueToTm());
		this.hashColumns.put("rej_knt", getRejKnt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("cstms_rslt", getCstmsRslt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("tot_cntr_knt", getTotCntrKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("l_pol", getLPol());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("snd_knt", getSndKnt());
		this.hashColumns.put("due", getDue());
		this.hashColumns.put("due_from_dt", getDueFromDt());
		this.hashColumns.put("due_from_tm", getDueFromTm());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("customs", getCustoms());
		this.hashColumns.put("mi_sts", getMiSts());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("customs_gb", getCustomsGb());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("snd_sts", "sndSts");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("ack_knt", "ackKnt");
		this.hashFields.put("srch_dt", "srchDt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("due_to_dt", "dueToDt");
		this.hashFields.put("due_to_tm", "dueToTm");
		this.hashFields.put("rej_knt", "rejKnt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("cstms_rslt", "cstmsRslt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("tot_cntr_knt", "totCntrKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("l_pol", "lPol");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("snd_knt", "sndKnt");
		this.hashFields.put("due", "due");
		this.hashFields.put("due_from_dt", "dueFromDt");
		this.hashFields.put("due_from_tm", "dueFromTm");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("customs", "customs");
		this.hashFields.put("mi_sts", "miSts");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("customs_gb", "customsGb");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sndSts
	 */
	public String getSndSts() {
		return this.sndSts;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return ackKnt
	 */
	public String getAckKnt() {
		return this.ackKnt;
	}
	
	/**
	 * Column Info
	 * @return srchDt
	 */
	public String getSrchDt() {
		return this.srchDt;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return dueToDt
	 */
	public String getDueToDt() {
		return this.dueToDt;
	}
	
	/**
	 * Column Info
	 * @return dueToDt
	 */
	public String getDueToTm() {
		return this.dueToTm;
	}
	
	/**
	 * Column Info
	 * @return rejKnt
	 */
	public String getRejKnt() {
		return this.rejKnt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsRslt
	 */
	public String getCstmsRslt() {
		return this.cstmsRslt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return totCntrKnt
	 */
	public String getTotCntrKnt() {
		return this.totCntrKnt;
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
	 * @return lPol
	 */
	public String getLPol() {
		return this.lPol;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return sndKnt
	 */
	public String getSndKnt() {
		return this.sndKnt;
	}
	
	/**
	 * Column Info
	 * @return due
	 */
	public String getDue() {
		return this.due;
	}
	
	/**
	 * Column Info
	 * @return dueFromDt
	 */
	public String getDueFromDt() {
		return this.dueFromDt;
	}
	
	/**
	 * Column Info
	 * @return dueFromDt
	 */
	public String getDueFromTm() {
		return this.dueFromTm;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return customs
	 */
	public String getCustoms() {
		return this.customs;
	}
	
	/**
	 * Column Info
	 * @return miSts
	 */
	public String getMiSts() {
		return this.miSts;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return customs_gb
	 */
	public String getCustomsGb() {
		return this.customsGb;
	}
	

	/**
	 * Column Info
	 * @param sndSts
	 */
	public void setSndSts(String sndSts) {
		this.sndSts = sndSts;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param ackKnt
	 */
	public void setAckKnt(String ackKnt) {
		this.ackKnt = ackKnt;
	}
	
	/**
	 * Column Info
	 * @param srchDt
	 */
	public void setSrchDt(String srchDt) {
		this.srchDt = srchDt;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param dueToDt
	 */
	public void setDueToDt(String dueToDt) {
		this.dueToDt = dueToDt;
	}
	
	/**
	 * Column Info
	 * @param dueToDt
	 */
	public void setDueToTm(String dueToTm) {
		this.dueToTm = dueToTm;
	}
	
	/**
	 * Column Info
	 * @param rejKnt
	 */
	public void setRejKnt(String rejKnt) {
		this.rejKnt = rejKnt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsRslt
	 */
	public void setCstmsRslt(String cstmsRslt) {
		this.cstmsRslt = cstmsRslt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param totCntrKnt
	 */
	public void setTotCntrKnt(String totCntrKnt) {
		this.totCntrKnt = totCntrKnt;
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
	 * @param lPol
	 */
	public void setLPol(String lPol) {
		this.lPol = lPol;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param sndKnt
	 */
	public void setSndKnt(String sndKnt) {
		this.sndKnt = sndKnt;
	}
	
	/**
	 * Column Info
	 * @param due
	 */
	public void setDue(String due) {
		this.due = due;
	}
	
	/**
	 * Column Info
	 * @param dueFromDt
	 */
	public void setDueFromDt(String dueFromDt) {
		this.dueFromDt = dueFromDt;
	}
	
	/**
	 * Column Info
	 * @param dueFromDt
	 */
	public void setDueFromTm(String dueFromTm) {
		this.dueFromTm = dueFromTm;
	}
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param customs
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	/**
	 * Column Info
	 * @param miSts
	 */
	public void setMiSts(String miSts) {
		this.miSts = miSts;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param customs_gb
	 */
	public void setCustomsGb(String customsGb) {
		this.customsGb = customsGb;
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
		setSndSts(JSPUtil.getParameter(request, prefix + "snd_sts", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setAckKnt(JSPUtil.getParameter(request, prefix + "ack_knt", ""));
		setSrchDt(JSPUtil.getParameter(request, prefix + "srch_dt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setDueToDt(JSPUtil.getParameter(request, prefix + "due_to_dt", ""));
		setDueToTm(JSPUtil.getParameter(request, prefix + "due_to_tm", ""));
		setRejKnt(JSPUtil.getParameter(request, prefix + "rej_knt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setCstmsRslt(JSPUtil.getParameter(request, prefix + "cstms_rslt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setTotCntrKnt(JSPUtil.getParameter(request, prefix + "tot_cntr_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLPol(JSPUtil.getParameter(request, prefix + "l_pol", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setSndKnt(JSPUtil.getParameter(request, prefix + "snd_knt", ""));
		setDue(JSPUtil.getParameter(request, prefix + "due", ""));
		setDueFromDt(JSPUtil.getParameter(request, prefix + "due_from_dt", ""));
		setDueFromTm(JSPUtil.getParameter(request, prefix + "due_from_tm", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setCustoms(JSPUtil.getParameter(request, prefix + "customs", ""));
		setMiSts(JSPUtil.getParameter(request, prefix + "mi_sts", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setCustomsGb(JSPUtil.getParameter(request, prefix + "customs_gb", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBaplieMonitorVO[]
	 */
	public BaplieMonitorCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBaplieMonitorVO[]
	 */
	public BaplieMonitorCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BaplieMonitorCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sndSts = (JSPUtil.getParameter(request, prefix	+ "snd_sts", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] ackKnt = (JSPUtil.getParameter(request, prefix	+ "ack_knt", length));
			String[] srchDt = (JSPUtil.getParameter(request, prefix	+ "srch_dt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] dueToDt = (JSPUtil.getParameter(request, prefix	+ "due_to_dt", length));
			String[] dueToTm = (JSPUtil.getParameter(request, prefix	+ "due_to_tm", length));
			String[] rejKnt = (JSPUtil.getParameter(request, prefix	+ "rej_knt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] cstmsRslt = (JSPUtil.getParameter(request, prefix	+ "cstms_rslt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] totCntrKnt = (JSPUtil.getParameter(request, prefix	+ "tot_cntr_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lPol = (JSPUtil.getParameter(request, prefix	+ "l_pol", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] sndKnt = (JSPUtil.getParameter(request, prefix	+ "snd_knt", length));
			String[] due = (JSPUtil.getParameter(request, prefix	+ "due", length));
			String[] dueFromDt = (JSPUtil.getParameter(request, prefix	+ "due_from_dt", length));
			String[] dueFromTm = (JSPUtil.getParameter(request, prefix	+ "due_from_tm", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] customs = (JSPUtil.getParameter(request, prefix	+ "customs", length));
			String[] miSts = (JSPUtil.getParameter(request, prefix	+ "mi_sts", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] customsGb = (JSPUtil.getParameter(request, prefix	+ "customs_gb", length));
			
			for (int i = 0; i < length; i++) {
				model = new BaplieMonitorCondVO();
				if (sndSts[i] != null)
					model.setSndSts(sndSts[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (ackKnt[i] != null)
					model.setAckKnt(ackKnt[i]);
				if (srchDt[i] != null)
					model.setSrchDt(srchDt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (dueToDt[i] != null)
					model.setDueToDt(dueToDt[i]);
				if (dueToTm[i] != null)
					model.setDueToDt(dueToTm[i]);
				if (rejKnt[i] != null)
					model.setRejKnt(rejKnt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (cstmsRslt[i] != null)
					model.setCstmsRslt(cstmsRslt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (totCntrKnt[i] != null)
					model.setTotCntrKnt(totCntrKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lPol[i] != null)
					model.setLPol(lPol[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (sndKnt[i] != null)
					model.setSndKnt(sndKnt[i]);
				if (due[i] != null)
					model.setDue(due[i]);
				if (dueFromDt[i] != null)
					model.setDueFromDt(dueFromDt[i]);
				if (dueFromTm[i] != null)
					model.setDueFromDt(dueFromTm[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (customs[i] != null)
					model.setCustoms(customs[i]);
				if (miSts[i] != null)
					model.setMiSts(miSts[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (customsGb[i] != null)
					model.setCustomsGb(customsGb[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBaplieMonitorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBaplieMonitorVO[]
	 */
	public BaplieMonitorCondVO[] getSearchBaplieMonitorVOs(){
		BaplieMonitorCondVO[] vos = (BaplieMonitorCondVO[])models.toArray(new BaplieMonitorCondVO[models.size()]);
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
		this.sndSts = this.sndSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackKnt = this.ackKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srchDt = this.srchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueToDt = this.dueToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueToTm = this.dueToTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejKnt = this.rejKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRslt = this.cstmsRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCntrKnt = this.totCntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lPol = this.lPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndKnt = this.sndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.due = this.due .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueFromDt = this.dueFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueFromTm = this.dueFromTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customs = this.customs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miSts = this.miSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsGb = this.customsGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
