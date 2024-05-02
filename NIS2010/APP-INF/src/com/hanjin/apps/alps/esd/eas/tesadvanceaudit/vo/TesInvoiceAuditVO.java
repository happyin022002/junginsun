/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesInvoiceAuditVO.java
*@FileTitle : TesInvoiceAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.30
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.30 yOnghO 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

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
 * @author yOnghO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class TesInvoiceAuditVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TesInvoiceAuditVO> models = new ArrayList<TesInvoiceAuditVO>();

    /* Column Info */
    private String dcgoQty = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String payDt = null;

    /* Column Info */
    private String amtAudTgtFlg = null;

    /* Column Info */
    private String audCaseDtlQty = null;

    /* Column Info */
    private String sSaveTpCd = null;

    /* Column Info */
    private String awkBbCgoQty = null;

    /* Column Info */
    private String audUpdUsrNm = null;

    /* Column Info */
    private String invCfmDtYmd = null;

    /* Column Info */
    private String vrfyRsltCdCtnt = null;

    /* Column Info */
    private String expnAudRsltCd = null;

    /* Column Info */
    private String tmlInvTpCd = null;

    /* Column Info */
    private String invPrdDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String atchFileLnkId = null;

    /* Column Info */
    private String autoExpnAudStsCd = null;

    /* Column Info */
    private String cntrTtlQty = null;

    /* Column Info */
    private String tmlInvRjctStsCd = null;

    /* Column Info */
    private String payDueDt = null;

    /* Column Info */
    private String batRslt = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String csrStsCd = null;

    /* Column Info */
    private String batEstmVolRsltCd = null;

    /* Column Info */
    private String fmPrdDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String rhqCd = null;

    /* Column Info */
    private String audLgsCostCdQty = null;

    /* Column Info */
    private String expnAudEstmAmt = null;

    /* Column Info */
    private String payTerm = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String hngrCgoQty = null;

    /* Column Info */
    private String batchTpCd = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String dgRcQty = null;

    /* Column Info */
    private String audUpdDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String batAmtRsltCdQty = null;

    /* Column Info */
    private String chk = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String bbCgoQty = null;

    /* Column Info */
    private String prdYm = null;

    /* Column Info */
    private String fullMtyCd = null;

    /* Column Info */
    private String batAmtRsltCd = null;

    /* Column Info */
    private String autoAudBatSeq = null;

    /* Column Info */
    private String audDtlTgtQty = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String awkCgoQty = null;

    /* Column Info */
    private String batVolRsltCdQty = null;

    /* Column Info */
    private String calcCostGrpCd = null;

    /* Column Info */
    private String atbDt = null;

    /* Column Info */
    private String expnAudSeq = null;

    /* Column Info */
    private String issDt = null;

    /* Column Info */
    private String tsFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rcQty = null;

    /* Column Info */
    private String expnAudRsltUsrId = null;

    /* Column Info */
    private String expnAudRsltRmk = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String invOfcCd = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String calcTpCdCtnt = null;

    /* Column Info */
    private String costOfcCd = null;

    /* Column Info */
    private String invCfmDt = null;

    /* Column Info */
    private String cfsCgoQty = null;

    /* Column Info */
    private String diffRto = null;

    /* Column Info */
    private String expnAudStsCd = null;

    /* Column Info */
    private String toPrdDt = null;

    /* Column Info */
    private String ioBndCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String batProgStsCd = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String volAudTgtQty = null;

    /* Column Info */
    private String batVolRsltCd = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String invCreUsrNm = null;

    /* Column Info */
    private String batEstmVolRsltCdQty = null;

    /* Column Info */
    private String selAudCd = null;

    /* Column Info */
    private String eacFlg = null;

    /* Column Info */
    private String expnAudRsltUsrNm = null;

    /* Column Info */
    private String audUpdUsrId = null;

    /* Column Info */
    private String invAudCurrCd = null;

    /* Column Info */
    private String invAudDiffAmt = null;

    /* Column Info */
    private String invAudUsdDiffAmt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public TesInvoiceAuditVO() {
    }

    public TesInvoiceAuditVO(String ibflag, String pagerows, String amtAudTgtFlg, String atbDt, String atchFileLnkId, String audCaseDtlQty, String audDtlTgtQty, String audLgsCostCdQty, String audUpdDt, String audUpdUsrId, String audUpdUsrNm, String autoAudBatSeq, String autoExpnAudStsCd, String awkCgoQty, String awkBbCgoQty, String batAmtRsltCd, String batAmtRsltCdQty, String batEstmVolRsltCd, String batEstmVolRsltCdQty, String batProgStsCd, String batchTpCd, String batRslt, String batVolRsltCd, String batVolRsltCdQty, String bbCgoQty, String calcCostGrpCd, String calcTpCdCtnt, String chk, String cfsCgoQty, String costOfcCd, String cntrTpszCd, String cntrTtlQty, String creUsrId, String creOfcCd, String csrNo, String csrStsCd, String currCd, String diffRto, String dcgoQty, String dgRcQty, String eacFlg, String expnAudEstmAmt, String expnAudRsltCd, String expnAudRsltRmk, String expnAudRsltUsrId, String expnAudRsltUsrNm, String expnAudSeq, String expnAudStsCd, String fmPrdDt, String fullMtyCd, String hngrCgoQty, String invAmt, String invCfmDt, String invCfmDtYmd, String invCreUsrNm, String invNo, String invOfcCd, String invPrdDt, String ioBndCd, String issDt, String payDt, String payDueDt, String payTerm, String prdYm, String rhqCd, String rcQty, String sSaveTpCd, String selAudCd, String skdDirCd, String skdVoyNo, String tmlInvRjctStsCd, String tmlInvTpCd, String toPrdDt, String tsFlg, String updDt, String updUsrId, String vndrSeq, String volAudTgtQty, String vrfyRsltCdCtnt, String vslCd, String vvd, String ydCd, String invAudCurrCd, String invAudDiffAmt, String invAudUsdDiffAmt) {
        this.dcgoQty = dcgoQty;
        this.vslCd = vslCd;
        this.payDt = payDt;
        this.amtAudTgtFlg = amtAudTgtFlg;
        this.audCaseDtlQty = audCaseDtlQty;
        this.sSaveTpCd = sSaveTpCd;
        this.awkBbCgoQty = awkBbCgoQty;
        this.audUpdUsrNm = audUpdUsrNm;
        this.invCfmDtYmd = invCfmDtYmd;
        this.vrfyRsltCdCtnt = vrfyRsltCdCtnt;
        this.expnAudRsltCd = expnAudRsltCd;
        this.tmlInvTpCd = tmlInvTpCd;
        this.invPrdDt = invPrdDt;
        this.pagerows = pagerows;
        this.atchFileLnkId = atchFileLnkId;
        this.autoExpnAudStsCd = autoExpnAudStsCd;
        this.cntrTtlQty = cntrTtlQty;
        this.tmlInvRjctStsCd = tmlInvRjctStsCd;
        this.payDueDt = payDueDt;
        this.batRslt = batRslt;
        this.cntrTpszCd = cntrTpszCd;
        this.csrStsCd = csrStsCd;
        this.batEstmVolRsltCd = batEstmVolRsltCd;
        this.fmPrdDt = fmPrdDt;
        this.updUsrId = updUsrId;
        this.csrNo = csrNo;
        this.rhqCd = rhqCd;
        this.audLgsCostCdQty = audLgsCostCdQty;
        this.expnAudEstmAmt = expnAudEstmAmt;
        this.payTerm = payTerm;
        this.skdVoyNo = skdVoyNo;
        this.hngrCgoQty = hngrCgoQty;
        this.batchTpCd = batchTpCd;
        this.vvd = vvd;
        this.dgRcQty = dgRcQty;
        this.audUpdDt = audUpdDt;
        this.creUsrId = creUsrId;
        this.batAmtRsltCdQty = batAmtRsltCdQty;
        this.chk = chk;
        this.vndrSeq = vndrSeq;
        this.bbCgoQty = bbCgoQty;
        this.prdYm = prdYm;
        this.fullMtyCd = fullMtyCd;
        this.batAmtRsltCd = batAmtRsltCd;
        this.autoAudBatSeq = autoAudBatSeq;
        this.audDtlTgtQty = audDtlTgtQty;
        this.currCd = currCd;
        this.awkCgoQty = awkCgoQty;
        this.batVolRsltCdQty = batVolRsltCdQty;
        this.calcCostGrpCd = calcCostGrpCd;
        this.atbDt = atbDt;
        this.expnAudSeq = expnAudSeq;
        this.issDt = issDt;
        this.tsFlg = tsFlg;
        this.ibflag = ibflag;
        this.rcQty = rcQty;
        this.expnAudRsltUsrId = expnAudRsltUsrId;
        this.expnAudRsltRmk = expnAudRsltRmk;
        this.creOfcCd = creOfcCd;
        this.invAmt = invAmt;
        this.invOfcCd = invOfcCd;
        this.updDt = updDt;
        this.calcTpCdCtnt = calcTpCdCtnt;
        this.costOfcCd = costOfcCd;
        this.invCfmDt = invCfmDt;
        this.cfsCgoQty = cfsCgoQty;
        this.diffRto = diffRto;
        this.expnAudStsCd = expnAudStsCd;
        this.toPrdDt = toPrdDt;
        this.ioBndCd = ioBndCd;
        this.skdDirCd = skdDirCd;
        this.batProgStsCd = batProgStsCd;
        this.invNo = invNo;
        this.volAudTgtQty = volAudTgtQty;
        this.batVolRsltCd = batVolRsltCd;
        this.ydCd = ydCd;
        this.invCreUsrNm = invCreUsrNm;
        this.batEstmVolRsltCdQty = batEstmVolRsltCdQty;
        this.selAudCd = selAudCd;
        this.eacFlg = eacFlg;
        this.expnAudRsltUsrNm = expnAudRsltUsrNm;
        this.audUpdUsrId = audUpdUsrId;
        this.invAudCurrCd = invAudCurrCd;
        this.invAudDiffAmt = invAudDiffAmt;
        this.invAudUsdDiffAmt = invAudUsdDiffAmt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("dcgo_qty", getDcgoQty());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("pay_dt", getPayDt());
        this.hashColumns.put("amt_aud_tgt_flg", getAmtAudTgtFlg());
        this.hashColumns.put("aud_case_dtl_qty", getAudCaseDtlQty());
        this.hashColumns.put("s_save_tp_cd", getSSaveTpCd());
        this.hashColumns.put("awk_bb_cgo_qty", getAwkBbCgoQty());
        this.hashColumns.put("aud_upd_usr_nm", getAudUpdUsrNm());
        this.hashColumns.put("inv_cfm_dt_ymd", getInvCfmDtYmd());
        this.hashColumns.put("vrfy_rslt_cd_ctnt", getVrfyRsltCdCtnt());
        this.hashColumns.put("expn_aud_rslt_cd", getExpnAudRsltCd());
        this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
        this.hashColumns.put("inv_prd_dt", getInvPrdDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
        this.hashColumns.put("auto_expn_aud_sts_cd", getAutoExpnAudStsCd());
        this.hashColumns.put("cntr_ttl_qty", getCntrTtlQty());
        this.hashColumns.put("tml_inv_rjct_sts_cd", getTmlInvRjctStsCd());
        this.hashColumns.put("pay_due_dt", getPayDueDt());
        this.hashColumns.put("bat_rslt", getBatRslt());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("csr_sts_cd", getCsrStsCd());
        this.hashColumns.put("bat_estm_vol_rslt_cd", getBatEstmVolRsltCd());
        this.hashColumns.put("fm_prd_dt", getFmPrdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("rhq_cd", getRhqCd());
        this.hashColumns.put("aud_lgs_cost_cd_qty", getAudLgsCostCdQty());
        this.hashColumns.put("expn_aud_estm_amt", getExpnAudEstmAmt());
        this.hashColumns.put("pay_term", getPayTerm());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("hngr_cgo_qty", getHngrCgoQty());
        this.hashColumns.put("batch_tp_cd", getBatchTpCd());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("dg_rc_qty", getDgRcQty());
        this.hashColumns.put("aud_upd_dt", getAudUpdDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("bat_amt_rslt_cd_qty", getBatAmtRsltCdQty());
        this.hashColumns.put("chk", getChk());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("bb_cgo_qty", getBbCgoQty());
        this.hashColumns.put("prd_ym", getPrdYm());
        this.hashColumns.put("full_mty_cd", getFullMtyCd());
        this.hashColumns.put("bat_amt_rslt_cd", getBatAmtRsltCd());
        this.hashColumns.put("auto_aud_bat_seq", getAutoAudBatSeq());
        this.hashColumns.put("aud_dtl_tgt_qty", getAudDtlTgtQty());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("awk_cgo_qty", getAwkCgoQty());
        this.hashColumns.put("bat_vol_rslt_cd_qty", getBatVolRsltCdQty());
        this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
        this.hashColumns.put("atb_dt", getAtbDt());
        this.hashColumns.put("expn_aud_seq", getExpnAudSeq());
        this.hashColumns.put("iss_dt", getIssDt());
        this.hashColumns.put("ts_flg", getTsFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rc_qty", getRcQty());
        this.hashColumns.put("expn_aud_rslt_usr_id", getExpnAudRsltUsrId());
        this.hashColumns.put("expn_aud_rslt_rmk", getExpnAudRsltRmk());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("calc_tp_cd_ctnt", getCalcTpCdCtnt());
        this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
        this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
        this.hashColumns.put("cfs_cgo_qty", getCfsCgoQty());
        this.hashColumns.put("diff_rto", getDiffRto());
        this.hashColumns.put("expn_aud_sts_cd", getExpnAudStsCd());
        this.hashColumns.put("to_prd_dt", getToPrdDt());
        this.hashColumns.put("io_bnd_cd", getIoBndCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("bat_prog_sts_cd", getBatProgStsCd());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("vol_aud_tgt_qty", getVolAudTgtQty());
        this.hashColumns.put("bat_vol_rslt_cd", getBatVolRsltCd());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("inv_cre_usr_nm", getInvCreUsrNm());
        this.hashColumns.put("bat_estm_vol_rslt_cd_qty", getBatEstmVolRsltCdQty());
        this.hashColumns.put("sel_aud_cd", getSelAudCd());
        this.hashColumns.put("eac_flg", getEacFlg());
        this.hashColumns.put("expn_aud_rslt_usr_nm", getExpnAudRsltUsrNm());
        this.hashColumns.put("aud_upd_usr_id", getAudUpdUsrId());
        this.hashColumns.put("inv_aud_curr_cd", getInvAudCurrCd());
        this.hashColumns.put("inv_aud_diff_amt", getInvAudDiffAmt());
        this.hashColumns.put("inv_aud_usd_diff_amt", getInvAudUsdDiffAmt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("dcgo_qty", "dcgoQty");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("pay_dt", "payDt");
        this.hashFields.put("amt_aud_tgt_flg", "amtAudTgtFlg");
        this.hashFields.put("aud_case_dtl_qty", "audCaseDtlQty");
        this.hashFields.put("s_save_tp_cd", "sSaveTpCd");
        this.hashFields.put("awk_bb_cgo_qty", "awkBbCgoQty");
        this.hashFields.put("aud_upd_usr_nm", "audUpdUsrNm");
        this.hashFields.put("inv_cfm_dt_ymd", "invCfmDtYmd");
        this.hashFields.put("vrfy_rslt_cd_ctnt", "vrfyRsltCdCtnt");
        this.hashFields.put("expn_aud_rslt_cd", "expnAudRsltCd");
        this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
        this.hashFields.put("inv_prd_dt", "invPrdDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
        this.hashFields.put("auto_expn_aud_sts_cd", "autoExpnAudStsCd");
        this.hashFields.put("cntr_ttl_qty", "cntrTtlQty");
        this.hashFields.put("tml_inv_rjct_sts_cd", "tmlInvRjctStsCd");
        this.hashFields.put("pay_due_dt", "payDueDt");
        this.hashFields.put("bat_rslt", "batRslt");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("csr_sts_cd", "csrStsCd");
        this.hashFields.put("bat_estm_vol_rslt_cd", "batEstmVolRsltCd");
        this.hashFields.put("fm_prd_dt", "fmPrdDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("rhq_cd", "rhqCd");
        this.hashFields.put("aud_lgs_cost_cd_qty", "audLgsCostCdQty");
        this.hashFields.put("expn_aud_estm_amt", "expnAudEstmAmt");
        this.hashFields.put("pay_term", "payTerm");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("hngr_cgo_qty", "hngrCgoQty");
        this.hashFields.put("batch_tp_cd", "batchTpCd");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("dg_rc_qty", "dgRcQty");
        this.hashFields.put("aud_upd_dt", "audUpdDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("bat_amt_rslt_cd_qty", "batAmtRsltCdQty");
        this.hashFields.put("chk", "chk");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("bb_cgo_qty", "bbCgoQty");
        this.hashFields.put("prd_ym", "prdYm");
        this.hashFields.put("full_mty_cd", "fullMtyCd");
        this.hashFields.put("bat_amt_rslt_cd", "batAmtRsltCd");
        this.hashFields.put("auto_aud_bat_seq", "autoAudBatSeq");
        this.hashFields.put("aud_dtl_tgt_qty", "audDtlTgtQty");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("awk_cgo_qty", "awkCgoQty");
        this.hashFields.put("bat_vol_rslt_cd_qty", "batVolRsltCdQty");
        this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
        this.hashFields.put("atb_dt", "atbDt");
        this.hashFields.put("expn_aud_seq", "expnAudSeq");
        this.hashFields.put("iss_dt", "issDt");
        this.hashFields.put("ts_flg", "tsFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rc_qty", "rcQty");
        this.hashFields.put("expn_aud_rslt_usr_id", "expnAudRsltUsrId");
        this.hashFields.put("expn_aud_rslt_rmk", "expnAudRsltRmk");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("inv_ofc_cd", "invOfcCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("calc_tp_cd_ctnt", "calcTpCdCtnt");
        this.hashFields.put("cost_ofc_cd", "costOfcCd");
        this.hashFields.put("inv_cfm_dt", "invCfmDt");
        this.hashFields.put("cfs_cgo_qty", "cfsCgoQty");
        this.hashFields.put("diff_rto", "diffRto");
        this.hashFields.put("expn_aud_sts_cd", "expnAudStsCd");
        this.hashFields.put("to_prd_dt", "toPrdDt");
        this.hashFields.put("io_bnd_cd", "ioBndCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("bat_prog_sts_cd", "batProgStsCd");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("vol_aud_tgt_qty", "volAudTgtQty");
        this.hashFields.put("bat_vol_rslt_cd", "batVolRsltCd");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("inv_cre_usr_nm", "invCreUsrNm");
        this.hashFields.put("bat_estm_vol_rslt_cd_qty", "batEstmVolRsltCdQty");
        this.hashFields.put("sel_aud_cd", "selAudCd");
        this.hashFields.put("eac_flg", "eacFlg");
        this.hashFields.put("expn_aud_rslt_usr_nm", "expnAudRsltUsrNm");
        this.hashFields.put("aud_upd_usr_id", "audUpdUsrId");
        this.hashFields.put("inv_aud_curr_cd", "invAudCurrCd");
        this.hashFields.put("inv_aud_diff_amt", "invAudDiffAmt");
        this.hashFields.put("inv_aud_usd_diff_amt", "invAudUsdDiffAmt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return dcgoQty
	 */
    public String getDcgoQty() {
        return this.dcgoQty;
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
	 * @return payDt
	 */
    public String getPayDt() {
        return this.payDt;
    }

    /**
	 * Column Info
	 * @return amtAudTgtFlg
	 */
    public String getAmtAudTgtFlg() {
        return this.amtAudTgtFlg;
    }

    /**
	 * Column Info
	 * @return audCaseDtlQty
	 */
    public String getAudCaseDtlQty() {
        return this.audCaseDtlQty;
    }

    /**
	 * Column Info
	 * @return sSaveTpCd
	 */
    public String getSSaveTpCd() {
        return this.sSaveTpCd;
    }

    /**
	 * Column Info
	 * @return awkBbCgoQty
	 */
    public String getAwkBbCgoQty() {
        return this.awkBbCgoQty;
    }

    /**
	 * Column Info
	 * @return audUpdUsrNm
	 */
    public String getAudUpdUsrNm() {
        return this.audUpdUsrNm;
    }

    /**
	 * Column Info
	 * @return invCfmDtYmd
	 */
    public String getInvCfmDtYmd() {
        return this.invCfmDtYmd;
    }

    /**
	 * Column Info
	 * @return vrfyRsltCdCtnt
	 */
    public String getVrfyRsltCdCtnt() {
        return this.vrfyRsltCdCtnt;
    }

    /**
	 * Column Info
	 * @return expnAudRsltCd
	 */
    public String getExpnAudRsltCd() {
        return this.expnAudRsltCd;
    }

    /**
	 * Column Info
	 * @return tmlInvTpCd
	 */
    public String getTmlInvTpCd() {
        return this.tmlInvTpCd;
    }

    /**
	 * Column Info
	 * @return invPrdDt
	 */
    public String getInvPrdDt() {
        return this.invPrdDt;
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
	 * @return atchFileLnkId
	 */
    public String getAtchFileLnkId() {
        return this.atchFileLnkId;
    }

    /**
	 * Column Info
	 * @return autoExpnAudStsCd
	 */
    public String getAutoExpnAudStsCd() {
        return this.autoExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @return cntrTtlQty
	 */
    public String getCntrTtlQty() {
        return this.cntrTtlQty;
    }

    /**
	 * Column Info
	 * @return tmlInvRjctStsCd
	 */
    public String getTmlInvRjctStsCd() {
        return this.tmlInvRjctStsCd;
    }

    /**
	 * Column Info
	 * @return payDueDt
	 */
    public String getPayDueDt() {
        return this.payDueDt;
    }

    /**
	 * Column Info
	 * @return batRslt
	 */
    public String getBatRslt() {
        return this.batRslt;
    }

    /**
	 * Column Info
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return csrStsCd
	 */
    public String getCsrStsCd() {
        return this.csrStsCd;
    }

    /**
	 * Column Info
	 * @return batEstmVolRsltCd
	 */
    public String getBatEstmVolRsltCd() {
        return this.batEstmVolRsltCd;
    }

    /**
	 * Column Info
	 * @return fmPrdDt
	 */
    public String getFmPrdDt() {
        return this.fmPrdDt;
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
	 * @return csrNo
	 */
    public String getCsrNo() {
        return this.csrNo;
    }

    /**
	 * Column Info
	 * @return rhqCd
	 */
    public String getRhqCd() {
        return this.rhqCd;
    }

    /**
	 * Column Info
	 * @return audLgsCostCdQty
	 */
    public String getAudLgsCostCdQty() {
        return this.audLgsCostCdQty;
    }

    /**
	 * Column Info
	 * @return expnAudEstmAmt
	 */
    public String getExpnAudEstmAmt() {
        return this.expnAudEstmAmt;
    }

    /**
	 * Column Info
	 * @return payTerm
	 */
    public String getPayTerm() {
        return this.payTerm;
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
	 * @return hngrCgoQty
	 */
    public String getHngrCgoQty() {
        return this.hngrCgoQty;
    }

    /**
	 * Column Info
	 * @return batchTpCd
	 */
    public String getBatchTpCd() {
        return this.batchTpCd;
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
	 * @return dgRcQty
	 */
    public String getDgRcQty() {
        return this.dgRcQty;
    }

    /**
	 * Column Info
	 * @return audUpdDt
	 */
    public String getAudUpdDt() {
        return this.audUpdDt;
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
	 * @return batAmtRsltCdQty
	 */
    public String getBatAmtRsltCdQty() {
        return this.batAmtRsltCdQty;
    }

    /**
	 * Column Info
	 * @return chk
	 */
    public String getChk() {
        return this.chk;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return bbCgoQty
	 */
    public String getBbCgoQty() {
        return this.bbCgoQty;
    }

    /**
	 * Column Info
	 * @return prdYm
	 */
    public String getPrdYm() {
        return this.prdYm;
    }

    /**
	 * Column Info
	 * @return fullMtyCd
	 */
    public String getFullMtyCd() {
        return this.fullMtyCd;
    }

    /**
	 * Column Info
	 * @return batAmtRsltCd
	 */
    public String getBatAmtRsltCd() {
        return this.batAmtRsltCd;
    }

    /**
	 * Column Info
	 * @return autoAudBatSeq
	 */
    public String getAutoAudBatSeq() {
        return this.autoAudBatSeq;
    }

    /**
	 * Column Info
	 * @return audDtlTgtQty
	 */
    public String getAudDtlTgtQty() {
        return this.audDtlTgtQty;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return awkCgoQty
	 */
    public String getAwkCgoQty() {
        return this.awkCgoQty;
    }

    /**
	 * Column Info
	 * @return batVolRsltCdQty
	 */
    public String getBatVolRsltCdQty() {
        return this.batVolRsltCdQty;
    }

    /**
	 * Column Info
	 * @return calcCostGrpCd
	 */
    public String getCalcCostGrpCd() {
        return this.calcCostGrpCd;
    }

    /**
	 * Column Info
	 * @return atbDt
	 */
    public String getAtbDt() {
        return this.atbDt;
    }

    /**
	 * Column Info
	 * @return expnAudSeq
	 */
    public String getExpnAudSeq() {
        return this.expnAudSeq;
    }

    /**
	 * Column Info
	 * @return issDt
	 */
    public String getIssDt() {
        return this.issDt;
    }

    /**
	 * Column Info
	 * @return tsFlg
	 */
    public String getTsFlg() {
        return this.tsFlg;
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
	 * @return rcQty
	 */
    public String getRcQty() {
        return this.rcQty;
    }

    /**
	 * Column Info
	 * @return expnAudRsltUsrId
	 */
    public String getExpnAudRsltUsrId() {
        return this.expnAudRsltUsrId;
    }

    /**
	 * Column Info
	 * @return expnAudRsltRmk
	 */
    public String getExpnAudRsltRmk() {
        return this.expnAudRsltRmk;
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
	 * @return invAmt
	 */
    public String getInvAmt() {
        return this.invAmt;
    }

    /**
	 * Column Info
	 * @return invOfcCd
	 */
    public String getInvOfcCd() {
        return this.invOfcCd;
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
	 * @return calcTpCdCtnt
	 */
    public String getCalcTpCdCtnt() {
        return this.calcTpCdCtnt;
    }

    /**
	 * Column Info
	 * @return costOfcCd
	 */
    public String getCostOfcCd() {
        return this.costOfcCd;
    }

    /**
	 * Column Info
	 * @return invCfmDt
	 */
    public String getInvCfmDt() {
        return this.invCfmDt;
    }

    /**
	 * Column Info
	 * @return cfsCgoQty
	 */
    public String getCfsCgoQty() {
        return this.cfsCgoQty;
    }

    /**
	 * Column Info
	 * @return diffRto
	 */
    public String getDiffRto() {
        return this.diffRto;
    }

    /**
	 * Column Info
	 * @return expnAudStsCd
	 */
    public String getExpnAudStsCd() {
        return this.expnAudStsCd;
    }

    /**
	 * Column Info
	 * @return toPrdDt
	 */
    public String getToPrdDt() {
        return this.toPrdDt;
    }

    /**
	 * Column Info
	 * @return ioBndCd
	 */
    public String getIoBndCd() {
        return this.ioBndCd;
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
	 * @return batProgStsCd
	 */
    public String getBatProgStsCd() {
        return this.batProgStsCd;
    }

    /**
	 * Column Info
	 * @return invNo
	 */
    public String getInvNo() {
        return this.invNo;
    }

    /**
	 * Column Info
	 * @return volAudTgtQty
	 */
    public String getVolAudTgtQty() {
        return this.volAudTgtQty;
    }

    /**
	 * Column Info
	 * @return batVolRsltCd
	 */
    public String getBatVolRsltCd() {
        return this.batVolRsltCd;
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
	 * @return invCreUsrNm
	 */
    public String getInvCreUsrNm() {
        return this.invCreUsrNm;
    }

    /**
	 * Column Info
	 * @return batEstmVolRsltCdQty
	 */
    public String getBatEstmVolRsltCdQty() {
        return this.batEstmVolRsltCdQty;
    }

    /**
	 * Column Info
	 * @return selAudCd
	 */
    public String getSelAudCd() {
        return this.selAudCd;
    }

    /**
	 * Column Info
	 * @return eacFlg
	 */
    public String getEacFlg() {
        return this.eacFlg;
    }

    /**
	 * Column Info
	 * @return expnAudRsltUsrNm
	 */
    public String getExpnAudRsltUsrNm() {
        return this.expnAudRsltUsrNm;
    }

    /**
	 * Column Info
	 * @return audUpdUsrId
	 */
    public String getAudUpdUsrId() {
        return this.audUpdUsrId;
    }

    /**
	 * Column Info
	 * @param dcgoQty
	 */
    public void setDcgoQty(String dcgoQty) {
        this.dcgoQty = dcgoQty;
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
	 * @param payDt
	 */
    public void setPayDt(String payDt) {
        this.payDt = payDt;
    }

    /**
	 * Column Info
	 * @param amtAudTgtFlg
	 */
    public void setAmtAudTgtFlg(String amtAudTgtFlg) {
        this.amtAudTgtFlg = amtAudTgtFlg;
    }

    /**
	 * Column Info
	 * @param audCaseDtlQty
	 */
    public void setAudCaseDtlQty(String audCaseDtlQty) {
        this.audCaseDtlQty = audCaseDtlQty;
    }

    /**
	 * Column Info
	 * @param sSaveTpCd
	 */
    public void setSSaveTpCd(String sSaveTpCd) {
        this.sSaveTpCd = sSaveTpCd;
    }

    /**
	 * Column Info
	 * @param awkBbCgoQty
	 */
    public void setAwkBbCgoQty(String awkBbCgoQty) {
        this.awkBbCgoQty = awkBbCgoQty;
    }

    /**
	 * Column Info
	 * @param audUpdUsrNm
	 */
    public void setAudUpdUsrNm(String audUpdUsrNm) {
        this.audUpdUsrNm = audUpdUsrNm;
    }

    /**
	 * Column Info
	 * @param invCfmDtYmd
	 */
    public void setInvCfmDtYmd(String invCfmDtYmd) {
        this.invCfmDtYmd = invCfmDtYmd;
    }

    /**
	 * Column Info
	 * @param vrfyRsltCdCtnt
	 */
    public void setVrfyRsltCdCtnt(String vrfyRsltCdCtnt) {
        this.vrfyRsltCdCtnt = vrfyRsltCdCtnt;
    }

    /**
	 * Column Info
	 * @param expnAudRsltCd
	 */
    public void setExpnAudRsltCd(String expnAudRsltCd) {
        this.expnAudRsltCd = expnAudRsltCd;
    }

    /**
	 * Column Info
	 * @param tmlInvTpCd
	 */
    public void setTmlInvTpCd(String tmlInvTpCd) {
        this.tmlInvTpCd = tmlInvTpCd;
    }

    /**
	 * Column Info
	 * @param invPrdDt
	 */
    public void setInvPrdDt(String invPrdDt) {
        this.invPrdDt = invPrdDt;
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
	 * @param atchFileLnkId
	 */
    public void setAtchFileLnkId(String atchFileLnkId) {
        this.atchFileLnkId = atchFileLnkId;
    }

    /**
	 * Column Info
	 * @param autoExpnAudStsCd
	 */
    public void setAutoExpnAudStsCd(String autoExpnAudStsCd) {
        this.autoExpnAudStsCd = autoExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @param cntrTtlQty
	 */
    public void setCntrTtlQty(String cntrTtlQty) {
        this.cntrTtlQty = cntrTtlQty;
    }

    /**
	 * Column Info
	 * @param tmlInvRjctStsCd
	 */
    public void setTmlInvRjctStsCd(String tmlInvRjctStsCd) {
        this.tmlInvRjctStsCd = tmlInvRjctStsCd;
    }

    /**
	 * Column Info
	 * @param payDueDt
	 */
    public void setPayDueDt(String payDueDt) {
        this.payDueDt = payDueDt;
    }

    /**
	 * Column Info
	 * @param batRslt
	 */
    public void setBatRslt(String batRslt) {
        this.batRslt = batRslt;
    }

    /**
	 * Column Info
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param csrStsCd
	 */
    public void setCsrStsCd(String csrStsCd) {
        this.csrStsCd = csrStsCd;
    }

    /**
	 * Column Info
	 * @param batEstmVolRsltCd
	 */
    public void setBatEstmVolRsltCd(String batEstmVolRsltCd) {
        this.batEstmVolRsltCd = batEstmVolRsltCd;
    }

    /**
	 * Column Info
	 * @param fmPrdDt
	 */
    public void setFmPrdDt(String fmPrdDt) {
        this.fmPrdDt = fmPrdDt;
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
	 * @param csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    /**
	 * Column Info
	 * @param rhqCd
	 */
    public void setRhqCd(String rhqCd) {
        this.rhqCd = rhqCd;
    }

    /**
	 * Column Info
	 * @param audLgsCostCdQty
	 */
    public void setAudLgsCostCdQty(String audLgsCostCdQty) {
        this.audLgsCostCdQty = audLgsCostCdQty;
    }

    /**
	 * Column Info
	 * @param expnAudEstmAmt
	 */
    public void setExpnAudEstmAmt(String expnAudEstmAmt) {
        this.expnAudEstmAmt = expnAudEstmAmt;
    }

    /**
	 * Column Info
	 * @param payTerm
	 */
    public void setPayTerm(String payTerm) {
        this.payTerm = payTerm;
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
	 * @param hngrCgoQty
	 */
    public void setHngrCgoQty(String hngrCgoQty) {
        this.hngrCgoQty = hngrCgoQty;
    }

    /**
	 * Column Info
	 * @param batchTpCd
	 */
    public void setBatchTpCd(String batchTpCd) {
        this.batchTpCd = batchTpCd;
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
	 * @param dgRcQty
	 */
    public void setDgRcQty(String dgRcQty) {
        this.dgRcQty = dgRcQty;
    }

    /**
	 * Column Info
	 * @param audUpdDt
	 */
    public void setAudUpdDt(String audUpdDt) {
        this.audUpdDt = audUpdDt;
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
	 * @param batAmtRsltCdQty
	 */
    public void setBatAmtRsltCdQty(String batAmtRsltCdQty) {
        this.batAmtRsltCdQty = batAmtRsltCdQty;
    }

    /**
	 * Column Info
	 * @param chk
	 */
    public void setChk(String chk) {
        this.chk = chk;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param bbCgoQty
	 */
    public void setBbCgoQty(String bbCgoQty) {
        this.bbCgoQty = bbCgoQty;
    }

    /**
	 * Column Info
	 * @param prdYm
	 */
    public void setPrdYm(String prdYm) {
        this.prdYm = prdYm;
    }

    /**
	 * Column Info
	 * @param fullMtyCd
	 */
    public void setFullMtyCd(String fullMtyCd) {
        this.fullMtyCd = fullMtyCd;
    }

    /**
	 * Column Info
	 * @param batAmtRsltCd
	 */
    public void setBatAmtRsltCd(String batAmtRsltCd) {
        this.batAmtRsltCd = batAmtRsltCd;
    }

    /**
	 * Column Info
	 * @param autoAudBatSeq
	 */
    public void setAutoAudBatSeq(String autoAudBatSeq) {
        this.autoAudBatSeq = autoAudBatSeq;
    }

    /**
	 * Column Info
	 * @param audDtlTgtQty
	 */
    public void setAudDtlTgtQty(String audDtlTgtQty) {
        this.audDtlTgtQty = audDtlTgtQty;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param awkCgoQty
	 */
    public void setAwkCgoQty(String awkCgoQty) {
        this.awkCgoQty = awkCgoQty;
    }

    /**
	 * Column Info
	 * @param batVolRsltCdQty
	 */
    public void setBatVolRsltCdQty(String batVolRsltCdQty) {
        this.batVolRsltCdQty = batVolRsltCdQty;
    }

    /**
	 * Column Info
	 * @param calcCostGrpCd
	 */
    public void setCalcCostGrpCd(String calcCostGrpCd) {
        this.calcCostGrpCd = calcCostGrpCd;
    }

    /**
	 * Column Info
	 * @param atbDt
	 */
    public void setAtbDt(String atbDt) {
        this.atbDt = atbDt;
    }

    /**
	 * Column Info
	 * @param expnAudSeq
	 */
    public void setExpnAudSeq(String expnAudSeq) {
        this.expnAudSeq = expnAudSeq;
    }

    /**
	 * Column Info
	 * @param issDt
	 */
    public void setIssDt(String issDt) {
        this.issDt = issDt;
    }

    /**
	 * Column Info
	 * @param tsFlg
	 */
    public void setTsFlg(String tsFlg) {
        this.tsFlg = tsFlg;
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
	 * @param rcQty
	 */
    public void setRcQty(String rcQty) {
        this.rcQty = rcQty;
    }

    /**
	 * Column Info
	 * @param expnAudRsltUsrId
	 */
    public void setExpnAudRsltUsrId(String expnAudRsltUsrId) {
        this.expnAudRsltUsrId = expnAudRsltUsrId;
    }

    /**
	 * Column Info
	 * @param expnAudRsltRmk
	 */
    public void setExpnAudRsltRmk(String expnAudRsltRmk) {
        this.expnAudRsltRmk = expnAudRsltRmk;
    }

    /**
	 * Column Info
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    /**
	 * Column Info
	 * @param invAmt
	 */
    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    /**
	 * Column Info
	 * @param invOfcCd
	 */
    public void setInvOfcCd(String invOfcCd) {
        this.invOfcCd = invOfcCd;
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
	 * @param calcTpCdCtnt
	 */
    public void setCalcTpCdCtnt(String calcTpCdCtnt) {
        this.calcTpCdCtnt = calcTpCdCtnt;
    }

    /**
	 * Column Info
	 * @param costOfcCd
	 */
    public void setCostOfcCd(String costOfcCd) {
        this.costOfcCd = costOfcCd;
    }

    /**
	 * Column Info
	 * @param invCfmDt
	 */
    public void setInvCfmDt(String invCfmDt) {
        this.invCfmDt = invCfmDt;
    }

    /**
	 * Column Info
	 * @param cfsCgoQty
	 */
    public void setCfsCgoQty(String cfsCgoQty) {
        this.cfsCgoQty = cfsCgoQty;
    }

    /**
	 * Column Info
	 * @param diffRto
	 */
    public void setDiffRto(String diffRto) {
        this.diffRto = diffRto;
    }

    /**
	 * Column Info
	 * @param expnAudStsCd
	 */
    public void setExpnAudStsCd(String expnAudStsCd) {
        this.expnAudStsCd = expnAudStsCd;
    }

    /**
	 * Column Info
	 * @param toPrdDt
	 */
    public void setToPrdDt(String toPrdDt) {
        this.toPrdDt = toPrdDt;
    }

    /**
	 * Column Info
	 * @param ioBndCd
	 */
    public void setIoBndCd(String ioBndCd) {
        this.ioBndCd = ioBndCd;
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
	 * @param batProgStsCd
	 */
    public void setBatProgStsCd(String batProgStsCd) {
        this.batProgStsCd = batProgStsCd;
    }

    /**
	 * Column Info
	 * @param invNo
	 */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    /**
	 * Column Info
	 * @param volAudTgtQty
	 */
    public void setVolAudTgtQty(String volAudTgtQty) {
        this.volAudTgtQty = volAudTgtQty;
    }

    /**
	 * Column Info
	 * @param batVolRsltCd
	 */
    public void setBatVolRsltCd(String batVolRsltCd) {
        this.batVolRsltCd = batVolRsltCd;
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
	 * @param invCreUsrNm
	 */
    public void setInvCreUsrNm(String invCreUsrNm) {
        this.invCreUsrNm = invCreUsrNm;
    }

    /**
	 * Column Info
	 * @param batEstmVolRsltCdQty
	 */
    public void setBatEstmVolRsltCdQty(String batEstmVolRsltCdQty) {
        this.batEstmVolRsltCdQty = batEstmVolRsltCdQty;
    }

    /**
	 * Column Info
	 * @param selAudCd
	 */
    public void setSelAudCd(String selAudCd) {
        this.selAudCd = selAudCd;
    }

    /**
	 * Column Info
	 * @param eacFlg
	 */
    public void setEacFlg(String eacFlg) {
        this.eacFlg = eacFlg;
    }

    /**
	 * Column Info
	 * @param expnAudRsltUsrNm
	 */
    public void setExpnAudRsltUsrNm(String expnAudRsltUsrNm) {
        this.expnAudRsltUsrNm = expnAudRsltUsrNm;
    }

    /**
	 * Column Info
	 * @param audUpdUsrId
	 */
    public void setAudUpdUsrId(String audUpdUsrId) {
        this.audUpdUsrId = audUpdUsrId;
    }

    public void setInvAudCurrCd(String invAudCurrCd) {
        this.invAudCurrCd = invAudCurrCd;
    }

    public String getInvAudCurrCd() {
        return this.invAudCurrCd;
    }

    public void setInvAudDiffAmt(String invAudDiffAmt) {
        this.invAudDiffAmt = invAudDiffAmt;
    }

    public String getInvAudDiffAmt() {
        return this.invAudDiffAmt;
    }

    public void setInvAudUsdDiffAmt(String invAudUsdDiffAmt) {
        this.invAudUsdDiffAmt = invAudUsdDiffAmt;
    }

    public String getInvAudUsdDiffAmt() {
        return this.invAudUsdDiffAmt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setDcgoQty(JSPUtil.getParameter(request, prefix + "dcgo_qty", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
        setAmtAudTgtFlg(JSPUtil.getParameter(request, prefix + "amt_aud_tgt_flg", ""));
        setAudCaseDtlQty(JSPUtil.getParameter(request, prefix + "aud_case_dtl_qty", ""));
        setSSaveTpCd(JSPUtil.getParameter(request, prefix + "s_save_tp_cd", ""));
        setAwkBbCgoQty(JSPUtil.getParameter(request, prefix + "awk_bb_cgo_qty", ""));
        setAudUpdUsrNm(JSPUtil.getParameter(request, prefix + "aud_upd_usr_nm", ""));
        setInvCfmDtYmd(JSPUtil.getParameter(request, prefix + "inv_cfm_dt_ymd", ""));
        setVrfyRsltCdCtnt(JSPUtil.getParameter(request, prefix + "vrfy_rslt_cd_ctnt", ""));
        setExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", ""));
        setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
        setInvPrdDt(JSPUtil.getParameter(request, prefix + "inv_prd_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
        setAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", ""));
        setCntrTtlQty(JSPUtil.getParameter(request, prefix + "cntr_ttl_qty", ""));
        setTmlInvRjctStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_rjct_sts_cd", ""));
        setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
        setBatRslt(JSPUtil.getParameter(request, prefix + "bat_rslt", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCsrStsCd(JSPUtil.getParameter(request, prefix + "csr_sts_cd", ""));
        setBatEstmVolRsltCd(JSPUtil.getParameter(request, prefix + "bat_estm_vol_rslt_cd", ""));
        setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
        setAudLgsCostCdQty(JSPUtil.getParameter(request, prefix + "aud_lgs_cost_cd_qty", ""));
        setExpnAudEstmAmt(JSPUtil.getParameter(request, prefix + "expn_aud_estm_amt", ""));
        setPayTerm(JSPUtil.getParameter(request, prefix + "pay_term", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setHngrCgoQty(JSPUtil.getParameter(request, prefix + "hngr_cgo_qty", ""));
        setBatchTpCd(JSPUtil.getParameter(request, prefix + "batch_tp_cd", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setDgRcQty(JSPUtil.getParameter(request, prefix + "dg_rc_qty", ""));
        setAudUpdDt(JSPUtil.getParameter(request, prefix + "aud_upd_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setBatAmtRsltCdQty(JSPUtil.getParameter(request, prefix + "bat_amt_rslt_cd_qty", ""));
        setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setBbCgoQty(JSPUtil.getParameter(request, prefix + "bb_cgo_qty", ""));
        setPrdYm(JSPUtil.getParameter(request, prefix + "prd_ym", ""));
        setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
        setBatAmtRsltCd(JSPUtil.getParameter(request, prefix + "bat_amt_rslt_cd", ""));
        setAutoAudBatSeq(JSPUtil.getParameter(request, prefix + "auto_aud_bat_seq", ""));
        setAudDtlTgtQty(JSPUtil.getParameter(request, prefix + "aud_dtl_tgt_qty", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setAwkCgoQty(JSPUtil.getParameter(request, prefix + "awk_cgo_qty", ""));
        setBatVolRsltCdQty(JSPUtil.getParameter(request, prefix + "bat_vol_rslt_cd_qty", ""));
        setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
        setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
        setExpnAudSeq(JSPUtil.getParameter(request, prefix + "expn_aud_seq", ""));
        setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
        setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRcQty(JSPUtil.getParameter(request, prefix + "rc_qty", ""));
        setExpnAudRsltUsrId(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_id", ""));
        setExpnAudRsltRmk(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setCalcTpCdCtnt(JSPUtil.getParameter(request, prefix + "calc_tp_cd_ctnt", ""));
        setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
        setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
        setCfsCgoQty(JSPUtil.getParameter(request, prefix + "cfs_cgo_qty", ""));
        setDiffRto(JSPUtil.getParameter(request, prefix + "diff_rto", ""));
        setExpnAudStsCd(JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", ""));
        setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
        setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setBatProgStsCd(JSPUtil.getParameter(request, prefix + "bat_prog_sts_cd", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setVolAudTgtQty(JSPUtil.getParameter(request, prefix + "vol_aud_tgt_qty", ""));
        setBatVolRsltCd(JSPUtil.getParameter(request, prefix + "bat_vol_rslt_cd", ""));
        setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
        setInvCreUsrNm(JSPUtil.getParameter(request, prefix + "inv_cre_usr_nm", ""));
        setBatEstmVolRsltCdQty(JSPUtil.getParameter(request, prefix + "bat_estm_vol_rslt_cd_qty", ""));
        setSelAudCd(JSPUtil.getParameter(request, prefix + "sel_aud_cd", ""));
        setEacFlg(JSPUtil.getParameter(request, prefix + "eac_flg", ""));
        setExpnAudRsltUsrNm(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_nm", ""));
        setAudUpdUsrId(JSPUtil.getParameter(request, prefix + "aud_upd_usr_id", ""));
        setInvAudCurrCd(JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", ""));
        setInvAudDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", ""));
        setInvAudUsdDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesInvoiceAuditVO[]
	 */
    public TesInvoiceAuditVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesInvoiceAuditVO[]
	 */
    public TesInvoiceAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TesInvoiceAuditVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] dcgoQty = (JSPUtil.getParameter(request, prefix + "dcgo_qty", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] payDt = (JSPUtil.getParameter(request, prefix + "pay_dt", length));
            String[] amtAudTgtFlg = (JSPUtil.getParameter(request, prefix + "amt_aud_tgt_flg", length));
            String[] audCaseDtlQty = (JSPUtil.getParameter(request, prefix + "aud_case_dtl_qty", length));
            String[] sSaveTpCd = (JSPUtil.getParameter(request, prefix + "s_save_tp_cd", length));
            String[] awkBbCgoQty = (JSPUtil.getParameter(request, prefix + "awk_bb_cgo_qty", length));
            String[] audUpdUsrNm = (JSPUtil.getParameter(request, prefix + "aud_upd_usr_nm", length));
            String[] invCfmDtYmd = (JSPUtil.getParameter(request, prefix + "inv_cfm_dt_ymd", length));
            String[] vrfyRsltCdCtnt = (JSPUtil.getParameter(request, prefix + "vrfy_rslt_cd_ctnt", length));
            String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", length));
            String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", length));
            String[] invPrdDt = (JSPUtil.getParameter(request, prefix + "inv_prd_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", length));
            String[] autoExpnAudStsCd = (JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", length));
            String[] cntrTtlQty = (JSPUtil.getParameter(request, prefix + "cntr_ttl_qty", length));
            String[] tmlInvRjctStsCd = (JSPUtil.getParameter(request, prefix + "tml_inv_rjct_sts_cd", length));
            String[] payDueDt = (JSPUtil.getParameter(request, prefix + "pay_due_dt", length));
            String[] batRslt = (JSPUtil.getParameter(request, prefix + "bat_rslt", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] csrStsCd = (JSPUtil.getParameter(request, prefix + "csr_sts_cd", length));
            String[] batEstmVolRsltCd = (JSPUtil.getParameter(request, prefix + "bat_estm_vol_rslt_cd", length));
            String[] fmPrdDt = (JSPUtil.getParameter(request, prefix + "fm_prd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] rhqCd = (JSPUtil.getParameter(request, prefix + "rhq_cd", length));
            String[] audLgsCostCdQty = (JSPUtil.getParameter(request, prefix + "aud_lgs_cost_cd_qty", length));
            String[] expnAudEstmAmt = (JSPUtil.getParameter(request, prefix + "expn_aud_estm_amt", length));
            String[] payTerm = (JSPUtil.getParameter(request, prefix + "pay_term", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] hngrCgoQty = (JSPUtil.getParameter(request, prefix + "hngr_cgo_qty", length));
            String[] batchTpCd = (JSPUtil.getParameter(request, prefix + "batch_tp_cd", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] dgRcQty = (JSPUtil.getParameter(request, prefix + "dg_rc_qty", length));
            String[] audUpdDt = (JSPUtil.getParameter(request, prefix + "aud_upd_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] batAmtRsltCdQty = (JSPUtil.getParameter(request, prefix + "bat_amt_rslt_cd_qty", length));
            String[] chk = (JSPUtil.getParameter(request, prefix + "chk", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] bbCgoQty = (JSPUtil.getParameter(request, prefix + "bb_cgo_qty", length));
            String[] prdYm = (JSPUtil.getParameter(request, prefix + "prd_ym", length));
            String[] fullMtyCd = (JSPUtil.getParameter(request, prefix + "full_mty_cd", length));
            String[] batAmtRsltCd = (JSPUtil.getParameter(request, prefix + "bat_amt_rslt_cd", length));
            String[] autoAudBatSeq = (JSPUtil.getParameter(request, prefix + "auto_aud_bat_seq", length));
            String[] audDtlTgtQty = (JSPUtil.getParameter(request, prefix + "aud_dtl_tgt_qty", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] awkCgoQty = (JSPUtil.getParameter(request, prefix + "awk_cgo_qty", length));
            String[] batVolRsltCdQty = (JSPUtil.getParameter(request, prefix + "bat_vol_rslt_cd_qty", length));
            String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", length));
            String[] atbDt = (JSPUtil.getParameter(request, prefix + "atb_dt", length));
            String[] expnAudSeq = (JSPUtil.getParameter(request, prefix + "expn_aud_seq", length));
            String[] issDt = (JSPUtil.getParameter(request, prefix + "iss_dt", length));
            String[] tsFlg = (JSPUtil.getParameter(request, prefix + "ts_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rcQty = (JSPUtil.getParameter(request, prefix + "rc_qty", length));
            String[] expnAudRsltUsrId = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_id", length));
            String[] expnAudRsltRmk = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] invOfcCd = (JSPUtil.getParameter(request, prefix + "inv_ofc_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] calcTpCdCtnt = (JSPUtil.getParameter(request, prefix + "calc_tp_cd_ctnt", length));
            String[] costOfcCd = (JSPUtil.getParameter(request, prefix + "cost_ofc_cd", length));
            String[] invCfmDt = (JSPUtil.getParameter(request, prefix + "inv_cfm_dt", length));
            String[] cfsCgoQty = (JSPUtil.getParameter(request, prefix + "cfs_cgo_qty", length));
            String[] diffRto = (JSPUtil.getParameter(request, prefix + "diff_rto", length));
            String[] expnAudStsCd = (JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", length));
            String[] toPrdDt = (JSPUtil.getParameter(request, prefix + "to_prd_dt", length));
            String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] batProgStsCd = (JSPUtil.getParameter(request, prefix + "bat_prog_sts_cd", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] volAudTgtQty = (JSPUtil.getParameter(request, prefix + "vol_aud_tgt_qty", length));
            String[] batVolRsltCd = (JSPUtil.getParameter(request, prefix + "bat_vol_rslt_cd", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] invCreUsrNm = (JSPUtil.getParameter(request, prefix + "inv_cre_usr_nm", length));
            String[] batEstmVolRsltCdQty = (JSPUtil.getParameter(request, prefix + "bat_estm_vol_rslt_cd_qty", length));
            String[] selAudCd = (JSPUtil.getParameter(request, prefix + "sel_aud_cd", length));
            String[] eacFlg = (JSPUtil.getParameter(request, prefix + "eac_flg", length));
            String[] expnAudRsltUsrNm = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_nm", length));
            String[] audUpdUsrId = (JSPUtil.getParameter(request, prefix + "aud_upd_usr_id", length));
            String[] invAudCurrCd = (JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", length));
	    	String[] invAudDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", length));
	    	String[] invAudUsdDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new TesInvoiceAuditVO();
                if (dcgoQty[i] != null)
                    model.setDcgoQty(dcgoQty[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (payDt[i] != null)
                    model.setPayDt(payDt[i]);
                if (amtAudTgtFlg[i] != null)
                    model.setAmtAudTgtFlg(amtAudTgtFlg[i]);
                if (audCaseDtlQty[i] != null)
                    model.setAudCaseDtlQty(audCaseDtlQty[i]);
                if (sSaveTpCd[i] != null)
                    model.setSSaveTpCd(sSaveTpCd[i]);
                if (awkBbCgoQty[i] != null)
                    model.setAwkBbCgoQty(awkBbCgoQty[i]);
                if (audUpdUsrNm[i] != null)
                    model.setAudUpdUsrNm(audUpdUsrNm[i]);
                if (invCfmDtYmd[i] != null)
                    model.setInvCfmDtYmd(invCfmDtYmd[i]);
                if (vrfyRsltCdCtnt[i] != null)
                    model.setVrfyRsltCdCtnt(vrfyRsltCdCtnt[i]);
                if (expnAudRsltCd[i] != null)
                    model.setExpnAudRsltCd(expnAudRsltCd[i]);
                if (tmlInvTpCd[i] != null)
                    model.setTmlInvTpCd(tmlInvTpCd[i]);
                if (invPrdDt[i] != null)
                    model.setInvPrdDt(invPrdDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (atchFileLnkId[i] != null)
                    model.setAtchFileLnkId(atchFileLnkId[i]);
                if (autoExpnAudStsCd[i] != null)
                    model.setAutoExpnAudStsCd(autoExpnAudStsCd[i]);
                if (cntrTtlQty[i] != null)
                    model.setCntrTtlQty(cntrTtlQty[i]);
                if (tmlInvRjctStsCd[i] != null)
                    model.setTmlInvRjctStsCd(tmlInvRjctStsCd[i]);
                if (payDueDt[i] != null)
                    model.setPayDueDt(payDueDt[i]);
                if (batRslt[i] != null)
                    model.setBatRslt(batRslt[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (csrStsCd[i] != null)
                    model.setCsrStsCd(csrStsCd[i]);
                if (batEstmVolRsltCd[i] != null)
                    model.setBatEstmVolRsltCd(batEstmVolRsltCd[i]);
                if (fmPrdDt[i] != null)
                    model.setFmPrdDt(fmPrdDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (rhqCd[i] != null)
                    model.setRhqCd(rhqCd[i]);
                if (audLgsCostCdQty[i] != null)
                    model.setAudLgsCostCdQty(audLgsCostCdQty[i]);
                if (expnAudEstmAmt[i] != null)
                    model.setExpnAudEstmAmt(expnAudEstmAmt[i]);
                if (payTerm[i] != null)
                    model.setPayTerm(payTerm[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (hngrCgoQty[i] != null)
                    model.setHngrCgoQty(hngrCgoQty[i]);
                if (batchTpCd[i] != null)
                    model.setBatchTpCd(batchTpCd[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (dgRcQty[i] != null)
                    model.setDgRcQty(dgRcQty[i]);
                if (audUpdDt[i] != null)
                    model.setAudUpdDt(audUpdDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (batAmtRsltCdQty[i] != null)
                    model.setBatAmtRsltCdQty(batAmtRsltCdQty[i]);
                if (chk[i] != null)
                    model.setChk(chk[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (bbCgoQty[i] != null)
                    model.setBbCgoQty(bbCgoQty[i]);
                if (prdYm[i] != null)
                    model.setPrdYm(prdYm[i]);
                if (fullMtyCd[i] != null)
                    model.setFullMtyCd(fullMtyCd[i]);
                if (batAmtRsltCd[i] != null)
                    model.setBatAmtRsltCd(batAmtRsltCd[i]);
                if (autoAudBatSeq[i] != null)
                    model.setAutoAudBatSeq(autoAudBatSeq[i]);
                if (audDtlTgtQty[i] != null)
                    model.setAudDtlTgtQty(audDtlTgtQty[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (awkCgoQty[i] != null)
                    model.setAwkCgoQty(awkCgoQty[i]);
                if (batVolRsltCdQty[i] != null)
                    model.setBatVolRsltCdQty(batVolRsltCdQty[i]);
                if (calcCostGrpCd[i] != null)
                    model.setCalcCostGrpCd(calcCostGrpCd[i]);
                if (atbDt[i] != null)
                    model.setAtbDt(atbDt[i]);
                if (expnAudSeq[i] != null)
                    model.setExpnAudSeq(expnAudSeq[i]);
                if (issDt[i] != null)
                    model.setIssDt(issDt[i]);
                if (tsFlg[i] != null)
                    model.setTsFlg(tsFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rcQty[i] != null)
                    model.setRcQty(rcQty[i]);
                if (expnAudRsltUsrId[i] != null)
                    model.setExpnAudRsltUsrId(expnAudRsltUsrId[i]);
                if (expnAudRsltRmk[i] != null)
                    model.setExpnAudRsltRmk(expnAudRsltRmk[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (invOfcCd[i] != null)
                    model.setInvOfcCd(invOfcCd[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (calcTpCdCtnt[i] != null)
                    model.setCalcTpCdCtnt(calcTpCdCtnt[i]);
                if (costOfcCd[i] != null)
                    model.setCostOfcCd(costOfcCd[i]);
                if (invCfmDt[i] != null)
                    model.setInvCfmDt(invCfmDt[i]);
                if (cfsCgoQty[i] != null)
                    model.setCfsCgoQty(cfsCgoQty[i]);
                if (diffRto[i] != null)
                    model.setDiffRto(diffRto[i]);
                if (expnAudStsCd[i] != null)
                    model.setExpnAudStsCd(expnAudStsCd[i]);
                if (toPrdDt[i] != null)
                    model.setToPrdDt(toPrdDt[i]);
                if (ioBndCd[i] != null)
                    model.setIoBndCd(ioBndCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (batProgStsCd[i] != null)
                    model.setBatProgStsCd(batProgStsCd[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (volAudTgtQty[i] != null)
                    model.setVolAudTgtQty(volAudTgtQty[i]);
                if (batVolRsltCd[i] != null)
                    model.setBatVolRsltCd(batVolRsltCd[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (invCreUsrNm[i] != null)
                    model.setInvCreUsrNm(invCreUsrNm[i]);
                if (batEstmVolRsltCdQty[i] != null)
                    model.setBatEstmVolRsltCdQty(batEstmVolRsltCdQty[i]);
                if (selAudCd[i] != null)
                    model.setSelAudCd(selAudCd[i]);
                if (eacFlg[i] != null)
                    model.setEacFlg(eacFlg[i]);
                if (expnAudRsltUsrNm[i] != null)
                    model.setExpnAudRsltUsrNm(expnAudRsltUsrNm[i]);
                if (audUpdUsrId[i] != null)
                    model.setAudUpdUsrId(audUpdUsrId[i]);
                if (invAudCurrCd[i] != null) 
		    		model.setInvAudCurrCd(invAudCurrCd[i]);
				if (invAudDiffAmt[i] != null) 
		    		model.setInvAudDiffAmt(invAudDiffAmt[i]);
				if (invAudUsdDiffAmt[i] != null) 
		    		model.setInvAudUsdDiffAmt(invAudUsdDiffAmt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTesInvoiceAuditVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TesInvoiceAuditVO[]
	 */
    public TesInvoiceAuditVO[] getTesInvoiceAuditVOs() {
        TesInvoiceAuditVO[] vos = (TesInvoiceAuditVO[]) models.toArray(new TesInvoiceAuditVO[models.size()]);
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
        this.dcgoQty = this.dcgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDt = this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amtAudTgtFlg = this.amtAudTgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audCaseDtlQty = this.audCaseDtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSaveTpCd = this.sSaveTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkBbCgoQty = this.awkBbCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audUpdUsrNm = this.audUpdUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCfmDtYmd = this.invCfmDtYmd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vrfyRsltCdCtnt = this.vrfyRsltCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltCd = this.expnAudRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlInvTpCd = this.tmlInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPrdDt = this.invPrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atchFileLnkId = this.atchFileLnkId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoExpnAudStsCd = this.autoExpnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTtlQty = this.cntrTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tmlInvRjctStsCd = this.tmlInvRjctStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDueDt = this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batRslt = this.batRslt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrStsCd = this.csrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batEstmVolRsltCd = this.batEstmVolRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmPrdDt = this.fmPrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqCd = this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audLgsCostCdQty = this.audLgsCostCdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudEstmAmt = this.expnAudEstmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payTerm = this.payTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrCgoQty = this.hngrCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batchTpCd = this.batchTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgRcQty = this.dgRcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audUpdDt = this.audUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batAmtRsltCdQty = this.batAmtRsltCdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chk = this.chk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoQty = this.bbCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prdYm = this.prdYm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullMtyCd = this.fullMtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batAmtRsltCd = this.batAmtRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAudBatSeq = this.autoAudBatSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audDtlTgtQty = this.audDtlTgtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoQty = this.awkCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batVolRsltCdQty = this.batVolRsltCdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcCostGrpCd = this.calcCostGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atbDt = this.atbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudSeq = this.expnAudSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issDt = this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsFlg = this.tsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcQty = this.rcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltUsrId = this.expnAudRsltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltRmk = this.expnAudRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invOfcCd = this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcTpCdCtnt = this.calcTpCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costOfcCd = this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCfmDt = this.invCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfsCgoQty = this.cfsCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRto = this.diffRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudStsCd = this.expnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toPrdDt = this.toPrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batProgStsCd = this.batProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.volAudTgtQty = this.volAudTgtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batVolRsltCd = this.batVolRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCreUsrNm = this.invCreUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batEstmVolRsltCdQty = this.batEstmVolRsltCdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selAudCd = this.selAudCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacFlg = this.eacFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltUsrNm = this.expnAudRsltUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audUpdUsrId = this.audUpdUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudCurrCd = this.invAudCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudDiffAmt = this.invAudDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudUsdDiffAmt = this.invAudUsdDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
