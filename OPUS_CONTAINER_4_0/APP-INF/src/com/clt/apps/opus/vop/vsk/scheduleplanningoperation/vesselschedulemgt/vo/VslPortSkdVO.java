/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VslPortSkdVO.java
 *@FileTitle : VslPortSkdVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.30
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.03.30 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class VslPortSkdVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VslPortSkdVO> models = new ArrayList<VslPortSkdVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String ofcInpFlg = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String crnWrkCmplDt = null;

    /*	Column Info	*/
    private String plismVoyNo = null;

    /*	Column Info	*/
    private String turnSkdVoyNo = null;

    /*	Column Info	*/
    private String initSkdInpFlg = null;

    /*	Column Info	*/
    private String turnPortIndCd = null;

    /*	Column Info	*/
    private String cngInd = null;

    /*	Column Info	*/
    private String skdBrthNo = null;

    /*	Column Info	*/
    private String clptSeq = null;

    /*	Column Info	*/
    private String vpsPortCd = null;

    /*	Column Info	*/
    private String portSkdStsCd = null;

    /*	Column Info	*/
    private String noonRptInpFlg = null;

    /*	Column Info	*/
    private String vslDlayRsnDesc = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String newClptIndSeq = null;

    /*	Column Info	*/
    private String crnWrkCmncDt = null;

    /*	Column Info	*/
    private String initEtaDt = null;

    /*	Column Info	*/
    private String shpCallNoUpdUsrId = null;

    /*	Column Info	*/
    private String vpsEtdDt = null;

    /*	Column Info	*/
    private String skdInd = null;

    /*	Column Info	*/
    private String initEtbDt = null;

    /*	Column Info	*/
    private String obCgoQty = null;

    /*	Column Info	*/
    private String portSkpRsnCd = null;

    /*	Column Info	*/
    private String plismYdCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String tmlVslCd = null;

    /*	Column Info	*/
    private String initEtdDt = null;

    /*	Column Info	*/
    private String ediSndKnt = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String skdCngStsCd = null;

    /*	Column Info	*/
    private String shpCallNoUpdDt = null;

    /*	Column Info	*/
    private String turnClptIndSeq = null;

    /*	Column Info	*/
    private String usdFlg = null;

    /*	Column Info	*/
    private String vpsRmk = null;

    /*	Column Info	*/
    private String vpsEtbDt = null;

    /*	Column Info	*/
    private String vslDlayRsnLocCd = null;

    /*	Column Info	*/
    private String turnPortFlg = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String phsIoRsnCd = null;

    /*	Column Info	*/
    private String vpsEtaDt = null;

    /*	Column Info	*/
    private String turnSkdDirCd = null;

    /*	Column Info	*/
    private String portSkpTpCd = null;

    /*	Column Info	*/
    private String vslEngNm = null;

    /*	Column Info	*/
    private String vslDlayRsnCd = null;

    /*	Column Info	*/
    private String tmlVoyNo = null;

    /*	Column Info	*/
    private String callYdIndSeq = null;

    /*	Column Info	*/
    private String plismVslCd = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String shpCallNo = null;

    /*	Column Info	*/
    private String tsPortCd = null;

    /*	Column Info	*/
    private String prtChkFlg = null;

    /*	Column Info	*/
    private String pfEtdDt = null;

    /*	Column Info	*/
    private String ttlDlayHrs = null;

    /*	Column Info	*/
    private String ftDt = null;

    /*	Column Info	*/
    private String portSkpRsnOffrRmk = null;

    /*	Column Info	*/
    private String pfEtaDt = null;

    /*	Column Info	*/
    private String phsIoRmk = null;

    /*	Column Info	*/
    private String pfEtbDt = null;

    /*	Column Info	*/
    private String actInpFlg = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String ibCgoQty = null;

    /*	Column Info	*/
    private String ydCd = null;

    /*	Column Info	*/
    private String clptIndSeq = null;

    /*	Column Info	*/
    private String depRptInpFlg = null;

    /*	Column Info	*/
    private String autoSkdCngFlg = null;

    /*	Column Info	*/
    private String lnkSpd = null;

    /*	Column Info	*/
    private String seaBufHrs = null;

    /*	Column Info	*/
    private String portBufHrs = null;

    /*	Column Info	*/
    private String tztmHrs = null;

    /*	Column Info	*/
    private String portWrkHrs = null;

    /*	Column Info	*/
    private String lnkDist = null;

    /*	Column Info	*/
    private String mnvrOutHrs = null;

    /*	Column Info	*/
    private String mnvrInHrs = null;

    /*	Column Info	*/
    private String addVtPortSeq = null;

    /*	Column Info	*/
    private String addVtPortFlg = null;

    /*	Column Info	*/
    private String firstVirPortFlg = null;

    /*	Column Info	*/
    private String vtAddCallFlg = null;

    /* Column Info */
    private String cssmVoyInitCreFlg = null;

    /* Column Info */
    private String vslRenmOldVslCd = null;

    /* Column Info */
    private String vslRenmOldVslEngNm = null;

    /* Column Info */
    private String vslRenmNewVslCd = null;

    /* Column Info */
    private String vslRenmNewVslEngNm = null;

    /* Column Info */
    private String vsldWks = null;

    /* Column Info */
    private String addCallFlg = null;

    /* Column Info */
    private String skpCallFlg = null;

    /* Column Info */
    private String clptIndSeq2 = null;

    /* Column Info */
    private String addCallXterFlg = null;

    /* Column Info */
    private String privCallFlg = null;

    /* Column Info */
    private String ibCssmVoyNo = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String turnIbCssmVoyNo = null;

    /* Column Info */
    private String firstTurnPortClptSeq = null;

    /* Column Info */
    private String bkgVvdKnd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public VslPortSkdVO() {
    }

    public VslPortSkdVO(String ibflag, String pagerows, String ofcInpFlg, String vslCd, String crnWrkCmplDt, String plismVoyNo, String turnSkdVoyNo, String initSkdInpFlg, String turnPortIndCd, String cngInd, String skdBrthNo, String clptSeq, String vpsPortCd, String portSkdStsCd, String noonRptInpFlg, String vslDlayRsnDesc, String updUsrId, String newClptIndSeq, String crnWrkCmncDt, String initEtaDt, String shpCallNoUpdUsrId, String vpsEtdDt, String skdInd, String initEtbDt, String obCgoQty, String portSkpRsnCd, String plismYdCd, String skdVoyNo, String tmlVslCd, String initEtdDt, String ediSndKnt, String creUsrId, String skdCngStsCd, String shpCallNoUpdDt, String turnClptIndSeq, String usdFlg, String vpsRmk, String vpsEtbDt, String vslDlayRsnLocCd, String turnPortFlg, String creDt, String phsIoRsnCd, String vpsEtaDt, String turnSkdDirCd, String portSkpTpCd, String vslEngNm, String vslDlayRsnCd, String tmlVoyNo, String callYdIndSeq, String plismVslCd, String updDt, String shpCallNo, String tsPortCd, String prtChkFlg, String pfEtdDt, String ttlDlayHrs, String ftDt, String portSkpRsnOffrRmk, String pfEtaDt, String phsIoRmk, String pfEtbDt, String actInpFlg, String skdDirCd, String slanCd, String ibCgoQty, String ydCd, String clptIndSeq, String depRptInpFlg, String autoSkdCngFlg, String lnkSpd, String seaBufHrs, String portBufHrs, String tztmHrs, String portWrkHrs, String lnkDist, String mnvrOutHrs, String mnvrInHrs, String addVtPortSeq, String addVtPortFlg, String ibCssmVoyNo, String obCssmVoyNo, String cssmVoyInitCreFlg, String vslRenmOldVslCd, String vslRenmOldVslEngNm, String vslRenmNewVslCd, String vslRenmNewVslEngNm, String vsldWks, String addCallFlg, String skpCallFlg, String clptIndSeq2, String addCallXterFlg, String turnIbCssmVoyNo, String firstTurnPortClptSeq, String bkgVvdKnd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.ofcInpFlg = ofcInpFlg;
        this.vslCd = vslCd;
        this.crnWrkCmplDt = crnWrkCmplDt;
        this.plismVoyNo = plismVoyNo;
        this.turnSkdVoyNo = turnSkdVoyNo;
        this.initSkdInpFlg = initSkdInpFlg;
        this.turnPortIndCd = turnPortIndCd;
        this.cngInd = cngInd;
        this.skdBrthNo = skdBrthNo;
        this.clptSeq = clptSeq;
        this.vpsPortCd = vpsPortCd;
        this.portSkdStsCd = portSkdStsCd;
        this.noonRptInpFlg = noonRptInpFlg;
        this.vslDlayRsnDesc = vslDlayRsnDesc;
        this.updUsrId = updUsrId;
        this.newClptIndSeq = newClptIndSeq;
        this.crnWrkCmncDt = crnWrkCmncDt;
        this.initEtaDt = initEtaDt;
        this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
        this.vpsEtdDt = vpsEtdDt;
        this.skdInd = skdInd;
        this.initEtbDt = initEtbDt;
        this.obCgoQty = obCgoQty;
        this.portSkpRsnCd = portSkpRsnCd;
        this.plismYdCd = plismYdCd;
        this.skdVoyNo = skdVoyNo;
        this.tmlVslCd = tmlVslCd;
        this.initEtdDt = initEtdDt;
        this.ediSndKnt = ediSndKnt;
        this.creUsrId = creUsrId;
        this.skdCngStsCd = skdCngStsCd;
        this.shpCallNoUpdDt = shpCallNoUpdDt;
        this.turnClptIndSeq = turnClptIndSeq;
        this.usdFlg = usdFlg;
        this.vpsRmk = vpsRmk;
        this.vpsEtbDt = vpsEtbDt;
        this.vslDlayRsnLocCd = vslDlayRsnLocCd;
        this.turnPortFlg = turnPortFlg;
        this.creDt = creDt;
        this.phsIoRsnCd = phsIoRsnCd;
        this.vpsEtaDt = vpsEtaDt;
        this.turnSkdDirCd = turnSkdDirCd;
        this.portSkpTpCd = portSkpTpCd;
        this.vslEngNm = vslEngNm;
        this.vslDlayRsnCd = vslDlayRsnCd;
        this.tmlVoyNo = tmlVoyNo;
        this.callYdIndSeq = callYdIndSeq;
        this.plismVslCd = plismVslCd;
        this.updDt = updDt;
        this.shpCallNo = shpCallNo;
        this.tsPortCd = tsPortCd;
        this.prtChkFlg = prtChkFlg;
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
        this.autoSkdCngFlg = autoSkdCngFlg;
        this.lnkSpd = lnkSpd;
        this.seaBufHrs = seaBufHrs;
        this.portBufHrs = portBufHrs;
        this.tztmHrs = tztmHrs;
        this.portWrkHrs = portWrkHrs;
        this.lnkDist = lnkDist;
        this.mnvrOutHrs = mnvrOutHrs;
        this.mnvrInHrs = mnvrInHrs;
        this.addVtPortSeq = addVtPortSeq;
        this.addVtPortFlg = addVtPortFlg;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.cssmVoyInitCreFlg = cssmVoyInitCreFlg;
        this.vslRenmOldVslCd = vslRenmOldVslCd;
        this.vslRenmOldVslEngNm = vslRenmOldVslEngNm;
        this.vslRenmNewVslCd = vslRenmNewVslCd;
        this.vslRenmNewVslEngNm = vslRenmNewVslEngNm;
        this.vsldWks = vsldWks;
        this.addCallFlg = addCallFlg;
        this.skpCallFlg = skpCallFlg;
        this.clptIndSeq2 = clptIndSeq2;
        this.addCallXterFlg = addCallXterFlg;
        this.privCallFlg = privCallFlg;
        this.ibCssmVoyNo = ibCssmVoyNo;
        this.obCssmVoyNo = obCssmVoyNo;
        this.turnIbCssmVoyNo = turnIbCssmVoyNo;
        this.firstTurnPortClptSeq = firstTurnPortClptSeq;
        this.bkgVvdKnd = bkgVvdKnd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ofc_inp_flg", getOfcInpFlg());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("crn_wrk_cmpl_dt", getCrnWrkCmplDt());
        this.hashColumns.put("plism_voy_no", getPlismVoyNo());
        this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
        this.hashColumns.put("init_skd_inp_flg", getInitSkdInpFlg());
        this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
        this.hashColumns.put("cng_ind", getCngInd());
        this.hashColumns.put("skd_brth_no", getSkdBrthNo());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("port_skd_sts_cd", getPortSkdStsCd());
        this.hashColumns.put("noon_rpt_inp_flg", getNoonRptInpFlg());
        this.hashColumns.put("vsl_dlay_rsn_desc", getVslDlayRsnDesc());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("new_clpt_ind_seq", getNewClptIndSeq());
        this.hashColumns.put("crn_wrk_cmnc_dt", getCrnWrkCmncDt());
        this.hashColumns.put("init_eta_dt", getInitEtaDt());
        this.hashColumns.put("shp_call_no_upd_usr_id", getShpCallNoUpdUsrId());
        this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
        this.hashColumns.put("skd_ind", getSkdInd());
        this.hashColumns.put("init_etb_dt", getInitEtbDt());
        this.hashColumns.put("ob_cgo_qty", getObCgoQty());
        this.hashColumns.put("port_skp_rsn_cd", getPortSkpRsnCd());
        this.hashColumns.put("plism_yd_cd", getPlismYdCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("tml_vsl_cd", getTmlVslCd());
        this.hashColumns.put("init_etd_dt", getInitEtdDt());
        this.hashColumns.put("edi_snd_knt", getEdiSndKnt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
        this.hashColumns.put("shp_call_no_upd_dt", getShpCallNoUpdDt());
        this.hashColumns.put("turn_clpt_ind_seq", getTurnClptIndSeq());
        this.hashColumns.put("usd_flg", getUsdFlg());
        this.hashColumns.put("vps_rmk", getVpsRmk());
        this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
        this.hashColumns.put("vsl_dlay_rsn_loc_cd", getVslDlayRsnLocCd());
        this.hashColumns.put("turn_port_flg", getTurnPortFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("phs_io_rsn_cd", getPhsIoRsnCd());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
        this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("vsl_dlay_rsn_cd", getVslDlayRsnCd());
        this.hashColumns.put("tml_voy_no", getTmlVoyNo());
        this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
        this.hashColumns.put("plism_vsl_cd", getPlismVslCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("shp_call_no", getShpCallNo());
        this.hashColumns.put("ts_port_cd", getTsPortCd());
        this.hashColumns.put("prt_chk_flg", getPrtChkFlg());
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
        this.hashColumns.put("auto_skd_cng_flg", getAutoSkdCngFlg());
        this.hashColumns.put("lnk_spd", getLnkSpd());
        this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
        this.hashColumns.put("port_buf_hrs", getPortBufHrs());
        this.hashColumns.put("tztm_hrs", getTztmHrs());
        this.hashColumns.put("port_wrk_hrs", getPortWrkHrs());
        this.hashColumns.put("lnk_dist", getLnkDist());
        this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
        this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
        this.hashColumns.put("add_vt_port_seq", getAddVtPortSeq());
        this.hashColumns.put("add_vt_port_flg", getAddVtPortFlg());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("first_vir_port_flg", getFirstVirPortFlg());
        this.hashColumns.put("vt_add_call_flg", getVtAddCallFlg());
        this.hashColumns.put("cssm_voy_init_cre_flg", getCssmVoyInitCreFlg());
        this.hashColumns.put("cssm_voy_init_cre_flg", getCssmVoyInitCreFlg());
        this.hashColumns.put("vsl_renm_old_vsl_cd", getVslRenmOldVslCd());
        this.hashColumns.put("vsl_renm_old_vsl_eng_nm", getVslRenmOldVslEngNm());
        this.hashColumns.put("vsl_renm_new_vsl_cd", getVslRenmNewVslCd());
        this.hashColumns.put("vsl_renm_new_vsl_eng_nm", getVslRenmNewVslEngNm());
        this.hashColumns.put("vsld_wks", getVsldWks());
        this.hashColumns.put("add_call_flg", getAddCallFlg());
        this.hashColumns.put("skp_call_flg", getSkpCallFlg());
        this.hashColumns.put("clpt_ind_seq2", getClptIndSeq2());
        this.hashColumns.put("add_call_xter_flg", getAddCallXterFlg());
        this.hashColumns.put("priv_call_flg", getPrivCallFlg());
        this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("turn_ib_cssm_voy_no", getTurnIbCssmVoyNo());
        this.hashColumns.put("first_turn_port_clpt_seq", getFirstTurnPortClptSeq());
        this.hashColumns.put("bkg_vvd_knd", getBkgVvdKnd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ofc_inp_flg", "ofcInpFlg");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("crn_wrk_cmpl_dt", "crnWrkCmplDt");
        this.hashFields.put("plism_voy_no", "plismVoyNo");
        this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
        this.hashFields.put("init_skd_inp_flg", "initSkdInpFlg");
        this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
        this.hashFields.put("cng_ind", "cngInd");
        this.hashFields.put("skd_brth_no", "skdBrthNo");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("port_skd_sts_cd", "portSkdStsCd");
        this.hashFields.put("noon_rpt_inp_flg", "noonRptInpFlg");
        this.hashFields.put("vsl_dlay_rsn_desc", "vslDlayRsnDesc");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("new_clpt_ind_seq", "newClptIndSeq");
        this.hashFields.put("crn_wrk_cmnc_dt", "crnWrkCmncDt");
        this.hashFields.put("init_eta_dt", "initEtaDt");
        this.hashFields.put("shp_call_no_upd_usr_id", "shpCallNoUpdUsrId");
        this.hashFields.put("vps_etd_dt", "vpsEtdDt");
        this.hashFields.put("skd_ind", "skdInd");
        this.hashFields.put("init_etb_dt", "initEtbDt");
        this.hashFields.put("ob_cgo_qty", "obCgoQty");
        this.hashFields.put("port_skp_rsn_cd", "portSkpRsnCd");
        this.hashFields.put("plism_yd_cd", "plismYdCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("tml_vsl_cd", "tmlVslCd");
        this.hashFields.put("init_etd_dt", "initEtdDt");
        this.hashFields.put("edi_snd_knt", "ediSndKnt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
        this.hashFields.put("shp_call_no_upd_dt", "shpCallNoUpdDt");
        this.hashFields.put("turn_clpt_ind_seq", "turnClptIndSeq");
        this.hashFields.put("usd_flg", "usdFlg");
        this.hashFields.put("vps_rmk", "vpsRmk");
        this.hashFields.put("vps_etb_dt", "vpsEtbDt");
        this.hashFields.put("vsl_dlay_rsn_loc_cd", "vslDlayRsnLocCd");
        this.hashFields.put("turn_port_flg", "turnPortFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("phs_io_rsn_cd", "phsIoRsnCd");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
        this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("vsl_dlay_rsn_cd", "vslDlayRsnCd");
        this.hashFields.put("tml_voy_no", "tmlVoyNo");
        this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
        this.hashFields.put("plism_vsl_cd", "plismVslCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("shp_call_no", "shpCallNo");
        this.hashFields.put("ts_port_cd", "tsPortCd");
        this.hashFields.put("prt_chk_flg", "prtChkFlg");
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
        this.hashFields.put("auto_skd_cng_flg", "autoSkdCngFlg");
        this.hashFields.put("lnk_spd", "lnkSpd");
        this.hashFields.put("sea_buf_hrs", "seaBufHrs");
        this.hashFields.put("port_buf_hrs", "portBufHrs");
        this.hashFields.put("tztm_hrs", "tztmHrs");
        this.hashFields.put("port_wrk_hrs", "portWrkHrs");
        this.hashFields.put("lnk_dist", "lnkDist");
        this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
        this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
        this.hashFields.put("add_vt_port_seq", "addVtPortSeq");
        this.hashFields.put("add_vt_port_flg", "addVtPortFlg");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("first_vir_port_flg", "firstVirPortFlg");
        this.hashFields.put("vt_add_call_flg", "vtAddCallFlg");
        this.hashFields.put("cssm_voy_init_cre_flg", "cssmVoyInitCreFlg");
        this.hashFields.put("cssm_voy_init_cre_flg", "cssmVoyInitCreFlg");
        this.hashFields.put("vsl_renm_old_vsl_cd", "vslRenmOldVslCd");
        this.hashFields.put("vsl_renm_old_vsl_eng_nm", "vslRenmOldVslEngNm");
        this.hashFields.put("vsl_renm_new_vsl_cd", "vslRenmNewVslCd");
        this.hashFields.put("vsl_renm_new_vsl_eng_nm", "vslRenmNewVslEngNm");
        this.hashFields.put("vsld_wks", "vsldWks");
        this.hashFields.put("add_call_flg", "addCallFlg");
        this.hashFields.put("skp_call_flg", "skpCallFlg");
        this.hashFields.put("clpt_ind_seq2", "clptIndSeq2");
        this.hashFields.put("add_call_xter_flg", "addCallXterFlg");
        this.hashFields.put("priv_call_flg", "privCallFlg");
        this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("turn_ib_cssm_voy_no", "turnIbCssmVoyNo");
        this.hashFields.put("first_turn_port_clpt_seq", "firstTurnPortClptSeq");
        this.hashFields.put("bkg_vvd_knd", "bkgVvdKnd");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return crnWrkCmplDt
	 */
    public String getCrnWrkCmplDt() {
        return this.crnWrkCmplDt;
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
	 * @return initSkdInpFlg
	 */
    public String getInitSkdInpFlg() {
        return this.initSkdInpFlg;
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
	 * @return cngInd
	 */
    public String getCngInd() {
        return this.cngInd;
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
	 * @return portSkdStsCd
	 */
    public String getPortSkdStsCd() {
        return this.portSkdStsCd;
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
	 * @return crnWrkCmncDt
	 */
    public String getCrnWrkCmncDt() {
        return this.crnWrkCmncDt;
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
	 * @return vpsEtdDt
	 */
    public String getVpsEtdDt() {
        return this.vpsEtdDt;
    }

    /**
	 * Column Info
	 * @return skdInd
	 */
    public String getSkdInd() {
        return this.skdInd;
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
	 * @return portSkpTpCd
	 */
    public String getPortSkpTpCd() {
        return this.portSkpTpCd;
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
	 * @return vslDlayRsnCd
	 */
    public String getVslDlayRsnCd() {
        return this.vslDlayRsnCd;
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
	 * @return autoSkdCngFlg
	 */
    public String getAutoSkdCngFlg() {
        return this.autoSkdCngFlg;
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
	 * @return portBufHrs
	 */
    public String getPortBufHrs() {
        return this.portBufHrs;
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
	 * @return portWrkHrs
	 */
    public String getPortWrkHrs() {
        return this.portWrkHrs;
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
	 * @return mnvrOutHrs
	 */
    public String getMnvrOutHrs() {
        return this.mnvrOutHrs;
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
	 * @return addVtPortSeq
	 */
    public String getAddVtPortSeq() {
        return this.addVtPortSeq;
    }

    /**
	 * Column Info
	 * @return addVtPortFlg
	 */
    public String getAddVtPortFlg() {
        return this.addVtPortFlg;
    }

    /**
	 * Column Info
	 * @return firstVirPortFlg
	 */
    public String getFirstVirPortFlg() {
        return this.firstVirPortFlg;
    }

    /**
	 * Column Info
	 * @return vtAddCallFlg
	 */
    public String getVtAddCallFlg() {
        return this.vtAddCallFlg;
    }

    /**
	* Column Info
	* @return vslRenmOldVslCd
	*/
    public String getVslRenmOldVslCd() {
        return this.vslRenmOldVslCd;
    }

    /**
	* Column Info
	* @return vslRenmOldVslEngNm
	*/
    public String getVslRenmOldVslEngNm() {
        return this.vslRenmOldVslEngNm;
    }

    /**
	* Column Info
	* @return vslRenmNewVslCd
	*/
    public String getVslRenmNewVslCd() {
        return this.vslRenmNewVslCd;
    }

    /**
	* Column Info
	* @return vslRenmNewVslEngNm
	*/
    public String getVslRenmNewVslEngNm() {
        return this.vslRenmNewVslEngNm;
    }

    /**
	* Column Info
	* @return vsldWks
	*/
    public String getVsldWks() {
        return this.vsldWks;
    }

    /**
	* Column Info
	* @return addCallFlg
	*/
    public String getAddCallFlg() {
        return this.addCallFlg;
    }

    /**
	* Column Info
	* @return skpCallFlg
	*/
    public String getSkpCallFlg() {
        return this.skpCallFlg;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  vtAddCallFlg
 	 */
    public void setVtAddCallFlg(String vtAddCallFlg) {
        this.vtAddCallFlg = vtAddCallFlg;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  firstVirPortFlg
 	 */
    public void setFirstVirPortFlg(String firstVirPortFlg) {
        this.firstVirPortFlg = firstVirPortFlg;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  ofcInpFlg
 	 */
    public void setOfcInpFlg(String ofcInpFlg) {
        this.ofcInpFlg = ofcInpFlg;
    }

    /**
	 * Column Info
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param  crnWrkCmplDt
 	 */
    public void setCrnWrkCmplDt(String crnWrkCmplDt) {
        this.crnWrkCmplDt = crnWrkCmplDt;
    }

    /**
	 * Column Info
	 * @param  plismVoyNo
 	 */
    public void setPlismVoyNo(String plismVoyNo) {
        this.plismVoyNo = plismVoyNo;
    }

    /**
	 * Column Info
	 * @param  turnSkdVoyNo
 	 */
    public void setTurnSkdVoyNo(String turnSkdVoyNo) {
        this.turnSkdVoyNo = turnSkdVoyNo;
    }

    /**
	 * Column Info
	 * @param  initSkdInpFlg
 	 */
    public void setInitSkdInpFlg(String initSkdInpFlg) {
        this.initSkdInpFlg = initSkdInpFlg;
    }

    /**
	 * Column Info
	 * @param  turnPortIndCd
 	 */
    public void setTurnPortIndCd(String turnPortIndCd) {
        this.turnPortIndCd = turnPortIndCd;
    }

    /**
	 * Column Info
	 * @param  cngInd
 	 */
    public void setCngInd(String cngInd) {
        this.cngInd = cngInd;
    }

    /**
	 * Column Info
	 * @param  skdBrthNo
 	 */
    public void setSkdBrthNo(String skdBrthNo) {
        this.skdBrthNo = skdBrthNo;
    }

    /**
	 * Column Info
	 * @param  clptSeq
 	 */
    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
    }

    /**
	 * Column Info
	 * @param  vpsPortCd
 	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    /**
	 * Column Info
	 * @param  portSkdStsCd
 	 */
    public void setPortSkdStsCd(String portSkdStsCd) {
        this.portSkdStsCd = portSkdStsCd;
    }

    /**
	 * Column Info
	 * @param  noonRptInpFlg
 	 */
    public void setNoonRptInpFlg(String noonRptInpFlg) {
        this.noonRptInpFlg = noonRptInpFlg;
    }

    /**
	 * Column Info
	 * @param  vslDlayRsnDesc
 	 */
    public void setVslDlayRsnDesc(String vslDlayRsnDesc) {
        this.vslDlayRsnDesc = vslDlayRsnDesc;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  newClptIndSeq
 	 */
    public void setNewClptIndSeq(String newClptIndSeq) {
        this.newClptIndSeq = newClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  crnWrkCmncDt
 	 */
    public void setCrnWrkCmncDt(String crnWrkCmncDt) {
        this.crnWrkCmncDt = crnWrkCmncDt;
    }

    /**
	 * Column Info
	 * @param  initEtaDt
 	 */
    public void setInitEtaDt(String initEtaDt) {
        this.initEtaDt = initEtaDt;
    }

    /**
	 * Column Info
	 * @param  shpCallNoUpdUsrId
 	 */
    public void setShpCallNoUpdUsrId(String shpCallNoUpdUsrId) {
        this.shpCallNoUpdUsrId = shpCallNoUpdUsrId;
    }

    /**
	 * Column Info
	 * @param  vpsEtdDt
 	 */
    public void setVpsEtdDt(String vpsEtdDt) {
        this.vpsEtdDt = vpsEtdDt;
    }

    /**
	 * Column Info
	 * @param  skdInd
 	 */
    public void setSkdInd(String skdInd) {
        this.skdInd = skdInd;
    }

    /**
	 * Column Info
	 * @param  initEtbDt
 	 */
    public void setInitEtbDt(String initEtbDt) {
        this.initEtbDt = initEtbDt;
    }

    /**
	 * Column Info
	 * @param  obCgoQty
 	 */
    public void setObCgoQty(String obCgoQty) {
        this.obCgoQty = obCgoQty;
    }

    /**
	 * Column Info
	 * @param  portSkpRsnCd
 	 */
    public void setPortSkpRsnCd(String portSkpRsnCd) {
        this.portSkpRsnCd = portSkpRsnCd;
    }

    /**
	 * Column Info
	 * @param  plismYdCd
 	 */
    public void setPlismYdCd(String plismYdCd) {
        this.plismYdCd = plismYdCd;
    }

    /**
	 * Column Info
	 * @param  skdVoyNo
 	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param  tmlVslCd
 	 */
    public void setTmlVslCd(String tmlVslCd) {
        this.tmlVslCd = tmlVslCd;
    }

    /**
	 * Column Info
	 * @param  initEtdDt
 	 */
    public void setInitEtdDt(String initEtdDt) {
        this.initEtdDt = initEtdDt;
    }

    /**
	 * Column Info
	 * @param  ediSndKnt
 	 */
    public void setEdiSndKnt(String ediSndKnt) {
        this.ediSndKnt = ediSndKnt;
    }

    /**
	 * Column Info
	 * @param  creUsrId
 	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param  skdCngStsCd
 	 */
    public void setSkdCngStsCd(String skdCngStsCd) {
        this.skdCngStsCd = skdCngStsCd;
    }

    /**
	 * Column Info
	 * @param  shpCallNoUpdDt
 	 */
    public void setShpCallNoUpdDt(String shpCallNoUpdDt) {
        this.shpCallNoUpdDt = shpCallNoUpdDt;
    }

    /**
	 * Column Info
	 * @param  turnClptIndSeq
 	 */
    public void setTurnClptIndSeq(String turnClptIndSeq) {
        this.turnClptIndSeq = turnClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  usdFlg
 	 */
    public void setUsdFlg(String usdFlg) {
        this.usdFlg = usdFlg;
    }

    /**
	 * Column Info
	 * @param  vpsRmk
 	 */
    public void setVpsRmk(String vpsRmk) {
        this.vpsRmk = vpsRmk;
    }

    /**
	 * Column Info
	 * @param  vpsEtbDt
 	 */
    public void setVpsEtbDt(String vpsEtbDt) {
        this.vpsEtbDt = vpsEtbDt;
    }

    /**
	 * Column Info
	 * @param  vslDlayRsnLocCd
 	 */
    public void setVslDlayRsnLocCd(String vslDlayRsnLocCd) {
        this.vslDlayRsnLocCd = vslDlayRsnLocCd;
    }

    /**
	 * Column Info
	 * @param  turnPortFlg
 	 */
    public void setTurnPortFlg(String turnPortFlg) {
        this.turnPortFlg = turnPortFlg;
    }

    /**
	 * Column Info
	 * @param  creDt
 	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param  phsIoRsnCd
 	 */
    public void setPhsIoRsnCd(String phsIoRsnCd) {
        this.phsIoRsnCd = phsIoRsnCd;
    }

    /**
	 * Column Info
	 * @param  vpsEtaDt
 	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param  turnSkdDirCd
 	 */
    public void setTurnSkdDirCd(String turnSkdDirCd) {
        this.turnSkdDirCd = turnSkdDirCd;
    }

    /**
	 * Column Info
	 * @param  portSkpTpCd
 	 */
    public void setPortSkpTpCd(String portSkpTpCd) {
        this.portSkpTpCd = portSkpTpCd;
    }

    /**
	 * Column Info
	 * @param  vslEngNm
 	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * Column Info
	 * @param  vslDlayRsnCd
 	 */
    public void setVslDlayRsnCd(String vslDlayRsnCd) {
        this.vslDlayRsnCd = vslDlayRsnCd;
    }

    /**
	 * Column Info
	 * @param  tmlVoyNo
 	 */
    public void setTmlVoyNo(String tmlVoyNo) {
        this.tmlVoyNo = tmlVoyNo;
    }

    /**
	 * Column Info
	 * @param  callYdIndSeq
 	 */
    public void setCallYdIndSeq(String callYdIndSeq) {
        this.callYdIndSeq = callYdIndSeq;
    }

    /**
	 * Column Info
	 * @param  plismVslCd
 	 */
    public void setPlismVslCd(String plismVslCd) {
        this.plismVslCd = plismVslCd;
    }

    /**
	 * Column Info
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param  shpCallNo
 	 */
    public void setShpCallNo(String shpCallNo) {
        this.shpCallNo = shpCallNo;
    }

    /**
	 * Column Info
	 * @param  tsPortCd
 	 */
    public void setTsPortCd(String tsPortCd) {
        this.tsPortCd = tsPortCd;
    }

    /**
	 * Column Info
	 * @param  prtChkFlg
 	 */
    public void setPrtChkFlg(String prtChkFlg) {
        this.prtChkFlg = prtChkFlg;
    }

    /**
	 * Column Info
	 * @param  pfEtdDt
 	 */
    public void setPfEtdDt(String pfEtdDt) {
        this.pfEtdDt = pfEtdDt;
    }

    /**
	 * Column Info
	 * @param  ttlDlayHrs
 	 */
    public void setTtlDlayHrs(String ttlDlayHrs) {
        this.ttlDlayHrs = ttlDlayHrs;
    }

    /**
	 * Column Info
	 * @param  ftDt
 	 */
    public void setFtDt(String ftDt) {
        this.ftDt = ftDt;
    }

    /**
	 * Column Info
	 * @param  portSkpRsnOffrRmk
 	 */
    public void setPortSkpRsnOffrRmk(String portSkpRsnOffrRmk) {
        this.portSkpRsnOffrRmk = portSkpRsnOffrRmk;
    }

    /**
	 * Column Info
	 * @param  pfEtaDt
 	 */
    public void setPfEtaDt(String pfEtaDt) {
        this.pfEtaDt = pfEtaDt;
    }

    /**
	 * Column Info
	 * @param  phsIoRmk
 	 */
    public void setPhsIoRmk(String phsIoRmk) {
        this.phsIoRmk = phsIoRmk;
    }

    /**
	 * Column Info
	 * @param  pfEtbDt
 	 */
    public void setPfEtbDt(String pfEtbDt) {
        this.pfEtbDt = pfEtbDt;
    }

    /**
	 * Column Info
	 * @param  actInpFlg
 	 */
    public void setActInpFlg(String actInpFlg) {
        this.actInpFlg = actInpFlg;
    }

    /**
	 * Column Info
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  slanCd
 	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param  ibCgoQty
 	 */
    public void setIbCgoQty(String ibCgoQty) {
        this.ibCgoQty = ibCgoQty;
    }

    /**
	 * Column Info
	 * @param  ydCd
 	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * @param  clptIndSeq
 	 */
    public void setClptIndSeq(String clptIndSeq) {
        this.clptIndSeq = clptIndSeq;
    }

    /**
	 * Column Info
	 * @param  depRptInpFlg
 	 */
    public void setDepRptInpFlg(String depRptInpFlg) {
        this.depRptInpFlg = depRptInpFlg;
    }

    /**
	 * Column Info
	 * @param  autoSkdCngFlg
 	 */
    public void setAutoSkdCngFlg(String autoSkdCngFlg) {
        this.autoSkdCngFlg = autoSkdCngFlg;
    }

    /**
	 * Column Info
	 * @param  lnkSpd
 	 */
    public void setLnkSpd(String lnkSpd) {
        this.lnkSpd = lnkSpd;
    }

    /**
	 * Column Info
	 * @param  seaBufHrs
 	 */
    public void setSeaBufHrs(String seaBufHrs) {
        this.seaBufHrs = seaBufHrs;
    }

    /**
	 * Column Info
	 * @param  portBufHrs
 	 */
    public void setPortBufHrs(String portBufHrs) {
        this.portBufHrs = portBufHrs;
    }

    /**
	 * Column Info
	 * @param  tztmHrs
 	 */
    public void setTztmHrs(String tztmHrs) {
        this.tztmHrs = tztmHrs;
    }

    /**
	 * Column Info
	 * @param  portWrkHrs
 	 */
    public void setPortWrkHrs(String portWrkHrs) {
        this.portWrkHrs = portWrkHrs;
    }

    /**
	 * Column Info
	 * @param  lnkDist
 	 */
    public void setLnkDist(String lnkDist) {
        this.lnkDist = lnkDist;
    }

    /**
	 * Column Info
	 * @param  mnvrOutHrs
 	 */
    public void setMnvrOutHrs(String mnvrOutHrs) {
        this.mnvrOutHrs = mnvrOutHrs;
    }

    /**
	 * Column Info
	 * @param  mnvrInHrs
 	 */
    public void setMnvrInHrs(String mnvrInHrs) {
        this.mnvrInHrs = mnvrInHrs;
    }

    /**
	 * Column Info
	 * @param  addVtPortSeq
 	 */
    public void setAddVtPortSeq(String addVtPortSeq) {
        this.addVtPortSeq = addVtPortSeq;
    }

    /**
	 * Column Info
	 * @param  addVtPortFlg
 	 */
    public void setAddVtPortFlg(String addVtPortFlg) {
        this.addVtPortFlg = addVtPortFlg;
    }

    public void setCssmVoyInitCreFlg(String cssmVoyInitCreFlg) {
        this.cssmVoyInitCreFlg = cssmVoyInitCreFlg;
    }

    public String getCssmVoyInitCreFlg() {
        return this.cssmVoyInitCreFlg;
    }

    /**
	 * Column Info
	 * @param  vslRenmOldVslCd
 	 */
    public void setVslRenmOldVslCd(String vslRenmOldVslCd) {
        this.vslRenmOldVslCd = vslRenmOldVslCd;
    }

    /**
	 * Column Info
	 * @param  vslRenmOldVslEngNm
 	 */
    public void setVslRenmOldVslEngNm(String vslRenmOldVslEngNm) {
        this.vslRenmOldVslEngNm = vslRenmOldVslEngNm;
    }

    /**
	 * Column Info
	 * @param  vslRenmNewVslCd
 	 */
    public void setVslRenmNewVslCd(String vslRenmNewVslCd) {
        this.vslRenmNewVslCd = vslRenmNewVslCd;
    }

    /**
	 * Column Info
	 * @param  vslRenmNewVslEngNm
 	 */
    public void setVslRenmNewVslEngNm(String vslRenmNewVslEngNm) {
        this.vslRenmNewVslEngNm = vslRenmNewVslEngNm;
    }

    /**
	 * Column Info
	 * @param  vsldWks
 	 */
    public void setVsldWks(String vsldWks) {
        this.vsldWks = vsldWks;
    }

    /**
	 * Column Info
	 * @param  addCallFlg
 	 */
    public void setAddCallFlg(String addCallFlg) {
        this.addCallFlg = addCallFlg;
    }

    /**
	 * Column Info
	 * @param skpCallFlg
 	 */
    public void setSkpCallFlg(String skpCallFlg) {
        this.skpCallFlg = skpCallFlg;
    }

    public void setClptIndSeq2(String clptIndSeq2) {
        this.clptIndSeq2 = clptIndSeq2;
    }

    public String getClptIndSeq2() {
        return this.clptIndSeq2;
    }

    public void setAddCallXterFlg(String addCallXterFlg) {
        this.addCallXterFlg = addCallXterFlg;
    }

    public String getAddCallXterFlg() {
        return this.addCallXterFlg;
    }

    public void setPrivCallFlg(String privCallFlg) {
        this.privCallFlg = privCallFlg;
    }

    public String getPrivCallFlg() {
        return this.privCallFlg;
    }

    public void setIbCssmVoyNo(String ibCssmVoyNo) {
        this.ibCssmVoyNo = ibCssmVoyNo;
    }

    public String getIbCssmVoyNo() {
        return this.ibCssmVoyNo;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    public void setTurnIbCssmVoyNo(String turnIbCssmVoyNo) {
        this.turnIbCssmVoyNo = turnIbCssmVoyNo;
    }

    public String getTurnIbCssmVoyNo() {
        return this.turnIbCssmVoyNo;
    }

    public void setFirstTurnPortClptSeq(String firstTurnPortClptSeq) {
        this.firstTurnPortClptSeq = firstTurnPortClptSeq;
    }

    public String getFirstTurnPortClptSeq() {
        return this.firstTurnPortClptSeq;
    }

    public void setBkgVvdKnd(String bkgVvdKnd) {
        this.bkgVvdKnd = bkgVvdKnd;
    }

    public String getBkgVvdKnd() {
        return this.bkgVvdKnd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOfcInpFlg(JSPUtil.getParameter(request, prefix + "ofc_inp_flg", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCrnWrkCmplDt(JSPUtil.getParameter(request, prefix + "crn_wrk_cmpl_dt", ""));
        setPlismVoyNo(JSPUtil.getParameter(request, prefix + "plism_voy_no", ""));
        setTurnSkdVoyNo(JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", ""));
        setInitSkdInpFlg(JSPUtil.getParameter(request, prefix + "init_skd_inp_flg", ""));
        setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
        setCngInd(JSPUtil.getParameter(request, prefix + "cng_ind", ""));
        setSkdBrthNo(JSPUtil.getParameter(request, prefix + "skd_brth_no", ""));
        setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setPortSkdStsCd(JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", ""));
        setNoonRptInpFlg(JSPUtil.getParameter(request, prefix + "noon_rpt_inp_flg", ""));
        setVslDlayRsnDesc(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_desc", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setNewClptIndSeq(JSPUtil.getParameter(request, prefix + "new_clpt_ind_seq", ""));
        setCrnWrkCmncDt(JSPUtil.getParameter(request, prefix + "crn_wrk_cmnc_dt", ""));
        setInitEtaDt(JSPUtil.getParameter(request, prefix + "init_eta_dt", ""));
        setShpCallNoUpdUsrId(JSPUtil.getParameter(request, prefix + "shp_call_no_upd_usr_id", ""));
        setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
        setSkdInd(JSPUtil.getParameter(request, prefix + "skd_ind", ""));
        setInitEtbDt(JSPUtil.getParameter(request, prefix + "init_etb_dt", ""));
        setObCgoQty(JSPUtil.getParameter(request, prefix + "ob_cgo_qty", ""));
        setPortSkpRsnCd(JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", ""));
        setPlismYdCd(JSPUtil.getParameter(request, prefix + "plism_yd_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setTmlVslCd(JSPUtil.getParameter(request, prefix + "tml_vsl_cd", ""));
        setInitEtdDt(JSPUtil.getParameter(request, prefix + "init_etd_dt", ""));
        setEdiSndKnt(JSPUtil.getParameter(request, prefix + "edi_snd_knt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setSkdCngStsCd(JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", ""));
        setShpCallNoUpdDt(JSPUtil.getParameter(request, prefix + "shp_call_no_upd_dt", ""));
        setTurnClptIndSeq(JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", ""));
        setUsdFlg(JSPUtil.getParameter(request, prefix + "usd_flg", ""));
        setVpsRmk(JSPUtil.getParameter(request, prefix + "vps_rmk", ""));
        setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
        setVslDlayRsnLocCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_loc_cd", ""));
        setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setPhsIoRsnCd(JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setTurnSkdDirCd(JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", ""));
        setPortSkpTpCd(JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setVslDlayRsnCd(JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_cd", ""));
        setTmlVoyNo(JSPUtil.getParameter(request, prefix + "tml_voy_no", ""));
        setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
        setPlismVslCd(JSPUtil.getParameter(request, prefix + "plism_vsl_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setShpCallNo(JSPUtil.getParameter(request, prefix + "shp_call_no", ""));
        setTsPortCd(JSPUtil.getParameter(request, prefix + "ts_port_cd", ""));
        setPrtChkFlg(JSPUtil.getParameter(request, prefix + "prt_chk_flg", ""));
        setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
        setTtlDlayHrs(JSPUtil.getParameter(request, prefix + "ttl_dlay_hrs", ""));
        setFtDt(JSPUtil.getParameter(request, prefix + "ft_dt", ""));
        setPortSkpRsnOffrRmk(JSPUtil.getParameter(request, prefix + "port_skp_rsn_offr_rmk", ""));
        setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
        setPhsIoRmk(JSPUtil.getParameter(request, prefix + "phs_io_rmk", ""));
        setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
        setActInpFlg(JSPUtil.getParameter(request, prefix + "act_inp_flg", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setIbCgoQty(JSPUtil.getParameter(request, prefix + "ib_cgo_qty", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
        setDepRptInpFlg(JSPUtil.getParameter(request, prefix + "dep_rpt_inp_flg", ""));
        setAutoSkdCngFlg(JSPUtil.getParameter(request, prefix + "auto_skd_cng_flg", ""));
        setLnkSpd(JSPUtil.getParameter(request, prefix + "lnk_spd", ""));
        setSeaBufHrs(JSPUtil.getParameter(request, prefix + "sea_buf_hrs", ""));
        setPortBufHrs(JSPUtil.getParameter(request, prefix + "port_buf_hrs", ""));
        setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
        setPortWrkHrs(JSPUtil.getParameter(request, prefix + "port_wrk_hrs", ""));
        setLnkDist(JSPUtil.getParameter(request, prefix + "lnk_dist", ""));
        setMnvrOutHrs(JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", ""));
        setMnvrInHrs(JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", ""));
        setAddVtPortSeq(JSPUtil.getParameter(request, prefix + "add_vt_port_seq", ""));
        setAddVtPortFlg(JSPUtil.getParameter(request, prefix + "add_vt_port_flg", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setVtAddCallFlg(JSPUtil.getParameter(request, "vt_add_call_flg", ""));
        setCssmVoyInitCreFlg(JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", ""));
        setCssmVoyInitCreFlg(JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", ""));
        setVslRenmOldVslCd(JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_cd", ""));
        setVslRenmOldVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_eng_nm", ""));
        setVslRenmNewVslCd(JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_cd", ""));
        setVslRenmNewVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_eng_nm", ""));
        setVsldWks(JSPUtil.getParameter(request, prefix + "vsld_wks", ""));
        setAddCallFlg(JSPUtil.getParameter(request, prefix + "add_call_flg", ""));
        setSkpCallFlg(JSPUtil.getParameter(request, prefix + "skp_call_flg", ""));
        setClptIndSeq2(JSPUtil.getParameter(request, prefix + "clpt_ind_seq2", ""));
        setAddCallXterFlg(JSPUtil.getParameter(request, prefix + "add_call_xter_flg", ""));
        setPrivCallFlg(JSPUtil.getParameter(request, prefix + "priv_call_flg", ""));
        setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setTurnIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "turn_ib_cssm_voy_no", ""));
        setFirstTurnPortClptSeq(JSPUtil.getParameter(request, prefix + "first_turn_port_clpt_seq", ""));
        setBkgVvdKnd(JSPUtil.getParameter(request, prefix + "bkg_vvd_knd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslPortSkdVO[]
	 */
    public VslPortSkdVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return VslPortSkdVO[]
	 */
    public VslPortSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VslPortSkdVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ofcInpFlg = (JSPUtil.getParameter(request, prefix + "ofc_inp_flg", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] crnWrkCmplDt = (JSPUtil.getParameter(request, prefix + "crn_wrk_cmpl_dt", length));
            String[] plismVoyNo = (JSPUtil.getParameter(request, prefix + "plism_voy_no", length));
            String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix + "turn_skd_voy_no", length));
            String[] initSkdInpFlg = (JSPUtil.getParameter(request, prefix + "init_skd_inp_flg", length));
            String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", length));
            String[] cngInd = (JSPUtil.getParameter(request, prefix + "cng_ind", length));
            String[] skdBrthNo = (JSPUtil.getParameter(request, prefix + "skd_brth_no", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] portSkdStsCd = (JSPUtil.getParameter(request, prefix + "port_skd_sts_cd", length));
            String[] noonRptInpFlg = (JSPUtil.getParameter(request, prefix + "noon_rpt_inp_flg", length));
            String[] vslDlayRsnDesc = (JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_desc", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] newClptIndSeq = (JSPUtil.getParameter(request, prefix + "new_clpt_ind_seq", length));
            String[] crnWrkCmncDt = (JSPUtil.getParameter(request, prefix + "crn_wrk_cmnc_dt", length));
            String[] initEtaDt = (JSPUtil.getParameter(request, prefix + "init_eta_dt", length));
            String[] shpCallNoUpdUsrId = (JSPUtil.getParameter(request, prefix + "shp_call_no_upd_usr_id", length));
            String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix + "vps_etd_dt", length));
            String[] skdInd = (JSPUtil.getParameter(request, prefix + "skd_ind", length));
            String[] initEtbDt = (JSPUtil.getParameter(request, prefix + "init_etb_dt", length));
            String[] obCgoQty = (JSPUtil.getParameter(request, prefix + "ob_cgo_qty", length));
            String[] portSkpRsnCd = (JSPUtil.getParameter(request, prefix + "port_skp_rsn_cd", length));
            String[] plismYdCd = (JSPUtil.getParameter(request, prefix + "plism_yd_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] tmlVslCd = (JSPUtil.getParameter(request, prefix + "tml_vsl_cd", length));
            String[] initEtdDt = (JSPUtil.getParameter(request, prefix + "init_etd_dt", length));
            String[] ediSndKnt = (JSPUtil.getParameter(request, prefix + "edi_snd_knt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix + "skd_cng_sts_cd", length));
            String[] shpCallNoUpdDt = (JSPUtil.getParameter(request, prefix + "shp_call_no_upd_dt", length));
            String[] turnClptIndSeq = (JSPUtil.getParameter(request, prefix + "turn_clpt_ind_seq", length));
            String[] usdFlg = (JSPUtil.getParameter(request, prefix + "usd_flg", length));
            String[] vpsRmk = (JSPUtil.getParameter(request, prefix + "vps_rmk", length));
            String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix + "vps_etb_dt", length));
            String[] vslDlayRsnLocCd = (JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_loc_cd", length));
            String[] turnPortFlg = (JSPUtil.getParameter(request, prefix + "turn_port_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] phsIoRsnCd = (JSPUtil.getParameter(request, prefix + "phs_io_rsn_cd", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix + "turn_skd_dir_cd", length));
            String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] vslDlayRsnCd = (JSPUtil.getParameter(request, prefix + "vsl_dlay_rsn_cd", length));
            String[] tmlVoyNo = (JSPUtil.getParameter(request, prefix + "tml_voy_no", length));
            String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", length));
            String[] plismVslCd = (JSPUtil.getParameter(request, prefix + "plism_vsl_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] shpCallNo = (JSPUtil.getParameter(request, prefix + "shp_call_no", length));
            String[] tsPortCd = (JSPUtil.getParameter(request, prefix + "ts_port_cd", length));
            String[] prtChkFlg = (JSPUtil.getParameter(request, prefix + "prt_chk_flg", length));
            String[] pfEtdDt = (JSPUtil.getParameter(request, prefix + "pf_etd_dt", length));
            String[] ttlDlayHrs = (JSPUtil.getParameter(request, prefix + "ttl_dlay_hrs", length));
            String[] ftDt = (JSPUtil.getParameter(request, prefix + "ft_dt", length));
            String[] portSkpRsnOffrRmk = (JSPUtil.getParameter(request, prefix + "port_skp_rsn_offr_rmk", length));
            String[] pfEtaDt = (JSPUtil.getParameter(request, prefix + "pf_eta_dt", length));
            String[] phsIoRmk = (JSPUtil.getParameter(request, prefix + "phs_io_rmk", length));
            String[] pfEtbDt = (JSPUtil.getParameter(request, prefix + "pf_etb_dt", length));
            String[] actInpFlg = (JSPUtil.getParameter(request, prefix + "act_inp_flg", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] ibCgoQty = (JSPUtil.getParameter(request, prefix + "ib_cgo_qty", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] clptIndSeq = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq", length));
            String[] depRptInpFlg = (JSPUtil.getParameter(request, prefix + "dep_rpt_inp_flg", length));
            String[] autoSkdCngFlg = (JSPUtil.getParameter(request, prefix + "auto_skd_cng_flg", length));
            String[] lnkSpd = (JSPUtil.getParameter(request, prefix + "lnk_spd", length));
            String[] seaBufHrs = (JSPUtil.getParameter(request, prefix + "sea_buf_hrs", length));
            String[] portBufHrs = (JSPUtil.getParameter(request, prefix + "port_buf_hrs", length));
            String[] tztmHrs = (JSPUtil.getParameter(request, prefix + "tztm_hrs", length));
            String[] portWrkHrs = (JSPUtil.getParameter(request, prefix + "port_wrk_hrs", length));
            String[] lnkDist = (JSPUtil.getParameter(request, prefix + "lnk_dist", length));
            String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", length));
            String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", length));
            String[] addVtPortSeq = (JSPUtil.getParameter(request, prefix + "add_vt_port_seq", length));
            String[] addVtPortFlg = (JSPUtil.getParameter(request, prefix + "add_vt_port_flg", length));
            String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] vtAddCallFlg = (JSPUtil.getParameter(request, prefix + "vt_add_call_flg".trim(), length));
            String[] cssmVoyInitCreFlg = (JSPUtil.getParameter(request, prefix + "cssm_voy_init_cre_flg", length));
            String[] vslRenmOldVslCd = (JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_cd", length));
            String[] vslRenmOldVslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_renm_old_vsl_eng_nm", length));
            String[] vslRenmNewVslCd = (JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_cd", length));
            String[] vslRenmNewVslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_renm_new_vsl_eng_nm", length));
            String[] vsldWks = (JSPUtil.getParameter(request, prefix + "vsld_wks", length));
            String[] addCallFlg = (JSPUtil.getParameter(request, prefix + "add_call_flg", length));
            String[] skpCallFlg = (JSPUtil.getParameter(request, prefix + "skp_call_flg", length));
            String[] clptIndSeq2 = (JSPUtil.getParameter(request, prefix + "clpt_ind_seq2", length));
            String[] addCallXterFlg = (JSPUtil.getParameter(request, prefix + "add_call_xter_flg", length));
            String[] privCallFlg = (JSPUtil.getParameter(request, prefix + "priv_call_flg", length));
            String[] turnIbCssmVoyNo = (JSPUtil.getParameter(request, prefix + "turn_ib_cssm_voy_no", length));
            String[] firstTurnPortClptSeq = (JSPUtil.getParameter(request, prefix + "first_turn_port_clpt_seq", length));
            String[] bkgVvdKnd = (JSPUtil.getParameter(request, prefix + "bkg_vvd_knd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VslPortSkdVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ofcInpFlg[i] != null)
                    model.setOfcInpFlg(ofcInpFlg[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (crnWrkCmplDt[i] != null)
                    model.setCrnWrkCmplDt(crnWrkCmplDt[i]);
                if (plismVoyNo[i] != null)
                    model.setPlismVoyNo(plismVoyNo[i]);
                if (turnSkdVoyNo[i] != null)
                    model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
                if (initSkdInpFlg[i] != null)
                    model.setInitSkdInpFlg(initSkdInpFlg[i]);
                if (turnPortIndCd[i] != null)
                    model.setTurnPortIndCd(turnPortIndCd[i]);
                if (cngInd[i] != null)
                    model.setCngInd(cngInd[i]);
                if (skdBrthNo[i] != null)
                    model.setSkdBrthNo(skdBrthNo[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (portSkdStsCd[i] != null)
                    model.setPortSkdStsCd(portSkdStsCd[i]);
                if (noonRptInpFlg[i] != null)
                    model.setNoonRptInpFlg(noonRptInpFlg[i]);
                if (vslDlayRsnDesc[i] != null)
                    model.setVslDlayRsnDesc(vslDlayRsnDesc[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (newClptIndSeq[i] != null)
                    model.setNewClptIndSeq(newClptIndSeq[i]);
                if (crnWrkCmncDt[i] != null)
                    model.setCrnWrkCmncDt(crnWrkCmncDt[i]);
                if (initEtaDt[i] != null)
                    model.setInitEtaDt(initEtaDt[i]);
                if (shpCallNoUpdUsrId[i] != null)
                    model.setShpCallNoUpdUsrId(shpCallNoUpdUsrId[i]);
                if (vpsEtdDt[i] != null)
                    model.setVpsEtdDt(vpsEtdDt[i]);
                if (skdInd[i] != null)
                    model.setSkdInd(skdInd[i]);
                if (initEtbDt[i] != null)
                    model.setInitEtbDt(initEtbDt[i]);
                if (obCgoQty[i] != null)
                    model.setObCgoQty(obCgoQty[i]);
                if (portSkpRsnCd[i] != null)
                    model.setPortSkpRsnCd(portSkpRsnCd[i]);
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
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (skdCngStsCd[i] != null)
                    model.setSkdCngStsCd(skdCngStsCd[i]);
                if (shpCallNoUpdDt[i] != null)
                    model.setShpCallNoUpdDt(shpCallNoUpdDt[i]);
                if (turnClptIndSeq[i] != null)
                    model.setTurnClptIndSeq(turnClptIndSeq[i]);
                if (usdFlg[i] != null)
                    model.setUsdFlg(usdFlg[i]);
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
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (turnSkdDirCd[i] != null)
                    model.setTurnSkdDirCd(turnSkdDirCd[i]);
                if (portSkpTpCd[i] != null)
                    model.setPortSkpTpCd(portSkpTpCd[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (vslDlayRsnCd[i] != null)
                    model.setVslDlayRsnCd(vslDlayRsnCd[i]);
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
                if (autoSkdCngFlg[i] != null)
                    model.setAutoSkdCngFlg(autoSkdCngFlg[i]);
                if (lnkSpd[i] != null)
                    model.setLnkSpd(lnkSpd[i]);
                if (seaBufHrs[i] != null)
                    model.setSeaBufHrs(seaBufHrs[i]);
                if (portBufHrs[i] != null)
                    model.setPortBufHrs(portBufHrs[i]);
                if (tztmHrs[i] != null)
                    model.setTztmHrs(tztmHrs[i]);
                if (portWrkHrs[i] != null)
                    model.setPortWrkHrs(portWrkHrs[i]);
                if (lnkDist[i] != null)
                    model.setLnkDist(lnkDist[i]);
                if (mnvrOutHrs[i] != null)
                    model.setMnvrOutHrs(mnvrOutHrs[i]);
                if (mnvrInHrs[i] != null)
                    model.setMnvrInHrs(mnvrInHrs[i]);
                if (addVtPortSeq[i] != null)
                    model.setAddVtPortSeq(addVtPortSeq[i]);
                if (addVtPortFlg[i] != null)
                    model.setAddVtPortFlg(addVtPortFlg[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (vtAddCallFlg[i] != null)
                    model.setVtAddCallFlg(vtAddCallFlg[i]);
                if (cssmVoyInitCreFlg[i] != null)
                    model.setCssmVoyInitCreFlg(cssmVoyInitCreFlg[i]);
                if (vslRenmOldVslCd[i] != null)
                    model.setVslRenmOldVslCd(vslRenmOldVslCd[i]);
                if (vslRenmOldVslEngNm[i] != null)
                    model.setVslRenmOldVslEngNm(vslRenmOldVslEngNm[i]);
                if (vslRenmNewVslCd[i] != null)
                    model.setVslRenmNewVslCd(vslRenmNewVslCd[i]);
                if (vslRenmNewVslEngNm[i] != null)
                    model.setVslRenmNewVslEngNm(vslRenmNewVslEngNm[i]);
                if (vsldWks[i] != null)
                    model.setVsldWks(vsldWks[i]);
                if (addCallFlg[i] != null)
                    model.setAddCallFlg(addCallFlg[i]);
                if (skpCallFlg[i] != null)
                    model.setSkpCallFlg(skpCallFlg[i]);
                if (clptIndSeq2[i] != null)
                    model.setClptIndSeq2(clptIndSeq2[i]);
                if (addCallXterFlg[i] != null)
                    model.setAddCallXterFlg(addCallXterFlg[i]);
                if (privCallFlg[i] != null)
                    model.setPrivCallFlg(privCallFlg[i]);
                if (ibCssmVoyNo[i] != null)
                    model.setIbCssmVoyNo(ibCssmVoyNo[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (turnIbCssmVoyNo[i] != null)
                    model.setTurnIbCssmVoyNo(turnIbCssmVoyNo[i]);
                if (firstTurnPortClptSeq[i] != null)
                    model.setFirstTurnPortClptSeq(firstTurnPortClptSeq[i]);
                if (bkgVvdKnd[i] != null) 
		    		model.setBkgVvdKnd(bkgVvdKnd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVslPortSkdVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return VslPortSkdVO[]
	 */
    public VslPortSkdVO[] getVslPortSkdVOs() {
        VslPortSkdVO[] vos = (VslPortSkdVO[]) models.toArray(new VslPortSkdVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
    public void unDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcInpFlg = this.ofcInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crnWrkCmplDt = this.crnWrkCmplDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plismVoyNo = this.plismVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdVoyNo = this.turnSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initSkdInpFlg = this.initSkdInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortIndCd = this.turnPortIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cngInd = this.cngInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdBrthNo = this.skdBrthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkdStsCd = this.portSkdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noonRptInpFlg = this.noonRptInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDlayRsnDesc = this.vslDlayRsnDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.newClptIndSeq = this.newClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crnWrkCmncDt = this.crnWrkCmncDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtaDt = this.initEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNoUpdUsrId = this.shpCallNoUpdUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtdDt = this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdInd = this.skdInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtbDt = this.initEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCgoQty = this.obCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkpRsnCd = this.portSkpRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plismYdCd = this.plismYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlVslCd = this.tmlVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.initEtdDt = this.initEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediSndKnt = this.ediSndKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdCngStsCd = this.skdCngStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNoUpdDt = this.shpCallNoUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnClptIndSeq = this.turnClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdFlg = this.usdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsRmk = this.vpsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtbDt = this.vpsEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDlayRsnLocCd = this.vslDlayRsnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnPortFlg = this.turnPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phsIoRsnCd = this.phsIoRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnSkdDirCd = this.turnSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkpTpCd = this.portSkpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDlayRsnCd = this.vslDlayRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlVoyNo = this.tmlVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callYdIndSeq = this.callYdIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.plismVslCd = this.plismVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNo = this.shpCallNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsPortCd = this.tsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prtChkFlg = this.prtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtdDt = this.pfEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDlayHrs = this.ttlDlayHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDt = this.ftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portSkpRsnOffrRmk = this.portSkpRsnOffrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtaDt = this.pfEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phsIoRmk = this.phsIoRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfEtbDt = this.pfEtbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actInpFlg = this.actInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCgoQty = this.ibCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq = this.clptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.depRptInpFlg = this.depRptInpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoSkdCngFlg = this.autoSkdCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lnkSpd = this.lnkSpd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seaBufHrs = this.seaBufHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portBufHrs = this.portBufHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tztmHrs = this.tztmHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portWrkHrs = this.portWrkHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lnkDist = this.lnkDist.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnvrOutHrs = this.mnvrOutHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnvrInHrs = this.mnvrInHrs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addVtPortSeq = this.addVtPortSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addVtPortFlg = this.addVtPortFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cssmVoyInitCreFlg = this.cssmVoyInitCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cssmVoyInitCreFlg = this.cssmVoyInitCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmOldVslCd = this.vslRenmOldVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmOldVslEngNm = this.vslRenmOldVslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmNewVslCd = this.vslRenmNewVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslRenmNewVslEngNm = this.vslRenmNewVslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vsldWks = this.vsldWks.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addCallFlg = this.addCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skpCallFlg = this.skpCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptIndSeq2 = this.clptIndSeq2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.addCallXterFlg = this.addCallXterFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.privCallFlg = this.privCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibCssmVoyNo = this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.turnIbCssmVoyNo = this.turnIbCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstTurnPortClptSeq = this.firstTurnPortClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgVvdKnd = this.bkgVvdKnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
