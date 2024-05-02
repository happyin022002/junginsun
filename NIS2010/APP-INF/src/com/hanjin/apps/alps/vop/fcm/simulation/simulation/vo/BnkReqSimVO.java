/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BnkReqSimVO.java
*@FileTitle : BnkReqSimVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.26 진마리아 
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BnkReqSimVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BnkReqSimVO> models = new ArrayList<BnkReqSimVO>();
	
	/* Column Info */
	private String trndLineTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String seaSpd = null;
	/* Column Info */
	private String fcmSimCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fcmSimSeq = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String avgCsmWgt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pfPortDist = null;
	/* Column Info */
	private String pfSeaTmHrs = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String actSeaTmHrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfBuffSpd = null;
	/* Column Info */
	private String actPortDist = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String pfSeaSpd = null;
	/* Column Info */
	private String estmCsmWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String suplWgt = null;
	/* Column Info */
	private String depFoilWgt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String dayCsmWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pfPortTmHrs = null;
	/* Column Info */
	private String portTmHrs = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String seaTmHrs = null;
	/* Column Info */
	private String sailGnrCsmWgt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String actPortTmHrs = null;
	/* Column Info */
	private String sailMeCsmWgt = null;
	/* Column Info */
	private String portCsmWgt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String trndLineNo = null;
	/* Column Info */
	private String depLowSulpFoilWgt = null;
	/* Column Info */
	private String fcmSimDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BnkReqSimVO() {}

	public BnkReqSimVO(String ibflag, String pagerows, String fcmSimCd, String vslCd, String skdVoyNo, String skdDirCd, String fcmSimSeq, String fcmSimDt, String vvdSeq, String vpsPortCd, String clptIndSeq, String ydCd, String clptSeq, String slanCd, String pfSkdTpCd, String vvd, String skdCngStsCd, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String portTmHrs, String seaTmHrs, String seaSpd, String estmCsmWgt, String avgCsmWgt, String depFoilWgt, String depLowSulpFoilWgt, String suplWgt, String dayCsmWgt, String portCsmWgt, String sailMeCsmWgt, String sailGnrCsmWgt, String pfPortTmHrs, String actPortTmHrs, String pfSeaTmHrs, String actSeaTmHrs, String pfPortDist, String actPortDist, String pfSeaSpd, String pfBuffSpd, String trndLineTpCd, String trndLineNo, String trndLineSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.trndLineTpCd = trndLineTpCd;
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.seaSpd = seaSpd;
		this.fcmSimCd = fcmSimCd;
		this.creDt = creDt;
		this.fcmSimSeq = fcmSimSeq;
		this.pfSkdTpCd = pfSkdTpCd;
		this.avgCsmWgt = avgCsmWgt;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.pfPortDist = pfPortDist;
		this.pfSeaTmHrs = pfSeaTmHrs;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.actSeaTmHrs = actSeaTmHrs;
		this.ibflag = ibflag;
		this.pfBuffSpd = pfBuffSpd;
		this.actPortDist = actPortDist;
		this.updUsrId = updUsrId;
		this.vvdSeq = vvdSeq;
		this.pfSeaSpd = pfSeaSpd;
		this.estmCsmWgt = estmCsmWgt;
		this.updDt = updDt;
		this.suplWgt = suplWgt;
		this.depFoilWgt = depFoilWgt;
		this.vpsEtdDt = vpsEtdDt;
		this.dayCsmWgt = dayCsmWgt;
		this.skdVoyNo = skdVoyNo;
		this.pfPortTmHrs = pfPortTmHrs;
		this.portTmHrs = portTmHrs;
		this.skdDirCd = skdDirCd;
		this.seaTmHrs = seaTmHrs;
		this.sailGnrCsmWgt = sailGnrCsmWgt;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.trndLineSeq = trndLineSeq;
		this.slanCd = slanCd;
		this.skdCngStsCd = skdCngStsCd;
		this.actPortTmHrs = actPortTmHrs;
		this.sailMeCsmWgt = sailMeCsmWgt;
		this.portCsmWgt = portCsmWgt;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.trndLineNo = trndLineNo;
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
		this.fcmSimDt = fcmSimDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trnd_line_tp_cd", getTrndLineTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("sea_spd", getSeaSpd());
		this.hashColumns.put("fcm_sim_cd", getFcmSimCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fcm_sim_seq", getFcmSimSeq());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("avg_csm_wgt", getAvgCsmWgt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pf_port_dist", getPfPortDist());
		this.hashColumns.put("pf_sea_tm_hrs", getPfSeaTmHrs());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("act_sea_tm_hrs", getActSeaTmHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_buff_spd", getPfBuffSpd());
		this.hashColumns.put("act_port_dist", getActPortDist());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("pf_sea_spd", getPfSeaSpd());
		this.hashColumns.put("estm_csm_wgt", getEstmCsmWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("supl_wgt", getSuplWgt());
		this.hashColumns.put("dep_foil_wgt", getDepFoilWgt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("day_csm_wgt", getDayCsmWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pf_port_tm_hrs", getPfPortTmHrs());
		this.hashColumns.put("port_tm_hrs", getPortTmHrs());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("sea_tm_hrs", getSeaTmHrs());
		this.hashColumns.put("sail_gnr_csm_wgt", getSailGnrCsmWgt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("act_port_tm_hrs", getActPortTmHrs());
		this.hashColumns.put("sail_me_csm_wgt", getSailMeCsmWgt());
		this.hashColumns.put("port_csm_wgt", getPortCsmWgt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("trnd_line_no", getTrndLineNo());
		this.hashColumns.put("dep_low_sulp_foil_wgt", getDepLowSulpFoilWgt());
		this.hashColumns.put("fcm_sim_dt", getFcmSimDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trnd_line_tp_cd", "trndLineTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("sea_spd", "seaSpd");
		this.hashFields.put("fcm_sim_cd", "fcmSimCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fcm_sim_seq", "fcmSimSeq");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("avg_csm_wgt", "avgCsmWgt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pf_port_dist", "pfPortDist");
		this.hashFields.put("pf_sea_tm_hrs", "pfSeaTmHrs");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("act_sea_tm_hrs", "actSeaTmHrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_buff_spd", "pfBuffSpd");
		this.hashFields.put("act_port_dist", "actPortDist");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("pf_sea_spd", "pfSeaSpd");
		this.hashFields.put("estm_csm_wgt", "estmCsmWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("supl_wgt", "suplWgt");
		this.hashFields.put("dep_foil_wgt", "depFoilWgt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("day_csm_wgt", "dayCsmWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pf_port_tm_hrs", "pfPortTmHrs");
		this.hashFields.put("port_tm_hrs", "portTmHrs");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("sea_tm_hrs", "seaTmHrs");
		this.hashFields.put("sail_gnr_csm_wgt", "sailGnrCsmWgt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("act_port_tm_hrs", "actPortTmHrs");
		this.hashFields.put("sail_me_csm_wgt", "sailMeCsmWgt");
		this.hashFields.put("port_csm_wgt", "portCsmWgt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("trnd_line_no", "trndLineNo");
		this.hashFields.put("dep_low_sulp_foil_wgt", "depLowSulpFoilWgt");
		this.hashFields.put("fcm_sim_dt", "fcmSimDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trndLineTpCd
	 */
	public String getTrndLineTpCd() {
		return this.trndLineTpCd;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return seaSpd
	 */
	public String getSeaSpd() {
		return this.seaSpd;
	}
	
	/**
	 * Column Info
	 * @return fcmSimCd
	 */
	public String getFcmSimCd() {
		return this.fcmSimCd;
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
	 * @return fcmSimSeq
	 */
	public String getFcmSimSeq() {
		return this.fcmSimSeq;
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
	 * @return avgCsmWgt
	 */
	public String getAvgCsmWgt() {
		return this.avgCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return pfPortDist
	 */
	public String getPfPortDist() {
		return this.pfPortDist;
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
	 * @return actSeaTmHrs
	 */
	public String getActSeaTmHrs() {
		return this.actSeaTmHrs;
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
	 * @return pfBuffSpd
	 */
	public String getPfBuffSpd() {
		return this.pfBuffSpd;
	}
	
	/**
	 * Column Info
	 * @return actPortDist
	 */
	public String getActPortDist() {
		return this.actPortDist;
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
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return pfSeaSpd
	 */
	public String getPfSeaSpd() {
		return this.pfSeaSpd;
	}
	
	/**
	 * Column Info
	 * @return estmCsmWgt
	 */
	public String getEstmCsmWgt() {
		return this.estmCsmWgt;
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
	 * @return suplWgt
	 */
	public String getSuplWgt() {
		return this.suplWgt;
	}
	
	/**
	 * Column Info
	 * @return depFoilWgt
	 */
	public String getDepFoilWgt() {
		return this.depFoilWgt;
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
	 * @return dayCsmWgt
	 */
	public String getDayCsmWgt() {
		return this.dayCsmWgt;
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
	 * @return pfPortTmHrs
	 */
	public String getPfPortTmHrs() {
		return this.pfPortTmHrs;
	}
	
	/**
	 * Column Info
	 * @return portTmHrs
	 */
	public String getPortTmHrs() {
		return this.portTmHrs;
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
	 * @return seaTmHrs
	 */
	public String getSeaTmHrs() {
		return this.seaTmHrs;
	}
	
	/**
	 * Column Info
	 * @return sailGnrCsmWgt
	 */
	public String getSailGnrCsmWgt() {
		return this.sailGnrCsmWgt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
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
	 * @return skdCngStsCd
	 */
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @return actPortTmHrs
	 */
	public String getActPortTmHrs() {
		return this.actPortTmHrs;
	}
	
	/**
	 * Column Info
	 * @return sailMeCsmWgt
	 */
	public String getSailMeCsmWgt() {
		return this.sailMeCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return portCsmWgt
	 */
	public String getPortCsmWgt() {
		return this.portCsmWgt;
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
	 * @return trndLineNo
	 */
	public String getTrndLineNo() {
		return this.trndLineNo;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpFoilWgt
	 */
	public String getDepLowSulpFoilWgt() {
		return this.depLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return fcmSimDt
	 */
	public String getFcmSimDt() {
		return this.fcmSimDt;
	}
	

	/**
	 * Column Info
	 * @param trndLineTpCd
	 */
	public void setTrndLineTpCd(String trndLineTpCd) {
		this.trndLineTpCd = trndLineTpCd;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param seaSpd
	 */
	public void setSeaSpd(String seaSpd) {
		this.seaSpd = seaSpd;
	}
	
	/**
	 * Column Info
	 * @param fcmSimCd
	 */
	public void setFcmSimCd(String fcmSimCd) {
		this.fcmSimCd = fcmSimCd;
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
	 * @param fcmSimSeq
	 */
	public void setFcmSimSeq(String fcmSimSeq) {
		this.fcmSimSeq = fcmSimSeq;
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
	 * @param avgCsmWgt
	 */
	public void setAvgCsmWgt(String avgCsmWgt) {
		this.avgCsmWgt = avgCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param pfPortDist
	 */
	public void setPfPortDist(String pfPortDist) {
		this.pfPortDist = pfPortDist;
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
	 * @param actSeaTmHrs
	 */
	public void setActSeaTmHrs(String actSeaTmHrs) {
		this.actSeaTmHrs = actSeaTmHrs;
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
	 * @param pfBuffSpd
	 */
	public void setPfBuffSpd(String pfBuffSpd) {
		this.pfBuffSpd = pfBuffSpd;
	}
	
	/**
	 * Column Info
	 * @param actPortDist
	 */
	public void setActPortDist(String actPortDist) {
		this.actPortDist = actPortDist;
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
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param pfSeaSpd
	 */
	public void setPfSeaSpd(String pfSeaSpd) {
		this.pfSeaSpd = pfSeaSpd;
	}
	
	/**
	 * Column Info
	 * @param estmCsmWgt
	 */
	public void setEstmCsmWgt(String estmCsmWgt) {
		this.estmCsmWgt = estmCsmWgt;
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
	 * @param suplWgt
	 */
	public void setSuplWgt(String suplWgt) {
		this.suplWgt = suplWgt;
	}
	
	/**
	 * Column Info
	 * @param depFoilWgt
	 */
	public void setDepFoilWgt(String depFoilWgt) {
		this.depFoilWgt = depFoilWgt;
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
	 * @param dayCsmWgt
	 */
	public void setDayCsmWgt(String dayCsmWgt) {
		this.dayCsmWgt = dayCsmWgt;
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
	 * @param pfPortTmHrs
	 */
	public void setPfPortTmHrs(String pfPortTmHrs) {
		this.pfPortTmHrs = pfPortTmHrs;
	}
	
	/**
	 * Column Info
	 * @param portTmHrs
	 */
	public void setPortTmHrs(String portTmHrs) {
		this.portTmHrs = portTmHrs;
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
	 * @param seaTmHrs
	 */
	public void setSeaTmHrs(String seaTmHrs) {
		this.seaTmHrs = seaTmHrs;
	}
	
	/**
	 * Column Info
	 * @param sailGnrCsmWgt
	 */
	public void setSailGnrCsmWgt(String sailGnrCsmWgt) {
		this.sailGnrCsmWgt = sailGnrCsmWgt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
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
	 * @param skdCngStsCd
	 */
	public void setSkdCngStsCd(String skdCngStsCd) {
		this.skdCngStsCd = skdCngStsCd;
	}
	
	/**
	 * Column Info
	 * @param actPortTmHrs
	 */
	public void setActPortTmHrs(String actPortTmHrs) {
		this.actPortTmHrs = actPortTmHrs;
	}
	
	/**
	 * Column Info
	 * @param sailMeCsmWgt
	 */
	public void setSailMeCsmWgt(String sailMeCsmWgt) {
		this.sailMeCsmWgt = sailMeCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param portCsmWgt
	 */
	public void setPortCsmWgt(String portCsmWgt) {
		this.portCsmWgt = portCsmWgt;
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
	 * @param trndLineNo
	 */
	public void setTrndLineNo(String trndLineNo) {
		this.trndLineNo = trndLineNo;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpFoilWgt
	 */
	public void setDepLowSulpFoilWgt(String depLowSulpFoilWgt) {
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param fcmSimDt
	 */
	public void setFcmSimDt(String fcmSimDt) {
		this.fcmSimDt = fcmSimDt;
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
		setTrndLineTpCd(JSPUtil.getParameter(request, prefix + "trnd_line_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setSeaSpd(JSPUtil.getParameter(request, prefix + "sea_spd", ""));
		setFcmSimCd(JSPUtil.getParameter(request, prefix + "fcm_sim_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFcmSimSeq(JSPUtil.getParameter(request, prefix + "fcm_sim_seq", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setAvgCsmWgt(JSPUtil.getParameter(request, prefix + "avg_csm_wgt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPfPortDist(JSPUtil.getParameter(request, prefix + "pf_port_dist", ""));
		setPfSeaTmHrs(JSPUtil.getParameter(request, prefix + "pf_sea_tm_hrs", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setActSeaTmHrs(JSPUtil.getParameter(request, prefix + "act_sea_tm_hrs", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPfBuffSpd(JSPUtil.getParameter(request, prefix + "pf_buff_spd", ""));
		setActPortDist(JSPUtil.getParameter(request, prefix + "act_port_dist", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
		setPfSeaSpd(JSPUtil.getParameter(request, prefix + "pf_sea_spd", ""));
		setEstmCsmWgt(JSPUtil.getParameter(request, prefix + "estm_csm_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSuplWgt(JSPUtil.getParameter(request, prefix + "supl_wgt", ""));
		setDepFoilWgt(JSPUtil.getParameter(request, prefix + "dep_foil_wgt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setDayCsmWgt(JSPUtil.getParameter(request, prefix + "day_csm_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPfPortTmHrs(JSPUtil.getParameter(request, prefix + "pf_port_tm_hrs", ""));
		setPortTmHrs(JSPUtil.getParameter(request, prefix + "port_tm_hrs", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSeaTmHrs(JSPUtil.getParameter(request, prefix + "sea_tm_hrs", ""));
		setSailGnrCsmWgt(JSPUtil.getParameter(request, prefix + "sail_gnr_csm_wgt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setActPortTmHrs(JSPUtil.getParameter(request, prefix + "act_port_tm_hrs", ""));
		setSailMeCsmWgt(JSPUtil.getParameter(request, prefix + "sail_me_csm_wgt", ""));
		setPortCsmWgt(JSPUtil.getParameter(request, prefix + "port_csm_wgt", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setTrndLineNo(JSPUtil.getParameter(request, prefix + "trnd_line_no", ""));
		setDepLowSulpFoilWgt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_foil_wgt", ""));
		setFcmSimDt(JSPUtil.getParameter(request, prefix + "fcm_sim_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BnkReqSimVO[]
	 */
	public BnkReqSimVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BnkReqSimVO[]
	 */
	public BnkReqSimVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BnkReqSimVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trndLineTpCd = (JSPUtil.getParameter(request, prefix	+ "trnd_line_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] seaSpd = (JSPUtil.getParameter(request, prefix	+ "sea_spd", length));
			String[] fcmSimCd = (JSPUtil.getParameter(request, prefix	+ "fcm_sim_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fcmSimSeq = (JSPUtil.getParameter(request, prefix	+ "fcm_sim_seq", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] avgCsmWgt = (JSPUtil.getParameter(request, prefix	+ "avg_csm_wgt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pfPortDist = (JSPUtil.getParameter(request, prefix	+ "pf_port_dist", length));
			String[] pfSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "pf_sea_tm_hrs", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] actSeaTmHrs = (JSPUtil.getParameter(request, prefix	+ "act_sea_tm_hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfBuffSpd = (JSPUtil.getParameter(request, prefix	+ "pf_buff_spd", length));
			String[] actPortDist = (JSPUtil.getParameter(request, prefix	+ "act_port_dist", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] pfSeaSpd = (JSPUtil.getParameter(request, prefix	+ "pf_sea_spd", length));
			String[] estmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "estm_csm_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] suplWgt = (JSPUtil.getParameter(request, prefix	+ "supl_wgt", length));
			String[] depFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_foil_wgt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] dayCsmWgt = (JSPUtil.getParameter(request, prefix	+ "day_csm_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pfPortTmHrs = (JSPUtil.getParameter(request, prefix	+ "pf_port_tm_hrs", length));
			String[] portTmHrs = (JSPUtil.getParameter(request, prefix	+ "port_tm_hrs", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] seaTmHrs = (JSPUtil.getParameter(request, prefix	+ "sea_tm_hrs", length));
			String[] sailGnrCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sail_gnr_csm_wgt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] actPortTmHrs = (JSPUtil.getParameter(request, prefix	+ "act_port_tm_hrs", length));
			String[] sailMeCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sail_me_csm_wgt", length));
			String[] portCsmWgt = (JSPUtil.getParameter(request, prefix	+ "port_csm_wgt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] trndLineNo = (JSPUtil.getParameter(request, prefix	+ "trnd_line_no", length));
			String[] depLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_foil_wgt", length));
			String[] fcmSimDt = (JSPUtil.getParameter(request, prefix	+ "fcm_sim_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BnkReqSimVO();
				if (trndLineTpCd[i] != null)
					model.setTrndLineTpCd(trndLineTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (seaSpd[i] != null)
					model.setSeaSpd(seaSpd[i]);
				if (fcmSimCd[i] != null)
					model.setFcmSimCd(fcmSimCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fcmSimSeq[i] != null)
					model.setFcmSimSeq(fcmSimSeq[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (avgCsmWgt[i] != null)
					model.setAvgCsmWgt(avgCsmWgt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pfPortDist[i] != null)
					model.setPfPortDist(pfPortDist[i]);
				if (pfSeaTmHrs[i] != null)
					model.setPfSeaTmHrs(pfSeaTmHrs[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (actSeaTmHrs[i] != null)
					model.setActSeaTmHrs(actSeaTmHrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfBuffSpd[i] != null)
					model.setPfBuffSpd(pfBuffSpd[i]);
				if (actPortDist[i] != null)
					model.setActPortDist(actPortDist[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (pfSeaSpd[i] != null)
					model.setPfSeaSpd(pfSeaSpd[i]);
				if (estmCsmWgt[i] != null)
					model.setEstmCsmWgt(estmCsmWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (suplWgt[i] != null)
					model.setSuplWgt(suplWgt[i]);
				if (depFoilWgt[i] != null)
					model.setDepFoilWgt(depFoilWgt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (dayCsmWgt[i] != null)
					model.setDayCsmWgt(dayCsmWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pfPortTmHrs[i] != null)
					model.setPfPortTmHrs(pfPortTmHrs[i]);
				if (portTmHrs[i] != null)
					model.setPortTmHrs(portTmHrs[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (seaTmHrs[i] != null)
					model.setSeaTmHrs(seaTmHrs[i]);
				if (sailGnrCsmWgt[i] != null)
					model.setSailGnrCsmWgt(sailGnrCsmWgt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (actPortTmHrs[i] != null)
					model.setActPortTmHrs(actPortTmHrs[i]);
				if (sailMeCsmWgt[i] != null)
					model.setSailMeCsmWgt(sailMeCsmWgt[i]);
				if (portCsmWgt[i] != null)
					model.setPortCsmWgt(portCsmWgt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (trndLineNo[i] != null)
					model.setTrndLineNo(trndLineNo[i]);
				if (depLowSulpFoilWgt[i] != null)
					model.setDepLowSulpFoilWgt(depLowSulpFoilWgt[i]);
				if (fcmSimDt[i] != null)
					model.setFcmSimDt(fcmSimDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBnkReqSimVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BnkReqSimVO[]
	 */
	public BnkReqSimVO[] getBnkReqSimVOs(){
		BnkReqSimVO[] vos = (BnkReqSimVO[])models.toArray(new BnkReqSimVO[models.size()]);
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
		this.trndLineTpCd = this.trndLineTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaSpd = this.seaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmSimCd = this.fcmSimCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmSimSeq = this.fcmSimSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgCsmWgt = this.avgCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfPortDist = this.pfPortDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSeaTmHrs = this.pfSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSeaTmHrs = this.actSeaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfBuffSpd = this.pfBuffSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortDist = this.actPortDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSeaSpd = this.pfSeaSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCsmWgt = this.estmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suplWgt = this.suplWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilWgt = this.depFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayCsmWgt = this.dayCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfPortTmHrs = this.pfPortTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTmHrs = this.portTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaTmHrs = this.seaTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailGnrCsmWgt = this.sailGnrCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPortTmHrs = this.actPortTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailMeCsmWgt = this.sailMeCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCsmWgt = this.portCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineNo = this.trndLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilWgt = this.depLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmSimDt = this.fcmSimDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
