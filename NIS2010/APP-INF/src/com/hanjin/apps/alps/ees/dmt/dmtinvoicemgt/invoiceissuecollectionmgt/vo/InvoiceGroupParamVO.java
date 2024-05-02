/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceGroupParamVO.java
*@FileTitle : InvoiceGroupParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class InvoiceGroupParamVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InvoiceGroupParamVO> models = new ArrayList<InvoiceGroupParamVO>();

    /* Column Info */
    private String payerCd = null;

    /* Column Info */
    private String invQty = null;

    /* Column Info */
    private String sGroupBy = null;

    /* Column Info */
    private String sChargeType = null;

    /* Column Info */
    private String backendjobKey = null;

    /* Column Info */
    private String errCode = null;

    /* Column Info */
    private String totBilAmt = null;

    /* Column Info */
    private String issueDate = null;

    /* Column Info */
    private String invCurrCd = null;

    /* Column Info */
    private String usrOfc = null;

    /* Page Number */
    private String pagerows = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String taxAmt = null;

    /* Column Info */
    private String backendjobId = null;

    /* Column Info */
    private String totTaxAmt = null;

    /* Column Info */
    private String payerNm = null;

    /* Column Info */
    private String errMsg = null;

    /* Column Info */
    private String totPayableAmt = null;

    /* Column Info */
    private String usrName = null;

    /* Column Info */
    private String sGroupInv = null;

    /* Column Info */
    private String grpBkgNo = null;

    /* Column Info */
    private String grpDmdtTrfCd = null;

    /* Column Info */
    private String sFmDt = null;

    /* Column Info */
    private String sToDt = null;

    /* Column Info */
    private String invNewRptFlg = null;

    /* Column Info */
    private String idaCgstRto = null;

    /* Column Info */
    private String idaCgstAmt = null;

    /* Column Info */
    private String idaSgstRto = null;

    /* Column Info */
    private String idaSgstAmt = null;

    /* Column Info */
    private String idaIgstRto = null;

    /* Column Info */
    private String idaIgstAmt = null;

    /* Column Info */
    private String idaUgstRto = null;

    /* Column Info */
    private String idaUgstAmt = null;

    /* Column Info */
    private String idaTaxApplTm = null;

    /* Column Info */
    private String idaExpnTaxRt = null;

    /* Column Info */
    private String idaExpnTax = null;

    /* Column Info */
    private String idaEduTaxRt = null;

    /* Column Info */
    private String idaEduTax = null;

    /* Column Info */
    private String idaHighEduTaxRt = null;

    /* Column Info */
    private String idaHighEduTax = null;

    /* Column Info */
    private String idaLoclTaxRt = null;

    /* Column Info */
    private String idaN2ndLoclTaxRt = null;

    /* Column Info */
    private String idaLoclTax = null;

    /* Column Info */
    private String idaN2ndLoclTax = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String taxRto = null;

    /* Column Info */
    private String usrCntCd = null;

    /* Column Info */
    private String autoArIfYn = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public InvoiceGroupParamVO() {
    }

    public InvoiceGroupParamVO(String ibflag, String pagerows, String invQty, String totBilAmt, String totTaxAmt, String totPayableAmt, String payerCd, String payerNm, String issueDate, String usrOfc, String invCurrCd, String usrName, String taxAmt, String sGroupBy, String sChargeType, String errCode, String errMsg, String backendjobId, String backendjobKey, String sGroupInv, String grpBkgNo, String grpDmdtTrfCd, String sFmDt, String sToDt, String invNewRptFlg, String idaCgstRto, String idaCgstAmt, String idaSgstRto, String idaSgstAmt, String idaIgstRto, String idaIgstAmt, String idaUgstRto, String idaUgstAmt, String idaTaxApplTm, String idaExpnTaxRt, String idaExpnTax, String idaEduTaxRt, String idaEduTax, String idaHighEduTaxRt, String idaHighEduTax, String idaLoclTaxRt, String idaN2ndLoclTaxRt, String idaLoclTax, String idaN2ndLoclTax, String invAmt, String taxRto, String usrCntCd, String autoArIfYn) {
        this.payerCd = payerCd;
        this.invQty = invQty;
        this.sGroupBy = sGroupBy;
        this.sChargeType = sChargeType;
        this.backendjobKey = backendjobKey;
        this.errCode = errCode;
        this.totBilAmt = totBilAmt;
        this.issueDate = issueDate;
        this.invCurrCd = invCurrCd;
        this.usrOfc = usrOfc;
        this.pagerows = pagerows;
        this.ibflag = ibflag;
        this.taxAmt = taxAmt;
        this.backendjobId = backendjobId;
        this.totTaxAmt = totTaxAmt;
        this.payerNm = payerNm;
        this.errMsg = errMsg;
        this.totPayableAmt = totPayableAmt;
        this.usrName = usrName;
        this.sGroupInv = sGroupInv;
        this.grpBkgNo = grpBkgNo;
        this.grpDmdtTrfCd = grpDmdtTrfCd;
        this.sFmDt = sFmDt;
        this.sToDt = sToDt;
        this.invNewRptFlg = invNewRptFlg;
        this.idaCgstRto = idaCgstRto;
        this.idaCgstAmt = idaCgstAmt;
        this.idaSgstRto = idaSgstRto;
        this.idaSgstAmt = idaSgstAmt;
        this.idaIgstRto = idaIgstRto;
        this.idaIgstAmt = idaIgstAmt;
        this.idaUgstRto = idaUgstRto;
        this.idaUgstAmt = idaUgstAmt;
        this.idaTaxApplTm = idaTaxApplTm;
        this.idaExpnTaxRt = idaExpnTaxRt;
        this.idaExpnTax = idaExpnTax;
        this.idaEduTaxRt = idaEduTaxRt;
        this.idaEduTax = idaEduTax;
        this.idaHighEduTaxRt = idaHighEduTaxRt;
        this.idaHighEduTax = idaHighEduTax;
        this.idaLoclTaxRt = idaLoclTaxRt;
        this.idaN2ndLoclTaxRt = idaN2ndLoclTaxRt;
        this.idaLoclTax = idaLoclTax;
        this.idaN2ndLoclTax = idaN2ndLoclTax;
        this.invAmt = invAmt;
        this.taxRto = taxRto;
        this.usrCntCd = usrCntCd;
        this.autoArIfYn = autoArIfYn;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("payer_cd", getPayerCd());
        this.hashColumns.put("inv_qty", getInvQty());
        this.hashColumns.put("s_group_by", getSGroupBy());
        this.hashColumns.put("s_charge_type", getSChargeType());
        this.hashColumns.put("backendjob_key", getBackendjobKey());
        this.hashColumns.put("err_code", getErrCode());
        this.hashColumns.put("tot_bil_amt", getTotBilAmt());
        this.hashColumns.put("issue_date", getIssueDate());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("usr_ofc", getUsrOfc());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("tax_amt", getTaxAmt());
        this.hashColumns.put("backendjob_id", getBackendjobId());
        this.hashColumns.put("tot_tax_amt", getTotTaxAmt());
        this.hashColumns.put("payer_nm", getPayerNm());
        this.hashColumns.put("err_msg", getErrMsg());
        this.hashColumns.put("tot_payable_amt", getTotPayableAmt());
        this.hashColumns.put("usr_name", getUsrName());
        this.hashColumns.put("s_group_inv", getSGroupInv());
        this.hashColumns.put("grp_bkg_no", getGrpBkgNo());
        this.hashColumns.put("grp_dmdt_trf_cd", getGrpDmdtTrfCd());
        this.hashColumns.put("s_fm_dt", getSFmDt());
        this.hashColumns.put("s_to_dt", getSToDt());
        this.hashColumns.put("inv_new_rpt_flg", getInvNewRptFlg());
        this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
        this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());
        this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
        this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());
        this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
        this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());
        this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
        this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());
        this.hashColumns.put("ida_tax_appl_tm", getIdaTaxApplTm());
        this.hashColumns.put("ida_expn_tax_rt", getIdaExpnTaxRt());
        this.hashColumns.put("ida_expn_tax", getIdaExpnTax());
        this.hashColumns.put("ida_edu_tax_rt", getIdaEduTaxRt());
        this.hashColumns.put("ida_edu_tax", getIdaEduTax());
        this.hashColumns.put("ida_high_edu_tax_rt", getIdaHighEduTaxRt());
        this.hashColumns.put("ida_high_edu_tax", getIdaHighEduTax());
        this.hashColumns.put("ida_locl_tax_rt", getIdaLoclTaxRt());
        this.hashColumns.put("ida_n2nd_locl_tax_rt", getIdaN2ndLoclTaxRt());
        this.hashColumns.put("ida_locl_tax", getIdaLoclTax());
        this.hashColumns.put("ida_n2nd_locl_tax", getIdaN2ndLoclTax());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("tax_rto", getTaxRto());
        this.hashColumns.put("usr_cnt_cd", getUsrCntCd());
        this.hashColumns.put("auto_ar_if_yn", getAutoArIfYn());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("payer_cd", "payerCd");
        this.hashFields.put("inv_qty", "invQty");
        this.hashFields.put("s_group_by", "sGroupBy");
        this.hashFields.put("s_charge_type", "sChargeType");
        this.hashFields.put("backendjob_key", "backendjobKey");
        this.hashFields.put("err_code", "errCode");
        this.hashFields.put("tot_bil_amt", "totBilAmt");
        this.hashFields.put("issue_date", "issueDate");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("usr_ofc", "usrOfc");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("tax_amt", "taxAmt");
        this.hashFields.put("backendjob_id", "backendjobId");
        this.hashFields.put("tot_tax_amt", "totTaxAmt");
        this.hashFields.put("payer_nm", "payerNm");
        this.hashFields.put("err_msg", "errMsg");
        this.hashFields.put("tot_payable_amt", "totPayableAmt");
        this.hashFields.put("usr_name", "usrName");
        this.hashFields.put("s_group_inv", "sGroupInv");
        this.hashFields.put("grp_bkg_no", "grpBkgNo");
        this.hashFields.put("grp_dmdt_trf_cd", "grpDmdtTrfCd");
        this.hashFields.put("s_fm_dt", "sFmDt");
        this.hashFields.put("s_to_dt", "sToDt");
        this.hashFields.put("inv_new_rpt_flg", "invNewRptFlg");
        this.hashFields.put("ida_cgst_rto", "idaCgstRto");
        this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
        this.hashFields.put("ida_sgst_rto", "idaSgstRto");
        this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
        this.hashFields.put("ida_igst_rto", "idaIgstRto");
        this.hashFields.put("ida_igst_amt", "idaIgstAmt");
        this.hashFields.put("ida_ugst_rto", "idaUgstRto");
        this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
        this.hashFields.put("ida_tax_appl_tm", "idaTaxApplTm");
        this.hashFields.put("ida_expn_tax_rt", "idaExpnTaxRt");
        this.hashFields.put("ida_expn_tax", "idaExpnTax");
        this.hashFields.put("ida_edu_tax_rt", "idaEduTaxRt");
        this.hashFields.put("ida_edu_tax", "idaEduTax");
        this.hashFields.put("ida_high_edu_tax_rt", "idaHighEduTaxRt");
        this.hashFields.put("ida_high_edu_tax", "idaHighEduTax");
        this.hashFields.put("ida_locl_tax_rt", "idaLoclTaxRt");
        this.hashFields.put("ida_n2nd_locl_tax_rt", "idaN2ndLoclTaxRt");
        this.hashFields.put("ida_locl_tax", "idaLoclTax");
        this.hashFields.put("ida_n2nd_locl_tax", "idaN2ndLoclTax");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("tax_rto", "taxRto");
        this.hashFields.put("usr_cnt_cd", "usrCntCd");
        this.hashFields.put("auto_ar_if_yn", "autoArIfYn");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return payerCd
	 */
    public String getPayerCd() {
        return this.payerCd;
    }

    /**
	 * Column Info
	 * @return invQty
	 */
    public String getInvQty() {
        return this.invQty;
    }

    /**
	 * Column Info
	 * @return sGroupBy
	 */
    public String getSGroupBy() {
        return this.sGroupBy;
    }

    /**
	 * Column Info
	 * @return sChargeType
	 */
    public String getSChargeType() {
        return this.sChargeType;
    }

    /**
	 * Column Info
	 * @return backendjobKey
	 */
    public String getBackendjobKey() {
        return this.backendjobKey;
    }

    /**
	 * Column Info
	 * @return errCode
	 */
    public String getErrCode() {
        return this.errCode;
    }

    /**
	 * Column Info
	 * @return totBilAmt
	 */
    public String getTotBilAmt() {
        return this.totBilAmt;
    }

    /**
	 * Column Info
	 * @return issueDate
	 */
    public String getIssueDate() {
        return this.issueDate;
    }

    /**
	 * Column Info
	 * @return invCurrCd
	 */
    public String getInvCurrCd() {
        return this.invCurrCd;
    }

    /**
	 * Column Info
	 * @return usrOfc
	 */
    public String getUsrOfc() {
        return this.usrOfc;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
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
	 * @return taxAmt
	 */
    public String getTaxAmt() {
        return this.taxAmt;
    }

    /**
	 * Column Info
	 * @return backendjobId
	 */
    public String getBackendjobId() {
        return this.backendjobId;
    }

    /**
	 * Column Info
	 * @return totTaxAmt
	 */
    public String getTotTaxAmt() {
        return this.totTaxAmt;
    }

    /**
	 * Column Info
	 * @return payerNm
	 */
    public String getPayerNm() {
        return this.payerNm;
    }

    /**
	 * Column Info
	 * @return errMsg
	 */
    public String getErrMsg() {
        return this.errMsg;
    }

    /**
	 * Column Info
	 * @return totPayableAmt
	 */
    public String getTotPayableAmt() {
        return this.totPayableAmt;
    }

    /**
	 * Column Info
	 * @return usrName
	 */
    public String getUsrName() {
        return this.usrName;
    }

    /**
	 * Column Info
	 * @param payerCd
	 */
    public void setPayerCd(String payerCd) {
        this.payerCd = payerCd;
    }

    /**
	 * Column Info
	 * @param invQty
	 */
    public void setInvQty(String invQty) {
        this.invQty = invQty;
    }

    /**
	 * Column Info
	 * @param sGroupBy
	 */
    public void setSGroupBy(String sGroupBy) {
        this.sGroupBy = sGroupBy;
    }

    /**
	 * Column Info
	 * @param sChargeType
	 */
    public void setSChargeType(String sChargeType) {
        this.sChargeType = sChargeType;
    }

    /**
	 * Column Info
	 * @param backendjobKey
	 */
    public void setBackendjobKey(String backendjobKey) {
        this.backendjobKey = backendjobKey;
    }

    /**
	 * Column Info
	 * @param errCode
	 */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
	 * Column Info
	 * @param totBilAmt
	 */
    public void setTotBilAmt(String totBilAmt) {
        this.totBilAmt = totBilAmt;
    }

    /**
	 * Column Info
	 * @param issueDate
	 */
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    /**
	 * Column Info
	 * @param invCurrCd
	 */
    public void setInvCurrCd(String invCurrCd) {
        this.invCurrCd = invCurrCd;
    }

    /**
	 * Column Info
	 * @param usrOfc
	 */
    public void setUsrOfc(String usrOfc) {
        this.usrOfc = usrOfc;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
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
	 * @param taxAmt
	 */
    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    /**
	 * Column Info
	 * @param backendjobId
	 */
    public void setBackendjobId(String backendjobId) {
        this.backendjobId = backendjobId;
    }

    /**
	 * Column Info
	 * @param totTaxAmt
	 */
    public void setTotTaxAmt(String totTaxAmt) {
        this.totTaxAmt = totTaxAmt;
    }

    /**
	 * Column Info
	 * @param payerNm
	 */
    public void setPayerNm(String payerNm) {
        this.payerNm = payerNm;
    }

    /**
	 * Column Info
	 * @param errMsg
	 */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    /**
	 * Column Info
	 * @param totPayableAmt
	 */
    public void setTotPayableAmt(String totPayableAmt) {
        this.totPayableAmt = totPayableAmt;
    }

    /**
	 * Column Info
	 * @param usrName
	 */
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getSGroupInv() {
        return sGroupInv;
    }

    public void setSGroupInv(String sGroupInv) {
        this.sGroupInv = sGroupInv;
    }

    public String getGrpBkgNo() {
        return grpBkgNo;
    }

    public void setGrpBkgNo(String grpBkgNo) {
        this.grpBkgNo = grpBkgNo;
    }

    public String getGrpDmdtTrfCd() {
        return grpDmdtTrfCd;
    }

    public void setGrpDmdtTrfCd(String grpDmdtTrfCd) {
        this.grpDmdtTrfCd = grpDmdtTrfCd;
    }

    public String getSFmDt() {
        return sFmDt;
    }

    public void setSFmDt(String sFmDt) {
        this.sFmDt = sFmDt;
    }

    public String getSToDt() {
        return sToDt;
    }

    public void setSToDt(String sToDt) {
        this.sToDt = sToDt;
    }

    public String getInvNewRptFlg() {
        return invNewRptFlg;
    }

    public void setInvNewRptFlg(String invNewRptFlg) {
        this.invNewRptFlg = invNewRptFlg;
    }

    public void setIdaCgstRto(String idaCgstRto) {
        this.idaCgstRto = idaCgstRto;
    }

    public String getIdaCgstRto() {
        return this.idaCgstRto;
    }

    public void setIdaCgstAmt(String idaCgstAmt) {
        this.idaCgstAmt = idaCgstAmt;
    }

    public String getIdaCgstAmt() {
        return this.idaCgstAmt;
    }

    public void setIdaSgstRto(String idaSgstRto) {
        this.idaSgstRto = idaSgstRto;
    }

    public String getIdaSgstRto() {
        return this.idaSgstRto;
    }

    public void setIdaSgstAmt(String idaSgstAmt) {
        this.idaSgstAmt = idaSgstAmt;
    }

    public String getIdaSgstAmt() {
        return this.idaSgstAmt;
    }

    public void setIdaIgstRto(String idaIgstRto) {
        this.idaIgstRto = idaIgstRto;
    }

    public String getIdaIgstRto() {
        return this.idaIgstRto;
    }

    public void setIdaIgstAmt(String idaIgstAmt) {
        this.idaIgstAmt = idaIgstAmt;
    }

    public String getIdaIgstAmt() {
        return this.idaIgstAmt;
    }

    public void setIdaUgstRto(String idaUgstRto) {
        this.idaUgstRto = idaUgstRto;
    }

    public String getIdaUgstRto() {
        return this.idaUgstRto;
    }

    public void setIdaUgstAmt(String idaUgstAmt) {
        this.idaUgstAmt = idaUgstAmt;
    }

    public String getIdaUgstAmt() {
        return this.idaUgstAmt;
    }

    public void setIdaTaxApplTm(String idaTaxApplTm) {
        this.idaTaxApplTm = idaTaxApplTm;
    }

    public String getIdaTaxApplTm() {
        return this.idaTaxApplTm;
    }

    public void setIdaExpnTaxRt(String idaExpnTaxRt) {
        this.idaExpnTaxRt = idaExpnTaxRt;
    }

    public String getIdaExpnTaxRt() {
        return this.idaExpnTaxRt;
    }

    public void setIdaExpnTax(String idaExpnTax) {
        this.idaExpnTax = idaExpnTax;
    }

    public String getIdaExpnTax() {
        return this.idaExpnTax;
    }

    public void setIdaEduTaxRt(String idaEduTaxRt) {
        this.idaEduTaxRt = idaEduTaxRt;
    }

    public String getIdaEduTaxRt() {
        return this.idaEduTaxRt;
    }

    public void setIdaEduTax(String idaEduTax) {
        this.idaEduTax = idaEduTax;
    }

    public String getIdaEduTax() {
        return this.idaEduTax;
    }

    public void setIdaHighEduTaxRt(String idaHighEduTaxRt) {
        this.idaHighEduTaxRt = idaHighEduTaxRt;
    }

    public String getIdaHighEduTaxRt() {
        return this.idaHighEduTaxRt;
    }

    public void setIdaHighEduTax(String idaHighEduTax) {
        this.idaHighEduTax = idaHighEduTax;
    }

    public String getIdaHighEduTax() {
        return this.idaHighEduTax;
    }

    public void setIdaLoclTaxRt(String idaLoclTaxRt) {
        this.idaLoclTaxRt = idaLoclTaxRt;
    }

    public String getIdaLoclTaxRt() {
        return this.idaLoclTaxRt;
    }

    public void setIdaN2ndLoclTaxRt(String idaN2ndLoclTaxRt) {
        this.idaN2ndLoclTaxRt = idaN2ndLoclTaxRt;
    }

    public String getIdaN2ndLoclTaxRt() {
        return this.idaN2ndLoclTaxRt;
    }

    public void setIdaLoclTax(String idaLoclTax) {
        this.idaLoclTax = idaLoclTax;
    }

    public String getIdaLoclTax() {
        return this.idaLoclTax;
    }

    public void setIdaN2ndLoclTax(String idaN2ndLoclTax) {
        this.idaN2ndLoclTax = idaN2ndLoclTax;
    }

    public String getIdaN2ndLoclTax() {
        return this.idaN2ndLoclTax;
    }

    public void setInvAmt(String invAmt) {
        this.invAmt = invAmt;
    }

    public String getInvAmt() {
        return this.invAmt;
    }

    public void setTaxRto(String taxRto) {
        this.taxRto = taxRto;
    }

    public String getTaxRto() {
        return this.taxRto;
    }

    public void setUsrCntCd(String usrCntCd) {
        this.usrCntCd = usrCntCd;
    }

    public String getUsrCntCd() {
        return this.usrCntCd;
    }

    public void setAutoArIfYn(String autoArIfYn) {
        this.autoArIfYn = autoArIfYn;
    }

    public String getAutoArIfYn() {
        return this.autoArIfYn;
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
        setPayerCd(JSPUtil.getParameter(request, prefix + "payer_cd", ""));
        setInvQty(JSPUtil.getParameter(request, prefix + "inv_qty", ""));
        setSGroupBy(JSPUtil.getParameter(request, prefix + "s_group_by", ""));
        setSChargeType(JSPUtil.getParameter(request, prefix + "s_charge_type", ""));
        setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
        setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
        setTotBilAmt(JSPUtil.getParameter(request, prefix + "tot_bil_amt", ""));
        setIssueDate(JSPUtil.getParameter(request, prefix + "issue_date", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setUsrOfc(JSPUtil.getParameter(request, prefix + "usr_ofc", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
        setBackendjobId(JSPUtil.getParameter(request, prefix + "backendjob_id", ""));
        setTotTaxAmt(JSPUtil.getParameter(request, prefix + "tot_tax_amt", ""));
        setPayerNm(JSPUtil.getParameter(request, prefix + "payer_nm", ""));
        setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
        setTotPayableAmt(JSPUtil.getParameter(request, prefix + "tot_payable_amt", ""));
        setUsrName(JSPUtil.getParameter(request, prefix + "usr_name", ""));
        setSGroupInv(JSPUtil.getParameter(request, prefix + "s_group_inv", ""));
        setGrpBkgNo(JSPUtil.getParameter(request, prefix + "grp_bkg_no", ""));
        setGrpDmdtTrfCd(JSPUtil.getParameter(request, prefix + "grp_dmdt_trf_cd", ""));
        setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
        setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
        setInvNewRptFlg(JSPUtil.getParameter(request, prefix + "inv_new_rpt_flg", ""));
        setIdaCgstRto(JSPUtil.getParameter(request, prefix + "ida_cgst_rto", ""));
        setIdaCgstAmt(JSPUtil.getParameter(request, prefix + "ida_cgst_amt", ""));
        setIdaSgstRto(JSPUtil.getParameter(request, prefix + "ida_sgst_rto", ""));
        setIdaSgstAmt(JSPUtil.getParameter(request, prefix + "ida_sgst_amt", ""));
        setIdaIgstRto(JSPUtil.getParameter(request, prefix + "ida_igst_rto", ""));
        setIdaIgstAmt(JSPUtil.getParameter(request, prefix + "ida_igst_amt", ""));
        setIdaUgstRto(JSPUtil.getParameter(request, prefix + "ida_ugst_rto", ""));
        setIdaUgstAmt(JSPUtil.getParameter(request, prefix + "ida_ugst_amt", ""));
        setIdaTaxApplTm(JSPUtil.getParameter(request, prefix + "ida_tax_appl_tm", ""));
        setIdaExpnTaxRt(JSPUtil.getParameter(request, prefix + "ida_expn_tax_rt", ""));
        setIdaExpnTax(JSPUtil.getParameter(request, prefix + "ida_expn_tax", ""));
        setIdaEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_edu_tax_rt", ""));
        setIdaEduTax(JSPUtil.getParameter(request, prefix + "ida_edu_tax", ""));
        setIdaHighEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax_rt", ""));
        setIdaHighEduTax(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax", ""));
        setIdaLoclTaxRt(JSPUtil.getParameter(request, prefix + "ida_locl_tax_rt", ""));
        setIdaN2ndLoclTaxRt(JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax_rt", ""));
        setIdaLoclTax(JSPUtil.getParameter(request, prefix + "ida_locl_tax", ""));
        setIdaN2ndLoclTax(JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setTaxRto(JSPUtil.getParameter(request, prefix + "tax_rto", ""));
        setUsrCntCd(JSPUtil.getParameter(request, prefix + "usr_cnt_cd", ""));
        setAutoArIfYn(JSPUtil.getParameter(request, prefix + "auto_ar_if_yn", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceGroupParamVO[]
	 */
    public InvoiceGroupParamVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceGroupParamVO[]
	 */
    public InvoiceGroupParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InvoiceGroupParamVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] payerCd = (JSPUtil.getParameter(request, prefix + "payer_cd", length));
            String[] invQty = (JSPUtil.getParameter(request, prefix + "inv_qty", length));
            String[] sGroupBy = (JSPUtil.getParameter(request, prefix + "s_group_by", length));
            String[] sChargeType = (JSPUtil.getParameter(request, prefix + "s_charge_type", length));
            String[] backendjobKey = (JSPUtil.getParameter(request, prefix + "backendjob_key", length));
            String[] errCode = (JSPUtil.getParameter(request, prefix + "err_code", length));
            String[] totBilAmt = (JSPUtil.getParameter(request, prefix + "tot_bil_amt", length));
            String[] issueDate = (JSPUtil.getParameter(request, prefix + "issue_date", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] usrOfc = (JSPUtil.getParameter(request, prefix + "usr_ofc", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] taxAmt = (JSPUtil.getParameter(request, prefix + "tax_amt", length));
            String[] backendjobId = (JSPUtil.getParameter(request, prefix + "backendjob_id", length));
            String[] totTaxAmt = (JSPUtil.getParameter(request, prefix + "tot_tax_amt", length));
            String[] payerNm = (JSPUtil.getParameter(request, prefix + "payer_nm", length));
            String[] errMsg = (JSPUtil.getParameter(request, prefix + "err_msg", length));
            String[] totPayableAmt = (JSPUtil.getParameter(request, prefix + "tot_payable_amt", length));
            String[] usrName = (JSPUtil.getParameter(request, prefix + "usr_name", length));
            String[] sGroupInv = (JSPUtil.getParameter(request, prefix + "s_group_inv", length));
            String[] grpBkgNo = (JSPUtil.getParameter(request, prefix + "grp_bkg_no", length));
            String[] grpDmdtTrfCd = (JSPUtil.getParameter(request, prefix + "grp_dmdt_trf_cd", length));
            String[] sFmDt = (JSPUtil.getParameter(request, prefix + "s_fm_dt", length));
            String[] sToDt = (JSPUtil.getParameter(request, prefix + "s_to_dt", length));
            String[] invNewRptFlg = (JSPUtil.getParameter(request, prefix + "inv_new_rpt_flg", length));
            String[] idaCgstRto = (JSPUtil.getParameter(request, prefix + "ida_cgst_rto", length));
            String[] idaCgstAmt = (JSPUtil.getParameter(request, prefix + "ida_cgst_amt", length));
            String[] idaSgstRto = (JSPUtil.getParameter(request, prefix + "ida_sgst_rto", length));
            String[] idaSgstAmt = (JSPUtil.getParameter(request, prefix + "ida_sgst_amt", length));
            String[] idaIgstRto = (JSPUtil.getParameter(request, prefix + "ida_igst_rto", length));
            String[] idaIgstAmt = (JSPUtil.getParameter(request, prefix + "ida_igst_amt", length));
            String[] idaUgstRto = (JSPUtil.getParameter(request, prefix + "ida_ugst_rto", length));
            String[] idaUgstAmt = (JSPUtil.getParameter(request, prefix + "ida_ugst_amt", length));
            String[] idaTaxApplTm = (JSPUtil.getParameter(request, prefix + "ida_tax_appl_tm", length));
            String[] idaExpnTaxRt = (JSPUtil.getParameter(request, prefix + "ida_expn_tax_rt", length));
            String[] idaExpnTax = (JSPUtil.getParameter(request, prefix + "ida_expn_tax", length));
            String[] idaEduTaxRt = (JSPUtil.getParameter(request, prefix + "ida_edu_tax_rt", length));
            String[] idaEduTax = (JSPUtil.getParameter(request, prefix + "ida_edu_tax", length));
            String[] idaHighEduTaxRt = (JSPUtil.getParameter(request, prefix + "ida_high_edu_tax_rt", length));
            String[] idaHighEduTax = (JSPUtil.getParameter(request, prefix + "ida_high_edu_tax", length));
            String[] idaLoclTaxRt = (JSPUtil.getParameter(request, prefix + "ida_locl_tax_rt", length));
            String[] idaN2ndLoclTaxRt = (JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax_rt", length));
            String[] idaLoclTax = (JSPUtil.getParameter(request, prefix + "ida_locl_tax", length));
            String[] idaN2ndLoclTax = (JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] taxRto = (JSPUtil.getParameter(request, prefix + "tax_rto", length));
            String[] usrCntCd = (JSPUtil.getParameter(request, prefix + "usr_cnt_cd", length));
            String[] autoArIfYn = (JSPUtil.getParameter(request, prefix + "auto_ar_if_yn", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InvoiceGroupParamVO();
                if (payerCd[i] != null)
                    model.setPayerCd(payerCd[i]);
                if (invQty[i] != null)
                    model.setInvQty(invQty[i]);
                if (sGroupBy[i] != null)
                    model.setSGroupBy(sGroupBy[i]);
                if (sChargeType[i] != null)
                    model.setSChargeType(sChargeType[i]);
                if (backendjobKey[i] != null)
                    model.setBackendjobKey(backendjobKey[i]);
                if (errCode[i] != null)
                    model.setErrCode(errCode[i]);
                if (totBilAmt[i] != null)
                    model.setTotBilAmt(totBilAmt[i]);
                if (issueDate[i] != null)
                    model.setIssueDate(issueDate[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (usrOfc[i] != null)
                    model.setUsrOfc(usrOfc[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (taxAmt[i] != null)
                    model.setTaxAmt(taxAmt[i]);
                if (backendjobId[i] != null)
                    model.setBackendjobId(backendjobId[i]);
                if (totTaxAmt[i] != null)
                    model.setTotTaxAmt(totTaxAmt[i]);
                if (payerNm[i] != null)
                    model.setPayerNm(payerNm[i]);
                if (errMsg[i] != null)
                    model.setErrMsg(errMsg[i]);
                if (totPayableAmt[i] != null)
                    model.setTotPayableAmt(totPayableAmt[i]);
                if (usrName[i] != null)
                    model.setUsrName(usrName[i]);
                if (sGroupInv[i] != null)
                    model.setSGroupInv(sGroupInv[i]);
                if (grpBkgNo[i] != null)
                    model.setGrpBkgNo(grpBkgNo[i]);
                if (grpDmdtTrfCd[i] != null)
                    model.setGrpDmdtTrfCd(grpDmdtTrfCd[i]);
                if (sFmDt[i] != null)
                    model.setSFmDt(sFmDt[i]);
                if (sToDt[i] != null)
                    model.setSToDt(sToDt[i]);
                if (invNewRptFlg[i] != null)
                    model.setInvNewRptFlg(invNewRptFlg[i]);
                if (idaCgstRto[i] != null)
                    model.setIdaCgstRto(idaCgstRto[i]);
                if (idaCgstAmt[i] != null)
                    model.setIdaCgstAmt(idaCgstAmt[i]);
                if (idaSgstRto[i] != null)
                    model.setIdaSgstRto(idaSgstRto[i]);
                if (idaSgstAmt[i] != null)
                    model.setIdaSgstAmt(idaSgstAmt[i]);
                if (idaIgstRto[i] != null)
                    model.setIdaIgstRto(idaIgstRto[i]);
                if (idaIgstAmt[i] != null)
                    model.setIdaIgstAmt(idaIgstAmt[i]);
                if (idaUgstRto[i] != null)
                    model.setIdaUgstRto(idaUgstRto[i]);
                if (idaUgstAmt[i] != null)
                    model.setIdaUgstAmt(idaUgstAmt[i]);
                if (idaTaxApplTm[i] != null)
                    model.setIdaTaxApplTm(idaTaxApplTm[i]);
                if (idaExpnTaxRt[i] != null)
                    model.setIdaExpnTaxRt(idaExpnTaxRt[i]);
                if (idaExpnTax[i] != null)
                    model.setIdaExpnTax(idaExpnTax[i]);
                if (idaEduTaxRt[i] != null)
                    model.setIdaEduTaxRt(idaEduTaxRt[i]);
                if (idaEduTax[i] != null)
                    model.setIdaEduTax(idaEduTax[i]);
                if (idaHighEduTaxRt[i] != null)
                    model.setIdaHighEduTaxRt(idaHighEduTaxRt[i]);
                if (idaHighEduTax[i] != null)
                    model.setIdaHighEduTax(idaHighEduTax[i]);
                if (idaLoclTaxRt[i] != null)
                    model.setIdaLoclTaxRt(idaLoclTaxRt[i]);
                if (idaN2ndLoclTaxRt[i] != null)
                    model.setIdaN2ndLoclTaxRt(idaN2ndLoclTaxRt[i]);
                if (idaLoclTax[i] != null)
                    model.setIdaLoclTax(idaLoclTax[i]);
                if (idaN2ndLoclTax[i] != null)
                    model.setIdaN2ndLoclTax(idaN2ndLoclTax[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (taxRto[i] != null)
                    model.setTaxRto(taxRto[i]);
                if (usrCntCd[i] != null)
                    model.setUsrCntCd(usrCntCd[i]);
                if (autoArIfYn[i] != null) 
		    		model.setAutoArIfYn(autoArIfYn[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInvoiceGroupParamVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InvoiceGroupParamVO[]
	 */
    public InvoiceGroupParamVO[] getInvoiceGroupParamVOs() {
        InvoiceGroupParamVO[] vos = (InvoiceGroupParamVO[]) models.toArray(new InvoiceGroupParamVO[models.size()]);
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
        this.payerCd = this.payerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invQty = this.invQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sGroupBy = this.sGroupBy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sChargeType = this.sChargeType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.backendjobKey = this.backendjobKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errCode = this.errCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totBilAmt = this.totBilAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issueDate = this.issueDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrOfc = this.usrOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxAmt = this.taxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.backendjobId = this.backendjobId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totTaxAmt = this.totTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerNm = this.payerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errMsg = this.errMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totPayableAmt = this.totPayableAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrName = this.usrName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sGroupInv = this.sGroupInv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpBkgNo = this.grpBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpDmdtTrfCd = this.grpDmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sFmDt = this.sFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sToDt = this.sToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNewRptFlg = this.invNewRptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstRto = this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstAmt = this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstRto = this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstAmt = this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstRto = this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstAmt = this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstRto = this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstAmt = this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxApplTm = this.idaTaxApplTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaExpnTaxRt = this.idaExpnTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaExpnTax = this.idaExpnTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaEduTaxRt = this.idaEduTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaEduTax = this.idaEduTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaHighEduTaxRt = this.idaHighEduTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaHighEduTax = this.idaHighEduTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaLoclTaxRt = this.idaLoclTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaN2ndLoclTaxRt = this.idaN2ndLoclTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaLoclTax = this.idaLoclTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaN2ndLoclTax = this.idaN2ndLoclTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxRto = this.taxRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrCntCd = this.usrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoArIfYn = this.autoArIfYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
