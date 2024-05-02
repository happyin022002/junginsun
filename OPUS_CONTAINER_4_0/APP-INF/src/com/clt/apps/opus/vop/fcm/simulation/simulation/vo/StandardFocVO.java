/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StandardFocVO.java
*@FileTitle : StandardFocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.18  
* 1.0 Creation
* 
* History
* 2014.08.22 [CHM-201431484] Previous 칼럼 말풍선 도움말 및 T actal 칼럼 로직 변경
=========================================================*/

package com.clt.apps.opus.vop.fcm.simulation.simulation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StandardFocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StandardFocVO> models = new ArrayList<StandardFocVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String opmzSeaTmHrs = null;
	/* Column Info */
	private String actFoilCsmCal = null;
	/* Column Info */
	private String sOpmzSeaTmHrs = null;
	/* Column Info */
	private String sOpmzSeaSpd = null;
	/* Column Info */
	private String depMnvrOutHrs = null;
	/* Column Info */
	private String actPortFoilCsmCal = null;
	/* Column Info */
	private String opmzDist = null;
	/* Column Info */
	private String actPortTime = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String pfMnvrInHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String sOpmzDist = null;
	/* Column Info */
	private String pfMnvrOutHrs = null;
	/* Column Info */
	private String trndLinePortFoilCsm = null;
	/* Column Info */
	private String sPfSeaTmHrs = null;
	/* Column Info */
	private String portSkdStsCd = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String distOpmz = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String opmzSeaSpd = null;
	/* Column Info */
	private String rvisFoilCsm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rvisPortFoilCsm = null;
	/* Column Info */
	private String opMinSpd = null;
	/* Column Info */
	private String depAvgSpd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String saveFlg = null;
	/* Column Info */
	private String distPfLnk = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String actFoilCsm = null;
	/* Column Info */
	private String initPortFoilCsm = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String depMnvrInHrs = null;
	/* Column Info */
	private String actFoilCsmAvg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String pfSeaTmHrs = null;
	/* Column Info */
	private String portTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sInitFoilCsm = null;
	/* Column Info */
	private String actPortFoilCsm = null;
	/* Column Info */
	private String sInitPortFoilCsm = null;
	/* Column Info */
	private String opGnrSpd = null;
	/* Column Info */
	private String actPortFoilCsmAvg = null;
	/* Column Info */
	private String actOpmzSeaTmHrs = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String spdPfLnk = null;
	/* Column Info */
	private String trndLineFoilCsm = null;
	/* Column Info */
	private String initFoilCsm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String mnvrCsmWgt = null;
	/* Column Info */
	private String initTactualSeaTmHrs = null;
	/* Column Info */
	private String nvgtMlDist = null;
	/* Column Info */
	private String initTactualPortTime = null;
	/* Column Info */
	private String oneAgoPrevious = null;
	/* Column Info */
	private String twoAgoPrevious = null;
	/* Column Info */
	private String threeAgoPrevious = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StandardFocVO() {}

	public StandardFocVO(String ibflag, String pagerows, String vvdSeq, String clptIndSeq, String clptSeq, String vslSlanCd, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String vpsPortCd, String tmlCd, String ydCd, String portSkdStsCd, String skdCngStsCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String initFoilCsm, String rvisFoilCsm, String trndLineFoilCsm, String actFoilCsm, String initPortFoilCsm, String rvisPortFoilCsm, String trndLinePortFoilCsm, String actPortFoilCsm, String opmzDist, String opmzSeaSpd, String pfSeaTmHrs, String opmzSeaTmHrs, String actOpmzSeaTmHrs, String distPfLnk, String distOpmz, String spdPfLnk, String actFoilCsmCal, String actPortFoilCsmCal, String actFoilCsmAvg, String actPortFoilCsmAvg, String sInitFoilCsm, String sInitPortFoilCsm, String sOpmzDist, String sOpmzSeaSpd, String sPfSeaTmHrs, String sOpmzSeaTmHrs, String depAvgSpd, String saveFlg, String portTime, String actPortTime, String mnvrCsmWgt, String opMinSpd, String opGnrSpd, String pfMnvrInHrs, String pfMnvrOutHrs, String depMnvrInHrs, String depMnvrOutHrs, String initTactualSeaTmHrs, String nvgtMlDist, String initTactualPortTime, String oneAgoPrevious, String twoAgoPrevious, String threeAgoPrevious) {
		this.vslCd = vslCd;
		this.opmzSeaTmHrs = opmzSeaTmHrs;
		this.actFoilCsmCal = actFoilCsmCal;
		this.sOpmzSeaTmHrs = sOpmzSeaTmHrs;
		this.sOpmzSeaSpd = sOpmzSeaSpd;
		this.depMnvrOutHrs = depMnvrOutHrs;
		this.actPortFoilCsmCal = actPortFoilCsmCal;
		this.opmzDist = opmzDist;
		this.actPortTime = actPortTime;
		this.tmlCd = tmlCd;
		this.pfMnvrInHrs = pfMnvrInHrs;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.sOpmzDist = sOpmzDist;
		this.pfMnvrOutHrs = pfMnvrOutHrs;
		this.trndLinePortFoilCsm = trndLinePortFoilCsm;
		this.sPfSeaTmHrs = sPfSeaTmHrs;
		this.portSkdStsCd = portSkdStsCd;
		this.vvdSeq = vvdSeq;
		this.distOpmz = distOpmz;
		this.vpsEtdDt = vpsEtdDt;
		this.opmzSeaSpd = opmzSeaSpd;
		this.rvisFoilCsm = rvisFoilCsm;
		this.skdVoyNo = skdVoyNo;
		this.rvisPortFoilCsm = rvisPortFoilCsm;
		this.opMinSpd = opMinSpd;
		this.depAvgSpd = depAvgSpd;
		this.vvd = vvd;
		this.saveFlg = saveFlg;
		this.distPfLnk = distPfLnk;
		this.skdCngStsCd = skdCngStsCd;
		this.actFoilCsm = actFoilCsm;
		this.initPortFoilCsm = initPortFoilCsm;
		this.vpsEtbDt = vpsEtbDt;
		this.depMnvrInHrs = depMnvrInHrs;
		this.actFoilCsmAvg = actFoilCsmAvg;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.pfSeaTmHrs = pfSeaTmHrs;
		this.portTime = portTime;
		this.ibflag = ibflag;
		this.sInitFoilCsm = sInitFoilCsm;
		this.actPortFoilCsm = actPortFoilCsm;
		this.sInitPortFoilCsm = sInitPortFoilCsm;
		this.opGnrSpd = opGnrSpd;
		this.actPortFoilCsmAvg = actPortFoilCsmAvg;
		this.actOpmzSeaTmHrs = actOpmzSeaTmHrs;
		this.skdDirCd = skdDirCd;
		this.spdPfLnk = spdPfLnk;
		this.trndLineFoilCsm = trndLineFoilCsm;
		this.initFoilCsm = initFoilCsm;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.mnvrCsmWgt = mnvrCsmWgt;
		this.initTactualSeaTmHrs = initTactualSeaTmHrs;
		this.nvgtMlDist = nvgtMlDist;
		this.initTactualPortTime = initTactualPortTime;
		this.oneAgoPrevious = oneAgoPrevious;
		this.twoAgoPrevious = twoAgoPrevious;
		this.threeAgoPrevious = threeAgoPrevious;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("opmz_sea_tm_hrs", getOpmzSeaTmHrs());
		this.hashColumns.put("act_foil_csm_cal", getActFoilCsmCal());
		this.hashColumns.put("s_opmz_sea_tm_hrs", getSOpmzSeaTmHrs());
		this.hashColumns.put("s_opmz_sea_spd", getSOpmzSeaSpd());
		this.hashColumns.put("dep_mnvr_out_hrs", getDepMnvrOutHrs());
		this.hashColumns.put("act_port_foil_csm_cal", getActPortFoilCsmCal());
		this.hashColumns.put("opmz_dist", getOpmzDist());
		this.hashColumns.put("act_port_time", getActPortTime());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("pf_mnvr_in_hrs", getPfMnvrInHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("s_opmz_dist", getSOpmzDist());
		this.hashColumns.put("pf_mnvr_out_hrs", getPfMnvrOutHrs());
		this.hashColumns.put("trnd_line_port_foil_csm", getTrndLinePortFoilCsm());
		this.hashColumns.put("s_pf_sea_tm_hrs", getSPfSeaTmHrs());
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("dist_opmz", getDistOpmz());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("opmz_sea_spd", getOpmzSeaSpd());
		this.hashColumns.put("rvis_foil_csm", getRvisFoilCsm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rvis_port_foil_csm", getRvisPortFoilCsm());
		this.hashColumns.put("op_min_spd", getOpMinSpd());
		this.hashColumns.put("dep_avg_spd", getDepAvgSpd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("save_flg", getSaveFlg());
		this.hashColumns.put("dist_pf_lnk", getDistPfLnk());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("act_foil_csm", getActFoilCsm());
		this.hashColumns.put("init_port_foil_csm", getInitPortFoilCsm());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("dep_mnvr_in_hrs", getDepMnvrInHrs());
		this.hashColumns.put("act_foil_csm_avg", getActFoilCsmAvg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pf_sea_tm_hrs", getPfSeaTmHrs());
		this.hashColumns.put("port_time", getPortTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_init_foil_csm", getSInitFoilCsm());
		this.hashColumns.put("act_port_foil_csm", getActPortFoilCsm());
		this.hashColumns.put("s_init_port_foil_csm", getSInitPortFoilCsm());
		this.hashColumns.put("op_gnr_spd", getOpGnrSpd());
		this.hashColumns.put("act_port_foil_csm_avg", getActPortFoilCsmAvg());
		this.hashColumns.put("act_opmz_sea_tm_hrs", getActOpmzSeaTmHrs());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("spd_pf_lnk", getSpdPfLnk());
		this.hashColumns.put("trnd_line_foil_csm", getTrndLineFoilCsm());
		this.hashColumns.put("init_foil_csm", getInitFoilCsm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("mnvr_csm_wgt", getMnvrCsmWgt());
		this.hashColumns.put("init_tactual_sea_tm_hrs", getInitTactualSeaTmHrs());
		this.hashColumns.put("nvgt_ml_dist", getNvgtMlDist());
		this.hashColumns.put("init_tactual_port_time", getInitTactualPortTime());
		this.hashColumns.put("one_ago_previous", getOneAgoPrevious());
		this.hashColumns.put("two_ago_previous", getTwoAgoPrevious());
		this.hashColumns.put("three_ago_previous", getThreeAgoPrevious());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("opmz_sea_tm_hrs", "opmzSeaTmHrs");
		this.hashFields.put("act_foil_csm_cal", "actFoilCsmCal");
		this.hashFields.put("s_opmz_sea_tm_hrs", "sOpmzSeaTmHrs");
		this.hashFields.put("s_opmz_sea_spd", "sOpmzSeaSpd");
		this.hashFields.put("dep_mnvr_out_hrs", "depMnvrOutHrs");
		this.hashFields.put("act_port_foil_csm_cal", "actPortFoilCsmCal");
		this.hashFields.put("opmz_dist", "opmzDist");
		this.hashFields.put("act_port_time", "actPortTime");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("pf_mnvr_in_hrs", "pfMnvrInHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("s_opmz_dist", "sOpmzDist");
		this.hashFields.put("pf_mnvr_out_hrs", "pfMnvrOutHrs");
		this.hashFields.put("trnd_line_port_foil_csm", "trndLinePortFoilCsm");
		this.hashFields.put("s_pf_sea_tm_hrs", "sPfSeaTmHrs");
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("dist_opmz", "distOpmz");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("opmz_sea_spd", "opmzSeaSpd");
		this.hashFields.put("rvis_foil_csm", "rvisFoilCsm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rvis_port_foil_csm", "rvisPortFoilCsm");
		this.hashFields.put("op_min_spd", "opMinSpd");
		this.hashFields.put("dep_avg_spd", "depAvgSpd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("save_flg", "saveFlg");
		this.hashFields.put("dist_pf_lnk", "distPfLnk");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("act_foil_csm", "actFoilCsm");
		this.hashFields.put("init_port_foil_csm", "initPortFoilCsm");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("dep_mnvr_in_hrs", "depMnvrInHrs");
		this.hashFields.put("act_foil_csm_avg", "actFoilCsmAvg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pf_sea_tm_hrs", "pfSeaTmHrs");
		this.hashFields.put("port_time", "portTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_init_foil_csm", "sInitFoilCsm");
		this.hashFields.put("act_port_foil_csm", "actPortFoilCsm");
		this.hashFields.put("s_init_port_foil_csm", "sInitPortFoilCsm");
		this.hashFields.put("op_gnr_spd", "opGnrSpd");
		this.hashFields.put("act_port_foil_csm_avg", "actPortFoilCsmAvg");
		this.hashFields.put("act_opmz_sea_tm_hrs", "actOpmzSeaTmHrs");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("spd_pf_lnk", "spdPfLnk");
		this.hashFields.put("trnd_line_foil_csm", "trndLineFoilCsm");
		this.hashFields.put("init_foil_csm", "initFoilCsm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("mnvr_csm_wgt", "mnvrCsmWgt");
		this.hashFields.put("init_tactual_sea_tm_hrs", "initTactualSeaTmHrs");
		this.hashFields.put("nvgt_ml_dist", "nvgtMlDist");
		this.hashFields.put("init_tactual_port_time", "initTactualPortTime");
		this.hashFields.put("one_ago_previous", "oneAgoPrevious");
		this.hashFields.put("two_ago_previous", "twoAgoPrevious");
		this.hashFields.put("three_ago_previous", "threeAgoPrevious");
		return this.hashFields;
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
	 * @return opmzSeaTmHrs
	 */
	public String getOpmzSeaTmHrs() {
		return this.opmzSeaTmHrs;
	}
	
	/**
	 * Column Info
	 * @return actFoilCsmCal
	 */
	public String getActFoilCsmCal() {
		return this.actFoilCsmCal;
	}
	
	/**
	 * Column Info
	 * @return sOpmzSeaTmHrs
	 */
	public String getSOpmzSeaTmHrs() {
		return this.sOpmzSeaTmHrs;
	}
	
	/**
	 * Column Info
	 * @return sOpmzSeaSpd
	 */
	public String getSOpmzSeaSpd() {
		return this.sOpmzSeaSpd;
	}
	
	/**
	 * Column Info
	 * @return depMnvrOutHrs
	 */
	public String getDepMnvrOutHrs() {
		return this.depMnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @return actPortFoilCsmCal
	 */
	public String getActPortFoilCsmCal() {
		return this.actPortFoilCsmCal;
	}
	
	/**
	 * Column Info
	 * @return opmzDist
	 */
	public String getOpmzDist() {
		return this.opmzDist;
	}
	
	/**
	 * Column Info
	 * @return actPortTime
	 */
	public String getActPortTime() {
		return this.actPortTime;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return pfMnvrInHrs
	 */
	public String getPfMnvrInHrs() {
		return this.pfMnvrInHrs;
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
	 * Column Info
	 * @return sOpmzDist
	 */
	public String getSOpmzDist() {
		return this.sOpmzDist;
	}
	
	/**
	 * Column Info
	 * @return pfMnvrOutHrs
	 */
	public String getPfMnvrOutHrs() {
		return this.pfMnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @return trndLinePortFoilCsm
	 */
	public String getTrndLinePortFoilCsm() {
		return this.trndLinePortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return sPfSeaTmHrs
	 */
	public String getSPfSeaTmHrs() {
		return this.sPfSeaTmHrs;
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
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return distOpmz
	 */
	public String getDistOpmz() {
		return this.distOpmz;
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
	 * @return opmzSeaSpd
	 */
	public String getOpmzSeaSpd() {
		return this.opmzSeaSpd;
	}
	
	/**
	 * Column Info
	 * @return rvisFoilCsm
	 */
	public String getRvisFoilCsm() {
		return this.rvisFoilCsm;
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
	 * @return rvisPortFoilCsm
	 */
	public String getRvisPortFoilCsm() {
		return this.rvisPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return opMinSpd
	 */
	public String getOpMinSpd() {
		return this.opMinSpd;
	}
	
	/**
	 * Column Info
	 * @return depAvgSpd
	 */
	public String getDepAvgSpd() {
		return this.depAvgSpd;
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
	 * @return saveFlg
	 */
	public String getSaveFlg() {
		return this.saveFlg;
	}
	
	/**
	 * Column Info
	 * @return distPfLnk
	 */
	public String getDistPfLnk() {
		return this.distPfLnk;
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
	 * @return actFoilCsm
	 */
	public String getActFoilCsm() {
		return this.actFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return initPortFoilCsm
	 */
	public String getInitPortFoilCsm() {
		return this.initPortFoilCsm;
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
	 * @return depMnvrInHrs
	 */
	public String getDepMnvrInHrs() {
		return this.depMnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return actFoilCsmAvg
	 */
	public String getActFoilCsmAvg() {
		return this.actFoilCsmAvg;
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
	 * @return pfSeaTmHrs
	 */
	public String getPfSeaTmHrs() {
		return this.pfSeaTmHrs;
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
	 * @return sInitFoilCsm
	 */
	public String getSInitFoilCsm() {
		return this.sInitFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return actPortFoilCsm
	 */
	public String getActPortFoilCsm() {
		return this.actPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return sInitPortFoilCsm
	 */
	public String getSInitPortFoilCsm() {
		return this.sInitPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return opGnrSpd
	 */
	public String getOpGnrSpd() {
		return this.opGnrSpd;
	}
	
	/**
	 * Column Info
	 * @return actPortFoilCsmAvg
	 */
	public String getActPortFoilCsmAvg() {
		return this.actPortFoilCsmAvg;
	}
	
	/**
	 * Column Info
	 * @return actOpmzSeaTmHrs
	 */
	public String getActOpmzSeaTmHrs() {
		return this.actOpmzSeaTmHrs;
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
	 * @return spdPfLnk
	 */
	public String getSpdPfLnk() {
		return this.spdPfLnk;
	}
	
	/**
	 * Column Info
	 * @return trndLineFoilCsm
	 */
	public String getTrndLineFoilCsm() {
		return this.trndLineFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return initFoilCsm
	 */
	public String getInitFoilCsm() {
		return this.initFoilCsm;
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
	 * @return mnvrCsmWgt
	 */
	public String getMnvrCsmWgt() {
		return this.mnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return initTactualSeaTmHrs
	 */
	public String getInitTactualSeaTmHrs() {
		return this.initTactualSeaTmHrs;
	}
	
	/**
	 * Column Info
	 * @return nvgtMlDist
	 */
	public String getNvgtMlDist() {
		return this.nvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @return initTactualPortTime
	 */
	public String getInitTactualPortTime() {
		return this.initTactualPortTime;
	}
	
	/**
	 * Column Info
	 * @return oneAgoPrevious
	 */
	public String getOneAgoPrevious() {
		return this.oneAgoPrevious;
	}
	
	/**
	 * Column Info
	 * @return twoAgoPrevious
	 */
	public String getTwoAgoPrevious() {
		return this.twoAgoPrevious;
	}
	
	/**
	 * Column Info
	 * @return threeAgoPrevious
	 */
	public String getThreeAgoPrevious() {
		return this.threeAgoPrevious;
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
	 * @param opmzSeaTmHrs
	 */
	public void setOpmzSeaTmHrs(String opmzSeaTmHrs) {
		this.opmzSeaTmHrs = opmzSeaTmHrs;
	}
	
	/**
	 * Column Info
	 * @param actFoilCsmCal
	 */
	public void setActFoilCsmCal(String actFoilCsmCal) {
		this.actFoilCsmCal = actFoilCsmCal;
	}
	
	/**
	 * Column Info
	 * @param sOpmzSeaTmHrs
	 */
	public void setSOpmzSeaTmHrs(String sOpmzSeaTmHrs) {
		this.sOpmzSeaTmHrs = sOpmzSeaTmHrs;
	}
	
	/**
	 * Column Info
	 * @param sOpmzSeaSpd
	 */
	public void setSOpmzSeaSpd(String sOpmzSeaSpd) {
		this.sOpmzSeaSpd = sOpmzSeaSpd;
	}
	
	/**
	 * Column Info
	 * @param depMnvrOutHrs
	 */
	public void setDepMnvrOutHrs(String depMnvrOutHrs) {
		this.depMnvrOutHrs = depMnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @param actPortFoilCsmCal
	 */
	public void setActPortFoilCsmCal(String actPortFoilCsmCal) {
		this.actPortFoilCsmCal = actPortFoilCsmCal;
	}
	
	/**
	 * Column Info
	 * @param opmzDist
	 */
	public void setOpmzDist(String opmzDist) {
		this.opmzDist = opmzDist;
	}
	
	/**
	 * Column Info
	 * @param actPortTime
	 */
	public void setActPortTime(String actPortTime) {
		this.actPortTime = actPortTime;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param pfMnvrInHrs
	 */
	public void setPfMnvrInHrs(String pfMnvrInHrs) {
		this.pfMnvrInHrs = pfMnvrInHrs;
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
	 * Column Info
	 * @param sOpmzDist
	 */
	public void setSOpmzDist(String sOpmzDist) {
		this.sOpmzDist = sOpmzDist;
	}
	
	/**
	 * Column Info
	 * @param pfMnvrOutHrs
	 */
	public void setPfMnvrOutHrs(String pfMnvrOutHrs) {
		this.pfMnvrOutHrs = pfMnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @param trndLinePortFoilCsm
	 */
	public void setTrndLinePortFoilCsm(String trndLinePortFoilCsm) {
		this.trndLinePortFoilCsm = trndLinePortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param sPfSeaTmHrs
	 */
	public void setSPfSeaTmHrs(String sPfSeaTmHrs) {
		this.sPfSeaTmHrs = sPfSeaTmHrs;
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
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param distOpmz
	 */
	public void setDistOpmz(String distOpmz) {
		this.distOpmz = distOpmz;
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
	 * @param opmzSeaSpd
	 */
	public void setOpmzSeaSpd(String opmzSeaSpd) {
		this.opmzSeaSpd = opmzSeaSpd;
	}
	
	/**
	 * Column Info
	 * @param rvisFoilCsm
	 */
	public void setRvisFoilCsm(String rvisFoilCsm) {
		this.rvisFoilCsm = rvisFoilCsm;
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
	 * @param rvisPortFoilCsm
	 */
	public void setRvisPortFoilCsm(String rvisPortFoilCsm) {
		this.rvisPortFoilCsm = rvisPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param opMinSpd
	 */
	public void setOpMinSpd(String opMinSpd) {
		this.opMinSpd = opMinSpd;
	}
	
	/**
	 * Column Info
	 * @param depAvgSpd
	 */
	public void setDepAvgSpd(String depAvgSpd) {
		this.depAvgSpd = depAvgSpd;
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
	 * @param saveFlg
	 */
	public void setSaveFlg(String saveFlg) {
		this.saveFlg = saveFlg;
	}
	
	/**
	 * Column Info
	 * @param distPfLnk
	 */
	public void setDistPfLnk(String distPfLnk) {
		this.distPfLnk = distPfLnk;
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
	 * @param actFoilCsm
	 */
	public void setActFoilCsm(String actFoilCsm) {
		this.actFoilCsm = actFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param initPortFoilCsm
	 */
	public void setInitPortFoilCsm(String initPortFoilCsm) {
		this.initPortFoilCsm = initPortFoilCsm;
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
	 * @param depMnvrInHrs
	 */
	public void setDepMnvrInHrs(String depMnvrInHrs) {
		this.depMnvrInHrs = depMnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param actFoilCsmAvg
	 */
	public void setActFoilCsmAvg(String actFoilCsmAvg) {
		this.actFoilCsmAvg = actFoilCsmAvg;
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
	 * @param pfSeaTmHrs
	 */
	public void setPfSeaTmHrs(String pfSeaTmHrs) {
		this.pfSeaTmHrs = pfSeaTmHrs;
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
	 * @param sInitFoilCsm
	 */
	public void setSInitFoilCsm(String sInitFoilCsm) {
		this.sInitFoilCsm = sInitFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param actPortFoilCsm
	 */
	public void setActPortFoilCsm(String actPortFoilCsm) {
		this.actPortFoilCsm = actPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param sInitPortFoilCsm
	 */
	public void setSInitPortFoilCsm(String sInitPortFoilCsm) {
		this.sInitPortFoilCsm = sInitPortFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param opGnrSpd
	 */
	public void setOpGnrSpd(String opGnrSpd) {
		this.opGnrSpd = opGnrSpd;
	}
	
	/**
	 * Column Info
	 * @param actPortFoilCsmAvg
	 */
	public void setActPortFoilCsmAvg(String actPortFoilCsmAvg) {
		this.actPortFoilCsmAvg = actPortFoilCsmAvg;
	}
	
	/**
	 * Column Info
	 * @param actOpmzSeaTmHrs
	 */
	public void setActOpmzSeaTmHrs(String actOpmzSeaTmHrs) {
		this.actOpmzSeaTmHrs = actOpmzSeaTmHrs;
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
	 * @param spdPfLnk
	 */
	public void setSpdPfLnk(String spdPfLnk) {
		this.spdPfLnk = spdPfLnk;
	}
	
	/**
	 * Column Info
	 * @param trndLineFoilCsm
	 */
	public void setTrndLineFoilCsm(String trndLineFoilCsm) {
		this.trndLineFoilCsm = trndLineFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param initFoilCsm
	 */
	public void setInitFoilCsm(String initFoilCsm) {
		this.initFoilCsm = initFoilCsm;
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
	 * @param mnvrCsmWgt
	 */
	public void setMnvrCsmWgt(String mnvrCsmWgt) {
		this.mnvrCsmWgt = mnvrCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param initTactualSeaTmHrs
	 */
	public void setInitTactualSeaTmHrs(String initTactualSeaTmHrs) {
		this.initTactualSeaTmHrs = initTactualSeaTmHrs;
	}
	
	/**
	 * Column Info
	 * @param nvgtMlDist
	 */
	public void setNvgtMlDist(String nvgtMlDist) {
		this.nvgtMlDist = nvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @param initTactualPortTime
	 */
	public void setInitTactualPortTime(String initTactualPortTime) {
		this.initTactualPortTime = initTactualPortTime;
	}
	
	/**
	 * Column Info
	 * @param oneAgoPrevious
	 */
	public void setOneAgoPrevious(String oneAgoPrevious) {
		this.oneAgoPrevious = oneAgoPrevious;
	}
	
	/**
	 * Column Info
	 * @param twoAgoPrevious
	 */
	public void setTwoAgoPrevious(String twoAgoPrevious) {
		this.twoAgoPrevious = twoAgoPrevious;
	}
	
	/**
	 * Column Info
	 * @param threeAgoPrevious
	 */
	public void setThreeAgoPrevious(String threeAgoPrevious) {
		this.threeAgoPrevious = threeAgoPrevious;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setOpmzSeaTmHrs(JSPUtil.getParameter(request, prefix + "opmz_sea_tm_hrs", ""));
		setActFoilCsmCal(JSPUtil.getParameter(request, prefix + "act_foil_csm_cal", ""));
		setSOpmzSeaTmHrs(JSPUtil.getParameter(request, prefix + "s_opmz_sea_tm_hrs", ""));
		setSOpmzSeaSpd(JSPUtil.getParameter(request, prefix + "s_opmz_sea_spd", ""));
		setDepMnvrOutHrs(JSPUtil.getParameter(request, prefix + "dep_mnvr_out_hrs", ""));
		setActPortFoilCsmCal(JSPUtil.getParameter(request, prefix + "act_port_foil_csm_cal", ""));
		setOpmzDist(JSPUtil.getParameter(request, prefix + "opmz_dist", ""));
		setActPortTime(JSPUtil.getParameter(request, prefix + "act_port_time", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setPfMnvrInHrs(JSPUtil.getParameter(request, prefix + "pf_mnvr_in_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setSOpmzDist(JSPUtil.getParameter(request, prefix + "s_opmz_dist", ""));
		setPfMnvrOutHrs(JSPUtil.getParameter(request, prefix + "pf_mnvr_out_hrs", ""));
		setTrndLinePortFoilCsm(JSPUtil.getParameter(request, prefix + "trnd_line_port_foil_csm", ""));
		setSPfSeaTmHrs(JSPUtil.getParameter(request, prefix + "s_pf_sea_tm_hrs", ""));
		setPortSkdStsCd(JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
		setDistOpmz(JSPUtil.getParameter(request, prefix + "dist_opmz", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setOpmzSeaSpd(JSPUtil.getParameter(request, prefix + "opmz_sea_spd", ""));
		setRvisFoilCsm(JSPUtil.getParameter(request, prefix + "rvis_foil_csm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRvisPortFoilCsm(JSPUtil.getParameter(request, prefix + "rvis_port_foil_csm", ""));
		setOpMinSpd(JSPUtil.getParameter(request, prefix + "op_min_spd", ""));
		setDepAvgSpd(JSPUtil.getParameter(request, prefix + "dep_avg_spd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSaveFlg(JSPUtil.getParameter(request, prefix + "save_flg", ""));
		setDistPfLnk(JSPUtil.getParameter(request, prefix + "dist_pf_lnk", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setActFoilCsm(JSPUtil.getParameter(request, prefix + "act_foil_csm", ""));
		setInitPortFoilCsm(JSPUtil.getParameter(request, prefix + "init_port_foil_csm", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setDepMnvrInHrs(JSPUtil.getParameter(request, prefix + "dep_mnvr_in_hrs", ""));
		setActFoilCsmAvg(JSPUtil.getParameter(request, prefix + "act_foil_csm_avg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPfSeaTmHrs(JSPUtil.getParameter(request, prefix + "pf_sea_tm_hrs", ""));
		setPortTime(JSPUtil.getParameter(request, prefix + "port_time", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSInitFoilCsm(JSPUtil.getParameter(request, prefix + "s_init_foil_csm", ""));
		setActPortFoilCsm(JSPUtil.getParameter(request, prefix + "act_port_foil_csm", ""));
		setSInitPortFoilCsm(JSPUtil.getParameter(request, prefix + "s_init_port_foil_csm", ""));
		setOpGnrSpd(JSPUtil.getParameter(request, prefix + "op_gnr_spd", ""));
		setActPortFoilCsmAvg(JSPUtil.getParameter(request, prefix + "act_port_foil_csm_avg", ""));
		setActOpmzSeaTmHrs(JSPUtil.getParameter(request, prefix + "act_opmz_sea_tm_hrs", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSpdPfLnk(JSPUtil.getParameter(request, prefix + "spd_pf_lnk", ""));
		setTrndLineFoilCsm(JSPUtil.getParameter(request, prefix + "trnd_line_foil_csm", ""));
		setInitFoilCsm(JSPUtil.getParameter(request, prefix + "init_foil_csm", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setMnvrCsmWgt(JSPUtil.getParameter(request, prefix + "mnvr_csm_wgt", ""));
		setInitTactualSeaTmHrs(JSPUtil.getParameter(request, prefix + "init_tactual_sea_tm_hrs", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "init_tactual_port_time", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "one_ago_previous", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "two_ago_previous", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "three_ago_previous", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StandardFocVO[]
	 */
	public StandardFocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StandardFocVO[]
	 */
	public StandardFocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StandardFocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] opmzSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "opmz_sea_tm_hrs", length));
			String[] actFoilCsmCal = (JSPUtil.getParameter(request, prefix	+ "act_foil_csm_cal", length));
			String[] sOpmzSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "s_opmz_sea_tm_hrs", length));
			String[] sOpmzSeaSpd = (JSPUtil.getParameter(request, prefix	+ "s_opmz_sea_spd", length));
			String[] depMnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "dep_mnvr_out_hrs", length));
			String[] actPortFoilCsmCal = (JSPUtil.getParameter(request, prefix	+ "act_port_foil_csm_cal", length));
			String[] opmzDist = (JSPUtil.getParameter(request, prefix	+ "opmz_dist", length));
			String[] actPortTime = (JSPUtil.getParameter(request, prefix	+ "act_port_time", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] pfMnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "pf_mnvr_in_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] sOpmzDist = (JSPUtil.getParameter(request, prefix	+ "s_opmz_dist", length));
			String[] pfMnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "pf_mnvr_out_hrs", length));
			String[] trndLinePortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "trnd_line_port_foil_csm", length));
			String[] sPfSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "s_pf_sea_tm_hrs", length));
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] distOpmz = (JSPUtil.getParameter(request, prefix	+ "dist_opmz", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] opmzSeaSpd = (JSPUtil.getParameter(request, prefix	+ "opmz_sea_spd", length));
			String[] rvisFoilCsm = (JSPUtil.getParameter(request, prefix	+ "rvis_foil_csm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rvisPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "rvis_port_foil_csm", length));
			String[] opMinSpd = (JSPUtil.getParameter(request, prefix	+ "op_min_spd", length));
			String[] depAvgSpd = (JSPUtil.getParameter(request, prefix	+ "dep_avg_spd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] saveFlg = (JSPUtil.getParameter(request, prefix	+ "save_flg", length));
			String[] distPfLnk = (JSPUtil.getParameter(request, prefix	+ "dist_pf_lnk", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] actFoilCsm = (JSPUtil.getParameter(request, prefix	+ "act_foil_csm", length));
			String[] initPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "init_port_foil_csm", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] depMnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "dep_mnvr_in_hrs", length));
			String[] actFoilCsmAvg = (JSPUtil.getParameter(request, prefix	+ "act_foil_csm_avg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pfSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "pf_sea_tm_hrs", length));
			String[] portTime = (JSPUtil.getParameter(request, prefix	+ "port_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sInitFoilCsm = (JSPUtil.getParameter(request, prefix	+ "s_init_foil_csm", length));
			String[] actPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "act_port_foil_csm", length));
			String[] sInitPortFoilCsm = (JSPUtil.getParameter(request, prefix	+ "s_init_port_foil_csm", length));
			String[] opGnrSpd = (JSPUtil.getParameter(request, prefix	+ "op_gnr_spd", length));
			String[] actPortFoilCsmAvg = (JSPUtil.getParameter(request, prefix	+ "act_port_foil_csm_avg", length));
			String[] actOpmzSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "act_opmz_sea_tm_hrs", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] spdPfLnk = (JSPUtil.getParameter(request, prefix	+ "spd_pf_lnk", length));
			String[] trndLineFoilCsm = (JSPUtil.getParameter(request, prefix	+ "trnd_line_foil_csm", length));
			String[] initFoilCsm = (JSPUtil.getParameter(request, prefix	+ "init_foil_csm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] mnvrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "mnvr_csm_wgt", length));
			String[] initTactualSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "init_tactual_sea_tm_hrs", length));
			String[] nvgtMlDist = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist", length));
			String[] initTactualPortTime = (JSPUtil.getParameter(request, prefix	+ "init_tactual_port_time", length));
			String[] oneAgoPrevious = (JSPUtil.getParameter(request, prefix	+ "one_ago_previous", length));
			String[] twoAgoPrevious = (JSPUtil.getParameter(request, prefix	+ "two_ago_previous", length));
			String[] threeAgoPrevious = (JSPUtil.getParameter(request, prefix	+ "three_ago_previous", length));
			
			for (int i = 0; i < length; i++) {
				model = new StandardFocVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (opmzSeaTmHrs[i] != null)
					model.setOpmzSeaTmHrs(opmzSeaTmHrs[i]);
				if (actFoilCsmCal[i] != null)
					model.setActFoilCsmCal(actFoilCsmCal[i]);
				if (sOpmzSeaTmHrs[i] != null)
					model.setSOpmzSeaTmHrs(sOpmzSeaTmHrs[i]);
				if (sOpmzSeaSpd[i] != null)
					model.setSOpmzSeaSpd(sOpmzSeaSpd[i]);
				if (depMnvrOutHrs[i] != null)
					model.setDepMnvrOutHrs(depMnvrOutHrs[i]);
				if (actPortFoilCsmCal[i] != null)
					model.setActPortFoilCsmCal(actPortFoilCsmCal[i]);
				if (opmzDist[i] != null)
					model.setOpmzDist(opmzDist[i]);
				if (actPortTime[i] != null)
					model.setActPortTime(actPortTime[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (pfMnvrInHrs[i] != null)
					model.setPfMnvrInHrs(pfMnvrInHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (sOpmzDist[i] != null)
					model.setSOpmzDist(sOpmzDist[i]);
				if (pfMnvrOutHrs[i] != null)
					model.setPfMnvrOutHrs(pfMnvrOutHrs[i]);
				if (trndLinePortFoilCsm[i] != null)
					model.setTrndLinePortFoilCsm(trndLinePortFoilCsm[i]);
				if (sPfSeaTmHrs[i] != null)
					model.setSPfSeaTmHrs(sPfSeaTmHrs[i]);
				if (portSkdStsCd[i] != null)
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (distOpmz[i] != null)
					model.setDistOpmz(distOpmz[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (opmzSeaSpd[i] != null)
					model.setOpmzSeaSpd(opmzSeaSpd[i]);
				if (rvisFoilCsm[i] != null)
					model.setRvisFoilCsm(rvisFoilCsm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rvisPortFoilCsm[i] != null)
					model.setRvisPortFoilCsm(rvisPortFoilCsm[i]);
				if (opMinSpd[i] != null)
					model.setOpMinSpd(opMinSpd[i]);
				if (depAvgSpd[i] != null)
					model.setDepAvgSpd(depAvgSpd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (saveFlg[i] != null)
					model.setSaveFlg(saveFlg[i]);
				if (distPfLnk[i] != null)
					model.setDistPfLnk(distPfLnk[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (actFoilCsm[i] != null)
					model.setActFoilCsm(actFoilCsm[i]);
				if (initPortFoilCsm[i] != null)
					model.setInitPortFoilCsm(initPortFoilCsm[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (depMnvrInHrs[i] != null)
					model.setDepMnvrInHrs(depMnvrInHrs[i]);
				if (actFoilCsmAvg[i] != null)
					model.setActFoilCsmAvg(actFoilCsmAvg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pfSeaTmHrs[i] != null)
					model.setPfSeaTmHrs(pfSeaTmHrs[i]);
				if (portTime[i] != null)
					model.setPortTime(portTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sInitFoilCsm[i] != null)
					model.setSInitFoilCsm(sInitFoilCsm[i]);
				if (actPortFoilCsm[i] != null)
					model.setActPortFoilCsm(actPortFoilCsm[i]);
				if (sInitPortFoilCsm[i] != null)
					model.setSInitPortFoilCsm(sInitPortFoilCsm[i]);
				if (opGnrSpd[i] != null)
					model.setOpGnrSpd(opGnrSpd[i]);
				if (actPortFoilCsmAvg[i] != null)
					model.setActPortFoilCsmAvg(actPortFoilCsmAvg[i]);
				if (actOpmzSeaTmHrs[i] != null)
					model.setActOpmzSeaTmHrs(actOpmzSeaTmHrs[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (spdPfLnk[i] != null)
					model.setSpdPfLnk(spdPfLnk[i]);
				if (trndLineFoilCsm[i] != null)
					model.setTrndLineFoilCsm(trndLineFoilCsm[i]);
				if (initFoilCsm[i] != null)
					model.setInitFoilCsm(initFoilCsm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (mnvrCsmWgt[i] != null)
					model.setMnvrCsmWgt(mnvrCsmWgt[i]);
				if (initTactualSeaTmHrs[i] != null)
					model.setInitTactualSeaTmHrs(initTactualSeaTmHrs[i]);
				if (nvgtMlDist[i] != null)
					model.setNvgtMlDist(nvgtMlDist[i]);
				if (initTactualPortTime[i] != null)
					model.setInitTactualPortTime(initTactualPortTime[i]);
				if (oneAgoPrevious[i] != null)
					model.setOneAgoPrevious(oneAgoPrevious[i]);
				if (twoAgoPrevious[i] != null)
					model.setTwoAgoPrevious(twoAgoPrevious[i]);
				if (threeAgoPrevious[i] != null)
					model.setThreeAgoPrevious(threeAgoPrevious[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStandardFocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StandardFocVO[]
	 */
	public StandardFocVO[] getStandardFocVOs(){
		StandardFocVO[] vos = (StandardFocVO[])models.toArray(new StandardFocVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzSeaTmHrs = this.opmzSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilCsmCal = this.actFoilCsmCal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOpmzSeaTmHrs = this.sOpmzSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOpmzSeaSpd = this.sOpmzSeaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMnvrOutHrs = this.depMnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortFoilCsmCal = this.actPortFoilCsmCal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzDist = this.opmzDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortTime = this.actPortTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfMnvrInHrs = this.pfMnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOpmzDist = this.sOpmzDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfMnvrOutHrs = this.pfMnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLinePortFoilCsm = this.trndLinePortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPfSeaTmHrs = this.sPfSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distOpmz = this.distOpmz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opmzSeaSpd = this.opmzSeaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisFoilCsm = this.rvisFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisPortFoilCsm = this.rvisPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opMinSpd = this.opMinSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAvgSpd = this.depAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveFlg = this.saveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distPfLnk = this.distPfLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilCsm = this.actFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initPortFoilCsm = this.initPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMnvrInHrs = this.depMnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilCsmAvg = this.actFoilCsmAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSeaTmHrs = this.pfSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTime = this.portTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInitFoilCsm = this.sInitFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortFoilCsm = this.actPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInitPortFoilCsm = this.sInitPortFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opGnrSpd = this.opGnrSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortFoilCsmAvg = this.actPortFoilCsmAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actOpmzSeaTmHrs = this.actOpmzSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spdPfLnk = this.spdPfLnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineFoilCsm = this.trndLineFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initFoilCsm = this.initFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrCsmWgt = this.mnvrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initTactualSeaTmHrs = this.initTactualSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDist = this.nvgtMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initTactualPortTime = this.initTactualPortTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oneAgoPrevious = this.oneAgoPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twoAgoPrevious = this.twoAgoPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.threeAgoPrevious = this.threeAgoPrevious .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
