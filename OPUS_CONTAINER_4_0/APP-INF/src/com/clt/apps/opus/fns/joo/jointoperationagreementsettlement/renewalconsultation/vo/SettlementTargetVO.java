/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementTargetVO.java
*@FileTitle : SettlementTargetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo;

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
public class SettlementTargetVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SettlementTargetVO> models = new ArrayList<SettlementTargetVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String frRevYrmon = null;

    /* Column Info */
    private String toRevYrmon = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String joStlItmCds = null;

    /* Column Info */
    private String revVvd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String revDirCd = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String stlVvdSeq = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String joStlItmNm = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String stlTgtFlg = null;

    /* Column Info */
    private String actDt = null;

    /* Column Info */
    private String stDt = null;

    /* Column Info */
    private String endDt = null;

    /* Column Info */
    private String sailDys = null;

    /* Column Info */
    private String estmYrmon = null;

    /* Column Info */
    private String estmDys = null;

    /* Column Info */
    private String joStlJbCd = null;

    /* Column Info */
    private String bsaQty = null;

    /* Column Info */
    private String bsaSltPrc = null;

    /* Column Info */
    private String actAmt = null;

    /* Column Info */
    private String stlRmk = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String rnum = null;

    /* Column Info */
    private String grpNo = null;

    /* Column Info */
    private String grpKey = null;

    /* Column Info */
    private String fromEstmAmt = null;

    /* Column Info */
    private String actInvAmt = null;

    /* Column Info */
    private String actSlipAmt = null;

    /* Column Info */
    private String actApprAmt = null;

    /* Column Info */
    private String chkPriority = null;

    /* Column Info */
    private String estmAmt = null;

    /* Column Info */
    private String minEstmYrmon = null;

    /* Column Info */
    private String maxEstmYrmon = null;

    /* Column Info */
    private String ordSeq = null;

    /* Column Info */
    private String chkDelFlg = null;

    /* Column Info */
    private String stlYrmon = null;

    /* Column Info */
    private String selAcctgCrrCd = null;

    /* Column Info */
    private String selJoCrrCd = null;

    /* Column Info */
    private String selLoclCurrCd = null;

    /* Column Info */
    private String selReDivrCd = null;

    /* Column Info */
    private String acctYrmon = null;

    /* Column Info */
    private String selPrnrRefNo = null;

    /* Column Info */
    private String procJbFlg = null;

    /* Column Info */
    private String jobFlg = null;

    /* Column Info */
    private String chkEqActFlg = null;

    /* Column Info */
    private String chkDelMrkFlg = null;

    /* Column Info */
    private String chkQtyPriority = null;

    /* Column Info */
    private String chkPrcPriority = null;

    /* Column Info */
    private String chkEditFlg = null;

    /* Column Info */
    private String chkEditCnt = null;

    /* Column Info */
    private String authOfcCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SettlementTargetVO() {
    }

    public SettlementTargetVO(String ibflag, String pagerows, String frRevYrmon, String toRevYrmon, String trdCd, String joStlItmCds, String revVvd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String revYrmon, String stlVvdSeq, String joCrrCd, String rlaneCd, String acctCd, String joStlItmCd, String joStlItmNm, String loclCurrCd, String reDivrCd, String stlTgtFlg, String actDt, String stDt, String endDt, String sailDys, String estmYrmon, String estmDys, String joStlJbCd, String bsaQty, String bsaSltPrc, String actAmt, String stlRmk, String creDt, String creUsrId, String updDt, String updUsrId, String rnum, String grpNo, String grpKey, String fromEstmAmt, String actInvAmt, String actSlipAmt, String actApprAmt, String chkPriority, String estmAmt, String minEstmYrmon, String maxEstmYrmon, String ordSeq, String chkDelFlg, String stlYrmon, String selAcctgCrrCd, String selJoCrrCd, String selLoclCurrCd, String selReDivrCd, String acctYrmon, String selPrnrRefNo, String procJbFlg, String jobFlg, String chkEqActFlg, String chkDelMrkFlg, String chkQtyPriority, String chkPrcPriority, String chkEditFlg, String chkEditCnt, String authOfcCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.frRevYrmon = frRevYrmon;
        this.toRevYrmon = toRevYrmon;
        this.trdCd = trdCd;
        this.joStlItmCds = joStlItmCds;
        this.revVvd = revVvd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.revDirCd = revDirCd;
        this.revYrmon = revYrmon;
        this.stlVvdSeq = stlVvdSeq;
        this.joCrrCd = joCrrCd;
        this.rlaneCd = rlaneCd;
        this.acctCd = acctCd;
        this.joStlItmCd = joStlItmCd;
        this.joStlItmNm = joStlItmNm;
        this.loclCurrCd = loclCurrCd;
        this.reDivrCd = reDivrCd;
        this.stlTgtFlg = stlTgtFlg;
        this.actDt = actDt;
        this.stDt = stDt;
        this.endDt = endDt;
        this.sailDys = sailDys;
        this.estmYrmon = estmYrmon;
        this.estmDys = estmDys;
        this.joStlJbCd = joStlJbCd;
        this.bsaQty = bsaQty;
        this.bsaSltPrc = bsaSltPrc;
        this.actAmt = actAmt;
        this.stlRmk = stlRmk;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.rnum = rnum;
        this.grpNo = grpNo;
        this.grpKey = grpKey;
        this.fromEstmAmt = fromEstmAmt;
        this.actInvAmt = actInvAmt;
        this.actSlipAmt = actSlipAmt;
        this.actApprAmt = actApprAmt;
        this.chkPriority = chkPriority;
        this.estmAmt = estmAmt;
        this.minEstmYrmon = minEstmYrmon;
        this.maxEstmYrmon = maxEstmYrmon;
        this.ordSeq = ordSeq;
        this.chkDelFlg = chkDelFlg;
        this.stlYrmon = stlYrmon;
        this.selAcctgCrrCd = selAcctgCrrCd;
        this.selJoCrrCd = selJoCrrCd;
        this.selLoclCurrCd = selLoclCurrCd;
        this.selReDivrCd = selReDivrCd;
        this.acctYrmon = acctYrmon;
        this.selPrnrRefNo = selPrnrRefNo;
        this.procJbFlg = procJbFlg;
        this.jobFlg = jobFlg;
        this.chkEqActFlg = chkEqActFlg;
        this.chkDelMrkFlg = chkDelMrkFlg;
        this.chkQtyPriority = chkQtyPriority;
        this.chkPrcPriority = chkPrcPriority;
        this.chkEditFlg = chkEditFlg;
        this.chkEditCnt = chkEditCnt;
        this.authOfcCd = authOfcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("fr_rev_yrmon", getFrRevYrmon());
        this.hashColumns.put("to_rev_yrmon", getToRevYrmon());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("jo_stl_itm_cds", getJoStlItmCds());
        this.hashColumns.put("rev_vvd", getRevVvd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("stl_tgt_flg", getStlTgtFlg());
        this.hashColumns.put("act_dt", getActDt());
        this.hashColumns.put("st_dt", getStDt());
        this.hashColumns.put("end_dt", getEndDt());
        this.hashColumns.put("sail_dys", getSailDys());
        this.hashColumns.put("estm_yrmon", getEstmYrmon());
        this.hashColumns.put("estm_dys", getEstmDys());
        this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
        this.hashColumns.put("bsa_qty", getBsaQty());
        this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
        this.hashColumns.put("act_amt", getActAmt());
        this.hashColumns.put("stl_rmk", getStlRmk());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("grp_no", getGrpNo());
        this.hashColumns.put("grp_key", getGrpKey());
        this.hashColumns.put("from_estm_amt", getFromEstmAmt());
        this.hashColumns.put("act_inv_amt", getActInvAmt());
        this.hashColumns.put("act_slip_amt", getActSlipAmt());
        this.hashColumns.put("act_appr_amt", getActApprAmt());
        this.hashColumns.put("chk_priority", getChkPriority());
        this.hashColumns.put("estm_amt", getEstmAmt());
        this.hashColumns.put("min_estm_yrmon", getMinEstmYrmon());
        this.hashColumns.put("max_estm_yrmon", getMaxEstmYrmon());
        this.hashColumns.put("ord_seq", getOrdSeq());
        this.hashColumns.put("chk_del_flg", getChkDelFlg());
        this.hashColumns.put("stl_yrmon", getStlYrmon());
        this.hashColumns.put("sel_acctg_crr_cd", getSelAcctgCrrCd());
        this.hashColumns.put("sel_jo_crr_cd", getSelJoCrrCd());
        this.hashColumns.put("sel_locl_curr_cd", getSelLoclCurrCd());
        this.hashColumns.put("sel_re_divr_cd", getSelReDivrCd());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("sel_prnr_ref_no", getSelPrnrRefNo());
        this.hashColumns.put("proc_jb_flg", getProcJbFlg());
        this.hashColumns.put("job_flg", getJobFlg());
        this.hashColumns.put("chk_eq_act_flg", getChkEqActFlg());
        this.hashColumns.put("chk_del_mrk_flg", getChkDelMrkFlg());
        this.hashColumns.put("chk_qty_priority", getChkQtyPriority());
        this.hashColumns.put("chk_prc_priority", getChkPrcPriority());
        this.hashColumns.put("chk_edit_flg", getChkEditFlg());
        this.hashColumns.put("chk_edit_cnt", getChkEditCnt());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("fr_rev_yrmon", "frRevYrmon");
        this.hashFields.put("to_rev_yrmon", "toRevYrmon");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("jo_stl_itm_cds", "joStlItmCds");
        this.hashFields.put("rev_vvd", "revVvd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("jo_stl_itm_nm", "joStlItmNm");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("stl_tgt_flg", "stlTgtFlg");
        this.hashFields.put("act_dt", "actDt");
        this.hashFields.put("st_dt", "stDt");
        this.hashFields.put("end_dt", "endDt");
        this.hashFields.put("sail_dys", "sailDys");
        this.hashFields.put("estm_yrmon", "estmYrmon");
        this.hashFields.put("estm_dys", "estmDys");
        this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
        this.hashFields.put("bsa_qty", "bsaQty");
        this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
        this.hashFields.put("act_amt", "actAmt");
        this.hashFields.put("stl_rmk", "stlRmk");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("grp_no", "grpNo");
        this.hashFields.put("grp_key", "grpKey");
        this.hashFields.put("from_estm_amt", "fromEstmAmt");
        this.hashFields.put("act_inv_amt", "actInvAmt");
        this.hashFields.put("act_slip_amt", "actSlipAmt");
        this.hashFields.put("act_appr_amt", "actApprAmt");
        this.hashFields.put("chk_priority", "chkPriority");
        this.hashFields.put("estm_amt", "estmAmt");
        this.hashFields.put("min_estm_yrmon", "minEstmYrmon");
        this.hashFields.put("max_estm_yrmon", "maxEstmYrmon");
        this.hashFields.put("ord_seq", "ordSeq");
        this.hashFields.put("chk_del_flg", "chkDelFlg");
        this.hashFields.put("stl_yrmon", "stlYrmon");
        this.hashFields.put("sel_acctg_crr_cd", "selAcctgCrrCd");
        this.hashFields.put("sel_jo_crr_cd", "selJoCrrCd");
        this.hashFields.put("sel_locl_curr_cd", "selLoclCurrCd");
        this.hashFields.put("sel_re_divr_cd", "selReDivrCd");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("sel_prnr_ref_no", "selPrnrRefNo");
        this.hashFields.put("proc_jb_flg", "procJbFlg");
        this.hashFields.put("job_flg", "jobFlg");
        this.hashFields.put("chk_eq_act_flg", "chkEqActFlg");
        this.hashFields.put("chk_del_mrk_flg", "chkDelMrkFlg");
        this.hashFields.put("chk_qty_priority", "chkQtyPriority");
        this.hashFields.put("chk_prc_priority", "chkPrcPriority");
        this.hashFields.put("chk_edit_flg", "chkEditFlg");
        this.hashFields.put("chk_edit_cnt", "chkEditCnt");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        return this.hashFields;
    }

    /**
	 *
	 * @param String ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * 
	 * @return String ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 *
	 * @param String pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * 
	 * @return String pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 *
	 * @param String fmRevYrmon
	 */
    public void setFrRevYrmon(String frRevYrmon) {
        this.frRevYrmon = frRevYrmon;
    }

    /**
	 * 
	 * @return String fmRevYrmon
	 */
    public String getFrRevYrmon() {
        return this.frRevYrmon;
    }

    /**
	 *
	 * @param String toRevYrmon
	 */
    public void setToRevYrmon(String toRevYrmon) {
        this.toRevYrmon = toRevYrmon;
    }

    /**
	 * 
	 * @return String toRevYrmon
	 */
    public String getToRevYrmon() {
        return this.toRevYrmon;
    }

    /**
	 *
	 * @param String trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * 
	 * @return String trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 *
	 * @param String joStlItmCds
	 */
    public void setJoStlItmCds(String joStlItmCds) {
        this.joStlItmCds = joStlItmCds;
    }

    /**
	 * 
	 * @return String joStlItmCds
	 */
    public String getJoStlItmCds() {
        return this.joStlItmCds;
    }

    /**
	 *
	 * @param String revVvd
	 */
    public void setRevVvd(String revVvd) {
        this.revVvd = revVvd;
    }

    /**
	 * 
	 * @return String revVvd
	 */
    public String getRevVvd() {
        return this.revVvd;
    }

    /**
	 *
	 * @param String vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * 
	 * @return String vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 *
	 * @param String skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * 
	 * @return String skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 *
	 * @param String skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * 
	 * @return String skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 *
	 * @param String revDirCd
	 */
    public void setRevDirCd(String revDirCd) {
        this.revDirCd = revDirCd;
    }

    /**
	 * 
	 * @return String revDirCd
	 */
    public String getRevDirCd() {
        return this.revDirCd;
    }

    /**
	 *
	 * @param String revYrmon
	 */
    public void setRevYrmon(String revYrmon) {
        this.revYrmon = revYrmon;
    }

    /**
	 * 
	 * @return String revYrmon
	 */
    public String getRevYrmon() {
        return this.revYrmon;
    }

    /**
	 *
	 * @param String stlVvdSeq
	 */
    public void setStlVvdSeq(String stlVvdSeq) {
        this.stlVvdSeq = stlVvdSeq;
    }

    /**
	 * 
	 * @return String stlVvdSeq
	 */
    public String getStlVvdSeq() {
        return this.stlVvdSeq;
    }

    /**
	 *
	 * @param String joCrrCd
	 */
    public void setJoCrrCd(String joCrrCd) {
        this.joCrrCd = joCrrCd;
    }

    /**
	 * 
	 * @return String joCrrCd
	 */
    public String getJoCrrCd() {
        return this.joCrrCd;
    }

    /**
	 *
	 * @param String rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * 
	 * @return String rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 *
	 * @param String acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * 
	 * @return String acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 *
	 * @param String joStlItmCd
	 */
    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    /**
	 * 
	 * @return String joStlItmCd
	 */
    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    /**
	 *
	 * @param String joStlItmNm
	 */
    public void setJoStlItmNm(String joStlItmNm) {
        this.joStlItmNm = joStlItmNm;
    }

    /**
	 * 
	 * @return String joStlItmNm
	 */
    public String getJoStlItmNm() {
        return this.joStlItmNm;
    }

    /**
	 *
	 * @param String loclCurrCd
	 */
    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    /**
	 * 
	 * @return String loclCurrCd
	 */
    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    /**
	 *
	 * @param String reDivrCd
	 */
    public void setReDivrCd(String reDivrCd) {
        this.reDivrCd = reDivrCd;
    }

    /**
	 * 
	 * @return String reDivrCd
	 */
    public String getReDivrCd() {
        return this.reDivrCd;
    }

    /**
	 *
	 * @param String stlTgtFlg
	 */
    public void setStlTgtFlg(String stlTgtFlg) {
        this.stlTgtFlg = stlTgtFlg;
    }

    /**
	 * 
	 * @return String stlTgtFlg
	 */
    public String getStlTgtFlg() {
        return this.stlTgtFlg;
    }

    /**
	 *
	 * @param String actDt
	 */
    public void setActDt(String actDt) {
        this.actDt = actDt;
    }

    /**
	 * 
	 * @return String actDt
	 */
    public String getActDt() {
        return this.actDt;
    }

    /**
	 *
	 * @param String stDt
	 */
    public void setStDt(String stDt) {
        this.stDt = stDt;
    }

    /**
	 * 
	 * @return String stDt
	 */
    public String getStDt() {
        return this.stDt;
    }

    /**
	 *
	 * @param String endDt
	 */
    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    /**
	 * 
	 * @return String endDt
	 */
    public String getEndDt() {
        return this.endDt;
    }

    /**
	 *
	 * @param String sailDys
	 */
    public void setSailDys(String sailDys) {
        this.sailDys = sailDys;
    }

    /**
	 * 
	 * @return String sailDys
	 */
    public String getSailDys() {
        return this.sailDys;
    }

    /**
	 *
	 * @param String estmYrmon
	 */
    public void setEstmYrmon(String estmYrmon) {
        this.estmYrmon = estmYrmon;
    }

    /**
	 * 
	 * @return String estmYrmon
	 */
    public String getEstmYrmon() {
        return this.estmYrmon;
    }

    /**
	 *
	 * @param String estmDys
	 */
    public void setEstmDys(String estmDys) {
        this.estmDys = estmDys;
    }

    /**
	 * 
	 * @return String estmDys
	 */
    public String getEstmDys() {
        return this.estmDys;
    }

    /**
	 *
	 * @param String joStlJbCd
	 */
    public void setJoStlJbCd(String joStlJbCd) {
        this.joStlJbCd = joStlJbCd;
    }

    /**
	 * 
	 * @return String joStlJbCd
	 */
    public String getJoStlJbCd() {
        return this.joStlJbCd;
    }

    /**
	 *
	 * @param String bsaQty
	 */
    public void setBsaQty(String bsaQty) {
        this.bsaQty = bsaQty;
    }

    /**
	 * 
	 * @return String bsaQty
	 */
    public String getBsaQty() {
        return this.bsaQty;
    }

    /**
	 *
	 * @param String bsaSltPrc
	 */
    public void setBsaSltPrc(String bsaSltPrc) {
        this.bsaSltPrc = bsaSltPrc;
    }

    /**
	 * 
	 * @return String bsaSltPrc
	 */
    public String getBsaSltPrc() {
        return this.bsaSltPrc;
    }

    /**
	 *
	 * @param String actAmt
	 */
    public void setActAmt(String actAmt) {
        this.actAmt = actAmt;
    }

    /**
	 * 
	 * @return String actAmt
	 */
    public String getActAmt() {
        return this.actAmt;
    }

    /**
	 *
	 * @param String stlRmk
	 */
    public void setStlRmk(String stlRmk) {
        this.stlRmk = stlRmk;
    }

    /**
	 * 
	 * @return String stlRmk
	 */
    public String getStlRmk() {
        return this.stlRmk;
    }

    /**
	 *
	 * @param String creDt
	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * 
	 * @return String creDt
	 */
    public String getCreDt() {
        return this.creDt;
    }

    /**
	 *
	 * @param String creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * 
	 * @return String creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 *
	 * @param String updDt
	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
	 * 
	 * @return String updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 *
	 * @param String updUsrId
	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * 
	 * @return String updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getRnum() {
        return this.rnum;
    }

    public void setGrpNo(String grpNo) {
        this.grpNo = grpNo;
    }

    public String getGrpNo() {
        return this.grpNo;
    }

    public void setGrpKey(String grpKey) {
        this.grpKey = grpKey;
    }

    public String getGrpKey() {
        return this.grpKey;
    }

    public void setFromEstmAmt(String fromEstmAmt) {
        this.fromEstmAmt = fromEstmAmt;
    }

    public String getFromEstmAmt() {
        return this.fromEstmAmt;
    }

    public void setActInvAmt(String actInvAmt) {
        this.actInvAmt = actInvAmt;
    }

    public String getActInvAmt() {
        return this.actInvAmt;
    }

    public void setActSlipAmt(String actSlipAmt) {
        this.actSlipAmt = actSlipAmt;
    }

    public String getActSlipAmt() {
        return this.actSlipAmt;
    }

    public void setActApprAmt(String actApprAmt) {
        this.actApprAmt = actApprAmt;
    }

    public String getActApprAmt() {
        return this.actApprAmt;
    }

    public void setChkPriority(String chkPriority) {
        this.chkPriority = chkPriority;
    }

    public String getChkPriority() {
        return this.chkPriority;
    }

    public void setEstmAmt(String estmAmt) {
        this.estmAmt = estmAmt;
    }

    public String getEstmAmt() {
        return this.estmAmt;
    }

    public void setMinEstmYrmon(String minEstmYrmon) {
        this.minEstmYrmon = minEstmYrmon;
    }

    public String getMinEstmYrmon() {
        return this.minEstmYrmon;
    }

    public void setMaxEstmYrmon(String maxEstmYrmon) {
        this.maxEstmYrmon = maxEstmYrmon;
    }

    public String getMaxEstmYrmon() {
        return this.maxEstmYrmon;
    }

    public void setOrdSeq(String ordSeq) {
        this.ordSeq = ordSeq;
    }

    public String getOrdSeq() {
        return this.ordSeq;
    }

    public void setChkDelFlg(String chkDelFlg) {
        this.chkDelFlg = chkDelFlg;
    }

    public String getChkDelFlg() {
        return this.chkDelFlg;
    }

    public void setStlYrmon(String stlYrmon) {
        this.stlYrmon = stlYrmon;
    }

    public String getStlYrmon() {
        return this.stlYrmon;
    }

    public void setSelAcctgCrrCd(String selAcctgCrrCd) {
        this.selAcctgCrrCd = selAcctgCrrCd;
    }

    public String getSelAcctgCrrCd() {
        return this.selAcctgCrrCd;
    }

    public void setSelJoCrrCd(String selJoCrrCd) {
        this.selJoCrrCd = selJoCrrCd;
    }

    public String getSelJoCrrCd() {
        return this.selJoCrrCd;
    }

    public void setSelLoclCurrCd(String selLoclCurrCd) {
        this.selLoclCurrCd = selLoclCurrCd;
    }

    public String getSelLoclCurrCd() {
        return this.selLoclCurrCd;
    }

    public void setSelReDivrCd(String selReDivrCd) {
        this.selReDivrCd = selReDivrCd;
    }

    public String getSelReDivrCd() {
        return this.selReDivrCd;
    }

    public void setAcctYrmon(String acctYrmon) {
        this.acctYrmon = acctYrmon;
    }

    public String getAcctYrmon() {
        return this.acctYrmon;
    }

    public void setSelPrnrRefNo(String selPrnrRefNo) {
        this.selPrnrRefNo = selPrnrRefNo;
    }

    public String getSelPrnrRefNo() {
        return this.selPrnrRefNo;
    }

    public void setProcJbFlg(String procJbFlg) {
        this.procJbFlg = procJbFlg;
    }

    public String getProcJbFlg() {
        return this.procJbFlg;
    }

    public void setJobFlg(String jobFlg) {
        this.jobFlg = jobFlg;
    }

    public String getJobFlg() {
        return this.jobFlg;
    }

    public void setChkEqActFlg(String chkEqActFlg) {
        this.chkEqActFlg = chkEqActFlg;
    }

    public String getChkEqActFlg() {
        return this.chkEqActFlg;
    }

    public void setChkDelMrkFlg(String chkDelMrkFlg) {
        this.chkDelMrkFlg = chkDelMrkFlg;
    }

    public String getChkDelMrkFlg() {
        return this.chkDelMrkFlg;
    }

    public void setChkQtyPriority(String chkQtyPriority) {
        this.chkQtyPriority = chkQtyPriority;
    }

    public String getChkQtyPriority() {
        return this.chkQtyPriority;
    }

    public void setChkPrcPriority(String chkPrcPriority) {
        this.chkPrcPriority = chkPrcPriority;
    }

    public String getChkPrcPriority() {
        return this.chkPrcPriority;
    }

    public void setChkEditFlg(String chkEditFlg) {
        this.chkEditFlg = chkEditFlg;
    }

    public String getChkEditFlg() {
        return this.chkEditFlg;
    }

    public void setChkEditCnt(String chkEditCnt) {
        this.chkEditCnt = chkEditCnt;
    }

    public String getChkEditCnt() {
        return this.chkEditCnt;
    }

    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    public String getAuthOfcCd() {
        return this.authOfcCd;
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
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFrRevYrmon(JSPUtil.getParameter(request, prefix + "fr_rev_yrmon", ""));
        setToRevYrmon(JSPUtil.getParameter(request, prefix + "to_rev_yrmon", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setJoStlItmCds(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cds", ""));
        setRevVvd(JSPUtil.getParameter(request, prefix + "rev_vvd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
        setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
        setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setJoStlItmNm(JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setStlTgtFlg(JSPUtil.getParameter(request, prefix + "stl_tgt_flg", ""));
        setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
        setStDt(JSPUtil.getParameter(request, prefix + "st_dt", ""));
        setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
        setSailDys(JSPUtil.getParameter(request, prefix + "sail_dys", ""));
        setEstmYrmon(JSPUtil.getParameter(request, prefix + "estm_yrmon", ""));
        setEstmDys(JSPUtil.getParameter(request, prefix + "estm_dys", ""));
        setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
        setBsaQty(JSPUtil.getParameter(request, prefix + "bsa_qty", ""));
        setBsaSltPrc(JSPUtil.getParameter(request, prefix + "bsa_slt_prc", ""));
        setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
        setStlRmk(JSPUtil.getParameter(request, prefix + "stl_rmk", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setGrpNo(JSPUtil.getParameter(request, prefix + "grp_no", ""));
        setGrpKey(JSPUtil.getParameter(request, prefix + "grp_key", ""));
        setFromEstmAmt(JSPUtil.getParameter(request, prefix + "from_estm_amt", ""));
        setActInvAmt(JSPUtil.getParameter(request, prefix + "act_inv_amt", ""));
        setActSlipAmt(JSPUtil.getParameter(request, prefix + "act_slip_amt", ""));
        setActApprAmt(JSPUtil.getParameter(request, prefix + "act_appr_amt", ""));
        setChkPriority(JSPUtil.getParameter(request, prefix + "chk_priority", ""));
        setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
        setMinEstmYrmon(JSPUtil.getParameter(request, prefix + "min_estm_yrmon", ""));
        setMaxEstmYrmon(JSPUtil.getParameter(request, prefix + "max_estm_yrmon", ""));
        setOrdSeq(JSPUtil.getParameter(request, prefix + "ord_seq", ""));
        setChkDelFlg(JSPUtil.getParameter(request, prefix + "chk_del_flg", ""));
        setStlYrmon(JSPUtil.getParameter(request, prefix + "stl_yrmon", ""));
        setSelAcctgCrrCd(JSPUtil.getParameter(request, prefix + "sel_acctg_crr_cd", ""));
        setSelJoCrrCd(JSPUtil.getParameter(request, prefix + "sel_jo_crr_cd", ""));
        setSelLoclCurrCd(JSPUtil.getParameter(request, prefix + "sel_locl_curr_cd", ""));
        setSelReDivrCd(JSPUtil.getParameter(request, prefix + "sel_re_divr_cd", ""));
        setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
        setSelPrnrRefNo(JSPUtil.getParameter(request, prefix + "sel_prnr_ref_no", ""));
        setProcJbFlg(JSPUtil.getParameter(request, prefix + "proc_jb_flg", ""));
        setJobFlg(JSPUtil.getParameter(request, prefix + "job_flg", ""));
        setChkEqActFlg(JSPUtil.getParameter(request, prefix + "chk_eq_act_flg", ""));
        setChkDelMrkFlg(JSPUtil.getParameter(request, prefix + "chk_del_mrk_flg", ""));
        setChkQtyPriority(JSPUtil.getParameter(request, prefix + "chk_qty_priority", ""));
        setChkPrcPriority(JSPUtil.getParameter(request, prefix + "chk_prc_priority", ""));
        setChkEditFlg(JSPUtil.getParameter(request, prefix + "chk_edit_flg", ""));
        setChkEditCnt(JSPUtil.getParameter(request, prefix + "chk_edit_cnt", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementTargetVO[]
	 */
    public SettlementTargetVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SettlementTargetVO[]
	 */
    public SettlementTargetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SettlementTargetVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] frRevYrmon = (JSPUtil.getParameter(request, prefix + "fr_rev_yrmon", length));
            String[] toRevYrmon = (JSPUtil.getParameter(request, prefix + "to_rev_yrmon", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] joStlItmCds = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cds", length));
            String[] revVvd = (JSPUtil.getParameter(request, prefix + "rev_vvd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix + "stl_vvd_seq", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] joStlItmNm = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] stlTgtFlg = (JSPUtil.getParameter(request, prefix + "stl_tgt_flg", length));
            String[] actDt = (JSPUtil.getParameter(request, prefix + "act_dt", length));
            String[] stDt = (JSPUtil.getParameter(request, prefix + "st_dt", length));
            String[] endDt = (JSPUtil.getParameter(request, prefix + "end_dt", length));
            String[] sailDys = (JSPUtil.getParameter(request, prefix + "sail_dys", length));
            String[] estmYrmon = (JSPUtil.getParameter(request, prefix + "estm_yrmon", length));
            String[] estmDys = (JSPUtil.getParameter(request, prefix + "estm_dys", length));
            String[] joStlJbCd = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", length));
            String[] bsaQty = (JSPUtil.getParameter(request, prefix + "bsa_qty", length));
            String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix + "bsa_slt_prc", length));
            String[] actAmt = (JSPUtil.getParameter(request, prefix + "act_amt", length));
            String[] stlRmk = (JSPUtil.getParameter(request, prefix + "stl_rmk", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] grpNo = (JSPUtil.getParameter(request, prefix + "grp_no", length));
            String[] grpKey = (JSPUtil.getParameter(request, prefix + "grp_key", length));
            String[] fromEstmAmt = (JSPUtil.getParameter(request, prefix + "from_estm_amt", length));
            String[] actInvAmt = (JSPUtil.getParameter(request, prefix + "act_inv_amt", length));
            String[] actSlipAmt = (JSPUtil.getParameter(request, prefix + "act_slip_amt", length));
            String[] actApprAmt = (JSPUtil.getParameter(request, prefix + "act_appr_amt", length));
            String[] chkPriority = (JSPUtil.getParameter(request, prefix + "chk_priority", length));
            String[] estmAmt = (JSPUtil.getParameter(request, prefix + "estm_amt", length));
            String[] minEstmYrmon = (JSPUtil.getParameter(request, prefix + "min_estm_yrmon", length));
            String[] maxEstmYrmon = (JSPUtil.getParameter(request, prefix + "max_estm_yrmon", length));
            String[] ordSeq = (JSPUtil.getParameter(request, prefix + "ord_seq", length));
            String[] chkDelFlg = (JSPUtil.getParameter(request, prefix + "chk_del_flg", length));
            String[] stlYrmon = (JSPUtil.getParameter(request, prefix + "stl_yrmon", length));
            String[] selAcctgCrrCd = (JSPUtil.getParameter(request, prefix + "sel_acctg_crr_cd", length));
            String[] selJoCrrCd = (JSPUtil.getParameter(request, prefix + "sel_jo_crr_cd", length));
            String[] selLoclCurrCd = (JSPUtil.getParameter(request, prefix + "sel_locl_curr_cd", length));
            String[] selReDivrCd = (JSPUtil.getParameter(request, prefix + "sel_re_divr_cd", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] selPrnrRefNo = (JSPUtil.getParameter(request, prefix + "sel_prnr_ref_no", length));
            String[] procJbFlg = (JSPUtil.getParameter(request, prefix + "proc_jb_flg", length));
            String[] jobFlg = (JSPUtil.getParameter(request, prefix + "job_flg", length));
            String[] chkEqActFlg = (JSPUtil.getParameter(request, prefix + "chk_eq_act_flg", length));
            String[] chkDelMrkFlg = (JSPUtil.getParameter(request, prefix + "chk_del_mrk_flg", length));
            String[] chkQtyPriority = (JSPUtil.getParameter(request, prefix + "chk_qty_priority", length));
            String[] chkPrcPriority = (JSPUtil.getParameter(request, prefix + "chk_prc_priority", length));
            String[] chkEditFlg = (JSPUtil.getParameter(request, prefix + "chk_edit_flg", length));
            String[] chkEditCnt = (JSPUtil.getParameter(request, prefix + "chk_edit_cnt", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SettlementTargetVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (frRevYrmon[i] != null)
                    model.setFrRevYrmon(frRevYrmon[i]);
                if (toRevYrmon[i] != null)
                    model.setToRevYrmon(toRevYrmon[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (joStlItmCds[i] != null)
                    model.setJoStlItmCds(joStlItmCds[i]);
                if (revVvd[i] != null)
                    model.setRevVvd(revVvd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (stlVvdSeq[i] != null)
                    model.setStlVvdSeq(stlVvdSeq[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (joStlItmNm[i] != null)
                    model.setJoStlItmNm(joStlItmNm[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (stlTgtFlg[i] != null)
                    model.setStlTgtFlg(stlTgtFlg[i]);
                if (actDt[i] != null)
                    model.setActDt(actDt[i]);
                if (stDt[i] != null)
                    model.setStDt(stDt[i]);
                if (endDt[i] != null)
                    model.setEndDt(endDt[i]);
                if (sailDys[i] != null)
                    model.setSailDys(sailDys[i]);
                if (estmYrmon[i] != null)
                    model.setEstmYrmon(estmYrmon[i]);
                if (estmDys[i] != null)
                    model.setEstmDys(estmDys[i]);
                if (joStlJbCd[i] != null)
                    model.setJoStlJbCd(joStlJbCd[i]);
                if (bsaQty[i] != null)
                    model.setBsaQty(bsaQty[i]);
                if (bsaSltPrc[i] != null)
                    model.setBsaSltPrc(bsaSltPrc[i]);
                if (actAmt[i] != null)
                    model.setActAmt(actAmt[i]);
                if (stlRmk[i] != null)
                    model.setStlRmk(stlRmk[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (rnum[i] != null)
                    model.setRnum(rnum[i]);
                if (grpNo[i] != null)
                    model.setGrpNo(grpNo[i]);
                if (grpKey[i] != null)
                    model.setGrpKey(grpKey[i]);
                if (fromEstmAmt[i] != null)
                    model.setFromEstmAmt(fromEstmAmt[i]);
                if (actInvAmt[i] != null)
                    model.setActInvAmt(actInvAmt[i]);
                if (actSlipAmt[i] != null)
                    model.setActSlipAmt(actSlipAmt[i]);
                if (actApprAmt[i] != null)
                    model.setActApprAmt(actApprAmt[i]);
                if (chkPriority[i] != null)
                    model.setChkPriority(chkPriority[i]);
                if (estmAmt[i] != null)
                    model.setEstmAmt(estmAmt[i]);
                if (minEstmYrmon[i] != null)
                    model.setMinEstmYrmon(minEstmYrmon[i]);
                if (maxEstmYrmon[i] != null)
                    model.setMaxEstmYrmon(maxEstmYrmon[i]);
                if (ordSeq[i] != null)
                    model.setOrdSeq(ordSeq[i]);
                if (chkDelFlg[i] != null)
                    model.setChkDelFlg(chkDelFlg[i]);
                if (stlYrmon[i] != null)
                    model.setStlYrmon(stlYrmon[i]);
                if (selAcctgCrrCd[i] != null)
                    model.setSelAcctgCrrCd(selAcctgCrrCd[i]);
                if (selJoCrrCd[i] != null)
                    model.setSelJoCrrCd(selJoCrrCd[i]);
                if (selLoclCurrCd[i] != null)
                    model.setSelLoclCurrCd(selLoclCurrCd[i]);
                if (selReDivrCd[i] != null)
                    model.setSelReDivrCd(selReDivrCd[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (selPrnrRefNo[i] != null)
                    model.setSelPrnrRefNo(selPrnrRefNo[i]);
                if (procJbFlg[i] != null)
                    model.setProcJbFlg(procJbFlg[i]);
                if (jobFlg[i] != null)
                    model.setJobFlg(jobFlg[i]);
                if (chkEqActFlg[i] != null)
                    model.setChkEqActFlg(chkEqActFlg[i]);
                if (chkDelMrkFlg[i] != null)
                    model.setChkDelMrkFlg(chkDelMrkFlg[i]);
                if (chkQtyPriority[i] != null)
                    model.setChkQtyPriority(chkQtyPriority[i]);
                if (chkPrcPriority[i] != null)
                    model.setChkPrcPriority(chkPrcPriority[i]);
                if (chkEditFlg[i] != null)
                    model.setChkEditFlg(chkEditFlg[i]);
                if (chkEditCnt[i] != null)
                    model.setChkEditCnt(chkEditCnt[i]);
                if (authOfcCd[i] != null) 
		    		model.setAuthOfcCd(authOfcCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSettlementTargetVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SettlementTargetVO[]
	 */
    public SettlementTargetVO[] getSettlementTargetVOs() {
        SettlementTargetVO[] vos = (SettlementTargetVO[]) models.toArray(new SettlementTargetVO[models.size()]);
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
        this.frRevYrmon = this.frRevYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toRevYrmon = this.toRevYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCds = this.joStlItmCds.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revVvd = this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlVvdSeq = this.stlVvdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmNm = this.joStlItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlTgtFlg = this.stlTgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDt = this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stDt = this.stDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.endDt = this.endDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sailDys = this.sailDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmYrmon = this.estmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmDys = this.estmDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbCd = this.joStlJbCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaQty = this.bsaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bsaSltPrc = this.bsaSltPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actAmt = this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlRmk = this.stlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpNo = this.grpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpKey = this.grpKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromEstmAmt = this.fromEstmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actInvAmt = this.actInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actSlipAmt = this.actSlipAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actApprAmt = this.actApprAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkPriority = this.chkPriority.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.estmAmt = this.estmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.minEstmYrmon = this.minEstmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxEstmYrmon = this.maxEstmYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ordSeq = this.ordSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDelFlg = this.chkDelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlYrmon = this.stlYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selAcctgCrrCd = this.selAcctgCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selJoCrrCd = this.selJoCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selLoclCurrCd = this.selLoclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selReDivrCd = this.selReDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.selPrnrRefNo = this.selPrnrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.procJbFlg = this.procJbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.jobFlg = this.jobFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkEqActFlg = this.chkEqActFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDelMrkFlg = this.chkDelMrkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkQtyPriority = this.chkQtyPriority.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkPrcPriority = this.chkPrcPriority.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkEditFlg = this.chkEditFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkEditCnt = this.chkEditCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
