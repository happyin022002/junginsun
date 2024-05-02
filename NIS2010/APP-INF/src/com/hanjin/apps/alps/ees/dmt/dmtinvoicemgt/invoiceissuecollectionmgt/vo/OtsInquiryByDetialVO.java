/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtsInquiryByDetialVO.java
*@FileTitle : OtsInquiryByDetialVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.06  
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
public class OtsInquiryByDetialVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OtsInquiryByDetialVO> models = new ArrayList<OtsInquiryByDetialVO>();

    /* Column Info */
    private String isseof = null;

    /* Column Info */
    private String blnooo = null;

    /* Column Info */
    private String bilamt = null;

    /* Column Info */
    private String payrcd = null;

    /* Column Info */
    private String tarftp = null;

    /* Column Info */
    private String comamt = null;

    /* Column Info */
    private String invnoo = null;

    /* Column Info */
    private String issedt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String invamt = null;

    /* Column Info */
    private String currcy = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sheetp = null;

    /* Column Info */
    private String taxamt = null;

    /* Column Info */
    private String invovd = null;

    /* Column Info */
    private String bkgnoo = null;

    /* Column Info */
    private String vvdcdd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String obSrepCd = null;

    /* Column Info */
    private String orgChgAmt = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String shCustCd = null;

    /* Column Info */
    private String shCustNm = null;

    /* Column Info */
    private String cnCustCd = null;

    /* Column Info */
    private String cnCustNm = null;

    /* Column Info */
    private String cmdtExptAmt = null;

    /* Column Info */
    private String scRfaExptAmt = null;

    /* Column Info */
    private String aftExptDcAmt = null;

    /* Column Info */
    private String invRmk = null;

    /* Column Info */
    private String dmdtVtInvStsCd = null;

    /* Column Info */
    private String dmdtVtInvNo = null;

    /* Column Info */
    private String dmdtVtInvYn = null;

    /* Column Info */
    private String colCharge = null;

    /* Column Info */
    private String colTax = null;

    /* Column Info */
    private String colDate = null;

    /* Column Info */
    private String uncolAmt = null;

    /* Column Info */
    private String otsCltFlg = null;

    public String getOtsCltFlg() {
        return otsCltFlg;
    }

    public void setOtsCltFlg(String otsCltFlg) {
        this.otsCltFlg = otsCltFlg;
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

    public String getUncolAmt() {
        return uncolAmt;
    }

    public void setUncolAmt(String uncolAmt) {
        this.uncolAmt = uncolAmt;
    }

    /* Column Info */
    private String dmdtInvTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public OtsInquiryByDetialVO() {
    }

    public OtsInquiryByDetialVO(String ibflag, String pagerows, String isseof, String blnooo, String bilamt, String payrcd, String tarftp, String comamt, String invnoo, String issedt, String invamt, String currcy, String sheetp, String taxamt, String invovd, String bkgnoo, String vvdcdd, String porCd, String polCd, String podCd, String delCd, String obSrepCd, String orgChgAmt, String rfaNo, String scNo, String taaNo, String shCustCd, String shCustNm, String cnCustCd, String cnCustNm, String cmdtExptAmt, String scRfaExptAmt, String aftExptDcAmt, String invRmk, String dmdtVtInvStsCd, String dmdtVtInvNo, String dmdtVtInvYn, String colCharge, String colTax, String colDate, String uncolAmt, String otsCltFlg, String dmdtInvTpCd) {
        this.isseof = isseof;
        this.blnooo = blnooo;
        this.bilamt = bilamt;
        this.payrcd = payrcd;
        this.tarftp = tarftp;
        this.comamt = comamt;
        this.invnoo = invnoo;
        this.issedt = issedt;
        this.pagerows = pagerows;
        this.invamt = invamt;
        this.currcy = currcy;
        this.ibflag = ibflag;
        this.sheetp = sheetp;
        this.taxamt = taxamt;
        this.invovd = invovd;
        this.bkgnoo = bkgnoo;
        this.vvdcdd = vvdcdd;
        this.podCd = podCd;
        this.porCd = porCd;
        this.polCd = polCd;
        this.delCd = delCd;
        this.orgChgAmt = orgChgAmt;
        this.rfaNo = rfaNo;
        this.scNo = scNo;
        this.taaNo = taaNo;
        this.shCustCd = shCustCd;
        this.shCustNm = shCustNm;
        this.cnCustCd = cnCustCd;
        this.cnCustNm = cnCustNm;
        this.cmdtExptAmt = cmdtExptAmt;
        this.scRfaExptAmt = scRfaExptAmt;
        this.aftExptDcAmt = aftExptDcAmt;
        this.invRmk = invRmk;
        this.dmdtVtInvStsCd = dmdtVtInvStsCd;
        this.dmdtVtInvNo = dmdtVtInvNo;
        this.dmdtVtInvYn = dmdtVtInvYn;
        this.colCharge = colCharge;
        this.colTax = colTax;
        this.colDate = colDate;
        this.uncolAmt = uncolAmt;
        this.otsCltFlg = otsCltFlg;
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("isseof", getIsseof());
        this.hashColumns.put("blnooo", getBlnooo());
        this.hashColumns.put("bilamt", getBilamt());
        this.hashColumns.put("payrcd", getPayrcd());
        this.hashColumns.put("tarftp", getTarftp());
        this.hashColumns.put("comamt", getComamt());
        this.hashColumns.put("invnoo", getInvnoo());
        this.hashColumns.put("issedt", getIssedt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("invamt", getInvamt());
        this.hashColumns.put("currcy", getCurrcy());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("sheetp", getSheetp());
        this.hashColumns.put("taxamt", getTaxamt());
        this.hashColumns.put("invovd", getInvovd());
        this.hashColumns.put("bkgnoo", getBkgnoo());
        this.hashColumns.put("vvdcdd", getVvdcdd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("org_chg_amt", getOrgChgAmt());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("sh_cust_cd", getShCustCd());
        this.hashColumns.put("sh_cust_nm", getShCustNm());
        this.hashColumns.put("cn_cust_cd", getCnCustCd());
        this.hashColumns.put("cn_cust_nm", getCnCustNm());
        this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
        this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
        this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
        this.hashColumns.put("inv_rmk", getInvRmk());
        this.hashColumns.put("dmdt_vt_inv_sts_cd", getDmdtVtInvStsCd());
        this.hashColumns.put("dmdt_vt_inv_no", getDmdtVtInvNo());
        this.hashColumns.put("dmdt_vt_inv_yn", getDmdtVtInvYn());
        this.hashColumns.put("col_charge", getColCharge());
        this.hashColumns.put("col_tax", getColTax());
        this.hashColumns.put("col_date", getColDate());
        this.hashColumns.put("uncol_amt", getUncolAmt());
        this.hashColumns.put("ots_clt_flg", getOtsCltFlg());
        this.hashColumns.put("dmdt_inv_tp_cd", getDmdtInvTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("isseof", "isseof");
        this.hashFields.put("blnooo", "blnooo");
        this.hashFields.put("bilamt", "bilamt");
        this.hashFields.put("payrcd", "payrcd");
        this.hashFields.put("tarftp", "tarftp");
        this.hashFields.put("comamt", "comamt");
        this.hashFields.put("invnoo", "invnoo");
        this.hashFields.put("issedt", "issedt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("invamt", "invamt");
        this.hashFields.put("currcy", "currcy");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("sheetp", "sheetp");
        this.hashFields.put("taxamt", "taxamt");
        this.hashFields.put("invovd", "invovd");
        this.hashFields.put("bkgnoo", "bkgnoo");
        this.hashFields.put("vvdcdd", "vvdcdd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("org_chg_amt", "orgChgAmt");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("sh_cust_cd", "shCustCd");
        this.hashFields.put("sh_cust_nm", "shCustNm");
        this.hashFields.put("cn_cust_cd", "cnCustCd");
        this.hashFields.put("cn_cust_nm", "cnCustNm");
        this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
        this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
        this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
        this.hashFields.put("inv_rmk", "invRmk");
        this.hashFields.put("dmdt_vt_inv_sts_cd", "dmdtVtInvStsCd");
        this.hashFields.put("dmdt_vt_inv_no", "dmdtVtInvNo");
        this.hashFields.put("dmdt_vt_inv_yn", "dmdtVtInvYn");
        this.hashFields.put("col_charge", "colCharge");
        this.hashFields.put("col_tax", "colTax");
        this.hashFields.put("col_date", "colDate");
        this.hashFields.put("uncol_amt", "uncolAmt");
        this.hashFields.put("ots_clt_flg", "otsCltFlg");
        this.hashFields.put("dmdt_inv_tp_cd", "dmdtInvTpCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return isseof
	 */
    public String getIsseof() {
        return this.isseof;
    }

    /**
	 * Column Info
	 * @return blnooo
	 */
    public String getBlnooo() {
        return this.blnooo;
    }

    /**
	 * Column Info
	 * @return bilamt
	 */
    public String getBilamt() {
        return this.bilamt;
    }

    /**
	 * Column Info
	 * @return payrcd
	 */
    public String getPayrcd() {
        return this.payrcd;
    }

    /**
	 * Column Info
	 * @return tarftp
	 */
    public String getTarftp() {
        return this.tarftp;
    }

    /**
	 * Column Info
	 * @return comamt
	 */
    public String getComamt() {
        return this.comamt;
    }

    /**
	 * Column Info
	 * @return invnoo
	 */
    public String getInvnoo() {
        return this.invnoo;
    }

    /**
	 * Column Info
	 * @return issedt
	 */
    public String getIssedt() {
        return this.issedt;
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
	 * @return invamt
	 */
    public String getInvamt() {
        return this.invamt;
    }

    /**
	 * Column Info
	 * @return currcy
	 */
    public String getCurrcy() {
        return this.currcy;
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
	 * @return sheetp
	 */
    public String getSheetp() {
        return this.sheetp;
    }

    /**
	 * Column Info
	 * @return taxamt
	 */
    public String getTaxamt() {
        return this.taxamt;
    }

    /**
	 * Column Info
	 * @return invovd
	 */
    public String getInvovd() {
        return this.invovd;
    }

    /**
	 * Column Info
	 * @return bkgnoo
	 */
    public String getBkgnoo() {
        return this.bkgnoo;
    }

    /**
	 * Column Info
	 * @return vvdcdd
	 */
    public String getVvdcdd() {
        return this.vvdcdd;
    }

    /**
	 * Column Info
	 * @return obSrepCd
	 */
    public String getObSrepCd() {
        return this.obSrepCd;
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

    public String getDelCd() {
        return delCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public void setDelCd(String delCd) {
        this.delCd = delCd;
    }

    /**
	 * Column Info
	 * @param isseof
	 */
    public void setIsseof(String isseof) {
        this.isseof = isseof;
    }

    /**
	 * Column Info
	 * @param blnooo
	 */
    public void setBlnooo(String blnooo) {
        this.blnooo = blnooo;
    }

    /**
	 * Column Info
	 * @param bilamt
	 */
    public void setBilamt(String bilamt) {
        this.bilamt = bilamt;
    }

    /**
	 * Column Info
	 * @param payrcd
	 */
    public void setPayrcd(String payrcd) {
        this.payrcd = payrcd;
    }

    /**
	 * Column Info
	 * @param tarftp
	 */
    public void setTarftp(String tarftp) {
        this.tarftp = tarftp;
    }

    /**
	 * Column Info
	 * @param comamt
	 */
    public void setComamt(String comamt) {
        this.comamt = comamt;
    }

    /**
	 * Column Info
	 * @param invnoo
	 */
    public void setInvnoo(String invnoo) {
        this.invnoo = invnoo;
    }

    /**
	 * Column Info
	 * @param issedt
	 */
    public void setIssedt(String issedt) {
        this.issedt = issedt;
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
	 * @param invamt
	 */
    public void setInvamt(String invamt) {
        this.invamt = invamt;
    }

    /**
	 * Column Info
	 * @param currcy
	 */
    public void setCurrcy(String currcy) {
        this.currcy = currcy;
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
	 * @param sheetp
	 */
    public void setSheetp(String sheetp) {
        this.sheetp = sheetp;
    }

    /**
	 * Column Info
	 * @param taxamt
	 */
    public void setTaxamt(String taxamt) {
        this.taxamt = taxamt;
    }

    /**
	 * Column Info
	 * @param invovd
	 */
    public void setInvovd(String invovd) {
        this.invovd = invovd;
    }

    /**
	 * Column Info
	 * @param bkgnoo
	 */
    public void setBkgnoo(String bkgnoo) {
        this.bkgnoo = bkgnoo;
    }

    /**
	 * Column Info
	 * @param vvdcdd
	 */
    public void setVvdcdd(String vvdcdd) {
        this.vvdcdd = vvdcdd;
    }

    /**
	 * Column Info
	 * @param obSrepCd
	 */
    public void setObSrepCd(String obSrepCd) {
        this.obSrepCd = obSrepCd;
    }

    public String getOrgChgAmt() {
        return orgChgAmt;
    }

    public void setOrgChgAmt(String orgChgAmt) {
        this.orgChgAmt = orgChgAmt;
    }

    public String getRfaNo() {
        return rfaNo;
    }

    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
    }

    public String getScNo() {
        return scNo;
    }

    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    public String getTaaNo() {
        return taaNo;
    }

    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
    }

    public String getShCustCd() {
        return shCustCd;
    }

    public void setShCustCd(String shCustCd) {
        this.shCustCd = shCustCd;
    }

    public String getShCustNm() {
        return shCustNm;
    }

    public void setShCustNm(String shCustNm) {
        this.shCustNm = shCustNm;
    }

    public String getCnCustCd() {
        return cnCustCd;
    }

    public void setCnCustCd(String cnCustCd) {
        this.cnCustCd = cnCustCd;
    }

    public String getCnCustNm() {
        return cnCustNm;
    }

    public void setCnCustNm(String cnCustNm) {
        this.cnCustNm = cnCustNm;
    }

    public String getScRfaExptAmt() {
        return scRfaExptAmt;
    }

    public void setScRfaExptAmt(String scRfaExptAmt) {
        this.scRfaExptAmt = scRfaExptAmt;
    }

    public String getAftExptDcAmt() {
        return aftExptDcAmt;
    }

    public void setAftExptDcAmt(String aftExptDcAmt) {
        this.aftExptDcAmt = aftExptDcAmt;
    }

    public String getInvRmk() {
        return invRmk;
    }

    public void setInvRmk(String invRmk) {
        this.invRmk = invRmk;
    }

    public String getCmdtExptAmt() {
        return cmdtExptAmt;
    }

    public void setCmdtExptAmt(String cmdtExptAmt) {
        this.cmdtExptAmt = cmdtExptAmt;
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

    public void setDmdtInvTpCd(String dmdtInvTpCd) {
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    public String getDmdtInvTpCd() {
        return this.dmdtInvTpCd;
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
        setIsseof(JSPUtil.getParameter(request, prefix + "isseof", ""));
        setBlnooo(JSPUtil.getParameter(request, prefix + "blnooo", ""));
        setBilamt(JSPUtil.getParameter(request, prefix + "bilamt", ""));
        setPayrcd(JSPUtil.getParameter(request, prefix + "payrcd", ""));
        setTarftp(JSPUtil.getParameter(request, prefix + "tarftp", ""));
        setComamt(JSPUtil.getParameter(request, prefix + "comamt", ""));
        setInvnoo(JSPUtil.getParameter(request, prefix + "invnoo", ""));
        setIssedt(JSPUtil.getParameter(request, prefix + "issedt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setInvamt(JSPUtil.getParameter(request, prefix + "invamt", ""));
        setCurrcy(JSPUtil.getParameter(request, prefix + "currcy", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSheetp(JSPUtil.getParameter(request, prefix + "sheetp", ""));
        setTaxamt(JSPUtil.getParameter(request, prefix + "taxamt", ""));
        setInvovd(JSPUtil.getParameter(request, prefix + "invovd", ""));
        setBkgnoo(JSPUtil.getParameter(request, prefix + "bkgnoo", ""));
        setVvdcdd(JSPUtil.getParameter(request, prefix + "vvdcdd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setShCustCd(JSPUtil.getParameter(request, prefix + "sh_cust_cd", ""));
        setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
        setCnCustCd(JSPUtil.getParameter(request, prefix + "cn_cust_cd", ""));
        setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
        setCmdtExptAmt(JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", ""));
        setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
        setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
        setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
        setDmdtVtInvStsCd(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_sts_cd", ""));
        setDmdtVtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_no", ""));
        setDmdtVtInvYn(JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_yn", ""));
        setColCharge(JSPUtil.getParameter(request, prefix + "col_charge", ""));
        setColTax(JSPUtil.getParameter(request, prefix + "col_tax", ""));
        setColDate(JSPUtil.getParameter(request, prefix + "col_date", ""));
        setUncolAmt(JSPUtil.getParameter(request, prefix + "uncol_amt", ""));
        setOtsCltFlg(JSPUtil.getParameter(request, "ots_clt_flg", ""));
        setDmdtInvTpCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryByDetialVO[]
	 */
    public OtsInquiryByDetialVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryByDetialVO[]
	 */
    public OtsInquiryByDetialVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OtsInquiryByDetialVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] isseof = (JSPUtil.getParameter(request, prefix + "isseof", length));
            String[] blnooo = (JSPUtil.getParameter(request, prefix + "blnooo", length));
            String[] bilamt = (JSPUtil.getParameter(request, prefix + "bilamt", length));
            String[] payrcd = (JSPUtil.getParameter(request, prefix + "payrcd", length));
            String[] tarftp = (JSPUtil.getParameter(request, prefix + "tarftp", length));
            String[] comamt = (JSPUtil.getParameter(request, prefix + "comamt", length));
            String[] invnoo = (JSPUtil.getParameter(request, prefix + "invnoo", length));
            String[] issedt = (JSPUtil.getParameter(request, prefix + "issedt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] invamt = (JSPUtil.getParameter(request, prefix + "invamt", length));
            String[] currcy = (JSPUtil.getParameter(request, prefix + "currcy", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sheetp = (JSPUtil.getParameter(request, prefix + "sheetp", length));
            String[] taxamt = (JSPUtil.getParameter(request, prefix + "taxamt", length));
            String[] invovd = (JSPUtil.getParameter(request, prefix + "invovd", length));
            String[] bkgnoo = (JSPUtil.getParameter(request, prefix + "bkgnoo", length));
            String[] vvdcdd = (JSPUtil.getParameter(request, prefix + "vvdcdd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
            String[] orgChgAmt = (JSPUtil.getParameter(request, prefix + "org_chg_amt", length));
            String[] rfaNO = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] shCustCd = (JSPUtil.getParameter(request, prefix + "sh_cust_cd", length));
            String[] shCustNm = (JSPUtil.getParameter(request, prefix + "sh_cust_nm", length));
            String[] cnCustCd = (JSPUtil.getParameter(request, prefix + "cn_cust_cd", length));
            String[] cnCustNm = (JSPUtil.getParameter(request, prefix + "cn_cust_nm", length));
            String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", length));
            String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", length));
            String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", length));
            String[] invRmk = (JSPUtil.getParameter(request, prefix + "inv_rmk", length));
            String[] dmdtVtInvStsCd = (JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_sts_cd", length));
            String[] dmdtVtInvNo = (JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_no", length));
            String[] dmdtVtInvYn = (JSPUtil.getParameter(request, prefix + "dmdt_vt_inv_yn", length));
            String[] colCharge = (JSPUtil.getParameter(request, prefix + "col_charge", length));
            String[] colTax = (JSPUtil.getParameter(request, prefix + "col_tax", length));
            String[] colDate = (JSPUtil.getParameter(request, prefix + "col_date", length));
            String[] uncolAmt = (JSPUtil.getParameter(request, prefix + "uncol_amt", length));
            String[] otsCltFlg = (JSPUtil.getParameter(request, prefix + "ots_clt_flg", length));
            String[] dmdtInvTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OtsInquiryByDetialVO();
                if (isseof[i] != null)
                    model.setIsseof(isseof[i]);
                if (blnooo[i] != null)
                    model.setBlnooo(blnooo[i]);
                if (bilamt[i] != null)
                    model.setBilamt(bilamt[i]);
                if (payrcd[i] != null)
                    model.setPayrcd(payrcd[i]);
                if (tarftp[i] != null)
                    model.setTarftp(tarftp[i]);
                if (comamt[i] != null)
                    model.setComamt(comamt[i]);
                if (invnoo[i] != null)
                    model.setInvnoo(invnoo[i]);
                if (issedt[i] != null)
                    model.setIssedt(issedt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (invamt[i] != null)
                    model.setInvamt(invamt[i]);
                if (currcy[i] != null)
                    model.setCurrcy(currcy[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sheetp[i] != null)
                    model.setSheetp(sheetp[i]);
                if (taxamt[i] != null)
                    model.setTaxamt(taxamt[i]);
                if (invovd[i] != null)
                    model.setInvovd(invovd[i]);
                if (bkgnoo[i] != null)
                    model.setBkgnoo(bkgnoo[i]);
                if (vvdcdd[i] != null)
                    model.setVvdcdd(vvdcdd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (orgChgAmt[i] != null)
                    model.setOrgChgAmt(orgChgAmt[i]);
                if (rfaNO[i] != null)
                    model.setRfaNo(rfaNO[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (shCustCd[i] != null)
                    model.setShCustCd(shCustCd[i]);
                if (shCustNm[i] != null)
                    model.setShCustNm(shCustNm[i]);
                if (cnCustCd[i] != null)
                    model.setCnCustCd(cnCustCd[i]);
                if (cnCustNm[i] != null)
                    model.setCnCustNm(cnCustNm[i]);
                if (cmdtExptAmt[i] != null)
                    model.setCmdtExptAmt(cmdtExptAmt[i]);
                if (scRfaExptAmt[i] != null)
                    model.setScRfaExptAmt(scRfaExptAmt[i]);
                if (aftExptDcAmt[i] != null)
                    model.setAftExptDcAmt(aftExptDcAmt[i]);
                if (invRmk[i] != null)
                    model.setInvRmk(invRmk[i]);
                if (dmdtVtInvStsCd[i] != null)
                    model.setDmdtVtInvStsCd(dmdtVtInvStsCd[i]);
                if (dmdtVtInvNo[i] != null)
                    model.setDmdtVtInvNo(dmdtVtInvNo[i]);
                if (dmdtVtInvYn[i] != null)
                    model.setDmdtVtInvYn(dmdtVtInvYn[i]);
                if (colCharge[i] != null)
                    model.setColCharge(colCharge[i]);
                if (colTax[i] != null)
                    model.setColTax(colTax[i]);
                if (colDate[i] != null)
                    model.setColDate(colDate[i]);
                if (uncolAmt[i] != null)
                    model.setUncolAmt(uncolAmt[i]);
                if (otsCltFlg[i] != null)
                    model.setOtsCltFlg(otsCltFlg[i]);
                if (dmdtInvTpCd[i] != null) 
		    		model.setDmdtInvTpCd(dmdtInvTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOtsInquiryByDetialVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OtsInquiryByDetialVO[]
	 */
    public OtsInquiryByDetialVO[] getOtsInquiryByDetialVOs() {
        OtsInquiryByDetialVO[] vos = (OtsInquiryByDetialVO[]) models.toArray(new OtsInquiryByDetialVO[models.size()]);
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
        this.isseof = this.isseof.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blnooo = this.blnooo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilamt = this.bilamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payrcd = this.payrcd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tarftp = this.tarftp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.comamt = this.comamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invnoo = this.invnoo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issedt = this.issedt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invamt = this.invamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currcy = this.currcy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sheetp = this.sheetp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxamt = this.taxamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invovd = this.invovd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgnoo = this.bkgnoo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdcdd = this.vvdcdd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgChgAmt = this.orgChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCustCd = this.shCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCustNm = this.shCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnCustCd = this.cnCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnCustNm = this.cnCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtExptAmt = this.cmdtExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scRfaExptAmt = this.scRfaExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftExptDcAmt = this.aftExptDcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk = this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtVtInvStsCd = this.dmdtVtInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtVtInvNo = this.dmdtVtInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtVtInvYn = this.dmdtVtInvYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colCharge = this.colCharge.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colTax = this.colTax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.colDate = this.colDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.uncolAmt = this.uncolAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.otsCltFlg = this.otsCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvTpCd = this.dmdtInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
