/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ActualDetailVO.java
*@FileTitle : ActualDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
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
public class ActualDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ActualDetailVO> models = new ArrayList<ActualDetailVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String acctYrmon = null;

    /* Column Info */
    private String joCrrCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String invNo = null;

    /* Column Info */
    private String reDivrCd = null;

    /* Column Info */
    private String csrNo = null;

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
    private String slpSeqNo = null;

    /* Column Info */
    private String acctgCrrCd = null;

    /* Column Info */
    private String loclCurrCd = null;

    /* Column Info */
    private String actAmt = null;

    /* Column Info */
    private String invActAmt = null;

    /* Column Info */
    private String slpActAmt = null;

    /* Column Info */
    private String prnrRefNo = null;

    /* Column Info */
    private String prnrRefNm = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String revDirCd = null;

    /* Column Info */
    private String revVvd = null;

    /* Column Info */
    private String revYrmon = null;

    /* Column Info */
    private String stlRmk = null;

    /* Column Info */
    private String aproFlg = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String joStlItmCd = null;

    /* Column Info */
    private String joStlItmNm = null;

    /* Column Info */
    private String dataTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public ActualDetailVO() {
    }

    public ActualDetailVO(String ibflag, String pagerows, String acctYrmon, String joCrrCd, String rlaneCd, String invNo, String reDivrCd, String csrNo, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpTpCd, String slpSerNo, String slpSeqNo, String acctgCrrCd, String loclCurrCd, String actAmt, String invActAmt, String slpActAmt, String prnrRefNo, String prnrRefNm, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String revVvd, String revYrmon, String stlRmk, String aproFlg, String creUsrId, String creDt, String updUsrId, String updDt, String joStlItmCd, String joStlItmNm, String dataTpCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.acctYrmon = acctYrmon;
        this.joCrrCd = joCrrCd;
        this.rlaneCd = rlaneCd;
        this.invNo = invNo;
        this.reDivrCd = reDivrCd;
        this.csrNo = csrNo;
        this.slpFuncCd = slpFuncCd;
        this.slpOfcCd = slpOfcCd;
        this.slpIssDt = slpIssDt;
        this.slpTpCd = slpTpCd;
        this.slpSerNo = slpSerNo;
        this.slpSeqNo = slpSeqNo;
        this.acctgCrrCd = acctgCrrCd;
        this.loclCurrCd = loclCurrCd;
        this.actAmt = actAmt;
        this.invActAmt = invActAmt;
        this.slpActAmt = slpActAmt;
        this.prnrRefNo = prnrRefNo;
        this.prnrRefNm = prnrRefNm;
        this.vslCd = vslCd;
        this.skdVoyNo = skdVoyNo;
        this.skdDirCd = skdDirCd;
        this.revDirCd = revDirCd;
        this.revVvd = revVvd;
        this.revYrmon = revYrmon;
        this.stlRmk = stlRmk;
        this.aproFlg = aproFlg;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.joStlItmCd = joStlItmCd;
        this.joStlItmNm = joStlItmNm;
        this.dataTpCd = dataTpCd;
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
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("inv_no", getInvNo());
        this.hashColumns.put("re_divr_cd", getReDivrCd());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("slp_func_cd", getSlpFuncCd());
        this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
        this.hashColumns.put("slp_iss_dt", getSlpIssDt());
        this.hashColumns.put("slp_tp_cd", getSlpTpCd());
        this.hashColumns.put("slp_ser_no", getSlpSerNo());
        this.hashColumns.put("slp_seq_no", getSlpSeqNo());
        this.hashColumns.put("acctg_crr_cd", getAcctgCrrCd());
        this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
        this.hashColumns.put("act_amt", getActAmt());
        this.hashColumns.put("inv_act_amt", getInvActAmt());
        this.hashColumns.put("slp_act_amt", getSlpActAmt());
        this.hashColumns.put("prnr_ref_no", getPrnrRefNo());
        this.hashColumns.put("prnr_ref_nm", getPrnrRefNm());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("rev_vvd", getRevVvd());
        this.hashColumns.put("rev_yrmon", getRevYrmon());
        this.hashColumns.put("stl_rmk", getStlRmk());
        this.hashColumns.put("apro_flg", getAproFlg());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
        this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
        this.hashColumns.put("data_tp_cd", getDataTpCd());
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
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("inv_no", "invNo");
        this.hashFields.put("re_divr_cd", "reDivrCd");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("slp_func_cd", "slpFuncCd");
        this.hashFields.put("slp_ofc_cd", "slpOfcCd");
        this.hashFields.put("slp_iss_dt", "slpIssDt");
        this.hashFields.put("slp_tp_cd", "slpTpCd");
        this.hashFields.put("slp_ser_no", "slpSerNo");
        this.hashFields.put("slp_seq_no", "slpSeqNo");
        this.hashFields.put("acctg_crr_cd", "acctgCrrCd");
        this.hashFields.put("locl_curr_cd", "loclCurrCd");
        this.hashFields.put("act_amt", "actAmt");
        this.hashFields.put("inv_act_amt", "invActAmt");
        this.hashFields.put("slp_act_amt", "slpActAmt");
        this.hashFields.put("prnr_ref_no", "prnrRefNo");
        this.hashFields.put("prnr_ref_nm", "prnrRefNm");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("rev_vvd", "revVvd");
        this.hashFields.put("rev_yrmon", "revYrmon");
        this.hashFields.put("stl_rmk", "stlRmk");
        this.hashFields.put("apro_flg", "aproFlg");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
        this.hashFields.put("jo_stl_itm_nm", "joStlItmNm");
        this.hashFields.put("data_tp_cd", "dataTpCd");
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
	 * @param String slpSeqNo
	 */
    public void setSlpSeqNo(String slpSeqNo) {
        this.slpSeqNo = slpSeqNo;
    }

    /**
	 * 
	 * @return String slpSeqNo
	 */
    public String getSlpSeqNo() {
        return this.slpSeqNo;
    }

    /**
	 *
	 * @param String acctgCrrCd
	 */
    public void setAcctgCrrCd(String acctgCrrCd) {
        this.acctgCrrCd = acctgCrrCd;
    }

    /**
	 * 
	 * @return String acctgCrrCd
	 */
    public String getAcctgCrrCd() {
        return this.acctgCrrCd;
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
	 * @param String invActAmt
	 */
    public void setInvActAmt(String invActAmt) {
        this.invActAmt = invActAmt;
    }

    /**
	 * 
	 * @return String invActAmt
	 */
    public String getInvActAmt() {
        return this.invActAmt;
    }

    /**
	 *
	 * @param String slpActAmt
	 */
    public void setSlpActAmt(String slpActAmt) {
        this.slpActAmt = slpActAmt;
    }

    /**
	 * 
	 * @return String slpActAmt
	 */
    public String getSlpActAmt() {
        return this.slpActAmt;
    }

    /**
	 *
	 * @param String prnrRefNo
	 */
    public void setPrnrRefNo(String prnrRefNo) {
        this.prnrRefNo = prnrRefNo;
    }

    /**
	 * 
	 * @return String prnrRefNo
	 */
    public String getPrnrRefNo() {
        return this.prnrRefNo;
    }

    /**
	 *
	 * @param String prnrRefNm
	 */
    public void setPrnrRefNm(String prnrRefNm) {
        this.prnrRefNm = prnrRefNm;
    }

    /**
	 * 
	 * @return String prnrRefNm
	 */
    public String getPrnrRefNm() {
        return this.prnrRefNm;
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
	 * @param String aproFlg
	 */
    public void setAproFlg(String aproFlg) {
        this.aproFlg = aproFlg;
    }

    /**
	 * 
	 * @return String aproFlg
	 */
    public String getAproFlg() {
        return this.aproFlg;
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

    public void setDataTpCd(String dataTpCd) {
        this.dataTpCd = dataTpCd;
    }

    public String getDataTpCd() {
        return this.dataTpCd;
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
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
        setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
        setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
        setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
        setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
        setSlpSerNo(JSPUtil.getParameter(request, prefix + "slp_ser_no", ""));
        setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
        setAcctgCrrCd(JSPUtil.getParameter(request, prefix + "acctg_crr_cd", ""));
        setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
        setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
        setInvActAmt(JSPUtil.getParameter(request, prefix + "inv_act_amt", ""));
        setSlpActAmt(JSPUtil.getParameter(request, prefix + "slp_act_amt", ""));
        setPrnrRefNo(JSPUtil.getParameter(request, prefix + "prnr_ref_no", ""));
        setPrnrRefNm(JSPUtil.getParameter(request, prefix + "prnr_ref_nm", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
        setRevVvd(JSPUtil.getParameter(request, prefix + "rev_vvd", ""));
        setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
        setStlRmk(JSPUtil.getParameter(request, prefix + "stl_rmk", ""));
        setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
        setJoStlItmNm(JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", ""));
        setDataTpCd(JSPUtil.getParameter(request, prefix + "data_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActualDetailVO[]
	 */
    public ActualDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActualDetailVO[]
	 */
    public ActualDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ActualDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] acctYrmon = (JSPUtil.getParameter(request, prefix + "acct_yrmon", length));
            String[] joCrrCd = (JSPUtil.getParameter(request, prefix + "jo_crr_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] invNo = (JSPUtil.getParameter(request, prefix + "inv_no", length));
            String[] reDivrCd = (JSPUtil.getParameter(request, prefix + "re_divr_cd", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] slpFuncCd = (JSPUtil.getParameter(request, prefix + "slp_func_cd", length));
            String[] slpOfcCd = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd", length));
            String[] slpIssDt = (JSPUtil.getParameter(request, prefix + "slp_iss_dt", length));
            String[] slpTpCd = (JSPUtil.getParameter(request, prefix + "slp_tp_cd", length));
            String[] slpSerNo = (JSPUtil.getParameter(request, prefix + "slp_ser_no", length));
            String[] slpSeqNo = (JSPUtil.getParameter(request, prefix + "slp_seq_no", length));
            String[] acctgCrrCd = (JSPUtil.getParameter(request, prefix + "acctg_crr_cd", length));
            String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
            String[] actAmt = (JSPUtil.getParameter(request, prefix + "act_amt", length));
            String[] invActAmt = (JSPUtil.getParameter(request, prefix + "inv_act_amt", length));
            String[] slpActAmt = (JSPUtil.getParameter(request, prefix + "slp_act_amt", length));
            String[] prnrRefNo = (JSPUtil.getParameter(request, prefix + "prnr_ref_no", length));
            String[] prnrRefNm = (JSPUtil.getParameter(request, prefix + "prnr_ref_nm", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] revVvd = (JSPUtil.getParameter(request, prefix + "rev_vvd", length));
            String[] revYrmon = (JSPUtil.getParameter(request, prefix + "rev_yrmon", length));
            String[] stlRmk = (JSPUtil.getParameter(request, prefix + "stl_rmk", length));
            String[] aproFlg = (JSPUtil.getParameter(request, prefix + "apro_flg", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] joStlItmCd = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", length));
            String[] joStlItmNm = (JSPUtil.getParameter(request, prefix + "jo_stl_itm_nm", length));
            String[] dataTpCd = (JSPUtil.getParameter(request, prefix + "data_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ActualDetailVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (acctYrmon[i] != null)
                    model.setAcctYrmon(acctYrmon[i]);
                if (joCrrCd[i] != null)
                    model.setJoCrrCd(joCrrCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (invNo[i] != null)
                    model.setInvNo(invNo[i]);
                if (reDivrCd[i] != null)
                    model.setReDivrCd(reDivrCd[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
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
                if (slpSeqNo[i] != null)
                    model.setSlpSeqNo(slpSeqNo[i]);
                if (acctgCrrCd[i] != null)
                    model.setAcctgCrrCd(acctgCrrCd[i]);
                if (loclCurrCd[i] != null)
                    model.setLoclCurrCd(loclCurrCd[i]);
                if (actAmt[i] != null)
                    model.setActAmt(actAmt[i]);
                if (invActAmt[i] != null)
                    model.setInvActAmt(invActAmt[i]);
                if (slpActAmt[i] != null)
                    model.setSlpActAmt(slpActAmt[i]);
                if (prnrRefNo[i] != null)
                    model.setPrnrRefNo(prnrRefNo[i]);
                if (prnrRefNm[i] != null)
                    model.setPrnrRefNm(prnrRefNm[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (revVvd[i] != null)
                    model.setRevVvd(revVvd[i]);
                if (revYrmon[i] != null)
                    model.setRevYrmon(revYrmon[i]);
                if (stlRmk[i] != null)
                    model.setStlRmk(stlRmk[i]);
                if (aproFlg[i] != null)
                    model.setAproFlg(aproFlg[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (joStlItmCd[i] != null)
                    model.setJoStlItmCd(joStlItmCd[i]);
                if (joStlItmNm[i] != null)
                    model.setJoStlItmNm(joStlItmNm[i]);
                if (dataTpCd[i] != null) 
		    		model.setDataTpCd(dataTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getActualDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ActualDetailVO[]
	 */
    public ActualDetailVO[] getActualDetailVOs() {
        ActualDetailVO[] vos = (ActualDetailVO[]) models.toArray(new ActualDetailVO[models.size()]);
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
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNo = this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.reDivrCd = this.reDivrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpFuncCd = this.slpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd = this.slpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpIssDt = this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpTpCd = this.slpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpSerNo = this.slpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpSeqNo = this.slpSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctgCrrCd = this.acctgCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actAmt = this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invActAmt = this.invActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpActAmt = this.slpActAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrRefNo = this.prnrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrRefNm = this.prnrRefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revVvd = this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revYrmon = this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stlRmk = this.stlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproFlg = this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmCd = this.joStlItmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.joStlItmNm = this.joStlItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dataTpCd = this.dataTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
