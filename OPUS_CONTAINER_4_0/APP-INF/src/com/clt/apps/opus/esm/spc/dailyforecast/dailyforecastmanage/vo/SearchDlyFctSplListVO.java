/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchDlyFctSplListVO.java
*@FileTitle : SearchDlyFctSplListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

import java.lang.reflect.Field;
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
public class SearchDlyFctSplListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchDlyFctSplListVO> models = new ArrayList<SearchDlyFctSplListVO>();

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String iocTsCd = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String pagerows = null;

    /* Column Info */
    private String fcastRfQty = null;

    /* Column Info */
    private String srepUsrId = null;

    /* Column Info */
    private String slsYrmon = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String ibflag = null;

    /* Column Info */
    private String fcastTtlQty = null;

    /* Column Info */
    private String fcastOfcCd = null;

    /* Column Info */
    private String fcast45ftHcQty = null;

    /* Column Info */
    private String costWk = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String fcastCustTpCd = null;

    /* Column Info */
    private String fcast40ftHcQty = null;

    /* Column Info */
    private String fcastTtlWgt = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String subTrdCd = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String ctrtCustCntCd = null;

    /* Column Info */
    private String ctrtCustSeq = null;

    /* Column Info */
    private String ctrtCustNm = null;

    /* Column Info */
    private String ctrtNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchDlyFctSplListVO() {
    }

    public SearchDlyFctSplListVO(String ibflag, String pagerows, String vslCd, String iocTsCd, String trdCd, String skdVoyNo, String rlaneCd, String custSeq, String skdDirCd, String fcastRfQty, String srepUsrId, String vvd, String fcastTtlQty, String fcast45ftHcQty, String fcastOfcCd, String polYdCd, String fcastCustTpCd, String fcast40ftHcQty, String fcastTtlWgt, String podYdCd, String subTrdCd, String custCntCd, String slsYrmon, String costWk, String scNo, String rfaNo, String ctrtCustCntCd, String ctrtCustSeq, String ctrtCustNm, String ctrtNo) {
        this.vslCd = vslCd;
        this.iocTsCd = iocTsCd;
        this.trdCd = trdCd;
        this.skdVoyNo = skdVoyNo;
        this.rlaneCd = rlaneCd;
        this.custSeq = custSeq;
        this.skdDirCd = skdDirCd;
        this.pagerows = pagerows;
        this.fcastRfQty = fcastRfQty;
        this.srepUsrId = srepUsrId;
        this.slsYrmon = slsYrmon;
        this.vvd = vvd;
        this.ibflag = ibflag;
        this.fcastTtlQty = fcastTtlQty;
        this.fcastOfcCd = fcastOfcCd;
        this.fcast45ftHcQty = fcast45ftHcQty;
        this.costWk = costWk;
        this.polYdCd = polYdCd;
        this.fcastCustTpCd = fcastCustTpCd;
        this.fcast40ftHcQty = fcast40ftHcQty;
        this.fcastTtlWgt = fcastTtlWgt;
        this.podYdCd = podYdCd;
        this.custCntCd = custCntCd;
        this.subTrdCd = subTrdCd;
        this.scNo = scNo;
        this.rfaNo = rfaNo;
        this.ctrtCustCntCd = ctrtCustCntCd;
        this.ctrtCustSeq = ctrtCustSeq;
        this.ctrtCustNm = ctrtCustNm;
        this.ctrtNo = ctrtNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("ioc_ts_cd", getIocTsCd());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
        this.hashColumns.put("srep_usr_id", getSrepUsrId());
        this.hashColumns.put("sls_yrmon", getSlsYrmon());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
        this.hashColumns.put("fcast_ofc_cd", getFcastOfcCd());
        this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
        this.hashColumns.put("cost_wk", getCostWk());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("fcast_cust_tp_cd", getFcastCustTpCd());
        this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
        this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("sub_trd_cd", getSubTrdCd());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
        this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
        this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
        this.hashColumns.put("ctrt_no", getCtrtNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("ioc_ts_cd", "iocTsCd");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("fcast_rf_qty", "fcastRfQty");
        this.hashFields.put("srep_usr_id", "srepUsrId");
        this.hashFields.put("sls_yrmon", "slsYrmon");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
        this.hashFields.put("fcast_ofc_cd", "fcastOfcCd");
        this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
        this.hashFields.put("cost_wk", "costWk");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("fcast_cust_tp_cd", "fcastCustTpCd");
        this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
        this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("sub_trd_cd", "subTrdCd");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
        this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
        this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
        this.hashFields.put("ctrt_no", "ctrtNo");
        return this.hashFields;
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
	 * @return iocTsCd
	 */
    public String getIocTsCd() {
        return this.iocTsCd;
    }

    /**
	 * Column Info
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
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
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
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
	 * @return skdDirCd
	 */
    public String getSkdDirCd() {
        return this.skdDirCd;
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
	 * @return fcastRfQty
	 */
    public String getFcastRfQty() {
        return this.fcastRfQty;
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
	 * @return slsYrmon
	 */
    public String getSlsYrmon() {
        return this.slsYrmon;
    }

    /**
	 * Column Info
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
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
	 * @return fcastTtlQty
	 */
    public String getFcastTtlQty() {
        return this.fcastTtlQty;
    }

    /**
	 * Column Info
	 * @return fcastOfcCd
	 */
    public String getFcastOfcCd() {
        return this.fcastOfcCd;
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
	 * @return costWk
	 */
    public String getCostWk() {
        return this.costWk;
    }

    /**
	 * Column Info
	 * @return polYdCd
	 */
    public String getPolYdCd() {
        return this.polYdCd;
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
	 * @return fcast40ftHcQty
	 */
    public String getFcast40ftHcQty() {
        return this.fcast40ftHcQty;
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
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
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
	 * @return subTrdCd
	 */
    public String getSubTrdCd() {
        return this.subTrdCd;
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
	 * @param iocTsCd
	 */
    public void setIocTsCd(String iocTsCd) {
        this.iocTsCd = iocTsCd;
    }

    /**
	 * Column Info
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
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
	 * @param skdDirCd
	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
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
	 * @param fcastRfQty
	 */
    public void setFcastRfQty(String fcastRfQty) {
        this.fcastRfQty = fcastRfQty;
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
	 * @param slsYrmon
	 */
    public void setSlsYrmon(String slsYrmon) {
        this.slsYrmon = slsYrmon;
    }

    /**
	 * Column Info
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
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
	 * @param fcastTtlQty
	 */
    public void setFcastTtlQty(String fcastTtlQty) {
        this.fcastTtlQty = fcastTtlQty;
    }

    /**
	 * Column Info
	 * @param fcastOfcCd
	 */
    public void setFcastOfcCd(String fcastOfcCd) {
        this.fcastOfcCd = fcastOfcCd;
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
	 * @param costWk
	 */
    public void setCostWk(String costWk) {
        this.costWk = costWk;
    }

    /**
	 * Column Info
	 * @param polYdCd
	 */
    public void setPolYdCd(String polYdCd) {
        this.polYdCd = polYdCd;
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
	 * @param fcast40ftHcQty
	 */
    public void setFcast40ftHcQty(String fcast40ftHcQty) {
        this.fcast40ftHcQty = fcast40ftHcQty;
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
	 * @param podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
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
	 * @param subTrdCd
	 */
    public void setSubTrdCd(String subTrdCd) {
        this.subTrdCd = subTrdCd;
    }

    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    public String getScNo() {
        return this.scNo;
    }

    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
    }

    public String getRfaNo() {
        return this.rfaNo;
    }

    public void setCtrtCustCntCd(String ctrtCustCntCd) {
        this.ctrtCustCntCd = ctrtCustCntCd;
    }

    public String getCtrtCustCntCd() {
        return this.ctrtCustCntCd;
    }

    public void setCtrtCustSeq(String ctrtCustSeq) {
        this.ctrtCustSeq = ctrtCustSeq;
    }

    public String getCtrtCustSeq() {
        return this.ctrtCustSeq;
    }

    public void setCtrtCustNm(String ctrtCustNm) {
        this.ctrtCustNm = ctrtCustNm;
    }

    public String getCtrtCustNm() {
        return this.ctrtCustNm;
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
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
        setSrepUsrId(JSPUtil.getParameter(request, prefix + "srep_usr_id", ""));
        setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
        setFcastOfcCd(JSPUtil.getParameter(request, prefix + "fcast_ofc_cd", ""));
        setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
        setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setFcastCustTpCd(JSPUtil.getParameter(request, prefix + "fcast_cust_tp_cd", ""));
        setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
        setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
        setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
        setCtrtCustNm(JSPUtil.getParameter(request, prefix + "ctrt_cust_nm", ""));
        setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDlyFctSplListVO[]
	 */
    public SearchDlyFctSplListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDlyFctSplListVO[]
	 */
    public SearchDlyFctSplListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchDlyFctSplListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] iocTsCd = (JSPUtil.getParameter(request, prefix + "ioc_ts_cd", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] fcastRfQty = (JSPUtil.getParameter(request, prefix + "fcast_rf_qty", length));
            String[] srepUsrId = (JSPUtil.getParameter(request, prefix + "srep_usr_id", length));
            String[] slsYrmon = (JSPUtil.getParameter(request, prefix + "sls_yrmon", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", length));
            String[] fcastOfcCd = (JSPUtil.getParameter(request, prefix + "fcast_ofc_cd", length));
            String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", length));
            String[] costWk = (JSPUtil.getParameter(request, prefix + "cost_wk", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] fcastCustTpCd = (JSPUtil.getParameter(request, prefix + "fcast_cust_tp_cd", length));
            String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", length));
            String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] subTrdCd = (JSPUtil.getParameter(request, prefix + "sub_trd_cd", length));
            for (int i = 0; i < length; i++) {
                model = new SearchDlyFctSplListVO();
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (iocTsCd[i] != null)
                    model.setIocTsCd(iocTsCd[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (fcastRfQty[i] != null)
                    model.setFcastRfQty(fcastRfQty[i]);
                if (srepUsrId[i] != null)
                    model.setSrepUsrId(srepUsrId[i]);
                if (slsYrmon[i] != null)
                    model.setSlsYrmon(slsYrmon[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (fcastTtlQty[i] != null)
                    model.setFcastTtlQty(fcastTtlQty[i]);
                if (fcastOfcCd[i] != null)
                    model.setFcastOfcCd(fcastOfcCd[i]);
                if (fcast45ftHcQty[i] != null)
                    model.setFcast45ftHcQty(fcast45ftHcQty[i]);
                if (costWk[i] != null)
                    model.setCostWk(costWk[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (fcastCustTpCd[i] != null)
                    model.setFcastCustTpCd(fcastCustTpCd[i]);
                if (fcast40ftHcQty[i] != null)
                    model.setFcast40ftHcQty(fcast40ftHcQty[i]);
                if (fcastTtlWgt[i] != null)
                    model.setFcastTtlWgt(fcastTtlWgt[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (subTrdCd[i] != null)
                    model.setSubTrdCd(subTrdCd[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchDlyFctSplListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchDlyFctSplListVO[]
	 */
    public SearchDlyFctSplListVO[] getSearchDlyFctSplListVOs() {
        SearchDlyFctSplListVO[] vos = (SearchDlyFctSplListVO[]) models.toArray(new SearchDlyFctSplListVO[models.size()]);
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
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iocTsCd = this.iocTsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastRfQty = this.fcastRfQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepUsrId = this.srepUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slsYrmon = this.slsYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlQty = this.fcastTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastOfcCd = this.fcastOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast45ftHcQty = this.fcast45ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costWk = this.costWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastCustTpCd = this.fcastCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast40ftHcQty = this.fcast40ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlWgt = this.fcastTtlWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subTrdCd = this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustCntCd = this.ctrtCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustSeq = this.ctrtCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustNm = this.ctrtCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
