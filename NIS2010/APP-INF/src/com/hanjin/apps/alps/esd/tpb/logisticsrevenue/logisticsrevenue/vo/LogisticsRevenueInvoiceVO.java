/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : LogisticsRevenueInvoiceVO.java
*@FileTitle : LogisticsRevenueInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.22  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class LogisticsRevenueInvoiceVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<LogisticsRevenueInvoiceVO> models = new ArrayList<LogisticsRevenueInvoiceVO>();

    /* Column Info */
    private String sTotal = null;

    /* Column Info */
    private String sVndrCustDivCd = null;

    /* Column Info */
    private String sCustSeq = null;

    /* Column Info */
    private String ibflag = null;

    /* Column Info */
    private String sRevInvRt = null;

    /* Column Info */
    private String sVndrCntCd = null;

    /* Column Info */
    private String sN3ptyIfTpCd = null;

    /* Column Info */
    private String sN3ptyNo = null;

    /* Column Info */
    private String sTax = null;

    /* Column Info */
    private String sSrcInvNo = null;

    /* Column Info */
    private String sSdate = null;

    /* Column Info */
    private String sCntrRtnYdCd = null;

    /* Column Info */
    private String sSrcVndrSeq = null;

    /* Column Info */
    private String sTtlAmt = null;

    /* Column Info */
    private String sEdate = null;

    /* Column Info */
    private String sN3ptyExpnTpCd = null;

    /* Column Info */
    private String sDtlRmk = null;

    /* Column Info */
    private String sNewBkg = null;

    /* Column Info */
    private String sSrcVndrCntCd = null;

    /* Column Info */
    private String pagerows = null;

    /* Column Info */
    private String sReYdCd = null;

    /* Column Info */
    private String sYdCd = null;

    /* Column Info */
    private String eqNo = null;

    /* Column Info */
    private String sTaxAmt = null;

    /* Column Info */
    private String sDtlAmt = null;

    /* Column Info */
    private String sTrdPartyVal = null;

    /* Column Info */
    private String sVndrSeq = null;

    /* Column Info */
    private String sLoclTaxAmt = null;

    /* Column Info */
    private String sN2ndLoclTaxAmt = null;

    /* Column Info */
    private String sCurr = null;

    /* Column Info */
    private String sUsrOfcCd = null;

    /* Column Info */
    private String sCustCntCd = null;

    /* Column Info */
    private String sIfOfcCd = null;

    /* Column Info */
    private String sN3ptyBilTpCd = null;

    /* Column Info */
    private String sUsrId = null;

    /* Column Info */
    private String sN3ptyInvNo = null;

    /* Column Info */
    private String sCntrRtnDt = null;

    /* Column Info */
    private String sN3ptySrcNo = null;

    /* Column Info */
    private String sBkgNo = null;

    /* Column Info */
    private String sCfmTp = null;

    /* Column Info */
    private String grpCfmSeq = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public LogisticsRevenueInvoiceVO() {
    }

    public LogisticsRevenueInvoiceVO(String ibflag, String pagerows, String sDtlRmk, String sN3ptyBilTpCd, String sEdate, String sN3ptyNo, String sTrdPartyVal, String sUsrId, String sVndrSeq, String sSdate, String sUsrOfcCd, String sIfOfcCd, String sTotal, String sTax, String sVndrCntCd, String sN3ptyIfTpCd, String sCurr, String sReYdCd, String sN3ptyInvNo, String sTtlAmt, String sN3ptyExpnTpCd, String sCustSeq, String sCustCntCd, String sVndrCustDivCd, String sLoclTaxAmt, String sN2ndLoclTaxAmt, String sDtlAmt, String sSrcInvNo, String sYdCd, String sCntrRtnYdCd, String sSrcVndrSeq, String sCntrRtnDt, String sRevInvRt, String sSrcVndrCntCd, String sNewBkg, String eqNo, String sTaxAmt, String sN3ptySrcNo, String sBkgNo, String sCfmTp, String grpCfmSeq) {
        this.sTotal = sTotal;
        this.sVndrCustDivCd = sVndrCustDivCd;
        this.sCustSeq = sCustSeq;
        this.ibflag = ibflag;
        this.sRevInvRt = sRevInvRt;
        this.sVndrCntCd = sVndrCntCd;
        this.sN3ptyIfTpCd = sN3ptyIfTpCd;
        this.sN3ptyNo = sN3ptyNo;
        this.sTax = sTax;
        this.sSrcInvNo = sSrcInvNo;
        this.sSdate = sSdate;
        this.sCntrRtnYdCd = sCntrRtnYdCd;
        this.sSrcVndrSeq = sSrcVndrSeq;
        this.sTtlAmt = sTtlAmt;
        this.sEdate = sEdate;
        this.sN3ptyExpnTpCd = sN3ptyExpnTpCd;
        this.sDtlRmk = sDtlRmk;
        this.sNewBkg = sNewBkg;
        this.sSrcVndrCntCd = sSrcVndrCntCd;
        this.pagerows = pagerows;
        this.sReYdCd = sReYdCd;
        this.sYdCd = sYdCd;
        this.eqNo = eqNo;
        this.sTaxAmt = sTaxAmt;
        this.sDtlAmt = sDtlAmt;
        this.sTrdPartyVal = sTrdPartyVal;
        this.sVndrSeq = sVndrSeq;
        this.sLoclTaxAmt = sLoclTaxAmt;
        this.sN2ndLoclTaxAmt = sN2ndLoclTaxAmt;
        this.sCurr = sCurr;
        this.sUsrOfcCd = sUsrOfcCd;
        this.sCustCntCd = sCustCntCd;
        this.sIfOfcCd = sIfOfcCd;
        this.sN3ptyBilTpCd = sN3ptyBilTpCd;
        this.sUsrId = sUsrId;
        this.sN3ptyInvNo = sN3ptyInvNo;
        this.sCntrRtnDt = sCntrRtnDt;
        this.sN3ptySrcNo = sN3ptySrcNo;
        this.sBkgNo = sBkgNo;
        this.sCfmTp = sCfmTp;
        this.grpCfmSeq = grpCfmSeq;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("s_total", getSTotal());
        this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
        this.hashColumns.put("s_cust_seq", getSCustSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("s_rev_inv_rt", getSRevInvRt());
        this.hashColumns.put("s_vndr_cnt_cd", getSVndrCntCd());
        this.hashColumns.put("s_n3pty_if_tp_cd", getSN3ptyIfTpCd());
        this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
        this.hashColumns.put("s_tax", getSTax());
        this.hashColumns.put("s_src_inv_no", getSSrcInvNo());
        this.hashColumns.put("s_sdate", getSSdate());
        this.hashColumns.put("s_cntr_rtn_yd_cd", getSCntrRtnYdCd());
        this.hashColumns.put("s_src_vndr_seq", getSSrcVndrSeq());
        this.hashColumns.put("s_ttl_amt", getSTtlAmt());
        this.hashColumns.put("s_edate", getSEdate());
        this.hashColumns.put("s_n3pty_expn_tp_cd", getSN3ptyExpnTpCd());
        this.hashColumns.put("s_dtl_rmk", getSDtlRmk());
        this.hashColumns.put("s_new_bkg", getSNewBkg());
        this.hashColumns.put("s_src_vndr_cnt_cd", getSSrcVndrCntCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("s_re_yd_cd", getSReYdCd());
        this.hashColumns.put("s_yd_cd", getSYdCd());
        this.hashColumns.put("eq_no", getEqNo());
        this.hashColumns.put("s_tax_amt", getSTaxAmt());
        this.hashColumns.put("s_dtl_amt", getSDtlAmt());
        this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
        this.hashColumns.put("s_vndr_seq", getSVndrSeq());
        this.hashColumns.put("s_locl_tax_amt", getSLoclTaxAmt());
        this.hashColumns.put("s_n2nd_locl_tax_amt", getSN2ndLoclTaxAmt());
        this.hashColumns.put("s_curr", getSCurr());
        this.hashColumns.put("s_usr_ofc_cd", getSUsrOfcCd());
        this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
        this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
        this.hashColumns.put("s_n3pty_bil_tp_cd", getSN3ptyBilTpCd());
        this.hashColumns.put("s_usr_id", getSUsrId());
        this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
        this.hashColumns.put("s_cntr_rtn_dt", getSCntrRtnDt());
        this.hashColumns.put("s_n3pty_src_no", getSN3ptySrcNo());
        this.hashColumns.put("s_bkg_no", getSBkgNo());
        this.hashColumns.put("s_cfm_tp", getSCfmTp());
        this.hashColumns.put("grp_cfm_seq", getGrpCfmSeq());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("s_total", "sTotal");
        this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
        this.hashFields.put("s_cust_seq", "sCustSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("s_rev_inv_rt", "sRevInvRt");
        this.hashFields.put("s_vndr_cnt_cd", "sVndrCntCd");
        this.hashFields.put("s_n3pty_if_tp_cd", "sN3ptyIfTpCd");
        this.hashFields.put("s_n3pty_no", "sN3ptyNo");
        this.hashFields.put("s_tax", "sTax");
        this.hashFields.put("s_src_inv_no", "sSrcInvNo");
        this.hashFields.put("s_sdate", "sSdate");
        this.hashFields.put("s_cntr_rtn_yd_cd", "sCntrRtnYdCd");
        this.hashFields.put("s_src_vndr_seq", "sSrcVndrSeq");
        this.hashFields.put("s_ttl_amt", "sTtlAmt");
        this.hashFields.put("s_edate", "sEdate");
        this.hashFields.put("s_n3pty_expn_tp_cd", "sN3ptyExpnTpCd");
        this.hashFields.put("s_dtl_drmk", "sDtlRmk");
        this.hashFields.put("s_new_bkg", "sNewBkg");
        this.hashFields.put("s_src_vndr_cnt_cd", "sSrcVndrCntCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("s_re_yd_cd", "sReYdCd");
        this.hashFields.put("s_yd_cd", "sYdCd");
        this.hashFields.put("eq_no", "eqNo");
        this.hashFields.put("s_tax_amt", "sTaxAmt");
        this.hashFields.put("s_dtl_amt", "sDtlAmt");
        this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
        this.hashFields.put("s_vndr_seq", "sVndrSeq");
        this.hashFields.put("s_locl_tax_amt", "sLoclTaxAmt");
        this.hashFields.put("s_n2nd_locl_tax_amt", "sN2ndLoclTaxAmt");
        this.hashFields.put("s_curr", "sCurr");
        this.hashFields.put("s_usr_ofc_cd", "sUsrOfcCd");
        this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
        this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
        this.hashFields.put("s_n3pty_bil_tp_cd", "sN3ptyBilTpCd");
        this.hashFields.put("s_usr_id", "sUsrId");
        this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
        this.hashFields.put("s_cntr_rtn_dt", "sCntrRtnDt");
        this.hashFields.put("s_n3pty_src_no", "sN3ptySrcNo");
        this.hashFields.put("s_bkg_no", "sBkgNo");
        this.hashFields.put("s_cfm_tp", "sCfmTp");
        this.hashFields.put("grp_cfm_seq", "grpCfmSeq");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return sTotal
	 */
    public String getSTotal() {
        return this.sTotal;
    }

    /**
	 * Column Info
	 * @return sVndrCustDivCd
	 */
    public String getSVndrCustDivCd() {
        return this.sVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @return sCustSeq
	 */
    public String getSCustSeq() {
        return this.sCustSeq;
    }

    /**
	 * Column Info
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @return sRevInvRt
	 */
    public String getSRevInvRt() {
        return this.sRevInvRt;
    }

    /**
	 * Column Info
	 * @return sVndrCntCd
	 */
    public String getSVndrCntCd() {
        return this.sVndrCntCd;
    }

    /**
	 * Column Info
	 * @return sN3ptyIfTpCd
	 */
    public String getSN3ptyIfTpCd() {
        return this.sN3ptyIfTpCd;
    }

    /**
	 * Column Info
	 * @return sN3ptyNo
	 */
    public String getSN3ptyNo() {
        return this.sN3ptyNo;
    }

    /**
	 * Column Info
	 * @return sTax
	 */
    public String getSTax() {
        return this.sTax;
    }

    /**
	 * Column Info
	 * @return sSrcInvNo
	 */
    public String getSSrcInvNo() {
        return this.sSrcInvNo;
    }

    /**
	 * Column Info
	 * @return sSdate
	 */
    public String getSSdate() {
        return this.sSdate;
    }

    /**
	 * Column Info
	 * @return sCntrRtnYdCd
	 */
    public String getSCntrRtnYdCd() {
        return this.sCntrRtnYdCd;
    }

    /**
	 * Column Info
	 * @return sSrcVndrSeq
	 */
    public String getSSrcVndrSeq() {
        return this.sSrcVndrSeq;
    }

    /**
	 * Column Info
	 * @return sTtlAmt
	 */
    public String getSTtlAmt() {
        return this.sTtlAmt;
    }

    /**
	 * Column Info
	 * @return sEdate
	 */
    public String getSEdate() {
        return this.sEdate;
    }

    /**
	 * Column Info
	 * @return sN3ptyExpnTpCd
	 */
    public String getSN3ptyExpnTpCd() {
        return this.sN3ptyExpnTpCd;
    }

    /**
	 * Column Info
	 * @return sDtlRmk
	 */
    public String getSDtlRmk() {
        return this.sDtlRmk;
    }

    /**
	 * Column Info
	 * @return sNewBkg
	 */
    public String getSNewBkg() {
        return this.sNewBkg;
    }

    /**
	 * Column Info
	 * @return sSrcVndrCntCd
	 */
    public String getSSrcVndrCntCd() {
        return this.sSrcVndrCntCd;
    }

    /**
	 * Column Info
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Column Info
	 * @return sReYdCd
	 */
    public String getSReYdCd() {
        return this.sReYdCd;
    }

    /**
	 * Column Info
	 * @return sYdCd
	 */
    public String getSYdCd() {
        return this.sYdCd;
    }

    /**
	 * Column Info
	 * @return eqNo
	 */
    public String getEqNo() {
        return this.eqNo;
    }

    /**
	 * Column Info
	 * @return sTaxAmt
	 */
    public String getSTaxAmt() {
        return this.sTaxAmt;
    }

    /**
	 * Column Info
	 * @return sDtlAmt
	 */
    public String getSDtlAmt() {
        return this.sDtlAmt;
    }

    /**
	 * Column Info
	 * @return sTrdPartyVal
	 */
    public String getSTrdPartyVal() {
        return this.sTrdPartyVal;
    }

    /**
	 * Column Info
	 * @return sVndrSeq
	 */
    public String getSVndrSeq() {
        return this.sVndrSeq;
    }

    /**
	 * Column Info
	 * @return sLoclTaxAmt
	 */
    public String getSLoclTaxAmt() {
        return this.sLoclTaxAmt;
    }

    /**
	 * Column Info
	 * @return sN2ndLoclTaxAmt
	 */
    public String getSN2ndLoclTaxAmt() {
        return this.sN2ndLoclTaxAmt;
    }

    /**
	 * Column Info
	 * @return sCurr
	 */
    public String getSCurr() {
        return this.sCurr;
    }

    /**
	 * Column Info
	 * @return sUsrOfcCd
	 */
    public String getSUsrOfcCd() {
        return this.sUsrOfcCd;
    }

    /**
	 * Column Info
	 * @return sCustCntCd
	 */
    public String getSCustCntCd() {
        return this.sCustCntCd;
    }

    /**
	 * Column Info
	 * @return sIfOfcCd
	 */
    public String getSIfOfcCd() {
        return this.sIfOfcCd;
    }

    /**
	 * Column Info
	 * @return sN3ptyBilTpCd
	 */
    public String getSN3ptyBilTpCd() {
        return this.sN3ptyBilTpCd;
    }

    /**
	 * Column Info
	 * @return sUsrId
	 */
    public String getSUsrId() {
        return this.sUsrId;
    }

    /**
	 * Column Info
	 * @return sN3ptyInvNo
	 */
    public String getSN3ptyInvNo() {
        return this.sN3ptyInvNo;
    }

    /**
	 * Column Info
	 * @return sCntrRtnDt
	 */
    public String getSCntrRtnDt() {
        return this.sCntrRtnDt;
    }

    /**
	 * Column Info
	 * @param sTotal
	 */
    public void setSTotal(String sTotal) {
        this.sTotal = sTotal;
    }

    /**
	 * Column Info
	 * @param sVndrCustDivCd
	 */
    public void setSVndrCustDivCd(String sVndrCustDivCd) {
        this.sVndrCustDivCd = sVndrCustDivCd;
    }

    /**
	 * Column Info
	 * @param sCustSeq
	 */
    public void setSCustSeq(String sCustSeq) {
        this.sCustSeq = sCustSeq;
    }

    /**
	 * Column Info
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Column Info
	 * @param sRevInvRt
	 */
    public void setSRevInvRt(String sRevInvRt) {
        this.sRevInvRt = sRevInvRt;
    }

    /**
	 * Column Info
	 * @param sVndrCntCd
	 */
    public void setSVndrCntCd(String sVndrCntCd) {
        this.sVndrCntCd = sVndrCntCd;
    }

    /**
	 * Column Info
	 * @param sN3ptyIfTpCd
	 */
    public void setSN3ptyIfTpCd(String sN3ptyIfTpCd) {
        this.sN3ptyIfTpCd = sN3ptyIfTpCd;
    }

    /**
	 * Column Info
	 * @param sN3ptyNo
	 */
    public void setSN3ptyNo(String sN3ptyNo) {
        this.sN3ptyNo = sN3ptyNo;
    }

    /**
	 * Column Info
	 * @param sTax
	 */
    public void setSTax(String sTax) {
        this.sTax = sTax;
    }

    /**
	 * Column Info
	 * @param sSrcInvNo
	 */
    public void setSSrcInvNo(String sSrcInvNo) {
        this.sSrcInvNo = sSrcInvNo;
    }

    /**
	 * Column Info
	 * @param sSdate
	 */
    public void setSSdate(String sSdate) {
        this.sSdate = sSdate;
    }

    /**
	 * Column Info
	 * @param sCntrRtnYdCd
	 */
    public void setSCntrRtnYdCd(String sCntrRtnYdCd) {
        this.sCntrRtnYdCd = sCntrRtnYdCd;
    }

    /**
	 * Column Info
	 * @param sSrcVndrSeq
	 */
    public void setSSrcVndrSeq(String sSrcVndrSeq) {
        this.sSrcVndrSeq = sSrcVndrSeq;
    }

    /**
	 * Column Info
	 * @param sTtlAmt
	 */
    public void setSTtlAmt(String sTtlAmt) {
        this.sTtlAmt = sTtlAmt;
    }

    /**
	 * Column Info
	 * @param sEdate
	 */
    public void setSEdate(String sEdate) {
        this.sEdate = sEdate;
    }

    /**
	 * Column Info
	 * @param sN3ptyExpnTpCd
	 */
    public void setSN3ptyExpnTpCd(String sN3ptyExpnTpCd) {
        this.sN3ptyExpnTpCd = sN3ptyExpnTpCd;
    }

    /**
	 * Column Info
	 * @param sDtlRmk
	 */
    public void setSDtlRmk(String sDtlRmk) {
        this.sDtlRmk = sDtlRmk;
    }

    /**
	 * Column Info
	 * @param sNewBkg
	 */
    public void setSNewBkg(String sNewBkg) {
        this.sNewBkg = sNewBkg;
    }

    /**
	 * Column Info
	 * @param sSrcVndrCntCd
	 */
    public void setSSrcVndrCntCd(String sSrcVndrCntCd) {
        this.sSrcVndrCntCd = sSrcVndrCntCd;
    }

    /**
	 * Column Info
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param sReYdCd
	 */
    public void setSReYdCd(String sReYdCd) {
        this.sReYdCd = sReYdCd;
    }

    /**
	 * Column Info
	 * @param sYdCd
	 */
    public void setSYdCd(String sYdCd) {
        this.sYdCd = sYdCd;
    }

    /**
	 * Column Info
	 * @param eqNo
	 */
    public void setEqNo(String eqNo) {
        this.eqNo = eqNo;
    }

    /**
	 * Column Info
	 * @param sTaxAmt
	 */
    public void setSTaxAmt(String sTaxAmt) {
        this.sTaxAmt = sTaxAmt;
    }

    /**
	 * Column Info
	 * @param sDtlAmt
	 */
    public void setSDtlAmt(String sDtlAmt) {
        this.sDtlAmt = sDtlAmt;
    }

    /**
	 * Column Info
	 * @param sTrdPartyVal
	 */
    public void setSTrdPartyVal(String sTrdPartyVal) {
        this.sTrdPartyVal = sTrdPartyVal;
    }

    /**
	 * Column Info
	 * @param sVndrSeq
	 */
    public void setSVndrSeq(String sVndrSeq) {
        this.sVndrSeq = sVndrSeq;
    }

    /**
	 * Column Info
	 * @param sLoclTaxAmt
	 */
    public void setSLoclTaxAmt(String sLoclTaxAmt) {
        this.sLoclTaxAmt = sLoclTaxAmt;
    }

    /**
	 * Column Info
	 * @param sN2ndLoclTaxAmt
	 */
    public void setSN2ndLoclTaxAmt(String sN2ndLoclTaxAmt) {
        this.sN2ndLoclTaxAmt = sN2ndLoclTaxAmt;
    }

    /**
	 * Column Info
	 * @param sCurr
	 */
    public void setSCurr(String sCurr) {
        this.sCurr = sCurr;
    }

    /**
	 * Column Info
	 * @param sUsrOfcCd
	 */
    public void setSUsrOfcCd(String sUsrOfcCd) {
        this.sUsrOfcCd = sUsrOfcCd;
    }

    /**
	 * Column Info
	 * @param sCustCntCd
	 */
    public void setSCustCntCd(String sCustCntCd) {
        this.sCustCntCd = sCustCntCd;
    }

    /**
	 * Column Info
	 * @param sIfOfcCd
	 */
    public void setSIfOfcCd(String sIfOfcCd) {
        this.sIfOfcCd = sIfOfcCd;
    }

    /**
	 * Column Info
	 * @param sN3ptyBilTpCd
	 */
    public void setSN3ptyBilTpCd(String sN3ptyBilTpCd) {
        this.sN3ptyBilTpCd = sN3ptyBilTpCd;
    }

    /**
	 * Column Info
	 * @param sUsrId
	 */
    public void setSUsrId(String sUsrId) {
        this.sUsrId = sUsrId;
    }

    /**
	 * Column Info
	 * @param sN3ptyInvNo
	 */
    public void setSN3ptyInvNo(String sN3ptyInvNo) {
        this.sN3ptyInvNo = sN3ptyInvNo;
    }

    /**
	 * Column Info
	 * @param sCntrRtnDt
	 */
    public void setSCntrRtnDt(String sCntrRtnDt) {
        this.sCntrRtnDt = sCntrRtnDt;
    }

    public void setSN3ptySrcNo(String sN3ptySrcNo) {
        this.sN3ptySrcNo = sN3ptySrcNo;
    }

    public String getSN3ptySrcNo() {
        return this.sN3ptySrcNo;
    }

    public void setSBkgNo(String sBkgNo) {
        this.sBkgNo = sBkgNo;
    }

    public String getSBkgNo() {
        return this.sBkgNo;
    }

    public void setSCfmTp(String sCfmTp) {
        this.sCfmTp = sCfmTp;
    }

    public String getSCfmTp() {
        return this.sCfmTp;
    }

    public void setGrpCfmSeq(String grpCfmSeq) {
        this.grpCfmSeq = grpCfmSeq;
    }

    public String getGrpCfmSeq() {
        return this.grpCfmSeq;
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
        setSTotal(JSPUtil.getParameter(request, prefix + "s_total", ""));
        setSVndrCustDivCd(JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", ""));
        setSCustSeq(JSPUtil.getParameter(request, prefix + "s_cust_seq", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSRevInvRt(JSPUtil.getParameter(request, prefix + "s_rev_inv_rt", ""));
        setSVndrCntCd(JSPUtil.getParameter(request, prefix + "s_vndr_cnt_cd", ""));
        setSN3ptyIfTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_if_tp_cd", ""));
        setSN3ptyNo(JSPUtil.getParameter(request, prefix + "s_n3pty_no", ""));
        setSTax(JSPUtil.getParameter(request, prefix + "s_tax", ""));
        setSSrcInvNo(JSPUtil.getParameter(request, prefix + "s_src_inv_no", ""));
        setSSdate(JSPUtil.getParameter(request, prefix + "s_sdate", ""));
        setSCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "s_cntr_rtn_yd_cd", ""));
        setSSrcVndrSeq(JSPUtil.getParameter(request, prefix + "s_src_vndr_seq", ""));
        setSTtlAmt(JSPUtil.getParameter(request, prefix + "s_ttl_amt", ""));
        setSEdate(JSPUtil.getParameter(request, prefix + "s_edate", ""));
        setSN3ptyExpnTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_expn_tp_cd", ""));
        setSDtlRmk(JSPUtil.getParameter(request, prefix + "s_dtl_rmk", ""));
        setSNewBkg(JSPUtil.getParameter(request, prefix + "s_new_bkg", ""));
        setSSrcVndrCntCd(JSPUtil.getParameter(request, prefix + "s_src_vndr_cnt_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSReYdCd(JSPUtil.getParameter(request, prefix + "s_re_yd_cd", ""));
        setSYdCd(JSPUtil.getParameter(request, prefix + "s_yd_cd", ""));
        setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
        setSTaxAmt(JSPUtil.getParameter(request, prefix + "s_tax_amt", ""));
        setSDtlAmt(JSPUtil.getParameter(request, prefix + "s_dtl_amt", ""));
        setSTrdPartyVal(JSPUtil.getParameter(request, prefix + "s_trd_party_val", ""));
        setSVndrSeq(JSPUtil.getParameter(request, prefix + "s_vndr_seq", ""));
        setSLoclTaxAmt(JSPUtil.getParameter(request, prefix + "s_locl_tax_amt", ""));
        setSN2ndLoclTaxAmt(JSPUtil.getParameter(request, prefix + "s_n2nd_locl_tax_amt", ""));
        setSCurr(JSPUtil.getParameter(request, prefix + "s_curr", ""));
        setSUsrOfcCd(JSPUtil.getParameter(request, prefix + "s_usr_ofc_cd", ""));
        setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
        setSIfOfcCd(JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", ""));
        setSN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_bil_tp_cd", ""));
        setSUsrId(JSPUtil.getParameter(request, prefix + "s_usr_id", ""));
        setSN3ptyInvNo(JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no", ""));
        setSCntrRtnDt(JSPUtil.getParameter(request, prefix + "s_cntr_rtn_dt", ""));
        setSN3ptySrcNo(JSPUtil.getParameter(request, prefix + "s_n3pty_src_no", ""));
        setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
        setSCfmTp(JSPUtil.getParameter(request, prefix + "s_cfm_tp", ""));
        setGrpCfmSeq(JSPUtil.getParameter(request, prefix + "grp_cfm_seq", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LogisticsRevenueInvoiceVO[]
	 */
    public LogisticsRevenueInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LogisticsRevenueInvoiceVO[]
	 */
    public LogisticsRevenueInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        LogisticsRevenueInvoiceVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] sTotal = (JSPUtil.getParameter(request, prefix + "s_total", length));
            String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix + "s_vndr_cust_div_cd", length));
            String[] sCustSeq = (JSPUtil.getParameter(request, prefix + "s_cust_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sRevInvRt = (JSPUtil.getParameter(request, prefix + "s_rev_inv_rt", length));
            String[] sVndrCntCd = (JSPUtil.getParameter(request, prefix + "s_vndr_cnt_cd", length));
            String[] sN3ptyIfTpCd = (JSPUtil.getParameter(request, prefix + "s_n3pty_if_tp_cd", length));
            String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix + "s_n3pty_no", length));
            String[] sTax = (JSPUtil.getParameter(request, prefix + "s_tax", length));
            String[] sSrcInvNo = (JSPUtil.getParameter(request, prefix + "s_src_inv_no", length));
            String[] sSdate = (JSPUtil.getParameter(request, prefix + "s_sdate", length));
            String[] sCntrRtnYdCd = (JSPUtil.getParameter(request, prefix + "s_cntr_rtn_yd_cd", length));
            String[] sSrcVndrSeq = (JSPUtil.getParameter(request, prefix + "s_src_vndr_seq", length));
            String[] sTtlAmt = (JSPUtil.getParameter(request, prefix + "s_ttl_amt", length));
            String[] sEdate = (JSPUtil.getParameter(request, prefix + "s_edate", length));
            String[] sN3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix + "s_n3pty_expn_tp_cd", length));
            String[] sDtlRmk = (JSPUtil.getParameter(request, prefix + "s_dtl_rmk", length));
            String[] sNewBkg = (JSPUtil.getParameter(request, prefix + "s_new_bkg", length));
            String[] sSrcVndrCntCd = (JSPUtil.getParameter(request, prefix + "s_src_vndr_cnt_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] sReYdCd = (JSPUtil.getParameter(request, prefix + "s_re_yd_cd", length));
            String[] sYdCd = (JSPUtil.getParameter(request, prefix + "s_yd_cd", length));
            String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
            String[] sTaxAmt = (JSPUtil.getParameter(request, prefix + "s_tax_amt", length));
            String[] sDtlAmt = (JSPUtil.getParameter(request, prefix + "s_dtl_amt", length));
            String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix + "s_trd_party_val", length));
            String[] sVndrSeq = (JSPUtil.getParameter(request, prefix + "s_vndr_seq", length));
            String[] sLoclTaxAmt = (JSPUtil.getParameter(request, prefix + "s_locl_tax_amt", length));
            String[] sN2ndLoclTaxAmt = (JSPUtil.getParameter(request, prefix + "s_n2nd_locl_tax_amt", length));
            String[] sCurr = (JSPUtil.getParameter(request, prefix + "s_curr", length));
            String[] sUsrOfcCd = (JSPUtil.getParameter(request, prefix + "s_usr_ofc_cd", length));
            String[] sCustCntCd = (JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", length));
            String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", length));
            String[] sN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix + "s_n3pty_bil_tp_cd", length));
            String[] sUsrId = (JSPUtil.getParameter(request, prefix + "s_usr_id", length));
            String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix + "s_n3pty_inv_no", length));
            String[] sCntrRtnDt = (JSPUtil.getParameter(request, prefix + "s_cntr_rtn_dt", length));
            String[] sN3ptySrcNo = (JSPUtil.getParameter(request, prefix + "s_n3pty_src_no", length));
            String[] sBkgNo = (JSPUtil.getParameter(request, prefix + "s_bkg_no", length));
            String[] sCfmTp = (JSPUtil.getParameter(request, prefix + "s_cfm_tp", length));
	    	String[] grpCfmSeq = (JSPUtil.getParameter(request, prefix + "grp_cfm_seq", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new LogisticsRevenueInvoiceVO();
                if (sTotal[i] != null)
                    model.setSTotal(sTotal[i]);
                if (sVndrCustDivCd[i] != null)
                    model.setSVndrCustDivCd(sVndrCustDivCd[i]);
                if (sCustSeq[i] != null)
                    model.setSCustSeq(sCustSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sRevInvRt[i] != null)
                    model.setSRevInvRt(sRevInvRt[i]);
                if (sVndrCntCd[i] != null)
                    model.setSVndrCntCd(sVndrCntCd[i]);
                if (sN3ptyIfTpCd[i] != null)
                    model.setSN3ptyIfTpCd(sN3ptyIfTpCd[i]);
                if (sN3ptyNo[i] != null)
                    model.setSN3ptyNo(sN3ptyNo[i]);
                if (sTax[i] != null)
                    model.setSTax(sTax[i]);
                if (sSrcInvNo[i] != null)
                    model.setSSrcInvNo(sSrcInvNo[i]);
                if (sSdate[i] != null)
                    model.setSSdate(sSdate[i]);
                if (sCntrRtnYdCd[i] != null)
                    model.setSCntrRtnYdCd(sCntrRtnYdCd[i]);
                if (sSrcVndrSeq[i] != null)
                    model.setSSrcVndrSeq(sSrcVndrSeq[i]);
                if (sTtlAmt[i] != null)
                    model.setSTtlAmt(sTtlAmt[i]);
                if (sEdate[i] != null)
                    model.setSEdate(sEdate[i]);
                if (sN3ptyExpnTpCd[i] != null)
                    model.setSN3ptyExpnTpCd(sN3ptyExpnTpCd[i]);
                if (sDtlRmk[i] != null)
                    model.setSDtlRmk(sDtlRmk[i]);
                if (sNewBkg[i] != null)
                    model.setSNewBkg(sNewBkg[i]);
                if (sSrcVndrCntCd[i] != null)
                    model.setSSrcVndrCntCd(sSrcVndrCntCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (sReYdCd[i] != null)
                    model.setSReYdCd(sReYdCd[i]);
                if (sYdCd[i] != null)
                    model.setSYdCd(sYdCd[i]);
                if (eqNo[i] != null)
                    model.setEqNo(eqNo[i]);
                if (sTaxAmt[i] != null)
                    model.setSTaxAmt(sTaxAmt[i]);
                if (sDtlAmt[i] != null)
                    model.setSDtlAmt(sDtlAmt[i]);
                if (sTrdPartyVal[i] != null)
                    model.setSTrdPartyVal(sTrdPartyVal[i]);
                if (sVndrSeq[i] != null)
                    model.setSVndrSeq(sVndrSeq[i]);
                if (sLoclTaxAmt[i] != null)
                    model.setSLoclTaxAmt(sLoclTaxAmt[i]);
                if (sN2ndLoclTaxAmt[i] != null)
                    model.setSN2ndLoclTaxAmt(sN2ndLoclTaxAmt[i]);
                if (sCurr[i] != null)
                    model.setSCurr(sCurr[i]);
                if (sUsrOfcCd[i] != null)
                    model.setSUsrOfcCd(sUsrOfcCd[i]);
                if (sCustCntCd[i] != null)
                    model.setSCustCntCd(sCustCntCd[i]);
                if (sIfOfcCd[i] != null)
                    model.setSIfOfcCd(sIfOfcCd[i]);
                if (sN3ptyBilTpCd[i] != null)
                    model.setSN3ptyBilTpCd(sN3ptyBilTpCd[i]);
                if (sUsrId[i] != null)
                    model.setSUsrId(sUsrId[i]);
                if (sN3ptyInvNo[i] != null)
                    model.setSN3ptyInvNo(sN3ptyInvNo[i]);
                if (sCntrRtnDt[i] != null)
                    model.setSCntrRtnDt(sCntrRtnDt[i]);
                if (sN3ptySrcNo[i] != null)
                    model.setSN3ptySrcNo(sN3ptySrcNo[i]);
                if (sBkgNo[i] != null)
                    model.setSBkgNo(sBkgNo[i]);
                if (sCfmTp[i] != null) 
		    		model.setSCfmTp(sCfmTp[i]);
				if (grpCfmSeq[i] != null) 
		    		model.setGrpCfmSeq(grpCfmSeq[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getLogisticsRevenueInvoiceVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return LogisticsRevenueInvoiceVO[]
	 */
    public LogisticsRevenueInvoiceVO[] getLogisticsRevenueInvoiceVOs() {
        LogisticsRevenueInvoiceVO[] vos = (LogisticsRevenueInvoiceVO[]) models.toArray(new LogisticsRevenueInvoiceVO[models.size()]);
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
        this.sTotal = this.sTotal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrCustDivCd = this.sVndrCustDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustSeq = this.sCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sRevInvRt = this.sRevInvRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrCntCd = this.sVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyIfTpCd = this.sN3ptyIfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyNo = this.sN3ptyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTax = this.sTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSrcInvNo = this.sSrcInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSdate = this.sSdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCntrRtnYdCd = this.sCntrRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSrcVndrSeq = this.sSrcVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTtlAmt = this.sTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sEdate = this.sEdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyExpnTpCd = this.sN3ptyExpnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sDtlRmk = this.sDtlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sNewBkg = this.sNewBkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sSrcVndrCntCd = this.sSrcVndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sReYdCd = this.sReYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sYdCd = this.sYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTaxAmt = this.sTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sDtlAmt = this.sDtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sTrdPartyVal = this.sTrdPartyVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sVndrSeq = this.sVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sLoclTaxAmt = this.sLoclTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN2ndLoclTaxAmt = this.sN2ndLoclTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCurr = this.sCurr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sUsrOfcCd = this.sUsrOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCustCntCd = this.sCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sIfOfcCd = this.sIfOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyBilTpCd = this.sN3ptyBilTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sUsrId = this.sUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptyInvNo = this.sN3ptyInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCntrRtnDt = this.sCntrRtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sN3ptySrcNo = this.sN3ptySrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sBkgNo = this.sBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sCfmTp = this.sCfmTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grpCfmSeq = this.grpCfmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

