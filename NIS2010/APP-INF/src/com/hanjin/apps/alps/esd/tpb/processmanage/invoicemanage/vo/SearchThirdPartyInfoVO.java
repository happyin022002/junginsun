/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchThirdPartyInfoVO.java
*@FileTitle : SearchThirdPartyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.09.15 박성진 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchThirdPartyInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchThirdPartyInfoVO> models = new ArrayList<SearchThirdPartyInfoVO>();

    /* Column Info */
    private String vndrCustEml = null;

    /* Column Info */
    private String vndrCntCd = null;

    /* Column Info */
    private String phnNo = null;

    /* Column Info */
    private String engAddr = null;

    /* Column Info */
    private String trdPartyCode = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String rhqCd = null;

    /* Column Info */
    private String sheetSetCount = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String bilToLocDivCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vndrCustAddr2 = null;

    /* Column Info */
    private String vndrCustAddr = null;

    /* Column Info */
    private String vatXchRt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String vndrCustNm = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String faxNo = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String prcsCnt = null;

    /* Column Info */
    private String rgstNo = null;

    /* Column Info */
    private String steCd = null;

    /* Column Info */
    private String idaTaxSeq = null;

    /* Column Info */
    private String idaSteCd = null;

    /* Column Info */
    private String idaSteNm = null;

    /* Column Info */
    private String idaCgstRto = null;

    /* Column Info */
    private String idaSgstRto = null;

    /* Column Info */
    private String idaIgstRto = null;

    /* Column Info */
    private String idaUgstRto = null;

    /* Column Info */
    private String idaGstRgstNoFlg = null;

    /* Column Info */
    private String idaSpclEcnZnUtFlg = null;

    /* Column Info */
    private String idaGstRgstNo = null;

    /* Column Info */
    private String idaPanNo = null;

    /* Column Info */
    private String idaBankAcctNo = null;

    /* Column Info */
    private String idaIfscCd = null;

    /* Column Info */
    private String idaTotGstRto = null;

    /* Column Info */
    private String idaOfcGstRgstNo = null;

    /* Column Info */
    private String zipCd = null;

    /* Column Info */
    private String ctyNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchThirdPartyInfoVO() {
    }

    public SearchThirdPartyInfoVO(String ibflag, String pagerows, String engAddr, String vndrCntCd, String vndrSeq, String custCntCd, String custSeq, String trdPartyCode, String currCd, String faxNo, String phnNo, String vndrCustAddr, String vndrCustNm, String rhqCd, String vndrCustEml, String bilToLocDivCd, String sheetSetCount, String vatXchRt, String vndrCustAddr2, String prcsCnt, String rgstNo, String steCd, String idaTaxSeq, String idaSteCd, String idaSteNm, String idaCgstRto, String idaSgstRto, String idaIgstRto, String idaUgstRto, String idaGstRgstNoFlg, String idaSpclEcnZnUtFlg, String idaGstRgstNo, String idaPanNo, String idaBankAcctNo, String idaIfscCd, String idaTotGstRto, String idaOfcGstRgstNo, String zipCd, String ctyNm) {
        this.vndrCustEml = vndrCustEml;
        this.vndrCntCd = vndrCntCd;
        this.phnNo = phnNo;
        this.engAddr = engAddr;
        this.trdPartyCode = trdPartyCode;
        this.currCd = currCd;
        this.rhqCd = rhqCd;
        this.sheetSetCount = sheetSetCount;
        this.custSeq = custSeq;
        this.bilToLocDivCd = bilToLocDivCd;
        this.pagerows = pagerows;
        this.vndrCustAddr2 = vndrCustAddr2;
        this.vndrCustAddr = vndrCustAddr;
        this.vatXchRt = vatXchRt;
        this.ibflag = ibflag;
        this.vndrCustNm = vndrCustNm;
        this.vndrSeq = vndrSeq;
        this.faxNo = faxNo;
        this.custCntCd = custCntCd;
        this.prcsCnt = prcsCnt;
        this.rgstNo = rgstNo;
        this.steCd = steCd;
        this.idaTaxSeq = idaTaxSeq;
        this.idaSteCd = idaSteCd;
        this.idaSteNm = idaSteNm;
        this.idaCgstRto = idaCgstRto;
        this.idaSgstRto = idaSgstRto;
        this.idaIgstRto = idaIgstRto;
        this.idaUgstRto = idaUgstRto;
        this.idaGstRgstNoFlg = idaGstRgstNoFlg;
        this.idaSpclEcnZnUtFlg = idaSpclEcnZnUtFlg;
        this.idaGstRgstNo = idaGstRgstNo;
        this.idaPanNo = idaPanNo;
        this.idaBankAcctNo = idaBankAcctNo;
        this.idaIfscCd = idaIfscCd;
        this.idaTotGstRto = idaTotGstRto;
        this.idaOfcGstRgstNo = idaOfcGstRgstNo;
        this.zipCd = zipCd;
        this.ctyNm = ctyNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vndr_cust_eml", getVndrCustEml());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("phn_no", getPhnNo());
        this.hashColumns.put("eng_addr", getEngAddr());
        this.hashColumns.put("trd_party_code", getTrdPartyCode());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("rhq_cd", getRhqCd());
        this.hashColumns.put("sheet_set_count", getSheetSetCount());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vndr_cust_addr2", getVndrCustAddr2());
        this.hashColumns.put("vndr_cust_addr", getVndrCustAddr());
        this.hashColumns.put("vat_xch_rt", getVatXchRt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vndr_cust_nm", getVndrCustNm());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("fax_no", getFaxNo());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("prcs_cnt", getPrcsCnt());
        this.hashColumns.put("rgst_no", getRgstNo());
        this.hashColumns.put("ste_cd", getSteCd());
        this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
        this.hashColumns.put("ida_ste_cd", getIdaSteCd());
        this.hashColumns.put("ida_ste_nm", getIdaSteNm());
        this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
        this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
        this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
        this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
        this.hashColumns.put("ida_gst_rgst_no_flg", getIdaGstRgstNoFlg());
        this.hashColumns.put("ida_spcl_ecn_zn_ut_flg", getIdaSpclEcnZnUtFlg());
        this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
        this.hashColumns.put("ida_pan_no", getIdaPanNo());
        this.hashColumns.put("ida_bank_acct_no", getIdaBankAcctNo());
        this.hashColumns.put("ida_ifsc_cd", getIdaIfscCd());
        this.hashColumns.put("ida_tot_gst_rto", getIdaTotGstRto());
        this.hashColumns.put("ida_ofc_gst_rgst_no", getIdaOfcGstRgstNo());
        this.hashColumns.put("zip_cd", getZipCd());
        this.hashColumns.put("cty_nm", getCtyNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vndr_cust_eml", "vndrCustEml");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("phn_no", "phnNo");
        this.hashFields.put("eng_addr", "engAddr");
        this.hashFields.put("trd_party_code", "trdPartyCode");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("rhq_cd", "rhqCd");
        this.hashFields.put("sheet_set_count", "sheetSetCount");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vndr_cust_addr2", "vndrCustAddr2");
        this.hashFields.put("vndr_cust_addr", "vndrCustAddr");
        this.hashFields.put("vat_xch_rt", "vatXchRt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vndr_cust_nm", "vndrCustNm");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("fax_no", "faxNo");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("prcs_cnt", "prcsCnt");
        this.hashFields.put("rgst_no", "rgstNo");
        this.hashFields.put("ste_cd", "steCd");
        this.hashFields.put("ida_tax_seq", "idaTaxSeq");
        this.hashFields.put("ida_ste_cd", "idaSteCd");
        this.hashFields.put("ida_ste_nm", "idaSteNm");
        this.hashFields.put("ida_cgst_rto", "idaCgstRto");
        this.hashFields.put("ida_sgst_rto", "idaSgstRto");
        this.hashFields.put("ida_igst_rto", "idaIgstRto");
        this.hashFields.put("ida_ugst_rto", "idaUgstRto");
        this.hashFields.put("ida_gst_rgst_no_flg", "idaGstRgstNoFlg");
        this.hashFields.put("ida_spcl_ecn_zn_ut_flg", "idaSpclEcnZnUtFlg");
        this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
        this.hashFields.put("ida_pan_no", "idaPanNo");
        this.hashFields.put("ida_bank_acct_no", "idaBankAcctNo");
        this.hashFields.put("ida_ifsc_cd", "idaIfscCd");
        this.hashFields.put("ida_tot_gst_rto", "idaTotGstRto");
        this.hashFields.put("ida_ofc_gst_rgst_no", "idaOfcGstRgstNo");
        this.hashFields.put("zip_cd", "zipCd");
        this.hashFields.put("cty_nm", "ctyNm");
        return this.hashFields;
    }

    /**
	 * @return the idaOfcGstRgstNo
	 */
    public String getIdaOfcGstRgstNo() {
        return idaOfcGstRgstNo;
    }

    /**
	 * @param idaOfcGstRgstNo the idaOfcGstRgstNo to set
	 */
    public void setIdaOfcGstRgstNo(String idaOfcGstRgstNo) {
        this.idaOfcGstRgstNo = idaOfcGstRgstNo;
    }

    /**
	 * @return the idaTotGstRto
	 */
    public String getIdaTotGstRto() {
        return idaTotGstRto;
    }

    /**
	 * @param idaTotGstRto the idaTotGstRto to set
	 */
    public void setIdaTotGstRto(String idaTotGstRto) {
        this.idaTotGstRto = idaTotGstRto;
    }

    /**
	 * @return the steCd
	 */
    public String getSteCd() {
        return steCd;
    }

    /**
	 * @param steCd the steCd to set
	 */
    public void setSteCd(String steCd) {
        this.steCd = steCd;
    }

    /**
	 * @return the idaTaxSeq
	 */
    public String getIdaTaxSeq() {
        return idaTaxSeq;
    }

    /**
	 * @param idaTaxSeq the idaTaxSeq to set
	 */
    public void setIdaTaxSeq(String idaTaxSeq) {
        this.idaTaxSeq = idaTaxSeq;
    }

    /**
	 * @return the idaSteCd
	 */
    public String getIdaSteCd() {
        return idaSteCd;
    }

    /**
	 * @param idaSteCd the idaSteCd to set
	 */
    public void setIdaSteCd(String idaSteCd) {
        this.idaSteCd = idaSteCd;
    }

    /**
	 * @return the idaSteNm
	 */
    public String getIdaSteNm() {
        return idaSteNm;
    }

    /**
	 * @param idaSteNm the idaSteNm to set
	 */
    public void setIdaSteNm(String idaSteNm) {
        this.idaSteNm = idaSteNm;
    }

    /**
	 * @return the idaCgstRto
	 */
    public String getIdaCgstRto() {
        return idaCgstRto;
    }

    /**
	 * @param idaCgstRto the idaCgstRto to set
	 */
    public void setIdaCgstRto(String idaCgstRto) {
        this.idaCgstRto = idaCgstRto;
    }

    /**
	 * @return the idaSgstRto
	 */
    public String getIdaSgstRto() {
        return idaSgstRto;
    }

    /**
	 * @param idaSgstRto the idaSgstRto to set
	 */
    public void setIdaSgstRto(String idaSgstRto) {
        this.idaSgstRto = idaSgstRto;
    }

    /**
	 * @return the idaIgstRto
	 */
    public String getIdaIgstRto() {
        return idaIgstRto;
    }

    /**
	 * @param idaIgstRto the idaIgstRto to set
	 */
    public void setIdaIgstRto(String idaIgstRto) {
        this.idaIgstRto = idaIgstRto;
    }

    /**
	 * @return the idaUgstRto
	 */
    public String getIdaUgstRto() {
        return idaUgstRto;
    }

    /**
	 * @param idaUgstRto the idaUgstRto to set
	 */
    public void setIdaUgstRto(String idaUgstRto) {
        this.idaUgstRto = idaUgstRto;
    }

    /**
	 * @return the idaGstRgstNoFlg
	 */
    public String getIdaGstRgstNoFlg() {
        return idaGstRgstNoFlg;
    }

    /**
	 * @param idaGstRgstNoFlg the idaGstRgstNoFlg to set
	 */
    public void setIdaGstRgstNoFlg(String idaGstRgstNoFlg) {
        this.idaGstRgstNoFlg = idaGstRgstNoFlg;
    }

    /**
	 * @return the idaSpclEcnZnUtFlg
	 */
    public String getIdaSpclEcnZnUtFlg() {
        return idaSpclEcnZnUtFlg;
    }

    /**
	 * @param idaSpclEcnZnUtFlg the idaSpclEcnZnUtFlg to set
	 */
    public void setIdaSpclEcnZnUtFlg(String idaSpclEcnZnUtFlg) {
        this.idaSpclEcnZnUtFlg = idaSpclEcnZnUtFlg;
    }

    /**
	 * @return the idaGstRgstNo
	 */
    public String getIdaGstRgstNo() {
        return idaGstRgstNo;
    }

    /**
	 * @param idaGstRgstNo the idaGstRgstNo to set
	 */
    public void setIdaGstRgstNo(String idaGstRgstNo) {
        this.idaGstRgstNo = idaGstRgstNo;
    }

    /**
	 * @return the idaPanNo
	 */
    public String getIdaPanNo() {
        return idaPanNo;
    }

    /**
	 * @param idaPanNo the idaPanNo to set
	 */
    public void setIdaPanNo(String idaPanNo) {
        this.idaPanNo = idaPanNo;
    }

    /**
	 * @return the idaBankAcctNo
	 */
    public String getIdaBankAcctNo() {
        return idaBankAcctNo;
    }

    /**
	 * @param idaBankAcctNo the idaBankAcctNo to set
	 */
    public void setIdaBankAcctNo(String idaBankAcctNo) {
        this.idaBankAcctNo = idaBankAcctNo;
    }

    /**
	 * @return the idaIfscCd
	 */
    public String getIdaIfscCd() {
        return idaIfscCd;
    }

    /**
	 * @param idaIfscCd the idaIfscCd to set
	 */
    public void setIdaIfscCd(String idaIfscCd) {
        this.idaIfscCd = idaIfscCd;
    }

    /**
	 * Column Info
	 * @return vndrCustEml
	 */
    public String getVndrCustEml() {
        return this.vndrCustEml;
    }

    /**
	 * Column Info
	 * @return vndrCntCd
	 */
    public String getVndrCntCd() {
        return this.vndrCntCd;
    }

    /**
	 * Column Info
	 * @return phnNo
	 */
    public String getPhnNo() {
        return this.phnNo;
    }

    /**
	 * Column Info
	 * @return engAddr
	 */
    public String getEngAddr() {
        return this.engAddr;
    }

    /**
	 * Column Info
	 * @return trdPartyCode
	 */
    public String getTrdPartyCode() {
        return this.trdPartyCode;
    }

    /**
	 * Column Info
	 * @return currCd
	 */
    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Column Info
	 * @return rhqCd
	 */
    public String getRhqCd() {
        return this.rhqCd;
    }

    /**
	 * Column Info
	 * @return sheetSetCount
	 */
    public String getSheetSetCount() {
        return this.sheetSetCount;
    }

    /**
	 * Column Info
	 * @return custSeq
	 */
    public String getCustSeq() {
        return this.custSeq;
    }

    /**
	 * Column Info
	 * @return bilToLocDivCd
	 */
    public String getBilToLocDivCd() {
        return this.bilToLocDivCd;
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
	 * @return vndrCustAddr2
	 */
    public String getVndrCustAddr2() {
        return this.vndrCustAddr2;
    }

    /**
	 * Column Info
	 * @return vndrCustAddr
	 */
    public String getVndrCustAddr() {
        return this.vndrCustAddr;
    }

    /**
	 * Column Info
	 * @return vatXchRt
	 */
    public String getVatXchRt() {
        return this.vatXchRt;
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
	 * @return vndrCustNm
	 */
    public String getVndrCustNm() {
        return this.vndrCustNm;
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
	 * @return faxNo
	 */
    public String getFaxNo() {
        return this.faxNo;
    }

    /**
	 * Column Info
	 * @return custCntCd
	 */
    public String getCustCntCd() {
        return this.custCntCd;
    }

    /**
	 * Column Info
	 * @return getPrcsCnt
	 */
    public String getPrcsCnt() {
        return this.prcsCnt;
    }

    /**
	 * Column Info
	 * @return getRgstNo
	 */
    public String getRgstNo() {
        return this.rgstNo;
    }

    /**
	 * Column Info
	 * @param vndrCustEml
	 */
    public void setVndrCustEml(String vndrCustEml) {
        this.vndrCustEml = vndrCustEml;
    }

    /**
	 * Column Info
	 * @param vndrCntCd
	 */
    public void setVndrCntCd(String vndrCntCd) {
        this.vndrCntCd = vndrCntCd;
    }

    /**
	 * Column Info
	 * @param phnNo
	 */
    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    /**
	 * Column Info
	 * @param engAddr
	 */
    public void setEngAddr(String engAddr) {
        this.engAddr = engAddr;
    }

    /**
	 * Column Info
	 * @param trdPartyCode
	 */
    public void setTrdPartyCode(String trdPartyCode) {
        this.trdPartyCode = trdPartyCode;
    }

    /**
	 * Column Info
	 * @param currCd
	 */
    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    /**
	 * Column Info
	 * @param rhqCd
	 */
    public void setRhqCd(String rhqCd) {
        this.rhqCd = rhqCd;
    }

    /**
	 * Column Info
	 * @param sheetSetCount
	 */
    public void setSheetSetCount(String sheetSetCount) {
        this.sheetSetCount = sheetSetCount;
    }

    /**
	 * Column Info
	 * @param custSeq
	 */
    public void setCustSeq(String custSeq) {
        this.custSeq = custSeq;
    }

    /**
	 * Column Info
	 * @param bilToLocDivCd
	 */
    public void setBilToLocDivCd(String bilToLocDivCd) {
        this.bilToLocDivCd = bilToLocDivCd;
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
	 * @param vndrCustAddr2
	 */
    public void setVndrCustAddr2(String vndrCustAddr2) {
        this.vndrCustAddr2 = vndrCustAddr2;
    }

    /**
	 * Column Info
	 * @param vndrCustAddr
	 */
    public void setVndrCustAddr(String vndrCustAddr) {
        this.vndrCustAddr = vndrCustAddr;
    }

    /**
	 * Column Info
	 * @param vatXchRt
	 */
    public void setVatXchRt(String vatXchRt) {
        this.vatXchRt = vatXchRt;
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
	 * @param vndrCustNm
	 */
    public void setVndrCustNm(String vndrCustNm) {
        this.vndrCustNm = vndrCustNm;
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
	 * @param faxNo
	 */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    /**
	 * Column Info
	 * @param custCntCd
	 */
    public void setCustCntCd(String custCntCd) {
        this.custCntCd = custCntCd;
    }

    /**
	 * Column Info
	 * @param prcsCnt
	 */
    public void setPrcsCnt(String prcsCnt) {
        this.prcsCnt = prcsCnt;
    }

    /**
	 * Column Info
	 * @param rgstNo
	 */
    public void setRgstNo(String rgstNo) {
        this.rgstNo = rgstNo;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getZipCd() {
        return this.zipCd;
    }

    public void setCtyNm(String ctyNm) {
        this.ctyNm = ctyNm;
    }

    public String getCtyNm() {
        return this.ctyNm;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setVndrCustEml(JSPUtil.getParameter(request, "vndr_cust_eml", ""));
        setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
        setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
        setEngAddr(JSPUtil.getParameter(request, "eng_addr", ""));
        setTrdPartyCode(JSPUtil.getParameter(request, "trd_party_code", ""));
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
        setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
        setSheetSetCount(JSPUtil.getParameter(request, "sheet_set_count", ""));
        setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
        setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setVndrCustAddr2(JSPUtil.getParameter(request, "vndr_cust_addr2", ""));
        setVndrCustAddr(JSPUtil.getParameter(request, "vndr_cust_addr", ""));
        setVatXchRt(JSPUtil.getParameter(request, "vat_xch_rt", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVndrCustNm(JSPUtil.getParameter(request, "vndr_cust_nm", ""));
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setPrcsCnt(JSPUtil.getParameter(request, "prcs_cnt", ""));
        setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
        setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
        setIdaTaxSeq(JSPUtil.getParameter(request, "ida_tax_seq", ""));
        setIdaSteCd(JSPUtil.getParameter(request, "ida_ste_cd", ""));
        setIdaSteNm(JSPUtil.getParameter(request, "ida_ste_nm", ""));
        setIdaCgstRto(JSPUtil.getParameter(request, "ida_cgst_rto", ""));
        setIdaSgstRto(JSPUtil.getParameter(request, "ida_sgst_rto", ""));
        setIdaIgstRto(JSPUtil.getParameter(request, "ida_igst_rto", ""));
        setIdaUgstRto(JSPUtil.getParameter(request, "ida_ugst_rto", ""));
        setIdaGstRgstNoFlg(JSPUtil.getParameter(request, "ida_gst_rgst_no_flg", ""));
        setIdaSpclEcnZnUtFlg(JSPUtil.getParameter(request, "ida_spcl_ecn_zn_ut_flg", ""));
        setIdaGstRgstNo(JSPUtil.getParameter(request, "ida_gst_rgst_no", ""));
        setIdaPanNo(JSPUtil.getParameter(request, "ida_pan_no", ""));
        setIdaBankAcctNo(JSPUtil.getParameter(request, "ida_bank_acct_no", ""));
        setIdaIfscCd(JSPUtil.getParameter(request, "ida_ifsc_cd", ""));
        setIdaTotGstRto(JSPUtil.getParameter(request, "ida_tot_gst_rto", ""));
        setIdaOfcGstRgstNo(JSPUtil.getParameter(request, "ida_ofc_gst_rgst_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchThirdPartyInfoVO[]
	 */
    public SearchThirdPartyInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchThirdPartyInfoVO[]
	 */
    public SearchThirdPartyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchThirdPartyInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vndrCustEml = (JSPUtil.getParameter(request, prefix + "vndr_cust_eml", length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", length));
            String[] phnNo = (JSPUtil.getParameter(request, prefix + "phn_no", length));
            String[] engAddr = (JSPUtil.getParameter(request, prefix + "eng_addr", length));
            String[] trdPartyCode = (JSPUtil.getParameter(request, prefix + "trd_party_code", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] rhqCd = (JSPUtil.getParameter(request, prefix + "rhq_cd", length));
            String[] sheetSetCount = (JSPUtil.getParameter(request, prefix + "sheet_set_count", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vndrCustAddr2 = (JSPUtil.getParameter(request, prefix + "vndr_cust_addr2", length));
            String[] vndrCustAddr = (JSPUtil.getParameter(request, prefix + "vndr_cust_addr", length));
            String[] vatXchRt = (JSPUtil.getParameter(request, prefix + "vat_xch_rt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] vndrCustNm = (JSPUtil.getParameter(request, prefix + "vndr_cust_nm", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] faxNo = (JSPUtil.getParameter(request, prefix + "fax_no", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] prcsCnt = (JSPUtil.getParameter(request, prefix + "prcs_cnt", length));
            String[] rgstNo = (JSPUtil.getParameter(request, prefix + "rgst_no", length));
            String[] steCd = (JSPUtil.getParameter(request, prefix + "ste_cd", length));
            String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix + "ida_tax_seq", length));
            String[] idaSteCd = (JSPUtil.getParameter(request, prefix + "ida_ste_cd", length));
            String[] idaSteNm = (JSPUtil.getParameter(request, prefix + "ida_ste_nm", length));
            String[] idaCgstRto = (JSPUtil.getParameter(request, prefix + "ida_cgst_rto", length));
            String[] idaSgstRto = (JSPUtil.getParameter(request, prefix + "ida_sgst_rto", length));
            String[] idaIgstRto = (JSPUtil.getParameter(request, prefix + "ida_igst_rto", length));
            String[] idaUgstRto = (JSPUtil.getParameter(request, prefix + "ida_ugst_rto", length));
            String[] idaGstRgstNoFlg = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no_flg", length));
            String[] idaSpclEcnZnUtFlg = (JSPUtil.getParameter(request, prefix + "ida_spcl_ecn_zn_ut_flg", length));
            String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", length));
            String[] idaPanNo = (JSPUtil.getParameter(request, prefix + "ida_pan_no", length));
            String[] idaBankAcctNo = (JSPUtil.getParameter(request, prefix + "ida_bank_acct_no", length));
            String[] idaIfscCd = (JSPUtil.getParameter(request, prefix + "ida_ifsc_cd", length));
            String[] idaTotGstRto = (JSPUtil.getParameter(request, prefix + "ida_tot_gst_rto", length));
            String[] idaOfcGstRgstNo = (JSPUtil.getParameter(request, prefix + "ida_ofc_gst_rgst_no", length));
            String[] zipCd = (JSPUtil.getParameter(request, prefix + "zip_cd", length));
	    	String[] ctyNm = (JSPUtil.getParameter(request, prefix + "cty_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchThirdPartyInfoVO();
                if (vndrCustEml[i] != null)
                    model.setVndrCustEml(vndrCustEml[i]);
                if (vndrCntCd[i] != null)
                    model.setVndrCntCd(vndrCntCd[i]);
                if (phnNo[i] != null)
                    model.setPhnNo(phnNo[i]);
                if (engAddr[i] != null)
                    model.setEngAddr(engAddr[i]);
                if (trdPartyCode[i] != null)
                    model.setTrdPartyCode(trdPartyCode[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (rhqCd[i] != null)
                    model.setRhqCd(rhqCd[i]);
                if (sheetSetCount[i] != null)
                    model.setSheetSetCount(sheetSetCount[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (bilToLocDivCd[i] != null)
                    model.setBilToLocDivCd(bilToLocDivCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vndrCustAddr2[i] != null)
                    model.setVndrCustAddr2(vndrCustAddr2[i]);
                if (vndrCustAddr[i] != null)
                    model.setVndrCustAddr(vndrCustAddr[i]);
                if (vatXchRt[i] != null)
                    model.setVatXchRt(vatXchRt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vndrCustNm[i] != null)
                    model.setVndrCustNm(vndrCustNm[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (faxNo[i] != null)
                    model.setFaxNo(faxNo[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (prcsCnt[i] != null)
                    model.setPrcsCnt(prcsCnt[i]);
                if (rgstNo[i] != null)
                    model.setRgstNo(rgstNo[i]);
                if (steCd[i] != null)
                    model.setSteCd(steCd[i]);
                if (idaTaxSeq[i] != null)
                    model.setIdaTaxSeq(idaTaxSeq[i]);
                if (idaSteCd[i] != null)
                    model.setIdaSteCd(idaSteCd[i]);
                if (idaSteNm[i] != null)
                    model.setIdaSteNm(idaSteNm[i]);
                if (idaCgstRto[i] != null)
                    model.setIdaCgstRto(idaCgstRto[i]);
                if (idaSgstRto[i] != null)
                    model.setIdaSgstRto(idaSgstRto[i]);
                if (idaIgstRto[i] != null)
                    model.setIdaIgstRto(idaIgstRto[i]);
                if (idaUgstRto[i] != null)
                    model.setIdaUgstRto(idaUgstRto[i]);
                if (idaGstRgstNoFlg[i] != null)
                    model.setIdaGstRgstNoFlg(idaGstRgstNoFlg[i]);
                if (idaSpclEcnZnUtFlg[i] != null)
                    model.setIdaSpclEcnZnUtFlg(idaSpclEcnZnUtFlg[i]);
                if (idaGstRgstNo[i] != null)
                    model.setIdaGstRgstNo(idaGstRgstNo[i]);
                if (idaPanNo[i] != null)
                    model.setIdaPanNo(idaPanNo[i]);
                if (idaBankAcctNo[i] != null)
                    model.setIdaBankAcctNo(idaBankAcctNo[i]);
                if (idaIfscCd[i] != null)
                    model.setIdaIfscCd(idaIfscCd[i]);
                if (idaTotGstRto[i] != null)
                    model.setIdaTotGstRto(idaTotGstRto[i]);
                if (idaOfcGstRgstNo[i] != null)
                    model.setIdaOfcGstRgstNo(idaOfcGstRgstNo[i]);
                if (zipCd[i] != null) 
		    		model.setZipCd(zipCd[i]);
				if (ctyNm[i] != null) 
		    		model.setCtyNm(ctyNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchThirdPartyInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchThirdPartyInfoVO[]
	 */
    public SearchThirdPartyInfoVO[] getSearchThirdPartyInfoVOs() {
        SearchThirdPartyInfoVO[] vos = (SearchThirdPartyInfoVO[]) models.toArray(new SearchThirdPartyInfoVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.vndrCustEml = this.vndrCustEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.engAddr = this.engAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdPartyCode = this.trdPartyCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rhqCd = this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sheetSetCount = this.sheetSetCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilToLocDivCd = this.bilToLocDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCustAddr2 = this.vndrCustAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCustAddr = this.vndrCustAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vatXchRt = this.vatXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCustNm = this.vndrCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.faxNo = this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcsCnt = this.prcsCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgstNo = this.rgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTaxSeq = this.idaTaxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteCd = this.idaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSteNm = this.idaSteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaCgstRto = this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSgstRto = this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIgstRto = this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaUgstRto = this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNoFlg = this.idaGstRgstNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaSpclEcnZnUtFlg = this.idaSpclEcnZnUtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaGstRgstNo = this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaPanNo = this.idaPanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaBankAcctNo = this.idaBankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaIfscCd = this.idaIfscCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaTotGstRto = this.idaTotGstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.idaOfcGstRgstNo = this.idaOfcGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.zipCd = this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctyNm = this.ctyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
