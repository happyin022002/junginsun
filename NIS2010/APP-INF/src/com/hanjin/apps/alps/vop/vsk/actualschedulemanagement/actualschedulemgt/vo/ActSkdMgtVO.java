/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActSkdMgtVO.java
*@FileTitle : ActSkdMgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.04.16 정진우 
* 1.0 Creation
* 
* 2011.05.13 진마리아 [CHM-201110230-01] VSK-Actual SKD creation 화면 일부 수정 요청(EDI와 Departure Report 정보 구분)
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경. 조회 조건 Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 / ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2012.08.28 진마리아 CHM-201219486-01 VSK_DEP_RPT 차단(FCM_DEP_RPT 대체) / ACT SKD과 VMS Data를 구별하여 alert
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActSkdMgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActSkdMgtVO> models = new ArrayList<ActSkdMgtVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslArrDlayRsnCd = null;
	/* Column Info */
	private String aftUnbrthAnkOffDt = null;
	/* Column Info */
	private String bfrBrthAnkDrpDt = null;
	/* Column Info */
	private String ttlGbgQty = null;
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Column Info */
	private String arrFoilWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String splFoilWgt = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String aftUnbrthAnkDrpDt = null;
	/* Column Info */
	private String lstEtbDt = null;
	/* Column Info */
	private String arrFrshWtrWgt = null;
	/* Column Info */
	private String nxtActInpFlg = null;
	/* Column Info */
	private String portSkdStsCd = null;
	/* Column Info */
	private String depBlstWgt = null;
	/* Column Info */
	private String lstEtaDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String depTugBotKnt = null;
	/* Column Info */
	private String dlayDepTm = null;
	/* Column Info */
	private String prePortCd = null;
	/* Column Info */
	private String depFoilWgt = null;
	/* Column Info */
	private String arrFwddrHgt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String nxtEtaDt = null;
	/* Column Info */
	private String vslBrthDlayRsnCd = null;
	/* Column Info */
	private String vslBrthDlayRsnNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String depFwddrHgt = null;
	/* Column Info */
	private String depGmHgt = null;
	/* Column Info */
	private String vslDepDlayRsnCd = null;
	/* Column Info */
	private String vslArrDlayRsnNm = null;
	/* Column Info */
	private String turnClptIndSeq = null;
	/* Column Info */
	private String pltLstUnldDt = null;
	/* Column Info */
	private String actBrthDt = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String vslDepDlayRsnNm = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String depFrshWtrWgt = null;
	/* Column Info */
	private String dlayArrTm = null;
	/* Column Info */
	private String arrLowSulpFoilWgt = null;
	/* Column Info */
	private String bfrBrthAnkOffDt = null;
	/* Column Info */
	private String splLowSulpDoilWgt = null;
	/* Column Info */
	private String actArrDt = null;
	/* Column Info */
	private String dlayBrthTm = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdStsCd = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arrDoilWgt = null;
	/* Column Info */
	private String depDoilWgt = null;
	/* Column Info */
	private String arrBlstWgt = null;
	/* Column Info */
	private String splFrshWtrWgt = null;
	/* Column Info */
	private String splDoilWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String arrLowSulpDoilWgt = null;
	/* Column Info */
	private String ttlSlgWgt = null;
	/* Column Info */
	private String preEtdDt = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String lstEtdDt = null;
	/* Column Info */
	private String splLowSulpFoilWgt = null;
	/* Column Info */
	private String pfEtaDt = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String arrAftdrHgt = null;
	/* Column Info */
	private String arrGmHgt = null;
	/* Column Info */
	private String depLowSulpDoilWgt = null;
	/* Column Info */
	private String depAftdrHgt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String arrTugBotKnt = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String depLowSulpFoilWgt = null;
	/* Column Info */
	private String actAtaInpDt = null;
	/* Column Info */
	private String actAtaInpUsrId = null;
	/* Column Info */
	private String actAtbInpDt = null;
	/* Column Info */
	private String actAtbInpUsrId = null;
	/* Column Info */
	private String actAtdInpDt = null;
	/* Column Info */
	private String actAtdInpUsrId = null;
	/* Column Info */
	private String arrFoilWgtFlg = null;
	/* Column Info */
	private String arrLowSulpFoilWgtFlg = null;
	/* Column Info */
	private String arrDoilWgtFlg = null;
	/* Column Info */
	private String arrLowSulpDoilWgtFlg = null;
	/* Column Info */
	private String arrFrshWtrWgtFlg = null;
	/* Column Info */
	private String arrBlstWgtFlg = null;
	/* Column Info */
	private String arrFwddrHgtFlg = null;
	/* Column Info */
	private String arrAftdrHgtFlg = null;
	/* Column Info */
	private String arrGmHgtFlg = null;
	/* Column Info */
	private String arrTugBotKntFlg = null;
	/* Column Info */
	private String splFoilWgtFlg = null;
	/* Column Info */
	private String splLowSulpFoilWgtFlg = null;
	/* Column Info */
	private String splDoilWgtFlg = null;
	/* Column Info */
	private String splLowSulpDoilWgtFlg = null;
	/* Column Info */
	private String splFrshWtrWgtFlg = null;
	/* Column Info */
	private String depLowSulpFoilWgtFlg = null;
	/* Column Info */
	private String depFoilWgtFlg = null;
	/* Column Info */
	private String depLowSulpDoilWgtFlg = null;
	/* Column Info */
	private String depDoilWgtFlg = null;
	/* Column Info */
	private String depFrshWtrWgtFlg = null;
	/* Column Info */
	private String depBlstWgtFlg = null;
	/* Column Info */
	private String depFwddrHgtFlg = null;
	/* Column Info */
	private String depAftdrHgtFlg = null;
	/* Column Info */
	private String depGmHgtFlg = null;
	/* Column Info */
	private String depTugBotKntFlg = null;
	/* Column Info */
	private String ttlSlgWgtFlg = null;
	/* Column Info */
	private String ttlGbgQtyFlg = null;
	/* Column Info */
	private String actArrRmk = null;
	/* Column Info */
	private String actBrthRmk = null;
	/* Column Info */
	private String actDepRmk = null;
	/* Column Info */
	private String actSkdSrcSysCd = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActSkdMgtVO() {}

	public ActSkdMgtVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptSeq, String ydCd, String clptIndSeq, String slanCd, String portSkdStsCd, String pfEtaDt, String pfEtbDt, String pfEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String turnPortFlg, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String actArrDt, String actBrthDt, String actDepDt, String lstEtaDt, String lstEtbDt, String lstEtdDt, String dlayArrTm, String dlayBrthTm, String dlayDepTm, String vslArrDlayRsnCd, String vslBrthDlayRsnCd, String vslDepDlayRsnCd, String vslArrDlayRsnNm, String vslBrthDlayRsnNm, String vslDepDlayRsnNm, String arrFoilWgt, String arrLowSulpFoilWgt, String arrDoilWgt, String arrLowSulpDoilWgt, String arrFrshWtrWgt, String arrBlstWgt, String arrFwddrHgt, String arrAftdrHgt, String arrGmHgt, String arrTugBotKnt, String splFoilWgt, String splLowSulpFoilWgt, String splDoilWgt, String splLowSulpDoilWgt, String splFrshWtrWgt, String depLowSulpFoilWgt, String depFoilWgt, String depLowSulpDoilWgt, String depDoilWgt, String depFrshWtrWgt, String depBlstWgt, String depFwddrHgt, String depAftdrHgt, String depGmHgt, String depTugBotKnt, String diffRmk, String pltLstUnldDt, String bfrBrthAnkDrpDt, String bfrBrthAnkOffDt, String aftUnbrthAnkDrpDt, String aftUnbrthAnkOffDt, String ttlSlgWgt, String ttlGbgQty, String creUsrId, String creDt, String updUsrId, String updDt, String prePortCd, String preEtdDt, String nxtPortCd, String nxtEtaDt, String nxtActInpFlg, String flag, String skdStsCd, String actAtaInpDt, String actAtbInpDt, String actAtdInpDt, String actAtaInpUsrId, String actAtbInpUsrId, String actAtdInpUsrId,
			String arrFoilWgtFlg, String arrLowSulpFoilWgtFlg, String arrDoilWgtFlg, String arrLowSulpDoilWgtFlg, String arrFrshWtrWgtFlg, String arrBlstWgtFlg, String arrFwddrHgtFlg, String arrAftdrHgtFlg, String arrGmHgtFlg, String arrTugBotKntFlg, String splFoilWgtFlg, String splLowSulpFoilWgtFlg, String splDoilWgtFlg, String splLowSulpDoilWgtFlg, String splFrshWtrWgtFlg, String depLowSulpFoilWgtFlg, String depFoilWgtFlg, String depLowSulpDoilWgtFlg, String depDoilWgtFlg, String depFrshWtrWgtFlg, String depBlstWgtFlg, String depFwddrHgtFlg, String depAftdrHgtFlg, String depGmHgtFlg, String depTugBotKntFlg, String ttlSlgWgtFlg, String ttlGbgQtyFlg, String actArrRmk, String actBrthRmk, String actDepRmk, String actSkdSrcSysCd) {
		this.vslCd = vslCd;
		this.vslArrDlayRsnCd = vslArrDlayRsnCd;
		this.aftUnbrthAnkOffDt = aftUnbrthAnkOffDt;
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
		this.ttlGbgQty = ttlGbgQty;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.nxtPortCd = nxtPortCd;
		this.arrFoilWgt = arrFoilWgt;
		this.pagerows = pagerows;
		this.splFoilWgt = splFoilWgt;
		this.turnPortIndCd = turnPortIndCd;
		this.vpsPortCd = vpsPortCd;
		this.clptSeq = clptSeq;
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
		this.lstEtbDt = lstEtbDt;
		this.arrFrshWtrWgt = arrFrshWtrWgt;
		this.nxtActInpFlg = nxtActInpFlg;
		this.portSkdStsCd = portSkdStsCd;
		this.depBlstWgt = depBlstWgt;
		this.lstEtaDt = lstEtaDt;
		this.updUsrId = updUsrId;
		this.depTugBotKnt = depTugBotKnt;
		this.dlayDepTm = dlayDepTm;
		this.prePortCd = prePortCd;
		this.depFoilWgt = depFoilWgt;
		this.arrFwddrHgt = arrFwddrHgt;
		this.vpsEtdDt = vpsEtdDt;
		this.skdVoyNo = skdVoyNo;
		this.nxtEtaDt = nxtEtaDt;
		this.vslBrthDlayRsnCd = vslBrthDlayRsnCd;
		this.vslBrthDlayRsnNm = vslBrthDlayRsnNm;
		this.creUsrId = creUsrId;
		this.flag = flag;
		this.depFwddrHgt = depFwddrHgt;
		this.depGmHgt = depGmHgt;
		this.vslDepDlayRsnCd = vslDepDlayRsnCd;
		this.vslArrDlayRsnNm = vslArrDlayRsnNm;
		this.turnClptIndSeq = turnClptIndSeq;
		this.pltLstUnldDt = pltLstUnldDt;
		this.actBrthDt = actBrthDt;
		this.vpsEtbDt = vpsEtbDt;
		this.vslDepDlayRsnNm = vslDepDlayRsnNm;
		this.turnPortFlg = turnPortFlg;
		this.creDt = creDt;
		this.depFrshWtrWgt = depFrshWtrWgt;
		this.dlayArrTm = dlayArrTm;
		this.arrLowSulpFoilWgt = arrLowSulpFoilWgt;
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
		this.splLowSulpDoilWgt = splLowSulpDoilWgt;
		this.actArrDt = actArrDt;
		this.dlayBrthTm = dlayBrthTm;
		this.vpsEtaDt = vpsEtaDt;
		this.skdStsCd = skdStsCd;
		this.turnSkdDirCd = turnSkdDirCd;
		this.ibflag = ibflag;
		this.arrDoilWgt = arrDoilWgt;
		this.depDoilWgt = depDoilWgt;
		this.arrBlstWgt = arrBlstWgt;
		this.splFrshWtrWgt = splFrshWtrWgt;
		this.splDoilWgt = splDoilWgt;
		this.updDt = updDt;
		this.arrLowSulpDoilWgt = arrLowSulpDoilWgt;
		this.ttlSlgWgt = ttlSlgWgt;
		this.preEtdDt = preEtdDt;
		this.pfEtdDt = pfEtdDt;
		this.lstEtdDt = lstEtdDt;
		this.splLowSulpFoilWgt = splLowSulpFoilWgt;
		this.pfEtaDt = pfEtaDt;
		this.pfEtbDt = pfEtbDt;
		this.arrAftdrHgt = arrAftdrHgt;
		this.arrGmHgt = arrGmHgt;
		this.depLowSulpDoilWgt = depLowSulpDoilWgt;
		this.depAftdrHgt = depAftdrHgt;
		this.skdDirCd = skdDirCd;
		this.arrTugBotKnt = arrTugBotKnt;
		this.actDepDt = actDepDt;
		this.diffRmk = diffRmk;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
		this.actAtaInpDt = actAtaInpDt;
		this.actAtbInpDt = actAtbInpDt;
		this.actAtdInpDt = actAtdInpDt;
		this.actAtaInpUsrId = actAtaInpUsrId;
		this.actAtbInpUsrId = actAtbInpUsrId;
		this.actAtdInpUsrId = actAtdInpUsrId;
		
		this.arrFoilWgtFlg = arrFoilWgtFlg;
		this.arrLowSulpFoilWgtFlg = arrLowSulpFoilWgtFlg;
		this.arrDoilWgtFlg = arrDoilWgtFlg;
		this.arrLowSulpDoilWgtFlg = arrLowSulpDoilWgtFlg;
		this.arrFrshWtrWgtFlg = arrFrshWtrWgtFlg;
		this.arrBlstWgtFlg = arrBlstWgtFlg;
		this.arrFwddrHgtFlg = arrFwddrHgtFlg;
		this.arrAftdrHgtFlg = arrAftdrHgtFlg;
		this.arrGmHgtFlg = arrGmHgtFlg;
		this.arrTugBotKntFlg = arrTugBotKntFlg;
		this.splFoilWgtFlg = splFoilWgtFlg;
		this.splLowSulpFoilWgtFlg = splLowSulpFoilWgtFlg;
		this.splDoilWgtFlg = splDoilWgtFlg;
		this.splLowSulpDoilWgtFlg = splLowSulpDoilWgtFlg;
		this.splFrshWtrWgtFlg = splFrshWtrWgtFlg;
		this.depLowSulpFoilWgtFlg = depLowSulpFoilWgtFlg;
		this.depFoilWgtFlg = depFoilWgtFlg;
		this.depLowSulpDoilWgtFlg = depLowSulpDoilWgtFlg;
		this.depDoilWgtFlg = depDoilWgtFlg;
		this.depFrshWtrWgtFlg = depFrshWtrWgtFlg;
		this.depBlstWgtFlg = depBlstWgtFlg;
		this.depFwddrHgtFlg = depFwddrHgtFlg;
		this.depAftdrHgtFlg = depAftdrHgtFlg;
		this.depGmHgtFlg = depGmHgtFlg;
		this.depTugBotKntFlg = depTugBotKntFlg;
		this.ttlSlgWgtFlg = ttlSlgWgtFlg;
		this.ttlGbgQtyFlg = ttlGbgQtyFlg;
		
		this.actArrRmk = actArrRmk;
		this.actBrthRmk = actBrthRmk;
		this.actDepRmk = actDepRmk;
		this.actSkdSrcSysCd = actSkdSrcSysCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_arr_dlay_rsn_cd", getVslArrDlayRsnCd());
		this.hashColumns.put("aft_unbrth_ank_off_dt", getAftUnbrthAnkOffDt());
		this.hashColumns.put("bfr_brth_ank_drp_dt", getBfrBrthAnkDrpDt());
		this.hashColumns.put("ttl_gbg_qty", getTtlGbgQty());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("arr_foil_wgt", getArrFoilWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spl_foil_wgt", getSplFoilWgt());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("aft_unbrth_ank_drp_dt", getAftUnbrthAnkDrpDt());
		this.hashColumns.put("lst_etb_dt", getLstEtbDt());
		this.hashColumns.put("arr_frsh_wtr_wgt", getArrFrshWtrWgt());
		this.hashColumns.put("nxt_act_inp_flg", getNxtActInpFlg());
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("dep_blst_wgt", getDepBlstWgt());
		this.hashColumns.put("lst_eta_dt", getLstEtaDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dep_tug_bot_knt", getDepTugBotKnt());
		this.hashColumns.put("dlay_dep_tm", getDlayDepTm());
		this.hashColumns.put("pre_port_cd", getPrePortCd());
		this.hashColumns.put("dep_foil_wgt", getDepFoilWgt());
		this.hashColumns.put("arr_fwddr_hgt", getArrFwddrHgt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("nxt_eta_dt", getNxtEtaDt());
		this.hashColumns.put("vsl_brth_dlay_rsn_cd", getVslBrthDlayRsnCd());
		this.hashColumns.put("vsl_brth_dlay_rsn_nm", getVslBrthDlayRsnNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("dep_fwddr_hgt", getDepFwddrHgt());
		this.hashColumns.put("dep_gm_hgt", getDepGmHgt());
		this.hashColumns.put("vsl_dep_dlay_rsn_cd", getVslDepDlayRsnCd());
		this.hashColumns.put("vsl_arr_dlay_rsn_nm", getVslArrDlayRsnNm());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		this.hashColumns.put("plt_lst_unld_dt", getPltLstUnldDt());
		this.hashColumns.put("act_brth_dt", getActBrthDt());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("vsl_dep_dlay_rsn_nm", getVslDepDlayRsnNm());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dep_frsh_wtr_wgt", getDepFrshWtrWgt());
		this.hashColumns.put("dlay_arr_tm", getDlayArrTm());
		this.hashColumns.put("arr_low_sulp_foil_wgt", getArrLowSulpFoilWgt());
		this.hashColumns.put("bfr_brth_ank_off_dt", getBfrBrthAnkOffDt());
		this.hashColumns.put("spl_low_sulp_doil_wgt", getSplLowSulpDoilWgt());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("dlay_brth_tm", getDlayBrthTm());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_sts_cd", getSkdStsCd());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("arr_doil_wgt", getArrDoilWgt());
		this.hashColumns.put("dep_doil_wgt", getDepDoilWgt());
		this.hashColumns.put("arr_blst_wgt", getArrBlstWgt());
		this.hashColumns.put("spl_frsh_wtr_wgt", getSplFrshWtrWgt());
		this.hashColumns.put("spl_doil_wgt", getSplDoilWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("arr_low_sulp_doil_wgt", getArrLowSulpDoilWgt());
		this.hashColumns.put("ttl_slg_wgt", getTtlSlgWgt());
		this.hashColumns.put("pre_etd_dt", getPreEtdDt());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("lst_etd_dt", getLstEtdDt());
		this.hashColumns.put("spl_low_sulp_foil_wgt", getSplLowSulpFoilWgt());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("arr_aftdr_hgt", getArrAftdrHgt());
		this.hashColumns.put("arr_gm_hgt", getArrGmHgt());
		this.hashColumns.put("dep_low_sulp_doil_wgt", getDepLowSulpDoilWgt());
		this.hashColumns.put("dep_aftdr_hgt", getDepAftdrHgt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("arr_tug_bot_knt", getArrTugBotKnt());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("dep_low_sulp_foil_wgt", getDepLowSulpFoilWgt());
		
		this.hashColumns.put("act_ata_inp_dt"    , getActAtaInpDt()   );
		this.hashColumns.put("act_atb_inp_dt"    , getActAtbInpDt()   );
		this.hashColumns.put("act_atd_inp_dt"    , getActAtdInpDt()   );
		this.hashColumns.put("act_ata_inp_usr_id", getActAtaInpUsrId());
		this.hashColumns.put("act_atb_inp_usr_id", getActAtbInpUsrId());
		this.hashColumns.put("act_atd_inp_usr_id", getActAtdInpUsrId());
		
		this.hashColumns.put("arr_foil_wgt_flg",           getArrFoilWgtFlg());       
		this.hashColumns.put("arr_low_sulp_foil_wgt_flg",  getArrLowSulpFoilWgtFlg());
		this.hashColumns.put("arr_doil_wgt_flg",           getArrDoilWgtFlg());       
		this.hashColumns.put("arr_low_sulp_doil_wgt_flg",  getArrLowSulpDoilWgtFlg());
		this.hashColumns.put("arr_frsh_wtr_wgt_flg",       getArrFrshWtrWgtFlg());    
		this.hashColumns.put("arr_blst_wgt_flg",           getArrBlstWgtFlg());       
		this.hashColumns.put("arr_fwddr_hgt_flg",          getArrFwddrHgtFlg());      
		this.hashColumns.put("arr_aftdr_hgt_flg",          getArrAftdrHgtFlg());      
		this.hashColumns.put("arr_gm_hgt_flg",             getArrGmHgtFlg());         
		this.hashColumns.put("arr_tug_bot_knt_flg",        getArrTugBotKntFlg());     
		this.hashColumns.put("spl_foil_wgt_flg",           getSplFoilWgtFlg());       
		this.hashColumns.put("spl_low_sulp_foil_wgt_flg",  getSplLowSulpFoilWgtFlg());
		this.hashColumns.put("spl_doil_wgt_flg",           getSplDoilWgtFlg());       
		this.hashColumns.put("spl_low_sulp_doil_wgt_flg",  getSplLowSulpDoilWgtFlg());
		this.hashColumns.put("spl_frsh_wtr_wgt_flg",       getSplFrshWtrWgtFlg());    
		this.hashColumns.put("dep_low_sulp_foil_wgt_flg",  getDepLowSulpFoilWgtFlg());
		this.hashColumns.put("dep_foil_wgt_flg",           getDepFoilWgtFlg());       
		this.hashColumns.put("dep_low_sulp_doil_wgt_flg",  getDepLowSulpDoilWgtFlg());
		this.hashColumns.put("dep_doil_wgt_flg",           getDepDoilWgtFlg());       
		this.hashColumns.put("dep_frsh_wtr_wgt_flg",       getDepFrshWtrWgtFlg());    
		this.hashColumns.put("dep_blst_wgt_flg",           getDepBlstWgtFlg());       
		this.hashColumns.put("dep_fwddr_hgt_flg",          getDepFwddrHgtFlg());      
		this.hashColumns.put("dep_aftdr_hgt_flg",          getDepAftdrHgtFlg());      
		this.hashColumns.put("dep_gm_hgt_flg",             getDepGmHgtFlg());         
		this.hashColumns.put("dep_tug_bot_knt_flg",        getDepTugBotKntFlg());     
		this.hashColumns.put("ttl_slg_wgt_flg",            getTtlSlgWgtFlg());        
		this.hashColumns.put("ttl_gbg_qty_flg",            getTtlGbgQtyFlg());        
		
		this.hashColumns.put("act_arr_rmk", getActArrRmk());
		this.hashColumns.put("act_brth_rmk", getActBrthRmk());
		this.hashColumns.put("act_dep_rmk", getActDepRmk());
		this.hashColumns.put("act_skd_src_sys_cd", getActSkdSrcSysCd());
		
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_arr_dlay_rsn_cd", "vslArrDlayRsnCd");
		this.hashFields.put("aft_unbrth_ank_off_dt", "aftUnbrthAnkOffDt");
		this.hashFields.put("bfr_brth_ank_drp_dt", "bfrBrthAnkDrpDt");
		this.hashFields.put("ttl_gbg_qty", "ttlGbgQty");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("arr_foil_wgt", "arrFoilWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spl_foil_wgt", "splFoilWgt");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("aft_unbrth_ank_drp_dt", "aftUnbrthAnkDrpDt");
		this.hashFields.put("lst_etb_dt", "lstEtbDt");
		this.hashFields.put("arr_frsh_wtr_wgt", "arrFrshWtrWgt");
		this.hashFields.put("nxt_act_inp_flg", "nxtActInpFlg");
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("dep_blst_wgt", "depBlstWgt");
		this.hashFields.put("lst_eta_dt", "lstEtaDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dep_tug_bot_knt", "depTugBotKnt");
		this.hashFields.put("dlay_dep_tm", "dlayDepTm");
		this.hashFields.put("pre_port_cd", "prePortCd");
		this.hashFields.put("dep_foil_wgt", "depFoilWgt");
		this.hashFields.put("arr_fwddr_hgt", "arrFwddrHgt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("nxt_eta_dt", "nxtEtaDt");
		this.hashFields.put("vsl_brth_dlay_rsn_cd", "vslBrthDlayRsnCd");
		this.hashFields.put("vsl_brth_dlay_rsn_nm", "vslBrthDlayRsnNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("dep_fwddr_hgt", "depFwddrHgt");
		this.hashFields.put("dep_gm_hgt", "depGmHgt");
		this.hashFields.put("vsl_dep_dlay_rsn_cd", "vslDepDlayRsnCd");
		this.hashFields.put("vsl_arr_dlay_rsn_nm", "vslArrDlayRsnNm");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		this.hashFields.put("plt_lst_unld_dt", "pltLstUnldDt");
		this.hashFields.put("act_brth_dt", "actBrthDt");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("vsl_dep_dlay_rsn_nm", "vslDepDlayRsnNm");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dep_frsh_wtr_wgt", "depFrshWtrWgt");
		this.hashFields.put("dlay_arr_tm", "dlayArrTm");
		this.hashFields.put("arr_low_sulp_foil_wgt", "arrLowSulpFoilWgt");
		this.hashFields.put("bfr_brth_ank_off_dt", "bfrBrthAnkOffDt");
		this.hashFields.put("spl_low_sulp_doil_wgt", "splLowSulpDoilWgt");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("dlay_brth_tm", "dlayBrthTm");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_sts_cd", "skdStsCd");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("arr_doil_wgt", "arrDoilWgt");
		this.hashFields.put("dep_doil_wgt", "depDoilWgt");
		this.hashFields.put("arr_blst_wgt", "arrBlstWgt");
		this.hashFields.put("spl_frsh_wtr_wgt", "splFrshWtrWgt");
		this.hashFields.put("spl_doil_wgt", "splDoilWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("arr_low_sulp_doil_wgt", "arrLowSulpDoilWgt");
		this.hashFields.put("ttl_slg_wgt", "ttlSlgWgt");
		this.hashFields.put("pre_etd_dt", "preEtdDt");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("lst_etd_dt", "lstEtdDt");
		this.hashFields.put("spl_low_sulp_foil_wgt", "splLowSulpFoilWgt");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("arr_aftdr_hgt", "arrAftdrHgt");
		this.hashFields.put("arr_gm_hgt", "arrGmHgt");
		this.hashFields.put("dep_low_sulp_doil_wgt", "depLowSulpDoilWgt");
		this.hashFields.put("dep_aftdr_hgt", "depAftdrHgt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("arr_tug_bot_knt", "arrTugBotKnt");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("dep_low_sulp_foil_wgt", "depLowSulpFoilWgt");
		
		this.hashFields.put("act_ata_inp_dt",     "actAtaInpDt");
		this.hashFields.put("act_atb_inp_dt",     "actAtbInpDt");
		this.hashFields.put("act_atd_inp_dt",     "actAtdInpDt");
		this.hashFields.put("act_ata_inp_usr_id", "actAtaInpUsrId");
		this.hashFields.put("act_atb_inp_usr_id", "actAtbInpUsrId");
		this.hashFields.put("act_atd_inp_usr_id", "actAtdInpUsrId");
		
		this.hashFields.put("arr_foil_wgt_flg",           "arrFoilWgtFlg");       
		this.hashFields.put("arr_low_sulp_foil_wgt_flg",  "arrLowSulpFoilWgtFlg");
		this.hashFields.put("arr_doil_wgt_flg",           "arrDoilWgtFlg");       
		this.hashFields.put("arr_low_sulp_doil_wgt_flg",  "arrLowSulpDoilWgtFlg");
		this.hashFields.put("arr_frsh_wtr_wgt_flg",       "arrFrshWtrWgtFlg");    
		this.hashFields.put("arr_blst_wgt_flg",           "arrBlstWgtFlg");       
		this.hashFields.put("arr_fwddr_hgt_flg",          "arrFwddrHgtFlg");      
		this.hashFields.put("arr_aftdr_hgt_flg",          "arrAftdrHgtFlg");      
		this.hashFields.put("arr_gm_hgt_flg",             "arrGmHgtFlg");         
		this.hashFields.put("arr_tug_bot_knt_flg",        "arrTugBotKntFlg");     
		this.hashFields.put("spl_foil_wgt_flg",           "splFoilWgtFlg");       
		this.hashFields.put("spl_low_sulp_foil_wgt_flg",  "splLowSulpFoilWgtFlg");
		this.hashFields.put("spl_doil_wgt_flg",           "splDoilWgtFlg");       
		this.hashFields.put("spl_low_sulp_doil_wgt_flg",  "splLowSulpDoilWgtFlg");
		this.hashFields.put("spl_frsh_wtr_wgt_flg",       "splFrshWtrWgtFlg");    
		this.hashFields.put("dep_low_sulp_foil_wgt_flg",  "depLowSulpFoilWgtFlg");
		this.hashFields.put("dep_foil_wgt_flg",           "depFoilWgtFlg");       
		this.hashFields.put("dep_low_sulp_doil_wgt_flg",  "depLowSulpDoilWgtFlg");
		this.hashFields.put("dep_doil_wgt_flg",           "depDoilWgtFlg");       
		this.hashFields.put("dep_frsh_wtr_wgt_flg",       "depFrshWtrWgtFlg");    
		this.hashFields.put("dep_blst_wgt_flg",           "depBlstWgtFlg");       
		this.hashFields.put("dep_fwddr_hgt_flg",          "depFwddrHgtFlg");      
		this.hashFields.put("dep_aftdr_hgt_flg",          "depAftdrHgtFlg");      
		this.hashFields.put("dep_gm_hgt_flg",             "depGmHgtFlg");         
		this.hashFields.put("dep_tug_bot_knt_flg",        "depTugBotKntFlg");     
		this.hashFields.put("ttl_slg_wgt_flg",            "ttlSlgWgtFlg");        
		this.hashFields.put("ttl_gbg_qty_flg",            "ttlGbgQtyFlg");        
		
		this.hashFields.put("act_arr_rmk", "actArrRmk");
		this.hashFields.put("act_brth_rmk", "actBrthRmk");
		this.hashFields.put("act_dep_rmk", "actDepRmk");
		this.hashFields.put("act_skd_src_sys_cd", "actSkdSrcSysCd");
		
		
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
	 * @return vslArrDlayRsnCd
	 */
	public String getVslArrDlayRsnCd() {
		return this.vslArrDlayRsnCd;
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
	 * @return bfrBrthAnkDrpDt
	 */
	public String getBfrBrthAnkDrpDt() {
		return this.bfrBrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return ttlGbgQty
	 */
	public String getTtlGbgQty() {
		return this.ttlGbgQty;
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
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @return arrFoilWgt
	 */
	public String getArrFoilWgt() {
		return this.arrFoilWgt;
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
	 * @return splFoilWgt
	 */
	public String getSplFoilWgt() {
		return this.splFoilWgt;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return aftUnbrthAnkDrpDt
	 */
	public String getAftUnbrthAnkDrpDt() {
		return this.aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @return lstEtbDt
	 */
	public String getLstEtbDt() {
		return this.lstEtbDt;
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
	 * @return nxtActInpFlg
	 */
	public String getNxtActInpFlg() {
		return this.nxtActInpFlg;
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
	 * @return depBlstWgt
	 */
	public String getDepBlstWgt() {
		return this.depBlstWgt;
	}
	
	/**
	 * Column Info
	 * @return lstEtaDt
	 */
	public String getLstEtaDt() {
		return this.lstEtaDt;
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
	 * @return depTugBotKnt
	 */
	public String getDepTugBotKnt() {
		return this.depTugBotKnt;
	}
	
	/**
	 * Column Info
	 * @return dlayDepTm
	 */
	public String getDlayDepTm() {
		return this.dlayDepTm;
	}
	
	/**
	 * Column Info
	 * @return prePortCd
	 */
	public String getPrePortCd() {
		return this.prePortCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return nxtEtaDt
	 */
	public String getNxtEtaDt() {
		return this.nxtEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vslBrthDlayRsnCd
	 */
	public String getVslBrthDlayRsnCd() {
		return this.vslBrthDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @return vslBrthDlayRsnNm
	 */
	public String getVslBrthDlayRsnNm() {
		return this.vslBrthDlayRsnNm;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
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
	 * @return vslDepDlayRsnCd
	 */
	public String getVslDepDlayRsnCd() {
		return this.vslDepDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @return vslArrDlayRsnNm
	 */
	public String getVslArrDlayRsnNm() {
		return this.vslArrDlayRsnNm;
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
	 * @return pltLstUnldDt
	 */
	public String getPltLstUnldDt() {
		return this.pltLstUnldDt;
	}
	
	/**
	 * Column Info
	 * @return actBrthDt
	 */
	public String getActBrthDt() {
		return this.actBrthDt;
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
	 * @return vslDepDlayRsnNm
	 */
	public String getVslDepDlayRsnNm() {
		return this.vslDepDlayRsnNm;
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
	 * @return depFrshWtrWgt
	 */
	public String getDepFrshWtrWgt() {
		return this.depFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @return dlayArrTm
	 */
	public String getDlayArrTm() {
		return this.dlayArrTm;
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
	 * @return bfrBrthAnkOffDt
	 */
	public String getBfrBrthAnkOffDt() {
		return this.bfrBrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpDoilWgt
	 */
	public String getSplLowSulpDoilWgt() {
		return this.splLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
	}
	
	/**
	 * Column Info
	 * @return dlayBrthTm
	 */
	public String getDlayBrthTm() {
		return this.dlayBrthTm;
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
	 * @return skdStsCd
	 */
	public String getSkdStsCd() {
		return this.skdStsCd;
	}
	
	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
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
	 * @return depDoilWgt
	 */
	public String getDepDoilWgt() {
		return this.depDoilWgt;
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
	 * @return splFrshWtrWgt
	 */
	public String getSplFrshWtrWgt() {
		return this.splFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @return splDoilWgt
	 */
	public String getSplDoilWgt() {
		return this.splDoilWgt;
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
	 * @return arrLowSulpDoilWgt
	 */
	public String getArrLowSulpDoilWgt() {
		return this.arrLowSulpDoilWgt;
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
	 * @return preEtdDt
	 */
	public String getPreEtdDt() {
		return this.preEtdDt;
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
	 * @return lstEtdDt
	 */
	public String getLstEtdDt() {
		return this.lstEtdDt;
	}
	
	/**
	 * Column Info
	 * @return splLowSulpFoilWgt
	 */
	public String getSplLowSulpFoilWgt() {
		return this.splLowSulpFoilWgt;
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
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
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
	 * @return arrGmHgt
	 */
	public String getArrGmHgt() {
		return this.arrGmHgt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return arrTugBotKnt
	 */
	public String getArrTugBotKnt() {
		return this.arrTugBotKnt;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return depLowSulpFoilWgt
	 */
	public String getDepLowSulpFoilWgt() {
		return this.depLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @return actAtaInpDt
	 */
	public String getActAtaInpDt() {
		return this.actAtaInpDt;
	}
	
	/**
	 * Column Info
	 * @return actAtbInpDt
	 */
	public String getActAtbInpDt() {
		return this.actAtbInpDt;
	}
	
	/**
	 * Column Info
	 * @return actAtdInpDt
	 */
	public String getActAtdInpDt() {
		return this.actAtdInpDt;
	}
	
	/**
	 * Column Info
	 * @return actAtaInpUsrId
	 */
	public String getActAtaInpUsrId() {
		return this.actAtaInpUsrId;
	}
	
	/**
	 * Column Info
	 * @return actAtbInpUsrId
	 */
	public String getActAtbInpUsrId() {
		return this.actAtbInpUsrId;
	}
	
	/**
	 * Column Info
	 * @return actAtdInpUsrId
	 */
	public String getActAtdInpUsrId() {
		return this.actAtdInpUsrId;
	}
	
	/**
	 * Column Info
	 * @return arrFoilWgtFlg       	
	 */
	public String getArrFoilWgtFlg(){
		return this.arrFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return arrLowSulpFoilWgtFlg	
	 */
	public String getArrLowSulpFoilWgtFlg(){
		return this.arrLowSulpFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return arrDoilWgtFlg       	
	 */
	public String getArrDoilWgtFlg(){
		return this.arrDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return arrLowSulpDoilWgtFlg	
	 */
	public String getArrLowSulpDoilWgtFlg(){
		return this.arrLowSulpDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return arrFrshWtrWgtFlg    	
	 */
	public String getArrFrshWtrWgtFlg(){
		return this.arrFrshWtrWgtFlg;
	}
	/**
	 * Column Info
	 * @return arrBlstWgtFlg       	
	 */
	public String getArrBlstWgtFlg(){
		return this.arrBlstWgtFlg;
	}
	/**
	 * Column Info
	 * @return arrFwddrHgtFlg      	
	 */
	public String getArrFwddrHgtFlg(){
		return this.arrFwddrHgtFlg;
	}
	/**
	 * Column Info
	 * @return arrAftdrHgtFlg      	
	 */
	public String getArrAftdrHgtFlg(){
		return this.arrAftdrHgtFlg;
	}
	/**
	 * Column Info
	 * @return arrGmHgtFlg         	
	 */
	public String getArrGmHgtFlg(){
		return this.arrGmHgtFlg;
	}
	/**
	 * Column Info
	 * @return arrTugBotKntFlg  	
	 */
	public String getArrTugBotKntFlg(){
		return this.arrTugBotKntFlg;
	}
	/**
	 * Column Info
	 * @return splFoilWgtFlg       	
	 */
	public String getSplFoilWgtFlg(){
		return this.splFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return splLowSulpFoilWgtFlg	
	 */
	public String getSplLowSulpFoilWgtFlg(){
		return this.splLowSulpFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return splDoilWgtFlg       	
	 */
	public String getSplDoilWgtFlg(){
		return this.splDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return splLowSulpDoilWgtFlg	
	 */
	public String getSplLowSulpDoilWgtFlg(){
		return this.splLowSulpDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return splFrshWtrWgtFlg    	
	 */
	public String getSplFrshWtrWgtFlg(){
		return this.splFrshWtrWgtFlg;
	}
	/**
	 * Column Info
	 * @return depLowSulpFoilWgtFlg	
	 */
	public String getDepLowSulpFoilWgtFlg(){
		return this.depLowSulpFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return depFoilWgtFlg       	
	 */
	public String getDepFoilWgtFlg(){
		return this.depFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return depLowSulpDoilWgtFlg	
	 */
	public String getDepLowSulpDoilWgtFlg(){
		return this.depLowSulpDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return depDoilWgtFlg       	
	 */
	public String getDepDoilWgtFlg(){
		return this.depDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @return depFrshWtrWgtFlg    	
	 */
	public String getDepFrshWtrWgtFlg(){
		return this.depFrshWtrWgtFlg;
	}
	/**
	 * Column Info
	 * @return depBlstWgtFlg       	
	 */
	public String getDepBlstWgtFlg(){
		return this.depBlstWgtFlg;
	}
	/**
	 * Column Info
	 * @return depFwddrHgtFlg      	
	 */
	public String getDepFwddrHgtFlg(){
		return this.depFwddrHgtFlg;
	}
	/**
	 * Column Info
	 * @return depAftdrHgtFlg      	
	 */
	public String getDepAftdrHgtFlg(){
		return this.depAftdrHgtFlg;
	}
	/**
	 * Column Info
	 * @return depGmHgtFlg         	
	 */
	public String getDepGmHgtFlg(){
		return this.depGmHgtFlg;
	}
	/**
	 * Column Info
	 * @return depTugBotKntFlg  	
	 */
	public String getDepTugBotKntFlg(){
		return this.depTugBotKntFlg;
	}
	/**
	 * Column Info
	 * @return ttlSlgWgtFlg        	
	 */
	public String getTtlSlgWgtFlg(){
		return this.ttlSlgWgtFlg;
	}
	/**
	 * Column Info
	 * @return ttlGbgQtyFlg     	
	 */
	public String getTtlGbgQtyFlg(){
		return this.ttlGbgQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return actArrRmk
	 */
	public String getActArrRmk() {
		return this.actArrRmk;
	}
	
	/**
	 * Column Info
	 * @return actBrthRmk
	 */
	public String getActBrthRmk() {
		return this.actBrthRmk;
	}
	
	/**
	 * Column Info
	 * @return actDepRmk
	 */
	public String getActDepRmk() {
		return this.actDepRmk;
	}
	
	/**
	 * Column Info
	 * @return actSkdSrcSysCd
	 */
	public String getActSkdSrcSysCd() {
		return this.actSkdSrcSysCd;
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
	 * @param vslArrDlayRsnCd
	 */
	public void setVslArrDlayRsnCd(String vslArrDlayRsnCd) {
		this.vslArrDlayRsnCd = vslArrDlayRsnCd;
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
	 * @param bfrBrthAnkDrpDt
	 */
	public void setBfrBrthAnkDrpDt(String bfrBrthAnkDrpDt) {
		this.bfrBrthAnkDrpDt = bfrBrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param ttlGbgQty
	 */
	public void setTtlGbgQty(String ttlGbgQty) {
		this.ttlGbgQty = ttlGbgQty;
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
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @param arrFoilWgt
	 */
	public void setArrFoilWgt(String arrFoilWgt) {
		this.arrFoilWgt = arrFoilWgt;
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
	 * @param splFoilWgt
	 */
	public void setSplFoilWgt(String splFoilWgt) {
		this.splFoilWgt = splFoilWgt;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param aftUnbrthAnkDrpDt
	 */
	public void setAftUnbrthAnkDrpDt(String aftUnbrthAnkDrpDt) {
		this.aftUnbrthAnkDrpDt = aftUnbrthAnkDrpDt;
	}
	
	/**
	 * Column Info
	 * @param lstEtbDt
	 */
	public void setLstEtbDt(String lstEtbDt) {
		this.lstEtbDt = lstEtbDt;
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
	 * @param nxtActInpFlg
	 */
	public void setNxtActInpFlg(String nxtActInpFlg) {
		this.nxtActInpFlg = nxtActInpFlg;
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
	 * @param depBlstWgt
	 */
	public void setDepBlstWgt(String depBlstWgt) {
		this.depBlstWgt = depBlstWgt;
	}
	
	/**
	 * Column Info
	 * @param lstEtaDt
	 */
	public void setLstEtaDt(String lstEtaDt) {
		this.lstEtaDt = lstEtaDt;
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
	 * @param depTugBotKnt
	 */
	public void setDepTugBotKnt(String depTugBotKnt) {
		this.depTugBotKnt = depTugBotKnt;
	}
	
	/**
	 * Column Info
	 * @param dlayDepTm
	 */
	public void setDlayDepTm(String dlayDepTm) {
		this.dlayDepTm = dlayDepTm;
	}
	
	/**
	 * Column Info
	 * @param prePortCd
	 */
	public void setPrePortCd(String prePortCd) {
		this.prePortCd = prePortCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param nxtEtaDt
	 */
	public void setNxtEtaDt(String nxtEtaDt) {
		this.nxtEtaDt = nxtEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vslBrthDlayRsnCd
	 */
	public void setVslBrthDlayRsnCd(String vslBrthDlayRsnCd) {
		this.vslBrthDlayRsnCd = vslBrthDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @param vslBrthDlayRsnNm
	 */
	public void setVslBrthDlayRsnNm(String vslBrthDlayRsnNm) {
		this.vslBrthDlayRsnNm = vslBrthDlayRsnNm;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * @param vslDepDlayRsnCd
	 */
	public void setVslDepDlayRsnCd(String vslDepDlayRsnCd) {
		this.vslDepDlayRsnCd = vslDepDlayRsnCd;
	}
	
	/**
	 * Column Info
	 * @param vslArrDlayRsnNm
	 */
	public void setVslArrDlayRsnNm(String vslArrDlayRsnNm) {
		this.vslArrDlayRsnNm = vslArrDlayRsnNm;
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
	 * @param pltLstUnldDt
	 */
	public void setPltLstUnldDt(String pltLstUnldDt) {
		this.pltLstUnldDt = pltLstUnldDt;
	}
	
	/**
	 * Column Info
	 * @param actBrthDt
	 */
	public void setActBrthDt(String actBrthDt) {
		this.actBrthDt = actBrthDt;
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
	 * @param vslDepDlayRsnNm
	 */
	public void setVslDepDlayRsnNm(String vslDepDlayRsnNm) {
		this.vslDepDlayRsnNm = vslDepDlayRsnNm;
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
	 * @param depFrshWtrWgt
	 */
	public void setDepFrshWtrWgt(String depFrshWtrWgt) {
		this.depFrshWtrWgt = depFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @param dlayArrTm
	 */
	public void setDlayArrTm(String dlayArrTm) {
		this.dlayArrTm = dlayArrTm;
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
	 * @param bfrBrthAnkOffDt
	 */
	public void setBfrBrthAnkOffDt(String bfrBrthAnkOffDt) {
		this.bfrBrthAnkOffDt = bfrBrthAnkOffDt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpDoilWgt
	 */
	public void setSplLowSulpDoilWgt(String splLowSulpDoilWgt) {
		this.splLowSulpDoilWgt = splLowSulpDoilWgt;
	}
	
	/**
	 * Column Info
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
	}
	
	/**
	 * Column Info
	 * @param dlayBrthTm
	 */
	public void setDlayBrthTm(String dlayBrthTm) {
		this.dlayBrthTm = dlayBrthTm;
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
	 * @param skdStsCd
	 */
	public void setSkdStsCd(String skdStsCd) {
		this.skdStsCd = skdStsCd;
	}
	
	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
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
	 * @param depDoilWgt
	 */
	public void setDepDoilWgt(String depDoilWgt) {
		this.depDoilWgt = depDoilWgt;
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
	 * @param splFrshWtrWgt
	 */
	public void setSplFrshWtrWgt(String splFrshWtrWgt) {
		this.splFrshWtrWgt = splFrshWtrWgt;
	}
	
	/**
	 * Column Info
	 * @param splDoilWgt
	 */
	public void setSplDoilWgt(String splDoilWgt) {
		this.splDoilWgt = splDoilWgt;
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
	 * @param arrLowSulpDoilWgt
	 */
	public void setArrLowSulpDoilWgt(String arrLowSulpDoilWgt) {
		this.arrLowSulpDoilWgt = arrLowSulpDoilWgt;
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
	 * @param preEtdDt
	 */
	public void setPreEtdDt(String preEtdDt) {
		this.preEtdDt = preEtdDt;
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
	 * @param lstEtdDt
	 */
	public void setLstEtdDt(String lstEtdDt) {
		this.lstEtdDt = lstEtdDt;
	}
	
	/**
	 * Column Info
	 * @param splLowSulpFoilWgt
	 */
	public void setSplLowSulpFoilWgt(String splLowSulpFoilWgt) {
		this.splLowSulpFoilWgt = splLowSulpFoilWgt;
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
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
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
	 * @param arrGmHgt
	 */
	public void setArrGmHgt(String arrGmHgt) {
		this.arrGmHgt = arrGmHgt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param arrTugBotKnt
	 */
	public void setArrTugBotKnt(String arrTugBotKnt) {
		this.arrTugBotKnt = arrTugBotKnt;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param depLowSulpFoilWgt
	 */
	public void setDepLowSulpFoilWgt(String depLowSulpFoilWgt) {
		this.depLowSulpFoilWgt = depLowSulpFoilWgt;
	}
	
	/**
	 * Column Info
	 * @param actAtaInpDt
	 */
	public void setActAtaInpDt(String actAtaInpDt) {
		this.actAtaInpDt = actAtaInpDt;
	}
	
	/**
	 * Column Info
	 * @param actAtbInpDt
	 */
	public void setActAtbInpDt(String actAtbInpDt) {
		this.actAtbInpDt = actAtbInpDt;
	}
	
	/**
	 * Column Info
	 * @param actAtdInpDt
	 */
	public void setActAtdInpDt(String actAtdInpDt) {
		this.actAtdInpDt = actAtdInpDt;
	}
	
	/**
	 * Column Info
	 * @param actAtaInpUsrId
	 */
	public void setActAtaInpUsrId(String actAtaInpUsrId) {
		this.actAtaInpUsrId = actAtaInpUsrId;
	}
	
	/**
	 * Column Info
	 * @param actAtbInpUsrId
	 */
	public void setActAtbInpUsrId(String actAtbInpUsrId) {
		this.actAtbInpUsrId = actAtbInpUsrId;
	}
	
	/**
	 * Column Info
	 * @param actAtdInpUsrId
	 */
	public void setActAtdInpUsrId(String actAtdInpUsrId) {
		this.actAtdInpUsrId = actAtdInpUsrId;
	}
	
	
	
	/**
	 * Column Info
	 * @param arrFoilWgtFlg
	 */
	public void setArrFoilWgtFlg(String arrFoilWgtFlg){
		this.arrFoilWgtFlg = arrFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param arrLowSulpFoilWgtFlg
	 */
	public void setArrLowSulpFoilWgtFlg(String arrLowSulpFoilWgtFlg){
		this.arrLowSulpFoilWgtFlg = arrLowSulpFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param arrDoilWgtFlg
	 */
	public void setArrDoilWgtFlg(String arrDoilWgtFlg){
		this.arrDoilWgtFlg = arrDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param arrLowSulpDoilWgtFlg
	 */
	public void setArrLowSulpDoilWgtFlg(String arrLowSulpDoilWgtFlg){
		this.arrLowSulpDoilWgtFlg = arrLowSulpDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param arrFrshWtrWgtFlg
	 */
	public void setArrFrshWtrWgtFlg(String arrFrshWtrWgtFlg){
		this.arrFrshWtrWgtFlg = arrFrshWtrWgtFlg;
	}
	/**
	 * Column Info
	 * @param arrBlstWgtFlg
	 */
	public void setArrBlstWgtFlg(String arrBlstWgtFlg){
		this.arrBlstWgtFlg = arrBlstWgtFlg;
	}
	/**
	 * Column Info
	 * @param arrFwddrHgtFlg
	 */
	public void setArrFwddrHgtFlg(String arrFwddrHgtFlg){
		this.arrFwddrHgtFlg = arrFwddrHgtFlg;
	}
	/**
	 * Column Info
	 * @param arrAftdrHgtFlg
	 */
	public void setArrAftdrHgtFlg(String arrAftdrHgtFlg){
		this.arrAftdrHgtFlg = arrAftdrHgtFlg;
	}
	/**
	 * Column Info
	 * @param arrGmHgtFlg
	 */
	public void setArrGmHgtFlg(String arrGmHgtFlg){
		this.arrGmHgtFlg = arrGmHgtFlg;
	}
	/**
	 * Column Info
	 * @param arrTugBotKntFlg
	 */
	public void setArrTugBotKntFlg(String arrTugBotKntFlg){
		this.arrTugBotKntFlg = arrTugBotKntFlg;
	}
	/**
	 * Column Info
	 * @param splFoilWgtFlg
	 */
	public void setSplFoilWgtFlg(String splFoilWgtFlg){
		this.splFoilWgtFlg = splFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param splLowSulpFoilWgtFlg
	 */
	public void setSplLowSulpFoilWgtFlg(String splLowSulpFoilWgtFlg){
		this.splLowSulpFoilWgtFlg = splLowSulpFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param splDoilWgtFlg
	 */
	public void setSplDoilWgtFlg(String splDoilWgtFlg){
		this.splDoilWgtFlg = splDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param splLowSulpDoilWgtFlg
	 */
	public void setSplLowSulpDoilWgtFlg(String splLowSulpDoilWgtFlg){
		this.splLowSulpDoilWgtFlg = splLowSulpDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param splFrshWtrWgtFlg
	 */
	public void setSplFrshWtrWgtFlg(String splFrshWtrWgtFlg){
		this.splFrshWtrWgtFlg = splFrshWtrWgtFlg;
	}
	/**
	 * Column Info
	 * @param depLowSulpFoilWgtFlg
	 */
	public void setDepLowSulpFoilWgtFlg(String depLowSulpFoilWgtFlg){
		this.depLowSulpFoilWgtFlg = depLowSulpFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param depFoilWgtFlg
	 */
	public void setDepFoilWgtFlg(String depFoilWgtFlg){
		this.depFoilWgtFlg = depFoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param depLowSulpDoilWgtFlg
	 */
	public void setDepLowSulpDoilWgtFlg(String depLowSulpDoilWgtFlg){
		this.depLowSulpDoilWgtFlg = depLowSulpDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param depDoilWgtFlg
	 */
	public void setDepDoilWgtFlg(String depDoilWgtFlg){
		this.depDoilWgtFlg = depDoilWgtFlg;
	}
	/**
	 * Column Info
	 * @param depFrshWtrWgtFlg
	 */
	public void setDepFrshWtrWgtFlg(String depFrshWtrWgtFlg){
		this.depFrshWtrWgtFlg = depFrshWtrWgtFlg;
	}
	/**
	 * Column Info
	 * @param depBlstWgtFlg
	 */
	public void setDepBlstWgtFlg(String depBlstWgtFlg){
		this.depBlstWgtFlg = depBlstWgtFlg;
	}
	/**
	 * Column Info
	 * @param depFwddrHgtFlg
	 */
	public void setDepFwddrHgtFlg(String depFwddrHgtFlg){
		this.depFwddrHgtFlg = depFwddrHgtFlg;
	}
	/**
	 * Column Info
	 * @param depAftdrHgtFlg
	 */
	public void setDepAftdrHgtFlg(String depAftdrHgtFlg){
		this.depAftdrHgtFlg = depAftdrHgtFlg;
	}
	/**
	 * Column Info
	 * @param depGmHgtFlg
	 */
	public void setDepGmHgtFlg(String depGmHgtFlg){
		this.depGmHgtFlg = depGmHgtFlg;
	}
	/**
	 * Column Info
	 * @param depTugBotKntFlg
	 */
	public void setDepTugBotKntFlg(String depTugBotKntFlg){
		this.depTugBotKntFlg = depTugBotKntFlg;
	}
	/**
	 * Column Info
	 * @param ttlSlgWgtFlg
	 */
	public void setTtlSlgWgtFlg(String ttlSlgWgtFlg){
		this.ttlSlgWgtFlg = ttlSlgWgtFlg;
	}
	/**
	 * Column Info
	 * @param ttlGbgQtyFlg
	 */
	public void setTtlGbgQtyFlg(String ttlGbgQtyFlg){
		this.ttlGbgQtyFlg = ttlGbgQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param actArrRmk
	 */
	public void setActArrRmk(String actArrRmk) {
		this.actArrRmk = actArrRmk;
	}
	
	/**
	 * Column Info
	 * @param actBrthRmk
	 */
	public void setActBrthRmk(String actBrthRmk) {
		this.actBrthRmk = actBrthRmk;
	}
	
	/**
	 * Column Info
	 * @param actDepRmk
	 */
	public void setActDepRmk(String actDepRmk) {
		this.actDepRmk = actDepRmk;
	}
	
	/**
	 * Column Info
	 * @param actSkdSrcSysCd
	 */
	public void setActSkdSrcSysCd(String actSkdSrcSysCd) {
		this.actSkdSrcSysCd = actSkdSrcSysCd;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslArrDlayRsnCd(JSPUtil.getParameter(request, "vsl_arr_dlay_rsn_cd", ""));
		setAftUnbrthAnkOffDt(JSPUtil.getParameter(request, "aft_unbrth_ank_off_dt", ""));
		setBfrBrthAnkDrpDt(JSPUtil.getParameter(request, "bfr_brth_ank_drp_dt", ""));
		setTtlGbgQty(JSPUtil.getParameter(request, "ttl_gbg_qty", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, "turn_skd_voy_no", ""));
		setNxtPortCd(JSPUtil.getParameter(request, "nxt_port_cd", ""));
		setArrFoilWgt(JSPUtil.getParameter(request, "arr_foil_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSplFoilWgt(JSPUtil.getParameter(request, "spl_foil_wgt", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setAftUnbrthAnkDrpDt(JSPUtil.getParameter(request, "aft_unbrth_ank_drp_dt", ""));
		setLstEtbDt(JSPUtil.getParameter(request, "lst_etb_dt", ""));
		setArrFrshWtrWgt(JSPUtil.getParameter(request, "arr_frsh_wtr_wgt", ""));
		setNxtActInpFlg(JSPUtil.getParameter(request, "nxt_act_inp_flg", ""));
		setPortSkdStsCd(JSPUtil.getParameter(request, "port_skd_sts_cd", ""));
		setDepBlstWgt(JSPUtil.getParameter(request, "dep_blst_wgt", ""));
		setLstEtaDt(JSPUtil.getParameter(request, "lst_eta_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDepTugBotKnt(JSPUtil.getParameter(request, "dep_tug_bot_knt", ""));
		setDlayDepTm(JSPUtil.getParameter(request, "dlay_dep_tm", ""));
		setPrePortCd(JSPUtil.getParameter(request, "pre_port_cd", ""));
		setDepFoilWgt(JSPUtil.getParameter(request, "dep_foil_wgt", ""));
		setArrFwddrHgt(JSPUtil.getParameter(request, "arr_fwddr_hgt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setNxtEtaDt(JSPUtil.getParameter(request, "nxt_eta_dt", ""));
		setVslBrthDlayRsnCd(JSPUtil.getParameter(request, "vsl_brth_dlay_rsn_cd", ""));
		setVslBrthDlayRsnNm(JSPUtil.getParameter(request, "vsl_brth_dlay_rsn_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setDepFwddrHgt(JSPUtil.getParameter(request, "dep_fwddr_hgt", ""));
		setDepGmHgt(JSPUtil.getParameter(request, "dep_gm_hgt", ""));
		setVslDepDlayRsnCd(JSPUtil.getParameter(request, "vsl_dep_dlay_rsn_cd", ""));
		setVslArrDlayRsnNm(JSPUtil.getParameter(request, "vsl_arr_dlay_rsn_nm", ""));
		setTurnClptIndSeq(JSPUtil.getParameter(request, "turn_clpt_ind_seq", ""));
		setPltLstUnldDt(JSPUtil.getParameter(request, "plt_lst_unld_dt", ""));
		setActBrthDt(JSPUtil.getParameter(request, "act_brth_dt", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setVslDepDlayRsnNm(JSPUtil.getParameter(request, "vsl_dep_dlay_rsn_nm", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDepFrshWtrWgt(JSPUtil.getParameter(request, "dep_frsh_wtr_wgt", ""));
		setDlayArrTm(JSPUtil.getParameter(request, "dlay_arr_tm", ""));
		setArrLowSulpFoilWgt(JSPUtil.getParameter(request, "arr_low_sulp_foil_wgt", ""));
		setBfrBrthAnkOffDt(JSPUtil.getParameter(request, "bfr_brth_ank_off_dt", ""));
		setSplLowSulpDoilWgt(JSPUtil.getParameter(request, "spl_low_sulp_doil_wgt", ""));
		setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
		setDlayBrthTm(JSPUtil.getParameter(request, "dlay_brth_tm", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setSkdStsCd(JSPUtil.getParameter(request, "skd_sts_cd", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, "turn_skd_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArrDoilWgt(JSPUtil.getParameter(request, "arr_doil_wgt", ""));
		setDepDoilWgt(JSPUtil.getParameter(request, "dep_doil_wgt", ""));
		setArrBlstWgt(JSPUtil.getParameter(request, "arr_blst_wgt", ""));
		setSplFrshWtrWgt(JSPUtil.getParameter(request, "spl_frsh_wtr_wgt", ""));
		setSplDoilWgt(JSPUtil.getParameter(request, "spl_doil_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setArrLowSulpDoilWgt(JSPUtil.getParameter(request, "arr_low_sulp_doil_wgt", ""));
		setTtlSlgWgt(JSPUtil.getParameter(request, "ttl_slg_wgt", ""));
		setPreEtdDt(JSPUtil.getParameter(request, "pre_etd_dt", ""));
		setPfEtdDt(JSPUtil.getParameter(request, "pf_etd_dt", ""));
		setLstEtdDt(JSPUtil.getParameter(request, "lst_etd_dt", ""));
		setSplLowSulpFoilWgt(JSPUtil.getParameter(request, "spl_low_sulp_foil_wgt", ""));
		setPfEtaDt(JSPUtil.getParameter(request, "pf_eta_dt", ""));
		setPfEtbDt(JSPUtil.getParameter(request, "pf_etb_dt", ""));
		setArrAftdrHgt(JSPUtil.getParameter(request, "arr_aftdr_hgt", ""));
		setArrGmHgt(JSPUtil.getParameter(request, "arr_gm_hgt", ""));
		setDepLowSulpDoilWgt(JSPUtil.getParameter(request, "dep_low_sulp_doil_wgt", ""));
		setDepAftdrHgt(JSPUtil.getParameter(request, "dep_aftdr_hgt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setArrTugBotKnt(JSPUtil.getParameter(request, "arr_tug_bot_knt", ""));
		setActDepDt(JSPUtil.getParameter(request, "act_dep_dt", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setDepLowSulpFoilWgt(JSPUtil.getParameter(request, "dep_low_sulp_foil_wgt", ""));
		
		setActAtaInpDt   (JSPUtil.getParameter(request, "act_ata_inp_dt", ""));
		setActAtbInpDt   (JSPUtil.getParameter(request, "act_atb_inp_dt", ""));
		setActAtdInpDt   (JSPUtil.getParameter(request, "act_atd_inp_dt", ""));
		setActAtaInpUsrId(JSPUtil.getParameter(request, "act_ata_inp_usr_id", ""));
		setActAtbInpUsrId(JSPUtil.getParameter(request, "act_atb_inp_usr_id", ""));
		setActAtdInpUsrId(JSPUtil.getParameter(request, "act_atd_inp_usr_id", ""));
		
		setArrFoilWgtFlg       (JSPUtil.getParameter(request, "arr_foil_wgt_flg", ""));
		setArrLowSulpFoilWgtFlg(JSPUtil.getParameter(request, "arr_low_sulp_foil_wgt_flg", ""));
		setArrDoilWgtFlg       (JSPUtil.getParameter(request, "arr_doil_wgt_flg", ""));
		setArrLowSulpDoilWgtFlg(JSPUtil.getParameter(request, "arr_low_sulp_doil_wgt_flg", ""));
		setArrFrshWtrWgtFlg    (JSPUtil.getParameter(request, "arr_frsh_wtr_wgt_flg", ""));
		setArrBlstWgtFlg       (JSPUtil.getParameter(request, "arr_blst_wgt_flg", ""));
		setArrFwddrHgtFlg      (JSPUtil.getParameter(request, "arr_fwddr_hgt_flg", ""));
		setArrAftdrHgtFlg      (JSPUtil.getParameter(request, "arr_aftdr_hgt_flg", ""));
		setArrGmHgtFlg         (JSPUtil.getParameter(request, "arr_gm_hgt_flg", ""));
		setArrTugBotKntFlg     (JSPUtil.getParameter(request, "arr_tug_bot_knt_flg", ""));
		setSplFoilWgtFlg       (JSPUtil.getParameter(request, "spl_foil_wgt_flg", ""));
		setSplLowSulpFoilWgtFlg(JSPUtil.getParameter(request, "spl_low_sulp_foil_wgt_flg", ""));
		setSplDoilWgtFlg       (JSPUtil.getParameter(request, "spl_doil_wgt_flg", ""));
		setSplLowSulpDoilWgtFlg(JSPUtil.getParameter(request, "spl_low_sulp_doil_wgt_flg", ""));
		setSplFrshWtrWgtFlg    (JSPUtil.getParameter(request, "spl_frsh_wtr_wgt_flg", ""));
		setDepLowSulpFoilWgtFlg(JSPUtil.getParameter(request, "dep_low_sulp_foil_wgt_flg", ""));
		setDepFoilWgtFlg       (JSPUtil.getParameter(request, "dep_foil_wgt_flg", ""));
		setDepLowSulpDoilWgtFlg(JSPUtil.getParameter(request, "dep_low_sulp_doil_wgt_flg", ""));
		setDepDoilWgtFlg       (JSPUtil.getParameter(request, "dep_doil_wgt_flg", ""));
		setDepFrshWtrWgtFlg    (JSPUtil.getParameter(request, "dep_frsh_wtr_wgt_flg", ""));
		setDepBlstWgtFlg       (JSPUtil.getParameter(request, "dep_blst_wgt_flg", ""));
		setDepFwddrHgtFlg      (JSPUtil.getParameter(request, "dep_fwddr_hgt_flg", ""));
		setDepAftdrHgtFlg      (JSPUtil.getParameter(request, "dep_aftdr_hgt_flg", ""));
		setDepGmHgtFlg         (JSPUtil.getParameter(request, "dep_gm_hgt_flg", ""));
		setDepTugBotKntFlg     (JSPUtil.getParameter(request, "dep_tug_bot_knt_flg", ""));
		setTtlSlgWgtFlg        (JSPUtil.getParameter(request, "ttl_slg_wgt_flg", ""));
		setTtlGbgQtyFlg        (JSPUtil.getParameter(request, "ttl_gbg_qty_flg", ""));
		
		setActArrRmk(JSPUtil.getParameter(request, "act_arr_rmk", ""));
		setActBrthRmk(JSPUtil.getParameter(request, "act_brth_rmk", ""));
		setActDepRmk(JSPUtil.getParameter(request, "act_dep_rmk", ""));
		setActSkdSrcSysCd(JSPUtil.getParameter(request, "act_skd_src_sys_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActSkdMgtVO[]
	 */
	public ActSkdMgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActSkdMgtVO[]
	 */
	public ActSkdMgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActSkdMgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslArrDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_arr_dlay_rsn_cd", length));
			String[] aftUnbrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_off_dt", length));
			String[] bfrBrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_drp_dt", length));
			String[] ttlGbgQty = (JSPUtil.getParameter(request, prefix	+ "ttl_gbg_qty", length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] arrFoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_foil_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] splFoilWgt = (JSPUtil.getParameter(request, prefix	+ "spl_foil_wgt", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] aftUnbrthAnkDrpDt = (JSPUtil.getParameter(request, prefix	+ "aft_unbrth_ank_drp_dt", length));
			String[] lstEtbDt = (JSPUtil.getParameter(request, prefix	+ "lst_etb_dt", length));
			String[] arrFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "arr_frsh_wtr_wgt", length));
			String[] nxtActInpFlg = (JSPUtil.getParameter(request, prefix	+ "nxt_act_inp_flg", length));
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] depBlstWgt = (JSPUtil.getParameter(request, prefix	+ "dep_blst_wgt", length));
			String[] lstEtaDt = (JSPUtil.getParameter(request, prefix	+ "lst_eta_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] depTugBotKnt = (JSPUtil.getParameter(request, prefix	+ "dep_tug_bot_knt", length));
			String[] dlayDepTm = (JSPUtil.getParameter(request, prefix	+ "dlay_dep_tm", length));
			String[] prePortCd = (JSPUtil.getParameter(request, prefix	+ "pre_port_cd", length));
			String[] depFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_foil_wgt", length));
			String[] arrFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "arr_fwddr_hgt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] nxtEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_eta_dt", length));
			String[] vslBrthDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_brth_dlay_rsn_cd", length));
			String[] vslBrthDlayRsnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_brth_dlay_rsn_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] depFwddrHgt = (JSPUtil.getParameter(request, prefix	+ "dep_fwddr_hgt", length));
			String[] depGmHgt = (JSPUtil.getParameter(request, prefix	+ "dep_gm_hgt", length));
			String[] vslDepDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dlay_rsn_cd", length));
			String[] vslArrDlayRsnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_arr_dlay_rsn_nm", length));
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq", length));
			String[] pltLstUnldDt = (JSPUtil.getParameter(request, prefix	+ "plt_lst_unld_dt", length));
			String[] actBrthDt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] vslDepDlayRsnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dlay_rsn_nm", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] depFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "dep_frsh_wtr_wgt", length));
			String[] dlayArrTm = (JSPUtil.getParameter(request, prefix	+ "dlay_arr_tm", length));
			String[] arrLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_foil_wgt", length));
			String[] bfrBrthAnkOffDt = (JSPUtil.getParameter(request, prefix	+ "bfr_brth_ank_off_dt", length));
			String[] splLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_doil_wgt", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] dlayBrthTm = (JSPUtil.getParameter(request, prefix	+ "dlay_brth_tm", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_sts_cd", length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arrDoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_doil_wgt", length));
			String[] depDoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_doil_wgt", length));
			String[] arrBlstWgt = (JSPUtil.getParameter(request, prefix	+ "arr_blst_wgt", length));
			String[] splFrshWtrWgt = (JSPUtil.getParameter(request, prefix	+ "spl_frsh_wtr_wgt", length));
			String[] splDoilWgt = (JSPUtil.getParameter(request, prefix	+ "spl_doil_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] arrLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "arr_low_sulp_doil_wgt", length));
			String[] ttlSlgWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_slg_wgt", length));
			String[] preEtdDt = (JSPUtil.getParameter(request, prefix	+ "pre_etd_dt", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] lstEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_etd_dt", length));
			String[] splLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "spl_low_sulp_foil_wgt", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] arrAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "arr_aftdr_hgt", length));
			String[] arrGmHgt = (JSPUtil.getParameter(request, prefix	+ "arr_gm_hgt", length));
			String[] depLowSulpDoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_doil_wgt", length));
			String[] depAftdrHgt = (JSPUtil.getParameter(request, prefix	+ "dep_aftdr_hgt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] arrTugBotKnt = (JSPUtil.getParameter(request, prefix	+ "arr_tug_bot_knt", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] depLowSulpFoilWgt = (JSPUtil.getParameter(request, prefix	+ "dep_low_sulp_foil_wgt", length));
			
			String[] actAtaInpDt    = (JSPUtil.getParameter(request, prefix + "act_ata_inp_dt", length));
			String[] actAtbInpDt    = (JSPUtil.getParameter(request, prefix + "act_atb_inp_dt", length));
			String[] actAtdInpDt    = (JSPUtil.getParameter(request, prefix + "act_atd_inp_dt", length));
			String[] actAtaInpUsrId = (JSPUtil.getParameter(request, prefix + "act_ata_inp_usr_id", length));
			String[] actAtbInpUsrId = (JSPUtil.getParameter(request, prefix + "act_atb_inp_usr_id", length));
			String[] actAtdInpUsrId = (JSPUtil.getParameter(request, prefix + "act_atd_inp_usr_id", length));
			
			String[] arrFoilWgtFlg        = (JSPUtil.getParameter(request, prefix + "arr_foil_wgt_flg", length));
			String[] arrLowSulpFoilWgtFlg = (JSPUtil.getParameter(request, prefix + "arr_low_sulp_foil_wgt_flg", length));
			String[] arrDoilWgtFlg        = (JSPUtil.getParameter(request, prefix + "arr_doil_wgt_flg", length));
			String[] arrLowSulpDoilWgtFlg = (JSPUtil.getParameter(request, prefix + "arr_low_sulp_doil_wgt_flg", length));
			String[] arrFrshWtrWgtFlg     = (JSPUtil.getParameter(request, prefix + "arr_frsh_wtr_wgt_flg", length));
			String[] arrBlstWgtFlg        = (JSPUtil.getParameter(request, prefix + "arr_blst_wgt_flg", length));
			String[] arrFwddrHgtFlg       = (JSPUtil.getParameter(request, prefix + "arr_fwddr_hgt_flg", length));
			String[] arrAftdrHgtFlg       = (JSPUtil.getParameter(request, prefix + "arr_aftdr_hgt_flg", length));
			String[] arrGmHgtFlg          = (JSPUtil.getParameter(request, prefix + "arr_gm_hgt_flg", length));
			String[] arrTugBotKntFlg      = (JSPUtil.getParameter(request, prefix + "arr_tug_bot_knt_flg", length));
			String[] splFoilWgtFlg        = (JSPUtil.getParameter(request, prefix + "spl_foil_wgt_flg", length));
			String[] splLowSulpFoilWgtFlg = (JSPUtil.getParameter(request, prefix + "spl_low_sulp_foil_wgt_flg", length));
			String[] splDoilWgtFlg        = (JSPUtil.getParameter(request, prefix + "spl_doil_wgt_flg", length));
			String[] splLowSulpDoilWgtFlg = (JSPUtil.getParameter(request, prefix + "spl_low_sulp_doil_wgt_flg", length));
			String[] splFrshWtrWgtFlg     = (JSPUtil.getParameter(request, prefix + "spl_frsh_wtr_wgt_flg", length));
			String[] depLowSulpFoilWgtFlg = (JSPUtil.getParameter(request, prefix + "dep_low_sulp_foil_wgt_flg", length));
			String[] depFoilWgtFlg        = (JSPUtil.getParameter(request, prefix + "dep_foil_wgt_flg", length));
			String[] depLowSulpDoilWgtFlg = (JSPUtil.getParameter(request, prefix + "dep_low_sulp_doil_wgt_flg", length));
			String[] depDoilWgtFlg        = (JSPUtil.getParameter(request, prefix + "dep_doil_wgt_flg", length));
			String[] depFrshWtrWgtFlg     = (JSPUtil.getParameter(request, prefix + "dep_frsh_wtr_wgt_flg", length));
			String[] depBlstWgtFlg        = (JSPUtil.getParameter(request, prefix + "dep_blst_wgt_flg", length));
			String[] depFwddrHgtFlg       = (JSPUtil.getParameter(request, prefix + "dep_fwddr_hgt_flg", length));
			String[] depAftdrHgtFlg       = (JSPUtil.getParameter(request, prefix + "dep_aftdr_hgt_flg", length));
			String[] depGmHgtFlg          = (JSPUtil.getParameter(request, prefix + "dep_gm_hgt_flg", length));
			String[] depTugBotKntFlg      = (JSPUtil.getParameter(request, prefix + "dep_tug_bot_knt_flg", length));
			String[] ttlSlgWgtFlg         = (JSPUtil.getParameter(request, prefix + "ttl_slg_wgt_flg", length));
			String[] ttlGbgQtyFlg         = (JSPUtil.getParameter(request, prefix + "ttl_gbg_qty_flg", length));
			
			String[] actArrRmk = (JSPUtil.getParameter(request, prefix	+ "act_arr_rmk", length));
			String[] actBrthRmk = (JSPUtil.getParameter(request, prefix	+ "act_brth_rmk", length));
			String[] actDepRmk = (JSPUtil.getParameter(request, prefix	+ "act_dep_rmk", length));
			String[] actSkdSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "act_skd_src_sys_cd", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new ActSkdMgtVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslArrDlayRsnCd[i] != null)
					model.setVslArrDlayRsnCd(vslArrDlayRsnCd[i]);
				if (aftUnbrthAnkOffDt[i] != null)
					model.setAftUnbrthAnkOffDt(aftUnbrthAnkOffDt[i]);
				if (bfrBrthAnkDrpDt[i] != null)
					model.setBfrBrthAnkDrpDt(bfrBrthAnkDrpDt[i]);
				if (ttlGbgQty[i] != null)
					model.setTtlGbgQty(ttlGbgQty[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (arrFoilWgt[i] != null)
					model.setArrFoilWgt(arrFoilWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (splFoilWgt[i] != null)
					model.setSplFoilWgt(splFoilWgt[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (aftUnbrthAnkDrpDt[i] != null)
					model.setAftUnbrthAnkDrpDt(aftUnbrthAnkDrpDt[i]);
				if (lstEtbDt[i] != null)
					model.setLstEtbDt(lstEtbDt[i]);
				if (arrFrshWtrWgt[i] != null)
					model.setArrFrshWtrWgt(arrFrshWtrWgt[i]);
				if (nxtActInpFlg[i] != null)
					model.setNxtActInpFlg(nxtActInpFlg[i]);
				if (portSkdStsCd[i] != null)
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (depBlstWgt[i] != null)
					model.setDepBlstWgt(depBlstWgt[i]);
				if (lstEtaDt[i] != null)
					model.setLstEtaDt(lstEtaDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (depTugBotKnt[i] != null)
					model.setDepTugBotKnt(depTugBotKnt[i]);
				if (dlayDepTm[i] != null)
					model.setDlayDepTm(dlayDepTm[i]);
				if (prePortCd[i] != null)
					model.setPrePortCd(prePortCd[i]);
				if (depFoilWgt[i] != null)
					model.setDepFoilWgt(depFoilWgt[i]);
				if (arrFwddrHgt[i] != null)
					model.setArrFwddrHgt(arrFwddrHgt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (nxtEtaDt[i] != null)
					model.setNxtEtaDt(nxtEtaDt[i]);
				if (vslBrthDlayRsnCd[i] != null)
					model.setVslBrthDlayRsnCd(vslBrthDlayRsnCd[i]);
				if (vslBrthDlayRsnNm[i] != null)
					model.setVslBrthDlayRsnNm(vslBrthDlayRsnNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (depFwddrHgt[i] != null)
					model.setDepFwddrHgt(depFwddrHgt[i]);
				if (depGmHgt[i] != null)
					model.setDepGmHgt(depGmHgt[i]);
				if (vslDepDlayRsnCd[i] != null)
					model.setVslDepDlayRsnCd(vslDepDlayRsnCd[i]);
				if (vslArrDlayRsnNm[i] != null)
					model.setVslArrDlayRsnNm(vslArrDlayRsnNm[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				if (pltLstUnldDt[i] != null)
					model.setPltLstUnldDt(pltLstUnldDt[i]);
				if (actBrthDt[i] != null)
					model.setActBrthDt(actBrthDt[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (vslDepDlayRsnNm[i] != null)
					model.setVslDepDlayRsnNm(vslDepDlayRsnNm[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (depFrshWtrWgt[i] != null)
					model.setDepFrshWtrWgt(depFrshWtrWgt[i]);
				if (dlayArrTm[i] != null)
					model.setDlayArrTm(dlayArrTm[i]);
				if (arrLowSulpFoilWgt[i] != null)
					model.setArrLowSulpFoilWgt(arrLowSulpFoilWgt[i]);
				if (bfrBrthAnkOffDt[i] != null)
					model.setBfrBrthAnkOffDt(bfrBrthAnkOffDt[i]);
				if (splLowSulpDoilWgt[i] != null)
					model.setSplLowSulpDoilWgt(splLowSulpDoilWgt[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (dlayBrthTm[i] != null)
					model.setDlayBrthTm(dlayBrthTm[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdStsCd[i] != null)
					model.setSkdStsCd(skdStsCd[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arrDoilWgt[i] != null)
					model.setArrDoilWgt(arrDoilWgt[i]);
				if (depDoilWgt[i] != null)
					model.setDepDoilWgt(depDoilWgt[i]);
				if (arrBlstWgt[i] != null)
					model.setArrBlstWgt(arrBlstWgt[i]);
				if (splFrshWtrWgt[i] != null)
					model.setSplFrshWtrWgt(splFrshWtrWgt[i]);
				if (splDoilWgt[i] != null)
					model.setSplDoilWgt(splDoilWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (arrLowSulpDoilWgt[i] != null)
					model.setArrLowSulpDoilWgt(arrLowSulpDoilWgt[i]);
				if (ttlSlgWgt[i] != null)
					model.setTtlSlgWgt(ttlSlgWgt[i]);
				if (preEtdDt[i] != null)
					model.setPreEtdDt(preEtdDt[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (lstEtdDt[i] != null)
					model.setLstEtdDt(lstEtdDt[i]);
				if (splLowSulpFoilWgt[i] != null)
					model.setSplLowSulpFoilWgt(splLowSulpFoilWgt[i]);
				if (pfEtaDt[i] != null)
					model.setPfEtaDt(pfEtaDt[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (arrAftdrHgt[i] != null)
					model.setArrAftdrHgt(arrAftdrHgt[i]);
				if (arrGmHgt[i] != null)
					model.setArrGmHgt(arrGmHgt[i]);
				if (depLowSulpDoilWgt[i] != null)
					model.setDepLowSulpDoilWgt(depLowSulpDoilWgt[i]);
				if (depAftdrHgt[i] != null)
					model.setDepAftdrHgt(depAftdrHgt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (arrTugBotKnt[i] != null)
					model.setArrTugBotKnt(arrTugBotKnt[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (depLowSulpFoilWgt[i] != null)
					model.setDepLowSulpFoilWgt(depLowSulpFoilWgt[i]);
				
				if (actAtaInpDt[i] != null)
					model.setActAtaInpDt(actAtaInpDt[i]);
				if (actAtbInpDt[i] != null)
					model.setActAtbInpDt(actAtbInpDt[i]);
				if (actAtdInpDt[i] != null)
					model.setActAtdInpDt(actAtdInpDt[i]);
				if (actAtaInpUsrId[i] != null)
					model.setActAtaInpUsrId(actAtaInpUsrId[i]);
				if (actAtbInpUsrId[i] != null)
					model.setActAtbInpUsrId(actAtbInpUsrId[i]);
				if (actAtdInpUsrId[i] != null)
					model.setActAtdInpUsrId(actAtdInpUsrId[i]);
				
				if(arrFoilWgtFlg[i]!=null)
					model.setArrFoilWgtFlg(arrFoilWgtFlg[i]);
				if(arrLowSulpFoilWgtFlg[i]!=null)
					model.setArrLowSulpFoilWgtFlg(arrLowSulpFoilWgtFlg[i]);
				if(arrDoilWgtFlg[i]!=null)
					model.setArrDoilWgtFlg(arrDoilWgtFlg[i]);
				if(arrLowSulpDoilWgtFlg[i]!=null)
					model.setArrLowSulpDoilWgtFlg(arrLowSulpDoilWgtFlg[i]);
				if(arrFrshWtrWgtFlg[i]!=null)
					model.setArrFrshWtrWgtFlg(arrFrshWtrWgtFlg[i]);
				if(arrBlstWgtFlg[i]!=null)
					model.setArrBlstWgtFlg(arrBlstWgtFlg[i]);
				if(arrFwddrHgtFlg[i]!=null)
					model.setArrFwddrHgtFlg(arrFwddrHgtFlg[i]);
				if(arrAftdrHgtFlg[i]!=null)
					model.setArrAftdrHgtFlg(arrAftdrHgtFlg[i]);
				if(arrGmHgtFlg[i]!=null)
					model.setArrGmHgtFlg(arrGmHgtFlg[i]);
				if(arrTugBotKntFlg[i]!=null)
					model.setArrTugBotKntFlg(arrTugBotKntFlg[i]);
				if(splFoilWgtFlg[i]!=null)
					model.setSplFoilWgtFlg(splFoilWgtFlg[i]);
				if(splLowSulpFoilWgtFlg[i]!=null)
					model.setSplLowSulpFoilWgtFlg(splLowSulpFoilWgtFlg[i]);
				if(splDoilWgtFlg[i]!=null)
					model.setSplDoilWgtFlg(splDoilWgtFlg[i]);
				if(splLowSulpDoilWgtFlg[i]!=null)
					model.setSplLowSulpDoilWgtFlg(splLowSulpDoilWgtFlg[i]);
				if(splFrshWtrWgtFlg[i]!=null)
					model.setSplFrshWtrWgtFlg(splFrshWtrWgtFlg[i]);
				if(depLowSulpFoilWgtFlg[i]!=null)
					model.setDepLowSulpFoilWgtFlg(depLowSulpFoilWgtFlg[i]);
				if(depFoilWgtFlg[i]!=null)
					model.setDepFoilWgtFlg(depFoilWgtFlg[i]);
				if(depLowSulpDoilWgtFlg[i]!=null)
					model.setDepLowSulpDoilWgtFlg(depLowSulpDoilWgtFlg[i]);
				if(depDoilWgtFlg[i]!=null)
					model.setDepDoilWgtFlg(depDoilWgtFlg[i]);
				if(depFrshWtrWgtFlg[i]!=null)
					model.setDepFrshWtrWgtFlg(depFrshWtrWgtFlg[i]);
				if(depBlstWgtFlg[i]!=null)
					model.setDepBlstWgtFlg(depBlstWgtFlg[i]);
				if(depFwddrHgtFlg[i]!=null)
					model.setDepFwddrHgtFlg(depFwddrHgtFlg[i]);
				if(depAftdrHgtFlg[i]!=null)
					model.setDepAftdrHgtFlg(depAftdrHgtFlg[i]);
				if(depGmHgtFlg[i]!=null)
					model.setDepGmHgtFlg(depGmHgtFlg[i]);
				if(depTugBotKntFlg[i]!=null)
					model.setDepTugBotKntFlg(depTugBotKntFlg[i]);
				if(ttlSlgWgtFlg[i]!=null)
					model.setTtlSlgWgtFlg(ttlSlgWgtFlg[i]);
				if(ttlGbgQtyFlg[i]!=null)
					model.setTtlGbgQtyFlg(ttlGbgQtyFlg[i]);
				
				if (actArrRmk[i] != null)
					model.setActArrRmk(actArrRmk[i]);
				if (actBrthRmk[i] != null)
					model.setActBrthRmk(actBrthRmk[i]);
				if (actDepRmk[i] != null)
					model.setActDepRmk(actDepRmk[i]);
				if (actSkdSrcSysCd[i] != null)
					model.setActSkdSrcSysCd(actSkdSrcSysCd[i]);
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActSkdMgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActSkdMgtVO[]
	 */
	public ActSkdMgtVO[] getActSkdMgtVOs(){
		ActSkdMgtVO[] vos = (ActSkdMgtVO[])models.toArray(new ActSkdMgtVO[models.size()]);
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
		this.vslArrDlayRsnCd = this.vslArrDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkOffDt = this.aftUnbrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkDrpDt = this.bfrBrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlGbgQty = this.ttlGbgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFoilWgt = this.arrFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilWgt = this.splFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftUnbrthAnkDrpDt = this.aftUnbrthAnkDrpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstEtbDt = this.lstEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFrshWtrWgt = this.arrFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtActInpFlg = this.nxtActInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depBlstWgt = this.depBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstEtaDt = this.lstEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTugBotKnt = this.depTugBotKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlayDepTm = this.dlayDepTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePortCd = this.prePortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilWgt = this.depFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFwddrHgt = this.arrFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtEtaDt = this.nxtEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBrthDlayRsnCd = this.vslBrthDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBrthDlayRsnNm = this.vslBrthDlayRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFwddrHgt = this.depFwddrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depGmHgt = this.depGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDlayRsnCd = this.vslDepDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslArrDlayRsnNm = this.vslArrDlayRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltLstUnldDt = this.pltLstUnldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthDt = this.actBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDlayRsnNm = this.vslDepDlayRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFrshWtrWgt = this.depFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlayArrTm = this.dlayArrTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpFoilWgt = this.arrLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBrthAnkOffDt = this.bfrBrthAnkOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilWgt = this.splLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlayBrthTm = this.dlayBrthTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsCd = this.skdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilWgt = this.arrDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDoilWgt = this.depDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlstWgt = this.arrBlstWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFrshWtrWgt = this.splFrshWtrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilWgt = this.splDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilWgt = this.arrLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSlgWgt = this.ttlSlgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEtdDt = this.preEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstEtdDt = this.lstEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilWgt = this.splLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrAftdrHgt = this.arrAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGmHgt = this.arrGmHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpDoilWgt = this.depLowSulpDoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAftdrHgt = this.depAftdrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTugBotKnt = this.arrTugBotKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilWgt = this.depLowSulpFoilWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.actAtaInpDt    = this.actAtaInpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAtbInpDt    = this.actAtbInpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAtdInpDt    = this.actAtdInpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAtaInpUsrId = this.actAtaInpUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAtbInpUsrId = this.actAtbInpUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAtdInpUsrId = this.actAtdInpUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.arrFoilWgtFlg              = this.arrFoilWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpFoilWgtFlg       = this.arrLowSulpFoilWgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDoilWgtFlg              = this.arrDoilWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLowSulpDoilWgtFlg       = this.arrLowSulpDoilWgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFrshWtrWgtFlg           = this.arrFrshWtrWgtFlg    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrBlstWgtFlg              = this.arrBlstWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFwddrHgtFlg             = this.arrFwddrHgtFlg      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrAftdrHgtFlg             = this.arrAftdrHgtFlg      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGmHgtFlg                = this.arrGmHgtFlg         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTugBotKntFlg            = this.arrTugBotKntFlg     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFoilWgtFlg              = this.splFoilWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpFoilWgtFlg       = this.splLowSulpFoilWgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splDoilWgtFlg              = this.splDoilWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splLowSulpDoilWgtFlg       = this.splLowSulpDoilWgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splFrshWtrWgtFlg           = this.splFrshWtrWgtFlg    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpFoilWgtFlg       = this.depLowSulpFoilWgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFoilWgtFlg              = this.depFoilWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLowSulpDoilWgtFlg       = this.depLowSulpDoilWgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDoilWgtFlg              = this.depDoilWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFrshWtrWgtFlg           = this.depFrshWtrWgtFlg    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depBlstWgtFlg              = this.depBlstWgtFlg       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depFwddrHgtFlg             = this.depFwddrHgtFlg      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depAftdrHgtFlg             = this.depAftdrHgtFlg      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depGmHgtFlg                = this.depGmHgtFlg         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depTugBotKntFlg            = this.depTugBotKntFlg     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSlgWgtFlg               = this.ttlSlgWgtFlg        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlGbgQtyFlg               = this.ttlGbgQtyFlg        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.actArrRmk = this.actArrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthRmk = this.actBrthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepRmk = this.actDepRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSkdSrcSysCd = this.actSkdSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
