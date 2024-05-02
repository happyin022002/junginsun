/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrRprRqstHdrVO.java
*@FileTitle : CustomMnrRprRqstHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.03.21 김종옥 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CustomMnrRprRqstHdrVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CustomMnrRprRqstHdrVO> models = new ArrayList<CustomMnrRprRqstHdrVO>();

    /* Column Info */
    private String mnrMeasUtNm = null;

    /* Column Info */
    private String aproOfcCd = null;

    /* Column Info */
    private String agmtOfcCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrNm = null;

    /* Column Info */
    private String mnrOrdOfcCtyCd = null;

    /* Column Info */
    private String costCd = null;

    /* Column Info */
    private String sorting = null;

    /* Column Info */
    private String eqDmgTpCd = null;

    /* Column Info */
    private String rprOffhFlg = null;

    /* Column Info */
    private String n3ptyBilTtlAmt = null;

    /* Column Info */
    private String rprRqstSeq = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String mnrEdiNm = null;

    /* Column Info */
    private String agmtRefNo = null;

    /* Column Info */
    private String rprStsCd = null;

    /* Column Info */
    private String dispNo = null;

    /* Column Info */
    private String agmtSeq = null;

    /* Column Info */
    private String agmtNo = null;

    /* Column Info */
    private String mnrRprRmk = null;

    /* Column Info */
    private String ediId = null;

    /* Column Info */
    private String aproDt = null;

    /* Column Info */
    private String trsmModCd = null;

    /* Column Info */
    private String eqTpszCd = null;

    /* Column Info */
    private String dmgFlag = null;

    /* Column Info */
    private String dispFlg = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String trfNo = null;

    /* Column Info */
    private String agmtOfcCtyCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String autoAmt = null;

    /* Column Info */
    private String fileSeq = null;

    /* Column Info */
    private String agmtVerNo = null;

    /* Column Info */
    private String rprRsltDt = null;

    /* Column Info */
    private String ifTrcSeq = null;

    /* Column Info */
    private String recentRprTpCd = null;

    /* Column Info */
    private String mnrVrfyTpCd = null;

    /* Column Info */
    private String rqstUsrId = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String rprRqstVerNo = null;

    /* Column Info */
    private String rqstRefNo = null;

    /* Column Info */
    private String mnrInpTpCd = null;

    /* Column Info */
    private String eqDmgDt = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String immExt = null;

    /* Column Info */
    private String rprWrkTpCd = null;

    /* Column Info */
    private String totalAmt = null;

    /* Column Info */
    private String totalUsdAmt = null;

    /* Column Info */
    private String upprOfcCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rprRqstTmpSeq = null;

    /* Column Info */
    private String rqstEqNo = null;

    /* Column Info */
    private String rprDtlStsCd = null;

    /* Column Info */
    private String rprYdCd = null;

    /* Column Info */
    private String appovalAmt = null;

    /* Column Info */
    private String rprRqstLstVerFlg = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String n3ptyFlg = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String costOfcCd = null;

    /* Column Info */
    private String rqstUsrNm = null;

    /* Column Info */
    private String dispDtlSeq = null;

    /* Column Info */
    private String eqKndCd = null;

    /* Column Info */
    private String aproUsrId = null;

    /* Column Info */
    private String mnrOrdSeq = null;

    /* Column Info */
    private String mnrMeasUtCd = null;

    /* Column Info */
    private String dupChk = null;

    /* Column Info */
    private String dpRqstDt = null;

    /* Column Info */
    private String reqStDt = null;

    /* Column Info */
    private String reqEndDt = null;

    /* Column Info */
    private String soldEq = null;

    /* Column Info */
    private String rctRprFlg = null;

    /* Column Info */
    private String vrfyRsltRmk = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CustomMnrRprRqstHdrVO() {
    }

    public CustomMnrRprRqstHdrVO(String ibflag, String pagerows, String mnrMeasUtNm, String aproOfcCd, String agmtOfcCd, String vndrNm, String mnrOrdOfcCtyCd, String costCd, String eqDmgTpCd, String rprOffhFlg, String n3ptyBilTtlAmt, String rprRqstSeq, String updUsrId, String mnrEdiNm, String agmtRefNo, String dispNo, String rprStsCd, String agmtSeq, String agmtNo, String mnrRprRmk, String ediId, String trsmModCd, String aproDt, String eqTpszCd, String dmgFlag, String dispFlg, String creUsrId, String trfNo, String agmtOfcCtyCd, String vndrSeq, String autoAmt, String fileSeq, String agmtVerNo, String rprRsltDt, String ifTrcSeq, String recentRprTpCd, String mnrVrfyTpCd, String rqstUsrId, String currCd, String rprRqstVerNo, String rqstRefNo, String mnrInpTpCd, String eqDmgDt, String creDt, String immExt, String rprWrkTpCd, String totalAmt, String totalUsdAmt, String upprOfcCd, String rprRqstTmpSeq, String rprDtlStsCd, String rqstEqNo, String rprYdCd, String appovalAmt, String rprRqstLstVerFlg, String n3ptyFlg, String updDt, String rqstDt, String costOfcCd, String rqstUsrNm, String eqKndCd, String dispDtlSeq, String aproUsrId, String mnrOrdSeq, String mnrMeasUtCd, String sorting, String dupChk, String dpRqstDt, String reqStDt, String reqEndDt, String soldEq, String rctRprFlg, String vrfyRsltRmk) {
        this.mnrMeasUtNm = mnrMeasUtNm;
        this.aproOfcCd = aproOfcCd;
        this.agmtOfcCd = agmtOfcCd;
        this.pagerows = pagerows;
        this.vndrNm = vndrNm;
        this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
        this.costCd = costCd;
        this.sorting = sorting;
        this.eqDmgTpCd = eqDmgTpCd;
        this.rprOffhFlg = rprOffhFlg;
        this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
        this.rprRqstSeq = rprRqstSeq;
        this.updUsrId = updUsrId;
        this.mnrEdiNm = mnrEdiNm;
        this.agmtRefNo = agmtRefNo;
        this.rprStsCd = rprStsCd;
        this.dispNo = dispNo;
        this.agmtSeq = agmtSeq;
        this.agmtNo = agmtNo;
        this.mnrRprRmk = mnrRprRmk;
        this.ediId = ediId;
        this.aproDt = aproDt;
        this.trsmModCd = trsmModCd;
        this.eqTpszCd = eqTpszCd;
        this.dmgFlag = dmgFlag;
        this.dispFlg = dispFlg;
        this.creUsrId = creUsrId;
        this.trfNo = trfNo;
        this.agmtOfcCtyCd = agmtOfcCtyCd;
        this.vndrSeq = vndrSeq;
        this.autoAmt = autoAmt;
        this.fileSeq = fileSeq;
        this.agmtVerNo = agmtVerNo;
        this.rprRsltDt = rprRsltDt;
        this.ifTrcSeq = ifTrcSeq;
        this.recentRprTpCd = recentRprTpCd;
        this.mnrVrfyTpCd = mnrVrfyTpCd;
        this.rqstUsrId = rqstUsrId;
        this.currCd = currCd;
        this.rprRqstVerNo = rprRqstVerNo;
        this.rqstRefNo = rqstRefNo;
        this.mnrInpTpCd = mnrInpTpCd;
        this.eqDmgDt = eqDmgDt;
        this.creDt = creDt;
        this.immExt = immExt;
        this.rprWrkTpCd = rprWrkTpCd;
        this.totalAmt = totalAmt;
        this.totalUsdAmt = totalUsdAmt;
        this.upprOfcCd = upprOfcCd;
        this.ibflag = ibflag;
        this.rprRqstTmpSeq = rprRqstTmpSeq;
        this.rqstEqNo = rqstEqNo;
        this.rprDtlStsCd = rprDtlStsCd;
        this.rprYdCd = rprYdCd;
        this.appovalAmt = appovalAmt;
        this.rprRqstLstVerFlg = rprRqstLstVerFlg;
        this.updDt = updDt;
        this.n3ptyFlg = n3ptyFlg;
        this.rqstDt = rqstDt;
        this.costOfcCd = costOfcCd;
        this.rqstUsrNm = rqstUsrNm;
        this.dispDtlSeq = dispDtlSeq;
        this.eqKndCd = eqKndCd;
        this.aproUsrId = aproUsrId;
        this.mnrOrdSeq = mnrOrdSeq;
        this.mnrMeasUtCd = mnrMeasUtCd;
        this.dupChk = dupChk;
        this.reqStDt = reqStDt;
        this.reqEndDt = reqEndDt;
        this.dpRqstDt = dpRqstDt;
        this.soldEq = soldEq;
        this.rctRprFlg = rctRprFlg;
        this.vrfyRsltRmk = vrfyRsltRmk;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("mnr_meas_ut_nm", getMnrMeasUtNm());
        this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
        this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
        this.hashColumns.put("cost_cd", getCostCd());
        this.hashColumns.put("sorting", getSorting());
        this.hashColumns.put("eq_dmg_tp_cd", getEqDmgTpCd());
        this.hashColumns.put("rpr_offh_flg", getRprOffhFlg());
        this.hashColumns.put("n3pty_bil_ttl_amt", getN3ptyBilTtlAmt());
        this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("mnr_edi_nm", getMnrEdiNm());
        this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
        this.hashColumns.put("rpr_sts_cd", getRprStsCd());
        this.hashColumns.put("disp_no", getDispNo());
        this.hashColumns.put("agmt_seq", getAgmtSeq());
        this.hashColumns.put("agmt_no", getAgmtNo());
        this.hashColumns.put("mnr_rpr_rmk", getMnrRprRmk());
        this.hashColumns.put("edi_id", getEdiId());
        this.hashColumns.put("apro_dt", getAproDt());
        this.hashColumns.put("trsm_mod_cd", getTrsmModCd());
        this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
        this.hashColumns.put("dmg_flag", getDmgFlag());
        this.hashColumns.put("disp_flg", getDispFlg());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("trf_no", getTrfNo());
        this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("auto_amt", getAutoAmt());
        this.hashColumns.put("file_seq", getFileSeq());
        this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
        this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
        this.hashColumns.put("if_trc_seq", getIfTrcSeq());
        this.hashColumns.put("recent_rpr_tp_cd", getRecentRprTpCd());
        this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
        this.hashColumns.put("rqst_usr_id", getRqstUsrId());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
        this.hashColumns.put("rqst_ref_no", getRqstRefNo());
        this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
        this.hashColumns.put("eq_dmg_dt", getEqDmgDt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("imm_ext", getImmExt());
        this.hashColumns.put("rpr_wrk_tp_cd", getRprWrkTpCd());
        this.hashColumns.put("total_amt", getTotalAmt());
        this.hashColumns.put("total_usd_amt", getTotalUsdAmt());
        this.hashColumns.put("uppr_ofc_cd", getUpprOfcCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rpr_rqst_tmp_seq", getRprRqstTmpSeq());
        this.hashColumns.put("rqst_eq_no", getRqstEqNo());
        this.hashColumns.put("rpr_dtl_sts_cd", getRprDtlStsCd());
        this.hashColumns.put("rpr_yd_cd", getRprYdCd());
        this.hashColumns.put("appoval_amt", getAppovalAmt());
        this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("n3pty_flg", getN3ptyFlg());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
        this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
        this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
        this.hashColumns.put("eq_knd_cd", getEqKndCd());
        this.hashColumns.put("apro_usr_id", getAproUsrId());
        this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
        this.hashColumns.put("mnr_meas_ut_cd", getMnrMeasUtCd());
        this.hashColumns.put("dup_chk", getDupChk());
        this.hashColumns.put("req_st_dt", getReqStDt());
        this.hashColumns.put("req_end_dt", getReqEndDt());
        this.hashColumns.put("dp_rqst_dt", getDpRqstDt());
        this.hashColumns.put("sold_eq", getSoldEq());
        this.hashColumns.put("rct_rpr_flg", getRctRprFlg());
        this.hashColumns.put("vrfy_rslt_rmk", getVrfyRsltRmk());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("mnr_meas_ut_nm", "mnrMeasUtNm");
        this.hashFields.put("apro_ofc_cd", "aproOfcCd");
        this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
        this.hashFields.put("cost_cd", "costCd");
        this.hashFields.put("sorting", "sorting");
        this.hashFields.put("eq_dmg_tp_cd", "eqDmgTpCd");
        this.hashFields.put("rpr_offh_flg", "rprOffhFlg");
        this.hashFields.put("n3pty_bil_ttl_amt", "n3ptyBilTtlAmt");
        this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("mnr_edi_nm", "mnrEdiNm");
        this.hashFields.put("agmt_ref_no", "agmtRefNo");
        this.hashFields.put("rpr_sts_cd", "rprStsCd");
        this.hashFields.put("disp_no", "dispNo");
        this.hashFields.put("agmt_seq", "agmtSeq");
        this.hashFields.put("agmt_no", "agmtNo");
        this.hashFields.put("mnr_rpr_rmk", "mnrRprRmk");
        this.hashFields.put("edi_id", "ediId");
        this.hashFields.put("apro_dt", "aproDt");
        this.hashFields.put("trsm_mod_cd", "trsmModCd");
        this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
        this.hashFields.put("dmg_flag", "dmgFlag");
        this.hashFields.put("disp_flg", "dispFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("trf_no", "trfNo");
        this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("auto_amt", "autoAmt");
        this.hashFields.put("file_seq", "fileSeq");
        this.hashFields.put("agmt_ver_no", "agmtVerNo");
        this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
        this.hashFields.put("if_trc_seq", "ifTrcSeq");
        this.hashFields.put("recent_rpr_tp_cd", "recentRprTpCd");
        this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
        this.hashFields.put("rqst_usr_id", "rqstUsrId");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
        this.hashFields.put("rqst_ref_no", "rqstRefNo");
        this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
        this.hashFields.put("eq_dmg_dt", "eqDmgDt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("imm_ext", "immExt");
        this.hashFields.put("rpr_wrk_tp_cd", "rprWrkTpCd");
        this.hashFields.put("total_amt", "totalAmt");
        this.hashFields.put("total_usd_amt", "totalUsdAmt");
        this.hashFields.put("uppr_ofc_cd", "upprOfcCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rpr_rqst_tmp_seq", "rprRqstTmpSeq");
        this.hashFields.put("rqst_eq_no", "rqstEqNo");
        this.hashFields.put("rpr_dtl_sts_cd", "rprDtlStsCd");
        this.hashFields.put("rpr_yd_cd", "rprYdCd");
        this.hashFields.put("appoval_amt", "appovalAmt");
        this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("n3pty_flg", "n3ptyFlg");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("cost_ofc_cd", "costOfcCd");
        this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
        this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
        this.hashFields.put("eq_knd_cd", "eqKndCd");
        this.hashFields.put("apro_usr_id", "aproUsrId");
        this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
        this.hashFields.put("mnr_meas_ut_cd", "mnrMeasUtCd");
        this.hashFields.put("dup_chk", "dupChk");
        this.hashFields.put("req_st_dt", "reqStDt");
        this.hashFields.put("req_end_dt", "reqEndDt");
        this.hashFields.put("dp_rqst_dt", "dpRqstDt");
        this.hashFields.put("sold_eq", "soldEq");
        this.hashFields.put("rct_rpr_flg", "rctRprFlg");
        this.hashFields.put("vrfy_rslt_rmk", "vrfyRsltRmk");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return mnrMeasUtNm
	 */
    public String getMnrMeasUtNm() {
        return this.mnrMeasUtNm;
    }

    /**
	 * Column Info
	 * @return aproOfcCd
	 */
    public String getAproOfcCd() {
        return this.aproOfcCd;
    }

    /**
	 * Column Info
	 * @return agmtOfcCd
	 */
    public String getAgmtOfcCd() {
        return this.agmtOfcCd;
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
	 * @return vndrNm
	 */
    public String getVndrNm() {
        return this.vndrNm;
    }

    /**
	 * Column Info
	 * @return mnrOrdOfcCtyCd
	 */
    public String getMnrOrdOfcCtyCd() {
        return this.mnrOrdOfcCtyCd;
    }

    /**
	 * Column Info
	 * @return costCd
	 */
    public String getCostCd() {
        return this.costCd;
    }

    /**
	 * Column Info
	 * @return sorting
	 */
    public String getSorting() {
        return this.sorting;
    }

    /**
	 * Column Info
	 * @return eqDmgTpCd
	 */
    public String getEqDmgTpCd() {
        return this.eqDmgTpCd;
    }

    /**
	 * Column Info
	 * @return rprOffhFlg
	 */
    public String getRprOffhFlg() {
        return this.rprOffhFlg;
    }

    /**
	 * Column Info
	 * @return n3ptyBilTtlAmt
	 */
    public String getN3ptyBilTtlAmt() {
        return this.n3ptyBilTtlAmt;
    }

    /**
	 * Column Info
	 * @return rprRqstSeq
	 */
    public String getRprRqstSeq() {
        return this.rprRqstSeq;
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
	 * @return mnrEdiNm
	 */
    public String getMnrEdiNm() {
        return this.mnrEdiNm;
    }

    /**
	 * Column Info
	 * @return agmtRefNo
	 */
    public String getAgmtRefNo() {
        return this.agmtRefNo;
    }

    /**
	 * Column Info
	 * @return rprStsCd
	 */
    public String getRprStsCd() {
        return this.rprStsCd;
    }

    /**
	 * Column Info
	 * @return dispNo
	 */
    public String getDispNo() {
        return this.dispNo;
    }

    /**
	 * Column Info
	 * @return agmtSeq
	 */
    public String getAgmtSeq() {
        return this.agmtSeq;
    }

    /**
	 * Column Info
	 * @return agmtNo
	 */
    public String getAgmtNo() {
        return this.agmtNo;
    }

    /**
	 * Column Info
	 * @return mnrRprRmk
	 */
    public String getMnrRprRmk() {
        return this.mnrRprRmk;
    }

    /**
	 * Column Info
	 * @return ediId
	 */
    public String getEdiId() {
        return this.ediId;
    }

    /**
	 * Column Info
	 * @return aproDt
	 */
    public String getAproDt() {
        return this.aproDt;
    }

    /**
	 * Column Info
	 * @return trsmModCd
	 */
    public String getTrsmModCd() {
        return this.trsmModCd;
    }

    /**
	 * Column Info
	 * @return eqTpszCd
	 */
    public String getEqTpszCd() {
        return this.eqTpszCd;
    }

    /**
	 * Column Info
	 * @return dmgFlag
	 */
    public String getDmgFlag() {
        return this.dmgFlag;
    }

    /**
	 * Column Info
	 * @return dispFlg
	 */
    public String getDispFlg() {
        return this.dispFlg;
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
	 * @return trfNo
	 */
    public String getTrfNo() {
        return this.trfNo;
    }

    /**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
    public String getAgmtOfcCtyCd() {
        return this.agmtOfcCtyCd;
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
	 * @return autoAmt
	 */
    public String getAutoAmt() {
        return this.autoAmt;
    }

    /**
	 * Column Info
	 * @return fileSeq
	 */
    public String getFileSeq() {
        return this.fileSeq;
    }

    /**
	 * Column Info
	 * @return agmtVerNo
	 */
    public String getAgmtVerNo() {
        return this.agmtVerNo;
    }

    /**
	 * Column Info
	 * @return rprRsltDt
	 */
    public String getRprRsltDt() {
        return this.rprRsltDt;
    }

    /**
	 * Column Info
	 * @return ifTrcSeq
	 */
    public String getIfTrcSeq() {
        return this.ifTrcSeq;
    }

    /**
	 * Column Info
	 * @return recentRprTpCd
	 */
    public String getRecentRprTpCd() {
        return this.recentRprTpCd;
    }

    /**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
    public String getMnrVrfyTpCd() {
        return this.mnrVrfyTpCd;
    }

    /**
	 * Column Info
	 * @return rqstUsrId
	 */
    public String getRqstUsrId() {
        return this.rqstUsrId;
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
	 * @return rprRqstVerNo
	 */
    public String getRprRqstVerNo() {
        return this.rprRqstVerNo;
    }

    /**
	 * Column Info
	 * @return rqstRefNo
	 */
    public String getRqstRefNo() {
        return this.rqstRefNo;
    }

    /**
	 * Column Info
	 * @return mnrInpTpCd
	 */
    public String getMnrInpTpCd() {
        return this.mnrInpTpCd;
    }

    /**
	 * Column Info
	 * @return eqDmgDt
	 */
    public String getEqDmgDt() {
        return this.eqDmgDt;
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
	 * @return immExt
	 */
    public String getImmExt() {
        return this.immExt;
    }

    /**
	 * Column Info
	 * @return rprWrkTpCd
	 */
    public String getRprWrkTpCd() {
        return this.rprWrkTpCd;
    }

    /**
	 * Column Info
	 * @return totalAmt
	 */
    public String getTotalAmt() {
        return this.totalAmt;
    }

    /**
	 * Column Info
	 * @return totalUsdAmt
	 */
    public String getTotalUsdAmt() {
        return this.totalUsdAmt;
    }

    /**
	 * Column Info
	 * @return upprOfcCd
	 */
    public String getUpprOfcCd() {
        return this.upprOfcCd;
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
	 * @return rprRqstTmpSeq
	 */
    public String getRprRqstTmpSeq() {
        return this.rprRqstTmpSeq;
    }

    /**
	 * Column Info
	 * @return rqstEqNo
	 */
    public String getRqstEqNo() {
        return this.rqstEqNo;
    }

    /**
	 * Column Info
	 * @return rprDtlStsCd
	 */
    public String getRprDtlStsCd() {
        return this.rprDtlStsCd;
    }

    /**
	 * Column Info
	 * @return rprYdCd
	 */
    public String getRprYdCd() {
        return this.rprYdCd;
    }

    /**
	 * Column Info
	 * @return appovalAmt
	 */
    public String getAppovalAmt() {
        return this.appovalAmt;
    }

    /**
	 * Column Info
	 * @return rprRqstLstVerFlg
	 */
    public String getRprRqstLstVerFlg() {
        return this.rprRqstLstVerFlg;
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
	 * @return n3ptyFlg
	 */
    public String getN3ptyFlg() {
        return this.n3ptyFlg;
    }

    /**
	 * Column Info
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
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
	 * @return rqstUsrNm
	 */
    public String getRqstUsrNm() {
        return this.rqstUsrNm;
    }

    /**
	 * Column Info
	 * @return dispDtlSeq
	 */
    public String getDispDtlSeq() {
        return this.dispDtlSeq;
    }

    /**
	 * Column Info
	 * @return eqKndCd
	 */
    public String getEqKndCd() {
        return this.eqKndCd;
    }

    /**
	 * Column Info
	 * @return aproUsrId
	 */
    public String getAproUsrId() {
        return this.aproUsrId;
    }

    /**
	 * Column Info
	 * @return mnrOrdSeq
	 */
    public String getMnrOrdSeq() {
        return this.mnrOrdSeq;
    }

    /**
	 * Column Info
	 * @return mnrMeasUtCd
	 */
    public String getMnrMeasUtCd() {
        return this.mnrMeasUtCd;
    }

    /**
	 * Column Info
	 * @return reqStDt
	 */
    public String getReqStDt() {
        return this.reqStDt;
    }

    /**
	 * Column Info
	 * @return reqEndDt
	 */
    public String getReqEndDt() {
        return this.reqEndDt;
    }

    /**
	 * Column Info
	 * @return dpRqstDt
	 */
    public String getDpRqstDt() {
        return this.dpRqstDt;
    }

    /**
	 * Column Info
	 * @return soldEq
	 */
    public String getSoldEq() {
        return this.soldEq;
    }

    /**
	 * Column Info
	 * @param mnrMeasUtNm
	 */
    public void setMnrMeasUtNm(String mnrMeasUtNm) {
        this.mnrMeasUtNm = mnrMeasUtNm;
    }

    /**
	 * Column Info
	 * @param aproOfcCd
	 */
    public void setAproOfcCd(String aproOfcCd) {
        this.aproOfcCd = aproOfcCd;
    }

    /**
	 * Column Info
	 * @param agmtOfcCd
	 */
    public void setAgmtOfcCd(String agmtOfcCd) {
        this.agmtOfcCd = agmtOfcCd;
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
	 * @param vndrNm
	 */
    public void setVndrNm(String vndrNm) {
        this.vndrNm = vndrNm;
    }

    /**
	 * Column Info
	 * @param mnrOrdOfcCtyCd
	 */
    public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
        this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
    }

    /**
	 * Column Info
	 * @param costCd
	 */
    public void setCostCd(String costCd) {
        this.costCd = costCd;
    }

    /**
	 * Column Info
	 * @param sorting
	 */
    public void setSorting(String sorting) {
        this.sorting = sorting;
    }

    /**
	 * Column Info
	 * @param eqDmgTpCd
	 */
    public void setEqDmgTpCd(String eqDmgTpCd) {
        this.eqDmgTpCd = eqDmgTpCd;
    }

    /**
	 * Column Info
	 * @param rprOffhFlg
	 */
    public void setRprOffhFlg(String rprOffhFlg) {
        this.rprOffhFlg = rprOffhFlg;
    }

    /**
	 * Column Info
	 * @param n3ptyBilTtlAmt
	 */
    public void setN3ptyBilTtlAmt(String n3ptyBilTtlAmt) {
        this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
    }

    /**
	 * Column Info
	 * @param rprRqstSeq
	 */
    public void setRprRqstSeq(String rprRqstSeq) {
        this.rprRqstSeq = rprRqstSeq;
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
	 * @param mnrEdiNm
	 */
    public void setMnrEdiNm(String mnrEdiNm) {
        this.mnrEdiNm = mnrEdiNm;
    }

    /**
	 * Column Info
	 * @param agmtRefNo
	 */
    public void setAgmtRefNo(String agmtRefNo) {
        this.agmtRefNo = agmtRefNo;
    }

    /**
	 * Column Info
	 * @param rprStsCd
	 */
    public void setRprStsCd(String rprStsCd) {
        this.rprStsCd = rprStsCd;
    }

    /**
	 * Column Info
	 * @param dispNo
	 */
    public void setDispNo(String dispNo) {
        this.dispNo = dispNo;
    }

    /**
	 * Column Info
	 * @param agmtSeq
	 */
    public void setAgmtSeq(String agmtSeq) {
        this.agmtSeq = agmtSeq;
    }

    /**
	 * Column Info
	 * @param agmtNo
	 */
    public void setAgmtNo(String agmtNo) {
        this.agmtNo = agmtNo;
    }

    /**
	 * Column Info
	 * @param mnrRprRmk
	 */
    public void setMnrRprRmk(String mnrRprRmk) {
        this.mnrRprRmk = mnrRprRmk;
    }

    /**
	 * Column Info
	 * @param ediId
	 */
    public void setEdiId(String ediId) {
        this.ediId = ediId;
    }

    /**
	 * Column Info
	 * @param aproDt
	 */
    public void setAproDt(String aproDt) {
        this.aproDt = aproDt;
    }

    /**
	 * Column Info
	 * @param trsmModCd
	 */
    public void setTrsmModCd(String trsmModCd) {
        this.trsmModCd = trsmModCd;
    }

    /**
	 * Column Info
	 * @param eqTpszCd
	 */
    public void setEqTpszCd(String eqTpszCd) {
        this.eqTpszCd = eqTpszCd;
    }

    /**
	 * Column Info
	 * @param dmgFlag
	 */
    public void setDmgFlag(String dmgFlag) {
        this.dmgFlag = dmgFlag;
    }

    /**
	 * Column Info
	 * @param dispFlg
	 */
    public void setDispFlg(String dispFlg) {
        this.dispFlg = dispFlg;
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
	 * @param trfNo
	 */
    public void setTrfNo(String trfNo) {
        this.trfNo = trfNo;
    }

    /**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
    public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
        this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param autoAmt
	 */
    public void setAutoAmt(String autoAmt) {
        this.autoAmt = autoAmt;
    }

    /**
	 * Column Info
	 * @param fileSeq
	 */
    public void setFileSeq(String fileSeq) {
        this.fileSeq = fileSeq;
    }

    /**
	 * Column Info
	 * @param agmtVerNo
	 */
    public void setAgmtVerNo(String agmtVerNo) {
        this.agmtVerNo = agmtVerNo;
    }

    /**
	 * Column Info
	 * @param rprRsltDt
	 */
    public void setRprRsltDt(String rprRsltDt) {
        this.rprRsltDt = rprRsltDt;
    }

    /**
	 * Column Info
	 * @param ifTrcSeq
	 */
    public void setIfTrcSeq(String ifTrcSeq) {
        this.ifTrcSeq = ifTrcSeq;
    }

    /**
	 * Column Info
	 * @param recentRprTpCd
	 */
    public void setRecentRprTpCd(String recentRprTpCd) {
        this.recentRprTpCd = recentRprTpCd;
    }

    /**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
    public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
        this.mnrVrfyTpCd = mnrVrfyTpCd;
    }

    /**
	 * Column Info
	 * @param rqstUsrId
	 */
    public void setRqstUsrId(String rqstUsrId) {
        this.rqstUsrId = rqstUsrId;
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
	 * @param rprRqstVerNo
	 */
    public void setRprRqstVerNo(String rprRqstVerNo) {
        this.rprRqstVerNo = rprRqstVerNo;
    }

    /**
	 * Column Info
	 * @param rqstRefNo
	 */
    public void setRqstRefNo(String rqstRefNo) {
        this.rqstRefNo = rqstRefNo;
    }

    /**
	 * Column Info
	 * @param mnrInpTpCd
	 */
    public void setMnrInpTpCd(String mnrInpTpCd) {
        this.mnrInpTpCd = mnrInpTpCd;
    }

    /**
	 * Column Info
	 * @param eqDmgDt
	 */
    public void setEqDmgDt(String eqDmgDt) {
        this.eqDmgDt = eqDmgDt;
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
	 * @param immExt
	 */
    public void setImmExt(String immExt) {
        this.immExt = immExt;
    }

    /**
	 * Column Info
	 * @param rprWrkTpCd
	 */
    public void setRprWrkTpCd(String rprWrkTpCd) {
        this.rprWrkTpCd = rprWrkTpCd;
    }

    /**
	 * Column Info
	 * @param totalAmt
	 */
    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    /**
	 * Column Info
	 * @param totalUsdAmt
	 */
    public void setTotalUsdAmt(String totalUsdAmt) {
        this.totalUsdAmt = totalUsdAmt;
    }

    /**
	 * Column Info
	 * @param upprOfcCd
	 */
    public void setUpprOfcCd(String upprOfcCd) {
        this.upprOfcCd = upprOfcCd;
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
	 * @param rprRqstTmpSeq
	 */
    public void setRprRqstTmpSeq(String rprRqstTmpSeq) {
        this.rprRqstTmpSeq = rprRqstTmpSeq;
    }

    /**
	 * Column Info
	 * @param rqstEqNo
	 */
    public void setRqstEqNo(String rqstEqNo) {
        this.rqstEqNo = rqstEqNo;
    }

    /**
	 * Column Info
	 * @param rprDtlStsCd
	 */
    public void setRprDtlStsCd(String rprDtlStsCd) {
        this.rprDtlStsCd = rprDtlStsCd;
    }

    /**
	 * Column Info
	 * @param rprYdCd
	 */
    public void setRprYdCd(String rprYdCd) {
        this.rprYdCd = rprYdCd;
    }

    /**
	 * Column Info
	 * @param appovalAmt
	 */
    public void setAppovalAmt(String appovalAmt) {
        this.appovalAmt = appovalAmt;
    }

    /**
	 * Column Info
	 * @param rprRqstLstVerFlg
	 */
    public void setRprRqstLstVerFlg(String rprRqstLstVerFlg) {
        this.rprRqstLstVerFlg = rprRqstLstVerFlg;
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
	 * @param n3ptyFlg
	 */
    public void setN3ptyFlg(String n3ptyFlg) {
        this.n3ptyFlg = n3ptyFlg;
    }

    /**
	 * Column Info
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
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
	 * @param rqstUsrNm
	 */
    public void setRqstUsrNm(String rqstUsrNm) {
        this.rqstUsrNm = rqstUsrNm;
    }

    /**
	 * Column Info
	 * @param dispDtlSeq
	 */
    public void setDispDtlSeq(String dispDtlSeq) {
        this.dispDtlSeq = dispDtlSeq;
    }

    /**
	 * Column Info
	 * @param eqKndCd
	 */
    public void setEqKndCd(String eqKndCd) {
        this.eqKndCd = eqKndCd;
    }

    /**
	 * Column Info
	 * @param aproUsrId
	 */
    public void setAproUsrId(String aproUsrId) {
        this.aproUsrId = aproUsrId;
    }

    /**
	 * Column Info
	 * @param mnrOrdSeq
	 */
    public void setMnrOrdSeq(String mnrOrdSeq) {
        this.mnrOrdSeq = mnrOrdSeq;
    }

    /**
	 * Column Info
	 * @param mnrMeasUtCd
	 */
    public void setMnrMeasUtCd(String mnrMeasUtCd) {
        this.mnrMeasUtCd = mnrMeasUtCd;
    }

    /**
	 * Column Info
	 * @param reqStDt
	 */
    public void setReqStDt(String reqStDt) {
        this.reqStDt = reqStDt;
    }

    /**
	 * Column Info
	 * @param reqEndDt
	 */
    public void setReqEndDt(String reqEndDt) {
        this.reqEndDt = reqEndDt;
    }

    /**
	 * Column Info
	 * @param dpRqstDt
	 */
    public void setDpRqstDt(String dpRqstDt) {
        this.dpRqstDt = dpRqstDt;
    }

    /**
	 * Column Info
	 * @param soldEq
	 */
    public void setSoldEq(String soldEq) {
        this.soldEq = soldEq;
    }

    public void setRctRprFlg(String rctRprFlg) {
        this.rctRprFlg = rctRprFlg;
    }

    public String getRctRprFlg() {
        return this.rctRprFlg;
    }

    public void setVrfyRsltRmk(String vrfyRsltRmk) {
        this.vrfyRsltRmk = vrfyRsltRmk;
    }

    public String getVrfyRsltRmk() {
        return this.vrfyRsltRmk;
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
        setMnrMeasUtNm(JSPUtil.getParameter(request, prefix + "mnr_meas_ut_nm", ""));
        setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
        setAgmtOfcCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
        setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
        setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
        setSorting(JSPUtil.getParameter(request, prefix + "sorting", ""));
        setEqDmgTpCd(JSPUtil.getParameter(request, prefix + "eq_dmg_tp_cd", ""));
        setRprOffhFlg(JSPUtil.getParameter(request, prefix + "rpr_offh_flg", ""));
        setN3ptyBilTtlAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_ttl_amt", ""));
        setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setMnrEdiNm(JSPUtil.getParameter(request, prefix + "mnr_edi_nm", ""));
        setAgmtRefNo(JSPUtil.getParameter(request, prefix + "agmt_ref_no", ""));
        setRprStsCd(JSPUtil.getParameter(request, prefix + "rpr_sts_cd", ""));
        setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
        setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
        setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
        setMnrRprRmk(JSPUtil.getParameter(request, prefix + "mnr_rpr_rmk", ""));
        setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
        setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
        setTrsmModCd(JSPUtil.getParameter(request, prefix + "trsm_mod_cd", ""));
        setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
        setDmgFlag(JSPUtil.getParameter(request, prefix + "dmg_flag", ""));
        setDispFlg(JSPUtil.getParameter(request, prefix + "disp_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
        setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setAutoAmt(JSPUtil.getParameter(request, prefix + "auto_amt", ""));
        setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
        setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
        setRprRsltDt(JSPUtil.getParameter(request, prefix + "rpr_rslt_dt", ""));
        setIfTrcSeq(JSPUtil.getParameter(request, prefix + "if_trc_seq", ""));
        setRecentRprTpCd(JSPUtil.getParameter(request, prefix + "recent_rpr_tp_cd", ""));
        setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
        setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
        setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
        setMnrInpTpCd(JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", ""));
        setEqDmgDt(JSPUtil.getParameter(request, prefix + "eq_dmg_dt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setImmExt(JSPUtil.getParameter(request, prefix + "imm_ext", ""));
        setRprWrkTpCd(JSPUtil.getParameter(request, prefix + "rpr_wrk_tp_cd", ""));
        setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
        setTotalUsdAmt(JSPUtil.getParameter(request, prefix + "total_usd_amt", ""));
        setUpprOfcCd(JSPUtil.getParameter(request, prefix + "uppr_ofc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRprRqstTmpSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_tmp_seq", ""));
        setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
        setRprDtlStsCd(JSPUtil.getParameter(request, prefix + "rpr_dtl_sts_cd", ""));
        setRprYdCd(JSPUtil.getParameter(request, prefix + "rpr_yd_cd", ""));
        setAppovalAmt(JSPUtil.getParameter(request, prefix + "appoval_amt", ""));
        setRprRqstLstVerFlg(JSPUtil.getParameter(request, prefix + "rpr_rqst_lst_ver_flg", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
        setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
        setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
        setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
        setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
        setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
        setMnrMeasUtCd(JSPUtil.getParameter(request, prefix + "mnr_meas_ut_cd", ""));
        setDupChk(JSPUtil.getParameter(request, prefix + "dup_chk", ""));
        setReqStDt(JSPUtil.getParameter(request, prefix + "req_st_dt", ""));
        setReqEndDt(JSPUtil.getParameter(request, prefix + "req_end_dt", ""));
        setDpRqstDt(JSPUtil.getParameter(request, prefix + "dp_rqst_dt", ""));
        setSoldEq(JSPUtil.getParameter(request, prefix + "sold_eq", ""));
        setRctRprFlg(JSPUtil.getParameter(request, prefix + "rct_rpr_flg", ""));
        setVrfyRsltRmk(JSPUtil.getParameter(request, prefix + "vrfy_rslt_rmk", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprRqstHdrVO[]
	 */
    public CustomMnrRprRqstHdrVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprRqstHdrVO[]
	 */
    public CustomMnrRprRqstHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CustomMnrRprRqstHdrVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] mnrMeasUtNm = (JSPUtil.getParameter(request, prefix + "mnr_meas_ut_nm", length));
            String[] aproOfcCd = (JSPUtil.getParameter(request, prefix + "apro_ofc_cd", length));
            String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix + "agmt_ofc_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
            String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", length));
            String[] costCd = (JSPUtil.getParameter(request, prefix + "cost_cd", length));
            String[] sorting = (JSPUtil.getParameter(request, prefix + "sorting", length));
            String[] eqDmgTpCd = (JSPUtil.getParameter(request, prefix + "eq_dmg_tp_cd", length));
            String[] rprOffhFlg = (JSPUtil.getParameter(request, prefix + "rpr_offh_flg", length));
            String[] n3ptyBilTtlAmt = (JSPUtil.getParameter(request, prefix + "n3pty_bil_ttl_amt", length));
            String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] mnrEdiNm = (JSPUtil.getParameter(request, prefix + "mnr_edi_nm", length));
            String[] agmtRefNo = (JSPUtil.getParameter(request, prefix + "agmt_ref_no", length));
            String[] rprStsCd = (JSPUtil.getParameter(request, prefix + "rpr_sts_cd", length));
            String[] dispNo = (JSPUtil.getParameter(request, prefix + "disp_no", length));
            String[] agmtSeq = (JSPUtil.getParameter(request, prefix + "agmt_seq", length));
            String[] agmtNo = (JSPUtil.getParameter(request, prefix + "agmt_no", length));
            String[] mnrRprRmk = (JSPUtil.getParameter(request, prefix + "mnr_rpr_rmk", length));
            String[] ediId = (JSPUtil.getParameter(request, prefix + "edi_id", length));
            String[] aproDt = (JSPUtil.getParameter(request, prefix + "apro_dt", length));
            String[] trsmModCd = (JSPUtil.getParameter(request, prefix + "trsm_mod_cd", length));
            String[] eqTpszCd = (JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", length));
            String[] dmgFlag = (JSPUtil.getParameter(request, prefix + "dmg_flag", length));
            String[] dispFlg = (JSPUtil.getParameter(request, prefix + "disp_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] trfNo = (JSPUtil.getParameter(request, prefix + "trf_no", length));
            String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] autoAmt = (JSPUtil.getParameter(request, prefix + "auto_amt", length));
            String[] fileSeq = (JSPUtil.getParameter(request, prefix + "file_seq", length));
            String[] agmtVerNo = (JSPUtil.getParameter(request, prefix + "agmt_ver_no", length));
            String[] rprRsltDt = (JSPUtil.getParameter(request, prefix + "rpr_rslt_dt", length));
            String[] ifTrcSeq = (JSPUtil.getParameter(request, prefix + "if_trc_seq", length));
            String[] recentRprTpCd = (JSPUtil.getParameter(request, prefix + "recent_rpr_tp_cd", length));
            String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", length));
            String[] rqstUsrId = (JSPUtil.getParameter(request, prefix + "rqst_usr_id", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", length));
            String[] rqstRefNo = (JSPUtil.getParameter(request, prefix + "rqst_ref_no", length));
            String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix + "mnr_inp_tp_cd", length));
            String[] eqDmgDt = (JSPUtil.getParameter(request, prefix + "eq_dmg_dt", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] immExt = (JSPUtil.getParameter(request, prefix + "imm_ext", length));
            String[] rprWrkTpCd = (JSPUtil.getParameter(request, prefix + "rpr_wrk_tp_cd", length));
            String[] totalAmt = (JSPUtil.getParameter(request, prefix + "total_amt", length));
            String[] totalUsdAmt = (JSPUtil.getParameter(request, prefix + "total_usd_amt", length));
            String[] upprOfcCd = (JSPUtil.getParameter(request, prefix + "uppr_ofc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rprRqstTmpSeq = (JSPUtil.getParameter(request, prefix + "rpr_rqst_tmp_seq", length));
            String[] rqstEqNo = (JSPUtil.getParameter(request, prefix + "rqst_eq_no", length));
            String[] rprDtlStsCd = (JSPUtil.getParameter(request, prefix + "rpr_dtl_sts_cd", length));
            String[] rprYdCd = (JSPUtil.getParameter(request, prefix + "rpr_yd_cd", length));
            String[] appovalAmt = (JSPUtil.getParameter(request, prefix + "appoval_amt", length));
            String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix + "rpr_rqst_lst_ver_flg", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix + "n3pty_flg", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] costOfcCd = (JSPUtil.getParameter(request, prefix + "cost_ofc_cd", length));
            String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix + "rqst_usr_nm", length));
            String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix + "disp_dtl_seq", length));
            String[] eqKndCd = (JSPUtil.getParameter(request, prefix + "eq_knd_cd", length));
            String[] aproUsrId = (JSPUtil.getParameter(request, prefix + "apro_usr_id", length));
            String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix + "mnr_ord_seq", length));
            String[] mnrMeasUtCd = (JSPUtil.getParameter(request, prefix + "mnr_meas_ut_cd", length));
            String[] dupChk = (JSPUtil.getParameter(request, prefix + "dup_chk", length));
            String[] reqStDt = (JSPUtil.getParameter(request, prefix + "req_st_dt", length));
            String[] reqEndDt = (JSPUtil.getParameter(request, prefix + "req_end_dt", length));
            String[] dpRqstDt = (JSPUtil.getParameter(request, prefix + "dp_rqst_dt", length));
            String[] soldEq = (JSPUtil.getParameter(request, prefix + "sold_eq", length));
            String[] rctRprFlg = (JSPUtil.getParameter(request, prefix + "rct_rpr_flg", length));
            String[] vrfyRsltRmk = (JSPUtil.getParameter(request, prefix + "vrfy_rslt_rmk", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CustomMnrRprRqstHdrVO();
                if (mnrMeasUtNm[i] != null)
                    model.setMnrMeasUtNm(mnrMeasUtNm[i]);
                if (aproOfcCd[i] != null)
                    model.setAproOfcCd(aproOfcCd[i]);
                if (agmtOfcCd[i] != null)
                    model.setAgmtOfcCd(agmtOfcCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (mnrOrdOfcCtyCd[i] != null)
                    model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
                if (costCd[i] != null)
                    model.setCostCd(costCd[i]);
                if (sorting[i] != null)
                    model.setSorting(sorting[i]);
                if (eqDmgTpCd[i] != null)
                    model.setEqDmgTpCd(eqDmgTpCd[i]);
                if (rprOffhFlg[i] != null)
                    model.setRprOffhFlg(rprOffhFlg[i]);
                if (n3ptyBilTtlAmt[i] != null)
                    model.setN3ptyBilTtlAmt(n3ptyBilTtlAmt[i]);
                if (rprRqstSeq[i] != null)
                    model.setRprRqstSeq(rprRqstSeq[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (mnrEdiNm[i] != null)
                    model.setMnrEdiNm(mnrEdiNm[i]);
                if (agmtRefNo[i] != null)
                    model.setAgmtRefNo(agmtRefNo[i]);
                if (rprStsCd[i] != null)
                    model.setRprStsCd(rprStsCd[i]);
                if (dispNo[i] != null)
                    model.setDispNo(dispNo[i]);
                if (agmtSeq[i] != null)
                    model.setAgmtSeq(agmtSeq[i]);
                if (agmtNo[i] != null)
                    model.setAgmtNo(agmtNo[i]);
                if (mnrRprRmk[i] != null)
                    model.setMnrRprRmk(mnrRprRmk[i]);
                if (ediId[i] != null)
                    model.setEdiId(ediId[i]);
                if (aproDt[i] != null)
                    model.setAproDt(aproDt[i]);
                if (trsmModCd[i] != null)
                    model.setTrsmModCd(trsmModCd[i]);
                if (eqTpszCd[i] != null)
                    model.setEqTpszCd(eqTpszCd[i]);
                if (dmgFlag[i] != null)
                    model.setDmgFlag(dmgFlag[i]);
                if (dispFlg[i] != null)
                    model.setDispFlg(dispFlg[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (trfNo[i] != null)
                    model.setTrfNo(trfNo[i]);
                if (agmtOfcCtyCd[i] != null)
                    model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (autoAmt[i] != null)
                    model.setAutoAmt(autoAmt[i]);
                if (fileSeq[i] != null)
                    model.setFileSeq(fileSeq[i]);
                if (agmtVerNo[i] != null)
                    model.setAgmtVerNo(agmtVerNo[i]);
                if (rprRsltDt[i] != null)
                    model.setRprRsltDt(rprRsltDt[i]);
                if (ifTrcSeq[i] != null)
                    model.setIfTrcSeq(ifTrcSeq[i]);
                if (recentRprTpCd[i] != null)
                    model.setRecentRprTpCd(recentRprTpCd[i]);
                if (mnrVrfyTpCd[i] != null)
                    model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
                if (rqstUsrId[i] != null)
                    model.setRqstUsrId(rqstUsrId[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (rprRqstVerNo[i] != null)
                    model.setRprRqstVerNo(rprRqstVerNo[i]);
                if (rqstRefNo[i] != null)
                    model.setRqstRefNo(rqstRefNo[i]);
                if (mnrInpTpCd[i] != null)
                    model.setMnrInpTpCd(mnrInpTpCd[i]);
                if (eqDmgDt[i] != null)
                    model.setEqDmgDt(eqDmgDt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (immExt[i] != null)
                    model.setImmExt(immExt[i]);
                if (rprWrkTpCd[i] != null)
                    model.setRprWrkTpCd(rprWrkTpCd[i]);
                if (totalAmt[i] != null)
                    model.setTotalAmt(totalAmt[i]);
                if (totalUsdAmt[i] != null)
                    model.setTotalUsdAmt(totalUsdAmt[i]);
                if (upprOfcCd[i] != null)
                    model.setUpprOfcCd(upprOfcCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rprRqstTmpSeq[i] != null)
                    model.setRprRqstTmpSeq(rprRqstTmpSeq[i]);
                if (rqstEqNo[i] != null)
                    model.setRqstEqNo(rqstEqNo[i]);
                if (rprDtlStsCd[i] != null)
                    model.setRprDtlStsCd(rprDtlStsCd[i]);
                if (rprYdCd[i] != null)
                    model.setRprYdCd(rprYdCd[i]);
                if (appovalAmt[i] != null)
                    model.setAppovalAmt(appovalAmt[i]);
                if (rprRqstLstVerFlg[i] != null)
                    model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (n3ptyFlg[i] != null)
                    model.setN3ptyFlg(n3ptyFlg[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (costOfcCd[i] != null)
                    model.setCostOfcCd(costOfcCd[i]);
                if (rqstUsrNm[i] != null)
                    model.setRqstUsrNm(rqstUsrNm[i]);
                if (dispDtlSeq[i] != null)
                    model.setDispDtlSeq(dispDtlSeq[i]);
                if (eqKndCd[i] != null)
                    model.setEqKndCd(eqKndCd[i]);
                if (aproUsrId[i] != null)
                    model.setAproUsrId(aproUsrId[i]);
                if (mnrOrdSeq[i] != null)
                    model.setMnrOrdSeq(mnrOrdSeq[i]);
                if (mnrMeasUtCd[i] != null)
                    model.setMnrMeasUtCd(mnrMeasUtCd[i]);
                if (dupChk[i] != null)
                    model.setDupChk(dupChk[i]);
                if (reqStDt[i] != null)
                    model.setReqStDt(reqStDt[i]);
                if (reqEndDt[i] != null)
                    model.setReqEndDt(reqEndDt[i]);
                if (dpRqstDt[i] != null)
                    model.setDpRqstDt(dpRqstDt[i]);
                if (soldEq[i] != null)
                    model.setSoldEq(soldEq[i]);
                if (rctRprFlg[i] != null)
                    model.setRctRprFlg(rctRprFlg[i]);
                if (vrfyRsltRmk[i] != null) 
		    		model.setVrfyRsltRmk(vrfyRsltRmk[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCustomMnrRprRqstHdrVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CustomMnrRprRqstHdrVO[]
	 */
    public CustomMnrRprRqstHdrVO[] getCustomMnrRprRqstHdrVOs() {
        CustomMnrRprRqstHdrVO[] vos = (CustomMnrRprRqstHdrVO[]) models.toArray(new CustomMnrRprRqstHdrVO[models.size()]);
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
        this.mnrMeasUtNm = this.mnrMeasUtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproOfcCd = this.aproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtOfcCd = this.agmtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costCd = this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sorting = this.sorting.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqDmgTpCd = this.eqDmgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprOffhFlg = this.rprOffhFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyBilTtlAmt = this.n3ptyBilTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprRqstSeq = this.rprRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrEdiNm = this.mnrEdiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtRefNo = this.agmtRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprStsCd = this.rprStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dispNo = this.dispNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtSeq = this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtNo = this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrRprRmk = this.mnrRprRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediId = this.ediId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproDt = this.aproDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmModCd = this.trsmModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmgFlag = this.dmgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dispFlg = this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trfNo = this.trfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtOfcCtyCd = this.agmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoAmt = this.autoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fileSeq = this.fileSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.agmtVerNo = this.agmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprRsltDt = this.rprRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ifTrcSeq = this.ifTrcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.recentRprTpCd = this.recentRprTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrVrfyTpCd = this.mnrVrfyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrId = this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprRqstVerNo = this.rprRqstVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstRefNo = this.rqstRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrInpTpCd = this.mnrInpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqDmgDt = this.eqDmgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.immExt = this.immExt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprWrkTpCd = this.rprWrkTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalAmt = this.totalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totalUsdAmt = this.totalUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.upprOfcCd = this.upprOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprRqstTmpSeq = this.rprRqstTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstEqNo = this.rqstEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprDtlStsCd = this.rprDtlStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprYdCd = this.rprYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.appovalAmt = this.appovalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rprRqstLstVerFlg = this.rprRqstLstVerFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyFlg = this.n3ptyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costOfcCd = this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrNm = this.rqstUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dispDtlSeq = this.dispDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproUsrId = this.aproUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrOrdSeq = this.mnrOrdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnrMeasUtCd = this.mnrMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dupChk = this.dupChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reqStDt = this.reqStDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reqEndDt = this.reqEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpRqstDt = this.dpRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.soldEq = this.soldEq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rctRprFlg = this.rctRprFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vrfyRsltRmk = this.vrfyRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }

    public String getDupChk() {
        return dupChk;
    }

    public void setDupChk(String dupChk) {
        this.dupChk = dupChk;
    }
}
