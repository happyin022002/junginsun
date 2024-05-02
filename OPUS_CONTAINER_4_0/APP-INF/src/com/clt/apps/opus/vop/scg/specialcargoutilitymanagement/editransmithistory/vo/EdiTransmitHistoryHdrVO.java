/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EdiTransmitHistoryHdrVO.java
 *@FileTitle : EdiTransmitHistoryHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.12
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.01.12 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.editransmithistory.vo;

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
public class EdiTransmitHistoryHdrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<EdiTransmitHistoryHdrVO> models = new ArrayList<EdiTransmitHistoryHdrVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String no = null;

    /*	Column Info	*/
    private String trsmBndCd = null;

    /*	Column Info	*/
    private String trsmDt = null;

    /*	Column Info	*/
    private String spclCgoCateCd = null;

    /*	Column Info	*/
    private String prnrSpclCgoSeq = null;

    /*	Column Info	*/
    private String trsmMzdCd = null;

    /*	Column Info	*/
    private String ediSndrId = null;

    /*	Column Info	*/
    private String ediRcvrId = null;

    /*	Column Info	*/
    private String fltFileRefNo = null;

    /*	Column Info	*/
    private String ediMsgId = null;

    /*	Column Info	*/
    private String ediIfId = null;

    /*	Column Info	*/
    private String rgnShpOprCd = null;

    /*	Column Info	*/
    private String cgoOprCd = null;

    /*	Column Info	*/
    private String emlSndNo = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String etaDt = null;

    /*	Column Info	*/
    private String ediHdrMsg = null;

    /*	Column Info	*/
    private String bkgRefNo = null;

    /*	Column Info	*/
    private String bkgCreLoclDt = null;

    /*	Column Info	*/
    private String bkgCreLoclDtCtnt = null;

    /*	Column Info	*/
    private String ediMsgStsCd = null;

    /*	Column Info	*/
    private String ediMsgRefNo = null;

    /*	Column Info	*/
    private String callSgnNo = null;

    /*	Column Info	*/
    private String vslEngFullNm = null;

    /*	Column Info	*/
    private String shpCallNo = null;

    /*	Column Info	*/
    private String inBndCssmVoyNo = null;

    /*	Column Info	*/
    private String outBndCssmVoyNo = null;

    /*	Column Info	*/
    private String porCd = null;

    /*	Column Info	*/
    private String porYdCd = null;

    /*	Column Info	*/
    private String porNm = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String polClptIndSeq = null;

    /*	Column Info	*/
    private String polYdCd = null;

    /*	Column Info	*/
    private String polNm = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String podClptIndSeq = null;

    /*	Column Info	*/
    private String podYdCd = null;

    /*	Column Info	*/
    private String podNm = null;

    /*	Column Info	*/
    private String delCd = null;

    /*	Column Info	*/
    private String delYdCd = null;

    /*	Column Info	*/
    private String delNm = null;

    /*	Column Info	*/
    private String fltFileConvRsltCd = null;

    /*	Column Info	*/
    private String autoUpdRsltCd = null;

    /*	Column Info	*/
    private String aplyRsltRmk = null;

    /*	Column Info	*/
    private String lstTrsmStsCd = null;

    /*	Column Info	*/
    private String crrCd = null;

    /*	Column Info	*/
    private String mapgCrrCd = null;

    /*	Column Info	*/
    private String mapgBkgRefNo = null;

    /*	Column Info	*/
    private String mapgSpclCgoRqstSeq = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String creOfcCd = null;

    /*	Column Info	*/
    private String updOfcCd = null;

    /*	Column Info	*/
    private String errKndCd = null;

    /*	Column Info	*/
    private String errKndCorrCd = null;

    /*	Column Info	*/
    private String ctrlRefNo = null;

    /*	Column Info	*/
    private String trsmFromDt = null;

    /*	Column Info	*/
    private String trsmToDt = null;

    /*	Column Info	*/
    private String method = null;

    /*	Column Info	*/
    private String msgAckRsltCd = null;

    /*	Column Info	*/
    private String msgRjctRsn = null;

    /*	Column Info	*/
    private String orgMsgRcvrNm = null;

    /*	Column Info	*/
    private String trsmStsCd = null;

    /*	Column Info	*/
    private String orgMsgKeyNo = null;

    /*	Column Info	*/
    private String tranIfDate = null;

    /*	Column Info	*/
    private String arkIfDate = null;

    /*	Column Info	*/
    private String errDtlCd = null;

    /*	Column Info	*/
    private String errDtlRmk = null;

    /*	Column Info	*/
    private String dcgoRefNo = null;

    /* Column Info */
    private String cgoCreateStsCd = null;

    /* Column Info */
    private String ediUnmapFlg = null;

    /* Column Info */
    private String ediUnmapKndCd = null;

    /* Column Info */
    private String fltFileDatCtnt = null;

    /* Column Info */
    private String expand = null;

    /* Column Info */
    private String ediUnmapCorrCd = null;

    /* Column Info */
    private String obCssmVoyNo = null;

    /* Column Info */
    private String callSignNo = null;

    /* Column Info */
    private String lloydNo = null;

    /* Column Info */
    private String callSignLloyd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public EdiTransmitHistoryHdrVO() {
    }

    public EdiTransmitHistoryHdrVO(String ibflag, String pagerows, String no, String trsmBndCd, String trsmDt, String spclCgoCateCd, String prnrSpclCgoSeq, String trsmMzdCd, String ediSndrId, String ediRcvrId, String fltFileRefNo, String ediMsgId, String ediIfId, String rgnShpOprCd, String cgoOprCd, String emlSndNo, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String etaDt, String ediHdrMsg, String bkgRefNo, String bkgCreLoclDt, String bkgCreLoclDtCtnt, String ediMsgStsCd, String ediMsgRefNo, String callSgnNo, String lloydNo, String vslEngFullNm, String shpCallNo, String inBndCssmVoyNo, String outBndCssmVoyNo, String porCd, String porYdCd, String porNm, String polCd, String polClptIndSeq, String polYdCd, String polNm, String podCd, String podClptIndSeq, String podYdCd, String podNm, String delCd, String delYdCd, String delNm, String fltFileConvRsltCd, String autoUpdRsltCd, String aplyRsltRmk, String lstTrsmStsCd, String crrCd, String mapgCrrCd, String mapgBkgRefNo, String mapgSpclCgoRqstSeq, String creUsrId, String creDt, String updUsrId, String updDt, String creOfcCd, String updOfcCd, String errKndCd, String errKndCorrCd, String ctrlRefNo, String trsmFromDt, String trsmToDt, String method, String msgAckRsltCd, String msgRjctRsn, String orgMsgRcvrNm, String trsmStsCd, String orgMsgKeyNo, String tranIfDate, String arkIfDate, String errDtlCd, String errDtlRmk, String cgoCreateStsCd, String ediUnmapFlg, String ediUnmapKndCd, String fltFileDatCtnt, String expand, String ediUnmapCorrCd, String obCssmVoyNo, String callSignNo, String callSignLloyd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.no = no;
        this.trsmBndCd = trsmBndCd;
        this.trsmDt = trsmDt;
        this.spclCgoCateCd = spclCgoCateCd;
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
        this.trsmMzdCd = trsmMzdCd;
        this.ediSndrId = ediSndrId;
        this.ediRcvrId = ediRcvrId;
        this.fltFileRefNo = fltFileRefNo;
        this.ediMsgId = ediMsgId;
        this.ediIfId = ediIfId;
        this.rgnShpOprCd = rgnShpOprCd;
        this.cgoOprCd = cgoOprCd;
        this.emlSndNo = emlSndNo;
        this.slanCd = slanCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.etaDt = etaDt;
        this.ediHdrMsg = ediHdrMsg;
        this.bkgRefNo = bkgRefNo;
        this.bkgCreLoclDt = bkgCreLoclDt;
        this.bkgCreLoclDtCtnt = bkgCreLoclDtCtnt;
        this.ediMsgStsCd = ediMsgStsCd;
        this.ediMsgRefNo = ediMsgRefNo;
        this.callSgnNo = callSgnNo;
        this.lloydNo = lloydNo;
        this.vslEngFullNm = vslEngFullNm;
        this.shpCallNo = shpCallNo;
        this.inBndCssmVoyNo = inBndCssmVoyNo;
        this.outBndCssmVoyNo = outBndCssmVoyNo;
        this.porCd = porCd;
        this.porYdCd = porYdCd;
        this.porNm = porNm;
        this.polCd = polCd;
        this.polClptIndSeq = polClptIndSeq;
        this.polYdCd = polYdCd;
        this.polNm = polNm;
        this.podCd = podCd;
        this.podClptIndSeq = podClptIndSeq;
        this.podYdCd = podYdCd;
        this.podNm = podNm;
        this.delCd = delCd;
        this.delYdCd = delYdCd;
        this.delNm = delNm;
        this.fltFileConvRsltCd = fltFileConvRsltCd;
        this.autoUpdRsltCd = autoUpdRsltCd;
        this.aplyRsltRmk = aplyRsltRmk;
        this.lstTrsmStsCd = lstTrsmStsCd;
        this.crrCd = crrCd;
        this.mapgCrrCd = mapgCrrCd;
        this.mapgBkgRefNo = mapgBkgRefNo;
        this.mapgSpclCgoRqstSeq = mapgSpclCgoRqstSeq;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.creOfcCd = creOfcCd;
        this.updOfcCd = updOfcCd;
        this.errKndCd = errKndCd;
        this.errKndCorrCd = errKndCorrCd;
        this.ctrlRefNo = ctrlRefNo;
        this.trsmFromDt = trsmFromDt;
        this.trsmToDt = trsmToDt;
        this.method = method;
        this.msgAckRsltCd = msgAckRsltCd;
        this.msgRjctRsn = msgRjctRsn;
        this.orgMsgRcvrNm = orgMsgRcvrNm;
        this.trsmStsCd = trsmStsCd;
        this.orgMsgKeyNo = orgMsgKeyNo;
        this.tranIfDate = tranIfDate;
        this.arkIfDate = arkIfDate;
        this.errDtlCd = errDtlCd;
        this.errDtlRmk = errDtlRmk;
        this.cgoCreateStsCd = cgoCreateStsCd;
        this.ediUnmapFlg = ediUnmapFlg;
        this.ediUnmapKndCd = ediUnmapKndCd;
        this.fltFileDatCtnt = fltFileDatCtnt;
        this.expand = expand;
        this.ediUnmapCorrCd = ediUnmapCorrCd;
        this.obCssmVoyNo = obCssmVoyNo;
        this.callSignNo = callSignNo;
        this.lloydNo = lloydNo;
        this.callSignLloyd = callSignLloyd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("no", getNo());
        this.hashColumns.put("trsm_bnd_cd", getTrsmBndCd());
        this.hashColumns.put("trsm_dt", getTrsmDt());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
        this.hashColumns.put("trsm_mzd_cd", getTrsmMzdCd());
        this.hashColumns.put("edi_sndr_id", getEdiSndrId());
        this.hashColumns.put("edi_rcvr_id", getEdiRcvrId());
        this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
        this.hashColumns.put("edi_msg_id", getEdiMsgId());
        this.hashColumns.put("edi_if_id", getEdiIfId());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("eml_snd_no", getEmlSndNo());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("eta_dt", getEtaDt());
        this.hashColumns.put("edi_hdr_msg", getEdiHdrMsg());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("bkg_cre_locl_dt", getBkgCreLoclDt());
        this.hashColumns.put("bkg_cre_locl_dt_ctnt", getBkgCreLoclDtCtnt());
        this.hashColumns.put("edi_msg_sts_cd", getEdiMsgStsCd());
        this.hashColumns.put("edi_msg_ref_no", getEdiMsgRefNo());
        this.hashColumns.put("call_sgn_no", getCallSgnNo());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("vsl_eng_full_nm", getVslEngFullNm());
        this.hashColumns.put("shp_call_no", getShpCallNo());
        this.hashColumns.put("in_bnd_cssm_voy_no", getInBndCssmVoyNo());
        this.hashColumns.put("out_bnd_cssm_voy_no", getOutBndCssmVoyNo());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("por_yd_cd", getPorYdCd());
        this.hashColumns.put("por_nm", getPorNm());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("pol_nm", getPolNm());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("pod_nm", getPodNm());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("del_yd_cd", getDelYdCd());
        this.hashColumns.put("del_nm", getDelNm());
        this.hashColumns.put("flt_file_conv_rslt_cd", getFltFileConvRsltCd());
        this.hashColumns.put("auto_upd_rslt_cd", getAutoUpdRsltCd());
        this.hashColumns.put("aply_rslt_rmk", getAplyRsltRmk());
        this.hashColumns.put("lst_trsm_sts_cd", getLstTrsmStsCd());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("mapg_crr_cd", getMapgCrrCd());
        this.hashColumns.put("mapg_bkg_ref_no", getMapgBkgRefNo());
        this.hashColumns.put("mapg_spcl_cgo_rqst_seq", getMapgSpclCgoRqstSeq());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
        this.hashColumns.put("err_knd_cd", getErrKndCd());
        this.hashColumns.put("err_knd_corr_cd", getErrKndCorrCd());
        this.hashColumns.put("ctrl_ref_no", getCtrlRefNo());
        this.hashColumns.put("trsm_from_dt", getTrsmFromDt());
        this.hashColumns.put("trsm_to_dt", getTrsmToDt());
        this.hashColumns.put("method", getMethod());
        this.hashColumns.put("msg_ack_rslt_cd", getMsgAckRsltCd());
        this.hashColumns.put("msg_rjct_rsn", getMsgRjctRsn());
        this.hashColumns.put("org_msg_rcvr_nm", getOrgMsgRcvrNm());
        this.hashColumns.put("trsm_sts_cd", getTrsmStsCd());
        this.hashColumns.put("org_msg_key_no", getOrgMsgKeyNo());
        this.hashColumns.put("tran_if_date", getTranIfDate());
        this.hashColumns.put("ark_if_date", getArkIfDate());
        this.hashColumns.put("err_dtl_cd", getErrDtlCd());
        this.hashColumns.put("err_dtl_rmk", getErrDtlRmk());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("cgo_create_sts_cd", getCgoCreateStsCd());
        this.hashColumns.put("edi_unmap_flg", getEdiUnmapFlg());
        this.hashColumns.put("edi_unmap_knd_cd", getEdiUnmapKndCd());
        this.hashColumns.put("flt_file_dat_ctnt", getFltFileDatCtnt());
        this.hashColumns.put("expand", getExpand());
        this.hashColumns.put("edi_unmap_corr_cd", getEdiUnmapCorrCd());
        this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
        this.hashColumns.put("call_sign_no", getCallSignNo());
        this.hashColumns.put("lloyd_no", getLloydNo());
        this.hashColumns.put("call_sign_lloyd", getCallSignLloyd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("no", "no");
        this.hashFields.put("trsm_bnd_cd", "trsmBndCd");
        this.hashFields.put("trsm_dt", "trsmDt");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
        this.hashFields.put("trsm_mzd_cd", "trsmMzdCd");
        this.hashFields.put("edi_sndr_id", "ediSndrId");
        this.hashFields.put("edi_rcvr_id", "ediRcvrId");
        this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
        this.hashFields.put("edi_msg_id", "ediMsgId");
        this.hashFields.put("edi_if_id", "ediIfId");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("eml_snd_no", "emlSndNo");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("eta_dt", "etaDt");
        this.hashFields.put("edi_hdr_msg", "ediHdrMsg");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("bkg_cre_locl_dt", "bkgCreLoclDt");
        this.hashFields.put("bkg_cre_locl_dt_ctnt", "bkgCreLoclDtCtnt");
        this.hashFields.put("edi_msg_sts_cd", "ediMsgStsCd");
        this.hashFields.put("edi_msg_ref_no", "ediMsgRefNo");
        this.hashFields.put("call_sgn_no", "callSgnNo");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("vsl_eng_full_nm", "vslEngFullNm");
        this.hashFields.put("shp_call_no", "shpCallNo");
        this.hashFields.put("in_bnd_cssm_voy_no", "inBndCssmVoyNo");
        this.hashFields.put("out_bnd_cssm_voy_no", "outBndCssmVoyNo");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("por_yd_cd", "porYdCd");
        this.hashFields.put("por_nm", "porNm");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("pol_nm", "polNm");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("pod_nm", "podNm");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("del_yd_cd", "delYdCd");
        this.hashFields.put("del_nm", "delNm");
        this.hashFields.put("flt_file_conv_rslt_cd", "fltFileConvRsltCd");
        this.hashFields.put("auto_upd_rslt_cd", "autoUpdRsltCd");
        this.hashFields.put("aply_rslt_rmk", "aplyRsltRmk");
        this.hashFields.put("lst_trsm_sts_cd", "lstTrsmStsCd");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("mapg_crr_cd", "mapgCrrCd");
        this.hashFields.put("mapg_bkg_ref_no", "mapgBkgRefNo");
        this.hashFields.put("mapg_spcl_cgo_rqst_seq", "mapgSpclCgoRqstSeq");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("upd_ofc_cd", "updOfcCd");
        this.hashFields.put("err_knd_cd", "errKndCd");
        this.hashFields.put("err_knd_corr_cd", "errKndCorrCd");
        this.hashFields.put("ctrl_ref_no", "ctrlRefNo");
        this.hashFields.put("trsm_from_dt", "trsmFromDt");
        this.hashFields.put("trsm_to_dt", "trsmToDt");
        this.hashFields.put("method", "method");
        this.hashFields.put("msg_ack_rslt_cd", "msgAckRsltCd");
        this.hashFields.put("msg_rjct_rsn", "msgRjctRsn");
        this.hashFields.put("org_msg_rcvr_nm", "orgMsgRcvrNm");
        this.hashFields.put("trsm_sts_cd", "trsmStsCd");
        this.hashFields.put("org_msg_key_no", "orgMsgKeyNo");
        this.hashFields.put("tran_if_date", "tranIfDate");
        this.hashFields.put("ark_if_date", "arkIfDate");
        this.hashFields.put("err_dtl_cd", "errDtlCd");
        this.hashFields.put("err_dtl_rmk", "errDtlRmk");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("cgo_create_sts_cd", "cgoCreateStsCd");
        this.hashFields.put("edi_unmap_flg", "ediUnmapFlg");
        this.hashFields.put("edi_unmap_knd_cd", "ediUnmapKndCd");
        this.hashFields.put("flt_file_dat_ctnt", "fltFileDatCtnt");
        this.hashFields.put("expand", "expand");
        this.hashFields.put("edi_unmap_corr_cd", "ediUnmapCorrCd");
        this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
        this.hashFields.put("call_sign_no", "callSignNo");
        this.hashFields.put("lloyd_no", "lloydNo");
        this.hashFields.put("call_sign_lloyd", "callSignLloyd");
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
	 * @return no
	 */
    public String getNo() {
        return this.no;
    }

    /**
	 * Column Info
	 * @return trsmBndCd
	 */
    public String getTrsmBndCd() {
        return this.trsmBndCd;
    }

    /**
	 * Column Info
	 * @return trsmDt
	 */
    public String getTrsmDt() {
        return this.trsmDt;
    }

    /**
	 * Column Info
	 * @return spclCgoCateCd
	 */
    public String getSpclCgoCateCd() {
        return this.spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @return prnrSpclCgoSeq
	 */
    public String getPrnrSpclCgoSeq() {
        return this.prnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @return trsmMzdCd
	 */
    public String getTrsmMzdCd() {
        return this.trsmMzdCd;
    }

    /**
	 * Column Info
	 * @return ediSndrId
	 */
    public String getEdiSndrId() {
        return this.ediSndrId;
    }

    /**
	 * Column Info
	 * @return ediRcvrId
	 */
    public String getEdiRcvrId() {
        return this.ediRcvrId;
    }

    /**
	 * Column Info
	 * @return fltFileRefNo
	 */
    public String getFltFileRefNo() {
        return this.fltFileRefNo;
    }

    /**
	 * Column Info
	 * @return ediMsgId
	 */
    public String getEdiMsgId() {
        return this.ediMsgId;
    }

    /**
	 * Column Info
	 * @return ediIfId
	 */
    public String getEdiIfId() {
        return this.ediIfId;
    }

    /**
	 * Column Info
	 * @return rgnShpOprCd
	 */
    public String getRgnShpOprCd() {
        return this.rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @return cgoOprCd
	 */
    public String getCgoOprCd() {
        return this.cgoOprCd;
    }

    /**
	 * Column Info
	 * @return emlSndNo
	 */
    public String getEmlSndNo() {
        return this.emlSndNo;
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
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
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return etaDt
	 */
    public String getEtaDt() {
        return this.etaDt;
    }

    /**
	 * Column Info
	 * @return ediHdrMsg
	 */
    public String getEdiHdrMsg() {
        return this.ediHdrMsg;
    }

    /**
	 * Column Info
	 * @return bkgRefNo
	 */
    public String getBkgRefNo() {
        return this.bkgRefNo;
    }

    /**
	 * Column Info
	 * @return bkgCreLoclDt
	 */
    public String getBkgCreLoclDt() {
        return this.bkgCreLoclDt;
    }

    /**
	 * Column Info
	 * @return bkgCreLoclDtCtnt
	 */
    public String getBkgCreLoclDtCtnt() {
        return this.bkgCreLoclDtCtnt;
    }

    /**
	 * Column Info
	 * @return ediMsgStsCd
	 */
    public String getEdiMsgStsCd() {
        return this.ediMsgStsCd;
    }

    /**
	 * Column Info
	 * @return ediMsgRefNo
	 */
    public String getEdiMsgRefNo() {
        return this.ediMsgRefNo;
    }

    /**
	 * Column Info
	 * @return callSgnNo
	 */
    public String getCallSgnNo() {
        return this.callSgnNo;
    }

    /**
	 * Column Info
	 * @return vslEngFullNm
	 */
    public String getVslEngFullNm() {
        return this.vslEngFullNm;
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
	 * @return inBndCssmVoyNo
	 */
    public String getInBndCssmVoyNo() {
        return this.inBndCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return outBndCssmVoyNo
	 */
    public String getOutBndCssmVoyNo() {
        return this.outBndCssmVoyNo;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return porYdCd
	 */
    public String getPorYdCd() {
        return this.porYdCd;
    }

    /**
	 * Column Info
	 * @return porNm
	 */
    public String getPorNm() {
        return this.porNm;
    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return polClptIndSeq
	 */
    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    /**
	 * Column Info
	 * @return polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
    }

    /**
	 * Column Info
	 * @return polNm
	 */
    public String getPolNm() {
        return this.polNm;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
    }

    /**
	 * Column Info
	 * @return podClptIndSeq
	 */
    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
    }

    /**
	 * Column Info
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
    }

    /**
	 * Column Info
	 * @return podNm
	 */
    public String getPodNm() {
        return this.podNm;
    }

    /**
	 * Column Info
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
    }

    /**
	 * Column Info
	 * @return delYdCd
	 */
    public String getDelYdCd() {
        return this.delYdCd;
    }

    /**
	 * Column Info
	 * @return delNm
	 */
    public String getDelNm() {
        return this.delNm;
    }

    /**
	 * Column Info
	 * @return fltFileConvRsltCd
	 */
    public String getFltFileConvRsltCd() {
        return this.fltFileConvRsltCd;
    }

    /**
	 * Column Info
	 * @return autoUpdRsltCd
	 */
    public String getAutoUpdRsltCd() {
        return this.autoUpdRsltCd;
    }

    /**
	 * Column Info
	 * @return aplyRsltRmk
	 */
    public String getAplyRsltRmk() {
        return this.aplyRsltRmk;
    }

    /**
	 * Column Info
	 * @return lstTrsmStsCd
	 */
    public String getLstTrsmStsCd() {
        return this.lstTrsmStsCd;
    }

    /**
	 * Column Info
	 * @return crrCd
	 */
    public String getCrrCd() {
        return this.crrCd;
    }

    /**
	 * Column Info
	 * @return mapgCrrCd
	 */
    public String getMapgCrrCd() {
        return this.mapgCrrCd;
    }

    /**
	 * Column Info
	 * @return mapgBkgRefNo
	 */
    public String getMapgBkgRefNo() {
        return this.mapgBkgRefNo;
    }

    /**
	 * Column Info
	 * @return mapgSpclCgoRqstSeq
	 */
    public String getMapgSpclCgoRqstSeq() {
        return this.mapgSpclCgoRqstSeq;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
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
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    /**
	 * Column Info
	 * @return updOfcCd
	 */
    public String getUpdOfcCd() {
        return this.updOfcCd;
    }

    /**
	 * Column Info
	 * @return errKndCd
	 */
    public String getErrKndCd() {
        return this.errKndCd;
    }

    /**
	 * Column Info
	 * @return errKndCorrCd
	 */
    public String getErrKndCorrCd() {
        return this.errKndCorrCd;
    }

    /**
	 * Column Info
	 * @return ctrlRefNo
	 */
    public String getCtrlRefNo() {
        return this.ctrlRefNo;
    }

    /**
	 * Column Info
	 * @return trsmFromDt
	 */
    public String getTrsmFromDt() {
        return this.trsmFromDt;
    }

    /**
	 * Column Info
	 * @return trsmToDt
	 */
    public String getTrsmToDt() {
        return this.trsmToDt;
    }

    /**
	 * Column Info
	 * @return method
	 */
    public String getMethod() {
        return this.method;
    }

    /**
	 * Column Info
	 * @return msgAckRsltCd
	 */
    public String getMsgAckRsltCd() {
        return this.msgAckRsltCd;
    }

    /**
	 * Column Info
	 * @return msgRjctRsn
	 */
    public String getMsgRjctRsn() {
        return this.msgRjctRsn;
    }

    /**
	 * Column Info
	 * @return orgMsgRcvrNm
	 */
    public String getOrgMsgRcvrNm() {
        return this.orgMsgRcvrNm;
    }

    /**
	 * Column Info
	 * @return trsmStsCd
	 */
    public String getTrsmStsCd() {
        return this.trsmStsCd;
    }

    /**
	 * Column Info
	 * @return orgMsgKeyNo
	 */
    public String getOrgMsgKeyNo() {
        return this.orgMsgKeyNo;
    }

    /**
	 * Column Info
	 * @return tranIfDate
	 */
    public String getTranIfDate() {
        return this.tranIfDate;
    }

    /**
	 * Column Info
	 * @return arkIfDate
	 */
    public String getArkIfDate() {
        return this.arkIfDate;
    }

    /**
	 * Column Info
	 * @return errDtlCd
	 */
    public String getErrDtlCd() {
        return this.errDtlCd;
    }

    /**
	 * Column Info
	 * @return errDtlRmk
	 */
    public String getErrDtlRmk() {
        return this.errDtlRmk;
    }

    /**
	 * Column Info
	 * @return dcgoRefNo
	 */
    public String getDcgoRefNo() {
        return this.dcgoRefNo;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  dcgoRefNo
 	 */
    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
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
	 * @param  no
 	 */
    public void setNo(String no) {
        this.no = no;
    }

    /**
	 * Column Info
	 * @param  trsmBndCd
 	 */
    public void setTrsmBndCd(String trsmBndCd) {
        this.trsmBndCd = trsmBndCd;
    }

    /**
	 * Column Info
	 * @param  trsmDt
 	 */
    public void setTrsmDt(String trsmDt) {
        this.trsmDt = trsmDt;
    }

    /**
	 * Column Info
	 * @param  spclCgoCateCd
 	 */
    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param  prnrSpclCgoSeq
 	 */
    public void setPrnrSpclCgoSeq(String prnrSpclCgoSeq) {
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @param  trsmMzdCd
 	 */
    public void setTrsmMzdCd(String trsmMzdCd) {
        this.trsmMzdCd = trsmMzdCd;
    }

    /**
	 * Column Info
	 * @param  ediSndrId
 	 */
    public void setEdiSndrId(String ediSndrId) {
        this.ediSndrId = ediSndrId;
    }

    /**
	 * Column Info
	 * @param  ediRcvrId
 	 */
    public void setEdiRcvrId(String ediRcvrId) {
        this.ediRcvrId = ediRcvrId;
    }

    /**
	 * Column Info
	 * @param  fltFileRefNo
 	 */
    public void setFltFileRefNo(String fltFileRefNo) {
        this.fltFileRefNo = fltFileRefNo;
    }

    /**
	 * Column Info
	 * @param  ediMsgId
 	 */
    public void setEdiMsgId(String ediMsgId) {
        this.ediMsgId = ediMsgId;
    }

    /**
	 * Column Info
	 * @param  ediIfId
 	 */
    public void setEdiIfId(String ediIfId) {
        this.ediIfId = ediIfId;
    }

    /**
	 * Column Info
	 * @param  rgnShpOprCd
 	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @param  cgoOprCd
 	 */
    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
    }

    /**
	 * Column Info
	 * @param  emlSndNo
 	 */
    public void setEmlSndNo(String emlSndNo) {
        this.emlSndNo = emlSndNo;
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
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
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
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  etaDt
 	 */
    public void setEtaDt(String etaDt) {
        this.etaDt = etaDt;
    }

    /**
	 * Column Info
	 * @param  ediHdrMsg
 	 */
    public void setEdiHdrMsg(String ediHdrMsg) {
        this.ediHdrMsg = ediHdrMsg;
    }

    /**
	 * Column Info
	 * @param  bkgRefNo
 	 */
    public void setBkgRefNo(String bkgRefNo) {
        this.bkgRefNo = bkgRefNo;
    }

    /**
	 * Column Info
	 * @param  bkgCreLoclDt
 	 */
    public void setBkgCreLoclDt(String bkgCreLoclDt) {
        this.bkgCreLoclDt = bkgCreLoclDt;
    }

    /**
	 * Column Info
	 * @param  bkgCreLoclDtCtnt
 	 */
    public void setBkgCreLoclDtCtnt(String bkgCreLoclDtCtnt) {
        this.bkgCreLoclDtCtnt = bkgCreLoclDtCtnt;
    }

    /**
	 * Column Info
	 * @param  ediMsgStsCd
 	 */
    public void setEdiMsgStsCd(String ediMsgStsCd) {
        this.ediMsgStsCd = ediMsgStsCd;
    }

    /**
	 * Column Info
	 * @param  ediMsgRefNo
 	 */
    public void setEdiMsgRefNo(String ediMsgRefNo) {
        this.ediMsgRefNo = ediMsgRefNo;
    }

    /**
	 * Column Info
	 * @param  callSgnNo
 	 */
    public void setCallSgnNo(String callSgnNo) {
        this.callSgnNo = callSgnNo;
    }

    /**
	 * Column Info
	 * @param  vslEngFullNm
 	 */
    public void setVslEngFullNm(String vslEngFullNm) {
        this.vslEngFullNm = vslEngFullNm;
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
	 * @param  inBndCssmVoyNo
 	 */
    public void setInBndCssmVoyNo(String inBndCssmVoyNo) {
        this.inBndCssmVoyNo = inBndCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param  outBndCssmVoyNo
 	 */
    public void setOutBndCssmVoyNo(String outBndCssmVoyNo) {
        this.outBndCssmVoyNo = outBndCssmVoyNo;
    }

    /**
	 * Column Info
	 * @param  porCd
 	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param  porYdCd
 	 */
    public void setPorYdCd(String porYdCd) {
        this.porYdCd = porYdCd;
    }

    /**
	 * Column Info
	 * @param  porNm
 	 */
    public void setPorNm(String porNm) {
        this.porNm = porNm;
    }

    /**
	 * Column Info
	 * @param  polCd
 	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param  polClptIndSeq
 	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  polYdCd
 	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
    }

    /**
	 * Column Info
	 * @param  polNm
 	 */
    public void setPolNm(String polNm) {
        this.polNm = polNm;
    }

    /**
	 * Column Info
	 * @param  podCd
 	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param  podClptIndSeq
 	 */
    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    /**
	 * Column Info
	 * @param  podYdCd
 	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
    }

    /**
	 * Column Info
	 * @param  podNm
 	 */
    public void setPodNm(String podNm) {
        this.podNm = podNm;
    }

    /**
	 * Column Info
	 * @param  delCd
 	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param  delYdCd
 	 */
    public void setDelYdCd(String delYdCd) {
        this.delYdCd = delYdCd;
    }

    /**
	 * Column Info
	 * @param  delNm
 	 */
    public void setDelNm(String delNm) {
        this.delNm = delNm;
    }

    /**
	 * Column Info
	 * @param  fltFileConvRsltCd
 	 */
    public void setFltFileConvRsltCd(String fltFileConvRsltCd) {
        this.fltFileConvRsltCd = fltFileConvRsltCd;
    }

    /**
	 * Column Info
	 * @param  autoUpdRsltCd
 	 */
    public void setAutoUpdRsltCd(String autoUpdRsltCd) {
        this.autoUpdRsltCd = autoUpdRsltCd;
    }

    /**
	 * Column Info
	 * @param  aplyRsltRmk
 	 */
    public void setAplyRsltRmk(String aplyRsltRmk) {
        this.aplyRsltRmk = aplyRsltRmk;
    }

    /**
	 * Column Info
	 * @param  lstTrsmStsCd
 	 */
    public void setLstTrsmStsCd(String lstTrsmStsCd) {
        this.lstTrsmStsCd = lstTrsmStsCd;
    }

    /**
	 * Column Info
	 * @param  crrCd
 	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * Column Info
	 * @param  mapgCrrCd
 	 */
    public void setMapgCrrCd(String mapgCrrCd) {
        this.mapgCrrCd = mapgCrrCd;
    }

    /**
	 * Column Info
	 * @param  mapgBkgRefNo
 	 */
    public void setMapgBkgRefNo(String mapgBkgRefNo) {
        this.mapgBkgRefNo = mapgBkgRefNo;
    }

    /**
	 * Column Info
	 * @param  mapgSpclCgoRqstSeq
 	 */
    public void setMapgSpclCgoRqstSeq(String mapgSpclCgoRqstSeq) {
        this.mapgSpclCgoRqstSeq = mapgSpclCgoRqstSeq;
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
	 * @param  creDt
 	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
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
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * Column Info
	 * @param  creOfcCd
 	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    /**
	 * Column Info
	 * @param  updOfcCd
 	 */
    public void setUpdOfcCd(String updOfcCd) {
        this.updOfcCd = updOfcCd;
    }

    /**
	 * Column Info
	 * @param  errKndCd
 	 */
    public void setErrKndCd(String errKndCd) {
        this.errKndCd = errKndCd;
    }

    /**
	 * Column Info
	 * @param  errKndCorrCd
 	 */
    public void setErrKndCorrCd(String errKndCorrCd) {
        this.errKndCorrCd = errKndCorrCd;
    }

    /**
	 * Column Info
	 * @param  ctrlRefNo
 	 */
    public void setCtrlRefNo(String ctrlRefNo) {
        this.ctrlRefNo = ctrlRefNo;
    }

    /**
	 * Column Info
	 * @param  trsmFromDt
 	 */
    public void setTrsmFromDt(String trsmFromDt) {
        this.trsmFromDt = trsmFromDt;
    }

    /**
	 * Column Info
	 * @param  trsmToDt
 	 */
    public void setTrsmToDt(String trsmToDt) {
        this.trsmToDt = trsmToDt;
    }

    /**
	 * Column Info
	 * @param  method
 	 */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
	 * Column Info
	 * @param  msgAckRsltCd
 	 */
    public void setMsgAckRsltCd(String msgAckRsltCd) {
        this.msgAckRsltCd = msgAckRsltCd;
    }

    /**
	 * Column Info
	 * @param  msgRjctRsn
 	 */
    public void setMsgRjctRsn(String msgRjctRsn) {
        this.msgRjctRsn = msgRjctRsn;
    }

    /**
	 * Column Info
	 * @param  orgMsgRcvrNm
 	 */
    public void setOrgMsgRcvrNm(String orgMsgRcvrNm) {
        this.orgMsgRcvrNm = orgMsgRcvrNm;
    }

    /**
	 * Column Info
	 * @param  trsmStsCd
 	 */
    public void setTrsmStsCd(String trsmStsCd) {
        this.trsmStsCd = trsmStsCd;
    }

    /**
	 * Column Info
	 * @param  orgMsgKeyNo
 	 */
    public void setOrgMsgKeyNo(String orgMsgKeyNo) {
        this.orgMsgKeyNo = orgMsgKeyNo;
    }

    /**
	 * Column Info
	 * @param  tranIfDate
 	 */
    public void setTranIfDate(String tranIfDate) {
        this.tranIfDate = tranIfDate;
    }

    /**
	 * Column Info
	 * @param  arkIfDate
 	 */
    public void setArkIfDate(String arkIfDate) {
        this.arkIfDate = arkIfDate;
    }

    /**
	 * Column Info
	 * @param  errDtlCd
 	 */
    public void setErrDtlCd(String errDtlCd) {
        this.errDtlCd = errDtlCd;
    }

    /**
	 * Column Info
	 * @param  errDtlRmk
 	 */
    public void setErrDtlRmk(String errDtlRmk) {
        this.errDtlRmk = errDtlRmk;
    }

    public void setCgoCreateStsCd(String cgoCreateStsCd) {
        this.cgoCreateStsCd = cgoCreateStsCd;
    }

    public String getCgoCreateStsCd() {
        return this.cgoCreateStsCd;
    }

    public void setEdiUnmapFlg(String ediUnmapFlg) {
        this.ediUnmapFlg = ediUnmapFlg;
    }

    public String getEdiUnmapFlg() {
        return this.ediUnmapFlg;
    }

    public void setEdiUnmapKndCd(String ediUnmapKndCd) {
        this.ediUnmapKndCd = ediUnmapKndCd;
    }

    public String getEdiUnmapKndCd() {
        return this.ediUnmapKndCd;
    }

    public void setFltFileDatCtnt(String fltFileDatCtnt) {
        this.fltFileDatCtnt = fltFileDatCtnt;
    }

    public String getFltFileDatCtnt() {
        return this.fltFileDatCtnt;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getExpand() {
        return this.expand;
    }

    public void setEdiUnmapCorrCd(String ediUnmapCorrCd) {
        this.ediUnmapCorrCd = ediUnmapCorrCd;
    }

    public String getEdiUnmapCorrCd() {
        return this.ediUnmapCorrCd;
    }

    public void setObCssmVoyNo(String obCssmVoyNo) {
        this.obCssmVoyNo = obCssmVoyNo;
    }

    public String getObCssmVoyNo() {
        return this.obCssmVoyNo;
    }

    public void setCallSignNo(String callSignNo) {
        this.callSignNo = callSignNo;
    }

    public String getCallSignNo() {
        return this.callSignNo;
    }

    public void setLloydNo(String lloydNo) {
        this.lloydNo = lloydNo;
    }

    public String getLloydNo() {
        return this.lloydNo;
    }

    public void setCallSignLloyd(String callSignLloyd) {
        this.callSignLloyd = callSignLloyd;
    }

    public String getCallSignLloyd() {
        return this.callSignLloyd;
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
        setNo(JSPUtil.getParameter(request, prefix + "no", ""));
        setTrsmBndCd(JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", ""));
        setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
        setTrsmMzdCd(JSPUtil.getParameter(request, prefix + "trsm_mzd_cd", ""));
        setEdiSndrId(JSPUtil.getParameter(request, prefix + "edi_sndr_id", ""));
        setEdiRcvrId(JSPUtil.getParameter(request, prefix + "edi_rcvr_id", ""));
        setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
        setEdiMsgId(JSPUtil.getParameter(request, prefix + "edi_msg_id", ""));
        setEdiIfId(JSPUtil.getParameter(request, prefix + "edi_if_id", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
        setEdiHdrMsg(JSPUtil.getParameter(request, prefix + "edi_hdr_msg", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setBkgCreLoclDt(JSPUtil.getParameter(request, prefix + "bkg_cre_locl_dt", ""));
        setBkgCreLoclDtCtnt(JSPUtil.getParameter(request, prefix + "bkg_cre_locl_dt_ctnt", ""));
        setEdiMsgStsCd(JSPUtil.getParameter(request, prefix + "edi_msg_sts_cd", ""));
        setEdiMsgRefNo(JSPUtil.getParameter(request, prefix + "edi_msg_ref_no", ""));
        setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setVslEngFullNm(JSPUtil.getParameter(request, prefix + "vsl_eng_full_nm", ""));
        setShpCallNo(JSPUtil.getParameter(request, prefix + "shp_call_no", ""));
        setInBndCssmVoyNo(JSPUtil.getParameter(request, prefix + "in_bnd_cssm_voy_no", ""));
        setOutBndCssmVoyNo(JSPUtil.getParameter(request, prefix + "out_bnd_cssm_voy_no", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
        setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setDelYdCd(JSPUtil.getParameter(request, prefix + "del_yd_cd", ""));
        setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
        setFltFileConvRsltCd(JSPUtil.getParameter(request, prefix + "flt_file_conv_rslt_cd", ""));
        setAutoUpdRsltCd(JSPUtil.getParameter(request, prefix + "auto_upd_rslt_cd", ""));
        setAplyRsltRmk(JSPUtil.getParameter(request, prefix + "aply_rslt_rmk", ""));
        setLstTrsmStsCd(JSPUtil.getParameter(request, prefix + "lst_trsm_sts_cd", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setMapgCrrCd(JSPUtil.getParameter(request, prefix + "mapg_crr_cd", ""));
        setMapgBkgRefNo(JSPUtil.getParameter(request, prefix + "mapg_bkg_ref_no", ""));
        setMapgSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "mapg_spcl_cgo_rqst_seq", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
        setErrKndCd(JSPUtil.getParameter(request, prefix + "err_knd_cd", ""));
        setErrKndCorrCd(JSPUtil.getParameter(request, prefix + "err_knd_corr_cd", ""));
        setCtrlRefNo(JSPUtil.getParameter(request, prefix + "ctrl_ref_no", ""));
        setTrsmFromDt(JSPUtil.getParameter(request, prefix + "trsm_from_dt", ""));
        setTrsmToDt(JSPUtil.getParameter(request, prefix + "trsm_to_dt", ""));
        setMethod(JSPUtil.getParameter(request, prefix + "method", ""));
        setMsgAckRsltCd(JSPUtil.getParameter(request, prefix + "msg_ack_rslt_cd", ""));
        setMsgRjctRsn(JSPUtil.getParameter(request, prefix + "msg_rjct_rsn", ""));
        setOrgMsgRcvrNm(JSPUtil.getParameter(request, prefix + "org_msg_rcvr_nm", ""));
        setTrsmStsCd(JSPUtil.getParameter(request, prefix + "trsm_sts_cd", ""));
        setOrgMsgKeyNo(JSPUtil.getParameter(request, prefix + "org_msg_key_no", ""));
        setTranIfDate(JSPUtil.getParameter(request, prefix + "tran_if_date", ""));
        setArkIfDate(JSPUtil.getParameter(request, prefix + "ark_if_date", ""));
        setErrDtlCd(JSPUtil.getParameter(request, prefix + "err_dtl_cd", ""));
        setErrDtlRmk(JSPUtil.getParameter(request, prefix + "err_dtl_rmk", ""));
        setCgoCreateStsCd(JSPUtil.getParameter(request, prefix + "cgo_create_sts_cd", ""));
        setEdiUnmapFlg(JSPUtil.getParameter(request, prefix + "edi_unmap_flg", ""));
        setEdiUnmapKndCd(JSPUtil.getParameter(request, prefix + "edi_unmap_knd_cd", ""));
        setFltFileDatCtnt(JSPUtil.getParameter(request, prefix + "flt_file_dat_ctnt", ""));
        setExpand(JSPUtil.getParameter(request, prefix + "expand", ""));
        setEdiUnmapCorrCd(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_cd", ""));
        setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
        setCallSignNo(JSPUtil.getParameter(request, prefix + "call_sign_no", ""));
        setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
        setCallSignLloyd(JSPUtil.getParameter(request, prefix + "call_sign_lloyd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiTransmitHistoryHdrVO[]
	 */
    public EdiTransmitHistoryHdrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return EdiTransmitHistoryHdrVO[]
	 */
    public EdiTransmitHistoryHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        EdiTransmitHistoryHdrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] no = (JSPUtil.getParameter(request, prefix + "no", length));
            String[] trsmBndCd = (JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", length));
            String[] trsmDt = (JSPUtil.getParameter(request, prefix + "trsm_dt", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", length));
            String[] trsmMzdCd = (JSPUtil.getParameter(request, prefix + "trsm_mzd_cd", length));
            String[] ediSndrId = (JSPUtil.getParameter(request, prefix + "edi_sndr_id", length));
            String[] ediRcvrId = (JSPUtil.getParameter(request, prefix + "edi_rcvr_id", length));
            String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix + "flt_file_ref_no", length));
            String[] ediMsgId = (JSPUtil.getParameter(request, prefix + "edi_msg_id", length));
            String[] ediIfId = (JSPUtil.getParameter(request, prefix + "edi_if_id", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] emlSndNo = (JSPUtil.getParameter(request, prefix + "eml_snd_no", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] etaDt = (JSPUtil.getParameter(request, prefix + "eta_dt", length));
            String[] ediHdrMsg = (JSPUtil.getParameter(request, prefix + "edi_hdr_msg", length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no", length));
            String[] bkgCreLoclDt = (JSPUtil.getParameter(request, prefix + "bkg_cre_locl_dt", length));
            String[] bkgCreLoclDtCtnt = (JSPUtil.getParameter(request, prefix + "bkg_cre_locl_dt_ctnt", length));
            String[] ediMsgStsCd = (JSPUtil.getParameter(request, prefix + "edi_msg_sts_cd", length));
            String[] ediMsgRefNo = (JSPUtil.getParameter(request, prefix + "edi_msg_ref_no", length));
            String[] callSgnNo = (JSPUtil.getParameter(request, prefix + "call_sgn_no", length));
            String[] lloydNo = (JSPUtil.getParameter(request, prefix + "lloyd_no", length));
            String[] vslEngFullNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_full_nm", length));
            String[] shpCallNo = (JSPUtil.getParameter(request, prefix + "shp_call_no", length));
            String[] inBndCssmVoyNo = (JSPUtil.getParameter(request, prefix + "in_bnd_cssm_voy_no", length));
            String[] outBndCssmVoyNo = (JSPUtil.getParameter(request, prefix + "out_bnd_cssm_voy_no", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] porYdCd = (JSPUtil.getParameter(request, prefix + "por_yd_cd", length));
            String[] porNm = (JSPUtil.getParameter(request, prefix + "por_nm", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] polNm = (JSPUtil.getParameter(request, prefix + "pol_nm", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] podNm = (JSPUtil.getParameter(request, prefix + "pod_nm", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] delYdCd = (JSPUtil.getParameter(request, prefix + "del_yd_cd", length));
            String[] delNm = (JSPUtil.getParameter(request, prefix + "del_nm", length));
            String[] fltFileConvRsltCd = (JSPUtil.getParameter(request, prefix + "flt_file_conv_rslt_cd", length));
            String[] autoUpdRsltCd = (JSPUtil.getParameter(request, prefix + "auto_upd_rslt_cd", length));
            String[] aplyRsltRmk = (JSPUtil.getParameter(request, prefix + "aply_rslt_rmk", length));
            String[] lstTrsmStsCd = (JSPUtil.getParameter(request, prefix + "lst_trsm_sts_cd", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] mapgCrrCd = (JSPUtil.getParameter(request, prefix + "mapg_crr_cd", length));
            String[] mapgBkgRefNo = (JSPUtil.getParameter(request, prefix + "mapg_bkg_ref_no", length));
            String[] mapgSpclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "mapg_spcl_cgo_rqst_seq", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
            String[] errKndCd = (JSPUtil.getParameter(request, prefix + "err_knd_cd", length));
            String[] errKndCorrCd = (JSPUtil.getParameter(request, prefix + "err_knd_corr_cd", length));
            String[] ctrlRefNo = (JSPUtil.getParameter(request, prefix + "ctrl_ref_no", length));
            String[] trsmFromDt = (JSPUtil.getParameter(request, prefix + "trsm_from_dt", length));
            String[] trsmToDt = (JSPUtil.getParameter(request, prefix + "trsm_to_dt", length));
            String[] method = (JSPUtil.getParameter(request, prefix + "method", length));
            String[] msgAckRsltCd = (JSPUtil.getParameter(request, prefix + "msg_ack_rslt_cd", length));
            String[] msgRjctRsn = (JSPUtil.getParameter(request, prefix + "msg_rjct_rsn", length));
            String[] orgMsgRcvrNm = (JSPUtil.getParameter(request, prefix + "org_msg_rcvr_nm", length));
            String[] trsmStsCd = (JSPUtil.getParameter(request, prefix + "trsm_sts_cd", length));
            String[] orgMsgKeyNo = (JSPUtil.getParameter(request, prefix + "org_msg_key_no", length));
            String[] tranIfDate = (JSPUtil.getParameter(request, prefix + "tran_if_date", length));
            String[] arkIfDate = (JSPUtil.getParameter(request, prefix + "ark_if_date", length));
            String[] errDtlCd = (JSPUtil.getParameter(request, prefix + "err_dtl_cd", length));
            String[] errDtlRmk = (JSPUtil.getParameter(request, prefix + "err_dtl_rmk", length));
            String[] ediUnmapFlg = (JSPUtil.getParameter(request, prefix + "edi_unmap_flg", length));
            String[] ediUnmapKndCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_knd_cd", length));
            String[] fltFileDatCtnt = (JSPUtil.getParameter(request, prefix + "flt_file_dat_ctnt", length));
            String[] expand = (JSPUtil.getParameter(request, prefix + "expand", length));
            String[] ediUnmapCorrCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_corr_cd", length));
            String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", length));
            String[] callSignNo = (JSPUtil.getParameter(request, prefix + "call_sign_no", length));
	    	String[] callSignLloyd = (JSPUtil.getParameter(request, prefix + "call_sign_lloyd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new EdiTransmitHistoryHdrVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (no[i] != null)
                    model.setNo(no[i]);
                if (trsmBndCd[i] != null)
                    model.setTrsmBndCd(trsmBndCd[i]);
                if (trsmDt[i] != null)
                    model.setTrsmDt(trsmDt[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (prnrSpclCgoSeq[i] != null)
                    model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
                if (trsmMzdCd[i] != null)
                    model.setTrsmMzdCd(trsmMzdCd[i]);
                if (ediSndrId[i] != null)
                    model.setEdiSndrId(ediSndrId[i]);
                if (ediRcvrId[i] != null)
                    model.setEdiRcvrId(ediRcvrId[i]);
                if (fltFileRefNo[i] != null)
                    model.setFltFileRefNo(fltFileRefNo[i]);
                if (ediMsgId[i] != null)
                    model.setEdiMsgId(ediMsgId[i]);
                if (ediIfId[i] != null)
                    model.setEdiIfId(ediIfId[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (emlSndNo[i] != null)
                    model.setEmlSndNo(emlSndNo[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (etaDt[i] != null)
                    model.setEtaDt(etaDt[i]);
                if (ediHdrMsg[i] != null)
                    model.setEdiHdrMsg(ediHdrMsg[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (bkgCreLoclDt[i] != null)
                    model.setBkgCreLoclDt(bkgCreLoclDt[i]);
                if (bkgCreLoclDtCtnt[i] != null)
                    model.setBkgCreLoclDtCtnt(bkgCreLoclDtCtnt[i]);
                if (ediMsgStsCd[i] != null)
                    model.setEdiMsgStsCd(ediMsgStsCd[i]);
                if (ediMsgRefNo[i] != null)
                    model.setEdiMsgRefNo(ediMsgRefNo[i]);
                if (callSgnNo[i] != null)
                    model.setCallSgnNo(callSgnNo[i]);
                if (lloydNo[i] != null)
                    model.setLloydNo(lloydNo[i]);
                if (vslEngFullNm[i] != null)
                    model.setVslEngFullNm(vslEngFullNm[i]);
                if (shpCallNo[i] != null)
                    model.setShpCallNo(shpCallNo[i]);
                if (inBndCssmVoyNo[i] != null)
                    model.setInBndCssmVoyNo(inBndCssmVoyNo[i]);
                if (outBndCssmVoyNo[i] != null)
                    model.setOutBndCssmVoyNo(outBndCssmVoyNo[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (porYdCd[i] != null)
                    model.setPorYdCd(porYdCd[i]);
                if (porNm[i] != null)
                    model.setPorNm(porNm[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (polNm[i] != null)
                    model.setPolNm(polNm[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (podNm[i] != null)
                    model.setPodNm(podNm[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (delYdCd[i] != null)
                    model.setDelYdCd(delYdCd[i]);
                if (delNm[i] != null)
                    model.setDelNm(delNm[i]);
                if (fltFileConvRsltCd[i] != null)
                    model.setFltFileConvRsltCd(fltFileConvRsltCd[i]);
                if (autoUpdRsltCd[i] != null)
                    model.setAutoUpdRsltCd(autoUpdRsltCd[i]);
                if (aplyRsltRmk[i] != null)
                    model.setAplyRsltRmk(aplyRsltRmk[i]);
                if (lstTrsmStsCd[i] != null)
                    model.setLstTrsmStsCd(lstTrsmStsCd[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (mapgCrrCd[i] != null)
                    model.setMapgCrrCd(mapgCrrCd[i]);
                if (mapgBkgRefNo[i] != null)
                    model.setMapgBkgRefNo(mapgBkgRefNo[i]);
                if (mapgSpclCgoRqstSeq[i] != null)
                    model.setMapgSpclCgoRqstSeq(mapgSpclCgoRqstSeq[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (updOfcCd[i] != null)
                    model.setUpdOfcCd(updOfcCd[i]);
                if (errKndCd[i] != null)
                    model.setErrKndCd(errKndCd[i]);
                if (errKndCorrCd[i] != null)
                    model.setErrKndCorrCd(errKndCorrCd[i]);
                if (ctrlRefNo[i] != null)
                    model.setCtrlRefNo(ctrlRefNo[i]);
                if (trsmFromDt[i] != null)
                    model.setTrsmFromDt(trsmFromDt[i]);
                if (trsmToDt[i] != null)
                    model.setTrsmToDt(trsmToDt[i]);
                if (method[i] != null)
                    model.setMethod(method[i]);
                if (msgAckRsltCd[i] != null)
                    model.setMsgAckRsltCd(msgAckRsltCd[i]);
                if (msgRjctRsn[i] != null)
                    model.setMsgRjctRsn(msgRjctRsn[i]);
                if (orgMsgRcvrNm[i] != null)
                    model.setOrgMsgRcvrNm(orgMsgRcvrNm[i]);
                if (trsmStsCd[i] != null)
                    model.setTrsmStsCd(trsmStsCd[i]);
                if (orgMsgKeyNo[i] != null)
                    model.setOrgMsgKeyNo(orgMsgKeyNo[i]);
                if (tranIfDate[i] != null)
                    model.setTranIfDate(tranIfDate[i]);
                if (arkIfDate[i] != null)
                    model.setArkIfDate(arkIfDate[i]);
                if (errDtlCd[i] != null)
                    model.setErrDtlCd(errDtlCd[i]);
                if (errDtlRmk[i] != null)
                    model.setErrDtlRmk(errDtlRmk[i]);
                if (ediUnmapFlg[i] != null)
                    model.setEdiUnmapFlg(ediUnmapFlg[i]);
                if (ediUnmapKndCd[i] != null)
                    model.setEdiUnmapKndCd(ediUnmapKndCd[i]);
                if (fltFileDatCtnt[i] != null)
                    model.setFltFileDatCtnt(fltFileDatCtnt[i]);
                if (expand[i] != null)
                    model.setExpand(expand[i]);
                if (ediUnmapCorrCd[i] != null)
                    model.setEdiUnmapCorrCd(ediUnmapCorrCd[i]);
                if (obCssmVoyNo[i] != null)
                    model.setObCssmVoyNo(obCssmVoyNo[i]);
                if (callSignNo[i] != null) 
		    		model.setCallSignNo(callSignNo[i]);
				if (lloydNo[i] != null) 
		    		model.setLloydNo(lloydNo[i]);
				if (callSignLloyd[i] != null) 
		    		model.setCallSignLloyd(callSignLloyd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getEdiTransmitHistoryHdrVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return EdiTransmitHistoryHdrVO[]
	 */
    public EdiTransmitHistoryHdrVO[] getEdiTransmitHistoryHdrVOs() {
        EdiTransmitHistoryHdrVO[] vos = (EdiTransmitHistoryHdrVO[]) models.toArray(new EdiTransmitHistoryHdrVO[models.size()]);
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
        this.no = this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmBndCd = this.trsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmDt = this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSeq = this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmMzdCd = this.trsmMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediSndrId = this.ediSndrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediRcvrId = this.ediRcvrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fltFileRefNo = this.fltFileRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediMsgId = this.ediMsgId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediIfId = this.ediIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndNo = this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etaDt = this.etaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediHdrMsg = this.ediHdrMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCreLoclDt = this.bkgCreLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCreLoclDtCtnt = this.bkgCreLoclDtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediMsgStsCd = this.ediMsgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediMsgRefNo = this.ediMsgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSgnNo = this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngFullNm = this.vslEngFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shpCallNo = this.shpCallNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inBndCssmVoyNo = this.inBndCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outBndCssmVoyNo = this.outBndCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porYdCd = this.porYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNm = this.porNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNm = this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNm = this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delYdCd = this.delYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNm = this.delNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fltFileConvRsltCd = this.fltFileConvRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoUpdRsltCd = this.autoUpdRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aplyRsltRmk = this.aplyRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstTrsmStsCd = this.lstTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgCrrCd = this.mapgCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgBkgRefNo = this.mapgBkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgSpclCgoRqstSeq = this.mapgSpclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errKndCd = this.errKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errKndCorrCd = this.errKndCorrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlRefNo = this.ctrlRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmFromDt = this.trsmFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmToDt = this.trsmToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.method = this.method.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgAckRsltCd = this.msgAckRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.msgRjctRsn = this.msgRjctRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgRcvrNm = this.orgMsgRcvrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmStsCd = this.trsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgMsgKeyNo = this.orgMsgKeyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tranIfDate = this.tranIfDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arkIfDate = this.arkIfDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errDtlCd = this.errDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errDtlRmk = this.errDtlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoCreateStsCd = this.cgoCreateStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapFlg = this.ediUnmapFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapKndCd = this.ediUnmapKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fltFileDatCtnt = this.fltFileDatCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expand = this.expand.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapCorrCd = this.ediUnmapCorrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obCssmVoyNo = this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSignNo = this.callSignNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lloydNo = this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.callSignLloyd = this.callSignLloyd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
