/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocTurnTimeOutVO.java
*@FileTitle : DocTurnTimeOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.28 김경섭 
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

public class DocTurnTimeOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocTurnTimeOutVO> models = new ArrayList<DocTurnTimeOutVO>();
	
	/* Column Info */
	private String queue = null;
	/* Column Info */
	private String avgElapsedTimeSs = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String elapsedTimeMi = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String avgElapsedTimeMi = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String avgElapsedTimeHh = null;
	/* Column Info */
	private String grpQueCnt = null;
	/* Column Info */
	private String elapsedTime = null;
	/* Column Info */
	private String dpcsWrkGrpCd = null;
	/* Column Info */
	private String elapsedTimeHh = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String elapsedTimeSs = null;
	/* Column Info */
	private String mdst = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String grpTotalElapsedTime = null;
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
	
	public DocTurnTimeOutVO() {}

	public DocTurnTimeOutVO(String ibflag, String pagerows, String mdst, String queue, String pic, String bkgNo, String srKind, String dpcsWrkGrpCd, String srAmdTpCd, String avgElapsedTimeHh, String avgElapsedTimeMi, String avgElapsedTimeSs, String grpQueCnt, String grpTotalElapsedTime, String seqNo, String vvdCd, String polCd, String podCd, String elapsedTimeHh, String elapsedTimeMi, String elapsedTimeSs, String elapsedTime, String docPart, String docPartEu, String docPartJp, String docPartSw) {
		this.queue = queue;
		this.avgElapsedTimeSs = avgElapsedTimeSs;
		this.seqNo = seqNo;
		this.elapsedTimeMi = elapsedTimeMi;
		this.srKind = srKind;
		this.avgElapsedTimeMi = avgElapsedTimeMi;
		this.pic = pic;
		this.avgElapsedTimeHh = avgElapsedTimeHh;
		this.grpQueCnt = grpQueCnt;
		this.elapsedTime = elapsedTime;
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
		this.elapsedTimeHh = elapsedTimeHh;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.vvdCd = vvdCd;
		this.elapsedTimeSs = elapsedTimeSs;
		this.mdst = mdst;
		this.srAmdTpCd = srAmdTpCd;
		this.grpTotalElapsedTime = grpTotalElapsedTime;
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
		this.hashColumns.put("queue", getQueue());
		this.hashColumns.put("avg_elapsed_time_ss", getAvgElapsedTimeSs());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("elapsed_time_mi", getElapsedTimeMi());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("avg_elapsed_time_mi", getAvgElapsedTimeMi());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("avg_elapsed_time_hh", getAvgElapsedTimeHh());
		this.hashColumns.put("grp_que_cnt", getGrpQueCnt());
		this.hashColumns.put("elapsed_time", getElapsedTime());
		this.hashColumns.put("dpcs_wrk_grp_cd", getDpcsWrkGrpCd());
		this.hashColumns.put("elapsed_time_hh", getElapsedTimeHh());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("elapsed_time_ss", getElapsedTimeSs());
		this.hashColumns.put("mdst", getMdst());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("grp_total_elapsed_time", getGrpTotalElapsedTime());
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
		this.hashFields.put("queue", "queue");
		this.hashFields.put("avg_elapsed_time_ss", "avgElapsedTimeSs");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("elapsed_time_mi", "elapsedTimeMi");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("avg_elapsed_time_mi", "avgElapsedTimeMi");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("avg_elapsed_time_hh", "avgElapsedTimeHh");
		this.hashFields.put("grp_que_cnt", "grpQueCnt");
		this.hashFields.put("elapsed_time", "elapsedTime");
		this.hashFields.put("dpcs_wrk_grp_cd", "dpcsWrkGrpCd");
		this.hashFields.put("elapsed_time_hh", "elapsedTimeHh");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("elapsed_time_ss", "elapsedTimeSs");
		this.hashFields.put("mdst", "mdst");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("grp_total_elapsed_time", "grpTotalElapsedTime");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part_sw", "docPartSw");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return queue
	 */
	public String getQueue() {
		return this.queue;
	}
	
	/**
	 * Column Info
	 * @return avgElapsedTimeSs
	 */
	public String getAvgElapsedTimeSs() {
		return this.avgElapsedTimeSs;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return elapsedTimeMi
	 */
	public String getElapsedTimeMi() {
		return this.elapsedTimeMi;
	}
	
	/**
	 * Column Info
	 * @return srKind
	 */
	public String getSrKind() {
		return this.srKind;
	}
	
	/**
	 * Column Info
	 * @return avgElapsedTimeMi
	 */
	public String getAvgElapsedTimeMi() {
		return this.avgElapsedTimeMi;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return avgElapsedTimeHh
	 */
	public String getAvgElapsedTimeHh() {
		return this.avgElapsedTimeHh;
	}
	
	/**
	 * Column Info
	 * @return grpQueCnt
	 */
	public String getGrpQueCnt() {
		return this.grpQueCnt;
	}
	
	/**
	 * Column Info
	 * @return elapsedTime
	 */
	public String getElapsedTime() {
		return this.elapsedTime;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return this.dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @return elapsedTimeHh
	 */
	public String getElapsedTimeHh() {
		return this.elapsedTimeHh;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return elapsedTimeSs
	 */
	public String getElapsedTimeSs() {
		return this.elapsedTimeSs;
	}
	
	/**
	 * Column Info
	 * @return mdst
	 */
	public String getMdst() {
		return this.mdst;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return grpTotalElapsedTime
	 */
	public String getGrpTotalElapsedTime() {
		return this.grpTotalElapsedTime;
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
	 * @param queue
	 */
	public void setQueue(String queue) {
		this.queue = queue;
	}
	
	/**
	 * Column Info
	 * @param avgElapsedTimeSs
	 */
	public void setAvgElapsedTimeSs(String avgElapsedTimeSs) {
		this.avgElapsedTimeSs = avgElapsedTimeSs;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param elapsedTimeMi
	 */
	public void setElapsedTimeMi(String elapsedTimeMi) {
		this.elapsedTimeMi = elapsedTimeMi;
	}
	
	/**
	 * Column Info
	 * @param srKind
	 */
	public void setSrKind(String srKind) {
		this.srKind = srKind;
	}
	
	/**
	 * Column Info
	 * @param avgElapsedTimeMi
	 */
	public void setAvgElapsedTimeMi(String avgElapsedTimeMi) {
		this.avgElapsedTimeMi = avgElapsedTimeMi;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param avgElapsedTimeHh
	 */
	public void setAvgElapsedTimeHh(String avgElapsedTimeHh) {
		this.avgElapsedTimeHh = avgElapsedTimeHh;
	}
	
	/**
	 * Column Info
	 * @param grpQueCnt
	 */
	public void setGrpQueCnt(String grpQueCnt) {
		this.grpQueCnt = grpQueCnt;
	}
	
	/**
	 * Column Info
	 * @param elapsedTime
	 */
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkGrpCd
	 */
	public void setDpcsWrkGrpCd(String dpcsWrkGrpCd) {
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @param elapsedTimeHh
	 */
	public void setElapsedTimeHh(String elapsedTimeHh) {
		this.elapsedTimeHh = elapsedTimeHh;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param elapsedTimeSs
	 */
	public void setElapsedTimeSs(String elapsedTimeSs) {
		this.elapsedTimeSs = elapsedTimeSs;
	}
	
	/**
	 * Column Info
	 * @param mdst
	 */
	public void setMdst(String mdst) {
		this.mdst = mdst;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param grpTotalElapsedTime
	 */
	public void setGrpTotalElapsedTime(String grpTotalElapsedTime) {
		this.grpTotalElapsedTime = grpTotalElapsedTime;
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
	 * Column Info
	 * @param docPart
	 */
	public void setDocPart(String docPart) {
		this.docPart = docPart;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setQueue(JSPUtil.getParameter(request, "queue", ""));
		setAvgElapsedTimeSs(JSPUtil.getParameter(request, "avg_elapsed_time_ss", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setElapsedTimeMi(JSPUtil.getParameter(request, "elapsed_time_mi", ""));
		setSrKind(JSPUtil.getParameter(request, "sr_kind", ""));
		setAvgElapsedTimeMi(JSPUtil.getParameter(request, "avg_elapsed_time_mi", ""));
		setPic(JSPUtil.getParameter(request, "pic", ""));
		setAvgElapsedTimeHh(JSPUtil.getParameter(request, "avg_elapsed_time_hh", ""));
		setGrpQueCnt(JSPUtil.getParameter(request, "grp_que_cnt", ""));
		setElapsedTime(JSPUtil.getParameter(request, "elapsed_time", ""));
		setDpcsWrkGrpCd(JSPUtil.getParameter(request, "dpcs_wrk_grp_cd", ""));
		setElapsedTimeHh(JSPUtil.getParameter(request, "elapsed_time_hh", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setElapsedTimeSs(JSPUtil.getParameter(request, "elapsed_time_ss", ""));
		setMdst(JSPUtil.getParameter(request, "mdst", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, "sr_amd_tp_cd", ""));
		setGrpTotalElapsedTime(JSPUtil.getParameter(request, "grp_total_elapsed_time", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocTurnTimeOutVO[]
	 */
	public DocTurnTimeOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocTurnTimeOutVO[]
	 */
	public DocTurnTimeOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocTurnTimeOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] queue = (JSPUtil.getParameter(request, prefix	+ "queue", length));
			String[] avgElapsedTimeSs = (JSPUtil.getParameter(request, prefix	+ "avg_elapsed_time_ss", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] elapsedTimeMi = (JSPUtil.getParameter(request, prefix	+ "elapsed_time_mi", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] avgElapsedTimeMi = (JSPUtil.getParameter(request, prefix	+ "avg_elapsed_time_mi", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] avgElapsedTimeHh = (JSPUtil.getParameter(request, prefix	+ "avg_elapsed_time_hh", length));
			String[] grpQueCnt = (JSPUtil.getParameter(request, prefix	+ "grp_que_cnt", length));
			String[] elapsedTime = (JSPUtil.getParameter(request, prefix	+ "elapsed_time", length));
			String[] dpcsWrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd", length));
			String[] elapsedTimeHh = (JSPUtil.getParameter(request, prefix	+ "elapsed_time_hh", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] elapsedTimeSs = (JSPUtil.getParameter(request, prefix	+ "elapsed_time_ss", length));
			String[] mdst = (JSPUtil.getParameter(request, prefix	+ "mdst", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] grpTotalElapsedTime = (JSPUtil.getParameter(request, prefix	+ "grp_total_elapsed_time", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocTurnTimeOutVO();
				if (queue[i] != null)
					model.setQueue(queue[i]);
				if (avgElapsedTimeSs[i] != null)
					model.setAvgElapsedTimeSs(avgElapsedTimeSs[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (elapsedTimeMi[i] != null)
					model.setElapsedTimeMi(elapsedTimeMi[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (avgElapsedTimeMi[i] != null)
					model.setAvgElapsedTimeMi(avgElapsedTimeMi[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (avgElapsedTimeHh[i] != null)
					model.setAvgElapsedTimeHh(avgElapsedTimeHh[i]);
				if (grpQueCnt[i] != null)
					model.setGrpQueCnt(grpQueCnt[i]);
				if (elapsedTime[i] != null)
					model.setElapsedTime(elapsedTime[i]);
				if (dpcsWrkGrpCd[i] != null)
					model.setDpcsWrkGrpCd(dpcsWrkGrpCd[i]);
				if (elapsedTimeHh[i] != null)
					model.setElapsedTimeHh(elapsedTimeHh[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (elapsedTimeSs[i] != null)
					model.setElapsedTimeSs(elapsedTimeSs[i]);
				if (mdst[i] != null)
					model.setMdst(mdst[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (grpTotalElapsedTime[i] != null)
					model.setGrpTotalElapsedTime(grpTotalElapsedTime[i]);
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
		return getDocTurnTimeOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocTurnTimeOutVO[]
	 */
	public DocTurnTimeOutVO[] getDocTurnTimeOutVOs(){
		DocTurnTimeOutVO[] vos = (DocTurnTimeOutVO[])models.toArray(new DocTurnTimeOutVO[models.size()]);
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
		this.queue = this.queue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgElapsedTimeSs = this.avgElapsedTimeSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapsedTimeMi = this.elapsedTimeMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgElapsedTimeMi = this.avgElapsedTimeMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgElapsedTimeHh = this.avgElapsedTimeHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpQueCnt = this.grpQueCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapsedTime = this.elapsedTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpCd = this.dpcsWrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapsedTimeHh = this.elapsedTimeHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elapsedTimeSs = this.elapsedTimeSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdst = this.mdst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpTotalElapsedTime = this.grpTotalElapsedTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
