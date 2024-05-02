/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSkdOnLongRangeVO.java
*@FileTitle : PortSkdOnLongRangeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.12.07 유혁 
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.08.09 진마리아 CHM-201111568-01 [VOP-VSK] LRS SKD inquiry 화면 및 로직 수정 요청건
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortSkdOnLongRangeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortSkdOnLongRangeVO> models = new ArrayList<PortSkdOnLongRangeVO>();
	
	/* Column Info */
	private String startDate = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsRmk = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String endDate = null;
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String portSkdStsCd = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String initEtaDt = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String initEtbDt = null;
	/* Column Info */
	private String pfEtaDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String initEtdDt = null;
	/* Column Info */
	private String vslSlanDirSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String turnClptIndSeq = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String portNm = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String incDelVsl = null;
	/* Column Info */
	private String unitTp = null;
	
	/* Column Info */
	private String actCrrCd = null;	
	/* Column Info */
	private String phsIoRsnCd = null;
	
	private boolean emptySkd = false;
	private boolean addingSkd = false;
	private boolean reverse = false;
	
	private PfSkdDetailVO pfSkdDetailVO = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortSkdOnLongRangeVO() {}

	public PortSkdOnLongRangeVO(String ibflag, String pagerows, String vslSlanCd, String pfSkdTpCd, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanDirSeq, String vpsPortCd, String clptIndSeq, String clptSeq, String portSkdStsCd, String ydCd, String callYdIndSeq, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String skdCngStsCd, String turnPortFlg, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String vpsRmk, String startDate, String endDate, String creDt, String creUsrId, String updDt, String updUsrId, String vslSvcTpCd, String portNm, String vslEngNm, String incDelVsl, String unitTp, String actCrrCd, String phsIoRsnCd) {
		this.startDate = startDate;
		this.vslCd = vslCd;
		this.vpsRmk = vpsRmk;
		this.vpsEtbDt = vpsEtbDt;
		this.turnPortFlg = turnPortFlg;
		this.creDt = creDt;
		this.pfSkdTpCd = pfSkdTpCd;
		this.endDate = endDate;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.turnSkdDirCd = turnSkdDirCd;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.portSkdStsCd = portSkdStsCd;
		this.callYdIndSeq = callYdIndSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.initEtaDt = initEtaDt;
		this.pfEtdDt = pfEtdDt;
		this.vpsEtdDt = vpsEtdDt;
		this.initEtbDt = initEtbDt;
		this.pfEtaDt = pfEtaDt;
		this.skdVoyNo = skdVoyNo;
		this.pfEtbDt = pfEtbDt;
		this.initEtdDt = initEtdDt;
		this.vslSlanDirSeq = vslSlanDirSeq;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.skdCngStsCd = skdCngStsCd;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.turnClptIndSeq = turnClptIndSeq;
		this.vslSvcTpCd = vslSvcTpCd;
		this.portNm = portNm;
		this.vslEngNm = vslEngNm;
		this.incDelVsl = incDelVsl;
		this.unitTp = unitTp;
		
		this.actCrrCd = actCrrCd;
		this.phsIoRsnCd = phsIoRsnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("start_date", getStartDate());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_rmk", getVpsRmk());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("end_date", getEndDate());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("init_etb_dt", getInitEtbDt());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("init_etd_dt", getInitEtdDt());
		this.hashColumns.put("vsl_slan_dir_seq", getVslSlanDirSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("inc_del_vsl", getIncDelVsl());
		this.hashColumns.put("unit_tp", getUnitTp());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("start_date", "startDate");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_rmk", "vpsRmk");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("end_date", "endDate");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("init_etb_dt", "initEtbDt");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("init_etd_dt", "initEtdDt");
		this.hashFields.put("vsl_slan_dir_seq", "vslSlanDirSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("inc_del_vsl", "incDelVsl");
		this.hashFields.put("unit_tp", "unitTp");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return startDate
	 */
	public String getStartDate() {
		return this.startDate;
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
	 * @return vpsRmk
	 */
	public String getVpsRmk() {
		return this.vpsRmk;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return turnPortFlg
	 */
	public String getTurnPortFlg() {
		return this.turnPortFlg;
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
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return endDate
	 */
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * Column Info
	 * @return turnSkdVoyNo
	 */
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
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
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return portSkdStsCd
	 */
	public String getPortSkdStsCd() {
		return this.portSkdStsCd;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return initEtaDt
	 */
	public String getInitEtaDt() {
		return this.initEtaDt;
	}
	
	/**
	 * Column Info
	 * @return pfEtdDt
	 */
	public String getPfEtdDt() {
		return this.pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return initEtbDt
	 */
	public String getInitEtbDt() {
		return this.initEtbDt;
	}
	
	/**
	 * Column Info
	 * @return pfEtaDt
	 */
	public String getPfEtaDt() {
		return this.pfEtaDt;
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
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @return initEtdDt
	 */
	public String getInitEtdDt() {
		return this.initEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirSeq
	 */
	public String getVslSlanDirSeq() {
		return this.vslSlanDirSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return turnClptIndSeq
	 */
	public String getTurnClptIndSeq() {
		return this.turnClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm(){
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return incDelVsl
	 */
	public String getIncDelVsl(){
		return this.incDelVsl;
	}
	
	/**
	 * Column Info
	 * @return unitTp
	 */
	public String getUnitTp(){
		return this.unitTp;
	}
	
	/**
	 * Column Info
	 * @return actCrrCd
	 */
	public String getActCrrCd(){
		return this.actCrrCd;
	}	
	
	/**
	 * Column Info
	 * @return phsIoRsnCd
	 */
	public String getPhsIoRsnCd(){
		return this.phsIoRsnCd;
	}

	/**
	 * Column Info
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	 * @param vpsRmk
	 */
	public void setVpsRmk(String vpsRmk) {
		this.vpsRmk = vpsRmk;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param turnPortFlg
	 */
	public void setTurnPortFlg(String turnPortFlg) {
		this.turnPortFlg = turnPortFlg;
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
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Column Info
	 * @param turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
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
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param portSkdStsCd
	 */
	public void setPortSkdStsCd(String portSkdStsCd) {
		this.portSkdStsCd = portSkdStsCd;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param initEtaDt
	 */
	public void setInitEtaDt(String initEtaDt) {
		this.initEtaDt = initEtaDt;
	}
	
	/**
	 * Column Info
	 * @param pfEtdDt
	 */
	public void setPfEtdDt(String pfEtdDt) {
		this.pfEtdDt = pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param initEtbDt
	 */
	public void setInitEtbDt(String initEtbDt) {
		this.initEtbDt = initEtbDt;
	}
	
	/**
	 * Column Info
	 * @param pfEtaDt
	 */
	public void setPfEtaDt(String pfEtaDt) {
		this.pfEtaDt = pfEtaDt;
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
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
	}
	
	/**
	 * Column Info
	 * @param initEtdDt
	 */
	public void setInitEtdDt(String initEtdDt) {
		this.initEtdDt = initEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirSeq
	 */
	public void setVslSlanDirSeq(String vslSlanDirSeq) {
		this.vslSlanDirSeq = vslSlanDirSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param turnClptIndSeq
	 */
	public void setTurnClptIndSeq(String turnClptIndSeq) {
		this.turnClptIndSeq = turnClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd){
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm){
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param incDelVsl
	 */
	public void setIncDelVsl(String incDelVsl){
		this.incDelVsl = incDelVsl;
	}
	
	/**
	 * Column Info
	 * @param unitTp
	 */
	public void setUnitTp(String unitTp){
		this.unitTp = unitTp;
	}
	
	/**
	 * Column Info
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd){
		this.actCrrCd = actCrrCd;
	}	
	
	/**
	 * Column Info
	 * @param phsIoRsnCd
	 */
	public void setPhsIoRsnCd(String phsIoRsnCd){
		this.phsIoRsnCd = phsIoRsnCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStartDate(JSPUtil.getParameter(request, "start_date", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsRmk(JSPUtil.getParameter(request, "vps_rmk", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, "pf_skd_tp_cd", ""));
		setEndDate(JSPUtil.getParameter(request, "end_date", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, "turn_skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, "turn_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPortSkdStsCd(JSPUtil.getParameter(request, "port_skd_sts_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, "call_yd_ind_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInitEtaDt(JSPUtil.getParameter(request, "init_eta_dt", ""));
		setPfEtdDt(JSPUtil.getParameter(request, "pf_etd_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setInitEtbDt(JSPUtil.getParameter(request, "init_etb_dt", ""));
		setPfEtaDt(JSPUtil.getParameter(request, "pf_eta_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPfEtbDt(JSPUtil.getParameter(request, "pf_etb_dt", ""));
		setInitEtdDt(JSPUtil.getParameter(request, "init_etd_dt", ""));
		setVslSlanDirSeq(JSPUtil.getParameter(request, "vsl_slan_dir_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, "skd_cng_sts_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setTurnClptIndSeq(JSPUtil.getParameter(request, "turn_clpt_ind_seq", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setPortNm(JSPUtil.getParameter(request, "port_nm", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setIncDelVsl(JSPUtil.getParameter(request, "inc_del_vsl", ""));
		setUnitTp(JSPUtil.getParameter(request, "unit_tp", ""));
		setActCrrCd(JSPUtil.getParameter(request, "act_crr_cd", ""));
		setPhsIoRsnCd(JSPUtil.getParameter(request, "phs_io_rsn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortSkdOnLongRangeVO[]
	 */
	public PortSkdOnLongRangeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortSkdOnLongRangeVO[]
	 */
	public PortSkdOnLongRangeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortSkdOnLongRangeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] startDate = (JSPUtil.getParameter(request, prefix	+ "start_date", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsRmk = (JSPUtil.getParameter(request, prefix	+ "vps_rmk", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] endDate = (JSPUtil.getParameter(request, prefix	+ "end_date", length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] initEtbDt = (JSPUtil.getParameter(request, prefix	+ "init_etb_dt", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] initEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt", length));
			String[] vslSlanDirSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq", length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] incDelVsl = (JSPUtil.getParameter(request, prefix	+ "inc_del_vsl", length));
			String[] unitTp = (JSPUtil.getParameter(request, prefix	+ "unit_tp", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix	+ "phs_io_rsn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortSkdOnLongRangeVO();
				if (startDate[i] != null)
					model.setStartDate(startDate[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsRmk[i] != null)
					model.setVpsRmk(vpsRmk[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (endDate[i] != null)
					model.setEndDate(endDate[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (portSkdStsCd[i] != null)
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (initEtaDt[i] != null)
					model.setInitEtaDt(initEtaDt[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (initEtbDt[i] != null)
					model.setInitEtbDt(initEtbDt[i]);
				if (pfEtaDt[i] != null)
					model.setPfEtaDt(pfEtaDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (initEtdDt[i] != null)
					model.setInitEtdDt(initEtdDt[i]);
				if (vslSlanDirSeq[i] != null)
					model.setVslSlanDirSeq(vslSlanDirSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (incDelVsl[i] != null)
					model.setIncDelVsl(incDelVsl[i]);
				if (unitTp[i] != null)
					model.setUnitTp(unitTp[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);				
				if (phsIoRsnCd[i] != null)
					model.setPhsIoRsnCd(phsIoRsnCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortSkdOnLongRangeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortSkdOnLongRangeVO[]
	 */
	public PortSkdOnLongRangeVO[] getPortSkdOnLongRangeVOs(){
		PortSkdOnLongRangeVO[] vos = (PortSkdOnLongRangeVO[])models.toArray(new PortSkdOnLongRangeVO[models.size()]);
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
		this.startDate = this.startDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsRmk = this.vpsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDate = this.endDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDt = this.initEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDt = this.initEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirSeq = this.vslSlanDirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incDelVsl = this.incDelVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitTp = this.unitTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRsnCd = this.phsIoRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	public boolean isSamePort(PortSkdOnLongRangeVO other){
		if(
			this.vslSlanCd.equals(other.vslSlanCd) &&
			this.pfSkdTpCd.equals(other.pfSkdTpCd) &&
			this.skdDirCd.equals(other.skdDirCd) &&
			this.vpsPortCd.equals(other.vpsPortCd) &&
			this.ydCd.equals(other.ydCd) &&
			this.clptIndSeq.equals(other.clptIndSeq)
		){
			return true;
		}else{
			return false;
		}
	}

	public PfSkdDetailVO getPfSkdDetailVO() {
		return pfSkdDetailVO;
	}

	public void setPfSkdDetailVO(PfSkdDetailVO pfSkdDetailVO) {
		this.pfSkdDetailVO = pfSkdDetailVO;
	}

	public boolean isEmptySkd() {
		return emptySkd;
	}

	public void setEmptySkd(boolean emptySkd) {
		this.emptySkd = emptySkd;
	}

	public boolean isAddingSkd() {
		return addingSkd;
	}

	public void setAddingSkd(boolean addingSkd) {
		this.addingSkd = addingSkd;
	}

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}
	
	
	
}
