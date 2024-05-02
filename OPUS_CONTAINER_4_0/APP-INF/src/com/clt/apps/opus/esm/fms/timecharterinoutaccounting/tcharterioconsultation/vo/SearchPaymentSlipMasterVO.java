/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchPaymentSlipMasterVO.java
*@FileTitle : SearchPaymentSlipMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
public class SearchPaymentSlipMasterVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchPaymentSlipMasterVO> models = new ArrayList<SearchPaymentSlipMasterVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String balanceAmt = null;

    /* Column Info */
    private String drAmt = null;

    /* Column Info */
    private String fletCtrtTpCd = null;

    /* Column Info */
    private String csrCurrCd = null;

    /* Column Info */
    private String evidTpCd = null;

    /* Column Info */
    private String ppayHirNo = null;

    /* Column Info */
    private String chkAcctCd = null;

    /* Column Info */
    private String slpDesc = null;

    /* Column Info */
    private String vatSlpFuncCd = null;

    /* Column Info */
    private String fletCtrtNo = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String slpTp = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String vslEngNm = null;

    /* Column Info */
    private String usrNm = null;

    /* Column Info */
    private String ownrCd = null;

    /* Column Info */
    private String vatFlg = null;

    /* Column Info */
    private String usdLoclXchRt = null;

    /* Column Info */
    private String vatSlpTpCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String chkBunkerVvd = null;

    /* Column Info */
    private String csrNo = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String vatSlpIssDt = null;

    /* Column Info */
    private String slpOfcCd = null;

    /* Column Info */
    private String slpIssDt = null;

    /* Column Info */
    private String evidTpCdVal = null;

    /* Column Info */
    private String diffAmt = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String vatSlpSerNo = null;

    /* Column Info */
    private String chkCtrCd = null;

    /* Column Info */
    private String vatSlpOfcCd = null;

    /* Column Info */
    private String apCtrCd = null;

    /* Column Info */
    private String preWorkFlag = null;

    /* Column Info */
    private String autoFlg = null;

    /* Column Info */
    private String taxIssCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String custLglEngNm = null;

    /* Column Info */
    private String fletCtrtTpNm = null;

    /* Column Info */
    private String slpFuncCd = null;

    /* Column Info */
    private String slpTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchPaymentSlipMasterVO() {
    }

    public SearchPaymentSlipMasterVO(String ibflag, String pagerows, String vslCd, String balanceAmt, String drAmt, String fletCtrtTpCd, String csrCurrCd, String evidTpCd, String ppayHirNo, String chkAcctCd, String slpDesc, String vatSlpFuncCd, String fletCtrtNo, String locCd, String slpTp, String effDt, String vslEngNm, String usrNm, String ownrCd, String vatFlg, String usdLoclXchRt, String vatSlpTpCd, String updUsrId, String chkBunkerVvd, String csrNo, String rqstDt, String vatSlpIssDt, String slpOfcCd, String slpIssDt, String evidTpCdVal, String diffAmt, String creUsrId, String vatSlpSerNo, String chkCtrCd, String vatSlpOfcCd, String apCtrCd, String preWorkFlag, String autoFlg, String taxIssCd, String vndrSeq, String vndrLglEngNm, String custCntCd, String custSeq, String custLglEngNm, String fletCtrtTpNm, String slpFuncCd, String slpTpCd) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.vslCd = vslCd;
        this.balanceAmt = balanceAmt;
        this.drAmt = drAmt;
        this.fletCtrtTpCd = fletCtrtTpCd;
        this.csrCurrCd = csrCurrCd;
        this.evidTpCd = evidTpCd;
        this.ppayHirNo = ppayHirNo;
        this.chkAcctCd = chkAcctCd;
        this.slpDesc = slpDesc;
        this.vatSlpFuncCd = vatSlpFuncCd;
        this.fletCtrtNo = fletCtrtNo;
        this.locCd = locCd;
        this.slpTp = slpTp;
        this.effDt = effDt;
        this.vslEngNm = vslEngNm;
        this.usrNm = usrNm;
        this.ownrCd = ownrCd;
        this.vatFlg = vatFlg;
        this.usdLoclXchRt = usdLoclXchRt;
        this.vatSlpTpCd = vatSlpTpCd;
        this.updUsrId = updUsrId;
        this.chkBunkerVvd = chkBunkerVvd;
        this.csrNo = csrNo;
        this.rqstDt = rqstDt;
        this.vatSlpIssDt = vatSlpIssDt;
        this.slpOfcCd = slpOfcCd;
        this.slpIssDt = slpIssDt;
        this.evidTpCdVal = evidTpCdVal;
        this.diffAmt = diffAmt;
        this.creUsrId = creUsrId;
        this.vatSlpSerNo = vatSlpSerNo;
        this.chkCtrCd = chkCtrCd;
        this.vatSlpOfcCd = vatSlpOfcCd;
        this.apCtrCd = apCtrCd;
        this.preWorkFlag = preWorkFlag;
        this.autoFlg = autoFlg;
        this.taxIssCd = taxIssCd;
        this.vndrSeq = vndrSeq;
        this.vndrLglEngNm = vndrLglEngNm;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.custLglEngNm = custLglEngNm;
        this.fletCtrtTpNm = fletCtrtTpNm;
        this.slpFuncCd = slpFuncCd;
        this.slpTpCd = slpTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("balance_amt", getBalanceAmt());
        this.hashColumns.put("dr_amt", getDrAmt());
        this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
        this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
        this.hashColumns.put("evid_tp_cd", getEvidTpCd());
        this.hashColumns.put("ppay_hir_no", getPpayHirNo());
        this.hashColumns.put("chk_acct_cd", getChkAcctCd());
        this.hashColumns.put("slp_desc", getSlpDesc());
        this.hashColumns.put("vat_slp_func_cd", getVatSlpFuncCd());
        this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("slp_tp", getSlpTp());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("vsl_eng_nm", getVslEngNm());
        this.hashColumns.put("usr_nm", getUsrNm());
        this.hashColumns.put("ownr_cd", getOwnrCd());
        this.hashColumns.put("vat_flg", getVatFlg());
        this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
        this.hashColumns.put("vat_slp_tp_cd", getVatSlpTpCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("chk_bunker_vvd", getChkBunkerVvd());
        this.hashColumns.put("csr_no", getCsrNo());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("vat_slp_iss_dt", getVatSlpIssDt());
        this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
        this.hashColumns.put("slp_iss_dt", getSlpIssDt());
        this.hashColumns.put("evid_tp_cd_val", getEvidTpCdVal());
        this.hashColumns.put("diff_amt", getDiffAmt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("vat_slp_ser_no", getVatSlpSerNo());
        this.hashColumns.put("chk_ctr_cd", getChkCtrCd());
        this.hashColumns.put("vat_slp_ofc_cd", getVatSlpOfcCd());
        this.hashColumns.put("ap_ctr_cd", getApCtrCd());
        this.hashColumns.put("pre_work_flag", getPreWorkFlag());
        this.hashColumns.put("auto_flg", getAutoFlg());
        this.hashColumns.put("tax_iss_cd", getTaxIssCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
        this.hashColumns.put("flet_ctrt_tp_nm", getFletCtrtTpNm());
        this.hashColumns.put("slp_func_cd", getSlpFuncCd());
        this.hashColumns.put("slp_tp_cd", getSlpTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("balance_amt", "balanceAmt");
        this.hashFields.put("dr_amt", "drAmt");
        this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
        this.hashFields.put("csr_curr_cd", "csrCurrCd");
        this.hashFields.put("evid_tp_cd", "evidTpCd");
        this.hashFields.put("ppay_hir_no", "ppayHirNo");
        this.hashFields.put("chk_acct_cd", "chkAcctCd");
        this.hashFields.put("slp_desc", "slpDesc");
        this.hashFields.put("vat_slp_func_cd", "vatSlpFuncCd");
        this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("slp_tp", "slpTp");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("vsl_eng_nm", "vslEngNm");
        this.hashFields.put("usr_nm", "usrNm");
        this.hashFields.put("ownr_cd", "ownrCd");
        this.hashFields.put("vat_flg", "vatFlg");
        this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
        this.hashFields.put("vat_slp_tp_cd", "vatSlpTpCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("chk_bunker_vvd", "chkBunkerVvd");
        this.hashFields.put("csr_no", "csrNo");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("vat_slp_iss_dt", "vatSlpIssDt");
        this.hashFields.put("slp_ofc_cd", "slpOfcCd");
        this.hashFields.put("slp_iss_dt", "slpIssDt");
        this.hashFields.put("evid_tp_cd_val", "evidTpCdVal");
        this.hashFields.put("diff_amt", "diffAmt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("vat_slp_ser_no", "vatSlpSerNo");
        this.hashFields.put("chk_ctr_cd", "chkCtrCd");
        this.hashFields.put("vat_slp_ofc_cd", "vatSlpOfcCd");
        this.hashFields.put("ap_ctr_cd", "apCtrCd");
        this.hashFields.put("pre_work_flag", "preWorkFlag");
        this.hashFields.put("auto_flg", "autoFlg");
        this.hashFields.put("tax_iss_cd", "taxIssCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
        this.hashFields.put("flet_ctrt_tp_nm", "fletCtrtTpNm");
        this.hashFields.put("slp_func_cd", "slpFuncCd");
        this.hashFields.put("slp_tp_cd", "slpTpCd");
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
	 * @param String balanceAmt
	 */
    public void setBalanceAmt(String balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    /**
	 * 
	 * @return String balanceAmt
	 */
    public String getBalanceAmt() {
        return this.balanceAmt;
    }

    /**
	 *
	 * @param String drAmt
	 */
    public void setDrAmt(String drAmt) {
        this.drAmt = drAmt;
    }

    /**
	 * 
	 * @return String drAmt
	 */
    public String getDrAmt() {
        return this.drAmt;
    }

    /**
	 *
	 * @param String fletCtrtTpCd
	 */
    public void setFletCtrtTpCd(String fletCtrtTpCd) {
        this.fletCtrtTpCd = fletCtrtTpCd;
    }

    /**
	 * 
	 * @return String fletCtrtTpCd
	 */
    public String getFletCtrtTpCd() {
        return this.fletCtrtTpCd;
    }

    /**
	 *
	 * @param String csrCurrCd
	 */
    public void setCsrCurrCd(String csrCurrCd) {
        this.csrCurrCd = csrCurrCd;
    }

    /**
	 * 
	 * @return String csrCurrCd
	 */
    public String getCsrCurrCd() {
        return this.csrCurrCd;
    }

    /**
	 *
	 * @param String evidTpCd
	 */
    public void setEvidTpCd(String evidTpCd) {
        this.evidTpCd = evidTpCd;
    }

    /**
	 * 
	 * @return String evidTpCd
	 */
    public String getEvidTpCd() {
        return this.evidTpCd;
    }

    /**
	 *
	 * @param String ppayHirNo
	 */
    public void setPpayHirNo(String ppayHirNo) {
        this.ppayHirNo = ppayHirNo;
    }

    /**
	 * 
	 * @return String ppayHirNo
	 */
    public String getPpayHirNo() {
        return this.ppayHirNo;
    }

    /**
	 *
	 * @param String chkAcctCd
	 */
    public void setChkAcctCd(String chkAcctCd) {
        this.chkAcctCd = chkAcctCd;
    }

    /**
	 * 
	 * @return String chkAcctCd
	 */
    public String getChkAcctCd() {
        return this.chkAcctCd;
    }

    /**
	 *
	 * @param String slpDesc
	 */
    public void setSlpDesc(String slpDesc) {
        this.slpDesc = slpDesc;
    }

    /**
	 * 
	 * @return String slpDesc
	 */
    public String getSlpDesc() {
        return this.slpDesc;
    }

    /**
	 *
	 * @param String vatSlpFuncCd
	 */
    public void setVatSlpFuncCd(String vatSlpFuncCd) {
        this.vatSlpFuncCd = vatSlpFuncCd;
    }

    /**
	 * 
	 * @return String vatSlpFuncCd
	 */
    public String getVatSlpFuncCd() {
        return this.vatSlpFuncCd;
    }

    /**
	 *
	 * @param String fletCtrtNo
	 */
    public void setFletCtrtNo(String fletCtrtNo) {
        this.fletCtrtNo = fletCtrtNo;
    }

    /**
	 * 
	 * @return String fletCtrtNo
	 */
    public String getFletCtrtNo() {
        return this.fletCtrtNo;
    }

    /**
	 *
	 * @param String locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * 
	 * @return String locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 *
	 * @param String slpTp
	 */
    public void setSlpTp(String slpTp) {
        this.slpTp = slpTp;
    }

    /**
	 * 
	 * @return String slpTp
	 */
    public String getSlpTp() {
        return this.slpTp;
    }

    /**
	 *
	 * @param String effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    /**
	 * 
	 * @return String effDt
	 */
    public String getEffDt() {
        return this.effDt;
    }

    /**
	 *
	 * @param String vslEngNm
	 */
    public void setVslEngNm(String vslEngNm) {
        this.vslEngNm = vslEngNm;
    }

    /**
	 * 
	 * @return String vslEngNm
	 */
    public String getVslEngNm() {
        return this.vslEngNm;
    }

    /**
	 *
	 * @param String usrNm
	 */
    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    /**
	 * 
	 * @return String usrNm
	 */
    public String getUsrNm() {
        return this.usrNm;
    }

    /**
	 *
	 * @param String ownrCd
	 */
    public void setOwnrCd(String ownrCd) {
        this.ownrCd = ownrCd;
    }

    /**
	 * 
	 * @return String ownrCd
	 */
    public String getOwnrCd() {
        return this.ownrCd;
    }

    /**
	 *
	 * @param String vatFlg
	 */
    public void setVatFlg(String vatFlg) {
        this.vatFlg = vatFlg;
    }

    /**
	 * 
	 * @return String vatFlg
	 */
    public String getVatFlg() {
        return this.vatFlg;
    }

    /**
	 *
	 * @param String usdLoclXchRt
	 */
    public void setUsdLoclXchRt(String usdLoclXchRt) {
        this.usdLoclXchRt = usdLoclXchRt;
    }

    /**
	 * 
	 * @return String usdLoclXchRt
	 */
    public String getUsdLoclXchRt() {
        return this.usdLoclXchRt;
    }

    /**
	 *
	 * @param String vatSlpTpCd
	 */
    public void setVatSlpTpCd(String vatSlpTpCd) {
        this.vatSlpTpCd = vatSlpTpCd;
    }

    /**
	 * 
	 * @return String vatSlpTpCd
	 */
    public String getVatSlpTpCd() {
        return this.vatSlpTpCd;
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
	 * @param String chkBunkerVvd
	 */
    public void setChkBunkerVvd(String chkBunkerVvd) {
        this.chkBunkerVvd = chkBunkerVvd;
    }

    /**
	 * 
	 * @return String chkBunkerVvd
	 */
    public String getChkBunkerVvd() {
        return this.chkBunkerVvd;
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
	 * @param String rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * 
	 * @return String rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 *
	 * @param String vatSlpIssDt
	 */
    public void setVatSlpIssDt(String vatSlpIssDt) {
        this.vatSlpIssDt = vatSlpIssDt;
    }

    /**
	 * 
	 * @return String vatSlpIssDt
	 */
    public String getVatSlpIssDt() {
        return this.vatSlpIssDt;
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
	 * @param String evidTpCdVal
	 */
    public void setEvidTpCdVal(String evidTpCdVal) {
        this.evidTpCdVal = evidTpCdVal;
    }

    /**
	 * 
	 * @return String evidTpCdVal
	 */
    public String getEvidTpCdVal() {
        return this.evidTpCdVal;
    }

    /**
	 *
	 * @param String diffAmt
	 */
    public void setDiffAmt(String diffAmt) {
        this.diffAmt = diffAmt;
    }

    /**
	 * 
	 * @return String diffAmt
	 */
    public String getDiffAmt() {
        return this.diffAmt;
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
	 * @param String vatSlpSerNo
	 */
    public void setVatSlpSerNo(String vatSlpSerNo) {
        this.vatSlpSerNo = vatSlpSerNo;
    }

    /**
	 * 
	 * @return String vatSlpSerNo
	 */
    public String getVatSlpSerNo() {
        return this.vatSlpSerNo;
    }

    /**
	 *
	 * @param String chkCtrCd
	 */
    public void setChkCtrCd(String chkCtrCd) {
        this.chkCtrCd = chkCtrCd;
    }

    /**
	 * 
	 * @return String chkCtrCd
	 */
    public String getChkCtrCd() {
        return this.chkCtrCd;
    }

    /**
	 *
	 * @param String vatSlpOfcCd
	 */
    public void setVatSlpOfcCd(String vatSlpOfcCd) {
        this.vatSlpOfcCd = vatSlpOfcCd;
    }

    /**
	 * 
	 * @return String vatSlpOfcCd
	 */
    public String getVatSlpOfcCd() {
        return this.vatSlpOfcCd;
    }

    /**
	 *
	 * @param String apCtrCd
	 */
    public void setApCtrCd(String apCtrCd) {
        this.apCtrCd = apCtrCd;
    }

    /**
	 * 
	 * @return String apCtrCd
	 */
    public String getApCtrCd() {
        return this.apCtrCd;
    }

    /**
	 *
	 * @param String preWorkFlag
	 */
    public void setPreWorkFlag(String preWorkFlag) {
        this.preWorkFlag = preWorkFlag;
    }

    /**
	 * 
	 * @return String preWorkFlag
	 */
    public String getPreWorkFlag() {
        return this.preWorkFlag;
    }

    /**
	 *
	 * @param String autoFlg
	 */
    public void setAutoFlg(String autoFlg) {
        this.autoFlg = autoFlg;
    }

    /**
	 * 
	 * @return String autoFlg
	 */
    public String getAutoFlg() {
        return this.autoFlg;
    }

    /**
	 *
	 * @param String taxIssCd
	 */
    public void setTaxIssCd(String taxIssCd) {
        this.taxIssCd = taxIssCd;
    }

    /**
	 * 
	 * @return String taxIssCd
	 */
    public String getTaxIssCd() {
        return this.taxIssCd;
    }

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
    }

    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    public String getCustCntCd() {
        return this.custCntCd;
    }

    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    public String getCustSeq() {
        return this.custSeq;
    }

    public void setCustLglEngNm(String custLglEngNm) {
        this.custLglEngNm = custLglEngNm;
    }

    public String getCustLglEngNm() {
        return this.custLglEngNm;
    }

    public void setFletCtrtTpNm(String fletCtrtTpNm) {
        this.fletCtrtTpNm = fletCtrtTpNm;
    }

    public String getFletCtrtTpNm() {
        return this.fletCtrtTpNm;
    }

    public void setSlpFuncCd(String slpFuncCd) {
        this.slpFuncCd = slpFuncCd;
    }

    public String getSlpFuncCd() {
        return this.slpFuncCd;
    }

    public void setSlpTpCd(String slpTpCd) {
        this.slpTpCd = slpTpCd;
    }

    public String getSlpTpCd() {
        return this.slpTpCd;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setBalanceAmt(JSPUtil.getParameter(request, prefix + "balance_amt", ""));
        setDrAmt(JSPUtil.getParameter(request, prefix + "dr_amt", ""));
        setFletCtrtTpCd(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", ""));
        setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
        setEvidTpCd(JSPUtil.getParameter(request, prefix + "evid_tp_cd", ""));
        setPpayHirNo(JSPUtil.getParameter(request, prefix + "ppay_hir_no", ""));
        setChkAcctCd(JSPUtil.getParameter(request, prefix + "chk_acct_cd", ""));
        setSlpDesc(JSPUtil.getParameter(request, prefix + "slp_desc", ""));
        setVatSlpFuncCd(JSPUtil.getParameter(request, prefix + "vat_slp_func_cd", ""));
        setFletCtrtNo(JSPUtil.getParameter(request, prefix + "flet_ctrt_no", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setSlpTp(JSPUtil.getParameter(request, prefix + "slp_tp", ""));
        setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
        setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
        setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
        setOwnrCd(JSPUtil.getParameter(request, prefix + "ownr_cd", ""));
        setVatFlg(JSPUtil.getParameter(request, prefix + "vat_flg", ""));
        setUsdLoclXchRt(JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", ""));
        setVatSlpTpCd(JSPUtil.getParameter(request, prefix + "vat_slp_tp_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setChkBunkerVvd(JSPUtil.getParameter(request, prefix + "chk_bunker_vvd", ""));
        setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setVatSlpIssDt(JSPUtil.getParameter(request, prefix + "vat_slp_iss_dt", ""));
        setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
        setSlpIssDt(JSPUtil.getParameter(request, prefix + "slp_iss_dt", ""));
        setEvidTpCdVal(JSPUtil.getParameter(request, prefix + "evid_tp_cd_val", ""));
        setDiffAmt(JSPUtil.getParameter(request, prefix + "diff_amt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setVatSlpSerNo(JSPUtil.getParameter(request, prefix + "vat_slp_ser_no", ""));
        setChkCtrCd(JSPUtil.getParameter(request, prefix + "chk_ctr_cd", ""));
        setVatSlpOfcCd(JSPUtil.getParameter(request, prefix + "vat_slp_ofc_cd", ""));
        setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
        setPreWorkFlag(JSPUtil.getParameter(request, prefix + "pre_work_flag", ""));
        setAutoFlg(JSPUtil.getParameter(request, prefix + "auto_flg", ""));
        setTaxIssCd(JSPUtil.getParameter(request, prefix + "tax_iss_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
        setFletCtrtTpNm(JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_nm", ""));
        setSlpFuncCd(JSPUtil.getParameter(request, prefix + "slp_func_cd", ""));
        setSlpTpCd(JSPUtil.getParameter(request, prefix + "slp_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPaymentSlipMasterVO[]
	 */
    public SearchPaymentSlipMasterVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPaymentSlipMasterVO[]
	 */
    public SearchPaymentSlipMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchPaymentSlipMasterVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] balanceAmt = (JSPUtil.getParameter(request, prefix + "balance_amt", length));
            String[] drAmt = (JSPUtil.getParameter(request, prefix + "dr_amt", length));
            String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_cd", length));
            String[] csrCurrCd = (JSPUtil.getParameter(request, prefix + "csr_curr_cd", length));
            String[] evidTpCd = (JSPUtil.getParameter(request, prefix + "evid_tp_cd", length));
            String[] ppayHirNo = (JSPUtil.getParameter(request, prefix + "ppay_hir_no", length));
            String[] chkAcctCd = (JSPUtil.getParameter(request, prefix + "chk_acct_cd", length));
            String[] slpDesc = (JSPUtil.getParameter(request, prefix + "slp_desc", length));
            String[] vatSlpFuncCd = (JSPUtil.getParameter(request, prefix + "vat_slp_func_cd", length));
            String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix + "flet_ctrt_no", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] slpTp = (JSPUtil.getParameter(request, prefix + "slp_tp", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] vslEngNm = (JSPUtil.getParameter(request, prefix + "vsl_eng_nm", length));
            String[] usrNm = (JSPUtil.getParameter(request, prefix + "usr_nm", length));
            String[] ownrCd = (JSPUtil.getParameter(request, prefix + "ownr_cd", length));
            String[] vatFlg = (JSPUtil.getParameter(request, prefix + "vat_flg", length));
            String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix + "usd_locl_xch_rt", length));
            String[] vatSlpTpCd = (JSPUtil.getParameter(request, prefix + "vat_slp_tp_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] chkBunkerVvd = (JSPUtil.getParameter(request, prefix + "chk_bunker_vvd", length));
            String[] csrNo = (JSPUtil.getParameter(request, prefix + "csr_no", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] vatSlpIssDt = (JSPUtil.getParameter(request, prefix + "vat_slp_iss_dt", length));
            String[] slpOfcCd = (JSPUtil.getParameter(request, prefix + "slp_ofc_cd", length));
            String[] slpIssDt = (JSPUtil.getParameter(request, prefix + "slp_iss_dt", length));
            String[] evidTpCdVal = (JSPUtil.getParameter(request, prefix + "evid_tp_cd_val", length));
            String[] diffAmt = (JSPUtil.getParameter(request, prefix + "diff_amt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] vatSlpSerNo = (JSPUtil.getParameter(request, prefix + "vat_slp_ser_no", length));
            String[] chkCtrCd = (JSPUtil.getParameter(request, prefix + "chk_ctr_cd", length));
            String[] vatSlpOfcCd = (JSPUtil.getParameter(request, prefix + "vat_slp_ofc_cd", length));
            String[] apCtrCd = (JSPUtil.getParameter(request, prefix + "ap_ctr_cd", length));
            String[] preWorkFlag = (JSPUtil.getParameter(request, prefix + "pre_work_flag", length));
            String[] autoFlg = (JSPUtil.getParameter(request, prefix + "auto_flg", length));
            String[] taxIssCd = (JSPUtil.getParameter(request, prefix + "tax_iss_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] custLglEngNm = (JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", length));
            String[] fletCtrtTpNm = (JSPUtil.getParameter(request, prefix + "flet_ctrt_tp_nm", length));
            String[] slpFuncCd = (JSPUtil.getParameter(request, prefix + "slp_func_cd", length));
	    	String[] slpTpCd = (JSPUtil.getParameter(request, prefix + "slp_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchPaymentSlipMasterVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (balanceAmt[i] != null)
                    model.setBalanceAmt(balanceAmt[i]);
                if (drAmt[i] != null)
                    model.setDrAmt(drAmt[i]);
                if (fletCtrtTpCd[i] != null)
                    model.setFletCtrtTpCd(fletCtrtTpCd[i]);
                if (csrCurrCd[i] != null)
                    model.setCsrCurrCd(csrCurrCd[i]);
                if (evidTpCd[i] != null)
                    model.setEvidTpCd(evidTpCd[i]);
                if (ppayHirNo[i] != null)
                    model.setPpayHirNo(ppayHirNo[i]);
                if (chkAcctCd[i] != null)
                    model.setChkAcctCd(chkAcctCd[i]);
                if (slpDesc[i] != null)
                    model.setSlpDesc(slpDesc[i]);
                if (vatSlpFuncCd[i] != null)
                    model.setVatSlpFuncCd(vatSlpFuncCd[i]);
                if (fletCtrtNo[i] != null)
                    model.setFletCtrtNo(fletCtrtNo[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (slpTp[i] != null)
                    model.setSlpTp(slpTp[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (vslEngNm[i] != null)
                    model.setVslEngNm(vslEngNm[i]);
                if (usrNm[i] != null)
                    model.setUsrNm(usrNm[i]);
                if (ownrCd[i] != null)
                    model.setOwnrCd(ownrCd[i]);
                if (vatFlg[i] != null)
                    model.setVatFlg(vatFlg[i]);
                if (usdLoclXchRt[i] != null)
                    model.setUsdLoclXchRt(usdLoclXchRt[i]);
                if (vatSlpTpCd[i] != null)
                    model.setVatSlpTpCd(vatSlpTpCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (chkBunkerVvd[i] != null)
                    model.setChkBunkerVvd(chkBunkerVvd[i]);
                if (csrNo[i] != null)
                    model.setCsrNo(csrNo[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (vatSlpIssDt[i] != null)
                    model.setVatSlpIssDt(vatSlpIssDt[i]);
                if (slpOfcCd[i] != null)
                    model.setSlpOfcCd(slpOfcCd[i]);
                if (slpIssDt[i] != null)
                    model.setSlpIssDt(slpIssDt[i]);
                if (evidTpCdVal[i] != null)
                    model.setEvidTpCdVal(evidTpCdVal[i]);
                if (diffAmt[i] != null)
                    model.setDiffAmt(diffAmt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (vatSlpSerNo[i] != null)
                    model.setVatSlpSerNo(vatSlpSerNo[i]);
                if (chkCtrCd[i] != null)
                    model.setChkCtrCd(chkCtrCd[i]);
                if (vatSlpOfcCd[i] != null)
                    model.setVatSlpOfcCd(vatSlpOfcCd[i]);
                if (apCtrCd[i] != null)
                    model.setApCtrCd(apCtrCd[i]);
                if (preWorkFlag[i] != null)
                    model.setPreWorkFlag(preWorkFlag[i]);
                if (autoFlg[i] != null)
                    model.setAutoFlg(autoFlg[i]);
                if (taxIssCd[i] != null)
                    model.setTaxIssCd(taxIssCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (custLglEngNm[i] != null)
                    model.setCustLglEngNm(custLglEngNm[i]);
                if (fletCtrtTpNm[i] != null)
                    model.setFletCtrtTpNm(fletCtrtTpNm[i]);
                if (slpFuncCd[i] != null) 
		    		model.setSlpFuncCd(slpFuncCd[i]);
				if (slpTpCd[i] != null) 
		    		model.setSlpTpCd(slpTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchPaymentSlipMasterVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchPaymentSlipMasterVO[]
	 */
    public SearchPaymentSlipMasterVO[] getSearchPaymentSlipMasterVOs() {
        SearchPaymentSlipMasterVO[] vos = (SearchPaymentSlipMasterVO[]) models.toArray(new SearchPaymentSlipMasterVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.balanceAmt = this.balanceAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.drAmt = this.drAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtTpCd = this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrCurrCd = this.csrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evidTpCd = this.evidTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ppayHirNo = this.ppayHirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkAcctCd = this.chkAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpDesc = this.slpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatSlpFuncCd = this.vatSlpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtNo = this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpTp = this.slpTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslEngNm = this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrNm = this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ownrCd = this.ownrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatFlg = this.vatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdLoclXchRt = this.usdLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatSlpTpCd = this.vatSlpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkBunkerVvd = this.chkBunkerVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.csrNo = this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatSlpIssDt = this.vatSlpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpOfcCd = this.slpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpIssDt = this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.evidTpCdVal = this.evidTpCdVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffAmt = this.diffAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatSlpSerNo = this.vatSlpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chkCtrCd = this.chkCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatSlpOfcCd = this.vatSlpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apCtrCd = this.apCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preWorkFlag = this.preWorkFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoFlg = this.autoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxIssCd = this.taxIssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fletCtrtTpNm = this.fletCtrtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpFuncCd = this.slpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slpTpCd = this.slpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
