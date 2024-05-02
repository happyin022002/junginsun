/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchDailyForecastManageListVO.java
*@FileTitle : SearchDailyForecastManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.24  
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
public class SearchDailyForecastManageListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchDailyForecastManageListVO> models = new ArrayList<SearchDailyForecastManageListVO>();

    /* Column Info */
    private String cfm40ftHcQty = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String cfmRfQty = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Column Info */
    private String lvl2 = null;

    /* Column Info */
    private String srepCd = null;

    /* Column Info */
    private String pagerows = null;

    /* Column Info */
    private String ctrl53 = null;

    /* Column Info */
    private String bkg45ftHcQty = null;

    /* Column Info */
    private String lvl1 = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String rnum = null;

    /* Column Info */
    private String bkgRfQty = null;

    /* Column Info */
    private String custCntCd = null;

    /* Column Info */
    private String cfm53ftQty = null;

    /* Column Info */
    private String bkgTtlQty = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String bkgCnt = null;

    /* Column Info */
    private String podSeq = null;

    /* Column Info */
    private String fcastRfQty = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String bkgTtlWgt = null;

    /* Column Info */
    private String fcast45ftHcRat = null;

    /* Column Info */
    private String lvl = null;

    /* Column Info */
    private String chl = null;

    /* Column Info */
    private String costWk = null;

    /* Column Info */
    private String ctrlWt = null;

    /* Column Info */
    private String bkg40ftQty = null;

    /* Column Info */
    private String bkg40ftHcQty = null;

    /* Column Info */
    private String fcast40ftHcQty = null;

    /* Column Info */
    private String cfm45ftHcQty = null;

    /* Column Info */
    private String subTrdCd = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String polSeq = null;

    /* Column Info */
    private String ctrlLvl = null;

    /* Column Info */
    private String fcastCnt = null;

    /* Column Info */
    private String fcastTtlTeuQty = null;

    /* Column Info */
    private String cfmTtlQty = null;

    /* Column Info */
    private String bkg20ftQty = null;

    /* Column Info */
    private String ibflag = null;

    /* Column Info */
    private String ctrlRf = null;

    /* Column Info */
    private String fcastTtlQty = null;

    /* Column Info */
    private String srepNm = null;

    /* Column Info */
    private String fcast53ftQty = null;

    /* Column Info */
    private String fcast40ftHcRat = null;

    /* Column Info */
    private String dirCd = null;

    /* Column Info */
    private String fcastTtlWgt = null;

    /* Column Info */
    private String rgnOfcCd = null;

    /* Column Info */
    private String custTpCd = null;

    /* Column Info */
    private String iocTsCd = null;

    /* Column Info */
    private String cfmTtlWgt = null;

    /* Column Info */
    private String subOfcCd = null;

    /* Column Info */
    private String mstCnt = null;

    /* Column Info */
    private String custSeq = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String ctrl45 = null;

    /* Column Info */
    private String fcast45ftHcQty = null;

    /* Column Info */
    private String costYr = null;

    /* Column Info */
    private String bkg53ftQty = null;

    /* Column Info */
    private String ctrlHc = null;

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

    public SearchDailyForecastManageListVO() {
    }

    public SearchDailyForecastManageListVO(String ibflag, String pagerows, String cfm40ftHcQty, String vslCd, String cfmRfQty, String trdCd, String rlaneCd, String lvl2, String srepCd, String ctrl53, String bkg45ftHcQty, String lvl1, String polCd, String rnum, String bkgRfQty, String custCntCd, String cfm53ftQty, String bkgTtlQty, String skdVoyNo, String bkgCnt, String podSeq, String fcastRfQty, String podCd, String bkgTtlWgt, String lvl, String chl, String costWk, String ctrlWt, String bkg40ftQty, String bkg40ftHcQty, String fcast40ftHcQty, String cfm45ftHcQty, String subTrdCd, String custNm, String polSeq, String ctrlLvl, String fcastCnt, String fcastTtlTeuQty, String cfmTtlQty, String bkg20ftQty, String ctrlRf, String fcastTtlQty, String srepNm, String fcast53ftQty, String dirCd, String fcastTtlWgt, String rgnOfcCd, String custTpCd, String iocTsCd, String cfmTtlWgt, String subOfcCd, String mstCnt, String custSeq, String skdDirCd, String ofcCd, String ctrl45, String costYr, String fcast45ftHcQty, String bkg53ftQty, String ctrlHc, String fcast40ftHcRat, String fcast45ftHcRat, String scNo, String rfaNo, String ctrtCustCntCd, String ctrtCustSeq, String ctrtCustNm, String ctrtNo) {
        this.cfm40ftHcQty = cfm40ftHcQty;
        this.vslCd = vslCd;
        this.cfmRfQty = cfmRfQty;
        this.trdCd = trdCd;
        this.rlaneCd = rlaneCd;
        this.lvl2 = lvl2;
        this.srepCd = srepCd;
        this.pagerows = pagerows;
        this.ctrl53 = ctrl53;
        this.bkg45ftHcQty = bkg45ftHcQty;
        this.lvl1 = lvl1;
        this.polCd = polCd;
        this.rnum = rnum;
        this.bkgRfQty = bkgRfQty;
        this.custCntCd = custCntCd;
        this.cfm53ftQty = cfm53ftQty;
        this.bkgTtlQty = bkgTtlQty;
        this.skdVoyNo = skdVoyNo;
        this.bkgCnt = bkgCnt;
        this.podSeq = podSeq;
        this.fcastRfQty = fcastRfQty;
        this.podCd = podCd;
        this.bkgTtlWgt = bkgTtlWgt;
        this.fcast45ftHcRat = fcast45ftHcRat;
        this.lvl = lvl;
        this.chl = chl;
        this.costWk = costWk;
        this.ctrlWt = ctrlWt;
        this.bkg40ftQty = bkg40ftQty;
        this.bkg40ftHcQty = bkg40ftHcQty;
        this.fcast40ftHcQty = fcast40ftHcQty;
        this.cfm45ftHcQty = cfm45ftHcQty;
        this.subTrdCd = subTrdCd;
        this.custNm = custNm;
        this.polSeq = polSeq;
        this.ctrlLvl = ctrlLvl;
        this.fcastCnt = fcastCnt;
        this.fcastTtlTeuQty = fcastTtlTeuQty;
        this.cfmTtlQty = cfmTtlQty;
        this.bkg20ftQty = bkg20ftQty;
        this.ibflag = ibflag;
        this.ctrlRf = ctrlRf;
        this.fcastTtlQty = fcastTtlQty;
        this.srepNm = srepNm;
        this.fcast53ftQty = fcast53ftQty;
        this.fcast40ftHcRat = fcast40ftHcRat;
        this.dirCd = dirCd;
        this.fcastTtlWgt = fcastTtlWgt;
        this.rgnOfcCd = rgnOfcCd;
        this.custTpCd = custTpCd;
        this.iocTsCd = iocTsCd;
        this.cfmTtlWgt = cfmTtlWgt;
        this.subOfcCd = subOfcCd;
        this.mstCnt = mstCnt;
        this.custSeq = custSeq;
        this.skdDirCd = skdDirCd;
        this.ofcCd = ofcCd;
        this.ctrl45 = ctrl45;
        this.fcast45ftHcQty = fcast45ftHcQty;
        this.costYr = costYr;
        this.bkg53ftQty = bkg53ftQty;
        this.ctrlHc = ctrlHc;
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
        this.hashColumns.put("cfm_40ft_hc_qty", getCfm40ftHcQty());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("cfm_rf_qty", getCfmRfQty());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("lvl2", getLvl2());
        this.hashColumns.put("srep_cd", getSrepCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ctrl_53", getCtrl53());
        this.hashColumns.put("bkg_45ft_hc_qty", getBkg45ftHcQty());
        this.hashColumns.put("lvl1", getLvl1());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("rnum", getRnum());
        this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
        this.hashColumns.put("cust_cnt_cd", getCustCntCd());
        this.hashColumns.put("cfm_53ft_qty", getCfm53ftQty());
        this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("bkg_cnt", getBkgCnt());
        this.hashColumns.put("pod_seq", getPodSeq());
        this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("bkg_ttl_wgt", getBkgTtlWgt());
        this.hashColumns.put("fcast_45ft_hc_rat", getFcast45ftHcRat());
        this.hashColumns.put("lvl", getLvl());
        this.hashColumns.put("chl", getChl());
        this.hashColumns.put("cost_wk", getCostWk());
        this.hashColumns.put("ctrl_wt", getCtrlWt());
        this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
        this.hashColumns.put("bkg_40ft_hc_qty", getBkg40ftHcQty());
        this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
        this.hashColumns.put("cfm_45ft_hc_qty", getCfm45ftHcQty());
        this.hashColumns.put("sub_trd_cd", getSubTrdCd());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("pol_seq", getPolSeq());
        this.hashColumns.put("ctrl_lvl", getCtrlLvl());
        this.hashColumns.put("fcast_cnt", getFcastCnt());
        this.hashColumns.put("fcast_ttl_teu_qty", getFcastTtlTeuQty());
        this.hashColumns.put("cfm_ttl_qty", getCfmTtlQty());
        this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("ctrl_rf", getCtrlRf());
        this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
        this.hashColumns.put("srep_nm", getSrepNm());
        this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
        this.hashColumns.put("fcast_40ft_hc_rat", getFcast40ftHcRat());
        this.hashColumns.put("dir_cd", getDirCd());
        this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
        this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
        this.hashColumns.put("cust_tp_cd", getCustTpCd());
        this.hashColumns.put("ioc_ts_cd", getIocTsCd());
        this.hashColumns.put("cfm_ttl_wgt", getCfmTtlWgt());
        this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
        this.hashColumns.put("mst_cnt", getMstCnt());
        this.hashColumns.put("cust_seq", getCustSeq());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("ctrl_45", getCtrl45());
        this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
        this.hashColumns.put("cost_yr", getCostYr());
        this.hashColumns.put("bkg_53ft_qty", getBkg53ftQty());
        this.hashColumns.put("ctrl_hc", getCtrlHc());
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
        this.hashFields.put("cfm_40ft_hc_qty", "cfm40ftHcQty");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("cfm_rf_qty", "cfmRfQty");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("lvl2", "lvl2");
        this.hashFields.put("srep_cd", "srepCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ctrl_53", "ctrl53");
        this.hashFields.put("bkg_45ft_hc_qty", "bkg45ftHcQty");
        this.hashFields.put("lvl1", "lvl1");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("rnum", "rnum");
        this.hashFields.put("bkg_rf_qty", "bkgRfQty");
        this.hashFields.put("cust_cnt_cd", "custCntCd");
        this.hashFields.put("cfm_53ft_qty", "cfm53ftQty");
        this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("bkg_cnt", "bkgCnt");
        this.hashFields.put("pod_seq", "podSeq");
        this.hashFields.put("fcast_rf_qty", "fcastRfQty");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("bkg_ttl_wgt", "bkgTtlWgt");
        this.hashFields.put("fcast_45ft_hc_rat", "fcast45ftHcRat");
        this.hashFields.put("lvl", "lvl");
        this.hashFields.put("chl", "chl");
        this.hashFields.put("cost_wk", "costWk");
        this.hashFields.put("ctrl_wt", "ctrlWt");
        this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
        this.hashFields.put("bkg_40ft_hc_qty", "bkg40ftHcQty");
        this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
        this.hashFields.put("cfm_45ft_hc_qty", "cfm45ftHcQty");
        this.hashFields.put("sub_trd_cd", "subTrdCd");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("pol_seq", "polSeq");
        this.hashFields.put("ctrl_lvl", "ctrlLvl");
        this.hashFields.put("fcast_cnt", "fcastCnt");
        this.hashFields.put("fcast_ttl_teu_qty", "fcastTtlTeuQty");
        this.hashFields.put("cfm_ttl_qty", "cfmTtlQty");
        this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("ctrl_rf", "ctrlRf");
        this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
        this.hashFields.put("srep_nm", "srepNm");
        this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
        this.hashFields.put("fcast_40ft_hc_rat", "fcast40ftHcRat");
        this.hashFields.put("dir_cd", "dirCd");
        this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
        this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
        this.hashFields.put("cust_tp_cd", "custTpCd");
        this.hashFields.put("ioc_ts_cd", "iocTsCd");
        this.hashFields.put("cfm_ttl_wgt", "cfmTtlWgt");
        this.hashFields.put("sub_ofc_cd", "subOfcCd");
        this.hashFields.put("mst_cnt", "mstCnt");
        this.hashFields.put("cust_seq", "custSeq");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("ctrl_45", "ctrl45");
        this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
        this.hashFields.put("cost_yr", "costYr");
        this.hashFields.put("bkg_53ft_qty", "bkg53ftQty");
        this.hashFields.put("ctrl_hc", "ctrlHc");
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
	 * @return cfm40ftHcQty
	 */
    public String getCfm40ftHcQty() {
        return this.cfm40ftHcQty;
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
	 * @return cfmRfQty
	 */
    public String getCfmRfQty() {
        return this.cfmRfQty;
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
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
    }

    /**
	 * Column Info
	 * @return lvl2
	 */
    public String getLvl2() {
        return this.lvl2;
    }

    /**
	 * Column Info
	 * @return srepCd
	 */
    public String getSrepCd() {
        return this.srepCd;
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
	 * @return ctrl53
	 */
    public String getCtrl53() {
        return this.ctrl53;
    }

    /**
	 * Column Info
	 * @return bkg45ftHcQty
	 */
    public String getBkg45ftHcQty() {
        return this.bkg45ftHcQty;
    }

    /**
	 * Column Info
	 * @return lvl1
	 */
    public String getLvl1() {
        return this.lvl1;
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
	 * @return rnum
	 */
    public String getRnum() {
        return this.rnum;
    }

    /**
	 * Column Info
	 * @return bkgRfQty
	 */
    public String getBkgRfQty() {
        return this.bkgRfQty;
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
	 * @return cfm53ftQty
	 */
    public String getCfm53ftQty() {
        return this.cfm53ftQty;
    }

    /**
	 * Column Info
	 * @return bkgTtlQty
	 */
    public String getBkgTtlQty() {
        return this.bkgTtlQty;
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
	 * @return bkgCnt
	 */
    public String getBkgCnt() {
        return this.bkgCnt;
    }

    /**
	 * Column Info
	 * @return podSeq
	 */
    public String getPodSeq() {
        return this.podSeq;
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
	 * @return bkgTtlWgt
	 */
    public String getBkgTtlWgt() {
        return this.bkgTtlWgt;
    }

    /**
	 * Column Info
	 * @return fcast45ftHcRat
	 */
    public String getFcast45ftHcRat() {
        return this.fcast45ftHcRat;
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
	 * @return chl
	 */
    public String getChl() {
        return this.chl;
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
	 * @return ctrlWt
	 */
    public String getCtrlWt() {
        return this.ctrlWt;
    }

    /**
	 * Column Info
	 * @return bkg40ftQty
	 */
    public String getBkg40ftQty() {
        return this.bkg40ftQty;
    }

    /**
	 * Column Info
	 * @return bkg40ftHcQty
	 */
    public String getBkg40ftHcQty() {
        return this.bkg40ftHcQty;
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
	 * @return cfm45ftHcQty
	 */
    public String getCfm45ftHcQty() {
        return this.cfm45ftHcQty;
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
	 * @return custNm
	 */
    public String getCustNm() {
        return this.custNm;
    }

    /**
	 * Column Info
	 * @return polSeq
	 */
    public String getPolSeq() {
        return this.polSeq;
    }

    /**
	 * Column Info
	 * @return ctrlLvl
	 */
    public String getCtrlLvl() {
        return this.ctrlLvl;
    }

    /**
	 * Column Info
	 * @return fcastCnt
	 */
    public String getFcastCnt() {
        return this.fcastCnt;
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
	 * @return cfmTtlQty
	 */
    public String getCfmTtlQty() {
        return this.cfmTtlQty;
    }

    /**
	 * Column Info
	 * @return bkg20ftQty
	 */
    public String getBkg20ftQty() {
        return this.bkg20ftQty;
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
	 * @return ctrlRf
	 */
    public String getCtrlRf() {
        return this.ctrlRf;
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
	 * @return srepNm
	 */
    public String getSrepNm() {
        return this.srepNm;
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
	 * @return fcast40ftHcRat
	 */
    public String getFcast40ftHcRat() {
        return this.fcast40ftHcRat;
    }

    /**
	 * Column Info
	 * @return dirCd
	 */
    public String getDirCd() {
        return this.dirCd;
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
	 * @return rgnOfcCd
	 */
    public String getRgnOfcCd() {
        return this.rgnOfcCd;
    }

    /**
	 * Column Info
	 * @return custTpCd
	 */
    public String getCustTpCd() {
        return this.custTpCd;
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
	 * @return cfmTtlWgt
	 */
    public String getCfmTtlWgt() {
        return this.cfmTtlWgt;
    }

    /**
	 * Column Info
	 * @return subOfcCd
	 */
    public String getSubOfcCd() {
        return this.subOfcCd;
    }

    /**
	 * Column Info
	 * @return mstCnt
	 */
    public String getMstCnt() {
        return this.mstCnt;
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
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return ctrl45
	 */
    public String getCtrl45() {
        return this.ctrl45;
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
	 * @return costYr
	 */
    public String getCostYr() {
        return this.costYr;
    }

    /**
	 * Column Info
	 * @return bkg53ftQty
	 */
    public String getBkg53ftQty() {
        return this.bkg53ftQty;
    }

    /**
	 * Column Info
	 * @return ctrlHc
	 */
    public String getCtrlHc() {
        return this.ctrlHc;
    }

    /**
	 * Column Info
	 * @param cfm40ftHcQty
	 */
    public void setCfm40ftHcQty(String cfm40ftHcQty) {
        this.cfm40ftHcQty = cfm40ftHcQty;
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
	 * @param cfmRfQty
	 */
    public void setCfmRfQty(String cfmRfQty) {
        this.cfmRfQty = cfmRfQty;
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
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
    }

    /**
	 * Column Info
	 * @param lvl2
	 */
    public void setLvl2(String lvl2) {
        this.lvl2 = lvl2;
    }

    /**
	 * Column Info
	 * @param srepCd
	 */
    public void setSrepCd(String srepCd) {
        this.srepCd = srepCd;
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
	 * @param ctrl53
	 */
    public void setCtrl53(String ctrl53) {
        this.ctrl53 = ctrl53;
    }

    /**
	 * Column Info
	 * @param bkg45ftHcQty
	 */
    public void setBkg45ftHcQty(String bkg45ftHcQty) {
        this.bkg45ftHcQty = bkg45ftHcQty;
    }

    /**
	 * Column Info
	 * @param lvl1
	 */
    public void setLvl1(String lvl1) {
        this.lvl1 = lvl1;
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
	 * @param rnum
	 */
    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    /**
	 * Column Info
	 * @param bkgRfQty
	 */
    public void setBkgRfQty(String bkgRfQty) {
        this.bkgRfQty = bkgRfQty;
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
	 * @param cfm53ftQty
	 */
    public void setCfm53ftQty(String cfm53ftQty) {
        this.cfm53ftQty = cfm53ftQty;
    }

    /**
	 * Column Info
	 * @param bkgTtlQty
	 */
    public void setBkgTtlQty(String bkgTtlQty) {
        this.bkgTtlQty = bkgTtlQty;
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
	 * @param bkgCnt
	 */
    public void setBkgCnt(String bkgCnt) {
        this.bkgCnt = bkgCnt;
    }

    /**
	 * Column Info
	 * @param podSeq
	 */
    public void setPodSeq(String podSeq) {
        this.podSeq = podSeq;
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
	 * @param bkgTtlWgt
	 */
    public void setBkgTtlWgt(String bkgTtlWgt) {
        this.bkgTtlWgt = bkgTtlWgt;
    }

    /**
	 * Column Info
	 * @param fcast45ftHcRat
	 */
    public void setFcast45ftHcRat(String fcast45ftHcRat) {
        this.fcast45ftHcRat = fcast45ftHcRat;
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
	 * @param chl
	 */
    public void setChl(String chl) {
        this.chl = chl;
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
	 * @param ctrlWt
	 */
    public void setCtrlWt(String ctrlWt) {
        this.ctrlWt = ctrlWt;
    }

    /**
	 * Column Info
	 * @param bkg40ftQty
	 */
    public void setBkg40ftQty(String bkg40ftQty) {
        this.bkg40ftQty = bkg40ftQty;
    }

    /**
	 * Column Info
	 * @param bkg40ftHcQty
	 */
    public void setBkg40ftHcQty(String bkg40ftHcQty) {
        this.bkg40ftHcQty = bkg40ftHcQty;
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
	 * @param cfm45ftHcQty
	 */
    public void setCfm45ftHcQty(String cfm45ftHcQty) {
        this.cfm45ftHcQty = cfm45ftHcQty;
    }

    /**
	 * Column Info
	 * @param subTrdCd
	 */
    public void setSubTrdCd(String subTrdCd) {
        this.subTrdCd = subTrdCd;
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
	 * @param polSeq
	 */
    public void setPolSeq(String polSeq) {
        this.polSeq = polSeq;
    }

    /**
	 * Column Info
	 * @param ctrlLvl
	 */
    public void setCtrlLvl(String ctrlLvl) {
        this.ctrlLvl = ctrlLvl;
    }

    /**
	 * Column Info
	 * @param fcastCnt
	 */
    public void setFcastCnt(String fcastCnt) {
        this.fcastCnt = fcastCnt;
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
	 * @param cfmTtlQty
	 */
    public void setCfmTtlQty(String cfmTtlQty) {
        this.cfmTtlQty = cfmTtlQty;
    }

    /**
	 * Column Info
	 * @param bkg20ftQty
	 */
    public void setBkg20ftQty(String bkg20ftQty) {
        this.bkg20ftQty = bkg20ftQty;
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
	 * @param ctrlRf
	 */
    public void setCtrlRf(String ctrlRf) {
        this.ctrlRf = ctrlRf;
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
	 * @param srepNm
	 */
    public void setSrepNm(String srepNm) {
        this.srepNm = srepNm;
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
	 * @param fcast40ftHcRat
	 */
    public void setFcast40ftHcRat(String fcast40ftHcRat) {
        this.fcast40ftHcRat = fcast40ftHcRat;
    }

    /**
	 * Column Info
	 * @param dirCd
	 */
    public void setDirCd(String dirCd) {
        this.dirCd = dirCd;
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
	 * @param rgnOfcCd
	 */
    public void setRgnOfcCd(String rgnOfcCd) {
        this.rgnOfcCd = rgnOfcCd;
    }

    /**
	 * Column Info
	 * @param custTpCd
	 */
    public void setCustTpCd(String custTpCd) {
        this.custTpCd = custTpCd;
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
	 * @param cfmTtlWgt
	 */
    public void setCfmTtlWgt(String cfmTtlWgt) {
        this.cfmTtlWgt = cfmTtlWgt;
    }

    /**
	 * Column Info
	 * @param subOfcCd
	 */
    public void setSubOfcCd(String subOfcCd) {
        this.subOfcCd = subOfcCd;
    }

    /**
	 * Column Info
	 * @param mstCnt
	 */
    public void setMstCnt(String mstCnt) {
        this.mstCnt = mstCnt;
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
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param ctrl45
	 */
    public void setCtrl45(String ctrl45) {
        this.ctrl45 = ctrl45;
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
	 * @param costYr
	 */
    public void setCostYr(String costYr) {
        this.costYr = costYr;
    }

    /**
	 * Column Info
	 * @param bkg53ftQty
	 */
    public void setBkg53ftQty(String bkg53ftQty) {
        this.bkg53ftQty = bkg53ftQty;
    }

    /**
	 * Column Info
	 * @param ctrlHc
	 */
    public void setCtrlHc(String ctrlHc) {
        this.ctrlHc = ctrlHc;
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
        setCfm40ftHcQty(JSPUtil.getParameter(request, prefix + "cfm_40ft_hc_qty", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setCfmRfQty(JSPUtil.getParameter(request, prefix + "cfm_rf_qty", ""));
        setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
        setLvl2(JSPUtil.getParameter(request, prefix + "lvl2", ""));
        setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCtrl53(JSPUtil.getParameter(request, prefix + "ctrl_53", ""));
        setBkg45ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", ""));
        setLvl1(JSPUtil.getParameter(request, prefix + "lvl1", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
        setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
        setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
        setCfm53ftQty(JSPUtil.getParameter(request, prefix + "cfm_53ft_qty", ""));
        setBkgTtlQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
        setPodSeq(JSPUtil.getParameter(request, prefix + "pod_seq", ""));
        setFcastRfQty(JSPUtil.getParameter(request, prefix + "fcast_rf_qty", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setBkgTtlWgt(JSPUtil.getParameter(request, prefix + "bkg_ttl_wgt", ""));
        setFcast45ftHcRat(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_rat", ""));
        setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
        setChl(JSPUtil.getParameter(request, prefix + "chl", ""));
        setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
        setCtrlWt(JSPUtil.getParameter(request, prefix + "ctrl_wt", ""));
        setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
        setBkg40ftHcQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", ""));
        setFcast40ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", ""));
        setCfm45ftHcQty(JSPUtil.getParameter(request, prefix + "cfm_45ft_hc_qty", ""));
        setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setPolSeq(JSPUtil.getParameter(request, prefix + "pol_seq", ""));
        setCtrlLvl(JSPUtil.getParameter(request, prefix + "ctrl_lvl", ""));
        setFcastCnt(JSPUtil.getParameter(request, prefix + "fcast_cnt", ""));
        setFcastTtlTeuQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", ""));
        setCfmTtlQty(JSPUtil.getParameter(request, prefix + "cfm_ttl_qty", ""));
        setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setCtrlRf(JSPUtil.getParameter(request, prefix + "ctrl_rf", ""));
        setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
        setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
        setFcast53ftQty(JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", ""));
        setFcast40ftHcRat(JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_rat", ""));
        setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
        setFcastTtlWgt(JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", ""));
        setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
        setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
        setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
        setCfmTtlWgt(JSPUtil.getParameter(request, prefix + "cfm_ttl_wgt", ""));
        setSubOfcCd(JSPUtil.getParameter(request, prefix + "sub_ofc_cd", ""));
        setMstCnt(JSPUtil.getParameter(request, prefix + "mst_cnt", ""));
        setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setCtrl45(JSPUtil.getParameter(request, prefix + "ctrl_45", ""));
        setFcast45ftHcQty(JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", ""));
        setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
        setBkg53ftQty(JSPUtil.getParameter(request, prefix + "bkg_53ft_qty", ""));
        setCtrlHc(JSPUtil.getParameter(request, prefix + "ctrl_hc", ""));
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
	 * @return SearchDailyForecastManageListVO[]
	 */
    public SearchDailyForecastManageListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastManageListVO[]
	 */
    public SearchDailyForecastManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchDailyForecastManageListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cfm40ftHcQty = (JSPUtil.getParameter(request, prefix + "cfm_40ft_hc_qty", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] cfmRfQty = (JSPUtil.getParameter(request, prefix + "cfm_rf_qty", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] lvl2 = (JSPUtil.getParameter(request, prefix + "lvl2", length));
            String[] srepCd = (JSPUtil.getParameter(request, prefix + "srep_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] ctrl53 = (JSPUtil.getParameter(request, prefix + "ctrl_53", length));
            String[] bkg45ftHcQty = (JSPUtil.getParameter(request, prefix + "bkg_45ft_hc_qty", length));
            String[] lvl1 = (JSPUtil.getParameter(request, prefix + "lvl1", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] rnum = (JSPUtil.getParameter(request, prefix + "rnum", length));
            String[] bkgRfQty = (JSPUtil.getParameter(request, prefix + "bkg_rf_qty", length));
            String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
            String[] cfm53ftQty = (JSPUtil.getParameter(request, prefix + "cfm_53ft_qty", length));
            String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] bkgCnt = (JSPUtil.getParameter(request, prefix + "bkg_cnt", length));
            String[] podSeq = (JSPUtil.getParameter(request, prefix + "pod_seq", length));
            String[] fcastRfQty = (JSPUtil.getParameter(request, prefix + "fcast_rf_qty", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] bkgTtlWgt = (JSPUtil.getParameter(request, prefix + "bkg_ttl_wgt", length));
            String[] fcast45ftHcRat = (JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_rat", length));
            String[] lvl = (JSPUtil.getParameter(request, prefix + "lvl", length));
            String[] chl = (JSPUtil.getParameter(request, prefix + "chl", length));
            String[] costWk = (JSPUtil.getParameter(request, prefix + "cost_wk", length));
            String[] ctrlWt = (JSPUtil.getParameter(request, prefix + "ctrl_wt", length));
            String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", length));
            String[] bkg40ftHcQty = (JSPUtil.getParameter(request, prefix + "bkg_40ft_hc_qty", length));
            String[] fcast40ftHcQty = (JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_qty", length));
            String[] cfm45ftHcQty = (JSPUtil.getParameter(request, prefix + "cfm_45ft_hc_qty", length));
            String[] subTrdCd = (JSPUtil.getParameter(request, prefix + "sub_trd_cd", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] polSeq = (JSPUtil.getParameter(request, prefix + "pol_seq", length));
            String[] ctrlLvl = (JSPUtil.getParameter(request, prefix + "ctrl_lvl", length));
            String[] fcastCnt = (JSPUtil.getParameter(request, prefix + "fcast_cnt", length));
            String[] fcastTtlTeuQty = (JSPUtil.getParameter(request, prefix + "fcast_ttl_teu_qty", length));
            String[] cfmTtlQty = (JSPUtil.getParameter(request, prefix + "cfm_ttl_qty", length));
            String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] ctrlRf = (JSPUtil.getParameter(request, prefix + "ctrl_rf", length));
            String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", length));
            String[] srepNm = (JSPUtil.getParameter(request, prefix + "srep_nm", length));
            String[] fcast53ftQty = (JSPUtil.getParameter(request, prefix + "fcast_53ft_qty", length));
            String[] fcast40ftHcRat = (JSPUtil.getParameter(request, prefix + "fcast_40ft_hc_rat", length));
            String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
            String[] fcastTtlWgt = (JSPUtil.getParameter(request, prefix + "fcast_ttl_wgt", length));
            String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", length));
            String[] custTpCd = (JSPUtil.getParameter(request, prefix + "cust_tp_cd", length));
            String[] iocTsCd = (JSPUtil.getParameter(request, prefix + "ioc_ts_cd", length));
            String[] cfmTtlWgt = (JSPUtil.getParameter(request, prefix + "cfm_ttl_wgt", length));
            String[] subOfcCd = (JSPUtil.getParameter(request, prefix + "sub_ofc_cd", length));
            String[] mstCnt = (JSPUtil.getParameter(request, prefix + "mst_cnt", length));
            String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] ctrl45 = (JSPUtil.getParameter(request, prefix + "ctrl_45", length));
            String[] fcast45ftHcQty = (JSPUtil.getParameter(request, prefix + "fcast_45ft_hc_qty", length));
            String[] costYr = (JSPUtil.getParameter(request, prefix + "cost_yr", length));
            String[] bkg53ftQty = (JSPUtil.getParameter(request, prefix + "bkg_53ft_qty", length));
            String[] ctrlHc = (JSPUtil.getParameter(request, prefix + "ctrl_hc", length));
            for (int i = 0; i < length; i++) {
                model = new SearchDailyForecastManageListVO();
                if (cfm40ftHcQty[i] != null)
                    model.setCfm40ftHcQty(cfm40ftHcQty[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (cfmRfQty[i] != null)
                    model.setCfmRfQty(cfmRfQty[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (lvl2[i] != null)
                    model.setLvl2(lvl2[i]);
                if (srepCd[i] != null)
                    model.setSrepCd(srepCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (ctrl53[i] != null)
                    model.setCtrl53(ctrl53[i]);
                if (bkg45ftHcQty[i] != null)
                    model.setBkg45ftHcQty(bkg45ftHcQty[i]);
                if (lvl1[i] != null)
                    model.setLvl1(lvl1[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (rnum[i] != null)
                    model.setRnum(rnum[i]);
                if (bkgRfQty[i] != null)
                    model.setBkgRfQty(bkgRfQty[i]);
                if (custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if (cfm53ftQty[i] != null)
                    model.setCfm53ftQty(cfm53ftQty[i]);
                if (bkgTtlQty[i] != null)
                    model.setBkgTtlQty(bkgTtlQty[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (bkgCnt[i] != null)
                    model.setBkgCnt(bkgCnt[i]);
                if (podSeq[i] != null)
                    model.setPodSeq(podSeq[i]);
                if (fcastRfQty[i] != null)
                    model.setFcastRfQty(fcastRfQty[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (bkgTtlWgt[i] != null)
                    model.setBkgTtlWgt(bkgTtlWgt[i]);
                if (fcast45ftHcRat[i] != null)
                    model.setFcast45ftHcRat(fcast45ftHcRat[i]);
                if (lvl[i] != null)
                    model.setLvl(lvl[i]);
                if (chl[i] != null)
                    model.setChl(chl[i]);
                if (costWk[i] != null)
                    model.setCostWk(costWk[i]);
                if (ctrlWt[i] != null)
                    model.setCtrlWt(ctrlWt[i]);
                if (bkg40ftQty[i] != null)
                    model.setBkg40ftQty(bkg40ftQty[i]);
                if (bkg40ftHcQty[i] != null)
                    model.setBkg40ftHcQty(bkg40ftHcQty[i]);
                if (fcast40ftHcQty[i] != null)
                    model.setFcast40ftHcQty(fcast40ftHcQty[i]);
                if (cfm45ftHcQty[i] != null)
                    model.setCfm45ftHcQty(cfm45ftHcQty[i]);
                if (subTrdCd[i] != null)
                    model.setSubTrdCd(subTrdCd[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (polSeq[i] != null)
                    model.setPolSeq(polSeq[i]);
                if (ctrlLvl[i] != null)
                    model.setCtrlLvl(ctrlLvl[i]);
                if (fcastCnt[i] != null)
                    model.setFcastCnt(fcastCnt[i]);
                if (fcastTtlTeuQty[i] != null)
                    model.setFcastTtlTeuQty(fcastTtlTeuQty[i]);
                if (cfmTtlQty[i] != null)
                    model.setCfmTtlQty(cfmTtlQty[i]);
                if (bkg20ftQty[i] != null)
                    model.setBkg20ftQty(bkg20ftQty[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (ctrlRf[i] != null)
                    model.setCtrlRf(ctrlRf[i]);
                if (fcastTtlQty[i] != null)
                    model.setFcastTtlQty(fcastTtlQty[i]);
                if (srepNm[i] != null)
                    model.setSrepNm(srepNm[i]);
                if (fcast53ftQty[i] != null)
                    model.setFcast53ftQty(fcast53ftQty[i]);
                if (fcast40ftHcRat[i] != null)
                    model.setFcast40ftHcRat(fcast40ftHcRat[i]);
                if (dirCd[i] != null)
                    model.setDirCd(dirCd[i]);
                if (fcastTtlWgt[i] != null)
                    model.setFcastTtlWgt(fcastTtlWgt[i]);
                if (rgnOfcCd[i] != null)
                    model.setRgnOfcCd(rgnOfcCd[i]);
                if (custTpCd[i] != null)
                    model.setCustTpCd(custTpCd[i]);
                if (iocTsCd[i] != null)
                    model.setIocTsCd(iocTsCd[i]);
                if (cfmTtlWgt[i] != null)
                    model.setCfmTtlWgt(cfmTtlWgt[i]);
                if (subOfcCd[i] != null)
                    model.setSubOfcCd(subOfcCd[i]);
                if (mstCnt[i] != null)
                    model.setMstCnt(mstCnt[i]);
                if (custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (ctrl45[i] != null)
                    model.setCtrl45(ctrl45[i]);
                if (fcast45ftHcQty[i] != null)
                    model.setFcast45ftHcQty(fcast45ftHcQty[i]);
                if (costYr[i] != null)
                    model.setCostYr(costYr[i]);
                if (bkg53ftQty[i] != null)
                    model.setBkg53ftQty(bkg53ftQty[i]);
                if (ctrlHc[i] != null)
                    model.setCtrlHc(ctrlHc[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchDailyForecastManageListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchDailyForecastManageListVO[]
	 */
    public SearchDailyForecastManageListVO[] getSearchDailyForecastManageListVOs() {
        SearchDailyForecastManageListVO[] vos = (SearchDailyForecastManageListVO[]) models.toArray(new SearchDailyForecastManageListVO[models.size()]);
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
        this.cfm40ftHcQty = this.cfm40ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfmRfQty = this.cfmRfQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lvl2 = this.lvl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepCd = this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrl53 = this.ctrl53.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkg45ftHcQty = this.bkg45ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lvl1 = this.lvl1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rnum = this.rnum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRfQty = this.bkgRfQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfm53ftQty = this.cfm53ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTtlQty = this.bkgTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCnt = this.bkgCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podSeq = this.podSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastRfQty = this.fcastRfQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTtlWgt = this.bkgTtlWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast45ftHcRat = this.fcast45ftHcRat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lvl = this.lvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chl = this.chl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costWk = this.costWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlWt = this.ctrlWt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkg40ftQty = this.bkg40ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkg40ftHcQty = this.bkg40ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast40ftHcQty = this.fcast40ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfm45ftHcQty = this.cfm45ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subTrdCd = this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polSeq = this.polSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlLvl = this.ctrlLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastCnt = this.fcastCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlTeuQty = this.fcastTtlTeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfmTtlQty = this.cfmTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkg20ftQty = this.bkg20ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlRf = this.ctrlRf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlQty = this.fcastTtlQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srepNm = this.srepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast53ftQty = this.fcast53ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast40ftHcRat = this.fcast40ftHcRat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcastTtlWgt = this.fcastTtlWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnOfcCd = this.rgnOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custTpCd = this.custTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iocTsCd = this.iocTsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfmTtlWgt = this.cfmTtlWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.subOfcCd = this.subOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mstCnt = this.mstCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrl45 = this.ctrl45.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fcast45ftHcQty = this.fcast45ftHcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costYr = this.costYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkg53ftQty = this.bkg53ftQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlHc = this.ctrlHc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustCntCd = this.ctrtCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustSeq = this.ctrtCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCustNm = this.ctrtCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
