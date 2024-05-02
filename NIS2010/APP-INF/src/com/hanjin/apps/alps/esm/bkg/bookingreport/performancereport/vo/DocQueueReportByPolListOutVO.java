/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocQueueReportByPolListOutVO.java
*@FileTitle : DocQueueReportByPolListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.21 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueReportByPolListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueReportByPolListOutVO> models = new ArrayList<DocQueueReportByPolListOutVO>();
	
	/* Column Info */
	private String inputting = null;
	/* Column Info */
	private String bstMatchedQ = null;
	/* Column Info */
	private String bstUnmatchedQ = null;
	/* Column Info */
	private String inputted = null;
	/* Column Info */
	private String queueTotal = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inputterQueue = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srTransferred = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String stoppedQueue = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String consigneeNm = null;
	/* Column Info */
	private String lastUpdDt = null;
	/* Column Info */
	private String raterQueue = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String sr = null;
	/* Column Info */
	private String srY = null;
	/* Column Info */
	private String fofcReturned = null;
	/* Column Info */
	private String auditorQueue = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String srN = null;
	/* Column Info */
	private String audited = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String shipperCode = null;
	/* Column Info */
	private String ttlBkg = null;
	/* Column Info */
	private String rating = null;
	/* Column Info */
	private String auditing = null;
	/* Column Info */
	private String rated = null;
	/* Column Info */
	private String docPart = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String docPartJp = null;
	/* Column Info */
	private String docPartSw = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueReportByPolListOutVO() {}

	public DocQueueReportByPolListOutVO(String ibflag, String pagerows, String seq, String bkgNo, String sr, String vvdCd, String polCd, String podCd, String srKndCd, String status, String lastUpdDt, String shipperCode, String shipperNm, String consigneeNm, String ttlBkg, String inputterQueue, String srTransferred, String inputting, String srY, String raterQueue, String inputted, String rating, String srN, String auditorQueue, String rated, String auditing, String audited, String stoppedQueue, String fofcReturned, String queueTotal, String bstMatchedQ, String bstUnmatchedQ, String totalCnt, String docPart, String docPartEu, String docPartJp, String docPartSw) {
		this.inputting = inputting;
		this.bstMatchedQ = bstMatchedQ;
		this.bstUnmatchedQ = bstUnmatchedQ;
		this.inputted = inputted;
		this.queueTotal = queueTotal;
		this.pagerows = pagerows;
		this.inputterQueue = inputterQueue;
		this.srKndCd = srKndCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.srTransferred = srTransferred;
		this.shipperNm = shipperNm;
		this.vvdCd = vvdCd;
		this.stoppedQueue = stoppedQueue;
		this.totalCnt = totalCnt;
		this.consigneeNm = consigneeNm;
		this.lastUpdDt = lastUpdDt;
		this.raterQueue = raterQueue;
		this.status = status;
		this.sr = sr;
		this.srY = srY;
		this.fofcReturned = fofcReturned;
		this.auditorQueue = auditorQueue;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.srN = srN;
		this.audited = audited;
		this.seq = seq;
		this.shipperCode = shipperCode;
		this.ttlBkg = ttlBkg;
		this.rating = rating;
		this.auditing = auditing;
		this.rated = rated;
		this.docPart = docPart;
		this.docPartEu = docPartEu;
		this.docPartJp = docPartJp;
		this.docPartSw = docPartSw;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inputting", getInputting());
		this.hashColumns.put("bst_matched_q", getBstMatchedQ());
		this.hashColumns.put("bst_unmatched_q", getBstUnmatchedQ());
		this.hashColumns.put("inputted", getInputted());
		this.hashColumns.put("queue_total", getQueueTotal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inputter_queue", getInputterQueue());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_transferred", getSrTransferred());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("stopped_queue", getStoppedQueue());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("consignee_nm", getConsigneeNm());
		this.hashColumns.put("last_upd_dt", getLastUpdDt());
		this.hashColumns.put("rater_queue", getRaterQueue());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("sr", getSr());
		this.hashColumns.put("sr_y", getSrY());
		this.hashColumns.put("fofc_returned", getFofcReturned());
		this.hashColumns.put("auditor_queue", getAuditorQueue());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sr_n", getSrN());
		this.hashColumns.put("audited", getAudited());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("shipper_code", getShipperCode());
		this.hashColumns.put("ttl_bkg", getTtlBkg());
		this.hashColumns.put("rating", getRating());
		this.hashColumns.put("auditing", getAuditing());
		this.hashColumns.put("rated", getRated());
		this.hashColumns.put("doc_part", getDocPart());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inputting", "inputting");
		this.hashFields.put("bst_matched_q", "bstMatchedQ");
		this.hashFields.put("bst_unmatched_q", "bstUnmatchedQ");
		this.hashFields.put("inputted", "inputted");
		this.hashFields.put("queue_total", "queueTotal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inputter_queue", "inputterQueue");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_transferred", "srTransferred");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("stopped_queue", "stoppedQueue");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("consignee_nm", "consigneeNm");
		this.hashFields.put("last_upd_dt", "lastUpdDt");
		this.hashFields.put("rater_queue", "raterQueue");
		this.hashFields.put("status", "status");
		this.hashFields.put("sr", "sr");
		this.hashFields.put("sr_y", "srY");
		this.hashFields.put("fofc_returned", "fofcReturned");
		this.hashFields.put("auditor_queue", "auditorQueue");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sr_n", "srN");
		this.hashFields.put("audited", "audited");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("shipper_code", "shipperCode");
		this.hashFields.put("ttl_bkg", "ttlBkg");
		this.hashFields.put("rating", "rating");
		this.hashFields.put("auditing", "auditing");
		this.hashFields.put("rated", "rated");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part_sw", "docPartSw");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inputting
	 */
	public String getInputting() {
		return this.inputting;
	}
	
	/**
	 * Column Info
	 * @return bstMatchedQ
	 */
	public String getBstMatchedQ() {
		return this.bstMatchedQ;
	}
	
	/**
	 * Column Info
	 * @return bstUnmatchedQ
	 */
	public String getBstUnmatchedQ() {
		return this.bstUnmatchedQ;
	}
	
	/**
	 * Column Info
	 * @return inputted
	 */
	public String getInputted() {
		return this.inputted;
	}
	
	/**
	 * Column Info
	 * @return queueTotal
	 */
	public String getQueueTotal() {
		return this.queueTotal;
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
	 * @return inputterQueue
	 */
	public String getInputterQueue() {
		return this.inputterQueue;
	}
	
	/**
	 * Column Info
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return srTransferred
	 */
	public String getSrTransferred() {
		return this.srTransferred;
	}
	
	/**
	 * Column Info
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
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
	 * @return stoppedQueue
	 */
	public String getStoppedQueue() {
		return this.stoppedQueue;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return consigneeNm
	 */
	public String getConsigneeNm() {
		return this.consigneeNm;
	}
	
	/**
	 * Column Info
	 * @return lastUpdDt
	 */
	public String getLastUpdDt() {
		return this.lastUpdDt;
	}
	
	/**
	 * Column Info
	 * @return raterQueue
	 */
	public String getRaterQueue() {
		return this.raterQueue;
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
	 * @return sr
	 */
	public String getSr() {
		return this.sr;
	}
	
	/**
	 * Column Info
	 * @return srY
	 */
	public String getSrY() {
		return this.srY;
	}
	
	/**
	 * Column Info
	 * @return fofcReturned
	 */
	public String getFofcReturned() {
		return this.fofcReturned;
	}
	
	/**
	 * Column Info
	 * @return auditorQueue
	 */
	public String getAuditorQueue() {
		return this.auditorQueue;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return srN
	 */
	public String getSrN() {
		return this.srN;
	}
	
	/**
	 * Column Info
	 * @return audited
	 */
	public String getAudited() {
		return this.audited;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return shipperCode
	 */
	public String getShipperCode() {
		return this.shipperCode;
	}
	
	/**
	 * Column Info
	 * @return ttlBkg
	 */
	public String getTtlBkg() {
		return this.ttlBkg;
	}
	
	/**
	 * Column Info
	 * @return rating
	 */
	public String getRating() {
		return this.rating;
	}
	
	/**
	 * Column Info
	 * @return auditing
	 */
	public String getAuditing() {
		return this.auditing;
	}
	
	/**
	 * Column Info
	 * @return rated
	 */
	public String getRated() {
		return this.rated;
	}
	/**
	 * Column Info
	 * @return docPart
	 */
	public String getDocPart() {
		return this.docPart;
	}
	
	/**
	 * Column Info
	 * @return docPartEu
	 */
	public String getDocPartEu() {
		return this.docPartEu;
	}
	
	/**
	 * Column Info
	 * @return docPartJp
	 */
	public String getDocPartJp() {
		return this.docPartJp;
	}
	
	/**
	 * Column Info
	 * @return docPartSw
	 */
	public String getDocPartSw() {
		return this.docPartSw;
	}
	

	/**
	 * Column Info
	 * @param inputting
	 */
	public void setInputting(String inputting) {
		this.inputting = inputting;
	}
	
	/**
	 * Column Info
	 * @param bstMatchedQ
	 */
	public void setBstMatchedQ(String bstMatchedQ) {
		this.bstMatchedQ = bstMatchedQ;
	}
	
	/**
	 * Column Info
	 * @param bstUnmatchedQ
	 */
	public void setBstUnmatchedQ(String bstUnmatchedQ) {
		this.bstUnmatchedQ = bstUnmatchedQ;
	}
	
	/**
	 * Column Info
	 * @param inputted
	 */
	public void setInputted(String inputted) {
		this.inputted = inputted;
	}
	
	/**
	 * Column Info
	 * @param queueTotal
	 */
	public void setQueueTotal(String queueTotal) {
		this.queueTotal = queueTotal;
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
	 * @param inputterQueue
	 */
	public void setInputterQueue(String inputterQueue) {
		this.inputterQueue = inputterQueue;
	}
	
	/**
	 * Column Info
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param srTransferred
	 */
	public void setSrTransferred(String srTransferred) {
		this.srTransferred = srTransferred;
	}
	
	/**
	 * Column Info
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
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
	 * @param stoppedQueue
	 */
	public void setStoppedQueue(String stoppedQueue) {
		this.stoppedQueue = stoppedQueue;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param consigneeNm
	 */
	public void setConsigneeNm(String consigneeNm) {
		this.consigneeNm = consigneeNm;
	}
	
	/**
	 * Column Info
	 * @param lastUpdDt
	 */
	public void setLastUpdDt(String lastUpdDt) {
		this.lastUpdDt = lastUpdDt;
	}
	
	/**
	 * Column Info
	 * @param raterQueue
	 */
	public void setRaterQueue(String raterQueue) {
		this.raterQueue = raterQueue;
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
	 * @param sr
	 */
	public void setSr(String sr) {
		this.sr = sr;
	}
	
	/**
	 * Column Info
	 * @param srY
	 */
	public void setSrY(String srY) {
		this.srY = srY;
	}
	
	/**
	 * Column Info
	 * @param fofcReturned
	 */
	public void setFofcReturned(String fofcReturned) {
		this.fofcReturned = fofcReturned;
	}
	
	/**
	 * Column Info
	 * @param auditorQueue
	 */
	public void setAuditorQueue(String auditorQueue) {
		this.auditorQueue = auditorQueue;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param srN
	 */
	public void setSrN(String srN) {
		this.srN = srN;
	}
	
	/**
	 * Column Info
	 * @param audited
	 */
	public void setAudited(String audited) {
		this.audited = audited;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param shipperCode
	 */
	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}
	
	/**
	 * Column Info
	 * @param ttlBkg
	 */
	public void setTtlBkg(String ttlBkg) {
		this.ttlBkg = ttlBkg;
	}
	
	/**
	 * Column Info
	 * @param rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/**
	 * Column Info
	 * @param auditing
	 */
	public void setAuditing(String auditing) {
		this.auditing = auditing;
	}
	
	/**
	 * Column Info
	 * @param rated
	 */
	public void setRated(String rated) {
		this.rated = rated;
	}
	
	/**
	 * Column Info
	 * @param docPart
	 */
	public void setDocPart(String docPart) {
		this.docPart = docPart;
	}
	
	/**
	 * Column Info
	 * @param docPartEu
	 */
	public void setDocPartEu(String docPartEu) {
		this.docPartEu = docPartEu;
	}
	
	/**
	 * Column Info
	 * @param docPartJp
	 */
	public void setDocPartJp(String docPartJp) {
		this.docPartJp = docPartJp;
	}
	
	/**
	 * Column Info
	 * @param docPartSw
	 */
	public void setDocPartSw(String docPartSw) {
		this.docPartSw = docPartSw;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInputting(JSPUtil.getParameter(request, "inputting", ""));
		setBstMatchedQ(JSPUtil.getParameter(request, "bst_matched_q", ""));
		setBstUnmatchedQ(JSPUtil.getParameter(request, "bst_unmatched_q", ""));
		setInputted(JSPUtil.getParameter(request, "inputted", ""));
		setQueueTotal(JSPUtil.getParameter(request, "queue_total", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInputterQueue(JSPUtil.getParameter(request, "inputter_queue", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSrTransferred(JSPUtil.getParameter(request, "sr_transferred", ""));
		setShipperNm(JSPUtil.getParameter(request, "shipper_nm", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setStoppedQueue(JSPUtil.getParameter(request, "stopped_queue", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setConsigneeNm(JSPUtil.getParameter(request, "consignee_nm", ""));
		setLastUpdDt(JSPUtil.getParameter(request, "last_upd_dt", ""));
		setRaterQueue(JSPUtil.getParameter(request, "rater_queue", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setSr(JSPUtil.getParameter(request, "sr", ""));
		setSrY(JSPUtil.getParameter(request, "sr_y", ""));
		setFofcReturned(JSPUtil.getParameter(request, "fofc_returned", ""));
		setAuditorQueue(JSPUtil.getParameter(request, "auditor_queue", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSrN(JSPUtil.getParameter(request, "sr_n", ""));
		setAudited(JSPUtil.getParameter(request, "audited", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setShipperCode(JSPUtil.getParameter(request, "shipper_code", ""));
		setTtlBkg(JSPUtil.getParameter(request, "ttl_bkg", ""));
		setRating(JSPUtil.getParameter(request, "rating", ""));
		setAuditing(JSPUtil.getParameter(request, "auditing", ""));
		setRated(JSPUtil.getParameter(request, "rated", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueReportByPolListOutVO[]
	 */
	public DocQueueReportByPolListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueReportByPolListOutVO[]
	 */
	public DocQueueReportByPolListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueReportByPolListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inputting = (JSPUtil.getParameter(request, prefix	+ "inputting", length));
			String[] bstMatchedQ = (JSPUtil.getParameter(request, prefix	+ "bst_matched_q", length));
			String[] bstUnmatchedQ = (JSPUtil.getParameter(request, prefix	+ "bst_unmatched_q", length));
			String[] inputted = (JSPUtil.getParameter(request, prefix	+ "inputted", length));
			String[] queueTotal = (JSPUtil.getParameter(request, prefix	+ "queue_total", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inputterQueue = (JSPUtil.getParameter(request, prefix	+ "inputter_queue", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srTransferred = (JSPUtil.getParameter(request, prefix	+ "sr_transferred", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] stoppedQueue = (JSPUtil.getParameter(request, prefix	+ "stopped_queue", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] consigneeNm = (JSPUtil.getParameter(request, prefix	+ "consignee_nm", length));
			String[] lastUpdDt = (JSPUtil.getParameter(request, prefix	+ "last_upd_dt", length));
			String[] raterQueue = (JSPUtil.getParameter(request, prefix	+ "rater_queue", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] sr = (JSPUtil.getParameter(request, prefix	+ "sr", length));
			String[] srY = (JSPUtil.getParameter(request, prefix	+ "sr_y", length));
			String[] fofcReturned = (JSPUtil.getParameter(request, prefix	+ "fofc_returned", length));
			String[] auditorQueue = (JSPUtil.getParameter(request, prefix	+ "auditor_queue", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] srN = (JSPUtil.getParameter(request, prefix	+ "sr_n", length));
			String[] audited = (JSPUtil.getParameter(request, prefix	+ "audited", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] shipperCode = (JSPUtil.getParameter(request, prefix	+ "shipper_code", length));
			String[] ttlBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg", length));
			String[] rating = (JSPUtil.getParameter(request, prefix	+ "rating", length));
			String[] auditing = (JSPUtil.getParameter(request, prefix	+ "auditing", length));
			String[] rated = (JSPUtil.getParameter(request, prefix	+ "rated", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueReportByPolListOutVO();
				if (inputting[i] != null)
					model.setInputting(inputting[i]);
				if (bstMatchedQ[i] != null)
					model.setBstMatchedQ(bstMatchedQ[i]);
				if (bstUnmatchedQ[i] != null)
					model.setBstUnmatchedQ(bstUnmatchedQ[i]);
				if (inputted[i] != null)
					model.setInputted(inputted[i]);
				if (queueTotal[i] != null)
					model.setQueueTotal(queueTotal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inputterQueue[i] != null)
					model.setInputterQueue(inputterQueue[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srTransferred[i] != null)
					model.setSrTransferred(srTransferred[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (stoppedQueue[i] != null)
					model.setStoppedQueue(stoppedQueue[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (consigneeNm[i] != null)
					model.setConsigneeNm(consigneeNm[i]);
				if (lastUpdDt[i] != null)
					model.setLastUpdDt(lastUpdDt[i]);
				if (raterQueue[i] != null)
					model.setRaterQueue(raterQueue[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (sr[i] != null)
					model.setSr(sr[i]);
				if (srY[i] != null)
					model.setSrY(srY[i]);
				if (fofcReturned[i] != null)
					model.setFofcReturned(fofcReturned[i]);
				if (auditorQueue[i] != null)
					model.setAuditorQueue(auditorQueue[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (srN[i] != null)
					model.setSrN(srN[i]);
				if (audited[i] != null)
					model.setAudited(audited[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (shipperCode[i] != null)
					model.setShipperCode(shipperCode[i]);
				if (ttlBkg[i] != null)
					model.setTtlBkg(ttlBkg[i]);
				if (rating[i] != null)
					model.setRating(rating[i]);
				if (auditing[i] != null)
					model.setAuditing(auditing[i]);
				if (rated[i] != null)
					model.setRated(rated[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueReportByPolListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueReportByPolListOutVO[]
	 */
	public DocQueueReportByPolListOutVO[] getDocQueueReportByPolListOutVOs(){
		DocQueueReportByPolListOutVO[] vos = (DocQueueReportByPolListOutVO[])models.toArray(new DocQueueReportByPolListOutVO[models.size()]);
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
		this.inputting = this.inputting .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bstMatchedQ = this.bstMatchedQ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bstUnmatchedQ = this.bstUnmatchedQ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputted = this.inputted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queueTotal = this.queueTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputterQueue = this.inputterQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srTransferred = this.srTransferred .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoppedQueue = this.stoppedQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeNm = this.consigneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdDt = this.lastUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raterQueue = this.raterQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sr = this.sr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srY = this.srY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fofcReturned = this.fofcReturned .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auditorQueue = this.auditorQueue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srN = this.srN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audited = this.audited .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCode = this.shipperCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkg = this.ttlBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rating = this.rating .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auditing = this.auditing .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rated = this.rated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
