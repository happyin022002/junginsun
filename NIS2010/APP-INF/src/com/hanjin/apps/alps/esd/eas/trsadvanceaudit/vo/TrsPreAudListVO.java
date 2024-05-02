/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsPreAudListVO.java
*@FileTitle : TrsPreAudListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.03.09 최종혁 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class TrsPreAudListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<TrsPreAudListVO> models = new ArrayList<TrsPreAudListVO>();

    /* Column Info */
    private String payDt = null;

    /* Column Info */
    private String avgOvrDiffFlg = null;

    /* Column Info */
    private String sSaveTpCd = null;

    /* Column Info */
    private String noOptmRoutFlg = null;

    /* Column Info */
    private String invVndrSeq = null;

    /* Column Info */
    private String invDiffAmt = null;

    /* Column Info */
    private String payTermCd = null;

    /* Column Info */
    private String invIssDt = null;

    /* Column Info */
    private String expnAudRsltCd = null;

    /* Column Info */
    private String atchFileLnkId = null;

    /* Column Info */
    private String exceedAvgDiffAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String audRlstFlg = null;

    /* Column Info */
    private String payDueDt = null;

    /* Column Info */
    private String sTrspCostSoTpCd = null;

    /* Column Info */
    private String trspSoTpCd = null;

    /* Column Info */
    private String invDiffPct = null;

    /* Column Info */
    private String sCsrStsCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String currCngFlg = null;

    /* Column Info */
    private String disInvVndrSeq = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String toDatetime = null;

    /* Column Info */
    private String sOfcCd = null;

    /* Column Info */
    private String invIssUsrNm = null;

    /* Column Info */
    private String audCfmUsrNm = null;

    /* Column Info */
    private String batchTpCd = null;

    /* Column Info */
    private String rhqOfcCd = null;

    /* Column Info */
    private String sInvNo = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String chk = null;

    /* Column Info */
    private String sInvVndrSeq = null;

    /* Column Info */
    private String invIssUsrId = null;

    /* Column Info */
    private String sTrspCrrModCd = null;

    /* Column Info */
    private String invDiffFlg = null;

    /* Column Info */
    private String disInvVndrNm = null;

    /* Column Info */
    private String exceedAvgFlg = null;

    /* Column Info */
    private String autoAudCfmUsrId = null;

    /* Column Info */
    private String invAudStsCd = null;

    /* Column Info */
    private String sCsrNo = null;

    /* Column Info */
    private String sRhqOfcCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String autoAudStsCd = null;

    /* Column Info */
    private String sTrspSoTpCd = null;

    /* Column Info */
    private String hjlInvVndrSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sToDt = null;

    /* Column Info */
    private String expnAudRsltUsrId = null;

    /* Column Info */
    private String sAudItmCd = null;

    /* Column Info */
    private String expnAudRsltRmk = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String eacIfFlg = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String sFmDt = null;

    /* Column Info */
    private String invVndrNm = null;

    /* Column Info */
    private String sAutoAudStsCd = null;

    /* Column Info */
    private String woAmt = null;

    /* Column Info */
    private String invOfcCd = null;

    /* Column Info */
    private String sExpnAudStsCd = null;

    /* Column Info */
    private String hjlInvNo = null;

    /* Column Info */
    private String sTrspCostDtlModCd = null;

    /* Column Info */
    private String invCfmDt = null;

    /* Column Info */
    private String expnAudStsCd = null;

    /* Column Info */
    private String loclCreDt = null;

    /* Column Info */
    private String batProgStsCd = null;

    /* Column Info */
    private String invDiffAmtFlg = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String autoAudCfmDt = null;

    /* Column Info */
    private String noAgmtFlg = null;

    /* Column Info */
    private String selAudCd = null;

    /* Column Info */
    private String expnAudRsltUsrNm = null;

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

    public TrsPreAudListVO() {
    }

    public TrsPreAudListVO(String ibflag, String pagerows, String chk, String selAudCd, String autoAudStsCd, String expnAudStsCd, String rhqOfcCd, String invOfcCd, String trspSoTpCd, String invVndrSeq, String invVndrNm, String invNo, String invIssDt, String invAudStsCd, String csrNo, String currCd, String woAmt, String invAmt, String currCngFlg, String invDiffAmt, String invDiffAmtFlg, String noAgmtFlg, String noOptmRoutFlg, String exceedAvgDiffAmt, String exceedAvgFlg, String invIssUsrNm, String audCfmUsrNm, String payTermCd, String payDueDt, String payDt, String eacIfFlg, String sToDt, String sFmDt, String sOfcCd, String sRhqOfcCd, String sTrspCostSoTpCd, String sTrspCrrModCd, String sTrspCostDtlModCd, String sInvVndrSeq, String sCsrNo, String sInvNo, String sAudItmCd, String sAutoAudStsCd, String sExpnAudStsCd, String sCsrStsCd, String sTrspSoTpCd, String creUsrId, String updUsrId, String loclCreDt, String creOfcCd, String expnAudRsltRmk, String expnAudRsltUsrId, String expnAudRsltUsrNm, String sSaveTpCd, String invDiffPct, String disInvVndrSeq, String disInvVndrNm, String hjlInvNo, String invCfmDt, String atchFileLnkId, String expnAudRsltCd, String batchTpCd, String toDatetime, String audRlstFlg, String invIssUsrId, String hjlInvVndrSeq, String invDiffFlg, String avgOvrDiffFlg, String autoAudCfmDt, String autoAudCfmUsrId, String batProgStsCd, String audCurrCd, String audDiffAmt, String audUsdDiffAmt, String invDiffAmtAud, String invAudCurrCd, String invAudDiffAmt, String invAudUsdDiffAmt) {
        this.payDt = payDt;
        this.avgOvrDiffFlg = avgOvrDiffFlg;
        this.sSaveTpCd = sSaveTpCd;
        this.noOptmRoutFlg = noOptmRoutFlg;
        this.invVndrSeq = invVndrSeq;
        this.invDiffAmt = invDiffAmt;
        this.payTermCd = payTermCd;
        this.invIssDt = invIssDt;
        this.expnAudRsltCd = expnAudRsltCd;
        this.atchFileLnkId = atchFileLnkId;
        this.exceedAvgDiffAmt = exceedAvgDiffAmt;
        this.pagerows = pagerows;
        this.audRlstFlg = audRlstFlg;
        this.payDueDt = payDueDt;
        this.sTrspCostSoTpCd = sTrspCostSoTpCd;
        this.trspSoTpCd = trspSoTpCd;
        this.invDiffPct = invDiffPct;
        this.sCsrStsCd = sCsrStsCd;
        this.updUsrId = updUsrId;
        this.currCngFlg = currCngFlg;
        this.disInvVndrSeq = disInvVndrSeq;
        this.csrNo = csrNo;
        this.toDatetime = toDatetime;
        this.sOfcCd = sOfcCd;
        this.invIssUsrNm = invIssUsrNm;
        this.audCfmUsrNm = audCfmUsrNm;
        this.batchTpCd = batchTpCd;
        this.rhqOfcCd = rhqOfcCd;
        this.sInvNo = sInvNo;
        this.creUsrId = creUsrId;
        this.chk = chk;
        this.sInvVndrSeq = sInvVndrSeq;
        this.invIssUsrId = invIssUsrId;
        this.sTrspCrrModCd = sTrspCrrModCd;
        this.invDiffFlg = invDiffFlg;
        this.disInvVndrNm = disInvVndrNm;
        this.exceedAvgFlg = exceedAvgFlg;
        this.autoAudCfmUsrId = autoAudCfmUsrId;
        this.invAudStsCd = invAudStsCd;
        this.sCsrNo = sCsrNo;
        this.sRhqOfcCd = sRhqOfcCd;
        this.currCd = currCd;
        this.autoAudStsCd = autoAudStsCd;
        this.sTrspSoTpCd = sTrspSoTpCd;
        this.hjlInvVndrSeq = hjlInvVndrSeq;
        this.ibflag = ibflag;
        this.sToDt = sToDt;
        this.expnAudRsltUsrId = expnAudRsltUsrId;
        this.sAudItmCd = sAudItmCd;
        this.expnAudRsltRmk = expnAudRsltRmk;
        this.creOfcCd = creOfcCd;
        this.eacIfFlg = eacIfFlg;
        this.invAmt = invAmt;
        this.sFmDt = sFmDt;
        this.invVndrNm = invVndrNm;
        this.sAutoAudStsCd = sAutoAudStsCd;
        this.woAmt = woAmt;
        this.invOfcCd = invOfcCd;
        this.sExpnAudStsCd = sExpnAudStsCd;
        this.hjlInvNo = hjlInvNo;
        this.sTrspCostDtlModCd = sTrspCostDtlModCd;
        this.invCfmDt = invCfmDt;
        this.expnAudStsCd = expnAudStsCd;
        this.loclCreDt = loclCreDt;
        this.batProgStsCd = batProgStsCd;
        this.invDiffAmtFlg = invDiffAmtFlg;
        this.invNo = invNo;
        this.autoAudCfmDt = autoAudCfmDt;
        this.noAgmtFlg = noAgmtFlg;
        this.selAudCd = selAudCd;
        this.expnAudRsltUsrNm = expnAudRsltUsrNm;
        this.invAudCurrCd = invAudCurrCd;
        this.invAudDiffAmt = invAudDiffAmt;
        this.invAudUsdDiffAmt = invAudUsdDiffAmt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pay_dt", getPayDt());
        this.hashColumns.put("avg_ovr_diff_flg", getAvgOvrDiffFlg());
        this.hashColumns.put("s_save_tp_cd", getSSaveTpCd());
        this.hashColumns.put("no_optm_rout_flg", getNoOptmRoutFlg());
        this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
        this.hashColumns.put("inv_diff_amt", getInvDiffAmt());
        this.hashColumns.put("pay_term_cd", getPayTermCd());
        this.hashColumns.put("inv_iss_dt", getInvIssDt());
        this.hashColumns.put("expn_aud_rslt_cd", getExpnAudRsltCd());
        this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
        this.hashColumns.put("exceed_avg_diff_amt", getExceedAvgDiffAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("aud_rlst_flg", getAudRlstFlg());
        this.hashColumns.put("pay_due_dt", getPayDueDt());
        this.hashColumns.put("s_trsp_cost_so_tp_cd", getSTrspCostSoTpCd());
        this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
        this.hashColumns.put("inv_diff_pct", getInvDiffPct());
        this.hashColumns.put("s_csr_sts_cd", getSCsrStsCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("curr_cng_flg", getCurrCngFlg());
        this.hashColumns.put("dis_inv_vndr_seq", getDisInvVndrSeq());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("to_datetime", getToDatetime());
        this.hashColumns.put("s_ofc_cd", getSOfcCd());
        this.hashColumns.put("inv_iss_usr_nm", getInvIssUsrNm());
        this.hashColumns.put("aud_cfm_usr_nm", getAudCfmUsrNm());
        this.hashColumns.put("batch_tp_cd", getBatchTpCd());
        this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
        this.hashColumns.put("s_inv_no", getSInvNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("chk", getChk());
        this.hashColumns.put("s_inv_vndr_seq", getSInvVndrSeq());
        this.hashColumns.put("inv_iss_usr_id", getInvIssUsrId());
        this.hashColumns.put("s_trsp_crr_mod_cd", getSTrspCrrModCd());
        this.hashColumns.put("inv_diff_flg", getInvDiffFlg());
        this.hashColumns.put("dis_inv_vndr_nm", getDisInvVndrNm());
        this.hashColumns.put("exceed_avg_flg", getExceedAvgFlg());
        this.hashColumns.put("auto_aud_cfm_usr_id", getAutoAudCfmUsrId());
        this.hashColumns.put("inv_aud_sts_cd", getInvAudStsCd());
        this.hashColumns.put("s_csr_no", getSCsrNo());
        this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("auto_aud_sts_cd", getAutoAudStsCd());
        this.hashColumns.put("s_trsp_so_tp_cd", getSTrspSoTpCd());
        this.hashColumns.put("hjl_inv_vndr_seq", getHjlInvVndrSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("s_to_dt", getSToDt());
        this.hashColumns.put("expn_aud_rslt_usr_id", getExpnAudRsltUsrId());
        this.hashColumns.put("s_aud_itm_cd", getSAudItmCd());
        this.hashColumns.put("expn_aud_rslt_rmk", getExpnAudRsltRmk());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("eac_if_flg", getEacIfFlg());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("s_fm_dt", getSFmDt());
        this.hashColumns.put("inv_vndr_nm", getInvVndrNm());
        this.hashColumns.put("s_auto_aud_sts_cd", getSAutoAudStsCd());
        this.hashColumns.put("wo_amt", getWoAmt());
        this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
        this.hashColumns.put("s_expn_aud_sts_cd", getSExpnAudStsCd());
        this.hashColumns.put("hjl_inv_no", getHjlInvNo());
        this.hashColumns.put("s_trsp_cost_dtl_mod_cd", getSTrspCostDtlModCd());
        this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
        this.hashColumns.put("expn_aud_sts_cd", getExpnAudStsCd());
        this.hashColumns.put("locl_cre_dt", getLoclCreDt());
        this.hashColumns.put("bat_prog_sts_cd", getBatProgStsCd());
        this.hashColumns.put("inv_diff_amt_flg", getInvDiffAmtFlg());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("auto_aud_cfm_dt", getAutoAudCfmDt());
        this.hashColumns.put("no_agmt_flg", getNoAgmtFlg());
        this.hashColumns.put("sel_aud_cd", getSelAudCd());
        this.hashColumns.put("expn_aud_rslt_usr_nm", getExpnAudRsltUsrNm());
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
        this.hashFields.put("pay_dt", "payDt");
        this.hashFields.put("avg_ovr_diff_flg", "avgOvrDiffFlg");
        this.hashFields.put("s_save_tp_cd", "sSaveTpCd");
        this.hashFields.put("no_optm_rout_flg", "noOptmRoutFlg");
        this.hashFields.put("inv_vndr_seq", "invVndrSeq");
        this.hashFields.put("inv_diff_amt", "invDiffAmt");
        this.hashFields.put("pay_term_cd", "payTermCd");
        this.hashFields.put("inv_iss_dt", "invIssDt");
        this.hashFields.put("expn_aud_rslt_cd", "expnAudRsltCd");
        this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
        this.hashFields.put("exceed_avg_diff_amt", "exceedAvgDiffAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("aud_rlst_flg", "audRlstFlg");
        this.hashFields.put("pay_due_dt", "payDueDt");
        this.hashFields.put("s_trsp_cost_so_tp_cd", "sTrspCostSoTpCd");
        this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
        this.hashFields.put("inv_diff_pct", "invDiffPct");
        this.hashFields.put("s_csr_sts_cd", "sCsrStsCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("curr_cng_flg", "currCngFlg");
        this.hashFields.put("dis_inv_vndr_seq", "disInvVndrSeq");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("to_datetime", "toDatetime");
        this.hashFields.put("s_ofc_cd", "sOfcCd");
        this.hashFields.put("inv_iss_usr_nm", "invIssUsrNm");
        this.hashFields.put("aud_cfm_usr_nm", "audCfmUsrNm");
        this.hashFields.put("batch_tp_cd", "batchTpCd");
        this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
        this.hashFields.put("s_inv_no", "sInvNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("chk", "chk");
        this.hashFields.put("s_inv_vndr_seq", "sInvVndrSeq");
        this.hashFields.put("inv_iss_usr_id", "invIssUsrId");
        this.hashFields.put("s_trsp_crr_mod_cd", "sTrspCrrModCd");
        this.hashFields.put("inv_diff_flg", "invDiffFlg");
        this.hashFields.put("dis_inv_vndr_nm", "disInvVndrNm");
        this.hashFields.put("exceed_avg_flg", "exceedAvgFlg");
        this.hashFields.put("auto_aud_cfm_usr_id", "autoAudCfmUsrId");
        this.hashFields.put("inv_aud_sts_cd", "invAudStsCd");
        this.hashFields.put("s_csr_no", "sCsrNo");
        this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("auto_aud_sts_cd", "autoAudStsCd");
        this.hashFields.put("s_trsp_so_tp_cd", "sTrspSoTpCd");
        this.hashFields.put("hjl_inv_vndr_seq", "hjlInvVndrSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("s_to_dt", "sToDt");
        this.hashFields.put("expn_aud_rslt_usr_id", "expnAudRsltUsrId");
        this.hashFields.put("s_aud_itm_cd", "sAudItmCd");
        this.hashFields.put("expn_aud_rslt_rmk", "expnAudRsltRmk");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("eac_if_flg", "eacIfFlg");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("s_fm_dt", "sFmDt");
        this.hashFields.put("inv_vndr_nm", "invVndrNm");
        this.hashFields.put("s_auto_aud_sts_cd", "sAutoAudStsCd");
        this.hashFields.put("wo_amt", "woAmt");
        this.hashFields.put("inv_ofc_cd", "invOfcCd");
        this.hashFields.put("s_expn_aud_sts_cd", "sExpnAudStsCd");
        this.hashFields.put("hjl_inv_no", "hjlInvNo");
        this.hashFields.put("s_trsp_cost_dtl_mod_cd", "sTrspCostDtlModCd");
        this.hashFields.put("inv_cfm_dt", "invCfmDt");
        this.hashFields.put("expn_aud_sts_cd", "expnAudStsCd");
        this.hashFields.put("locl_cre_dt", "loclCreDt");
        this.hashFields.put("bat_prog_sts_cd", "batProgStsCd");
        this.hashFields.put("inv_diff_amt_flg", "invDiffAmtFlg");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("auto_aud_cfm_dt", "autoAudCfmDt");
        this.hashFields.put("no_agmt_flg", "noAgmtFlg");
        this.hashFields.put("sel_aud_cd", "selAudCd");
        this.hashFields.put("expn_aud_rslt_usr_nm", "expnAudRsltUsrNm");
        this.hashFields.put("aud_curr_cd", "audCurrCd");
        this.hashFields.put("aud_diff_amt", "audDiffAmt");
        this.hashFields.put("aud_usd_diff_amt", "audUsdDiffAmt");
        this.hashFields.put("inv_diff_amt_aud", "invDiffAmtAud");
        this.hashFields.put("inv_aud_curr_cd", "invAudCurrCd");
        this.hashFields.put("inv_aud_diff_amt", "invAudDiffAmt");
        this.hashFields.put("inv_aud_usd_diff_amt", "invAudUsdDiffAmt");
        return this.hashFields;
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
	 * @return avgOvrDiffFlg
	 */
    public String getAvgOvrDiffFlg() {
        return this.avgOvrDiffFlg;
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
	 * @return noOptmRoutFlg
	 */
    public String getNoOptmRoutFlg() {
        return this.noOptmRoutFlg;
    }

    /**
	 * Column Info
	 * @return invVndrSeq
	 */
    public String getInvVndrSeq() {
        return this.invVndrSeq;
    }

    /**
	 * Column Info
	 * @return invDiffAmt
	 */
    public String getInvDiffAmt() {
        return this.invDiffAmt;
    }

    /**
	 * Column Info
	 * @return payTermCd
	 */
    public String getPayTermCd() {
        return this.payTermCd;
    }

    /**
	 * Column Info
	 * @return invIssDt
	 */
    public String getInvIssDt() {
        return this.invIssDt;
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
	 * @return atchFileLnkId
	 */
    public String getAtchFileLnkId() {
        return this.atchFileLnkId;
    }

    /**
	 * Column Info
	 * @return exceedAvgDiffAmt
	 */
    public String getExceedAvgDiffAmt() {
        return this.exceedAvgDiffAmt;
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
	 * @return audRlstFlg
	 */
    public String getAudRlstFlg() {
        return this.audRlstFlg;
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
	 * @return sTrspCostSoTpCd
	 */
    public String getSTrspCostSoTpCd() {
        return this.sTrspCostSoTpCd;
    }

    /**
	 * Column Info
	 * @return trspSoTpCd
	 */
    public String getTrspSoTpCd() {
        return this.trspSoTpCd;
    }

    /**
	 * Column Info
	 * @return invDiffPct
	 */
    public String getInvDiffPct() {
        return this.invDiffPct;
    }

    /**
	 * Column Info
	 * @return sCsrStsCd
	 */
    public String getSCsrStsCd() {
        return this.sCsrStsCd;
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
	 * @return currCngFlg
	 */
    public String getCurrCngFlg() {
        return this.currCngFlg;
    }

    /**
	 * Column Info
	 * @return disInvVndrSeq
	 */
    public String getDisInvVndrSeq() {
        return this.disInvVndrSeq;
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
	 * @return toDatetime
	 */
    public String getToDatetime() {
        return this.toDatetime;
    }

    /**
	 * Column Info
	 * @return sOfcCd
	 */
    public String getSOfcCd() {
        return this.sOfcCd;
    }

    /**
	 * Column Info
	 * @return invIssUsrNm
	 */
    public String getInvIssUsrNm() {
        return this.invIssUsrNm;
    }

    /**
	 * Column Info
	 * @return audCfmUsrNm
	 */
    public String getAudCfmUsrNm() {
        return this.audCfmUsrNm;
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
	 * @return rhqOfcCd
	 */
    public String getRhqOfcCd() {
        return this.rhqOfcCd;
    }

    /**
	 * Column Info
	 * @return sInvNo
	 */
    public String getSInvNo() {
        return this.sInvNo;
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
	 * @return chk
	 */
    public String getChk() {
        return this.chk;
    }

    /**
	 * Column Info
	 * @return sInvVndrSeq
	 */
    public String getSInvVndrSeq() {
        return this.sInvVndrSeq;
    }

    /**
	 * Column Info
	 * @return invIssUsrId
	 */
    public String getInvIssUsrId() {
        return this.invIssUsrId;
    }

    /**
	 * Column Info
	 * @return sTrspCrrModCd
	 */
    public String getSTrspCrrModCd() {
        return this.sTrspCrrModCd;
    }

    /**
	 * Column Info
	 * @return invDiffFlg
	 */
    public String getInvDiffFlg() {
        return this.invDiffFlg;
    }

    /**
	 * Column Info
	 * @return disInvVndrNm
	 */
    public String getDisInvVndrNm() {
        return this.disInvVndrNm;
    }

    /**
	 * Column Info
	 * @return exceedAvgFlg
	 */
    public String getExceedAvgFlg() {
        return this.exceedAvgFlg;
    }

    /**
	 * Column Info
	 * @return autoAudCfmUsrId
	 */
    public String getAutoAudCfmUsrId() {
        return this.autoAudCfmUsrId;
    }

    /**
	 * Column Info
	 * @return invAudStsCd
	 */
    public String getInvAudStsCd() {
        return this.invAudStsCd;
    }

    /**
	 * Column Info
	 * @return sCsrNo
	 */
    public String getSCsrNo() {
        return this.sCsrNo;
    }

    /**
	 * Column Info
	 * @return sRhqOfcCd
	 */
    public String getSRhqOfcCd() {
        return this.sRhqOfcCd;
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
	 * @return autoAudStsCd
	 */
    public String getAutoAudStsCd() {
        return this.autoAudStsCd;
    }

    /**
	 * Column Info
	 * @return sTrspSoTpCd
	 */
    public String getSTrspSoTpCd() {
        return this.sTrspSoTpCd;
    }

    /**
	 * Column Info
	 * @return hjlInvVndrSeq
	 */
    public String getHjlInvVndrSeq() {
        return this.hjlInvVndrSeq;
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
	 * @return sToDt
	 */
    public String getSToDt() {
        return this.sToDt;
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
	 * @return sAudItmCd
	 */
    public String getSAudItmCd() {
        return this.sAudItmCd;
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
	 * @return eacIfFlg
	 */
    public String getEacIfFlg() {
        return this.eacIfFlg;
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
	 * @return sFmDt
	 */
    public String getSFmDt() {
        return this.sFmDt;
    }

    /**
	 * Column Info
	 * @return invVndrNm
	 */
    public String getInvVndrNm() {
        return this.invVndrNm;
    }

    /**
	 * Column Info
	 * @return sAutoAudStsCd
	 */
    public String getSAutoAudStsCd() {
        return this.sAutoAudStsCd;
    }

    /**
	 * Column Info
	 * @return woAmt
	 */
    public String getWoAmt() {
        return this.woAmt;
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
	 * @return sExpnAudStsCd
	 */
    public String getSExpnAudStsCd() {
        return this.sExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @return hjlInvNo
	 */
    public String getHjlInvNo() {
        return this.hjlInvNo;
    }

    /**
	 * Column Info
	 * @return sTrspCostDtlModCd
	 */
    public String getSTrspCostDtlModCd() {
        return this.sTrspCostDtlModCd;
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
	 * @return expnAudStsCd
	 */
    public String getExpnAudStsCd() {
        return this.expnAudStsCd;
    }

    /**
	 * Column Info
	 * @return loclCreDt
	 */
    public String getLoclCreDt() {
        return this.loclCreDt;
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
	 * @return invDiffAmtFlg
	 */
    public String getInvDiffAmtFlg() {
        return this.invDiffAmtFlg;
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
	 * @return autoAudCfmDt
	 */
    public String getAutoAudCfmDt() {
        return this.autoAudCfmDt;
    }

    /**
	 * Column Info
	 * @return noAgmtFlg
	 */
    public String getNoAgmtFlg() {
        return this.noAgmtFlg;
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
	 * @return expnAudRsltUsrNm
	 */
    public String getExpnAudRsltUsrNm() {
        return this.expnAudRsltUsrNm;
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
	 * @param avgOvrDiffFlg
	 */
    public void setAvgOvrDiffFlg(String avgOvrDiffFlg) {
        this.avgOvrDiffFlg = avgOvrDiffFlg;
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
	 * @param noOptmRoutFlg
	 */
    public void setNoOptmRoutFlg(String noOptmRoutFlg) {
        this.noOptmRoutFlg = noOptmRoutFlg;
    }

    /**
	 * Column Info
	 * @param invVndrSeq
	 */
    public void setInvVndrSeq(String invVndrSeq) {
        this.invVndrSeq = invVndrSeq;
    }

    /**
	 * Column Info
	 * @param invDiffAmt
	 */
    public void setInvDiffAmt(String invDiffAmt) {
        this.invDiffAmt = invDiffAmt;
    }

    /**
	 * Column Info
	 * @param payTermCd
	 */
    public void setPayTermCd(String payTermCd) {
        this.payTermCd = payTermCd;
    }

    /**
	 * Column Info
	 * @param invIssDt
	 */
    public void setInvIssDt(String invIssDt) {
        this.invIssDt = invIssDt;
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
	 * @param atchFileLnkId
	 */
    public void setAtchFileLnkId(String atchFileLnkId) {
        this.atchFileLnkId = atchFileLnkId;
    }

    /**
	 * Column Info
	 * @param exceedAvgDiffAmt
	 */
    public void setExceedAvgDiffAmt(String exceedAvgDiffAmt) {
        this.exceedAvgDiffAmt = exceedAvgDiffAmt;
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
	 * @param audRlstFlg
	 */
    public void setAudRlstFlg(String audRlstFlg) {
        this.audRlstFlg = audRlstFlg;
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
	 * @param sTrspCostSoTpCd
	 */
    public void setSTrspCostSoTpCd(String sTrspCostSoTpCd) {
        this.sTrspCostSoTpCd = sTrspCostSoTpCd;
    }

    /**
	 * Column Info
	 * @param trspSoTpCd
	 */
    public void setTrspSoTpCd(String trspSoTpCd) {
        this.trspSoTpCd = trspSoTpCd;
    }

    /**
	 * Column Info
	 * @param invDiffPct
	 */
    public void setInvDiffPct(String invDiffPct) {
        this.invDiffPct = invDiffPct;
    }

    /**
	 * Column Info
	 * @param sCsrStsCd
	 */
    public void setSCsrStsCd(String sCsrStsCd) {
        this.sCsrStsCd = sCsrStsCd;
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
	 * @param currCngFlg
	 */
    public void setCurrCngFlg(String currCngFlg) {
        this.currCngFlg = currCngFlg;
    }

    /**
	 * Column Info
	 * @param disInvVndrSeq
	 */
    public void setDisInvVndrSeq(String disInvVndrSeq) {
        this.disInvVndrSeq = disInvVndrSeq;
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
	 * @param toDatetime
	 */
    public void setToDatetime(String toDatetime) {
        this.toDatetime = toDatetime;
    }

    /**
	 * Column Info
	 * @param sOfcCd
	 */
    public void setSOfcCd(String sOfcCd) {
        this.sOfcCd = sOfcCd;
    }

    /**
	 * Column Info
	 * @param invIssUsrNm
	 */
    public void setInvIssUsrNm(String invIssUsrNm) {
        this.invIssUsrNm = invIssUsrNm;
    }

    /**
	 * Column Info
	 * @param audCfmUsrNm
	 */
    public void setAudCfmUsrNm(String audCfmUsrNm) {
        this.audCfmUsrNm = audCfmUsrNm;
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
	 * @param rhqOfcCd
	 */
    public void setRhqOfcCd(String rhqOfcCd) {
        this.rhqOfcCd = rhqOfcCd;
    }

    /**
	 * Column Info
	 * @param sInvNo
	 */
    public void setSInvNo(String sInvNo) {
        this.sInvNo = sInvNo;
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
	 * @param chk
	 */
    public void setChk(String chk) {
        this.chk = chk;
    }

    /**
	 * Column Info
	 * @param sInvVndrSeq
	 */
    public void setSInvVndrSeq(String sInvVndrSeq) {
        this.sInvVndrSeq = sInvVndrSeq;
    }

    /**
	 * Column Info
	 * @param invIssUsrId
	 */
    public void setInvIssUsrId(String invIssUsrId) {
        this.invIssUsrId = invIssUsrId;
    }

    /**
	 * Column Info
	 * @param sTrspCrrModCd
	 */
    public void setSTrspCrrModCd(String sTrspCrrModCd) {
        this.sTrspCrrModCd = sTrspCrrModCd;
    }

    /**
	 * Column Info
	 * @param invDiffFlg
	 */
    public void setInvDiffFlg(String invDiffFlg) {
        this.invDiffFlg = invDiffFlg;
    }

    /**
	 * Column Info
	 * @param disInvVndrNm
	 */
    public void setDisInvVndrNm(String disInvVndrNm) {
        this.disInvVndrNm = disInvVndrNm;
    }

    /**
	 * Column Info
	 * @param exceedAvgFlg
	 */
    public void setExceedAvgFlg(String exceedAvgFlg) {
        this.exceedAvgFlg = exceedAvgFlg;
    }

    /**
	 * Column Info
	 * @param autoAudCfmUsrId
	 */
    public void setAutoAudCfmUsrId(String autoAudCfmUsrId) {
        this.autoAudCfmUsrId = autoAudCfmUsrId;
    }

    /**
	 * Column Info
	 * @param invAudStsCd
	 */
    public void setInvAudStsCd(String invAudStsCd) {
        this.invAudStsCd = invAudStsCd;
    }

    /**
	 * Column Info
	 * @param sCsrNo
	 */
    public void setSCsrNo(String sCsrNo) {
        this.sCsrNo = sCsrNo;
    }

    /**
	 * Column Info
	 * @param sRhqOfcCd
	 */
    public void setSRhqOfcCd(String sRhqOfcCd) {
        this.sRhqOfcCd = sRhqOfcCd;
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
	 * @param autoAudStsCd
	 */
    public void setAutoAudStsCd(String autoAudStsCd) {
        this.autoAudStsCd = autoAudStsCd;
    }

    /**
	 * Column Info
	 * @param sTrspSoTpCd
	 */
    public void setSTrspSoTpCd(String sTrspSoTpCd) {
        this.sTrspSoTpCd = sTrspSoTpCd;
    }

    /**
	 * Column Info
	 * @param hjlInvVndrSeq
	 */
    public void setHjlInvVndrSeq(String hjlInvVndrSeq) {
        this.hjlInvVndrSeq = hjlInvVndrSeq;
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
	 * @param sToDt
	 */
    public void setSToDt(String sToDt) {
        this.sToDt = sToDt;
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
	 * @param sAudItmCd
	 */
    public void setSAudItmCd(String sAudItmCd) {
        this.sAudItmCd = sAudItmCd;
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
	 * @param eacIfFlg
	 */
    public void setEacIfFlg(String eacIfFlg) {
        this.eacIfFlg = eacIfFlg;
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
	 * @param sFmDt
	 */
    public void setSFmDt(String sFmDt) {
        this.sFmDt = sFmDt;
    }

    /**
	 * Column Info
	 * @param invVndrNm
	 */
    public void setInvVndrNm(String invVndrNm) {
        this.invVndrNm = invVndrNm;
    }

    /**
	 * Column Info
	 * @param sAutoAudStsCd
	 */
    public void setSAutoAudStsCd(String sAutoAudStsCd) {
        this.sAutoAudStsCd = sAutoAudStsCd;
    }

    /**
	 * Column Info
	 * @param woAmt
	 */
    public void setWoAmt(String woAmt) {
        this.woAmt = woAmt;
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
	 * @param sExpnAudStsCd
	 */
    public void setSExpnAudStsCd(String sExpnAudStsCd) {
        this.sExpnAudStsCd = sExpnAudStsCd;
    }

    /**
	 * Column Info
	 * @param hjlInvNo
	 */
    public void setHjlInvNo(String hjlInvNo) {
        this.hjlInvNo = hjlInvNo;
    }

    /**
	 * Column Info
	 * @param sTrspCostDtlModCd
	 */
    public void setSTrspCostDtlModCd(String sTrspCostDtlModCd) {
        this.sTrspCostDtlModCd = sTrspCostDtlModCd;
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
	 * @param expnAudStsCd
	 */
    public void setExpnAudStsCd(String expnAudStsCd) {
        this.expnAudStsCd = expnAudStsCd;
    }

    /**
	 * Column Info
	 * @param loclCreDt
	 */
    public void setLoclCreDt(String loclCreDt) {
        this.loclCreDt = loclCreDt;
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
	 * @param invDiffAmtFlg
	 */
    public void setInvDiffAmtFlg(String invDiffAmtFlg) {
        this.invDiffAmtFlg = invDiffAmtFlg;
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
	 * @param autoAudCfmDt
	 */
    public void setAutoAudCfmDt(String autoAudCfmDt) {
        this.autoAudCfmDt = autoAudCfmDt;
    }

    /**
	 * Column Info
	 * @param noAgmtFlg
	 */
    public void setNoAgmtFlg(String noAgmtFlg) {
        this.noAgmtFlg = noAgmtFlg;
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
	 * @param expnAudRsltUsrNm
	 */
    public void setExpnAudRsltUsrNm(String expnAudRsltUsrNm) {
        this.expnAudRsltUsrNm = expnAudRsltUsrNm;
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
        setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
        setAvgOvrDiffFlg(JSPUtil.getParameter(request, prefix + "avg_ovr_diff_flg", ""));
        setSSaveTpCd(JSPUtil.getParameter(request, prefix + "s_save_tp_cd", ""));
        setNoOptmRoutFlg(JSPUtil.getParameter(request, prefix + "no_optm_rout_flg", ""));
        setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
        setInvDiffAmt(JSPUtil.getParameter(request, prefix + "inv_diff_amt", ""));
        setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
        setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
        setExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", ""));
        setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
        setExceedAvgDiffAmt(JSPUtil.getParameter(request, prefix + "exceed_avg_diff_amt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setAudRlstFlg(JSPUtil.getParameter(request, prefix + "aud_rlst_flg", ""));
        setPayDueDt(JSPUtil.getParameter(request, prefix + "pay_due_dt", ""));
        setSTrspCostSoTpCd(JSPUtil.getParameter(request, prefix + "s_trsp_cost_so_tp_cd", ""));
        setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
        setInvDiffPct(JSPUtil.getParameter(request, prefix + "inv_diff_pct", ""));
        setSCsrStsCd(JSPUtil.getParameter(request, prefix + "s_csr_sts_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setCurrCngFlg(JSPUtil.getParameter(request, prefix + "curr_cng_flg", ""));
        setDisInvVndrSeq(JSPUtil.getParameter(request, prefix + "dis_inv_vndr_seq", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setToDatetime(JSPUtil.getParameter(request, prefix + "to_datetime", ""));
        setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
        setInvIssUsrNm(JSPUtil.getParameter(request, prefix + "inv_iss_usr_nm", ""));
        setAudCfmUsrNm(JSPUtil.getParameter(request, prefix + "aud_cfm_usr_nm", ""));
        setBatchTpCd(JSPUtil.getParameter(request, prefix + "batch_tp_cd", ""));
        setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
        setSInvNo(JSPUtil.getParameter(request, prefix + "s_inv_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
        setSInvVndrSeq(JSPUtil.getParameter(request, prefix + "s_inv_vndr_seq", ""));
        setInvIssUsrId(JSPUtil.getParameter(request, prefix + "inv_iss_usr_id", ""));
        setSTrspCrrModCd(JSPUtil.getParameter(request, prefix + "s_trsp_crr_mod_cd", ""));
        setInvDiffFlg(JSPUtil.getParameter(request, prefix + "inv_diff_flg", ""));
        setDisInvVndrNm(JSPUtil.getParameter(request, prefix + "dis_inv_vndr_nm", ""));
        setExceedAvgFlg(JSPUtil.getParameter(request, prefix + "exceed_avg_flg", ""));
        setAutoAudCfmUsrId(JSPUtil.getParameter(request, prefix + "auto_aud_cfm_usr_id", ""));
        setInvAudStsCd(JSPUtil.getParameter(request, prefix + "inv_aud_sts_cd", ""));
        setSCsrNo(JSPUtil.getParameter(request, prefix + "s_csr_no", ""));
        setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setAutoAudStsCd(JSPUtil.getParameter(request, prefix + "auto_aud_sts_cd", ""));
        setSTrspSoTpCd(JSPUtil.getParameter(request, prefix + "s_trsp_so_tp_cd", ""));
        setHjlInvVndrSeq(JSPUtil.getParameter(request, prefix + "hjl_inv_vndr_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
        setExpnAudRsltUsrId(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_id", ""));
        setSAudItmCd(JSPUtil.getParameter(request, prefix + "s_aud_itm_cd", ""));
        setExpnAudRsltRmk(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
        setInvVndrNm(JSPUtil.getParameter(request, prefix + "inv_vndr_nm", ""));
        setSAutoAudStsCd(JSPUtil.getParameter(request, prefix + "s_auto_aud_sts_cd", ""));
        setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
        setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
        setSExpnAudStsCd(JSPUtil.getParameter(request, prefix + "s_expn_aud_sts_cd", ""));
        setHjlInvNo(JSPUtil.getParameter(request, prefix + "hjl_inv_no", ""));
        setSTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "s_trsp_cost_dtl_mod_cd", ""));
        setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
        setExpnAudStsCd(JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", ""));
        setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
        setBatProgStsCd(JSPUtil.getParameter(request, prefix + "bat_prog_sts_cd", ""));
        setInvDiffAmtFlg(JSPUtil.getParameter(request, prefix + "inv_diff_amt_flg", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setAutoAudCfmDt(JSPUtil.getParameter(request, prefix + "auto_aud_cfm_dt", ""));
        setNoAgmtFlg(JSPUtil.getParameter(request, prefix + "no_agmt_flg", ""));
        setSelAudCd(JSPUtil.getParameter(request, prefix + "sel_aud_cd", ""));
        setExpnAudRsltUsrNm(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_nm", ""));
        setInvAudCurrCd(JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", ""));
        setInvAudDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", ""));
        setInvAudUsdDiffAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsPreAudListVO[]
	 */
    public TrsPreAudListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsPreAudListVO[]
	 */
    public TrsPreAudListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TrsPreAudListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] payDt = (JSPUtil.getParameter(request, prefix + "pay_dt", length));
            String[] avgOvrDiffFlg = (JSPUtil.getParameter(request, prefix + "avg_ovr_diff_flg", length));
            String[] sSaveTpCd = (JSPUtil.getParameter(request, prefix + "s_save_tp_cd", length));
            String[] noOptmRoutFlg = (JSPUtil.getParameter(request, prefix + "no_optm_rout_flg", length));
            String[] invVndrSeq = (JSPUtil.getParameter(request, prefix + "inv_vndr_seq", length));
            String[] invDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_diff_amt", length));
            String[] payTermCd = (JSPUtil.getParameter(request, prefix + "pay_term_cd", length));
            String[] invIssDt = (JSPUtil.getParameter(request, prefix + "inv_iss_dt", length));
            String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", length));
            String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", length));
            String[] exceedAvgDiffAmt = (JSPUtil.getParameter(request, prefix + "exceed_avg_diff_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] audRlstFlg = (JSPUtil.getParameter(request, prefix + "aud_rlst_flg", length));
            String[] payDueDt = (JSPUtil.getParameter(request, prefix + "pay_due_dt", length));
            String[] sTrspCostSoTpCd = (JSPUtil.getParameter(request, prefix + "s_trsp_cost_so_tp_cd", length));
            String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", length));
            String[] invDiffPct = (JSPUtil.getParameter(request, prefix + "inv_diff_pct", length));
            String[] sCsrStsCd = (JSPUtil.getParameter(request, prefix + "s_csr_sts_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] currCngFlg = (JSPUtil.getParameter(request, prefix + "curr_cng_flg", length));
            String[] disInvVndrSeq = (JSPUtil.getParameter(request, prefix + "dis_inv_vndr_seq", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] toDatetime = (JSPUtil.getParameter(request, prefix + "to_datetime", length));
            String[] sOfcCd = (JSPUtil.getParameter(request, prefix + "s_ofc_cd", length));
            String[] invIssUsrNm = (JSPUtil.getParameter(request, prefix + "inv_iss_usr_nm", length));
            String[] audCfmUsrNm = (JSPUtil.getParameter(request, prefix + "aud_cfm_usr_nm", length));
            String[] batchTpCd = (JSPUtil.getParameter(request, prefix + "batch_tp_cd", length));
            String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", length));
            String[] sInvNo = (JSPUtil.getParameter(request, prefix + "s_inv_no", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] chk = (JSPUtil.getParameter(request, prefix + "chk", length));
            String[] sInvVndrSeq = (JSPUtil.getParameter(request, prefix + "s_inv_vndr_seq", length));
            String[] invIssUsrId = (JSPUtil.getParameter(request, prefix + "inv_iss_usr_id", length));
            String[] sTrspCrrModCd = (JSPUtil.getParameter(request, prefix + "s_trsp_crr_mod_cd", length));
            String[] invDiffFlg = (JSPUtil.getParameter(request, prefix + "inv_diff_flg", length));
            String[] disInvVndrNm = (JSPUtil.getParameter(request, prefix + "dis_inv_vndr_nm", length));
            String[] exceedAvgFlg = (JSPUtil.getParameter(request, prefix + "exceed_avg_flg", length));
            String[] autoAudCfmUsrId = (JSPUtil.getParameter(request, prefix + "auto_aud_cfm_usr_id", length));
            String[] invAudStsCd = (JSPUtil.getParameter(request, prefix + "inv_aud_sts_cd", length));
            String[] sCsrNo = (JSPUtil.getParameter(request, prefix + "s_csr_no", length));
            String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] autoAudStsCd = (JSPUtil.getParameter(request, prefix + "auto_aud_sts_cd", length));
            String[] sTrspSoTpCd = (JSPUtil.getParameter(request, prefix + "s_trsp_so_tp_cd", length));
            String[] hjlInvVndrSeq = (JSPUtil.getParameter(request, prefix + "hjl_inv_vndr_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sToDt = (JSPUtil.getParameter(request, prefix + "s_to_dt", length));
            String[] expnAudRsltUsrId = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_id", length));
            String[] sAudItmCd = (JSPUtil.getParameter(request, prefix + "s_aud_itm_cd", length));
            String[] expnAudRsltRmk = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_rmk", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] eacIfFlg = (JSPUtil.getParameter(request, prefix + "eac_if_flg", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] sFmDt = (JSPUtil.getParameter(request, prefix + "s_fm_dt", length));
            String[] invVndrNm = (JSPUtil.getParameter(request, prefix + "inv_vndr_nm", length));
            String[] sAutoAudStsCd = (JSPUtil.getParameter(request, prefix + "s_auto_aud_sts_cd", length));
            String[] woAmt = (JSPUtil.getParameter(request, prefix + "wo_amt", length));
            String[] invOfcCd = (JSPUtil.getParameter(request, prefix + "inv_ofc_cd", length));
            String[] sExpnAudStsCd = (JSPUtil.getParameter(request, prefix + "s_expn_aud_sts_cd", length));
            String[] hjlInvNo = (JSPUtil.getParameter(request, prefix + "hjl_inv_no", length));
            String[] sTrspCostDtlModCd = (JSPUtil.getParameter(request, prefix + "s_trsp_cost_dtl_mod_cd", length));
            String[] invCfmDt = (JSPUtil.getParameter(request, prefix + "inv_cfm_dt", length));
            String[] expnAudStsCd = (JSPUtil.getParameter(request, prefix + "expn_aud_sts_cd", length));
            String[] loclCreDt = (JSPUtil.getParameter(request, prefix + "locl_cre_dt", length));
            String[] batProgStsCd = (JSPUtil.getParameter(request, prefix + "bat_prog_sts_cd", length));
            String[] invDiffAmtFlg = (JSPUtil.getParameter(request, prefix + "inv_diff_amt_flg", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] autoAudCfmDt = (JSPUtil.getParameter(request, prefix + "auto_aud_cfm_dt", length));
            String[] noAgmtFlg = (JSPUtil.getParameter(request, prefix + "no_agmt_flg", length));
            String[] selAudCd = (JSPUtil.getParameter(request, prefix + "sel_aud_cd", length));
            String[] expnAudRsltUsrNm = (JSPUtil.getParameter(request, prefix + "expn_aud_rslt_usr_nm", length));
            String[] invAudCurrCd = (JSPUtil.getParameter(request, prefix + "inv_aud_curr_cd", length));
            String[] invAudDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_diff_amt", length));
            String[] invAudUsdDiffAmt = (JSPUtil.getParameter(request, prefix + "inv_aud_usd_diff_amt", length));
            for (int i = 0; i < length; i++) {
                model = new TrsPreAudListVO();
                if (payDt[i] != null)
                    model.setPayDt(payDt[i]);
                if (avgOvrDiffFlg[i] != null)
                    model.setAvgOvrDiffFlg(avgOvrDiffFlg[i]);
                if (sSaveTpCd[i] != null)
                    model.setSSaveTpCd(sSaveTpCd[i]);
                if (noOptmRoutFlg[i] != null)
                    model.setNoOptmRoutFlg(noOptmRoutFlg[i]);
                if (invVndrSeq[i] != null)
                    model.setInvVndrSeq(invVndrSeq[i]);
                if (invDiffAmt[i] != null)
                    model.setInvDiffAmt(invDiffAmt[i]);
                if (payTermCd[i] != null)
                    model.setPayTermCd(payTermCd[i]);
                if (invIssDt[i] != null)
                    model.setInvIssDt(invIssDt[i]);
                if (expnAudRsltCd[i] != null)
                    model.setExpnAudRsltCd(expnAudRsltCd[i]);
                if (atchFileLnkId[i] != null)
                    model.setAtchFileLnkId(atchFileLnkId[i]);
                if (exceedAvgDiffAmt[i] != null)
                    model.setExceedAvgDiffAmt(exceedAvgDiffAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (audRlstFlg[i] != null)
                    model.setAudRlstFlg(audRlstFlg[i]);
                if (payDueDt[i] != null)
                    model.setPayDueDt(payDueDt[i]);
                if (sTrspCostSoTpCd[i] != null)
                    model.setSTrspCostSoTpCd(sTrspCostSoTpCd[i]);
                if (trspSoTpCd[i] != null)
                    model.setTrspSoTpCd(trspSoTpCd[i]);
                if (invDiffPct[i] != null)
                    model.setInvDiffPct(invDiffPct[i]);
                if (sCsrStsCd[i] != null)
                    model.setSCsrStsCd(sCsrStsCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (currCngFlg[i] != null)
                    model.setCurrCngFlg(currCngFlg[i]);
                if (disInvVndrSeq[i] != null)
                    model.setDisInvVndrSeq(disInvVndrSeq[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (toDatetime[i] != null)
                    model.setToDatetime(toDatetime[i]);
                if (sOfcCd[i] != null)
                    model.setSOfcCd(sOfcCd[i]);
                if (invIssUsrNm[i] != null)
                    model.setInvIssUsrNm(invIssUsrNm[i]);
                if (audCfmUsrNm[i] != null)
                    model.setAudCfmUsrNm(audCfmUsrNm[i]);
                if (batchTpCd[i] != null)
                    model.setBatchTpCd(batchTpCd[i]);
                if (rhqOfcCd[i] != null)
                    model.setRhqOfcCd(rhqOfcCd[i]);
                if (sInvNo[i] != null)
                    model.setSInvNo(sInvNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (chk[i] != null)
                    model.setChk(chk[i]);
                if (sInvVndrSeq[i] != null)
                    model.setSInvVndrSeq(sInvVndrSeq[i]);
                if (invIssUsrId[i] != null)
                    model.setInvIssUsrId(invIssUsrId[i]);
                if (sTrspCrrModCd[i] != null)
                    model.setSTrspCrrModCd(sTrspCrrModCd[i]);
                if (invDiffFlg[i] != null)
                    model.setInvDiffFlg(invDiffFlg[i]);
                if (disInvVndrNm[i] != null)
                    model.setDisInvVndrNm(disInvVndrNm[i]);
                if (exceedAvgFlg[i] != null)
                    model.setExceedAvgFlg(exceedAvgFlg[i]);
                if (autoAudCfmUsrId[i] != null)
                    model.setAutoAudCfmUsrId(autoAudCfmUsrId[i]);
                if (invAudStsCd[i] != null)
                    model.setInvAudStsCd(invAudStsCd[i]);
                if (sCsrNo[i] != null)
                    model.setSCsrNo(sCsrNo[i]);
                if (sRhqOfcCd[i] != null)
                    model.setSRhqOfcCd(sRhqOfcCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (autoAudStsCd[i] != null)
                    model.setAutoAudStsCd(autoAudStsCd[i]);
                if (sTrspSoTpCd[i] != null)
                    model.setSTrspSoTpCd(sTrspSoTpCd[i]);
                if (hjlInvVndrSeq[i] != null)
                    model.setHjlInvVndrSeq(hjlInvVndrSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sToDt[i] != null)
                    model.setSToDt(sToDt[i]);
                if (expnAudRsltUsrId[i] != null)
                    model.setExpnAudRsltUsrId(expnAudRsltUsrId[i]);
                if (sAudItmCd[i] != null)
                    model.setSAudItmCd(sAudItmCd[i]);
                if (expnAudRsltRmk[i] != null)
                    model.setExpnAudRsltRmk(expnAudRsltRmk[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (eacIfFlg[i] != null)
                    model.setEacIfFlg(eacIfFlg[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (sFmDt[i] != null)
                    model.setSFmDt(sFmDt[i]);
                if (invVndrNm[i] != null)
                    model.setInvVndrNm(invVndrNm[i]);
                if (sAutoAudStsCd[i] != null)
                    model.setSAutoAudStsCd(sAutoAudStsCd[i]);
                if (woAmt[i] != null)
                    model.setWoAmt(woAmt[i]);
                if (invOfcCd[i] != null)
                    model.setInvOfcCd(invOfcCd[i]);
                if (sExpnAudStsCd[i] != null)
                    model.setSExpnAudStsCd(sExpnAudStsCd[i]);
                if (hjlInvNo[i] != null)
                    model.setHjlInvNo(hjlInvNo[i]);
                if (sTrspCostDtlModCd[i] != null)
                    model.setSTrspCostDtlModCd(sTrspCostDtlModCd[i]);
                if (invCfmDt[i] != null)
                    model.setInvCfmDt(invCfmDt[i]);
                if (expnAudStsCd[i] != null)
                    model.setExpnAudStsCd(expnAudStsCd[i]);
                if (loclCreDt[i] != null)
                    model.setLoclCreDt(loclCreDt[i]);
                if (batProgStsCd[i] != null)
                    model.setBatProgStsCd(batProgStsCd[i]);
                if (invDiffAmtFlg[i] != null)
                    model.setInvDiffAmtFlg(invDiffAmtFlg[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (autoAudCfmDt[i] != null)
                    model.setAutoAudCfmDt(autoAudCfmDt[i]);
                if (noAgmtFlg[i] != null)
                    model.setNoAgmtFlg(noAgmtFlg[i]);
                if (selAudCd[i] != null)
                    model.setSelAudCd(selAudCd[i]);
                if (expnAudRsltUsrNm[i] != null)
                    model.setExpnAudRsltUsrNm(expnAudRsltUsrNm[i]);
                if (invAudCurrCd[i] != null)
                    model.setInvAudCurrCd(invAudCurrCd[i]);
                if (invAudDiffAmt[i] != null)
                    model.setInvAudDiffAmt(invAudDiffAmt[i]);
                if (invAudUsdDiffAmt[i] != null)
                    model.setInvAudUsdDiffAmt(invAudUsdDiffAmt[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTrsPreAudListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return TrsPreAudListVO[]
	 */
    public TrsPreAudListVO[] getTrsPreAudListVOs() {
        TrsPreAudListVO[] vos = (TrsPreAudListVO[]) models.toArray(new TrsPreAudListVO[models.size()]);
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
        this.payDt = this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.avgOvrDiffFlg = this.avgOvrDiffFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSaveTpCd = this.sSaveTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noOptmRoutFlg = this.noOptmRoutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invVndrSeq = this.invVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffAmt = this.invDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payTermCd = this.payTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssDt = this.invIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltCd = this.expnAudRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.atchFileLnkId = this.atchFileLnkId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exceedAvgDiffAmt = this.exceedAvgDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audRlstFlg = this.audRlstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payDueDt = this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrspCostSoTpCd = this.sTrspCostSoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trspSoTpCd = this.trspSoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffPct = this.invDiffPct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCsrStsCd = this.sCsrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCngFlg = this.currCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.disInvVndrSeq = this.disInvVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toDatetime = this.toDatetime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sOfcCd = this.sOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssUsrNm = this.invIssUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.audCfmUsrNm = this.audCfmUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batchTpCd = this.batchTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfcCd = this.rhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sInvNo = this.sInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chk = this.chk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sInvVndrSeq = this.sInvVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invIssUsrId = this.invIssUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrspCrrModCd = this.sTrspCrrModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffFlg = this.invDiffFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.disInvVndrNm = this.disInvVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exceedAvgFlg = this.exceedAvgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAudCfmUsrId = this.autoAudCfmUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudStsCd = this.invAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCsrNo = this.sCsrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sRhqOfcCd = this.sRhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAudStsCd = this.autoAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrspSoTpCd = this.sTrspSoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hjlInvVndrSeq = this.hjlInvVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sToDt = this.sToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltUsrId = this.expnAudRsltUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sAudItmCd = this.sAudItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltRmk = this.expnAudRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eacIfFlg = this.eacIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sFmDt = this.sFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invVndrNm = this.invVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sAutoAudStsCd = this.sAutoAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woAmt = this.woAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invOfcCd = this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sExpnAudStsCd = this.sExpnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hjlInvNo = this.hjlInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrspCostDtlModCd = this.sTrspCostDtlModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCfmDt = this.invCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudStsCd = this.expnAudStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCreDt = this.loclCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.batProgStsCd = this.batProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invDiffAmtFlg = this.invDiffAmtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAudCfmDt = this.autoAudCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noAgmtFlg = this.noAgmtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selAudCd = this.selAudCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expnAudRsltUsrNm = this.expnAudRsltUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudCurrCd = this.invAudCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudDiffAmt = this.invAudDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAudUsdDiffAmt = this.invAudUsdDiffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
