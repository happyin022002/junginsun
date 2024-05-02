/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ErpMsgFns017VO.java
*@FileTitle : ErpMsgFns017VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.10.07 서창열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ErpMsgFns017VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErpMsgFns017VO> models = new ArrayList<ErpMsgFns017VO>();
	
	/* Column Info */
	private String position = null;
	/* Column Info */
	private String loadQnt = null;
	/* Column Info */
	private String skdSkdStat = null;
	/* Column Info */
	private String delMk = null;
	/* Column Info */
	private String voyTp = null;
	/* Column Info */
	private String lineCnt = null;
	/* Column Info */
	private String vesselCheck = null;
	/* Column Info */
	private String newSailDt = null;
	/* Column Info */
	private String estArrDt = null;
	/* Column Info */
	private String actArrDt = null;
	/* Column Info */
	private String vpsSkdStat = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estSailDt = null;
	/* Column Info */
	private String actSailDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vsl = null;
	/* Column Info */
	private String logUpdt = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String logRgst = null;
	/* Column Info */
	private String turnInd = null;
	/* Column Info */
	private String survey = null;
	/* Column Info */
	private String newArrDt = null;
	/* Column Info */
	private String dep = null;
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String dtlVsl = null;
	/* Column Info */
	private String dtlVoyNo = null;
	/* Column Info */
	private String logUserid = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String dtlDep = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String pt = null;
	/* Column Info */
	private String dRemark = null;
	/* Column Info */
	private String hRemark = null;
	/* Column Info */
	private String changeInd = null;
	/* Column Info */
	private String rowNum = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErpMsgFns017VO() {}

	public ErpMsgFns017VO(String ibflag, String pagerows, String lifid, String seq, String totalCount, String rowNum, String vsl, String voyNo, String dep, String voyTp, String lane, String loadQnt, String survey, String vesselCheck, String lineCnt, String dtlVsl, String dtlVoyNo, String dtlDep, String portSeq, String pt, String estArrDt, String estSailDt, String actArrDt, String actSailDt, String position, String logRgst, String logUpdt, String logUserid, String changeInd, String delMk, String turnInd, String hRemark, String dRemark, String newSailDt, String newArrDt, String skdSkdStat, String vpsSkdStat) {
		this.position = position;
		this.loadQnt = loadQnt;
		this.skdSkdStat = skdSkdStat;
		this.delMk = delMk;
		this.voyTp = voyTp;
		this.lineCnt = lineCnt;
		this.vesselCheck = vesselCheck;
		this.newSailDt = newSailDt;
		this.estArrDt = estArrDt;
		this.actArrDt = actArrDt;
		this.vpsSkdStat = vpsSkdStat;
		this.lane = lane;
		this.pagerows = pagerows;
		this.estSailDt = estSailDt;
		this.actSailDt = actSailDt;
		this.ibflag = ibflag;
		this.vsl = vsl;
		this.logUpdt = logUpdt;
		this.totalCount = totalCount;
		this.logRgst = logRgst;
		this.turnInd = turnInd;
		this.survey = survey;
		this.newArrDt = newArrDt;
		this.dep = dep;
		this.lifid = lifid;
		this.voyNo = voyNo;
		this.dtlVsl = dtlVsl;
		this.dtlVoyNo = dtlVoyNo;
		this.logUserid = logUserid;
		this.portSeq = portSeq;
		this.dtlDep = dtlDep;
		this.seq = seq;
		this.pt = pt;
		this.dRemark = dRemark;
		this.hRemark = hRemark;
		this.changeInd = changeInd;
		this.rowNum = rowNum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("position", getPosition());
		this.hashColumns.put("load_qnt", getLoadQnt());
		this.hashColumns.put("skd_skd_stat", getSkdSkdStat());
		this.hashColumns.put("del_mk", getDelMk());
		this.hashColumns.put("voy_tp", getVoyTp());
		this.hashColumns.put("line_cnt", getLineCnt());
		this.hashColumns.put("vessel_check", getVesselCheck());
		this.hashColumns.put("new_sail_dt", getNewSailDt());
		this.hashColumns.put("est_arr_dt", getEstArrDt());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("vps_skd_stat", getVpsSkdStat());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("est_sail_dt", getEstSailDt());
		this.hashColumns.put("act_sail_dt", getActSailDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl", getVsl());
		this.hashColumns.put("log_updt", getLogUpdt());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("log_rgst", getLogRgst());
		this.hashColumns.put("turn_ind", getTurnInd());
		this.hashColumns.put("survey", getSurvey());
		this.hashColumns.put("new_arr_dt", getNewArrDt());
		this.hashColumns.put("dep", getDep());
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("dtl_vsl", getDtlVsl());
		this.hashColumns.put("dtl_voy_no", getDtlVoyNo());
		this.hashColumns.put("log_userid", getLogUserid());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("dtl_dep", getDtlDep());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("pt", getPt());
		this.hashColumns.put("d_remark", getDRemark());
		this.hashColumns.put("h_remark", getHRemark());
		this.hashColumns.put("change_ind", getChangeInd());
		this.hashColumns.put("row_num", getRowNum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("position", "position");
		this.hashFields.put("load_qnt", "loadQnt");
		this.hashFields.put("skd_skd_stat", "skdSkdStat");
		this.hashFields.put("del_mk", "delMk");
		this.hashFields.put("voy_tp", "voyTp");
		this.hashFields.put("line_cnt", "lineCnt");
		this.hashFields.put("vessel_check", "vesselCheck");
		this.hashFields.put("new_sail_dt", "newSailDt");
		this.hashFields.put("est_arr_dt", "estArrDt");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("vps_skd_stat", "vpsSkdStat");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("est_sail_dt", "estSailDt");
		this.hashFields.put("act_sail_dt", "actSailDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("log_updt", "logUpdt");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("log_rgst", "logRgst");
		this.hashFields.put("turn_ind", "turnInd");
		this.hashFields.put("survey", "survey");
		this.hashFields.put("new_arr_dt", "newArrDt");
		this.hashFields.put("dep", "dep");
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("dtl_vsl", "dtlVsl");
		this.hashFields.put("dtl_voy_no", "dtlVoyNo");
		this.hashFields.put("log_userid", "logUserid");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("dtl_dep", "dtlDep");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("pt", "pt");
		this.hashFields.put("d_remark", "dRemark");
		this.hashFields.put("h_remark", "hRemark");
		this.hashFields.put("change_ind", "changeInd");
		this.hashFields.put("row_num", "rowNum");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * Column Info
	 * @return loadQnt
	 */
	public String getLoadQnt() {
		return this.loadQnt;
	}
	
	/**
	 * Column Info
	 * @return skdSkdStat
	 */
	public String getSkdSkdStat() {
		return this.skdSkdStat;
	}
	
	/**
	 * Column Info
	 * @return delMk
	 */
	public String getDelMk() {
		return this.delMk;
	}
	
	/**
	 * Column Info
	 * @return voyTp
	 */
	public String getVoyTp() {
		return this.voyTp;
	}
	
	/**
	 * Column Info
	 * @return lineCnt
	 */
	public String getLineCnt() {
		return this.lineCnt;
	}
	
	/**
	 * Column Info
	 * @return vesselCheck
	 */
	public String getVesselCheck() {
		return this.vesselCheck;
	}
	
	/**
	 * Column Info
	 * @return newSailDt
	 */
	public String getNewSailDt() {
		return this.newSailDt;
	}
	
	/**
	 * Column Info
	 * @return estArrDt
	 */
	public String getEstArrDt() {
		return this.estArrDt;
	}
	
	/**
	 * Column Info
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
	}
	
	/**
	 * Column Info
	 * @return vpsSkdStat
	 */
	public String getVpsSkdStat() {
		return this.vpsSkdStat;
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
	 * @return estSailDt
	 */
	public String getEstSailDt() {
		return this.estSailDt;
	}
	
	/**
	 * Column Info
	 * @return actSailDt
	 */
	public String getActSailDt() {
		return this.actSailDt;
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
	 * @return vsl
	 */
	public String getVsl() {
		return this.vsl;
	}
	
	/**
	 * Column Info
	 * @return logUpdt
	 */
	public String getLogUpdt() {
		return this.logUpdt;
	}
	
	/**
	 * Column Info
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return logRgst
	 */
	public String getLogRgst() {
		return this.logRgst;
	}
	
	/**
	 * Column Info
	 * @return turnInd
	 */
	public String getTurnInd() {
		return this.turnInd;
	}
	
	/**
	 * Column Info
	 * @return survey
	 */
	public String getSurvey() {
		return this.survey;
	}
	
	/**
	 * Column Info
	 * @return newArrDt
	 */
	public String getNewArrDt() {
		return this.newArrDt;
	}
	
	/**
	 * Column Info
	 * @return dep
	 */
	public String getDep() {
		return this.dep;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return dtlVsl
	 */
	public String getDtlVsl() {
		return this.dtlVsl;
	}
	
	/**
	 * Column Info
	 * @return dtlVoyNo
	 */
	public String getDtlVoyNo() {
		return this.dtlVoyNo;
	}
	
	/**
	 * Column Info
	 * @return logUserid
	 */
	public String getLogUserid() {
		return this.logUserid;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return dtlDep
	 */
	public String getDtlDep() {
		return this.dtlDep;
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
	 * @return pt
	 */
	public String getPt() {
		return this.pt;
	}
	
	/**
	 * Column Info
	 * @return dRemark
	 */
	public String getDRemark() {
		return this.dRemark;
	}
	
	/**
	 * Column Info
	 * @return hRemark
	 */
	public String getHRemark() {
		return this.hRemark;
	}
	
	/**
	 * Column Info
	 * @return changeInd
	 */
	public String getChangeInd() {
		return this.changeInd;
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
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Column Info
	 * @param loadQnt
	 */
	public void setLoadQnt(String loadQnt) {
		this.loadQnt = loadQnt;
	}
	
	/**
	 * Column Info
	 * @param skdSkdStat
	 */
	public void setSkdSkdStat(String skdSkdStat) {
		this.skdSkdStat = skdSkdStat;
	}
	
	/**
	 * Column Info
	 * @param delMk
	 */
	public void setDelMk(String delMk) {
		this.delMk = delMk;
	}
	
	/**
	 * Column Info
	 * @param voyTp
	 */
	public void setVoyTp(String voyTp) {
		this.voyTp = voyTp;
	}
	
	/**
	 * Column Info
	 * @param lineCnt
	 */
	public void setLineCnt(String lineCnt) {
		this.lineCnt = lineCnt;
	}
	
	/**
	 * Column Info
	 * @param vesselCheck
	 */
	public void setVesselCheck(String vesselCheck) {
		this.vesselCheck = vesselCheck;
	}
	
	/**
	 * Column Info
	 * @param newSailDt
	 */
	public void setNewSailDt(String newSailDt) {
		this.newSailDt = newSailDt;
	}
	
	/**
	 * Column Info
	 * @param estArrDt
	 */
	public void setEstArrDt(String estArrDt) {
		this.estArrDt = estArrDt;
	}
	
	/**
	 * Column Info
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
	}
	
	/**
	 * Column Info
	 * @param vpsSkdStat
	 */
	public void setVpsSkdStat(String vpsSkdStat) {
		this.vpsSkdStat = vpsSkdStat;
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
	 * @param estSailDt
	 */
	public void setEstSailDt(String estSailDt) {
		this.estSailDt = estSailDt;
	}
	
	/**
	 * Column Info
	 * @param actSailDt
	 */
	public void setActSailDt(String actSailDt) {
		this.actSailDt = actSailDt;
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
	 * @param vsl
	 */
	public void setVsl(String vsl) {
		this.vsl = vsl;
	}
	
	/**
	 * Column Info
	 * @param logUpdt
	 */
	public void setLogUpdt(String logUpdt) {
		this.logUpdt = logUpdt;
	}
	
	/**
	 * Column Info
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param logRgst
	 */
	public void setLogRgst(String logRgst) {
		this.logRgst = logRgst;
	}
	
	/**
	 * Column Info
	 * @param turnInd
	 */
	public void setTurnInd(String turnInd) {
		this.turnInd = turnInd;
	}
	
	/**
	 * Column Info
	 * @param survey
	 */
	public void setSurvey(String survey) {
		this.survey = survey;
	}
	
	/**
	 * Column Info
	 * @param newArrDt
	 */
	public void setNewArrDt(String newArrDt) {
		this.newArrDt = newArrDt;
	}
	
	/**
	 * Column Info
	 * @param dep
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}
	
	/**
	 * Column Info
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param dtlVsl
	 */
	public void setDtlVsl(String dtlVsl) {
		this.dtlVsl = dtlVsl;
	}
	
	/**
	 * Column Info
	 * @param dtlVoyNo
	 */
	public void setDtlVoyNo(String dtlVoyNo) {
		this.dtlVoyNo = dtlVoyNo;
	}
	
	/**
	 * Column Info
	 * @param logUserid
	 */
	public void setLogUserid(String logUserid) {
		this.logUserid = logUserid;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlDep
	 */
	public void setDtlDep(String dtlDep) {
		this.dtlDep = dtlDep;
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
	 * @param pt
	 */
	public void setPt(String pt) {
		this.pt = pt;
	}
	
	/**
	 * Column Info
	 * @param dRemark
	 */
	public void setDRemark(String dRemark) {
		this.dRemark = dRemark;
	}
	
	/**
	 * Column Info
	 * @param hRemark
	 */
	public void setHRemark(String hRemark) {
		this.hRemark = hRemark;
	}
	
	/**
	 * Column Info
	 * @param changeInd
	 */
	public void setChangeInd(String changeInd) {
		this.changeInd = changeInd;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPosition(JSPUtil.getParameter(request, "position", ""));
		setLoadQnt(JSPUtil.getParameter(request, "load_qnt", ""));
		setSkdSkdStat(JSPUtil.getParameter(request, "skd_skd_stat", ""));
		setDelMk(JSPUtil.getParameter(request, "del_mk", ""));
		setVoyTp(JSPUtil.getParameter(request, "voy_tp", ""));
		setLineCnt(JSPUtil.getParameter(request, "line_cnt", ""));
		setVesselCheck(JSPUtil.getParameter(request, "vessel_check", ""));
		setNewSailDt(JSPUtil.getParameter(request, "new_sail_dt", ""));
		setEstArrDt(JSPUtil.getParameter(request, "est_arr_dt", ""));
		setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
		setVpsSkdStat(JSPUtil.getParameter(request, "vps_skd_stat", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstSailDt(JSPUtil.getParameter(request, "est_sail_dt", ""));
		setActSailDt(JSPUtil.getParameter(request, "act_sail_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVsl(JSPUtil.getParameter(request, "vsl", ""));
		setLogUpdt(JSPUtil.getParameter(request, "log_updt", ""));
		setTotalCount(JSPUtil.getParameter(request, "total_count", ""));
		setLogRgst(JSPUtil.getParameter(request, "log_rgst", ""));
		setTurnInd(JSPUtil.getParameter(request, "turn_ind", ""));
		setSurvey(JSPUtil.getParameter(request, "survey", ""));
		setNewArrDt(JSPUtil.getParameter(request, "new_arr_dt", ""));
		setDep(JSPUtil.getParameter(request, "dep", ""));
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setDtlVsl(JSPUtil.getParameter(request, "dtl_vsl", ""));
		setDtlVoyNo(JSPUtil.getParameter(request, "dtl_voy_no", ""));
		setLogUserid(JSPUtil.getParameter(request, "log_userid", ""));
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setDtlDep(JSPUtil.getParameter(request, "dtl_dep", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setPt(JSPUtil.getParameter(request, "pt", ""));
		setDRemark(JSPUtil.getParameter(request, "d_remark", ""));
		setHRemark(JSPUtil.getParameter(request, "h_remark", ""));
		setChangeInd(JSPUtil.getParameter(request, "change_ind", ""));
		setRowNum(JSPUtil.getParameter(request, "row_num", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErpMsgFns017VO[]
	 */
	public ErpMsgFns017VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErpMsgFns017VO[]
	 */
	public ErpMsgFns017VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErpMsgFns017VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] position = (JSPUtil.getParameter(request, prefix	+ "position", length));
			String[] loadQnt = (JSPUtil.getParameter(request, prefix	+ "load_qnt", length));
			String[] skdSkdStat = (JSPUtil.getParameter(request, prefix	+ "skd_skd_stat", length));
			String[] delMk = (JSPUtil.getParameter(request, prefix	+ "del_mk", length));
			String[] voyTp = (JSPUtil.getParameter(request, prefix	+ "voy_tp", length));
			String[] lineCnt = (JSPUtil.getParameter(request, prefix	+ "line_cnt", length));
			String[] vesselCheck = (JSPUtil.getParameter(request, prefix	+ "vessel_check", length));
			String[] newSailDt = (JSPUtil.getParameter(request, prefix	+ "new_sail_dt", length));
			String[] estArrDt = (JSPUtil.getParameter(request, prefix	+ "est_arr_dt", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] vpsSkdStat = (JSPUtil.getParameter(request, prefix	+ "vps_skd_stat", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estSailDt = (JSPUtil.getParameter(request, prefix	+ "est_sail_dt", length));
			String[] actSailDt = (JSPUtil.getParameter(request, prefix	+ "act_sail_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vsl = (JSPUtil.getParameter(request, prefix	+ "vsl", length));
			String[] logUpdt = (JSPUtil.getParameter(request, prefix	+ "log_updt", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] logRgst = (JSPUtil.getParameter(request, prefix	+ "log_rgst", length));
			String[] turnInd = (JSPUtil.getParameter(request, prefix	+ "turn_ind", length));
			String[] survey = (JSPUtil.getParameter(request, prefix	+ "survey", length));
			String[] newArrDt = (JSPUtil.getParameter(request, prefix	+ "new_arr_dt", length));
			String[] dep = (JSPUtil.getParameter(request, prefix	+ "dep", length));
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] dtlVsl = (JSPUtil.getParameter(request, prefix	+ "dtl_vsl", length));
			String[] dtlVoyNo = (JSPUtil.getParameter(request, prefix	+ "dtl_voy_no", length));
			String[] logUserid = (JSPUtil.getParameter(request, prefix	+ "log_userid", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] dtlDep = (JSPUtil.getParameter(request, prefix	+ "dtl_dep", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] pt = (JSPUtil.getParameter(request, prefix	+ "pt", length));
			String[] dRemark = (JSPUtil.getParameter(request, prefix	+ "d_remark", length));
			String[] hRemark = (JSPUtil.getParameter(request, prefix	+ "h_remark", length));
			String[] changeInd = (JSPUtil.getParameter(request, prefix	+ "change_ind", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			
			for (int i = 0; i < length; i++) {
				model = new ErpMsgFns017VO();
				if (position[i] != null)
					model.setPosition(position[i]);
				if (loadQnt[i] != null)
					model.setLoadQnt(loadQnt[i]);
				if (skdSkdStat[i] != null)
					model.setSkdSkdStat(skdSkdStat[i]);
				if (delMk[i] != null)
					model.setDelMk(delMk[i]);
				if (voyTp[i] != null)
					model.setVoyTp(voyTp[i]);
				if (lineCnt[i] != null)
					model.setLineCnt(lineCnt[i]);
				if (vesselCheck[i] != null)
					model.setVesselCheck(vesselCheck[i]);
				if (newSailDt[i] != null)
					model.setNewSailDt(newSailDt[i]);
				if (estArrDt[i] != null)
					model.setEstArrDt(estArrDt[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (vpsSkdStat[i] != null)
					model.setVpsSkdStat(vpsSkdStat[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estSailDt[i] != null)
					model.setEstSailDt(estSailDt[i]);
				if (actSailDt[i] != null)
					model.setActSailDt(actSailDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vsl[i] != null)
					model.setVsl(vsl[i]);
				if (logUpdt[i] != null)
					model.setLogUpdt(logUpdt[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (logRgst[i] != null)
					model.setLogRgst(logRgst[i]);
				if (turnInd[i] != null)
					model.setTurnInd(turnInd[i]);
				if (survey[i] != null)
					model.setSurvey(survey[i]);
				if (newArrDt[i] != null)
					model.setNewArrDt(newArrDt[i]);
				if (dep[i] != null)
					model.setDep(dep[i]);
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (dtlVsl[i] != null)
					model.setDtlVsl(dtlVsl[i]);
				if (dtlVoyNo[i] != null)
					model.setDtlVoyNo(dtlVoyNo[i]);
				if (logUserid[i] != null)
					model.setLogUserid(logUserid[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (dtlDep[i] != null)
					model.setDtlDep(dtlDep[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (pt[i] != null)
					model.setPt(pt[i]);
				if (dRemark[i] != null)
					model.setDRemark(dRemark[i]);
				if (hRemark[i] != null)
					model.setHRemark(hRemark[i]);
				if (changeInd[i] != null)
					model.setChangeInd(changeInd[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getErpMsgFns017VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ErpMsgFns017VO[]
	 */
	public ErpMsgFns017VO[] getErpMsgFns017VOs(){
		ErpMsgFns017VO[] vos = (ErpMsgFns017VO[])models.toArray(new ErpMsgFns017VO[models.size()]);
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
		this.position = this.position .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadQnt = this.loadQnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdSkdStat = this.skdSkdStat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delMk = this.delMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyTp = this.voyTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineCnt = this.lineCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselCheck = this.vesselCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSailDt = this.newSailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estArrDt = this.estArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsSkdStat = this.vpsSkdStat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estSailDt = this.estSailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSailDt = this.actSailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl = this.vsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logUpdt = this.logUpdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logRgst = this.logRgst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnInd = this.turnInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.survey = this.survey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newArrDt = this.newArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dep = this.dep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlVsl = this.dtlVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlVoyNo = this.dtlVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logUserid = this.logUserid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlDep = this.dtlDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pt = this.pt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dRemark = this.dRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hRemark = this.hRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.changeInd = this.changeInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
