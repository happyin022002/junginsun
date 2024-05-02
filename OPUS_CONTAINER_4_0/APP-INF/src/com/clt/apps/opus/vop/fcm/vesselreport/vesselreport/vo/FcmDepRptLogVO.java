/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmDepRptLogVO.java
*@FileTitle : FcmDepRptLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.27 진마리아 
* 1.0 Creation
* 
* 2014.04.08 박다은 [CHM-201429498] [FCM] Vessel Report Status-Departure Report VMS I/F rule 변경 관련 조치
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmDepRptLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmDepRptLogVO> models = new ArrayList<FcmDepRptLogVO>();

	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String pltInDt = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String depRobCtnt = null;
	/* Column Info */
	private String seaDnst = null;
	/* Column Info */
	private String bfrBrthAnkDrpDt = null;
	/* Column Info */
	private String foSlgWgt = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sbEngDt = null;
	/* Column Info */
	private String blkCgoTpCd1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String avgRpmPwr = null;
	/* Column Info */
	private String pltOutDt = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String depRpmUusdTo = null;
	/* Column Info */
	private String blkCgoTtlWgt = null;
	/* Column Info */
	private String incnrSlgWgt = null;
	/* Column Info */
	private String depLat = null;
	/* Column Info */
	private String depDplWgt = null;
	/* Column Info */
	private String foilPurfDchgItval = null;
	/* Column Info */
	private String bfrBrthAnkOffDt = null;
	/* Column Info */
	private String rmnSdgWgt = null;
	/* Column Info */
	private String arrLon = null;
	/* Column Info */
	private String rmnAvgSpd = null;
	/* Column Info */
	private String blkLodDchgStsCd = null;
	/* Column Info */
	private String dplSlgWgt = null;
	/* Column Info */
	private String depCgoWgt = null;
	/* Column Info */
	private String arrBlrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String mnvrInMlDist = null;
	/* Column Info */
	private String ttlSlgWgt = null;
	/* Column Info */
	private String rupDt = null;
	/* Column Info */
	private String depDrftCtnt = null;
	/* Column Info */
	private String arrEngMl = null;
	/* Column Info */
	private String cgoWrkEndDt = null;
	/* Column Info */
	private String arrMnFoilCsmQty = null;
	/* Column Info */
	private String arrSailHrs = null;
	/* Column Info */
	private String depLon = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String nvgtMlDist = null;
	/* Column Info */
	private String nxtDrftCtnt = null;
	/* Column Info */
	private String arrBlrFoilCsmQty = null;
	/* Column Info */
	private String nxtRobCtnt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String depArrPltMgnHrs = null;
	/* Column Info */
	private String aftUnbrthAnkOffDt = null;
	/* Column Info */
	private String depRpmMaxPwr = null;
	/* Column Info */
	private String cgoWrkStDt = null;
	/* Column Info */
	private String cntrCgoCtnt = null;
	/* Column Info */
	private String aftUnbrthAnkDrpDt = null;
	/* Column Info */
	private String mnvrOutMlDist = null;
	/* Column Info */
	private String depRpmMinPwr = null;
	/* Column Info */
	private String arrDoilCsmQty = null;
	/* Column Info */
	private String arrGnrFoilCsmQty = null;
	/* Column Info */
	private String arrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String arrNvgtMl = null;
	/* Column Info */
	private String arrMnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String gmtTdHrs = null;
	/* Column Info */
	private String arrGnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String depRmk = null;
	/* Column Info */
	private String rmnDist = null;
	/* Column Info */
	private String arrRpmPwr = null;
	/* Column Info */
	private String portFuelCsmCtnt = null;
	/* Column Info */
	private String seaFuelCsmCtnt = null;
	/* Column Info */
	private String engMlDist = null;
	/* Column Info */
	private String detRsnCtnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String splOilCtnt = null;
	/* Column Info */
	private String cfEngNm = null;
	/* Column Info */
	private String nxtPortEtaDt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String portLowSulpFuelCsmCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String depStsCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String blkCgoTpCd2 = null;
	/* Column Info */
	private String blkCgoTpCd3 = null;
	/* Column Info */
	private String eaiIfRmk = null;
	/* Column Info */
	private String blkCgoTpCd4 = null;
	/* Column Info */
	private String blkCgoTpCd5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String runHrsInHvWe = null;
	/* Column Info */
	private String voyDirCd = null;
	/* Column Info */
	private String depRpmUusdFm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String depRsnForMgnTm = null;
	/* Column Info */
	private String arrDrftCtnt = null;
	/* Column Info */
	private String blkHldLoadCtnt = null;
	/* Column Info */
	private String arrLat = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String dplSlgSp = null;
	/* Column Info */
	private String arrRobCtnt = null;
	/* Column Info */
	private String splLowSulpOilCtnt = null;
	/* Column Info */
	private String avgSpd = null;
	/* Column Info */
	private String seaLowSulpFuelCsmCtnt = null;
	/* Column Info */
	private String depArrPltMgnMnts = null;
	/* Column Info */
	private String depRpmPwr = null;
	/* Column Info */
	private String vslRptTjTpCd = null;
	/* Column Info */
	private String oldVslCd = null;
	/* Column Info */
	private String oldVoyDirCd = null;
	/* Column Info */
	private String oldVslSlanCd = null;
	/* Column Info */
	private String oldDepPortCd = null;
	/* Column Info */
	private String oldClptIndSeq = null;		
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmDepRptLogVO() {}

	public FcmDepRptLogVO(String rcvDt, String rcvSeq,String ibflag, String pagerows, String vslCd, String voyDirCd, String vslSlanCd, String depPortCd, String clptIndSeq, String gmtTdHrs, String nxtPortCd, String nxtPortEtaDt, String rmnDist, String rmnAvgSpd, String arrDrftCtnt, String depDrftCtnt, String nxtDrftCtnt, String arrRobCtnt, String depRobCtnt, String nxtRobCtnt, String splOilCtnt, String nvgtMlDist, String avgSpd, String avgRpmPwr, String blkLodDchgStsCd, String blkCgoTpCd1, String blkHldLoadCtnt, String sbEngDt, String pltInDt, String vpsEtbDt, String cgoWrkStDt, String cgoWrkEndDt, String vpsEtdDt, String pltOutDt, String rupDt, String depRmk, String depStsCd, String runHrsInHvWe, String seaDnst, String detRsnCtnt, String engMlDist, String mnvrInMlDist, String mnvrOutMlDist, String blkCgoTtlWgt, String bfrBrthAnkDrpDt, String bfrBrthAnkOffDt, String aftUnbrthAnkDrpDt, String aftUnbrthAnkOffDt, String seaFuelCsmCtnt, String portFuelCsmCtnt, String refNo, String cntrCgoCtnt, String blkCgoTpCd2, String blkCgoTpCd3, String blkCgoTpCd4, String blkCgoTpCd5, String seaLowSulpFuelCsmCtnt, String portLowSulpFuelCsmCtnt, String splLowSulpOilCtnt, String depCgoWgt, String depDplWgt, String ttlSlgWgt, String foSlgWgt, String incnrSlgWgt, String dplSlgWgt, String dplSlgSp, String rmnSdgWgt, String foilPurfDchgItval, String capNm, String cfEngNm, String depLat, String depLon, String depRpmPwr, String depRpmMaxPwr, String depRpmMinPwr, String depRpmUusdFm, String depRpmUusdTo, String depArrPltMgnHrs, String depArrPltMgnMnts, String depRsnForMgnTm, String arrLat, String arrLon, String arrSailHrs, String arrNvgtMl, String arrEngMl, String arrRpmPwr, String arrMnFoilCsmQty, String arrMnLowSulpFoilCsmQty, String arrGnrFoilCsmQty, String arrGnrLowSulpFoilCsmQty, String arrBlrFoilCsmQty, String arrBlrLowSulpFoilCsmQty, String arrDoilCsmQty, String arrLowSulpDoilCsmQty, String eaiIfId, String ifFlg, String eaiIfRmk, String creUsrId, String creDt, String updUsrId, String updDt, String vslRptTjTpCd, String oldVslCd, String oldVoyDirCd, String oldVslSlanCd, String oldDepPortCd, String oldClptIndSeq) {
		this.rcvDt = rcvDt;
		this.pltInDt = pltInDt;
		this.rcvSeq = rcvSeq;
		this.depRobCtnt = depRobCtnt;
		this.seaDnst = seaDnst;
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
		this.foSlgWgt = foSlgWgt;
		this.nxtPortCd = nxtPortCd;
		this.pagerows = pagerows;
		this.sbEngDt = sbEngDt;
		this.blkCgoTpCd1 = blkCgoTpCd1;
		this.updUsrId = updUsrId;
		this.capNm = capNm;
		this.avgRpmPwr = avgRpmPwr;
		this.pltOutDt = pltOutDt;
		this.ifFlg = ifFlg;
		this.depRpmUusdTo = depRpmUusdTo;
		this.blkCgoTtlWgt = blkCgoTtlWgt;
		this.incnrSlgWgt = incnrSlgWgt;
		this.depLat = depLat;
		this.depDplWgt = depDplWgt;
		this.foilPurfDchgItval = foilPurfDchgItval;
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
		this.rmnSdgWgt = rmnSdgWgt;
		this.arrLon = arrLon;
		this.rmnAvgSpd = rmnAvgSpd;
		this.blkLodDchgStsCd = blkLodDchgStsCd;
		this.dplSlgWgt = dplSlgWgt;
		this.depCgoWgt = depCgoWgt;
		this.arrBlrLowSulpFoilCsmQty = arrBlrLowSulpFoilCsmQty;
		this.mnvrInMlDist = mnvrInMlDist;
		this.ttlSlgWgt = ttlSlgWgt;
		this.rupDt = rupDt;
		this.depDrftCtnt = depDrftCtnt;
		this.arrEngMl = arrEngMl;
		this.cgoWrkEndDt = cgoWrkEndDt;
		this.arrMnFoilCsmQty = arrMnFoilCsmQty;
		this.arrSailHrs = arrSailHrs;
		this.depLon = depLon;
		this.refNo = refNo;
		this.nvgtMlDist = nvgtMlDist;
		this.nxtDrftCtnt = nxtDrftCtnt;
		this.arrBlrFoilCsmQty = arrBlrFoilCsmQty;
		this.nxtRobCtnt = nxtRobCtnt;
		this.vslCd = vslCd;
		this.depArrPltMgnHrs = depArrPltMgnHrs;
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
		this.depRpmMaxPwr = depRpmMaxPwr;
		this.cgoWrkStDt = cgoWrkStDt;
		this.cntrCgoCtnt = cntrCgoCtnt;
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
		this.mnvrOutMlDist = mnvrOutMlDist;
		this.depRpmMinPwr = depRpmMinPwr;
		this.arrDoilCsmQty = arrDoilCsmQty;
		this.arrGnrFoilCsmQty = arrGnrFoilCsmQty;
		this.arrLowSulpDoilCsmQty = arrLowSulpDoilCsmQty;
		this.arrNvgtMl = arrNvgtMl;
		this.arrMnLowSulpFoilCsmQty = arrMnLowSulpFoilCsmQty;
		this.vpsEtdDt = vpsEtdDt;
		this.gmtTdHrs = gmtTdHrs;
		this.arrGnrLowSulpFoilCsmQty = arrGnrLowSulpFoilCsmQty;
		this.depRmk = depRmk;
		this.rmnDist = rmnDist;
		this.arrRpmPwr = arrRpmPwr;
		this.portFuelCsmCtnt = portFuelCsmCtnt;
		this.seaFuelCsmCtnt = seaFuelCsmCtnt;
		this.engMlDist = engMlDist;
		this.detRsnCtnt = detRsnCtnt;
		this.creUsrId = creUsrId;
		this.splOilCtnt = splOilCtnt;
		this.cfEngNm = cfEngNm;
		this.nxtPortEtaDt = nxtPortEtaDt;
		this.clptIndSeq = clptIndSeq;
		this.portLowSulpFuelCsmCtnt = portLowSulpFuelCsmCtnt;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.depStsCd = depStsCd;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtbDt = vpsEtbDt;
		this.blkCgoTpCd2 = blkCgoTpCd2;
		this.blkCgoTpCd3 = blkCgoTpCd3;
		this.eaiIfRmk = eaiIfRmk;
		this.blkCgoTpCd4 = blkCgoTpCd4;
		this.blkCgoTpCd5 = blkCgoTpCd5;
		this.ibflag = ibflag;
		this.runHrsInHvWe = runHrsInHvWe;
		this.voyDirCd = voyDirCd;
		this.depRpmUusdFm = depRpmUusdFm;
		this.updDt = updDt;
		this.depRsnForMgnTm = depRsnForMgnTm;
		this.arrDrftCtnt = arrDrftCtnt;
		this.blkHldLoadCtnt = blkHldLoadCtnt;
		this.arrLat = arrLat;
		this.depPortCd = depPortCd;
		this.dplSlgSp = dplSlgSp;
		this.arrRobCtnt = arrRobCtnt;
		this.splLowSulpOilCtnt = splLowSulpOilCtnt;
		this.avgSpd = avgSpd;
		this.seaLowSulpFuelCsmCtnt = seaLowSulpFuelCsmCtnt;
		this.depArrPltMgnMnts = depArrPltMgnMnts;
		this.depRpmPwr = depRpmPwr;
		this.vslRptTjTpCd = vslRptTjTpCd;
		this.oldVslCd		  = oldVslCd	 ;
		this.oldVoyDirCd      = oldVoyDirCd  ; 
		this.oldVslSlanCd     = oldVslSlanCd ; 
		this.oldDepPortCd     = oldDepPortCd ; 
		this.oldClptIndSeq    = oldClptIndSeq; 
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("plt_in_dt", getPltInDt());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("dep_rob_ctnt", getDepRobCtnt());
		this.hashColumns.put("sea_dnst", getSeaDnst());
		this.hashColumns.put("bfr_brth_ank_drp_dt", getBfrBrthAnkDrpDt());
		this.hashColumns.put("fo_slg_wgt", getFoSlgWgt());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sb_eng_dt", getSbEngDt());
		this.hashColumns.put("blk_cgo_tp_cd1", getBlkCgoTpCd1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("avg_rpm_pwr", getAvgRpmPwr());
		this.hashColumns.put("plt_out_dt", getPltOutDt());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("dep_rpm_uusd_to", getDepRpmUusdTo());
		this.hashColumns.put("blk_cgo_ttl_wgt", getBlkCgoTtlWgt());
		this.hashColumns.put("incnr_slg_wgt", getIncnrSlgWgt());
		this.hashColumns.put("dep_lat", getDepLat());
		this.hashColumns.put("dep_dpl_wgt", getDepDplWgt());
		this.hashColumns.put("foil_purf_dchg_itval", getFoilPurfDchgItval());
		this.hashColumns.put("bfr_brth_ank_off_dt", getBfrBrthAnkOffDt());
		this.hashColumns.put("rmn_sdg_wgt", getRmnSdgWgt());
		this.hashColumns.put("arr_lon", getArrLon());
		this.hashColumns.put("rmn_avg_spd", getRmnAvgSpd());
		this.hashColumns.put("blk_lod_dchg_sts_cd", getBlkLodDchgStsCd());
		this.hashColumns.put("dpl_slg_wgt", getDplSlgWgt());
		this.hashColumns.put("dep_cgo_wgt", getDepCgoWgt());
		this.hashColumns.put("arr_blr_low_sulp_foil_csm_qty", getArrBlrLowSulpFoilCsmQty());
		this.hashColumns.put("mnvr_in_ml_dist", getMnvrInMlDist());
		this.hashColumns.put("ttl_slg_wgt", getTtlSlgWgt());
		this.hashColumns.put("rup_dt", getRupDt());
		this.hashColumns.put("dep_drft_ctnt", getDepDrftCtnt());
		this.hashColumns.put("arr_eng_ml", getArrEngMl());
		this.hashColumns.put("cgo_wrk_end_dt", getCgoWrkEndDt());
		this.hashColumns.put("arr_mn_foil_csm_qty", getArrMnFoilCsmQty());
		this.hashColumns.put("arr_sail_hrs", getArrSailHrs());
		this.hashColumns.put("dep_lon", getDepLon());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("nvgt_ml_dist", getNvgtMlDist());
		this.hashColumns.put("nxt_drft_ctnt", getNxtDrftCtnt());
		this.hashColumns.put("arr_blr_foil_csm_qty", getArrBlrFoilCsmQty());
		this.hashColumns.put("nxt_rob_ctnt", getNxtRobCtnt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dep_arr_plt_mgn_hrs", getDepArrPltMgnHrs());
		this.hashColumns.put("aft_unbrth_ank_off_dt", getAftUnbrthAnkOffDt());
		this.hashColumns.put("dep_rpm_max_pwr", getDepRpmMaxPwr());
		this.hashColumns.put("cgo_wrk_st_dt", getCgoWrkStDt());
		this.hashColumns.put("cntr_cgo_ctnt", getCntrCgoCtnt());
		this.hashColumns.put("aft_unbrth_ank_drp_dt", getAftUnbrthAnkDrpDt());
		this.hashColumns.put("mnvr_out_ml_dist", getMnvrOutMlDist());
		this.hashColumns.put("dep_rpm_min_pwr", getDepRpmMinPwr());
		this.hashColumns.put("arr_doil_csm_qty", getArrDoilCsmQty());
		this.hashColumns.put("arr_gnr_foil_csm_qty", getArrGnrFoilCsmQty());
		this.hashColumns.put("arr_low_sulp_doil_csm_qty", getArrLowSulpDoilCsmQty());
		this.hashColumns.put("arr_nvgt_ml", getArrNvgtMl());
		this.hashColumns.put("arr_mn_low_sulp_foil_csm_qty", getArrMnLowSulpFoilCsmQty());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("gmt_td_hrs", getGmtTdHrs());
		this.hashColumns.put("arr_gnr_low_sulp_foil_csm_qty", getArrGnrLowSulpFoilCsmQty());
		this.hashColumns.put("dep_rmk", getDepRmk());
		this.hashColumns.put("rmn_dist", getRmnDist());
		this.hashColumns.put("arr_rpm_pwr", getArrRpmPwr());
		this.hashColumns.put("port_fuel_csm_ctnt", getPortFuelCsmCtnt());
		this.hashColumns.put("sea_fuel_csm_ctnt", getSeaFuelCsmCtnt());
		this.hashColumns.put("eng_ml_dist", getEngMlDist());
		this.hashColumns.put("det_rsn_ctnt", getDetRsnCtnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spl_oil_ctnt", getSplOilCtnt());
		this.hashColumns.put("cf_eng_nm", getCfEngNm());
		this.hashColumns.put("nxt_port_eta_dt", getNxtPortEtaDt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("port_low_sulp_fuel_csm_ctnt", getPortLowSulpFuelCsmCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("dep_sts_cd", getDepStsCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("blk_cgo_tp_cd2", getBlkCgoTpCd2());
		this.hashColumns.put("blk_cgo_tp_cd3", getBlkCgoTpCd3());
		this.hashColumns.put("eai_if_rmk", getEaiIfRmk());
		this.hashColumns.put("blk_cgo_tp_cd4", getBlkCgoTpCd4());
		this.hashColumns.put("blk_cgo_tp_cd5", getBlkCgoTpCd5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("run_hrs_in_hv_we", getRunHrsInHvWe());
		this.hashColumns.put("voy_dir_cd", getVoyDirCd());
		this.hashColumns.put("dep_rpm_uusd_fm", getDepRpmUusdFm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dep_rsn_for_mgn_tm", getDepRsnForMgnTm());
		this.hashColumns.put("arr_drft_ctnt", getArrDrftCtnt());
		this.hashColumns.put("blk_hld_load_ctnt", getBlkHldLoadCtnt());
		this.hashColumns.put("arr_lat", getArrLat());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("dpl_slg_sp", getDplSlgSp());
		this.hashColumns.put("arr_rob_ctnt", getArrRobCtnt());
		this.hashColumns.put("spl_low_sulp_oil_ctnt", getSplLowSulpOilCtnt());
		this.hashColumns.put("avg_spd", getAvgSpd());
		this.hashColumns.put("sea_low_sulp_fuel_csm_ctnt", getSeaLowSulpFuelCsmCtnt());
		this.hashColumns.put("dep_arr_plt_mgn_mnts", getDepArrPltMgnMnts());
		this.hashColumns.put("dep_rpm_pwr", getDepRpmPwr());
		this.hashColumns.put("vsl_rpt_tj_tp_cd", getVslRptTjTpCd());
		this.hashColumns.put("old_vsl_cd", getOldVslCd());
		this.hashColumns.put("old_voy_dir_cd", getOldVoyDirCd());
		this.hashColumns.put("old_vsl_slan_cd", getOldVslSlanCd());
		this.hashColumns.put("old_dep_port_cd", getOldDepPortCd());
		this.hashColumns.put("old_clpt_ind_seq", getOldClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("plt_in_dt", "pltInDt");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("dep_rob_ctnt", "depRobCtnt");
		this.hashFields.put("sea_dnst", "seaDnst");
		this.hashFields.put("bfr_brth_ank_drp_dt", "bfrBrthAnkDrpDt");
		this.hashFields.put("fo_slg_wgt", "foSlgWgt");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sb_eng_dt", "sbEngDt");
		this.hashFields.put("blk_cgo_tp_cd1", "blkCgoTpCd1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("avg_rpm_pwr", "avgRpmPwr");
		this.hashFields.put("plt_out_dt", "pltOutDt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("dep_rpm_uusd_to", "depRpmUusdTo");
		this.hashFields.put("blk_cgo_ttl_wgt", "blkCgoTtlWgt");
		this.hashFields.put("incnr_slg_wgt", "incnrSlgWgt");
		this.hashFields.put("dep_lat", "depLat");
		this.hashFields.put("dep_dpl_wgt", "depDplWgt");
		this.hashFields.put("foil_purf_dchg_itval", "foilPurfDchgItval");
		this.hashFields.put("bfr_brth_ank_off_dt", "bfrBrthAnkOffDt");
		this.hashFields.put("rmn_sdg_wgt", "rmnSdgWgt");
		this.hashFields.put("arr_lon", "arrLon");
		this.hashFields.put("rmn_avg_spd", "rmnAvgSpd");
		this.hashFields.put("blk_lod_dchg_sts_cd", "blkLodDchgStsCd");
		this.hashFields.put("dpl_slg_wgt", "dplSlgWgt");
		this.hashFields.put("dep_cgo_wgt", "depCgoWgt");
		this.hashFields.put("arr_blr_low_sulp_foil_csm_qty", "arrBlrLowSulpFoilCsmQty");
		this.hashFields.put("mnvr_in_ml_dist", "mnvrInMlDist");
		this.hashFields.put("ttl_slg_wgt", "ttlSlgWgt");
		this.hashFields.put("rup_dt", "rupDt");
		this.hashFields.put("dep_drft_ctnt", "depDrftCtnt");
		this.hashFields.put("arr_eng_ml", "arrEngMl");
		this.hashFields.put("cgo_wrk_end_dt", "cgoWrkEndDt");
		this.hashFields.put("arr_mn_foil_csm_qty", "arrMnFoilCsmQty");
		this.hashFields.put("arr_sail_hrs", "arrSailHrs");
		this.hashFields.put("dep_lon", "depLon");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("nvgt_ml_dist", "nvgtMlDist");
		this.hashFields.put("nxt_drft_ctnt", "nxtDrftCtnt");
		this.hashFields.put("arr_blr_foil_csm_qty", "arrBlrFoilCsmQty");
		this.hashFields.put("nxt_rob_ctnt", "nxtRobCtnt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dep_arr_plt_mgn_hrs", "depArrPltMgnHrs");
		this.hashFields.put("aft_unbrth_ank_off_dt", "aftUnbrthAnkOffDt");
		this.hashFields.put("dep_rpm_max_pwr", "depRpmMaxPwr");
		this.hashFields.put("cgo_wrk_st_dt", "cgoWrkStDt");
		this.hashFields.put("cntr_cgo_ctnt", "cntrCgoCtnt");
		this.hashFields.put("aft_unbrth_ank_drp_dt", "aftUnbrthAnkDrpDt");
		this.hashFields.put("mnvr_out_ml_dist", "mnvrOutMlDist");
		this.hashFields.put("dep_rpm_min_pwr", "depRpmMinPwr");
		this.hashFields.put("arr_doil_csm_qty", "arrDoilCsmQty");
		this.hashFields.put("arr_gnr_foil_csm_qty", "arrGnrFoilCsmQty");
		this.hashFields.put("arr_low_sulp_doil_csm_qty", "arrLowSulpDoilCsmQty");
		this.hashFields.put("arr_nvgt_ml", "arrNvgtMl");
		this.hashFields.put("arr_mn_low_sulp_foil_csm_qty", "arrMnLowSulpFoilCsmQty");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("gmt_td_hrs", "gmtTdHrs");
		this.hashFields.put("arr_gnr_low_sulp_foil_csm_qty", "arrGnrLowSulpFoilCsmQty");
		this.hashFields.put("dep_rmk", "depRmk");
		this.hashFields.put("rmn_dist", "rmnDist");
		this.hashFields.put("arr_rpm_pwr", "arrRpmPwr");
		this.hashFields.put("port_fuel_csm_ctnt", "portFuelCsmCtnt");
		this.hashFields.put("sea_fuel_csm_ctnt", "seaFuelCsmCtnt");
		this.hashFields.put("eng_ml_dist", "engMlDist");
		this.hashFields.put("det_rsn_ctnt", "detRsnCtnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spl_oil_ctnt", "splOilCtnt");
		this.hashFields.put("cf_eng_nm", "cfEngNm");
		this.hashFields.put("nxt_port_eta_dt", "nxtPortEtaDt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("port_low_sulp_fuel_csm_ctnt", "portLowSulpFuelCsmCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("dep_sts_cd", "depStsCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("blk_cgo_tp_cd2", "blkCgoTpCd2");
		this.hashFields.put("blk_cgo_tp_cd3", "blkCgoTpCd3");
		this.hashFields.put("eai_if_rmk", "eaiIfRmk");
		this.hashFields.put("blk_cgo_tp_cd4", "blkCgoTpCd4");
		this.hashFields.put("blk_cgo_tp_cd5", "blkCgoTpCd5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("run_hrs_in_hv_we", "runHrsInHvWe");
		this.hashFields.put("voy_dir_cd", "voyDirCd");
		this.hashFields.put("dep_rpm_uusd_fm", "depRpmUusdFm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dep_rsn_for_mgn_tm", "depRsnForMgnTm");
		this.hashFields.put("arr_drft_ctnt", "arrDrftCtnt");
		this.hashFields.put("blk_hld_load_ctnt", "blkHldLoadCtnt");
		this.hashFields.put("arr_lat", "arrLat");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("dpl_slg_sp", "dplSlgSp");
		this.hashFields.put("arr_rob_ctnt", "arrRobCtnt");
		this.hashFields.put("spl_low_sulp_oil_ctnt", "splLowSulpOilCtnt");
		this.hashFields.put("avg_spd", "avgSpd");
		this.hashFields.put("sea_low_sulp_fuel_csm_ctnt", "seaLowSulpFuelCsmCtnt");
		this.hashFields.put("dep_arr_plt_mgn_mnts", "depArrPltMgnMnts");
		this.hashFields.put("dep_rpm_pwr", "depRpmPwr");
		this.hashFields.put("vsl_rpt_tj_tp_cd", "vslRptTjTpCd");
		this.hashFields.put("old_vsl_cd", "oldVslCd");
		this.hashFields.put("old_voy_dir_cd", "oldVoyDirCd");
		this.hashFields.put("old_vsl_slan_cd", "oldVslSlanCd");
		this.hashFields.put("old_dep_port_cd", "oldDepPortCd");
		this.hashFields.put("old_clpt_ind_seq", "oldClptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pltInDt
	 */
	public String getPltInDt() {
		return this.pltInDt;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return depRobCtnt
	 */
	public String getDepRobCtnt() {
		return this.depRobCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaDnst
	 */
	public String getSeaDnst() {
		return this.seaDnst;
	}
	
	/**
	 * Column Info
	 * @return bfrBrthAnkDrpDt
	 */
	public String getBfrBrthAnkDrpDt() {
		return this.bfrBrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return foSlgWgt
	 */
	public String getFoSlgWgt() {
		return this.foSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
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
	 * @return sbEngDt
	 */
	public String getSbEngDt() {
		return this.sbEngDt;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd1
	 */
	public String getBlkCgoTpCd1() {
		return this.blkCgoTpCd1;
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
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
	}
	
	/**
	 * Column Info
	 * @return avgRpmPwr
	 */
	public String getAvgRpmPwr() {
		return this.avgRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return pltOutDt
	 */
	public String getPltOutDt() {
		return this.pltOutDt;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return depRpmUusdTo
	 */
	public String getDepRpmUusdTo() {
		return this.depRpmUusdTo;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTtlWgt
	 */
	public String getBlkCgoTtlWgt() {
		return this.blkCgoTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return incnrSlgWgt
	 */
	public String getIncnrSlgWgt() {
		return this.incnrSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return depLat
	 */
	public String getDepLat() {
		return this.depLat;
	}
	
	/**
	 * Column Info
	 * @return depDplWgt
	 */
	public String getDepDplWgt() {
		return this.depDplWgt;
	}
	
	/**
	 * Column Info
	 * @return foilPurfDchgItval
	 */
	public String getFoilPurfDchgItval() {
		return this.foilPurfDchgItval;
	}
	
	/**
	 * Column Info
	 * @return bfrBrthAnkOffDt
	 */
	public String getBfrBrthAnkOffDt() {
		return this.bfrBrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @return rmnSdgWgt
	 */
	public String getRmnSdgWgt() {
		return this.rmnSdgWgt;
	}
	
	/**
	 * Column Info
	 * @return arrLon
	 */
	public String getArrLon() {
		return this.arrLon;
	}
	
	/**
	 * Column Info
	 * @return rmnAvgSpd
	 */
	public String getRmnAvgSpd() {
		return this.rmnAvgSpd;
	}
	
	/**
	 * Column Info
	 * @return blkLodDchgStsCd
	 */
	public String getBlkLodDchgStsCd() {
		return this.blkLodDchgStsCd;
	}
	
	/**
	 * Column Info
	 * @return dplSlgWgt
	 */
	public String getDplSlgWgt() {
		return this.dplSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return depCgoWgt
	 */
	public String getDepCgoWgt() {
		return this.depCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return arrBlrLowSulpFoilCsmQty
	 */
	public String getArrBlrLowSulpFoilCsmQty() {
		return this.arrBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return mnvrInMlDist
	 */
	public String getMnvrInMlDist() {
		return this.mnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @return ttlSlgWgt
	 */
	public String getTtlSlgWgt() {
		return this.ttlSlgWgt;
	}
	
	/**
	 * Column Info
	 * @return rupDt
	 */
	public String getRupDt() {
		return this.rupDt;
	}
	
	/**
	 * Column Info
	 * @return depDrftCtnt
	 */
	public String getDepDrftCtnt() {
		return this.depDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrEngMl
	 */
	public String getArrEngMl() {
		return this.arrEngMl;
	}
	
	/**
	 * Column Info
	 * @return cgoWrkEndDt
	 */
	public String getCgoWrkEndDt() {
		return this.cgoWrkEndDt;
	}
	
	/**
	 * Column Info
	 * @return arrMnFoilCsmQty
	 */
	public String getArrMnFoilCsmQty() {
		return this.arrMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrSailHrs
	 */
	public String getArrSailHrs() {
		return this.arrSailHrs;
	}
	
	/**
	 * Column Info
	 * @return depLon
	 */
	public String getDepLon() {
		return this.depLon;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
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
	 * @return nxtDrftCtnt
	 */
	public String getNxtDrftCtnt() {
		return this.nxtDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrBlrFoilCsmQty
	 */
	public String getArrBlrFoilCsmQty() {
		return this.arrBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return nxtRobCtnt
	 */
	public String getNxtRobCtnt() {
		return this.nxtRobCtnt;
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
	 * @return depArrPltMgnHrs
	 */
	public String getDepArrPltMgnHrs() {
		return this.depArrPltMgnHrs;
	}
	
	/**
	 * Column Info
	 * @return aftUnbrthAnkOffDt
	 */
	public String getAftUnbrthAnkOffDt() {
		return this.aftUnbrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @return depRpmMaxPwr
	 */
	public String getDepRpmMaxPwr() {
		return this.depRpmMaxPwr;
	}
	
	/**
	 * Column Info
	 * @return cgoWrkStDt
	 */
	public String getCgoWrkStDt() {
		return this.cgoWrkStDt;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoCtnt
	 */
	public String getCntrCgoCtnt() {
		return this.cntrCgoCtnt;
	}
	
	/**
	 * Column Info
	 * @return aftUnbrthAnkDrpDt
	 */
	public String getAftUnbrthAnkDrpDt() {
		return this.aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutMlDist
	 */
	public String getMnvrOutMlDist() {
		return this.mnvrOutMlDist;
	}
	
	/**
	 * Column Info
	 * @return depRpmMinPwr
	 */
	public String getDepRpmMinPwr() {
		return this.depRpmMinPwr;
	}
	
	/**
	 * Column Info
	 * @return arrDoilCsmQty
	 */
	public String getArrDoilCsmQty() {
		return this.arrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrGnrFoilCsmQty
	 */
	public String getArrGnrFoilCsmQty() {
		return this.arrGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpDoilCsmQty
	 */
	public String getArrLowSulpDoilCsmQty() {
		return this.arrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrNvgtMl
	 */
	public String getArrNvgtMl() {
		return this.arrNvgtMl;
	}
	
	/**
	 * Column Info
	 * @return arrMnLowSulpFoilCsmQty
	 */
	public String getArrMnLowSulpFoilCsmQty() {
		return this.arrMnLowSulpFoilCsmQty;
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
	 * @return gmtTdHrs
	 */
	public String getGmtTdHrs() {
		return this.gmtTdHrs;
	}
	
	/**
	 * Column Info
	 * @return arrGnrLowSulpFoilCsmQty
	 */
	public String getArrGnrLowSulpFoilCsmQty() {
		return this.arrGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depRmk
	 */
	public String getDepRmk() {
		return this.depRmk;
	}
	
	/**
	 * Column Info
	 * @return rmnDist
	 */
	public String getRmnDist() {
		return this.rmnDist;
	}
	
	/**
	 * Column Info
	 * @return arrRpmPwr
	 */
	public String getArrRpmPwr() {
		return this.arrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return portFuelCsmCtnt
	 */
	public String getPortFuelCsmCtnt() {
		return this.portFuelCsmCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaFuelCsmCtnt
	 */
	public String getSeaFuelCsmCtnt() {
		return this.seaFuelCsmCtnt;
	}
	
	/**
	 * Column Info
	 * @return engMlDist
	 */
	public String getEngMlDist() {
		return this.engMlDist;
	}
	
	/**
	 * Column Info
	 * @return detRsnCtnt
	 */
	public String getDetRsnCtnt() {
		return this.detRsnCtnt;
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
	 * @return splOilCtnt
	 */
	public String getSplOilCtnt() {
		return this.splOilCtnt;
	}
	
	/**
	 * Column Info
	 * @return cfEngNm
	 */
	public String getCfEngNm() {
		return this.cfEngNm;
	}
	
	/**
	 * Column Info
	 * @return nxtPortEtaDt
	 */
	public String getNxtPortEtaDt() {
		return this.nxtPortEtaDt;
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
	 * @return portLowSulpFuelCsmCtnt
	 */
	public String getPortLowSulpFuelCsmCtnt() {
		return this.portLowSulpFuelCsmCtnt;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return depStsCd
	 */
	public String getDepStsCd() {
		return this.depStsCd;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd2
	 */
	public String getBlkCgoTpCd2() {
		return this.blkCgoTpCd2;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd3
	 */
	public String getBlkCgoTpCd3() {
		return this.blkCgoTpCd3;
	}
	
	/**
	 * Column Info
	 * @return eaiIfRmk
	 */
	public String getEaiIfRmk() {
		return this.eaiIfRmk;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd4
	 */
	public String getBlkCgoTpCd4() {
		return this.blkCgoTpCd4;
	}
	
	/**
	 * Column Info
	 * @return blkCgoTpCd5
	 */
	public String getBlkCgoTpCd5() {
		return this.blkCgoTpCd5;
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
	 * @return runHrsInHvWe
	 */
	public String getRunHrsInHvWe() {
		return this.runHrsInHvWe;
	}
	
	/**
	 * Column Info
	 * @return voyDirCd
	 */
	public String getVoyDirCd() {
		return this.voyDirCd;
	}
	
	/**
	 * Column Info
	 * @return depRpmUusdFm
	 */
	public String getDepRpmUusdFm() {
		return this.depRpmUusdFm;
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
	 * @return depRsnForMgnTm
	 */
	public String getDepRsnForMgnTm() {
		return this.depRsnForMgnTm;
	}
	
	/**
	 * Column Info
	 * @return arrDrftCtnt
	 */
	public String getArrDrftCtnt() {
		return this.arrDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @return blkHldLoadCtnt
	 */
	public String getBlkHldLoadCtnt() {
		return this.blkHldLoadCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrLat
	 */
	public String getArrLat() {
		return this.arrLat;
	}
	
	/**
	 * Column Info
	 * @return depPortCd
	 */
	public String getDepPortCd() {
		return this.depPortCd;
	}
	
	/**
	 * Column Info
	 * @return dplSlgSp
	 */
	public String getDplSlgSp() {
		return this.dplSlgSp;
	}
	
	/**
	 * Column Info
	 * @return arrRobCtnt
	 */
	public String getArrRobCtnt() {
		return this.arrRobCtnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpOilCtnt
	 */
	public String getSplLowSulpOilCtnt() {
		return this.splLowSulpOilCtnt;
	}
	
	/**
	 * Column Info
	 * @return avgSpd
	 */
	public String getAvgSpd() {
		return this.avgSpd;
	}
	
	/**
	 * Column Info
	 * @return seaLowSulpFuelCsmCtnt
	 */
	public String getSeaLowSulpFuelCsmCtnt() {
		return this.seaLowSulpFuelCsmCtnt;
	}
	
	/**
	 * Column Info
	 * @return depArrPltMgnMnts
	 */
	public String getDepArrPltMgnMnts() {
		return this.depArrPltMgnMnts;
	}
	
	/**
	 * Column Info
	 * @return depRpmPwr
	 */
	public String getDepRpmPwr() {
		return this.depRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return vslRptTjTpCd
	 */
	public String getVslRptTjTpCd() {
		return this.vslRptTjTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldVslCd
	 */
	public String getOldVslCd() {
		return this.oldVslCd;
	}
	
	/**
	 * Column Info
	 * @return oldVoyDirCd
	 */
	public String getOldVoyDirCd() {
		return this.oldVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @return oldVslSlanCd
	 */
	public String getOldVslSlanCd() {
		return this.oldVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return oldDepPortCd
	 */
	public String getOldDepPortCd() {
		return this.oldDepPortCd;
	}
	
	/**
	 * Column Info
	 * @return oldClptIndSeq
	 */
	public String getOldClptIndSeq() {
		return this.oldClptIndSeq;
	}

	/**
	 * Column Info
	 * @param pltInDt
	 */
	public void setPltInDt(String pltInDt) {
		this.pltInDt = pltInDt;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param depRobCtnt
	 */
	public void setDepRobCtnt(String depRobCtnt) {
		this.depRobCtnt = depRobCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaDnst
	 */
	public void setSeaDnst(String seaDnst) {
		this.seaDnst = seaDnst;
	}
	
	/**
	 * Column Info
	 * @param bfrBrthAnkDrpDt
	 */
	public void setBfrBrthAnkDrpDt(String bfrBrthAnkDrpDt) {
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param foSlgWgt
	 */
	public void setFoSlgWgt(String foSlgWgt) {
		this.foSlgWgt = foSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
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
	 * @param sbEngDt
	 */
	public void setSbEngDt(String sbEngDt) {
		this.sbEngDt = sbEngDt;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd1
	 */
	public void setBlkCgoTpCd1(String blkCgoTpCd1) {
		this.blkCgoTpCd1 = blkCgoTpCd1;
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
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}
	
	/**
	 * Column Info
	 * @param avgRpmPwr
	 */
	public void setAvgRpmPwr(String avgRpmPwr) {
		this.avgRpmPwr = avgRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param pltOutDt
	 */
	public void setPltOutDt(String pltOutDt) {
		this.pltOutDt = pltOutDt;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param depRpmUusdTo
	 */
	public void setDepRpmUusdTo(String depRpmUusdTo) {
		this.depRpmUusdTo = depRpmUusdTo;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTtlWgt
	 */
	public void setBlkCgoTtlWgt(String blkCgoTtlWgt) {
		this.blkCgoTtlWgt = blkCgoTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param incnrSlgWgt
	 */
	public void setIncnrSlgWgt(String incnrSlgWgt) {
		this.incnrSlgWgt = incnrSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param depLat
	 */
	public void setDepLat(String depLat) {
		this.depLat = depLat;
	}
	
	/**
	 * Column Info
	 * @param depDplWgt
	 */
	public void setDepDplWgt(String depDplWgt) {
		this.depDplWgt = depDplWgt;
	}
	
	/**
	 * Column Info
	 * @param foilPurfDchgItval
	 */
	public void setFoilPurfDchgItval(String foilPurfDchgItval) {
		this.foilPurfDchgItval = foilPurfDchgItval;
	}
	
	/**
	 * Column Info
	 * @param bfrBrthAnkOffDt
	 */
	public void setBfrBrthAnkOffDt(String bfrBrthAnkOffDt) {
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @param rmnSdgWgt
	 */
	public void setRmnSdgWgt(String rmnSdgWgt) {
		this.rmnSdgWgt = rmnSdgWgt;
	}
	
	/**
	 * Column Info
	 * @param arrLon
	 */
	public void setArrLon(String arrLon) {
		this.arrLon = arrLon;
	}
	
	/**
	 * Column Info
	 * @param rmnAvgSpd
	 */
	public void setRmnAvgSpd(String rmnAvgSpd) {
		this.rmnAvgSpd = rmnAvgSpd;
	}
	
	/**
	 * Column Info
	 * @param blkLodDchgStsCd
	 */
	public void setBlkLodDchgStsCd(String blkLodDchgStsCd) {
		this.blkLodDchgStsCd = blkLodDchgStsCd;
	}
	
	/**
	 * Column Info
	 * @param dplSlgWgt
	 */
	public void setDplSlgWgt(String dplSlgWgt) {
		this.dplSlgWgt = dplSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param depCgoWgt
	 */
	public void setDepCgoWgt(String depCgoWgt) {
		this.depCgoWgt = depCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param arrBlrLowSulpFoilCsmQty
	 */
	public void setArrBlrLowSulpFoilCsmQty(String arrBlrLowSulpFoilCsmQty) {
		this.arrBlrLowSulpFoilCsmQty = arrBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param mnvrInMlDist
	 */
	public void setMnvrInMlDist(String mnvrInMlDist) {
		this.mnvrInMlDist = mnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @param ttlSlgWgt
	 */
	public void setTtlSlgWgt(String ttlSlgWgt) {
		this.ttlSlgWgt = ttlSlgWgt;
	}
	
	/**
	 * Column Info
	 * @param rupDt
	 */
	public void setRupDt(String rupDt) {
		this.rupDt = rupDt;
	}
	
	/**
	 * Column Info
	 * @param depDrftCtnt
	 */
	public void setDepDrftCtnt(String depDrftCtnt) {
		this.depDrftCtnt = depDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrEngMl
	 */
	public void setArrEngMl(String arrEngMl) {
		this.arrEngMl = arrEngMl;
	}
	
	/**
	 * Column Info
	 * @param cgoWrkEndDt
	 */
	public void setCgoWrkEndDt(String cgoWrkEndDt) {
		this.cgoWrkEndDt = cgoWrkEndDt;
	}
	
	/**
	 * Column Info
	 * @param arrMnFoilCsmQty
	 */
	public void setArrMnFoilCsmQty(String arrMnFoilCsmQty) {
		this.arrMnFoilCsmQty = arrMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrSailHrs
	 */
	public void setArrSailHrs(String arrSailHrs) {
		this.arrSailHrs = arrSailHrs;
	}
	
	/**
	 * Column Info
	 * @param depLon
	 */
	public void setDepLon(String depLon) {
		this.depLon = depLon;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
	 * @param nxtDrftCtnt
	 */
	public void setNxtDrftCtnt(String nxtDrftCtnt) {
		this.nxtDrftCtnt = nxtDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrBlrFoilCsmQty
	 */
	public void setArrBlrFoilCsmQty(String arrBlrFoilCsmQty) {
		this.arrBlrFoilCsmQty = arrBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param nxtRobCtnt
	 */
	public void setNxtRobCtnt(String nxtRobCtnt) {
		this.nxtRobCtnt = nxtRobCtnt;
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
	 * @param depArrPltMgnHrs
	 */
	public void setDepArrPltMgnHrs(String depArrPltMgnHrs) {
		this.depArrPltMgnHrs = depArrPltMgnHrs;
	}
	
	/**
	 * Column Info
	 * @param aftUnbrthAnkOffDt
	 */
	public void setAftUnbrthAnkOffDt(String aftUnbrthAnkOffDt) {
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @param depRpmMaxPwr
	 */
	public void setDepRpmMaxPwr(String depRpmMaxPwr) {
		this.depRpmMaxPwr = depRpmMaxPwr;
	}
	
	/**
	 * Column Info
	 * @param cgoWrkStDt
	 */
	public void setCgoWrkStDt(String cgoWrkStDt) {
		this.cgoWrkStDt = cgoWrkStDt;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoCtnt
	 */
	public void setCntrCgoCtnt(String cntrCgoCtnt) {
		this.cntrCgoCtnt = cntrCgoCtnt;
	}
	
	/**
	 * Column Info
	 * @param aftUnbrthAnkDrpDt
	 */
	public void setAftUnbrthAnkDrpDt(String aftUnbrthAnkDrpDt) {
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutMlDist
	 */
	public void setMnvrOutMlDist(String mnvrOutMlDist) {
		this.mnvrOutMlDist = mnvrOutMlDist;
	}
	
	/**
	 * Column Info
	 * @param depRpmMinPwr
	 */
	public void setDepRpmMinPwr(String depRpmMinPwr) {
		this.depRpmMinPwr = depRpmMinPwr;
	}
	
	/**
	 * Column Info
	 * @param arrDoilCsmQty
	 */
	public void setArrDoilCsmQty(String arrDoilCsmQty) {
		this.arrDoilCsmQty = arrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrGnrFoilCsmQty
	 */
	public void setArrGnrFoilCsmQty(String arrGnrFoilCsmQty) {
		this.arrGnrFoilCsmQty = arrGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpDoilCsmQty
	 */
	public void setArrLowSulpDoilCsmQty(String arrLowSulpDoilCsmQty) {
		this.arrLowSulpDoilCsmQty = arrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrNvgtMl
	 */
	public void setArrNvgtMl(String arrNvgtMl) {
		this.arrNvgtMl = arrNvgtMl;
	}
	
	/**
	 * Column Info
	 * @param arrMnLowSulpFoilCsmQty
	 */
	public void setArrMnLowSulpFoilCsmQty(String arrMnLowSulpFoilCsmQty) {
		this.arrMnLowSulpFoilCsmQty = arrMnLowSulpFoilCsmQty;
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
	 * @param gmtTdHrs
	 */
	public void setGmtTdHrs(String gmtTdHrs) {
		this.gmtTdHrs = gmtTdHrs;
	}
	
	/**
	 * Column Info
	 * @param arrGnrLowSulpFoilCsmQty
	 */
	public void setArrGnrLowSulpFoilCsmQty(String arrGnrLowSulpFoilCsmQty) {
		this.arrGnrLowSulpFoilCsmQty = arrGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depRmk
	 */
	public void setDepRmk(String depRmk) {
		this.depRmk = depRmk;
	}
	
	/**
	 * Column Info
	 * @param rmnDist
	 */
	public void setRmnDist(String rmnDist) {
		this.rmnDist = rmnDist;
	}
	
	/**
	 * Column Info
	 * @param arrRpmPwr
	 */
	public void setArrRpmPwr(String arrRpmPwr) {
		this.arrRpmPwr = arrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param portFuelCsmCtnt
	 */
	public void setPortFuelCsmCtnt(String portFuelCsmCtnt) {
		this.portFuelCsmCtnt = portFuelCsmCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaFuelCsmCtnt
	 */
	public void setSeaFuelCsmCtnt(String seaFuelCsmCtnt) {
		this.seaFuelCsmCtnt = seaFuelCsmCtnt;
	}
	
	/**
	 * Column Info
	 * @param engMlDist
	 */
	public void setEngMlDist(String engMlDist) {
		this.engMlDist = engMlDist;
	}
	
	/**
	 * Column Info
	 * @param detRsnCtnt
	 */
	public void setDetRsnCtnt(String detRsnCtnt) {
		this.detRsnCtnt = detRsnCtnt;
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
	 * @param splOilCtnt
	 */
	public void setSplOilCtnt(String splOilCtnt) {
		this.splOilCtnt = splOilCtnt;
	}
	
	/**
	 * Column Info
	 * @param cfEngNm
	 */
	public void setCfEngNm(String cfEngNm) {
		this.cfEngNm = cfEngNm;
	}
	
	/**
	 * Column Info
	 * @param nxtPortEtaDt
	 */
	public void setNxtPortEtaDt(String nxtPortEtaDt) {
		this.nxtPortEtaDt = nxtPortEtaDt;
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
	 * @param portLowSulpFuelCsmCtnt
	 */
	public void setPortLowSulpFuelCsmCtnt(String portLowSulpFuelCsmCtnt) {
		this.portLowSulpFuelCsmCtnt = portLowSulpFuelCsmCtnt;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param depStsCd
	 */
	public void setDepStsCd(String depStsCd) {
		this.depStsCd = depStsCd;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd2
	 */
	public void setBlkCgoTpCd2(String blkCgoTpCd2) {
		this.blkCgoTpCd2 = blkCgoTpCd2;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd3
	 */
	public void setBlkCgoTpCd3(String blkCgoTpCd3) {
		this.blkCgoTpCd3 = blkCgoTpCd3;
	}
	
	/**
	 * Column Info
	 * @param eaiIfRmk
	 */
	public void setEaiIfRmk(String eaiIfRmk) {
		this.eaiIfRmk = eaiIfRmk;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd4
	 */
	public void setBlkCgoTpCd4(String blkCgoTpCd4) {
		this.blkCgoTpCd4 = blkCgoTpCd4;
	}
	
	/**
	 * Column Info
	 * @param blkCgoTpCd5
	 */
	public void setBlkCgoTpCd5(String blkCgoTpCd5) {
		this.blkCgoTpCd5 = blkCgoTpCd5;
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
	 * @param runHrsInHvWe
	 */
	public void setRunHrsInHvWe(String runHrsInHvWe) {
		this.runHrsInHvWe = runHrsInHvWe;
	}
	
	/**
	 * Column Info
	 * @param voyDirCd
	 */
	public void setVoyDirCd(String voyDirCd) {
		this.voyDirCd = voyDirCd;
	}
	
	/**
	 * Column Info
	 * @param depRpmUusdFm
	 */
	public void setDepRpmUusdFm(String depRpmUusdFm) {
		this.depRpmUusdFm = depRpmUusdFm;
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
	 * @param depRsnForMgnTm
	 */
	public void setDepRsnForMgnTm(String depRsnForMgnTm) {
		this.depRsnForMgnTm = depRsnForMgnTm;
	}
	
	/**
	 * Column Info
	 * @param arrDrftCtnt
	 */
	public void setArrDrftCtnt(String arrDrftCtnt) {
		this.arrDrftCtnt = arrDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @param blkHldLoadCtnt
	 */
	public void setBlkHldLoadCtnt(String blkHldLoadCtnt) {
		this.blkHldLoadCtnt = blkHldLoadCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrLat
	 */
	public void setArrLat(String arrLat) {
		this.arrLat = arrLat;
	}
	
	/**
	 * Column Info
	 * @param depPortCd
	 */
	public void setDepPortCd(String depPortCd) {
		this.depPortCd = depPortCd;
	}
	
	/**
	 * Column Info
	 * @param dplSlgSp
	 */
	public void setDplSlgSp(String dplSlgSp) {
		this.dplSlgSp = dplSlgSp;
	}
	
	/**
	 * Column Info
	 * @param arrRobCtnt
	 */
	public void setArrRobCtnt(String arrRobCtnt) {
		this.arrRobCtnt = arrRobCtnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpOilCtnt
	 */
	public void setSplLowSulpOilCtnt(String splLowSulpOilCtnt) {
		this.splLowSulpOilCtnt = splLowSulpOilCtnt;
	}
	
	/**
	 * Column Info
	 * @param avgSpd
	 */
	public void setAvgSpd(String avgSpd) {
		this.avgSpd = avgSpd;
	}
	
	/**
	 * Column Info
	 * @param seaLowSulpFuelCsmCtnt
	 */
	public void setSeaLowSulpFuelCsmCtnt(String seaLowSulpFuelCsmCtnt) {
		this.seaLowSulpFuelCsmCtnt = seaLowSulpFuelCsmCtnt;
	}
	
	/**
	 * Column Info
	 * @param depArrPltMgnMnts
	 */
	public void setDepArrPltMgnMnts(String depArrPltMgnMnts) {
		this.depArrPltMgnMnts = depArrPltMgnMnts;
	}
	
	/**
	 * Column Info
	 * @param depRpmPwr
	 */
	public void setDepRpmPwr(String depRpmPwr) {
		this.depRpmPwr = depRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param vslRptTjTpCd
	 */
	public void setVslRptTjTpCd(String vslRptTjTpCd) {
		this.vslRptTjTpCd = vslRptTjTpCd;
	}
	
	/**
	 * Column Info
	 * @param oldVslCd
	 */
	public void setOldVslCd(String oldVslCd) {
		this.oldVslCd = oldVslCd;
	}
	/**
	 * Column Info
	 * @param oldVoyDirCd
	 */
	public void setOldVoyDirCd(String oldVoyDirCd) {
		this.oldVoyDirCd = oldVoyDirCd;
	}
	/**
	 * Column Info
	 * @param oldVslSlanCd
	 */
	public void setOldVslSlanCd(String oldVslSlanCd) {
		this.oldVslSlanCd = oldVslSlanCd;
	}
	/**
	 * Column Info
	 * @param oldDepPortCd
	 */
	public void setOldDepPortCd(String oldDepPortCd) {
		this.oldDepPortCd = oldDepPortCd;
	}
	/**
	 * Column Info
	 * @param oldClptIndSeq
	 */
	public void setOldClptIndSeq(String oldClptIndSeq) {
		this.oldClptIndSeq = oldClptIndSeq;
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
		setPltInDt(JSPUtil.getParameter(request, prefix + "plt_in_dt", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setDepRobCtnt(JSPUtil.getParameter(request, prefix + "dep_rob_ctnt", ""));
		setSeaDnst(JSPUtil.getParameter(request, prefix + "sea_dnst", ""));
		setBfrBrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_drp_dt", ""));
		setFoSlgWgt(JSPUtil.getParameter(request, prefix + "fo_slg_wgt", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSbEngDt(JSPUtil.getParameter(request, prefix + "sb_eng_dt", ""));
		setBlkCgoTpCd1(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setAvgRpmPwr(JSPUtil.getParameter(request, prefix + "avg_rpm_pwr", ""));
		setPltOutDt(JSPUtil.getParameter(request, prefix + "plt_out_dt", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setDepRpmUusdTo(JSPUtil.getParameter(request, prefix + "dep_rpm_uusd_to", ""));
		setBlkCgoTtlWgt(JSPUtil.getParameter(request, prefix + "blk_cgo_ttl_wgt", ""));
		setIncnrSlgWgt(JSPUtil.getParameter(request, prefix + "incnr_slg_wgt", ""));
		setDepLat(JSPUtil.getParameter(request, prefix + "dep_lat", ""));
		setDepDplWgt(JSPUtil.getParameter(request, prefix + "dep_dpl_wgt", ""));
		setFoilPurfDchgItval(JSPUtil.getParameter(request, prefix + "foil_purf_dchg_itval", ""));
		setBfrBrthAnkOffDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_off_dt", ""));
		setRmnSdgWgt(JSPUtil.getParameter(request, prefix + "rmn_sdg_wgt", ""));
		setArrLon(JSPUtil.getParameter(request, prefix + "arr_lon", ""));
		setRmnAvgSpd(JSPUtil.getParameter(request, prefix + "rmn_avg_spd", ""));
		setBlkLodDchgStsCd(JSPUtil.getParameter(request, prefix + "blk_lod_dchg_sts_cd", ""));
		setDplSlgWgt(JSPUtil.getParameter(request, prefix + "dpl_slg_wgt", ""));
		setDepCgoWgt(JSPUtil.getParameter(request, prefix + "dep_cgo_wgt", ""));
		setArrBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_blr_low_sulp_foil_csm_qty", ""));
		setMnvrInMlDist(JSPUtil.getParameter(request, prefix + "mnvr_in_ml_dist", ""));
		setTtlSlgWgt(JSPUtil.getParameter(request, prefix + "ttl_slg_wgt", ""));
		setRupDt(JSPUtil.getParameter(request, prefix + "rup_dt", ""));
		setDepDrftCtnt(JSPUtil.getParameter(request, prefix + "dep_drft_ctnt", ""));
		setArrEngMl(JSPUtil.getParameter(request, prefix + "arr_eng_ml", ""));
		setCgoWrkEndDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_end_dt", ""));
		setArrMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_mn_foil_csm_qty", ""));
		setArrSailHrs(JSPUtil.getParameter(request, prefix + "arr_sail_hrs", ""));
		setDepLon(JSPUtil.getParameter(request, prefix + "dep_lon", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist", ""));
		setNxtDrftCtnt(JSPUtil.getParameter(request, prefix + "nxt_drft_ctnt", ""));
		setArrBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_blr_foil_csm_qty", ""));
		setNxtRobCtnt(JSPUtil.getParameter(request, prefix + "nxt_rob_ctnt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDepArrPltMgnHrs(JSPUtil.getParameter(request, prefix + "dep_arr_plt_mgn_hrs", ""));
		setAftUnbrthAnkOffDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_off_dt", ""));
		setDepRpmMaxPwr(JSPUtil.getParameter(request, prefix + "dep_rpm_max_pwr", ""));
		setCgoWrkStDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_st_dt", ""));
		setCntrCgoCtnt(JSPUtil.getParameter(request, prefix + "cntr_cgo_ctnt", ""));
		setAftUnbrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_drp_dt", ""));
		setMnvrOutMlDist(JSPUtil.getParameter(request, prefix + "mnvr_out_ml_dist", ""));
		setDepRpmMinPwr(JSPUtil.getParameter(request, prefix + "dep_rpm_min_pwr", ""));
		setArrDoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_doil_csm_qty", ""));
		setArrGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_gnr_foil_csm_qty", ""));
		setArrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_csm_qty", ""));
		setArrNvgtMl(JSPUtil.getParameter(request, prefix + "arr_nvgt_ml", ""));
		setArrMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_mn_low_sulp_foil_csm_qty", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setGmtTdHrs(JSPUtil.getParameter(request, prefix + "gmt_td_hrs", ""));
		setArrGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "arr_gnr_low_sulp_foil_csm_qty", ""));
		setDepRmk(JSPUtil.getParameter(request, prefix + "dep_rmk", ""));
		setRmnDist(JSPUtil.getParameter(request, prefix + "rmn_dist", ""));
		setArrRpmPwr(JSPUtil.getParameter(request, prefix + "arr_rpm_pwr", ""));
		setPortFuelCsmCtnt(JSPUtil.getParameter(request, prefix + "port_fuel_csm_ctnt", ""));
		setSeaFuelCsmCtnt(JSPUtil.getParameter(request, prefix + "sea_fuel_csm_ctnt", ""));
		setEngMlDist(JSPUtil.getParameter(request, prefix + "eng_ml_dist", ""));
		setDetRsnCtnt(JSPUtil.getParameter(request, prefix + "det_rsn_ctnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSplOilCtnt(JSPUtil.getParameter(request, prefix + "spl_oil_ctnt", ""));
		setCfEngNm(JSPUtil.getParameter(request, prefix + "cf_eng_nm", ""));
		setNxtPortEtaDt(JSPUtil.getParameter(request, prefix + "nxt_port_eta_dt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setPortLowSulpFuelCsmCtnt(JSPUtil.getParameter(request, prefix + "port_low_sulp_fuel_csm_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setDepStsCd(JSPUtil.getParameter(request, prefix + "dep_sts_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setBlkCgoTpCd2(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd2", ""));
		setBlkCgoTpCd3(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd3", ""));
		setEaiIfRmk(JSPUtil.getParameter(request, prefix + "eai_if_rmk", ""));
		setBlkCgoTpCd4(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd4", ""));
		setBlkCgoTpCd5(JSPUtil.getParameter(request, prefix + "blk_cgo_tp_cd5", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRunHrsInHvWe(JSPUtil.getParameter(request, prefix + "run_hrs_in_hv_we", ""));
		setVoyDirCd(JSPUtil.getParameter(request, prefix + "voy_dir_cd", ""));
		setDepRpmUusdFm(JSPUtil.getParameter(request, prefix + "dep_rpm_uusd_fm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDepRsnForMgnTm(JSPUtil.getParameter(request, prefix + "dep_rsn_for_mgn_tm", ""));
		setArrDrftCtnt(JSPUtil.getParameter(request, prefix + "arr_drft_ctnt", ""));
		setBlkHldLoadCtnt(JSPUtil.getParameter(request, prefix + "blk_hld_load_ctnt", ""));
		setArrLat(JSPUtil.getParameter(request, prefix + "arr_lat", ""));
		setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
		setDplSlgSp(JSPUtil.getParameter(request, prefix + "dpl_slg_sp", ""));
		setArrRobCtnt(JSPUtil.getParameter(request, prefix + "arr_rob_ctnt", ""));
		setSplLowSulpOilCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_oil_ctnt", ""));
		setAvgSpd(JSPUtil.getParameter(request, prefix + "avg_spd", ""));
		setSeaLowSulpFuelCsmCtnt(JSPUtil.getParameter(request, prefix + "sea_low_sulp_fuel_csm_ctnt", ""));
		setDepArrPltMgnMnts(JSPUtil.getParameter(request, prefix + "dep_arr_plt_mgn_mnts", ""));
		setDepRpmPwr(JSPUtil.getParameter(request, prefix + "dep_rpm_pwr", ""));
		setVslRptTjTpCd(JSPUtil.getParameter(request, prefix + "vsl_rpt_tj_tp_cd", ""));
		setOldVslCd(JSPUtil.getParameter(request, prefix + "old_vsl_cd", ""));
		setOldVoyDirCd(JSPUtil.getParameter(request, prefix + "old_voy_dir_cd", ""));
		setOldVslSlanCd(JSPUtil.getParameter(request, prefix + "old_vsl_slan_cd", ""));
		setOldDepPortCd(JSPUtil.getParameter(request, prefix + "old_dep_port_cd", ""));
		setOldClptIndSeq(JSPUtil.getParameter(request, prefix + "old_clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmDepRptLogVO[]
	 */
	public FcmDepRptLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmDepRptLogVO[]
	 */
	public FcmDepRptLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmDepRptLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pltInDt = (JSPUtil.getParameter(request, prefix	+ "plt_in_dt", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] depRobCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_rob_ctnt", length));
			String[] seaDnst = (JSPUtil.getParameter(request, prefix	+ "sea_dnst", length));
			String[] bfrBrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_drp_dt", length));
			String[] foSlgWgt = (JSPUtil.getParameter(request, prefix	+ "fo_slg_wgt", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sbEngDt = (JSPUtil.getParameter(request, prefix	+ "sb_eng_dt", length));
			String[] blkCgoTpCd1 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd1", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] avgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "avg_rpm_pwr", length));
			String[] pltOutDt = (JSPUtil.getParameter(request, prefix	+ "plt_out_dt", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] depRpmUusdTo = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_uusd_to", length));
			String[] blkCgoTtlWgt = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_ttl_wgt", length));
			String[] incnrSlgWgt = (JSPUtil.getParameter(request, prefix	+ "incnr_slg_wgt", length));
			String[] depLat = (JSPUtil.getParameter(request, prefix	+ "dep_lat", length));
			String[] depDplWgt = (JSPUtil.getParameter(request, prefix	+ "dep_dpl_wgt", length));
			String[] foilPurfDchgItval = (JSPUtil.getParameter(request, prefix	+ "foil_purf_dchg_itval", length));
			String[] bfrBrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_off_dt", length));
			String[] rmnSdgWgt = (JSPUtil.getParameter(request, prefix	+ "rmn_sdg_wgt", length));
			String[] arrLon = (JSPUtil.getParameter(request, prefix	+ "arr_lon", length));
			String[] rmnAvgSpd = (JSPUtil.getParameter(request, prefix	+ "rmn_avg_spd", length));
			String[] blkLodDchgStsCd = (JSPUtil.getParameter(request, prefix	+ "blk_lod_dchg_sts_cd", length));
			String[] dplSlgWgt = (JSPUtil.getParameter(request, prefix	+ "dpl_slg_wgt", length));
			String[] depCgoWgt = (JSPUtil.getParameter(request, prefix	+ "dep_cgo_wgt", length));
			String[] arrBlrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_blr_low_sulp_foil_csm_qty", length));
			String[] mnvrInMlDist = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_ml_dist", length));
			String[] ttlSlgWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_slg_wgt", length));
			String[] rupDt = (JSPUtil.getParameter(request, prefix	+ "rup_dt", length));
			String[] depDrftCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_drft_ctnt", length));
			String[] arrEngMl = (JSPUtil.getParameter(request, prefix	+ "arr_eng_ml", length));
			String[] cgoWrkEndDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_end_dt", length));
			String[] arrMnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_mn_foil_csm_qty", length));
			String[] arrSailHrs = (JSPUtil.getParameter(request, prefix	+ "arr_sail_hrs", length));
			String[] depLon = (JSPUtil.getParameter(request, prefix	+ "dep_lon", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] nvgtMlDist = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist", length));
			String[] nxtDrftCtnt = (JSPUtil.getParameter(request, prefix	+ "nxt_drft_ctnt", length));
			String[] arrBlrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_blr_foil_csm_qty", length));
			String[] nxtRobCtnt = (JSPUtil.getParameter(request, prefix	+ "nxt_rob_ctnt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] depArrPltMgnHrs = (JSPUtil.getParameter(request, prefix	+ "dep_arr_plt_mgn_hrs", length));
			String[] aftUnbrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_off_dt", length));
			String[] depRpmMaxPwr = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_max_pwr", length));
			String[] cgoWrkStDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_st_dt", length));
			String[] cntrCgoCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_ctnt", length));
			String[] aftUnbrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_drp_dt", length));
			String[] mnvrOutMlDist = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_ml_dist", length));
			String[] depRpmMinPwr = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_min_pwr", length));
			String[] arrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_doil_csm_qty", length));
			String[] arrGnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_gnr_foil_csm_qty", length));
			String[] arrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_csm_qty", length));
			String[] arrNvgtMl = (JSPUtil.getParameter(request, prefix	+ "arr_nvgt_ml", length));
			String[] arrMnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_mn_low_sulp_foil_csm_qty", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] gmtTdHrs = (JSPUtil.getParameter(request, prefix	+ "gmt_td_hrs", length));
			String[] arrGnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "arr_gnr_low_sulp_foil_csm_qty", length));
			String[] depRmk = (JSPUtil.getParameter(request, prefix	+ "dep_rmk", length));
			String[] rmnDist = (JSPUtil.getParameter(request, prefix	+ "rmn_dist", length));
			String[] arrRpmPwr = (JSPUtil.getParameter(request, prefix	+ "arr_rpm_pwr", length));
			String[] portFuelCsmCtnt = (JSPUtil.getParameter(request, prefix	+ "port_fuel_csm_ctnt", length));
			String[] seaFuelCsmCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_fuel_csm_ctnt", length));
			String[] engMlDist = (JSPUtil.getParameter(request, prefix	+ "eng_ml_dist", length));
			String[] detRsnCtnt = (JSPUtil.getParameter(request, prefix	+ "det_rsn_ctnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] splOilCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_oil_ctnt", length));
			String[] cfEngNm = (JSPUtil.getParameter(request, prefix	+ "cf_eng_nm", length));
			String[] nxtPortEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta_dt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] portLowSulpFuelCsmCtnt = (JSPUtil.getParameter(request, prefix	+ "port_low_sulp_fuel_csm_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] depStsCd = (JSPUtil.getParameter(request, prefix	+ "dep_sts_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] blkCgoTpCd2 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd2", length));
			String[] blkCgoTpCd3 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd3", length));
			String[] eaiIfRmk = (JSPUtil.getParameter(request, prefix	+ "eai_if_rmk", length));
			String[] blkCgoTpCd4 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd4", length));
			String[] blkCgoTpCd5 = (JSPUtil.getParameter(request, prefix	+ "blk_cgo_tp_cd5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] runHrsInHvWe = (JSPUtil.getParameter(request, prefix	+ "run_hrs_in_hv_we", length));
			String[] voyDirCd = (JSPUtil.getParameter(request, prefix	+ "voy_dir_cd", length));
			String[] depRpmUusdFm = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_uusd_fm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] depRsnForMgnTm = (JSPUtil.getParameter(request, prefix	+ "dep_rsn_for_mgn_tm", length));
			String[] arrDrftCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_drft_ctnt", length));
			String[] blkHldLoadCtnt = (JSPUtil.getParameter(request, prefix	+ "blk_hld_load_ctnt", length));
			String[] arrLat = (JSPUtil.getParameter(request, prefix	+ "arr_lat", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] dplSlgSp = (JSPUtil.getParameter(request, prefix	+ "dpl_slg_sp", length));
			String[] arrRobCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_rob_ctnt", length));
			String[] splLowSulpOilCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_oil_ctnt", length));
			String[] avgSpd = (JSPUtil.getParameter(request, prefix	+ "avg_spd", length));
			String[] seaLowSulpFuelCsmCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_low_sulp_fuel_csm_ctnt", length));
			String[] depArrPltMgnMnts = (JSPUtil.getParameter(request, prefix	+ "dep_arr_plt_mgn_mnts", length));
			String[] depRpmPwr = (JSPUtil.getParameter(request, prefix	+ "dep_rpm_pwr", length));
			String[] vslRptTjTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rpt_tj_tp_cd", length));

			String[] oldVslCd = (JSPUtil.getParameter(request, prefix	+ "old_vsl_cd", length));
			String[] oldVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "old_voy_dir_cd", length));
			String[] oldVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "old_vsl_slan_cd", length));
			String[] oldDepPortCd = (JSPUtil.getParameter(request, prefix	+ "old_dep_port_cd", length));
			String[] oldClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "old_clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmDepRptLogVO();
				if (pltInDt[i] != null)
					model.setPltInDt(pltInDt[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (depRobCtnt[i] != null)
					model.setDepRobCtnt(depRobCtnt[i]);
				if (seaDnst[i] != null)
					model.setSeaDnst(seaDnst[i]);
				if (bfrBrthAnkDrpDt[i] != null)
					model.setBfrBrthAnkDrpDt(bfrBrthAnkDrpDt[i]);
				if (foSlgWgt[i] != null)
					model.setFoSlgWgt(foSlgWgt[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sbEngDt[i] != null)
					model.setSbEngDt(sbEngDt[i]);
				if (blkCgoTpCd1[i] != null)
					model.setBlkCgoTpCd1(blkCgoTpCd1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (avgRpmPwr[i] != null)
					model.setAvgRpmPwr(avgRpmPwr[i]);
				if (pltOutDt[i] != null)
					model.setPltOutDt(pltOutDt[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (depRpmUusdTo[i] != null)
					model.setDepRpmUusdTo(depRpmUusdTo[i]);
				if (blkCgoTtlWgt[i] != null)
					model.setBlkCgoTtlWgt(blkCgoTtlWgt[i]);
				if (incnrSlgWgt[i] != null)
					model.setIncnrSlgWgt(incnrSlgWgt[i]);
				if (depLat[i] != null)
					model.setDepLat(depLat[i]);
				if (depDplWgt[i] != null)
					model.setDepDplWgt(depDplWgt[i]);
				if (foilPurfDchgItval[i] != null)
					model.setFoilPurfDchgItval(foilPurfDchgItval[i]);
				if (bfrBrthAnkOffDt[i] != null)
					model.setBfrBrthAnkOffDt(bfrBrthAnkOffDt[i]);
				if (rmnSdgWgt[i] != null)
					model.setRmnSdgWgt(rmnSdgWgt[i]);
				if (arrLon[i] != null)
					model.setArrLon(arrLon[i]);
				if (rmnAvgSpd[i] != null)
					model.setRmnAvgSpd(rmnAvgSpd[i]);
				if (blkLodDchgStsCd[i] != null)
					model.setBlkLodDchgStsCd(blkLodDchgStsCd[i]);
				if (dplSlgWgt[i] != null)
					model.setDplSlgWgt(dplSlgWgt[i]);
				if (depCgoWgt[i] != null)
					model.setDepCgoWgt(depCgoWgt[i]);
				if (arrBlrLowSulpFoilCsmQty[i] != null)
					model.setArrBlrLowSulpFoilCsmQty(arrBlrLowSulpFoilCsmQty[i]);
				if (mnvrInMlDist[i] != null)
					model.setMnvrInMlDist(mnvrInMlDist[i]);
				if (ttlSlgWgt[i] != null)
					model.setTtlSlgWgt(ttlSlgWgt[i]);
				if (rupDt[i] != null)
					model.setRupDt(rupDt[i]);
				if (depDrftCtnt[i] != null)
					model.setDepDrftCtnt(depDrftCtnt[i]);
				if (arrEngMl[i] != null)
					model.setArrEngMl(arrEngMl[i]);
				if (cgoWrkEndDt[i] != null)
					model.setCgoWrkEndDt(cgoWrkEndDt[i]);
				if (arrMnFoilCsmQty[i] != null)
					model.setArrMnFoilCsmQty(arrMnFoilCsmQty[i]);
				if (arrSailHrs[i] != null)
					model.setArrSailHrs(arrSailHrs[i]);
				if (depLon[i] != null)
					model.setDepLon(depLon[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (nvgtMlDist[i] != null)
					model.setNvgtMlDist(nvgtMlDist[i]);
				if (nxtDrftCtnt[i] != null)
					model.setNxtDrftCtnt(nxtDrftCtnt[i]);
				if (arrBlrFoilCsmQty[i] != null)
					model.setArrBlrFoilCsmQty(arrBlrFoilCsmQty[i]);
				if (nxtRobCtnt[i] != null)
					model.setNxtRobCtnt(nxtRobCtnt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (depArrPltMgnHrs[i] != null)
					model.setDepArrPltMgnHrs(depArrPltMgnHrs[i]);
				if (aftUnbrthAnkOffDt[i] != null)
					model.setAftUnbrthAnkOffDt(aftUnbrthAnkOffDt[i]);
				if (depRpmMaxPwr[i] != null)
					model.setDepRpmMaxPwr(depRpmMaxPwr[i]);
				if (cgoWrkStDt[i] != null)
					model.setCgoWrkStDt(cgoWrkStDt[i]);
				if (cntrCgoCtnt[i] != null)
					model.setCntrCgoCtnt(cntrCgoCtnt[i]);
				if (aftUnbrthAnkDrpDt[i] != null)
					model.setAftUnbrthAnkDrpDt(aftUnbrthAnkDrpDt[i]);
				if (mnvrOutMlDist[i] != null)
					model.setMnvrOutMlDist(mnvrOutMlDist[i]);
				if (depRpmMinPwr[i] != null)
					model.setDepRpmMinPwr(depRpmMinPwr[i]);
				if (arrDoilCsmQty[i] != null)
					model.setArrDoilCsmQty(arrDoilCsmQty[i]);
				if (arrGnrFoilCsmQty[i] != null)
					model.setArrGnrFoilCsmQty(arrGnrFoilCsmQty[i]);
				if (arrLowSulpDoilCsmQty[i] != null)
					model.setArrLowSulpDoilCsmQty(arrLowSulpDoilCsmQty[i]);
				if (arrNvgtMl[i] != null)
					model.setArrNvgtMl(arrNvgtMl[i]);
				if (arrMnLowSulpFoilCsmQty[i] != null)
					model.setArrMnLowSulpFoilCsmQty(arrMnLowSulpFoilCsmQty[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (gmtTdHrs[i] != null)
					model.setGmtTdHrs(gmtTdHrs[i]);
				if (arrGnrLowSulpFoilCsmQty[i] != null)
					model.setArrGnrLowSulpFoilCsmQty(arrGnrLowSulpFoilCsmQty[i]);
				if (depRmk[i] != null)
					model.setDepRmk(depRmk[i]);
				if (rmnDist[i] != null)
					model.setRmnDist(rmnDist[i]);
				if (arrRpmPwr[i] != null)
					model.setArrRpmPwr(arrRpmPwr[i]);
				if (portFuelCsmCtnt[i] != null)
					model.setPortFuelCsmCtnt(portFuelCsmCtnt[i]);
				if (seaFuelCsmCtnt[i] != null)
					model.setSeaFuelCsmCtnt(seaFuelCsmCtnt[i]);
				if (engMlDist[i] != null)
					model.setEngMlDist(engMlDist[i]);
				if (detRsnCtnt[i] != null)
					model.setDetRsnCtnt(detRsnCtnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (splOilCtnt[i] != null)
					model.setSplOilCtnt(splOilCtnt[i]);
				if (cfEngNm[i] != null)
					model.setCfEngNm(cfEngNm[i]);
				if (nxtPortEtaDt[i] != null)
					model.setNxtPortEtaDt(nxtPortEtaDt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (portLowSulpFuelCsmCtnt[i] != null)
					model.setPortLowSulpFuelCsmCtnt(portLowSulpFuelCsmCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (depStsCd[i] != null)
					model.setDepStsCd(depStsCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (blkCgoTpCd2[i] != null)
					model.setBlkCgoTpCd2(blkCgoTpCd2[i]);
				if (blkCgoTpCd3[i] != null)
					model.setBlkCgoTpCd3(blkCgoTpCd3[i]);
				if (eaiIfRmk[i] != null)
					model.setEaiIfRmk(eaiIfRmk[i]);
				if (blkCgoTpCd4[i] != null)
					model.setBlkCgoTpCd4(blkCgoTpCd4[i]);
				if (blkCgoTpCd5[i] != null)
					model.setBlkCgoTpCd5(blkCgoTpCd5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (runHrsInHvWe[i] != null)
					model.setRunHrsInHvWe(runHrsInHvWe[i]);
				if (voyDirCd[i] != null)
					model.setVoyDirCd(voyDirCd[i]);
				if (depRpmUusdFm[i] != null)
					model.setDepRpmUusdFm(depRpmUusdFm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (depRsnForMgnTm[i] != null)
					model.setDepRsnForMgnTm(depRsnForMgnTm[i]);
				if (arrDrftCtnt[i] != null)
					model.setArrDrftCtnt(arrDrftCtnt[i]);
				if (blkHldLoadCtnt[i] != null)
					model.setBlkHldLoadCtnt(blkHldLoadCtnt[i]);
				if (arrLat[i] != null)
					model.setArrLat(arrLat[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (dplSlgSp[i] != null)
					model.setDplSlgSp(dplSlgSp[i]);
				if (arrRobCtnt[i] != null)
					model.setArrRobCtnt(arrRobCtnt[i]);
				if (splLowSulpOilCtnt[i] != null)
					model.setSplLowSulpOilCtnt(splLowSulpOilCtnt[i]);
				if (avgSpd[i] != null)
					model.setAvgSpd(avgSpd[i]);
				if (seaLowSulpFuelCsmCtnt[i] != null)
					model.setSeaLowSulpFuelCsmCtnt(seaLowSulpFuelCsmCtnt[i]);
				if (depArrPltMgnMnts[i] != null)
					model.setDepArrPltMgnMnts(depArrPltMgnMnts[i]);
				if (depRpmPwr[i] != null)
					model.setDepRpmPwr(depRpmPwr[i]);
				if (vslRptTjTpCd[i] != null)
					model.setVslRptTjTpCd(vslRptTjTpCd[i]);

				if (oldVslCd[i] != null)
					model.setOldVslCd(oldVslCd[i]);
				if (oldVoyDirCd[i] != null)
					model.setOldVoyDirCd(oldVoyDirCd[i]);
				if (oldVslSlanCd[i] != null)
					model.setOldVslSlanCd(oldVslSlanCd[i]);
				if (oldDepPortCd[i] != null)
					model.setOldDepPortCd(oldDepPortCd[i]); 
				if (oldClptIndSeq[i] != null)
					model.setOldClptIndSeq(oldClptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmDepRptLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmDepRptLogVO[]
	 */
	public FcmDepRptLogVO[] getFcmDepRptLogVOs(){
		FcmDepRptLogVO[] vos = (FcmDepRptLogVO[])models.toArray(new FcmDepRptLogVO[models.size()]);
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
		this.pltInDt = this.pltInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRobCtnt = this.depRobCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDnst = this.seaDnst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkDrpDt = this.bfrBrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foSlgWgt = this.foSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbEngDt = this.sbEngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd1 = this.blkCgoTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRpmPwr = this.avgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltOutDt = this.pltOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmUusdTo = this.depRpmUusdTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTtlWgt = this.blkCgoTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incnrSlgWgt = this.incnrSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLat = this.depLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDplWgt = this.depDplWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPurfDchgItval = this.foilPurfDchgItval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkOffDt = this.bfrBrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnSdgWgt = this.rmnSdgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLon = this.arrLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnAvgSpd = this.rmnAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkLodDchgStsCd = this.blkLodDchgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dplSlgWgt = this.dplSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depCgoWgt = this.depCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlrLowSulpFoilCsmQty = this.arrBlrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInMlDist = this.mnvrInMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSlgWgt = this.ttlSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rupDt = this.rupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDrftCtnt = this.depDrftCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrEngMl = this.arrEngMl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkEndDt = this.cgoWrkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMnFoilCsmQty = this.arrMnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSailHrs = this.arrSailHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLon = this.depLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDist = this.nvgtMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtDrftCtnt = this.nxtDrftCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlrFoilCsmQty = this.arrBlrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtRobCtnt = this.nxtRobCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depArrPltMgnHrs = this.depArrPltMgnHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkOffDt = this.aftUnbrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmMaxPwr = this.depRpmMaxPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkStDt = this.cgoWrkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoCtnt = this.cntrCgoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkDrpDt = this.aftUnbrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutMlDist = this.mnvrOutMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmMinPwr = this.depRpmMinPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilCsmQty = this.arrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGnrFoilCsmQty = this.arrGnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilCsmQty = this.arrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrNvgtMl = this.arrNvgtMl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMnLowSulpFoilCsmQty = this.arrMnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtTdHrs = this.gmtTdHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGnrLowSulpFoilCsmQty = this.arrGnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRmk = this.depRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnDist = this.rmnDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRpmPwr = this.arrRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portFuelCsmCtnt = this.portFuelCsmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaFuelCsmCtnt = this.seaFuelCsmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engMlDist = this.engMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detRsnCtnt = this.detRsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splOilCtnt = this.splOilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfEngNm = this.cfEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEtaDt = this.nxtPortEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLowSulpFuelCsmCtnt = this.portLowSulpFuelCsmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depStsCd = this.depStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd2 = this.blkCgoTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd3 = this.blkCgoTpCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfRmk = this.eaiIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd4 = this.blkCgoTpCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCgoTpCd5 = this.blkCgoTpCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runHrsInHvWe = this.runHrsInHvWe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDirCd = this.voyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmUusdFm = this.depRpmUusdFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRsnForMgnTm = this.depRsnForMgnTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDrftCtnt = this.arrDrftCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkHldLoadCtnt = this.blkHldLoadCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLat = this.arrLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dplSlgSp = this.dplSlgSp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrRobCtnt = this.arrRobCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpOilCtnt = this.splLowSulpOilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpd = this.avgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaLowSulpFuelCsmCtnt = this.seaLowSulpFuelCsmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depArrPltMgnMnts = this.depArrPltMgnMnts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRpmPwr = this.depRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRptTjTpCd = this.vslRptTjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.oldVslCd = this.oldVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVoyDirCd = this.oldVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVslSlanCd = this.oldVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDepPortCd = this.oldDepPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldClptIndSeq = this.oldClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
