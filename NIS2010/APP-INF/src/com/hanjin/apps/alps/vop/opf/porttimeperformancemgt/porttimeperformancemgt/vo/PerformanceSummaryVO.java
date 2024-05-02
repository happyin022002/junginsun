/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceSummaryVO.java
*@FileTitle : PerformanceSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.08.28 원종규 
* 1.0 Creation
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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PerformanceSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PerformanceSummaryVO> models = new ArrayList<PerformanceSummaryVO>();
	
	/* Column Info */
	private String etL4h = null;
	/* Column Info */
	private String grossCraneProd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etL20 = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String dualCycle = null;
	/* Column Info */
	private String stwDifHrsFlg = null;
	/* Column Info */
	private String fullL20 = null;
	/* Column Info */
	private String workCopleted = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String exceptPobFlg = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vvdCdGroup = null;
	/* Column Info */
	private String fullL4h = null;
	/* Column Info */
	private String workCommenced = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String etD40 = null;
	/* Column Info */
	private String etD45 = null;
	/* Column Info */
	private String departureTime = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String fullD20 = null;
	/* Column Info */
	private String fullD4h = null;
	/* Column Info */
	private String clptIndSeqView = null;
	/* Column Info */
	private String netCraneProd = null;
	/* Column Info */
	private String craneNo = null;
	/* Column Info */
	private String restow = null;
	/* Column Info */
	private String twinLift = null;
	/* Column Info */
	private String kpiAchive = null;
	/* Column Info */
	private String etD2h = null;
	/* Column Info */
	private String updateUser = null;
	/* Column Info */
	private String fullL2h = null;
	/* Column Info */
	private String etL2h = null;
	/* Column Info */
	private String operationTime = null;
	/* Column Info */
	private String fullL45 = null;
	/* Column Info */
	private String etL45 = null;
	/* Column Info */
	private String portKpiDirCd = null;
	/* Column Info */
	private String etL40 = null;
	/* Column Info */
	private String fullL40 = null;
	/* Column Info */
	private String updateSys = null;
	/* Column Info */
	private String portTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String steamInTime = null;
	/* Column Info */
	private String stwDifHrs = null;
	/* Column Info */
	private String ttlMvs2 = null;
	/* Column Info */
	private String grossTmlProd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String fullD45 = null;
	/* Column Info */
	private String ttlMvs = null;
	/* Column Info */
	private String fullD40 = null;
	/* Column Info */
	private String etD20 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String arrivalTime = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String fullD2h = null;
	/* Column Info */
	private String exceptCd = null;
	/* Column Info */
	private String etD4h = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PerformanceSummaryVO() {}

	public PerformanceSummaryVO(String ibflag, String pagerows, String grossCraneProd, String gubun, String operationTime, String dualCycle, String workCopleted, String portKpiDirCd, String vpsPortCd, String portTime, String steamInTime, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String vvdCd, String vvdCdGroup, String grossTmlProd, String workCommenced, String rhq, String departureTime, String ttlMvs, String ttlMvs2, String clptIndSeqView, String netCraneProd, String craneNo, String actDepDt, String arrivalTime, String slanCd, String restow, String clptIndSeq, String twinLift, String exceptCd, String exceptPobFlg, String kpiAchive, String updateSys, String fullD20, String fullD2h, String fullD40, String fullD4h, String fullD45, String etD20, String etD2h, String etD40, String etD4h, String etD45, String fullL20, String fullL2h, String fullL40, String fullL4h, String fullL45, String etL20, String etL2h, String etL40, String etL4h, String etL45, String updateUser, String stwDifHrsFlg, String stwDifHrs) {
		this.etL4h = etL4h;
		this.grossCraneProd = grossCraneProd;
		this.vslCd = vslCd;
		this.etL20 = etL20;
		this.gubun = gubun;
		this.dualCycle = dualCycle;
		this.stwDifHrsFlg = stwDifHrsFlg;
		this.fullL20 = fullL20;
		this.workCopleted = workCopleted;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.exceptPobFlg = exceptPobFlg;
		this.vvdCd = vvdCd;
		this.vvdCdGroup = vvdCdGroup;
		this.fullL4h = fullL4h;
		this.workCommenced = workCommenced;
		this.rhq = rhq;
		this.etD40 = etD40;
		this.etD45 = etD45;
		this.departureTime = departureTime;
		this.skdVoyNo = skdVoyNo;
		this.fullD20 = fullD20;
		this.fullD4h = fullD4h;
		this.clptIndSeqView = clptIndSeqView;
		this.netCraneProd = netCraneProd;
		this.craneNo = craneNo;
		this.restow = restow;
		this.twinLift = twinLift;
		this.kpiAchive = kpiAchive;
		this.etD2h = etD2h;
		this.updateUser = updateUser;
		this.fullL2h = fullL2h;
		this.etL2h = etL2h;
		this.operationTime = operationTime;
		this.fullL45 = fullL45;
		this.etL45 = etL45;
		this.portKpiDirCd = portKpiDirCd;
		this.etL40 = etL40;
		this.fullL40 = fullL40;
		this.updateSys = updateSys;
		this.portTime = portTime;
		this.ibflag = ibflag;
		this.steamInTime = steamInTime;
		this.stwDifHrs = stwDifHrs;
		this.ttlMvs2 = ttlMvs2;
		this.grossTmlProd = grossTmlProd;
		this.portCd = portCd;
		this.fullD45 = fullD45;
		this.ttlMvs = ttlMvs;
		this.fullD40 = fullD40;
		this.etD20 = etD20;
		this.skdDirCd = skdDirCd;
		this.actDepDt = actDepDt;
		this.arrivalTime = arrivalTime;
		this.slanCd = slanCd;
		this.clptIndSeq = clptIndSeq;
		this.fullD2h = fullD2h;
		this.exceptCd = exceptCd;
		this.etD4h = etD4h;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("et_l_4h", getEtL4h());
		this.hashColumns.put("gross_crane_prod", getGrossCraneProd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("et_l_20", getEtL20());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("dual_cycle", getDualCycle());
		this.hashColumns.put("stw_dif_hrs_flg", getStwDifHrsFlg());
		this.hashColumns.put("full_l_20", getFullL20());
		this.hashColumns.put("work_copleted", getWorkCopleted());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("except_pob_flg", getExceptPobFlg());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("vvd_cd_group", getVvdCdGroup());
		this.hashColumns.put("full_l_4h", getFullL4h());
		this.hashColumns.put("work_commenced", getWorkCommenced());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("et_d_40", getEtD40());
		this.hashColumns.put("et_d_45", getEtD45());
		this.hashColumns.put("departure_time", getDepartureTime());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("full_d_20", getFullD20());
		this.hashColumns.put("full_d_4h", getFullD4h());
		this.hashColumns.put("clpt_ind_seq_view", getClptIndSeqView());
		this.hashColumns.put("net_crane_prod", getNetCraneProd());
		this.hashColumns.put("crane_no", getCraneNo());
		this.hashColumns.put("restow", getRestow());
		this.hashColumns.put("twin_lift", getTwinLift());
		this.hashColumns.put("kpi_achive", getKpiAchive());
		this.hashColumns.put("et_d_2h", getEtD2h());
		this.hashColumns.put("update_user", getUpdateUser());
		this.hashColumns.put("full_l_2h", getFullL2h());
		this.hashColumns.put("et_l_2h", getEtL2h());
		this.hashColumns.put("operation_time", getOperationTime());
		this.hashColumns.put("full_l_45", getFullL45());
		this.hashColumns.put("et_l_45", getEtL45());
		this.hashColumns.put("port_kpi_dir_cd", getPortKpiDirCd());
		this.hashColumns.put("et_l_40", getEtL40());
		this.hashColumns.put("full_l_40", getFullL40());
		this.hashColumns.put("update_sys", getUpdateSys());
		this.hashColumns.put("port_time", getPortTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("steam_in_time", getSteamInTime());
		this.hashColumns.put("stw_dif_hrs", getStwDifHrs());
		this.hashColumns.put("ttl_mvs2", getTtlMvs2());
		this.hashColumns.put("gross_tml_prod", getGrossTmlProd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("full_d_45", getFullD45());
		this.hashColumns.put("ttl_mvs", getTtlMvs());
		this.hashColumns.put("full_d_40", getFullD40());
		this.hashColumns.put("et_d_20", getEtD20());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("arrival_time", getArrivalTime());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("full_d_2h", getFullD2h());
		this.hashColumns.put("except_cd", getExceptCd());
		this.hashColumns.put("et_d_4h", getEtD4h());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("et_l_4h", "etL4h");
		this.hashFields.put("gross_crane_prod", "grossCraneProd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("et_l_20", "etL20");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("dual_cycle", "dualCycle");
		this.hashFields.put("stw_dif_hrs_flg", "stwDifHrsFlg");
		this.hashFields.put("full_l_20", "fullL20");
		this.hashFields.put("work_copleted", "workCopleted");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("except_pob_flg", "exceptPobFlg");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("vvd_cd_group", "vvdCdGroup");
		this.hashFields.put("full_l_4h", "fullL4h");
		this.hashFields.put("work_commenced", "workCommenced");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("et_d_40", "etD40");
		this.hashFields.put("et_d_45", "etD45");
		this.hashFields.put("departure_time", "departureTime");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("full_d_20", "fullD20");
		this.hashFields.put("full_d_4h", "fullD4h");
		this.hashFields.put("clpt_ind_seq_view", "clptIndSeqView");
		this.hashFields.put("net_crane_prod", "netCraneProd");
		this.hashFields.put("crane_no", "craneNo");
		this.hashFields.put("restow", "restow");
		this.hashFields.put("twin_lift", "twinLift");
		this.hashFields.put("kpi_achive", "kpiAchive");
		this.hashFields.put("et_d_2h", "etD2h");
		this.hashFields.put("update_user", "updateUser");
		this.hashFields.put("full_l_2h", "fullL2h");
		this.hashFields.put("et_l_2h", "etL2h");
		this.hashFields.put("operation_time", "operationTime");
		this.hashFields.put("full_l_45", "fullL45");
		this.hashFields.put("et_l_45", "etL45");
		this.hashFields.put("port_kpi_dir_cd", "portKpiDirCd");
		this.hashFields.put("et_l_40", "etL40");
		this.hashFields.put("full_l_40", "fullL40");
		this.hashFields.put("update_sys", "updateSys");
		this.hashFields.put("port_time", "portTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("steam_in_time", "steamInTime");
		this.hashFields.put("stw_dif_hrs", "stwDifHrs");
		this.hashFields.put("ttl_mvs2", "ttlMvs2");
		this.hashFields.put("gross_tml_prod", "grossTmlProd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("full_d_45", "fullD45");
		this.hashFields.put("ttl_mvs", "ttlMvs");
		this.hashFields.put("full_d_40", "fullD40");
		this.hashFields.put("et_d_20", "etD20");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("arrival_time", "arrivalTime");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("full_d_2h", "fullD2h");
		this.hashFields.put("except_cd", "exceptCd");
		this.hashFields.put("et_d_4h", "etD4h");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etL4h
	 */
	public String getEtL4h() {
		return this.etL4h;
	}
	
	/**
	 * Column Info
	 * @return grossCraneProd
	 */
	public String getGrossCraneProd() {
		return this.grossCraneProd;
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
	 * @return etL20
	 */
	public String getEtL20() {
		return this.etL20;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return dualCycle
	 */
	public String getDualCycle() {
		return this.dualCycle;
	}
	
	/**
	 * Column Info
	 * @return stwDifHrsFlg
	 */
	public String getStwDifHrsFlg() {
		return this.stwDifHrsFlg;
	}
	
	/**
	 * Column Info
	 * @return fullL20
	 */
	public String getFullL20() {
		return this.fullL20;
	}
	
	/**
	 * Column Info
	 * @return workCopleted
	 */
	public String getWorkCopleted() {
		return this.workCopleted;
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
	 * Column Info
	 * @return exceptPobFlg
	 */
	public String getExceptPobFlg() {
		return this.exceptPobFlg;
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
	 * @return vvdCdGroup
	 */
	public String getVvdCdGroup() {
		return this.vvdCdGroup;
	}
	
	/**
	 * Column Info
	 * @return fullL4h
	 */
	public String getFullL4h() {
		return this.fullL4h;
	}
	
	/**
	 * Column Info
	 * @return workCommenced
	 */
	public String getWorkCommenced() {
		return this.workCommenced;
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
	 * @return etD40
	 */
	public String getEtD40() {
		return this.etD40;
	}
	
	/**
	 * Column Info
	 * @return etD45
	 */
	public String getEtD45() {
		return this.etD45;
	}
	
	/**
	 * Column Info
	 * @return departureTime
	 */
	public String getDepartureTime() {
		return this.departureTime;
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
	 * @return fullD20
	 */
	public String getFullD20() {
		return this.fullD20;
	}
	
	/**
	 * Column Info
	 * @return fullD4h
	 */
	public String getFullD4h() {
		return this.fullD4h;
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
	 * @return netCraneProd
	 */
	public String getNetCraneProd() {
		return this.netCraneProd;
	}
	
	/**
	 * Column Info
	 * @return craneNo
	 */
	public String getCraneNo() {
		return this.craneNo;
	}
	
	/**
	 * Column Info
	 * @return restow
	 */
	public String getRestow() {
		return this.restow;
	}
	
	/**
	 * Column Info
	 * @return twinLift
	 */
	public String getTwinLift() {
		return this.twinLift;
	}
	
	/**
	 * Column Info
	 * @return kpiAchive
	 */
	public String getKpiAchive() {
		return this.kpiAchive;
	}
	
	/**
	 * Column Info
	 * @return etD2h
	 */
	public String getEtD2h() {
		return this.etD2h;
	}
	
	/**
	 * Column Info
	 * @return updateUser
	 */
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * Column Info
	 * @return fullL2h
	 */
	public String getFullL2h() {
		return this.fullL2h;
	}
	
	/**
	 * Column Info
	 * @return etL2h
	 */
	public String getEtL2h() {
		return this.etL2h;
	}
	
	/**
	 * Column Info
	 * @return operationTime
	 */
	public String getOperationTime() {
		return this.operationTime;
	}
	
	/**
	 * Column Info
	 * @return fullL45
	 */
	public String getFullL45() {
		return this.fullL45;
	}
	
	/**
	 * Column Info
	 * @return etL45
	 */
	public String getEtL45() {
		return this.etL45;
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
	 * @return etL40
	 */
	public String getEtL40() {
		return this.etL40;
	}
	
	/**
	 * Column Info
	 * @return fullL40
	 */
	public String getFullL40() {
		return this.fullL40;
	}
	
	/**
	 * Column Info
	 * @return updateSys
	 */
	public String getUpdateSys() {
		return this.updateSys;
	}
	
	/**
	 * Column Info
	 * @return portTime
	 */
	public String getPortTime() {
		return this.portTime;
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
	 * @return steamInTime
	 */
	public String getSteamInTime() {
		return this.steamInTime;
	}
	
	/**
	 * Column Info
	 * @return stwDifHrs
	 */
	public String getStwDifHrs() {
		return this.stwDifHrs;
	}
	
	/**
	 * Column Info
	 * @return ttlMvs2
	 */
	public String getTtlMvs2() {
		return this.ttlMvs2;
	}
	
	/**
	 * Column Info
	 * @return grossTmlProd
	 */
	public String getGrossTmlProd() {
		return this.grossTmlProd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return fullD45
	 */
	public String getFullD45() {
		return this.fullD45;
	}
	
	/**
	 * Column Info
	 * @return ttlMvs
	 */
	public String getTtlMvs() {
		return this.ttlMvs;
	}
	
	/**
	 * Column Info
	 * @return fullD40
	 */
	public String getFullD40() {
		return this.fullD40;
	}
	
	/**
	 * Column Info
	 * @return etD20
	 */
	public String getEtD20() {
		return this.etD20;
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
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	
	/**
	 * Column Info
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return this.arrivalTime;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return fullD2h
	 */
	public String getFullD2h() {
		return this.fullD2h;
	}
	
	/**
	 * Column Info
	 * @return exceptCd
	 */
	public String getExceptCd() {
		return this.exceptCd;
	}
	
	/**
	 * Column Info
	 * @return etD4h
	 */
	public String getEtD4h() {
		return this.etD4h;
	}
	

	/**
	 * Column Info
	 * @param etL4h
	 */
	public void setEtL4h(String etL4h) {
		this.etL4h = etL4h;
	}
	
	/**
	 * Column Info
	 * @param grossCraneProd
	 */
	public void setGrossCraneProd(String grossCraneProd) {
		this.grossCraneProd = grossCraneProd;
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
	 * @param etL20
	 */
	public void setEtL20(String etL20) {
		this.etL20 = etL20;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param dualCycle
	 */
	public void setDualCycle(String dualCycle) {
		this.dualCycle = dualCycle;
	}
	
	/**
	 * Column Info
	 * @param stwDifHrsFlg
	 */
	public void setStwDifHrsFlg(String stwDifHrsFlg) {
		this.stwDifHrsFlg = stwDifHrsFlg;
	}
	
	/**
	 * Column Info
	 * @param fullL20
	 */
	public void setFullL20(String fullL20) {
		this.fullL20 = fullL20;
	}
	
	/**
	 * Column Info
	 * @param workCopleted
	 */
	public void setWorkCopleted(String workCopleted) {
		this.workCopleted = workCopleted;
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
	 * Column Info
	 * @param exceptPobFlg
	 */
	public void setExceptPobFlg(String exceptPobFlg) {
		this.exceptPobFlg = exceptPobFlg;
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
	 * @param vvdCdGroup
	 */
	public void setVvdCdGroup(String vvdCdGroup) {
		this.vvdCdGroup = vvdCdGroup;
	}
	
	/**
	 * Column Info
	 * @param fullL4h
	 */
	public void setFullL4h(String fullL4h) {
		this.fullL4h = fullL4h;
	}
	
	/**
	 * Column Info
	 * @param workCommenced
	 */
	public void setWorkCommenced(String workCommenced) {
		this.workCommenced = workCommenced;
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
	 * @param etD40
	 */
	public void setEtD40(String etD40) {
		this.etD40 = etD40;
	}
	
	/**
	 * Column Info
	 * @param etD45
	 */
	public void setEtD45(String etD45) {
		this.etD45 = etD45;
	}
	
	/**
	 * Column Info
	 * @param departureTime
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
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
	 * @param fullD20
	 */
	public void setFullD20(String fullD20) {
		this.fullD20 = fullD20;
	}
	
	/**
	 * Column Info
	 * @param fullD4h
	 */
	public void setFullD4h(String fullD4h) {
		this.fullD4h = fullD4h;
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
	 * @param netCraneProd
	 */
	public void setNetCraneProd(String netCraneProd) {
		this.netCraneProd = netCraneProd;
	}
	
	/**
	 * Column Info
	 * @param craneNo
	 */
	public void setCraneNo(String craneNo) {
		this.craneNo = craneNo;
	}
	
	/**
	 * Column Info
	 * @param restow
	 */
	public void setRestow(String restow) {
		this.restow = restow;
	}
	
	/**
	 * Column Info
	 * @param twinLift
	 */
	public void setTwinLift(String twinLift) {
		this.twinLift = twinLift;
	}
	
	/**
	 * Column Info
	 * @param kpiAchive
	 */
	public void setKpiAchive(String kpiAchive) {
		this.kpiAchive = kpiAchive;
	}
	
	/**
	 * Column Info
	 * @param etD2h
	 */
	public void setEtD2h(String etD2h) {
		this.etD2h = etD2h;
	}
	
	/**
	 * Column Info
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
	 * Column Info
	 * @param fullL2h
	 */
	public void setFullL2h(String fullL2h) {
		this.fullL2h = fullL2h;
	}
	
	/**
	 * Column Info
	 * @param etL2h
	 */
	public void setEtL2h(String etL2h) {
		this.etL2h = etL2h;
	}
	
	/**
	 * Column Info
	 * @param operationTime
	 */
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	
	/**
	 * Column Info
	 * @param fullL45
	 */
	public void setFullL45(String fullL45) {
		this.fullL45 = fullL45;
	}
	
	/**
	 * Column Info
	 * @param etL45
	 */
	public void setEtL45(String etL45) {
		this.etL45 = etL45;
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
	 * @param etL40
	 */
	public void setEtL40(String etL40) {
		this.etL40 = etL40;
	}
	
	/**
	 * Column Info
	 * @param fullL40
	 */
	public void setFullL40(String fullL40) {
		this.fullL40 = fullL40;
	}
	
	/**
	 * Column Info
	 * @param updateSys
	 */
	public void setUpdateSys(String updateSys) {
		this.updateSys = updateSys;
	}
	
	/**
	 * Column Info
	 * @param portTime
	 */
	public void setPortTime(String portTime) {
		this.portTime = portTime;
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
	 * @param steamInTime
	 */
	public void setSteamInTime(String steamInTime) {
		this.steamInTime = steamInTime;
	}
	
	/**
	 * Column Info
	 * @param stwDifHrs
	 */
	public void setStwDifHrs(String stwDifHrs) {
		this.stwDifHrs = stwDifHrs;
	}
	
	/**
	 * Column Info
	 * @param ttlMvs2
	 */
	public void setTtlMvs2(String ttlMvs2) {
		this.ttlMvs2 = ttlMvs2;
	}
	
	/**
	 * Column Info
	 * @param grossTmlProd
	 */
	public void setGrossTmlProd(String grossTmlProd) {
		this.grossTmlProd = grossTmlProd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param fullD45
	 */
	public void setFullD45(String fullD45) {
		this.fullD45 = fullD45;
	}
	
	/**
	 * Column Info
	 * @param ttlMvs
	 */
	public void setTtlMvs(String ttlMvs) {
		this.ttlMvs = ttlMvs;
	}
	
	/**
	 * Column Info
	 * @param fullD40
	 */
	public void setFullD40(String fullD40) {
		this.fullD40 = fullD40;
	}
	
	/**
	 * Column Info
	 * @param etD20
	 */
	public void setEtD20(String etD20) {
		this.etD20 = etD20;
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
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/**
	 * Column Info
	 * @param arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param fullD2h
	 */
	public void setFullD2h(String fullD2h) {
		this.fullD2h = fullD2h;
	}
	
	/**
	 * Column Info
	 * @param exceptCd
	 */
	public void setExceptCd(String exceptCd) {
		this.exceptCd = exceptCd;
	}
	
	/**
	 * Column Info
	 * @param etD4h
	 */
	public void setEtD4h(String etD4h) {
		this.etD4h = etD4h;
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
		setEtL4h(JSPUtil.getParameter(request, prefix + "et_l_4h", ""));
		setGrossCraneProd(JSPUtil.getParameter(request, prefix + "gross_crane_prod", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEtL20(JSPUtil.getParameter(request, prefix + "et_l_20", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setDualCycle(JSPUtil.getParameter(request, prefix + "dual_cycle", ""));
		setStwDifHrsFlg(JSPUtil.getParameter(request, prefix + "stw_dif_hrs_flg", ""));
		setFullL20(JSPUtil.getParameter(request, prefix + "full_l_20", ""));
		setWorkCopleted(JSPUtil.getParameter(request, prefix + "work_copleted", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setExceptPobFlg(JSPUtil.getParameter(request, prefix + "except_pob_flg", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setVvdCdGroup(JSPUtil.getParameter(request, prefix + "vvd_cd_group", ""));
		setFullL4h(JSPUtil.getParameter(request, prefix + "full_l_4h", ""));
		setWorkCommenced(JSPUtil.getParameter(request, prefix + "work_commenced", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setEtD40(JSPUtil.getParameter(request, prefix + "et_d_40", ""));
		setEtD45(JSPUtil.getParameter(request, prefix + "et_d_45", ""));
		setDepartureTime(JSPUtil.getParameter(request, prefix + "departure_time", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setFullD20(JSPUtil.getParameter(request, prefix + "full_d_20", ""));
		setFullD4h(JSPUtil.getParameter(request, prefix + "full_d_4h", ""));
		setClptIndSeqView(JSPUtil.getParameter(request, prefix + "clpt_ind_seq_view", ""));
		setNetCraneProd(JSPUtil.getParameter(request, prefix + "net_crane_prod", ""));
		setCraneNo(JSPUtil.getParameter(request, prefix + "crane_no", ""));
		setRestow(JSPUtil.getParameter(request, prefix + "restow", ""));
		setTwinLift(JSPUtil.getParameter(request, prefix + "twin_lift", ""));
		setKpiAchive(JSPUtil.getParameter(request, prefix + "kpi_achive", ""));
		setEtD2h(JSPUtil.getParameter(request, prefix + "et_d_2h", ""));
		setUpdateUser(JSPUtil.getParameter(request, prefix + "update_user", ""));
		setFullL2h(JSPUtil.getParameter(request, prefix + "full_l_2h", ""));
		setEtL2h(JSPUtil.getParameter(request, prefix + "et_l_2h", ""));
		setOperationTime(JSPUtil.getParameter(request, prefix + "operation_time", ""));
		setFullL45(JSPUtil.getParameter(request, prefix + "full_l_45", ""));
		setEtL45(JSPUtil.getParameter(request, prefix + "et_l_45", ""));
		setPortKpiDirCd(JSPUtil.getParameter(request, prefix + "port_kpi_dir_cd", ""));
		setEtL40(JSPUtil.getParameter(request, prefix + "et_l_40", ""));
		setFullL40(JSPUtil.getParameter(request, prefix + "full_l_40", ""));
		setUpdateSys(JSPUtil.getParameter(request, prefix + "update_sys", ""));
		setPortTime(JSPUtil.getParameter(request, prefix + "port_time", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSteamInTime(JSPUtil.getParameter(request, prefix + "steam_in_time", ""));
		setStwDifHrs(JSPUtil.getParameter(request, prefix + "stw_dif_hrs", ""));
		setTtlMvs2(JSPUtil.getParameter(request, prefix + "ttl_mvs2", ""));
		setGrossTmlProd(JSPUtil.getParameter(request, prefix + "gross_tml_prod", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setFullD45(JSPUtil.getParameter(request, prefix + "full_d_45", ""));
		setTtlMvs(JSPUtil.getParameter(request, prefix + "ttl_mvs", ""));
		setFullD40(JSPUtil.getParameter(request, prefix + "full_d_40", ""));
		setEtD20(JSPUtil.getParameter(request, prefix + "et_d_20", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
		setArrivalTime(JSPUtil.getParameter(request, prefix + "arrival_time", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setFullD2h(JSPUtil.getParameter(request, prefix + "full_d_2h", ""));
		setExceptCd(JSPUtil.getParameter(request, prefix + "except_cd", ""));
		setEtD4h(JSPUtil.getParameter(request, prefix + "et_d_4h", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PerformanceSummaryVO[]
	 */
	public PerformanceSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PerformanceSummaryVO[]
	 */
	public PerformanceSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PerformanceSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etL4h = (JSPUtil.getParameter(request, prefix	+ "et_l_4h", length));
			String[] grossCraneProd = (JSPUtil.getParameter(request, prefix	+ "gross_crane_prod", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etL20 = (JSPUtil.getParameter(request, prefix	+ "et_l_20", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] dualCycle = (JSPUtil.getParameter(request, prefix	+ "dual_cycle", length));
			String[] stwDifHrsFlg = (JSPUtil.getParameter(request, prefix	+ "stw_dif_hrs_flg", length));
			String[] fullL20 = (JSPUtil.getParameter(request, prefix	+ "full_l_20", length));
			String[] workCopleted = (JSPUtil.getParameter(request, prefix	+ "work_copleted", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] exceptPobFlg = (JSPUtil.getParameter(request, prefix	+ "except_pob_flg", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] vvdCdGroup = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_group", length));
			String[] fullL4h = (JSPUtil.getParameter(request, prefix	+ "full_l_4h", length));
			String[] workCommenced = (JSPUtil.getParameter(request, prefix	+ "work_commenced", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] etD40 = (JSPUtil.getParameter(request, prefix	+ "et_d_40", length));
			String[] etD45 = (JSPUtil.getParameter(request, prefix	+ "et_d_45", length));
			String[] departureTime = (JSPUtil.getParameter(request, prefix	+ "departure_time", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] fullD20 = (JSPUtil.getParameter(request, prefix	+ "full_d_20", length));
			String[] fullD4h = (JSPUtil.getParameter(request, prefix	+ "full_d_4h", length));
			String[] clptIndSeqView = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq_view", length));
			String[] netCraneProd = (JSPUtil.getParameter(request, prefix	+ "net_crane_prod", length));
			String[] craneNo = (JSPUtil.getParameter(request, prefix	+ "crane_no", length));
			String[] restow = (JSPUtil.getParameter(request, prefix	+ "restow", length));
			String[] twinLift = (JSPUtil.getParameter(request, prefix	+ "twin_lift", length));
			String[] kpiAchive = (JSPUtil.getParameter(request, prefix	+ "kpi_achive", length));
			String[] etD2h = (JSPUtil.getParameter(request, prefix	+ "et_d_2h", length));
			String[] updateUser = (JSPUtil.getParameter(request, prefix	+ "update_user", length));
			String[] fullL2h = (JSPUtil.getParameter(request, prefix	+ "full_l_2h", length));
			String[] etL2h = (JSPUtil.getParameter(request, prefix	+ "et_l_2h", length));
			String[] operationTime = (JSPUtil.getParameter(request, prefix	+ "operation_time", length));
			String[] fullL45 = (JSPUtil.getParameter(request, prefix	+ "full_l_45", length));
			String[] etL45 = (JSPUtil.getParameter(request, prefix	+ "et_l_45", length));
			String[] portKpiDirCd = (JSPUtil.getParameter(request, prefix	+ "port_kpi_dir_cd", length));
			String[] etL40 = (JSPUtil.getParameter(request, prefix	+ "et_l_40", length));
			String[] fullL40 = (JSPUtil.getParameter(request, prefix	+ "full_l_40", length));
			String[] updateSys = (JSPUtil.getParameter(request, prefix	+ "update_sys", length));
			String[] portTime = (JSPUtil.getParameter(request, prefix	+ "port_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] steamInTime = (JSPUtil.getParameter(request, prefix	+ "steam_in_time", length));
			String[] stwDifHrs = (JSPUtil.getParameter(request, prefix	+ "stw_dif_hrs", length));
			String[] ttlMvs2 = (JSPUtil.getParameter(request, prefix	+ "ttl_mvs2", length));
			String[] grossTmlProd = (JSPUtil.getParameter(request, prefix	+ "gross_tml_prod", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] fullD45 = (JSPUtil.getParameter(request, prefix	+ "full_d_45", length));
			String[] ttlMvs = (JSPUtil.getParameter(request, prefix	+ "ttl_mvs", length));
			String[] fullD40 = (JSPUtil.getParameter(request, prefix	+ "full_d_40", length));
			String[] etD20 = (JSPUtil.getParameter(request, prefix	+ "et_d_20", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] arrivalTime = (JSPUtil.getParameter(request, prefix	+ "arrival_time", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] fullD2h = (JSPUtil.getParameter(request, prefix	+ "full_d_2h", length));
			String[] exceptCd = (JSPUtil.getParameter(request, prefix	+ "except_cd", length));
			String[] etD4h = (JSPUtil.getParameter(request, prefix	+ "et_d_4h", length));
			
			for (int i = 0; i < length; i++) {
				model = new PerformanceSummaryVO();
				if (etL4h[i] != null)
					model.setEtL4h(etL4h[i]);
				if (grossCraneProd[i] != null)
					model.setGrossCraneProd(grossCraneProd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etL20[i] != null)
					model.setEtL20(etL20[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (dualCycle[i] != null)
					model.setDualCycle(dualCycle[i]);
				if (stwDifHrsFlg[i] != null)
					model.setStwDifHrsFlg(stwDifHrsFlg[i]);
				if (fullL20[i] != null)
					model.setFullL20(fullL20[i]);
				if (workCopleted[i] != null)
					model.setWorkCopleted(workCopleted[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (exceptPobFlg[i] != null)
					model.setExceptPobFlg(exceptPobFlg[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (vvdCdGroup[i] != null)
					model.setVvdCdGroup(vvdCdGroup[i]);
				if (fullL4h[i] != null)
					model.setFullL4h(fullL4h[i]);
				if (workCommenced[i] != null)
					model.setWorkCommenced(workCommenced[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (etD40[i] != null)
					model.setEtD40(etD40[i]);
				if (etD45[i] != null)
					model.setEtD45(etD45[i]);
				if (departureTime[i] != null)
					model.setDepartureTime(departureTime[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (fullD20[i] != null)
					model.setFullD20(fullD20[i]);
				if (fullD4h[i] != null)
					model.setFullD4h(fullD4h[i]);
				if (clptIndSeqView[i] != null)
					model.setClptIndSeqView(clptIndSeqView[i]);
				if (netCraneProd[i] != null)
					model.setNetCraneProd(netCraneProd[i]);
				if (craneNo[i] != null)
					model.setCraneNo(craneNo[i]);
				if (restow[i] != null)
					model.setRestow(restow[i]);
				if (twinLift[i] != null)
					model.setTwinLift(twinLift[i]);
				if (kpiAchive[i] != null)
					model.setKpiAchive(kpiAchive[i]);
				if (etD2h[i] != null)
					model.setEtD2h(etD2h[i]);
				if (updateUser[i] != null)
					model.setUpdateUser(updateUser[i]);
				if (fullL2h[i] != null)
					model.setFullL2h(fullL2h[i]);
				if (etL2h[i] != null)
					model.setEtL2h(etL2h[i]);
				if (operationTime[i] != null)
					model.setOperationTime(operationTime[i]);
				if (fullL45[i] != null)
					model.setFullL45(fullL45[i]);
				if (etL45[i] != null)
					model.setEtL45(etL45[i]);
				if (portKpiDirCd[i] != null)
					model.setPortKpiDirCd(portKpiDirCd[i]);
				if (etL40[i] != null)
					model.setEtL40(etL40[i]);
				if (fullL40[i] != null)
					model.setFullL40(fullL40[i]);
				if (updateSys[i] != null)
					model.setUpdateSys(updateSys[i]);
				if (portTime[i] != null)
					model.setPortTime(portTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (steamInTime[i] != null)
					model.setSteamInTime(steamInTime[i]);
				if (stwDifHrs[i] != null)
					model.setStwDifHrs(stwDifHrs[i]);
				if (ttlMvs2[i] != null)
					model.setTtlMvs2(ttlMvs2[i]);
				if (grossTmlProd[i] != null)
					model.setGrossTmlProd(grossTmlProd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (fullD45[i] != null)
					model.setFullD45(fullD45[i]);
				if (ttlMvs[i] != null)
					model.setTtlMvs(ttlMvs[i]);
				if (fullD40[i] != null)
					model.setFullD40(fullD40[i]);
				if (etD20[i] != null)
					model.setEtD20(etD20[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (arrivalTime[i] != null)
					model.setArrivalTime(arrivalTime[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (fullD2h[i] != null)
					model.setFullD2h(fullD2h[i]);
				if (exceptCd[i] != null)
					model.setExceptCd(exceptCd[i]);
				if (etD4h[i] != null)
					model.setEtD4h(etD4h[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPerformanceSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PerformanceSummaryVO[]
	 */
	public PerformanceSummaryVO[] getPerformanceSummaryVOs(){
		PerformanceSummaryVO[] vos = (PerformanceSummaryVO[])models.toArray(new PerformanceSummaryVO[models.size()]);
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
		this.etL4h = this.etL4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossCraneProd = this.grossCraneProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etL20 = this.etL20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dualCycle = this.dualCycle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwDifHrsFlg = this.stwDifHrsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullL20 = this.fullL20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workCopleted = this.workCopleted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceptPobFlg = this.exceptPobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdGroup = this.vvdCdGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullL4h = this.fullL4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workCommenced = this.workCommenced .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etD40 = this.etD40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etD45 = this.etD45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.departureTime = this.departureTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullD20 = this.fullD20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullD4h = this.fullD4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeqView = this.clptIndSeqView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netCraneProd = this.netCraneProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.craneNo = this.craneNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.restow = this.restow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twinLift = this.twinLift .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiAchive = this.kpiAchive .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etD2h = this.etD2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateUser = this.updateUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullL2h = this.fullL2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etL2h = this.etL2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operationTime = this.operationTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullL45 = this.fullL45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etL45 = this.etL45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portKpiDirCd = this.portKpiDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etL40 = this.etL40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullL40 = this.fullL40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateSys = this.updateSys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTime = this.portTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steamInTime = this.steamInTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwDifHrs = this.stwDifHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMvs2 = this.ttlMvs2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossTmlProd = this.grossTmlProd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullD45 = this.fullD45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMvs = this.ttlMvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullD40 = this.fullD40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etD20 = this.etD20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalTime = this.arrivalTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullD2h = this.fullD2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceptCd = this.exceptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etD4h = this.etD4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
