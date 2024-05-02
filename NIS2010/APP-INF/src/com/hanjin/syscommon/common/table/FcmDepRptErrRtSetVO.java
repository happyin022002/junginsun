/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FcmDepRptErrRtSetVO.java
*@FileTitle : FcmDepRptErrRtSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class FcmDepRptErrRtSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmDepRptErrRtSetVO> models = new ArrayList<FcmDepRptErrRtSetVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String aftUnbrthAnkOffDtRt = null;
	/* Column Info */
	private String seaStmngMnEngRt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String portTtlHrRtRt = null;
	/* Column Info */
	private String portTtlRt = null;
	/* Column Info */
	private String ttlCntrObrdTeuRt = null;
	/* Column Info */
	private String bfrBrthAnkDrpDtRt = null;
	/* Column Info */
	private String avgRpmPwrRt = null;
	/* Column Info */
	private String rfCntrLodKntRt = null;
	/* Column Info */
	private String arrLowSulpFoilRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String depCgoRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mcntrObrdTeuRt = null;
	/* Column Info */
	private String depDoilRt = null;
	/* Column Info */
	private String arrFoilRt = null;
	/* Column Info */
	private String depLowSulpDoilRt = null;
	/* Column Info */
	private String rfCntrObrdKntRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rfCntrDchgKntRt = null;
	/* Column Info */
	private String aftUnbrthAnkDrpDtRt = null;
	/* Column Info */
	private String cgoWrkStDtRt = null;
	/* Column Info */
	private String mnvrInMlDistRt = null;
	/* Column Info */
	private String nvgtMlDistRt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String arrDoilRt = null;
	/* Column Info */
	private String bfrBrthAnkOffDtRt = null;
	/* Column Info */
	private String avgSpdRt = null;
	/* Column Info */
	private String depLowSulpFoilRt = null;
	/* Column Info */
	private String fcntrObrdTeuRt = null;
	/* Column Info */
	private String arrLowSulpDoilRt = null;
	/* Column Info */
	private String sbEngDtRt = null;
	/* Column Info */
	private String rupDtRt = null;
	/* Column Info */
	private String vpsEtdDtRt = null;
	/* Column Info */
	private String vpsEtbDtRt = null;
	/* Column Info */
	private String pltOutDtRt = null;
	/* Column Info */
	private String depFoilRt = null;
	/* Column Info */
	private String pltInDtRt = null;
	/* Column Info */
	private String cgoWrkEndDtRt = null;
	/* Column Info */
	private String engMlDistRt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prlrPchRt = null;
	/* Column Info */
	private String sailTmRt = null;
	/* Column Info */
	private String mnvrOutMlDistRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FcmDepRptErrRtSetVO() {}

	public FcmDepRptErrRtSetVO(String ibflag, String pagerows, String vslCd, String nvgtMlDistRt, String engMlDistRt, String mnvrInMlDistRt, String mnvrOutMlDistRt, String avgSpdRt, String avgRpmPwrRt, String prlrPchRt, String sailTmRt, String arrFoilRt, String arrLowSulpFoilRt, String arrDoilRt, String arrLowSulpDoilRt, String depFoilRt, String depLowSulpFoilRt, String depDoilRt, String depLowSulpDoilRt, String seaStmngMnEngRt, String portTtlRt, String portTtlHrRtRt, String sbEngDtRt, String pltInDtRt, String bfrBrthAnkDrpDtRt, String bfrBrthAnkOffDtRt, String vpsEtbDtRt, String cgoWrkStDtRt, String cgoWrkEndDtRt, String vpsEtdDtRt, String aftUnbrthAnkDrpDtRt, String aftUnbrthAnkOffDtRt, String pltOutDtRt, String rupDtRt, String fcntrObrdTeuRt, String mcntrObrdTeuRt, String ttlCntrObrdTeuRt, String depCgoRt, String rfCntrDchgKntRt, String rfCntrLodKntRt, String rfCntrObrdKntRt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.aftUnbrthAnkOffDtRt = aftUnbrthAnkOffDtRt;
		this.seaStmngMnEngRt = seaStmngMnEngRt;
		this.creDt = creDt;
		this.portTtlHrRtRt = portTtlHrRtRt;
		this.portTtlRt = portTtlRt;
		this.ttlCntrObrdTeuRt = ttlCntrObrdTeuRt;
		this.bfrBrthAnkDrpDtRt = bfrBrthAnkDrpDtRt;
		this.avgRpmPwrRt = avgRpmPwrRt;
		this.rfCntrLodKntRt = rfCntrLodKntRt;
		this.arrLowSulpFoilRt = arrLowSulpFoilRt;
		this.pagerows = pagerows;
		this.depCgoRt = depCgoRt;
		this.ibflag = ibflag;
		this.mcntrObrdTeuRt = mcntrObrdTeuRt;
		this.depDoilRt = depDoilRt;
		this.arrFoilRt = arrFoilRt;
		this.depLowSulpDoilRt = depLowSulpDoilRt;
		this.rfCntrObrdKntRt = rfCntrObrdKntRt;
		this.updUsrId = updUsrId;
		this.rfCntrDchgKntRt = rfCntrDchgKntRt;
		this.aftUnbrthAnkDrpDtRt = aftUnbrthAnkDrpDtRt;
		this.cgoWrkStDtRt = cgoWrkStDtRt;
		this.mnvrInMlDistRt = mnvrInMlDistRt;
		this.nvgtMlDistRt = nvgtMlDistRt;
		this.updDt = updDt;
		this.arrDoilRt = arrDoilRt;
		this.bfrBrthAnkOffDtRt = bfrBrthAnkOffDtRt;
		this.avgSpdRt = avgSpdRt;
		this.depLowSulpFoilRt = depLowSulpFoilRt;
		this.fcntrObrdTeuRt = fcntrObrdTeuRt;
		this.arrLowSulpDoilRt = arrLowSulpDoilRt;
		this.sbEngDtRt = sbEngDtRt;
		this.rupDtRt = rupDtRt;
		this.vpsEtdDtRt = vpsEtdDtRt;
		this.vpsEtbDtRt = vpsEtbDtRt;
		this.pltOutDtRt = pltOutDtRt;
		this.depFoilRt = depFoilRt;
		this.pltInDtRt = pltInDtRt;
		this.cgoWrkEndDtRt = cgoWrkEndDtRt;
		this.engMlDistRt = engMlDistRt;
		this.creUsrId = creUsrId;
		this.prlrPchRt = prlrPchRt;
		this.sailTmRt = sailTmRt;
		this.mnvrOutMlDistRt = mnvrOutMlDistRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("aft_unbrth_ank_off_dt_rt", getAftUnbrthAnkOffDtRt());
		this.hashColumns.put("sea_stmng_mn_eng_rt", getSeaStmngMnEngRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("port_ttl_hr_rt_rt", getPortTtlHrRtRt());
		this.hashColumns.put("port_ttl_rt", getPortTtlRt());
		this.hashColumns.put("ttl_cntr_obrd_teu_rt", getTtlCntrObrdTeuRt());
		this.hashColumns.put("bfr_brth_ank_drp_dt_rt", getBfrBrthAnkDrpDtRt());
		this.hashColumns.put("avg_rpm_pwr_rt", getAvgRpmPwrRt());
		this.hashColumns.put("rf_cntr_lod_knt_rt", getRfCntrLodKntRt());
		this.hashColumns.put("arr_low_sulp_foil_rt", getArrLowSulpFoilRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dep_cgo_rt", getDepCgoRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mcntr_obrd_teu_rt", getMcntrObrdTeuRt());
		this.hashColumns.put("dep_doil_rt", getDepDoilRt());
		this.hashColumns.put("arr_foil_rt", getArrFoilRt());
		this.hashColumns.put("dep_low_sulp_doil_rt", getDepLowSulpDoilRt());
		this.hashColumns.put("rf_cntr_obrd_knt_rt", getRfCntrObrdKntRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rf_cntr_dchg_knt_rt", getRfCntrDchgKntRt());
		this.hashColumns.put("aft_unbrth_ank_drp_dt_rt", getAftUnbrthAnkDrpDtRt());
		this.hashColumns.put("cgo_wrk_st_dt_rt", getCgoWrkStDtRt());
		this.hashColumns.put("mnvr_in_ml_dist_rt", getMnvrInMlDistRt());
		this.hashColumns.put("nvgt_ml_dist_rt", getNvgtMlDistRt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("arr_doil_rt", getArrDoilRt());
		this.hashColumns.put("bfr_brth_ank_off_dt_rt", getBfrBrthAnkOffDtRt());
		this.hashColumns.put("avg_spd_rt", getAvgSpdRt());
		this.hashColumns.put("dep_low_sulp_foil_rt", getDepLowSulpFoilRt());
		this.hashColumns.put("fcntr_obrd_teu_rt", getFcntrObrdTeuRt());
		this.hashColumns.put("arr_low_sulp_doil_rt", getArrLowSulpDoilRt());
		this.hashColumns.put("sb_eng_dt_rt", getSbEngDtRt());
		this.hashColumns.put("rup_dt_rt", getRupDtRt());
		this.hashColumns.put("vps_etd_dt_rt", getVpsEtdDtRt());
		this.hashColumns.put("vps_etb_dt_rt", getVpsEtbDtRt());
		this.hashColumns.put("plt_out_dt_rt", getPltOutDtRt());
		this.hashColumns.put("dep_foil_rt", getDepFoilRt());
		this.hashColumns.put("plt_in_dt_rt", getPltInDtRt());
		this.hashColumns.put("cgo_wrk_end_dt_rt", getCgoWrkEndDtRt());
		this.hashColumns.put("eng_ml_dist_rt", getEngMlDistRt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prlr_pch_rt", getPrlrPchRt());
		this.hashColumns.put("sail_tm_rt", getSailTmRt());
		this.hashColumns.put("mnvr_out_ml_dist_rt", getMnvrOutMlDistRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("aft_unbrth_ank_off_dt_rt", "aftUnbrthAnkOffDtRt");
		this.hashFields.put("sea_stmng_mn_eng_rt", "seaStmngMnEngRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("port_ttl_hr_rt_rt", "portTtlHrRtRt");
		this.hashFields.put("port_ttl_rt", "portTtlRt");
		this.hashFields.put("ttl_cntr_obrd_teu_rt", "ttlCntrObrdTeuRt");
		this.hashFields.put("bfr_brth_ank_drp_dt_rt", "bfrBrthAnkDrpDtRt");
		this.hashFields.put("avg_rpm_pwr_rt", "avgRpmPwrRt");
		this.hashFields.put("rf_cntr_lod_knt_rt", "rfCntrLodKntRt");
		this.hashFields.put("arr_low_sulp_foil_rt", "arrLowSulpFoilRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dep_cgo_rt", "depCgoRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mcntr_obrd_teu_rt", "mcntrObrdTeuRt");
		this.hashFields.put("dep_doil_rt", "depDoilRt");
		this.hashFields.put("arr_foil_rt", "arrFoilRt");
		this.hashFields.put("dep_low_sulp_doil_rt", "depLowSulpDoilRt");
		this.hashFields.put("rf_cntr_obrd_knt_rt", "rfCntrObrdKntRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rf_cntr_dchg_knt_rt", "rfCntrDchgKntRt");
		this.hashFields.put("aft_unbrth_ank_drp_dt_rt", "aftUnbrthAnkDrpDtRt");
		this.hashFields.put("cgo_wrk_st_dt_rt", "cgoWrkStDtRt");
		this.hashFields.put("mnvr_in_ml_dist_rt", "mnvrInMlDistRt");
		this.hashFields.put("nvgt_ml_dist_rt", "nvgtMlDistRt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("arr_doil_rt", "arrDoilRt");
		this.hashFields.put("bfr_brth_ank_off_dt_rt", "bfrBrthAnkOffDtRt");
		this.hashFields.put("avg_spd_rt", "avgSpdRt");
		this.hashFields.put("dep_low_sulp_foil_rt", "depLowSulpFoilRt");
		this.hashFields.put("fcntr_obrd_teu_rt", "fcntrObrdTeuRt");
		this.hashFields.put("arr_low_sulp_doil_rt", "arrLowSulpDoilRt");
		this.hashFields.put("sb_eng_dt_rt", "sbEngDtRt");
		this.hashFields.put("rup_dt_rt", "rupDtRt");
		this.hashFields.put("vps_etd_dt_rt", "vpsEtdDtRt");
		this.hashFields.put("vps_etb_dt_rt", "vpsEtbDtRt");
		this.hashFields.put("plt_out_dt_rt", "pltOutDtRt");
		this.hashFields.put("dep_foil_rt", "depFoilRt");
		this.hashFields.put("plt_in_dt_rt", "pltInDtRt");
		this.hashFields.put("cgo_wrk_end_dt_rt", "cgoWrkEndDtRt");
		this.hashFields.put("eng_ml_dist_rt", "engMlDistRt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prlr_pch_rt", "prlrPchRt");
		this.hashFields.put("sail_tm_rt", "sailTmRt");
		this.hashFields.put("mnvr_out_ml_dist_rt", "mnvrOutMlDistRt");
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
	 * @return aftUnbrthAnkOffDtRt
	 */
	public String getAftUnbrthAnkOffDtRt() {
		return this.aftUnbrthAnkOffDtRt;
	}
	
	/**
	 * Column Info
	 * @return seaStmngMnEngRt
	 */
	public String getSeaStmngMnEngRt() {
		return this.seaStmngMnEngRt;
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
	 * @return portTtlHrRtRt
	 */
	public String getPortTtlHrRtRt() {
		return this.portTtlHrRtRt;
	}
	
	/**
	 * Column Info
	 * @return portTtlRt
	 */
	public String getPortTtlRt() {
		return this.portTtlRt;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrObrdTeuRt
	 */
	public String getTtlCntrObrdTeuRt() {
		return this.ttlCntrObrdTeuRt;
	}
	
	/**
	 * Column Info
	 * @return bfrBrthAnkDrpDtRt
	 */
	public String getBfrBrthAnkDrpDtRt() {
		return this.bfrBrthAnkDrpDtRt;
	}
	
	/**
	 * Column Info
	 * @return avgRpmPwrRt
	 */
	public String getAvgRpmPwrRt() {
		return this.avgRpmPwrRt;
	}
	
	/**
	 * Column Info
	 * @return rfCntrLodKntRt
	 */
	public String getRfCntrLodKntRt() {
		return this.rfCntrLodKntRt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpFoilRt
	 */
	public String getArrLowSulpFoilRt() {
		return this.arrLowSulpFoilRt;
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
	 * @return depCgoRt
	 */
	public String getDepCgoRt() {
		return this.depCgoRt;
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
	 * @return mcntrObrdTeuRt
	 */
	public String getMcntrObrdTeuRt() {
		return this.mcntrObrdTeuRt;
	}
	
	/**
	 * Column Info
	 * @return depDoilRt
	 */
	public String getDepDoilRt() {
		return this.depDoilRt;
	}
	
	/**
	 * Column Info
	 * @return arrFoilRt
	 */
	public String getArrFoilRt() {
		return this.arrFoilRt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpDoilRt
	 */
	public String getDepLowSulpDoilRt() {
		return this.depLowSulpDoilRt;
	}
	
	/**
	 * Column Info
	 * @return rfCntrObrdKntRt
	 */
	public String getRfCntrObrdKntRt() {
		return this.rfCntrObrdKntRt;
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
	 * @return rfCntrDchgKntRt
	 */
	public String getRfCntrDchgKntRt() {
		return this.rfCntrDchgKntRt;
	}
	
	/**
	 * Column Info
	 * @return aftUnbrthAnkDrpDtRt
	 */
	public String getAftUnbrthAnkDrpDtRt() {
		return this.aftUnbrthAnkDrpDtRt;
	}
	
	/**
	 * Column Info
	 * @return cgoWrkStDtRt
	 */
	public String getCgoWrkStDtRt() {
		return this.cgoWrkStDtRt;
	}
	
	/**
	 * Column Info
	 * @return mnvrInMlDistRt
	 */
	public String getMnvrInMlDistRt() {
		return this.mnvrInMlDistRt;
	}
	
	/**
	 * Column Info
	 * @return nvgtMlDistRt
	 */
	public String getNvgtMlDistRt() {
		return this.nvgtMlDistRt;
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
	 * @return arrDoilRt
	 */
	public String getArrDoilRt() {
		return this.arrDoilRt;
	}
	
	/**
	 * Column Info
	 * @return bfrBrthAnkOffDtRt
	 */
	public String getBfrBrthAnkOffDtRt() {
		return this.bfrBrthAnkOffDtRt;
	}
	
	/**
	 * Column Info
	 * @return avgSpdRt
	 */
	public String getAvgSpdRt() {
		return this.avgSpdRt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpFoilRt
	 */
	public String getDepLowSulpFoilRt() {
		return this.depLowSulpFoilRt;
	}
	
	/**
	 * Column Info
	 * @return fcntrObrdTeuRt
	 */
	public String getFcntrObrdTeuRt() {
		return this.fcntrObrdTeuRt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpDoilRt
	 */
	public String getArrLowSulpDoilRt() {
		return this.arrLowSulpDoilRt;
	}
	
	/**
	 * Column Info
	 * @return sbEngDtRt
	 */
	public String getSbEngDtRt() {
		return this.sbEngDtRt;
	}
	
	/**
	 * Column Info
	 * @return rupDtRt
	 */
	public String getRupDtRt() {
		return this.rupDtRt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtRt
	 */
	public String getVpsEtdDtRt() {
		return this.vpsEtdDtRt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDtRt
	 */
	public String getVpsEtbDtRt() {
		return this.vpsEtbDtRt;
	}
	
	/**
	 * Column Info
	 * @return pltOutDtRt
	 */
	public String getPltOutDtRt() {
		return this.pltOutDtRt;
	}
	
	/**
	 * Column Info
	 * @return depFoilRt
	 */
	public String getDepFoilRt() {
		return this.depFoilRt;
	}
	
	/**
	 * Column Info
	 * @return pltInDtRt
	 */
	public String getPltInDtRt() {
		return this.pltInDtRt;
	}
	
	/**
	 * Column Info
	 * @return cgoWrkEndDtRt
	 */
	public String getCgoWrkEndDtRt() {
		return this.cgoWrkEndDtRt;
	}
	
	/**
	 * Column Info
	 * @return engMlDistRt
	 */
	public String getEngMlDistRt() {
		return this.engMlDistRt;
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
	 * @return prlrPchRt
	 */
	public String getPrlrPchRt() {
		return this.prlrPchRt;
	}
	
	/**
	 * Column Info
	 * @return sailTmRt
	 */
	public String getSailTmRt() {
		return this.sailTmRt;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutMlDistRt
	 */
	public String getMnvrOutMlDistRt() {
		return this.mnvrOutMlDistRt;
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
	 * @param aftUnbrthAnkOffDtRt
	 */
	public void setAftUnbrthAnkOffDtRt(String aftUnbrthAnkOffDtRt) {
		this.aftUnbrthAnkOffDtRt = aftUnbrthAnkOffDtRt;
	}
	
	/**
	 * Column Info
	 * @param seaStmngMnEngRt
	 */
	public void setSeaStmngMnEngRt(String seaStmngMnEngRt) {
		this.seaStmngMnEngRt = seaStmngMnEngRt;
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
	 * @param portTtlHrRtRt
	 */
	public void setPortTtlHrRtRt(String portTtlHrRtRt) {
		this.portTtlHrRtRt = portTtlHrRtRt;
	}
	
	/**
	 * Column Info
	 * @param portTtlRt
	 */
	public void setPortTtlRt(String portTtlRt) {
		this.portTtlRt = portTtlRt;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrObrdTeuRt
	 */
	public void setTtlCntrObrdTeuRt(String ttlCntrObrdTeuRt) {
		this.ttlCntrObrdTeuRt = ttlCntrObrdTeuRt;
	}
	
	/**
	 * Column Info
	 * @param bfrBrthAnkDrpDtRt
	 */
	public void setBfrBrthAnkDrpDtRt(String bfrBrthAnkDrpDtRt) {
		this.bfrBrthAnkDrpDtRt = bfrBrthAnkDrpDtRt;
	}
	
	/**
	 * Column Info
	 * @param avgRpmPwrRt
	 */
	public void setAvgRpmPwrRt(String avgRpmPwrRt) {
		this.avgRpmPwrRt = avgRpmPwrRt;
	}
	
	/**
	 * Column Info
	 * @param rfCntrLodKntRt
	 */
	public void setRfCntrLodKntRt(String rfCntrLodKntRt) {
		this.rfCntrLodKntRt = rfCntrLodKntRt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpFoilRt
	 */
	public void setArrLowSulpFoilRt(String arrLowSulpFoilRt) {
		this.arrLowSulpFoilRt = arrLowSulpFoilRt;
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
	 * @param depCgoRt
	 */
	public void setDepCgoRt(String depCgoRt) {
		this.depCgoRt = depCgoRt;
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
	 * @param mcntrObrdTeuRt
	 */
	public void setMcntrObrdTeuRt(String mcntrObrdTeuRt) {
		this.mcntrObrdTeuRt = mcntrObrdTeuRt;
	}
	
	/**
	 * Column Info
	 * @param depDoilRt
	 */
	public void setDepDoilRt(String depDoilRt) {
		this.depDoilRt = depDoilRt;
	}
	
	/**
	 * Column Info
	 * @param arrFoilRt
	 */
	public void setArrFoilRt(String arrFoilRt) {
		this.arrFoilRt = arrFoilRt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpDoilRt
	 */
	public void setDepLowSulpDoilRt(String depLowSulpDoilRt) {
		this.depLowSulpDoilRt = depLowSulpDoilRt;
	}
	
	/**
	 * Column Info
	 * @param rfCntrObrdKntRt
	 */
	public void setRfCntrObrdKntRt(String rfCntrObrdKntRt) {
		this.rfCntrObrdKntRt = rfCntrObrdKntRt;
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
	 * @param rfCntrDchgKntRt
	 */
	public void setRfCntrDchgKntRt(String rfCntrDchgKntRt) {
		this.rfCntrDchgKntRt = rfCntrDchgKntRt;
	}
	
	/**
	 * Column Info
	 * @param aftUnbrthAnkDrpDtRt
	 */
	public void setAftUnbrthAnkDrpDtRt(String aftUnbrthAnkDrpDtRt) {
		this.aftUnbrthAnkDrpDtRt = aftUnbrthAnkDrpDtRt;
	}
	
	/**
	 * Column Info
	 * @param cgoWrkStDtRt
	 */
	public void setCgoWrkStDtRt(String cgoWrkStDtRt) {
		this.cgoWrkStDtRt = cgoWrkStDtRt;
	}
	
	/**
	 * Column Info
	 * @param mnvrInMlDistRt
	 */
	public void setMnvrInMlDistRt(String mnvrInMlDistRt) {
		this.mnvrInMlDistRt = mnvrInMlDistRt;
	}
	
	/**
	 * Column Info
	 * @param nvgtMlDistRt
	 */
	public void setNvgtMlDistRt(String nvgtMlDistRt) {
		this.nvgtMlDistRt = nvgtMlDistRt;
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
	 * @param arrDoilRt
	 */
	public void setArrDoilRt(String arrDoilRt) {
		this.arrDoilRt = arrDoilRt;
	}
	
	/**
	 * Column Info
	 * @param bfrBrthAnkOffDtRt
	 */
	public void setBfrBrthAnkOffDtRt(String bfrBrthAnkOffDtRt) {
		this.bfrBrthAnkOffDtRt = bfrBrthAnkOffDtRt;
	}
	
	/**
	 * Column Info
	 * @param avgSpdRt
	 */
	public void setAvgSpdRt(String avgSpdRt) {
		this.avgSpdRt = avgSpdRt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpFoilRt
	 */
	public void setDepLowSulpFoilRt(String depLowSulpFoilRt) {
		this.depLowSulpFoilRt = depLowSulpFoilRt;
	}
	
	/**
	 * Column Info
	 * @param fcntrObrdTeuRt
	 */
	public void setFcntrObrdTeuRt(String fcntrObrdTeuRt) {
		this.fcntrObrdTeuRt = fcntrObrdTeuRt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpDoilRt
	 */
	public void setArrLowSulpDoilRt(String arrLowSulpDoilRt) {
		this.arrLowSulpDoilRt = arrLowSulpDoilRt;
	}
	
	/**
	 * Column Info
	 * @param sbEngDtRt
	 */
	public void setSbEngDtRt(String sbEngDtRt) {
		this.sbEngDtRt = sbEngDtRt;
	}
	
	/**
	 * Column Info
	 * @param rupDtRt
	 */
	public void setRupDtRt(String rupDtRt) {
		this.rupDtRt = rupDtRt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtRt
	 */
	public void setVpsEtdDtRt(String vpsEtdDtRt) {
		this.vpsEtdDtRt = vpsEtdDtRt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDtRt
	 */
	public void setVpsEtbDtRt(String vpsEtbDtRt) {
		this.vpsEtbDtRt = vpsEtbDtRt;
	}
	
	/**
	 * Column Info
	 * @param pltOutDtRt
	 */
	public void setPltOutDtRt(String pltOutDtRt) {
		this.pltOutDtRt = pltOutDtRt;
	}
	
	/**
	 * Column Info
	 * @param depFoilRt
	 */
	public void setDepFoilRt(String depFoilRt) {
		this.depFoilRt = depFoilRt;
	}
	
	/**
	 * Column Info
	 * @param pltInDtRt
	 */
	public void setPltInDtRt(String pltInDtRt) {
		this.pltInDtRt = pltInDtRt;
	}
	
	/**
	 * Column Info
	 * @param cgoWrkEndDtRt
	 */
	public void setCgoWrkEndDtRt(String cgoWrkEndDtRt) {
		this.cgoWrkEndDtRt = cgoWrkEndDtRt;
	}
	
	/**
	 * Column Info
	 * @param engMlDistRt
	 */
	public void setEngMlDistRt(String engMlDistRt) {
		this.engMlDistRt = engMlDistRt;
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
	 * @param prlrPchRt
	 */
	public void setPrlrPchRt(String prlrPchRt) {
		this.prlrPchRt = prlrPchRt;
	}
	
	/**
	 * Column Info
	 * @param sailTmRt
	 */
	public void setSailTmRt(String sailTmRt) {
		this.sailTmRt = sailTmRt;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutMlDistRt
	 */
	public void setMnvrOutMlDistRt(String mnvrOutMlDistRt) {
		this.mnvrOutMlDistRt = mnvrOutMlDistRt;
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
		setAftUnbrthAnkOffDtRt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_off_dt_rt", ""));
		setSeaStmngMnEngRt(JSPUtil.getParameter(request, prefix + "sea_stmng_mn_eng_rt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPortTtlHrRtRt(JSPUtil.getParameter(request, prefix + "port_ttl_hr_rt_rt", ""));
		setPortTtlRt(JSPUtil.getParameter(request, prefix + "port_ttl_rt", ""));
		setTtlCntrObrdTeuRt(JSPUtil.getParameter(request, prefix + "ttl_cntr_obrd_teu_rt", ""));
		setBfrBrthAnkDrpDtRt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_drp_dt_rt", ""));
		setAvgRpmPwrRt(JSPUtil.getParameter(request, prefix + "avg_rpm_pwr_rt", ""));
		setRfCntrLodKntRt(JSPUtil.getParameter(request, prefix + "rf_cntr_lod_knt_rt", ""));
		setArrLowSulpFoilRt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_foil_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDepCgoRt(JSPUtil.getParameter(request, prefix + "dep_cgo_rt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMcntrObrdTeuRt(JSPUtil.getParameter(request, prefix + "mcntr_obrd_teu_rt", ""));
		setDepDoilRt(JSPUtil.getParameter(request, prefix + "dep_doil_rt", ""));
		setArrFoilRt(JSPUtil.getParameter(request, prefix + "arr_foil_rt", ""));
		setDepLowSulpDoilRt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_doil_rt", ""));
		setRfCntrObrdKntRt(JSPUtil.getParameter(request, prefix + "rf_cntr_obrd_knt_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRfCntrDchgKntRt(JSPUtil.getParameter(request, prefix + "rf_cntr_dchg_knt_rt", ""));
		setAftUnbrthAnkDrpDtRt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_drp_dt_rt", ""));
		setCgoWrkStDtRt(JSPUtil.getParameter(request, prefix + "cgo_wrk_st_dt_rt", ""));
		setMnvrInMlDistRt(JSPUtil.getParameter(request, prefix + "mnvr_in_ml_dist_rt", ""));
		setNvgtMlDistRt(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist_rt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setArrDoilRt(JSPUtil.getParameter(request, prefix + "arr_doil_rt", ""));
		setBfrBrthAnkOffDtRt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_off_dt_rt", ""));
		setAvgSpdRt(JSPUtil.getParameter(request, prefix + "avg_spd_rt", ""));
		setDepLowSulpFoilRt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_foil_rt", ""));
		setFcntrObrdTeuRt(JSPUtil.getParameter(request, prefix + "fcntr_obrd_teu_rt", ""));
		setArrLowSulpDoilRt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_rt", ""));
		setSbEngDtRt(JSPUtil.getParameter(request, prefix + "sb_eng_dt_rt", ""));
		setRupDtRt(JSPUtil.getParameter(request, prefix + "rup_dt_rt", ""));
		setVpsEtdDtRt(JSPUtil.getParameter(request, prefix + "vps_etd_dt_rt", ""));
		setVpsEtbDtRt(JSPUtil.getParameter(request, prefix + "vps_etb_dt_rt", ""));
		setPltOutDtRt(JSPUtil.getParameter(request, prefix + "plt_out_dt_rt", ""));
		setDepFoilRt(JSPUtil.getParameter(request, prefix + "dep_foil_rt", ""));
		setPltInDtRt(JSPUtil.getParameter(request, prefix + "plt_in_dt_rt", ""));
		setCgoWrkEndDtRt(JSPUtil.getParameter(request, prefix + "cgo_wrk_end_dt_rt", ""));
		setEngMlDistRt(JSPUtil.getParameter(request, prefix + "eng_ml_dist_rt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPrlrPchRt(JSPUtil.getParameter(request, prefix + "prlr_pch_rt", ""));
		setSailTmRt(JSPUtil.getParameter(request, prefix + "sail_tm_rt", ""));
		setMnvrOutMlDistRt(JSPUtil.getParameter(request, prefix + "mnvr_out_ml_dist_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmDepRptErrRtSetVO[]
	 */
	public FcmDepRptErrRtSetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmDepRptErrRtSetVO[]
	 */
	public FcmDepRptErrRtSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmDepRptErrRtSetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] aftUnbrthAnkOffDtRt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_off_dt_rt", length));
			String[] seaStmngMnEngRt = (JSPUtil.getParameter(request, prefix	+ "sea_stmng_mn_eng_rt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] portTtlHrRtRt = (JSPUtil.getParameter(request, prefix	+ "port_ttl_hr_rt_rt", length));
			String[] portTtlRt = (JSPUtil.getParameter(request, prefix	+ "port_ttl_rt", length));
			String[] ttlCntrObrdTeuRt = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_obrd_teu_rt", length));
			String[] bfrBrthAnkDrpDtRt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_drp_dt_rt", length));
			String[] avgRpmPwrRt = (JSPUtil.getParameter(request, prefix	+ "avg_rpm_pwr_rt", length));
			String[] rfCntrLodKntRt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_lod_knt_rt", length));
			String[] arrLowSulpFoilRt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_foil_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] depCgoRt = (JSPUtil.getParameter(request, prefix	+ "dep_cgo_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mcntrObrdTeuRt = (JSPUtil.getParameter(request, prefix	+ "mcntr_obrd_teu_rt", length));
			String[] depDoilRt = (JSPUtil.getParameter(request, prefix	+ "dep_doil_rt", length));
			String[] arrFoilRt = (JSPUtil.getParameter(request, prefix	+ "arr_foil_rt", length));
			String[] depLowSulpDoilRt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_doil_rt", length));
			String[] rfCntrObrdKntRt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_obrd_knt_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rfCntrDchgKntRt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_dchg_knt_rt", length));
			String[] aftUnbrthAnkDrpDtRt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_drp_dt_rt", length));
			String[] cgoWrkStDtRt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_st_dt_rt", length));
			String[] mnvrInMlDistRt = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_ml_dist_rt", length));
			String[] nvgtMlDistRt = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist_rt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] arrDoilRt = (JSPUtil.getParameter(request, prefix	+ "arr_doil_rt", length));
			String[] bfrBrthAnkOffDtRt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_off_dt_rt", length));
			String[] avgSpdRt = (JSPUtil.getParameter(request, prefix	+ "avg_spd_rt", length));
			String[] depLowSulpFoilRt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_foil_rt", length));
			String[] fcntrObrdTeuRt = (JSPUtil.getParameter(request, prefix	+ "fcntr_obrd_teu_rt", length));
			String[] arrLowSulpDoilRt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_rt", length));
			String[] sbEngDtRt = (JSPUtil.getParameter(request, prefix	+ "sb_eng_dt_rt", length));
			String[] rupDtRt = (JSPUtil.getParameter(request, prefix	+ "rup_dt_rt", length));
			String[] vpsEtdDtRt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_rt", length));
			String[] vpsEtbDtRt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt_rt", length));
			String[] pltOutDtRt = (JSPUtil.getParameter(request, prefix	+ "plt_out_dt_rt", length));
			String[] depFoilRt = (JSPUtil.getParameter(request, prefix	+ "dep_foil_rt", length));
			String[] pltInDtRt = (JSPUtil.getParameter(request, prefix	+ "plt_in_dt_rt", length));
			String[] cgoWrkEndDtRt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_end_dt_rt", length));
			String[] engMlDistRt = (JSPUtil.getParameter(request, prefix	+ "eng_ml_dist_rt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] prlrPchRt = (JSPUtil.getParameter(request, prefix	+ "prlr_pch_rt", length));
			String[] sailTmRt = (JSPUtil.getParameter(request, prefix	+ "sail_tm_rt", length));
			String[] mnvrOutMlDistRt = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_ml_dist_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmDepRptErrRtSetVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (aftUnbrthAnkOffDtRt[i] != null)
					model.setAftUnbrthAnkOffDtRt(aftUnbrthAnkOffDtRt[i]);
				if (seaStmngMnEngRt[i] != null)
					model.setSeaStmngMnEngRt(seaStmngMnEngRt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (portTtlHrRtRt[i] != null)
					model.setPortTtlHrRtRt(portTtlHrRtRt[i]);
				if (portTtlRt[i] != null)
					model.setPortTtlRt(portTtlRt[i]);
				if (ttlCntrObrdTeuRt[i] != null)
					model.setTtlCntrObrdTeuRt(ttlCntrObrdTeuRt[i]);
				if (bfrBrthAnkDrpDtRt[i] != null)
					model.setBfrBrthAnkDrpDtRt(bfrBrthAnkDrpDtRt[i]);
				if (avgRpmPwrRt[i] != null)
					model.setAvgRpmPwrRt(avgRpmPwrRt[i]);
				if (rfCntrLodKntRt[i] != null)
					model.setRfCntrLodKntRt(rfCntrLodKntRt[i]);
				if (arrLowSulpFoilRt[i] != null)
					model.setArrLowSulpFoilRt(arrLowSulpFoilRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (depCgoRt[i] != null)
					model.setDepCgoRt(depCgoRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mcntrObrdTeuRt[i] != null)
					model.setMcntrObrdTeuRt(mcntrObrdTeuRt[i]);
				if (depDoilRt[i] != null)
					model.setDepDoilRt(depDoilRt[i]);
				if (arrFoilRt[i] != null)
					model.setArrFoilRt(arrFoilRt[i]);
				if (depLowSulpDoilRt[i] != null)
					model.setDepLowSulpDoilRt(depLowSulpDoilRt[i]);
				if (rfCntrObrdKntRt[i] != null)
					model.setRfCntrObrdKntRt(rfCntrObrdKntRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rfCntrDchgKntRt[i] != null)
					model.setRfCntrDchgKntRt(rfCntrDchgKntRt[i]);
				if (aftUnbrthAnkDrpDtRt[i] != null)
					model.setAftUnbrthAnkDrpDtRt(aftUnbrthAnkDrpDtRt[i]);
				if (cgoWrkStDtRt[i] != null)
					model.setCgoWrkStDtRt(cgoWrkStDtRt[i]);
				if (mnvrInMlDistRt[i] != null)
					model.setMnvrInMlDistRt(mnvrInMlDistRt[i]);
				if (nvgtMlDistRt[i] != null)
					model.setNvgtMlDistRt(nvgtMlDistRt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (arrDoilRt[i] != null)
					model.setArrDoilRt(arrDoilRt[i]);
				if (bfrBrthAnkOffDtRt[i] != null)
					model.setBfrBrthAnkOffDtRt(bfrBrthAnkOffDtRt[i]);
				if (avgSpdRt[i] != null)
					model.setAvgSpdRt(avgSpdRt[i]);
				if (depLowSulpFoilRt[i] != null)
					model.setDepLowSulpFoilRt(depLowSulpFoilRt[i]);
				if (fcntrObrdTeuRt[i] != null)
					model.setFcntrObrdTeuRt(fcntrObrdTeuRt[i]);
				if (arrLowSulpDoilRt[i] != null)
					model.setArrLowSulpDoilRt(arrLowSulpDoilRt[i]);
				if (sbEngDtRt[i] != null)
					model.setSbEngDtRt(sbEngDtRt[i]);
				if (rupDtRt[i] != null)
					model.setRupDtRt(rupDtRt[i]);
				if (vpsEtdDtRt[i] != null)
					model.setVpsEtdDtRt(vpsEtdDtRt[i]);
				if (vpsEtbDtRt[i] != null)
					model.setVpsEtbDtRt(vpsEtbDtRt[i]);
				if (pltOutDtRt[i] != null)
					model.setPltOutDtRt(pltOutDtRt[i]);
				if (depFoilRt[i] != null)
					model.setDepFoilRt(depFoilRt[i]);
				if (pltInDtRt[i] != null)
					model.setPltInDtRt(pltInDtRt[i]);
				if (cgoWrkEndDtRt[i] != null)
					model.setCgoWrkEndDtRt(cgoWrkEndDtRt[i]);
				if (engMlDistRt[i] != null)
					model.setEngMlDistRt(engMlDistRt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prlrPchRt[i] != null)
					model.setPrlrPchRt(prlrPchRt[i]);
				if (sailTmRt[i] != null)
					model.setSailTmRt(sailTmRt[i]);
				if (mnvrOutMlDistRt[i] != null)
					model.setMnvrOutMlDistRt(mnvrOutMlDistRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmDepRptErrRtSetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmDepRptErrRtSetVO[]
	 */
	public FcmDepRptErrRtSetVO[] getFcmDepRptErrRtSetVOs(){
		FcmDepRptErrRtSetVO[] vos = (FcmDepRptErrRtSetVO[])models.toArray(new FcmDepRptErrRtSetVO[models.size()]);
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
		this.aftUnbrthAnkOffDtRt = this.aftUnbrthAnkOffDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaStmngMnEngRt = this.seaStmngMnEngRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTtlHrRtRt = this.portTtlHrRtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTtlRt = this.portTtlRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrObrdTeuRt = this.ttlCntrObrdTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkDrpDtRt = this.bfrBrthAnkDrpDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRpmPwrRt = this.avgRpmPwrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrLodKntRt = this.rfCntrLodKntRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpFoilRt = this.arrLowSulpFoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depCgoRt = this.depCgoRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrObrdTeuRt = this.mcntrObrdTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDoilRt = this.depDoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFoilRt = this.arrFoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpDoilRt = this.depLowSulpDoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrObrdKntRt = this.rfCntrObrdKntRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrDchgKntRt = this.rfCntrDchgKntRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkDrpDtRt = this.aftUnbrthAnkDrpDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkStDtRt = this.cgoWrkStDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInMlDistRt = this.mnvrInMlDistRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDistRt = this.nvgtMlDistRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilRt = this.arrDoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkOffDtRt = this.bfrBrthAnkOffDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpdRt = this.avgSpdRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilRt = this.depLowSulpFoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrObrdTeuRt = this.fcntrObrdTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilRt = this.arrLowSulpDoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbEngDtRt = this.sbEngDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rupDtRt = this.rupDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtRt = this.vpsEtdDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDtRt = this.vpsEtbDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltOutDtRt = this.pltOutDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilRt = this.depFoilRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltInDtRt = this.pltInDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkEndDtRt = this.cgoWrkEndDtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engMlDistRt = this.engMlDistRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlrPchRt = this.prlrPchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailTmRt = this.sailTmRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutMlDistRt = this.mnvrOutMlDistRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
