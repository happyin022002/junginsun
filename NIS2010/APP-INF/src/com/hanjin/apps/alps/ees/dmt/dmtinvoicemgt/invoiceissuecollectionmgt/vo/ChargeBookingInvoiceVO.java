/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeBookingInvoiceVO.java
*@FileTitle : ChargeBookingInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21  
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
public class ChargeBookingInvoiceVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ChargeBookingInvoiceVO> models = new ArrayList<ChargeBookingInvoiceVO>();

    /* Column Info */
    private String taxRto = null;

    /* Column Info */
    private String invPrtFlg = null;

    /* Column Info */
    private String faxEmailSndCnt = null;

    /* Column Info */
    private String invHldRsnNm = null;

    /* Column Info */
    private String invTaxRto = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String chgCurrCd = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String dcAmt = null;

    /* Column Info */
    private String bkgCustNm = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String aftInvAdjAmt = null;

    /* Column Info */
    private String cntCd = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String dmdtTrfCd = null;

    /* Column Info */
    private String invXchRt = null;

    /* Column Info */
    private String payerCd = null;

    /* Column Info */
    private String ntcKntCd = null;

    /* Column Info */
    private String truckerCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String cntrCnt = null;

    /* Column Info */
    private String creUsrNm = null;

    /* Column Info */
    private String actCustCd = null;

    /* Column Info */
    private String dmdtPayrCntcPntNm = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String dmdtCxlRsnNm = null;

    /* Column Info */
    private String caller = null;

    /* Column Info */
    private String totAmt = null;

    /* Column Info */
    private String mnlInvSndFlg = null;

    /* Column Info */
    private String mnOrgChgAmt = null;

    /* Column Info */
    private String dmdtInvStsNm = null;

    /* Column Info */
    private String taxAmt = null;

    /* Column Info */
    private String payerNm = null;

    /* Column Info */
    private String dueDate = null;

    /* Column Info */
    private String crTermDys = null;

    /* Column Info */
    private String chgType = null;

    /* Column Info */
    private String chgDcAmt = null;

    /* Column Info */
    private String payrCntcPntEml = null;

    /* Column Info */
    private String dmdtInvStsCd = null;

    /* Column Info */
    private String invChgAmt = null;

    /* Column Info */
    private String dmdtInvNo = null;

    /* Column Info */
    private String arIfUsrId = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String issDtPrnFlg = null;

    /* Column Info */
    private String invRmk = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String invHldRsnCd = null;

    /* Column Info */
    private String orgChgAmt = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String mnBilAmt = null;

    /* Column Info */
    private String vndrNm = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String dmdtExptAmt = null;

    /* Column Info */
    private String bkgCustCd = null;

    /* Column Info */
    private String arIfDt = null;

    /* Column Info */
    private String updOfcCd = null;

    /* Column Info */
    private String crArYn = null;

    /* Column Info */
    private String truckerNm = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String arIfOfcCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String dmdtCxlRsnCd = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String dmdtArIfCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String custCntcPntSeq = null;

    /* Column Info */
    private String mnlInvRmk = null;

    /* Column Info */
    private String overDay = null;

    /* Column Info */
    private String creDt = null;

    /* Column Info */
    private String invRmk2 = null;

    /* Column Info */
    private String invRmk1 = null;

    /* Column Info */
    private String rd = null;

    /* Column Info */
    private String bilAmt = null;

    /* Column Info */
    private String payrCntcPntFaxNo = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String svrId = null;

    /* Column Info */
    private String cxlRmk = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String creOfcCd = null;

    /* Column Info */
    private String invAmt = null;

    /* Column Info */
    private String crInvNo = null;

    /* Column Info */
    private String arIfUsrNm = null;

    /* Column Info */
    private String invHldRmk = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String invRefNo = null;

    /* Column Info */
    private String issueDay = null;

    /* Column Info */
    private String creCntCd = null;

    /* Column Info */
    private String invCurrCd = null;

    /* Column Info */
    private String bilToLocDivCd = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String payrCntcPntPhnNo = null;

    /* Column Info */
    private String actCustNm = null;

    /* Column Info */
    private String actPayrCustNm = null;

    /* Column Info */
    private String useRtCurr = null;

    /* Column Info */
    private String updUsrNm = null;

    /* Column Info */
    private String rhqOfcCd = null;

    /* Column Info */
    private String idaExpnTaxRt = null;

    /* Column Info */
    private String idaExpnTax = null;

    /* Column Info */
    private String idaEduTax = null;

    /* Column Info */
    private String idaEduTaxRt = null;

    /* Column Info */
    private String idaHighEduTaxRt = null;

    /* Column Info */
    private String idaHighEduTax = null;

    /* Column Info */
    private String taxRgstNo = null;

    /* Column Info */
    private String pmntAcctNo = null;

    /* Column Info */
    private String svcCateRmk = null;

    /* Column Info */
    private String dmdtVtInvStsCd = null;

    /* Column Info */
    private String dmdtVtInvNo = null;

    /* Column Info */
    private String dmdtVtInvYn = null;

    /* Column Info */
    private String invNewRptFlg = null;

    /* Column Info */
    private String colDate = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String colAmt = null;

    /* Column Info */
    private String colCharge = null;

    /* Column Info */
    private String colTax = null;

    /* Column Info */
    private String colOverDay = null;

    /* Column Info */
    private String otsCltFlg = null;

    /* Column Info */
    private String vtCollected = null;

    /* Column Info */
    private String invUncolAmt = null;

    /* Column Info */
    private String chgUncolAmt = null;

    /* Column Info */
    private String invColCharge = null;

    /* Column Info */
    private String invColTax = null;

    /* Column Info */
    private String chgColCharge = null;

    /* Column Info */
    private String chgColTax = null;

    /* Column Info */
    private String idaLoclTaxRt = null;

    /* Column Info */
    private String idaLoclTax = null;

    /* Column Info */
    private String idaN2ndLoclTaxRt = null;

    /* Column Info */
    private String idaN2ndLoclTax = null;

    /* Column Info */
    private String idaCgstRto = null;

    /* Column Info */
    private String idaSgstRto = null;

    /* Column Info */
    private String idaIgstRto = null;

    /* Column Info */
    private String idaUgstRto = null;

    /* Column Info */
    private String idaCgstAmt = null;

    /* Column Info */
    private String idaSgstAmt = null;

    /* Column Info */
    private String idaIgstAmt = null;

    /* Column Info */
    private String idaUgstAmt = null;

    /* Column Info */
    private String idaTaxApplTm = null;

    /* Column Info */
    private String idaBankAcctNo = null;

    /* Column Info */
    private String idaBankIfscCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChargeBookingInvoiceVO() {
    }

    public ChargeBookingInvoiceVO(String ibflag, String pagerows, String dmdtInvNo, String creDt, String creOfcCd, String creCntCd, String creUsrId, String creUsrNm, String updUsrId, String updUsrNm, String dmdtInvStsCd, String dmdtInvStsNm, String actPayrCustNm, String dmdtArIfCd, String arIfDt, String arIfOfcCd, String arIfUsrId, String arIfUsrNm, String crInvNo, String bkgNo, String blNo, String dmdtTrfCd, String scNo, String ofcCd, String vvdCd, String porCd, String polCd, String podCd, String delCd, String rd, String bkgCustCd, String bkgCustNm, String actCustCd, String actCustNm, String issDtPrnFlg, String crTermDys, String payerCd, String payerNm, String ntcKntCd, String overDay, String dmdtPayrCntcPntNm, String custCntcPntSeq, String payrCntcPntPhnNo, String payrCntcPntFaxNo, String payrCntcPntEml, String truckerCd, String truckerNm, String invRefNo, String invRmk, String invRmk1, String invRmk2, String chgCurrCd, String orgChgAmt, String dmdtExptAmt, String chgDcAmt, String bilAmt, String aftInvAdjAmt, String invCurrCd, String invXchRt, String cntrCnt, String totAmt, String dcAmt, String invChgAmt, String taxRto, String taxAmt, String invAmt, String chgType, String rfaNo, String issueDay, String svrId, String bilToLocDivCd, String mnlInvSndFlg, String cntrNo, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String mnOrgChgAmt, String mnBilAmt, String dueDate, String dmdtCxlRsnCd, String cxlRmk, String invHldRsnCd, String invHldRmk, String dmdtCxlRsnNm, String invHldRsnNm, String updDt, String updOfcCd, String mnlInvRmk, String faxEmailSndCnt, String crArYn, String invTaxRto, String vndrSeq, String vndrNm, String caller, String invPrtFlg, String cntCd, String useRtCurr, String rhqOfcCd, String idaExpnTaxRt, String idaExpnTax, String idaEduTaxRt, String idaEduTax, String idaHighEduTaxRt, String idaHighEduTax, String taxRgstNo, String svcCateRmk, String pmntAcctNo, String dmdtVtInvStsCd, String dmdtVtInvNo, String dmdtVtInvYn, String invNewRptFlg, String colDate, String taaNo, String colAmt, String colTax, String colCharge, String colOverDay, String otsCltFlg, String vtCollected, String invUncolAmt, String chgUncolAmt, String invColCharge, String invColTax, String chgColCharge, String chgColTax, String idaLoclTaxRt, String idaLoclTax, String idaN2ndLoclTaxRt, String idaN2ndLoclTax, String idaCgstRto, String idaSgstRto, String idaIgstRto, String idaUgstRto, String idaCgstAmt, String idaSgstAmt, String idaIgstAmt, String idaUgstAmt, String idaTaxApplTm, String idaBankAcctNo, String idaBankIfscCd) {
        this.taxRto = taxRto;
        this.invPrtFlg = invPrtFlg;
        this.faxEmailSndCnt = faxEmailSndCnt;
        this.invHldRsnNm = invHldRsnNm;
        this.invTaxRto = invTaxRto;
        this.pagerows = pagerows;
        this.chgCurrCd = chgCurrCd;
        this.vpsPortCd = vpsPortCd;
        this.dcAmt = dcAmt;
        this.bkgCustNm = bkgCustNm;
        this.vvdCd = vvdCd;
        this.aftInvAdjAmt = aftInvAdjAmt;
        this.cntCd = cntCd;
        this.updUsrId = updUsrId;
        this.dmdtTrfCd = dmdtTrfCd;
        this.invXchRt = invXchRt;
        this.payerCd = payerCd;
        this.ntcKntCd = ntcKntCd;
        this.truckerCd = truckerCd;
        this.skdVoyNo = skdVoyNo;
        this.cntrCnt = cntrCnt;
        this.creUsrNm = creUsrNm;
        this.actCustCd = actCustCd;
        this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
        this.podCd = podCd;
        this.bkgNo = bkgNo;
        this.dmdtCxlRsnNm = dmdtCxlRsnNm;
        this.caller = caller;
        this.totAmt = totAmt;
        this.mnlInvSndFlg = mnlInvSndFlg;
        this.mnOrgChgAmt = mnOrgChgAmt;
        this.dmdtInvStsNm = dmdtInvStsNm;
        this.taxAmt = taxAmt;
        this.payerNm = payerNm;
        this.dueDate = dueDate;
        this.crTermDys = crTermDys;
        this.chgType = chgType;
        this.chgDcAmt = chgDcAmt;
        this.payrCntcPntEml = payrCntcPntEml;
        this.dmdtInvStsCd = dmdtInvStsCd;
        this.invChgAmt = invChgAmt;
        this.dmdtInvNo = dmdtInvNo;
        this.arIfUsrId = arIfUsrId;
        this.ofcCd = ofcCd;
        this.issDtPrnFlg = issDtPrnFlg;
        this.invRmk = invRmk;
        this.cntrNo = cntrNo;
        this.invHldRsnCd = invHldRsnCd;
        this.orgChgAmt = orgChgAmt;
        this.vslCd = vslCd;
        this.blNo = blNo;
        this.mnBilAmt = mnBilAmt;
        this.vndrNm = vndrNm;
        this.polCd = polCd;
        this.scNo = scNo;
        this.dmdtExptAmt = dmdtExptAmt;
        this.bkgCustCd = bkgCustCd;
        this.arIfDt = arIfDt;
        this.updOfcCd = updOfcCd;
        this.crArYn = crArYn;
        this.truckerNm = truckerNm;
        this.delCd = delCd;
        this.arIfOfcCd = arIfOfcCd;
        this.creUsrId = creUsrId;
        this.dmdtCxlRsnCd = dmdtCxlRsnCd;
        this.vndrSeq = vndrSeq;
        this.dmdtArIfCd = dmdtArIfCd;
        this.porCd = porCd;
        this.custCntcPntSeq = custCntcPntSeq;
        this.mnlInvRmk = mnlInvRmk;
        this.overDay = overDay;
        this.creDt = creDt;
        this.invRmk2 = invRmk2;
        this.invRmk1 = invRmk1;
        this.rd = rd;
        this.bilAmt = bilAmt;
        this.payrCntcPntFaxNo = payrCntcPntFaxNo;
        this.rfaNo = rfaNo;
        this.svrId = svrId;
        this.cxlRmk = cxlRmk;
        this.ibflag = ibflag;
        this.creOfcCd = creOfcCd;
        this.invAmt = invAmt;
        this.crInvNo = crInvNo;
        this.arIfUsrNm = arIfUsrNm;
        this.invHldRmk = invHldRmk;
        this.updDt = updDt;
        this.invRefNo = invRefNo;
        this.issueDay = issueDay;
        this.creCntCd = creCntCd;
        this.invCurrCd = invCurrCd;
        this.bilToLocDivCd = bilToLocDivCd;
        this.skdDirCd = skdDirCd;
        this.payrCntcPntPhnNo = payrCntcPntPhnNo;
        this.actCustNm = actCustNm;
        this.useRtCurr = useRtCurr;
        this.actPayrCustNm = actPayrCustNm;
        this.updUsrNm = updUsrNm;
        this.rhqOfcCd = rhqOfcCd;
        this.idaExpnTaxRt = idaExpnTaxRt;
        this.idaExpnTax = idaExpnTax;
        this.idaEduTaxRt = idaEduTaxRt;
        this.idaEduTax = idaEduTax;
        this.idaHighEduTaxRt = idaHighEduTaxRt;
        this.idaHighEduTax = idaHighEduTax;
        this.taxRgstNo = taxRgstNo;
        this.pmntAcctNo = pmntAcctNo;
        this.svcCateRmk = svcCateRmk;
        this.dmdtVtInvStsCd = dmdtVtInvStsCd;
        this.dmdtVtInvNo = dmdtVtInvNo;
        this.dmdtVtInvYn = dmdtVtInvYn;
        this.invNewRptFlg = invNewRptFlg;
        this.colDate = colDate;
        this.taaNo = taaNo;
        this.colAmt = colAmt;
        this.colTax = colTax;
        this.colCharge = colCharge;
        this.colOverDay = colOverDay;
        this.otsCltFlg = otsCltFlg;
        this.vtCollected = vtCollected;
        this.invUncolAmt = invUncolAmt;
        this.chgUncolAmt = chgUncolAmt;
        this.invColCharge = invColCharge;
        this.invColTax = invColTax;
        this.chgColCharge = chgColCharge;
        this.chgColTax = chgColTax;
        this.idaLoclTaxRt = idaLoclTaxRt;
        this.idaLoclTax = idaLoclTax;
        this.idaN2ndLoclTaxRt = idaN2ndLoclTaxRt;
        this.idaN2ndLoclTax = idaN2ndLoclTax;
        this.idaCgstRto = idaCgstRto;
        this.idaSgstRto = idaSgstRto;
        this.idaIgstRto = idaIgstRto;
        this.idaUgstRto = idaUgstRto;
        this.idaCgstAmt = idaCgstAmt;
        this.idaSgstAmt = idaSgstAmt;
        this.idaIgstAmt = idaIgstAmt;
        this.idaUgstAmt = idaUgstAmt;
        this.idaTaxApplTm = idaTaxApplTm;
        this.idaBankAcctNo = idaBankAcctNo;
        this.idaBankIfscCd = idaBankIfscCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("tax_rto", getTaxRto());
        this.hashColumns.put("inv_prt_flg", getInvPrtFlg());
        this.hashColumns.put("fax_email_snd_cnt", getFaxEmailSndCnt());
        this.hashColumns.put("inv_hld_rsn_nm", getInvHldRsnNm());
        this.hashColumns.put("inv_tax_rto", getInvTaxRto());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("chg_curr_cd", getChgCurrCd());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("dc_amt", getDcAmt());
        this.hashColumns.put("bkg_cust_nm", getBkgCustNm());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("aft_inv_adj_amt", getAftInvAdjAmt());
        this.hashColumns.put("cnt_cd", getCntCd());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
        this.hashColumns.put("inv_xch_rt", getInvXchRt());
        this.hashColumns.put("payer_cd", getPayerCd());
        this.hashColumns.put("ntc_knt_cd", getNtcKntCd());
        this.hashColumns.put("trucker_cd", getTruckerCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("cntr_cnt", getCntrCnt());
        this.hashColumns.put("cre_usr_nm", getCreUsrNm());
        this.hashColumns.put("act_cust_cd", getActCustCd());
        this.hashColumns.put("dmdt_payr_cntc_pnt_nm", getDmdtPayrCntcPntNm());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("dmdt_cxl_rsn_nm", getDmdtCxlRsnNm());
        this.hashColumns.put("caller", getCaller());
        this.hashColumns.put("tot_amt", getTotAmt());
        this.hashColumns.put("mnl_inv_snd_flg", getMnlInvSndFlg());
        this.hashColumns.put("mn_org_chg_amt", getMnOrgChgAmt());
        this.hashColumns.put("dmdt_inv_sts_nm", getDmdtInvStsNm());
        this.hashColumns.put("tax_amt", getTaxAmt());
        this.hashColumns.put("payer_nm", getPayerNm());
        this.hashColumns.put("due_date", getDueDate());
        this.hashColumns.put("cr_term_dys", getCrTermDys());
        this.hashColumns.put("chg_type", getChgType());
        this.hashColumns.put("chg_dc_amt", getChgDcAmt());
        this.hashColumns.put("payr_cntc_pnt_eml", getPayrCntcPntEml());
        this.hashColumns.put("dmdt_inv_sts_cd", getDmdtInvStsCd());
        this.hashColumns.put("inv_chg_amt", getInvChgAmt());
        this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
        this.hashColumns.put("ar_if_usr_id", getArIfUsrId());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("iss_dt_prn_flg", getIssDtPrnFlg());
        this.hashColumns.put("inv_rmk", getInvRmk());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("inv_hld_rsn_cd", getInvHldRsnCd());
        this.hashColumns.put("org_chg_amt", getOrgChgAmt());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("mn_bil_amt", getMnBilAmt());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("dmdt_expt_amt", getDmdtExptAmt());
        this.hashColumns.put("bkg_cust_cd", getBkgCustCd());
        this.hashColumns.put("ar_if_dt", getArIfDt());
        this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
        this.hashColumns.put("cr_ar_yn", getCrArYn());
        this.hashColumns.put("trucker_nm", getTruckerNm());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("ar_if_ofc_cd", getArIfOfcCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("dmdt_cxl_rsn_cd", getDmdtCxlRsnCd());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
        this.hashColumns.put("mnl_inv_rmk", getMnlInvRmk());
        this.hashColumns.put("over_day", getOverDay());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("inv_rmk2", getInvRmk2());
        this.hashColumns.put("inv_rmk1", getInvRmk1());
        this.hashColumns.put("rd", getRd());
        this.hashColumns.put("bil_amt", getBilAmt());
        this.hashColumns.put("payr_cntc_pnt_fax_no", getPayrCntcPntFaxNo());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("svr_id", getSvrId());
        this.hashColumns.put("cxl_rmk", getCxlRmk());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
        this.hashColumns.put("inv_amt", getInvAmt());
        this.hashColumns.put("cr_inv_no", getCrInvNo());
        this.hashColumns.put("ar_if_usr_nm", getArIfUsrNm());
        this.hashColumns.put("inv_hld_rmk", getInvHldRmk());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("inv_ref_no", getInvRefNo());
        this.hashColumns.put("issue_day", getIssueDay());
        this.hashColumns.put("cre_cnt_cd", getCreCntCd());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("payr_cntc_pnt_phn_no", getPayrCntcPntPhnNo());
        this.hashColumns.put("act_cust_nm", getActCustNm());
        this.hashColumns.put("act_payr_cust_nm", getActPayrCustNm());
        this.hashColumns.put("use_rt_curr", getUseRtCurr());
        this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
        this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
        this.hashColumns.put("ida_expn_tax_rt", getIdaExpnTaxRt());
        this.hashColumns.put("ida_expn_tax", getIdaExpnTax());
        this.hashColumns.put("ida_edu_tax_rt", getIdaEduTaxRt());
        this.hashColumns.put("ida_edu_tax", getIdaEduTax());
        this.hashColumns.put("ida_high_edu_tax_rt", getIdaHighEduTaxRt());
        this.hashColumns.put("ida_high_edu_tax", getIdaHighEduTax());
        this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
        this.hashColumns.put("pmnt_acct_no", getPmntAcctNo());
        this.hashColumns.put("svc_cate_rmk", getSvcCateRmk());
        this.hashColumns.put("dmdt_vt_inv_sts_cd", getDmdtVtInvStsCd());
        this.hashColumns.put("dmdt_vt_inv_no", getDmdtVtInvNo());
        this.hashColumns.put("dmdt_vt_inv_yn", getDmdtVtInvYn());
        this.hashColumns.put("inv_new_rpt_flg", getInvNewRptFlg());
        this.hashColumns.put("col_date", getColDate());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("col_amt", getColAmt());
        this.hashColumns.put("col_charge", getColCharge());
        this.hashColumns.put("col_tax", getColTax());
        this.hashColumns.put("col_over_day", getColOverDay());
        this.hashColumns.put("ots_clt_flg", getOtsCltFlg());
        this.hashColumns.put("vt_collected", getVtCollected());
        this.hashColumns.put("inv_uncol_amt", getInvUncolAmt());
        this.hashColumns.put("chg_uncol_amt", getChgUncolAmt());
        this.hashColumns.put("inv_col_charge", getInvColCharge());
        this.hashColumns.put("inv_col_tax", getInvColTax());
        this.hashColumns.put("chg_col_charge", getChgColCharge());
        this.hashColumns.put("chg_col_tax", getChgColTax());
        this.hashColumns.put("ida_locl_tax_rt", getIdaLoclTaxRt());
        this.hashColumns.put("ida_locl_tax", getIdaLoclTax());
        this.hashColumns.put("ida_n2nd_locl_tax_rt", getIdaN2ndLoclTaxRt());
        this.hashColumns.put("ida_n2nd_locl_tax", getIdaN2ndLoclTax());
        this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
        this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
        this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
        this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
        this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());
        this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());
        this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());
        this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());
        this.hashColumns.put("ida_tax_appl_tm", getIdaTaxApplTm());
        this.hashColumns.put("ida_bank_acct_no", getIdaBankAcctNo());
        this.hashColumns.put("ida_bank_ifsc_cd", getIdaBankIfscCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("tax_rto", "taxRto");
        this.hashFields.put("inv_prt_flg", "invPrtFlg");
        this.hashFields.put("fax_email_snd_cnt", "faxEmailSndCnt");
        this.hashFields.put("inv_hld_rsn_nm", "invHldRsnNm");
        this.hashFields.put("inv_tax_rto", "invTaxRto");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("chg_curr_cd", "chgCurrCd");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("dc_amt", "dcAmt");
        this.hashFields.put("bkg_cust_nm", "bkgCustNm");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("aft_inv_adj_amt", "aftInvAdjAmt");
        this.hashFields.put("cnt_cd", "cntCd");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
        this.hashFields.put("inv_xch_rt", "invXchRt");
        this.hashFields.put("payer_cd", "payerCd");
        this.hashFields.put("ntc_knt_cd", "ntcKntCd");
        this.hashFields.put("trucker_cd", "truckerCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("cntr_cnt", "cntrCnt");
        this.hashFields.put("cre_usr_nm", "creUsrNm");
        this.hashFields.put("act_cust_cd", "actCustCd");
        this.hashFields.put("dmdt_payr_cntc_pnt_nm", "dmdtPayrCntcPntNm");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("dmdt_cxl_rsn_nm", "dmdtCxlRsnNm");
        this.hashFields.put("caller", "caller");
        this.hashFields.put("tot_amt", "totAmt");
        this.hashFields.put("mnl_inv_snd_flg", "mnlInvSndFlg");
        this.hashFields.put("mn_org_chg_amt", "mnOrgChgAmt");
        this.hashFields.put("dmdt_inv_sts_nm", "dmdtInvStsNm");
        this.hashFields.put("tax_amt", "taxAmt");
        this.hashFields.put("payer_nm", "payerNm");
        this.hashFields.put("due_date", "dueDate");
        this.hashFields.put("cr_term_dys", "crTermDys");
        this.hashFields.put("chg_type", "chgType");
        this.hashFields.put("chg_dc_amt", "chgDcAmt");
        this.hashFields.put("payr_cntc_pnt_eml", "payrCntcPntEml");
        this.hashFields.put("dmdt_inv_sts_cd", "dmdtInvStsCd");
        this.hashFields.put("inv_chg_amt", "invChgAmt");
        this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
        this.hashFields.put("ar_if_usr_id", "arIfUsrId");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("iss_dt_prn_flg", "issDtPrnFlg");
        this.hashFields.put("inv_rmk", "invRmk");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("inv_hld_rsn_cd", "invHldRsnCd");
        this.hashFields.put("org_chg_amt", "orgChgAmt");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("mn_bil_amt", "mnBilAmt");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("dmdt_expt_amt", "dmdtExptAmt");
        this.hashFields.put("bkg_cust_cd", "bkgCustCd");
        this.hashFields.put("ar_if_dt", "arIfDt");
        this.hashFields.put("upd_ofc_cd", "updOfcCd");
        this.hashFields.put("cr_ar_yn", "crArYn");
        this.hashFields.put("trucker_nm", "truckerNm");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("ar_if_ofc_cd", "arIfOfcCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("dmdt_cxl_rsn_cd", "dmdtCxlRsnCd");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
        this.hashFields.put("mnl_inv_rmk", "mnlInvRmk");
        this.hashFields.put("over_day", "overDay");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("inv_rmk2", "invRmk2");
        this.hashFields.put("inv_rmk1", "invRmk1");
        this.hashFields.put("rd", "rd");
        this.hashFields.put("bil_amt", "bilAmt");
        this.hashFields.put("payr_cntc_pnt_fax_no", "payrCntcPntFaxNo");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("svr_id", "svrId");
        this.hashFields.put("cxl_rmk", "cxlRmk");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cre_ofc_cd", "creOfcCd");
        this.hashFields.put("inv_amt", "invAmt");
        this.hashFields.put("cr_inv_no", "crInvNo");
        this.hashFields.put("ar_if_usr_nm", "arIfUsrNm");
        this.hashFields.put("inv_hld_rmk", "invHldRmk");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("inv_ref_no", "invRefNo");
        this.hashFields.put("issue_day", "issueDay");
        this.hashFields.put("cre_cnt_cd", "creCntCd");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("payr_cntc_pnt_phn_no", "payrCntcPntPhnNo");
        this.hashFields.put("act_cust_nm", "actCustNm");
        this.hashFields.put("act_payr_cust_nm", "actPayrCustNm");
        this.hashFields.put("use_rt_curr", "useRtCurr");
        this.hashFields.put("upd_usr_nm", "updUsrNm");
        this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
        this.hashFields.put("ida_expn_tax_rt", "idaExpnTaxRt");
        this.hashFields.put("ida_expn_tax", "idaExpnTax");
        this.hashFields.put("ida_edu_tax_rt", "idaEduTaxRt");
        this.hashFields.put("ida_edu_tax", "idaEduTax");
        this.hashFields.put("ida_high_edu_tax_rt", "idaHighEduTaxRt");
        this.hashFields.put("ida_high_edu_tax", "idaHighEduTax");
        this.hashFields.put("tax_rgst_no", "taxRgstNo");
        this.hashFields.put("pmnt_acct_no", "pmntAcctNo");
        this.hashFields.put("svc_cate_rmk", "svcCateRmk");
        this.hashFields.put("dmdt_vt_inv_sts_cd", "dmdtVtInvStsCd");
        this.hashFields.put("dmdt_vt_inv_no", "dmdtVtInvNo");
        this.hashFields.put("dmdt_vt_inv_yn", "dmdtVtInvYn");
        this.hashFields.put("inv_new_rpt_flg", "invNewRptFlg");
        this.hashFields.put("col_date", "colDate");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("col_amt", "colAmt");
        this.hashFields.put("col_charge", "colCharge");
        this.hashFields.put("col_tax", "colTax");
        this.hashFields.put("col_over_Day", "colOverDay");
        this.hashFields.put("ots_clt_flg", "otsCltFlg");
        this.hashFields.put("vt_collected", "vtCollected");
        this.hashFields.put("inv_uncol_amt", "invUncolAmt");
        this.hashFields.put("chg_uncol_amt", "chgUncolAmt");
        this.hashFields.put("inv_col_charge", "invColCharge");
        this.hashFields.put("inv_col_tax", "invColTax");
        this.hashFields.put("chg_col_charge", "chgColCharge");
        this.hashFields.put("chg_col_tax", "chgColTax");
        this.hashFields.put("ida_locl_tax_rt", "idaLoclTaxRt");
        this.hashFields.put("ida_locl_tax", "idaLoclTax");
        this.hashFields.put("ida_n2nd_locl_tax_rt", "idaN2ndLoclTaxRt");
        this.hashFields.put("ida_n2nd_locl_tax", "idaN2ndLoclTax");
        this.hashFields.put("ida_cgst_rto", "idaCgstRto");
        this.hashFields.put("ida_sgst_rto", "idaSgstRto");
        this.hashFields.put("ida_igst_rto", "idaIgstRto");
        this.hashFields.put("ida_ugst_rto", "idaUgstRto");
        this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
        this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
        this.hashFields.put("ida_igst_amt", "idaIgstAmt");
        this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
        this.hashFields.put("ida_tax_appl_tm", "idaTaxApplTm");
        this.hashFields.put("ida_bank_acct_no", "idaBankAcctNo");
        this.hashFields.put("ida_bank_ifsc_cd", "idaBankIfscCd");
        return this.hashFields;
    }

    public String getColDate() {
        return colDate;
    }

    public void setColDate(String colDate) {
        this.colDate = colDate;
    }

    public String getTaaNo() {
        return taaNo;
    }

    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
    }

    /**
	 * Column Info
	 * @return taxRto
	 */
    public String getTaxRto() {
        return this.taxRto;
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
	 * @return faxEmailSndCnt
	 */
    public String getFaxEmailSndCnt() {
        return this.faxEmailSndCnt;
    }

    /**
	 * Column Info
	 * @return invHldRsnNm
	 */
    public String getInvHldRsnNm() {
        return this.invHldRsnNm;
    }

    /**
	 * Column Info
	 * @return invTaxRto
	 */
    public String getInvTaxRto() {
        return this.invTaxRto;
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
	 * @return chgCurrCd
	 */
    public String getChgCurrCd() {
        return this.chgCurrCd;
    }

    /**
	 * Column Info
	 * @return vpsPortCd
	 */
    public String getVpsPortCd() {
        return this.vpsPortCd;
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
	 * @return bkgCustNm
	 */
    public String getBkgCustNm() {
        return this.bkgCustNm;
    }

    /**
	 * Column Info
	 * @return vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 * Column Info
	 * @return aftInvAdjAmt
	 */
    public String getAftInvAdjAmt() {
        return this.aftInvAdjAmt;
    }

    /**
	 * Column Info
	 * @return cntCd
	 */
    public String getCntCd() {
        return this.cntCd;
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
	 * @return dmdtTrfCd
	 */
    public String getDmdtTrfCd() {
        return this.dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @return invXchRt
	 */
    public String getInvXchRt() {
        return this.invXchRt;
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
	 * @return ntcKntCd
	 */
    public String getNtcKntCd() {
        return this.ntcKntCd;
    }

    /**
	 * Column Info
	 * @return truckerCd
	 */
    public String getTruckerCd() {
        return this.truckerCd;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return cntrCnt
	 */
    public String getCntrCnt() {
        return this.cntrCnt;
    }

    /**
	 * Column Info
	 * @return creUsrNm
	 */
    public String getCreUsrNm() {
        return this.creUsrNm;
    }

    /**
	 * Column Info
	 * @return actCustCd
	 */
    public String getActCustCd() {
        return this.actCustCd;
    }

    /**
	 * Column Info
	 * @return dmdtPayrCntcPntNm
	 */
    public String getDmdtPayrCntcPntNm() {
        return this.dmdtPayrCntcPntNm;
    }

    /**
	 * Column Info
	 * @return podCd
	 */
    public String getPodCd() {
        return this.podCd;
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
	 * @return dmdtCxlRsnNm
	 */
    public String getDmdtCxlRsnNm() {
        return this.dmdtCxlRsnNm;
    }

    /**
	 * Column Info
	 * @return caller
	 */
    public String getCaller() {
        return this.caller;
    }

    /**
	 * Column Info
	 * @return totAmt
	 */
    public String getTotAmt() {
        return this.totAmt;
    }

    /**
	 * Column Info
	 * @return mnlInvSndFlg
	 */
    public String getMnlInvSndFlg() {
        return this.mnlInvSndFlg;
    }

    /**
	 * Column Info
	 * @return mnOrgChgAmt
	 */
    public String getMnOrgChgAmt() {
        return this.mnOrgChgAmt;
    }

    /**
	 * Column Info
	 * @return dmdtInvStsNm
	 */
    public String getDmdtInvStsNm() {
        return this.dmdtInvStsNm;
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
	 * @return payerNm
	 */
    public String getPayerNm() {
        return this.payerNm;
    }

    /**
	 * Column Info
	 * @return dueDate
	 */
    public String getDueDate() {
        return this.dueDate;
    }

    /**
	 * Column Info
	 * @return crTermDys
	 */
    public String getCrTermDys() {
        return this.crTermDys;
    }

    /**
	 * Column Info
	 * @return chgType
	 */
    public String getChgType() {
        return this.chgType;
    }

    /**
	 * Column Info
	 * @return chgDcAmt
	 */
    public String getChgDcAmt() {
        return this.chgDcAmt;
    }

    /**
	 * Column Info
	 * @return payrCntcPntEml
	 */
    public String getPayrCntcPntEml() {
        return this.payrCntcPntEml;
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
	 * @return dmdtInvNo
	 */
    public String getDmdtInvNo() {
        return this.dmdtInvNo;
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
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return issDtPrnFlg
	 */
    public String getIssDtPrnFlg() {
        return this.issDtPrnFlg;
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
	 * @return invHldRsnCd
	 */
    public String getInvHldRsnCd() {
        return this.invHldRsnCd;
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
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
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
	 * @return mnBilAmt
	 */
    public String getMnBilAmt() {
        return this.mnBilAmt;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return bkgCustCd
	 */
    public String getBkgCustCd() {
        return this.bkgCustCd;
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
	 * @return updOfcCd
	 */
    public String getUpdOfcCd() {
        return this.updOfcCd;
    }

    /**
	 * Column Info
	 * @return crArYn
	 */
    public String getCrArYn() {
        return this.crArYn;
    }

    /**
	 * Column Info
	 * @return truckerNm
	 */
    public String getTruckerNm() {
        return this.truckerNm;
    }

    /**
	 * Column Info
	 * @return delCd
	 */
    public String getDelCd() {
        return this.delCd;
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
	 * @return creUsrId
	 */
    public String getCreUsrId() {
        return this.creUsrId;
    }

    /**
	 * Column Info
	 * @return dmdtCxlRsnCd
	 */
    public String getDmdtCxlRsnCd() {
        return this.dmdtCxlRsnCd;
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
	 * @return dmdtArIfCd
	 */
    public String getDmdtArIfCd() {
        return this.dmdtArIfCd;
    }

    /**
	 * Column Info
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return custCntcPntSeq
	 */
    public String getCustCntcPntSeq() {
        return this.custCntcPntSeq;
    }

    /**
	 * Column Info
	 * @return mnlInvRmk
	 */
    public String getMnlInvRmk() {
        return this.mnlInvRmk;
    }

    /**
	 * Column Info
	 * @return overDay
	 */
    public String getOverDay() {
        return this.overDay;
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
	 * @return invRmk2
	 */
    public String getInvRmk2() {
        return this.invRmk2;
    }

    /**
	 * Column Info
	 * @return invRmk1
	 */
    public String getInvRmk1() {
        return this.invRmk1;
    }

    /**
	 * Column Info
	 * @return rd
	 */
    public String getRd() {
        return this.rd;
    }

    /**
	 * Column Info
	 * @return bilAmt
	 */
    public String getBilAmt() {
        return this.bilAmt;
    }

    /**
	 * Column Info
	 * @return payrCntcPntFaxNo
	 */
    public String getPayrCntcPntFaxNo() {
        return this.payrCntcPntFaxNo;
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
	 * @return svrId
	 */
    public String getSvrId() {
        return this.svrId;
    }

    /**
	 * Column Info
	 * @return cxlRmk
	 */
    public String getCxlRmk() {
        return this.cxlRmk;
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
	 * @return creOfcCd
	 */
    public String getCreOfcCd() {
        return this.creOfcCd;
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
	 * @return arIfUsrNm
	 */
    public String getArIfUsrNm() {
        return this.arIfUsrNm;
    }

    /**
	 * Column Info
	 * @return invHldRmk
	 */
    public String getInvHldRmk() {
        return this.invHldRmk;
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
	 * @return invRefNo
	 */
    public String getInvRefNo() {
        return this.invRefNo;
    }

    /**
	 * Column Info
	 * @return issueDay
	 */
    public String getIssueDay() {
        return this.issueDay;
    }

    /**
	 * Column Info
	 * @return actPayrCustNm
	 */
    public String getActPayrCustNm() {
        return this.actPayrCustNm;
    }

    /**
	 * Column Info
	 * @return creCntCd
	 */
    public String getCreCntCd() {
        return this.creCntCd;
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
	 * @return bilToLocDivCd
	 */
    public String getBilToLocDivCd() {
        return this.bilToLocDivCd;
    }

    /**
	 * Column Info
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
    }

    /**
	 * Column Info
	 * @return payrCntcPntPhnNo
	 */
    public String getPayrCntcPntPhnNo() {
        return this.payrCntcPntPhnNo;
    }

    /**
	 * Column Info
	 * @return actCustNm
	 */
    public String getActCustNm() {
        return this.actCustNm;
    }

    /**
	 * Column Info
	 * @return useRtCurr
	 */
    public String getUseRtCurr() {
        return this.useRtCurr;
    }

    /**
	 * Column Info
	 * @return updUsrNm
	 */
    public String getUpdUsrNm() {
        return this.updUsrNm;
    }

    /**
	 * Column Info
	 * @return rhqOfcCd
	 */
    public String getRhqOfcCd() {
        return rhqOfcCd;
    }

    /**
	 * Column Info
	 * @return idaHighEduTaxRt
	 */
    public String getIdaHighEduTaxRt() {
        return this.idaHighEduTaxRt;
    }

    /**
	 * Column Info
	 * @return idaEduTax
	 */
    public String getIdaEduTax() {
        return this.idaEduTax;
    }

    /**
	 * Column Info
	 * @return idaExpnTaxRt
	 */
    public String getIdaExpnTaxRt() {
        return this.idaExpnTaxRt;
    }

    /**
	 * Column Info
	 * @return idaEduTaxRt
	 */
    public String getIdaEduTaxRt() {
        return this.idaEduTaxRt;
    }

    /**
	 * Column Info
	 * @return idaHighEduTax
	 */
    public String getIdaHighEduTax() {
        return this.idaHighEduTax;
    }

    /**
	 * Column Info
	 * @return idaExpnTax
	 */
    public String getIdaExpnTax() {
        return this.idaExpnTax;
    }

    public String getTaxRgstNo() {
        return taxRgstNo;
    }

    public String getPmntAcctNo() {
        return pmntAcctNo;
    }

    public String getSvcCateRmk() {
        return svcCateRmk;
    }

    /**
	 * Column Info
	 * @return dmdtVtInvStsCd
	 */
    public String getDmdtVtInvStsCd() {
        return this.dmdtVtInvStsCd;
    }

    /**
	 * Column Info
	 * @return dmdtVtInvNo
	 */
    public String getDmdtVtInvNo() {
        return this.dmdtVtInvNo;
    }

    /**
	 * Column Info
	 * @return dmdtVtInvYn
	 */
    public String getDmdtVtInvYn() {
        return this.dmdtVtInvYn;
    }

    /**
	 * Column Info
	 * @param taxRto
	 */
    public void setTaxRto(String taxRto) {
        this.taxRto = taxRto;
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
	 * @param faxEmailSndCnt
	 */
    public void setFaxEmailSndCnt(String faxEmailSndCnt) {
        this.faxEmailSndCnt = faxEmailSndCnt;
    }

    /**
	 * Column Info
	 * @param invHldRsnNm
	 */
    public void setInvHldRsnNm(String invHldRsnNm) {
        this.invHldRsnNm = invHldRsnNm;
    }

    /**
	 * Column Info
	 * @param invTaxRto
	 */
    public void setInvTaxRto(String invTaxRto) {
        this.invTaxRto = invTaxRto;
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
	 * @param chgCurrCd
	 */
    public void setChgCurrCd(String chgCurrCd) {
        this.chgCurrCd = chgCurrCd;
    }

    /**
	 * Column Info
	 * @param vpsPortCd
	 */
    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
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
	 * @param bkgCustNm
	 */
    public void setBkgCustNm(String bkgCustNm) {
        this.bkgCustNm = bkgCustNm;
    }

    /**
	 * Column Info
	 * @param vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * Column Info
	 * @param aftInvAdjAmt
	 */
    public void setAftInvAdjAmt(String aftInvAdjAmt) {
        this.aftInvAdjAmt = aftInvAdjAmt;
    }

    /**
	 * Column Info
	 * @param cntCd
	 */
    public void setCntCd(String cntCd) {
        this.cntCd = cntCd;
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
	 * @param dmdtTrfCd
	 */
    public void setDmdtTrfCd(String dmdtTrfCd) {
        this.dmdtTrfCd = dmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param invXchRt
	 */
    public void setInvXchRt(String invXchRt) {
        this.invXchRt = invXchRt;
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
	 * @param ntcKntCd
	 */
    public void setNtcKntCd(String ntcKntCd) {
        this.ntcKntCd = ntcKntCd;
    }

    /**
	 * Column Info
	 * @param truckerCd
	 */
    public void setTruckerCd(String truckerCd) {
        this.truckerCd = truckerCd;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param cntrCnt
	 */
    public void setCntrCnt(String cntrCnt) {
        this.cntrCnt = cntrCnt;
    }

    /**
	 * Column Info
	 * @param creUsrNm
	 */
    public void setCreUsrNm(String creUsrNm) {
        this.creUsrNm = creUsrNm;
    }

    /**
	 * Column Info
	 * @param actCustCd
	 */
    public void setActCustCd(String actCustCd) {
        this.actCustCd = actCustCd;
    }

    /**
	 * Column Info
	 * @param dmdtPayrCntcPntNm
	 */
    public void setDmdtPayrCntcPntNm(String dmdtPayrCntcPntNm) {
        this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
    }

    /**
	 * Column Info
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
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
	 * @param dmdtCxlRsnNm
	 */
    public void setDmdtCxlRsnNm(String dmdtCxlRsnNm) {
        this.dmdtCxlRsnNm = dmdtCxlRsnNm;
    }

    /**
	 * Column Info
	 * @param caller
	 */
    public void setCaller(String caller) {
        this.caller = caller;
    }

    /**
	 * Column Info
	 * @param totAmt
	 */
    public void setTotAmt(String totAmt) {
        this.totAmt = totAmt;
    }

    /**
	 * Column Info
	 * @param mnlInvSndFlg
	 */
    public void setMnlInvSndFlg(String mnlInvSndFlg) {
        this.mnlInvSndFlg = mnlInvSndFlg;
    }

    /**
	 * Column Info
	 * @param mnOrgChgAmt
	 */
    public void setMnOrgChgAmt(String mnOrgChgAmt) {
        this.mnOrgChgAmt = mnOrgChgAmt;
    }

    /**
	 * Column Info
	 * @param dmdtInvStsNm
	 */
    public void setDmdtInvStsNm(String dmdtInvStsNm) {
        this.dmdtInvStsNm = dmdtInvStsNm;
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
	 * @param payerNm
	 */
    public void setPayerNm(String payerNm) {
        this.payerNm = payerNm;
    }

    /**
	 * Column Info
	 * @param dueDate
	 */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
	 * Column Info
	 * @param crTermDys
	 */
    public void setCrTermDys(String crTermDys) {
        this.crTermDys = crTermDys;
    }

    /**
	 * Column Info
	 * @param chgType
	 */
    public void setChgType(String chgType) {
        this.chgType = chgType;
    }

    /**
	 * Column Info
	 * @param chgDcAmt
	 */
    public void setChgDcAmt(String chgDcAmt) {
        this.chgDcAmt = chgDcAmt;
    }

    /**
	 * Column Info
	 * @param payrCntcPntEml
	 */
    public void setPayrCntcPntEml(String payrCntcPntEml) {
        this.payrCntcPntEml = payrCntcPntEml;
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
	 * @param dmdtInvNo
	 */
    public void setDmdtInvNo(String dmdtInvNo) {
        this.dmdtInvNo = dmdtInvNo;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param issDtPrnFlg
	 */
    public void setIssDtPrnFlg(String issDtPrnFlg) {
        this.issDtPrnFlg = issDtPrnFlg;
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
	 * @param invHldRsnCd
	 */
    public void setInvHldRsnCd(String invHldRsnCd) {
        this.invHldRsnCd = invHldRsnCd;
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
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
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
	 * @param mnBilAmt
	 */
    public void setMnBilAmt(String mnBilAmt) {
        this.mnBilAmt = mnBilAmt;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param bkgCustCd
	 */
    public void setBkgCustCd(String bkgCustCd) {
        this.bkgCustCd = bkgCustCd;
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
	 * @param updOfcCd
	 */
    public void setUpdOfcCd(String updOfcCd) {
        this.updOfcCd = updOfcCd;
    }

    /**
	 * Column Info
	 * @param crArYn
	 */
    public void setCrArYn(String crArYn) {
        this.crArYn = crArYn;
    }

    /**
	 * Column Info
	 * @param truckerNm
	 */
    public void setTruckerNm(String truckerNm) {
        this.truckerNm = truckerNm;
    }

    /**
	 * Column Info
	 * @param delCd
	 */
    public void setDelCd(String delCd) {
        this.delCd = delCd;
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
	 * @param creUsrId
	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param dmdtCxlRsnCd
	 */
    public void setDmdtCxlRsnCd(String dmdtCxlRsnCd) {
        this.dmdtCxlRsnCd = dmdtCxlRsnCd;
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
	 * @param dmdtArIfCd
	 */
    public void setDmdtArIfCd(String dmdtArIfCd) {
        this.dmdtArIfCd = dmdtArIfCd;
    }

    /**
	 * Column Info
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param custCntcPntSeq
	 */
    public void setCustCntcPntSeq(String custCntcPntSeq) {
        this.custCntcPntSeq = custCntcPntSeq;
    }

    /**
	 * Column Info
	 * @param mnlInvRmk
	 */
    public void setMnlInvRmk(String mnlInvRmk) {
        this.mnlInvRmk = mnlInvRmk;
    }

    /**
	 * Column Info
	 * @param overDay
	 */
    public void setOverDay(String overDay) {
        this.overDay = overDay;
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
	 * @param invRmk2
	 */
    public void setInvRmk2(String invRmk2) {
        this.invRmk2 = invRmk2;
    }

    /**
	 * Column Info
	 * @param invRmk1
	 */
    public void setInvRmk1(String invRmk1) {
        this.invRmk1 = invRmk1;
    }

    /**
	 * Column Info
	 * @param rd
	 */
    public void setRd(String rd) {
        this.rd = rd;
    }

    /**
	 * Column Info
	 * @param bilAmt
	 */
    public void setBilAmt(String bilAmt) {
        this.bilAmt = bilAmt;
    }

    /**
	 * Column Info
	 * @param payrCntcPntFaxNo
	 */
    public void setPayrCntcPntFaxNo(String payrCntcPntFaxNo) {
        this.payrCntcPntFaxNo = payrCntcPntFaxNo;
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
	 * @param svrId
	 */
    public void setSvrId(String svrId) {
        this.svrId = svrId;
    }

    /**
	 * Column Info
	 * @param cxlRmk
	 */
    public void setCxlRmk(String cxlRmk) {
        this.cxlRmk = cxlRmk;
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
	 * @param creOfcCd
	 */
    public void setCreOfcCd(String creOfcCd) {
        this.creOfcCd = creOfcCd;
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
	 * @param arIfUsrNm
	 */
    public void setArIfUsrNm(String arIfUsrNm) {
        this.arIfUsrNm = arIfUsrNm;
    }

    /**
	 * Column Info
	 * @param invHldRmk
	 */
    public void setInvHldRmk(String invHldRmk) {
        this.invHldRmk = invHldRmk;
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
	 * @param invRefNo
	 */
    public void setInvRefNo(String invRefNo) {
        this.invRefNo = invRefNo;
    }

    /**
	 * Column Info
	 * @param issueDay
	 */
    public void setIssueDay(String issueDay) {
        this.issueDay = issueDay;
    }

    /**
	 * Column Info
	 * @param creCntCd
	 */
    public void setCreCntCd(String creCntCd) {
        this.creCntCd = creCntCd;
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
	 * @param actPayrCustNm
	 */
    public void setActPayrCustNm(String actPayrCustNm) {
        this.actPayrCustNm = actPayrCustNm;
    }

    /**
	 * Column Info
	 * @param bilToLocDivCd
	 */
    public void setBilToLocDivCd(String bilToLocDivCd) {
        this.bilToLocDivCd = bilToLocDivCd;
    }

    /**
	 * Column Info
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param payrCntcPntPhnNo
	 */
    public void setPayrCntcPntPhnNo(String payrCntcPntPhnNo) {
        this.payrCntcPntPhnNo = payrCntcPntPhnNo;
    }

    /**
	 * Column Info
	 * @param actCustNm
	 */
    public void setActCustNm(String actCustNm) {
        this.actCustNm = actCustNm;
    }

    /**
	 * Column Info
	 * @param useRtCurr
	 */
    public void setUseRtCurr(String useRtCurr) {
        this.useRtCurr = useRtCurr;
    }

    /**
	 * Column Info
	 * @param updUsrNm
	 */
    public void setUpdUsrNm(String updUsrNm) {
        this.updUsrNm = updUsrNm;
    }

    /**
	 * Column Info
	 * @return rhqOfcCd
	 */
    public void setRhqOfcCd(String rhqOfcCd) {
        this.rhqOfcCd = rhqOfcCd;
    }

    /**
	 * Column Info
	 * @param idaHighEduTaxRt
	 */
    public void setIdaHighEduTaxRt(String idaHighEduTaxRt) {
        this.idaHighEduTaxRt = idaHighEduTaxRt;
    }

    /**
	 * Column Info
	 * @param idaEduTax
	 */
    public void setIdaEduTax(String idaEduTax) {
        this.idaEduTax = idaEduTax;
    }

    /**
	 * Column Info
	 * @param idaExpnTaxRt
	 */
    public void setIdaExpnTaxRt(String idaExpnTaxRt) {
        this.idaExpnTaxRt = idaExpnTaxRt;
    }

    /**
	 * Column Info
	 * @param idaEduTaxRt
	 */
    public void setIdaEduTaxRt(String idaEduTaxRt) {
        this.idaEduTaxRt = idaEduTaxRt;
    }

    /**
	 * Column Info
	 * @param idaHighEduTax
	 */
    public void setIdaHighEduTax(String idaHighEduTax) {
        this.idaHighEduTax = idaHighEduTax;
    }

    /**
	 * Column Info
	 * @param idaExpnTax
	 */
    public void setIdaExpnTax(String idaExpnTax) {
        this.idaExpnTax = idaExpnTax;
    }

    public void setTaxRgstNo(String taxRgstNo) {
        this.taxRgstNo = taxRgstNo;
    }

    public void setPmntAcctNo(String pmntAcctNo) {
        this.pmntAcctNo = pmntAcctNo;
    }

    public void setSvcCateRmk(String svcCateRmk) {
        this.svcCateRmk = svcCateRmk;
    }

    /**
	 * Column Info
	 * @param dmdtVtInvStsCd
	 */
    public void setDmdtVtInvStsCd(String dmdtVtInvStsCd) {
        this.dmdtVtInvStsCd = dmdtVtInvStsCd;
    }

    /**
	 * Column Info
	 * @param dmdtVtInvNo
	 */
    public void setDmdtVtInvNo(String dmdtVtInvNo) {
        this.dmdtVtInvNo = dmdtVtInvNo;
    }

    /**
	 * Column Info
	 * @param dmdtVtInvYn
	 */
    public void setDmdtVtInvYn(String dmdtVtInvYn) {
        this.dmdtVtInvYn = dmdtVtInvYn;
    }

    public String getInvNewRptFlg() {
        return invNewRptFlg;
    }

    public void setInvNewRptFlg(String invNewRptFlg) {
        this.invNewRptFlg = invNewRptFlg;
    }

    public String getVtCollected() {
        return vtCollected;
    }

    public void setVtCollected(String vtCollected) {
        this.vtCollected = vtCollected;
    }

    public String getOtsCltFlg() {
        return otsCltFlg;
    }

    public void setOtsCltFlg(String otsCltFlg) {
        this.otsCltFlg = otsCltFlg;
    }

    public String getColOverDay() {
        return colOverDay;
    }

    public void setColOverDay(String colOverDay) {
        this.colOverDay = colOverDay;
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

    public String getColAmt() {
        return colAmt;
    }

    public void setColAmt(String colAmt) {
        this.colAmt = colAmt;
    }

    public String getInvUncolAmt() {
        return invUncolAmt;
    }

    public void setInvUncolAmt(String invUncolAmt) {
        this.invUncolAmt = invUncolAmt;
    }

    public String getChgUncolAmt() {
        return chgUncolAmt;
    }

    public void setChgUncolAmt(String chgUncolAmt) {
        this.chgUncolAmt = chgUncolAmt;
    }

    public String getInvColCharge() {
        return invColCharge;
    }

    public void setInvColCharge(String invColCharge) {
        this.invColCharge = invColCharge;
    }

    public String getInvColTax() {
        return invColTax;
    }

    public void setInvColTax(String invColTax) {
        this.invColTax = invColTax;
    }

    public String getChgColCharge() {
        return chgColCharge;
    }

    public void setChgColCharge(String chgColCharge) {
        this.chgColCharge = chgColCharge;
    }

    public String getChgColTax() {
        return chgColTax;
    }

    public void setChgColTax(String chgColTax) {
        this.chgColTax = chgColTax;
    }

    public String getIdaLoclTaxRt() {
        return idaLoclTaxRt;
    }

    public void setIdaLoclTaxRt(String idaLoclTaxRt) {
        this.idaLoclTaxRt = idaLoclTaxRt;
    }

    public String getIdaLoclTax() {
        return idaLoclTax;
    }

    public void setIdaLoclTax(String idaLoclTax) {
        this.idaLoclTax = idaLoclTax;
    }

    public String getIdaN2ndLoclTaxRt() {
        return idaN2ndLoclTaxRt;
    }

    public void setIdaN2ndLoclTaxRt(String idaN2ndLoclTaxRt) {
        this.idaN2ndLoclTaxRt = idaN2ndLoclTaxRt;
    }

    public String getIdaN2ndLoclTax() {
        return idaN2ndLoclTax;
    }

    public void setIdaN2ndLoclTax(String idaN2ndLoclTax) {
        this.idaN2ndLoclTax = idaN2ndLoclTax;
    }

    public void setIdaCgstRto(String idaCgstRto) {
        this.idaCgstRto = idaCgstRto;
    }

    public String getIdaCgstRto() {
        return this.idaCgstRto;
    }

    public void setIdaSgstRto(String idaSgstRto) {
        this.idaSgstRto = idaSgstRto;
    }

    public String getIdaSgstRto() {
        return this.idaSgstRto;
    }

    public void setIdaIgstRto(String idaIgstRto) {
        this.idaIgstRto = idaIgstRto;
    }

    public String getIdaIgstRto() {
        return this.idaIgstRto;
    }

    public void setIdaUgstRto(String idaUgstRto) {
        this.idaUgstRto = idaUgstRto;
    }

    public String getIdaUgstRto() {
        return this.idaUgstRto;
    }

    public void setIdaCgstAmt(String idaCgstAmt) {
        this.idaCgstAmt = idaCgstAmt;
    }

    public String getIdaCgstAmt() {
        return this.idaCgstAmt;
    }

    public void setIdaSgstAmt(String idaSgstAmt) {
        this.idaSgstAmt = idaSgstAmt;
    }

    public String getIdaSgstAmt() {
        return this.idaSgstAmt;
    }

    public void setIdaIgstAmt(String idaIgstAmt) {
        this.idaIgstAmt = idaIgstAmt;
    }

    public String getIdaIgstAmt() {
        return this.idaIgstAmt;
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

    public void setIdaBankAcctNo(String idaBankAcctNo) {
        this.idaBankAcctNo = idaBankAcctNo;
    }

    public String getIdaBankAcctNo() {
        return this.idaBankAcctNo;
    }

    public void setIdaBankIfscCd(String idaBankIfscCd) {
        this.idaBankIfscCd = idaBankIfscCd;
    }

    public String getIdaBankIfscCd() {
        return this.idaBankIfscCd;
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
        setTaxRto(JSPUtil.getParameter(request, prefix + "tax_rto", ""));
        setInvPrtFlg(JSPUtil.getParameter(request, prefix + "inv_prt_flg", ""));
        setFaxEmailSndCnt(JSPUtil.getParameter(request, prefix + "fax_email_snd_cnt", ""));
        setInvHldRsnNm(JSPUtil.getParameter(request, prefix + "inv_hld_rsn_nm", ""));
        setInvTaxRto(JSPUtil.getParameter(request, prefix + "inv_tax_rto", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
        setBkgCustNm(JSPUtil.getParameter(request, prefix + "bkg_cust_nm", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setAftInvAdjAmt(JSPUtil.getParameter(request, prefix + "aft_inv_adj_amt", ""));
        setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
        setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
        setPayerCd(JSPUtil.getParameter(request, prefix + "payer_cd", ""));
        setNtcKntCd(JSPUtil.getParameter(request, prefix + "ntc_knt_cd", ""));
        setTruckerCd(JSPUtil.getParameter(request, prefix + "trucker_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
        setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
        setActCustCd(JSPUtil.getParameter(request, prefix + "act_cust_cd", ""));
        setDmdtPayrCntcPntNm(JSPUtil.getParameter(request, prefix + "dmdt_payr_cntc_pnt_nm", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setDmdtCxlRsnNm(JSPUtil.getParameter(request, prefix + "dmdt_cxl_rsn_nm", ""));
        setCaller(JSPUtil.getParameter(request, prefix + "caller", ""));
        setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
        setMnlInvSndFlg(JSPUtil.getParameter(request, prefix + "mnl_inv_snd_flg", ""));
        setMnOrgChgAmt(JSPUtil.getParameter(request, prefix + "mn_org_chg_amt", ""));
        setDmdtInvStsNm(JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_nm", ""));
        setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
        setPayerNm(JSPUtil.getParameter(request, prefix + "payer_nm", ""));
        setDueDate(JSPUtil.getParameter(request, prefix + "due_date", ""));
        setCrTermDys(JSPUtil.getParameter(request, prefix + "cr_term_dys", ""));
        setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
        setChgDcAmt(JSPUtil.getParameter(request, prefix + "chg_dc_amt", ""));
        setPayrCntcPntEml(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_eml", ""));
        setDmdtInvStsCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_cd", ""));
        setInvChgAmt(JSPUtil.getParameter(request, prefix + "inv_chg_amt", ""));
        setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
        setArIfUsrId(JSPUtil.getParameter(request, prefix + "ar_if_usr_id", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setIssDtPrnFlg(JSPUtil.getParameter(request, prefix + "iss_dt_prn_flg", ""));
        setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setInvHldRsnCd(JSPUtil.getParameter(request, prefix + "inv_hld_rsn_cd", ""));
        setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setMnBilAmt(JSPUtil.getParameter(request, prefix + "mn_bil_amt", ""));
        setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setDmdtExptAmt(JSPUtil.getParameter(request, prefix + "dmdt_expt_amt", ""));
        setBkgCustCd(JSPUtil.getParameter(request, prefix + "bkg_cust_cd", ""));
        setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
        setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
        setCrArYn(JSPUtil.getParameter(request, prefix + "cr_ar_yn", ""));
        setTruckerNm(JSPUtil.getParameter(request, prefix + "trucker_nm", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setArIfOfcCd(JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setDmdtCxlRsnCd(JSPUtil.getParameter(request, prefix + "dmdt_cxl_rsn_cd", ""));
        setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
        setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setCustCntcPntSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", ""));
        setMnlInvRmk(JSPUtil.getParameter(request, prefix + "mnl_inv_rmk", ""));
        setOverDay(JSPUtil.getParameter(request, prefix + "over_day", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setInvRmk2(JSPUtil.getParameter(request, prefix + "inv_rmk2", ""));
        setInvRmk1(JSPUtil.getParameter(request, prefix + "inv_rmk1", ""));
        setRd(JSPUtil.getParameter(request, prefix + "rd", ""));
        setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
        setPayrCntcPntFaxNo(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_fax_no", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
        setCxlRmk(JSPUtil.getParameter(request, prefix + "cxl_rmk", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
        setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
        setCrInvNo(JSPUtil.getParameter(request, prefix + "cr_inv_no", ""));
        setArIfUsrNm(JSPUtil.getParameter(request, prefix + "ar_if_usr_nm", ""));
        setInvHldRmk(JSPUtil.getParameter(request, prefix + "inv_hld_rmk", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setInvRefNo(JSPUtil.getParameter(request, prefix + "inv_ref_no", ""));
        setIssueDay(JSPUtil.getParameter(request, prefix + "issue_day", ""));
        setCreCntCd(JSPUtil.getParameter(request, prefix + "cre_cnt_cd", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setBilToLocDivCd(JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPayrCntcPntPhnNo(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_phn_no", ""));
        setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
        setActPayrCustNm(JSPUtil.getParameter(request, prefix + "act_payr_cust_nm", ""));
        setUseRtCurr(JSPUtil.getParameter(request, prefix + "use_rt_curr", ""));
        setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
        setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
        setIdaExpnTaxRt(JSPUtil.getParameter(request, prefix + "ida_expn_tax_rt", ""));
        setIdaExpnTax(JSPUtil.getParameter(request, prefix + "ida_expn_tax", ""));
        setIdaEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_edu_tax_rt", ""));
        setIdaEduTax(JSPUtil.getParameter(request, prefix + "ida_edu_tax", ""));
        setIdaHighEduTaxRt(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax_rt", ""));
        setIdaHighEduTax(JSPUtil.getParameter(request, prefix + "ida_high_edu_tax", ""));
        setTaxRgstNo(JSPUtil.getParameter(request, prefix + "tax_rgst_no", ""));
        setPmntAcctNo(JSPUtil.getParameter(request, prefix + "pmnt_acct_no", ""));
        setSvcCateRmk(JSPUtil.getParameter(request, prefix + "svc_cate_rmk", ""));
        setDmdtVtInvStsCd(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_sts_cd", ""));
        setDmdtVtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_no", ""));
        setDmdtVtInvYn(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_yn", ""));
        setInvNewRptFlg(JSPUtil.getParameter(request, prefix + "inv_new_rpt_flg", ""));
        setColDate(JSPUtil.getParameter(request, prefix + "col_date", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setColAmt(JSPUtil.getParameter(request, prefix + "col_amt", ""));
        setColCharge(JSPUtil.getParameter(request, prefix + "col_charge", ""));
        setColTax(JSPUtil.getParameter(request, prefix + "col_tax", ""));
        setColOverDay(JSPUtil.getParameter(request, prefix + "col_over_day", ""));
        setOtsCltFlg(JSPUtil.getParameter(request, prefix + "ots_clt_flg", ""));
        setVtCollected(JSPUtil.getParameter(request, "vt_collected", ""));
        setInvUncolAmt(JSPUtil.getParameter(request, "inv_uncol_amt", ""));
        setChgUncolAmt(JSPUtil.getParameter(request, "chg_uncol_amt", ""));
        setInvColCharge(JSPUtil.getParameter(request, "inv_col_charge", ""));
        setInvColTax(JSPUtil.getParameter(request, "inv_col_tax", ""));
        setChgColCharge(JSPUtil.getParameter(request, "chg_col_charge", ""));
        setChgColTax(JSPUtil.getParameter(request, "chg_col_tax", ""));
        setIdaLoclTaxRt(JSPUtil.getParameter(request, prefix + "ida_locl_tax_rt", ""));
        setIdaLoclTax(JSPUtil.getParameter(request, prefix + "ida_locl_tax", ""));
        setIdaN2ndLoclTaxRt(JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax_rt", ""));
        setIdaN2ndLoclTax(JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax", ""));
        setIdaCgstRto(JSPUtil.getParameter(request, prefix + "ida_cgst_rto", ""));
        setIdaSgstRto(JSPUtil.getParameter(request, prefix + "ida_sgst_rto", ""));
        setIdaIgstRto(JSPUtil.getParameter(request, prefix + "ida_igst_rto", ""));
        setIdaUgstRto(JSPUtil.getParameter(request, prefix + "ida_ugst_rto", ""));
        setIdaCgstAmt(JSPUtil.getParameter(request, prefix + "ida_cgst_amt", ""));
        setIdaSgstAmt(JSPUtil.getParameter(request, prefix + "ida_sgst_amt", ""));
        setIdaIgstAmt(JSPUtil.getParameter(request, prefix + "ida_igst_amt", ""));
        setIdaUgstAmt(JSPUtil.getParameter(request, prefix + "ida_ugst_amt", ""));
        setIdaTaxApplTm(JSPUtil.getParameter(request, prefix + "ida_tax_appl_tm", ""));
        setIdaBankAcctNo(JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", ""));
        setIdaBankIfscCd(JSPUtil.getParameter(request, prefix + "ida_bank_ifsc_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeBookingInvoiceVO[]
	 */
    public ChargeBookingInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeBookingInvoiceVO[]
	 */
    public ChargeBookingInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChargeBookingInvoiceVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] taxRto = (JSPUtil.getParameter(request, prefix + "tax_rto", length));
            String[] invPrtFlg = (JSPUtil.getParameter(request, prefix + "inv_prt_flg", length));
            String[] faxEmailSndCnt = (JSPUtil.getParameter(request, prefix + "fax_email_snd_cnt", length));
            String[] invHldRsnNm = (JSPUtil.getParameter(request, prefix + "inv_hld_rsn_nm", length));
            String[] invTaxRto = (JSPUtil.getParameter(request, prefix + "inv_tax_rto", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] chgCurrCd = (JSPUtil.getParameter(request, prefix + "chg_curr_cd", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
            String[] dcAmt = (JSPUtil.getParameter(request, prefix + "dc_amt", length));
            String[] bkgCustNm = (JSPUtil.getParameter(request, prefix + "bkg_cust_nm", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] aftInvAdjAmt = (JSPUtil.getParameter(request, prefix + "aft_inv_adj_amt", length));
            String[] cntCd = (JSPUtil.getParameter(request, prefix + "cnt_cd", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", length));
            String[] invXchRt = (JSPUtil.getParameter(request, prefix + "inv_xch_rt", length));
            String[] payerCd = (JSPUtil.getParameter(request, prefix + "payer_cd", length));
            String[] ntcKntCd = (JSPUtil.getParameter(request, prefix + "ntc_knt_cd", length));
            String[] truckerCd = (JSPUtil.getParameter(request, prefix + "trucker_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] cntrCnt = (JSPUtil.getParameter(request, prefix + "cntr_cnt", length));
            String[] creUsrNm = (JSPUtil.getParameter(request, prefix + "cre_usr_nm", length));
            String[] actCustCd = (JSPUtil.getParameter(request, prefix + "act_cust_cd", length));
            String[] dmdtPayrCntcPntNm = (JSPUtil.getParameter(request, prefix + "dmdt_payr_cntc_pnt_nm", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] dmdtCxlRsnNm = (JSPUtil.getParameter(request, prefix + "dmdt_cxl_rsn_nm", length));
            String[] caller = (JSPUtil.getParameter(request, prefix + "caller", length));
            String[] totAmt = (JSPUtil.getParameter(request, prefix + "tot_amt", length));
            String[] mnlInvSndFlg = (JSPUtil.getParameter(request, prefix + "mnl_inv_snd_flg", length));
            String[] mnOrgChgAmt = (JSPUtil.getParameter(request, prefix + "mn_org_chg_amt", length));
            String[] dmdtInvStsNm = (JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_nm", length));
            String[] taxAmt = (JSPUtil.getParameter(request, prefix + "tax_amt", length));
            String[] payerNm = (JSPUtil.getParameter(request, prefix + "payer_nm", length));
            String[] dueDate = (JSPUtil.getParameter(request, prefix + "due_date", length));
            String[] crTermDys = (JSPUtil.getParameter(request, prefix + "cr_term_dys", length));
            String[] chgType = (JSPUtil.getParameter(request, prefix + "chg_type", length));
            String[] chgDcAmt = (JSPUtil.getParameter(request, prefix + "chg_dc_amt", length));
            String[] payrCntcPntEml = (JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_eml", length));
            String[] dmdtInvStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_sts_cd", length));
            String[] invChgAmt = (JSPUtil.getParameter(request, prefix + "inv_chg_amt", length));
            String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_inv_no", length));
            String[] arIfUsrId = (JSPUtil.getParameter(request, prefix + "ar_if_usr_id", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] issDtPrnFlg = (JSPUtil.getParameter(request, prefix + "iss_dt_prn_flg", length));
            String[] invRmk = (JSPUtil.getParameter(request, prefix + "inv_rmk", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] invHldRsnCd = (JSPUtil.getParameter(request, prefix + "inv_hld_rsn_cd", length));
            String[] orgChgAmt = (JSPUtil.getParameter(request, prefix + "org_chg_amt", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] mnBilAmt = (JSPUtil.getParameter(request, prefix + "mn_bil_amt", length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] dmdtExptAmt = (JSPUtil.getParameter(request, prefix + "dmdt_expt_amt", length));
            String[] bkgCustCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_cd", length));
            String[] arIfDt = (JSPUtil.getParameter(request, prefix + "ar_if_dt", length));
            String[] updOfcCd = (JSPUtil.getParameter(request, prefix + "upd_ofc_cd", length));
            String[] crArYn = (JSPUtil.getParameter(request, prefix + "cr_ar_yn", length));
            String[] truckerNm = (JSPUtil.getParameter(request, prefix + "trucker_nm", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] arIfOfcCd = (JSPUtil.getParameter(request, prefix + "ar_if_ofc_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] dmdtCxlRsnCd = (JSPUtil.getParameter(request, prefix + "dmdt_cxl_rsn_cd", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", length));
            String[] mnlInvRmk = (JSPUtil.getParameter(request, prefix + "mnl_inv_rmk", length));
            String[] overDay = (JSPUtil.getParameter(request, prefix + "over_day", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] invRmk2 = (JSPUtil.getParameter(request, prefix + "inv_rmk2", length));
            String[] invRmk1 = (JSPUtil.getParameter(request, prefix + "inv_rmk1", length));
            String[] rd = (JSPUtil.getParameter(request, prefix + "rd", length));
            String[] bilAmt = (JSPUtil.getParameter(request, prefix + "bil_amt", length));
            String[] payrCntcPntFaxNo = (JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_fax_no", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] svrId = (JSPUtil.getParameter(request, prefix + "svr_id", length));
            String[] cxlRmk = (JSPUtil.getParameter(request, prefix + "cxl_rmk", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
            String[] invAmt = (JSPUtil.getParameter(request, prefix + "inv_amt", length));
            String[] crInvNo = (JSPUtil.getParameter(request, prefix + "cr_inv_no", length));
            String[] arIfUsrNm = (JSPUtil.getParameter(request, prefix + "ar_if_usr_nm", length));
            String[] invHldRmk = (JSPUtil.getParameter(request, prefix + "inv_hld_rmk", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] invRefNo = (JSPUtil.getParameter(request, prefix + "inv_ref_no", length));
            String[] issueDay = (JSPUtil.getParameter(request, prefix + "issue_day", length));
            String[] creCntCd = (JSPUtil.getParameter(request, prefix + "cre_cnt_cd", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] payrCntcPntPhnNo = (JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_phn_no", length));
            String[] actCustNm = (JSPUtil.getParameter(request, prefix + "act_cust_nm", length));
            String[] actPayrCustNm = (JSPUtil.getParameter(request, prefix + "act_payr_cust_nm", length));
            String[] useRtCurr = (JSPUtil.getParameter(request, prefix + "use_rt_curr", length));
            String[] updUsrNm = (JSPUtil.getParameter(request, prefix + "upd_usr_nm", length));
            String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", length));
            String[] idaExpnTaxRt = (JSPUtil.getParameter(request, prefix + "ida_expn_tax_rt", length));
            String[] idaExpnTax = (JSPUtil.getParameter(request, prefix + "ida_expn_tax", length));
            String[] idaEduTaxRt = (JSPUtil.getParameter(request, prefix + "ida_edu_tax_rt", length));
            String[] idaEduTax = (JSPUtil.getParameter(request, prefix + "ida_edu_tax", length));
            String[] idaHighEduTaxRt = (JSPUtil.getParameter(request, prefix + "ida_high_edu_tax_rt", length));
            String[] idaHighEduTax = (JSPUtil.getParameter(request, prefix + "ida_high_edu_tax", length));
            String[] taxRgstNo = (JSPUtil.getParameter(request, prefix + "tax_rgst_no", length));
            String[] pmntAcctNo = (JSPUtil.getParameter(request, prefix + "pmnt_acct_no", length));
            String[] svcCateRmk = (JSPUtil.getParameter(request, prefix + "svc_cate_rmk", length));
            String[] dmdtVtInvStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_sts_cd", length));
            String[] dmdtVtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_no", length));
            String[] dmdtVtInvYn = (JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_yn", length));
            String[] invNewRptFlg = (JSPUtil.getParameter(request, prefix + "inv_new_rpt_flg", length));
            String[] colDate = (JSPUtil.getParameter(request, prefix + "col_date", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] scRfaExptAplyDt = (JSPUtil.getParameter(request, prefix + "sc_rfa_expt_aply_dt", length));
            String[] colAmt = (JSPUtil.getParameter(request, prefix + "col_amt", length));
            String[] colCharge = (JSPUtil.getParameter(request, prefix + "col_charge", length));
            String[] colTax = (JSPUtil.getParameter(request, prefix + "col_tax", length));
            String[] colOverDay = (JSPUtil.getParameter(request, prefix + "col_over_day", length));
            String[] otsCltFlg = (JSPUtil.getParameter(request, prefix + "ots_clt_flg", length));
            String[] vtCollected = (JSPUtil.getParameter(request, prefix + "vt_collected", length));
            String[] invUncolAmt = (JSPUtil.getParameter(request, prefix + "inv_uncol_amt", length));
            String[] chgUncolAmt = (JSPUtil.getParameter(request, prefix + "chg_uncol_amt", length));
            String[] invColCharge = (JSPUtil.getParameter(request, prefix + "inv_col_charge", length));
            String[] invColTax = (JSPUtil.getParameter(request, prefix + "inv_col_tax", length));
            String[] chgColCharge = (JSPUtil.getParameter(request, prefix + "chg_col_charge", length));
            String[] chgColTax = (JSPUtil.getParameter(request, prefix + "chg_col_tax", length));
            String[] idaLoclTaxRt = (JSPUtil.getParameter(request, prefix + "ida_locl_tax_rt", length));
            String[] idaLoclTax = (JSPUtil.getParameter(request, prefix + "ida_locl_tax", length));
            String[] idaN2ndLoclTaxRt = (JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax_rt", length));
            String[] idaN2ndLoclTax = (JSPUtil.getParameter(request, prefix + "ida_n2nd_locl_tax", length));
            String[] idaCgstRto = (JSPUtil.getParameter(request, prefix + "ida_cgst_rto", length));
            String[] idaSgstRto = (JSPUtil.getParameter(request, prefix + "ida_sgst_rto", length));
            String[] idaIgstRto = (JSPUtil.getParameter(request, prefix + "ida_igst_rto", length));
            String[] idaUgstRto = (JSPUtil.getParameter(request, prefix + "ida_ugst_rto", length));
            String[] idaCgstAmt = (JSPUtil.getParameter(request, prefix + "ida_cgst_amt", length));
            String[] idaSgstAmt = (JSPUtil.getParameter(request, prefix + "ida_sgst_amt", length));
            String[] idaIgstAmt = (JSPUtil.getParameter(request, prefix + "ida_igst_amt", length));
            String[] idaUgstAmt = (JSPUtil.getParameter(request, prefix + "ida_ugst_amt", length));
            String[] idaTaxApplTm = (JSPUtil.getParameter(request, prefix + "ida_tax_appl_tm", length));
            String[] idaBankAcctNo = (JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", length));
	    	String[] idaBankIfscCd = (JSPUtil.getParameter(request, prefix + "ida_bank_ifsc_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChargeBookingInvoiceVO();
                if (taxRto[i] != null)
                    model.setTaxRto(taxRto[i]);
                if (invPrtFlg[i] != null)
                    model.setInvPrtFlg(invPrtFlg[i]);
                if (faxEmailSndCnt[i] != null)
                    model.setFaxEmailSndCnt(faxEmailSndCnt[i]);
                if (invHldRsnNm[i] != null)
                    model.setInvHldRsnNm(invHldRsnNm[i]);
                if (invTaxRto[i] != null)
                    model.setInvTaxRto(invTaxRto[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (chgCurrCd[i] != null)
                    model.setChgCurrCd(chgCurrCd[i]);
                if (vpsPortCd[i] != null)
                    model.setVpsPortCd(vpsPortCd[i]);
                if (dcAmt[i] != null)
                    model.setDcAmt(dcAmt[i]);
                if (bkgCustNm[i] != null)
                    model.setBkgCustNm(bkgCustNm[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (aftInvAdjAmt[i] != null)
                    model.setAftInvAdjAmt(aftInvAdjAmt[i]);
                if (cntCd[i] != null)
                    model.setCntCd(cntCd[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (dmdtTrfCd[i] != null)
                    model.setDmdtTrfCd(dmdtTrfCd[i]);
                if (invXchRt[i] != null)
                    model.setInvXchRt(invXchRt[i]);
                if (payerCd[i] != null)
                    model.setPayerCd(payerCd[i]);
                if (ntcKntCd[i] != null)
                    model.setNtcKntCd(ntcKntCd[i]);
                if (truckerCd[i] != null)
                    model.setTruckerCd(truckerCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (cntrCnt[i] != null)
                    model.setCntrCnt(cntrCnt[i]);
                if (creUsrNm[i] != null)
                    model.setCreUsrNm(creUsrNm[i]);
                if (actCustCd[i] != null)
                    model.setActCustCd(actCustCd[i]);
                if (dmdtPayrCntcPntNm[i] != null)
                    model.setDmdtPayrCntcPntNm(dmdtPayrCntcPntNm[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (dmdtCxlRsnNm[i] != null)
                    model.setDmdtCxlRsnNm(dmdtCxlRsnNm[i]);
                if (caller[i] != null)
                    model.setCaller(caller[i]);
                if (totAmt[i] != null)
                    model.setTotAmt(totAmt[i]);
                if (mnlInvSndFlg[i] != null)
                    model.setMnlInvSndFlg(mnlInvSndFlg[i]);
                if (mnOrgChgAmt[i] != null)
                    model.setMnOrgChgAmt(mnOrgChgAmt[i]);
                if (dmdtInvStsNm[i] != null)
                    model.setDmdtInvStsNm(dmdtInvStsNm[i]);
                if (taxAmt[i] != null)
                    model.setTaxAmt(taxAmt[i]);
                if (payerNm[i] != null)
                    model.setPayerNm(payerNm[i]);
                if (dueDate[i] != null)
                    model.setDueDate(dueDate[i]);
                if (crTermDys[i] != null)
                    model.setCrTermDys(crTermDys[i]);
                if (chgType[i] != null)
                    model.setChgType(chgType[i]);
                if (chgDcAmt[i] != null)
                    model.setChgDcAmt(chgDcAmt[i]);
                if (payrCntcPntEml[i] != null)
                    model.setPayrCntcPntEml(payrCntcPntEml[i]);
                if (dmdtInvStsCd[i] != null)
                    model.setDmdtInvStsCd(dmdtInvStsCd[i]);
                if (invChgAmt[i] != null)
                    model.setInvChgAmt(invChgAmt[i]);
                if (dmdtInvNo[i] != null)
                    model.setDmdtInvNo(dmdtInvNo[i]);
                if (arIfUsrId[i] != null)
                    model.setArIfUsrId(arIfUsrId[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (issDtPrnFlg[i] != null)
                    model.setIssDtPrnFlg(issDtPrnFlg[i]);
                if (invRmk[i] != null)
                    model.setInvRmk(invRmk[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (invHldRsnCd[i] != null)
                    model.setInvHldRsnCd(invHldRsnCd[i]);
                if (orgChgAmt[i] != null)
                    model.setOrgChgAmt(orgChgAmt[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (mnBilAmt[i] != null)
                    model.setMnBilAmt(mnBilAmt[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (dmdtExptAmt[i] != null)
                    model.setDmdtExptAmt(dmdtExptAmt[i]);
                if (bkgCustCd[i] != null)
                    model.setBkgCustCd(bkgCustCd[i]);
                if (arIfDt[i] != null)
                    model.setArIfDt(arIfDt[i]);
                if (updOfcCd[i] != null)
                    model.setUpdOfcCd(updOfcCd[i]);
                if (crArYn[i] != null)
                    model.setCrArYn(crArYn[i]);
                if (truckerNm[i] != null)
                    model.setTruckerNm(truckerNm[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (arIfOfcCd[i] != null)
                    model.setArIfOfcCd(arIfOfcCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (dmdtCxlRsnCd[i] != null)
                    model.setDmdtCxlRsnCd(dmdtCxlRsnCd[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (dmdtArIfCd[i] != null)
                    model.setDmdtArIfCd(dmdtArIfCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (custCntcPntSeq[i] != null)
                    model.setCustCntcPntSeq(custCntcPntSeq[i]);
                if (mnlInvRmk[i] != null)
                    model.setMnlInvRmk(mnlInvRmk[i]);
                if (overDay[i] != null)
                    model.setOverDay(overDay[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (invRmk2[i] != null)
                    model.setInvRmk2(invRmk2[i]);
                if (invRmk1[i] != null)
                    model.setInvRmk1(invRmk1[i]);
                if (rd[i] != null)
                    model.setRd(rd[i]);
                if (bilAmt[i] != null)
                    model.setBilAmt(bilAmt[i]);
                if (payrCntcPntFaxNo[i] != null)
                    model.setPayrCntcPntFaxNo(payrCntcPntFaxNo[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (svrId[i] != null)
                    model.setSvrId(svrId[i]);
                if (cxlRmk[i] != null)
                    model.setCxlRmk(cxlRmk[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (creOfcCd[i] != null)
                    model.setCreOfcCd(creOfcCd[i]);
                if (invAmt[i] != null)
                    model.setInvAmt(invAmt[i]);
                if (crInvNo[i] != null)
                    model.setCrInvNo(crInvNo[i]);
                if (arIfUsrNm[i] != null)
                    model.setArIfUsrNm(arIfUsrNm[i]);
                if (invHldRmk[i] != null)
                    model.setInvHldRmk(invHldRmk[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (invRefNo[i] != null)
                    model.setInvRefNo(invRefNo[i]);
                if (issueDay[i] != null)
                    model.setIssueDay(issueDay[i]);
                if (creCntCd[i] != null)
                    model.setCreCntCd(creCntCd[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (bilToLocDivCd[i] != null)
                    model.setBilToLocDivCd(bilToLocDivCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (payrCntcPntPhnNo[i] != null)
                    model.setPayrCntcPntPhnNo(payrCntcPntPhnNo[i]);
                if (actCustNm[i] != null)
                    model.setActCustNm(actCustNm[i]);
                if (useRtCurr[i] != null)
                    model.setUseRtCurr(useRtCurr[i]);
                if (updUsrNm[i] != null)
                    model.setUpdUsrNm(updUsrNm[i]);
                if (rhqOfcCd[i] != null)
                    model.setRhqOfcCd(rhqOfcCd[i]);
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
                if (taxRgstNo[i] != null)
                    model.setTaxRgstNo(taxRgstNo[i]);
                if (pmntAcctNo[i] != null)
                    model.setPmntAcctNo(pmntAcctNo[i]);
                if (svcCateRmk[i] != null)
                    model.setSvcCateRmk(svcCateRmk[i]);
                if (actPayrCustNm[i] != null)
                    model.setActPayrCustNm(actPayrCustNm[i]);
                if (dmdtVtInvStsCd[i] != null)
                    model.setDmdtVtInvStsCd(dmdtVtInvStsCd[i]);
                if (dmdtVtInvNo[i] != null)
                    model.setDmdtVtInvNo(dmdtVtInvNo[i]);
                if (dmdtVtInvYn[i] != null)
                    model.setDmdtVtInvYn(dmdtVtInvYn[i]);
                if (invNewRptFlg[i] != null)
                    model.setInvNewRptFlg(invNewRptFlg[i]);
                if (colDate[i] != null)
                    model.setColDate(colDate[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (colAmt[i] != null)
                    model.setColAmt(colAmt[i]);
                if (colCharge[i] != null)
                    model.setColCharge(colCharge[i]);
                if (colTax[i] != null)
                    model.setColTax(colTax[i]);
                if (colOverDay[i] != null)
                    model.setColOverDay(colOverDay[i]);
                if (otsCltFlg[i] != null)
                    model.setOtsCltFlg(otsCltFlg[i]);
                if (vtCollected[i] != null)
                    model.setVtCollected(vtCollected[i]);
                if (invUncolAmt[i] != null)
                    model.setInvUncolAmt(invUncolAmt[i]);
                if (chgUncolAmt[i] != null)
                    model.setChgUncolAmt(chgUncolAmt[i]);
                if (invColCharge[i] != null)
                    model.setInvColCharge(invColCharge[i]);
                if (invColTax[i] != null)
                    model.setInvColTax(invColTax[i]);
                if (chgColCharge[i] != null)
                    model.setChgColCharge(chgColCharge[i]);
                if (chgColTax[i] != null)
                    model.setChgColTax(chgColTax[i]);
                if (idaLoclTaxRt[i] != null)
                    model.setIdaLoclTaxRt(idaLoclTaxRt[i]);
                if (idaLoclTax[i] != null)
                    model.setIdaLoclTax(idaLoclTax[i]);
                if (idaN2ndLoclTaxRt[i] != null)
                    model.setIdaN2ndLoclTaxRt(idaN2ndLoclTaxRt[i]);
                if (idaN2ndLoclTax[i] != null)
                    model.setIdaN2ndLoclTax(idaN2ndLoclTax[i]);
                if (idaCgstRto[i] != null)
                    model.setIdaCgstRto(idaCgstRto[i]);
                if (idaSgstRto[i] != null)
                    model.setIdaSgstRto(idaSgstRto[i]);
                if (idaIgstRto[i] != null)
                    model.setIdaIgstRto(idaIgstRto[i]);
                if (idaUgstRto[i] != null)
                    model.setIdaUgstRto(idaUgstRto[i]);
                if (idaCgstAmt[i] != null)
                    model.setIdaCgstAmt(idaCgstAmt[i]);
                if (idaSgstAmt[i] != null)
                    model.setIdaSgstAmt(idaSgstAmt[i]);
                if (idaIgstAmt[i] != null)
                    model.setIdaIgstAmt(idaIgstAmt[i]);
                if (idaUgstAmt[i] != null)
                    model.setIdaUgstAmt(idaUgstAmt[i]);
                if (idaTaxApplTm[i] != null)
                    model.setIdaTaxApplTm(idaTaxApplTm[i]);
                if (idaBankAcctNo[i] != null) 
		    		model.setIdaBankAcctNo(idaBankAcctNo[i]);
				if (idaBankIfscCd[i] != null) 
		    		model.setIdaBankIfscCd(idaBankIfscCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChargeBookingInvoiceVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChargeBookingInvoiceVO[]
	 */
    public ChargeBookingInvoiceVO[] getChargeBookingInvoiceVOs() {
        ChargeBookingInvoiceVO[] vos = (ChargeBookingInvoiceVO[]) models.toArray(new ChargeBookingInvoiceVO[models.size()]);
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
        this.taxRto = this.taxRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invPrtFlg = this.invPrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxEmailSndCnt = this.faxEmailSndCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invHldRsnNm = this.invHldRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invTaxRto = this.invTaxRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgCurrCd = this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcAmt = this.dcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustNm = this.bkgCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftInvAdjAmt = this.aftInvAdjAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntCd = this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtTrfCd = this.dmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invXchRt = this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerCd = this.payerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ntcKntCd = this.ntcKntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.truckerCd = this.truckerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCnt = this.cntrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrNm = this.creUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCustCd = this.actCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtPayrCntcPntNm = this.dmdtPayrCntcPntNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCxlRsnNm = this.dmdtCxlRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caller = this.caller.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.totAmt = this.totAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnlInvSndFlg = this.mnlInvSndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnOrgChgAmt = this.mnOrgChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvStsNm = this.dmdtInvStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxAmt = this.taxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerNm = this.payerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dueDate = this.dueDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crTermDys = this.crTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgType = this.chgType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgDcAmt = this.chgDcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payrCntcPntEml = this.payrCntcPntEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvStsCd = this.dmdtInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invChgAmt = this.invChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvNo = this.dmdtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfUsrId = this.arIfUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issDtPrnFlg = this.issDtPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk = this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invHldRsnCd = this.invHldRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgChgAmt = this.orgChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnBilAmt = this.mnBilAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtExptAmt = this.dmdtExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCustCd = this.bkgCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfDt = this.arIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updOfcCd = this.updOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crArYn = this.crArYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.truckerNm = this.truckerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfOfcCd = this.arIfOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtCxlRsnCd = this.dmdtCxlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtArIfCd = this.dmdtArIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntcPntSeq = this.custCntcPntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnlInvRmk = this.mnlInvRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.overDay = this.overDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk2 = this.invRmk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk1 = this.invRmk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rd = this.rd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilAmt = this.bilAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payrCntcPntFaxNo = this.payrCntcPntFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svrId = this.svrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cxlRmk = this.cxlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invAmt = this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crInvNo = this.crInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfUsrNm = this.arIfUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invHldRmk = this.invHldRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRefNo = this.invRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issueDay = this.issueDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creCntCd = this.creCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilToLocDivCd = this.bilToLocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payrCntcPntPhnNo = this.payrCntcPntPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actCustNm = this.actCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actPayrCustNm = this.actPayrCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.useRtCurr = this.useRtCurr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrNm = this.updUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqOfcCd = this.rhqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaExpnTaxRt = this.idaExpnTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaExpnTax = this.idaExpnTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaEduTaxRt = this.idaEduTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaEduTax = this.idaEduTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaHighEduTaxRt = this.idaHighEduTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaHighEduTax = this.idaHighEduTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxRgstNo = this.taxRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pmntAcctNo = this.pmntAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcCateRmk = this.svcCateRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtVtInvStsCd = this.dmdtVtInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtVtInvNo = this.dmdtVtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtVtInvYn = this.dmdtVtInvYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invNewRptFlg = this.invNewRptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colDate = this.colDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colAmt = this.colAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colCharge = this.colCharge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colTax = this.colTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colOverDay = this.colOverDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsCltFlg = this.otsCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vtCollected = this.vtCollected.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invUncolAmt = this.invUncolAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgUncolAmt = this.chgUncolAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invColCharge = this.invColCharge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invColTax = this.invColTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgColCharge = this.chgColCharge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgColTax = this.chgColTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaLoclTaxRt = this.idaLoclTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaLoclTax = this.idaLoclTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaN2ndLoclTaxRt = this.idaN2ndLoclTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaN2ndLoclTax = this.idaN2ndLoclTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstRto = this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstRto = this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstRto = this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstRto = this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstAmt = this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstAmt = this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstAmt = this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstAmt = this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxApplTm = this.idaTaxApplTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaBankAcctNo = this.idaBankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaBankIfscCd = this.idaBankIfscCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
