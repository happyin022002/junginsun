/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccrualVerificationVO.java
*@FileTitle : AccrualVerificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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
public class AccrualVerificationVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<AccrualVerificationVO> models = new ArrayList<AccrualVerificationVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String mdlTpCd = null;

    /* Column Info */
    private String actYrmon = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String acctNm = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String trdNm = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String acclEstmUsd = null;

    /* Column Info */
    private String acclActUsd = null;

    /* Column Info */
    private String acclAcclUsd = null;

    /* Column Info */
    private String acclEstmLocl = null;

    /* Column Info */
    private String acclActLocl = null;

    /* Column Info */
    private String acclAcclLocl = null;

    /* Column Info */
    private String trgtEstmUsd = null;

    /* Column Info */
    private String trgtActUsd = null;

    /* Column Info */
    private String trgtAcclUsd = null;

    /* Column Info */
    private String trgtEstmLocl = null;

    /* Column Info */
    private String trgtActLocl = null;

    /* Column Info */
    private String trgtAcclLocl = null;

    /* Column Info */
    private String acclYrmon = null;

    /* Column Info */
    private String exeYrmon = null;

    /* Column Info */
    private String pfitctrCd = null;

    /* Column Info */
    private String glAcctNo = null;

    /* Column Info */
    private String acclDocAmt = null;

    /* Column Info */
    private String acclLoclAmt = null;

    /* Column Info */
    private String oprDocAmt = null;

    /* Column Info */
    private String oprLoclAmt = null;

    /* Column Info */
    private String jobFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public AccrualVerificationVO() {
    }

    public AccrualVerificationVO(String ibflag, String pagerows, String mdlTpCd, String actYrmon, String acctCd, String acctNm, String trdCd, String trdNm, String loclCurrCd, String acclEstmUsd, String acclActUsd, String acclAcclUsd, String acclEstmLocl, String acclActLocl, String acclAcclLocl, String trgtEstmUsd, String trgtActUsd, String trgtAcclUsd, String trgtEstmLocl, String trgtActLocl, String trgtAcclLocl, String acclYrmon, String exeYrmon, String pfitctrCd, String glAcctNo, String acclDocAmt, String acclLoclAmt, String oprDocAmt, String oprLoclAmt, String jobFlg) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.mdlTpCd = mdlTpCd;
        this.actYrmon = actYrmon;
        this.acctCd = acctCd;
        this.acctNm = acctNm;
        this.trdCd = trdCd;
        this.trdNm = trdNm;
        this.loclCurrCd = loclCurrCd;
        this.acclEstmUsd = acclEstmUsd;
        this.acclActUsd = acclActUsd;
        this.acclAcclUsd = acclAcclUsd;
        this.acclEstmLocl = acclEstmLocl;
        this.acclActLocl = acclActLocl;
        this.acclAcclLocl = acclAcclLocl;
        this.trgtEstmUsd = trgtEstmUsd;
        this.trgtActUsd = trgtActUsd;
        this.trgtAcclUsd = trgtAcclUsd;
        this.trgtEstmLocl = trgtEstmLocl;
        this.trgtActLocl = trgtActLocl;
        this.trgtAcclLocl = trgtAcclLocl;
        this.acclYrmon = acclYrmon;
        this.exeYrmon = exeYrmon;
        this.pfitctrCd = pfitctrCd;
        this.glAcctNo = glAcctNo;
        this.acclDocAmt = acclDocAmt;
        this.acclLoclAmt = acclLoclAmt;
        this.oprDocAmt = oprDocAmt;
        this.oprLoclAmt = oprLoclAmt;
        this.jobFlg = jobFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("mdl_tp_cd", getMdlTpCd());
        this.hashColumns.put("act_yrmon", getActYrmon());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("acct_nm", getAcctNm());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("trd_nm", getTrdNm());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("accl_estm_usd", getAcclEstmUsd());
        this.hashColumns.put("accl_act_usd", getAcclActUsd());
        this.hashColumns.put("accl_accl_usd", getAcclAcclUsd());
        this.hashColumns.put("accl_estm_locl", getAcclEstmLocl());
        this.hashColumns.put("accl_act_locl", getAcclActLocl());
        this.hashColumns.put("accl_accl_locl", getAcclAcclLocl());
        this.hashColumns.put("trgt_estm_usd", getTrgtEstmUsd());
        this.hashColumns.put("trgt_act_usd", getTrgtActUsd());
        this.hashColumns.put("trgt_accl_usd", getTrgtAcclUsd());
        this.hashColumns.put("trgt_estm_locl", getTrgtEstmLocl());
        this.hashColumns.put("trgt_act_locl", getTrgtActLocl());
        this.hashColumns.put("trgt_accl_locl", getTrgtAcclLocl());
        this.hashColumns.put("accl_yrmon", getAcclYrmon());
        this.hashColumns.put("exe_yrmon", getExeYrmon());
        this.hashColumns.put("pfitctr_cd", getPfitctrCd());
        this.hashColumns.put("gl_acct_no", getGlAcctNo());
        this.hashColumns.put("accl_doc_amt", getAcclDocAmt());
        this.hashColumns.put("accl_locl_amt", getAcclLoclAmt());
        this.hashColumns.put("opr_doc_amt", getOprDocAmt());
        this.hashColumns.put("opr_locl_amt", getOprLoclAmt());
        this.hashColumns.put("job_flg", getJobFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("mdl_tp_cd", "mdlTpCd");
        this.hashFields.put("act_yrmon", "actYrmon");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("acct_nm", "acctNm");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("trd_nm", "trdNm");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("accl_estm_usd", "acclEstmUsd");
        this.hashFields.put("accl_act_usd", "acclActUsd");
        this.hashFields.put("accl_accl_usd", "acclAcclUsd");
        this.hashFields.put("accl_estm_locl", "acclEstmLocl");
        this.hashFields.put("accl_act_locl", "acclActLocl");
        this.hashFields.put("accl_accl_locl", "acclAcclLocl");
        this.hashFields.put("trgt_estm_usd", "trgtEstmUsd");
        this.hashFields.put("trgt_act_usd", "trgtActUsd");
        this.hashFields.put("trgt_accl_usd", "trgtAcclUsd");
        this.hashFields.put("trgt_estm_locl", "trgtEstmLocl");
        this.hashFields.put("trgt_act_locl", "trgtActLocl");
        this.hashFields.put("trgt_accl_locl", "trgtAcclLocl");
        this.hashFields.put("accl_yrmon", "acclYrmon");
        this.hashFields.put("exe_yrmon", "exeYrmon");
        this.hashFields.put("pfitctr_cd", "pfitctrCd");
        this.hashFields.put("gl_acct_no", "glAcctNo");
        this.hashFields.put("accl_doc_amt", "acclDocAmt");
        this.hashFields.put("accl_locl_amt", "acclLoclAmt");
        this.hashFields.put("opr_doc_amt", "oprDocAmt");
        this.hashFields.put("opr_locl_amt", "oprLoclAmt");
        this.hashFields.put("job_flg", "jobFlg");
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
	 * @param String mdlTpCd
	 */
    public void setMdlTpCd(String mdlTpCd) {
        this.mdlTpCd = mdlTpCd;
    }

    /**
	 * 
	 * @return String mdlTpCd
	 */
    public String getMdlTpCd() {
        return this.mdlTpCd;
    }

    /**
	 *
	 * @param String actYrmon
	 */
    public void setActYrmon(String actYrmon) {
        this.actYrmon = actYrmon;
    }

    /**
	 * 
	 * @return String actYrmon
	 */
    public String getActYrmon() {
        return this.actYrmon;
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
	 * @param String acctNm
	 */
    public void setAcctNm(String acctNm) {
        this.acctNm = acctNm;
    }

    /**
	 * 
	 * @return String acctNm
	 */
    public String getAcctNm() {
        return this.acctNm;
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
	 * @param String trdNm
	 */
    public void setTrdNm(String trdNm) {
        this.trdNm = trdNm;
    }

    /**
	 * 
	 * @return String trdNm
	 */
    public String getTrdNm() {
        return this.trdNm;
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
	 * @param String acclEstmUsd
	 */
    public void setAcclEstmUsd(String acclEstmUsd) {
        this.acclEstmUsd = acclEstmUsd;
    }

    /**
	 * 
	 * @return String acclEstmUsd
	 */
    public String getAcclEstmUsd() {
        return this.acclEstmUsd;
    }

    /**
	 *
	 * @param String acclActUsd
	 */
    public void setAcclActUsd(String acclActUsd) {
        this.acclActUsd = acclActUsd;
    }

    /**
	 * 
	 * @return String acclActUsd
	 */
    public String getAcclActUsd() {
        return this.acclActUsd;
    }

    /**
	 *
	 * @param String acclAcclUsd
	 */
    public void setAcclAcclUsd(String acclAcclUsd) {
        this.acclAcclUsd = acclAcclUsd;
    }

    /**
	 * 
	 * @return String acclAcclUsd
	 */
    public String getAcclAcclUsd() {
        return this.acclAcclUsd;
    }

    /**
	 *
	 * @param String acclEstmLocl
	 */
    public void setAcclEstmLocl(String acclEstmLocl) {
        this.acclEstmLocl = acclEstmLocl;
    }

    /**
	 * 
	 * @return String acclEstmLocl
	 */
    public String getAcclEstmLocl() {
        return this.acclEstmLocl;
    }

    /**
	 *
	 * @param String acclActLocl
	 */
    public void setAcclActLocl(String acclActLocl) {
        this.acclActLocl = acclActLocl;
    }

    /**
	 * 
	 * @return String acclActLocl
	 */
    public String getAcclActLocl() {
        return this.acclActLocl;
    }

    /**
	 *
	 * @param String acclAcclLocl
	 */
    public void setAcclAcclLocl(String acclAcclLocl) {
        this.acclAcclLocl = acclAcclLocl;
    }

    /**
	 * 
	 * @return String acclAcclLocl
	 */
    public String getAcclAcclLocl() {
        return this.acclAcclLocl;
    }

    /**
	 *
	 * @param String trgtEstmUsd
	 */
    public void setTrgtEstmUsd(String trgtEstmUsd) {
        this.trgtEstmUsd = trgtEstmUsd;
    }

    /**
	 * 
	 * @return String trgtEstmUsd
	 */
    public String getTrgtEstmUsd() {
        return this.trgtEstmUsd;
    }

    /**
	 *
	 * @param String trgtActUsd
	 */
    public void setTrgtActUsd(String trgtActUsd) {
        this.trgtActUsd = trgtActUsd;
    }

    /**
	 * 
	 * @return String trgtActUsd
	 */
    public String getTrgtActUsd() {
        return this.trgtActUsd;
    }

    /**
	 *
	 * @param String trgtAcclUsd
	 */
    public void setTrgtAcclUsd(String trgtAcclUsd) {
        this.trgtAcclUsd = trgtAcclUsd;
    }

    /**
	 * 
	 * @return String trgtAcclUsd
	 */
    public String getTrgtAcclUsd() {
        return this.trgtAcclUsd;
    }

    /**
	 *
	 * @param String trgtEstmLocl
	 */
    public void setTrgtEstmLocl(String trgtEstmLocl) {
        this.trgtEstmLocl = trgtEstmLocl;
    }

    /**
	 * 
	 * @return String trgtEstmLocl
	 */
    public String getTrgtEstmLocl() {
        return this.trgtEstmLocl;
    }

    /**
	 *
	 * @param String trgtActLocl
	 */
    public void setTrgtActLocl(String trgtActLocl) {
        this.trgtActLocl = trgtActLocl;
    }

    /**
	 * 
	 * @return String trgtActLocl
	 */
    public String getTrgtActLocl() {
        return this.trgtActLocl;
    }

    /**
	 *
	 * @param String trgtAcclLocl
	 */
    public void setTrgtAcclLocl(String trgtAcclLocl) {
        this.trgtAcclLocl = trgtAcclLocl;
    }

    /**
	 * 
	 * @return String trgtAcclLocl
	 */
    public String getTrgtAcclLocl() {
        return this.trgtAcclLocl;
    }

    /**
	 *
	 * @param String acclYrmon
	 */
    public void setAcclYrmon(String acclYrmon) {
        this.acclYrmon = acclYrmon;
    }

    /**
	 * 
	 * @return String acclYrmon
	 */
    public String getAcclYrmon() {
        return this.acclYrmon;
    }

    public void setExeYrmon(String exeYrmon) {
        this.exeYrmon = exeYrmon;
    }

    public String getExeYrmon() {
        return this.exeYrmon;
    }

    public void setPfitctrCd(String pfitctrCd) {
        this.pfitctrCd = pfitctrCd;
    }

    public String getPfitctrCd() {
        return this.pfitctrCd;
    }

    public void setGlAcctNo(String glAcctNo) {
        this.glAcctNo = glAcctNo;
    }

    public String getGlAcctNo() {
        return this.glAcctNo;
    }

    public void setAcclDocAmt(String acclDocAmt) {
        this.acclDocAmt = acclDocAmt;
    }

    public String getAcclDocAmt() {
        return this.acclDocAmt;
    }

    public void setAcclLoclAmt(String acclLoclAmt) {
        this.acclLoclAmt = acclLoclAmt;
    }

    public String getAcclLoclAmt() {
        return this.acclLoclAmt;
    }

    public void setOprDocAmt(String oprDocAmt) {
        this.oprDocAmt = oprDocAmt;
    }

    public String getOprDocAmt() {
        return this.oprDocAmt;
    }

    public void setOprLoclAmt(String oprLoclAmt) {
        this.oprLoclAmt = oprLoclAmt;
    }

    public String getOprLoclAmt() {
        return this.oprLoclAmt;
    }

    public void setJobFlg(String jobFlg) {
        this.jobFlg = jobFlg;
    }

    public String getJobFlg() {
        return this.jobFlg;
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
        setMdlTpCd(JSPUtil.getParameter(request, prefix + "mdl_tp_cd", ""));
        setActYrmon(JSPUtil.getParameter(request, prefix + "act_yrmon", ""));
        setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
        setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setTrdNm(JSPUtil.getParameter(request, prefix + "trd_nm", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setAcclEstmUsd(JSPUtil.getParameter(request, prefix + "accl_estm_usd", ""));
        setAcclActUsd(JSPUtil.getParameter(request, prefix + "accl_act_usd", ""));
        setAcclAcclUsd(JSPUtil.getParameter(request, prefix + "accl_accl_usd", ""));
        setAcclEstmLocl(JSPUtil.getParameter(request, prefix + "accl_estm_locl", ""));
        setAcclActLocl(JSPUtil.getParameter(request, prefix + "accl_act_locl", ""));
        setAcclAcclLocl(JSPUtil.getParameter(request, prefix + "accl_accl_locl", ""));
        setTrgtEstmUsd(JSPUtil.getParameter(request, prefix + "trgt_estm_usd", ""));
        setTrgtActUsd(JSPUtil.getParameter(request, prefix + "trgt_act_usd", ""));
        setTrgtAcclUsd(JSPUtil.getParameter(request, prefix + "trgt_accl_usd", ""));
        setTrgtEstmLocl(JSPUtil.getParameter(request, prefix + "trgt_estm_locl", ""));
        setTrgtActLocl(JSPUtil.getParameter(request, prefix + "trgt_act_locl", ""));
        setTrgtAcclLocl(JSPUtil.getParameter(request, prefix + "trgt_accl_locl", ""));
        setAcclYrmon(JSPUtil.getParameter(request, prefix + "accl_yrmon", ""));
        setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
        setPfitctrCd(JSPUtil.getParameter(request, prefix + "pfitctr_cd", ""));
        setGlAcctNo(JSPUtil.getParameter(request, prefix + "gl_acct_no", ""));
        setAcclDocAmt(JSPUtil.getParameter(request, prefix + "accl_doc_amt", ""));
        setAcclLoclAmt(JSPUtil.getParameter(request, prefix + "accl_locl_amt", ""));
        setOprDocAmt(JSPUtil.getParameter(request, prefix + "opr_doc_amt", ""));
        setOprLoclAmt(JSPUtil.getParameter(request, prefix + "opr_locl_amt", ""));
        setJobFlg(JSPUtil.getParameter(request, prefix + "job_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccrualVerificationVO[]
	 */
    public AccrualVerificationVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AccrualVerificationVO[]
	 */
    public AccrualVerificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        AccrualVerificationVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] mdlTpCd = (JSPUtil.getParameter(request, prefix + "mdl_tp_cd", length));
            String[] actYrmon = (JSPUtil.getParameter(request, prefix + "act_yrmon", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] acctNm = (JSPUtil.getParameter(request, prefix + "acct_nm", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] trdNm = (JSPUtil.getParameter(request, prefix + "trd_nm", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] acclEstmUsd = (JSPUtil.getParameter(request, prefix + "accl_estm_usd", length));
            String[] acclActUsd = (JSPUtil.getParameter(request, prefix + "accl_act_usd", length));
            String[] acclAcclUsd = (JSPUtil.getParameter(request, prefix + "accl_accl_usd", length));
            String[] acclEstmLocl = (JSPUtil.getParameter(request, prefix + "accl_estm_locl", length));
            String[] acclActLocl = (JSPUtil.getParameter(request, prefix + "accl_act_locl", length));
            String[] acclAcclLocl = (JSPUtil.getParameter(request, prefix + "accl_accl_locl", length));
            String[] trgtEstmUsd = (JSPUtil.getParameter(request, prefix + "trgt_estm_usd", length));
            String[] trgtActUsd = (JSPUtil.getParameter(request, prefix + "trgt_act_usd", length));
            String[] trgtAcclUsd = (JSPUtil.getParameter(request, prefix + "trgt_accl_usd", length));
            String[] trgtEstmLocl = (JSPUtil.getParameter(request, prefix + "trgt_estm_locl", length));
            String[] trgtActLocl = (JSPUtil.getParameter(request, prefix + "trgt_act_locl", length));
            String[] trgtAcclLocl = (JSPUtil.getParameter(request, prefix + "trgt_accl_locl", length));
            String[] acclYrmon = (JSPUtil.getParameter(request, prefix + "accl_yrmon", length));
            String[] exeYrmon = (JSPUtil.getParameter(request, prefix + "exe_yrmon", length));
            String[] pfitctrCd = (JSPUtil.getParameter(request, prefix + "pfitctr_cd", length));
            String[] glAcctNo = (JSPUtil.getParameter(request, prefix + "gl_acct_no", length));
            String[] acclDocAmt = (JSPUtil.getParameter(request, prefix + "accl_doc_amt", length));
            String[] acclLoclAmt = (JSPUtil.getParameter(request, prefix + "accl_locl_amt", length));
            String[] oprDocAmt = (JSPUtil.getParameter(request, prefix + "opr_doc_amt", length));
            String[] oprLoclAmt = (JSPUtil.getParameter(request, prefix + "opr_locl_amt", length));
            String[] jobFlg = (JSPUtil.getParameter(request, prefix + "job_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new AccrualVerificationVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (mdlTpCd[i] != null)
                    model.setMdlTpCd(mdlTpCd[i]);
                if (actYrmon[i] != null)
                    model.setActYrmon(actYrmon[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (acctNm[i] != null)
                    model.setAcctNm(acctNm[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (trdNm[i] != null)
                    model.setTrdNm(trdNm[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (acclEstmUsd[i] != null)
                    model.setAcclEstmUsd(acclEstmUsd[i]);
                if (acclActUsd[i] != null)
                    model.setAcclActUsd(acclActUsd[i]);
                if (acclAcclUsd[i] != null)
                    model.setAcclAcclUsd(acclAcclUsd[i]);
                if (acclEstmLocl[i] != null)
                    model.setAcclEstmLocl(acclEstmLocl[i]);
                if (acclActLocl[i] != null)
                    model.setAcclActLocl(acclActLocl[i]);
                if (acclAcclLocl[i] != null)
                    model.setAcclAcclLocl(acclAcclLocl[i]);
                if (trgtEstmUsd[i] != null)
                    model.setTrgtEstmUsd(trgtEstmUsd[i]);
                if (trgtActUsd[i] != null)
                    model.setTrgtActUsd(trgtActUsd[i]);
                if (trgtAcclUsd[i] != null)
                    model.setTrgtAcclUsd(trgtAcclUsd[i]);
                if (trgtEstmLocl[i] != null)
                    model.setTrgtEstmLocl(trgtEstmLocl[i]);
                if (trgtActLocl[i] != null)
                    model.setTrgtActLocl(trgtActLocl[i]);
                if (trgtAcclLocl[i] != null)
                    model.setTrgtAcclLocl(trgtAcclLocl[i]);
                if (acclYrmon[i] != null)
                    model.setAcclYrmon(acclYrmon[i]);
                if (exeYrmon[i] != null)
                    model.setExeYrmon(exeYrmon[i]);
                if (pfitctrCd[i] != null)
                    model.setPfitctrCd(pfitctrCd[i]);
                if (glAcctNo[i] != null)
                    model.setGlAcctNo(glAcctNo[i]);
                if (acclDocAmt[i] != null)
                    model.setAcclDocAmt(acclDocAmt[i]);
                if (acclLoclAmt[i] != null)
                    model.setAcclLoclAmt(acclLoclAmt[i]);
                if (oprDocAmt[i] != null)
                    model.setOprDocAmt(oprDocAmt[i]);
                if (oprLoclAmt[i] != null)
                    model.setOprLoclAmt(oprLoclAmt[i]);
                if (jobFlg[i] != null) 
		    		model.setJobFlg(jobFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getAccrualVerificationVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return AccrualVerificationVO[]
	 */
    public AccrualVerificationVO[] getAccrualVerificationVOs() {
        AccrualVerificationVO[] vos = (AccrualVerificationVO[]) models.toArray(new AccrualVerificationVO[models.size()]);
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
        this.mdlTpCd = this.mdlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actYrmon = this.actYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctNm = this.acctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdNm = this.trdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclEstmUsd = this.acclEstmUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclActUsd = this.acclActUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclAcclUsd = this.acclAcclUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclEstmLocl = this.acclEstmLocl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclActLocl = this.acclActLocl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclAcclLocl = this.acclAcclLocl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trgtEstmUsd = this.trgtEstmUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trgtActUsd = this.trgtActUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trgtAcclUsd = this.trgtAcclUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trgtEstmLocl = this.trgtEstmLocl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trgtActLocl = this.trgtActLocl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trgtAcclLocl = this.trgtAcclLocl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclYrmon = this.acclYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.exeYrmon = this.exeYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pfitctrCd = this.pfitctrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.glAcctNo = this.glAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclDocAmt = this.acclDocAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acclLoclAmt = this.acclLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oprDocAmt = this.oprDocAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oprLoclAmt = this.oprLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.jobFlg = this.jobFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
