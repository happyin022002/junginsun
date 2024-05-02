/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CstSkdBerthWdoVO.java
*@FileTitle : CstSkdBerthWdoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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

public class CstSkdBerthWdoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstSkdBerthWdoVO> models = new ArrayList<CstSkdBerthWdoVO>();
	
	/* Column Info */ 
	private String ofcInpFlg = null;
	/* Column Info */
	private String nxtVvd = null;
	/* Column Info */
	private String usrInfo = null;
	/* Column Info */
	private String plismVoyNo = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String extMsgFlg = null;
	/* Column Info */ 
	private String noonRptInpFlg = null;
	/* Column Info */
	private String vslDlayRsnDesc = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String freeTmDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String initEtaDt = null;
	/* Column Info */
	private String prePortCd = null;
	/* Column Info */
	private String shpCallNoUpdUsrId = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String headerSeq = null;
	/* Column Info */
	private String obCgoQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String tmlVslCd = null;
	/* Column Info */
	private String nxtEtaDt = null;
	/* Column Info */
	private String ediSndKnt = null;
	/* Column Info */
	private String portPos = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String usdFlg = null;
	/* Column Info */
	private String vslDlayRsnLocCd = null;
	/* Column Info */
	private String phsIoRsnCd = null;
	/* Column Info */
	private String mphnNo = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Column Info */
	private String portSkpTpCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String laneGrpNm = null;
	/* Column Info */
	private String vslDlayRsnCd = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String plismVslCd = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String preEtdDt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String ftDt = null;
	/* Column Info */
	private String portSkpRsnOffrRmk = null;
	/* Column Info */
	private String phsIoRmk = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String depRptInpFlg = null;
	/* Column Info */
	private String updDtTxt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String actWrkHrs = null;
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Column Info */
	private String initSkdInpFlg = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String skdBrthNo = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String lastSkipFlg = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String portSkdStsCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String initEtbDt = null;
	/* Column Info */
	private String portSkpRsnCd = null;
	/* Column Info */
	private String plismYdCd = null;
	/* Column Info */
	private String cgoTtl = null;
	/* Column Info */
	private String initEtdDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String uqVslIdNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String shpCallNoUpdDt = null;
	/* Column Info */
	private String bfrActFlg = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String turnClptIndSeq = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String vpsRmk = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String firstSkipFlg = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String tmlVoyNo = null;
	/* Column Info */
	private String shpCallNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String prtChkFlg = null;
	/* Column Info */
	private String tsPortCd = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String ttlDlayHrs = null;
	/* Column Info */
	private String pfEtaDt = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String winRmk = null;
	/* Column Info */
	private String actInpFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pfEtbDy = null;
	/* Column Info */
	private String ibCgoQty = null;
	/* Column Info */
	private String pfEtdDy = null;
	/* Column Info */
	private String pfEtaDy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstSkdBerthWdoVO() {}

	public CstSkdBerthWdoVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String vpsPortCd, String clptIndSeq, String clptSeq, String slanCd, String portSkdStsCd, String ydCd, String ydNm, String callYdIndSeq, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String vslDlayRsnCd, String vslDlayRsnDesc, String vslDlayRsnLocCd, String shpCallNo, String shpCallNoUpdUsrId, String shpCallNoUpdDt, String tmlVslCd, String tmlVoyNo, String ftDt, String freeTmDt, String plismYdCd, String plismVslCd, String plismVoyNo, String skdCngStsCd, String turnPortFlg, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String ibCgoQty, String obCgoQty, String cgoTtl, String vpsRmk, String winRmk, String phsIoRsnCd, String phsIoRmk, String skdBrthNo, String initSkdInpFlg, String ofcInpFlg, String noonRptInpFlg, String depRptInpFlg, String actInpFlg, String prtChkFlg, String creUsrId, String creDt, String updUsrId, String updDt, String updDtTxt, String ediSndKnt, String portSkpTpCd, String portSkpRsnCd, String portSkpRsnOffrRmk, String ttlDlayHrs, String tsPortCd, String usdFlg, String lnkSpd, String seaBufHrs, String portBufHrs, String tztmHrs, String actWrkHrs, String lnkDist, String mnvrOutHrs, String mnvrInHrs, String vslSvcTpCd, String laneGrp, String laneGrpNm, String usrId, String fmDt, String toDt, String extMsgFlg, String usrInfo, String portPos, String headerSeq, String diffRmk, String usrNm, String mphnNo, String faxNo, String usrEml, String uqVslIdNo, String bfrActFlg, String pfEtaDy, String pfEtbDy, String pfEtdDy, String nxtVvd, String nxtPortCd, String nxtEtaDt, String vslEngNm, String totalCnt, String rnum, String preVvd, String prePortCd, String preEtdDt, String pageNo, String firstSkipFlg, String maxSeq, String lastSkipFlg) {
		this.ofcInpFlg = ofcInpFlg;
		this.nxtVvd = nxtVvd;
		this.usrInfo = usrInfo;
		this.plismVoyNo = plismVoyNo;
		this.nxtPortCd = nxtPortCd;
		this.pagerows = pagerows;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.extMsgFlg = extMsgFlg;
		this.noonRptInpFlg = noonRptInpFlg;
		this.vslDlayRsnDesc = vslDlayRsnDesc;
		this.totalCnt = totalCnt;
		this.freeTmDt = freeTmDt;
		this.updUsrId = updUsrId;
		this.initEtaDt = initEtaDt;
		this.prePortCd = prePortCd;
		this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
		this.lnkDist = lnkDist;
		this.headerSeq = headerSeq;
		this.obCgoQty = obCgoQty;
		this.skdVoyNo = skdVoyNo;
		this.tmlVslCd = tmlVslCd;
		this.nxtEtaDt = nxtEtaDt;
		this.ediSndKnt = ediSndKnt;
		this.portPos = portPos;
		this.maxSeq = maxSeq;
		this.pageNo = pageNo;
		this.usdFlg = usdFlg;
		this.vslDlayRsnLocCd = vslDlayRsnLocCd;
		this.phsIoRsnCd = phsIoRsnCd;
		this.mphnNo = mphnNo;
		this.turnSkdDirCd = turnSkdDirCd;
		this.portSkpTpCd = portSkpTpCd;
		this.usrId = usrId;
		this.laneGrpNm = laneGrpNm;
		this.vslDlayRsnCd = vslDlayRsnCd;
		this.callYdIndSeq = callYdIndSeq;
		this.plismVslCd = plismVslCd;
		this.vslSvcTpCd = vslSvcTpCd;
		this.preEtdDt = preEtdDt;
		this.fmDt = fmDt;
		this.ftDt = ftDt;
		this.portSkpRsnOffrRmk = portSkpRsnOffrRmk;
		this.phsIoRmk = phsIoRmk;
		this.mnvrInHrs = mnvrInHrs;
		this.slanCd = slanCd;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.depRptInpFlg = depRptInpFlg;
		this.updDtTxt = updDtTxt;
		this.vslCd = vslCd;
		this.lnkSpd = lnkSpd;
		this.seaBufHrs = seaBufHrs;
		this.actWrkHrs = actWrkHrs;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.portBufHrs = portBufHrs;
		this.initSkdInpFlg = initSkdInpFlg;
		this.tztmHrs = tztmHrs;
		this.turnPortIndCd = turnPortIndCd;
		this.skdBrthNo = skdBrthNo;
		this.preVvd = preVvd;
		this.lastSkipFlg = lastSkipFlg;
		this.rnum = rnum;
		this.usrEml = usrEml;
		this.portSkdStsCd = portSkdStsCd;
		this.vpsEtdDt = vpsEtdDt;
		this.initEtbDt = initEtbDt;
		this.portSkpRsnCd = portSkpRsnCd;
		this.plismYdCd = plismYdCd;
		this.cgoTtl = cgoTtl;
		this.initEtdDt = initEtdDt;
		this.vvd = vvd;
		this.toDt = toDt;
		this.uqVslIdNo = uqVslIdNo;
		this.creUsrId = creUsrId;
		this.skdCngStsCd = skdCngStsCd;
		this.shpCallNoUpdDt = shpCallNoUpdDt;
		this.bfrActFlg = bfrActFlg;
		this.ydNm = ydNm;
		this.faxNo = faxNo;
		this.turnClptIndSeq = turnClptIndSeq;
		this.mnvrOutHrs = mnvrOutHrs;
		this.vpsRmk = vpsRmk;
		this.vpsEtbDt = vpsEtbDt;
		this.firstSkipFlg = firstSkipFlg;
		this.turnPortFlg = turnPortFlg;
		this.creDt = creDt;
		this.vpsEtaDt = vpsEtaDt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.usrNm = usrNm;
		this.tmlVoyNo = tmlVoyNo;
		this.shpCallNo = shpCallNo;
		this.updDt = updDt;
		this.prtChkFlg = prtChkFlg;
		this.tsPortCd = tsPortCd;
		this.pfEtdDt = pfEtdDt;
		this.laneGrp = laneGrp;
		this.ttlDlayHrs = ttlDlayHrs;
		this.pfEtaDt = pfEtaDt;
		this.pfEtbDt = pfEtbDt;
		this.winRmk = winRmk;
		this.actInpFlg = actInpFlg;
		this.skdDirCd = skdDirCd;
		this.pfEtbDy = pfEtbDy;
		this.ibCgoQty = ibCgoQty;
		this.pfEtdDy = pfEtdDy;
		this.pfEtaDy = pfEtaDy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_inp_flg", getOfcInpFlg());
		this.hashColumns.put("nxt_vvd", getNxtVvd());
		this.hashColumns.put("usr_info", getUsrInfo());
		this.hashColumns.put("plism_voy_no", getPlismVoyNo());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ext_msg_flg", getExtMsgFlg());
		this.hashColumns.put("noon_rpt_inp_flg", getNoonRptInpFlg());
		this.hashColumns.put("vsl_dlay_rsn_desc", getVslDlayRsnDesc());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("free_tm_dt", getFreeTmDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("pre_port_cd", getPrePortCd());
		this.hashColumns.put("shp_call_no_upd_usr_id", getShpCallNoUpdUsrId());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("header_seq", getHeaderSeq());
		this.hashColumns.put("ob_cgo_qty", getObCgoQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("tml_vsl_cd", getTmlVslCd());
		this.hashColumns.put("nxt_eta_dt", getNxtEtaDt());
		this.hashColumns.put("edi_snd_knt", getEdiSndKnt());
		this.hashColumns.put("port_pos", getPortPos());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("usd_flg", getUsdFlg());
		this.hashColumns.put("vsl_dlay_rsn_loc_cd", getVslDlayRsnLocCd());
		this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
		this.hashColumns.put("mphn_no", getMphnNo());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("lane_grp_nm", getLaneGrpNm());
		this.hashColumns.put("vsl_dlay_rsn_cd", getVslDlayRsnCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("plism_vsl_cd", getPlismVslCd());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("pre_etd_dt", getPreEtdDt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("ft_dt", getFtDt());
		this.hashColumns.put("port_skp_rsn_offr_rmk", getPortSkpRsnOffrRmk());
		this.hashColumns.put("phs_io_rmk", getPhsIoRmk());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("dep_rpt_inp_flg", getDepRptInpFlg());
		this.hashColumns.put("upd_dt_txt", getUpdDtTxt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
		this.hashColumns.put("init_skd_inp_flg", getInitSkdInpFlg());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("skd_brth_no", getSkdBrthNo());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("last_skip_flg", getLastSkipFlg());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("init_etb_dt", getInitEtbDt());
		this.hashColumns.put("port_skp_rsn_cd", getPortSkpRsnCd());
		this.hashColumns.put("plism_yd_cd", getPlismYdCd());
		this.hashColumns.put("cgo_ttl", getCgoTtl());
		this.hashColumns.put("init_etd_dt", getInitEtdDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("uq_vsl_id_no", getUqVslIdNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("shp_call_no_upd_dt", getShpCallNoUpdDt());
		this.hashColumns.put("bfr_act_flg", getBfrActFlg());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("vps_rmk", getVpsRmk());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("first_skip_flg", getFirstSkipFlg());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("tml_voy_no", getTmlVoyNo());
		this.hashColumns.put("shp_call_no", getShpCallNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prt_chk_flg", getPrtChkFlg());
		this.hashColumns.put("ts_port_cd", getTsPortCd());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("ttl_dlay_hrs", getTtlDlayHrs());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("win_rmk", getWinRmk());
		this.hashColumns.put("act_inp_flg", getActInpFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pf_etb_dy", getPfEtbDy());
		this.hashColumns.put("ib_cgo_qty", getIbCgoQty());
		this.hashColumns.put("pf_etd_dy", getPfEtdDy());
		this.hashColumns.put("pf_eta_dy", getPfEtaDy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_inp_flg", "ofcInpFlg");
		this.hashFields.put("nxt_vvd", "nxtVvd");
		this.hashFields.put("usr_info", "usrInfo");
		this.hashFields.put("plism_voy_no", "plismVoyNo");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ext_msg_flg", "extMsgFlg");
		this.hashFields.put("noon_rpt_inp_flg", "noonRptInpFlg");
		this.hashFields.put("vsl_dlay_rsn_desc", "vslDlayRsnDesc");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("free_tm_dt", "freeTmDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("pre_port_cd", "prePortCd");
		this.hashFields.put("shp_call_no_upd_usr_id", "shpCallNoUpdUsrId");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("header_seq", "headerSeq");
		this.hashFields.put("ob_cgo_qty", "obCgoQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("tml_vsl_cd", "tmlVslCd");
		this.hashFields.put("nxt_eta_dt", "nxtEtaDt");
		this.hashFields.put("edi_snd_knt", "ediSndKnt");
		this.hashFields.put("port_pos", "portPos");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("usd_flg", "usdFlg");
		this.hashFields.put("vsl_dlay_rsn_loc_cd", "vslDlayRsnLocCd");
		this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
		this.hashFields.put("mphn_no", "mphnNo");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("lane_grp_nm", "laneGrpNm");
		this.hashFields.put("vsl_dlay_rsn_cd", "vslDlayRsnCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("plism_vsl_cd", "plismVslCd");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("pre_etd_dt", "preEtdDt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("ft_dt", "ftDt");
		this.hashFields.put("port_skp_rsn_offr_rmk", "portSkpRsnOffrRmk");
		this.hashFields.put("phs_io_rmk", "phsIoRmk");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("dep_rpt_inp_flg", "depRptInpFlg");
		this.hashFields.put("upd_dt_txt", "updDtTxt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("act_wrk_hrs", "actWrkHrs");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
		this.hashFields.put("init_skd_inp_flg", "initSkdInpFlg");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("skd_brth_no", "skdBrthNo");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("last_skip_flg", "lastSkipFlg");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("init_etb_dt", "initEtbDt");
		this.hashFields.put("port_skp_rsn_cd", "portSkpRsnCd");
		this.hashFields.put("plism_yd_cd", "plismYdCd");
		this.hashFields.put("cgo_ttl", "cgoTtl");
		this.hashFields.put("init_etd_dt", "initEtdDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("uq_vsl_id_no", "uqVslIdNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("shp_call_no_upd_dt", "shpCallNoUpdDt");
		this.hashFields.put("bfr_act_flg", "bfrActFlg");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("vps_rmk", "vpsRmk");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("first_skip_flg", "firstSkipFlg");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("tml_voy_no", "tmlVoyNo");
		this.hashFields.put("shp_call_no", "shpCallNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prt_chk_flg", "prtChkFlg");
		this.hashFields.put("ts_port_cd", "tsPortCd");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("ttl_dlay_hrs", "ttlDlayHrs");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("win_rmk", "winRmk");
		this.hashFields.put("act_inp_flg", "actInpFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pf_etb_dy", "pfEtbDy");
		this.hashFields.put("ib_cgo_qty", "ibCgoQty");
		this.hashFields.put("pf_etd_dy", "pfEtdDy");
		this.hashFields.put("pf_eta_dy", "pfEtaDy");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcInpFlg
	 */
	public String getOfcInpFlg() {
		return this.ofcInpFlg;
	}
	
	/**
	 * Column Info
	 * @return nxtVvd
	 */
	public String getNxtVvd() {
		return this.nxtVvd;
	}
	
	/**
	 * Column Info
	 * @return usrInfo
	 */
	public String getUsrInfo() {
		return this.usrInfo;
	}
	
	/**
	 * Column Info
	 * @return plismVoyNo
	 */
	public String getPlismVoyNo() {
		return this.plismVoyNo;
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
	 * @return extMsgFlg
	 */
	public String getExtMsgFlg() {
		return this.extMsgFlg;
	}
	
	/**
	 * Column Info
	 * @return noonRptInpFlg
	 */
	public String getNoonRptInpFlg() {
		return this.noonRptInpFlg;
	}
	
	/**
	 * Column Info
	 * @return vslDlayRsnDesc
	 */
	public String getVslDlayRsnDesc() {
		return this.vslDlayRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return freeTmDt
	 */
	public String getFreeTmDt() {
		return this.freeTmDt;
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
	 * @return initEtaDt
	 */
	public String getInitEtaDt() {
		return this.initEtaDt;
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
	 * @return shpCallNoUpdUsrId
	 */
	public String getShpCallNoUpdUsrId() {
		return this.shpCallNoUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return headerSeq
	 */
	public String getHeaderSeq() {
		return this.headerSeq;
	}
	
	/**
	 * Column Info
	 * @return obCgoQty
	 */
	public String getObCgoQty() {
		return this.obCgoQty;
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
	 * @return tmlVslCd
	 */
	public String getTmlVslCd() {
		return this.tmlVslCd;
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
	 * @return ediSndKnt
	 */
	public String getEdiSndKnt() {
		return this.ediSndKnt;
	}
	
	/**
	 * Column Info
	 * @return portPos
	 */
	public String getPortPos() {
		return this.portPos;
	}
	
	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return usdFlg
	 */
	public String getUsdFlg() {
		return this.usdFlg;
	}
	
	/**
	 * Column Info
	 * @return vslDlayRsnLocCd
	 */
	public String getVslDlayRsnLocCd() {
		return this.vslDlayRsnLocCd;
	}
	
	/**
	 * Column Info
	 * @return phsIoRsnCd
	 */
	public String getPhsIoRsnCd() {
		return this.phsIoRsnCd;
	}
	
	/**
	 * Column Info
	 * @return mphnNo
	 */
	public String getMphnNo() {
		return this.mphnNo;
	}
	
	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return portSkpTpCd
	 */
	public String getPortSkpTpCd() {
		return this.portSkpTpCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return laneGrpNm
	 */
	public String getLaneGrpNm() {
		return this.laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @return vslDlayRsnCd
	 */
	public String getVslDlayRsnCd() {
		return this.vslDlayRsnCd;
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
	 * @return plismVslCd
	 */
	public String getPlismVslCd() {
		return this.plismVslCd;
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
	 * @return preEtdDt
	 */
	public String getPreEtdDt() {
		return this.preEtdDt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return ftDt
	 */
	public String getFtDt() {
		return this.ftDt;
	}
	
	/**
	 * Column Info
	 * @return portSkpRsnOffrRmk
	 */
	public String getPortSkpRsnOffrRmk() {
		return this.portSkpRsnOffrRmk;
	}
	
	/**
	 * Column Info
	 * @return phsIoRmk
	 */
	public String getPhsIoRmk() {
		return this.phsIoRmk;
	}
	
	/**
	 * Column Info
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return depRptInpFlg
	 */
	public String getDepRptInpFlg() {
		return this.depRptInpFlg;
	}
	
	/**
	 * Column Info
	 * @return updDtTxt
	 */
	public String getUpdDtTxt() {
		return this.updDtTxt;
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
	 * @return lnkSpd
	 */
	public String getLnkSpd() {
		return this.lnkSpd;
	}
	
	/**
	 * Column Info
	 * @return seaBufHrs
	 */
	public String getSeaBufHrs() {
		return this.seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @return actWrkHrs
	 */
	public String getActWrkHrs() {
		return this.actWrkHrs;
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
	 * @return portBufHrs
	 */
	public String getPortBufHrs() {
		return this.portBufHrs;
	}
	
	/**
	 * Column Info
	 * @return initSkdInpFlg
	 */
	public String getInitSkdInpFlg() {
		return this.initSkdInpFlg;
	}
	
	/**
	 * Column Info
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
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
	 * @return skdBrthNo
	 */
	public String getSkdBrthNo() {
		return this.skdBrthNo;
	}
	
	/**
	 * Column Info
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return lastSkipFlg
	 */
	public String getLastSkipFlg() {
		return this.lastSkipFlg;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
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
	 * @return portSkpRsnCd
	 */
	public String getPortSkpRsnCd() {
		return this.portSkpRsnCd;
	}
	
	/**
	 * Column Info
	 * @return plismYdCd
	 */
	public String getPlismYdCd() {
		return this.plismYdCd;
	}
	
	/**
	 * Column Info
	 * @return cgoTtl
	 */
	public String getCgoTtl() {
		return this.cgoTtl;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return uqVslIdNo
	 */
	public String getUqVslIdNo() {
		return this.uqVslIdNo;
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
	 * @return shpCallNoUpdDt
	 */
	public String getShpCallNoUpdDt() {
		return this.shpCallNoUpdDt;
	}
	
	/**
	 * Column Info
	 * @return bfrActFlg
	 */
	public String getBfrActFlg() {
		return this.bfrActFlg;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
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
	 * @return mnvrOutHrs
	 */
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
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
	 * @return firstSkipFlg
	 */
	public String getFirstSkipFlg() {
		return this.firstSkipFlg;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return tmlVoyNo
	 */
	public String getTmlVoyNo() {
		return this.tmlVoyNo;
	}
	
	/**
	 * Column Info
	 * @return shpCallNo
	 */
	public String getShpCallNo() {
		return this.shpCallNo;
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
	 * @return prtChkFlg
	 */
	public String getPrtChkFlg() {
		return this.prtChkFlg;
	}
	
	/**
	 * Column Info
	 * @return tsPortCd
	 */
	public String getTsPortCd() {
		return this.tsPortCd;
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
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return ttlDlayHrs
	 */
	public String getTtlDlayHrs() {
		return this.ttlDlayHrs;
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
	 * @return winRmk
	 */
	public String getWinRmk() {
		return this.winRmk;
	}
	
	/**
	 * Column Info
	 * @return actInpFlg
	 */
	public String getActInpFlg() {
		return this.actInpFlg;
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
	 * @return pfEtbDy
	 */
	public String getPfEtbDy() {
		return this.pfEtbDy;
	}
	
	/**
	 * Column Info
	 * @return ibCgoQty
	 */
	public String getIbCgoQty() {
		return this.ibCgoQty;
	}
	
	/**
	 * Column Info
	 * @return pfEtdDy
	 */
	public String getPfEtdDy() {
		return this.pfEtdDy;
	}
	
	/**
	 * Column Info
	 * @return pfEtaDy
	 */
	public String getPfEtaDy() {
		return this.pfEtaDy;
	}
	

	/**
	 * Column Info
	 * @param ofcInpFlg
	 */
	public void setOfcInpFlg(String ofcInpFlg) {
		this.ofcInpFlg = ofcInpFlg;
	}
	
	/**
	 * Column Info
	 * @param nxtVvd
	 */
	public void setNxtVvd(String nxtVvd) {
		this.nxtVvd = nxtVvd;
	}
	
	/**
	 * Column Info
	 * @param usrInfo
	 */
	public void setUsrInfo(String usrInfo) {
		this.usrInfo = usrInfo;
	}
	
	/**
	 * Column Info
	 * @param plismVoyNo
	 */
	public void setPlismVoyNo(String plismVoyNo) {
		this.plismVoyNo = plismVoyNo;
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
	 * @param extMsgFlg
	 */
	public void setExtMsgFlg(String extMsgFlg) {
		this.extMsgFlg = extMsgFlg;
	}
	
	/**
	 * Column Info
	 * @param noonRptInpFlg
	 */
	public void setNoonRptInpFlg(String noonRptInpFlg) {
		this.noonRptInpFlg = noonRptInpFlg;
	}
	
	/**
	 * Column Info
	 * @param vslDlayRsnDesc
	 */
	public void setVslDlayRsnDesc(String vslDlayRsnDesc) {
		this.vslDlayRsnDesc = vslDlayRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param freeTmDt
	 */
	public void setFreeTmDt(String freeTmDt) {
		this.freeTmDt = freeTmDt;
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
	 * @param initEtaDt
	 */
	public void setInitEtaDt(String initEtaDt) {
		this.initEtaDt = initEtaDt;
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
	 * @param shpCallNoUpdUsrId
	 */
	public void setShpCallNoUpdUsrId(String shpCallNoUpdUsrId) {
		this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param headerSeq
	 */
	public void setHeaderSeq(String headerSeq) {
		this.headerSeq = headerSeq;
	}
	
	/**
	 * Column Info
	 * @param obCgoQty
	 */
	public void setObCgoQty(String obCgoQty) {
		this.obCgoQty = obCgoQty;
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
	 * @param tmlVslCd
	 */
	public void setTmlVslCd(String tmlVslCd) {
		this.tmlVslCd = tmlVslCd;
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
	 * @param ediSndKnt
	 */
	public void setEdiSndKnt(String ediSndKnt) {
		this.ediSndKnt = ediSndKnt;
	}
	
	/**
	 * Column Info
	 * @param portPos
	 */
	public void setPortPos(String portPos) {
		this.portPos = portPos;
	}
	
	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param usdFlg
	 */
	public void setUsdFlg(String usdFlg) {
		this.usdFlg = usdFlg;
	}
	
	/**
	 * Column Info
	 * @param vslDlayRsnLocCd
	 */
	public void setVslDlayRsnLocCd(String vslDlayRsnLocCd) {
		this.vslDlayRsnLocCd = vslDlayRsnLocCd;
	}
	
	/**
	 * Column Info
	 * @param phsIoRsnCd
	 */
	public void setPhsIoRsnCd(String phsIoRsnCd) {
		this.phsIoRsnCd = phsIoRsnCd;
	}
	
	/**
	 * Column Info
	 * @param mphnNo
	 */
	public void setMphnNo(String mphnNo) {
		this.mphnNo = mphnNo;
	}
	
	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param portSkpTpCd
	 */
	public void setPortSkpTpCd(String portSkpTpCd) {
		this.portSkpTpCd = portSkpTpCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param laneGrpNm
	 */
	public void setLaneGrpNm(String laneGrpNm) {
		this.laneGrpNm = laneGrpNm;
	}
	
	/**
	 * Column Info
	 * @param vslDlayRsnCd
	 */
	public void setVslDlayRsnCd(String vslDlayRsnCd) {
		this.vslDlayRsnCd = vslDlayRsnCd;
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
	 * @param plismVslCd
	 */
	public void setPlismVslCd(String plismVslCd) {
		this.plismVslCd = plismVslCd;
	}
	
	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param ftDt
	 */
	public void setFtDt(String ftDt) {
		this.ftDt = ftDt;
	}
	
	/**
	 * Column Info
	 * @param portSkpRsnOffrRmk
	 */
	public void setPortSkpRsnOffrRmk(String portSkpRsnOffrRmk) {
		this.portSkpRsnOffrRmk = portSkpRsnOffrRmk;
	}
	
	/**
	 * Column Info
	 * @param phsIoRmk
	 */
	public void setPhsIoRmk(String phsIoRmk) {
		this.phsIoRmk = phsIoRmk;
	}
	
	/**
	 * Column Info
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param depRptInpFlg
	 */
	public void setDepRptInpFlg(String depRptInpFlg) {
		this.depRptInpFlg = depRptInpFlg;
	}
	
	/**
	 * Column Info
	 * @param updDtTxt
	 */
	public void setUpdDtTxt(String updDtTxt) {
		this.updDtTxt = updDtTxt;
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
	 * @param lnkSpd
	 */
	public void setLnkSpd(String lnkSpd) {
		this.lnkSpd = lnkSpd;
	}
	
	/**
	 * Column Info
	 * @param seaBufHrs
	 */
	public void setSeaBufHrs(String seaBufHrs) {
		this.seaBufHrs = seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @param actWrkHrs
	 */
	public void setActWrkHrs(String actWrkHrs) {
		this.actWrkHrs = actWrkHrs;
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
	 * @param portBufHrs
	 */
	public void setPortBufHrs(String portBufHrs) {
		this.portBufHrs = portBufHrs;
	}
	
	/**
	 * Column Info
	 * @param initSkdInpFlg
	 */
	public void setInitSkdInpFlg(String initSkdInpFlg) {
		this.initSkdInpFlg = initSkdInpFlg;
	}
	
	/**
	 * Column Info
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
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
	 * @param skdBrthNo
	 */
	public void setSkdBrthNo(String skdBrthNo) {
		this.skdBrthNo = skdBrthNo;
	}
	
	/**
	 * Column Info
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param lastSkipFlg
	 */
	public void setLastSkipFlg(String lastSkipFlg) {
		this.lastSkipFlg = lastSkipFlg;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
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
	 * @param portSkpRsnCd
	 */
	public void setPortSkpRsnCd(String portSkpRsnCd) {
		this.portSkpRsnCd = portSkpRsnCd;
	}
	
	/**
	 * Column Info
	 * @param plismYdCd
	 */
	public void setPlismYdCd(String plismYdCd) {
		this.plismYdCd = plismYdCd;
	}
	
	/**
	 * Column Info
	 * @param cgoTtl
	 */
	public void setCgoTtl(String cgoTtl) {
		this.cgoTtl = cgoTtl;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param uqVslIdNo
	 */
	public void setUqVslIdNo(String uqVslIdNo) {
		this.uqVslIdNo = uqVslIdNo;
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
	 * @param shpCallNoUpdDt
	 */
	public void setShpCallNoUpdDt(String shpCallNoUpdDt) {
		this.shpCallNoUpdDt = shpCallNoUpdDt;
	}
	
	/**
	 * Column Info
	 * @param bfrActFlg
	 */
	public void setBfrActFlg(String bfrActFlg) {
		this.bfrActFlg = bfrActFlg;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	 * @param mnvrOutHrs
	 */
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
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
	 * @param firstSkipFlg
	 */
	public void setFirstSkipFlg(String firstSkipFlg) {
		this.firstSkipFlg = firstSkipFlg;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param tmlVoyNo
	 */
	public void setTmlVoyNo(String tmlVoyNo) {
		this.tmlVoyNo = tmlVoyNo;
	}
	
	/**
	 * Column Info
	 * @param shpCallNo
	 */
	public void setShpCallNo(String shpCallNo) {
		this.shpCallNo = shpCallNo;
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
	 * @param prtChkFlg
	 */
	public void setPrtChkFlg(String prtChkFlg) {
		this.prtChkFlg = prtChkFlg;
	}
	
	/**
	 * Column Info
	 * @param tsPortCd
	 */
	public void setTsPortCd(String tsPortCd) {
		this.tsPortCd = tsPortCd;
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
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param ttlDlayHrs
	 */
	public void setTtlDlayHrs(String ttlDlayHrs) {
		this.ttlDlayHrs = ttlDlayHrs;
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
	 * @param winRmk
	 */
	public void setWinRmk(String winRmk) {
		this.winRmk = winRmk;
	}
	
	/**
	 * Column Info
	 * @param actInpFlg
	 */
	public void setActInpFlg(String actInpFlg) {
		this.actInpFlg = actInpFlg;
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
	 * @param pfEtbDy
	 */
	public void setPfEtbDy(String pfEtbDy) {
		this.pfEtbDy = pfEtbDy;
	}
	
	/**
	 * Column Info
	 * @param ibCgoQty
	 */
	public void setIbCgoQty(String ibCgoQty) {
		this.ibCgoQty = ibCgoQty;
	}
	
	/**
	 * Column Info
	 * @param pfEtdDy
	 */
	public void setPfEtdDy(String pfEtdDy) {
		this.pfEtdDy = pfEtdDy;
	}
	
	/**
	 * Column Info
	 * @param pfEtaDy
	 */
	public void setPfEtaDy(String pfEtaDy) {
		this.pfEtaDy = pfEtaDy;
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
		setOfcInpFlg(JSPUtil.getParameter(request, prefix + "ofc_inp_flg", ""));
		setNxtVvd(JSPUtil.getParameter(request, prefix + "nxt_vvd", ""));
		setUsrInfo(JSPUtil.getParameter(request, prefix + "usr_info", ""));
		setPlismVoyNo(JSPUtil.getParameter(request, prefix + "plism_voy_no", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setExtMsgFlg(JSPUtil.getParameter(request, prefix + "ext_msg_flg", ""));
		setNoonRptInpFlg(JSPUtil.getParameter(request, prefix + "noon_rpt_inp_flg", ""));
		setVslDlayRsnDesc(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_desc", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setFreeTmDt(JSPUtil.getParameter(request, prefix + "free_tm_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
		setPrePortCd(JSPUtil.getParameter(request, prefix + "pre_port_cd", ""));
		setShpCallNoUpdUsrId(JSPUtil.getParameter(request, prefix + "shp_call_no_upd_usr_id", ""));
		setLnkDist(JSPUtil.getParameter(request, prefix + "lnk_dist", ""));
		setHeaderSeq(JSPUtil.getParameter(request, prefix + "header_seq", ""));
		setObCgoQty(JSPUtil.getParameter(request, prefix + "ob_cgo_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTmlVslCd(JSPUtil.getParameter(request, prefix + "tml_vsl_cd", ""));
		setNxtEtaDt(JSPUtil.getParameter(request, prefix + "nxt_eta_dt", ""));
		setEdiSndKnt(JSPUtil.getParameter(request, prefix + "edi_snd_knt", ""));
		setPortPos(JSPUtil.getParameter(request, prefix + "port_pos", ""));
		setMaxSeq(JSPUtil.getParameter(request, prefix + "max_seq", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setUsdFlg(JSPUtil.getParameter(request, prefix + "usd_flg", ""));
		setVslDlayRsnLocCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_loc_cd", ""));
		setPhsIoRsnCd(JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", ""));
		setMphnNo(JSPUtil.getParameter(request, prefix + "mphn_no", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
		setPortSkpTpCd(JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setLaneGrpNm(JSPUtil.getParameter(request, prefix + "lane_grp_nm", ""));
		setVslDlayRsnCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setPlismVslCd(JSPUtil.getParameter(request, prefix + "plism_vsl_cd", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", ""));
		setPreEtdDt(JSPUtil.getParameter(request, prefix + "pre_etd_dt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setFtDt(JSPUtil.getParameter(request, prefix + "ft_dt", ""));
		setPortSkpRsnOffrRmk(JSPUtil.getParameter(request, prefix + "port_skp_rsn_offr_rmk", ""));
		setPhsIoRmk(JSPUtil.getParameter(request, prefix + "phs_io_rmk", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setDepRptInpFlg(JSPUtil.getParameter(request, prefix + "dep_rpt_inp_flg", ""));
		setUpdDtTxt(JSPUtil.getParameter(request, prefix + "upd_dt_txt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLnkSpd(JSPUtil.getParameter(request, prefix + "lnk_spd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, prefix + "sea_buf_hrs", ""));
		setActWrkHrs(JSPUtil.getParameter(request, prefix + "act_wrk_hrs", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
		setPortBufHrs(JSPUtil.getParameter(request, prefix + "port_buf_hrs", ""));
		setInitSkdInpFlg(JSPUtil.getParameter(request, prefix + "init_skd_inp_flg", ""));
		setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setSkdBrthNo(JSPUtil.getParameter(request, prefix + "skd_brth_no", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setLastSkipFlg(JSPUtil.getParameter(request, prefix + "last_skip_flg", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setPortSkdStsCd(JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setInitEtbDt(JSPUtil.getParameter(request, prefix + "init_etb_dt", ""));
		setPortSkpRsnCd(JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", ""));
		setPlismYdCd(JSPUtil.getParameter(request, prefix + "plism_yd_cd", ""));
		setCgoTtl(JSPUtil.getParameter(request, prefix + "cgo_ttl", ""));
		setInitEtdDt(JSPUtil.getParameter(request, prefix + "init_etd_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setUqVslIdNo(JSPUtil.getParameter(request, prefix + "uq_vsl_id_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
		setShpCallNoUpdDt(JSPUtil.getParameter(request, prefix + "shp_call_no_upd_dt", ""));
		setBfrActFlg(JSPUtil.getParameter(request, prefix + "bfr_act_flg", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setTurnClptIndSeq(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", ""));
		setVpsRmk(JSPUtil.getParameter(request, prefix + "vps_rmk", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setFirstSkipFlg(JSPUtil.getParameter(request, prefix + "first_skip_flg", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setTmlVoyNo(JSPUtil.getParameter(request, prefix + "tml_voy_no", ""));
		setShpCallNo(JSPUtil.getParameter(request, prefix + "shp_call_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPrtChkFlg(JSPUtil.getParameter(request, prefix + "prt_chk_flg", ""));
		setTsPortCd(JSPUtil.getParameter(request, prefix + "ts_port_cd", ""));
		setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
		setLaneGrp(JSPUtil.getParameter(request, prefix + "lane_grp", ""));
		setTtlDlayHrs(JSPUtil.getParameter(request, prefix + "ttl_dlay_hrs", ""));
		setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
		setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
		setWinRmk(JSPUtil.getParameter(request, prefix + "win_rmk", ""));
		setActInpFlg(JSPUtil.getParameter(request, prefix + "act_inp_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPfEtbDy(JSPUtil.getParameter(request, prefix + "pf_etb_dy", ""));
		setIbCgoQty(JSPUtil.getParameter(request, prefix + "ib_cgo_qty", ""));
		setPfEtdDy(JSPUtil.getParameter(request, prefix + "pf_etd_dy", ""));
		setPfEtaDy(JSPUtil.getParameter(request, prefix + "pf_eta_dy", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstSkdBerthWdoVO[]
	 */
	public CstSkdBerthWdoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstSkdBerthWdoVO[]
	 */
	public CstSkdBerthWdoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstSkdBerthWdoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcInpFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_inp_flg", length));
			String[] nxtVvd = (JSPUtil.getParameter(request, prefix	+ "nxt_vvd", length));
			String[] usrInfo = (JSPUtil.getParameter(request, prefix	+ "usr_info", length));
			String[] plismVoyNo = (JSPUtil.getParameter(request, prefix	+ "plism_voy_no", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] extMsgFlg = (JSPUtil.getParameter(request, prefix	+ "ext_msg_flg", length));
			String[] noonRptInpFlg = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_inp_flg", length));
			String[] vslDlayRsnDesc = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_desc", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] freeTmDt = (JSPUtil.getParameter(request, prefix	+ "free_tm_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] prePortCd = (JSPUtil.getParameter(request, prefix	+ "pre_port_cd", length));
			String[] shpCallNoUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "shp_call_no_upd_usr_id", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] headerSeq = (JSPUtil.getParameter(request, prefix	+ "header_seq", length));
			String[] obCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_cgo_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tmlVslCd = (JSPUtil.getParameter(request, prefix	+ "tml_vsl_cd", length));
			String[] nxtEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_eta_dt", length));
			String[] ediSndKnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_knt", length));
			String[] portPos = (JSPUtil.getParameter(request, prefix	+ "port_pos", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] usdFlg = (JSPUtil.getParameter(request, prefix	+ "usd_flg", length));
			String[] vslDlayRsnLocCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_loc_cd", length));
			String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix	+ "phs_io_rsn_cd", length));
			String[] mphnNo = (JSPUtil.getParameter(request, prefix	+ "mphn_no", length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd", length));
			String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_tp_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] laneGrpNm = (JSPUtil.getParameter(request, prefix	+ "lane_grp_nm", length));
			String[] vslDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_cd", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] plismVslCd = (JSPUtil.getParameter(request, prefix	+ "plism_vsl_cd", length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] preEtdDt = (JSPUtil.getParameter(request, prefix	+ "pre_etd_dt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] ftDt = (JSPUtil.getParameter(request, prefix	+ "ft_dt", length));
			String[] portSkpRsnOffrRmk = (JSPUtil.getParameter(request, prefix	+ "port_skp_rsn_offr_rmk", length));
			String[] phsIoRmk = (JSPUtil.getParameter(request, prefix	+ "phs_io_rmk", length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] depRptInpFlg = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_inp_flg", length));
			String[] updDtTxt = (JSPUtil.getParameter(request, prefix	+ "upd_dt_txt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd", length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs", length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no", length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs", length));
			String[] initSkdInpFlg = (JSPUtil.getParameter(request, prefix	+ "init_skd_inp_flg", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] skdBrthNo = (JSPUtil.getParameter(request, prefix	+ "skd_brth_no", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] lastSkipFlg = (JSPUtil.getParameter(request, prefix	+ "last_skip_flg", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] initEtbDt = (JSPUtil.getParameter(request, prefix	+ "init_etb_dt", length));
			String[] portSkpRsnCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_rsn_cd", length));
			String[] plismYdCd = (JSPUtil.getParameter(request, prefix	+ "plism_yd_cd", length));
			String[] cgoTtl = (JSPUtil.getParameter(request, prefix	+ "cgo_ttl", length));
			String[] initEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] uqVslIdNo = (JSPUtil.getParameter(request, prefix	+ "uq_vsl_id_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] shpCallNoUpdDt = (JSPUtil.getParameter(request, prefix	+ "shp_call_no_upd_dt", length));
			String[] bfrActFlg = (JSPUtil.getParameter(request, prefix	+ "bfr_act_flg", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq", length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] vpsRmk = (JSPUtil.getParameter(request, prefix	+ "vps_rmk", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] firstSkipFlg = (JSPUtil.getParameter(request, prefix	+ "first_skip_flg", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] tmlVoyNo = (JSPUtil.getParameter(request, prefix	+ "tml_voy_no", length));
			String[] shpCallNo = (JSPUtil.getParameter(request, prefix	+ "shp_call_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] prtChkFlg = (JSPUtil.getParameter(request, prefix	+ "prt_chk_flg", length));
			String[] tsPortCd = (JSPUtil.getParameter(request, prefix	+ "ts_port_cd", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] ttlDlayHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_dlay_hrs", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] winRmk = (JSPUtil.getParameter(request, prefix	+ "win_rmk", length));
			String[] actInpFlg = (JSPUtil.getParameter(request, prefix	+ "act_inp_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pfEtbDy = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dy", length));
			String[] ibCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_cgo_qty", length));
			String[] pfEtdDy = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dy", length));
			String[] pfEtaDy = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dy", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstSkdBerthWdoVO();
				if (ofcInpFlg[i] != null)
					model.setOfcInpFlg(ofcInpFlg[i]);
				if (nxtVvd[i] != null)
					model.setNxtVvd(nxtVvd[i]);
				if (usrInfo[i] != null)
					model.setUsrInfo(usrInfo[i]);
				if (plismVoyNo[i] != null)
					model.setPlismVoyNo(plismVoyNo[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (extMsgFlg[i] != null)
					model.setExtMsgFlg(extMsgFlg[i]);
				if (noonRptInpFlg[i] != null)
					model.setNoonRptInpFlg(noonRptInpFlg[i]);
				if (vslDlayRsnDesc[i] != null)
					model.setVslDlayRsnDesc(vslDlayRsnDesc[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (freeTmDt[i] != null)
					model.setFreeTmDt(freeTmDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (initEtaDt[i] != null)
					model.setInitEtaDt(initEtaDt[i]);
				if (prePortCd[i] != null)
					model.setPrePortCd(prePortCd[i]);
				if (shpCallNoUpdUsrId[i] != null)
					model.setShpCallNoUpdUsrId(shpCallNoUpdUsrId[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (headerSeq[i] != null)
					model.setHeaderSeq(headerSeq[i]);
				if (obCgoQty[i] != null)
					model.setObCgoQty(obCgoQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (tmlVslCd[i] != null)
					model.setTmlVslCd(tmlVslCd[i]);
				if (nxtEtaDt[i] != null)
					model.setNxtEtaDt(nxtEtaDt[i]);
				if (ediSndKnt[i] != null)
					model.setEdiSndKnt(ediSndKnt[i]);
				if (portPos[i] != null)
					model.setPortPos(portPos[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (usdFlg[i] != null)
					model.setUsdFlg(usdFlg[i]);
				if (vslDlayRsnLocCd[i] != null)
					model.setVslDlayRsnLocCd(vslDlayRsnLocCd[i]);
				if (phsIoRsnCd[i] != null)
					model.setPhsIoRsnCd(phsIoRsnCd[i]);
				if (mphnNo[i] != null)
					model.setMphnNo(mphnNo[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (portSkpTpCd[i] != null)
					model.setPortSkpTpCd(portSkpTpCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (laneGrpNm[i] != null)
					model.setLaneGrpNm(laneGrpNm[i]);
				if (vslDlayRsnCd[i] != null)
					model.setVslDlayRsnCd(vslDlayRsnCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (plismVslCd[i] != null)
					model.setPlismVslCd(plismVslCd[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (preEtdDt[i] != null)
					model.setPreEtdDt(preEtdDt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (ftDt[i] != null)
					model.setFtDt(ftDt[i]);
				if (portSkpRsnOffrRmk[i] != null)
					model.setPortSkpRsnOffrRmk(portSkpRsnOffrRmk[i]);
				if (phsIoRmk[i] != null)
					model.setPhsIoRmk(phsIoRmk[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (depRptInpFlg[i] != null)
					model.setDepRptInpFlg(depRptInpFlg[i]);
				if (updDtTxt[i] != null)
					model.setUpdDtTxt(updDtTxt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (actWrkHrs[i] != null)
					model.setActWrkHrs(actWrkHrs[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
				if (initSkdInpFlg[i] != null)
					model.setInitSkdInpFlg(initSkdInpFlg[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (skdBrthNo[i] != null)
					model.setSkdBrthNo(skdBrthNo[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (lastSkipFlg[i] != null)
					model.setLastSkipFlg(lastSkipFlg[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (portSkdStsCd[i] != null)
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (initEtbDt[i] != null)
					model.setInitEtbDt(initEtbDt[i]);
				if (portSkpRsnCd[i] != null)
					model.setPortSkpRsnCd(portSkpRsnCd[i]);
				if (plismYdCd[i] != null)
					model.setPlismYdCd(plismYdCd[i]);
				if (cgoTtl[i] != null)
					model.setCgoTtl(cgoTtl[i]);
				if (initEtdDt[i] != null)
					model.setInitEtdDt(initEtdDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (uqVslIdNo[i] != null)
					model.setUqVslIdNo(uqVslIdNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (shpCallNoUpdDt[i] != null)
					model.setShpCallNoUpdDt(shpCallNoUpdDt[i]);
				if (bfrActFlg[i] != null)
					model.setBfrActFlg(bfrActFlg[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (vpsRmk[i] != null)
					model.setVpsRmk(vpsRmk[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (firstSkipFlg[i] != null)
					model.setFirstSkipFlg(firstSkipFlg[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (tmlVoyNo[i] != null)
					model.setTmlVoyNo(tmlVoyNo[i]);
				if (shpCallNo[i] != null)
					model.setShpCallNo(shpCallNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (prtChkFlg[i] != null)
					model.setPrtChkFlg(prtChkFlg[i]);
				if (tsPortCd[i] != null)
					model.setTsPortCd(tsPortCd[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (ttlDlayHrs[i] != null)
					model.setTtlDlayHrs(ttlDlayHrs[i]);
				if (pfEtaDt[i] != null)
					model.setPfEtaDt(pfEtaDt[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (winRmk[i] != null)
					model.setWinRmk(winRmk[i]);
				if (actInpFlg[i] != null)
					model.setActInpFlg(actInpFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pfEtbDy[i] != null)
					model.setPfEtbDy(pfEtbDy[i]);
				if (ibCgoQty[i] != null)
					model.setIbCgoQty(ibCgoQty[i]);
				if (pfEtdDy[i] != null)
					model.setPfEtdDy(pfEtdDy[i]);
				if (pfEtaDy[i] != null)
					model.setPfEtaDy(pfEtaDy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstSkdBerthWdoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstSkdBerthWdoVO[]
	 */
	public CstSkdBerthWdoVO[] getCstSkdBerthWdoVOs(){
		CstSkdBerthWdoVO[] vos = (CstSkdBerthWdoVO[])models.toArray(new CstSkdBerthWdoVO[models.size()]);
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
		this.ofcInpFlg = this.ofcInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtVvd = this.nxtVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrInfo = this.usrInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plismVoyNo = this.plismVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.extMsgFlg = this.extMsgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptInpFlg = this.noonRptInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnDesc = this.vslDlayRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeTmDt = this.freeTmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePortCd = this.prePortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNoUpdUsrId = this.shpCallNoUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headerSeq = this.headerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCgoQty = this.obCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVslCd = this.tmlVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtEtaDt = this.nxtEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndKnt = this.ediSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portPos = this.portPos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdFlg = this.usdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnLocCd = this.vslDlayRsnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRsnCd = this.phsIoRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mphnNo = this.mphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpTpCd = this.portSkpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrpNm = this.laneGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnCd = this.vslDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plismVslCd = this.plismVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEtdDt = this.preEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDt = this.ftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpRsnOffrRmk = this.portSkpRsnOffrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRmk = this.phsIoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptInpFlg = this.depRptInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtTxt = this.updDtTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWrkHrs = this.actWrkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initSkdInpFlg = this.initSkdInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdBrthNo = this.skdBrthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastSkipFlg = this.lastSkipFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDt = this.initEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpRsnCd = this.portSkpRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plismYdCd = this.plismYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTtl = this.cgoTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDt = this.initEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uqVslIdNo = this.uqVslIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNoUpdDt = this.shpCallNoUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrActFlg = this.bfrActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsRmk = this.vpsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstSkipFlg = this.firstSkipFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVoyNo = this.tmlVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNo = this.shpCallNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtChkFlg = this.prtChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortCd = this.tsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDlayHrs = this.ttlDlayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.winRmk = this.winRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpFlg = this.actInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDy = this.pfEtbDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCgoQty = this.ibCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDy = this.pfEtdDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDy = this.pfEtaDy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
