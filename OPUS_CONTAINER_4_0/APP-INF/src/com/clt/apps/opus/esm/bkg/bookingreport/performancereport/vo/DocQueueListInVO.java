/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocQueueListInVO.java
*@FileTitle : DocQueueListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.11.16 이일민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueListInVO> models = new ArrayList<DocQueueListInVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String pendingOnly = null;
	/* Column Info */
	private String svrCd = null;
	/* Column Info */
	private String qa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String input = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String queueStatus = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String duraToDt = null;
	/* Column Info */
	private String curQueue = null;
	/* Column Info */
	private String duraFromDt = null;
	/* Column Info */
	private String prtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueListInVO() {}

	public DocQueueListInVO(String ibflag, String pagerows, String vvdCd, String polCd, String podCd, String usrId, String prtCd, String svrCd, String ofcCd, String curQueue, String duraFromDt, String duraToDt, String queueStatus, String pendingOnly, String bkgNo, String bkgOfcCd, String input, String rate, String qa, String fax, String region, String sts, String currPage, String rowsPerPage) {
		this.region = region;
		this.bkgOfcCd = bkgOfcCd;
		this.fax = fax;
		this.pendingOnly = pendingOnly;
		this.svrCd = svrCd;
		this.qa = qa;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.rowsPerPage = rowsPerPage;
		this.input = input;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.queueStatus = queueStatus;
		this.currPage = currPage;
		this.rate = rate;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.sts = sts;
		this.duraToDt = duraToDt;
		this.curQueue = curQueue;
		this.duraFromDt = duraFromDt;
		this.prtCd = prtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("pending_only", getPendingOnly());
		this.hashColumns.put("svr_cd", getSvrCd());
		this.hashColumns.put("qa", getQa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("input", getInput());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("queue_status", getQueueStatus());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("dura_to_dt", getDuraToDt());
		this.hashColumns.put("cur_queue", getCurQueue());
		this.hashColumns.put("dura_from_dt", getDuraFromDt());
		this.hashColumns.put("prt_cd", getPrtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("pending_only", "pendingOnly");
		this.hashFields.put("svr_cd", "svrCd");
		this.hashFields.put("qa", "qa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("input", "input");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("queue_status", "queueStatus");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("dura_to_dt", "duraToDt");
		this.hashFields.put("cur_queue", "curQueue");
		this.hashFields.put("dura_from_dt", "duraFromDt");
		this.hashFields.put("prt_cd", "prtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return pendingOnly
	 */
	public String getPendingOnly() {
		return this.pendingOnly;
	}
	
	/**
	 * Column Info
	 * @return svrCd
	 */
	public String getSvrCd() {
		return this.svrCd;
	}
	
	/**
	 * Column Info
	 * @return qa
	 */
	public String getQa() {
		return this.qa;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return input
	 */
	public String getInput() {
		return this.input;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return queueStatus
	 */
	public String getQueueStatus() {
		return this.queueStatus;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return duraToDt
	 */
	public String getDuraToDt() {
		return this.duraToDt;
	}
	
	/**
	 * Column Info
	 * @return curQueue
	 */
	public String getCurQueue() {
		return this.curQueue;
	}
	
	/**
	 * Column Info
	 * @return duraFromDt
	 */
	public String getDuraFromDt() {
		return this.duraFromDt;
	}
	
	/**
	 * Column Info
	 * @return prtCd
	 */
	public String getPrtCd() {
		return this.prtCd;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param pendingOnly
	 */
	public void setPendingOnly(String pendingOnly) {
		this.pendingOnly = pendingOnly;
	}
	
	/**
	 * Column Info
	 * @param svrCd
	 */
	public void setSvrCd(String svrCd) {
		this.svrCd = svrCd;
	}
	
	/**
	 * Column Info
	 * @param qa
	 */
	public void setQa(String qa) {
		this.qa = qa;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param input
	 */
	public void setInput(String input) {
		this.input = input;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param queueStatus
	 */
	public void setQueueStatus(String queueStatus) {
		this.queueStatus = queueStatus;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param duraToDt
	 */
	public void setDuraToDt(String duraToDt) {
		this.duraToDt = duraToDt;
	}
	
	/**
	 * Column Info
	 * @param curQueue
	 */
	public void setCurQueue(String curQueue) {
		this.curQueue = curQueue;
	}
	
	/**
	 * Column Info
	 * @param duraFromDt
	 */
	public void setDuraFromDt(String duraFromDt) {
		this.duraFromDt = duraFromDt;
	}
	
	/**
	 * Column Info
	 * @param prtCd
	 */
	public void setPrtCd(String prtCd) {
		this.prtCd = prtCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRegion(JSPUtil.getParameter(request, "region", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setFax(JSPUtil.getParameter(request, "fax", ""));
		setPendingOnly(JSPUtil.getParameter(request, "pending_only", ""));
		setSvrCd(JSPUtil.getParameter(request, "svr_cd", ""));
		setQa(JSPUtil.getParameter(request, "qa", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, "rows_per_page", ""));
		setInput(JSPUtil.getParameter(request, "input", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setQueueStatus(JSPUtil.getParameter(request, "queue_status", ""));
		setCurrPage(JSPUtil.getParameter(request, "curr_page", ""));
		setRate(JSPUtil.getParameter(request, "rate", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
		setDuraToDt(JSPUtil.getParameter(request, "dura_to_dt", ""));
		setCurQueue(JSPUtil.getParameter(request, "cur_queue", ""));
		setDuraFromDt(JSPUtil.getParameter(request, "dura_from_dt", ""));
		setPrtCd(JSPUtil.getParameter(request, "prt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueListInVO[]
	 */
	public DocQueueListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueListInVO[]
	 */
	public DocQueueListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] pendingOnly = (JSPUtil.getParameter(request, prefix	+ "pending_only", length));
			String[] svrCd = (JSPUtil.getParameter(request, prefix	+ "svr_cd", length));
			String[] qa = (JSPUtil.getParameter(request, prefix	+ "qa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] input = (JSPUtil.getParameter(request, prefix	+ "input", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] queueStatus = (JSPUtil.getParameter(request, prefix	+ "queue_status", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] duraToDt = (JSPUtil.getParameter(request, prefix	+ "dura_to_dt", length));
			String[] curQueue = (JSPUtil.getParameter(request, prefix	+ "cur_queue", length));
			String[] duraFromDt = (JSPUtil.getParameter(request, prefix	+ "dura_from_dt", length));
			String[] prtCd = (JSPUtil.getParameter(request, prefix	+ "prt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueListInVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (pendingOnly[i] != null)
					model.setPendingOnly(pendingOnly[i]);
				if (svrCd[i] != null)
					model.setSvrCd(svrCd[i]);
				if (qa[i] != null)
					model.setQa(qa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (input[i] != null)
					model.setInput(input[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (queueStatus[i] != null)
					model.setQueueStatus(queueStatus[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (duraToDt[i] != null)
					model.setDuraToDt(duraToDt[i]);
				if (curQueue[i] != null)
					model.setCurQueue(curQueue[i]);
				if (duraFromDt[i] != null)
					model.setDuraFromDt(duraFromDt[i]);
				if (prtCd[i] != null)
					model.setPrtCd(prtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueListInVO[]
	 */
	public DocQueueListInVO[] getDocQueueListInVOs(){
		DocQueueListInVO[] vos = (DocQueueListInVO[])models.toArray(new DocQueueListInVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pendingOnly = this.pendingOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrCd = this.svrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qa = this.qa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.input = this.input .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueStatus = this.queueStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraToDt = this.duraToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curQueue = this.curQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraFromDt = this.duraFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtCd = this.prtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
