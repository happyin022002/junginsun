/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceVO.java
*@FileTitle : InvoiceVO
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
public class InvoiceVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InvoiceVO> models = new ArrayList<InvoiceVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String acctYrmon = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String slpFuncCd = null;

    /* Column Info */
    private String slpOfcCd = null;

    /* Column Info */
    private String slpIssDt = null;

    /* Column Info */
    private String slpTpCd = null;

    /* Column Info */
    private String slpSerNo = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String actAmt = null;

    /* Column Info */
    private String rvsCmbFlg = null;

    /* Column Info */
    private String rjctCmbFlg = null;

    /* Column Info */
    private String invRevActAmt = null;

    /* Column Info */
    private String invExpActAmt = null;

    /* Column Info */
    private String stlRevActAmt = null;

    /* Column Info */
    private String stlExpActAmt = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String acctgCrrCd = null;

    /* Column Info */
    private String prnrRefNo = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String chkCmbFlg = null;

    /* Column Info */
    private String dtlGrpKey = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String custVndrCntCd = null;

    /* Column Info */
    private String custVndrSeq = null;

    /* Column Info */
    private String custVndrEngNm = null;

    /* Column Info */
    private String chkDelFlg = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String aproFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public InvoiceVO() {
    }

    public InvoiceVO(String ibflag, String pagerows, String acctYrmon, String joCrrCd, String invNo, String reDivrCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpTpCd, String slpSerNo, String loclCurrCd, String actAmt, String rvsCmbFlg, String rjctCmbFlg, String invRevActAmt, String invExpActAmt, String stlRevActAmt, String stlExpActAmt, String creDt, String creUsrId, String updDt, String updUsrId, String acctgCrrCd, String prnrRefNo, String rlaneCd, String chkCmbFlg, String dtlGrpKey, String custCd, String vndrSeq, String custVndrCntCd, String custVndrSeq, String custVndrEngNm, String chkDelFlg, String csrNo, String aproFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.acctYrmon = acctYrmon;
        this.joCrrCd = joCrrCd;
        this.invNo = invNo;
        this.reDivrCd = reDivrCd;
        this.slpFuncCd = slpFuncCd;
        this.slpOfcCd = slpOfcCd;
        this.slpIssDt = slpIssDt;
        this.slpTpCd = slpTpCd;
        this.slpSerNo = slpSerNo;
        this.loclCurrCd = loclCurrCd;
        this.actAmt = actAmt;
        this.rvsCmbFlg = rvsCmbFlg;
        this.rjctCmbFlg = rjctCmbFlg;
        this.invRevActAmt = invRevActAmt;
        this.invExpActAmt = invExpActAmt;
        this.stlRevActAmt = stlRevActAmt;
        this.stlExpActAmt = stlExpActAmt;
        this.creDt = creDt;
        this.creUsrId = creUsrId;
        this.updDt = updDt;
        this.updUsrId = updUsrId;
        this.acctgCrrCd = acctgCrrCd;
        this.prnrRefNo = prnrRefNo;
        this.rlaneCd = rlaneCd;
        this.chkCmbFlg = chkCmbFlg;
        this.dtlGrpKey = dtlGrpKey;
        this.custCd = custCd;
        this.vndrSeq = vndrSeq;
        this.custVndrCntCd = custVndrCntCd;
        this.custVndrSeq = custVndrSeq;
        this.custVndrEngNm = custVndrEngNm;
        this.chkDelFlg = chkDelFlg;
        this.csrNo = csrNo;
        this.aproFlg = aproFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("acct_yrmon", getAcctYrmon());
        this.hashColumns.put("jo_crr_cd", getJoCrrCd());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("slp_func_cd", getSlpFuncCd());
        this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
        this.hashColumns.put("slp_iss_dt", getSlpIssDt());
        this.hashColumns.put("slp_tp_cd", getSlpTpCd());
        this.hashColumns.put("slp_ser_no", getSlpSerNo());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("act_amt", getActAmt());
        this.hashColumns.put("rvs_cmb_flg", getRvsCmbFlg());
        this.hashColumns.put("rjct_cmb_flg", getRjctCmbFlg());
        this.hashColumns.put("inv_rev_act_amt", getInvRevActAmt());
        this.hashColumns.put("inv_exp_act_amt", getInvExpActAmt());
        this.hashColumns.put("stl_rev_act_amt", getStlRevActAmt());
        this.hashColumns.put("stl_exp_act_amt", getStlExpActAmt());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("acctg_crr_cd", getAcctgCrrCd());
        this.hashColumns.put("prnr_ref_no", getPrnrRefNo());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("chk_cmb_flg", getChkCmbFlg());
        this.hashColumns.put("dtl_grp_key", getDtlGrpKey());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("cust_vndr_cnt_cd", getCustVndrCntCd());
        this.hashColumns.put("cust_vndr_seq", getCustVndrSeq());
        this.hashColumns.put("cust_vndr_eng_nm", getCustVndrEngNm());
        this.hashColumns.put("chk_del_flg", getChkDelFlg());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("apro_flg", getAproFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("acct_yrmon", "acctYrmon");
        this.hashFields.put("jo_crr_cd", "joCrrCd");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("slp_func_cd", "slpFuncCd");
        this.hashFields.put("slp_ofc_cd", "slpOfcCd");
        this.hashFields.put("slp_iss_dt", "slpIssDt");
        this.hashFields.put("slp_tp_cd", "slpTpCd");
        this.hashFields.put("slp_ser_no", "slpSerNo");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("act_amt", "actAmt");
        this.hashFields.put("rvs_cmb_flg", "rvsCmbFlg");
        this.hashFields.put("rjct_cmb_flg", "rjctCmbFlg");
        this.hashFields.put("inv_rev_act_amt", "invRevActAmt");
        this.hashFields.put("inv_exp_act_amt", "invExpActAmt");
        this.hashFields.put("stl_rev_act_amt", "stlRevActAmt");
        this.hashFields.put("stl_exp_act_amt", "stlExpActAmt");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("acctg_crr_cd", "acctgCrrCd");
        this.hashFields.put("prnr_ref_no", "prnrRefNo");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("chk_cmb_flg", "chkCmbFlg");
        this.hashFields.put("dtl_grp_key", "dtlGrpKey");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("cust_vndr_cnt_cd", "custVndrCntCd");
        this.hashFields.put("cust_vndr_seq", "custVndrSeq");
        this.hashFields.put("cust_vndr_eng_nm", "custVndrEngNm");
        this.hashFields.put("chk_del_flg", "chkDelFlg");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("apro_flg", "aproFlg");
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
	 * @param String slpFuncCd
	 */
    public void setSlpFuncCd(String slpFuncCd) {
        this.slpFuncCd = slpFuncCd;
    }

    /**
	 * 
	 * @return String slpFuncCd
	 */
    public String getSlpFuncCd() {
        return this.slpFuncCd;
    }

    /**
	 *
	 * @param String slpOfcCd
	 */
    public void setSlpOfcCd(String slpOfcCd) {
        this.slpOfcCd = slpOfcCd;
    }

    /**
	 * 
	 * @return String slpOfcCd
	 */
    public String getSlpOfcCd() {
        return this.slpOfcCd;
    }

    /**
	 *
	 * @param String slpIssDt
	 */
    public void setSlpIssDt(String slpIssDt) {
        this.slpIssDt = slpIssDt;
    }

    /**
	 * 
	 * @return String slpIssDt
	 */
    public String getSlpIssDt() {
        return this.slpIssDt;
    }

    /**
	 *
	 * @param String slpTpCd
	 */
    public void setSlpTpCd(String slpTpCd) {
        this.slpTpCd = slpTpCd;
    }

    /**
	 * 
	 * @return String slpTpCd
	 */
    public String getSlpTpCd() {
        return this.slpTpCd;
    }

    /**
	 *
	 * @param String slpSerNo
	 */
    public void setSlpSerNo(String slpSerNo) {
        this.slpSerNo = slpSerNo;
    }

    /**
	 * 
	 * @return String slpSerNo
	 */
    public String getSlpSerNo() {
        return this.slpSerNo;
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
	 * @param String rvsCmbFlg
	 */
    public void setRvsCmbFlg(String rvsCmbFlg) {
        this.rvsCmbFlg = rvsCmbFlg;
    }

    /**
	 * 
	 * @return String rvsCmbFlg
	 */
    public String getRvsCmbFlg() {
        return this.rvsCmbFlg;
    }

    /**
	 *
	 * @param String rjctCmbFlg
	 */
    public void setRjctCmbFlg(String rjctCmbFlg) {
        this.rjctCmbFlg = rjctCmbFlg;
    }

    /**
	 * 
	 * @return String rjctCmbFlg
	 */
    public String getRjctCmbFlg() {
        return this.rjctCmbFlg;
    }

    /**
	 *
	 * @param String invRevActAmt
	 */
    public void setInvRevActAmt(String invRevActAmt) {
        this.invRevActAmt = invRevActAmt;
    }

    /**
	 * 
	 * @return String invRevActAmt
	 */
    public String getInvRevActAmt() {
        return this.invRevActAmt;
    }

    /**
	 *
	 * @param String invExpActAmt
	 */
    public void setInvExpActAmt(String invExpActAmt) {
        this.invExpActAmt = invExpActAmt;
    }

    /**
	 * 
	 * @return String invExpActAmt
	 */
    public String getInvExpActAmt() {
        return this.invExpActAmt;
    }

    /**
	 *
	 * @param String stlRevActAmt
	 */
    public void setStlRevActAmt(String stlRevActAmt) {
        this.stlRevActAmt = stlRevActAmt;
    }

    /**
	 * 
	 * @return String stlRevActAmt
	 */
    public String getStlRevActAmt() {
        return this.stlRevActAmt;
    }

    /**
	 *
	 * @param String stlExpActAmt
	 */
    public void setStlExpActAmt(String stlExpActAmt) {
        this.stlExpActAmt = stlExpActAmt;
    }

    /**
	 * 
	 * @return String stlExpActAmt
	 */
    public String getStlExpActAmt() {
        return this.stlExpActAmt;
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

    public void setAcctgCrrCd(String acctgCrrCd) {
        this.acctgCrrCd = acctgCrrCd;
    }

    public String getAcctgCrrCd() {
        return this.acctgCrrCd;
    }

    public void setPrnrRefNo(String prnrRefNo) {
        this.prnrRefNo = prnrRefNo;
    }

    public String getPrnrRefNo() {
        return this.prnrRefNo;
    }

    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    public String getRlaneCd() {
        return this.rlaneCd;
    }

    public void setChkCmbFlg(String chkCmbFlg) {
        this.chkCmbFlg = chkCmbFlg;
    }

    public String getChkCmbFlg() {
        return this.chkCmbFlg;
    }

    public void setDtlGrpKey(String dtlGrpKey) {
        this.dtlGrpKey = dtlGrpKey;
    }

    public String getDtlGrpKey() {
        return this.dtlGrpKey;
    }

    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    public String getCustCd() {
        return this.custCd;
    }

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
    }

    public void setCustVndrCntCd(String custVndrCntCd) {
        this.custVndrCntCd = custVndrCntCd;
    }

    public String getCustVndrCntCd() {
        return this.custVndrCntCd;
    }

    public void setCustVndrSeq(String custVndrSeq) {
        this.custVndrSeq = custVndrSeq;
    }

    public String getCustVndrSeq() {
        return this.custVndrSeq;
    }

    public void setCustVndrEngNm(String custVndrEngNm) {
        this.custVndrEngNm = custVndrEngNm;
    }

    public String getCustVndrEngNm() {
        return this.custVndrEngNm;
    }

    public void setChkDelFlg(String chkDelFlg) {
        this.chkDelFlg = chkDelFlg;
    }

    public String getChkDelFlg() {
        return this.chkDelFlg;
    }

    public void setCsrNo(String csrNo) {
        this.csrNo = csrNo;
    }

    public String getCsrNo() {
        return this.csrNo;
    }

    public void setAproFlg(String aproFlg) {
        this.aproFlg = aproFlg;
    }

    public String getAproFlg() {
        return this.aproFlg;
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
        setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
        setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
        setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
        setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
        setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
        setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
        setRvsCmbFlg(JSPUtil.getParameter(request, prefix + "rvs_cmb_flg", ""));
        setRjctCmbFlg(JSPUtil.getParameter(request, prefix + "rjct_cmb_flg", ""));
        setInvRevActAmt(JSPUtil.getParameter(request, prefix + "inv_rev_act_amt", ""));
        setInvExpActAmt(JSPUtil.getParameter(request, prefix + "inv_exp_act_amt", ""));
        setStlRevActAmt(JSPUtil.getParameter(request, prefix + "stl_rev_act_amt", ""));
        setStlExpActAmt(JSPUtil.getParameter(request, prefix + "stl_exp_act_amt", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setAcctgCrrCd(JSPUtil.getParameter(request, prefix + "acctg_crr_cd", ""));
        setPrnrRefNo(JSPUtil.getParameter(request, prefix + "prnr_ref_no", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setChkCmbFlg(JSPUtil.getParameter(request, prefix + "chk_cmb_flg", ""));
        setDtlGrpKey(JSPUtil.getParameter(request, prefix + "dtl_grp_key", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setCustVndrCntCd(JSPUtil.getParameter(request, prefix + "cust_vndr_cnt_cd", ""));
        setCustVndrSeq(JSPUtil.getParameter(request, prefix + "cust_vndr_seq", ""));
        setCustVndrEngNm(JSPUtil.getParameter(request, prefix + "cust_vndr_eng_nm", ""));
        setChkDelFlg(JSPUtil.getParameter(request, prefix + "chk_del_flg", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceVO[]
	 */
    public InvoiceVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceVO[]
	 */
    public InvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InvoiceVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] slpFuncCd = (JSPUtil.getParameter(request, prefix + "slp_func_cd", length));
            String[] slpOfcCd = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd", length));
            String[] slpIssDt = (JSPUtil.getParameter(request, prefix + "slp_iss_dt", length));
            String[] slpTpCd = (JSPUtil.getParameter(request, prefix + "slp_tp_cd", length));
            String[] slpSerNo = (JSPUtil.getParameter(request, prefix + "slp_ser_no", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] actAmt = (JSPUtil.getParameter(request, prefix + "act_amt", length));
            String[] rvsCmbFlg = (JSPUtil.getParameter(request, prefix + "rvs_cmb_flg", length));
            String[] rjctCmbFlg = (JSPUtil.getParameter(request, prefix + "rjct_cmb_flg", length));
            String[] invRevActAmt = (JSPUtil.getParameter(request, prefix + "inv_rev_act_amt", length));
            String[] invExpActAmt = (JSPUtil.getParameter(request, prefix + "inv_exp_act_amt", length));
            String[] stlRevActAmt = (JSPUtil.getParameter(request, prefix + "stl_rev_act_amt", length));
            String[] stlExpActAmt = (JSPUtil.getParameter(request, prefix + "stl_exp_act_amt", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] acctgCrrCd = (JSPUtil.getParameter(request, prefix + "acctg_crr_cd", length));
            String[] prnrRefNo = (JSPUtil.getParameter(request, prefix + "prnr_ref_no", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] chkCmbFlg = (JSPUtil.getParameter(request, prefix + "chk_cmb_flg", length));
            String[] dtlGrpKey = (JSPUtil.getParameter(request, prefix + "dtl_grp_key", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] custVndrCntCd = (JSPUtil.getParameter(request, prefix + "cust_vndr_cnt_cd", length));
            String[] custVndrSeq = (JSPUtil.getParameter(request, prefix + "cust_vndr_seq", length));
            String[] custVndrEngNm = (JSPUtil.getParameter(request, prefix + "cust_vndr_eng_nm", length));
            String[] chkDelFlg = (JSPUtil.getParameter(request, prefix + "chk_del_flg", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
	    	String[] aproFlg = (JSPUtil.getParameter(request, prefix + "apro_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InvoiceVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (slpFuncCd[i] != null)
                    model.setSlpFuncCd(slpFuncCd[i]);
                if (slpOfcCd[i] != null)
                    model.setSlpOfcCd(slpOfcCd[i]);
                if (slpIssDt[i] != null)
                    model.setSlpIssDt(slpIssDt[i]);
                if (slpTpCd[i] != null)
                    model.setSlpTpCd(slpTpCd[i]);
                if (slpSerNo[i] != null)
                    model.setSlpSerNo(slpSerNo[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (actAmt[i] != null)
                    model.setActAmt(actAmt[i]);
                if (rvsCmbFlg[i] != null)
                    model.setRvsCmbFlg(rvsCmbFlg[i]);
                if (rjctCmbFlg[i] != null)
                    model.setRjctCmbFlg(rjctCmbFlg[i]);
                if (invRevActAmt[i] != null)
                    model.setInvRevActAmt(invRevActAmt[i]);
                if (invExpActAmt[i] != null)
                    model.setInvExpActAmt(invExpActAmt[i]);
                if (stlRevActAmt[i] != null)
                    model.setStlRevActAmt(stlRevActAmt[i]);
                if (stlExpActAmt[i] != null)
                    model.setStlExpActAmt(stlExpActAmt[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (acctgCrrCd[i] != null)
                    model.setAcctgCrrCd(acctgCrrCd[i]);
                if (prnrRefNo[i] != null)
                    model.setPrnrRefNo(prnrRefNo[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (chkCmbFlg[i] != null)
                    model.setChkCmbFlg(chkCmbFlg[i]);
                if (dtlGrpKey[i] != null)
                    model.setDtlGrpKey(dtlGrpKey[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (custVndrCntCd[i] != null)
                    model.setCustVndrCntCd(custVndrCntCd[i]);
                if (custVndrSeq[i] != null)
                    model.setCustVndrSeq(custVndrSeq[i]);
                if (custVndrEngNm[i] != null)
                    model.setCustVndrEngNm(custVndrEngNm[i]);
                if (chkDelFlg[i] != null)
                    model.setChkDelFlg(chkDelFlg[i]);
                if (csrNo[i] != null) 
		    		model.setCsrNo(csrNo[i]);
				if (aproFlg[i] != null) 
		    		model.setAproFlg(aproFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInvoiceVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InvoiceVO[]
	 */
    public InvoiceVO[] getInvoiceVOs() {
        InvoiceVO[] vos = (InvoiceVO[]) models.toArray(new InvoiceVO[models.size()]);
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
        this.acctYrmon = this.acctYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joCrrCd = this.joCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpFuncCd = this.slpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd = this.slpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpIssDt = this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpTpCd = this.slpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpSerNo = this.slpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actAmt = this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvsCmbFlg = this.rvsCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rjctCmbFlg = this.rjctCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRevActAmt = this.invRevActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invExpActAmt = this.invExpActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlRevActAmt = this.stlRevActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlExpActAmt = this.stlExpActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctgCrrCd = this.acctgCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrRefNo = this.prnrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCmbFlg = this.chkCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dtlGrpKey = this.dtlGrpKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custVndrCntCd = this.custVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custVndrSeq = this.custVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custVndrEngNm = this.custVndrEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkDelFlg = this.chkDelFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproFlg = this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
