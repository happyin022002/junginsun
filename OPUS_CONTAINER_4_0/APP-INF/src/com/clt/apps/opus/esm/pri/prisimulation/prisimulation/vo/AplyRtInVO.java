/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AplyRtInVO.java
*@FileTitle : AplyRtInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class AplyRtInVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AplyRtInVO> models = new ArrayList<AplyRtInVO>();

    /* Column Info */
    private String ldDt = null;

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String fMtyRtnYdChk = null;

    /* Column Info */
    private String por = null;

    /* Column Info */
    private String cgoTpCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String errorMsg = null;

    /* Column Info */
    private String rcvT = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String ctrtNo = null;

    /* Column Info */
    private String fCltOfcCd = null;

    /* Column Info */
    private String depLane = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String unmatchChk = null;

    /* Column Info */
    private String fEndPctlNo = null;

    /* Column Info */
    private String gohCd = null;

    /* Column Info */
    private String fMtyPkupYd = null;

    /* Column Info */
    private String fRv45 = null;

    /* Column Info */
    private String fOutParamNumber = null;

    /* Column Info */
    private String fPctlNo = null;

    /* Column Info */
    private String fMtyRtnYdNode = null;

    /* Column Info */
    private String cmdtSeq = null;

    /* Column Info */
    private String ctrtTp = null;

    /* Column Info */
    private String arvLane = null;

    /* Column Info */
    private String fRv40 = null;

    /* Column Info */
    private String fMtyPkupYdNode = null;

    /* Column Info */
    private String fVoidQty = null;

    /* Column Info */
    private String subTrdCd = null;

    /* Column Info */
    private String cntrSzCd = null;

    /* Column Info */
    private String delT = null;

    /* Column Info */
    private String fCallId = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String fUserId = null;

    /* Column Info */
    private String del = null;

    /* Column Info */
    private String fPpdOfcCd = null;

    /* Column Info */
    private String fCostYrmon = null;

    /* Column Info */
    private String costFlg = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String fMtyRtnYd = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String fRv20 = null;

    /* Column Info */
    private String fCount = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String fGRev = null;

    /* Column Info */
    private String errorCode = null;

    /* Column Info */
    private String eqTpCd = null;

    /* Column Info */
    private String fStartPctlNo = null;

    /* Column Info */
    private String fAgmtSgnOfcCd = null;

    /* Column Info */
    private String fMtyRtnYdCd = null;

    /* Column Info */
    private String fMtyPkupYdCd = null;

    /* Column Info */
    private String pgmNo = null;
    
    /* Column Info */
    private String autoRatFlg = null;
    /* Column Info */
    private String actWgt = null;
    private String wgtUtCd = null;
    private String measQty = null;
    private String measUtCd = null;
    private String usaCstmsFileCd = null;
    private String cndCstmsFileCd = null;
    private String imdgClssCd = null;
    private String inGaFlg = null;
    private String hblKnt = null;
    private String mfSelfKnt = null;
    private String docLocCd = null;
    private String orgTrnsModCd = null;
    private String destTrnsModCd = null;
    private String siCd = null;
    private String fAgnBkgOfcCd = null;
    private String fAgnCtrtOfcCd = null;
    private String fAgnFfCust = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AplyRtInVO() {
    }

    public AplyRtInVO(String ibflag, String pagerows, String ldDt, String svcScpCd, String cntrSzCd, String por, String cgoTpCd, String gohCd, String trdCd, String rcvT, String custSeq, String delT, String pctlNo, String socFlg, String ctrtNo, String depLane, String slanCd, String cmdtCd, String ctrtTp, String del, String arvLane, String eqTpCd, String custCntCd, String subTrdCd, String cmdtSeq, String unmatchChk, String errorCode, String errorMsg, String fPctlNo, String fMtyPkupYd, String fMtyRtnYd, String fMtyRtnYdCd, String fMtyRtnYdNode, String fCallId, String fOutParamNumber, String fStartPctlNo, String fEndPctlNo, String fUserId, String fGRev, String fAgmtSgnOfcCd, String fPpdOfcCd, String fCltOfcCd, String fCostYrmon, String fVoidQty, String fMtyRtnYdChk, String fMtyPkupYdCd, String fMtyPkupYdNode, String fRv20, String fRv40, String fRv45, String fCount, String costFlg, String pgmNo, String autoRatFlg, String actWgt, String wgtUtCd, String measQty, String measUtCd, String usaCstmsFileCd, String cndCstmsFileCd, String imdgClssCd, String inGaFlg, String hblKnt, String mfSelfKnt, String docLocCd, String orgTrnsModCd, String destTrnsModCd, String siCd, String fAgnBkgOfcCd, String fAgnCtrtOfcCd, String fAgnFfCust) {
        this.ldDt = ldDt;
        this.svcScpCd = svcScpCd;
        this.fMtyRtnYdChk = fMtyRtnYdChk;
        this.por = por;
        this.cgoTpCd = cgoTpCd;
        this.trdCd = trdCd;
        this.errorMsg = errorMsg;
        this.rcvT = rcvT;
        this.pagerows = pagerows;
        this.pctlNo = pctlNo;
        this.ctrtNo = ctrtNo;
        this.fCltOfcCd = fCltOfcCd;
        this.depLane = depLane;
        this.custCntCd = custCntCd;
        this.unmatchChk = unmatchChk;
        this.fEndPctlNo = fEndPctlNo;
        this.gohCd = gohCd;
        this.fMtyPkupYd = fMtyPkupYd;
        this.fRv45 = fRv45;
        this.fOutParamNumber = fOutParamNumber;
        this.fPctlNo = fPctlNo;
        this.fMtyRtnYdNode = fMtyRtnYdNode;
        this.cmdtSeq = cmdtSeq;
        this.ctrtTp = ctrtTp;
        this.arvLane = arvLane;
        this.fRv40 = fRv40;
        this.fMtyPkupYdNode = fMtyPkupYdNode;
        this.fVoidQty = fVoidQty;
        this.subTrdCd = subTrdCd;
        this.cntrSzCd = cntrSzCd;
        this.delT = delT;
        this.fCallId = fCallId;
        this.ibflag = ibflag;
        this.cmdtCd = cmdtCd;
        this.fUserId = fUserId;
        this.del = del;
        this.fPpdOfcCd = fPpdOfcCd;
        this.fCostYrmon = fCostYrmon;
        this.costFlg = costFlg;
        this.custSeq = custSeq;
        this.fMtyRtnYd = fMtyRtnYd;
        this.socFlg = socFlg;
        this.fRv20 = fRv20;
        this.fCount = fCount;
        this.slanCd = slanCd;
        this.fGRev = fGRev;
        this.errorCode = errorCode;
        this.eqTpCd = eqTpCd;
        this.fStartPctlNo = fStartPctlNo;
        this.fAgmtSgnOfcCd = fAgmtSgnOfcCd;
        this.fMtyRtnYdCd = fMtyRtnYdCd;
        this.fMtyPkupYdCd = fMtyPkupYdCd;
        this.pgmNo = pgmNo;
        this.autoRatFlg = autoRatFlg;
        this.actWgt         = actWgt;
        this.wgtUtCd        = wgtUtCd;
        this.measQty        = measQty;
        this.measUtCd       = measUtCd;
        this.usaCstmsFileCd = usaCstmsFileCd;
        this.cndCstmsFileCd = cndCstmsFileCd;
        this.imdgClssCd     = imdgClssCd;
        this.inGaFlg        = inGaFlg;
        this.hblKnt         = hblKnt;
        this.mfSelfKnt      = mfSelfKnt;
        this.docLocCd       = docLocCd;
        this.orgTrnsModCd   = orgTrnsModCd;
        this.destTrnsModCd  = destTrnsModCd;
        this.siCd  = siCd;
        this.fAgnBkgOfcCd = fAgnBkgOfcCd;
        this.fAgnCtrtOfcCd = fAgnCtrtOfcCd;
        this.fAgnFfCust = fAgnFfCust;

    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ld_dt", getLdDt());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("f_mty_rtn_yd_chk", getFMtyRtnYdChk());
        this.hashColumns.put("por", getPor());
        this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("error_msg", getErrorMsg());
        this.hashColumns.put("rcv_t", getRcvT());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("ctrt_no", getCtrtNo());
        this.hashColumns.put("f_clt_ofc_cd", getFCltOfcCd());
        this.hashColumns.put("dep_lane", getDepLane());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("unmatch_chk", getUnmatchChk());
        this.hashColumns.put("f_end_pctl_no", getFEndPctlNo());
        this.hashColumns.put("goh_cd", getGohCd());
        this.hashColumns.put("f_mty_pkup_yd", getFMtyPkupYd());
        this.hashColumns.put("f_rv_45", getFRv45());
        this.hashColumns.put("f_out_param_number", getFOutParamNumber());
        this.hashColumns.put("f_pctl_no", getFPctlNo());
        this.hashColumns.put("f_mty_rtn_yd_node", getFMtyRtnYdNode());
        this.hashColumns.put("cmdt_seq", getCmdtSeq());
        this.hashColumns.put("ctrt_tp", getCtrtTp());
        this.hashColumns.put("arv_lane", getArvLane());
        this.hashColumns.put("f_rv_40", getFRv40());
        this.hashColumns.put("f_mty_pkup_yd_node", getFMtyPkupYdNode());
        this.hashColumns.put("f_void_qty", getFVoidQty());
        this.hashColumns.put("sub_trd_cd", getSubTrdCd());
        this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
        this.hashColumns.put("del_t", getDelT());
        this.hashColumns.put("f_call_id", getFCallId());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("f_user_id", getFUserId());
        this.hashColumns.put("del", getDel());
        this.hashColumns.put("f_ppd_ofc_cd", getFPpdOfcCd());
        this.hashColumns.put("f_cost_yrmon", getFCostYrmon());
        this.hashColumns.put("cost_flg", getCostFlg());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("f_mty_rtn_yd", getFMtyRtnYd());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("f_rv_20", getFRv20());
        this.hashColumns.put("f_count", getFCount());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("f_g_rev", getFGRev());
        this.hashColumns.put("error_code", getErrorCode());
        this.hashColumns.put("eq_tp_cd", getEqTpCd());
        this.hashColumns.put("f_start_pctl_no", getFStartPctlNo());
        this.hashColumns.put("f_agmt_sgn_ofc_cd", getFAgmtSgnOfcCd());
        this.hashColumns.put("f_mty_rtn_yd_cd", getFMtyRtnYdCd());
        this.hashColumns.put("f_mty_pkup_yd_cd", getFMtyPkupYdCd());
        this.hashColumns.put("pgm_no", getPgmNo());
        this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
        this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("in_ga_flg", getInGaFlg());
        this.hashColumns.put("hbl_knt", getHblKnt());
        this.hashColumns.put("mf_self_knt", getMfSelfKnt());
        this.hashColumns.put("doc_loc_cd", getDocLocCd());
        this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
        this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
        this.hashColumns.put("si_cd", getSiCd());
        this.hashColumns.put("f_agn_bkg_ofc_cd", getFAgnBkgOfcCd());
        this.hashColumns.put("f_agn_ctrt_ofc_cd", getFAgnCtrtOfcCd());
        this.hashColumns.put("f_agn_ff_cust", getFAgnFfCust());

        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ld_dt", "ldDt");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("f_mty_rtn_yd_chk", "fMtyRtnYdChk");
        this.hashFields.put("por", "por");
        this.hashFields.put("cgo_tp_cd", "cgoTpCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("error_msg", "errorMsg");
        this.hashFields.put("rcv_t", "rcvT");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("ctrt_no", "ctrtNo");
        this.hashFields.put("f_clt_ofc_cd", "fCltOfcCd");
        this.hashFields.put("dep_lane", "depLane");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("unmatch_chk", "unmatchChk");
        this.hashFields.put("f_end_pctl_no", "fEndPctlNo");
        this.hashFields.put("goh_cd", "gohCd");
        this.hashFields.put("f_mty_pkup_yd", "fMtyPkupYd");
        this.hashFields.put("f_rv_45", "fRv45");
        this.hashFields.put("f_out_param_number", "fOutParamNumber");
        this.hashFields.put("f_pctl_no", "fPctlNo");
        this.hashFields.put("f_mty_rtn_yd_node", "fMtyRtnYdNode");
        this.hashFields.put("cmdt_seq", "cmdtSeq");
        this.hashFields.put("ctrt_tp", "ctrtTp");
        this.hashFields.put("arv_lane", "arvLane");
        this.hashFields.put("f_rv_40", "fRv40");
        this.hashFields.put("f_mty_pkup_yd_node", "fMtyPkupYdNode");
        this.hashFields.put("f_void_qty", "fVoidQty");
        this.hashFields.put("sub_trd_cd", "subTrdCd");
        this.hashFields.put("cntr_sz_cd", "cntrSzCd");
        this.hashFields.put("del_t", "delT");
        this.hashFields.put("f_call_id", "fCallId");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("f_user_id", "fUserId");
        this.hashFields.put("del", "del");
        this.hashFields.put("f_ppd_ofc_cd", "fPpdOfcCd");
        this.hashFields.put("f_cost_yrmon", "fCostYrmon");
        this.hashFields.put("cost_flg", "costFlg");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("f_mty_rtn_yd", "fMtyRtnYd");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("f_rv_20", "fRv20");
        this.hashFields.put("f_count", "fCount");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("f_g_rev", "fGRev");
        this.hashFields.put("error_code", "errorCode");
        this.hashFields.put("eq_tp_cd", "eqTpCd");
        this.hashFields.put("f_start_pctl_no", "fStartPctlNo");
        this.hashFields.put("f_agmt_sgn_ofc_cd", "fAgmtSgnOfcCd");
        this.hashFields.put("f_mty_rtn_yd_cd", "fMtyRtnYdCd");
        this.hashFields.put("f_mty_pkup_yd_cd", "fMtyPkupYdCd");
        this.hashFields.put("pgm_no", "pgmNo");
        this.hashFields.put("auto_rat_flg", "autoRatFlg");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
        this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("in_ga_flg", "inGaFlg");
        this.hashFields.put("hbl_knt", "hblKnt");
        this.hashFields.put("mf_self_knt", "mfSelfKnt");
        this.hashFields.put("doc_loc_cd", "docLocCd");
        this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
        this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
        this.hashFields.put("si_cd", "siCd");
        this.hashFields.put("f_agn_bkg_ofc_cd", "fAgnBkgOfcCd");
        this.hashFields.put("f_agn_ctrt_ofc_cd", "fAgnCtrtOfcCd");
        this.hashFields.put("f_agn_ff_cust", "fAgnFfCust");

        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return ldDt
	 */
    public String getLdDt() {
        return this.ldDt;
    }

    /**
	 * Column Info
	 * @return svcScpCd
	 */
    public String getSvcScpCd() {
        return this.svcScpCd;
    }

    /**
	 * Column Info
	 * @return fMtyRtnYdChk
	 */
    public String getFMtyRtnYdChk() {
        return this.fMtyRtnYdChk;
    }

    /**
	 * Column Info
	 * @return por
	 */
    public String getPor() {
        return this.por;
    }

    /**
	 * Column Info
	 * @return cgoTpCd
	 */
    public String getCgoTpCd() {
        return this.cgoTpCd;
    }

    /**
	 * Column Info
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 * Column Info
	 * @return errorMsg
	 */
    public String getErrorMsg() {
        return this.errorMsg;
    }

    /**
	 * Column Info
	 * @return rcvT
	 */
    public String getRcvT() {
        return this.rcvT;
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
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
    }

    /**
	 * Column Info
	 * @return ctrtNo
	 */
    public String getCtrtNo() {
        return this.ctrtNo;
    }

    /**
	 * Column Info
	 * @return fCltOfcCd
	 */
    public String getFCltOfcCd() {
        return this.fCltOfcCd;
    }

    /**
	 * Column Info
	 * @return depLane
	 */
    public String getDepLane() {
        return this.depLane;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @return unmatchChk
	 */
    public String getUnmatchChk() {
        return this.unmatchChk;
    }

    /**
	 * Column Info
	 * @return fEndPctlNo
	 */
    public String getFEndPctlNo() {
        return this.fEndPctlNo;
    }

    /**
	 * Column Info
	 * @return gohCd
	 */
    public String getGohCd() {
        return this.gohCd;
    }

    /**
	 * Column Info
	 * @return fMtyPkupYd
	 */
    public String getFMtyPkupYd() {
        return this.fMtyPkupYd;
    }

    /**
	 * Column Info
	 * @return fRv45
	 */
    public String getFRv45() {
        return this.fRv45;
    }

    /**
	 * Column Info
	 * @return fOutParamNumber
	 */
    public String getFOutParamNumber() {
        return this.fOutParamNumber;
    }

    /**
	 * Column Info
	 * @return fPctlNo
	 */
    public String getFPctlNo() {
        return this.fPctlNo;
    }

    /**
	 * Column Info
	 * @return fMtyRtnYdNode
	 */
    public String getFMtyRtnYdNode() {
        return this.fMtyRtnYdNode;
    }

    /**
	 * Column Info
	 * @return cmdtSeq
	 */
    public String getCmdtSeq() {
        return this.cmdtSeq;
    }

    /**
	 * Column Info
	 * @return ctrtTp
	 */
    public String getCtrtTp() {
        return this.ctrtTp;
    }

    /**
	 * Column Info
	 * @return arvLane
	 */
    public String getArvLane() {
        return this.arvLane;
    }

    /**
	 * Column Info
	 * @return fRv40
	 */
    public String getFRv40() {
        return this.fRv40;
    }

    /**
	 * Column Info
	 * @return fMtyPkupYdNode
	 */
    public String getFMtyPkupYdNode() {
        return this.fMtyPkupYdNode;
    }

    /**
	 * Column Info
	 * @return fVoidQty
	 */
    public String getFVoidQty() {
        return this.fVoidQty;
    }

    /**
	 * Column Info
	 * @return subTrdCd
	 */
    public String getSubTrdCd() {
        return this.subTrdCd;
    }

    /**
	 * Column Info
	 * @return cntrSzCd
	 */
    public String getCntrSzCd() {
        return this.cntrSzCd;
    }

    /**
	 * Column Info
	 * @return delT
	 */
    public String getDelT() {
        return this.delT;
    }

    /**
	 * Column Info
	 * @return fCallId
	 */
    public String getFCallId() {
        return this.fCallId;
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
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return fUserId
	 */
    public String getFUserId() {
        return this.fUserId;
    }

    /**
	 * Column Info
	 * @return del
	 */
    public String getDel() {
        return this.del;
    }

    /**
	 * Column Info
	 * @return fPpdOfcCd
	 */
    public String getFPpdOfcCd() {
        return this.fPpdOfcCd;
    }

    /**
	 * Column Info
	 * @return fCostYrmon
	 */
    public String getFCostYrmon() {
        return this.fCostYrmon;
    }

    /**
	 * Column Info
	 * @return costFlg
	 */
    public String getCostFlg() {
        return this.costFlg;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return fMtyRtnYd
	 */
    public String getFMtyRtnYd() {
        return this.fMtyRtnYd;
    }

    /**
	 * Column Info
	 * @return socFlg
	 */
    public String getSocFlg() {
        return this.socFlg;
    }

    /**
	 * Column Info
	 * @return fRv20
	 */
    public String getFRv20() {
        return this.fRv20;
    }

    /**
	 * Column Info
	 * @return fCount
	 */
    public String getFCount() {
        return this.fCount;
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
	 * @return fGRev
	 */
    public String getFGRev() {
        return this.fGRev;
    }

    /**
	 * Column Info
	 * @return errorCode
	 */
    public String getErrorCode() {
        return this.errorCode;
    }

    /**
	 * Column Info
	 * @return eqTpCd
	 */
    public String getEqTpCd() {
        return this.eqTpCd;
    }

    /**
	 * Column Info
	 * @return fStartPctlNo
	 */
    public String getFStartPctlNo() {
        return this.fStartPctlNo;
    }

    /**
	 * Column Info
	 * @return fAgmtSgnOfcCd
	 */
    public String getFAgmtSgnOfcCd() {
        return this.fAgmtSgnOfcCd;
    }

    /**
	 * Column Info
	 * @return fMtyRtnYdCd
	 */
    public String getFMtyRtnYdCd() {
        return this.fMtyRtnYdCd;
    }

    /**
	 * Column Info
	 * @return fMtyPkupYdCd
	 */
    public String getFMtyPkupYdCd() {
        return this.fMtyPkupYdCd;
    }
    /**
	 * Column Info
	 * @return fAgnBkgOfcCd
	 */
    public String getFAgnBkgOfcCd() {
        return this.fAgnBkgOfcCd;
    }
    /**
	 * Column Info
	 * @return fAgnCtrtOfcCd
	 */
    public String getFAgnCtrtOfcCd() {
        return this.fAgnCtrtOfcCd;
    }
    /**
	 * Column Info
	 * @return fAgnFfCust
	 */
    public String getFAgnFfCust() {
        return this.fAgnFfCust;
    }

    /**
	 * Column Info
	 * @param ldDt
	 */
    public void setLdDt(String ldDt) {
        this.ldDt = ldDt;
    }

    /**
	 * Column Info
	 * @param svcScpCd
	 */
    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    /**
	 * Column Info
	 * @param fMtyRtnYdChk
	 */
    public void setFMtyRtnYdChk(String fMtyRtnYdChk) {
        this.fMtyRtnYdChk = fMtyRtnYdChk;
    }

    /**
	 * Column Info
	 * @param por
	 */
    public void setPor(String por) {
        this.por = por;
    }

    /**
	 * Column Info
	 * @param cgoTpCd
	 */
    public void setCgoTpCd(String cgoTpCd) {
        this.cgoTpCd = cgoTpCd;
    }

    /**
	 * Column Info
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * Column Info
	 * @param errorMsg
	 */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
	 * Column Info
	 * @param rcvT
	 */
    public void setRcvT(String rcvT) {
        this.rcvT = rcvT;
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
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    /**
	 * Column Info
	 * @param ctrtNo
	 */
    public void setCtrtNo(String ctrtNo) {
        this.ctrtNo = ctrtNo;
    }

    /**
	 * Column Info
	 * @param fCltOfcCd
	 */
    public void setFCltOfcCd(String fCltOfcCd) {
        this.fCltOfcCd = fCltOfcCd;
    }

    /**
	 * Column Info
	 * @param depLane
	 */
    public void setDepLane(String depLane) {
        this.depLane = depLane;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @param unmatchChk
	 */
    public void setUnmatchChk(String unmatchChk) {
        this.unmatchChk = unmatchChk;
    }

    /**
	 * Column Info
	 * @param fEndPctlNo
	 */
    public void setFEndPctlNo(String fEndPctlNo) {
        this.fEndPctlNo = fEndPctlNo;
    }

    /**
	 * Column Info
	 * @param gohCd
	 */
    public void setGohCd(String gohCd) {
        this.gohCd = gohCd;
    }

    /**
	 * Column Info
	 * @param fMtyPkupYd
	 */
    public void setFMtyPkupYd(String fMtyPkupYd) {
        this.fMtyPkupYd = fMtyPkupYd;
    }

    /**
	 * Column Info
	 * @param fRv45
	 */
    public void setFRv45(String fRv45) {
        this.fRv45 = fRv45;
    }

    /**
	 * Column Info
	 * @param fOutParamNumber
	 */
    public void setFOutParamNumber(String fOutParamNumber) {
        this.fOutParamNumber = fOutParamNumber;
    }

    /**
	 * Column Info
	 * @param fPctlNo
	 */
    public void setFPctlNo(String fPctlNo) {
        this.fPctlNo = fPctlNo;
    }

    /**
	 * Column Info
	 * @param fMtyRtnYdNode
	 */
    public void setFMtyRtnYdNode(String fMtyRtnYdNode) {
        this.fMtyRtnYdNode = fMtyRtnYdNode;
    }

    /**
	 * Column Info
	 * @param cmdtSeq
	 */
    public void setCmdtSeq(String cmdtSeq) {
        this.cmdtSeq = cmdtSeq;
    }

    /**
	 * Column Info
	 * @param ctrtTp
	 */
    public void setCtrtTp(String ctrtTp) {
        this.ctrtTp = ctrtTp;
    }

    /**
	 * Column Info
	 * @param arvLane
	 */
    public void setArvLane(String arvLane) {
        this.arvLane = arvLane;
    }

    /**
	 * Column Info
	 * @param fRv40
	 */
    public void setFRv40(String fRv40) {
        this.fRv40 = fRv40;
    }

    /**
	 * Column Info
	 * @param fMtyPkupYdNode
	 */
    public void setFMtyPkupYdNode(String fMtyPkupYdNode) {
        this.fMtyPkupYdNode = fMtyPkupYdNode;
    }

    /**
	 * Column Info
	 * @param fVoidQty
	 */
    public void setFVoidQty(String fVoidQty) {
        this.fVoidQty = fVoidQty;
    }

    /**
	 * Column Info
	 * @param subTrdCd
	 */
    public void setSubTrdCd(String subTrdCd) {
        this.subTrdCd = subTrdCd;
    }

    /**
	 * Column Info
	 * @param cntrSzCd
	 */
    public void setCntrSzCd(String cntrSzCd) {
        this.cntrSzCd = cntrSzCd;
    }

    /**
	 * Column Info
	 * @param delT
	 */
    public void setDelT(String delT) {
        this.delT = delT;
    }

    /**
	 * Column Info
	 * @param fCallId
	 */
    public void setFCallId(String fCallId) {
        this.fCallId = fCallId;
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
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param fUserId
	 */
    public void setFUserId(String fUserId) {
        this.fUserId = fUserId;
    }

    /**
	 * Column Info
	 * @param del
	 */
    public void setDel(String del) {
        this.del = del;
    }

    /**
	 * Column Info
	 * @param fPpdOfcCd
	 */
    public void setFPpdOfcCd(String fPpdOfcCd) {
        this.fPpdOfcCd = fPpdOfcCd;
    }

    /**
	 * Column Info
	 * @param fCostYrmon
	 */
    public void setFCostYrmon(String fCostYrmon) {
        this.fCostYrmon = fCostYrmon;
    }

    /**
	 * Column Info
	 * @param costFlg
	 */
    public void setCostFlg(String costFlg) {
        this.costFlg = costFlg;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param fMtyRtnYd
	 */
    public void setFMtyRtnYd(String fMtyRtnYd) {
        this.fMtyRtnYd = fMtyRtnYd;
    }

    /**
	 * Column Info
	 * @param socFlg
	 */
    public void setSocFlg(String socFlg) {
        this.socFlg = socFlg;
    }

    /**
	 * Column Info
	 * @param fRv20
	 */
    public void setFRv20(String fRv20) {
        this.fRv20 = fRv20;
    }

    /**
	 * Column Info
	 * @param fCount
	 */
    public void setFCount(String fCount) {
        this.fCount = fCount;
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
	 * @param fGRev
	 */
    public void setFGRev(String fGRev) {
        this.fGRev = fGRev;
    }

    /**
	 * Column Info
	 * @param errorCode
	 */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
	 * Column Info
	 * @param eqTpCd
	 */
    public void setEqTpCd(String eqTpCd) {
        this.eqTpCd = eqTpCd;
    }

    /**
	 * Column Info
	 * @param fStartPctlNo
	 */
    public void setFStartPctlNo(String fStartPctlNo) {
        this.fStartPctlNo = fStartPctlNo;
    }

    /**
	 * Column Info
	 * @param fAgmtSgnOfcCd
	 */
    public void setFAgmtSgnOfcCd(String fAgmtSgnOfcCd) {
        this.fAgmtSgnOfcCd = fAgmtSgnOfcCd;
    }

    /**
	 * Column Info
	 * @param fMtyRtnYdCd
	 */
    public void setFMtyRtnYdCd(String fMtyRtnYdCd) {
        this.fMtyRtnYdCd = fMtyRtnYdCd;
    }

    /**
	 * Column Info
	 * @param fMtyPkupYdCd
	 */
    public void setFMtyPkupYdCd(String fMtyPkupYdCd) {
        this.fMtyPkupYdCd = fMtyPkupYdCd;
    }
    /**
	 * Column Info
	 * @param fAgnBkgOfcCd
	 */
    public void setFAgnBkgOfcCd(String fAgnBkgOfcCd) {
        this.fAgnBkgOfcCd = fAgnBkgOfcCd;
    }
    /**
	 * Column Info
	 * @param fAgnCtrtOfcCd
	 */
    public void setFAgnCtrtOfcCd(String fAgnCtrtOfcCd) {
        this.fAgnCtrtOfcCd = fAgnCtrtOfcCd;
    }
    /**
	 * Column Info
	 * @param fAgnFfCust
	 */
    public void setFAgnFfCust(String fAgnFfCust) {
        this.fAgnFfCust = fAgnFfCust;
    }
    public void setPgmNo(String pgmNo) {
        this.pgmNo = pgmNo;
    }

    public String getPgmNo() {
        return this.pgmNo;
    }
    
    public void setAutoRatFlg(String autoRatFlg) {
    	this.autoRatFlg = autoRatFlg;
    }
    
    public String getAutoRatFlg() {
    	return this.autoRatFlg;
    }

    public String getActWgt() {
		return actWgt;
	}

	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}

	public String getWgtUtCd() {
		return wgtUtCd;
	}

	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	public String getMeasQty() {
		return measQty;
	}

	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}

	public String getMeasUtCd() {
		return measUtCd;
	}

	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}

	public String getUsaCstmsFileCd() {
		return usaCstmsFileCd;
	}

	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}

	public String getCndCstmsFileCd() {
		return cndCstmsFileCd;
	}

	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
	}

	public String getImdgClssCd() {
		return imdgClssCd;
	}

	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	public String getInGaFlg() {
		return inGaFlg;
	}

	public void setInGaFlg(String inGaFlg) {
		this.inGaFlg = inGaFlg;
	}

	public String getHblKnt() {
		return hblKnt;
	}

	public void setHblKnt(String hblKnt) {
		this.hblKnt = hblKnt;
	}

	public String getMfSelfKnt() {
		return mfSelfKnt;
	}

	public void setMfSelfKnt(String mfSelfKnt) {
		this.mfSelfKnt = mfSelfKnt;
	}

	public String getDocLocCd() {
		return docLocCd;
	}

	public void setDocLocCd(String docLocCd) {
		this.docLocCd = docLocCd;
	}

	public String getOrgTrnsModCd() {
		return orgTrnsModCd;
	}

	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}

	public String getDestTrnsModCd() {
		return destTrnsModCd;
	}

	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	public String getSiCd() {
		return siCd;
	}
	
	public void setSiCd(String siCd) {
		this.siCd = siCd;
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
        setLdDt(JSPUtil.getParameter(request, prefix + "ld_dt", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        setFMtyRtnYdChk(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_chk", ""));
        setPor(JSPUtil.getParameter(request, prefix + "por", ""));
        setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setErrorMsg(JSPUtil.getParameter(request, prefix + "error_msg", ""));
        setRcvT(JSPUtil.getParameter(request, prefix + "rcv_t", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
        setFCltOfcCd(JSPUtil.getParameter(request, prefix + "f_clt_ofc_cd", ""));
        setDepLane(JSPUtil.getParameter(request, prefix + "dep_lane", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setUnmatchChk(JSPUtil.getParameter(request, prefix + "unmatch_chk", ""));
        setFEndPctlNo(JSPUtil.getParameter(request, prefix + "f_end_pctl_no", ""));
        setGohCd(JSPUtil.getParameter(request, prefix + "goh_cd", ""));
        setFMtyPkupYd(JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd", ""));
        setFRv45(JSPUtil.getParameter(request, prefix + "f_rv_45", ""));
        setFOutParamNumber(JSPUtil.getParameter(request, prefix + "f_out_param_number", ""));
        setFPctlNo(JSPUtil.getParameter(request, prefix + "f_pctl_no", ""));
        setFMtyRtnYdNode(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_node", ""));
        setCmdtSeq(JSPUtil.getParameter(request, prefix + "cmdt_seq", ""));
        setCtrtTp(JSPUtil.getParameter(request, prefix + "ctrt_tp", ""));
        setArvLane(JSPUtil.getParameter(request, prefix + "arv_lane", ""));
        setFRv40(JSPUtil.getParameter(request, prefix + "f_rv_40", ""));
        setFMtyPkupYdNode(JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd_node", ""));
        setFVoidQty(JSPUtil.getParameter(request, prefix + "f_void_qty", ""));
        setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
        setCntrSzCd(JSPUtil.getParameter(request, prefix + "cntr_sz_cd", ""));
        setDelT(JSPUtil.getParameter(request, prefix + "del_t", ""));
        setFCallId(JSPUtil.getParameter(request, prefix + "f_call_id", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setFUserId(JSPUtil.getParameter(request, prefix + "f_user_id", ""));
        setDel(JSPUtil.getParameter(request, prefix + "del", ""));
        setFPpdOfcCd(JSPUtil.getParameter(request, prefix + "f_ppd_ofc_cd", ""));
        setFCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
        setCostFlg(JSPUtil.getParameter(request, prefix + "cost_flg", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setFMtyRtnYd(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setFRv20(JSPUtil.getParameter(request, prefix + "f_rv_20", ""));
        setFCount(JSPUtil.getParameter(request, prefix + "f_count", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setFGRev(JSPUtil.getParameter(request, prefix + "f_g_rev", ""));
        setErrorCode(JSPUtil.getParameter(request, prefix + "error_code", ""));
        setEqTpCd(JSPUtil.getParameter(request, prefix + "eq_tp_cd", ""));
        setFStartPctlNo(JSPUtil.getParameter(request, prefix + "f_start_pctl_no", ""));
        setFAgmtSgnOfcCd(JSPUtil.getParameter(request, prefix + "f_agmt_sgn_ofc_cd", ""));
        setFMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_cd", ""));
        setFMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd_cd", ""));
        setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
        setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
        setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
        setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setInGaFlg(JSPUtil.getParameter(request, prefix + "in_ga_flg", ""));
        setHblKnt(JSPUtil.getParameter(request, prefix + "hbl_knt", ""));
        setMfSelfKnt(JSPUtil.getParameter(request, prefix + "mf_self_knt", ""));
        setDocLocCd(JSPUtil.getParameter(request, prefix + "doc_loc_cd", ""));
        setOrgTrnsModCd(JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", ""));
        setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
        setSiCd(JSPUtil.getParameter(request, prefix + "si_cd", ""));
        setFAgnBkgOfcCd(JSPUtil.getParameter(request, prefix + "f_agn_bkg_ofc_cd", ""));
        setFAgnCtrtOfcCd(JSPUtil.getParameter(request, prefix + "f_agn_ctrt_ofc_cd", ""));
        setFAgnFfCust(JSPUtil.getParameter(request, prefix + "f_agn_ff_cust", ""));
}

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AplyRtInVO[]
	 */
    public AplyRtInVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AplyRtInVO[]
	 */
    public AplyRtInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AplyRtInVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ldDt = (JSPUtil.getParameter(request, prefix + "ld_dt", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] fMtyRtnYdChk = (JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_chk", length));
            String[] por = (JSPUtil.getParameter(request, prefix + "por", length));
            String[] cgoTpCd = (JSPUtil.getParameter(request, prefix + "cgo_tp_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] errorMsg = (JSPUtil.getParameter(request, prefix + "error_msg", length));
            String[] rcvT = (JSPUtil.getParameter(request, prefix + "rcv_t", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] ctrtNo = (JSPUtil.getParameter(request, prefix + "ctrt_no", length));
            String[] fCltOfcCd = (JSPUtil.getParameter(request, prefix + "f_clt_ofc_cd", length));
            String[] depLane = (JSPUtil.getParameter(request, prefix + "dep_lane", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] unmatchChk = (JSPUtil.getParameter(request, prefix + "unmatch_chk", length));
            String[] fEndPctlNo = (JSPUtil.getParameter(request, prefix + "f_end_pctl_no", length));
            String[] gohCd = (JSPUtil.getParameter(request, prefix + "goh_cd", length));
            String[] fMtyPkupYd = (JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd", length));
            String[] fRv45 = (JSPUtil.getParameter(request, prefix + "f_rv_45", length));
            String[] fOutParamNumber = (JSPUtil.getParameter(request, prefix + "f_out_param_number", length));
            String[] fPctlNo = (JSPUtil.getParameter(request, prefix + "f_pctl_no", length));
            String[] fMtyRtnYdNode = (JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_node", length));
            String[] cmdtSeq = (JSPUtil.getParameter(request, prefix + "cmdt_seq", length));
            String[] ctrtTp = (JSPUtil.getParameter(request, prefix + "ctrt_tp", length));
            String[] arvLane = (JSPUtil.getParameter(request, prefix + "arv_lane", length));
            String[] fRv40 = (JSPUtil.getParameter(request, prefix + "f_rv_40", length));
            String[] fMtyPkupYdNode = (JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd_node", length));
            String[] fVoidQty = (JSPUtil.getParameter(request, prefix + "f_void_qty", length));
            String[] subTrdCd = (JSPUtil.getParameter(request, prefix + "sub_trd_cd", length));
            String[] cntrSzCd = (JSPUtil.getParameter(request, prefix + "cntr_sz_cd", length));
            String[] delT = (JSPUtil.getParameter(request, prefix + "del_t", length));
            String[] fCallId = (JSPUtil.getParameter(request, prefix + "f_call_id", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] fUserId = (JSPUtil.getParameter(request, prefix + "f_user_id", length));
            String[] del = (JSPUtil.getParameter(request, prefix + "del", length));
            String[] fPpdOfcCd = (JSPUtil.getParameter(request, prefix + "f_ppd_ofc_cd", length));
            String[] fCostYrmon = (JSPUtil.getParameter(request, prefix + "f_cost_yrmon", length));
            String[] costFlg = (JSPUtil.getParameter(request, prefix + "cost_flg", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] fMtyRtnYd = (JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] fRv20 = (JSPUtil.getParameter(request, prefix + "f_rv_20", length));
            String[] fCount = (JSPUtil.getParameter(request, prefix + "f_count", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] fGRev = (JSPUtil.getParameter(request, prefix + "f_g_rev", length));
            String[] errorCode = (JSPUtil.getParameter(request, prefix + "error_code", length));
            String[] eqTpCd = (JSPUtil.getParameter(request, prefix + "eq_tp_cd", length));
            String[] fStartPctlNo = (JSPUtil.getParameter(request, prefix + "f_start_pctl_no", length));
            String[] fAgmtSgnOfcCd = (JSPUtil.getParameter(request, prefix + "f_agmt_sgn_ofc_cd", length));
            String[] fMtyRtnYdCd = (JSPUtil.getParameter(request, prefix + "f_mty_rtn_yd_cd", length));
            String[] fMtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "f_mty_pkup_yd_cd", length));
            String[] pgmNo = (JSPUtil.getParameter(request, prefix + "pgm_no", length));
            String[] autoRatFlg = (JSPUtil.getParameter(request, prefix + "auto_rat_flg", length));
            String[] actWgt         = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] wgtUtCd        = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] measQty        = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] measUtCd       = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", length));
            String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", length));
            String[] imdgClssCd     = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] inGaFlg        = (JSPUtil.getParameter(request, prefix + "in_ga_flg", length));
            String[] hblKnt         = (JSPUtil.getParameter(request, prefix + "hbl_knt", length));
            String[] mfSelfKnt      = (JSPUtil.getParameter(request, prefix + "mf_self_knt", length));
            String[] docLocCd       = (JSPUtil.getParameter(request, prefix + "doc_loc_cd", length));
            String[] orgTrnsModCd   = (JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", length));
            String[] destTrnsModCd  = (JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", length));
            String[] siCd  = (JSPUtil.getParameter(request, prefix + "si_cd", length));
            String[] fAgnBkgOfcCd = (JSPUtil.getParameter(request, prefix + "f_agn_bkg_ofc_cd", length));
            String[] fAgnCtrtOfcCd = (JSPUtil.getParameter(request, prefix + "f_agn_ctrt_ofc_cd", length));
            String[] fAgnFfCust = (JSPUtil.getParameter(request, prefix + "f_agn_ff_cust", length));

            for (int i = 0; i < length; i++) {
                model = new AplyRtInVO();
                if (ldDt[i] != null)
                    model.setLdDt(ldDt[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (fMtyRtnYdChk[i] != null)
                    model.setFMtyRtnYdChk(fMtyRtnYdChk[i]);
                if (por[i] != null)
                    model.setPor(por[i]);
                if (cgoTpCd[i] != null)
                    model.setCgoTpCd(cgoTpCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (errorMsg[i] != null)
                    model.setErrorMsg(errorMsg[i]);
                if (rcvT[i] != null)
                    model.setRcvT(rcvT[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (ctrtNo[i] != null)
                    model.setCtrtNo(ctrtNo[i]);
                if (fCltOfcCd[i] != null)
                    model.setFCltOfcCd(fCltOfcCd[i]);
                if (depLane[i] != null)
                    model.setDepLane(depLane[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (unmatchChk[i] != null)
                    model.setUnmatchChk(unmatchChk[i]);
                if (fEndPctlNo[i] != null)
                    model.setFEndPctlNo(fEndPctlNo[i]);
                if (gohCd[i] != null)
                    model.setGohCd(gohCd[i]);
                if (fMtyPkupYd[i] != null)
                    model.setFMtyPkupYd(fMtyPkupYd[i]);
                if (fRv45[i] != null)
                    model.setFRv45(fRv45[i]);
                if (fOutParamNumber[i] != null)
                    model.setFOutParamNumber(fOutParamNumber[i]);
                if (fPctlNo[i] != null)
                    model.setFPctlNo(fPctlNo[i]);
                if (fMtyRtnYdNode[i] != null)
                    model.setFMtyRtnYdNode(fMtyRtnYdNode[i]);
                if (cmdtSeq[i] != null)
                    model.setCmdtSeq(cmdtSeq[i]);
                if (ctrtTp[i] != null)
                    model.setCtrtTp(ctrtTp[i]);
                if (arvLane[i] != null)
                    model.setArvLane(arvLane[i]);
                if (fRv40[i] != null)
                    model.setFRv40(fRv40[i]);
                if (fMtyPkupYdNode[i] != null)
                    model.setFMtyPkupYdNode(fMtyPkupYdNode[i]);
                if (fVoidQty[i] != null)
                    model.setFVoidQty(fVoidQty[i]);
                if (subTrdCd[i] != null)
                    model.setSubTrdCd(subTrdCd[i]);
                if (cntrSzCd[i] != null)
                    model.setCntrSzCd(cntrSzCd[i]);
                if (delT[i] != null)
                    model.setDelT(delT[i]);
                if (fCallId[i] != null)
                    model.setFCallId(fCallId[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (fUserId[i] != null)
                    model.setFUserId(fUserId[i]);
                if (del[i] != null)
                    model.setDel(del[i]);
                if (fPpdOfcCd[i] != null)
                    model.setFPpdOfcCd(fPpdOfcCd[i]);
                if (fCostYrmon[i] != null)
                    model.setFCostYrmon(fCostYrmon[i]);
                if (costFlg[i] != null)
                    model.setCostFlg(costFlg[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (fMtyRtnYd[i] != null)
                    model.setFMtyRtnYd(fMtyRtnYd[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (fRv20[i] != null)
                    model.setFRv20(fRv20[i]);
                if (fCount[i] != null)
                    model.setFCount(fCount[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (fGRev[i] != null)
                    model.setFGRev(fGRev[i]);
                if (errorCode[i] != null)
                    model.setErrorCode(errorCode[i]);
                if (eqTpCd[i] != null)
                    model.setEqTpCd(eqTpCd[i]);
                if (fStartPctlNo[i] != null)
                    model.setFStartPctlNo(fStartPctlNo[i]);
                if (fAgmtSgnOfcCd[i] != null)
                    model.setFAgmtSgnOfcCd(fAgmtSgnOfcCd[i]);
                if (fMtyRtnYdCd[i] != null)
                    model.setFMtyRtnYdCd(fMtyRtnYdCd[i]);
                if (fMtyPkupYdCd[i] != null)
                    model.setFMtyPkupYdCd(fMtyPkupYdCd[i]);
                if (pgmNo[i] != null)
                	model.setPgmNo(pgmNo[i]);
                if (autoRatFlg[i] != null)
                	model.setAutoRatFlg(autoRatFlg[i]);
                if (actWgt[i] != null)
                	model.setActWgt(actWgt[i]);
                if (wgtUtCd[i] != null)
                	model.setWgtUtCd(wgtUtCd[i]);
                if (measQty[i] != null)
                	model.setMeasQty(measQty[i]);
                if (measUtCd[i] != null)
                	model.setMeasUtCd(measUtCd[i]);
                if (usaCstmsFileCd[i] != null)
                	model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
                if (cndCstmsFileCd[i] != null)
                	model.setCndCstmsFileCd(cndCstmsFileCd[i]);
                if (imdgClssCd[i] != null)
                	model.setImdgClssCd(imdgClssCd[i]);
                if (inGaFlg[i] != null)
                	model.setInGaFlg(inGaFlg[i]);
                if (hblKnt[i] != null)
                	model.setHblKnt(hblKnt[i]);
                if (mfSelfKnt[i] != null)
                	model.setMfSelfKnt(mfSelfKnt[i]);
                if (docLocCd[i] != null)
                	model.setDocLocCd(docLocCd[i]);
                if (orgTrnsModCd[i] != null)
                	model.setOrgTrnsModCd(orgTrnsModCd[i]);
                if (destTrnsModCd[i] != null)
                	model.setDestTrnsModCd(destTrnsModCd[i]);
                if (siCd[i] != null)
                	model.setSiCd(siCd[i]);
                if (fAgnBkgOfcCd[i] != null)
                    model.setFAgnBkgOfcCd(fAgnBkgOfcCd[i]);
                if (fAgnCtrtOfcCd[i] != null)
                    model.setFAgnCtrtOfcCd(fAgnCtrtOfcCd[i]);
                if (fAgnFfCust[i] != null)
                    model.setFAgnFfCust(fAgnFfCust[i]);

                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAplyRtInVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AplyRtInVO[]
	 */
    public AplyRtInVO[] getAplyRtInVOs() {
        AplyRtInVO[] vos = (AplyRtInVO[]) models.toArray(new AplyRtInVO[models.size()]);
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
        this.ldDt = this.ldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyRtnYdChk = this.fMtyRtnYdChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.por = this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoTpCd = this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errorMsg = this.errorMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvT = this.rcvT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCltOfcCd = this.fCltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.depLane = this.depLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unmatchChk = this.unmatchChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fEndPctlNo = this.fEndPctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gohCd = this.gohCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyPkupYd = this.fMtyPkupYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRv45 = this.fRv45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fOutParamNumber = this.fOutParamNumber.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPctlNo = this.fPctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyRtnYdNode = this.fMtyRtnYdNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtSeq = this.cmdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtTp = this.ctrtTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arvLane = this.arvLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRv40 = this.fRv40.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyPkupYdNode = this.fMtyPkupYdNode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fVoidQty = this.fVoidQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subTrdCd = this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSzCd = this.cntrSzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delT = this.delT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCallId = this.fCallId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fUserId = this.fUserId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.del = this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fPpdOfcCd = this.fPpdOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCostYrmon = this.fCostYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costFlg = this.costFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyRtnYd = this.fMtyRtnYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fRv20 = this.fRv20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fCount = this.fCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fGRev = this.fGRev.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errorCode = this.errorCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqTpCd = this.eqTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fStartPctlNo = this.fStartPctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fAgmtSgnOfcCd = this.fAgmtSgnOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyRtnYdCd = this.fMtyRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fMtyPkupYdCd = this.fMtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pgmNo = this.pgmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoRatFlg = this.autoRatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt         = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd        = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty        = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd       = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usaCstmsFileCd = this.usaCstmsFileCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndCstmsFileCd = this.cndCstmsFileCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd     = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inGaFlg        = this.inGaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hblKnt         = this.hblKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfSelfKnt      = this.mfSelfKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docLocCd       = this.docLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrnsModCd   = this.orgTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destTrnsModCd  = this.destTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCd  = this.siCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fAgnBkgOfcCd = this.fAgnBkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fAgnCtrtOfcCd = this.fAgnCtrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fAgnFfCust = this.fAgnFfCust.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

    }
}
