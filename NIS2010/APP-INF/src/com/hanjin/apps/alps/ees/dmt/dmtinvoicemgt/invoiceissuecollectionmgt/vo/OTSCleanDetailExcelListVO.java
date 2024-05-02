/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OTSCleanDetailExcelListVO.java
*@FileTitle : OTSCleanDetailExcelListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.12  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
public class OTSCleanDetailExcelListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<OTSCleanDetailExcelListVO> models = new ArrayList<OTSCleanDetailExcelListVO>();

    /* Column Info */
    private String bzcTrfCurrCd = null;

    /* Column Info */
    private String cnCustCd = null;

    /* Column Info */
    private String isseof = null;

    /* Column Info */
    private String aftExptDcAmt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String obSrepCd = null;

    /* Column Info */
    private String fxFtOvrDys = null;

    /* Column Info */
    private String currcy = null;

    /* Column Info */
    private String chgCurrCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String issudt = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String arIfDt = null;

    /* Column Info */
    private String bkgnoo = null;

    /* Column Info */
    private String ibSrepCd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String tarftp = null;

    /* Column Info */
    private String ftCmncDt = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String shCustNm = null;

    /* Column Info */
    private String fmMvmtDt = null;

    /* Column Info */
    private String dmdtArIfCd = null;

    /* Column Info */
    private String calcBilAmt = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String scRfaExptAmt = null;

    /* Column Info */
    private String netExptAmt = null;

    /* Column Info */
    private String issedt = null;

    /* Column Info */
    private String invamt = null;

    /* Column Info */
    private String rfaNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String oveday = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String nfCustCd = null;

    /* Column Info */
    private String invovd = null;

    /* Column Info */
    private String ftEndDt = null;

    /* Column Info */
    private String cmdtExptAmt = null;

    /* Column Info */
    private String toMvmtDt = null;

    /* Column Info */
    private String vvdcdd = null;

    /* Column Info */
    private String nfCustNm = null;

    /* Column Info */
    private String ibSlsOfcCd = null;

    /* Column Info */
    private String fmMvmtYdCd = null;

    /* Column Info */
    private String payern = null;

    /* Column Info */
    private String blnooo = null;

    /* Column Info */
    private String bilamt = null;

    /* Column Info */
    private String invCurrCd = null;

    /* Column Info */
    private String invnoo = null;

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String ftDys = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String sheetp = null;

    /* Column Info */
    private String payerc = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String invRmk = null;

    /* Column Info */
    private String shCustCd = null;

    /* Column Info */
    private String taxamt = null;

    /* Column Info */
    private String cnCustNm = null;

    /* Column Info */
    private String orgChgAmt = null;

    /* Column Info */
    private String toMvmtYdCd = null;

    /* Column Info */
    private String dmdtInvTpCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public OTSCleanDetailExcelListVO() {
    }

    public OTSCleanDetailExcelListVO(String ibflag, String pagerows, String invnoo, String vvdcdd, String bkgnoo, String cntrNo, String blnooo, String currcy, String bilamt, String taxamt, String invamt, String tarftp, String issedt, String isseof, String invovd, String sheetp, String porCd, String polCd, String podCd, String delCd, String obSrepCd, String rfaNo, String scNo, String taaNo, String shCustCd, String shCustNm, String cnCustCd, String cnCustNm, String nfCustCd, String nfCustNm, String invRmk, String orgChgAmt, String cmdtExptAmt, String scRfaExptAmt, String aftExptDcAmt, String payerc, String payern, String ibSlsOfcCd, String ibSrepCd, String invCurrCd, String chgCurrCd, String ftDys, String fxFtOvrDys, String fmMvmtYdCd, String toMvmtYdCd, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String calcBilAmt, String dmdtArIfCd, String arIfDt, String cmdtCd, String cmdtNm, String bzcTrfCurrCd, String netExptAmt, String issudt, String oveday, String dmdtInvTpCd) {
        this.bzcTrfCurrCd = bzcTrfCurrCd;
        this.cnCustCd = cnCustCd;
        this.isseof = isseof;
        this.aftExptDcAmt = aftExptDcAmt;
        this.pagerows = pagerows;
        this.obSrepCd = obSrepCd;
        this.fxFtOvrDys = fxFtOvrDys;
        this.currcy = currcy;
        this.chgCurrCd = chgCurrCd;
        this.polCd = polCd;
        this.issudt = issudt;
        this.scNo = scNo;
        this.arIfDt = arIfDt;
        this.bkgnoo = bkgnoo;
        this.ibSrepCd = ibSrepCd;
        this.delCd = delCd;
        this.tarftp = tarftp;
        this.ftCmncDt = ftCmncDt;
        this.podCd = podCd;
        this.shCustNm = shCustNm;
        this.fmMvmtDt = fmMvmtDt;
        this.dmdtArIfCd = dmdtArIfCd;
        this.calcBilAmt = calcBilAmt;
        this.porCd = porCd;
        this.scRfaExptAmt = scRfaExptAmt;
        this.netExptAmt = netExptAmt;
        this.issedt = issedt;
        this.invamt = invamt;
        this.rfaNo = rfaNo;
        this.ibflag = ibflag;
        this.oveday = oveday;
        this.cmdtCd = cmdtCd;
        this.nfCustCd = nfCustCd;
        this.invovd = invovd;
        this.ftEndDt = ftEndDt;
        this.cmdtExptAmt = cmdtExptAmt;
        this.toMvmtDt = toMvmtDt;
        this.vvdcdd = vvdcdd;
        this.nfCustNm = nfCustNm;
        this.ibSlsOfcCd = ibSlsOfcCd;
        this.fmMvmtYdCd = fmMvmtYdCd;
        this.payern = payern;
        this.blnooo = blnooo;
        this.bilamt = bilamt;
        this.invCurrCd = invCurrCd;
        this.invnoo = invnoo;
        this.cmdtNm = cmdtNm;
        this.ftDys = ftDys;
        this.taaNo = taaNo;
        this.sheetp = sheetp;
        this.payerc = payerc;
        this.cntrNo = cntrNo;
        this.invRmk = invRmk;
        this.shCustCd = shCustCd;
        this.taxamt = taxamt;
        this.cnCustNm = cnCustNm;
        this.orgChgAmt = orgChgAmt;
        this.toMvmtYdCd = toMvmtYdCd;
        this.dmdtInvTpCd = dmdtInvTpCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd());
        this.hashColumns.put("cn_cust_cd", getCnCustCd());
        this.hashColumns.put("isseof", getIsseof());
        this.hashColumns.put("aft_expt_dc_amt", getAftExptDcAmt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
        this.hashColumns.put("currcy", getCurrcy());
        this.hashColumns.put("chg_curr_cd", getChgCurrCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("issudt", getIssudt());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("ar_if_dt", getArIfDt());
        this.hashColumns.put("bkgnoo", getBkgnoo());
        this.hashColumns.put("ib_srep_cd", getIbSrepCd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("tarftp", getTarftp());
        this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("sh_cust_nm", getShCustNm());
        this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
        this.hashColumns.put("dmdt_ar_if_cd", getDmdtArIfCd());
        this.hashColumns.put("calc_bil_amt", getCalcBilAmt());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("sc_rfa_expt_amt", getScRfaExptAmt());
        this.hashColumns.put("net_expt_amt", getNetExptAmt());
        this.hashColumns.put("issedt", getIssedt());
        this.hashColumns.put("invamt", getInvamt());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("oveday", getOveday());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("nf_cust_cd", getNfCustCd());
        this.hashColumns.put("invovd", getInvovd());
        this.hashColumns.put("ft_end_dt", getFtEndDt());
        this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
        this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
        this.hashColumns.put("vvdcdd", getVvdcdd());
        this.hashColumns.put("nf_cust_nm", getNfCustNm());
        this.hashColumns.put("ib_sls_ofc_cd", getIbSlsOfcCd());
        this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
        this.hashColumns.put("payern", getPayern());
        this.hashColumns.put("blnooo", getBlnooo());
        this.hashColumns.put("bilamt", getBilamt());
        this.hashColumns.put("inv_curr_cd", getInvCurrCd());
        this.hashColumns.put("invnoo", getInvnoo());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("ft_dys", getFtDys());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("sheetp", getSheetp());
        this.hashColumns.put("payerc", getPayerc());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("inv_rmk", getInvRmk());
        this.hashColumns.put("sh_cust_cd", getShCustCd());
        this.hashColumns.put("taxamt", getTaxamt());
        this.hashColumns.put("cn_cust_nm", getCnCustNm());
        this.hashColumns.put("org_chg_amt", getOrgChgAmt());
        this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
        this.hashColumns.put("dmdt_inv_tp_cd", getDmdtInvTpCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
        this.hashFields.put("cn_cust_cd", "cnCustCd");
        this.hashFields.put("isseof", "isseof");
        this.hashFields.put("aft_expt_dc_amt", "aftExptDcAmt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
        this.hashFields.put("currcy", "currcy");
        this.hashFields.put("chg_curr_cd", "chgCurrCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("issudt", "issudt");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("ar_if_dt", "arIfDt");
        this.hashFields.put("bkgnoo", "bkgnoo");
        this.hashFields.put("ib_srep_cd", "ibSrepCd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("tarftp", "tarftp");
        this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("sh_cust_nm", "shCustNm");
        this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
        this.hashFields.put("dmdt_ar_if_cd", "dmdtArIfCd");
        this.hashFields.put("calc_bil_amt", "calcBilAmt");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("sc_rfa_expt_amt", "scRfaExptAmt");
        this.hashFields.put("net_expt_amt", "netExptAmt");
        this.hashFields.put("issedt", "issedt");
        this.hashFields.put("invamt", "invamt");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("oveday", "oveday");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("nf_cust_cd", "nfCustCd");
        this.hashFields.put("invovd", "invovd");
        this.hashFields.put("ft_end_dt", "ftEndDt");
        this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
        this.hashFields.put("to_mvmt_dt", "toMvmtDt");
        this.hashFields.put("vvdcdd", "vvdcdd");
        this.hashFields.put("nf_cust_nm", "nfCustNm");
        this.hashFields.put("ib_sls_ofc_cd", "ibSlsOfcCd");
        this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
        this.hashFields.put("payern", "payern");
        this.hashFields.put("blnooo", "blnooo");
        this.hashFields.put("bilamt", "bilamt");
        this.hashFields.put("inv_curr_cd", "invCurrCd");
        this.hashFields.put("invnoo", "invnoo");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("ft_dys", "ftDys");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("sheetp", "sheetp");
        this.hashFields.put("payerc", "payerc");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("inv_rmk", "invRmk");
        this.hashFields.put("sh_cust_cd", "shCustCd");
        this.hashFields.put("taxamt", "taxamt");
        this.hashFields.put("cn_cust_nm", "cnCustNm");
        this.hashFields.put("org_chg_amt", "orgChgAmt");
        this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
        this.hashFields.put("dmdt_inv_tp_cd", "dmdtInvTpCd");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bzcTrfCurrCd
	 */
    public String getBzcTrfCurrCd() {
        return this.bzcTrfCurrCd;
    }

    /**
	 * Column Info
	 * @return cnCustCd
	 */
    public String getCnCustCd() {
        return this.cnCustCd;
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
	 * @return aftExptDcAmt
	 */
    public String getAftExptDcAmt() {
        return this.aftExptDcAmt;
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
	 * @return obSrepCd
	 */
    public String getObSrepCd() {
        return this.obSrepCd;
    }

    /**
	 * Column Info
	 * @return fxFtOvrDys
	 */
    public String getFxFtOvrDys() {
        return this.fxFtOvrDys;
    }

    /**
	 * Column Info
	 * @return currcy
	 */
    public String getCurrcy() {
        return this.currcy;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Column Info
	 * @return issudt
	 */
    public String getIssudt() {
        return this.issudt;
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
	 * @return arIfDt
	 */
    public String getArIfDt() {
        return this.arIfDt;
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
	 * @return ibSrepCd
	 */
    public String getIbSrepCd() {
        return this.ibSrepCd;
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
	 * @return tarftp
	 */
    public String getTarftp() {
        return this.tarftp;
    }

    /**
	 * Column Info
	 * @return ftCmncDt
	 */
    public String getFtCmncDt() {
        return this.ftCmncDt;
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
	 * @return shCustNm
	 */
    public String getShCustNm() {
        return this.shCustNm;
    }

    /**
	 * Column Info
	 * @return fmMvmtDt
	 */
    public String getFmMvmtDt() {
        return this.fmMvmtDt;
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
	 * @return calcBilAmt
	 */
    public String getCalcBilAmt() {
        return this.calcBilAmt;
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
	 * @return scRfaExptAmt
	 */
    public String getScRfaExptAmt() {
        return this.scRfaExptAmt;
    }

    /**
	 * Column Info
	 * @return netExptAmt
	 */
    public String getNetExptAmt() {
        return this.netExptAmt;
    }

    /**
	 * Column Info
	 * @return issedt
	 */
    public String getIssedt() {
        return this.issedt;
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
	 * @return rfaNo
	 */
    public String getRfaNo() {
        return this.rfaNo;
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
	 * @return oveday
	 */
    public String getOveday() {
        return this.oveday;
    }

    /**
	 * Column Info
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return nfCustCd
	 */
    public String getNfCustCd() {
        return this.nfCustCd;
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
	 * @return ftEndDt
	 */
    public String getFtEndDt() {
        return this.ftEndDt;
    }

    /**
	 * Column Info
	 * @return cmdtExptAmt
	 */
    public String getCmdtExptAmt() {
        return this.cmdtExptAmt;
    }

    /**
	 * Column Info
	 * @return toMvmtDt
	 */
    public String getToMvmtDt() {
        return this.toMvmtDt;
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
	 * @return nfCustNm
	 */
    public String getNfCustNm() {
        return this.nfCustNm;
    }

    /**
	 * Column Info
	 * @return ibSlsOfcCd
	 */
    public String getIbSlsOfcCd() {
        return this.ibSlsOfcCd;
    }

    /**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
    public String getFmMvmtYdCd() {
        return this.fmMvmtYdCd;
    }

    /**
	 * Column Info
	 * @return payern
	 */
    public String getPayern() {
        return this.payern;
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
	 * @return invCurrCd
	 */
    public String getInvCurrCd() {
        return this.invCurrCd;
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
	 * @return cmdtNm
	 */
    public String getCmdtNm() {
        return this.cmdtNm;
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
	 * @return taaNo
	 */
    public String getTaaNo() {
        return this.taaNo;
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
	 * @return payerc
	 */
    public String getPayerc() {
        return this.payerc;
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
	 * @return invRmk
	 */
    public String getInvRmk() {
        return this.invRmk;
    }

    /**
	 * Column Info
	 * @return shCustCd
	 */
    public String getShCustCd() {
        return this.shCustCd;
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
	 * @return cnCustNm
	 */
    public String getCnCustNm() {
        return this.cnCustNm;
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
	 * @return toMvmtYdCd
	 */
    public String getToMvmtYdCd() {
        return this.toMvmtYdCd;
    }

    /**
	 * Column Info
	 * @param bzcTrfCurrCd
	 */
    public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
        this.bzcTrfCurrCd = bzcTrfCurrCd;
    }

    /**
	 * Column Info
	 * @param cnCustCd
	 */
    public void setCnCustCd(String cnCustCd) {
        this.cnCustCd = cnCustCd;
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
	 * @param aftExptDcAmt
	 */
    public void setAftExptDcAmt(String aftExptDcAmt) {
        this.aftExptDcAmt = aftExptDcAmt;
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
	 * @param obSrepCd
	 */
    public void setObSrepCd(String obSrepCd) {
        this.obSrepCd = obSrepCd;
    }

    /**
	 * Column Info
	 * @param fxFtOvrDys
	 */
    public void setFxFtOvrDys(String fxFtOvrDys) {
        this.fxFtOvrDys = fxFtOvrDys;
    }

    /**
	 * Column Info
	 * @param currcy
	 */
    public void setCurrcy(String currcy) {
        this.currcy = currcy;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param issudt
	 */
    public void setIssudt(String issudt) {
        this.issudt = issudt;
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
	 * @param arIfDt
	 */
    public void setArIfDt(String arIfDt) {
        this.arIfDt = arIfDt;
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
	 * @param ibSrepCd
	 */
    public void setIbSrepCd(String ibSrepCd) {
        this.ibSrepCd = ibSrepCd;
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
	 * @param tarftp
	 */
    public void setTarftp(String tarftp) {
        this.tarftp = tarftp;
    }

    /**
	 * Column Info
	 * @param ftCmncDt
	 */
    public void setFtCmncDt(String ftCmncDt) {
        this.ftCmncDt = ftCmncDt;
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
	 * @param shCustNm
	 */
    public void setShCustNm(String shCustNm) {
        this.shCustNm = shCustNm;
    }

    /**
	 * Column Info
	 * @param fmMvmtDt
	 */
    public void setFmMvmtDt(String fmMvmtDt) {
        this.fmMvmtDt = fmMvmtDt;
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
	 * @param calcBilAmt
	 */
    public void setCalcBilAmt(String calcBilAmt) {
        this.calcBilAmt = calcBilAmt;
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
	 * @param scRfaExptAmt
	 */
    public void setScRfaExptAmt(String scRfaExptAmt) {
        this.scRfaExptAmt = scRfaExptAmt;
    }

    /**
	 * Column Info
	 * @param netExptAmt
	 */
    public void setNetExptAmt(String netExptAmt) {
        this.netExptAmt = netExptAmt;
    }

    /**
	 * Column Info
	 * @param issedt
	 */
    public void setIssedt(String issedt) {
        this.issedt = issedt;
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
	 * @param rfaNo
	 */
    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
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
	 * @param oveday
	 */
    public void setOveday(String oveday) {
        this.oveday = oveday;
    }

    /**
	 * Column Info
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param nfCustCd
	 */
    public void setNfCustCd(String nfCustCd) {
        this.nfCustCd = nfCustCd;
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
	 * @param ftEndDt
	 */
    public void setFtEndDt(String ftEndDt) {
        this.ftEndDt = ftEndDt;
    }

    /**
	 * Column Info
	 * @param cmdtExptAmt
	 */
    public void setCmdtExptAmt(String cmdtExptAmt) {
        this.cmdtExptAmt = cmdtExptAmt;
    }

    /**
	 * Column Info
	 * @param toMvmtDt
	 */
    public void setToMvmtDt(String toMvmtDt) {
        this.toMvmtDt = toMvmtDt;
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
	 * @param nfCustNm
	 */
    public void setNfCustNm(String nfCustNm) {
        this.nfCustNm = nfCustNm;
    }

    /**
	 * Column Info
	 * @param ibSlsOfcCd
	 */
    public void setIbSlsOfcCd(String ibSlsOfcCd) {
        this.ibSlsOfcCd = ibSlsOfcCd;
    }

    /**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
    public void setFmMvmtYdCd(String fmMvmtYdCd) {
        this.fmMvmtYdCd = fmMvmtYdCd;
    }

    /**
	 * Column Info
	 * @param payern
	 */
    public void setPayern(String payern) {
        this.payern = payern;
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
	 * @param invCurrCd
	 */
    public void setInvCurrCd(String invCurrCd) {
        this.invCurrCd = invCurrCd;
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
	 * @param cmdtNm
	 */
    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
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
	 * @param taaNo
	 */
    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
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
	 * @param payerc
	 */
    public void setPayerc(String payerc) {
        this.payerc = payerc;
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
	 * @param invRmk
	 */
    public void setInvRmk(String invRmk) {
        this.invRmk = invRmk;
    }

    /**
	 * Column Info
	 * @param shCustCd
	 */
    public void setShCustCd(String shCustCd) {
        this.shCustCd = shCustCd;
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
	 * @param cnCustNm
	 */
    public void setCnCustNm(String cnCustNm) {
        this.cnCustNm = cnCustNm;
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
	 * @param toMvmtYdCd
	 */
    public void setToMvmtYdCd(String toMvmtYdCd) {
        this.toMvmtYdCd = toMvmtYdCd;
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
        setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", ""));
        setCnCustCd(JSPUtil.getParameter(request, prefix + "cn_cust_cd", ""));
        setIsseof(JSPUtil.getParameter(request, prefix + "isseof", ""));
        setAftExptDcAmt(JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
        setCurrcy(JSPUtil.getParameter(request, prefix + "currcy", ""));
        setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIssudt(JSPUtil.getParameter(request, prefix + "issudt", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setArIfDt(JSPUtil.getParameter(request, prefix + "ar_if_dt", ""));
        setBkgnoo(JSPUtil.getParameter(request, prefix + "bkgnoo", ""));
        setIbSrepCd(JSPUtil.getParameter(request, prefix + "ib_srep_cd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setTarftp(JSPUtil.getParameter(request, prefix + "tarftp", ""));
        setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
        setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
        setDmdtArIfCd(JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", ""));
        setCalcBilAmt(JSPUtil.getParameter(request, prefix + "calc_bil_amt", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setScRfaExptAmt(JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", ""));
        setNetExptAmt(JSPUtil.getParameter(request, prefix + "net_expt_amt", ""));
        setIssedt(JSPUtil.getParameter(request, prefix + "issedt", ""));
        setInvamt(JSPUtil.getParameter(request, prefix + "invamt", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setOveday(JSPUtil.getParameter(request, prefix + "oveday", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setNfCustCd(JSPUtil.getParameter(request, prefix + "nf_cust_cd", ""));
        setInvovd(JSPUtil.getParameter(request, prefix + "invovd", ""));
        setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
        setCmdtExptAmt(JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", ""));
        setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
        setVvdcdd(JSPUtil.getParameter(request, prefix + "vvdcdd", ""));
        setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
        setIbSlsOfcCd(JSPUtil.getParameter(request, prefix + "ib_sls_ofc_cd", ""));
        setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
        setPayern(JSPUtil.getParameter(request, prefix + "payern", ""));
        setBlnooo(JSPUtil.getParameter(request, prefix + "blnooo", ""));
        setBilamt(JSPUtil.getParameter(request, prefix + "bilamt", ""));
        setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
        setInvnoo(JSPUtil.getParameter(request, prefix + "invnoo", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setFtDys(JSPUtil.getParameter(request, prefix + "ft_dys", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setSheetp(JSPUtil.getParameter(request, prefix + "sheetp", ""));
        setPayerc(JSPUtil.getParameter(request, prefix + "payerc", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
        setShCustCd(JSPUtil.getParameter(request, prefix + "sh_cust_cd", ""));
        setTaxamt(JSPUtil.getParameter(request, prefix + "taxamt", ""));
        setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
        setOrgChgAmt(JSPUtil.getParameter(request, prefix + "org_chg_amt", ""));
        setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
        setDmdtInvTpCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OTSCleanDetailExcelListVO[]
	 */
    public OTSCleanDetailExcelListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OTSCleanDetailExcelListVO[]
	 */
    public OTSCleanDetailExcelListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        OTSCleanDetailExcelListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix + "bzc_trf_curr_cd", length));
            String[] cnCustCd = (JSPUtil.getParameter(request, prefix + "cn_cust_cd", length));
            String[] isseof = (JSPUtil.getParameter(request, prefix + "isseof", length));
            String[] aftExptDcAmt = (JSPUtil.getParameter(request, prefix + "aft_expt_dc_amt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
            String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", length));
            String[] currcy = (JSPUtil.getParameter(request, prefix + "currcy", length));
            String[] chgCurrCd = (JSPUtil.getParameter(request, prefix + "chg_curr_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] issudt = (JSPUtil.getParameter(request, prefix + "issudt", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] arIfDt = (JSPUtil.getParameter(request, prefix + "ar_if_dt", length));
            String[] bkgnoo = (JSPUtil.getParameter(request, prefix + "bkgnoo", length));
            String[] ibSrepCd = (JSPUtil.getParameter(request, prefix + "ib_srep_cd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] tarftp = (JSPUtil.getParameter(request, prefix + "tarftp", length));
            String[] ftCmncDt = (JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] shCustNm = (JSPUtil.getParameter(request, prefix + "sh_cust_nm", length));
            String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", length));
            String[] dmdtArIfCd = (JSPUtil.getParameter(request, prefix + "dmdt_ar_if_cd", length));
            String[] calcBilAmt = (JSPUtil.getParameter(request, prefix + "calc_bil_amt", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] scRfaExptAmt = (JSPUtil.getParameter(request, prefix + "sc_rfa_expt_amt", length));
            String[] netExptAmt = (JSPUtil.getParameter(request, prefix + "net_expt_amt", length));
            String[] issedt = (JSPUtil.getParameter(request, prefix + "issedt", length));
            String[] invamt = (JSPUtil.getParameter(request, prefix + "invamt", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] oveday = (JSPUtil.getParameter(request, prefix + "oveday", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] nfCustCd = (JSPUtil.getParameter(request, prefix + "nf_cust_cd", length));
            String[] invovd = (JSPUtil.getParameter(request, prefix + "invovd", length));
            String[] ftEndDt = (JSPUtil.getParameter(request, prefix + "ft_end_dt", length));
            String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix + "cmdt_expt_amt", length));
            String[] toMvmtDt = (JSPUtil.getParameter(request, prefix + "to_mvmt_dt", length));
            String[] vvdcdd = (JSPUtil.getParameter(request, prefix + "vvdcdd", length));
            String[] nfCustNm = (JSPUtil.getParameter(request, prefix + "nf_cust_nm", length));
            String[] ibSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ib_sls_ofc_cd", length));
            String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", length));
            String[] payern = (JSPUtil.getParameter(request, prefix + "payern", length));
            String[] blnooo = (JSPUtil.getParameter(request, prefix + "blnooo", length));
            String[] bilamt = (JSPUtil.getParameter(request, prefix + "bilamt", length));
            String[] invCurrCd = (JSPUtil.getParameter(request, prefix + "inv_curr_cd", length));
            String[] invnoo = (JSPUtil.getParameter(request, prefix + "invnoo", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] ftDys = (JSPUtil.getParameter(request, prefix + "ft_dys", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] sheetp = (JSPUtil.getParameter(request, prefix + "sheetp", length));
            String[] payerc = (JSPUtil.getParameter(request, prefix + "payerc", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] invRmk = (JSPUtil.getParameter(request, prefix + "inv_rmk", length));
            String[] shCustCd = (JSPUtil.getParameter(request, prefix + "sh_cust_cd", length));
            String[] taxamt = (JSPUtil.getParameter(request, prefix + "taxamt", length));
            String[] cnCustNm = (JSPUtil.getParameter(request, prefix + "cn_cust_nm", length));
            String[] orgChgAmt = (JSPUtil.getParameter(request, prefix + "org_chg_amt", length));
            String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", length));
            String[] dmdtInvTpCd = (JSPUtil.getParameter(request, prefix + "dmdt_inv_tp_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new OTSCleanDetailExcelListVO();
                if (bzcTrfCurrCd[i] != null)
                    model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
                if (cnCustCd[i] != null)
                    model.setCnCustCd(cnCustCd[i]);
                if (isseof[i] != null)
                    model.setIsseof(isseof[i]);
                if (aftExptDcAmt[i] != null)
                    model.setAftExptDcAmt(aftExptDcAmt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (fxFtOvrDys[i] != null)
                    model.setFxFtOvrDys(fxFtOvrDys[i]);
                if (currcy[i] != null)
                    model.setCurrcy(currcy[i]);
                if (chgCurrCd[i] != null)
                    model.setChgCurrCd(chgCurrCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (issudt[i] != null)
                    model.setIssudt(issudt[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (arIfDt[i] != null)
                    model.setArIfDt(arIfDt[i]);
                if (bkgnoo[i] != null)
                    model.setBkgnoo(bkgnoo[i]);
                if (ibSrepCd[i] != null)
                    model.setIbSrepCd(ibSrepCd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (tarftp[i] != null)
                    model.setTarftp(tarftp[i]);
                if (ftCmncDt[i] != null)
                    model.setFtCmncDt(ftCmncDt[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (shCustNm[i] != null)
                    model.setShCustNm(shCustNm[i]);
                if (fmMvmtDt[i] != null)
                    model.setFmMvmtDt(fmMvmtDt[i]);
                if (dmdtArIfCd[i] != null)
                    model.setDmdtArIfCd(dmdtArIfCd[i]);
                if (calcBilAmt[i] != null)
                    model.setCalcBilAmt(calcBilAmt[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (scRfaExptAmt[i] != null)
                    model.setScRfaExptAmt(scRfaExptAmt[i]);
                if (netExptAmt[i] != null)
                    model.setNetExptAmt(netExptAmt[i]);
                if (issedt[i] != null)
                    model.setIssedt(issedt[i]);
                if (invamt[i] != null)
                    model.setInvamt(invamt[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (oveday[i] != null)
                    model.setOveday(oveday[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (nfCustCd[i] != null)
                    model.setNfCustCd(nfCustCd[i]);
                if (invovd[i] != null)
                    model.setInvovd(invovd[i]);
                if (ftEndDt[i] != null)
                    model.setFtEndDt(ftEndDt[i]);
                if (cmdtExptAmt[i] != null)
                    model.setCmdtExptAmt(cmdtExptAmt[i]);
                if (toMvmtDt[i] != null)
                    model.setToMvmtDt(toMvmtDt[i]);
                if (vvdcdd[i] != null)
                    model.setVvdcdd(vvdcdd[i]);
                if (nfCustNm[i] != null)
                    model.setNfCustNm(nfCustNm[i]);
                if (ibSlsOfcCd[i] != null)
                    model.setIbSlsOfcCd(ibSlsOfcCd[i]);
                if (fmMvmtYdCd[i] != null)
                    model.setFmMvmtYdCd(fmMvmtYdCd[i]);
                if (payern[i] != null)
                    model.setPayern(payern[i]);
                if (blnooo[i] != null)
                    model.setBlnooo(blnooo[i]);
                if (bilamt[i] != null)
                    model.setBilamt(bilamt[i]);
                if (invCurrCd[i] != null)
                    model.setInvCurrCd(invCurrCd[i]);
                if (invnoo[i] != null)
                    model.setInvnoo(invnoo[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (ftDys[i] != null)
                    model.setFtDys(ftDys[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (sheetp[i] != null)
                    model.setSheetp(sheetp[i]);
                if (payerc[i] != null)
                    model.setPayerc(payerc[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (invRmk[i] != null)
                    model.setInvRmk(invRmk[i]);
                if (shCustCd[i] != null)
                    model.setShCustCd(shCustCd[i]);
                if (taxamt[i] != null)
                    model.setTaxamt(taxamt[i]);
                if (cnCustNm[i] != null)
                    model.setCnCustNm(cnCustNm[i]);
                if (orgChgAmt[i] != null)
                    model.setOrgChgAmt(orgChgAmt[i]);
                if (toMvmtYdCd[i] != null)
                    model.setToMvmtYdCd(toMvmtYdCd[i]);
                if (dmdtInvTpCd[i] != null) 
		    		model.setDmdtInvTpCd(dmdtInvTpCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getOTSCleanDetailExcelListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return OTSCleanDetailExcelListVO[]
	 */
    public OTSCleanDetailExcelListVO[] getOTSCleanDetailExcelListVOs() {
        OTSCleanDetailExcelListVO[] vos = (OTSCleanDetailExcelListVO[]) models.toArray(new OTSCleanDetailExcelListVO[models.size()]);
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
        this.bzcTrfCurrCd = this.bzcTrfCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnCustCd = this.cnCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isseof = this.isseof.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aftExptDcAmt = this.aftExptDcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fxFtOvrDys = this.fxFtOvrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currcy = this.currcy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgCurrCd = this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issudt = this.issudt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arIfDt = this.arIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgnoo = this.bkgnoo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibSrepCd = this.ibSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tarftp = this.tarftp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftCmncDt = this.ftCmncDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCustNm = this.shCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtDt = this.fmMvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtArIfCd = this.dmdtArIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.calcBilAmt = this.calcBilAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scRfaExptAmt = this.scRfaExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExptAmt = this.netExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.issedt = this.issedt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invamt = this.invamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oveday = this.oveday.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfCustCd = this.nfCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invovd = this.invovd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftEndDt = this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtExptAmt = this.cmdtExptAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toMvmtDt = this.toMvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdcdd = this.vvdcdd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nfCustNm = this.nfCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibSlsOfcCd = this.ibSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmMvmtYdCd = this.fmMvmtYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payern = this.payern.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blnooo = this.blnooo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bilamt = this.bilamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invCurrCd = this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invnoo = this.invnoo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ftDys = this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sheetp = this.sheetp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.payerc = this.payerc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.invRmk = this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.shCustCd = this.shCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxamt = this.taxamt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnCustNm = this.cnCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgChgAmt = this.orgChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toMvmtYdCd = this.toMvmtYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dmdtInvTpCd = this.dmdtInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
