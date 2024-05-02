/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceDetailVO.java
*@FileTitle : InvoiceDetailVO
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
public class InvoiceDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InvoiceDetailVO> models = new ArrayList<InvoiceDetailVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String fmAcctYrmon = null;

    /* Column Info */
    private String toAcctYrmon = null;

    /* Column Info */
    private String acctYrmon = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String reDivrCd = null;

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
    private String actAmt = null;

    /* Column Info */
    private String stlRmk = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String csrLoclAmt = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String revVvd = null;

    /* Column Info */
    private String revActAmt = null;

    /* Column Info */
    private String expVvd = null;

    /* Column Info */
    private String expActAmt = null;

    /* Column Info */
    private String ordSeq = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String joStlItmNm = null;

    /* Column Info */
    private String joStlJbCd = null;

    /* Column Info */
    private String joStlJbNm = null;

    /* Column Info */
    private String dtlGrpKey = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String aproFlg = null;

    /* Column Info */
    private String invActAmt = null;

    /* Column Info */
    private String slpActAmt = null;

    /* Column Info */
    private String custVndrEngNm = null;

    /* Column Info */
    private String prnrRefNo = null;

    /* Column Info */
    private String acctgCrrCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public InvoiceDetailVO() {
    }

    public InvoiceDetailVO(String ibflag, String pagerows, String fmAcctYrmon, String toAcctYrmon, String acctYrmon, String joCrrCd, String invNo, String reDivrCd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String revYrmon, String stlVvdSeq, String actAmt, String stlRmk, String csrNo, String csrLoclAmt, String creDt, String creUsrId, String updDt, String updUsrId, String revVvd, String revActAmt, String expVvd, String expActAmt, String ordSeq, String rlaneCd, String joStlItmCd, String joStlItmNm, String joStlJbCd, String joStlJbNm, String dtlGrpKey, String loclCurrCd, String aproFlg, String invActAmt, String slpActAmt, String custVndrEngNm, String prnrRefNo, String acctgCrrCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.fmAcctYrmon = fmAcctYrmon;
        this.toAcctYrmon = toAcctYrmon;
        this.acctYrmon = acctYrmon;
        this.joCrrCd = joCrrCd;
        this.invNo = invNo;
        this.reDivrCd = reDivrCd;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.revDirCd = revDirCd;
        this.revYrmon = revYrmon;
        this.stlVvdSeq = stlVvdSeq;
        this.actAmt = actAmt;
        this.stlRmk = stlRmk;
        this.csrNo = csrNo;
        this.csrLoclAmt = csrLoclAmt;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.revVvd = revVvd;
        this.revActAmt = revActAmt;
        this.expVvd = expVvd;
        this.expActAmt = expActAmt;
        this.ordSeq = ordSeq;
        this.rlaneCd = rlaneCd;
        this.joStlItmCd = joStlItmCd;
        this.joStlItmNm = joStlItmNm;
        this.joStlJbCd = joStlJbCd;
        this.joStlJbNm = joStlJbNm;
        this.dtlGrpKey = dtlGrpKey;
        this.loclCurrCd = loclCurrCd;
        this.aproFlg = aproFlg;
        this.invActAmt = invActAmt;
        this.slpActAmt = slpActAmt;
        this.custVndrEngNm = custVndrEngNm;
        this.prnrRefNo = prnrRefNo;
        this.acctgCrrCd = acctgCrrCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("fm_acct_yrmon", getFmAcctYrmon());
        this.hashColumns.put("to_acct_yrmon", getToAcctYrmon());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("stl_vvd_seq", getStlVvdSeq());
        this.hashColumns.put("act_amt", getActAmt());
        this.hashColumns.put("stl_rmk", getStlRmk());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("rev_vvd", getRevVvd());
        this.hashColumns.put("rev_act_amt", getRevActAmt());
        this.hashColumns.put("exp_vvd", getExpVvd());
        this.hashColumns.put("exp_act_amt", getExpActAmt());
        this.hashColumns.put("ord_seq", getOrdSeq());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
        this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
        this.hashColumns.put("jo_stl_jb_nm", getJoStlJbNm());
        this.hashColumns.put("dtl_grp_key", getDtlGrpKey());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("apro_flg", getAproFlg());
        this.hashColumns.put("inv_act_amt", getInvActAmt());
        this.hashColumns.put("slp_act_amt", getSlpActAmt());
        this.hashColumns.put("cust_vndr_eng_nm", getCustVndrEngNm());
        this.hashColumns.put("prnr_ref_no", getPrnrRefNo());
        this.hashColumns.put("acctg_crr_cd", getAcctgCrrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("fm_acct_yrmon", "fmAcctYrmon");
        this.hashFields.put("to_acct_yrmon", "toAcctYrmon");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("stl_vvd_seq", "stlVvdSeq");
        this.hashFields.put("act_amt", "actAmt");
        this.hashFields.put("stl_rmk", "stlRmk");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("csr_locl_amt", "csrLoclAmt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("rev_vvd", "revVvd");
        this.hashFields.put("rev_act_amt", "revActAmt");
        this.hashFields.put("exp_vvd", "expVvd");
        this.hashFields.put("exp_act_amt", "expActAmt");
        this.hashFields.put("ord_seq", "ordSeq");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("jo_stl_itm_nm", "joStlItmNm");
        this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
        this.hashFields.put("jo_stl_jb_nm", "joStlJbNm");
        this.hashFields.put("dtl_grp_key", "dtlGrpKey");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("apro_flg", "aproFlg");
        this.hashFields.put("inv_act_amt", "invActAmt");
        this.hashFields.put("slp_act_amt", "slpActAmt");
        this.hashFields.put("cust_vndr_eng_nm", "custVndrEngNm");
        this.hashFields.put("prnr_ref_no", "prnrRefNo");
        this.hashFields.put("acctg_crr_cd", "acctgCrrCd");
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
	 * @param String fmAcctYrmon
	 */
    public void setFmAcctYrmon(String fmAcctYrmon) {
        this.fmAcctYrmon = fmAcctYrmon;
    }

    /**
	 * 
	 * @return String fmAcctYrmon
	 */
    public String getFmAcctYrmon() {
        return this.fmAcctYrmon;
    }

    /**
	 *
	 * @param String toAcctYrmon
	 */
    public void setToAcctYrmon(String toAcctYrmon) {
        this.toAcctYrmon = toAcctYrmon;
    }

    /**
	 * 
	 * @return String toAcctYrmon
	 */
    public String getToAcctYrmon() {
        return this.toAcctYrmon;
    }

    /**
	 *
	 * @param String acctYrmon
	 */
    public void setAcctYrmon(String acctYrmon) {
        this.acctYrmon = acctYrmon;
    }

    /**
	 * 
	 * @return String acctYrmon
	 */
    public String getAcctYrmon() {
        return this.acctYrmon;
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
	 * @param String invNo
	 */
    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    /**
	 * 
	 * @return String invNo
	 */
    public String getInvNo() {
        return this.invNo;
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
	 * @param String csrNo
	 */
    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    /**
	 * 
	 * @return String csrNo
	 */
    public String getCsrNo() {
        return this.csrNo;
    }

    /**
	 *
	 * @param String csrLoclAmt
	 */
    public void setCsrLoclAmt(String csrLoclAmt) {
        this.csrLoclAmt = csrLoclAmt;
    }

    /**
	 * 
	 * @return String csrLoclAmt
	 */
    public String getCsrLoclAmt() {
        return this.csrLoclAmt;
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

    public void setRevVvd(String revVvd) {
        this.revVvd = revVvd;
    }

    public String getRevVvd() {
        return this.revVvd;
    }

    public void setRevActAmt(String revActAmt) {
        this.revActAmt = revActAmt;
    }

    public String getRevActAmt() {
        return this.revActAmt;
    }

    public void setExpVvd(String expVvd) {
        this.expVvd = expVvd;
    }

    public String getExpVvd() {
        return this.expVvd;
    }

    public void setExpActAmt(String expActAmt) {
        this.expActAmt = expActAmt;
    }

    public String getExpActAmt() {
        return this.expActAmt;
    }

    public void setOrdSeq(String ordSeq) {
        this.ordSeq = ordSeq;
    }

    public String getOrdSeq() {
        return this.ordSeq;
    }

    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    public String getRlaneCd() {
        return this.rlaneCd;
    }

    public void setJoStlItmCd(String joStlItmCd) {
        this.joStlItmCd = joStlItmCd;
    }

    public String getJoStlItmCd() {
        return this.joStlItmCd;
    }

    public void setJoStlItmNm(String joStlItmNm) {
        this.joStlItmNm = joStlItmNm;
    }

    public String getJoStlItmNm() {
        return this.joStlItmNm;
    }

    public void setJoStlJbCd(String joStlJbCd) {
        this.joStlJbCd = joStlJbCd;
    }

    public String getJoStlJbCd() {
        return this.joStlJbCd;
    }

    public void setJoStlJbNm(String joStlJbNm) {
        this.joStlJbNm = joStlJbNm;
    }

    public String getJoStlJbNm() {
        return this.joStlJbNm;
    }

    public void setDtlGrpKey(String dtlGrpKey) {
        this.dtlGrpKey = dtlGrpKey;
    }

    public String getDtlGrpKey() {
        return this.dtlGrpKey;
    }

    public void setLoclCurrCd(String loclCurrCd) {
        this.loclCurrCd = loclCurrCd;
    }

    public String getLoclCurrCd() {
        return this.loclCurrCd;
    }

    public void setAproFlg(String aproFlg) {
        this.aproFlg = aproFlg;
    }

    public String getAproFlg() {
        return this.aproFlg;
    }

    public void setInvActAmt(String invActAmt) {
        this.invActAmt = invActAmt;
    }

    public String getInvActAmt() {
        return this.invActAmt;
    }

    public void setSlpActAmt(String slpActAmt) {
        this.slpActAmt = slpActAmt;
    }

    public String getSlpActAmt() {
        return this.slpActAmt;
    }

    public void setCustVndrEngNm(String custVndrEngNm) {
        this.custVndrEngNm = custVndrEngNm;
    }

    public String getCustVndrEngNm() {
        return this.custVndrEngNm;
    }

    public void setPrnrRefNo(String prnrRefNo) {
        this.prnrRefNo = prnrRefNo;
    }

    public String getPrnrRefNo() {
        return this.prnrRefNo;
    }

    public void setAcctgCrrCd(String acctgCrrCd) {
        this.acctgCrrCd = acctgCrrCd;
    }

    public String getAcctgCrrCd() {
        return this.acctgCrrCd;
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
        setFmAcctYrmon(JSPUtil.getParameter(request, prefix + "fm_acct_yrmon", ""));
        setToAcctYrmon(JSPUtil.getParameter(request, prefix + "to_acct_yrmon", ""));
        setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
        setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
        setStlVvdSeq(JSPUtil.getParameter(request, prefix + "stl_vvd_seq", ""));
        setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
        setStlRmk(JSPUtil.getParameter(request, prefix + "stl_rmk", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setCsrLoclAmt(JSPUtil.getParameter(request, prefix + "csr_locl_amt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setRevVvd(JSPUtil.getParameter(request, prefix + "rev_vvd", ""));
        setRevActAmt(JSPUtil.getParameter(request, prefix + "rev_act_amt", ""));
        setExpVvd(JSPUtil.getParameter(request, prefix + "exp_vvd", ""));
        setExpActAmt(JSPUtil.getParameter(request, prefix + "exp_act_amt", ""));
        setOrdSeq(JSPUtil.getParameter(request, prefix + "ord_seq", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setJoStlItmNm(JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", ""));
        setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
        setJoStlJbNm(JSPUtil.getParameter(request, prefix + "jo_stl_jb_nm", ""));
        setDtlGrpKey(JSPUtil.getParameter(request, prefix + "dtl_grp_key", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
        setInvActAmt(JSPUtil.getParameter(request, prefix + "inv_act_amt", ""));
        setSlpActAmt(JSPUtil.getParameter(request, prefix + "slp_act_amt", ""));
        setCustVndrEngNm(JSPUtil.getParameter(request, prefix + "cust_vndr_eng_nm", ""));
        setPrnrRefNo(JSPUtil.getParameter(request, prefix + "prnr_ref_no", ""));
        setAcctgCrrCd(JSPUtil.getParameter(request, prefix + "acctg_crr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceDetailVO[]
	 */
    public InvoiceDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceDetailVO[]
	 */
    public InvoiceDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InvoiceDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fmAcctYrmon = (JSPUtil.getParameter(request, prefix + "fm_acct_yrmon", length));
            String[] toAcctYrmon = (JSPUtil.getParameter(request, prefix + "to_acct_yrmon", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] stlVvdSeq = (JSPUtil.getParameter(request, prefix + "stl_vvd_seq", length));
            String[] actAmt = (JSPUtil.getParameter(request, prefix + "act_amt", length));
            String[] stlRmk = (JSPUtil.getParameter(request, prefix + "stl_rmk", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix + "csr_locl_amt", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] revVvd = (JSPUtil.getParameter(request, prefix + "rev_vvd", length));
            String[] revActAmt = (JSPUtil.getParameter(request, prefix + "rev_act_amt", length));
            String[] expVvd = (JSPUtil.getParameter(request, prefix + "exp_vvd", length));
            String[] expActAmt = (JSPUtil.getParameter(request, prefix + "exp_act_amt", length));
            String[] ordSeq = (JSPUtil.getParameter(request, prefix + "ord_seq", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] joStlItmNm = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", length));
            String[] joStlJbCd = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", length));
            String[] joStlJbNm = (JSPUtil.getParameter(request, prefix + "jo_stl_jb_nm", length));
            String[] dtlGrpKey = (JSPUtil.getParameter(request, prefix + "dtl_grp_key", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] aproFlg = (JSPUtil.getParameter(request, prefix + "apro_flg", length));
            String[] invActAmt = (JSPUtil.getParameter(request, prefix + "inv_act_amt", length));
            String[] slpActAmt = (JSPUtil.getParameter(request, prefix + "slp_act_amt", length));
            String[] custVndrEngNm = (JSPUtil.getParameter(request, prefix + "cust_vndr_eng_nm", length));
            String[] prnrRefNo = (JSPUtil.getParameter(request, prefix + "prnr_ref_no", length));
            String[] acctgCrrCd = (JSPUtil.getParameter(request, prefix + "acctg_crr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InvoiceDetailVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fmAcctYrmon[i] != null)
                    model.setFmAcctYrmon(fmAcctYrmon[i]);
                if (toAcctYrmon[i] != null)
                    model.setToAcctYrmon(toAcctYrmon[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
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
                if (actAmt[i] != null)
                    model.setActAmt(actAmt[i]);
                if (stlRmk[i] != null)
                    model.setStlRmk(stlRmk[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (csrLoclAmt[i] != null)
                    model.setCsrLoclAmt(csrLoclAmt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (revVvd[i] != null)
                    model.setRevVvd(revVvd[i]);
                if (revActAmt[i] != null)
                    model.setRevActAmt(revActAmt[i]);
                if (expVvd[i] != null)
                    model.setExpVvd(expVvd[i]);
                if (expActAmt[i] != null)
                    model.setExpActAmt(expActAmt[i]);
                if (ordSeq[i] != null)
                    model.setOrdSeq(ordSeq[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (joStlItmNm[i] != null)
                    model.setJoStlItmNm(joStlItmNm[i]);
                if (joStlJbCd[i] != null)
                    model.setJoStlJbCd(joStlJbCd[i]);
                if (joStlJbNm[i] != null)
                    model.setJoStlJbNm(joStlJbNm[i]);
                if (dtlGrpKey[i] != null)
                    model.setDtlGrpKey(dtlGrpKey[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (aproFlg[i] != null)
                    model.setAproFlg(aproFlg[i]);
                if (invActAmt[i] != null)
                    model.setInvActAmt(invActAmt[i]);
                if (slpActAmt[i] != null)
                    model.setSlpActAmt(slpActAmt[i]);
                if (custVndrEngNm[i] != null)
                    model.setCustVndrEngNm(custVndrEngNm[i]);
                if (prnrRefNo[i] != null)
                    model.setPrnrRefNo(prnrRefNo[i]);
                if (acctgCrrCd[i] != null) 
		    		model.setAcctgCrrCd(acctgCrrCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInvoiceDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InvoiceDetailVO[]
	 */
    public InvoiceDetailVO[] getInvoiceDetailVOs() {
        InvoiceDetailVO[] vos = (InvoiceDetailVO[]) models.toArray(new InvoiceDetailVO[models.size()]);
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
        this.fmAcctYrmon = this.fmAcctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toAcctYrmon = this.toAcctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlVvdSeq = this.stlVvdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actAmt = this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlRmk = this.stlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrLoclAmt = this.csrLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revVvd = this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revActAmt = this.revActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expVvd = this.expVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.expActAmt = this.expActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ordSeq = this.ordSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmNm = this.joStlItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbCd = this.joStlJbCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlJbNm = this.joStlJbNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dtlGrpKey = this.dtlGrpKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproFlg = this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invActAmt = this.invActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpActAmt = this.slpActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custVndrEngNm = this.custVndrEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrRefNo = this.prnrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctgCrrCd = this.acctgCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
