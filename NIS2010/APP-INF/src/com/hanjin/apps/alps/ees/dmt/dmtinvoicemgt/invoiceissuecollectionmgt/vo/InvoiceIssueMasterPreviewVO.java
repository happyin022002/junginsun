/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueMasterPreviewVO.java
*@FileTitle : InvoiceIssueMasterPreviewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.01.12 김태균 
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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class InvoiceIssueMasterPreviewVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<InvoiceIssueMasterPreviewVO> models = new ArrayList<InvoiceIssueMasterPreviewVO>();

    /* Column Info */
    private String rdInvCurrCd = null;

    /* Column Info */
    private String rdDcAmt = null;

    /* Column Info */
    private String rdBkgRcvTermNm = null;

    /* Column Info */
    private String rdTaxAmt = null;

    /* Column Info */
    private String rdTaxAmtPrnFlg = null;

    /* Column Info */
    private String rdPayrAddr = null;

    /* Column Info */
    private String rdPhnFaxPrnFlg = null;

    /* Column Info */
    private String rdCustNm = null;

    /* Column Info */
    private String rdPhnNo = null;

    /* Column Info */
    private String rdInvRefNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String rdShRmk11 = null;

    /* Column Info */
    private String rdShRmk10 = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String rdShRmk13 = null;

    /* Column Info */
    private String rdShRmk12 = null;

    /* Column Info */
    private String rdCancelNote = null;

    /* Column Info */
    private String rdCreCntCd = null;

    /* Column Info */
    private String rdShRmk14 = null;

    /* Column Info */
    private String rdDel = null;

    /* Column Info */
    private String rdPod = null;

    /* Column Info */
    private String rdDep = null;

    /* Column Info */
    private String rdCustRefPrnFlg = null;

    /* Column Info */
    private String rdCustVatNo = null;

    /* Column Info */
    private String rdShRmk4 = null;

    /* Column Info */
    private String rdShRmk3 = null;

    /* Column Info */
    private String rdShRmk2 = null;

    /* Column Info */
    private String rdShHdN3rdMsg = null;

    /* Column Info */
    private String rdShRmk1 = null;

    /* Column Info */
    private String rdShRmk8 = null;

    /* Column Info */
    private String rdShRmk7 = null;

    /* Column Info */
    private String rdShRmk6 = null;

    /* Column Info */
    private String rdShRmk5 = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String rdCreUsrNm = null;

    /* Column Info */
    private String rdBkgDelTermNm = null;

    /* Column Info */
    private String rdInvAmt = null;

    /* Column Info */
    private String rdOrgChgAmt = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String rdOrgCurrCd = null;

    /* Column Info */
    private String rdDmdtInvNo = null;

    /* Column Info */
    private String rdCustVatPrnFlg = null;

    /* Column Info */
    private String rdInvRmk2 = null;

    /* Column Info */
    private String rdInvRmk1 = null;

    /* Column Info */
    private String rdShRmk9 = null;

    /* Column Info */
    private String rdDaysDisp = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String rdDmdtTrfCd = null;

    /* Column Info */
    private String rdShHdN2ndMsg = null;

    /* Column Info */
    private String rdVvdCd = null;

    /* Column Info */
    private String rdCustCd = null;

    /* Column Info */
    private String rdDueDate = null;

    /* Column Info */
    private String rdShAddr1 = null;

    /* Column Info */
    private String rdShAddr2 = null;

    /* Column Info */
    private String rdShAddr3 = null;

    /* Column Info */
    private String rdPodNm = null;

    /* Column Info */
    private String rdBlNo = null;

    /* Column Info */
    private String rdShHdN4thMsg = null;

    /* Column Info */
    private String rdCmdtNm = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String rdDelNm = null;

    /* Column Info */
    private String rdVslEngNm = null;

    /* Column Info */
    private String rdShHdN5thMsg = null;

    /* Column Info */
    private String rdDueDay = null;

    /* Column Info */
    private String rdInvoiceTitle = null;

    /* Column Info */
    private String rdBkgNo = null;

    /* Column Info */
    private String rdNtcKntCd = null;

    /* Column Info */
    private String rdShHdN1stMsg = null;

    /* Column Info */
    private String rdTotAmt = null;

    /* Column Info */
    private String rdDcAmtFlg = null;

    /* Column Info */
    private String rdFaxNo = null;

    /* Column Info */
    private String rdArr = null;

    /* Column Info */
    private String rdTaxRto = null;

    /* Column Info */
    private String rdInvChgAmt = null;

    /* Column Info */
    private String rdIssueDay = null;

    /* Column Info */
    private String rdDmdtTrfNm = null;

    /* Column Info */
    private String rdAttnNm = null;

    /* Column Info */
    private String rdInvXchRt = null;

    /* Column Info */
    private String rdTruckerNm = null;

    /* Column Info */
    private String rdDmdtInvStsCd = null;

    /* Column Info */
    private String rdIdaExpnTaxRt = null;

    /* Column Info */
    private String rdIdaExpnTax = null;

    /* Column Info */
    private String rdIdaEduTaxRt = null;

    /* Column Info */
    private String rdIdaEduTax = null;

    /* Column Info */
    private String rdIdaHighEduTaxRt = null;

    /* Column Info */
    private String rdIdaHighEduTax = null;

    /* Column Info */
    private String rdSvcCateRmk = null;

    /* Column Info */
    private String rdPmntAcctNo = null;

    /* Column Info */
    private String rdTaxRgstNo = null;

    /* Column Info */
    private String rdIdaLoclTaxRt = null;

    /* Column Info */
    private String rdIdaLoclTax = null;

    /* Column Info */
    private String rdIdaN2ndLoclTaxRt = null;

    /* Column Info */
    private String rdIdaN2ndLoclTax = null;

    /* Column Info */
    private String rdIdaTaxApplTm = null;

    /* Column Info */
    private String rdIdaCgstRto = null;

    /* Column Info */
    private String rdIdaCgstAmt = null;

    /* Column Info */
    private String rdIdaSgstRto = null;

    /* Column Info */
    private String rdIdaSgstAmt = null;

    /* Column Info */
    private String rdIdaIgstRto = null;

    /* Column Info */
    private String rdIdaIgstAmt = null;

    /* Column Info */
    private String rdIdaUgstRto = null;

    /* Column Info */
    private String rdIdaUgstAmt = null;

    /* Column Info */
    private String rdIdaBankAcctNo = null;

    /* Column Info */
    private String rdIdaBankIfscCd = null;

    /* Column Info */
    private String rdIdaTaxCin = null;

    /* Column Info */
    private String rdIdaGstRgstNo = null;

    /* Column Info */
    private String rdIdaSteCd = null;

    /* Column Info */
    private String rdIdaSteNm = null;
    
    /* Column Info */
    private String rdIdaSacCd = null;

    /* Column Info */
    private String rdIdaOfcSteCd = null;

    /* Column Info */
    private String rdIdaOfcSteNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public InvoiceIssueMasterPreviewVO() {
    }

    public InvoiceIssueMasterPreviewVO(String ibflag, String pagerows, String rdShAddr1, String rdShAddr2, String rdShAddr3, String rdInvoiceTitle, String rdCancelNote, String rdCustNm, String rdPayrAddr, String rdAttnNm, String rdPhnNo, String rdFaxNo, String rdShHdN1stMsg, String rdShHdN2ndMsg, String rdShHdN3rdMsg, String rdShHdN4thMsg, String rdShHdN5thMsg, String rdDmdtInvNo, String rdIssueDay, String rdDueDate, String rdDueDay, String rdNtcKntCd, String rdCreUsrNm, String rdCustCd, String rdInvRefNo, String rdCustVatNo, String rdVvdCd, String rdVslEngNm, String rdArr, String rdDep, String rdBlNo, String rdBkgNo, String rdCmdtNm, String rdDmdtTrfCd, String rdDmdtTrfNm, String rdBkgRcvTermNm, String rdBkgDelTermNm, String rdPod, String rdPodNm, String rdDel, String rdDelNm, String rdTruckerNm, String rdInvRmk1, String rdInvRmk2, String rdShRmk1, String rdShRmk2, String rdShRmk3, String rdShRmk4, String rdShRmk5, String rdShRmk6, String rdShRmk7, String rdShRmk8, String rdShRmk9, String rdShRmk10, String rdShRmk11, String rdShRmk12, String rdShRmk13, String rdShRmk14, String rdOrgChgAmt, String rdOrgCurrCd, String rdInvXchRt, String rdTotAmt, String rdInvCurrCd, String rdDcAmt, String rdInvChgAmt, String rdTaxRto, String rdTaxAmt, String rdInvAmt, String rdTaxAmtPrnFlg, String rdDcAmtFlg, String rdCustRefPrnFlg, String rdCustVatPrnFlg, String rdPhnFaxPrnFlg, String rdDaysDisp, String rdDmdtInvStsCd, String rdCreCntCd, String podCd, String porCd, String delCd, String polCd, String rdIdaExpnTaxRt, String rdIdaExpnTax, String rdIdaEduTaxRt, String rdIdaEduTax, String rdIdaHighEduTaxRt, String rdIdaHighEduTax, String rdTaxRgstNo, String rdSvcCateRmk, String rdPmntAcctNo, String rdIdaLoclTaxRt, String rdIdaLoclTax, String rdIdaN2ndLoclTaxRt, String rdIdaN2ndLoclTax, String rdIdaTaxApplTm, String rdIdaCgstRto, String rdIdaCgstAmt, String rdIdaSgstRto, String rdIdaSgstAmt, String rdIdaIgstRto, String rdIdaIgstAmt, String rdIdaUgstRto, String rdIdaUgstAmt, String rdIdaBankAcctNo, String rdIdaBankIfscCd, String rdIdaTaxCin, String rdIdaGstRgstNo, String rdIdaSteCd, String rdIdaSteNm, String rdIdaSacCd, String rdIdaOfcSteCd, String rdIdaOfcSteNm) {
        this.rdInvCurrCd = rdInvCurrCd;
        this.rdDcAmt = rdDcAmt;
        this.rdBkgRcvTermNm = rdBkgRcvTermNm;
        this.rdTaxAmt = rdTaxAmt;
        this.rdTaxAmtPrnFlg = rdTaxAmtPrnFlg;
        this.rdPayrAddr = rdPayrAddr;
        this.rdPhnFaxPrnFlg = rdPhnFaxPrnFlg;
        this.rdCustNm = rdCustNm;
        this.rdPhnNo = rdPhnNo;
        this.rdInvRefNo = rdInvRefNo;
        this.pagerows = pagerows;
        this.rdShRmk11 = rdShRmk11;
        this.rdShRmk10 = rdShRmk10;
        this.polCd = polCd;
        this.rdShRmk13 = rdShRmk13;
        this.rdShRmk12 = rdShRmk12;
        this.rdCancelNote = rdCancelNote;
        this.rdCreCntCd = rdCreCntCd;
        this.rdShRmk14 = rdShRmk14;
        this.rdDel = rdDel;
        this.rdPod = rdPod;
        this.rdDep = rdDep;
        this.rdCustRefPrnFlg = rdCustRefPrnFlg;
        this.rdCustVatNo = rdCustVatNo;
        this.rdShRmk4 = rdShRmk4;
        this.rdShRmk3 = rdShRmk3;
        this.rdShRmk2 = rdShRmk2;
        this.rdShHdN3rdMsg = rdShHdN3rdMsg;
        this.rdShRmk1 = rdShRmk1;
        this.rdShRmk8 = rdShRmk8;
        this.rdShRmk7 = rdShRmk7;
        this.rdShRmk6 = rdShRmk6;
        this.rdShRmk5 = rdShRmk5;
        this.delCd = delCd;
        this.rdCreUsrNm = rdCreUsrNm;
        this.rdBkgDelTermNm = rdBkgDelTermNm;
        this.rdInvAmt = rdInvAmt;
        this.rdOrgChgAmt = rdOrgChgAmt;
        this.podCd = podCd;
        this.rdOrgCurrCd = rdOrgCurrCd;
        this.rdDmdtInvNo = rdDmdtInvNo;
        this.rdCustVatPrnFlg = rdCustVatPrnFlg;
        this.rdInvRmk2 = rdInvRmk2;
        this.rdInvRmk1 = rdInvRmk1;
        this.rdShRmk9 = rdShRmk9;
        this.rdDaysDisp = rdDaysDisp;
        this.porCd = porCd;
        this.rdDmdtTrfCd = rdDmdtTrfCd;
        this.rdShHdN2ndMsg = rdShHdN2ndMsg;
        this.rdVvdCd = rdVvdCd;
        this.rdCustCd = rdCustCd;
        this.rdDueDate = rdDueDate;
        this.rdShAddr1 = rdShAddr1;
        this.rdShAddr2 = rdShAddr2;
        this.rdShAddr3 = rdShAddr3;
        this.rdPodNm = rdPodNm;
        this.rdBlNo = rdBlNo;
        this.rdShHdN4thMsg = rdShHdN4thMsg;
        this.rdCmdtNm = rdCmdtNm;
        this.ibflag = ibflag;
        this.rdDelNm = rdDelNm;
        this.rdVslEngNm = rdVslEngNm;
        this.rdShHdN5thMsg = rdShHdN5thMsg;
        this.rdDueDay = rdDueDay;
        this.rdInvoiceTitle = rdInvoiceTitle;
        this.rdBkgNo = rdBkgNo;
        this.rdNtcKntCd = rdNtcKntCd;
        this.rdShHdN1stMsg = rdShHdN1stMsg;
        this.rdTotAmt = rdTotAmt;
        this.rdDcAmtFlg = rdDcAmtFlg;
        this.rdFaxNo = rdFaxNo;
        this.rdArr = rdArr;
        this.rdTaxRto = rdTaxRto;
        this.rdInvChgAmt = rdInvChgAmt;
        this.rdIssueDay = rdIssueDay;
        this.rdDmdtTrfNm = rdDmdtTrfNm;
        this.rdAttnNm = rdAttnNm;
        this.rdInvXchRt = rdInvXchRt;
        this.rdTruckerNm = rdTruckerNm;
        this.rdDmdtInvStsCd = rdDmdtInvStsCd;
        this.rdIdaExpnTaxRt = rdIdaExpnTaxRt;
        this.rdIdaExpnTax = rdIdaExpnTax;
        this.rdIdaEduTax = rdIdaEduTax;
        this.rdIdaEduTaxRt = rdIdaEduTaxRt;
        this.rdIdaHighEduTaxRt = rdIdaHighEduTaxRt;
        this.rdIdaHighEduTax = rdIdaHighEduTax;
        this.rdSvcCateRmk = rdSvcCateRmk;
        this.rdPmntAcctNo = rdPmntAcctNo;
        this.rdTaxRgstNo = rdTaxRgstNo;
        this.rdIdaLoclTaxRt = rdIdaLoclTaxRt;
        this.rdIdaLoclTax = rdIdaLoclTax;
        this.rdIdaN2ndLoclTaxRt = rdIdaN2ndLoclTaxRt;
        this.rdIdaN2ndLoclTax = rdIdaN2ndLoclTax;
        this.rdIdaTaxApplTm = rdIdaTaxApplTm;
        this.rdIdaCgstRto = rdIdaCgstRto;
        this.rdIdaCgstAmt = rdIdaCgstAmt;
        this.rdIdaSgstRto = rdIdaSgstRto;
        this.rdIdaSgstAmt = rdIdaSgstAmt;
        this.rdIdaIgstRto = rdIdaIgstRto;
        this.rdIdaIgstAmt = rdIdaIgstAmt;
        this.rdIdaUgstRto = rdIdaUgstRto;
        this.rdIdaUgstAmt = rdIdaUgstAmt;
        this.rdIdaBankAcctNo = rdIdaBankAcctNo;
        this.rdIdaBankIfscCd = rdIdaBankIfscCd;
        this.rdIdaTaxCin = rdIdaTaxCin;
        this.rdIdaGstRgstNo = rdIdaGstRgstNo;
        this.rdIdaSteCd = rdIdaSteCd;
        this.rdIdaSteNm = rdIdaSteNm;
        this.rdIdaSacCd = rdIdaSacCd;
        this.rdIdaOfcSteCd = rdIdaOfcSteCd;
        this.rdIdaOfcSteNm = rdIdaOfcSteNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("rd_inv_curr_cd", getRdInvCurrCd());
        this.hashColumns.put("rd_dc_amt", getRdDcAmt());
        this.hashColumns.put("rd_bkg_rcv_term_nm", getRdBkgRcvTermNm());
        this.hashColumns.put("rd_tax_amt", getRdTaxAmt());
        this.hashColumns.put("rd_tax_amt_prn_flg", getRdTaxAmtPrnFlg());
        this.hashColumns.put("rd_payr_addr", getRdPayrAddr());
        this.hashColumns.put("rd_phn_fax_prn_flg", getRdPhnFaxPrnFlg());
        this.hashColumns.put("rd_cust_nm", getRdCustNm());
        this.hashColumns.put("rd_phn_no", getRdPhnNo());
        this.hashColumns.put("rd_inv_ref_no", getRdInvRefNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("rd_sh_rmk11", getRdShRmk11());
        this.hashColumns.put("rd_sh_rmk10", getRdShRmk10());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("rd_sh_rmk13", getRdShRmk13());
        this.hashColumns.put("rd_sh_rmk12", getRdShRmk12());
        this.hashColumns.put("rd_cancel_note", getRdCancelNote());
        this.hashColumns.put("rd_cre_cnt_cd", getRdCreCntCd());
        this.hashColumns.put("rd_sh_rmk14", getRdShRmk14());
        this.hashColumns.put("rd_del", getRdDel());
        this.hashColumns.put("rd_pod", getRdPod());
        this.hashColumns.put("rd_dep", getRdDep());
        this.hashColumns.put("rd_cust_ref_prn_flg", getRdCustRefPrnFlg());
        this.hashColumns.put("rd_cust_vat_no", getRdCustVatNo());
        this.hashColumns.put("rd_sh_rmk4", getRdShRmk4());
        this.hashColumns.put("rd_sh_rmk3", getRdShRmk3());
        this.hashColumns.put("rd_sh_rmk2", getRdShRmk2());
        this.hashColumns.put("rd_sh_hd_n3rd_msg", getRdShHdN3rdMsg());
        this.hashColumns.put("rd_sh_rmk1", getRdShRmk1());
        this.hashColumns.put("rd_sh_rmk8", getRdShRmk8());
        this.hashColumns.put("rd_sh_rmk7", getRdShRmk7());
        this.hashColumns.put("rd_sh_rmk6", getRdShRmk6());
        this.hashColumns.put("rd_sh_rmk5", getRdShRmk5());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("rd_cre_usr_nm", getRdCreUsrNm());
        this.hashColumns.put("rd_bkg_del_term_nm", getRdBkgDelTermNm());
        this.hashColumns.put("rd_inv_amt", getRdInvAmt());
        this.hashColumns.put("rd_org_chg_amt", getRdOrgChgAmt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("rd_org_curr_cd", getRdOrgCurrCd());
        this.hashColumns.put("rd_dmdt_inv_no", getRdDmdtInvNo());
        this.hashColumns.put("rd_cust_vat_prn_flg", getRdCustVatPrnFlg());
        this.hashColumns.put("rd_inv_rmk2", getRdInvRmk2());
        this.hashColumns.put("rd_inv_rmk1", getRdInvRmk1());
        this.hashColumns.put("rd_sh_rmk9", getRdShRmk9());
        this.hashColumns.put("rd_days_disp", getRdDaysDisp());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("rd_dmdt_trf_cd", getRdDmdtTrfCd());
        this.hashColumns.put("rd_sh_hd_n2nd_msg", getRdShHdN2ndMsg());
        this.hashColumns.put("rd_vvd_cd", getRdVvdCd());
        this.hashColumns.put("rd_cust_cd", getRdCustCd());
        this.hashColumns.put("rd_due_date", getRdDueDate());
        this.hashColumns.put("rd_sh_addr1", getRdShAddr1());
        this.hashColumns.put("rd_sh_addr2", getRdShAddr2());
        this.hashColumns.put("rd_sh_addr3", getRdShAddr3());
        this.hashColumns.put("rd_pod_nm", getRdPodNm());
        this.hashColumns.put("rd_bl_no", getRdBlNo());
        this.hashColumns.put("rd_sh_hd_n4th_msg", getRdShHdN4thMsg());
        this.hashColumns.put("rd_cmdt_nm", getRdCmdtNm());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rd_del_nm", getRdDelNm());
        this.hashColumns.put("rd_vsl_eng_nm", getRdVslEngNm());
        this.hashColumns.put("rd_sh_hd_n5th_msg", getRdShHdN5thMsg());
        this.hashColumns.put("rd_due_day", getRdDueDay());
        this.hashColumns.put("rd_invoice_title", getRdInvoiceTitle());
        this.hashColumns.put("rd_bkg_no", getRdBkgNo());
        this.hashColumns.put("rd_ntc_knt_cd", getRdNtcKntCd());
        this.hashColumns.put("rd_sh_hd_n1st_msg", getRdShHdN1stMsg());
        this.hashColumns.put("rd_tot_amt", getRdTotAmt());
        this.hashColumns.put("rd_dc_amt_flg", getRdDcAmtFlg());
        this.hashColumns.put("rd_fax_no", getRdFaxNo());
        this.hashColumns.put("rd_arr", getRdArr());
        this.hashColumns.put("rd_tax_rto", getRdTaxRto());
        this.hashColumns.put("rd_inv_chg_amt", getRdInvChgAmt());
        this.hashColumns.put("rd_issue_day", getRdIssueDay());
        this.hashColumns.put("rd_dmdt_trf_nm", getRdDmdtTrfNm());
        this.hashColumns.put("rd_attn_nm", getRdAttnNm());
        this.hashColumns.put("rd_inv_xch_rt", getRdInvXchRt());
        this.hashColumns.put("rd_trucker_nm", getRdTruckerNm());
        this.hashColumns.put("rd_dmdt_inv_sts_cd", getRdDmdtInvStsCd());
        this.hashColumns.put("rd_ida_expn_tax_rt", getRdIdaExpnTaxRt());
        this.hashColumns.put("rd_ida_expn_tax", getRdIdaExpnTax());
        this.hashColumns.put("rd_ida_edu_tax_rt", getRdIdaEduTaxRt());
        this.hashColumns.put("rd_ida_edu_tax", getRdIdaEduTax());
        this.hashColumns.put("rd_ida_high_edu_tax_rt", getRdIdaHighEduTaxRt());
        this.hashColumns.put("rd_ida_high_edu_tax", getRdIdaHighEduTax());
        this.hashColumns.put("rd_svc_cate_rmk", getRdSvcCateRmk());
        this.hashColumns.put("rd_pmnt_acct_no", getRdPmntAcctNo());
        this.hashColumns.put("rd_tax_rgst_no", getRdTaxRgstNo());
        this.hashColumns.put("rd_ida_locl_tax_rt", getRdIdaLoclTaxRt());
        this.hashColumns.put("rd_ida_locl_tax", getRdIdaLoclTax());
        this.hashColumns.put("rd_ida_n2nd_locl_tax_rt", getRdIdaN2ndLoclTaxRt());
        this.hashColumns.put("rd_ida_n2nd_locl_tax", getRdIdaN2ndLoclTax());
        this.hashColumns.put("rd_ida_tax_appl_tm", getRdIdaTaxApplTm());
        this.hashColumns.put("rd_ida_cgst_rto", getRdIdaCgstRto());
        this.hashColumns.put("rd_ida_cgst_amt", getRdIdaCgstAmt());
        this.hashColumns.put("rd_ida_sgst_rto", getRdIdaSgstRto());
        this.hashColumns.put("rd_ida_sgst_amt", getRdIdaSgstAmt());
        this.hashColumns.put("rd_ida_igst_rto", getRdIdaIgstRto());
        this.hashColumns.put("rd_ida_igst_amt", getRdIdaIgstAmt());
        this.hashColumns.put("rd_ida_ugst_rto", getRdIdaUgstRto());
        this.hashColumns.put("rd_ida_ugst_amt", getRdIdaUgstAmt());
        this.hashColumns.put("rd_ida_bank_acct_no", getRdIdaBankAcctNo());
        this.hashColumns.put("rd_ida_bank_ifsc_cd", getRdIdaBankIfscCd());
        this.hashColumns.put("rd_ida_tax_cin", getRdIdaTaxCin());
        this.hashColumns.put("rd_ida_gst_rgst_no", getRdIdaGstRgstNo());
        this.hashColumns.put("rd_ida_ste_cd", getRdIdaSteCd());
        this.hashColumns.put("rd_ida_ste_nm", getRdIdaSteNm());
        this.hashColumns.put("rd_ida_sac_cd", getRdIdaSacCd());
        this.hashColumns.put("rd_ida_ofc_ste_cd", getRdIdaOfcSteCd());
        this.hashColumns.put("rd_ida_ofc_ste_nm", getRdIdaOfcSteNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("rd_inv_curr_cd", "rdInvCurrCd");
        this.hashFields.put("rd_dc_amt", "rdDcAmt");
        this.hashFields.put("rd_bkg_rcv_term_nm", "rdBkgRcvTermNm");
        this.hashFields.put("rd_tax_amt", "rdTaxAmt");
        this.hashFields.put("rd_tax_amt_prn_flg", "rdTaxAmtPrnFlg");
        this.hashFields.put("rd_payr_addr", "rdPayrAddr");
        this.hashFields.put("rd_phn_fax_prn_flg", "rdPhnFaxPrnFlg");
        this.hashFields.put("rd_cust_nm", "rdCustNm");
        this.hashFields.put("rd_phn_no", "rdPhnNo");
        this.hashFields.put("rd_inv_ref_no", "rdInvRefNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("rd_sh_rmk11", "rdShRmk11");
        this.hashFields.put("rd_sh_rmk10", "rdShRmk10");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("rd_sh_rmk13", "rdShRmk13");
        this.hashFields.put("rd_sh_rmk12", "rdShRmk12");
        this.hashFields.put("rd_cancel_note", "rdCancelNote");
        this.hashFields.put("rd_cre_cnt_cd", "rdCreCntCd");
        this.hashFields.put("rd_sh_rmk14", "rdShRmk14");
        this.hashFields.put("rd_del", "rdDel");
        this.hashFields.put("rd_pod", "rdPod");
        this.hashFields.put("rd_dep", "rdDep");
        this.hashFields.put("rd_cust_ref_prn_flg", "rdCustRefPrnFlg");
        this.hashFields.put("rd_cust_vat_no", "rdCustVatNo");
        this.hashFields.put("rd_sh_rmk4", "rdShRmk4");
        this.hashFields.put("rd_sh_rmk3", "rdShRmk3");
        this.hashFields.put("rd_sh_rmk2", "rdShRmk2");
        this.hashFields.put("rd_sh_hd_n3rd_msg", "rdShHdN3rdMsg");
        this.hashFields.put("rd_sh_rmk1", "rdShRmk1");
        this.hashFields.put("rd_sh_rmk8", "rdShRmk8");
        this.hashFields.put("rd_sh_rmk7", "rdShRmk7");
        this.hashFields.put("rd_sh_rmk6", "rdShRmk6");
        this.hashFields.put("rd_sh_rmk5", "rdShRmk5");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("rd_cre_usr_nm", "rdCreUsrNm");
        this.hashFields.put("rd_bkg_del_term_nm", "rdBkgDelTermNm");
        this.hashFields.put("rd_inv_amt", "rdInvAmt");
        this.hashFields.put("rd_org_chg_amt", "rdOrgChgAmt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("rd_org_curr_cd", "rdOrgCurrCd");
        this.hashFields.put("rd_dmdt_inv_no", "rdDmdtInvNo");
        this.hashFields.put("rd_cust_vat_prn_flg", "rdCustVatPrnFlg");
        this.hashFields.put("rd_inv_rmk2", "rdInvRmk2");
        this.hashFields.put("rd_inv_rmk1", "rdInvRmk1");
        this.hashFields.put("rd_sh_rmk9", "rdShRmk9");
        this.hashFields.put("rd_days_disp", "rdDaysDisp");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("rd_dmdt_trf_cd", "rdDmdtTrfCd");
        this.hashFields.put("rd_sh_hd_n2nd_msg", "rdShHdN2ndMsg");
        this.hashFields.put("rd_vvd_cd", "rdVvdCd");
        this.hashFields.put("rd_cust_cd", "rdCustCd");
        this.hashFields.put("rd_due_date", "rdDueDate");
        this.hashFields.put("rd_sh_addr1", "rdShAddr1");
        this.hashFields.put("rd_sh_addr2", "rdShAddr2");
        this.hashFields.put("rd_sh_addr3", "rdShAddr3");
        this.hashFields.put("rd_pod_nm", "rdPodNm");
        this.hashFields.put("rd_bl_no", "rdBlNo");
        this.hashFields.put("rd_sh_hd_n4th_msg", "rdShHdN4thMsg");
        this.hashFields.put("rd_cmdt_nm", "rdCmdtNm");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rd_del_nm", "rdDelNm");
        this.hashFields.put("rd_vsl_eng_nm", "rdVslEngNm");
        this.hashFields.put("rd_sh_hd_n5th_msg", "rdShHdN5thMsg");
        this.hashFields.put("rd_due_day", "rdDueDay");
        this.hashFields.put("rd_invoice_title", "rdInvoiceTitle");
        this.hashFields.put("rd_bkg_no", "rdBkgNo");
        this.hashFields.put("rd_ntc_knt_cd", "rdNtcKntCd");
        this.hashFields.put("rd_sh_hd_n1st_msg", "rdShHdN1stMsg");
        this.hashFields.put("rd_tot_amt", "rdTotAmt");
        this.hashFields.put("rd_dc_amt_flg", "rdDcAmtFlg");
        this.hashFields.put("rd_fax_no", "rdFaxNo");
        this.hashFields.put("rd_arr", "rdArr");
        this.hashFields.put("rd_tax_rto", "rdTaxRto");
        this.hashFields.put("rd_inv_chg_amt", "rdInvChgAmt");
        this.hashFields.put("rd_issue_day", "rdIssueDay");
        this.hashFields.put("rd_dmdt_trf_nm", "rdDmdtTrfNm");
        this.hashFields.put("rd_attn_nm", "rdAttnNm");
        this.hashFields.put("rd_inv_xch_rt", "rdInvXchRt");
        this.hashFields.put("rd_trucker_nm", "rdTruckerNm");
        this.hashFields.put("rd_dmdt_inv_sts_cd", "rdDmdtInvStsCd");
        this.hashFields.put("rd_ida_expn_tax_rt", "rdIdaExpnTaxRt");
        this.hashFields.put("rd_ida_expn_tax", "rdIdaExpnTax");
        this.hashFields.put("rd_ida_edu_tax", "rdIdaEduTax");
        this.hashFields.put("rd_ida_edu_tax_rt", "rdIdaEduTaxRt");
        this.hashFields.put("rd_ida_high_edu_tax_rt", "rdIdaHighEduTaxRt");
        this.hashFields.put("rd_ida_high_edu_tax", "rdIdaHighEduTax");
        this.hashFields.put("rd_svc_cate_rmk", "rdSvcCateRmk");
        this.hashFields.put("rd_pmnt_acct_no", "rdPmntAcctNo");
        this.hashFields.put("rd_tax_rgst_no", "rdTaxRgstNo");
        this.hashFields.put("rd_ida_locl_tax_rt", "rdIdaLoclTaxRt");
        this.hashFields.put("rd_ida_locl_tax", "rdIdaLoclTax");
        this.hashFields.put("rd_ida_n2nd_locl_tax_rt", "rdIdaN2ndLoclTaxRt");
        this.hashFields.put("rd_ida_n2nd_locl_tax", "rdIdaN2ndLoclTax");
        this.hashFields.put("rd_ida_tax_appl_tm", "rdIdaTaxApplTm");
        this.hashFields.put("rd_ida_cgst_rto", "rdIdaCgstRto");
        this.hashFields.put("rd_ida_cgst_amt", "rdIdaCgstAmt");
        this.hashFields.put("rd_ida_sgst_rto", "rdIdaSgstRto");
        this.hashFields.put("rd_ida_sgst_amt", "rdIdaSgstAmt");
        this.hashFields.put("rd_ida_igst_rto", "rdIdaIgstRto");
        this.hashFields.put("rd_ida_igst_amt", "rdIdaIgstAmt");
        this.hashFields.put("rd_ida_ugst_rto", "rdIdaUgstRto");
        this.hashFields.put("rd_ida_ugst_amt", "rdIdaUgstAmt");
        this.hashFields.put("rd_ida_bank_acct_no", "rdIdaBankAcctNo");
        this.hashFields.put("rd_ida_bank_ifsc_cd", "rdIdaBankIfscCd");
        this.hashFields.put("rd_ida_tax_cin", "rdIdaTaxCin");
        this.hashFields.put("rd_ida_gst_rgst_no", "rdIdaGstRgstNo");
        this.hashFields.put("rd_ida_ste_cd", "rdIdaSteCd");
        this.hashFields.put("rd_ida_ste_nm", "rdIdaSteNm");
        this.hashFields.put("rd_ida_sac_cd", "rdIdaSacCd");
        this.hashFields.put("rd_ida_ofc_ste_cd", "rdIdaOfcSteCd");
        this.hashFields.put("rd_ida_ofc_ste_nm", "rdIdaOfcSteNm");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return rdInvCurrCd
	 */
    public String getRdInvCurrCd() {
        return this.rdInvCurrCd;
    }

    /**
	 * Column Info
	 * @return rdDcAmt
	 */
    public String getRdDcAmt() {
        return this.rdDcAmt;
    }

    /**
	 * Column Info
	 * @return rdBkgRcvTermNm
	 */
    public String getRdBkgRcvTermNm() {
        return this.rdBkgRcvTermNm;
    }

    /**
	 * Column Info
	 * @return rdTaxAmt
	 */
    public String getRdTaxAmt() {
        return this.rdTaxAmt;
    }

    /**
	 * Column Info
	 * @return rdTaxAmtPrnFlg
	 */
    public String getRdTaxAmtPrnFlg() {
        return this.rdTaxAmtPrnFlg;
    }

    /**
	 * Column Info
	 * @return rdPayrAddr
	 */
    public String getRdPayrAddr() {
        return this.rdPayrAddr;
    }

    /**
	 * Column Info
	 * @return rdPhnFaxPrnFlg
	 */
    public String getRdPhnFaxPrnFlg() {
        return this.rdPhnFaxPrnFlg;
    }

    /**
	 * Column Info
	 * @return rdCustNm
	 */
    public String getRdCustNm() {
        return this.rdCustNm;
    }

    /**
	 * Column Info
	 * @return rdPhnNo
	 */
    public String getRdPhnNo() {
        return this.rdPhnNo;
    }

    /**
	 * Column Info
	 * @return rdInvRefNo
	 */
    public String getRdInvRefNo() {
        return this.rdInvRefNo;
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
	 * @return rdShRmk11
	 */
    public String getRdShRmk11() {
        return this.rdShRmk11;
    }

    /**
	 * Column Info
	 * @return rdShRmk10
	 */
    public String getRdShRmk10() {
        return this.rdShRmk10;
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
	 * @return rdShRmk13
	 */
    public String getRdShRmk13() {
        return this.rdShRmk13;
    }

    /**
	 * Column Info
	 * @return rdShRmk12
	 */
    public String getRdShRmk12() {
        return this.rdShRmk12;
    }

    /**
	 * Column Info
	 * @return rdCancelNote
	 */
    public String getRdCancelNote() {
        return this.rdCancelNote;
    }

    /**
	 * Column Info
	 * @return rdCreCntCd
	 */
    public String getRdCreCntCd() {
        return this.rdCreCntCd;
    }

    /**
	 * Column Info
	 * @return rdShRmk14
	 */
    public String getRdShRmk14() {
        return this.rdShRmk14;
    }

    /**
	 * Column Info
	 * @return rdDel
	 */
    public String getRdDel() {
        return this.rdDel;
    }

    /**
	 * Column Info
	 * @return rdPod
	 */
    public String getRdPod() {
        return this.rdPod;
    }

    /**
	 * Column Info
	 * @return rdDep
	 */
    public String getRdDep() {
        return this.rdDep;
    }

    /**
	 * Column Info
	 * @return rdCustRefPrnFlg
	 */
    public String getRdCustRefPrnFlg() {
        return this.rdCustRefPrnFlg;
    }

    /**
	 * Column Info
	 * @return rdCustVatNo
	 */
    public String getRdCustVatNo() {
        return this.rdCustVatNo;
    }

    /**
	 * Column Info
	 * @return rdShRmk4
	 */
    public String getRdShRmk4() {
        return this.rdShRmk4;
    }

    /**
	 * Column Info
	 * @return rdShRmk3
	 */
    public String getRdShRmk3() {
        return this.rdShRmk3;
    }

    /**
	 * Column Info
	 * @return rdShRmk2
	 */
    public String getRdShRmk2() {
        return this.rdShRmk2;
    }

    /**
	 * Column Info
	 * @return rdShHdN3rdMsg
	 */
    public String getRdShHdN3rdMsg() {
        return this.rdShHdN3rdMsg;
    }

    /**
	 * Column Info
	 * @return rdShRmk1
	 */
    public String getRdShRmk1() {
        return this.rdShRmk1;
    }

    /**
	 * Column Info
	 * @return rdShRmk8
	 */
    public String getRdShRmk8() {
        return this.rdShRmk8;
    }

    /**
	 * Column Info
	 * @return rdShRmk7
	 */
    public String getRdShRmk7() {
        return this.rdShRmk7;
    }

    /**
	 * Column Info
	 * @return rdShRmk6
	 */
    public String getRdShRmk6() {
        return this.rdShRmk6;
    }

    /**
	 * Column Info
	 * @return rdShRmk5
	 */
    public String getRdShRmk5() {
        return this.rdShRmk5;
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
	 * @return rdCreUsrNm
	 */
    public String getRdCreUsrNm() {
        return this.rdCreUsrNm;
    }

    /**
	 * Column Info
	 * @return rdBkgDelTermNm
	 */
    public String getRdBkgDelTermNm() {
        return this.rdBkgDelTermNm;
    }

    /**
	 * Column Info
	 * @return rdInvAmt
	 */
    public String getRdInvAmt() {
        return this.rdInvAmt;
    }

    /**
	 * Column Info
	 * @return rdOrgChgAmt
	 */
    public String getRdOrgChgAmt() {
        return this.rdOrgChgAmt;
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
	 * @return rdOrgCurrCd
	 */
    public String getRdOrgCurrCd() {
        return this.rdOrgCurrCd;
    }

    /**
	 * Column Info
	 * @return rdDmdtInvNo
	 */
    public String getRdDmdtInvNo() {
        return this.rdDmdtInvNo;
    }

    /**
	 * Column Info
	 * @return rdCustVatPrnFlg
	 */
    public String getRdCustVatPrnFlg() {
        return this.rdCustVatPrnFlg;
    }

    /**
	 * Column Info
	 * @return rdInvRmk2
	 */
    public String getRdInvRmk2() {
        return this.rdInvRmk2;
    }

    /**
	 * Column Info
	 * @return rdInvRmk1
	 */
    public String getRdInvRmk1() {
        return this.rdInvRmk1;
    }

    /**
	 * Column Info
	 * @return rdShRmk9
	 */
    public String getRdShRmk9() {
        return this.rdShRmk9;
    }

    /**
	 * Column Info
	 * @return rdDaysDisp
	 */
    public String getRdDaysDisp() {
        return this.rdDaysDisp;
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
	 * @return rdDmdtTrfCd
	 */
    public String getRdDmdtTrfCd() {
        return this.rdDmdtTrfCd;
    }

    /**
	 * Column Info
	 * @return rdShHdN2ndMsg
	 */
    public String getRdShHdN2ndMsg() {
        return this.rdShHdN2ndMsg;
    }

    /**
	 * Column Info
	 * @return rdVvdCd
	 */
    public String getRdVvdCd() {
        return this.rdVvdCd;
    }

    /**
	 * Column Info
	 * @return rdCustCd
	 */
    public String getRdCustCd() {
        return this.rdCustCd;
    }

    /**
	 * Column Info
	 * @return rdDueDate
	 */
    public String getRdDueDate() {
        return this.rdDueDate;
    }

    /**
	 * Column Info
	 * @return rdShAddr1
	 */
    public String getRdShAddr1() {
        return this.rdShAddr1;
    }

    /**
	 * Column Info
	 * @return rdShAddr2
	 */
    public String getRdShAddr2() {
        return this.rdShAddr2;
    }

    /**
	 * Column Info
	 * @return rdShAddr3
	 */
    public String getRdShAddr3() {
        return this.rdShAddr3;
    }

    /**
	 * Column Info
	 * @return rdPodNm
	 */
    public String getRdPodNm() {
        return this.rdPodNm;
    }

    /**
	 * Column Info
	 * @return rdBlNo
	 */
    public String getRdBlNo() {
        return this.rdBlNo;
    }

    /**
	 * Column Info
	 * @return rdShHdN4thMsg
	 */
    public String getRdShHdN4thMsg() {
        return this.rdShHdN4thMsg;
    }

    /**
	 * Column Info
	 * @return rdCmdtNm
	 */
    public String getRdCmdtNm() {
        return this.rdCmdtNm;
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
	 * @return rdDelNm
	 */
    public String getRdDelNm() {
        return this.rdDelNm;
    }

    /**
	 * Column Info
	 * @return rdVslEngNm
	 */
    public String getRdVslEngNm() {
        return this.rdVslEngNm;
    }

    /**
	 * Column Info
	 * @return rdShHdN5thMsg
	 */
    public String getRdShHdN5thMsg() {
        return this.rdShHdN5thMsg;
    }

    /**
	 * Column Info
	 * @return rdDueDay
	 */
    public String getRdDueDay() {
        return this.rdDueDay;
    }

    /**
	 * Column Info
	 * @return rdInvoiceTitle
	 */
    public String getRdInvoiceTitle() {
        return this.rdInvoiceTitle;
    }

    /**
	 * Column Info
	 * @return rdBkgNo
	 */
    public String getRdBkgNo() {
        return this.rdBkgNo;
    }

    /**
	 * Column Info
	 * @return rdNtcKntCd
	 */
    public String getRdNtcKntCd() {
        return this.rdNtcKntCd;
    }

    /**
	 * Column Info
	 * @return rdShHdN1stMsg
	 */
    public String getRdShHdN1stMsg() {
        return this.rdShHdN1stMsg;
    }

    /**
	 * Column Info
	 * @return rdTotAmt
	 */
    public String getRdTotAmt() {
        return this.rdTotAmt;
    }

    /**
	 * Column Info
	 * @return rdDcAmtFlg
	 */
    public String getRdDcAmtFlg() {
        return this.rdDcAmtFlg;
    }

    /**
	 * Column Info
	 * @return rdFaxNo
	 */
    public String getRdFaxNo() {
        return this.rdFaxNo;
    }

    /**
	 * Column Info
	 * @return rdArr
	 */
    public String getRdArr() {
        return this.rdArr;
    }

    /**
	 * Column Info
	 * @return rdTaxRto
	 */
    public String getRdTaxRto() {
        return this.rdTaxRto;
    }

    /**
	 * Column Info
	 * @return rdInvChgAmt
	 */
    public String getRdInvChgAmt() {
        return this.rdInvChgAmt;
    }

    /**
	 * Column Info
	 * @return rdIssueDay
	 */
    public String getRdIssueDay() {
        return this.rdIssueDay;
    }

    /**
	 * Column Info
	 * @return rdDmdtTrfNm
	 */
    public String getRdDmdtTrfNm() {
        return this.rdDmdtTrfNm;
    }

    /**
	 * Column Info
	 * @return rdAttnNm
	 */
    public String getRdAttnNm() {
        return this.rdAttnNm;
    }

    /**
	 * Column Info
	 * @return rdInvXchRt
	 */
    public String getRdInvXchRt() {
        return this.rdInvXchRt;
    }

    /**
	 * Column Info
	 * @return rdTruckerNm
	 */
    public String getRdTruckerNm() {
        return this.rdTruckerNm;
    }

    /**
	 * Column Info
	 * @return rdDmdtInvStsCd
	 */
    public String getRdDmdtInvStsCd() {
        return this.rdDmdtInvStsCd;
    }

    /**
	 * Column Info
	 * @return rdIdaExpnTaxRt
	 */
    public String getRdIdaExpnTaxRt() {
        return this.rdIdaExpnTaxRt;
    }

    /**
	 * Column Info
	 * @return rdIdaExpnTax
	 */
    public String getRdIdaExpnTax() {
        return this.rdIdaExpnTax;
    }

    /**
	 * Column Info
	 * @return rdIdaEduTaxRt
	 */
    public String getRdIdaEduTaxRt() {
        return this.rdIdaEduTaxRt;
    }

    /**
	 * Column Info
	 * @return rdIdaEduTax
	 */
    public String getRdIdaEduTax() {
        return this.rdIdaEduTax;
    }

    /**
	 * Column Info
	 * @return rdIdaHighEduTaxRt
	 */
    public String getRdIdaHighEduTaxRt() {
        return this.rdIdaHighEduTaxRt;
    }

    /**
	 * Column Info
	 * @return rdIdaHighEduTax
	 */
    public String getRdIdaHighEduTax() {
        return this.rdIdaHighEduTax;
    }

    public String getRdSvcCateRmk() {
        return rdSvcCateRmk;
    }

    public void setRdSvcCateRmk(String rdSvcCateRmk) {
        this.rdSvcCateRmk = rdSvcCateRmk;
    }

    public String getRdPmntAcctNo() {
        return rdPmntAcctNo;
    }

    public void setRdPmntAcctNo(String rdPmntAcctNo) {
        this.rdPmntAcctNo = rdPmntAcctNo;
    }

    public String getRdTaxRgstNo() {
        return rdTaxRgstNo;
    }

    public void setRdTaxRgstNo(String rdTaxRgstNo) {
        this.rdTaxRgstNo = rdTaxRgstNo;
    }

    /**
	 * Column Info
	 * @param rdInvCurrCd
	 */
    public void setRdInvCurrCd(String rdInvCurrCd) {
        this.rdInvCurrCd = rdInvCurrCd;
    }

    /**
	 * Column Info
	 * @param rdDcAmt
	 */
    public void setRdDcAmt(String rdDcAmt) {
        this.rdDcAmt = rdDcAmt;
    }

    /**
	 * Column Info
	 * @param rdBkgRcvTermNm
	 */
    public void setRdBkgRcvTermNm(String rdBkgRcvTermNm) {
        this.rdBkgRcvTermNm = rdBkgRcvTermNm;
    }

    /**
	 * Column Info
	 * @param rdTaxAmt
	 */
    public void setRdTaxAmt(String rdTaxAmt) {
        this.rdTaxAmt = rdTaxAmt;
    }

    /**
	 * Column Info
	 * @param rdTaxAmtPrnFlg
	 */
    public void setRdTaxAmtPrnFlg(String rdTaxAmtPrnFlg) {
        this.rdTaxAmtPrnFlg = rdTaxAmtPrnFlg;
    }

    /**
	 * Column Info
	 * @param rdPayrAddr
	 */
    public void setRdPayrAddr(String rdPayrAddr) {
        this.rdPayrAddr = rdPayrAddr;
    }

    /**
	 * Column Info
	 * @param rdPhnFaxPrnFlg
	 */
    public void setRdPhnFaxPrnFlg(String rdPhnFaxPrnFlg) {
        this.rdPhnFaxPrnFlg = rdPhnFaxPrnFlg;
    }

    /**
	 * Column Info
	 * @param rdCustNm
	 */
    public void setRdCustNm(String rdCustNm) {
        this.rdCustNm = rdCustNm;
    }

    /**
	 * Column Info
	 * @param rdPhnNo
	 */
    public void setRdPhnNo(String rdPhnNo) {
        this.rdPhnNo = rdPhnNo;
    }

    /**
	 * Column Info
	 * @param rdInvRefNo
	 */
    public void setRdInvRefNo(String rdInvRefNo) {
        this.rdInvRefNo = rdInvRefNo;
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
	 * @param rdShRmk11
	 */
    public void setRdShRmk11(String rdShRmk11) {
        this.rdShRmk11 = rdShRmk11;
    }

    /**
	 * Column Info
	 * @param rdShRmk10
	 */
    public void setRdShRmk10(String rdShRmk10) {
        this.rdShRmk10 = rdShRmk10;
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
	 * @param rdShRmk13
	 */
    public void setRdShRmk13(String rdShRmk13) {
        this.rdShRmk13 = rdShRmk13;
    }

    /**
	 * Column Info
	 * @param rdShRmk12
	 */
    public void setRdShRmk12(String rdShRmk12) {
        this.rdShRmk12 = rdShRmk12;
    }

    /**
	 * Column Info
	 * @param rdCancelNote
	 */
    public void setRdCancelNote(String rdCancelNote) {
        this.rdCancelNote = rdCancelNote;
    }

    /**
	 * Column Info
	 * @param rdCreCntCd
	 */
    public void setRdCreCntCd(String rdCreCntCd) {
        this.rdCreCntCd = rdCreCntCd;
    }

    /**
	 * Column Info
	 * @param rdShRmk14
	 */
    public void setRdShRmk14(String rdShRmk14) {
        this.rdShRmk14 = rdShRmk14;
    }

    /**
	 * Column Info
	 * @param rdDel
	 */
    public void setRdDel(String rdDel) {
        this.rdDel = rdDel;
    }

    /**
	 * Column Info
	 * @param rdPod
	 */
    public void setRdPod(String rdPod) {
        this.rdPod = rdPod;
    }

    /**
	 * Column Info
	 * @param rdDep
	 */
    public void setRdDep(String rdDep) {
        this.rdDep = rdDep;
    }

    /**
	 * Column Info
	 * @param rdCustRefPrnFlg
	 */
    public void setRdCustRefPrnFlg(String rdCustRefPrnFlg) {
        this.rdCustRefPrnFlg = rdCustRefPrnFlg;
    }

    /**
	 * Column Info
	 * @param rdCustVatNo
	 */
    public void setRdCustVatNo(String rdCustVatNo) {
        this.rdCustVatNo = rdCustVatNo;
    }

    /**
	 * Column Info
	 * @param rdShRmk4
	 */
    public void setRdShRmk4(String rdShRmk4) {
        this.rdShRmk4 = rdShRmk4;
    }

    /**
	 * Column Info
	 * @param rdShRmk3
	 */
    public void setRdShRmk3(String rdShRmk3) {
        this.rdShRmk3 = rdShRmk3;
    }

    /**
	 * Column Info
	 * @param rdShRmk2
	 */
    public void setRdShRmk2(String rdShRmk2) {
        this.rdShRmk2 = rdShRmk2;
    }

    /**
	 * Column Info
	 * @param rdShHdN3rdMsg
	 */
    public void setRdShHdN3rdMsg(String rdShHdN3rdMsg) {
        this.rdShHdN3rdMsg = rdShHdN3rdMsg;
    }

    /**
	 * Column Info
	 * @param rdShRmk1
	 */
    public void setRdShRmk1(String rdShRmk1) {
        this.rdShRmk1 = rdShRmk1;
    }

    /**
	 * Column Info
	 * @param rdShRmk8
	 */
    public void setRdShRmk8(String rdShRmk8) {
        this.rdShRmk8 = rdShRmk8;
    }

    /**
	 * Column Info
	 * @param rdShRmk7
	 */
    public void setRdShRmk7(String rdShRmk7) {
        this.rdShRmk7 = rdShRmk7;
    }

    /**
	 * Column Info
	 * @param rdShRmk6
	 */
    public void setRdShRmk6(String rdShRmk6) {
        this.rdShRmk6 = rdShRmk6;
    }

    /**
	 * Column Info
	 * @param rdShRmk5
	 */
    public void setRdShRmk5(String rdShRmk5) {
        this.rdShRmk5 = rdShRmk5;
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
	 * @param rdCreUsrNm
	 */
    public void setRdCreUsrNm(String rdCreUsrNm) {
        this.rdCreUsrNm = rdCreUsrNm;
    }

    /**
	 * Column Info
	 * @param rdBkgDelTermNm
	 */
    public void setRdBkgDelTermNm(String rdBkgDelTermNm) {
        this.rdBkgDelTermNm = rdBkgDelTermNm;
    }

    /**
	 * Column Info
	 * @param rdInvAmt
	 */
    public void setRdInvAmt(String rdInvAmt) {
        this.rdInvAmt = rdInvAmt;
    }

    /**
	 * Column Info
	 * @param rdOrgChgAmt
	 */
    public void setRdOrgChgAmt(String rdOrgChgAmt) {
        this.rdOrgChgAmt = rdOrgChgAmt;
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
	 * @param rdOrgCurrCd
	 */
    public void setRdOrgCurrCd(String rdOrgCurrCd) {
        this.rdOrgCurrCd = rdOrgCurrCd;
    }

    /**
	 * Column Info
	 * @param rdDmdtInvNo
	 */
    public void setRdDmdtInvNo(String rdDmdtInvNo) {
        this.rdDmdtInvNo = rdDmdtInvNo;
    }

    /**
	 * Column Info
	 * @param rdCustVatPrnFlg
	 */
    public void setRdCustVatPrnFlg(String rdCustVatPrnFlg) {
        this.rdCustVatPrnFlg = rdCustVatPrnFlg;
    }

    /**
	 * Column Info
	 * @param rdInvRmk2
	 */
    public void setRdInvRmk2(String rdInvRmk2) {
        this.rdInvRmk2 = rdInvRmk2;
    }

    /**
	 * Column Info
	 * @param rdInvRmk1
	 */
    public void setRdInvRmk1(String rdInvRmk1) {
        this.rdInvRmk1 = rdInvRmk1;
    }

    /**
	 * Column Info
	 * @param rdShRmk9
	 */
    public void setRdShRmk9(String rdShRmk9) {
        this.rdShRmk9 = rdShRmk9;
    }

    /**
	 * Column Info
	 * @param rdDaysDisp
	 */
    public void setRdDaysDisp(String rdDaysDisp) {
        this.rdDaysDisp = rdDaysDisp;
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
	 * @param rdDmdtTrfCd
	 */
    public void setRdDmdtTrfCd(String rdDmdtTrfCd) {
        this.rdDmdtTrfCd = rdDmdtTrfCd;
    }

    /**
	 * Column Info
	 * @param rdShHdN2ndMsg
	 */
    public void setRdShHdN2ndMsg(String rdShHdN2ndMsg) {
        this.rdShHdN2ndMsg = rdShHdN2ndMsg;
    }

    /**
	 * Column Info
	 * @param rdVvdCd
	 */
    public void setRdVvdCd(String rdVvdCd) {
        this.rdVvdCd = rdVvdCd;
    }

    /**
	 * Column Info
	 * @param rdCustCd
	 */
    public void setRdCustCd(String rdCustCd) {
        this.rdCustCd = rdCustCd;
    }

    /**
	 * Column Info
	 * @param rdDueDate
	 */
    public void setRdDueDate(String rdDueDate) {
        this.rdDueDate = rdDueDate;
    }

    /**
	 * Column Info
	 * @param rdShAddr1
	 */
    public void setRdShAddr1(String rdShAddr1) {
        this.rdShAddr1 = rdShAddr1;
    }

    /**
	 * Column Info
	 * @param rdShAddr2
	 */
    public void setRdShAddr2(String rdShAddr2) {
        this.rdShAddr2 = rdShAddr2;
    }

    /**
	 * Column Info
	 * @param rdShAddr3
	 */
    public void setRdShAddr3(String rdShAddr3) {
        this.rdShAddr3 = rdShAddr3;
    }

    /**
	 * Column Info
	 * @param rdPodNm
	 */
    public void setRdPodNm(String rdPodNm) {
        this.rdPodNm = rdPodNm;
    }

    /**
	 * Column Info
	 * @param rdBlNo
	 */
    public void setRdBlNo(String rdBlNo) {
        this.rdBlNo = rdBlNo;
    }

    /**
	 * Column Info
	 * @param rdShHdN4thMsg
	 */
    public void setRdShHdN4thMsg(String rdShHdN4thMsg) {
        this.rdShHdN4thMsg = rdShHdN4thMsg;
    }

    /**
	 * Column Info
	 * @param rdCmdtNm
	 */
    public void setRdCmdtNm(String rdCmdtNm) {
        this.rdCmdtNm = rdCmdtNm;
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
	 * @param rdDelNm
	 */
    public void setRdDelNm(String rdDelNm) {
        this.rdDelNm = rdDelNm;
    }

    /**
	 * Column Info
	 * @param rdVslEngNm
	 */
    public void setRdVslEngNm(String rdVslEngNm) {
        this.rdVslEngNm = rdVslEngNm;
    }

    /**
	 * Column Info
	 * @param rdShHdN5thMsg
	 */
    public void setRdShHdN5thMsg(String rdShHdN5thMsg) {
        this.rdShHdN5thMsg = rdShHdN5thMsg;
    }

    /**
	 * Column Info
	 * @param rdDueDay
	 */
    public void setRdDueDay(String rdDueDay) {
        this.rdDueDay = rdDueDay;
    }

    /**
	 * Column Info
	 * @param rdInvoiceTitle
	 */
    public void setRdInvoiceTitle(String rdInvoiceTitle) {
        this.rdInvoiceTitle = rdInvoiceTitle;
    }

    /**
	 * Column Info
	 * @param rdBkgNo
	 */
    public void setRdBkgNo(String rdBkgNo) {
        this.rdBkgNo = rdBkgNo;
    }

    /**
	 * Column Info
	 * @param rdNtcKntCd
	 */
    public void setRdNtcKntCd(String rdNtcKntCd) {
        this.rdNtcKntCd = rdNtcKntCd;
    }

    /**
	 * Column Info
	 * @param rdShHdN1stMsg
	 */
    public void setRdShHdN1stMsg(String rdShHdN1stMsg) {
        this.rdShHdN1stMsg = rdShHdN1stMsg;
    }

    /**
	 * Column Info
	 * @param rdTotAmt
	 */
    public void setRdTotAmt(String rdTotAmt) {
        this.rdTotAmt = rdTotAmt;
    }

    /**
	 * Column Info
	 * @param rdDcAmtFlg
	 */
    public void setRdDcAmtFlg(String rdDcAmtFlg) {
        this.rdDcAmtFlg = rdDcAmtFlg;
    }

    /**
	 * Column Info
	 * @param rdFaxNo
	 */
    public void setRdFaxNo(String rdFaxNo) {
        this.rdFaxNo = rdFaxNo;
    }

    /**
	 * Column Info
	 * @param rdArr
	 */
    public void setRdArr(String rdArr) {
        this.rdArr = rdArr;
    }

    /**
	 * Column Info
	 * @param rdTaxRto
	 */
    public void setRdTaxRto(String rdTaxRto) {
        this.rdTaxRto = rdTaxRto;
    }

    /**
	 * Column Info
	 * @param rdInvChgAmt
	 */
    public void setRdInvChgAmt(String rdInvChgAmt) {
        this.rdInvChgAmt = rdInvChgAmt;
    }

    /**
	 * Column Info
	 * @param rdIssueDay
	 */
    public void setRdIssueDay(String rdIssueDay) {
        this.rdIssueDay = rdIssueDay;
    }

    /**
	 * Column Info
	 * @param rdDmdtTrfNm
	 */
    public void setRdDmdtTrfNm(String rdDmdtTrfNm) {
        this.rdDmdtTrfNm = rdDmdtTrfNm;
    }

    /**
	 * Column Info
	 * @param rdAttnNm
	 */
    public void setRdAttnNm(String rdAttnNm) {
        this.rdAttnNm = rdAttnNm;
    }

    /**
	 * Column Info
	 * @param rdInvXchRt
	 */
    public void setRdInvXchRt(String rdInvXchRt) {
        this.rdInvXchRt = rdInvXchRt;
    }

    /**
	 * Column Info
	 * @param rdTruckerNm
	 */
    public void setRdTruckerNm(String rdTruckerNm) {
        this.rdTruckerNm = rdTruckerNm;
    }

    /**
	 * Column Info
	 * @param rdDmdtInvStsCd
	 */
    public void setRdDmdtInvStsCd(String rdDmdtInvStsCd) {
        this.rdDmdtInvStsCd = rdDmdtInvStsCd;
    }

    public void setRdIdaExpnTaxRt(String rdIdaExpnTaxRt) {
        this.rdIdaExpnTaxRt = rdIdaExpnTaxRt;
    }

    public void setRdIdaExpnTax(String rdIdaExpnTax) {
        this.rdIdaExpnTax = rdIdaExpnTax;
    }

    public void setRdIdaEduTaxRt(String rdIdaEduTaxRt) {
        this.rdIdaEduTaxRt = rdIdaEduTaxRt;
    }

    public void setRdIdaEduTax(String rdIdaEduTax) {
        this.rdIdaEduTax = rdIdaEduTax;
    }

    public void setRdIdaHighEduTaxRt(String rdIdaHighEduTaxRt) {
        this.rdIdaHighEduTaxRt = rdIdaHighEduTaxRt;
    }

    public void setRdIdaHighEduTax(String rdIdaHighEduTax) {
        this.rdIdaHighEduTax = rdIdaHighEduTax;
    }

    public String getRdIdaLoclTaxRt() {
        return rdIdaLoclTaxRt;
    }

    public void setRdIdaLoclTaxRt(String rdIdaLoclTaxRt) {
        this.rdIdaLoclTaxRt = rdIdaLoclTaxRt;
    }

    public String getRdIdaLoclTax() {
        return rdIdaLoclTax;
    }

    public void setRdIdaLoclTax(String rdIdaLoclTax) {
        this.rdIdaLoclTax = rdIdaLoclTax;
    }

    public String getRdIdaN2ndLoclTaxRt() {
        return rdIdaN2ndLoclTaxRt;
    }

    public void setRdIdaN2ndLoclTaxRt(String rdIdaN2ndLoclTaxRt) {
        this.rdIdaN2ndLoclTaxRt = rdIdaN2ndLoclTaxRt;
    }

    public String getRdIdaN2ndLoclTax() {
        return rdIdaN2ndLoclTax;
    }

    public void setRdIdaN2ndLoclTax(String rdIdaN2ndLoclTax) {
        this.rdIdaN2ndLoclTax = rdIdaN2ndLoclTax;
    }

    public void setRdIdaTaxApplTm(String rdIdaTaxApplTm) {
        this.rdIdaTaxApplTm = rdIdaTaxApplTm;
    }

    public String getRdIdaTaxApplTm() {
        return this.rdIdaTaxApplTm;
    }

    public void setRdIdaCgstRto(String rdIdaCgstRto) {
        this.rdIdaCgstRto = rdIdaCgstRto;
    }

    public String getRdIdaCgstRto() {
        return this.rdIdaCgstRto;
    }

    public void setRdIdaCgstAmt(String rdIdaCgstAmt) {
        this.rdIdaCgstAmt = rdIdaCgstAmt;
    }

    public String getRdIdaCgstAmt() {
        return this.rdIdaCgstAmt;
    }

    public void setRdIdaSgstRto(String rdIdaSgstRto) {
        this.rdIdaSgstRto = rdIdaSgstRto;
    }

    public String getRdIdaSgstRto() {
        return this.rdIdaSgstRto;
    }

    public void setRdIdaSgstAmt(String rdIdaSgstAmt) {
        this.rdIdaSgstAmt = rdIdaSgstAmt;
    }

    public String getRdIdaSgstAmt() {
        return this.rdIdaSgstAmt;
    }

    public void setRdIdaIgstRto(String rdIdaIgstRto) {
        this.rdIdaIgstRto = rdIdaIgstRto;
    }

    public String getRdIdaIgstRto() {
        return this.rdIdaIgstRto;
    }

    public void setRdIdaIgstAmt(String rdIdaIgstAmt) {
        this.rdIdaIgstAmt = rdIdaIgstAmt;
    }

    public String getRdIdaIgstAmt() {
        return this.rdIdaIgstAmt;
    }

    public void setRdIdaUgstRto(String rdIdaUgstRto) {
        this.rdIdaUgstRto = rdIdaUgstRto;
    }

    public String getRdIdaUgstRto() {
        return this.rdIdaUgstRto;
    }

    public void setRdIdaUgstAmt(String rdIdaUgstAmt) {
        this.rdIdaUgstAmt = rdIdaUgstAmt;
    }

    public String getRdIdaUgstAmt() {
        return this.rdIdaUgstAmt;
    }

    public void setRdIdaBankAcctNo(String rdIdaBankAcctNo) {
        this.rdIdaBankAcctNo = rdIdaBankAcctNo;
    }

    public String getRdIdaBankAcctNo() {
        return this.rdIdaBankAcctNo;
    }

    public void setRdIdaBankIfscCd(String rdIdaBankIfscCd) {
        this.rdIdaBankIfscCd = rdIdaBankIfscCd;
    }

    public String getRdIdaBankIfscCd() {
        return this.rdIdaBankIfscCd;
    }

    public void setRdIdaTaxCin(String rdIdaTaxCin) {
        this.rdIdaTaxCin = rdIdaTaxCin;
    }

    public String getRdIdaTaxCin() {
        return this.rdIdaTaxCin;
    }

    public void setRdIdaGstRgstNo(String rdIdaGstRgstNo) {
        this.rdIdaGstRgstNo = rdIdaGstRgstNo;
    }

    public String getRdIdaGstRgstNo() {
        return this.rdIdaGstRgstNo;
    }

    public void setRdIdaSteCd(String rdIdaSteCd) {
        this.rdIdaSteCd = rdIdaSteCd;
    }

    public String getRdIdaSteCd() {
        return this.rdIdaSteCd;
    }
    
    public void setRdIdaSteNm(String rdIdaSteNm) {
        this.rdIdaSteNm = rdIdaSteNm;
    }

    public String getRdIdaSteNm() {
        return this.rdIdaSteNm;
    }    

    public void setRdIdaSacCd(String rdIdaSacCd) {
        this.rdIdaSacCd = rdIdaSacCd;
    }

    public String getRdIdaSacCd() {
        return this.rdIdaSacCd;
    }

    public void setRdIdaOfcSteCd(String rdIdaOfcSteCd) {
        this.rdIdaOfcSteCd = rdIdaOfcSteCd;
    }

    public String getRdIdaOfcSteCd() {
        return this.rdIdaOfcSteCd;
    }

    public void setRdIdaOfcSteNm(String rdIdaOfcSteNm) {
        this.rdIdaOfcSteNm = rdIdaOfcSteNm;
    }

    public String getRdIdaOfcSteNm() {
        return this.rdIdaOfcSteNm;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setRdInvCurrCd(JSPUtil.getParameter(request, "rd_inv_curr_cd", ""));
        setRdDcAmt(JSPUtil.getParameter(request, "rd_dc_amt", ""));
        setRdBkgRcvTermNm(JSPUtil.getParameter(request, "rd_bkg_rcv_term_nm", ""));
        setRdTaxAmt(JSPUtil.getParameter(request, "rd_tax_amt", ""));
        setRdTaxAmtPrnFlg(JSPUtil.getParameter(request, "rd_tax_amt_prn_flg", ""));
        setRdPayrAddr(JSPUtil.getParameter(request, "rd_payr_addr", ""));
        setRdPhnFaxPrnFlg(JSPUtil.getParameter(request, "rd_phn_fax_prn_flg", ""));
        setRdCustNm(JSPUtil.getParameter(request, "rd_cust_nm", ""));
        setRdPhnNo(JSPUtil.getParameter(request, "rd_phn_no", ""));
        setRdInvRefNo(JSPUtil.getParameter(request, "rd_inv_ref_no", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setRdShRmk11(JSPUtil.getParameter(request, "rd_sh_rmk11", ""));
        setRdShRmk10(JSPUtil.getParameter(request, "rd_sh_rmk10", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
        setRdShRmk13(JSPUtil.getParameter(request, "rd_sh_rmk13", ""));
        setRdShRmk12(JSPUtil.getParameter(request, "rd_sh_rmk12", ""));
        setRdCancelNote(JSPUtil.getParameter(request, "rd_cancel_note", ""));
        setRdCreCntCd(JSPUtil.getParameter(request, "rd_cre_cnt_cd", ""));
        setRdShRmk14(JSPUtil.getParameter(request, "rd_sh_rmk14", ""));
        setRdDel(JSPUtil.getParameter(request, "rd_del", ""));
        setRdPod(JSPUtil.getParameter(request, "rd_pod", ""));
        setRdDep(JSPUtil.getParameter(request, "rd_dep", ""));
        setRdCustRefPrnFlg(JSPUtil.getParameter(request, "rd_cust_ref_prn_flg", ""));
        setRdCustVatNo(JSPUtil.getParameter(request, "rd_cust_vat_no", ""));
        setRdShRmk4(JSPUtil.getParameter(request, "rd_sh_rmk4", ""));
        setRdShRmk3(JSPUtil.getParameter(request, "rd_sh_rmk3", ""));
        setRdShRmk2(JSPUtil.getParameter(request, "rd_sh_rmk2", ""));
        setRdShHdN3rdMsg(JSPUtil.getParameter(request, "rd_sh_hd_n3rd_msg", ""));
        setRdShRmk1(JSPUtil.getParameter(request, "rd_sh_rmk1", ""));
        setRdShRmk8(JSPUtil.getParameter(request, "rd_sh_rmk8", ""));
        setRdShRmk7(JSPUtil.getParameter(request, "rd_sh_rmk7", ""));
        setRdShRmk6(JSPUtil.getParameter(request, "rd_sh_rmk6", ""));
        setRdShRmk5(JSPUtil.getParameter(request, "rd_sh_rmk5", ""));
        setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
        setRdCreUsrNm(JSPUtil.getParameter(request, "rd_cre_usr_nm", ""));
        setRdBkgDelTermNm(JSPUtil.getParameter(request, "rd_bkg_del_term_nm", ""));
        setRdInvAmt(JSPUtil.getParameter(request, "rd_inv_amt", ""));
        setRdOrgChgAmt(JSPUtil.getParameter(request, "rd_org_chg_amt", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setRdOrgCurrCd(JSPUtil.getParameter(request, "rd_org_curr_cd", ""));
        setRdDmdtInvNo(JSPUtil.getParameter(request, "rd_dmdt_inv_no", ""));
        setRdCustVatPrnFlg(JSPUtil.getParameter(request, "rd_cust_vat_prn_flg", ""));
        setRdInvRmk2(JSPUtil.getParameter(request, "rd_inv_rmk2", ""));
        setRdInvRmk1(JSPUtil.getParameter(request, "rd_inv_rmk1", ""));
        setRdShRmk9(JSPUtil.getParameter(request, "rd_sh_rmk9", ""));
        setRdDaysDisp(JSPUtil.getParameter(request, "rd_days_disp", ""));
        setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
        setRdDmdtTrfCd(JSPUtil.getParameter(request, "rd_dmdt_trf_cd", ""));
        setRdShHdN2ndMsg(JSPUtil.getParameter(request, "rd_sh_hd_n2nd_msg", ""));
        setRdVvdCd(JSPUtil.getParameter(request, "rd_vvd_cd", ""));
        setRdCustCd(JSPUtil.getParameter(request, "rd_cust_cd", ""));
        setRdDueDate(JSPUtil.getParameter(request, "rd_due_date", ""));
        setRdShAddr1(JSPUtil.getParameter(request, "rd_sh_addr1", ""));
        setRdShAddr2(JSPUtil.getParameter(request, "rd_sh_addr2", ""));
        setRdShAddr3(JSPUtil.getParameter(request, "rd_sh_addr3", ""));
        setRdPodNm(JSPUtil.getParameter(request, "rd_pod_nm", ""));
        setRdBlNo(JSPUtil.getParameter(request, "rd_bl_no", ""));
        setRdShHdN4thMsg(JSPUtil.getParameter(request, "rd_sh_hd_n4th_msg", ""));
        setRdCmdtNm(JSPUtil.getParameter(request, "rd_cmdt_nm", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setRdDelNm(JSPUtil.getParameter(request, "rd_del_nm", ""));
        setRdVslEngNm(JSPUtil.getParameter(request, "rd_vsl_eng_nm", ""));
        setRdShHdN5thMsg(JSPUtil.getParameter(request, "rd_sh_hd_n5th_msg", ""));
        setRdDueDay(JSPUtil.getParameter(request, "rd_due_day", ""));
        setRdInvoiceTitle(JSPUtil.getParameter(request, "rd_invoice_title", ""));
        setRdBkgNo(JSPUtil.getParameter(request, "rd_bkg_no", ""));
        setRdNtcKntCd(JSPUtil.getParameter(request, "rd_ntc_knt_cd", ""));
        setRdShHdN1stMsg(JSPUtil.getParameter(request, "rd_sh_hd_n1st_msg", ""));
        setRdTotAmt(JSPUtil.getParameter(request, "rd_tot_amt", ""));
        setRdDcAmtFlg(JSPUtil.getParameter(request, "rd_dc_amt_flg", ""));
        setRdFaxNo(JSPUtil.getParameter(request, "rd_fax_no", ""));
        setRdArr(JSPUtil.getParameter(request, "rd_arr", ""));
        setRdTaxRto(JSPUtil.getParameter(request, "rd_tax_rto", ""));
        setRdInvChgAmt(JSPUtil.getParameter(request, "rd_inv_chg_amt", ""));
        setRdIssueDay(JSPUtil.getParameter(request, "rd_issue_day", ""));
        setRdDmdtTrfNm(JSPUtil.getParameter(request, "rd_dmdt_trf_nm", ""));
        setRdAttnNm(JSPUtil.getParameter(request, "rd_attn_nm", ""));
        setRdInvXchRt(JSPUtil.getParameter(request, "rd_inv_xch_rt", ""));
        setRdTruckerNm(JSPUtil.getParameter(request, "rd_trucker_nm", ""));
        setRdDmdtInvStsCd(JSPUtil.getParameter(request, "rd_dmdt_inv_sts_cd", ""));
        setRdIdaExpnTaxRt(JSPUtil.getParameter(request, "rd_ida_expn_tax_rt", ""));
        setRdIdaExpnTax(JSPUtil.getParameter(request, "rd_ida_expn_tax", ""));
        setRdIdaEduTaxRt(JSPUtil.getParameter(request, "rd_ida_edu_tax_rt", ""));
        setRdIdaEduTax(JSPUtil.getParameter(request, "rd_ida_edu_tax", ""));
        setRdIdaHighEduTaxRt(JSPUtil.getParameter(request, "rd_ida_high_edu_tax_rt", ""));
        setRdIdaHighEduTax(JSPUtil.getParameter(request, "rd_ida_high_edu_tax", ""));
        setRdSvcCateRmk(JSPUtil.getParameter(request, "rd_svc_cate_rmk", ""));
        setRdPmntAcctNo(JSPUtil.getParameter(request, "rd_pmnt_acct_no", ""));
        setRdTaxRgstNo(JSPUtil.getParameter(request, "rd_tax_rgst_no", ""));
        setRdIdaLoclTaxRt(JSPUtil.getParameter(request, "rd_ida_locl_tax_rt", ""));
        setRdIdaLoclTax(JSPUtil.getParameter(request, "rd_ida_locl_tax", ""));
        setRdIdaN2ndLoclTaxRt(JSPUtil.getParameter(request, "rd_ida_n2nd_locl_tax_rt", ""));
        setRdIdaN2ndLoclTax(JSPUtil.getParameter(request, "rd_ida_n2nd_locl_tax", ""));
        setRdIdaTaxApplTm(JSPUtil.getParameter(request, "rd_ida_tax_appl_tm", ""));
        setRdIdaCgstRto(JSPUtil.getParameter(request, "rd_ida_cgst_rto", ""));
        setRdIdaCgstAmt(JSPUtil.getParameter(request, "rd_ida_cgst_amt", ""));
        setRdIdaSgstRto(JSPUtil.getParameter(request, "rd_ida_sgst_rto", ""));
        setRdIdaSgstAmt(JSPUtil.getParameter(request, "rd_ida_sgst_amt", ""));
        setRdIdaIgstRto(JSPUtil.getParameter(request, "rd_ida_igst_rto", ""));
        setRdIdaIgstAmt(JSPUtil.getParameter(request, "rd_ida_igst_amt", ""));
        setRdIdaUgstRto(JSPUtil.getParameter(request, "rd_ida_ugst_rto", ""));
        setRdIdaUgstAmt(JSPUtil.getParameter(request, "rd_ida_ugst_amt", ""));
        setRdIdaTaxCin(JSPUtil.getParameter(request, "rd_ida_tax_cin", ""));
        setRdIdaGstRgstNo(JSPUtil.getParameter(request, "rd_ida_gst_rgst_no", ""));
        setRdIdaSteCd(JSPUtil.getParameter(request, "rd_ida_ste_cd", ""));
        setRdIdaSteNm(JSPUtil.getParameter(request, "rd_ida_ste_nm", ""));
        setRdIdaSacCd(JSPUtil.getParameter(request, "rd_ida_sac_cd", ""));
        setRdIdaOfcSteCd(JSPUtil.getParameter(request, "rd_ida_ofc_ste_cd", ""));
        setRdIdaOfcSteNm(JSPUtil.getParameter(request, "rd_ida_ofc_ste_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueMasterPreviewVO[]
	 */
    public InvoiceIssueMasterPreviewVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueMasterPreviewVO[]
	 */
    public InvoiceIssueMasterPreviewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        InvoiceIssueMasterPreviewVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] rdInvCurrCd = (JSPUtil.getParameter(request, prefix + "rd_inv_curr_cd", length));
            String[] rdDcAmt = (JSPUtil.getParameter(request, prefix + "rd_dc_amt", length));
            String[] rdBkgRcvTermNm = (JSPUtil.getParameter(request, prefix + "rd_bkg_rcv_term_nm", length));
            String[] rdTaxAmt = (JSPUtil.getParameter(request, prefix + "rd_tax_amt", length));
            String[] rdTaxAmtPrnFlg = (JSPUtil.getParameter(request, prefix + "rd_tax_amt_prn_flg", length));
            String[] rdPayrAddr = (JSPUtil.getParameter(request, prefix + "rd_payr_addr", length));
            String[] rdPhnFaxPrnFlg = (JSPUtil.getParameter(request, prefix + "rd_phn_fax_prn_flg", length));
            String[] rdCustNm = (JSPUtil.getParameter(request, prefix + "rd_cust_nm", length));
            String[] rdPhnNo = (JSPUtil.getParameter(request, prefix + "rd_phn_no", length));
            String[] rdInvRefNo = (JSPUtil.getParameter(request, prefix + "rd_inv_ref_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] rdShRmk11 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk11", length));
            String[] rdShRmk10 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk10", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] rdShRmk13 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk13", length));
            String[] rdShRmk12 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk12", length));
            String[] rdCancelNote = (JSPUtil.getParameter(request, prefix + "rd_cancel_note", length));
            String[] rdCreCntCd = (JSPUtil.getParameter(request, prefix + "rd_cre_cnt_cd", length));
            String[] rdShRmk14 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk14", length));
            String[] rdDel = (JSPUtil.getParameter(request, prefix + "rd_del", length));
            String[] rdPod = (JSPUtil.getParameter(request, prefix + "rd_pod", length));
            String[] rdDep = (JSPUtil.getParameter(request, prefix + "rd_dep", length));
            String[] rdCustRefPrnFlg = (JSPUtil.getParameter(request, prefix + "rd_cust_ref_prn_flg", length));
            String[] rdCustVatNo = (JSPUtil.getParameter(request, prefix + "rd_cust_vat_no", length));
            String[] rdShRmk4 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk4", length));
            String[] rdShRmk3 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk3", length));
            String[] rdShRmk2 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk2", length));
            String[] rdShHdN3rdMsg = (JSPUtil.getParameter(request, prefix + "rd_sh_hd_n3rd_msg", length));
            String[] rdShRmk1 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk1", length));
            String[] rdShRmk8 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk8", length));
            String[] rdShRmk7 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk7", length));
            String[] rdShRmk6 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk6", length));
            String[] rdShRmk5 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk5", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] rdCreUsrNm = (JSPUtil.getParameter(request, prefix + "rd_cre_usr_nm", length));
            String[] rdBkgDelTermNm = (JSPUtil.getParameter(request, prefix + "rd_bkg_del_term_nm", length));
            String[] rdInvAmt = (JSPUtil.getParameter(request, prefix + "rd_inv_amt", length));
            String[] rdOrgChgAmt = (JSPUtil.getParameter(request, prefix + "rd_org_chg_amt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] rdOrgCurrCd = (JSPUtil.getParameter(request, prefix + "rd_org_curr_cd", length));
            String[] rdDmdtInvNo = (JSPUtil.getParameter(request, prefix + "rd_dmdt_inv_no", length));
            String[] rdCustVatPrnFlg = (JSPUtil.getParameter(request, prefix + "rd_cust_vat_prn_flg", length));
            String[] rdInvRmk2 = (JSPUtil.getParameter(request, prefix + "rd_inv_rmk2", length));
            String[] rdInvRmk1 = (JSPUtil.getParameter(request, prefix + "rd_inv_rmk1", length));
            String[] rdShRmk9 = (JSPUtil.getParameter(request, prefix + "rd_sh_rmk9", length));
            String[] rdDaysDisp = (JSPUtil.getParameter(request, prefix + "rd_days_disp", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] rdDmdtTrfCd = (JSPUtil.getParameter(request, prefix + "rd_dmdt_trf_cd", length));
            String[] rdShHdN2ndMsg = (JSPUtil.getParameter(request, prefix + "rd_sh_hd_n2nd_msg", length));
            String[] rdVvdCd = (JSPUtil.getParameter(request, prefix + "rd_vvd_cd", length));
            String[] rdCustCd = (JSPUtil.getParameter(request, prefix + "rd_cust_cd", length));
            String[] rdDueDate = (JSPUtil.getParameter(request, prefix + "rd_due_date", length));
            String[] rdShAddr1 = (JSPUtil.getParameter(request, prefix + "rd_sh_addr1", length));
            String[] rdShAddr2 = (JSPUtil.getParameter(request, prefix + "rd_sh_addr2", length));
            String[] rdShAddr3 = (JSPUtil.getParameter(request, prefix + "rd_sh_addr3", length));
            String[] rdPodNm = (JSPUtil.getParameter(request, prefix + "rd_pod_nm", length));
            String[] rdBlNo = (JSPUtil.getParameter(request, prefix + "rd_bl_no", length));
            String[] rdShHdN4thMsg = (JSPUtil.getParameter(request, prefix + "rd_sh_hd_n4th_msg", length));
            String[] rdCmdtNm = (JSPUtil.getParameter(request, prefix + "rd_cmdt_nm", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] rdDelNm = (JSPUtil.getParameter(request, prefix + "rd_del_nm", length));
            String[] rdVslEngNm = (JSPUtil.getParameter(request, prefix + "rd_vsl_eng_nm", length));
            String[] rdShHdN5thMsg = (JSPUtil.getParameter(request, prefix + "rd_sh_hd_n5th_msg", length));
            String[] rdDueDay = (JSPUtil.getParameter(request, prefix + "rd_due_day", length));
            String[] rdInvoiceTitle = (JSPUtil.getParameter(request, prefix + "rd_invoice_title", length));
            String[] rdBkgNo = (JSPUtil.getParameter(request, prefix + "rd_bkg_no", length));
            String[] rdNtcKntCd = (JSPUtil.getParameter(request, prefix + "rd_ntc_knt_cd", length));
            String[] rdShHdN1stMsg = (JSPUtil.getParameter(request, prefix + "rd_sh_hd_n1st_msg", length));
            String[] rdTotAmt = (JSPUtil.getParameter(request, prefix + "rd_tot_amt", length));
            String[] rdDcAmtFlg = (JSPUtil.getParameter(request, prefix + "rd_dc_amt_flg", length));
            String[] rdFaxNo = (JSPUtil.getParameter(request, prefix + "rd_fax_no", length));
            String[] rdArr = (JSPUtil.getParameter(request, prefix + "rd_arr", length));
            String[] rdTaxRto = (JSPUtil.getParameter(request, prefix + "rd_tax_rto", length));
            String[] rdInvChgAmt = (JSPUtil.getParameter(request, prefix + "rd_inv_chg_amt", length));
            String[] rdIssueDay = (JSPUtil.getParameter(request, prefix + "rd_issue_day", length));
            String[] rdDmdtTrfNm = (JSPUtil.getParameter(request, prefix + "rd_dmdt_trf_nm", length));
            String[] rdAttnNm = (JSPUtil.getParameter(request, prefix + "rd_attn_nm", length));
            String[] rdInvXchRt = (JSPUtil.getParameter(request, prefix + "rd_inv_xch_rt", length));
            String[] rdTruckerNm = (JSPUtil.getParameter(request, prefix + "rd_trucker_nm", length));
            String[] rdDmdtInvStsCd = (JSPUtil.getParameter(request, prefix + "rd_dmdt_inv_sts_cd", length));
            String[] rdIdaExpnTaxRt = (JSPUtil.getParameter(request, prefix + "rd_ida_expn_tax_rt", length));
            String[] rdIdaExpnTax = (JSPUtil.getParameter(request, prefix + "rd_ida_expn_tax", length));
            String[] rdIdaEduTax = (JSPUtil.getParameter(request, prefix + "rd_ida_edu_tax", length));
            String[] rdIdaEduTaxRt = (JSPUtil.getParameter(request, prefix + "rd_ida_edu_tax_rt", length));
            String[] rdIdaHighEduTaxRt = (JSPUtil.getParameter(request, prefix + "rd_ida_high_edu_tax_rt", length));
            String[] rdIdaHighEduTax = (JSPUtil.getParameter(request, prefix + "rd_ida_high_edu_tax", length));
            String[] rdSvcCateRmk = (JSPUtil.getParameter(request, prefix + "rd_svc_cate_rmk", length));
            String[] rdPmntAcctNo = (JSPUtil.getParameter(request, prefix + "rd_pmnt_acct_no", length));
            String[] rdTaxRgstNo = (JSPUtil.getParameter(request, prefix + "rd_tax_rgst_no", length));
            String[] rdIdaLoclTaxRt = (JSPUtil.getParameter(request, prefix + "rd_ida_locl_tax_rt", length));
            String[] rdIdaLoclTax = (JSPUtil.getParameter(request, prefix + "rd_ida_locl_tax", length));
            String[] rdIdaN2ndLoclTaxRt = (JSPUtil.getParameter(request, prefix + "rd_ida_n2nd_locl_tax_rt", length));
            String[] rdIdaN2ndLoclTax = (JSPUtil.getParameter(request, prefix + "rd_ida_n2nd_locl_tax", length));
            String[] rdIdaTaxApplTm = (JSPUtil.getParameter(request, prefix + "rd_ida_tax_appl_tm", length));
            String[] rdIdaCgstRto = (JSPUtil.getParameter(request, prefix + "rd_ida_cgst_rto", length));
            String[] rdIdaCgstAmt = (JSPUtil.getParameter(request, prefix + "rd_ida_cgst_amt", length));
            String[] rdIdaSgstRto = (JSPUtil.getParameter(request, prefix + "rd_ida_sgst_rto", length));
            String[] rdIdaSgstAmt = (JSPUtil.getParameter(request, prefix + "rd_ida_sgst_amt", length));
            String[] rdIdaIgstRto = (JSPUtil.getParameter(request, prefix + "rd_ida_igst_rto", length));
            String[] rdIdaIgstAmt = (JSPUtil.getParameter(request, prefix + "rd_ida_igst_amt", length));
            String[] rdIdaUgstRto = (JSPUtil.getParameter(request, prefix + "rd_ida_ugst_rto", length));
            String[] rdIdaUgstAmt = (JSPUtil.getParameter(request, prefix + "rd_ida_ugst_amt", length));
            String[] rdIdaBankAcctNo = (JSPUtil.getParameter(request, prefix + "rd_ida_bank_acct_no", length));
            String[] rdIdaBankIfscCd = (JSPUtil.getParameter(request, prefix + "rd_ida_bank_ifsc_cd", length));
            String[] rdIdaTaxCin = (JSPUtil.getParameter(request, prefix + "rd_ida_tax_cin", length));
            String[] rdIdaGstRgstNo = (JSPUtil.getParameter(request, prefix + "rd_ida_gst_rgst_no", length));
            String[] rdIdaSteCd = (JSPUtil.getParameter(request, prefix + "rd_ida_ste_cd", length));
            String[] rdIdaSteNm = (JSPUtil.getParameter(request, prefix + "rd_ida_ste_nm", length));
            String[] rdIdaSacCd = (JSPUtil.getParameter(request, prefix + "rd_ida_sac_cd", length));
            String[] rdIdaOfcSteCd = (JSPUtil.getParameter(request, prefix + "rd_ida_ofc_ste_cd", length));
            String[] rdIdaOfcSteNm = (JSPUtil.getParameter(request, prefix + "rd_ida_ofc_ste_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new InvoiceIssueMasterPreviewVO();
                if (rdInvCurrCd[i] != null)
                    model.setRdInvCurrCd(rdInvCurrCd[i]);
                if (rdDcAmt[i] != null)
                    model.setRdDcAmt(rdDcAmt[i]);
                if (rdBkgRcvTermNm[i] != null)
                    model.setRdBkgRcvTermNm(rdBkgRcvTermNm[i]);
                if (rdTaxAmt[i] != null)
                    model.setRdTaxAmt(rdTaxAmt[i]);
                if (rdTaxAmtPrnFlg[i] != null)
                    model.setRdTaxAmtPrnFlg(rdTaxAmtPrnFlg[i]);
                if (rdPayrAddr[i] != null)
                    model.setRdPayrAddr(rdPayrAddr[i]);
                if (rdPhnFaxPrnFlg[i] != null)
                    model.setRdPhnFaxPrnFlg(rdPhnFaxPrnFlg[i]);
                if (rdCustNm[i] != null)
                    model.setRdCustNm(rdCustNm[i]);
                if (rdPhnNo[i] != null)
                    model.setRdPhnNo(rdPhnNo[i]);
                if (rdInvRefNo[i] != null)
                    model.setRdInvRefNo(rdInvRefNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (rdShRmk11[i] != null)
                    model.setRdShRmk11(rdShRmk11[i]);
                if (rdShRmk10[i] != null)
                    model.setRdShRmk10(rdShRmk10[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (rdShRmk13[i] != null)
                    model.setRdShRmk13(rdShRmk13[i]);
                if (rdShRmk12[i] != null)
                    model.setRdShRmk12(rdShRmk12[i]);
                if (rdCancelNote[i] != null)
                    model.setRdCancelNote(rdCancelNote[i]);
                if (rdCreCntCd[i] != null)
                    model.setRdCreCntCd(rdCreCntCd[i]);
                if (rdShRmk14[i] != null)
                    model.setRdShRmk14(rdShRmk14[i]);
                if (rdDel[i] != null)
                    model.setRdDel(rdDel[i]);
                if (rdPod[i] != null)
                    model.setRdPod(rdPod[i]);
                if (rdDep[i] != null)
                    model.setRdDep(rdDep[i]);
                if (rdCustRefPrnFlg[i] != null)
                    model.setRdCustRefPrnFlg(rdCustRefPrnFlg[i]);
                if (rdCustVatNo[i] != null)
                    model.setRdCustVatNo(rdCustVatNo[i]);
                if (rdShRmk4[i] != null)
                    model.setRdShRmk4(rdShRmk4[i]);
                if (rdShRmk3[i] != null)
                    model.setRdShRmk3(rdShRmk3[i]);
                if (rdShRmk2[i] != null)
                    model.setRdShRmk2(rdShRmk2[i]);
                if (rdShHdN3rdMsg[i] != null)
                    model.setRdShHdN3rdMsg(rdShHdN3rdMsg[i]);
                if (rdShRmk1[i] != null)
                    model.setRdShRmk1(rdShRmk1[i]);
                if (rdShRmk8[i] != null)
                    model.setRdShRmk8(rdShRmk8[i]);
                if (rdShRmk7[i] != null)
                    model.setRdShRmk7(rdShRmk7[i]);
                if (rdShRmk6[i] != null)
                    model.setRdShRmk6(rdShRmk6[i]);
                if (rdShRmk5[i] != null)
                    model.setRdShRmk5(rdShRmk5[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (rdCreUsrNm[i] != null)
                    model.setRdCreUsrNm(rdCreUsrNm[i]);
                if (rdBkgDelTermNm[i] != null)
                    model.setRdBkgDelTermNm(rdBkgDelTermNm[i]);
                if (rdInvAmt[i] != null)
                    model.setRdInvAmt(rdInvAmt[i]);
                if (rdOrgChgAmt[i] != null)
                    model.setRdOrgChgAmt(rdOrgChgAmt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (rdOrgCurrCd[i] != null)
                    model.setRdOrgCurrCd(rdOrgCurrCd[i]);
                if (rdDmdtInvNo[i] != null)
                    model.setRdDmdtInvNo(rdDmdtInvNo[i]);
                if (rdCustVatPrnFlg[i] != null)
                    model.setRdCustVatPrnFlg(rdCustVatPrnFlg[i]);
                if (rdInvRmk2[i] != null)
                    model.setRdInvRmk2(rdInvRmk2[i]);
                if (rdInvRmk1[i] != null)
                    model.setRdInvRmk1(rdInvRmk1[i]);
                if (rdShRmk9[i] != null)
                    model.setRdShRmk9(rdShRmk9[i]);
                if (rdDaysDisp[i] != null)
                    model.setRdDaysDisp(rdDaysDisp[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (rdDmdtTrfCd[i] != null)
                    model.setRdDmdtTrfCd(rdDmdtTrfCd[i]);
                if (rdShHdN2ndMsg[i] != null)
                    model.setRdShHdN2ndMsg(rdShHdN2ndMsg[i]);
                if (rdVvdCd[i] != null)
                    model.setRdVvdCd(rdVvdCd[i]);
                if (rdCustCd[i] != null)
                    model.setRdCustCd(rdCustCd[i]);
                if (rdDueDate[i] != null)
                    model.setRdDueDate(rdDueDate[i]);
                if (rdShAddr1[i] != null)
                    model.setRdShAddr1(rdShAddr1[i]);
                if (rdShAddr2[i] != null)
                    model.setRdShAddr2(rdShAddr2[i]);
                if (rdShAddr3[i] != null)
                    model.setRdShAddr3(rdShAddr3[i]);
                if (rdPodNm[i] != null)
                    model.setRdPodNm(rdPodNm[i]);
                if (rdBlNo[i] != null)
                    model.setRdBlNo(rdBlNo[i]);
                if (rdShHdN4thMsg[i] != null)
                    model.setRdShHdN4thMsg(rdShHdN4thMsg[i]);
                if (rdCmdtNm[i] != null)
                    model.setRdCmdtNm(rdCmdtNm[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (rdDelNm[i] != null)
                    model.setRdDelNm(rdDelNm[i]);
                if (rdVslEngNm[i] != null)
                    model.setRdVslEngNm(rdVslEngNm[i]);
                if (rdShHdN5thMsg[i] != null)
                    model.setRdShHdN5thMsg(rdShHdN5thMsg[i]);
                if (rdDueDay[i] != null)
                    model.setRdDueDay(rdDueDay[i]);
                if (rdInvoiceTitle[i] != null)
                    model.setRdInvoiceTitle(rdInvoiceTitle[i]);
                if (rdBkgNo[i] != null)
                    model.setRdBkgNo(rdBkgNo[i]);
                if (rdNtcKntCd[i] != null)
                    model.setRdNtcKntCd(rdNtcKntCd[i]);
                if (rdShHdN1stMsg[i] != null)
                    model.setRdShHdN1stMsg(rdShHdN1stMsg[i]);
                if (rdTotAmt[i] != null)
                    model.setRdTotAmt(rdTotAmt[i]);
                if (rdDcAmtFlg[i] != null)
                    model.setRdDcAmtFlg(rdDcAmtFlg[i]);
                if (rdFaxNo[i] != null)
                    model.setRdFaxNo(rdFaxNo[i]);
                if (rdArr[i] != null)
                    model.setRdArr(rdArr[i]);
                if (rdTaxRto[i] != null)
                    model.setRdTaxRto(rdTaxRto[i]);
                if (rdInvChgAmt[i] != null)
                    model.setRdInvChgAmt(rdInvChgAmt[i]);
                if (rdIssueDay[i] != null)
                    model.setRdIssueDay(rdIssueDay[i]);
                if (rdDmdtTrfNm[i] != null)
                    model.setRdDmdtTrfNm(rdDmdtTrfNm[i]);
                if (rdAttnNm[i] != null)
                    model.setRdAttnNm(rdAttnNm[i]);
                if (rdInvXchRt[i] != null)
                    model.setRdInvXchRt(rdInvXchRt[i]);
                if (rdTruckerNm[i] != null)
                    model.setRdTruckerNm(rdTruckerNm[i]);
                if (rdDmdtInvStsCd[i] != null)
                    model.setRdDmdtInvStsCd(rdDmdtInvStsCd[i]);
                if (rdIdaExpnTaxRt[i] != null)
                    model.setRdIdaExpnTaxRt(rdIdaExpnTaxRt[i]);
                if (rdIdaExpnTax[i] != null)
                    model.setRdIdaExpnTax(rdIdaExpnTax[i]);
                if (rdIdaEduTaxRt[i] != null)
                    model.setRdIdaEduTaxRt(rdIdaEduTaxRt[i]);
                if (rdIdaEduTax[i] != null)
                    model.setRdIdaEduTax(rdIdaEduTax[i]);
                if (rdIdaHighEduTaxRt[i] != null)
                    model.setRdIdaHighEduTaxRt(rdIdaHighEduTaxRt[i]);
                if (rdIdaHighEduTax[i] != null)
                    model.setRdIdaHighEduTax(rdIdaHighEduTax[i]);
                if (rdSvcCateRmk[i] != null)
                    model.setRdSvcCateRmk(rdSvcCateRmk[i]);
                if (rdPmntAcctNo[i] != null)
                    model.setRdPmntAcctNo(rdPmntAcctNo[i]);
                if (rdTaxRgstNo[i] != null)
                    model.setRdTaxRgstNo(rdTaxRgstNo[i]);
                if (rdIdaLoclTaxRt[i] != null)
                    model.setRdIdaLoclTaxRt(rdIdaLoclTaxRt[i]);
                if (rdIdaLoclTax[i] != null)
                    model.setRdIdaLoclTax(rdIdaLoclTax[i]);
                if (rdIdaN2ndLoclTaxRt[i] != null)
                    model.setRdIdaN2ndLoclTaxRt(rdIdaN2ndLoclTaxRt[i]);
                if (rdIdaN2ndLoclTax[i] != null)
                    model.setRdIdaN2ndLoclTax(rdIdaN2ndLoclTax[i]);
                if (rdIdaTaxApplTm[i] != null)
                    model.setRdIdaTaxApplTm(rdIdaTaxApplTm[i]);
                if (rdIdaCgstRto[i] != null)
                    model.setRdIdaCgstRto(rdIdaCgstRto[i]);
                if (rdIdaCgstAmt[i] != null)
                    model.setRdIdaCgstAmt(rdIdaCgstAmt[i]);
                if (rdIdaSgstRto[i] != null)
                    model.setRdIdaSgstRto(rdIdaSgstRto[i]);
                if (rdIdaSgstAmt[i] != null)
                    model.setRdIdaSgstAmt(rdIdaSgstAmt[i]);
                if (rdIdaIgstRto[i] != null)
                    model.setRdIdaIgstRto(rdIdaIgstRto[i]);
                if (rdIdaIgstAmt[i] != null)
                    model.setRdIdaIgstAmt(rdIdaIgstAmt[i]);
                if (rdIdaUgstRto[i] != null)
                    model.setRdIdaUgstRto(rdIdaUgstRto[i]);
                if (rdIdaUgstAmt[i] != null)
                    model.setRdIdaUgstAmt(rdIdaUgstAmt[i]);
                if (rdIdaBankAcctNo[i] != null)
                    model.setRdIdaBankAcctNo(rdIdaBankAcctNo[i]);
                if (rdIdaBankIfscCd[i] != null)
                    model.setRdIdaBankIfscCd(rdIdaBankIfscCd[i]);
                if (rdIdaTaxCin[i] != null)
                    model.setRdIdaTaxCin(rdIdaTaxCin[i]);
                if (rdIdaGstRgstNo[i] != null)
                    model.setRdIdaGstRgstNo(rdIdaGstRgstNo[i]);
                if (rdIdaSteCd[i] != null)
                    model.setRdIdaSteCd(rdIdaSteCd[i]);
                if (rdIdaSteNm[i] != null) 
		    		model.setRdIdaSteNm(rdIdaSteNm[i]);                
                if (rdIdaSacCd[i] != null)
                    model.setRdIdaSacCd(rdIdaSacCd[i]);
                if (rdIdaOfcSteCd[i] != null)
                    model.setRdIdaOfcSteCd(rdIdaOfcSteCd[i]);
                if (rdIdaOfcSteNm[i] != null)
                    model.setRdIdaOfcSteNm(rdIdaOfcSteNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getInvoiceIssueMasterPreviewVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return InvoiceIssueMasterPreviewVO[]
	 */
    public InvoiceIssueMasterPreviewVO[] getInvoiceIssueMasterPreviewVOs() {
        InvoiceIssueMasterPreviewVO[] vos = (InvoiceIssueMasterPreviewVO[]) models.toArray(new InvoiceIssueMasterPreviewVO[models.size()]);
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
        this.rdInvCurrCd = this.rdInvCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDcAmt = this.rdDcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdBkgRcvTermNm = this.rdBkgRcvTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTaxAmt = this.rdTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTaxAmtPrnFlg = this.rdTaxAmtPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdPayrAddr = this.rdPayrAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdPhnFaxPrnFlg = this.rdPhnFaxPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCustNm = this.rdCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdPhnNo = this.rdPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvRefNo = this.rdInvRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk11 = this.rdShRmk11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk10 = this.rdShRmk10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk13 = this.rdShRmk13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk12 = this.rdShRmk12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCancelNote = this.rdCancelNote.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCreCntCd = this.rdCreCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk14 = this.rdShRmk14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDel = this.rdDel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdPod = this.rdPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDep = this.rdDep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCustRefPrnFlg = this.rdCustRefPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCustVatNo = this.rdCustVatNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk4 = this.rdShRmk4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk3 = this.rdShRmk3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk2 = this.rdShRmk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShHdN3rdMsg = this.rdShHdN3rdMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk1 = this.rdShRmk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk8 = this.rdShRmk8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk7 = this.rdShRmk7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk6 = this.rdShRmk6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk5 = this.rdShRmk5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCreUsrNm = this.rdCreUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdBkgDelTermNm = this.rdBkgDelTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvAmt = this.rdInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdOrgChgAmt = this.rdOrgChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdOrgCurrCd = this.rdOrgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDmdtInvNo = this.rdDmdtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCustVatPrnFlg = this.rdCustVatPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvRmk2 = this.rdInvRmk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvRmk1 = this.rdInvRmk1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShRmk9 = this.rdShRmk9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDaysDisp = this.rdDaysDisp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDmdtTrfCd = this.rdDmdtTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShHdN2ndMsg = this.rdShHdN2ndMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdVvdCd = this.rdVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCustCd = this.rdCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDueDate = this.rdDueDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShAddr1 = this.rdShAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShAddr2 = this.rdShAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShAddr3 = this.rdShAddr3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdPodNm = this.rdPodNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdBlNo = this.rdBlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShHdN4thMsg = this.rdShHdN4thMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCmdtNm = this.rdCmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDelNm = this.rdDelNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdVslEngNm = this.rdVslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShHdN5thMsg = this.rdShHdN5thMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDueDay = this.rdDueDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvoiceTitle = this.rdInvoiceTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdBkgNo = this.rdBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdNtcKntCd = this.rdNtcKntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdShHdN1stMsg = this.rdShHdN1stMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTotAmt = this.rdTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDcAmtFlg = this.rdDcAmtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdFaxNo = this.rdFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdArr = this.rdArr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTaxRto = this.rdTaxRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvChgAmt = this.rdInvChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIssueDay = this.rdIssueDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDmdtTrfNm = this.rdDmdtTrfNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdAttnNm = this.rdAttnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdInvXchRt = this.rdInvXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTruckerNm = this.rdTruckerNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdDmdtInvStsCd = this.rdDmdtInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaExpnTaxRt = this.rdIdaExpnTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaExpnTax = this.rdIdaExpnTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaEduTaxRt = this.rdIdaEduTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaEduTax = this.rdIdaEduTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaHighEduTaxRt = this.rdIdaHighEduTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaHighEduTax = this.rdIdaHighEduTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdSvcCateRmk = this.rdSvcCateRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdPmntAcctNo = this.rdPmntAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdTaxRgstNo = this.rdTaxRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaLoclTaxRt = this.rdIdaLoclTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaLoclTax = this.rdIdaLoclTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaN2ndLoclTaxRt = this.rdIdaLoclTaxRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaN2ndLoclTax = this.rdIdaLoclTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaTaxApplTm = this.rdIdaTaxApplTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaCgstRto = this.rdIdaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaCgstAmt = this.rdIdaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaSgstRto = this.rdIdaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaSgstAmt = this.rdIdaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaIgstRto = this.rdIdaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaIgstAmt = this.rdIdaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaUgstRto = this.rdIdaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaUgstAmt = this.rdIdaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaBankAcctNo = this.rdIdaBankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaBankIfscCd = this.rdIdaBankIfscCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaTaxCin = this.rdIdaTaxCin.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaGstRgstNo = this.rdIdaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaSteCd = this.rdIdaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaSteNm = this.rdIdaSteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaSacCd = this.rdIdaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaOfcSteCd = this.rdIdaOfcSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdIdaOfcSteNm = this.rdIdaOfcSteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
