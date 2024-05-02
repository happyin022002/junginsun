/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IssuedInvoiceListVO.java
*@FileTitle : IssuedInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.20 김태균 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class IssuedInvoiceListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<IssuedInvoiceListVO> models = new ArrayList<IssuedInvoiceListVO>();

    /* Column Info */
    private String port = null;

    /* Column Info */
    private String invPrtFlg = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String issueId = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String bilAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String chgCurrCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String dcAmt = null;

    /* Column Info */
    private String taxAmt = null;

    /* Column Info */
    private String arIfNo = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String dmdtExptAmt = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String actPayrCd = null;

    /* Column Info */
    private String arIfDt = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String crInvNo = null;

    /* Column Info */
    private String actPayrNm = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String arIfUsrNm = null;

    /* Column Info */
    private String issueNm = null;

    /* Column Info */
    private String invOver = null;

    /* Column Info */
    private String ctrtOfc = null;

    /* Column Info */
    private String dmdtInvStsCd = null;

    /* Column Info */
    private String invChgAmt = null;

    /* Column Info */
    private String actDeltFlg = null;

    /* Column Info */
    private String invCurrCd = null;

    /* Column Info */
    private String arIfOfcCd = null;

    /* Column Info */
    private String arIfUsrId = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String ftDys = null;

    /* Column Info */
    private String invRmk = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String dmdtArIfCd = null;

    /* Column Info */
    private String orgChgAmt = null;

    /* Column Info */
    private String rhqOfcCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String fmMvmtDt = null;

    /* Column Info */
    private String toMvmtDt = null;

    /* Column Info */
    private String fxFtOvrDys = null;

    /* Column Info */
    private String cntrNoS = null;

    /* Column Info */
    private String colCharge = null;

    /* Column Info */
    private String colTax = null;

    /* Column Info */
    private String colDate = null;

    /* Column Info */
    private String colDueDt = null;

    /* Column Info */
    private String uncolAmt = null;

    /* Column Info */
    private String cntrCnt = null;

    private String sInvOver = null;

    private String sCreDt = null;

    private String sColDate = null;

    private String bkgCntrQty = null;

    private String otsCltFlg = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String dmdtInvTpCd = null;

    /* Column Info */
    private String rvsChgFlg = null;

    /* Column Info */
    private String issOfcCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String dmdtInvNo = null;

    /* Column Info */
    private String issDt = null;

    /* Column Info */
    private String sezFlg = null;

    /* Column Info */
    private String smGstnNo = null;

    /* Column Info */
    private String custGstnNo = null;

    /* Column Info */
    private String smSteCd = null;

    /* Column Info */
    private String custSteCd = null;

    /* Column Info */
    private String sacCd = null;

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
    private String ttlInvAmt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public IssuedInvoiceListVO() {
    }

    public IssuedInvoiceListVO(String ibflag, String pagerows, String dmdtInvNo, String invPrtFlg, String dmdtArIfCd, String dmdtInvStsCd, String dmdtTrfCd, String bkgNo, String blNo, String cntrNo, String ftDys, String scNo, String rfaNo, String chgCurrCd, String orgChgAmt, String dmdtExptAmt, String dcAmt, String bilAmt, String invCurrCd, String invChgAmt, String taxAmt, String invAmt, String port, String creDt, String creOfcCd, String issueId, String issueNm, String arIfDt, String arIfOfcCd, String arIfUsrId, String arIfUsrNm, String invOver, String actPayrCd, String actPayrNm, String crInvNo, String ctrtOfc, String actDeltFlg, String arIfNo, String invRmk, String rhqOfcCd, String porCd, String polCd, String podCd, String delCd, String fmMvmtDt, String toMvmtDt, String fxFtOvrDys, String cntrNoS, String colCharge, String colTax, String colDate, String colDueDt, String uncolAmt, String sInvOver, String sCreDt, String sColDate, String cntrCnt, String bkgCntrQty, String otsCltFlg, String taaNo, String dmdtInvTpCd, String rvsChgFlg, String issOfcCd, String custNm, String issDt, String sezFlg, String smGstnNo, String custGstnNo, String smSteCd, String custSteCd, String sacCd, String idaCgstRto, String idaCgstAmt, String idaSgstRto, String idaSgstAmt, String idaIgstRto, String idaIgstAmt, String idaUgstRto, String idaUgstAmt, String ttlInvAmt) {
        this.port = port;
        this.invPrtFlg = invPrtFlg;
        this.creDt = creDt;
        this.issueId = issueId;
        this.blNo = blNo;
        this.bilAmt = bilAmt;
        this.pagerows = pagerows;
        this.rfaNo = rfaNo;
        this.chgCurrCd = chgCurrCd;
        this.ibflag = ibflag;
        this.dcAmt = dcAmt;
        this.taxAmt = taxAmt;
        this.arIfNo = arIfNo;
        this.scNo = scNo;
        this.dmdtExptAmt = dmdtExptAmt;
        this.creOfcCd = creOfcCd;
        this.actPayrCd = actPayrCd;
        this.arIfDt = arIfDt;
        this.invAmt = invAmt;
        this.crInvNo = crInvNo;
        this.actPayrNm = actPayrNm;
        this.dmdtTrfCd = dmdtTrfCd;
        this.arIfUsrNm = arIfUsrNm;
        this.issueNm = issueNm;
        this.invOver = invOver;
        this.ctrtOfc = ctrtOfc;
        this.dmdtInvStsCd = dmdtInvStsCd;
        this.invChgAmt = invChgAmt;
        this.dmdtInvNo = dmdtInvNo;
        this.actDeltFlg = actDeltFlg;
        this.invCurrCd = invCurrCd;
        this.arIfOfcCd = arIfOfcCd;
        this.arIfUsrId = arIfUsrId;
        this.bkgNo = bkgNo;
        this.ftDys = ftDys;
        this.invRmk = invRmk;
        this.cntrNo = cntrNo;
        this.dmdtArIfCd = dmdtArIfCd;
        this.orgChgAmt = orgChgAmt;
        this.rhqOfcCd = rhqOfcCd;
        this.podCd = podCd;
        this.porCd = porCd;
        this.polCd = polCd;
        this.delCd = delCd;
        this.fmMvmtDt = fmMvmtDt;
        this.toMvmtDt = toMvmtDt;
        this.fxFtOvrDys = fxFtOvrDys;
        this.cntrNoS = cntrNoS;
        this.colCharge = colCharge;
        this.colTax = colTax;
        this.colDate = colDate;
        this.colDueDt = colDueDt;
        this.uncolAmt = uncolAmt;
        this.sInvOver = sInvOver;
        this.sCreDt = sCreDt;
        this.sColDate = sColDate;
        this.cntrCnt = cntrCnt;
        this.bkgCntrQty = bkgCntrQty;
        this.otsCltFlg = otsCltFlg;
        this.taaNo = taaNo;
        this.dmdtInvTpCd = dmdtInvTpCd;
        this.rvsChgFlg = rvsChgFlg;
        this.issOfcCd = issOfcCd;
        this.custNm = custNm;
        this.issDt = issDt;
        this.sezFlg = sezFlg;
        this.smGstnNo = smGstnNo;
        this.custGstnNo = custGstnNo;
        this.smSteCd = smSteCd;
        this.custSteCd = custSteCd;
        this.sacCd = sacCd;
        this.idaCgstRto = idaCgstRto;
        this.idaCgstAmt = idaCgstAmt;
        this.idaSgstRto = idaSgstRto;
        this.idaSgstAmt = idaSgstAmt;
        this.idaIgstRto = idaIgstRto;
        this.idaIgstAmt = idaIgstAmt;
        this.idaUgstRto = idaUgstRto;
        this.idaUgstAmt = idaUgstAmt;
        this.ttlInvAmt = ttlInvAmt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("port", getPort());
        this.hashColumns.put("inv_prt_flg", getInvPrtFlg());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("issue_id", getIssueId());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("bil_amt", getBilAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("chg_curr_cd", getChgCurrCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("dc_amt", getDcAmt());
        this.hashColumns.put("tax_amt", getTaxAmt());
        this.hashColumns.put("ar_if_no", getArIfNo());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("dmdt_expt_amt", getDmdtExptAmt());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("act_payr_cd", getActPayrCd());
        this.hashColumns.put("ar_if_dt", getArIfDt());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("cr_inv_no", getCrInvNo());
        this.hashColumns.put("act_payr_nm", getActPayrNm());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("ar_if_usr_nm", getArIfUsrNm());
        this.hashColumns.put("issue_nm", getIssueNm());
        this.hashColumns.put("inv_over", getInvOver());
        this.hashColumns.put("ctrt_ofc", getCtrtOfc());
        this.hashColumns.put("dmdt_inv_sts_cd", getDmdtInvStsCd());
        this.hashColumns.put("inv_chg_amt", getInvChgAmt());
        this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
        this.hashColumns.put("act_delt_flg", getActDeltFlg());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("ar_if_ofc_cd", getArIfOfcCd());
        this.hashColumns.put("ar_if_usr_id", getArIfUsrId());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ft_dys", getFtDys());
        this.hashColumns.put("inv_rmk", getInvRmk());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
        this.hashColumns.put("org_chg_amt", getOrgChgAmt());
        this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
        this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
        this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
        this.hashColumns.put("cntr_no_s", getCntrNoS());
        this.hashColumns.put("col_charge", getColCharge());
        this.hashColumns.put("col_tax", getColTax());
        this.hashColumns.put("col_date", getColDate());
        this.hashColumns.put("col_due_dt", getColDueDt());
        this.hashColumns.put("uncol_amt", getUncolAmt());
        this.hashColumns.put("s_inv_over", getsInvOver());
        this.hashColumns.put("s_cre_dt", getsCreDt());
        this.hashColumns.put("s_col_date", getsColDate());
        this.hashColumns.put("cntr_cnt", getCntrCnt());
        this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
        this.hashColumns.put("ots_clt_flg", getOtsCltFlg());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("dmdt_inv_tp_cd", getDmdtInvTpCd());
        this.hashColumns.put("rvs_chg_flg", getRvsChgFlg());
        this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
        this.hashColumns.put("iss_dt", getIssDt());
        this.hashColumns.put("sez_flg", getSezFlg());
        this.hashColumns.put("sm_gstn_no", getSmGstnNo());
        this.hashColumns.put("cust_gstn_no", getCustGstnNo());
        this.hashColumns.put("sm_ste_cd", getSmSteCd());
        this.hashColumns.put("cust_ste_cd", getCustSteCd());
        this.hashColumns.put("sac_cd", getSacCd());
        this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
        this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());
        this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
        this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());
        this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
        this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());
        this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
        this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());
        this.hashColumns.put("ttl_inv_amt", getTtlInvAmt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("port", "port");
        this.hashFields.put("inv_prt_flg", "invPrtFlg");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("issue_id", "issueId");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("bil_amt", "bilAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("chg_curr_cd", "chgCurrCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("dc_amt", "dcAmt");
        this.hashFields.put("tax_amt", "taxAmt");
        this.hashFields.put("ar_if_no", "arIfNo");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("dmdt_expt_amt", "dmdtExptAmt");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("act_payr_cd", "actPayrCd");
        this.hashFields.put("ar_if_dt", "arIfDt");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("cr_inv_no", "crInvNo");
        this.hashFields.put("act_payr_nm", "actPayrNm");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("ar_if_usr_nm", "arIfUsrNm");
        this.hashFields.put("issue_nm", "issueNm");
        this.hashFields.put("inv_over", "invOver");
        this.hashFields.put("ctrt_ofc", "ctrtOfc");
        this.hashFields.put("dmdt_inv_sts_cd", "dmdtInvStsCd");
        this.hashFields.put("inv_chg_amt", "invChgAmt");
        this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
        this.hashFields.put("act_delt_flg", "actDeltFlg");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("ar_if_ofc_cd", "arIfOfcCd");
        this.hashFields.put("ar_if_usr_id", "arIfUsrId");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ft_dys", "ftDys");
        this.hashFields.put("inv_rmk", "invRmk");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
        this.hashFields.put("org_chg_amt", "orgChgAmt");
        this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
        this.hashFields.put("to_mvmt_dt", "toMvmtDt");
        this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
        this.hashFields.put("cntr_no_s", "cntrNoS");
        this.hashFields.put("col_charge", "colCharge");
        this.hashFields.put("col_tax", "colTax");
        this.hashFields.put("col_date", "colDate");
        this.hashFields.put("col_due_dt", "colDueDt");
        this.hashFields.put("uncol_amt", "uncolAmt");
        this.hashFields.put("s_inv_over", "sInvOver");
        this.hashFields.put("s_cre_dt", "sCreDt");
        this.hashFields.put("s_col_date", "sColDate");
        this.hashFields.put("cntr_cnt", "cntrCnt");
        this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
        this.hashFields.put("ots_clt_flg", "otsCltFlg");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("dmdt_inv_tp_cd", "dmdtInvTpCd");
        this.hashFields.put("rvs_chg_flg", "rvsChgFlg");
        this.hashFields.put("iss_ofc_cd", "issOfcCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
        this.hashFields.put("iss_dt", "issDt");
        this.hashFields.put("sez_flg", "sezFlg");
        this.hashFields.put("sm_gstn_no", "smGstnNo");
        this.hashFields.put("cust_gstn_no", "custGstnNo");
        this.hashFields.put("sm_ste_cd", "smSteCd");
        this.hashFields.put("cust_ste_cd", "custSteCd");
        this.hashFields.put("sac_cd", "sacCd");
        this.hashFields.put("ida_cgst_rto", "idaCgstRto");
        this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
        this.hashFields.put("ida_sgst_rto", "idaSgstRto");
        this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
        this.hashFields.put("ida_igst_rto", "idaIgstRto");
        this.hashFields.put("ida_igst_amt", "idaIgstAmt");
        this.hashFields.put("ida_ugst_rto", "idaUgstRto");
        this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
        this.hashFields.put("ttl_inv_amt", "ttlInvAmt");
        this.hashFields.put("ttl_tax_amt", "ttlTaxAmt");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return port
	 */
    public String getPort() {
        return this.port;
    }

    /**
	 * Column Info
	 * @return invPrtFlg
	 */
    public String getInvPrtFlg() {
        return this.invPrtFlg;
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
	 * @return issueId
	 */
    public String getIssueId() {
        return this.issueId;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return bilAmt
	 */
    public String getBilAmt() {
        return this.bilAmt;
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
	 * @return rfaNo
	 */
    public String getRfaNo() {
        return this.rfaNo;
    }

    /**
	 * Column Info
	 * @return chgCurrCd
	 */
    public String getChgCurrCd() {
        return this.chgCurrCd;
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
	 * @return dcAmt
	 */
    public String getDcAmt() {
        return this.dcAmt;
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
	 * @return arIfNo
	 */
    public String getArIfNo() {
        return this.arIfNo;
    }

    /**
	 * Column Info
	 * @return scNo
	 */
    public String getScNo() {
        return this.scNo;
    }

    /**
	 * Column Info
	 * @return dmdtExptAmt
	 */
    public String getDmdtExptAmt() {
        return this.dmdtExptAmt;
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
	 * @return actPayrCd
	 */
    public String getActPayrCd() {
        return this.actPayrCd;
    }

    /**
	 * Column Info
	 * @return arIfDt
	 */
    public String getArIfDt() {
        return this.arIfDt;
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
	 * @return crInvNo
	 */
    public String getCrInvNo() {
        return this.crInvNo;
    }

    /**
	 * Column Info
	 * @return actPayrNm
	 */
    public String getActPayrNm() {
        return this.actPayrNm;
    }

    /**
	 * Column Info
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @return arIfUsrNm
	 */
    public String getArIfUsrNm() {
        return this.arIfUsrNm;
    }

    /**
	 * Column Info
	 * @return issueNm
	 */
    public String getIssueNm() {
        return this.issueNm;
    }

    /**
	 * Column Info
	 * @return invOver
	 */
    public String getInvOver() {
        return this.invOver;
    }

    /**
	 * Column Info
	 * @return ctrtOfc
	 */
    public String getCtrtOfc() {
        return this.ctrtOfc;
    }

    /**
	 * Column Info
	 * @return dmdtInvStsCd
	 */
    public String getDmdtInvStsCd() {
        return this.dmdtInvStsCd;
    }

    /**
	 * Column Info
	 * @return invChgAmt
	 */
    public String getInvChgAmt() {
        return this.invChgAmt;
    }

    /**
	 * Column Info
	 * @return actDeltFlg
	 */
    public String getActDeltFlg() {
        return this.actDeltFlg;
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
	 * @return arIfOfcCd
	 */
    public String getArIfOfcCd() {
        return this.arIfOfcCd;
    }

    /**
	 * Column Info
	 * @return arIfUsrId
	 */
    public String getArIfUsrId() {
        return this.arIfUsrId;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return ftDys
	 */
    public String getFtDys() {
        return this.ftDys;
    }

    /**
	 * Column Info
	 * @return invRmk
	 */
    public String getInvRmk() {
        return this.invRmk;
    }

    /**
	 * Column Info
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return dmdtArIfCd
	 */
    public String getDmdtArIfCd() {
        return this.dmdtArIfCd;
    }

    /**
	 * Column Info
	 * @return orgChgAmt
	 */
    public String getOrgChgAmt() {
        return this.orgChgAmt;
    }

    /**
	 * Column Info
	 * @return rhqOfcCd
	 */
    public String getRhqOfcCd() {
        return rhqOfcCd;
    }

    public String getPorCd() {
        return porCd;
    }

    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    public String getPolCd() {
        return polCd;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPodCd() {
        return podCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public String getDelCd() {
        return delCd;
    }

    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param port
	 */
    public void setPort(String port) {
        this.port = port;
    }

    /**
	 * Column Info
	 * @param invPrtFlg
	 */
    public void setInvPrtFlg(String invPrtFlg) {
        this.invPrtFlg = invPrtFlg;
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
	 * @param issueId
	 */
    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param bilAmt
	 */
    public void setBilAmt(String bilAmt) {
        this.bilAmt = bilAmt;
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
	 * @param rfaNo
	 */
    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
    }

    /**
	 * Column Info
	 * @param chgCurrCd
	 */
    public void setChgCurrCd(String chgCurrCd) {
        this.chgCurrCd = chgCurrCd;
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
	 * @param dcAmt
	 */
    public void setDcAmt(String dcAmt) {
        this.dcAmt = dcAmt;
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
	 * @param arIfNo
	 */
    public void setArIfNo(String arIfNo) {
        this.arIfNo = arIfNo;
    }

    /**
	 * Column Info
	 * @param scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    /**
	 * Column Info
	 * @param dmdtExptAmt
	 */
    public void setDmdtExptAmt(String dmdtExptAmt) {
        this.dmdtExptAmt = dmdtExptAmt;
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
	 * @param actPayrCd
	 */
    public void setActPayrCd(String actPayrCd) {
        this.actPayrCd = actPayrCd;
    }

    /**
	 * Column Info
	 * @param arIfDt
	 */
    public void setArIfDt(String arIfDt) {
        this.arIfDt = arIfDt;
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
	 * @param crInvNo
	 */
    public void setCrInvNo(String crInvNo) {
        this.crInvNo = crInvNo;
    }

    /**
	 * Column Info
	 * @param actPayrNm
	 */
    public void setActPayrNm(String actPayrNm) {
        this.actPayrNm = actPayrNm;
    }

    /**
	 * Column Info
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param arIfUsrNm
	 */
    public void setArIfUsrNm(String arIfUsrNm) {
        this.arIfUsrNm = arIfUsrNm;
    }

    /**
	 * Column Info
	 * @param issueNm
	 */
    public void setIssueNm(String issueNm) {
        this.issueNm = issueNm;
    }

    /**
	 * Column Info
	 * @param invOver
	 */
    public void setInvOver(String invOver) {
        this.invOver = invOver;
    }

    /**
	 * Column Info
	 * @param ctrtOfc
	 */
    public void setCtrtOfc(String ctrtOfc) {
        this.ctrtOfc = ctrtOfc;
    }

    /**
	 * Column Info
	 * @param dmdtInvStsCd
	 */
    public void setDmdtInvStsCd(String dmdtInvStsCd) {
        this.dmdtInvStsCd = dmdtInvStsCd;
    }

    /**
	 * Column Info
	 * @param invChgAmt
	 */
    public void setInvChgAmt(String invChgAmt) {
        this.invChgAmt = invChgAmt;
    }

    /**
	 * Column Info
	 * @param actDeltFlg
	 */
    public void setActDeltFlg(String actDeltFlg) {
        this.actDeltFlg = actDeltFlg;
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
	 * @param arIfOfcCd
	 */
    public void setArIfOfcCd(String arIfOfcCd) {
        this.arIfOfcCd = arIfOfcCd;
    }

    /**
	 * Column Info
	 * @param arIfUsrId
	 */
    public void setArIfUsrId(String arIfUsrId) {
        this.arIfUsrId = arIfUsrId;
    }

    /**
	 * Column Info
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param ftDys
	 */
    public void setFtDys(String ftDys) {
        this.ftDys = ftDys;
    }

    /**
	 * Column Info
	 * @param invRmk
	 */
    public void setInvRmk(String invRmk) {
        this.invRmk = invRmk;
    }

    /**
	 * Column Info
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param dmdtArIfCd
	 */
    public void setDmdtArIfCd(String dmdtArIfCd) {
        this.dmdtArIfCd = dmdtArIfCd;
    }

    /**
	 * Column Info
	 * @param orgChgAmt
	 */
    public void setOrgChgAmt(String orgChgAmt) {
        this.orgChgAmt = orgChgAmt;
    }

    /**
	 * Column Info
	 * @return rhqOfcCd
	 */
    public void setRhqOfcCd(String rhqOfcCd) {
        this.rhqOfcCd = rhqOfcCd;
    }

    public String getFmMvmtDt() {
        return fmMvmtDt;
    }

    public void setFmMvmtDt(String fmMvmtDt) {
        this.fmMvmtDt = fmMvmtDt;
    }

    public String getToMvmtDt() {
        return toMvmtDt;
    }

    public void setToMvmtDt(String toMvmtDt) {
        this.toMvmtDt = toMvmtDt;
    }

    public String getFxFtOvrDys() {
        return fxFtOvrDys;
    }

    public void setFxFtOvrDys(String fxFtOvrDys) {
        this.fxFtOvrDys = fxFtOvrDys;
    }

    public String getCntrNoS() {
        return cntrNoS;
    }

    public void setCntrNoS(String cntrNoS) {
        this.cntrNoS = cntrNoS;
    }

    public String getBkgCntrQty() {
        return bkgCntrQty;
    }

    public void setBkgCntrQty(String bkgCntrQty) {
        this.bkgCntrQty = bkgCntrQty;
    }

    public String getOtsCltFlg() {
        return otsCltFlg;
    }

    public void setOtsCltFlg(String otsCltFlg) {
        this.otsCltFlg = otsCltFlg;
    }

    public String getCntrCnt() {
        return cntrCnt;
    }

    public void setCntrCnt(String cntrCnt) {
        this.cntrCnt = cntrCnt;
    }

    public String getsInvOver() {
        return sInvOver;
    }

    public void setsInvOver(String sInvOver) {
        this.sInvOver = sInvOver;
    }

    public String getsCreDt() {
        return sCreDt;
    }

    public void setsCreDt(String sCreDt) {
        this.sCreDt = sCreDt;
    }

    public String getsColDate() {
        return sColDate;
    }

    public void setsColDate(String sColDate) {
        this.sColDate = sColDate;
    }

    public String getColCharge() {
        return colCharge;
    }

    public void setColCharge(String colCharge) {
        this.colCharge = colCharge;
    }

    public String getColTax() {
        return colTax;
    }

    public void setColTax(String colTax) {
        this.colTax = colTax;
    }

    public String getColDate() {
        return colDate;
    }

    public void setColDate(String colDate) {
        this.colDate = colDate;
    }

    public String getColDueDt() {
        return colDueDt;
    }

    public void setColDueDt(String colDueDt) {
        this.colDueDt = colDueDt;
    }

    public String getUncolAmt() {
        return uncolAmt;
    }

    public void setUncolAmt(String uncolAmt) {
        this.uncolAmt = uncolAmt;
    }
    
    public String getTaaNo() {
        return taaNo;
    }

    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
    }

    public void setDmdtInvTpCd(String dmdtInvTpCd) {
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    public String getDmdtInvTpCd() {
        return this.dmdtInvTpCd;
    }

    public void setRvsChgFlg(String rvsChgFlg) {
        this.rvsChgFlg = rvsChgFlg;
    }

    public String getRvsChgFlg() {
        return this.rvsChgFlg;
    }

    public void setIssOfcCd(String issOfcCd) {
        this.issOfcCd = issOfcCd;
    }

    public String getIssOfcCd() {
        return this.issOfcCd;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    public String getCustNm() {
        return this.custNm;
    }

    public void setDmdtInvNo(String dmdtInvNo) {
        this.dmdtInvNo = dmdtInvNo;
    }

    public String getDmdtInvNo() {
        return this.dmdtInvNo;
    }

    public void setIssDt(String issDt) {
        this.issDt = issDt;
    }

    public String getIssDt() {
        return this.issDt;
    }

    public void setSezFlg(String sezFlg) {
        this.sezFlg = sezFlg;
    }

    public String getSezFlg() {
        return this.sezFlg;
    }

    public void setSmGstnNo(String smGstnNo) {
        this.smGstnNo = smGstnNo;
    }

    public String getSmGstnNo() {
        return this.smGstnNo;
    }

    public void setCustGstnNo(String custGstnNo) {
        this.custGstnNo = custGstnNo;
    }

    public String getCustGstnNo() {
        return this.custGstnNo;
    }

    public void setSmSteCd(String smSteCd) {
        this.smSteCd = smSteCd;
    }

    public String getSmSteCd() {
        return this.smSteCd;
    }

    public void setCustSteCd(String custSteCd) {
        this.custSteCd = custSteCd;
    }

    public String getCustSteCd() {
        return this.custSteCd;
    }

    public void setSacCd(String sacCd) {
        this.sacCd = sacCd;
    }

    public String getSacCd() {
        return this.sacCd;
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

    public void setTtlInvAmt(String ttlInvAmt) {
        this.ttlInvAmt = ttlInvAmt;
    }

    public String getTtlInvAmt() {
        return this.ttlInvAmt;
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
        setPort(JSPUtil.getParameter(request, prefix + "port", ""));
        setInvPrtFlg(JSPUtil.getParameter(request, prefix + "inv_prt_flg", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setIssueId(JSPUtil.getParameter(request, prefix + "issue_id", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
        setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
        setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setDmdtExptAmt(JSPUtil.getParameter(request, prefix + "dmdt_expt_amt", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setActPayrCd(JSPUtil.getParameter(request, prefix + "act_payr_cd", ""));
        setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setCrInvNo(JSPUtil.getParameter(request, prefix + "cr_inv_no", ""));
        setActPayrNm(JSPUtil.getParameter(request, prefix + "act_payr_nm", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setArIfUsrNm(JSPUtil.getParameter(request, prefix + "ar_if_usr_nm", ""));
        setIssueNm(JSPUtil.getParameter(request, prefix + "issue_nm", ""));
        setInvOver(JSPUtil.getParameter(request, prefix + "inv_over", ""));
        setCtrtOfc(JSPUtil.getParameter(request, prefix + "ctrt_ofc", ""));
        setDmdtInvStsCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_cd", ""));
        setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
        setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
        setActDeltFlg(JSPUtil.getParameter(request, prefix + "act_delt_flg", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setArIfOfcCd(JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", ""));
        setArIfUsrId(JSPUtil.getParameter(request, prefix + "ar_if_usr_id", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
        setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
        setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
        setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
        setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
        setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
        setCntrNoS(JSPUtil.getParameter(request, prefix + "cntr_no_s", ""));
        setColCharge(JSPUtil.getParameter(request, prefix + "col_charge", ""));
        setColTax(JSPUtil.getParameter(request, prefix + "col_tax", ""));
        setColDate(JSPUtil.getParameter(request, prefix + "col_date", ""));
        setColDueDt(JSPUtil.getParameter(request, prefix + "col_due_dt", ""));
        setUncolAmt(JSPUtil.getParameter(request, prefix + "uncol_amt", ""));
        setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setDmdtInvTpCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", ""));
        setRvsChgFlg(JSPUtil.getParameter(request, prefix + "rvs_chg_flg", ""));
        setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
        setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
        setSezFlg(JSPUtil.getParameter(request, prefix + "sez_flg", ""));
        setSmGstnNo(JSPUtil.getParameter(request, prefix + "sm_gstn_no", ""));
        setCustGstnNo(JSPUtil.getParameter(request, prefix + "cust_gstn_no", ""));
        setSmSteCd(JSPUtil.getParameter(request, prefix + "sm_ste_cd", ""));
        setCustSteCd(JSPUtil.getParameter(request, prefix + "cust_ste_cd", ""));
        setSacCd(JSPUtil.getParameter(request, prefix + "sac_cd", ""));
        setIdaCgstRto(JSPUtil.getParameter(request, prefix + "ida_cgst_rto", ""));
        setIdaCgstAmt(JSPUtil.getParameter(request, prefix + "ida_cgst_amt", ""));
        setIdaSgstRto(JSPUtil.getParameter(request, prefix + "ida_sgst_rto", ""));
        setIdaSgstAmt(JSPUtil.getParameter(request, prefix + "ida_sgst_amt", ""));
        setIdaIgstRto(JSPUtil.getParameter(request, prefix + "ida_igst_rto", ""));
        setIdaIgstAmt(JSPUtil.getParameter(request, prefix + "ida_igst_amt", ""));
        setIdaUgstRto(JSPUtil.getParameter(request, prefix + "ida_ugst_rto", ""));
        setIdaUgstAmt(JSPUtil.getParameter(request, prefix + "ida_ugst_amt", ""));
        setTtlInvAmt(JSPUtil.getParameter(request, prefix + "ttl_inv_amt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IssuedInvoiceListVO[]
	 */
    public IssuedInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IssuedInvoiceListVO[]
	 */
    public IssuedInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        IssuedInvoiceListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] port = (JSPUtil.getParameter(request, prefix + "port", length));
            String[] invPrtFlg = (JSPUtil.getParameter(request, prefix + "inv_prt_flg", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] issueId = (JSPUtil.getParameter(request, prefix + "issue_id", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] bilAmt = (JSPUtil.getParameter(request, prefix + "bil_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] chgCurrCd = (JSPUtil.getParameter(request, prefix + "chg_curr_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] dcAmt = (JSPUtil.getParameter(request, prefix + "dc_amt", length));
            String[] taxAmt = (JSPUtil.getParameter(request, prefix + "tax_amt", length));
            String[] arIfNo = (JSPUtil.getParameter(request, prefix + "ar_if_no", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] dmdtExptAmt = (JSPUtil.getParameter(request, prefix + "dmdt_expt_amt", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] actPayrCd = (JSPUtil.getParameter(request, prefix + "act_payr_cd", length));
            String[] arIfDt = (JSPUtil.getParameter(request, prefix + "ar_if_dt", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] crInvNo = (JSPUtil.getParameter(request, prefix + "cr_inv_no", length));
            String[] actPayrNm = (JSPUtil.getParameter(request, prefix + "act_payr_nm", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] arIfUsrNm = (JSPUtil.getParameter(request, prefix + "ar_if_usr_nm", length));
            String[] issueNm = (JSPUtil.getParameter(request, prefix + "issue_nm", length));
            String[] invOver = (JSPUtil.getParameter(request, prefix + "inv_over", length));
            String[] ctrtOfc = (JSPUtil.getParameter(request, prefix + "ctrt_ofc", length));
            String[] dmdtInvStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_cd", length));
            String[] invChgAmt = (JSPUtil.getParameter(request, prefix + "inv_chg_amt", length));
            String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_inv_no", length));
            String[] actDeltFlg = (JSPUtil.getParameter(request, prefix + "act_delt_flg", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] arIfOfcCd = (JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", length));
            String[] arIfUsrId = (JSPUtil.getParameter(request, prefix + "ar_if_usr_id", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ftDys = (JSPUtil.getParameter(request, prefix + "ft_dys", length));
            String[] invRmk = (JSPUtil.getParameter(request, prefix + "inv_rmk", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", length));
            String[] orgChgAmt = (JSPUtil.getParameter(request, prefix + "org_chg_amt", length));
            String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", length));
            String[] toMvmtDt = (JSPUtil.getParameter(request, prefix + "to_mvmt_dt", length));
            String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", length));
            String[] cntrNoS = (JSPUtil.getParameter(request, prefix + "cntr_no_s", length));
            String[] colCharge = (JSPUtil.getParameter(request, prefix + "col_charge", length));
            String[] colTax = (JSPUtil.getParameter(request, prefix + "col_tax", length));
            String[] colDate = (JSPUtil.getParameter(request, prefix + "col_date", length));
            String[] colDueDt = (JSPUtil.getParameter(request, prefix + "col_due_dt", length));
            String[] uncolAmt = (JSPUtil.getParameter(request, prefix + "uncol_amt", length));
            String[] cntrCnt = (JSPUtil.getParameter(request, prefix + "cntr_cnt", length));
            String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix + "bkg_cntr_qty", length));
            String[] otsCltFlg = (JSPUtil.getParameter(request, prefix + "ots_clt_flg", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] dmdtInvTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", length));
            String[] rvsChgFlg = (JSPUtil.getParameter(request, prefix + "rvs_chg_flg", length));
	    	String[] issOfcCd = (JSPUtil.getParameter(request, prefix + "iss_ofc_cd", length));
	    	String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
	    	String[] issDt = (JSPUtil.getParameter(request, prefix + "iss_dt", length));
	    	String[] sezFlg = (JSPUtil.getParameter(request, prefix + "sez_flg", length));
	    	String[] smGstnNo = (JSPUtil.getParameter(request, prefix + "sm_gstn_no", length));
	    	String[] custGstnNo = (JSPUtil.getParameter(request, prefix + "cust_gstn_no", length));
	    	String[] smSteCd = (JSPUtil.getParameter(request, prefix + "sm_ste_cd", length));
	    	String[] custSteCd = (JSPUtil.getParameter(request, prefix + "cust_ste_cd", length));
	    	String[] sacCd = (JSPUtil.getParameter(request, prefix + "sac_cd", length));
	    	String[] idaCgstRto = (JSPUtil.getParameter(request, prefix + "ida_cgst_rto", length));
	    	String[] idaCgstAmt = (JSPUtil.getParameter(request, prefix + "ida_cgst_amt", length));
	    	String[] idaSgstRto = (JSPUtil.getParameter(request, prefix + "ida_sgst_rto", length));
	    	String[] idaSgstAmt = (JSPUtil.getParameter(request, prefix + "ida_sgst_amt", length));
	    	String[] idaIgstRto = (JSPUtil.getParameter(request, prefix + "ida_igst_rto", length));
	    	String[] idaIgstAmt = (JSPUtil.getParameter(request, prefix + "ida_igst_amt", length));
	    	String[] idaUgstRto = (JSPUtil.getParameter(request, prefix + "ida_ugst_rto", length));
	    	String[] idaUgstAmt = (JSPUtil.getParameter(request, prefix + "ida_ugst_amt", length));
	    	String[] ttlInvAmt = (JSPUtil.getParameter(request, prefix + "ttl_inv_amt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new IssuedInvoiceListVO();
                if (port[i] != null)
                    model.setPort(port[i]);
                if (invPrtFlg[i] != null)
                    model.setInvPrtFlg(invPrtFlg[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (issueId[i] != null)
                    model.setIssueId(issueId[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (bilAmt[i] != null)
                    model.setBilAmt(bilAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (chgCurrCd[i] != null)
                    model.setChgCurrCd(chgCurrCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (dcAmt[i] != null)
                    model.setDcAmt(dcAmt[i]);
                if (taxAmt[i] != null)
                    model.setTaxAmt(taxAmt[i]);
                if (arIfNo[i] != null)
                    model.setArIfNo(arIfNo[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (dmdtExptAmt[i] != null)
                    model.setDmdtExptAmt(dmdtExptAmt[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (actPayrCd[i] != null)
                    model.setActPayrCd(actPayrCd[i]);
                if (arIfDt[i] != null)
                    model.setArIfDt(arIfDt[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (crInvNo[i] != null)
                    model.setCrInvNo(crInvNo[i]);
                if (actPayrNm[i] != null)
                    model.setActPayrNm(actPayrNm[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (arIfUsrNm[i] != null)
                    model.setArIfUsrNm(arIfUsrNm[i]);
                if (issueNm[i] != null)
                    model.setIssueNm(issueNm[i]);
                if (invOver[i] != null)
                    model.setInvOver(invOver[i]);
                if (ctrtOfc[i] != null)
                    model.setCtrtOfc(ctrtOfc[i]);
                if (dmdtInvStsCd[i] != null)
                    model.setDmdtInvStsCd(dmdtInvStsCd[i]);
                if (invChgAmt[i] != null)
                    model.setInvChgAmt(invChgAmt[i]);
                if (dmdtInvNo[i] != null)
                    model.setDmdtInvNo(dmdtInvNo[i]);
                if (actDeltFlg[i] != null)
                    model.setActDeltFlg(actDeltFlg[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (arIfOfcCd[i] != null)
                    model.setArIfOfcCd(arIfOfcCd[i]);
                if (arIfUsrId[i] != null)
                    model.setArIfUsrId(arIfUsrId[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ftDys[i] != null)
                    model.setFtDys(ftDys[i]);
                if (invRmk[i] != null)
                    model.setInvRmk(invRmk[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (dmdtArIfCd[i] != null)
                    model.setDmdtArIfCd(dmdtArIfCd[i]);
                if (orgChgAmt[i] != null)
                    model.setOrgChgAmt(orgChgAmt[i]);
                if (rhqOfcCd[i] != null)
                    model.setRhqOfcCd(rhqOfcCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (fmMvmtDt[i] != null)
                    model.setFmMvmtDt(fmMvmtDt[i]);
                if (toMvmtDt[i] != null)
                    model.setToMvmtDt(toMvmtDt[i]);
                if (fxFtOvrDys[i] != null)
                    model.setFxFtOvrDys(fxFtOvrDys[i]);
                if (cntrNoS[i] != null)
                    model.setCntrNoS(cntrNoS[i]);
                if (colCharge[i] != null)
                    model.setColCharge(colCharge[i]);
                if (colTax[i] != null)
                    model.setColTax(colTax[i]);
                if (colDate[i] != null)
                    model.setColDate(colDate[i]);
                if (colDueDt[i] != null)
                    model.setColDueDt(colDueDt[i]);
                if (uncolAmt[i] != null)
                    model.setUncolAmt(uncolAmt[i]);
                if (cntrCnt[i] != null)
                    model.setCntrCnt(cntrCnt[i]);
                if (bkgCntrQty[i] != null)
                    model.setBkgCntrQty(bkgCntrQty[i]);
                if (otsCltFlg[i] != null)
                    model.setOtsCltFlg(otsCltFlg[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (dmdtInvTpCd[i] != null)
                    model.setDmdtInvTpCd(dmdtInvTpCd[i]);
                if (rvsChgFlg[i] != null) 
		    		model.setRvsChgFlg(rvsChgFlg[i]);
				if (issOfcCd[i] != null) 
		    		model.setIssOfcCd(issOfcCd[i]);
				if (custNm[i] != null) 
		    		model.setCustNm(custNm[i]);
				if (issDt[i] != null) 
		    		model.setIssDt(issDt[i]);
				if (sezFlg[i] != null) 
		    		model.setSezFlg(sezFlg[i]);
				if (smGstnNo[i] != null) 
		    		model.setSmGstnNo(smGstnNo[i]);
				if (custGstnNo[i] != null) 
		    		model.setCustGstnNo(custGstnNo[i]);
				if (smSteCd[i] != null) 
		    		model.setSmSteCd(smSteCd[i]);
				if (custSteCd[i] != null) 
		    		model.setCustSteCd(custSteCd[i]);
				if (sacCd[i] != null) 
		    		model.setSacCd(sacCd[i]);
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
				if (ttlInvAmt[i] != null) 
		    		model.setTtlInvAmt(ttlInvAmt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getIssuedInvoiceListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return IssuedInvoiceListVO[]
	 */
    public IssuedInvoiceListVO[] getIssuedInvoiceListVOs() {
        IssuedInvoiceListVO[] vos = (IssuedInvoiceListVO[]) models.toArray(new IssuedInvoiceListVO[models.size()]);
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
        this.port = this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPrtFlg = this.invPrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issueId = this.issueId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilAmt = this.bilAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgCurrCd = this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcAmt = this.dcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxAmt = this.taxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfNo = this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtExptAmt = this.dmdtExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actPayrCd = this.actPayrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfDt = this.arIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crInvNo = this.crInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actPayrNm = this.actPayrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfUsrNm = this.arIfUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issueNm = this.issueNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invOver = this.invOver.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtOfc = this.ctrtOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvStsCd = this.dmdtInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invChgAmt = this.invChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvNo = this.dmdtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actDeltFlg = this.actDeltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfOfcCd = this.arIfOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfUsrId = this.arIfUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDys = this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk = this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtArIfCd = this.dmdtArIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgChgAmt = this.orgChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfcCd = this.rhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtDt = this.fmMvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toMvmtDt = this.toMvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fxFtOvrDys = this.fxFtOvrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNoS = this.cntrNoS.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colCharge = this.colCharge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colTax = this.colTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colDate = this.colDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colDueDt = this.colDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uncolAmt = this.uncolAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCnt = this.cntrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntrQty = this.bkgCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsCltFlg = this.otsCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvTpCd = this.dmdtInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rvsChgFlg = this.rvsChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issOfcCd = this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issDt = this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sezFlg = this.sezFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.smGstnNo = this.smGstnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custGstnNo = this.custGstnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.smSteCd = this.smSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSteCd = this.custSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sacCd = this.sacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstRto = this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstAmt = this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstRto = this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstAmt = this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstRto = this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstAmt = this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstRto = this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstAmt = this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlInvAmt = this.ttlInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
