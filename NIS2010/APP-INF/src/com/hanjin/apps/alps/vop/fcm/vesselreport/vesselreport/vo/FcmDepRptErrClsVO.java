/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FcmDepRptErrClsVO.java
*@FileTitle : FcmDepRptErrClsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo;

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

public class FcmDepRptErrClsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmDepRptErrClsVO> models = new ArrayList<FcmDepRptErrClsVO>();
	
	/* Column Info */
	private String portBlrLowSulpDoilCtnt = null;
	/* Column Info */
	private String pltInDt = null;
	/* Column Info */
	private String seaGnrLowSulpDoilCtnt = null;
	/* Column Info */
	private String depLowSulpFoilCtnt = null;
	/* Column Info */
	private String splLowSulpDoilBdrCtnt = null;
	/* Column Info */
	private String lstRfCntrObrdKntCtnt = null;
	/* Column Info */
	private String arrLowSulpDoilCtnt = null;
	/* Column Info */
	private String bfrBrthAnkDrpDt = null;
	/* Column Info */
	private String depRptErrTpCd = null;
	/* Column Info */
	private String sailTmHrs = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Column Info */
	private String rmnDistCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String avgMnvrInMlDist = null;
	/* Column Info */
	private String seaMnLowSulpFoilCtnt = null;
	/* Column Info */
	private String portMnLowSulpDoilCtnt = null;
	/* Column Info */
	private String callUiId = null;
	/* Column Info */
	private String depFoilCtnt = null;
	/* Column Info */
	private String fcntrObrdTeuCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String seaGnrFoilCtnt = null;
	/* Column Info */
	private String lstDepDoilCtnt = null;
	/* Column Info */
	private String errItmCtnt = null;
	/* Column Info */
	private String depCgoCtnt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String lstPortRupDt = null;
	/* Column Info */
	private String pltOutDt = null;
	/* Column Info */
	private String avgPortTtlHrQty = null;
	/* Column Info */
	private String seaGnrLowSulpFoilCtnt = null;
	/* Column Info */
	private String portGnrLowSulpFoilCtnt = null;
	/* Column Info */
	private String arrGmCtnt = null;
	/* Column Info */
	private String portMnFoilCtnt = null;
	/* Column Info */
	private String arrFwddrCtnt = null;
	/* Column Info */
	private String avgRpmPwrCtnt = null;
	/* Column Info */
	private String mnvrOutMlDistCtnt = null;
	/* Column Info */
	private String portGnrDoilCtnt = null;
	/* Column Info */
	private String oldVslCd = null;
	/* Column Info */
	private String depGmCtnt = null;
	/* Column Info */
	private String seaGnrDoilCtnt = null;
	/* Column Info */
	private String lstDepLowSulpFoilCtnt = null;
	/* Column Info */
	private String portMnDoilCtnt = null;
	/* Column Info */
	private String bfrBrthAnkOffDt = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String depMidDrftCtnt = null;
	/* Column Info */
	private String seaBlrLowSulpFoilCtnt = null;
	/* Column Info */
	private String splLowSulpDoilActCtnt = null;
	/* Column Info */
	private String splDoilSulpCtnt = null;
	/* Column Info */
	private String arrFoilCtnt = null;
	/* Column Info */
	private String depRptClsSeq = null;
	/* Column Info */
	private String lstDepFoilCtnt = null;
	/* Column Info */
	private String rupDt = null;
	/* Column Info */
	private String splDoilActCtnt = null;
	/* Column Info */
	private String sbEngDt = null;
	/* Column Info */
	private String cgoWrkEndDt = null;
	/* Column Info */
	private String portBlrLowSulpFoilCtnt = null;
	/* Column Info */
	private String rmnAvgSpdCtnt = null;
	/* Column Info */
	private String engMlDistCtnt = null;
	/* Column Info */
	private String avgPrlrPchVal = null;
	/* Column Info */
	private String rfCntrLodKntCtnt = null;
	/* Column Info */
	private String splFoilActCtnt = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String rfCntrDchgKntCtnt = null;
	/* Column Info */
	private String splFoilBdrCtnt = null;
	/* Column Info */
	private String arrLowSulpFoilCtnt = null;
	/* Column Info */
	private String depFwddrCtnt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lstDepPortCd = null;
	/* Column Info */
	private String aftUnbrthAnkOffDt = null;
	/* Column Info */
	private String depDplCtnt = null;
	/* Column Info */
	private String seaMnDoilCtnt = null;
	/* Column Info */
	private String oldClptIndSeq = null;
	/* Column Info */
	private String cgoWrkStDt = null;
	/* Column Info */
	private String portGnrFoilCtnt = null;
	/* Column Info */
	private String splFoilSulpCtnt = null;
	/* Column Info */
	private String avgPortTtlQty = null;
	/* Column Info */
	private String aftUnbrthAnkDrpDt = null;
	/* Column Info */
	private String arrAftdrCtnt = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String ttlCntrObrdTeuCtnt = null;
	/* Column Info */
	private String portGnrLowSulpDoilCtnt = null;
	/* Column Info */
	private String avgSpdCtnt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String portBlrDoilCtnt = null;
	/* Column Info */
	private String depDoilCtnt = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String oldDepPortCd = null;
	/* Column Info */
	private String avgNvgtMlDist = null;
	/* Column Info */
	private String oldSkdDirCd = null;
	/* Column Info */
	private String nvgtMlDistCtnt = null;
	/* Column Info */
	private String nxtPortEtaDt = null;
	/* Column Info */
	private String splLowSulpDoilSulpCtnt = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String seaStmngMnEngTtlQty = null;
	/* Column Info */
	private String splLowSulpFoilSulpCtnt = null;
	/* Column Info */
	private String portBlrFoilCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String seaBlrLowSulpDoilCtnt = null;
	/* Column Info */
	private String seaBlrFoilCtnt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstDepLowSulpDoilCtnt = null;
	/* Column Info */
	private String arrMidDrftCtnt = null;
	/* Column Info */
	private String rfCntrObrdKntCtnt = null;
	/* Column Info */
	private String portMnLowSulpFoilCtnt = null;
	/* Column Info */
	private String avgMnvrOutMlDist = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String splDoilBdrCtnt = null;
	/* Column Info */
	private String splLowSulpFoilActCtnt = null;
	/* Column Info */
	private String depAftdrCtnt = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String oldSkdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String mnvrInMlDistCtnt = null;
	/* Column Info */
	private String rcvEaiIfId = null;
	/* Column Info */
	private String arrDoilCtnt = null;
	/* Column Info */
	private String depRptErrSeq = null;
	/* Column Info */
	private String seaMnFoilCtnt = null;
	/* Column Info */
	private String seaBlrDoilCtnt = null;
	/* Column Info */
	private String seaMnLowSulpDoilCtnt = null;
	/* Column Info */
	private String depLowSulpDoilCtnt = null;
	/* Column Info */
	private String mcntrObrdTeuCtnt = null;
	/* Column Info */
	private String splLowSulpFoilBdrCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FcmDepRptErrClsVO() {}

	public FcmDepRptErrClsVO(String ibflag, String pagerows, String depRptErrSeq, String cntrDznCapa, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanCd, String lstDepPortCd, String depPortCd, String clptIndSeq, String depRptErrTpCd, String nvgtMlDistCtnt, String avgNvgtMlDist, String engMlDistCtnt, String mnvrInMlDistCtnt, String avgMnvrInMlDist, String mnvrOutMlDistCtnt, String avgMnvrOutMlDist, String avgSpdCtnt, String avgRpmPwrCtnt, String avgPrlrPchVal, String sailTmHrs, String arrFoilCtnt, String arrLowSulpFoilCtnt, String arrDoilCtnt, String arrLowSulpDoilCtnt, String depFoilCtnt, String depLowSulpFoilCtnt, String depDoilCtnt, String depLowSulpDoilCtnt, String lstDepFoilCtnt, String lstDepLowSulpFoilCtnt, String lstDepDoilCtnt, String lstDepLowSulpDoilCtnt, String seaStmngMnEngTtlQty, String avgPortTtlQty, String avgPortTtlHrQty, String seaMnFoilCtnt, String seaGnrFoilCtnt, String seaBlrFoilCtnt, String seaMnLowSulpFoilCtnt, String seaGnrLowSulpFoilCtnt, String seaBlrLowSulpFoilCtnt, String seaMnDoilCtnt, String seaGnrDoilCtnt, String seaBlrDoilCtnt, String seaMnLowSulpDoilCtnt, String seaGnrLowSulpDoilCtnt, String seaBlrLowSulpDoilCtnt, String portMnFoilCtnt, String portGnrFoilCtnt, String portBlrFoilCtnt, String portMnLowSulpFoilCtnt, String portGnrLowSulpFoilCtnt, String portBlrLowSulpFoilCtnt, String portMnDoilCtnt, String portGnrDoilCtnt, String portBlrDoilCtnt, String portMnLowSulpDoilCtnt, String portGnrLowSulpDoilCtnt, String portBlrLowSulpDoilCtnt, String splFoilBdrCtnt, String splFoilActCtnt, String splFoilSulpCtnt, String splLowSulpFoilBdrCtnt, String splLowSulpFoilActCtnt, String splLowSulpFoilSulpCtnt, String splDoilBdrCtnt, String splDoilActCtnt, String splDoilSulpCtnt, String splLowSulpDoilBdrCtnt, String splLowSulpDoilActCtnt, String splLowSulpDoilSulpCtnt, String nxtPortCd, String nxtPortEtaDt, String rmnDistCtnt, String rmnAvgSpdCtnt, String sbEngDt, String pltInDt, String bfrBrthAnkDrpDt, String bfrBrthAnkOffDt, String vpsEtbDt, String cgoWrkStDt, String cgoWrkEndDt, String vpsEtdDt, String aftUnbrthAnkDrpDt, String aftUnbrthAnkOffDt, String pltOutDt, String rupDt, String lstPortRupDt, String arrFwddrCtnt, String arrMidDrftCtnt, String arrAftdrCtnt, String arrGmCtnt, String depFwddrCtnt, String depMidDrftCtnt, String depAftdrCtnt, String depGmCtnt, String fcntrObrdTeuCtnt, String mcntrObrdTeuCtnt, String ttlCntrObrdTeuCtnt, String depCgoCtnt, String depDplCtnt, String rfCntrDchgKntCtnt, String rfCntrLodKntCtnt, String rfCntrObrdKntCtnt, String lstRfCntrObrdKntCtnt, String errItmCtnt, String rcvEaiIfId, String creUsrId, String creDt, String updUsrId, String updDt, String rcvDt, String rcvSeq, String oldClptIndSeq, String oldDepPortCd, String oldSkdDirCd, String oldSkdVoyNo, String oldVslCd, String depRptClsSeq, String callUiId) {
		this.portBlrLowSulpDoilCtnt = portBlrLowSulpDoilCtnt;
		this.pltInDt = pltInDt;
		this.seaGnrLowSulpDoilCtnt = seaGnrLowSulpDoilCtnt;
		this.depLowSulpFoilCtnt = depLowSulpFoilCtnt;
		this.splLowSulpDoilBdrCtnt = splLowSulpDoilBdrCtnt;
		this.lstRfCntrObrdKntCtnt = lstRfCntrObrdKntCtnt;
		this.arrLowSulpDoilCtnt = arrLowSulpDoilCtnt;
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
		this.depRptErrTpCd = depRptErrTpCd;
		this.sailTmHrs = sailTmHrs;
		this.nxtPortCd = nxtPortCd;
		this.rmnDistCtnt = rmnDistCtnt;
		this.pagerows = pagerows;
		this.avgMnvrInMlDist = avgMnvrInMlDist;
		this.seaMnLowSulpFoilCtnt = seaMnLowSulpFoilCtnt;
		this.portMnLowSulpDoilCtnt = portMnLowSulpDoilCtnt;
		this.callUiId = callUiId;
		this.depFoilCtnt = depFoilCtnt;
		this.fcntrObrdTeuCtnt = fcntrObrdTeuCtnt;
		this.updUsrId = updUsrId;
		this.seaGnrFoilCtnt = seaGnrFoilCtnt;
		this.lstDepDoilCtnt = lstDepDoilCtnt;
		this.errItmCtnt = errItmCtnt;
		this.depCgoCtnt = depCgoCtnt;
		this.skdVoyNo = skdVoyNo;
		this.lstPortRupDt = lstPortRupDt;
		this.pltOutDt = pltOutDt;
		this.avgPortTtlHrQty = avgPortTtlHrQty;
		this.seaGnrLowSulpFoilCtnt = seaGnrLowSulpFoilCtnt;
		this.portGnrLowSulpFoilCtnt = portGnrLowSulpFoilCtnt;
		this.arrGmCtnt = arrGmCtnt;
		this.portMnFoilCtnt = portMnFoilCtnt;
		this.arrFwddrCtnt = arrFwddrCtnt;
		this.avgRpmPwrCtnt = avgRpmPwrCtnt;
		this.mnvrOutMlDistCtnt = mnvrOutMlDistCtnt;
		this.portGnrDoilCtnt = portGnrDoilCtnt;
		this.oldVslCd = oldVslCd;
		this.depGmCtnt = depGmCtnt;
		this.seaGnrDoilCtnt = seaGnrDoilCtnt;
		this.lstDepLowSulpFoilCtnt = lstDepLowSulpFoilCtnt;
		this.portMnDoilCtnt = portMnDoilCtnt;
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
		this.rcvSeq = rcvSeq;
		this.depMidDrftCtnt = depMidDrftCtnt;
		this.seaBlrLowSulpFoilCtnt = seaBlrLowSulpFoilCtnt;
		this.splLowSulpDoilActCtnt = splLowSulpDoilActCtnt;
		this.splDoilSulpCtnt = splDoilSulpCtnt;
		this.arrFoilCtnt = arrFoilCtnt;
		this.depRptClsSeq = depRptClsSeq;
		this.lstDepFoilCtnt = lstDepFoilCtnt;
		this.rupDt = rupDt;
		this.splDoilActCtnt = splDoilActCtnt;
		this.sbEngDt = sbEngDt;
		this.cgoWrkEndDt = cgoWrkEndDt;
		this.portBlrLowSulpFoilCtnt = portBlrLowSulpFoilCtnt;
		this.rmnAvgSpdCtnt = rmnAvgSpdCtnt;
		this.engMlDistCtnt = engMlDistCtnt;
		this.avgPrlrPchVal = avgPrlrPchVal;
		this.rfCntrLodKntCtnt = rfCntrLodKntCtnt;
		this.splFoilActCtnt = splFoilActCtnt;
		this.clptIndSeq = clptIndSeq;
		this.rfCntrDchgKntCtnt = rfCntrDchgKntCtnt;
		this.splFoilBdrCtnt = splFoilBdrCtnt;
		this.arrLowSulpFoilCtnt = arrLowSulpFoilCtnt;
		this.depFwddrCtnt = depFwddrCtnt;
		this.vslCd = vslCd;
		this.lstDepPortCd = lstDepPortCd;
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
		this.depDplCtnt = depDplCtnt;
		this.seaMnDoilCtnt = seaMnDoilCtnt;
		this.oldClptIndSeq = oldClptIndSeq;
		this.cgoWrkStDt = cgoWrkStDt;
		this.portGnrFoilCtnt = portGnrFoilCtnt;
		this.splFoilSulpCtnt = splFoilSulpCtnt;
		this.avgPortTtlQty = avgPortTtlQty;
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
		this.arrAftdrCtnt = arrAftdrCtnt;
		this.rcvDt = rcvDt;
		this.ttlCntrObrdTeuCtnt = ttlCntrObrdTeuCtnt;
		this.portGnrLowSulpDoilCtnt = portGnrLowSulpDoilCtnt;
		this.avgSpdCtnt = avgSpdCtnt;
		this.vpsEtdDt = vpsEtdDt;
		this.portBlrDoilCtnt = portBlrDoilCtnt;
		this.depDoilCtnt = depDoilCtnt;
		this.cntrDznCapa = cntrDznCapa;
		this.creUsrId = creUsrId;
		this.oldDepPortCd = oldDepPortCd;
		this.avgNvgtMlDist = avgNvgtMlDist;
		this.oldSkdDirCd = oldSkdDirCd;
		this.nvgtMlDistCtnt = nvgtMlDistCtnt;
		this.nxtPortEtaDt = nxtPortEtaDt;
		this.splLowSulpDoilSulpCtnt = splLowSulpDoilSulpCtnt;
		this.vpsEtbDt = vpsEtbDt;
		this.seaStmngMnEngTtlQty = seaStmngMnEngTtlQty;
		this.splLowSulpFoilSulpCtnt = splLowSulpFoilSulpCtnt;
		this.portBlrFoilCtnt = portBlrFoilCtnt;
		this.creDt = creDt;
		this.seaBlrLowSulpDoilCtnt = seaBlrLowSulpDoilCtnt;
		this.seaBlrFoilCtnt = seaBlrFoilCtnt;
		this.vslSlanCd = vslSlanCd;
		this.ibflag = ibflag;
		this.lstDepLowSulpDoilCtnt = lstDepLowSulpDoilCtnt;
		this.arrMidDrftCtnt = arrMidDrftCtnt;
		this.rfCntrObrdKntCtnt = rfCntrObrdKntCtnt;
		this.portMnLowSulpFoilCtnt = portMnLowSulpFoilCtnt;
		this.avgMnvrOutMlDist = avgMnvrOutMlDist;
		this.updDt = updDt;
		this.splDoilBdrCtnt = splDoilBdrCtnt;
		this.splLowSulpFoilActCtnt = splLowSulpFoilActCtnt;
		this.depAftdrCtnt = depAftdrCtnt;
		this.depPortCd = depPortCd;
		this.oldSkdVoyNo = oldSkdVoyNo;
		this.skdDirCd = skdDirCd;
		this.mnvrInMlDistCtnt = mnvrInMlDistCtnt;
		this.rcvEaiIfId = rcvEaiIfId;
		this.arrDoilCtnt = arrDoilCtnt;
		this.depRptErrSeq = depRptErrSeq;
		this.seaMnFoilCtnt = seaMnFoilCtnt;
		this.seaBlrDoilCtnt = seaBlrDoilCtnt;
		this.seaMnLowSulpDoilCtnt = seaMnLowSulpDoilCtnt;
		this.depLowSulpDoilCtnt = depLowSulpDoilCtnt;
		this.mcntrObrdTeuCtnt = mcntrObrdTeuCtnt;
		this.splLowSulpFoilBdrCtnt = splLowSulpFoilBdrCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_blr_low_sulp_doil_ctnt", getPortBlrLowSulpDoilCtnt());
		this.hashColumns.put("plt_in_dt", getPltInDt());
		this.hashColumns.put("sea_gnr_low_sulp_doil_ctnt", getSeaGnrLowSulpDoilCtnt());
		this.hashColumns.put("dep_low_sulp_foil_ctnt", getDepLowSulpFoilCtnt());
		this.hashColumns.put("spl_low_sulp_doil_bdr_ctnt", getSplLowSulpDoilBdrCtnt());
		this.hashColumns.put("lst_rf_cntr_obrd_knt_ctnt", getLstRfCntrObrdKntCtnt());
		this.hashColumns.put("arr_low_sulp_doil_ctnt", getArrLowSulpDoilCtnt());
		this.hashColumns.put("bfr_brth_ank_drp_dt", getBfrBrthAnkDrpDt());
		this.hashColumns.put("dep_rpt_err_tp_cd", getDepRptErrTpCd());
		this.hashColumns.put("sail_tm_hrs", getSailTmHrs());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("rmn_dist_ctnt", getRmnDistCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("avg_mnvr_in_ml_dist", getAvgMnvrInMlDist());
		this.hashColumns.put("sea_mn_low_sulp_foil_ctnt", getSeaMnLowSulpFoilCtnt());
		this.hashColumns.put("port_mn_low_sulp_doil_ctnt", getPortMnLowSulpDoilCtnt());
		this.hashColumns.put("call_ui_id", getCallUiId());
		this.hashColumns.put("dep_foil_ctnt", getDepFoilCtnt());
		this.hashColumns.put("fcntr_obrd_teu_ctnt", getFcntrObrdTeuCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sea_gnr_foil_ctnt", getSeaGnrFoilCtnt());
		this.hashColumns.put("lst_dep_doil_ctnt", getLstDepDoilCtnt());
		this.hashColumns.put("err_itm_ctnt", getErrItmCtnt());
		this.hashColumns.put("dep_cgo_ctnt", getDepCgoCtnt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("lst_port_rup_dt", getLstPortRupDt());
		this.hashColumns.put("plt_out_dt", getPltOutDt());
		this.hashColumns.put("avg_port_ttl_hr_qty", getAvgPortTtlHrQty());
		this.hashColumns.put("sea_gnr_low_sulp_foil_ctnt", getSeaGnrLowSulpFoilCtnt());
		this.hashColumns.put("port_gnr_low_sulp_foil_ctnt", getPortGnrLowSulpFoilCtnt());
		this.hashColumns.put("arr_gm_ctnt", getArrGmCtnt());
		this.hashColumns.put("port_mn_foil_ctnt", getPortMnFoilCtnt());
		this.hashColumns.put("arr_fwddr_ctnt", getArrFwddrCtnt());
		this.hashColumns.put("avg_rpm_pwr_ctnt", getAvgRpmPwrCtnt());
		this.hashColumns.put("mnvr_out_ml_dist_ctnt", getMnvrOutMlDistCtnt());
		this.hashColumns.put("port_gnr_doil_ctnt", getPortGnrDoilCtnt());
		this.hashColumns.put("old_vsl_cd", getOldVslCd());
		this.hashColumns.put("dep_gm_ctnt", getDepGmCtnt());
		this.hashColumns.put("sea_gnr_doil_ctnt", getSeaGnrDoilCtnt());
		this.hashColumns.put("lst_dep_low_sulp_foil_ctnt", getLstDepLowSulpFoilCtnt());
		this.hashColumns.put("port_mn_doil_ctnt", getPortMnDoilCtnt());
		this.hashColumns.put("bfr_brth_ank_off_dt", getBfrBrthAnkOffDt());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("dep_mid_drft_ctnt", getDepMidDrftCtnt());
		this.hashColumns.put("sea_blr_low_sulp_foil_ctnt", getSeaBlrLowSulpFoilCtnt());
		this.hashColumns.put("spl_low_sulp_doil_act_ctnt", getSplLowSulpDoilActCtnt());
		this.hashColumns.put("spl_doil_sulp_ctnt", getSplDoilSulpCtnt());
		this.hashColumns.put("arr_foil_ctnt", getArrFoilCtnt());
		this.hashColumns.put("dep_rpt_cls_seq", getDepRptClsSeq());
		this.hashColumns.put("lst_dep_foil_ctnt", getLstDepFoilCtnt());
		this.hashColumns.put("rup_dt", getRupDt());
		this.hashColumns.put("spl_doil_act_ctnt", getSplDoilActCtnt());
		this.hashColumns.put("sb_eng_dt", getSbEngDt());
		this.hashColumns.put("cgo_wrk_end_dt", getCgoWrkEndDt());
		this.hashColumns.put("port_blr_low_sulp_foil_ctnt", getPortBlrLowSulpFoilCtnt());
		this.hashColumns.put("rmn_avg_spd_ctnt", getRmnAvgSpdCtnt());
		this.hashColumns.put("eng_ml_dist_ctnt", getEngMlDistCtnt());
		this.hashColumns.put("avg_prlr_pch_val", getAvgPrlrPchVal());
		this.hashColumns.put("rf_cntr_lod_knt_ctnt", getRfCntrLodKntCtnt());
		this.hashColumns.put("spl_foil_act_ctnt", getSplFoilActCtnt());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("rf_cntr_dchg_knt_ctnt", getRfCntrDchgKntCtnt());
		this.hashColumns.put("spl_foil_bdr_ctnt", getSplFoilBdrCtnt());
		this.hashColumns.put("arr_low_sulp_foil_ctnt", getArrLowSulpFoilCtnt());
		this.hashColumns.put("dep_fwddr_ctnt", getDepFwddrCtnt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lst_dep_port_cd", getLstDepPortCd());
		this.hashColumns.put("aft_unbrth_ank_off_dt", getAftUnbrthAnkOffDt());
		this.hashColumns.put("dep_dpl_ctnt", getDepDplCtnt());
		this.hashColumns.put("sea_mn_doil_ctnt", getSeaMnDoilCtnt());
		this.hashColumns.put("old_clpt_ind_seq", getOldClptIndSeq());
		this.hashColumns.put("cgo_wrk_st_dt", getCgoWrkStDt());
		this.hashColumns.put("port_gnr_foil_ctnt", getPortGnrFoilCtnt());
		this.hashColumns.put("spl_foil_sulp_ctnt", getSplFoilSulpCtnt());
		this.hashColumns.put("avg_port_ttl_qty", getAvgPortTtlQty());
		this.hashColumns.put("aft_unbrth_ank_drp_dt", getAftUnbrthAnkDrpDt());
		this.hashColumns.put("arr_aftdr_ctnt", getArrAftdrCtnt());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("ttl_cntr_obrd_teu_ctnt", getTtlCntrObrdTeuCtnt());
		this.hashColumns.put("port_gnr_low_sulp_doil_ctnt", getPortGnrLowSulpDoilCtnt());
		this.hashColumns.put("avg_spd_ctnt", getAvgSpdCtnt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("port_blr_doil_ctnt", getPortBlrDoilCtnt());
		this.hashColumns.put("dep_doil_ctnt", getDepDoilCtnt());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("old_dep_port_cd", getOldDepPortCd());
		this.hashColumns.put("avg_nvgt_ml_dist", getAvgNvgtMlDist());
		this.hashColumns.put("old_skd_dir_cd", getOldSkdDirCd());
		this.hashColumns.put("nvgt_ml_dist_ctnt", getNvgtMlDistCtnt());
		this.hashColumns.put("nxt_port_eta_dt", getNxtPortEtaDt());
		this.hashColumns.put("spl_low_sulp_doil_sulp_ctnt", getSplLowSulpDoilSulpCtnt());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("sea_stmng_mn_eng_ttl_qty", getSeaStmngMnEngTtlQty());
		this.hashColumns.put("spl_low_sulp_foil_sulp_ctnt", getSplLowSulpFoilSulpCtnt());
		this.hashColumns.put("port_blr_foil_ctnt", getPortBlrFoilCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sea_blr_low_sulp_doil_ctnt", getSeaBlrLowSulpDoilCtnt());
		this.hashColumns.put("sea_blr_foil_ctnt", getSeaBlrFoilCtnt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_dep_low_sulp_doil_ctnt", getLstDepLowSulpDoilCtnt());
		this.hashColumns.put("arr_mid_drft_ctnt", getArrMidDrftCtnt());
		this.hashColumns.put("rf_cntr_obrd_knt_ctnt", getRfCntrObrdKntCtnt());
		this.hashColumns.put("port_mn_low_sulp_foil_ctnt", getPortMnLowSulpFoilCtnt());
		this.hashColumns.put("avg_mnvr_out_ml_dist", getAvgMnvrOutMlDist());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spl_doil_bdr_ctnt", getSplDoilBdrCtnt());
		this.hashColumns.put("spl_low_sulp_foil_act_ctnt", getSplLowSulpFoilActCtnt());
		this.hashColumns.put("dep_aftdr_ctnt", getDepAftdrCtnt());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("old_skd_voy_no", getOldSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("mnvr_in_ml_dist_ctnt", getMnvrInMlDistCtnt());
		this.hashColumns.put("rcv_eai_if_id", getRcvEaiIfId());
		this.hashColumns.put("arr_doil_ctnt", getArrDoilCtnt());
		this.hashColumns.put("dep_rpt_err_seq", getDepRptErrSeq());
		this.hashColumns.put("sea_mn_foil_ctnt", getSeaMnFoilCtnt());
		this.hashColumns.put("sea_blr_doil_ctnt", getSeaBlrDoilCtnt());
		this.hashColumns.put("sea_mn_low_sulp_doil_ctnt", getSeaMnLowSulpDoilCtnt());
		this.hashColumns.put("dep_low_sulp_doil_ctnt", getDepLowSulpDoilCtnt());
		this.hashColumns.put("mcntr_obrd_teu_ctnt", getMcntrObrdTeuCtnt());
		this.hashColumns.put("spl_low_sulp_foil_bdr_ctnt", getSplLowSulpFoilBdrCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_blr_low_sulp_doil_ctnt", "portBlrLowSulpDoilCtnt");
		this.hashFields.put("plt_in_dt", "pltInDt");
		this.hashFields.put("sea_gnr_low_sulp_doil_ctnt", "seaGnrLowSulpDoilCtnt");
		this.hashFields.put("dep_low_sulp_foil_ctnt", "depLowSulpFoilCtnt");
		this.hashFields.put("spl_low_sulp_doil_bdr_ctnt", "splLowSulpDoilBdrCtnt");
		this.hashFields.put("lst_rf_cntr_obrd_knt_ctnt", "lstRfCntrObrdKntCtnt");
		this.hashFields.put("arr_low_sulp_doil_ctnt", "arrLowSulpDoilCtnt");
		this.hashFields.put("bfr_brth_ank_drp_dt", "bfrBrthAnkDrpDt");
		this.hashFields.put("dep_rpt_err_tp_cd", "depRptErrTpCd");
		this.hashFields.put("sail_tm_hrs", "sailTmHrs");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("rmn_dist_ctnt", "rmnDistCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("avg_mnvr_in_ml_dist", "avgMnvrInMlDist");
		this.hashFields.put("sea_mn_low_sulp_foil_ctnt", "seaMnLowSulpFoilCtnt");
		this.hashFields.put("port_mn_low_sulp_doil_ctnt", "portMnLowSulpDoilCtnt");
		this.hashFields.put("call_ui_id", "callUiId");
		this.hashFields.put("dep_foil_ctnt", "depFoilCtnt");
		this.hashFields.put("fcntr_obrd_teu_ctnt", "fcntrObrdTeuCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sea_gnr_foil_ctnt", "seaGnrFoilCtnt");
		this.hashFields.put("lst_dep_doil_ctnt", "lstDepDoilCtnt");
		this.hashFields.put("err_itm_ctnt", "errItmCtnt");
		this.hashFields.put("dep_cgo_ctnt", "depCgoCtnt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("lst_port_rup_dt", "lstPortRupDt");
		this.hashFields.put("plt_out_dt", "pltOutDt");
		this.hashFields.put("avg_port_ttl_hr_qty", "avgPortTtlHrQty");
		this.hashFields.put("sea_gnr_low_sulp_foil_ctnt", "seaGnrLowSulpFoilCtnt");
		this.hashFields.put("port_gnr_low_sulp_foil_ctnt", "portGnrLowSulpFoilCtnt");
		this.hashFields.put("arr_gm_ctnt", "arrGmCtnt");
		this.hashFields.put("port_mn_foil_ctnt", "portMnFoilCtnt");
		this.hashFields.put("arr_fwddr_ctnt", "arrFwddrCtnt");
		this.hashFields.put("avg_rpm_pwr_ctnt", "avgRpmPwrCtnt");
		this.hashFields.put("mnvr_out_ml_dist_ctnt", "mnvrOutMlDistCtnt");
		this.hashFields.put("port_gnr_doil_ctnt", "portGnrDoilCtnt");
		this.hashFields.put("old_vsl_cd", "oldVslCd");
		this.hashFields.put("dep_gm_ctnt", "depGmCtnt");
		this.hashFields.put("sea_gnr_doil_ctnt", "seaGnrDoilCtnt");
		this.hashFields.put("lst_dep_low_sulp_foil_ctnt", "lstDepLowSulpFoilCtnt");
		this.hashFields.put("port_mn_doil_ctnt", "portMnDoilCtnt");
		this.hashFields.put("bfr_brth_ank_off_dt", "bfrBrthAnkOffDt");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("dep_mid_drft_ctnt", "depMidDrftCtnt");
		this.hashFields.put("sea_blr_low_sulp_foil_ctnt", "seaBlrLowSulpFoilCtnt");
		this.hashFields.put("spl_low_sulp_doil_act_ctnt", "splLowSulpDoilActCtnt");
		this.hashFields.put("spl_doil_sulp_ctnt", "splDoilSulpCtnt");
		this.hashFields.put("arr_foil_ctnt", "arrFoilCtnt");
		this.hashFields.put("dep_rpt_cls_seq", "depRptClsSeq");
		this.hashFields.put("lst_dep_foil_ctnt", "lstDepFoilCtnt");
		this.hashFields.put("rup_dt", "rupDt");
		this.hashFields.put("spl_doil_act_ctnt", "splDoilActCtnt");
		this.hashFields.put("sb_eng_dt", "sbEngDt");
		this.hashFields.put("cgo_wrk_end_dt", "cgoWrkEndDt");
		this.hashFields.put("port_blr_low_sulp_foil_ctnt", "portBlrLowSulpFoilCtnt");
		this.hashFields.put("rmn_avg_spd_ctnt", "rmnAvgSpdCtnt");
		this.hashFields.put("eng_ml_dist_ctnt", "engMlDistCtnt");
		this.hashFields.put("avg_prlr_pch_val", "avgPrlrPchVal");
		this.hashFields.put("rf_cntr_lod_knt_ctnt", "rfCntrLodKntCtnt");
		this.hashFields.put("spl_foil_act_ctnt", "splFoilActCtnt");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("rf_cntr_dchg_knt_ctnt", "rfCntrDchgKntCtnt");
		this.hashFields.put("spl_foil_bdr_ctnt", "splFoilBdrCtnt");
		this.hashFields.put("arr_low_sulp_foil_ctnt", "arrLowSulpFoilCtnt");
		this.hashFields.put("dep_fwddr_ctnt", "depFwddrCtnt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lst_dep_port_cd", "lstDepPortCd");
		this.hashFields.put("aft_unbrth_ank_off_dt", "aftUnbrthAnkOffDt");
		this.hashFields.put("dep_dpl_ctnt", "depDplCtnt");
		this.hashFields.put("sea_mn_doil_ctnt", "seaMnDoilCtnt");
		this.hashFields.put("old_clpt_ind_seq", "oldClptIndSeq");
		this.hashFields.put("cgo_wrk_st_dt", "cgoWrkStDt");
		this.hashFields.put("port_gnr_foil_ctnt", "portGnrFoilCtnt");
		this.hashFields.put("spl_foil_sulp_ctnt", "splFoilSulpCtnt");
		this.hashFields.put("avg_port_ttl_qty", "avgPortTtlQty");
		this.hashFields.put("aft_unbrth_ank_drp_dt", "aftUnbrthAnkDrpDt");
		this.hashFields.put("arr_aftdr_ctnt", "arrAftdrCtnt");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("ttl_cntr_obrd_teu_ctnt", "ttlCntrObrdTeuCtnt");
		this.hashFields.put("port_gnr_low_sulp_doil_ctnt", "portGnrLowSulpDoilCtnt");
		this.hashFields.put("avg_spd_ctnt", "avgSpdCtnt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("port_blr_doil_ctnt", "portBlrDoilCtnt");
		this.hashFields.put("dep_doil_ctnt", "depDoilCtnt");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("old_dep_port_cd", "oldDepPortCd");
		this.hashFields.put("avg_nvgt_ml_dist", "avgNvgtMlDist");
		this.hashFields.put("old_skd_dir_cd", "oldSkdDirCd");
		this.hashFields.put("nvgt_ml_dist_ctnt", "nvgtMlDistCtnt");
		this.hashFields.put("nxt_port_eta_dt", "nxtPortEtaDt");
		this.hashFields.put("spl_low_sulp_doil_sulp_ctnt", "splLowSulpDoilSulpCtnt");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("sea_stmng_mn_eng_ttl_qty", "seaStmngMnEngTtlQty");
		this.hashFields.put("spl_low_sulp_foil_sulp_ctnt", "splLowSulpFoilSulpCtnt");
		this.hashFields.put("port_blr_foil_ctnt", "portBlrFoilCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sea_blr_low_sulp_doil_ctnt", "seaBlrLowSulpDoilCtnt");
		this.hashFields.put("sea_blr_foil_ctnt", "seaBlrFoilCtnt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_dep_low_sulp_doil_ctnt", "lstDepLowSulpDoilCtnt");
		this.hashFields.put("arr_mid_drft_ctnt", "arrMidDrftCtnt");
		this.hashFields.put("rf_cntr_obrd_knt_ctnt", "rfCntrObrdKntCtnt");
		this.hashFields.put("port_mn_low_sulp_foil_ctnt", "portMnLowSulpFoilCtnt");
		this.hashFields.put("avg_mnvr_out_ml_dist", "avgMnvrOutMlDist");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spl_doil_bdr_ctnt", "splDoilBdrCtnt");
		this.hashFields.put("spl_low_sulp_foil_act_ctnt", "splLowSulpFoilActCtnt");
		this.hashFields.put("dep_aftdr_ctnt", "depAftdrCtnt");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("old_skd_voy_no", "oldSkdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("mnvr_in_ml_dist_ctnt", "mnvrInMlDistCtnt");
		this.hashFields.put("rcv_eai_if_id", "rcvEaiIfId");
		this.hashFields.put("arr_doil_ctnt", "arrDoilCtnt");
		this.hashFields.put("dep_rpt_err_seq", "depRptErrSeq");
		this.hashFields.put("sea_mn_foil_ctnt", "seaMnFoilCtnt");
		this.hashFields.put("sea_blr_doil_ctnt", "seaBlrDoilCtnt");
		this.hashFields.put("sea_mn_low_sulp_doil_ctnt", "seaMnLowSulpDoilCtnt");
		this.hashFields.put("dep_low_sulp_doil_ctnt", "depLowSulpDoilCtnt");
		this.hashFields.put("mcntr_obrd_teu_ctnt", "mcntrObrdTeuCtnt");
		this.hashFields.put("spl_low_sulp_foil_bdr_ctnt", "splLowSulpFoilBdrCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portBlrLowSulpDoilCtnt
	 */
	public String getPortBlrLowSulpDoilCtnt() {
		return this.portBlrLowSulpDoilCtnt;
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
	 * @return seaGnrLowSulpDoilCtnt
	 */
	public String getSeaGnrLowSulpDoilCtnt() {
		return this.seaGnrLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpFoilCtnt
	 */
	public String getDepLowSulpFoilCtnt() {
		return this.depLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilBdrCtnt
	 */
	public String getSplLowSulpDoilBdrCtnt() {
		return this.splLowSulpDoilBdrCtnt;
	}
	
	/**
	 * Column Info
	 * @return lstRfCntrObrdKntCtnt
	 */
	public String getLstRfCntrObrdKntCtnt() {
		return this.lstRfCntrObrdKntCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpDoilCtnt
	 */
	public String getArrLowSulpDoilCtnt() {
		return this.arrLowSulpDoilCtnt;
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
	 * @return depRptErrTpCd
	 */
	public String getDepRptErrTpCd() {
		return this.depRptErrTpCd;
	}
	
	/**
	 * Column Info
	 * @return sailTmHrs
	 */
	public String getSailTmHrs() {
		return this.sailTmHrs;
	}
	
	/**
	 * Column Info
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @return rmnDistCtnt
	 */
	public String getRmnDistCtnt() {
		return this.rmnDistCtnt;
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
	 * @return avgMnvrInMlDist
	 */
	public String getAvgMnvrInMlDist() {
		return this.avgMnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @return seaMnLowSulpFoilCtnt
	 */
	public String getSeaMnLowSulpFoilCtnt() {
		return this.seaMnLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return portMnLowSulpDoilCtnt
	 */
	public String getPortMnLowSulpDoilCtnt() {
		return this.portMnLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return callUiId
	 */
	public String getCallUiId() {
		return this.callUiId;
	}
	
	/**
	 * Column Info
	 * @return depFoilCtnt
	 */
	public String getDepFoilCtnt() {
		return this.depFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return fcntrObrdTeuCtnt
	 */
	public String getFcntrObrdTeuCtnt() {
		return this.fcntrObrdTeuCtnt;
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
	 * @return seaGnrFoilCtnt
	 */
	public String getSeaGnrFoilCtnt() {
		return this.seaGnrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return lstDepDoilCtnt
	 */
	public String getLstDepDoilCtnt() {
		return this.lstDepDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return errItmCtnt
	 */
	public String getErrItmCtnt() {
		return this.errItmCtnt;
	}
	
	/**
	 * Column Info
	 * @return depCgoCtnt
	 */
	public String getDepCgoCtnt() {
		return this.depCgoCtnt;
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
	 * @return lstPortRupDt
	 */
	public String getLstPortRupDt() {
		return this.lstPortRupDt;
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
	 * @return avgPortTtlHrQty
	 */
	public String getAvgPortTtlHrQty() {
		return this.avgPortTtlHrQty;
	}
	
	/**
	 * Column Info
	 * @return seaGnrLowSulpFoilCtnt
	 */
	public String getSeaGnrLowSulpFoilCtnt() {
		return this.seaGnrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return portGnrLowSulpFoilCtnt
	 */
	public String getPortGnrLowSulpFoilCtnt() {
		return this.portGnrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrGmCtnt
	 */
	public String getArrGmCtnt() {
		return this.arrGmCtnt;
	}
	
	/**
	 * Column Info
	 * @return portMnFoilCtnt
	 */
	public String getPortMnFoilCtnt() {
		return this.portMnFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrFwddrCtnt
	 */
	public String getArrFwddrCtnt() {
		return this.arrFwddrCtnt;
	}
	
	/**
	 * Column Info
	 * @return avgRpmPwrCtnt
	 */
	public String getAvgRpmPwrCtnt() {
		return this.avgRpmPwrCtnt;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutMlDistCtnt
	 */
	public String getMnvrOutMlDistCtnt() {
		return this.mnvrOutMlDistCtnt;
	}
	
	/**
	 * Column Info
	 * @return portGnrDoilCtnt
	 */
	public String getPortGnrDoilCtnt() {
		return this.portGnrDoilCtnt;
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
	 * @return depGmCtnt
	 */
	public String getDepGmCtnt() {
		return this.depGmCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaGnrDoilCtnt
	 */
	public String getSeaGnrDoilCtnt() {
		return this.seaGnrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return lstDepLowSulpFoilCtnt
	 */
	public String getLstDepLowSulpFoilCtnt() {
		return this.lstDepLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return portMnDoilCtnt
	 */
	public String getPortMnDoilCtnt() {
		return this.portMnDoilCtnt;
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
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return depMidDrftCtnt
	 */
	public String getDepMidDrftCtnt() {
		return this.depMidDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaBlrLowSulpFoilCtnt
	 */
	public String getSeaBlrLowSulpFoilCtnt() {
		return this.seaBlrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilActCtnt
	 */
	public String getSplLowSulpDoilActCtnt() {
		return this.splLowSulpDoilActCtnt;
	}
	
	/**
	 * Column Info
	 * @return splDoilSulpCtnt
	 */
	public String getSplDoilSulpCtnt() {
		return this.splDoilSulpCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrFoilCtnt
	 */
	public String getArrFoilCtnt() {
		return this.arrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return depRptClsSeq
	 */
	public String getDepRptClsSeq() {
		return this.depRptClsSeq;
	}
	
	/**
	 * Column Info
	 * @return lstDepFoilCtnt
	 */
	public String getLstDepFoilCtnt() {
		return this.lstDepFoilCtnt;
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
	 * @return splDoilActCtnt
	 */
	public String getSplDoilActCtnt() {
		return this.splDoilActCtnt;
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
	 * @return cgoWrkEndDt
	 */
	public String getCgoWrkEndDt() {
		return this.cgoWrkEndDt;
	}
	
	/**
	 * Column Info
	 * @return portBlrLowSulpFoilCtnt
	 */
	public String getPortBlrLowSulpFoilCtnt() {
		return this.portBlrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return rmnAvgSpdCtnt
	 */
	public String getRmnAvgSpdCtnt() {
		return this.rmnAvgSpdCtnt;
	}
	
	/**
	 * Column Info
	 * @return engMlDistCtnt
	 */
	public String getEngMlDistCtnt() {
		return this.engMlDistCtnt;
	}
	
	/**
	 * Column Info
	 * @return avgPrlrPchVal
	 */
	public String getAvgPrlrPchVal() {
		return this.avgPrlrPchVal;
	}
	
	/**
	 * Column Info
	 * @return rfCntrLodKntCtnt
	 */
	public String getRfCntrLodKntCtnt() {
		return this.rfCntrLodKntCtnt;
	}
	
	/**
	 * Column Info
	 * @return splFoilActCtnt
	 */
	public String getSplFoilActCtnt() {
		return this.splFoilActCtnt;
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
	 * @return rfCntrDchgKntCtnt
	 */
	public String getRfCntrDchgKntCtnt() {
		return this.rfCntrDchgKntCtnt;
	}
	
	/**
	 * Column Info
	 * @return splFoilBdrCtnt
	 */
	public String getSplFoilBdrCtnt() {
		return this.splFoilBdrCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpFoilCtnt
	 */
	public String getArrLowSulpFoilCtnt() {
		return this.arrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return depFwddrCtnt
	 */
	public String getDepFwddrCtnt() {
		return this.depFwddrCtnt;
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
	 * @return lstDepPortCd
	 */
	public String getLstDepPortCd() {
		return this.lstDepPortCd;
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
	 * @return depDplCtnt
	 */
	public String getDepDplCtnt() {
		return this.depDplCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaMnDoilCtnt
	 */
	public String getSeaMnDoilCtnt() {
		return this.seaMnDoilCtnt;
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
	 * @return cgoWrkStDt
	 */
	public String getCgoWrkStDt() {
		return this.cgoWrkStDt;
	}
	
	/**
	 * Column Info
	 * @return portGnrFoilCtnt
	 */
	public String getPortGnrFoilCtnt() {
		return this.portGnrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return splFoilSulpCtnt
	 */
	public String getSplFoilSulpCtnt() {
		return this.splFoilSulpCtnt;
	}
	
	/**
	 * Column Info
	 * @return avgPortTtlQty
	 */
	public String getAvgPortTtlQty() {
		return this.avgPortTtlQty;
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
	 * @return arrAftdrCtnt
	 */
	public String getArrAftdrCtnt() {
		return this.arrAftdrCtnt;
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
	 * @return ttlCntrObrdTeuCtnt
	 */
	public String getTtlCntrObrdTeuCtnt() {
		return this.ttlCntrObrdTeuCtnt;
	}
	
	/**
	 * Column Info
	 * @return portGnrLowSulpDoilCtnt
	 */
	public String getPortGnrLowSulpDoilCtnt() {
		return this.portGnrLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return avgSpdCtnt
	 */
	public String getAvgSpdCtnt() {
		return this.avgSpdCtnt;
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
	 * @return portBlrDoilCtnt
	 */
	public String getPortBlrDoilCtnt() {
		return this.portBlrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return depDoilCtnt
	 */
	public String getDepDoilCtnt() {
		return this.depDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @return oldDepPortCd
	 */
	public String getOldDepPortCd() {
		return this.oldDepPortCd;
	}
	
	/**
	 * Column Info
	 * @return avgNvgtMlDist
	 */
	public String getAvgNvgtMlDist() {
		return this.avgNvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @return oldSkdDirCd
	 */
	public String getOldSkdDirCd() {
		return this.oldSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return nvgtMlDistCtnt
	 */
	public String getNvgtMlDistCtnt() {
		return this.nvgtMlDistCtnt;
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
	 * @return splLowSulpDoilSulpCtnt
	 */
	public String getSplLowSulpDoilSulpCtnt() {
		return this.splLowSulpDoilSulpCtnt;
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
	 * @return seaStmngMnEngTtlQty
	 */
	public String getSeaStmngMnEngTtlQty() {
		return this.seaStmngMnEngTtlQty;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilSulpCtnt
	 */
	public String getSplLowSulpFoilSulpCtnt() {
		return this.splLowSulpFoilSulpCtnt;
	}
	
	/**
	 * Column Info
	 * @return portBlrFoilCtnt
	 */
	public String getPortBlrFoilCtnt() {
		return this.portBlrFoilCtnt;
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
	 * @return seaBlrLowSulpDoilCtnt
	 */
	public String getSeaBlrLowSulpDoilCtnt() {
		return this.seaBlrLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaBlrFoilCtnt
	 */
	public String getSeaBlrFoilCtnt() {
		return this.seaBlrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return lstDepLowSulpDoilCtnt
	 */
	public String getLstDepLowSulpDoilCtnt() {
		return this.lstDepLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return arrMidDrftCtnt
	 */
	public String getArrMidDrftCtnt() {
		return this.arrMidDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @return rfCntrObrdKntCtnt
	 */
	public String getRfCntrObrdKntCtnt() {
		return this.rfCntrObrdKntCtnt;
	}
	
	/**
	 * Column Info
	 * @return portMnLowSulpFoilCtnt
	 */
	public String getPortMnLowSulpFoilCtnt() {
		return this.portMnLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return avgMnvrOutMlDist
	 */
	public String getAvgMnvrOutMlDist() {
		return this.avgMnvrOutMlDist;
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
	 * @return splDoilBdrCtnt
	 */
	public String getSplDoilBdrCtnt() {
		return this.splDoilBdrCtnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilActCtnt
	 */
	public String getSplLowSulpFoilActCtnt() {
		return this.splLowSulpFoilActCtnt;
	}
	
	/**
	 * Column Info
	 * @return depAftdrCtnt
	 */
	public String getDepAftdrCtnt() {
		return this.depAftdrCtnt;
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
	 * @return oldSkdVoyNo
	 */
	public String getOldSkdVoyNo() {
		return this.oldSkdVoyNo;
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
	 * @return mnvrInMlDistCtnt
	 */
	public String getMnvrInMlDistCtnt() {
		return this.mnvrInMlDistCtnt;
	}
	
	/**
	 * Column Info
	 * @return rcvEaiIfId
	 */
	public String getRcvEaiIfId() {
		return this.rcvEaiIfId;
	}
	
	/**
	 * Column Info
	 * @return arrDoilCtnt
	 */
	public String getArrDoilCtnt() {
		return this.arrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return depRptErrSeq
	 */
	public String getDepRptErrSeq() {
		return this.depRptErrSeq;
	}
	
	/**
	 * Column Info
	 * @return seaMnFoilCtnt
	 */
	public String getSeaMnFoilCtnt() {
		return this.seaMnFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaBlrDoilCtnt
	 */
	public String getSeaBlrDoilCtnt() {
		return this.seaBlrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return seaMnLowSulpDoilCtnt
	 */
	public String getSeaMnLowSulpDoilCtnt() {
		return this.seaMnLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpDoilCtnt
	 */
	public String getDepLowSulpDoilCtnt() {
		return this.depLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @return mcntrObrdTeuCtnt
	 */
	public String getMcntrObrdTeuCtnt() {
		return this.mcntrObrdTeuCtnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilBdrCtnt
	 */
	public String getSplLowSulpFoilBdrCtnt() {
		return this.splLowSulpFoilBdrCtnt;
	}
	

	/**
	 * Column Info
	 * @param portBlrLowSulpDoilCtnt
	 */
	public void setPortBlrLowSulpDoilCtnt(String portBlrLowSulpDoilCtnt) {
		this.portBlrLowSulpDoilCtnt = portBlrLowSulpDoilCtnt;
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
	 * @param seaGnrLowSulpDoilCtnt
	 */
	public void setSeaGnrLowSulpDoilCtnt(String seaGnrLowSulpDoilCtnt) {
		this.seaGnrLowSulpDoilCtnt = seaGnrLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpFoilCtnt
	 */
	public void setDepLowSulpFoilCtnt(String depLowSulpFoilCtnt) {
		this.depLowSulpFoilCtnt = depLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilBdrCtnt
	 */
	public void setSplLowSulpDoilBdrCtnt(String splLowSulpDoilBdrCtnt) {
		this.splLowSulpDoilBdrCtnt = splLowSulpDoilBdrCtnt;
	}
	
	/**
	 * Column Info
	 * @param lstRfCntrObrdKntCtnt
	 */
	public void setLstRfCntrObrdKntCtnt(String lstRfCntrObrdKntCtnt) {
		this.lstRfCntrObrdKntCtnt = lstRfCntrObrdKntCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpDoilCtnt
	 */
	public void setArrLowSulpDoilCtnt(String arrLowSulpDoilCtnt) {
		this.arrLowSulpDoilCtnt = arrLowSulpDoilCtnt;
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
	 * @param depRptErrTpCd
	 */
	public void setDepRptErrTpCd(String depRptErrTpCd) {
		this.depRptErrTpCd = depRptErrTpCd;
	}
	
	/**
	 * Column Info
	 * @param sailTmHrs
	 */
	public void setSailTmHrs(String sailTmHrs) {
		this.sailTmHrs = sailTmHrs;
	}
	
	/**
	 * Column Info
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @param rmnDistCtnt
	 */
	public void setRmnDistCtnt(String rmnDistCtnt) {
		this.rmnDistCtnt = rmnDistCtnt;
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
	 * @param avgMnvrInMlDist
	 */
	public void setAvgMnvrInMlDist(String avgMnvrInMlDist) {
		this.avgMnvrInMlDist = avgMnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @param seaMnLowSulpFoilCtnt
	 */
	public void setSeaMnLowSulpFoilCtnt(String seaMnLowSulpFoilCtnt) {
		this.seaMnLowSulpFoilCtnt = seaMnLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param portMnLowSulpDoilCtnt
	 */
	public void setPortMnLowSulpDoilCtnt(String portMnLowSulpDoilCtnt) {
		this.portMnLowSulpDoilCtnt = portMnLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param callUiId
	 */
	public void setCallUiId(String callUiId) {
		this.callUiId = callUiId;
	}
	
	/**
	 * Column Info
	 * @param depFoilCtnt
	 */
	public void setDepFoilCtnt(String depFoilCtnt) {
		this.depFoilCtnt = depFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param fcntrObrdTeuCtnt
	 */
	public void setFcntrObrdTeuCtnt(String fcntrObrdTeuCtnt) {
		this.fcntrObrdTeuCtnt = fcntrObrdTeuCtnt;
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
	 * @param seaGnrFoilCtnt
	 */
	public void setSeaGnrFoilCtnt(String seaGnrFoilCtnt) {
		this.seaGnrFoilCtnt = seaGnrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param lstDepDoilCtnt
	 */
	public void setLstDepDoilCtnt(String lstDepDoilCtnt) {
		this.lstDepDoilCtnt = lstDepDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param errItmCtnt
	 */
	public void setErrItmCtnt(String errItmCtnt) {
		this.errItmCtnt = errItmCtnt;
	}
	
	/**
	 * Column Info
	 * @param depCgoCtnt
	 */
	public void setDepCgoCtnt(String depCgoCtnt) {
		this.depCgoCtnt = depCgoCtnt;
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
	 * @param lstPortRupDt
	 */
	public void setLstPortRupDt(String lstPortRupDt) {
		this.lstPortRupDt = lstPortRupDt;
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
	 * @param avgPortTtlHrQty
	 */
	public void setAvgPortTtlHrQty(String avgPortTtlHrQty) {
		this.avgPortTtlHrQty = avgPortTtlHrQty;
	}
	
	/**
	 * Column Info
	 * @param seaGnrLowSulpFoilCtnt
	 */
	public void setSeaGnrLowSulpFoilCtnt(String seaGnrLowSulpFoilCtnt) {
		this.seaGnrLowSulpFoilCtnt = seaGnrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param portGnrLowSulpFoilCtnt
	 */
	public void setPortGnrLowSulpFoilCtnt(String portGnrLowSulpFoilCtnt) {
		this.portGnrLowSulpFoilCtnt = portGnrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrGmCtnt
	 */
	public void setArrGmCtnt(String arrGmCtnt) {
		this.arrGmCtnt = arrGmCtnt;
	}
	
	/**
	 * Column Info
	 * @param portMnFoilCtnt
	 */
	public void setPortMnFoilCtnt(String portMnFoilCtnt) {
		this.portMnFoilCtnt = portMnFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrFwddrCtnt
	 */
	public void setArrFwddrCtnt(String arrFwddrCtnt) {
		this.arrFwddrCtnt = arrFwddrCtnt;
	}
	
	/**
	 * Column Info
	 * @param avgRpmPwrCtnt
	 */
	public void setAvgRpmPwrCtnt(String avgRpmPwrCtnt) {
		this.avgRpmPwrCtnt = avgRpmPwrCtnt;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutMlDistCtnt
	 */
	public void setMnvrOutMlDistCtnt(String mnvrOutMlDistCtnt) {
		this.mnvrOutMlDistCtnt = mnvrOutMlDistCtnt;
	}
	
	/**
	 * Column Info
	 * @param portGnrDoilCtnt
	 */
	public void setPortGnrDoilCtnt(String portGnrDoilCtnt) {
		this.portGnrDoilCtnt = portGnrDoilCtnt;
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
	 * @param depGmCtnt
	 */
	public void setDepGmCtnt(String depGmCtnt) {
		this.depGmCtnt = depGmCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaGnrDoilCtnt
	 */
	public void setSeaGnrDoilCtnt(String seaGnrDoilCtnt) {
		this.seaGnrDoilCtnt = seaGnrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param lstDepLowSulpFoilCtnt
	 */
	public void setLstDepLowSulpFoilCtnt(String lstDepLowSulpFoilCtnt) {
		this.lstDepLowSulpFoilCtnt = lstDepLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param portMnDoilCtnt
	 */
	public void setPortMnDoilCtnt(String portMnDoilCtnt) {
		this.portMnDoilCtnt = portMnDoilCtnt;
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
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param depMidDrftCtnt
	 */
	public void setDepMidDrftCtnt(String depMidDrftCtnt) {
		this.depMidDrftCtnt = depMidDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaBlrLowSulpFoilCtnt
	 */
	public void setSeaBlrLowSulpFoilCtnt(String seaBlrLowSulpFoilCtnt) {
		this.seaBlrLowSulpFoilCtnt = seaBlrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilActCtnt
	 */
	public void setSplLowSulpDoilActCtnt(String splLowSulpDoilActCtnt) {
		this.splLowSulpDoilActCtnt = splLowSulpDoilActCtnt;
	}
	
	/**
	 * Column Info
	 * @param splDoilSulpCtnt
	 */
	public void setSplDoilSulpCtnt(String splDoilSulpCtnt) {
		this.splDoilSulpCtnt = splDoilSulpCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrFoilCtnt
	 */
	public void setArrFoilCtnt(String arrFoilCtnt) {
		this.arrFoilCtnt = arrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param depRptClsSeq
	 */
	public void setDepRptClsSeq(String depRptClsSeq) {
		this.depRptClsSeq = depRptClsSeq;
	}
	
	/**
	 * Column Info
	 * @param lstDepFoilCtnt
	 */
	public void setLstDepFoilCtnt(String lstDepFoilCtnt) {
		this.lstDepFoilCtnt = lstDepFoilCtnt;
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
	 * @param splDoilActCtnt
	 */
	public void setSplDoilActCtnt(String splDoilActCtnt) {
		this.splDoilActCtnt = splDoilActCtnt;
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
	 * @param cgoWrkEndDt
	 */
	public void setCgoWrkEndDt(String cgoWrkEndDt) {
		this.cgoWrkEndDt = cgoWrkEndDt;
	}
	
	/**
	 * Column Info
	 * @param portBlrLowSulpFoilCtnt
	 */
	public void setPortBlrLowSulpFoilCtnt(String portBlrLowSulpFoilCtnt) {
		this.portBlrLowSulpFoilCtnt = portBlrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param rmnAvgSpdCtnt
	 */
	public void setRmnAvgSpdCtnt(String rmnAvgSpdCtnt) {
		this.rmnAvgSpdCtnt = rmnAvgSpdCtnt;
	}
	
	/**
	 * Column Info
	 * @param engMlDistCtnt
	 */
	public void setEngMlDistCtnt(String engMlDistCtnt) {
		this.engMlDistCtnt = engMlDistCtnt;
	}
	
	/**
	 * Column Info
	 * @param avgPrlrPchVal
	 */
	public void setAvgPrlrPchVal(String avgPrlrPchVal) {
		this.avgPrlrPchVal = avgPrlrPchVal;
	}
	
	/**
	 * Column Info
	 * @param rfCntrLodKntCtnt
	 */
	public void setRfCntrLodKntCtnt(String rfCntrLodKntCtnt) {
		this.rfCntrLodKntCtnt = rfCntrLodKntCtnt;
	}
	
	/**
	 * Column Info
	 * @param splFoilActCtnt
	 */
	public void setSplFoilActCtnt(String splFoilActCtnt) {
		this.splFoilActCtnt = splFoilActCtnt;
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
	 * @param rfCntrDchgKntCtnt
	 */
	public void setRfCntrDchgKntCtnt(String rfCntrDchgKntCtnt) {
		this.rfCntrDchgKntCtnt = rfCntrDchgKntCtnt;
	}
	
	/**
	 * Column Info
	 * @param splFoilBdrCtnt
	 */
	public void setSplFoilBdrCtnt(String splFoilBdrCtnt) {
		this.splFoilBdrCtnt = splFoilBdrCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpFoilCtnt
	 */
	public void setArrLowSulpFoilCtnt(String arrLowSulpFoilCtnt) {
		this.arrLowSulpFoilCtnt = arrLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param depFwddrCtnt
	 */
	public void setDepFwddrCtnt(String depFwddrCtnt) {
		this.depFwddrCtnt = depFwddrCtnt;
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
	 * @param lstDepPortCd
	 */
	public void setLstDepPortCd(String lstDepPortCd) {
		this.lstDepPortCd = lstDepPortCd;
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
	 * @param depDplCtnt
	 */
	public void setDepDplCtnt(String depDplCtnt) {
		this.depDplCtnt = depDplCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaMnDoilCtnt
	 */
	public void setSeaMnDoilCtnt(String seaMnDoilCtnt) {
		this.seaMnDoilCtnt = seaMnDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param oldClptIndSeq
	 */
	public void setOldClptIndSeq(String oldClptIndSeq) {
		this.oldClptIndSeq = oldClptIndSeq;
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
	 * @param portGnrFoilCtnt
	 */
	public void setPortGnrFoilCtnt(String portGnrFoilCtnt) {
		this.portGnrFoilCtnt = portGnrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param splFoilSulpCtnt
	 */
	public void setSplFoilSulpCtnt(String splFoilSulpCtnt) {
		this.splFoilSulpCtnt = splFoilSulpCtnt;
	}
	
	/**
	 * Column Info
	 * @param avgPortTtlQty
	 */
	public void setAvgPortTtlQty(String avgPortTtlQty) {
		this.avgPortTtlQty = avgPortTtlQty;
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
	 * @param arrAftdrCtnt
	 */
	public void setArrAftdrCtnt(String arrAftdrCtnt) {
		this.arrAftdrCtnt = arrAftdrCtnt;
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
	 * @param ttlCntrObrdTeuCtnt
	 */
	public void setTtlCntrObrdTeuCtnt(String ttlCntrObrdTeuCtnt) {
		this.ttlCntrObrdTeuCtnt = ttlCntrObrdTeuCtnt;
	}
	
	/**
	 * Column Info
	 * @param portGnrLowSulpDoilCtnt
	 */
	public void setPortGnrLowSulpDoilCtnt(String portGnrLowSulpDoilCtnt) {
		this.portGnrLowSulpDoilCtnt = portGnrLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param avgSpdCtnt
	 */
	public void setAvgSpdCtnt(String avgSpdCtnt) {
		this.avgSpdCtnt = avgSpdCtnt;
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
	 * @param portBlrDoilCtnt
	 */
	public void setPortBlrDoilCtnt(String portBlrDoilCtnt) {
		this.portBlrDoilCtnt = portBlrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param depDoilCtnt
	 */
	public void setDepDoilCtnt(String depDoilCtnt) {
		this.depDoilCtnt = depDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
	 * @param oldDepPortCd
	 */
	public void setOldDepPortCd(String oldDepPortCd) {
		this.oldDepPortCd = oldDepPortCd;
	}
	
	/**
	 * Column Info
	 * @param avgNvgtMlDist
	 */
	public void setAvgNvgtMlDist(String avgNvgtMlDist) {
		this.avgNvgtMlDist = avgNvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @param oldSkdDirCd
	 */
	public void setOldSkdDirCd(String oldSkdDirCd) {
		this.oldSkdDirCd = oldSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param nvgtMlDistCtnt
	 */
	public void setNvgtMlDistCtnt(String nvgtMlDistCtnt) {
		this.nvgtMlDistCtnt = nvgtMlDistCtnt;
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
	 * @param splLowSulpDoilSulpCtnt
	 */
	public void setSplLowSulpDoilSulpCtnt(String splLowSulpDoilSulpCtnt) {
		this.splLowSulpDoilSulpCtnt = splLowSulpDoilSulpCtnt;
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
	 * @param seaStmngMnEngTtlQty
	 */
	public void setSeaStmngMnEngTtlQty(String seaStmngMnEngTtlQty) {
		this.seaStmngMnEngTtlQty = seaStmngMnEngTtlQty;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilSulpCtnt
	 */
	public void setSplLowSulpFoilSulpCtnt(String splLowSulpFoilSulpCtnt) {
		this.splLowSulpFoilSulpCtnt = splLowSulpFoilSulpCtnt;
	}
	
	/**
	 * Column Info
	 * @param portBlrFoilCtnt
	 */
	public void setPortBlrFoilCtnt(String portBlrFoilCtnt) {
		this.portBlrFoilCtnt = portBlrFoilCtnt;
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
	 * @param seaBlrLowSulpDoilCtnt
	 */
	public void setSeaBlrLowSulpDoilCtnt(String seaBlrLowSulpDoilCtnt) {
		this.seaBlrLowSulpDoilCtnt = seaBlrLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaBlrFoilCtnt
	 */
	public void setSeaBlrFoilCtnt(String seaBlrFoilCtnt) {
		this.seaBlrFoilCtnt = seaBlrFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param lstDepLowSulpDoilCtnt
	 */
	public void setLstDepLowSulpDoilCtnt(String lstDepLowSulpDoilCtnt) {
		this.lstDepLowSulpDoilCtnt = lstDepLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param arrMidDrftCtnt
	 */
	public void setArrMidDrftCtnt(String arrMidDrftCtnt) {
		this.arrMidDrftCtnt = arrMidDrftCtnt;
	}
	
	/**
	 * Column Info
	 * @param rfCntrObrdKntCtnt
	 */
	public void setRfCntrObrdKntCtnt(String rfCntrObrdKntCtnt) {
		this.rfCntrObrdKntCtnt = rfCntrObrdKntCtnt;
	}
	
	/**
	 * Column Info
	 * @param portMnLowSulpFoilCtnt
	 */
	public void setPortMnLowSulpFoilCtnt(String portMnLowSulpFoilCtnt) {
		this.portMnLowSulpFoilCtnt = portMnLowSulpFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param avgMnvrOutMlDist
	 */
	public void setAvgMnvrOutMlDist(String avgMnvrOutMlDist) {
		this.avgMnvrOutMlDist = avgMnvrOutMlDist;
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
	 * @param splDoilBdrCtnt
	 */
	public void setSplDoilBdrCtnt(String splDoilBdrCtnt) {
		this.splDoilBdrCtnt = splDoilBdrCtnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilActCtnt
	 */
	public void setSplLowSulpFoilActCtnt(String splLowSulpFoilActCtnt) {
		this.splLowSulpFoilActCtnt = splLowSulpFoilActCtnt;
	}
	
	/**
	 * Column Info
	 * @param depAftdrCtnt
	 */
	public void setDepAftdrCtnt(String depAftdrCtnt) {
		this.depAftdrCtnt = depAftdrCtnt;
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
	 * @param oldSkdVoyNo
	 */
	public void setOldSkdVoyNo(String oldSkdVoyNo) {
		this.oldSkdVoyNo = oldSkdVoyNo;
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
	 * @param mnvrInMlDistCtnt
	 */
	public void setMnvrInMlDistCtnt(String mnvrInMlDistCtnt) {
		this.mnvrInMlDistCtnt = mnvrInMlDistCtnt;
	}
	
	/**
	 * Column Info
	 * @param rcvEaiIfId
	 */
	public void setRcvEaiIfId(String rcvEaiIfId) {
		this.rcvEaiIfId = rcvEaiIfId;
	}
	
	/**
	 * Column Info
	 * @param arrDoilCtnt
	 */
	public void setArrDoilCtnt(String arrDoilCtnt) {
		this.arrDoilCtnt = arrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param depRptErrSeq
	 */
	public void setDepRptErrSeq(String depRptErrSeq) {
		this.depRptErrSeq = depRptErrSeq;
	}
	
	/**
	 * Column Info
	 * @param seaMnFoilCtnt
	 */
	public void setSeaMnFoilCtnt(String seaMnFoilCtnt) {
		this.seaMnFoilCtnt = seaMnFoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaBlrDoilCtnt
	 */
	public void setSeaBlrDoilCtnt(String seaBlrDoilCtnt) {
		this.seaBlrDoilCtnt = seaBlrDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param seaMnLowSulpDoilCtnt
	 */
	public void setSeaMnLowSulpDoilCtnt(String seaMnLowSulpDoilCtnt) {
		this.seaMnLowSulpDoilCtnt = seaMnLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpDoilCtnt
	 */
	public void setDepLowSulpDoilCtnt(String depLowSulpDoilCtnt) {
		this.depLowSulpDoilCtnt = depLowSulpDoilCtnt;
	}
	
	/**
	 * Column Info
	 * @param mcntrObrdTeuCtnt
	 */
	public void setMcntrObrdTeuCtnt(String mcntrObrdTeuCtnt) {
		this.mcntrObrdTeuCtnt = mcntrObrdTeuCtnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilBdrCtnt
	 */
	public void setSplLowSulpFoilBdrCtnt(String splLowSulpFoilBdrCtnt) {
		this.splLowSulpFoilBdrCtnt = splLowSulpFoilBdrCtnt;
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
		setPortBlrLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "port_blr_low_sulp_doil_ctnt", ""));
		setPltInDt(JSPUtil.getParameter(request, prefix + "plt_in_dt", ""));
		setSeaGnrLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "sea_gnr_low_sulp_doil_ctnt", ""));
		setDepLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_foil_ctnt", ""));
		setSplLowSulpDoilBdrCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_bdr_ctnt", ""));
		setLstRfCntrObrdKntCtnt(JSPUtil.getParameter(request, prefix + "lst_rf_cntr_obrd_knt_ctnt", ""));
		setArrLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_ctnt", ""));
		setBfrBrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_drp_dt", ""));
		setDepRptErrTpCd(JSPUtil.getParameter(request, prefix + "dep_rpt_err_tp_cd", ""));
		setSailTmHrs(JSPUtil.getParameter(request, prefix + "sail_tm_hrs", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setRmnDistCtnt(JSPUtil.getParameter(request, prefix + "rmn_dist_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAvgMnvrInMlDist(JSPUtil.getParameter(request, prefix + "avg_mnvr_in_ml_dist", ""));
		setSeaMnLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "sea_mn_low_sulp_foil_ctnt", ""));
		setPortMnLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "port_mn_low_sulp_doil_ctnt", ""));
		setCallUiId(JSPUtil.getParameter(request, prefix + "call_ui_id", ""));
		setDepFoilCtnt(JSPUtil.getParameter(request, prefix + "dep_foil_ctnt", ""));
		setFcntrObrdTeuCtnt(JSPUtil.getParameter(request, prefix + "fcntr_obrd_teu_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSeaGnrFoilCtnt(JSPUtil.getParameter(request, prefix + "sea_gnr_foil_ctnt", ""));
		setLstDepDoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_doil_ctnt", ""));
		setErrItmCtnt(JSPUtil.getParameter(request, prefix + "err_itm_ctnt", ""));
		setDepCgoCtnt(JSPUtil.getParameter(request, prefix + "dep_cgo_ctnt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setLstPortRupDt(JSPUtil.getParameter(request, prefix + "lst_port_rup_dt", ""));
		setPltOutDt(JSPUtil.getParameter(request, prefix + "plt_out_dt", ""));
		setAvgPortTtlHrQty(JSPUtil.getParameter(request, prefix + "avg_port_ttl_hr_qty", ""));
		setSeaGnrLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "sea_gnr_low_sulp_foil_ctnt", ""));
		setPortGnrLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "port_gnr_low_sulp_foil_ctnt", ""));
		setArrGmCtnt(JSPUtil.getParameter(request, prefix + "arr_gm_ctnt", ""));
		setPortMnFoilCtnt(JSPUtil.getParameter(request, prefix + "port_mn_foil_ctnt", ""));
		setArrFwddrCtnt(JSPUtil.getParameter(request, prefix + "arr_fwddr_ctnt", ""));
		setAvgRpmPwrCtnt(JSPUtil.getParameter(request, prefix + "avg_rpm_pwr_ctnt", ""));
		setMnvrOutMlDistCtnt(JSPUtil.getParameter(request, prefix + "mnvr_out_ml_dist_ctnt", ""));
		setPortGnrDoilCtnt(JSPUtil.getParameter(request, prefix + "port_gnr_doil_ctnt", ""));
		setOldVslCd(JSPUtil.getParameter(request, prefix + "old_vsl_cd", ""));
		setDepGmCtnt(JSPUtil.getParameter(request, prefix + "dep_gm_ctnt", ""));
		setSeaGnrDoilCtnt(JSPUtil.getParameter(request, prefix + "sea_gnr_doil_ctnt", ""));
		setLstDepLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_low_sulp_foil_ctnt", ""));
		setPortMnDoilCtnt(JSPUtil.getParameter(request, prefix + "port_mn_doil_ctnt", ""));
		setBfrBrthAnkOffDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_off_dt", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setDepMidDrftCtnt(JSPUtil.getParameter(request, prefix + "dep_mid_drft_ctnt", ""));
		setSeaBlrLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "sea_blr_low_sulp_foil_ctnt", ""));
		setSplLowSulpDoilActCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_act_ctnt", ""));
		setSplDoilSulpCtnt(JSPUtil.getParameter(request, prefix + "spl_doil_sulp_ctnt", ""));
		setArrFoilCtnt(JSPUtil.getParameter(request, prefix + "arr_foil_ctnt", ""));
		setDepRptClsSeq(JSPUtil.getParameter(request, prefix + "dep_rpt_cls_seq", ""));
		setLstDepFoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_foil_ctnt", ""));
		setRupDt(JSPUtil.getParameter(request, prefix + "rup_dt", ""));
		setSplDoilActCtnt(JSPUtil.getParameter(request, prefix + "spl_doil_act_ctnt", ""));
		setSbEngDt(JSPUtil.getParameter(request, prefix + "sb_eng_dt", ""));
		setCgoWrkEndDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_end_dt", ""));
		setPortBlrLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "port_blr_low_sulp_foil_ctnt", ""));
		setRmnAvgSpdCtnt(JSPUtil.getParameter(request, prefix + "rmn_avg_spd_ctnt", ""));
		setEngMlDistCtnt(JSPUtil.getParameter(request, prefix + "eng_ml_dist_ctnt", ""));
		setAvgPrlrPchVal(JSPUtil.getParameter(request, prefix + "avg_prlr_pch_val", ""));
		setRfCntrLodKntCtnt(JSPUtil.getParameter(request, prefix + "rf_cntr_lod_knt_ctnt", ""));
		setSplFoilActCtnt(JSPUtil.getParameter(request, prefix + "spl_foil_act_ctnt", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setRfCntrDchgKntCtnt(JSPUtil.getParameter(request, prefix + "rf_cntr_dchg_knt_ctnt", ""));
		setSplFoilBdrCtnt(JSPUtil.getParameter(request, prefix + "spl_foil_bdr_ctnt", ""));
		setArrLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_foil_ctnt", ""));
		setDepFwddrCtnt(JSPUtil.getParameter(request, prefix + "dep_fwddr_ctnt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLstDepPortCd(JSPUtil.getParameter(request, prefix + "lst_dep_port_cd", ""));
		setAftUnbrthAnkOffDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_off_dt", ""));
		setDepDplCtnt(JSPUtil.getParameter(request, prefix + "dep_dpl_ctnt", ""));
		setSeaMnDoilCtnt(JSPUtil.getParameter(request, prefix + "sea_mn_doil_ctnt", ""));
		setOldClptIndSeq(JSPUtil.getParameter(request, prefix + "old_clpt_ind_seq", ""));
		setCgoWrkStDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_st_dt", ""));
		setPortGnrFoilCtnt(JSPUtil.getParameter(request, prefix + "port_gnr_foil_ctnt", ""));
		setSplFoilSulpCtnt(JSPUtil.getParameter(request, prefix + "spl_foil_sulp_ctnt", ""));
		setAvgPortTtlQty(JSPUtil.getParameter(request, prefix + "avg_port_ttl_qty", ""));
		setAftUnbrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_drp_dt", ""));
		setArrAftdrCtnt(JSPUtil.getParameter(request, prefix + "arr_aftdr_ctnt", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setTtlCntrObrdTeuCtnt(JSPUtil.getParameter(request, prefix + "ttl_cntr_obrd_teu_ctnt", ""));
		setPortGnrLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "port_gnr_low_sulp_doil_ctnt", ""));
		setAvgSpdCtnt(JSPUtil.getParameter(request, prefix + "avg_spd_ctnt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPortBlrDoilCtnt(JSPUtil.getParameter(request, prefix + "port_blr_doil_ctnt", ""));
		setDepDoilCtnt(JSPUtil.getParameter(request, prefix + "dep_doil_ctnt", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOldDepPortCd(JSPUtil.getParameter(request, prefix + "old_dep_port_cd", ""));
		setAvgNvgtMlDist(JSPUtil.getParameter(request, prefix + "avg_nvgt_ml_dist", ""));
		setOldSkdDirCd(JSPUtil.getParameter(request, prefix + "old_skd_dir_cd", ""));
		setNvgtMlDistCtnt(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist_ctnt", ""));
		setNxtPortEtaDt(JSPUtil.getParameter(request, prefix + "nxt_port_eta_dt", ""));
		setSplLowSulpDoilSulpCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_sulp_ctnt", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setSeaStmngMnEngTtlQty(JSPUtil.getParameter(request, prefix + "sea_stmng_mn_eng_ttl_qty", ""));
		setSplLowSulpFoilSulpCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_sulp_ctnt", ""));
		setPortBlrFoilCtnt(JSPUtil.getParameter(request, prefix + "port_blr_foil_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSeaBlrLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "sea_blr_low_sulp_doil_ctnt", ""));
		setSeaBlrFoilCtnt(JSPUtil.getParameter(request, prefix + "sea_blr_foil_ctnt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstDepLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "lst_dep_low_sulp_doil_ctnt", ""));
		setArrMidDrftCtnt(JSPUtil.getParameter(request, prefix + "arr_mid_drft_ctnt", ""));
		setRfCntrObrdKntCtnt(JSPUtil.getParameter(request, prefix + "rf_cntr_obrd_knt_ctnt", ""));
		setPortMnLowSulpFoilCtnt(JSPUtil.getParameter(request, prefix + "port_mn_low_sulp_foil_ctnt", ""));
		setAvgMnvrOutMlDist(JSPUtil.getParameter(request, prefix + "avg_mnvr_out_ml_dist", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSplDoilBdrCtnt(JSPUtil.getParameter(request, prefix + "spl_doil_bdr_ctnt", ""));
		setSplLowSulpFoilActCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_act_ctnt", ""));
		setDepAftdrCtnt(JSPUtil.getParameter(request, prefix + "dep_aftdr_ctnt", ""));
		setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
		setOldSkdVoyNo(JSPUtil.getParameter(request, prefix + "old_skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setMnvrInMlDistCtnt(JSPUtil.getParameter(request, prefix + "mnvr_in_ml_dist_ctnt", ""));
		setRcvEaiIfId(JSPUtil.getParameter(request, prefix + "rcv_eai_if_id", ""));
		setArrDoilCtnt(JSPUtil.getParameter(request, prefix + "arr_doil_ctnt", ""));
		setDepRptErrSeq(JSPUtil.getParameter(request, prefix + "dep_rpt_err_seq", ""));
		setSeaMnFoilCtnt(JSPUtil.getParameter(request, prefix + "sea_mn_foil_ctnt", ""));
		setSeaBlrDoilCtnt(JSPUtil.getParameter(request, prefix + "sea_blr_doil_ctnt", ""));
		setSeaMnLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "sea_mn_low_sulp_doil_ctnt", ""));
		setDepLowSulpDoilCtnt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_doil_ctnt", ""));
		setMcntrObrdTeuCtnt(JSPUtil.getParameter(request, prefix + "mcntr_obrd_teu_ctnt", ""));
		setSplLowSulpFoilBdrCtnt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_bdr_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmDepRptErrClsVO[]
	 */
	public FcmDepRptErrClsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmDepRptErrClsVO[]
	 */
	public FcmDepRptErrClsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmDepRptErrClsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portBlrLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_blr_low_sulp_doil_ctnt", length));
			String[] pltInDt = (JSPUtil.getParameter(request, prefix	+ "plt_in_dt", length));
			String[] seaGnrLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_low_sulp_doil_ctnt", length));
			String[] depLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_foil_ctnt", length));
			String[] splLowSulpDoilBdrCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_bdr_ctnt", length));
			String[] lstRfCntrObrdKntCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_rf_cntr_obrd_knt_ctnt", length));
			String[] arrLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_ctnt", length));
			String[] bfrBrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_drp_dt", length));
			String[] depRptErrTpCd = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_err_tp_cd", length));
			String[] sailTmHrs = (JSPUtil.getParameter(request, prefix	+ "sail_tm_hrs", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] rmnDistCtnt = (JSPUtil.getParameter(request, prefix	+ "rmn_dist_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] avgMnvrInMlDist = (JSPUtil.getParameter(request, prefix	+ "avg_mnvr_in_ml_dist", length));
			String[] seaMnLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_mn_low_sulp_foil_ctnt", length));
			String[] portMnLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_mn_low_sulp_doil_ctnt", length));
			String[] callUiId = (JSPUtil.getParameter(request, prefix	+ "call_ui_id", length));
			String[] depFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_foil_ctnt", length));
			String[] fcntrObrdTeuCtnt = (JSPUtil.getParameter(request, prefix	+ "fcntr_obrd_teu_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] seaGnrFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_foil_ctnt", length));
			String[] lstDepDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_doil_ctnt", length));
			String[] errItmCtnt = (JSPUtil.getParameter(request, prefix	+ "err_itm_ctnt", length));
			String[] depCgoCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_cgo_ctnt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] lstPortRupDt = (JSPUtil.getParameter(request, prefix	+ "lst_port_rup_dt", length));
			String[] pltOutDt = (JSPUtil.getParameter(request, prefix	+ "plt_out_dt", length));
			String[] avgPortTtlHrQty = (JSPUtil.getParameter(request, prefix	+ "avg_port_ttl_hr_qty", length));
			String[] seaGnrLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_low_sulp_foil_ctnt", length));
			String[] portGnrLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_gnr_low_sulp_foil_ctnt", length));
			String[] arrGmCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_gm_ctnt", length));
			String[] portMnFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_mn_foil_ctnt", length));
			String[] arrFwddrCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_fwddr_ctnt", length));
			String[] avgRpmPwrCtnt = (JSPUtil.getParameter(request, prefix	+ "avg_rpm_pwr_ctnt", length));
			String[] mnvrOutMlDistCtnt = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_ml_dist_ctnt", length));
			String[] portGnrDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_gnr_doil_ctnt", length));
			String[] oldVslCd = (JSPUtil.getParameter(request, prefix	+ "old_vsl_cd", length));
			String[] depGmCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_gm_ctnt", length));
			String[] seaGnrDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_doil_ctnt", length));
			String[] lstDepLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_low_sulp_foil_ctnt", length));
			String[] portMnDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_mn_doil_ctnt", length));
			String[] bfrBrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_off_dt", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] depMidDrftCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_mid_drft_ctnt", length));
			String[] seaBlrLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_blr_low_sulp_foil_ctnt", length));
			String[] splLowSulpDoilActCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_act_ctnt", length));
			String[] splDoilSulpCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_sulp_ctnt", length));
			String[] arrFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_foil_ctnt", length));
			String[] depRptClsSeq = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_cls_seq", length));
			String[] lstDepFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_foil_ctnt", length));
			String[] rupDt = (JSPUtil.getParameter(request, prefix	+ "rup_dt", length));
			String[] splDoilActCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_act_ctnt", length));
			String[] sbEngDt = (JSPUtil.getParameter(request, prefix	+ "sb_eng_dt", length));
			String[] cgoWrkEndDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_end_dt", length));
			String[] portBlrLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_blr_low_sulp_foil_ctnt", length));
			String[] rmnAvgSpdCtnt = (JSPUtil.getParameter(request, prefix	+ "rmn_avg_spd_ctnt", length));
			String[] engMlDistCtnt = (JSPUtil.getParameter(request, prefix	+ "eng_ml_dist_ctnt", length));
			String[] avgPrlrPchVal = (JSPUtil.getParameter(request, prefix	+ "avg_prlr_pch_val", length));
			String[] rfCntrLodKntCtnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_lod_knt_ctnt", length));
			String[] splFoilActCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_act_ctnt", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] rfCntrDchgKntCtnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_dchg_knt_ctnt", length));
			String[] splFoilBdrCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_bdr_ctnt", length));
			String[] arrLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_foil_ctnt", length));
			String[] depFwddrCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_fwddr_ctnt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lstDepPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_dep_port_cd", length));
			String[] aftUnbrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_off_dt", length));
			String[] depDplCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_dpl_ctnt", length));
			String[] seaMnDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_mn_doil_ctnt", length));
			String[] oldClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "old_clpt_ind_seq", length));
			String[] cgoWrkStDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_st_dt", length));
			String[] portGnrFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_gnr_foil_ctnt", length));
			String[] splFoilSulpCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_sulp_ctnt", length));
			String[] avgPortTtlQty = (JSPUtil.getParameter(request, prefix	+ "avg_port_ttl_qty", length));
			String[] aftUnbrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_drp_dt", length));
			String[] arrAftdrCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_aftdr_ctnt", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] ttlCntrObrdTeuCtnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_obrd_teu_ctnt", length));
			String[] portGnrLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_gnr_low_sulp_doil_ctnt", length));
			String[] avgSpdCtnt = (JSPUtil.getParameter(request, prefix	+ "avg_spd_ctnt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] portBlrDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_blr_doil_ctnt", length));
			String[] depDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_doil_ctnt", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] oldDepPortCd = (JSPUtil.getParameter(request, prefix	+ "old_dep_port_cd", length));
			String[] avgNvgtMlDist = (JSPUtil.getParameter(request, prefix	+ "avg_nvgt_ml_dist", length));
			String[] oldSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "old_skd_dir_cd", length));
			String[] nvgtMlDistCtnt = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist_ctnt", length));
			String[] nxtPortEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta_dt", length));
			String[] splLowSulpDoilSulpCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_sulp_ctnt", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] seaStmngMnEngTtlQty = (JSPUtil.getParameter(request, prefix	+ "sea_stmng_mn_eng_ttl_qty", length));
			String[] splLowSulpFoilSulpCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_sulp_ctnt", length));
			String[] portBlrFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_blr_foil_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] seaBlrLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_blr_low_sulp_doil_ctnt", length));
			String[] seaBlrFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_blr_foil_ctnt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstDepLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "lst_dep_low_sulp_doil_ctnt", length));
			String[] arrMidDrftCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_mid_drft_ctnt", length));
			String[] rfCntrObrdKntCtnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_obrd_knt_ctnt", length));
			String[] portMnLowSulpFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "port_mn_low_sulp_foil_ctnt", length));
			String[] avgMnvrOutMlDist = (JSPUtil.getParameter(request, prefix	+ "avg_mnvr_out_ml_dist", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] splDoilBdrCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_bdr_ctnt", length));
			String[] splLowSulpFoilActCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_act_ctnt", length));
			String[] depAftdrCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_aftdr_ctnt", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] oldSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "old_skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] mnvrInMlDistCtnt = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_ml_dist_ctnt", length));
			String[] rcvEaiIfId = (JSPUtil.getParameter(request, prefix	+ "rcv_eai_if_id", length));
			String[] arrDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "arr_doil_ctnt", length));
			String[] depRptErrSeq = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_err_seq", length));
			String[] seaMnFoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_mn_foil_ctnt", length));
			String[] seaBlrDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_blr_doil_ctnt", length));
			String[] seaMnLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "sea_mn_low_sulp_doil_ctnt", length));
			String[] depLowSulpDoilCtnt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_doil_ctnt", length));
			String[] mcntrObrdTeuCtnt = (JSPUtil.getParameter(request, prefix	+ "mcntr_obrd_teu_ctnt", length));
			String[] splLowSulpFoilBdrCtnt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_bdr_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmDepRptErrClsVO();
				if (portBlrLowSulpDoilCtnt[i] != null)
					model.setPortBlrLowSulpDoilCtnt(portBlrLowSulpDoilCtnt[i]);
				if (pltInDt[i] != null)
					model.setPltInDt(pltInDt[i]);
				if (seaGnrLowSulpDoilCtnt[i] != null)
					model.setSeaGnrLowSulpDoilCtnt(seaGnrLowSulpDoilCtnt[i]);
				if (depLowSulpFoilCtnt[i] != null)
					model.setDepLowSulpFoilCtnt(depLowSulpFoilCtnt[i]);
				if (splLowSulpDoilBdrCtnt[i] != null)
					model.setSplLowSulpDoilBdrCtnt(splLowSulpDoilBdrCtnt[i]);
				if (lstRfCntrObrdKntCtnt[i] != null)
					model.setLstRfCntrObrdKntCtnt(lstRfCntrObrdKntCtnt[i]);
				if (arrLowSulpDoilCtnt[i] != null)
					model.setArrLowSulpDoilCtnt(arrLowSulpDoilCtnt[i]);
				if (bfrBrthAnkDrpDt[i] != null)
					model.setBfrBrthAnkDrpDt(bfrBrthAnkDrpDt[i]);
				if (depRptErrTpCd[i] != null)
					model.setDepRptErrTpCd(depRptErrTpCd[i]);
				if (sailTmHrs[i] != null)
					model.setSailTmHrs(sailTmHrs[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (rmnDistCtnt[i] != null)
					model.setRmnDistCtnt(rmnDistCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (avgMnvrInMlDist[i] != null)
					model.setAvgMnvrInMlDist(avgMnvrInMlDist[i]);
				if (seaMnLowSulpFoilCtnt[i] != null)
					model.setSeaMnLowSulpFoilCtnt(seaMnLowSulpFoilCtnt[i]);
				if (portMnLowSulpDoilCtnt[i] != null)
					model.setPortMnLowSulpDoilCtnt(portMnLowSulpDoilCtnt[i]);
				if (callUiId[i] != null)
					model.setCallUiId(callUiId[i]);
				if (depFoilCtnt[i] != null)
					model.setDepFoilCtnt(depFoilCtnt[i]);
				if (fcntrObrdTeuCtnt[i] != null)
					model.setFcntrObrdTeuCtnt(fcntrObrdTeuCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (seaGnrFoilCtnt[i] != null)
					model.setSeaGnrFoilCtnt(seaGnrFoilCtnt[i]);
				if (lstDepDoilCtnt[i] != null)
					model.setLstDepDoilCtnt(lstDepDoilCtnt[i]);
				if (errItmCtnt[i] != null)
					model.setErrItmCtnt(errItmCtnt[i]);
				if (depCgoCtnt[i] != null)
					model.setDepCgoCtnt(depCgoCtnt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (lstPortRupDt[i] != null)
					model.setLstPortRupDt(lstPortRupDt[i]);
				if (pltOutDt[i] != null)
					model.setPltOutDt(pltOutDt[i]);
				if (avgPortTtlHrQty[i] != null)
					model.setAvgPortTtlHrQty(avgPortTtlHrQty[i]);
				if (seaGnrLowSulpFoilCtnt[i] != null)
					model.setSeaGnrLowSulpFoilCtnt(seaGnrLowSulpFoilCtnt[i]);
				if (portGnrLowSulpFoilCtnt[i] != null)
					model.setPortGnrLowSulpFoilCtnt(portGnrLowSulpFoilCtnt[i]);
				if (arrGmCtnt[i] != null)
					model.setArrGmCtnt(arrGmCtnt[i]);
				if (portMnFoilCtnt[i] != null)
					model.setPortMnFoilCtnt(portMnFoilCtnt[i]);
				if (arrFwddrCtnt[i] != null)
					model.setArrFwddrCtnt(arrFwddrCtnt[i]);
				if (avgRpmPwrCtnt[i] != null)
					model.setAvgRpmPwrCtnt(avgRpmPwrCtnt[i]);
				if (mnvrOutMlDistCtnt[i] != null)
					model.setMnvrOutMlDistCtnt(mnvrOutMlDistCtnt[i]);
				if (portGnrDoilCtnt[i] != null)
					model.setPortGnrDoilCtnt(portGnrDoilCtnt[i]);
				if (oldVslCd[i] != null)
					model.setOldVslCd(oldVslCd[i]);
				if (depGmCtnt[i] != null)
					model.setDepGmCtnt(depGmCtnt[i]);
				if (seaGnrDoilCtnt[i] != null)
					model.setSeaGnrDoilCtnt(seaGnrDoilCtnt[i]);
				if (lstDepLowSulpFoilCtnt[i] != null)
					model.setLstDepLowSulpFoilCtnt(lstDepLowSulpFoilCtnt[i]);
				if (portMnDoilCtnt[i] != null)
					model.setPortMnDoilCtnt(portMnDoilCtnt[i]);
				if (bfrBrthAnkOffDt[i] != null)
					model.setBfrBrthAnkOffDt(bfrBrthAnkOffDt[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (depMidDrftCtnt[i] != null)
					model.setDepMidDrftCtnt(depMidDrftCtnt[i]);
				if (seaBlrLowSulpFoilCtnt[i] != null)
					model.setSeaBlrLowSulpFoilCtnt(seaBlrLowSulpFoilCtnt[i]);
				if (splLowSulpDoilActCtnt[i] != null)
					model.setSplLowSulpDoilActCtnt(splLowSulpDoilActCtnt[i]);
				if (splDoilSulpCtnt[i] != null)
					model.setSplDoilSulpCtnt(splDoilSulpCtnt[i]);
				if (arrFoilCtnt[i] != null)
					model.setArrFoilCtnt(arrFoilCtnt[i]);
				if (depRptClsSeq[i] != null)
					model.setDepRptClsSeq(depRptClsSeq[i]);
				if (lstDepFoilCtnt[i] != null)
					model.setLstDepFoilCtnt(lstDepFoilCtnt[i]);
				if (rupDt[i] != null)
					model.setRupDt(rupDt[i]);
				if (splDoilActCtnt[i] != null)
					model.setSplDoilActCtnt(splDoilActCtnt[i]);
				if (sbEngDt[i] != null)
					model.setSbEngDt(sbEngDt[i]);
				if (cgoWrkEndDt[i] != null)
					model.setCgoWrkEndDt(cgoWrkEndDt[i]);
				if (portBlrLowSulpFoilCtnt[i] != null)
					model.setPortBlrLowSulpFoilCtnt(portBlrLowSulpFoilCtnt[i]);
				if (rmnAvgSpdCtnt[i] != null)
					model.setRmnAvgSpdCtnt(rmnAvgSpdCtnt[i]);
				if (engMlDistCtnt[i] != null)
					model.setEngMlDistCtnt(engMlDistCtnt[i]);
				if (avgPrlrPchVal[i] != null)
					model.setAvgPrlrPchVal(avgPrlrPchVal[i]);
				if (rfCntrLodKntCtnt[i] != null)
					model.setRfCntrLodKntCtnt(rfCntrLodKntCtnt[i]);
				if (splFoilActCtnt[i] != null)
					model.setSplFoilActCtnt(splFoilActCtnt[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (rfCntrDchgKntCtnt[i] != null)
					model.setRfCntrDchgKntCtnt(rfCntrDchgKntCtnt[i]);
				if (splFoilBdrCtnt[i] != null)
					model.setSplFoilBdrCtnt(splFoilBdrCtnt[i]);
				if (arrLowSulpFoilCtnt[i] != null)
					model.setArrLowSulpFoilCtnt(arrLowSulpFoilCtnt[i]);
				if (depFwddrCtnt[i] != null)
					model.setDepFwddrCtnt(depFwddrCtnt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lstDepPortCd[i] != null)
					model.setLstDepPortCd(lstDepPortCd[i]);
				if (aftUnbrthAnkOffDt[i] != null)
					model.setAftUnbrthAnkOffDt(aftUnbrthAnkOffDt[i]);
				if (depDplCtnt[i] != null)
					model.setDepDplCtnt(depDplCtnt[i]);
				if (seaMnDoilCtnt[i] != null)
					model.setSeaMnDoilCtnt(seaMnDoilCtnt[i]);
				if (oldClptIndSeq[i] != null)
					model.setOldClptIndSeq(oldClptIndSeq[i]);
				if (cgoWrkStDt[i] != null)
					model.setCgoWrkStDt(cgoWrkStDt[i]);
				if (portGnrFoilCtnt[i] != null)
					model.setPortGnrFoilCtnt(portGnrFoilCtnt[i]);
				if (splFoilSulpCtnt[i] != null)
					model.setSplFoilSulpCtnt(splFoilSulpCtnt[i]);
				if (avgPortTtlQty[i] != null)
					model.setAvgPortTtlQty(avgPortTtlQty[i]);
				if (aftUnbrthAnkDrpDt[i] != null)
					model.setAftUnbrthAnkDrpDt(aftUnbrthAnkDrpDt[i]);
				if (arrAftdrCtnt[i] != null)
					model.setArrAftdrCtnt(arrAftdrCtnt[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (ttlCntrObrdTeuCtnt[i] != null)
					model.setTtlCntrObrdTeuCtnt(ttlCntrObrdTeuCtnt[i]);
				if (portGnrLowSulpDoilCtnt[i] != null)
					model.setPortGnrLowSulpDoilCtnt(portGnrLowSulpDoilCtnt[i]);
				if (avgSpdCtnt[i] != null)
					model.setAvgSpdCtnt(avgSpdCtnt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (portBlrDoilCtnt[i] != null)
					model.setPortBlrDoilCtnt(portBlrDoilCtnt[i]);
				if (depDoilCtnt[i] != null)
					model.setDepDoilCtnt(depDoilCtnt[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (oldDepPortCd[i] != null)
					model.setOldDepPortCd(oldDepPortCd[i]);
				if (avgNvgtMlDist[i] != null)
					model.setAvgNvgtMlDist(avgNvgtMlDist[i]);
				if (oldSkdDirCd[i] != null)
					model.setOldSkdDirCd(oldSkdDirCd[i]);
				if (nvgtMlDistCtnt[i] != null)
					model.setNvgtMlDistCtnt(nvgtMlDistCtnt[i]);
				if (nxtPortEtaDt[i] != null)
					model.setNxtPortEtaDt(nxtPortEtaDt[i]);
				if (splLowSulpDoilSulpCtnt[i] != null)
					model.setSplLowSulpDoilSulpCtnt(splLowSulpDoilSulpCtnt[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (seaStmngMnEngTtlQty[i] != null)
					model.setSeaStmngMnEngTtlQty(seaStmngMnEngTtlQty[i]);
				if (splLowSulpFoilSulpCtnt[i] != null)
					model.setSplLowSulpFoilSulpCtnt(splLowSulpFoilSulpCtnt[i]);
				if (portBlrFoilCtnt[i] != null)
					model.setPortBlrFoilCtnt(portBlrFoilCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (seaBlrLowSulpDoilCtnt[i] != null)
					model.setSeaBlrLowSulpDoilCtnt(seaBlrLowSulpDoilCtnt[i]);
				if (seaBlrFoilCtnt[i] != null)
					model.setSeaBlrFoilCtnt(seaBlrFoilCtnt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstDepLowSulpDoilCtnt[i] != null)
					model.setLstDepLowSulpDoilCtnt(lstDepLowSulpDoilCtnt[i]);
				if (arrMidDrftCtnt[i] != null)
					model.setArrMidDrftCtnt(arrMidDrftCtnt[i]);
				if (rfCntrObrdKntCtnt[i] != null)
					model.setRfCntrObrdKntCtnt(rfCntrObrdKntCtnt[i]);
				if (portMnLowSulpFoilCtnt[i] != null)
					model.setPortMnLowSulpFoilCtnt(portMnLowSulpFoilCtnt[i]);
				if (avgMnvrOutMlDist[i] != null)
					model.setAvgMnvrOutMlDist(avgMnvrOutMlDist[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (splDoilBdrCtnt[i] != null)
					model.setSplDoilBdrCtnt(splDoilBdrCtnt[i]);
				if (splLowSulpFoilActCtnt[i] != null)
					model.setSplLowSulpFoilActCtnt(splLowSulpFoilActCtnt[i]);
				if (depAftdrCtnt[i] != null)
					model.setDepAftdrCtnt(depAftdrCtnt[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (oldSkdVoyNo[i] != null)
					model.setOldSkdVoyNo(oldSkdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (mnvrInMlDistCtnt[i] != null)
					model.setMnvrInMlDistCtnt(mnvrInMlDistCtnt[i]);
				if (rcvEaiIfId[i] != null)
					model.setRcvEaiIfId(rcvEaiIfId[i]);
				if (arrDoilCtnt[i] != null)
					model.setArrDoilCtnt(arrDoilCtnt[i]);
				if (depRptErrSeq[i] != null)
					model.setDepRptErrSeq(depRptErrSeq[i]);
				if (seaMnFoilCtnt[i] != null)
					model.setSeaMnFoilCtnt(seaMnFoilCtnt[i]);
				if (seaBlrDoilCtnt[i] != null)
					model.setSeaBlrDoilCtnt(seaBlrDoilCtnt[i]);
				if (seaMnLowSulpDoilCtnt[i] != null)
					model.setSeaMnLowSulpDoilCtnt(seaMnLowSulpDoilCtnt[i]);
				if (depLowSulpDoilCtnt[i] != null)
					model.setDepLowSulpDoilCtnt(depLowSulpDoilCtnt[i]);
				if (mcntrObrdTeuCtnt[i] != null)
					model.setMcntrObrdTeuCtnt(mcntrObrdTeuCtnt[i]);
				if (splLowSulpFoilBdrCtnt[i] != null)
					model.setSplLowSulpFoilBdrCtnt(splLowSulpFoilBdrCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmDepRptErrClsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmDepRptErrClsVO[]
	 */
	public FcmDepRptErrClsVO[] getFcmDepRptErrClsVOs(){
		FcmDepRptErrClsVO[] vos = (FcmDepRptErrClsVO[])models.toArray(new FcmDepRptErrClsVO[models.size()]);
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
		this.portBlrLowSulpDoilCtnt = this.portBlrLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltInDt = this.pltInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrLowSulpDoilCtnt = this.seaGnrLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilCtnt = this.depLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBdrCtnt = this.splLowSulpDoilBdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstRfCntrObrdKntCtnt = this.lstRfCntrObrdKntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilCtnt = this.arrLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkDrpDt = this.bfrBrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptErrTpCd = this.depRptErrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailTmHrs = this.sailTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnDistCtnt = this.rmnDistCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgMnvrInMlDist = this.avgMnvrInMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnLowSulpFoilCtnt = this.seaMnLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnLowSulpDoilCtnt = this.portMnLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callUiId = this.callUiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilCtnt = this.depFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrObrdTeuCtnt = this.fcntrObrdTeuCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrFoilCtnt = this.seaGnrFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepDoilCtnt = this.lstDepDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errItmCtnt = this.errItmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depCgoCtnt = this.depCgoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstPortRupDt = this.lstPortRupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltOutDt = this.pltOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPortTtlHrQty = this.avgPortTtlHrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrLowSulpFoilCtnt = this.seaGnrLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrLowSulpFoilCtnt = this.portGnrLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGmCtnt = this.arrGmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnFoilCtnt = this.portMnFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFwddrCtnt = this.arrFwddrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRpmPwrCtnt = this.avgRpmPwrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutMlDistCtnt = this.mnvrOutMlDistCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrDoilCtnt = this.portGnrDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVslCd = this.oldVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depGmCtnt = this.depGmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrDoilCtnt = this.seaGnrDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepLowSulpFoilCtnt = this.lstDepLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnDoilCtnt = this.portMnDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkOffDt = this.bfrBrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMidDrftCtnt = this.depMidDrftCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrLowSulpFoilCtnt = this.seaBlrLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilActCtnt = this.splLowSulpDoilActCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilSulpCtnt = this.splDoilSulpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFoilCtnt = this.arrFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptClsSeq = this.depRptClsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepFoilCtnt = this.lstDepFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rupDt = this.rupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilActCtnt = this.splDoilActCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbEngDt = this.sbEngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkEndDt = this.cgoWrkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrLowSulpFoilCtnt = this.portBlrLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnAvgSpdCtnt = this.rmnAvgSpdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engMlDistCtnt = this.engMlDistCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPrlrPchVal = this.avgPrlrPchVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrLodKntCtnt = this.rfCntrLodKntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilActCtnt = this.splFoilActCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrDchgKntCtnt = this.rfCntrDchgKntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBdrCtnt = this.splFoilBdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpFoilCtnt = this.arrLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFwddrCtnt = this.depFwddrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepPortCd = this.lstDepPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkOffDt = this.aftUnbrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDplCtnt = this.depDplCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnDoilCtnt = this.seaMnDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldClptIndSeq = this.oldClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkStDt = this.cgoWrkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrFoilCtnt = this.portGnrFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilSulpCtnt = this.splFoilSulpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgPortTtlQty = this.avgPortTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkDrpDt = this.aftUnbrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrAftdrCtnt = this.arrAftdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrObrdTeuCtnt = this.ttlCntrObrdTeuCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrLowSulpDoilCtnt = this.portGnrLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpdCtnt = this.avgSpdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrDoilCtnt = this.portBlrDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDoilCtnt = this.depDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDepPortCd = this.oldDepPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgNvgtMlDist = this.avgNvgtMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSkdDirCd = this.oldSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDistCtnt = this.nvgtMlDistCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEtaDt = this.nxtPortEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilSulpCtnt = this.splLowSulpDoilSulpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaStmngMnEngTtlQty = this.seaStmngMnEngTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilSulpCtnt = this.splLowSulpFoilSulpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrFoilCtnt = this.portBlrFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrLowSulpDoilCtnt = this.seaBlrLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrFoilCtnt = this.seaBlrFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstDepLowSulpDoilCtnt = this.lstDepLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMidDrftCtnt = this.arrMidDrftCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrObrdKntCtnt = this.rfCntrObrdKntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnLowSulpFoilCtnt = this.portMnLowSulpFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgMnvrOutMlDist = this.avgMnvrOutMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBdrCtnt = this.splDoilBdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilActCtnt = this.splLowSulpFoilActCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAftdrCtnt = this.depAftdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSkdVoyNo = this.oldSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInMlDistCtnt = this.mnvrInMlDistCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvEaiIfId = this.rcvEaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilCtnt = this.arrDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptErrSeq = this.depRptErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnFoilCtnt = this.seaMnFoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrDoilCtnt = this.seaBlrDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnLowSulpDoilCtnt = this.seaMnLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpDoilCtnt = this.depLowSulpDoilCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrObrdTeuCtnt = this.mcntrObrdTeuCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBdrCtnt = this.splLowSulpFoilBdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
