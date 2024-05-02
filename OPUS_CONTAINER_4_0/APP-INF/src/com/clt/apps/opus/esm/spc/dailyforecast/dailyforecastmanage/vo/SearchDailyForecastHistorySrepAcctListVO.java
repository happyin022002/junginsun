/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDailyForecastHistorySrepAcctListVO.java
*@FileTitle : SearchDailyForecastHistorySrepAcctListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.08
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.07.08 이상용 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchDailyForecastHistorySrepAcctListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchDailyForecastHistorySrepAcctListVO> models = new ArrayList<SearchDailyForecastHistorySrepAcctListVO>();

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String usdBkg53ftQty = null;

    /* Column Info */
    private String usdBkg20ftQty = null;

    /* Column Info */
    private String fcastTtlTeuQty = null;

    /* Column Info */
    private String usdBkg40ftQty = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String fcastTtlQty = null;

    /* Column Info */
    private String usdBkgRfQty = null;

    /* Column Info */
    private String usdBkgTtlQty = null;

    /* Column Info */
    private String srepNm = null;

    /* Column Info */
    private String modiUsr = null;

    /* Column Info */
    private String slsOfcCd = null;

    /* Column Info */
    private String fcast53ftQty = null;

    /* Column Info */
    private String fcastTtlWgt = null;

    /* Column Info */
    private String usdBkg40ftHcQty = null;

    /* Column Info */
    private String modiGdt = null;

    /* Column Info */
    private String srepUsrId = null;

    /* Column Info */
    private String fcastRfQty = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String lvl = null;

    /* Column Info */
    private String usdBkg45ftHcQty = null;

    /* Column Info */
    private String fcast45ftHcQty = null;

    /* Column Info */
    private String custCd = null;

    /* Column Info */
    private String fcastCustTpCd = null;

    /* Column Info */
    private String usdBkgTtlWgt = null;

    /* Column Info */
    private String fcast40ftHcQty = null;

    /* Column Info */
    private String scRfaNo = null;

    /* Column Info */
    private String ctrtCustCd = null;

    /* Column Info */
    private String ctrtCustNm = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String ctrtNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchDailyForecastHistorySrepAcctListVO() {
    }

    public SearchDailyForecastHistorySrepAcctListVO(String ibflag, String pagerows, String slsOfcCd, String srepUsrId, String srepNm, String modiGdt, String modiUsr, String fcastCustTpCd, String custCd, String custNm, String polCd, String podCd, String fcastTtlTeuQty, String fcastTtlQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcast53ftQty, String fcastRfQty, String fcastTtlWgt, String usdBkgTtlQty, String usdBkg20ftQty, String usdBkg40ftQty, String usdBkg40ftHcQty, String usdBkg45ftHcQty, String usdBkg53ftQty, String usdBkgRfQty, String usdBkgTtlWgt, String lvl, String scRfaNo, String ctrtCustCd, String ctrtCustNm, String vvdCd, String ctrtNo) {
        this.custNm = custNm;
        this.usdBkg53ftQty = usdBkg53ftQty;
        this.usdBkg20ftQty = usdBkg20ftQty;
        this.fcastTtlTeuQty = fcastTtlTeuQty;
        this.usdBkg40ftQty = usdBkg40ftQty;
        this.pagerows = pagerows;
        this.polCd = polCd;
        this.ibflag = ibflag;
        this.fcastTtlQty = fcastTtlQty;
        this.usdBkgRfQty = usdBkgRfQty;
        this.usdBkgTtlQty = usdBkgTtlQty;
        this.srepNm = srepNm;
        this.modiUsr = modiUsr;
        this.slsOfcCd = slsOfcCd;
        this.fcast53ftQty = fcast53ftQty;
        this.fcastTtlWgt = fcastTtlWgt;
        this.usdBkg40ftHcQty = usdBkg40ftHcQty;
        this.modiGdt = modiGdt;
        this.srepUsrId = srepUsrId;
        this.fcastRfQty = fcastRfQty;
        this.podCd = podCd;
        this.lvl = lvl;
        this.usdBkg45ftHcQty = usdBkg45ftHcQty;
        this.fcast45ftHcQty = fcast45ftHcQty;
        this.custCd = custCd;
        this.fcastCustTpCd = fcastCustTpCd;
        this.usdBkgTtlWgt = usdBkgTtlWgt;
        this.fcast40ftHcQty = fcast40ftHcQty;
        this.scRfaNo = scRfaNo;
        this.ctrtCustCd = ctrtCustCd;
        this.ctrtCustNm = ctrtCustNm;
        this.vvdCd = vvdCd;
        this.ctrtNo = ctrtNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("usd_bkg_53ft_qty", getUsdBkg53ftQty());
        this.hashColumns.put("usd_bkg_20ft_qty", getUsdBkg20ftQty());
        this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
        this.hashColumns.put("usd_bkg_40ft_qty", getUsdBkg40ftQty());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
        this.hashColumns.put("usd_bkg_rf_qty", getUsdBkgRfQty());
        this.hashColumns.put("usd_bkg_ttl_qty", getUsdBkgTtlQty());
        this.hashColumns.put("srep_nm", getSrepNm());
        this.hashColumns.put("modi_usr", getModiUsr());
        this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
        this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
        this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
        this.hashColumns.put("usd_bkg_40ft_hc_qty", getUsdBkg40ftHcQty());
        this.hashColumns.put("modi_gdt", getModiGdt());
        this.hashColumns.put("srep_usr_id", getSrepUsrId());
        this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("lvl", getLvl());
        this.hashColumns.put("usd_bkg_45ft_hc_qty", getUsdBkg45ftHcQty());
        this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
        this.hashColumns.put("cust_cd", getCustCd());
        this.hashColumns.put("fcast_cust_tp_cd", getFcastCustTpCd());
        this.hashColumns.put("usd_bkg_ttl_wgt", getUsdBkgTtlWgt());
        this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
        this.hashColumns.put("sc_rfa_no", getScRfaNo());
        this.hashColumns.put("ctrt_cust_cd", getCtrtCustCd());
        this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("ctrt_no", getCtrtNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("usd_bkg_53ft_qty", "usdBkg53ftQty");
        this.hashFields.put("usd_bkg_20ft_qty", "usdBkg20ftQty");
        this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
        this.hashFields.put("usd_bkg_40ft_qty", "usdBkg40ftQty");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
        this.hashFields.put("usd_bkg_rf_qty", "usdBkgRfQty");
        this.hashFields.put("usd_bkg_ttl_qty", "usdBkgTtlQty");
        this.hashFields.put("srep_nm", "srepNm");
        this.hashFields.put("modi_usr", "modiUsr");
        this.hashFields.put("sls_ofc_cd", "slsOfcCd");
        this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
        this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
        this.hashFields.put("usd_bkg_40ft_hc_qty", "usdBkg40ftHcQty");
        this.hashFields.put("modi_gdt", "modiGdt");
        this.hashFields.put("srep_usr_id", "srepUsrId");
        this.hashFields.put("fcast_rf_qty", "fcastRfQty");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("lvl", "lvl");
        this.hashFields.put("usd_bkg_45ft_hc_qty", "usdBkg45ftHcQty");
        this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
        this.hashFields.put("cust_cd", "custCd");
        this.hashFields.put("fcast_cust_tp_cd", "fcastCustTpCd");
        this.hashFields.put("usd_bkg_ttl_wgt", "usdBkgTtlWgt");
        this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
        this.hashFields.put("sc_rfa_no", "scRfaNo");
        this.hashFields.put("ctrt_cust_cd", "ctrtCustCd");
        this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("ctrt_no", "ctrtNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 * Column Info
	 * @return usdBkg53ftQty
	 */
    public String getUsdBkg53ftQty() {
        return this.usdBkg53ftQty;
    }

    /**
	 * Column Info
	 * @return usdBkg20ftQty
	 */
    public String getUsdBkg20ftQty() {
        return this.usdBkg20ftQty;
    }

    /**
	 * Column Info
	 * @return fcastTtlTeuQty
	 */
    public String getFcastTtlTeuQty() {
        return this.fcastTtlTeuQty;
    }

    /**
	 * Column Info
	 * @return usdBkg40ftQty
	 */
    public String getUsdBkg40ftQty() {
        return this.usdBkg40ftQty;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return fcastTtlQty
	 */
    public String getFcastTtlQty() {
        return this.fcastTtlQty;
    }

    /**
	 * Column Info
	 * @return usdBkgRfQty
	 */
    public String getUsdBkgRfQty() {
        return this.usdBkgRfQty;
    }

    /**
	 * Column Info
	 * @return usdBkgTtlQty
	 */
    public String getUsdBkgTtlQty() {
        return this.usdBkgTtlQty;
    }

    /**
	 * Column Info
	 * @return srepNm
	 */
    public String getSrepNm() {
        return this.srepNm;
    }

    /**
	 * Column Info
	 * @return modiUsr
	 */
    public String getModiUsr() {
        return this.modiUsr;
    }

    /**
	 * Column Info
	 * @return slsOfcCd
	 */
    public String getSlsOfcCd() {
        return this.slsOfcCd;
    }

    /**
	 * Column Info
	 * @return fcast53ftQty
	 */
    public String getFcast53ftQty() {
        return this.fcast53ftQty;
    }

    /**
	 * Column Info
	 * @return fcastTtlWgt
	 */
    public String getFcastTtlWgt() {
        return this.fcastTtlWgt;
    }

    /**
	 * Column Info
	 * @return usdBkg40ftHcQty
	 */
    public String getUsdBkg40ftHcQty() {
        return this.usdBkg40ftHcQty;
    }

    /**
	 * Column Info
	 * @return modiGdt
	 */
    public String getModiGdt() {
        return this.modiGdt;
    }

    /**
	 * Column Info
	 * @return srepUsrId
	 */
    public String getSrepUsrId() {
        return this.srepUsrId;
    }

    /**
	 * Column Info
	 * @return fcastRfQty
	 */
    public String getFcastRfQty() {
        return this.fcastRfQty;
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
	 * @return lvl
	 */
    public String getLvl() {
        return this.lvl;
    }

    /**
	 * Column Info
	 * @return usdBkg45ftHcQty
	 */
    public String getUsdBkg45ftHcQty() {
        return this.usdBkg45ftHcQty;
    }

    /**
	 * Column Info
	 * @return fcast45ftHcQty
	 */
    public String getFcast45ftHcQty() {
        return this.fcast45ftHcQty;
    }

    /**
	 * Column Info
	 * @return custCd
	 */
    public String getCustCd() {
        return this.custCd;
    }

    /**
	 * Column Info
	 * @return fcastCustTpCd
	 */
    public String getFcastCustTpCd() {
        return this.fcastCustTpCd;
    }

    /**
	 * Column Info
	 * @return usdBkgTtlWgt
	 */
    public String getUsdBkgTtlWgt() {
        return this.usdBkgTtlWgt;
    }

    /**
	 * Column Info
	 * @return fcast40ftHcQty
	 */
    public String getFcast40ftHcQty() {
        return this.fcast40ftHcQty;
    }

    /**
	 * Column Info
	 * @param custNm
	 */
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }

    /**
	 * Column Info
	 * @param usdBkg53ftQty
	 */
    public void setUsdBkg53ftQty(String usdBkg53ftQty) {
        this.usdBkg53ftQty = usdBkg53ftQty;
    }

    /**
	 * Column Info
	 * @param usdBkg20ftQty
	 */
    public void setUsdBkg20ftQty(String usdBkg20ftQty) {
        this.usdBkg20ftQty = usdBkg20ftQty;
    }

    /**
	 * Column Info
	 * @param fcastTtlTeuQty
	 */
    public void setFcastTtlTeuQty(String fcastTtlTeuQty) {
        this.fcastTtlTeuQty = fcastTtlTeuQty;
    }

    /**
	 * Column Info
	 * @param usdBkg40ftQty
	 */
    public void setUsdBkg40ftQty(String usdBkg40ftQty) {
        this.usdBkg40ftQty = usdBkg40ftQty;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param fcastTtlQty
	 */
    public void setFcastTtlQty(String fcastTtlQty) {
        this.fcastTtlQty = fcastTtlQty;
    }

    /**
	 * Column Info
	 * @param usdBkgRfQty
	 */
    public void setUsdBkgRfQty(String usdBkgRfQty) {
        this.usdBkgRfQty = usdBkgRfQty;
    }

    /**
	 * Column Info
	 * @param usdBkgTtlQty
	 */
    public void setUsdBkgTtlQty(String usdBkgTtlQty) {
        this.usdBkgTtlQty = usdBkgTtlQty;
    }

    /**
	 * Column Info
	 * @param srepNm
	 */
    public void setSrepNm(String srepNm) {
        this.srepNm = srepNm;
    }

    /**
	 * Column Info
	 * @param modiUsr
	 */
    public void setModiUsr(String modiUsr) {
        this.modiUsr = modiUsr;
    }

    /**
	 * Column Info
	 * @param slsOfcCd
	 */
    public void setSlsOfcCd(String slsOfcCd) {
        this.slsOfcCd = slsOfcCd;
    }

    /**
	 * Column Info
	 * @param fcast53ftQty
	 */
    public void setFcast53ftQty(String fcast53ftQty) {
        this.fcast53ftQty = fcast53ftQty;
    }

    /**
	 * Column Info
	 * @param fcastTtlWgt
	 */
    public void setFcastTtlWgt(String fcastTtlWgt) {
        this.fcastTtlWgt = fcastTtlWgt;
    }

    /**
	 * Column Info
	 * @param usdBkg40ftHcQty
	 */
    public void setUsdBkg40ftHcQty(String usdBkg40ftHcQty) {
        this.usdBkg40ftHcQty = usdBkg40ftHcQty;
    }

    /**
	 * Column Info
	 * @param modiGdt
	 */
    public void setModiGdt(String modiGdt) {
        this.modiGdt = modiGdt;
    }

    /**
	 * Column Info
	 * @param srepUsrId
	 */
    public void setSrepUsrId(String srepUsrId) {
        this.srepUsrId = srepUsrId;
    }

    /**
	 * Column Info
	 * @param fcastRfQty
	 */
    public void setFcastRfQty(String fcastRfQty) {
        this.fcastRfQty = fcastRfQty;
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
	 * @param lvl
	 */
    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    /**
	 * Column Info
	 * @param usdBkg45ftHcQty
	 */
    public void setUsdBkg45ftHcQty(String usdBkg45ftHcQty) {
        this.usdBkg45ftHcQty = usdBkg45ftHcQty;
    }

    /**
	 * Column Info
	 * @param fcast45ftHcQty
	 */
    public void setFcast45ftHcQty(String fcast45ftHcQty) {
        this.fcast45ftHcQty = fcast45ftHcQty;
    }

    /**
	 * Column Info
	 * @param custCd
	 */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /**
	 * Column Info
	 * @param fcastCustTpCd
	 */
    public void setFcastCustTpCd(String fcastCustTpCd) {
        this.fcastCustTpCd = fcastCustTpCd;
    }

    /**
	 * Column Info
	 * @param usdBkgTtlWgt
	 */
    public void setUsdBkgTtlWgt(String usdBkgTtlWgt) {
        this.usdBkgTtlWgt = usdBkgTtlWgt;
    }

    /**
	 * Column Info
	 * @param fcast40ftHcQty
	 */
    public void setFcast40ftHcQty(String fcast40ftHcQty) {
        this.fcast40ftHcQty = fcast40ftHcQty;
    }

    public void setScRfaNo(String scRfaNo) {
        this.scRfaNo = scRfaNo;
    }

    public String getScRfaNo() {
        return this.scRfaNo;
    }

    public void setCtrtCustCd(String ctrtCustCd) {
        this.ctrtCustCd = ctrtCustCd;
    }

    public String getCtrtCustCd() {
        return this.ctrtCustCd;
    }

    public void setCtrtCustNm(String ctrtCustNm) {
        this.ctrtCustNm = ctrtCustNm;
    }

    public String getCtrtCustNm() {
        return this.ctrtCustNm;
    }

    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    public String getVvdCd() {
        return this.vvdCd;
    }

    public void setCtrtNo(String ctrtNo) {
        this.ctrtNo = ctrtNo;
    }

    public String getCtrtNo() {
        return this.ctrtNo;
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
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setUsdBkg53ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_53ft_qty", ""));
        setUsdBkg20ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_qty", ""));
        setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
        setUsdBkg40ftQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_qty", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
        setUsdBkgRfQty(JSPUtil.getParameter(request, prefix + "usd_bkg_rf_qty", ""));
        setUsdBkgTtlQty(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_qty", ""));
        setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
        setModiUsr(JSPUtil.getParameter(request, prefix + "modi_usr", ""));
        setSlsOfcCd(JSPUtil.getParameter(request, prefix + "sls_ofc_cd", ""));
        setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
        setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
        setUsdBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_hc_qty", ""));
        setModiGdt(JSPUtil.getParameter(request, prefix + "modi_gdt", ""));
        setSrepUsrId(JSPUtil.getParameter(request, prefix + "srep_usr_id", ""));
        setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
        setUsdBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "usd_bkg_45ft_hc_qty", ""));
        setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
        setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
        setFcastCustTpCd(JSPUtil.getParameter(request, prefix + "fcast_cust_tp_cd", ""));
        setUsdBkgTtlWgt(JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_wgt", ""));
        setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
        setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
        setCtrtCustCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cd", ""));
        setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForecastHistorySrepAcctListVO[]
	 */
    public SearchDailyForecastHistorySrepAcctListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastHistorySrepAcctListVO[]
	 */
    public SearchDailyForecastHistorySrepAcctListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchDailyForecastHistorySrepAcctListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] usdBkg53ftQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_53ft_qty", length));
            String[] usdBkg20ftQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_20ft_qty", length));
            String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", length));
            String[] usdBkg40ftQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_qty", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", length));
            String[] usdBkgRfQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_rf_qty", length));
            String[] usdBkgTtlQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_qty", length));
            String[] srepNm = (JSPUtil.getParameter(request, prefix + "srep_nm", length));
            String[] modiUsr = (JSPUtil.getParameter(request, prefix + "modi_usr", length));
            String[] slsOfcCd = (JSPUtil.getParameter(request, prefix + "sls_ofc_cd", length));
            String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", length));
            String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", length));
            String[] usdBkg40ftHcQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_40ft_hc_qty", length));
            String[] modiGdt = (JSPUtil.getParameter(request, prefix + "modi_gdt", length));
            String[] srepUsrId = (JSPUtil.getParameter(request, prefix + "srep_usr_id", length));
            String[] fcastRfQty = (JSPUtil.getParameter(request, prefix + "fcast_rf_qty", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] lvl = (JSPUtil.getParameter(request, prefix + "lvl", length));
            String[] usdBkg45ftHcQty = (JSPUtil.getParameter(request, prefix + "usd_bkg_45ft_hc_qty", length));
            String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", length));
            String[] custCd = (JSPUtil.getParameter(request, prefix + "cust_cd", length));
            String[] fcastCustTpCd = (JSPUtil.getParameter(request, prefix + "fcast_cust_tp_cd", length));
            String[] usdBkgTtlWgt = (JSPUtil.getParameter(request, prefix + "usd_bkg_ttl_wgt", length));
            String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", length));
            for (int i = 0; i < length; i++) {
                model = new SearchDailyForecastHistorySrepAcctListVO();
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (usdBkg53ftQty[i] != null)
                    model.setUsdBkg53ftQty(usdBkg53ftQty[i]);
                if (usdBkg20ftQty[i] != null)
                    model.setUsdBkg20ftQty(usdBkg20ftQty[i]);
                if (fcastTtlTeuQty[i] != null)
                    model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
                if (usdBkg40ftQty[i] != null)
                    model.setUsdBkg40ftQty(usdBkg40ftQty[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (fcastTtlQty[i] != null)
                    model.setFcastTtlQty(fcastTtlQty[i]);
                if (usdBkgRfQty[i] != null)
                    model.setUsdBkgRfQty(usdBkgRfQty[i]);
                if (usdBkgTtlQty[i] != null)
                    model.setUsdBkgTtlQty(usdBkgTtlQty[i]);
                if (srepNm[i] != null)
                    model.setSrepNm(srepNm[i]);
                if (modiUsr[i] != null)
                    model.setModiUsr(modiUsr[i]);
                if (slsOfcCd[i] != null)
                    model.setSlsOfcCd(slsOfcCd[i]);
                if (fcast53ftQty[i] != null)
                    model.setFcast53ftQty(fcast53ftQty[i]);
                if (fcastTtlWgt[i] != null)
                    model.setFcastTtlWgt(fcastTtlWgt[i]);
                if (usdBkg40ftHcQty[i] != null)
                    model.setUsdBkg40ftHcQty(usdBkg40ftHcQty[i]);
                if (modiGdt[i] != null)
                    model.setModiGdt(modiGdt[i]);
                if (srepUsrId[i] != null)
                    model.setSrepUsrId(srepUsrId[i]);
                if (fcastRfQty[i] != null)
                    model.setFcastRfQty(fcastRfQty[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (lvl[i] != null)
                    model.setLvl(lvl[i]);
                if (usdBkg45ftHcQty[i] != null)
                    model.setUsdBkg45ftHcQty(usdBkg45ftHcQty[i]);
                if (fcast45ftHcQty[i] != null)
                    model.setFcast45ftHcQty(fcast45ftHcQty[i]);
                if (custCd[i] != null)
                    model.setCustCd(custCd[i]);
                if (fcastCustTpCd[i] != null)
                    model.setFcastCustTpCd(fcastCustTpCd[i]);
                if (usdBkgTtlWgt[i] != null)
                    model.setUsdBkgTtlWgt(usdBkgTtlWgt[i]);
                if (fcast40ftHcQty[i] != null)
                    model.setFcast40ftHcQty(fcast40ftHcQty[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchDailyForecastHistorySrepAcctListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchDailyForecastHistorySrepAcctListVO[]
	 */
    public SearchDailyForecastHistorySrepAcctListVO[] getSearchDailyForecastHistorySrepAcctListVOs() {
        SearchDailyForecastHistorySrepAcctListVO[] vos = (SearchDailyForecastHistorySrepAcctListVO[]) models.toArray(new SearchDailyForecastHistorySrepAcctListVO[models.size()]);
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
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkg53ftQty = this.usdBkg53ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkg20ftQty = this.usdBkg20ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlTeuQty = this.fcastTtlTeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkg40ftQty = this.usdBkg40ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlQty = this.fcastTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkgRfQty = this.usdBkgRfQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkgTtlQty = this.usdBkgTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepNm = this.srepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiUsr = this.modiUsr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsOfcCd = this.slsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast53ftQty = this.fcast53ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlWgt = this.fcastTtlWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkg40ftHcQty = this.usdBkg40ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modiGdt = this.modiGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepUsrId = this.srepUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastRfQty = this.fcastRfQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lvl = this.lvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkg45ftHcQty = this.usdBkg45ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast45ftHcQty = this.fcast45ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCd = this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastCustTpCd = this.fcastCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usdBkgTtlWgt = this.usdBkgTtlWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast40ftHcQty = this.fcast40ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scRfaNo = this.scRfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustCd = this.ctrtCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustNm = this.ctrtCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
