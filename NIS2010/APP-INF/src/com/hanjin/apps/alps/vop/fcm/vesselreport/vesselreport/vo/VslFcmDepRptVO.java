/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VslFcmDepRptVO.java
*@FileTitle : VslFcmDepRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo;

import java.lang.reflect.Field;
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

public class VslFcmDepRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslFcmDepRptVO> models = new ArrayList<VslFcmDepRptVO>();
	
	/* Column Info */
	private String splLowSulpFoilActWgt = null;
	/* Column Info */
	private String pltInDt = null;
	/* Column Info */
	private String seaBlrDoilCsmQty = null;
	/* Column Info */
	private String bfrBrthAnkDrpDt = null;
	/* Column Info */
	private String arrFoilWgt = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String proPitch = null;
	/* Column Info */
	private String nvgtMlDist = null;
	/* Column Info */
	private String depBlstWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String seaGnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String depFoilWgt = null;
	/* Column Info */
	private String splLowSulpFoilBdrWgt = null;
	/* Column Info */
	private String splFoilActWgt = null;
	/* Column Info */
	private String avgRpmPwr = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pltOutDt = null;
	/* Column Info */
	private String depFwddrHgt = null;
	/* Column Info */
	private String depGmHgt = null;
	/* Column Info */
	private String portBlrDoilCsmQty = null;
	/* Column Info */
	private String depDplWgt = null;
	/* Column Info */
	private String seaTtlLowSulpDoilCsmQty = null;
	/* Column Info */
	private String splFoilSulpWgt = null;
	/* Column Info */
	private String bfrBrthAnkOffDt = null;
	/* Column Info */
	private String rmnAvgSpd = null;
	/* Column Info */
	private String depCgoWgt = null;
	/* Column Info */
	private String mnvrInMlDist = null;
	/* Column Info */
	private String arrBlstWgt = null;
	/* Column Info */
	private String depDoilWgt = null;
	/* Column Info */
	private String splLowSulpDoilActWgt = null;
	/* Column Info */
	private String arrLowSulpDoilWgt = null;
	/* Column Info */
	private String splLowSulpFoilSulpWgt = null;
	/* Column Info */
	private String splDoilActWgt = null;
	/* Column Info */
	private String rupDt = null;
	/* Column Info */
	private String vskFlg = null;
	/* Column Info */
	private String sbEngDt = null;
	/* Column Info */
	private String cgoWrkEndDt = null;
	/* Column Info */
	private String portMnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String arrAftdrHgt = null;
	/* Column Info */
	private String depLowSulpDoilWgt = null;
	/* Column Info */
	private String depAftdrHgt = null;
	/* Column Info */
	private String portMnFoilCsmQty = null;
	/* Column Info */
	private String seaGnrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String seaTtlLowSulpFoilCsmQty = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String rfCntrDchgKnt = null;
	/* Column Info */
	private String rfCntrObrdKnt = null;
	/* Column Info */
	private String splLowSulpDoilSulpWgt = null;
	/* Column Info */
	private String depLowSulpFoilWgt = null;
	/* Column Info */
	private String seaBlrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String aftUnbrthAnkOffDt = null;
	/* Column Info */
	private String seaTtlDoilCsmQty = null;
	/* Column Info */
	private String splDoilBrgWgt1 = null;
	/* Column Info */
	private String portTtlFoilCsmQty = null;
	/* Column Info */
	private String vskEtdDt = null;
	/* Column Info */
	private String seaMnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String rfCntrLodKnt = null;
	/* Column Info */
	private String splDoilBrgWgt2 = null;
	/* Column Info */
	private String cgoWrkStDt = null;
	/* Column Info */
	private String aftUnbrthAnkDrpDt = null;
	/* Column Info */
	private String seaGnrDoilCsmQty = null;
	/* Column Info */
	private String arrFrshWtrWgt = null;
	/* Column Info */
	private String mnvrOutMlDist = null;
	/* Column Info */
	private String mtyCntrObrdTeu = null;
	/* Column Info */
	private String splLowSulpDoilBdrWgt = null;
	/* Column Info */
	private String portGnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String arrMidDrftHgt = null;
	/* Column Info */
	private String arrFwddrHgt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String portBlrFoilCsmQty = null;
	/* Column Info */
	private String harborInPortTtl = null;
	/* Column Info */
	private String portMnLowSulpDoilCsmQty = null;
	/* Column Info */
	private String rmnDist = null;
	/* Column Info */
	private String seaGnrFoilCsmQty = null;
	/* Column Info */
	private String engMlDist = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String portMnDoilCsmQty = null;
	/* Column Info */
	private String splFoilBrgWgt2 = null;
	/* Column Info */
	private String splFoilBrgWgt1 = null;
	/* Column Info */
	private String skdVoyDir = null;
	/* Column Info */
	private String depFlg = null;
	/* Column Info */
	private String nxtPortEtaDt = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String seaSteamingTtl = null;
	/* Column Info */
	private String seaSteamingMe = null;
	/* Column Info */
	private String portTtlLowSulpFoilCsmQty = null;
	/* Column Info */
	private String portBlrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String portGnrDoilCsmQty = null;
	/* Column Info */
	private String arrLowSulpFoilWgt = null;
	/* Column Info */
	private String depFrshWtrWgt = null;
	/* Column Info */
	private String splLowSulpDoilBrgWgt1 = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String splLowSulpDoilBrgWgt2 = null;
	/* Column Info */
	private String splLowSulpFoilBrgWgt2 = null;
	/* Column Info */
	private String seaBlrFoilCsmQty = null;
	/* Column Info */
	private String splLowSulpFoilBrgWgt1 = null;
	/* Column Info */
	private String lastPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrDoilWgt = null;
	/* Column Info */
	private String splDoilSulpWgt = null;
	/* Column Info */
	private String seaTtlFoilCsmQty = null;
	/* Column Info */
	private String avgExptFlg = null;
	/* Column Info */
	private String sailingTime = null;
	/* Column Info */
	private String portTtlLowSulpDoilCsmQty = null;
	/* Column Info */
	private String seaMnFoilCsmQty = null;
	/* Column Info */
	private String splDoilBdrWgt = null;
	/* Column Info */
	private String ttlCntrObrdTeu = null;
	/* Column Info */
	private String depPortCd = null;
	/* Column Info */
	private String fullCntrObrdTeu = null;
	/* Column Info */
	private String arrGmHgt = null;
	/* Column Info */
	private String portGnrFoilCsmQty = null;
	/* Column Info */
	private String seaMnDoilCsmQty = null;
	/* Column Info */
	private String portGnrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String portBlrLowSulpDoilCsmQty = null;
	/* Column Info */
	private String splFoilBdrWgt = null;
	/* Column Info */
	private String seaBlrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String seaMnLowSulpDoilCsmQty = null;
	/* Column Info */
	private String depMidDrftHgt = null;
	/* Column Info */
	private String portTtlDoilCsmQty = null;
	/* Column Info */
	private String avgSpd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslFcmDepRptVO() {}

	public VslFcmDepRptVO(String ibflag, String pagerows, String vskFlg, String depFlg, String avgExptFlg, String cntrDznCapa, String vslCd, String skdVoyDir, String vslSlanCd, String lastPortCd, String depPortCd, String vskEtdDt, String skdVoyNo, String skdDirCd, String clptIndSeq, String nvgtMlDist, String engMlDist, String mnvrInMlDist, String mnvrOutMlDist, String avgSpd, String avgRpmPwr, String proPitch, String sailingTime, String seaSteamingMe, String seaSteamingTtl, String harborInPortTtl, String seaMnFoilCsmQty, String seaGnrFoilCsmQty, String seaBlrFoilCsmQty, String seaTtlFoilCsmQty, String seaMnLowSulpFoilCsmQty, String seaGnrLowSulpFoilCsmQty, String seaBlrLowSulpFoilCsmQty, String seaTtlLowSulpFoilCsmQty, String seaMnDoilCsmQty, String seaGnrDoilCsmQty, String seaBlrDoilCsmQty, String seaTtlDoilCsmQty, String seaMnLowSulpDoilCsmQty, String seaGnrLowSulpDoilCsmQty, String seaBlrLowSulpDoilCsmQty, String seaTtlLowSulpDoilCsmQty, String portMnFoilCsmQty, String portGnrFoilCsmQty, String portBlrFoilCsmQty, String portTtlFoilCsmQty, String portMnLowSulpFoilCsmQty, String portGnrLowSulpFoilCsmQty, String portBlrLowSulpFoilCsmQty, String portTtlLowSulpFoilCsmQty, String portMnDoilCsmQty, String portGnrDoilCsmQty, String portBlrDoilCsmQty, String portTtlDoilCsmQty, String portMnLowSulpDoilCsmQty, String portGnrLowSulpDoilCsmQty, String portBlrLowSulpDoilCsmQty, String portTtlLowSulpDoilCsmQty, String arrFoilWgt, String arrLowSulpFoilWgt, String arrDoilWgt, String arrLowSulpDoilWgt, String arrFrshWtrWgt, String arrBlstWgt, String depFoilWgt, String depLowSulpFoilWgt, String depDoilWgt, String depLowSulpDoilWgt, String depFrshWtrWgt, String depBlstWgt, String splFoilBdrWgt, String splFoilActWgt, String splFoilSulpWgt, String splFoilBrgWgt1, String splFoilBrgWgt2, String splLowSulpFoilBdrWgt, String splLowSulpFoilActWgt, String splLowSulpFoilSulpWgt, String splLowSulpFoilBrgWgt1, String splLowSulpFoilBrgWgt2, String splDoilBdrWgt, String splDoilActWgt, String splDoilSulpWgt, String splDoilBrgWgt1, String splDoilBrgWgt2, String splLowSulpDoilBdrWgt, String splLowSulpDoilActWgt, String splLowSulpDoilSulpWgt, String splLowSulpDoilBrgWgt1, String splLowSulpDoilBrgWgt2, String nxtPortCd, String nxtPortEtaDt, String rmnDist, String rmnAvgSpd, String sbEngDt, String pltInDt, String bfrBrthAnkDrpDt, String bfrBrthAnkOffDt, String vpsEtbDt, String cgoWrkStDt, String cgoWrkEndDt, String vpsEtdDt, String aftUnbrthAnkDrpDt, String aftUnbrthAnkOffDt, String pltOutDt, String rupDt, String arrFwddrHgt, String arrMidDrftHgt, String arrAftdrHgt, String arrGmHgt, String depFwddrHgt, String depMidDrftHgt, String depAftdrHgt, String depGmHgt, String fullCntrObrdTeu, String mtyCntrObrdTeu, String ttlCntrObrdTeu, String depCgoWgt, String depDplWgt, String rfCntrDchgKnt, String rfCntrLodKnt, String rfCntrObrdKnt, String updUsrId) {
		this.splLowSulpFoilActWgt = splLowSulpFoilActWgt;
		this.pltInDt = pltInDt;
		this.seaBlrDoilCsmQty = seaBlrDoilCsmQty;
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
		this.arrFoilWgt = arrFoilWgt;
		this.nxtPortCd = nxtPortCd;
		this.pagerows = pagerows;
		this.proPitch = proPitch;
		this.nvgtMlDist = nvgtMlDist;
		this.depBlstWgt = depBlstWgt;
		this.updUsrId = updUsrId;
		this.seaGnrLowSulpFoilCsmQty = seaGnrLowSulpFoilCsmQty;
		this.depFoilWgt = depFoilWgt;
		this.splLowSulpFoilBdrWgt = splLowSulpFoilBdrWgt;
		this.splFoilActWgt = splFoilActWgt;
		this.avgRpmPwr = avgRpmPwr;
		this.skdVoyNo = skdVoyNo;
		this.pltOutDt = pltOutDt;
		this.depFwddrHgt = depFwddrHgt;
		this.depGmHgt = depGmHgt;
		this.portBlrDoilCsmQty = portBlrDoilCsmQty;
		this.depDplWgt = depDplWgt;
		this.seaTtlLowSulpDoilCsmQty = seaTtlLowSulpDoilCsmQty;
		this.splFoilSulpWgt = splFoilSulpWgt;
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
		this.rmnAvgSpd = rmnAvgSpd;
		this.depCgoWgt = depCgoWgt;
		this.mnvrInMlDist = mnvrInMlDist;
		this.arrBlstWgt = arrBlstWgt;
		this.depDoilWgt = depDoilWgt;
		this.splLowSulpDoilActWgt = splLowSulpDoilActWgt;
		this.arrLowSulpDoilWgt = arrLowSulpDoilWgt;
		this.splLowSulpFoilSulpWgt = splLowSulpFoilSulpWgt;
		this.splDoilActWgt = splDoilActWgt;
		this.rupDt = rupDt;
		this.vskFlg = vskFlg;
		this.sbEngDt = sbEngDt;
		this.cgoWrkEndDt = cgoWrkEndDt;
		this.portMnLowSulpFoilCsmQty = portMnLowSulpFoilCsmQty;
		this.arrAftdrHgt = arrAftdrHgt;
		this.depLowSulpDoilWgt = depLowSulpDoilWgt;
		this.depAftdrHgt = depAftdrHgt;
		this.portMnFoilCsmQty = portMnFoilCsmQty;
		this.seaGnrLowSulpDoilCsmQty = seaGnrLowSulpDoilCsmQty;
		this.seaTtlLowSulpFoilCsmQty = seaTtlLowSulpFoilCsmQty;
		this.clptIndSeq = clptIndSeq;
		this.rfCntrDchgKnt = rfCntrDchgKnt;
		this.rfCntrObrdKnt = rfCntrObrdKnt;
		this.splLowSulpDoilSulpWgt = splLowSulpDoilSulpWgt;
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
		this.seaBlrLowSulpDoilCsmQty = seaBlrLowSulpDoilCsmQty;
		this.vslCd = vslCd;
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
		this.seaTtlDoilCsmQty = seaTtlDoilCsmQty;
		this.splDoilBrgWgt1 = splDoilBrgWgt1;
		this.portTtlFoilCsmQty = portTtlFoilCsmQty;
		this.vskEtdDt = vskEtdDt;
		this.seaMnLowSulpFoilCsmQty = seaMnLowSulpFoilCsmQty;
		this.rfCntrLodKnt = rfCntrLodKnt;
		this.splDoilBrgWgt2 = splDoilBrgWgt2;
		this.cgoWrkStDt = cgoWrkStDt;
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
		this.seaGnrDoilCsmQty = seaGnrDoilCsmQty;
		this.arrFrshWtrWgt = arrFrshWtrWgt;
		this.mnvrOutMlDist = mnvrOutMlDist;
		this.mtyCntrObrdTeu = mtyCntrObrdTeu;
		this.splLowSulpDoilBdrWgt = splLowSulpDoilBdrWgt;
		this.portGnrLowSulpFoilCsmQty = portGnrLowSulpFoilCsmQty;
		this.arrMidDrftHgt = arrMidDrftHgt;
		this.arrFwddrHgt = arrFwddrHgt;
		this.vpsEtdDt = vpsEtdDt;
		this.portBlrFoilCsmQty = portBlrFoilCsmQty;
		this.harborInPortTtl = harborInPortTtl;
		this.portMnLowSulpDoilCsmQty = portMnLowSulpDoilCsmQty;
		this.rmnDist = rmnDist;
		this.seaGnrFoilCsmQty = seaGnrFoilCsmQty;
		this.engMlDist = engMlDist;
		this.cntrDznCapa = cntrDznCapa;
		this.portMnDoilCsmQty = portMnDoilCsmQty;
		this.splFoilBrgWgt2 = splFoilBrgWgt2;
		this.splFoilBrgWgt1 = splFoilBrgWgt1;
		this.skdVoyDir = skdVoyDir;
		this.depFlg = depFlg;
		this.nxtPortEtaDt = nxtPortEtaDt;
		this.vpsEtbDt = vpsEtbDt;
		this.seaSteamingTtl = seaSteamingTtl;
		this.seaSteamingMe = seaSteamingMe;
		this.portTtlLowSulpFoilCsmQty = portTtlLowSulpFoilCsmQty;
		this.portBlrLowSulpFoilCsmQty = portBlrLowSulpFoilCsmQty;
		this.portGnrDoilCsmQty = portGnrDoilCsmQty;
		this.arrLowSulpFoilWgt = arrLowSulpFoilWgt;
		this.depFrshWtrWgt = depFrshWtrWgt;
		this.splLowSulpDoilBrgWgt1 = splLowSulpDoilBrgWgt1;
		this.vslSlanCd = vslSlanCd;
		this.splLowSulpDoilBrgWgt2 = splLowSulpDoilBrgWgt2;
		this.splLowSulpFoilBrgWgt2 = splLowSulpFoilBrgWgt2;
		this.seaBlrFoilCsmQty = seaBlrFoilCsmQty;
		this.splLowSulpFoilBrgWgt1 = splLowSulpFoilBrgWgt1;
		this.lastPortCd = lastPortCd;
		this.ibflag = ibflag;
		this.arrDoilWgt = arrDoilWgt;
		this.splDoilSulpWgt = splDoilSulpWgt;
		this.seaTtlFoilCsmQty = seaTtlFoilCsmQty;
		this.avgExptFlg = avgExptFlg;
		this.sailingTime = sailingTime;
		this.portTtlLowSulpDoilCsmQty = portTtlLowSulpDoilCsmQty;
		this.seaMnFoilCsmQty = seaMnFoilCsmQty;
		this.splDoilBdrWgt = splDoilBdrWgt;
		this.ttlCntrObrdTeu = ttlCntrObrdTeu;
		this.depPortCd = depPortCd;
		this.fullCntrObrdTeu = fullCntrObrdTeu;
		this.arrGmHgt = arrGmHgt;
		this.portGnrFoilCsmQty = portGnrFoilCsmQty;
		this.seaMnDoilCsmQty = seaMnDoilCsmQty;
		this.portGnrLowSulpDoilCsmQty = portGnrLowSulpDoilCsmQty;
		this.skdDirCd = skdDirCd;
		this.portBlrLowSulpDoilCsmQty = portBlrLowSulpDoilCsmQty;
		this.splFoilBdrWgt = splFoilBdrWgt;
		this.seaBlrLowSulpFoilCsmQty = seaBlrLowSulpFoilCsmQty;
		this.seaMnLowSulpDoilCsmQty = seaMnLowSulpDoilCsmQty;
		this.depMidDrftHgt = depMidDrftHgt;
		this.portTtlDoilCsmQty = portTtlDoilCsmQty;
		this.avgSpd = avgSpd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spl_low_sulp_foil_act_wgt", getSplLowSulpFoilActWgt());
		this.hashColumns.put("plt_in_dt", getPltInDt());
		this.hashColumns.put("sea_blr_doil_csm_qty", getSeaBlrDoilCsmQty());
		this.hashColumns.put("bfr_brth_ank_drp_dt", getBfrBrthAnkDrpDt());
		this.hashColumns.put("arr_foil_wgt", getArrFoilWgt());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pro_pitch", getProPitch());
		this.hashColumns.put("nvgt_ml_dist", getNvgtMlDist());
		this.hashColumns.put("dep_blst_wgt", getDepBlstWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sea_gnr_low_sulp_foil_csm_qty", getSeaGnrLowSulpFoilCsmQty());
		this.hashColumns.put("dep_foil_wgt", getDepFoilWgt());
		this.hashColumns.put("spl_low_sulp_foil_bdr_wgt", getSplLowSulpFoilBdrWgt());
		this.hashColumns.put("spl_foil_act_wgt", getSplFoilActWgt());
		this.hashColumns.put("avg_rpm_pwr", getAvgRpmPwr());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("plt_out_dt", getPltOutDt());
		this.hashColumns.put("dep_fwddr_hgt", getDepFwddrHgt());
		this.hashColumns.put("dep_gm_hgt", getDepGmHgt());
		this.hashColumns.put("port_blr_doil_csm_qty", getPortBlrDoilCsmQty());
		this.hashColumns.put("dep_dpl_wgt", getDepDplWgt());
		this.hashColumns.put("sea_ttl_low_sulp_doil_csm_qty", getSeaTtlLowSulpDoilCsmQty());
		this.hashColumns.put("spl_foil_sulp_wgt", getSplFoilSulpWgt());
		this.hashColumns.put("bfr_brth_ank_off_dt", getBfrBrthAnkOffDt());
		this.hashColumns.put("rmn_avg_spd", getRmnAvgSpd());
		this.hashColumns.put("dep_cgo_wgt", getDepCgoWgt());
		this.hashColumns.put("mnvr_in_ml_dist", getMnvrInMlDist());
		this.hashColumns.put("arr_blst_wgt", getArrBlstWgt());
		this.hashColumns.put("dep_doil_wgt", getDepDoilWgt());
		this.hashColumns.put("spl_low_sulp_doil_act_wgt", getSplLowSulpDoilActWgt());
		this.hashColumns.put("arr_low_sulp_doil_wgt", getArrLowSulpDoilWgt());
		this.hashColumns.put("spl_low_sulp_foil_sulp_wgt", getSplLowSulpFoilSulpWgt());
		this.hashColumns.put("spl_doil_act_wgt", getSplDoilActWgt());
		this.hashColumns.put("rup_dt", getRupDt());
		this.hashColumns.put("vsk_flg", getVskFlg());
		this.hashColumns.put("sb_eng_dt", getSbEngDt());
		this.hashColumns.put("cgo_wrk_end_dt", getCgoWrkEndDt());
		this.hashColumns.put("port_mn_low_sulp_foil_csm_qty", getPortMnLowSulpFoilCsmQty());
		this.hashColumns.put("arr_aftdr_hgt", getArrAftdrHgt());
		this.hashColumns.put("dep_low_sulp_doil_wgt", getDepLowSulpDoilWgt());
		this.hashColumns.put("dep_aftdr_hgt", getDepAftdrHgt());
		this.hashColumns.put("port_mn_foil_csm_qty", getPortMnFoilCsmQty());
		this.hashColumns.put("sea_gnr_low_sulp_doil_csm_qty", getSeaGnrLowSulpDoilCsmQty());
		this.hashColumns.put("sea_ttl_low_sulp_foil_csm_qty", getSeaTtlLowSulpFoilCsmQty());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("rf_cntr_dchg_knt", getRfCntrDchgKnt());
		this.hashColumns.put("rf_cntr_obrd_knt", getRfCntrObrdKnt());
		this.hashColumns.put("spl_low_sulp_doil_sulp_wgt", getSplLowSulpDoilSulpWgt());
		this.hashColumns.put("dep_low_sulp_foil_wgt", getDepLowSulpFoilWgt());
		this.hashColumns.put("sea_blr_low_sulp_doil_csm_qty", getSeaBlrLowSulpDoilCsmQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("aft_unbrth_ank_off_dt", getAftUnbrthAnkOffDt());
		this.hashColumns.put("sea_ttl_doil_csm_qty", getSeaTtlDoilCsmQty());
		this.hashColumns.put("spl_doil_brg_wgt1", getSplDoilBrgWgt1());
		this.hashColumns.put("port_ttl_foil_csm_qty", getPortTtlFoilCsmQty());
		this.hashColumns.put("vsk_etd_dt", getVskEtdDt());
		this.hashColumns.put("sea_mn_low_sulp_foil_csm_qty", getSeaMnLowSulpFoilCsmQty());
		this.hashColumns.put("rf_cntr_lod_knt", getRfCntrLodKnt());
		this.hashColumns.put("spl_doil_brg_wgt2", getSplDoilBrgWgt2());
		this.hashColumns.put("cgo_wrk_st_dt", getCgoWrkStDt());
		this.hashColumns.put("aft_unbrth_ank_drp_dt", getAftUnbrthAnkDrpDt());
		this.hashColumns.put("sea_gnr_doil_csm_qty", getSeaGnrDoilCsmQty());
		this.hashColumns.put("arr_frsh_wtr_wgt", getArrFrshWtrWgt());
		this.hashColumns.put("mnvr_out_ml_dist", getMnvrOutMlDist());
		this.hashColumns.put("mty_cntr_obrd_teu", getMtyCntrObrdTeu());
		this.hashColumns.put("spl_low_sulp_doil_bdr_wgt", getSplLowSulpDoilBdrWgt());
		this.hashColumns.put("port_gnr_low_sulp_foil_csm_qty", getPortGnrLowSulpFoilCsmQty());
		this.hashColumns.put("arr_mid_drft_hgt", getArrMidDrftHgt());
		this.hashColumns.put("arr_fwddr_hgt", getArrFwddrHgt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("port_blr_foil_csm_qty", getPortBlrFoilCsmQty());
		this.hashColumns.put("harbor_in_port_ttl", getHarborInPortTtl());
		this.hashColumns.put("port_mn_low_sulp_doil_csm_qty", getPortMnLowSulpDoilCsmQty());
		this.hashColumns.put("rmn_dist", getRmnDist());
		this.hashColumns.put("sea_gnr_foil_csm_qty", getSeaGnrFoilCsmQty());
		this.hashColumns.put("eng_ml_dist", getEngMlDist());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("port_mn_doil_csm_qty", getPortMnDoilCsmQty());
		this.hashColumns.put("spl_foil_brg_wgt2", getSplFoilBrgWgt2());
		this.hashColumns.put("spl_foil_brg_wgt1", getSplFoilBrgWgt1());
		this.hashColumns.put("skd_voy_dir", getSkdVoyDir());
		this.hashColumns.put("dep_flg", getDepFlg());
		this.hashColumns.put("nxt_port_eta_dt", getNxtPortEtaDt());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("sea_steaming_ttl", getSeaSteamingTtl());
		this.hashColumns.put("sea_steaming_me", getSeaSteamingMe());
		this.hashColumns.put("port_ttl_low_sulp_foil_csm_qty", getPortTtlLowSulpFoilCsmQty());
		this.hashColumns.put("port_blr_low_sulp_foil_csm_qty", getPortBlrLowSulpFoilCsmQty());
		this.hashColumns.put("port_gnr_doil_csm_qty", getPortGnrDoilCsmQty());
		this.hashColumns.put("arr_low_sulp_foil_wgt", getArrLowSulpFoilWgt());
		this.hashColumns.put("dep_frsh_wtr_wgt", getDepFrshWtrWgt());
		this.hashColumns.put("spl_low_sulp_doil_brg_wgt1", getSplLowSulpDoilBrgWgt1());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("spl_low_sulp_doil_brg_wgt2", getSplLowSulpDoilBrgWgt2());
		this.hashColumns.put("spl_low_sulp_foil_brg_wgt2", getSplLowSulpFoilBrgWgt2());
		this.hashColumns.put("sea_blr_foil_csm_qty", getSeaBlrFoilCsmQty());
		this.hashColumns.put("spl_low_sulp_foil_brg_wgt1", getSplLowSulpFoilBrgWgt1());
		this.hashColumns.put("last_port_cd", getLastPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arr_doil_wgt", getArrDoilWgt());
		this.hashColumns.put("spl_doil_sulp_wgt", getSplDoilSulpWgt());
		this.hashColumns.put("sea_ttl_foil_csm_qty", getSeaTtlFoilCsmQty());
		this.hashColumns.put("avg_expt_flg", getAvgExptFlg());
		this.hashColumns.put("sailing_time", getSailingTime());
		this.hashColumns.put("port_ttl_low_sulp_doil_csm_qty", getPortTtlLowSulpDoilCsmQty());
		this.hashColumns.put("sea_mn_foil_csm_qty", getSeaMnFoilCsmQty());
		this.hashColumns.put("spl_doil_bdr_wgt", getSplDoilBdrWgt());
		this.hashColumns.put("ttl_cntr_obrd_teu", getTtlCntrObrdTeu());
		this.hashColumns.put("dep_port_cd", getDepPortCd());
		this.hashColumns.put("full_cntr_obrd_teu", getFullCntrObrdTeu());
		this.hashColumns.put("arr_gm_hgt", getArrGmHgt());
		this.hashColumns.put("port_gnr_foil_csm_qty", getPortGnrFoilCsmQty());
		this.hashColumns.put("sea_mn_doil_csm_qty", getSeaMnDoilCsmQty());
		this.hashColumns.put("port_gnr_low_sulp_doil_csm_qty", getPortGnrLowSulpDoilCsmQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("port_blr_low_sulp_doil_csm_qty", getPortBlrLowSulpDoilCsmQty());
		this.hashColumns.put("spl_foil_bdr_wgt", getSplFoilBdrWgt());
		this.hashColumns.put("sea_blr_low_sulp_foil_csm_qty", getSeaBlrLowSulpFoilCsmQty());
		this.hashColumns.put("sea_mn_low_sulp_doil_csm_qty", getSeaMnLowSulpDoilCsmQty());
		this.hashColumns.put("dep_mid_drft_hgt", getDepMidDrftHgt());
		this.hashColumns.put("port_ttl_doil_csm_qty", getPortTtlDoilCsmQty());
		this.hashColumns.put("avg_spd", getAvgSpd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spl_low_sulp_foil_act_wgt", "splLowSulpFoilActWgt");
		this.hashFields.put("plt_in_dt", "pltInDt");
		this.hashFields.put("sea_blr_doil_csm_qty", "seaBlrDoilCsmQty");
		this.hashFields.put("bfr_brth_ank_drp_dt", "bfrBrthAnkDrpDt");
		this.hashFields.put("arr_foil_wgt", "arrFoilWgt");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pro_pitch", "proPitch");
		this.hashFields.put("nvgt_ml_dist", "nvgtMlDist");
		this.hashFields.put("dep_blst_wgt", "depBlstWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sea_gnr_low_sulp_foil_csm_qty", "seaGnrLowSulpFoilCsmQty");
		this.hashFields.put("dep_foil_wgt", "depFoilWgt");
		this.hashFields.put("spl_low_sulp_foil_bdr_wgt", "splLowSulpFoilBdrWgt");
		this.hashFields.put("spl_foil_act_wgt", "splFoilActWgt");
		this.hashFields.put("avg_rpm_pwr", "avgRpmPwr");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("plt_out_dt", "pltOutDt");
		this.hashFields.put("dep_fwddr_hgt", "depFwddrHgt");
		this.hashFields.put("dep_gm_hgt", "depGmHgt");
		this.hashFields.put("port_blr_doil_csm_qty", "portBlrDoilCsmQty");
		this.hashFields.put("dep_dpl_wgt", "depDplWgt");
		this.hashFields.put("sea_ttl_low_sulp_doil_csm_qty", "seaTtlLowSulpDoilCsmQty");
		this.hashFields.put("spl_foil_sulp_wgt", "splFoilSulpWgt");
		this.hashFields.put("bfr_brth_ank_off_dt", "bfrBrthAnkOffDt");
		this.hashFields.put("rmn_avg_spd", "rmnAvgSpd");
		this.hashFields.put("dep_cgo_wgt", "depCgoWgt");
		this.hashFields.put("mnvr_in_ml_dist", "mnvrInMlDist");
		this.hashFields.put("arr_blst_wgt", "arrBlstWgt");
		this.hashFields.put("dep_doil_wgt", "depDoilWgt");
		this.hashFields.put("spl_low_sulp_doil_act_wgt", "splLowSulpDoilActWgt");
		this.hashFields.put("arr_low_sulp_doil_wgt", "arrLowSulpDoilWgt");
		this.hashFields.put("spl_low_sulp_foil_sulp_wgt", "splLowSulpFoilSulpWgt");
		this.hashFields.put("spl_doil_act_wgt", "splDoilActWgt");
		this.hashFields.put("rup_dt", "rupDt");
		this.hashFields.put("vsk_flg", "vskFlg");
		this.hashFields.put("sb_eng_dt", "sbEngDt");
		this.hashFields.put("cgo_wrk_end_dt", "cgoWrkEndDt");
		this.hashFields.put("port_mn_low_sulp_foil_csm_qty", "portMnLowSulpFoilCsmQty");
		this.hashFields.put("arr_aftdr_hgt", "arrAftdrHgt");
		this.hashFields.put("dep_low_sulp_doil_wgt", "depLowSulpDoilWgt");
		this.hashFields.put("dep_aftdr_hgt", "depAftdrHgt");
		this.hashFields.put("port_mn_foil_csm_qty", "portMnFoilCsmQty");
		this.hashFields.put("sea_gnr_low_sulp_doil_csm_qty", "seaGnrLowSulpDoilCsmQty");
		this.hashFields.put("sea_ttl_low_sulp_foil_csm_qty", "seaTtlLowSulpFoilCsmQty");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("rf_cntr_dchg_knt", "rfCntrDchgKnt");
		this.hashFields.put("rf_cntr_obrd_knt", "rfCntrObrdKnt");
		this.hashFields.put("spl_low_sulp_doil_sulp_wgt", "splLowSulpDoilSulpWgt");
		this.hashFields.put("dep_low_sulp_foil_wgt", "depLowSulpFoilWgt");
		this.hashFields.put("sea_blr_low_sulp_doil_csm_qty", "seaBlrLowSulpDoilCsmQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("aft_unbrth_ank_off_dt", "aftUnbrthAnkOffDt");
		this.hashFields.put("sea_ttl_doil_csm_qty", "seaTtlDoilCsmQty");
		this.hashFields.put("spl_doil_brg_wgt1", "splDoilBrgWgt1");
		this.hashFields.put("port_ttl_foil_csm_qty", "portTtlFoilCsmQty");
		this.hashFields.put("vsk_etd_dt", "vskEtdDt");
		this.hashFields.put("sea_mn_low_sulp_foil_csm_qty", "seaMnLowSulpFoilCsmQty");
		this.hashFields.put("rf_cntr_lod_knt", "rfCntrLodKnt");
		this.hashFields.put("spl_doil_brg_wgt2", "splDoilBrgWgt2");
		this.hashFields.put("cgo_wrk_st_dt", "cgoWrkStDt");
		this.hashFields.put("aft_unbrth_ank_drp_dt", "aftUnbrthAnkDrpDt");
		this.hashFields.put("sea_gnr_doil_csm_qty", "seaGnrDoilCsmQty");
		this.hashFields.put("arr_frsh_wtr_wgt", "arrFrshWtrWgt");
		this.hashFields.put("mnvr_out_ml_dist", "mnvrOutMlDist");
		this.hashFields.put("mty_cntr_obrd_teu", "mtyCntrObrdTeu");
		this.hashFields.put("spl_low_sulp_doil_bdr_wgt", "splLowSulpDoilBdrWgt");
		this.hashFields.put("port_gnr_low_sulp_foil_csm_qty", "portGnrLowSulpFoilCsmQty");
		this.hashFields.put("arr_mid_drft_hgt", "arrMidDrftHgt");
		this.hashFields.put("arr_fwddr_hgt", "arrFwddrHgt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("port_blr_foil_csm_qty", "portBlrFoilCsmQty");
		this.hashFields.put("harbor_in_port_ttl", "harborInPortTtl");
		this.hashFields.put("port_mn_low_sulp_doil_csm_qty", "portMnLowSulpDoilCsmQty");
		this.hashFields.put("rmn_dist", "rmnDist");
		this.hashFields.put("sea_gnr_foil_csm_qty", "seaGnrFoilCsmQty");
		this.hashFields.put("eng_ml_dist", "engMlDist");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("port_mn_doil_csm_qty", "portMnDoilCsmQty");
		this.hashFields.put("spl_foil_brg_wgt2", "splFoilBrgWgt2");
		this.hashFields.put("spl_foil_brg_wgt1", "splFoilBrgWgt1");
		this.hashFields.put("skd_voy_dir", "skdVoyDir");
		this.hashFields.put("dep_flg", "depFlg");
		this.hashFields.put("nxt_port_eta_dt", "nxtPortEtaDt");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("sea_steaming_ttl", "seaSteamingTtl");
		this.hashFields.put("sea_steaming_me", "seaSteamingMe");
		this.hashFields.put("port_ttl_low_sulp_foil_csm_qty", "portTtlLowSulpFoilCsmQty");
		this.hashFields.put("port_blr_low_sulp_foil_csm_qty", "portBlrLowSulpFoilCsmQty");
		this.hashFields.put("port_gnr_doil_csm_qty", "portGnrDoilCsmQty");
		this.hashFields.put("arr_low_sulp_foil_wgt", "arrLowSulpFoilWgt");
		this.hashFields.put("dep_frsh_wtr_wgt", "depFrshWtrWgt");
		this.hashFields.put("spl_low_sulp_doil_brg_wgt1", "splLowSulpDoilBrgWgt1");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("spl_low_sulp_doil_brg_wgt2", "splLowSulpDoilBrgWgt2");
		this.hashFields.put("spl_low_sulp_foil_brg_wgt2", "splLowSulpFoilBrgWgt2");
		this.hashFields.put("sea_blr_foil_csm_qty", "seaBlrFoilCsmQty");
		this.hashFields.put("spl_low_sulp_foil_brg_wgt1", "splLowSulpFoilBrgWgt1");
		this.hashFields.put("last_port_cd", "lastPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arr_doil_wgt", "arrDoilWgt");
		this.hashFields.put("spl_doil_sulp_wgt", "splDoilSulpWgt");
		this.hashFields.put("sea_ttl_foil_csm_qty", "seaTtlFoilCsmQty");
		this.hashFields.put("avg_expt_flg", "avgExptFlg");
		this.hashFields.put("sailing_time", "sailingTime");
		this.hashFields.put("port_ttl_low_sulp_doil_csm_qty", "portTtlLowSulpDoilCsmQty");
		this.hashFields.put("sea_mn_foil_csm_qty", "seaMnFoilCsmQty");
		this.hashFields.put("spl_doil_bdr_wgt", "splDoilBdrWgt");
		this.hashFields.put("ttl_cntr_obrd_teu", "ttlCntrObrdTeu");
		this.hashFields.put("dep_port_cd", "depPortCd");
		this.hashFields.put("full_cntr_obrd_teu", "fullCntrObrdTeu");
		this.hashFields.put("arr_gm_hgt", "arrGmHgt");
		this.hashFields.put("port_gnr_foil_csm_qty", "portGnrFoilCsmQty");
		this.hashFields.put("sea_mn_doil_csm_qty", "seaMnDoilCsmQty");
		this.hashFields.put("port_gnr_low_sulp_doil_csm_qty", "portGnrLowSulpDoilCsmQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("port_blr_low_sulp_doil_csm_qty", "portBlrLowSulpDoilCsmQty");
		this.hashFields.put("spl_foil_bdr_wgt", "splFoilBdrWgt");
		this.hashFields.put("sea_blr_low_sulp_foil_csm_qty", "seaBlrLowSulpFoilCsmQty");
		this.hashFields.put("sea_mn_low_sulp_doil_csm_qty", "seaMnLowSulpDoilCsmQty");
		this.hashFields.put("dep_mid_drft_hgt", "depMidDrftHgt");
		this.hashFields.put("port_ttl_doil_csm_qty", "portTtlDoilCsmQty");
		this.hashFields.put("avg_spd", "avgSpd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilActWgt
	 */
	public String getSplLowSulpFoilActWgt() {
		return this.splLowSulpFoilActWgt;
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
	 * @return seaBlrDoilCsmQty
	 */
	public String getSeaBlrDoilCsmQty() {
		return this.seaBlrDoilCsmQty;
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
	 * @return arrFoilWgt
	 */
	public String getArrFoilWgt() {
		return this.arrFoilWgt;
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
	 * @return proPitch
	 */
	public String getProPitch() {
		return this.proPitch;
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
	 * @return depBlstWgt
	 */
	public String getDepBlstWgt() {
		return this.depBlstWgt;
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
	 * @return seaGnrLowSulpFoilCsmQty
	 */
	public String getSeaGnrLowSulpFoilCsmQty() {
		return this.seaGnrLowSulpFoilCsmQty;
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
	 * @return splLowSulpFoilBdrWgt
	 */
	public String getSplLowSulpFoilBdrWgt() {
		return this.splLowSulpFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return splFoilActWgt
	 */
	public String getSplFoilActWgt() {
		return this.splFoilActWgt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return depFwddrHgt
	 */
	public String getDepFwddrHgt() {
		return this.depFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @return depGmHgt
	 */
	public String getDepGmHgt() {
		return this.depGmHgt;
	}
	
	/**
	 * Column Info
	 * @return portBlrDoilCsmQty
	 */
	public String getPortBlrDoilCsmQty() {
		return this.portBlrDoilCsmQty;
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
	 * @return seaTtlLowSulpDoilCsmQty
	 */
	public String getSeaTtlLowSulpDoilCsmQty() {
		return this.seaTtlLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splFoilSulpWgt
	 */
	public String getSplFoilSulpWgt() {
		return this.splFoilSulpWgt;
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
	 * @return rmnAvgSpd
	 */
	public String getRmnAvgSpd() {
		return this.rmnAvgSpd;
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
	 * @return mnvrInMlDist
	 */
	public String getMnvrInMlDist() {
		return this.mnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @return arrBlstWgt
	 */
	public String getArrBlstWgt() {
		return this.arrBlstWgt;
	}
	
	/**
	 * Column Info
	 * @return depDoilWgt
	 */
	public String getDepDoilWgt() {
		return this.depDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilActWgt
	 */
	public String getSplLowSulpDoilActWgt() {
		return this.splLowSulpDoilActWgt;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpDoilWgt
	 */
	public String getArrLowSulpDoilWgt() {
		return this.arrLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilSulpWgt
	 */
	public String getSplLowSulpFoilSulpWgt() {
		return this.splLowSulpFoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @return splDoilActWgt
	 */
	public String getSplDoilActWgt() {
		return this.splDoilActWgt;
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
	 * @return vskFlg
	 */
	public String getVskFlg() {
		return this.vskFlg;
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
	 * @return portMnLowSulpFoilCsmQty
	 */
	public String getPortMnLowSulpFoilCsmQty() {
		return this.portMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrAftdrHgt
	 */
	public String getArrAftdrHgt() {
		return this.arrAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @return depLowSulpDoilWgt
	 */
	public String getDepLowSulpDoilWgt() {
		return this.depLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return depAftdrHgt
	 */
	public String getDepAftdrHgt() {
		return this.depAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @return portMnFoilCsmQty
	 */
	public String getPortMnFoilCsmQty() {
		return this.portMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaGnrLowSulpDoilCsmQty
	 */
	public String getSeaGnrLowSulpDoilCsmQty() {
		return this.seaGnrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaTtlLowSulpFoilCsmQty
	 */
	public String getSeaTtlLowSulpFoilCsmQty() {
		return this.seaTtlLowSulpFoilCsmQty;
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
	 * @return rfCntrDchgKnt
	 */
	public String getRfCntrDchgKnt() {
		return this.rfCntrDchgKnt;
	}
	
	/**
	 * Column Info
	 * @return rfCntrObrdKnt
	 */
	public String getRfCntrObrdKnt() {
		return this.rfCntrObrdKnt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilSulpWgt
	 */
	public String getSplLowSulpDoilSulpWgt() {
		return this.splLowSulpDoilSulpWgt;
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
	 * @return seaBlrLowSulpDoilCsmQty
	 */
	public String getSeaBlrLowSulpDoilCsmQty() {
		return this.seaBlrLowSulpDoilCsmQty;
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
	 * @return aftUnbrthAnkOffDt
	 */
	public String getAftUnbrthAnkOffDt() {
		return this.aftUnbrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @return seaTtlDoilCsmQty
	 */
	public String getSeaTtlDoilCsmQty() {
		return this.seaTtlDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splDoilBrgWgt1
	 */
	public String getSplDoilBrgWgt1() {
		return this.splDoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return portTtlFoilCsmQty
	 */
	public String getPortTtlFoilCsmQty() {
		return this.portTtlFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return vskEtdDt
	 */
	public String getVskEtdDt() {
		return this.vskEtdDt;
	}
	
	/**
	 * Column Info
	 * @return seaMnLowSulpFoilCsmQty
	 */
	public String getSeaMnLowSulpFoilCsmQty() {
		return this.seaMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return rfCntrLodKnt
	 */
	public String getRfCntrLodKnt() {
		return this.rfCntrLodKnt;
	}
	
	/**
	 * Column Info
	 * @return splDoilBrgWgt2
	 */
	public String getSplDoilBrgWgt2() {
		return this.splDoilBrgWgt2;
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
	 * @return aftUnbrthAnkDrpDt
	 */
	public String getAftUnbrthAnkDrpDt() {
		return this.aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return seaGnrDoilCsmQty
	 */
	public String getSeaGnrDoilCsmQty() {
		return this.seaGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrFrshWtrWgt
	 */
	public String getArrFrshWtrWgt() {
		return this.arrFrshWtrWgt;
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
	 * @return mtyCntrObrdTeu
	 */
	public String getMtyCntrObrdTeu() {
		return this.mtyCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilBdrWgt
	 */
	public String getSplLowSulpDoilBdrWgt() {
		return this.splLowSulpDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return portGnrLowSulpFoilCsmQty
	 */
	public String getPortGnrLowSulpFoilCsmQty() {
		return this.portGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrMidDrftHgt
	 */
	public String getArrMidDrftHgt() {
		return this.arrMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return arrFwddrHgt
	 */
	public String getArrFwddrHgt() {
		return this.arrFwddrHgt;
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
	 * @return portBlrFoilCsmQty
	 */
	public String getPortBlrFoilCsmQty() {
		return this.portBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return harborInPortTtl
	 */
	public String getHarborInPortTtl() {
		return this.harborInPortTtl;
	}
	
	/**
	 * Column Info
	 * @return portMnLowSulpDoilCsmQty
	 */
	public String getPortMnLowSulpDoilCsmQty() {
		return this.portMnLowSulpDoilCsmQty;
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
	 * @return seaGnrFoilCsmQty
	 */
	public String getSeaGnrFoilCsmQty() {
		return this.seaGnrFoilCsmQty;
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
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @return portMnDoilCsmQty
	 */
	public String getPortMnDoilCsmQty() {
		return this.portMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splFoilBrgWgt2
	 */
	public String getSplFoilBrgWgt2() {
		return this.splFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @return splFoilBrgWgt1
	 */
	public String getSplFoilBrgWgt1() {
		return this.splFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return skdVoyDir
	 */
	public String getSkdVoyDir() {
		return this.skdVoyDir;
	}
	
	/**
	 * Column Info
	 * @return depFlg
	 */
	public String getDepFlg() {
		return this.depFlg;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return seaSteamingTtl
	 */
	public String getSeaSteamingTtl() {
		return this.seaSteamingTtl;
	}
	
	/**
	 * Column Info
	 * @return seaSteamingMe
	 */
	public String getSeaSteamingMe() {
		return this.seaSteamingMe;
	}
	
	/**
	 * Column Info
	 * @return portTtlLowSulpFoilCsmQty
	 */
	public String getPortTtlLowSulpFoilCsmQty() {
		return this.portTtlLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portBlrLowSulpFoilCsmQty
	 */
	public String getPortBlrLowSulpFoilCsmQty() {
		return this.portBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portGnrDoilCsmQty
	 */
	public String getPortGnrDoilCsmQty() {
		return this.portGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return arrLowSulpFoilWgt
	 */
	public String getArrLowSulpFoilWgt() {
		return this.arrLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return depFrshWtrWgt
	 */
	public String getDepFrshWtrWgt() {
		return this.depFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilBrgWgt1
	 */
	public String getSplLowSulpDoilBrgWgt1() {
		return this.splLowSulpDoilBrgWgt1;
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
	 * @return splLowSulpDoilBrgWgt2
	 */
	public String getSplLowSulpDoilBrgWgt2() {
		return this.splLowSulpDoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilBrgWgt2
	 */
	public String getSplLowSulpFoilBrgWgt2() {
		return this.splLowSulpFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @return seaBlrFoilCsmQty
	 */
	public String getSeaBlrFoilCsmQty() {
		return this.seaBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilBrgWgt1
	 */
	public String getSplLowSulpFoilBrgWgt1() {
		return this.splLowSulpFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @return lastPortCd
	 */
	public String getLastPortCd() {
		return this.lastPortCd;
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
	 * @return arrDoilWgt
	 */
	public String getArrDoilWgt() {
		return this.arrDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return splDoilSulpWgt
	 */
	public String getSplDoilSulpWgt() {
		return this.splDoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @return seaTtlFoilCsmQty
	 */
	public String getSeaTtlFoilCsmQty() {
		return this.seaTtlFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return avgExptFlg
	 */
	public String getAvgExptFlg() {
		return this.avgExptFlg;
	}
	
	/**
	 * Column Info
	 * @return sailingTime
	 */
	public String getSailingTime() {
		return this.sailingTime;
	}
	
	/**
	 * Column Info
	 * @return portTtlLowSulpDoilCsmQty
	 */
	public String getPortTtlLowSulpDoilCsmQty() {
		return this.portTtlLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaMnFoilCsmQty
	 */
	public String getSeaMnFoilCsmQty() {
		return this.seaMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splDoilBdrWgt
	 */
	public String getSplDoilBdrWgt() {
		return this.splDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return ttlCntrObrdTeu
	 */
	public String getTtlCntrObrdTeu() {
		return this.ttlCntrObrdTeu;
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
	 * @return fullCntrObrdTeu
	 */
	public String getFullCntrObrdTeu() {
		return this.fullCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @return arrGmHgt
	 */
	public String getArrGmHgt() {
		return this.arrGmHgt;
	}
	
	/**
	 * Column Info
	 * @return portGnrFoilCsmQty
	 */
	public String getPortGnrFoilCsmQty() {
		return this.portGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaMnDoilCsmQty
	 */
	public String getSeaMnDoilCsmQty() {
		return this.seaMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return portGnrLowSulpDoilCsmQty
	 */
	public String getPortGnrLowSulpDoilCsmQty() {
		return this.portGnrLowSulpDoilCsmQty;
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
	 * @return portBlrLowSulpDoilCsmQty
	 */
	public String getPortBlrLowSulpDoilCsmQty() {
		return this.portBlrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return splFoilBdrWgt
	 */
	public String getSplFoilBdrWgt() {
		return this.splFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @return seaBlrLowSulpFoilCsmQty
	 */
	public String getSeaBlrLowSulpFoilCsmQty() {
		return this.seaBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return seaMnLowSulpDoilCsmQty
	 */
	public String getSeaMnLowSulpDoilCsmQty() {
		return this.seaMnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return depMidDrftHgt
	 */
	public String getDepMidDrftHgt() {
		return this.depMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return portTtlDoilCsmQty
	 */
	public String getPortTtlDoilCsmQty() {
		return this.portTtlDoilCsmQty;
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
	 * @param splLowSulpFoilActWgt
	 */
	public void setSplLowSulpFoilActWgt(String splLowSulpFoilActWgt) {
		this.splLowSulpFoilActWgt = splLowSulpFoilActWgt;
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
	 * @param seaBlrDoilCsmQty
	 */
	public void setSeaBlrDoilCsmQty(String seaBlrDoilCsmQty) {
		this.seaBlrDoilCsmQty = seaBlrDoilCsmQty;
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
	 * @param arrFoilWgt
	 */
	public void setArrFoilWgt(String arrFoilWgt) {
		this.arrFoilWgt = arrFoilWgt;
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
	 * @param proPitch
	 */
	public void setProPitch(String proPitch) {
		this.proPitch = proPitch;
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
	 * @param depBlstWgt
	 */
	public void setDepBlstWgt(String depBlstWgt) {
		this.depBlstWgt = depBlstWgt;
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
	 * @param seaGnrLowSulpFoilCsmQty
	 */
	public void setSeaGnrLowSulpFoilCsmQty(String seaGnrLowSulpFoilCsmQty) {
		this.seaGnrLowSulpFoilCsmQty = seaGnrLowSulpFoilCsmQty;
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
	 * @param splLowSulpFoilBdrWgt
	 */
	public void setSplLowSulpFoilBdrWgt(String splLowSulpFoilBdrWgt) {
		this.splLowSulpFoilBdrWgt = splLowSulpFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param splFoilActWgt
	 */
	public void setSplFoilActWgt(String splFoilActWgt) {
		this.splFoilActWgt = splFoilActWgt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param depFwddrHgt
	 */
	public void setDepFwddrHgt(String depFwddrHgt) {
		this.depFwddrHgt = depFwddrHgt;
	}
	
	/**
	 * Column Info
	 * @param depGmHgt
	 */
	public void setDepGmHgt(String depGmHgt) {
		this.depGmHgt = depGmHgt;
	}
	
	/**
	 * Column Info
	 * @param portBlrDoilCsmQty
	 */
	public void setPortBlrDoilCsmQty(String portBlrDoilCsmQty) {
		this.portBlrDoilCsmQty = portBlrDoilCsmQty;
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
	 * @param seaTtlLowSulpDoilCsmQty
	 */
	public void setSeaTtlLowSulpDoilCsmQty(String seaTtlLowSulpDoilCsmQty) {
		this.seaTtlLowSulpDoilCsmQty = seaTtlLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splFoilSulpWgt
	 */
	public void setSplFoilSulpWgt(String splFoilSulpWgt) {
		this.splFoilSulpWgt = splFoilSulpWgt;
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
	 * @param rmnAvgSpd
	 */
	public void setRmnAvgSpd(String rmnAvgSpd) {
		this.rmnAvgSpd = rmnAvgSpd;
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
	 * @param mnvrInMlDist
	 */
	public void setMnvrInMlDist(String mnvrInMlDist) {
		this.mnvrInMlDist = mnvrInMlDist;
	}
	
	/**
	 * Column Info
	 * @param arrBlstWgt
	 */
	public void setArrBlstWgt(String arrBlstWgt) {
		this.arrBlstWgt = arrBlstWgt;
	}
	
	/**
	 * Column Info
	 * @param depDoilWgt
	 */
	public void setDepDoilWgt(String depDoilWgt) {
		this.depDoilWgt = depDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilActWgt
	 */
	public void setSplLowSulpDoilActWgt(String splLowSulpDoilActWgt) {
		this.splLowSulpDoilActWgt = splLowSulpDoilActWgt;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpDoilWgt
	 */
	public void setArrLowSulpDoilWgt(String arrLowSulpDoilWgt) {
		this.arrLowSulpDoilWgt = arrLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilSulpWgt
	 */
	public void setSplLowSulpFoilSulpWgt(String splLowSulpFoilSulpWgt) {
		this.splLowSulpFoilSulpWgt = splLowSulpFoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @param splDoilActWgt
	 */
	public void setSplDoilActWgt(String splDoilActWgt) {
		this.splDoilActWgt = splDoilActWgt;
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
	 * @param vskFlg
	 */
	public void setVskFlg(String vskFlg) {
		this.vskFlg = vskFlg;
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
	 * @param portMnLowSulpFoilCsmQty
	 */
	public void setPortMnLowSulpFoilCsmQty(String portMnLowSulpFoilCsmQty) {
		this.portMnLowSulpFoilCsmQty = portMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrAftdrHgt
	 */
	public void setArrAftdrHgt(String arrAftdrHgt) {
		this.arrAftdrHgt = arrAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @param depLowSulpDoilWgt
	 */
	public void setDepLowSulpDoilWgt(String depLowSulpDoilWgt) {
		this.depLowSulpDoilWgt = depLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param depAftdrHgt
	 */
	public void setDepAftdrHgt(String depAftdrHgt) {
		this.depAftdrHgt = depAftdrHgt;
	}
	
	/**
	 * Column Info
	 * @param portMnFoilCsmQty
	 */
	public void setPortMnFoilCsmQty(String portMnFoilCsmQty) {
		this.portMnFoilCsmQty = portMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaGnrLowSulpDoilCsmQty
	 */
	public void setSeaGnrLowSulpDoilCsmQty(String seaGnrLowSulpDoilCsmQty) {
		this.seaGnrLowSulpDoilCsmQty = seaGnrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaTtlLowSulpFoilCsmQty
	 */
	public void setSeaTtlLowSulpFoilCsmQty(String seaTtlLowSulpFoilCsmQty) {
		this.seaTtlLowSulpFoilCsmQty = seaTtlLowSulpFoilCsmQty;
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
	 * @param rfCntrDchgKnt
	 */
	public void setRfCntrDchgKnt(String rfCntrDchgKnt) {
		this.rfCntrDchgKnt = rfCntrDchgKnt;
	}
	
	/**
	 * Column Info
	 * @param rfCntrObrdKnt
	 */
	public void setRfCntrObrdKnt(String rfCntrObrdKnt) {
		this.rfCntrObrdKnt = rfCntrObrdKnt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilSulpWgt
	 */
	public void setSplLowSulpDoilSulpWgt(String splLowSulpDoilSulpWgt) {
		this.splLowSulpDoilSulpWgt = splLowSulpDoilSulpWgt;
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
	 * @param seaBlrLowSulpDoilCsmQty
	 */
	public void setSeaBlrLowSulpDoilCsmQty(String seaBlrLowSulpDoilCsmQty) {
		this.seaBlrLowSulpDoilCsmQty = seaBlrLowSulpDoilCsmQty;
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
	 * @param aftUnbrthAnkOffDt
	 */
	public void setAftUnbrthAnkOffDt(String aftUnbrthAnkOffDt) {
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @param seaTtlDoilCsmQty
	 */
	public void setSeaTtlDoilCsmQty(String seaTtlDoilCsmQty) {
		this.seaTtlDoilCsmQty = seaTtlDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splDoilBrgWgt1
	 */
	public void setSplDoilBrgWgt1(String splDoilBrgWgt1) {
		this.splDoilBrgWgt1 = splDoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param portTtlFoilCsmQty
	 */
	public void setPortTtlFoilCsmQty(String portTtlFoilCsmQty) {
		this.portTtlFoilCsmQty = portTtlFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param vskEtdDt
	 */
	public void setVskEtdDt(String vskEtdDt) {
		this.vskEtdDt = vskEtdDt;
	}
	
	/**
	 * Column Info
	 * @param seaMnLowSulpFoilCsmQty
	 */
	public void setSeaMnLowSulpFoilCsmQty(String seaMnLowSulpFoilCsmQty) {
		this.seaMnLowSulpFoilCsmQty = seaMnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param rfCntrLodKnt
	 */
	public void setRfCntrLodKnt(String rfCntrLodKnt) {
		this.rfCntrLodKnt = rfCntrLodKnt;
	}
	
	/**
	 * Column Info
	 * @param splDoilBrgWgt2
	 */
	public void setSplDoilBrgWgt2(String splDoilBrgWgt2) {
		this.splDoilBrgWgt2 = splDoilBrgWgt2;
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
	 * @param aftUnbrthAnkDrpDt
	 */
	public void setAftUnbrthAnkDrpDt(String aftUnbrthAnkDrpDt) {
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param seaGnrDoilCsmQty
	 */
	public void setSeaGnrDoilCsmQty(String seaGnrDoilCsmQty) {
		this.seaGnrDoilCsmQty = seaGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrFrshWtrWgt
	 */
	public void setArrFrshWtrWgt(String arrFrshWtrWgt) {
		this.arrFrshWtrWgt = arrFrshWtrWgt;
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
	 * @param mtyCntrObrdTeu
	 */
	public void setMtyCntrObrdTeu(String mtyCntrObrdTeu) {
		this.mtyCntrObrdTeu = mtyCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilBdrWgt
	 */
	public void setSplLowSulpDoilBdrWgt(String splLowSulpDoilBdrWgt) {
		this.splLowSulpDoilBdrWgt = splLowSulpDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param portGnrLowSulpFoilCsmQty
	 */
	public void setPortGnrLowSulpFoilCsmQty(String portGnrLowSulpFoilCsmQty) {
		this.portGnrLowSulpFoilCsmQty = portGnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrMidDrftHgt
	 */
	public void setArrMidDrftHgt(String arrMidDrftHgt) {
		this.arrMidDrftHgt = arrMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param arrFwddrHgt
	 */
	public void setArrFwddrHgt(String arrFwddrHgt) {
		this.arrFwddrHgt = arrFwddrHgt;
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
	 * @param portBlrFoilCsmQty
	 */
	public void setPortBlrFoilCsmQty(String portBlrFoilCsmQty) {
		this.portBlrFoilCsmQty = portBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param harborInPortTtl
	 */
	public void setHarborInPortTtl(String harborInPortTtl) {
		this.harborInPortTtl = harborInPortTtl;
	}
	
	/**
	 * Column Info
	 * @param portMnLowSulpDoilCsmQty
	 */
	public void setPortMnLowSulpDoilCsmQty(String portMnLowSulpDoilCsmQty) {
		this.portMnLowSulpDoilCsmQty = portMnLowSulpDoilCsmQty;
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
	 * @param seaGnrFoilCsmQty
	 */
	public void setSeaGnrFoilCsmQty(String seaGnrFoilCsmQty) {
		this.seaGnrFoilCsmQty = seaGnrFoilCsmQty;
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
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
	}
	
	/**
	 * Column Info
	 * @param portMnDoilCsmQty
	 */
	public void setPortMnDoilCsmQty(String portMnDoilCsmQty) {
		this.portMnDoilCsmQty = portMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splFoilBrgWgt2
	 */
	public void setSplFoilBrgWgt2(String splFoilBrgWgt2) {
		this.splFoilBrgWgt2 = splFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @param splFoilBrgWgt1
	 */
	public void setSplFoilBrgWgt1(String splFoilBrgWgt1) {
		this.splFoilBrgWgt1 = splFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param skdVoyDir
	 */
	public void setSkdVoyDir(String skdVoyDir) {
		this.skdVoyDir = skdVoyDir;
	}
	
	/**
	 * Column Info
	 * @param depFlg
	 */
	public void setDepFlg(String depFlg) {
		this.depFlg = depFlg;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param seaSteamingTtl
	 */
	public void setSeaSteamingTtl(String seaSteamingTtl) {
		this.seaSteamingTtl = seaSteamingTtl;
	}
	
	/**
	 * Column Info
	 * @param seaSteamingMe
	 */
	public void setSeaSteamingMe(String seaSteamingMe) {
		this.seaSteamingMe = seaSteamingMe;
	}
	
	/**
	 * Column Info
	 * @param portTtlLowSulpFoilCsmQty
	 */
	public void setPortTtlLowSulpFoilCsmQty(String portTtlLowSulpFoilCsmQty) {
		this.portTtlLowSulpFoilCsmQty = portTtlLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portBlrLowSulpFoilCsmQty
	 */
	public void setPortBlrLowSulpFoilCsmQty(String portBlrLowSulpFoilCsmQty) {
		this.portBlrLowSulpFoilCsmQty = portBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portGnrDoilCsmQty
	 */
	public void setPortGnrDoilCsmQty(String portGnrDoilCsmQty) {
		this.portGnrDoilCsmQty = portGnrDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param arrLowSulpFoilWgt
	 */
	public void setArrLowSulpFoilWgt(String arrLowSulpFoilWgt) {
		this.arrLowSulpFoilWgt = arrLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param depFrshWtrWgt
	 */
	public void setDepFrshWtrWgt(String depFrshWtrWgt) {
		this.depFrshWtrWgt = depFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilBrgWgt1
	 */
	public void setSplLowSulpDoilBrgWgt1(String splLowSulpDoilBrgWgt1) {
		this.splLowSulpDoilBrgWgt1 = splLowSulpDoilBrgWgt1;
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
	 * @param splLowSulpDoilBrgWgt2
	 */
	public void setSplLowSulpDoilBrgWgt2(String splLowSulpDoilBrgWgt2) {
		this.splLowSulpDoilBrgWgt2 = splLowSulpDoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilBrgWgt2
	 */
	public void setSplLowSulpFoilBrgWgt2(String splLowSulpFoilBrgWgt2) {
		this.splLowSulpFoilBrgWgt2 = splLowSulpFoilBrgWgt2;
	}
	
	/**
	 * Column Info
	 * @param seaBlrFoilCsmQty
	 */
	public void setSeaBlrFoilCsmQty(String seaBlrFoilCsmQty) {
		this.seaBlrFoilCsmQty = seaBlrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilBrgWgt1
	 */
	public void setSplLowSulpFoilBrgWgt1(String splLowSulpFoilBrgWgt1) {
		this.splLowSulpFoilBrgWgt1 = splLowSulpFoilBrgWgt1;
	}
	
	/**
	 * Column Info
	 * @param lastPortCd
	 */
	public void setLastPortCd(String lastPortCd) {
		this.lastPortCd = lastPortCd;
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
	 * @param arrDoilWgt
	 */
	public void setArrDoilWgt(String arrDoilWgt) {
		this.arrDoilWgt = arrDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param splDoilSulpWgt
	 */
	public void setSplDoilSulpWgt(String splDoilSulpWgt) {
		this.splDoilSulpWgt = splDoilSulpWgt;
	}
	
	/**
	 * Column Info
	 * @param seaTtlFoilCsmQty
	 */
	public void setSeaTtlFoilCsmQty(String seaTtlFoilCsmQty) {
		this.seaTtlFoilCsmQty = seaTtlFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param avgExptFlg
	 */
	public void setAvgExptFlg(String avgExptFlg) {
		this.avgExptFlg = avgExptFlg;
	}
	
	/**
	 * Column Info
	 * @param sailingTime
	 */
	public void setSailingTime(String sailingTime) {
		this.sailingTime = sailingTime;
	}
	
	/**
	 * Column Info
	 * @param portTtlLowSulpDoilCsmQty
	 */
	public void setPortTtlLowSulpDoilCsmQty(String portTtlLowSulpDoilCsmQty) {
		this.portTtlLowSulpDoilCsmQty = portTtlLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaMnFoilCsmQty
	 */
	public void setSeaMnFoilCsmQty(String seaMnFoilCsmQty) {
		this.seaMnFoilCsmQty = seaMnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splDoilBdrWgt
	 */
	public void setSplDoilBdrWgt(String splDoilBdrWgt) {
		this.splDoilBdrWgt = splDoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param ttlCntrObrdTeu
	 */
	public void setTtlCntrObrdTeu(String ttlCntrObrdTeu) {
		this.ttlCntrObrdTeu = ttlCntrObrdTeu;
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
	 * @param fullCntrObrdTeu
	 */
	public void setFullCntrObrdTeu(String fullCntrObrdTeu) {
		this.fullCntrObrdTeu = fullCntrObrdTeu;
	}
	
	/**
	 * Column Info
	 * @param arrGmHgt
	 */
	public void setArrGmHgt(String arrGmHgt) {
		this.arrGmHgt = arrGmHgt;
	}
	
	/**
	 * Column Info
	 * @param portGnrFoilCsmQty
	 */
	public void setPortGnrFoilCsmQty(String portGnrFoilCsmQty) {
		this.portGnrFoilCsmQty = portGnrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaMnDoilCsmQty
	 */
	public void setSeaMnDoilCsmQty(String seaMnDoilCsmQty) {
		this.seaMnDoilCsmQty = seaMnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param portGnrLowSulpDoilCsmQty
	 */
	public void setPortGnrLowSulpDoilCsmQty(String portGnrLowSulpDoilCsmQty) {
		this.portGnrLowSulpDoilCsmQty = portGnrLowSulpDoilCsmQty;
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
	 * @param portBlrLowSulpDoilCsmQty
	 */
	public void setPortBlrLowSulpDoilCsmQty(String portBlrLowSulpDoilCsmQty) {
		this.portBlrLowSulpDoilCsmQty = portBlrLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param splFoilBdrWgt
	 */
	public void setSplFoilBdrWgt(String splFoilBdrWgt) {
		this.splFoilBdrWgt = splFoilBdrWgt;
	}
	
	/**
	 * Column Info
	 * @param seaBlrLowSulpFoilCsmQty
	 */
	public void setSeaBlrLowSulpFoilCsmQty(String seaBlrLowSulpFoilCsmQty) {
		this.seaBlrLowSulpFoilCsmQty = seaBlrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param seaMnLowSulpDoilCsmQty
	 */
	public void setSeaMnLowSulpDoilCsmQty(String seaMnLowSulpDoilCsmQty) {
		this.seaMnLowSulpDoilCsmQty = seaMnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param depMidDrftHgt
	 */
	public void setDepMidDrftHgt(String depMidDrftHgt) {
		this.depMidDrftHgt = depMidDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param portTtlDoilCsmQty
	 */
	public void setPortTtlDoilCsmQty(String portTtlDoilCsmQty) {
		this.portTtlDoilCsmQty = portTtlDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param avgSpd
	 */
	public void setAvgSpd(String avgSpd) {
		this.avgSpd = avgSpd;
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
		setSplLowSulpFoilActWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_act_wgt", ""));
		setPltInDt(JSPUtil.getParameter(request, prefix + "plt_in_dt", ""));
		setSeaBlrDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_doil_csm_qty", ""));
		setBfrBrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_drp_dt", ""));
		setArrFoilWgt(JSPUtil.getParameter(request, prefix + "arr_foil_wgt", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setProPitch(JSPUtil.getParameter(request, prefix + "pro_pitch", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist", ""));
		setDepBlstWgt(JSPUtil.getParameter(request, prefix + "dep_blst_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSeaGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_low_sulp_foil_csm_qty", ""));
		setDepFoilWgt(JSPUtil.getParameter(request, prefix + "dep_foil_wgt", ""));
		setSplLowSulpFoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_bdr_wgt", ""));
		setSplFoilActWgt(JSPUtil.getParameter(request, prefix + "spl_foil_act_wgt", ""));
		setAvgRpmPwr(JSPUtil.getParameter(request, prefix + "avg_rpm_pwr", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPltOutDt(JSPUtil.getParameter(request, prefix + "plt_out_dt", ""));
		setDepFwddrHgt(JSPUtil.getParameter(request, prefix + "dep_fwddr_hgt", ""));
		setDepGmHgt(JSPUtil.getParameter(request, prefix + "dep_gm_hgt", ""));
		setPortBlrDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_doil_csm_qty", ""));
		setDepDplWgt(JSPUtil.getParameter(request, prefix + "dep_dpl_wgt", ""));
		setSeaTtlLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_ttl_low_sulp_doil_csm_qty", ""));
		setSplFoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_foil_sulp_wgt", ""));
		setBfrBrthAnkOffDt(JSPUtil.getParameter(request, prefix + "bfr_brth_ank_off_dt", ""));
		setRmnAvgSpd(JSPUtil.getParameter(request, prefix + "rmn_avg_spd", ""));
		setDepCgoWgt(JSPUtil.getParameter(request, prefix + "dep_cgo_wgt", ""));
		setMnvrInMlDist(JSPUtil.getParameter(request, prefix + "mnvr_in_ml_dist", ""));
		setArrBlstWgt(JSPUtil.getParameter(request, prefix + "arr_blst_wgt", ""));
		setDepDoilWgt(JSPUtil.getParameter(request, prefix + "dep_doil_wgt", ""));
		setSplLowSulpDoilActWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_act_wgt", ""));
		setArrLowSulpDoilWgt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_wgt", ""));
		setSplLowSulpFoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_sulp_wgt", ""));
		setSplDoilActWgt(JSPUtil.getParameter(request, prefix + "spl_doil_act_wgt", ""));
		setRupDt(JSPUtil.getParameter(request, prefix + "rup_dt", ""));
		setVskFlg(JSPUtil.getParameter(request, prefix + "vsk_flg", ""));
		setSbEngDt(JSPUtil.getParameter(request, prefix + "sb_eng_dt", ""));
		setCgoWrkEndDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_end_dt", ""));
		setPortMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_low_sulp_foil_csm_qty", ""));
		setArrAftdrHgt(JSPUtil.getParameter(request, prefix + "arr_aftdr_hgt", ""));
		setDepLowSulpDoilWgt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_doil_wgt", ""));
		setDepAftdrHgt(JSPUtil.getParameter(request, prefix + "dep_aftdr_hgt", ""));
		setPortMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_foil_csm_qty", ""));
		setSeaGnrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_low_sulp_doil_csm_qty", ""));
		setSeaTtlLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_ttl_low_sulp_foil_csm_qty", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setRfCntrDchgKnt(JSPUtil.getParameter(request, prefix + "rf_cntr_dchg_knt", ""));
		setRfCntrObrdKnt(JSPUtil.getParameter(request, prefix + "rf_cntr_obrd_knt", ""));
		setSplLowSulpDoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_sulp_wgt", ""));
		setDepLowSulpFoilWgt(JSPUtil.getParameter(request, prefix + "dep_low_sulp_foil_wgt", ""));
		setSeaBlrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_low_sulp_doil_csm_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAftUnbrthAnkOffDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_off_dt", ""));
		setSeaTtlDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_ttl_doil_csm_qty", ""));
		setSplDoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_doil_brg_wgt1", ""));
		setPortTtlFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_ttl_foil_csm_qty", ""));
		setVskEtdDt(JSPUtil.getParameter(request, prefix + "vsk_etd_dt", ""));
		setSeaMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_low_sulp_foil_csm_qty", ""));
		setRfCntrLodKnt(JSPUtil.getParameter(request, prefix + "rf_cntr_lod_knt", ""));
		setSplDoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_doil_brg_wgt2", ""));
		setCgoWrkStDt(JSPUtil.getParameter(request, prefix + "cgo_wrk_st_dt", ""));
		setAftUnbrthAnkDrpDt(JSPUtil.getParameter(request, prefix + "aft_unbrth_ank_drp_dt", ""));
		setSeaGnrDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_doil_csm_qty", ""));
		setArrFrshWtrWgt(JSPUtil.getParameter(request, prefix + "arr_frsh_wtr_wgt", ""));
		setMnvrOutMlDist(JSPUtil.getParameter(request, prefix + "mnvr_out_ml_dist", ""));
		setMtyCntrObrdTeu(JSPUtil.getParameter(request, prefix + "mty_cntr_obrd_teu", ""));
		setSplLowSulpDoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_bdr_wgt", ""));
		setPortGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_low_sulp_foil_csm_qty", ""));
		setArrMidDrftHgt(JSPUtil.getParameter(request, prefix + "arr_mid_drft_hgt", ""));
		setArrFwddrHgt(JSPUtil.getParameter(request, prefix + "arr_fwddr_hgt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPortBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_foil_csm_qty", ""));
		setHarborInPortTtl(JSPUtil.getParameter(request, prefix + "harbor_in_port_ttl", ""));
		setPortMnLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_low_sulp_doil_csm_qty", ""));
		setRmnDist(JSPUtil.getParameter(request, prefix + "rmn_dist", ""));
		setSeaGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_gnr_foil_csm_qty", ""));
		setEngMlDist(JSPUtil.getParameter(request, prefix + "eng_ml_dist", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setPortMnDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_mn_doil_csm_qty", ""));
		setSplFoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_foil_brg_wgt2", ""));
		setSplFoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_foil_brg_wgt1", ""));
		setSkdVoyDir(JSPUtil.getParameter(request, prefix + "skd_voy_dir", ""));
		setDepFlg(JSPUtil.getParameter(request, prefix + "dep_flg", ""));
		setNxtPortEtaDt(JSPUtil.getParameter(request, prefix + "nxt_port_eta_dt", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setSeaSteamingTtl(JSPUtil.getParameter(request, prefix + "sea_steaming_ttl", ""));
		setSeaSteamingMe(JSPUtil.getParameter(request, prefix + "sea_steaming_me", ""));
		setPortTtlLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_ttl_low_sulp_foil_csm_qty", ""));
		setPortBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_low_sulp_foil_csm_qty", ""));
		setPortGnrDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_doil_csm_qty", ""));
		setArrLowSulpFoilWgt(JSPUtil.getParameter(request, prefix + "arr_low_sulp_foil_wgt", ""));
		setDepFrshWtrWgt(JSPUtil.getParameter(request, prefix + "dep_frsh_wtr_wgt", ""));
		setSplLowSulpDoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_brg_wgt1", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSplLowSulpDoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_brg_wgt2", ""));
		setSplLowSulpFoilBrgWgt2(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_brg_wgt2", ""));
		setSeaBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_foil_csm_qty", ""));
		setSplLowSulpFoilBrgWgt1(JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_brg_wgt1", ""));
		setLastPortCd(JSPUtil.getParameter(request, prefix + "last_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArrDoilWgt(JSPUtil.getParameter(request, prefix + "arr_doil_wgt", ""));
		setSplDoilSulpWgt(JSPUtil.getParameter(request, prefix + "spl_doil_sulp_wgt", ""));
		setSeaTtlFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_ttl_foil_csm_qty", ""));
		setAvgExptFlg(JSPUtil.getParameter(request, prefix + "avg_expt_flg", ""));
		setSailingTime(JSPUtil.getParameter(request, prefix + "sailing_time", ""));
		setPortTtlLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_ttl_low_sulp_doil_csm_qty", ""));
		setSeaMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_foil_csm_qty", ""));
		setSplDoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_doil_bdr_wgt", ""));
		setTtlCntrObrdTeu(JSPUtil.getParameter(request, prefix + "ttl_cntr_obrd_teu", ""));
		setDepPortCd(JSPUtil.getParameter(request, prefix + "dep_port_cd", ""));
		setFullCntrObrdTeu(JSPUtil.getParameter(request, prefix + "full_cntr_obrd_teu", ""));
		setArrGmHgt(JSPUtil.getParameter(request, prefix + "arr_gm_hgt", ""));
		setPortGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_foil_csm_qty", ""));
		setSeaMnDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_doil_csm_qty", ""));
		setPortGnrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_gnr_low_sulp_doil_csm_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPortBlrLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_blr_low_sulp_doil_csm_qty", ""));
		setSplFoilBdrWgt(JSPUtil.getParameter(request, prefix + "spl_foil_bdr_wgt", ""));
		setSeaBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_blr_low_sulp_foil_csm_qty", ""));
		setSeaMnLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "sea_mn_low_sulp_doil_csm_qty", ""));
		setDepMidDrftHgt(JSPUtil.getParameter(request, prefix + "dep_mid_drft_hgt", ""));
		setPortTtlDoilCsmQty(JSPUtil.getParameter(request, prefix + "port_ttl_doil_csm_qty", ""));
		setAvgSpd(JSPUtil.getParameter(request, prefix + "avg_spd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslFcmDepRptVO[]
	 */
	public VslFcmDepRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslFcmDepRptVO[]
	 */
	public VslFcmDepRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslFcmDepRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splLowSulpFoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_act_wgt", length));
			String[] pltInDt = (JSPUtil.getParameter(request, prefix	+ "plt_in_dt", length));
			String[] seaBlrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_doil_csm_qty", length));
			String[] bfrBrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_drp_dt", length));
			String[] arrFoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_foil_wgt", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] proPitch = (JSPUtil.getParameter(request, prefix	+ "pro_pitch", length));
			String[] nvgtMlDist = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist", length));
			String[] depBlstWgt = (JSPUtil.getParameter(request, prefix	+ "dep_blst_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] seaGnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_low_sulp_foil_csm_qty", length));
			String[] depFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_foil_wgt", length));
			String[] splLowSulpFoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_bdr_wgt", length));
			String[] splFoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_act_wgt", length));
			String[] avgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "avg_rpm_pwr", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pltOutDt = (JSPUtil.getParameter(request, prefix	+ "plt_out_dt", length));
			String[] depFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "dep_fwddr_hgt", length));
			String[] depGmHgt = (JSPUtil.getParameter(request, prefix	+ "dep_gm_hgt", length));
			String[] portBlrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_doil_csm_qty", length));
			String[] depDplWgt = (JSPUtil.getParameter(request, prefix	+ "dep_dpl_wgt", length));
			String[] seaTtlLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_ttl_low_sulp_doil_csm_qty", length));
			String[] splFoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_sulp_wgt", length));
			String[] bfrBrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_off_dt", length));
			String[] rmnAvgSpd = (JSPUtil.getParameter(request, prefix	+ "rmn_avg_spd", length));
			String[] depCgoWgt = (JSPUtil.getParameter(request, prefix	+ "dep_cgo_wgt", length));
			String[] mnvrInMlDist = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_ml_dist", length));
			String[] arrBlstWgt = (JSPUtil.getParameter(request, prefix	+ "arr_blst_wgt", length));
			String[] depDoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_doil_wgt", length));
			String[] splLowSulpDoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_act_wgt", length));
			String[] arrLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_wgt", length));
			String[] splLowSulpFoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_sulp_wgt", length));
			String[] splDoilActWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_act_wgt", length));
			String[] rupDt = (JSPUtil.getParameter(request, prefix	+ "rup_dt", length));
			String[] vskFlg = (JSPUtil.getParameter(request, prefix	+ "vsk_flg", length));
			String[] sbEngDt = (JSPUtil.getParameter(request, prefix	+ "sb_eng_dt", length));
			String[] cgoWrkEndDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_end_dt", length));
			String[] portMnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_low_sulp_foil_csm_qty", length));
			String[] arrAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "arr_aftdr_hgt", length));
			String[] depLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_doil_wgt", length));
			String[] depAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "dep_aftdr_hgt", length));
			String[] portMnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_foil_csm_qty", length));
			String[] seaGnrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_low_sulp_doil_csm_qty", length));
			String[] seaTtlLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_ttl_low_sulp_foil_csm_qty", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] rfCntrDchgKnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_dchg_knt", length));
			String[] rfCntrObrdKnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_obrd_knt", length));
			String[] splLowSulpDoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_sulp_wgt", length));
			String[] depLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_foil_wgt", length));
			String[] seaBlrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_low_sulp_doil_csm_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] aftUnbrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_off_dt", length));
			String[] seaTtlDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_ttl_doil_csm_qty", length));
			String[] splDoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_doil_brg_wgt1", length));
			String[] portTtlFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_ttl_foil_csm_qty", length));
			String[] vskEtdDt = (JSPUtil.getParameter(request, prefix	+ "vsk_etd_dt", length));
			String[] seaMnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_low_sulp_foil_csm_qty", length));
			String[] rfCntrLodKnt = (JSPUtil.getParameter(request, prefix	+ "rf_cntr_lod_knt", length));
			String[] splDoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_doil_brg_wgt2", length));
			String[] cgoWrkStDt = (JSPUtil.getParameter(request, prefix	+ "cgo_wrk_st_dt", length));
			String[] aftUnbrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_drp_dt", length));
			String[] seaGnrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_doil_csm_qty", length));
			String[] arrFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "arr_frsh_wtr_wgt", length));
			String[] mnvrOutMlDist = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_ml_dist", length));
			String[] mtyCntrObrdTeu = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_obrd_teu", length));
			String[] splLowSulpDoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_bdr_wgt", length));
			String[] portGnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_low_sulp_foil_csm_qty", length));
			String[] arrMidDrftHgt = (JSPUtil.getParameter(request, prefix	+ "arr_mid_drft_hgt", length));
			String[] arrFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "arr_fwddr_hgt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] portBlrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_foil_csm_qty", length));
			String[] harborInPortTtl = (JSPUtil.getParameter(request, prefix	+ "harbor_in_port_ttl", length));
			String[] portMnLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_low_sulp_doil_csm_qty", length));
			String[] rmnDist = (JSPUtil.getParameter(request, prefix	+ "rmn_dist", length));
			String[] seaGnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_gnr_foil_csm_qty", length));
			String[] engMlDist = (JSPUtil.getParameter(request, prefix	+ "eng_ml_dist", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] portMnDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_mn_doil_csm_qty", length));
			String[] splFoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_foil_brg_wgt2", length));
			String[] splFoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_foil_brg_wgt1", length));
			String[] skdVoyDir = (JSPUtil.getParameter(request, prefix	+ "skd_voy_dir", length));
			String[] depFlg = (JSPUtil.getParameter(request, prefix	+ "dep_flg", length));
			String[] nxtPortEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta_dt", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] seaSteamingTtl = (JSPUtil.getParameter(request, prefix	+ "sea_steaming_ttl", length));
			String[] seaSteamingMe = (JSPUtil.getParameter(request, prefix	+ "sea_steaming_me", length));
			String[] portTtlLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_ttl_low_sulp_foil_csm_qty", length));
			String[] portBlrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_low_sulp_foil_csm_qty", length));
			String[] portGnrDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_doil_csm_qty", length));
			String[] arrLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_foil_wgt", length));
			String[] depFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "dep_frsh_wtr_wgt", length));
			String[] splLowSulpDoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_brg_wgt1", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] splLowSulpDoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_brg_wgt2", length));
			String[] splLowSulpFoilBrgWgt2 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_brg_wgt2", length));
			String[] seaBlrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_foil_csm_qty", length));
			String[] splLowSulpFoilBrgWgt1 = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_brg_wgt1", length));
			String[] lastPortCd = (JSPUtil.getParameter(request, prefix	+ "last_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrDoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_doil_wgt", length));
			String[] splDoilSulpWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_sulp_wgt", length));
			String[] seaTtlFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_ttl_foil_csm_qty", length));
			String[] avgExptFlg = (JSPUtil.getParameter(request, prefix	+ "avg_expt_flg", length));
			String[] sailingTime = (JSPUtil.getParameter(request, prefix	+ "sailing_time", length));
			String[] portTtlLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_ttl_low_sulp_doil_csm_qty", length));
			String[] seaMnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_foil_csm_qty", length));
			String[] splDoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_bdr_wgt", length));
			String[] ttlCntrObrdTeu = (JSPUtil.getParameter(request, prefix	+ "ttl_cntr_obrd_teu", length));
			String[] depPortCd = (JSPUtil.getParameter(request, prefix	+ "dep_port_cd", length));
			String[] fullCntrObrdTeu = (JSPUtil.getParameter(request, prefix	+ "full_cntr_obrd_teu", length));
			String[] arrGmHgt = (JSPUtil.getParameter(request, prefix	+ "arr_gm_hgt", length));
			String[] portGnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_foil_csm_qty", length));
			String[] seaMnDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_doil_csm_qty", length));
			String[] portGnrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_gnr_low_sulp_doil_csm_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] portBlrLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_blr_low_sulp_doil_csm_qty", length));
			String[] splFoilBdrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_bdr_wgt", length));
			String[] seaBlrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_blr_low_sulp_foil_csm_qty", length));
			String[] seaMnLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "sea_mn_low_sulp_doil_csm_qty", length));
			String[] depMidDrftHgt = (JSPUtil.getParameter(request, prefix	+ "dep_mid_drft_hgt", length));
			String[] portTtlDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "port_ttl_doil_csm_qty", length));
			String[] avgSpd = (JSPUtil.getParameter(request, prefix	+ "avg_spd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslFcmDepRptVO();
				if (splLowSulpFoilActWgt[i] != null)
					model.setSplLowSulpFoilActWgt(splLowSulpFoilActWgt[i]);
				if (pltInDt[i] != null)
					model.setPltInDt(pltInDt[i]);
				if (seaBlrDoilCsmQty[i] != null)
					model.setSeaBlrDoilCsmQty(seaBlrDoilCsmQty[i]);
				if (bfrBrthAnkDrpDt[i] != null)
					model.setBfrBrthAnkDrpDt(bfrBrthAnkDrpDt[i]);
				if (arrFoilWgt[i] != null)
					model.setArrFoilWgt(arrFoilWgt[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (proPitch[i] != null)
					model.setProPitch(proPitch[i]);
				if (nvgtMlDist[i] != null)
					model.setNvgtMlDist(nvgtMlDist[i]);
				if (depBlstWgt[i] != null)
					model.setDepBlstWgt(depBlstWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (seaGnrLowSulpFoilCsmQty[i] != null)
					model.setSeaGnrLowSulpFoilCsmQty(seaGnrLowSulpFoilCsmQty[i]);
				if (depFoilWgt[i] != null)
					model.setDepFoilWgt(depFoilWgt[i]);
				if (splLowSulpFoilBdrWgt[i] != null)
					model.setSplLowSulpFoilBdrWgt(splLowSulpFoilBdrWgt[i]);
				if (splFoilActWgt[i] != null)
					model.setSplFoilActWgt(splFoilActWgt[i]);
				if (avgRpmPwr[i] != null)
					model.setAvgRpmPwr(avgRpmPwr[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pltOutDt[i] != null)
					model.setPltOutDt(pltOutDt[i]);
				if (depFwddrHgt[i] != null)
					model.setDepFwddrHgt(depFwddrHgt[i]);
				if (depGmHgt[i] != null)
					model.setDepGmHgt(depGmHgt[i]);
				if (portBlrDoilCsmQty[i] != null)
					model.setPortBlrDoilCsmQty(portBlrDoilCsmQty[i]);
				if (depDplWgt[i] != null)
					model.setDepDplWgt(depDplWgt[i]);
				if (seaTtlLowSulpDoilCsmQty[i] != null)
					model.setSeaTtlLowSulpDoilCsmQty(seaTtlLowSulpDoilCsmQty[i]);
				if (splFoilSulpWgt[i] != null)
					model.setSplFoilSulpWgt(splFoilSulpWgt[i]);
				if (bfrBrthAnkOffDt[i] != null)
					model.setBfrBrthAnkOffDt(bfrBrthAnkOffDt[i]);
				if (rmnAvgSpd[i] != null)
					model.setRmnAvgSpd(rmnAvgSpd[i]);
				if (depCgoWgt[i] != null)
					model.setDepCgoWgt(depCgoWgt[i]);
				if (mnvrInMlDist[i] != null)
					model.setMnvrInMlDist(mnvrInMlDist[i]);
				if (arrBlstWgt[i] != null)
					model.setArrBlstWgt(arrBlstWgt[i]);
				if (depDoilWgt[i] != null)
					model.setDepDoilWgt(depDoilWgt[i]);
				if (splLowSulpDoilActWgt[i] != null)
					model.setSplLowSulpDoilActWgt(splLowSulpDoilActWgt[i]);
				if (arrLowSulpDoilWgt[i] != null)
					model.setArrLowSulpDoilWgt(arrLowSulpDoilWgt[i]);
				if (splLowSulpFoilSulpWgt[i] != null)
					model.setSplLowSulpFoilSulpWgt(splLowSulpFoilSulpWgt[i]);
				if (splDoilActWgt[i] != null)
					model.setSplDoilActWgt(splDoilActWgt[i]);
				if (rupDt[i] != null)
					model.setRupDt(rupDt[i]);
				if (vskFlg[i] != null)
					model.setVskFlg(vskFlg[i]);
				if (sbEngDt[i] != null)
					model.setSbEngDt(sbEngDt[i]);
				if (cgoWrkEndDt[i] != null)
					model.setCgoWrkEndDt(cgoWrkEndDt[i]);
				if (portMnLowSulpFoilCsmQty[i] != null)
					model.setPortMnLowSulpFoilCsmQty(portMnLowSulpFoilCsmQty[i]);
				if (arrAftdrHgt[i] != null)
					model.setArrAftdrHgt(arrAftdrHgt[i]);
				if (depLowSulpDoilWgt[i] != null)
					model.setDepLowSulpDoilWgt(depLowSulpDoilWgt[i]);
				if (depAftdrHgt[i] != null)
					model.setDepAftdrHgt(depAftdrHgt[i]);
				if (portMnFoilCsmQty[i] != null)
					model.setPortMnFoilCsmQty(portMnFoilCsmQty[i]);
				if (seaGnrLowSulpDoilCsmQty[i] != null)
					model.setSeaGnrLowSulpDoilCsmQty(seaGnrLowSulpDoilCsmQty[i]);
				if (seaTtlLowSulpFoilCsmQty[i] != null)
					model.setSeaTtlLowSulpFoilCsmQty(seaTtlLowSulpFoilCsmQty[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (rfCntrDchgKnt[i] != null)
					model.setRfCntrDchgKnt(rfCntrDchgKnt[i]);
				if (rfCntrObrdKnt[i] != null)
					model.setRfCntrObrdKnt(rfCntrObrdKnt[i]);
				if (splLowSulpDoilSulpWgt[i] != null)
					model.setSplLowSulpDoilSulpWgt(splLowSulpDoilSulpWgt[i]);
				if (depLowSulpFoilWgt[i] != null)
					model.setDepLowSulpFoilWgt(depLowSulpFoilWgt[i]);
				if (seaBlrLowSulpDoilCsmQty[i] != null)
					model.setSeaBlrLowSulpDoilCsmQty(seaBlrLowSulpDoilCsmQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (aftUnbrthAnkOffDt[i] != null)
					model.setAftUnbrthAnkOffDt(aftUnbrthAnkOffDt[i]);
				if (seaTtlDoilCsmQty[i] != null)
					model.setSeaTtlDoilCsmQty(seaTtlDoilCsmQty[i]);
				if (splDoilBrgWgt1[i] != null)
					model.setSplDoilBrgWgt1(splDoilBrgWgt1[i]);
				if (portTtlFoilCsmQty[i] != null)
					model.setPortTtlFoilCsmQty(portTtlFoilCsmQty[i]);
				if (vskEtdDt[i] != null)
					model.setVskEtdDt(vskEtdDt[i]);
				if (seaMnLowSulpFoilCsmQty[i] != null)
					model.setSeaMnLowSulpFoilCsmQty(seaMnLowSulpFoilCsmQty[i]);
				if (rfCntrLodKnt[i] != null)
					model.setRfCntrLodKnt(rfCntrLodKnt[i]);
				if (splDoilBrgWgt2[i] != null)
					model.setSplDoilBrgWgt2(splDoilBrgWgt2[i]);
				if (cgoWrkStDt[i] != null)
					model.setCgoWrkStDt(cgoWrkStDt[i]);
				if (aftUnbrthAnkDrpDt[i] != null)
					model.setAftUnbrthAnkDrpDt(aftUnbrthAnkDrpDt[i]);
				if (seaGnrDoilCsmQty[i] != null)
					model.setSeaGnrDoilCsmQty(seaGnrDoilCsmQty[i]);
				if (arrFrshWtrWgt[i] != null)
					model.setArrFrshWtrWgt(arrFrshWtrWgt[i]);
				if (mnvrOutMlDist[i] != null)
					model.setMnvrOutMlDist(mnvrOutMlDist[i]);
				if (mtyCntrObrdTeu[i] != null)
					model.setMtyCntrObrdTeu(mtyCntrObrdTeu[i]);
				if (splLowSulpDoilBdrWgt[i] != null)
					model.setSplLowSulpDoilBdrWgt(splLowSulpDoilBdrWgt[i]);
				if (portGnrLowSulpFoilCsmQty[i] != null)
					model.setPortGnrLowSulpFoilCsmQty(portGnrLowSulpFoilCsmQty[i]);
				if (arrMidDrftHgt[i] != null)
					model.setArrMidDrftHgt(arrMidDrftHgt[i]);
				if (arrFwddrHgt[i] != null)
					model.setArrFwddrHgt(arrFwddrHgt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (portBlrFoilCsmQty[i] != null)
					model.setPortBlrFoilCsmQty(portBlrFoilCsmQty[i]);
				if (harborInPortTtl[i] != null)
					model.setHarborInPortTtl(harborInPortTtl[i]);
				if (portMnLowSulpDoilCsmQty[i] != null)
					model.setPortMnLowSulpDoilCsmQty(portMnLowSulpDoilCsmQty[i]);
				if (rmnDist[i] != null)
					model.setRmnDist(rmnDist[i]);
				if (seaGnrFoilCsmQty[i] != null)
					model.setSeaGnrFoilCsmQty(seaGnrFoilCsmQty[i]);
				if (engMlDist[i] != null)
					model.setEngMlDist(engMlDist[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (portMnDoilCsmQty[i] != null)
					model.setPortMnDoilCsmQty(portMnDoilCsmQty[i]);
				if (splFoilBrgWgt2[i] != null)
					model.setSplFoilBrgWgt2(splFoilBrgWgt2[i]);
				if (splFoilBrgWgt1[i] != null)
					model.setSplFoilBrgWgt1(splFoilBrgWgt1[i]);
				if (skdVoyDir[i] != null)
					model.setSkdVoyDir(skdVoyDir[i]);
				if (depFlg[i] != null)
					model.setDepFlg(depFlg[i]);
				if (nxtPortEtaDt[i] != null)
					model.setNxtPortEtaDt(nxtPortEtaDt[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (seaSteamingTtl[i] != null)
					model.setSeaSteamingTtl(seaSteamingTtl[i]);
				if (seaSteamingMe[i] != null)
					model.setSeaSteamingMe(seaSteamingMe[i]);
				if (portTtlLowSulpFoilCsmQty[i] != null)
					model.setPortTtlLowSulpFoilCsmQty(portTtlLowSulpFoilCsmQty[i]);
				if (portBlrLowSulpFoilCsmQty[i] != null)
					model.setPortBlrLowSulpFoilCsmQty(portBlrLowSulpFoilCsmQty[i]);
				if (portGnrDoilCsmQty[i] != null)
					model.setPortGnrDoilCsmQty(portGnrDoilCsmQty[i]);
				if (arrLowSulpFoilWgt[i] != null)
					model.setArrLowSulpFoilWgt(arrLowSulpFoilWgt[i]);
				if (depFrshWtrWgt[i] != null)
					model.setDepFrshWtrWgt(depFrshWtrWgt[i]);
				if (splLowSulpDoilBrgWgt1[i] != null)
					model.setSplLowSulpDoilBrgWgt1(splLowSulpDoilBrgWgt1[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (splLowSulpDoilBrgWgt2[i] != null)
					model.setSplLowSulpDoilBrgWgt2(splLowSulpDoilBrgWgt2[i]);
				if (splLowSulpFoilBrgWgt2[i] != null)
					model.setSplLowSulpFoilBrgWgt2(splLowSulpFoilBrgWgt2[i]);
				if (seaBlrFoilCsmQty[i] != null)
					model.setSeaBlrFoilCsmQty(seaBlrFoilCsmQty[i]);
				if (splLowSulpFoilBrgWgt1[i] != null)
					model.setSplLowSulpFoilBrgWgt1(splLowSulpFoilBrgWgt1[i]);
				if (lastPortCd[i] != null)
					model.setLastPortCd(lastPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrDoilWgt[i] != null)
					model.setArrDoilWgt(arrDoilWgt[i]);
				if (splDoilSulpWgt[i] != null)
					model.setSplDoilSulpWgt(splDoilSulpWgt[i]);
				if (seaTtlFoilCsmQty[i] != null)
					model.setSeaTtlFoilCsmQty(seaTtlFoilCsmQty[i]);
				if (avgExptFlg[i] != null)
					model.setAvgExptFlg(avgExptFlg[i]);
				if (sailingTime[i] != null)
					model.setSailingTime(sailingTime[i]);
				if (portTtlLowSulpDoilCsmQty[i] != null)
					model.setPortTtlLowSulpDoilCsmQty(portTtlLowSulpDoilCsmQty[i]);
				if (seaMnFoilCsmQty[i] != null)
					model.setSeaMnFoilCsmQty(seaMnFoilCsmQty[i]);
				if (splDoilBdrWgt[i] != null)
					model.setSplDoilBdrWgt(splDoilBdrWgt[i]);
				if (ttlCntrObrdTeu[i] != null)
					model.setTtlCntrObrdTeu(ttlCntrObrdTeu[i]);
				if (depPortCd[i] != null)
					model.setDepPortCd(depPortCd[i]);
				if (fullCntrObrdTeu[i] != null)
					model.setFullCntrObrdTeu(fullCntrObrdTeu[i]);
				if (arrGmHgt[i] != null)
					model.setArrGmHgt(arrGmHgt[i]);
				if (portGnrFoilCsmQty[i] != null)
					model.setPortGnrFoilCsmQty(portGnrFoilCsmQty[i]);
				if (seaMnDoilCsmQty[i] != null)
					model.setSeaMnDoilCsmQty(seaMnDoilCsmQty[i]);
				if (portGnrLowSulpDoilCsmQty[i] != null)
					model.setPortGnrLowSulpDoilCsmQty(portGnrLowSulpDoilCsmQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (portBlrLowSulpDoilCsmQty[i] != null)
					model.setPortBlrLowSulpDoilCsmQty(portBlrLowSulpDoilCsmQty[i]);
				if (splFoilBdrWgt[i] != null)
					model.setSplFoilBdrWgt(splFoilBdrWgt[i]);
				if (seaBlrLowSulpFoilCsmQty[i] != null)
					model.setSeaBlrLowSulpFoilCsmQty(seaBlrLowSulpFoilCsmQty[i]);
				if (seaMnLowSulpDoilCsmQty[i] != null)
					model.setSeaMnLowSulpDoilCsmQty(seaMnLowSulpDoilCsmQty[i]);
				if (depMidDrftHgt[i] != null)
					model.setDepMidDrftHgt(depMidDrftHgt[i]);
				if (portTtlDoilCsmQty[i] != null)
					model.setPortTtlDoilCsmQty(portTtlDoilCsmQty[i]);
				if (avgSpd[i] != null)
					model.setAvgSpd(avgSpd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslFcmDepRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslFcmDepRptVO[]
	 */
	public VslFcmDepRptVO[] getVslFcmDepRptVOs(){
		VslFcmDepRptVO[] vos = (VslFcmDepRptVO[])models.toArray(new VslFcmDepRptVO[models.size()]);
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
		this.splLowSulpFoilActWgt = this.splLowSulpFoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltInDt = this.pltInDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrDoilCsmQty = this.seaBlrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkDrpDt = this.bfrBrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFoilWgt = this.arrFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proPitch = this.proPitch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDist = this.nvgtMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depBlstWgt = this.depBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrLowSulpFoilCsmQty = this.seaGnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilWgt = this.depFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBdrWgt = this.splLowSulpFoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilActWgt = this.splFoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRpmPwr = this.avgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltOutDt = this.pltOutDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFwddrHgt = this.depFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depGmHgt = this.depGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrDoilCsmQty = this.portBlrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDplWgt = this.depDplWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaTtlLowSulpDoilCsmQty = this.seaTtlLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilSulpWgt = this.splFoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkOffDt = this.bfrBrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnAvgSpd = this.rmnAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depCgoWgt = this.depCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInMlDist = this.mnvrInMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlstWgt = this.arrBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDoilWgt = this.depDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilActWgt = this.splLowSulpDoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilWgt = this.arrLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilSulpWgt = this.splLowSulpFoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilActWgt = this.splDoilActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rupDt = this.rupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskFlg = this.vskFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbEngDt = this.sbEngDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkEndDt = this.cgoWrkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnLowSulpFoilCsmQty = this.portMnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrAftdrHgt = this.arrAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpDoilWgt = this.depLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAftdrHgt = this.depAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnFoilCsmQty = this.portMnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrLowSulpDoilCsmQty = this.seaGnrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaTtlLowSulpFoilCsmQty = this.seaTtlLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrDchgKnt = this.rfCntrDchgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrObrdKnt = this.rfCntrObrdKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilSulpWgt = this.splLowSulpDoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilWgt = this.depLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrLowSulpDoilCsmQty = this.seaBlrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkOffDt = this.aftUnbrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaTtlDoilCsmQty = this.seaTtlDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBrgWgt1 = this.splDoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTtlFoilCsmQty = this.portTtlFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskEtdDt = this.vskEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnLowSulpFoilCsmQty = this.seaMnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrLodKnt = this.rfCntrLodKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBrgWgt2 = this.splDoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWrkStDt = this.cgoWrkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkDrpDt = this.aftUnbrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrDoilCsmQty = this.seaGnrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFrshWtrWgt = this.arrFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutMlDist = this.mnvrOutMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrObrdTeu = this.mtyCntrObrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBdrWgt = this.splLowSulpDoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrLowSulpFoilCsmQty = this.portGnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMidDrftHgt = this.arrMidDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFwddrHgt = this.arrFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrFoilCsmQty = this.portBlrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.harborInPortTtl = this.harborInPortTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnLowSulpDoilCsmQty = this.portMnLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnDist = this.rmnDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaGnrFoilCsmQty = this.seaGnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engMlDist = this.engMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portMnDoilCsmQty = this.portMnDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBrgWgt2 = this.splFoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBrgWgt1 = this.splFoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyDir = this.skdVoyDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFlg = this.depFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEtaDt = this.nxtPortEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaSteamingTtl = this.seaSteamingTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaSteamingMe = this.seaSteamingMe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTtlLowSulpFoilCsmQty = this.portTtlLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrLowSulpFoilCsmQty = this.portBlrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrDoilCsmQty = this.portGnrDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpFoilWgt = this.arrLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFrshWtrWgt = this.depFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBrgWgt1 = this.splLowSulpDoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilBrgWgt2 = this.splLowSulpDoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBrgWgt2 = this.splLowSulpFoilBrgWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrFoilCsmQty = this.seaBlrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilBrgWgt1 = this.splLowSulpFoilBrgWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPortCd = this.lastPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilWgt = this.arrDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilSulpWgt = this.splDoilSulpWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaTtlFoilCsmQty = this.seaTtlFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgExptFlg = this.avgExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailingTime = this.sailingTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTtlLowSulpDoilCsmQty = this.portTtlLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnFoilCsmQty = this.seaMnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilBdrWgt = this.splDoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCntrObrdTeu = this.ttlCntrObrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depPortCd = this.depPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullCntrObrdTeu = this.fullCntrObrdTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGmHgt = this.arrGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrFoilCsmQty = this.portGnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnDoilCsmQty = this.seaMnDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portGnrLowSulpDoilCsmQty = this.portGnrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBlrLowSulpDoilCsmQty = this.portBlrLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilBdrWgt = this.splFoilBdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBlrLowSulpFoilCsmQty = this.seaBlrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaMnLowSulpDoilCsmQty = this.seaMnLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depMidDrftHgt = this.depMidDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTtlDoilCsmQty = this.portTtlDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpd = this.avgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
