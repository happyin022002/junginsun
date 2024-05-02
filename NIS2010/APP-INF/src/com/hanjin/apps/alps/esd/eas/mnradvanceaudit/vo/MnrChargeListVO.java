package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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

public class MnrChargeListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MnrChargeListVO> models = new ArrayList<MnrChargeListVO>();

    private String estVrfyDesc = null;

    private String woCurrCd = null;

    private String sSaveTpCd = null;

    private String rsltChk = null;

    private String invDiffAmt = null;

    private String expnAudRsltCd = null;

    private String apPayDt = null;

    private String pagerows = null;

    private String atchFileLnkId = null;

    private String autoExpnAudStsCd = null;

    private String vndrNm = null;

    private String invStsCd = null;

    private String payDueDt = null;

    private String chekedDt = null;

    private String mnrWrkAmt = null;

    private String woVrfyFlg = null;

    private String sprPrtUcAmt = null;

    private String estmVrfyFlg = null;

    private String invDiffPct = null;

    private String updUsrId = null;

    private String mnrWoErrFlg = null;

    private String autoAudit = null;

    private String currCngFlg = null;

    private String eqKndCdNm = null;

    private String csrNo = null;

    private String rhqCd = null;

    private String selectFlgTemp = null;

    private String estmVrfyDesc = null;

    private String cfmDt = null;

    private String toDatetime = null;

    private String wkVrfyDesc = null;

    private String selectFlg = null;

    private String batchTpCd = null;

    private String chgWoAmt = null;

    private String invDiffRto = null;

    private String creUsrId = null;

    private String vndrSeq = null;

    private String estVrfyYn = null;

    private String checkedUserNm = null;

    private String currCd = null;

    private String creDt = null;

    private String auditDt = null;

    private String issDt = null;

    private String ibflag = null;

    private String sToDt = null;

    private String mnrAgmtAmt = null;

    private String expnAudRsltUsrId = null;

    private String expnAudRsltRmk = null;

    private String costAmt = null;

    private String creOfcCd = null;

    private String expnMaxPrmtRto = null;

    private String eacYn = null;

    private String invCreUserId = null;

    private String reflExYn = null;

    private String invAmt = null;

    private String sFmDt = null;

    private String woInvRto = null;

    private String wkVrfyYn = null;

    private String invStsNm = null;

    private String woAmt = null;

    private String invOfcCd = null;

    private String invRgstNo = null;

    private String updDt = null;

    private String genPayTermCd = null;

    private String invChgAmt = null;

    private String invCfmDt = null;

    private String loclCreDt = null;

    private String expnAudStsCd = null;

    private String invCreUserNm = null;

    private String mnrEstErrFlg = null;

    private String eqKndCd = null;

    private String bzcAmt = null;

    private String invCurrCd = null;

    private String auditResult = null;

    private String invNo = null;

    private String woVrfyDesc = null;

    private String invRmk = null;

    private String ttlInvAmt = null;

    private String sel = null;

    private String expnAudRsltUsrNm = null;

    private String checkedUserId = null;

    private String issOfcCd = null;

    private String mnrInpTpCd = null;

    private String batProgStsCd = null;

    private String batProgStsNm = null;

    private String checkedDt = null;

    private String rhqInvOfcCd = null;

    private String mltWoCurrFlg = null;

    private String invAudCurrCd = null;

    private String invAudDiffAmt = null;

    private String invAudUsdDiffAmt = null;

    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public MnrChargeListVO() {
    }

    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("est_vrfy_desc", getEstVrfyDesc());
        this.hashColumns.put("wo_curr_cd", getWoCurrCd());
        this.hashColumns.put("s_save_tp_cd", getSSaveTpCd());
        this.hashColumns.put("rslt_chk", getRsltChk());
        this.hashColumns.put("inv_diff_amt", getInvDiffAmt());
        this.hashColumns.put("expn_aud_rslt_cd", getExpnAudRsltCd());
        this.hashColumns.put("ap_pay_dt", getApPayDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
        this.hashColumns.put("auto_expn_aud_sts_cd", getAutoExpnAudStsCd());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("inv_sts_cd", getInvStsCd());
        this.hashColumns.put("pay_due_dt", getPayDueDt());
        this.hashColumns.put("cheked_dt", getChekedDt());
        this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
        this.hashColumns.put("wo_vrfy_flg", getWoVrfyFlg());
        this.hashColumns.put("spr_prt_uc_amt", getSprPrtUcAmt());
        this.hashColumns.put("estm_vrfy_flg", getEstmVrfyFlg());
        this.hashColumns.put("inv_diff_pct", getInvDiffPct());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("mnr_wo_err_flg", getMnrWoErrFlg());
        this.hashColumns.put("auto_audit", getAutoAudit());
        this.hashColumns.put("curr_cng_flg", getCurrCngFlg());
        this.hashColumns.put("eq_knd_cd_nm", getEqKndCdNm());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("rhq_cd", getRhqCd());
        this.hashColumns.put("select_flg_temp", getSelectFlgTemp());
        this.hashColumns.put("estm_vrfy_desc", getEstmVrfyDesc());
        this.hashColumns.put("cfm_dt", getCfmDt());
        this.hashColumns.put("to_datetime", getToDatetime());
        this.hashColumns.put("wk_vrfy_desc", getWkVrfyDesc());
        this.hashColumns.put("select_flg", getSelectFlg());
        this.hashColumns.put("batch_tp_cd", getBatchTpCd());
        this.hashColumns.put("chg_wo_amt", getChgWoAmt());
        this.hashColumns.put("inv_diff_rto", getInvDiffRto());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("est_vrfy_yn", getEstVrfyYn());
        this.hashColumns.put("checked_user_nm", getCheckedUserNm());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("audit_dt", getAuditDt());
        this.hashColumns.put("iss_dt", getIssDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("s_to_dt", getSToDt());
        this.hashColumns.put("mnr_agmt_amt", getMnrAgmtAmt());
        this.hashColumns.put("expn_aud_rslt_usr_id", getExpnAudRsltUsrId());
        this.hashColumns.put("expn_aud_rslt_rmk", getExpnAudRsltRmk());
        this.hashColumns.put("cost_amt", getCostAmt());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("expn_max_prmt_rto", getExpnMaxPrmtRto());
        this.hashColumns.put("eac_yn", getEacYn());
        this.hashColumns.put("inv_cre_user_id", getInvCreUserId());
        this.hashColumns.put("refl_ex_yn", getReflExYn());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("s_fm_dt", getSFmDt());
        this.hashColumns.put("wo_inv_rto", getWoInvRto());
        this.hashColumns.put("wk_vrfy_yn", getWkVrfyYn());
        this.hashColumns.put("inv_sts_nm", getInvStsNm());
        this.hashColumns.put("wo_amt", getWoAmt());
        this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
        this.hashColumns.put("inv_rgst_no", getInvRgstNo());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
        this.hashColumns.put("inv_chg_amt", getInvChgAmt());
        this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
        this.hashColumns.put("locl_cre_dt", getLoclCreDt());
        this.hashColumns.put("expn_aud_sts_cd", getExpnAudStsCd());
        this.hashColumns.put("inv_cre_user_nm", getInvCreUserNm());
        this.hashColumns.put("mnr_est_err_flg", getMnrEstErrFlg());
        this.hashColumns.put("eq_knd_cd", getEqKndCd());
        this.hashColumns.put("bzc_amt", getBzcAmt());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("audit_result", getAuditResult());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("wo_vrfy_desc", getWoVrfyDesc());
        this.hashColumns.put("inv_rmk", getInvRmk());
        this.hashColumns.put("ttl_inv_amt", getTtlInvAmt());
        this.hashColumns.put("sel", getSel());
        this.hashColumns.put("expn_aud_rslt_usr_nm", getExpnAudRsltUsrNm());
        this.hashColumns.put("checked_user_id", getCheckedUserId());
        this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
        this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
        this.hashColumns.put("bat_prog_sts_cd", getBatProgStsCd());
        this.hashColumns.put("bat_prog_sts_nm", getBatProgStsNm());
        this.hashColumns.put("checked_dt", getCheckedDt());
        this.hashColumns.put("rhq_inv_ofc_cd", getRhqInvOfcCd());
        this.hashColumns.put("mlt_wo_curr_flg", getMltWoCurrFlg());
        this.hashColumns.put("inv_aud_curr_cd", getInvAudCurrCd());
        this.hashColumns.put("inv_aud_diff_amt", getInvAudDiffAmt());
        this.hashColumns.put("inv_aud_usd_diff_amt", getInvAudUsdDiffAmt());
        return this.hashColumns;
    }

    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("est_vrfy_desc", "estVrfyDesc");
        this.hashFields.put("wo_curr_cd", "woCurrCd");
        this.hashFields.put("s_save_tp_cd", "sSaveTpCd");
        this.hashFields.put("rslt_chk", "rsltChk");
        this.hashFields.put("inv_diff_amt", "invDiffAmt");
        this.hashFields.put("expn_aud_rslt_cd", "expnAudRsltCd");
        this.hashFields.put("ap_pay_dt", "apPayDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
        this.hashFields.put("auto_expn_aud_sts_cd", "autoExpnAudStsCd");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("inv_sts_cd", "invStsCd");
        this.hashFields.put("pay_due_dt", "payDueDt");
        this.hashFields.put("cheked_dt", "chekedDt");
        this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
        this.hashFields.put("wo_vrfy_flg", "woVrfyFlg");
        this.hashFields.put("spr_prt_uc_amt", "sprPrtUcAmt");
        this.hashFields.put("estm_vrfy_flg", "estmVrfyFlg");
        this.hashFields.put("inv_diff_pct", "invDiffPct");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("mnr_wo_err_flg", "mnrWoErrFlg");
        this.hashFields.put("auto_audit", "autoAudit");
        this.hashFields.put("curr_cng_flg", "currCngFlg");
        this.hashFields.put("eq_knd_cd_nm", "eqKndCdNm");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("rhq_cd", "rhqCd");
        this.hashFields.put("select_flg_temp", "selectFlgTemp");
        this.hashFields.put("estm_vrfy_desc", "estmVrfyDesc");
        this.hashFields.put("cfm_dt", "cfmDt");
        this.hashFields.put("to_datetime", "toDatetime");
        this.hashFields.put("wk_vrfy_desc", "wkVrfyDesc");
        this.hashFields.put("select_flg", "selectFlg");
        this.hashFields.put("batch_tp_cd", "batchTpCd");
        this.hashFields.put("chg_wo_amt", "chgWoAmt");
        this.hashFields.put("inv_diff_rto", "invDiffRto");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("est_vrfy_yn", "estVrfyYn");
        this.hashFields.put("checked_user_nm", "checkedUserNm");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("audit_dt", "auditDt");
        this.hashFields.put("iss_dt", "issDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("s_to_dt", "sToDt");
        this.hashFields.put("mnr_agmt_amt", "mnrAgmtAmt");
        this.hashFields.put("expn_aud_rslt_usr_id", "expnAudRsltUsrId");
        this.hashFields.put("expn_aud_rslt_rmk", "expnAudRsltRmk");
        this.hashFields.put("cost_amt", "costAmt");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("expn_max_prmt_rto", "expnMaxPrmtRto");
        this.hashFields.put("eac_yn", "eacYn");
        this.hashFields.put("inv_cre_user_id", "invCreUserId");
        this.hashFields.put("refl_ex_yn", "reflExYn");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("s_fm_dt", "sFmDt");
        this.hashFields.put("wo_inv_rto", "woInvRto");
        this.hashFields.put("wk_vrfy_yn", "wkVrfyYn");
        this.hashFields.put("inv_sts_nm", "invStsNm");
        this.hashFields.put("wo_amt", "woAmt");
        this.hashFields.put("inv_ofc_cd", "invOfcCd");
        this.hashFields.put("inv_rgst_no", "invRgstNo");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
        this.hashFields.put("inv_chg_amt", "invChgAmt");
        this.hashFields.put("inv_cfm_dt", "invCfmDt");
        this.hashFields.put("locl_cre_dt", "loclCreDt");
        this.hashFields.put("expn_aud_sts_cd", "expnAudStsCd");
        this.hashFields.put("inv_cre_user_nm", "invCreUserNm");
        this.hashFields.put("mnr_est_err_flg", "mnrEstErrFlg");
        this.hashFields.put("eq_knd_cd", "eqKndCd");
        this.hashFields.put("bzc_amt", "bzcAmt");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("audit_result", "auditResult");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("wo_vrfy_desc", "woVrfyDesc");
        this.hashFields.put("inv_rmk", "invRmk");
        this.hashFields.put("ttl_inv_amt", "ttlInvAmt");
        this.hashFields.put("sel", "sel");
        this.hashFields.put("expn_aud_rslt_usr_nm", "expnAudRsltUsrNm");
        this.hashFields.put("checked_user_id", "checkedUserId");
        this.hashFields.put("iss_ofc_cd", "issOfcCd");
        this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
        this.hashFields.put("bat_prog_sts_cd", "batProgStsCd");
        this.hashFields.put("bat_prog_sts_nm", "batProgStsNm");
        this.hashFields.put("checked_dt", "checkedDt");
        this.hashFields.put("rhq_inv_ofc_cd", "rhqInvOfcCd");
        this.hashFields.put("mlt_wo_curr_flg", "mltWoCurrFlg");
        this.hashFields.put("inv_aud_curr_cd", "invAudCurrCd");
        this.hashFields.put("inv_aud_diff_amt", "invAudDiffAmt");
        this.hashFields.put("inv_aud_usd_diff_amt", "invAudUsdDiffAmt");
        return this.hashFields;
    }

    public String getEstVrfyDesc() {
        return this.estVrfyDesc;
    }

    public String getWoCurrCd() {
        return this.woCurrCd;
    }

    public String getSSaveTpCd() {
        return this.sSaveTpCd;
    }

    public String getRsltChk() {
        return this.rsltChk;
    }

    public String getInvDiffAmt() {
        return this.invDiffAmt;
    }

    public String getExpnAudRsltCd() {
        return this.expnAudRsltCd;
    }

    public String getApPayDt() {
        return this.apPayDt;
    }

    public String getPagerows() {
        return this.pagerows;
    }

    public String getAtchFileLnkId() {
        return this.atchFileLnkId;
    }

    public String getAutoExpnAudStsCd() {
        return this.autoExpnAudStsCd;
    }

    public String getVndrNm() {
        return this.vndrNm;
    }

    public String getInvStsCd() {
        return this.invStsCd;
    }

    public String getPayDueDt() {
        return this.payDueDt;
    }

    public String getChekedDt() {
        return this.chekedDt;
    }

    public String getMnrWrkAmt() {
        return this.mnrWrkAmt;
    }

    public String getWoVrfyFlg() {
        return this.woVrfyFlg;
    }

    public String getSprPrtUcAmt() {
        return this.sprPrtUcAmt;
    }

    public String getEstmVrfyFlg() {
        return this.estmVrfyFlg;
    }

    public String getInvDiffPct() {
        return this.invDiffPct;
    }

    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public String getMnrWoErrFlg() {
        return this.mnrWoErrFlg;
    }

    public String getAutoAudit() {
        return this.autoAudit;
    }

    public String getCurrCngFlg() {
        return this.currCngFlg;
    }

    public String getEqKndCdNm() {
        return this.eqKndCdNm;
    }

    public String getCsrNo() {
        return this.csrNo;
    }

    public String getRhqCd() {
        return this.rhqCd;
    }

    public String getSelectFlgTemp() {
        return this.selectFlgTemp;
    }

    public String getEstmVrfyDesc() {
        return this.estmVrfyDesc;
    }

    public String getCfmDt() {
        return this.cfmDt;
    }

    public String getToDatetime() {
        return this.toDatetime;
    }

    public String getWkVrfyDesc() {
        return this.wkVrfyDesc;
    }

    public String getSelectFlg() {
        return this.selectFlg;
    }

    public String getBatchTpCd() {
        return this.batchTpCd;
    }

    public String getChgWoAmt() {
        return this.chgWoAmt;
    }

    public String getInvDiffRto() {
        return this.invDiffRto;
    }

    public String getCreUsrId() {
        return this.creUsrId;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
    }

    public String getEstVrfyYn() {
        return this.estVrfyYn;
    }

    public String getCheckedUserNm() {
        return this.checkedUserNm;
    }

    public String getCurrCd() {
        return this.currCd;
    }

    public String getCreDt() {
        return this.creDt;
    }

    public String getAuditDt() {
        return this.auditDt;
    }

    public String getIssDt() {
        return this.issDt;
    }

    public String getIbflag() {
        return this.ibflag;
    }

    public String getSToDt() {
        return this.sToDt;
    }

    public String getMnrAgmtAmt() {
        return this.mnrAgmtAmt;
    }

    public String getExpnAudRsltUsrId() {
        return this.expnAudRsltUsrId;
    }

    public String getExpnAudRsltRmk() {
        return this.expnAudRsltRmk;
    }

    public String getCostAmt() {
        return this.costAmt;
    }

    public String getCreOfcCd() {
        return this.creOfcCd;
    }

    public String getExpnMaxPrmtRto() {
        return this.expnMaxPrmtRto;
    }

    public String getEacYn() {
        return this.eacYn;
    }

    public String getInvCreUserId() {
        return this.invCreUserId;
    }

    public String getReflExYn() {
        return this.reflExYn;
    }

    public String getInvAmt() {
        return this.invAmt;
    }

    public String getSFmDt() {
        return this.sFmDt;
    }

    public String getWoInvRto() {
        return this.woInvRto;
    }

    public String getWkVrfyYn() {
        return this.wkVrfyYn;
    }

    public String getInvStsNm() {
        return this.invStsNm;
    }

    public String getWoAmt() {
        return this.woAmt;
    }

    public String getInvOfcCd() {
        return this.invOfcCd;
    }

    public String getInvRgstNo() {
        return this.invRgstNo;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public String getGenPayTermCd() {
        return this.genPayTermCd;
    }

    public String getInvChgAmt() {
        return this.invChgAmt;
    }

    public String getInvCfmDt() {
        return this.invCfmDt;
    }

    public String getLoclCreDt() {
        return this.loclCreDt;
    }

    public String getExpnAudStsCd() {
        return this.expnAudStsCd;
    }

    public String getInvCreUserNm() {
        return this.invCreUserNm;
    }

    public String getMnrEstErrFlg() {
        return this.mnrEstErrFlg;
    }

    public String getEqKndCd() {
        return this.eqKndCd;
    }

    public String getBzcAmt() {
        return this.bzcAmt;
    }

    public String getInvCurrCd() {
        return this.invCurrCd;
    }

    public String getAuditResult() {
        return this.auditResult;
    }

    public String getInvNo() {
        return this.invNo;
    }

    public String getWoVrfyDesc() {
        return this.woVrfyDesc;
    }

    public String getInvRmk() {
        return this.invRmk;
    }

    public String getTtlInvAmt() {
        return this.ttlInvAmt;
    }

    public String getSel() {
        return this.sel;
    }

    public String getExpnAudRsltUsrNm() {
        return this.expnAudRsltUsrNm;
    }

    public String getCheckedUserId() {
        return this.checkedUserId;
    }

    public String getIssOfcCd() {
        return this.issOfcCd;
    }

    public String getMnrInpTpCd() {
        return this.mnrInpTpCd;
    }

    public String getBatProgStsCd() {
        return this.batProgStsCd;
    }

    public String getBatProgStsNm() {
        return this.batProgStsNm;
    }

    public String getCheckedDt() {
        return this.checkedDt;
    }

    public String getRhqInvOfcCd() {
        return this.rhqInvOfcCd;
    }

    public String getMltWoCurrFlg() {
        return this.mltWoCurrFlg;
    }

    public void setEstVrfyDesc(String estVrfyDesc) {
        this.estVrfyDesc = estVrfyDesc;
    }

    public void setWoCurrCd(String woCurrCd) {
        this.woCurrCd = woCurrCd;
    }

    public void setSSaveTpCd(String sSaveTpCd) {
        this.sSaveTpCd = sSaveTpCd;
    }

    public void setRsltChk(String rsltChk) {
        this.rsltChk = rsltChk;
    }

    public void setInvDiffAmt(String invDiffAmt) {
        this.invDiffAmt = invDiffAmt;
    }

    public void setExpnAudRsltCd(String expnAudRsltCd) {
        this.expnAudRsltCd = expnAudRsltCd;
    }

    public void setApPayDt(String apPayDt) {
        this.apPayDt = apPayDt;
    }

    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setAtchFileLnkId(String atchFileLnkId) {
        this.atchFileLnkId = atchFileLnkId;
    }

    public void setAutoExpnAudStsCd(String autoExpnAudStsCd) {
        this.autoExpnAudStsCd = autoExpnAudStsCd;
    }

    public void setVndrNm(String vndrNm) {
        this.vndrNm = vndrNm;
    }

    public void setInvStsCd(String invStsCd) {
        this.invStsCd = invStsCd;
    }

    public void setPayDueDt(String payDueDt) {
        this.payDueDt = payDueDt;
    }

    public void setChekedDt(String chekedDt) {
        this.chekedDt = chekedDt;
    }

    public void setMnrWrkAmt(String mnrWrkAmt) {
        this.mnrWrkAmt = mnrWrkAmt;
    }

    public void setWoVrfyFlg(String woVrfyFlg) {
        this.woVrfyFlg = woVrfyFlg;
    }

    public void setSprPrtUcAmt(String sprPrtUcAmt) {
        this.sprPrtUcAmt = sprPrtUcAmt;
    }

    public void setEstmVrfyFlg(String estmVrfyFlg) {
        this.estmVrfyFlg = estmVrfyFlg;
    }

    public void setInvDiffPct(String invDiffPct) {
        this.invDiffPct = invDiffPct;
    }

    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    public void setMnrWoErrFlg(String mnrWoErrFlg) {
        this.mnrWoErrFlg = mnrWoErrFlg;
    }

    public void setAutoAudit(String autoAudit) {
        this.autoAudit = autoAudit;
    }

    public void setCurrCngFlg(String currCngFlg) {
        this.currCngFlg = currCngFlg;
    }

    public void setEqKndCdNm(String eqKndCdNm) {
        this.eqKndCdNm = eqKndCdNm;
    }

    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    public void setRhqCd(String rhqCd) {
        this.rhqCd = rhqCd;
    }

    public void setSelectFlgTemp(String selectFlgTemp) {
        this.selectFlgTemp = selectFlgTemp;
    }

    public void setEstmVrfyDesc(String estmVrfyDesc) {
        this.estmVrfyDesc = estmVrfyDesc;
    }

    public void setCfmDt(String cfmDt) {
        this.cfmDt = cfmDt;
    }

    public void setToDatetime(String toDatetime) {
        this.toDatetime = toDatetime;
    }

    public void setWkVrfyDesc(String wkVrfyDesc) {
        this.wkVrfyDesc = wkVrfyDesc;
    }

    public void setSelectFlg(String selectFlg) {
        this.selectFlg = selectFlg;
    }

    public void setBatchTpCd(String batchTpCd) {
        this.batchTpCd = batchTpCd;
    }

    public void setChgWoAmt(String chgWoAmt) {
        this.chgWoAmt = chgWoAmt;
    }

    public void setInvDiffRto(String invDiffRto) {
        this.invDiffRto = invDiffRto;
    }

    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public void setEstVrfyYn(String estVrfyYn) {
        this.estVrfyYn = estVrfyYn;
    }

    public void setCheckedUserNm(String checkedUserNm) {
        this.checkedUserNm = checkedUserNm;
    }

    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    public void setAuditDt(String auditDt) {
        this.auditDt = auditDt;
    }

    public void setIssDt(String issDt) {
        this.issDt = issDt;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public void setSToDt(String sToDt) {
        this.sToDt = sToDt;
    }

    public void setMnrAgmtAmt(String mnrAgmtAmt) {
        this.mnrAgmtAmt = mnrAgmtAmt;
    }

    public void setExpnAudRsltUsrId(String expnAudRsltUsrId) {
        this.expnAudRsltUsrId = expnAudRsltUsrId;
    }

    public void setExpnAudRsltRmk(String expnAudRsltRmk) {
        this.expnAudRsltRmk = expnAudRsltRmk;
    }

    public void setCostAmt(String costAmt) {
        this.costAmt = costAmt;
    }

    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
    }

    public void setExpnMaxPrmtRto(String expnMaxPrmtRto) {
        this.expnMaxPrmtRto = expnMaxPrmtRto;
    }

    public void setEacYn(String eacYn) {
        this.eacYn = eacYn;
    }

    public void setInvCreUserId(String invCreUserId) {
        this.invCreUserId = invCreUserId;
    }

    public void setReflExYn(String reflExYn) {
        this.reflExYn = reflExYn;
    }

    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    public void setSFmDt(String sFmDt) {
        this.sFmDt = sFmDt;
    }

    public void setWoInvRto(String woInvRto) {
        this.woInvRto = woInvRto;
    }

    public void setWkVrfyYn(String wkVrfyYn) {
        this.wkVrfyYn = wkVrfyYn;
    }

    public void setInvStsNm(String invStsNm) {
        this.invStsNm = invStsNm;
    }

    public void setWoAmt(String woAmt) {
        this.woAmt = woAmt;
    }

    public void setInvOfcCd(String invOfcCd) {
        this.invOfcCd = invOfcCd;
    }

    public void setInvRgstNo(String invRgstNo) {
        this.invRgstNo = invRgstNo;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public void setGenPayTermCd(String genPayTermCd) {
        this.genPayTermCd = genPayTermCd;
    }

    public void setInvChgAmt(String invChgAmt) {
        this.invChgAmt = invChgAmt;
    }

    public void setInvCfmDt(String invCfmDt) {
        this.invCfmDt = invCfmDt;
    }

    public void setLoclCreDt(String loclCreDt) {
        this.loclCreDt = loclCreDt;
    }

    public void setExpnAudStsCd(String expnAudStsCd) {
        this.expnAudStsCd = expnAudStsCd;
    }

    public void setInvCreUserNm(String invCreUserNm) {
        this.invCreUserNm = invCreUserNm;
    }

    public void setMnrEstErrFlg(String mnrEstErrFlg) {
        this.mnrEstErrFlg = mnrEstErrFlg;
    }

    public void setEqKndCd(String eqKndCd) {
        this.eqKndCd = eqKndCd;
    }

    public void setBzcAmt(String bzcAmt) {
        this.bzcAmt = bzcAmt;
    }

    public void setInvCurrCd(String invCurrCd) {
        this.invCurrCd = invCurrCd;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public void setWoVrfyDesc(String woVrfyDesc) {
        this.woVrfyDesc = woVrfyDesc;
    }

    public void setInvRmk(String invRmk) {
        this.invRmk = invRmk;
    }

    public void setTtlInvAmt(String ttlInvAmt) {
        this.ttlInvAmt = ttlInvAmt;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public void setExpnAudRsltUsrNm(String expnAudRsltUsrNm) {
        this.expnAudRsltUsrNm = expnAudRsltUsrNm;
    }

    public void setCheckedUserId(String checkedUserId) {
        this.checkedUserId = checkedUserId;
    }

    public void setIssOfcCd(String issOfcCd) {
        this.issOfcCd = issOfcCd;
    }

    public void setMnrInpTpCd(String mnrInpTpCd) {
        this.mnrInpTpCd = mnrInpTpCd;
    }

    public void setBatProgStsCd(String batProgStsCd) {
        this.batProgStsCd = batProgStsCd;
    }

    public void setBatProgStsNm(String batProgStsNm) {
        this.batProgStsNm = batProgStsNm;
    }

    public void setCheckedDt(String checkedDt) {
        this.checkedDt = checkedDt;
    }

    public void setRhqInvOfcCd(String rhqInvOfcCd) {
        this.rhqInvOfcCd = rhqInvOfcCd;
    }

    public void setMltWoCurrFlg(String mltWoCurrFlg) {
        this.mltWoCurrFlg = mltWoCurrFlg;
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

    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    public void fromRequest(HttpServletRequest request, String prefix) {
        setEstVrfyDesc(JSPUtil.getParameter(request, prefix + "est_vrfy_desc", ""));
        setWoCurrCd(JSPUtil.getParameter(request, prefix + "wo_curr_cd", ""));
        setSSaveTpCd(JSPUtil.getParameter(request, prefix + "s_save_tp_cd", ""));
        setRsltChk(JSPUtil.getParameter(request, prefix + "rslt_chk", ""));
        setInvDiffAmt(JSPUtil.getParameter(request, prefix + "inv_diff_amt", ""));
        setExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", ""));
        setApPayDt(JSPUtil.getParameter(request, prefix + "ap_pay_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
        setAutoExpnAudStsCd(JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", ""));
        setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
        setInvStsCd(JSPUtil.getParameter(request, prefix + "inv_sts_cd", ""));
        setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
        setChekedDt(JSPUtil.getParameter(request, prefix + "cheked_dt", ""));
        setMnrWrkAmt(JSPUtil.getParameter(request, prefix + "mnr_wrk_amt", ""));
        setWoVrfyFlg(JSPUtil.getParameter(request, prefix + "wo_vrfy_flg", ""));
        setSprPrtUcAmt(JSPUtil.getParameter(request, prefix + "spr_prt_uc_amt", ""));
        setEstmVrfyFlg(JSPUtil.getParameter(request, prefix + "estm_vrfy_flg", ""));
        setInvDiffPct(JSPUtil.getParameter(request, prefix + "inv_diff_pct", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setMnrWoErrFlg(JSPUtil.getParameter(request, prefix + "mnr_wo_err_flg", ""));
        setAutoAudit(JSPUtil.getParameter(request, prefix + "auto_audit", ""));
        setCurrCngFlg(JSPUtil.getParameter(request, prefix + "curr_cng_flg", ""));
        setEqKndCdNm(JSPUtil.getParameter(request, prefix + "eq_knd_cd_nm", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
        setSelectFlgTemp(JSPUtil.getParameter(request, prefix + "select_flg_temp", ""));
        setEstmVrfyDesc(JSPUtil.getParameter(request, prefix + "estm_vrfy_desc", ""));
        setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
        setToDatetime(JSPUtil.getParameter(request, prefix + "to_datetime", ""));
        setWkVrfyDesc(JSPUtil.getParameter(request, prefix + "wk_vrfy_desc", ""));
        setSelectFlg(JSPUtil.getParameter(request, prefix + "select_flg", ""));
        setBatchTpCd(JSPUtil.getParameter(request, prefix + "batch_tp_cd", ""));
        setChgWoAmt(JSPUtil.getParameter(request, prefix + "chg_wo_amt", ""));
        setInvDiffRto(JSPUtil.getParameter(request, prefix + "inv_diff_rto", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setEstVrfyYn(JSPUtil.getParameter(request, prefix + "est_vrfy_yn", ""));
        setCheckedUserNm(JSPUtil.getParameter(request, prefix + "checked_user_nm", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setAuditDt(JSPUtil.getParameter(request, prefix + "audit_dt", ""));
        setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
        setMnrAgmtAmt(JSPUtil.getParameter(request, prefix + "mnr_agmt_amt", ""));
        setExpnAudRsltUsrId(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_id", ""));
        setExpnAudRsltRmk(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", ""));
        setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setExpnMaxPrmtRto(JSPUtil.getParameter(request, prefix + "expn_max_prmt_rto", ""));
        setEacYn(JSPUtil.getParameter(request, prefix + "eac_yn", ""));
        setInvCreUserId(JSPUtil.getParameter(request, prefix + "inv_cre_user_id", ""));
        setReflExYn(JSPUtil.getParameter(request, prefix + "refl_ex_yn", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
        setWoInvRto(JSPUtil.getParameter(request, prefix + "wo_inv_rto", ""));
        setWkVrfyYn(JSPUtil.getParameter(request, prefix + "wk_vrfy_yn", ""));
        setInvStsNm(JSPUtil.getParameter(request, prefix + "inv_sts_nm", ""));
        setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
        setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
        setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setGenPayTermCd(JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", ""));
        setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
        setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
        setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
        setExpnAudStsCd(JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", ""));
        setInvCreUserNm(JSPUtil.getParameter(request, prefix + "inv_cre_user_nm", ""));
        setMnrEstErrFlg(JSPUtil.getParameter(request, prefix + "mnr_est_err_flg", ""));
        setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
        setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setAuditResult(JSPUtil.getParameter(request, prefix + "audit_result", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setWoVrfyDesc(JSPUtil.getParameter(request, prefix + "wo_vrfy_desc", ""));
        setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
        setTtlInvAmt(JSPUtil.getParameter(request, prefix + "ttl_inv_amt", ""));
        setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
        setExpnAudRsltUsrNm(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_nm", ""));
        setCheckedUserId(JSPUtil.getParameter(request, prefix + "checked_user_id", ""));
        setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
        setMnrInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", ""));
        setBatProgStsCd(JSPUtil.getParameter(request, prefix + "bat_prog_sts_cd", ""));
        setBatProgStsNm(JSPUtil.getParameter(request, prefix + "bat_prog_sts_nm", ""));
        setCheckedDt(JSPUtil.getParameter(request, prefix + "checked_dt", ""));
        setRhqInvOfcCd(JSPUtil.getParameter(request, prefix + "rhq_inv_ofc_cd", ""));
        setMltWoCurrFlg(JSPUtil.getParameter(request, prefix + "mlt_wo_curr_flg", ""));
        setInvAudCurrCd(JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", ""));
        setInvAudDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", ""));
        setInvAudUsdDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", ""));
    }

    public MnrChargeListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    public MnrChargeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MnrChargeListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] estVrfyDesc = (JSPUtil.getParameter(request, prefix + "est_vrfy_desc", length));
            String[] woCurrCd = (JSPUtil.getParameter(request, prefix + "wo_curr_cd", length));
            String[] sSaveTpCd = (JSPUtil.getParameter(request, prefix + "s_save_tp_cd", length));
            String[] rsltChk = (JSPUtil.getParameter(request, prefix + "rslt_chk", length));
            String[] invDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_diff_amt", length));
            String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", length));
            String[] apPayDt = (JSPUtil.getParameter(request, prefix + "ap_pay_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", length));
            String[] autoExpnAudStsCd = (JSPUtil.getParameter(request, prefix + "auto_expn_aud_sts_cd", length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
            String[] invStsCd = (JSPUtil.getParameter(request, prefix + "inv_sts_cd", length));
            String[] payDueDt = (JSPUtil.getParameter(request, prefix + "pay_due_dt", length));
            String[] chekedDt = (JSPUtil.getParameter(request, prefix + "cheked_dt", length));
            String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix + "mnr_wrk_amt", length));
            String[] woVrfyFlg = (JSPUtil.getParameter(request, prefix + "wo_vrfy_flg", length));
            String[] sprPrtUcAmt = (JSPUtil.getParameter(request, prefix + "spr_prt_uc_amt", length));
            String[] estmVrfyFlg = (JSPUtil.getParameter(request, prefix + "estm_vrfy_flg", length));
            String[] invDiffPct = (JSPUtil.getParameter(request, prefix + "inv_diff_pct", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] mnrWoErrFlg = (JSPUtil.getParameter(request, prefix + "mnr_wo_err_flg", length));
            String[] autoAudit = (JSPUtil.getParameter(request, prefix + "auto_audit", length));
            String[] currCngFlg = (JSPUtil.getParameter(request, prefix + "curr_cng_flg", length));
            String[] eqKndCdNm = (JSPUtil.getParameter(request, prefix + "eq_knd_cd_nm", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] rhqCd = (JSPUtil.getParameter(request, prefix + "rhq_cd", length));
            String[] selectFlgTemp = (JSPUtil.getParameter(request, prefix + "select_flg_temp", length));
            String[] estmVrfyDesc = (JSPUtil.getParameter(request, prefix + "estm_vrfy_desc", length));
            String[] cfmDt = (JSPUtil.getParameter(request, prefix + "cfm_dt", length));
            String[] toDatetime = (JSPUtil.getParameter(request, prefix + "to_datetime", length));
            String[] wkVrfyDesc = (JSPUtil.getParameter(request, prefix + "wk_vrfy_desc", length));
            String[] selectFlg = (JSPUtil.getParameter(request, prefix + "select_flg", length));
            String[] batchTpCd = (JSPUtil.getParameter(request, prefix + "batch_tp_cd", length));
            String[] chgWoAmt = (JSPUtil.getParameter(request, prefix + "chg_wo_amt", length));
            String[] invDiffRto = (JSPUtil.getParameter(request, prefix + "inv_diff_rto", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] estVrfyYn = (JSPUtil.getParameter(request, prefix + "est_vrfy_yn", length));
            String[] checkedUserNm = (JSPUtil.getParameter(request, prefix + "checked_user_nm", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] auditDt = (JSPUtil.getParameter(request, prefix + "audit_dt", length));
            String[] issDt = (JSPUtil.getParameter(request, prefix + "iss_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sToDt = (JSPUtil.getParameter(request, prefix + "s_to_dt", length));
            String[] mnrAgmtAmt = (JSPUtil.getParameter(request, prefix + "mnr_agmt_amt", length));
            String[] expnAudRsltUsrId = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_id", length));
            String[] expnAudRsltRmk = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", length));
            String[] costAmt = (JSPUtil.getParameter(request, prefix + "cost_amt", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] expnMaxPrmtRto = (JSPUtil.getParameter(request, prefix + "expn_max_prmt_rto", length));
            String[] eacYn = (JSPUtil.getParameter(request, prefix + "eac_yn", length));
            String[] invCreUserId = (JSPUtil.getParameter(request, prefix + "inv_cre_user_id", length));
            String[] reflExYn = (JSPUtil.getParameter(request, prefix + "refl_ex_yn", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] sFmDt = (JSPUtil.getParameter(request, prefix + "s_fm_dt", length));
            String[] woInvRto = (JSPUtil.getParameter(request, prefix + "wo_inv_rto", length));
            String[] wkVrfyYn = (JSPUtil.getParameter(request, prefix + "wk_vrfy_yn", length));
            String[] invStsNm = (JSPUtil.getParameter(request, prefix + "inv_sts_nm", length));
            String[] woAmt = (JSPUtil.getParameter(request, prefix + "wo_amt", length));
            String[] invOfcCd = (JSPUtil.getParameter(request, prefix + "inv_ofc_cd", length));
            String[] invRgstNo = (JSPUtil.getParameter(request, prefix + "inv_rgst_no", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] genPayTermCd = (JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", length));
            String[] invChgAmt = (JSPUtil.getParameter(request, prefix + "inv_chg_amt", length));
            String[] invCfmDt = (JSPUtil.getParameter(request, prefix + "inv_cfm_dt", length));
            String[] loclCreDt = (JSPUtil.getParameter(request, prefix + "locl_cre_dt", length));
            String[] expnAudStsCd = (JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", length));
            String[] invCreUserNm = (JSPUtil.getParameter(request, prefix + "inv_cre_user_nm", length));
            String[] mnrEstErrFlg = (JSPUtil.getParameter(request, prefix + "mnr_est_err_flg", length));
            String[] eqKndCd = (JSPUtil.getParameter(request, prefix + "eq_knd_cd", length));
            String[] bzcAmt = (JSPUtil.getParameter(request, prefix + "bzc_amt", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] auditResult = (JSPUtil.getParameter(request, prefix + "audit_result", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] woVrfyDesc = (JSPUtil.getParameter(request, prefix + "wo_vrfy_desc", length));
            String[] invRmk = (JSPUtil.getParameter(request, prefix + "inv_rmk", length));
            String[] ttlInvAmt = (JSPUtil.getParameter(request, prefix + "ttl_inv_amt", length));
            String[] sel = (JSPUtil.getParameter(request, prefix + "sel", length));
            String[] expnAudRsltUsrNm = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_nm", length));
            String[] checkedUserId = (JSPUtil.getParameter(request, prefix + "checked_user_id", length));
            String[] issOfcCd = (JSPUtil.getParameter(request, prefix + "iss_ofc_cd", length));
            String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", length));
            String[] batProgStsCd = (JSPUtil.getParameter(request, prefix + "bat_prog_sts_cd", length));
            String[] batProgStsNm = (JSPUtil.getParameter(request, prefix + "bat_prog_sts_nm", length));
            String[] checkedDt = (JSPUtil.getParameter(request, prefix + "checked_dt", length));
            String[] rhqInvOfcCd = (JSPUtil.getParameter(request, prefix + "rhq_inv_ofc_cd", length));
            String[] mltWoCurrFlg = (JSPUtil.getParameter(request, prefix + "mlt_wo_curr_flg", length));
            String[] invAudCurrCd = (JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", length));
	    	String[] invAudDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", length));
	    	String[] invAudUsdDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MnrChargeListVO();
                if (estVrfyDesc[i] != null)
                    model.setEstVrfyDesc(estVrfyDesc[i]);
                if (woCurrCd[i] != null)
                    model.setWoCurrCd(woCurrCd[i]);
                if (sSaveTpCd[i] != null)
                    model.setSSaveTpCd(sSaveTpCd[i]);
                if (rsltChk[i] != null)
                    model.setRsltChk(rsltChk[i]);
                if (invDiffAmt[i] != null)
                    model.setInvDiffAmt(invDiffAmt[i]);
                if (expnAudRsltCd[i] != null)
                    model.setExpnAudRsltCd(expnAudRsltCd[i]);
                if (apPayDt[i] != null)
                    model.setApPayDt(apPayDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (atchFileLnkId[i] != null)
                    model.setAtchFileLnkId(atchFileLnkId[i]);
                if (autoExpnAudStsCd[i] != null)
                    model.setAutoExpnAudStsCd(autoExpnAudStsCd[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (invStsCd[i] != null)
                    model.setInvStsCd(invStsCd[i]);
                if (payDueDt[i] != null)
                    model.setPayDueDt(payDueDt[i]);
                if (chekedDt[i] != null)
                    model.setChekedDt(chekedDt[i]);
                if (mnrWrkAmt[i] != null)
                    model.setMnrWrkAmt(mnrWrkAmt[i]);
                if (woVrfyFlg[i] != null)
                    model.setWoVrfyFlg(woVrfyFlg[i]);
                if (sprPrtUcAmt[i] != null)
                    model.setSprPrtUcAmt(sprPrtUcAmt[i]);
                if (estmVrfyFlg[i] != null)
                    model.setEstmVrfyFlg(estmVrfyFlg[i]);
                if (invDiffPct[i] != null)
                    model.setInvDiffPct(invDiffPct[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (mnrWoErrFlg[i] != null)
                    model.setMnrWoErrFlg(mnrWoErrFlg[i]);
                if (autoAudit[i] != null)
                    model.setAutoAudit(autoAudit[i]);
                if (currCngFlg[i] != null)
                    model.setCurrCngFlg(currCngFlg[i]);
                if (eqKndCdNm[i] != null)
                    model.setEqKndCdNm(eqKndCdNm[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (rhqCd[i] != null)
                    model.setRhqCd(rhqCd[i]);
                if (selectFlgTemp[i] != null)
                    model.setSelectFlgTemp(selectFlgTemp[i]);
                if (estmVrfyDesc[i] != null)
                    model.setEstmVrfyDesc(estmVrfyDesc[i]);
                if (cfmDt[i] != null)
                    model.setCfmDt(cfmDt[i]);
                if (toDatetime[i] != null)
                    model.setToDatetime(toDatetime[i]);
                if (wkVrfyDesc[i] != null)
                    model.setWkVrfyDesc(wkVrfyDesc[i]);
                if (selectFlg[i] != null)
                    model.setSelectFlg(selectFlg[i]);
                if (batchTpCd[i] != null)
                    model.setBatchTpCd(batchTpCd[i]);
                if (chgWoAmt[i] != null)
                    model.setChgWoAmt(chgWoAmt[i]);
                if (invDiffRto[i] != null)
                    model.setInvDiffRto(invDiffRto[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (estVrfyYn[i] != null)
                    model.setEstVrfyYn(estVrfyYn[i]);
                if (checkedUserNm[i] != null)
                    model.setCheckedUserNm(checkedUserNm[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (auditDt[i] != null)
                    model.setAuditDt(auditDt[i]);
                if (issDt[i] != null)
                    model.setIssDt(issDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sToDt[i] != null)
                    model.setSToDt(sToDt[i]);
                if (mnrAgmtAmt[i] != null)
                    model.setMnrAgmtAmt(mnrAgmtAmt[i]);
                if (expnAudRsltUsrId[i] != null)
                    model.setExpnAudRsltUsrId(expnAudRsltUsrId[i]);
                if (expnAudRsltRmk[i] != null)
                    model.setExpnAudRsltRmk(expnAudRsltRmk[i]);
                if (costAmt[i] != null)
                    model.setCostAmt(costAmt[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (expnMaxPrmtRto[i] != null)
                    model.setExpnMaxPrmtRto(expnMaxPrmtRto[i]);
                if (eacYn[i] != null)
                    model.setEacYn(eacYn[i]);
                if (invCreUserId[i] != null)
                    model.setInvCreUserId(invCreUserId[i]);
                if (reflExYn[i] != null)
                    model.setReflExYn(reflExYn[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (sFmDt[i] != null)
                    model.setSFmDt(sFmDt[i]);
                if (woInvRto[i] != null)
                    model.setWoInvRto(woInvRto[i]);
                if (wkVrfyYn[i] != null)
                    model.setWkVrfyYn(wkVrfyYn[i]);
                if (invStsNm[i] != null)
                    model.setInvStsNm(invStsNm[i]);
                if (woAmt[i] != null)
                    model.setWoAmt(woAmt[i]);
                if (invOfcCd[i] != null)
                    model.setInvOfcCd(invOfcCd[i]);
                if (invRgstNo[i] != null)
                    model.setInvRgstNo(invRgstNo[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (genPayTermCd[i] != null)
                    model.setGenPayTermCd(genPayTermCd[i]);
                if (invChgAmt[i] != null)
                    model.setInvChgAmt(invChgAmt[i]);
                if (invCfmDt[i] != null)
                    model.setInvCfmDt(invCfmDt[i]);
                if (loclCreDt[i] != null)
                    model.setLoclCreDt(loclCreDt[i]);
                if (expnAudStsCd[i] != null)
                    model.setExpnAudStsCd(expnAudStsCd[i]);
                if (invCreUserNm[i] != null)
                    model.setInvCreUserNm(invCreUserNm[i]);
                if (mnrEstErrFlg[i] != null)
                    model.setMnrEstErrFlg(mnrEstErrFlg[i]);
                if (eqKndCd[i] != null)
                    model.setEqKndCd(eqKndCd[i]);
                if (bzcAmt[i] != null)
                    model.setBzcAmt(bzcAmt[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (auditResult[i] != null)
                    model.setAuditResult(auditResult[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (woVrfyDesc[i] != null)
                    model.setWoVrfyDesc(woVrfyDesc[i]);
                if (invRmk[i] != null)
                    model.setInvRmk(invRmk[i]);
                if (ttlInvAmt[i] != null)
                    model.setTtlInvAmt(ttlInvAmt[i]);
                if (sel[i] != null)
                    model.setSel(sel[i]);
                if (expnAudRsltUsrNm[i] != null)
                    model.setExpnAudRsltUsrNm(expnAudRsltUsrNm[i]);
                if (checkedUserId[i] != null)
                    model.setCheckedUserId(checkedUserId[i]);
                if (issOfcCd[i] != null)
                    model.setIssOfcCd(issOfcCd[i]);
                if (mnrInpTpCd[i] != null)
                    model.setMnrInpTpCd(mnrInpTpCd[i]);
                if (batProgStsCd[i] != null)
                    model.setBatProgStsCd(batProgStsCd[i]);
                if (batProgStsNm[i] != null)
                    model.setBatProgStsNm(batProgStsNm[i]);
                if (checkedDt[i] != null)
                    model.setCheckedDt(checkedDt[i]);
                if (rhqInvOfcCd[i] != null)
                    model.setRhqInvOfcCd(rhqInvOfcCd[i]);
                if (mltWoCurrFlg[i] != null)
                    model.setMltWoCurrFlg(mltWoCurrFlg[i]);
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
        return getMnrChargeListVOs();
    }

    public MnrChargeListVO[] getMnrChargeListVOs() {
        MnrChargeListVO[] vos = (MnrChargeListVO[]) models.toArray(new MnrChargeListVO[models.size()]);
        return vos;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public void unDataFormat() {
        this.estVrfyDesc = this.estVrfyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woCurrCd = this.woCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSaveTpCd = this.sSaveTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsltChk = this.rsltChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffAmt = this.invDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltCd = this.expnAudRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apPayDt = this.apPayDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atchFileLnkId = this.atchFileLnkId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoExpnAudStsCd = this.autoExpnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invStsCd = this.invStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDueDt = this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chekedDt = this.chekedDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrWrkAmt = this.mnrWrkAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woVrfyFlg = this.woVrfyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sprPrtUcAmt = this.sprPrtUcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmVrfyFlg = this.estmVrfyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffPct = this.invDiffPct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrWoErrFlg = this.mnrWoErrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAudit = this.autoAudit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCngFlg = this.currCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqKndCdNm = this.eqKndCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqCd = this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selectFlgTemp = this.selectFlgTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmVrfyDesc = this.estmVrfyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfmDt = this.cfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDatetime = this.toDatetime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wkVrfyDesc = this.wkVrfyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selectFlg = this.selectFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batchTpCd = this.batchTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgWoAmt = this.chgWoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffRto = this.invDiffRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estVrfyYn = this.estVrfyYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.checkedUserNm = this.checkedUserNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditDt = this.auditDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issDt = this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sToDt = this.sToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrAgmtAmt = this.mnrAgmtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltUsrId = this.expnAudRsltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltRmk = this.expnAudRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costAmt = this.costAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnMaxPrmtRto = this.expnMaxPrmtRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacYn = this.eacYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCreUserId = this.invCreUserId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reflExYn = this.reflExYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sFmDt = this.sFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woInvRto = this.woInvRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wkVrfyYn = this.wkVrfyYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invStsNm = this.invStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woAmt = this.woAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invOfcCd = this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRgstNo = this.invRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.genPayTermCd = this.genPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invChgAmt = this.invChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCfmDt = this.invCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCreDt = this.loclCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudStsCd = this.expnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCreUserNm = this.invCreUserNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrEstErrFlg = this.mnrEstErrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bzcAmt = this.bzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.auditResult = this.auditResult.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woVrfyDesc = this.woVrfyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk = this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlInvAmt = this.ttlInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sel = this.sel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltUsrNm = this.expnAudRsltUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.checkedUserId = this.checkedUserId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issOfcCd = this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrInpTpCd = this.mnrInpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batProgStsCd = this.batProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batProgStsNm = this.batProgStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.checkedDt = this.checkedDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqInvOfcCd = this.rhqInvOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mltWoCurrFlg = this.mltWoCurrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudCurrCd = this.invAudCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudDiffAmt = this.invAudDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudUsdDiffAmt = this.invAudUsdDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
