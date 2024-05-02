/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslSkdHisInVO.java
*@FileTitle : VslSkdHisInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.11 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdHisInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdHisInVO> models = new ArrayList<VslSkdHisInVO>();
	
	/* Column Info */
	private String ofcInpFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String plismVoyNo = null;
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String cngSkdVoyNo = null;
	/* Column Info */
	private String initSkdInpFlg = null;
	/* Column Info */
	private String etdDyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String skdBrthNo = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String psdoVvdCd = null;
	/* Column Info */
	private String skdUsdIndCd = null;
	/* Column Info */
	private String skdCngStsDesc = null;
	/* Column Info */
	private String noonRptInpFlg = null;
	/* Column Info */
	private String portSkdStsCd = null;
	/* Column Info */
	private String vslDlayRsnDesc = null;
	/* Column Info */
	private String portSkdStsDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String newClptIndSeq = null;
	/* Column Info */
	private String initEtaDt = null;
	/* Column Info */
	private String shpCallNoUpdUsrId = null;
	/* Column Info */
	private String cngLaneCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String initEtbDt = null;
	/* Column Info */
	private String obCgoQty = null;
	/* Column Info */
	private String dirSeq = null;
	/* Column Info */
	private String portSkpRsnCd = null;
	/* Column Info */
	private String n1stPortBrthDt = null;
	/* Column Info */
	private String plismYdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String tmlVslCd = null;
	/* Column Info */
	private String initEtdDt = null;
	/* Column Info */
	private String ediSndKnt = null;
	/* Column Info */
	private String cngVslCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String shpCallNoUpdDt = null;
	/* Column Info */
	private String cngSkdDirCd = null;
	/* Column Info */
	private String turnClptIndSeq = null;
	/* Column Info */
	private String usdFlg = null;
	/* Column Info */
	private String etbDyCd = null;
	/* Column Info */
	private String vpsRmk = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String vslDlayRsnLocCd = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String phsIoRsnCd = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Column Info */
	private String skdStsCd = null;
	/* Column Info */
	private String portSkpTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String skdRmk = null;
	/* Column Info */
	private String skdVoyTpCd = null;
	/* Column Info */
	private String vslDlayRsnCd = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String tmlVoyNo = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String plismVslCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String shpCallNo = null;
	/* Column Info */
	private String tsPortCd = null;
	/* Column Info */
	private String prtChkFlg = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String ttlDlayHrs = null;
	/* Column Info */
	private String ftDt = null;
	/* Column Info */
	private String portSkpRsnOffrRmk = null;
	/* Column Info */
	private String pfEtaDt = null;
	/* Column Info */
	private String phsIoRmk = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String actInpFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ibCgoQty = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String depRptInpFlg = null;
	/* Column Info */
	private String stPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdHisInVO() {}

	public VslSkdHisInVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vslSlanCd, String skdStsCd, String skdVoyTpCd, String skdUsdIndCd, String pfSkdTpCd, String stPortCd, String n1stPortBrthDt, String psdoVvdCd, String coCd, String skdRmk, String creUsrId, String creDt, String updUsrId, String updDt, String vpsPortCd, String clptIndSeq, String clptSeq, String slanCd, String portSkdStsCd, String portSkdStsDesc, String ydCd, String callYdIndSeq, String pfEtaDt, String pfEtbDt, String pfEtdDt, String initEtaDt, String initEtbDt, String initEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String vslDlayRsnCd, String vslDlayRsnDesc, String vslDlayRsnLocCd, String shpCallNo, String shpCallNoUpdUsrId, String shpCallNoUpdDt, String tmlVslCd, String tmlVoyNo, String ftDt, String plismYdCd, String plismVslCd, String plismVoyNo, String skdCngStsCd, String skdCngStsDesc, String turnPortFlg, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String turnClptIndSeq, String ibCgoQty, String obCgoQty, String vpsRmk, String phsIoRsnCd, String phsIoRmk, String skdBrthNo, String initSkdInpFlg, String ofcInpFlg, String noonRptInpFlg, String depRptInpFlg, String actInpFlg, String prtChkFlg, String ediSndKnt, String portSkpTpCd, String portSkpRsnCd, String portSkpRsnOffrRmk, String ttlDlayHrs, String tsPortCd, String usdFlg, String etbDyCd, String etdDyCd, String pfSvcTpCd, String portRotnSeq, String dirSeq, String usrId, String cngLaneCd, String cngVslCd, String cngSkdVoyNo, String cngSkdDirCd, String newClptIndSeq) {
		this.ofcInpFlg = ofcInpFlg;
		this.vslCd = vslCd;
		this.plismVoyNo = plismVoyNo;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.cngSkdVoyNo = cngSkdVoyNo;
		this.initSkdInpFlg = initSkdInpFlg;
		this.etdDyCd = etdDyCd;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.skdBrthNo = skdBrthNo;
		this.clptSeq = clptSeq;
		this.vpsPortCd = vpsPortCd;
		this.psdoVvdCd = psdoVvdCd;
		this.skdUsdIndCd = skdUsdIndCd;
		this.skdCngStsDesc = skdCngStsDesc;
		this.noonRptInpFlg = noonRptInpFlg;
		this.portSkdStsCd = portSkdStsCd;
		this.vslDlayRsnDesc = vslDlayRsnDesc;
		this.portSkdStsDesc = portSkdStsDesc;
		this.updUsrId = updUsrId;
		this.newClptIndSeq = newClptIndSeq;
		this.initEtaDt = initEtaDt;
		this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
		this.cngLaneCd = cngLaneCd;
		this.vpsEtdDt = vpsEtdDt;
		this.initEtbDt = initEtbDt;
		this.obCgoQty = obCgoQty;
		this.dirSeq = dirSeq;
		this.portSkpRsnCd = portSkpRsnCd;
		this.n1stPortBrthDt = n1stPortBrthDt;
		this.plismYdCd = plismYdCd;
		this.skdVoyNo = skdVoyNo;
		this.tmlVslCd = tmlVslCd;
		this.initEtdDt = initEtdDt;
		this.ediSndKnt = ediSndKnt;
		this.cngVslCd = cngVslCd;
		this.creUsrId = creUsrId;
		this.skdCngStsCd = skdCngStsCd;
		this.shpCallNoUpdDt = shpCallNoUpdDt;
		this.cngSkdDirCd = cngSkdDirCd;
		this.turnClptIndSeq = turnClptIndSeq;
		this.usdFlg = usdFlg;
		this.etbDyCd = etbDyCd;
		this.vpsRmk = vpsRmk;
		this.vpsEtbDt = vpsEtbDt;
		this.vslDlayRsnLocCd = vslDlayRsnLocCd;
		this.turnPortFlg = turnPortFlg;
		this.creDt = creDt;
		this.phsIoRsnCd = phsIoRsnCd;
		this.pfSkdTpCd = pfSkdTpCd;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.turnSkdDirCd = turnSkdDirCd;
		this.skdStsCd = skdStsCd;
		this.portSkpTpCd = portSkpTpCd;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.usrId = usrId;
		this.skdRmk = skdRmk;
		this.skdVoyTpCd = skdVoyTpCd;
		this.vslDlayRsnCd = vslDlayRsnCd;
		this.portRotnSeq = portRotnSeq;
		this.tmlVoyNo = tmlVoyNo;
		this.callYdIndSeq = callYdIndSeq;
		this.plismVslCd = plismVslCd;
		this.updDt = updDt;
		this.shpCallNo = shpCallNo;
		this.tsPortCd = tsPortCd;
		this.prtChkFlg = prtChkFlg;
		this.coCd = coCd;
		this.pfEtdDt = pfEtdDt;
		this.ttlDlayHrs = ttlDlayHrs;
		this.ftDt = ftDt;
		this.portSkpRsnOffrRmk = portSkpRsnOffrRmk;
		this.pfEtaDt = pfEtaDt;
		this.phsIoRmk = phsIoRmk;
		this.pfEtbDt = pfEtbDt;
		this.actInpFlg = actInpFlg;
		this.skdDirCd = skdDirCd;
		this.slanCd = slanCd;
		this.ibCgoQty = ibCgoQty;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.depRptInpFlg = depRptInpFlg;
		this.stPortCd = stPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_inp_flg", getOfcInpFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("plism_voy_no", getPlismVoyNo());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("cng_skd_voy_no", getCngSkdVoyNo());
		this.hashColumns.put("init_skd_inp_flg", getInitSkdInpFlg());
		this.hashColumns.put("etd_dy_cd", getEtdDyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("skd_brth_no", getSkdBrthNo());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("psdo_vvd_cd", getPsdoVvdCd());
		this.hashColumns.put("skd_usd_ind_cd", getSkdUsdIndCd());
		this.hashColumns.put("skd_cng_sts_desc", getSkdCngStsDesc());
		this.hashColumns.put("noon_rpt_inp_flg", getNoonRptInpFlg());
		this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
		this.hashColumns.put("vsl_dlay_rsn_desc", getVslDlayRsnDesc());
		this.hashColumns.put("port_skd_sts_desc", getPortSkdStsDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("new_clpt_ind_seq", getNewClptIndSeq());
		this.hashColumns.put("init_eta_dt", getInitEtaDt());
		this.hashColumns.put("shp_call_no_upd_usr_id", getShpCallNoUpdUsrId());
		this.hashColumns.put("cng_lane_cd", getCngLaneCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("init_etb_dt", getInitEtbDt());
		this.hashColumns.put("ob_cgo_qty", getObCgoQty());
		this.hashColumns.put("dir_seq", getDirSeq());
		this.hashColumns.put("port_skp_rsn_cd", getPortSkpRsnCd());
		this.hashColumns.put("n1st_port_brth_dt", getN1stPortBrthDt());
		this.hashColumns.put("plism_yd_cd", getPlismYdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("tml_vsl_cd", getTmlVslCd());
		this.hashColumns.put("init_etd_dt", getInitEtdDt());
		this.hashColumns.put("edi_snd_knt", getEdiSndKnt());
		this.hashColumns.put("cng_vsl_cd", getCngVslCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("shp_call_no_upd_dt", getShpCallNoUpdDt());
		this.hashColumns.put("cng_skd_dir_cd", getCngSkdDirCd());
		this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
		this.hashColumns.put("usd_flg", getUsdFlg());
		this.hashColumns.put("etb_dy_cd", getEtbDyCd());
		this.hashColumns.put("vps_rmk", getVpsRmk());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("vsl_dlay_rsn_loc_cd", getVslDlayRsnLocCd());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("skd_sts_cd", getSkdStsCd());
		this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("skd_rmk", getSkdRmk());
		this.hashColumns.put("skd_voy_tp_cd", getSkdVoyTpCd());
		this.hashColumns.put("vsl_dlay_rsn_cd", getVslDlayRsnCd());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("tml_voy_no", getTmlVoyNo());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("plism_vsl_cd", getPlismVslCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("shp_call_no", getShpCallNo());
		this.hashColumns.put("ts_port_cd", getTsPortCd());
		this.hashColumns.put("prt_chk_flg", getPrtChkFlg());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("ttl_dlay_hrs", getTtlDlayHrs());
		this.hashColumns.put("ft_dt", getFtDt());
		this.hashColumns.put("port_skp_rsn_offr_rmk", getPortSkpRsnOffrRmk());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("phs_io_rmk", getPhsIoRmk());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("act_inp_flg", getActInpFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ib_cgo_qty", getIbCgoQty());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("dep_rpt_inp_flg", getDepRptInpFlg());
		this.hashColumns.put("st_port_cd", getStPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_inp_flg", "ofcInpFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("plism_voy_no", "plismVoyNo");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("cng_skd_voy_no", "cngSkdVoyNo");
		this.hashFields.put("init_skd_inp_flg", "initSkdInpFlg");
		this.hashFields.put("etd_dy_cd", "etdDyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("skd_brth_no", "skdBrthNo");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("psdo_vvd_cd", "psdoVvdCd");
		this.hashFields.put("skd_usd_ind_cd", "skdUsdIndCd");
		this.hashFields.put("skd_cng_sts_desc", "skdCngStsDesc");
		this.hashFields.put("noon_rpt_inp_flg", "noonRptInpFlg");
		this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
		this.hashFields.put("vsl_dlay_rsn_desc", "vslDlayRsnDesc");
		this.hashFields.put("port_skd_sts_desc", "portSkdStsDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("new_clpt_ind_seq", "newClptIndSeq");
		this.hashFields.put("init_eta_dt", "initEtaDt");
		this.hashFields.put("shp_call_no_upd_usr_id", "shpCallNoUpdUsrId");
		this.hashFields.put("cng_lane_cd", "cngLaneCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("init_etb_dt", "initEtbDt");
		this.hashFields.put("ob_cgo_qty", "obCgoQty");
		this.hashFields.put("dir_seq", "dirSeq");
		this.hashFields.put("port_skp_rsn_cd", "portSkpRsnCd");
		this.hashFields.put("n1st_port_brth_dt", "n1stPortBrthDt");
		this.hashFields.put("plism_yd_cd", "plismYdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("tml_vsl_cd", "tmlVslCd");
		this.hashFields.put("init_etd_dt", "initEtdDt");
		this.hashFields.put("edi_snd_knt", "ediSndKnt");
		this.hashFields.put("cng_vsl_cd", "cngVslCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("shp_call_no_upd_dt", "shpCallNoUpdDt");
		this.hashFields.put("cng_skd_dir_cd", "cngSkdDirCd");
		this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
		this.hashFields.put("usd_flg", "usdFlg");
		this.hashFields.put("etb_dy_cd", "etbDyCd");
		this.hashFields.put("vps_rmk", "vpsRmk");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("vsl_dlay_rsn_loc_cd", "vslDlayRsnLocCd");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("skd_sts_cd", "skdStsCd");
		this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("skd_rmk", "skdRmk");
		this.hashFields.put("skd_voy_tp_cd", "skdVoyTpCd");
		this.hashFields.put("vsl_dlay_rsn_cd", "vslDlayRsnCd");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("tml_voy_no", "tmlVoyNo");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("plism_vsl_cd", "plismVslCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("shp_call_no", "shpCallNo");
		this.hashFields.put("ts_port_cd", "tsPortCd");
		this.hashFields.put("prt_chk_flg", "prtChkFlg");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("ttl_dlay_hrs", "ttlDlayHrs");
		this.hashFields.put("ft_dt", "ftDt");
		this.hashFields.put("port_skp_rsn_offr_rmk", "portSkpRsnOffrRmk");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("phs_io_rmk", "phsIoRmk");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("act_inp_flg", "actInpFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ib_cgo_qty", "ibCgoQty");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("dep_rpt_inp_flg", "depRptInpFlg");
		this.hashFields.put("st_port_cd", "stPortCd");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return turnSkdVoyNo
	 */
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cngSkdVoyNo
	 */
	public String getCngSkdVoyNo() {
		return this.cngSkdVoyNo;
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
	 * @return etdDyCd
	 */
	public String getEtdDyCd() {
		return this.etdDyCd;
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
	 * @return psdoVvdCd
	 */
	public String getPsdoVvdCd() {
		return this.psdoVvdCd;
	}
	
	/**
	 * Column Info
	 * @return skdUsdIndCd
	 */
	public String getSkdUsdIndCd() {
		return this.skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @return skdCngStsDesc
	 */
	public String getSkdCngStsDesc() {
		return this.skdCngStsDesc;
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
	 * @return portSkdStsCd
	 */
	public String getPortSkdStsCd() {
		return this.portSkdStsCd;
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
	 * @return portSkdStsDesc
	 */
	public String getPortSkdStsDesc() {
		return this.portSkdStsDesc;
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
	 * @return newClptIndSeq
	 */
	public String getNewClptIndSeq() {
		return this.newClptIndSeq;
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
	 * @return shpCallNoUpdUsrId
	 */
	public String getShpCallNoUpdUsrId() {
		return this.shpCallNoUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return cngLaneCd
	 */
	public String getCngLaneCd() {
		return this.cngLaneCd;
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
	 * @return obCgoQty
	 */
	public String getObCgoQty() {
		return this.obCgoQty;
	}
	
	/**
	 * Column Info
	 * @return dirSeq
	 */
	public String getDirSeq() {
		return this.dirSeq;
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
	 * @return n1stPortBrthDt
	 */
	public String getN1stPortBrthDt() {
		return this.n1stPortBrthDt;
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
	 * @return initEtdDt
	 */
	public String getInitEtdDt() {
		return this.initEtdDt;
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
	 * @return cngVslCd
	 */
	public String getCngVslCd() {
		return this.cngVslCd;
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
	 * @return cngSkdDirCd
	 */
	public String getCngSkdDirCd() {
		return this.cngSkdDirCd;
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
	 * @return usdFlg
	 */
	public String getUsdFlg() {
		return this.usdFlg;
	}
	
	/**
	 * Column Info
	 * @return etbDyCd
	 */
	public String getEtbDyCd() {
		return this.etbDyCd;
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
	 * @return vslDlayRsnLocCd
	 */
	public String getVslDlayRsnLocCd() {
		return this.vslDlayRsnLocCd;
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
	 * @return phsIoRsnCd
	 */
	public String getPhsIoRsnCd() {
		return this.phsIoRsnCd;
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
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
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
	 * @return portSkpTpCd
	 */
	public String getPortSkpTpCd() {
		return this.portSkpTpCd;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
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
	 * @return skdRmk
	 */
	public String getSkdRmk() {
		return this.skdRmk;
	}
	
	/**
	 * Column Info
	 * @return skdVoyTpCd
	 */
	public String getSkdVoyTpCd() {
		return this.skdVoyTpCd;
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
	 * @return portRotnSeq
	 */
	public String getPortRotnSeq() {
		return this.portRotnSeq;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return tsPortCd
	 */
	public String getTsPortCd() {
		return this.tsPortCd;
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
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
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
	 * @return ttlDlayHrs
	 */
	public String getTtlDlayHrs() {
		return this.ttlDlayHrs;
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
	 * @return pfEtaDt
	 */
	public String getPfEtaDt() {
		return this.pfEtaDt;
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
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cngSkdVoyNo
	 */
	public void setCngSkdVoyNo(String cngSkdVoyNo) {
		this.cngSkdVoyNo = cngSkdVoyNo;
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
	 * @param etdDyCd
	 */
	public void setEtdDyCd(String etdDyCd) {
		this.etdDyCd = etdDyCd;
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
	 * @param psdoVvdCd
	 */
	public void setPsdoVvdCd(String psdoVvdCd) {
		this.psdoVvdCd = psdoVvdCd;
	}
	
	/**
	 * Column Info
	 * @param skdUsdIndCd
	 */
	public void setSkdUsdIndCd(String skdUsdIndCd) {
		this.skdUsdIndCd = skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @param skdCngStsDesc
	 */
	public void setSkdCngStsDesc(String skdCngStsDesc) {
		this.skdCngStsDesc = skdCngStsDesc;
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
	 * @param portSkdStsCd
	 */
	public void setPortSkdStsCd(String portSkdStsCd) {
		this.portSkdStsCd = portSkdStsCd;
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
	 * @param portSkdStsDesc
	 */
	public void setPortSkdStsDesc(String portSkdStsDesc) {
		this.portSkdStsDesc = portSkdStsDesc;
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
	 * @param newClptIndSeq
	 */
	public void setNewClptIndSeq(String newClptIndSeq) {
		this.newClptIndSeq = newClptIndSeq;
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
	 * @param shpCallNoUpdUsrId
	 */
	public void setShpCallNoUpdUsrId(String shpCallNoUpdUsrId) {
		this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param cngLaneCd
	 */
	public void setCngLaneCd(String cngLaneCd) {
		this.cngLaneCd = cngLaneCd;
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
	 * @param obCgoQty
	 */
	public void setObCgoQty(String obCgoQty) {
		this.obCgoQty = obCgoQty;
	}
	
	/**
	 * Column Info
	 * @param dirSeq
	 */
	public void setDirSeq(String dirSeq) {
		this.dirSeq = dirSeq;
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
	 * @param n1stPortBrthDt
	 */
	public void setN1stPortBrthDt(String n1stPortBrthDt) {
		this.n1stPortBrthDt = n1stPortBrthDt;
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
	 * @param initEtdDt
	 */
	public void setInitEtdDt(String initEtdDt) {
		this.initEtdDt = initEtdDt;
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
	 * @param cngVslCd
	 */
	public void setCngVslCd(String cngVslCd) {
		this.cngVslCd = cngVslCd;
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
	 * @param cngSkdDirCd
	 */
	public void setCngSkdDirCd(String cngSkdDirCd) {
		this.cngSkdDirCd = cngSkdDirCd;
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
	 * @param usdFlg
	 */
	public void setUsdFlg(String usdFlg) {
		this.usdFlg = usdFlg;
	}
	
	/**
	 * Column Info
	 * @param etbDyCd
	 */
	public void setEtbDyCd(String etbDyCd) {
		this.etbDyCd = etbDyCd;
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
	 * @param vslDlayRsnLocCd
	 */
	public void setVslDlayRsnLocCd(String vslDlayRsnLocCd) {
		this.vslDlayRsnLocCd = vslDlayRsnLocCd;
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
	 * @param phsIoRsnCd
	 */
	public void setPhsIoRsnCd(String phsIoRsnCd) {
		this.phsIoRsnCd = phsIoRsnCd;
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
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
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
	 * @param portSkpTpCd
	 */
	public void setPortSkpTpCd(String portSkpTpCd) {
		this.portSkpTpCd = portSkpTpCd;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
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
	 * @param skdRmk
	 */
	public void setSkdRmk(String skdRmk) {
		this.skdRmk = skdRmk;
	}
	
	/**
	 * Column Info
	 * @param skdVoyTpCd
	 */
	public void setSkdVoyTpCd(String skdVoyTpCd) {
		this.skdVoyTpCd = skdVoyTpCd;
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
	 * @param portRotnSeq
	 */
	public void setPortRotnSeq(String portRotnSeq) {
		this.portRotnSeq = portRotnSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param tsPortCd
	 */
	public void setTsPortCd(String tsPortCd) {
		this.tsPortCd = tsPortCd;
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
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
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
	 * @param ttlDlayHrs
	 */
	public void setTtlDlayHrs(String ttlDlayHrs) {
		this.ttlDlayHrs = ttlDlayHrs;
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
	 * @param pfEtaDt
	 */
	public void setPfEtaDt(String pfEtaDt) {
		this.pfEtaDt = pfEtaDt;
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
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcInpFlg(JSPUtil.getParameter(request, "ofc_inp_flg", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPlismVoyNo(JSPUtil.getParameter(request, "plism_voy_no", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, "turn_skd_voy_no", ""));
		setCngSkdVoyNo(JSPUtil.getParameter(request, "cng_skd_voy_no", ""));
		setInitSkdInpFlg(JSPUtil.getParameter(request, "init_skd_inp_flg", ""));
		setEtdDyCd(JSPUtil.getParameter(request, "etd_dy_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setSkdBrthNo(JSPUtil.getParameter(request, "skd_brth_no", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setPsdoVvdCd(JSPUtil.getParameter(request, "psdo_vvd_cd", ""));
		setSkdUsdIndCd(JSPUtil.getParameter(request, "skd_usd_ind_cd", ""));
		setSkdCngStsDesc(JSPUtil.getParameter(request, "skd_cng_sts_desc", ""));
		setNoonRptInpFlg(JSPUtil.getParameter(request, "noon_rpt_inp_flg", ""));
		setPortSkdStsCd(JSPUtil.getParameter(request, "port_skd_sts_cd", ""));
		setVslDlayRsnDesc(JSPUtil.getParameter(request, "vsl_dlay_rsn_desc", ""));
		setPortSkdStsDesc(JSPUtil.getParameter(request, "port_skd_sts_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setNewClptIndSeq(JSPUtil.getParameter(request, "new_clpt_ind_seq", ""));
		setInitEtaDt(JSPUtil.getParameter(request, "init_eta_dt", ""));
		setShpCallNoUpdUsrId(JSPUtil.getParameter(request, "shp_call_no_upd_usr_id", ""));
		setCngLaneCd(JSPUtil.getParameter(request, "cng_lane_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setInitEtbDt(JSPUtil.getParameter(request, "init_etb_dt", ""));
		setObCgoQty(JSPUtil.getParameter(request, "ob_cgo_qty", ""));
		setDirSeq(JSPUtil.getParameter(request, "dir_seq", ""));
		setPortSkpRsnCd(JSPUtil.getParameter(request, "port_skp_rsn_cd", ""));
		setN1stPortBrthDt(JSPUtil.getParameter(request, "n1st_port_brth_dt", ""));
		setPlismYdCd(JSPUtil.getParameter(request, "plism_yd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setTmlVslCd(JSPUtil.getParameter(request, "tml_vsl_cd", ""));
		setInitEtdDt(JSPUtil.getParameter(request, "init_etd_dt", ""));
		setEdiSndKnt(JSPUtil.getParameter(request, "edi_snd_knt", ""));
		setCngVslCd(JSPUtil.getParameter(request, "cng_vsl_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, "skd_cng_sts_cd", ""));
		setShpCallNoUpdDt(JSPUtil.getParameter(request, "shp_call_no_upd_dt", ""));
		setCngSkdDirCd(JSPUtil.getParameter(request, "cng_skd_dir_cd", ""));
		setTurnClptIndSeq(JSPUtil.getParameter(request, "turn_clpt_ind_seq", ""));
		setUsdFlg(JSPUtil.getParameter(request, "usd_flg", ""));
		setEtbDyCd(JSPUtil.getParameter(request, "etb_dy_cd", ""));
		setVpsRmk(JSPUtil.getParameter(request, "vps_rmk", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setVslDlayRsnLocCd(JSPUtil.getParameter(request, "vsl_dlay_rsn_loc_cd", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPhsIoRsnCd(JSPUtil.getParameter(request, "phs_io_rsn_cd", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, "pf_skd_tp_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, "turn_skd_dir_cd", ""));
		setSkdStsCd(JSPUtil.getParameter(request, "skd_sts_cd", ""));
		setPortSkpTpCd(JSPUtil.getParameter(request, "port_skp_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setSkdRmk(JSPUtil.getParameter(request, "skd_rmk", ""));
		setSkdVoyTpCd(JSPUtil.getParameter(request, "skd_voy_tp_cd", ""));
		setVslDlayRsnCd(JSPUtil.getParameter(request, "vsl_dlay_rsn_cd", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		setTmlVoyNo(JSPUtil.getParameter(request, "tml_voy_no", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, "call_yd_ind_seq", ""));
		setPlismVslCd(JSPUtil.getParameter(request, "plism_vsl_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setShpCallNo(JSPUtil.getParameter(request, "shp_call_no", ""));
		setTsPortCd(JSPUtil.getParameter(request, "ts_port_cd", ""));
		setPrtChkFlg(JSPUtil.getParameter(request, "prt_chk_flg", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setPfEtdDt(JSPUtil.getParameter(request, "pf_etd_dt", ""));
		setTtlDlayHrs(JSPUtil.getParameter(request, "ttl_dlay_hrs", ""));
		setFtDt(JSPUtil.getParameter(request, "ft_dt", ""));
		setPortSkpRsnOffrRmk(JSPUtil.getParameter(request, "port_skp_rsn_offr_rmk", ""));
		setPfEtaDt(JSPUtil.getParameter(request, "pf_eta_dt", ""));
		setPhsIoRmk(JSPUtil.getParameter(request, "phs_io_rmk", ""));
		setPfEtbDt(JSPUtil.getParameter(request, "pf_etb_dt", ""));
		setActInpFlg(JSPUtil.getParameter(request, "act_inp_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setIbCgoQty(JSPUtil.getParameter(request, "ib_cgo_qty", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setDepRptInpFlg(JSPUtil.getParameter(request, "dep_rpt_inp_flg", ""));
		setStPortCd(JSPUtil.getParameter(request, "st_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdHisInVO[]
	 */
	public VslSkdHisInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdHisInVO[]
	 */
	public VslSkdHisInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdHisInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcInpFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_inp_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] plismVoyNo = (JSPUtil.getParameter(request, prefix	+ "plism_voy_no", length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no", length));
			String[] cngSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "cng_skd_voy_no", length));
			String[] initSkdInpFlg = (JSPUtil.getParameter(request, prefix	+ "init_skd_inp_flg", length));
			String[] etdDyCd = (JSPUtil.getParameter(request, prefix	+ "etd_dy_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] skdBrthNo = (JSPUtil.getParameter(request, prefix	+ "skd_brth_no", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] psdoVvdCd = (JSPUtil.getParameter(request, prefix	+ "psdo_vvd_cd", length));
			String[] skdUsdIndCd = (JSPUtil.getParameter(request, prefix	+ "skd_usd_ind_cd", length));
			String[] skdCngStsDesc = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_desc", length));
			String[] noonRptInpFlg = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_inp_flg", length));
			String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_cd", length));
			String[] vslDlayRsnDesc = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_desc", length));
			String[] portSkdStsDesc = (JSPUtil.getParameter(request, prefix	+ "port_skd_sts_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] newClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "new_clpt_ind_seq", length));
			String[] initEtaDt = (JSPUtil.getParameter(request, prefix	+ "init_eta_dt", length));
			String[] shpCallNoUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "shp_call_no_upd_usr_id", length));
			String[] cngLaneCd = (JSPUtil.getParameter(request, prefix	+ "cng_lane_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] initEtbDt = (JSPUtil.getParameter(request, prefix	+ "init_etb_dt", length));
			String[] obCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_cgo_qty", length));
			String[] dirSeq = (JSPUtil.getParameter(request, prefix	+ "dir_seq", length));
			String[] portSkpRsnCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_rsn_cd", length));
			String[] n1stPortBrthDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_brth_dt", length));
			String[] plismYdCd = (JSPUtil.getParameter(request, prefix	+ "plism_yd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tmlVslCd = (JSPUtil.getParameter(request, prefix	+ "tml_vsl_cd", length));
			String[] initEtdDt = (JSPUtil.getParameter(request, prefix	+ "init_etd_dt", length));
			String[] ediSndKnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_knt", length));
			String[] cngVslCd = (JSPUtil.getParameter(request, prefix	+ "cng_vsl_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd", length));
			String[] shpCallNoUpdDt = (JSPUtil.getParameter(request, prefix	+ "shp_call_no_upd_dt", length));
			String[] cngSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "cng_skd_dir_cd", length));
			String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "turn_clpt_ind_seq", length));
			String[] usdFlg = (JSPUtil.getParameter(request, prefix	+ "usd_flg", length));
			String[] etbDyCd = (JSPUtil.getParameter(request, prefix	+ "etb_dy_cd", length));
			String[] vpsRmk = (JSPUtil.getParameter(request, prefix	+ "vps_rmk", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] vslDlayRsnLocCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_loc_cd", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix	+ "phs_io_rsn_cd", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd", length));
			String[] skdStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_sts_cd", length));
			String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] skdRmk = (JSPUtil.getParameter(request, prefix	+ "skd_rmk", length));
			String[] skdVoyTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_voy_tp_cd", length));
			String[] vslDlayRsnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dlay_rsn_cd", length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq", length));
			String[] tmlVoyNo = (JSPUtil.getParameter(request, prefix	+ "tml_voy_no", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] plismVslCd = (JSPUtil.getParameter(request, prefix	+ "plism_vsl_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] shpCallNo = (JSPUtil.getParameter(request, prefix	+ "shp_call_no", length));
			String[] tsPortCd = (JSPUtil.getParameter(request, prefix	+ "ts_port_cd", length));
			String[] prtChkFlg = (JSPUtil.getParameter(request, prefix	+ "prt_chk_flg", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] ttlDlayHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_dlay_hrs", length));
			String[] ftDt = (JSPUtil.getParameter(request, prefix	+ "ft_dt", length));
			String[] portSkpRsnOffrRmk = (JSPUtil.getParameter(request, prefix	+ "port_skp_rsn_offr_rmk", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] phsIoRmk = (JSPUtil.getParameter(request, prefix	+ "phs_io_rmk", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] actInpFlg = (JSPUtil.getParameter(request, prefix	+ "act_inp_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ibCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_cgo_qty", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] depRptInpFlg = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_inp_flg", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdHisInVO();
				if (ofcInpFlg[i] != null)
					model.setOfcInpFlg(ofcInpFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (plismVoyNo[i] != null)
					model.setPlismVoyNo(plismVoyNo[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (cngSkdVoyNo[i] != null)
					model.setCngSkdVoyNo(cngSkdVoyNo[i]);
				if (initSkdInpFlg[i] != null)
					model.setInitSkdInpFlg(initSkdInpFlg[i]);
				if (etdDyCd[i] != null)
					model.setEtdDyCd(etdDyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (skdBrthNo[i] != null)
					model.setSkdBrthNo(skdBrthNo[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (psdoVvdCd[i] != null)
					model.setPsdoVvdCd(psdoVvdCd[i]);
				if (skdUsdIndCd[i] != null)
					model.setSkdUsdIndCd(skdUsdIndCd[i]);
				if (skdCngStsDesc[i] != null)
					model.setSkdCngStsDesc(skdCngStsDesc[i]);
				if (noonRptInpFlg[i] != null)
					model.setNoonRptInpFlg(noonRptInpFlg[i]);
				if (portSkdStsCd[i] != null)
					model.setPortSkdStsCd(portSkdStsCd[i]);
				if (vslDlayRsnDesc[i] != null)
					model.setVslDlayRsnDesc(vslDlayRsnDesc[i]);
				if (portSkdStsDesc[i] != null)
					model.setPortSkdStsDesc(portSkdStsDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (newClptIndSeq[i] != null)
					model.setNewClptIndSeq(newClptIndSeq[i]);
				if (initEtaDt[i] != null)
					model.setInitEtaDt(initEtaDt[i]);
				if (shpCallNoUpdUsrId[i] != null)
					model.setShpCallNoUpdUsrId(shpCallNoUpdUsrId[i]);
				if (cngLaneCd[i] != null)
					model.setCngLaneCd(cngLaneCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (initEtbDt[i] != null)
					model.setInitEtbDt(initEtbDt[i]);
				if (obCgoQty[i] != null)
					model.setObCgoQty(obCgoQty[i]);
				if (dirSeq[i] != null)
					model.setDirSeq(dirSeq[i]);
				if (portSkpRsnCd[i] != null)
					model.setPortSkpRsnCd(portSkpRsnCd[i]);
				if (n1stPortBrthDt[i] != null)
					model.setN1stPortBrthDt(n1stPortBrthDt[i]);
				if (plismYdCd[i] != null)
					model.setPlismYdCd(plismYdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (tmlVslCd[i] != null)
					model.setTmlVslCd(tmlVslCd[i]);
				if (initEtdDt[i] != null)
					model.setInitEtdDt(initEtdDt[i]);
				if (ediSndKnt[i] != null)
					model.setEdiSndKnt(ediSndKnt[i]);
				if (cngVslCd[i] != null)
					model.setCngVslCd(cngVslCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (skdCngStsCd[i] != null)
					model.setSkdCngStsCd(skdCngStsCd[i]);
				if (shpCallNoUpdDt[i] != null)
					model.setShpCallNoUpdDt(shpCallNoUpdDt[i]);
				if (cngSkdDirCd[i] != null)
					model.setCngSkdDirCd(cngSkdDirCd[i]);
				if (turnClptIndSeq[i] != null)
					model.setTurnClptIndSeq(turnClptIndSeq[i]);
				if (usdFlg[i] != null)
					model.setUsdFlg(usdFlg[i]);
				if (etbDyCd[i] != null)
					model.setEtbDyCd(etbDyCd[i]);
				if (vpsRmk[i] != null)
					model.setVpsRmk(vpsRmk[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (vslDlayRsnLocCd[i] != null)
					model.setVslDlayRsnLocCd(vslDlayRsnLocCd[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (phsIoRsnCd[i] != null)
					model.setPhsIoRsnCd(phsIoRsnCd[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (skdStsCd[i] != null)
					model.setSkdStsCd(skdStsCd[i]);
				if (portSkpTpCd[i] != null)
					model.setPortSkpTpCd(portSkpTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (skdRmk[i] != null)
					model.setSkdRmk(skdRmk[i]);
				if (skdVoyTpCd[i] != null)
					model.setSkdVoyTpCd(skdVoyTpCd[i]);
				if (vslDlayRsnCd[i] != null)
					model.setVslDlayRsnCd(vslDlayRsnCd[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				if (tmlVoyNo[i] != null)
					model.setTmlVoyNo(tmlVoyNo[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (plismVslCd[i] != null)
					model.setPlismVslCd(plismVslCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (shpCallNo[i] != null)
					model.setShpCallNo(shpCallNo[i]);
				if (tsPortCd[i] != null)
					model.setTsPortCd(tsPortCd[i]);
				if (prtChkFlg[i] != null)
					model.setPrtChkFlg(prtChkFlg[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (ttlDlayHrs[i] != null)
					model.setTtlDlayHrs(ttlDlayHrs[i]);
				if (ftDt[i] != null)
					model.setFtDt(ftDt[i]);
				if (portSkpRsnOffrRmk[i] != null)
					model.setPortSkpRsnOffrRmk(portSkpRsnOffrRmk[i]);
				if (pfEtaDt[i] != null)
					model.setPfEtaDt(pfEtaDt[i]);
				if (phsIoRmk[i] != null)
					model.setPhsIoRmk(phsIoRmk[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (actInpFlg[i] != null)
					model.setActInpFlg(actInpFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ibCgoQty[i] != null)
					model.setIbCgoQty(ibCgoQty[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (depRptInpFlg[i] != null)
					model.setDepRptInpFlg(depRptInpFlg[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdHisInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdHisInVO[]
	 */
	public VslSkdHisInVO[] getVslSkdHisInVOs(){
		VslSkdHisInVO[] vos = (VslSkdHisInVO[])models.toArray(new VslSkdHisInVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plismVoyNo = this.plismVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngSkdVoyNo = this.cngSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initSkdInpFlg = this.initSkdInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyCd = this.etdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdBrthNo = this.skdBrthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psdoVvdCd = this.psdoVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUsdIndCd = this.skdUsdIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsDesc = this.skdCngStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptInpFlg = this.noonRptInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsCd = this.portSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnDesc = this.vslDlayRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkdStsDesc = this.portSkdStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newClptIndSeq = this.newClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtaDt = this.initEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNoUpdUsrId = this.shpCallNoUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngLaneCd = this.cngLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDt = this.initEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCgoQty = this.obCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirSeq = this.dirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpRsnCd = this.portSkpRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortBrthDt = this.n1stPortBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plismYdCd = this.plismYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVslCd = this.tmlVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDt = this.initEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndKnt = this.ediSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngVslCd = this.cngVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNoUpdDt = this.shpCallNoUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngSkdDirCd = this.cngSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnClptIndSeq = this.turnClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdFlg = this.usdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyCd = this.etbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsRmk = this.vpsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnLocCd = this.vslDlayRsnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRsnCd = this.phsIoRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsCd = this.skdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpTpCd = this.portSkpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRmk = this.skdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyTpCd = this.skdVoyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDlayRsnCd = this.vslDlayRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlVoyNo = this.tmlVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plismVslCd = this.plismVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNo = this.shpCallNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPortCd = this.tsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtChkFlg = this.prtChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDlayHrs = this.ttlDlayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDt = this.ftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpRsnOffrRmk = this.portSkpRsnOffrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phsIoRmk = this.phsIoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpFlg = this.actInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCgoQty = this.ibCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptInpFlg = this.depRptInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
