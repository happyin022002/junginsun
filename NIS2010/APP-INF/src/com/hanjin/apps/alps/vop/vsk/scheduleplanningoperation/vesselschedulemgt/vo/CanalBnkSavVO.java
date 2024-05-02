/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalBnkSavVO.java
*@FileTitle : CanalBnkSavVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.10.09 유혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalBnkSavVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalBnkSavVO> models = new ArrayList<CanalBnkSavVO>();
	
	/* Column Info */
	private String seaDirScale = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String addBunkerConsumQty = null;
	/* Column Info */
	private String courseOrg = null;
	/* Column Info */
	private String addBunkerConsumAmount = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String addBunkerAmount02 = null;
	/* Column Info */
	private String nextPortEtaSpeed = null;
	/* Column Info */
	private String addBunkerConsum02 = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String canalTzSurchgAmt = null;
	/* Column Info */
	private String supplyBunkerQty = null;
	/* Column Info */
	private String fmPort = null;
	/* Column Info */
	private String windDirScale = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String etaSpeed = null;
	/* Column Info */
	private String remainBunker = null;
	/* Column Info */
	private String nxtPortEta = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bunkerConsumByEta = null;
	/* Column Info */
	private String toPort = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String suzNetTongWgt = null;
	/* Column Info */
	private String reportedDate = null;
	/* Column Info */
	private String supplyBunkerPort = null;
	/* Column Info */
	private String remainDist = null;
	/* Column Info */
	private String remainSpd = null;
	/* Column Info */
	private String lmtTmScgRto = null;
	/* Column Info */
	private String actualBunkerPrice = null;
	/* Column Info */
	private String cts1st = null;
	/* Column Info */
	private String cts2nd = null;
	/* Column Info */
	private String cts3rd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalBnkSavVO() {}

	public CanalBnkSavVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String lmtTmScgRto, String etaSpeed, String addBunkerConsumQty, String addBunkerConsumAmount, String nextPortEtaSpeed, String addBunkerConsum02, String addBunkerAmount02, String result, String fmPort, String toPort, String reportedDate, String nxtPortEta, String remainDist, String remainSpd, String windDirScale, String seaDirScale, String supplyBunkerQty, String supplyBunkerPort, String actualBunkerPrice, String remainBunker, String bunkerConsumByEta, String courseOrg, String canalTzSurchgAmt, String suzNetTongWgt, String nextPort, String cts1st, String cts2nd, String cts3rd) {
		this.seaDirScale = seaDirScale;
		this.vslCd = vslCd;
		this.result = result;
		this.addBunkerConsumQty = addBunkerConsumQty;
		this.courseOrg = courseOrg;
		this.addBunkerConsumAmount = addBunkerConsumAmount;
		this.pagerows = pagerows;
		this.addBunkerAmount02 = addBunkerAmount02;
		this.nextPortEtaSpeed = nextPortEtaSpeed;
		this.addBunkerConsum02 = addBunkerConsum02;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.canalTzSurchgAmt = canalTzSurchgAmt;
		this.supplyBunkerQty = supplyBunkerQty;
		this.fmPort = fmPort;
		this.windDirScale = windDirScale;
		this.nextPort = nextPort;
		this.etaSpeed = etaSpeed;
		this.remainBunker = remainBunker;
		this.nxtPortEta = nxtPortEta;
		this.skdVoyNo = skdVoyNo;
		this.bunkerConsumByEta = bunkerConsumByEta;
		this.toPort = toPort;
		this.skdDirCd = skdDirCd;
		this.suzNetTongWgt = suzNetTongWgt;
		this.reportedDate = reportedDate;
		this.supplyBunkerPort = supplyBunkerPort;
		this.remainDist = remainDist;
		this.remainSpd = remainSpd;
		this.lmtTmScgRto = lmtTmScgRto;
		this.actualBunkerPrice = actualBunkerPrice;
		this.cts1st = cts1st;
		this.cts2nd = cts2nd;
		this.cts3rd = cts3rd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sea_dir_scale", getSeaDirScale());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("add_bunker_consum_qty", getAddBunkerConsumQty());
		this.hashColumns.put("course_org", getCourseOrg());
		this.hashColumns.put("add_bunker_consum_amount", getAddBunkerConsumAmount());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("add_bunker_amount_02", getAddBunkerAmount02());
		this.hashColumns.put("next_port_eta_speed", getNextPortEtaSpeed());
		this.hashColumns.put("add_bunker_consum_02", getAddBunkerConsum02());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("canal_tz_surchg_amt", getCanalTzSurchgAmt());
		this.hashColumns.put("supply_bunker_qty", getSupplyBunkerQty());
		this.hashColumns.put("fm_port", getFmPort());
		this.hashColumns.put("wind_dir_scale", getWindDirScale());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("eta_speed", getEtaSpeed());
		this.hashColumns.put("remain_bunker", getRemainBunker());
		this.hashColumns.put("nxt_port_eta", getNxtPortEta());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bunker_consum_by_eta", getBunkerConsumByEta());
		this.hashColumns.put("to_port", getToPort());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
		this.hashColumns.put("reported_date", getReportedDate());
		this.hashColumns.put("supply_bunker_port", getSupplyBunkerPort());
		this.hashColumns.put("remain_dist", getRemainDist());
		this.hashColumns.put("remain_spd", getRemainSpd());
		this.hashColumns.put("lmt_tm_scg_rto", getLmtTmScgRto());
		this.hashColumns.put("actual_bunker_price", getActualBunkerPrice());
		this.hashColumns.put("cts_1st", getCts1st());
		this.hashColumns.put("cts_2nd", getCts2nd());
		this.hashColumns.put("cts_3rd", getCts3rd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sea_dir_scale", "seaDirScale");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("result", "result");
		this.hashFields.put("add_bunker_consum_qty", "addBunkerConsumQty");
		this.hashFields.put("course_org", "courseOrg");
		this.hashFields.put("add_bunker_consum_amount", "addBunkerConsumAmount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("add_bunker_amount_02", "addBunkerAmount02");
		this.hashFields.put("next_port_eta_speed", "nextPortEtaSpeed");
		this.hashFields.put("add_bunker_consum_02", "addBunkerConsum02");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("canal_tz_surchg_amt", "canalTzSurchgAmt");
		this.hashFields.put("supply_bunker_qty", "supplyBunkerQty");
		this.hashFields.put("fm_port", "fmPort");
		this.hashFields.put("wind_dir_scale", "windDirScale");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("eta_speed", "etaSpeed");
		this.hashFields.put("remain_bunker", "remainBunker");
		this.hashFields.put("nxt_port_eta", "nxtPortEta");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bunker_consum_by_eta", "bunkerConsumByEta");
		this.hashFields.put("to_port", "toPort");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
		this.hashFields.put("reported_date", "reportedDate");
		this.hashFields.put("supply_bunker_port", "supplyBunkerPort");
		this.hashFields.put("remain_dist", "remainDist");
		this.hashFields.put("remain_spd", "remainSpd");
		this.hashFields.put("lmt_tm_scg_rto", "lmtTmScgRto");
		this.hashFields.put("actual_bunker_price", "actualBunkerPrice");
		this.hashFields.put("cts_1st", "cts1st");
		this.hashFields.put("cts_2nd", "cts2nd");
		this.hashFields.put("cts_3rd", "cts3rd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return seaDirScale
	 */
	public String getSeaDirScale() {
		return this.seaDirScale;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return addBunkerConsumQty
	 */
	public String getAddBunkerConsumQty() {
		return this.addBunkerConsumQty;
	}
	
	/**
	 * Column Info
	 * @return courseOrg
	 */
	public String getCourseOrg() {
		return this.courseOrg;
	}
	
	/**
	 * Column Info
	 * @return addBunkerConsumAmount
	 */
	public String getAddBunkerConsumAmount() {
		return this.addBunkerConsumAmount;
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
	 * @return addBunkerAmount02
	 */
	public String getAddBunkerAmount02() {
		return this.addBunkerAmount02;
	}
	
	/**
	 * Column Info
	 * @return nextPortEtaSpeed
	 */
	public String getNextPortEtaSpeed() {
		return this.nextPortEtaSpeed;
	}
	
	/**
	 * Column Info
	 * @return addBunkerConsum02
	 */
	public String getAddBunkerConsum02() {
		return this.addBunkerConsum02;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return canalTzSurchgAmt
	 */
	public String getCanalTzSurchgAmt() {
		return this.canalTzSurchgAmt;
	}
	
	/**
	 * Column Info
	 * @return supplyBunkerQty
	 */
	public String getSupplyBunkerQty() {
		return this.supplyBunkerQty;
	}
	
	/**
	 * Column Info
	 * @return fmPort
	 */
	public String getFmPort() {
		return this.fmPort;
	}
	
	/**
	 * Column Info
	 * @return windDirScale
	 */
	public String getWindDirScale() {
		return this.windDirScale;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	
	/**
	 * Column Info
	 * @return etaSpeed
	 */
	public String getEtaSpeed() {
		return this.etaSpeed;
	}
	
	/**
	 * Column Info
	 * @return remainBunker
	 */
	public String getRemainBunker() {
		return this.remainBunker;
	}
	
	/**
	 * Column Info
	 * @return nxtPortEta
	 */
	public String getNxtPortEta() {
		return this.nxtPortEta;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bunkerConsumByEta
	 */
	public String getBunkerConsumByEta() {
		return this.bunkerConsumByEta;
	}
	
	/**
	 * Column Info
	 * @return toPort
	 */
	public String getToPort() {
		return this.toPort;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return suzNetTongWgt
	 */
	public String getSuzNetTongWgt() {
		return this.suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return reportedDate
	 */
	public String getReportedDate() {
		return this.reportedDate;
	}
	
	/**
	 * Column Info
	 * @return supplyBunkerPort
	 */
	public String getSupplyBunkerPort() {
		return this.supplyBunkerPort;
	}
	
	/**
	 * Column Info
	 * @return remainDist
	 */
	public String getRemainDist() {
		return this.remainDist;
	}
	
	/**
	 * Column Info
	 * @return remainSpd
	 */
	public String getRemainSpd() {
		return this.remainSpd;
	}
	
	/**
	 * Column Info
	 * @return lmtTmScgRto
	 */
	public String getLmtTmScgRto() {
		return this.lmtTmScgRto;
	}
	
	/**
	 * Column Info
	 * @return actualBunkerPrice
	 */
	public String getActualBunkerPrice() {
		return this.actualBunkerPrice;
	}
	
	/**
	 * Column Info
	 * @return cts1st
	 */
	public String getCts1st(){
		return this.cts1st;
	}
	
	/**
	 * Column Info
	 * @return cts2nd
	 */
	public String getCts2nd(){
		return this.cts2nd;
	}
	
	/**
	 * Column Info
	 * @return cts3rd
	 */
	public String getCts3rd(){
		return this.cts3rd;
	}

	/**
	 * Column Info
	 * @param seaDirScale
	 */
	public void setSeaDirScale(String seaDirScale) {
		this.seaDirScale = seaDirScale;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param addBunkerConsumQty
	 */
	public void setAddBunkerConsumQty(String addBunkerConsumQty) {
		this.addBunkerConsumQty = addBunkerConsumQty;
	}
	
	/**
	 * Column Info
	 * @param courseOrg
	 */
	public void setCourseOrg(String courseOrg) {
		this.courseOrg = courseOrg;
	}
	
	/**
	 * Column Info
	 * @param addBunkerConsumAmount
	 */
	public void setAddBunkerConsumAmount(String addBunkerConsumAmount) {
		this.addBunkerConsumAmount = addBunkerConsumAmount;
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
	 * @param addBunkerAmount02
	 */
	public void setAddBunkerAmount02(String addBunkerAmount02) {
		this.addBunkerAmount02 = addBunkerAmount02;
	}
	
	/**
	 * Column Info
	 * @param nextPortEtaSpeed
	 */
	public void setNextPortEtaSpeed(String nextPortEtaSpeed) {
		this.nextPortEtaSpeed = nextPortEtaSpeed;
	}
	
	/**
	 * Column Info
	 * @param addBunkerConsum02
	 */
	public void setAddBunkerConsum02(String addBunkerConsum02) {
		this.addBunkerConsum02 = addBunkerConsum02;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param canalTzSurchgAmt
	 */
	public void setCanalTzSurchgAmt(String canalTzSurchgAmt) {
		this.canalTzSurchgAmt = canalTzSurchgAmt;
	}
	
	/**
	 * Column Info
	 * @param supplyBunkerQty
	 */
	public void setSupplyBunkerQty(String supplyBunkerQty) {
		this.supplyBunkerQty = supplyBunkerQty;
	}
	
	/**
	 * Column Info
	 * @param fmPort
	 */
	public void setFmPort(String fmPort) {
		this.fmPort = fmPort;
	}
	
	/**
	 * Column Info
	 * @param windDirScale
	 */
	public void setWindDirScale(String windDirScale) {
		this.windDirScale = windDirScale;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Column Info
	 * @param etaSpeed
	 */
	public void setEtaSpeed(String etaSpeed) {
		this.etaSpeed = etaSpeed;
	}
	
	/**
	 * Column Info
	 * @param remainBunker
	 */
	public void setRemainBunker(String remainBunker) {
		this.remainBunker = remainBunker;
	}
	
	/**
	 * Column Info
	 * @param nxtPortEta
	 */
	public void setNxtPortEta(String nxtPortEta) {
		this.nxtPortEta = nxtPortEta;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bunkerConsumByEta
	 */
	public void setBunkerConsumByEta(String bunkerConsumByEta) {
		this.bunkerConsumByEta = bunkerConsumByEta;
	}
	
	/**
	 * Column Info
	 * @param toPort
	 */
	public void setToPort(String toPort) {
		this.toPort = toPort;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param suzNetTongWgt
	 */
	public void setSuzNetTongWgt(String suzNetTongWgt) {
		this.suzNetTongWgt = suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param reportedDate
	 */
	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	/**
	 * Column Info
	 * @param supplyBunkerPort
	 */
	public void setSupplyBunkerPort(String supplyBunkerPort) {
		this.supplyBunkerPort = supplyBunkerPort;
	}
	
	/**
	 * Column Info
	 * @param remainDist
	 */
	public void setRemainDist(String remainDist) {
		this.remainDist = remainDist;
	}
	
	/**
	 * Column Info
	 * @param remainSpd
	 */
	public void setRemainSpd(String remainSpd) {
		this.remainSpd = remainSpd;
	}
	
	/**
	 * Column Info
	 * @param lmtTmScgRto
	 */
	public void setLmtTmScgRto(String lmtTmScgRto) {
		this.lmtTmScgRto = lmtTmScgRto;
	}
	
	/**
	 * Column Info
	 * @param actualBunkerPrice
	 */
	public void setActualBunkerPrice(String actualBunkerPrice) {
		this.actualBunkerPrice = actualBunkerPrice;
	}
	
	/**
	 * Column Info
	 * @param cts1st
	 */
	public void setCts1st(String cts1st){
		this.cts1st = cts1st;
	}
	
	/**
	 * Column Info
	 * @param cts2nd
	 */
	public void setCts2nd(String cts2nd){
		this.cts2nd = cts2nd;
	}
	
	/**
	 * Column Info
	 * @param cts3rd
	 */
	public void setCts3rd(String cts3rd){
		this.cts3rd = cts3rd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSeaDirScale(JSPUtil.getParameter(request, "sea_dir_scale", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setResult(JSPUtil.getParameter(request, "result", ""));
		setAddBunkerConsumQty(JSPUtil.getParameter(request, "add_bunker_consum_qty", ""));
		setCourseOrg(JSPUtil.getParameter(request, "course_org", ""));
		setAddBunkerConsumAmount(JSPUtil.getParameter(request, "add_bunker_consum_amount", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAddBunkerAmount02(JSPUtil.getParameter(request, "add_bunker_amount_02", ""));
		setNextPortEtaSpeed(JSPUtil.getParameter(request, "next_port_eta_speed", ""));
		setAddBunkerConsum02(JSPUtil.getParameter(request, "add_bunker_consum_02", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCanalTzSurchgAmt(JSPUtil.getParameter(request, "canal_tz_surchg_amt", ""));
		setSupplyBunkerQty(JSPUtil.getParameter(request, "supply_bunker_qty", ""));
		setFmPort(JSPUtil.getParameter(request, "fm_port", ""));
		setWindDirScale(JSPUtil.getParameter(request, "wind_dir_scale", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setEtaSpeed(JSPUtil.getParameter(request, "eta_speed", ""));
		setRemainBunker(JSPUtil.getParameter(request, "remain_bunker", ""));
		setNxtPortEta(JSPUtil.getParameter(request, "nxt_port_eta", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBunkerConsumByEta(JSPUtil.getParameter(request, "bunker_consum_by_eta", ""));
		setToPort(JSPUtil.getParameter(request, "to_port", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSuzNetTongWgt(JSPUtil.getParameter(request, "suz_net_tong_wgt", ""));
		setReportedDate(JSPUtil.getParameter(request, "reported_date", ""));
		setSupplyBunkerPort(JSPUtil.getParameter(request, "supply_bunker_port", ""));
		setRemainDist(JSPUtil.getParameter(request, "remain_dist", ""));
		setRemainSpd(JSPUtil.getParameter(request, "remain_spd", ""));
		setLmtTmScgRto(JSPUtil.getParameter(request, "lmt_tm_scg_rto", ""));
		setActualBunkerPrice(JSPUtil.getParameter(request, "actual_bunker_price", ""));
		setCts1st(JSPUtil.getParameter(request, "cts_1st", ""));
		setCts2nd(JSPUtil.getParameter(request, "cts_2nd", ""));
		setCts3rd(JSPUtil.getParameter(request, "cts_3rd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalBnkSavVO[]
	 */
	public CanalBnkSavVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalBnkSavVO[]
	 */
	public CanalBnkSavVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalBnkSavVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] seaDirScale = (JSPUtil.getParameter(request, prefix	+ "sea_dir_scale", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] addBunkerConsumQty = (JSPUtil.getParameter(request, prefix	+ "add_bunker_consum_qty", length));
			String[] courseOrg = (JSPUtil.getParameter(request, prefix	+ "course_org", length));
			String[] addBunkerConsumAmount = (JSPUtil.getParameter(request, prefix	+ "add_bunker_consum_amount", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] addBunkerAmount02 = (JSPUtil.getParameter(request, prefix	+ "add_bunker_amount_02", length));
			String[] nextPortEtaSpeed = (JSPUtil.getParameter(request, prefix	+ "next_port_eta_speed", length));
			String[] addBunkerConsum02 = (JSPUtil.getParameter(request, prefix	+ "add_bunker_consum_02", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] canalTzSurchgAmt = (JSPUtil.getParameter(request, prefix	+ "canal_tz_surchg_amt", length));
			String[] supplyBunkerQty = (JSPUtil.getParameter(request, prefix	+ "supply_bunker_qty", length));
			String[] fmPort = (JSPUtil.getParameter(request, prefix	+ "fm_port", length));
			String[] windDirScale = (JSPUtil.getParameter(request, prefix	+ "wind_dir_scale", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] etaSpeed = (JSPUtil.getParameter(request, prefix	+ "eta_speed", length));
			String[] remainBunker = (JSPUtil.getParameter(request, prefix	+ "remain_bunker", length));
			String[] nxtPortEta = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bunkerConsumByEta = (JSPUtil.getParameter(request, prefix	+ "bunker_consum_by_eta", length));
			String[] toPort = (JSPUtil.getParameter(request, prefix	+ "to_port", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "suz_net_tong_wgt", length));
			String[] reportedDate = (JSPUtil.getParameter(request, prefix	+ "reported_date", length));
			String[] supplyBunkerPort = (JSPUtil.getParameter(request, prefix	+ "supply_bunker_port", length));
			String[] remainDist = (JSPUtil.getParameter(request, prefix	+ "remain_dist", length));
			String[] remainSpd = (JSPUtil.getParameter(request, prefix	+ "remain_spd", length));
			String[] lmtTmScgRto = (JSPUtil.getParameter(request, prefix	+ "lmt_tm_scg_rto", length));
			String[] actualBunkerPrice = (JSPUtil.getParameter(request, prefix	+ "actual_bunker_price", length));
			String[] cts1st = (JSPUtil.getParameter(request, prefix	+ "cts_1st", length));
			String[] cts2nd = (JSPUtil.getParameter(request, prefix	+ "cts_2nd", length));
			String[] cts3rd = (JSPUtil.getParameter(request, prefix	+ "cts_3rd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalBnkSavVO();
				if (seaDirScale[i] != null)
					model.setSeaDirScale(seaDirScale[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (addBunkerConsumQty[i] != null)
					model.setAddBunkerConsumQty(addBunkerConsumQty[i]);
				if (courseOrg[i] != null)
					model.setCourseOrg(courseOrg[i]);
				if (addBunkerConsumAmount[i] != null)
					model.setAddBunkerConsumAmount(addBunkerConsumAmount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (addBunkerAmount02[i] != null)
					model.setAddBunkerAmount02(addBunkerAmount02[i]);
				if (nextPortEtaSpeed[i] != null)
					model.setNextPortEtaSpeed(nextPortEtaSpeed[i]);
				if (addBunkerConsum02[i] != null)
					model.setAddBunkerConsum02(addBunkerConsum02[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (canalTzSurchgAmt[i] != null)
					model.setCanalTzSurchgAmt(canalTzSurchgAmt[i]);
				if (supplyBunkerQty[i] != null)
					model.setSupplyBunkerQty(supplyBunkerQty[i]);
				if (fmPort[i] != null)
					model.setFmPort(fmPort[i]);
				if (windDirScale[i] != null)
					model.setWindDirScale(windDirScale[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (etaSpeed[i] != null)
					model.setEtaSpeed(etaSpeed[i]);
				if (remainBunker[i] != null)
					model.setRemainBunker(remainBunker[i]);
				if (nxtPortEta[i] != null)
					model.setNxtPortEta(nxtPortEta[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bunkerConsumByEta[i] != null)
					model.setBunkerConsumByEta(bunkerConsumByEta[i]);
				if (toPort[i] != null)
					model.setToPort(toPort[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (suzNetTongWgt[i] != null)
					model.setSuzNetTongWgt(suzNetTongWgt[i]);
				if (reportedDate[i] != null)
					model.setReportedDate(reportedDate[i]);
				if (supplyBunkerPort[i] != null)
					model.setSupplyBunkerPort(supplyBunkerPort[i]);
				if (remainDist[i] != null)
					model.setRemainDist(remainDist[i]);
				if (remainSpd[i] != null)
					model.setRemainSpd(remainSpd[i]);
				if (lmtTmScgRto[i] != null)
					model.setLmtTmScgRto(lmtTmScgRto[i]);
				if (actualBunkerPrice[i] != null)
					model.setActualBunkerPrice(actualBunkerPrice[i]);
				if (cts1st[i] != null)
					model.setCts1st(cts1st[i]);
				if (cts2nd[i] != null)
					model.setCts2nd(cts2nd[i]);
				if (cts3rd[i] != null)
					model.setCts3rd(cts3rd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalBnkSavVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalBnkSavVO[]
	 */
	public CanalBnkSavVO[] getCanalBnkSavVOs(){
		CanalBnkSavVO[] vos = (CanalBnkSavVO[])models.toArray(new CanalBnkSavVO[models.size()]);
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
		this.seaDirScale = this.seaDirScale .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addBunkerConsumQty = this.addBunkerConsumQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.courseOrg = this.courseOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addBunkerConsumAmount = this.addBunkerConsumAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addBunkerAmount02 = this.addBunkerAmount02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPortEtaSpeed = this.nextPortEtaSpeed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addBunkerConsum02 = this.addBunkerConsum02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.canalTzSurchgAmt = this.canalTzSurchgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplyBunkerQty = this.supplyBunkerQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPort = this.fmPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.windDirScale = this.windDirScale .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaSpeed = this.etaSpeed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remainBunker = this.remainBunker .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEta = this.nxtPortEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerConsumByEta = this.bunkerConsumByEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPort = this.toPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzNetTongWgt = this.suzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportedDate = this.reportedDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplyBunkerPort = this.supplyBunkerPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remainDist = this.remainDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remainSpd = this.remainSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtTmScgRto = this.lmtTmScgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualBunkerPrice = this.actualBunkerPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cts1st = this.cts1st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cts2nd = this.cts2nd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cts3rd = this.cts3rd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
