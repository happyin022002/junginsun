/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimeKPIDetailVO.java
*@FileTitle : PortTimeKPIDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.07  
* 1.0 Creation
* 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
* 2012.07.06 문동선 [CHM-201218855-01] 쿼리 수행 대상 테이블 구분위해 tabChk 인자 추가  
=========================================================*/

package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortTimeKPIDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortTimeKPIDetailVO> models = new ArrayList<PortTimeKPIDetailVO>();
	
	/* Column Info */
	private String kpiVerSeq = null;
	/* Column Info */
	private String fmEffDtMd = null;
	/* Column Info */
	private String portKpiDirCd = null;
	/* Column Info */
	private String grsTmlProdHrs = null;
	/* Column Info */
	private String twnLftHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String toEffDtYy = null;
	/* Column Info */
	private String stmInHrs = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String clptIndSeqView = null;
	/* Column Info */
	private String grsCrnProdHrs = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rstwgHrs = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vslDepHrs = null;
	/* Column Info */
	private String portStayHrs = null;
	/* Column Info */
	private String netCrnProdHrs = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String stmOutHrs = null;
	/* Column Info */
	private String dulCycHrs = null;
	/* Column Info */
	private String toEffDtMd = null;
	/* Column Info */
	private String chkVal = null;
	/* Column Info */
	private String vslArrHrs = null;
	/* Column Info */
	private String kpiTgtYr = null;
	/* Column Info */
	private String tmlOpHrs = null;
	/* Column Info */
	private String fmEffDtYy = null;
	/* Column Info */
	private String ttlCntrMvKnt = null;
	/* Column Info */
	private String tabChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortTimeKPIDetailVO() {}

	public PortTimeKPIDetailVO(String ibflag, String pagerows, String kpiTgtYr, String slanCd, String vpsPortCd, String kpiVerSeq, String rhqCd, String fmEffDt, String toEffDt, String fmEffDtYy, String fmEffDtMd, String toEffDtYy, String toEffDtMd, String portKpiDirCd, String clptIndSeqView, String clptIndSeq, String ttlCntrMvKnt, String stmInHrs, String vslArrHrs, String tmlOpHrs, String vslDepHrs, String stmOutHrs, String portStayHrs, String grsTmlProdHrs, String grsCrnProdHrs, String netCrnProdHrs, String twnLftHrs, String dulCycHrs, String rstwgHrs, String creUsrId, String updUsrId, String chkVal, String tabChk) {
		this.kpiVerSeq = kpiVerSeq;
		this.fmEffDtMd = fmEffDtMd;
		this.portKpiDirCd = portKpiDirCd;
		this.grsTmlProdHrs = grsTmlProdHrs;
		this.twnLftHrs = twnLftHrs;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.fmEffDt = fmEffDt;
		this.updUsrId = updUsrId;
		this.toEffDtYy = toEffDtYy;
		this.stmInHrs = stmInHrs;
		this.rhqCd = rhqCd;
		this.toEffDt = toEffDt;
		this.clptIndSeqView = clptIndSeqView;
		this.grsCrnProdHrs = grsCrnProdHrs;
		this.creUsrId = creUsrId;
		this.rstwgHrs = rstwgHrs;
		this.slanCd = slanCd;
		this.vslDepHrs = vslDepHrs;
		this.portStayHrs = portStayHrs;
		this.netCrnProdHrs = netCrnProdHrs;
		this.clptIndSeq = clptIndSeq;
		this.stmOutHrs = stmOutHrs;
		this.dulCycHrs = dulCycHrs;
		this.toEffDtMd = toEffDtMd;
		this.chkVal = chkVal;
		this.vslArrHrs = vslArrHrs;
		this.kpiTgtYr = kpiTgtYr;
		this.tmlOpHrs = tmlOpHrs;
		this.fmEffDtYy = fmEffDtYy;
		this.ttlCntrMvKnt = ttlCntrMvKnt;
		this.tabChk = tabChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kpi_ver_seq", getKpiVerSeq());
		this.hashColumns.put("fm_eff_dt_md", getFmEffDtMd());
		this.hashColumns.put("port_kpi_dir_cd", getPortKpiDirCd());
		this.hashColumns.put("grs_tml_prod_hrs", getGrsTmlProdHrs());
		this.hashColumns.put("twn_lft_hrs", getTwnLftHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("to_eff_dt_yy", getToEffDtYy());
		this.hashColumns.put("stm_in_hrs", getStmInHrs());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("clpt_ind_seq_view", getClptIndSeqView());
		this.hashColumns.put("grs_crn_prod_hrs", getGrsCrnProdHrs());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rstwg_hrs", getRstwgHrs());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_dep_hrs", getVslDepHrs());
		this.hashColumns.put("port_stay_hrs", getPortStayHrs());
		this.hashColumns.put("net_crn_prod_hrs", getNetCrnProdHrs());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("stm_out_hrs", getStmOutHrs());
		this.hashColumns.put("dul_cyc_hrs", getDulCycHrs());
		this.hashColumns.put("to_eff_dt_md", getToEffDtMd());
		this.hashColumns.put("chk_val", getChkVal());
		this.hashColumns.put("vsl_arr_hrs", getVslArrHrs());
		this.hashColumns.put("kpi_tgt_yr", getKpiTgtYr());
		this.hashColumns.put("tml_op_hrs", getTmlOpHrs());
		this.hashColumns.put("fm_eff_dt_yy", getFmEffDtYy());
		this.hashColumns.put("ttl_cntr_mv_knt", getTtlCntrMvKnt());
		this.hashColumns.put("tab_chk", getTabChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kpi_ver_seq", "kpiVerSeq");
		this.hashFields.put("fm_eff_dt_md", "fmEffDtMd");
		this.hashFields.put("port_kpi_dir_cd", "portKpiDirCd");
		this.hashFields.put("grs_tml_prod_hrs", "grsTmlProdHrs");
		this.hashFields.put("twn_lft_hrs", "twnLftHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("to_eff_dt_yy", "toEffDtYy");
		this.hashFields.put("stm_in_hrs", "stmInHrs");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("clpt_ind_seq_view", "clptIndSeqView");
		this.hashFields.put("grs_crn_prod_hrs", "grsCrnProdHrs");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rstwg_hrs", "rstwgHrs");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_dep_hrs", "vslDepHrs");
		this.hashFields.put("port_stay_hrs", "portStayHrs");
		this.hashFields.put("net_crn_prod_hrs", "netCrnProdHrs");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("stm_out_hrs", "stmOutHrs");
		this.hashFields.put("dul_cyc_hrs", "dulCycHrs");
		this.hashFields.put("to_eff_dt_md", "toEffDtMd");
		this.hashFields.put("chk_val", "chkVal");
		this.hashFields.put("vsl_arr_hrs", "vslArrHrs");
		this.hashFields.put("kpi_tgt_yr", "kpiTgtYr");
		this.hashFields.put("tml_op_hrs", "tmlOpHrs");
		this.hashFields.put("fm_eff_dt_yy", "fmEffDtYy");
		this.hashFields.put("ttl_cntr_mv_knt", "ttlCntrMvKnt");
		this.hashFields.put("tab_chk", "tabChk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return kpiVerSeq
	 */
	public String getKpiVerSeq() {
		return this.kpiVerSeq;
	}
	
	/**
	 * Column Info
	 * @return fmEffDtMd
	 */
	public String getFmEffDtMd() {
		return this.fmEffDtMd;
	}
	
	/**
	 * Column Info
	 * @return portKpiDirCd
	 */
	public String getPortKpiDirCd() {
		return this.portKpiDirCd;
	}
	
	/**
	 * Column Info
	 * @return grsTmlProdHrs
	 */
	public String getGrsTmlProdHrs() {
		return this.grsTmlProdHrs;
	}
	
	/**
	 * Column Info
	 * @return twnLftHrs
	 */
	public String getTwnLftHrs() {
		return this.twnLftHrs;
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
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
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
	 * @return toEffDtYy
	 */
	public String getToEffDtYy() {
		return this.toEffDtYy;
	}
	
	/**
	 * Column Info
	 * @return stmInHrs
	 */
	public String getStmInHrs() {
		return this.stmInHrs;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeqView
	 */
	public String getClptIndSeqView() {
		return this.clptIndSeqView;
	}
	
	/**
	 * Column Info
	 * @return grsCrnProdHrs
	 */
	public String getGrsCrnProdHrs() {
		return this.grsCrnProdHrs;
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
	 * @return rstwgHrs
	 */
	public String getRstwgHrs() {
		return this.rstwgHrs;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return vslDepHrs
	 */
	public String getVslDepHrs() {
		return this.vslDepHrs;
	}
	
	/**
	 * Column Info
	 * @return portStayHrs
	 */
	public String getPortStayHrs() {
		return this.portStayHrs;
	}
	
	/**
	 * Column Info
	 * @return netCrnProdHrs
	 */
	public String getNetCrnProdHrs() {
		return this.netCrnProdHrs;
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
	 * @return stmOutHrs
	 */
	public String getStmOutHrs() {
		return this.stmOutHrs;
	}
	
	/**
	 * Column Info
	 * @return dulCycHrs
	 */
	public String getDulCycHrs() {
		return this.dulCycHrs;
	}
	
	/**
	 * Column Info
	 * @return toEffDtMd
	 */
	public String getToEffDtMd() {
		return this.toEffDtMd;
	}
	
	/**
	 * Column Info
	 * @return chkVal
	 */
	public String getChkVal() {
		return this.chkVal;
	}
	
	/**
	 * Column Info
	 * @return vslArrHrs
	 */
	public String getVslArrHrs() {
		return this.vslArrHrs;
	}
	
	/**
	 * Column Info
	 * @return kpiTgtYr
	 */
	public String getKpiTgtYr() {
		return this.kpiTgtYr;
	}
	
	/**
	 * Column Info
	 * @return tmlOpHrs
	 */
	public String getTmlOpHrs() {
		return this.tmlOpHrs;
	}
	
	/**
	 * Column Info
	 * @return fmEffDtYy
	 */
	public String getFmEffDtYy() {
		return this.fmEffDtYy;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrMvKnt
	 */
	public String getTtlCntrMvKnt() {
		return this.ttlCntrMvKnt;
	}
	
	/**
	 * Column Info
	 * @return tabChk
	 */
	public String getTabChk() {
		return this.tabChk;
	}
	

	/**
	 * Column Info
	 * @param kpiVerSeq
	 */
	public void setKpiVerSeq(String kpiVerSeq) {
		this.kpiVerSeq = kpiVerSeq;
	}
	
	/**
	 * Column Info
	 * @param fmEffDtMd
	 */
	public void setFmEffDtMd(String fmEffDtMd) {
		this.fmEffDtMd = fmEffDtMd;
	}
	
	/**
	 * Column Info
	 * @param portKpiDirCd
	 */
	public void setPortKpiDirCd(String portKpiDirCd) {
		this.portKpiDirCd = portKpiDirCd;
	}
	
	/**
	 * Column Info
	 * @param grsTmlProdHrs
	 */
	public void setGrsTmlProdHrs(String grsTmlProdHrs) {
		this.grsTmlProdHrs = grsTmlProdHrs;
	}
	
	/**
	 * Column Info
	 * @param twnLftHrs
	 */
	public void setTwnLftHrs(String twnLftHrs) {
		this.twnLftHrs = twnLftHrs;
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
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
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
	 * @param toEffDtYy
	 */
	public void setToEffDtYy(String toEffDtYy) {
		this.toEffDtYy = toEffDtYy;
	}
	
	/**
	 * Column Info
	 * @param stmInHrs
	 */
	public void setStmInHrs(String stmInHrs) {
		this.stmInHrs = stmInHrs;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeqView
	 */
	public void setClptIndSeqView(String clptIndSeqView) {
		this.clptIndSeqView = clptIndSeqView;
	}
	
	/**
	 * Column Info
	 * @param grsCrnProdHrs
	 */
	public void setGrsCrnProdHrs(String grsCrnProdHrs) {
		this.grsCrnProdHrs = grsCrnProdHrs;
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
	 * @param rstwgHrs
	 */
	public void setRstwgHrs(String rstwgHrs) {
		this.rstwgHrs = rstwgHrs;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param vslDepHrs
	 */
	public void setVslDepHrs(String vslDepHrs) {
		this.vslDepHrs = vslDepHrs;
	}
	
	/**
	 * Column Info
	 * @param portStayHrs
	 */
	public void setPortStayHrs(String portStayHrs) {
		this.portStayHrs = portStayHrs;
	}
	
	/**
	 * Column Info
	 * @param netCrnProdHrs
	 */
	public void setNetCrnProdHrs(String netCrnProdHrs) {
		this.netCrnProdHrs = netCrnProdHrs;
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
	 * @param stmOutHrs
	 */
	public void setStmOutHrs(String stmOutHrs) {
		this.stmOutHrs = stmOutHrs;
	}
	
	/**
	 * Column Info
	 * @param dulCycHrs
	 */
	public void setDulCycHrs(String dulCycHrs) {
		this.dulCycHrs = dulCycHrs;
	}
	
	/**
	 * Column Info
	 * @param toEffDtMd
	 */
	public void setToEffDtMd(String toEffDtMd) {
		this.toEffDtMd = toEffDtMd;
	}
	
	/**
	 * Column Info
	 * @param chkVal
	 */
	public void setChkVal(String chkVal) {
		this.chkVal = chkVal;
	}
	
	/**
	 * Column Info
	 * @param vslArrHrs
	 */
	public void setVslArrHrs(String vslArrHrs) {
		this.vslArrHrs = vslArrHrs;
	}
	
	/**
	 * Column Info
	 * @param kpiTgtYr
	 */
	public void setKpiTgtYr(String kpiTgtYr) {
		this.kpiTgtYr = kpiTgtYr;
	}
	
	/**
	 * Column Info
	 * @param tmlOpHrs
	 */
	public void setTmlOpHrs(String tmlOpHrs) {
		this.tmlOpHrs = tmlOpHrs;
	}
	
	/**
	 * Column Info
	 * @param fmEffDtYy
	 */
	public void setFmEffDtYy(String fmEffDtYy) {
		this.fmEffDtYy = fmEffDtYy;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrMvKnt
	 */
	public void setTtlCntrMvKnt(String ttlCntrMvKnt) {
		this.ttlCntrMvKnt = ttlCntrMvKnt;
	}
	
	/**
	 * Column Info
	 * @param tabChk
	 */
	public void setTabChk(String tabChk) {
		this.tabChk = tabChk;
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
		setKpiVerSeq(JSPUtil.getParameter(request, prefix + "kpi_ver_seq", ""));
		setFmEffDtMd(JSPUtil.getParameter(request, prefix + "fm_eff_dt_md", ""));
		setPortKpiDirCd(JSPUtil.getParameter(request, prefix + "port_kpi_dir_cd", ""));
		setGrsTmlProdHrs(JSPUtil.getParameter(request, prefix + "grs_tml_prod_hrs", ""));
		setTwnLftHrs(JSPUtil.getParameter(request, prefix + "twn_lft_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setToEffDtYy(JSPUtil.getParameter(request, prefix + "to_eff_dt_yy", ""));
		setStmInHrs(JSPUtil.getParameter(request, prefix + "stm_in_hrs", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setClptIndSeqView(JSPUtil.getParameter(request, prefix + "clpt_ind_seq_view", ""));
		setGrsCrnProdHrs(JSPUtil.getParameter(request, prefix + "grs_crn_prod_hrs", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRstwgHrs(JSPUtil.getParameter(request, prefix + "rstwg_hrs", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVslDepHrs(JSPUtil.getParameter(request, prefix + "vsl_dep_hrs", ""));
		setPortStayHrs(JSPUtil.getParameter(request, prefix + "port_stay_hrs", ""));
		setNetCrnProdHrs(JSPUtil.getParameter(request, prefix + "net_crn_prod_hrs", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setStmOutHrs(JSPUtil.getParameter(request, prefix + "stm_out_hrs", ""));
		setDulCycHrs(JSPUtil.getParameter(request, prefix + "dul_cyc_hrs", ""));
		setToEffDtMd(JSPUtil.getParameter(request, prefix + "to_eff_dt_md", ""));
		setChkVal(JSPUtil.getParameter(request, prefix + "chk_val", ""));
		setVslArrHrs(JSPUtil.getParameter(request, prefix + "vsl_arr_hrs", ""));
		setKpiTgtYr(JSPUtil.getParameter(request, prefix + "kpi_tgt_yr", ""));
		setTmlOpHrs(JSPUtil.getParameter(request, prefix + "tml_op_hrs", ""));
		setFmEffDtYy(JSPUtil.getParameter(request, prefix + "fm_eff_dt_yy", ""));
		setTtlCntrMvKnt(JSPUtil.getParameter(request, prefix + "ttl_cntr_mv_knt", ""));
		setTabChk(JSPUtil.getParameter(request, prefix + "tab_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortTimeKPIDetailVO[]
	 */
	public PortTimeKPIDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortTimeKPIDetailVO[]
	 */
	public PortTimeKPIDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortTimeKPIDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] kpiVerSeq = (JSPUtil.getParameter(request, prefix	+ "kpi_ver_seq", length));
			String[] fmEffDtMd = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt_md", length));
			String[] portKpiDirCd = (JSPUtil.getParameter(request, prefix	+ "port_kpi_dir_cd", length));
			String[] grsTmlProdHrs = (JSPUtil.getParameter(request, prefix	+ "grs_tml_prod_hrs", length));
			String[] twnLftHrs = (JSPUtil.getParameter(request, prefix	+ "twn_lft_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] toEffDtYy = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt_yy", length));
			String[] stmInHrs = (JSPUtil.getParameter(request, prefix	+ "stm_in_hrs", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] clptIndSeqView = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq_view", length));
			String[] grsCrnProdHrs = (JSPUtil.getParameter(request, prefix	+ "grs_crn_prod_hrs", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rstwgHrs = (JSPUtil.getParameter(request, prefix	+ "rstwg_hrs", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vslDepHrs = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_hrs", length));
			String[] portStayHrs = (JSPUtil.getParameter(request, prefix	+ "port_stay_hrs", length));
			String[] netCrnProdHrs = (JSPUtil.getParameter(request, prefix	+ "net_crn_prod_hrs", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] stmOutHrs = (JSPUtil.getParameter(request, prefix	+ "stm_out_hrs", length));
			String[] dulCycHrs = (JSPUtil.getParameter(request, prefix	+ "dul_cyc_hrs", length));
			String[] toEffDtMd = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt_md", length));
			String[] chkVal = (JSPUtil.getParameter(request, prefix	+ "chk_val", length));
			String[] vslArrHrs = (JSPUtil.getParameter(request, prefix	+ "vsl_arr_hrs", length));
			String[] kpiTgtYr = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_yr", length));
			String[] tmlOpHrs = (JSPUtil.getParameter(request, prefix	+ "tml_op_hrs", length));
			String[] fmEffDtYy = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt_yy", length));
			String[] ttlCntrMvKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_mv_knt", length));
			String[] tabChk = (JSPUtil.getParameter(request, prefix	+ "tab_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortTimeKPIDetailVO();
				if (kpiVerSeq[i] != null)
					model.setKpiVerSeq(kpiVerSeq[i]);
				if (fmEffDtMd[i] != null)
					model.setFmEffDtMd(fmEffDtMd[i]);
				if (portKpiDirCd[i] != null)
					model.setPortKpiDirCd(portKpiDirCd[i]);
				if (grsTmlProdHrs[i] != null)
					model.setGrsTmlProdHrs(grsTmlProdHrs[i]);
				if (twnLftHrs[i] != null)
					model.setTwnLftHrs(twnLftHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (toEffDtYy[i] != null)
					model.setToEffDtYy(toEffDtYy[i]);
				if (stmInHrs[i] != null)
					model.setStmInHrs(stmInHrs[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (clptIndSeqView[i] != null)
					model.setClptIndSeqView(clptIndSeqView[i]);
				if (grsCrnProdHrs[i] != null)
					model.setGrsCrnProdHrs(grsCrnProdHrs[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rstwgHrs[i] != null)
					model.setRstwgHrs(rstwgHrs[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vslDepHrs[i] != null)
					model.setVslDepHrs(vslDepHrs[i]);
				if (portStayHrs[i] != null)
					model.setPortStayHrs(portStayHrs[i]);
				if (netCrnProdHrs[i] != null)
					model.setNetCrnProdHrs(netCrnProdHrs[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (stmOutHrs[i] != null)
					model.setStmOutHrs(stmOutHrs[i]);
				if (dulCycHrs[i] != null)
					model.setDulCycHrs(dulCycHrs[i]);
				if (toEffDtMd[i] != null)
					model.setToEffDtMd(toEffDtMd[i]);
				if (chkVal[i] != null)
					model.setChkVal(chkVal[i]);
				if (vslArrHrs[i] != null)
					model.setVslArrHrs(vslArrHrs[i]);
				if (kpiTgtYr[i] != null)
					model.setKpiTgtYr(kpiTgtYr[i]);
				if (tmlOpHrs[i] != null)
					model.setTmlOpHrs(tmlOpHrs[i]);
				if (fmEffDtYy[i] != null)
					model.setFmEffDtYy(fmEffDtYy[i]);
				if (ttlCntrMvKnt[i] != null)
					model.setTtlCntrMvKnt(ttlCntrMvKnt[i]);
				if (tabChk[i] != null)
					model.setTabChk(tabChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortTimeKPIDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortTimeKPIDetailVO[]
	 */
	public PortTimeKPIDetailVO[] getPortTimeKPIDetailVOs(){
		PortTimeKPIDetailVO[] vos = (PortTimeKPIDetailVO[])models.toArray(new PortTimeKPIDetailVO[models.size()]);
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
		this.kpiVerSeq = this.kpiVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDtMd = this.fmEffDtMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portKpiDirCd = this.portKpiDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsTmlProdHrs = this.grsTmlProdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnLftHrs = this.twnLftHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDtYy = this.toEffDtYy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmInHrs = this.stmInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeqView = this.clptIndSeqView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCrnProdHrs = this.grsCrnProdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstwgHrs = this.rstwgHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepHrs = this.vslDepHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portStayHrs = this.portStayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netCrnProdHrs = this.netCrnProdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmOutHrs = this.stmOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulCycHrs = this.dulCycHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDtMd = this.toEffDtMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVal = this.chkVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslArrHrs = this.vslArrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtYr = this.kpiTgtYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlOpHrs = this.tmlOpHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDtYy = this.fmEffDtYy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrMvKnt = this.ttlCntrMvKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabChk = this.tabChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
