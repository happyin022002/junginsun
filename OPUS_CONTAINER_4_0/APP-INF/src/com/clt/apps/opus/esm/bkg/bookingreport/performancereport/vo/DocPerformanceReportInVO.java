/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocPerformanceReportInVO.java
*@FileTitle : DocPerformanceReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.03 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocPerformanceReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocPerformanceReportInVO> models = new ArrayList<DocPerformanceReportInVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String hh = null;
	/* Column Info */
	private String pipeHh = null;
	/* Column Info */
	private String pipeSs = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String dd = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String sss = null;
	/* Column Info */
	private String avgeSs = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String ss = null;
	/* Column Info */
	private String turnTimeCd = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String mi = null;
	/* Column Info */
	private String avgeMi = null;
	/* Column Info */
	private String turnTime = null;
	/* Column Info */
	private String docPartSw = null;
	/* Column Info */
	private String pipeMi = null;
	/* Column Info */
	private String avge = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String avgeDd = null;
	/* Column Info */
	private String avgeHh = null;
	/* Column Info */
	private String totalHh = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String totalMi = null;
	/* Column Info */
	private String totalDistinct = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String totalDd = null;
	/* Column Info */
	private String totalSs = null;
	/* Column Info */
	private String docPartJp = null;
	/* Column Info */
	private String docPart = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocPerformanceReportInVO() {}

	public DocPerformanceReportInVO(String ibflag, String pagerows, String total, String fromDt, String hh, String pipeHh, String pipeSs,  String dd, String polCd, String srKndCd, String avgeSs, String sss, String srAmdTpCd, String ss, String turnTimeCd, String totalCnt, String srNo, String mi, String avgeMi, String turnTime, String pipeMi, String avge, String srKind, String avgeHh, String totalHh, String avgeDd, String toDt, String podCd, String vvd, String ofcCd, String totalDistinct, String totalMi, String bkgNo, String totalDd, String totalSs, String docPart, String docPartEu, String docPartJp, String docPartSw) {
		this.total = total;
		this.fromDt = fromDt;
		this.hh = hh;
		this.pipeHh = pipeHh;
		this.pipeSs = pipeSs;
		this.pagerows = pagerows;
		this.dd = dd;
		this.srKndCd = srKndCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.sss = sss;
		this.avgeSs = avgeSs;
		this.srAmdTpCd = srAmdTpCd;
		this.ss = ss;
		this.turnTimeCd = turnTimeCd;
		this.totalCnt = totalCnt;
		this.docPartEu = docPartEu;
		this.srNo = srNo;
		this.mi = mi;
		this.avgeMi = avgeMi;
		this.turnTime = turnTime;
		this.docPartSw = docPartSw;
		this.pipeMi = pipeMi;
		this.avge = avge;
		this.srKind = srKind;
		this.avgeDd = avgeDd;
		this.avgeHh = avgeHh;
		this.totalHh = totalHh;
		this.vvd = vvd;
		this.podCd = podCd;
		this.toDt = toDt;
		this.totalMi = totalMi;
		this.totalDistinct = totalDistinct;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.totalDd = totalDd;
		this.totalSs = totalSs;
		this.docPartJp = docPartJp;
		this.docPart = docPart;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("hh", getHh());
		this.hashColumns.put("pipe_hh", getPipeHh());
		this.hashColumns.put("pipe_ss", getPipeSs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dd", getDd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sss", getSss());
		this.hashColumns.put("avge_ss", getAvgeSs());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("ss", getSs());
		this.hashColumns.put("turn_time_cd", getTurnTimeCd());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("mi", getMi());
		this.hashColumns.put("avge_mi", getAvgeMi());
		this.hashColumns.put("turn_time", getTurnTime());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		this.hashColumns.put("pipe_mi", getPipeMi());
		this.hashColumns.put("avge", getAvge());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("avge_dd", getAvgeDd());
		this.hashColumns.put("avge_hh", getAvgeHh());
		this.hashColumns.put("total_hh", getTotalHh());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("total_mi", getTotalMi());
		this.hashColumns.put("total_distinct", getTotalDistinct());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("total_dd", getTotalDd());
		this.hashColumns.put("total_ss", getTotalSs());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		this.hashColumns.put("doc_part", getDocPart());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("hh", "hh");
		this.hashFields.put("pipe_hh", "pipeHh");
		this.hashFields.put("pipe_ss", "pipeSs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dd", "dd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sss", "sss");
		this.hashFields.put("avge_ss", "avgeSs");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("ss", "ss");
		this.hashFields.put("turn_time_cd", "turnTimeCd");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("mi", "mi");
		this.hashFields.put("avge_mi", "avgeMi");
		this.hashFields.put("turn_time", "turnTime");
		this.hashFields.put("doc_part_sw", "docPartSw");
		this.hashFields.put("pipe_mi", "pipeMi");
		this.hashFields.put("avge", "avge");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("avge_dd", "avgeDd");
		this.hashFields.put("avge_hh", "avgeHh");
		this.hashFields.put("total_hh", "totalHh");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("total_mi", "totalMi");
		this.hashFields.put("total_distinct", "totalDistinct");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("total_dd", "totalDd");
		this.hashFields.put("total_ss", "totalSs");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part", "docPart");
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return hh
	 */
	public String getHh() {
		return this.hh;
	}
	
	/**
	 * Column Info
	 * @return pipeHh
	 */
	public String getPipeHh() {
		return this.pipeHh;
	}
	
	/**
	 * Column Info
	 * @return pipeSs
	 */
	public String getPipeSs() {
		return this.pipeSs;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return dd
	 */
	public String getDd() {
		return this.dd;
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
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sss
	 */
	public String getSss() {
		return this.sss;
	}
	
	/**
	 * Column Info
	 * @return avgeSs
	 */
	public String getAvgeSs() {
		return this.avgeSs;
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
	 * @return ss
	 */
	public String getSs() {
		return this.ss;
	}
	
	/**
	 * Column Info
	 * @return turnTimeCd
	 */
	public String getTurnTimeCd() {
		return this.turnTimeCd;
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
	 * @return docPartEu
	 */
	public String getDocPartEu() {
		return this.docPartEu;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return mi
	 */
	public String getMi() {
		return this.mi;
	}
	
	/**
	 * Column Info
	 * @return avgeMi
	 */
	public String getAvgeMi() {
		return this.avgeMi;
	}
	
	/**
	 * Column Info
	 * @return turnTime
	 */
	public String getTurnTime() {
		return this.turnTime;
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
	 * @return pipeMi
	 */
	public String getPipeMi() {
		return this.pipeMi;
	}
	
	/**
	 * Column Info
	 * @return avge
	 */
	public String getAvge() {
		return this.avge;
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
	 * @return avgeDd
	 */
	public String getAvgeDd() {
		return this.avgeDd;
	}
	
	/**
	 * Column Info
	 * @return avgeHh
	 */
	public String getAvgeHh() {
		return this.avgeHh;
	}
	
	/**
	 * Column Info
	 * @return totalHh
	 */
	public String getTotalHh() {
		return this.totalHh;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return totalMi
	 */
	public String getTotalMi() {
		return this.totalMi;
	}
	
	/**
	 * Column Info
	 * @return totalDistinct
	 */
	public String getTotalDistinct() {
		return this.totalDistinct;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return totalDd
	 */
	public String getTotalDd() {
		return this.totalDd;
	}
	
	/**
	 * Column Info
	 * @return totalSs
	 */
	public String getTotalSs() {
		return this.totalSs;
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
	 * @return docPart
	 */
	public String getDocPart() {
		return this.docPart;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param hh
	 */
	public void setHh(String hh) {
		this.hh = hh;
	}
	
	/**
	 * Column Info
	 * @param pipeHh
	 */
	public void setPipeHh(String pipeHh) {
		this.pipeHh = pipeHh;
	}
	
	/**
	 * Column Info
	 * @param pipeSs
	 */
	public void setPipeSs(String pipeSs) {
		this.pipeSs = pipeSs;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param dd
	 */
	public void setDd(String dd) {
		this.dd = dd;
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
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sss
	 */
	public void setSss(String sss) {
		this.sss = sss;
	}
	
	/**
	 * Column Info
	 * @param avgeSs
	 */
	public void setAvgeSs(String avgeSs) {
		this.avgeSs = avgeSs;
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
	 * @param ss
	 */
	public void setSs(String ss) {
		this.ss = ss;
	}
	
	/**
	 * Column Info
	 * @param turnTimeCd
	 */
	public void setTurnTimeCd(String turnTimeCd) {
		this.turnTimeCd = turnTimeCd;
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
	 * @param docPartEu
	 */
	public void setDocPartEu(String docPartEu) {
		this.docPartEu = docPartEu;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param mi
	 */
	public void setMi(String mi) {
		this.mi = mi;
	}
	
	/**
	 * Column Info
	 * @param avgeMi
	 */
	public void setAvgeMi(String avgeMi) {
		this.avgeMi = avgeMi;
	}
	
	/**
	 * Column Info
	 * @param turnTime
	 */
	public void setTurnTime(String turnTime) {
		this.turnTime = turnTime;
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
	 * @param pipeMi
	 */
	public void setPipeMi(String pipeMi) {
		this.pipeMi = pipeMi;
	}
	
	/**
	 * Column Info
	 * @param avge
	 */
	public void setAvge(String avge) {
		this.avge = avge;
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
	 * @param avgeDd
	 */
	public void setAvgeDd(String avgeDd) {
		this.avgeDd = avgeDd;
	}
	
	/**
	 * Column Info
	 * @param avgeHh
	 */
	public void setAvgeHh(String avgeHh) {
		this.avgeHh = avgeHh;
	}
	
	/**
	 * Column Info
	 * @param totalHh
	 */
	public void setTotalHh(String totalHh) {
		this.totalHh = totalHh;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param totalMi
	 */
	public void setTotalMi(String totalMi) {
		this.totalMi = totalMi;
	}
	
	/**
	 * Column Info
	 * @param totalDistinct
	 */
	public void setTotalDistinct(String totalDistinct) {
		this.totalDistinct = totalDistinct;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param totalDd
	 */
	public void setTotalDd(String totalDd) {
		this.totalDd = totalDd;
	}
	
	/**
	 * Column Info
	 * @param totalSs
	 */
	public void setTotalSs(String totalSs) {
		this.totalSs = totalSs;
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
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setHh(JSPUtil.getParameter(request, "hh", ""));
		setPipeHh(JSPUtil.getParameter(request, "pipe_hh", ""));
		setPipeSs(JSPUtil.getParameter(request, "pipe_ss", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDd(JSPUtil.getParameter(request, "dd", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSss(JSPUtil.getParameter(request, "sss", ""));
		setAvgeSs(JSPUtil.getParameter(request, "avge_ss", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, "sr_amd_tp_cd", ""));
		setSs(JSPUtil.getParameter(request, "ss", ""));
		setTurnTimeCd(JSPUtil.getParameter(request, "turn_time_cd", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
		setMi(JSPUtil.getParameter(request, "mi", ""));
		setAvgeMi(JSPUtil.getParameter(request, "avge_mi", ""));
		setTurnTime(JSPUtil.getParameter(request, "turn_time", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
		setPipeMi(JSPUtil.getParameter(request, "pipe_mi", ""));
		setAvge(JSPUtil.getParameter(request, "avge", ""));
		setSrKind(JSPUtil.getParameter(request, "sr_kind", ""));
		setAvgeDd(JSPUtil.getParameter(request, "avge_dd", ""));
		setAvgeHh(JSPUtil.getParameter(request, "avge_hh", ""));
		setTotalHh(JSPUtil.getParameter(request, "total_hh", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setTotalMi(JSPUtil.getParameter(request, "total_mi", ""));
		setTotalDistinct(JSPUtil.getParameter(request, "total_distinct", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTotalDd(JSPUtil.getParameter(request, "total_dd", ""));
		setTotalSs(JSPUtil.getParameter(request, "total_ss", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocPerformanceReportInVO[]
	 */
	public DocPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocPerformanceReportInVO[]
	 */
	public DocPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocPerformanceReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] hh = (JSPUtil.getParameter(request, prefix	+ "hh", length));
			String[] pipeHh = (JSPUtil.getParameter(request, prefix	+ "pipe_hh", length));
			String[] pipeSs = (JSPUtil.getParameter(request, prefix	+ "pipe_ss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dd = (JSPUtil.getParameter(request, prefix	+ "dd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sss = (JSPUtil.getParameter(request, prefix	+ "sss", length));
			String[] avgeSs = (JSPUtil.getParameter(request, prefix	+ "avge_ss", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] ss = (JSPUtil.getParameter(request, prefix	+ "ss", length));
			String[] turnTimeCd = (JSPUtil.getParameter(request, prefix	+ "turn_time_cd", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] mi = (JSPUtil.getParameter(request, prefix	+ "mi", length));
			String[] avgeMi = (JSPUtil.getParameter(request, prefix	+ "avge_mi", length));
			String[] turnTime = (JSPUtil.getParameter(request, prefix	+ "turn_time", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			String[] pipeMi = (JSPUtil.getParameter(request, prefix	+ "pipe_mi", length));
			String[] avge = (JSPUtil.getParameter(request, prefix	+ "avge", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] avgeDd = (JSPUtil.getParameter(request, prefix	+ "avge_dd", length));
			String[] avgeHh = (JSPUtil.getParameter(request, prefix	+ "avge_hh", length));
			String[] totalHh = (JSPUtil.getParameter(request, prefix	+ "total_hh", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] totalMi = (JSPUtil.getParameter(request, prefix	+ "total_mi", length));
			String[] totalDistinct = (JSPUtil.getParameter(request, prefix	+ "total_distinct", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] totalDd = (JSPUtil.getParameter(request, prefix	+ "total_dd", length));
			String[] totalSs = (JSPUtil.getParameter(request, prefix	+ "total_ss", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocPerformanceReportInVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (hh[i] != null)
					model.setHh(hh[i]);
				if (pipeHh[i] != null)
					model.setPipeHh(pipeHh[i]);
				if (pipeSs[i] != null)
					model.setPipeSs(pipeSs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dd[i] != null)
					model.setDd(dd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sss[i] != null)
					model.setSss(sss[i]);
				if (avgeSs[i] != null)
					model.setAvgeSs(avgeSs[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (ss[i] != null)
					model.setSs(ss[i]);
				if (turnTimeCd[i] != null)
					model.setTurnTimeCd(turnTimeCd[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (mi[i] != null)
					model.setMi(mi[i]);
				if (avgeMi[i] != null)
					model.setAvgeMi(avgeMi[i]);
				if (turnTime[i] != null)
					model.setTurnTime(turnTime[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				if (pipeMi[i] != null)
					model.setPipeMi(pipeMi[i]);
				if (avge[i] != null)
					model.setAvge(avge[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (avgeDd[i] != null)
					model.setAvgeDd(avgeDd[i]);
				if (avgeHh[i] != null)
					model.setAvgeHh(avgeHh[i]);
				if (totalHh[i] != null)
					model.setTotalHh(totalHh[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (totalMi[i] != null)
					model.setTotalMi(totalMi[i]);
				if (totalDistinct[i] != null)
					model.setTotalDistinct(totalDistinct[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (totalDd[i] != null)
					model.setTotalDd(totalDd[i]);
				if (totalSs[i] != null)
					model.setTotalSs(totalSs[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocPerformanceReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocPerformanceReportInVO[]
	 */
	public DocPerformanceReportInVO[] getDocPerformanceReportInVOs(){
		DocPerformanceReportInVO[] vos = (DocPerformanceReportInVO[])models.toArray(new DocPerformanceReportInVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hh = this.hh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pipeHh = this.pipeHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pipeSs = this.pipeSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dd = this.dd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sss = this.sss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgeSs = this.avgeSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ss = this.ss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnTimeCd = this.turnTimeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mi = this.mi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgeMi = this.avgeMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnTime = this.turnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pipeMi = this.pipeMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avge = this.avge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgeDd = this.avgeDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgeHh = this.avgeHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalHh = this.totalHh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalMi = this.totalMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalDistinct = this.totalDistinct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalDd = this.totalDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalSs = this.totalSs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
